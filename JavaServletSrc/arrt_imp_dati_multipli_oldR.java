// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_imp_dati_multipli_oldR implements CallerWithObjs {
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
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_tbvalute;
  public String m_cServer_tbvalute;
  public String m_cPhName_xraziobo;
  public String m_cServer_xraziobo;
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_imp_info;
  public String m_cServer_imp_info;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
  public String m_cPhName_xapopebo;
  public String m_cServer_xapopebo;
  public String m_cPhName_soginfo;
  public String m_cServer_soginfo;
  public String m_cPhName_xoginfo;
  public String m_cServer_xoginfo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_imp_opefra;
  public String m_cServer_imp_opefra;
  public String m_cPhName_tbcauana;
  public String m_cServer_tbcauana;
  public String m_cPhName_xnarapbo;
  public String m_cServer_xnarapbo;
  public String m_cPhName_xntestbo;
  public String m_cServer_xntestbo;
  public String m_cPhName_xperazbo;
  public String m_cServer_xperazbo;
  public String m_cPhName_jnarapbo;
  public String m_cServer_jnarapbo;
  public String m_cPhName_japopebo;
  public String m_cServer_japopebo;
  public String m_cPhName_joginfo;
  public String m_cServer_joginfo;
  public String m_cPhName_jntestbo;
  public String m_cServer_jntestbo;
  public String m_cPhName_jperazbo;
  public String m_cServer_jperazbo;
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_xelegabo;
  public String m_cServer_xelegabo;
  public String m_cPhName_delegabo;
  public String m_cServer_delegabo;
  public String m_cPhName_titopers;
  public String m_cServer_titopers;
  public String m_cPhName_jelegabo;
  public String m_cServer_jelegabo;
  public String m_cPhName_titolabo;
  public String m_cServer_titolabo;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public String m_cPhName_tmp_list_imprich;
  public String m_cServer_tmp_list_imprich;
  public String m_cPhName_sogopebo;
  public String m_cServer_sogopebo;
  public String m_cPhName_sogopefbo;
  public String m_cServer_sogopefbo;
  public String m_cPhName_xogopefbo;
  public String m_cServer_xogopefbo;
  public String m_cPhName_xogopebo;
  public String m_cServer_xogopebo;
  public String m_cPhName_jraziobo;
  public String m_cServer_jraziobo;
  public String m_cPhName_jogopefbo;
  public String m_cServer_jogopefbo;
  public String m_cPhName_jogopebo;
  public String m_cServer_jogopebo;
  public String m_cPhName_jitopers;
  public String m_cServer_jitopers;
  String m_cServer;
  String m_cPhName;
  String m_cQuery;
  String m_cQueryTable;
  String m_cSql;
  java.util.List<String> m_oParameters;
  String m_cWhere;
  int m_nUpdatedRows;
  // Contiene il messaggio di errore dell'ultima select terminata a causa della caduta della connessione
  String m_cConnectivityError;
  public String w_tipodest;
  public String w_msgproc;
  public double w_impzip;
  public String fhand;
  public String riga;
  public String xConnes;
  public String xCF;
  public String xCodCab;
  public String xCitta;
  public String cCliProg;
  public String cInfProg1;
  public String cInfProg2;
  public String cOpeProg1;
  public String cOpeProg2;
  public String xSesso;
  public String xRapporto;
  public String xCAB;
  public String xDIP;
  public String xDIPx;
  public String cCli1;
  public String xIDB;
  public String xData;
  public String xDatF;
  public double cNumNew;
  public double cNumMod;
  public String cFlagLire;
  public String cFlagCont;
  public String cFlagFraz;
  public double cMaxRow;
  public String cIdCau;
  public double xCFE;
  public double conta;
  public double _esito;
  public String cSNAS;
  public String cCNAS;
  public String uniquecode;
  public double _salta;
  public double _allineamento;
  public double _allineatonomecnome;
  public String _ragsocold;
  public String _cabold;
  public double nProgImp;
  public String ciidbase;
  public java.sql.Date cidataini;
  public java.sql.Date cidatafine;
  public String cicodinter;
  public String cinumprog;
  public String citiporap;
  public String czipfile;
  public String cpercorsozip;
  public String cdirectoryfile;
  public String buffernomefile;
  public String nomefileimport;
  public double _priorita;
  public String gPathApp;
  public String gAzienda;
  public String gMsgImp;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_imp_dati_multipli_old
  public String[] lista;
  public int conteggio;
  public int i;
  public int contanome;
  // * --- Fine Area Manuale
  public arrt_imp_dati_multipli_oldR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_imp_dati_multipli_old",m_Caller);
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_cPhName_tbvalute = p_ContextObject.GetPhName("tbvalute");
    m_cServer_tbvalute = p_ContextObject.GetServer("tbvalute");
    m_cPhName_xraziobo = p_ContextObject.GetPhName("xraziobo");
    m_cServer_xraziobo = p_ContextObject.GetServer("xraziobo");
    m_cPhName_fraziobo = p_ContextObject.GetPhName("fraziobo");
    m_cServer_fraziobo = p_ContextObject.GetServer("fraziobo");
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    if (m_Ctx.IsTmpAlreadyCreated("imp_info")) {
      m_cPhName_imp_info = p_ContextObject.GetPhName("imp_info");
      m_cServer_imp_info = p_ContextObject.GetServer("imp_info");
    }
    m_cPhName_rapopebo = p_ContextObject.GetPhName("rapopebo");
    m_cServer_rapopebo = p_ContextObject.GetServer("rapopebo");
    m_cPhName_xapopebo = p_ContextObject.GetPhName("xapopebo");
    m_cServer_xapopebo = p_ContextObject.GetServer("xapopebo");
    m_cPhName_soginfo = p_ContextObject.GetPhName("soginfo");
    m_cServer_soginfo = p_ContextObject.GetServer("soginfo");
    m_cPhName_xoginfo = p_ContextObject.GetPhName("xoginfo");
    m_cServer_xoginfo = p_ContextObject.GetServer("xoginfo");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    if (m_Ctx.IsTmpAlreadyCreated("imp_opefra")) {
      m_cPhName_imp_opefra = p_ContextObject.GetPhName("imp_opefra");
      m_cServer_imp_opefra = p_ContextObject.GetServer("imp_opefra");
    }
    m_cPhName_tbcauana = p_ContextObject.GetPhName("tbcauana");
    m_cServer_tbcauana = p_ContextObject.GetServer("tbcauana");
    m_cPhName_xnarapbo = p_ContextObject.GetPhName("xnarapbo");
    m_cServer_xnarapbo = p_ContextObject.GetServer("xnarapbo");
    m_cPhName_xntestbo = p_ContextObject.GetPhName("xntestbo");
    m_cServer_xntestbo = p_ContextObject.GetServer("xntestbo");
    m_cPhName_xperazbo = p_ContextObject.GetPhName("xperazbo");
    m_cServer_xperazbo = p_ContextObject.GetServer("xperazbo");
    m_cPhName_jnarapbo = p_ContextObject.GetPhName("jnarapbo");
    m_cServer_jnarapbo = p_ContextObject.GetServer("jnarapbo");
    m_cPhName_japopebo = p_ContextObject.GetPhName("japopebo");
    m_cServer_japopebo = p_ContextObject.GetServer("japopebo");
    m_cPhName_joginfo = p_ContextObject.GetPhName("joginfo");
    m_cServer_joginfo = p_ContextObject.GetServer("joginfo");
    m_cPhName_jntestbo = p_ContextObject.GetPhName("jntestbo");
    m_cServer_jntestbo = p_ContextObject.GetServer("jntestbo");
    m_cPhName_jperazbo = p_ContextObject.GetPhName("jperazbo");
    m_cServer_jperazbo = p_ContextObject.GetServer("jperazbo");
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_cPhName_opextrbo = p_ContextObject.GetPhName("opextrbo");
    m_cServer_opextrbo = p_ContextObject.GetServer("opextrbo");
    m_cPhName_xelegabo = p_ContextObject.GetPhName("xelegabo");
    m_cServer_xelegabo = p_ContextObject.GetServer("xelegabo");
    m_cPhName_delegabo = p_ContextObject.GetPhName("delegabo");
    m_cServer_delegabo = p_ContextObject.GetServer("delegabo");
    m_cPhName_titopers = p_ContextObject.GetPhName("titopers");
    m_cServer_titopers = p_ContextObject.GetServer("titopers");
    m_cPhName_jelegabo = p_ContextObject.GetPhName("jelegabo");
    m_cServer_jelegabo = p_ContextObject.GetServer("jelegabo");
    m_cPhName_titolabo = p_ContextObject.GetPhName("titolabo");
    m_cServer_titolabo = p_ContextObject.GetServer("titolabo");
    m_cPhName_tbcitta = p_ContextObject.GetPhName("tbcitta");
    m_cServer_tbcitta = p_ContextObject.GetServer("tbcitta");
    m_cPhName_tmp_list_imprich = p_ContextObject.GetPhName("tmp_list_imprich");
    m_cServer_tmp_list_imprich = p_ContextObject.GetServer("tmp_list_imprich");
    m_cPhName_sogopebo = p_ContextObject.GetPhName("sogopebo");
    m_cServer_sogopebo = p_ContextObject.GetServer("sogopebo");
    m_cPhName_sogopefbo = p_ContextObject.GetPhName("sogopefbo");
    m_cServer_sogopefbo = p_ContextObject.GetServer("sogopefbo");
    m_cPhName_xogopefbo = p_ContextObject.GetPhName("xogopefbo");
    m_cServer_xogopefbo = p_ContextObject.GetServer("xogopefbo");
    m_cPhName_xogopebo = p_ContextObject.GetPhName("xogopebo");
    m_cServer_xogopebo = p_ContextObject.GetServer("xogopebo");
    m_cPhName_jraziobo = p_ContextObject.GetPhName("jraziobo");
    m_cServer_jraziobo = p_ContextObject.GetServer("jraziobo");
    m_cPhName_jogopefbo = p_ContextObject.GetPhName("jogopefbo");
    m_cServer_jogopefbo = p_ContextObject.GetServer("jogopefbo");
    m_cPhName_jogopebo = p_ContextObject.GetPhName("jogopebo");
    m_cServer_jogopebo = p_ContextObject.GetServer("jogopebo");
    m_cPhName_jitopers = p_ContextObject.GetPhName("jitopers");
    m_cServer_jitopers = p_ContextObject.GetServer("jitopers");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("impzip",p_cVarName)) {
      return w_impzip;
    }
    if (CPLib.eqr("cNumNew",p_cVarName)) {
      return cNumNew;
    }
    if (CPLib.eqr("cNumMod",p_cVarName)) {
      return cNumMod;
    }
    if (CPLib.eqr("cMaxRow",p_cVarName)) {
      return cMaxRow;
    }
    if (CPLib.eqr("xCFE",p_cVarName)) {
      return xCFE;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      return conta;
    }
    if (CPLib.eqr("_esito",p_cVarName)) {
      return _esito;
    }
    if (CPLib.eqr("_salta",p_cVarName)) {
      return _salta;
    }
    if (CPLib.eqr("_allineamento",p_cVarName)) {
      return _allineamento;
    }
    if (CPLib.eqr("_allineatonomecnome",p_cVarName)) {
      return _allineatonomecnome;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      return nProgImp;
    }
    if (CPLib.eqr("_priorita",p_cVarName)) {
      return _priorita;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_imp_dati_multipli_old";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("tipodest",p_cVarName)) {
      return w_tipodest;
    }
    if (CPLib.eqr("msgproc",p_cVarName)) {
      return w_msgproc;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      return riga;
    }
    if (CPLib.eqr("xConnes",p_cVarName)) {
      return xConnes;
    }
    if (CPLib.eqr("xCF",p_cVarName)) {
      return xCF;
    }
    if (CPLib.eqr("xCodCab",p_cVarName)) {
      return xCodCab;
    }
    if (CPLib.eqr("xCitta",p_cVarName)) {
      return xCitta;
    }
    if (CPLib.eqr("cCliProg",p_cVarName)) {
      return cCliProg;
    }
    if (CPLib.eqr("cInfProg1",p_cVarName)) {
      return cInfProg1;
    }
    if (CPLib.eqr("cInfProg2",p_cVarName)) {
      return cInfProg2;
    }
    if (CPLib.eqr("cOpeProg1",p_cVarName)) {
      return cOpeProg1;
    }
    if (CPLib.eqr("cOpeProg2",p_cVarName)) {
      return cOpeProg2;
    }
    if (CPLib.eqr("xSesso",p_cVarName)) {
      return xSesso;
    }
    if (CPLib.eqr("xRapporto",p_cVarName)) {
      return xRapporto;
    }
    if (CPLib.eqr("xCAB",p_cVarName)) {
      return xCAB;
    }
    if (CPLib.eqr("xDIP",p_cVarName)) {
      return xDIP;
    }
    if (CPLib.eqr("xDIPx",p_cVarName)) {
      return xDIPx;
    }
    if (CPLib.eqr("cCli1",p_cVarName)) {
      return cCli1;
    }
    if (CPLib.eqr("xIDB",p_cVarName)) {
      return xIDB;
    }
    if (CPLib.eqr("xData",p_cVarName)) {
      return xData;
    }
    if (CPLib.eqr("xDatF",p_cVarName)) {
      return xDatF;
    }
    if (CPLib.eqr("cFlagLire",p_cVarName)) {
      return cFlagLire;
    }
    if (CPLib.eqr("cFlagCont",p_cVarName)) {
      return cFlagCont;
    }
    if (CPLib.eqr("cFlagFraz",p_cVarName)) {
      return cFlagFraz;
    }
    if (CPLib.eqr("cIdCau",p_cVarName)) {
      return cIdCau;
    }
    if (CPLib.eqr("cSNAS",p_cVarName)) {
      return cSNAS;
    }
    if (CPLib.eqr("cCNAS",p_cVarName)) {
      return cCNAS;
    }
    if (CPLib.eqr("uniquecode",p_cVarName)) {
      return uniquecode;
    }
    if (CPLib.eqr("_ragsocold",p_cVarName)) {
      return _ragsocold;
    }
    if (CPLib.eqr("_cabold",p_cVarName)) {
      return _cabold;
    }
    if (CPLib.eqr("ciidbase",p_cVarName)) {
      return ciidbase;
    }
    if (CPLib.eqr("cicodinter",p_cVarName)) {
      return cicodinter;
    }
    if (CPLib.eqr("cinumprog",p_cVarName)) {
      return cinumprog;
    }
    if (CPLib.eqr("citiporap",p_cVarName)) {
      return citiporap;
    }
    if (CPLib.eqr("czipfile",p_cVarName)) {
      return czipfile;
    }
    if (CPLib.eqr("cpercorsozip",p_cVarName)) {
      return cpercorsozip;
    }
    if (CPLib.eqr("cdirectoryfile",p_cVarName)) {
      return cdirectoryfile;
    }
    if (CPLib.eqr("buffernomefile",p_cVarName)) {
      return buffernomefile;
    }
    if (CPLib.eqr("nomefileimport",p_cVarName)) {
      return nomefileimport;
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
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("cidataini",p_cVarName)) {
      return cidataini;
    }
    if (CPLib.eqr("cidatafine",p_cVarName)) {
      return cidatafine;
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
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("impzip",p_cVarName)) {
      w_impzip = value;
      return;
    }
    if (CPLib.eqr("cNumNew",p_cVarName)) {
      cNumNew = value;
      return;
    }
    if (CPLib.eqr("cNumMod",p_cVarName)) {
      cNumMod = value;
      return;
    }
    if (CPLib.eqr("cMaxRow",p_cVarName)) {
      cMaxRow = value;
      return;
    }
    if (CPLib.eqr("xCFE",p_cVarName)) {
      xCFE = value;
      return;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      conta = value;
      return;
    }
    if (CPLib.eqr("_esito",p_cVarName)) {
      _esito = value;
      return;
    }
    if (CPLib.eqr("_salta",p_cVarName)) {
      _salta = value;
      return;
    }
    if (CPLib.eqr("_allineamento",p_cVarName)) {
      _allineamento = value;
      return;
    }
    if (CPLib.eqr("_allineatonomecnome",p_cVarName)) {
      _allineatonomecnome = value;
      return;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      nProgImp = value;
      return;
    }
    if (CPLib.eqr("_priorita",p_cVarName)) {
      _priorita = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("tipodest",p_cVarName)) {
      w_tipodest = value;
      return;
    }
    if (CPLib.eqr("msgproc",p_cVarName)) {
      w_msgproc = value;
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
    if (CPLib.eqr("xConnes",p_cVarName)) {
      xConnes = value;
      return;
    }
    if (CPLib.eqr("xCF",p_cVarName)) {
      xCF = value;
      return;
    }
    if (CPLib.eqr("xCodCab",p_cVarName)) {
      xCodCab = value;
      return;
    }
    if (CPLib.eqr("xCitta",p_cVarName)) {
      xCitta = value;
      return;
    }
    if (CPLib.eqr("cCliProg",p_cVarName)) {
      cCliProg = value;
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
    if (CPLib.eqr("cOpeProg1",p_cVarName)) {
      cOpeProg1 = value;
      return;
    }
    if (CPLib.eqr("cOpeProg2",p_cVarName)) {
      cOpeProg2 = value;
      return;
    }
    if (CPLib.eqr("xSesso",p_cVarName)) {
      xSesso = value;
      return;
    }
    if (CPLib.eqr("xRapporto",p_cVarName)) {
      xRapporto = value;
      return;
    }
    if (CPLib.eqr("xCAB",p_cVarName)) {
      xCAB = value;
      return;
    }
    if (CPLib.eqr("xDIP",p_cVarName)) {
      xDIP = value;
      return;
    }
    if (CPLib.eqr("xDIPx",p_cVarName)) {
      xDIPx = value;
      return;
    }
    if (CPLib.eqr("cCli1",p_cVarName)) {
      cCli1 = value;
      return;
    }
    if (CPLib.eqr("xIDB",p_cVarName)) {
      xIDB = value;
      return;
    }
    if (CPLib.eqr("xData",p_cVarName)) {
      xData = value;
      return;
    }
    if (CPLib.eqr("xDatF",p_cVarName)) {
      xDatF = value;
      return;
    }
    if (CPLib.eqr("cFlagLire",p_cVarName)) {
      cFlagLire = value;
      return;
    }
    if (CPLib.eqr("cFlagCont",p_cVarName)) {
      cFlagCont = value;
      return;
    }
    if (CPLib.eqr("cFlagFraz",p_cVarName)) {
      cFlagFraz = value;
      return;
    }
    if (CPLib.eqr("cIdCau",p_cVarName)) {
      cIdCau = value;
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
    if (CPLib.eqr("uniquecode",p_cVarName)) {
      uniquecode = value;
      return;
    }
    if (CPLib.eqr("_ragsocold",p_cVarName)) {
      _ragsocold = value;
      return;
    }
    if (CPLib.eqr("_cabold",p_cVarName)) {
      _cabold = value;
      return;
    }
    if (CPLib.eqr("ciidbase",p_cVarName)) {
      ciidbase = value;
      return;
    }
    if (CPLib.eqr("cicodinter",p_cVarName)) {
      cicodinter = value;
      return;
    }
    if (CPLib.eqr("cinumprog",p_cVarName)) {
      cinumprog = value;
      return;
    }
    if (CPLib.eqr("citiporap",p_cVarName)) {
      citiporap = value;
      return;
    }
    if (CPLib.eqr("czipfile",p_cVarName)) {
      czipfile = value;
      return;
    }
    if (CPLib.eqr("cpercorsozip",p_cVarName)) {
      cpercorsozip = value;
      return;
    }
    if (CPLib.eqr("cdirectoryfile",p_cVarName)) {
      cdirectoryfile = value;
      return;
    }
    if (CPLib.eqr("buffernomefile",p_cVarName)) {
      buffernomefile = value;
      return;
    }
    if (CPLib.eqr("nomefileimport",p_cVarName)) {
      nomefileimport = value;
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
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("cidataini",p_cVarName)) {
      cidataini = value;
      return;
    }
    if (CPLib.eqr("cidatafine",p_cVarName)) {
      cidatafine = value;
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
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_tmp_list_imprich=null;
    try {
      /* Dichiarazione variabili del caller */
      /* w_tipodest Char(1) */
      /* w_msgproc Memo */
      /* w_impzip Numeric(1, 0) */
      /* Definizione variabili locali */
      /* fhand Char(1) */
      /* riga Memo */
      /* xConnes Char(16) */
      /* xCF Char(16) */
      /* xCodCab Char(6) */
      /* xCitta Char(30) */
      /* cCliProg Char(6) */
      /* cInfProg1 Char(10) */
      /* cInfProg2 Char(11) */
      /* cOpeProg1 Char(10) */
      /* cOpeProg2 Char(11) */
      /* xSesso Char(1) */
      /* xRapporto Char(25) */
      /* xCAB Char(6) */
      /* xDIP Char(6) */
      /* xDIPx Char(6) */
      /* cCli1 Char(16) */
      /* xIDB Char(10) */
      /* xData Char(8) */
      /* xDatF Char(8) */
      /* cNumNew Numeric(10, 0) */
      /* cNumMod Numeric(10, 0) */
      /* cFlagLire Char(1) */
      /* cFlagCont Char(1) */
      /* cFlagFraz Char(1) */
      /* cMaxRow Numeric(3, 0) */
      /* cIdCau Char(4) */
      /* xCFE Numeric(1, 0) */
      /* conta Numeric(10, 0) */
      /* _esito Numeric(1, 0) */
      /* cSNAS Char(30) */
      /* cCNAS Char(30) */
      /* uniquecode Char(10) */
      /* _salta Numeric(1, 0) */
      /* _allineamento Numeric(1, 0) */
      /* _allineatonomecnome Numeric(1, 0) */
      /* _ragsocold Char(70) */
      /* _cabold Char(6) */
      /* nProgImp Numeric(15, 0) */
      /* ciidbase Char(10) */
      /* cidataini Date */
      /* cidatafine Date */
      /* cicodinter Char(12) */
      /* cinumprog Char(11) */
      /* citiporap Char(1) */
      /* czipfile Char(100) */
      /* cpercorsozip Char(200) */
      /* cdirectoryfile Char(200) */
      /* buffernomefile Char(100) */
      /* nomefileimport Char(50) */
      /* _priorita Numeric(3, 0) */
      /* gPathApp Char(80) // Path Applicazione */
      /* gAzienda Char(10) // Azienda */
      /* gMsgImp Char(60) // Messaggio Import */
      /* Import Soggetti */
      /* w_msgproc := '' */
      w_msgproc = "";
      /* Cicla sul file della lista e lancia la pagina appropriata */
      /* _esito := 0 */
      _esito = CPLib.Round(0,0);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry07C0AA10status;
      nTry07C0AA10status = m_Sql.GetTransactionStatus();
      String cTry07C0AA10msg;
      cTry07C0AA10msg = m_Sql.TransactionErrorMessage();
      try {
        /* If w_impzip=1 */
        if (CPLib.eqr(w_impzip,1)) {
          /* Exec "Estrai zip" Page 27 */
          Page_27();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          // * --- Select from tmp_list_imprich
          m_cServer = m_Ctx.GetServer("tmp_list_imprich");
          m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
          if (Cursor_tmp_list_imprich!=null)
            Cursor_tmp_list_imprich.Close();
          Cursor_tmp_list_imprich = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_list_imprich")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1")+" order by "+"priorita,nomefile ",m_cServer,m_Ctx,true));
          while ( ! (Cursor_tmp_list_imprich.Eof())) {
            /* If _esito = 0 */
            if (CPLib.eqr(_esito,0)) {
              /* nomefileimport := Lower(LRTrim(tmp_list_imprich->nomefile)) */
              nomefileimport = CPLib.Lower(CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile")));
              /* Case Substr(nomefileimport,3)='archpers.txt' */
              if (CPLib.eqr(CPLib.Substr(nomefileimport,3),"archpers.txt")) {
                /* Exec "Soggetti" Page 2 */
                Page_2();
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
                /* Case Substr(nomefileimport,3)='archdip.txt' */
              } else if (CPLib.eqr(CPLib.Substr(nomefileimport,3),"archdip.txt")) {
                /* Exec "Dipendenze" Page 14 */
                Page_14();
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
                /* Case Substr(nomefileimport,3)='titola.txt' */
              } else if (CPLib.eqr(CPLib.Substr(nomefileimport,3),"titola.txt")) {
                /* Exec "Titolari Effettivi" Page 15 */
                Page_15();
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
                /* Case Substr(nomefileimport,3)='titocont.txt' */
              } else if (CPLib.eqr(CPLib.Substr(nomefileimport,3),"titocont.txt")) {
                /* Exec "Soggetti Controllati" Page 26 */
                Page_26();
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
                /* Case Substr(nomefileimport,3)='archrap.txt' */
              } else if (CPLib.eqr(CPLib.Substr(nomefileimport,3),"archrap.txt")) {
                /* If w_tipodest = 'P' */
                if (CPLib.eqr(w_tipodest,"P")) {
                  /* Exec "Rapporti Provvisorio" Page 7 */
                  Page_7();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                } else { // Else
                  /* Exec "Rapporti" Page 3 */
                  Page_3();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                } // End If
                /* Case Substr(nomefileimport,3)='archinf.txt' */
              } else if (CPLib.eqr(CPLib.Substr(nomefileimport,3),"archinf.txt")) {
                /* If w_tipodest = 'P' */
                if (CPLib.eqr(w_tipodest,"P")) {
                  /* Exec "Informazioni Provvisorio" Page 8 */
                  Page_8();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                } else { // Else
                  /* Exec "Informazioni" Page 4 */
                  Page_4();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                } // End If
                /* Case Substr(nomefileimport,3)='archope.txt' */
              } else if (CPLib.eqr(CPLib.Substr(nomefileimport,3),"archope.txt")) {
                /* If w_tipodest = 'P' */
                if (CPLib.eqr(w_tipodest,"P")) {
                  /* Exec "Operazioni Provvisorio" Page 9 */
                  Page_9();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                } else { // Else
                  /* Exec "Operazioni" Page 5 */
                  Page_5();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                } // End If
                /* Case Substr(nomefileimport,3)='archfraz.txt' */
              } else if (CPLib.eqr(CPLib.Substr(nomefileimport,3),"archfraz.txt")) {
                /* If w_tipodest = 'P' */
                if (CPLib.eqr(w_tipodest,"P")) {
                  /* Exec "Frazionarie Provvisorio" Page 10 */
                  Page_10();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                } else { // Else
                  /* Exec "Frazionate" Page 6 */
                  Page_6();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                } // End If
                /* Case Substr(nomefileimport,3)='intest.txt' */
              } else if (CPLib.eqr(CPLib.Substr(nomefileimport,3),"intest.txt")) {
                /* If w_tipodest = 'P' */
                if (CPLib.eqr(w_tipodest,"P")) {
                  /* Exec "Intestatari" Page 19 */
                  Page_19();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                } else { // Else
                  /* Exec "Intestatari Provvisorio" Page 22 */
                  Page_22();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                } // End If
                /* Case Substr(nomefileimport,3)='rapage.txt' */
              } else if (CPLib.eqr(CPLib.Substr(nomefileimport,3),"rapage.txt")) {
                /* Exec "Rapporti Agenzia Entrate" Page 11 */
                Page_11();
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
                /* Case Substr(nomefileimport,3)='infage.txt' */
              } else if (CPLib.eqr(CPLib.Substr(nomefileimport,3),"infage.txt")) {
                /* Exec "Informazioni Agenzia Entrate" Page 12 */
                Page_12();
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
                /* Case Substr(nomefileimport,3)='opeage.txt' */
              } else if (CPLib.eqr(CPLib.Substr(nomefileimport,3),"opeage.txt")) {
                /* Exec "Operazioni Agenzia Entrate" Page 13 */
                Page_13();
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
                /* Case Substr(nomefileimport,3)='opex.txt' */
              } else if (CPLib.eqr(CPLib.Substr(nomefileimport,3),"opex.txt")) {
                /* Exec "Operazioni extraconto" Page 16 */
                Page_16();
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
                /* Case Substr(nomefileimport,3)='procdel.txt' */
              } else if (CPLib.eqr(CPLib.Substr(nomefileimport,3),"procdel.txt")) {
                /* If w_tipodest = 'P' */
                if (CPLib.eqr(w_tipodest,"P")) {
                  /* Exec "Procuratori/delegati su rapporto" Page 17 */
                  Page_17();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                } else { // Else
                  /* Exec "Procuratori/delegati su rapporto Provvisorio" Page 20 */
                  Page_20();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                } // End If
                /* Case Substr(nomefileimport,3)='procage.txt' */
              } else if (CPLib.eqr(CPLib.Substr(nomefileimport,3),"procage.txt")) {
                /* Exec "Procuratori/delegati su rapporto Agenzia Entrate" Page 23 */
                Page_23();
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
                /* Case Substr(nomefileimport,3)='sogope.txt' */
              } else if (CPLib.eqr(CPLib.Substr(nomefileimport,3),"sogope.txt")) {
                /* If w_tipodest = 'P' */
                if (CPLib.eqr(w_tipodest,"P")) {
                  /* Exec "Soggetti operanti" Page 18 */
                  Page_18();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                } else { // Else
                  /* Exec "Soggetti operanti Provvisorio" Page 21 */
                  Page_21();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                } // End If
                /* Case Substr(nomefileimport,3)='sogage.txt' */
              } else if (CPLib.eqr(CPLib.Substr(nomefileimport,3),"sogage.txt")) {
                /* Exec "Soggetti operanti Agenzia Entrate" Page 24 */
                Page_24();
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
                /* Case Substr(nomefileimport,3)='intage.txt' */
              } else if (CPLib.eqr(CPLib.Substr(nomefileimport,3),"intage.txt")) {
                /* Exec "Intestatari Agenzia Entrate" Page 25 */
                Page_25();
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
              } // End Case
            } // End If
            // * --- Delete from tmp_list_imprich
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_list_imprich");
            m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = "delete from "+m_cPhName;
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"nomefile = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_list_imprich.GetString("nomefile"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_list_imprich.GetString("nomefile"))+"";
            if (m_Ctx.IsSharedTemp("tmp_list_imprich")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
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
            Cursor_tmp_list_imprich.Next();
          }
          m_cConnectivityError = Cursor_tmp_list_imprich.ErrorMessage();
          Cursor_tmp_list_imprich.Close();
          // * --- End Select
        } // End If
        /* If _esito=0 */
        if (CPLib.eqr(_esito,0)) {
          // Commit
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          m_Sql.CompleteTransaction();
        } else { // Else
          // Rollback
          m_Sql.AbortTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          m_bError = true;
          m_Sql.CompleteTransaction();
        } // End If
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
        /* w_msgproc := w_msgproc + "Rilevati errori nell'impotazione dei file! Ricreare il file segnalato e rieseguire l'import dei dati. La procedura annullera automaticamente l'importazione" + NL */
        w_msgproc = w_msgproc+"Rilevati errori nell'impotazione dei file! Ricreare il file segnalato e rieseguire l'import dei dati. La procedura annullera automaticamente l'importazione"+"\n";
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry07C0AA10status,0)) {
          m_Sql.SetTransactionStatus(nTry07C0AA10status,cTry07C0AA10msg);
        }
      }
    } finally {
      try {
        if (Cursor_tmp_list_imprich!=null)
          Cursor_tmp_list_imprich.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* Legge il file di testo e porta i dati nella tabella */
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      /* cNumMod := 0 */
      cNumMod = CPLib.Round(0,0);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      /* w_msgproc := w_msgproc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + 'del file' + nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"del file"+nomefileimport+"\n";
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        /* If Len(LRTrim(riga)) > 0 */
        if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
          /* conta := conta + 1 */
          conta = CPLib.Round(conta+1,0);
          /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' nominativi del file'+nomefileimport // Messaggio Import */
          gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" nominativi del file"+nomefileimport;
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* cCli1 := Substr(riga,112,16) */
          cCli1 = CPLib.Substr(riga,112,16);
          /* xConnes := '' */
          xConnes = "";
          /* _ragsocold := '' */
          _ragsocold = "";
          /* _allineamento := 0 */
          _allineamento = CPLib.Round(0,0);
          /* _allineatonomecnome := 0 */
          _allineatonomecnome = CPLib.Round(0,0);
          /* xCF := Substr(riga,112,16) */
          xCF = CPLib.Substr(riga,112,16);
          /* Prima la Read si faceva per CF */
          // * --- Read from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          m_cSql = "";
          m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(cCli1,"C",16,0,m_cServer),m_cServer,cCli1);
          if (m_Ctx.IsSharedTemp("personbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            xConnes = Read_Cursor.GetString("CONNES");
            _ragsocold = Read_Cursor.GetString("RAGSOCOLD");
            _allineamento = CPLib.Round(Read_Cursor.GetDouble("ALLINEATO"),0);
            _allineatonomecnome = CPLib.Round(Read_Cursor.GetDouble("ALLINEATONOMECNOME"),0);
            _cabold = Read_Cursor.GetString("CODCAB");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on personbo into routine arrt_imp_dati_multipli_old returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            xConnes = "";
            _ragsocold = "";
            _allineamento = 0;
            _allineatonomecnome = 0;
            _cabold = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* xSesso := iif(Substr(riga,288,1)='M','1',iif(Substr(riga,288,1)='F','2',Substr(riga,288,1))) */
          xSesso = (CPLib.eqr(CPLib.Substr(riga,288,1),"M")?"1":(CPLib.eqr(CPLib.Substr(riga,288,1),"F")?"2":CPLib.Substr(riga,288,1)));
          /* If Substr(riga,450,1)='0' or Substr(riga,450,1)='1' or Substr(riga,450,1) = '' */
          if (CPLib.eqr(CPLib.Substr(riga,450,1),"0") || CPLib.eqr(CPLib.Substr(riga,450,1),"1") || CPLib.eqr(CPLib.Substr(riga,450,1),"")) {
            /* xCFE := iif(Substr(riga,450,1)='',0,Val(Substr(riga,450,1))) */
            xCFE = CPLib.Round((CPLib.eqr(CPLib.Substr(riga,450,1),"")?0:CPLib.Val(CPLib.Substr(riga,450,1))),0);
            /* ElseIf Substr(riga,450,1)='N' or Substr(riga,450,1)='S' */
          } else if (CPLib.eqr(CPLib.Substr(riga,450,1),"N") || CPLib.eqr(CPLib.Substr(riga,450,1),"S")) {
            /* xCFE := iif(Substr(riga,450,1)='N',0,1) */
            xCFE = CPLib.Round((CPLib.eqr(CPLib.Substr(riga,450,1),"N")?0:1),0);
          } // End If
          /* xCodCab := Substr(riga,1,6) */
          xCodCab = CPLib.Substr(riga,1,6);
          /* If Empty(LRTrim(xCodCab)) */
          if (CPLib.Empty(CPLib.LRTrim(xCodCab))) {
            /* xCitta := Substr(riga,230,30) */
            xCitta = CPLib.Substr(riga,230,30);
            // * --- Read from tbcitta
            m_cServer = m_Ctx.GetServer("tbcitta");
            m_cPhName = m_Ctx.GetPhName("tbcitta");
            m_cSql = "";
            m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(xCitta,"C",40,0,m_cServer),m_cServer,xCitta);
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
                Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_imp_dati_multipli_old returns two or more records. This item should return only a record.");
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
          /* cSNAS := '' */
          cSNAS = "";
          /* cCNAS := Substr(riga,136,30) */
          cCNAS = CPLib.Substr(riga,136,30);
          /* If (Substr(xCF,12,1) = 'Z' or Substr(riga,448,2)='EE') and Len(LRTrim(xCF))=16 */
          if ((CPLib.eqr(CPLib.Substr(xCF,12,1),"Z") || CPLib.eqr(CPLib.Substr(riga,448,2),"EE")) && CPLib.eqr(CPLib.Len(CPLib.LRTrim(xCF)),16)) {
            /* cSNAS := Substr(riga,136,30) */
            cSNAS = CPLib.Substr(riga,136,30);
            /* cCNAS := '' */
            cCNAS = "";
          } // End If
          /* Verifico se il soggetto in esame non è già presente ilo inserisco */
          /* If Empty(LRTrim(xConnes)) */
          if (CPLib.Empty(CPLib.LRTrim(xConnes))) {
            /* nProgImp := Utilities.GetAutonumber('PRGIMPOCLI',0,15) */
            nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOCLI",0,15),0);
            // * --- Insert into personbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.InsertIntoStatement(m_Ctx,"personbo")+" (";
            m_cSql = m_cSql+GetFieldsName_06F52090(m_Ctx);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cCli1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(xCodCab,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,7,70),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,77,35),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,112,16),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,132,4)+CPLib.Substr(riga,130,2)+CPLib.Substr(riga,128,2)),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cCNAS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,166,3),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,169,3),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,172,3),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,175,2),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,177,15),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,196,4)+CPLib.Substr(riga,194,2)+CPLib.Substr(riga,192,2)),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,200,30),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,230,30),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,260,2),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,262,3),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,265,9),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,274,14),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(xSesso,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,293,4)+CPLib.Substr(riga,291,2)+CPLib.Substr(riga,289,2)),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("P","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,297,26),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,323,25),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,348,100),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,448,2),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(xCFE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,451,4),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,455,5),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,460,10),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cSNAS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,7,70),"?",0,0,m_cServer)+", ";
            if (m_Ctx.IsSharedTemp("personbo")) {
              m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
            }
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo",true);
            m_cSql = m_cSql+")";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_nUpdatedRows = 0;
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.lt(m_nUpdatedRows,1)) {
              // No rows inserted
              /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per il soggetto: "+Substr(riga,7,70)+" con codice fiscale: "+Substr(riga,112,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
              w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per il soggetto: "+CPLib.Substr(riga,7,70)+" con codice fiscale: "+CPLib.Substr(riga,112,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
              /* _esito := 1 */
              _esito = CPLib.Round(1,0);
              // Exit Loop
              if (true) {
                break;
              }
            } else if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
              m_cLastMsgError = "Errore in inserimento ARCHPERS";
            }
            /* cNumNew := cNumNew + 1 */
            cNumNew = CPLib.Round(cNumNew+1,0);
          } else { // Else
            /* Verifico se il soggetto è una persona fisica */
            /* If Len(LRTrim(Substr(riga,112,16)))=16 */
            if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(CPLib.Substr(riga,112,16))),16)) {
              /* Verifico se è mai stato allineato e quale tipo di allineamento a subito */
              /* Case _allineatonomecnome=0 and _allineamento=0 */
              if (CPLib.eqr(_allineatonomecnome,0) && CPLib.eqr(_allineamento,0)) {
                /* Se il soggetto non è stato allineato con le procedure di allineamento sovrascrivo tutti i dati solo se la ragione sociale è diversa dalla precedente inserita */
                /* If not(_ragsocold=Substr(riga,7,70)) */
                if ( ! (CPLib.eqr(_ragsocold,CPLib.Substr(riga,7,70)))) {
                  // * --- Write into personbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = "Update "+m_cPhName+" set ";
                  m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(xCodCab,"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.Substr(riga,7,70),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(CPLib.Substr(riga,77,35),"C",35,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(CPLib.Substr(riga,112,16),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,132,4)+CPLib.Substr(riga,130,2)+CPLib.Substr(riga,128,2)),"D",8,0)+", ";
                  m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(cCNAS,"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(CPLib.Substr(riga,166,3),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(CPLib.Substr(riga,169,3),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(CPLib.Substr(riga,172,3),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(CPLib.Substr(riga,175,2),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(CPLib.Substr(riga,177,15),"C",15,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,196,4)+CPLib.Substr(riga,194,2)+CPLib.Substr(riga,192,2)),"D",8,0)+", ";
                  m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(CPLib.Substr(riga,200,30),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.Substr(riga,230,30),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(CPLib.Substr(riga,260,2),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(CPLib.Substr(riga,262,3),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(CPLib.Substr(riga,265,9),"C",9,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PARTIVA = "+CPLib.ToSQL(CPLib.Substr(riga,274,14),"C",14,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(xSesso,"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATAVALI = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,293,4)+CPLib.Substr(riga,291,2)+CPLib.Substr(riga,289,2)),"D",8,0)+", ";
                  m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(CPLib.Substr(riga,297,26),"C",26,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(CPLib.Substr(riga,323,25),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DOCFILE = "+CPLib.ToSQL(CPLib.Substr(riga,348,100),"C",100,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(CPLib.Substr(riga,448,2),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(xCFE,"N",1,0)+", ";
                  m_cSql = m_cSql+"PKTBSPECIE = "+CPLib.ToSQL(CPLib.Substr(riga,451,4),"C",4,0,m_cServer)+", ";
                  m_cSql = m_cSql+"COMPORT = "+CPLib.ToSQL(CPLib.Substr(riga,455,5),"C",5,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(CPLib.Substr(riga,460,10),"C",10,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(cSNAS,"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAGSOCOLD = "+CPLib.ToSQL(CPLib.Substr(riga,7,70),"C",70,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(xConnes,"?",0,0,m_cServer),m_cServer,xConnes)+"";
                  if (m_Ctx.IsSharedTemp("personbo")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  if (CPLib.lt(m_nUpdatedRows,0)) {
                    m_nUpdatedRows = 0;
                  }
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.lt(m_nUpdatedRows,1)) {
                    // No rows updated
                    /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per il soggetto: "+Substr(riga,7,70)+" con codice fiscale: "+Substr(riga,112,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                    w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per il soggetto: "+CPLib.Substr(riga,7,70)+" con codice fiscale: "+CPLib.Substr(riga,112,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                    /* _esito := 1 */
                    _esito = CPLib.Round(1,0);
                    // Exit Loop
                    if (true) {
                      break;
                    }
                  } else if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                    m_cLastMsgError = "Errore in aggiornamento ARCHPERS";
                  }
                  /* cNumMod := cNumMod + 1 */
                  cNumMod = CPLib.Round(cNumMod+1,0);
                } // End If
                /* Case _allineatonomecnome=1 and _allineamento=0 */
              } else if (CPLib.eqr(_allineatonomecnome,1) && CPLib.eqr(_allineamento,0)) {
                /* Verifico che la ragione sociale invertita _ragsochold sia uguale a quella importata altrimenti sovraschivo la vecchia e riabilito l'allineamento */
                /* If _ragsocold=Substr(riga,7,70) */
                if (CPLib.eqr(_ragsocold,CPLib.Substr(riga,7,70))) {
                  /* Sovrascrivo i dati del soggetto ad eccezione dalla ragione sociale, nome e cognome */
                  // * --- Write into personbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = "Update "+m_cPhName+" set ";
                  m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(xCodCab,"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(CPLib.Substr(riga,77,35),"C",35,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(CPLib.Substr(riga,112,16),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,132,4)+CPLib.Substr(riga,130,2)+CPLib.Substr(riga,128,2)),"D",8,0)+", ";
                  m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(cCNAS,"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(CPLib.Substr(riga,166,3),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(CPLib.Substr(riga,169,3),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(CPLib.Substr(riga,172,3),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(CPLib.Substr(riga,175,2),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(CPLib.Substr(riga,177,15),"C",15,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,196,4)+CPLib.Substr(riga,194,2)+CPLib.Substr(riga,192,2)),"D",8,0)+", ";
                  m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(CPLib.Substr(riga,200,30),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.Substr(riga,230,30),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(CPLib.Substr(riga,260,2),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(CPLib.Substr(riga,262,3),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(CPLib.Substr(riga,265,9),"C",9,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PARTIVA = "+CPLib.ToSQL(CPLib.Substr(riga,274,14),"C",14,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(xSesso,"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATAVALI = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,293,4)+CPLib.Substr(riga,291,2)+CPLib.Substr(riga,289,2)),"D",8,0)+", ";
                  m_cSql = m_cSql+"DOCFILE = "+CPLib.ToSQL(CPLib.Substr(riga,348,100),"C",100,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(CPLib.Substr(riga,448,2),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(xCFE,"N",1,0)+", ";
                  m_cSql = m_cSql+"PKTBSPECIE = "+CPLib.ToSQL(CPLib.Substr(riga,451,4),"C",4,0,m_cServer)+", ";
                  m_cSql = m_cSql+"COMPORT = "+CPLib.ToSQL(CPLib.Substr(riga,455,5),"C",5,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(CPLib.Substr(riga,460,10),"C",10,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(cSNAS,"C",30,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(xConnes,"?",0,0,m_cServer),m_cServer,xConnes)+"";
                  if (m_Ctx.IsSharedTemp("personbo")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  if (CPLib.lt(m_nUpdatedRows,0)) {
                    m_nUpdatedRows = 0;
                  }
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.lt(m_nUpdatedRows,1)) {
                    // No rows updated
                    /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per il soggetto: "+Substr(riga,7,70)+" con codice fiscale: "+Substr(riga,112,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                    w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per il soggetto: "+CPLib.Substr(riga,7,70)+" con codice fiscale: "+CPLib.Substr(riga,112,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                    /* _esito := 1 */
                    _esito = CPLib.Round(1,0);
                    // Exit Loop
                    if (true) {
                      break;
                    }
                  } else if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                    m_cLastMsgError = "Errore in aggiornamento ARCHPERS";
                  }
                  /* cNumMod := cNumMod + 1 */
                  cNumMod = CPLib.Round(cNumMod+1,0);
                } else { // Else
                  /* Sovrascrivo tutti i dati */
                  // * --- Write into personbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = "Update "+m_cPhName+" set ";
                  m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(xCodCab,"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.Substr(riga,7,70),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(CPLib.Substr(riga,77,35),"C",35,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(CPLib.Substr(riga,112,16),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,132,4)+CPLib.Substr(riga,130,2)+CPLib.Substr(riga,128,2)),"D",8,0)+", ";
                  m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(cCNAS,"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(CPLib.Substr(riga,166,3),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(CPLib.Substr(riga,169,3),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(CPLib.Substr(riga,172,3),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(CPLib.Substr(riga,175,2),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(CPLib.Substr(riga,177,15),"C",15,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,196,4)+CPLib.Substr(riga,194,2)+CPLib.Substr(riga,192,2)),"D",8,0)+", ";
                  m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(CPLib.Substr(riga,200,30),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.Substr(riga,230,30),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(CPLib.Substr(riga,260,2),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(CPLib.Substr(riga,262,3),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(CPLib.Substr(riga,265,9),"C",9,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PARTIVA = "+CPLib.ToSQL(CPLib.Substr(riga,274,14),"C",14,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(xSesso,"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATAVALI = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,293,4)+CPLib.Substr(riga,291,2)+CPLib.Substr(riga,289,2)),"D",8,0)+", ";
                  m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(CPLib.Substr(riga,297,26),"C",26,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(CPLib.Substr(riga,323,25),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DOCFILE = "+CPLib.ToSQL(CPLib.Substr(riga,348,100),"C",100,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(CPLib.Substr(riga,448,2),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(xCFE,"N",1,0)+", ";
                  m_cSql = m_cSql+"PKTBSPECIE = "+CPLib.ToSQL(CPLib.Substr(riga,451,4),"C",4,0,m_cServer)+", ";
                  m_cSql = m_cSql+"COMPORT = "+CPLib.ToSQL(CPLib.Substr(riga,455,5),"C",5,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(CPLib.Substr(riga,460,10),"C",10,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(cSNAS,"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAGSOCOLD = "+CPLib.ToSQL(CPLib.Substr(riga,7,70),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ALLINEATONOMECNOME = "+CPLib.ToSQL(0,"N",1,0)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(xConnes,"?",0,0,m_cServer),m_cServer,xConnes)+"";
                  if (m_Ctx.IsSharedTemp("personbo")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  if (CPLib.lt(m_nUpdatedRows,0)) {
                    m_nUpdatedRows = 0;
                  }
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.lt(m_nUpdatedRows,1)) {
                    // No rows updated
                    /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per il soggetto: "+Substr(riga,7,70)+" con codice fiscale: "+Substr(riga,112,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                    w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per il soggetto: "+CPLib.Substr(riga,7,70)+" con codice fiscale: "+CPLib.Substr(riga,112,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                    /* _esito := 1 */
                    _esito = CPLib.Round(1,0);
                    // Exit Loop
                    if (true) {
                      break;
                    }
                  } else if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                    m_cLastMsgError = "Errore in aggiornamento ARCHPERS";
                  }
                  /* cNumMod := cNumMod + 1 */
                  cNumMod = CPLib.Round(cNumMod+1,0);
                } // End If
                /* Case _allineatonomecnome=0 and _allineamento=1 */
              } else if (CPLib.eqr(_allineatonomecnome,0) && CPLib.eqr(_allineamento,1)) {
                /* If not(_ragsocold=Substr(riga,7,70)) */
                if ( ! (CPLib.eqr(_ragsocold,CPLib.Substr(riga,7,70)))) {
                  /* Sovrascrivo i dati non alineati solo se la ragione sociale è diversa */
                  // * --- Write into personbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = "Update "+m_cPhName+" set ";
                  m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(xCodCab,"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.Substr(riga,7,70),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(CPLib.Substr(riga,77,35),"C",35,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(CPLib.Substr(riga,166,3),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(CPLib.Substr(riga,169,3),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(CPLib.Substr(riga,172,3),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(CPLib.Substr(riga,175,2),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(CPLib.Substr(riga,177,15),"C",15,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,196,4)+CPLib.Substr(riga,194,2)+CPLib.Substr(riga,192,2)),"D",8,0)+", ";
                  m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(CPLib.Substr(riga,200,30),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.Substr(riga,230,30),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(CPLib.Substr(riga,260,2),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(CPLib.Substr(riga,262,3),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(CPLib.Substr(riga,265,9),"C",9,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PARTIVA = "+CPLib.ToSQL(CPLib.Substr(riga,274,14),"C",14,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(xSesso,"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATAVALI = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,293,4)+CPLib.Substr(riga,291,2)+CPLib.Substr(riga,289,2)),"D",8,0)+", ";
                  m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(CPLib.Substr(riga,297,26),"C",26,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(CPLib.Substr(riga,323,25),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DOCFILE = "+CPLib.ToSQL(CPLib.Substr(riga,348,100),"C",100,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(CPLib.Substr(riga,448,2),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(xCFE,"N",1,0)+", ";
                  m_cSql = m_cSql+"PKTBSPECIE = "+CPLib.ToSQL(CPLib.Substr(riga,451,4),"C",4,0,m_cServer)+", ";
                  m_cSql = m_cSql+"COMPORT = "+CPLib.ToSQL(CPLib.Substr(riga,455,5),"C",5,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(CPLib.Substr(riga,460,10),"C",10,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAGSOCOLD = "+CPLib.ToSQL(CPLib.Substr(riga,7,70),"C",70,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(xConnes,"?",0,0,m_cServer),m_cServer,xConnes)+"";
                  if (m_Ctx.IsSharedTemp("personbo")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  if (CPLib.lt(m_nUpdatedRows,0)) {
                    m_nUpdatedRows = 0;
                  }
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.lt(m_nUpdatedRows,1)) {
                    // No rows updated
                    /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per il soggetto: "+Substr(riga,7,70)+" con codice fiscale: "+Substr(riga,112,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                    w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per il soggetto: "+CPLib.Substr(riga,7,70)+" con codice fiscale: "+CPLib.Substr(riga,112,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                    /* _esito := 1 */
                    _esito = CPLib.Round(1,0);
                    // Exit Loop
                    if (true) {
                      break;
                    }
                  } else if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                    m_cLastMsgError = "Errore in aggiornamento ARCHPERS";
                  }
                  /* cNumMod := cNumMod + 1 */
                  cNumMod = CPLib.Round(cNumMod+1,0);
                } // End If
                /* Case _allineatonomecnome=1 and _allineamento=1 */
              } else if (CPLib.eqr(_allineatonomecnome,1) && CPLib.eqr(_allineamento,1)) {
                /* Verifico che la ragione sociale invertita _ragsochold sia uguale a quella importata altrimenti sovraschivo la vecchia e riabilito l'allineamento */
                /* If not(_ragsocold=Substr(riga,7,70)) */
                if ( ! (CPLib.eqr(_ragsocold,CPLib.Substr(riga,7,70)))) {
                  // * --- Write into personbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = "Update "+m_cPhName+" set ";
                  m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(xCodCab,"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.Substr(riga,7,70),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(CPLib.Substr(riga,77,35),"C",35,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(CPLib.Substr(riga,166,3),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(CPLib.Substr(riga,169,3),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(CPLib.Substr(riga,172,3),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(CPLib.Substr(riga,175,2),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(CPLib.Substr(riga,177,15),"C",15,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,196,4)+CPLib.Substr(riga,194,2)+CPLib.Substr(riga,192,2)),"D",8,0)+", ";
                  m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(CPLib.Substr(riga,200,30),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.Substr(riga,230,30),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(CPLib.Substr(riga,260,2),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(CPLib.Substr(riga,262,3),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(CPLib.Substr(riga,265,9),"C",9,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PARTIVA = "+CPLib.ToSQL(CPLib.Substr(riga,274,14),"C",14,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(xSesso,"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATAVALI = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,293,4)+CPLib.Substr(riga,291,2)+CPLib.Substr(riga,289,2)),"D",8,0)+", ";
                  m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(CPLib.Substr(riga,297,26),"C",26,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(CPLib.Substr(riga,323,25),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DOCFILE = "+CPLib.ToSQL(CPLib.Substr(riga,348,100),"C",100,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(CPLib.Substr(riga,448,2),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PKTBSPECIE = "+CPLib.ToSQL(CPLib.Substr(riga,451,4),"C",4,0,m_cServer)+", ";
                  m_cSql = m_cSql+"COMPORT = "+CPLib.ToSQL(CPLib.Substr(riga,455,5),"C",5,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(CPLib.Substr(riga,460,10),"C",10,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(cSNAS,"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAGSOCOLD = "+CPLib.ToSQL(CPLib.Substr(riga,7,70),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ALLINEATONOMECNOME = "+CPLib.ToSQL(0,"N",1,0)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(xConnes,"?",0,0,m_cServer),m_cServer,xConnes)+"";
                  if (m_Ctx.IsSharedTemp("personbo")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  if (CPLib.lt(m_nUpdatedRows,0)) {
                    m_nUpdatedRows = 0;
                  }
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.lt(m_nUpdatedRows,1)) {
                    // No rows updated
                    /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per il soggetto: "+Substr(riga,7,70)+" con codice fiscale: "+Substr(riga,112,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                    w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per il soggetto: "+CPLib.Substr(riga,7,70)+" con codice fiscale: "+CPLib.Substr(riga,112,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                    /* _esito := 1 */
                    _esito = CPLib.Round(1,0);
                    // Exit Loop
                    if (true) {
                      break;
                    }
                  } else if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                    m_cLastMsgError = "Errore in aggiornamento ARCHPERS";
                  }
                  /* cNumMod := cNumMod + 1 */
                  cNumMod = CPLib.Round(cNumMod+1,0);
                } // End If
              } // End Case
            } else { // Else
              /* Se non è persona fisica */
              /* If _allineamento=1 */
              if (CPLib.eqr(_allineamento,1)) {
                /* If not(xCodCab=_cabold) */
                if ( ! (CPLib.eqr(xCodCab,_cabold))) {
                  // * --- Write into personbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = "Update "+m_cPhName+" set ";
                  m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(xCodCab,"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.Substr(riga,7,70),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(CPLib.Substr(riga,77,35),"C",35,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(CPLib.Substr(riga,112,16),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,132,4)+CPLib.Substr(riga,130,2)+CPLib.Substr(riga,128,2)),"D",8,0)+", ";
                  m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(cCNAS,"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(CPLib.Substr(riga,166,3),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(CPLib.Substr(riga,169,3),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(CPLib.Substr(riga,172,3),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(CPLib.Substr(riga,175,2),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(CPLib.Substr(riga,177,15),"C",15,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,196,4)+CPLib.Substr(riga,194,2)+CPLib.Substr(riga,192,2)),"D",8,0)+", ";
                  m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(CPLib.Substr(riga,200,30),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.Substr(riga,230,30),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(CPLib.Substr(riga,260,2),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(CPLib.Substr(riga,262,3),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(CPLib.Substr(riga,265,9),"C",9,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PARTIVA = "+CPLib.ToSQL(CPLib.Substr(riga,274,14),"C",14,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(xSesso,"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATAVALI = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,293,4)+CPLib.Substr(riga,291,2)+CPLib.Substr(riga,289,2)),"D",8,0)+", ";
                  m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(CPLib.Substr(riga,297,26),"C",26,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(CPLib.Substr(riga,323,25),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DOCFILE = "+CPLib.ToSQL(CPLib.Substr(riga,348,100),"C",100,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(CPLib.Substr(riga,448,2),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(xCFE,"N",1,0)+", ";
                  m_cSql = m_cSql+"PKTBSPECIE = "+CPLib.ToSQL(CPLib.Substr(riga,451,4),"C",4,0,m_cServer)+", ";
                  m_cSql = m_cSql+"COMPORT = "+CPLib.ToSQL(CPLib.Substr(riga,455,5),"C",5,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(CPLib.Substr(riga,460,10),"C",10,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(cSNAS,"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAGSOCOLD = "+CPLib.ToSQL(CPLib.Substr(riga,7,70),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"0 = "+CPLib.ToSQL(_allineamento,"C",10,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(xConnes,"?",0,0,m_cServer),m_cServer,xConnes)+"";
                  if (m_Ctx.IsSharedTemp("personbo")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  if (CPLib.lt(m_nUpdatedRows,0)) {
                    m_nUpdatedRows = 0;
                  }
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.lt(m_nUpdatedRows,1)) {
                    // No rows updated
                    /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per il soggetto: "+Substr(riga,7,70)+" con codice fiscale: "+Substr(riga,112,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                    w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per il soggetto: "+CPLib.Substr(riga,7,70)+" con codice fiscale: "+CPLib.Substr(riga,112,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                    /* _esito := 1 */
                    _esito = CPLib.Round(1,0);
                    // Exit Loop
                    if (true) {
                      break;
                    }
                  } else if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                    m_cLastMsgError = "Errore in aggiornamento ARCHPERS";
                  }
                  /* cNumMod := cNumMod + 1 */
                  cNumMod = CPLib.Round(cNumMod+1,0);
                } else { // Else
                  /* If not(_ragsocold=Substr(riga,7,70)) */
                  if ( ! (CPLib.eqr(_ragsocold,CPLib.Substr(riga,7,70)))) {
                    // * --- Write into personbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("personbo");
                    m_cPhName = m_Ctx.GetPhName("personbo");
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = "Update "+m_cPhName+" set ";
                    m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.Substr(riga,7,70),"C",70,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(CPLib.Substr(riga,77,35),"C",35,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(CPLib.Substr(riga,112,16),"C",16,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(CPLib.Substr(riga,166,3),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(CPLib.Substr(riga,169,3),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(CPLib.Substr(riga,172,3),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(CPLib.Substr(riga,175,2),"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(CPLib.Substr(riga,177,15),"C",15,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,196,4)+CPLib.Substr(riga,194,2)+CPLib.Substr(riga,192,2)),"D",8,0)+", ";
                    m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(CPLib.Substr(riga,200,30),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(CPLib.Substr(riga,265,9),"C",9,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PARTIVA = "+CPLib.ToSQL(CPLib.Substr(riga,274,14),"C",14,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DATAVALI = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,293,4)+CPLib.Substr(riga,291,2)+CPLib.Substr(riga,289,2)),"D",8,0)+", ";
                    m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(CPLib.Substr(riga,297,26),"C",26,0,m_cServer)+", ";
                    m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(CPLib.Substr(riga,323,25),"C",25,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DOCFILE = "+CPLib.ToSQL(CPLib.Substr(riga,348,100),"C",100,0,m_cServer)+", ";
                    m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(CPLib.Substr(riga,448,2),"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(xCFE,"N",1,0)+", ";
                    m_cSql = m_cSql+"PKTBSPECIE = "+CPLib.ToSQL(CPLib.Substr(riga,451,4),"C",4,0,m_cServer)+", ";
                    m_cSql = m_cSql+"COMPORT = "+CPLib.ToSQL(CPLib.Substr(riga,455,5),"C",5,0,m_cServer)+", ";
                    m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(CPLib.Substr(riga,460,10),"C",10,0,m_cServer)+", ";
                    m_cSql = m_cSql+"RAGSOCOLD = "+CPLib.ToSQL(CPLib.Substr(riga,7,70),"C",70,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(xConnes,"?",0,0,m_cServer),m_cServer,xConnes)+"";
                    if (m_Ctx.IsSharedTemp("personbo")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                    if (CPLib.lt(m_nUpdatedRows,0)) {
                      m_nUpdatedRows = 0;
                    }
                    m_Sql.CompleteTransaction();
                    m_cLastMsgError = m_Sql.TransactionErrorMessage();
                    if (CPLib.lt(m_nUpdatedRows,1)) {
                      // No rows updated
                      /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per il soggetto: "+Substr(riga,7,70)+" con codice fiscale: "+Substr(riga,112,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                      w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per il soggetto: "+CPLib.Substr(riga,7,70)+" con codice fiscale: "+CPLib.Substr(riga,112,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                      /* _esito := 1 */
                      _esito = CPLib.Round(1,0);
                      // Exit Loop
                      if (true) {
                        break;
                      }
                    } else if (CPLib.ne(m_cLastMsgError,"")) {
                      m_bError = true;
                      m_cLastMsgError = "Errore in aggiornamento ARCHPERS";
                    }
                  } // End If
                  /* cNumMod := cNumMod + 1 */
                  cNumMod = CPLib.Round(cNumMod+1,0);
                } // End If
              } else { // Else
                // * --- Write into personbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "Update "+m_cPhName+" set ";
                m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(xCodCab,"C",6,0,m_cServer)+", ";
                m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.Substr(riga,7,70),"C",70,0,m_cServer)+", ";
                m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(CPLib.Substr(riga,77,35),"C",35,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(CPLib.Substr(riga,112,16),"C",16,0,m_cServer)+", ";
                m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,132,4)+CPLib.Substr(riga,130,2)+CPLib.Substr(riga,128,2)),"D",8,0)+", ";
                m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(cCNAS,"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(CPLib.Substr(riga,166,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(CPLib.Substr(riga,169,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(CPLib.Substr(riga,172,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(CPLib.Substr(riga,175,2),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(CPLib.Substr(riga,177,15),"C",15,0,m_cServer)+", ";
                m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,196,4)+CPLib.Substr(riga,194,2)+CPLib.Substr(riga,192,2)),"D",8,0)+", ";
                m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(CPLib.Substr(riga,200,30),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.Substr(riga,230,30),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(CPLib.Substr(riga,260,2),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(CPLib.Substr(riga,262,3),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(CPLib.Substr(riga,265,9),"C",9,0,m_cServer)+", ";
                m_cSql = m_cSql+"PARTIVA = "+CPLib.ToSQL(CPLib.Substr(riga,274,14),"C",14,0,m_cServer)+", ";
                m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(xSesso,"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"DATAVALI = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,293,4)+CPLib.Substr(riga,291,2)+CPLib.Substr(riga,289,2)),"D",8,0)+", ";
                m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(CPLib.Substr(riga,297,26),"C",26,0,m_cServer)+", ";
                m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(CPLib.Substr(riga,323,25),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"DOCFILE = "+CPLib.ToSQL(CPLib.Substr(riga,348,100),"C",100,0,m_cServer)+", ";
                m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(CPLib.Substr(riga,448,2),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(xCFE,"N",1,0)+", ";
                m_cSql = m_cSql+"PKTBSPECIE = "+CPLib.ToSQL(CPLib.Substr(riga,451,4),"C",4,0,m_cServer)+", ";
                m_cSql = m_cSql+"COMPORT = "+CPLib.ToSQL(CPLib.Substr(riga,455,5),"C",5,0,m_cServer)+", ";
                m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(CPLib.Substr(riga,460,10),"C",10,0,m_cServer)+", ";
                m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(cSNAS,"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"RAGSOCOLD = "+CPLib.ToSQL(CPLib.Substr(riga,7,70),"C",70,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(xConnes,"?",0,0,m_cServer),m_cServer,xConnes)+"";
                if (m_Ctx.IsSharedTemp("personbo")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_nUpdatedRows = 0;
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.lt(m_nUpdatedRows,1)) {
                  // No rows updated
                  /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per il soggetto: "+Substr(riga,7,70)+" con codice fiscale: "+Substr(riga,112,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                  w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per il soggetto: "+CPLib.Substr(riga,7,70)+" con codice fiscale: "+CPLib.Substr(riga,112,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                  /* _esito := 1 */
                  _esito = CPLib.Round(1,0);
                  // Exit Loop
                  if (true) {
                    break;
                  }
                } else if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  m_cLastMsgError = "Errore in aggiornamento ARCHPERS";
                }
                /* cNumMod := cNumMod + 1 */
                cNumMod = CPLib.Round(cNumMod+1,0);
              } // End If
            } // End If
          } // End If
        } // End If
      } // End While
      // Commit
      m_cLastMsgError = m_Sql.TransactionErrorMessage();
      if (CPLib.ne(m_cLastMsgError,"")) {
        m_bError = true;
      }
      m_Sql.CompleteTransaction();
      /* w_msgproc := w_msgproc + 'Soggetti Inseriti: '+LRTrim(Str(cNumNew,10,0)) + ' - Soggetti Aggiornati: '+LRTrim(Str(cNumMod,10,0)) + ' dal file '+nomefileimport+NL */
      w_msgproc = w_msgproc+"Soggetti Inseriti: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+" - Soggetti Aggiornati: "+CPLib.LRTrim(CPLib.Str(cNumMod,10,0))+" dal file "+nomefileimport+"\n";
      /* w_msgproc := w_msgproc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"del file"+nomefileimport+"\n";
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
    } finally {
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
    CPResultSet Read_Cursor=null;
    try {
      /* Legge il file di testo e porta i dati nella tabella */
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      /* cNumMod := 0 */
      cNumMod = CPLib.Round(0,0);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      /* w_msgproc := w_msgproc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime())  + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"del file"+nomefileimport+"\n";
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' rapporti' // Messaggio Import */
        gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" rapporti";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        // * --- Read from anarapbo
        m_cServer = m_Ctx.GetServer("anarapbo");
        m_cPhName = m_Ctx.GetPhName("anarapbo");
        m_cSql = "";
        m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,25),"C",25,0,m_cServer),m_cServer,CPLib.Left(riga,25));
        if (m_Ctx.IsSharedTemp("anarapbo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          xRapporto = Read_Cursor.GetString("RAPPORTO");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on anarapbo into routine arrt_imp_dati_multipli_old returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          xRapporto = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If Empty(LRTrim(xRapporto)) */
        if (CPLib.Empty(CPLib.LRTrim(xRapporto))) {
          // * --- Insert into anarapbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("anarapbo");
          m_cPhName = m_Ctx.GetPhName("anarapbo");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"anarapbo")+" (";
          m_cSql = m_cSql+GetFieldsName_0619FDC8(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,25),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,26,50),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,76,1),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,77,1),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,78,3),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,81,2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,83,1)),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,84,5),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,89,5),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,94,5),"?",0,0,m_cServer)+", ";
          if (m_Ctx.IsSharedTemp("anarapbo")) {
            m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
          }
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"anarapbo",true);
          m_cSql = m_cSql+")";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows inserted
            /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per il rapporto: "+Left(riga,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
            w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per il rapporto: "+CPLib.Left(riga,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            // Exit Loop
            if (true) {
              break;
            }
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          /* cNumNew := cNumNew + 1 */
          cNumNew = CPLib.Round(cNumNew+1,0);
        } else { // Else
          // * --- Write into anarapbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("anarapbo");
          m_cPhName = m_Ctx.GetPhName("anarapbo");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = "Update "+m_cPhName+" set ";
          m_cSql = m_cSql+"DESCRAP = "+CPLib.ToSQL(CPLib.Substr(riga,26,50),"C",50,0,m_cServer)+", ";
          m_cSql = m_cSql+"TIPORAP = "+CPLib.ToSQLNull(CPLib.Substr(riga,76,1),"C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"FLAGLIRE = "+CPLib.ToSQL(CPLib.Substr(riga,77,1),"C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"VALUTA = "+CPLib.ToSQLNull(CPLib.Substr(riga,78,3),"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"TIPOAG = "+CPLib.ToSQL(CPLib.Substr(riga,81,2),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"NOPROT = "+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,83,1)),"N",1,0)+", ";
          m_cSql = m_cSql+"RAGIO = "+CPLib.ToSQL(CPLib.Substr(riga,84,5),"C",5,0,m_cServer)+", ";
          m_cSql = m_cSql+"MODSVOL = "+CPLib.ToSQL(CPLib.Substr(riga,89,5),"C",5,0,m_cServer)+", ";
          m_cSql = m_cSql+"AREAGEO = "+CPLib.ToSQL(CPLib.Substr(riga,94,5),"C",5,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"anarapbo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(xRapporto,"?",0,0,m_cServer),m_cServer,xRapporto)+"";
          if (m_Ctx.IsSharedTemp("anarapbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows updated
            /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per il rapporto: "+Left(riga,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
            w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per il rapporto: "+CPLib.Left(riga,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            // Exit Loop
            if (true) {
              break;
            }
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          /* cNumMod := cNumMod + 1 */
          cNumMod = CPLib.Round(cNumMod+1,0);
        } // End If
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* w_msgproc := w_msgproc + 'Rapporti Inseriti: '+LRTrim(Str(cNumNew,10,0)) +' - Rapporti Aggiornati: '+LRTrim(Str(cNumMod,10,0))+' dal file '+nomefileimport+NL */
      w_msgproc = w_msgproc+"Rapporti Inseriti: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+" - Rapporti Aggiornati: "+CPLib.LRTrim(CPLib.Str(cNumMod,10,0))+" dal file "+nomefileimport+"\n";
      /* w_msgproc := w_msgproc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"del file"+nomefileimport+"\n";
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_4() throws Exception {
    CPResultSet Cursor_imp_info=null;
    CPResultSet Cursor_soginfo=null;
    CPResultSet Cursor_intestbo=null;
    try {
      /* Legge il file di testo e porta i dati nella tabella */
      // * --- Drop temporary table imp_info
      if (m_Ctx.IsSharedTemp("imp_info")) {
        if (m_Ctx.IsTmpAlreadyCreated("imp_info")) {
          m_cServer = m_Ctx.GetServer("imp_info");
          m_cPhName = m_Ctx.GetPhName("imp_info");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("imp_info");
      }
      // * --- Create temporary table imp_info
      if (m_Ctx.IsSharedTemp("imp_info")) {
        if (m_Ctx.IsTmpAlreadyCreated("imp_info")) {
          m_cServer = m_Ctx.GetServer("imp_info");
          m_cPhName = m_Ctx.GetPhName("imp_info");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("imp_info");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("imp_info");
      if ( ! (m_Ctx.IsSharedTemp("imp_info"))) {
        m_cServer = m_Ctx.GetServer("imp_info");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("imp_info",m_cServer,"proto")),m_cPhName,"imp_info",m_Ctx,new String[]{"RAPPORTO,DATAOPE"});
      }
      m_cPhName_imp_info = m_cPhName;
      /* w_msgproc := w_msgproc + 'Ora Inizio Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Inizio Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        // * --- Insert into imp_info from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("imp_info");
        m_cPhName = m_Ctx.GetPhName("imp_info");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"imp_info")+" (";
        m_cSql = m_cSql+GetFieldsName_06DF8EC0(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,8),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,9,25),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,34,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,35,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,36,8),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,44,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,46,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,47,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,50,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,66,9),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,75,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,91,11),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,102,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,104,11),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,115,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,121,30),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,151,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,153,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,159,10),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,169,50),"?",0,0,m_cServer)+", ";
        if (m_Ctx.IsSharedTemp("imp_info")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"imp_info",true);
        m_cSql = m_cSql+")";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_nUpdatedRows = 0;
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.lt(m_nUpdatedRows,1)) {
          // No rows inserted
          /* w_msgproc := w_msgproc +"Rilevati errori in lettura del file "+nomefileimport+" per l'informazione in data "+Left(riga,8)+" relativa al rapporto: "+Substr(riga,9,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
          w_msgproc = w_msgproc+"Rilevati errori in lettura del file "+nomefileimport+" per l'informazione in data "+CPLib.Left(riga,8)+" relativa al rapporto: "+CPLib.Substr(riga,9,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
          // Exit Loop
          if (true) {
            break;
          }
        } else if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      // * --- Select from imp_info
      m_cServer = m_Ctx.GetServer("imp_info");
      m_cPhName = m_Ctx.GetPhName("imp_info");
      if (Cursor_imp_info!=null)
        Cursor_imp_info.Close();
      Cursor_imp_info = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("imp_info")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_imp_info.Eof())) {
        /* Case imp_info->FLAGLIRE='S' or imp_info->FLAGLIRE='1' or imp_info->FLAGLIRE='7' */
        if (CPLib.eqr(Cursor_imp_info.GetString("FLAGLIRE"),"S") || CPLib.eqr(Cursor_imp_info.GetString("FLAGLIRE"),"1") || CPLib.eqr(Cursor_imp_info.GetString("FLAGLIRE"),"7")) {
          /* cFlagLire := '1' */
          cFlagLire = "1";
          /* Case imp_info->FLAGLIRE='E' or imp_info->FLAGLIRE='3' or imp_info->FLAGLIRE='5' */
        } else if (CPLib.eqr(Cursor_imp_info.GetString("FLAGLIRE"),"E") || CPLib.eqr(Cursor_imp_info.GetString("FLAGLIRE"),"3") || CPLib.eqr(Cursor_imp_info.GetString("FLAGLIRE"),"5")) {
          /* If imp_info->FLAGLIRE = 'E' */
          if (CPLib.eqr(Cursor_imp_info.GetString("FLAGLIRE"),"E")) {
            /* cFlagLire := '3' */
            cFlagLire = "3";
          } else { // Else
            /* cFlagLire := imp_info->FLAGLIRE */
            cFlagLire = Cursor_imp_info.GetString("FLAGLIRE");
          } // End If
        } else { // Otherwise
          /* cFlagLire := imp_info->FLAGLIRE */
          cFlagLire = Cursor_imp_info.GetString("FLAGLIRE");
        } // End Case
        /* cInfProg1 := iif(Empty(imp_info->UNIQUECOD),Utilities.GetAutonumber('PRGINFO1','',10),imp_info->UNIQUECOD) */
        cInfProg1 = (CPLib.Empty(Cursor_imp_info.GetString("UNIQUECOD"))?Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO1","",10):Cursor_imp_info.GetString("UNIQUECOD"));
        /* cInfProg2 := Utilities.GetAutonumber('PRGINFO2','',11) */
        cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO2","",11);
        // * --- Insert into rapopebo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("rapopebo");
        m_cPhName = m_Ctx.GetPhName("rapopebo");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"rapopebo")+" (";
        m_cSql = m_cSql+GetFieldsName_07A3A2E8(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(Cursor_imp_info.GetString("DATAOPE"),4)+CPLib.Substr(Cursor_imp_info.GetString("DATAOPE"),3,2)+CPLib.Left(Cursor_imp_info.GetString("DATAOPE"),2)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("DATAOPE")+Cursor_imp_info.GetString("NUMPROG")+"0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(Cursor_imp_info.GetString("DATAREG"),4)+CPLib.Substr(Cursor_imp_info.GetString("DATAREG"),3,2)+CPLib.Left(Cursor_imp_info.GetString("DATAREG"),2)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_imp_info.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_imp_info.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_imp_info.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_imp_info.GetString("TIPOOPRAP"),1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cFlagLire,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_imp_info.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
        if (m_Ctx.IsSharedTemp("rapopebo")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"rapopebo",true);
        m_cSql = m_cSql+")";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_nUpdatedRows = 0;
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.lt(m_nUpdatedRows,1)) {
          // No rows inserted
          /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per l'informazione in data "+imp_info->DATAOPE+" relativa al rapporto: "+imp_info->RAPPORTO+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
          w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per l'informazione in data "+Cursor_imp_info.GetString("DATAOPE")+" relativa al rapporto: "+Cursor_imp_info.GetString("RAPPORTO")+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
          // Exit Loop
          if (true) {
            break;
          }
        } else if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        /* If not(Empty(imp_info->CONNESOPER)) */
        if ( ! (CPLib.Empty(Cursor_imp_info.GetString("CONNESOPER")))) {
          /* cMaxRow := 0 */
          cMaxRow = CPLib.Round(0,0);
          // * --- Select from soginfo
          m_cServer = m_Ctx.GetServer("soginfo");
          m_cPhName = m_Ctx.GetPhName("soginfo");
          if (Cursor_soginfo!=null)
            Cursor_soginfo.Close();
          Cursor_soginfo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer, m_oParameters),m_cServer,cInfProg1)+" "+")"+(m_Ctx.IsSharedTemp("soginfo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_soginfo.Eof())) {
            /* cMaxRow := soginfo->CPROWNUM */
            cMaxRow = CPLib.Round(Cursor_soginfo.GetDouble("CPROWNUM"),0);
            Cursor_soginfo.Next();
          }
          m_cConnectivityError = Cursor_soginfo.ErrorMessage();
          Cursor_soginfo.Close();
          // * --- End Select
          /* cMaxRow := cMaxRow + 1 */
          cMaxRow = CPLib.Round(cMaxRow+1,0);
          // * --- Insert into soginfo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("soginfo");
          m_cPhName = m_Ctx.GetPhName("soginfo");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"soginfo")+" (";
          m_cSql = m_cSql+GetFieldsName_06EC8C28(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_imp_info.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_imp_info.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          if (m_Ctx.IsSharedTemp("soginfo")) {
            m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
          }
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"soginfo",true);
          m_cSql = m_cSql+")";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows inserted
            /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per la registrazione del soggetto operante dell'informazione in data "+imp_info->DATAOPE+" relativa al rapporto: "+imp_info->RAPPORTO+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
            w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per la registrazione del soggetto operante dell'informazione in data "+Cursor_imp_info.GetString("DATAOPE")+" relativa al rapporto: "+Cursor_imp_info.GetString("RAPPORTO")+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            // Exit Loop
            if (true) {
              break;
            }
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
        } // End If
        /* cMaxRow := 0 */
        cMaxRow = CPLib.Round(0,0);
        /* cNumMod := 0 */
        cNumMod = CPLib.Round(0,0);
        // * --- Select from intestbo
        m_cServer = m_Ctx.GetServer("intestbo");
        m_cPhName = m_Ctx.GetPhName("intestbo");
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
        Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_imp_info.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM ",m_cServer,m_Ctx,true));
        while ( ! (Cursor_intestbo.Eof())) {
          /* If imp_info->CODFISC=intestbo->CODINTER */
          if (CPLib.eqr(Cursor_imp_info.GetString("CODFISC"),Cursor_intestbo.GetString("CODINTER"))) {
            /* cNumMod := intestbo->CPROWNUM */
            cNumMod = CPLib.Round(Cursor_intestbo.GetDouble("CPROWNUM"),0);
          } // End If
          /* cMaxRow := intestbo->CPROWNUM */
          cMaxRow = CPLib.Round(Cursor_intestbo.GetDouble("CPROWNUM"),0);
          Cursor_intestbo.Next();
        }
        m_cConnectivityError = Cursor_intestbo.ErrorMessage();
        Cursor_intestbo.Close();
        // * --- End Select
        /* If cNumMod = 0 */
        if (CPLib.eqr(cNumMod,0)) {
          // * --- Insert into intestbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("intestbo");
          m_cPhName = m_Ctx.GetPhName("intestbo");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"intestbo")+" (";
          m_cSql = m_cSql+GetFieldsName_07C16998(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow+1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(Cursor_imp_info.GetString("DATAOPE"),5,4)+CPLib.Substr(Cursor_imp_info.GetString("DATAOPE"),3,2)+CPLib.Substr(Cursor_imp_info.GetString("DATAOPE"),1,2)),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_imp_info.GetString("TIPOOPRAP"),"25") || CPLib.eqr(Cursor_imp_info.GetString("TIPOOPRAP"),"28")?"D":"P"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Left(CPLib.LRTrim(Cursor_imp_info.GetString("CODFISC"))+CPLib.Space(5),16),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("DATAOPE")+cInfProg2+"O","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(Cursor_imp_info.GetString("CODFISC"))+CPLib.Space(5),16),"?",0,0,m_cServer)+", ";
          if (m_Ctx.IsSharedTemp("intestbo")) {
            m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
          }
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"intestbo",true);
          m_cSql = m_cSql+")";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows inserted
            /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario dell'informazione in data "+imp_info->DATAOPE+" relativa al rapporto: "+imp_info->RAPPORTO+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
            w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario dell'informazione in data "+Cursor_imp_info.GetString("DATAOPE")+" relativa al rapporto: "+Cursor_imp_info.GetString("RAPPORTO")+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            // Exit Loop
            if (true) {
              break;
            }
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
        } else { // Else
          /* If imp_info->TIPOOPRAP='23' */
          if (CPLib.eqr(Cursor_imp_info.GetString("TIPOOPRAP"),"23")) {
            // * --- Write into intestbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = "Update "+m_cPhName+" set ";
            m_cSql = m_cSql+"DATAINI = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(Cursor_imp_info.GetString("DATAOPE"),5,4)+CPLib.Substr(Cursor_imp_info.GetString("DATAOPE"),3,2)+CPLib.Substr(Cursor_imp_info.GetString("DATAOPE"),1,2)),"D",8,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_imp_info.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_imp_info.GetString("RAPPORTO"))+"";
            m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cNumMod,"?",0,0,m_cServer),m_cServer,cNumMod)+"";
            if (m_Ctx.IsSharedTemp("intestbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_nUpdatedRows = 0;
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.lt(m_nUpdatedRows,1)) {
              // No rows updated
              /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario dell'informazione in data "+imp_info->DATAOPE+" relativa al rapporto: "+imp_info->RAPPORTO+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
              w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario dell'informazione in data "+Cursor_imp_info.GetString("DATAOPE")+" relativa al rapporto: "+Cursor_imp_info.GetString("RAPPORTO")+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
              /* _esito := 1 */
              _esito = CPLib.Round(1,0);
              // Exit Loop
              if (true) {
                break;
              }
            } else if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
            /* ElseIf imp_info->TIPOOPRAP='26' */
          } else if (CPLib.eqr(Cursor_imp_info.GetString("TIPOOPRAP"),"26")) {
            // * --- Write into intestbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = "Update "+m_cPhName+" set ";
            m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(Cursor_imp_info.GetString("DATAOPE"),5,4)+CPLib.Substr(Cursor_imp_info.GetString("DATAOPE"),3,2)+CPLib.Substr(Cursor_imp_info.GetString("DATAOPE"),1,2)),"D",8,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_imp_info.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_imp_info.GetString("RAPPORTO"))+"";
            m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cNumMod,"?",0,0,m_cServer),m_cServer,cNumMod)+"";
            if (m_Ctx.IsSharedTemp("intestbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_nUpdatedRows = 0;
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.lt(m_nUpdatedRows,1)) {
              // No rows updated
              /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario dell'informazione in data "+imp_info->DATAOPE+" relativa al rapporto: "+imp_info->RAPPORTO+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
              w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario dell'informazione in data "+Cursor_imp_info.GetString("DATAOPE")+" relativa al rapporto: "+Cursor_imp_info.GetString("RAPPORTO")+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
              /* _esito := 1 */
              _esito = CPLib.Round(1,0);
              // Exit Loop
              if (true) {
                break;
              }
            } else if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
          } // End If
        } // End If
        /* cNumNew := cNumNew + 1 */
        cNumNew = CPLib.Round(cNumNew+1,0);
        Cursor_imp_info.Next();
      }
      m_cConnectivityError = Cursor_imp_info.ErrorMessage();
      Cursor_imp_info.Close();
      // * --- End Select
      /* w_msgproc := w_msgproc + 'Informazione Inserite: '+LRTrim(Str(cNumNew,10,0)) + NL */
      w_msgproc = w_msgproc+"Informazione Inserite: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+"\n";
      /* w_msgproc := w_msgproc + 'Ora Fine Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Fine Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
    } finally {
      try {
        if (Cursor_imp_info!=null)
          Cursor_imp_info.Close();
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
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_5() throws Exception {
    CPResultSet Cursor_imp_opefra=null;
    CPResultSet Read_Cursor=null;
    try {
      /* Legge il file di testo e porta i dati nella tabella */
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      // * --- Drop temporary table imp_opefra
      if (m_Ctx.IsSharedTemp("imp_opefra")) {
        if (m_Ctx.IsTmpAlreadyCreated("imp_opefra")) {
          m_cServer = m_Ctx.GetServer("imp_opefra");
          m_cPhName = m_Ctx.GetPhName("imp_opefra");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("imp_opefra");
      }
      // * --- Create temporary table imp_opefra
      if (m_Ctx.IsSharedTemp("imp_opefra")) {
        if (m_Ctx.IsTmpAlreadyCreated("imp_opefra")) {
          m_cServer = m_Ctx.GetServer("imp_opefra");
          m_cPhName = m_Ctx.GetPhName("imp_opefra");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("imp_opefra");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("imp_opefra");
      if ( ! (m_Ctx.IsSharedTemp("imp_opefra"))) {
        m_cServer = m_Ctx.GetServer("imp_opefra");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("imp_opefra",m_cServer,"proto")),m_cPhName,"imp_opefra",m_Ctx,new String[]{"RAPPORTO,DATAOPE"});
      }
      m_cPhName_imp_opefra = m_cPhName;
      /* w_msgproc := w_msgproc + 'Ora Inizio Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Inizio Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        // * --- Insert into imp_opefra from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("imp_opefra");
        m_cPhName = m_Ctx.GetPhName("imp_opefra");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"imp_opefra")+" (";
        m_cSql = m_cSql+GetFieldsName_06336040(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,8),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,9,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,10,4),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,14,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,16,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,18,11),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,29,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,32,30),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,62,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,64,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,70,50),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,120,25),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,145,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,146,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,147,8),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,155,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,156,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,159,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,160,15),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,175,15),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,190,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,206,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,222,9),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,231,11),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,242,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,244,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,246,11),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,257,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,263,30),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,293,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,295,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,301,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,302,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,318,10),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,328,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,331,9),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,340,69),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,409,5),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,414,5),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,419,5),"?",0,0,m_cServer)+", ";
        if (m_Ctx.IsSharedTemp("imp_opefra")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"imp_opefra",true);
        m_cSql = m_cSql+")";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_nUpdatedRows = 0;
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.lt(m_nUpdatedRows,1)) {
          // No rows inserted
          /* w_msgproc := w_msgproc +"Rilevati errori in lettura del file "+nomefileimport+" per l'operazione in data "+Left(riga,8)+" con importo "+Str(Val(Substr(riga,160,15)),14,2)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
          w_msgproc = w_msgproc+"Rilevati errori in lettura del file "+nomefileimport+" per l'operazione in data "+CPLib.Left(riga,8)+" con importo "+CPLib.Str(CPLib.Val(CPLib.Substr(riga,160,15)),14,2)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
          // Exit Loop
          if (true) {
            break;
          }
        } else if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      // * --- Select from imp_opefra
      m_cServer = m_Ctx.GetServer("imp_opefra");
      m_cPhName = m_Ctx.GetPhName("imp_opefra");
      if (Cursor_imp_opefra!=null)
        Cursor_imp_opefra.Close();
      Cursor_imp_opefra = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("imp_opefra")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_imp_opefra.Eof())) {
        /* cOpeProg1 := iif(Empty(imp_opefra->UNIQUECODE),Utilities.GetAutonumber('POPERAZ1','',10),imp_opefra->UNIQUECODE) */
        cOpeProg1 = (CPLib.Empty(Cursor_imp_opefra.GetString("UNIQUECODE"))?Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ1","",10):Cursor_imp_opefra.GetString("UNIQUECODE"));
        /* cOpeProg2 := Utilities.GetAutonumber('POPERAZ2','',11) */
        cOpeProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ2","",11);
        /* Case imp_opefra->FLAGLIRE='S' or imp_opefra->FLAGLIRE='1' or imp_opefra->FLAGLIRE='7' */
        if (CPLib.eqr(Cursor_imp_opefra.GetString("FLAGLIRE"),"S") || CPLib.eqr(Cursor_imp_opefra.GetString("FLAGLIRE"),"1") || CPLib.eqr(Cursor_imp_opefra.GetString("FLAGLIRE"),"7")) {
          /* cFlagLire := '1' */
          cFlagLire = "1";
          /* Case imp_opefra->FLAGLIRE='E' or imp_opefra->FLAGLIRE='3' or imp_opefra->FLAGLIRE='5' */
        } else if (CPLib.eqr(Cursor_imp_opefra.GetString("FLAGLIRE"),"E") || CPLib.eqr(Cursor_imp_opefra.GetString("FLAGLIRE"),"3") || CPLib.eqr(Cursor_imp_opefra.GetString("FLAGLIRE"),"5")) {
          /* If imp_opefra->FLAGLIRE = 'E' */
          if (CPLib.eqr(Cursor_imp_opefra.GetString("FLAGLIRE"),"E")) {
            /* cFlagLire := '3' */
            cFlagLire = "3";
          } else { // Else
            /* cFlagLire := imp_opefra->FLAGLIRE */
            cFlagLire = Cursor_imp_opefra.GetString("FLAGLIRE");
          } // End If
        } else { // Otherwise
          /* cFlagLire := imp_opefra->FLAGLIRE */
          cFlagLire = Cursor_imp_opefra.GetString("FLAGLIRE");
        } // End Case
        /* cFlagCont := iif(imp_opefra->FLAGCONT='1' or imp_opefra->FLAGCONT='S','1','0')  */
        cFlagCont = (CPLib.eqr(Cursor_imp_opefra.GetString("FLAGCONT"),"1") || CPLib.eqr(Cursor_imp_opefra.GetString("FLAGCONT"),"S")?"1":"0");
        /* cFlagFraz := iif(Empty(imp_opefra->FLAGFRAZ),'0',imp_opefra->FLAGFRAZ) */
        cFlagFraz = (CPLib.Empty(Cursor_imp_opefra.GetString("FLAGFRAZ"))?"0":Cursor_imp_opefra.GetString("FLAGFRAZ"));
        /* cIdCau := '' */
        cIdCau = "";
        // * --- Read from tbcauana
        m_cServer = m_Ctx.GetServer("tbcauana");
        m_cPhName = m_Ctx.GetPhName("tbcauana");
        m_cSql = "";
        m_cSql = m_cSql+"CODCAU="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_imp_opefra.GetString("CODANA"),"C",4,0,m_cServer),m_cServer,Cursor_imp_opefra.GetString("CODANA"));
        m_cSql = m_cSql+" and CAUSINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_imp_opefra.GetString("CODVOC"),"C",2,0,m_cServer),m_cServer,Cursor_imp_opefra.GetString("CODVOC"));
        if (m_Ctx.IsSharedTemp("tbcauana")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("idbase",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          cIdCau = Read_Cursor.GetString("idbase");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on tbcauana into routine arrt_imp_dati_multipli_old returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          cIdCau = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        // * --- Insert into operazbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("operazbo");
        m_cPhName = m_Ctx.GetPhName("operazbo");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"operazbo")+" (";
        m_cSql = m_cSql+GetFieldsName_06E66070(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_imp_opefra.GetString("CAMBIO")),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(Cursor_imp_opefra.GetString("DATAOPE"),5,4)+CPLib.Substr(Cursor_imp_opefra.GetString("DATAOPE"),3,2)+CPLib.Substr(Cursor_imp_opefra.GetString("DATAOPE"),1,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CODANA"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(Cursor_imp_opefra.GetString("DATAOPE"),5,4)+CPLib.Substr(Cursor_imp_opefra.GetString("DATAOPE"),3,2)+CPLib.Substr(Cursor_imp_opefra.GetString("DATAOPE"),1,2)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(Cursor_imp_opefra.GetString("DATAREG"),5,4)+CPLib.Substr(Cursor_imp_opefra.GetString("DATAREG"),3,2)+CPLib.Substr(Cursor_imp_opefra.GetString("DATAREG"),1,2)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("DESC2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cFlagCont,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cFlagFraz,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cIdCau,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("DATAOPE")+cOpeProg2+"O","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("INFORM"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("AGOPER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("PAESE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("PROV2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CAMBIO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_imp_opefra.GetString("TOTCONT")),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_imp_opefra.GetString("TOTLIRE")),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
        if (m_Ctx.IsSharedTemp("operazbo")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"operazbo",true);
        m_cSql = m_cSql+")";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_nUpdatedRows = 0;
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.lt(m_nUpdatedRows,1)) {
          // No rows inserted
          /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per l'operazione in data "+imp_opefra->DATAOPE+" con importo "+Str((Val(imp_opefra->TOTLIRE))/100,14,2)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
          w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per l'operazione in data "+Cursor_imp_opefra.GetString("DATAOPE")+" con importo "+CPLib.Str((CPLib.Val(Cursor_imp_opefra.GetString("TOTLIRE")))/100,14,2)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
          // Exit Loop
          if (true) {
            break;
          }
        } else if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        /* cNumNew := cNumNew + 1 */
        cNumNew = CPLib.Round(cNumNew+1,0);
        Cursor_imp_opefra.Next();
      }
      m_cConnectivityError = Cursor_imp_opefra.ErrorMessage();
      Cursor_imp_opefra.Close();
      // * --- End Select
      /* w_msgproc := w_msgproc + 'Operazioni Inserite: '+LRTrim(Str(cNumNew,10,0)) + NL */
      w_msgproc = w_msgproc+"Operazioni Inserite: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+"\n";
      /* w_msgproc := w_msgproc + 'Ora Fine Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Fine Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
    } finally {
      try {
        if (Cursor_imp_opefra!=null)
          Cursor_imp_opefra.Close();
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
  void Page_6() throws Exception {
    CPResultSet Cursor_imp_opefra=null;
    CPResultSet Read_Cursor=null;
    try {
      /* Legge il file di testo e porta i dati nella tabella */
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      // * --- Drop temporary table imp_opefra
      if (m_Ctx.IsSharedTemp("imp_opefra")) {
        if (m_Ctx.IsTmpAlreadyCreated("imp_opefra")) {
          m_cServer = m_Ctx.GetServer("imp_opefra");
          m_cPhName = m_Ctx.GetPhName("imp_opefra");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("imp_opefra");
      }
      // * --- Create temporary table imp_opefra
      if (m_Ctx.IsSharedTemp("imp_opefra")) {
        if (m_Ctx.IsTmpAlreadyCreated("imp_opefra")) {
          m_cServer = m_Ctx.GetServer("imp_opefra");
          m_cPhName = m_Ctx.GetPhName("imp_opefra");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("imp_opefra");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("imp_opefra");
      if ( ! (m_Ctx.IsSharedTemp("imp_opefra"))) {
        m_cServer = m_Ctx.GetServer("imp_opefra");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("imp_opefra",m_cServer,"proto")),m_cPhName,"imp_opefra",m_Ctx,new String[]{"RAPPORTO,DATAOPE"});
      }
      m_cPhName_imp_opefra = m_cPhName;
      /* w_msgproc := w_msgproc + 'Ora Inizio Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Inizio Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        // * --- Insert into imp_opefra from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("imp_opefra");
        m_cPhName = m_Ctx.GetPhName("imp_opefra");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"imp_opefra")+" (";
        m_cSql = m_cSql+GetFieldsName_06DEF698(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,8),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,9,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,10,4),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,14,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,16,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,18,11),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,29,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,32,30),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,62,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,64,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,70,50),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,120,25),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,145,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,146,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,147,8),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,155,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,156,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,159,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,160,15),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,175,15),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,190,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,206,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,222,9),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,231,11),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,242,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,244,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,246,11),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,257,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,263,30),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,293,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,295,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,301,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,302,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,318,10),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,328,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,331,9),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,340,69),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,409,5),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,414,5),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,419,5),"?",0,0,m_cServer)+", ";
        if (m_Ctx.IsSharedTemp("imp_opefra")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"imp_opefra",true);
        m_cSql = m_cSql+")";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_nUpdatedRows = 0;
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.lt(m_nUpdatedRows,1)) {
          // No rows inserted
          /* w_msgproc := w_msgproc +"Rilevati errori in lettura del file "+nomefileimport+" per l'operazione in data "+Left(riga,8)+" con importo "+Str(Val(Substr(riga,160,15)),14,2)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
          w_msgproc = w_msgproc+"Rilevati errori in lettura del file "+nomefileimport+" per l'operazione in data "+CPLib.Left(riga,8)+" con importo "+CPLib.Str(CPLib.Val(CPLib.Substr(riga,160,15)),14,2)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
          // Exit Loop
          if (true) {
            break;
          }
        } else if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      // * --- Select from imp_opefra
      m_cServer = m_Ctx.GetServer("imp_opefra");
      m_cPhName = m_Ctx.GetPhName("imp_opefra");
      if (Cursor_imp_opefra!=null)
        Cursor_imp_opefra.Close();
      Cursor_imp_opefra = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("imp_opefra")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_imp_opefra.Eof())) {
        /* cOpeProg1 := iif(Empty(imp_opefra->UNIQUECODE),Utilities.GetAutonumber('PFRAZIO1','',10),imp_opefra->UNIQUECODE) */
        cOpeProg1 = (CPLib.Empty(Cursor_imp_opefra.GetString("UNIQUECODE"))?Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PFRAZIO1","",10):Cursor_imp_opefra.GetString("UNIQUECODE"));
        /* cOpeProg2 := Utilities.GetAutonumber('PFRAZIO2','',11) */
        cOpeProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PFRAZIO2","",11);
        /* Case imp_opefra->FLAGLIRE='S' or imp_opefra->FLAGLIRE='1' or imp_opefra->FLAGLIRE='7' */
        if (CPLib.eqr(Cursor_imp_opefra.GetString("FLAGLIRE"),"S") || CPLib.eqr(Cursor_imp_opefra.GetString("FLAGLIRE"),"1") || CPLib.eqr(Cursor_imp_opefra.GetString("FLAGLIRE"),"7")) {
          /* cFlagLire := '1' */
          cFlagLire = "1";
          /* Case imp_opefra->FLAGLIRE='E' or imp_opefra->FLAGLIRE='3' or imp_opefra->FLAGLIRE='5' */
        } else if (CPLib.eqr(Cursor_imp_opefra.GetString("FLAGLIRE"),"E") || CPLib.eqr(Cursor_imp_opefra.GetString("FLAGLIRE"),"3") || CPLib.eqr(Cursor_imp_opefra.GetString("FLAGLIRE"),"5")) {
          /* If imp_opefra->FLAGLIRE = 'E' */
          if (CPLib.eqr(Cursor_imp_opefra.GetString("FLAGLIRE"),"E")) {
            /* cFlagLire := '3' */
            cFlagLire = "3";
          } else { // Else
            /* cFlagLire := imp_opefra->FLAGLIRE */
            cFlagLire = Cursor_imp_opefra.GetString("FLAGLIRE");
          } // End If
        } else { // Otherwise
          /* cFlagLire := imp_opefra->FLAGLIRE */
          cFlagLire = Cursor_imp_opefra.GetString("FLAGLIRE");
        } // End Case
        /* cFlagCont := iif(imp_opefra->FLAGCONT='1' or imp_opefra->FLAGCONT='S','1','0')  */
        cFlagCont = (CPLib.eqr(Cursor_imp_opefra.GetString("FLAGCONT"),"1") || CPLib.eqr(Cursor_imp_opefra.GetString("FLAGCONT"),"S")?"1":"0");
        /* cFlagFraz := iif(Empty(imp_opefra->FLAGFRAZ),'0',imp_opefra->FLAGFRAZ) */
        cFlagFraz = (CPLib.Empty(Cursor_imp_opefra.GetString("FLAGFRAZ"))?"0":Cursor_imp_opefra.GetString("FLAGFRAZ"));
        /* cIdCau := '' */
        cIdCau = "";
        // * --- Read from tbcauana
        m_cServer = m_Ctx.GetServer("tbcauana");
        m_cPhName = m_Ctx.GetPhName("tbcauana");
        m_cSql = "";
        m_cSql = m_cSql+"CODCAU="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_imp_opefra.GetString("CODANA"),"C",4,0,m_cServer),m_cServer,Cursor_imp_opefra.GetString("CODANA"));
        m_cSql = m_cSql+" and CAUSINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_imp_opefra.GetString("CODVOC"),"C",2,0,m_cServer),m_cServer,Cursor_imp_opefra.GetString("CODVOC"));
        if (m_Ctx.IsSharedTemp("tbcauana")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("idbase",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          cIdCau = Read_Cursor.GetString("idbase");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on tbcauana into routine arrt_imp_dati_multipli_old returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          cIdCau = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        // * --- Insert into fraziobo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("fraziobo");
        m_cPhName = m_Ctx.GetPhName("fraziobo");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"fraziobo")+" (";
        m_cSql = m_cSql+GetFieldsName_05E604F0(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(Cursor_imp_opefra.GetString("DATAOPE"),5,4)+CPLib.Substr(Cursor_imp_opefra.GetString("DATAOPE"),3,2)+CPLib.Substr(Cursor_imp_opefra.GetString("DATAOPE"),1,2)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("DATAOPE")+cOpeProg2+"O","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cFlagFraz,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cFlagCont,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CODANA"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("PAESE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("DESC2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("PROV2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(Cursor_imp_opefra.GetString("DATAREG"),5,4)+CPLib.Substr(Cursor_imp_opefra.GetString("DATAREG"),3,2)+CPLib.Substr(Cursor_imp_opefra.GetString("DATAREG"),1,2)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_imp_opefra.GetString("TOTLIRE")),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_imp_opefra.GetString("TOTCONT")),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_imp_opefra.GetString("CAMBIO")),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CAMBIO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cIdCau,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("AGOPER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("INFORM"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(Cursor_imp_opefra.GetString("DATAOPE"),5,4)+CPLib.Substr(Cursor_imp_opefra.GetString("DATAOPE"),3,2)+CPLib.Substr(Cursor_imp_opefra.GetString("DATAOPE"),1,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
        if (m_Ctx.IsSharedTemp("fraziobo")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"fraziobo",true);
        m_cSql = m_cSql+")";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_nUpdatedRows = 0;
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.lt(m_nUpdatedRows,1)) {
          // No rows inserted
          /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per l'operazione in data "+imp_opefra->DATAOPE+" con importo "+Str((Val(imp_opefra->TOTLIRE))/100,14,2)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
          w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per l'operazione in data "+Cursor_imp_opefra.GetString("DATAOPE")+" con importo "+CPLib.Str((CPLib.Val(Cursor_imp_opefra.GetString("TOTLIRE")))/100,14,2)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
          // Exit Loop
          if (true) {
            break;
          }
        } else if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        /* cNumNew := cNumNew + 1 */
        cNumNew = CPLib.Round(cNumNew+1,0);
        Cursor_imp_opefra.Next();
      }
      m_cConnectivityError = Cursor_imp_opefra.ErrorMessage();
      Cursor_imp_opefra.Close();
      // * --- End Select
      /* w_msgproc := w_msgproc + 'Frazionate Inserite: '+LRTrim(Str(cNumNew,10,0)) + NL */
      w_msgproc = w_msgproc+"Frazionate Inserite: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+"\n";
      /* w_msgproc := w_msgproc + 'Ora Fine Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Fine Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
    } finally {
      try {
        if (Cursor_imp_opefra!=null)
          Cursor_imp_opefra.Close();
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
  void Page_7() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* Legge il file di testo e porta i dati nella tabella */
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      /* cNumMod := 0 */
      cNumMod = CPLib.Round(0,0);
      /* w_msgproc := w_msgproc + 'Ora Inizio Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Inizio Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        // * --- Read from xnarapbo
        m_cServer = m_Ctx.GetServer("xnarapbo");
        m_cPhName = m_Ctx.GetPhName("xnarapbo");
        m_cSql = "";
        m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,25),"C",25,0,m_cServer),m_cServer,CPLib.Left(riga,25));
        if (m_Ctx.IsSharedTemp("xnarapbo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          xRapporto = Read_Cursor.GetString("RAPPORTO");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on xnarapbo into routine arrt_imp_dati_multipli_old returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          xRapporto = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If Empty(LRTrim(xRapporto)) */
        if (CPLib.Empty(CPLib.LRTrim(xRapporto))) {
          // * --- Insert into xnarapbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xnarapbo");
          m_cPhName = m_Ctx.GetPhName("xnarapbo");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"xnarapbo")+" (";
          m_cSql = m_cSql+GetFieldsName_07023738(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,25),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,26,50),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,76,1),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,77,1),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,78,3),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,81,2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,83,1)),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,84,5),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,89,5),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,94,5),"?",0,0,m_cServer)+", ";
          if (m_Ctx.IsSharedTemp("xnarapbo")) {
            m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
          }
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xnarapbo",true);
          m_cSql = m_cSql+")";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows inserted
            /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per il rapporto: "+Left(riga,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
            w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per il rapporto: "+CPLib.Left(riga,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            // Exit Loop
            if (true) {
              break;
            }
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          /* cNumNew := cNumNew + 1 */
          cNumNew = CPLib.Round(cNumNew+1,0);
        } else { // Else
          // * --- Write into xnarapbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xnarapbo");
          m_cPhName = m_Ctx.GetPhName("xnarapbo");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = "Update "+m_cPhName+" set ";
          m_cSql = m_cSql+"DESCRAP = "+CPLib.ToSQL(CPLib.Substr(riga,26,50),"C",50,0,m_cServer)+", ";
          m_cSql = m_cSql+"TIPORAP = "+CPLib.ToSQLNull(CPLib.Substr(riga,76,1),"C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"FLAGLIRE = "+CPLib.ToSQL(CPLib.Substr(riga,77,1),"C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"VALUTA = "+CPLib.ToSQLNull(CPLib.Substr(riga,78,3),"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"TIPOAG = "+CPLib.ToSQL(CPLib.Substr(riga,81,2),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"NOPROT = "+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,83,1)),"N",1,0)+", ";
          m_cSql = m_cSql+"RAGIO = "+CPLib.ToSQL(CPLib.Substr(riga,84,5),"C",5,0,m_cServer)+", ";
          m_cSql = m_cSql+"MODSVOL = "+CPLib.ToSQL(CPLib.Substr(riga,89,5),"C",5,0,m_cServer)+", ";
          m_cSql = m_cSql+"AREAGEO = "+CPLib.ToSQL(CPLib.Substr(riga,94,5),"C",5,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xnarapbo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(xRapporto,"?",0,0,m_cServer),m_cServer,xRapporto)+"";
          if (m_Ctx.IsSharedTemp("xnarapbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows updated
            /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per il rapporto: "+Left(riga,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
            w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per il rapporto: "+CPLib.Left(riga,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            // Exit Loop
            if (true) {
              break;
            }
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          /* cNumMod := cNumMod + 1 */
          cNumMod = CPLib.Round(cNumMod+1,0);
        } // End If
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* w_msgproc := w_msgproc + 'Rapporti Inseriti: '+LRTrim(Str(cNumNew,10,0)) + " - Rapporti Aggiornati: "+LRTrim(Str(cNumMod,10,0)) + NL */
      w_msgproc = w_msgproc+"Rapporti Inseriti: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+" - Rapporti Aggiornati: "+CPLib.LRTrim(CPLib.Str(cNumMod,10,0))+"\n";
      /* w_msgproc := w_msgproc + 'Ora Fine Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Fine Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_8() throws Exception {
    CPResultSet Cursor_imp_info=null;
    CPResultSet Cursor_xoginfo=null;
    CPResultSet Cursor_xntestbo=null;
    try {
      /* Legge il file di testo e porta i dati nella tabella */
      // * --- Drop temporary table imp_info
      if (m_Ctx.IsSharedTemp("imp_info")) {
        if (m_Ctx.IsTmpAlreadyCreated("imp_info")) {
          m_cServer = m_Ctx.GetServer("imp_info");
          m_cPhName = m_Ctx.GetPhName("imp_info");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("imp_info");
      }
      // * --- Create temporary table imp_info
      if (m_Ctx.IsSharedTemp("imp_info")) {
        if (m_Ctx.IsTmpAlreadyCreated("imp_info")) {
          m_cServer = m_Ctx.GetServer("imp_info");
          m_cPhName = m_Ctx.GetPhName("imp_info");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("imp_info");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("imp_info");
      if ( ! (m_Ctx.IsSharedTemp("imp_info"))) {
        m_cServer = m_Ctx.GetServer("imp_info");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("imp_info",m_cServer,"proto")),m_cPhName,"imp_info",m_Ctx,new String[]{"RAPPORTO,DATAOPE"});
      }
      m_cPhName_imp_info = m_cPhName;
      /* w_msgproc := w_msgproc + 'Ora Inizio Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Inizio Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        // * --- Insert into imp_info from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("imp_info");
        m_cPhName = m_Ctx.GetPhName("imp_info");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"imp_info")+" (";
        m_cSql = m_cSql+GetFieldsName_07CE0318(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,8),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,9,25),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,34,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,35,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,36,8),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,44,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,46,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,47,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,50,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,66,9),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,75,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,91,11),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,102,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,104,11),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,115,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,121,30),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,151,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,153,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,159,10),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,169,50),"?",0,0,m_cServer)+", ";
        if (m_Ctx.IsSharedTemp("imp_info")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"imp_info",true);
        m_cSql = m_cSql+")";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_nUpdatedRows = 0;
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.lt(m_nUpdatedRows,1)) {
          // No rows inserted
          /* w_msgproc := w_msgproc +"Rilevati errori in lettura del file "+nomefileimport+" per l'informazione in data "+Left(riga,8)+" relativa al rapporto: "+Substr(riga,9,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
          w_msgproc = w_msgproc+"Rilevati errori in lettura del file "+nomefileimport+" per l'informazione in data "+CPLib.Left(riga,8)+" relativa al rapporto: "+CPLib.Substr(riga,9,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
          // Exit Loop
          if (true) {
            break;
          }
        } else if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      // * --- Select from imp_info
      m_cServer = m_Ctx.GetServer("imp_info");
      m_cPhName = m_Ctx.GetPhName("imp_info");
      if (Cursor_imp_info!=null)
        Cursor_imp_info.Close();
      Cursor_imp_info = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("imp_info")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_imp_info.Eof())) {
        /* Case imp_info->FLAGLIRE='S' or imp_info->FLAGLIRE='1' or imp_info->FLAGLIRE='7' */
        if (CPLib.eqr(Cursor_imp_info.GetString("FLAGLIRE"),"S") || CPLib.eqr(Cursor_imp_info.GetString("FLAGLIRE"),"1") || CPLib.eqr(Cursor_imp_info.GetString("FLAGLIRE"),"7")) {
          /* cFlagLire := '1' */
          cFlagLire = "1";
          /* Case imp_info->FLAGLIRE='E' or imp_info->FLAGLIRE='3' or imp_info->FLAGLIRE='5' */
        } else if (CPLib.eqr(Cursor_imp_info.GetString("FLAGLIRE"),"E") || CPLib.eqr(Cursor_imp_info.GetString("FLAGLIRE"),"3") || CPLib.eqr(Cursor_imp_info.GetString("FLAGLIRE"),"5")) {
          /* If imp_info->FLAGLIRE = 'E' */
          if (CPLib.eqr(Cursor_imp_info.GetString("FLAGLIRE"),"E")) {
            /* cFlagLire := '3' */
            cFlagLire = "3";
          } else { // Else
            /* cFlagLire := imp_info->FLAGLIRE */
            cFlagLire = Cursor_imp_info.GetString("FLAGLIRE");
          } // End If
        } else { // Otherwise
          /* cFlagLire := imp_info->FLAGLIRE */
          cFlagLire = Cursor_imp_info.GetString("FLAGLIRE");
        } // End Case
        /* cInfProg1 := iif(Empty(imp_info->UNIQUECOD),Utilities.GetAutonumber('PRGPINFO1','',10),imp_info->UNIQUECOD) */
        cInfProg1 = (CPLib.Empty(Cursor_imp_info.GetString("UNIQUECOD"))?Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGPINFO1","",10):Cursor_imp_info.GetString("UNIQUECOD"));
        /* cInfProg2 := Utilities.GetAutonumber('PRGPINFO2','',11) */
        cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGPINFO2","",11);
        // * --- Insert into xapopebo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("xapopebo");
        m_cPhName = m_Ctx.GetPhName("xapopebo");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"xapopebo")+" (";
        m_cSql = m_cSql+GetFieldsName_0705BAC8(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(Cursor_imp_info.GetString("DATAOPE"),4)+CPLib.Substr(Cursor_imp_info.GetString("DATAOPE"),3,2)+CPLib.Left(Cursor_imp_info.GetString("DATAOPE"),2)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("DATAOPE")+Cursor_imp_info.GetString("NUMPROG")+"0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(Cursor_imp_info.GetString("DATAREG"),4)+CPLib.Substr(Cursor_imp_info.GetString("DATAREG"),3,2)+CPLib.Left(Cursor_imp_info.GetString("DATAREG"),2)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_imp_info.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_imp_info.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_imp_info.GetString("TIPOOPRAP"),1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cFlagLire,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_imp_info.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
        if (m_Ctx.IsSharedTemp("xapopebo")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xapopebo",true);
        m_cSql = m_cSql+")";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_nUpdatedRows = 0;
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.lt(m_nUpdatedRows,1)) {
          // No rows inserted
          /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per l'informazione in data "+imp_info->DATAOPE+" relativa al rapporto: "+imp_info->RAPPORTO+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
          w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per l'informazione in data "+Cursor_imp_info.GetString("DATAOPE")+" relativa al rapporto: "+Cursor_imp_info.GetString("RAPPORTO")+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
          // Exit Loop
          if (true) {
            break;
          }
        } else if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        /* If not(Empty(imp_info->CONNESOPER)) */
        if ( ! (CPLib.Empty(Cursor_imp_info.GetString("CONNESOPER")))) {
          /* cMaxRow := 0 */
          cMaxRow = CPLib.Round(0,0);
          // * --- Select from xoginfo
          m_cServer = m_Ctx.GetServer("xoginfo");
          m_cPhName = m_Ctx.GetPhName("xoginfo");
          if (Cursor_xoginfo!=null)
            Cursor_xoginfo.Close();
          Cursor_xoginfo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer, m_oParameters),m_cServer,cInfProg1)+" "+")"+(m_Ctx.IsSharedTemp("xoginfo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_xoginfo.Eof())) {
            /* cMaxRow := xoginfo->CPROWNUM */
            cMaxRow = CPLib.Round(Cursor_xoginfo.GetDouble("CPROWNUM"),0);
            Cursor_xoginfo.Next();
          }
          m_cConnectivityError = Cursor_xoginfo.ErrorMessage();
          Cursor_xoginfo.Close();
          // * --- End Select
          /* cMaxRow := cMaxRow + 1 */
          cMaxRow = CPLib.Round(cMaxRow+1,0);
          // * --- Insert into xoginfo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xoginfo");
          m_cPhName = m_Ctx.GetPhName("xoginfo");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"xoginfo")+" (";
          m_cSql = m_cSql+GetFieldsName_06F77E20(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_imp_info.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_imp_info.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          if (m_Ctx.IsSharedTemp("xoginfo")) {
            m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
          }
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xoginfo",true);
          m_cSql = m_cSql+")";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows inserted
            /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per la registrazione del soggetto operante dell'informazione in data "+imp_info->DATAOPE+" relativa al rapporto: "+imp_info->RAPPORTO+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
            w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per la registrazione del soggetto operante dell'informazione in data "+Cursor_imp_info.GetString("DATAOPE")+" relativa al rapporto: "+Cursor_imp_info.GetString("RAPPORTO")+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            // Exit Loop
            if (true) {
              break;
            }
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
        } // End If
        /* cMaxRow := 0 */
        cMaxRow = CPLib.Round(0,0);
        /* cNumMod := 0 */
        cNumMod = CPLib.Round(0,0);
        // * --- Select from xntestbo
        m_cServer = m_Ctx.GetServer("xntestbo");
        m_cPhName = m_Ctx.GetPhName("xntestbo");
        if (Cursor_xntestbo!=null)
          Cursor_xntestbo.Close();
        Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_imp_info.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM ",m_cServer,m_Ctx,true));
        while ( ! (Cursor_xntestbo.Eof())) {
          /* If imp_info->CODFISC=xntestbo->CODINTER */
          if (CPLib.eqr(Cursor_imp_info.GetString("CODFISC"),Cursor_xntestbo.GetString("CODINTER"))) {
            /* cNumMod := xntestbo->CPROWNUM */
            cNumMod = CPLib.Round(Cursor_xntestbo.GetDouble("CPROWNUM"),0);
          } // End If
          /* cMaxRow := xntestbo->CPROWNUM */
          cMaxRow = CPLib.Round(Cursor_xntestbo.GetDouble("CPROWNUM"),0);
          Cursor_xntestbo.Next();
        }
        m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
        Cursor_xntestbo.Close();
        // * --- End Select
        /* If cNumMod = 0 */
        if (CPLib.eqr(cNumMod,0)) {
          // * --- Insert into xntestbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xntestbo");
          m_cPhName = m_Ctx.GetPhName("xntestbo");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"xntestbo")+" (";
          m_cSql = m_cSql+GetFieldsName_070593B0(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow+1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(Cursor_imp_info.GetString("DATAOPE"),5,4)+CPLib.Substr(Cursor_imp_info.GetString("DATAOPE"),3,2)+CPLib.Substr(Cursor_imp_info.GetString("DATAOPE"),1,2)),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_imp_info.GetString("TIPOOPRAP"),"25") || CPLib.eqr(Cursor_imp_info.GetString("TIPOOPRAP"),"28")?"D":"P"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Left(CPLib.LRTrim(Cursor_imp_info.GetString("CODFISC"))+CPLib.Space(5),16),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("DATAOPE")+cInfProg2+"O","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(Cursor_imp_info.GetString("CODFISC"))+CPLib.Space(5),16),"?",0,0,m_cServer)+", ";
          if (m_Ctx.IsSharedTemp("xntestbo")) {
            m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
          }
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xntestbo",true);
          m_cSql = m_cSql+")";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows inserted
            /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario dell'informazione in data "+imp_info->DATAOPE+" relativa al rapporto: "+imp_info->RAPPORTO+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
            w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario dell'informazione in data "+Cursor_imp_info.GetString("DATAOPE")+" relativa al rapporto: "+Cursor_imp_info.GetString("RAPPORTO")+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            // Exit Loop
            if (true) {
              break;
            }
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
        } else { // Else
          /* If imp_info->TIPOOPRAP='23' */
          if (CPLib.eqr(Cursor_imp_info.GetString("TIPOOPRAP"),"23")) {
            // * --- Write into xntestbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xntestbo");
            m_cPhName = m_Ctx.GetPhName("xntestbo");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = "Update "+m_cPhName+" set ";
            m_cSql = m_cSql+"DATAINI = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(Cursor_imp_info.GetString("DATAOPE"),5,4)+CPLib.Substr(Cursor_imp_info.GetString("DATAOPE"),3,2)+CPLib.Substr(Cursor_imp_info.GetString("DATAOPE"),1,2)),"D",8,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xntestbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_imp_info.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_imp_info.GetString("RAPPORTO"))+"";
            m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cNumMod,"?",0,0,m_cServer),m_cServer,cNumMod)+"";
            if (m_Ctx.IsSharedTemp("xntestbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_nUpdatedRows = 0;
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.lt(m_nUpdatedRows,1)) {
              // No rows updated
              /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario dell'informazione in data "+imp_info->DATAOPE+" relativa al rapporto: "+imp_info->RAPPORTO+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
              w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario dell'informazione in data "+Cursor_imp_info.GetString("DATAOPE")+" relativa al rapporto: "+Cursor_imp_info.GetString("RAPPORTO")+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
              /* _esito := 1 */
              _esito = CPLib.Round(1,0);
              // Exit Loop
              if (true) {
                break;
              }
            } else if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
            /* ElseIf imp_info->TIPOOPRAP='26' */
          } else if (CPLib.eqr(Cursor_imp_info.GetString("TIPOOPRAP"),"26")) {
            // * --- Write into xntestbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xntestbo");
            m_cPhName = m_Ctx.GetPhName("xntestbo");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = "Update "+m_cPhName+" set ";
            m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(Cursor_imp_info.GetString("DATAOPE"),5,4)+CPLib.Substr(Cursor_imp_info.GetString("DATAOPE"),3,2)+CPLib.Substr(Cursor_imp_info.GetString("DATAOPE"),1,2)),"D",8,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xntestbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_imp_info.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_imp_info.GetString("RAPPORTO"))+"";
            m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cNumMod,"?",0,0,m_cServer),m_cServer,cNumMod)+"";
            if (m_Ctx.IsSharedTemp("xntestbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_nUpdatedRows = 0;
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.lt(m_nUpdatedRows,1)) {
              // No rows updated
              /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario dell'informazione in data "+imp_info->DATAOPE+" relativa al rapporto: "+imp_info->RAPPORTO+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
              w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario dell'informazione in data "+Cursor_imp_info.GetString("DATAOPE")+" relativa al rapporto: "+Cursor_imp_info.GetString("RAPPORTO")+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
              /* _esito := 1 */
              _esito = CPLib.Round(1,0);
              // Exit Loop
              if (true) {
                break;
              }
            } else if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
          } // End If
        } // End If
        /* cNumNew := cNumNew + 1 */
        cNumNew = CPLib.Round(cNumNew+1,0);
        Cursor_imp_info.Next();
      }
      m_cConnectivityError = Cursor_imp_info.ErrorMessage();
      Cursor_imp_info.Close();
      // * --- End Select
      /* w_msgproc := w_msgproc + 'Informazione Inserite: '+LRTrim(Str(cNumNew,10,0)) + NL */
      w_msgproc = w_msgproc+"Informazione Inserite: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+"\n";
      /* w_msgproc := w_msgproc + 'Ora Fine Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Fine Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
    } finally {
      try {
        if (Cursor_imp_info!=null)
          Cursor_imp_info.Close();
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
        if (Cursor_xntestbo!=null)
          Cursor_xntestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_9() throws Exception {
    CPResultSet Cursor_imp_opefra=null;
    CPResultSet Read_Cursor=null;
    try {
      /* Legge il file di testo e porta i dati nella tabella */
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      // * --- Drop temporary table imp_opefra
      if (m_Ctx.IsSharedTemp("imp_opefra")) {
        if (m_Ctx.IsTmpAlreadyCreated("imp_opefra")) {
          m_cServer = m_Ctx.GetServer("imp_opefra");
          m_cPhName = m_Ctx.GetPhName("imp_opefra");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("imp_opefra");
      }
      // * --- Create temporary table imp_opefra
      if (m_Ctx.IsSharedTemp("imp_opefra")) {
        if (m_Ctx.IsTmpAlreadyCreated("imp_opefra")) {
          m_cServer = m_Ctx.GetServer("imp_opefra");
          m_cPhName = m_Ctx.GetPhName("imp_opefra");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("imp_opefra");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("imp_opefra");
      if ( ! (m_Ctx.IsSharedTemp("imp_opefra"))) {
        m_cServer = m_Ctx.GetServer("imp_opefra");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("imp_opefra",m_cServer,"proto")),m_cPhName,"imp_opefra",m_Ctx,new String[]{"RAPPORTO,DATAOPE"});
      }
      m_cPhName_imp_opefra = m_cPhName;
      /* w_msgproc := w_msgproc + 'Ora Inizio Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Inizio Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        // * --- Insert into imp_opefra from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("imp_opefra");
        m_cPhName = m_Ctx.GetPhName("imp_opefra");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"imp_opefra")+" (";
        m_cSql = m_cSql+GetFieldsName_05E9DE28(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,8),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,9,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,10,4),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,14,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,16,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,18,11),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,29,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,32,30),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,62,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,64,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,70,50),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,120,25),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,145,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,146,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,147,8),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,155,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,156,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,159,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,160,15),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,175,15),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,190,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,206,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,222,9),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,231,11),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,242,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,244,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,246,11),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,257,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,263,30),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,293,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,295,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,301,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,302,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,318,10),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,328,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,331,9),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,340,69),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,409,5),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,414,5),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,419,5),"?",0,0,m_cServer)+", ";
        if (m_Ctx.IsSharedTemp("imp_opefra")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"imp_opefra",true);
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
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      // * --- Select from imp_opefra
      m_cServer = m_Ctx.GetServer("imp_opefra");
      m_cPhName = m_Ctx.GetPhName("imp_opefra");
      if (Cursor_imp_opefra!=null)
        Cursor_imp_opefra.Close();
      Cursor_imp_opefra = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("imp_opefra")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_imp_opefra.Eof())) {
        /* cOpeProg1 := iif(Empty(imp_opefra->UNIQUECODE),Utilities.GetAutonumber('PPOPER1','',10),imp_opefra->UNIQUECODE) */
        cOpeProg1 = (CPLib.Empty(Cursor_imp_opefra.GetString("UNIQUECODE"))?Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PPOPER1","",10):Cursor_imp_opefra.GetString("UNIQUECODE"));
        /* cOpeProg2 := Utilities.GetAutonumber('PPOPER2','',11) */
        cOpeProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PPOPER2","",11);
        /* Case imp_opefra->FLAGLIRE='S' or imp_opefra->FLAGLIRE='1' or imp_opefra->FLAGLIRE='7' */
        if (CPLib.eqr(Cursor_imp_opefra.GetString("FLAGLIRE"),"S") || CPLib.eqr(Cursor_imp_opefra.GetString("FLAGLIRE"),"1") || CPLib.eqr(Cursor_imp_opefra.GetString("FLAGLIRE"),"7")) {
          /* cFlagLire := '1' */
          cFlagLire = "1";
          /* Case imp_opefra->FLAGLIRE='E' or imp_opefra->FLAGLIRE='3' or imp_opefra->FLAGLIRE='5' */
        } else if (CPLib.eqr(Cursor_imp_opefra.GetString("FLAGLIRE"),"E") || CPLib.eqr(Cursor_imp_opefra.GetString("FLAGLIRE"),"3") || CPLib.eqr(Cursor_imp_opefra.GetString("FLAGLIRE"),"5")) {
          /* If imp_opefra->FLAGLIRE = 'E' */
          if (CPLib.eqr(Cursor_imp_opefra.GetString("FLAGLIRE"),"E")) {
            /* cFlagLire := '3' */
            cFlagLire = "3";
          } else { // Else
            /* cFlagLire := imp_opefra->FLAGLIRE */
            cFlagLire = Cursor_imp_opefra.GetString("FLAGLIRE");
          } // End If
        } else { // Otherwise
          /* cFlagLire := imp_opefra->FLAGLIRE */
          cFlagLire = Cursor_imp_opefra.GetString("FLAGLIRE");
        } // End Case
        /* cFlagCont := iif(imp_opefra->FLAGCONT='1' or imp_opefra->FLAGCONT='S','1','0')  */
        cFlagCont = (CPLib.eqr(Cursor_imp_opefra.GetString("FLAGCONT"),"1") || CPLib.eqr(Cursor_imp_opefra.GetString("FLAGCONT"),"S")?"1":"0");
        /* cFlagFraz := iif(Empty(imp_opefra->FLAGFRAZ),'0',imp_opefra->FLAGFRAZ) */
        cFlagFraz = (CPLib.Empty(Cursor_imp_opefra.GetString("FLAGFRAZ"))?"0":Cursor_imp_opefra.GetString("FLAGFRAZ"));
        /* cIdCau := '' */
        cIdCau = "";
        // * --- Read from tbcauana
        m_cServer = m_Ctx.GetServer("tbcauana");
        m_cPhName = m_Ctx.GetPhName("tbcauana");
        m_cSql = "";
        m_cSql = m_cSql+"CODCAU="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_imp_opefra.GetString("CODANA"),"C",4,0,m_cServer),m_cServer,Cursor_imp_opefra.GetString("CODANA"));
        m_cSql = m_cSql+" and CAUSINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_imp_opefra.GetString("CODVOC"),"C",2,0,m_cServer),m_cServer,Cursor_imp_opefra.GetString("CODVOC"));
        if (m_Ctx.IsSharedTemp("tbcauana")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("idbase",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          cIdCau = Read_Cursor.GetString("idbase");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on tbcauana into routine arrt_imp_dati_multipli_old returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          cIdCau = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        // * --- Insert into xperazbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("xperazbo");
        m_cPhName = m_Ctx.GetPhName("xperazbo");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"xperazbo")+" (";
        m_cSql = m_cSql+GetFieldsName_062ED208(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(Cursor_imp_opefra.GetString("DATAOPE"),5,4)+CPLib.Substr(Cursor_imp_opefra.GetString("DATAOPE"),3,2)+CPLib.Substr(Cursor_imp_opefra.GetString("DATAOPE"),1,2)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("DATAOPE")+cOpeProg2+"O","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cFlagFraz,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cFlagCont,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CODANA"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("PAESE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("DESC2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("PROV2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(Cursor_imp_opefra.GetString("DATAREG"),5,4)+CPLib.Substr(Cursor_imp_opefra.GetString("DATAREG"),3,2)+CPLib.Substr(Cursor_imp_opefra.GetString("DATAREG"),1,2)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_imp_opefra.GetString("TOTLIRE")),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_imp_opefra.GetString("TOTCONT")),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_imp_opefra.GetString("CAMBIO")),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CAMBIO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cIdCau,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("AGOPER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("INFORM"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(Cursor_imp_opefra.GetString("DATAOPE"),5,4)+CPLib.Substr(Cursor_imp_opefra.GetString("DATAOPE"),3,2)+CPLib.Substr(Cursor_imp_opefra.GetString("DATAOPE"),1,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
        if (m_Ctx.IsSharedTemp("xperazbo")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xperazbo",true);
        m_cSql = m_cSql+")";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_nUpdatedRows = 0;
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.lt(m_nUpdatedRows,1)) {
          // No rows inserted
          /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per l'operazione in data "+imp_opefra->DATAOPE+" con importo "+Str((Val(imp_opefra->TOTLIRE))/100,14,2)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
          w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per l'operazione in data "+Cursor_imp_opefra.GetString("DATAOPE")+" con importo "+CPLib.Str((CPLib.Val(Cursor_imp_opefra.GetString("TOTLIRE")))/100,14,2)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
          // Exit Loop
          if (true) {
            break;
          }
        } else if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        /* cNumNew := cNumNew + 1 */
        cNumNew = CPLib.Round(cNumNew+1,0);
        Cursor_imp_opefra.Next();
      }
      m_cConnectivityError = Cursor_imp_opefra.ErrorMessage();
      Cursor_imp_opefra.Close();
      // * --- End Select
      /* w_msgproc := w_msgproc + 'Operazioni Inserite: '+LRTrim(Str(cNumNew,10,0)) + NL */
      w_msgproc = w_msgproc+"Operazioni Inserite: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+"\n";
      /* w_msgproc := w_msgproc + 'Ora Fine Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Fine Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
    } finally {
      try {
        if (Cursor_imp_opefra!=null)
          Cursor_imp_opefra.Close();
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
  void Page_10() throws Exception {
    CPResultSet Cursor_imp_opefra=null;
    CPResultSet Read_Cursor=null;
    try {
      /* Legge il file di testo e porta i dati nella tabella */
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      // * --- Drop temporary table imp_opefra
      if (m_Ctx.IsSharedTemp("imp_opefra")) {
        if (m_Ctx.IsTmpAlreadyCreated("imp_opefra")) {
          m_cServer = m_Ctx.GetServer("imp_opefra");
          m_cPhName = m_Ctx.GetPhName("imp_opefra");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("imp_opefra");
      }
      // * --- Create temporary table imp_opefra
      if (m_Ctx.IsSharedTemp("imp_opefra")) {
        if (m_Ctx.IsTmpAlreadyCreated("imp_opefra")) {
          m_cServer = m_Ctx.GetServer("imp_opefra");
          m_cPhName = m_Ctx.GetPhName("imp_opefra");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("imp_opefra");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("imp_opefra");
      if ( ! (m_Ctx.IsSharedTemp("imp_opefra"))) {
        m_cServer = m_Ctx.GetServer("imp_opefra");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("imp_opefra",m_cServer,"proto")),m_cPhName,"imp_opefra",m_Ctx,new String[]{"RAPPORTO,DATAOPE"});
      }
      m_cPhName_imp_opefra = m_cPhName;
      /* w_msgproc := w_msgproc + 'Ora Inizio Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Inizio Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        // * --- Insert into imp_opefra from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("imp_opefra");
        m_cPhName = m_Ctx.GetPhName("imp_opefra");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"imp_opefra")+" (";
        m_cSql = m_cSql+GetFieldsName_0704A600(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,8),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,9,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,10,4),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,14,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,16,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,18,11),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,29,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,32,30),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,62,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,64,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,70,50),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,120,25),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,145,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,146,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,147,8),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,155,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,156,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,159,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,160,15),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,175,15),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,190,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,206,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,222,9),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,231,11),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,242,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,244,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,246,11),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,257,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,263,30),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,293,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,295,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,301,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,302,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,318,10),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,328,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,331,9),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,340,69),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,409,5),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,414,5),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,419,5),"?",0,0,m_cServer)+", ";
        if (m_Ctx.IsSharedTemp("imp_opefra")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"imp_opefra",true);
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
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      // * --- Select from imp_opefra
      m_cServer = m_Ctx.GetServer("imp_opefra");
      m_cPhName = m_Ctx.GetPhName("imp_opefra");
      if (Cursor_imp_opefra!=null)
        Cursor_imp_opefra.Close();
      Cursor_imp_opefra = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("imp_opefra")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_imp_opefra.Eof())) {
        /* cOpeProg1 := iif(Empty(imp_opefra->UNIQUECODE),Utilities.GetAutonumber('PPFRAZ1','',10),imp_opefra->UNIQUECODE) */
        cOpeProg1 = (CPLib.Empty(Cursor_imp_opefra.GetString("UNIQUECODE"))?Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PPFRAZ1","",10):Cursor_imp_opefra.GetString("UNIQUECODE"));
        /* cOpeProg2 := Utilities.GetAutonumber('PPFRAZ2','',11) */
        cOpeProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PPFRAZ2","",11);
        /* Case imp_opefra->FLAGLIRE='S' or imp_opefra->FLAGLIRE='1' or imp_opefra->FLAGLIRE='7' */
        if (CPLib.eqr(Cursor_imp_opefra.GetString("FLAGLIRE"),"S") || CPLib.eqr(Cursor_imp_opefra.GetString("FLAGLIRE"),"1") || CPLib.eqr(Cursor_imp_opefra.GetString("FLAGLIRE"),"7")) {
          /* cFlagLire := '1' */
          cFlagLire = "1";
          /* Case imp_opefra->FLAGLIRE='E' or imp_opefra->FLAGLIRE='3' or imp_opefra->FLAGLIRE='5' */
        } else if (CPLib.eqr(Cursor_imp_opefra.GetString("FLAGLIRE"),"E") || CPLib.eqr(Cursor_imp_opefra.GetString("FLAGLIRE"),"3") || CPLib.eqr(Cursor_imp_opefra.GetString("FLAGLIRE"),"5")) {
          /* If imp_opefra->FLAGLIRE = 'E' */
          if (CPLib.eqr(Cursor_imp_opefra.GetString("FLAGLIRE"),"E")) {
            /* cFlagLire := '3' */
            cFlagLire = "3";
          } else { // Else
            /* cFlagLire := imp_opefra->FLAGLIRE */
            cFlagLire = Cursor_imp_opefra.GetString("FLAGLIRE");
          } // End If
        } else { // Otherwise
          /* cFlagLire := imp_opefra->FLAGLIRE */
          cFlagLire = Cursor_imp_opefra.GetString("FLAGLIRE");
        } // End Case
        /* cFlagCont := iif(imp_opefra->FLAGCONT='1' or imp_opefra->FLAGCONT='S','1','0')  */
        cFlagCont = (CPLib.eqr(Cursor_imp_opefra.GetString("FLAGCONT"),"1") || CPLib.eqr(Cursor_imp_opefra.GetString("FLAGCONT"),"S")?"1":"0");
        /* cFlagFraz := iif(Empty(imp_opefra->FLAGFRAZ),'0',imp_opefra->FLAGFRAZ) */
        cFlagFraz = (CPLib.Empty(Cursor_imp_opefra.GetString("FLAGFRAZ"))?"0":Cursor_imp_opefra.GetString("FLAGFRAZ"));
        /* cIdCau := '' */
        cIdCau = "";
        // * --- Read from tbcauana
        m_cServer = m_Ctx.GetServer("tbcauana");
        m_cPhName = m_Ctx.GetPhName("tbcauana");
        m_cSql = "";
        m_cSql = m_cSql+"CODCAU="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_imp_opefra.GetString("CODANA"),"C",4,0,m_cServer),m_cServer,Cursor_imp_opefra.GetString("CODANA"));
        m_cSql = m_cSql+" and CAUSINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_imp_opefra.GetString("CODVOC"),"C",2,0,m_cServer),m_cServer,Cursor_imp_opefra.GetString("CODVOC"));
        if (m_Ctx.IsSharedTemp("tbcauana")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("idbase",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          cIdCau = Read_Cursor.GetString("idbase");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on tbcauana into routine arrt_imp_dati_multipli_old returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          cIdCau = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        // * --- Insert into xraziobo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("xraziobo");
        m_cPhName = m_Ctx.GetPhName("xraziobo");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"xraziobo")+" (";
        m_cSql = m_cSql+GetFieldsName_07BE7D70(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(Cursor_imp_opefra.GetString("DATAOPE"),5,4)+CPLib.Substr(Cursor_imp_opefra.GetString("DATAOPE"),3,2)+CPLib.Substr(Cursor_imp_opefra.GetString("DATAOPE"),1,2)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("DATAOPE")+cOpeProg2+"O","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cFlagFraz,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cFlagCont,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CODANA"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("PAESE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("DESC2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("PROV2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(Cursor_imp_opefra.GetString("DATAREG"),5,4)+CPLib.Substr(Cursor_imp_opefra.GetString("DATAREG"),3,2)+CPLib.Substr(Cursor_imp_opefra.GetString("DATAREG"),1,2)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_imp_opefra.GetString("TOTLIRE")),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_imp_opefra.GetString("TOTCONT")),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_imp_opefra.GetString("CAMBIO")),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CAMBIO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cIdCau,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("AGOPER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("INFORM"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(Cursor_imp_opefra.GetString("DATAOPE"),5,4)+CPLib.Substr(Cursor_imp_opefra.GetString("DATAOPE"),3,2)+CPLib.Substr(Cursor_imp_opefra.GetString("DATAOPE"),1,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
        if (m_Ctx.IsSharedTemp("xraziobo")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xraziobo",true);
        m_cSql = m_cSql+")";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_nUpdatedRows = 0;
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.lt(m_nUpdatedRows,1)) {
          // No rows inserted
          /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per l'operazione in data "+imp_opefra->DATAOPE+" con importo "+Str((Val(imp_opefra->TOTLIRE))/100,14,2)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
          w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per l'operazione in data "+Cursor_imp_opefra.GetString("DATAOPE")+" con importo "+CPLib.Str((CPLib.Val(Cursor_imp_opefra.GetString("TOTLIRE")))/100,14,2)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
          // Exit Loop
          if (true) {
            break;
          }
        } else if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        /* cNumNew := cNumNew + 1 */
        cNumNew = CPLib.Round(cNumNew+1,0);
        Cursor_imp_opefra.Next();
      }
      m_cConnectivityError = Cursor_imp_opefra.ErrorMessage();
      Cursor_imp_opefra.Close();
      // * --- End Select
      /* w_msgproc := w_msgproc + 'Frazionate Inserite: '+LRTrim(Str(cNumNew,10,0)) + NL */
      w_msgproc = w_msgproc+"Frazionate Inserite: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+"\n";
      /* w_msgproc := w_msgproc + 'Ora Fine Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Fine Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
    } finally {
      try {
        if (Cursor_imp_opefra!=null)
          Cursor_imp_opefra.Close();
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
  void Page_11() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* Legge il file di testo e porta i dati nella tabella */
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      /* cNumMod := 0 */
      cNumMod = CPLib.Round(0,0);
      /* w_msgproc := w_msgproc + 'Ora Inizio Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Inizio Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        // * --- Read from jnarapbo
        m_cServer = m_Ctx.GetServer("jnarapbo");
        m_cPhName = m_Ctx.GetPhName("jnarapbo");
        m_cSql = "";
        m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,25),"C",25,0,m_cServer),m_cServer,CPLib.Left(riga,25));
        if (m_Ctx.IsSharedTemp("jnarapbo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          xRapporto = Read_Cursor.GetString("RAPPORTO");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on jnarapbo into routine arrt_imp_dati_multipli_old returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          xRapporto = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If Empty(LRTrim(xRapporto)) */
        if (CPLib.Empty(CPLib.LRTrim(xRapporto))) {
          // * --- Insert into jnarapbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("jnarapbo");
          m_cPhName = m_Ctx.GetPhName("jnarapbo");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"jnarapbo")+" (";
          m_cSql = m_cSql+GetFieldsName_05B676B8(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,25),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,26,50),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,76,1),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,77,1),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,78,3),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,81,2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,83,1)),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,84,5),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,89,5),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,94,5),"?",0,0,m_cServer)+", ";
          if (m_Ctx.IsSharedTemp("jnarapbo")) {
            m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
          }
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"jnarapbo",true);
          m_cSql = m_cSql+")";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows inserted
            /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per il rapporto: "+Left(riga,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
            w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per il rapporto: "+CPLib.Left(riga,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            // Exit Loop
            if (true) {
              break;
            }
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          /* cNumNew := cNumNew + 1 */
          cNumNew = CPLib.Round(cNumNew+1,0);
        } else { // Else
          // * --- Write into jnarapbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("jnarapbo");
          m_cPhName = m_Ctx.GetPhName("jnarapbo");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = "Update "+m_cPhName+" set ";
          m_cSql = m_cSql+"DESCRAP = "+CPLib.ToSQL(CPLib.Substr(riga,26,50),"C",50,0,m_cServer)+", ";
          m_cSql = m_cSql+"TIPORAP = "+CPLib.ToSQL(CPLib.Substr(riga,76,1),"C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"FLAGLIRE = "+CPLib.ToSQL(CPLib.Substr(riga,77,1),"C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"VALUTA = "+CPLib.ToSQL(CPLib.Substr(riga,78,3),"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"TIPOAG = "+CPLib.ToSQL(CPLib.Substr(riga,81,2),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"NOPROT = "+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,83,1)),"N",1,0)+", ";
          m_cSql = m_cSql+"RAGIO = "+CPLib.ToSQL(CPLib.Substr(riga,84,5),"C",5,0,m_cServer)+", ";
          m_cSql = m_cSql+"MODSVOL = "+CPLib.ToSQL(CPLib.Substr(riga,89,5),"C",5,0,m_cServer)+", ";
          m_cSql = m_cSql+"AREAGEO = "+CPLib.ToSQL(CPLib.Substr(riga,94,5),"C",5,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jnarapbo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(xRapporto,"?",0,0,m_cServer),m_cServer,xRapporto)+"";
          if (m_Ctx.IsSharedTemp("jnarapbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows updated
            /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per il rapporto: "+Left(riga,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
            w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per il rapporto: "+CPLib.Left(riga,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            // Exit Loop
            if (true) {
              break;
            }
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          /* cNumMod := cNumMod + 1 */
          cNumMod = CPLib.Round(cNumMod+1,0);
        } // End If
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* w_msgproc := w_msgproc + 'Rapporti AGE Inseriti: '+LRTrim(Str(cNumNew,10,0)) + " - Rapporti AGE Aggiornati: "+LRTrim(Str(cNumMod,10,0)) + NL */
      w_msgproc = w_msgproc+"Rapporti AGE Inseriti: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+" - Rapporti AGE Aggiornati: "+CPLib.LRTrim(CPLib.Str(cNumMod,10,0))+"\n";
      /* w_msgproc := w_msgproc + 'Ora Fine Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Fine Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_12() throws Exception {
    CPResultSet Cursor_imp_info=null;
    CPResultSet Cursor_joginfo=null;
    CPResultSet Cursor_jntestbo=null;
    try {
      /* Legge il file di testo e porta i dati nella tabella */
      // * --- Drop temporary table imp_info
      if (m_Ctx.IsSharedTemp("imp_info")) {
        if (m_Ctx.IsTmpAlreadyCreated("imp_info")) {
          m_cServer = m_Ctx.GetServer("imp_info");
          m_cPhName = m_Ctx.GetPhName("imp_info");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("imp_info");
      }
      // * --- Create temporary table imp_info
      if (m_Ctx.IsSharedTemp("imp_info")) {
        if (m_Ctx.IsTmpAlreadyCreated("imp_info")) {
          m_cServer = m_Ctx.GetServer("imp_info");
          m_cPhName = m_Ctx.GetPhName("imp_info");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("imp_info");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("imp_info");
      if ( ! (m_Ctx.IsSharedTemp("imp_info"))) {
        m_cServer = m_Ctx.GetServer("imp_info");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("imp_info",m_cServer,"proto")),m_cPhName,"imp_info",m_Ctx,new String[]{"RAPPORTO,DATAOPE"});
      }
      m_cPhName_imp_info = m_cPhName;
      /* w_msgproc := w_msgproc + 'Ora Inizio Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Inizio Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        // * --- Insert into imp_info from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("imp_info");
        m_cPhName = m_Ctx.GetPhName("imp_info");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"imp_info")+" (";
        m_cSql = m_cSql+GetFieldsName_06DFC1F0(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,8),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,9,25),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,34,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,35,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,36,8),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,44,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,46,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,47,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,50,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,66,9),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,75,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,91,11),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,102,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,104,11),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,115,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,121,30),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,151,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,153,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,159,10),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,169,50),"?",0,0,m_cServer)+", ";
        if (m_Ctx.IsSharedTemp("imp_info")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"imp_info",true);
        m_cSql = m_cSql+")";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_nUpdatedRows = 0;
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.lt(m_nUpdatedRows,1)) {
          // No rows inserted
          /* w_msgproc := w_msgproc +"Rilevati errori in lettura del file "+nomefileimport+" per l'informazione in data "+Left(riga,8)+" relativa al rapporto: "+Substr(riga,9,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
          w_msgproc = w_msgproc+"Rilevati errori in lettura del file "+nomefileimport+" per l'informazione in data "+CPLib.Left(riga,8)+" relativa al rapporto: "+CPLib.Substr(riga,9,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
          // Exit Loop
          if (true) {
            break;
          }
        } else if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      // * --- Select from imp_info
      m_cServer = m_Ctx.GetServer("imp_info");
      m_cPhName = m_Ctx.GetPhName("imp_info");
      if (Cursor_imp_info!=null)
        Cursor_imp_info.Close();
      Cursor_imp_info = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("imp_info")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_imp_info.Eof())) {
        /* Case imp_info->FLAGLIRE='S' or imp_info->FLAGLIRE='1' or imp_info->FLAGLIRE='7' */
        if (CPLib.eqr(Cursor_imp_info.GetString("FLAGLIRE"),"S") || CPLib.eqr(Cursor_imp_info.GetString("FLAGLIRE"),"1") || CPLib.eqr(Cursor_imp_info.GetString("FLAGLIRE"),"7")) {
          /* cFlagLire := '1' */
          cFlagLire = "1";
          /* Case imp_info->FLAGLIRE='E' or imp_info->FLAGLIRE='3' or imp_info->FLAGLIRE='5' */
        } else if (CPLib.eqr(Cursor_imp_info.GetString("FLAGLIRE"),"E") || CPLib.eqr(Cursor_imp_info.GetString("FLAGLIRE"),"3") || CPLib.eqr(Cursor_imp_info.GetString("FLAGLIRE"),"5")) {
          /* If imp_info->FLAGLIRE = 'E' */
          if (CPLib.eqr(Cursor_imp_info.GetString("FLAGLIRE"),"E")) {
            /* cFlagLire := '3' */
            cFlagLire = "3";
          } else { // Else
            /* cFlagLire := imp_info->FLAGLIRE */
            cFlagLire = Cursor_imp_info.GetString("FLAGLIRE");
          } // End If
        } else { // Otherwise
          /* cFlagLire := imp_info->FLAGLIRE */
          cFlagLire = Cursor_imp_info.GetString("FLAGLIRE");
        } // End Case
        /* cInfProg1 := iif(Empty(imp_info->UNIQUECOD),Utilities.GetAutonumber('PRGINFO1','',10),imp_info->UNIQUECOD) */
        cInfProg1 = (CPLib.Empty(Cursor_imp_info.GetString("UNIQUECOD"))?Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO1","",10):Cursor_imp_info.GetString("UNIQUECOD"));
        /* cInfProg2 := Utilities.GetAutonumber('PRGINFO2','',11) */
        cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO2","",11);
        // * --- Insert into japopebo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("japopebo");
        m_cPhName = m_Ctx.GetPhName("japopebo");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"japopebo")+" (";
        m_cSql = m_cSql+GetFieldsName_06EA51F8(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(Cursor_imp_info.GetString("DATAOPE"),4)+CPLib.Substr(Cursor_imp_info.GetString("DATAOPE"),3,2)+CPLib.Left(Cursor_imp_info.GetString("DATAOPE"),2)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("DATAOPE")+Cursor_imp_info.GetString("NUMPROG")+"0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(Cursor_imp_info.GetString("DATAREG"),4)+CPLib.Substr(Cursor_imp_info.GetString("DATAREG"),3,2)+CPLib.Left(Cursor_imp_info.GetString("DATAREG"),2)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_imp_info.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_imp_info.GetString("TIPOOPRAP"),1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cFlagLire,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
        if (m_Ctx.IsSharedTemp("japopebo")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"japopebo",true);
        m_cSql = m_cSql+")";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_nUpdatedRows = 0;
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.lt(m_nUpdatedRows,1)) {
          // No rows inserted
          /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per l'informazione in data "+imp_info->DATAOPE+" relativa al rapporto: "+imp_info->RAPPORTO+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
          w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per l'informazione in data "+Cursor_imp_info.GetString("DATAOPE")+" relativa al rapporto: "+Cursor_imp_info.GetString("RAPPORTO")+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
          // Exit Loop
          if (true) {
            break;
          }
        } else if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        /* If not(Empty(imp_info->CONNESOPER)) */
        if ( ! (CPLib.Empty(Cursor_imp_info.GetString("CONNESOPER")))) {
          /* cMaxRow := 0 */
          cMaxRow = CPLib.Round(0,0);
          // * --- Select from joginfo
          m_cServer = m_Ctx.GetServer("joginfo");
          m_cPhName = m_Ctx.GetPhName("joginfo");
          if (Cursor_joginfo!=null)
            Cursor_joginfo.Close();
          Cursor_joginfo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer, m_oParameters),m_cServer,cInfProg1)+" "+")"+(m_Ctx.IsSharedTemp("joginfo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_joginfo.Eof())) {
            /* cMaxRow := joginfo->CPROWNUM */
            cMaxRow = CPLib.Round(Cursor_joginfo.GetDouble("CPROWNUM"),0);
            Cursor_joginfo.Next();
          }
          m_cConnectivityError = Cursor_joginfo.ErrorMessage();
          Cursor_joginfo.Close();
          // * --- End Select
          /* cMaxRow := cMaxRow + 1 */
          cMaxRow = CPLib.Round(cMaxRow+1,0);
          // * --- Insert into joginfo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("joginfo");
          m_cPhName = m_Ctx.GetPhName("joginfo");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"joginfo")+" (";
          m_cSql = m_cSql+GetFieldsName_06DB8FB8(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          if (m_Ctx.IsSharedTemp("joginfo")) {
            m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
          }
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"joginfo",true);
          m_cSql = m_cSql+")";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows inserted
            /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per la registrazione del soggetto operante dell'informazione in data "+imp_info->DATAOPE+" relativa al rapporto: "+imp_info->RAPPORTO+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
            w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per la registrazione del soggetto operante dell'informazione in data "+Cursor_imp_info.GetString("DATAOPE")+" relativa al rapporto: "+Cursor_imp_info.GetString("RAPPORTO")+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            // Exit Loop
            if (true) {
              break;
            }
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
        } // End If
        /* cMaxRow := 0 */
        cMaxRow = CPLib.Round(0,0);
        /* cNumMod := 0 */
        cNumMod = CPLib.Round(0,0);
        // * --- Select from jntestbo
        m_cServer = m_Ctx.GetServer("jntestbo");
        m_cPhName = m_Ctx.GetPhName("jntestbo");
        if (Cursor_jntestbo!=null)
          Cursor_jntestbo.Close();
        Cursor_jntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_imp_info.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("jntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM ",m_cServer,m_Ctx,true));
        while ( ! (Cursor_jntestbo.Eof())) {
          /* If imp_info->CODFISC=jntestbo->CODINTER */
          if (CPLib.eqr(Cursor_imp_info.GetString("CODFISC"),Cursor_jntestbo.GetString("CODINTER"))) {
            /* cNumMod := jntestbo->CPROWNUM */
            cNumMod = CPLib.Round(Cursor_jntestbo.GetDouble("CPROWNUM"),0);
          } // End If
          /* cMaxRow := jntestbo->CPROWNUM */
          cMaxRow = CPLib.Round(Cursor_jntestbo.GetDouble("CPROWNUM"),0);
          Cursor_jntestbo.Next();
        }
        m_cConnectivityError = Cursor_jntestbo.ErrorMessage();
        Cursor_jntestbo.Close();
        // * --- End Select
        /* If cNumMod = 0 */
        if (CPLib.eqr(cNumMod,0)) {
          // * --- Insert into jntestbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("jntestbo");
          m_cPhName = m_Ctx.GetPhName("jntestbo");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"jntestbo")+" (";
          m_cSql = m_cSql+GetFieldsName_06EE4A40(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow+1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(Cursor_imp_info.GetString("DATAOPE"),5,4)+CPLib.Substr(Cursor_imp_info.GetString("DATAOPE"),3,2)+CPLib.Substr(Cursor_imp_info.GetString("DATAOPE"),1,2)),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_imp_info.GetString("TIPOOPRAP"),"25") || CPLib.eqr(Cursor_imp_info.GetString("TIPOOPRAP"),"28")?"D":"P"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(Cursor_imp_info.GetString("CODFISC"))+CPLib.Space(5),16),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_info.GetString("DATAOPE")+cInfProg2+"O","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(Cursor_imp_info.GetString("CODFISC"))+CPLib.Space(5),16),"?",0,0,m_cServer)+", ";
          if (m_Ctx.IsSharedTemp("jntestbo")) {
            m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
          }
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"jntestbo",true);
          m_cSql = m_cSql+")";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows inserted
            /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario dell'informazione in data "+imp_info->DATAOPE+" relativa al rapporto: "+imp_info->RAPPORTO+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
            w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario dell'informazione in data "+Cursor_imp_info.GetString("DATAOPE")+" relativa al rapporto: "+Cursor_imp_info.GetString("RAPPORTO")+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            // Exit Loop
            if (true) {
              break;
            }
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
        } else { // Else
          /* If imp_info->TIPOOPRAP='23' */
          if (CPLib.eqr(Cursor_imp_info.GetString("TIPOOPRAP"),"23")) {
            // * --- Write into jntestbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("jntestbo");
            m_cPhName = m_Ctx.GetPhName("jntestbo");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = "Update "+m_cPhName+" set ";
            m_cSql = m_cSql+"DATAINI = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(Cursor_imp_info.GetString("DATAOPE"),5,4)+CPLib.Substr(Cursor_imp_info.GetString("DATAOPE"),3,2)+CPLib.Substr(Cursor_imp_info.GetString("DATAOPE"),1,2)),"D",8,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jntestbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_imp_info.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_imp_info.GetString("RAPPORTO"))+"";
            m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cNumMod,"?",0,0,m_cServer),m_cServer,cNumMod)+"";
            if (m_Ctx.IsSharedTemp("jntestbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_nUpdatedRows = 0;
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.lt(m_nUpdatedRows,1)) {
              // No rows updated
              /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario dell'informazione in data "+imp_info->DATAOPE+" relativa al rapporto: "+imp_info->RAPPORTO+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
              w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario dell'informazione in data "+Cursor_imp_info.GetString("DATAOPE")+" relativa al rapporto: "+Cursor_imp_info.GetString("RAPPORTO")+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
              /* _esito := 1 */
              _esito = CPLib.Round(1,0);
              // Exit Loop
              if (true) {
                break;
              }
            } else if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
            /* ElseIf imp_info->TIPOOPRAP='26' */
          } else if (CPLib.eqr(Cursor_imp_info.GetString("TIPOOPRAP"),"26")) {
            // * --- Write into jntestbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("jntestbo");
            m_cPhName = m_Ctx.GetPhName("jntestbo");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = "Update "+m_cPhName+" set ";
            m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(Cursor_imp_info.GetString("DATAOPE"),5,4)+CPLib.Substr(Cursor_imp_info.GetString("DATAOPE"),3,2)+CPLib.Substr(Cursor_imp_info.GetString("DATAOPE"),1,2)),"D",8,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jntestbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_imp_info.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_imp_info.GetString("RAPPORTO"))+"";
            m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cNumMod,"?",0,0,m_cServer),m_cServer,cNumMod)+"";
            if (m_Ctx.IsSharedTemp("jntestbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_nUpdatedRows = 0;
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.lt(m_nUpdatedRows,1)) {
              // No rows updated
              /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario dell'informazione in data "+imp_info->DATAOPE+" relativa al rapporto: "+imp_info->RAPPORTO+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
              w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario dell'informazione in data "+Cursor_imp_info.GetString("DATAOPE")+" relativa al rapporto: "+Cursor_imp_info.GetString("RAPPORTO")+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
              /* _esito := 1 */
              _esito = CPLib.Round(1,0);
              // Exit Loop
              if (true) {
                break;
              }
            } else if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
          } // End If
        } // End If
        /* cNumNew := cNumNew + 1 */
        cNumNew = CPLib.Round(cNumNew+1,0);
        Cursor_imp_info.Next();
      }
      m_cConnectivityError = Cursor_imp_info.ErrorMessage();
      Cursor_imp_info.Close();
      // * --- End Select
      /* w_msgproc := w_msgproc + 'Informazione Inserite: '+LRTrim(Str(cNumNew,10,0)) + NL */
      w_msgproc = w_msgproc+"Informazione Inserite: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+"\n";
      /* w_msgproc := w_msgproc + 'Ora Fine Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Fine Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
    } finally {
      try {
        if (Cursor_imp_info!=null)
          Cursor_imp_info.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_joginfo!=null)
          Cursor_joginfo.Close();
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
  void Page_13() throws Exception {
    CPResultSet Cursor_imp_opefra=null;
    CPResultSet Read_Cursor=null;
    try {
      /* Legge il file di testo e porta i dati nella tabella */
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      // * --- Drop temporary table imp_opefra
      if (m_Ctx.IsSharedTemp("imp_opefra")) {
        if (m_Ctx.IsTmpAlreadyCreated("imp_opefra")) {
          m_cServer = m_Ctx.GetServer("imp_opefra");
          m_cPhName = m_Ctx.GetPhName("imp_opefra");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("imp_opefra");
      }
      // * --- Create temporary table imp_opefra
      if (m_Ctx.IsSharedTemp("imp_opefra")) {
        if (m_Ctx.IsTmpAlreadyCreated("imp_opefra")) {
          m_cServer = m_Ctx.GetServer("imp_opefra");
          m_cPhName = m_Ctx.GetPhName("imp_opefra");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("imp_opefra");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("imp_opefra");
      if ( ! (m_Ctx.IsSharedTemp("imp_opefra"))) {
        m_cServer = m_Ctx.GetServer("imp_opefra");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("imp_opefra",m_cServer,"proto")),m_cPhName,"imp_opefra",m_Ctx,new String[]{"RAPPORTO,DATAOPE"});
      }
      m_cPhName_imp_opefra = m_cPhName;
      /* w_msgproc := w_msgproc + 'Ora Inizio Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Inizio Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        // * --- Insert into imp_opefra from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("imp_opefra");
        m_cPhName = m_Ctx.GetPhName("imp_opefra");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"imp_opefra")+" (";
        m_cSql = m_cSql+GetFieldsName_0628B6C0(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,8),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,9,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,10,4),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,14,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,16,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,18,11),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,29,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,32,30),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,62,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,64,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,70,50),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,120,25),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,145,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,146,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,147,8),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,155,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,156,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,159,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,160,15),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,175,15),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,190,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,206,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,222,9),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,231,11),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,242,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,244,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,246,11),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,257,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,263,30),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,293,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,295,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,301,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,302,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,318,10),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,328,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,331,9),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,340,69),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,409,5),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,414,5),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,419,5),"?",0,0,m_cServer)+", ";
        if (m_Ctx.IsSharedTemp("imp_opefra")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"imp_opefra",true);
        m_cSql = m_cSql+")";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_nUpdatedRows = 0;
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.lt(m_nUpdatedRows,1)) {
          // No rows inserted
          /* w_msgproc := w_msgproc +"Rilevati errori in lettura del file "+nomefileimport+" per l'operazione in data "+Left(riga,8)+" con importo "+Str(Val(Substr(riga,160,15)),14,2)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
          w_msgproc = w_msgproc+"Rilevati errori in lettura del file "+nomefileimport+" per l'operazione in data "+CPLib.Left(riga,8)+" con importo "+CPLib.Str(CPLib.Val(CPLib.Substr(riga,160,15)),14,2)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
          // Exit Loop
          if (true) {
            break;
          }
        } else if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      // * --- Select from imp_opefra
      m_cServer = m_Ctx.GetServer("imp_opefra");
      m_cPhName = m_Ctx.GetPhName("imp_opefra");
      if (Cursor_imp_opefra!=null)
        Cursor_imp_opefra.Close();
      Cursor_imp_opefra = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("imp_opefra")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_imp_opefra.Eof())) {
        /* cOpeProg1 := iif(Empty(imp_opefra->UNIQUECODE),Utilities.GetAutonumber('POPERAGE1','',10),imp_opefra->UNIQUECODE) */
        cOpeProg1 = (CPLib.Empty(Cursor_imp_opefra.GetString("UNIQUECODE"))?Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAGE1","",10):Cursor_imp_opefra.GetString("UNIQUECODE"));
        /* cOpeProg2 := Utilities.GetAutonumber('POPERAGE2','',11) */
        cOpeProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAGE2","",11);
        /* Case imp_opefra->FLAGLIRE='S' or imp_opefra->FLAGLIRE='1' or imp_opefra->FLAGLIRE='7' */
        if (CPLib.eqr(Cursor_imp_opefra.GetString("FLAGLIRE"),"S") || CPLib.eqr(Cursor_imp_opefra.GetString("FLAGLIRE"),"1") || CPLib.eqr(Cursor_imp_opefra.GetString("FLAGLIRE"),"7")) {
          /* cFlagLire := '1' */
          cFlagLire = "1";
          /* Case imp_opefra->FLAGLIRE='E' or imp_opefra->FLAGLIRE='3' or imp_opefra->FLAGLIRE='5' */
        } else if (CPLib.eqr(Cursor_imp_opefra.GetString("FLAGLIRE"),"E") || CPLib.eqr(Cursor_imp_opefra.GetString("FLAGLIRE"),"3") || CPLib.eqr(Cursor_imp_opefra.GetString("FLAGLIRE"),"5")) {
          /* If imp_opefra->FLAGLIRE = 'E' */
          if (CPLib.eqr(Cursor_imp_opefra.GetString("FLAGLIRE"),"E")) {
            /* cFlagLire := '3' */
            cFlagLire = "3";
          } else { // Else
            /* cFlagLire := imp_opefra->FLAGLIRE */
            cFlagLire = Cursor_imp_opefra.GetString("FLAGLIRE");
          } // End If
        } else { // Otherwise
          /* cFlagLire := imp_opefra->FLAGLIRE */
          cFlagLire = Cursor_imp_opefra.GetString("FLAGLIRE");
        } // End Case
        /* cFlagCont := iif(imp_opefra->FLAGCONT='1' or imp_opefra->FLAGCONT='S','1','0')  */
        cFlagCont = (CPLib.eqr(Cursor_imp_opefra.GetString("FLAGCONT"),"1") || CPLib.eqr(Cursor_imp_opefra.GetString("FLAGCONT"),"S")?"1":"0");
        /* cFlagFraz := iif(Empty(imp_opefra->FLAGFRAZ),'0',imp_opefra->FLAGFRAZ) */
        cFlagFraz = (CPLib.Empty(Cursor_imp_opefra.GetString("FLAGFRAZ"))?"0":Cursor_imp_opefra.GetString("FLAGFRAZ"));
        /* cIdCau := '' */
        cIdCau = "";
        // * --- Read from tbcauana
        m_cServer = m_Ctx.GetServer("tbcauana");
        m_cPhName = m_Ctx.GetPhName("tbcauana");
        m_cSql = "";
        m_cSql = m_cSql+"CODCAU="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_imp_opefra.GetString("CODANA"),"C",4,0,m_cServer),m_cServer,Cursor_imp_opefra.GetString("CODANA"));
        m_cSql = m_cSql+" and CAUSINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_imp_opefra.GetString("CODVOC"),"C",2,0,m_cServer),m_cServer,Cursor_imp_opefra.GetString("CODVOC"));
        if (m_Ctx.IsSharedTemp("tbcauana")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("idbase",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          cIdCau = Read_Cursor.GetString("idbase");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on tbcauana into routine arrt_imp_dati_multipli_old returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          cIdCau = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        // * --- Insert into jperazbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("jperazbo");
        m_cPhName = m_Ctx.GetPhName("jperazbo");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"jperazbo")+" (";
        m_cSql = m_cSql+GetFieldsName_05D132F0(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(Cursor_imp_opefra.GetString("DATAOPE"),5,4)+CPLib.Substr(Cursor_imp_opefra.GetString("DATAOPE"),3,2)+CPLib.Substr(Cursor_imp_opefra.GetString("DATAOPE"),1,2)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("DATAOPE")+cOpeProg2+"O","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cFlagFraz,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cFlagCont,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CODANA"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("PAESE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("DESC2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("PROV2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(Cursor_imp_opefra.GetString("DATAREG"),5,4)+CPLib.Substr(Cursor_imp_opefra.GetString("DATAREG"),3,2)+CPLib.Substr(Cursor_imp_opefra.GetString("DATAREG"),1,2)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_imp_opefra.GetString("TOTLIRE")),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_imp_opefra.GetString("TOTCONT")),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_imp_opefra.GetString("CAMBIO")),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("CAMBIO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cIdCau,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("AGOPER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_opefra.GetString("INFORM"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(Cursor_imp_opefra.GetString("DATAOPE"),5,4)+CPLib.Substr(Cursor_imp_opefra.GetString("DATAOPE"),3,2)+CPLib.Substr(Cursor_imp_opefra.GetString("DATAOPE"),1,2),"?",0,0,m_cServer)+", ";
        if (m_Ctx.IsSharedTemp("jperazbo")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"jperazbo",true);
        m_cSql = m_cSql+")";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_nUpdatedRows = 0;
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.lt(m_nUpdatedRows,1)) {
          // No rows inserted
          /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per l'operazione in data "+imp_opefra->DATAOPE+" con importo "+Str((Val(imp_opefra->TOTLIRE))/100,14,2)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
          w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per l'operazione in data "+Cursor_imp_opefra.GetString("DATAOPE")+" con importo "+CPLib.Str((CPLib.Val(Cursor_imp_opefra.GetString("TOTLIRE")))/100,14,2)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
          // Exit Loop
          if (true) {
            break;
          }
        } else if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        /* cNumNew := cNumNew + 1 */
        cNumNew = CPLib.Round(cNumNew+1,0);
        Cursor_imp_opefra.Next();
      }
      m_cConnectivityError = Cursor_imp_opefra.ErrorMessage();
      Cursor_imp_opefra.Close();
      // * --- End Select
      /* w_msgproc := w_msgproc + 'Operazioni AGE Inserite: '+LRTrim(Str(cNumNew,10,0)) + NL */
      w_msgproc = w_msgproc+"Operazioni AGE Inserite: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+"\n";
      /* w_msgproc := w_msgproc + 'Ora Fine Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Fine Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
    } finally {
      try {
        if (Cursor_imp_opefra!=null)
          Cursor_imp_opefra.Close();
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
    CPResultSet Read_Cursor=null;
    try {
      /* Import Dipendenze */
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      /* cNumMod := 0 */
      cNumMod = CPLib.Round(0,0);
      /* w_msgproc := w_msgproc + 'Ora Inizio Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Inizio Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        /* xDIP := Substr(riga,1,6) */
        xDIP = CPLib.Substr(riga,1,6);
        // * --- Read from anadip
        m_cServer = m_Ctx.GetServer("anadip");
        m_cPhName = m_Ctx.GetPhName("anadip");
        m_cSql = "";
        m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(xDIP,"C",6,0,m_cServer),m_cServer,xDIP);
        if (m_Ctx.IsSharedTemp("anadip")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODDIP",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          xDIPx = Read_Cursor.GetString("CODDIP");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on anadip into routine arrt_imp_dati_multipli_old returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          xDIPx = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If Empty(LRTrim(xDIPx)) */
        if (CPLib.Empty(CPLib.LRTrim(xDIPx))) {
          // * --- Insert into anadip from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("anadip");
          m_cPhName = m_Ctx.GetPhName("anadip");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"anadip")+" (";
          m_cSql = m_cSql+GetFieldsName_0619AA40(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(xDIP,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,7,30),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,37,30),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,67,2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,69,6),"?",0,0,m_cServer)+", ";
          if (m_Ctx.IsSharedTemp("anadip")) {
            m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
          }
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
          /* cNumNew := cNumNew + 1 */
          cNumNew = CPLib.Round(cNumNew+1,0);
        } else { // Else
          // * --- Write into anadip from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("anadip");
          m_cPhName = m_Ctx.GetPhName("anadip");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = "Update "+m_cPhName+" set ";
          m_cSql = m_cSql+"DESCRIZ = "+CPLib.ToSQL(CPLib.Substr(riga,7,30),"C",30,0,m_cServer)+", ";
          m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.Substr(riga,37,30),"C",30,0,m_cServer)+", ";
          m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(CPLib.Substr(riga,67,2),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"CAB = "+CPLib.ToSQL(CPLib.Substr(riga,69,6),"C",6,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"anadip",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"CODDIP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(xDIP,"?",0,0,m_cServer),m_cServer,xDIP)+"";
          if (m_Ctx.IsSharedTemp("anadip")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          /* cNumMod := cNumMod + 1 */
          cNumMod = CPLib.Round(cNumMod+1,0);
        } // End If
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* If cNumNew <> 0 */
      if (CPLib.ne(cNumNew,0)) {
        /* w_msgproc := w_msgproc + 'Dipendenze Inserite: '+LRTrim(Str(cNumNew,10,0)) + NL */
        w_msgproc = w_msgproc+"Dipendenze Inserite: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+"\n";
      } // End If
      /* If cNumMod <> 0 */
      if (CPLib.ne(cNumMod,0)) {
        /* w_msgproc := w_msgproc + 'Dipendenze Aggiornate: '+LRTrim(Str(cNumMod,10,0)) + NL */
        w_msgproc = w_msgproc+"Dipendenze Aggiornate: "+CPLib.LRTrim(CPLib.Str(cNumMod,10,0))+"\n";
      } // End If
      /* w_msgproc := w_msgproc + 'Ora Fine Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Fine Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_15() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* Legge il file di testo e porta i dati nella tabella */
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      /* cNumMod := 0 */
      cNumMod = CPLib.Round(0,0);
      /* w_msgproc := w_msgproc + 'Ora Inizio Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Inizio Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        /* cCli1 := Substr(riga,112,16) */
        cCli1 = CPLib.Substr(riga,112,16);
        /* xConnes := '' */
        xConnes = "";
        // * --- Read from titolabo
        m_cServer = m_Ctx.GetServer("titolabo");
        m_cPhName = m_Ctx.GetPhName("titolabo");
        m_cSql = "";
        m_cSql = m_cSql+"CODFISC="+CPSql.SQLValueAdapter(CPLib.ToSQL(cCli1,"C",16,0,m_cServer),m_cServer,cCli1);
        if (m_Ctx.IsSharedTemp("titolabo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          xConnes = Read_Cursor.GetString("CONNES");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on titolabo into routine arrt_imp_dati_multipli_old returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          xConnes = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* xSesso := iif(Substr(riga,288,1)='M','1',iif(Substr(riga,288,1)='F','2',Substr(riga,288,1))) */
        xSesso = (CPLib.eqr(CPLib.Substr(riga,288,1),"M")?"1":(CPLib.eqr(CPLib.Substr(riga,288,1),"F")?"2":CPLib.Substr(riga,288,1)));
        /* xCFE := iif(Substr(riga,450,1)='',0,Val(Substr(riga,450,1))) */
        xCFE = CPLib.Round((CPLib.eqr(CPLib.Substr(riga,450,1),"")?0:CPLib.Val(CPLib.Substr(riga,450,1))),0);
        /* If Empty(LRTrim(xConnes)) */
        if (CPLib.Empty(CPLib.LRTrim(xConnes))) {
          // * --- Insert into titolabo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("titolabo");
          m_cPhName = m_Ctx.GetPhName("titolabo");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"titolabo")+" (";
          m_cSql = m_cSql+GetFieldsName_062A4038(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cCli1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,1,6),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,7,70),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,77,35),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,112,16),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,132,4)+CPLib.Substr(riga,130,2)+CPLib.Substr(riga,128,2)),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,136,30),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,166,3),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,169,3),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,172,3),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,175,2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,177,15),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,196,4)+CPLib.Substr(riga,194,2)+CPLib.Substr(riga,192,2)),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,200,30),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,230,30),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,260,2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,262,3),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,265,9),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,274,14),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(xSesso,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,293,4)+CPLib.Substr(riga,291,2)+CPLib.Substr(riga,289,2)),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("P","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,297,26),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,323,25),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,348,100),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,448,2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(xCFE,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,451,4),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,455,5),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,460,10),"?",0,0,m_cServer)+", ";
          if (m_Ctx.IsSharedTemp("titolabo")) {
            m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
          }
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"titolabo",true);
          m_cSql = m_cSql+")";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows inserted
            /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per il titolare: "+Substr(riga,7,70)+" con codice fiscale: "+Substr(riga,112,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
            w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per il titolare: "+CPLib.Substr(riga,7,70)+" con codice fiscale: "+CPLib.Substr(riga,112,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            // Exit Loop
            if (true) {
              break;
            }
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          /* cNumNew := cNumNew + 1 */
          cNumNew = CPLib.Round(cNumNew+1,0);
        } else { // Else
          // * --- Write into titolabo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("titolabo");
          m_cPhName = m_Ctx.GetPhName("titolabo");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = "Update "+m_cPhName+" set ";
          m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(CPLib.Substr(riga,1,6),"C",6,0,m_cServer)+", ";
          m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.Substr(riga,7,70),"C",70,0,m_cServer)+", ";
          m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(CPLib.Substr(riga,77,35),"C",35,0,m_cServer)+", ";
          m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(CPLib.Substr(riga,112,16),"C",16,0,m_cServer)+", ";
          m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,132,4)+CPLib.Substr(riga,130,2)+CPLib.Substr(riga,128,2)),"D",8,0)+", ";
          m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(CPLib.Substr(riga,136,30),"C",30,0,m_cServer)+", ";
          m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(CPLib.Substr(riga,166,3),"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(CPLib.Substr(riga,169,3),"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(CPLib.Substr(riga,172,3),"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(CPLib.Substr(riga,175,2),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(CPLib.Substr(riga,177,15),"C",15,0,m_cServer)+", ";
          m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,196,4)+CPLib.Substr(riga,194,2)+CPLib.Substr(riga,192,2)),"D",8,0)+", ";
          m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(CPLib.Substr(riga,200,30),"C",30,0,m_cServer)+", ";
          m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.Substr(riga,230,30),"C",30,0,m_cServer)+", ";
          m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(CPLib.Substr(riga,260,2),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(CPLib.Substr(riga,262,3),"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(CPLib.Substr(riga,265,9),"C",9,0,m_cServer)+", ";
          m_cSql = m_cSql+"PARTIVA = "+CPLib.ToSQL(CPLib.Substr(riga,274,14),"C",14,0,m_cServer)+", ";
          m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(xSesso,"C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"DATAVALI = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,293,4)+CPLib.Substr(riga,291,2)+CPLib.Substr(riga,289,2)),"D",8,0)+", ";
          m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(CPLib.Substr(riga,297,26),"C",26,0,m_cServer)+", ";
          m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(CPLib.Substr(riga,323,25),"C",25,0,m_cServer)+", ";
          m_cSql = m_cSql+"DOCFILE = "+CPLib.ToSQL(CPLib.Substr(riga,348,100),"C",100,0,m_cServer)+", ";
          m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(CPLib.Substr(riga,448,2),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(xCFE,"N",1,0)+", ";
          m_cSql = m_cSql+"PKTBSPECIE = "+CPLib.ToSQL(CPLib.Substr(riga,451,4),"C",4,0,m_cServer)+", ";
          m_cSql = m_cSql+"COMPORT = "+CPLib.ToSQL(CPLib.Substr(riga,455,5),"C",5,0,m_cServer)+", ";
          m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(CPLib.Substr(riga,460,10),"C",10,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"titolabo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(xConnes,"?",0,0,m_cServer),m_cServer,xConnes)+"";
          if (m_Ctx.IsSharedTemp("titolabo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows updated
            /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per il titolare: "+Substr(riga,7,70)+" con codice fiscale: "+Substr(riga,112,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
            w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per il titolare: "+CPLib.Substr(riga,7,70)+" con codice fiscale: "+CPLib.Substr(riga,112,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            // Exit Loop
            if (true) {
              break;
            }
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          /* cNumMod := cNumMod + 1 */
          cNumMod = CPLib.Round(cNumMod+1,0);
        } // End If
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* w_msgproc := w_msgproc + 'Titolari Inseriti: '+LRTrim(Str(cNumNew,10,0)) + " - Titolari Aggiornati: "+LRTrim(Str(cNumMod,10,0)) + NL */
      w_msgproc = w_msgproc+"Titolari Inseriti: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+" - Titolari Aggiornati: "+CPLib.LRTrim(CPLib.Str(cNumMod,10,0))+"\n";
      /* w_msgproc := w_msgproc + 'Ora Fine Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Fine Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_16() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* Legge il file di testo e porta i dati nella tabella (Operazioni ExtraConto) */
      /* w_msgproc := w_msgproc + 'Ora Inizio Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Inizio Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      /* cNumMod := 0 */
      cNumMod = CPLib.Round(0,0);
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        /* cCli1 := Substr(riga,1,16) */
        cCli1 = CPLib.Substr(riga,1,16);
        /* xData := Substr(riga,25,4)+Substr(riga,23,2)+Substr(riga,21,2) */
        xData = CPLib.Substr(riga,25,4)+CPLib.Substr(riga,23,2)+CPLib.Substr(riga,21,2);
        // * --- Read from opextrbo
        m_cServer = m_Ctx.GetServer("opextrbo");
        m_cPhName = m_Ctx.GetPhName("opextrbo");
        m_cSql = "";
        m_cSql = m_cSql+"COLLEG="+CPSql.SQLValueAdapter(CPLib.ToSQL(cCli1,"C",16,0,m_cServer),m_cServer,cCli1);
        m_cSql = m_cSql+" and ANNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,17,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(riga,17,4));
        if (m_Ctx.IsSharedTemp("opextrbo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          xIDB = Read_Cursor.GetString("IDBASE");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on opextrbo into routine arrt_imp_dati_multipli_old returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          xIDB = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If Empty(LRTrim(xIDB)) */
        if (CPLib.Empty(CPLib.LRTrim(xIDB))) {
          /* xIDB := LibreriaMit.UniqueId() */
          xIDB = LibreriaMit.UniqueId();
          // * --- Insert into opextrbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("opextrbo");
          m_cPhName = m_Ctx.GetPhName("opextrbo");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"opextrbo")+" (";
          m_cSql = m_cSql+GetFieldsName_06347620(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cCli1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,17,4),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(xIDB,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(xData),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,29,1),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,30,15),"?",0,0,m_cServer)+", ";
          if (m_Ctx.IsSharedTemp("opextrbo")) {
            m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
          }
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"opextrbo",true);
          m_cSql = m_cSql+")";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows inserted
            /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per il soggetto con codice fiscale: "+Substr(riga,1,16)+" per l'operazione extraconto in data: "+Substr(riga,21,8)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
            w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per il soggetto con codice fiscale: "+CPLib.Substr(riga,1,16)+" per l'operazione extraconto in data: "+CPLib.Substr(riga,21,8)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            // Exit Loop
            if (true) {
              break;
            }
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          /* cNumNew := cNumNew + 1 */
          cNumNew = CPLib.Round(cNumNew+1,0);
        } else { // Else
          // * --- Write into opextrbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("opextrbo");
          m_cPhName = m_Ctx.GetPhName("opextrbo");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = "Update "+m_cPhName+" set ";
          m_cSql = m_cSql+"DATAOPE = "+CPLib.ToSQL(CPLib.CharToDate(xData),"D",8,0)+", ";
          m_cSql = m_cSql+"COINT = "+CPLib.ToSQL(CPLib.Substr(riga,29,1),"C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"RIFIMP = "+CPLib.ToSQL(CPLib.Substr(riga,30,15),"C",30,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cCli1,"?",0,0,m_cServer),m_cServer,cCli1)+"";
          m_cSql = m_cSql+" and ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,17,4),"?",0,0,m_cServer),m_cServer,CPLib.Substr(riga,17,4))+"";
          if (m_Ctx.IsSharedTemp("opextrbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows updated
            /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per il soggetto con codice fiscale: "+Substr(riga,1,16)+" per l'operazione extraconto in data: "+Substr(riga,21,8)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
            w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per il soggetto con codice fiscale: "+CPLib.Substr(riga,1,16)+" per l'operazione extraconto in data: "+CPLib.Substr(riga,21,8)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            // Exit Loop
            if (true) {
              break;
            }
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          /* cNumMod := cNumMod + 1 */
          cNumMod = CPLib.Round(cNumMod+1,0);
        } // End If
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* w_msgproc := w_msgproc + 'Operazioni ExtraConto Inserite: '+LRTrim(Str(cNumNew,10,0)) + " - Operazioni ExtraConto Aggiornati: "+LRTrim(Str(cNumMod,10,0))+' dal file '+nomefileimport+NL */
      w_msgproc = w_msgproc+"Operazioni ExtraConto Inserite: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+" - Operazioni ExtraConto Aggiornati: "+CPLib.LRTrim(CPLib.Str(cNumMod,10,0))+" dal file "+nomefileimport+"\n";
      /* w_msgproc := w_msgproc + 'Ora Fine Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Fine Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_17() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* Deleghe sui rapporti */
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      /* cNumMod := 0 */
      cNumMod = CPLib.Round(0,0);
      /* w_msgproc := w_msgproc + 'Ora Inizio Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Inizio Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        /* cMaxRow := 0 */
        cMaxRow = CPLib.Round(0,0);
        // * --- Read from delegabo
        m_cServer = m_Ctx.GetServer("delegabo");
        m_cPhName = m_Ctx.GetPhName("delegabo");
        m_cSql = "";
        m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,25),"C",25,0,m_cServer),m_cServer,CPLib.Left(riga,25));
        m_cSql = m_cSql+" and CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,26,16),"C",16,0,m_cServer),m_cServer,CPLib.Substr(riga,26,16));
        if (m_Ctx.IsSharedTemp("delegabo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CPROWNUM",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          cMaxRow = CPLib.Round(Read_Cursor.GetDouble("CPROWNUM"),0);
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on delegabo into routine arrt_imp_dati_multipli_old returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          cMaxRow = 0;
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* xData := Substr(riga,46,4)+Substr(riga,44,2)+Substr(riga,42,2) */
        xData = CPLib.Substr(riga,46,4)+CPLib.Substr(riga,44,2)+CPLib.Substr(riga,42,2);
        /* xDatF := Substr(riga,55,4)+Substr(riga,53,2)+Substr(riga,51,2) */
        xDatF = CPLib.Substr(riga,55,4)+CPLib.Substr(riga,53,2)+CPLib.Substr(riga,51,2);
        /* If cMaxRow = 0 */
        if (CPLib.eqr(cMaxRow,0)) {
          // * --- Insert into delegabo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("delegabo");
          m_cPhName = m_Ctx.GetPhName("delegabo");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"delegabo")+" (";
          m_cSql = m_cSql+GetFieldsName_05F07F50(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,25),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,26,16),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(xData),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,50,1),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(xDatF),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
          if (m_Ctx.IsSharedTemp("delegabo")) {
            m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
          }
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"delegabo",true);
          m_cSql = m_cSql+")";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows inserted
            /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per il soggetto con codice fiscale: "+Substr(riga,26,16)+" per il rapporto: "+Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
            w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per il soggetto con codice fiscale: "+CPLib.Substr(riga,26,16)+" per il rapporto: "+CPLib.Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            // Exit Loop
            if (true) {
              break;
            }
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          /* cNumNew := cNumNew + 1 */
          cNumNew = CPLib.Round(cNumNew+1,0);
        } else { // Else
          // * --- Write into delegabo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("delegabo");
          m_cPhName = m_Ctx.GetPhName("delegabo");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = "Update "+m_cPhName+" set ";
          m_cSql = m_cSql+"DATAINI = "+CPLib.ToSQL(CPLib.CharToDate(xData),"D",8,0)+", ";
          m_cSql = m_cSql+"TIPORAP = "+CPLib.ToSQL(CPLib.Substr(riga,50,1),"C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(CPLib.CharToDate(xDatF),"D",8,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"delegabo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,25),"?",0,0,m_cServer),m_cServer,CPLib.Left(riga,25))+"";
          m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cMaxRow,"?",0,0,m_cServer),m_cServer,cMaxRow)+"";
          if (m_Ctx.IsSharedTemp("delegabo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows updated
            /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per il soggetto con codice fiscale: "+Substr(riga,26,16)+" per il rapporto: "+Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
            w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per il soggetto con codice fiscale: "+CPLib.Substr(riga,26,16)+" per il rapporto: "+CPLib.Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            // Exit Loop
            if (true) {
              break;
            }
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          /* cNumMod := cNumMod + 1 */
          cNumMod = CPLib.Round(cNumMod+1,0);
        } // End If
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* w_msgproc := w_msgproc + 'Deleghe Rapporti Inserite: '+LRTrim(Str(cNumNew,10,0)) + " - Deleghe Rapporti Aggiornate: "+LRTrim(Str(cNumMod,10,0)) + NL */
      w_msgproc = w_msgproc+"Deleghe Rapporti Inserite: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+" - Deleghe Rapporti Aggiornate: "+CPLib.LRTrim(CPLib.Str(cNumMod,10,0))+"\n";
      /* w_msgproc := w_msgproc + 'Ora Fine Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Fine Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_18() throws Exception {
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_sogopefbo=null;
    CPResultSet Cursor_sogopebo=null;
    CPResultSet Cursor_soginfo=null;
    try {
      /* Importazione file SOGOPE.TXT altri soggetti operanti */
      /* w_msgproc := w_msgproc + 'Ora Inizio Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Inizio Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      /* cNumMod := 0 */
      cNumMod = CPLib.Round(0,0);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        /* cMaxRow := 0 */
        cMaxRow = CPLib.Round(0,0);
        /* uniquecode := '' */
        uniquecode = "";
        /* _salta := 0 */
        _salta = CPLib.Round(0,0);
        /* Verfico la presenza di uniquecode nelle tabelle rapopebo/operazbo/fraziobo */
        // * --- Read from rapopebo
        m_cServer = m_Ctx.GetServer("rapopebo");
        m_cPhName = m_Ctx.GetPhName("rapopebo");
        m_cSql = "";
        m_cSql = m_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,11,10),"C",10,0,m_cServer),m_cServer,CPLib.Substr(riga,11,10));
        if (m_Ctx.IsSharedTemp("rapopebo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("NUMPROG",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          uniquecode = Read_Cursor.GetString("IDBASE");
          cInfProg2 = Read_Cursor.GetString("NUMPROG");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on rapopebo into routine arrt_imp_dati_multipli_old returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          uniquecode = "";
          cInfProg2 = "";
          Read_Cursor.Close();
          // * --- Read from operazbo
          m_cServer = m_Ctx.GetServer("operazbo");
          m_cPhName = m_Ctx.GetPhName("operazbo");
          m_cSql = "";
          m_cSql = m_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,11,10),"C",10,0,m_cServer),m_cServer,CPLib.Substr(riga,11,10));
          if (m_Ctx.IsSharedTemp("operazbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("NUMPROG",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            uniquecode = Read_Cursor.GetString("IDBASE");
            cOpeProg2 = Read_Cursor.GetString("NUMPROG");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on operazbo into routine arrt_imp_dati_multipli_old returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            uniquecode = "";
            cOpeProg2 = "";
            Read_Cursor.Close();
            // * --- Read from fraziobo
            m_cServer = m_Ctx.GetServer("fraziobo");
            m_cPhName = m_Ctx.GetPhName("fraziobo");
            m_cSql = "";
            m_cSql = m_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,11,10),"C",10,0,m_cServer),m_cServer,CPLib.Substr(riga,11,10));
            if (m_Ctx.IsSharedTemp("fraziobo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("NUMPROG",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              uniquecode = Read_Cursor.GetString("IDBASE");
              cOpeProg2 = Read_Cursor.GetString("NUMPROG");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on fraziobo into routine arrt_imp_dati_multipli_old returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              uniquecode = "";
              cOpeProg2 = "";
              Read_Cursor.Close();
              /* w_msgproc := w_msgproc +"Rilevati errore nella valorizazione del campo IDFILEBO nel file "+nomefileimport+" per il soggetto con codice fiscale: "+Substr(riga,21,16)+" non risulta associabile a nessuna informazione/operazione.  Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
              w_msgproc = w_msgproc+"Rilevati errore nella valorizazione del campo IDFILEBO nel file "+nomefileimport+" per il soggetto con codice fiscale: "+CPLib.Substr(riga,21,16)+" non risulta associabile a nessuna informazione/operazione.  Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
              /* _esito := 1 */
              _esito = CPLib.Round(1,0);
              /* _salta := 1 */
              _salta = CPLib.Round(1,0);
              // Exit Loop
              if (true) {
                break;
              }
            }
            /* If _salta=0 and Substr(riga,11,10) = uniquecode */
            if (CPLib.eqr(_salta,0) && CPLib.eqr(CPLib.Substr(riga,11,10),uniquecode)) {
              // * --- Select from sogopefbo
              m_cServer = m_Ctx.GetServer("sogopefbo");
              m_cPhName = m_Ctx.GetPhName("sogopefbo");
              if (Cursor_sogopefbo!=null)
                Cursor_sogopefbo.Close();
              Cursor_sogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(uniquecode,"?",0,0,m_cServer, m_oParameters),m_cServer,uniquecode)+" "+")"+(m_Ctx.IsSharedTemp("sogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_sogopefbo.Eof())) {
                /* cMaxRow := sogopefbo->CPROWNUM */
                cMaxRow = CPLib.Round(Cursor_sogopefbo.GetDouble("CPROWNUM"),0);
                Cursor_sogopefbo.Next();
              }
              m_cConnectivityError = Cursor_sogopefbo.ErrorMessage();
              Cursor_sogopefbo.Close();
              // * --- End Select
              // * --- Insert into sogopefbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("sogopefbo");
              m_cPhName = m_Ctx.GetPhName("sogopefbo");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"sogopefbo")+" (";
              m_cSql = m_cSql+GetFieldsName_0615E3F0(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(uniquecode,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow+1,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,21,16),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,49,1),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(uniquecode,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,48,1),"?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("sogopefbo")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"sogopefbo",true);
              m_cSql = m_cSql+")";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_nUpdatedRows = 0;
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.lt(m_nUpdatedRows,1)) {
                // No rows inserted
                /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per il soggetto operante con codice fiscale: "+Substr(riga,21,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per il soggetto operante con codice fiscale: "+CPLib.Substr(riga,21,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                /* _esito := 1 */
                _esito = CPLib.Round(1,0);
                // Exit Loop
                if (true) {
                  break;
                }
              } else if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
              /* _salta := 1 */
              _salta = CPLib.Round(1,0);
              /* cNumNew := cNumNew+1 */
              cNumNew = CPLib.Round(cNumNew+1,0);
            } // End If
          }
          /* If _salta=0 and Substr(riga,11,10) = uniquecode */
          if (CPLib.eqr(_salta,0) && CPLib.eqr(CPLib.Substr(riga,11,10),uniquecode)) {
            // * --- Select from sogopebo
            m_cServer = m_Ctx.GetServer("sogopebo");
            m_cPhName = m_Ctx.GetPhName("sogopebo");
            if (Cursor_sogopebo!=null)
              Cursor_sogopebo.Close();
            Cursor_sogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(uniquecode,"?",0,0,m_cServer, m_oParameters),m_cServer,uniquecode)+" "+")"+(m_Ctx.IsSharedTemp("sogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_sogopebo.Eof())) {
              /* cMaxRow := sogopebo->CPROWNUM */
              cMaxRow = CPLib.Round(Cursor_sogopebo.GetDouble("CPROWNUM"),0);
              Cursor_sogopebo.Next();
            }
            m_cConnectivityError = Cursor_sogopebo.ErrorMessage();
            Cursor_sogopebo.Close();
            // * --- End Select
            // * --- Insert into sogopebo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("sogopebo");
            m_cPhName = m_Ctx.GetPhName("sogopebo");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.InsertIntoStatement(m_Ctx,"sogopebo")+" (";
            m_cSql = m_cSql+GetFieldsName_06D12E58(m_Ctx);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(uniquecode,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow+1,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,21,16),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,49,1),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(uniquecode,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,48,1),"?",0,0,m_cServer)+", ";
            if (m_Ctx.IsSharedTemp("sogopebo")) {
              m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
            }
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"sogopebo",true);
            m_cSql = m_cSql+")";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_nUpdatedRows = 0;
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.lt(m_nUpdatedRows,1)) {
              // No rows inserted
              /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per il soggetto operante con codice fiscale: "+Substr(riga,21,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
              w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per il soggetto operante con codice fiscale: "+CPLib.Substr(riga,21,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
              /* _esito := 1 */
              _esito = CPLib.Round(1,0);
              // Exit Loop
              if (true) {
                break;
              }
            } else if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
            /* cNumNew := cNumNew+1 */
            cNumNew = CPLib.Round(cNumNew+1,0);
          } // End If
        }
        /* If _salta=0 and Substr(riga,11,10) = uniquecode */
        if (CPLib.eqr(_salta,0) && CPLib.eqr(CPLib.Substr(riga,11,10),uniquecode)) {
          // * --- Select from soginfo
          m_cServer = m_Ctx.GetServer("soginfo");
          m_cPhName = m_Ctx.GetPhName("soginfo");
          if (Cursor_soginfo!=null)
            Cursor_soginfo.Close();
          Cursor_soginfo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO=uniquecode "+")"+(m_Ctx.IsSharedTemp("soginfo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_soginfo.Eof())) {
            /* cMaxRow := soginfo->CPROWNUM */
            cMaxRow = CPLib.Round(Cursor_soginfo.GetDouble("CPROWNUM"),0);
            Cursor_soginfo.Next();
          }
          m_cConnectivityError = Cursor_soginfo.ErrorMessage();
          Cursor_soginfo.Close();
          // * --- End Select
          // * --- Insert into soginfo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("soginfo");
          m_cPhName = m_Ctx.GetPhName("soginfo");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"soginfo")+" (";
          m_cSql = m_cSql+GetFieldsName_070C5DC0(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(uniquecode,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow+1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,21,16),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,49,1),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(uniquecode,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,48,1),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,50,25),"?",0,0,m_cServer)+", ";
          if (m_Ctx.IsSharedTemp("soginfo")) {
            m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
          }
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"soginfo",true);
          m_cSql = m_cSql+")";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows inserted
            /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per il soggetto operante con codice fiscale: "+Substr(riga,21,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
            w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per il soggetto operante con codice fiscale: "+CPLib.Substr(riga,21,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            // Exit Loop
            if (true) {
              break;
            }
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          /* cNumNew := cNumNew+1 */
          cNumNew = CPLib.Round(cNumNew+1,0);
        } // End If
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport') */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* w_msgproc := w_msgproc + "Soggetti operanti inseriti: "+LRTrim(Str(cNumNew,10,0)) + " - Soggetti operanti aggiornati: "+LRTrim(Str(cNumMod,10,0)) + NL */
      w_msgproc = w_msgproc+"Soggetti operanti inseriti: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+" - Soggetti operanti aggiornati: "+CPLib.LRTrim(CPLib.Str(cNumMod,10,0))+"\n";
      /* w_msgproc := w_msgproc + 'Ora Fine Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Fine Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
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
        if (Cursor_sogopebo!=null)
          Cursor_sogopebo.Close();
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
    }
  }
  void Page_19() throws Exception {
    CPResultSet Cursor_intestbo=null;
    try {
      /* Importazione file INTEST.TXT altri intestatari */
      /* w_msgproc := w_msgproc + 'Ora Inizio Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Inizio Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      /* cNumMod := 0 */
      cNumMod = CPLib.Round(0,0);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        /* cMaxRow := 0 */
        cMaxRow = CPLib.Round(0,0);
        /* cNumMod := 0 */
        cNumMod = CPLib.Round(0,0);
        /* Verifico in intestbo che ci sia già un recod con lo stesso codice rapporto e memorizzo i dati della riga necessari per crearne una nuova. */
        // * --- Select from intestbo
        m_cServer = m_Ctx.GetServer("intestbo");
        m_cPhName = m_Ctx.GetPhName("intestbo");
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
        Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,1,25),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Substr(riga,1,25))+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM ",m_cServer,m_Ctx,true));
        if ( ! (Cursor_intestbo.Eof())) {
          while ( ! (Cursor_intestbo.Eof())) {
            /* If Substr(riga,26,16)=intestbo->CODINTER */
            if (CPLib.eqr(CPLib.Substr(riga,26,16),Cursor_intestbo.GetString("CODINTER"))) {
              /* cNumMod := intestbo->CPROWNUM */
              cNumMod = CPLib.Round(Cursor_intestbo.GetDouble("CPROWNUM"),0);
            } // End If
            /* cMaxRow := intestbo->CPROWNUM */
            cMaxRow = CPLib.Round(Cursor_intestbo.GetDouble("CPROWNUM"),0);
            /* ciidbase := intestbo->IDBASE */
            ciidbase = Cursor_intestbo.GetString("IDBASE");
            /* cidataini := intestbo->DATAINI */
            cidataini = Cursor_intestbo.GetDate("DATAINI");
            /* cidatafine := intestbo->DATAFINE */
            cidatafine = Cursor_intestbo.GetDate("DATAFINE");
            /* cicodinter := intestbo->CODINTER */
            cicodinter = Cursor_intestbo.GetString("CODINTER");
            /* cinumprog := intestbo->NUMPROG1 */
            cinumprog = Cursor_intestbo.GetString("NUMPROG1");
            /* citiporap := intestbo->TIPORAP */
            citiporap = Cursor_intestbo.GetString("TIPORAP");
            Cursor_intestbo.Next();
          }
          m_cConnectivityError = Cursor_intestbo.ErrorMessage();
        } else {
          // No rows selected
          /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario con codice fiscale "+Substr(riga,26,16)+" relativa al rapporto: "+Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
          w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario con codice fiscale "+CPLib.Substr(riga,26,16)+" relativa al rapporto: "+CPLib.Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
          // Exit Loop
          if (true) {
            break;
          }
        }
        Cursor_intestbo.Close();
        // * --- End Select
        /* Se trovo il record inserisco il nuovo intestatario */
        // * --- Insert into intestbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("intestbo");
        m_cPhName = m_Ctx.GetPhName("intestbo");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"intestbo")+" (";
        m_cSql = m_cSql+GetFieldsName_06163C40(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(ciidbase,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow+1,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cidataini,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.Substr(riga,121,1))?"P":CPLib.Substr(riga,121,1)),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQLNull(cicodinter,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cinumprog,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,1,25),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(citiporap,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cidataini+cinumprog+"O","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(CPLib.Substr(riga,26,16))+CPLib.Space(5),16),"?",0,0,m_cServer)+", ";
        if (m_Ctx.IsSharedTemp("intestbo")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"intestbo",true);
        m_cSql = m_cSql+")";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_nUpdatedRows = 0;
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.lt(m_nUpdatedRows,1)) {
          // No rows inserted
          /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario con codice fiscale "+Substr(riga,26,16)+" relativa al rapporto: "+Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
          w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario con codice fiscale "+CPLib.Substr(riga,26,16)+" relativa al rapporto: "+CPLib.Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
          // Exit Loop
          if (true) {
            break;
          }
        } else if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        /* cNumNew := cNumNew+1 */
        cNumNew = CPLib.Round(cNumNew+1,0);
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* w_msgproc := w_msgproc + "Intestatari inseriti: "+LRTrim(Str(cNumNew,10,0)) + " - Intestatari aggiornati: "+LRTrim(Str(cNumMod,10,0)) + NL */
      w_msgproc = w_msgproc+"Intestatari inseriti: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+" - Intestatari aggiornati: "+CPLib.LRTrim(CPLib.Str(cNumMod,10,0))+"\n";
      /* w_msgproc := w_msgproc + 'Ora Fine Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Fine Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
    } finally {
      try {
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_20() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* Deleghe sui rapporti */
      /* w_msgproc := w_msgproc + 'Ora Inizio Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Inizio Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      /* cNumMod := 0 */
      cNumMod = CPLib.Round(0,0);
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        /* cMaxRow := 0 */
        cMaxRow = CPLib.Round(0,0);
        // * --- Read from xelegabo
        m_cServer = m_Ctx.GetServer("xelegabo");
        m_cPhName = m_Ctx.GetPhName("xelegabo");
        m_cSql = "";
        m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,25),"C",25,0,m_cServer),m_cServer,CPLib.Left(riga,25));
        m_cSql = m_cSql+" and CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,26,16),"C",16,0,m_cServer),m_cServer,CPLib.Substr(riga,26,16));
        if (m_Ctx.IsSharedTemp("xelegabo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CPROWNUM",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          cMaxRow = CPLib.Round(Read_Cursor.GetDouble("CPROWNUM"),0);
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on xelegabo into routine arrt_imp_dati_multipli_old returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          cMaxRow = 0;
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* xData := Substr(riga,46,4)+Substr(riga,44,2)+Substr(riga,42,2) */
        xData = CPLib.Substr(riga,46,4)+CPLib.Substr(riga,44,2)+CPLib.Substr(riga,42,2);
        /* xDatF := Substr(riga,55,4)+Substr(riga,53,2)+Substr(riga,51,2) */
        xDatF = CPLib.Substr(riga,55,4)+CPLib.Substr(riga,53,2)+CPLib.Substr(riga,51,2);
        /* If cMaxRow = 0 */
        if (CPLib.eqr(cMaxRow,0)) {
          // * --- Insert into xelegabo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xelegabo");
          m_cPhName = m_Ctx.GetPhName("xelegabo");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"xelegabo")+" (";
          m_cSql = m_cSql+GetFieldsName_06ECC6A8(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,25),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,26,16),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(xData),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,50,1),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(xDatF),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
          if (m_Ctx.IsSharedTemp("xelegabo")) {
            m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
          }
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xelegabo",true);
          m_cSql = m_cSql+")";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows inserted
            /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per il soggetto con codice fiscale: "+Substr(riga,26,16)+" per il rapporto: "+Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
            w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per il soggetto con codice fiscale: "+CPLib.Substr(riga,26,16)+" per il rapporto: "+CPLib.Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            // Exit Loop
            if (true) {
              break;
            }
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          /* cNumNew := cNumNew + 1 */
          cNumNew = CPLib.Round(cNumNew+1,0);
        } else { // Else
          // * --- Write into xelegabo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xelegabo");
          m_cPhName = m_Ctx.GetPhName("xelegabo");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = "Update "+m_cPhName+" set ";
          m_cSql = m_cSql+"DATAINI = "+CPLib.ToSQL(CPLib.CharToDate(xData),"D",8,0)+", ";
          m_cSql = m_cSql+"TIPORAP = "+CPLib.ToSQL(CPLib.Substr(riga,50,1),"C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(CPLib.CharToDate(xDatF),"D",8,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xelegabo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,25),"?",0,0,m_cServer),m_cServer,CPLib.Left(riga,25))+"";
          m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cMaxRow,"?",0,0,m_cServer),m_cServer,cMaxRow)+"";
          if (m_Ctx.IsSharedTemp("xelegabo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows updated
            /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per il soggetto con codice fiscale: "+Substr(riga,26,16)+" per il rapporto: "+Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
            w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per il soggetto con codice fiscale: "+CPLib.Substr(riga,26,16)+" per il rapporto: "+CPLib.Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            // Exit Loop
            if (true) {
              break;
            }
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          /* cNumMod := cNumMod + 1 */
          cNumMod = CPLib.Round(cNumMod+1,0);
        } // End If
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* w_msgproc := w_msgproc + 'Deleghe Rapporti Inserite: '+LRTrim(Str(cNumNew,10,0)) + " - Deleghe Rapporti Aggiornate: "+LRTrim(Str(cNumMod,10,0)) + NL */
      w_msgproc = w_msgproc+"Deleghe Rapporti Inserite: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+" - Deleghe Rapporti Aggiornate: "+CPLib.LRTrim(CPLib.Str(cNumMod,10,0))+"\n";
      /* w_msgproc := w_msgproc + 'Ora Fine Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Fine Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_21() throws Exception {
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_xogopefbo=null;
    CPResultSet Cursor_xogopebo=null;
    CPResultSet Cursor_xoginfo=null;
    try {
      /* Importazione file SOGOPE.TXT altri soggetti operanti in Provvisorio */
      /* w_msgproc := w_msgproc + 'Ora Inizio Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Inizio Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      /* cNumMod := 0 */
      cNumMod = CPLib.Round(0,0);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        /* cMaxRow := 0 */
        cMaxRow = CPLib.Round(0,0);
        /* uniquecode := '' */
        uniquecode = "";
        /* _salta := 0 */
        _salta = CPLib.Round(0,0);
        /* Verfico la presenza di uniquecode nelle tabelle rapopebo/operazbo/fraziobo */
        // * --- Read from xapopebo
        m_cServer = m_Ctx.GetServer("xapopebo");
        m_cPhName = m_Ctx.GetPhName("xapopebo");
        m_cSql = "";
        m_cSql = m_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,11,10),"C",10,0,m_cServer),m_cServer,CPLib.Substr(riga,11,10));
        if (m_Ctx.IsSharedTemp("xapopebo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("NUMPROG",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          uniquecode = Read_Cursor.GetString("IDBASE");
          cInfProg2 = Read_Cursor.GetString("NUMPROG");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on xapopebo into routine arrt_imp_dati_multipli_old returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          uniquecode = "";
          cInfProg2 = "";
          Read_Cursor.Close();
          // * --- Read from xperazbo
          m_cServer = m_Ctx.GetServer("xperazbo");
          m_cPhName = m_Ctx.GetPhName("xperazbo");
          m_cSql = "";
          m_cSql = m_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,11,10),"C",10,0,m_cServer),m_cServer,CPLib.Substr(riga,11,10));
          if (m_Ctx.IsSharedTemp("xperazbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("NUMPROG",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            uniquecode = Read_Cursor.GetString("IDBASE");
            cOpeProg2 = Read_Cursor.GetString("NUMPROG");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on xperazbo into routine arrt_imp_dati_multipli_old returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            uniquecode = "";
            cOpeProg2 = "";
            Read_Cursor.Close();
            // * --- Read from xraziobo
            m_cServer = m_Ctx.GetServer("xraziobo");
            m_cPhName = m_Ctx.GetPhName("xraziobo");
            m_cSql = "";
            m_cSql = m_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,11,10),"C",10,0,m_cServer),m_cServer,CPLib.Substr(riga,11,10));
            if (m_Ctx.IsSharedTemp("xraziobo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("NUMPROG",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              uniquecode = Read_Cursor.GetString("IDBASE");
              cOpeProg2 = Read_Cursor.GetString("NUMPROG");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on xraziobo into routine arrt_imp_dati_multipli_old returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              uniquecode = "";
              cOpeProg2 = "";
              Read_Cursor.Close();
              /* w_msgproc := w_msgproc +"Rilevati errore nella valorizazione del campo IDFILEBO nel file "+nomefileimport+" per il soggetto con codice fiscale: "+Substr(riga,21,16)+" non risulta associabile a nessuna informazione/operazione.  Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
              w_msgproc = w_msgproc+"Rilevati errore nella valorizazione del campo IDFILEBO nel file "+nomefileimport+" per il soggetto con codice fiscale: "+CPLib.Substr(riga,21,16)+" non risulta associabile a nessuna informazione/operazione.  Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
              /* _esito := 1 */
              _esito = CPLib.Round(1,0);
              /* _salta := 1 */
              _salta = CPLib.Round(1,0);
              // Exit Loop
              if (true) {
                break;
              }
            }
            /* If _salta=0 and Substr(riga,11,10) = uniquecode */
            if (CPLib.eqr(_salta,0) && CPLib.eqr(CPLib.Substr(riga,11,10),uniquecode)) {
              // * --- Select from xogopefbo
              m_cServer = m_Ctx.GetServer("xogopefbo");
              m_cPhName = m_Ctx.GetPhName("xogopefbo");
              if (Cursor_xogopefbo!=null)
                Cursor_xogopefbo.Close();
              Cursor_xogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(uniquecode,"?",0,0,m_cServer, m_oParameters),m_cServer,uniquecode)+" "+")"+(m_Ctx.IsSharedTemp("xogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_xogopefbo.Eof())) {
                /* cMaxRow := xogopefbo->CPROWNUM */
                cMaxRow = CPLib.Round(Cursor_xogopefbo.GetDouble("CPROWNUM"),0);
                Cursor_xogopefbo.Next();
              }
              m_cConnectivityError = Cursor_xogopefbo.ErrorMessage();
              Cursor_xogopefbo.Close();
              // * --- End Select
              // * --- Insert into xogopefbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("xogopefbo");
              m_cPhName = m_Ctx.GetPhName("xogopefbo");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"xogopefbo")+" (";
              m_cSql = m_cSql+GetFieldsName_062B2660(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(uniquecode,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow+1,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,21,16),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,49,1),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(uniquecode,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,48,1),"?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("xogopefbo")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xogopefbo",true);
              m_cSql = m_cSql+")";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_nUpdatedRows = 0;
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.lt(m_nUpdatedRows,1)) {
                // No rows inserted
                /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per il soggetto operante con codice fiscale: "+Substr(riga,21,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per il soggetto operante con codice fiscale: "+CPLib.Substr(riga,21,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                /* _esito := 1 */
                _esito = CPLib.Round(1,0);
                // Exit Loop
                if (true) {
                  break;
                }
              } else if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
              /* _salta := 1 */
              _salta = CPLib.Round(1,0);
              /* cNumNew := cNumNew+1 */
              cNumNew = CPLib.Round(cNumNew+1,0);
            } // End If
          }
          /* If _salta=0 and Substr(riga,11,10) = uniquecode */
          if (CPLib.eqr(_salta,0) && CPLib.eqr(CPLib.Substr(riga,11,10),uniquecode)) {
            // * --- Select from xogopebo
            m_cServer = m_Ctx.GetServer("xogopebo");
            m_cPhName = m_Ctx.GetPhName("xogopebo");
            if (Cursor_xogopebo!=null)
              Cursor_xogopebo.Close();
            Cursor_xogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(uniquecode,"?",0,0,m_cServer, m_oParameters),m_cServer,uniquecode)+" "+")"+(m_Ctx.IsSharedTemp("xogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xogopebo.Eof())) {
              /* cMaxRow := xogopebo->CPROWNUM */
              cMaxRow = CPLib.Round(Cursor_xogopebo.GetDouble("CPROWNUM"),0);
              Cursor_xogopebo.Next();
            }
            m_cConnectivityError = Cursor_xogopebo.ErrorMessage();
            Cursor_xogopebo.Close();
            // * --- End Select
            // * --- Insert into xogopebo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xogopebo");
            m_cPhName = m_Ctx.GetPhName("xogopebo");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.InsertIntoStatement(m_Ctx,"xogopebo")+" (";
            m_cSql = m_cSql+GetFieldsName_06EB4168(m_Ctx);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(uniquecode,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow+1,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,21,16),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,49,1),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(uniquecode,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,48,1),"?",0,0,m_cServer)+", ";
            if (m_Ctx.IsSharedTemp("xogopebo")) {
              m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
            }
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xogopebo",true);
            m_cSql = m_cSql+")";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_nUpdatedRows = 0;
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.lt(m_nUpdatedRows,1)) {
              // No rows inserted
              /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per il soggetto operante con codice fiscale: "+Substr(riga,21,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
              w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per il soggetto operante con codice fiscale: "+CPLib.Substr(riga,21,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
              /* _esito := 1 */
              _esito = CPLib.Round(1,0);
              // Exit Loop
              if (true) {
                break;
              }
            } else if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
            /* cNumNew := cNumNew+1 */
            cNumNew = CPLib.Round(cNumNew+1,0);
          } // End If
        }
        /* If _salta=0 and Substr(riga,11,10) = uniquecode */
        if (CPLib.eqr(_salta,0) && CPLib.eqr(CPLib.Substr(riga,11,10),uniquecode)) {
          // * --- Select from xoginfo
          m_cServer = m_Ctx.GetServer("xoginfo");
          m_cPhName = m_Ctx.GetPhName("xoginfo");
          if (Cursor_xoginfo!=null)
            Cursor_xoginfo.Close();
          Cursor_xoginfo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO=uniquecode "+")"+(m_Ctx.IsSharedTemp("xoginfo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_xoginfo.Eof())) {
            /* cMaxRow := xoginfo->CPROWNUM */
            cMaxRow = CPLib.Round(Cursor_xoginfo.GetDouble("CPROWNUM"),0);
            Cursor_xoginfo.Next();
          }
          m_cConnectivityError = Cursor_xoginfo.ErrorMessage();
          Cursor_xoginfo.Close();
          // * --- End Select
          // * --- Insert into xoginfo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xoginfo");
          m_cPhName = m_Ctx.GetPhName("xoginfo");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"xoginfo")+" (";
          m_cSql = m_cSql+GetFieldsName_06CFD0C0(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(uniquecode,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow+1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,21,16),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,49,1),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(uniquecode,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,48,1),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,50,25),"?",0,0,m_cServer)+", ";
          if (m_Ctx.IsSharedTemp("xoginfo")) {
            m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
          }
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
          /* cNumNew := cNumNew+1 */
          cNumNew = CPLib.Round(cNumNew+1,0);
        } // End If
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport') */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* w_msgproc := w_msgproc + "Soggetti operanti inseriti: "+LRTrim(Str(cNumNew,10,0)) + " - Soggetti operanti aggiornati: "+LRTrim(Str(cNumMod,10,0)) + NL */
      w_msgproc = w_msgproc+"Soggetti operanti inseriti: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+" - Soggetti operanti aggiornati: "+CPLib.LRTrim(CPLib.Str(cNumMod,10,0))+"\n";
      /* w_msgproc := w_msgproc + 'Ora Fine Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Fine Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
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
        if (Cursor_xogopebo!=null)
          Cursor_xogopebo.Close();
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
    }
  }
  void Page_22() throws Exception {
    CPResultSet Cursor_xntestbo=null;
    try {
      /* Importazione file INTEST.TXT altri intestatari */
      /* w_msgproc := w_msgproc + 'Ora Inizio Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Inizio Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      /* cNumMod := 0 */
      cNumMod = CPLib.Round(0,0);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        /* cMaxRow := 0 */
        cMaxRow = CPLib.Round(0,0);
        /* cNumMod := 0 */
        cNumMod = CPLib.Round(0,0);
        /* Verifico in intestbo che ci sia già un recod con lo stesso codice rapporto e memorizzo i dati della riga necessari per crearne una nuova. */
        // * --- Select from xntestbo
        m_cServer = m_Ctx.GetServer("xntestbo");
        m_cPhName = m_Ctx.GetPhName("xntestbo");
        if (Cursor_xntestbo!=null)
          Cursor_xntestbo.Close();
        Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,1,25),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Substr(riga,1,25))+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM ",m_cServer,m_Ctx,true));
        if ( ! (Cursor_xntestbo.Eof())) {
          while ( ! (Cursor_xntestbo.Eof())) {
            /* If Substr(riga,26,16)=xntestbo->CODINTER */
            if (CPLib.eqr(CPLib.Substr(riga,26,16),Cursor_xntestbo.GetString("CODINTER"))) {
              /* cNumMod := xntestbo->CPROWNUM */
              cNumMod = CPLib.Round(Cursor_xntestbo.GetDouble("CPROWNUM"),0);
            } // End If
            /* cMaxRow := xntestbo->CPROWNUM */
            cMaxRow = CPLib.Round(Cursor_xntestbo.GetDouble("CPROWNUM"),0);
            /* ciidbase := xntestbo->IDBASE */
            ciidbase = Cursor_xntestbo.GetString("IDBASE");
            /* cidataini := xntestbo->DATAINI */
            cidataini = Cursor_xntestbo.GetDate("DATAINI");
            /* cidatafine := xntestbo->DATAFINE */
            cidatafine = Cursor_xntestbo.GetDate("DATAFINE");
            /* cicodinter := xntestbo->CODINTER */
            cicodinter = Cursor_xntestbo.GetString("CODINTER");
            /* cinumprog := xntestbo->NUMPROG1 */
            cinumprog = Cursor_xntestbo.GetString("NUMPROG1");
            /* citiporap := xntestbo->TIPORAP */
            citiporap = Cursor_xntestbo.GetString("TIPORAP");
            Cursor_xntestbo.Next();
          }
          m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
        } else {
          // No rows selected
          /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario con codice fiscale "+Substr(riga,26,16)+" relativa al rapporto: "+Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
          w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario con codice fiscale "+CPLib.Substr(riga,26,16)+" relativa al rapporto: "+CPLib.Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
          // Exit Loop
          if (true) {
            break;
          }
        }
        Cursor_xntestbo.Close();
        // * --- End Select
        /* Se trovo il record inserisco il nuovo intestatario */
        // * --- Insert into xntestbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("xntestbo");
        m_cPhName = m_Ctx.GetPhName("xntestbo");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"xntestbo")+" (";
        m_cSql = m_cSql+GetFieldsName_06D0F7C8(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(ciidbase,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow+1,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cidataini,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.Substr(riga,121,1))?"P":CPLib.Substr(riga,121,1)),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQLNull(cicodinter,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cinumprog,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,1,25),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(citiporap,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cidataini+cinumprog+"O","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(CPLib.Substr(riga,26,16))+CPLib.Space(5),16),"?",0,0,m_cServer)+", ";
        if (m_Ctx.IsSharedTemp("xntestbo")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xntestbo",true);
        m_cSql = m_cSql+")";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_nUpdatedRows = 0;
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.lt(m_nUpdatedRows,1)) {
          // No rows inserted
          /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario con codice fiscale "+Substr(riga,26,16)+" relativa al rapporto: "+Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
          w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario con codice fiscale "+CPLib.Substr(riga,26,16)+" relativa al rapporto: "+CPLib.Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
          // Exit Loop
          if (true) {
            break;
          }
        } else if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        /* cNumNew := cNumNew+1 */
        cNumNew = CPLib.Round(cNumNew+1,0);
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* w_msgproc := w_msgproc + "Intestatari inseriti: "+LRTrim(Str(cNumNew,10,0)) + " - Intestatari aggiornati: "+LRTrim(Str(cNumMod,10,0)) + NL */
      w_msgproc = w_msgproc+"Intestatari inseriti: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+" - Intestatari aggiornati: "+CPLib.LRTrim(CPLib.Str(cNumMod,10,0))+"\n";
      /* w_msgproc := w_msgproc + 'Ora Fine Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Fine Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
    } finally {
      try {
        if (Cursor_xntestbo!=null)
          Cursor_xntestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_23() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* Deleghe sui rapporti */
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      /* cNumMod := 0 */
      cNumMod = CPLib.Round(0,0);
      /* w_msgproc := w_msgproc + 'Ora Inizio Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Inizio Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        /* cMaxRow := 0 */
        cMaxRow = CPLib.Round(0,0);
        // * --- Read from jelegabo
        m_cServer = m_Ctx.GetServer("jelegabo");
        m_cPhName = m_Ctx.GetPhName("jelegabo");
        m_cSql = "";
        m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,25),"C",25,0,m_cServer),m_cServer,CPLib.Left(riga,25));
        m_cSql = m_cSql+" and CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,26,16),"C",16,0,m_cServer),m_cServer,CPLib.Substr(riga,26,16));
        if (m_Ctx.IsSharedTemp("jelegabo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CPROWNUM",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          cMaxRow = CPLib.Round(Read_Cursor.GetDouble("CPROWNUM"),0);
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on jelegabo into routine arrt_imp_dati_multipli_old returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          cMaxRow = 0;
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* xData := Substr(riga,46,4)+Substr(riga,44,2)+Substr(riga,42,2) */
        xData = CPLib.Substr(riga,46,4)+CPLib.Substr(riga,44,2)+CPLib.Substr(riga,42,2);
        /* xDatF := Substr(riga,55,4)+Substr(riga,53,2)+Substr(riga,51,2) */
        xDatF = CPLib.Substr(riga,55,4)+CPLib.Substr(riga,53,2)+CPLib.Substr(riga,51,2);
        /* If cMaxRow = 0 */
        if (CPLib.eqr(cMaxRow,0)) {
          // * --- Insert into jelegabo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("jelegabo");
          m_cPhName = m_Ctx.GetPhName("jelegabo");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"jelegabo")+" (";
          m_cSql = m_cSql+GetFieldsName_0703BBB8(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,25),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,26,16),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(xData),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,50,1),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(xDatF),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
          if (m_Ctx.IsSharedTemp("jelegabo")) {
            m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
          }
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"jelegabo",true);
          m_cSql = m_cSql+")";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows inserted
            /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per il soggetto con codice fiscale: "+Substr(riga,26,16)+" per il rapporto: "+Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
            w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per il soggetto con codice fiscale: "+CPLib.Substr(riga,26,16)+" per il rapporto: "+CPLib.Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            // Exit Loop
            if (true) {
              break;
            }
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          /* cNumNew := cNumNew + 1 */
          cNumNew = CPLib.Round(cNumNew+1,0);
        } else { // Else
          // * --- Write into jelegabo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("jelegabo");
          m_cPhName = m_Ctx.GetPhName("jelegabo");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = "Update "+m_cPhName+" set ";
          m_cSql = m_cSql+"DATAINI = "+CPLib.ToSQL(CPLib.CharToDate(xData),"D",8,0)+", ";
          m_cSql = m_cSql+"TIPORAP = "+CPLib.ToSQL(CPLib.Substr(riga,50,1),"C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(CPLib.CharToDate(xDatF),"D",8,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jelegabo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,25),"?",0,0,m_cServer),m_cServer,CPLib.Left(riga,25))+"";
          m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cMaxRow,"?",0,0,m_cServer),m_cServer,cMaxRow)+"";
          if (m_Ctx.IsSharedTemp("jelegabo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows updated
            /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per il soggetto con codice fiscale: "+Substr(riga,26,16)+" per il rapporto: "+Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
            w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per il soggetto con codice fiscale: "+CPLib.Substr(riga,26,16)+" per il rapporto: "+CPLib.Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            // Exit Loop
            if (true) {
              break;
            }
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          /* cNumMod := cNumMod + 1 */
          cNumMod = CPLib.Round(cNumMod+1,0);
        } // End If
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* w_msgproc := w_msgproc + 'Deleghe Rapporti Inserite: '+LRTrim(Str(cNumNew,10,0)) + " - Deleghe Rapporti Aggiornate: "+LRTrim(Str(cNumMod,10,0)) + NL */
      w_msgproc = w_msgproc+"Deleghe Rapporti Inserite: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+" - Deleghe Rapporti Aggiornate: "+CPLib.LRTrim(CPLib.Str(cNumMod,10,0))+"\n";
      /* w_msgproc := w_msgproc + 'Ora Fine Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Fine Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_24() throws Exception {
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_jogopebo=null;
    CPResultSet Cursor_joginfo=null;
    try {
      /* Importazione file SOGAGE.TXT altri soggetti operanti in Provvisorio */
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      /* cNumMod := 0 */
      cNumMod = CPLib.Round(0,0);
      /* w_msgproc := w_msgproc + 'Ora Inizio Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Inizio Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        /* cMaxRow := 0 */
        cMaxRow = CPLib.Round(0,0);
        /* uniquecode := '' */
        uniquecode = "";
        /* _salta := 0 */
        _salta = CPLib.Round(0,0);
        /* Verfico la presenza di uniquecode nelle tabelle rapopebo/operazbo/fraziobo */
        // * --- Read from japopebo
        m_cServer = m_Ctx.GetServer("japopebo");
        m_cPhName = m_Ctx.GetPhName("japopebo");
        m_cSql = "";
        m_cSql = m_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,11,10),"C",10,0,m_cServer),m_cServer,CPLib.Substr(riga,11,10));
        if (m_Ctx.IsSharedTemp("japopebo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("NUMPROG",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          uniquecode = Read_Cursor.GetString("IDBASE");
          cInfProg2 = Read_Cursor.GetString("NUMPROG");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on japopebo into routine arrt_imp_dati_multipli_old returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          uniquecode = "";
          cInfProg2 = "";
          Read_Cursor.Close();
          // * --- Read from jperazbo
          m_cServer = m_Ctx.GetServer("jperazbo");
          m_cPhName = m_Ctx.GetPhName("jperazbo");
          m_cSql = "";
          m_cSql = m_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,11,10),"C",10,0,m_cServer),m_cServer,CPLib.Substr(riga,11,10));
          if (m_Ctx.IsSharedTemp("jperazbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("NUMPROG",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            uniquecode = Read_Cursor.GetString("IDBASE");
            cOpeProg2 = Read_Cursor.GetString("NUMPROG");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on jperazbo into routine arrt_imp_dati_multipli_old returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            uniquecode = "";
            cOpeProg2 = "";
            Read_Cursor.Close();
            /* w_msgproc := w_msgproc +"Rilevati errore nella valorizazione del campo IDFILEBO nel file "+nomefileimport+" per il soggetto con codice fiscale: "+Substr(riga,21,16)+" non risulta associabile a nessuna informazione/operazione.  Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
            w_msgproc = w_msgproc+"Rilevati errore nella valorizazione del campo IDFILEBO nel file "+nomefileimport+" per il soggetto con codice fiscale: "+CPLib.Substr(riga,21,16)+" non risulta associabile a nessuna informazione/operazione.  Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            /* _salta := 1 */
            _salta = CPLib.Round(1,0);
            // Exit Loop
            if (true) {
              break;
            }
          }
          /* If _salta=0 and Substr(riga,11,10) = uniquecode */
          if (CPLib.eqr(_salta,0) && CPLib.eqr(CPLib.Substr(riga,11,10),uniquecode)) {
            // * --- Select from jogopebo
            m_cServer = m_Ctx.GetServer("jogopebo");
            m_cPhName = m_Ctx.GetPhName("jogopebo");
            if (Cursor_jogopebo!=null)
              Cursor_jogopebo.Close();
            Cursor_jogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(uniquecode,"?",0,0,m_cServer, m_oParameters),m_cServer,uniquecode)+" "+")"+(m_Ctx.IsSharedTemp("jogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_jogopebo.Eof())) {
              /* cMaxRow := jogopebo->CPROWNUM */
              cMaxRow = CPLib.Round(Cursor_jogopebo.GetDouble("CPROWNUM"),0);
              Cursor_jogopebo.Next();
            }
            m_cConnectivityError = Cursor_jogopebo.ErrorMessage();
            Cursor_jogopebo.Close();
            // * --- End Select
            // * --- Insert into jogopebo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("jogopebo");
            m_cPhName = m_Ctx.GetPhName("jogopebo");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.InsertIntoStatement(m_Ctx,"jogopebo")+" (";
            m_cSql = m_cSql+GetFieldsName_06DCB7B0(m_Ctx);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(uniquecode,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow+1,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,21,16),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,49,1),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(uniquecode,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,48,1),"?",0,0,m_cServer)+", ";
            if (m_Ctx.IsSharedTemp("jogopebo")) {
              m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
            }
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"jogopebo",true);
            m_cSql = m_cSql+")";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_nUpdatedRows = 0;
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.lt(m_nUpdatedRows,1)) {
              // No rows inserted
              /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per il soggetto operante con codice fiscale: "+Substr(riga,21,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
              w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per il soggetto operante con codice fiscale: "+CPLib.Substr(riga,21,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
              /* _esito := 1 */
              _esito = CPLib.Round(1,0);
              // Exit Loop
              if (true) {
                break;
              }
            } else if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
            /* cNumNew := cNumNew+1 */
            cNumNew = CPLib.Round(cNumNew+1,0);
          } // End If
        }
        /* If _salta=0 and Substr(riga,11,10) = uniquecode */
        if (CPLib.eqr(_salta,0) && CPLib.eqr(CPLib.Substr(riga,11,10),uniquecode)) {
          // * --- Select from joginfo
          m_cServer = m_Ctx.GetServer("joginfo");
          m_cPhName = m_Ctx.GetPhName("joginfo");
          if (Cursor_joginfo!=null)
            Cursor_joginfo.Close();
          Cursor_joginfo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO=uniquecode "+")"+(m_Ctx.IsSharedTemp("joginfo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_joginfo.Eof())) {
            /* cMaxRow := joginfo->CPROWNUM */
            cMaxRow = CPLib.Round(Cursor_joginfo.GetDouble("CPROWNUM"),0);
            Cursor_joginfo.Next();
          }
          m_cConnectivityError = Cursor_joginfo.ErrorMessage();
          Cursor_joginfo.Close();
          // * --- End Select
          // * --- Insert into joginfo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("joginfo");
          m_cPhName = m_Ctx.GetPhName("joginfo");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"joginfo")+" (";
          m_cSql = m_cSql+GetFieldsName_06D7BFA8(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(uniquecode,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow+1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,21,16),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,49,1),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(uniquecode,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,48,1),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,50,25),"?",0,0,m_cServer)+", ";
          if (m_Ctx.IsSharedTemp("joginfo")) {
            m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
          }
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"joginfo",true);
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
          /* cNumNew := cNumNew+1 */
          cNumNew = CPLib.Round(cNumNew+1,0);
        } // End If
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport') */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* w_msgproc := w_msgproc + "Soggetti operanti inseriti: "+LRTrim(Str(cNumNew,10,0)) + " - Soggetti operanti aggiornati: "+LRTrim(Str(cNumMod,10,0)) + NL */
      w_msgproc = w_msgproc+"Soggetti operanti inseriti: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+" - Soggetti operanti aggiornati: "+CPLib.LRTrim(CPLib.Str(cNumMod,10,0))+"\n";
      /* w_msgproc := w_msgproc + 'Ora Fine Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Fine Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jogopebo!=null)
          Cursor_jogopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_joginfo!=null)
          Cursor_joginfo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_25() throws Exception {
    CPResultSet Cursor_xntestbo=null;
    try {
      /* Importazione file INTAGE.TXT altri intestatari */
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      /* cNumMod := 0 */
      cNumMod = CPLib.Round(0,0);
      /* w_msgproc := w_msgproc + 'Ora Inizio Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Inizio Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        /* cMaxRow := 0 */
        cMaxRow = CPLib.Round(0,0);
        /* cNumMod := 0 */
        cNumMod = CPLib.Round(0,0);
        /* Verifico in intestbo che ci sia già un recod con lo stesso codice rapporto e memorizzo i dati della riga necessari per crearne una nuova. */
        // * --- Select from xntestbo
        m_cServer = m_Ctx.GetServer("xntestbo");
        m_cPhName = m_Ctx.GetPhName("xntestbo");
        if (Cursor_xntestbo!=null)
          Cursor_xntestbo.Close();
        Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,1,25),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Substr(riga,1,25))+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM ",m_cServer,m_Ctx,true));
        if ( ! (Cursor_xntestbo.Eof())) {
          while ( ! (Cursor_xntestbo.Eof())) {
            /* If Substr(riga,26,16)=xntestbo->CODINTER */
            if (CPLib.eqr(CPLib.Substr(riga,26,16),Cursor_xntestbo.GetString("CODINTER"))) {
              /* cNumMod := xntestbo->CPROWNUM */
              cNumMod = CPLib.Round(Cursor_xntestbo.GetDouble("CPROWNUM"),0);
            } // End If
            /* cMaxRow := xntestbo->CPROWNUM */
            cMaxRow = CPLib.Round(Cursor_xntestbo.GetDouble("CPROWNUM"),0);
            /* ciidbase := xntestbo->IDBASE */
            ciidbase = Cursor_xntestbo.GetString("IDBASE");
            /* cidataini := xntestbo->DATAINI */
            cidataini = Cursor_xntestbo.GetDate("DATAINI");
            /* cidatafine := xntestbo->DATAFINE */
            cidatafine = Cursor_xntestbo.GetDate("DATAFINE");
            /* cicodinter := xntestbo->CODINTER */
            cicodinter = Cursor_xntestbo.GetString("CODINTER");
            /* cinumprog := xntestbo->NUMPROG1 */
            cinumprog = Cursor_xntestbo.GetString("NUMPROG1");
            /* citiporap := xntestbo->TIPORAP */
            citiporap = Cursor_xntestbo.GetString("TIPORAP");
            Cursor_xntestbo.Next();
          }
          m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
        } else {
          // No rows selected
          /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario con codice fiscale "+Substr(riga,26,16)+" relativa al rapporto: "+Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
          w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario con codice fiscale "+CPLib.Substr(riga,26,16)+" relativa al rapporto: "+CPLib.Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
          // Exit Loop
          if (true) {
            break;
          }
        }
        Cursor_xntestbo.Close();
        // * --- End Select
        /* Se trovo il record inserisco il nuovo intestatario */
        // * --- Insert into xntestbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("xntestbo");
        m_cPhName = m_Ctx.GetPhName("xntestbo");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"xntestbo")+" (";
        m_cSql = m_cSql+GetFieldsName_06DB4D10(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(ciidbase,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow+1,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cidataini,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.Substr(riga,121,1))?"P":CPLib.Substr(riga,121,1)),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQLNull(cicodinter,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cinumprog,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,1,25),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(citiporap,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cidataini+cinumprog+"O","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(CPLib.Substr(riga,26,16))+CPLib.Space(5),16),"?",0,0,m_cServer)+", ";
        if (m_Ctx.IsSharedTemp("xntestbo")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xntestbo",true);
        m_cSql = m_cSql+")";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_nUpdatedRows = 0;
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.lt(m_nUpdatedRows,1)) {
          // No rows inserted
          /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario con codice fiscale "+Substr(riga,26,16)+" relativa al rapporto: "+Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
          w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario con codice fiscale "+CPLib.Substr(riga,26,16)+" relativa al rapporto: "+CPLib.Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
          // Exit Loop
          if (true) {
            break;
          }
        } else if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        /* cNumNew := cNumNew+1 */
        cNumNew = CPLib.Round(cNumNew+1,0);
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* w_msgproc := w_msgproc + "Intestatari inseriti: "+LRTrim(Str(cNumNew,10,0)) + " - Intestatari aggiornati: "+LRTrim(Str(cNumMod,10,0)) + NL */
      w_msgproc = w_msgproc+"Intestatari inseriti: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+" - Intestatari aggiornati: "+CPLib.LRTrim(CPLib.Str(cNumMod,10,0))+"\n";
      /* w_msgproc := w_msgproc + 'Ora Fine Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Fine Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
    } finally {
      try {
        if (Cursor_xntestbo!=null)
          Cursor_xntestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_26() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* Legge il file di testo e porta i dati nella tabella */
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      /* cNumMod := 0 */
      cNumMod = CPLib.Round(0,0);
      /* w_msgproc := w_msgproc + 'Ora Inizio Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Inizio Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        /* cCli1 := Substr(riga,1,16) */
        cCli1 = CPLib.Substr(riga,1,16);
        /* xConnes := Substr(riga,17,16) */
        xConnes = CPLib.Substr(riga,17,16);
        /* cMaxRow := 0 */
        cMaxRow = CPLib.Round(0,0);
        /* xData := Substr(riga,37,4)+Substr(riga,35,2)+Substr(riga,33,2) */
        xData = CPLib.Substr(riga,37,4)+CPLib.Substr(riga,35,2)+CPLib.Substr(riga,33,2);
        /* xDatF := Substr(riga,45,4)+Substr(riga,43,2)+Substr(riga,41,2) */
        xDatF = CPLib.Substr(riga,45,4)+CPLib.Substr(riga,43,2)+CPLib.Substr(riga,41,2);
        // * --- Read from titopers
        m_cServer = m_Ctx.GetServer("titopers");
        m_cPhName = m_Ctx.GetPhName("titopers");
        m_cSql = "";
        m_cSql = m_cSql+"CONTITO="+CPSql.SQLValueAdapter(CPLib.ToSQL(cCli1,"C",16,0,m_cServer),m_cServer,cCli1);
        m_cSql = m_cSql+" and CONPERS="+CPSql.SQLValueAdapter(CPLib.ToSQL(xConnes,"C",16,0,m_cServer),m_cServer,xConnes);
        if (m_Ctx.IsSharedTemp("titopers")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CPROWNUM",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          cMaxRow = CPLib.Round(Read_Cursor.GetDouble("CPROWNUM"),0);
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on titopers into routine arrt_imp_dati_multipli_old returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          cMaxRow = 0;
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If cMaxRow = 0 */
        if (CPLib.eqr(cMaxRow,0)) {
          // * --- Insert into titopers from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("titopers");
          m_cPhName = m_Ctx.GetPhName("titopers");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"titopers")+" (";
          m_cSql = m_cSql+GetFieldsName_06D6FF90(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cCli1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(xConnes,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(xData),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(xDatF),"?",0,0)+", ";
          if (m_Ctx.IsSharedTemp("titopers")) {
            m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
          }
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"titopers",true);
          m_cSql = m_cSql+")";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows inserted
            /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per il titolare con codice fiscale: "+Substr(riga,1,16)+" che controlla il soggetto con codice fiscale: "+Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
            w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per il titolare con codice fiscale: "+CPLib.Substr(riga,1,16)+" che controlla il soggetto con codice fiscale: "+CPLib.Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            // Exit Loop
            if (true) {
              break;
            }
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          /* cNumNew := cNumNew + 1 */
          cNumNew = CPLib.Round(cNumNew+1,0);
        } else { // Else
          // * --- Write into titopers from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("titopers");
          m_cPhName = m_Ctx.GetPhName("titopers");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = "Update "+m_cPhName+" set ";
          m_cSql = m_cSql+"DATAINI = "+CPLib.ToSQL(CPLib.CharToDate(xData),"D",8,0)+", ";
          m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(CPLib.CharToDate(xDatF),"D",8,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"titopers",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"CONTITO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,16),"?",0,0,m_cServer),m_cServer,CPLib.Left(riga,16))+"";
          m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cMaxRow,"?",0,0,m_cServer),m_cServer,cMaxRow)+"";
          if (m_Ctx.IsSharedTemp("titopers")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows updated
            /* w_msgproc := w_msgproc +"Rilevati errori nel file "+nomefileimport+" per il titolare con codice fiscale: "+Substr(riga,1,16)+" che controlla il soggetto con codice fiscale: "+Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
            w_msgproc = w_msgproc+"Rilevati errori nel file "+nomefileimport+" per il titolare con codice fiscale: "+CPLib.Substr(riga,1,16)+" che controlla il soggetto con codice fiscale: "+CPLib.Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            // Exit Loop
            if (true) {
              break;
            }
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          /* cNumMod := cNumMod + 1 */
          cNumMod = CPLib.Round(cNumMod+1,0);
        } // End If
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* w_msgproc := w_msgproc + 'Sog. Controllati Inseriti: '+LRTrim(Str(cNumNew,10,0)) + " - Sog. Controllati Aggiornati: "+LRTrim(Str(cNumMod,10,0)) + NL */
      w_msgproc = w_msgproc+"Sog. Controllati Inseriti: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+" - Sog. Controllati Aggiornati: "+CPLib.LRTrim(CPLib.Str(cNumMod,10,0))+"\n";
      /* w_msgproc := w_msgproc + 'Ora Fine Processo: '+DateTimeToChar(DateTime()) + 'del file' +nomefileimport + NL */
      w_msgproc = w_msgproc+"Ora Fine Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+nomefileimport+"\n";
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_27() throws Exception {
    CPResultSet Cursor_tmp_list_imprich=null;
    try {
      // * --- Select from tmp_list_imprich
      m_cServer = m_Ctx.GetServer("tmp_list_imprich");
      m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
      if (Cursor_tmp_list_imprich!=null)
        Cursor_tmp_list_imprich.Close();
      Cursor_tmp_list_imprich = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_list_imprich")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_tmp_list_imprich.Eof())) {
        /* czipfile := LRTrim(tmp_list_imprich->nomefile) */
        czipfile = CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile"));
        Cursor_tmp_list_imprich.Next();
      }
      m_cConnectivityError = Cursor_tmp_list_imprich.ErrorMessage();
      Cursor_tmp_list_imprich.Close();
      // * --- End Select
      /* w_msgproc := w_msgproc + 'Ora Inizio Processo: '+DateTimeToChar(DateTime()) + 'del file' + czipfile + NL */
      w_msgproc = w_msgproc+"Ora Inizio Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+czipfile+"\n";
      /* cpercorsozip := LRTrim(gPathApp)+"\appo\"+czipfile */
      cpercorsozip = CPLib.LRTrim(gPathApp)+"\\appo\\"+czipfile;
      /* cdirectoryfile := LRTrim(gPathApp)+"\appo\" */
      cdirectoryfile = CPLib.LRTrim(gPathApp)+"\\appo\\";
      try {
            // Apro il file zip
            java.util.zip.ZipFile zf = new java.util.zip.ZipFile(cpercorsozip);
      
            //Conto il numero di file all interno del file zip e creo un array di stringhe per memorizzare i nomi file
            conteggio=zf.size();
            lista=new String[conteggio];
            
            // Enumerate each entry
            i=0;
            for (java.util.Enumeration entries = zf.entries(); entries.hasMoreElements();) {
                // Get the entry name
                lista[i] = ((java.util.zip.ZipEntry)entries.nextElement()).getName();
                i++;
            }
           zf.close();
           } catch (java.io.IOException e) {
           }
      try {
            // Apro il file zip
            java.util.zip.ZipFile zf = new java.util.zip.ZipFile(cpercorsozip);
      
            byte[] buffer = new byte[1024]; 
            java.util.Enumeration entries = zf.entries();
            while(entries.hasMoreElements() ) {
              java.util.zip.ZipEntry entry = (java.util.zip.ZipEntry)entries.nextElement();
      
              System.err.println("Extracting file: " + entry.getName());
              java.io.InputStream in =zf.getInputStream(entry);
              java.io.OutputStream out = new java.io.BufferedOutputStream(new java.io.FileOutputStream(cdirectoryfile+entry.getName()));
      
              int len;
      
              while((len = in.read(buffer)) >= 0){
                out.write(buffer, 0, len);
              }
      
                in.close();
                out.close();
            }
      
            zf.close();
      } catch (java.io.IOException ioe) {
            System.err.println("Unhandled exception:");
            ioe.printStackTrace();
            return;
      }
      // * --- Delete from tmp_list_imprich
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("tmp_list_imprich");
      m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = "delete from "+m_cPhName;
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"nomefile = "+CPSql.SQLValueAdapter(CPLib.ToSQL(czipfile,"?",0,0,m_cServer),m_cServer,czipfile)+"";
      if (m_Ctx.IsSharedTemp("tmp_list_imprich")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
      if (CPLib.lt(m_nUpdatedRows,0)) {
        m_Sql.AbortTransaction();
      }
      m_Sql.CompleteTransaction();
      m_cLastMsgError = m_Sql.TransactionErrorMessage();
      if (CPLib.ne(m_cLastMsgError,"")) {
        m_bError = true;
      }
      /* contanome := 0 */
      contanome = 0;
      /* _priorita := 0 */
      _priorita = CPLib.Round(0,0);
      /* While contanome<conteggio */
      while (CPLib.lt(contanome,conteggio)) {
        buffernomefile=lista[contanome];
        /* Case Lower(Substr(buffernomefile,3))='archdip.txt' */
        if (CPLib.eqr(CPLib.Lower(CPLib.Substr(buffernomefile,3)),"archdip.txt")) {
          /* _priorita := 1 */
          _priorita = CPLib.Round(1,0);
          /* Case Lower(Substr(buffernomefile,3))='archpers.txt' */
        } else if (CPLib.eqr(CPLib.Lower(CPLib.Substr(buffernomefile,3)),"archpers.txt")) {
          /* _priorita := 2 */
          _priorita = CPLib.Round(2,0);
          /* Case Lower(Substr(buffernomefile,3))='archrap.txt' */
        } else if (CPLib.eqr(CPLib.Lower(CPLib.Substr(buffernomefile,3)),"archrap.txt")) {
          /* _priorita := 3 */
          _priorita = CPLib.Round(3,0);
          /* Case Lower(Substr(buffernomefile,3))='archinf.txt' */
        } else if (CPLib.eqr(CPLib.Lower(CPLib.Substr(buffernomefile,3)),"archinf.txt")) {
          /* _priorita := 4 */
          _priorita = CPLib.Round(4,0);
          /* Case Lower(Substr(buffernomefile,3))='archope.txt' */
        } else if (CPLib.eqr(CPLib.Lower(CPLib.Substr(buffernomefile,3)),"archope.txt")) {
          /* _priorita := 5 */
          _priorita = CPLib.Round(5,0);
          /* Case Lower(Substr(buffernomefile,3))='archfraz.txt' */
        } else if (CPLib.eqr(CPLib.Lower(CPLib.Substr(buffernomefile,3)),"archfraz.txt")) {
          /* _priorita := 6 */
          _priorita = CPLib.Round(6,0);
          /* Case Lower(Substr(buffernomefile,3))='opex.txt' */
        } else if (CPLib.eqr(CPLib.Lower(CPLib.Substr(buffernomefile,3)),"opex.txt")) {
          /* _priorita := 7 */
          _priorita = CPLib.Round(7,0);
          /* Case Lower(Substr(buffernomefile,3))='titola.txt' */
        } else if (CPLib.eqr(CPLib.Lower(CPLib.Substr(buffernomefile,3)),"titola.txt")) {
          /* _priorita := 8 */
          _priorita = CPLib.Round(8,0);
          /* Case Lower(Substr(buffernomefile,3))='titocont.txt' */
        } else if (CPLib.eqr(CPLib.Lower(CPLib.Substr(buffernomefile,3)),"titocont.txt")) {
          /* _priorita := 9 */
          _priorita = CPLib.Round(9,0);
          /* Case Lower(Substr(buffernomefile,3))='procdel.txt' */
        } else if (CPLib.eqr(CPLib.Lower(CPLib.Substr(buffernomefile,3)),"procdel.txt")) {
          /* _priorita := 10 */
          _priorita = CPLib.Round(10,0);
          /* Case Lower(Substr(buffernomefile,3))='sogope.txt' */
        } else if (CPLib.eqr(CPLib.Lower(CPLib.Substr(buffernomefile,3)),"sogope.txt")) {
          /* _priorita := 11 */
          _priorita = CPLib.Round(11,0);
          /* Case Lower(Substr(buffernomefile,3))='intest.txt' */
        } else if (CPLib.eqr(CPLib.Lower(CPLib.Substr(buffernomefile,3)),"intest.txt")) {
          /* _priorita := 12 */
          _priorita = CPLib.Round(12,0);
          /* Case Lower(Substr(buffernomefile,3))='stopers.txt' */
        } else if (CPLib.eqr(CPLib.Lower(CPLib.Substr(buffernomefile,3)),"stopers.txt")) {
          /* _priorita := 13 */
          _priorita = CPLib.Round(13,0);
          /* Case Lower(Substr(buffernomefile,3))='personew.txt' */
        } else if (CPLib.eqr(CPLib.Lower(CPLib.Substr(buffernomefile,3)),"personew.txt")) {
          /* _priorita := 14 */
          _priorita = CPLib.Round(14,0);
          /* Case Lower(Substr(buffernomefile,3))='rapage.txt' */
        } else if (CPLib.eqr(CPLib.Lower(CPLib.Substr(buffernomefile,3)),"rapage.txt")) {
          /* _priorita := 15 */
          _priorita = CPLib.Round(15,0);
          /* Case Lower(Substr(buffernomefile,3))='infage.txt' */
        } else if (CPLib.eqr(CPLib.Lower(CPLib.Substr(buffernomefile,3)),"infage.txt")) {
          /* _priorita := 16 */
          _priorita = CPLib.Round(16,0);
          /* Case Lower(Substr(buffernomefile,3))='sogage.txt' */
        } else if (CPLib.eqr(CPLib.Lower(CPLib.Substr(buffernomefile,3)),"sogage.txt")) {
          /* _priorita := 17 */
          _priorita = CPLib.Round(17,0);
          /* Case Lower(Substr(buffernomefile,3))='opeage.txt' */
        } else if (CPLib.eqr(CPLib.Lower(CPLib.Substr(buffernomefile,3)),"opeage.txt")) {
          /* _priorita := 18 */
          _priorita = CPLib.Round(18,0);
          /* Case Lower(Substr(buffernomefile,3))='procage.txt' */
        } else if (CPLib.eqr(CPLib.Lower(CPLib.Substr(buffernomefile,3)),"procage.txt")) {
          /* _priorita := 19 */
          _priorita = CPLib.Round(19,0);
        } // End Case
        // * --- Insert into tmp_list_imprich from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_list_imprich");
        m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_list_imprich")+" (";
        m_cSql = m_cSql+GetFieldsName_0614FD08(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(buffernomefile,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_priorita,"?",0,0)+", ";
        if (m_Ctx.IsSharedTemp("tmp_list_imprich")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_list_imprich",true);
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
        /* contanome := contanome+1 */
        contanome = contanome+1;
      } // End While
      /* FileLibrary.DeleteFile('./appo/'+czipfile) */
      FileLibrary.DeleteFile("./appo/"+czipfile);
      /* w_msgproc := w_msgproc + 'Ora Fine Processo: '+DateTimeToChar(DateTime()) + 'del file' +czipfile + NL */
      w_msgproc = w_msgproc+"Ora Fine Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"del file"+czipfile+"\n";
    } finally {
      try {
        if (Cursor_tmp_list_imprich!=null)
          Cursor_tmp_list_imprich.Close();
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
      m_Caller.SetString("tipodest","C",1,0,w_tipodest);
      m_Caller.SetString("msgproc","M",10,0,w_msgproc);
      m_Caller.SetNumber("impzip","N",1,0,w_impzip);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_imp_dati_multipli_oldR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_imp_dati_multipli_oldR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_tipodest = m_Caller.GetString("tipodest","C",1,0);
    w_msgproc = m_Caller.GetString("msgproc","M",10,0);
    w_impzip = m_Caller.GetNumber("impzip","N",1,0);
    fhand = CPLib.Space(1);
    riga = "";
    xConnes = CPLib.Space(16);
    xCF = CPLib.Space(16);
    xCodCab = CPLib.Space(6);
    xCitta = CPLib.Space(30);
    cCliProg = CPLib.Space(6);
    cInfProg1 = CPLib.Space(10);
    cInfProg2 = CPLib.Space(11);
    cOpeProg1 = CPLib.Space(10);
    cOpeProg2 = CPLib.Space(11);
    xSesso = CPLib.Space(1);
    xRapporto = CPLib.Space(25);
    xCAB = CPLib.Space(6);
    xDIP = CPLib.Space(6);
    xDIPx = CPLib.Space(6);
    cCli1 = CPLib.Space(16);
    xIDB = CPLib.Space(10);
    xData = CPLib.Space(8);
    xDatF = CPLib.Space(8);
    cNumNew = 0;
    cNumMod = 0;
    cFlagLire = CPLib.Space(1);
    cFlagCont = CPLib.Space(1);
    cFlagFraz = CPLib.Space(1);
    cMaxRow = 0;
    cIdCau = CPLib.Space(4);
    xCFE = 0;
    conta = 0;
    _esito = 0;
    cSNAS = CPLib.Space(30);
    cCNAS = CPLib.Space(30);
    uniquecode = CPLib.Space(10);
    _salta = 0;
    _allineamento = 0;
    _allineatonomecnome = 0;
    _ragsocold = CPLib.Space(70);
    _cabold = CPLib.Space(6);
    nProgImp = 0;
    ciidbase = CPLib.Space(10);
    cidataini = CPLib.NullDate();
    cidatafine = CPLib.NullDate();
    cicodinter = CPLib.Space(12);
    cinumprog = CPLib.Space(11);
    citiporap = CPLib.Space(1);
    czipfile = CPLib.Space(100);
    cpercorsozip = CPLib.Space(200);
    cdirectoryfile = CPLib.Space(200);
    buffernomefile = CPLib.Space(100);
    nomefileimport = CPLib.Space(50);
    _priorita = 0;
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_06F52090(CPContext p_Ctx) {
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
    p_cSql = p_cSql+"PARTIVA,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"TIPINTER,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+"PKTBSPECIE,";
    p_cSql = p_cSql+"COMPORT,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"ALLINEATO,";
    p_cSql = p_cSql+"ALLINEATONOMECNOME,";
    p_cSql = p_cSql+"PROGIMPORT,";
    p_cSql = p_cSql+"RAGSOCOLD,";
    if (p_Ctx.IsSharedTemp("personbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0619FDC8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"AREAGEO,";
    if (p_Ctx.IsSharedTemp("anarapbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"anarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06DF8EC0(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"UNIQUECOD,";
    p_cSql = p_cSql+"DESCINTER,";
    if (p_Ctx.IsSharedTemp("imp_info")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"imp_info",true);
    return p_cSql;
  }
  protected static String GetFieldsName_07A3A2E8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCINTER,";
    if (p_Ctx.IsSharedTemp("rapopebo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06EC8C28(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"RAPCOL,";
    if (p_Ctx.IsSharedTemp("soginfo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"soginfo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_07C16998(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"COLLEGAMEN,";
    if (p_Ctx.IsSharedTemp("intestbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"intestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06336040(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"DATAOPE,";
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
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"AGOPER,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"AREAGEO,";
    if (p_Ctx.IsSharedTemp("imp_opefra")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"imp_opefra",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06E66070(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
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
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    if (p_Ctx.IsSharedTemp("operazbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06DEF698(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"DATAOPE,";
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
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"AGOPER,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"AREAGEO,";
    if (p_Ctx.IsSharedTemp("imp_opefra")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"imp_opefra",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05E604F0(CPContext p_Ctx) {
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
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"AREAGEO,";
    if (p_Ctx.IsSharedTemp("fraziobo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"fraziobo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_07023738(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"AREAGEO,";
    if (p_Ctx.IsSharedTemp("xnarapbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xnarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_07CE0318(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"UNIQUECOD,";
    p_cSql = p_cSql+"DESCINTER,";
    if (p_Ctx.IsSharedTemp("imp_info")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"imp_info",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0705BAC8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCINTER,";
    if (p_Ctx.IsSharedTemp("xapopebo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06F77E20(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"RAPCOL,";
    if (p_Ctx.IsSharedTemp("xoginfo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xoginfo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_070593B0(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"COLLEGAMEN,";
    if (p_Ctx.IsSharedTemp("xntestbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xntestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05E9DE28(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"DATAOPE,";
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
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"AGOPER,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"AREAGEO,";
    if (p_Ctx.IsSharedTemp("imp_opefra")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"imp_opefra",true);
    return p_cSql;
  }
  protected static String GetFieldsName_062ED208(CPContext p_Ctx) {
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
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"AREAGEO,";
    if (p_Ctx.IsSharedTemp("xperazbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xperazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0704A600(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"DATAOPE,";
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
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"AGOPER,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"AREAGEO,";
    if (p_Ctx.IsSharedTemp("imp_opefra")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"imp_opefra",true);
    return p_cSql;
  }
  protected static String GetFieldsName_07BE7D70(CPContext p_Ctx) {
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
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"AREAGEO,";
    if (p_Ctx.IsSharedTemp("xraziobo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xraziobo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05B676B8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"AREAGEO,";
    if (p_Ctx.IsSharedTemp("jnarapbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"jnarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06DFC1F0(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"UNIQUECOD,";
    p_cSql = p_cSql+"DESCINTER,";
    if (p_Ctx.IsSharedTemp("imp_info")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"imp_info",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06EA51F8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCINTER,";
    if (p_Ctx.IsSharedTemp("japopebo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"japopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06DB8FB8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"RAPCOL,";
    if (p_Ctx.IsSharedTemp("joginfo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"joginfo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06EE4A40(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"COLLEGAMEN,";
    if (p_Ctx.IsSharedTemp("jntestbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"jntestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0628B6C0(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"DATAOPE,";
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
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"AGOPER,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"AREAGEO,";
    if (p_Ctx.IsSharedTemp("imp_opefra")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"imp_opefra",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05D132F0(CPContext p_Ctx) {
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
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"CDATAOPE,";
    if (p_Ctx.IsSharedTemp("jperazbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"jperazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0619AA40(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODDIP,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CAB,";
    if (p_Ctx.IsSharedTemp("anadip")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"anadip",true);
    return p_cSql;
  }
  protected static String GetFieldsName_062A4038(CPContext p_Ctx) {
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
    p_cSql = p_cSql+"PARTIVA,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"TIPINTER,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+"PKTBSPECIE,";
    p_cSql = p_cSql+"COMPORT,";
    p_cSql = p_cSql+"ATTIV,";
    if (p_Ctx.IsSharedTemp("titolabo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"titolabo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06347620(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"RIFIMP,";
    if (p_Ctx.IsSharedTemp("opextrbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"opextrbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05F07F50(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"IDBASE,";
    if (p_Ctx.IsSharedTemp("delegabo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"delegabo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0615E3F0(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    if (p_Ctx.IsSharedTemp("sogopefbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"sogopefbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06D12E58(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    if (p_Ctx.IsSharedTemp("sogopebo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"sogopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_070C5DC0(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"RAPCOL,";
    if (p_Ctx.IsSharedTemp("soginfo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"soginfo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06163C40(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"COLLEGAMEN,";
    if (p_Ctx.IsSharedTemp("intestbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"intestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06ECC6A8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"IDBASE,";
    if (p_Ctx.IsSharedTemp("xelegabo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xelegabo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_062B2660(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    if (p_Ctx.IsSharedTemp("xogopefbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xogopefbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06EB4168(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    if (p_Ctx.IsSharedTemp("xogopebo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xogopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06CFD0C0(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"RAPCOL,";
    if (p_Ctx.IsSharedTemp("xoginfo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xoginfo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06D0F7C8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"COLLEGAMEN,";
    if (p_Ctx.IsSharedTemp("xntestbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xntestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0703BBB8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"IDBASE,";
    if (p_Ctx.IsSharedTemp("jelegabo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"jelegabo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06DCB7B0(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    if (p_Ctx.IsSharedTemp("jogopebo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"jogopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06D7BFA8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"RAPCOL,";
    if (p_Ctx.IsSharedTemp("joginfo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"joginfo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06DB4D10(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"COLLEGAMEN,";
    if (p_Ctx.IsSharedTemp("xntestbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xntestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06D6FF90(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONTITO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CONPERS,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATAFINE,";
    if (p_Ctx.IsSharedTemp("titopers")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"titopers",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0614FD08(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"priorita,";
    if (p_Ctx.IsSharedTemp("tmp_list_imprich")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_list_imprich",true);
    return p_cSql;
  }
}
