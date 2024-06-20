// * --- Area Manuale = BO - Header
// * --- arrt_imp_dati_storico_sched_tabs
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
// * --- Fine Area Manuale
public class arrt_imp_dati_storico_sched_tabsR implements CallerWithObjs {
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
  public String m_cPhName_cpazi;
  public String m_cServer_cpazi;
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_log_app;
  public String m_cServer_log_app;
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
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
  public String m_cPhName_xperazbo;
  public String m_cServer_xperazbo;
  public String m_cPhName_xraziobo;
  public String m_cServer_xraziobo;
  public String m_cPhName_archmovi_in;
  public String m_cServer_archmovi_in;
  public String m_cPhName_archmovi_err;
  public String m_cServer_archmovi_err;
  public String m_cPhName_sogopebo;
  public String m_cServer_sogopebo;
  public String m_cPhName_sogopefbo;
  public String m_cServer_sogopefbo;
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
  public double oNumNew;
  public double oNumMod;
  public double oNumDel;
  public double oNumInv;
  public double sNumNew;
  public double sNumMod;
  public double sNumInv;
  public double nTotErr;
  public java.sql.Date _datope;
  public java.sql.Date _datreg;
  public java.sql.Date _datimp;
  public java.sql.Date _datnas;
  public java.sql.Date _datemi;
  public java.sql.Date _datval;
  public double _recok;
  public String _txterr;
  public String _gAzienda;
  public String _chiave;
  public String _flgfile;
  public String _oldazi;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_imp_dati_storico_sched_tabs
  public String[] lista;
  public int conteggio;
  public int i;
  public int contanome;
  // * --- Fine Area Manuale
  public arrt_imp_dati_storico_sched_tabsR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_imp_dati_storico_sched_tabs",m_Caller);
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_cPhName_cpazi = p_ContextObject.GetPhName("cpazi");
    m_cServer_cpazi = p_ContextObject.GetServer("cpazi");
    m_cPhName_fraziobo = p_ContextObject.GetPhName("fraziobo");
    m_cServer_fraziobo = p_ContextObject.GetServer("fraziobo");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_log_app = p_ContextObject.GetPhName("log_app");
    m_cServer_log_app = p_ContextObject.GetServer("log_app");
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
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
    m_cPhName_xperazbo = p_ContextObject.GetPhName("xperazbo");
    m_cServer_xperazbo = p_ContextObject.GetServer("xperazbo");
    m_cPhName_xraziobo = p_ContextObject.GetPhName("xraziobo");
    m_cServer_xraziobo = p_ContextObject.GetServer("xraziobo");
    m_cPhName_archmovi_in = p_ContextObject.GetPhName("archmovi_in");
    m_cServer_archmovi_in = p_ContextObject.GetServer("archmovi_in");
    m_cPhName_archmovi_err = p_ContextObject.GetPhName("archmovi_err");
    m_cServer_archmovi_err = p_ContextObject.GetServer("archmovi_err");
    m_cPhName_sogopebo = p_ContextObject.GetPhName("sogopebo");
    m_cServer_sogopebo = p_ContextObject.GetServer("sogopebo");
    m_cPhName_sogopefbo = p_ContextObject.GetPhName("sogopefbo");
    m_cServer_sogopefbo = p_ContextObject.GetServer("sogopefbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
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
    if (CPLib.eqr("_newop",p_cVarName)) {
      return _newop;
    }
    if (CPLib.eqr("numriga",p_cVarName)) {
      return numriga;
    }
    if (CPLib.eqr("chkat",p_cVarName)) {
      return chkat;
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
    if (CPLib.eqr("oNumNew",p_cVarName)) {
      return oNumNew;
    }
    if (CPLib.eqr("oNumMod",p_cVarName)) {
      return oNumMod;
    }
    if (CPLib.eqr("oNumDel",p_cVarName)) {
      return oNumDel;
    }
    if (CPLib.eqr("oNumInv",p_cVarName)) {
      return oNumInv;
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
    if (CPLib.eqr("nTotErr",p_cVarName)) {
      return nTotErr;
    }
    if (CPLib.eqr("_recok",p_cVarName)) {
      return _recok;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_imp_dati_storico_sched_tabs";
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
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("cDNAS",p_cVarName)) {
      return cDNAS;
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
    return null;
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
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
    if (CPLib.eqr("oNumNew",p_cVarName)) {
      oNumNew = value;
      return;
    }
    if (CPLib.eqr("oNumMod",p_cVarName)) {
      oNumMod = value;
      return;
    }
    if (CPLib.eqr("oNumDel",p_cVarName)) {
      oNumDel = value;
      return;
    }
    if (CPLib.eqr("oNumInv",p_cVarName)) {
      oNumInv = value;
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
    if (CPLib.eqr("nTotErr",p_cVarName)) {
      nTotErr = value;
      return;
    }
    if (CPLib.eqr("_recok",p_cVarName)) {
      _recok = value;
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
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("cDNAS",p_cVarName)) {
      cDNAS = value;
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
    CPResultSet Cursor_qbe_movi_input=null;
    CPResultSet Cursor_qbe_movi_input_select=null;
    CPResultSet Cursor_archmovi_in=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Definizione variabili locali */
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
      /* cProg Char(10) // Messaggio */
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
      /* oNumNew Numeric(10, 0) */
      /* oNumMod Numeric(10, 0) */
      /* oNumDel Numeric(10, 0) */
      /* oNumInv Numeric(10, 0) // Contatore record invariati */
      /* sNumNew Numeric(10, 0) */
      /* sNumMod Numeric(10, 0) */
      /* sNumInv Numeric(10, 0) */
      /* nTotErr Numeric(10, 0) */
      /* _datope Date */
      /* _datreg Date */
      /* _datimp Date */
      /* _datnas Date */
      /* _datemi Date */
      /* _datval Date */
      /* _recok Numeric(1, 0) */
      /* _txterr Memo */
      /* _gAzienda Char(10) // Azienda */
      /* _chiave Char(20) */
      /* _flgfile Char(1) */
      /* _oldazi Char(10) */
      /* Utilities.SetUserCode(1) */
      Utilities.Make(m_Ctx,m_Caller).SetUserCode(1);
      /* _chiave := '' */
      _chiave = "";
      /* _oldazi := Utilities.GetCompany() */
      _oldazi = Utilities.Make(m_Ctx,m_Caller).GetCompany();
      /* _gMsgProc := _gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + NL */
      _gMsgProc = _gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
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
        /* _max := 0 */
        _max = CPLib.Round(0,0);
        /* _min := 0 */
        _min = CPLib.Round(0,0);
        /* _totale := 0 */
        _totale = CPLib.Round(0,0);
        // * --- Select from qbe_movi_input
        if (Cursor_qbe_movi_input!=null)
          Cursor_qbe_movi_input.Close();
        Cursor_qbe_movi_input = new VQRHolder("qbe_movi_input",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_movi_input.Eof())) {
          /* _totale := qbe_movi_input->TOTALE */
          _totale = CPLib.Round(Cursor_qbe_movi_input.GetDouble("TOTALE"),0);
          /* _max := qbe_movi_input->MASSIMO */
          _max = CPLib.Round(Cursor_qbe_movi_input.GetDouble("MASSIMO"),0);
          /* _min := qbe_movi_input->MINIMO */
          _min = CPLib.Round(Cursor_qbe_movi_input.GetDouble("MINIMO"),0);
          Cursor_qbe_movi_input.Next();
        }
        m_cConnectivityError = Cursor_qbe_movi_input.ErrorMessage();
        Cursor_qbe_movi_input.Close();
        // * --- End Select
        /* _flgfile := iif(_totale>0,'S','N') */
        _flgfile = (CPLib.gt(_totale,0)?"S":"N");
        /* If _flgfile='S' */
        if (CPLib.eqr(_flgfile,"S")) {
          // Begin Transaction
          m_Sql.RequireTransaction();
          double nTry05F96220status;
          nTry05F96220status = m_Sql.GetTransactionStatus();
          String cTry05F96220msg;
          cTry05F96220msg = m_Sql.TransactionErrorMessage();
          try {
            /* dNumNew := 0 */
            dNumNew = CPLib.Round(0,0);
            /* dNumMod := 0 */
            dNumMod = CPLib.Round(0,0);
            /* oNumNew := 0 */
            oNumNew = CPLib.Round(0,0);
            /* oNumMod := 0 */
            oNumMod = CPLib.Round(0,0);
            /* oNumDel := 0 */
            oNumDel = CPLib.Round(0,0);
            /* sNumNew := 0 */
            sNumNew = CPLib.Round(0,0);
            /* sNumMod := 0 */
            sNumMod = CPLib.Round(0,0);
            /* sNumInv := 0 */
            sNumInv = CPLib.Round(0,0);
            /* nTotErr := 0 */
            nTotErr = CPLib.Round(0,0);
            /* _contacilci := 1 */
            _contacilci = CPLib.Round(1,0);
            /* _cicli := iif(Mod(_max,1000) <> 0,Int(_max/1000) + 1,Int(_max/1000)) */
            _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,1000),0)?CPLib.Int(_max/1000)+1:CPLib.Int(_max/1000)),0);
            /* While _contacilci<=_cicli */
            while (CPLib.le(_contacilci,_cicli)) {
              /* _bottom := ((_contacilci -1 ) * 1000) + 1 */
              _bottom = CPLib.Round(((_contacilci-1)*1000)+1,0);
              /* _top := _contacilci * 1000 */
              _top = CPLib.Round(_contacilci*1000,0);
              // * --- Select from qbe_movi_input_select
              SPBridge.HMCaller _hBCHSQFOKGP;
              _hBCHSQFOKGP = new SPBridge.HMCaller();
              _hBCHSQFOKGP.Set("m_cVQRList",m_cVQRList);
              _hBCHSQFOKGP.Set("_bottom",_bottom);
              _hBCHSQFOKGP.Set("_top",_top);
              if (Cursor_qbe_movi_input_select!=null)
                Cursor_qbe_movi_input_select.Close();
              Cursor_qbe_movi_input_select = new VQRHolder("qbe_movi_input_select",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_hBCHSQFOKGP,true).GetResultSet(m_Ctx);
              while ( ! (Cursor_qbe_movi_input_select.Eof())) {
                /* _recok := 0 */
                _recok = CPLib.Round(0,0);
                /* _txterr := '' */
                _txterr = "";
                /* _movcod := qbe_movi_input_select->MCODMOV */
                _movcod = CPLib.Round(Cursor_qbe_movi_input_select.GetDouble("MCODMOV"),0);
                /* Exec "Controlli per proseguire nella scrittura" Page 7:Page_7 */
                Page_7();
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
                /* If _recok=0 */
                if (CPLib.eqr(_recok,0)) {
                  /* Exec "Dipendenze" Page 5:Page_5 */
                  Page_5();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                  /* Exec "Soggetti" Page 2:Page_2 */
                  Page_2();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                  /* Exec "Operazioni" Page 3:Page_3 */
                  Page_3();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                } else { // Else
                  // * --- Select from archmovi_in
                  m_cServer = m_Ctx.GetServer("archmovi_in");
                  m_cPhName = m_Ctx.GetPhName("archmovi_in");
                  if (Cursor_archmovi_in!=null)
                    Cursor_archmovi_in.Close();
                  Cursor_archmovi_in = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"MCODMOV="+CPSql.SQLValueAdapter(CPLib.ToSQL(_movcod,"?",0,0,m_cServer, m_oParameters),m_cServer,_movcod)+" "+")"+(m_Ctx.IsSharedTemp("archmovi_in")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_archmovi_in.Eof())) {
                    // * --- Insert into archmovi_err from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("archmovi_err");
                    m_cPhName = m_Ctx.GetPhName("archmovi_err");
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.InsertIntoStatement(m_Ctx,"archmovi_err")+" (";
                    m_cSql = m_cSql+GetFieldsName_05DE4BA8(m_Ctx);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetDouble("MCODMOV"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("PCODCAB"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("PRAGSOC"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("PDOMICILIO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("PCONNES"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("PDATANASC"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("PNASCOMUN"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("PSOTGRUP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("PRAMOGRUP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("PSETTSINT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("PTIPODOC"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("PNUMDOCUM"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("PDATARILASC"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("PAUTRILASC"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("PDESCCIT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("PPROVINCIA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("PPAESE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("PCAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("PPARTIVA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("PSESSO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("PDATAVALI"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("PCOGNOME"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("PNOME"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("PDOCFILE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("PPROVNAS"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("PCFESTERO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("PSPECIE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("PCOMPORT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("PATTIV"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("PAREAGEO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetDouble("PRNATGIU"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetDouble("PRCOMP"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetDouble("PRATTIV"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetDouble("PRAREA"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("PCODFISC"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("PPEP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("ODATAOPE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("OFLAGCONT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("OCODANA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("OCODVOC"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("OTIPOINT2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("OCODINT2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("OPAESE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("ODESC2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("OPROV2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("OCODCAB2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("ODESCINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("ORAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("OFLAGRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("OTIPOLEG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("ODATAREG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("OFLAGLIRE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("OVALUTA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("OSEGNO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetDouble("OTOTLIRE"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetDouble("OTOTCONT"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("OCONNESOPER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetDouble("OCAMBIO"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("ONUMPROG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("OTIPOOPRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("OTIPOINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("OCODINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("ODESCCIT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("OPROVINCIA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("OCODCAB"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("OFLAGFRAZ"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("OCONNESBEN"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("OUNIQUECODE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("OAGOPER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("ORIFIMP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("OZCPARTE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("ORAGIO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("OMODSVOL"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("OAREAGEO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("OINFORM"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("OAMMONT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("ODURAT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("OTIPO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetDouble("ORRAGIO"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetDouble("ORCOMP"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetDouble("ORAREA"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetDouble("ORIMP"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetDouble("ORFREQ"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("OCONNALTRO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("ODATAIMP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetDouble("ORTIPO"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("OC_RAG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("OC_STA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("OC_CTA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("OC_CAB"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("OC_PRV"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("OC_IND"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("OC_CAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("ONATURA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("OSCOPO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("OC_RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("ORAPPORTBEN"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("OPAGASOGOP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("DCODDIP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("DDESCRIZ"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("DDESCCIT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("DPROVINCIA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("DCAB"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_archmovi_in.GetString("DAGENTE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_txterr,"?",0,0,m_cServer, m_oParameters)+", ";
                    if (m_Ctx.IsSharedTemp("archmovi_err")) {
                      m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                    }
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"archmovi_err",true);
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
                    Cursor_archmovi_in.Next();
                  }
                  m_cConnectivityError = Cursor_archmovi_in.ErrorMessage();
                  Cursor_archmovi_in.Close();
                  // * --- End Select
                  /* nTotErr := nTotErr + 1 */
                  nTotErr = CPLib.Round(nTotErr+1,0);
                } // End If
                // * --- Delete from archmovi_in
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("archmovi_in");
                m_cPhName = m_Ctx.GetPhName("archmovi_in");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "delete from "+m_cPhName;
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"MCODMOV = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_movcod,"?",0,0,m_cServer),m_cServer,_movcod)+"";
                if (m_Ctx.IsSharedTemp("archmovi_in")) {
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
                Cursor_qbe_movi_input_select.Next();
              }
              m_cConnectivityError = Cursor_qbe_movi_input_select.ErrorMessage();
              Cursor_qbe_movi_input_select.Close();
              // * --- End Select
              /* _contacilci := _contacilci+1 */
              _contacilci = CPLib.Round(_contacilci+1,0);
            } // End While
            // Commit
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
            m_Sql.CompleteTransaction();
            /* If nTotErr = 0 */
            if (CPLib.eqr(nTotErr,0)) {
              /* _chiave := 'COMPLETED OK' */
              _chiave = "COMPLETED OK";
            } else { // Else
              /* _chiave := 'COMPLETED WITH WASTE' */
              _chiave = "COMPLETED WITH WASTE";
            } // End If
          } catch(Exception l_exeption) {
            Stop.ReactToException(l_exeption);
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            /* _gMsgProc := _gMsgProc + "Rilevati errori nell'impotazione dei file! Ricreare il file segnalato e rieseguire l'import dei dati. La procedura annullera automaticamente l'importazione" + NL */
            _gMsgProc = _gMsgProc+"Rilevati errori nell'impotazione dei file! Ricreare il file segnalato e rieseguire l'import dei dati. La procedura annullera automaticamente l'importazione"+"\n";
            /* _gMsgProc := _gMsgProc + 'Errore SQL: ' + m_Sql.TransactionErrorMessage() + NL */
            _gMsgProc = _gMsgProc+"Errore SQL: "+m_Sql.TransactionErrorMessage()+"\n";
            // Rollback
            m_Sql.AbortTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            m_bError = true;
            m_Sql.CompleteTransaction();
            /* _chiave := 'ERRORS' */
            _chiave = "ERRORS";
          } finally {
            if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry05F96220status,0)) {
              m_Sql.SetTransactionStatus(nTry05F96220status,cTry05F96220msg);
            }
          }
        } else { // Else
          /* _chiave := 'NORECORDS' */
          _chiave = "NORECORDS";
        } // End If
        /* _gMsgProc := _gMsgProc + 'Dipendenze Inserite: '+LRTrim(Str(dNumNew,10,0)) + ' - Dipendenze Aggiornate: '+LRTrim(Str(dNumMod,10,0)) + NL */
        _gMsgProc = _gMsgProc+"Dipendenze Inserite: "+CPLib.LRTrim(CPLib.Str(dNumNew,10,0))+" - Dipendenze Aggiornate: "+CPLib.LRTrim(CPLib.Str(dNumMod,10,0))+"\n";
        /* _gMsgProc := _gMsgProc + 'Soggetti Inseriti: '+LRTrim(Str(sNumNew,10,0)) + ' - Soggetti Aggiornati: '+LRTrim(Str(sNumMod,10,0)) + ' - Soggetti Invariati: '+LRTrim(Str(sNumInv,10,0)) + NL */
        _gMsgProc = _gMsgProc+"Soggetti Inseriti: "+CPLib.LRTrim(CPLib.Str(sNumNew,10,0))+" - Soggetti Aggiornati: "+CPLib.LRTrim(CPLib.Str(sNumMod,10,0))+" - Soggetti Invariati: "+CPLib.LRTrim(CPLib.Str(sNumInv,10,0))+"\n";
        /* _gMsgProc := _gMsgProc + 'Operazioni Inserite: '+LRTrim(Str(oNumNew,10,0)) + ' - Operazioni Aggiornate: '+LRTrim(Str(oNumMod,10,0)) + ' - Operazioni Cancellate: '+LRTrim(Str(oNumDel,10,0)) + NL */
        _gMsgProc = _gMsgProc+"Operazioni Inserite: "+CPLib.LRTrim(CPLib.Str(oNumNew,10,0))+" - Operazioni Aggiornate: "+CPLib.LRTrim(CPLib.Str(oNumMod,10,0))+" - Operazioni Cancellate: "+CPLib.LRTrim(CPLib.Str(oNumDel,10,0))+"\n";
        /* If nTotErr > 0 */
        if (CPLib.gt(nTotErr,0)) {
          /* _gMsgProc := _gMsgProc + 'Sono stati rilevati '+LRTrim(Str(nTotErr,10,0)) + ' record con errori. Consultare la tabella per verificarne le tipologie.' + NL */
          _gMsgProc = _gMsgProc+"Sono stati rilevati "+CPLib.LRTrim(CPLib.Str(nTotErr,10,0))+" record con errori. Consultare la tabella per verificarne le tipologie."+"\n";
        } // End If
        /* cProg := Utilities.GetAutonumber("PRGLOG\'"+LRTrim(_gAzienda)+"'",'',20) */
        cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGLOG\\'"+CPLib.LRTrim(_gAzienda)+"'","",20);
        // * --- Insert into log_app from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("log_app");
        m_cPhName = m_Ctx.GetPhName("log_app");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"log_app")+" (";
        m_cSql = m_cSql+GetFieldsName_05FC65F8(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Import Dati","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_gMsgProc,"?",0,0,m_cServer, m_oParameters)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Scheduler","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_chiave,"?",0,0,m_cServer)+", ";
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
        /* _gMsgProc := '' */
        _gMsgProc = "";
        Cursor_cpazi.Next();
      }
      m_cConnectivityError = Cursor_cpazi.ErrorMessage();
      Cursor_cpazi.Close();
      // * --- End Select
      /* Utilities.SetCompany(_oldazi) */
      Utilities.Make(m_Ctx,m_Caller).SetCompany(_oldazi);
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
      try {
        if (Cursor_qbe_movi_input!=null)
          Cursor_qbe_movi_input.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_movi_input_select!=null)
          Cursor_qbe_movi_input_select.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_archmovi_in!=null)
          Cursor_archmovi_in.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_qbe_movi_input_archpers=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_personbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Soggetti */
      // * --- Select from qbe_movi_input_archpers
      SPBridge.HMCaller _hAGIGNNIAUB;
      _hAGIGNNIAUB = new SPBridge.HMCaller();
      _hAGIGNNIAUB.Set("m_cVQRList",m_cVQRList);
      _hAGIGNNIAUB.Set("_movcod",_movcod);
      if (Cursor_qbe_movi_input_archpers!=null)
        Cursor_qbe_movi_input_archpers.Close();
      Cursor_qbe_movi_input_archpers = new VQRHolder("qbe_movi_input_archpers",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_hAGIGNNIAUB,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_movi_input_archpers.Eof())) {
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
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        /* numriga := numriga + 1 */
        numriga = CPLib.Round(numriga+1,0);
        /* cSetSin := '' */
        cSetSin = "";
        /* xRagSoc := Upper(LRTrim(qbe_movi_input_archpers->PRAGSOC)) */
        xRagSoc = CPLib.Upper(CPLib.LRTrim(Cursor_qbe_movi_input_archpers.GetString("PRAGSOC")));
        /* xCodCab := qbe_movi_input_archpers->PCODCAB */
        xCodCab = Cursor_qbe_movi_input_archpers.GetString("PCODCAB");
        /* cCli1 := qbe_movi_input_archpers->PCONNES */
        cCli1 = Cursor_qbe_movi_input_archpers.GetString("PCONNES");
        /* xCF := qbe_movi_input_archpers->PCODFISC */
        xCF = Cursor_qbe_movi_input_archpers.GetString("PCODFISC");
        /* xCFE := iif((qbe_movi_input_archpers->PCFESTERO='S' or qbe_movi_input_archpers->PCFESTERO='1'),1,0) */
        xCFE = CPLib.Round(((CPLib.eqr(Cursor_qbe_movi_input_archpers.GetString("PCFESTERO"),"S") || CPLib.eqr(Cursor_qbe_movi_input_archpers.GetString("PCFESTERO"),"1"))?1:0),0);
        /* If Empty(LRTrim(xCodCab)) */
        if (CPLib.Empty(CPLib.LRTrim(xCodCab))) {
          /* xCitta := qbe_movi_input_archpers->PDESCCIT */
          xCitta = Cursor_qbe_movi_input_archpers.GetString("PDESCCIT");
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
              Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_imp_dati_storico_sched_tabs returns two or more records. This item should return only a record.");
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
        /* xAnnNas := Substr(qbe_movi_input_archpers->PDATANASC,5,4) // Anno Di Nascita */
        xAnnNas = CPLib.Substr(Cursor_qbe_movi_input_archpers.GetString("PDATANASC"),5,4);
        /* xMesNas := Substr(qbe_movi_input_archpers->PDATANASC,3,2) // Mese Di Nascita */
        xMesNas = CPLib.Substr(Cursor_qbe_movi_input_archpers.GetString("PDATANASC"),3,2);
        /* xDayNas := Substr(qbe_movi_input_archpers->PDATANASC,1,2) // Giorno Di Nascita */
        xDayNas = CPLib.Substr(Cursor_qbe_movi_input_archpers.GetString("PDATANASC"),1,2);
        /* cDNAS := _datnas */
        cDNAS = _datnas;
        /* xSesso := iif(qbe_movi_input_archpers->PSESSO='M','1',iif(qbe_movi_input_archpers->PSESSO='F','2','')) */
        xSesso = (CPLib.eqr(Cursor_qbe_movi_input_archpers.GetString("PSESSO"),"M")?"1":(CPLib.eqr(Cursor_qbe_movi_input_archpers.GetString("PSESSO"),"F")?"2":""));
        /* If not(Empty(LRTrim(qbe_movi_input_archpers->PPROVNAS))) */
        if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_movi_input_archpers.GetString("PPROVNAS"))))) {
          /* If LRTrim(qbe_movi_input_archpers->PPROVNAS)='EE' */
          if (CPLib.eqr(CPLib.LRTrim(Cursor_qbe_movi_input_archpers.GetString("PPROVNAS")),"EE")) {
            /* cSNAS := '' */
            cSNAS = "";
            // * --- Read from tbstati
            m_cServer = m_Ctx.GetServer("tbstati");
            m_cPhName = m_Ctx.GetPhName("tbstati");
            m_cSql = "";
            m_cSql = m_cSql+"DESCRI="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_movi_input_archpers.GetString("PNASCOMUN"),"C",40,0,m_cServer),m_cServer,Cursor_qbe_movi_input_archpers.GetString("PNASCOMUN"));
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
                Error l_oErrorFault = new Error("Read on tbstati into routine arrt_imp_dati_storico_sched_tabs returns two or more records. This item should return only a record.");
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
              /* cSNAS := qbe_movi_input_archpers->PNASCOMUN */
              cSNAS = Cursor_qbe_movi_input_archpers.GetString("PNASCOMUN");
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
            m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_movi_input_archpers.GetString("PNASCOMUN"),"C",40,0,m_cServer),m_cServer,Cursor_qbe_movi_input_archpers.GetString("PNASCOMUN"));
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
                Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_imp_dati_storico_sched_tabs returns two or more records. This item should return only a record.");
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
              /* cCNAS := qbe_movi_input_archpers->PNASCOMUN */
              cCNAS = Cursor_qbe_movi_input_archpers.GetString("PNASCOMUN");
            } // End If
            /* cSNAS := '' */
            cSNAS = "";
          } // End If
        } else { // Else
          /* cSNAS := qbe_movi_input_archpers->PNASCOMUN */
          cSNAS = Cursor_qbe_movi_input_archpers.GetString("PNASCOMUN");
          /* cCNAS := qbe_movi_input_archpers->PNASCOMUN */
          cCNAS = Cursor_qbe_movi_input_archpers.GetString("PNASCOMUN");
          /* cPNAS := '' */
          cPNAS = "";
        } // End If
        /* xRiga1 := LibreriaMit.SpacePad(xCF,16) */
        xRiga1 = LibreriaMit.SpacePad(xCF,16);
        /* xRiga1 := xRiga1 + LibreriaMit.SpacePad(qbe_movi_input_archpers->PRAGSOC,70) */
        xRiga1 = xRiga1+LibreriaMit.SpacePad(Cursor_qbe_movi_input_archpers.GetString("PRAGSOC"),70);
        /* xRiga1 := xRiga1 + LibreriaMit.SpacePad(qbe_movi_input_archpers->PDOMICILIO,35) */
        xRiga1 = xRiga1+LibreriaMit.SpacePad(Cursor_qbe_movi_input_archpers.GetString("PDOMICILIO"),35);
        /* xRiga1 := xRiga1 + LibreriaMit.SpacePad(qbe_movi_input_archpers->PDESCCIT,30) */
        xRiga1 = xRiga1+LibreriaMit.SpacePad(Cursor_qbe_movi_input_archpers.GetString("PDESCCIT"),30);
        /* xRiga1 := xRiga1 + LibreriaMit.SpacePad(qbe_movi_input_archpers->PPROVINCIA,2) */
        xRiga1 = xRiga1+LibreriaMit.SpacePad(Cursor_qbe_movi_input_archpers.GetString("PPROVINCIA"),2);
        /* xRiga1 := xRiga1 + LibreriaMit.SpacePad(LRTrim(qbe_movi_input_archpers->PCAP),5) */
        xRiga1 = xRiga1+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_qbe_movi_input_archpers.GetString("PCAP")),5);
        /* xRiga1 := xRiga1 + LibreriaMit.SpacePad(qbe_movi_input_archpers->PPAESE,3) */
        xRiga1 = xRiga1+LibreriaMit.SpacePad(Cursor_qbe_movi_input_archpers.GetString("PPAESE"),3);
        /* xRiga1 := xRiga1 + LibreriaMit.SpacePad(qbe_movi_input_archpers->PSOTGRUP,3) */
        xRiga1 = xRiga1+LibreriaMit.SpacePad(Cursor_qbe_movi_input_archpers.GetString("PSOTGRUP"),3);
        /* xRiga1 := xRiga1 + LibreriaMit.SpacePad(qbe_movi_input_archpers->PRAMOGRUP,3) */
        xRiga1 = xRiga1+LibreriaMit.SpacePad(Cursor_qbe_movi_input_archpers.GetString("PRAMOGRUP"),3);
        /* xRiga1 := xRiga1 + LibreriaMit.SpacePad(qbe_movi_input_archpers->PSETTSINT,3) */
        xRiga1 = xRiga1+LibreriaMit.SpacePad(Cursor_qbe_movi_input_archpers.GetString("PSETTSINT"),3);
        /* xRiga1 := xRiga1 + LibreriaMit.SpacePad(Left(cCNAS,30),30) */
        xRiga1 = xRiga1+LibreriaMit.SpacePad(CPLib.Left(cCNAS,30),30);
        /* xRiga1 := xRiga1 + LibreriaMit.SpacePad(cPNAS,2) */
        xRiga1 = xRiga1+LibreriaMit.SpacePad(cPNAS,2);
        /* xRiga1 := xRiga1 + LibreriaMit.SpacePad(Left(cSNAS,30),30) */
        xRiga1 = xRiga1+LibreriaMit.SpacePad(CPLib.Left(cSNAS,30),30);
        /* xRiga1 := xRiga1 + iif(DateToChar(_datnas) <> '01000101',LibreriaMit.SpacePad(DateToChar(_datnas),8),Space(8)) */
        xRiga1 = xRiga1+(CPLib.ne(CPLib.DateToChar(_datnas),"01000101")?LibreriaMit.SpacePad(CPLib.DateToChar(_datnas),8):CPLib.Space(8));
        /* xRiga1 := xRiga1 +LibreriaMit.SpacePad(qbe_movi_input_archpers->PTIPODOC,2) */
        xRiga1 = xRiga1+LibreriaMit.SpacePad(Cursor_qbe_movi_input_archpers.GetString("PTIPODOC"),2);
        /* xRiga1 := xRiga1 +LibreriaMit.SpacePad(qbe_movi_input_archpers->PNUMDOCUM,15) */
        xRiga1 = xRiga1+LibreriaMit.SpacePad(Cursor_qbe_movi_input_archpers.GetString("PNUMDOCUM"),15);
        /* xRiga1 := xRiga1 + iif(DateToChar(_datemi) <> '01000101',LibreriaMit.SpacePad(DateToChar(_datemi),8),Space(8)) */
        xRiga1 = xRiga1+(CPLib.ne(CPLib.DateToChar(_datemi),"01000101")?LibreriaMit.SpacePad(CPLib.DateToChar(_datemi),8):CPLib.Space(8));
        /* xRiga1 := xRiga1 +LibreriaMit.SpacePad(qbe_movi_input_archpers->PAUTRILASC,30) */
        xRiga1 = xRiga1+LibreriaMit.SpacePad(Cursor_qbe_movi_input_archpers.GetString("PAUTRILASC"),30);
        /* xRiga1 := xRiga1 +LibreriaMit.SpacePad(qbe_movi_input_archpers->PPARTIVA,14) */
        xRiga1 = xRiga1+LibreriaMit.SpacePad(Cursor_qbe_movi_input_archpers.GetString("PPARTIVA"),14);
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
          /* xRiga2 := xRiga2 +LibreriaMit.SpacePad(personbo->PARTIVA,14) */
          xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("PARTIVA"),14);
          /* xConnes := personbo->CONNES */
          xConnes = Cursor_personbo.GetString("CONNES");
          Cursor_personbo.Next();
        }
        m_cConnectivityError = Cursor_personbo.ErrorMessage();
        Cursor_personbo.Close();
        // * --- End Select
        /* If Empty(LRTrim(qbe_movi_input_archpers->PSETTSINT)) */
        if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_movi_input_archpers.GetString("PSETTSINT")))) {
          /* cSetSin := arfn_calcolasett(qbe_movi_input_archpers->PSOTGRUP,qbe_movi_input_archpers->PRAMOGRUP,qbe_movi_input_archpers->PATTIV) */
          cSetSin = arfn_calcolasettR.Make(m_Ctx,this).Run(Cursor_qbe_movi_input_archpers.GetString("PSOTGRUP"),Cursor_qbe_movi_input_archpers.GetString("PRAMOGRUP"),Cursor_qbe_movi_input_archpers.GetString("PATTIV"));
        } else { // Else
          /* cSetSin := qbe_movi_input_archpers->PSETTSINT */
          cSetSin = Cursor_qbe_movi_input_archpers.GetString("PSETTSINT");
        } // End If
        /* _tipper := iif(Empty(LRTrim(qbe_movi_input_archpers->PSESSO)),'G','P') */
        _tipper = (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_movi_input_archpers.GetString("PSESSO")))?"G":"P");
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
            /* xNome := qbe_movi_input_archpers->PNOME */
            xNome = Cursor_qbe_movi_input_archpers.GetString("PNOME");
            /* xCognome := qbe_movi_input_archpers->PCOGNOME */
            xCognome = Cursor_qbe_movi_input_archpers.GetString("PCOGNOME");
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
              m_cSql = m_cSql+GetFieldsName_06583858(m_Ctx);
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
                /* _gMsgProc := _gMsgProc +"Rilevati errori nel file per il soggetto: "+LRTrim(qbe_movi_input_archpers->PRAGSOC)+" con codice: "+LRTrim(qbe_movi_input_archpers->PCONNES)+". Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                _gMsgProc = _gMsgProc+"Rilevati errori nel file per il soggetto: "+CPLib.LRTrim(Cursor_qbe_movi_input_archpers.GetString("PRAGSOC"))+" con codice: "+CPLib.LRTrim(Cursor_qbe_movi_input_archpers.GetString("PCONNES"))+". Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                /* _esito := 1 */
                _esito = CPLib.Round(1,0);
                // Exit Loop
                if (true) {
                  break;
                }
              } else if (CPLib.ne(m_cLastMsgError,"")) {
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
            m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.Left(Cursor_qbe_movi_input_archpers.GetString("PRAGSOC"),70),"C",70,0,m_cServer)+", ";
            m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(CPLib.Left(Cursor_qbe_movi_input_archpers.GetString("PDOMICILIO"),35),"C",35,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_qbe_movi_input_archpers.GetString("PCODFISC"),"C",16,0,m_cServer)+", ";
            m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(cDNAS,"D",8,0)+", ";
            m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(CPLib.Left(cCNAS,30),"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_qbe_movi_input_archpers.GetString("PSOTGRUP"),"C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_qbe_movi_input_archpers.GetString("PRAMOGRUP"),"C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(cSetSin,"C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_qbe_movi_input_archpers.GetString("PTIPODOC"),"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(CPLib.Left(Cursor_qbe_movi_input_archpers.GetString("PNUMDOCUM"),15),"C",15,0,m_cServer)+", ";
            m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(_datemi,"D",8,0)+", ";
            m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_qbe_movi_input_archpers.GetString("PAUTRILASC"),"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.Left(Cursor_qbe_movi_input_archpers.GetString("PDESCCIT"),30),"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_qbe_movi_input_archpers.GetString("PPROVINCIA"),"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_qbe_movi_input_archpers.GetString("PPAESE"),"C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_qbe_movi_input_archpers.GetString("PCAP"),"C",9,0,m_cServer)+", ";
            m_cSql = m_cSql+"PARTIVA = "+CPLib.ToSQL(Cursor_qbe_movi_input_archpers.GetString("PPARTIVA"),"C",14,0,m_cServer)+", ";
            m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(xSesso,"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"DATAVALI = "+CPLib.ToSQL(_datval,"D",8,0)+", ";
            m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(xCognome,"C",26,0,m_cServer)+", ";
            m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(xNome,"C",25,0,m_cServer)+", ";
            m_cSql = m_cSql+"DOCFILE = "+CPLib.ToSQL(Cursor_qbe_movi_input_archpers.GetString("PDOCFILE"),"C",100,0,m_cServer)+", ";
            m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(cPNAS,"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(xCFE,"N",1,0)+", ";
            m_cSql = m_cSql+"PKTBSPECIE = "+CPLib.ToSQL(Cursor_qbe_movi_input_archpers.GetString("PSPECIE"),"C",4,0,m_cServer)+", ";
            m_cSql = m_cSql+"COMPORT = "+CPLib.ToSQL(Cursor_qbe_movi_input_archpers.GetString("PCOMPORT"),"C",5,0,m_cServer)+", ";
            m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_qbe_movi_input_archpers.GetString("PATTIV"),"C",10,0,m_cServer)+", ";
            m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(CPLib.Left(cSNAS,30),"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"RAGSOCOLD = "+CPLib.ToSQL(CPLib.Left(Cursor_qbe_movi_input_archpers.GetString("PRAGSOC"),70),"C",70,0,m_cServer)+", ";
            m_cSql = m_cSql+"ALLINEATONOMECNOME = "+CPLib.ToSQL(_allcn,"N",1,0)+", ";
            m_cSql = m_cSql+"AREAGEO = "+CPLib.ToSQL(Cursor_qbe_movi_input_archpers.GetString("PAREAGEO"),"C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"PEP = "+CPLib.ToSQL((CPLib.Empty(Cursor_qbe_movi_input_archpers.GetString("PPEP"))?"N":Cursor_qbe_movi_input_archpers.GetString("PPEP")),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"TIPOPERS = "+CPLib.ToSQL(_tipper,"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"RNATGIU = "+CPLib.ToSQL(Cursor_qbe_movi_input_archpers.GetDouble("PRNATGIU"),"N",3,0)+", ";
            m_cSql = m_cSql+"RATTIV = "+CPLib.ToSQL(Cursor_qbe_movi_input_archpers.GetDouble("PRATTIV"),"N",3,0)+", ";
            m_cSql = m_cSql+"RCOMP = "+CPLib.ToSQL(Cursor_qbe_movi_input_archpers.GetDouble("PRCOMP"),"N",3,0)+", ";
            m_cSql = m_cSql+"RAREA = "+CPLib.ToSQL(Cursor_qbe_movi_input_archpers.GetDouble("PRAREA"),"N",3,0)+", ";
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
              /* _gMsgProc := _gMsgProc +"Rilevati errori nel file per il soggetto: "+LRTrim(qbe_movi_input_archpers->PRAGSOC)+" con codice: "+LRTrim(qbe_movi_input_archpers->PCONNES)+". Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
              _gMsgProc = _gMsgProc+"Rilevati errori nel file per il soggetto: "+CPLib.LRTrim(Cursor_qbe_movi_input_archpers.GetString("PRAGSOC"))+" con codice: "+CPLib.LRTrim(Cursor_qbe_movi_input_archpers.GetString("PCONNES"))+". Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
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
            /* Exec "Allinea Anagrafiche" Page 6:Page_6 */
            Page_6();
            /* sNumMod := sNumMod + 1 */
            sNumMod = CPLib.Round(sNumMod+1,0);
          } else { // Else
            /* sNumInv := sNumInv + 1 // Contatore record invariati */
            sNumInv = CPLib.Round(sNumInv+1,0);
          } // End If
        } else { // Else
          /* _allcn := 0 */
          _allcn = CPLib.Round(0,0);
          /* xNome := qbe_movi_input_archpers->PNOME */
          xNome = Cursor_qbe_movi_input_archpers.GetString("PNOME");
          /* xCognome := qbe_movi_input_archpers->PCOGNOME */
          xCognome = Cursor_qbe_movi_input_archpers.GetString("PCOGNOME");
          /* nProgImp := Utilities.GetAutonumber("PRGIMPOCLI\'"+LRTrim(_gAzienda)+"'",0,15) */
          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOCLI\\'"+CPLib.LRTrim(_gAzienda)+"'",0,15),0);
          // * --- Insert into personbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"personbo")+" (";
          m_cSql = m_cSql+GetFieldsName_062E4208(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cCli1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(xCodCab,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_qbe_movi_input_archpers.GetString("PRAGSOC"),70),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_qbe_movi_input_archpers.GetString("PDOMICILIO"),35),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(xCF,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cDNAS,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(cCNAS,30),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_qbe_movi_input_archpers.GetString("PSOTGRUP"),3),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_qbe_movi_input_archpers.GetString("PRAMOGRUP"),3),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cSetSin,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_qbe_movi_input_archpers.GetString("PTIPODOC"),2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_qbe_movi_input_archpers.GetString("PNUMDOCUM"),15),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datemi,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_qbe_movi_input_archpers.GetString("PAUTRILASC"),30),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_qbe_movi_input_archpers.GetString("PDESCCIT"),30),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_qbe_movi_input_archpers.GetString("PPROVINCIA"),2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_qbe_movi_input_archpers.GetString("PPAESE"),3),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_qbe_movi_input_archpers.GetString("PCAP"),9),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archpers.GetString("PPARTIVA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(xSesso,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datval,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tipper,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(xCognome,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(xNome,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_qbe_movi_input_archpers.GetString("PDOCFILE"),100),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cPNAS,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(xCFE,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_qbe_movi_input_archpers.GetString("PSPECIE"),4),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archpers.GetString("PCOMPORT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archpers.GetString("PATTIV"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(cSNAS,30),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_allcn,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_qbe_movi_input_archpers.GetString("PRAGSOC"),70),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archpers.GetDouble("PRNATGIU"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archpers.GetDouble("PRCOMP"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archpers.GetDouble("PRATTIV"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archpers.GetDouble("PRAREA"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archpers.GetString("PAREAGEO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_qbe_movi_input_archpers.GetString("PPEP"))?"N":Cursor_qbe_movi_input_archpers.GetString("PPEP")),"?",0,0,m_cServer)+", ";
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
            /* _gMsgProc := _gMsgProc +"Rilevati errori nel file per il soggetto: "+LRTrim(qbe_movi_input_archpers->PRAGSOC)+" con codice: "+LRTrim(qbe_movi_input_archpers->PCONNES)+". Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
            _gMsgProc = _gMsgProc+"Rilevati errori nel file per il soggetto: "+CPLib.LRTrim(Cursor_qbe_movi_input_archpers.GetString("PRAGSOC"))+" con codice: "+CPLib.LRTrim(Cursor_qbe_movi_input_archpers.GetString("PCONNES"))+". Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
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
          /* sNumNew := sNumNew + 1 */
          sNumNew = CPLib.Round(sNumNew+1,0);
        } // End If
        Cursor_qbe_movi_input_archpers.Next();
      }
      m_cConnectivityError = Cursor_qbe_movi_input_archpers.ErrorMessage();
      Cursor_qbe_movi_input_archpers.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_movi_input_archpers!=null)
          Cursor_qbe_movi_input_archpers.Close();
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
    }
  }
  void Page_3() throws Exception {
    CPResultSet Cursor_qbe_movi_input_archope=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_operazbo=null;
    CPResultSet Cursor_sogopebo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Operazioni */
      // * --- Select from qbe_movi_input_archope
      SPBridge.HMCaller _hWEXDGPNDIX;
      _hWEXDGPNDIX = new SPBridge.HMCaller();
      _hWEXDGPNDIX.Set("m_cVQRList",m_cVQRList);
      _hWEXDGPNDIX.Set("_movcod",_movcod);
      if (Cursor_qbe_movi_input_archope!=null)
        Cursor_qbe_movi_input_archope.Close();
      Cursor_qbe_movi_input_archope = new VQRHolder("qbe_movi_input_archope",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_hWEXDGPNDIX,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_movi_input_archope.Eof())) {
        /* _newop := 0 */
        _newop = CPLib.Round(0,0);
        /* _intertip := iif(Empty(LRTrim(qbe_movi_input_archope->OTIPOINTER)),_tipinter,qbe_movi_input_archope->OTIPOINTER) */
        _intertip = (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_movi_input_archope.GetString("OTIPOINTER")))?_tipinter:Cursor_qbe_movi_input_archope.GetString("OTIPOINTER"));
        /* _intercod := iif(Empty(LRTrim(qbe_movi_input_archope->OCODINTER)),_codinter,qbe_movi_input_archope->OCODINTER) */
        _intercod = (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_movi_input_archope.GetString("OCODINTER")))?_codinter:Cursor_qbe_movi_input_archope.GetString("OCODINTER"));
        /* _intercit := iif(Empty(LRTrim(qbe_movi_input_archope->ODESCCIT)),_citinter,qbe_movi_input_archope->ODESCCIT) */
        _intercit = (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_movi_input_archope.GetString("ODESCCIT")))?_citinter:Cursor_qbe_movi_input_archope.GetString("ODESCCIT"));
        /* _intercab := iif(Empty(LRTrim(qbe_movi_input_archope->OCODCAB)),_cabinter,qbe_movi_input_archope->OCODCAB) */
        _intercab = (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_movi_input_archope.GetString("OCODCAB")))?_cabinter:Cursor_qbe_movi_input_archope.GetString("OCODCAB"));
        /* _interprv := iif(Empty(LRTrim(qbe_movi_input_archope->OPROVINCIA)),_prvinter,qbe_movi_input_archope->OPROVINCIA) */
        _interprv = (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_movi_input_archope.GetString("OPROVINCIA")))?_prvinter:Cursor_qbe_movi_input_archope.GetString("OPROVINCIA"));
        /* If not(Empty(LRTrim(qbe_movi_input_archope->DCODDIP))) */
        if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_movi_input_archope.GetString("DCODDIP"))))) {
          /* If Empty(LRTrim(qbe_movi_input_archope->ODESCCIT)+LRTrim(qbe_movi_input_archope->OCODCAB)+LRTrim(qbe_movi_input_archope->OPROVINCIA)) */
          if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_movi_input_archope.GetString("ODESCCIT"))+CPLib.LRTrim(Cursor_qbe_movi_input_archope.GetString("OCODCAB"))+CPLib.LRTrim(Cursor_qbe_movi_input_archope.GetString("OPROVINCIA")))) {
            // * --- Read from anadip
            m_cServer = m_Ctx.GetServer("anadip");
            m_cPhName = m_Ctx.GetPhName("anadip");
            m_cSql = "";
            m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("DCODDIP"),"C",6,0,m_cServer),m_cServer,Cursor_qbe_movi_input_archope.GetString("DCODDIP"));
            if (m_Ctx.IsSharedTemp("anadip")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _intercit = Read_Cursor.GetString("DESCCIT");
              _intercab = Read_Cursor.GetString("CAB");
              _interprv = Read_Cursor.GetString("PROVINCIA");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on anadip into routine arrt_imp_dati_storico_sched_tabs returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _intercit = "";
              _intercab = "";
              _interprv = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
          } // End If
        } // End If
        /* Verifico la presenza dell'_unicode per evitare duplicazioni di informazioni diverse con lo stesso _unicode */
        /* _unicode := '' */
        _unicode = "";
        /* _ucode := qbe_movi_input_archope->OUNIQUECODE */
        _ucode = Cursor_qbe_movi_input_archope.GetString("OUNIQUECODE");
        /* If Left(_ucode,1)='I' */
        if (CPLib.eqr(CPLib.Left(_ucode,1),"I")) {
          /* _unicode := Substr(_ucode,2,9) */
          _unicode = CPLib.Substr(_ucode,2,9);
          /* _newop := 1 */
          _newop = CPLib.Round(1,0);
          /* ElseIf Left(_ucode,1)='U' */
        } else if (CPLib.eqr(CPLib.Left(_ucode,1),"U")) {
          /* _unicode := Substr(_ucode,2,9) */
          _unicode = CPLib.Substr(_ucode,2,9);
          /* _newop := 0 */
          _newop = CPLib.Round(0,0);
          /* ElseIf Left(_ucode,1)='D' */
        } else if (CPLib.eqr(CPLib.Left(_ucode,1),"D")) {
          /* _unicode := Substr(_ucode,2,9) */
          _unicode = CPLib.Substr(_ucode,2,9);
          /* _newop := -1 */
          _newop = CPLib.Round(-1,0);
        } else { // Else
          // * --- Read from operazbo
          m_cServer = m_Ctx.GetServer("operazbo");
          m_cPhName = m_Ctx.GetPhName("operazbo");
          m_cSql = "";
          m_cSql = m_cSql+"UNIQUECODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OUNIQUECODE"),"C",10,0,m_cServer),m_cServer,Cursor_qbe_movi_input_archope.GetString("OUNIQUECODE"));
          if (m_Ctx.IsSharedTemp("operazbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("UNIQUECODE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _unicode = Read_Cursor.GetString("UNIQUECODE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on operazbo into routine arrt_imp_dati_storico_sched_tabs returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _unicode = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Len(LRTrim(_unicode)) = 0 */
          if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(_unicode)),0)) {
            /* _unicode := qbe_movi_input_archope->OUNIQUECODE */
            _unicode = Cursor_qbe_movi_input_archope.GetString("OUNIQUECODE");
            /* _newop := 1 */
            _newop = CPLib.Round(1,0);
          } // End If
        } // End If
        /* If _newop=1 */
        if (CPLib.eqr(_newop,1)) {
          /* If w_tipodest='P' */
          if (CPLib.eqr(w_tipodest,"P")) {
            /* cOpeProg1 := Utilities.GetAutonumber("PPOPER1\'"+LRTrim(_gAzienda)+"'",'',10) */
            cOpeProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PPOPER1\\'"+CPLib.LRTrim(_gAzienda)+"'","",10);
            /* cOpeProg2 := Utilities.GetAutonumber("PPOPER2\'"+LRTrim(_gAzienda)+"'",'',11) */
            cOpeProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PPOPER2\\'"+CPLib.LRTrim(_gAzienda)+"'","",11);
          } else { // Else
            /* cOpeProg1 := Utilities.GetAutonumber("POPERAZ1\'"+LRTrim(_gAzienda)+"'",'',10) */
            cOpeProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ1\\'"+CPLib.LRTrim(_gAzienda)+"'","",10);
            /* cOpeProg2 := Utilities.GetAutonumber("POPERAZ2\'"+LRTrim(_gAzienda)+"'",'',11) */
            cOpeProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ2\\'"+CPLib.LRTrim(_gAzienda)+"'","",11);
          } // End If
          /* Case qbe_movi_input_archope->OFLAGLIRE='S' or qbe_movi_input_archope->OFLAGLIRE='1' or qbe_movi_input_archope->OFLAGLIRE='7' */
          if (CPLib.eqr(Cursor_qbe_movi_input_archope.GetString("OFLAGLIRE"),"S") || CPLib.eqr(Cursor_qbe_movi_input_archope.GetString("OFLAGLIRE"),"1") || CPLib.eqr(Cursor_qbe_movi_input_archope.GetString("OFLAGLIRE"),"7")) {
            /* cFlagLire := '1' */
            cFlagLire = "1";
            /* Case qbe_movi_input_archope->OFLAGLIRE='E' or qbe_movi_input_archope->OFLAGLIRE='3' or qbe_movi_input_archope->OFLAGLIRE='5' */
          } else if (CPLib.eqr(Cursor_qbe_movi_input_archope.GetString("OFLAGLIRE"),"E") || CPLib.eqr(Cursor_qbe_movi_input_archope.GetString("OFLAGLIRE"),"3") || CPLib.eqr(Cursor_qbe_movi_input_archope.GetString("OFLAGLIRE"),"5")) {
            /* If qbe_movi_input_archope->OFLAGLIRE = 'E' */
            if (CPLib.eqr(Cursor_qbe_movi_input_archope.GetString("OFLAGLIRE"),"E")) {
              /* cFlagLire := '3' */
              cFlagLire = "3";
            } else { // Else
              /* cFlagLire := qbe_movi_input_archope->OFLAGLIRE */
              cFlagLire = Cursor_qbe_movi_input_archope.GetString("OFLAGLIRE");
            } // End If
          } else { // Otherwise
            /* cFlagLire := qbe_movi_input_archope->OFLAGLIRE */
            cFlagLire = Cursor_qbe_movi_input_archope.GetString("OFLAGLIRE");
          } // End Case
          /* cFlagCont := iif(qbe_movi_input_archope->OFLAGCONT='1' or qbe_movi_input_archope->OFLAGCONT='S','1','0')  */
          cFlagCont = (CPLib.eqr(Cursor_qbe_movi_input_archope.GetString("OFLAGCONT"),"1") || CPLib.eqr(Cursor_qbe_movi_input_archope.GetString("OFLAGCONT"),"S")?"1":"0");
          /* cFlagFraz := iif(Empty(qbe_movi_input_archope->OFLAGFRAZ),'0',qbe_movi_input_archope->OFLAGFRAZ) */
          cFlagFraz = (CPLib.Empty(Cursor_qbe_movi_input_archope.GetString("OFLAGFRAZ"))?"0":Cursor_qbe_movi_input_archope.GetString("OFLAGFRAZ"));
          /* cIdCau := '' */
          cIdCau = "";
          // * --- Read from tbcauana
          m_cServer = m_Ctx.GetServer("tbcauana");
          m_cPhName = m_Ctx.GetPhName("tbcauana");
          m_cSql = "";
          m_cSql = m_cSql+"CODCAU="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCODANA"),"C",4,0,m_cServer),m_cServer,Cursor_qbe_movi_input_archope.GetString("OCODANA"));
          m_cSql = m_cSql+" and CAUSINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCODVOC"),"C",2,0,m_cServer),m_cServer,Cursor_qbe_movi_input_archope.GetString("OCODVOC"));
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
              Error l_oErrorFault = new Error("Read on tbcauana into routine arrt_imp_dati_storico_sched_tabs returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            cIdCau = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* nProgImp := Utilities.GetAutonumber("PRGIMPOPE\'"+LRTrim(_gAzienda)+"'",0,15) */
          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOPE\\'"+CPLib.LRTrim(_gAzienda)+"'",0,15),0);
          /* _benrag := qbe_movi_input_archope->OC_RAG */
          _benrag = Cursor_qbe_movi_input_archope.GetString("OC_RAG");
          /* _bensta := qbe_movi_input_archope->OC_STA */
          _bensta = Cursor_qbe_movi_input_archope.GetString("OC_STA");
          /* _bencta := qbe_movi_input_archope->OC_CTA */
          _bencta = Cursor_qbe_movi_input_archope.GetString("OC_CTA");
          /* _bencab := qbe_movi_input_archope->OC_CAB */
          _bencab = Cursor_qbe_movi_input_archope.GetString("OC_CAB");
          /* _benprv := qbe_movi_input_archope->OC_PRV */
          _benprv = Cursor_qbe_movi_input_archope.GetString("OC_PRV");
          /* _benind := qbe_movi_input_archope->OC_IND */
          _benind = Cursor_qbe_movi_input_archope.GetString("OC_IND");
          /* _bencap := qbe_movi_input_archope->OC_CAP */
          _bencap = Cursor_qbe_movi_input_archope.GetString("OC_CAP");
          /* If not(Empty(LRTrim(qbe_movi_input_archope->OCONNESBEN))) and Empty(LRTrim(_benrag+_bensta+_bencta+_bencab+_benprv+_benind+_bencap)) */
          if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_movi_input_archope.GetString("OCONNESBEN")))) && CPLib.Empty(CPLib.LRTrim(_benrag+_bensta+_bencta+_bencab+_benprv+_benind+_bencap))) {
            /* _benrag := '' */
            _benrag = "";
            /* _bensta := '' */
            _bensta = "";
            /* _bencta := '' */
            _bencta = "";
            /* _bencab := '' */
            _bencab = "";
            /* _benprv := '' */
            _benprv = "";
            /* _benind := '' */
            _benind = "";
            /* _bencap := '' */
            _bencap = "";
            // * --- Read from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_cSql = "";
            m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCONNESBEN"),"C",16,0,m_cServer),m_cServer,Cursor_qbe_movi_input_archope.GetString("OCONNESBEN"));
            if (m_Ctx.IsSharedTemp("personbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _bencab = Read_Cursor.GetString("CODCAB");
              _benrag = Read_Cursor.GetString("RAGSOC");
              _benind = Read_Cursor.GetString("DOMICILIO");
              _bencta = Read_Cursor.GetString("DESCCIT");
              _benprv = Read_Cursor.GetString("PROVINCIA");
              _bensta = Read_Cursor.GetString("PAESE");
              _bencap = Read_Cursor.GetString("CAP");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on personbo into routine arrt_imp_dati_storico_sched_tabs returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _bencab = "";
              _benrag = "";
              _benind = "";
              _bencta = "";
              _benprv = "";
              _bensta = "";
              _bencap = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
          } // End If
          /* If w_tipodest='P' */
          if (CPLib.eqr(w_tipodest,"P")) {
            // * --- Insert into xperazbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xperazbo");
            m_cPhName = m_Ctx.GetPhName("xperazbo");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.InsertIntoStatement(m_Ctx,"xperazbo")+" (";
            m_cSql = m_cSql+GetFieldsName_04178278(m_Ctx);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OAMMONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OAREAGEO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_bencab,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_bencap,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_bencta,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_benind,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_benprv,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_benrag,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OC_RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_bensta,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("OCAMBIO")/10000,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datreg),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCODANA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCODCAB2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("DCODDIP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCODINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCODVOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCONNALTRO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCONNESBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("PCONNES"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCONNESOPER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_datimp,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_datreg,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("ODESC2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("ODESCINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("ODURAT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cFlagCont,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cFlagFraz,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cFlagLire,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OFLAGRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cIdCau,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope)+cOpeProg2+"S","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OINFORM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OMODSVOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("ONATURA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OAGOPER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OPAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OPAGASOGOP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OPROV2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("ORAGIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("ORAPPORTBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("ORAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("ORAREA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("ORCOMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("ORFREQ"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("ORIMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("ORRAGIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("ORTIPO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OSCOPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OSEGNO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OTIPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OTIPOINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intertip,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OTIPOLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OTIPOOPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("OTOTCONT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("OTOTLIRE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_unicode,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OVALUTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OZCPARTE"),"?",0,0,m_cServer)+", ";
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
              /* _gMsgProc := _gMsgProc +"Rilevati errori per l'operazione in data "+arfn_fdate(_datope)+" con codice "+LRTrim(_unicode)+". Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
              _gMsgProc = _gMsgProc+"Rilevati errori per l'operazione in data "+arfn_fdateR.Make(m_Ctx,this).Run(_datope)+" con codice "+CPLib.LRTrim(_unicode)+". Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
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
          } else { // Else
            // * --- Insert into operazbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("operazbo");
            m_cPhName = m_Ctx.GetPhName("operazbo");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.InsertIntoStatement(m_Ctx,"operazbo")+" (";
            m_cSql = m_cSql+GetFieldsName_07B44D50(m_Ctx);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OAMMONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OAREAGEO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_bencab,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_bencap,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_bencta,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_benind,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_benprv,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_benrag,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OC_RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_bensta,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("OCAMBIO")/10000,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datreg),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCODANA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCODCAB2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("DCODDIP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCODINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCODVOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCONNALTRO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCONNESBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("PCONNES"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCONNESOPER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_datimp,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_datreg,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("ODESC2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("ODESCINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("ODURAT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cFlagCont,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cFlagFraz,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cFlagLire,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OFLAGRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cIdCau,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope)+cOpeProg2+"S","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OINFORM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OMODSVOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("ONATURA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OAGOPER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OPAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OPAGASOGOP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OPROV2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("ORAGIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("ORAPPORTBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("ORAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("ORAREA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("ORCOMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("ORFREQ"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("ORIMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("ORRAGIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("ORTIPO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OSCOPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OSEGNO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OTIPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OTIPOINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intertip,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OTIPOLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OTIPOOPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("OTOTCONT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("OTOTLIRE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_unicode,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OVALUTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OZCPARTE"),"?",0,0,m_cServer)+", ";
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
              /* _gMsgProc := _gMsgProc +"Rilevati errori per l'operazione in data "+arfn_fdate(_datope)+" con codice "+LRTrim(_unicode)+". Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
              _gMsgProc = _gMsgProc+"Rilevati errori per l'operazione in data "+arfn_fdateR.Make(m_Ctx,this).Run(_datope)+" con codice "+CPLib.LRTrim(_unicode)+". Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
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
          /* oNumNew := oNumNew + 1 */
          oNumNew = CPLib.Round(oNumNew+1,0);
          /* ElseIf _newop=-1 */
        } else if (CPLib.eqr(_newop,-1)) {
          /* conta := conta + 1 */
          conta = CPLib.Round(conta+1,0);
          // * --- Select from operazbo
          m_cServer = m_Ctx.GetServer("operazbo");
          m_cPhName = m_Ctx.GetPhName("operazbo");
          if (Cursor_operazbo!=null)
            Cursor_operazbo.Close();
          Cursor_operazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"UNIQUECODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_unicode,"?",0,0,m_cServer, m_oParameters),m_cServer,_unicode)+"  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("operazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_operazbo.Eof())) {
            // * --- Write into operazbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("operazbo");
            m_cPhName = m_Ctx.GetPhName("operazbo");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = "Update "+m_cPhName+" set ";
            m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL("2","C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"DATARETT = "+CPLib.ToSQL(_datreg,"D",8,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_operazbo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_operazbo.GetString("IDBASE"))+"";
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
            }
            Cursor_operazbo.Next();
          }
          m_cConnectivityError = Cursor_operazbo.ErrorMessage();
          Cursor_operazbo.Close();
          // * --- End Select
          /* oNumDel := oNumDel + 1 */
          oNumDel = CPLib.Round(oNumDel+1,0);
        } else { // Else
          /* oNumMod := oNumMod + 1 // Contatore record aggiornati */
          oNumMod = CPLib.Round(oNumMod+1,0);
          /* cOpeProg1 := '' */
          cOpeProg1 = "";
          /* cOpeProg2 := '' */
          cOpeProg2 = "";
          /* nProgImp := 0 */
          nProgImp = CPLib.Round(0,0);
          // * --- Select from operazbo
          m_cServer = m_Ctx.GetServer("operazbo");
          m_cPhName = m_Ctx.GetPhName("operazbo");
          if (Cursor_operazbo!=null)
            Cursor_operazbo.Close();
          Cursor_operazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"UNIQUECODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_unicode,"?",0,0,m_cServer, m_oParameters),m_cServer,_unicode)+" "+")"+(m_Ctx.IsSharedTemp("operazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_operazbo.Eof())) {
            /* cOpeProg1 := operazbo->IDBASE */
            cOpeProg1 = Cursor_operazbo.GetString("IDBASE");
            /* cOpeProg2 := operazbo->NUMPROG */
            cOpeProg2 = Cursor_operazbo.GetString("NUMPROG");
            /* nProgImp := operazbo->PRGIMPOPE */
            nProgImp = CPLib.Round(Cursor_operazbo.GetDouble("PRGIMPOPE"),0);
            /* cNewProg := Utilities.GetAutonumber("POPERAZ1\'"+LRTrim(_gAzienda)+"'",'',10) */
            cNewProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ1\\'"+CPLib.LRTrim(_gAzienda)+"'","",10);
            /* stringaflagrap2 := 'ABCDEFGHI' // stringa di valori di flagrap2 */
            stringaflagrap2 = "ABCDEFGHI";
            /* _flagrap2 := iif(Empty(operazbo->FLAGRAP2),Left(stringaflagrap2,1),Substr(stringaflagrap2,(At(operazbo->FLAGRAP2,stringaflagrap2)+1),1)) */
            _flagrap2 = (CPLib.Empty(Cursor_operazbo.GetString("FLAGRAP2"))?CPLib.Left(stringaflagrap2,1):CPLib.Substr(stringaflagrap2,(CPLib.At(Cursor_operazbo.GetString("FLAGRAP2"),stringaflagrap2)+1),1));
            /* _idreg := DateToChar(_datope)+operazbo->NUMPROG+_flagrap2 */
            _idreg = CPLib.DateToChar(_datope)+Cursor_operazbo.GetString("NUMPROG")+_flagrap2;
            // * --- Insert into operazbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("operazbo");
            m_cPhName = m_Ctx.GetPhName("operazbo");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.InsertIntoStatement(m_Ctx,"operazbo")+" (";
            m_cSql = m_cSql+GetFieldsName_05F4F490(m_Ctx);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("C_IND"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("C_STA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("CAMBIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CDATREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDate("DATAOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDate("DATAREG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_datreg,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("DURAT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_flagrap2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cNewProg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("idcauana"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("NOPROT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("RAREA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("RCOMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("RFREQ"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("RIMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("RRAGIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("RTIPO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("TOTCONT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("TOTLIRE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
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
            }
            // * --- Select from sogopebo
            m_cServer = m_Ctx.GetServer("sogopebo");
            m_cPhName = m_Ctx.GetPhName("sogopebo");
            if (Cursor_sogopebo!=null)
              Cursor_sogopebo.Close();
            Cursor_sogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_operazbo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("sogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_sogopebo.Eof())) {
              // * --- Insert into sogopebo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("sogopebo");
              m_cPhName = m_Ctx.GetPhName("sogopebo");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"sogopebo")+" (";
              m_cSql = m_cSql+GetFieldsName_05DA8C30(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(cNewProg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetDouble("CPROWNUM"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_sogopebo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_sogopebo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("sogopebo")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
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
              }
              Cursor_sogopebo.Next();
            }
            m_cConnectivityError = Cursor_sogopebo.ErrorMessage();
            Cursor_sogopebo.Close();
            // * --- End Select
            Cursor_operazbo.Next();
          }
          m_cConnectivityError = Cursor_operazbo.ErrorMessage();
          Cursor_operazbo.Close();
          // * --- End Select
          // * --- Delete from operazbo
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("operazbo");
          m_cPhName = m_Ctx.GetPhName("operazbo");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = "delete from "+m_cPhName;
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
          }
          /* cFlagCont := iif(qbe_movi_input_archope->OFLAGCONT='1' or qbe_movi_input_archope->OFLAGCONT='S','1','0')  */
          cFlagCont = (CPLib.eqr(Cursor_qbe_movi_input_archope.GetString("OFLAGCONT"),"1") || CPLib.eqr(Cursor_qbe_movi_input_archope.GetString("OFLAGCONT"),"S")?"1":"0");
          /* cFlagFraz := iif(Empty(qbe_movi_input_archope->OFLAGFRAZ),'0',qbe_movi_input_archope->OFLAGFRAZ) */
          cFlagFraz = (CPLib.Empty(Cursor_qbe_movi_input_archope.GetString("OFLAGFRAZ"))?"0":Cursor_qbe_movi_input_archope.GetString("OFLAGFRAZ"));
          /* cIdCau := '' */
          cIdCau = "";
          // * --- Read from tbcauana
          m_cServer = m_Ctx.GetServer("tbcauana");
          m_cPhName = m_Ctx.GetPhName("tbcauana");
          m_cSql = "";
          m_cSql = m_cSql+"CODCAU="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCODANA"),"C",4,0,m_cServer),m_cServer,Cursor_qbe_movi_input_archope.GetString("OCODANA"));
          m_cSql = m_cSql+" and CAUSINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCODVOC"),"C",2,0,m_cServer),m_cServer,Cursor_qbe_movi_input_archope.GetString("OCODVOC"));
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
              Error l_oErrorFault = new Error("Read on tbcauana into routine arrt_imp_dati_storico_sched_tabs returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            cIdCau = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* _benrag := qbe_movi_input_archope->OC_RAG */
          _benrag = Cursor_qbe_movi_input_archope.GetString("OC_RAG");
          /* _bensta := qbe_movi_input_archope->OC_STA */
          _bensta = Cursor_qbe_movi_input_archope.GetString("OC_STA");
          /* _bencta := qbe_movi_input_archope->OC_CTA */
          _bencta = Cursor_qbe_movi_input_archope.GetString("OC_CTA");
          /* _bencab := qbe_movi_input_archope->OC_CAB */
          _bencab = Cursor_qbe_movi_input_archope.GetString("OC_CAB");
          /* _benprv := qbe_movi_input_archope->OC_PRV */
          _benprv = Cursor_qbe_movi_input_archope.GetString("OC_PRV");
          /* _benind := qbe_movi_input_archope->OC_IND */
          _benind = Cursor_qbe_movi_input_archope.GetString("OC_IND");
          /* _bencap := qbe_movi_input_archope->OC_CAP */
          _bencap = Cursor_qbe_movi_input_archope.GetString("OC_CAP");
          /* If not(Empty(LRTrim(qbe_movi_input_archope->OCONNESBEN))) and Empty(LRTrim(_benrag+_bensta+_bencta+_bencab+_benprv+_benind+_bencap)) */
          if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_movi_input_archope.GetString("OCONNESBEN")))) && CPLib.Empty(CPLib.LRTrim(_benrag+_bensta+_bencta+_bencab+_benprv+_benind+_bencap))) {
            /* _benrag := '' */
            _benrag = "";
            /* _bensta := '' */
            _bensta = "";
            /* _bencta := '' */
            _bencta = "";
            /* _bencab := '' */
            _bencab = "";
            /* _benprv := '' */
            _benprv = "";
            /* _benind := '' */
            _benind = "";
            /* _bencap := '' */
            _bencap = "";
            // * --- Read from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_cSql = "";
            m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCONNESBEN"),"C",16,0,m_cServer),m_cServer,Cursor_qbe_movi_input_archope.GetString("OCONNESBEN"));
            if (m_Ctx.IsSharedTemp("personbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _bencab = Read_Cursor.GetString("CODCAB");
              _benrag = Read_Cursor.GetString("RAGSOC");
              _benind = Read_Cursor.GetString("DOMICILIO");
              _bencta = Read_Cursor.GetString("DESCCIT");
              _benprv = Read_Cursor.GetString("PROVINCIA");
              _bensta = Read_Cursor.GetString("PAESE");
              _bencap = Read_Cursor.GetString("CAP");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on personbo into routine arrt_imp_dati_storico_sched_tabs returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _bencab = "";
              _benrag = "";
              _benind = "";
              _bencta = "";
              _benprv = "";
              _bensta = "";
              _bencap = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
          } // End If
          // * --- Insert into operazbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("operazbo");
          m_cPhName = m_Ctx.GetPhName("operazbo");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"operazbo")+" (";
          m_cSql = m_cSql+GetFieldsName_07AA8A48(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OAMMONT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OAREAGEO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_bencab,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_bencap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_bencta,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_benind,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_benprv,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_benrag,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OC_RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_bensta,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("OCAMBIO")/10000,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datreg),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCODANA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCODCAB2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("DCODDIP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCODINT2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCODVOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCONNALTRO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCONNESBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("PCONNES"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCONNESOPER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datimp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datreg,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("ODESC2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("ODESCINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("ODURAT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cFlagCont,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cFlagFraz,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cFlagLire,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OFLAGRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cIdCau,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope)+cOpeProg2+"S","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OINFORM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OMODSVOL"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("ONATURA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OAGOPER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OPAESE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OPAGASOGOP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OPROV2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("ORAGIO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("ORAPPORTBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("ORAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("ORAREA"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("ORCOMP"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("ORFREQ"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("ORIMP"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("ORRAGIO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("ORTIPO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OSCOPO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OSEGNO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OTIPO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OTIPOINT2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intertip,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OTIPOLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OTIPOOPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("OTOTCONT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("OTOTLIRE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_unicode,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OVALUTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OZCPARTE"),"?",0,0,m_cServer)+", ";
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
            /* _gMsgProc := _gMsgProc +"Rilevati errori per l'operazione in data "+arfn_fdate(_datope)+" con codice "+LRTrim(_unicode)+". Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
            _gMsgProc = _gMsgProc+"Rilevati errori per l'operazione in data "+arfn_fdateR.Make(m_Ctx,this).Run(_datope)+" con codice "+CPLib.LRTrim(_unicode)+". Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
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
        Cursor_qbe_movi_input_archope.Next();
      }
      m_cConnectivityError = Cursor_qbe_movi_input_archope.ErrorMessage();
      Cursor_qbe_movi_input_archope.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_movi_input_archope!=null)
          Cursor_qbe_movi_input_archope.Close();
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
        if (Cursor_operazbo!=null)
          Cursor_operazbo.Close();
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
    }
  }
  void Page_4() throws Exception {
    CPResultSet Cursor_qbe_movi_input_archope=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_fraziobo=null;
    CPResultSet Cursor_sogopefbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Frazionate */
      // * --- Select from qbe_movi_input_archope
      SPBridge.HMCaller _hETDTELTCAD;
      _hETDTELTCAD = new SPBridge.HMCaller();
      _hETDTELTCAD.Set("m_cVQRList",m_cVQRList);
      _hETDTELTCAD.Set("_movcod",_movcod);
      if (Cursor_qbe_movi_input_archope!=null)
        Cursor_qbe_movi_input_archope.Close();
      Cursor_qbe_movi_input_archope = new VQRHolder("qbe_movi_input_archope",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_hETDTELTCAD,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_movi_input_archope.Eof())) {
        /* _newop := 0 */
        _newop = CPLib.Round(0,0);
        /* _intertip := iif(Empty(LRTrim(qbe_movi_input_archope->OTIPOINTER)),_tipinter,qbe_movi_input_archope->OTIPOINTER) */
        _intertip = (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_movi_input_archope.GetString("OTIPOINTER")))?_tipinter:Cursor_qbe_movi_input_archope.GetString("OTIPOINTER"));
        /* _intercod := iif(Empty(LRTrim(qbe_movi_input_archope->OCODINTER)),_codinter,qbe_movi_input_archope->OCODINTER) */
        _intercod = (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_movi_input_archope.GetString("OCODINTER")))?_codinter:Cursor_qbe_movi_input_archope.GetString("OCODINTER"));
        /* _intercit := iif(Empty(LRTrim(qbe_movi_input_archope->ODESCCIT)),_citinter,qbe_movi_input_archope->ODESCCIT) */
        _intercit = (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_movi_input_archope.GetString("ODESCCIT")))?_citinter:Cursor_qbe_movi_input_archope.GetString("ODESCCIT"));
        /* _intercab := iif(Empty(LRTrim(qbe_movi_input_archope->OCODCAB)),_cabinter,qbe_movi_input_archope->OCODCAB) */
        _intercab = (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_movi_input_archope.GetString("OCODCAB")))?_cabinter:Cursor_qbe_movi_input_archope.GetString("OCODCAB"));
        /* _interprv := iif(Empty(LRTrim(qbe_movi_input_archope->OPROVINCIA)),_prvinter,qbe_movi_input_archope->OPROVINCIA) */
        _interprv = (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_movi_input_archope.GetString("OPROVINCIA")))?_prvinter:Cursor_qbe_movi_input_archope.GetString("OPROVINCIA"));
        /* If not(Empty(LRTrim(qbe_movi_input_archope->DCODDIP))) */
        if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_movi_input_archope.GetString("DCODDIP"))))) {
          /* If Empty(LRTrim(qbe_movi_input_archope->ODESCCIT)+LRTrim(qbe_movi_input_archope->OCODCAB)+LRTrim(qbe_movi_input_archope->OPROVINCIA)) */
          if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_movi_input_archope.GetString("ODESCCIT"))+CPLib.LRTrim(Cursor_qbe_movi_input_archope.GetString("OCODCAB"))+CPLib.LRTrim(Cursor_qbe_movi_input_archope.GetString("OPROVINCIA")))) {
            // * --- Read from anadip
            m_cServer = m_Ctx.GetServer("anadip");
            m_cPhName = m_Ctx.GetPhName("anadip");
            m_cSql = "";
            m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("DCODDIP"),"C",6,0,m_cServer),m_cServer,Cursor_qbe_movi_input_archope.GetString("DCODDIP"));
            if (m_Ctx.IsSharedTemp("anadip")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _intercit = Read_Cursor.GetString("DESCCIT");
              _intercab = Read_Cursor.GetString("CAB");
              _interprv = Read_Cursor.GetString("PROVINCIA");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on anadip into routine arrt_imp_dati_storico_sched_tabs returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _intercit = "";
              _intercab = "";
              _interprv = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
          } // End If
        } // End If
        /* Verifico la presenza dell'_unicode per evitare duplicazioni di informazioni diverse con lo stesso _unicode */
        /* _unicode := '' */
        _unicode = "";
        /* _ucode := qbe_movi_input_archope->OUNIQUECODE */
        _ucode = Cursor_qbe_movi_input_archope.GetString("OUNIQUECODE");
        /* If Left(_ucode,1)='I' */
        if (CPLib.eqr(CPLib.Left(_ucode,1),"I")) {
          /* _unicode := Substr(_ucode,2,9) */
          _unicode = CPLib.Substr(_ucode,2,9);
          /* _newop := 1 */
          _newop = CPLib.Round(1,0);
          /* ElseIf Left(_ucode,1)='U' */
        } else if (CPLib.eqr(CPLib.Left(_ucode,1),"U")) {
          /* _unicode := Substr(_ucode,2,9) */
          _unicode = CPLib.Substr(_ucode,2,9);
          /* _newop := 0 */
          _newop = CPLib.Round(0,0);
          /* ElseIf Left(_ucode,1)='D' */
        } else if (CPLib.eqr(CPLib.Left(_ucode,1),"D")) {
          /* _unicode := Substr(_ucode,2,9) */
          _unicode = CPLib.Substr(_ucode,2,9);
          /* _newop := -1 */
          _newop = CPLib.Round(-1,0);
        } else { // Else
          // * --- Read from fraziobo
          m_cServer = m_Ctx.GetServer("fraziobo");
          m_cPhName = m_Ctx.GetPhName("fraziobo");
          m_cSql = "";
          m_cSql = m_cSql+"UNIQUECODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OUNIQUECODE"),"C",10,0,m_cServer),m_cServer,Cursor_qbe_movi_input_archope.GetString("OUNIQUECODE"));
          if (m_Ctx.IsSharedTemp("fraziobo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("UNIQUECODE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _unicode = Read_Cursor.GetString("UNIQUECODE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on fraziobo into routine arrt_imp_dati_storico_sched_tabs returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _unicode = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Len(LRTrim(_unicode)) = 0 */
          if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(_unicode)),0)) {
            /* _unicode := qbe_movi_input_archope->OUNIQUECODE */
            _unicode = Cursor_qbe_movi_input_archope.GetString("OUNIQUECODE");
            /* _newop := 1 */
            _newop = CPLib.Round(1,0);
          } // End If
        } // End If
        /* If _newop=1 */
        if (CPLib.eqr(_newop,1)) {
          /* If w_tipodest='P' */
          if (CPLib.eqr(w_tipodest,"P")) {
            /* cOpeProg1 := Utilities.GetAutonumber("PPFRAZ1\'"+LRTrim(_gAzienda)+"'",'',10) */
            cOpeProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PPFRAZ1\\'"+CPLib.LRTrim(_gAzienda)+"'","",10);
            /* cOpeProg2 := Utilities.GetAutonumber("PPFRAZ2\'"+LRTrim(_gAzienda)+"'",'',11) */
            cOpeProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PPFRAZ2\\'"+CPLib.LRTrim(_gAzienda)+"'","",11);
          } else { // Else
            /* cOpeProg1 := Utilities.GetAutonumber("PFRAZIO1\'"+LRTrim(_gAzienda)+"'",'',10) */
            cOpeProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PFRAZIO1\\'"+CPLib.LRTrim(_gAzienda)+"'","",10);
            /* cOpeProg2 := Utilities.GetAutonumber("PFRAZIO2\'"+LRTrim(_gAzienda)+"'",'',11) */
            cOpeProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PFRAZIO2\\'"+CPLib.LRTrim(_gAzienda)+"'","",11);
          } // End If
          /* Case qbe_movi_input_archope->OFLAGLIRE='S' or qbe_movi_input_archope->OFLAGLIRE='1' or qbe_movi_input_archope->OFLAGLIRE='7' */
          if (CPLib.eqr(Cursor_qbe_movi_input_archope.GetString("OFLAGLIRE"),"S") || CPLib.eqr(Cursor_qbe_movi_input_archope.GetString("OFLAGLIRE"),"1") || CPLib.eqr(Cursor_qbe_movi_input_archope.GetString("OFLAGLIRE"),"7")) {
            /* cFlagLire := '1' */
            cFlagLire = "1";
            /* Case qbe_movi_input_archope->OFLAGLIRE='E' or qbe_movi_input_archope->OFLAGLIRE='3' or qbe_movi_input_archope->OFLAGLIRE='5' */
          } else if (CPLib.eqr(Cursor_qbe_movi_input_archope.GetString("OFLAGLIRE"),"E") || CPLib.eqr(Cursor_qbe_movi_input_archope.GetString("OFLAGLIRE"),"3") || CPLib.eqr(Cursor_qbe_movi_input_archope.GetString("OFLAGLIRE"),"5")) {
            /* If qbe_movi_input_archope->OFLAGLIRE = 'E' */
            if (CPLib.eqr(Cursor_qbe_movi_input_archope.GetString("OFLAGLIRE"),"E")) {
              /* cFlagLire := '3' */
              cFlagLire = "3";
            } else { // Else
              /* cFlagLire := qbe_movi_input_archope->OFLAGLIRE */
              cFlagLire = Cursor_qbe_movi_input_archope.GetString("OFLAGLIRE");
            } // End If
          } else { // Otherwise
            /* cFlagLire := qbe_movi_input_archope->OFLAGLIRE */
            cFlagLire = Cursor_qbe_movi_input_archope.GetString("OFLAGLIRE");
          } // End Case
          /* cFlagCont := iif(qbe_movi_input_archope->OFLAGCONT='1' or qbe_movi_input_archope->OFLAGCONT='S','1','0')  */
          cFlagCont = (CPLib.eqr(Cursor_qbe_movi_input_archope.GetString("OFLAGCONT"),"1") || CPLib.eqr(Cursor_qbe_movi_input_archope.GetString("OFLAGCONT"),"S")?"1":"0");
          /* cFlagFraz := iif(Empty(qbe_movi_input_archope->OFLAGFRAZ),'0',qbe_movi_input_archope->OFLAGFRAZ) */
          cFlagFraz = (CPLib.Empty(Cursor_qbe_movi_input_archope.GetString("OFLAGFRAZ"))?"0":Cursor_qbe_movi_input_archope.GetString("OFLAGFRAZ"));
          /* cIdCau := '' */
          cIdCau = "";
          // * --- Read from tbcauana
          m_cServer = m_Ctx.GetServer("tbcauana");
          m_cPhName = m_Ctx.GetPhName("tbcauana");
          m_cSql = "";
          m_cSql = m_cSql+"CODCAU="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCODANA"),"C",4,0,m_cServer),m_cServer,Cursor_qbe_movi_input_archope.GetString("OCODANA"));
          m_cSql = m_cSql+" and CAUSINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCODVOC"),"C",2,0,m_cServer),m_cServer,Cursor_qbe_movi_input_archope.GetString("OCODVOC"));
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
              Error l_oErrorFault = new Error("Read on tbcauana into routine arrt_imp_dati_storico_sched_tabs returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            cIdCau = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* nProgImp := Utilities.GetAutonumber("PRGIMPFRZ\'"+LRTrim(_gAzienda)+"'",0,15) */
          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPFRZ\\'"+CPLib.LRTrim(_gAzienda)+"'",0,15),0);
          /* _benrag := qbe_movi_input_archope->OC_RAG */
          _benrag = Cursor_qbe_movi_input_archope.GetString("OC_RAG");
          /* _bensta := qbe_movi_input_archope->OC_STA */
          _bensta = Cursor_qbe_movi_input_archope.GetString("OC_STA");
          /* _bencta := qbe_movi_input_archope->OC_CTA */
          _bencta = Cursor_qbe_movi_input_archope.GetString("OC_CTA");
          /* _bencab := qbe_movi_input_archope->OC_CAB */
          _bencab = Cursor_qbe_movi_input_archope.GetString("OC_CAB");
          /* _benprv := qbe_movi_input_archope->OC_PRV */
          _benprv = Cursor_qbe_movi_input_archope.GetString("OC_PRV");
          /* _benind := qbe_movi_input_archope->OC_IND */
          _benind = Cursor_qbe_movi_input_archope.GetString("OC_IND");
          /* _bencap := qbe_movi_input_archope->OC_CAP */
          _bencap = Cursor_qbe_movi_input_archope.GetString("OC_CAP");
          /* If not(Empty(LRTrim(qbe_movi_input_archope->OCONNESBEN))) and Empty(LRTrim(_benrag+_bensta+_bencta+_bencab+_benprv+_benind+_bencap)) */
          if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_movi_input_archope.GetString("OCONNESBEN")))) && CPLib.Empty(CPLib.LRTrim(_benrag+_bensta+_bencta+_bencab+_benprv+_benind+_bencap))) {
            /* _benrag := '' */
            _benrag = "";
            /* _bensta := '' */
            _bensta = "";
            /* _bencta := '' */
            _bencta = "";
            /* _bencab := '' */
            _bencab = "";
            /* _benprv := '' */
            _benprv = "";
            /* _benind := '' */
            _benind = "";
            /* _bencap := '' */
            _bencap = "";
            // * --- Read from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_cSql = "";
            m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCONNESBEN"),"C",16,0,m_cServer),m_cServer,Cursor_qbe_movi_input_archope.GetString("OCONNESBEN"));
            if (m_Ctx.IsSharedTemp("personbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _bencab = Read_Cursor.GetString("CODCAB");
              _benrag = Read_Cursor.GetString("RAGSOC");
              _benind = Read_Cursor.GetString("DOMICILIO");
              _bencta = Read_Cursor.GetString("DESCCIT");
              _benprv = Read_Cursor.GetString("PROVINCIA");
              _bensta = Read_Cursor.GetString("PAESE");
              _bencap = Read_Cursor.GetString("CAP");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on personbo into routine arrt_imp_dati_storico_sched_tabs returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _bencab = "";
              _benrag = "";
              _benind = "";
              _bencta = "";
              _benprv = "";
              _bensta = "";
              _bencap = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
          } // End If
          /* If w_tipodest='P' */
          if (CPLib.eqr(w_tipodest,"P")) {
            // * --- Insert into xraziobo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xraziobo");
            m_cPhName = m_Ctx.GetPhName("xraziobo");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.InsertIntoStatement(m_Ctx,"xraziobo")+" (";
            m_cSql = m_cSql+GetFieldsName_06340F78(m_Ctx);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OAMMONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OAREAGEO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_bencab,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_bencap,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_bencta,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_benind,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_benprv,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_benrag,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OC_RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_bensta,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("OCAMBIO")/10000,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datreg),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCODANA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCODCAB2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("DCODDIP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCODINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCODVOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCONNALTRO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCONNESBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("PCONNES"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCONNESOPER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_datimp,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_datreg,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("ODESC2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("ODESCINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("ODURAT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cFlagCont,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cFlagFraz,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cFlagLire,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OFLAGRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cIdCau,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope)+cOpeProg2+"S","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OINFORM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OMODSVOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("ONATURA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OAGOPER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OPAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OPAGASOGOP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OPROV2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("ORAGIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("ORAPPORTBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("ORAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("ORAREA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("ORCOMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("ORFREQ"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("ORIMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("ORRAGIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("ORTIPO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OSCOPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OSEGNO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OTIPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OTIPOINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intertip,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OTIPOLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OTIPOOPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("OTOTCONT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("OTOTLIRE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_unicode,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OVALUTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OZCPARTE"),"?",0,0,m_cServer)+", ";
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
              /* _gMsgProc := _gMsgProc +"Rilevati errori per l'operazione in data "+arfn_fdate(_datope)+" con codice "+LRTrim(_unicode)+". Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
              _gMsgProc = _gMsgProc+"Rilevati errori per l'operazione in data "+arfn_fdateR.Make(m_Ctx,this).Run(_datope)+" con codice "+CPLib.LRTrim(_unicode)+". Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
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
          } else { // Else
            // * --- Insert into fraziobo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("fraziobo");
            m_cPhName = m_Ctx.GetPhName("fraziobo");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.InsertIntoStatement(m_Ctx,"fraziobo")+" (";
            m_cSql = m_cSql+GetFieldsName_06EC1E30(m_Ctx);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OAMMONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OAREAGEO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_bencab,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_bencap,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_bencta,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_benind,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_benprv,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_benrag,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OC_RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_bensta,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("OCAMBIO")/10000,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datreg),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCODANA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCODCAB2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("DCODDIP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCODINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCODVOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCONNALTRO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCONNESBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("PCONNES"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCONNESOPER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_datimp,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_datreg,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("ODESC2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("ODESCINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("ODURAT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cFlagCont,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cFlagFraz,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cFlagLire,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OFLAGRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cIdCau,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope)+cOpeProg2+"S","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OINFORM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OMODSVOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("ONATURA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OAGOPER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OPAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OPAGASOGOP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OPROV2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("ORAGIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("ORAPPORTBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("ORAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("ORAREA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("ORCOMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("ORFREQ"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("ORIMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("ORRAGIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("ORTIPO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OSCOPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OSEGNO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OTIPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OTIPOINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intertip,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OTIPOLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OTIPOOPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("OTOTCONT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("OTOTLIRE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_unicode,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OVALUTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OZCPARTE"),"?",0,0,m_cServer)+", ";
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
              /* _gMsgProc := _gMsgProc +"Rilevati errori per l'operazione in data "+arfn_fdate(_datope)+" con codice "+LRTrim(_unicode)+". Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
              _gMsgProc = _gMsgProc+"Rilevati errori per l'operazione in data "+arfn_fdateR.Make(m_Ctx,this).Run(_datope)+" con codice "+CPLib.LRTrim(_unicode)+". Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
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
          /* oNumNew := oNumNew + 1 */
          oNumNew = CPLib.Round(oNumNew+1,0);
          /* ElseIf _newop=-1 */
        } else if (CPLib.eqr(_newop,-1)) {
          /* conta := conta + 1 */
          conta = CPLib.Round(conta+1,0);
          // * --- Select from fraziobo
          m_cServer = m_Ctx.GetServer("fraziobo");
          m_cPhName = m_Ctx.GetPhName("fraziobo");
          if (Cursor_fraziobo!=null)
            Cursor_fraziobo.Close();
          Cursor_fraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"UNIQUECODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_unicode,"?",0,0,m_cServer, m_oParameters),m_cServer,_unicode)+"  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("fraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_fraziobo.Eof())) {
            // * --- Write into fraziobo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("fraziobo");
            m_cPhName = m_Ctx.GetPhName("fraziobo");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = "Update "+m_cPhName+" set ";
            m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL("2","C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"DATARETT = "+CPLib.ToSQL(_datreg,"D",8,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_fraziobo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_fraziobo.GetString("IDBASE"))+"";
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
            }
            Cursor_fraziobo.Next();
          }
          m_cConnectivityError = Cursor_fraziobo.ErrorMessage();
          Cursor_fraziobo.Close();
          // * --- End Select
          /* oNumDel := oNumDel + 1 */
          oNumDel = CPLib.Round(oNumDel+1,0);
        } else { // Else
          /* oNumMod := oNumMod + 1 // Contatore record aggiornati */
          oNumMod = CPLib.Round(oNumMod+1,0);
          /* conta := conta + 1 */
          conta = CPLib.Round(conta+1,0);
          /* cOpeProg1 := '' */
          cOpeProg1 = "";
          /* cOpeProg2 := '' */
          cOpeProg2 = "";
          /* nProgImp := 0 */
          nProgImp = CPLib.Round(0,0);
          // * --- Select from fraziobo
          m_cServer = m_Ctx.GetServer("fraziobo");
          m_cPhName = m_Ctx.GetPhName("fraziobo");
          if (Cursor_fraziobo!=null)
            Cursor_fraziobo.Close();
          Cursor_fraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"UNIQUECODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_unicode,"?",0,0,m_cServer, m_oParameters),m_cServer,_unicode)+" "+")"+(m_Ctx.IsSharedTemp("fraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_fraziobo.Eof())) {
            /* cOpeProg1 := fraziobo->IDBASE */
            cOpeProg1 = Cursor_fraziobo.GetString("IDBASE");
            /* cOpeProg2 := fraziobo->NUMPROG */
            cOpeProg2 = Cursor_fraziobo.GetString("NUMPROG");
            /* nProgImp := fraziobo->PRGIMPFRZ */
            nProgImp = CPLib.Round(Cursor_fraziobo.GetDouble("PRGIMPFRZ"),0);
            /* cNewProg := Utilities.GetAutonumber("PFRAZIO1\'"+LRTrim(_gAzienda)+"'",'',10) */
            cNewProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PFRAZIO1\\'"+CPLib.LRTrim(_gAzienda)+"'","",10);
            /* stringaflagrap2 := 'JLMNOTUV?' // stringa di valori di flagrap2 */
            stringaflagrap2 = "JLMNOTUV?";
            /* _flagrap2 := iif(Empty(fraziobo->FLAGRAP2),Left(stringaflagrap2,1),Substr(stringaflagrap2,(At(fraziobo->FLAGRAP2,stringaflagrap2)+1),1)) */
            _flagrap2 = (CPLib.Empty(Cursor_fraziobo.GetString("FLAGRAP2"))?CPLib.Left(stringaflagrap2,1):CPLib.Substr(stringaflagrap2,(CPLib.At(Cursor_fraziobo.GetString("FLAGRAP2"),stringaflagrap2)+1),1));
            /* _idreg := DateToChar(_datope)+fraziobo->NUMPROG+_flagrap2 */
            _idreg = CPLib.DateToChar(_datope)+Cursor_fraziobo.GetString("NUMPROG")+_flagrap2;
            // * --- Insert into fraziobo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("fraziobo");
            m_cPhName = m_Ctx.GetPhName("fraziobo");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.InsertIntoStatement(m_Ctx,"fraziobo")+" (";
            m_cSql = m_cSql+GetFieldsName_060FE218(m_Ctx);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_IND"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_STA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("CAMBIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CDATREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDate("DATAOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDate("DATAREG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_datreg,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("DURAT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_flagrap2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cNewProg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("idcauana"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("NOPROT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("RAREA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("RCOMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("RFREQ"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("RIMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("RRAGIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("RTIPO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("TOTCONT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("TOTLIRE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
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
            }
            // * --- Select from sogopefbo
            m_cServer = m_Ctx.GetServer("sogopefbo");
            m_cPhName = m_Ctx.GetPhName("sogopefbo");
            if (Cursor_sogopefbo!=null)
              Cursor_sogopefbo.Close();
            Cursor_sogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_fraziobo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("sogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_sogopefbo.Eof())) {
              // * --- Insert into sogopefbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("sogopefbo");
              m_cPhName = m_Ctx.GetPhName("sogopefbo");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"sogopefbo")+" (";
              m_cSql = m_cSql+GetFieldsName_07C48638(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(cNewProg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetDouble("CPROWNUM"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_sogopefbo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_sogopefbo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("sogopefbo")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
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
              }
              Cursor_sogopefbo.Next();
            }
            m_cConnectivityError = Cursor_sogopefbo.ErrorMessage();
            Cursor_sogopefbo.Close();
            // * --- End Select
            Cursor_fraziobo.Next();
          }
          m_cConnectivityError = Cursor_fraziobo.ErrorMessage();
          Cursor_fraziobo.Close();
          // * --- End Select
          // * --- Delete from fraziobo
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("fraziobo");
          m_cPhName = m_Ctx.GetPhName("fraziobo");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = "delete from "+m_cPhName;
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
          }
          /* cFlagCont := iif(qbe_movi_input_archope->OFLAGCONT='1' or qbe_movi_input_archope->OFLAGCONT='S','1','0')  */
          cFlagCont = (CPLib.eqr(Cursor_qbe_movi_input_archope.GetString("OFLAGCONT"),"1") || CPLib.eqr(Cursor_qbe_movi_input_archope.GetString("OFLAGCONT"),"S")?"1":"0");
          /* cFlagFraz := iif(Empty(qbe_movi_input_archope->OFLAGFRAZ),'0',qbe_movi_input_archope->OFLAGFRAZ) */
          cFlagFraz = (CPLib.Empty(Cursor_qbe_movi_input_archope.GetString("OFLAGFRAZ"))?"0":Cursor_qbe_movi_input_archope.GetString("OFLAGFRAZ"));
          /* cIdCau := '' */
          cIdCau = "";
          // * --- Read from tbcauana
          m_cServer = m_Ctx.GetServer("tbcauana");
          m_cPhName = m_Ctx.GetPhName("tbcauana");
          m_cSql = "";
          m_cSql = m_cSql+"CODCAU="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCODANA"),"C",4,0,m_cServer),m_cServer,Cursor_qbe_movi_input_archope.GetString("OCODANA"));
          m_cSql = m_cSql+" and CAUSINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCODVOC"),"C",2,0,m_cServer),m_cServer,Cursor_qbe_movi_input_archope.GetString("OCODVOC"));
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
              Error l_oErrorFault = new Error("Read on tbcauana into routine arrt_imp_dati_storico_sched_tabs returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            cIdCau = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* _benrag := qbe_movi_input_archope->OC_RAG */
          _benrag = Cursor_qbe_movi_input_archope.GetString("OC_RAG");
          /* _bensta := qbe_movi_input_archope->OC_STA */
          _bensta = Cursor_qbe_movi_input_archope.GetString("OC_STA");
          /* _bencta := qbe_movi_input_archope->OC_CTA */
          _bencta = Cursor_qbe_movi_input_archope.GetString("OC_CTA");
          /* _bencab := qbe_movi_input_archope->OC_CAB */
          _bencab = Cursor_qbe_movi_input_archope.GetString("OC_CAB");
          /* _benprv := qbe_movi_input_archope->OC_PRV */
          _benprv = Cursor_qbe_movi_input_archope.GetString("OC_PRV");
          /* _benind := qbe_movi_input_archope->OC_IND */
          _benind = Cursor_qbe_movi_input_archope.GetString("OC_IND");
          /* _bencap := qbe_movi_input_archope->OC_CAP */
          _bencap = Cursor_qbe_movi_input_archope.GetString("OC_CAP");
          /* If not(Empty(LRTrim(qbe_movi_input_archope->OCONNESBEN))) and Empty(LRTrim(_benrag+_bensta+_bencta+_bencab+_benprv+_benind+_bencap)) */
          if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_movi_input_archope.GetString("OCONNESBEN")))) && CPLib.Empty(CPLib.LRTrim(_benrag+_bensta+_bencta+_bencab+_benprv+_benind+_bencap))) {
            /* _benrag := '' */
            _benrag = "";
            /* _bensta := '' */
            _bensta = "";
            /* _bencta := '' */
            _bencta = "";
            /* _bencab := '' */
            _bencab = "";
            /* _benprv := '' */
            _benprv = "";
            /* _benind := '' */
            _benind = "";
            /* _bencap := '' */
            _bencap = "";
            // * --- Read from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_cSql = "";
            m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCONNESBEN"),"C",16,0,m_cServer),m_cServer,Cursor_qbe_movi_input_archope.GetString("OCONNESBEN"));
            if (m_Ctx.IsSharedTemp("personbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _bencab = Read_Cursor.GetString("CODCAB");
              _benrag = Read_Cursor.GetString("RAGSOC");
              _benind = Read_Cursor.GetString("DOMICILIO");
              _bencta = Read_Cursor.GetString("DESCCIT");
              _benprv = Read_Cursor.GetString("PROVINCIA");
              _bensta = Read_Cursor.GetString("PAESE");
              _bencap = Read_Cursor.GetString("CAP");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on personbo into routine arrt_imp_dati_storico_sched_tabs returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _bencab = "";
              _benrag = "";
              _benind = "";
              _bencta = "";
              _benprv = "";
              _bensta = "";
              _bencap = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
          } // End If
          // * --- Insert into fraziobo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("fraziobo");
          m_cPhName = m_Ctx.GetPhName("fraziobo");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"fraziobo")+" (";
          m_cSql = m_cSql+GetFieldsName_06194E90(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OAMMONT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OAREAGEO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_bencab,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_bencap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_bencta,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_benind,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_benprv,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_benrag,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OC_RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_bensta,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("OCAMBIO")/10000,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datreg),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCODANA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCODCAB2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("DCODDIP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCODINT2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCODVOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCONNALTRO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCONNESBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("PCONNES"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OCONNESOPER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datimp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datreg,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("ODESC2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("ODESCINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("ODURAT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cFlagCont,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cFlagFraz,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cFlagLire,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OFLAGRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cIdCau,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope)+cOpeProg2+"S","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OINFORM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OMODSVOL"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("ONATURA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OAGOPER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OPAESE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OPAGASOGOP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OPROV2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("ORAGIO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("ORAPPORTBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("ORAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("ORAREA"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("ORCOMP"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("ORFREQ"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("ORIMP"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("ORRAGIO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("ORTIPO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OSCOPO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OSEGNO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OTIPO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OTIPOINT2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intertip,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OTIPOLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OTIPOOPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("OTOTCONT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetDouble("OTOTLIRE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_unicode,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OVALUTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archope.GetString("OZCPARTE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
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
            /* _gMsgProc := _gMsgProc +"Rilevati errori per l'operazione in data "+arfn_fdate(_datope)+" con codice "+LRTrim(_unicode)+". Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
            _gMsgProc = _gMsgProc+"Rilevati errori per l'operazione in data "+arfn_fdateR.Make(m_Ctx,this).Run(_datope)+" con codice "+CPLib.LRTrim(_unicode)+". Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
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
        Cursor_qbe_movi_input_archope.Next();
      }
      m_cConnectivityError = Cursor_qbe_movi_input_archope.ErrorMessage();
      Cursor_qbe_movi_input_archope.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_movi_input_archope!=null)
          Cursor_qbe_movi_input_archope.Close();
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
        if (Cursor_fraziobo!=null)
          Cursor_fraziobo.Close();
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
    }
  }
  void Page_5() throws Exception {
    CPResultSet Cursor_qbe_movi_input_archdip=null;
    CPResultSet Read_Cursor=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Import Dipendenze */
      // * --- Select from qbe_movi_input_archdip
      SPBridge.HMCaller _hCWEWTBTIHF;
      _hCWEWTBTIHF = new SPBridge.HMCaller();
      _hCWEWTBTIHF.Set("m_cVQRList",m_cVQRList);
      _hCWEWTBTIHF.Set("_movcod",_movcod);
      if (Cursor_qbe_movi_input_archdip!=null)
        Cursor_qbe_movi_input_archdip.Close();
      Cursor_qbe_movi_input_archdip = new VQRHolder("qbe_movi_input_archdip",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_hCWEWTBTIHF,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_movi_input_archdip.Eof())) {
        /* xDIP := qbe_movi_input_archdip->DCODDIP */
        xDIP = Cursor_qbe_movi_input_archdip.GetString("DCODDIP");
        /* xDIPx := '' */
        xDIPx = "";
        /* xCodCab := qbe_movi_input_archdip->DCAB */
        xCodCab = Cursor_qbe_movi_input_archdip.GetString("DCAB");
        /* If Empty(LRTrim(xCodCab)) */
        if (CPLib.Empty(CPLib.LRTrim(xCodCab))) {
          /* xCitta := qbe_movi_input_archdip->DDESCCIT */
          xCitta = Cursor_qbe_movi_input_archdip.GetString("DDESCCIT");
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
              Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_imp_dati_storico_sched_tabs returns two or more records. This item should return only a record.");
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
            Error l_oErrorFault = new Error("Read on anadip into routine arrt_imp_dati_storico_sched_tabs returns two or more records. This item should return only a record.");
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
          m_cSql = m_cSql+GetFieldsName_05CC5D50(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(xDIP,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archdip.GetString("DDESCRIZ"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archdip.GetString("DDESCCIT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_movi_input_archdip.GetString("DPROVINCIA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(xCodCab,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_qbe_movi_input_archdip.GetString("DAGENTE"))?"N":Cursor_qbe_movi_input_archdip.GetString("DAGENTE")),"?",0,0,m_cServer)+", ";
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
          /* dNumNew := dNumNew + 1 */
          dNumNew = CPLib.Round(dNumNew+1,0);
        } else { // Else
          // * --- Write into anadip from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("anadip");
          m_cPhName = m_Ctx.GetPhName("anadip");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = "Update "+m_cPhName+" set ";
          m_cSql = m_cSql+"DESCRIZ = "+CPLib.ToSQL(Cursor_qbe_movi_input_archdip.GetString("DDESCRIZ"),"C",30,0,m_cServer)+", ";
          m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_qbe_movi_input_archdip.GetString("DDESCCIT"),"C",30,0,m_cServer)+", ";
          m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_qbe_movi_input_archdip.GetString("DPROVINCIA"),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"CAB = "+CPLib.ToSQL(xCodCab,"C",6,0,m_cServer)+", ";
          m_cSql = m_cSql+"AGENTE = "+CPLib.ToSQL((CPLib.Empty(Cursor_qbe_movi_input_archdip.GetString("DAGENTE"))?"N":Cursor_qbe_movi_input_archdip.GetString("DAGENTE")),"C",1,0,m_cServer)+", ";
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
          /* dNumMod := dNumMod + 1 */
          dNumMod = CPLib.Round(dNumMod+1,0);
        } // End If
        Cursor_qbe_movi_input_archdip.Next();
      }
      m_cConnectivityError = Cursor_qbe_movi_input_archdip.ErrorMessage();
      Cursor_qbe_movi_input_archdip.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_movi_input_archdip!=null)
          Cursor_qbe_movi_input_archdip.Close();
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
    /* Tenta di inserire i dati Cognome e Nome se Non Esistono */
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
      /* If arfn_verifica_cf_nome_cognome(xCF,xNome,xCognome) */
      if (arfn_verifica_cf_nome_cognomeR.Make(m_Ctx,this).Run(xCF,xNome,xCognome)) {
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
          /* If arfn_verifica_cf_nome_cognome(xCF,xNome,xCognome) */
          if (arfn_verifica_cf_nome_cognomeR.Make(m_Ctx,this).Run(xCF,xNome,xCognome)) {
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
        /* If arfn_verifica_cf_nome_cognome(xCF,xNome,xCognome) */
        if (arfn_verifica_cf_nome_cognomeR.Make(m_Ctx,this).Run(xCF,xNome,xCognome)) {
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
        /* If arfn_verifica_cf_nome_cognome(xCF,xNome,xCognome) */
        if (arfn_verifica_cf_nome_cognomeR.Make(m_Ctx,this).Run(xCF,xNome,xCognome)) {
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
  void Page_7() throws Exception {
    CPResultSet Cursor_qbe_movi_input_check=null;
    CPResultSet Read_Cursor=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Controlla i dati per scarto */
      /* _cdessta Char(40) */
      String _cdessta;
      _cdessta = CPLib.Space(40);
      /* _cdescit Char(40) */
      String _cdescit;
      _cdescit = CPLib.Space(40);
      /* _ctipdoc Char(2) */
      String _ctipdoc;
      _ctipdoc = CPLib.Space(2);
      // * --- Select from qbe_movi_input_check
      SPBridge.HMCaller _hQJVFTDJLVE;
      _hQJVFTDJLVE = new SPBridge.HMCaller();
      _hQJVFTDJLVE.Set("m_cVQRList",m_cVQRList);
      _hQJVFTDJLVE.Set("_movcod",_movcod);
      if (Cursor_qbe_movi_input_check!=null)
        Cursor_qbe_movi_input_check.Close();
      Cursor_qbe_movi_input_check = new VQRHolder("qbe_movi_input_check",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_hQJVFTDJLVE,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_movi_input_check.Eof())) {
        /* _datope := arfn_datefchar(qbe_movi_input_check->ODATAOPE) */
        _datope = arfn_datefcharR.Make(m_Ctx,this).Run(Cursor_qbe_movi_input_check.GetString("ODATAOPE"));
        /* _datreg := arfn_datefchar(qbe_movi_input_check->ODATAREG) */
        _datreg = arfn_datefcharR.Make(m_Ctx,this).Run(Cursor_qbe_movi_input_check.GetString("ODATAREG"));
        /* _datimp := arfn_datefchar(qbe_movi_input_check->ODATAIMP) */
        _datimp = arfn_datefcharR.Make(m_Ctx,this).Run(Cursor_qbe_movi_input_check.GetString("ODATAIMP"));
        /* _datnas := arfn_datefchar(qbe_movi_input_check->PDATANASC) */
        _datnas = arfn_datefcharR.Make(m_Ctx,this).Run(Cursor_qbe_movi_input_check.GetString("PDATANASC"));
        /* _datemi := arfn_datefchar(qbe_movi_input_check->PDATARILASC) */
        _datemi = arfn_datefcharR.Make(m_Ctx,this).Run(Cursor_qbe_movi_input_check.GetString("PDATARILASC"));
        /* _datval := arfn_datefchar(qbe_movi_input_check->PDATAVALI) */
        _datval = arfn_datefcharR.Make(m_Ctx,this).Run(Cursor_qbe_movi_input_check.GetString("PDATAVALI"));
        /* If Empty(qbe_movi_input_check->OC_RAG) */
        if (CPLib.Empty(Cursor_qbe_movi_input_check.GetString("OC_RAG"))) {
          /* _txterr := _txterr + 'Manca il nome del beneficiario' + NL */
          _txterr = _txterr+"Manca il nome del beneficiario"+"\n";
          /* _recok := 1 */
          _recok = CPLib.Round(1,0);
        } // End If
        /* If Empty(qbe_movi_input_check->OC_STA) */
        if (CPLib.Empty(Cursor_qbe_movi_input_check.GetString("OC_STA"))) {
          /* _txterr := _txterr + 'Manca lo stato di destinazione del beneficiario' + NL */
          _txterr = _txterr+"Manca lo stato di destinazione del beneficiario"+"\n";
          /* _recok := 1 */
          _recok = CPLib.Round(1,0);
        } else { // Else
          /* _cdessta := '' */
          _cdessta = "";
          // * --- Read from tbstati
          m_cServer = m_Ctx.GetServer("tbstati");
          m_cPhName = m_Ctx.GetPhName("tbstati");
          m_cSql = "";
          m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_movi_input_check.GetString("OC_STA"),"C",3,0,m_cServer),m_cServer,Cursor_qbe_movi_input_check.GetString("OC_STA"));
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
              Error l_oErrorFault = new Error("Read on tbstati into routine arrt_imp_dati_storico_sched_tabs returns two or more records. This item should return only a record.");
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
            /* _txterr := _txterr + 'Stato destinazione del beneficiario errato' + NL */
            _txterr = _txterr+"Stato destinazione del beneficiario errato"+"\n";
            /* _recok := 1 */
            _recok = CPLib.Round(1,0);
          } // End If
        } // End If
        /* If Empty(qbe_movi_input_check->PNASCOMUN) */
        if (CPLib.Empty(Cursor_qbe_movi_input_check.GetString("PNASCOMUN"))) {
          /* _txterr := _txterr + 'Manca il Comune o lo Stato di Nascita' + NL */
          _txterr = _txterr+"Manca il Comune o lo Stato di Nascita"+"\n";
          /* _recok := 1 */
          _recok = CPLib.Round(1,0);
        } else { // Else
          /* If Empty(qbe_movi_input_check->PPROVNAS) */
          if (CPLib.Empty(Cursor_qbe_movi_input_check.GetString("PPROVNAS"))) {
            /* _txterr := _txterr + 'Manca la provincia di Nascita' + NL */
            _txterr = _txterr+"Manca la provincia di Nascita"+"\n";
            /* _recok := 1 */
            _recok = CPLib.Round(1,0);
          } else { // Else
            /* If Upper(LRTrim(qbe_movi_input_check->PPROVNAS))='EE' */
            if (CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_qbe_movi_input_check.GetString("PPROVNAS"))),"EE")) {
              /* _cdessta := '' */
              _cdessta = "";
              // * --- Read from tbstati
              m_cServer = m_Ctx.GetServer("tbstati");
              m_cPhName = m_Ctx.GetPhName("tbstati");
              m_cSql = "";
              m_cSql = m_cSql+"DESCRI="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Upper(CPLib.LRTrim(Cursor_qbe_movi_input_check.GetString("PNASCOMUN"))),"C",40,0,m_cServer),m_cServer,CPLib.Upper(CPLib.LRTrim(Cursor_qbe_movi_input_check.GetString("PNASCOMUN"))));
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
                  Error l_oErrorFault = new Error("Read on tbstati into routine arrt_imp_dati_storico_sched_tabs returns two or more records. This item should return only a record.");
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
                /* _recok := 1 */
                _recok = CPLib.Round(1,0);
              } // End If
            } else { // Else
              /* _cdescit := '' */
              _cdescit = "";
              // * --- Read from tbcitta
              m_cServer = m_Ctx.GetServer("tbcitta");
              m_cPhName = m_Ctx.GetPhName("tbcitta");
              m_cSql = "";
              m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Upper(CPLib.LRTrim(Cursor_qbe_movi_input_check.GetString("PNASCOMUN"))),"C",40,0,m_cServer),m_cServer,CPLib.Upper(CPLib.LRTrim(Cursor_qbe_movi_input_check.GetString("PNASCOMUN"))));
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
                  Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_imp_dati_storico_sched_tabs returns two or more records. This item should return only a record.");
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
                /* _recok := 1 */
                _recok = CPLib.Round(1,0);
              } // End If
            } // End If
          } // End If
        } // End If
        /* If qbe_movi_input_check->OTOTLIRE=0 */
        if (CPLib.eqr(Cursor_qbe_movi_input_check.GetDouble("OTOTLIRE"),0)) {
          /* _txterr := _txterr + 'Manca importo operazione' + NL */
          _txterr = _txterr+"Manca importo operazione"+"\n";
          /* _recok := 1 */
          _recok = CPLib.Round(1,0);
        } // End If
        /* If Empty(LRTrim(qbe_movi_input_check->PAUTRILASC)) */
        if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_movi_input_check.GetString("PAUTRILASC")))) {
          /* _txterr := _txterr + 'Manca autorità rilascio del documento' + NL */
          _txterr = _txterr+"Manca autorità rilascio del documento"+"\n";
          /* _recok := 1 */
          _recok = CPLib.Round(1,0);
        } // End If
        /* If Empty(LRTrim(qbe_movi_input_check->PNUMDOCUM)) */
        if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_movi_input_check.GetString("PNUMDOCUM")))) {
          /* _txterr := _txterr + 'Manca numero documento identità' + NL */
          _txterr = _txterr+"Manca numero documento identità"+"\n";
          /* _recok := 1 */
          _recok = CPLib.Round(1,0);
        } // End If
        /* If Empty(LRTrim(qbe_movi_input_check->PTIPODOC)) */
        if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_movi_input_check.GetString("PTIPODOC")))) {
          /* _txterr := _txterr + 'Manca tipo documento identità' + NL */
          _txterr = _txterr+"Manca tipo documento identità"+"\n";
          /* _recok := 1 */
          _recok = CPLib.Round(1,0);
        } else { // Else
          /* _ctipdoc := '' */
          _ctipdoc = "";
          // * --- Read from tbtipdoc
          m_cServer = m_Ctx.GetServer("tbtipdoc");
          m_cPhName = m_Ctx.GetPhName("tbtipdoc");
          m_cSql = "";
          m_cSql = m_cSql+"TIPDOC="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_movi_input_check.GetString("PTIPODOC"),"C",2,0,m_cServer),m_cServer,Cursor_qbe_movi_input_check.GetString("PTIPODOC"));
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
              Error l_oErrorFault = new Error("Read on tbtipdoc into routine arrt_imp_dati_storico_sched_tabs returns two or more records. This item should return only a record.");
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
            /* _recok := 1 */
            _recok = CPLib.Round(1,0);
          } // End If
        } // End If
        /* If Empty(LRTrim(qbe_movi_input_check->OSEGNO)) */
        if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_movi_input_check.GetString("OSEGNO")))) {
          /* _txterr := _txterr + "Manca il segno dell'operazione" + NL */
          _txterr = _txterr+"Manca il segno dell'operazione"+"\n";
          /* _recok := 1 */
          _recok = CPLib.Round(1,0);
        } // End If
        /* If Empty(_datope) or DateToChar(_datope) = '0100101' */
        if (CPLib.Empty(_datope) || CPLib.eqr(CPLib.DateToChar(_datope),"0100101")) {
          /* _txterr := _txterr + "Manca la data dell'operazione" + NL */
          _txterr = _txterr+"Manca la data dell'operazione"+"\n";
          /* _recok := 1 */
          _recok = CPLib.Round(1,0);
        } else { // Else
          /* If Year(_datope) < 1900 or Year(_datope) > Year(Date()) */
          if (CPLib.lt(CPLib.Year(_datope),1900) || CPLib.gt(CPLib.Year(_datope),CPLib.Year(CPLib.Date()))) {
            /* _txterr := _txterr + "Data operazione errata" + NL */
            _txterr = _txterr+"Data operazione errata"+"\n";
            /* _recok := 1 */
            _recok = CPLib.Round(1,0);
          } // End If
        } // End If
        /* If Empty(_datreg) or DateToChar(_datreg) = '0100101' */
        if (CPLib.Empty(_datreg) || CPLib.eqr(CPLib.DateToChar(_datreg),"0100101")) {
          /* _txterr := _txterr + "Manca la data di registrazione dell'operazione" + NL */
          _txterr = _txterr+"Manca la data di registrazione dell'operazione"+"\n";
          /* _recok := 1 */
          _recok = CPLib.Round(1,0);
        } else { // Else
          /* If Year(_datreg) < 1900 or _datreg > Date() */
          if (CPLib.lt(CPLib.Year(_datreg),1900) || CPLib.gt(_datreg,CPLib.Date())) {
            /* _txterr := _txterr + "Data registrazione operazione errata" + NL */
            _txterr = _txterr+"Data registrazione operazione errata"+"\n";
            /* _recok := 1 */
            _recok = CPLib.Round(1,0);
          } // End If
        } // End If
        /* If Empty(_datnas) or DateToChar(_datnas) = '0100101' */
        if (CPLib.Empty(_datnas) || CPLib.eqr(CPLib.DateToChar(_datnas),"0100101")) {
          /* _txterr := _txterr + "Manca la data di nascita del soggetto" + NL */
          _txterr = _txterr+"Manca la data di nascita del soggetto"+"\n";
          /* _recok := 1 */
          _recok = CPLib.Round(1,0);
        } else { // Else
          /* If Year(_datnas) < 1900 or _datnas > Date() */
          if (CPLib.lt(CPLib.Year(_datnas),1900) || CPLib.gt(_datnas,CPLib.Date())) {
            /* _txterr := _txterr + "Data di nascita del soggetto errata" + NL */
            _txterr = _txterr+"Data di nascita del soggetto errata"+"\n";
            /* _recok := 1 */
            _recok = CPLib.Round(1,0);
          } // End If
        } // End If
        /* If Empty(_datemi) or DateToChar(_datemi) = '0100101' */
        if (CPLib.Empty(_datemi) || CPLib.eqr(CPLib.DateToChar(_datemi),"0100101")) {
          /* _txterr := _txterr + "Manca data rilascio del documento del soggetto" + NL */
          _txterr = _txterr+"Manca data rilascio del documento del soggetto"+"\n";
          /* _recok := 1 */
          _recok = CPLib.Round(1,0);
        } else { // Else
          /* If Year(_datemi) < 1900 or _datemi > Date() */
          if (CPLib.lt(CPLib.Year(_datemi),1900) || CPLib.gt(_datemi,CPLib.Date())) {
            /* _txterr := _txterr + "Data rilascio del documento del soggetto errata" + NL */
            _txterr = _txterr+"Data rilascio del documento del soggetto errata"+"\n";
            /* _recok := 1 */
            _recok = CPLib.Round(1,0);
          } // End If
        } // End If
        /* If not(Empty(_datval)) and DateToChar(_datval) <> '0100101' */
        if ( ! (CPLib.Empty(_datval)) && CPLib.ne(CPLib.DateToChar(_datval),"0100101")) {
          /* If Year(_datval) < 1900 */
          if (CPLib.lt(CPLib.Year(_datval),1900)) {
            /* _txterr := _txterr + "Data scadenza del documento del soggetto errata" + NL */
            _txterr = _txterr+"Data scadenza del documento del soggetto errata"+"\n";
            /* _recok := 1 */
            _recok = CPLib.Round(1,0);
          } // End If
        } // End If
        Cursor_qbe_movi_input_check.Next();
      }
      m_cConnectivityError = Cursor_qbe_movi_input_check.ErrorMessage();
      Cursor_qbe_movi_input_check.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_movi_input_check!=null)
          Cursor_qbe_movi_input_check.Close();
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
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_imp_dati_storico_sched_tabsR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_imp_dati_storico_sched_tabsR(p_Ctx, p_Caller);
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
    cProg = CPLib.Space(10);
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
    oNumNew = 0;
    oNumMod = 0;
    oNumDel = 0;
    oNumInv = 0;
    sNumNew = 0;
    sNumMod = 0;
    sNumInv = 0;
    nTotErr = 0;
    _datope = CPLib.NullDate();
    _datreg = CPLib.NullDate();
    _datimp = CPLib.NullDate();
    _datnas = CPLib.NullDate();
    _datemi = CPLib.NullDate();
    _datval = CPLib.NullDate();
    _recok = 0;
    _txterr = "";
    _gAzienda = CPLib.Space(10);
    _chiave = CPLib.Space(20);
    _flgfile = CPLib.Space(1);
    _oldazi = CPLib.Space(10);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_movi_input,qbe_movi_input_select,qbe_movi_input_archpers,qbe_movi_input_archope,qbe_movi_input_archope,qbe_movi_input_archdip,qbe_movi_input_check,
  public static final String m_cVQRList = ",qbe_movi_input,qbe_movi_input_select,qbe_movi_input_archpers,qbe_movi_input_archope,qbe_movi_input_archope,qbe_movi_input_archdip,qbe_movi_input_check,";
  // ENTITY_BATCHES: ,arfn_calcolasett,arfn_datefchar,arfn_fdate,arfn_fdatetime,arfn_verifica_cf_nome_cognome,
  public static final String i_InvokedRoutines = ",arfn_calcolasett,arfn_datefchar,arfn_fdate,arfn_fdatetime,arfn_verifica_cf_nome_cognome,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_05DE4BA8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"MCODMOV,";
    p_cSql = p_cSql+"PCODCAB,";
    p_cSql = p_cSql+"PRAGSOC,";
    p_cSql = p_cSql+"PDOMICILIO,";
    p_cSql = p_cSql+"PCONNES,";
    p_cSql = p_cSql+"PDATANASC,";
    p_cSql = p_cSql+"PNASCOMUN,";
    p_cSql = p_cSql+"PSOTGRUP,";
    p_cSql = p_cSql+"PRAMOGRUP,";
    p_cSql = p_cSql+"PSETTSINT,";
    p_cSql = p_cSql+"PTIPODOC,";
    p_cSql = p_cSql+"PNUMDOCUM,";
    p_cSql = p_cSql+"PDATARILASC,";
    p_cSql = p_cSql+"PAUTRILASC,";
    p_cSql = p_cSql+"PDESCCIT,";
    p_cSql = p_cSql+"PPROVINCIA,";
    p_cSql = p_cSql+"PPAESE,";
    p_cSql = p_cSql+"PCAP,";
    p_cSql = p_cSql+"PPARTIVA,";
    p_cSql = p_cSql+"PSESSO,";
    p_cSql = p_cSql+"PDATAVALI,";
    p_cSql = p_cSql+"PCOGNOME,";
    p_cSql = p_cSql+"PNOME,";
    p_cSql = p_cSql+"PDOCFILE,";
    p_cSql = p_cSql+"PPROVNAS,";
    p_cSql = p_cSql+"PCFESTERO,";
    p_cSql = p_cSql+"PSPECIE,";
    p_cSql = p_cSql+"PCOMPORT,";
    p_cSql = p_cSql+"PATTIV,";
    p_cSql = p_cSql+"PAREAGEO,";
    p_cSql = p_cSql+"PRNATGIU,";
    p_cSql = p_cSql+"PRCOMP,";
    p_cSql = p_cSql+"PRATTIV,";
    p_cSql = p_cSql+"PRAREA,";
    p_cSql = p_cSql+"PCODFISC,";
    p_cSql = p_cSql+"PPEP,";
    p_cSql = p_cSql+"ODATAOPE,";
    p_cSql = p_cSql+"OFLAGCONT,";
    p_cSql = p_cSql+"OCODANA,";
    p_cSql = p_cSql+"OCODVOC,";
    p_cSql = p_cSql+"OTIPOINT2,";
    p_cSql = p_cSql+"OCODINT2,";
    p_cSql = p_cSql+"OPAESE,";
    p_cSql = p_cSql+"ODESC2,";
    p_cSql = p_cSql+"OPROV2,";
    p_cSql = p_cSql+"OCODCAB2,";
    p_cSql = p_cSql+"ODESCINTER,";
    p_cSql = p_cSql+"ORAPPORTO,";
    p_cSql = p_cSql+"OFLAGRAP,";
    p_cSql = p_cSql+"OTIPOLEG,";
    p_cSql = p_cSql+"ODATAREG,";
    p_cSql = p_cSql+"OFLAGLIRE,";
    p_cSql = p_cSql+"OVALUTA,";
    p_cSql = p_cSql+"OSEGNO,";
    p_cSql = p_cSql+"OTOTLIRE,";
    p_cSql = p_cSql+"OTOTCONT,";
    p_cSql = p_cSql+"OCONNESOPER,";
    p_cSql = p_cSql+"OCAMBIO,";
    p_cSql = p_cSql+"ONUMPROG,";
    p_cSql = p_cSql+"OTIPOOPRAP,";
    p_cSql = p_cSql+"OTIPOINTER,";
    p_cSql = p_cSql+"OCODINTER,";
    p_cSql = p_cSql+"ODESCCIT,";
    p_cSql = p_cSql+"OPROVINCIA,";
    p_cSql = p_cSql+"OCODCAB,";
    p_cSql = p_cSql+"OFLAGFRAZ,";
    p_cSql = p_cSql+"OCONNESBEN,";
    p_cSql = p_cSql+"OUNIQUECODE,";
    p_cSql = p_cSql+"OAGOPER,";
    p_cSql = p_cSql+"ORIFIMP,";
    p_cSql = p_cSql+"OZCPARTE,";
    p_cSql = p_cSql+"ORAGIO,";
    p_cSql = p_cSql+"OMODSVOL,";
    p_cSql = p_cSql+"OAREAGEO,";
    p_cSql = p_cSql+"OINFORM,";
    p_cSql = p_cSql+"OAMMONT,";
    p_cSql = p_cSql+"ODURAT,";
    p_cSql = p_cSql+"OTIPO,";
    p_cSql = p_cSql+"ORRAGIO,";
    p_cSql = p_cSql+"ORCOMP,";
    p_cSql = p_cSql+"ORAREA,";
    p_cSql = p_cSql+"ORIMP,";
    p_cSql = p_cSql+"ORFREQ,";
    p_cSql = p_cSql+"OCONNALTRO,";
    p_cSql = p_cSql+"ODATAIMP,";
    p_cSql = p_cSql+"ORTIPO,";
    p_cSql = p_cSql+"OC_RAG,";
    p_cSql = p_cSql+"OC_STA,";
    p_cSql = p_cSql+"OC_CTA,";
    p_cSql = p_cSql+"OC_CAB,";
    p_cSql = p_cSql+"OC_PRV,";
    p_cSql = p_cSql+"OC_IND,";
    p_cSql = p_cSql+"OC_CAP,";
    p_cSql = p_cSql+"ONATURA,";
    p_cSql = p_cSql+"OSCOPO,";
    p_cSql = p_cSql+"OC_RAPPORTO,";
    p_cSql = p_cSql+"ORAPPORTBEN,";
    p_cSql = p_cSql+"OPAGASOGOP,";
    p_cSql = p_cSql+"DCODDIP,";
    p_cSql = p_cSql+"DDESCRIZ,";
    p_cSql = p_cSql+"DDESCCIT,";
    p_cSql = p_cSql+"DPROVINCIA,";
    p_cSql = p_cSql+"DCAB,";
    p_cSql = p_cSql+"DAGENTE,";
    p_cSql = p_cSql+"RNOTESCR,";
    if (p_Ctx.IsSharedTemp("archmovi_err")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"archmovi_err",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05FC65F8(CPContext p_Ctx) {
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
  protected static String GetFieldsName_06583858(CPContext p_Ctx) {
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
  protected static String GetFieldsName_062E4208(CPContext p_Ctx) {
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
    p_cSql = p_cSql+"RNATGIU,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RATTIV,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"PEP,";
    if (p_Ctx.IsSharedTemp("personbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_04178278(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"AREAGEO,";
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
    p_cSql = p_cSql+"CONNALTRO,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
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
    p_cSql = p_cSql+"RFREQ,";
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
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    if (p_Ctx.IsSharedTemp("xperazbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xperazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_07B44D50(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"AREAGEO,";
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
    p_cSql = p_cSql+"CONNALTRO,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
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
    p_cSql = p_cSql+"RFREQ,";
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
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    if (p_Ctx.IsSharedTemp("operazbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05F4F490(CPContext p_Ctx) {
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
    p_cSql = p_cSql+"idcauana,";
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
    if (p_Ctx.IsSharedTemp("operazbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05DA8C30(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    if (p_Ctx.IsSharedTemp("sogopebo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"sogopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_07AA8A48(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"AREAGEO,";
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
    p_cSql = p_cSql+"CONNALTRO,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
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
    p_cSql = p_cSql+"RFREQ,";
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
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    if (p_Ctx.IsSharedTemp("operazbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06340F78(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"AREAGEO,";
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
    p_cSql = p_cSql+"CONNALTRO,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
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
    p_cSql = p_cSql+"RFREQ,";
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
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    if (p_Ctx.IsSharedTemp("xraziobo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xraziobo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06EC1E30(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"AREAGEO,";
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
    p_cSql = p_cSql+"CONNALTRO,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
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
    p_cSql = p_cSql+"RFREQ,";
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
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    if (p_Ctx.IsSharedTemp("fraziobo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"fraziobo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_060FE218(CPContext p_Ctx) {
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
    p_cSql = p_cSql+"idcauana,";
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
    if (p_Ctx.IsSharedTemp("fraziobo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"fraziobo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_07C48638(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    if (p_Ctx.IsSharedTemp("sogopefbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"sogopefbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06194E90(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"AREAGEO,";
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
    p_cSql = p_cSql+"CONNALTRO,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
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
    p_cSql = p_cSql+"RFREQ,";
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
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    if (p_Ctx.IsSharedTemp("fraziobo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"fraziobo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05CC5D50(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODDIP,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CAB,";
    p_cSql = p_cSql+"AGENTE,";
    if (p_Ctx.IsSharedTemp("anadip")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"anadip",true);
    return p_cSql;
  }
}
