// * --- Area Manuale = BO - Header
// * --- arrt_imp_dati_cgo_sched_tabs_multitry
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
// * --- Fine Area Manuale
public class arrt_imp_dati_cgo_sched_tabs_multitryR implements CallerWithObjs {
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
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_cgo_anadip;
  public String m_cServer_cgo_anadip;
  public String m_cPhName_cgo_anadip_err;
  public String m_cServer_cgo_anadip_err;
  public String m_cPhName_cgo_causali;
  public String m_cServer_cgo_causali;
  public String m_cPhName_cgo_operazioni;
  public String m_cServer_cgo_operazioni;
  public String m_cPhName_cgo_operazioni_dl;
  public String m_cServer_cgo_operazioni_dl;
  public String m_cPhName_cgo_rapporti;
  public String m_cServer_cgo_rapporti;
  public String m_cPhName_cgo_rapporti_err;
  public String m_cServer_cgo_rapporti_err;
  public String m_cPhName_cgo_soggetti;
  public String m_cServer_cgo_soggetti;
  public String m_cPhName_cgo_soggetti_err;
  public String m_cServer_cgo_soggetti_err;
  public String m_cPhName_cgo_telematico;
  public String m_cServer_cgo_telematico;
  public String m_cPhName_cgo_telematico_err;
  public String m_cServer_cgo_telematico_err;
  public String m_cPhName_cgo_totope;
  public String m_cServer_cgo_totope;
  public String m_cPhName_cgo_users;
  public String m_cServer_cgo_users;
  public String m_cPhName_clientifrz;
  public String m_cServer_clientifrz;
  public String m_cPhName_clientiope;
  public String m_cServer_clientiope;
  public String m_cPhName_cpazi;
  public String m_cServer_cpazi;
  public String m_cPhName_cpusers;
  public String m_cServer_cpusers;
  public String m_cPhName_cpusers_add;
  public String m_cServer_cpusers_add;
  public String m_cPhName_cpusrgrp;
  public String m_cServer_cpusrgrp;
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public String m_cPhName_inter2bo;
  public String m_cServer_inter2bo;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_knarapbo;
  public String m_cServer_knarapbo;
  public String m_cPhName_log_app;
  public String m_cServer_log_app;
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
  public String m_cPhName_sogopebo;
  public String m_cServer_sogopebo;
  public String m_cPhName_sogopefbo;
  public String m_cServer_sogopefbo;
  public String m_cPhName_tbcauana;
  public String m_cServer_tbcauana;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public String m_cPhName_tbtipdoc;
  public String m_cServer_tbtipdoc;
  public String m_cPhName_tbvalute;
  public String m_cServer_tbvalute;
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
  public String m_cPhName_xapopebo;
  public String m_cServer_xapopebo;
  public String m_cPhName_xlientifrz;
  public String m_cServer_xlientifrz;
  public String m_cPhName_xlientiope;
  public String m_cServer_xlientiope;
  public String m_cPhName_xnarapbo;
  public String m_cServer_xnarapbo;
  public String m_cPhName_xntestbo;
  public String m_cServer_xntestbo;
  public String m_cPhName_xperazbo;
  public String m_cServer_xperazbo;
  public String m_cPhName_xraziobo;
  public String m_cServer_xraziobo;
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
  public String fhand;
  public String riga;
  public String _tdest;
  public String xConnes;
  public String xCF;
  public String xRiga1;
  public String xRiga2;
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
  public String cInfProg1;
  public String cInfProg2;
  public String cOpeProg1;
  public String cOpeProg2;
  public String xRapporto;
  public String xCAB;
  public String xDIP;
  public String xDIPx;
  public String cCli1;
  public String xIDB;
  public String xData;
  public String xDatF;
  public double cNumNew;
  public double rNumNew;
  public double cNumMod;
  public double rNumMod;
  public double cNumInv;
  public String cFlagLire;
  public String cFlagCont;
  public String cFlagFraz;
  public double cMaxRow;
  public String cIdCau;
  public double xCFE;
  public double conta;
  public double _esito;
  public String _unicode;
  public String _ucode;
  public double _salta;
  public double _allineamento;
  public double _allineatonomecnome;
  public String _ragsocold;
  public String _cabold;
  public double nProgImp;
  public double nProgImp2;
  public String cProgSto;
  public String _idbase;
  public String _tipinter;
  public String _codinter;
  public String _citinter;
  public String _cabinter;
  public String _prvinter;
  public String _intertip;
  public String _intercod;
  public String _intercit;
  public String _intercab;
  public String _interprv;
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
  public double _newop;
  public String _nprog;
  public String _operazmod;
  public String stringaflagrap2;
  public String _flagrap2;
  public String _idreg;
  public String cNewProg;
  public double numriga;
  public String _tipper;
  public double chkat;
  public String _benrag;
  public String _bensta;
  public String _bencta;
  public String _bencab;
  public String _benprv;
  public String _benind;
  public String _bencap;
  public String abicab;
  public String _flgvnp;
  public String _flgvlt;
  public String cProgImp;
  public String _snainumope;
  public double _codcau;
  public java.sql.Date _datini;
  public java.sql.Date _datend;
  public String _codrap;
  public String _intcon;
  public String _mezpagam;
  public String _MsgAss;
  public String ciidbase;
  public java.sql.Date cidataini;
  public java.sql.Date cidatafine;
  public String cicodinter;
  public String cinumprog;
  public String citiporap;
  public double w_errchk;
  public String w_tipodest;
  public String filename;
  public double _conta;
  public String _gMsgProc;
  public String cProg;
  public double _totale;
  public double _max;
  public double _min;
  public double _cicli;
  public double _contacilci;
  public double _bottom;
  public double _top;
  public double _movcod;
  public double dNumNew;
  public double dNumMod;
  public double dNumErr;
  public double oNumero;
  public double oNumErr;
  public double fNumero;
  public double sNumNew;
  public double sNumMod;
  public double sNumInv;
  public double sNumErr;
  public double rNumErr;
  public double uNumNew;
  public double uNumMod;
  public double nTotErr;
  public double _recOK;
  public java.sql.Date _datope;
  public java.sql.Date _datreg;
  public java.sql.Date _datimp;
  public java.sql.Date _datnas;
  public java.sql.Date _datemi;
  public java.sql.Date _datval;
  public String _txterr;
  public String _codana;
  public String _codsin;
  public String _segno;
  public String _tipope;
  public double nIntest;
  public String _tiporap;
  public String _locrap;
  public String _codsog;
  public String _gAzienda;
  public String _chiave;
  public String _flgfile;
  public String _oldazi;
  public double _limoper;
  public String ProgErr;
  public double _limvlt;
  public double _limvnp;
  public String _numope;
  public String _oidb;
  public String _idb;
  public String _seekid;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_imp_dati_cgo_sched_tabs_multitry
  public String[] lista;
  public int conteggio;
  public int i;
  public int contanome;
  // * --- Fine Area Manuale
  public arrt_imp_dati_cgo_sched_tabs_multitryR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_imp_dati_cgo_sched_tabs_multitry",m_Caller);
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_cgo_anadip = p_ContextObject.GetPhName("cgo_anadip");
    m_cServer_cgo_anadip = p_ContextObject.GetServer("cgo_anadip");
    m_cPhName_cgo_anadip_err = p_ContextObject.GetPhName("cgo_anadip_err");
    m_cServer_cgo_anadip_err = p_ContextObject.GetServer("cgo_anadip_err");
    m_cPhName_cgo_causali = p_ContextObject.GetPhName("cgo_causali");
    m_cServer_cgo_causali = p_ContextObject.GetServer("cgo_causali");
    m_cPhName_cgo_operazioni = p_ContextObject.GetPhName("cgo_operazioni");
    m_cServer_cgo_operazioni = p_ContextObject.GetServer("cgo_operazioni");
    m_cPhName_cgo_operazioni_dl = p_ContextObject.GetPhName("cgo_operazioni_dl");
    m_cServer_cgo_operazioni_dl = p_ContextObject.GetServer("cgo_operazioni_dl");
    m_cPhName_cgo_rapporti = p_ContextObject.GetPhName("cgo_rapporti");
    m_cServer_cgo_rapporti = p_ContextObject.GetServer("cgo_rapporti");
    m_cPhName_cgo_rapporti_err = p_ContextObject.GetPhName("cgo_rapporti_err");
    m_cServer_cgo_rapporti_err = p_ContextObject.GetServer("cgo_rapporti_err");
    m_cPhName_cgo_soggetti = p_ContextObject.GetPhName("cgo_soggetti");
    m_cServer_cgo_soggetti = p_ContextObject.GetServer("cgo_soggetti");
    m_cPhName_cgo_soggetti_err = p_ContextObject.GetPhName("cgo_soggetti_err");
    m_cServer_cgo_soggetti_err = p_ContextObject.GetServer("cgo_soggetti_err");
    m_cPhName_cgo_telematico = p_ContextObject.GetPhName("cgo_telematico");
    m_cServer_cgo_telematico = p_ContextObject.GetServer("cgo_telematico");
    m_cPhName_cgo_telematico_err = p_ContextObject.GetPhName("cgo_telematico_err");
    m_cServer_cgo_telematico_err = p_ContextObject.GetServer("cgo_telematico_err");
    m_cPhName_cgo_totope = p_ContextObject.GetPhName("cgo_totope");
    m_cServer_cgo_totope = p_ContextObject.GetServer("cgo_totope");
    m_cPhName_cgo_users = p_ContextObject.GetPhName("cgo_users");
    m_cServer_cgo_users = p_ContextObject.GetServer("cgo_users");
    m_cPhName_clientifrz = p_ContextObject.GetPhName("clientifrz");
    m_cServer_clientifrz = p_ContextObject.GetServer("clientifrz");
    m_cPhName_clientiope = p_ContextObject.GetPhName("clientiope");
    m_cServer_clientiope = p_ContextObject.GetServer("clientiope");
    m_cPhName_cpazi = p_ContextObject.GetPhName("cpazi");
    m_cServer_cpazi = p_ContextObject.GetServer("cpazi");
    m_cPhName_cpusers = p_ContextObject.GetPhName("cpusers");
    m_cServer_cpusers = p_ContextObject.GetServer("cpusers");
    m_cPhName_cpusers_add = p_ContextObject.GetPhName("cpusers_add");
    m_cServer_cpusers_add = p_ContextObject.GetServer("cpusers_add");
    m_cPhName_cpusrgrp = p_ContextObject.GetPhName("cpusrgrp");
    m_cServer_cpusrgrp = p_ContextObject.GetServer("cpusrgrp");
    m_cPhName_fraziobo = p_ContextObject.GetPhName("fraziobo");
    m_cServer_fraziobo = p_ContextObject.GetServer("fraziobo");
    m_cPhName_inter2bo = p_ContextObject.GetPhName("inter2bo");
    m_cServer_inter2bo = p_ContextObject.GetServer("inter2bo");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_knarapbo = p_ContextObject.GetPhName("knarapbo");
    m_cServer_knarapbo = p_ContextObject.GetServer("knarapbo");
    m_cPhName_log_app = p_ContextObject.GetPhName("log_app");
    m_cServer_log_app = p_ContextObject.GetServer("log_app");
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_rapopebo = p_ContextObject.GetPhName("rapopebo");
    m_cServer_rapopebo = p_ContextObject.GetServer("rapopebo");
    m_cPhName_sogopebo = p_ContextObject.GetPhName("sogopebo");
    m_cServer_sogopebo = p_ContextObject.GetServer("sogopebo");
    m_cPhName_sogopefbo = p_ContextObject.GetPhName("sogopefbo");
    m_cServer_sogopefbo = p_ContextObject.GetServer("sogopefbo");
    m_cPhName_tbcauana = p_ContextObject.GetPhName("tbcauana");
    m_cServer_tbcauana = p_ContextObject.GetServer("tbcauana");
    m_cPhName_tbcitta = p_ContextObject.GetPhName("tbcitta");
    m_cServer_tbcitta = p_ContextObject.GetServer("tbcitta");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_cPhName_tbtipdoc = p_ContextObject.GetPhName("tbtipdoc");
    m_cServer_tbtipdoc = p_ContextObject.GetServer("tbtipdoc");
    m_cPhName_tbvalute = p_ContextObject.GetPhName("tbvalute");
    m_cServer_tbvalute = p_ContextObject.GetServer("tbvalute");
    m_cPhName_wersonbo = p_ContextObject.GetPhName("wersonbo");
    m_cServer_wersonbo = p_ContextObject.GetServer("wersonbo");
    m_cPhName_xapopebo = p_ContextObject.GetPhName("xapopebo");
    m_cServer_xapopebo = p_ContextObject.GetServer("xapopebo");
    m_cPhName_xlientifrz = p_ContextObject.GetPhName("xlientifrz");
    m_cServer_xlientifrz = p_ContextObject.GetServer("xlientifrz");
    m_cPhName_xlientiope = p_ContextObject.GetPhName("xlientiope");
    m_cServer_xlientiope = p_ContextObject.GetServer("xlientiope");
    m_cPhName_xnarapbo = p_ContextObject.GetPhName("xnarapbo");
    m_cServer_xnarapbo = p_ContextObject.GetServer("xnarapbo");
    m_cPhName_xntestbo = p_ContextObject.GetPhName("xntestbo");
    m_cServer_xntestbo = p_ContextObject.GetServer("xntestbo");
    m_cPhName_xperazbo = p_ContextObject.GetPhName("xperazbo");
    m_cServer_xperazbo = p_ContextObject.GetServer("xperazbo");
    m_cPhName_xraziobo = p_ContextObject.GetPhName("xraziobo");
    m_cServer_xraziobo = p_ContextObject.GetServer("xraziobo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("cNumNew",p_cVarName)) {
      return cNumNew;
    }
    if (CPLib.eqr("rNumNew",p_cVarName)) {
      return rNumNew;
    }
    if (CPLib.eqr("cNumMod",p_cVarName)) {
      return cNumMod;
    }
    if (CPLib.eqr("rNumMod",p_cVarName)) {
      return rNumMod;
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
    if (CPLib.eqr("_newop",p_cVarName)) {
      return _newop;
    }
    if (CPLib.eqr("numriga",p_cVarName)) {
      return numriga;
    }
    if (CPLib.eqr("chkat",p_cVarName)) {
      return chkat;
    }
    if (CPLib.eqr("_codcau",p_cVarName)) {
      return _codcau;
    }
    if (CPLib.eqr("errchk",p_cVarName)) {
      return w_errchk;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_totale",p_cVarName)) {
      return _totale;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      return _max;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      return _min;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
    }
    if (CPLib.eqr("_contacilci",p_cVarName)) {
      return _contacilci;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      return _bottom;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      return _top;
    }
    if (CPLib.eqr("_movcod",p_cVarName)) {
      return _movcod;
    }
    if (CPLib.eqr("dNumNew",p_cVarName)) {
      return dNumNew;
    }
    if (CPLib.eqr("dNumMod",p_cVarName)) {
      return dNumMod;
    }
    if (CPLib.eqr("dNumErr",p_cVarName)) {
      return dNumErr;
    }
    if (CPLib.eqr("oNumero",p_cVarName)) {
      return oNumero;
    }
    if (CPLib.eqr("oNumErr",p_cVarName)) {
      return oNumErr;
    }
    if (CPLib.eqr("fNumero",p_cVarName)) {
      return fNumero;
    }
    if (CPLib.eqr("sNumNew",p_cVarName)) {
      return sNumNew;
    }
    if (CPLib.eqr("sNumMod",p_cVarName)) {
      return sNumMod;
    }
    if (CPLib.eqr("sNumInv",p_cVarName)) {
      return sNumInv;
    }
    if (CPLib.eqr("sNumErr",p_cVarName)) {
      return sNumErr;
    }
    if (CPLib.eqr("rNumErr",p_cVarName)) {
      return rNumErr;
    }
    if (CPLib.eqr("uNumNew",p_cVarName)) {
      return uNumNew;
    }
    if (CPLib.eqr("uNumMod",p_cVarName)) {
      return uNumMod;
    }
    if (CPLib.eqr("nTotErr",p_cVarName)) {
      return nTotErr;
    }
    if (CPLib.eqr("_recOK",p_cVarName)) {
      return _recOK;
    }
    if (CPLib.eqr("nIntest",p_cVarName)) {
      return nIntest;
    }
    if (CPLib.eqr("_limoper",p_cVarName)) {
      return _limoper;
    }
    if (CPLib.eqr("_limvlt",p_cVarName)) {
      return _limvlt;
    }
    if (CPLib.eqr("_limvnp",p_cVarName)) {
      return _limvnp;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_imp_dati_cgo_sched_tabs_multitry";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      return riga;
    }
    if (CPLib.eqr("_tdest",p_cVarName)) {
      return _tdest;
    }
    if (CPLib.eqr("xConnes",p_cVarName)) {
      return xConnes;
    }
    if (CPLib.eqr("xCF",p_cVarName)) {
      return xCF;
    }
    if (CPLib.eqr("xRiga1",p_cVarName)) {
      return xRiga1;
    }
    if (CPLib.eqr("xRiga2",p_cVarName)) {
      return xRiga2;
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
    if (CPLib.eqr("_unicode",p_cVarName)) {
      return _unicode;
    }
    if (CPLib.eqr("_ucode",p_cVarName)) {
      return _ucode;
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
    if (CPLib.eqr("_intertip",p_cVarName)) {
      return _intertip;
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
    if (CPLib.eqr("_nprog",p_cVarName)) {
      return _nprog;
    }
    if (CPLib.eqr("_operazmod",p_cVarName)) {
      return _operazmod;
    }
    if (CPLib.eqr("stringaflagrap2",p_cVarName)) {
      return stringaflagrap2;
    }
    if (CPLib.eqr("_flagrap2",p_cVarName)) {
      return _flagrap2;
    }
    if (CPLib.eqr("_idreg",p_cVarName)) {
      return _idreg;
    }
    if (CPLib.eqr("cNewProg",p_cVarName)) {
      return cNewProg;
    }
    if (CPLib.eqr("_tipper",p_cVarName)) {
      return _tipper;
    }
    if (CPLib.eqr("_benrag",p_cVarName)) {
      return _benrag;
    }
    if (CPLib.eqr("_bensta",p_cVarName)) {
      return _bensta;
    }
    if (CPLib.eqr("_bencta",p_cVarName)) {
      return _bencta;
    }
    if (CPLib.eqr("_bencab",p_cVarName)) {
      return _bencab;
    }
    if (CPLib.eqr("_benprv",p_cVarName)) {
      return _benprv;
    }
    if (CPLib.eqr("_benind",p_cVarName)) {
      return _benind;
    }
    if (CPLib.eqr("_bencap",p_cVarName)) {
      return _bencap;
    }
    if (CPLib.eqr("abicab",p_cVarName)) {
      return abicab;
    }
    if (CPLib.eqr("_flgvnp",p_cVarName)) {
      return _flgvnp;
    }
    if (CPLib.eqr("_flgvlt",p_cVarName)) {
      return _flgvlt;
    }
    if (CPLib.eqr("cProgImp",p_cVarName)) {
      return cProgImp;
    }
    if (CPLib.eqr("_snainumope",p_cVarName)) {
      return _snainumope;
    }
    if (CPLib.eqr("_codrap",p_cVarName)) {
      return _codrap;
    }
    if (CPLib.eqr("_intcon",p_cVarName)) {
      return _intcon;
    }
    if (CPLib.eqr("_mezpagam",p_cVarName)) {
      return _mezpagam;
    }
    if (CPLib.eqr("_MsgAss",p_cVarName)) {
      return _MsgAss;
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
    if (CPLib.eqr("tipodest",p_cVarName)) {
      return w_tipodest;
    }
    if (CPLib.eqr("filename",p_cVarName)) {
      return filename;
    }
    if (CPLib.eqr("_gMsgProc",p_cVarName)) {
      return _gMsgProc;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      return cProg;
    }
    if (CPLib.eqr("_txterr",p_cVarName)) {
      return _txterr;
    }
    if (CPLib.eqr("_codana",p_cVarName)) {
      return _codana;
    }
    if (CPLib.eqr("_codsin",p_cVarName)) {
      return _codsin;
    }
    if (CPLib.eqr("_segno",p_cVarName)) {
      return _segno;
    }
    if (CPLib.eqr("_tipope",p_cVarName)) {
      return _tipope;
    }
    if (CPLib.eqr("_tiporap",p_cVarName)) {
      return _tiporap;
    }
    if (CPLib.eqr("_locrap",p_cVarName)) {
      return _locrap;
    }
    if (CPLib.eqr("_codsog",p_cVarName)) {
      return _codsog;
    }
    if (CPLib.eqr("_gAzienda",p_cVarName)) {
      return _gAzienda;
    }
    if (CPLib.eqr("_chiave",p_cVarName)) {
      return _chiave;
    }
    if (CPLib.eqr("_flgfile",p_cVarName)) {
      return _flgfile;
    }
    if (CPLib.eqr("_oldazi",p_cVarName)) {
      return _oldazi;
    }
    if (CPLib.eqr("ProgErr",p_cVarName)) {
      return ProgErr;
    }
    if (CPLib.eqr("_numope",p_cVarName)) {
      return _numope;
    }
    if (CPLib.eqr("_oidb",p_cVarName)) {
      return _oidb;
    }
    if (CPLib.eqr("_idb",p_cVarName)) {
      return _idb;
    }
    if (CPLib.eqr("_seekid",p_cVarName)) {
      return _seekid;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("cDNAS",p_cVarName)) {
      return cDNAS;
    }
    if (CPLib.eqr("_datini",p_cVarName)) {
      return _datini;
    }
    if (CPLib.eqr("_datend",p_cVarName)) {
      return _datend;
    }
    if (CPLib.eqr("cidataini",p_cVarName)) {
      return cidataini;
    }
    if (CPLib.eqr("cidatafine",p_cVarName)) {
      return cidatafine;
    }
    if (CPLib.eqr("_datope",p_cVarName)) {
      return _datope;
    }
    if (CPLib.eqr("_datreg",p_cVarName)) {
      return _datreg;
    }
    if (CPLib.eqr("_datimp",p_cVarName)) {
      return _datimp;
    }
    if (CPLib.eqr("_datnas",p_cVarName)) {
      return _datnas;
    }
    if (CPLib.eqr("_datemi",p_cVarName)) {
      return _datemi;
    }
    if (CPLib.eqr("_datval",p_cVarName)) {
      return _datval;
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
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("cNumNew",p_cVarName)) {
      cNumNew = value;
      return;
    }
    if (CPLib.eqr("rNumNew",p_cVarName)) {
      rNumNew = value;
      return;
    }
    if (CPLib.eqr("cNumMod",p_cVarName)) {
      cNumMod = value;
      return;
    }
    if (CPLib.eqr("rNumMod",p_cVarName)) {
      rNumMod = value;
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
    if (CPLib.eqr("_newop",p_cVarName)) {
      _newop = value;
      return;
    }
    if (CPLib.eqr("numriga",p_cVarName)) {
      numriga = value;
      return;
    }
    if (CPLib.eqr("chkat",p_cVarName)) {
      chkat = value;
      return;
    }
    if (CPLib.eqr("_codcau",p_cVarName)) {
      _codcau = value;
      return;
    }
    if (CPLib.eqr("errchk",p_cVarName)) {
      w_errchk = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
    if (CPLib.eqr("_totale",p_cVarName)) {
      _totale = value;
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
    if (CPLib.eqr("_cicli",p_cVarName)) {
      _cicli = value;
      return;
    }
    if (CPLib.eqr("_contacilci",p_cVarName)) {
      _contacilci = value;
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
    if (CPLib.eqr("_movcod",p_cVarName)) {
      _movcod = value;
      return;
    }
    if (CPLib.eqr("dNumNew",p_cVarName)) {
      dNumNew = value;
      return;
    }
    if (CPLib.eqr("dNumMod",p_cVarName)) {
      dNumMod = value;
      return;
    }
    if (CPLib.eqr("dNumErr",p_cVarName)) {
      dNumErr = value;
      return;
    }
    if (CPLib.eqr("oNumero",p_cVarName)) {
      oNumero = value;
      return;
    }
    if (CPLib.eqr("oNumErr",p_cVarName)) {
      oNumErr = value;
      return;
    }
    if (CPLib.eqr("fNumero",p_cVarName)) {
      fNumero = value;
      return;
    }
    if (CPLib.eqr("sNumNew",p_cVarName)) {
      sNumNew = value;
      return;
    }
    if (CPLib.eqr("sNumMod",p_cVarName)) {
      sNumMod = value;
      return;
    }
    if (CPLib.eqr("sNumInv",p_cVarName)) {
      sNumInv = value;
      return;
    }
    if (CPLib.eqr("sNumErr",p_cVarName)) {
      sNumErr = value;
      return;
    }
    if (CPLib.eqr("rNumErr",p_cVarName)) {
      rNumErr = value;
      return;
    }
    if (CPLib.eqr("uNumNew",p_cVarName)) {
      uNumNew = value;
      return;
    }
    if (CPLib.eqr("uNumMod",p_cVarName)) {
      uNumMod = value;
      return;
    }
    if (CPLib.eqr("nTotErr",p_cVarName)) {
      nTotErr = value;
      return;
    }
    if (CPLib.eqr("_recOK",p_cVarName)) {
      _recOK = value;
      return;
    }
    if (CPLib.eqr("nIntest",p_cVarName)) {
      nIntest = value;
      return;
    }
    if (CPLib.eqr("_limoper",p_cVarName)) {
      _limoper = value;
      return;
    }
    if (CPLib.eqr("_limvlt",p_cVarName)) {
      _limvlt = value;
      return;
    }
    if (CPLib.eqr("_limvnp",p_cVarName)) {
      _limvnp = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      riga = value;
      return;
    }
    if (CPLib.eqr("_tdest",p_cVarName)) {
      _tdest = value;
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
    if (CPLib.eqr("xRiga1",p_cVarName)) {
      xRiga1 = value;
      return;
    }
    if (CPLib.eqr("xRiga2",p_cVarName)) {
      xRiga2 = value;
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
    if (CPLib.eqr("_unicode",p_cVarName)) {
      _unicode = value;
      return;
    }
    if (CPLib.eqr("_ucode",p_cVarName)) {
      _ucode = value;
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
    if (CPLib.eqr("_intertip",p_cVarName)) {
      _intertip = value;
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
    if (CPLib.eqr("_nprog",p_cVarName)) {
      _nprog = value;
      return;
    }
    if (CPLib.eqr("_operazmod",p_cVarName)) {
      _operazmod = value;
      return;
    }
    if (CPLib.eqr("stringaflagrap2",p_cVarName)) {
      stringaflagrap2 = value;
      return;
    }
    if (CPLib.eqr("_flagrap2",p_cVarName)) {
      _flagrap2 = value;
      return;
    }
    if (CPLib.eqr("_idreg",p_cVarName)) {
      _idreg = value;
      return;
    }
    if (CPLib.eqr("cNewProg",p_cVarName)) {
      cNewProg = value;
      return;
    }
    if (CPLib.eqr("_tipper",p_cVarName)) {
      _tipper = value;
      return;
    }
    if (CPLib.eqr("_benrag",p_cVarName)) {
      _benrag = value;
      return;
    }
    if (CPLib.eqr("_bensta",p_cVarName)) {
      _bensta = value;
      return;
    }
    if (CPLib.eqr("_bencta",p_cVarName)) {
      _bencta = value;
      return;
    }
    if (CPLib.eqr("_bencab",p_cVarName)) {
      _bencab = value;
      return;
    }
    if (CPLib.eqr("_benprv",p_cVarName)) {
      _benprv = value;
      return;
    }
    if (CPLib.eqr("_benind",p_cVarName)) {
      _benind = value;
      return;
    }
    if (CPLib.eqr("_bencap",p_cVarName)) {
      _bencap = value;
      return;
    }
    if (CPLib.eqr("abicab",p_cVarName)) {
      abicab = value;
      return;
    }
    if (CPLib.eqr("_flgvnp",p_cVarName)) {
      _flgvnp = value;
      return;
    }
    if (CPLib.eqr("_flgvlt",p_cVarName)) {
      _flgvlt = value;
      return;
    }
    if (CPLib.eqr("cProgImp",p_cVarName)) {
      cProgImp = value;
      return;
    }
    if (CPLib.eqr("_snainumope",p_cVarName)) {
      _snainumope = value;
      return;
    }
    if (CPLib.eqr("_codrap",p_cVarName)) {
      _codrap = value;
      return;
    }
    if (CPLib.eqr("_intcon",p_cVarName)) {
      _intcon = value;
      return;
    }
    if (CPLib.eqr("_mezpagam",p_cVarName)) {
      _mezpagam = value;
      return;
    }
    if (CPLib.eqr("_MsgAss",p_cVarName)) {
      _MsgAss = value;
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
    if (CPLib.eqr("tipodest",p_cVarName)) {
      w_tipodest = value;
      return;
    }
    if (CPLib.eqr("filename",p_cVarName)) {
      filename = value;
      return;
    }
    if (CPLib.eqr("_gMsgProc",p_cVarName)) {
      _gMsgProc = value;
      return;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      cProg = value;
      return;
    }
    if (CPLib.eqr("_txterr",p_cVarName)) {
      _txterr = value;
      return;
    }
    if (CPLib.eqr("_codana",p_cVarName)) {
      _codana = value;
      return;
    }
    if (CPLib.eqr("_codsin",p_cVarName)) {
      _codsin = value;
      return;
    }
    if (CPLib.eqr("_segno",p_cVarName)) {
      _segno = value;
      return;
    }
    if (CPLib.eqr("_tipope",p_cVarName)) {
      _tipope = value;
      return;
    }
    if (CPLib.eqr("_tiporap",p_cVarName)) {
      _tiporap = value;
      return;
    }
    if (CPLib.eqr("_locrap",p_cVarName)) {
      _locrap = value;
      return;
    }
    if (CPLib.eqr("_codsog",p_cVarName)) {
      _codsog = value;
      return;
    }
    if (CPLib.eqr("_gAzienda",p_cVarName)) {
      _gAzienda = value;
      return;
    }
    if (CPLib.eqr("_chiave",p_cVarName)) {
      _chiave = value;
      return;
    }
    if (CPLib.eqr("_flgfile",p_cVarName)) {
      _flgfile = value;
      return;
    }
    if (CPLib.eqr("_oldazi",p_cVarName)) {
      _oldazi = value;
      return;
    }
    if (CPLib.eqr("ProgErr",p_cVarName)) {
      ProgErr = value;
      return;
    }
    if (CPLib.eqr("_numope",p_cVarName)) {
      _numope = value;
      return;
    }
    if (CPLib.eqr("_oidb",p_cVarName)) {
      _oidb = value;
      return;
    }
    if (CPLib.eqr("_idb",p_cVarName)) {
      _idb = value;
      return;
    }
    if (CPLib.eqr("_seekid",p_cVarName)) {
      _seekid = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("cDNAS",p_cVarName)) {
      cDNAS = value;
      return;
    }
    if (CPLib.eqr("_datini",p_cVarName)) {
      _datini = value;
      return;
    }
    if (CPLib.eqr("_datend",p_cVarName)) {
      _datend = value;
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
    if (CPLib.eqr("_datope",p_cVarName)) {
      _datope = value;
      return;
    }
    if (CPLib.eqr("_datreg",p_cVarName)) {
      _datreg = value;
      return;
    }
    if (CPLib.eqr("_datimp",p_cVarName)) {
      _datimp = value;
      return;
    }
    if (CPLib.eqr("_datnas",p_cVarName)) {
      _datnas = value;
      return;
    }
    if (CPLib.eqr("_datemi",p_cVarName)) {
      _datemi = value;
      return;
    }
    if (CPLib.eqr("_datval",p_cVarName)) {
      _datval = value;
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
    CPResultSet Cursor_cpazi=null;
    CPResultSet Cursor_intermbo=null;
    try {
      /* fhand Char(1) */
      /* riga Memo */
      /* _tdest Char(1) */
      /* xConnes Char(16) */
      /* xCF Char(16) */
      /* xRiga1 Memo */
      /* xRiga2 Memo */
      /* xAnnNas Char(2) // Anno Di Nascita */
      /* xMesNas Char(2) // Mese Di Nascita */
      /* xDayNas Char(2) // Giorno Di Nascita */
      /* xSesso Char(1) */
      /* cSNAS Char(30) */
      /* cCNAS Char(30) */
      /* cPNAS Char(2) */
      /* cDNAS Date */
      /* xSOCTCon Char(16) */
      /* xSOCTCF Char(16) */
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
      /* cNumNew Numeric(10, 0) // Contatore record nuovi */
      /* rNumNew Numeric(10, 0) // Contatore record nuovi */
      /* cNumMod Numeric(10, 0) // Contatore record aggiornati */
      /* rNumMod Numeric(10, 0) // Contatore record aggiornati */
      /* cNumInv Numeric(10, 0) // Contatore record invariati */
      /* cFlagLire Char(1) */
      /* cFlagCont Char(1) */
      /* cFlagFraz Char(1) */
      /* cMaxRow Numeric(4, 0) */
      /* cIdCau Char(4) */
      /* xCFE Numeric(1, 0) */
      /* conta Numeric(10, 0) */
      /* _esito Numeric(1, 0) */
      /* _unicode Char(10) */
      /* _ucode Char(10) */
      /* _salta Numeric(1, 0) */
      /* _allineamento Numeric(1, 0) */
      /* _allineatonomecnome Numeric(1, 0) */
      /* _ragsocold Char(70) */
      /* _cabold Char(6) */
      /* nProgImp Numeric(15, 0) */
      /* nProgImp2 Numeric(15, 0) */
      /* cProgSto Char(15) */
      /* _idbase Char(10) */
      /* _tipinter Char(2) */
      /* _codinter Char(11) */
      /* _citinter Char(30) */
      /* _cabinter Char(6) */
      /* _prvinter Char(2) */
      /* _intertip Char(2) */
      /* _intercod Char(11) */
      /* _intercit Char(30) */
      /* _intercab Char(6) */
      /* _interprv Char(2) */
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
      /* _newop Numeric(1, 0) */
      /* _nprog Char(10) */
      /* _operazmod Char(20) // Operazione Modificata */
      /* stringaflagrap2 Char(9) // stringa di valori di flagrap2 */
      /* _flagrap2 Char(1) */
      /* _idreg Char(20) */
      /* cNewProg Char(10) */
      /* numriga Numeric(10, 0) */
      /* _tipper Char(1) */
      /* chkat Numeric(1, 0) */
      /* _benrag Char(70) */
      /* _bensta Char(3) */
      /* _bencta Char(30) */
      /* _bencab Char(6) */
      /* _benprv Char(2) */
      /* _benind Char(35) */
      /* _bencap Char(5) */
      /* abicab Char(11) */
      /* _flgvnp Char(1) */
      /* _flgvlt Char(1) */
      /* cProgImp Char(15) */
      /* _snainumope Char(15) */
      /* _codcau Numeric(5, 0) */
      /* _datini Date */
      /* _datend Date */
      /* _codrap Char(25) */
      /* _intcon Char(16) */
      /* _mezpagam Char(1) // Mezzo Pagamento */
      /* _MsgAss Memo */
      /* ciidbase Char(10) */
      /* cidataini Date */
      /* cidatafine Date */
      /* cicodinter Char(12) */
      /* cinumprog Char(11) */
      /* citiporap Char(1) */
      /* w_errchk Numeric(1, 0) */
      /* w_tipodest Char(1) */
      /* filename Char(100) */
      /* _conta Numeric(10, 0) */
      /* _gMsgProc Memo // Messaggio */
      /* cProg Char(20) // Messaggio */
      /* _totale Numeric(10, 0) */
      /* _max Numeric(15, 0) */
      /* _min Numeric(15, 0) */
      /* _cicli Numeric(15, 0) */
      /* _contacilci Numeric(15, 0) */
      /* _bottom Numeric(15, 0) */
      /* _top Numeric(15, 0) */
      /* _movcod Numeric(10, 0) */
      /* dNumNew Numeric(10, 0) */
      /* dNumMod Numeric(10, 0) */
      /* dNumErr Numeric(10, 0) */
      /* oNumero Numeric(10, 0) */
      /* oNumErr Numeric(10, 0) */
      /* fNumero Numeric(10, 0) */
      /* sNumNew Numeric(10, 0) */
      /* sNumMod Numeric(10, 0) */
      /* sNumInv Numeric(10, 0) */
      /* sNumErr Numeric(10, 0) */
      /* rNumErr Numeric(10, 0) */
      /* uNumNew Numeric(10, 0) */
      /* uNumMod Numeric(10, 0) */
      /* nTotErr Numeric(10, 0) */
      /* _recOK Numeric(1, 0) */
      /* xData Char(8) */
      /* _datope Date */
      /* _datreg Date */
      /* _datimp Date */
      /* _datnas Date */
      /* _datemi Date */
      /* _datval Date */
      /* _txterr Memo */
      /* _codana Char(4) */
      /* _codsin Char(2) */
      /* _segno Char(1) */
      /* _tipope Char(2) */
      /* cOpeProg1 Char(10) */
      /* cOpeProg2 Char(11) */
      /* nProgImp Numeric(15, 0) */
      /* nIntest Numeric(10, 0) */
      /* _tiporap Char(1) */
      /* _locrap Char(1) */
      /* _codsog Char(16) */
      /* _gAzienda Char(10) // Azienda */
      /* _chiave Char(20) */
      /* _flgfile Char(1) */
      /* _oldazi Char(10) */
      /* _limoper Numeric(12, 2) */
      /* ProgErr Char(15) */
      /* _limvlt Numeric(10, 2) */
      /* _limvnp Numeric(10, 2) */
      /* _numope Char(15) */
      /* _oidb Char(1) */
      /* _idb Char(20) */
      /* _seekid Char(20) */
      /* Debug Msg 'Attivazione Import Dati' */
      if ( ! (CPLib.IsNull(m_Debug))) {
        m_Debug.log(CPLib.FormatMsg(m_Ctx,"Attivazione Import Dati"));
      }
      /* Utilities.SetUserCode(1) */
      Utilities.Make(m_Ctx,m_Caller).SetUserCode(1);
      /* _oldazi := Utilities.GetCompany() */
      _oldazi = Utilities.Make(m_Ctx,m_Caller).GetCompany();
      /* _chiave := '' */
      _chiave = "";
      /* _gMsgProc := 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + NL */
      _gMsgProc = "Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      // * --- Select from cpazi
      m_cServer = m_Ctx.GetServer("cpazi");
      m_cPhName = m_Ctx.GetPhName("cpazi");
      if (Cursor_cpazi!=null)
        Cursor_cpazi.Close();
      Cursor_cpazi = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("cpazi")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_cpazi.Eof())) {
        /* Utilities.SetCompany(LRTrim(cpazi->codazi)) */
        Utilities.Make(m_Ctx,m_Caller).SetCompany(CPLib.LRTrim(Cursor_cpazi.GetString("codazi")));
        /* _gAzienda := LRTrim(cpazi->codazi) // Azienda */
        _gAzienda = CPLib.LRTrim(Cursor_cpazi.GetString("codazi"));
        /* Legge dati intermediario per metteri su operazbo,fraziobo,rapopebo se mancanti */
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
          /* w_tipodest := intermbo->FLGTIPIMP */
          w_tipodest = Cursor_intermbo.GetString("FLGTIPIMP");
          /* _limoper := intermbo->IMPINTOPE */
          _limoper = CPLib.Round(Cursor_intermbo.GetDouble("IMPINTOPE"),2);
          /* _limvlt := intermbo->LIMITVLT */
          _limvlt = CPLib.Round(Cursor_intermbo.GetDouble("LIMITVLT"),2);
          /* _limvnp := intermbo->LIMITVNP */
          _limvnp = CPLib.Round(Cursor_intermbo.GetDouble("LIMITVNP"),2);
          Cursor_intermbo.Next();
        }
        m_cConnectivityError = Cursor_intermbo.ErrorMessage();
        Cursor_intermbo.Close();
        // * --- End Select
        /* Import Soggetti */
        /* _gMsgProc := '' */
        _gMsgProc = "";
        /* Cicla sul file della lista e lancia la pagina appropriata */
        /* _esito := 0 */
        _esito = CPLib.Round(0,0);
        /* _flgfile := 'N' */
        _flgfile = "N";
        /* nTotErr := 0 */
        nTotErr = CPLib.Round(0,0);
        /* dNumNew := 0 */
        dNumNew = CPLib.Round(0,0);
        /* dNumMod := 0 */
        dNumMod = CPLib.Round(0,0);
        /* dNumErr := 0 */
        dNumErr = CPLib.Round(0,0);
        /* sNumNew := 0 */
        sNumNew = CPLib.Round(0,0);
        /* sNumMod := 0 */
        sNumMod = CPLib.Round(0,0);
        /* sNumInv := 0 */
        sNumInv = CPLib.Round(0,0);
        /* sNumErr := 0 */
        sNumErr = CPLib.Round(0,0);
        /* rNumNew := 0 */
        rNumNew = CPLib.Round(0,0);
        /* rNumMod := 0 */
        rNumMod = CPLib.Round(0,0);
        /* rNumErr := 0 */
        rNumErr = CPLib.Round(0,0);
        /* oNumero := 0 */
        oNumero = CPLib.Round(0,0);
        /* oNumErr := 0 */
        oNumErr = CPLib.Round(0,0);
        /* uNumNew := 0 */
        uNumNew = CPLib.Round(0,0);
        /* uNumMod := 0 */
        uNumMod = CPLib.Round(0,0);
        /* Exec "Dipendenze" Page 2:Page_2 */
        Page_2();
        /* Exec "Soggetti" Page 3:Page_3 */
        Page_3();
        /* Exec "Rapporti" Page 4:Page_4 */
        Page_4();
        /* Exec "Operazioni / Frazionate" Page 5:Page_5 */
        Page_5();
        /* Exec "Utenti" Page 6:Page_6 */
        Page_6();
        Cursor_cpazi.Next();
      }
      m_cConnectivityError = Cursor_cpazi.ErrorMessage();
      Cursor_cpazi.Close();
      // * --- End Select
      /* Utilities.SetCompany(_oldazi) */
      Utilities.Make(m_Ctx,m_Caller).SetCompany(_oldazi);
      /* _gMsgProc := _gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + NL */
      _gMsgProc = _gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
    } finally {
      try {
        if (Cursor_cpazi!=null)
          Cursor_cpazi.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_qbe_cgo_anadip_totali=null;
    CPResultSet Cursor_cgo_anadip=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_cgo_telematico=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Import Dipendenze */
      /* _totale := 0 */
      _totale = CPLib.Round(0,0);
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      // * --- Select from qbe_cgo_anadip_totali
      if (Cursor_qbe_cgo_anadip_totali!=null)
        Cursor_qbe_cgo_anadip_totali.Close();
      Cursor_qbe_cgo_anadip_totali = new VQRHolder("qbe_cgo_anadip_totali",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_cgo_anadip_totali.Eof())) {
        /* _totale := qbe_cgo_anadip_totali->TOTDIP */
        _totale = CPLib.Round(Cursor_qbe_cgo_anadip_totali.GetDouble("TOTDIP"),0);
        Cursor_qbe_cgo_anadip_totali.Next();
      }
      m_cConnectivityError = Cursor_qbe_cgo_anadip_totali.ErrorMessage();
      Cursor_qbe_cgo_anadip_totali.Close();
      // * --- End Select
      /* If _totale > 0 */
      if (CPLib.gt(_totale,0)) {
        // * --- Select from cgo_anadip
        m_cServer = m_Ctx.GetServer("cgo_anadip");
        m_cPhName = m_Ctx.GetPhName("cgo_anadip");
        if (Cursor_cgo_anadip!=null)
          Cursor_cgo_anadip.Close();
        Cursor_cgo_anadip = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("cgo_anadip")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_cgo_anadip.Eof())) {
          // Begin Transaction
          m_Sql.RequireTransaction();
          double nTry05DB17B0status;
          nTry05DB17B0status = m_Sql.GetTransactionStatus();
          String cTry05DB17B0msg;
          cTry05DB17B0msg = m_Sql.TransactionErrorMessage();
          try {
            /* _txterr := '' */
            _txterr = "";
            /* _recOK := 0 */
            _recOK = CPLib.Round(0,0);
            /* If Empty(LRTrim(cgo_anadip->CODDIP)) */
            if (CPLib.Empty(CPLib.LRTrim(Cursor_cgo_anadip.GetString("CODDIP")))) {
              /* _txterr := _txterr + 'Manca il codice della dipendenza' + NL */
              _txterr = _txterr+"Manca il codice della dipendenza"+"\n";
              /* _recOK := 1 */
              _recOK = CPLib.Round(1,0);
            } // End If
            /* If Empty(LRTrim(cgo_anadip->CAB)) and Empty(LRTrim(cgo_anadip->DESCCIT)) */
            if (CPLib.Empty(CPLib.LRTrim(Cursor_cgo_anadip.GetString("CAB"))) && CPLib.Empty(CPLib.LRTrim(Cursor_cgo_anadip.GetString("DESCCIT")))) {
              /* _txterr := _txterr + 'Mancano il CAB o la città della dipendenza' + NL */
              _txterr = _txterr+"Mancano il CAB o la città della dipendenza"+"\n";
              /* _recOK := 1 */
              _recOK = CPLib.Round(1,0);
            } // End If
            /* If Empty(LRTrim(cgo_anadip->IDBASE)) */
            if (CPLib.Empty(CPLib.LRTrim(Cursor_cgo_anadip.GetString("IDBASE")))) {
              /* _txterr := _txterr + 'Manca il riferimento interno della dipendenza' + NL */
              _txterr = _txterr+"Manca il riferimento interno della dipendenza"+"\n";
              /* _recOK := 1 */
              _recOK = CPLib.Round(1,0);
            } // End If
            /* If _recOK=0 */
            if (CPLib.eqr(_recOK,0)) {
              /* xDIP := cgo_anadip->CODDIP */
              xDIP = Cursor_cgo_anadip.GetString("CODDIP");
              /* xDIPx := '' */
              xDIPx = "";
              /* xCodCab := cgo_anadip->CAB */
              xCodCab = Cursor_cgo_anadip.GetString("CAB");
              /* If Empty(LRTrim(xCodCab)) */
              if (CPLib.Empty(CPLib.LRTrim(xCodCab))) {
                /* xCitta := cgo_anadip->DESCCIT */
                xCitta = Cursor_cgo_anadip.GetString("DESCCIT");
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
                    Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_imp_dati_cgo_sched_tabs_multitry returns two or more records. This item should return only a record.");
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
                  Error l_oErrorFault = new Error("Read on anadip into routine arrt_imp_dati_cgo_sched_tabs_multitry returns two or more records. This item should return only a record.");
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
                m_cSql = m_cSql+GetFieldsName_07A54250(m_Ctx);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(xDIP,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_anadip.GetString("DESCRIZ"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_anadip.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_anadip.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(xCodCab,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_anadip.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_anadip.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_anadip.GetString("TELEFONO"),"?",0,0,m_cServer)+", ";
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
                  throw new RoutineException();
                }
                /* dNumNew := dNumNew + 1 */
                dNumNew = CPLib.Round(dNumNew+1,0);
              } else { // Else
                // * --- Write into anadip from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("anadip");
                m_cPhName = m_Ctx.GetPhName("anadip");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "Update "+m_cPhName+" set ";
                m_cSql = m_cSql+"DESCRIZ = "+CPLib.ToSQL(Cursor_cgo_anadip.GetString("DESCRIZ"),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_cgo_anadip.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_cgo_anadip.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"CAB = "+CPLib.ToSQL(xCodCab,"C",6,0,m_cServer)+", ";
                m_cSql = m_cSql+"IDBASE = "+CPLib.ToSQL(Cursor_cgo_anadip.GetString("IDBASE"),"C",10,0,m_cServer)+", ";
                m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_cgo_anadip.GetString("DOMICILIO"),"C",40,0,m_cServer)+", ";
                m_cSql = m_cSql+"TELEFONO = "+CPLib.ToSQL(Cursor_cgo_anadip.GetString("TELEFONO"),"C",15,0,m_cServer)+", ";
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
                  throw new RoutineException();
                }
                /* dNumMod := dNumMod + 1 */
                dNumMod = CPLib.Round(dNumMod+1,0);
              } // End If
            } else { // Else
              /* ProgErr := Utilities.GetAutonumber("PRGDIPERR\'"+LRTrim(_gAzienda)+"'","",15) */
              ProgErr = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGDIPERR\\'"+CPLib.LRTrim(_gAzienda)+"'","",15);
              // * --- Insert into cgo_anadip_err from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cgo_anadip_err");
              m_cPhName = m_Ctx.GetPhName("cgo_anadip_err");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"cgo_anadip_err")+" (";
              m_cSql = m_cSql+GetFieldsName_05D94200(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(ProgErr,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_anadip.GetString("CODDIP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_anadip.GetString("DESCRIZ"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_anadip.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_anadip.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_anadip.GetString("CAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_anadip.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_txterr,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("cgo_anadip_err")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_anadip_err",true);
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
              /* dNumErr := dNumErr + 1 */
              dNumErr = CPLib.Round(dNumErr+1,0);
              // * --- Select from cgo_telematico
              m_cServer = m_Ctx.GetServer("cgo_telematico");
              m_cPhName = m_Ctx.GetPhName("cgo_telematico");
              if (Cursor_cgo_telematico!=null)
                Cursor_cgo_telematico.Close();
              Cursor_cgo_telematico = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODDIPE="+CPLib.ToSQL(Cursor_cgo_anadip.GetString("CODDIP"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("cgo_telematico")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_cgo_telematico.Eof())) {
                // * --- Insert into cgo_telematico_err from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("cgo_telematico_err");
                m_cPhName = m_Ctx.GetPhName("cgo_telematico_err");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.InsertIntoStatement(m_Ctx,"cgo_telematico_err")+" (";
                m_cSql = m_cSql+GetFieldsName_05F5E700(m_Ctx);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("SNAINUMOPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("ENV"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("TOTLIRE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("CACODICE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDateTime("CADATAORA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CAIDBIGLIETTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("CSMF_COD"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("NUM_CONC"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("P_VEND"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("IPCOLLEG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDateTime("ORACOLLEG"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("DUCOLLEG"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("IBAN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("Operazione eliminata per scarto dipendena","?",0,0,m_cServer, m_oParameters)+", ";
                if (m_Ctx.IsSharedTemp("cgo_telematico_err")) {
                  m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                }
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_telematico_err",true);
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
                /* oNumErr := oNumErr + 1 */
                oNumErr = CPLib.Round(oNumErr+1,0);
                // * --- Delete from cgo_telematico
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("cgo_telematico");
                m_cPhName = m_Ctx.GetPhName("cgo_telematico");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "delete from "+m_cPhName;
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"SNAINUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_telematico.GetString("SNAINUMOPE"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_telematico.GetString("SNAINUMOPE"))+"";
                if (m_Ctx.IsSharedTemp("cgo_telematico")) {
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
                Cursor_cgo_telematico.Next();
              }
              m_cConnectivityError = Cursor_cgo_telematico.ErrorMessage();
              Cursor_cgo_telematico.Close();
              // * --- End Select
            } // End If
            // * --- Delete from cgo_anadip
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cgo_anadip");
            m_cPhName = m_Ctx.GetPhName("cgo_anadip");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = "delete from "+m_cPhName;
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"CODDIP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_anadip.GetString("CODDIP"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_anadip.GetString("CODDIP"))+"";
            if (m_Ctx.IsSharedTemp("cgo_anadip")) {
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
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
            // Commit
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
            m_Sql.CompleteTransaction();
          } catch(Exception l_exeption) {
            Stop.ReactToException(l_exeption);
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            /* _gMsgProc := "Rilevati errori nell'impotazione dei file! Ricreare il file segnalato e rieseguire l'import dei dati. La procedura annullera automaticamente l'importazione" + NL */
            _gMsgProc = "Rilevati errori nell'impotazione dei file! Ricreare il file segnalato e rieseguire l'import dei dati. La procedura annullera automaticamente l'importazione"+"\n";
            /* _gMsgProc := _gMsgProc + 'Errore SQL: ' + m_Sql.TransactionErrorMessage() + NL */
            _gMsgProc = _gMsgProc+"Errore SQL: "+m_Sql.TransactionErrorMessage()+"\n";
            // Rollback
            m_Sql.AbortTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            m_bError = true;
            m_Sql.CompleteTransaction();
            /* cProg := Utilities.GetAutonumber("PRGLOG\'"+LRTrim(_gAzienda)+"'",'',20) */
            cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGLOG\\'"+CPLib.LRTrim(_gAzienda)+"'","",20);
            // * --- Insert into log_app from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("log_app");
            m_cPhName = m_Ctx.GetPhName("log_app");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.InsertIntoStatement(m_Ctx,"log_app")+" (";
            m_cSql = m_cSql+GetFieldsName_07AFDE68(m_Ctx);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Import Dati","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_gMsgProc,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Scheduler","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("ERRORS","?",0,0,m_cServer)+", ";
            if (m_Ctx.IsSharedTemp("log_app")) {
              m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
            }
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"log_app",true);
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
          } finally {
            if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry05DB17B0status,0)) {
              m_Sql.SetTransactionStatus(nTry05DB17B0status,cTry05DB17B0msg);
            }
          }
          Cursor_cgo_anadip.Next();
        }
        m_cConnectivityError = Cursor_cgo_anadip.ErrorMessage();
        Cursor_cgo_anadip.Close();
        // * --- End Select
        /* _gMsgProc := 'Dipendenze Inserite: '+LRTrim(Str(dNumNew,10,0)) + ' - Dipendenze Aggiornate: '+LRTrim(Str(dNumMod,10,0)) + NL */
        _gMsgProc = "Dipendenze Inserite: "+CPLib.LRTrim(CPLib.Str(dNumNew,10,0))+" - Dipendenze Aggiornate: "+CPLib.LRTrim(CPLib.Str(dNumMod,10,0))+"\n";
        /* cProg := Utilities.GetAutonumber("PRGLOG\'"+LRTrim(_gAzienda)+"'",'',20) */
        cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGLOG\\'"+CPLib.LRTrim(_gAzienda)+"'","",20);
        // * --- Insert into log_app from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("log_app");
        m_cPhName = m_Ctx.GetPhName("log_app");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"log_app")+" (";
        m_cSql = m_cSql+GetFieldsName_062E0AE8(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Import Dati","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_gMsgProc,"?",0,0,m_cServer, m_oParameters)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("ANADIP","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Inseriti / Aggiornati "+CPLib.LRTrim(CPLib.Str(dNumNew+dNumMod,10,0)),"?",0,0,m_cServer)+", ";
        if (m_Ctx.IsSharedTemp("log_app")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"log_app",true);
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
        /* If oNumErr > 0 */
        if (CPLib.gt(oNumErr,0)) {
          /* _gMsgProc := 'Dipendenze Scartate: '+LRTrim(Str(dNumErr,10,0)) + NL */
          _gMsgProc = "Dipendenze Scartate: "+CPLib.LRTrim(CPLib.Str(dNumErr,10,0))+"\n";
          /* cProg := Utilities.GetAutonumber("PRGLOG\'"+LRTrim(_gAzienda)+"'",'',20) */
          cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGLOG\\'"+CPLib.LRTrim(_gAzienda)+"'","",20);
          // * --- Insert into log_app from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("log_app");
          m_cPhName = m_Ctx.GetPhName("log_app");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"log_app")+" (";
          m_cSql = m_cSql+GetFieldsName_05DA0338(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Import Dati","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_gMsgProc,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("ANADIP","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Scartati "+CPLib.LRTrim(CPLib.Str(dNumErr,10,0)),"?",0,0,m_cServer)+", ";
          if (m_Ctx.IsSharedTemp("log_app")) {
            m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
          }
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"log_app",true);
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
      } else { // Else
        /* _gMsgProc := "Nessuna Dipendenza Inserita, Aggiornata o Scartata" */
        _gMsgProc = "Nessuna Dipendenza Inserita, Aggiornata o Scartata";
        /* cProg := Utilities.GetAutonumber("PRGLOG\'"+LRTrim(_gAzienda)+"'",'',20) */
        cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGLOG\\'"+CPLib.LRTrim(_gAzienda)+"'","",20);
        // * --- Insert into log_app from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("log_app");
        m_cPhName = m_Ctx.GetPhName("log_app");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"log_app")+" (";
        m_cSql = m_cSql+GetFieldsName_04220AA0(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Import Dati","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_gMsgProc,"?",0,0,m_cServer, m_oParameters)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("ANADIP","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("NO RECORDS","?",0,0,m_cServer)+", ";
        if (m_Ctx.IsSharedTemp("log_app")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"log_app",true);
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
    } finally {
      try {
        if (Cursor_qbe_cgo_anadip_totali!=null)
          Cursor_qbe_cgo_anadip_totali.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_cgo_anadip!=null)
          Cursor_cgo_anadip.Close();
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
        if (Cursor_cgo_telematico!=null)
          Cursor_cgo_telematico.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_3() throws Exception {
    CPResultSet Cursor_qbe_cgo_soggetti_totali=null;
    CPResultSet Cursor_cgo_soggetti=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_cgo_rapporti=null;
    CPResultSet Cursor_cgo_telematico=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_xntestbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Soggetti */
      /* _totale := 0 */
      _totale = CPLib.Round(0,0);
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      // * --- Select from qbe_cgo_soggetti_totali
      if (Cursor_qbe_cgo_soggetti_totali!=null)
        Cursor_qbe_cgo_soggetti_totali.Close();
      Cursor_qbe_cgo_soggetti_totali = new VQRHolder("qbe_cgo_soggetti_totali",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_cgo_soggetti_totali.Eof())) {
        /* _totale := qbe_cgo_soggetti_totali->TOTSOG */
        _totale = CPLib.Round(Cursor_qbe_cgo_soggetti_totali.GetDouble("TOTSOG"),0);
        Cursor_qbe_cgo_soggetti_totali.Next();
      }
      m_cConnectivityError = Cursor_qbe_cgo_soggetti_totali.ErrorMessage();
      Cursor_qbe_cgo_soggetti_totali.Close();
      // * --- End Select
      /* If _totale > 0 */
      if (CPLib.gt(_totale,0)) {
        // * --- Select from cgo_soggetti
        m_cServer = m_Ctx.GetServer("cgo_soggetti");
        m_cPhName = m_Ctx.GetPhName("cgo_soggetti");
        if (Cursor_cgo_soggetti!=null)
          Cursor_cgo_soggetti.Close();
        Cursor_cgo_soggetti = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("cgo_soggetti")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_cgo_soggetti.Eof())) {
          // Begin Transaction
          m_Sql.RequireTransaction();
          double nTry06119728status;
          nTry06119728status = m_Sql.GetTransactionStatus();
          String cTry06119728msg;
          cTry06119728msg = m_Sql.TransactionErrorMessage();
          try {
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
            /* _txterr := '' */
            _txterr = "";
            /* _recOK := 0 */
            _recOK = CPLib.Round(0,0);
            /* conta := conta + 1 */
            conta = CPLib.Round(conta+1,0);
            /* numriga := numriga + 1 */
            numriga = CPLib.Round(numriga+1,0);
            /* _codsog := cgo_soggetti->CONNES */
            _codsog = Cursor_cgo_soggetti.GetString("CONNES");
            /* Exec "Controllo Soggetti" Page 7:Page_7 */
            Page_7();
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
              throw new RoutineException();
            }
            /* If _recOK=0 */
            if (CPLib.eqr(_recOK,0)) {
              /* cSetSin := '' */
              cSetSin = "";
              /* _datnas := cgo_soggetti->DATANASC */
              _datnas = Cursor_cgo_soggetti.GetDate("DATANASC");
              /* _datemi := cgo_soggetti->DATARILASC */
              _datemi = Cursor_cgo_soggetti.GetDate("DATARILASC");
              /* _datval := cgo_soggetti->DATAVALI */
              _datval = Cursor_cgo_soggetti.GetDate("DATAVALI");
              /* xRagSoc := LRTrim(cgo_soggetti->COGNOME)+" "+ LRTrim(cgo_soggetti->NOME) */
              xRagSoc = CPLib.LRTrim(Cursor_cgo_soggetti.GetString("COGNOME"))+" "+CPLib.LRTrim(Cursor_cgo_soggetti.GetString("NOME"));
              /* cCli1 := cgo_soggetti->CONNES */
              cCli1 = Cursor_cgo_soggetti.GetString("CONNES");
              /* xCF := cgo_soggetti->CONNES */
              xCF = Cursor_cgo_soggetti.GetString("CONNES");
              /* xCFE := cgo_soggetti->CFESTERO */
              xCFE = CPLib.Round(Cursor_cgo_soggetti.GetDouble("CFESTERO"),0);
              /* If Empty(LRTrim(xCodCab)) */
              if (CPLib.Empty(CPLib.LRTrim(xCodCab))) {
                /* xCitta := cgo_soggetti->DESCCIT */
                xCitta = Cursor_cgo_soggetti.GetString("DESCCIT");
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
                    Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_imp_dati_cgo_sched_tabs_multitry returns two or more records. This item should return only a record.");
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
              /* xAnnNas := Substr(DateToChar(cgo_soggetti->DATANASC),1,4) // Anno Di Nascita */
              xAnnNas = CPLib.Substr(CPLib.DateToChar(Cursor_cgo_soggetti.GetDate("DATANASC")),1,4);
              /* xMesNas := Substr(DateToChar(cgo_soggetti->DATANASC),5,2) // Mese Di Nascita */
              xMesNas = CPLib.Substr(CPLib.DateToChar(Cursor_cgo_soggetti.GetDate("DATANASC")),5,2);
              /* xDayNas := Substr(DateToChar(cgo_soggetti->DATANASC),7,2) // Giorno Di Nascita */
              xDayNas = CPLib.Substr(CPLib.DateToChar(Cursor_cgo_soggetti.GetDate("DATANASC")),7,2);
              /* cDNAS := _datnas */
              cDNAS = _datnas;
              /* xSesso := iif(cgo_soggetti->SESSO='M','1',iif(cgo_soggetti->SESSO='F','2','')) */
              xSesso = (CPLib.eqr(Cursor_cgo_soggetti.GetString("SESSO"),"M")?"1":(CPLib.eqr(Cursor_cgo_soggetti.GetString("SESSO"),"F")?"2":""));
              /* If not(Empty(LRTrim(cgo_soggetti->NASPROV))) */
              if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_cgo_soggetti.GetString("NASPROV"))))) {
                /* If LRTrim(cgo_soggetti->NASPROV)='EE' */
                if (CPLib.eqr(CPLib.LRTrim(Cursor_cgo_soggetti.GetString("NASPROV")),"EE")) {
                  /* cSNAS := '' */
                  cSNAS = "";
                  // * --- Read from tbstati
                  m_cServer = m_Ctx.GetServer("tbstati");
                  m_cPhName = m_Ctx.GetPhName("tbstati");
                  m_cSql = "";
                  m_cSql = m_cSql+"DESCRI="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_soggetti.GetString("NASSTATO"),"C",40,0,m_cServer),m_cServer,Cursor_cgo_soggetti.GetString("NASSTATO"));
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
                      Error l_oErrorFault = new Error("Read on tbstati into routine arrt_imp_dati_cgo_sched_tabs_multitry returns two or more records. This item should return only a record.");
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
                    /* cSNAS := cgo_soggetti->NASCOMUN */
                    cSNAS = Cursor_cgo_soggetti.GetString("NASCOMUN");
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
                  m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_soggetti.GetString("NASCOMUN"),"C",40,0,m_cServer),m_cServer,Cursor_cgo_soggetti.GetString("NASCOMUN"));
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
                      Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_imp_dati_cgo_sched_tabs_multitry returns two or more records. This item should return only a record.");
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
                    /* cCNAS := cgo_soggetti->NASCOMUN */
                    cCNAS = Cursor_cgo_soggetti.GetString("NASCOMUN");
                  } // End If
                  /* cSNAS := '' */
                  cSNAS = "";
                } // End If
              } else { // Else
                /* cSNAS := cgo_soggetti->NASSTATO */
                cSNAS = Cursor_cgo_soggetti.GetString("NASSTATO");
                /* cCNAS := cgo_soggetti->NASCOMUN */
                cCNAS = Cursor_cgo_soggetti.GetString("NASCOMUN");
                /* cPNAS := '' */
                cPNAS = "";
              } // End If
              /* xRiga1 := LibreriaMit.SpacePad(xCF,16) */
              xRiga1 = LibreriaMit.SpacePad(xCF,16);
              /* xRiga1 := xRiga1 + LibreriaMit.SpacePad(xRagSoc,70) */
              xRiga1 = xRiga1+LibreriaMit.SpacePad(xRagSoc,70);
              /* xRiga1 := xRiga1 + LibreriaMit.SpacePad(cgo_soggetti->DOMICILIO,35) */
              xRiga1 = xRiga1+LibreriaMit.SpacePad(Cursor_cgo_soggetti.GetString("DOMICILIO"),35);
              /* xRiga1 := xRiga1 + LibreriaMit.SpacePad(cgo_soggetti->DESCCIT,30) */
              xRiga1 = xRiga1+LibreriaMit.SpacePad(Cursor_cgo_soggetti.GetString("DESCCIT"),30);
              /* xRiga1 := xRiga1 + LibreriaMit.SpacePad(cgo_soggetti->PROVINCIA,2) */
              xRiga1 = xRiga1+LibreriaMit.SpacePad(Cursor_cgo_soggetti.GetString("PROVINCIA"),2);
              /* xRiga1 := xRiga1 + LibreriaMit.SpacePad(LRTrim(cgo_soggetti->CAP),5) */
              xRiga1 = xRiga1+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_cgo_soggetti.GetString("CAP")),5);
              /* xRiga1 := xRiga1 + LibreriaMit.SpacePad(cgo_soggetti->PAESE,3) */
              xRiga1 = xRiga1+LibreriaMit.SpacePad(Cursor_cgo_soggetti.GetString("PAESE"),3);
              /* xRiga1 := xRiga1 + LibreriaMit.SpacePad('600',3) */
              xRiga1 = xRiga1+LibreriaMit.SpacePad("600",3);
              /* xRiga1 := xRiga1 + LibreriaMit.SpacePad('   ',3) */
              xRiga1 = xRiga1+LibreriaMit.SpacePad("   ",3);
              /* xRiga1 := xRiga1 + LibreriaMit.SpacePad('600',3) */
              xRiga1 = xRiga1+LibreriaMit.SpacePad("600",3);
              /* xRiga1 := xRiga1 + LibreriaMit.SpacePad(Left(cCNAS,30),30) */
              xRiga1 = xRiga1+LibreriaMit.SpacePad(CPLib.Left(cCNAS,30),30);
              /* xRiga1 := xRiga1 + LibreriaMit.SpacePad(cPNAS,2) */
              xRiga1 = xRiga1+LibreriaMit.SpacePad(cPNAS,2);
              /* xRiga1 := xRiga1 + LibreriaMit.SpacePad(Left(cSNAS,30),30) */
              xRiga1 = xRiga1+LibreriaMit.SpacePad(CPLib.Left(cSNAS,30),30);
              /* xRiga1 := xRiga1 + iif(DateToChar(_datnas) <> '01000101',LibreriaMit.SpacePad(DateToChar(_datnas),8),Space(8)) */
              xRiga1 = xRiga1+(CPLib.ne(CPLib.DateToChar(_datnas),"01000101")?LibreriaMit.SpacePad(CPLib.DateToChar(_datnas),8):CPLib.Space(8));
              /* xRiga1 := xRiga1 +LibreriaMit.SpacePad(cgo_soggetti->TIPODOC,2) */
              xRiga1 = xRiga1+LibreriaMit.SpacePad(Cursor_cgo_soggetti.GetString("TIPODOC"),2);
              /* xRiga1 := xRiga1 +LibreriaMit.SpacePad(cgo_soggetti->NUMDOCUM,15) */
              xRiga1 = xRiga1+LibreriaMit.SpacePad(Cursor_cgo_soggetti.GetString("NUMDOCUM"),15);
              /* xRiga1 := xRiga1 + iif(DateToChar(_datemi) <> '01000101',LibreriaMit.SpacePad(DateToChar(_datemi),8),Space(8)) */
              xRiga1 = xRiga1+(CPLib.ne(CPLib.DateToChar(_datemi),"01000101")?LibreriaMit.SpacePad(CPLib.DateToChar(_datemi),8):CPLib.Space(8));
              /* xRiga1 := xRiga1 +LibreriaMit.SpacePad(cgo_soggetti->AUTRILASC,30) */
              xRiga1 = xRiga1+LibreriaMit.SpacePad(Cursor_cgo_soggetti.GetString("AUTRILASC"),30);
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
                /* xRiga2 := xRiga2 +LibreriaMit.SpacePad(personbo->AUTRILASC,30) */
                xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("AUTRILASC"),30);
                /* xConnes := personbo->CONNES */
                xConnes = Cursor_personbo.GetString("CONNES");
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
              /* nProgImp := 0 */
              nProgImp = CPLib.Round(0,0);
              /* cProgSto := '' */
              cProgSto = "";
              /* If not(Empty(xConnes)) */
              if ( ! (CPLib.Empty(xConnes))) {
                /* If Upper(LRTrim(xRiga1)) <> Upper(LRTrim(xRiga2)) */
                if (CPLib.ne(CPLib.Upper(CPLib.LRTrim(xRiga1)),CPLib.Upper(CPLib.LRTrim(xRiga2)))) {
                  /* _allcn := 0 */
                  _allcn = CPLib.Round(0,0);
                  /* xNome := cgo_soggetti->NOME */
                  xNome = Cursor_cgo_soggetti.GetString("NOME");
                  /* xCognome := cgo_soggetti->COGNOME */
                  xCognome = Cursor_cgo_soggetti.GetString("COGNOME");
                  /* cProgSto := Utilities.GetAutonumber("PSTOPERS\'"+LRTrim(_gAzienda)+"'","",15) */
                  cProgSto = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PSTOPERS\\'"+CPLib.LRTrim(_gAzienda)+"'","",15);
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
                    m_cSql = m_cSql+GetFieldsName_05D0CDB0(m_Ctx);
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
                      m_nUpdatedRows = 0;
                    }
                    m_Sql.CompleteTransaction();
                    m_cLastMsgError = m_Sql.TransactionErrorMessage();
                    if (CPLib.lt(m_nUpdatedRows,1)) {
                      // No rows inserted
                      /* _gMsgProc := _gMsgProc +"Rilevati errori nel file per il soggetto: "+LRTrim(xRagSoc)+" con codice: "+LRTrim(cgo_soggetti->CONNES)+". Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                      _gMsgProc = _gMsgProc+"Rilevati errori nel file per il soggetto: "+CPLib.LRTrim(xRagSoc)+" con codice: "+CPLib.LRTrim(Cursor_cgo_soggetti.GetString("CONNES"))+". Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                      /* _esito := 1 */
                      _esito = CPLib.Round(1,0);
                      // Exit Loop
                      if (true) {
                        break;
                      }
                    } else if (CPLib.ne(m_cLastMsgError,"")) {
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
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = "Update "+m_cPhName+" set ";
                  m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(xCodCab,"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.Left(xRagSoc,70),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(CPLib.Left(Cursor_cgo_soggetti.GetString("DOMICILIO"),35),"C",35,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_cgo_soggetti.GetString("CONNES"),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(cDNAS,"D",8,0)+", ";
                  m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(CPLib.Left(cCNAS,30),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL("600","C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL("","C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL("600","C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_cgo_soggetti.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(CPLib.Left(Cursor_cgo_soggetti.GetString("NUMDOCUM"),15),"C",15,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(_datemi,"D",8,0)+", ";
                  m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_cgo_soggetti.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.Left(Cursor_cgo_soggetti.GetString("DESCCIT"),30),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_cgo_soggetti.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_cgo_soggetti.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_cgo_soggetti.GetString("CAP"),"C",9,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(xSesso,"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATAVALI = "+CPLib.ToSQL(_datval,"D",8,0)+", ";
                  m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(xCognome,"C",26,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(xNome,"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(cPNAS,"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(xCFE,"N",1,0)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(CPLib.Left(cSNAS,30),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PEP = "+CPLib.ToSQL((CPLib.Empty(Cursor_cgo_soggetti.GetString("PEP"))?"N":Cursor_cgo_soggetti.GetString("PEP")),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPOPERS = "+CPLib.ToSQL("P","C",1,0,m_cServer)+", ";
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
                    /* _gMsgProc := _gMsgProc +"Rilevati errori nel file per il soggetto: "+LRTrim(xRagSoc)+" con codice: "+LRTrim(cgo_soggetti->CONNES)+". Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                    _gMsgProc = _gMsgProc+"Rilevati errori nel file per il soggetto: "+CPLib.LRTrim(xRagSoc)+" con codice: "+CPLib.LRTrim(Cursor_cgo_soggetti.GetString("CONNES"))+". Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                    /* _esito := 1 */
                    _esito = CPLib.Round(1,0);
                    // Exit Loop
                    if (true) {
                      break;
                    }
                  } else if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                    m_cLastMsgError = "Errore in aggiornamento ARCHPERS";
                    throw new RoutineException();
                  }
                  /* sNumMod := sNumMod + 1 */
                  sNumMod = CPLib.Round(sNumMod+1,0);
                } else { // Else
                  /* sNumInv := sNumInv + 1 // Contatore record invariati */
                  sNumInv = CPLib.Round(sNumInv+1,0);
                } // End If
              } else { // Else
                /* xNome := cgo_soggetti->NOME */
                xNome = Cursor_cgo_soggetti.GetString("NOME");
                /* xCognome := cgo_soggetti->COGNOME */
                xCognome = Cursor_cgo_soggetti.GetString("COGNOME");
                /* nProgImp := Utilities.GetAutonumber("PRGIMPOCLI\'"+LRTrim(_gAzienda)+"'",0,15) */
                nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOCLI\\'"+CPLib.LRTrim(_gAzienda)+"'",0,15),0);
                // * --- Insert into personbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.InsertIntoStatement(m_Ctx,"personbo")+" (";
                m_cSql = m_cSql+GetFieldsName_062CEB78(m_Ctx);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_cgo_soggetti.GetString("AUTRILASC"),30),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_cgo_soggetti.GetString("CAP"),9),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(xCFE,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(xCodCab,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(xCF,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(xCognome,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cCli1,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cDNAS,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_datemi,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_datval,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_cgo_soggetti.GetString("DESCCIT"),30),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_cgo_soggetti.GetString("DOMICILIO"),35),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(cCNAS,30),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(cSNAS,30),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(xNome,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_cgo_soggetti.GetString("NUMDOCUM"),15),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_cgo_soggetti.GetString("PAESE"),3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_cgo_soggetti.GetString("PEP"))?"N":Cursor_cgo_soggetti.GetString("PEP")),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_cgo_soggetti.GetString("PROVINCIA"),2),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(xRagSoc,70),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(xSesso,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("600","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("600","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cPNAS,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_cgo_soggetti.GetString("TIPODOC"),2),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("P","?",0,0,m_cServer)+", ";
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
                  /* _gMsgProc := _gMsgProc +"Rilevati errori nel file per il soggetto: "+LRTrim(xRagSoc)+" con codice: "+LRTrim(cgo_soggetti->CONNES)+". Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                  _gMsgProc = _gMsgProc+"Rilevati errori nel file per il soggetto: "+CPLib.LRTrim(xRagSoc)+" con codice: "+CPLib.LRTrim(Cursor_cgo_soggetti.GetString("CONNES"))+". Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                  /* _esito := 1 */
                  _esito = CPLib.Round(1,0);
                  // Exit Loop
                  if (true) {
                    break;
                  }
                } else if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  m_cLastMsgError = "Errore in inserimento ARCHPERS";
                  throw new RoutineException();
                }
                /* sNumNew := sNumNew + 1 */
                sNumNew = CPLib.Round(sNumNew+1,0);
              } // End If
            } else { // Else
              /* ProgErr := Utilities.GetAutonumber("PRGSOGERR\'"+LRTrim(_gAzienda)+"'","",15) */
              ProgErr = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGSOGERR\\'"+CPLib.LRTrim(_gAzienda)+"'","",15);
              // * --- Insert into cgo_soggetti_err from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cgo_soggetti_err");
              m_cPhName = m_Ctx.GetPhName("cgo_soggetti_err");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"cgo_soggetti_err")+" (";
              m_cSql = m_cSql+GetFieldsName_05DED380(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(ProgErr,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_soggetti.GetString("CONNES"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_soggetti.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_soggetti.GetString("NOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_soggetti.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_soggetti.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_soggetti.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_soggetti.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_soggetti.GetString("CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_soggetti.GetDate("DATANASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_soggetti.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_soggetti.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_soggetti.GetString("NASPROV"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_soggetti.GetString("SESSO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_soggetti.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_soggetti.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_soggetti.GetDate("DATARILASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_soggetti.GetDate("DATAVALI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_soggetti.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_soggetti.GetDouble("CFESTERO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_soggetti.GetString("PEP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_txterr,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("cgo_soggetti_err")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_soggetti_err",true);
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
              /* sNumErr := sNumErr + 1 */
              sNumErr = CPLib.Round(sNumErr+1,0);
              // * --- Select from cgo_rapporti
              m_cServer = m_Ctx.GetServer("cgo_rapporti");
              m_cPhName = m_Ctx.GetPhName("cgo_rapporti");
              if (Cursor_cgo_rapporti!=null)
                Cursor_cgo_rapporti.Close();
              Cursor_cgo_rapporti = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTEST="+CPLib.ToSQL(Cursor_cgo_soggetti.GetString("CONNES"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("cgo_rapporti")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_cgo_rapporti.Eof())) {
                /* ProgErr := Utilities.GetAutonumber("PRGDIPERR\'"+LRTrim(_gAzienda)+"'","",15) */
                ProgErr = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGDIPERR\\'"+CPLib.LRTrim(_gAzienda)+"'","",15);
                // * --- Insert into cgo_rapporti_err from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("cgo_rapporti_err");
                m_cPhName = m_Ctx.GetPhName("cgo_rapporti_err");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.InsertIntoStatement(m_Ctx,"cgo_rapporti_err")+" (";
                m_cSql = m_cSql+GetFieldsName_0643B980(m_Ctx);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(ProgErr,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetString("DESCRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetString("TIPOMOV"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetDate("DATAOPE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetString("CODINTEST"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("Rapporto scartato per errori su intestatario","?",0,0,m_cServer, m_oParameters)+", ";
                if (m_Ctx.IsSharedTemp("cgo_rapporti_err")) {
                  m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                }
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_rapporti_err",true);
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
                /* rNumErr := rNumErr + 1 */
                rNumErr = CPLib.Round(rNumErr+1,0);
                // * --- Select from cgo_telematico
                m_cServer = m_Ctx.GetServer("cgo_telematico");
                m_cPhName = m_Ctx.GetPhName("cgo_telematico");
                if (Cursor_cgo_telematico!=null)
                  Cursor_cgo_telematico.Close();
                Cursor_cgo_telematico = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_cgo_rapporti.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("cgo_telematico")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_cgo_telematico.Eof())) {
                  // * --- Insert into cgo_telematico_err from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("cgo_telematico_err");
                  m_cPhName = m_Ctx.GetPhName("cgo_telematico_err");
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.InsertIntoStatement(m_Ctx,"cgo_telematico_err")+" (";
                  m_cSql = m_cSql+GetFieldsName_062EDB98(m_Ctx);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("SNAINUMOPE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("ENV"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("TOTLIRE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("CACODICE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDateTime("CADATAORA"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CAIDBIGLIETTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("CSMF_COD"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("NUM_CONC"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("P_VEND"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("IPCOLLEG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDateTime("ORACOLLEG"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("DUCOLLEG"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("IBAN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("Operazione eliminata per errori su intestatario","?",0,0,m_cServer, m_oParameters)+", ";
                  if (m_Ctx.IsSharedTemp("cgo_telematico_err")) {
                    m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                  }
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_telematico_err",true);
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
                  /* oNumErr := oNumErr + 1 */
                  oNumErr = CPLib.Round(oNumErr+1,0);
                  // * --- Delete from cgo_telematico
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("cgo_telematico");
                  m_cPhName = m_Ctx.GetPhName("cgo_telematico");
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = "delete from "+m_cPhName;
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"SNAINUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_telematico.GetString("SNAINUMOPE"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_telematico.GetString("SNAINUMOPE"))+"";
                  if (m_Ctx.IsSharedTemp("cgo_telematico")) {
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
                  Cursor_cgo_telematico.Next();
                }
                m_cConnectivityError = Cursor_cgo_telematico.ErrorMessage();
                Cursor_cgo_telematico.Close();
                // * --- End Select
                // * --- Delete from cgo_rapporti
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("cgo_rapporti");
                m_cPhName = m_Ctx.GetPhName("cgo_rapporti");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "delete from "+m_cPhName;
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_rapporti.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_rapporti.GetString("RAPPORTO"))+"";
                if (m_Ctx.IsSharedTemp("cgo_rapporti")) {
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
                Cursor_cgo_rapporti.Next();
              }
              m_cConnectivityError = Cursor_cgo_rapporti.ErrorMessage();
              Cursor_cgo_rapporti.Close();
              // * --- End Select
              // * --- Select from intestbo
              m_cServer = m_Ctx.GetServer("intestbo");
              m_cPhName = m_Ctx.GetPhName("intestbo");
              if (Cursor_intestbo!=null)
                Cursor_intestbo.Close();
              Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPLib.ToSQL(Cursor_cgo_soggetti.GetString("CONNES"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_intestbo.Eof())) {
                // * --- Select from cgo_telematico
                m_cServer = m_Ctx.GetServer("cgo_telematico");
                m_cPhName = m_Ctx.GetPhName("cgo_telematico");
                if (Cursor_cgo_telematico!=null)
                  Cursor_cgo_telematico.Close();
                Cursor_cgo_telematico = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_intestbo.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("cgo_telematico")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_cgo_telematico.Eof())) {
                  // * --- Insert into cgo_telematico_err from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("cgo_telematico_err");
                  m_cPhName = m_Ctx.GetPhName("cgo_telematico_err");
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.InsertIntoStatement(m_Ctx,"cgo_telematico_err")+" (";
                  m_cSql = m_cSql+GetFieldsName_05E70F00(m_Ctx);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("SNAINUMOPE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("ENV"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("TOTLIRE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("CACODICE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDateTime("CADATAORA"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CAIDBIGLIETTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("CSMF_COD"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("NUM_CONC"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("P_VEND"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("IPCOLLEG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDateTime("ORACOLLEG"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("DUCOLLEG"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("IBAN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("Operazione eliminata per errori su intestatario","?",0,0,m_cServer, m_oParameters)+", ";
                  if (m_Ctx.IsSharedTemp("cgo_telematico_err")) {
                    m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                  }
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_telematico_err",true);
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
                  /* oNumErr := oNumErr + 1 */
                  oNumErr = CPLib.Round(oNumErr+1,0);
                  // * --- Delete from cgo_telematico
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("cgo_telematico");
                  m_cPhName = m_Ctx.GetPhName("cgo_telematico");
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = "delete from "+m_cPhName;
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"SNAINUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_telematico.GetString("SNAINUMOPE"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_telematico.GetString("SNAINUMOPE"))+"";
                  if (m_Ctx.IsSharedTemp("cgo_telematico")) {
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
                  Cursor_cgo_telematico.Next();
                }
                m_cConnectivityError = Cursor_cgo_telematico.ErrorMessage();
                Cursor_cgo_telematico.Close();
                // * --- End Select
                Cursor_intestbo.Next();
              }
              m_cConnectivityError = Cursor_intestbo.ErrorMessage();
              Cursor_intestbo.Close();
              // * --- End Select
              // * --- Select from xntestbo
              m_cServer = m_Ctx.GetServer("xntestbo");
              m_cPhName = m_Ctx.GetPhName("xntestbo");
              if (Cursor_xntestbo!=null)
                Cursor_xntestbo.Close();
              Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPLib.ToSQL(Cursor_cgo_soggetti.GetString("CONNES"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_xntestbo.Eof())) {
                // * --- Select from cgo_telematico
                m_cServer = m_Ctx.GetServer("cgo_telematico");
                m_cPhName = m_Ctx.GetPhName("cgo_telematico");
                if (Cursor_cgo_telematico!=null)
                  Cursor_cgo_telematico.Close();
                Cursor_cgo_telematico = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_xntestbo.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("cgo_telematico")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_cgo_telematico.Eof())) {
                  // * --- Insert into cgo_telematico_err from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("cgo_telematico_err");
                  m_cPhName = m_Ctx.GetPhName("cgo_telematico_err");
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.InsertIntoStatement(m_Ctx,"cgo_telematico_err")+" (";
                  m_cSql = m_cSql+GetFieldsName_06117F88(m_Ctx);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("SNAINUMOPE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("ENV"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("TOTLIRE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("CACODICE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDateTime("CADATAORA"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CAIDBIGLIETTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("CSMF_COD"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("NUM_CONC"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("P_VEND"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("IPCOLLEG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDateTime("ORACOLLEG"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("DUCOLLEG"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("IBAN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("Operazione eliminata per errori su intestatario","?",0,0,m_cServer, m_oParameters)+", ";
                  if (m_Ctx.IsSharedTemp("cgo_telematico_err")) {
                    m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                  }
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_telematico_err",true);
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
                  /* oNumErr := oNumErr + 1 */
                  oNumErr = CPLib.Round(oNumErr+1,0);
                  // * --- Delete from cgo_telematico
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("cgo_telematico");
                  m_cPhName = m_Ctx.GetPhName("cgo_telematico");
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = "delete from "+m_cPhName;
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"SNAINUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_telematico.GetString("SNAINUMOPE"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_telematico.GetString("SNAINUMOPE"))+"";
                  if (m_Ctx.IsSharedTemp("cgo_telematico")) {
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
                  Cursor_cgo_telematico.Next();
                }
                m_cConnectivityError = Cursor_cgo_telematico.ErrorMessage();
                Cursor_cgo_telematico.Close();
                // * --- End Select
                Cursor_xntestbo.Next();
              }
              m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
              Cursor_xntestbo.Close();
              // * --- End Select
            } // End If
            // * --- Delete from cgo_soggetti
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cgo_soggetti");
            m_cPhName = m_Ctx.GetPhName("cgo_soggetti");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = "delete from "+m_cPhName;
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_soggetti.GetString("CONNES"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_soggetti.GetString("CONNES"))+"";
            if (m_Ctx.IsSharedTemp("cgo_soggetti")) {
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
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
            // Commit
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
            m_Sql.CompleteTransaction();
          } catch(Exception l_exeption) {
            Stop.ReactToException(l_exeption);
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            /* _gMsgProc := "Rilevati errori nell'impotazione dei file! Ricreare il file segnalato e rieseguire l'import dei dati. La procedura annullera automaticamente l'importazione" + NL */
            _gMsgProc = "Rilevati errori nell'impotazione dei file! Ricreare il file segnalato e rieseguire l'import dei dati. La procedura annullera automaticamente l'importazione"+"\n";
            /* _gMsgProc := _gMsgProc + 'Errore SQL: ' + m_Sql.TransactionErrorMessage() + NL */
            _gMsgProc = _gMsgProc+"Errore SQL: "+m_Sql.TransactionErrorMessage()+"\n";
            // Rollback
            m_Sql.AbortTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            m_bError = true;
            m_Sql.CompleteTransaction();
            /* cProg := Utilities.GetAutonumber("PRGLOG\'"+LRTrim(_gAzienda)+"'",'',20) */
            cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGLOG\\'"+CPLib.LRTrim(_gAzienda)+"'","",20);
            // * --- Insert into log_app from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("log_app");
            m_cPhName = m_Ctx.GetPhName("log_app");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.InsertIntoStatement(m_Ctx,"log_app")+" (";
            m_cSql = m_cSql+GetFieldsName_07C91D50(m_Ctx);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Import Dati","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_gMsgProc,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Scheduler","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("ERRORS","?",0,0,m_cServer)+", ";
            if (m_Ctx.IsSharedTemp("log_app")) {
              m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
            }
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"log_app",true);
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
          } finally {
            if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry06119728status,0)) {
              m_Sql.SetTransactionStatus(nTry06119728status,cTry06119728msg);
            }
          }
          Cursor_cgo_soggetti.Next();
        }
        m_cConnectivityError = Cursor_cgo_soggetti.ErrorMessage();
        Cursor_cgo_soggetti.Close();
        // * --- End Select
        /* _gMsgProc := 'Soggetti Inseriti: '+LRTrim(Str(sNumNew,10,0)) + ' - Soggetti Aggiornati: '+LRTrim(Str(sNumMod,10,0)) + NL */
        _gMsgProc = "Soggetti Inseriti: "+CPLib.LRTrim(CPLib.Str(sNumNew,10,0))+" - Soggetti Aggiornati: "+CPLib.LRTrim(CPLib.Str(sNumMod,10,0))+"\n";
        /* cProg := Utilities.GetAutonumber("PRGLOG\'"+LRTrim(_gAzienda)+"'",'',20) */
        cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGLOG\\'"+CPLib.LRTrim(_gAzienda)+"'","",20);
        // * --- Insert into log_app from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("log_app");
        m_cPhName = m_Ctx.GetPhName("log_app");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"log_app")+" (";
        m_cSql = m_cSql+GetFieldsName_05B34760(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Import Dati","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_gMsgProc,"?",0,0,m_cServer, m_oParameters)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("PERSONBO","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Inseriti / Aggiornati "+CPLib.LRTrim(CPLib.Str(sNumNew+sNumMod,10,0)),"?",0,0,m_cServer)+", ";
        if (m_Ctx.IsSharedTemp("log_app")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"log_app",true);
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
        /* If sNumErr > 0 */
        if (CPLib.gt(sNumErr,0)) {
          /* _gMsgProc := 'Soggetti Scartati: '+LRTrim(Str(sNumErr,10,0)) + NL */
          _gMsgProc = "Soggetti Scartati: "+CPLib.LRTrim(CPLib.Str(sNumErr,10,0))+"\n";
          /* cProg := Utilities.GetAutonumber("PRGLOG\'"+LRTrim(_gAzienda)+"'",'',20) */
          cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGLOG\\'"+CPLib.LRTrim(_gAzienda)+"'","",20);
          // * --- Insert into log_app from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("log_app");
          m_cPhName = m_Ctx.GetPhName("log_app");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"log_app")+" (";
          m_cSql = m_cSql+GetFieldsName_05FA9E88(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Import Dati","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_gMsgProc,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("PERSONBO","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Scartati "+CPLib.LRTrim(CPLib.Str(sNumErr,10,0)),"?",0,0,m_cServer)+", ";
          if (m_Ctx.IsSharedTemp("log_app")) {
            m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
          }
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"log_app",true);
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
      } else { // Else
        /* _gMsgProc := "Nessuna Soggetto Inserito, Aggiornato o Scartato" */
        _gMsgProc = "Nessuna Soggetto Inserito, Aggiornato o Scartato";
        /* cProg := Utilities.GetAutonumber("PRGLOG\'"+LRTrim(_gAzienda)+"'",'',20) */
        cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGLOG\\'"+CPLib.LRTrim(_gAzienda)+"'","",20);
        // * --- Insert into log_app from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("log_app");
        m_cPhName = m_Ctx.GetPhName("log_app");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"log_app")+" (";
        m_cSql = m_cSql+GetFieldsName_0656DBE0(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Import Dati","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_gMsgProc,"?",0,0,m_cServer, m_oParameters)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("PERSONBO","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("NO RECORDS","?",0,0,m_cServer)+", ";
        if (m_Ctx.IsSharedTemp("log_app")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"log_app",true);
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
    } finally {
      try {
        if (Cursor_qbe_cgo_soggetti_totali!=null)
          Cursor_qbe_cgo_soggetti_totali.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_cgo_soggetti!=null)
          Cursor_cgo_soggetti.Close();
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
        if (Cursor_cgo_rapporti!=null)
          Cursor_cgo_rapporti.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_cgo_telematico!=null)
          Cursor_cgo_telematico.Close();
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
        if (Cursor_xntestbo!=null)
          Cursor_xntestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_4() throws Exception {
    CPResultSet Cursor_qbe_cgo_rapporti_totali=null;
    CPResultSet Cursor_cgo_rapporti=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_cgo_telematico=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Import Rapporti */
      /* _rapporto Char(25) */
      String _rapporto;
      _rapporto = CPLib.Space(25);
      /* _totale := 0 */
      _totale = CPLib.Round(0,0);
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      // * --- Select from qbe_cgo_rapporti_totali
      if (Cursor_qbe_cgo_rapporti_totali!=null)
        Cursor_qbe_cgo_rapporti_totali.Close();
      Cursor_qbe_cgo_rapporti_totali = new VQRHolder("qbe_cgo_rapporti_totali",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_cgo_rapporti_totali.Eof())) {
        /* _totale := qbe_cgo_rapporti_totali->TOTRAP */
        _totale = CPLib.Round(Cursor_qbe_cgo_rapporti_totali.GetDouble("TOTRAP"),0);
        Cursor_qbe_cgo_rapporti_totali.Next();
      }
      m_cConnectivityError = Cursor_qbe_cgo_rapporti_totali.ErrorMessage();
      Cursor_qbe_cgo_rapporti_totali.Close();
      // * --- End Select
      /* If _totale > 0 */
      if (CPLib.gt(_totale,0)) {
        // * --- Select from cgo_rapporti
        m_cServer = m_Ctx.GetServer("cgo_rapporti");
        m_cPhName = m_Ctx.GetPhName("cgo_rapporti");
        if (Cursor_cgo_rapporti!=null)
          Cursor_cgo_rapporti.Close();
        Cursor_cgo_rapporti = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("cgo_rapporti")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_cgo_rapporti.Eof())) {
          // Begin Transaction
          m_Sql.RequireTransaction();
          double nTry062D0288status;
          nTry062D0288status = m_Sql.GetTransactionStatus();
          String cTry062D0288msg;
          cTry062D0288msg = m_Sql.TransactionErrorMessage();
          try {
            /* _recOK := 0 */
            _recOK = CPLib.Round(0,0);
            /* _txterr := '' */
            _txterr = "";
            /* If Empty(cgo_rapporti->RAPPORTO) */
            if (CPLib.Empty(Cursor_cgo_rapporti.GetString("RAPPORTO"))) {
              /* _txterr := _txterr + 'Manca il codice del rapporto' + NL */
              _txterr = _txterr+"Manca il codice del rapporto"+"\n";
              /* _recOK := 1 */
              _recOK = CPLib.Round(1,0);
            } // End If
            /* If Empty(cgo_rapporti->TIPOMOV) */
            if (CPLib.Empty(Cursor_cgo_rapporti.GetString("TIPOMOV"))) {
              /* _txterr := _txterr + 'Manca il tipo di movimento del rapporto' + NL */
              _txterr = _txterr+"Manca il tipo di movimento del rapporto"+"\n";
              /* _recOK := 1 */
              _recOK = CPLib.Round(1,0);
            } else { // Else
              /* If cgo_rapporti->TIPOMOV <> 'A' and cgo_rapporti->TIPOMOV <> 'C' */
              if (CPLib.ne(Cursor_cgo_rapporti.GetString("TIPOMOV"),"A") && CPLib.ne(Cursor_cgo_rapporti.GetString("TIPOMOV"),"C")) {
                /* _txterr := _txterr + 'Tipo di movimento del rapporto errato' + NL */
                _txterr = _txterr+"Tipo di movimento del rapporto errato"+"\n";
                /* _recOK := 1 */
                _recOK = CPLib.Round(1,0);
              } // End If
            } // End If
            /* If Empty(cgo_rapporti->DATAOPE) */
            if (CPLib.Empty(Cursor_cgo_rapporti.GetDate("DATAOPE"))) {
              /* _txterr := _txterr + 'Manca la data del movimento del rapporto' + NL */
              _txterr = _txterr+"Manca la data del movimento del rapporto"+"\n";
              /* _recOK := 1 */
              _recOK = CPLib.Round(1,0);
            } else { // Else
              /* If cgo_rapporti->DATAOPE > Date() */
              if (CPLib.gt(Cursor_cgo_rapporti.GetDate("DATAOPE"),CPLib.Date())) {
                /* _txterr := _txterr + 'Data movimento del rapporto errata' + NL */
                _txterr = _txterr+"Data movimento del rapporto errata"+"\n";
                /* _recOK := 1 */
                _recOK = CPLib.Round(1,0);
              } // End If
            } // End If
            /* If Empty(cgo_rapporti->CODINTEST) */
            if (CPLib.Empty(Cursor_cgo_rapporti.GetString("CODINTEST"))) {
              /* _txterr := _txterr + "Manca l'intestatario del rapporto" + NL */
              _txterr = _txterr+"Manca l'intestatario del rapporto"+"\n";
              /* _recOK := 1 */
              _recOK = CPLib.Round(1,0);
            } else { // Else
              /* _codsog := '' */
              _codsog = "";
              // * --- Read from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              m_cSql = "";
              m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_rapporti.GetString("CODINTEST"),"C",16,0,m_cServer),m_cServer,Cursor_cgo_rapporti.GetString("CODINTEST"));
              if (m_Ctx.IsSharedTemp("personbo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _codsog = Read_Cursor.GetString("CONNES");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on personbo into routine arrt_imp_dati_cgo_sched_tabs_multitry returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _codsog = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(_codsog) */
              if (CPLib.Empty(_codsog)) {
                /* _txterr := _txterr + 'Non trovata anagrafica soggetto intestatario rapporto' + NL */
                _txterr = _txterr+"Non trovata anagrafica soggetto intestatario rapporto"+"\n";
                /* _recOK := 1 */
                _recOK = CPLib.Round(1,0);
              } // End If
            } // End If
            /* If not(Empty(LRTrim(cgo_rapporti->TIPOMOV))) and cgo_rapporti->TIPOMOV = 'C' */
            if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_cgo_rapporti.GetString("TIPOMOV")))) && CPLib.eqr(Cursor_cgo_rapporti.GetString("TIPOMOV"),"C")) {
              /* _rapporto := '' */
              _rapporto = "";
              // * --- Read from anarapbo
              m_cServer = m_Ctx.GetServer("anarapbo");
              m_cPhName = m_Ctx.GetPhName("anarapbo");
              m_cSql = "";
              m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_rapporti.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_cgo_rapporti.GetString("RAPPORTO"));
              if (m_Ctx.IsSharedTemp("anarapbo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _rapporto = Read_Cursor.GetString("RAPPORTO");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on anarapbo into routine arrt_imp_dati_cgo_sched_tabs_multitry returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _rapporto = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(LRTrim(_rapporto)) */
              if (CPLib.Empty(CPLib.LRTrim(_rapporto))) {
                // * --- Read from xnarapbo
                m_cServer = m_Ctx.GetServer("xnarapbo");
                m_cPhName = m_Ctx.GetPhName("xnarapbo");
                m_cSql = "";
                m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_rapporti.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_cgo_rapporti.GetString("RAPPORTO"));
                if (m_Ctx.IsSharedTemp("xnarapbo")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _rapporto = Read_Cursor.GetString("RAPPORTO");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on xnarapbo into routine arrt_imp_dati_cgo_sched_tabs_multitry returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _rapporto = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
              } // End If
              /* If Empty(LRTrim(_rapporto)) */
              if (CPLib.Empty(CPLib.LRTrim(_rapporto))) {
                /* _txterr := _txterr + 'Operazione di chiusura per rapporto mai aperto' + NL */
                _txterr = _txterr+"Operazione di chiusura per rapporto mai aperto"+"\n";
                /* _recOK := 1 */
                _recOK = CPLib.Round(1,0);
              } // End If
            } // End If
            /* If _recOK = 0 */
            if (CPLib.eqr(_recOK,0)) {
              /* If cgo_rapporti->TIPOMOV='A' */
              if (CPLib.eqr(Cursor_cgo_rapporti.GetString("TIPOMOV"),"A")) {
                // * --- Read from anarapbo
                m_cServer = m_Ctx.GetServer("anarapbo");
                m_cPhName = m_Ctx.GetPhName("anarapbo");
                m_cSql = "";
                m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_rapporti.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_cgo_rapporti.GetString("RAPPORTO"));
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
                    Error l_oErrorFault = new Error("Read on anarapbo into routine arrt_imp_dati_cgo_sched_tabs_multitry returns two or more records. This item should return only a record.");
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
                  // * --- Read from xnarapbo
                  m_cServer = m_Ctx.GetServer("xnarapbo");
                  m_cPhName = m_Ctx.GetPhName("xnarapbo");
                  m_cSql = "";
                  m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_rapporti.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_cgo_rapporti.GetString("RAPPORTO"));
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
                      Error l_oErrorFault = new Error("Read on xnarapbo into routine arrt_imp_dati_cgo_sched_tabs_multitry returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    xRapporto = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                } // End If
                /* If Empty(LRTrim(xRapporto)) */
                if (CPLib.Empty(CPLib.LRTrim(xRapporto))) {
                  /* If w_tipodest='P' */
                  if (CPLib.eqr(w_tipodest,"P")) {
                    // * --- Insert into xnarapbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("xnarapbo");
                    m_cPhName = m_Ctx.GetPhName("xnarapbo");
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.InsertIntoStatement(m_Ctx,"xnarapbo")+" (";
                    m_cSql = m_cSql+GetFieldsName_05E0D648(m_Ctx);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetString("DESCRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQLNull("0","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("E","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQLNull("242","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("22","?",0,0,m_cServer)+", ";
                    if (m_Ctx.IsSharedTemp("xnarapbo")) {
                      m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                    }
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
                      throw new RoutineException();
                    }
                    /* cInfProg1 := Utilities.GetAutonumber("PRGPINFO1\'"+LRTrim(_gAzienda)+"'",'',10) */
                    cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGPINFO1\\'"+CPLib.LRTrim(_gAzienda)+"'","",10);
                    /* cInfProg2 := Utilities.GetAutonumber("PRGPINFO2\'"+LRTrim(_gAzienda)+"'",'',11) */
                    cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGPINFO2\\'"+CPLib.LRTrim(_gAzienda)+"'","",11);
                    /* nProgImp := Utilities.GetAutonumber("PRGIMPINF\'"+LRTrim(_gAzienda)+"'",0,15) */
                    nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINF\\'"+CPLib.LRTrim(_gAzienda)+"'",0,15),0);
                    // * --- Insert into xapopebo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("xapopebo");
                    m_cPhName = m_Ctx.GetPhName("xapopebo");
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.InsertIntoStatement(m_Ctx,"xapopebo")+" (";
                    m_cSql = m_cSql+GetFieldsName_0646E390(m_Ctx);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_cgo_rapporti.GetDate("DATAOPE")),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_cabinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,115,6),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetDate("DATAOPE"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,169,50),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_cgo_rapporti.GetDate("DATAOPE"))+cInfProg1+"0","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQLNull("0","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQLNull("23","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
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
                      /* _gMsgProc := _gMsgProc +"Rilevati errori nel file cgo_rapporti per l'informazione in data "+arfn_fdate(cgo_rapporti->DATAOPE)+" relativa al rapporto: "+LRTrim(cgo_rapporti->RAPPORTO)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                      _gMsgProc = _gMsgProc+"Rilevati errori nel file cgo_rapporti per l'informazione in data "+arfn_fdateR.Make(m_Ctx,this).Run(Cursor_cgo_rapporti.GetDate("DATAOPE"))+" relativa al rapporto: "+CPLib.LRTrim(Cursor_cgo_rapporti.GetString("RAPPORTO"))+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                      m_Ctx.SetGlobalString("_gMsgProc",_gMsgProc);
                      m_cLastMsgError = "";
                      /* _esito := 1 */
                      _esito = CPLib.Round(1,0);
                      // Exit Loop
                      if (true) {
                        break;
                      }
                    } else if (CPLib.ne(m_cLastMsgError,"")) {
                      m_bError = true;
                      throw new RoutineException();
                    }
                    /* nProgImp2 := Utilities.GetAutonumber("PRGIMPSOG\'"+LRTrim(_gAzienda)+"'",0,15) */
                    nProgImp2 = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPSOG\\'"+CPLib.LRTrim(_gAzienda)+"'",0,15),0);
                    // * --- Insert into xntestbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("xntestbo");
                    m_cPhName = m_Ctx.GetPhName("xntestbo");
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.InsertIntoStatement(m_Ctx,"xntestbo")+" (";
                    m_cSql = m_cSql+GetFieldsName_062EEC58(m_Ctx);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetDate("DATAOPE"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_cgo_rapporti.GetString("CODINTEST"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp2,"?",0,0)+", ";
                    if (m_Ctx.IsSharedTemp("xntestbo")) {
                      m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                    }
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
                      throw new RoutineException();
                    }
                  } else { // Else
                    // * --- Insert into anarapbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("anarapbo");
                    m_cPhName = m_Ctx.GetPhName("anarapbo");
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.InsertIntoStatement(m_Ctx,"anarapbo")+" (";
                    m_cSql = m_cSql+GetFieldsName_05E0E068(m_Ctx);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetString("DESCRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQLNull("0","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("E","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQLNull("242","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("22","?",0,0,m_cServer)+", ";
                    if (m_Ctx.IsSharedTemp("anarapbo")) {
                      m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                    }
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
                      throw new RoutineException();
                    }
                    /* cInfProg1 := Utilities.GetAutonumber("PRGINFO1\'"+LRTrim(_gAzienda)+"'",'',10) */
                    cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO1\\'"+CPLib.LRTrim(_gAzienda)+"'","",10);
                    /* cInfProg2 := Utilities.GetAutonumber("PRGINFO2\'"+LRTrim(_gAzienda)+"'",'',11) */
                    cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO2\\'"+CPLib.LRTrim(_gAzienda)+"'","",11);
                    /* nProgImp := Utilities.GetAutonumber("PRGIMPINF\'"+LRTrim(_gAzienda)+"'",0,15) */
                    nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINF\\'"+CPLib.LRTrim(_gAzienda)+"'",0,15),0);
                    // * --- Insert into rapopebo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("rapopebo");
                    m_cPhName = m_Ctx.GetPhName("rapopebo");
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.InsertIntoStatement(m_Ctx,"rapopebo")+" (";
                    m_cSql = m_cSql+GetFieldsName_0646EA98(m_Ctx);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_cgo_rapporti.GetDate("DATAOPE")),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_cabinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,115,6),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetDate("DATAOPE"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,169,50),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_cgo_rapporti.GetDate("DATAOPE"))+cInfProg1+"0","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_cgo_rapporti.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQLNull("0","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQLNull("23","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
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
                      /* _gMsgProc := _gMsgProc +"Rilevati errori nel file cgo_rapporti per l'informazione in data "+arfn_fdate(cgo_rapporti->DATAOPE)+" relativa al rapporto: "+LRTrim(cgo_rapporti->RAPPORTO)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                      _gMsgProc = _gMsgProc+"Rilevati errori nel file cgo_rapporti per l'informazione in data "+arfn_fdateR.Make(m_Ctx,this).Run(Cursor_cgo_rapporti.GetDate("DATAOPE"))+" relativa al rapporto: "+CPLib.LRTrim(Cursor_cgo_rapporti.GetString("RAPPORTO"))+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                      m_Ctx.SetGlobalString("_gMsgProc",_gMsgProc);
                      m_cLastMsgError = "";
                      /* _esito := 1 */
                      _esito = CPLib.Round(1,0);
                      // Exit Loop
                      if (true) {
                        break;
                      }
                    } else if (CPLib.ne(m_cLastMsgError,"")) {
                      m_bError = true;
                      throw new RoutineException();
                    }
                    /* nProgImp2 := Utilities.GetAutonumber("PRGIMPSOG\'"+LRTrim(_gAzienda)+"'",0,15) */
                    nProgImp2 = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPSOG\\'"+CPLib.LRTrim(_gAzienda)+"'",0,15),0);
                    // * --- Insert into intestbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("intestbo");
                    m_cPhName = m_Ctx.GetPhName("intestbo");
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.InsertIntoStatement(m_Ctx,"intestbo")+" (";
                    m_cSql = m_cSql+GetFieldsName_062E4208(m_Ctx);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetDate("DATAOPE"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_cgo_rapporti.GetString("CODINTEST"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp2,"?",0,0)+", ";
                    if (m_Ctx.IsSharedTemp("intestbo")) {
                      m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                    }
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
                      throw new RoutineException();
                    }
                  } // End If
                  // * --- Insert into knarapbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("knarapbo");
                  m_cPhName = m_Ctx.GetPhName("knarapbo");
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.InsertIntoStatement(m_Ctx,"knarapbo")+" (";
                  m_cSql = m_cSql+GetFieldsName_07A51088(m_Ctx);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetString("DESCRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(w_tipodest,"?",0,0,m_cServer)+", ";
                  if (m_Ctx.IsSharedTemp("knarapbo")) {
                    m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                  }
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
                    throw new RoutineException();
                  }
                  /* rNumNew := rNumNew + 1 */
                  rNumNew = CPLib.Round(rNumNew+1,0);
                } // End If
                /* ElseIf cgo_rapporti->TIPOMOV='C' */
              } else if (CPLib.eqr(Cursor_cgo_rapporti.GetString("TIPOMOV"),"C")) {
                // * --- Read from anarapbo
                m_cServer = m_Ctx.GetServer("anarapbo");
                m_cPhName = m_Ctx.GetPhName("anarapbo");
                m_cSql = "";
                m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_rapporti.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_cgo_rapporti.GetString("RAPPORTO"));
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
                    Error l_oErrorFault = new Error("Read on anarapbo into routine arrt_imp_dati_cgo_sched_tabs_multitry returns two or more records. This item should return only a record.");
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
                  /* cInfProg1 := Utilities.GetAutonumber("PRGPINFO1\'"+LRTrim(_gAzienda)+"'",'',10) */
                  cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGPINFO1\\'"+CPLib.LRTrim(_gAzienda)+"'","",10);
                  /* cInfProg2 := Utilities.GetAutonumber("PRGPINFO2\'"+LRTrim(_gAzienda)+"'",'',11) */
                  cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGPINFO2\\'"+CPLib.LRTrim(_gAzienda)+"'","",11);
                  /* nProgImp := Utilities.GetAutonumber("PRGIMPINF\'"+LRTrim(_gAzienda)+"'",0,15) */
                  nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINF\\'"+CPLib.LRTrim(_gAzienda)+"'",0,15),0);
                  // * --- Insert into xapopebo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("xapopebo");
                  m_cPhName = m_Ctx.GetPhName("xapopebo");
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.InsertIntoStatement(m_Ctx,"xapopebo")+" (";
                  m_cSql = m_cSql+GetFieldsName_062D1050(m_Ctx);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_cgo_rapporti.GetDate("DATAOPE")),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_cabinter,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,115,6),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetDate("DATAOPE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,169,50),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_cgo_rapporti.GetDate("DATAOPE"))+cInfProg1+"0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull("0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull("23","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
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
                    /* _gMsgProc := _gMsgProc +"Rilevati errori nel file cgo_rapporti per l'informazione in data "+arfn_fdate(cgo_rapporti->DATAOPE)+" relativa al rapporto: "+LRTrim(cgo_rapporti->RAPPORTO)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                    _gMsgProc = _gMsgProc+"Rilevati errori nel file cgo_rapporti per l'informazione in data "+arfn_fdateR.Make(m_Ctx,this).Run(Cursor_cgo_rapporti.GetDate("DATAOPE"))+" relativa al rapporto: "+CPLib.LRTrim(Cursor_cgo_rapporti.GetString("RAPPORTO"))+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                    m_Ctx.SetGlobalString("_gMsgProc",_gMsgProc);
                    m_cLastMsgError = "";
                    /* _esito := 1 */
                    _esito = CPLib.Round(1,0);
                    // Exit Loop
                    if (true) {
                      break;
                    }
                  } else if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                    throw new RoutineException();
                  }
                  // * --- Write into xntestbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("xntestbo");
                  m_cPhName = m_Ctx.GetPhName("xntestbo");
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = "Update "+m_cPhName+" set ";
                  m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(Cursor_cgo_rapporti.GetDate("DATAOPE"),"D",8,0)+", ";
                  m_cSql = m_cSql+"NUMPROG2 = "+CPLib.ToSQL(cInfProg2,"C",11,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xntestbo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_rapporti.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_rapporti.GetString("RAPPORTO"))+"";
                  if (m_Ctx.IsSharedTemp("xntestbo")) {
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
                } else { // Else
                  /* cInfProg1 := Utilities.GetAutonumber("PRGINFO1\'"+LRTrim(_gAzienda)+"'",'',10) */
                  cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO1\\'"+CPLib.LRTrim(_gAzienda)+"'","",10);
                  /* cInfProg2 := Utilities.GetAutonumber("PRGINFO2\'"+LRTrim(_gAzienda)+"'",'',11) */
                  cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO2\\'"+CPLib.LRTrim(_gAzienda)+"'","",11);
                  /* nProgImp := Utilities.GetAutonumber("PRGIMPINF\'"+LRTrim(_gAzienda)+"'",0,15) */
                  nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINF\\'"+CPLib.LRTrim(_gAzienda)+"'",0,15),0);
                  // * --- Insert into rapopebo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("rapopebo");
                  m_cPhName = m_Ctx.GetPhName("rapopebo");
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.InsertIntoStatement(m_Ctx,"rapopebo")+" (";
                  m_cSql = m_cSql+GetFieldsName_07A87C70(m_Ctx);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_cgo_rapporti.GetDate("DATAOPE")),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_cabinter,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,115,6),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetDate("DATAOPE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,169,50),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_cgo_rapporti.GetDate("DATAOPE"))+cInfProg1+"0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_cgo_rapporti.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull("0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull("26","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
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
                    /* _gMsgProc := _gMsgProc +"Rilevati errori nel file cgo_rapporti per l'informazione in data "+arfn_fdate(cgo_rapporti->DATAOPE)+" relativa al rapporto: "+LRTrim(cgo_rapporti->RAPPORTO)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                    _gMsgProc = _gMsgProc+"Rilevati errori nel file cgo_rapporti per l'informazione in data "+arfn_fdateR.Make(m_Ctx,this).Run(Cursor_cgo_rapporti.GetDate("DATAOPE"))+" relativa al rapporto: "+CPLib.LRTrim(Cursor_cgo_rapporti.GetString("RAPPORTO"))+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                    m_Ctx.SetGlobalString("_gMsgProc",_gMsgProc);
                    m_cLastMsgError = "";
                    /* _esito := 1 */
                    _esito = CPLib.Round(1,0);
                    // Exit Loop
                    if (true) {
                      break;
                    }
                  } else if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                    throw new RoutineException();
                  }
                  // * --- Write into intestbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("intestbo");
                  m_cPhName = m_Ctx.GetPhName("intestbo");
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = "Update "+m_cPhName+" set ";
                  m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(Cursor_cgo_rapporti.GetDate("DATAOPE"),"D",8,0)+", ";
                  m_cSql = m_cSql+"NUMPROG2 = "+CPLib.ToSQL(cInfProg2,"C",11,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_rapporti.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_rapporti.GetString("RAPPORTO"))+"";
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
                    throw new RoutineException();
                  }
                } // End If
                /* rNumMod := rNumMod + 1 */
                rNumMod = CPLib.Round(rNumMod+1,0);
              } // End If
            } else { // Else
              /* ProgErr := Utilities.GetAutonumber("PRGRAPERR\'"+LRTrim(_gAzienda)+"'","",15) */
              ProgErr = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGRAPERR\\'"+CPLib.LRTrim(_gAzienda)+"'","",15);
              // * --- Insert into cgo_rapporti_err from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cgo_rapporti_err");
              m_cPhName = m_Ctx.GetPhName("cgo_rapporti_err");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"cgo_rapporti_err")+" (";
              m_cSql = m_cSql+GetFieldsName_05DD13B8(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(ProgErr,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetString("DESCRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetString("TIPOMOV"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetString("CODINTEST"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_txterr,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("cgo_rapporti_err")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_rapporti_err",true);
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
              /* rNumErr := rNumErr + 1 */
              rNumErr = CPLib.Round(rNumErr+1,0);
              // * --- Select from cgo_telematico
              m_cServer = m_Ctx.GetServer("cgo_telematico");
              m_cPhName = m_Ctx.GetPhName("cgo_telematico");
              if (Cursor_cgo_telematico!=null)
                Cursor_cgo_telematico.Close();
              Cursor_cgo_telematico = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_cgo_rapporti.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("cgo_telematico")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_cgo_telematico.Eof())) {
                // * --- Insert into cgo_telematico_err from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("cgo_telematico_err");
                m_cPhName = m_Ctx.GetPhName("cgo_telematico_err");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.InsertIntoStatement(m_Ctx,"cgo_telematico_err")+" (";
                m_cSql = m_cSql+GetFieldsName_06102478(m_Ctx);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("SNAINUMOPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("ENV"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("TOTLIRE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("CACODICE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDateTime("CADATAORA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CAIDBIGLIETTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("CSMF_COD"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("NUM_CONC"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("P_VEND"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("IPCOLLEG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDateTime("ORACOLLEG"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("DUCOLLEG"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("IBAN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("Operazione scartata per errori su rapporto continuativo","?",0,0,m_cServer, m_oParameters)+", ";
                if (m_Ctx.IsSharedTemp("cgo_telematico_err")) {
                  m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                }
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_telematico_err",true);
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
                // * --- Delete from cgo_telematico
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("cgo_telematico");
                m_cPhName = m_Ctx.GetPhName("cgo_telematico");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "delete from "+m_cPhName;
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"SNAINUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_telematico.GetString("SNAINUMOPE"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_telematico.GetString("SNAINUMOPE"))+"";
                if (m_Ctx.IsSharedTemp("cgo_telematico")) {
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
                /* oNumErr := oNumErr + 1 */
                oNumErr = CPLib.Round(oNumErr+1,0);
                Cursor_cgo_telematico.Next();
              }
              m_cConnectivityError = Cursor_cgo_telematico.ErrorMessage();
              Cursor_cgo_telematico.Close();
              // * --- End Select
            } // End If
            // * --- Delete from cgo_rapporti
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cgo_rapporti");
            m_cPhName = m_Ctx.GetPhName("cgo_rapporti");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = "delete from "+m_cPhName;
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_rapporti.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_rapporti.GetString("RAPPORTO"))+"";
            if (m_Ctx.IsSharedTemp("cgo_rapporti")) {
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
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
            // Commit
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
            m_Sql.CompleteTransaction();
          } catch(Exception l_exeption) {
            Stop.ReactToException(l_exeption);
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            /* _gMsgProc := "Rilevati errori nell'impotazione dei file! Ricreare il file segnalato e rieseguire l'import dei dati. La procedura annullera automaticamente l'importazione" + NL */
            _gMsgProc = "Rilevati errori nell'impotazione dei file! Ricreare il file segnalato e rieseguire l'import dei dati. La procedura annullera automaticamente l'importazione"+"\n";
            /* _gMsgProc := _gMsgProc + 'Errore SQL: ' + m_Sql.TransactionErrorMessage() + NL */
            _gMsgProc = _gMsgProc+"Errore SQL: "+m_Sql.TransactionErrorMessage()+"\n";
            // Rollback
            m_Sql.AbortTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            m_bError = true;
            m_Sql.CompleteTransaction();
            /* cProg := Utilities.GetAutonumber("PRGLOG\'"+LRTrim(_gAzienda)+"'",'',20) */
            cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGLOG\\'"+CPLib.LRTrim(_gAzienda)+"'","",20);
            // * --- Insert into log_app from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("log_app");
            m_cPhName = m_Ctx.GetPhName("log_app");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.InsertIntoStatement(m_Ctx,"log_app")+" (";
            m_cSql = m_cSql+GetFieldsName_05CE7698(m_Ctx);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Import Dati","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_gMsgProc,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Scheduler","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("ERRORS","?",0,0,m_cServer)+", ";
            if (m_Ctx.IsSharedTemp("log_app")) {
              m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
            }
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"log_app",true);
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
          } finally {
            if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry062D0288status,0)) {
              m_Sql.SetTransactionStatus(nTry062D0288status,cTry062D0288msg);
            }
          }
          Cursor_cgo_rapporti.Next();
        }
        m_cConnectivityError = Cursor_cgo_rapporti.ErrorMessage();
        Cursor_cgo_rapporti.Close();
        // * --- End Select
        /* _gMsgProc := 'Rapporti Inseriti: '+LRTrim(Str(rNumNew,10,0)) + ' - Rapporti Aggiornati: '+LRTrim(Str(rNumMod,10,0)) + NL */
        _gMsgProc = "Rapporti Inseriti: "+CPLib.LRTrim(CPLib.Str(rNumNew,10,0))+" - Rapporti Aggiornati: "+CPLib.LRTrim(CPLib.Str(rNumMod,10,0))+"\n";
        /* cProg := Utilities.GetAutonumber("PRGLOG\'"+LRTrim(_gAzienda)+"'",'',20) */
        cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGLOG\\'"+CPLib.LRTrim(_gAzienda)+"'","",20);
        // * --- Insert into log_app from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("log_app");
        m_cPhName = m_Ctx.GetPhName("log_app");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"log_app")+" (";
        m_cSql = m_cSql+GetFieldsName_05EFB320(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Import Dati","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_gMsgProc,"?",0,0,m_cServer, m_oParameters)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("RAPPORTI","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Inseriti / Aggiornati "+CPLib.LRTrim(CPLib.Str((rNumNew+rNumMod),10,0)),"?",0,0,m_cServer)+", ";
        if (m_Ctx.IsSharedTemp("log_app")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"log_app",true);
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
        /* If rNumErr > 0 */
        if (CPLib.gt(rNumErr,0)) {
          /* _gMsgProc := 'Rapporti Scartati: '+LRTrim(Str(rNumErr,10,0))  + NL */
          _gMsgProc = "Rapporti Scartati: "+CPLib.LRTrim(CPLib.Str(rNumErr,10,0))+"\n";
          /* cProg := Utilities.GetAutonumber("PRGLOG\'"+LRTrim(_gAzienda)+"'",'',20) */
          cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGLOG\\'"+CPLib.LRTrim(_gAzienda)+"'","",20);
          // * --- Insert into log_app from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("log_app");
          m_cPhName = m_Ctx.GetPhName("log_app");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"log_app")+" (";
          m_cSql = m_cSql+GetFieldsName_06553FF0(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Import Dati","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_gMsgProc,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("RAPPORTI","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Scartati "+CPLib.LRTrim(CPLib.Str(rNumErr,10,0)),"?",0,0,m_cServer)+", ";
          if (m_Ctx.IsSharedTemp("log_app")) {
            m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
          }
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"log_app",true);
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
      } else { // Else
        /* _gMsgProc := "Nessun Rapporto Inserito, Aggiornato o Scartato" */
        _gMsgProc = "Nessun Rapporto Inserito, Aggiornato o Scartato";
        /* cProg := Utilities.GetAutonumber("PRGLOG\'"+LRTrim(_gAzienda)+"'",'',20) */
        cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGLOG\\'"+CPLib.LRTrim(_gAzienda)+"'","",20);
        // * --- Insert into log_app from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("log_app");
        m_cPhName = m_Ctx.GetPhName("log_app");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"log_app")+" (";
        m_cSql = m_cSql+GetFieldsName_05C84660(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Import Dati","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_gMsgProc,"?",0,0,m_cServer, m_oParameters)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("RAPPORTI","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("NO RECORDS","?",0,0,m_cServer)+", ";
        if (m_Ctx.IsSharedTemp("log_app")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"log_app",true);
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
    } finally {
      try {
        if (Cursor_qbe_cgo_rapporti_totali!=null)
          Cursor_qbe_cgo_rapporti_totali.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_cgo_rapporti!=null)
          Cursor_cgo_rapporti.Close();
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
        if (Cursor_cgo_telematico!=null)
          Cursor_cgo_telematico.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_5() throws Exception {
    CPResultSet Cursor_qbe_cgo_telematico_totali=null;
    CPResultSet Cursor_cgo_telematico=null;
    CPResultSet Cursor_anadip=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_xntestbo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_inter2bo=null;
    CPResultSet Cursor_cgo_operazioni_dl=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Import Operazioni */
      /* _totale := 0 */
      _totale = CPLib.Round(0,0);
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      /* _MsgAss := '' */
      _MsgAss = "";
      // * --- Select from qbe_cgo_telematico_totali
      if (Cursor_qbe_cgo_telematico_totali!=null)
        Cursor_qbe_cgo_telematico_totali.Close();
      Cursor_qbe_cgo_telematico_totali = new VQRHolder("qbe_cgo_telematico_totali",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_cgo_telematico_totali.Eof())) {
        /* _totale := qbe_cgo_telematico_totali->TOTALE */
        _totale = CPLib.Round(Cursor_qbe_cgo_telematico_totali.GetDouble("TOTALE"),0);
        Cursor_qbe_cgo_telematico_totali.Next();
      }
      m_cConnectivityError = Cursor_qbe_cgo_telematico_totali.ErrorMessage();
      Cursor_qbe_cgo_telematico_totali.Close();
      // * --- End Select
      /* If _totale > 0 */
      if (CPLib.gt(_totale,0)) {
        // * --- Select from cgo_telematico
        m_cServer = m_Ctx.GetServer("cgo_telematico");
        m_cPhName = m_Ctx.GetPhName("cgo_telematico");
        if (Cursor_cgo_telematico!=null)
          Cursor_cgo_telematico.Close();
        Cursor_cgo_telematico = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("cgo_telematico")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_cgo_telematico.Eof())) {
          // Begin Transaction
          m_Sql.RequireTransaction();
          double nTry06335A58status;
          nTry06335A58status = m_Sql.GetTransactionStatus();
          String cTry06335A58msg;
          cTry06335A58msg = m_Sql.TransactionErrorMessage();
          try {
            /* _snainumope := cgo_telematico->SNAINUMOPE */
            _snainumope = Cursor_cgo_telematico.GetString("SNAINUMOPE");
            /* _recOK := 0 */
            _recOK = CPLib.Round(0,0);
            /* _txterr := '' */
            _txterr = "";
            /* Exec "Controllo Operazione" Page 8:Page_8 */
            Page_8();
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
              throw new RoutineException();
            }
            /* If _recOK=0 */
            if (CPLib.eqr(_recOK,0)) {
              // * --- Select from anadip
              m_cServer = m_Ctx.GetServer("anadip");
              m_cPhName = m_Ctx.GetPhName("anadip");
              if (Cursor_anadip!=null)
                Cursor_anadip.Close();
              Cursor_anadip = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODDIP="+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CODDIPE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("anadip")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_anadip.Eof())) {
                /* _citinter := anadip->DESCCIT */
                _citinter = Cursor_anadip.GetString("DESCCIT");
                /* _cabinter := anadip->CAB */
                _cabinter = Cursor_anadip.GetString("CAB");
                /* _prvinter := anadip->PROVINCIA */
                _prvinter = Cursor_anadip.GetString("PROVINCIA");
                Cursor_anadip.Next();
              }
              m_cConnectivityError = Cursor_anadip.ErrorMessage();
              Cursor_anadip.Close();
              // * --- End Select
              /* _locrap := 'D' */
              _locrap = "D";
              /* _tiporap := '' */
              _tiporap = "";
              // * --- Read from anarapbo
              m_cServer = m_Ctx.GetServer("anarapbo");
              m_cPhName = m_Ctx.GetPhName("anarapbo");
              m_cSql = "";
              m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_telematico.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_cgo_telematico.GetString("RAPPORTO"));
              if (m_Ctx.IsSharedTemp("anarapbo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("TIPORAP",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _tiporap = Read_Cursor.GetString("TIPORAP");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on anarapbo into routine arrt_imp_dati_cgo_sched_tabs_multitry returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _tiporap = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(LRTrim(_tiporap)) */
              if (CPLib.Empty(CPLib.LRTrim(_tiporap))) {
                // * --- Read from xnarapbo
                m_cServer = m_Ctx.GetServer("xnarapbo");
                m_cPhName = m_Ctx.GetPhName("xnarapbo");
                m_cSql = "";
                m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_telematico.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_cgo_telematico.GetString("RAPPORTO"));
                if (m_Ctx.IsSharedTemp("xnarapbo")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("TIPORAP",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _tiporap = Read_Cursor.GetString("TIPORAP");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on xnarapbo into routine arrt_imp_dati_cgo_sched_tabs_multitry returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _tiporap = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* _locrap := 'P' */
                _locrap = "P";
              } // End If
              /* xData := Left(DateTimeToChar(cgo_telematico->CADATAORA),8) */
              xData = CPLib.Left(CPLib.DateTimeToChar(Cursor_cgo_telematico.GetDateTime("CADATAORA")),8);
              /* _datope := CharToDate(xData) */
              _datope = CPLib.CharToDate(xData);
              /* _datreg := Date() */
              _datreg = CPLib.Date();
              /* _codana := '' */
              _codana = "";
              /* _codsin := '' */
              _codsin = "";
              /* _segno := '' */
              _segno = "";
              /* _tipope := '' */
              _tipope = "";
              /* _mezpagam := iif(LRTrim(cgo_telematico->MEZPAGAM) <> 'I' and LRTrim(cgo_telematico->MEZPAGAM) <> 'E' and LRTrim(cgo_telematico->MEZPAGAM) <> 'P','A',LRTrim(cgo_telematico->MEZPAGAM)) */
              _mezpagam = (CPLib.ne(CPLib.LRTrim(Cursor_cgo_telematico.GetString("MEZPAGAM")),"I") && CPLib.ne(CPLib.LRTrim(Cursor_cgo_telematico.GetString("MEZPAGAM")),"E") && CPLib.ne(CPLib.LRTrim(Cursor_cgo_telematico.GetString("MEZPAGAM")),"P")?"A":CPLib.LRTrim(Cursor_cgo_telematico.GetString("MEZPAGAM")));
              // * --- Read from cgo_causali
              m_cServer = m_Ctx.GetServer("cgo_causali");
              m_cPhName = m_Ctx.GetPhName("cgo_causali");
              m_cSql = "";
              m_cSql = m_cSql+"CACODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("CACODICE"),"N",5,0,m_cServer),m_cServer,Cursor_cgo_telematico.GetDouble("CACODICE"));
              m_cSql = m_cSql+" and CATIPOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_mezpagam,"C",2,0,m_cServer),m_cServer,_mezpagam);
              if (m_Ctx.IsSharedTemp("cgo_causali")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CACODANA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CACODSIN",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CASEGNO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _codana = Read_Cursor.GetString("CACODANA");
                _codsin = Read_Cursor.GetString("CACODSIN");
                _segno = Read_Cursor.GetString("CASEGNO");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on cgo_causali into routine arrt_imp_dati_cgo_sched_tabs_multitry returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _codana = "";
                _codsin = "";
                _segno = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If _codana <> '26' and _codana <> '48' and _codana <> 'AA' */
              if (CPLib.ne(_codana,"26") && CPLib.ne(_codana,"48") && CPLib.ne(_codana,"AA")) {
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
              /* xCF := '' */
              xCF = "";
              /* If cgo_telematico->ENV='W' */
              if (CPLib.eqr(Cursor_cgo_telematico.GetString("ENV"),"W")) {
                /* If cgo_telematico->TOTLIRE >= _limoper */
                if (CPLib.ge(Cursor_cgo_telematico.GetDouble("TOTLIRE"),_limoper)) {
                  /* If w_tipodest='P' */
                  if (CPLib.eqr(w_tipodest,"P")) {
                    /* cOpeProg1 := Utilities.GetAutonumber("PPOPER1\'"+LRTrim(_gAzienda)+"'",'',10) */
                    cOpeProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PPOPER1\\'"+CPLib.LRTrim(_gAzienda)+"'","",10);
                    /* cOpeProg2 := Utilities.GetAutonumber("PPOPER2\'"+LRTrim(_gAzienda)+"'",'',11) */
                    cOpeProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PPOPER2\\'"+CPLib.LRTrim(_gAzienda)+"'","",11);
                    /* nProgImp := Utilities.GetAutonumber("PRGIMPOPE\'"+LRTrim(_gAzienda)+"'",0,15) */
                    nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOPE\\'"+CPLib.LRTrim(_gAzienda)+"'",0,15),0);
                    /* nIntest := 1 */
                    nIntest = CPLib.Round(1,0);
                    // * --- Insert into xperazbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("xperazbo");
                    m_cPhName = m_Ctx.GetPhName("xperazbo");
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.InsertIntoStatement(m_Ctx,"xperazbo")+" (";
                    m_cSql = m_cSql+GetFieldsName_062EB288(m_Ctx);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_codana,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_cabinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_codsin,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_citinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("DUCOLLEG"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tiporap,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(xData+cOpeProg2+"0","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("IPCOLLEG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDateTime("ORACOLLEG"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_prvinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CAIDBIGLIETTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tipope,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("TOTLIRE")*100,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("ENV"),"?",0,0,m_cServer)+", ";
                    if (m_Ctx.IsSharedTemp("xperazbo")) {
                      m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                    }
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
                    /* If _locrap='D' */
                    if (CPLib.eqr(_locrap,"D")) {
                      // * --- Select from intestbo
                      m_cServer = m_Ctx.GetServer("intestbo");
                      m_cPhName = m_Ctx.GetPhName("intestbo");
                      if (Cursor_intestbo!=null)
                        Cursor_intestbo.Close();
                      Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_cgo_telematico.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      while ( ! (Cursor_intestbo.Eof())) {
                        /* If nIntest=1 */
                        if (CPLib.eqr(nIntest,1)) {
                          /* xCF := intestbo->CODINTER */
                          xCF = Cursor_intestbo.GetString("CODINTER");
                          // * --- Write into xperazbo from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("xperazbo");
                          m_cPhName = m_Ctx.GetPhName("xperazbo");
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = "Update "+m_cPhName+" set ";
                          m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
                          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xperazbo",false,true);
                          m_cSql = m_cSql+" where ";
                          m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
                          if (m_Ctx.IsSharedTemp("xperazbo")) {
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
                        } else { // Else
                          // * --- Insert into xlientiope from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("xlientiope");
                          m_cPhName = m_Ctx.GetPhName("xlientiope");
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"xlientiope")+" (";
                          m_cSql = m_cSql+GetFieldsName_05E09B80(m_Ctx);
                          m_cSql = m_cSql+") values (";
                          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                          if (m_Ctx.IsSharedTemp("xlientiope")) {
                            m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                          }
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
                        } // End If
                        /* nIntest := nIntest + 1 */
                        nIntest = CPLib.Round(nIntest+1,0);
                        Cursor_intestbo.Next();
                      }
                      m_cConnectivityError = Cursor_intestbo.ErrorMessage();
                      Cursor_intestbo.Close();
                      // * --- End Select
                      /* _codsog := '' */
                      _codsog = "";
                      // * --- Read from cgo_totope
                      m_cServer = m_Ctx.GetServer("cgo_totope");
                      m_cPhName = m_Ctx.GetPhName("cgo_totope");
                      m_cSql = "";
                      m_cSql = m_cSql+"TODATOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_datope,"D",8,0,m_cServer),m_cServer,_datope);
                      m_cSql = m_cSql+" and TOCODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"C",16,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"));
                      m_cSql = m_cSql+" and TO_SEGNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_segno,"C",1,0,m_cServer),m_cServer,_segno);
                      if (m_Ctx.IsSharedTemp("cgo_totope")) {
                        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                      }
                      if (Read_Cursor!=null)
                        Read_Cursor.Close();
                      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("TOCODSOG",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                      if ( ! (Read_Cursor.Eof())) {
                        _codsog = Read_Cursor.GetString("TOCODSOG");
                        Read_Cursor.Next();
                        if ( ! (Read_Cursor.Eof())) {
                          Error l_oErrorFault = new Error("Read on cgo_totope into routine arrt_imp_dati_cgo_sched_tabs_multitry returns two or more records. This item should return only a record.");
                          CPStdCounter.Error(l_oErrorFault);
                        }
                        Read_Cursor.Close();
                      } else {
                        // Error: no record found!
                        _codsog = "";
                        Read_Cursor.Close();
                        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                      }
                      /* If Empty(LRTrim(_codsog)) */
                      if (CPLib.Empty(CPLib.LRTrim(_codsog))) {
                        // * --- Insert into cgo_totope from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("cgo_totope");
                        m_cPhName = m_Ctx.GetPhName("cgo_totope");
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"cgo_totope")+" (";
                        m_cSql = m_cSql+GetFieldsName_05E8F398(m_Ctx);
                        m_cSql = m_cSql+") values (";
                        m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("TOTLIRE"),"?",0,0)+", ";
                        if (m_Ctx.IsSharedTemp("cgo_totope")) {
                          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                        }
                        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_totope",true);
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
                        // * --- Write into cgo_totope from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("cgo_totope");
                        m_cPhName = m_Ctx.GetPhName("cgo_totope");
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = "Update "+m_cPhName+" set ";
                        m_cSql = m_cSql+"TONUMOPE = TONUMOPE+"+CPLib.ToSQL(1,"N",10,0)+", ";
                        m_cSql = m_cSql+"TOIMPORT = TOIMPORT+"+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("TOTLIRE"),"N",12,2)+", ";
                        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_totope",false,true);
                        m_cSql = m_cSql+" where ";
                        m_cSql = m_cSql+"TODATOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_datope,"?",0,0,m_cServer),m_cServer,_datope)+"";
                        m_cSql = m_cSql+" and TOCODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_codsog,"?",0,0,m_cServer),m_cServer,_codsog)+"";
                        m_cSql = m_cSql+" and TO_SEGNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_segno,"?",0,0,m_cServer),m_cServer,_segno)+"";
                        if (m_Ctx.IsSharedTemp("cgo_totope")) {
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
                    } else { // Else
                      // * --- Select from xntestbo
                      m_cServer = m_Ctx.GetServer("xntestbo");
                      m_cPhName = m_Ctx.GetPhName("xntestbo");
                      if (Cursor_xntestbo!=null)
                        Cursor_xntestbo.Close();
                      Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_cgo_telematico.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      while ( ! (Cursor_xntestbo.Eof())) {
                        /* If nIntest=1 */
                        if (CPLib.eqr(nIntest,1)) {
                          /* xCF := xntestbo->CODINTER */
                          xCF = Cursor_xntestbo.GetString("CODINTER");
                          // * --- Write into xperazbo from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("xperazbo");
                          m_cPhName = m_Ctx.GetPhName("xperazbo");
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = "Update "+m_cPhName+" set ";
                          m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
                          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xperazbo",false,true);
                          m_cSql = m_cSql+" where ";
                          m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
                          if (m_Ctx.IsSharedTemp("xperazbo")) {
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
                        } else { // Else
                          // * --- Insert into xlientiope from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("xlientiope");
                          m_cPhName = m_Ctx.GetPhName("xlientiope");
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"xlientiope")+" (";
                          m_cSql = m_cSql+GetFieldsName_05B38978(m_Ctx);
                          m_cSql = m_cSql+") values (";
                          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                          if (m_Ctx.IsSharedTemp("xlientiope")) {
                            m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                          }
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
                        } // End If
                        /* nIntest := nIntest + 1 */
                        nIntest = CPLib.Round(nIntest+1,0);
                        /* _codsog := '' */
                        _codsog = "";
                        // * --- Read from cgo_totope
                        m_cServer = m_Ctx.GetServer("cgo_totope");
                        m_cPhName = m_Ctx.GetPhName("cgo_totope");
                        m_cSql = "";
                        m_cSql = m_cSql+"TODATOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_datope,"D",8,0,m_cServer),m_cServer,_datope);
                        m_cSql = m_cSql+" and TOCODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"C",16,0,m_cServer),m_cServer,Cursor_xntestbo.GetString("CODINTER"));
                        m_cSql = m_cSql+" and TO_SEGNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_segno,"C",1,0,m_cServer),m_cServer,_segno);
                        if (m_Ctx.IsSharedTemp("cgo_totope")) {
                          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                        }
                        if (Read_Cursor!=null)
                          Read_Cursor.Close();
                        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("TOCODSOG",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                        if ( ! (Read_Cursor.Eof())) {
                          _codsog = Read_Cursor.GetString("TOCODSOG");
                          Read_Cursor.Next();
                          if ( ! (Read_Cursor.Eof())) {
                            Error l_oErrorFault = new Error("Read on cgo_totope into routine arrt_imp_dati_cgo_sched_tabs_multitry returns two or more records. This item should return only a record.");
                            CPStdCounter.Error(l_oErrorFault);
                          }
                          Read_Cursor.Close();
                        } else {
                          // Error: no record found!
                          _codsog = "";
                          Read_Cursor.Close();
                          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                        }
                        /* If Empty(LRTrim(_codsog)) */
                        if (CPLib.Empty(CPLib.LRTrim(_codsog))) {
                          // * --- Insert into cgo_totope from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("cgo_totope");
                          m_cPhName = m_Ctx.GetPhName("cgo_totope");
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"cgo_totope")+" (";
                          m_cSql = m_cSql+GetFieldsName_05D0EF28(m_Ctx);
                          m_cSql = m_cSql+") values (";
                          m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("TOTLIRE"),"?",0,0)+", ";
                          if (m_Ctx.IsSharedTemp("cgo_totope")) {
                            m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                          }
                          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_totope",true);
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
                          // * --- Write into cgo_totope from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("cgo_totope");
                          m_cPhName = m_Ctx.GetPhName("cgo_totope");
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = "Update "+m_cPhName+" set ";
                          m_cSql = m_cSql+"TONUMOPE = TONUMOPE+"+CPLib.ToSQL(1,"N",10,0)+", ";
                          m_cSql = m_cSql+"TOIMPORT = TOIMPORT+"+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("TOTLIRE"),"N",12,2)+", ";
                          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_totope",false,true);
                          m_cSql = m_cSql+" where ";
                          m_cSql = m_cSql+"TODATOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_datope,"?",0,0,m_cServer),m_cServer,_datope)+"";
                          m_cSql = m_cSql+" and TOCODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_codsog,"?",0,0,m_cServer),m_cServer,_codsog)+"";
                          m_cSql = m_cSql+" and TO_SEGNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_segno,"?",0,0,m_cServer),m_cServer,_segno)+"";
                          if (m_Ctx.IsSharedTemp("cgo_totope")) {
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
                        Cursor_xntestbo.Next();
                      }
                      m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
                      Cursor_xntestbo.Close();
                      // * --- End Select
                    } // End If
                    /* If _mezpagam='I' or _mezpagam='E' or _mezpagam='P' */
                    if (CPLib.eqr(_mezpagam,"I") || CPLib.eqr(_mezpagam,"E") || CPLib.eqr(_mezpagam,"P")) {
                      // * --- Select from personbo
                      m_cServer = m_Ctx.GetServer("personbo");
                      m_cPhName = m_Ctx.GetPhName("personbo");
                      if (Cursor_personbo!=null)
                        Cursor_personbo.Close();
                      Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(xCF,"?",0,0,m_cServer, m_oParameters),m_cServer,xCF)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      while ( ! (Cursor_personbo.Eof())) {
                        // * --- Write into xperazbo from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("xperazbo");
                        m_cPhName = m_Ctx.GetPhName("xperazbo");
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = "Update "+m_cPhName+" set ";
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
                        if (m_Ctx.IsSharedTemp("xperazbo")) {
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
                        Cursor_personbo.Next();
                      }
                      m_cConnectivityError = Cursor_personbo.ErrorMessage();
                      Cursor_personbo.Close();
                      // * --- End Select
                    } // End If
                    /* If not(Empty(cgo_telematico->IBAN)) */
                    if ( ! (CPLib.Empty(Cursor_cgo_telematico.GetString("IBAN")))) {
                      /* If Left(cgo_telematico->IBAN,2)='IT' */
                      if (CPLib.eqr(CPLib.Left(Cursor_cgo_telematico.GetString("IBAN"),2),"IT")) {
                        /* abicab := Substr(cgo_telematico->IBAN,6,5)+"-"+Substr(cgo_telematico->IBAN,11,5) */
                        abicab = CPLib.Substr(Cursor_cgo_telematico.GetString("IBAN"),6,5)+"-"+CPLib.Substr(Cursor_cgo_telematico.GetString("IBAN"),11,5);
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
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = "Update "+m_cPhName+" set ";
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
                          if (m_Ctx.IsSharedTemp("xperazbo")) {
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
                          Cursor_inter2bo.Next();
                        }
                        m_cConnectivityError = Cursor_inter2bo.ErrorMessage();
                        Cursor_inter2bo.Close();
                        // * --- End Select
                      } else { // Else
                        /* abicab := Left(cgo_telematico->IBAN,11) */
                        abicab = CPLib.Left(Cursor_cgo_telematico.GetString("IBAN"),11);
                        // * --- Write into xperazbo from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("xperazbo");
                        m_cPhName = m_Ctx.GetPhName("xperazbo");
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = "Update "+m_cPhName+" set ";
                        m_cSql = m_cSql+"CODINT2 = "+CPLib.ToSQL(abicab,"C",11,0,m_cServer)+", ";
                        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xperazbo",false,true);
                        m_cSql = m_cSql+" where ";
                        m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
                        if (m_Ctx.IsSharedTemp("xperazbo")) {
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
                    } // End If
                    /* oNumero := oNumero + 1 */
                    oNumero = CPLib.Round(oNumero+1,0);
                  } else { // Else
                    /* cOpeProg1 := Utilities.GetAutonumber("POPERAZ1\'"+LRTrim(_gAzienda)+"'",'',10) */
                    cOpeProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ1\\'"+CPLib.LRTrim(_gAzienda)+"'","",10);
                    /* cOpeProg2 := Utilities.GetAutonumber("POPERAZ2\'"+LRTrim(_gAzienda)+"'",'',11) */
                    cOpeProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ2\\'"+CPLib.LRTrim(_gAzienda)+"'","",11);
                    /* nProgImp := Utilities.GetAutonumber("PRGIMPOPE\'"+LRTrim(_gAzienda)+"'",0,15) */
                    nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOPE\\'"+CPLib.LRTrim(_gAzienda)+"'",0,15),0);
                    /* nIntest := 1 */
                    nIntest = CPLib.Round(1,0);
                    // * --- Insert into operazbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("operazbo");
                    m_cPhName = m_Ctx.GetPhName("operazbo");
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.InsertIntoStatement(m_Ctx,"operazbo")+" (";
                    m_cSql = m_cSql+GetFieldsName_05F5CA98(m_Ctx);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_codana,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_cabinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_codsin,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_citinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("DUCOLLEG"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tiporap,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(xData+cOpeProg2+"0","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("IPCOLLEG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDateTime("ORACOLLEG"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_prvinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CAIDBIGLIETTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tipope,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("TOTLIRE")*100,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("ENV"),"?",0,0,m_cServer)+", ";
                    if (m_Ctx.IsSharedTemp("operazbo")) {
                      m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                    }
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
                    /* If _locrap='D' */
                    if (CPLib.eqr(_locrap,"D")) {
                      // * --- Select from intestbo
                      m_cServer = m_Ctx.GetServer("intestbo");
                      m_cPhName = m_Ctx.GetPhName("intestbo");
                      if (Cursor_intestbo!=null)
                        Cursor_intestbo.Close();
                      Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_cgo_telematico.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      while ( ! (Cursor_intestbo.Eof())) {
                        /* If nIntest=1 */
                        if (CPLib.eqr(nIntest,1)) {
                          /* xCF := intestbo->CODINTER */
                          xCF = Cursor_intestbo.GetString("CODINTER");
                          // * --- Write into operazbo from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("operazbo");
                          m_cPhName = m_Ctx.GetPhName("operazbo");
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = "Update "+m_cPhName+" set ";
                          m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
                          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
                          m_cSql = m_cSql+" where ";
                          m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
                          if (m_Ctx.IsSharedTemp("operazbo")) {
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
                        } else { // Else
                          // * --- Insert into clientiope from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("clientiope");
                          m_cPhName = m_Ctx.GetPhName("clientiope");
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"clientiope")+" (";
                          m_cSql = m_cSql+GetFieldsName_05B64F10(m_Ctx);
                          m_cSql = m_cSql+") values (";
                          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                          if (m_Ctx.IsSharedTemp("clientiope")) {
                            m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                          }
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
                        /* nIntest := nIntest + 1 */
                        nIntest = CPLib.Round(nIntest+1,0);
                        /* _codsog := '' */
                        _codsog = "";
                        // * --- Read from cgo_totope
                        m_cServer = m_Ctx.GetServer("cgo_totope");
                        m_cPhName = m_Ctx.GetPhName("cgo_totope");
                        m_cSql = "";
                        m_cSql = m_cSql+"TODATOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_datope,"D",8,0,m_cServer),m_cServer,_datope);
                        m_cSql = m_cSql+" and TOCODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"C",16,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"));
                        m_cSql = m_cSql+" and TO_SEGNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_segno,"C",1,0,m_cServer),m_cServer,_segno);
                        if (m_Ctx.IsSharedTemp("cgo_totope")) {
                          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                        }
                        if (Read_Cursor!=null)
                          Read_Cursor.Close();
                        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("TOCODSOG",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                        if ( ! (Read_Cursor.Eof())) {
                          _codsog = Read_Cursor.GetString("TOCODSOG");
                          Read_Cursor.Next();
                          if ( ! (Read_Cursor.Eof())) {
                            Error l_oErrorFault = new Error("Read on cgo_totope into routine arrt_imp_dati_cgo_sched_tabs_multitry returns two or more records. This item should return only a record.");
                            CPStdCounter.Error(l_oErrorFault);
                          }
                          Read_Cursor.Close();
                        } else {
                          // Error: no record found!
                          _codsog = "";
                          Read_Cursor.Close();
                          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                        }
                        /* If Empty(LRTrim(_codsog)) */
                        if (CPLib.Empty(CPLib.LRTrim(_codsog))) {
                          // * --- Insert into cgo_totope from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("cgo_totope");
                          m_cPhName = m_Ctx.GetPhName("cgo_totope");
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"cgo_totope")+" (";
                          m_cSql = m_cSql+GetFieldsName_05F7EE90(m_Ctx);
                          m_cSql = m_cSql+") values (";
                          m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("TOTLIRE"),"?",0,0)+", ";
                          if (m_Ctx.IsSharedTemp("cgo_totope")) {
                            m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                          }
                          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_totope",true);
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
                          // * --- Write into cgo_totope from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("cgo_totope");
                          m_cPhName = m_Ctx.GetPhName("cgo_totope");
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = "Update "+m_cPhName+" set ";
                          m_cSql = m_cSql+"TONUMOPE = TONUMOPE+"+CPLib.ToSQL(1,"N",10,0)+", ";
                          m_cSql = m_cSql+"TOIMPORT = TOIMPORT+"+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("TOTLIRE"),"N",12,2)+", ";
                          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_totope",false,true);
                          m_cSql = m_cSql+" where ";
                          m_cSql = m_cSql+"TODATOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_datope,"?",0,0,m_cServer),m_cServer,_datope)+"";
                          m_cSql = m_cSql+" and TOCODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_codsog,"?",0,0,m_cServer),m_cServer,_codsog)+"";
                          m_cSql = m_cSql+" and TO_SEGNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_segno,"?",0,0,m_cServer),m_cServer,_segno)+"";
                          if (m_Ctx.IsSharedTemp("cgo_totope")) {
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
                        Cursor_intestbo.Next();
                      }
                      m_cConnectivityError = Cursor_intestbo.ErrorMessage();
                      Cursor_intestbo.Close();
                      // * --- End Select
                    } else { // Else
                      // * --- Select from xntestbo
                      m_cServer = m_Ctx.GetServer("xntestbo");
                      m_cPhName = m_Ctx.GetPhName("xntestbo");
                      if (Cursor_xntestbo!=null)
                        Cursor_xntestbo.Close();
                      Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_cgo_telematico.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      while ( ! (Cursor_xntestbo.Eof())) {
                        /* If nIntest=1 */
                        if (CPLib.eqr(nIntest,1)) {
                          /* xCF := xntestbo->CODINTER */
                          xCF = Cursor_xntestbo.GetString("CODINTER");
                          // * --- Write into operazbo from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("operazbo");
                          m_cPhName = m_Ctx.GetPhName("operazbo");
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = "Update "+m_cPhName+" set ";
                          m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
                          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
                          m_cSql = m_cSql+" where ";
                          m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
                          if (m_Ctx.IsSharedTemp("operazbo")) {
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
                        } else { // Else
                          // * --- Insert into clientiope from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("clientiope");
                          m_cPhName = m_Ctx.GetPhName("clientiope");
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"clientiope")+" (";
                          m_cSql = m_cSql+GetFieldsName_0622D0C0(m_Ctx);
                          m_cSql = m_cSql+") values (";
                          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                          if (m_Ctx.IsSharedTemp("clientiope")) {
                            m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                          }
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
                        /* nIntest := nIntest + 1 */
                        nIntest = CPLib.Round(nIntest+1,0);
                        /* _codsog := '' */
                        _codsog = "";
                        // * --- Read from cgo_totope
                        m_cServer = m_Ctx.GetServer("cgo_totope");
                        m_cPhName = m_Ctx.GetPhName("cgo_totope");
                        m_cSql = "";
                        m_cSql = m_cSql+"TODATOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_datope,"D",8,0,m_cServer),m_cServer,_datope);
                        m_cSql = m_cSql+" and TOCODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"C",16,0,m_cServer),m_cServer,Cursor_xntestbo.GetString("CODINTER"));
                        m_cSql = m_cSql+" and TO_SEGNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_segno,"C",1,0,m_cServer),m_cServer,_segno);
                        if (m_Ctx.IsSharedTemp("cgo_totope")) {
                          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                        }
                        if (Read_Cursor!=null)
                          Read_Cursor.Close();
                        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("TOCODSOG",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                        if ( ! (Read_Cursor.Eof())) {
                          _codsog = Read_Cursor.GetString("TOCODSOG");
                          Read_Cursor.Next();
                          if ( ! (Read_Cursor.Eof())) {
                            Error l_oErrorFault = new Error("Read on cgo_totope into routine arrt_imp_dati_cgo_sched_tabs_multitry returns two or more records. This item should return only a record.");
                            CPStdCounter.Error(l_oErrorFault);
                          }
                          Read_Cursor.Close();
                        } else {
                          // Error: no record found!
                          _codsog = "";
                          Read_Cursor.Close();
                          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                        }
                        /* If Empty(LRTrim(_codsog)) */
                        if (CPLib.Empty(CPLib.LRTrim(_codsog))) {
                          // * --- Insert into cgo_totope from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("cgo_totope");
                          m_cPhName = m_Ctx.GetPhName("cgo_totope");
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"cgo_totope")+" (";
                          m_cSql = m_cSql+GetFieldsName_060DDEF8(m_Ctx);
                          m_cSql = m_cSql+") values (";
                          m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("TOTLIRE"),"?",0,0)+", ";
                          if (m_Ctx.IsSharedTemp("cgo_totope")) {
                            m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                          }
                          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_totope",true);
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
                          // * --- Write into cgo_totope from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("cgo_totope");
                          m_cPhName = m_Ctx.GetPhName("cgo_totope");
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = "Update "+m_cPhName+" set ";
                          m_cSql = m_cSql+"TONUMOPE = TONUMOPE+"+CPLib.ToSQL(1,"N",10,0)+", ";
                          m_cSql = m_cSql+"TOIMPORT = TOIMPORT+"+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("TOTLIRE"),"N",12,2)+", ";
                          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_totope",false,true);
                          m_cSql = m_cSql+" where ";
                          m_cSql = m_cSql+"TODATOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_datope,"?",0,0,m_cServer),m_cServer,_datope)+"";
                          m_cSql = m_cSql+" and TOCODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_codsog,"?",0,0,m_cServer),m_cServer,_codsog)+"";
                          m_cSql = m_cSql+" and TO_SEGNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_segno,"?",0,0,m_cServer),m_cServer,_segno)+"";
                          if (m_Ctx.IsSharedTemp("cgo_totope")) {
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
                        Cursor_xntestbo.Next();
                      }
                      m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
                      Cursor_xntestbo.Close();
                      // * --- End Select
                    } // End If
                    /* If _mezpagam='I' or _mezpagam='E' or _mezpagam='P' */
                    if (CPLib.eqr(_mezpagam,"I") || CPLib.eqr(_mezpagam,"E") || CPLib.eqr(_mezpagam,"P")) {
                      // * --- Select from personbo
                      m_cServer = m_Ctx.GetServer("personbo");
                      m_cPhName = m_Ctx.GetPhName("personbo");
                      if (Cursor_personbo!=null)
                        Cursor_personbo.Close();
                      Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(xCF,"?",0,0,m_cServer, m_oParameters),m_cServer,xCF)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      while ( ! (Cursor_personbo.Eof())) {
                        // * --- Write into operazbo from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("operazbo");
                        m_cPhName = m_Ctx.GetPhName("operazbo");
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = "Update "+m_cPhName+" set ";
                        m_cSql = m_cSql+"C_RAG = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                        m_cSql = m_cSql+"C_STA = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                        m_cSql = m_cSql+"C_CTA = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                        m_cSql = m_cSql+"C_CAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                        m_cSql = m_cSql+"C_PRV = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                        m_cSql = m_cSql+"C_IND = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                        m_cSql = m_cSql+"C_CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",5,0,m_cServer)+", ";
                        m_cSql = m_cSql+"CONNESBEN = "+CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"C",16,0,m_cServer)+", ";
                        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
                        m_cSql = m_cSql+" where ";
                        m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
                        if (m_Ctx.IsSharedTemp("operazbo")) {
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
                        Cursor_personbo.Next();
                      }
                      m_cConnectivityError = Cursor_personbo.ErrorMessage();
                      Cursor_personbo.Close();
                      // * --- End Select
                    } // End If
                    /* If not(Empty(cgo_telematico->IBAN)) */
                    if ( ! (CPLib.Empty(Cursor_cgo_telematico.GetString("IBAN")))) {
                      /* If Left(cgo_telematico->IBAN,2)='IT' */
                      if (CPLib.eqr(CPLib.Left(Cursor_cgo_telematico.GetString("IBAN"),2),"IT")) {
                        /* abicab := Substr(cgo_telematico->IBAN,6,5)+"-"+Substr(cgo_telematico->IBAN,11,5) */
                        abicab = CPLib.Substr(Cursor_cgo_telematico.GetString("IBAN"),6,5)+"-"+CPLib.Substr(Cursor_cgo_telematico.GetString("IBAN"),11,5);
                        // * --- Select from inter2bo
                        m_cServer = m_Ctx.GetServer("inter2bo");
                        m_cPhName = m_Ctx.GetPhName("inter2bo");
                        if (Cursor_inter2bo!=null)
                          Cursor_inter2bo.Close();
                        Cursor_inter2bo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(abicab,"?",0,0,m_cServer, m_oParameters),m_cServer,abicab)+" "+")"+(m_Ctx.IsSharedTemp("inter2bo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                        while ( ! (Cursor_inter2bo.Eof())) {
                          // * --- Write into operazbo from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("operazbo");
                          m_cPhName = m_Ctx.GetPhName("operazbo");
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = "Update "+m_cPhName+" set ";
                          m_cSql = m_cSql+"TIPOINT2 = "+CPLib.ToSQL(Cursor_inter2bo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
                          m_cSql = m_cSql+"CODINT2 = "+CPLib.ToSQL(abicab,"C",11,0,m_cServer)+", ";
                          m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_inter2bo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                          m_cSql = m_cSql+"DESC2 = "+CPLib.ToSQL(Cursor_inter2bo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                          m_cSql = m_cSql+"PROV2 = "+CPLib.ToSQL(Cursor_inter2bo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                          m_cSql = m_cSql+"CODCAB2 = "+CPLib.ToSQL(Cursor_inter2bo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                          m_cSql = m_cSql+"DESCINTER = "+CPLib.ToSQL(Cursor_inter2bo.GetString("RAGSOC"),"C",50,0,m_cServer)+", ";
                          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
                          m_cSql = m_cSql+" where ";
                          m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
                          if (m_Ctx.IsSharedTemp("operazbo")) {
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
                          Cursor_inter2bo.Next();
                        }
                        m_cConnectivityError = Cursor_inter2bo.ErrorMessage();
                        Cursor_inter2bo.Close();
                        // * --- End Select
                      } else { // Else
                        /* abicab := Left(cgo_telematico->IBAN,11) */
                        abicab = CPLib.Left(Cursor_cgo_telematico.GetString("IBAN"),11);
                        // * --- Write into operazbo from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("operazbo");
                        m_cPhName = m_Ctx.GetPhName("operazbo");
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = "Update "+m_cPhName+" set ";
                        m_cSql = m_cSql+"CODINT2 = "+CPLib.ToSQL(abicab,"C",11,0,m_cServer)+", ";
                        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
                        m_cSql = m_cSql+" where ";
                        m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
                        if (m_Ctx.IsSharedTemp("operazbo")) {
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
                    } // End If
                    /* oNumero := oNumero + 1 */
                    oNumero = CPLib.Round(oNumero+1,0);
                  } // End If
                } else { // Else
                  /* If w_tipodest='P' */
                  if (CPLib.eqr(w_tipodest,"P")) {
                    /* cOpeProg1 := Utilities.GetAutonumber("PPFRAZ1\'"+LRTrim(_gAzienda)+"'",'',10) */
                    cOpeProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PPFRAZ1\\'"+CPLib.LRTrim(_gAzienda)+"'","",10);
                    /* cOpeProg2 := Utilities.GetAutonumber("PPFRAZ2\'"+LRTrim(_gAzienda)+"'",'',11) */
                    cOpeProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PPFRAZ2\\'"+CPLib.LRTrim(_gAzienda)+"'","",11);
                    /* nProgImp := Utilities.GetAutonumber("PRGIMPFRZ\'"+LRTrim(_gAzienda)+"'",0,15) */
                    nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPFRZ\\'"+CPLib.LRTrim(_gAzienda)+"'",0,15),0);
                    /* nIntest := 1 */
                    nIntest = CPLib.Round(1,0);
                    // * --- Insert into xraziobo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("xraziobo");
                    m_cPhName = m_Ctx.GetPhName("xraziobo");
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.InsertIntoStatement(m_Ctx,"xraziobo")+" (";
                    m_cSql = m_cSql+GetFieldsName_04191610(m_Ctx);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_codana,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_cabinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_codsin,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_citinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("DUCOLLEG"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tiporap,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(xData+cOpeProg2+"0","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("IPCOLLEG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDateTime("ORACOLLEG"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_prvinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CAIDBIGLIETTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tipope,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("TOTLIRE")*100,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("ENV"),"?",0,0,m_cServer)+", ";
                    if (m_Ctx.IsSharedTemp("xraziobo")) {
                      m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                    }
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
                    /* If _locrap='D' */
                    if (CPLib.eqr(_locrap,"D")) {
                      // * --- Select from intestbo
                      m_cServer = m_Ctx.GetServer("intestbo");
                      m_cPhName = m_Ctx.GetPhName("intestbo");
                      if (Cursor_intestbo!=null)
                        Cursor_intestbo.Close();
                      Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_cgo_telematico.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      while ( ! (Cursor_intestbo.Eof())) {
                        /* If nIntest=1 */
                        if (CPLib.eqr(nIntest,1)) {
                          /* xCF := intestbo->CODINTER */
                          xCF = Cursor_intestbo.GetString("CODINTER");
                          // * --- Write into xraziobo from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("xraziobo");
                          m_cPhName = m_Ctx.GetPhName("xraziobo");
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = "Update "+m_cPhName+" set ";
                          m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
                          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xraziobo",false,true);
                          m_cSql = m_cSql+" where ";
                          m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
                          if (m_Ctx.IsSharedTemp("xraziobo")) {
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
                        } else { // Else
                          // * --- Insert into xlientifrz from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("xlientifrz");
                          m_cPhName = m_Ctx.GetPhName("xlientifrz");
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"xlientifrz")+" (";
                          m_cSql = m_cSql+GetFieldsName_05EDA680(m_Ctx);
                          m_cSql = m_cSql+") values (";
                          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                          if (m_Ctx.IsSharedTemp("xlientifrz")) {
                            m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                          }
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
                        } // End If
                        /* nIntest := nIntest + 1 */
                        nIntest = CPLib.Round(nIntest+1,0);
                        Cursor_intestbo.Next();
                      }
                      m_cConnectivityError = Cursor_intestbo.ErrorMessage();
                      Cursor_intestbo.Close();
                      // * --- End Select
                    } else { // Else
                      // * --- Select from xntestbo
                      m_cServer = m_Ctx.GetServer("xntestbo");
                      m_cPhName = m_Ctx.GetPhName("xntestbo");
                      if (Cursor_xntestbo!=null)
                        Cursor_xntestbo.Close();
                      Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_cgo_telematico.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      while ( ! (Cursor_xntestbo.Eof())) {
                        /* If nIntest=1 */
                        if (CPLib.eqr(nIntest,1)) {
                          /* xCF := xntestbo->CODINTER */
                          xCF = Cursor_xntestbo.GetString("CODINTER");
                          // * --- Write into xraziobo from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("xraziobo");
                          m_cPhName = m_Ctx.GetPhName("xraziobo");
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = "Update "+m_cPhName+" set ";
                          m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
                          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xraziobo",false,true);
                          m_cSql = m_cSql+" where ";
                          m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
                          if (m_Ctx.IsSharedTemp("xraziobo")) {
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
                        } else { // Else
                          // * --- Insert into xlientifrz from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("xlientifrz");
                          m_cPhName = m_Ctx.GetPhName("xlientifrz");
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"xlientifrz")+" (";
                          m_cSql = m_cSql+GetFieldsName_072560F8(m_Ctx);
                          m_cSql = m_cSql+") values (";
                          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                          if (m_Ctx.IsSharedTemp("xlientifrz")) {
                            m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                          }
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
                        } // End If
                        /* nIntest := nIntest + 1 */
                        nIntest = CPLib.Round(nIntest+1,0);
                        Cursor_xntestbo.Next();
                      }
                      m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
                      Cursor_xntestbo.Close();
                      // * --- End Select
                    } // End If
                    /* If _mezpagam='I' or _mezpagam='E' or _mezpagam='P' */
                    if (CPLib.eqr(_mezpagam,"I") || CPLib.eqr(_mezpagam,"E") || CPLib.eqr(_mezpagam,"P")) {
                      // * --- Select from personbo
                      m_cServer = m_Ctx.GetServer("personbo");
                      m_cPhName = m_Ctx.GetPhName("personbo");
                      if (Cursor_personbo!=null)
                        Cursor_personbo.Close();
                      Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(xCF,"?",0,0,m_cServer, m_oParameters),m_cServer,xCF)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      while ( ! (Cursor_personbo.Eof())) {
                        // * --- Write into xraziobo from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("xraziobo");
                        m_cPhName = m_Ctx.GetPhName("xraziobo");
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = "Update "+m_cPhName+" set ";
                        m_cSql = m_cSql+"C_RAG = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                        m_cSql = m_cSql+"C_STA = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                        m_cSql = m_cSql+"C_CTA = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                        m_cSql = m_cSql+"C_CAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                        m_cSql = m_cSql+"C_PRV = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                        m_cSql = m_cSql+"C_IND = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                        m_cSql = m_cSql+"C_CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",5,0,m_cServer)+", ";
                        m_cSql = m_cSql+"CONNESBEN = "+CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"C",16,0,m_cServer)+", ";
                        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xraziobo",false,true);
                        m_cSql = m_cSql+" where ";
                        m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
                        if (m_Ctx.IsSharedTemp("xraziobo")) {
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
                        Cursor_personbo.Next();
                      }
                      m_cConnectivityError = Cursor_personbo.ErrorMessage();
                      Cursor_personbo.Close();
                      // * --- End Select
                    } // End If
                    /* If not(Empty(cgo_telematico->IBAN)) */
                    if ( ! (CPLib.Empty(Cursor_cgo_telematico.GetString("IBAN")))) {
                      /* If Left(cgo_telematico->IBAN,2)='IT' */
                      if (CPLib.eqr(CPLib.Left(Cursor_cgo_telematico.GetString("IBAN"),2),"IT")) {
                        /* abicab := Substr(cgo_telematico->IBAN,6,5)+"-"+Substr(cgo_telematico->IBAN,11,5) */
                        abicab = CPLib.Substr(Cursor_cgo_telematico.GetString("IBAN"),6,5)+"-"+CPLib.Substr(Cursor_cgo_telematico.GetString("IBAN"),11,5);
                        // * --- Select from inter2bo
                        m_cServer = m_Ctx.GetServer("inter2bo");
                        m_cPhName = m_Ctx.GetPhName("inter2bo");
                        if (Cursor_inter2bo!=null)
                          Cursor_inter2bo.Close();
                        Cursor_inter2bo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(abicab,"?",0,0,m_cServer, m_oParameters),m_cServer,abicab)+" "+")"+(m_Ctx.IsSharedTemp("inter2bo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                        while ( ! (Cursor_inter2bo.Eof())) {
                          // * --- Write into xraziobo from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("xraziobo");
                          m_cPhName = m_Ctx.GetPhName("xraziobo");
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = "Update "+m_cPhName+" set ";
                          m_cSql = m_cSql+"TIPOINT2 = "+CPLib.ToSQL(Cursor_inter2bo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
                          m_cSql = m_cSql+"CODINT2 = "+CPLib.ToSQL(abicab,"C",11,0,m_cServer)+", ";
                          m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_inter2bo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                          m_cSql = m_cSql+"DESC2 = "+CPLib.ToSQL(Cursor_inter2bo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                          m_cSql = m_cSql+"PROV2 = "+CPLib.ToSQL(Cursor_inter2bo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                          m_cSql = m_cSql+"CODCAB2 = "+CPLib.ToSQL(Cursor_inter2bo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                          m_cSql = m_cSql+"DESCINTER = "+CPLib.ToSQL(Cursor_inter2bo.GetString("RAGSOC"),"C",50,0,m_cServer)+", ";
                          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xraziobo",false,true);
                          m_cSql = m_cSql+" where ";
                          m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
                          if (m_Ctx.IsSharedTemp("xraziobo")) {
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
                          Cursor_inter2bo.Next();
                        }
                        m_cConnectivityError = Cursor_inter2bo.ErrorMessage();
                        Cursor_inter2bo.Close();
                        // * --- End Select
                      } else { // Else
                        /* abicab := Left(cgo_telematico->IBAN,11) */
                        abicab = CPLib.Left(Cursor_cgo_telematico.GetString("IBAN"),11);
                        // * --- Write into xraziobo from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("xraziobo");
                        m_cPhName = m_Ctx.GetPhName("xraziobo");
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = "Update "+m_cPhName+" set ";
                        m_cSql = m_cSql+"CODINT2 = "+CPLib.ToSQL(abicab,"C",11,0,m_cServer)+", ";
                        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xraziobo",false,true);
                        m_cSql = m_cSql+" where ";
                        m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
                        if (m_Ctx.IsSharedTemp("xraziobo")) {
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
                    } // End If
                    /* fNumero := fNumero + 1 */
                    fNumero = CPLib.Round(fNumero+1,0);
                  } else { // Else
                    /* cOpeProg1 := Utilities.GetAutonumber("PFRAZIO1\'"+LRTrim(_gAzienda)+"'",'',10) */
                    cOpeProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PFRAZIO1\\'"+CPLib.LRTrim(_gAzienda)+"'","",10);
                    /* cOpeProg2 := Utilities.GetAutonumber("PFRAZIO2\'"+LRTrim(_gAzienda)+"'",'',11) */
                    cOpeProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PFRAZIO2\\'"+CPLib.LRTrim(_gAzienda)+"'","",11);
                    /* nProgImp := Utilities.GetAutonumber("PRGIMPFRZ\'"+LRTrim(_gAzienda)+"'",0,15) */
                    nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPFRZ\\'"+CPLib.LRTrim(_gAzienda)+"'",0,15),0);
                    /* nIntest := 1 */
                    nIntest = CPLib.Round(1,0);
                    // * --- Insert into fraziobo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("fraziobo");
                    m_cPhName = m_Ctx.GetPhName("fraziobo");
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.InsertIntoStatement(m_Ctx,"fraziobo")+" (";
                    m_cSql = m_cSql+GetFieldsName_05D0BF58(m_Ctx);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_codana,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_cabinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_codsin,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_citinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("DUCOLLEG"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tiporap,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(xData+cOpeProg2+"0","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("IPCOLLEG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDateTime("ORACOLLEG"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_prvinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CAIDBIGLIETTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tipope,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("TOTLIRE")*100,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("ENV"),"?",0,0,m_cServer)+", ";
                    if (m_Ctx.IsSharedTemp("fraziobo")) {
                      m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                    }
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
                    /* If _locrap='D' */
                    if (CPLib.eqr(_locrap,"D")) {
                      // * --- Select from intestbo
                      m_cServer = m_Ctx.GetServer("intestbo");
                      m_cPhName = m_Ctx.GetPhName("intestbo");
                      if (Cursor_intestbo!=null)
                        Cursor_intestbo.Close();
                      Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_cgo_telematico.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      while ( ! (Cursor_intestbo.Eof())) {
                        /* If nIntest=1 */
                        if (CPLib.eqr(nIntest,1)) {
                          /* xCF := intestbo->CODINTER */
                          xCF = Cursor_intestbo.GetString("CODINTER");
                          // * --- Write into fraziobo from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("fraziobo");
                          m_cPhName = m_Ctx.GetPhName("fraziobo");
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = "Update "+m_cPhName+" set ";
                          m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
                          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
                          m_cSql = m_cSql+" where ";
                          m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
                          if (m_Ctx.IsSharedTemp("fraziobo")) {
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
                        } else { // Else
                          // * --- Insert into clientifrz from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("clientifrz");
                          m_cPhName = m_Ctx.GetPhName("clientifrz");
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"clientifrz")+" (";
                          m_cSql = m_cSql+GetFieldsName_0641FC30(m_Ctx);
                          m_cSql = m_cSql+") values (";
                          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                          if (m_Ctx.IsSharedTemp("clientifrz")) {
                            m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                          }
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
                        /* nIntest := nIntest + 1 */
                        nIntest = CPLib.Round(nIntest+1,0);
                        Cursor_intestbo.Next();
                      }
                      m_cConnectivityError = Cursor_intestbo.ErrorMessage();
                      Cursor_intestbo.Close();
                      // * --- End Select
                    } else { // Else
                      // * --- Select from xntestbo
                      m_cServer = m_Ctx.GetServer("xntestbo");
                      m_cPhName = m_Ctx.GetPhName("xntestbo");
                      if (Cursor_xntestbo!=null)
                        Cursor_xntestbo.Close();
                      Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_cgo_telematico.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      while ( ! (Cursor_xntestbo.Eof())) {
                        /* If nIntest=1 */
                        if (CPLib.eqr(nIntest,1)) {
                          /* xCF := xntestbo->CODINTER */
                          xCF = Cursor_xntestbo.GetString("CODINTER");
                          // * --- Write into fraziobo from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("fraziobo");
                          m_cPhName = m_Ctx.GetPhName("fraziobo");
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = "Update "+m_cPhName+" set ";
                          m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
                          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
                          m_cSql = m_cSql+" where ";
                          m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
                          if (m_Ctx.IsSharedTemp("fraziobo")) {
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
                        } else { // Else
                          // * --- Insert into clientifrz from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("clientifrz");
                          m_cPhName = m_Ctx.GetPhName("clientifrz");
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"clientifrz")+" (";
                          m_cSql = m_cSql+GetFieldsName_05D02140(m_Ctx);
                          m_cSql = m_cSql+") values (";
                          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                          if (m_Ctx.IsSharedTemp("clientifrz")) {
                            m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                          }
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
                        /* nIntest := nIntest + 1 */
                        nIntest = CPLib.Round(nIntest+1,0);
                        Cursor_xntestbo.Next();
                      }
                      m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
                      Cursor_xntestbo.Close();
                      // * --- End Select
                    } // End If
                    /* If _mezpagam='I' or _mezpagam='E' or _mezpagam='P' */
                    if (CPLib.eqr(_mezpagam,"I") || CPLib.eqr(_mezpagam,"E") || CPLib.eqr(_mezpagam,"P")) {
                      // * --- Select from personbo
                      m_cServer = m_Ctx.GetServer("personbo");
                      m_cPhName = m_Ctx.GetPhName("personbo");
                      if (Cursor_personbo!=null)
                        Cursor_personbo.Close();
                      Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(xCF,"?",0,0,m_cServer, m_oParameters),m_cServer,xCF)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      while ( ! (Cursor_personbo.Eof())) {
                        // * --- Write into fraziobo from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("fraziobo");
                        m_cPhName = m_Ctx.GetPhName("fraziobo");
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = "Update "+m_cPhName+" set ";
                        m_cSql = m_cSql+"C_RAG = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                        m_cSql = m_cSql+"C_STA = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                        m_cSql = m_cSql+"C_CTA = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                        m_cSql = m_cSql+"C_CAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                        m_cSql = m_cSql+"C_PRV = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                        m_cSql = m_cSql+"C_IND = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                        m_cSql = m_cSql+"C_CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",5,0,m_cServer)+", ";
                        m_cSql = m_cSql+"CONNESBEN = "+CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"C",16,0,m_cServer)+", ";
                        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
                        m_cSql = m_cSql+" where ";
                        m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
                        if (m_Ctx.IsSharedTemp("fraziobo")) {
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
                        Cursor_personbo.Next();
                      }
                      m_cConnectivityError = Cursor_personbo.ErrorMessage();
                      Cursor_personbo.Close();
                      // * --- End Select
                    } // End If
                    /* If not(Empty(cgo_telematico->IBAN)) */
                    if ( ! (CPLib.Empty(Cursor_cgo_telematico.GetString("IBAN")))) {
                      /* If Left(cgo_telematico->IBAN,2)='IT' */
                      if (CPLib.eqr(CPLib.Left(Cursor_cgo_telematico.GetString("IBAN"),2),"IT")) {
                        /* abicab := Substr(cgo_telematico->IBAN,6,5)+"-"+Substr(cgo_telematico->IBAN,11,5) */
                        abicab = CPLib.Substr(Cursor_cgo_telematico.GetString("IBAN"),6,5)+"-"+CPLib.Substr(Cursor_cgo_telematico.GetString("IBAN"),11,5);
                        // * --- Select from inter2bo
                        m_cServer = m_Ctx.GetServer("inter2bo");
                        m_cPhName = m_Ctx.GetPhName("inter2bo");
                        if (Cursor_inter2bo!=null)
                          Cursor_inter2bo.Close();
                        Cursor_inter2bo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(abicab,"?",0,0,m_cServer, m_oParameters),m_cServer,abicab)+" "+")"+(m_Ctx.IsSharedTemp("inter2bo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                        while ( ! (Cursor_inter2bo.Eof())) {
                          // * --- Write into fraziobo from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("fraziobo");
                          m_cPhName = m_Ctx.GetPhName("fraziobo");
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = "Update "+m_cPhName+" set ";
                          m_cSql = m_cSql+"TIPOINT2 = "+CPLib.ToSQL(Cursor_inter2bo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
                          m_cSql = m_cSql+"CODINT2 = "+CPLib.ToSQL(abicab,"C",11,0,m_cServer)+", ";
                          m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_inter2bo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                          m_cSql = m_cSql+"DESC2 = "+CPLib.ToSQL(Cursor_inter2bo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                          m_cSql = m_cSql+"PROV2 = "+CPLib.ToSQL(Cursor_inter2bo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                          m_cSql = m_cSql+"CODCAB2 = "+CPLib.ToSQL(Cursor_inter2bo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                          m_cSql = m_cSql+"DESCINTER = "+CPLib.ToSQL(Cursor_inter2bo.GetString("RAGSOC"),"C",50,0,m_cServer)+", ";
                          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
                          m_cSql = m_cSql+" where ";
                          m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
                          if (m_Ctx.IsSharedTemp("fraziobo")) {
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
                          Cursor_inter2bo.Next();
                        }
                        m_cConnectivityError = Cursor_inter2bo.ErrorMessage();
                        Cursor_inter2bo.Close();
                        // * --- End Select
                      } else { // Else
                        /* abicab := Left(cgo_telematico->IBAN,11) */
                        abicab = CPLib.Left(Cursor_cgo_telematico.GetString("IBAN"),11);
                        // * --- Write into fraziobo from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("fraziobo");
                        m_cPhName = m_Ctx.GetPhName("fraziobo");
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = "Update "+m_cPhName+" set ";
                        m_cSql = m_cSql+"CODINT2 = "+CPLib.ToSQL(abicab,"C",11,0,m_cServer)+", ";
                        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
                        m_cSql = m_cSql+" where ";
                        m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
                        if (m_Ctx.IsSharedTemp("fraziobo")) {
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
                    } // End If
                    /* fNumero := fNumero + 1 */
                    fNumero = CPLib.Round(fNumero+1,0);
                  } // End If
                } // End If
                /* ElseIf cgo_telematico->ENV='A' or cgo_telematico->ENV='V' */
              } else if (CPLib.eqr(Cursor_cgo_telematico.GetString("ENV"),"A") || CPLib.eqr(Cursor_cgo_telematico.GetString("ENV"),"V")) {
                /* nProgImp := Utilities.GetAutonumber("PRGIMCGOA\'"+LRTrim(_gAzienda)+"'",0,15) */
                nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMCGOA\\'"+CPLib.LRTrim(_gAzienda)+"'",0,15),0);
                /* _flgvnp := 'A' */
                _flgvnp = "A";
                /* _flgvlt := 'A' */
                _flgvlt = "A";
                /* _numope := '' */
                _numope = "";
                /* If cgo_telematico->ENV='V' */
                if (CPLib.eqr(Cursor_cgo_telematico.GetString("ENV"),"V")) {
                  /* If cgo_telematico->TOTLIRE >= _limvlt */
                  if (CPLib.ge(Cursor_cgo_telematico.GetDouble("TOTLIRE"),_limvlt)) {
                    /* _flgvlt := 'S' */
                    _flgvlt = "S";
                  } // End If
                  /* _numope := '' */
                  _numope = "";
                  // * --- Select from cgo_operazioni_dl
                  m_cServer = m_Ctx.GetServer("cgo_operazioni_dl");
                  m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl");
                  if (Cursor_cgo_operazioni_dl!=null)
                    Cursor_cgo_operazioni_dl.Close();
                  Cursor_cgo_operazioni_dl = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select SNAINUMOPE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"DATAOPE= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_datope,"?",0,0,m_cServer, m_oParameters),m_cServer,_datope)+"  and  CODDIPE="+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CODDIPE"),"?",0,0)+"  and  TOTLIRE="+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("TOTLIRE"),"?",0,0)+"  and  CGOTIPOPE='V' "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni_dl")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_cgo_operazioni_dl.Eof())) {
                    /* _numope := cgo_operazioni_dl->SNAINUMOPE */
                    _numope = Cursor_cgo_operazioni_dl.GetString("SNAINUMOPE");
                    Cursor_cgo_operazioni_dl.Next();
                  }
                  m_cConnectivityError = Cursor_cgo_operazioni_dl.ErrorMessage();
                  Cursor_cgo_operazioni_dl.Close();
                  // * --- End Select
                } else { // Else
                  /* _idb := '' */
                  _idb = "";
                  /* _oidb := 'N' */
                  _oidb = "N";
                  /* _numope := '' */
                  _numope = "";
                  /* _seekid := iif(Right(LRTrim(cgo_telematico->CAIDBIGLIETTO),8)='00000000',Left(LRTrim(cgo_telematico->CAIDBIGLIETTO),12),cgo_telematico->CAIDBIGLIETTO) */
                  _seekid = (CPLib.eqr(CPLib.Right(CPLib.LRTrim(Cursor_cgo_telematico.GetString("CAIDBIGLIETTO")),8),"00000000")?CPLib.Left(CPLib.LRTrim(Cursor_cgo_telematico.GetString("CAIDBIGLIETTO")),12):Cursor_cgo_telematico.GetString("CAIDBIGLIETTO"));
                  // * --- Select from cgo_operazioni_dl
                  m_cServer = m_Ctx.GetServer("cgo_operazioni_dl");
                  m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl");
                  if (Cursor_cgo_operazioni_dl!=null)
                    Cursor_cgo_operazioni_dl.Close();
                  Cursor_cgo_operazioni_dl = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select SNAINUMOPE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"DATAOPE= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_datope,"?",0,0,m_cServer, m_oParameters),m_cServer,_datope)+"  and  CODDIPE="+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CODDIPE"),"?",0,0)+"  and  TOTLIRE="+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("TOTLIRE"),"?",0,0)+"  and  CAIDBIGLIETTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_seekid,"?",0,0,m_cServer, m_oParameters),m_cServer,_seekid)+"  and  CGOTIPOPE='A' "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni_dl")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_cgo_operazioni_dl.Eof())) {
                    /* _numope := cgo_operazioni_dl->SNAINUMOPE */
                    _numope = Cursor_cgo_operazioni_dl.GetString("SNAINUMOPE");
                    /* _idb := cgo_telematico->CAIDBIGLIETTO */
                    _idb = Cursor_cgo_telematico.GetString("CAIDBIGLIETTO");
                    Cursor_cgo_operazioni_dl.Next();
                  }
                  m_cConnectivityError = Cursor_cgo_operazioni_dl.ErrorMessage();
                  Cursor_cgo_operazioni_dl.Close();
                  // * --- End Select
                  /* If Empty(LRTrim(_numope)) */
                  if (CPLib.Empty(CPLib.LRTrim(_numope))) {
                    // * --- Select from cgo_operazioni_dl
                    m_cServer = m_Ctx.GetServer("cgo_operazioni_dl");
                    m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl");
                    if (Cursor_cgo_operazioni_dl!=null)
                      Cursor_cgo_operazioni_dl.Close();
                    Cursor_cgo_operazioni_dl = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select SNAINUMOPE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"DATAOPE= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_datope,"?",0,0,m_cServer, m_oParameters),m_cServer,_datope)+"  and  CODDIPE="+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CODDIPE"),"?",0,0)+"  and  CAIDBIGLIETTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_seekid,"?",0,0,m_cServer, m_oParameters),m_cServer,_seekid)+"  and  CGOTIPOPE='A' "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni_dl")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_cgo_operazioni_dl.Eof())) {
                      /* _numope := cgo_operazioni_dl->SNAINUMOPE */
                      _numope = Cursor_cgo_operazioni_dl.GetString("SNAINUMOPE");
                      /* _idb := cgo_telematico->CAIDBIGLIETTO */
                      _idb = Cursor_cgo_telematico.GetString("CAIDBIGLIETTO");
                      /* _oidb := 'S' */
                      _oidb = "S";
                      Cursor_cgo_operazioni_dl.Next();
                    }
                    m_cConnectivityError = Cursor_cgo_operazioni_dl.ErrorMessage();
                    Cursor_cgo_operazioni_dl.Close();
                    // * --- End Select
                  } // End If
                } // End If
                /* If not(Empty(LRTrim(_numope))) */
                if ( ! (CPLib.Empty(CPLib.LRTrim(_numope)))) {
                  // * --- Select from cgo_operazioni_dl
                  m_cServer = m_Ctx.GetServer("cgo_operazioni_dl");
                  m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl");
                  if (Cursor_cgo_operazioni_dl!=null)
                    Cursor_cgo_operazioni_dl.Close();
                  Cursor_cgo_operazioni_dl = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numope,"?",0,0,m_cServer, m_oParameters),m_cServer,_numope)+" "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni_dl")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_cgo_operazioni_dl.Eof())) {
                    // * --- Insert into cgo_operazioni from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("cgo_operazioni");
                    m_cPhName = m_Ctx.GetPhName("cgo_operazioni");
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.InsertIntoStatement(m_Ctx,"cgo_operazioni")+" (";
                    m_cSql = m_cSql+GetFieldsName_06108A00(m_Ctx);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_citinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_prvinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_cabinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_codana,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_codsin,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tiporap,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tipope,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("TOTLIRE"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CAIDBIGLIETTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDateTime("CADATAORA"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("CACODICE"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetDate("DATANASC"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetDate("DATARILASC"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("CAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("SESSO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetDate("DATAVALI"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("NOME"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetDouble("CFESTERO"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("PEP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("MEZPAGAM"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("IBAN"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("CGOFLGVLT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("CGOFLGVNP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("ENV"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_numope,"?",0,0,m_cServer)+", ";
                    if (m_Ctx.IsSharedTemp("cgo_operazioni")) {
                      m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                    }
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_operazioni",true);
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
                    Cursor_cgo_operazioni_dl.Next();
                  }
                  m_cConnectivityError = Cursor_cgo_operazioni_dl.ErrorMessage();
                  Cursor_cgo_operazioni_dl.Close();
                  // * --- End Select
                  /* If cgo_telematico->ENV='V' */
                  if (CPLib.eqr(Cursor_cgo_telematico.GetString("ENV"),"V")) {
                    /* _MsgAss := _MsgAss + 'Associata Operazione VLT n. '+_numope + NL */
                    _MsgAss = _MsgAss+"Associata Operazione VLT n. "+_numope+"\n";
                  } else { // Else
                    /* If _oidb='N' */
                    if (CPLib.eqr(_oidb,"N")) {
                      /* _MsgAss := _MsgAss + 'Associata Operazione Agenzia con ID Biglietto '+_idb+NL */
                      _MsgAss = _MsgAss+"Associata Operazione Agenzia con ID Biglietto "+_idb+"\n";
                    } else { // Else
                      /* _MsgAss := _MsgAss + 'Associata Operazione Agenzia con ID Biglietto '+_idb + ' (Solo ID)'+NL */
                      _MsgAss = _MsgAss+"Associata Operazione Agenzia con ID Biglietto "+_idb+" (Solo ID)"+"\n";
                    } // End If
                  } // End If
                  /* cProgImp := LRTrim(Str(nProgImp,15,0)) */
                  cProgImp = CPLib.LRTrim(CPLib.Str(nProgImp,15,0));
                  /* Exec Routine arrt_snai_oper_save(cProgImp,'X',_gAzienda) */
                  arrt_snai_oper_saveR.Make(m_Ctx,this).Run(cProgImp,"X",_gAzienda);
                } else { // Else
                  // * --- Insert into cgo_operazioni from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("cgo_operazioni");
                  m_cPhName = m_Ctx.GetPhName("cgo_operazioni");
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.InsertIntoStatement(m_Ctx,"cgo_operazioni")+" (";
                  m_cSql = m_cSql+GetFieldsName_05EAB8E8(m_Ctx);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_citinter,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_prvinter,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_cabinter,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_codana,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_codsin,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_tiporap,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_tipope,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("TOTLIRE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CAIDBIGLIETTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDateTime("CADATAORA"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("CACODICE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_flgvlt,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_flgvnp,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("ENV"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
                  if (m_Ctx.IsSharedTemp("cgo_operazioni")) {
                    m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                  }
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_operazioni",true);
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
                /* oNumero := oNumero + 1 */
                oNumero = CPLib.Round(oNumero+1,0);
              } // End If
            } else { // Else
              // * --- Insert into cgo_telematico_err from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cgo_telematico_err");
              m_cPhName = m_Ctx.GetPhName("cgo_telematico_err");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"cgo_telematico_err")+" (";
              m_cSql = m_cSql+GetFieldsName_06473760(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("SNAINUMOPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("ENV"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("TOTLIRE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("CACODICE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDateTime("CADATAORA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CAIDBIGLIETTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("CSMF_COD"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("NUM_CONC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("P_VEND"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("IPCOLLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDateTime("ORACOLLEG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("DUCOLLEG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("IBAN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_txterr,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("cgo_telematico_err")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_telematico_err",true);
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
              /* oNumErr := oNumErr + 1 */
              oNumErr = CPLib.Round(oNumErr+1,0);
            } // End If
            // * --- Delete from cgo_telematico
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cgo_telematico");
            m_cPhName = m_Ctx.GetPhName("cgo_telematico");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = "delete from "+m_cPhName;
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"SNAINUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_telematico.GetString("SNAINUMOPE"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_telematico.GetString("SNAINUMOPE"))+"";
            if (m_Ctx.IsSharedTemp("cgo_telematico")) {
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
            // Commit
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
            m_Sql.CompleteTransaction();
          } catch(Exception l_exeption) {
            Stop.ReactToException(l_exeption);
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            /* _gMsgProc := "Rilevati errori nell'impotazione dei file! Ricreare il file segnalato e rieseguire l'import dei dati. La procedura annullera automaticamente l'importazione" + NL */
            _gMsgProc = "Rilevati errori nell'impotazione dei file! Ricreare il file segnalato e rieseguire l'import dei dati. La procedura annullera automaticamente l'importazione"+"\n";
            /* _gMsgProc := _gMsgProc + 'Errore SQL: ' + m_Sql.TransactionErrorMessage() + NL */
            _gMsgProc = _gMsgProc+"Errore SQL: "+m_Sql.TransactionErrorMessage()+"\n";
            // Rollback
            m_Sql.AbortTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            m_bError = true;
            m_Sql.CompleteTransaction();
            /* cProg := Utilities.GetAutonumber("PRGLOG\'"+LRTrim(_gAzienda)+"'",'',20) */
            cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGLOG\\'"+CPLib.LRTrim(_gAzienda)+"'","",20);
            // * --- Insert into log_app from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("log_app");
            m_cPhName = m_Ctx.GetPhName("log_app");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.InsertIntoStatement(m_Ctx,"log_app")+" (";
            m_cSql = m_cSql+GetFieldsName_062242B0(m_Ctx);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Import Dati","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_gMsgProc,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Scheduler","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("ERRORS","?",0,0,m_cServer)+", ";
            if (m_Ctx.IsSharedTemp("log_app")) {
              m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
            }
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"log_app",true);
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
          } finally {
            if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry06335A58status,0)) {
              m_Sql.SetTransactionStatus(nTry06335A58status,cTry06335A58msg);
            }
          }
          Cursor_cgo_telematico.Next();
        }
        m_cConnectivityError = Cursor_cgo_telematico.ErrorMessage();
        Cursor_cgo_telematico.Close();
        // * --- End Select
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
        /* _gMsgProc := 'Operazioni Inserite: '+LRTrim(Str(oNumero,10,0)) + ' - Frazionate Inserite: '+LRTrim(Str(fNumero,10,0)) + NL+LRTrim(_MsgAss)+NL */
        _gMsgProc = "Operazioni Inserite: "+CPLib.LRTrim(CPLib.Str(oNumero,10,0))+" - Frazionate Inserite: "+CPLib.LRTrim(CPLib.Str(fNumero,10,0))+"\n"+CPLib.LRTrim(_MsgAss)+"\n";
        /* cProg := Utilities.GetAutonumber("PRGLOG\'"+LRTrim(_gAzienda)+"'",'',20) */
        cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGLOG\\'"+CPLib.LRTrim(_gAzienda)+"'","",20);
        // * --- Insert into log_app from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("log_app");
        m_cPhName = m_Ctx.GetPhName("log_app");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"log_app")+" (";
        m_cSql = m_cSql+GetFieldsName_05CA3608(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Import Dati","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_gMsgProc,"?",0,0,m_cServer, m_oParameters)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("OPERAZIONI","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Inseriti / Aggiornati "+CPLib.LRTrim(CPLib.Str(oNumero+fNumero,10,0)),"?",0,0,m_cServer)+", ";
        if (m_Ctx.IsSharedTemp("log_app")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"log_app",true);
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
        /* If oNumErr > 0 */
        if (CPLib.gt(oNumErr,0)) {
          /* _gMsgProc := 'Movimenti Scartati: '+LRTrim(Str(oNumErr,10,0)) + NL */
          _gMsgProc = "Movimenti Scartati: "+CPLib.LRTrim(CPLib.Str(oNumErr,10,0))+"\n";
          /* cProg := Utilities.GetAutonumber("PRGLOG\'"+LRTrim(_gAzienda)+"'",'',20) */
          cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGLOG\\'"+CPLib.LRTrim(_gAzienda)+"'","",20);
          // * --- Insert into log_app from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("log_app");
          m_cPhName = m_Ctx.GetPhName("log_app");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"log_app")+" (";
          m_cSql = m_cSql+GetFieldsName_05ED1D88(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Import Dati","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_gMsgProc,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("OPERAZIONI","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Scartati "+CPLib.LRTrim(CPLib.Str(oNumErr,10,0)),"?",0,0,m_cServer)+", ";
          if (m_Ctx.IsSharedTemp("log_app")) {
            m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
          }
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"log_app",true);
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
      } else { // Else
        /* _gMsgProc := "Nessuna Operazione/Frazionata Inserita" */
        _gMsgProc = "Nessuna Operazione/Frazionata Inserita";
        /* cProg := Utilities.GetAutonumber("PRGLOG\'"+LRTrim(_gAzienda)+"'",'',20) */
        cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGLOG\\'"+CPLib.LRTrim(_gAzienda)+"'","",20);
        // * --- Insert into log_app from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("log_app");
        m_cPhName = m_Ctx.GetPhName("log_app");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"log_app")+" (";
        m_cSql = m_cSql+GetFieldsName_07C8F200(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Import Dati","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_gMsgProc,"?",0,0,m_cServer, m_oParameters)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("OPERAZIONI","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("NO RECORDS","?",0,0,m_cServer)+", ";
        if (m_Ctx.IsSharedTemp("log_app")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"log_app",true);
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
    } finally {
      try {
        if (Cursor_qbe_cgo_telematico_totali!=null)
          Cursor_qbe_cgo_telematico_totali.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_cgo_telematico!=null)
          Cursor_cgo_telematico.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_anadip!=null)
          Cursor_anadip.Close();
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
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
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
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
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
        if (Cursor_cgo_operazioni_dl!=null)
          Cursor_cgo_operazioni_dl.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_6() throws Exception {
    CPResultSet Cursor_qbe_cgo_users_totali=null;
    CPResultSet Cursor_cgo_users=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_qbe_cpusers_max=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Import Utenti + Dipendenze */
      /* nUser Numeric(10, 0) */
      double nUser;
      nUser = 0;
      /* mUser Numeric(10, 0) */
      double mUser;
      mUser = 0;
      /* cPassword Char(20) */
      String cPassword;
      cPassword = CPLib.Space(20);
      /* Azzera variabili per i conteggi */
      /* _totale := 0 */
      _totale = CPLib.Round(0,0);
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      // * --- Select from qbe_cgo_users_totali
      if (Cursor_qbe_cgo_users_totali!=null)
        Cursor_qbe_cgo_users_totali.Close();
      Cursor_qbe_cgo_users_totali = new VQRHolder("qbe_cgo_users_totali",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_cgo_users_totali.Eof())) {
        /* _totale := qbe_cgo_users_totali->TOTUSR */
        _totale = CPLib.Round(Cursor_qbe_cgo_users_totali.GetDouble("TOTUSR"),0);
        Cursor_qbe_cgo_users_totali.Next();
      }
      m_cConnectivityError = Cursor_qbe_cgo_users_totali.ErrorMessage();
      Cursor_qbe_cgo_users_totali.Close();
      // * --- End Select
      /* If _totale > 0 */
      if (CPLib.gt(_totale,0)) {
        // * --- Select from cgo_users
        m_cServer = m_Ctx.GetServer("cgo_users");
        m_cPhName = m_Ctx.GetPhName("cgo_users");
        if (Cursor_cgo_users!=null)
          Cursor_cgo_users.Close();
        Cursor_cgo_users = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("cgo_users")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_cgo_users.Eof())) {
          // Begin Transaction
          m_Sql.RequireTransaction();
          double nTry062DEDF0status;
          nTry062DEDF0status = m_Sql.GetTransactionStatus();
          String cTry062DEDF0msg;
          cTry062DEDF0msg = m_Sql.TransactionErrorMessage();
          try {
            /* nUser := 0 */
            nUser = CPLib.Round(0,0);
            // * --- Read from cpusers
            m_cServer = m_Ctx.GetServer("cpusers");
            m_cPhName = m_Ctx.GetPhName("cpusers");
            m_cSql = "";
            m_cSql = m_cSql+"name="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_users.GetString("name"),"C",50,0,m_cServer),m_cServer,Cursor_cgo_users.GetString("name"));
            if (m_Ctx.IsSharedTemp("cpusers")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("code",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              nUser = Read_Cursor.GetDouble("code");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on cpusers into routine arrt_imp_dati_cgo_sched_tabs_multitry returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              nUser = 0;
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If nUser = 0 */
            if (CPLib.eqr(nUser,0)) {
              /* mUser := 0 */
              mUser = CPLib.Round(0,0);
              // * --- Select from qbe_cpusers_max
              if (Cursor_qbe_cpusers_max!=null)
                Cursor_qbe_cpusers_max.Close();
              Cursor_qbe_cpusers_max = new VQRHolder("qbe_cpusers_max",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
              while ( ! (Cursor_qbe_cpusers_max.Eof())) {
                /* mUser := qbe_cpusers_max->MAXUSR */
                mUser = CPLib.Round(Cursor_qbe_cpusers_max.GetDouble("MAXUSR"),0);
                Cursor_qbe_cpusers_max.Next();
              }
              m_cConnectivityError = Cursor_qbe_cpusers_max.ErrorMessage();
              Cursor_qbe_cpusers_max.Close();
              // * --- End Select
              /* mUser := mUser+1 */
              mUser = CPLib.Round(mUser+1,0);
              /* cPassword := CPLib.CriptPwd(mUser,'mitwebanti') */
              cPassword = CPLib.CriptPwd(mUser,"mitwebanti");
              // * --- Insert into cpusers from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cpusers");
              m_cPhName = m_Ctx.GetPhName("cpusers");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"cpusers")+" (";
              m_cSql = m_cSql+GetFieldsName_05EAD748(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(mUser,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_users.GetString("name"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cPassword,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("E","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_gAzienda,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_users.GetString("fullname"),"?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("cpusers")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpusers",true);
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
              // * --- Insert into cpusers_add from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cpusers_add");
              m_cPhName = m_Ctx.GetPhName("cpusers_add");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"cpusers_add")+" (";
              m_cSql = m_cSql+GetFieldsName_07CEFD80(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(mUser,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_users.GetString("coddip"),"?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("cpusers_add")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpusers_add",true);
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
              // * --- Insert into cpusrgrp from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cpusrgrp");
              m_cPhName = m_Ctx.GetPhName("cpusrgrp");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"cpusrgrp")+" (";
              m_cSql = m_cSql+GetFieldsName_05F35718(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(6,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mUser,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_gAzienda,"?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("cpusrgrp")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpusrgrp",true);
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
              /* uNumNew := uNumNew + 1 */
              uNumNew = CPLib.Round(uNumNew+1,0);
            } else { // Else
              // * --- Write into cpusers from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cpusers");
              m_cPhName = m_Ctx.GetPhName("cpusers");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = "Update "+m_cPhName+" set ";
              m_cSql = m_cSql+"fullname = "+CPLib.ToSQL(Cursor_cgo_users.GetString("fullname"),"C",60,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpusers",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"code = "+CPSql.SQLValueAdapter(CPLib.ToSQL(nUser,"?",0,0,m_cServer),m_cServer,nUser)+"";
              if (m_Ctx.IsSharedTemp("cpusers")) {
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
              // * --- Write into cpusers_add from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cpusers_add");
              m_cPhName = m_Ctx.GetPhName("cpusers_add");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = "Update "+m_cPhName+" set ";
              m_cSql = m_cSql+"CODDIP = "+CPLib.ToSQL(Cursor_cgo_users.GetString("coddip"),"C",6,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpusers_add",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"CODE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(nUser,"?",0,0,m_cServer),m_cServer,nUser)+"";
              if (m_Ctx.IsSharedTemp("cpusers_add")) {
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
              /* uNumMod := uNumMod + 1 */
              uNumMod = CPLib.Round(uNumMod+1,0);
            } // End If
            // * --- Delete from cgo_users
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cgo_users");
            m_cPhName = m_Ctx.GetPhName("cgo_users");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = "delete from "+m_cPhName;
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"name = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_users.GetString("name"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_users.GetString("name"))+"";
            if (m_Ctx.IsSharedTemp("cgo_users")) {
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
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
            // Commit
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
            m_Sql.CompleteTransaction();
          } catch(Exception l_exeption) {
            Stop.ReactToException(l_exeption);
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            /* _gMsgProc := "Rilevati errori nell'impotazione dei file! Ricreare il file segnalato e rieseguire l'import dei dati. La procedura annullera automaticamente l'importazione" + NL */
            _gMsgProc = "Rilevati errori nell'impotazione dei file! Ricreare il file segnalato e rieseguire l'import dei dati. La procedura annullera automaticamente l'importazione"+"\n";
            /* _gMsgProc := _gMsgProc + 'Errore SQL: ' + m_Sql.TransactionErrorMessage() + NL */
            _gMsgProc = _gMsgProc+"Errore SQL: "+m_Sql.TransactionErrorMessage()+"\n";
            // Rollback
            m_Sql.AbortTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            m_bError = true;
            m_Sql.CompleteTransaction();
            /* cProg := Utilities.GetAutonumber("PRGLOG\'"+LRTrim(_gAzienda)+"'",'',20) */
            cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGLOG\\'"+CPLib.LRTrim(_gAzienda)+"'","",20);
            // * --- Insert into log_app from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("log_app");
            m_cPhName = m_Ctx.GetPhName("log_app");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.InsertIntoStatement(m_Ctx,"log_app")+" (";
            m_cSql = m_cSql+GetFieldsName_05F49D58(m_Ctx);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Import Dati","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_gMsgProc,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Scheduler","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("ERRORS","?",0,0,m_cServer)+", ";
            if (m_Ctx.IsSharedTemp("log_app")) {
              m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
            }
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"log_app",true);
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
          } finally {
            if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry062DEDF0status,0)) {
              m_Sql.SetTransactionStatus(nTry062DEDF0status,cTry062DEDF0msg);
            }
          }
          Cursor_cgo_users.Next();
        }
        m_cConnectivityError = Cursor_cgo_users.ErrorMessage();
        Cursor_cgo_users.Close();
        // * --- End Select
        /* _gMsgProc := 'Utenti Inseriti: '+LRTrim(Str(uNumNew,10,0)) + ' - Utenti Aggiornati: '+LRTrim(Str(uNumMod,10,0)) + NL */
        _gMsgProc = "Utenti Inseriti: "+CPLib.LRTrim(CPLib.Str(uNumNew,10,0))+" - Utenti Aggiornati: "+CPLib.LRTrim(CPLib.Str(uNumMod,10,0))+"\n";
        /* cProg := Utilities.GetAutonumber("PRGLOG\'"+LRTrim(_gAzienda)+"'",'',20) */
        cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGLOG\\'"+CPLib.LRTrim(_gAzienda)+"'","",20);
        // * --- Insert into log_app from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("log_app");
        m_cPhName = m_Ctx.GetPhName("log_app");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"log_app")+" (";
        m_cSql = m_cSql+GetFieldsName_04178278(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Import Dati","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_gMsgProc,"?",0,0,m_cServer, m_oParameters)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("UTENTI","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Inseriti / Aggiornati "+CPLib.LRTrim(CPLib.Str(_conta,10,0)),"?",0,0,m_cServer)+", ";
        if (m_Ctx.IsSharedTemp("log_app")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"log_app",true);
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
        /* _gMsgProc := "Nessun Utente Inserito o Aggiornato" */
        _gMsgProc = "Nessun Utente Inserito o Aggiornato";
        /* cProg := Utilities.GetAutonumber("PRGLOG\'"+LRTrim(_gAzienda)+"'",'',20) */
        cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGLOG\\'"+CPLib.LRTrim(_gAzienda)+"'","",20);
        // * --- Insert into log_app from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("log_app");
        m_cPhName = m_Ctx.GetPhName("log_app");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"log_app")+" (";
        m_cSql = m_cSql+GetFieldsName_05DD8908(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Import Dati","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_gMsgProc,"?",0,0,m_cServer, m_oParameters)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("UTENTI","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("NO RECORDS","?",0,0,m_cServer)+", ";
        if (m_Ctx.IsSharedTemp("log_app")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"log_app",true);
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
    } finally {
      try {
        if (Cursor_qbe_cgo_users_totali!=null)
          Cursor_qbe_cgo_users_totali.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_cgo_users!=null)
          Cursor_cgo_users.Close();
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
        if (Cursor_qbe_cpusers_max!=null)
          Cursor_qbe_cpusers_max.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_7() throws Exception {
    CPResultSet Cursor_cgo_soggetti=null;
    CPResultSet Read_Cursor=null;
    try {
      /* Effettua le verifiche sui soggetti */
      /* _cdessta Char(40) */
      String _cdessta;
      _cdessta = CPLib.Space(40);
      /* _cdescit Char(40) */
      String _cdescit;
      _cdescit = CPLib.Space(40);
      /* _ctipdoc Char(2) */
      String _ctipdoc;
      _ctipdoc = CPLib.Space(2);
      // * --- Select from cgo_soggetti
      m_cServer = m_Ctx.GetServer("cgo_soggetti");
      m_cPhName = m_Ctx.GetPhName("cgo_soggetti");
      if (Cursor_cgo_soggetti!=null)
        Cursor_cgo_soggetti.Close();
      Cursor_cgo_soggetti = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codsog,"?",0,0,m_cServer, m_oParameters),m_cServer,_codsog)+" "+")"+(m_Ctx.IsSharedTemp("cgo_soggetti")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_cgo_soggetti.Eof())) {
        /* If Empty(cgo_soggetti->NASCOMUN) and Empty(cgo_soggetti->NASSTATO) */
        if (CPLib.Empty(Cursor_cgo_soggetti.GetString("NASCOMUN")) && CPLib.Empty(Cursor_cgo_soggetti.GetString("NASSTATO"))) {
          /* _txterr := _txterr + 'Manca il Comune o lo Stato di Nascita' + NL */
          _txterr = _txterr+"Manca il Comune o lo Stato di Nascita"+"\n";
          /* _recOK := 1 */
          _recOK = CPLib.Round(1,0);
        } else { // Else
          /* If Empty(cgo_soggetti->NASPROV) */
          if (CPLib.Empty(Cursor_cgo_soggetti.GetString("NASPROV"))) {
            /* _txterr := _txterr + 'Manca la provincia di Nascita' + NL */
            _txterr = _txterr+"Manca la provincia di Nascita"+"\n";
            /* _recOK := 1 */
            _recOK = CPLib.Round(1,0);
          } else { // Else
            /* If Upper(LRTrim(cgo_soggetti->NASPROV))='EE' */
            if (CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_cgo_soggetti.GetString("NASPROV"))),"EE")) {
              /* _cdessta := '' */
              _cdessta = "";
              // * --- Read from tbstati
              m_cServer = m_Ctx.GetServer("tbstati");
              m_cPhName = m_Ctx.GetPhName("tbstati");
              m_cSql = "";
              m_cSql = m_cSql+"DESCRI="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Upper(CPLib.LRTrim(Cursor_cgo_soggetti.GetString("NASSTATO"))),"C",40,0,m_cServer),m_cServer,CPLib.Upper(CPLib.LRTrim(Cursor_cgo_soggetti.GetString("NASSTATO"))));
              if (m_Ctx.IsSharedTemp("tbstati")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _cdessta = Read_Cursor.GetString("DESCRI");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbstati into routine arrt_imp_dati_cgo_sched_tabs_multitry returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _cdessta = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(_cdessta) */
              if (CPLib.Empty(_cdessta)) {
                /* _txterr := _txterr + 'Stato di nascita intestatario operazione errato' + NL */
                _txterr = _txterr+"Stato di nascita intestatario operazione errato"+"\n";
                /* _recOK := 1 */
                _recOK = CPLib.Round(1,0);
              } // End If
            } else { // Else
              /* _cdescit := '' */
              _cdescit = "";
              // * --- Read from tbcitta
              m_cServer = m_Ctx.GetServer("tbcitta");
              m_cPhName = m_Ctx.GetPhName("tbcitta");
              m_cSql = "";
              m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Upper(CPLib.LRTrim(Cursor_cgo_soggetti.GetString("NASCOMUN"))),"C",40,0,m_cServer),m_cServer,CPLib.Upper(CPLib.LRTrim(Cursor_cgo_soggetti.GetString("NASCOMUN"))));
              if (m_Ctx.IsSharedTemp("tbcitta")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _cdescit = Read_Cursor.GetString("CITTA");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_imp_dati_cgo_sched_tabs_multitry returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _cdescit = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(_cdescit) */
              if (CPLib.Empty(_cdescit)) {
                /* _txterr := _txterr + 'Città di nascita intestatario operazione errata' + NL */
                _txterr = _txterr+"Città di nascita intestatario operazione errata"+"\n";
                /* _recOK := 1 */
                _recOK = CPLib.Round(1,0);
              } // End If
            } // End If
          } // End If
        } // End If
        /* If Empty(LRTrim(cgo_soggetti->AUTRILASC)) */
        if (CPLib.Empty(CPLib.LRTrim(Cursor_cgo_soggetti.GetString("AUTRILASC")))) {
          /* _txterr := _txterr + 'Manca autorità rilascio del documento' + NL */
          _txterr = _txterr+"Manca autorità rilascio del documento"+"\n";
          /* _recOK := 1 */
          _recOK = CPLib.Round(1,0);
        } // End If
        /* If Empty(LRTrim(cgo_soggetti->NUMDOCUM)) */
        if (CPLib.Empty(CPLib.LRTrim(Cursor_cgo_soggetti.GetString("NUMDOCUM")))) {
          /* _txterr := _txterr + 'Manca numero documento identità' + NL */
          _txterr = _txterr+"Manca numero documento identità"+"\n";
          /* _recOK := 1 */
          _recOK = CPLib.Round(1,0);
        } // End If
        /* If Empty(LRTrim(cgo_soggetti->TIPODOC)) */
        if (CPLib.Empty(CPLib.LRTrim(Cursor_cgo_soggetti.GetString("TIPODOC")))) {
          /* _txterr := _txterr + 'Manca tipo documento identità' + NL */
          _txterr = _txterr+"Manca tipo documento identità"+"\n";
          /* _recOK := 1 */
          _recOK = CPLib.Round(1,0);
        } else { // Else
          /* _ctipdoc := '' */
          _ctipdoc = "";
          // * --- Read from tbtipdoc
          m_cServer = m_Ctx.GetServer("tbtipdoc");
          m_cPhName = m_Ctx.GetPhName("tbtipdoc");
          m_cSql = "";
          m_cSql = m_cSql+"TIPDOC="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_soggetti.GetString("TIPODOC"),"C",2,0,m_cServer),m_cServer,Cursor_cgo_soggetti.GetString("TIPODOC"));
          if (m_Ctx.IsSharedTemp("tbtipdoc")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("TIPDOC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _ctipdoc = Read_Cursor.GetString("TIPDOC");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on tbtipdoc into routine arrt_imp_dati_cgo_sched_tabs_multitry returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _ctipdoc = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(_ctipdoc)) */
          if (CPLib.Empty(CPLib.LRTrim(_ctipdoc))) {
            /* _txterr := _txterr + 'Tipo documento identità errato' + NL */
            _txterr = _txterr+"Tipo documento identità errato"+"\n";
            /* _recOK := 1 */
            _recOK = CPLib.Round(1,0);
          } // End If
        } // End If
        /* If Empty(cgo_soggetti->DATANASC) */
        if (CPLib.Empty(Cursor_cgo_soggetti.GetDate("DATANASC"))) {
          /* _txterr := _txterr + "Manca la data di nascita del soggetto" + NL */
          _txterr = _txterr+"Manca la data di nascita del soggetto"+"\n";
          /* _recOK := 1 */
          _recOK = CPLib.Round(1,0);
        } else { // Else
          /* If cgo_soggetti->DATANASC > Date() */
          if (CPLib.gt(Cursor_cgo_soggetti.GetDate("DATANASC"),CPLib.Date())) {
            /* _txterr := _txterr + "Data di nascita del soggetto errata" + NL */
            _txterr = _txterr+"Data di nascita del soggetto errata"+"\n";
            /* _recOK := 1 */
            _recOK = CPLib.Round(1,0);
          } // End If
        } // End If
        /* If Empty(cgo_soggetti->DATARILASC) */
        if (CPLib.Empty(Cursor_cgo_soggetti.GetDate("DATARILASC"))) {
          /* _txterr := _txterr + "Manca data rilascio del documento del soggetto" + NL */
          _txterr = _txterr+"Manca data rilascio del documento del soggetto"+"\n";
          /* _recOK := 1 */
          _recOK = CPLib.Round(1,0);
        } else { // Else
          /* If cgo_soggetti->DATARILASC > Date() */
          if (CPLib.gt(Cursor_cgo_soggetti.GetDate("DATARILASC"),CPLib.Date())) {
            /* _txterr := _txterr + "Data rilascio del documento del soggetto errata" + NL */
            _txterr = _txterr+"Data rilascio del documento del soggetto errata"+"\n";
            /* _recOK := 1 */
            _recOK = CPLib.Round(1,0);
          } // End If
        } // End If
        /* If Empty(cgo_soggetti->DATAVALI) */
        if (CPLib.Empty(Cursor_cgo_soggetti.GetDate("DATAVALI"))) {
          /* _txterr := _txterr + "Manca data scadenza del documento del soggetto" + NL */
          _txterr = _txterr+"Manca data scadenza del documento del soggetto"+"\n";
          /* _recOK := 0 */
          _recOK = CPLib.Round(0,0);
        } else { // Else
          /* If cgo_soggetti->DATAVALI < cgo_soggetti->DATARILASC */
          if (CPLib.lt(Cursor_cgo_soggetti.GetDate("DATAVALI"),Cursor_cgo_soggetti.GetDate("DATARILASC"))) {
            /* _txterr := _txterr + "Data scadenza del documento del soggetto inferiore alla data di rilascio" + NL */
            _txterr = _txterr+"Data scadenza del documento del soggetto inferiore alla data di rilascio"+"\n";
            /* _recOK := 1 */
            _recOK = CPLib.Round(1,0);
          } // End If
        } // End If
        /* If Empty(cgo_soggetti->PAESE) */
        if (CPLib.Empty(Cursor_cgo_soggetti.GetString("PAESE"))) {
          /* _txterr := _txterr + 'Manca il paese di residenza del soggetto' + NL */
          _txterr = _txterr+"Manca il paese di residenza del soggetto"+"\n";
          /* _recOK := 1 */
          _recOK = CPLib.Round(1,0);
        } else { // Else
          /* If cgo_soggetti->PAESE='086' */
          if (CPLib.eqr(Cursor_cgo_soggetti.GetString("PAESE"),"086")) {
            /* If Empty(cgo_soggetti->DOMICILIO) */
            if (CPLib.Empty(Cursor_cgo_soggetti.GetString("DOMICILIO"))) {
              /* _txterr := _txterr + "Manca il domicilio del soggetto" + NL */
              _txterr = _txterr+"Manca il domicilio del soggetto"+"\n";
              /* _recOK := 1 */
              _recOK = CPLib.Round(1,0);
            } // End If
            /* If Empty(cgo_soggetti->DESCCIT) */
            if (CPLib.Empty(Cursor_cgo_soggetti.GetString("DESCCIT"))) {
              /* _txterr := _txterr + 'Manca il comune di residenza' + NL */
              _txterr = _txterr+"Manca il comune di residenza"+"\n";
              /* _recOK := 1 */
              _recOK = CPLib.Round(1,0);
            } else { // Else
              /* _cdescit := '' */
              _cdescit = "";
              // * --- Read from tbcitta
              m_cServer = m_Ctx.GetServer("tbcitta");
              m_cPhName = m_Ctx.GetPhName("tbcitta");
              m_cSql = "";
              m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Upper(CPLib.LRTrim(Cursor_cgo_soggetti.GetString("DESCCIT"))),"C",40,0,m_cServer),m_cServer,CPLib.Upper(CPLib.LRTrim(Cursor_cgo_soggetti.GetString("DESCCIT"))));
              if (m_Ctx.IsSharedTemp("tbcitta")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _cdescit = Read_Cursor.GetString("CITTA");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_imp_dati_cgo_sched_tabs_multitry returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _cdescit = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(_cdescit) */
              if (CPLib.Empty(_cdescit)) {
                /* _txterr := _txterr + 'Città di residenza intestatario operazione errata' + NL */
                _txterr = _txterr+"Città di residenza intestatario operazione errata"+"\n";
                /* _recOK := 1 */
                _recOK = CPLib.Round(1,0);
              } // End If
            } // End If
          } else { // Else
            /* If Upper(LRTrim(cgo_soggetti->PROVINCIA)) <> 'EE' and not(Empty(cgo_soggetti->PROVINCIA)) */
            if (CPLib.ne(CPLib.Upper(CPLib.LRTrim(Cursor_cgo_soggetti.GetString("PROVINCIA"))),"EE") &&  ! (CPLib.Empty(Cursor_cgo_soggetti.GetString("PROVINCIA")))) {
              /* _txterr := _txterr + "Provincia errata per soggetto residente all'estero" + NL */
              _txterr = _txterr+"Provincia errata per soggetto residente all'estero"+"\n";
              /* _recOK := 1 */
              _recOK = CPLib.Round(1,0);
            } // End If
          } // End If
        } // End If
        Cursor_cgo_soggetti.Next();
      }
      m_cConnectivityError = Cursor_cgo_soggetti.ErrorMessage();
      Cursor_cgo_soggetti.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_cgo_soggetti!=null)
          Cursor_cgo_soggetti.Close();
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
  void Page_8() throws Exception {
    CPResultSet Cursor_cgo_telematico=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_rapopebo=null;
    CPResultSet Cursor_xapopebo=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_xntestbo=null;
    CPResultSet Cursor_personbo=null;
    try {
      // * --- Select from cgo_telematico
      m_cServer = m_Ctx.GetServer("cgo_telematico");
      m_cPhName = m_Ctx.GetPhName("cgo_telematico");
      if (Cursor_cgo_telematico!=null)
        Cursor_cgo_telematico.Close();
      Cursor_cgo_telematico = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_snainumope,"?",0,0,m_cServer, m_oParameters),m_cServer,_snainumope)+" "+")"+(m_Ctx.IsSharedTemp("cgo_telematico")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_cgo_telematico.Eof())) {
        /* If Empty(LRTrim(cgo_telematico->ENV)) */
        if (CPLib.Empty(CPLib.LRTrim(Cursor_cgo_telematico.GetString("ENV")))) {
          /* _txterr := _txterr + "Manca il tipo di operazione" + NL */
          _txterr = _txterr+"Manca il tipo di operazione"+"\n";
          /* _recOK := 1 */
          _recOK = CPLib.Round(1,0);
        } // End If
        /* If Empty(cgo_telematico->CACODICE) */
        if (CPLib.Empty(Cursor_cgo_telematico.GetDouble("CACODICE"))) {
          /* _txterr := _txterr + "Manca la causale dell'operazione" + NL */
          _txterr = _txterr+"Manca la causale dell'operazione"+"\n";
          /* _recOK := 1 */
          _recOK = CPLib.Round(1,0);
        } else { // Else
          /* If not(Empty(LRTrim(cgo_telematico->MEZPAGAM))) */
          if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_cgo_telematico.GetString("MEZPAGAM"))))) {
            /* _codcau := 0 */
            _codcau = CPLib.Round(0,0);
            // * --- Read from cgo_causali
            m_cServer = m_Ctx.GetServer("cgo_causali");
            m_cPhName = m_Ctx.GetPhName("cgo_causali");
            m_cSql = "";
            m_cSql = m_cSql+"CACODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("CACODICE"),"N",5,0,m_cServer),m_cServer,Cursor_cgo_telematico.GetDouble("CACODICE"));
            m_cSql = m_cSql+" and CATIPOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_telematico.GetString("MEZPAGAM"),"C",2,0,m_cServer),m_cServer,Cursor_cgo_telematico.GetString("MEZPAGAM"));
            if (m_Ctx.IsSharedTemp("cgo_causali")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CACODICE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _codcau = CPLib.Round(Read_Cursor.GetDouble("CACODICE"),0);
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on cgo_causali into routine arrt_imp_dati_cgo_sched_tabs_multitry returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _codcau = 0;
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If _codcau=0 */
            if (CPLib.eqr(_codcau,0)) {
              /* _txterr := _txterr + "Causale dell'operazione errata" + NL */
              _txterr = _txterr+"Causale dell'operazione errata"+"\n";
              /* _recOK := 1 */
              _recOK = CPLib.Round(1,0);
            } // End If
          } // End If
        } // End If
        /* If Empty(LRTrim(cgo_telematico->CAIDBIGLIETTO)) */
        if (CPLib.Empty(CPLib.LRTrim(Cursor_cgo_telematico.GetString("CAIDBIGLIETTO")))) {
          /* _txterr := _txterr + "Manca ID Biglietto all'operazione" + NL */
          _txterr = _txterr+"Manca ID Biglietto all'operazione"+"\n";
          /* _recOK := 1 */
          _recOK = CPLib.Round(1,0);
        } // End If
        /* If Empty(cgo_telematico->CADATAORA) */
        if (CPLib.Empty(Cursor_cgo_telematico.GetDateTime("CADATAORA"))) {
          /* _txterr := _txterr + "Mancano data e ora dell'operazione" + NL */
          _txterr = _txterr+"Mancano data e ora dell'operazione"+"\n";
          /* _recOK := 1 */
          _recOK = CPLib.Round(1,0);
        } else { // Else
          /* _datope := arfn_dttod(cgo_telematico->CADATAORA) */
          _datope = arfn_dttodR.Make(m_Ctx,this).Run(Cursor_cgo_telematico.GetDateTime("CADATAORA"));
        } // End If
        /* If Empty(cgo_telematico->CODDIPE) and cgo_telematico->ENV='A' */
        if (CPLib.Empty(Cursor_cgo_telematico.GetString("CODDIPE")) && CPLib.eqr(Cursor_cgo_telematico.GetString("ENV"),"A")) {
          /* _txterr := _txterr + "Mancano il codice agenzia dell'operazione" + NL */
          _txterr = _txterr+"Mancano il codice agenzia dell'operazione"+"\n";
          /* _recOK := 1 */
          _recOK = CPLib.Round(1,0);
        } // End If
        /* If cgo_telematico->ENV='W' */
        if (CPLib.eqr(Cursor_cgo_telematico.GetString("ENV"),"W")) {
          /* If Empty(LRTrim(cgo_telematico->MEZPAGAM)) */
          if (CPLib.Empty(CPLib.LRTrim(Cursor_cgo_telematico.GetString("MEZPAGAM")))) {
            /* _txterr := _txterr + "Manca il mezzo di pagamento dell'operazione" + NL */
            _txterr = _txterr+"Manca il mezzo di pagamento dell'operazione"+"\n";
            /* _recOK := 1 */
            _recOK = CPLib.Round(1,0);
          } // End If
          /* If Empty(cgo_telematico->DUCOLLEG) */
          if (CPLib.Empty(Cursor_cgo_telematico.GetDouble("DUCOLLEG"))) {
            /* _txterr := _txterr + "Mancano durata dell'operazione" + NL */
            _txterr = _txterr+"Mancano durata dell'operazione"+"\n";
            /* _recOK := 1 */
            _recOK = CPLib.Round(1,0);
          } // End If
          /* If Empty(cgo_telematico->IPCOLLEG) */
          if (CPLib.Empty(Cursor_cgo_telematico.GetString("IPCOLLEG"))) {
            /* _txterr := _txterr + "Manca ip collegamento dell'operazione" + NL */
            _txterr = _txterr+"Manca ip collegamento dell'operazione"+"\n";
            /* _recOK := 1 */
            _recOK = CPLib.Round(1,0);
          } // End If
          /* If Empty(cgo_telematico->ORACOLLEG) */
          if (CPLib.Empty(Cursor_cgo_telematico.GetDateTime("ORACOLLEG"))) {
            /* _txterr := _txterr + "Mancano data e ora inizio collegamento dell'operazione" + NL */
            _txterr = _txterr+"Mancano data e ora inizio collegamento dell'operazione"+"\n";
            /* _recOK := 1 */
            _recOK = CPLib.Round(1,0);
          } // End If
          /* If Empty(cgo_telematico->RAPPORTO) */
          if (CPLib.Empty(Cursor_cgo_telematico.GetString("RAPPORTO"))) {
            /* _txterr := _txterr + "Manca il rapporto collegato all'operazione" + NL */
            _txterr = _txterr+"Manca il rapporto collegato all'operazione"+"\n";
            /* _recOK := 1 */
            _recOK = CPLib.Round(1,0);
          } else { // Else
            /* _codrap := '' */
            _codrap = "";
            // * --- Read from anarapbo
            m_cServer = m_Ctx.GetServer("anarapbo");
            m_cPhName = m_Ctx.GetPhName("anarapbo");
            m_cSql = "";
            m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_telematico.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_cgo_telematico.GetString("RAPPORTO"));
            if (m_Ctx.IsSharedTemp("anarapbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _codrap = Read_Cursor.GetString("RAPPORTO");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on anarapbo into routine arrt_imp_dati_cgo_sched_tabs_multitry returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _codrap = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If not(Empty(LRTrim(_codrap))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(_codrap)))) {
              /* _datini := NullDate() */
              _datini = CPLib.NullDate();
              /* _datend := NullDate() */
              _datend = CPLib.NullDate();
              // * --- Select from rapopebo
              m_cServer = m_Ctx.GetServer("rapopebo");
              m_cPhName = m_Ctx.GetPhName("rapopebo");
              if (Cursor_rapopebo!=null)
                Cursor_rapopebo.Close();
              Cursor_rapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select DATAOPE,TIPOOPRAP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_cgo_telematico.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("rapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_rapopebo.Eof())) {
                /* If rapopebo->TIPOOPRAP='23' */
                if (CPLib.eqr(Cursor_rapopebo.GetString("TIPOOPRAP"),"23")) {
                  /* _datini := rapopebo->DATAOPE */
                  _datini = Cursor_rapopebo.GetDate("DATAOPE");
                  /* ElseIf rapopebo->TIPOOPRAP='26' */
                } else if (CPLib.eqr(Cursor_rapopebo.GetString("TIPOOPRAP"),"26")) {
                  /* _datend := rapopebo->DATAOPE */
                  _datend = Cursor_rapopebo.GetDate("DATAOPE");
                } // End If
                Cursor_rapopebo.Next();
              }
              m_cConnectivityError = Cursor_rapopebo.ErrorMessage();
              Cursor_rapopebo.Close();
              // * --- End Select
              /* If Empty(_datini) and Empty(_datend) */
              if (CPLib.Empty(_datini) && CPLib.Empty(_datend)) {
                // * --- Select from xapopebo
                m_cServer = m_Ctx.GetServer("xapopebo");
                m_cPhName = m_Ctx.GetPhName("xapopebo");
                if (Cursor_xapopebo!=null)
                  Cursor_xapopebo.Close();
                Cursor_xapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select DATAOPE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_cgo_telematico.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_xapopebo.Eof())) {
                  /* If xapopebo->TIPOOPRAP='23' */
                  if (CPLib.eqr(Cursor_xapopebo.GetString("TIPOOPRAP"),"23")) {
                    /* _datini := xapopebo->DATAOPE */
                    _datini = Cursor_xapopebo.GetDate("DATAOPE");
                    /* ElseIf xapopebo->TIPOOPRAP='26' */
                  } else if (CPLib.eqr(Cursor_xapopebo.GetString("TIPOOPRAP"),"26")) {
                    /* _datend := xapopebo->DATAOPE */
                    _datend = Cursor_xapopebo.GetDate("DATAOPE");
                  } // End If
                  Cursor_xapopebo.Next();
                }
                m_cConnectivityError = Cursor_xapopebo.ErrorMessage();
                Cursor_xapopebo.Close();
                // * --- End Select
              } // End If
              /* If Empty(_datini) and Empty(_datend) */
              if (CPLib.Empty(_datini) && CPLib.Empty(_datend)) {
                /* _txterr := _txterr + "Non esistono le informazioni di apertura ed eventuale chiusura del rapporto collegato all'operazione" + NL */
                _txterr = _txterr+"Non esistono le informazioni di apertura ed eventuale chiusura del rapporto collegato all'operazione"+"\n";
                /* _recOK := 1 */
                _recOK = CPLib.Round(1,0);
              } else { // Else
                /* If _datope < _datini */
                if (CPLib.lt(_datope,_datini)) {
                  /* _txterr := _txterr + "Impossibile inserire un'operazione prima dell'apertura del rapporto" + NL */
                  _txterr = _txterr+"Impossibile inserire un'operazione prima dell'apertura del rapporto"+"\n";
                  /* _recOK := 1 */
                  _recOK = CPLib.Round(1,0);
                } // End If
                /* If not(Empty(_datend)) and _datope > _datend */
                if ( ! (CPLib.Empty(_datend)) && CPLib.gt(_datope,_datend)) {
                  /* _txterr := _txterr + "Impossibile inserire un'operazione dopo la chiusura del rapporto" + NL */
                  _txterr = _txterr+"Impossibile inserire un'operazione dopo la chiusura del rapporto"+"\n";
                  /* _recOK := 1 */
                  _recOK = CPLib.Round(1,0);
                } // End If
              } // End If
            } else { // Else
              /* _codrap := '' */
              _codrap = "";
              // * --- Read from xnarapbo
              m_cServer = m_Ctx.GetServer("xnarapbo");
              m_cPhName = m_Ctx.GetPhName("xnarapbo");
              m_cSql = "";
              m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_telematico.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_cgo_telematico.GetString("RAPPORTO"));
              if (m_Ctx.IsSharedTemp("xnarapbo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _codrap = Read_Cursor.GetString("RAPPORTO");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on xnarapbo into routine arrt_imp_dati_cgo_sched_tabs_multitry returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _codrap = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If not(Empty(LRTrim(_codrap))) */
              if ( ! (CPLib.Empty(CPLib.LRTrim(_codrap)))) {
                /* _datini := NullDate() */
                _datini = CPLib.NullDate();
                /* _datend := NullDate() */
                _datend = CPLib.NullDate();
                // * --- Select from xapopebo
                m_cServer = m_Ctx.GetServer("xapopebo");
                m_cPhName = m_Ctx.GetPhName("xapopebo");
                if (Cursor_xapopebo!=null)
                  Cursor_xapopebo.Close();
                Cursor_xapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select DATAOPE,TIPOOPRAP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_cgo_telematico.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_xapopebo.Eof())) {
                  /* If xapopebo->TIPOOPRAP='23' */
                  if (CPLib.eqr(Cursor_xapopebo.GetString("TIPOOPRAP"),"23")) {
                    /* _datini := xapopebo->DATAOPE */
                    _datini = Cursor_xapopebo.GetDate("DATAOPE");
                    /* ElseIf xapopebo->TIPOOPRAP='26' */
                  } else if (CPLib.eqr(Cursor_xapopebo.GetString("TIPOOPRAP"),"26")) {
                    /* _datend := xapopebo->DATAOPE */
                    _datend = Cursor_xapopebo.GetDate("DATAOPE");
                  } // End If
                  Cursor_xapopebo.Next();
                }
                m_cConnectivityError = Cursor_xapopebo.ErrorMessage();
                Cursor_xapopebo.Close();
                // * --- End Select
                /* If Empty(_datini) and Empty(_datend) */
                if (CPLib.Empty(_datini) && CPLib.Empty(_datend)) {
                  /* _txterr := _txterr + "Non esistono le informazioni di apertura ed eventuale chiusura del rapporto collegato all'operazione" + NL */
                  _txterr = _txterr+"Non esistono le informazioni di apertura ed eventuale chiusura del rapporto collegato all'operazione"+"\n";
                  /* _recOK := 1 */
                  _recOK = CPLib.Round(1,0);
                } else { // Else
                  /* If _datope < _datini */
                  if (CPLib.lt(_datope,_datini)) {
                    /* _txterr := _txterr + "Impossibile inserire un'operazione prima dell'apertura del rapporto" + NL */
                    _txterr = _txterr+"Impossibile inserire un'operazione prima dell'apertura del rapporto"+"\n";
                    /* _recOK := 1 */
                    _recOK = CPLib.Round(1,0);
                  } // End If
                  /* If not(Empty(_datend)) and _datope > _datend */
                  if ( ! (CPLib.Empty(_datend)) && CPLib.gt(_datope,_datend)) {
                    /* _txterr := _txterr + "Impossibile inserire un'operazione dopo la chiusura del rapporto" + NL */
                    _txterr = _txterr+"Impossibile inserire un'operazione dopo la chiusura del rapporto"+"\n";
                    /* _recOK := 1 */
                    _recOK = CPLib.Round(1,0);
                  } // End If
                } // End If
              } else { // Else
                /* _txterr := _txterr + "Non esistono i dati base del rapporto collegato all'operazione" + NL */
                _txterr = _txterr+"Non esistono i dati base del rapporto collegato all'operazione"+"\n";
                /* _recOK := 1 */
                _recOK = CPLib.Round(1,0);
              } // End If
            } // End If
            /* If not(Empty(LRTrim(cgo_telematico->RAPPORTO))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_cgo_telematico.GetString("RAPPORTO"))))) {
              /* _intcon := '' */
              _intcon = "";
              // * --- Select from intestbo
              m_cServer = m_Ctx.GetServer("intestbo");
              m_cPhName = m_Ctx.GetPhName("intestbo");
              if (Cursor_intestbo!=null)
                Cursor_intestbo.Close();
              Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_cgo_telematico.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_intestbo.Eof())) {
                /* _intcon := intestbo->CODINTER */
                _intcon = Cursor_intestbo.GetString("CODINTER");
                Cursor_intestbo.Next();
              }
              m_cConnectivityError = Cursor_intestbo.ErrorMessage();
              Cursor_intestbo.Close();
              // * --- End Select
              /* If Empty(LRTrim(_intcon)) */
              if (CPLib.Empty(CPLib.LRTrim(_intcon))) {
                // * --- Select from xntestbo
                m_cServer = m_Ctx.GetServer("xntestbo");
                m_cPhName = m_Ctx.GetPhName("xntestbo");
                if (Cursor_xntestbo!=null)
                  Cursor_xntestbo.Close();
                Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_cgo_telematico.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_xntestbo.Eof())) {
                  /* _intcon := xntestbo->CODINTER */
                  _intcon = Cursor_xntestbo.GetString("CODINTER");
                  Cursor_xntestbo.Next();
                }
                m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
                Cursor_xntestbo.Close();
                // * --- End Select
              } // End If
              /* If not(Empty(LRTrim(_intcon))) */
              if ( ! (CPLib.Empty(CPLib.LRTrim(_intcon)))) {
                /* _datini := NullDate() */
                _datini = CPLib.NullDate();
                /* _datend := NullDate() */
                _datend = CPLib.NullDate();
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select DATAVALI,DATARILASC  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_intcon,"?",0,0,m_cServer, m_oParameters),m_cServer,_intcon)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* _datini := personbo->DATARILASC */
                  _datini = Cursor_personbo.GetDate("DATARILASC");
                  /* _datend := personbo->DATAVALI */
                  _datend = Cursor_personbo.GetDate("DATAVALI");
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
                /* If Empty(_datini) and Empty(_datend) */
                if (CPLib.Empty(_datini) && CPLib.Empty(_datend)) {
                  /* _txterr := _txterr + "Mancano le date di rilascio e scadenza del documento dell'intestatario del rapporto collegato all'operazione" + NL */
                  _txterr = _txterr+"Mancano le date di rilascio e scadenza del documento dell'intestatario del rapporto collegato all'operazione"+"\n";
                  /* _recOK := 1 */
                  _recOK = CPLib.Round(1,0);
                } else { // Else
                  /* If _datope < _datini */
                  if (CPLib.lt(_datope,_datini)) {
                    /* _txterr := _txterr + "Impossibile inserire un'operazione prima della data di rilascio deldocumentodel soggetto intestatario del rapporto" + NL */
                    _txterr = _txterr+"Impossibile inserire un'operazione prima della data di rilascio deldocumentodel soggetto intestatario del rapporto"+"\n";
                    /* _recOK := 1 */
                    _recOK = CPLib.Round(1,0);
                  } // End If
                  /* If not(Empty(_datend)) and _datope > _datend */
                  if ( ! (CPLib.Empty(_datend)) && CPLib.gt(_datope,_datend)) {
                    /* _txterr := _txterr + "Impossibile inserire un'operazione dopo la data di scadenza del documento del soggetto intestatario del rapporto" + NL */
                    _txterr = _txterr+"Impossibile inserire un'operazione dopo la data di scadenza del documento del soggetto intestatario del rapporto"+"\n";
                    /* _recOK := 1 */
                    _recOK = CPLib.Round(1,0);
                  } // End If
                } // End If
              } else { // Else
                /* _txterr := _txterr + "Manca il riferimento all'intestatario del rapporto collegato all'operazione" + NL */
                _txterr = _txterr+"Manca il riferimento all'intestatario del rapporto collegato all'operazione"+"\n";
                /* _recOK := 1 */
                _recOK = CPLib.Round(1,0);
              } // End If
            } // End If
          } // End If
        } // End If
        /* If cgo_telematico->TOTLIRE=0 */
        if (CPLib.eqr(Cursor_cgo_telematico.GetDouble("TOTLIRE"),0)) {
          /* _txterr := _txterr + "Manca l'importo dell'operazione" + NL */
          _txterr = _txterr+"Manca l'importo dell'operazione"+"\n";
          /* _recOK := 1 */
          _recOK = CPLib.Round(1,0);
        } // End If
        Cursor_cgo_telematico.Next();
      }
      m_cConnectivityError = Cursor_cgo_telematico.ErrorMessage();
      Cursor_cgo_telematico.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_cgo_telematico!=null)
          Cursor_cgo_telematico.Close();
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
        if (Cursor_rapopebo!=null)
          Cursor_rapopebo.Close();
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
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
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
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync() {
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
  public static arrt_imp_dati_cgo_sched_tabs_multitryR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_imp_dati_cgo_sched_tabs_multitryR(p_Ctx, p_Caller);
  }
  public void Blank() {
    fhand = CPLib.Space(1);
    riga = "";
    _tdest = CPLib.Space(1);
    xConnes = CPLib.Space(16);
    xCF = CPLib.Space(16);
    xRiga1 = "";
    xRiga2 = "";
    xAnnNas = CPLib.Space(2);
    xMesNas = CPLib.Space(2);
    xDayNas = CPLib.Space(2);
    xSesso = CPLib.Space(1);
    cSNAS = CPLib.Space(30);
    cCNAS = CPLib.Space(30);
    cPNAS = CPLib.Space(2);
    cDNAS = CPLib.NullDate();
    xSOCTCon = CPLib.Space(16);
    xSOCTCF = CPLib.Space(16);
    xCodCab = CPLib.Space(6);
    xCitta = CPLib.Space(30);
    cCliProg = CPLib.Space(6);
    cInfProg1 = CPLib.Space(10);
    cInfProg2 = CPLib.Space(11);
    cOpeProg1 = CPLib.Space(10);
    cOpeProg2 = CPLib.Space(11);
    xRapporto = CPLib.Space(25);
    xCAB = CPLib.Space(6);
    xDIP = CPLib.Space(6);
    xDIPx = CPLib.Space(6);
    cCli1 = CPLib.Space(16);
    xIDB = CPLib.Space(10);
    xData = CPLib.Space(8);
    xDatF = CPLib.Space(8);
    cNumNew = 0;
    rNumNew = 0;
    cNumMod = 0;
    rNumMod = 0;
    cNumInv = 0;
    cFlagLire = CPLib.Space(1);
    cFlagCont = CPLib.Space(1);
    cFlagFraz = CPLib.Space(1);
    cMaxRow = 0;
    cIdCau = CPLib.Space(4);
    xCFE = 0;
    conta = 0;
    _esito = 0;
    _unicode = CPLib.Space(10);
    _ucode = CPLib.Space(10);
    _salta = 0;
    _allineamento = 0;
    _allineatonomecnome = 0;
    _ragsocold = CPLib.Space(70);
    _cabold = CPLib.Space(6);
    nProgImp = 0;
    nProgImp2 = 0;
    cProgSto = CPLib.Space(15);
    _idbase = CPLib.Space(10);
    _tipinter = CPLib.Space(2);
    _codinter = CPLib.Space(11);
    _citinter = CPLib.Space(30);
    _cabinter = CPLib.Space(6);
    _prvinter = CPLib.Space(2);
    _intertip = CPLib.Space(2);
    _intercod = CPLib.Space(11);
    _intercit = CPLib.Space(30);
    _intercab = CPLib.Space(6);
    _interprv = CPLib.Space(2);
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
    _newop = 0;
    _nprog = CPLib.Space(10);
    _operazmod = CPLib.Space(20);
    stringaflagrap2 = CPLib.Space(9);
    _flagrap2 = CPLib.Space(1);
    _idreg = CPLib.Space(20);
    cNewProg = CPLib.Space(10);
    numriga = 0;
    _tipper = CPLib.Space(1);
    chkat = 0;
    _benrag = CPLib.Space(70);
    _bensta = CPLib.Space(3);
    _bencta = CPLib.Space(30);
    _bencab = CPLib.Space(6);
    _benprv = CPLib.Space(2);
    _benind = CPLib.Space(35);
    _bencap = CPLib.Space(5);
    abicab = CPLib.Space(11);
    _flgvnp = CPLib.Space(1);
    _flgvlt = CPLib.Space(1);
    cProgImp = CPLib.Space(15);
    _snainumope = CPLib.Space(15);
    _codcau = 0;
    _datini = CPLib.NullDate();
    _datend = CPLib.NullDate();
    _codrap = CPLib.Space(25);
    _intcon = CPLib.Space(16);
    _mezpagam = CPLib.Space(1);
    _MsgAss = "";
    ciidbase = CPLib.Space(10);
    cidataini = CPLib.NullDate();
    cidatafine = CPLib.NullDate();
    cicodinter = CPLib.Space(12);
    cinumprog = CPLib.Space(11);
    citiporap = CPLib.Space(1);
    w_errchk = 0;
    w_tipodest = CPLib.Space(1);
    filename = CPLib.Space(100);
    _conta = 0;
    _gMsgProc = "";
    cProg = CPLib.Space(20);
    _totale = 0;
    _max = 0;
    _min = 0;
    _cicli = 0;
    _contacilci = 0;
    _bottom = 0;
    _top = 0;
    _movcod = 0;
    dNumNew = 0;
    dNumMod = 0;
    dNumErr = 0;
    oNumero = 0;
    oNumErr = 0;
    fNumero = 0;
    sNumNew = 0;
    sNumMod = 0;
    sNumInv = 0;
    sNumErr = 0;
    rNumErr = 0;
    uNumNew = 0;
    uNumMod = 0;
    nTotErr = 0;
    _recOK = 0;
    _datope = CPLib.NullDate();
    _datreg = CPLib.NullDate();
    _datimp = CPLib.NullDate();
    _datnas = CPLib.NullDate();
    _datemi = CPLib.NullDate();
    _datval = CPLib.NullDate();
    _txterr = "";
    _codana = CPLib.Space(4);
    _codsin = CPLib.Space(2);
    _segno = CPLib.Space(1);
    _tipope = CPLib.Space(2);
    nIntest = 0;
    _tiporap = CPLib.Space(1);
    _locrap = CPLib.Space(1);
    _codsog = CPLib.Space(16);
    _gAzienda = CPLib.Space(10);
    _chiave = CPLib.Space(20);
    _flgfile = CPLib.Space(1);
    _oldazi = CPLib.Space(10);
    _limoper = 0;
    ProgErr = CPLib.Space(15);
    _limvlt = 0;
    _limvnp = 0;
    _numope = CPLib.Space(15);
    _oidb = CPLib.Space(1);
    _idb = CPLib.Space(20);
    _seekid = CPLib.Space(20);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_cgo_anadip_totali,qbe_cgo_soggetti_totali,qbe_cgo_rapporti_totali,qbe_cgo_telematico_totali,qbe_cgo_users_totali,qbe_cpusers_max,
  public static final String m_cVQRList = ",qbe_cgo_anadip_totali,qbe_cgo_soggetti_totali,qbe_cgo_rapporti_totali,qbe_cgo_telematico_totali,qbe_cgo_users_totali,qbe_cpusers_max,";
  // ENTITY_BATCHES: ,arfn_dttod,arfn_fdate,arfn_fdatetime,arrt_snai_oper_save,
  public static final String i_InvokedRoutines = ",arfn_dttod,arfn_fdate,arfn_fdatetime,arrt_snai_oper_save,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_07A54250(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODDIP,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CAB,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"TELEFONO,";
    if (p_Ctx.IsSharedTemp("anadip")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"anadip",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05D94200(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"PRGDIP,";
    p_cSql = p_cSql+"CODDIP,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CAB,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TXTERR,";
    p_cSql = p_cSql+"FLGFULL,";
    if (p_Ctx.IsSharedTemp("cgo_anadip_err")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_anadip_err",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05F5E700(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"SNAINUMOPE,";
    p_cSql = p_cSql+"ENV,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"CACODICE,";
    p_cSql = p_cSql+"CADATAORA,";
    p_cSql = p_cSql+"CAIDBIGLIETTO,";
    p_cSql = p_cSql+"CSMF_COD,";
    p_cSql = p_cSql+"NUM_CONC,";
    p_cSql = p_cSql+"P_VEND,";
    p_cSql = p_cSql+"IPCOLLEG,";
    p_cSql = p_cSql+"ORACOLLEG,";
    p_cSql = p_cSql+"DUCOLLEG,";
    p_cSql = p_cSql+"IBAN,";
    p_cSql = p_cSql+"TXTERR,";
    if (p_Ctx.IsSharedTemp("cgo_telematico_err")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_telematico_err",true);
    return p_cSql;
  }
  protected static String GetFieldsName_07AFDE68(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"LOGCODICE,";
    p_cSql = p_cSql+"LOGDATORA,";
    p_cSql = p_cSql+"LOGUTENTE,";
    p_cSql = p_cSql+"LOGTIPOPE,";
    p_cSql = p_cSql+"LOGTESTO,";
    p_cSql = p_cSql+"LOGTABELLA,";
    p_cSql = p_cSql+"LOGCHIAVE,";
    if (p_Ctx.IsSharedTemp("log_app")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"log_app",true);
    return p_cSql;
  }
  protected static String GetFieldsName_062E0AE8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"LOGCODICE,";
    p_cSql = p_cSql+"LOGDATORA,";
    p_cSql = p_cSql+"LOGUTENTE,";
    p_cSql = p_cSql+"LOGTIPOPE,";
    p_cSql = p_cSql+"LOGTESTO,";
    p_cSql = p_cSql+"LOGTABELLA,";
    p_cSql = p_cSql+"LOGCHIAVE,";
    if (p_Ctx.IsSharedTemp("log_app")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"log_app",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05DA0338(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"LOGCODICE,";
    p_cSql = p_cSql+"LOGDATORA,";
    p_cSql = p_cSql+"LOGUTENTE,";
    p_cSql = p_cSql+"LOGTIPOPE,";
    p_cSql = p_cSql+"LOGTESTO,";
    p_cSql = p_cSql+"LOGTABELLA,";
    p_cSql = p_cSql+"LOGCHIAVE,";
    if (p_Ctx.IsSharedTemp("log_app")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"log_app",true);
    return p_cSql;
  }
  protected static String GetFieldsName_04220AA0(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"LOGCODICE,";
    p_cSql = p_cSql+"LOGDATORA,";
    p_cSql = p_cSql+"LOGUTENTE,";
    p_cSql = p_cSql+"LOGTIPOPE,";
    p_cSql = p_cSql+"LOGTESTO,";
    p_cSql = p_cSql+"LOGTABELLA,";
    p_cSql = p_cSql+"LOGCHIAVE,";
    if (p_Ctx.IsSharedTemp("log_app")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"log_app",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05D0CDB0(CPContext p_Ctx) {
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
  protected static String GetFieldsName_062CEB78(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PEP,";
    p_cSql = p_cSql+"PROGIMPORT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"TIPINTER,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"TIPOPERS,";
    if (p_Ctx.IsSharedTemp("personbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05DED380(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"PRGSOG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"NASPROV,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+"PEP,";
    p_cSql = p_cSql+"TXTERR,";
    p_cSql = p_cSql+"FLGFULL,";
    if (p_Ctx.IsSharedTemp("cgo_soggetti_err")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_soggetti_err",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0643B980(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"PRGRAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"TIPOMOV,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"CODINTEST,";
    p_cSql = p_cSql+"TXTERR,";
    if (p_Ctx.IsSharedTemp("cgo_rapporti_err")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_rapporti_err",true);
    return p_cSql;
  }
  protected static String GetFieldsName_062EDB98(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"SNAINUMOPE,";
    p_cSql = p_cSql+"ENV,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"CACODICE,";
    p_cSql = p_cSql+"CADATAORA,";
    p_cSql = p_cSql+"CAIDBIGLIETTO,";
    p_cSql = p_cSql+"CSMF_COD,";
    p_cSql = p_cSql+"NUM_CONC,";
    p_cSql = p_cSql+"P_VEND,";
    p_cSql = p_cSql+"IPCOLLEG,";
    p_cSql = p_cSql+"ORACOLLEG,";
    p_cSql = p_cSql+"DUCOLLEG,";
    p_cSql = p_cSql+"IBAN,";
    p_cSql = p_cSql+"TXTERR,";
    if (p_Ctx.IsSharedTemp("cgo_telematico_err")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_telematico_err",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05E70F00(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"SNAINUMOPE,";
    p_cSql = p_cSql+"ENV,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"CACODICE,";
    p_cSql = p_cSql+"CADATAORA,";
    p_cSql = p_cSql+"CAIDBIGLIETTO,";
    p_cSql = p_cSql+"CSMF_COD,";
    p_cSql = p_cSql+"NUM_CONC,";
    p_cSql = p_cSql+"P_VEND,";
    p_cSql = p_cSql+"IPCOLLEG,";
    p_cSql = p_cSql+"ORACOLLEG,";
    p_cSql = p_cSql+"DUCOLLEG,";
    p_cSql = p_cSql+"IBAN,";
    p_cSql = p_cSql+"TXTERR,";
    if (p_Ctx.IsSharedTemp("cgo_telematico_err")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_telematico_err",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06117F88(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"SNAINUMOPE,";
    p_cSql = p_cSql+"ENV,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"CACODICE,";
    p_cSql = p_cSql+"CADATAORA,";
    p_cSql = p_cSql+"CAIDBIGLIETTO,";
    p_cSql = p_cSql+"CSMF_COD,";
    p_cSql = p_cSql+"NUM_CONC,";
    p_cSql = p_cSql+"P_VEND,";
    p_cSql = p_cSql+"IPCOLLEG,";
    p_cSql = p_cSql+"ORACOLLEG,";
    p_cSql = p_cSql+"DUCOLLEG,";
    p_cSql = p_cSql+"IBAN,";
    p_cSql = p_cSql+"TXTERR,";
    if (p_Ctx.IsSharedTemp("cgo_telematico_err")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_telematico_err",true);
    return p_cSql;
  }
  protected static String GetFieldsName_07C91D50(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"LOGCODICE,";
    p_cSql = p_cSql+"LOGDATORA,";
    p_cSql = p_cSql+"LOGUTENTE,";
    p_cSql = p_cSql+"LOGTIPOPE,";
    p_cSql = p_cSql+"LOGTESTO,";
    p_cSql = p_cSql+"LOGTABELLA,";
    p_cSql = p_cSql+"LOGCHIAVE,";
    if (p_Ctx.IsSharedTemp("log_app")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"log_app",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05B34760(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"LOGCODICE,";
    p_cSql = p_cSql+"LOGDATORA,";
    p_cSql = p_cSql+"LOGUTENTE,";
    p_cSql = p_cSql+"LOGTIPOPE,";
    p_cSql = p_cSql+"LOGTESTO,";
    p_cSql = p_cSql+"LOGTABELLA,";
    p_cSql = p_cSql+"LOGCHIAVE,";
    if (p_Ctx.IsSharedTemp("log_app")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"log_app",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05FA9E88(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"LOGCODICE,";
    p_cSql = p_cSql+"LOGDATORA,";
    p_cSql = p_cSql+"LOGUTENTE,";
    p_cSql = p_cSql+"LOGTIPOPE,";
    p_cSql = p_cSql+"LOGTESTO,";
    p_cSql = p_cSql+"LOGTABELLA,";
    p_cSql = p_cSql+"LOGCHIAVE,";
    if (p_Ctx.IsSharedTemp("log_app")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"log_app",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0656DBE0(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"LOGCODICE,";
    p_cSql = p_cSql+"LOGDATORA,";
    p_cSql = p_cSql+"LOGUTENTE,";
    p_cSql = p_cSql+"LOGTIPOPE,";
    p_cSql = p_cSql+"LOGTESTO,";
    p_cSql = p_cSql+"LOGTABELLA,";
    p_cSql = p_cSql+"LOGCHIAVE,";
    if (p_Ctx.IsSharedTemp("log_app")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"log_app",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05E0D648(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"TIPOAG,";
    if (p_Ctx.IsSharedTemp("xnarapbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xnarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0646E390(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
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
    p_cSql = p_cSql+"CDATREG,";
    if (p_Ctx.IsSharedTemp("xapopebo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_062EEC58(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"PRGIMPSOG,";
    if (p_Ctx.IsSharedTemp("xntestbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xntestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05E0E068(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"TIPOAG,";
    if (p_Ctx.IsSharedTemp("anarapbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"anarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0646EA98(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
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
    p_cSql = p_cSql+"CDATREG,";
    if (p_Ctx.IsSharedTemp("rapopebo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_062E4208(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"PRGIMPSOG,";
    if (p_Ctx.IsSharedTemp("intestbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"intestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_07A51088(CPContext p_Ctx) {
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
  protected static String GetFieldsName_062D1050(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
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
    p_cSql = p_cSql+"CDATREG,";
    if (p_Ctx.IsSharedTemp("xapopebo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_07A87C70(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
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
    p_cSql = p_cSql+"CDATREG,";
    if (p_Ctx.IsSharedTemp("rapopebo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05DD13B8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"PRGRAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"TIPOMOV,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"CODINTEST,";
    p_cSql = p_cSql+"TXTERR,";
    p_cSql = p_cSql+"FLGFULL,";
    if (p_Ctx.IsSharedTemp("cgo_rapporti_err")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_rapporti_err",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06102478(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"SNAINUMOPE,";
    p_cSql = p_cSql+"ENV,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"CACODICE,";
    p_cSql = p_cSql+"CADATAORA,";
    p_cSql = p_cSql+"CAIDBIGLIETTO,";
    p_cSql = p_cSql+"CSMF_COD,";
    p_cSql = p_cSql+"NUM_CONC,";
    p_cSql = p_cSql+"P_VEND,";
    p_cSql = p_cSql+"IPCOLLEG,";
    p_cSql = p_cSql+"ORACOLLEG,";
    p_cSql = p_cSql+"DUCOLLEG,";
    p_cSql = p_cSql+"IBAN,";
    p_cSql = p_cSql+"TXTERR,";
    if (p_Ctx.IsSharedTemp("cgo_telematico_err")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_telematico_err",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05CE7698(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"LOGCODICE,";
    p_cSql = p_cSql+"LOGDATORA,";
    p_cSql = p_cSql+"LOGUTENTE,";
    p_cSql = p_cSql+"LOGTIPOPE,";
    p_cSql = p_cSql+"LOGTESTO,";
    p_cSql = p_cSql+"LOGTABELLA,";
    p_cSql = p_cSql+"LOGCHIAVE,";
    if (p_Ctx.IsSharedTemp("log_app")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"log_app",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05EFB320(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"LOGCODICE,";
    p_cSql = p_cSql+"LOGDATORA,";
    p_cSql = p_cSql+"LOGUTENTE,";
    p_cSql = p_cSql+"LOGTIPOPE,";
    p_cSql = p_cSql+"LOGTESTO,";
    p_cSql = p_cSql+"LOGTABELLA,";
    p_cSql = p_cSql+"LOGCHIAVE,";
    if (p_Ctx.IsSharedTemp("log_app")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"log_app",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06553FF0(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"LOGCODICE,";
    p_cSql = p_cSql+"LOGDATORA,";
    p_cSql = p_cSql+"LOGUTENTE,";
    p_cSql = p_cSql+"LOGTIPOPE,";
    p_cSql = p_cSql+"LOGTESTO,";
    p_cSql = p_cSql+"LOGTABELLA,";
    p_cSql = p_cSql+"LOGCHIAVE,";
    if (p_Ctx.IsSharedTemp("log_app")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"log_app",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05C84660(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"LOGCODICE,";
    p_cSql = p_cSql+"LOGDATORA,";
    p_cSql = p_cSql+"LOGUTENTE,";
    p_cSql = p_cSql+"LOGTIPOPE,";
    p_cSql = p_cSql+"LOGTESTO,";
    p_cSql = p_cSql+"LOGTABELLA,";
    p_cSql = p_cSql+"LOGCHIAVE,";
    if (p_Ctx.IsSharedTemp("log_app")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"log_app",true);
    return p_cSql;
  }
  protected static String GetFieldsName_062EB288(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DUCOLLEG,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"IPCOLLEG,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"ORACOLLEG,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"MTCN,";
    if (p_Ctx.IsSharedTemp("xperazbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xperazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05E09B80(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    if (p_Ctx.IsSharedTemp("xlientiope")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xlientiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05E8F398(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"TODATOPE,";
    p_cSql = p_cSql+"TOCODSOG,";
    p_cSql = p_cSql+"TONUMOPE,";
    p_cSql = p_cSql+"TO_SEGNO,";
    p_cSql = p_cSql+"TOIMPORT,";
    if (p_Ctx.IsSharedTemp("cgo_totope")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_totope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05B38978(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    if (p_Ctx.IsSharedTemp("xlientiope")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xlientiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05D0EF28(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"TODATOPE,";
    p_cSql = p_cSql+"TOCODSOG,";
    p_cSql = p_cSql+"TONUMOPE,";
    p_cSql = p_cSql+"TO_SEGNO,";
    p_cSql = p_cSql+"TOIMPORT,";
    if (p_Ctx.IsSharedTemp("cgo_totope")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_totope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05F5CA98(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DUCOLLEG,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"IPCOLLEG,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"ORACOLLEG,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"MTCN,";
    if (p_Ctx.IsSharedTemp("operazbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05B64F10(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    if (p_Ctx.IsSharedTemp("clientiope")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"clientiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05F7EE90(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"TODATOPE,";
    p_cSql = p_cSql+"TOCODSOG,";
    p_cSql = p_cSql+"TONUMOPE,";
    p_cSql = p_cSql+"TO_SEGNO,";
    p_cSql = p_cSql+"TOIMPORT,";
    if (p_Ctx.IsSharedTemp("cgo_totope")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_totope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0622D0C0(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    if (p_Ctx.IsSharedTemp("clientiope")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"clientiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_060DDEF8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"TODATOPE,";
    p_cSql = p_cSql+"TOCODSOG,";
    p_cSql = p_cSql+"TONUMOPE,";
    p_cSql = p_cSql+"TO_SEGNO,";
    p_cSql = p_cSql+"TOIMPORT,";
    if (p_Ctx.IsSharedTemp("cgo_totope")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_totope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_04191610(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DUCOLLEG,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"IPCOLLEG,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"ORACOLLEG,";
    p_cSql = p_cSql+"PRGIMPFRZ,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"MTCN,";
    if (p_Ctx.IsSharedTemp("xraziobo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xraziobo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05EDA680(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    if (p_Ctx.IsSharedTemp("xlientifrz")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xlientifrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_072560F8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    if (p_Ctx.IsSharedTemp("xlientifrz")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xlientifrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05D0BF58(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DUCOLLEG,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"IPCOLLEG,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"ORACOLLEG,";
    p_cSql = p_cSql+"PRGIMPFRZ,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"MTCN,";
    if (p_Ctx.IsSharedTemp("fraziobo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"fraziobo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0641FC30(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    if (p_Ctx.IsSharedTemp("clientifrz")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"clientifrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05D02140(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    if (p_Ctx.IsSharedTemp("clientifrz")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"clientifrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06108A00(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"SNAINUMOPE,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"DESCCITDIP,";
    p_cSql = p_cSql+"PROVINCIADIP,";
    p_cSql = p_cSql+"CODCABDIP,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CAIDBIGLIETTO,";
    p_cSql = p_cSql+"CADATAORA,";
    p_cSql = p_cSql+"CACODICE,";
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
    p_cSql = p_cSql+"MEZPAGAM,";
    p_cSql = p_cSql+"IBAN,";
    p_cSql = p_cSql+"CGOFLGVLT,";
    p_cSql = p_cSql+"CGOFLGVNP,";
    p_cSql = p_cSql+"CGOTIPOPE,";
    p_cSql = p_cSql+"CGODIPCOM,";
    p_cSql = p_cSql+"NUMOPEDL,";
    if (p_Ctx.IsSharedTemp("cgo_operazioni")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_operazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05EAB8E8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"SNAINUMOPE,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"DESCCITDIP,";
    p_cSql = p_cSql+"PROVINCIADIP,";
    p_cSql = p_cSql+"CODCABDIP,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CAIDBIGLIETTO,";
    p_cSql = p_cSql+"CADATAORA,";
    p_cSql = p_cSql+"CACODICE,";
    p_cSql = p_cSql+"CGOFLGVLT,";
    p_cSql = p_cSql+"CGOFLGVNP,";
    p_cSql = p_cSql+"CGOTIPOPE,";
    p_cSql = p_cSql+"CGODIPCOM,";
    if (p_Ctx.IsSharedTemp("cgo_operazioni")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_operazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06473760(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"SNAINUMOPE,";
    p_cSql = p_cSql+"ENV,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"CACODICE,";
    p_cSql = p_cSql+"CADATAORA,";
    p_cSql = p_cSql+"CAIDBIGLIETTO,";
    p_cSql = p_cSql+"CSMF_COD,";
    p_cSql = p_cSql+"NUM_CONC,";
    p_cSql = p_cSql+"P_VEND,";
    p_cSql = p_cSql+"IPCOLLEG,";
    p_cSql = p_cSql+"ORACOLLEG,";
    p_cSql = p_cSql+"DUCOLLEG,";
    p_cSql = p_cSql+"IBAN,";
    p_cSql = p_cSql+"TXTERR,";
    p_cSql = p_cSql+"FLGFULL,";
    if (p_Ctx.IsSharedTemp("cgo_telematico_err")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_telematico_err",true);
    return p_cSql;
  }
  protected static String GetFieldsName_062242B0(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"LOGCODICE,";
    p_cSql = p_cSql+"LOGDATORA,";
    p_cSql = p_cSql+"LOGUTENTE,";
    p_cSql = p_cSql+"LOGTIPOPE,";
    p_cSql = p_cSql+"LOGTESTO,";
    p_cSql = p_cSql+"LOGTABELLA,";
    p_cSql = p_cSql+"LOGCHIAVE,";
    if (p_Ctx.IsSharedTemp("log_app")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"log_app",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05CA3608(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"LOGCODICE,";
    p_cSql = p_cSql+"LOGDATORA,";
    p_cSql = p_cSql+"LOGUTENTE,";
    p_cSql = p_cSql+"LOGTIPOPE,";
    p_cSql = p_cSql+"LOGTESTO,";
    p_cSql = p_cSql+"LOGTABELLA,";
    p_cSql = p_cSql+"LOGCHIAVE,";
    if (p_Ctx.IsSharedTemp("log_app")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"log_app",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05ED1D88(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"LOGCODICE,";
    p_cSql = p_cSql+"LOGDATORA,";
    p_cSql = p_cSql+"LOGUTENTE,";
    p_cSql = p_cSql+"LOGTIPOPE,";
    p_cSql = p_cSql+"LOGTESTO,";
    p_cSql = p_cSql+"LOGTABELLA,";
    p_cSql = p_cSql+"LOGCHIAVE,";
    if (p_Ctx.IsSharedTemp("log_app")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"log_app",true);
    return p_cSql;
  }
  protected static String GetFieldsName_07C8F200(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"LOGCODICE,";
    p_cSql = p_cSql+"LOGDATORA,";
    p_cSql = p_cSql+"LOGUTENTE,";
    p_cSql = p_cSql+"LOGTIPOPE,";
    p_cSql = p_cSql+"LOGTESTO,";
    p_cSql = p_cSql+"LOGTABELLA,";
    p_cSql = p_cSql+"LOGCHIAVE,";
    if (p_Ctx.IsSharedTemp("log_app")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"log_app",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05EAD748(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"code,";
    p_cSql = p_cSql+"name,";
    p_cSql = p_cSql+"passwd,";
    p_cSql = p_cSql+"enabled,";
    p_cSql = p_cSql+"companies,";
    p_cSql = p_cSql+"fullname,";
    if (p_Ctx.IsSharedTemp("cpusers")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpusers",true);
    return p_cSql;
  }
  protected static String GetFieldsName_07CEFD80(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODE,";
    p_cSql = p_cSql+"CODDIP,";
    if (p_Ctx.IsSharedTemp("cpusers_add")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpusers_add",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05F35718(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"groupcode,";
    p_cSql = p_cSql+"usercode,";
    p_cSql = p_cSql+"companies,";
    if (p_Ctx.IsSharedTemp("cpusrgrp")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpusrgrp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05F49D58(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"LOGCODICE,";
    p_cSql = p_cSql+"LOGDATORA,";
    p_cSql = p_cSql+"LOGUTENTE,";
    p_cSql = p_cSql+"LOGTIPOPE,";
    p_cSql = p_cSql+"LOGTESTO,";
    p_cSql = p_cSql+"LOGTABELLA,";
    p_cSql = p_cSql+"LOGCHIAVE,";
    if (p_Ctx.IsSharedTemp("log_app")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"log_app",true);
    return p_cSql;
  }
  protected static String GetFieldsName_04178278(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"LOGCODICE,";
    p_cSql = p_cSql+"LOGDATORA,";
    p_cSql = p_cSql+"LOGUTENTE,";
    p_cSql = p_cSql+"LOGTIPOPE,";
    p_cSql = p_cSql+"LOGTESTO,";
    p_cSql = p_cSql+"LOGTABELLA,";
    p_cSql = p_cSql+"LOGCHIAVE,";
    if (p_Ctx.IsSharedTemp("log_app")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"log_app",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05DD8908(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"LOGCODICE,";
    p_cSql = p_cSql+"LOGDATORA,";
    p_cSql = p_cSql+"LOGUTENTE,";
    p_cSql = p_cSql+"LOGTIPOPE,";
    p_cSql = p_cSql+"LOGTESTO,";
    p_cSql = p_cSql+"LOGTABELLA,";
    p_cSql = p_cSql+"LOGCHIAVE,";
    if (p_Ctx.IsSharedTemp("log_app")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"log_app",true);
    return p_cSql;
  }
}
