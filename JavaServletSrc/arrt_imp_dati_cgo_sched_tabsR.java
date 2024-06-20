// * --- Area Manuale = BO - Header
// * --- arrt_imp_dati_cgo_sched_tabs
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
// * --- Fine Area Manuale
public class arrt_imp_dati_cgo_sched_tabsR implements CallerWithObjs {
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
  public String m_cPhName_cgo_aams_base;
  public String m_cServer_cgo_aams_base;
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
  public String m_cPhName_cgo_rapporti;
  public String m_cServer_cgo_rapporti;
  public String m_cPhName_cgo_rapporti_err;
  public String m_cServer_cgo_rapporti_err;
  public String m_cPhName_cgo_soggetti;
  public String m_cServer_cgo_soggetti;
  public String m_cPhName_cgo_soggetti_err;
  public String m_cServer_cgo_soggetti_err;
  public String m_cPhName_cgo_tbtipgio;
  public String m_cServer_cgo_tbtipgio;
  public String m_cPhName_cgo_telematico;
  public String m_cServer_cgo_telematico;
  public String m_cPhName_cgo_telematico_err;
  public String m_cServer_cgo_telematico_err;
  public String m_cPhName_cgo_telematico_multipla;
  public String m_cServer_cgo_telematico_multipla;
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
  public String m_cPhName_fraziobo_agg;
  public String m_cServer_fraziobo_agg;
  public String m_cPhName_inter2bo;
  public String m_cServer_inter2bo;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_knarapbo;
  public String m_cServer_knarapbo;
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_operazbo_agg;
  public String m_cServer_operazbo_agg;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
  public String m_cPhName_slientifrz;
  public String m_cServer_slientifrz;
  public String m_cPhName_sogopebo;
  public String m_cServer_sogopebo;
  public String m_cPhName_sogopefbo;
  public String m_cServer_sogopefbo;
  public String m_cPhName_sraziobo;
  public String m_cServer_sraziobo;
  public String m_cPhName_sraziobo_agg;
  public String m_cServer_sraziobo_agg;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public String m_cPhName_tbtipdoc;
  public String m_cServer_tbtipdoc;
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
  public String m_cPhName_xperazbo_agg;
  public String m_cServer_xperazbo_agg;
  public String m_cPhName_xraziobo;
  public String m_cServer_xraziobo;
  public String m_cPhName_xraziobo_agg;
  public String m_cServer_xraziobo_agg;
  public String m_cPhName_cpwarn;
  public String m_cServer_cpwarn;
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
  public String fhand;
  public String riga;
  public String _tdest;
  public String xConnes;
  public String xCF;
  public String xRiga1;
  public String xRiga2;
  public String xRiga3;
  public String xRiga4;
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
  public double _intest;
  public double _stoper;
  public String _biglietto;
  public String _numass;
  public String _oldmodi;
  public MemoryCursor_mctelematicomultiple_mcrdef mcMultipla;
  public MemoryCursor_mcmatchope_mcrdef mcMatch;
  public double nTotRighe;
  public double nTotValide;
  public double nRighe;
  public double _criga;
  public String _match;
  public String _defmul;
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
  public double sNumero;
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
  public String xFLGSAE;
  public String _coddip;
  public String _ipcol;
  public double _drcol;
  public java.sql.Timestamp _orcol;
  public String _idbiglietto;
  public String _rapporto;
  public String _env;
  public double _importo;
  public String _iban;
  public String _flgaui;
  public String xSNAINUMOPE;
  public double mNumero;
  public double nRigheSto;
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
  public String _flgnodoc;
  public String _snaistor;
  public double _tottele;
  public String _codlob;
  public String _tipgio;
  public String nProgOpe;
  public double _cacodice;
  public double _prgope1;
  public double _prgope2;
  public double _prgimpope;
  public double _prgfrz1;
  public double _prgfrz2;
  public double _prgimpfrz;
  public double _codcau;
  public java.sql.Date _datini;
  public java.sql.Date _datend;
  public String _codrap;
  public String _intcon;
  public String _mezpagam;
  public String _MsgAss;
  public String _omulti;
  public String _omultic;
  public String _numopetele;
  public double _catipgio;
  public double _catipcon;
  public double _capv_cod;
  public java.sql.Timestamp _cadataora;
  public String _iddocall;
  public String _vpcodice;
  public String cColleg;
  public String _flglight;
  public String _flgope;
  public MemoryCursor_tbcitta mcTBCITTA;
  public MemoryCursor_tbstati mcTBSTATI;
  public MemoryCursor_tbstati mcTBSTATI_D;
  public MemoryCursor_cgo_causali mcCAUSALI;
  public MemoryCursor_cgo_causali mcCAUSALI_C;
  public MemoryCursor_cgo_tbtipgio mcTBTIPGIO;
  public MemoryCursor_tbtipdoc mcTIPDOC;
  public MemoryCursor_inter2bo mcINTER2BO;
  public MemoryCursor_clientiope mcCLIENTI;
  public MemoryCursorRow_cgo_soggetti rowSoggetti;
  public MemoryCursorRow_cgo_telematico rowTele;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_imp_dati_cgo_sched_tabs
  public String[] lista;
  public int conteggio;
  public int i;
  public int contanome;
  // * --- Fine Area Manuale
  public arrt_imp_dati_cgo_sched_tabsR (CPContext p_ContextObject, Caller caller) {
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
                                all'oggetto globale (unico per pi� istanze di una stessa applicazione)
                                per recuperare informazioni sul:
                                1) nome fisico della tabella di gestione;
                                2) nome fisico delle tabelle collegate nei link;
                                3) stringa di connessione.
                                L'azienda � contenuta nel global object.
                             */
    // I messaggi vengono instradati su questo oggetto
    m_MessageSink = CPMessageSink.ConsoleSink;
    m_Debug = com.zucchetti.sitepainter.Logger.getDebugLogger();
    m_Info = com.zucchetti.sitepainter.Logger.getInfoLogger();
    m_Warning = com.zucchetti.sitepainter.Logger.getWarningLogger();
    p_ContextObject = p_ContextObject.DisabledDataFilteringVersion();
    CPSecurity.RoutineCallableByProgram("arrt_imp_dati_cgo_sched_tabs",m_Caller);
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    if (m_cPhName_anadip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anadip = m_cPhName_anadip+" "+m_Ctx.GetWritePhName("anadip");
    }
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    if (m_cPhName_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anarapbo = m_cPhName_anarapbo+" "+m_Ctx.GetWritePhName("anarapbo");
    }
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_cgo_aams_base = p_ContextObject.GetPhName("cgo_aams_base");
    if (m_cPhName_cgo_aams_base.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_aams_base = m_cPhName_cgo_aams_base+" "+m_Ctx.GetWritePhName("cgo_aams_base");
    }
    m_cServer_cgo_aams_base = p_ContextObject.GetServer("cgo_aams_base");
    m_cPhName_cgo_anadip = p_ContextObject.GetPhName("cgo_anadip");
    if (m_cPhName_cgo_anadip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_anadip = m_cPhName_cgo_anadip+" "+m_Ctx.GetWritePhName("cgo_anadip");
    }
    m_cServer_cgo_anadip = p_ContextObject.GetServer("cgo_anadip");
    m_cPhName_cgo_anadip_err = p_ContextObject.GetPhName("cgo_anadip_err");
    if (m_cPhName_cgo_anadip_err.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_anadip_err = m_cPhName_cgo_anadip_err+" "+m_Ctx.GetWritePhName("cgo_anadip_err");
    }
    m_cServer_cgo_anadip_err = p_ContextObject.GetServer("cgo_anadip_err");
    m_cPhName_cgo_causali = p_ContextObject.GetPhName("cgo_causali");
    if (m_cPhName_cgo_causali.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_causali = m_cPhName_cgo_causali+" "+m_Ctx.GetWritePhName("cgo_causali");
    }
    m_cServer_cgo_causali = p_ContextObject.GetServer("cgo_causali");
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
    m_cPhName_cgo_rapporti = p_ContextObject.GetPhName("cgo_rapporti");
    if (m_cPhName_cgo_rapporti.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_rapporti = m_cPhName_cgo_rapporti+" "+m_Ctx.GetWritePhName("cgo_rapporti");
    }
    m_cServer_cgo_rapporti = p_ContextObject.GetServer("cgo_rapporti");
    m_cPhName_cgo_rapporti_err = p_ContextObject.GetPhName("cgo_rapporti_err");
    if (m_cPhName_cgo_rapporti_err.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_rapporti_err = m_cPhName_cgo_rapporti_err+" "+m_Ctx.GetWritePhName("cgo_rapporti_err");
    }
    m_cServer_cgo_rapporti_err = p_ContextObject.GetServer("cgo_rapporti_err");
    m_cPhName_cgo_soggetti = p_ContextObject.GetPhName("cgo_soggetti");
    if (m_cPhName_cgo_soggetti.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_soggetti = m_cPhName_cgo_soggetti+" "+m_Ctx.GetWritePhName("cgo_soggetti");
    }
    m_cServer_cgo_soggetti = p_ContextObject.GetServer("cgo_soggetti");
    m_cPhName_cgo_soggetti_err = p_ContextObject.GetPhName("cgo_soggetti_err");
    if (m_cPhName_cgo_soggetti_err.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_soggetti_err = m_cPhName_cgo_soggetti_err+" "+m_Ctx.GetWritePhName("cgo_soggetti_err");
    }
    m_cServer_cgo_soggetti_err = p_ContextObject.GetServer("cgo_soggetti_err");
    m_cPhName_cgo_tbtipgio = p_ContextObject.GetPhName("cgo_tbtipgio");
    if (m_cPhName_cgo_tbtipgio.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_tbtipgio = m_cPhName_cgo_tbtipgio+" "+m_Ctx.GetWritePhName("cgo_tbtipgio");
    }
    m_cServer_cgo_tbtipgio = p_ContextObject.GetServer("cgo_tbtipgio");
    m_cPhName_cgo_telematico = p_ContextObject.GetPhName("cgo_telematico");
    if (m_cPhName_cgo_telematico.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_telematico = m_cPhName_cgo_telematico+" "+m_Ctx.GetWritePhName("cgo_telematico");
    }
    m_cServer_cgo_telematico = p_ContextObject.GetServer("cgo_telematico");
    m_cPhName_cgo_telematico_err = p_ContextObject.GetPhName("cgo_telematico_err");
    if (m_cPhName_cgo_telematico_err.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_telematico_err = m_cPhName_cgo_telematico_err+" "+m_Ctx.GetWritePhName("cgo_telematico_err");
    }
    m_cServer_cgo_telematico_err = p_ContextObject.GetServer("cgo_telematico_err");
    m_cPhName_cgo_telematico_multipla = p_ContextObject.GetPhName("cgo_telematico_multipla");
    if (m_cPhName_cgo_telematico_multipla.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_telematico_multipla = m_cPhName_cgo_telematico_multipla+" "+m_Ctx.GetWritePhName("cgo_telematico_multipla");
    }
    m_cServer_cgo_telematico_multipla = p_ContextObject.GetServer("cgo_telematico_multipla");
    m_cPhName_cgo_totope = p_ContextObject.GetPhName("cgo_totope");
    if (m_cPhName_cgo_totope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_totope = m_cPhName_cgo_totope+" "+m_Ctx.GetWritePhName("cgo_totope");
    }
    m_cServer_cgo_totope = p_ContextObject.GetServer("cgo_totope");
    m_cPhName_cgo_users = p_ContextObject.GetPhName("cgo_users");
    if (m_cPhName_cgo_users.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_users = m_cPhName_cgo_users+" "+m_Ctx.GetWritePhName("cgo_users");
    }
    m_cServer_cgo_users = p_ContextObject.GetServer("cgo_users");
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
    m_cPhName_cpazi = p_ContextObject.GetPhName("cpazi");
    if (m_cPhName_cpazi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpazi = m_cPhName_cpazi+" "+m_Ctx.GetWritePhName("cpazi");
    }
    m_cServer_cpazi = p_ContextObject.GetServer("cpazi");
    m_cPhName_cpusers = p_ContextObject.GetPhName("cpusers");
    if (m_cPhName_cpusers.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpusers = m_cPhName_cpusers+" "+m_Ctx.GetWritePhName("cpusers");
    }
    m_cServer_cpusers = p_ContextObject.GetServer("cpusers");
    m_cPhName_cpusers_add = p_ContextObject.GetPhName("cpusers_add");
    if (m_cPhName_cpusers_add.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpusers_add = m_cPhName_cpusers_add+" "+m_Ctx.GetWritePhName("cpusers_add");
    }
    m_cServer_cpusers_add = p_ContextObject.GetServer("cpusers_add");
    m_cPhName_cpusrgrp = p_ContextObject.GetPhName("cpusrgrp");
    if (m_cPhName_cpusrgrp.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpusrgrp = m_cPhName_cpusrgrp+" "+m_Ctx.GetWritePhName("cpusrgrp");
    }
    m_cServer_cpusrgrp = p_ContextObject.GetServer("cpusrgrp");
    m_cPhName_fraziobo = p_ContextObject.GetPhName("fraziobo");
    if (m_cPhName_fraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fraziobo = m_cPhName_fraziobo+" "+m_Ctx.GetWritePhName("fraziobo");
    }
    m_cServer_fraziobo = p_ContextObject.GetServer("fraziobo");
    m_cPhName_fraziobo_agg = p_ContextObject.GetPhName("fraziobo_agg");
    if (m_cPhName_fraziobo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fraziobo_agg = m_cPhName_fraziobo_agg+" "+m_Ctx.GetWritePhName("fraziobo_agg");
    }
    m_cServer_fraziobo_agg = p_ContextObject.GetServer("fraziobo_agg");
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
    m_cPhName_knarapbo = p_ContextObject.GetPhName("knarapbo");
    if (m_cPhName_knarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_knarapbo = m_cPhName_knarapbo+" "+m_Ctx.GetWritePhName("knarapbo");
    }
    m_cServer_knarapbo = p_ContextObject.GetServer("knarapbo");
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    if (m_cPhName_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo = m_cPhName_operazbo+" "+m_Ctx.GetWritePhName("operazbo");
    }
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_cPhName_operazbo_agg = p_ContextObject.GetPhName("operazbo_agg");
    if (m_cPhName_operazbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo_agg = m_cPhName_operazbo_agg+" "+m_Ctx.GetWritePhName("operazbo_agg");
    }
    m_cServer_operazbo_agg = p_ContextObject.GetServer("operazbo_agg");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_rapopebo = p_ContextObject.GetPhName("rapopebo");
    if (m_cPhName_rapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapopebo = m_cPhName_rapopebo+" "+m_Ctx.GetWritePhName("rapopebo");
    }
    m_cServer_rapopebo = p_ContextObject.GetServer("rapopebo");
    m_cPhName_slientifrz = p_ContextObject.GetPhName("slientifrz");
    if (m_cPhName_slientifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_slientifrz = m_cPhName_slientifrz+" "+m_Ctx.GetWritePhName("slientifrz");
    }
    m_cServer_slientifrz = p_ContextObject.GetServer("slientifrz");
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
    m_cPhName_sraziobo = p_ContextObject.GetPhName("sraziobo");
    if (m_cPhName_sraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sraziobo = m_cPhName_sraziobo+" "+m_Ctx.GetWritePhName("sraziobo");
    }
    m_cServer_sraziobo = p_ContextObject.GetServer("sraziobo");
    m_cPhName_sraziobo_agg = p_ContextObject.GetPhName("sraziobo_agg");
    if (m_cPhName_sraziobo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sraziobo_agg = m_cPhName_sraziobo_agg+" "+m_Ctx.GetWritePhName("sraziobo_agg");
    }
    m_cServer_sraziobo_agg = p_ContextObject.GetServer("sraziobo_agg");
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
    m_cPhName_tbtipdoc = p_ContextObject.GetPhName("tbtipdoc");
    if (m_cPhName_tbtipdoc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbtipdoc = m_cPhName_tbtipdoc+" "+m_Ctx.GetWritePhName("tbtipdoc");
    }
    m_cServer_tbtipdoc = p_ContextObject.GetServer("tbtipdoc");
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
    m_cPhName_xnarapbo = p_ContextObject.GetPhName("xnarapbo");
    if (m_cPhName_xnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xnarapbo = m_cPhName_xnarapbo+" "+m_Ctx.GetWritePhName("xnarapbo");
    }
    m_cServer_xnarapbo = p_ContextObject.GetServer("xnarapbo");
    m_cPhName_xntestbo = p_ContextObject.GetPhName("xntestbo");
    if (m_cPhName_xntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xntestbo = m_cPhName_xntestbo+" "+m_Ctx.GetWritePhName("xntestbo");
    }
    m_cServer_xntestbo = p_ContextObject.GetServer("xntestbo");
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
    m_cPhName_cpwarn = p_ContextObject.GetPhName("cpwarn");
    if (m_cPhName_cpwarn.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpwarn = m_cPhName_cpwarn+" "+m_Ctx.GetWritePhName("cpwarn");
    }
    m_cServer_cpwarn = p_ContextObject.GetServer("cpwarn");
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
    if (CPLib.eqr("_intest",p_cVarName)) {
      return _intest;
    }
    if (CPLib.eqr("_stoper",p_cVarName)) {
      return _stoper;
    }
    if (CPLib.eqr("nTotRighe",p_cVarName)) {
      return nTotRighe;
    }
    if (CPLib.eqr("nTotValide",p_cVarName)) {
      return nTotValide;
    }
    if (CPLib.eqr("nRighe",p_cVarName)) {
      return nRighe;
    }
    if (CPLib.eqr("_criga",p_cVarName)) {
      return _criga;
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
    if (CPLib.eqr("sNumero",p_cVarName)) {
      return sNumero;
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
    if (CPLib.eqr("_drcol",p_cVarName)) {
      return _drcol;
    }
    if (CPLib.eqr("_importo",p_cVarName)) {
      return _importo;
    }
    if (CPLib.eqr("mNumero",p_cVarName)) {
      return mNumero;
    }
    if (CPLib.eqr("nRigheSto",p_cVarName)) {
      return nRigheSto;
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
    if (CPLib.eqr("_tottele",p_cVarName)) {
      return _tottele;
    }
    if (CPLib.eqr("_cacodice",p_cVarName)) {
      return _cacodice;
    }
    if (CPLib.eqr("_prgope1",p_cVarName)) {
      return _prgope1;
    }
    if (CPLib.eqr("_prgope2",p_cVarName)) {
      return _prgope2;
    }
    if (CPLib.eqr("_prgimpope",p_cVarName)) {
      return _prgimpope;
    }
    if (CPLib.eqr("_prgfrz1",p_cVarName)) {
      return _prgfrz1;
    }
    if (CPLib.eqr("_prgfrz2",p_cVarName)) {
      return _prgfrz2;
    }
    if (CPLib.eqr("_prgimpfrz",p_cVarName)) {
      return _prgimpfrz;
    }
    if (CPLib.eqr("_codcau",p_cVarName)) {
      return _codcau;
    }
    if (CPLib.eqr("_catipgio",p_cVarName)) {
      return _catipgio;
    }
    if (CPLib.eqr("_catipcon",p_cVarName)) {
      return _catipcon;
    }
    if (CPLib.eqr("_capv_cod",p_cVarName)) {
      return _capv_cod;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_imp_dati_cgo_sched_tabs";
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
    if (CPLib.eqr("xRiga3",p_cVarName)) {
      return xRiga3;
    }
    if (CPLib.eqr("xRiga4",p_cVarName)) {
      return xRiga4;
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
    if (CPLib.eqr("_biglietto",p_cVarName)) {
      return _biglietto;
    }
    if (CPLib.eqr("_numass",p_cVarName)) {
      return _numass;
    }
    if (CPLib.eqr("_oldmodi",p_cVarName)) {
      return _oldmodi;
    }
    if (CPLib.eqr("_match",p_cVarName)) {
      return _match;
    }
    if (CPLib.eqr("_defmul",p_cVarName)) {
      return _defmul;
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
    if (CPLib.eqr("xFLGSAE",p_cVarName)) {
      return xFLGSAE;
    }
    if (CPLib.eqr("_coddip",p_cVarName)) {
      return _coddip;
    }
    if (CPLib.eqr("_ipcol",p_cVarName)) {
      return _ipcol;
    }
    if (CPLib.eqr("_idbiglietto",p_cVarName)) {
      return _idbiglietto;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      return _rapporto;
    }
    if (CPLib.eqr("_env",p_cVarName)) {
      return _env;
    }
    if (CPLib.eqr("_iban",p_cVarName)) {
      return _iban;
    }
    if (CPLib.eqr("_flgaui",p_cVarName)) {
      return _flgaui;
    }
    if (CPLib.eqr("xSNAINUMOPE",p_cVarName)) {
      return xSNAINUMOPE;
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
    if (CPLib.eqr("_flgnodoc",p_cVarName)) {
      return _flgnodoc;
    }
    if (CPLib.eqr("_snaistor",p_cVarName)) {
      return _snaistor;
    }
    if (CPLib.eqr("_codlob",p_cVarName)) {
      return _codlob;
    }
    if (CPLib.eqr("_tipgio",p_cVarName)) {
      return _tipgio;
    }
    if (CPLib.eqr("nProgOpe",p_cVarName)) {
      return nProgOpe;
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
    if (CPLib.eqr("_omulti",p_cVarName)) {
      return _omulti;
    }
    if (CPLib.eqr("_omultic",p_cVarName)) {
      return _omultic;
    }
    if (CPLib.eqr("_numopetele",p_cVarName)) {
      return _numopetele;
    }
    if (CPLib.eqr("_iddocall",p_cVarName)) {
      return _iddocall;
    }
    if (CPLib.eqr("_vpcodice",p_cVarName)) {
      return _vpcodice;
    }
    if (CPLib.eqr("cColleg",p_cVarName)) {
      return cColleg;
    }
    if (CPLib.eqr("_flglight",p_cVarName)) {
      return _flglight;
    }
    if (CPLib.eqr("_flgope",p_cVarName)) {
      return _flgope;
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
    if (CPLib.eqr("_datini",p_cVarName)) {
      return _datini;
    }
    if (CPLib.eqr("_datend",p_cVarName)) {
      return _datend;
    }
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_orcol",p_cVarName)) {
      return _orcol;
    }
    if (CPLib.eqr("_cadataora",p_cVarName)) {
      return _cadataora;
    }
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("mcMultipla",p_cVarName)) {
      return mcMultipla;
    }
    if (CPLib.eqr("mcMatch",p_cVarName)) {
      return mcMatch;
    }
    if (CPLib.eqr("mcTBCITTA",p_cVarName)) {
      return mcTBCITTA;
    }
    if (CPLib.eqr("mcTBSTATI",p_cVarName)) {
      return mcTBSTATI;
    }
    if (CPLib.eqr("mcTBSTATI_D",p_cVarName)) {
      return mcTBSTATI_D;
    }
    if (CPLib.eqr("mcCAUSALI",p_cVarName)) {
      return mcCAUSALI;
    }
    if (CPLib.eqr("mcCAUSALI_C",p_cVarName)) {
      return mcCAUSALI_C;
    }
    if (CPLib.eqr("mcTBTIPGIO",p_cVarName)) {
      return mcTBTIPGIO;
    }
    if (CPLib.eqr("mcTIPDOC",p_cVarName)) {
      return mcTIPDOC;
    }
    if (CPLib.eqr("mcINTER2BO",p_cVarName)) {
      return mcINTER2BO;
    }
    if (CPLib.eqr("mcCLIENTI",p_cVarName)) {
      return mcCLIENTI;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("rowSoggetti",p_cVarName)) {
      return rowSoggetti;
    }
    if (CPLib.eqr("rowTele",p_cVarName)) {
      return rowTele;
    }
    if (CPLib.eqr("i_MessageSink",p_cVarName)) {
      return m_MessageSink.RowForCaller();
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
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
    if (CPLib.eqr("_intest",p_cVarName)) {
      _intest = value;
      return;
    }
    if (CPLib.eqr("_stoper",p_cVarName)) {
      _stoper = value;
      return;
    }
    if (CPLib.eqr("nTotRighe",p_cVarName)) {
      nTotRighe = value;
      return;
    }
    if (CPLib.eqr("nTotValide",p_cVarName)) {
      nTotValide = value;
      return;
    }
    if (CPLib.eqr("nRighe",p_cVarName)) {
      nRighe = value;
      return;
    }
    if (CPLib.eqr("_criga",p_cVarName)) {
      _criga = value;
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
    if (CPLib.eqr("sNumero",p_cVarName)) {
      sNumero = value;
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
    if (CPLib.eqr("_drcol",p_cVarName)) {
      _drcol = value;
      return;
    }
    if (CPLib.eqr("_importo",p_cVarName)) {
      _importo = value;
      return;
    }
    if (CPLib.eqr("mNumero",p_cVarName)) {
      mNumero = value;
      return;
    }
    if (CPLib.eqr("nRigheSto",p_cVarName)) {
      nRigheSto = value;
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
    if (CPLib.eqr("_tottele",p_cVarName)) {
      _tottele = value;
      return;
    }
    if (CPLib.eqr("_cacodice",p_cVarName)) {
      _cacodice = value;
      return;
    }
    if (CPLib.eqr("_prgope1",p_cVarName)) {
      _prgope1 = value;
      return;
    }
    if (CPLib.eqr("_prgope2",p_cVarName)) {
      _prgope2 = value;
      return;
    }
    if (CPLib.eqr("_prgimpope",p_cVarName)) {
      _prgimpope = value;
      return;
    }
    if (CPLib.eqr("_prgfrz1",p_cVarName)) {
      _prgfrz1 = value;
      return;
    }
    if (CPLib.eqr("_prgfrz2",p_cVarName)) {
      _prgfrz2 = value;
      return;
    }
    if (CPLib.eqr("_prgimpfrz",p_cVarName)) {
      _prgimpfrz = value;
      return;
    }
    if (CPLib.eqr("_codcau",p_cVarName)) {
      _codcau = value;
      return;
    }
    if (CPLib.eqr("_catipgio",p_cVarName)) {
      _catipgio = value;
      return;
    }
    if (CPLib.eqr("_catipcon",p_cVarName)) {
      _catipcon = value;
      return;
    }
    if (CPLib.eqr("_capv_cod",p_cVarName)) {
      _capv_cod = value;
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
    if (CPLib.eqr("xRiga3",p_cVarName)) {
      xRiga3 = value;
      return;
    }
    if (CPLib.eqr("xRiga4",p_cVarName)) {
      xRiga4 = value;
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
    if (CPLib.eqr("_biglietto",p_cVarName)) {
      _biglietto = value;
      return;
    }
    if (CPLib.eqr("_numass",p_cVarName)) {
      _numass = value;
      return;
    }
    if (CPLib.eqr("_oldmodi",p_cVarName)) {
      _oldmodi = value;
      return;
    }
    if (CPLib.eqr("_match",p_cVarName)) {
      _match = value;
      return;
    }
    if (CPLib.eqr("_defmul",p_cVarName)) {
      _defmul = value;
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
    if (CPLib.eqr("xFLGSAE",p_cVarName)) {
      xFLGSAE = value;
      return;
    }
    if (CPLib.eqr("_coddip",p_cVarName)) {
      _coddip = value;
      return;
    }
    if (CPLib.eqr("_ipcol",p_cVarName)) {
      _ipcol = value;
      return;
    }
    if (CPLib.eqr("_idbiglietto",p_cVarName)) {
      _idbiglietto = value;
      return;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      _rapporto = value;
      return;
    }
    if (CPLib.eqr("_env",p_cVarName)) {
      _env = value;
      return;
    }
    if (CPLib.eqr("_iban",p_cVarName)) {
      _iban = value;
      return;
    }
    if (CPLib.eqr("_flgaui",p_cVarName)) {
      _flgaui = value;
      return;
    }
    if (CPLib.eqr("xSNAINUMOPE",p_cVarName)) {
      xSNAINUMOPE = value;
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
    if (CPLib.eqr("_flgnodoc",p_cVarName)) {
      _flgnodoc = value;
      return;
    }
    if (CPLib.eqr("_snaistor",p_cVarName)) {
      _snaistor = value;
      return;
    }
    if (CPLib.eqr("_codlob",p_cVarName)) {
      _codlob = value;
      return;
    }
    if (CPLib.eqr("_tipgio",p_cVarName)) {
      _tipgio = value;
      return;
    }
    if (CPLib.eqr("nProgOpe",p_cVarName)) {
      nProgOpe = value;
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
    if (CPLib.eqr("_omulti",p_cVarName)) {
      _omulti = value;
      return;
    }
    if (CPLib.eqr("_omultic",p_cVarName)) {
      _omultic = value;
      return;
    }
    if (CPLib.eqr("_numopetele",p_cVarName)) {
      _numopetele = value;
      return;
    }
    if (CPLib.eqr("_iddocall",p_cVarName)) {
      _iddocall = value;
      return;
    }
    if (CPLib.eqr("_vpcodice",p_cVarName)) {
      _vpcodice = value;
      return;
    }
    if (CPLib.eqr("cColleg",p_cVarName)) {
      cColleg = value;
      return;
    }
    if (CPLib.eqr("_flglight",p_cVarName)) {
      _flglight = value;
      return;
    }
    if (CPLib.eqr("_flgope",p_cVarName)) {
      _flgope = value;
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
    if (CPLib.eqr("_datini",p_cVarName)) {
      _datini = value;
      return;
    }
    if (CPLib.eqr("_datend",p_cVarName)) {
      _datend = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
    if (CPLib.eqr("_orcol",p_cVarName)) {
      _orcol = value;
      return;
    }
    if (CPLib.eqr("_cadataora",p_cVarName)) {
      _cadataora = value;
      return;
    }
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
    if (CPLib.eqr("rowSoggetti",p_cVarName)) {
      rowSoggetti = (MemoryCursorRow_cgo_soggetti)value;
      return;
    }
    if (CPLib.eqr("rowTele",p_cVarName)) {
      rowTele = (MemoryCursorRow_cgo_telematico)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcMultipla",p_cVarName)) {
      mcMultipla = (MemoryCursor_mctelematicomultiple_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcMatch",p_cVarName)) {
      mcMatch = (MemoryCursor_mcmatchope_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcTBCITTA",p_cVarName)) {
      mcTBCITTA = (MemoryCursor_tbcitta)value;
      return;
    }
    if (CPLib.eqr("mcTBSTATI",p_cVarName)) {
      mcTBSTATI = (MemoryCursor_tbstati)value;
      return;
    }
    if (CPLib.eqr("mcTBSTATI_D",p_cVarName)) {
      mcTBSTATI_D = (MemoryCursor_tbstati)value;
      return;
    }
    if (CPLib.eqr("mcCAUSALI",p_cVarName)) {
      mcCAUSALI = (MemoryCursor_cgo_causali)value;
      return;
    }
    if (CPLib.eqr("mcCAUSALI_C",p_cVarName)) {
      mcCAUSALI_C = (MemoryCursor_cgo_causali)value;
      return;
    }
    if (CPLib.eqr("mcTBTIPGIO",p_cVarName)) {
      mcTBTIPGIO = (MemoryCursor_cgo_tbtipgio)value;
      return;
    }
    if (CPLib.eqr("mcTIPDOC",p_cVarName)) {
      mcTIPDOC = (MemoryCursor_tbtipdoc)value;
      return;
    }
    if (CPLib.eqr("mcINTER2BO",p_cVarName)) {
      mcINTER2BO = (MemoryCursor_inter2bo)value;
      return;
    }
    if (CPLib.eqr("mcCLIENTI",p_cVarName)) {
      mcCLIENTI = (MemoryCursor_clientiope)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_tbcitta=null;
    CPResultSet Cursor_tbstati=null;
    CPResultSet Cursor_cgo_causali=null;
    CPResultSet Cursor_cgo_tbtipgio=null;
    CPResultSet Cursor_tbtipdoc=null;
    CPResultSet Cursor_inter2bo=null;
    CPResultSet Cursor_cpazi=null;
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_qbe_cgo_telematico_totali=null;
    CPResultSet Cursor_cpwarn=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* fhand Char(1) */
      /* riga Memo */
      /* _tdest Char(1) */
      /* xConnes Char(16) */
      /* xCF Char(16) */
      /* xRiga1 Memo */
      /* xRiga2 Memo */
      /* xRiga3 Memo */
      /* xRiga4 Memo */
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
      /* _intest Numeric(5, 0) */
      /* _stoper Numeric(1, 0) */
      /* _biglietto Char(28) */
      /* _numass Char(25) */
      /* _oldmodi Char(15) */
      /* mcMultipla MemoryCursor(mcTelematicoMultiple.MCRDef) */
      /* mcMatch MemoryCursor(mcMatchOpe.MCRDef) */
      /* nTotRighe Numeric(4, 0) */
      /* nTotValide Numeric(4, 0) */
      /* nRighe Numeric(4, 0) */
      /* _criga Numeric(3, 0) */
      /* _match Char(1) */
      /* _defmul Char(10) */
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
      /* sNumero Numeric(10, 0) */
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
      /* xFLGSAE Char(1) */
      /* _coddip Char(6) */
      /* _ipcol Char(20) */
      /* _drcol Numeric(10, 0) */
      /* _orcol DateTime */
      /* _idbiglietto Char(30) */
      /* _rapporto Char(25) */
      /* _env Char(1) */
      /* _importo Numeric(15, 0) */
      /* _iban Char(27) */
      /* _flgaui Char(1) */
      /* xSNAINUMOPE Char(15) */
      /* mNumero Numeric(10, 0) */
      /* nRigheSto Numeric(4, 0) */
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
      /* _idb Char(30) */
      /* _seekid Char(20) */
      /* _flgnodoc Char(1) */
      /* _snaistor Char(1) */
      /* _tottele Numeric(15, 0) */
      /* _codlob Char(3) */
      /* _tipgio Char(3) */
      /* nProgOpe Char(15) */
      /* _cacodice Numeric(5, 0) */
      /* _prgope1 Numeric(11, 0) */
      /* _prgope2 Numeric(11, 0) */
      /* _prgimpope Numeric(11, 0) */
      /* _prgfrz1 Numeric(11, 0) */
      /* _prgfrz2 Numeric(11, 0) */
      /* _prgimpfrz Numeric(11, 0) */
      /* _codcau Numeric(5, 0) */
      /* _datini Date */
      /* _datend Date */
      /* _codrap Char(25) */
      /* _intcon Char(16) */
      /* _mezpagam Char(1) // Mezzo Pagamento */
      /* _MsgAss Memo */
      /* _omulti Char(1) */
      /* _omultic Char(1) */
      /* _omultic Char(1) */
      /* _numopetele Char(15) */
      /* _catipgio Numeric(5, 0) */
      /* _catipcon Numeric(5, 0) */
      /* _capv_cod Numeric(10, 0) */
      /* _cadataora DateTime */
      /* _iddocall Char(36) */
      /* _vpcodice Char(2) */
      /* cColleg Char(12) */
      /* _flglight Char(1) */
      /* _flgope Char(1) */
      /* mcTBCITTA MemoryCursor(tbcitta) */
      /* mcTBSTATI MemoryCursor(tbstati) */
      /* mcTBSTATI_D MemoryCursor(tbstati) */
      /* mcCAUSALI MemoryCursor(cgo_causali) */
      /* mcCAUSALI_C MemoryCursor(cgo_causali) */
      /* mcTBTIPGIO MemoryCursor(cgo_tbtipgio) */
      /* mcTIPDOC MemoryCursor(tbtipdoc) */
      /* mcINTER2BO MemoryCursor(inter2bo) */
      /* mcCLIENTI MemoryCursor(clientiope) */
      /* rowSoggetti Row(cgo_soggetti) */
      /* rowTele Row(cgo_telematico) */
      // * --- Fill memory cursor mcTBCITTA on tbcitta
      mcTBCITTA.Zap();
      m_cServer = m_Ctx.GetServer("tbcitta");
      m_cPhName = m_Ctx.GetPhName("tbcitta");
      if (Cursor_tbcitta!=null)
        Cursor_tbcitta.Close();
      Cursor_tbcitta = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbcitta")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_tbcitta;
        Cursor_tbcitta.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_imp_dati_cgo_sched_tabs: query on tbcitta returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_tbcitta.Eof())) {
        mcTBCITTA.AppendWithTrimmedKey(CPLib.LRTrim(Cursor_tbcitta.GetString("CITTA"))+Cursor_tbcitta.GetString("PROV"));
        mcTBCITTA.row.IDBASE = Cursor_tbcitta.GetString("IDBASE");
        mcTBCITTA.row.CITTA = Cursor_tbcitta.GetString("CITTA");
        mcTBCITTA.row.CAB = Cursor_tbcitta.GetString("CAB");
        mcTBCITTA.row.PROV = Cursor_tbcitta.GetString("PROV");
        mcTBCITTA.row.CAP = Cursor_tbcitta.GetString("CAP");
        mcTBCITTA.row.PKTBSTATI = Cursor_tbcitta.GetString("PKTBSTATI");
        mcTBCITTA.row.SIGLA = Cursor_tbcitta.GetString("SIGLA");
        mcTBCITTA.row.PREF = Cursor_tbcitta.GetString("PREF");
        mcTBCITTA.row.IDTBLS = Cursor_tbcitta.GetString("IDTBLS");
        mcTBCITTA.row.IDCITTA = Cursor_tbcitta.GetString("IDCITTA");
        mcTBCITTA.row.IDISTAT = Cursor_tbcitta.GetString("IDISTAT");
        mcTBCITTA.row.IDREGIO = Cursor_tbcitta.GetString("IDREGIO");
        mcTBCITTA.row.DATAINI = Cursor_tbcitta.GetDate("DATAINI");
        mcTBCITTA.row.DATAFIN = Cursor_tbcitta.GetDate("DATAFIN");
        Cursor_tbcitta.Next();
      }
      m_cConnectivityError = Cursor_tbcitta.ErrorMessage();
      Cursor_tbcitta.Close();
      mcTBCITTA.GoTop();
      // * --- Fill memory cursor mcTBSTATI on tbstati
      mcTBSTATI.Zap();
      m_cServer = m_Ctx.GetServer("tbstati");
      m_cPhName = m_Ctx.GetPhName("tbstati");
      if (Cursor_tbstati!=null)
        Cursor_tbstati.Close();
      Cursor_tbstati = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbstati")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_tbstati;
        Cursor_tbstati.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_imp_dati_cgo_sched_tabs: query on tbstati returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_tbstati.Eof())) {
        mcTBSTATI.AppendWithTrimmedKey(Cursor_tbstati.GetString("CODSTA"));
        mcTBSTATI.row.CODSTA = Cursor_tbstati.GetString("CODSTA");
        mcTBSTATI.row.DESCRI = Cursor_tbstati.GetString("DESCRI");
        mcTBSTATI.row.SIGLA = Cursor_tbstati.GetString("SIGLA");
        mcTBSTATI.row.ISO = Cursor_tbstati.GetString("ISO");
        mcTBSTATI.row.ISO2 = Cursor_tbstati.GetString("ISO2");
        mcTBSTATI.row.IDTBLS = Cursor_tbstati.GetString("IDTBLS");
        mcTBSTATI.row.IDBASE = Cursor_tbstati.GetString("IDBASE");
        mcTBSTATI.row.FLGSAE = Cursor_tbstati.GetString("FLGSAE");
        mcTBSTATI.row.ISON = Cursor_tbstati.GetString("ISON");
        Cursor_tbstati.Next();
      }
      m_cConnectivityError = Cursor_tbstati.ErrorMessage();
      Cursor_tbstati.Close();
      mcTBSTATI.GoTop();
      // * --- Fill memory cursor mcTBSTATI_D on tbstati
      mcTBSTATI_D.Zap();
      m_cServer = m_Ctx.GetServer("tbstati");
      m_cPhName = m_Ctx.GetPhName("tbstati");
      if (Cursor_tbstati!=null)
        Cursor_tbstati.Close();
      Cursor_tbstati = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbstati")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_tbstati;
        Cursor_tbstati.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_imp_dati_cgo_sched_tabs: query on tbstati returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_tbstati.Eof())) {
        mcTBSTATI_D.AppendWithTrimmedKey(Cursor_tbstati.GetString("DESCRI"));
        mcTBSTATI_D.row.CODSTA = Cursor_tbstati.GetString("CODSTA");
        mcTBSTATI_D.row.DESCRI = Cursor_tbstati.GetString("DESCRI");
        mcTBSTATI_D.row.SIGLA = Cursor_tbstati.GetString("SIGLA");
        mcTBSTATI_D.row.ISO = Cursor_tbstati.GetString("ISO");
        mcTBSTATI_D.row.ISO2 = Cursor_tbstati.GetString("ISO2");
        mcTBSTATI_D.row.IDTBLS = Cursor_tbstati.GetString("IDTBLS");
        mcTBSTATI_D.row.IDBASE = Cursor_tbstati.GetString("IDBASE");
        mcTBSTATI_D.row.FLGSAE = Cursor_tbstati.GetString("FLGSAE");
        mcTBSTATI_D.row.ISON = Cursor_tbstati.GetString("ISON");
        Cursor_tbstati.Next();
      }
      m_cConnectivityError = Cursor_tbstati.ErrorMessage();
      Cursor_tbstati.Close();
      mcTBSTATI_D.GoTop();
      // * --- Fill memory cursor mcCAUSALI on cgo_causali
      mcCAUSALI.Zap();
      m_cServer = m_Ctx.GetServer("cgo_causali");
      m_cPhName = m_Ctx.GetPhName("cgo_causali");
      if (Cursor_cgo_causali!=null)
        Cursor_cgo_causali.Close();
      Cursor_cgo_causali = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("cgo_causali")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_cgo_causali;
        Cursor_cgo_causali.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_imp_dati_cgo_sched_tabs: query on cgo_causali returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_cgo_causali.Eof())) {
        mcCAUSALI.AppendWithTrimmedKey(CPLib.Str(Cursor_cgo_causali.GetDouble("CACODICE"),5,0)+Cursor_cgo_causali.GetString("CATIPOPE"));
        mcCAUSALI.row.CACODICE = Cursor_cgo_causali.GetDouble("CACODICE");
        mcCAUSALI.row.CADESCRI = Cursor_cgo_causali.GetString("CADESCRI");
        mcCAUSALI.row.CACODANA = Cursor_cgo_causali.GetString("CACODANA");
        mcCAUSALI.row.CACODSIN = Cursor_cgo_causali.GetString("CACODSIN");
        mcCAUSALI.row.CASEGNO = Cursor_cgo_causali.GetString("CASEGNO");
        mcCAUSALI.row.CATIPOPE = Cursor_cgo_causali.GetString("CATIPOPE");
        mcCAUSALI.row.CAFLGOPE = Cursor_cgo_causali.GetString("CAFLGOPE");
        mcCAUSALI.row.CAFLGDIP = Cursor_cgo_causali.GetString("CAFLGDIP");
        mcCAUSALI.row.CAFLGAUI = Cursor_cgo_causali.GetString("CAFLGAUI");
        Cursor_cgo_causali.Next();
      }
      m_cConnectivityError = Cursor_cgo_causali.ErrorMessage();
      Cursor_cgo_causali.Close();
      mcCAUSALI.GoTop();
      // * --- Fill memory cursor mcCAUSALI_C on cgo_causali
      mcCAUSALI_C.Zap();
      m_cServer = m_Ctx.GetServer("cgo_causali");
      m_cPhName = m_Ctx.GetPhName("cgo_causali");
      if (Cursor_cgo_causali!=null)
        Cursor_cgo_causali.Close();
      Cursor_cgo_causali = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("cgo_causali")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_cgo_causali;
        Cursor_cgo_causali.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_imp_dati_cgo_sched_tabs: query on cgo_causali returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_cgo_causali.Eof())) {
        mcCAUSALI_C.AppendWithTrimmedKey(Cursor_cgo_causali.GetDouble("CACODICE"));
        mcCAUSALI_C.row.CACODICE = Cursor_cgo_causali.GetDouble("CACODICE");
        mcCAUSALI_C.row.CADESCRI = Cursor_cgo_causali.GetString("CADESCRI");
        mcCAUSALI_C.row.CACODANA = Cursor_cgo_causali.GetString("CACODANA");
        mcCAUSALI_C.row.CACODSIN = Cursor_cgo_causali.GetString("CACODSIN");
        mcCAUSALI_C.row.CASEGNO = Cursor_cgo_causali.GetString("CASEGNO");
        mcCAUSALI_C.row.CATIPOPE = Cursor_cgo_causali.GetString("CATIPOPE");
        mcCAUSALI_C.row.CAFLGOPE = Cursor_cgo_causali.GetString("CAFLGOPE");
        mcCAUSALI_C.row.CAFLGDIP = Cursor_cgo_causali.GetString("CAFLGDIP");
        mcCAUSALI_C.row.CAFLGAUI = Cursor_cgo_causali.GetString("CAFLGAUI");
        Cursor_cgo_causali.Next();
      }
      m_cConnectivityError = Cursor_cgo_causali.ErrorMessage();
      Cursor_cgo_causali.Close();
      mcCAUSALI_C.GoTop();
      // * --- Fill memory cursor mcTBTIPGIO on cgo_tbtipgio
      mcTBTIPGIO.Zap();
      m_cServer = m_Ctx.GetServer("cgo_tbtipgio");
      m_cPhName = m_Ctx.GetPhName("cgo_tbtipgio");
      if (Cursor_cgo_tbtipgio!=null)
        Cursor_cgo_tbtipgio.Close();
      Cursor_cgo_tbtipgio = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("cgo_tbtipgio")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_cgo_tbtipgio;
        Cursor_cgo_tbtipgio.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_imp_dati_cgo_sched_tabs: query on cgo_tbtipgio returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_cgo_tbtipgio.Eof())) {
        mcTBTIPGIO.AppendBlank();
        mcTBTIPGIO.row.CODTPGIO = Cursor_cgo_tbtipgio.GetString("CODTPGIO");
        mcTBTIPGIO.row.DESTPGIO = Cursor_cgo_tbtipgio.GetString("DESTPGIO");
        mcTBTIPGIO.row.SOGTPGIO = Cursor_cgo_tbtipgio.GetDouble("SOGTPGIO");
        mcTBTIPGIO.row.DEFTPGIO = Cursor_cgo_tbtipgio.GetString("DEFTPGIO");
        mcTBTIPGIO.row.EDTTPGIO = Cursor_cgo_tbtipgio.GetString("EDTTPGIO");
        mcTBTIPGIO.row.EDTSPGIO = Cursor_cgo_tbtipgio.GetString("EDTSPGIO");
        mcTBTIPGIO.row.DEFSPGIO = Cursor_cgo_tbtipgio.GetString("DEFSPGIO");
        mcTBTIPGIO.row.FLGPLGIO = Cursor_cgo_tbtipgio.GetString("FLGPLGIO");
        mcTBTIPGIO.row.FLGMLGIO = Cursor_cgo_tbtipgio.GetString("FLGMLGIO");
        mcTBTIPGIO.row.MAGPAGGIO = Cursor_cgo_tbtipgio.GetDouble("MAGPAGGIO");
        mcTBTIPGIO.row.MINPAGGIO = Cursor_cgo_tbtipgio.GetDouble("MINPAGGIO");
        mcTBTIPGIO.row.NCOPAGGIO = Cursor_cgo_tbtipgio.GetDouble("NCOPAGGIO");
        mcTBTIPGIO.row.FDC1OSGIO = Cursor_cgo_tbtipgio.GetString("FDC1OSGIO");
        mcTBTIPGIO.row.FDC2OSGIO = Cursor_cgo_tbtipgio.GetString("FDC2OSGIO");
        mcTBTIPGIO.row.FDC3OSGIO = Cursor_cgo_tbtipgio.GetString("FDC3OSGIO");
        mcTBTIPGIO.row.FDC4OSGIO = Cursor_cgo_tbtipgio.GetString("FDC4OSGIO");
        mcTBTIPGIO.row.FDC5OSGIO = Cursor_cgo_tbtipgio.GetString("FDC5OSGIO");
        mcTBTIPGIO.row.FDC6OSGIO = Cursor_cgo_tbtipgio.GetString("FDC6OSGIO");
        mcTBTIPGIO.row.FDC1SSGIO = Cursor_cgo_tbtipgio.GetString("FDC1SSGIO");
        mcTBTIPGIO.row.FDC2SSGIO = Cursor_cgo_tbtipgio.GetString("FDC2SSGIO");
        mcTBTIPGIO.row.FDC3SSGIO = Cursor_cgo_tbtipgio.GetString("FDC3SSGIO");
        mcTBTIPGIO.row.FDC4SSGIO = Cursor_cgo_tbtipgio.GetString("FDC4SSGIO");
        mcTBTIPGIO.row.FDC5SSGIO = Cursor_cgo_tbtipgio.GetString("FDC5SSGIO");
        mcTBTIPGIO.row.FDC6SSGIO = Cursor_cgo_tbtipgio.GetString("FDC6SSGIO");
        mcTBTIPGIO.row.FDC1ACGIO = Cursor_cgo_tbtipgio.GetString("FDC1ACGIO");
        mcTBTIPGIO.row.FDC2ACGIO = Cursor_cgo_tbtipgio.GetString("FDC2ACGIO");
        mcTBTIPGIO.row.FDC3ACGIO = Cursor_cgo_tbtipgio.GetString("FDC3ACGIO");
        mcTBTIPGIO.row.FDC4ACGIO = Cursor_cgo_tbtipgio.GetString("FDC4ACGIO");
        mcTBTIPGIO.row.FDC5ACGIO = Cursor_cgo_tbtipgio.GetString("FDC5ACGIO");
        mcTBTIPGIO.row.FDC6ACGIO = Cursor_cgo_tbtipgio.GetString("FDC6ACGIO");
        mcTBTIPGIO.row.FLTIPGIO = Cursor_cgo_tbtipgio.GetString("FLTIPGIO");
        mcTBTIPGIO.row.FLGATTIVO = Cursor_cgo_tbtipgio.GetString("FLGATTIVO");
        mcTBTIPGIO.row.IMPMINGIO = Cursor_cgo_tbtipgio.GetDouble("IMPMINGIO");
        mcTBTIPGIO.row.IMPMINTOT = Cursor_cgo_tbtipgio.GetDouble("IMPMINTOT");
        Cursor_cgo_tbtipgio.Next();
      }
      m_cConnectivityError = Cursor_cgo_tbtipgio.ErrorMessage();
      Cursor_cgo_tbtipgio.Close();
      mcTBTIPGIO.GoTop();
      // * --- Fill memory cursor mcTIPDOC on tbtipdoc
      mcTIPDOC.Zap();
      m_cServer = m_Ctx.GetServer("tbtipdoc");
      m_cPhName = m_Ctx.GetPhName("tbtipdoc");
      if (Cursor_tbtipdoc!=null)
        Cursor_tbtipdoc.Close();
      Cursor_tbtipdoc = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbtipdoc")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_tbtipdoc;
        Cursor_tbtipdoc.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_imp_dati_cgo_sched_tabs: query on tbtipdoc returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_tbtipdoc.Eof())) {
        mcTIPDOC.AppendWithTrimmedKey(Cursor_tbtipdoc.GetString("TIPDOC"));
        mcTIPDOC.row.TIPDOC = Cursor_tbtipdoc.GetString("TIPDOC");
        mcTIPDOC.row.DESCRI = Cursor_tbtipdoc.GetString("DESCRI");
        Cursor_tbtipdoc.Next();
      }
      m_cConnectivityError = Cursor_tbtipdoc.ErrorMessage();
      Cursor_tbtipdoc.Close();
      mcTIPDOC.GoTop();
      // * --- Fill memory cursor mcINTER2BO on inter2bo
      mcINTER2BO.Zap();
      m_cServer = m_Ctx.GetServer("inter2bo");
      m_cPhName = m_Ctx.GetPhName("inter2bo");
      if (Cursor_inter2bo!=null)
        Cursor_inter2bo.Close();
      Cursor_inter2bo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("inter2bo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_inter2bo;
        Cursor_inter2bo.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_imp_dati_cgo_sched_tabs: query on inter2bo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_inter2bo.Eof())) {
        mcINTER2BO.AppendWithTrimmedKey(Cursor_inter2bo.GetString("CODINTER"));
        mcINTER2BO.row.CODINTER = Cursor_inter2bo.GetString("CODINTER");
        mcINTER2BO.row.RAGSOC = Cursor_inter2bo.GetString("RAGSOC");
        mcINTER2BO.row.CODCAB = Cursor_inter2bo.GetString("CODCAB");
        mcINTER2BO.row.DOMICILIO = Cursor_inter2bo.GetString("DOMICILIO");
        mcINTER2BO.row.CODFISC = Cursor_inter2bo.GetString("CODFISC");
        mcINTER2BO.row.DATANASC = Cursor_inter2bo.GetDate("DATANASC");
        mcINTER2BO.row.NASCOMUN = Cursor_inter2bo.GetString("NASCOMUN");
        mcINTER2BO.row.SOTGRUP = Cursor_inter2bo.GetString("SOTGRUP");
        mcINTER2BO.row.RAMOGRUP = Cursor_inter2bo.GetString("RAMOGRUP");
        mcINTER2BO.row.SETTSINT = Cursor_inter2bo.GetString("SETTSINT");
        mcINTER2BO.row.TIPODOC = Cursor_inter2bo.GetString("TIPODOC");
        mcINTER2BO.row.NUMDOCUM = Cursor_inter2bo.GetString("NUMDOCUM");
        mcINTER2BO.row.DATARILASC = Cursor_inter2bo.GetDate("DATARILASC");
        mcINTER2BO.row.AUTRILASC = Cursor_inter2bo.GetString("AUTRILASC");
        mcINTER2BO.row.DESCCIT = Cursor_inter2bo.GetString("DESCCIT");
        mcINTER2BO.row.PROVINCIA = Cursor_inter2bo.GetString("PROVINCIA");
        mcINTER2BO.row.PAESE = Cursor_inter2bo.GetString("PAESE");
        mcINTER2BO.row.CAP = Cursor_inter2bo.GetString("CAP");
        mcINTER2BO.row.TIPINTER = Cursor_inter2bo.GetString("TIPINTER");
        mcINTER2BO.row.TIPOPERS = Cursor_inter2bo.GetString("TIPOPERS");
        mcINTER2BO.row.CONNES = Cursor_inter2bo.GetString("CONNES");
        mcINTER2BO.row.CODDIPE = Cursor_inter2bo.GetString("CODDIPE");
        mcINTER2BO.row.PARTIVA = Cursor_inter2bo.GetString("PARTIVA");
        mcINTER2BO.row.SESSO = Cursor_inter2bo.GetString("SESSO");
        mcINTER2BO.row.SOSPMAF = Cursor_inter2bo.GetString("SOSPMAF");
        mcINTER2BO.row.IDCITTA = Cursor_inter2bo.GetString("IDCITTA");
        mcINTER2BO.row.CONTO = Cursor_inter2bo.GetString("CONTO");
        Cursor_inter2bo.Next();
      }
      m_cConnectivityError = Cursor_inter2bo.ErrorMessage();
      Cursor_inter2bo.Close();
      mcINTER2BO.GoTop();
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
          /* _limoper := intermbo->MINFRZSNAI */
          _limoper = CPLib.Round(Cursor_intermbo.GetDouble("MINFRZSNAI"),2);
          /* _limvlt := intermbo->LIMITVLT */
          _limvlt = CPLib.Round(Cursor_intermbo.GetDouble("LIMITVLT"),2);
          /* _limvnp := intermbo->LIMITVNP */
          _limvnp = CPLib.Round(Cursor_intermbo.GetDouble("LIMITVNP"),2);
          /* _flgnodoc := intermbo->FLGNODOC */
          _flgnodoc = Cursor_intermbo.GetString("FLGNODOC");
          /* _snaistor := intermbo->SNAISTOR */
          _snaistor = Cursor_intermbo.GetString("SNAISTOR");
          /* _flglight := intermbo->FLGLIGHT */
          _flglight = Cursor_intermbo.GetString("FLGLIGHT");
          /* _defmul := intermbo->CGOTGDEFMUL */
          _defmul = Cursor_intermbo.GetString("CGOTGDEFMUL");
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
        // Begin Transaction
        m_Sql.RequireTransaction();
        double nTry00000124status;
        nTry00000124status = m_Sql.GetTransactionStatus();
        String cTry00000124msg;
        cTry00000124msg = m_Sql.TransactionErrorMessage();
        try {
          /* _prgope1 := 0 */
          _prgope1 = CPLib.Round(0,0);
          /* _prgope2 := 0 */
          _prgope2 = CPLib.Round(0,0);
          /* _prgimpope := 0 */
          _prgimpope = CPLib.Round(0,0);
          /* _prgfrz1 := 0 */
          _prgfrz1 = CPLib.Round(0,0);
          /* _prgfrz2 := 0 */
          _prgfrz2 = CPLib.Round(0,0);
          /* _prgimpfrz := 0 */
          _prgimpfrz = CPLib.Round(0,0);
          // * --- Select from qbe_cgo_telematico_totali
          if (Cursor_qbe_cgo_telematico_totali!=null)
            Cursor_qbe_cgo_telematico_totali.Close();
          Cursor_qbe_cgo_telematico_totali = new VQRHolder("qbe_cgo_telematico_totali",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_cgo_telematico_totali.Eof())) {
            /* _tottele := qbe_cgo_telematico_totali->TOTALE */
            _tottele = CPLib.Round(Cursor_qbe_cgo_telematico_totali.GetDouble("TOTALE"),0);
            Cursor_qbe_cgo_telematico_totali.Next();
          }
          m_cConnectivityError = Cursor_qbe_cgo_telematico_totali.ErrorMessage();
          Cursor_qbe_cgo_telematico_totali.Close();
          // * --- End Select
          /* If _tottele > 0 */
          if (CPLib.gt(_tottele,0)) {
            // * --- Select from cpwarn
            m_cServer = m_Ctx.GetServer("cpwarn");
            m_cPhName = m_Ctx.GetPhName("cpwarn");
            if (Cursor_cpwarn!=null)
              Cursor_cpwarn.Close();
            Cursor_cpwarn = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("cpwarn")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_cpwarn.Eof())) {
              /* If w_tipodest='P' */
              if (CPLib.eqr(w_tipodest,"P")) {
                /* If At("PPOPER1",cpwarn->tablecode) > 0 */
                if (CPLib.gt(CPLib.At("PPOPER1",Cursor_cpwarn.GetString("tablecode")),0)) {
                  /* _prgope1 := cpwarn->autonum */
                  _prgope1 = CPLib.Round(Cursor_cpwarn.GetDouble("autonum"),0);
                  // * --- Write into cpwarn from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("cpwarn");
                  m_cPhName = m_Ctx.GetPhName("cpwarn");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000132")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(_prgope1+_tottele+1,"N",10,0)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PPOPER1\\'"+CPLib.LRTrim(_gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PPOPER1\\'"+CPLib.LRTrim(_gAzienda)+"'")+"";
                  m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_gAzienda,"?",0,0,m_cServer),m_cServer,_gAzienda)+"";
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
                /* If At("PPOPER2",cpwarn->tablecode) > 0 */
                if (CPLib.gt(CPLib.At("PPOPER2",Cursor_cpwarn.GetString("tablecode")),0)) {
                  /* _prgope2 := cpwarn->autonum */
                  _prgope2 = CPLib.Round(Cursor_cpwarn.GetDouble("autonum"),0);
                  // * --- Write into cpwarn from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("cpwarn");
                  m_cPhName = m_Ctx.GetPhName("cpwarn");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000135")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(_prgope2+_tottele+1,"N",10,0)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PPOPER2\\'"+CPLib.LRTrim(_gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PPOPER2\\'"+CPLib.LRTrim(_gAzienda)+"'")+"";
                  m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_gAzienda,"?",0,0,m_cServer),m_cServer,_gAzienda)+"";
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
                /* If At("PPFRAZ1",cpwarn->tablecode) > 0 */
                if (CPLib.gt(CPLib.At("PPFRAZ1",Cursor_cpwarn.GetString("tablecode")),0)) {
                  /* _prgfrz1 := cpwarn->autonum */
                  _prgfrz1 = CPLib.Round(Cursor_cpwarn.GetDouble("autonum"),0);
                  // * --- Write into cpwarn from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("cpwarn");
                  m_cPhName = m_Ctx.GetPhName("cpwarn");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000138")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(_prgfrz1+_tottele+1,"N",10,0)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PPFRAZ1\\'"+CPLib.LRTrim(_gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PPFRAZ1\\'"+CPLib.LRTrim(_gAzienda)+"'")+"";
                  m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_gAzienda,"?",0,0,m_cServer),m_cServer,_gAzienda)+"";
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
                /* If At("PPFRAZ2",cpwarn->tablecode) > 0 */
                if (CPLib.gt(CPLib.At("PPFRAZ2",Cursor_cpwarn.GetString("tablecode")),0)) {
                  /* _prgfrz2 := cpwarn->autonum */
                  _prgfrz2 = CPLib.Round(Cursor_cpwarn.GetDouble("autonum"),0);
                  // * --- Write into cpwarn from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("cpwarn");
                  m_cPhName = m_Ctx.GetPhName("cpwarn");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"0000013B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(_prgfrz2+_tottele+1,"N",10,0)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PPFRAZ2\\'"+CPLib.LRTrim(_gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PPFRAZ2\\'"+CPLib.LRTrim(_gAzienda)+"'")+"";
                  m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_gAzienda,"?",0,0,m_cServer),m_cServer,_gAzienda)+"";
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
              /* If At("PRGIMPOPE",cpwarn->tablecode) > 0 */
              if (CPLib.gt(CPLib.At("PRGIMPOPE",Cursor_cpwarn.GetString("tablecode")),0)) {
                /* _prgimpope := cpwarn->autonum */
                _prgimpope = CPLib.Round(Cursor_cpwarn.GetDouble("autonum"),0);
                // * --- Write into cpwarn from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("cpwarn");
                m_cPhName = m_Ctx.GetPhName("cpwarn");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"0000013E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(_prgimpope+_tottele+1,"N",10,0)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PRGIMPOPE\\'"+CPLib.LRTrim(_gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PRGIMPOPE\\'"+CPLib.LRTrim(_gAzienda)+"'")+"";
                m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_gAzienda,"?",0,0,m_cServer),m_cServer,_gAzienda)+"";
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
              /* If At("PRGIMPFRZ",cpwarn->tablecode) > 0 */
              if (CPLib.gt(CPLib.At("PRGIMPFRZ",Cursor_cpwarn.GetString("tablecode")),0)) {
                /* _prgimpfrz := cpwarn->autonum */
                _prgimpfrz = CPLib.Round(Cursor_cpwarn.GetDouble("autonum"),0);
                // * --- Write into cpwarn from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("cpwarn");
                m_cPhName = m_Ctx.GetPhName("cpwarn");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000141")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(_prgimpfrz+_tottele+1,"N",10,0)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PRGIMPFRZ\\'"+CPLib.LRTrim(_gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PRGIMPFRZ\\'"+CPLib.LRTrim(_gAzienda)+"'")+"";
                m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_gAzienda,"?",0,0,m_cServer),m_cServer,_gAzienda)+"";
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
              Cursor_cpwarn.Next();
            }
            m_cConnectivityError = Cursor_cpwarn.ErrorMessage();
            Cursor_cpwarn.Close();
            // * --- End Select
          } // End If
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
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000124status,0)) {
            m_Sql.SetTransactionStatus(nTry00000124status,cTry00000124msg);
          }
        }
        // Begin Transaction
        m_Sql.RequireTransaction();
        double nTry00000145status;
        nTry00000145status = m_Sql.GetTransactionStatus();
        String cTry00000145msg;
        cTry00000145msg = m_Sql.TransactionErrorMessage();
        try {
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
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* Exec "Soggetti" Page 3:Page_3 */
          Page_3();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* Exec "Rapporti" Page 4:Page_4 */
          Page_4();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* Exec "Operazioni / Frazionate" Page 5:Page_5 */
          Page_5();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* Exec "Utenti" Page 6:Page_6 */
          Page_6();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
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
          /* _gMsgProc := "Rilevati errori nell'importazione dei file! Ricreare il file segnalato e rieseguire l'import dei dati. La procedura annullera automaticamente l'importazione" + NL */
          _gMsgProc = "Rilevati errori nell'importazione dei file! Ricreare il file segnalato e rieseguire l'import dei dati. La procedura annullera automaticamente l'importazione"+"\n";
          /* _gMsgProc := _gMsgProc + 'Errore SQL: ' + m_Sql.TransactionErrorMessage() + NL */
          _gMsgProc = _gMsgProc+"Errore SQL: "+m_Sql.TransactionErrorMessage()+"\n";
          // Rollback
          m_Sql.AbortTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          m_bError = true;
          m_Sql.CompleteTransaction();
          /* Exec Routine arrt_writelog('IMPORT DATI','Scheduler','ERRORS',_gMsgProc,"S") */
          arrt_writelogR.Make(m_Ctx,this).Run("IMPORT DATI","Scheduler","ERRORS",_gMsgProc,"S");
          /* Utilities.SetCompany(LRTrim(cpazi->codazi)) */
          Utilities.Make(m_Ctx,m_Caller).SetCompany(CPLib.LRTrim(Cursor_cpazi.GetString("codazi")));
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000145status,0)) {
            m_Sql.SetTransactionStatus(nTry00000145status,cTry00000145msg);
          }
        }
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
        if (Cursor_tbcitta!=null)
          Cursor_tbcitta.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tbstati!=null)
          Cursor_tbstati.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_cgo_causali!=null)
          Cursor_cgo_causali.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_cgo_tbtipgio!=null)
          Cursor_cgo_tbtipgio.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tbtipdoc!=null)
          Cursor_tbtipdoc.Close();
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
        if (Cursor_qbe_cgo_telematico_totali!=null)
          Cursor_qbe_cgo_telematico_totali.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_cpwarn!=null)
          Cursor_cpwarn.Close();
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
          /* _txterr := '' */
          _txterr = "";
          /* _recOK := 0 */
          _recOK = CPLib.Round(0,0);
          /* If _snaistor='N' */
          if (CPLib.eqr(_snaistor,"N")) {
            /* If Empty(LRTrim(cgo_anadip->CODDIP)) */
            if (CPLib.Empty(CPLib.LRTrim(Cursor_cgo_anadip.GetString("CODDIP")))) {
              /* _txterr := _txterr + 'Manca il codice della dipendenza' + NL */
              _txterr = _txterr+"Manca il codice della dipendenza"+"\n";
              /* _recOK := 1 */
              _recOK = CPLib.Round(1,0);
            } // End If
            /* If Empty(LRTrim(cgo_anadip->CAB)) and Empty(LRTrim(cgo_anadip->DESCCIT)) */
            if (CPLib.Empty(CPLib.LRTrim(Cursor_cgo_anadip.GetString("CAB"))) && CPLib.Empty(CPLib.LRTrim(Cursor_cgo_anadip.GetString("DESCCIT")))) {
              /* _txterr := _txterr + 'Mancano il CAB o la citt� della dipendenza' + NL */
              _txterr = _txterr+"Mancano il CAB o la citt� della dipendenza"+"\n";
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
            /* If Empty(LRTrim(cgo_anadip->CODLOC)) */
            if (CPLib.Empty(CPLib.LRTrim(Cursor_cgo_anadip.GetString("CODLOC")))) {
              /* _txterr := _txterr + 'Manca il codice locale' + NL */
              _txterr = _txterr+"Manca il codice locale"+"\n";
              /* _recOK := 1 */
              _recOK = CPLib.Round(1,0);
            } // End If
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
              /* xCitta := LRTrim(Upper(cgo_anadip->DESCCIT)) */
              xCitta = CPLib.LRTrim(CPLib.Upper(Cursor_cgo_anadip.GetString("DESCCIT")));
              /* If mcTBCITTA.HasKey(xCitta+cgo_anadip->PROVINCIA) */
              if (mcTBCITTA.HasKey(xCitta+Cursor_cgo_anadip.GetString("PROVINCIA"))) {
                /* If mcTBCITTA.GoToKey(xCitta+cgo_anadip->PROVINCIA) */
                if (mcTBCITTA.GoToKey(xCitta+Cursor_cgo_anadip.GetString("PROVINCIA"))) {
                  /* xCodCab := mcTBCITTA.CAB */
                  xCodCab = mcTBCITTA.row.CAB;
                } // End If
              } // End If
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
                Error l_oErrorFault = new Error("Read on anadip into routine arrt_imp_dati_cgo_sched_tabs returns two or more records. This item should return only a record.");
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
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anadip",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000186")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000186(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(xDIP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_anadip.GetString("DESCRIZ"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_anadip.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_anadip.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(xCodCab,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_anadip.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_anadip.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_anadip.GetString("TELEFONO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_anadip.GetString("CODLOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_anadip.GetString("CODICEAAMS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anadip",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000188")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"DESCRIZ = "+CPLib.ToSQL(Cursor_cgo_anadip.GetString("DESCRIZ"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_cgo_anadip.GetString("DESCCIT"),"C",60,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_cgo_anadip.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAB = "+CPLib.ToSQL(xCodCab,"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"IDBASE = "+CPLib.ToSQL(Cursor_cgo_anadip.GetString("IDBASE"),"C",10,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_cgo_anadip.GetString("DOMICILIO"),"C",50,0,m_cServer)+", ";
              m_cSql = m_cSql+"TELEFONO = "+CPLib.ToSQL(Cursor_cgo_anadip.GetString("TELEFONO"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODLOC = "+CPLib.ToSQL(Cursor_cgo_anadip.GetString("CODLOC"),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODICEAAMS = "+CPLib.ToSQL(Cursor_cgo_anadip.GetString("CODICEAAMS"),"C",12,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"anadip",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"CODDIP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(xDIP,"?",0,0,m_cServer),m_cServer,xDIP)+"";
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
              /* dNumMod := dNumMod + 1 */
              dNumMod = CPLib.Round(dNumMod+1,0);
            } // End If
          } else { // Else
            /* ProgErr := LibreriaMit.GeneraCodice(15,true,false,"") */
            ProgErr = LibreriaMit.GeneraCodice(15,true,false,"");
            // * --- Insert into cgo_anadip_err from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cgo_anadip_err");
            m_cPhName = m_Ctx.GetPhName("cgo_anadip_err");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_anadip_err",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"0000018B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000018B(m_Ctx,m_oWrInfo);
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
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_anadip.GetString("CODLOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_anadip.GetString("CODICEAAMS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_telematico_err",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"0000018E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000018E(m_Ctx,m_oWrInfo);
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
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("MEZPAGAM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("TIPOGIOCO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CODLOB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("CATIPGIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("CATIPCON"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("CAPV_COD"),"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
              }
              /* oNumErr := oNumErr + 1 */
              oNumErr = CPLib.Round(oNumErr+1,0);
              // * --- Delete from cgo_telematico
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cgo_telematico");
              m_cPhName = m_Ctx.GetPhName("cgo_telematico");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_telematico",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000190")+"delete from "+m_oWrInfo.GetTableWriteName();
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"SNAINUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_telematico.GetString("SNAINUMOPE"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_telematico.GetString("SNAINUMOPE"))+"";
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
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_anadip",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000191")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"CODDIP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_anadip.GetString("CODDIP"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_anadip.GetString("CODDIP"))+"";
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
          /* _conta := _conta + 1 */
          _conta = CPLib.Round(_conta+1,0);
          Cursor_cgo_anadip.Next();
        }
        m_cConnectivityError = Cursor_cgo_anadip.ErrorMessage();
        Cursor_cgo_anadip.Close();
        // * --- End Select
        /* _gMsgProc := 'Dipendenze Inserite: '+LRTrim(Str(dNumNew,10,0)) + ' - Dipendenze Aggiornate: '+LRTrim(Str(dNumMod,10,0)) + NL */
        _gMsgProc = "Dipendenze Inserite: "+CPLib.LRTrim(CPLib.Str(dNumNew,10,0))+" - Dipendenze Aggiornate: "+CPLib.LRTrim(CPLib.Str(dNumMod,10,0))+"\n";
        /* Exec Routine arrt_writelog('IMPORT DATI','ANADIP','Inseriti / Aggiornati '+LRTrim(Str(dNumNew+dNumMod,10,0)),_gMsgProc,"S") */
        arrt_writelogR.Make(m_Ctx,this).Run("IMPORT DATI","ANADIP","Inseriti / Aggiornati "+CPLib.LRTrim(CPLib.Str(dNumNew+dNumMod,10,0)),_gMsgProc,"S");
        /* If oNumErr > 0 */
        if (CPLib.gt(oNumErr,0)) {
          /* _gMsgProc := 'Dipendenze Scartate: '+LRTrim(Str(dNumErr,10,0)) + NL */
          _gMsgProc = "Dipendenze Scartate: "+CPLib.LRTrim(CPLib.Str(dNumErr,10,0))+"\n";
          /* Exec Routine arrt_writelog('IMPORT DATI','ANADIP','Scartati '+LRTrim(Str(dNumErr,10,0)),_gMsgProc,"S") */
          arrt_writelogR.Make(m_Ctx,this).Run("IMPORT DATI","ANADIP","Scartati "+CPLib.LRTrim(CPLib.Str(dNumErr,10,0)),_gMsgProc,"S");
        } // End If
      } else { // Else
        /* _gMsgProc := "Nessuna Dipendenza Inserita, Aggiornata o Scartata" */
        _gMsgProc = "Nessuna Dipendenza Inserita, Aggiornata o Scartata";
        /* Exec Routine arrt_writelog('IMPORT DATI','ANADIP','NO RECORDS',_gMsgProc,"S") */
        arrt_writelogR.Make(m_Ctx,this).Run("IMPORT DATI","ANADIP","NO RECORDS",_gMsgProc,"S");
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
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_operazbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_cgo_rapporti=null;
    CPResultSet Cursor_cgo_telematico=null;
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
          /* If _snaistor='N' */
          if (CPLib.eqr(_snaistor,"N")) {
            /* rowSoggetti.CONNES := cgo_soggetti->CONNES */
            rowSoggetti.CONNES = Cursor_cgo_soggetti.GetString("CONNES");
            /* rowSoggetti.COGNOME := cgo_soggetti->COGNOME */
            rowSoggetti.COGNOME = Cursor_cgo_soggetti.GetString("COGNOME");
            /* rowSoggetti.NOME := cgo_soggetti->NOME */
            rowSoggetti.NOME = Cursor_cgo_soggetti.GetString("NOME");
            /* rowSoggetti.DOMICILIO := cgo_soggetti->DOMICILIO */
            rowSoggetti.DOMICILIO = Cursor_cgo_soggetti.GetString("DOMICILIO");
            /* rowSoggetti.DESCCIT := cgo_soggetti->DESCCIT */
            rowSoggetti.DESCCIT = Cursor_cgo_soggetti.GetString("DESCCIT");
            /* rowSoggetti.PROVINCIA := cgo_soggetti->PROVINCIA */
            rowSoggetti.PROVINCIA = Cursor_cgo_soggetti.GetString("PROVINCIA");
            /* rowSoggetti.PAESE := cgo_soggetti->PAESE */
            rowSoggetti.PAESE = Cursor_cgo_soggetti.GetString("PAESE");
            /* rowSoggetti.CAP := cgo_soggetti->CAP */
            rowSoggetti.CAP = Cursor_cgo_soggetti.GetString("CAP");
            /* rowSoggetti.DATANASC := cgo_soggetti->DATANASC */
            rowSoggetti.DATANASC = Cursor_cgo_soggetti.GetDate("DATANASC");
            /* rowSoggetti.NASCOMUN := cgo_soggetti->NASCOMUN */
            rowSoggetti.NASCOMUN = Cursor_cgo_soggetti.GetString("NASCOMUN");
            /* rowSoggetti.NASSTATO := cgo_soggetti->NASSTATO */
            rowSoggetti.NASSTATO = Cursor_cgo_soggetti.GetString("NASSTATO");
            /* rowSoggetti.NASPROV := cgo_soggetti->NASPROV */
            rowSoggetti.NASPROV = Cursor_cgo_soggetti.GetString("NASPROV");
            /* rowSoggetti.SESSO := cgo_soggetti->SESSO */
            rowSoggetti.SESSO = Cursor_cgo_soggetti.GetString("SESSO");
            /* rowSoggetti.TIPODOC := cgo_soggetti->TIPODOC */
            rowSoggetti.TIPODOC = Cursor_cgo_soggetti.GetString("TIPODOC");
            /* rowSoggetti.NUMDOCUM := cgo_soggetti->NUMDOCUM */
            rowSoggetti.NUMDOCUM = Cursor_cgo_soggetti.GetString("NUMDOCUM");
            /* rowSoggetti.DATARILASC := cgo_soggetti->DATARILASC */
            rowSoggetti.DATARILASC = Cursor_cgo_soggetti.GetDate("DATARILASC");
            /* rowSoggetti.DATAVALI := cgo_soggetti->DATAVALI */
            rowSoggetti.DATAVALI = Cursor_cgo_soggetti.GetDate("DATAVALI");
            /* rowSoggetti.AUTRILASC := cgo_soggetti->AUTRILASC */
            rowSoggetti.AUTRILASC = Cursor_cgo_soggetti.GetString("AUTRILASC");
            /* rowSoggetti.CFESTERO := cgo_soggetti->CFESTERO */
            rowSoggetti.CFESTERO = Cursor_cgo_soggetti.GetDouble("CFESTERO");
            /* rowSoggetti.PEP := cgo_soggetti->PEP */
            rowSoggetti.PEP = Cursor_cgo_soggetti.GetString("PEP");
            /* rowSoggetti.FLGLIGHT := cgo_soggetti->FLGLIGHT */
            rowSoggetti.FLGLIGHT = Cursor_cgo_soggetti.GetString("FLGLIGHT");
            /* Exec "Controllo Soggetti" Page 7:Page_7 */
            Page_7();
          } // End If
          /* If _recOK=0 */
          if (CPLib.eqr(_recOK,0)) {
            /* cSetSin := '' */
            cSetSin = "";
            /* xFLGSAE := '' */
            xFLGSAE = "";
            /* If mcTBSTATI.HasKey(cgo_soggetti->PAESE) */
            if (mcTBSTATI.HasKey(Cursor_cgo_soggetti.GetString("PAESE"))) {
              /* If mcTBSTATI.GoToKey(cgo_soggetti->PAESE) */
              if (mcTBSTATI.GoToKey(Cursor_cgo_soggetti.GetString("PAESE"))) {
                /* xFLGSAE := mcTBSTATI.FLGSAE */
                xFLGSAE = mcTBSTATI.row.FLGSAE;
              } // End If
            } // End If
            /* _datnas := cgo_soggetti->DATANASC */
            _datnas = Cursor_cgo_soggetti.GetDate("DATANASC");
            /* _datemi := cgo_soggetti->DATARILASC */
            _datemi = Cursor_cgo_soggetti.GetDate("DATARILASC");
            /* _datval := cgo_soggetti->DATAVALI */
            _datval = Cursor_cgo_soggetti.GetDate("DATAVALI");
            /* xRagSoc := LRTrim(cgo_soggetti->COGNOME)+" "+ LRTrim(cgo_soggetti->NOME) */
            xRagSoc = CPLib.LRTrim(Cursor_cgo_soggetti.GetString("COGNOME"))+" "+CPLib.LRTrim(Cursor_cgo_soggetti.GetString("NOME"));
            /* xNome := cgo_soggetti->NOME */
            xNome = Cursor_cgo_soggetti.GetString("NOME");
            /* xCognome := cgo_soggetti->COGNOME */
            xCognome = Cursor_cgo_soggetti.GetString("COGNOME");
            /* cCli1 := cgo_soggetti->CONNES */
            cCli1 = Cursor_cgo_soggetti.GetString("CONNES");
            /* xCF := cgo_soggetti->CONNES */
            xCF = Cursor_cgo_soggetti.GetString("CONNES");
            /* xCFE := cgo_soggetti->CFESTERO */
            xCFE = CPLib.Round(Cursor_cgo_soggetti.GetDouble("CFESTERO"),0);
            /* If Empty(LRTrim(xCodCab)) */
            if (CPLib.Empty(CPLib.LRTrim(xCodCab))) {
              /* xCitta := LRTrim(Upper(cgo_soggetti->DESCCIT)) */
              xCitta = CPLib.LRTrim(CPLib.Upper(Cursor_cgo_soggetti.GetString("DESCCIT")));
              /* If mcTBCITTA.HasKey(xCitta+cgo_soggetti->PROVINCIA) */
              if (mcTBCITTA.HasKey(xCitta+Cursor_cgo_soggetti.GetString("PROVINCIA"))) {
                /* If mcTBCITTA.GoToKey(xCitta+cgo_soggetti->PROVINCIA) */
                if (mcTBCITTA.GoToKey(xCitta+Cursor_cgo_soggetti.GetString("PROVINCIA"))) {
                  /* xCodCab := mcTBCITTA.CAB */
                  xCodCab = mcTBCITTA.row.CAB;
                } // End If
              } // End If
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
                /* If mcTBSTATI_D.HasKey(Upper(LRTrim(cgo_soggetti->NASSTATO))) */
                if (mcTBSTATI_D.HasKey(CPLib.Upper(CPLib.LRTrim(Cursor_cgo_soggetti.GetString("NASSTATO"))))) {
                  /* If mcTBSTATI_D.GoToKey(Upper(LRTrim(cgo_soggetti->NASSTATO))) */
                  if (mcTBSTATI_D.GoToKey(CPLib.Upper(CPLib.LRTrim(Cursor_cgo_soggetti.GetString("NASSTATO"))))) {
                    /* cSNAS := LRTrim(mcTBSTATI_D.DESCRI) */
                    cSNAS = CPLib.LRTrim(mcTBSTATI_D.row.DESCRI);
                  } // End If
                } // End If
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
                /* If mcTBCITTA.HasKey(LRTrim(Upper(cgo_soggetti->NASCOMUN))+cgo_soggetti->NASPROV) */
                if (mcTBCITTA.HasKey(CPLib.LRTrim(CPLib.Upper(Cursor_cgo_soggetti.GetString("NASCOMUN")))+Cursor_cgo_soggetti.GetString("NASPROV"))) {
                  /* If mcTBCITTA.GoToKey(LRTrim(Upper(cgo_soggetti->NASCOMUN))+cgo_soggetti->NASPROV) */
                  if (mcTBCITTA.GoToKey(CPLib.LRTrim(CPLib.Upper(Cursor_cgo_soggetti.GetString("NASCOMUN")))+Cursor_cgo_soggetti.GetString("NASPROV"))) {
                    /* cCNAS := LRTrim(mcTBCITTA.CITTA) */
                    cCNAS = CPLib.LRTrim(mcTBCITTA.row.CITTA);
                    /* cPNAS := mcTBCITTA.PROV */
                    cPNAS = mcTBCITTA.row.PROV;
                  } // End If
                } // End If
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
            /* If cgo_soggetti->CFESTERO=0 */
            if (CPLib.eqr(Cursor_cgo_soggetti.GetDouble("CFESTERO"),0)) {
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
            /* xRiga1 := xRiga1 +LibreriaMit.SpacePad(cgo_soggetti->TIPODOC,2) */
            xRiga1 = xRiga1+LibreriaMit.SpacePad(Cursor_cgo_soggetti.GetString("TIPODOC"),2);
            /* xRiga1 := xRiga1 +LibreriaMit.SpacePad(cgo_soggetti->NUMDOCUM,15) */
            xRiga1 = xRiga1+LibreriaMit.SpacePad(Cursor_cgo_soggetti.GetString("NUMDOCUM"),15);
            /* xRiga1 := xRiga1 + iif(DateToChar(_datemi) <> '01000101',LibreriaMit.SpacePad(DateToChar(_datemi),8),Space(8)) */
            xRiga1 = xRiga1+(CPLib.ne(CPLib.DateToChar(_datemi),"01000101")?LibreriaMit.SpacePad(CPLib.DateToChar(_datemi),8):CPLib.Space(8));
            /* xRiga1 := xRiga1 +LibreriaMit.SpacePad(cgo_soggetti->AUTRILASC,30) */
            xRiga1 = xRiga1+LibreriaMit.SpacePad(Cursor_cgo_soggetti.GetString("AUTRILASC"),30);
            /* xRiga3 := iif(DateToChar(_datval) <> '01000101',LibreriaMit.SpacePad(DateToChar(_datval),8),Space(8)) */
            xRiga3 = (CPLib.ne(CPLib.DateToChar(_datval),"01000101")?LibreriaMit.SpacePad(CPLib.DateToChar(_datval),8):CPLib.Space(8));
            /* xRiga3 := xRiga3 +LibreriaMit.SpacePad(Str(cgo_soggetti->CFESTERO,1,0),30) */
            xRiga3 = xRiga3+LibreriaMit.SpacePad(CPLib.Str(Cursor_cgo_soggetti.GetDouble("CFESTERO"),1,0),30);
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
              /* xRiga4 := iif(DateToChar(personbo->DATAVALI) <> '01000101',LibreriaMit.SpacePad(DateToChar(personbo->DATAVALI),8),Space(8)) */
              xRiga4 = (CPLib.ne(CPLib.DateToChar(Cursor_personbo.GetDate("DATAVALI")),"01000101")?LibreriaMit.SpacePad(CPLib.DateToChar(Cursor_personbo.GetDate("DATAVALI")),8):CPLib.Space(8));
              /* xRiga4 := xRiga4 +LibreriaMit.SpacePad(Str(personbo->CFESTERO,1,0),30) */
              xRiga4 = xRiga4+LibreriaMit.SpacePad(CPLib.Str(Cursor_personbo.GetDouble("CFESTERO"),1,0),30);
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
              /* If Upper(LRTrim(xRiga1)+LRTrim(xRiga3)) <> Upper(LRTrim(xRiga2)+LRTrim(xRiga4)) */
              if (CPLib.ne(CPLib.Upper(CPLib.LRTrim(xRiga1)+CPLib.LRTrim(xRiga3)),CPLib.Upper(CPLib.LRTrim(xRiga2)+CPLib.LRTrim(xRiga4)))) {
                /* _intest := 0 */
                _intest = CPLib.Round(0,0);
                /* _stoper := 0 */
                _stoper = CPLib.Round(0,0);
                // * --- Select from intestbo
                m_cServer = m_Ctx.GetServer("intestbo");
                m_cPhName = m_Ctx.GetPhName("intestbo");
                if (Cursor_intestbo!=null)
                  Cursor_intestbo.Close();
                Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select RAPPORTO,DATAFINE,DATAINI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(cCli1,"?",0,0,m_cServer, m_oParameters),m_cServer,cCli1)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_intestbo.Eof())) {
                  /* If Empty(intestbo->DATAFINE) */
                  if (CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE"))) {
                    /* _intest := _intest + 1 */
                    _intest = CPLib.Round(_intest+1,0);
                  } // End If
                  Cursor_intestbo.Next();
                }
                m_cConnectivityError = Cursor_intestbo.ErrorMessage();
                Cursor_intestbo.Close();
                // * --- End Select
                /* If _intest=0 */
                if (CPLib.eqr(_intest,0)) {
                  // * --- Select from operazbo
                  m_cServer = m_Ctx.GetServer("operazbo");
                  m_cPhName = m_Ctx.GetPhName("operazbo");
                  if (Cursor_operazbo!=null)
                    Cursor_operazbo.Close();
                  Cursor_operazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(cCli1,"?",0,0,m_cServer, m_oParameters),m_cServer,cCli1)+" "+")"+(m_Ctx.IsSharedTemp("operazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_operazbo.Eof())) {
                    /* _stoper := 1 */
                    _stoper = CPLib.Round(1,0);
                    Cursor_operazbo.Next();
                  }
                  m_cConnectivityError = Cursor_operazbo.ErrorMessage();
                  Cursor_operazbo.Close();
                  // * --- End Select
                } else { // Else
                  /* _stoper := 1 */
                  _stoper = CPLib.Round(1,0);
                } // End If
                /* If _stoper=1 */
                if (CPLib.eqr(_stoper,1)) {
                  /* _oldmodi := '' */
                  _oldmodi = "";
                  // * --- Read from wersonbo
                  m_cServer = m_Ctx.GetServer("wersonbo");
                  m_cPhName = m_Ctx.GetPhName("wersonbo");
                  m_cSql = "";
                  m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(cCli1,"C",16,0,m_cServer),m_cServer,cCli1);
                  m_cSql = m_cSql+" and datamodi="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Date(),"D",8,0,m_cServer),m_cServer,CPLib.Date());
                  if (m_Ctx.IsSharedTemp("wersonbo")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("sanumpro",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _oldmodi = Read_Cursor.GetString("sanumpro");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on wersonbo into routine arrt_imp_dati_cgo_sched_tabs returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _oldmodi = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* _allcn := 0 */
                  _allcn = CPLib.Round(0,0);
                  /* If Empty(LRTrim(_oldmodi)) */
                  if (CPLib.Empty(CPLib.LRTrim(_oldmodi))) {
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
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000240")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_00000240(m_Ctx,m_oWrInfo);
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
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
                        /* _gMsgProc := _gMsgProc +"Rilevati errori nel file per il soggetto: "+LRTrim(xRagSoc)+" con codice: "+LRTrim(cgo_soggetti->CONNES)+". Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
                        _gMsgProc = _gMsgProc+"Rilevati errori nel file per il soggetto: "+CPLib.LRTrim(xRagSoc)+" con codice: "+CPLib.LRTrim(Cursor_cgo_soggetti.GetString("CONNES"))+". Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
                  } // End If
                } // End If
                /* If Upper(LRTrim(xRiga1)) <> Upper(LRTrim(xRiga2)) */
                if (CPLib.ne(CPLib.Upper(CPLib.LRTrim(xRiga1)),CPLib.Upper(CPLib.LRTrim(xRiga2)))) {
                  // * --- Select from intestbo
                  m_cServer = m_Ctx.GetServer("intestbo");
                  m_cPhName = m_Ctx.GetPhName("intestbo");
                  if (Cursor_intestbo!=null)
                    Cursor_intestbo.Close();
                  Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select RAPPORTO,DATAFINE,DATAINI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(cCli1,"?",0,0,m_cServer, m_oParameters),m_cServer,cCli1)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_intestbo.Eof())) {
                    /* If Empty(intestbo->DATAFINE) */
                    if (CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE"))) {
                      /* cInfProg1 := Utilities.GetAutonumber("PRGINFO1\'"+LRTrim(_gAzienda)+"'",'',10) */
                      cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO1\\'"+CPLib.LRTrim(_gAzienda)+"'","",10);
                      /* cInfProg2 := Utilities.GetAutonumber("PRGINFO2\'"+LRTrim(_gAzienda)+"'",'',11) */
                      cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO2\\'"+CPLib.LRTrim(_gAzienda)+"'","",11);
                      /* nProgImp := Utilities.GetAutonumber("PRGIMPINF\'"+LRTrim(_gAzienda)+"'",0,15) */
                      nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINF\\'"+CPLib.LRTrim(_gAzienda)+"'",0,15),0);
                      /* cColleg := 'I'+cInfProg2 */
                      cColleg = "I"+cInfProg2;
                      // * --- Insert into rapopebo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("rapopebo");
                      m_cPhName = m_Ctx.GetPhName("rapopebo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"0000024B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_0000024B(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_cabinter,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
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
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(cColleg,"?",0,0,m_cServer)+", ";
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
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"0000024F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_0000024F(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_cabinter,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
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
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(cColleg,"?",0,0,m_cServer)+", ";
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
                // * --- Write into personbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000250")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_nUpdatedRows = 0;
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.lt(m_nUpdatedRows,1)) {
                  // No rows updated
                  /* _gMsgProc := _gMsgProc +"Rilevati errori nel file per il soggetto: "+LRTrim(xRagSoc)+" con codice: "+LRTrim(cgo_soggetti->CONNES)+". Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
                  _gMsgProc = _gMsgProc+"Rilevati errori nel file per il soggetto: "+CPLib.LRTrim(xRagSoc)+" con codice: "+CPLib.LRTrim(Cursor_cgo_soggetti.GetString("CONNES"))+". Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
                /* sNumMod := sNumMod + 1 */
                sNumMod = CPLib.Round(sNumMod+1,0);
              } else { // Else
                /* sNumInv := sNumInv + 1 // Contatore record invariati */
                sNumInv = CPLib.Round(sNumInv+1,0);
              } // End If
            } else { // Else
              /* nProgImp := Utilities.GetAutonumber("PRGIMPOCLI\'"+LRTrim(_gAzienda)+"'",0,15) */
              nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOCLI\\'"+CPLib.LRTrim(_gAzienda)+"'",0,15),0);
              // * --- Insert into personbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000257")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000257(m_Ctx,m_oWrInfo);
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
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
                /* _gMsgProc := _gMsgProc +"Rilevati errori nel file per il soggetto: "+LRTrim(xRagSoc)+" con codice: "+LRTrim(cgo_soggetti->CONNES)+". Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
                _gMsgProc = _gMsgProc+"Rilevati errori nel file per il soggetto: "+CPLib.LRTrim(xRagSoc)+" con codice: "+CPLib.LRTrim(Cursor_cgo_soggetti.GetString("CONNES"))+". Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
          } else { // Else
            /* ProgErr := LibreriaMit.GeneraCodice(15,true,false,"") */
            ProgErr = LibreriaMit.GeneraCodice(15,true,false,"");
            // * --- Insert into cgo_soggetti_err from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cgo_soggetti_err");
            m_cPhName = m_Ctx.GetPhName("cgo_soggetti_err");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_soggetti_err",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"0000025D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000025D(m_Ctx,m_oWrInfo);
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
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
              /* ProgErr := LibreriaMit.GeneraCodice(15,true,false,"") */
              ProgErr = LibreriaMit.GeneraCodice(15,true,false,"");
              // * --- Insert into cgo_rapporti_err from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cgo_rapporti_err");
              m_cPhName = m_Ctx.GetPhName("cgo_rapporti_err");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_rapporti_err",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000261")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000261(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(ProgErr,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetString("DESCRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetString("TIPOMOV"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetString("CODINTEST"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Rapporto scartato per errori su intestatario","?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetDouble("CASTATOC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetDouble("CASTATOM"),"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_telematico_err",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000264")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000264(m_Ctx,m_oWrInfo);
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
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("MEZPAGAM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("TIPOGIOCO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CODLOB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("CATIPGIO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("CATIPCON"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("CAPV_COD"),"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
                }
                /* oNumErr := oNumErr + 1 */
                oNumErr = CPLib.Round(oNumErr+1,0);
                // * --- Delete from cgo_telematico
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("cgo_telematico");
                m_cPhName = m_Ctx.GetPhName("cgo_telematico");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_telematico",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000266")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"SNAINUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_telematico.GetString("SNAINUMOPE"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_telematico.GetString("SNAINUMOPE"))+"";
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
                Cursor_cgo_telematico.Next();
              }
              m_cConnectivityError = Cursor_cgo_telematico.ErrorMessage();
              Cursor_cgo_telematico.Close();
              // * --- End Select
              // * --- Delete from cgo_rapporti
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cgo_rapporti");
              m_cPhName = m_Ctx.GetPhName("cgo_rapporti");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_rapporti",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000267")+"delete from "+m_oWrInfo.GetTableWriteName();
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_rapporti.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_rapporti.GetString("RAPPORTO"))+"";
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
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_telematico_err",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"0000026A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000026A(m_Ctx,m_oWrInfo);
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
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("MEZPAGAM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("TIPOGIOCO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CODLOB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("CATIPGIO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("CATIPCON"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("CAPV_COD"),"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
                }
                /* oNumErr := oNumErr + 1 */
                oNumErr = CPLib.Round(oNumErr+1,0);
                // * --- Delete from cgo_telematico
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("cgo_telematico");
                m_cPhName = m_Ctx.GetPhName("cgo_telematico");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_telematico",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"0000026C")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"SNAINUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_telematico.GetString("SNAINUMOPE"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_telematico.GetString("SNAINUMOPE"))+"";
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
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_telematico_err",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"0000026F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000026F(m_Ctx,m_oWrInfo);
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
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("MEZPAGAM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("TIPOGIOCO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CODLOB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("CATIPGIO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("CATIPCON"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("CAPV_COD"),"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
                }
                /* oNumErr := oNumErr + 1 */
                oNumErr = CPLib.Round(oNumErr+1,0);
                // * --- Delete from cgo_telematico
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("cgo_telematico");
                m_cPhName = m_Ctx.GetPhName("cgo_telematico");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_telematico",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000271")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"SNAINUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_telematico.GetString("SNAINUMOPE"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_telematico.GetString("SNAINUMOPE"))+"";
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
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_soggetti",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000272")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_soggetti.GetString("CONNES"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_soggetti.GetString("CONNES"))+"";
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
          Cursor_cgo_soggetti.Next();
        }
        m_cConnectivityError = Cursor_cgo_soggetti.ErrorMessage();
        Cursor_cgo_soggetti.Close();
        // * --- End Select
        /* _gMsgProc := 'Soggetti Inseriti: '+LRTrim(Str(sNumNew,10,0)) + ' - Soggetti Aggiornati: '+LRTrim(Str(sNumMod,10,0)) + NL */
        _gMsgProc = "Soggetti Inseriti: "+CPLib.LRTrim(CPLib.Str(sNumNew,10,0))+" - Soggetti Aggiornati: "+CPLib.LRTrim(CPLib.Str(sNumMod,10,0))+"\n";
        /* Exec Routine arrt_writelog('IMPORT DATI','PERSONBO','Inseriti / Aggiornati '+LRTrim(Str(sNumNew+sNumMod,10,0)),_gMsgProc,"S") */
        arrt_writelogR.Make(m_Ctx,this).Run("IMPORT DATI","PERSONBO","Inseriti / Aggiornati "+CPLib.LRTrim(CPLib.Str(sNumNew+sNumMod,10,0)),_gMsgProc,"S");
        /* If sNumErr > 0 */
        if (CPLib.gt(sNumErr,0)) {
          /* _gMsgProc := 'Soggetti Scartati: '+LRTrim(Str(sNumErr,10,0)) + NL */
          _gMsgProc = "Soggetti Scartati: "+CPLib.LRTrim(CPLib.Str(sNumErr,10,0))+"\n";
          /* Exec Routine arrt_writelog('IMPORT DATI','PERSONBO','Scartati '+LRTrim(Str(sNumErr,10,0)),_gMsgProc,"S") */
          arrt_writelogR.Make(m_Ctx,this).Run("IMPORT DATI","PERSONBO","Scartati "+CPLib.LRTrim(CPLib.Str(sNumErr,10,0)),_gMsgProc,"S");
        } // End If
      } else { // Else
        /* _gMsgProc := "Nessuna Soggetto Inserito, Aggiornato o Scartato" */
        _gMsgProc = "Nessuna Soggetto Inserito, Aggiornato o Scartato";
        /* Exec Routine arrt_writelog('IMPORT DATI','PERSONBO','NO RECORDS',_gMsgProc,"S") */
        arrt_writelogR.Make(m_Ctx,this).Run("IMPORT DATI","PERSONBO","NO RECORDS",_gMsgProc,"S");
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
      try {
        if (Cursor_operazbo!=null)
          Cursor_operazbo.Close();
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
        Cursor_cgo_rapporti = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("cgo_rapporti")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1")+" order by "+"STATORAP ",m_cServer,m_Ctx,true));
        while ( ! (Cursor_cgo_rapporti.Eof())) {
          /* _recOK := 0 */
          _recOK = CPLib.Round(0,0);
          /* _txterr := '' */
          _txterr = "";
          /* xRapporto := '' */
          xRapporto = "";
          /* If _snaistor='N' */
          if (CPLib.eqr(_snaistor,"N")) {
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
              /* If cgo_rapporti->TIPOMOV <> 'A' and cgo_rapporti->TIPOMOV <> 'C' and cgo_rapporti->TIPOMOV <> 'S' */
              if (CPLib.ne(Cursor_cgo_rapporti.GetString("TIPOMOV"),"A") && CPLib.ne(Cursor_cgo_rapporti.GetString("TIPOMOV"),"C") && CPLib.ne(Cursor_cgo_rapporti.GetString("TIPOMOV"),"S")) {
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
                  Error l_oErrorFault = new Error("Read on personbo into routine arrt_imp_dati_cgo_sched_tabs returns two or more records. This item should return only a record.");
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
            /* If not(Empty(LRTrim(cgo_rapporti->TIPOMOV))) and (cgo_rapporti->TIPOMOV = 'C' or cgo_rapporti->TIPOMOV = 'S') */
            if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_cgo_rapporti.GetString("TIPOMOV")))) && (CPLib.eqr(Cursor_cgo_rapporti.GetString("TIPOMOV"),"C") || CPLib.eqr(Cursor_cgo_rapporti.GetString("TIPOMOV"),"S"))) {
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
                  Error l_oErrorFault = new Error("Read on anarapbo into routine arrt_imp_dati_cgo_sched_tabs returns two or more records. This item should return only a record.");
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
                    Error l_oErrorFault = new Error("Read on xnarapbo into routine arrt_imp_dati_cgo_sched_tabs returns two or more records. This item should return only a record.");
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
                /* _txterr := _txterr + 'Operazione di chiusura/cambio stato per rapporto mai aperto' + NL */
                _txterr = _txterr+"Operazione di chiusura/cambio stato per rapporto mai aperto"+"\n";
                /* _recOK := 1 */
                _recOK = CPLib.Round(1,0);
              } // End If
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
                  Error l_oErrorFault = new Error("Read on anarapbo into routine arrt_imp_dati_cgo_sched_tabs returns two or more records. This item should return only a record.");
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
                    Error l_oErrorFault = new Error("Read on xnarapbo into routine arrt_imp_dati_cgo_sched_tabs returns two or more records. This item should return only a record.");
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
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xnarapbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000002AC")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000002AC(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetString("DESCRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull("0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("E","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull("242","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("22","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetDouble("CASTATOC"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetDouble("CASTATOM"),"?",0,0)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xapopebo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000002B0")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000002B0(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_cgo_rapporti.GetDate("DATAOPE")),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_cabinter,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetDate("DATAOPE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_snaistor,"N")?CPLib.Date():(CPLib.le(CPLib.DateToChar(Cursor_cgo_rapporti.GetDate("DATAOPE")),"20120531")?CPLib.CharToDate("20120601"):arfn_datesumR.Make(m_Ctx,this).Run(Cursor_cgo_rapporti.GetDate("DATAOPE"),1))),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
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
                  m_cSql = m_cSql+""+CPLib.ToSQLNull("23","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
                    /* _gMsgProc := _gMsgProc +"Rilevati errori nel file cgo_rapporti per l'informazione in data "+arfn_fdate(cgo_rapporti->DATAOPE)+" relativa al rapporto: "+LRTrim(cgo_rapporti->RAPPORTO)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
                    _gMsgProc = _gMsgProc+"Rilevati errori nel file cgo_rapporti per l'informazione in data "+arfn_fdateR.Make(m_Ctx,this).Run(Cursor_cgo_rapporti.GetDate("DATAOPE"))+" relativa al rapporto: "+CPLib.LRTrim(Cursor_cgo_rapporti.GetString("RAPPORTO"))+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
                  }
                  /* nProgImp2 := Utilities.GetAutonumber("PRGIMPSOG\'"+LRTrim(_gAzienda)+"'",0,15) */
                  nProgImp2 = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPSOG\\'"+CPLib.LRTrim(_gAzienda)+"'",0,15),0);
                  // * --- Insert into xntestbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("xntestbo");
                  m_cPhName = m_Ctx.GetPhName("xntestbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xntestbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000002B6")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000002B6(m_Ctx,m_oWrInfo);
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
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
                  }
                } else { // Else
                  // * --- Insert into anarapbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("anarapbo");
                  m_cPhName = m_Ctx.GetPhName("anarapbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anarapbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000002B7")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000002B7(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetString("DESCRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull("0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("E","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull("242","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("22","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetDouble("CASTATOC"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetDouble("CASTATOM"),"?",0,0)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000002BB")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000002BB(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_cgo_rapporti.GetDate("DATAOPE")),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_cabinter,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetDate("DATAOPE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_snaistor,"N")?CPLib.Date():(CPLib.le(CPLib.DateToChar(Cursor_cgo_rapporti.GetDate("DATAOPE")),"20120531")?CPLib.CharToDate("20120601"):arfn_datesumR.Make(m_Ctx,this).Run(Cursor_cgo_rapporti.GetDate("DATAOPE"),1))),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
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
                  m_cSql = m_cSql+""+CPLib.ToSQLNull("23","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_snaistor,"N")?CPLib.DateToChar(CPLib.Date()):(CPLib.le(CPLib.DateToChar(Cursor_cgo_rapporti.GetDate("DATAOPE")),"20120531")?"20120601":CPLib.DateToChar(arfn_datesumR.Make(m_Ctx,this).Run(Cursor_cgo_rapporti.GetDate("DATAOPE"),1)))),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
                    /* _gMsgProc := _gMsgProc +"Rilevati errori nel file cgo_rapporti per l'informazione in data "+arfn_fdate(cgo_rapporti->DATAOPE)+" relativa al rapporto: "+LRTrim(cgo_rapporti->RAPPORTO)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
                    _gMsgProc = _gMsgProc+"Rilevati errori nel file cgo_rapporti per l'informazione in data "+arfn_fdateR.Make(m_Ctx,this).Run(Cursor_cgo_rapporti.GetDate("DATAOPE"))+" relativa al rapporto: "+CPLib.LRTrim(Cursor_cgo_rapporti.GetString("RAPPORTO"))+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
                  }
                  /* nProgImp2 := Utilities.GetAutonumber("PRGIMPSOG\'"+LRTrim(_gAzienda)+"'",0,15) */
                  nProgImp2 = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPSOG\\'"+CPLib.LRTrim(_gAzienda)+"'",0,15),0);
                  // * --- Insert into intestbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("intestbo");
                  m_cPhName = m_Ctx.GetPhName("intestbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000002C1")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000002C1(m_Ctx,m_oWrInfo);
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
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
                  }
                } // End If
                // * --- Insert into knarapbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("knarapbo");
                m_cPhName = m_Ctx.GetPhName("knarapbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"knarapbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000002C2")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000002C2(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetString("DESCRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(w_tipodest,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
                  Error l_oErrorFault = new Error("Read on anarapbo into routine arrt_imp_dati_cgo_sched_tabs returns two or more records. This item should return only a record.");
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
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xapopebo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000002C9")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000002C9(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_cgo_rapporti.GetDate("DATAOPE")),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_cabinter,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetDate("DATAOPE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_snaistor,"N")?CPLib.Date():(CPLib.le(CPLib.DateToChar(Cursor_cgo_rapporti.GetDate("DATAOPE")),"20120531")?CPLib.CharToDate("20120601"):arfn_datesumR.Make(m_Ctx,this).Run(Cursor_cgo_rapporti.GetDate("DATAOPE"),1))),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
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
                m_cSql = m_cSql+""+CPLib.ToSQLNull("26","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
                  /* _gMsgProc := _gMsgProc +"Rilevati errori nel file cgo_rapporti per l'informazione in data "+arfn_fdate(cgo_rapporti->DATAOPE)+" relativa al rapporto: "+LRTrim(cgo_rapporti->RAPPORTO)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
                  _gMsgProc = _gMsgProc+"Rilevati errori nel file cgo_rapporti per l'informazione in data "+arfn_fdateR.Make(m_Ctx,this).Run(Cursor_cgo_rapporti.GetDate("DATAOPE"))+" relativa al rapporto: "+CPLib.LRTrim(Cursor_cgo_rapporti.GetString("RAPPORTO"))+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
                }
                // * --- Write into xntestbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("xntestbo");
                m_cPhName = m_Ctx.GetPhName("xntestbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xntestbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000002CE")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(Cursor_cgo_rapporti.GetDate("DATAOPE"),"D",8,0)+", ";
                m_cSql = m_cSql+"NUMPROG2 = "+CPLib.ToSQL(cInfProg2,"C",11,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xntestbo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_rapporti.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_rapporti.GetString("RAPPORTO"))+"";
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
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000002D2")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000002D2(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_cgo_rapporti.GetDate("DATAOPE")),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_cabinter,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetDate("DATAOPE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_snaistor,"N")?CPLib.Date():(CPLib.le(CPLib.DateToChar(Cursor_cgo_rapporti.GetDate("DATAOPE")),"20120531")?CPLib.CharToDate("20120601"):arfn_datesumR.Make(m_Ctx,this).Run(Cursor_cgo_rapporti.GetDate("DATAOPE"),1))),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
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
                m_cSql = m_cSql+""+CPLib.ToSQLNull("26","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_snaistor,"N")?CPLib.DateToChar(CPLib.Date()):(CPLib.le(CPLib.DateToChar(Cursor_cgo_rapporti.GetDate("DATAOPE")),"20120531")?"20120601":CPLib.DateToChar(arfn_datesumR.Make(m_Ctx,this).Run(Cursor_cgo_rapporti.GetDate("DATAOPE"),1)))),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
                  /* _gMsgProc := _gMsgProc +"Rilevati errori nel file cgo_rapporti per l'informazione in data "+arfn_fdate(cgo_rapporti->DATAOPE)+" relativa al rapporto: "+LRTrim(cgo_rapporti->RAPPORTO)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
                  _gMsgProc = _gMsgProc+"Rilevati errori nel file cgo_rapporti per l'informazione in data "+arfn_fdateR.Make(m_Ctx,this).Run(Cursor_cgo_rapporti.GetDate("DATAOPE"))+" relativa al rapporto: "+CPLib.LRTrim(Cursor_cgo_rapporti.GetString("RAPPORTO"))+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
                }
                // * --- Write into intestbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("intestbo");
                m_cPhName = m_Ctx.GetPhName("intestbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000002D7")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(Cursor_cgo_rapporti.GetDate("DATAOPE"),"D",8,0)+", ";
                m_cSql = m_cSql+"NUMPROG2 = "+CPLib.ToSQL(cInfProg2,"C",11,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_rapporti.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_rapporti.GetString("RAPPORTO"))+"";
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
                // * --- Write into anarapbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("anarapbo");
                m_cPhName = m_Ctx.GetPhName("anarapbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anarapbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000002D8")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"CASTATOC = "+CPLib.ToSQL(Cursor_cgo_rapporti.GetDouble("CASTATOC"),"N",3,0)+", ";
                m_cSql = m_cSql+"CASTATOM = "+CPLib.ToSQL(Cursor_cgo_rapporti.GetDouble("CASTATOM"),"N",3,0)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"anarapbo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_rapporti.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_rapporti.GetString("RAPPORTO"))+"";
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
              /* rNumMod := rNumMod + 1 */
              rNumMod = CPLib.Round(rNumMod+1,0);
              /* ElseIf cgo_rapporti->TIPOMOV='S' */
            } else if (CPLib.eqr(Cursor_cgo_rapporti.GetString("TIPOMOV"),"S")) {
              // * --- Write into anarapbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("anarapbo");
              m_cPhName = m_Ctx.GetPhName("anarapbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anarapbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000002DA")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"CASTATOC = "+CPLib.ToSQL(Cursor_cgo_rapporti.GetDouble("CASTATOC"),"N",3,0)+", ";
              m_cSql = m_cSql+"CASTATOM = "+CPLib.ToSQL(Cursor_cgo_rapporti.GetDouble("CASTATOM"),"N",3,0)+", ";
              m_cSql = m_cSql+"CADSTATO = "+CPLib.ToSQL(Cursor_cgo_rapporti.GetDate("DATAOPE"),"D",8,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"anarapbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_rapporti.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_rapporti.GetString("RAPPORTO"))+"";
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
          } else { // Else
            /* ProgErr := LibreriaMit.GeneraCodice(15,true,false,"") */
            ProgErr = LibreriaMit.GeneraCodice(15,true,false,"");
            // * --- Insert into cgo_rapporti_err from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cgo_rapporti_err");
            m_cPhName = m_Ctx.GetPhName("cgo_rapporti_err");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_rapporti_err",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000002DC")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000002DC(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(ProgErr,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetString("DESCRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetString("TIPOMOV"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetDate("DATAOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetString("CODINTEST"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_txterr,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetDouble("CASTATOC"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_rapporti.GetDouble("CASTATOM"),"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_telematico_err",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000002DF")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000002DF(m_Ctx,m_oWrInfo);
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
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("MEZPAGAM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("TIPOGIOCO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CODLOB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("CATIPGIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("CATIPCON"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("CAPV_COD"),"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
              }
              // * --- Delete from cgo_telematico
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cgo_telematico");
              m_cPhName = m_Ctx.GetPhName("cgo_telematico");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_telematico",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000002E0")+"delete from "+m_oWrInfo.GetTableWriteName();
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"SNAINUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_telematico.GetString("SNAINUMOPE"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_telematico.GetString("SNAINUMOPE"))+"";
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
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_rapporti",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000002E2")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_rapporti.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_rapporti.GetString("RAPPORTO"))+"";
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
          /* _conta := _conta + 1 */
          _conta = CPLib.Round(_conta+1,0);
          Cursor_cgo_rapporti.Next();
        }
        m_cConnectivityError = Cursor_cgo_rapporti.ErrorMessage();
        Cursor_cgo_rapporti.Close();
        // * --- End Select
        /* _gMsgProc := 'Rapporti Inseriti: '+LRTrim(Str(rNumNew,10,0)) + ' - Rapporti Aggiornati: '+LRTrim(Str(rNumMod,10,0)) + NL */
        _gMsgProc = "Rapporti Inseriti: "+CPLib.LRTrim(CPLib.Str(rNumNew,10,0))+" - Rapporti Aggiornati: "+CPLib.LRTrim(CPLib.Str(rNumMod,10,0))+"\n";
        /* Exec Routine arrt_writelog('IMPORT DATI','RAPOPEBO','Inseriti / Aggiornati '+LRTrim(Str((rNumNew+rNumMod),10,0)),_gMsgProc,"S") */
        arrt_writelogR.Make(m_Ctx,this).Run("IMPORT DATI","RAPOPEBO","Inseriti / Aggiornati "+CPLib.LRTrim(CPLib.Str((rNumNew+rNumMod),10,0)),_gMsgProc,"S");
        /* If rNumErr > 0 */
        if (CPLib.gt(rNumErr,0)) {
          /* _gMsgProc := 'Rapporti Scartati: '+LRTrim(Str(rNumErr,10,0))  + NL */
          _gMsgProc = "Rapporti Scartati: "+CPLib.LRTrim(CPLib.Str(rNumErr,10,0))+"\n";
          /* Exec Routine arrt_writelog('IMPORT DATI','RAPOPEBO','Scartati '+LRTrim(Str(rNumErr,10,0)),_gMsgProc,"S") */
          arrt_writelogR.Make(m_Ctx,this).Run("IMPORT DATI","RAPOPEBO","Scartati "+CPLib.LRTrim(CPLib.Str(rNumErr,10,0)),_gMsgProc,"S");
        } // End If
      } else { // Else
        /* _gMsgProc := "Nessun Rapporto Inserito, Aggiornato o Scartato" */
        _gMsgProc = "Nessun Rapporto Inserito, Aggiornato o Scartato";
        /* Exec Routine arrt_writelog('IMPORT DATI','RAPOPEBO','NO RECORDS',_gMsgProc,"S") */
        arrt_writelogR.Make(m_Ctx,this).Run("IMPORT DATI","RAPOPEBO","NO RECORDS",_gMsgProc,"S");
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
    CPResultSet Cursor_cgo_telematico=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_rapopebo=null;
    CPResultSet Cursor_xapopebo=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_xntestbo=null;
    CPResultSet Cursor_personbo=null;
    try {
      /* Import Operazioni */
      /* _totale := 0 */
      _totale = CPLib.Round(0,0);
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      /* _MsgAss := '' */
      _MsgAss = "";
      /* If _tottele > 0 */
      if (CPLib.gt(_tottele,0)) {
        // * --- Select from cgo_telematico
        m_cServer = m_Ctx.GetServer("cgo_telematico");
        m_cPhName = m_Ctx.GetPhName("cgo_telematico");
        if (Cursor_cgo_telematico!=null)
          Cursor_cgo_telematico.Close();
        Cursor_cgo_telematico = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("cgo_telematico")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_cgo_telematico.Eof())) {
          /* _recOK := 0 */
          _recOK = CPLib.Round(0,0);
          /* _txterr := '' */
          _txterr = "";
          /* _omulti := 'N' */
          _omulti = "N";
          /* _omultic := 'N' */
          _omultic = "N";
          /* If _snaistor='N' */
          if (CPLib.eqr(_snaistor,"N")) {
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
              /* _codcau := 0 */
              _codcau = CPLib.Round(0,0);
              /* If mcCAUSALI_C.HasKey(cgo_telematico->CACODICE) */
              if (mcCAUSALI_C.HasKey(Cursor_cgo_telematico.GetDouble("CACODICE"))) {
                /* If mcCAUSALI_C.GoToKey(cgo_telematico->CACODICE) */
                if (mcCAUSALI_C.GoToKey(Cursor_cgo_telematico.GetDouble("CACODICE"))) {
                  /* _codcau := cgo_telematico->CACODICE */
                  _codcau = CPLib.Round(Cursor_cgo_telematico.GetDouble("CACODICE"),0);
                } // End If
              } // End If
              /* If _codcau = 0 */
              if (CPLib.eqr(_codcau,0)) {
                /* _txterr := _txterr + "Causale non presente in archivio causali" + NL */
                _txterr = _txterr+"Causale non presente in archivio causali"+"\n";
                /* _recOK := 1 */
                _recOK = CPLib.Round(1,0);
              } else { // Else
                /* If not(Empty(LRTrim(cgo_telematico->MEZPAGAM))) */
                if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_cgo_telematico.GetString("MEZPAGAM"))))) {
                  /* If mcCAUSALI.HasKey(Str(cgo_telematico->CACODICE,5,0)+cgo_telematico->MEZPAGAM) */
                  if (mcCAUSALI.HasKey(CPLib.Str(Cursor_cgo_telematico.GetDouble("CACODICE"),5,0)+Cursor_cgo_telematico.GetString("MEZPAGAM"))) {
                    /* If mcCAUSALI.GoToKey(Str(cgo_telematico->CACODICE,5,0)+cgo_telematico->MEZPAGAM) */
                    if (mcCAUSALI.GoToKey(CPLib.Str(Cursor_cgo_telematico.GetDouble("CACODICE"),5,0)+Cursor_cgo_telematico.GetString("MEZPAGAM"))) {
                      /* _codcau := cgo_telematico->CACODICE */
                      _codcau = CPLib.Round(Cursor_cgo_telematico.GetDouble("CACODICE"),0);
                    } // End If
                  } // End If
                  /* If _codcau=0 */
                  if (CPLib.eqr(_codcau,0)) {
                    /* _txterr := _txterr + "Causale dell'operazione errata" + NL */
                    _txterr = _txterr+"Causale dell'operazione errata"+"\n";
                    /* _recOK := 1 */
                    _recOK = CPLib.Round(1,0);
                  } // End If
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
            /* If Empty(cgo_telematico->CODDIPE) and (cgo_telematico->ENV='A' or cgo_telematico->ENV='V') */
            if (CPLib.Empty(Cursor_cgo_telematico.GetString("CODDIPE")) && (CPLib.eqr(Cursor_cgo_telematico.GetString("ENV"),"A") || CPLib.eqr(Cursor_cgo_telematico.GetString("ENV"),"V"))) {
              /* _txterr := _txterr + "Manca il codice agenzia dell'operazione" + NL */
              _txterr = _txterr+"Manca il codice agenzia dell'operazione"+"\n";
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
              /* If cgo_telematico->DUCOLLEG = 0 */
              if (CPLib.eqr(Cursor_cgo_telematico.GetDouble("DUCOLLEG"),0)) {
                /* _txterr := _txterr + "Manca durata dell'operazione" + NL */
                _txterr = _txterr+"Manca durata dell'operazione"+"\n";
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
                    Error l_oErrorFault = new Error("Read on anarapbo into routine arrt_imp_dati_cgo_sched_tabs returns two or more records. This item should return only a record.");
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
                    /* If rapopebo->TIPOOPRAP='23' or rapopebo->TIPOOPRAP='45' or rapopebo->TIPOOPRAP='35' or rapopebo->TIPOOPRAP='37' */
                    if (CPLib.eqr(Cursor_rapopebo.GetString("TIPOOPRAP"),"23") || CPLib.eqr(Cursor_rapopebo.GetString("TIPOOPRAP"),"45") || CPLib.eqr(Cursor_rapopebo.GetString("TIPOOPRAP"),"35") || CPLib.eqr(Cursor_rapopebo.GetString("TIPOOPRAP"),"37")) {
                      /* _datini := rapopebo->DATAOPE */
                      _datini = Cursor_rapopebo.GetDate("DATAOPE");
                      /* ElseIf rapopebo->TIPOOPRAP='26' or rapopebo->TIPOOPRAP='46' or rapopebo->TIPOOPRAP='36' or rapopebo->TIPOOPRAP='38' */
                    } else if (CPLib.eqr(Cursor_rapopebo.GetString("TIPOOPRAP"),"26") || CPLib.eqr(Cursor_rapopebo.GetString("TIPOOPRAP"),"46") || CPLib.eqr(Cursor_rapopebo.GetString("TIPOOPRAP"),"36") || CPLib.eqr(Cursor_rapopebo.GetString("TIPOOPRAP"),"38")) {
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
                      Error l_oErrorFault = new Error("Read on xnarapbo into routine arrt_imp_dati_cgo_sched_tabs returns two or more records. This item should return only a record.");
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
                      /* If xapopebo->TIPOOPRAP='23' or xapopebo->TIPOOPRAP='45' or xapopebo->TIPOOPRAP='35' or xapopebo->TIPOOPRAP='37' */
                      if (CPLib.eqr(Cursor_xapopebo.GetString("TIPOOPRAP"),"23") || CPLib.eqr(Cursor_xapopebo.GetString("TIPOOPRAP"),"45") || CPLib.eqr(Cursor_xapopebo.GetString("TIPOOPRAP"),"35") || CPLib.eqr(Cursor_xapopebo.GetString("TIPOOPRAP"),"37")) {
                        /* _datini := xapopebo->DATAOPE */
                        _datini = Cursor_xapopebo.GetDate("DATAOPE");
                        /* ElseIf xapopebo->TIPOOPRAP='26' or xapopebo->TIPOOPRAP='46' or xapopebo->TIPOOPRAP='36' or xapopebo->TIPOOPRAP='38' */
                      } else if (CPLib.eqr(Cursor_xapopebo.GetString("TIPOOPRAP"),"26") || CPLib.eqr(Cursor_xapopebo.GetString("TIPOOPRAP"),"46") || CPLib.eqr(Cursor_xapopebo.GetString("TIPOOPRAP"),"36") || CPLib.eqr(Cursor_xapopebo.GetString("TIPOOPRAP"),"38")) {
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
                        /* _txterr := _txterr + "Impossibile inserire un'operazione prima della data di rilascio del documento del soggetto intestatario del rapporto" + NL */
                        _txterr = _txterr+"Impossibile inserire un'operazione prima della data di rilascio del documento del soggetto intestatario del rapporto"+"\n";
                        /* _recOK := 1 */
                        _recOK = CPLib.Round(1,0);
                      } // End If
                      /* If _flgnodoc='S' */
                      if (CPLib.eqr(_flgnodoc,"S")) {
                        /* If not(Empty(_datend)) and _datope > _datend */
                        if ( ! (CPLib.Empty(_datend)) && CPLib.gt(_datope,_datend)) {
                          /* _txterr := _txterr + "Impossibile inserire un'operazione dopo la data di scadenza del documento del soggetto intestatario del rapporto" + NL */
                          _txterr = _txterr+"Impossibile inserire un'operazione dopo la data di scadenza del documento del soggetto intestatario del rapporto"+"\n";
                          /* _recOK := 1 */
                          _recOK = CPLib.Round(1,0);
                        } // End If
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
          } // End If
          /* If _recOK=0 */
          if (CPLib.eqr(_recOK,0)) {
            /* rowTele.SNAINUMOPE := cgo_telematico->SNAINUMOPE */
            rowTele.SNAINUMOPE = Cursor_cgo_telematico.GetString("SNAINUMOPE");
            /* rowTele.ENV := cgo_telematico->ENV */
            rowTele.ENV = Cursor_cgo_telematico.GetString("ENV");
            /* rowTele.CODDIPE := cgo_telematico->CODDIPE */
            rowTele.CODDIPE = Cursor_cgo_telematico.GetString("CODDIPE");
            /* rowTele.RAPPORTO := cgo_telematico->RAPPORTO */
            rowTele.RAPPORTO = Cursor_cgo_telematico.GetString("RAPPORTO");
            /* rowTele.TOTLIRE := cgo_telematico->TOTLIRE */
            rowTele.TOTLIRE = Cursor_cgo_telematico.GetDouble("TOTLIRE");
            /* rowTele.CACODICE := cgo_telematico->CACODICE */
            rowTele.CACODICE = Cursor_cgo_telematico.GetDouble("CACODICE");
            /* rowTele.CADATAORA := cgo_telematico->CADATAORA */
            rowTele.CADATAORA = Cursor_cgo_telematico.GetDateTime("CADATAORA");
            /* rowTele.CAIDBIGLIETTO := cgo_telematico->CAIDBIGLIETTO */
            rowTele.CAIDBIGLIETTO = Cursor_cgo_telematico.GetString("CAIDBIGLIETTO");
            /* rowTele.CSMF_COD := cgo_telematico->CSMF_COD */
            rowTele.CSMF_COD = Cursor_cgo_telematico.GetDouble("CSMF_COD");
            /* rowTele.NUM_CONC := cgo_telematico->NUM_CONC */
            rowTele.NUM_CONC = Cursor_cgo_telematico.GetDouble("NUM_CONC");
            /* rowTele.P_VEND := cgo_telematico->P_VEND */
            rowTele.P_VEND = Cursor_cgo_telematico.GetDouble("P_VEND");
            /* rowTele.IPCOLLEG := cgo_telematico->IPCOLLEG */
            rowTele.IPCOLLEG = Cursor_cgo_telematico.GetString("IPCOLLEG");
            /* rowTele.ORACOLLEG := cgo_telematico->ORACOLLEG */
            rowTele.ORACOLLEG = Cursor_cgo_telematico.GetDateTime("ORACOLLEG");
            /* rowTele.DUCOLLEG := cgo_telematico->DUCOLLEG */
            rowTele.DUCOLLEG = Cursor_cgo_telematico.GetDouble("DUCOLLEG");
            /* rowTele.IBAN := cgo_telematico->IBAN */
            rowTele.IBAN = Cursor_cgo_telematico.GetString("IBAN");
            /* rowTele.MEZPAGAM := cgo_telematico->MEZPAGAM */
            rowTele.MEZPAGAM = Cursor_cgo_telematico.GetString("MEZPAGAM");
            /* rowTele.TIPOGIOCO := cgo_telematico->TIPOGIOCO */
            rowTele.TIPOGIOCO = Cursor_cgo_telematico.GetString("TIPOGIOCO");
            /* rowTele.CODLOB := cgo_telematico->CODLOB */
            rowTele.CODLOB = Cursor_cgo_telematico.GetString("CODLOB");
            /* rowTele.CATIPGIO := cgo_telematico->CATIPGIO */
            rowTele.CATIPGIO = Cursor_cgo_telematico.GetDouble("CATIPGIO");
            /* rowTele.CATIPCON := cgo_telematico->CATIPCON */
            rowTele.CATIPCON = Cursor_cgo_telematico.GetDouble("CATIPCON");
            /* rowTele.CAPV_COD := cgo_telematico->CAPV_COD */
            rowTele.CAPV_COD = Cursor_cgo_telematico.GetDouble("CAPV_COD");
            /* rowTele.VPCODICE := cgo_telematico->VPCODICE */
            rowTele.VPCODICE = Cursor_cgo_telematico.GetString("VPCODICE");
            /* If _snaistor='S' */
            if (CPLib.eqr(_snaistor,"S")) {
              /* Exec "Scrittura Operazioni (Stor)" Page 10:Page_10 */
              Page_10();
            } else { // Else
              /* Exec "Scrittura Operazioni (Std)" Page 8:Page_8 */
              Page_8();
            } // End If
          } else { // Else
            // * --- Insert into cgo_telematico_err from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cgo_telematico_err");
            m_cPhName = m_Ctx.GetPhName("cgo_telematico_err");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_telematico_err",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000388")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000388(m_Ctx,m_oWrInfo);
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
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("MEZPAGAM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("TIPOGIOCO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CODLOB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("CATIPGIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("CATIPCON"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("CAPV_COD"),"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
            }
            /* oNumErr := oNumErr + 1 */
            oNumErr = CPLib.Round(oNumErr+1,0);
          } // End If
          /* If cgo_telematico->ENV='M' */
          if (CPLib.eqr(Cursor_cgo_telematico.GetString("ENV"),"M")) {
            // * --- Delete from cgo_telematico_multipla
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cgo_telematico_multipla");
            m_cPhName = m_Ctx.GetPhName("cgo_telematico_multipla");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_telematico_multipla",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"0000038B")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"SNAINUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_telematico.GetString("SNAINUMOPE"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_telematico.GetString("SNAINUMOPE"))+"";
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
          // * --- Delete from cgo_telematico
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cgo_telematico");
          m_cPhName = m_Ctx.GetPhName("cgo_telematico");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_telematico",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"0000038C")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"SNAINUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_telematico.GetString("SNAINUMOPE"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_telematico.GetString("SNAINUMOPE"))+"";
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
          Cursor_cgo_telematico.Next();
        }
        m_cConnectivityError = Cursor_cgo_telematico.ErrorMessage();
        Cursor_cgo_telematico.Close();
        // * --- End Select
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
        /* _gMsgProc := 'Operazioni Inserite: '+LRTrim(Str(oNumero,10,0)) + ' - Frazionate Inserite: '+LRTrim(Str(fNumero,10,0)) + ' - Match Multiple: '+LRTrim(Str(mNumero,10,0)) + NL+LRTrim(_MsgAss)+NL */
        _gMsgProc = "Operazioni Inserite: "+CPLib.LRTrim(CPLib.Str(oNumero,10,0))+" - Frazionate Inserite: "+CPLib.LRTrim(CPLib.Str(fNumero,10,0))+" - Match Multiple: "+CPLib.LRTrim(CPLib.Str(mNumero,10,0))+"\n"+CPLib.LRTrim(_MsgAss)+"\n";
        /* Exec Routine arrt_writelog('IMPORT DATI','OPERAZIONI','Inseriti / Aggiornati '+LRTrim(Str(oNumero+fNumero,10,0)),_gMsgProc,"S") */
        arrt_writelogR.Make(m_Ctx,this).Run("IMPORT DATI","OPERAZIONI","Inseriti / Aggiornati "+CPLib.LRTrim(CPLib.Str(oNumero+fNumero,10,0)),_gMsgProc,"S");
        /* If oNumErr > 0 */
        if (CPLib.gt(oNumErr,0)) {
          /* _gMsgProc := 'Movimenti Scartati: '+LRTrim(Str(oNumErr,10,0)) + NL */
          _gMsgProc = "Movimenti Scartati: "+CPLib.LRTrim(CPLib.Str(oNumErr,10,0))+"\n";
          /* Exec Routine arrt_writelog('IMPORT DATI','OPERAZIONI','Scartati '+LRTrim(Str(oNumErr,10,0)),_gMsgProc,"S") */
          arrt_writelogR.Make(m_Ctx,this).Run("IMPORT DATI","OPERAZIONI","Scartati "+CPLib.LRTrim(CPLib.Str(oNumErr,10,0)),_gMsgProc,"S");
        } // End If
      } else { // Else
        /* _gMsgProc := "Nessuna Operazione/Frazionata Inserita" */
        _gMsgProc = "Nessuna Operazione/Frazionata Inserita";
        /* Exec Routine arrt_writelog('IMPORT DATI','OPERAZIONI','NO RECORDS',_gMsgProc,"S") */
        arrt_writelogR.Make(m_Ctx,this).Run("IMPORT DATI","OPERAZIONI","NO RECORDS",_gMsgProc,"S");
      } // End If
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
              Error l_oErrorFault = new Error("Read on cpusers into routine arrt_imp_dati_cgo_sched_tabs returns two or more records. This item should return only a record.");
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
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpusers",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000003A8")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000003A8(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(mUser,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_users.GetString("name"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cPassword,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("E","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_gAzienda,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_users.GetString("fullname"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
            }
            // * --- Insert into cpusers_add from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cpusers_add");
            m_cPhName = m_Ctx.GetPhName("cpusers_add");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpusers_add",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000003A9")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000003A9(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(mUser,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_users.GetString("coddip"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
            }
            // * --- Insert into cpusrgrp from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cpusrgrp");
            m_cPhName = m_Ctx.GetPhName("cpusrgrp");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpusrgrp",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000003AA")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000003AA(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(6,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(mUser,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_gAzienda,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
            }
            /* uNumNew := uNumNew + 1 */
            uNumNew = CPLib.Round(uNumNew+1,0);
          } else { // Else
            // * --- Write into cpusers from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cpusers");
            m_cPhName = m_Ctx.GetPhName("cpusers");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpusers",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000003AC")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"fullname = "+CPLib.ToSQL(Cursor_cgo_users.GetString("fullname"),"C",60,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpusers",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"code = "+CPSql.SQLValueAdapter(CPLib.ToSQL(nUser,"?",0,0,m_cServer),m_cServer,nUser)+"";
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
            // * --- Write into cpusers_add from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cpusers_add");
            m_cPhName = m_Ctx.GetPhName("cpusers_add");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpusers_add",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000003AD")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"CODDIP = "+CPLib.ToSQL(Cursor_cgo_users.GetString("coddip"),"C",6,0,m_cServer)+", ";
            m_cSql = m_cSql+"SUPERDIP = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpusers_add",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"CODE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(nUser,"?",0,0,m_cServer),m_cServer,nUser)+"";
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
            /* uNumMod := uNumMod + 1 */
            uNumMod = CPLib.Round(uNumMod+1,0);
          } // End If
          // * --- Delete from cgo_users
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cgo_users");
          m_cPhName = m_Ctx.GetPhName("cgo_users");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_users",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000003AF")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"name = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_users.GetString("name"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_users.GetString("name"))+"";
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
          /* _conta := _conta + 1 */
          _conta = CPLib.Round(_conta+1,0);
          Cursor_cgo_users.Next();
        }
        m_cConnectivityError = Cursor_cgo_users.ErrorMessage();
        Cursor_cgo_users.Close();
        // * --- End Select
        /* _gMsgProc := 'Utenti Inseriti: '+LRTrim(Str(uNumNew,10,0)) + ' - Utenti Aggiornati: '+LRTrim(Str(uNumMod,10,0)) + NL */
        _gMsgProc = "Utenti Inseriti: "+CPLib.LRTrim(CPLib.Str(uNumNew,10,0))+" - Utenti Aggiornati: "+CPLib.LRTrim(CPLib.Str(uNumMod,10,0))+"\n";
        /* Exec Routine arrt_writelog('IMPORT DATI','UTENTI','Inseriti / Aggiornati '+LRTrim(Str(_conta,10,0)),_gMsgProc,"S") */
        arrt_writelogR.Make(m_Ctx,this).Run("IMPORT DATI","UTENTI","Inseriti / Aggiornati "+CPLib.LRTrim(CPLib.Str(_conta,10,0)),_gMsgProc,"S");
      } else { // Else
        /* _gMsgProc := "Nessun Utente Inserito o Aggiornato" */
        _gMsgProc = "Nessun Utente Inserito o Aggiornato";
        /* Exec Routine arrt_writelog('IMPORT DATI','UTENTI','NO RECORDS',_gMsgProc,"S") */
        arrt_writelogR.Make(m_Ctx,this).Run("IMPORT DATI","UTENTI","NO RECORDS",_gMsgProc,"S");
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
    /* If Empty(rowSoggetti.NASCOMUN) and Empty(rowSoggetti.NASSTATO) */
    if (CPLib.Empty(rowSoggetti.NASCOMUN) && CPLib.Empty(rowSoggetti.NASSTATO)) {
      /* _txterr := _txterr + 'Manca il Comune o lo Stato di Nascita' + NL */
      _txterr = _txterr+"Manca il Comune o lo Stato di Nascita"+"\n";
      /* _recOK := 1 */
      _recOK = CPLib.Round(1,0);
    } else { // Else
      /* If Empty(rowSoggetti.NASPROV) */
      if (CPLib.Empty(rowSoggetti.NASPROV)) {
        /* _txterr := _txterr + 'Manca la provincia di Nascita' + NL */
        _txterr = _txterr+"Manca la provincia di Nascita"+"\n";
        /* _recOK := 1 */
        _recOK = CPLib.Round(1,0);
      } else { // Else
        /* If Upper(LRTrim(rowSoggetti.NASPROV))='EE' */
        if (CPLib.eqr(CPLib.Upper(CPLib.LRTrim(rowSoggetti.NASPROV)),"EE")) {
          /* _cdessta := '' */
          _cdessta = "";
          /* If mcTBSTATI_D.HasKey(Upper(LRTrim(rowSoggetti.NASSTATO))) */
          if (mcTBSTATI_D.HasKey(CPLib.Upper(CPLib.LRTrim(rowSoggetti.NASSTATO)))) {
            /* If mcTBSTATI_D.GoToKey(Upper(LRTrim(rowSoggetti.NASSTATO))) */
            if (mcTBSTATI_D.GoToKey(CPLib.Upper(CPLib.LRTrim(rowSoggetti.NASSTATO)))) {
              /* _cdessta := mcTBSTATI_D.DESCRI */
              _cdessta = mcTBSTATI_D.row.DESCRI;
            } // End If
          } // End If
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
          /* If mcTBCITTA.HasKey(LRTrim(Upper(rowSoggetti.NASCOMUN))+rowSoggetti.NASPROV) */
          if (mcTBCITTA.HasKey(CPLib.LRTrim(CPLib.Upper(rowSoggetti.NASCOMUN))+rowSoggetti.NASPROV)) {
            /* If mcTBCITTA.GoToKey(LRTrim(Upper(rowSoggetti.NASCOMUN))+rowSoggetti.NASPROV) */
            if (mcTBCITTA.GoToKey(CPLib.LRTrim(CPLib.Upper(rowSoggetti.NASCOMUN))+rowSoggetti.NASPROV)) {
              /* _cdescit := LRTrim(mcTBCITTA.CITTA) */
              _cdescit = CPLib.LRTrim(mcTBCITTA.row.CITTA);
            } // End If
          } // End If
          /* If Empty(_cdescit) */
          if (CPLib.Empty(_cdescit)) {
            /* _txterr := _txterr + 'Citt� di nascita intestatario operazione errata' + NL */
            _txterr = _txterr+"Citt� di nascita intestatario operazione errata"+"\n";
            /* _recOK := 1 */
            _recOK = CPLib.Round(1,0);
          } // End If
        } // End If
      } // End If
    } // End If
    /* If _flglight='N' or (_flglight='S' and (rowSoggetti.FLGLIGHT='N' or Empty(rowSoggetti.FLGLIGHT))) */
    if (CPLib.eqr(_flglight,"N") || (CPLib.eqr(_flglight,"S") && (CPLib.eqr(rowSoggetti.FLGLIGHT,"N") || CPLib.Empty(rowSoggetti.FLGLIGHT)))) {
      /* If Empty(LRTrim(rowSoggetti.AUTRILASC)) */
      if (CPLib.Empty(CPLib.LRTrim(rowSoggetti.AUTRILASC))) {
        /* _txterr := _txterr + 'Manca autorit� rilascio del documento' + NL */
        _txterr = _txterr+"Manca autorit� rilascio del documento"+"\n";
        /* _recOK := 1 */
        _recOK = CPLib.Round(1,0);
      } // End If
      /* If Empty(LRTrim(rowSoggetti.NUMDOCUM)) */
      if (CPLib.Empty(CPLib.LRTrim(rowSoggetti.NUMDOCUM))) {
        /* _txterr := _txterr + 'Manca numero documento identit�' + NL */
        _txterr = _txterr+"Manca numero documento identit�"+"\n";
        /* _recOK := 1 */
        _recOK = CPLib.Round(1,0);
      } // End If
      /* If Empty(LRTrim(rowSoggetti.TIPODOC)) */
      if (CPLib.Empty(CPLib.LRTrim(rowSoggetti.TIPODOC))) {
        /* _txterr := _txterr + 'Manca tipo documento identit�' + NL */
        _txterr = _txterr+"Manca tipo documento identit�"+"\n";
        /* _recOK := 1 */
        _recOK = CPLib.Round(1,0);
      } else { // Else
        /* _ctipdoc := '' */
        _ctipdoc = "";
        /* If mcTIPDOC.HasKey(rowSoggetti.TIPODOC) */
        if (mcTIPDOC.HasKey(rowSoggetti.TIPODOC)) {
          /* If mcTIPDOC.GoToKey(rowSoggetti.TIPODOC) */
          if (mcTIPDOC.GoToKey(rowSoggetti.TIPODOC)) {
            /* _ctipdoc := mcTIPDOC.TIPDOC */
            _ctipdoc = mcTIPDOC.row.TIPDOC;
          } // End If
        } // End If
        /* If Empty(LRTrim(_ctipdoc)) */
        if (CPLib.Empty(CPLib.LRTrim(_ctipdoc))) {
          /* _txterr := _txterr + 'Tipo documento identit� errato' + NL */
          _txterr = _txterr+"Tipo documento identit� errato"+"\n";
          /* _recOK := 1 */
          _recOK = CPLib.Round(1,0);
        } // End If
      } // End If
      /* If Empty(rowSoggetti.DATARILASC) */
      if (CPLib.Empty(rowSoggetti.DATARILASC)) {
        /* _txterr := _txterr + "Manca data rilascio del documento del soggetto" + NL */
        _txterr = _txterr+"Manca data rilascio del documento del soggetto"+"\n";
        /* _recOK := 1 */
        _recOK = CPLib.Round(1,0);
      } else { // Else
        /* If rowSoggetti.DATARILASC > Date() */
        if (CPLib.gt(rowSoggetti.DATARILASC,CPLib.Date())) {
          /* _txterr := _txterr + "Data rilascio del documento del soggetto errata" + NL */
          _txterr = _txterr+"Data rilascio del documento del soggetto errata"+"\n";
          /* _recOK := 1 */
          _recOK = CPLib.Round(1,0);
        } // End If
      } // End If
      /* If Empty(rowSoggetti.DATAVALI) */
      if (CPLib.Empty(rowSoggetti.DATAVALI)) {
        /* _txterr := _txterr + "Manca data scadenza del documento del soggetto" + NL */
        _txterr = _txterr+"Manca data scadenza del documento del soggetto"+"\n";
        /* _recOK := 0 */
        _recOK = CPLib.Round(0,0);
      } else { // Else
        /* If rowSoggetti.DATAVALI < rowSoggetti.DATARILASC */
        if (CPLib.lt(rowSoggetti.DATAVALI,rowSoggetti.DATARILASC)) {
          /* _txterr := _txterr + "Data scadenza del documento del soggetto inferiore alla data di rilascio" + NL */
          _txterr = _txterr+"Data scadenza del documento del soggetto inferiore alla data di rilascio"+"\n";
          /* _recOK := 1 */
          _recOK = CPLib.Round(1,0);
        } // End If
      } // End If
    } // End If
    /* If Empty(rowSoggetti.DATANASC) */
    if (CPLib.Empty(rowSoggetti.DATANASC)) {
      /* _txterr := _txterr + "Manca la data di nascita del soggetto" + NL */
      _txterr = _txterr+"Manca la data di nascita del soggetto"+"\n";
      /* _recOK := 1 */
      _recOK = CPLib.Round(1,0);
    } else { // Else
      /* If rowSoggetti.DATANASC > Date() */
      if (CPLib.gt(rowSoggetti.DATANASC,CPLib.Date())) {
        /* _txterr := _txterr + "Data di nascita del soggetto errata" + NL */
        _txterr = _txterr+"Data di nascita del soggetto errata"+"\n";
        /* _recOK := 1 */
        _recOK = CPLib.Round(1,0);
      } // End If
    } // End If
    /* If Empty(rowSoggetti.PAESE) */
    if (CPLib.Empty(rowSoggetti.PAESE)) {
      /* _txterr := _txterr + 'Manca il paese di residenza del soggetto' + NL */
      _txterr = _txterr+"Manca il paese di residenza del soggetto"+"\n";
      /* _recOK := 1 */
      _recOK = CPLib.Round(1,0);
    } else { // Else
      /* If rowSoggetti.PAESE='086' */
      if (CPLib.eqr(rowSoggetti.PAESE,"086")) {
        /* If Empty(rowSoggetti.DOMICILIO) */
        if (CPLib.Empty(rowSoggetti.DOMICILIO)) {
          /* _txterr := _txterr + "Manca il domicilio del soggetto" + NL */
          _txterr = _txterr+"Manca il domicilio del soggetto"+"\n";
          /* _recOK := 1 */
          _recOK = CPLib.Round(1,0);
        } // End If
        /* If Empty(rowSoggetti.DESCCIT) */
        if (CPLib.Empty(rowSoggetti.DESCCIT)) {
          /* _txterr := _txterr + 'Manca il comune di residenza' + NL */
          _txterr = _txterr+"Manca il comune di residenza"+"\n";
          /* _recOK := 1 */
          _recOK = CPLib.Round(1,0);
        } else { // Else
          /* _cdescit := '' */
          _cdescit = "";
          /* If mcTBCITTA.HasKey(Upper(LRTrim(rowSoggetti.DESCCIT))+rowSoggetti.PROVINCIA) */
          if (mcTBCITTA.HasKey(CPLib.Upper(CPLib.LRTrim(rowSoggetti.DESCCIT))+rowSoggetti.PROVINCIA)) {
            /* If mcTBCITTA.GoToKey(Upper(LRTrim(rowSoggetti.DESCCIT))+rowSoggetti.PROVINCIA) */
            if (mcTBCITTA.GoToKey(CPLib.Upper(CPLib.LRTrim(rowSoggetti.DESCCIT))+rowSoggetti.PROVINCIA)) {
              /* _cdescit := LRTrim(mcTBCITTA.CITTA) */
              _cdescit = CPLib.LRTrim(mcTBCITTA.row.CITTA);
            } // End If
          } // End If
          /* If Empty(_cdescit) */
          if (CPLib.Empty(_cdescit)) {
            /* _txterr := _txterr + 'Citt� di residenza intestatario operazione errata' + NL */
            _txterr = _txterr+"Citt� di residenza intestatario operazione errata"+"\n";
            /* _recOK := 1 */
            _recOK = CPLib.Round(1,0);
          } // End If
        } // End If
      } else { // Else
        /* If Upper(LRTrim(rowSoggetti.PROVINCIA)) <> 'EE' and not(Empty(rowSoggetti.PROVINCIA)) */
        if (CPLib.ne(CPLib.Upper(CPLib.LRTrim(rowSoggetti.PROVINCIA)),"EE") &&  ! (CPLib.Empty(rowSoggetti.PROVINCIA))) {
          /* _txterr := _txterr + "Provincia errata per soggetto residente all'estero" + NL */
          _txterr = _txterr+"Provincia errata per soggetto residente all'estero"+"\n";
          /* _recOK := 1 */
          _recOK = CPLib.Round(1,0);
        } // End If
      } // End If
    } // End If
  }
  void Page_8() throws Exception {
    CPResultSet Cursor_anadip=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_xntestbo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_cgo_operazioni_dl=null;
    CPResultSet Cursor_cgo_operazioni_dl_multi=null;
    CPResultSet Cursor_cgo_operazioni_dl_multi_dt=null;
    CPResultSet Cursor_cgo_telematico_multipla=null;
    CPResultSet Cursor_cgo_operazioni_storico=null;
    CPResultSet Cursor_cgo_operazioni_storico_multi=null;
    try {
      /* _coddip := rowTele.CODDIPE */
      _coddip = rowTele.CODDIPE;
      /* _ipcol := rowTele.IPCOLLEG */
      _ipcol = rowTele.IPCOLLEG;
      /* _drcol := rowTele.DUCOLLEG */
      _drcol = CPLib.Round(rowTele.DUCOLLEG,0);
      /* _orcol := rowTele.ORACOLLEG */
      _orcol = rowTele.ORACOLLEG;
      /* _idbiglietto := rowTele.CAIDBIGLIETTO */
      _idbiglietto = rowTele.CAIDBIGLIETTO;
      /* _rapporto := rowTele.RAPPORTO */
      _rapporto = rowTele.RAPPORTO;
      /* _env := rowTele.ENV */
      _env = rowTele.ENV;
      /* _importo := rowTele.TOTLIRE */
      _importo = CPLib.Round(rowTele.TOTLIRE,0);
      /* _iban := rowTele.IBAN */
      _iban = rowTele.IBAN;
      /* _vpcodice := rowTele.VPCODICE */
      _vpcodice = rowTele.VPCODICE;
      // * --- Select from anadip
      m_cServer = m_Ctx.GetServer("anadip");
      m_cPhName = m_Ctx.GetPhName("anadip");
      if (Cursor_anadip!=null)
        Cursor_anadip.Close();
      Cursor_anadip = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowTele.CODDIPE,"?",0,0,m_cServer, m_oParameters),m_cServer,rowTele.CODDIPE)+" "+")"+(m_Ctx.IsSharedTemp("anadip")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
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
      m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowTele.RAPPORTO,"C",25,0,m_cServer),m_cServer,rowTele.RAPPORTO);
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
          Error l_oErrorFault = new Error("Read on anarapbo into routine arrt_imp_dati_cgo_sched_tabs returns two or more records. This item should return only a record.");
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
        m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowTele.RAPPORTO,"C",25,0,m_cServer),m_cServer,rowTele.RAPPORTO);
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
            Error l_oErrorFault = new Error("Read on xnarapbo into routine arrt_imp_dati_cgo_sched_tabs returns two or more records. This item should return only a record.");
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
      /* xData := Left(DateTimeToChar(rowTele.CADATAORA),8) */
      xData = CPLib.Left(CPLib.DateTimeToChar(rowTele.CADATAORA),8);
      /* _datope := CharToDate(xData) */
      _datope = CPLib.CharToDate(xData);
      /* _datreg := Date() */
      _datreg = CPLib.Date();
      /* _codana := '' */
      _codana = "";
      /* _codsin := '' */
      _codsin = "";
      /* _flgaui := '' */
      _flgaui = "";
      /* _segno := '' */
      _segno = "";
      /* _tipope := '' */
      _tipope = "";
      /* _flgope := '' */
      _flgope = "";
      /* _mezpagam := iif(LRTrim(rowTele.MEZPAGAM) <> 'I' and LRTrim(rowTele.MEZPAGAM) <> 'E' and LRTrim(rowTele.MEZPAGAM) <> 'P','A',LRTrim(rowTele.MEZPAGAM)) */
      _mezpagam = (CPLib.ne(CPLib.LRTrim(rowTele.MEZPAGAM),"I") && CPLib.ne(CPLib.LRTrim(rowTele.MEZPAGAM),"E") && CPLib.ne(CPLib.LRTrim(rowTele.MEZPAGAM),"P")?"A":CPLib.LRTrim(rowTele.MEZPAGAM));
      /* If mcCAUSALI.HasKey(Str(rowTele.CACODICE,5,0)+_mezpagam) */
      if (mcCAUSALI.HasKey(CPLib.Str(rowTele.CACODICE,5,0)+_mezpagam)) {
        /* If mcCAUSALI.GoToKey(Str(rowTele.CACODICE,5,0)+_mezpagam) */
        if (mcCAUSALI.GoToKey(CPLib.Str(rowTele.CACODICE,5,0)+_mezpagam)) {
          /* _codana := mcCAUSALI.CACODANA */
          _codana = mcCAUSALI.row.CACODANA;
          /* _codsin := mcCAUSALI.CACODSIN */
          _codsin = mcCAUSALI.row.CACODSIN;
          /* _segno := mcCAUSALI.CASEGNO */
          _segno = mcCAUSALI.row.CASEGNO;
          /* _flgaui := mcCAUSALI.CAFLGAUI */
          _flgaui = mcCAUSALI.row.CAFLGAUI;
          /* _flgope := mcCAUSALI.CAFLGOPE */
          _flgope = mcCAUSALI.row.CAFLGOPE;
        } // End If
      } // End If
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
      /* _catipgio := rowTele.CATIPGIO */
      _catipgio = CPLib.Round(rowTele.CATIPGIO,0);
      /* _catipcon := rowTele.CATIPCON */
      _catipcon = CPLib.Round(rowTele.CATIPCON,0);
      /* _capv_cod := rowTele.CAPV_COD */
      _capv_cod = CPLib.Round(rowTele.CAPV_COD,0);
      /* _cadataora := rowTele.CADATAORA */
      _cadataora = rowTele.CADATAORA;
      /* If rowTele.ENV='W' */
      if (CPLib.eqr(rowTele.ENV,"W")) {
        /* _tottele := rowTele.TOTLIRE */
        _tottele = CPLib.Round(rowTele.TOTLIRE,0);
        /* _codlob := rowTele.CODLOB */
        _codlob = rowTele.CODLOB;
        /* _tipgio := rowTele.TIPOGIOCO */
        _tipgio = rowTele.TIPOGIOCO;
        /* _cacodice := rowTele.CACODICE */
        _cacodice = CPLib.Round(rowTele.CACODICE,0);
        /* _biglietto := rowTele.CAIDBIGLIETTO */
        _biglietto = rowTele.CAIDBIGLIETTO;
        /* If _flgaui='N' */
        if (CPLib.eqr(_flgaui,"N")) {
          /* cOpeProg1 := Utilities.GetAutonumber("PSRAZ1\'"+LRTrim(_gAzienda)+"'",'',10) */
          cOpeProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PSRAZ1\\'"+CPLib.LRTrim(_gAzienda)+"'","",10);
          /* cOpeProg2 := Utilities.GetAutonumber("PSRAZ2\'"+LRTrim(_gAzienda)+"'",'',11) */
          cOpeProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PSRAZ2\\'"+CPLib.LRTrim(_gAzienda)+"'","",11);
          /* nProgImp := Utilities.GetAutonumber("PRGIMPSRZ\'"+LRTrim(_gAzienda)+"'",0,15) */
          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPSRZ\\'"+CPLib.LRTrim(_gAzienda)+"'",0,15),0);
          /* nIntest := 1 */
          nIntest = CPLib.Round(1,0);
          // * --- Insert into sraziobo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("sraziobo");
          m_cPhName = m_Ctx.GetPhName("sraziobo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sraziobo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000443")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000443(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codana,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_cabinter,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowTele.CODDIPE,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codsin,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_citinter,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowTele.DUCOLLEG,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tiporap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(xData+cOpeProg2+"0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowTele.IPCOLLEG,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowTele.ORACOLLEG,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_prvinter,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowTele.RAPPORTO,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowTele.CAIDBIGLIETTO,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tipope,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowTele.TOTLIRE*100,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowTele.ENV,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"sraziobo",true);
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
          /* If _locrap='D' */
          if (CPLib.eqr(_locrap,"D")) {
            // * --- Select from intestbo
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            if (Cursor_intestbo!=null)
              Cursor_intestbo.Close();
            Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowTele.RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,rowTele.RAPPORTO)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestbo.Eof())) {
              /* If nIntest=1 */
              if (CPLib.eqr(nIntest,1)) {
                /* xCF := intestbo->CODINTER */
                xCF = Cursor_intestbo.GetString("CODINTER");
                // * --- Write into sraziobo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("sraziobo");
                m_cPhName = m_Ctx.GetPhName("sraziobo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sraziobo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000448")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"sraziobo",false,true);
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
              } else { // Else
                // * --- Insert into slientifrz from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("slientifrz");
                m_cPhName = m_Ctx.GetPhName("slientifrz");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"slientifrz",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000449")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000449(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"slientifrz",true);
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
            Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowTele.RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,rowTele.RAPPORTO)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xntestbo.Eof())) {
              /* If nIntest=1 */
              if (CPLib.eqr(nIntest,1)) {
                /* xCF := xntestbo->CODINTER */
                xCF = Cursor_xntestbo.GetString("CODINTER");
                // * --- Write into sraziobo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("sraziobo");
                m_cPhName = m_Ctx.GetPhName("sraziobo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sraziobo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"0000044E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"sraziobo",false,true);
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
              } else { // Else
                // * --- Insert into slientifrz from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("slientifrz");
                m_cPhName = m_Ctx.GetPhName("slientifrz");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"slientifrz",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"0000044F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000044F(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"slientifrz",true);
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
              // * --- Write into sraziobo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("sraziobo");
              m_cPhName = m_Ctx.GetPhName("sraziobo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sraziobo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000453")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"C_RAG = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_STA = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_CTA = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_CAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_PRV = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_IND = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",5,0,m_cServer)+", ";
              m_cSql = m_cSql+"CONNESBEN = "+CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"C",16,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"sraziobo",false,true);
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
          /* If not(Empty(rowTele.IBAN)) */
          if ( ! (CPLib.Empty(rowTele.IBAN))) {
            /* If Left(rowTele.IBAN,2)='IT' */
            if (CPLib.eqr(CPLib.Left(rowTele.IBAN,2),"IT")) {
              /* abicab := Substr(rowTele.IBAN,6,5)+"-"+Substr(rowTele.IBAN,11,5) */
              abicab = CPLib.Substr(rowTele.IBAN,6,5)+"-"+CPLib.Substr(rowTele.IBAN,11,5);
              /* If mcINTER2BO.HasKey(abicab) */
              if (mcINTER2BO.HasKey(abicab)) {
                /* If mcINTER2BO.GoToKey(abicab) */
                if (mcINTER2BO.GoToKey(abicab)) {
                  // * --- Write into sraziobo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("sraziobo");
                  m_cPhName = m_Ctx.GetPhName("sraziobo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sraziobo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000459")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"TIPOINT2 = "+CPLib.ToSQL(mcINTER2BO.row.TIPINTER,"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODINT2 = "+CPLib.ToSQL(abicab,"C",11,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(mcINTER2BO.row.PAESE,"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESC2 = "+CPLib.ToSQL(mcINTER2BO.row.DESCCIT,"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROV2 = "+CPLib.ToSQL(mcINTER2BO.row.PROVINCIA,"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODCAB2 = "+CPLib.ToSQL(mcINTER2BO.row.CODCAB,"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCINTER = "+CPLib.ToSQL(mcINTER2BO.row.RAGSOC,"C",50,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"sraziobo",false,true);
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
              } // End If
            } else { // Else
              /* abicab := Left(rowTele.IBAN,11) */
              abicab = CPLib.Left(rowTele.IBAN,11);
              // * --- Write into sraziobo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("sraziobo");
              m_cPhName = m_Ctx.GetPhName("sraziobo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sraziobo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"0000045B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"CODINT2 = "+CPLib.ToSQL(abicab,"C",11,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"sraziobo",false,true);
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
          } // End If
          /* sNumero := sNumero + 1 */
          sNumero = CPLib.Round(sNumero+1,0);
        } else { // Else
          /* If rowTele.TOTLIRE >= _limoper */
          if (CPLib.ge(rowTele.TOTLIRE,_limoper)) {
            /* Exec "Scrive Dati Operazioni" Page 12:Page_12 */
            Page_12();
          } else { // Else
            /* Exec "Scrive Dati Frazionate" Page 13:Page_13 */
            Page_13();
          } // End If
        } // End If
        /* Exec "Scrive dati aggiuntivi operazioni" Page 11:Page_11 */
        Page_11();
        /* ElseIf rowTele.ENV='A' or rowTele.ENV='V' */
      } else if (CPLib.eqr(rowTele.ENV,"A") || CPLib.eqr(rowTele.ENV,"V")) {
        /* nProgImp := Utilities.GetAutonumber("PRGIMCGOA\'"+LRTrim(_gAzienda)+"'",0,15) */
        nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMCGOA\\'"+CPLib.LRTrim(_gAzienda)+"'",0,15),0);
        /* _flgvnp := 'A' */
        _flgvnp = "A";
        /* _numass := '' */
        _numass = "";
        for (MemoryCursorRow_cgo_tbtipgio rwTBTIPGIO : mcTBTIPGIO._iterable_()) {
          /* If rwTBTIPGIO.CODTPGIO=rowTele.TIPOGIOCO */
          if (CPLib.eqr(rwTBTIPGIO.CODTPGIO,rowTele.TIPOGIOCO)) {
            /* If rowTele.TOTLIRE < rwTBTIPGIO.SOGTPGIO */
            if (CPLib.lt(rowTele.TOTLIRE,rwTBTIPGIO.SOGTPGIO)) {
              /* _flgvlt := rwTBTIPGIO.DEFTPGIO */
              _flgvlt = rwTBTIPGIO.DEFTPGIO;
            } else { // Else
              /* _flgvlt := rwTBTIPGIO.DEFSPGIO */
              _flgvlt = rwTBTIPGIO.DEFSPGIO;
            } // End If
          } // End If
        }
        /* _numope := '' */
        _numope = "";
        /* If rowTele.ENV='V' */
        if (CPLib.eqr(rowTele.ENV,"V")) {
          /* _numope := '' */
          _numope = "";
          // * --- Select from cgo_operazioni_dl
          m_cServer = m_Ctx.GetServer("cgo_operazioni_dl");
          m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl");
          if (Cursor_cgo_operazioni_dl!=null)
            Cursor_cgo_operazioni_dl.Close();
          Cursor_cgo_operazioni_dl = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"DATAOPE= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_datope,"?",0,0,m_cServer, m_oParameters),m_cServer,_datope)+"  and  CODDIPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowTele.CODDIPE,"?",0,0,m_cServer, m_oParameters),m_cServer,rowTele.CODDIPE)+"  and  TOTLIRE="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowTele.TOTLIRE,"?",0,0,m_cServer, m_oParameters),m_cServer,rowTele.TOTLIRE)+"  and  TIPOGIOCO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowTele.TIPOGIOCO,"?",0,0,m_cServer, m_oParameters),m_cServer,rowTele.TIPOGIOCO)+" "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni_dl")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_cgo_operazioni_dl.Eof())) {
            /* _numope := cgo_operazioni_dl->SNAINUMOPE */
            _numope = Cursor_cgo_operazioni_dl.GetString("SNAINUMOPE");
            /* _numass := cgo_operazioni_dl->ASSEGNO */
            _numass = Cursor_cgo_operazioni_dl.GetString("ASSEGNO");
            Cursor_cgo_operazioni_dl.Next();
          }
          m_cConnectivityError = Cursor_cgo_operazioni_dl.ErrorMessage();
          Cursor_cgo_operazioni_dl.Close();
          // * --- End Select
          /* If _numope='' */
          if (CPLib.eqr(_numope,"")) {
            // * --- Select from cgo_operazioni_dl_multi
            m_cServer = m_Ctx.GetServer("cgo_operazioni_dl_multi");
            m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl_multi");
            if (Cursor_cgo_operazioni_dl_multi!=null)
              Cursor_cgo_operazioni_dl_multi.Close();
            Cursor_cgo_operazioni_dl_multi = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODDIPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowTele.CODDIPE,"?",0,0,m_cServer, m_oParameters),m_cServer,rowTele.CODDIPE)+"  and  TIPOGIOCO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowTele.TIPOGIOCO,"?",0,0,m_cServer, m_oParameters),m_cServer,rowTele.TIPOGIOCO)+" "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni_dl_multi")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_cgo_operazioni_dl_multi.Eof())) {
              /* _numass := cgo_operazioni_dl_multi->ASSEGNO */
              _numass = Cursor_cgo_operazioni_dl_multi.GetString("ASSEGNO");
              // * --- Select from cgo_operazioni_dl_multi_dt
              m_cServer = m_Ctx.GetServer("cgo_operazioni_dl_multi_dt");
              m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl_multi_dt");
              if (Cursor_cgo_operazioni_dl_multi_dt!=null)
                Cursor_cgo_operazioni_dl_multi_dt.Close();
              Cursor_cgo_operazioni_dl_multi_dt = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SNAINUMOPE="+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi.GetString("SNAINUMOPE"),"?",0,0)+"  and  DATOPE= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_datope,"?",0,0,m_cServer, m_oParameters),m_cServer,_datope)+"  and  TOTLIRE="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowTele.TOTLIRE,"?",0,0,m_cServer, m_oParameters),m_cServer,rowTele.TOTLIRE)+" "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni_dl_multi_dt")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_cgo_operazioni_dl_multi_dt.Eof())) {
                /* _numope := cgo_operazioni_dl_multi_dt->SNAINUMOPE */
                _numope = Cursor_cgo_operazioni_dl_multi_dt.GetString("SNAINUMOPE");
                // * --- Write into cgo_operazioni_dl_multi_dt from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("cgo_operazioni_dl_multi_dt");
                m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl_multi_dt");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_operazioni_dl_multi_dt",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000474")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"TOTLIRE = "+CPLib.ToSQL(rowTele.TOTLIRE,"N",15,2)+", ";
                m_cSql = m_cSql+"FLGFULL = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_operazioni_dl_multi_dt",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"SNAINUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dt.GetString("SNAINUMOPE"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_operazioni_dl_multi_dt.GetString("SNAINUMOPE"))+"";
                m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dt.GetDouble("CPROWNUM"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_operazioni_dl_multi_dt.GetDouble("CPROWNUM"))+"";
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
                /* _omulti := 'S' */
                _omulti = "S";
                Cursor_cgo_operazioni_dl_multi_dt.Next();
              }
              m_cConnectivityError = Cursor_cgo_operazioni_dl_multi_dt.ErrorMessage();
              Cursor_cgo_operazioni_dl_multi_dt.Close();
              // * --- End Select
              Cursor_cgo_operazioni_dl_multi.Next();
            }
            m_cConnectivityError = Cursor_cgo_operazioni_dl_multi.ErrorMessage();
            Cursor_cgo_operazioni_dl_multi.Close();
            // * --- End Select
          } // End If
        } else { // Else
          /* _idb := '' */
          _idb = "";
          /* _oidb := 'N' */
          _oidb = "N";
          /* _numope := '' */
          _numope = "";
          /* _seekid := iif(Right(LRTrim(rowTele.CAIDBIGLIETTO),8)='00000000',Left(LRTrim(rowTele.CAIDBIGLIETTO),12),rowTele.CAIDBIGLIETTO) */
          _seekid = (CPLib.eqr(CPLib.Right(CPLib.LRTrim(rowTele.CAIDBIGLIETTO),8),"00000000")?CPLib.Left(CPLib.LRTrim(rowTele.CAIDBIGLIETTO),12):rowTele.CAIDBIGLIETTO);
          // * --- Select from cgo_operazioni_dl
          m_cServer = m_Ctx.GetServer("cgo_operazioni_dl");
          m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl");
          if (Cursor_cgo_operazioni_dl!=null)
            Cursor_cgo_operazioni_dl.Close();
          Cursor_cgo_operazioni_dl = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"DATAOPE= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_datope,"?",0,0,m_cServer, m_oParameters),m_cServer,_datope)+"  and  CODDIPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowTele.CODDIPE,"?",0,0,m_cServer, m_oParameters),m_cServer,rowTele.CODDIPE)+"  and  TOTLIRE="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowTele.TOTLIRE,"?",0,0,m_cServer, m_oParameters),m_cServer,rowTele.TOTLIRE)+"  and  CAIDBIGLIETTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_seekid,"?",0,0,m_cServer, m_oParameters),m_cServer,_seekid)+"  and  TIPOGIOCO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowTele.TIPOGIOCO,"?",0,0,m_cServer, m_oParameters),m_cServer,rowTele.TIPOGIOCO)+" "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni_dl")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_cgo_operazioni_dl.Eof())) {
            /* _numope := cgo_operazioni_dl->SNAINUMOPE */
            _numope = Cursor_cgo_operazioni_dl.GetString("SNAINUMOPE");
            /* _numass := cgo_operazioni_dl->ASSEGNO */
            _numass = Cursor_cgo_operazioni_dl.GetString("ASSEGNO");
            /* _idb := rowTele.CAIDBIGLIETTO */
            _idb = rowTele.CAIDBIGLIETTO;
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
            Cursor_cgo_operazioni_dl = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"DATAOPE= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_datope,"?",0,0,m_cServer, m_oParameters),m_cServer,_datope)+"  and  CODDIPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowTele.CODDIPE,"?",0,0,m_cServer, m_oParameters),m_cServer,rowTele.CODDIPE)+"  and  CAIDBIGLIETTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_seekid,"?",0,0,m_cServer, m_oParameters),m_cServer,_seekid)+"  and  TIPOGIOCO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowTele.TIPOGIOCO,"?",0,0,m_cServer, m_oParameters),m_cServer,rowTele.TIPOGIOCO)+" "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni_dl")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_cgo_operazioni_dl.Eof())) {
              /* _numope := cgo_operazioni_dl->SNAINUMOPE */
              _numope = Cursor_cgo_operazioni_dl.GetString("SNAINUMOPE");
              /* _numass := cgo_operazioni_dl->ASSEGNO */
              _numass = Cursor_cgo_operazioni_dl.GetString("ASSEGNO");
              /* _idb := rowTele.CAIDBIGLIETTO */
              _idb = rowTele.CAIDBIGLIETTO;
              /* _oidb := 'S' */
              _oidb = "S";
              Cursor_cgo_operazioni_dl.Next();
            }
            m_cConnectivityError = Cursor_cgo_operazioni_dl.ErrorMessage();
            Cursor_cgo_operazioni_dl.Close();
            // * --- End Select
          } // End If
          /* If Empty(LRTrim(_numope)) */
          if (CPLib.Empty(CPLib.LRTrim(_numope))) {
            // * --- Select from cgo_operazioni_dl_multi
            m_cServer = m_Ctx.GetServer("cgo_operazioni_dl_multi");
            m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl_multi");
            if (Cursor_cgo_operazioni_dl_multi!=null)
              Cursor_cgo_operazioni_dl_multi.Close();
            Cursor_cgo_operazioni_dl_multi = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODDIPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowTele.CODDIPE,"?",0,0,m_cServer, m_oParameters),m_cServer,rowTele.CODDIPE)+" "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni_dl_multi")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_cgo_operazioni_dl_multi.Eof())) {
              /* _numass := cgo_operazioni_dl_multi->ASSEGNO */
              _numass = Cursor_cgo_operazioni_dl_multi.GetString("ASSEGNO");
              // * --- Select from cgo_operazioni_dl_multi_dt
              m_cServer = m_Ctx.GetServer("cgo_operazioni_dl_multi_dt");
              m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl_multi_dt");
              if (Cursor_cgo_operazioni_dl_multi_dt!=null)
                Cursor_cgo_operazioni_dl_multi_dt.Close();
              Cursor_cgo_operazioni_dl_multi_dt = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SNAINUMOPE="+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi.GetString("SNAINUMOPE"),"?",0,0)+"  and  DATOPE= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_datope,"?",0,0,m_cServer, m_oParameters),m_cServer,_datope)+"  and  TOTLIRE="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowTele.TOTLIRE,"?",0,0,m_cServer, m_oParameters),m_cServer,rowTele.TOTLIRE)+"  and  CAIDBIGLIETTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_seekid,"?",0,0,m_cServer, m_oParameters),m_cServer,_seekid)+" "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni_dl_multi_dt")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_cgo_operazioni_dl_multi_dt.Eof())) {
                /* _numope := cgo_operazioni_dl_multi_dt->SNAINUMOPE */
                _numope = Cursor_cgo_operazioni_dl_multi_dt.GetString("SNAINUMOPE");
                /* _omulti := 'S' */
                _omulti = "S";
                // * --- Write into cgo_operazioni_dl_multi_dt from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("cgo_operazioni_dl_multi_dt");
                m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl_multi_dt");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_operazioni_dl_multi_dt",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"0000048A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"TOTLIRE = "+CPLib.ToSQL(rowTele.TOTLIRE,"N",15,2)+", ";
                m_cSql = m_cSql+"FLGFULL = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_operazioni_dl_multi_dt",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"SNAINUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dt.GetString("SNAINUMOPE"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_operazioni_dl_multi_dt.GetString("SNAINUMOPE"))+"";
                m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dt.GetDouble("CPROWNUM"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_operazioni_dl_multi_dt.GetDouble("CPROWNUM"))+"";
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
                Cursor_cgo_operazioni_dl_multi_dt.Next();
              }
              m_cConnectivityError = Cursor_cgo_operazioni_dl_multi_dt.ErrorMessage();
              Cursor_cgo_operazioni_dl_multi_dt.Close();
              // * --- End Select
              /* If Empty(LRTrim(_numope)) */
              if (CPLib.Empty(CPLib.LRTrim(_numope))) {
                // * --- Select from cgo_operazioni_dl_multi_dt
                m_cServer = m_Ctx.GetServer("cgo_operazioni_dl_multi_dt");
                m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl_multi_dt");
                if (Cursor_cgo_operazioni_dl_multi_dt!=null)
                  Cursor_cgo_operazioni_dl_multi_dt.Close();
                Cursor_cgo_operazioni_dl_multi_dt = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SNAINUMOPE="+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi.GetString("SNAINUMOPE"),"?",0,0)+"  and  DATOPE= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_datope,"?",0,0,m_cServer, m_oParameters),m_cServer,_datope)+"  and  CAIDBIGLIETTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_seekid,"?",0,0,m_cServer, m_oParameters),m_cServer,_seekid)+" "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni_dl_multi_dt")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_cgo_operazioni_dl_multi_dt.Eof())) {
                  /* _numope := cgo_operazioni_dl_multi_dt->SNAINUMOPE */
                  _numope = Cursor_cgo_operazioni_dl_multi_dt.GetString("SNAINUMOPE");
                  /* _omulti := 'S' */
                  _omulti = "S";
                  // * --- Write into cgo_operazioni_dl_multi_dt from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("cgo_operazioni_dl_multi_dt");
                  m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl_multi_dt");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_operazioni_dl_multi_dt",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"0000048F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"TOTLIRE = "+CPLib.ToSQL(rowTele.TOTLIRE,"N",15,2)+", ";
                  m_cSql = m_cSql+"FLGFULL = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_operazioni_dl_multi_dt",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"SNAINUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dt.GetString("SNAINUMOPE"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_operazioni_dl_multi_dt.GetString("SNAINUMOPE"))+"";
                  m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dt.GetDouble("CPROWNUM"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_operazioni_dl_multi_dt.GetDouble("CPROWNUM"))+"";
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
                  Cursor_cgo_operazioni_dl_multi_dt.Next();
                }
                m_cConnectivityError = Cursor_cgo_operazioni_dl_multi_dt.ErrorMessage();
                Cursor_cgo_operazioni_dl_multi_dt.Close();
                // * --- End Select
              } // End If
              Cursor_cgo_operazioni_dl_multi.Next();
            }
            m_cConnectivityError = Cursor_cgo_operazioni_dl_multi.ErrorMessage();
            Cursor_cgo_operazioni_dl_multi.Close();
            // * --- End Select
          } // End If
        } // End If
        /* If not(Empty(LRTrim(_numope))) */
        if ( ! (CPLib.Empty(CPLib.LRTrim(_numope)))) {
          /* If _omulti='S' */
          if (CPLib.eqr(_omulti,"S")) {
            /* _omultic := 'S' */
            _omultic = "S";
            // * --- Select from cgo_operazioni_dl_multi_dt
            m_cServer = m_Ctx.GetServer("cgo_operazioni_dl_multi_dt");
            m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl_multi_dt");
            if (Cursor_cgo_operazioni_dl_multi_dt!=null)
              Cursor_cgo_operazioni_dl_multi_dt.Close();
            Cursor_cgo_operazioni_dl_multi_dt = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numope,"?",0,0,m_cServer, m_oParameters),m_cServer,_numope)+" "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni_dl_multi_dt")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_cgo_operazioni_dl_multi_dt.Eof())) {
              /* xSNAINUMOPE := cgo_operazioni_dl_multi_dt->SNAINUMOPE */
              xSNAINUMOPE = Cursor_cgo_operazioni_dl_multi_dt.GetString("SNAINUMOPE");
              /* If cgo_operazioni_dl_multi_dt->FLGFULL='N' or Empty(cgo_operazioni_dl_multi_dt->FLGFULL) */
              if (CPLib.eqr(Cursor_cgo_operazioni_dl_multi_dt.GetString("FLGFULL"),"N") || CPLib.Empty(Cursor_cgo_operazioni_dl_multi_dt.GetString("FLGFULL"))) {
                /* _omultic := 'N' */
                _omultic = "N";
              } // End If
              Cursor_cgo_operazioni_dl_multi_dt.Next();
            }
            m_cConnectivityError = Cursor_cgo_operazioni_dl_multi_dt.ErrorMessage();
            Cursor_cgo_operazioni_dl_multi_dt.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from cgo_operazioni_dl
            m_cServer = m_Ctx.GetServer("cgo_operazioni_dl");
            m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl");
            if (Cursor_cgo_operazioni_dl!=null)
              Cursor_cgo_operazioni_dl.Close();
            Cursor_cgo_operazioni_dl = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numope,"?",0,0,m_cServer, m_oParameters),m_cServer,_numope)+" "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni_dl")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_cgo_operazioni_dl.Eof())) {
              /* nProgOpe := Utilities.GetAutonumber("PRGNUMOPE\'"+LRTrim(_gAzienda)+"'","",15) */
              nProgOpe = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGNUMOPE\\'"+CPLib.LRTrim(_gAzienda)+"'","",15);
              // * --- Insert into cgo_operazioni from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cgo_operazioni");
              m_cPhName = m_Ctx.GetPhName("cgo_operazioni");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_operazioni",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000499")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000499(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("ASSEGNO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("ATTIV"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowTele.CACODICE,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cadataora,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("CAFLGOPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowTele.CAIDBIGLIETTO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_capv_cod,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_catipcon,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_catipgio,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetDouble("CFESTERO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("CGOFLGVLT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("CGOFLGVNP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowTele.ENV,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codana,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cabinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowTele.CODDIPE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowTele.CODLOB,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codsin,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetDate("DATANASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetDate("DATARILASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetDate("DATAVALI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_citinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tiporap,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_cgo_operazioni_dl.GetString("FLGDOCALL"))?"N":Cursor_cgo_operazioni_dl.GetString("FLGDOCALL")),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("IBAN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_cgo_operazioni_dl.GetString("IDDOCALL"))?LibreriaMit.nextUID():Cursor_cgo_operazioni_dl.GetString("IDDOCALL")),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("MEZPAGAM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("NOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_numope,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("PEP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_prvinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowTele.RAPPORTO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("RDCODAUT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("RDLOCAUT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("SESSO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgOpe,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowTele.TIPOGIOCO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tipope,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetDouble("TOTCONT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowTele.TOTLIRE,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_vpcodice,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("PEPDESCRI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("DOMICILIO2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("DESCCIT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("PROVINCIA2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("PAESE2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("CAP2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("FLGDOM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("PROFESSIONE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("FLAGWALLET"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetDouble("IMPWALLET"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("CODWALLET"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("CODTRANSZ"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
              }
              Cursor_cgo_operazioni_dl.Next();
            }
            m_cConnectivityError = Cursor_cgo_operazioni_dl.ErrorMessage();
            Cursor_cgo_operazioni_dl.Close();
            // * --- End Select
            /* If rowTele.ENV='V' */
            if (CPLib.eqr(rowTele.ENV,"V")) {
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
          } // End If
          /* If _omulti='N' */
          if (CPLib.eqr(_omulti,"N")) {
            /* cProgImp := LRTrim(nProgOpe) */
            cProgImp = CPLib.LRTrim(nProgOpe);
            /* Exec Routine arrt_writelog('IMPORT DATI','CGO_OPERAZIONI',nProgOpe,'Associazione Operazione con IDBIGLIETTO'+_seekid,"S") */
            arrt_writelogR.Make(m_Ctx,this).Run("IMPORT DATI","CGO_OPERAZIONI",nProgOpe,"Associazione Operazione con IDBIGLIETTO"+_seekid,"S");
            /* Exec Routine arrt_snai_oper_save(cProgImp,'X',_gAzienda) */
            arrt_snai_oper_saveR.Make(m_Ctx,this).Run(cProgImp,"X",_gAzienda);
            /* ElseIf _omulti='S' and _omultic='S' */
          } else if (CPLib.eqr(_omulti,"S") && CPLib.eqr(_omultic,"S")) {
            /* mNumero := mNumero + 1 */
            mNumero = CPLib.Round(mNumero+1,0);
            /* Exec Routine arrt_cgo_save_multi_dl(xSNAINUMOPE,_gAzienda) */
            arrt_cgo_save_multi_dlR.Make(m_Ctx,this).Run(xSNAINUMOPE,_gAzienda);
            /* _MsgAss := _MsgAss + 'Associata Operazione Multipla Completa n. '+_numope + NL */
            _MsgAss = _MsgAss+"Associata Operazione Multipla Completa n. "+_numope+"\n";
          } // End If
        } else { // Else
          /* nProgOpe := Utilities.GetAutonumber("PRGNUMOPE\'"+LRTrim(_gAzienda)+"'","",15) */
          nProgOpe = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGNUMOPE\\'"+CPLib.LRTrim(_gAzienda)+"'","",15);
          /* Exec Routine arrt_writelog('IMPORT DATI','CGO_OPERAZIONI',nProgOpe,'Inserimento Operazione con IDBIGLIETTO'+_seekid,"S") */
          arrt_writelogR.Make(m_Ctx,this).Run("IMPORT DATI","CGO_OPERAZIONI",nProgOpe,"Inserimento Operazione con IDBIGLIETTO"+_seekid,"S");
          // * --- Insert into cgo_operazioni from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cgo_operazioni");
          m_cPhName = m_Ctx.GetPhName("cgo_operazioni");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_operazioni",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000004A8")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000004A8(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_numass,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowTele.CACODICE,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_cadataora,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_flgope,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowTele.CAIDBIGLIETTO,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_capv_cod,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_catipcon,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_catipgio,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_flgvlt,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_flgvnp,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowTele.ENV,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codana,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_cabinter,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowTele.CODDIPE,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowTele.CODLOB,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codsin,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_citinter,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tiporap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.nextUID(),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_prvinter,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowTele.RAPPORTO,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgOpe,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowTele.TIPOGIOCO,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tipope,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowTele.TOTLIRE,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_vpcodice,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
          }
        } // End If
        /* oNumero := oNumero + 1 */
        oNumero = CPLib.Round(oNumero+1,0);
        /* ElseIf rowTele.ENV='M' */
      } else if (CPLib.eqr(rowTele.ENV,"M")) {
        /* _flgvnp := 'A' */
        _flgvnp = "A";
        /* nTotRighe := 0 */
        nTotRighe = CPLib.Round(0,0);
        // * --- Fill memory cursor mcMultipla on cgo_telematico_multipla
        mcMultipla.Zap();
        m_cServer = m_Ctx.GetServer("cgo_telematico_multipla");
        m_cPhName = m_Ctx.GetPhName("cgo_telematico_multipla");
        if (Cursor_cgo_telematico_multipla!=null)
          Cursor_cgo_telematico_multipla.Close();
        Cursor_cgo_telematico_multipla = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *,'N'  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowTele.SNAINUMOPE,"?",0,0,m_cServer, m_oParameters),m_cServer,rowTele.SNAINUMOPE)+" "+")"+(m_Ctx.IsSharedTemp("cgo_telematico_multipla")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        {
          final CPResultSet m_TheCursor = Cursor_cgo_telematico_multipla;
          Cursor_cgo_telematico_multipla.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arrt_imp_dati_cgo_sched_tabs: query on cgo_telematico_multipla returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_cgo_telematico_multipla.Eof())) {
          mcMultipla.AppendBlank();
          mcMultipla.row.SNAINUMOPE = Cursor_cgo_telematico_multipla.GetString("SNAINUMOPE");
          mcMultipla.row.ENV = Cursor_cgo_telematico_multipla.GetString("ENV");
          mcMultipla.row.IDMULTIPLA = Cursor_cgo_telematico_multipla.GetString("IDMULTIPLA");
          mcMultipla.row.TOTLIRE = Cursor_cgo_telematico_multipla.GetDouble("TOTLIRE");
          mcMultipla.row.CACODICE = Cursor_cgo_telematico_multipla.GetDouble("CACODICE");
          mcMultipla.row.CADATAORA = Cursor_cgo_telematico_multipla.GetDateTime("CADATAORA");
          mcMultipla.row.CAIDBIGLIETTO = Cursor_cgo_telematico_multipla.GetString("CAIDBIGLIETTO");
          mcMultipla.row.CODLOB = Cursor_cgo_telematico_multipla.GetString("CODLOB");
          mcMultipla.row.TIPOGIOCO = Cursor_cgo_telematico_multipla.GetString("TIPOGIOCO");
          mcMultipla.row.CATIPGIO = Cursor_cgo_telematico_multipla.GetDouble("CATIPGIO");
          mcMultipla.row.CATIPCON = Cursor_cgo_telematico_multipla.GetDouble("CATIPCON");
          Cursor_cgo_telematico_multipla.Next();
        }
        m_cConnectivityError = Cursor_cgo_telematico_multipla.ErrorMessage();
        Cursor_cgo_telematico_multipla.Close();
        mcMultipla.GoTop();
        /* nTotRighe := mcMultipla.RecCount() */
        nTotRighe = CPLib.Round(mcMultipla.RecCount(),0);
        /* mcMatch.Zap() */
        mcMatch.Zap();
        // * --- Select from cgo_operazioni_dl_multi
        m_cServer = m_Ctx.GetServer("cgo_operazioni_dl_multi");
        m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl_multi");
        if (Cursor_cgo_operazioni_dl_multi!=null)
          Cursor_cgo_operazioni_dl_multi.Close();
        Cursor_cgo_operazioni_dl_multi = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODDIPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowTele.CODDIPE,"?",0,0,m_cServer, m_oParameters),m_cServer,rowTele.CODDIPE)+" "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni_dl_multi")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_cgo_operazioni_dl_multi.Eof())) {
          /* nTotValide := 0 */
          nTotValide = CPLib.Round(0,0);
          /* mcMultipla.GoTop() */
          mcMultipla.GoTop();
          /* While not(mcMultipla.Eof()) */
          while ( ! (mcMultipla.Eof())) {
            /* mcMultipla.TROVATO := 'N' */
            mcMultipla.row.TROVATO = "N";
            /* mcMultipla.SaveRow() */
            mcMultipla.SaveRow();
            /* mcMultipla.Next() */
            mcMultipla.Next();
          } // End While
          for (MemoryCursorRow_mctelematicomultiple_mcrdef rwMultipla : mcMultipla._iterable_()) {
            // * --- Select from cgo_operazioni_dl_multi_dt
            m_cServer = m_Ctx.GetServer("cgo_operazioni_dl_multi_dt");
            m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl_multi_dt");
            if (Cursor_cgo_operazioni_dl_multi_dt!=null)
              Cursor_cgo_operazioni_dl_multi_dt.Close();
            Cursor_cgo_operazioni_dl_multi_dt = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SNAINUMOPE="+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi.GetString("SNAINUMOPE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni_dl_multi_dt")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_cgo_operazioni_dl_multi_dt.Eof())) {
              /* If cgo_operazioni_dl_multi_dt->CAIDBIGLIETTO=rwMultipla.CAIDBIGLIETTO and cgo_operazioni_dl_multi_dt->TIPOGIOCO=rwMultipla.TIPOGIOCO and cgo_operazioni_dl_multi_dt->TOTLIRE=rwMultipla.TOTLIRE and cgo_operazioni_dl_multi_dt->DATOPE=arfn_dt_to_date(rwMultipla.CADATAORA) */
              if (CPLib.eqr(Cursor_cgo_operazioni_dl_multi_dt.GetString("CAIDBIGLIETTO"),rwMultipla.CAIDBIGLIETTO) && CPLib.eqr(Cursor_cgo_operazioni_dl_multi_dt.GetString("TIPOGIOCO"),rwMultipla.TIPOGIOCO) && CPLib.eqr(Cursor_cgo_operazioni_dl_multi_dt.GetDouble("TOTLIRE"),rwMultipla.TOTLIRE) && CPLib.eqr(Cursor_cgo_operazioni_dl_multi_dt.GetDate("DATOPE"),arfn_dt_to_dateR.Make(m_Ctx,this).Run(rwMultipla.CADATAORA))) {
                /* nTotValide := nTotValide + 1 */
                nTotValide = CPLib.Round(nTotValide+1,0);
              } // End If
              Cursor_cgo_operazioni_dl_multi_dt.Next();
            }
            m_cConnectivityError = Cursor_cgo_operazioni_dl_multi_dt.ErrorMessage();
            Cursor_cgo_operazioni_dl_multi_dt.Close();
            // * --- End Select
          }
          /* If nTotValide > 0 */
          if (CPLib.gt(nTotValide,0)) {
            /* nRighe := 0 */
            nRighe = CPLib.Round(0,0);
            // * --- Select from cgo_operazioni_dl_multi_dt
            m_cServer = m_Ctx.GetServer("cgo_operazioni_dl_multi_dt");
            m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl_multi_dt");
            if (Cursor_cgo_operazioni_dl_multi_dt!=null)
              Cursor_cgo_operazioni_dl_multi_dt.Close();
            Cursor_cgo_operazioni_dl_multi_dt = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SNAINUMOPE="+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi.GetString("SNAINUMOPE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni_dl_multi_dt")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_cgo_operazioni_dl_multi_dt.Eof())) {
              /* nRighe := nRighe + 1 */
              nRighe = CPLib.Round(nRighe+1,0);
              Cursor_cgo_operazioni_dl_multi_dt.Next();
            }
            m_cConnectivityError = Cursor_cgo_operazioni_dl_multi_dt.ErrorMessage();
            Cursor_cgo_operazioni_dl_multi_dt.Close();
            // * --- End Select
            /* mcMatch.AppendBlank() */
            mcMatch.AppendBlank();
            /* mcMatch.SNAINUMOPE := cgo_operazioni_dl_multi->SNAINUMOPE */
            mcMatch.row.SNAINUMOPE = Cursor_cgo_operazioni_dl_multi.GetString("SNAINUMOPE");
            /* mcMatch.NUMMATCH := nTotValide */
            mcMatch.row.NUMMATCH = nTotValide;
            /* mcMatch.NUMRIGHE := nRighe */
            mcMatch.row.NUMRIGHE = nRighe;
            /* mcMatch.SaveRow() */
            mcMatch.SaveRow();
          } // End If
          Cursor_cgo_operazioni_dl_multi.Next();
        }
        m_cConnectivityError = Cursor_cgo_operazioni_dl_multi.ErrorMessage();
        Cursor_cgo_operazioni_dl_multi.Close();
        // * --- End Select
        /* If mcMatch.RecCount()=0 */
        if (CPLib.eqr(mcMatch.RecCount(),0)) {
          /* _match := 'N' */
          _match = "N";
        } else { // Else
          for (MemoryCursorRow_mcmatchope_mcrdef rwMatch : mcMatch._iterable_()) {
            /* Case rwMatch.NUMRIGHE = nTotRighe and rwMatch.NUMMATCH=nTotRighe */
            if (CPLib.eqr(rwMatch.NUMRIGHE,nTotRighe) && CPLib.eqr(rwMatch.NUMMATCH,nTotRighe)) {
              for (MemoryCursorRow_mctelematicomultiple_mcrdef rwMultipla : mcMultipla._iterable_()) {
                // * --- Select from cgo_operazioni_dl_multi_dt
                m_cServer = m_Ctx.GetServer("cgo_operazioni_dl_multi_dt");
                m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl_multi_dt");
                if (Cursor_cgo_operazioni_dl_multi_dt!=null)
                  Cursor_cgo_operazioni_dl_multi_dt.Close();
                Cursor_cgo_operazioni_dl_multi_dt = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwMatch.SNAINUMOPE,"?",0,0,m_cServer, m_oParameters),m_cServer,rwMatch.SNAINUMOPE)+" "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni_dl_multi_dt")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_cgo_operazioni_dl_multi_dt.Eof())) {
                  /* xSNAINUMOPE := cgo_operazioni_dl_multi_dt->SNAINUMOPE */
                  xSNAINUMOPE = Cursor_cgo_operazioni_dl_multi_dt.GetString("SNAINUMOPE");
                  /* If cgo_operazioni_dl_multi_dt->CAIDBIGLIETTO=rwMultipla.CAIDBIGLIETTO and cgo_operazioni_dl_multi_dt->TIPOGIOCO=rwMultipla.TIPOGIOCO and cgo_operazioni_dl_multi_dt->TOTLIRE=rwMultipla.TOTLIRE and cgo_operazioni_dl_multi_dt->DATOPE=arfn_dt_to_date(rwMultipla.CADATAORA) */
                  if (CPLib.eqr(Cursor_cgo_operazioni_dl_multi_dt.GetString("CAIDBIGLIETTO"),rwMultipla.CAIDBIGLIETTO) && CPLib.eqr(Cursor_cgo_operazioni_dl_multi_dt.GetString("TIPOGIOCO"),rwMultipla.TIPOGIOCO) && CPLib.eqr(Cursor_cgo_operazioni_dl_multi_dt.GetDouble("TOTLIRE"),rwMultipla.TOTLIRE) && CPLib.eqr(Cursor_cgo_operazioni_dl_multi_dt.GetDate("DATOPE"),arfn_dt_to_dateR.Make(m_Ctx,this).Run(rwMultipla.CADATAORA))) {
                    // * --- Write into cgo_operazioni_dl_multi_dt from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("cgo_operazioni_dl_multi_dt");
                    m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl_multi_dt");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_operazioni_dl_multi_dt",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000004CC")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"FLGFULL = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_operazioni_dl_multi_dt",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"CAIDBIGLIETTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rwMultipla.CAIDBIGLIETTO,"?",0,0,m_cServer),m_cServer,rwMultipla.CAIDBIGLIETTO)+"";
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
                  Cursor_cgo_operazioni_dl_multi_dt.Next();
                }
                m_cConnectivityError = Cursor_cgo_operazioni_dl_multi_dt.ErrorMessage();
                Cursor_cgo_operazioni_dl_multi_dt.Close();
                // * --- End Select
              }
              /* cProgImp := LRTrim(rwMatch.SNAINUMOPE) */
              cProgImp = CPLib.LRTrim(rwMatch.SNAINUMOPE);
              /* _match := 'S' */
              _match = "S";
              // Exit Loop
              if (true) {
                break;
              }
              /* Case rwMatch.NUMRIGHE > nTotRighe and rwMatch.NUMMATCH=nTotRighe */
            } else if (CPLib.gt(rwMatch.NUMRIGHE,nTotRighe) && CPLib.eqr(rwMatch.NUMMATCH,nTotRighe)) {
              for (MemoryCursorRow_mctelematicomultiple_mcrdef rwMultipla : mcMultipla._iterable_()) {
                // * --- Select from cgo_operazioni_dl_multi_dt
                m_cServer = m_Ctx.GetServer("cgo_operazioni_dl_multi_dt");
                m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl_multi_dt");
                if (Cursor_cgo_operazioni_dl_multi_dt!=null)
                  Cursor_cgo_operazioni_dl_multi_dt.Close();
                Cursor_cgo_operazioni_dl_multi_dt = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwMatch.SNAINUMOPE,"?",0,0,m_cServer, m_oParameters),m_cServer,rwMatch.SNAINUMOPE)+" "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni_dl_multi_dt")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_cgo_operazioni_dl_multi_dt.Eof())) {
                  /* xSNAINUMOPE := cgo_operazioni_dl_multi_dt->SNAINUMOPE */
                  xSNAINUMOPE = Cursor_cgo_operazioni_dl_multi_dt.GetString("SNAINUMOPE");
                  /* If cgo_operazioni_dl_multi_dt->CAIDBIGLIETTO=rwMultipla.CAIDBIGLIETTO and cgo_operazioni_dl_multi_dt->TIPOGIOCO=rwMultipla.TIPOGIOCO and cgo_operazioni_dl_multi_dt->TOTLIRE=rwMultipla.TOTLIRE and cgo_operazioni_dl_multi_dt->DATOPE=arfn_dt_to_date(rwMultipla.CADATAORA) */
                  if (CPLib.eqr(Cursor_cgo_operazioni_dl_multi_dt.GetString("CAIDBIGLIETTO"),rwMultipla.CAIDBIGLIETTO) && CPLib.eqr(Cursor_cgo_operazioni_dl_multi_dt.GetString("TIPOGIOCO"),rwMultipla.TIPOGIOCO) && CPLib.eqr(Cursor_cgo_operazioni_dl_multi_dt.GetDouble("TOTLIRE"),rwMultipla.TOTLIRE) && CPLib.eqr(Cursor_cgo_operazioni_dl_multi_dt.GetDate("DATOPE"),arfn_dt_to_dateR.Make(m_Ctx,this).Run(rwMultipla.CADATAORA))) {
                    // * --- Write into cgo_operazioni_dl_multi_dt from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("cgo_operazioni_dl_multi_dt");
                    m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl_multi_dt");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_operazioni_dl_multi_dt",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000004D4")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"FLGFULL = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_operazioni_dl_multi_dt",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"CAIDBIGLIETTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rwMultipla.CAIDBIGLIETTO,"?",0,0,m_cServer),m_cServer,rwMultipla.CAIDBIGLIETTO)+"";
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
                  Cursor_cgo_operazioni_dl_multi_dt.Next();
                }
                m_cConnectivityError = Cursor_cgo_operazioni_dl_multi_dt.ErrorMessage();
                Cursor_cgo_operazioni_dl_multi_dt.Close();
                // * --- End Select
              }
              /* cProgImp := LRTrim(rwMatch.SNAINUMOPE) */
              cProgImp = CPLib.LRTrim(rwMatch.SNAINUMOPE);
              /* _match := 'S' */
              _match = "S";
              // Exit Loop
              if (true) {
                break;
              }
            } else { // Otherwise
              /* _match := 'N' */
              _match = "N";
            } // End Case
          }
        } // End If
        /* If _match='N' */
        if (CPLib.eqr(_match,"N")) {
          // * --- Select from cgo_operazioni_storico
          m_cServer = m_Ctx.GetServer("cgo_operazioni_storico");
          m_cPhName = m_Ctx.GetPhName("cgo_operazioni_storico");
          if (Cursor_cgo_operazioni_storico!=null)
            Cursor_cgo_operazioni_storico.Close();
          Cursor_cgo_operazioni_storico = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODDIPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowTele.CODDIPE,"?",0,0,m_cServer, m_oParameters),m_cServer,rowTele.CODDIPE)+"  and  TIPOGIOCO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowTele.TIPOGIOCO,"?",0,0,m_cServer, m_oParameters),m_cServer,rowTele.TIPOGIOCO)+"  and  DATAOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_datope,"?",0,0,m_cServer, m_oParameters),m_cServer,_datope)+" "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni_storico")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_cgo_operazioni_storico.Eof())) {
            /* nTotValide := 0 */
            nTotValide = CPLib.Round(0,0);
            /* nRigheSto := 0 */
            nRigheSto = CPLib.Round(0,0);
            /* xSNAINUMOPE := cgo_operazioni_storico->SNAINUMOPE */
            xSNAINUMOPE = Cursor_cgo_operazioni_storico.GetString("SNAINUMOPE");
            /* _idbiglietto := cgo_operazioni_storico->CAIDBIGLIETTO */
            _idbiglietto = Cursor_cgo_operazioni_storico.GetString("CAIDBIGLIETTO");
            for (MemoryCursorRow_mctelematicomultiple_mcrdef rwMultipla : mcMultipla._iterable_()) {
              // * --- Select from cgo_operazioni_storico_multi
              m_cServer = m_Ctx.GetServer("cgo_operazioni_storico_multi");
              m_cPhName = m_Ctx.GetPhName("cgo_operazioni_storico_multi");
              if (Cursor_cgo_operazioni_storico_multi!=null)
                Cursor_cgo_operazioni_storico_multi.Close();
              Cursor_cgo_operazioni_storico_multi = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SNAINUMOPE="+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("SNAINUMOPE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni_storico_multi")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_cgo_operazioni_storico_multi.Eof())) {
                /* nRigheSto := nRigheSto + 1 */
                nRigheSto = CPLib.Round(nRigheSto+1,0);
                /* If cgo_operazioni_storico_multi->CAIDBIGLIETTO=rwMultipla.CAIDBIGLIETTO and cgo_operazioni_storico_multi->TIPOGIOCO=rwMultipla.TIPOGIOCO and cgo_operazioni_storico_multi->TOTLIRE=rwMultipla.TOTLIRE and cgo_operazioni_storico_multi->DATOPE=arfn_dt_to_date(rwMultipla.CADATAORA) */
                if (CPLib.eqr(Cursor_cgo_operazioni_storico_multi.GetString("CAIDBIGLIETTO"),rwMultipla.CAIDBIGLIETTO) && CPLib.eqr(Cursor_cgo_operazioni_storico_multi.GetString("TIPOGIOCO"),rwMultipla.TIPOGIOCO) && CPLib.eqr(Cursor_cgo_operazioni_storico_multi.GetDouble("TOTLIRE"),rwMultipla.TOTLIRE) && CPLib.eqr(Cursor_cgo_operazioni_storico_multi.GetDate("DATOPE"),arfn_dt_to_dateR.Make(m_Ctx,this).Run(rwMultipla.CADATAORA))) {
                  /* nTotValide := nTotValide + 1 */
                  nTotValide = CPLib.Round(nTotValide+1,0);
                } // End If
                Cursor_cgo_operazioni_storico_multi.Next();
              }
              m_cConnectivityError = Cursor_cgo_operazioni_storico_multi.ErrorMessage();
              Cursor_cgo_operazioni_storico_multi.Close();
              // * --- End Select
            }
            /* If nTotValide > 0 */
            if (CPLib.gt(nTotValide,0)) {
              // Exit Loop
              if (true) {
                break;
              }
            } // End If
            Cursor_cgo_operazioni_storico.Next();
          }
          m_cConnectivityError = Cursor_cgo_operazioni_storico.ErrorMessage();
          Cursor_cgo_operazioni_storico.Close();
          // * --- End Select
          /* If nTotValide <> nTotRighe */
          if (CPLib.ne(nTotValide,nTotRighe)) {
            for (MemoryCursorRow_cgo_tbtipgio rwTBTIPGIO : mcTBTIPGIO._iterable_()) {
              /* If rwTBTIPGIO.CODTPGIO=_defmul */
              if (CPLib.eqr(rwTBTIPGIO.CODTPGIO,_defmul)) {
                /* If rowTele.TOTLIRE < rwTBTIPGIO.SOGTPGIO */
                if (CPLib.lt(rowTele.TOTLIRE,rwTBTIPGIO.SOGTPGIO)) {
                  /* _flgvlt := rwTBTIPGIO.DEFTPGIO */
                  _flgvlt = rwTBTIPGIO.DEFTPGIO;
                } else { // Else
                  /* _flgvlt := rwTBTIPGIO.DEFSPGIO */
                  _flgvlt = rwTBTIPGIO.DEFSPGIO;
                } // End If
              } // End If
            }
            /* nProgOpe := Utilities.GetAutonumber("PRGNUMOPE\'"+LRTrim(_gAzienda)+"'","",15) */
            nProgOpe = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGNUMOPE\\'"+CPLib.LRTrim(_gAzienda)+"'","",15);
            // * --- Insert into cgo_operazioni_dl_multi_dc from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cgo_operazioni_dl_multi_dc");
            m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl_multi_dc");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_operazioni_dl_multi_dc",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000004EE")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000004EE(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(_numass,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTele.CACODICE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_cadataora,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_flgope,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTele.CAIDBIGLIETTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_capv_cod,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_catipcon,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_catipgio,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_flgvlt,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_flgvnp,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTele.ENV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_codana,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_cabinter,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTele.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTele.CODLOB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_codsin,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_citinter,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_tiporap,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.nextUID(),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_prvinter,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTele.RAPPORTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(nProgOpe,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_defmul,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_tipope,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTele.TOTLIRE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_vpcodice,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_operazioni_dl_multi_dc",true);
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
            /* Exec Routine arrt_writelog('IMPORT DATI','CGO_OPERAZIONI',nProgOpe,'Inserimento operazione multipla da completare',"S") */
            arrt_writelogR.Make(m_Ctx,this).Run("IMPORT DATI","CGO_OPERAZIONI",nProgOpe,"Inserimento operazione multipla da completare","S");
            /* _criga := 1 */
            _criga = CPLib.Round(1,0);
            // * --- Select from cgo_telematico_multipla
            m_cServer = m_Ctx.GetServer("cgo_telematico_multipla");
            m_cPhName = m_Ctx.GetPhName("cgo_telematico_multipla");
            if (Cursor_cgo_telematico_multipla!=null)
              Cursor_cgo_telematico_multipla.Close();
            Cursor_cgo_telematico_multipla = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowTele.SNAINUMOPE,"?",0,0,m_cServer, m_oParameters),m_cServer,rowTele.SNAINUMOPE)+" "+")"+(m_Ctx.IsSharedTemp("cgo_telematico_multipla")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_cgo_telematico_multipla.Eof())) {
              // * --- Insert into cgo_operazioni_dl_multi_dt_dc from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cgo_operazioni_dl_multi_dt_dc");
              m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl_multi_dt_dc");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_operazioni_dl_multi_dt_dc",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000004F2")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000004F2(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgOpe,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_criga,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico_multipla.GetString("CAIDBIGLIETTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico_multipla.GetDouble("TOTLIRE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(arfn_dt_to_dateR.Make(m_Ctx,this).Run(Cursor_cgo_telematico_multipla.GetDateTime("CADATAORA")),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico_multipla.GetDouble("CACODICE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico_multipla.GetString("CODLOB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico_multipla.GetString("TIPOGIOCO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico_multipla.GetDouble("CATIPGIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico_multipla.GetDouble("CATIPCON"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico_multipla.GetString("ENV"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_operazioni_dl_multi_dt_dc",true);
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
              /* _criga := _criga + 1 */
              _criga = CPLib.Round(_criga+1,0);
              Cursor_cgo_telematico_multipla.Next();
            }
            m_cConnectivityError = Cursor_cgo_telematico_multipla.ErrorMessage();
            Cursor_cgo_telematico_multipla.Close();
            // * --- End Select
            /* If nTotRighe > nTotValide and nTotValide > 0 */
            if (CPLib.gt(nTotRighe,nTotValide) && CPLib.gt(nTotValide,0)) {
              // * --- Delete from cgo_operazioni_storico_multi
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cgo_operazioni_storico_multi");
              m_cPhName = m_Ctx.GetPhName("cgo_operazioni_storico_multi");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_operazioni_storico_multi",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000004F5")+"delete from "+m_oWrInfo.GetTableWriteName();
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"SNAINUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(xSNAINUMOPE,"?",0,0,m_cServer),m_cServer,xSNAINUMOPE)+"";
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
              // * --- Delete from cgo_operazioni_storico
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cgo_operazioni_storico");
              m_cPhName = m_Ctx.GetPhName("cgo_operazioni_storico");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_operazioni_storico",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000004F6")+"delete from "+m_oWrInfo.GetTableWriteName();
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"SNAINUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(xSNAINUMOPE,"?",0,0,m_cServer),m_cServer,xSNAINUMOPE)+"";
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
              /* _idbase := '' */
              _idbase = "";
              // * --- Read from xperazbo_agg
              m_cServer = m_Ctx.GetServer("xperazbo_agg");
              m_cPhName = m_Ctx.GetPhName("xperazbo_agg");
              m_cSql = "";
              m_cSql = m_cSql+"IDBIGLIETTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idbiglietto,"C",30,0,m_cServer),m_cServer,_idbiglietto);
              if (m_Ctx.IsSharedTemp("xperazbo_agg")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _idbase = Read_Cursor.GetString("IDBASE");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on xperazbo_agg into routine arrt_imp_dati_cgo_sched_tabs returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _idbase = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(_idbase) */
              if (CPLib.Empty(_idbase)) {
                // * --- Read from operazbo_agg
                m_cServer = m_Ctx.GetServer("operazbo_agg");
                m_cPhName = m_Ctx.GetPhName("operazbo_agg");
                m_cSql = "";
                m_cSql = m_cSql+"IDBIGLIETTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idbiglietto,"C",30,0,m_cServer),m_cServer,_idbiglietto);
                if (m_Ctx.IsSharedTemp("operazbo_agg")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _idbase = Read_Cursor.GetString("IDBASE");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on operazbo_agg into routine arrt_imp_dati_cgo_sched_tabs returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _idbase = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If not(Empty(_idbase)) */
                if ( ! (CPLib.Empty(_idbase))) {
                  // * --- Write into operazbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("operazbo");
                  m_cPhName = m_Ctx.GetPhName("operazbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000004FC")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL("2","C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATARETT = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_idbase,"?",0,0,m_cServer),m_cServer,_idbase)+"";
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
              } else { // Else
                // * --- Delete from xperazbo_agg
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("xperazbo_agg");
                m_cPhName = m_Ctx.GetPhName("xperazbo_agg");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo_agg",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000004FD")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_idbase,"?",0,0,m_cServer),m_cServer,_idbase)+"";
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
                // * --- Delete from xperazbo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("xperazbo");
                m_cPhName = m_Ctx.GetPhName("xperazbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000004FE")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_idbase,"?",0,0,m_cServer),m_cServer,_idbase)+"";
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
          } else { // Else
            /* mNumero := mNumero + 1 */
            mNumero = CPLib.Round(mNumero+1,0);
          } // End If
        } else { // Else
          /* mNumero := mNumero + 1 */
          mNumero = CPLib.Round(mNumero+1,0);
          /* Exec Routine arrt_cgo_save_multi_dl(xSNAINUMOPE,_gAzienda) */
          arrt_cgo_save_multi_dlR.Make(m_Ctx,this).Run(xSNAINUMOPE,_gAzienda);
        } // End If
        /* oNumero := oNumero + 1 */
        oNumero = CPLib.Round(oNumero+1,0);
      } // End If
    } finally {
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
        if (Cursor_cgo_operazioni_dl!=null)
          Cursor_cgo_operazioni_dl.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_cgo_operazioni_dl_multi!=null)
          Cursor_cgo_operazioni_dl_multi.Close();
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
        if (Cursor_cgo_telematico_multipla!=null)
          Cursor_cgo_telematico_multipla.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_cgo_operazioni_storico!=null)
          Cursor_cgo_operazioni_storico.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_cgo_operazioni_storico_multi!=null)
          Cursor_cgo_operazioni_storico_multi.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_9() throws Exception {
    CPResultSet Cursor_cgo_telematico=null;
    CPResultSet Cursor_cgo_operazioni_dl_multi=null;
    CPResultSet Cursor_cgo_operazioni_dl_multi_dt=null;
    CPResultSet Cursor_cgo_operazioni_dl=null;
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
      // * --- Select from cgo_telematico
      m_cServer = m_Ctx.GetServer("cgo_telematico");
      m_cPhName = m_Ctx.GetPhName("cgo_telematico");
      if (Cursor_cgo_telematico!=null)
        Cursor_cgo_telematico.Close();
      Cursor_cgo_telematico = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numopetele,"?",0,0,m_cServer, m_oParameters),m_cServer,_numopetele)+" "+")"+(m_Ctx.IsSharedTemp("cgo_telematico")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_cgo_telematico.Eof())) {
        /* If _omulti='S' */
        if (CPLib.eqr(_omulti,"S")) {
          /* If cgo_telematico->TOTLIRE > 1000 */
          if (CPLib.gt(Cursor_cgo_telematico.GetDouble("TOTLIRE"),1000)) {
            // * --- Select from cgo_operazioni_dl_multi
            m_cServer = m_Ctx.GetServer("cgo_operazioni_dl_multi");
            m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl_multi");
            if (Cursor_cgo_operazioni_dl_multi!=null)
              Cursor_cgo_operazioni_dl_multi.Close();
            Cursor_cgo_operazioni_dl_multi = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numope,"?",0,0,m_cServer, m_oParameters),m_cServer,_numope)+" "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni_dl_multi")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_cgo_operazioni_dl_multi.Eof())) {
              // * --- Select from cgo_operazioni_dl_multi_dt
              m_cServer = m_Ctx.GetServer("cgo_operazioni_dl_multi_dt");
              m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl_multi_dt");
              if (Cursor_cgo_operazioni_dl_multi_dt!=null)
                Cursor_cgo_operazioni_dl_multi_dt.Close();
              Cursor_cgo_operazioni_dl_multi_dt = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numope,"?",0,0,m_cServer, m_oParameters),m_cServer,_numope)+"  and  CAIDBIGLIETTO="+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CAIDBIGLIETTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni_dl_multi_dt")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_cgo_operazioni_dl_multi_dt.Eof())) {
                /* xData := Left(DateTimeToChar(cgo_telematico->CADATAORA),8) */
                xData = CPLib.Left(CPLib.DateTimeToChar(Cursor_cgo_telematico.GetDateTime("CADATAORA")),8);
                /* _cauana := '' */
                _cauana = "";
                /* _causin := '' */
                _causin = "";
                /* _segno := '' */
                _segno = "";
                /* _mezpagam := iif(LRTrim(cgo_operazioni_dl_multi->MEZPAGAM) <> 'I' and LRTrim(cgo_operazioni_dl_multi->MEZPAGAM) <> 'E','A',LRTrim(cgo_operazioni_dl_multi->MEZPAGAM)) */
                _mezpagam = (CPLib.ne(CPLib.LRTrim(Cursor_cgo_operazioni_dl_multi.GetString("MEZPAGAM")),"I") && CPLib.ne(CPLib.LRTrim(Cursor_cgo_operazioni_dl_multi.GetString("MEZPAGAM")),"E")?"A":CPLib.LRTrim(Cursor_cgo_operazioni_dl_multi.GetString("MEZPAGAM")));
                /* If mcCAUSALI.HasKey(Str(cgo_telematico->CACODICE,5,0)+_mezpagam) */
                if (mcCAUSALI.HasKey(CPLib.Str(Cursor_cgo_telematico.GetDouble("CACODICE"),5,0)+_mezpagam)) {
                  /* If mcCAUSALI.GoToKey(Str(cgo_telematico->CACODICE,5,0)+_mezpagam) */
                  if (mcCAUSALI.GoToKey(CPLib.Str(Cursor_cgo_telematico.GetDouble("CACODICE"),5,0)+_mezpagam)) {
                    /* _codana := mcCAUSALI.CACODANA */
                    _codana = mcCAUSALI.row.CACODANA;
                    /* _codsin := mcCAUSALI.CACODSIN */
                    _codsin = mcCAUSALI.row.CACODSIN;
                    /* _segno := mcCAUSALI.CASEGNO */
                    _segno = mcCAUSALI.row.CASEGNO;
                  } // End If
                } // End If
                /* If _cauana <> '26' and _cauana <> '48' and _cauana <> 'AA' */
                if (CPLib.ne(_cauana,"26") && CPLib.ne(_cauana,"48") && CPLib.ne(_cauana,"AA")) {
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
                /* If False */
                if (false) {
                  /* cOpeProg1 := Utilities.GetAutonumber("PRGAAMS1\'"+LRTrim(_gAzienda)+"'",'',10) */
                  cOpeProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGAAMS1\\'"+CPLib.LRTrim(_gAzienda)+"'","",10);
                  /* cOpeProg2 := Utilities.GetAutonumber("PRGAAMS2\'"+LRTrim(_gAzienda)+"'",'',11) */
                  cOpeProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGAAMS2\\'"+CPLib.LRTrim(_gAzienda)+"'","",11);
                  /* nProgImp := Utilities.GetAutonumber("PRGAAMS3\'"+LRTrim(_gAzienda)+"'",0,15) */
                  nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGAAMS3\\'"+CPLib.LRTrim(_gAzienda)+"'",0,15),0);
                  // * --- Insert into cgo_aams_base from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("cgo_aams_base");
                  m_cPhName = m_Ctx.GetPhName("cgo_aams_base");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_aams_base",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000520")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000520(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_cgo_operazioni_dl_multi.GetDate("DATAREG")),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_cauana,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_causin,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(xData),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi.GetDate("DATAREG"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_cgo_operazioni_dl_multi.GetDate("DATAOPE"))+cOpeProg2+"Z","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CAIDBIGLIETTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_tipope,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi.GetDouble("TOTCONT")*100,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("TOTLIRE")*100,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_aams_base",true);
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
                  /* If cgo_operazioni_dl_multi->MEZPAGAM='I' or cgo_operazioni_dl_multi->MEZPAGAM='E' or cgo_operazioni_dl_multi->MEZPAGAM='P' */
                  if (CPLib.eqr(Cursor_cgo_operazioni_dl_multi.GetString("MEZPAGAM"),"I") || CPLib.eqr(Cursor_cgo_operazioni_dl_multi.GetString("MEZPAGAM"),"E") || CPLib.eqr(Cursor_cgo_operazioni_dl_multi.GetString("MEZPAGAM"),"P")) {
                    /* If Left(Upper(cgo_operazioni_dl_multi->IBAN),2)='IT' */
                    if (CPLib.eqr(CPLib.Left(CPLib.Upper(Cursor_cgo_operazioni_dl_multi.GetString("IBAN")),2),"IT")) {
                      /* abicab := Substr(cgo_operazioni_dl_multi->IBAN,6,5)+"-"+Substr(cgo_operazioni_dl_multi->IBAN,11,5) */
                      abicab = CPLib.Substr(Cursor_cgo_operazioni_dl_multi.GetString("IBAN"),6,5)+"-"+CPLib.Substr(Cursor_cgo_operazioni_dl_multi.GetString("IBAN"),11,5);
                      // * --- Write into cgo_aams_base from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("cgo_aams_base");
                      m_cPhName = m_Ctx.GetPhName("cgo_aams_base");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_aams_base",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000524")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"CODINT2 = "+CPLib.ToSQL(abicab,"C",11,0,m_cServer)+", ";
                      m_cSql = m_cSql+"TIPOINT2 = "+CPLib.ToSQL("02","C",2,0,m_cServer)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_aams_base",false,true);
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
                      /* If mcINTER2BO.HasKey(abicab) */
                      if (mcINTER2BO.HasKey(abicab)) {
                        /* If mcINTER2BO.GoToKey(abicab) */
                        if (mcINTER2BO.GoToKey(abicab)) {
                          // * --- Write into cgo_aams_base from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("cgo_aams_base");
                          m_cPhName = m_Ctx.GetPhName("cgo_aams_base");
                          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_aams_base",m_Ctx.GetCompany());
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000527")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                          m_cSql = m_cSql+"TIPOINT2 = "+CPLib.ToSQL(mcINTER2BO.row.TIPINTER,"C",2,0,m_cServer)+", ";
                          m_cSql = m_cSql+"CODINT2 = "+CPLib.ToSQL(abicab,"C",11,0,m_cServer)+", ";
                          m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(mcINTER2BO.row.PAESE,"C",3,0,m_cServer)+", ";
                          m_cSql = m_cSql+"DESC2 = "+CPLib.ToSQL(mcINTER2BO.row.DESCCIT,"C",30,0,m_cServer)+", ";
                          m_cSql = m_cSql+"PROV2 = "+CPLib.ToSQL(mcINTER2BO.row.PROVINCIA,"C",2,0,m_cServer)+", ";
                          m_cSql = m_cSql+"CODCAB2 = "+CPLib.ToSQL(mcINTER2BO.row.CODCAB,"C",6,0,m_cServer)+", ";
                          m_cSql = m_cSql+"DESCINTER = "+CPLib.ToSQL(mcINTER2BO.row.RAGSOC,"C",50,0,m_cServer)+", ";
                          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_aams_base",false,true);
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
                      } // End If
                    } else { // Else
                      /* abicab := Left(Upper(cgo_operazioni_dl_multi->IBAN),11) */
                      abicab = CPLib.Left(CPLib.Upper(Cursor_cgo_operazioni_dl_multi.GetString("IBAN")),11);
                      // * --- Write into cgo_aams_base from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("cgo_aams_base");
                      m_cPhName = m_Ctx.GetPhName("cgo_aams_base");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_aams_base",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000529")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"CODINT2 = "+CPLib.ToSQL(abicab,"C",11,0,m_cServer)+", ";
                      m_cSql = m_cSql+"TIPOINT2 = "+CPLib.ToSQL("12","C",2,0,m_cServer)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_aams_base",false,true);
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
                  } // End If
                } // End If
                Cursor_cgo_operazioni_dl_multi_dt.Next();
              }
              m_cConnectivityError = Cursor_cgo_operazioni_dl_multi_dt.ErrorMessage();
              Cursor_cgo_operazioni_dl_multi_dt.Close();
              // * --- End Select
              Cursor_cgo_operazioni_dl_multi.Next();
            }
            m_cConnectivityError = Cursor_cgo_operazioni_dl_multi.ErrorMessage();
            Cursor_cgo_operazioni_dl_multi.Close();
            // * --- End Select
          } // End If
        } else { // Else
          // * --- Select from cgo_operazioni_dl
          m_cServer = m_Ctx.GetServer("cgo_operazioni_dl");
          m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl");
          if (Cursor_cgo_operazioni_dl!=null)
            Cursor_cgo_operazioni_dl.Close();
          Cursor_cgo_operazioni_dl = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numope,"?",0,0,m_cServer, m_oParameters),m_cServer,_numope)+" "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni_dl")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_cgo_operazioni_dl.Eof())) {
            /* xData := Left(DateTimeToChar(cgo_telematico->CADATAORA),8) */
            xData = CPLib.Left(CPLib.DateTimeToChar(Cursor_cgo_telematico.GetDateTime("CADATAORA")),8);
            /* _cauana := '' */
            _cauana = "";
            /* _causin := '' */
            _causin = "";
            /* _segno := '' */
            _segno = "";
            /* _mezpagam := iif(LRTrim(cgo_operazioni_dl->MEZPAGAM) <> 'I' and LRTrim(cgo_operazioni_dl->MEZPAGAM) <> 'E','A',LRTrim(cgo_operazioni_dl->MEZPAGAM)) */
            _mezpagam = (CPLib.ne(CPLib.LRTrim(Cursor_cgo_operazioni_dl.GetString("MEZPAGAM")),"I") && CPLib.ne(CPLib.LRTrim(Cursor_cgo_operazioni_dl.GetString("MEZPAGAM")),"E")?"A":CPLib.LRTrim(Cursor_cgo_operazioni_dl.GetString("MEZPAGAM")));
            /* If mcCAUSALI.HasKey(Str(cgo_telematico->CACODICE,5,0)+_mezpagam) */
            if (mcCAUSALI.HasKey(CPLib.Str(Cursor_cgo_telematico.GetDouble("CACODICE"),5,0)+_mezpagam)) {
              /* If mcCAUSALI.GoToKey(Str(cgo_telematico->CACODICE,5,0)+_mezpagam) */
              if (mcCAUSALI.GoToKey(CPLib.Str(Cursor_cgo_telematico.GetDouble("CACODICE"),5,0)+_mezpagam)) {
                /* _codana := mcCAUSALI.CACODANA */
                _codana = mcCAUSALI.row.CACODANA;
                /* _codsin := mcCAUSALI.CACODSIN */
                _codsin = mcCAUSALI.row.CACODSIN;
                /* _segno := mcCAUSALI.CASEGNO */
                _segno = mcCAUSALI.row.CASEGNO;
              } // End If
            } // End If
            /* If _cauana <> '26' and _cauana <> '48' and _cauana <> 'AA' */
            if (CPLib.ne(_cauana,"26") && CPLib.ne(_cauana,"48") && CPLib.ne(_cauana,"AA")) {
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
            /* If False */
            if (false) {
              /* cOpeProg1 := Utilities.GetAutonumber("PRGAAMS1\'"+LRTrim(_gAzienda)+"'",'',10) */
              cOpeProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGAAMS1\\'"+CPLib.LRTrim(_gAzienda)+"'","",10);
              /* cOpeProg2 := Utilities.GetAutonumber("PRGAAMS2\'"+LRTrim(_gAzienda)+"'",'',11) */
              cOpeProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGAAMS2\\'"+CPLib.LRTrim(_gAzienda)+"'","",11);
              /* nProgImp := Utilities.GetAutonumber("PRGAAMS3\'"+LRTrim(_gAzienda)+"'",0,15) */
              nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGAAMS3\\'"+CPLib.LRTrim(_gAzienda)+"'",0,15),0);
              // * --- Insert into cgo_aams_base from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cgo_aams_base");
              m_cPhName = m_Ctx.GetPhName("cgo_aams_base");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_aams_base",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"0000053E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000053E(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_cgo_operazioni_dl.GetDate("DATAREG")),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cauana,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_causin,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(xData),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_cgo_operazioni_dl.GetDate("DATAOPE"))+cOpeProg2+"Z","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CAIDBIGLIETTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tipope,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl.GetDouble("TOTCONT")*100,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetDouble("TOTLIRE")*100,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_aams_base",true);
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
              /* If cgo_operazioni_dl->MEZPAGAM='I' or cgo_operazioni_dl->MEZPAGAM='E' or cgo_operazioni_dl->MEZPAGAM='P' */
              if (CPLib.eqr(Cursor_cgo_operazioni_dl.GetString("MEZPAGAM"),"I") || CPLib.eqr(Cursor_cgo_operazioni_dl.GetString("MEZPAGAM"),"E") || CPLib.eqr(Cursor_cgo_operazioni_dl.GetString("MEZPAGAM"),"P")) {
                /* If Left(Upper(cgo_operazioni_dl->IBAN),2)='IT' */
                if (CPLib.eqr(CPLib.Left(CPLib.Upper(Cursor_cgo_operazioni_dl.GetString("IBAN")),2),"IT")) {
                  /* abicab := Substr(cgo_operazioni_dl->IBAN,6,5)+"-"+Substr(cgo_operazioni_dl->IBAN,11,5) */
                  abicab = CPLib.Substr(Cursor_cgo_operazioni_dl.GetString("IBAN"),6,5)+"-"+CPLib.Substr(Cursor_cgo_operazioni_dl.GetString("IBAN"),11,5);
                  // * --- Write into cgo_aams_base from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("cgo_aams_base");
                  m_cPhName = m_Ctx.GetPhName("cgo_aams_base");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_aams_base",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000542")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"CODINT2 = "+CPLib.ToSQL(abicab,"C",11,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPOINT2 = "+CPLib.ToSQL("02","C",2,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_aams_base",false,true);
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
                  /* If mcINTER2BO.HasKey(abicab) */
                  if (mcINTER2BO.HasKey(abicab)) {
                    /* If mcINTER2BO.GoToKey(abicab) */
                    if (mcINTER2BO.GoToKey(abicab)) {
                      // * --- Write into cgo_aams_base from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("cgo_aams_base");
                      m_cPhName = m_Ctx.GetPhName("cgo_aams_base");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_aams_base",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000545")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"TIPOINT2 = "+CPLib.ToSQL(mcINTER2BO.row.TIPINTER,"C",2,0,m_cServer)+", ";
                      m_cSql = m_cSql+"CODINT2 = "+CPLib.ToSQL(abicab,"C",11,0,m_cServer)+", ";
                      m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(mcINTER2BO.row.PAESE,"C",3,0,m_cServer)+", ";
                      m_cSql = m_cSql+"DESC2 = "+CPLib.ToSQL(mcINTER2BO.row.DESCCIT,"C",30,0,m_cServer)+", ";
                      m_cSql = m_cSql+"PROV2 = "+CPLib.ToSQL(mcINTER2BO.row.PROVINCIA,"C",2,0,m_cServer)+", ";
                      m_cSql = m_cSql+"CODCAB2 = "+CPLib.ToSQL(mcINTER2BO.row.CODCAB,"C",6,0,m_cServer)+", ";
                      m_cSql = m_cSql+"DESCINTER = "+CPLib.ToSQL(mcINTER2BO.row.RAGSOC,"C",50,0,m_cServer)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_aams_base",false,true);
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
                  } // End If
                } else { // Else
                  /* abicab := Left(Upper(cgo_operazioni_dl->IBAN),11) */
                  abicab = CPLib.Left(CPLib.Upper(Cursor_cgo_operazioni_dl.GetString("IBAN")),11);
                  // * --- Write into cgo_aams_base from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("cgo_aams_base");
                  m_cPhName = m_Ctx.GetPhName("cgo_aams_base");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_aams_base",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000547")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"CODINT2 = "+CPLib.ToSQL(abicab,"C",11,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPOINT2 = "+CPLib.ToSQL("12","C",2,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_aams_base",false,true);
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
              } // End If
            } // End If
            Cursor_cgo_operazioni_dl.Next();
          }
          m_cConnectivityError = Cursor_cgo_operazioni_dl.ErrorMessage();
          Cursor_cgo_operazioni_dl.Close();
          // * --- End Select
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
        if (Cursor_cgo_operazioni_dl_multi!=null)
          Cursor_cgo_operazioni_dl_multi.Close();
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
        if (Cursor_cgo_operazioni_dl!=null)
          Cursor_cgo_operazioni_dl.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_10() throws Exception {
    CPResultSet Cursor_cgo_telematico=null;
    CPResultSet Cursor_anadip=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_xntestbo=null;
    CPResultSet Cursor_personbo=null;
    try {
      /* Scrive le operazioni corrette */
      // * --- Select from cgo_telematico
      m_cServer = m_Ctx.GetServer("cgo_telematico");
      m_cPhName = m_Ctx.GetPhName("cgo_telematico");
      if (Cursor_cgo_telematico!=null)
        Cursor_cgo_telematico.Close();
      Cursor_cgo_telematico = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numopetele,"?",0,0,m_cServer, m_oParameters),m_cServer,_numopetele)+" "+")"+(m_Ctx.IsSharedTemp("cgo_telematico")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_cgo_telematico.Eof())) {
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
            Error l_oErrorFault = new Error("Read on anarapbo into routine arrt_imp_dati_cgo_sched_tabs returns two or more records. This item should return only a record.");
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
              Error l_oErrorFault = new Error("Read on xnarapbo into routine arrt_imp_dati_cgo_sched_tabs returns two or more records. This item should return only a record.");
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
        /* If mcCAUSALI.HasKey(Str(cgo_telematico->CACODICE,5,0)+_mezpagam) */
        if (mcCAUSALI.HasKey(CPLib.Str(Cursor_cgo_telematico.GetDouble("CACODICE"),5,0)+_mezpagam)) {
          /* If mcCAUSALI.GoToKey(Str(cgo_telematico->CACODICE,5,0)+_mezpagam) */
          if (mcCAUSALI.GoToKey(CPLib.Str(Cursor_cgo_telematico.GetDouble("CACODICE"),5,0)+_mezpagam)) {
            /* _codana := mcCAUSALI.CACODANA */
            _codana = mcCAUSALI.row.CACODANA;
            /* _codsin := mcCAUSALI.CACODSIN */
            _codsin = mcCAUSALI.row.CACODSIN;
            /* _segno := mcCAUSALI.CASEGNO */
            _segno = mcCAUSALI.row.CASEGNO;
          } // End If
        } // End If
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
        /* _tottele := cgo_telematico->TOTLIRE */
        _tottele = CPLib.Round(Cursor_cgo_telematico.GetDouble("TOTLIRE"),0);
        /* _codlob := cgo_telematico->CODLOB */
        _codlob = Cursor_cgo_telematico.GetString("CODLOB");
        /* _tipgio := cgo_telematico->TIPOGIOCO */
        _tipgio = Cursor_cgo_telematico.GetString("TIPOGIOCO");
        /* _cacodice := cgo_telematico->CACODICE */
        _cacodice = CPLib.Round(Cursor_cgo_telematico.GetDouble("CACODICE"),0);
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
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000573")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000573(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.le(CPLib.DateToChar(_datope),"20120531")?"20120601":CPLib.DateToChar(arfn_datesumR.Make(m_Ctx,this).Run(_datope,1))),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codana,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cabinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codsin,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.le(CPLib.DateToChar(_datope),"20120531")?CPLib.CharToDate("20120601"):arfn_datesumR.Make(m_Ctx,this).Run(_datope,1)),"?",0,0)+", ";
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
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000578")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
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
                  } else { // Else
                    // * --- Insert into xlientiope from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("xlientiope");
                    m_cPhName = m_Ctx.GetPhName("xlientiope");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xlientiope",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000579")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_00000579(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
                    }
                  } // End If
                  /* nIntest := nIntest + 1 */
                  nIntest = CPLib.Round(nIntest+1,0);
                  /* _codsog := '' */
                  _codsog = "";
                  // * --- Merge into cgo_totope from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("cgo_totope");
                  m_cPhName = m_Ctx.GetPhName("cgo_totope");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_totope",m_Ctx.GetCompany());
                  m_cQuery = "select ";
                  m_cQuery =  m_cQuery+""+CPLib.ToSQL(_datope,"?",0,0)+" as TODATOPE";
                  m_cQuery =  m_cQuery+", "+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" as TOCODSOG";
                  m_cQuery =  m_cQuery+", "+CPLib.ToSQL(_segno,"?",0,0)+" as TO_SEGNO";
                  if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
                    m_cQuery = m_cQuery+" from dual";
                  }
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cWhere = "cgo_totope.TODATOPE = cptmp_1xab23.TODATOPE";
                  m_cWhere = m_cWhere+" and "+"cgo_totope.TOCODSOG = cptmp_1xab23.TOCODSOG";
                  m_cWhere = m_cWhere+" and "+"cgo_totope.TO_SEGNO = cptmp_1xab23.TO_SEGNO";
                  m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
                  if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"0000057C")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" cgo_totope USING ";
                    m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
                    m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
                    m_cSql = m_cSql+"TONUMOPE = TONUMOPE+("+CPLib.ToSQL(1,"N",10,0)+"), ";
                    m_cSql = m_cSql+"TOIMPORT = TOIMPORT+("+CPLib.ToSQL(_importo,"N",12,2)+"), ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_totope",true,true);
                    m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
                    m_cSql = m_cSql+GetFieldsName_0000057C(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_importo,"?",0,0)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_totope",true);
                    m_cSql = m_cSql+")";
                    if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                      m_cSql = m_cSql+";";
                    }
                  } else {
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"0000057C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"TONUMOPE = TONUMOPE+("+CPLib.ToSQL(1,"N",10,0)+"), ";
                    m_cSql = m_cSql+"TOIMPORT = TOIMPORT+("+CPLib.ToSQL(_importo,"N",12,2)+"), ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_totope",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"TODATOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_datope,"?",0,0,m_cServer),m_cServer,_datope)+"";
                    m_cSql = m_cSql+" and TOCODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"))+"";
                    m_cSql = m_cSql+" and TO_SEGNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_segno,"?",0,0,m_cServer),m_cServer,_segno)+"";
                    m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                    m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                    if (CPLib.eqr(m_nUpdatedRows,0)) {
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"0000057C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_0000057C(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_importo,"?",0,0)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_totope",true);
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
                    // * --- Write into xperazbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("xperazbo");
                    m_cPhName = m_Ctx.GetPhName("xperazbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000580")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
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
                  } else { // Else
                    // * --- Insert into xlientiope from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("xlientiope");
                    m_cPhName = m_Ctx.GetPhName("xlientiope");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xlientiope",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000581")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_00000581(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
                    }
                  } // End If
                  /* nIntest := nIntest + 1 */
                  nIntest = CPLib.Round(nIntest+1,0);
                  /* _codsog := '' */
                  _codsog = "";
                  // * --- Merge into cgo_totope from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("cgo_totope");
                  m_cPhName = m_Ctx.GetPhName("cgo_totope");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_totope",m_Ctx.GetCompany());
                  m_cQuery = "select ";
                  m_cQuery =  m_cQuery+""+CPLib.ToSQL(_datope,"?",0,0)+" as TODATOPE";
                  m_cQuery =  m_cQuery+", "+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" as TOCODSOG";
                  m_cQuery =  m_cQuery+", "+CPLib.ToSQL(_segno,"?",0,0)+" as TO_SEGNO";
                  if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
                    m_cQuery = m_cQuery+" from dual";
                  }
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cWhere = "cgo_totope.TODATOPE = cptmp_1xab23.TODATOPE";
                  m_cWhere = m_cWhere+" and "+"cgo_totope.TOCODSOG = cptmp_1xab23.TOCODSOG";
                  m_cWhere = m_cWhere+" and "+"cgo_totope.TO_SEGNO = cptmp_1xab23.TO_SEGNO";
                  m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
                  if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000584")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" cgo_totope USING ";
                    m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
                    m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
                    m_cSql = m_cSql+"TONUMOPE = TONUMOPE+("+CPLib.ToSQL(1,"N",10,0)+"), ";
                    m_cSql = m_cSql+"TOIMPORT = TOIMPORT+("+CPLib.ToSQL(_importo,"N",12,2)+"), ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_totope",true,true);
                    m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
                    m_cSql = m_cSql+GetFieldsName_00000584(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_importo,"?",0,0)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_totope",true);
                    m_cSql = m_cSql+")";
                    if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                      m_cSql = m_cSql+";";
                    }
                  } else {
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000584")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"TONUMOPE = TONUMOPE+("+CPLib.ToSQL(1,"N",10,0)+"), ";
                    m_cSql = m_cSql+"TOIMPORT = TOIMPORT+("+CPLib.ToSQL(_importo,"N",12,2)+"), ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_totope",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"TODATOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_datope,"?",0,0,m_cServer),m_cServer,_datope)+"";
                    m_cSql = m_cSql+" and TOCODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"))+"";
                    m_cSql = m_cSql+" and TO_SEGNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_segno,"?",0,0,m_cServer),m_cServer,_segno)+"";
                    m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                    m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                    if (CPLib.eqr(m_nUpdatedRows,0)) {
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000584")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_00000584(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_importo,"?",0,0)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_totope",true);
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
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000587")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
              /* If not(Empty(cgo_telematico->IBAN)) */
              if ( ! (CPLib.Empty(Cursor_cgo_telematico.GetString("IBAN")))) {
                /* If Left(cgo_telematico->IBAN,2)='IT' */
                if (CPLib.eqr(CPLib.Left(Cursor_cgo_telematico.GetString("IBAN"),2),"IT")) {
                  /* abicab := Substr(cgo_telematico->IBAN,6,5)+"-"+Substr(cgo_telematico->IBAN,11,5) */
                  abicab = CPLib.Substr(Cursor_cgo_telematico.GetString("IBAN"),6,5)+"-"+CPLib.Substr(Cursor_cgo_telematico.GetString("IBAN"),11,5);
                  /* If mcINTER2BO.HasKey(abicab) */
                  if (mcINTER2BO.HasKey(abicab)) {
                    /* If mcINTER2BO.GoToKey(abicab) */
                    if (mcINTER2BO.GoToKey(abicab)) {
                      // * --- Write into xperazbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("xperazbo");
                      m_cPhName = m_Ctx.GetPhName("xperazbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"0000058D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"TIPOINT2 = "+CPLib.ToSQL(mcINTER2BO.row.TIPINTER,"C",2,0,m_cServer)+", ";
                      m_cSql = m_cSql+"CODINT2 = "+CPLib.ToSQL(abicab,"C",11,0,m_cServer)+", ";
                      m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(mcINTER2BO.row.PAESE,"C",3,0,m_cServer)+", ";
                      m_cSql = m_cSql+"DESC2 = "+CPLib.ToSQL(mcINTER2BO.row.DESCCIT,"C",30,0,m_cServer)+", ";
                      m_cSql = m_cSql+"PROV2 = "+CPLib.ToSQL(mcINTER2BO.row.PROVINCIA,"C",2,0,m_cServer)+", ";
                      m_cSql = m_cSql+"CODCAB2 = "+CPLib.ToSQL(mcINTER2BO.row.CODCAB,"C",6,0,m_cServer)+", ";
                      m_cSql = m_cSql+"DESCINTER = "+CPLib.ToSQL(mcINTER2BO.row.RAGSOC,"C",50,0,m_cServer)+", ";
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
                  } // End If
                } else { // Else
                  /* abicab := Left(cgo_telematico->IBAN,11) */
                  abicab = CPLib.Left(Cursor_cgo_telematico.GetString("IBAN"),11);
                  // * --- Write into xperazbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("xperazbo");
                  m_cPhName = m_Ctx.GetPhName("xperazbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"0000058F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"CODINT2 = "+CPLib.ToSQL(abicab,"C",11,0,m_cServer)+", ";
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
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000595")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000595(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.le(CPLib.DateToChar(_datope),"20120531")?"20120601":CPLib.DateToChar(arfn_datesumR.Make(m_Ctx,this).Run(_datope,1))),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codana,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cabinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codsin,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.le(CPLib.DateToChar(_datope),"20120531")?CPLib.CharToDate("20120601"):arfn_datesumR.Make(m_Ctx,this).Run(_datope,1)),"?",0,0)+", ";
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
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"0000059A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
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
                  } else { // Else
                    // * --- Insert into clientiope from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("clientiope");
                    m_cPhName = m_Ctx.GetPhName("clientiope");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientiope",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"0000059B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_0000059B(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
                    }
                  } // End If
                  /* nIntest := nIntest + 1 */
                  nIntest = CPLib.Round(nIntest+1,0);
                  /* _codsog := '' */
                  _codsog = "";
                  // * --- Merge into cgo_totope from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("cgo_totope");
                  m_cPhName = m_Ctx.GetPhName("cgo_totope");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_totope",m_Ctx.GetCompany());
                  m_cQuery = "select ";
                  m_cQuery =  m_cQuery+""+CPLib.ToSQL(_datope,"?",0,0)+" as TODATOPE";
                  m_cQuery =  m_cQuery+", "+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" as TOCODSOG";
                  m_cQuery =  m_cQuery+", "+CPLib.ToSQL(_segno,"?",0,0)+" as TO_SEGNO";
                  if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
                    m_cQuery = m_cQuery+" from dual";
                  }
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cWhere = "cgo_totope.TODATOPE = cptmp_1xab23.TODATOPE";
                  m_cWhere = m_cWhere+" and "+"cgo_totope.TOCODSOG = cptmp_1xab23.TOCODSOG";
                  m_cWhere = m_cWhere+" and "+"cgo_totope.TO_SEGNO = cptmp_1xab23.TO_SEGNO";
                  m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
                  if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"0000059E")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" cgo_totope USING ";
                    m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
                    m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
                    m_cSql = m_cSql+"TONUMOPE = TONUMOPE+("+CPLib.ToSQL(1,"N",10,0)+"), ";
                    m_cSql = m_cSql+"TOIMPORT = TOIMPORT+("+CPLib.ToSQL(_importo,"N",12,2)+"), ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_totope",true,true);
                    m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
                    m_cSql = m_cSql+GetFieldsName_0000059E(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_importo,"?",0,0)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_totope",true);
                    m_cSql = m_cSql+")";
                    if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                      m_cSql = m_cSql+";";
                    }
                  } else {
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"0000059E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"TONUMOPE = TONUMOPE+("+CPLib.ToSQL(1,"N",10,0)+"), ";
                    m_cSql = m_cSql+"TOIMPORT = TOIMPORT+("+CPLib.ToSQL(_importo,"N",12,2)+"), ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_totope",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"TODATOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_datope,"?",0,0,m_cServer),m_cServer,_datope)+"";
                    m_cSql = m_cSql+" and TOCODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"))+"";
                    m_cSql = m_cSql+" and TO_SEGNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_segno,"?",0,0,m_cServer),m_cServer,_segno)+"";
                    m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                    m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                    if (CPLib.eqr(m_nUpdatedRows,0)) {
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"0000059E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_0000059E(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_importo,"?",0,0)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_totope",true);
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
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000005A2")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
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
                  } else { // Else
                    // * --- Insert into clientiope from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("clientiope");
                    m_cPhName = m_Ctx.GetPhName("clientiope");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientiope",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000005A3")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000005A3(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
                    }
                  } // End If
                  /* nIntest := nIntest + 1 */
                  nIntest = CPLib.Round(nIntest+1,0);
                  // * --- Merge into cgo_totope from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("cgo_totope");
                  m_cPhName = m_Ctx.GetPhName("cgo_totope");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_totope",m_Ctx.GetCompany());
                  m_cQuery = "select ";
                  m_cQuery =  m_cQuery+""+CPLib.ToSQL(_datope,"?",0,0)+" as TODATOPE";
                  m_cQuery =  m_cQuery+", "+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" as TOCODSOG";
                  m_cQuery =  m_cQuery+", "+CPLib.ToSQL(_segno,"?",0,0)+" as TO_SEGNO";
                  if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
                    m_cQuery = m_cQuery+" from dual";
                  }
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cWhere = "cgo_totope.TODATOPE = cptmp_1xab23.TODATOPE";
                  m_cWhere = m_cWhere+" and "+"cgo_totope.TOCODSOG = cptmp_1xab23.TOCODSOG";
                  m_cWhere = m_cWhere+" and "+"cgo_totope.TO_SEGNO = cptmp_1xab23.TO_SEGNO";
                  m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
                  if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000005A5")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" cgo_totope USING ";
                    m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
                    m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
                    m_cSql = m_cSql+"TONUMOPE = TONUMOPE+("+CPLib.ToSQL(1,"N",10,0)+"), ";
                    m_cSql = m_cSql+"TOIMPORT = TOIMPORT+("+CPLib.ToSQL(_importo,"N",12,2)+"), ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_totope",true,true);
                    m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
                    m_cSql = m_cSql+GetFieldsName_000005A5(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_importo,"?",0,0)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_totope",true);
                    m_cSql = m_cSql+")";
                    if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                      m_cSql = m_cSql+";";
                    }
                  } else {
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000005A5")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"TONUMOPE = TONUMOPE+("+CPLib.ToSQL(1,"N",10,0)+"), ";
                    m_cSql = m_cSql+"TOIMPORT = TOIMPORT+("+CPLib.ToSQL(_importo,"N",12,2)+"), ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_totope",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"TODATOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_datope,"?",0,0,m_cServer),m_cServer,_datope)+"";
                    m_cSql = m_cSql+" and TOCODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"))+"";
                    m_cSql = m_cSql+" and TO_SEGNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_segno,"?",0,0,m_cServer),m_cServer,_segno)+"";
                    m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                    m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                    if (CPLib.eqr(m_nUpdatedRows,0)) {
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000005A5")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_000005A5(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_importo,"?",0,0)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_totope",true);
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
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000005A8")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
              /* If not(Empty(cgo_telematico->IBAN)) */
              if ( ! (CPLib.Empty(Cursor_cgo_telematico.GetString("IBAN")))) {
                /* If Left(cgo_telematico->IBAN,2)='IT' */
                if (CPLib.eqr(CPLib.Left(Cursor_cgo_telematico.GetString("IBAN"),2),"IT")) {
                  /* abicab := Substr(cgo_telematico->IBAN,6,5)+"-"+Substr(cgo_telematico->IBAN,11,5) */
                  abicab = CPLib.Substr(Cursor_cgo_telematico.GetString("IBAN"),6,5)+"-"+CPLib.Substr(Cursor_cgo_telematico.GetString("IBAN"),11,5);
                  /* If mcINTER2BO.HasKey(abicab) */
                  if (mcINTER2BO.HasKey(abicab)) {
                    /* If mcINTER2BO.GoToKey(abicab) */
                    if (mcINTER2BO.GoToKey(abicab)) {
                      // * --- Write into operazbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("operazbo");
                      m_cPhName = m_Ctx.GetPhName("operazbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000005AE")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"TIPOINT2 = "+CPLib.ToSQL(mcINTER2BO.row.TIPINTER,"C",2,0,m_cServer)+", ";
                      m_cSql = m_cSql+"CODINT2 = "+CPLib.ToSQL(abicab,"C",11,0,m_cServer)+", ";
                      m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(mcINTER2BO.row.PAESE,"C",3,0,m_cServer)+", ";
                      m_cSql = m_cSql+"DESC2 = "+CPLib.ToSQL(mcINTER2BO.row.DESCCIT,"C",30,0,m_cServer)+", ";
                      m_cSql = m_cSql+"PROV2 = "+CPLib.ToSQL(mcINTER2BO.row.PROVINCIA,"C",2,0,m_cServer)+", ";
                      m_cSql = m_cSql+"CODCAB2 = "+CPLib.ToSQL(mcINTER2BO.row.CODCAB,"C",6,0,m_cServer)+", ";
                      m_cSql = m_cSql+"DESCINTER = "+CPLib.ToSQL(mcINTER2BO.row.RAGSOC,"C",50,0,m_cServer)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
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
                  } // End If
                } else { // Else
                  /* abicab := Left(cgo_telematico->IBAN,11) */
                  abicab = CPLib.Left(Cursor_cgo_telematico.GetString("IBAN"),11);
                  // * --- Write into operazbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("operazbo");
                  m_cPhName = m_Ctx.GetPhName("operazbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000005B0")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"CODINT2 = "+CPLib.ToSQL(abicab,"C",11,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
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
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000005B7")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000005B7(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.le(CPLib.DateToChar(_datope),"20120531")?"20120601":CPLib.DateToChar(arfn_datesumR.Make(m_Ctx,this).Run(_datope,1))),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codana,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cabinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codsin,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.le(CPLib.DateToChar(_datope),"20120531")?CPLib.CharToDate("20120601"):arfn_datesumR.Make(m_Ctx,this).Run(_datope,1)),"?",0,0)+", ";
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
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000005BC")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xraziobo",false,true);
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
                  } else { // Else
                    // * --- Insert into xlientifrz from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("xlientifrz");
                    m_cPhName = m_Ctx.GetPhName("xlientifrz");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xlientifrz",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000005BD")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000005BD(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000005C2")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xraziobo",false,true);
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
                  } else { // Else
                    // * --- Insert into xlientifrz from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("xlientifrz");
                    m_cPhName = m_Ctx.GetPhName("xlientifrz");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xlientifrz",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000005C3")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000005C3(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000005C7")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
              /* If not(Empty(cgo_telematico->IBAN)) */
              if ( ! (CPLib.Empty(Cursor_cgo_telematico.GetString("IBAN")))) {
                /* If Left(cgo_telematico->IBAN,2)='IT' */
                if (CPLib.eqr(CPLib.Left(Cursor_cgo_telematico.GetString("IBAN"),2),"IT")) {
                  /* abicab := Substr(cgo_telematico->IBAN,6,5)+"-"+Substr(cgo_telematico->IBAN,11,5) */
                  abicab = CPLib.Substr(Cursor_cgo_telematico.GetString("IBAN"),6,5)+"-"+CPLib.Substr(Cursor_cgo_telematico.GetString("IBAN"),11,5);
                  /* If mcINTER2BO.HasKey(abicab) */
                  if (mcINTER2BO.HasKey(abicab)) {
                    /* If mcINTER2BO.GoToKey(abicab) */
                    if (mcINTER2BO.GoToKey(abicab)) {
                      // * --- Write into xraziobo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("xraziobo");
                      m_cPhName = m_Ctx.GetPhName("xraziobo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000005CD")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"TIPOINT2 = "+CPLib.ToSQL(mcINTER2BO.row.TIPINTER,"C",2,0,m_cServer)+", ";
                      m_cSql = m_cSql+"CODINT2 = "+CPLib.ToSQL(abicab,"C",11,0,m_cServer)+", ";
                      m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(mcINTER2BO.row.PAESE,"C",3,0,m_cServer)+", ";
                      m_cSql = m_cSql+"DESC2 = "+CPLib.ToSQL(mcINTER2BO.row.DESCCIT,"C",30,0,m_cServer)+", ";
                      m_cSql = m_cSql+"PROV2 = "+CPLib.ToSQL(mcINTER2BO.row.PROVINCIA,"C",2,0,m_cServer)+", ";
                      m_cSql = m_cSql+"CODCAB2 = "+CPLib.ToSQL(mcINTER2BO.row.CODCAB,"C",6,0,m_cServer)+", ";
                      m_cSql = m_cSql+"DESCINTER = "+CPLib.ToSQL(mcINTER2BO.row.RAGSOC,"C",50,0,m_cServer)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xraziobo",false,true);
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
                  } // End If
                } else { // Else
                  /* abicab := Left(cgo_telematico->IBAN,11) */
                  abicab = CPLib.Left(Cursor_cgo_telematico.GetString("IBAN"),11);
                  // * --- Write into xraziobo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("xraziobo");
                  m_cPhName = m_Ctx.GetPhName("xraziobo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000005CF")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"CODINT2 = "+CPLib.ToSQL(abicab,"C",11,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xraziobo",false,true);
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
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000005D5")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000005D5(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.le(CPLib.DateToChar(_datope),"20120531")?"20120601":CPLib.DateToChar(arfn_datesumR.Make(m_Ctx,this).Run(_datope,1))),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codana,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cabinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codsin,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.le(CPLib.DateToChar(_datope),"20120531")?CPLib.CharToDate("20120601"):arfn_datesumR.Make(m_Ctx,this).Run(_datope,1)),"?",0,0)+", ";
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
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000005DA")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
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
                  } else { // Else
                    // * --- Insert into clientifrz from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("clientifrz");
                    m_cPhName = m_Ctx.GetPhName("clientifrz");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientifrz",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000005DB")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000005DB(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000005E0")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
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
                  } else { // Else
                    // * --- Insert into clientifrz from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("clientifrz");
                    m_cPhName = m_Ctx.GetPhName("clientifrz");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientifrz",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000005E1")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000005E1(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000005E5")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
              /* If not(Empty(cgo_telematico->IBAN)) */
              if ( ! (CPLib.Empty(Cursor_cgo_telematico.GetString("IBAN")))) {
                /* If Left(cgo_telematico->IBAN,2)='IT' */
                if (CPLib.eqr(CPLib.Left(Cursor_cgo_telematico.GetString("IBAN"),2),"IT")) {
                  /* abicab := Substr(cgo_telematico->IBAN,6,5)+"-"+Substr(cgo_telematico->IBAN,11,5) */
                  abicab = CPLib.Substr(Cursor_cgo_telematico.GetString("IBAN"),6,5)+"-"+CPLib.Substr(Cursor_cgo_telematico.GetString("IBAN"),11,5);
                  /* If mcINTER2BO.HasKey(abicab) */
                  if (mcINTER2BO.HasKey(abicab)) {
                    /* If mcINTER2BO.GoToKey(abicab) */
                    if (mcINTER2BO.GoToKey(abicab)) {
                      // * --- Write into fraziobo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("fraziobo");
                      m_cPhName = m_Ctx.GetPhName("fraziobo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000005EB")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"TIPOINT2 = "+CPLib.ToSQL(mcINTER2BO.row.TIPINTER,"C",2,0,m_cServer)+", ";
                      m_cSql = m_cSql+"CODINT2 = "+CPLib.ToSQL(abicab,"C",11,0,m_cServer)+", ";
                      m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(mcINTER2BO.row.PAESE,"C",3,0,m_cServer)+", ";
                      m_cSql = m_cSql+"DESC2 = "+CPLib.ToSQL(mcINTER2BO.row.DESCCIT,"C",30,0,m_cServer)+", ";
                      m_cSql = m_cSql+"PROV2 = "+CPLib.ToSQL(mcINTER2BO.row.PROVINCIA,"C",2,0,m_cServer)+", ";
                      m_cSql = m_cSql+"CODCAB2 = "+CPLib.ToSQL(mcINTER2BO.row.CODCAB,"C",6,0,m_cServer)+", ";
                      m_cSql = m_cSql+"DESCINTER = "+CPLib.ToSQL(mcINTER2BO.row.RAGSOC,"C",50,0,m_cServer)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
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
                  } // End If
                } else { // Else
                  /* abicab := Left(cgo_telematico->IBAN,11) */
                  abicab = CPLib.Left(Cursor_cgo_telematico.GetString("IBAN"),11);
                  // * --- Write into fraziobo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("fraziobo");
                  m_cPhName = m_Ctx.GetPhName("fraziobo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000005ED")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"CODINT2 = "+CPLib.ToSQL(abicab,"C",11,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
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
              } // End If
              /* fNumero := fNumero + 1 */
              fNumero = CPLib.Round(fNumero+1,0);
            } // End If
          } // End If
          /* ElseIf cgo_telematico->ENV='A' or cgo_telematico->ENV='V' */
        } else if (CPLib.eqr(Cursor_cgo_telematico.GetString("ENV"),"A") || CPLib.eqr(Cursor_cgo_telematico.GetString("ENV"),"V")) {
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
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000005F5")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000005F5(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.le(CPLib.DateToChar(_datope),"20120531")?"20120601":CPLib.DateToChar(arfn_datesumR.Make(m_Ctx,this).Run(_datope,1))),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codana,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cabinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codsin,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.le(CPLib.DateToChar(_datope),"20120531")?CPLib.CharToDate("20120601"):arfn_datesumR.Make(m_Ctx,this).Run(_datope,1)),"?",0,0)+", ";
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
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(Cursor_cgo_telematico.GetString("RAPPORTO")),16),"?",0,0,m_cServer)+", ";
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
              /* If _mezpagam='I' or _mezpagam='E' or _mezpagam='P' */
              if (CPLib.eqr(_mezpagam,"I") || CPLib.eqr(_mezpagam,"E") || CPLib.eqr(_mezpagam,"P")) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(Cursor_cgo_telematico.GetString("RAPPORTO")),16),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Left(CPLib.LRTrim(Cursor_cgo_telematico.GetString("RAPPORTO")),16))+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  // * --- Write into xperazbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("xperazbo");
                  m_cPhName = m_Ctx.GetPhName("xperazbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000005F8")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
              /* If not(Empty(cgo_telematico->IBAN)) */
              if ( ! (CPLib.Empty(Cursor_cgo_telematico.GetString("IBAN")))) {
                /* If Left(cgo_telematico->IBAN,2)='IT' */
                if (CPLib.eqr(CPLib.Left(Cursor_cgo_telematico.GetString("IBAN"),2),"IT")) {
                  /* abicab := Substr(cgo_telematico->IBAN,6,5)+"-"+Substr(cgo_telematico->IBAN,11,5) */
                  abicab = CPLib.Substr(Cursor_cgo_telematico.GetString("IBAN"),6,5)+"-"+CPLib.Substr(Cursor_cgo_telematico.GetString("IBAN"),11,5);
                  /* If mcINTER2BO.HasKey(abicab) */
                  if (mcINTER2BO.HasKey(abicab)) {
                    /* If mcINTER2BO.GoToKey(abicab) */
                    if (mcINTER2BO.GoToKey(abicab)) {
                      // * --- Write into xperazbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("xperazbo");
                      m_cPhName = m_Ctx.GetPhName("xperazbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000005FE")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"TIPOINT2 = "+CPLib.ToSQL(mcINTER2BO.row.TIPINTER,"C",2,0,m_cServer)+", ";
                      m_cSql = m_cSql+"CODINT2 = "+CPLib.ToSQL(abicab,"C",11,0,m_cServer)+", ";
                      m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(mcINTER2BO.row.PAESE,"C",3,0,m_cServer)+", ";
                      m_cSql = m_cSql+"DESC2 = "+CPLib.ToSQL(mcINTER2BO.row.DESCCIT,"C",30,0,m_cServer)+", ";
                      m_cSql = m_cSql+"PROV2 = "+CPLib.ToSQL(mcINTER2BO.row.PROVINCIA,"C",2,0,m_cServer)+", ";
                      m_cSql = m_cSql+"CODCAB2 = "+CPLib.ToSQL(mcINTER2BO.row.CODCAB,"C",6,0,m_cServer)+", ";
                      m_cSql = m_cSql+"DESCINTER = "+CPLib.ToSQL(mcINTER2BO.row.RAGSOC,"C",50,0,m_cServer)+", ";
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
                  } // End If
                } else { // Else
                  /* abicab := Left(cgo_telematico->IBAN,11) */
                  abicab = CPLib.Left(Cursor_cgo_telematico.GetString("IBAN"),11);
                  // * --- Write into xperazbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("xperazbo");
                  m_cPhName = m_Ctx.GetPhName("xperazbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000600")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"CODINT2 = "+CPLib.ToSQL(abicab,"C",11,0,m_cServer)+", ";
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
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000606")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000606(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.le(CPLib.DateToChar(_datope),"20120531")?"20120601":CPLib.DateToChar(arfn_datesumR.Make(m_Ctx,this).Run(_datope,1))),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codana,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cabinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codsin,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.le(CPLib.DateToChar(_datope),"20120531")?CPLib.CharToDate("20120601"):arfn_datesumR.Make(m_Ctx,this).Run(_datope,1)),"?",0,0)+", ";
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
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(Cursor_cgo_telematico.GetString("RAPPORTO")),16),"?",0,0,m_cServer)+", ";
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
              }
              /* If _mezpagam='I' or _mezpagam='E' or _mezpagam='P' */
              if (CPLib.eqr(_mezpagam,"I") || CPLib.eqr(_mezpagam,"E") || CPLib.eqr(_mezpagam,"P")) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(Cursor_cgo_telematico.GetString("RAPPORTO")),16),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Left(CPLib.LRTrim(Cursor_cgo_telematico.GetString("RAPPORTO")),16))+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  // * --- Write into operazbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("operazbo");
                  m_cPhName = m_Ctx.GetPhName("operazbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000609")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
              /* If not(Empty(cgo_telematico->IBAN)) */
              if ( ! (CPLib.Empty(Cursor_cgo_telematico.GetString("IBAN")))) {
                /* If Left(cgo_telematico->IBAN,2)='IT' */
                if (CPLib.eqr(CPLib.Left(Cursor_cgo_telematico.GetString("IBAN"),2),"IT")) {
                  /* abicab := Substr(cgo_telematico->IBAN,6,5)+"-"+Substr(cgo_telematico->IBAN,11,5) */
                  abicab = CPLib.Substr(Cursor_cgo_telematico.GetString("IBAN"),6,5)+"-"+CPLib.Substr(Cursor_cgo_telematico.GetString("IBAN"),11,5);
                  /* If mcINTER2BO.HasKey(abicab) */
                  if (mcINTER2BO.HasKey(abicab)) {
                    /* If mcINTER2BO.GoToKey(abicab) */
                    if (mcINTER2BO.GoToKey(abicab)) {
                      // * --- Write into operazbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("operazbo");
                      m_cPhName = m_Ctx.GetPhName("operazbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"0000060F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"TIPOINT2 = "+CPLib.ToSQL(mcINTER2BO.row.TIPINTER,"C",2,0,m_cServer)+", ";
                      m_cSql = m_cSql+"CODINT2 = "+CPLib.ToSQL(abicab,"C",11,0,m_cServer)+", ";
                      m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(mcINTER2BO.row.PAESE,"C",3,0,m_cServer)+", ";
                      m_cSql = m_cSql+"DESC2 = "+CPLib.ToSQL(mcINTER2BO.row.DESCCIT,"C",30,0,m_cServer)+", ";
                      m_cSql = m_cSql+"PROV2 = "+CPLib.ToSQL(mcINTER2BO.row.PROVINCIA,"C",2,0,m_cServer)+", ";
                      m_cSql = m_cSql+"CODCAB2 = "+CPLib.ToSQL(mcINTER2BO.row.CODCAB,"C",6,0,m_cServer)+", ";
                      m_cSql = m_cSql+"DESCINTER = "+CPLib.ToSQL(mcINTER2BO.row.RAGSOC,"C",50,0,m_cServer)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
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
                  } // End If
                } else { // Else
                  /* abicab := Left(cgo_telematico->IBAN,11) */
                  abicab = CPLib.Left(Cursor_cgo_telematico.GetString("IBAN"),11);
                  // * --- Write into operazbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("operazbo");
                  m_cPhName = m_Ctx.GetPhName("operazbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000611")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"CODINT2 = "+CPLib.ToSQL(abicab,"C",11,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
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
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000618")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000618(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.le(CPLib.DateToChar(_datope),"20120531")?"20120601":CPLib.DateToChar(arfn_datesumR.Make(m_Ctx,this).Run(_datope,1))),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codana,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cabinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codsin,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.le(CPLib.DateToChar(_datope),"20120531")?CPLib.CharToDate("20120601"):arfn_datesumR.Make(m_Ctx,this).Run(_datope,1)),"?",0,0)+", ";
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
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(Cursor_cgo_telematico.GetString("RAPPORTO")),16),"?",0,0,m_cServer)+", ";
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
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
              }
              /* If _mezpagam='I' or _mezpagam='E' or _mezpagam='P' */
              if (CPLib.eqr(_mezpagam,"I") || CPLib.eqr(_mezpagam,"E") || CPLib.eqr(_mezpagam,"P")) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(Cursor_cgo_telematico.GetString("RAPPORTO")),16),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Left(CPLib.LRTrim(Cursor_cgo_telematico.GetString("RAPPORTO")),16))+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  // * --- Write into xraziobo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("xraziobo");
                  m_cPhName = m_Ctx.GetPhName("xraziobo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"0000061B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
              /* If not(Empty(cgo_telematico->IBAN)) */
              if ( ! (CPLib.Empty(Cursor_cgo_telematico.GetString("IBAN")))) {
                /* If Left(cgo_telematico->IBAN,2)='IT' */
                if (CPLib.eqr(CPLib.Left(Cursor_cgo_telematico.GetString("IBAN"),2),"IT")) {
                  /* abicab := Substr(cgo_telematico->IBAN,6,5)+"-"+Substr(cgo_telematico->IBAN,11,5) */
                  abicab = CPLib.Substr(Cursor_cgo_telematico.GetString("IBAN"),6,5)+"-"+CPLib.Substr(Cursor_cgo_telematico.GetString("IBAN"),11,5);
                  /* If mcINTER2BO.HasKey(abicab) */
                  if (mcINTER2BO.HasKey(abicab)) {
                    /* If mcINTER2BO.GoToKey(abicab) */
                    if (mcINTER2BO.GoToKey(abicab)) {
                      // * --- Write into xraziobo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("xraziobo");
                      m_cPhName = m_Ctx.GetPhName("xraziobo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000621")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"TIPOINT2 = "+CPLib.ToSQL(mcINTER2BO.row.TIPINTER,"C",2,0,m_cServer)+", ";
                      m_cSql = m_cSql+"CODINT2 = "+CPLib.ToSQL(abicab,"C",11,0,m_cServer)+", ";
                      m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(mcINTER2BO.row.PAESE,"C",3,0,m_cServer)+", ";
                      m_cSql = m_cSql+"DESC2 = "+CPLib.ToSQL(mcINTER2BO.row.DESCCIT,"C",30,0,m_cServer)+", ";
                      m_cSql = m_cSql+"PROV2 = "+CPLib.ToSQL(mcINTER2BO.row.PROVINCIA,"C",2,0,m_cServer)+", ";
                      m_cSql = m_cSql+"CODCAB2 = "+CPLib.ToSQL(mcINTER2BO.row.CODCAB,"C",6,0,m_cServer)+", ";
                      m_cSql = m_cSql+"DESCINTER = "+CPLib.ToSQL(mcINTER2BO.row.RAGSOC,"C",50,0,m_cServer)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xraziobo",false,true);
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
                  } // End If
                } else { // Else
                  /* abicab := Left(cgo_telematico->IBAN,11) */
                  abicab = CPLib.Left(Cursor_cgo_telematico.GetString("IBAN"),11);
                  // * --- Write into xraziobo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("xraziobo");
                  m_cPhName = m_Ctx.GetPhName("xraziobo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000623")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"CODINT2 = "+CPLib.ToSQL(abicab,"C",11,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xraziobo",false,true);
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
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000629")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000629(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.le(CPLib.DateToChar(_datope),"20120531")?"20120601":CPLib.DateToChar(arfn_datesumR.Make(m_Ctx,this).Run(_datope,1))),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codana,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cabinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codsin,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.le(CPLib.DateToChar(_datope),"20120531")?CPLib.CharToDate("20120601"):arfn_datesumR.Make(m_Ctx,this).Run(_datope,1)),"?",0,0)+", ";
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
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(Cursor_cgo_telematico.GetString("RAPPORTO")),16),"?",0,0,m_cServer)+", ";
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
              }
              /* If _mezpagam='I' or _mezpagam='E' or _mezpagam='P' */
              if (CPLib.eqr(_mezpagam,"I") || CPLib.eqr(_mezpagam,"E") || CPLib.eqr(_mezpagam,"P")) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(Cursor_cgo_telematico.GetString("RAPPORTO")),16),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Left(CPLib.LRTrim(Cursor_cgo_telematico.GetString("RAPPORTO")),16))+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  // * --- Write into fraziobo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("fraziobo");
                  m_cPhName = m_Ctx.GetPhName("fraziobo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"0000062C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
              /* If not(Empty(cgo_telematico->IBAN)) */
              if ( ! (CPLib.Empty(Cursor_cgo_telematico.GetString("IBAN")))) {
                /* If Left(cgo_telematico->IBAN,2)='IT' */
                if (CPLib.eqr(CPLib.Left(Cursor_cgo_telematico.GetString("IBAN"),2),"IT")) {
                  /* abicab := Substr(cgo_telematico->IBAN,6,5)+"-"+Substr(cgo_telematico->IBAN,11,5) */
                  abicab = CPLib.Substr(Cursor_cgo_telematico.GetString("IBAN"),6,5)+"-"+CPLib.Substr(Cursor_cgo_telematico.GetString("IBAN"),11,5);
                  /* If mcINTER2BO.HasKey(abicab) */
                  if (mcINTER2BO.HasKey(abicab)) {
                    /* If mcINTER2BO.GoToKey(abicab) */
                    if (mcINTER2BO.GoToKey(abicab)) {
                      // * --- Write into fraziobo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("fraziobo");
                      m_cPhName = m_Ctx.GetPhName("fraziobo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000632")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"TIPOINT2 = "+CPLib.ToSQL(mcINTER2BO.row.TIPINTER,"C",2,0,m_cServer)+", ";
                      m_cSql = m_cSql+"CODINT2 = "+CPLib.ToSQL(abicab,"C",11,0,m_cServer)+", ";
                      m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(mcINTER2BO.row.PAESE,"C",3,0,m_cServer)+", ";
                      m_cSql = m_cSql+"DESC2 = "+CPLib.ToSQL(mcINTER2BO.row.DESCCIT,"C",30,0,m_cServer)+", ";
                      m_cSql = m_cSql+"PROV2 = "+CPLib.ToSQL(mcINTER2BO.row.PROVINCIA,"C",2,0,m_cServer)+", ";
                      m_cSql = m_cSql+"CODCAB2 = "+CPLib.ToSQL(mcINTER2BO.row.CODCAB,"C",6,0,m_cServer)+", ";
                      m_cSql = m_cSql+"DESCINTER = "+CPLib.ToSQL(mcINTER2BO.row.RAGSOC,"C",50,0,m_cServer)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
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
                  } // End If
                } else { // Else
                  /* abicab := Left(cgo_telematico->IBAN,11) */
                  abicab = CPLib.Left(Cursor_cgo_telematico.GetString("IBAN"),11);
                  // * --- Write into fraziobo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("fraziobo");
                  m_cPhName = m_Ctx.GetPhName("fraziobo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000634")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"CODINT2 = "+CPLib.ToSQL(abicab,"C",11,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
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
              } // End If
              /* fNumero := fNumero + 1 */
              fNumero = CPLib.Round(fNumero+1,0);
            } // End If
          } // End If
        } // End If
        /* Exec "Scrive dati aggiuntivi operazioni" Page 11:Page_11 */
        Page_11();
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
    }
  }
  void Page_11() throws Exception {
    /* Scrive i dati aggiuntivi delle operazioni/frazionate */
    /* If _flgaui='N' */
    if (CPLib.eqr(_flgaui,"N")) {
      // * --- Insert into sraziobo_agg from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("sraziobo_agg");
      m_cPhName = m_Ctx.GetPhName("sraziobo_agg");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sraziobo_agg",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000639")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
      m_cSql = m_cSql+GetFieldsName_00000639(m_Ctx,m_oWrInfo);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_codlob,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_tipgio,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_cacodice,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_biglietto,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_catipgio,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_catipcon,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_capv_cod,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_cadataora,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_vpcodice,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+m_oWrInfo.InsertValues();
      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"sraziobo_agg",true);
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
      /* If _tottele >= _limoper */
      if (CPLib.ge(_tottele,_limoper)) {
        /* If w_tipodest='P' */
        if (CPLib.eqr(w_tipodest,"P")) {
          // * --- Insert into xperazbo_agg from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xperazbo_agg");
          m_cPhName = m_Ctx.GetPhName("xperazbo_agg");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo_agg",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"0000063C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000063C(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codlob,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tipgio,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_cacodice,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_biglietto,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_catipgio,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_catipcon,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_capv_cod,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_cadataora,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_vpcodice,"?",0,0,m_cServer)+", ";
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
        } else { // Else
          // * --- Insert into operazbo_agg from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("operazbo_agg");
          m_cPhName = m_Ctx.GetPhName("operazbo_agg");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo_agg",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"0000063D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000063D(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codlob,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tipgio,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_cacodice,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_biglietto,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_catipgio,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_catipcon,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_capv_cod,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_cadataora,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_vpcodice,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"operazbo_agg",true);
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
        /* If w_tipodest='P' */
        if (CPLib.eqr(w_tipodest,"P")) {
          // * --- Insert into xraziobo_agg from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xraziobo_agg");
          m_cPhName = m_Ctx.GetPhName("xraziobo_agg");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo_agg",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"0000063F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000063F(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codlob,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tipgio,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_cacodice,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_biglietto,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_catipgio,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_catipcon,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_capv_cod,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_cadataora,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_vpcodice,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xraziobo_agg",true);
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
          // * --- Insert into fraziobo_agg from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("fraziobo_agg");
          m_cPhName = m_Ctx.GetPhName("fraziobo_agg");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo_agg",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000640")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000640(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codlob,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tipgio,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_cacodice,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_biglietto,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_catipgio,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_catipcon,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_capv_cod,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_cadataora,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_vpcodice,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"fraziobo_agg",true);
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
    } // End If
  }
  void Page_12() throws Exception {
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_xntestbo=null;
    CPResultSet Cursor_personbo=null;
    try {
      /* rowOper Row(operazbo) */
      MemoryCursorRow_operazbo rowOper;
      rowOper = new MemoryCursorRow_operazbo();
      /* mcCLIENTI.Zap() */
      mcCLIENTI.Zap();
      /* If w_tipodest='P' */
      if (CPLib.eqr(w_tipodest,"P")) {
        /* _prgope1 := _prgope1 + 1 */
        _prgope1 = CPLib.Round(_prgope1+1,0);
        /* _prgope2 := _prgope2 + 1 */
        _prgope2 = CPLib.Round(_prgope2+1,0);
        /* _prgimpope := _prgimpope + 1 */
        _prgimpope = CPLib.Round(_prgimpope+1,0);
        /* cOpeProg1 := Right("00000000000"+LRTrim(Str(_prgope1,11,0)),11) */
        cOpeProg1 = CPLib.Right("00000000000"+CPLib.LRTrim(CPLib.Str(_prgope1,11,0)),11);
        /* cOpeProg2 := Right("0000000000"+LRTrim(Str(_prgope2,10,0)),10) */
        cOpeProg2 = CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(_prgope2,10,0)),10);
        /* nProgImp := _prgimpope */
        nProgImp = CPLib.Round(_prgimpope,0);
        /* nIntest := 1 */
        nIntest = CPLib.Round(1,0);
        /* If _locrap='D' */
        if (CPLib.eqr(_locrap,"D")) {
          // * --- Select from intestbo
          m_cServer = m_Ctx.GetServer("intestbo");
          m_cPhName = m_Ctx.GetPhName("intestbo");
          if (Cursor_intestbo!=null)
            Cursor_intestbo.Close();
          Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,_rapporto)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_intestbo.Eof())) {
            /* If nIntest=1 */
            if (CPLib.eqr(nIntest,1)) {
              /* xCF := intestbo->CODINTER */
              xCF = Cursor_intestbo.GetString("CODINTER");
              /* rowOper.CONNESCLI := intestbo->CODINTER */
              rowOper.CONNESCLI = Cursor_intestbo.GetString("CODINTER");
            } else { // Else
              /* mcCLIENTI.AppendBlank() */
              mcCLIENTI.AppendBlank();
              /* mcCLIENTI.IDFILEBO := cOpeProg1 */
              mcCLIENTI.row.IDFILEBO = cOpeProg1;
              /* mcCLIENTI.CODSOG := intestbo->CODINTER */
              mcCLIENTI.row.CODSOG = Cursor_intestbo.GetString("CODINTER");
              /* mcCLIENTI.IDBASE := LibreriaMit.UniqueId() */
              mcCLIENTI.row.IDBASE = LibreriaMit.UniqueId();
              /* mcCLIENTI.SaveRow() */
              mcCLIENTI.SaveRow();
            } // End If
            /* nIntest := nIntest + 1 */
            nIntest = CPLib.Round(nIntest+1,0);
            // * --- Merge into cgo_totope from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cgo_totope");
            m_cPhName = m_Ctx.GetPhName("cgo_totope");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_totope",m_Ctx.GetCompany());
            m_cQuery = "select ";
            m_cQuery =  m_cQuery+""+CPLib.ToSQL(_datope,"?",0,0)+" as TODATOPE";
            m_cQuery =  m_cQuery+", "+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" as TOCODSOG";
            m_cQuery =  m_cQuery+", "+CPLib.ToSQL(_segno,"?",0,0)+" as TO_SEGNO";
            if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
              m_cQuery = m_cQuery+" from dual";
            }
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cWhere = "cgo_totope.TODATOPE = cptmp_1xab23.TODATOPE";
            m_cWhere = m_cWhere+" and "+"cgo_totope.TOCODSOG = cptmp_1xab23.TOCODSOG";
            m_cWhere = m_cWhere+" and "+"cgo_totope.TO_SEGNO = cptmp_1xab23.TO_SEGNO";
            m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
            if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000659")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" cgo_totope USING ";
              m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
              m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
              m_cSql = m_cSql+"TONUMOPE = TONUMOPE+("+CPLib.ToSQL(1,"N",10,0)+"), ";
              m_cSql = m_cSql+"TOIMPORT = TOIMPORT+("+CPLib.ToSQL(_importo,"N",12,2)+"), ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_totope",true,true);
              m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
              m_cSql = m_cSql+GetFieldsName_00000659(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_importo,"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_totope",true);
              m_cSql = m_cSql+")";
              if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                m_cSql = m_cSql+";";
              }
            } else {
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000659")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"TONUMOPE = TONUMOPE+("+CPLib.ToSQL(1,"N",10,0)+"), ";
              m_cSql = m_cSql+"TOIMPORT = TOIMPORT+("+CPLib.ToSQL(_importo,"N",12,2)+"), ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_totope",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"TODATOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_datope,"?",0,0,m_cServer),m_cServer,_datope)+"";
              m_cSql = m_cSql+" and TOCODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"))+"";
              m_cSql = m_cSql+" and TO_SEGNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_segno,"?",0,0,m_cServer),m_cServer,_segno)+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.eqr(m_nUpdatedRows,0)) {
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000659")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000659(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_importo,"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_totope",true);
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
          Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,_rapporto)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_xntestbo.Eof())) {
            /* If nIntest=1 */
            if (CPLib.eqr(nIntest,1)) {
              /* xCF := xntestbo->CODINTER */
              xCF = Cursor_xntestbo.GetString("CODINTER");
              /* rowOper.CONNESCLI := xntestbo->CODINTER */
              rowOper.CONNESCLI = Cursor_xntestbo.GetString("CODINTER");
            } else { // Else
              /* mcCLIENTI.AppendBlank() */
              mcCLIENTI.AppendBlank();
              /* mcCLIENTI.IDFILEBO := cOpeProg1 */
              mcCLIENTI.row.IDFILEBO = cOpeProg1;
              /* mcCLIENTI.CODSOG := xntestbo->CODINTER */
              mcCLIENTI.row.CODSOG = Cursor_xntestbo.GetString("CODINTER");
              /* mcCLIENTI.IDBASE := LibreriaMit.UniqueId() */
              mcCLIENTI.row.IDBASE = LibreriaMit.UniqueId();
              /* mcCLIENTI.SaveRow() */
              mcCLIENTI.SaveRow();
            } // End If
            /* nIntest := nIntest + 1 */
            nIntest = CPLib.Round(nIntest+1,0);
            // * --- Merge into cgo_totope from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cgo_totope");
            m_cPhName = m_Ctx.GetPhName("cgo_totope");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_totope",m_Ctx.GetCompany());
            m_cQuery = "select ";
            m_cQuery =  m_cQuery+""+CPLib.ToSQL(_datope,"?",0,0)+" as TODATOPE";
            m_cQuery =  m_cQuery+", "+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" as TOCODSOG";
            m_cQuery =  m_cQuery+", "+CPLib.ToSQL(_segno,"?",0,0)+" as TO_SEGNO";
            if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
              m_cQuery = m_cQuery+" from dual";
            }
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cWhere = "cgo_totope.TODATOPE = cptmp_1xab23.TODATOPE";
            m_cWhere = m_cWhere+" and "+"cgo_totope.TOCODSOG = cptmp_1xab23.TOCODSOG";
            m_cWhere = m_cWhere+" and "+"cgo_totope.TO_SEGNO = cptmp_1xab23.TO_SEGNO";
            m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
            if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000664")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" cgo_totope USING ";
              m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
              m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
              m_cSql = m_cSql+"TONUMOPE = TONUMOPE+("+CPLib.ToSQL(1,"N",10,0)+"), ";
              m_cSql = m_cSql+"TOIMPORT = TOIMPORT+("+CPLib.ToSQL(_importo,"N",12,2)+"), ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_totope",true,true);
              m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
              m_cSql = m_cSql+GetFieldsName_00000664(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_importo,"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_totope",true);
              m_cSql = m_cSql+")";
              if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                m_cSql = m_cSql+";";
              }
            } else {
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000664")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"TONUMOPE = TONUMOPE+("+CPLib.ToSQL(1,"N",10,0)+"), ";
              m_cSql = m_cSql+"TOIMPORT = TOIMPORT+("+CPLib.ToSQL(_importo,"N",12,2)+"), ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_totope",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"TODATOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_datope,"?",0,0,m_cServer),m_cServer,_datope)+"";
              m_cSql = m_cSql+" and TOCODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"))+"";
              m_cSql = m_cSql+" and TO_SEGNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_segno,"?",0,0,m_cServer),m_cServer,_segno)+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.eqr(m_nUpdatedRows,0)) {
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000664")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000664(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_importo,"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_totope",true);
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
            /* rowOper.C_RAG := personbo->RAGSOC */
            rowOper.C_RAG = Cursor_personbo.GetString("RAGSOC");
            /* rowOper.C_STA := personbo->PAESE */
            rowOper.C_STA = Cursor_personbo.GetString("PAESE");
            /* rowOper.C_CTA := personbo->DESCCIT */
            rowOper.C_CTA = Cursor_personbo.GetString("DESCCIT");
            /* rowOper.C_CAB := personbo->CODCAB */
            rowOper.C_CAB = Cursor_personbo.GetString("CODCAB");
            /* rowOper.C_PRV := personbo->PROVINCIA */
            rowOper.C_PRV = Cursor_personbo.GetString("PROVINCIA");
            /* rowOper.C_IND := personbo->DOMICILIO */
            rowOper.C_IND = Cursor_personbo.GetString("DOMICILIO");
            /* rowOper.C_CAP := personbo->CAP */
            rowOper.C_CAP = Cursor_personbo.GetString("CAP");
            /* rowOper.CONNESBEN := personbo->CONNES */
            rowOper.CONNESBEN = Cursor_personbo.GetString("CONNES");
            Cursor_personbo.Next();
          }
          m_cConnectivityError = Cursor_personbo.ErrorMessage();
          Cursor_personbo.Close();
          // * --- End Select
        } // End If
        /* If not(Empty(_iban)) */
        if ( ! (CPLib.Empty(_iban))) {
          /* If Left(_iban,2)='IT' */
          if (CPLib.eqr(CPLib.Left(_iban,2),"IT")) {
            /* abicab := Substr(_iban,6,5)+"-"+Substr(_iban,11,5) */
            abicab = CPLib.Substr(_iban,6,5)+"-"+CPLib.Substr(_iban,11,5);
            /* If mcINTER2BO.HasKey(abicab) */
            if (mcINTER2BO.HasKey(abicab)) {
              /* If mcINTER2BO.GoToKey(abicab) */
              if (mcINTER2BO.GoToKey(abicab)) {
                /* rowOper.TIPOINT2 := mcINTER2BO.TIPINTER */
                rowOper.TIPOINT2 = mcINTER2BO.row.TIPINTER;
                /* rowOper.CODINT2 := abicab */
                rowOper.CODINT2 = abicab;
                /* rowOper.PAESE := mcINTER2BO.PAESE */
                rowOper.PAESE = mcINTER2BO.row.PAESE;
                /* rowOper.DESC2 := mcINTER2BO.DESCCIT */
                rowOper.DESC2 = mcINTER2BO.row.DESCCIT;
                /* rowOper.PROV2 := mcINTER2BO.PROVINCIA */
                rowOper.PROV2 = mcINTER2BO.row.PROVINCIA;
                /* rowOper.CODCAB2 := mcINTER2BO.CODCAB */
                rowOper.CODCAB2 = mcINTER2BO.row.CODCAB;
                /* rowOper.DESCINTER := mcINTER2BO.RAGSOC */
                rowOper.DESCINTER = mcINTER2BO.row.RAGSOC;
              } // End If
            } // End If
          } else { // Else
            /* abicab := Left(_iban,11) */
            abicab = CPLib.Left(_iban,11);
            /* rowOper.CODINT2 := abicab */
            rowOper.CODINT2 = abicab;
          } // End If
        } // End If
        // * --- Insert into xperazbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("xperazbo");
        m_cPhName = m_Ctx.GetPhName("xperazbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"0000067D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000067D(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codana,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_cabinter,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codsin,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_citinter,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_drcol,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_tiporap,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(xData+cOpeProg2+"0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_ipcol,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_orcol,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_prvinter,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_idbiglietto,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_tipope,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_importo*100,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_env,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowOper.TIPOINT2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(abicab,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowOper.PAESE,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowOper.DESC2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowOper.PROV2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowOper.CODCAB2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowOper.DESCINTER,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowOper.C_RAG,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowOper.C_STA,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowOper.C_CTA,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowOper.C_CAB,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowOper.C_PRV,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowOper.C_IND,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowOper.C_CAP,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowOper.CONNESBEN,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowOper.CONNESCLI,"?",0,0,m_cServer)+", ";
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
        for (MemoryCursorRow_clientiope rwClienti : mcCLIENTI._iterable_()) {
          // * --- Insert into xlientiope from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xlientiope");
          m_cPhName = m_Ctx.GetPhName("xlientiope");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xlientiope",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"0000067F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000067F(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(rwClienti.IDFILEBO,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rwClienti.CODSOG,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rwClienti.IDBASE,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
          }
        }
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
        /* If _locrap='D' */
        if (CPLib.eqr(_locrap,"D")) {
          // * --- Select from intestbo
          m_cServer = m_Ctx.GetServer("intestbo");
          m_cPhName = m_Ctx.GetPhName("intestbo");
          if (Cursor_intestbo!=null)
            Cursor_intestbo.Close();
          Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,_rapporto)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_intestbo.Eof())) {
            /* If nIntest=1 */
            if (CPLib.eqr(nIntest,1)) {
              /* xCF := intestbo->CODINTER */
              xCF = Cursor_intestbo.GetString("CODINTER");
              /* rowOper.CONNESCLI := intestbo->CODINTER */
              rowOper.CONNESCLI = Cursor_intestbo.GetString("CODINTER");
            } else { // Else
              /* mcCLIENTI.AppendBlank() */
              mcCLIENTI.AppendBlank();
              /* mcCLIENTI.IDFILEBO := cOpeProg1 */
              mcCLIENTI.row.IDFILEBO = cOpeProg1;
              /* mcCLIENTI.CODSOG := intestbo->CODINTER */
              mcCLIENTI.row.CODSOG = Cursor_intestbo.GetString("CODINTER");
              /* mcCLIENTI.IDBASE := LibreriaMit.UniqueId() */
              mcCLIENTI.row.IDBASE = LibreriaMit.UniqueId();
              /* mcCLIENTI.SaveRow() */
              mcCLIENTI.SaveRow();
            } // End If
            /* nIntest := nIntest + 1 */
            nIntest = CPLib.Round(nIntest+1,0);
            // * --- Merge into cgo_totope from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cgo_totope");
            m_cPhName = m_Ctx.GetPhName("cgo_totope");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_totope",m_Ctx.GetCompany());
            m_cQuery = "select ";
            m_cQuery =  m_cQuery+""+CPLib.ToSQL(_datope,"?",0,0)+" as TODATOPE";
            m_cQuery =  m_cQuery+", "+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" as TOCODSOG";
            m_cQuery =  m_cQuery+", "+CPLib.ToSQL(_segno,"?",0,0)+" as TO_SEGNO";
            if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
              m_cQuery = m_cQuery+" from dual";
            }
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cWhere = "cgo_totope.TODATOPE = cptmp_1xab23.TODATOPE";
            m_cWhere = m_cWhere+" and "+"cgo_totope.TOCODSOG = cptmp_1xab23.TOCODSOG";
            m_cWhere = m_cWhere+" and "+"cgo_totope.TO_SEGNO = cptmp_1xab23.TO_SEGNO";
            m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
            if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000690")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" cgo_totope USING ";
              m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
              m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
              m_cSql = m_cSql+"TONUMOPE = TONUMOPE+("+CPLib.ToSQL(1,"N",10,0)+"), ";
              m_cSql = m_cSql+"TOIMPORT = TOIMPORT+("+CPLib.ToSQL(_importo,"N",12,2)+"), ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_totope",true,true);
              m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
              m_cSql = m_cSql+GetFieldsName_00000690(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_importo,"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_totope",true);
              m_cSql = m_cSql+")";
              if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                m_cSql = m_cSql+";";
              }
            } else {
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000690")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"TONUMOPE = TONUMOPE+("+CPLib.ToSQL(1,"N",10,0)+"), ";
              m_cSql = m_cSql+"TOIMPORT = TOIMPORT+("+CPLib.ToSQL(_importo,"N",12,2)+"), ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_totope",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"TODATOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_datope,"?",0,0,m_cServer),m_cServer,_datope)+"";
              m_cSql = m_cSql+" and TOCODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"))+"";
              m_cSql = m_cSql+" and TO_SEGNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_segno,"?",0,0,m_cServer),m_cServer,_segno)+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.eqr(m_nUpdatedRows,0)) {
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000690")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000690(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_importo,"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_totope",true);
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
          Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,_rapporto)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_xntestbo.Eof())) {
            /* If nIntest=1 */
            if (CPLib.eqr(nIntest,1)) {
              /* xCF := xntestbo->CODINTER */
              xCF = Cursor_xntestbo.GetString("CODINTER");
              /* rowOper.CONNESCLI := xntestbo->CODINTER */
              rowOper.CONNESCLI = Cursor_xntestbo.GetString("CODINTER");
            } else { // Else
              /* mcCLIENTI.AppendBlank() */
              mcCLIENTI.AppendBlank();
              /* mcCLIENTI.IDFILEBO := cOpeProg1 */
              mcCLIENTI.row.IDFILEBO = cOpeProg1;
              /* mcCLIENTI.CODSOG := xntestbo->CODINTER */
              mcCLIENTI.row.CODSOG = Cursor_xntestbo.GetString("CODINTER");
              /* mcCLIENTI.IDBASE := LibreriaMit.UniqueId() */
              mcCLIENTI.row.IDBASE = LibreriaMit.UniqueId();
              /* mcCLIENTI.SaveRow() */
              mcCLIENTI.SaveRow();
            } // End If
            /* nIntest := nIntest + 1 */
            nIntest = CPLib.Round(nIntest+1,0);
            // * --- Merge into cgo_totope from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cgo_totope");
            m_cPhName = m_Ctx.GetPhName("cgo_totope");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_totope",m_Ctx.GetCompany());
            m_cQuery = "select ";
            m_cQuery =  m_cQuery+""+CPLib.ToSQL(_datope,"?",0,0)+" as TODATOPE";
            m_cQuery =  m_cQuery+", "+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" as TOCODSOG";
            m_cQuery =  m_cQuery+", "+CPLib.ToSQL(_segno,"?",0,0)+" as TO_SEGNO";
            if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
              m_cQuery = m_cQuery+" from dual";
            }
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cWhere = "cgo_totope.TODATOPE = cptmp_1xab23.TODATOPE";
            m_cWhere = m_cWhere+" and "+"cgo_totope.TOCODSOG = cptmp_1xab23.TOCODSOG";
            m_cWhere = m_cWhere+" and "+"cgo_totope.TO_SEGNO = cptmp_1xab23.TO_SEGNO";
            m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
            if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"0000069B")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" cgo_totope USING ";
              m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
              m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
              m_cSql = m_cSql+"TONUMOPE = TONUMOPE+("+CPLib.ToSQL(1,"N",10,0)+"), ";
              m_cSql = m_cSql+"TOIMPORT = TOIMPORT+("+CPLib.ToSQL(_importo,"N",12,2)+"), ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_totope",true,true);
              m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
              m_cSql = m_cSql+GetFieldsName_0000069B(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_importo,"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_totope",true);
              m_cSql = m_cSql+")";
              if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                m_cSql = m_cSql+";";
              }
            } else {
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"0000069B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"TONUMOPE = TONUMOPE+("+CPLib.ToSQL(1,"N",10,0)+"), ";
              m_cSql = m_cSql+"TOIMPORT = TOIMPORT+("+CPLib.ToSQL(_importo,"N",12,2)+"), ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_totope",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"TODATOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_datope,"?",0,0,m_cServer),m_cServer,_datope)+"";
              m_cSql = m_cSql+" and TOCODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"))+"";
              m_cSql = m_cSql+" and TO_SEGNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_segno,"?",0,0,m_cServer),m_cServer,_segno)+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.eqr(m_nUpdatedRows,0)) {
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"0000069B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000069B(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_importo,"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_totope",true);
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
            /* rowOper.C_RAG := personbo->RAGSOC */
            rowOper.C_RAG = Cursor_personbo.GetString("RAGSOC");
            /* rowOper.C_STA := personbo->PAESE */
            rowOper.C_STA = Cursor_personbo.GetString("PAESE");
            /* rowOper.C_CTA := personbo->DESCCIT */
            rowOper.C_CTA = Cursor_personbo.GetString("DESCCIT");
            /* rowOper.C_CAB := personbo->CODCAB */
            rowOper.C_CAB = Cursor_personbo.GetString("CODCAB");
            /* rowOper.C_PRV := personbo->PROVINCIA */
            rowOper.C_PRV = Cursor_personbo.GetString("PROVINCIA");
            /* rowOper.C_IND := personbo->DOMICILIO */
            rowOper.C_IND = Cursor_personbo.GetString("DOMICILIO");
            /* rowOper.C_CAP := personbo->CAP */
            rowOper.C_CAP = Cursor_personbo.GetString("CAP");
            /* rowOper.CONNESBEN := personbo->CONNES */
            rowOper.CONNESBEN = Cursor_personbo.GetString("CONNES");
            Cursor_personbo.Next();
          }
          m_cConnectivityError = Cursor_personbo.ErrorMessage();
          Cursor_personbo.Close();
          // * --- End Select
        } // End If
        /* If not(Empty(_iban)) */
        if ( ! (CPLib.Empty(_iban))) {
          /* If Left(_iban,2)='IT' */
          if (CPLib.eqr(CPLib.Left(_iban,2),"IT")) {
            /* abicab := Substr(_iban,6,5)+"-"+Substr(_iban,11,5) */
            abicab = CPLib.Substr(_iban,6,5)+"-"+CPLib.Substr(_iban,11,5);
            /* If mcINTER2BO.HasKey(abicab) */
            if (mcINTER2BO.HasKey(abicab)) {
              /* If mcINTER2BO.GoToKey(abicab) */
              if (mcINTER2BO.GoToKey(abicab)) {
                /* rowOper.TIPOINT2 := mcINTER2BO.TIPINTER */
                rowOper.TIPOINT2 = mcINTER2BO.row.TIPINTER;
                /* rowOper.CODINT2 := abicab */
                rowOper.CODINT2 = abicab;
                /* rowOper.PAESE := mcINTER2BO.PAESE */
                rowOper.PAESE = mcINTER2BO.row.PAESE;
                /* rowOper.DESC2 := mcINTER2BO.DESCCIT */
                rowOper.DESC2 = mcINTER2BO.row.DESCCIT;
                /* rowOper.PROV2 := mcINTER2BO.PROVINCIA */
                rowOper.PROV2 = mcINTER2BO.row.PROVINCIA;
                /* rowOper.CODCAB2 := mcINTER2BO.CODCAB */
                rowOper.CODCAB2 = mcINTER2BO.row.CODCAB;
                /* rowOper.DESCINTER := mcINTER2BO.RAGSOC */
                rowOper.DESCINTER = mcINTER2BO.row.RAGSOC;
              } // End If
            } // End If
          } else { // Else
            /* abicab := Left(_iban,11) */
            abicab = CPLib.Left(_iban,11);
            /* rowOper.CODINT2 := abicab */
            rowOper.CODINT2 = abicab;
          } // End If
        } // End If
        /* oNumero := oNumero + 1 */
        oNumero = CPLib.Round(oNumero+1,0);
        // * --- Insert into operazbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("operazbo");
        m_cPhName = m_Ctx.GetPhName("operazbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000006B5")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_000006B5(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codana,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_cabinter,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codsin,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_citinter,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_drcol,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_tiporap,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(xData+cOpeProg2+"0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_ipcol,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_orcol,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_prvinter,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_idbiglietto,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_tipope,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_importo*100,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_env,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowOper.TIPOINT2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(abicab,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowOper.PAESE,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowOper.DESC2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowOper.PROV2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowOper.CODCAB2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowOper.DESCINTER,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowOper.C_RAG,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowOper.C_STA,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowOper.C_CTA,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowOper.C_CAB,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowOper.C_PRV,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowOper.C_IND,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowOper.C_CAP,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowOper.CONNESBEN,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowOper.CONNESCLI,"?",0,0,m_cServer)+", ";
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
        }
        for (MemoryCursorRow_clientiope rwClienti : mcCLIENTI._iterable_()) {
          // * --- Insert into clientiope from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("clientiope");
          m_cPhName = m_Ctx.GetPhName("clientiope");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientiope",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000006B7")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000006B7(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(rwClienti.IDFILEBO,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rwClienti.CODSOG,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rwClienti.IDBASE,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
          }
        }
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
  void Page_13() throws Exception {
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_xntestbo=null;
    CPResultSet Cursor_personbo=null;
    try {
      /* rowFraz Row(fraziobo) */
      MemoryCursorRow_fraziobo rowFraz;
      rowFraz = new MemoryCursorRow_fraziobo();
      /* mcCLIENTI.Zap() */
      mcCLIENTI.Zap();
      /* If w_tipodest='P' */
      if (CPLib.eqr(w_tipodest,"P")) {
        /* _prgope1 := _prgope1 + 1 */
        _prgope1 = CPLib.Round(_prgope1+1,0);
        /* _prgope2 := _prgope2 + 1 */
        _prgope2 = CPLib.Round(_prgope2+1,0);
        /* _prgimpope := _prgimpope + 1 */
        _prgimpope = CPLib.Round(_prgimpope+1,0);
        /* cOpeProg1 := Right("00000000000"+LRTrim(Str(_prgope1,11,0)),11) */
        cOpeProg1 = CPLib.Right("00000000000"+CPLib.LRTrim(CPLib.Str(_prgope1,11,0)),11);
        /* cOpeProg2 := Right("0000000000"+LRTrim(Str(_prgope2,10,0)),10) */
        cOpeProg2 = CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(_prgope2,10,0)),10);
        /* nProgImp := _prgimpope */
        nProgImp = CPLib.Round(_prgimpope,0);
        /* nIntest := 1 */
        nIntest = CPLib.Round(1,0);
        /* If _locrap='D' */
        if (CPLib.eqr(_locrap,"D")) {
          // * --- Select from intestbo
          m_cServer = m_Ctx.GetServer("intestbo");
          m_cPhName = m_Ctx.GetPhName("intestbo");
          if (Cursor_intestbo!=null)
            Cursor_intestbo.Close();
          Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,_rapporto)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_intestbo.Eof())) {
            /* If nIntest=1 */
            if (CPLib.eqr(nIntest,1)) {
              /* xCF := intestbo->CODINTER */
              xCF = Cursor_intestbo.GetString("CODINTER");
              /* rowFraz.CONNESCLI := intestbo->CODINTER */
              rowFraz.CONNESCLI = Cursor_intestbo.GetString("CODINTER");
            } else { // Else
              /* mcCLIENTI.AppendBlank() */
              mcCLIENTI.AppendBlank();
              /* mcCLIENTI.IDFILEBO := cOpeProg1 */
              mcCLIENTI.row.IDFILEBO = cOpeProg1;
              /* mcCLIENTI.CODSOG := intestbo->CODINTER */
              mcCLIENTI.row.CODSOG = Cursor_intestbo.GetString("CODINTER");
              /* mcCLIENTI.IDBASE := LibreriaMit.UniqueId() */
              mcCLIENTI.row.IDBASE = LibreriaMit.UniqueId();
              /* mcCLIENTI.SaveRow() */
              mcCLIENTI.SaveRow();
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
          Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,_rapporto)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_xntestbo.Eof())) {
            /* If nIntest=1 */
            if (CPLib.eqr(nIntest,1)) {
              /* xCF := xntestbo->CODINTER */
              xCF = Cursor_xntestbo.GetString("CODINTER");
              /* rowFraz.CONNESCLI := xntestbo->CODINTER */
              rowFraz.CONNESCLI = Cursor_xntestbo.GetString("CODINTER");
            } else { // Else
              /* mcCLIENTI.AppendBlank() */
              mcCLIENTI.AppendBlank();
              /* mcCLIENTI.IDFILEBO := cOpeProg1 */
              mcCLIENTI.row.IDFILEBO = cOpeProg1;
              /* mcCLIENTI.CODSOG := xntestbo->CODINTER */
              mcCLIENTI.row.CODSOG = Cursor_xntestbo.GetString("CODINTER");
              /* mcCLIENTI.IDBASE := LibreriaMit.UniqueId() */
              mcCLIENTI.row.IDBASE = LibreriaMit.UniqueId();
              /* mcCLIENTI.SaveRow() */
              mcCLIENTI.SaveRow();
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
            /* rowFraz.C_RAG := personbo->RAGSOC */
            rowFraz.C_RAG = Cursor_personbo.GetString("RAGSOC");
            /* rowFraz.C_STA := personbo->PAESE */
            rowFraz.C_STA = Cursor_personbo.GetString("PAESE");
            /* rowFraz.C_CTA := personbo->DESCCIT */
            rowFraz.C_CTA = Cursor_personbo.GetString("DESCCIT");
            /* rowFraz.C_CAB := personbo->CODCAB */
            rowFraz.C_CAB = Cursor_personbo.GetString("CODCAB");
            /* rowFraz.C_PRV := personbo->PROVINCIA */
            rowFraz.C_PRV = Cursor_personbo.GetString("PROVINCIA");
            /* rowFraz.C_IND := personbo->DOMICILIO */
            rowFraz.C_IND = Cursor_personbo.GetString("DOMICILIO");
            /* rowFraz.C_CAP := personbo->CAP */
            rowFraz.C_CAP = Cursor_personbo.GetString("CAP");
            /* rowFraz.CONNESBEN := personbo->CONNES */
            rowFraz.CONNESBEN = Cursor_personbo.GetString("CONNES");
            Cursor_personbo.Next();
          }
          m_cConnectivityError = Cursor_personbo.ErrorMessage();
          Cursor_personbo.Close();
          // * --- End Select
        } // End If
        /* If not(Empty(_iban)) */
        if ( ! (CPLib.Empty(_iban))) {
          /* If Left(_iban,2)='IT' */
          if (CPLib.eqr(CPLib.Left(_iban,2),"IT")) {
            /* abicab := Substr(_iban,6,5)+"-"+Substr(_iban,11,5) */
            abicab = CPLib.Substr(_iban,6,5)+"-"+CPLib.Substr(_iban,11,5);
            /* If mcINTER2BO.HasKey(abicab) */
            if (mcINTER2BO.HasKey(abicab)) {
              /* If mcINTER2BO.GoToKey(abicab) */
              if (mcINTER2BO.GoToKey(abicab)) {
                /* rowFraz.TIPOINT2 := mcINTER2BO.TIPINTER */
                rowFraz.TIPOINT2 = mcINTER2BO.row.TIPINTER;
                /* rowFraz.CODINT2 := abicab */
                rowFraz.CODINT2 = abicab;
                /* rowFraz.PAESE := mcINTER2BO.PAESE */
                rowFraz.PAESE = mcINTER2BO.row.PAESE;
                /* rowFraz.DESC2 := mcINTER2BO.DESCCIT */
                rowFraz.DESC2 = mcINTER2BO.row.DESCCIT;
                /* rowFraz.PROV2 := mcINTER2BO.PROVINCIA */
                rowFraz.PROV2 = mcINTER2BO.row.PROVINCIA;
                /* rowFraz.CODCAB2 := mcINTER2BO.CODCAB */
                rowFraz.CODCAB2 = mcINTER2BO.row.CODCAB;
                /* rowFraz.DESCINTER := mcINTER2BO.RAGSOC */
                rowFraz.DESCINTER = mcINTER2BO.row.RAGSOC;
              } // End If
            } // End If
          } else { // Else
            /* abicab := Left(_iban,11) */
            abicab = CPLib.Left(_iban,11);
            /* rowFraz.CODINT2 := abicab */
            rowFraz.CODINT2 = abicab;
          } // End If
        } // End If
        // * --- Insert into xraziobo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("xraziobo");
        m_cPhName = m_Ctx.GetPhName("xraziobo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000006F2")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_000006F2(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codana,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_cabinter,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codsin,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_citinter,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_drcol,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_tiporap,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(xData+cOpeProg2+"0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_ipcol,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_orcol,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_prvinter,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_idbiglietto,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_tipope,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_importo*100,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_env,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowFraz.TIPOINT2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(abicab,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowFraz.PAESE,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowFraz.DESC2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowFraz.PROV2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowFraz.CODCAB2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowFraz.DESCINTER,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowFraz.C_RAG,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowFraz.C_STA,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowFraz.C_CTA,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowFraz.C_CAB,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowFraz.C_PRV,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowFraz.C_IND,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowFraz.C_CAP,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowFraz.CONNESBEN,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowFraz.CONNESCLI,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
        }
        for (MemoryCursorRow_clientiope rwClienti : mcCLIENTI._iterable_()) {
          // * --- Insert into xlientifrz from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xlientifrz");
          m_cPhName = m_Ctx.GetPhName("xlientifrz");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xlientifrz",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"000006F4")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000006F4(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(rwClienti.IDFILEBO,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rwClienti.CODSOG,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rwClienti.IDBASE,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
          }
        }
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
        /* If _locrap='D' */
        if (CPLib.eqr(_locrap,"D")) {
          // * --- Select from intestbo
          m_cServer = m_Ctx.GetServer("intestbo");
          m_cPhName = m_Ctx.GetPhName("intestbo");
          if (Cursor_intestbo!=null)
            Cursor_intestbo.Close();
          Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,_rapporto)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_intestbo.Eof())) {
            /* If nIntest=1 */
            if (CPLib.eqr(nIntest,1)) {
              /* xCF := intestbo->CODINTER */
              xCF = Cursor_intestbo.GetString("CODINTER");
              /* rowFraz.CONNESCLI := intestbo->CODINTER */
              rowFraz.CONNESCLI = Cursor_intestbo.GetString("CODINTER");
            } else { // Else
              /* mcCLIENTI.AppendBlank() */
              mcCLIENTI.AppendBlank();
              /* mcCLIENTI.IDFILEBO := cOpeProg1 */
              mcCLIENTI.row.IDFILEBO = cOpeProg1;
              /* mcCLIENTI.CODSOG := intestbo->CODINTER */
              mcCLIENTI.row.CODSOG = Cursor_intestbo.GetString("CODINTER");
              /* mcCLIENTI.IDBASE := LibreriaMit.UniqueId() */
              mcCLIENTI.row.IDBASE = LibreriaMit.UniqueId();
              /* mcCLIENTI.SaveRow() */
              mcCLIENTI.SaveRow();
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
          Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,_rapporto)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_xntestbo.Eof())) {
            /* If nIntest=1 */
            if (CPLib.eqr(nIntest,1)) {
              /* xCF := xntestbo->CODINTER */
              xCF = Cursor_xntestbo.GetString("CODINTER");
              /* rowFraz.CONNESCLI := xntestbo->CODINTER */
              rowFraz.CONNESCLI = Cursor_xntestbo.GetString("CODINTER");
            } else { // Else
              /* mcCLIENTI.AppendBlank() */
              mcCLIENTI.AppendBlank();
              /* mcCLIENTI.IDFILEBO := cOpeProg1 */
              mcCLIENTI.row.IDFILEBO = cOpeProg1;
              /* mcCLIENTI.CODSOG := xntestbo->CODINTER */
              mcCLIENTI.row.CODSOG = Cursor_xntestbo.GetString("CODINTER");
              /* mcCLIENTI.IDBASE := LibreriaMit.UniqueId() */
              mcCLIENTI.row.IDBASE = LibreriaMit.UniqueId();
              /* mcCLIENTI.SaveRow() */
              mcCLIENTI.SaveRow();
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
            /* rowFraz.C_RAG := personbo->RAGSOC */
            rowFraz.C_RAG = Cursor_personbo.GetString("RAGSOC");
            /* rowFraz.C_STA := personbo->PAESE */
            rowFraz.C_STA = Cursor_personbo.GetString("PAESE");
            /* rowFraz.C_CTA := personbo->DESCCIT */
            rowFraz.C_CTA = Cursor_personbo.GetString("DESCCIT");
            /* rowFraz.C_CAB := personbo->CODCAB */
            rowFraz.C_CAB = Cursor_personbo.GetString("CODCAB");
            /* rowFraz.C_PRV := personbo->PROVINCIA */
            rowFraz.C_PRV = Cursor_personbo.GetString("PROVINCIA");
            /* rowFraz.C_IND := personbo->DOMICILIO */
            rowFraz.C_IND = Cursor_personbo.GetString("DOMICILIO");
            /* rowFraz.C_CAP := personbo->CAP */
            rowFraz.C_CAP = Cursor_personbo.GetString("CAP");
            /* rowFraz.CONNESBEN := personbo->CONNES */
            rowFraz.CONNESBEN = Cursor_personbo.GetString("CONNES");
            Cursor_personbo.Next();
          }
          m_cConnectivityError = Cursor_personbo.ErrorMessage();
          Cursor_personbo.Close();
          // * --- End Select
        } // End If
        /* If not(Empty(_iban)) */
        if ( ! (CPLib.Empty(_iban))) {
          /* If Left(_iban,2)='IT' */
          if (CPLib.eqr(CPLib.Left(_iban,2),"IT")) {
            /* abicab := Substr(_iban,6,5)+"-"+Substr(_iban,11,5) */
            abicab = CPLib.Substr(_iban,6,5)+"-"+CPLib.Substr(_iban,11,5);
            /* If mcINTER2BO.HasKey(abicab) */
            if (mcINTER2BO.HasKey(abicab)) {
              /* If mcINTER2BO.GoToKey(abicab) */
              if (mcINTER2BO.GoToKey(abicab)) {
                /* rowFraz.TIPOINT2 := mcINTER2BO.TIPINTER */
                rowFraz.TIPOINT2 = mcINTER2BO.row.TIPINTER;
                /* rowFraz.CODINT2 := abicab */
                rowFraz.CODINT2 = abicab;
                /* rowFraz.PAESE := mcINTER2BO.PAESE */
                rowFraz.PAESE = mcINTER2BO.row.PAESE;
                /* rowFraz.DESC2 := mcINTER2BO.DESCCIT */
                rowFraz.DESC2 = mcINTER2BO.row.DESCCIT;
                /* rowFraz.PROV2 := mcINTER2BO.PROVINCIA */
                rowFraz.PROV2 = mcINTER2BO.row.PROVINCIA;
                /* rowFraz.CODCAB2 := mcINTER2BO.CODCAB */
                rowFraz.CODCAB2 = mcINTER2BO.row.CODCAB;
                /* rowFraz.DESCINTER := mcINTER2BO.RAGSOC */
                rowFraz.DESCINTER = mcINTER2BO.row.RAGSOC;
              } // End If
            } // End If
          } else { // Else
            /* abicab := Left(_iban,11) */
            abicab = CPLib.Left(_iban,11);
            /* rowFraz.CODINT2 := abicab */
            rowFraz.CODINT2 = abicab;
          } // End If
        } // End If
        // * --- Insert into fraziobo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("fraziobo");
        m_cPhName = m_Ctx.GetPhName("fraziobo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000727")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000727(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codana,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_cabinter,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codsin,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_citinter,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_drcol,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_tiporap,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(xData+cOpeProg2+"0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_ipcol,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_orcol,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_prvinter,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_idbiglietto,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_tipope,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_importo*100,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_env,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowFraz.TIPOINT2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(abicab,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowFraz.PAESE,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowFraz.DESC2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowFraz.PROV2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowFraz.CODCAB2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowFraz.DESCINTER,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowFraz.C_RAG,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowFraz.C_STA,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowFraz.C_CTA,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowFraz.C_CAB,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowFraz.C_PRV,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowFraz.C_IND,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowFraz.C_CAP,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowFraz.CONNESBEN,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowFraz.CONNESCLI,"?",0,0,m_cServer)+", ";
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
        }
        for (MemoryCursorRow_clientiope rwClienti : mcCLIENTI._iterable_()) {
          // * --- Insert into clientifrz from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("clientifrz");
          m_cPhName = m_Ctx.GetPhName("clientifrz");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientifrz",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_cgo_sched_tabs",974,"00000729")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000729(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(rwClienti.IDFILEBO,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rwClienti.CODSOG,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rwClienti.IDBASE,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
          }
        }
        /* fNumero := fNumero + 1 */
        fNumero = CPLib.Round(fNumero+1,0);
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
  public static arrt_imp_dati_cgo_sched_tabsR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_imp_dati_cgo_sched_tabsR(p_Ctx, p_Caller);
  }
  public void Blank() {
    fhand = CPLib.Space(1);
    riga = "";
    _tdest = CPLib.Space(1);
    xConnes = CPLib.Space(16);
    xCF = CPLib.Space(16);
    xRiga1 = "";
    xRiga2 = "";
    xRiga3 = "";
    xRiga4 = "";
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
    _intest = 0;
    _stoper = 0;
    _biglietto = CPLib.Space(28);
    _numass = CPLib.Space(25);
    _oldmodi = CPLib.Space(15);
    mcMultipla = new MemoryCursor_mctelematicomultiple_mcrdef();
    mcMatch = new MemoryCursor_mcmatchope_mcrdef();
    nTotRighe = 0;
    nTotValide = 0;
    nRighe = 0;
    _criga = 0;
    _match = CPLib.Space(1);
    _defmul = CPLib.Space(10);
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
    sNumero = 0;
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
    xFLGSAE = CPLib.Space(1);
    _coddip = CPLib.Space(6);
    _ipcol = CPLib.Space(20);
    _drcol = 0;
    _orcol = CPLib.NullDateTime();
    _idbiglietto = CPLib.Space(30);
    _rapporto = CPLib.Space(25);
    _env = CPLib.Space(1);
    _importo = 0;
    _iban = CPLib.Space(27);
    _flgaui = CPLib.Space(1);
    xSNAINUMOPE = CPLib.Space(15);
    mNumero = 0;
    nRigheSto = 0;
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
    _idb = CPLib.Space(30);
    _seekid = CPLib.Space(20);
    _flgnodoc = CPLib.Space(1);
    _snaistor = CPLib.Space(1);
    _tottele = 0;
    _codlob = CPLib.Space(3);
    _tipgio = CPLib.Space(3);
    nProgOpe = CPLib.Space(15);
    _cacodice = 0;
    _prgope1 = 0;
    _prgope2 = 0;
    _prgimpope = 0;
    _prgfrz1 = 0;
    _prgfrz2 = 0;
    _prgimpfrz = 0;
    _codcau = 0;
    _datini = CPLib.NullDate();
    _datend = CPLib.NullDate();
    _codrap = CPLib.Space(25);
    _intcon = CPLib.Space(16);
    _mezpagam = CPLib.Space(1);
    _MsgAss = "";
    _omulti = CPLib.Space(1);
    _omultic = CPLib.Space(1);
    _numopetele = CPLib.Space(15);
    _catipgio = 0;
    _catipcon = 0;
    _capv_cod = 0;
    _cadataora = CPLib.NullDateTime();
    _iddocall = CPLib.Space(36);
    _vpcodice = CPLib.Space(2);
    cColleg = CPLib.Space(12);
    _flglight = CPLib.Space(1);
    _flgope = CPLib.Space(1);
    mcTBCITTA = new MemoryCursor_tbcitta();
    mcTBSTATI = new MemoryCursor_tbstati();
    mcTBSTATI_D = new MemoryCursor_tbstati();
    mcCAUSALI = new MemoryCursor_cgo_causali();
    mcCAUSALI_C = new MemoryCursor_cgo_causali();
    mcTBTIPGIO = new MemoryCursor_cgo_tbtipgio();
    mcTIPDOC = new MemoryCursor_tbtipdoc();
    mcINTER2BO = new MemoryCursor_inter2bo();
    mcCLIENTI = new MemoryCursor_clientiope();
    rowSoggetti = new MemoryCursorRow_cgo_soggetti();
    rowTele = new MemoryCursorRow_cgo_telematico();
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_cgo_telematico_totali,qbe_cgo_anadip_totali,qbe_cgo_soggetti_totali,qbe_cgo_rapporti_totali,qbe_cgo_users_totali,qbe_cpusers_max,
  public static final String m_cVQRList = ",qbe_cgo_telematico_totali,qbe_cgo_anadip_totali,qbe_cgo_soggetti_totali,qbe_cgo_rapporti_totali,qbe_cgo_users_totali,qbe_cpusers_max,";
  // ENTITY_BATCHES: ,arfn_datesum,arfn_dt_to_date,arfn_dttod,arfn_fdate,arfn_fdatetime,arrt_cgo_save_multi_dl,arrt_snai_oper_save,arrt_writelog,
  public static final String i_InvokedRoutines = ",arfn_datesum,arfn_dt_to_date,arfn_dttod,arfn_fdate,arfn_fdatetime,arrt_cgo_save_multi_dl,arrt_snai_oper_save,arrt_writelog,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000186(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODDIP,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CAB,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"TELEFONO,";
    p_cSql = p_cSql+"CODLOC,";
    p_cSql = p_cSql+"CODICEAAMS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"anadip",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000018B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"CODLOC,";
    p_cSql = p_cSql+"CODICEAAMS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_anadip_err",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000018E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"MEZPAGAM,";
    p_cSql = p_cSql+"TIPOGIOCO,";
    p_cSql = p_cSql+"CODLOB,";
    p_cSql = p_cSql+"CATIPGIO,";
    p_cSql = p_cSql+"CATIPCON,";
    p_cSql = p_cSql+"CAPV_COD,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_telematico_err",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000240(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wersonbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000024B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODINTER,";
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
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000024F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODINTER,";
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
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000257(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000025D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_soggetti_err",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000261(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PRGRAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"TIPOMOV,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"CODINTEST,";
    p_cSql = p_cSql+"TXTERR,";
    p_cSql = p_cSql+"CASTATOC,";
    p_cSql = p_cSql+"CASTATOM,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_rapporti_err",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000264(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"MEZPAGAM,";
    p_cSql = p_cSql+"TIPOGIOCO,";
    p_cSql = p_cSql+"CODLOB,";
    p_cSql = p_cSql+"CATIPGIO,";
    p_cSql = p_cSql+"CATIPCON,";
    p_cSql = p_cSql+"CAPV_COD,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_telematico_err",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000026A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"MEZPAGAM,";
    p_cSql = p_cSql+"TIPOGIOCO,";
    p_cSql = p_cSql+"CODLOB,";
    p_cSql = p_cSql+"CATIPGIO,";
    p_cSql = p_cSql+"CATIPCON,";
    p_cSql = p_cSql+"CAPV_COD,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_telematico_err",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000026F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"MEZPAGAM,";
    p_cSql = p_cSql+"TIPOGIOCO,";
    p_cSql = p_cSql+"CODLOB,";
    p_cSql = p_cSql+"CATIPGIO,";
    p_cSql = p_cSql+"CATIPCON,";
    p_cSql = p_cSql+"CAPV_COD,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_telematico_err",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002AC(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"CASTATOC,";
    p_cSql = p_cSql+"CASTATOM,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xnarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002B0(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODINTER,";
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
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002B6(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xntestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002B7(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"CASTATOC,";
    p_cSql = p_cSql+"CASTATOM,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"anarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002BB(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODINTER,";
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
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002C1(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"intestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002C2(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"knarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002C9(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODINTER,";
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
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002D2(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODINTER,";
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
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002DC(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PRGRAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"TIPOMOV,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"CODINTEST,";
    p_cSql = p_cSql+"TXTERR,";
    p_cSql = p_cSql+"FLGFULL,";
    p_cSql = p_cSql+"CASTATOC,";
    p_cSql = p_cSql+"CASTATOM,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_rapporti_err",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002DF(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"MEZPAGAM,";
    p_cSql = p_cSql+"TIPOGIOCO,";
    p_cSql = p_cSql+"CODLOB,";
    p_cSql = p_cSql+"CATIPGIO,";
    p_cSql = p_cSql+"CATIPCON,";
    p_cSql = p_cSql+"CAPV_COD,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_telematico_err",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000388(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"MEZPAGAM,";
    p_cSql = p_cSql+"TIPOGIOCO,";
    p_cSql = p_cSql+"CODLOB,";
    p_cSql = p_cSql+"CATIPGIO,";
    p_cSql = p_cSql+"CATIPCON,";
    p_cSql = p_cSql+"CAPV_COD,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_telematico_err",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000003A8(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"code,";
    p_cSql = p_cSql+"name,";
    p_cSql = p_cSql+"passwd,";
    p_cSql = p_cSql+"enabled,";
    p_cSql = p_cSql+"companies,";
    p_cSql = p_cSql+"fullname,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpusers",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000003A9(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODE,";
    p_cSql = p_cSql+"CODDIP,";
    p_cSql = p_cSql+"SUPERDIP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpusers_add",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000003AA(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"groupcode,";
    p_cSql = p_cSql+"usercode,";
    p_cSql = p_cSql+"companies,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpusrgrp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000443(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"sraziobo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000449(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"slientifrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000044F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"slientifrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000499(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ASSEGNO,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"CACODICE,";
    p_cSql = p_cSql+"CADATAORA,";
    p_cSql = p_cSql+"CAFLGOPE,";
    p_cSql = p_cSql+"CAIDBIGLIETTO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CAPV_COD,";
    p_cSql = p_cSql+"CATIPCON,";
    p_cSql = p_cSql+"CATIPGIO,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+"CGODIPCOM,";
    p_cSql = p_cSql+"CGOFLGVLT,";
    p_cSql = p_cSql+"CGOFLGVNP,";
    p_cSql = p_cSql+"CGOTIPOPE,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCABDIP,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODLOB,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCCITDIP,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLGDOCALL,";
    p_cSql = p_cSql+"IBAN,";
    p_cSql = p_cSql+"IDDOCALL,";
    p_cSql = p_cSql+"MEZPAGAM,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"NUMOPEDL,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PEP,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"PROVINCIADIP,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RDCODAUT,";
    p_cSql = p_cSql+"RDLOCAUT,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"SNAINUMOPE,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPINTER,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"TIPOGIOCO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TIPOPEDL,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"VLTPLAT,";
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
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_operazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000004A8(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ASSEGNO,";
    p_cSql = p_cSql+"CACODICE,";
    p_cSql = p_cSql+"CADATAORA,";
    p_cSql = p_cSql+"CAFLGOPE,";
    p_cSql = p_cSql+"CAIDBIGLIETTO,";
    p_cSql = p_cSql+"CAPV_COD,";
    p_cSql = p_cSql+"CATIPCON,";
    p_cSql = p_cSql+"CATIPGIO,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CGODIPCOM,";
    p_cSql = p_cSql+"CGOFLGVLT,";
    p_cSql = p_cSql+"CGOFLGVNP,";
    p_cSql = p_cSql+"CGOTIPOPE,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCABDIP,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODLOB,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCITDIP,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLGDOCALL,";
    p_cSql = p_cSql+"IDDOCALL,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PEP,";
    p_cSql = p_cSql+"PROVINCIADIP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"SNAINUMOPE,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOGIOCO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TIPOPEDL,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"VLTPLAT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_operazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000004EE(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ASSEGNO,";
    p_cSql = p_cSql+"CACODICE,";
    p_cSql = p_cSql+"CADATAORA,";
    p_cSql = p_cSql+"CAFLGOPE,";
    p_cSql = p_cSql+"CAIDBIGLIETTO,";
    p_cSql = p_cSql+"CAPV_COD,";
    p_cSql = p_cSql+"CATIPCON,";
    p_cSql = p_cSql+"CATIPGIO,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CGOFLGVLT,";
    p_cSql = p_cSql+"CGOFLGVNP,";
    p_cSql = p_cSql+"CGOTIPOPE,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCABDIP,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODLOB,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCITDIP,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLGDOCALL,";
    p_cSql = p_cSql+"IDDOCALL,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PEP,";
    p_cSql = p_cSql+"PROVINCIADIP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"SNAINUMOPE,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOGIOCO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"VLTPLAT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_operazioni_dl_multi_dc",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000004F2(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"SNAINUMOPE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CAIDBIGLIETTO,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"FLGFULL,";
    p_cSql = p_cSql+"DATOPE,";
    p_cSql = p_cSql+"CACODICE,";
    p_cSql = p_cSql+"CODLOB,";
    p_cSql = p_cSql+"TIPOGIOCO,";
    p_cSql = p_cSql+"CATIPGIO,";
    p_cSql = p_cSql+"CATIPCON,";
    p_cSql = p_cSql+"CGOTIPOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_operazioni_dl_multi_dt_dc",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000520(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
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
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_aams_base",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000053E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
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
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_aams_base",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000573(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xperazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000579(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xlientiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000057C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TODATOPE,";
    p_cSql = p_cSql+"TOCODSOG,";
    p_cSql = p_cSql+"TO_SEGNO,";
    p_cSql = p_cSql+"TONUMOPE,";
    p_cSql = p_cSql+"TOIMPORT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_totope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000581(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xlientiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000584(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TODATOPE,";
    p_cSql = p_cSql+"TOCODSOG,";
    p_cSql = p_cSql+"TO_SEGNO,";
    p_cSql = p_cSql+"TONUMOPE,";
    p_cSql = p_cSql+"TOIMPORT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_totope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000595(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000059B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"clientiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000059E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TODATOPE,";
    p_cSql = p_cSql+"TOCODSOG,";
    p_cSql = p_cSql+"TO_SEGNO,";
    p_cSql = p_cSql+"TONUMOPE,";
    p_cSql = p_cSql+"TOIMPORT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_totope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000005A3(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"clientiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000005A5(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TODATOPE,";
    p_cSql = p_cSql+"TOCODSOG,";
    p_cSql = p_cSql+"TO_SEGNO,";
    p_cSql = p_cSql+"TONUMOPE,";
    p_cSql = p_cSql+"TOIMPORT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_totope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000005B7(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xraziobo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000005BD(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xlientifrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000005C3(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xlientifrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000005D5(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"fraziobo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000005DB(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"clientifrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000005E1(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"clientifrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000005F5(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"CONNESCLI,";
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
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xperazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000606(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"CONNESCLI,";
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
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000618(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"CONNESCLI,";
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
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xraziobo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000629(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"CONNESCLI,";
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
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"fraziobo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000639(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CODLOB,";
    p_cSql = p_cSql+"TIPOGIOCO,";
    p_cSql = p_cSql+"CACODICE,";
    p_cSql = p_cSql+"IDBIGLIETTO,";
    p_cSql = p_cSql+"CATIPGIO,";
    p_cSql = p_cSql+"CATIPCON,";
    p_cSql = p_cSql+"CAPV_COD,";
    p_cSql = p_cSql+"CADATAORA,";
    p_cSql = p_cSql+"VPCODICE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"sraziobo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000063C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CODLOB,";
    p_cSql = p_cSql+"TIPOGIOCO,";
    p_cSql = p_cSql+"CACODICE,";
    p_cSql = p_cSql+"IDBIGLIETTO,";
    p_cSql = p_cSql+"CATIPGIO,";
    p_cSql = p_cSql+"CATIPCON,";
    p_cSql = p_cSql+"CAPV_COD,";
    p_cSql = p_cSql+"CADATAORA,";
    p_cSql = p_cSql+"VPCODICE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xperazbo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000063D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CODLOB,";
    p_cSql = p_cSql+"TIPOGIOCO,";
    p_cSql = p_cSql+"CACODICE,";
    p_cSql = p_cSql+"IDBIGLIETTO,";
    p_cSql = p_cSql+"CATIPGIO,";
    p_cSql = p_cSql+"CATIPCON,";
    p_cSql = p_cSql+"CAPV_COD,";
    p_cSql = p_cSql+"CADATAORA,";
    p_cSql = p_cSql+"VPCODICE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000063F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CODLOB,";
    p_cSql = p_cSql+"TIPOGIOCO,";
    p_cSql = p_cSql+"CACODICE,";
    p_cSql = p_cSql+"IDBIGLIETTO,";
    p_cSql = p_cSql+"CATIPGIO,";
    p_cSql = p_cSql+"CATIPCON,";
    p_cSql = p_cSql+"CAPV_COD,";
    p_cSql = p_cSql+"CADATAORA,";
    p_cSql = p_cSql+"VPCODICE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xraziobo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000640(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CODLOB,";
    p_cSql = p_cSql+"TIPOGIOCO,";
    p_cSql = p_cSql+"CACODICE,";
    p_cSql = p_cSql+"IDBIGLIETTO,";
    p_cSql = p_cSql+"CATIPGIO,";
    p_cSql = p_cSql+"CATIPCON,";
    p_cSql = p_cSql+"CAPV_COD,";
    p_cSql = p_cSql+"CADATAORA,";
    p_cSql = p_cSql+"VPCODICE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"fraziobo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000659(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TODATOPE,";
    p_cSql = p_cSql+"TOCODSOG,";
    p_cSql = p_cSql+"TO_SEGNO,";
    p_cSql = p_cSql+"TONUMOPE,";
    p_cSql = p_cSql+"TOIMPORT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_totope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000664(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TODATOPE,";
    p_cSql = p_cSql+"TOCODSOG,";
    p_cSql = p_cSql+"TO_SEGNO,";
    p_cSql = p_cSql+"TONUMOPE,";
    p_cSql = p_cSql+"TOIMPORT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_totope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000067D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xperazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000067F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xlientiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000690(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TODATOPE,";
    p_cSql = p_cSql+"TOCODSOG,";
    p_cSql = p_cSql+"TO_SEGNO,";
    p_cSql = p_cSql+"TONUMOPE,";
    p_cSql = p_cSql+"TOIMPORT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_totope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000069B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TODATOPE,";
    p_cSql = p_cSql+"TOCODSOG,";
    p_cSql = p_cSql+"TO_SEGNO,";
    p_cSql = p_cSql+"TONUMOPE,";
    p_cSql = p_cSql+"TOIMPORT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_totope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000006B5(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000006B7(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"clientiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000006F2(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xraziobo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000006F4(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xlientifrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000727(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"fraziobo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000729(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"clientifrz",true);
    return p_cSql;
  }
}
