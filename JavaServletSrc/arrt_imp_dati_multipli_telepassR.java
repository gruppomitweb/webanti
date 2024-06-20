// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_imp_dati_multipli_telepassR implements CallerWithObjs {
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
  public String m_cPhName_delegabo;
  public String m_cServer_delegabo;
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_knarapbo;
  public String m_cServer_knarapbo;
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
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
  public String m_cPhName_titolabo;
  public String m_cServer_titolabo;
  public String m_cPhName_titopers;
  public String m_cServer_titopers;
  public String m_cPhName_tmp_list_imprich;
  public String m_cServer_tmp_list_imprich;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
  public String m_cPhName_tmp_allin_anag;
  public String m_cServer_tmp_allin_anag;
  public String m_cPhName_tmp_imprappo;
  public String m_cServer_tmp_imprappo;
  public String m_cPhName_tmp_errimp;
  public String m_cServer_tmp_errimp;
  public String m_cPhName_tmp_newpers;
  public String m_cServer_tmp_newpers;
  public String m_cPhName_tmp_newrapp;
  public String m_cServer_tmp_newrapp;
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
  public String m_cPhName_aerighe;
  public String m_cServer_aerighe;
  public String m_cPhName_processi;
  public String m_cServer_processi;
  public String m_cPhName_dprocessi;
  public String m_cServer_dprocessi;
  public String m_cPhName_tprighe;
  public String m_cServer_tprighe;
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
  public String gMsgProc;
  public double w_impzip;
  public double w_errchk;
  public String fhand;
  public String riga;
  public double _chiudi;
  public double _modint;
  public String _tipoco;
  public double _nriga;
  public double _newrow;
  public String _rapold;
  public double _chkimp;
  public double _cfestero;
  public String _cfimport;
  public String xConnes;
  public String xRiga1;
  public String xRiga2;
  public String xCF;
  public String xAnnNas;
  public String xMesNas;
  public String xDayNas;
  public String xSesso;
  public String cSNAS;
  public String cCNAS;
  public String cPNAS;
  public java.sql.Date cDNAS;
  public String xSOCTCon;
  public String xSOCTCF;
  public String xCodCab;
  public String xCitta;
  public String cCliProg;
  public String cOpeProg1;
  public String cOpeProg2;
  public String xRapporto;
  public String cRapporto;
  public String xCAB;
  public String xDIP;
  public String xDIPx;
  public String cCli1;
  public String xIDB;
  public String xData;
  public String xDatF;
  public double cNumNew;
  public double cNumMod;
  public double cNumInv;
  public String cFlagLire;
  public String cFlagCont;
  public String cFlagFraz;
  public double cMaxRow;
  public String cIdCau;
  public double xCFE;
  public double conta;
  public double _esito;
  public String uniquecode;
  public double _salta;
  public double _allineamento;
  public double _allineatonomecnome;
  public String _ragsocold;
  public String _cabold;
  public double nProgImp;
  public String cProgSto;
  public double nProgImp2;
  public String _idbase;
  public String _codinter;
  public String _citinter;
  public String _cabinter;
  public String _prvinter;
  public String _descinter;
  public String _tipointer;
  public String _intercod;
  public String _intercit;
  public String _intercab;
  public String _interprv;
  public java.sql.Date _interini;
  public String xRagSoc;
  public double NSpazzi;
  public double NSpazzi2;
  public String xNome;
  public String xCognome;
  public double _allcn;
  public String Allineamento;
  public String SubRag;
  public double _i;
  public String Controllo;
  public String cSetSin;
  public String _tsogope;
  public double _rigsog;
  public double _rigint;
  public String cInfApri1;
  public String cInfApri2;
  public String cInfChiu1;
  public String cInfChiu2;
  public double numriga;
  public double imprec;
  public java.sql.Date xDatIni;
  public java.sql.Date xDatFin;
  public String xCodInt;
  public String xTipLeg;
  public String xCodLeg;
  public double xNumRig;
  public String _progproc;
  public double _progdproc;
  public String _progriga;
  public String _numriga;
  public String _tipper;
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
  // * --- arrt_imp_dati_multipli_telepass
  public String[] lista;
  public int conteggio;
  public int i;
  public int contanome;
  // * --- Fine Area Manuale
  public arrt_imp_dati_multipli_telepassR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_imp_dati_multipli_telepass",m_Caller);
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_delegabo = p_ContextObject.GetPhName("delegabo");
    m_cServer_delegabo = p_ContextObject.GetServer("delegabo");
    m_cPhName_fraziobo = p_ContextObject.GetPhName("fraziobo");
    m_cServer_fraziobo = p_ContextObject.GetServer("fraziobo");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_knarapbo = p_ContextObject.GetPhName("knarapbo");
    m_cServer_knarapbo = p_ContextObject.GetServer("knarapbo");
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_rapopebo = p_ContextObject.GetPhName("rapopebo");
    m_cServer_rapopebo = p_ContextObject.GetServer("rapopebo");
    m_cPhName_soginfo = p_ContextObject.GetPhName("soginfo");
    m_cServer_soginfo = p_ContextObject.GetServer("soginfo");
    m_cPhName_sogopebo = p_ContextObject.GetPhName("sogopebo");
    m_cServer_sogopebo = p_ContextObject.GetServer("sogopebo");
    m_cPhName_sogopefbo = p_ContextObject.GetPhName("sogopefbo");
    m_cServer_sogopefbo = p_ContextObject.GetServer("sogopefbo");
    m_cPhName_tbcauana = p_ContextObject.GetPhName("tbcauana");
    m_cServer_tbcauana = p_ContextObject.GetServer("tbcauana");
    m_cPhName_tbcitta = p_ContextObject.GetPhName("tbcitta");
    m_cServer_tbcitta = p_ContextObject.GetServer("tbcitta");
    m_cPhName_tbvalute = p_ContextObject.GetPhName("tbvalute");
    m_cServer_tbvalute = p_ContextObject.GetServer("tbvalute");
    m_cPhName_titolabo = p_ContextObject.GetPhName("titolabo");
    m_cServer_titolabo = p_ContextObject.GetServer("titolabo");
    m_cPhName_titopers = p_ContextObject.GetPhName("titopers");
    m_cServer_titopers = p_ContextObject.GetServer("titopers");
    m_cPhName_tmp_list_imprich = p_ContextObject.GetPhName("tmp_list_imprich");
    m_cServer_tmp_list_imprich = p_ContextObject.GetServer("tmp_list_imprich");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_cPhName_wersonbo = p_ContextObject.GetPhName("wersonbo");
    m_cServer_wersonbo = p_ContextObject.GetServer("wersonbo");
    m_cPhName_tmp_allin_anag = p_ContextObject.GetPhName("tmp_allin_anag");
    m_cServer_tmp_allin_anag = p_ContextObject.GetServer("tmp_allin_anag");
    m_cPhName_tmp_imprappo = p_ContextObject.GetPhName("tmp_imprappo");
    m_cServer_tmp_imprappo = p_ContextObject.GetServer("tmp_imprappo");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_errimp")) {
      m_cPhName_tmp_errimp = p_ContextObject.GetPhName("tmp_errimp");
      m_cServer_tmp_errimp = p_ContextObject.GetServer("tmp_errimp");
    }
    if (m_Ctx.IsTmpAlreadyCreated("tmp_newpers")) {
      m_cPhName_tmp_newpers = p_ContextObject.GetPhName("tmp_newpers");
      m_cServer_tmp_newpers = p_ContextObject.GetServer("tmp_newpers");
    }
    if (m_Ctx.IsTmpAlreadyCreated("tmp_newrapp")) {
      m_cPhName_tmp_newrapp = p_ContextObject.GetPhName("tmp_newrapp");
      m_cServer_tmp_newrapp = p_ContextObject.GetServer("tmp_newrapp");
    }
    m_cPhName_aetesta = p_ContextObject.GetPhName("aetesta");
    m_cServer_aetesta = p_ContextObject.GetServer("aetesta");
    m_cPhName_aerighe = p_ContextObject.GetPhName("aerighe");
    m_cServer_aerighe = p_ContextObject.GetServer("aerighe");
    m_cPhName_processi = p_ContextObject.GetPhName("processi");
    m_cServer_processi = p_ContextObject.GetServer("processi");
    m_cPhName_dprocessi = p_ContextObject.GetPhName("dprocessi");
    m_cServer_dprocessi = p_ContextObject.GetServer("dprocessi");
    m_cPhName_tprighe = p_ContextObject.GetPhName("tprighe");
    m_cServer_tprighe = p_ContextObject.GetServer("tprighe");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("impzip",p_cVarName)) {
      return w_impzip;
    }
    if (CPLib.eqr("errchk",p_cVarName)) {
      return w_errchk;
    }
    if (CPLib.eqr("_chiudi",p_cVarName)) {
      return _chiudi;
    }
    if (CPLib.eqr("_modint",p_cVarName)) {
      return _modint;
    }
    if (CPLib.eqr("_nriga",p_cVarName)) {
      return _nriga;
    }
    if (CPLib.eqr("_newrow",p_cVarName)) {
      return _newrow;
    }
    if (CPLib.eqr("_chkimp",p_cVarName)) {
      return _chkimp;
    }
    if (CPLib.eqr("_cfestero",p_cVarName)) {
      return _cfestero;
    }
    if (CPLib.eqr("cNumNew",p_cVarName)) {
      return cNumNew;
    }
    if (CPLib.eqr("cNumMod",p_cVarName)) {
      return cNumMod;
    }
    if (CPLib.eqr("cNumInv",p_cVarName)) {
      return cNumInv;
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
    if (CPLib.eqr("nProgImp2",p_cVarName)) {
      return nProgImp2;
    }
    if (CPLib.eqr("NSpazzi",p_cVarName)) {
      return NSpazzi;
    }
    if (CPLib.eqr("NSpazzi2",p_cVarName)) {
      return NSpazzi2;
    }
    if (CPLib.eqr("_allcn",p_cVarName)) {
      return _allcn;
    }
    if (CPLib.eqr("_i",p_cVarName)) {
      return _i;
    }
    if (CPLib.eqr("_rigsog",p_cVarName)) {
      return _rigsog;
    }
    if (CPLib.eqr("_rigint",p_cVarName)) {
      return _rigint;
    }
    if (CPLib.eqr("numriga",p_cVarName)) {
      return numriga;
    }
    if (CPLib.eqr("imprec",p_cVarName)) {
      return imprec;
    }
    if (CPLib.eqr("xNumRig",p_cVarName)) {
      return xNumRig;
    }
    if (CPLib.eqr("_progdproc",p_cVarName)) {
      return _progdproc;
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
      return "arrt_imp_dati_multipli_telepass";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("tipodest",p_cVarName)) {
      return w_tipodest;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      return riga;
    }
    if (CPLib.eqr("_tipoco",p_cVarName)) {
      return _tipoco;
    }
    if (CPLib.eqr("_rapold",p_cVarName)) {
      return _rapold;
    }
    if (CPLib.eqr("_cfimport",p_cVarName)) {
      return _cfimport;
    }
    if (CPLib.eqr("xConnes",p_cVarName)) {
      return xConnes;
    }
    if (CPLib.eqr("xRiga1",p_cVarName)) {
      return xRiga1;
    }
    if (CPLib.eqr("xRiga2",p_cVarName)) {
      return xRiga2;
    }
    if (CPLib.eqr("xCF",p_cVarName)) {
      return xCF;
    }
    if (CPLib.eqr("xAnnNas",p_cVarName)) {
      return xAnnNas;
    }
    if (CPLib.eqr("xMesNas",p_cVarName)) {
      return xMesNas;
    }
    if (CPLib.eqr("xDayNas",p_cVarName)) {
      return xDayNas;
    }
    if (CPLib.eqr("xSesso",p_cVarName)) {
      return xSesso;
    }
    if (CPLib.eqr("cSNAS",p_cVarName)) {
      return cSNAS;
    }
    if (CPLib.eqr("cCNAS",p_cVarName)) {
      return cCNAS;
    }
    if (CPLib.eqr("cPNAS",p_cVarName)) {
      return cPNAS;
    }
    if (CPLib.eqr("xSOCTCon",p_cVarName)) {
      return xSOCTCon;
    }
    if (CPLib.eqr("xSOCTCF",p_cVarName)) {
      return xSOCTCF;
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
    if (CPLib.eqr("cOpeProg1",p_cVarName)) {
      return cOpeProg1;
    }
    if (CPLib.eqr("cOpeProg2",p_cVarName)) {
      return cOpeProg2;
    }
    if (CPLib.eqr("xRapporto",p_cVarName)) {
      return xRapporto;
    }
    if (CPLib.eqr("cRapporto",p_cVarName)) {
      return cRapporto;
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
    if (CPLib.eqr("uniquecode",p_cVarName)) {
      return uniquecode;
    }
    if (CPLib.eqr("_ragsocold",p_cVarName)) {
      return _ragsocold;
    }
    if (CPLib.eqr("_cabold",p_cVarName)) {
      return _cabold;
    }
    if (CPLib.eqr("cProgSto",p_cVarName)) {
      return cProgSto;
    }
    if (CPLib.eqr("_idbase",p_cVarName)) {
      return _idbase;
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
    if (CPLib.eqr("_descinter",p_cVarName)) {
      return _descinter;
    }
    if (CPLib.eqr("_tipointer",p_cVarName)) {
      return _tipointer;
    }
    if (CPLib.eqr("_intercod",p_cVarName)) {
      return _intercod;
    }
    if (CPLib.eqr("_intercit",p_cVarName)) {
      return _intercit;
    }
    if (CPLib.eqr("_intercab",p_cVarName)) {
      return _intercab;
    }
    if (CPLib.eqr("_interprv",p_cVarName)) {
      return _interprv;
    }
    if (CPLib.eqr("xRagSoc",p_cVarName)) {
      return xRagSoc;
    }
    if (CPLib.eqr("xNome",p_cVarName)) {
      return xNome;
    }
    if (CPLib.eqr("xCognome",p_cVarName)) {
      return xCognome;
    }
    if (CPLib.eqr("Allineamento",p_cVarName)) {
      return Allineamento;
    }
    if (CPLib.eqr("SubRag",p_cVarName)) {
      return SubRag;
    }
    if (CPLib.eqr("Controllo",p_cVarName)) {
      return Controllo;
    }
    if (CPLib.eqr("cSetSin",p_cVarName)) {
      return cSetSin;
    }
    if (CPLib.eqr("_tsogope",p_cVarName)) {
      return _tsogope;
    }
    if (CPLib.eqr("cInfApri1",p_cVarName)) {
      return cInfApri1;
    }
    if (CPLib.eqr("cInfApri2",p_cVarName)) {
      return cInfApri2;
    }
    if (CPLib.eqr("cInfChiu1",p_cVarName)) {
      return cInfChiu1;
    }
    if (CPLib.eqr("cInfChiu2",p_cVarName)) {
      return cInfChiu2;
    }
    if (CPLib.eqr("xCodInt",p_cVarName)) {
      return xCodInt;
    }
    if (CPLib.eqr("xTipLeg",p_cVarName)) {
      return xTipLeg;
    }
    if (CPLib.eqr("xCodLeg",p_cVarName)) {
      return xCodLeg;
    }
    if (CPLib.eqr("_progproc",p_cVarName)) {
      return _progproc;
    }
    if (CPLib.eqr("_progriga",p_cVarName)) {
      return _progriga;
    }
    if (CPLib.eqr("_numriga",p_cVarName)) {
      return _numriga;
    }
    if (CPLib.eqr("_tipper",p_cVarName)) {
      return _tipper;
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
    if (CPLib.eqr("cDNAS",p_cVarName)) {
      return cDNAS;
    }
    if (CPLib.eqr("_interini",p_cVarName)) {
      return _interini;
    }
    if (CPLib.eqr("xDatIni",p_cVarName)) {
      return xDatIni;
    }
    if (CPLib.eqr("xDatFin",p_cVarName)) {
      return xDatFin;
    }
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
    if (CPLib.eqr("errchk",p_cVarName)) {
      w_errchk = value;
      return;
    }
    if (CPLib.eqr("_chiudi",p_cVarName)) {
      _chiudi = value;
      return;
    }
    if (CPLib.eqr("_modint",p_cVarName)) {
      _modint = value;
      return;
    }
    if (CPLib.eqr("_nriga",p_cVarName)) {
      _nriga = value;
      return;
    }
    if (CPLib.eqr("_newrow",p_cVarName)) {
      _newrow = value;
      return;
    }
    if (CPLib.eqr("_chkimp",p_cVarName)) {
      _chkimp = value;
      return;
    }
    if (CPLib.eqr("_cfestero",p_cVarName)) {
      _cfestero = value;
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
    if (CPLib.eqr("cNumInv",p_cVarName)) {
      cNumInv = value;
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
    if (CPLib.eqr("nProgImp2",p_cVarName)) {
      nProgImp2 = value;
      return;
    }
    if (CPLib.eqr("NSpazzi",p_cVarName)) {
      NSpazzi = value;
      return;
    }
    if (CPLib.eqr("NSpazzi2",p_cVarName)) {
      NSpazzi2 = value;
      return;
    }
    if (CPLib.eqr("_allcn",p_cVarName)) {
      _allcn = value;
      return;
    }
    if (CPLib.eqr("_i",p_cVarName)) {
      _i = value;
      return;
    }
    if (CPLib.eqr("_rigsog",p_cVarName)) {
      _rigsog = value;
      return;
    }
    if (CPLib.eqr("_rigint",p_cVarName)) {
      _rigint = value;
      return;
    }
    if (CPLib.eqr("numriga",p_cVarName)) {
      numriga = value;
      return;
    }
    if (CPLib.eqr("imprec",p_cVarName)) {
      imprec = value;
      return;
    }
    if (CPLib.eqr("xNumRig",p_cVarName)) {
      xNumRig = value;
      return;
    }
    if (CPLib.eqr("_progdproc",p_cVarName)) {
      _progdproc = value;
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
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
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
    if (CPLib.eqr("_tipoco",p_cVarName)) {
      _tipoco = value;
      return;
    }
    if (CPLib.eqr("_rapold",p_cVarName)) {
      _rapold = value;
      return;
    }
    if (CPLib.eqr("_cfimport",p_cVarName)) {
      _cfimport = value;
      return;
    }
    if (CPLib.eqr("xConnes",p_cVarName)) {
      xConnes = value;
      return;
    }
    if (CPLib.eqr("xRiga1",p_cVarName)) {
      xRiga1 = value;
      return;
    }
    if (CPLib.eqr("xRiga2",p_cVarName)) {
      xRiga2 = value;
      return;
    }
    if (CPLib.eqr("xCF",p_cVarName)) {
      xCF = value;
      return;
    }
    if (CPLib.eqr("xAnnNas",p_cVarName)) {
      xAnnNas = value;
      return;
    }
    if (CPLib.eqr("xMesNas",p_cVarName)) {
      xMesNas = value;
      return;
    }
    if (CPLib.eqr("xDayNas",p_cVarName)) {
      xDayNas = value;
      return;
    }
    if (CPLib.eqr("xSesso",p_cVarName)) {
      xSesso = value;
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
    if (CPLib.eqr("cPNAS",p_cVarName)) {
      cPNAS = value;
      return;
    }
    if (CPLib.eqr("xSOCTCon",p_cVarName)) {
      xSOCTCon = value;
      return;
    }
    if (CPLib.eqr("xSOCTCF",p_cVarName)) {
      xSOCTCF = value;
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
    if (CPLib.eqr("cOpeProg1",p_cVarName)) {
      cOpeProg1 = value;
      return;
    }
    if (CPLib.eqr("cOpeProg2",p_cVarName)) {
      cOpeProg2 = value;
      return;
    }
    if (CPLib.eqr("xRapporto",p_cVarName)) {
      xRapporto = value;
      return;
    }
    if (CPLib.eqr("cRapporto",p_cVarName)) {
      cRapporto = value;
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
    if (CPLib.eqr("cProgSto",p_cVarName)) {
      cProgSto = value;
      return;
    }
    if (CPLib.eqr("_idbase",p_cVarName)) {
      _idbase = value;
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
    if (CPLib.eqr("_descinter",p_cVarName)) {
      _descinter = value;
      return;
    }
    if (CPLib.eqr("_tipointer",p_cVarName)) {
      _tipointer = value;
      return;
    }
    if (CPLib.eqr("_intercod",p_cVarName)) {
      _intercod = value;
      return;
    }
    if (CPLib.eqr("_intercit",p_cVarName)) {
      _intercit = value;
      return;
    }
    if (CPLib.eqr("_intercab",p_cVarName)) {
      _intercab = value;
      return;
    }
    if (CPLib.eqr("_interprv",p_cVarName)) {
      _interprv = value;
      return;
    }
    if (CPLib.eqr("xRagSoc",p_cVarName)) {
      xRagSoc = value;
      return;
    }
    if (CPLib.eqr("xNome",p_cVarName)) {
      xNome = value;
      return;
    }
    if (CPLib.eqr("xCognome",p_cVarName)) {
      xCognome = value;
      return;
    }
    if (CPLib.eqr("Allineamento",p_cVarName)) {
      Allineamento = value;
      return;
    }
    if (CPLib.eqr("SubRag",p_cVarName)) {
      SubRag = value;
      return;
    }
    if (CPLib.eqr("Controllo",p_cVarName)) {
      Controllo = value;
      return;
    }
    if (CPLib.eqr("cSetSin",p_cVarName)) {
      cSetSin = value;
      return;
    }
    if (CPLib.eqr("_tsogope",p_cVarName)) {
      _tsogope = value;
      return;
    }
    if (CPLib.eqr("cInfApri1",p_cVarName)) {
      cInfApri1 = value;
      return;
    }
    if (CPLib.eqr("cInfApri2",p_cVarName)) {
      cInfApri2 = value;
      return;
    }
    if (CPLib.eqr("cInfChiu1",p_cVarName)) {
      cInfChiu1 = value;
      return;
    }
    if (CPLib.eqr("cInfChiu2",p_cVarName)) {
      cInfChiu2 = value;
      return;
    }
    if (CPLib.eqr("xCodInt",p_cVarName)) {
      xCodInt = value;
      return;
    }
    if (CPLib.eqr("xTipLeg",p_cVarName)) {
      xTipLeg = value;
      return;
    }
    if (CPLib.eqr("xCodLeg",p_cVarName)) {
      xCodLeg = value;
      return;
    }
    if (CPLib.eqr("_progproc",p_cVarName)) {
      _progproc = value;
      return;
    }
    if (CPLib.eqr("_progriga",p_cVarName)) {
      _progriga = value;
      return;
    }
    if (CPLib.eqr("_numriga",p_cVarName)) {
      _numriga = value;
      return;
    }
    if (CPLib.eqr("_tipper",p_cVarName)) {
      _tipper = value;
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
    if (CPLib.eqr("cDNAS",p_cVarName)) {
      cDNAS = value;
      return;
    }
    if (CPLib.eqr("_interini",p_cVarName)) {
      _interini = value;
      return;
    }
    if (CPLib.eqr("xDatIni",p_cVarName)) {
      xDatIni = value;
      return;
    }
    if (CPLib.eqr("xDatFin",p_cVarName)) {
      xDatFin = value;
      return;
    }
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
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_tmp_list_imprich=null;
    try {
      /* Dichiarazione variabili del caller */
      /* w_tipodest Char(1) */
      /* gMsgProc Memo */
      /* w_impzip Numeric(1, 0) */
      /* w_errchk Numeric(1, 0) */
      /* Definizione variabili locali */
      /* fhand Char(1) */
      /* riga Memo */
      /* _chiudi Numeric(1, 0) */
      /* _modint Numeric(1, 0) */
      /* _tipoco Char(1) */
      /* _nriga Numeric(4, 0) */
      /* _newrow Numeric(4, 0) */
      /* _rapold Char(25) */
      /* _chkimp Numeric(1, 0) */
      /* _cfestero Numeric(1, 0) */
      /* _cfimport Char(16) */
      /* xConnes Char(16) */
      /* xRiga1 Memo */
      /* xRiga2 Memo */
      /* xCF Char(16) */
      /* xAnnNas Char(2) // Anno Di Nascita */
      /* xMesNas Char(2) // Mese Di Nascita */
      /* xDayNas Char(2) // Giorno Di Nascita */
      /* xSesso Char(1) */
      /* cSNAS Char(40) */
      /* cCNAS Char(40) */
      /* cPNAS Char(2) */
      /* cDNAS Date */
      /* xSOCTCon Char(16) */
      /* xSOCTCF Char(16) */
      /* xCodCab Char(6) */
      /* xCitta Char(30) */
      /* cCliProg Char(6) */
      /* cOpeProg1 Char(10) */
      /* cOpeProg2 Char(11) */
      /* xRapporto Char(25) */
      /* cRapporto Char(25) */
      /* xCAB Char(6) */
      /* xDIP Char(6) */
      /* xDIPx Char(6) */
      /* cCli1 Char(16) */
      /* xIDB Char(10) */
      /* xData Char(8) */
      /* xDatF Char(8) */
      /* cNumNew Numeric(10, 0) // Contatore record nuovi */
      /* cNumMod Numeric(10, 0) // Contatore record aggiornati */
      /* cNumInv Numeric(10, 0) // Contatore record invariati */
      /* cFlagLire Char(1) */
      /* cFlagCont Char(1) */
      /* cFlagFraz Char(1) */
      /* cMaxRow Numeric(4, 0) */
      /* cIdCau Char(4) */
      /* xCFE Numeric(1, 0) */
      /* conta Numeric(10, 0) */
      /* _esito Numeric(1, 0) */
      /* uniquecode Char(10) */
      /* _salta Numeric(1, 0) */
      /* _allineamento Numeric(1, 0) */
      /* _allineatonomecnome Numeric(1, 0) */
      /* _ragsocold Char(70) */
      /* _cabold Char(6) */
      /* nProgImp Numeric(15, 0) */
      /* cProgSto Char(15) */
      /* nProgImp2 Numeric(15, 0) */
      /* _idbase Char(10) */
      /* _codinter Char(11) */
      /* _citinter Char(30) */
      /* _cabinter Char(6) */
      /* _prvinter Char(2) */
      /* _descinter Char(70) // Descrizione Intermediario */
      /* _tipointer Char(2) // Descrizione Intermediario */
      /* _intercod Char(11) */
      /* _intercit Char(30) */
      /* _intercab Char(6) */
      /* _interprv Char(2) */
      /* _interini Date */
      /* xRagSoc Char(70) */
      /* NSpazzi Numeric(2, 0) */
      /* NSpazzi2 Numeric(2, 0) */
      /* xNome Char(25) */
      /* xCognome Char(26) */
      /* _allcn Numeric(1, 0) */
      /* Allineamento Char(2) */
      /* SubRag Char(70) */
      /* _i Numeric(10, 0) */
      /* Controllo Char(103) */
      /* cSetSin Char(3) */
      /* _tsogope Char(2) */
      /* _rigsog Numeric(2, 0) */
      /* _rigint Numeric(2, 0) */
      /* cInfApri1 Char(10) */
      /* cInfApri2 Char(11) */
      /* cInfChiu1 Char(10) */
      /* cInfChiu2 Char(11) */
      /* numriga Numeric(10, 0) */
      /* imprec Numeric(10, 0) */
      /* xDatIni Date */
      /* xDatFin Date */
      /* xCodInt Char(9) */
      /* xTipLeg Char(2) */
      /* xCodLeg Char(9) */
      /* xNumRig Numeric(3, 0) */
      /* _progproc Char(10) */
      /* _progdproc Numeric(5, 0) */
      /* _progriga Char(15) */
      /* _numriga Char(3) */
      /* _tipper Char(1) */
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
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgImp Memo // Messaggio Import */
      /* Legge dati intermediario per metteri su operazbo,fraziobo,rapopebo se mancanti */
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _codinter := intermbo->CODINTER */
        _codinter = Cursor_intermbo.GetString("CODINTER");
        /* _citinter := intermbo->DESCCIT */
        _citinter = Cursor_intermbo.GetString("DESCCIT");
        /* _cabinter := intermbo->CODCAB */
        _cabinter = Cursor_intermbo.GetString("CODCAB");
        /* _prvinter := intermbo->PROVINCIA */
        _prvinter = Cursor_intermbo.GetString("PROVINCIA");
        /* _descinter := intermbo->RAGSOC // Descrizione Intermediario */
        _descinter = Cursor_intermbo.GetString("RAGSOC");
        /* _tipointer := intermbo->TIPINTER // Descrizione Intermediario */
        _tipointer = Cursor_intermbo.GetString("TIPINTER");
        /* _interini := intermbo->DTINIATT */
        _interini = Cursor_intermbo.GetDate("DTINIATT");
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* Import Soggetti */
      /* gMsgProc := '' */
      gMsgProc = "";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Controllo := "du/del/dell'/l'/d'/di/de/la/li/lu/lo/le/degli/degl'/il/della/dello/delle/dell'/de'/o'/mc/mac/o/von/van/" */
      Controllo = "du/del/dell'/l'/d'/di/de/la/li/lu/lo/le/degli/degl'/il/della/dello/delle/dell'/de'/o'/mc/mac/o/von/van/";
      /* Cicla sul file della lista e lancia la pagina appropriata */
      /* w_errchk := 0 */
      w_errchk = CPLib.Round(0,0);
      /* _esito := 0 */
      _esito = CPLib.Round(0,0);
      // Begin Transaction
      m_Sql.RequireTransaction();
      // * --- Drop temporary table tmp_newpers
      if (m_Ctx.IsSharedTemp("tmp_newpers")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_newpers")) {
          m_cServer = m_Ctx.GetServer("tmp_newpers");
          m_cPhName = m_Ctx.GetPhName("tmp_newpers");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_newpers");
      }
      // * --- Create temporary table tmp_newpers
      if (m_Ctx.IsSharedTemp("tmp_newpers")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_newpers")) {
          m_cServer = m_Ctx.GetServer("tmp_newpers");
          m_cPhName = m_Ctx.GetPhName("tmp_newpers");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_newpers");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_newpers");
      if ( ! (m_Ctx.IsSharedTemp("tmp_newpers"))) {
        m_cServer = m_Ctx.GetServer("tmp_newpers");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_newpers",m_cServer,"proto")),m_cPhName,"tmp_newpers",m_Ctx);
      }
      m_cPhName_tmp_newpers = m_cPhName;
      // * --- Drop temporary table tmp_newrapp
      if (m_Ctx.IsSharedTemp("tmp_newrapp")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_newrapp")) {
          m_cServer = m_Ctx.GetServer("tmp_newrapp");
          m_cPhName = m_Ctx.GetPhName("tmp_newrapp");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_newrapp");
      }
      // * --- Create temporary table tmp_newrapp
      if (m_Ctx.IsSharedTemp("tmp_newrapp")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_newrapp")) {
          m_cServer = m_Ctx.GetServer("tmp_newrapp");
          m_cPhName = m_Ctx.GetPhName("tmp_newrapp");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_newrapp");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_newrapp");
      if ( ! (m_Ctx.IsSharedTemp("tmp_newrapp"))) {
        m_cServer = m_Ctx.GetServer("tmp_newrapp");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_newrapp",m_cServer,"proto")),m_cPhName,"tmp_newrapp",m_Ctx);
      }
      m_cPhName_tmp_newrapp = m_cPhName;
      // * --- Drop temporary table tmp_errimp
      if (m_Ctx.IsSharedTemp("tmp_errimp")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_errimp")) {
          m_cServer = m_Ctx.GetServer("tmp_errimp");
          m_cPhName = m_Ctx.GetPhName("tmp_errimp");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_errimp");
      }
      // * --- Create temporary table tmp_errimp
      if (m_Ctx.IsSharedTemp("tmp_errimp")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_errimp")) {
          m_cServer = m_Ctx.GetServer("tmp_errimp");
          m_cPhName = m_Ctx.GetPhName("tmp_errimp");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_errimp");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_errimp");
      if ( ! (m_Ctx.IsSharedTemp("tmp_errimp"))) {
        m_cServer = m_Ctx.GetServer("tmp_errimp");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_errimp",m_cServer,"proto")),m_cPhName,"tmp_errimp",m_Ctx);
      }
      m_cPhName_tmp_errimp = m_cPhName;
      /* _progproc := Utilities.GetAutonumber('IMP','',10) */
      _progproc = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("IMP","",10);
      // * --- Insert into processi from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("processi");
      m_cPhName = m_Ctx.GetPhName("processi");
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.InsertIntoStatement(m_Ctx,"processi")+" (";
      m_cSql = m_cSql+GetFieldsName_05B4EA70(m_Ctx);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL("IMP","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_progproc,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("Importo Rapporti Continuativi","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
      if (m_Ctx.IsSharedTemp("processi")) {
        m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
      }
      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"processi",true);
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
      /* Exec "Estrai zip" Page 2 */
      Page_2();
      // * --- Select from tmp_list_imprich
      m_cServer = m_Ctx.GetServer("tmp_list_imprich");
      m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
      if (Cursor_tmp_list_imprich!=null)
        Cursor_tmp_list_imprich.Close();
      Cursor_tmp_list_imprich = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_list_imprich")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1")+" order by "+"priorita,nomefile ",m_cServer,m_Ctx,true));
      while ( ! (Cursor_tmp_list_imprich.Eof())) {
        double nTry06D5C040status;
        nTry06D5C040status = m_Sql.GetTransactionStatus();
        String cTry06D5C040msg;
        cTry06D5C040msg = m_Sql.TransactionErrorMessage();
        try {
          /* If _esito = 0 */
          if (CPLib.eqr(_esito,0)) {
            /* nomefileimport := LRTrim(tmp_list_imprich->nomefile) */
            nomefileimport = CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile"));
            /* Case At('archpers.txt',Lower(nomefileimport)) <> 0 */
            if (CPLib.ne(CPLib.At("archpers.txt",CPLib.Lower(nomefileimport)),0)) {
              /* Exec "Soggetti" Page 3 */
              Page_3();
              if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                throw new RoutineException();
              }
              /* Case At('archdip.txt',Lower(nomefileimport)) <> 0 */
            } else if (CPLib.ne(CPLib.At("archdip.txt",CPLib.Lower(nomefileimport)),0)) {
              /* Case At('archrap.txt',Lower(nomefileimport)) <> 0 */
            } else if (CPLib.ne(CPLib.At("archrap.txt",CPLib.Lower(nomefileimport)),0)) {
              /* Exec "Rapporti" Page 5 */
              Page_5();
              if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                throw new RoutineException();
              }
              /* Case At('archope.txt',Lower(nomefileimport)) <> 0 */
            } else if (CPLib.ne(CPLib.At("archope.txt",CPLib.Lower(nomefileimport)),0)) {
              /* Case At('archfraz.txt',Lower(nomefileimport)) <> 0 */
            } else if (CPLib.ne(CPLib.At("archfraz.txt",CPLib.Lower(nomefileimport)),0)) {
            } // End Case
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
          } // End If
          /* gMsgImp := 'Fine importazione dati. Inizio fase di commit. Attendere prego...' // Messaggio Import */
          gMsgImp = "Fine importazione dati. Inizio fase di commit. Attendere prego...";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // Commit
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          m_Sql.CompleteTransaction();
          /* gMsgImp := 'Importazione dati terminata.' // Messaggio Import */
          gMsgImp = "Importazione dati terminata.";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } catch(Exception l_exeption) {
          Stop.ReactToException(l_exeption);
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
          /* gMsgProc := gMsgProc + "Rilevati errori nell'impotazione dei file! Ricreare il file segnalato e rieseguire l'import dei dati. La procedura annullera automaticamente l'importazione" + NL */
          gMsgProc = gMsgProc+"Rilevati errori nell'impotazione dei file! Ricreare il file segnalato e rieseguire l'import dei dati. La procedura annullera automaticamente l'importazione"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgProc := gMsgProc + 'Errore SQL: ' + m_Sql.TransactionErrorMessage() + NL */
          gMsgProc = gMsgProc+"Errore SQL: "+m_Sql.TransactionErrorMessage()+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          // Rollback
          m_Sql.AbortTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          m_bError = true;
          m_Sql.CompleteTransaction();
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry06D5C040status,0)) {
            m_Sql.SetTransactionStatus(nTry06D5C040status,cTry06D5C040msg);
          }
        }
        Cursor_tmp_list_imprich.Next();
      }
      m_cConnectivityError = Cursor_tmp_list_imprich.ErrorMessage();
      Cursor_tmp_list_imprich.Close();
      // * --- End Select
      /* If _esito=1 */
      if (CPLib.eqr(_esito,1)) {
        // * --- Write into processi from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("processi");
        m_cPhName = m_Ctx.GetPhName("processi");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = "Update "+m_cPhName+" set ";
        m_cSql = m_cSql+"PRESITO = "+CPLib.ToSQL("K","C",1,0,m_cServer)+", ";
        m_cSql = m_cSql+"PRDOSTOP = "+CPLib.ToSQL(CPLib.DateTime(),"T",14,0)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"processi",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"PR_TIPO = "+CPSql.SQLValueAdapter(CPLib.ToSQL("IMP","?",0,0,m_cServer),m_cServer,"IMP")+"";
        m_cSql = m_cSql+" and PRCODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_progproc,"?",0,0,m_cServer),m_cServer,_progproc)+"";
        if (m_Ctx.IsSharedTemp("processi")) {
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
      } else { // Else
        // * --- Write into processi from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("processi");
        m_cPhName = m_Ctx.GetPhName("processi");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = "Update "+m_cPhName+" set ";
        m_cSql = m_cSql+"PRESITO = "+CPLib.ToSQL("O","C",1,0,m_cServer)+", ";
        m_cSql = m_cSql+"PRDOSTOP = "+CPLib.ToSQL(CPLib.DateTime(),"T",14,0)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"processi",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"PR_TIPO = "+CPSql.SQLValueAdapter(CPLib.ToSQL("IMP","?",0,0,m_cServer),m_cServer,"IMP")+"";
        m_cSql = m_cSql+" and PRCODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_progproc,"?",0,0,m_cServer),m_cServer,_progproc)+"";
        if (m_Ctx.IsSharedTemp("processi")) {
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
        if (Cursor_tmp_list_imprich!=null)
          Cursor_tmp_list_imprich.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_tmp_list_imprich=null;
    try {
      /* _progdproc := Utilities.GetAutonumber('IMP-'+_progproc,0,4) */
      _progdproc = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("IMP-"+_progproc,0,4),0);
      // * --- Insert into dprocessi from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("dprocessi");
      m_cPhName = m_Ctx.GetPhName("dprocessi");
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.InsertIntoStatement(m_Ctx,"dprocessi")+" (";
      m_cSql = m_cSql+GetFieldsName_06E624D0(m_Ctx);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL("IMP","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_progproc,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_progdproc,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("Estrazione File da Zip","?",0,0,m_cServer, m_oParameters)+", ";
      if (m_Ctx.IsSharedTemp("dprocessi")) {
        m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
      }
      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"dprocessi",true);
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
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + czipfile + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+czipfile+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Inizio estrazione del file '+ czipfile // Messaggio Import */
      gMsgImp = "Inizio estrazione del file "+czipfile;
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
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
      // * --- Write into dprocessi from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("dprocessi");
      m_cPhName = m_Ctx.GetPhName("dprocessi");
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = "Update "+m_cPhName+" set ";
      m_cSql = m_cSql+"DPRESITO = "+CPLib.ToSQL("O","C",1,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"dprocessi",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"DPR_TIPO = "+CPSql.SQLValueAdapter(CPLib.ToSQL("IMP","?",0,0,m_cServer),m_cServer,"IMP")+"";
      m_cSql = m_cSql+" and DPRCODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_progproc,"?",0,0,m_cServer),m_cServer,_progproc)+"";
      m_cSql = m_cSql+" and DPRPROGRE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_progdproc,"?",0,0,m_cServer),m_cServer,_progdproc)+"";
      if (m_Ctx.IsSharedTemp("dprocessi")) {
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
      } catch (java.io.IOException ioe) {
            System.err.println("Unhandled exception:");
            ioe.printStackTrace();
      // * --- Write into dprocessi from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("dprocessi");
      m_cPhName = m_Ctx.GetPhName("dprocessi");
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = "Update "+m_cPhName+" set ";
      m_cSql = m_cSql+"DPRESITO = "+CPLib.ToSQL("K","C",1,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"dprocessi",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"DPR_TIPO = "+CPSql.SQLValueAdapter(CPLib.ToSQL("IMP","?",0,0,m_cServer),m_cServer,"IMP")+"";
      m_cSql = m_cSql+" and DPRCODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_progproc,"?",0,0,m_cServer),m_cServer,_progproc)+"";
      m_cSql = m_cSql+" and DPRPROGRE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_progdproc,"?",0,0,m_cServer),m_cServer,_progdproc)+"";
      if (m_Ctx.IsSharedTemp("dprocessi")) {
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
        /* Case At('archdip.txt',Lower(buffernomefile)) <> 0 */
        if (CPLib.ne(CPLib.At("archdip.txt",CPLib.Lower(buffernomefile)),0)) {
          /* _priorita := 1 */
          _priorita = CPLib.Round(1,0);
          /* Case At('archpers.txt',Lower(buffernomefile)) <> 0 */
        } else if (CPLib.ne(CPLib.At("archpers.txt",CPLib.Lower(buffernomefile)),0)) {
          /* _priorita := 2 */
          _priorita = CPLib.Round(2,0);
          /* Case At('archrap.txt',Lower(buffernomefile)) <> 0 */
        } else if (CPLib.ne(CPLib.At("archrap.txt",CPLib.Lower(buffernomefile)),0)) {
          /* _priorita := 3 */
          _priorita = CPLib.Round(3,0);
          /* Case At('archope.txt',Lower(buffernomefile)) <> 0 */
        } else if (CPLib.ne(CPLib.At("archope.txt",CPLib.Lower(buffernomefile)),0)) {
          /* _priorita := 4 */
          _priorita = CPLib.Round(4,0);
          /* Case At('archfraz.txt',Lower(buffernomefile)) <> 0 */
        } else if (CPLib.ne(CPLib.At("archfraz.txt",CPLib.Lower(buffernomefile)),0)) {
          /* _priorita := 5 */
          _priorita = CPLib.Round(5,0);
        } // End Case
        // * --- Insert into tmp_list_imprich from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_list_imprich");
        m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_list_imprich")+" (";
        m_cSql = m_cSql+GetFieldsName_06E75418(m_Ctx);
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
      /* gMsgImp := 'Fine estrazione del file '+ czipfile // Messaggio Import */
      gMsgImp = "Fine estrazione del file "+czipfile;
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +czipfile + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+czipfile+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
  void Page_3() throws Exception {
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_personbo=null;
    try {
      /* Legge il file di testo e porta i dati nella tabella */
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      /* cNumMod := 0 */
      cNumMod = CPLib.Round(0,0);
      /* cNumInv := 0 */
      cNumInv = CPLib.Round(0,0);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* numriga := 0 */
      numriga = CPLib.Round(0,0);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
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
        /* _tipper := '' */
        _tipper = "";
        /* If Len(LRTrim(riga)) > 0 */
        if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
          /* conta := conta + 1 */
          conta = CPLib.Round(conta+1,0);
          /* numriga := numriga + 1 */
          numriga = CPLib.Round(numriga+1,0);
          /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' nominativi del file '+nomefileimport // Messaggio Import */
          gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" nominativi del file "+nomefileimport;
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* cSetSin := '' */
          cSetSin = "";
          /* xCodCab := Substr(riga,1,6) */
          xCodCab = CPLib.Substr(riga,1,6);
          /* cCli1 := Substr(riga,112,16) */
          cCli1 = CPLib.Substr(riga,112,16);
          /* xCF := Substr(riga,487,16) */
          xCF = CPLib.Substr(riga,487,16);
          /* xCFE := iif(Substr(riga,450,1)='S' or Substr(riga,450,1)='1',1,0) */
          xCFE = CPLib.Round((CPLib.eqr(CPLib.Substr(riga,450,1),"S") || CPLib.eqr(CPLib.Substr(riga,450,1),"1")?1:0),0);
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
                Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_imp_dati_multipli_telepass returns two or more records. This item should return only a record.");
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
          /* If Len(LRTrim(xCF)) = 0 */
          if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(xCF)),0)) {
            /* w_errchk := 1 */
            w_errchk = CPLib.Round(1,0);
            // * --- Insert into tmp_errimp from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_errimp");
            m_cPhName = m_Ctx.GetPhName("tmp_errimp");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_errimp")+" (";
            m_cSql = m_cSql+GetFieldsName_0641BA60(m_Ctx);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(numriga,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Codice Fiscale Assente. - "+CPLib.LRTrim(cCli1)+" - "+CPLib.LRTrim(CPLib.Substr(riga,7,70)),"?",0,0,m_cServer, m_oParameters)+", ";
            if (m_Ctx.IsSharedTemp("tmp_errimp")) {
              m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
            }
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
            /* If arfn_chkcodfis(xCF,Substr(riga,262,3),0) */
            if (arfn_chkcodfisR.Make(m_Ctx,this).Run(xCF,CPLib.Substr(riga,262,3),0)) {
              /* If Len(LRTrim(xCF)) = 16 and Substr(riga,450,1) <> 'S' */
              if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(xCF)),16) && CPLib.ne(CPLib.Substr(riga,450,1),"S")) {
                /* xAnnNas := Substr(xCF,7,2) // Anno Di Nascita */
                xAnnNas = CPLib.Substr(xCF,7,2);
                /* xMesNas := arfn_mesecf(Substr(xCF,9,1)) // Mese Di Nascita */
                xMesNas = arfn_mesecfR.Make(m_Ctx,this).Run(CPLib.Substr(xCF,9,1));
                /* xDayNas := iif(Val(Substr(xCF,10,2)) < 40,Substr(xCF,10,2),Str(Val(Substr(xCF,10,1))-4,1,0)+Substr(xCF,11,1)) // Giorno Di Nascita */
                xDayNas = (CPLib.lt(CPLib.Val(CPLib.Substr(xCF,10,2)),40)?CPLib.Substr(xCF,10,2):CPLib.Str(CPLib.Val(CPLib.Substr(xCF,10,1))-4,1,0)+CPLib.Substr(xCF,11,1));
                /* cDNAS := CharToDate('19'+xAnnNas+xMesNas+xDayNas) */
                cDNAS = CPLib.CharToDate("19"+xAnnNas+xMesNas+xDayNas);
                /* xSesso := iif(Val(Substr(xCF,10,2)) < 40,'1','2') */
                xSesso = (CPLib.lt(CPLib.Val(CPLib.Substr(xCF,10,2)),40)?"1":"2");
                /* If Substr(riga,12,1) = 'Z' */
                if (CPLib.eqr(CPLib.Substr(riga,12,1),"Z")) {
                  /* cSNAS := '' */
                  cSNAS = "";
                  // * --- Read from tbstati
                  m_cServer = m_Ctx.GetServer("tbstati");
                  m_cPhName = m_Ctx.GetPhName("tbstati");
                  m_cSql = "";
                  m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(xCF,12,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(xCF,12,4));
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
                      Error l_oErrorFault = new Error("Read on tbstati into routine arrt_imp_dati_multipli_telepass returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    cSNAS = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
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
                  m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(xCF,12,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(xCF,12,4));
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
                      Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_imp_dati_multipli_telepass returns two or more records. This item should return only a record.");
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
                  /* cSNAS := '' */
                  cSNAS = "";
                } // End If
              } // End If
            } else { // Else
              /* w_errchk := 1 */
              w_errchk = CPLib.Round(1,0);
              // * --- Insert into tmp_errimp from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_errimp");
              m_cPhName = m_Ctx.GetPhName("tmp_errimp");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_errimp")+" (";
              m_cSql = m_cSql+GetFieldsName_062B5090(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(numriga,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Codice Fiscale Errato. - "+CPLib.LRTrim(cCli1)+" - "+CPLib.LRTrim(CPLib.Substr(riga,7,70)),"?",0,0,m_cServer, m_oParameters)+", ";
              if (m_Ctx.IsSharedTemp("tmp_errimp")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
          } // End If
          /* xRiga1 := xCF+Substr(riga,7,70)+Substr(riga,77,35)+Substr(riga,230,30)+Substr(riga,260,2)+LibreriaMit.SpacePad(LRTrim(Substr(riga,265,9)),5)+Substr(riga,262,3)+Substr(riga,166,3)+Substr(riga,169,3)+Substr(riga,172,3) */
          xRiga1 = xCF+CPLib.Substr(riga,7,70)+CPLib.Substr(riga,77,35)+CPLib.Substr(riga,230,30)+CPLib.Substr(riga,260,2)+LibreriaMit.SpacePad(CPLib.LRTrim(CPLib.Substr(riga,265,9)),5)+CPLib.Substr(riga,262,3)+CPLib.Substr(riga,166,3)+CPLib.Substr(riga,169,3)+CPLib.Substr(riga,172,3);
          /* xRiga1 := xRiga1+LibreriaMit.SpacePad(Left(cCNAS,30),30)+LibreriaMit.SpacePad(cPNAS,2)+LibreriaMit.SpacePad(Left(cSNAS,30),30) */
          xRiga1 = xRiga1+LibreriaMit.SpacePad(CPLib.Left(cCNAS,30),30)+LibreriaMit.SpacePad(cPNAS,2)+LibreriaMit.SpacePad(CPLib.Left(cSNAS,30),30);
          /* xRiga1 := xRiga1+iif(DateToChar(cDNAS) <> '01000101',LibreriaMit.SpacePad(DateToChar(cDNAS),8),Space(8)) */
          xRiga1 = xRiga1+(CPLib.ne(CPLib.DateToChar(cDNAS),"01000101")?LibreriaMit.SpacePad(CPLib.DateToChar(cDNAS),8):CPLib.Space(8));
          /* xRiga1 := xRiga1+Substr(riga,175,2)+Substr(riga,177,15)+Substr(riga,196,4)+Substr(riga,194,2)+Substr(riga,192,2)+Substr(riga,200,30)+Substr(riga,274,14) */
          xRiga1 = xRiga1+CPLib.Substr(riga,175,2)+CPLib.Substr(riga,177,15)+CPLib.Substr(riga,196,4)+CPLib.Substr(riga,194,2)+CPLib.Substr(riga,192,2)+CPLib.Substr(riga,200,30)+CPLib.Substr(riga,274,14);
          /* Verifica l'esistenza della persona */
          /* xConnes := '' */
          xConnes = "";
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
            /* xRiga2 := xRiga2 + LibreriaMit.SpacePad(Left(LRTrim(personbo->CAP),5),5) */
            xRiga2 = xRiga2+LibreriaMit.SpacePad(CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP")),5),5);
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
            /* xRiga2 := xRiga2 +LibreriaMit.SpacePad(personbo->AUTRILASC,30) */
            xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("AUTRILASC"),30);
            /* xRiga2 := xRiga2 +LibreriaMit.SpacePad(personbo->PARTIVA,14) */
            xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("PARTIVA"),14);
            /* xConnes := personbo->CONNES */
            xConnes = Cursor_personbo.GetString("CONNES");
            Cursor_personbo.Next();
          }
          m_cConnectivityError = Cursor_personbo.ErrorMessage();
          Cursor_personbo.Close();
          // * --- End Select
          /* If Empty(LRTrim(Substr(riga,172,3))) */
          if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,172,3)))) {
            /* cSetSin := arfn_calcolasett(Substr(riga,166,3),Substr(riga,169,3),Substr(riga,460,10)) */
            cSetSin = arfn_calcolasettR.Make(m_Ctx,this).Run(CPLib.Substr(riga,166,3),CPLib.Substr(riga,169,3),CPLib.Substr(riga,460,10));
          } else { // Else
            /* cSetSin := Substr(riga,172,3) */
            cSetSin = CPLib.Substr(riga,172,3);
          } // End If
          /* nProgImp := 0 */
          nProgImp = CPLib.Round(0,0);
          /* cProgSto := '' */
          cProgSto = "";
          /* _tipper := iif(Empty(LRTrim(Substr(riga,288,1))),'G','P') */
          _tipper = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,288,1)))?"G":"P");
          /* If not(Empty(xConnes)) */
          if ( ! (CPLib.Empty(xConnes))) {
            /* If Upper(LRTrim(xRiga1)) <> Upper(LRTrim(xRiga2)) */
            if (CPLib.ne(CPLib.Upper(CPLib.LRTrim(xRiga1)),CPLib.Upper(CPLib.LRTrim(xRiga2)))) {
              /* _allcn := 0 */
              _allcn = CPLib.Round(0,0);
              /* xNome := '' */
              xNome = "";
              /* xCognome := '' */
              xCognome = "";
              /* If Len(LRTrim(Substr(riga,487,16))) = 16 */
              if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(CPLib.Substr(riga,487,16))),16)) {
                /* If Len(LRTrim(Substr(riga,297,26))+LRTrim(Substr(riga,323,25))) = 0 */
                if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(CPLib.Substr(riga,297,26))+CPLib.LRTrim(CPLib.Substr(riga,323,25))),0)) {
                  /* Exec "Allinea Cognome Nome" Page 4 */
                  Page_4();
                  /* xNome := Left(xNome,25) */
                  xNome = CPLib.Left(xNome,25);
                  /* xCognome := Left(xCognome,26) */
                  xCognome = CPLib.Left(xCognome,26);
                } else { // Else
                  /* xNome := Substr(riga,323,25) */
                  xNome = CPLib.Substr(riga,323,25);
                  /* xCognome := Substr(riga,297,26) */
                  xCognome = CPLib.Substr(riga,297,26);
                  /* _allcn := 1 */
                  _allcn = CPLib.Round(1,0);
                } // End If
              } // End If
              /* cProgSto := Utilities.GetAutonumber("PSTOPERS\'"+LRTrim(gAzienda)+"'","",15) */
              cProgSto = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PSTOPERS\\'"+CPLib.LRTrim(gAzienda)+"'","",15);
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
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.InsertIntoStatement(m_Ctx,"wersonbo")+" (";
                m_cSql = m_cSql+GetFieldsName_07BFCC68(m_Ctx);
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
                if (m_Ctx.IsSharedTemp("wersonbo")) {
                  m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                }
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
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = "Update "+m_cPhName+" set ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(xCodCab,"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.Substr(riga,7,70),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(CPLib.Substr(riga,77,35),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(CPLib.Substr(riga,487,16),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(cDNAS,"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(CPLib.Left(cCNAS,30),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(CPLib.Substr(riga,166,3),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(CPLib.Substr(riga,169,3),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(cSetSin,"C",3,0,m_cServer)+", ";
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
              m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(xCognome,"C",26,0,m_cServer)+", ";
              m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(xNome,"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOCFILE = "+CPLib.ToSQL(CPLib.Substr(riga,348,100),"C",100,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(cPNAS,"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(xCFE,"N",1,0)+", ";
              m_cSql = m_cSql+"PKTBSPECIE = "+CPLib.ToSQL(CPLib.Substr(riga,451,4),"C",4,0,m_cServer)+", ";
              m_cSql = m_cSql+"COMPORT = "+CPLib.ToSQL(CPLib.Substr(riga,455,5),"C",5,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(CPLib.Substr(riga,460,10),"C",10,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(CPLib.Left(cSNAS,30),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAGSOCOLD = "+CPLib.ToSQL(CPLib.Substr(riga,7,70),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"ALLINEATONOMECNOME = "+CPLib.ToSQL(_allcn,"N",1,0)+", ";
              m_cSql = m_cSql+"TIPOPERS = "+CPLib.ToSQL(_tipper,"C",1,0,m_cServer)+", ";
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
                /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per il soggetto: "+Substr(riga,7,70)+" con codice: "+cCli1+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per il soggetto: "+CPLib.Substr(riga,7,70)+" con codice: "+cCli1+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* _esito := 1 */
                _esito = CPLib.Round(1,0);
                /* m_cLastMsgError = "" */
                CPLib.eqr(m_cLastMsgError,"");
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
              // * --- Insert into tmp_newpers from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_newpers");
              m_cPhName = m_Ctx.GetPhName("tmp_newpers");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_newpers")+" (";
              m_cSql = m_cSql+GetFieldsName_06EE8D78(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(xConnes,"?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("tmp_newpers")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_newpers",true);
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
              /* cNumInv := cNumInv + 1 // Contatore record invariati */
              cNumInv = CPLib.Round(cNumInv+1,0);
            } // End If
          } else { // Else
            /* _allcn := 0 */
            _allcn = CPLib.Round(0,0);
            /* xNome := '' */
            xNome = "";
            /* xCognome := '' */
            xCognome = "";
            /* If Len(LRTrim(Substr(riga,487,16))) = 16 */
            if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(CPLib.Substr(riga,487,16))),16)) {
              /* If Len(LRTrim(Substr(riga,297,26))+LRTrim(Substr(riga,323,25))) = 0 */
              if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(CPLib.Substr(riga,297,26))+CPLib.LRTrim(CPLib.Substr(riga,323,25))),0)) {
                /* Exec "Allinea Cognome Nome" Page 4 */
                Page_4();
                /* xNome := Left(xNome,25) */
                xNome = CPLib.Left(xNome,25);
                /* xCognome := Left(xCognome,26) */
                xCognome = CPLib.Left(xCognome,26);
              } else { // Else
                /* xNome := Substr(riga,323,25) */
                xNome = CPLib.Substr(riga,323,25);
                /* xCognome := Substr(riga,297,26) */
                xCognome = CPLib.Substr(riga,297,26);
                /* _allcn := 1 */
                _allcn = CPLib.Round(1,0);
              } // End If
            } // End If
            /* nProgImp := Utilities.GetAutonumber("PRGIMPOCLI\'"+LRTrim(gAzienda)+"'",0,15) */
            nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOCLI\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
            // * --- Insert into personbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.InsertIntoStatement(m_Ctx,"personbo")+" (";
            m_cSql = m_cSql+GetFieldsName_06F72ED0(m_Ctx);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cCli1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(xCodCab,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,7,70),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,77,35),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(xCF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cDNAS,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(cCNAS,30),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,166,3),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,169,3),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cSetSin,"?",0,0,m_cServer)+", ";
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
            m_cSql = m_cSql+""+CPLib.ToSQL(_tipper,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(xCognome,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(xNome,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,348,100),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cPNAS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(xCFE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,451,4),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,455,5),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,460,10),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(cSNAS,30),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_allcn,"?",0,0)+", ";
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
              /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per il soggetto: "+Substr(riga,7,70)+" con codice: "+Substr(riga,112,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
              gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per il soggetto: "+CPLib.Substr(riga,7,70)+" con codice: "+CPLib.Substr(riga,112,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              /* _esito := 1 */
              _esito = CPLib.Round(1,0);
              m_cLastMsgError = "";
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
          } // End If
        } // End If
      } // End While
      /* gMsgProc := gMsgProc + 'Soggetti Inseriti: '+LRTrim(Str(cNumNew,10,0)) + ' - Soggetti Aggiornati: '+LRTrim(Str(cNumMod,10,0)) + ' - Soggetti Invariati: '+LRTrim(Str(cNumInv,10,0)) + ' dal file '+nomefileimport+NL */
      gMsgProc = gMsgProc+"Soggetti Inseriti: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+" - Soggetti Aggiornati: "+CPLib.LRTrim(CPLib.Str(cNumMod,10,0))+" - Soggetti Invariati: "+CPLib.LRTrim(CPLib.Str(cNumInv,10,0))+" dal file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* gMsgImp := 'Fine importazione del file '+nomefileimport // Messaggio Import */
      gMsgImp = "Fine importazione del file "+nomefileimport;
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
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
    }
  }
  void Page_4() throws Exception {
    /* Tenta di inserire i dati Cognome e Nome se Non Esistono */
    /* xRagSoc := Upper(LRTrim(Substr(riga,7,70))) */
    xRagSoc = CPLib.Upper(CPLib.LRTrim(CPLib.Substr(riga,7,70)));
    /* While True  */
    while (true) {
      /* NSpazzi := LibreriaMit.Occurs(xRagSoc,'  ') */
      NSpazzi = CPLib.Round(LibreriaMit.Occurs(xRagSoc,"  "),0);
      /* If NSpazzi>0 */
      if (CPLib.gt(NSpazzi,0)) {
        /* xRagSoc := Strtran(xRagSoc,'  ',' ') */
        xRagSoc = CPLib.Strtran(xRagSoc,"  "," ");
      } else { // Else
        // Exit Loop
        if (true) {
          break;
        }
      } // End If
    } // End While
    /* NSpazzi := LibreriaMit.Occurs(xRagSoc,' ') */
    NSpazzi = CPLib.Round(LibreriaMit.Occurs(xRagSoc," "),0);
    /* If NSpazzi=1 */
    if (CPLib.eqr(NSpazzi,1)) {
      /* xNome := Left(xRagSoc,At(" ",xRagSoc)-1) */
      xNome = CPLib.Left(xRagSoc,CPLib.At(" ",xRagSoc)-1);
      /* xCognome := Substr(xRagSoc,At(" ",xRagSoc)+1) */
      xCognome = CPLib.Substr(xRagSoc,CPLib.At(" ",xRagSoc)+1);
      /* If arfn_verifica_cf_nome_cognome(Substr(riga,487,16),xNome,xCognome) */
      if (arfn_verifica_cf_nome_cognomeR.Make(m_Ctx,this).Run(CPLib.Substr(riga,487,16),xNome,xCognome)) {
        /* xRagSoc := Left(xRagSoc,At(" ",xRagSoc)-1)+'?'+Substr(xRagSoc,At(" ",xRagSoc)+1) */
        xRagSoc = CPLib.Left(xRagSoc,CPLib.At(" ",xRagSoc)-1)+"?"+CPLib.Substr(xRagSoc,CPLib.At(" ",xRagSoc)+1);
        /* Allineamento := 'OK' */
        Allineamento = "OK";
      } else { // Else
        /* xNome := '' */
        xNome = "";
        /* xCognome := '' */
        xCognome = "";
        /* Allineamento := 'KO' */
        Allineamento = "KO";
      } // End If
    } else { // Else
      /* NSpazzi2 := NSpazzi-1 */
      NSpazzi2 = CPLib.Round(NSpazzi-1,0);
      /* While NSpazzi2>1 */
      while (CPLib.gt(NSpazzi2,1)) {
        /* SubRag := Substr(xRagSoc,At(' ',xRagSoc,NSpazzi2)+1,(At(' ',xRagSoc,NSpazzi2+1)-At(' ',xRagSoc,NSpazzi2))-1) */
        SubRag = CPLib.Substr(xRagSoc,CPLib.At(" ",xRagSoc,NSpazzi2)+1,(CPLib.At(" ",xRagSoc,NSpazzi2+1)-CPLib.At(" ",xRagSoc,NSpazzi2))-1);
        /* If At(Lower(SubRag)+'/',Controllo)>0 */
        if (CPLib.gt(CPLib.At(CPLib.Lower(SubRag)+"/",Controllo),0)) {
          /* xNome := Left(xRagSoc,At(" ",xRagSoc,NSpazzi2)-1) */
          xNome = CPLib.Left(xRagSoc,CPLib.At(" ",xRagSoc,NSpazzi2)-1);
          /* xCognome := Substr(xRagSoc,At(" ",xRagSoc,NSpazzi2)+1) */
          xCognome = CPLib.Substr(xRagSoc,CPLib.At(" ",xRagSoc,NSpazzi2)+1);
          /* If arfn_verifica_cf_nome_cognome(Substr(riga,487,16),xNome,xCognome) */
          if (arfn_verifica_cf_nome_cognomeR.Make(m_Ctx,this).Run(CPLib.Substr(riga,487,16),xNome,xCognome)) {
            /* xRagSoc := Left(xRagSoc,At(" ",xRagSoc)-1)+'?'+Substr(xRagSoc,At(" ",xRagSoc)+1) */
            xRagSoc = CPLib.Left(xRagSoc,CPLib.At(" ",xRagSoc)-1)+"?"+CPLib.Substr(xRagSoc,CPLib.At(" ",xRagSoc)+1);
            /* Allineamento := 'OK' */
            Allineamento = "OK";
            // Exit Loop
            if (true) {
              break;
            }
          } else { // Else
            /* xNome := '' */
            xNome = "";
            /* xCognome := '' */
            xCognome = "";
            /* Allineamento := 'KO' */
            Allineamento = "KO";
          } // End If
        } // End If
        /* NSpazzi2 := NSpazzi2-1 */
        NSpazzi2 = CPLib.Round(NSpazzi2-1,0);
      } // End While
    } // End If
    /* If LibreriaMit.Occurs(xRagSoc,'?')=0 */
    if (CPLib.eqr(LibreriaMit.Occurs(xRagSoc,"?"),0)) {
      /* _i := 1 */
      _i = CPLib.Round(1,0);
      /* While _i<=NSpazzi */
      while (CPLib.le(_i,NSpazzi)) {
        /* xNome := Left(xRagSoc,At(' ',xRagSoc,_i)-1) */
        xNome = CPLib.Left(xRagSoc,CPLib.At(" ",xRagSoc,_i)-1);
        /* xCognome := Substr(xRagSoc,At(' ',xRagSoc,_i)+1) */
        xCognome = CPLib.Substr(xRagSoc,CPLib.At(" ",xRagSoc,_i)+1);
        /* If arfn_verifica_cf_nome_cognome(Substr(riga,487,16),xNome,xCognome) */
        if (arfn_verifica_cf_nome_cognomeR.Make(m_Ctx,this).Run(CPLib.Substr(riga,487,16),xNome,xCognome)) {
          /* xRagSoc := Left(xRagSoc,At(' ',xRagSoc,_i)-1)+'?'+Substr(xRagSoc,At(' ',xRagSoc,_i)+1) */
          xRagSoc = CPLib.Left(xRagSoc,CPLib.At(" ",xRagSoc,_i)-1)+"?"+CPLib.Substr(xRagSoc,CPLib.At(" ",xRagSoc,_i)+1);
          /* Allineamento := 'KO' */
          Allineamento = "KO";
          // Exit Loop
          if (true) {
            break;
          }
        } else { // Else
          /* xNome := '' */
          xNome = "";
          /* xCognome := '' */
          xCognome = "";
          /* Allineamento := 'KO' */
          Allineamento = "KO";
        } // End If
        /* _i := _i+1 */
        _i = CPLib.Round(_i+1,0);
      } // End While
    } // End If
    /* If LibreriaMit.Occurs(xRagSoc,'?')=0 */
    if (CPLib.eqr(LibreriaMit.Occurs(xRagSoc,"?"),0)) {
      /* _i := 1 */
      _i = CPLib.Round(1,0);
      /* While _i<=NSpazzi */
      while (CPLib.le(_i,NSpazzi)) {
        /* xNome := Substr(xRagSoc,At(' ',xRagSoc,_i)+1) */
        xNome = CPLib.Substr(xRagSoc,CPLib.At(" ",xRagSoc,_i)+1);
        /* xCognome := Left(xRagSoc,At(' ',xRagSoc,_i)-1) */
        xCognome = CPLib.Left(xRagSoc,CPLib.At(" ",xRagSoc,_i)-1);
        /* If arfn_verifica_cf_nome_cognome(Substr(riga,487,16),xNome,xCognome) */
        if (arfn_verifica_cf_nome_cognomeR.Make(m_Ctx,this).Run(CPLib.Substr(riga,487,16),xNome,xCognome)) {
          /* xRagSoc := Left(xRagSoc,At(' ',xRagSoc,_i)-1)+'?'+Substr(xRagSoc,At(' ',xRagSoc,_i)+1) */
          xRagSoc = CPLib.Left(xRagSoc,CPLib.At(" ",xRagSoc,_i)-1)+"?"+CPLib.Substr(xRagSoc,CPLib.At(" ",xRagSoc,_i)+1);
          /* Allineamento := 'KO' */
          Allineamento = "KO";
          // Exit Loop
          if (true) {
            break;
          }
        } else { // Else
          /* xNome := '' */
          xNome = "";
          /* xCognome := '' */
          xCognome = "";
          /* Allineamento := 'KO' */
          Allineamento = "KO";
        } // End If
        /* _i := _i+1 */
        _i = CPLib.Round(_i+1,0);
      } // End While
    } // End If
    /* If LibreriaMit.Occurs(xRagSoc,'?')<1 */
    if (CPLib.lt(LibreriaMit.Occurs(xRagSoc,"?"),1)) {
      /* xNome := '' */
      xNome = "";
      /* xCognome := '' */
      xCognome = "";
      /* Allineamento := 'KO' */
      Allineamento = "KO";
    } // End If
    /* Scrive direttamente i dati in personbo senza visualizzare la gestionese con tipoallin = A */
    /* If Allineamento='OK' */
    if (CPLib.eqr(Allineamento,"OK")) {
      /* _allcn := 1 */
      _allcn = CPLib.Round(1,0);
    } else { // Else
      /* _allcn := 0 */
      _allcn = CPLib.Round(0,0);
    } // End If
  }
  void Page_5() throws Exception {
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_rapopebo=null;
    CPResultSet Cursor_soginfo=null;
    try {
      /* Legge il file di testo e porta i dati nella tabella */
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      /* cNumMod := 0 */
      cNumMod = CPLib.Round(0,0);
      /* cNumInv := 0 */
      cNumInv = CPLib.Round(0,0);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      /* cRapporto := '' */
      cRapporto = "";
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime())  + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* _progdproc := Utilities.GetAutonumber('IMP-'+_progproc,0,4) */
      _progdproc = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("IMP-"+_progproc,0,4),0);
      // * --- Insert into dprocessi from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("dprocessi");
      m_cPhName = m_Ctx.GetPhName("dprocessi");
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.InsertIntoStatement(m_Ctx,"dprocessi")+" (";
      m_cSql = m_cSql+GetFieldsName_06DF2AE8(m_Ctx);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL("IMP","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_progproc,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_progdproc,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(gMsgProc,"?",0,0,m_cServer, m_oParameters)+", ";
      if (m_Ctx.IsSharedTemp("dprocessi")) {
        m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
      }
      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"dprocessi",true);
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
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' rapporti del file '+nomefileimport // Messaggio Import */
        gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" rapporti del file "+nomefileimport;
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        /* _progriga := '' */
        _progriga = "";
        // * --- Read from tprighe
        m_cServer = m_Ctx.GetServer("tprighe");
        m_cPhName = m_Ctx.GetPhName("tprighe");
        m_cSql = "";
        m_cSql = m_cSql+"TRIRAPPO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,25),"C",25,0,m_cServer),m_cServer,CPLib.Left(riga,25));
        m_cSql = m_cSql+" and TRIDATINI="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,29,8),"C",8,0,m_cServer),m_cServer,CPLib.Substr(riga,29,8));
        m_cSql = m_cSql+" and TRIDATFIN="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,37,8),"C",8,0,m_cServer),m_cServer,CPLib.Substr(riga,37,8));
        m_cSql = m_cSql+" and TRICODINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,45,9),"C",9,0,m_cServer),m_cServer,CPLib.Substr(riga,45,9));
        m_cSql = m_cSql+" and TRITIPCOL="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,54,2),"C",2,0,m_cServer),m_cServer,CPLib.Substr(riga,54,2));
        m_cSql = m_cSql+" and TRICODCOL="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,56,9),"C",9,0,m_cServer),m_cServer,CPLib.Substr(riga,56,9));
        if (m_Ctx.IsSharedTemp("tprighe")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("TRICODICE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _progriga = Read_Cursor.GetString("TRICODICE");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on tprighe into routine arrt_imp_dati_multipli_telepass returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _progriga = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If Empty(LRTrim(_progriga)) */
        if (CPLib.Empty(CPLib.LRTrim(_progriga))) {
          /* _progriga := Utilities.GetAutonumber("TPIMPORT\'"+LRTrim(gAzienda)+"'","",15) */
          _progriga = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("TPIMPORT\\'"+CPLib.LRTrim(gAzienda)+"'","",15);
          // * --- Insert into tprighe from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tprighe");
          m_cPhName = m_Ctx.GetPhName("tprighe");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tprighe")+" (";
          m_cSql = m_cSql+GetFieldsName_0704A600(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_progriga,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,25),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,26,3),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,29,8),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,37,8),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,45,9),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,54,2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,56,9),"?",0,0,m_cServer)+", ";
          if (m_Ctx.IsSharedTemp("tprighe")) {
            m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
          }
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tprighe",true);
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
          /* cRapporto := Left(riga,25) */
          cRapporto = CPLib.Left(riga,25);
          /* xNumRig := Val(Substr(riga,26,3)) */
          xNumRig = CPLib.Round(CPLib.Val(CPLib.Substr(riga,26,3)),0);
          /* xDatIni := CharToDate(Substr(riga,33,4)+Substr(riga,31,2)+Substr(riga,29,2)) */
          xDatIni = CPLib.CharToDate(CPLib.Substr(riga,33,4)+CPLib.Substr(riga,31,2)+CPLib.Substr(riga,29,2));
          /* xDatIni := iif(xDatIni < _interini,_interini,xDatIni) */
          xDatIni = (CPLib.lt(xDatIni,_interini)?_interini:xDatIni);
          /* If Empty(LRTrim(Substr(riga,37,8))) */
          if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,37,8)))) {
            /* xDatFin := NullDate() */
            xDatFin = CPLib.NullDate();
          } else { // Else
            /* xDatFin := CharToDate(Substr(riga,41,4)+Substr(riga,39,2)+Substr(riga,37,2)) */
            xDatFin = CPLib.CharToDate(CPLib.Substr(riga,41,4)+CPLib.Substr(riga,39,2)+CPLib.Substr(riga,37,2));
            /* xDatFin := iif(xDatFin < _interini,_interini,xDatFin) */
            xDatFin = (CPLib.lt(xDatFin,_interini)?_interini:xDatFin);
          } // End If
          /* xCodInt := Substr(riga,45,9) */
          xCodInt = CPLib.Substr(riga,45,9);
          /* xTipLeg := Substr(riga,54,2) */
          xTipLeg = CPLib.Substr(riga,54,2);
          /* xCodLeg := Substr(riga,56,9) */
          xCodLeg = CPLib.Substr(riga,56,9);
          /* Verifica esistenza rapporto */
          /* xRapporto := '' */
          xRapporto = "";
          // * --- Read from anarapbo
          m_cServer = m_Ctx.GetServer("anarapbo");
          m_cPhName = m_Ctx.GetPhName("anarapbo");
          m_cSql = "";
          m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(cRapporto,"C",25,0,m_cServer),m_cServer,cRapporto);
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
              Error l_oErrorFault = new Error("Read on anarapbo into routine arrt_imp_dati_multipli_telepass returns two or more records. This item should return only a record.");
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
            /* _rigsog := 0 */
            _rigsog = CPLib.Round(0,0);
            /* _rigint := 0 */
            _rigint = CPLib.Round(0,0);
            /* nProgImp := Utilities.GetAutonumber("PRGIMPRAP\'"+LRTrim(gAzienda)+"'",0,15) */
            nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPRAP\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
            // * --- Insert into anarapbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("anarapbo");
            m_cPhName = m_Ctx.GetPhName("anarapbo");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.InsertIntoStatement(m_Ctx,"anarapbo")+" (";
            m_cSql = m_cSql+GetFieldsName_07A38CF8(m_Ctx);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cRapporto,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull("242","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("18","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Rapporto relativo a cliente "+CPLib.LRTrim(xCodInt),"?",0,0,m_cServer)+", ";
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
              /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" alla riga "+LRTrim(Str(conta,10,0))+NL */
              gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" alla riga "+CPLib.LRTrim(CPLib.Str(conta,10,0))+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              /* gMsgProc := gMsgProc +"Errori nel file "+nomefileimport+" per il rapporto: "+Left(riga,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
              gMsgProc = gMsgProc+"Errori nel file "+nomefileimport+" per il rapporto: "+CPLib.Left(riga,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              m_cLastMsgError = "";
              /* _esito := 1 */
              _esito = CPLib.Round(1,0);
              // Exit Loop
              if (true) {
                break;
              }
            } else if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
            // * --- Insert into knarapbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("knarapbo");
            m_cPhName = m_Ctx.GetPhName("knarapbo");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.InsertIntoStatement(m_Ctx,"knarapbo")+" (";
            m_cSql = m_cSql+GetFieldsName_07B03D78(m_Ctx);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cRapporto,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Rapporto relativo a cliente "+CPLib.LRTrim(xCodInt),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
            if (m_Ctx.IsSharedTemp("knarapbo")) {
              m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
            }
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"knarapbo",true);
            m_cSql = m_cSql+")";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_nUpdatedRows = 0;
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.lt(m_nUpdatedRows,1)) {
              // No rows inserted
              /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" alla riga "+LRTrim(Str(conta,10,0))+NL */
              gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" alla riga "+CPLib.LRTrim(CPLib.Str(conta,10,0))+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              /* gMsgProc := gMsgProc +"Errori nel file "+nomefileimport+" per il rapporto: "+Left(riga,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
              gMsgProc = gMsgProc+"Errori nel file "+nomefileimport+" per il rapporto: "+CPLib.Left(riga,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              m_cLastMsgError = "";
              /* _esito := 1 */
              _esito = CPLib.Round(1,0);
              // Exit Loop
              if (true) {
                break;
              }
            } else if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
            /* cInfApri1 := Utilities.GetAutonumber("PRGINFO1\'"+LRTrim(gAzienda)+"'",'',10) */
            cInfApri1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
            /* cInfApri2 := Utilities.GetAutonumber("PRGINFO2\'"+LRTrim(gAzienda)+"'",'',11) */
            cInfApri2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
            /* nProgImp := Utilities.GetAutonumber("PRGIMPINF\'"+LRTrim(gAzienda)+"'",0,15) */
            nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINF\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
            // * --- Insert into rapopebo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("rapopebo");
            m_cPhName = m_Ctx.GetPhName("rapopebo");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.InsertIntoStatement(m_Ctx,"rapopebo")+" (";
            m_cSql = m_cSql+GetFieldsName_062F3068(m_Ctx);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(xDatIni),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(xDatIni,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(xDatIni,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_descinter,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cInfApri1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(xDatIni)+cInfApri1+"0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cInfApri2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(cRapporto,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_tipointer,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull("23","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
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
              /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" alla riga "+LRTrim(Str(conta,10,0))+NL */
              gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" alla riga "+CPLib.LRTrim(CPLib.Str(conta,10,0))+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              /* gMsgProc := gMsgProc +"Errori nel file "+nomefileimport+" per il rapporto: "+Left(riga,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
              gMsgProc = gMsgProc+"Errori nel file "+nomefileimport+" per il rapporto: "+CPLib.Left(riga,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              m_cLastMsgError = "";
              /* _esito := 1 */
              _esito = CPLib.Round(1,0);
              // Exit Loop
              if (true) {
                break;
              }
            } else if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
            /* cInfChiu1 := '' */
            cInfChiu1 = "";
            /* cInfChiu2 := '' */
            cInfChiu2 = "";
            /* If not(Empty(xDatFin)) */
            if ( ! (CPLib.Empty(xDatFin))) {
              /* cInfChiu1 := Utilities.GetAutonumber("PRGINFO1\'"+LRTrim(gAzienda)+"'",'',10) */
              cInfChiu1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
              /* cInfChiu2 := Utilities.GetAutonumber("PRGINFO2\'"+LRTrim(gAzienda)+"'",'',11) */
              cInfChiu2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
              /* nProgImp := Utilities.GetAutonumber("PRGIMPINF\'"+LRTrim(gAzienda)+"'",0,15) */
              nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINF\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
              // * --- Insert into rapopebo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("rapopebo");
              m_cPhName = m_Ctx.GetPhName("rapopebo");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"rapopebo")+" (";
              m_cSql = m_cSql+GetFieldsName_060EDBD0(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(xDatFin),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(xDatFin,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(xDatFin,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_descinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cInfChiu1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(xDatFin)+cInfChiu1+"0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cInfChiu2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(cRapporto,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tipointer,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull("23","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
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
                /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" alla riga "+LRTrim(Str(conta,10,0))+NL */
                gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" alla riga "+CPLib.LRTrim(CPLib.Str(conta,10,0))+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* gMsgProc := gMsgProc +"Errori nel file "+nomefileimport+" per il rapporto: "+Left(riga,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                gMsgProc = gMsgProc+"Errori nel file "+nomefileimport+" per il rapporto: "+CPLib.Left(riga,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                m_cLastMsgError = "";
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
            /* If xTipLeg='TE' */
            if (CPLib.eqr(xTipLeg,"TE")) {
              /* ElseIf xTipLeg='LR' */
            } else if (CPLib.eqr(xTipLeg,"LR")) {
              /* _rigsog := _rigsog+1 */
              _rigsog = CPLib.Round(_rigsog+1,0);
              // * --- Insert into soginfo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("soginfo");
              m_cPhName = m_Ctx.GetPhName("soginfo");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"soginfo")+" (";
              m_cSql = m_cSql+GetFieldsName_06106378(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_rigsog,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(xCodLeg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull("1","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cRapporto,"?",0,0,m_cServer)+", ";
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
                /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" alla riga "+LRTrim(Str(conta,10,0))+NL */
                gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" alla riga "+CPLib.LRTrim(CPLib.Str(conta,10,0))+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* gMsgProc := gMsgProc +"Errori nel file "+nomefileimport+" per la registrazione dei legali rappresentanti nel rapporto "+Left(riga,25)+". Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                gMsgProc = gMsgProc+"Errori nel file "+nomefileimport+" per la registrazione dei legali rappresentanti nel rapporto "+CPLib.Left(riga,25)+". Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* _esito := 1 */
                _esito = CPLib.Round(1,0);
                m_cLastMsgError = "";
                // Exit Loop
                if (true) {
                  break;
                }
              } else if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
              // * --- Write into rapopebo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("rapopebo");
              m_cPhName = m_Ctx.GetPhName("rapopebo");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = "Update "+m_cPhName+" set ";
              m_cSql = m_cSql+"CONNESOPER = "+CPLib.ToSQLNull(xCodLeg,"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPOLEG = "+CPLib.ToSQLNull("1","C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"rapopebo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQLNull(cRapporto,"?",0,0,m_cServer),m_cServer,cRapporto)+"";
              if (m_Ctx.IsSharedTemp("rapopebo")) {
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
            } // End If
            /* cNumMod := 0 */
            cNumMod = CPLib.Round(0,0);
            /* _rigint := 0 */
            _rigint = CPLib.Round(0,0);
            // * --- Select from intestbo
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            if (Cursor_intestbo!=null)
              Cursor_intestbo.Close();
            Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(cRapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,cRapporto)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM ",m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestbo.Eof())) {
              /* If LRTrim(intestbo->CODINTER)=LRTrim(xCodLeg) */
              if (CPLib.eqr(CPLib.LRTrim(Cursor_intestbo.GetString("CODINTER")),CPLib.LRTrim(xCodLeg))) {
                /* cNumMod := intestbo->CPROWNUM */
                cNumMod = CPLib.Round(Cursor_intestbo.GetDouble("CPROWNUM"),0);
              } // End If
              /* _rigint := _rigint + 1 */
              _rigint = CPLib.Round(_rigint+1,0);
              Cursor_intestbo.Next();
            }
            m_cConnectivityError = Cursor_intestbo.ErrorMessage();
            Cursor_intestbo.Close();
            // * --- End Select
            /* If cNumMod = 0 */
            if (CPLib.eqr(cNumMod,0)) {
              /* nProgImp2 := Utilities.GetAutonumber("PRGIMPSOG\'"+LRTrim(gAzienda)+"'",0,15) */
              nProgImp2 = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPSOG\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
              // * --- Insert into intestbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("intestbo");
              m_cPhName = m_Ctx.GetPhName("intestbo");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"intestbo")+" (";
              m_cSql = m_cSql+GetFieldsName_062CE4B8(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_rigint+1,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(xDatIni,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("P","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(xCodInt,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cInfApri2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cRapporto,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(xDatIni)+cInfApri2+"0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(xCodInt,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp2,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(xDatFin,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cInfChiu2,"?",0,0,m_cServer)+", ";
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
                /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" alla riga "+LRTrim(Str(conta,10,0))+NL */
                gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" alla riga "+CPLib.LRTrim(CPLib.Str(conta,10,0))+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* gMsgProc := gMsgProc + "Errori per la registrazione dell'intestatario relativa al rapporto: "+Left(riga,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                gMsgProc = gMsgProc+"Errori per la registrazione dell'intestatario relativa al rapporto: "+CPLib.Left(riga,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* _esito := 1 */
                _esito = CPLib.Round(1,0);
                m_cLastMsgError = "";
                // Exit Loop
                if (true) {
                  break;
                }
              } else if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
            } // End If
            /* cNumNew := cNumNew + 1 */
            cNumNew = CPLib.Round(cNumNew+1,0);
          } else { // Else
            /* _chiudi := 0 */
            _chiudi = CPLib.Round(0,0);
            /* cInfApri2 := '' */
            cInfApri2 = "";
            /* cInfChiu1 := '' */
            cInfChiu1 = "";
            /* cInfChiu2 := '' */
            cInfChiu2 = "";
            /* nProgImp := 0 */
            nProgImp = CPLib.Round(0,0);
            // * --- Select from rapopebo
            m_cServer = m_Ctx.GetServer("rapopebo");
            m_cPhName = m_Ctx.GetPhName("rapopebo");
            if (Cursor_rapopebo!=null)
              Cursor_rapopebo.Close();
            Cursor_rapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(cRapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,cRapporto)+"  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("rapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_rapopebo.Eof())) {
              /* If rapopebo->TIPOOPRAP='23' */
              if (CPLib.eqr(Cursor_rapopebo.GetString("TIPOOPRAP"),"23")) {
                /* If rapopebo->DATAOPE <> xDatIni */
                if (CPLib.ne(Cursor_rapopebo.GetDate("DATAOPE"),xDatIni)) {
                  // * --- Write into rapopebo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("rapopebo");
                  m_cPhName = m_Ctx.GetPhName("rapopebo");
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = "Update "+m_cPhName+" set ";
                  m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL("3","C",1,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"rapopebo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_rapopebo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_rapopebo.GetString("IDBASE"))+"";
                  if (m_Ctx.IsSharedTemp("rapopebo")) {
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
                  /* cInfApri1 := Utilities.GetAutonumber("PRGINFO1\'"+LRTrim(gAzienda)+"'",'',10) */
                  cInfApri1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
                  // * --- Insert into rapopebo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("rapopebo");
                  m_cPhName = m_Ctx.GetPhName("rapopebo");
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.InsertIntoStatement(m_Ctx,"rapopebo")+" (";
                  m_cSql = m_cSql+GetFieldsName_0705FD28(m_Ctx);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cInfApri1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(xDatIni,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(xDatIni)+Cursor_rapopebo.GetString("NUMPROG")+LibreriaMit.StatoReg("RAPOPEBO","1"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_rapopebo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_rapopebo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_rapopebo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDate("DATAREG"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_rapopebo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDouble("TOTLIRE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDouble("TOTCONT"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_rapopebo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDouble("CAMBIO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDate("DATAAGE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDouble("PRGIMPINF"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(xDatIni),"?",0,0,m_cServer)+", ";
                  if (m_Ctx.IsSharedTemp("rapopebo")) {
                    m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                  }
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
                /* cInfApri2 := rapopebo->NUMPROG */
                cInfApri2 = Cursor_rapopebo.GetString("NUMPROG");
              } // End If
              /* If rapopebo->TIPOOPRAP='26' */
              if (CPLib.eqr(Cursor_rapopebo.GetString("TIPOOPRAP"),"26")) {
                /* _chiudi := 1 */
                _chiudi = CPLib.Round(1,0);
                /* If rapopebo->DATAOPE <> xDatFin */
                if (CPLib.ne(Cursor_rapopebo.GetDate("DATAOPE"),xDatFin)) {
                  // * --- Write into rapopebo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("rapopebo");
                  m_cPhName = m_Ctx.GetPhName("rapopebo");
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = "Update "+m_cPhName+" set ";
                  m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL("3","C",1,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"rapopebo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_rapopebo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_rapopebo.GetString("IDBASE"))+"";
                  if (m_Ctx.IsSharedTemp("rapopebo")) {
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
                  /* cInfChiu1 := Utilities.GetAutonumber("PRGINFO1\'"+LRTrim(gAzienda)+"'",'',10) */
                  cInfChiu1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
                  // * --- Insert into rapopebo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("rapopebo");
                  m_cPhName = m_Ctx.GetPhName("rapopebo");
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.InsertIntoStatement(m_Ctx,"rapopebo")+" (";
                  m_cSql = m_cSql+GetFieldsName_06FB9948(m_Ctx);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cInfChiu1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(xDatIni,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(xDatIni)+Cursor_rapopebo.GetString("NUMPROG")+LibreriaMit.StatoReg("RAPOPEBO","1"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_rapopebo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_rapopebo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_rapopebo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDate("DATAREG"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_rapopebo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDouble("TOTLIRE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDouble("TOTCONT"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_rapopebo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDouble("CAMBIO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDate("DATAAGE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDouble("PRGIMPINF"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(xDatIni),"?",0,0,m_cServer)+", ";
                  if (m_Ctx.IsSharedTemp("rapopebo")) {
                    m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                  }
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
                /* cInfChiu2 := rapopebo->NUMPROG */
                cInfChiu2 = Cursor_rapopebo.GetString("NUMPROG");
              } // End If
              Cursor_rapopebo.Next();
            }
            m_cConnectivityError = Cursor_rapopebo.ErrorMessage();
            Cursor_rapopebo.Close();
            // * --- End Select
            /* If _chiudi=0 and not(Empty(xDatFin)) */
            if (CPLib.eqr(_chiudi,0) &&  ! (CPLib.Empty(xDatFin))) {
              /* cInfChiu1 := Utilities.GetAutonumber("PRGINFO1\'"+LRTrim(gAzienda)+"'",'',10) */
              cInfChiu1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
              /* cInfChiu2 := Utilities.GetAutonumber("PRGINFO2\'"+LRTrim(gAzienda)+"'",'',11) */
              cInfChiu2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
              /* nProgImp := Utilities.GetAutonumber("PRGIMPINF\'"+LRTrim(gAzienda)+"'",0,15) */
              nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINF\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
              // * --- Insert into rapopebo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("rapopebo");
              m_cPhName = m_Ctx.GetPhName("rapopebo");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"rapopebo")+" (";
              m_cSql = m_cSql+GetFieldsName_05E61E88(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(xDatFin),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(xDatFin,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(xDatFin,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_descinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cInfChiu1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(xDatFin)+cInfChiu1+"0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cInfChiu2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(cRapporto,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tipointer,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull("26","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("rapopebo")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
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
            /* If xTipLeg='TE' */
            if (CPLib.eqr(xTipLeg,"TE")) {
              /* ElseIf xTipLeg='LR' */
            } else if (CPLib.eqr(xTipLeg,"LR")) {
              /* cNumMod := 0 */
              cNumMod = CPLib.Round(0,0);
              // * --- Select from soginfo
              m_cServer = m_Ctx.GetServer("soginfo");
              m_cPhName = m_Ctx.GetPhName("soginfo");
              if (Cursor_soginfo!=null)
                Cursor_soginfo.Close();
              Cursor_soginfo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODSOG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPCOL="+CPSql.SQLValueAdapter(CPLib.ToSQL(cRapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,cRapporto)+" "+")"+(m_Ctx.IsSharedTemp("soginfo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM ",m_cServer,m_Ctx,true));
              while ( ! (Cursor_soginfo.Eof())) {
                /* If LRTrim(soginfo->CODSOG)=LRTrim(xCodLeg) */
                if (CPLib.eqr(CPLib.LRTrim(Cursor_soginfo.GetString("CODSOG")),CPLib.LRTrim(xCodLeg))) {
                  /* cNumMod := soginfo->CPROWNUM */
                  cNumMod = CPLib.Round(Cursor_soginfo.GetDouble("CPROWNUM"),0);
                } // End If
                /* _rigsog := _rigsog + 1 */
                _rigsog = CPLib.Round(_rigsog+1,0);
                Cursor_soginfo.Next();
              }
              m_cConnectivityError = Cursor_soginfo.ErrorMessage();
              Cursor_soginfo.Close();
              // * --- End Select
              /* If cNumMod=0 */
              if (CPLib.eqr(cNumMod,0)) {
                // * --- Insert into soginfo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("soginfo");
                m_cPhName = m_Ctx.GetPhName("soginfo");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.InsertIntoStatement(m_Ctx,"soginfo")+" (";
                m_cSql = m_cSql+GetFieldsName_05CAF938(m_Ctx);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_rigsog+1,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull(xCodLeg,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull("1","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cRapporto,"?",0,0,m_cServer)+", ";
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
                  /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" alla riga "+LRTrim(Str(conta,10,0))+NL */
                  gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" alla riga "+CPLib.LRTrim(CPLib.Str(conta,10,0))+"\n";
                  m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                  /* gMsgProc := gMsgProc +"Errori nel file "+nomefileimport+" per la registrazione dei legali rappresentanti nel rapporto "+Left(riga,25)+NL+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                  gMsgProc = gMsgProc+"Errori nel file "+nomefileimport+" per la registrazione dei legali rappresentanti nel rapporto "+CPLib.Left(riga,25)+"\n"+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                  m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                  /* _esito := 1 */
                  _esito = CPLib.Round(1,0);
                  m_cLastMsgError = "";
                  // Exit Loop
                  if (true) {
                    break;
                  }
                } else if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                }
              } // End If
            } // End If
            /* cNumMod := 0 */
            cNumMod = CPLib.Round(0,0);
            /* _rigint := 0 */
            _rigint = CPLib.Round(0,0);
            // * --- Select from intestbo
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            if (Cursor_intestbo!=null)
              Cursor_intestbo.Close();
            Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(cRapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,cRapporto)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM ",m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestbo.Eof())) {
              /* If LRTrim(intestbo->CODINTER)=LRTrim(xCodInt) */
              if (CPLib.eqr(CPLib.LRTrim(Cursor_intestbo.GetString("CODINTER")),CPLib.LRTrim(xCodInt))) {
                /* cNumMod := intestbo->CPROWNUM */
                cNumMod = CPLib.Round(Cursor_intestbo.GetDouble("CPROWNUM"),0);
                /* _modint := 0 */
                _modint = CPLib.Round(0,0);
                /* If intestbo->DATAINI <> xDatIni */
                if (CPLib.ne(Cursor_intestbo.GetDate("DATAINI"),xDatIni)) {
                  /* _modint := 1 */
                  _modint = CPLib.Round(1,0);
                } // End If
                /* If intestbo->DATAFINE <> xDatFin and not(Empty(xDatFin)) */
                if (CPLib.ne(Cursor_intestbo.GetDate("DATAFINE"),xDatFin) &&  ! (CPLib.Empty(xDatFin))) {
                  /* _modint := 1 */
                  _modint = CPLib.Round(1,0);
                } // End If
                /* If _modint = 1 */
                if (CPLib.eqr(_modint,1)) {
                  // * --- Write into intestbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("intestbo");
                  m_cPhName = m_Ctx.GetPhName("intestbo");
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = "Update "+m_cPhName+" set ";
                  m_cSql = m_cSql+"DATAINI = "+CPLib.ToSQL(xDatIni,"D",8,0)+", ";
                  m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(xDatFin,"D",8,0)+", ";
                  m_cSql = m_cSql+"NUMPROG1 = "+CPLib.ToSQL(cInfApri2,"C",11,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NUMPROG2 = "+CPLib.ToSQL(cInfChiu2,"C",11,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cRapporto,"?",0,0,m_cServer),m_cServer,cRapporto)+"";
                  m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cNumMod,"?",0,0,m_cServer),m_cServer,cNumMod)+"";
                  if (m_Ctx.IsSharedTemp("intestbo")) {
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
                } // End If
              } // End If
              /* _rigint := _rigint + 1 */
              _rigint = CPLib.Round(_rigint+1,0);
              Cursor_intestbo.Next();
            }
            m_cConnectivityError = Cursor_intestbo.ErrorMessage();
            Cursor_intestbo.Close();
            // * --- End Select
            /* If cNumMod = 0 */
            if (CPLib.eqr(cNumMod,0)) {
              /* nProgImp2 := Utilities.GetAutonumber("PRGIMPSOG\'"+LRTrim(gAzienda)+"'",0,15) */
              nProgImp2 = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPSOG\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
              // * --- Insert into intestbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("intestbo");
              m_cPhName = m_Ctx.GetPhName("intestbo");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"intestbo")+" (";
              m_cSql = m_cSql+GetFieldsName_07018218(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_rigint+1,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(xDatIni,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("P","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(xCodInt,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cInfApri2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cRapporto,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(xDatIni)+cInfApri2+"0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(xCodInt,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp2,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(xDatFin,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cInfChiu2,"?",0,0,m_cServer)+", ";
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
                /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" alla riga "+LRTrim(Str(conta,10,0))+NL */
                gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" alla riga "+CPLib.LRTrim(CPLib.Str(conta,10,0))+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario dell'informazione in data "+DateToChar(xDatIni)+" relativa al rapporto: "+LRTrim(cRapporto)+NL+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario dell'informazione in data "+CPLib.DateToChar(xDatIni)+" relativa al rapporto: "+CPLib.LRTrim(cRapporto)+"\n"+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* _esito := 1 */
                _esito = CPLib.Round(1,0);
                m_cLastMsgError = "";
                // Exit Loop
                if (true) {
                  break;
                }
              } else if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
            } // End If
            /* cNumMod := cNumMod + 1 */
            cNumMod = CPLib.Round(cNumMod+1,0);
          } // End If
        } // End If
        // * --- Write into dprocessi from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("dprocessi");
        m_cPhName = m_Ctx.GetPhName("dprocessi");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = "Update "+m_cPhName+" set ";
        m_cSql = m_cSql+"DPRNUMRIG = "+CPLib.ToSQL(conta,"N",10,0)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"dprocessi",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"DPR_TIPO = "+CPSql.SQLValueAdapter(CPLib.ToSQL("IMP","?",0,0,m_cServer),m_cServer,"IMP")+"";
        m_cSql = m_cSql+" and DPRCODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_progproc,"?",0,0,m_cServer),m_cServer,_progproc)+"";
        m_cSql = m_cSql+" and DPRPROGRE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_progdproc,"?",0,0,m_cServer),m_cServer,_progdproc)+"";
        if (m_Ctx.IsSharedTemp("dprocessi")) {
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
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* gMsgProc := gMsgProc + 'Rapporti Inseriti: '+LRTrim(Str(cNumNew,10,0)) +' - Rapporti Aggiornati: '+LRTrim(Str(cNumMod,10,0))+' dal file '+nomefileimport+NL */
      gMsgProc = gMsgProc+"Rapporti Inseriti: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+" - Rapporti Aggiornati: "+CPLib.LRTrim(CPLib.Str(cNumMod,10,0))+" dal file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* If _esito = 1 */
      if (CPLib.eqr(_esito,1)) {
        // * --- Write into dprocessi from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("dprocessi");
        m_cPhName = m_Ctx.GetPhName("dprocessi");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = "Update "+m_cPhName+" set ";
        m_cSql = m_cSql+"DPRESITO = "+CPLib.ToSQL("K","C",1,0,m_cServer)+", ";
        m_cSql = m_cSql+"DPRTXTMSG = "+CPLib.ToSQL(gMsgProc,"M",10,0,m_cServer,m_oParameters)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"dprocessi",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"DPR_TIPO = "+CPSql.SQLValueAdapter(CPLib.ToSQL("IMP","?",0,0,m_cServer),m_cServer,"IMP")+"";
        m_cSql = m_cSql+" and DPRCODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_progproc,"?",0,0,m_cServer),m_cServer,_progproc)+"";
        m_cSql = m_cSql+" and DPRPROGRE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_progdproc,"?",0,0,m_cServer),m_cServer,_progdproc)+"";
        if (m_Ctx.IsSharedTemp("dprocessi")) {
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
      } else { // Else
        // * --- Write into dprocessi from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("dprocessi");
        m_cPhName = m_Ctx.GetPhName("dprocessi");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = "Update "+m_cPhName+" set ";
        m_cSql = m_cSql+"DPRESITO = "+CPLib.ToSQL("O","C",1,0,m_cServer)+", ";
        m_cSql = m_cSql+"DPRTXTMSG = "+CPLib.ToSQL(gMsgProc,"M",10,0,m_cServer,m_oParameters)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"dprocessi",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"DPR_TIPO = "+CPSql.SQLValueAdapter(CPLib.ToSQL("IMP","?",0,0,m_cServer),m_cServer,"IMP")+"";
        m_cSql = m_cSql+" and DPRCODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_progproc,"?",0,0,m_cServer),m_cServer,_progproc)+"";
        m_cSql = m_cSql+" and DPRPROGRE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_progdproc,"?",0,0,m_cServer),m_cServer,_progdproc)+"";
        if (m_Ctx.IsSharedTemp("dprocessi")) {
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
      } // End If
      /* gMsgImp := 'Fine importazione del file '+nomefileimport // Messaggio Import */
      gMsgImp = "Fine importazione del file "+nomefileimport;
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
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
        if (Cursor_rapopebo!=null)
          Cursor_rapopebo.Close();
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
  void Page_6() throws Exception {
    CPResultSet Cursor_intestbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_anarapbo=null;
    CPResultSet Cursor_aerighe=null;
    try {
      /* Inserisce il rapporto nell'anagrafe rapporti */
      /* _chkimp := 0 */
      _chkimp = CPLib.Round(0,0);
      /* _cfestero := 0 */
      _cfestero = CPLib.Round(0,0);
      /* _cfimport := '' */
      _cfimport = "";
      /* imprec := 0 */
      imprec = CPLib.Round(0,0);
      // * --- Select from intestbo
      m_cServer = m_Ctx.GetServer("intestbo");
      m_cPhName = m_Ctx.GetPhName("intestbo");
      if (Cursor_intestbo!=null)
        Cursor_intestbo.Close();
      Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(xRapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,xRapporto)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intestbo.Eof())) {
        // * --- Read from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        m_cSql = "";
        m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"C",16,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"));
        if (m_Ctx.IsSharedTemp("personbo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CFESTERO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _cfestero = CPLib.Round(Read_Cursor.GetDouble("CFESTERO"),0);
          _cfimport = Read_Cursor.GetString("CODFISC");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on personbo into routine arrt_imp_dati_multipli_telepass returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _cfestero = 0;
          _cfimport = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* imprec := imprec + 1 */
        imprec = CPLib.Round(imprec+1,0);
        /* gMsgImp := "Import informazioni d'apertura AUI: "+LRTrim(Str(imprec,10,0))+". Operazione 1 di 4" // Messaggio Import */
        gMsgImp = "Import informazioni d'apertura AUI: "+CPLib.LRTrim(CPLib.Str(imprec,10,0))+". Operazione 1 di 4";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _chkimp := _chkimp + iif(Len(LRTrim(_cfimport)) = 0,1,0) */
        _chkimp = CPLib.Round(_chkimp+(CPLib.eqr(CPLib.Len(CPLib.LRTrim(_cfimport)),0)?1:0),0);
        Cursor_intestbo.Next();
      }
      m_cConnectivityError = Cursor_intestbo.ErrorMessage();
      Cursor_intestbo.Close();
      // * --- End Select
      /* If _chkimp = 0 */
      if (CPLib.eqr(_chkimp,0)) {
        /* _rapold := '' */
        _rapold = "";
        // * --- Read from aetesta
        m_cServer = m_Ctx.GetServer("aetesta");
        m_cPhName = m_Ctx.GetPhName("aetesta");
        m_cSql = "";
        m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(xRapporto,"C",25,0,m_cServer),m_cServer,xRapporto);
        if (m_Ctx.IsSharedTemp("aetesta")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _rapold = Read_Cursor.GetString("RAPPORTO");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on aetesta into routine arrt_imp_dati_multipli_telepass returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _rapold = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If Empty(LRTrim(_rapold)) */
        if (CPLib.Empty(CPLib.LRTrim(_rapold))) {
          // * --- Select from anarapbo
          m_cServer = m_Ctx.GetServer("anarapbo");
          m_cPhName = m_Ctx.GetPhName("anarapbo");
          if (Cursor_anarapbo!=null)
            Cursor_anarapbo.Close();
          Cursor_anarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(xRapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,xRapporto)+" "+")"+(m_Ctx.IsSharedTemp("anarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_anarapbo.Eof())) {
            /* _tipoco := iif(anarapbo->TIPORAP='1','1','2') */
            _tipoco = (CPLib.eqr(Cursor_anarapbo.GetString("TIPORAP"),"1")?"1":"2");
            /* nProgImp := Utilities.GetAutonumber("PROGAET\'"+LRTrim(gAzienda)+"'",0,15) */
            nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGAET\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
            // * --- Insert into aetesta from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("aetesta");
            m_cPhName = m_Ctx.GetPhName("aetesta");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.InsertIntoStatement(m_Ctx,"aetesta")+" (";
            m_cSql = m_cSql+GetFieldsName_06DF86E0(m_Ctx);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("A","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_tipoco,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
            if (m_Ctx.IsSharedTemp("aetesta")) {
              m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
            }
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
            Cursor_anarapbo.Next();
          }
          m_cConnectivityError = Cursor_anarapbo.ErrorMessage();
          Cursor_anarapbo.Close();
          // * --- End Select
        } // End If
        // * --- Select from intestbo
        m_cServer = m_Ctx.GetServer("intestbo");
        m_cPhName = m_Ctx.GetPhName("intestbo");
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
        Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(xRapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,xRapporto)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intestbo.Eof())) {
          // * --- Read from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          m_cSql = "";
          m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"C",16,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"));
          if (m_Ctx.IsSharedTemp("personbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CFESTERO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _cfestero = CPLib.Round(Read_Cursor.GetDouble("CFESTERO"),0);
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on personbo into routine arrt_imp_dati_multipli_telepass returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _cfestero = 0;
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* _nriga := 0 */
          _nriga = CPLib.Round(0,0);
          // * --- Read from aerighe
          m_cServer = m_Ctx.GetServer("aerighe");
          m_cPhName = m_Ctx.GetPhName("aerighe");
          m_cSql = "";
          m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(xRapporto,"C",25,0,m_cServer),m_cServer,xRapporto);
          m_cSql = m_cSql+" and CONNESINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"C",16,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"));
          if (m_Ctx.IsSharedTemp("aerighe")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CPROWNUM",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _nriga = CPLib.Round(Read_Cursor.GetDouble("CPROWNUM"),0);
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on aerighe into routine arrt_imp_dati_multipli_telepass returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _nriga = 0;
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If _nriga = 0 */
          if (CPLib.eqr(_nriga,0)) {
            /* _newrow := 1 */
            _newrow = CPLib.Round(1,0);
            // * --- Select from aerighe
            m_cServer = m_Ctx.GetServer("aerighe");
            m_cPhName = m_Ctx.GetPhName("aerighe");
            if (Cursor_aerighe!=null)
              Cursor_aerighe.Close();
            Cursor_aerighe = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CPROWNUM  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(xRapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,xRapporto)+" "+")"+(m_Ctx.IsSharedTemp("aerighe")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_aerighe.Eof())) {
              /* _newrow := _newrow + 1 */
              _newrow = CPLib.Round(_newrow+1,0);
              Cursor_aerighe.Next();
            }
            m_cConnectivityError = Cursor_aerighe.ErrorMessage();
            Cursor_aerighe.Close();
            // * --- End Select
            /* nProgImp2 := Utilities.GetAutonumber("PROGAER\'"+LRTrim(gAzienda)+"'",0,15) */
            nProgImp2 = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGAER\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
            // * --- Insert into aerighe from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("aerighe");
            m_cPhName = m_Ctx.GetPhName("aerighe");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.InsertIntoStatement(m_Ctx,"aerighe")+" (";
            m_cSql = m_cSql+GetFieldsName_0652A118(m_Ctx);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(xRapporto,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_newrow,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetDate("DATAINI"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetDouble("CPROWNUM"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp2,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_cfestero,"?",0,0,m_cServer)+", ";
            if (m_Ctx.IsSharedTemp("aerighe")) {
              m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
            }
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
          } else { // Else
            // * --- Select from aerighe
            m_cServer = m_Ctx.GetServer("aerighe");
            m_cPhName = m_Ctx.GetPhName("aerighe");
            if (Cursor_aerighe!=null)
              Cursor_aerighe.Close();
            Cursor_aerighe = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(xRapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,xRapporto)+"  and  CPROWNUM="+CPSql.SQLValueAdapter(CPLib.ToSQL(_nriga,"?",0,0,m_cServer, m_oParameters),m_cServer,_nriga)+" "+")"+(m_Ctx.IsSharedTemp("aerighe")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_aerighe.Eof())) {
              /* If aerighe->ASPEDITO=0 */
              if (CPLib.eqr(Cursor_aerighe.GetDouble("ASPEDITO"),0)) {
                /* If Empty(aerighe->ADATA) */
                if (CPLib.Empty(Cursor_aerighe.GetDate("ADATA"))) {
                  // * --- Write into aerighe from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("aerighe");
                  m_cPhName = m_Ctx.GetPhName("aerighe");
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = "Update "+m_cPhName+" set ";
                  m_cSql = m_cSql+"ADATA = "+CPLib.ToSQL(Cursor_intestbo.GetDate("DATAINI"),"D",8,0)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(xRapporto,"?",0,0,m_cServer),m_cServer,xRapporto)+"";
                  m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_nriga,"?",0,0,m_cServer),m_cServer,_nriga)+"";
                  if (m_Ctx.IsSharedTemp("aerighe")) {
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
                } // End If
                /* If Empty(LRTrim(aerighe->CONNESINT)) */
                if (CPLib.Empty(CPLib.LRTrim(Cursor_aerighe.GetString("CONNESINT")))) {
                  // * --- Write into aerighe from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("aerighe");
                  m_cPhName = m_Ctx.GetPhName("aerighe");
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = "Update "+m_cPhName+" set ";
                  m_cSql = m_cSql+"CONNESINT = "+CPLib.ToSQLNull(Cursor_intestbo.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(xRapporto,"?",0,0,m_cServer),m_cServer,xRapporto)+"";
                  m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_nriga,"?",0,0,m_cServer),m_cServer,_nriga)+"";
                  if (m_Ctx.IsSharedTemp("aerighe")) {
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
                } // End If
              } // End If
              Cursor_aerighe.Next();
            }
            m_cConnectivityError = Cursor_aerighe.ErrorMessage();
            Cursor_aerighe.Close();
            // * --- End Select
          } // End If
          Cursor_intestbo.Next();
        }
        m_cConnectivityError = Cursor_intestbo.ErrorMessage();
        Cursor_intestbo.Close();
        // * --- End Select
      } // End If
    } finally {
      try {
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
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
        if (Cursor_anarapbo!=null)
          Cursor_anarapbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_aerighe!=null)
          Cursor_aerighe.Close();
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
      m_Caller.SetNumber("impzip","N",1,0,w_impzip);
      m_Caller.SetNumber("errchk","N",1,0,w_errchk);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_imp_dati_multipli_telepassR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_imp_dati_multipli_telepassR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_tipodest = m_Caller.GetString("tipodest","C",1,0);
    w_impzip = m_Caller.GetNumber("impzip","N",1,0);
    w_errchk = m_Caller.GetNumber("errchk","N",1,0);
    fhand = CPLib.Space(1);
    riga = "";
    _chiudi = 0;
    _modint = 0;
    _tipoco = CPLib.Space(1);
    _nriga = 0;
    _newrow = 0;
    _rapold = CPLib.Space(25);
    _chkimp = 0;
    _cfestero = 0;
    _cfimport = CPLib.Space(16);
    xConnes = CPLib.Space(16);
    xRiga1 = "";
    xRiga2 = "";
    xCF = CPLib.Space(16);
    xAnnNas = CPLib.Space(2);
    xMesNas = CPLib.Space(2);
    xDayNas = CPLib.Space(2);
    xSesso = CPLib.Space(1);
    cSNAS = CPLib.Space(40);
    cCNAS = CPLib.Space(40);
    cPNAS = CPLib.Space(2);
    cDNAS = CPLib.NullDate();
    xSOCTCon = CPLib.Space(16);
    xSOCTCF = CPLib.Space(16);
    xCodCab = CPLib.Space(6);
    xCitta = CPLib.Space(30);
    cCliProg = CPLib.Space(6);
    cOpeProg1 = CPLib.Space(10);
    cOpeProg2 = CPLib.Space(11);
    xRapporto = CPLib.Space(25);
    cRapporto = CPLib.Space(25);
    xCAB = CPLib.Space(6);
    xDIP = CPLib.Space(6);
    xDIPx = CPLib.Space(6);
    cCli1 = CPLib.Space(16);
    xIDB = CPLib.Space(10);
    xData = CPLib.Space(8);
    xDatF = CPLib.Space(8);
    cNumNew = 0;
    cNumMod = 0;
    cNumInv = 0;
    cFlagLire = CPLib.Space(1);
    cFlagCont = CPLib.Space(1);
    cFlagFraz = CPLib.Space(1);
    cMaxRow = 0;
    cIdCau = CPLib.Space(4);
    xCFE = 0;
    conta = 0;
    _esito = 0;
    uniquecode = CPLib.Space(10);
    _salta = 0;
    _allineamento = 0;
    _allineatonomecnome = 0;
    _ragsocold = CPLib.Space(70);
    _cabold = CPLib.Space(6);
    nProgImp = 0;
    cProgSto = CPLib.Space(15);
    nProgImp2 = 0;
    _idbase = CPLib.Space(10);
    _codinter = CPLib.Space(11);
    _citinter = CPLib.Space(30);
    _cabinter = CPLib.Space(6);
    _prvinter = CPLib.Space(2);
    _descinter = CPLib.Space(70);
    _tipointer = CPLib.Space(2);
    _intercod = CPLib.Space(11);
    _intercit = CPLib.Space(30);
    _intercab = CPLib.Space(6);
    _interprv = CPLib.Space(2);
    _interini = CPLib.NullDate();
    xRagSoc = CPLib.Space(70);
    NSpazzi = 0;
    NSpazzi2 = 0;
    xNome = CPLib.Space(25);
    xCognome = CPLib.Space(26);
    _allcn = 0;
    Allineamento = CPLib.Space(2);
    SubRag = CPLib.Space(70);
    _i = 0;
    Controllo = CPLib.Space(103);
    cSetSin = CPLib.Space(3);
    _tsogope = CPLib.Space(2);
    _rigsog = 0;
    _rigint = 0;
    cInfApri1 = CPLib.Space(10);
    cInfApri2 = CPLib.Space(11);
    cInfChiu1 = CPLib.Space(10);
    cInfChiu2 = CPLib.Space(11);
    numriga = 0;
    imprec = 0;
    xDatIni = CPLib.NullDate();
    xDatFin = CPLib.NullDate();
    xCodInt = CPLib.Space(9);
    xTipLeg = CPLib.Space(2);
    xCodLeg = CPLib.Space(9);
    xNumRig = 0;
    _progproc = CPLib.Space(10);
    _progdproc = 0;
    _progriga = CPLib.Space(15);
    _numriga = CPLib.Space(3);
    _tipper = CPLib.Space(1);
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
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_calcolasett,arfn_chkcodfis,arfn_fdatetime,arfn_mesecf,arfn_verifica_cf_nome_cognome,
  public static final String i_InvokedRoutines = ",arfn_calcolasett,arfn_chkcodfis,arfn_fdatetime,arfn_mesecf,arfn_verifica_cf_nome_cognome,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_05B4EA70(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"PR_TIPO,";
    p_cSql = p_cSql+"PRCODICE,";
    p_cSql = p_cSql+"PRDESCRI,";
    p_cSql = p_cSql+"PRDOSTART,";
    if (p_Ctx.IsSharedTemp("processi")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"processi",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06E624D0(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"DPR_TIPO,";
    p_cSql = p_cSql+"DPRCODICE,";
    p_cSql = p_cSql+"DPRPROGRE,";
    p_cSql = p_cSql+"DPRTXTMSG,";
    if (p_Ctx.IsSharedTemp("dprocessi")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"dprocessi",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06E75418(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"priorita,";
    if (p_Ctx.IsSharedTemp("tmp_list_imprich")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_list_imprich",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0641BA60(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    if (p_Ctx.IsSharedTemp("tmp_errimp")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_062B5090(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    if (p_Ctx.IsSharedTemp("tmp_errimp")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_07BFCC68(CPContext p_Ctx) {
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
    if (p_Ctx.IsSharedTemp("wersonbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wersonbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06EE8D78(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    if (p_Ctx.IsSharedTemp("tmp_newpers")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_newpers",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06F72ED0(CPContext p_Ctx) {
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
  protected static String GetFieldsName_06DF2AE8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"DPR_TIPO,";
    p_cSql = p_cSql+"DPRCODICE,";
    p_cSql = p_cSql+"DPRPROGRE,";
    p_cSql = p_cSql+"DPRTXTMSG,";
    if (p_Ctx.IsSharedTemp("dprocessi")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"dprocessi",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0704A600(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"TRICODICE,";
    p_cSql = p_cSql+"TRIRAPPO,";
    p_cSql = p_cSql+"TRIRIGA,";
    p_cSql = p_cSql+"TRIDATINI,";
    p_cSql = p_cSql+"TRIDATFIN,";
    p_cSql = p_cSql+"TRICODINT,";
    p_cSql = p_cSql+"TRITIPCOL,";
    p_cSql = p_cSql+"TRICODCOL,";
    if (p_Ctx.IsSharedTemp("tprighe")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tprighe",true);
    return p_cSql;
  }
  protected static String GetFieldsName_07A38CF8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"PRGIMPRAP,";
    p_cSql = p_cSql+"DESCRAP,";
    if (p_Ctx.IsSharedTemp("anarapbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"anarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_07B03D78(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"TIPORAP,";
    if (p_Ctx.IsSharedTemp("knarapbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"knarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_062F3068(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"FLAGLIRE,";
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
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"VALUTA,";
    if (p_Ctx.IsSharedTemp("rapopebo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_060EDBD0(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"FLAGLIRE,";
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
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"VALUTA,";
    if (p_Ctx.IsSharedTemp("rapopebo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06106378(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAPCOL,";
    if (p_Ctx.IsSharedTemp("soginfo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"soginfo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_062CE4B8(CPContext p_Ctx) {
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
    p_cSql = p_cSql+"PRGIMPSOG,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"NUMPROG2,";
    if (p_Ctx.IsSharedTemp("intestbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"intestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0705FD28(CPContext p_Ctx) {
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
    p_cSql = p_cSql+"PRGIMPINF,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"CDATOPE,";
    if (p_Ctx.IsSharedTemp("rapopebo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06FB9948(CPContext p_Ctx) {
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
    p_cSql = p_cSql+"PRGIMPINF,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"CDATOPE,";
    if (p_Ctx.IsSharedTemp("rapopebo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05E61E88(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"FLAGLIRE,";
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
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"VALUTA,";
    if (p_Ctx.IsSharedTemp("rapopebo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05CAF938(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAPCOL,";
    if (p_Ctx.IsSharedTemp("soginfo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"soginfo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_07018218(CPContext p_Ctx) {
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
    p_cSql = p_cSql+"PRGIMPSOG,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"NUMPROG2,";
    if (p_Ctx.IsSharedTemp("intestbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"intestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06DF86E0(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"RIFANA,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"PROGAET,";
    if (p_Ctx.IsSharedTemp("aetesta")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aetesta",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0652A118(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+"NRIGRIF,";
    p_cSql = p_cSql+"IDRIF,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"ASPEDITO,";
    p_cSql = p_cSql+"PROGAER,";
    p_cSql = p_cSql+"NOCODFISC,";
    if (p_Ctx.IsSharedTemp("aerighe")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aerighe",true);
    return p_cSql;
  }
}
