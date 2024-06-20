// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_import_unicreditR implements CallerWithObjs {
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
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_knarapbo;
  public String m_cServer_knarapbo;
  public String m_cPhName_mtimperr;
  public String m_cServer_mtimperr;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_personbo_agg;
  public String m_cServer_personbo_agg;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public String m_cPhName_tbvalute;
  public String m_cServer_tbvalute;
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
  public String m_cPhName_wuchkimp;
  public String m_cServer_wuchkimp;
  public String m_cPhName_wuchkunicr;
  public String m_cServer_wuchkunicr;
  public String m_cPhName_wurapporti;
  public String m_cServer_wurapporti;
  public String m_cPhName_xapopebo;
  public String m_cServer_xapopebo;
  public String m_cPhName_xnarapbo;
  public String m_cServer_xnarapbo;
  public String m_cPhName_xntestbo;
  public String m_cServer_xntestbo;
  public String m_cPhName_tbmacage;
  public String m_cServer_tbmacage;
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
  public String w_tipodest;
  public String w_nomefile;
  public String w_codmage;
  public String fhand;
  public String riga;
  public double eProg;
  public String xConnes;
  public String _tdest;
  public String xCF;
  public String xSOCTCon;
  public String xSOCTCF;
  public String xCodCab;
  public String xCitta;
  public String cCliProg;
  public String cInfProg1;
  public String cInfProg2;
  public String cOpeProg1;
  public String cOpeProg2;
  public String cProgSto;
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
  public double cNumChi;
  public double cNumSca;
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
  public String cPNAS;
  public String cSRES;
  public String cSRES2;
  public String _unicode;
  public double _salta;
  public double _allineamento;
  public double _allineatonomecnome;
  public String _ragsocold;
  public String _cabold;
  public double nProgImp;
  public double nProgImp2;
  public String _idbase;
  public String _codinter;
  public String _citinter;
  public String _cabinter;
  public String _prvinter;
  public String _intercod;
  public String _intercit;
  public String _intercab;
  public String _interprv;
  public String _intertip;
  public String _tipper;
  public String _benrag;
  public String _bensta;
  public String _bencta;
  public String _bencab;
  public String _benprv;
  public String _benind;
  public String _bencap;
  public String _oldreg;
  public String _idreg;
  public String _flagrap2;
  public String xProvRes;
  public String _connes;
  public double _numrec;
  public double _nummod;
  public String _oldmac;
  public String _oldrag;
  public String _oldcon;
  public double _aggcli;
  public double _nriga;
  public String _xrapporto;
  public String _magecod;
  public String ciidbase;
  public java.sql.Date cidataini;
  public java.sql.Date cidatafine;
  public String cicodinter;
  public String cinumprog;
  public String citiporap;
  public String w_xMADESCRI;
  public String w_xMADIPSTD;
  public String w_xMAFLGBON;
  public String w_xMAFLGRAP;
  public String gPathApp;
  public String gAzienda;
  public String gMsgImp;
  public String gMsgProc;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_import_unicredit
  public String[] lista;
  public int conteggio;
  public int i;
  public int contanome;
  // * --- Fine Area Manuale
  public arrt_import_unicreditR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_import_unicredit",m_Caller);
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
    m_cPhName_mtimperr = p_ContextObject.GetPhName("mtimperr");
    if (m_cPhName_mtimperr.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mtimperr = m_cPhName_mtimperr+" "+m_Ctx.GetWritePhName("mtimperr");
    }
    m_cServer_mtimperr = p_ContextObject.GetServer("mtimperr");
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
    m_cPhName_tbvalute = p_ContextObject.GetPhName("tbvalute");
    if (m_cPhName_tbvalute.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbvalute = m_cPhName_tbvalute+" "+m_Ctx.GetWritePhName("tbvalute");
    }
    m_cServer_tbvalute = p_ContextObject.GetServer("tbvalute");
    m_cPhName_wersonbo = p_ContextObject.GetPhName("wersonbo");
    if (m_cPhName_wersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo = m_cPhName_wersonbo+" "+m_Ctx.GetWritePhName("wersonbo");
    }
    m_cServer_wersonbo = p_ContextObject.GetServer("wersonbo");
    m_cPhName_wuchkimp = p_ContextObject.GetPhName("wuchkimp");
    if (m_cPhName_wuchkimp.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wuchkimp = m_cPhName_wuchkimp+" "+m_Ctx.GetWritePhName("wuchkimp");
    }
    m_cServer_wuchkimp = p_ContextObject.GetServer("wuchkimp");
    m_cPhName_wuchkunicr = p_ContextObject.GetPhName("wuchkunicr");
    if (m_cPhName_wuchkunicr.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wuchkunicr = m_cPhName_wuchkunicr+" "+m_Ctx.GetWritePhName("wuchkunicr");
    }
    m_cServer_wuchkunicr = p_ContextObject.GetServer("wuchkunicr");
    m_cPhName_wurapporti = p_ContextObject.GetPhName("wurapporti");
    if (m_cPhName_wurapporti.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wurapporti = m_cPhName_wurapporti+" "+m_Ctx.GetWritePhName("wurapporti");
    }
    m_cServer_wurapporti = p_ContextObject.GetServer("wurapporti");
    m_cPhName_xapopebo = p_ContextObject.GetPhName("xapopebo");
    if (m_cPhName_xapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xapopebo = m_cPhName_xapopebo+" "+m_Ctx.GetWritePhName("xapopebo");
    }
    m_cServer_xapopebo = p_ContextObject.GetServer("xapopebo");
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
    m_cPhName_tbmacage = p_ContextObject.GetPhName("tbmacage");
    if (m_cPhName_tbmacage.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbmacage = m_cPhName_tbmacage+" "+m_Ctx.GetWritePhName("tbmacage");
    }
    m_cServer_tbmacage = p_ContextObject.GetServer("tbmacage");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("eProg",p_cVarName)) {
      return eProg;
    }
    if (CPLib.eqr("cNumNew",p_cVarName)) {
      return cNumNew;
    }
    if (CPLib.eqr("cNumMod",p_cVarName)) {
      return cNumMod;
    }
    if (CPLib.eqr("cNumChi",p_cVarName)) {
      return cNumChi;
    }
    if (CPLib.eqr("cNumSca",p_cVarName)) {
      return cNumSca;
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
    if (CPLib.eqr("_numrec",p_cVarName)) {
      return _numrec;
    }
    if (CPLib.eqr("_nummod",p_cVarName)) {
      return _nummod;
    }
    if (CPLib.eqr("_aggcli",p_cVarName)) {
      return _aggcli;
    }
    if (CPLib.eqr("_nriga",p_cVarName)) {
      return _nriga;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_import_unicredit";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("tipodest",p_cVarName)) {
      return w_tipodest;
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      return w_nomefile;
    }
    if (CPLib.eqr("codmage",p_cVarName)) {
      return w_codmage;
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
    if (CPLib.eqr("_tdest",p_cVarName)) {
      return _tdest;
    }
    if (CPLib.eqr("xCF",p_cVarName)) {
      return xCF;
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
    if (CPLib.eqr("cProgSto",p_cVarName)) {
      return cProgSto;
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
    if (CPLib.eqr("cPNAS",p_cVarName)) {
      return cPNAS;
    }
    if (CPLib.eqr("cSRES",p_cVarName)) {
      return cSRES;
    }
    if (CPLib.eqr("cSRES2",p_cVarName)) {
      return cSRES2;
    }
    if (CPLib.eqr("_unicode",p_cVarName)) {
      return _unicode;
    }
    if (CPLib.eqr("_ragsocold",p_cVarName)) {
      return _ragsocold;
    }
    if (CPLib.eqr("_cabold",p_cVarName)) {
      return _cabold;
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
    if (CPLib.eqr("_intertip",p_cVarName)) {
      return _intertip;
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
    if (CPLib.eqr("_oldreg",p_cVarName)) {
      return _oldreg;
    }
    if (CPLib.eqr("_idreg",p_cVarName)) {
      return _idreg;
    }
    if (CPLib.eqr("_flagrap2",p_cVarName)) {
      return _flagrap2;
    }
    if (CPLib.eqr("xProvRes",p_cVarName)) {
      return xProvRes;
    }
    if (CPLib.eqr("_connes",p_cVarName)) {
      return _connes;
    }
    if (CPLib.eqr("_oldmac",p_cVarName)) {
      return _oldmac;
    }
    if (CPLib.eqr("_oldrag",p_cVarName)) {
      return _oldrag;
    }
    if (CPLib.eqr("_oldcon",p_cVarName)) {
      return _oldcon;
    }
    if (CPLib.eqr("_xrapporto",p_cVarName)) {
      return _xrapporto;
    }
    if (CPLib.eqr("_magecod",p_cVarName)) {
      return _magecod;
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
    if (CPLib.eqr("xMADESCRI",p_cVarName)) {
      return w_xMADESCRI;
    }
    if (CPLib.eqr("xMADIPSTD",p_cVarName)) {
      return w_xMADIPSTD;
    }
    if (CPLib.eqr("xMAFLGBON",p_cVarName)) {
      return w_xMAFLGBON;
    }
    if (CPLib.eqr("xMAFLGRAP",p_cVarName)) {
      return w_xMAFLGRAP;
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
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
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
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("eProg",p_cVarName)) {
      eProg = value;
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
    if (CPLib.eqr("cNumChi",p_cVarName)) {
      cNumChi = value;
      return;
    }
    if (CPLib.eqr("cNumSca",p_cVarName)) {
      cNumSca = value;
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
    if (CPLib.eqr("_numrec",p_cVarName)) {
      _numrec = value;
      return;
    }
    if (CPLib.eqr("_nummod",p_cVarName)) {
      _nummod = value;
      return;
    }
    if (CPLib.eqr("_aggcli",p_cVarName)) {
      _aggcli = value;
      return;
    }
    if (CPLib.eqr("_nriga",p_cVarName)) {
      _nriga = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("tipodest",p_cVarName)) {
      w_tipodest = value;
      return;
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      w_nomefile = value;
      return;
    }
    if (CPLib.eqr("codmage",p_cVarName)) {
      w_codmage = value;
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
    if (CPLib.eqr("_tdest",p_cVarName)) {
      _tdest = value;
      return;
    }
    if (CPLib.eqr("xCF",p_cVarName)) {
      xCF = value;
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
    if (CPLib.eqr("cProgSto",p_cVarName)) {
      cProgSto = value;
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
    if (CPLib.eqr("cPNAS",p_cVarName)) {
      cPNAS = value;
      return;
    }
    if (CPLib.eqr("cSRES",p_cVarName)) {
      cSRES = value;
      return;
    }
    if (CPLib.eqr("cSRES2",p_cVarName)) {
      cSRES2 = value;
      return;
    }
    if (CPLib.eqr("_unicode",p_cVarName)) {
      _unicode = value;
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
    if (CPLib.eqr("_intertip",p_cVarName)) {
      _intertip = value;
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
    if (CPLib.eqr("_oldreg",p_cVarName)) {
      _oldreg = value;
      return;
    }
    if (CPLib.eqr("_idreg",p_cVarName)) {
      _idreg = value;
      return;
    }
    if (CPLib.eqr("_flagrap2",p_cVarName)) {
      _flagrap2 = value;
      return;
    }
    if (CPLib.eqr("xProvRes",p_cVarName)) {
      xProvRes = value;
      return;
    }
    if (CPLib.eqr("_connes",p_cVarName)) {
      _connes = value;
      return;
    }
    if (CPLib.eqr("_oldmac",p_cVarName)) {
      _oldmac = value;
      return;
    }
    if (CPLib.eqr("_oldrag",p_cVarName)) {
      _oldrag = value;
      return;
    }
    if (CPLib.eqr("_oldcon",p_cVarName)) {
      _oldcon = value;
      return;
    }
    if (CPLib.eqr("_xrapporto",p_cVarName)) {
      _xrapporto = value;
      return;
    }
    if (CPLib.eqr("_magecod",p_cVarName)) {
      _magecod = value;
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
    if (CPLib.eqr("xMADESCRI",p_cVarName)) {
      w_xMADESCRI = value;
      return;
    }
    if (CPLib.eqr("xMADIPSTD",p_cVarName)) {
      w_xMADIPSTD = value;
      return;
    }
    if (CPLib.eqr("xMAFLGBON",p_cVarName)) {
      w_xMAFLGBON = value;
      return;
    }
    if (CPLib.eqr("xMAFLGRAP",p_cVarName)) {
      w_xMAFLGRAP = value;
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
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
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
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_intermbo=null;
    CPResultSet Read_Cursor=null;
    try {
      /* w_tipodest Char(1) */
      /* w_nomefile Char(100) */
      /* w_codmage Char(5) */
      /* fhand Char(1) */
      /* riga Memo */
      /* eProg Numeric(10, 0) */
      /* xConnes Char(16) */
      /* _tdest Char(1) */
      /* xCF Char(16) */
      /* xSOCTCon Char(16) */
      /* xSOCTCF Char(16) */
      /* xCodCab Char(6) */
      /* xCitta Char(30) */
      /* cCliProg Char(6) */
      /* cInfProg1 Char(10) */
      /* cInfProg2 Char(11) */
      /* cOpeProg1 Char(10) */
      /* cOpeProg2 Char(11) */
      /* cProgSto Char(15) */
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
      /* cNumChi Numeric(10, 0) // Contatore record invariati */
      /* cNumSca Numeric(10, 0) // Contatore record invariati */
      /* cFlagLire Char(1) */
      /* cFlagCont Char(1) */
      /* cFlagFraz Char(1) */
      /* cMaxRow Numeric(4, 0) */
      /* cIdCau Char(4) */
      /* xCFE Numeric(1, 0) */
      /* conta Numeric(10, 0) */
      /* _esito Numeric(1, 0) */
      /* cSNAS Char(30) */
      /* cCNAS Char(30) */
      /* cPNAS Char(2) */
      /* cSRES Char(40) */
      /* cSRES2 Char(3) */
      /* _unicode Char(10) */
      /* _salta Numeric(1, 0) */
      /* _allineamento Numeric(1, 0) */
      /* _allineatonomecnome Numeric(1, 0) */
      /* _ragsocold Char(70) */
      /* _cabold Char(6) */
      /* nProgImp Numeric(15, 0) */
      /* nProgImp2 Numeric(15, 0) */
      /* _idbase Char(10) */
      /* _codinter Char(11) */
      /* _citinter Char(30) */
      /* _cabinter Char(6) */
      /* _prvinter Char(2) */
      /* _intercod Char(11) */
      /* _intercit Char(30) */
      /* _intercab Char(6) */
      /* _interprv Char(2) */
      /* _intertip Char(2) */
      /* _tipper Char(1) */
      /* _benrag Char(70) */
      /* _bensta Char(3) */
      /* _bencta Char(30) */
      /* _bencab Char(6) */
      /* _benprv Char(2) */
      /* _benind Char(35) */
      /* _bencap Char(5) */
      /* _oldreg Char(20) */
      /* _idreg Char(20) */
      /* _flagrap2 Char(1) */
      /* xProvRes Char(2) */
      /* _connes Char(16) */
      /* _numrec Numeric(5, 0) */
      /* _nummod Numeric(5, 0) */
      /* _oldmac Char(5) */
      /* _oldrag Char(70) */
      /* _oldcon Char(70) */
      /* _aggcli Numeric(1, 0) */
      /* _nriga Numeric(10, 0) */
      /* _xrapporto Char(25) */
      /* _magecod Char(5) */
      /* ciidbase Char(10) */
      /* cidataini Date */
      /* cidatafine Date */
      /* cicodinter Char(12) */
      /* cinumprog Char(11) */
      /* citiporap Char(1) */
      /* w_xMADESCRI Char(60) // Denominazione */
      /* w_xMADIPSTD Char(6) // Dipendenza Default */
      /* w_xMAFLGBON Char(1) // Scrive tipo operazione come bonifico */
      /* w_xMAFLGRAP Char(1) // Generazione Rapporti da operazioni */
      /* gPathApp Char(80) // Path Applicazione */
      /* gAzienda Char(10) // Azienda */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio */
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
        /* _intertip := intermbo->TIPINTER */
        _intertip = Cursor_intermbo.GetString("TIPINTER");
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      // * --- Read from tbmacage
      m_cServer = m_Ctx.GetServer("tbmacage");
      m_cPhName = m_Ctx.GetPhName("tbmacage");
      m_cSql = "";
      m_cSql = m_cSql+"MACODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codmage,"C",5,0,m_cServer),m_cServer,w_codmage);
      if (m_Ctx.IsSharedTemp("tbmacage")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("MADESCRI",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("MAFLGRAP",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("MAFLGBON",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("MADIPSTD",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        w_xMADESCRI = Read_Cursor.GetString("MADESCRI");
        w_xMAFLGRAP = Read_Cursor.GetString("MAFLGRAP");
        w_xMAFLGBON = Read_Cursor.GetString("MAFLGBON");
        w_xMADIPSTD = Read_Cursor.GetString("MADIPSTD");
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on tbmacage into routine arrt_import_unicredit returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        w_xMADESCRI = "";
        w_xMAFLGRAP = "";
        w_xMAFLGBON = "";
        w_xMADIPSTD = "";
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
      /* Import Soggetti */
      /* gMsgProc := '' */
      gMsgProc = "";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Cicla sul file della lista e lancia la pagina appropriata */
      /* _esito := 0 */
      _esito = CPLib.Round(0,0);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000075status;
      nTry00000075status = m_Sql.GetTransactionStatus();
      String cTry00000075msg;
      cTry00000075msg = m_Sql.TransactionErrorMessage();
      try {
        /* cNumNew := 0 */
        cNumNew = CPLib.Round(0,0);
        /* cNumMod := 0 */
        cNumMod = CPLib.Round(0,0);
        /* cNumChi := 0 */
        cNumChi = CPLib.Round(0,0);
        /* cNumSca := 0 */
        cNumSca = CPLib.Round(0,0);
        /* _numrec := 0 */
        _numrec = CPLib.Round(0,0);
        /* conta := 0 */
        conta = CPLib.Round(0,0);
        /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + LRTrim(w_nomefile) + NL */
        gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+CPLib.LRTrim(w_nomefile)+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* fhand := FileLibMit.OpenRead('appo/'+LRTrim(gAzienda)+"/"+LRTrim(w_nomefile)) */
        fhand = FileLibMit.OpenRead("appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(w_nomefile));
        /* While not(FileLibMit.Eof(fhand)) */
        while ( ! (FileLibMit.Eof(fhand))) {
          /* riga := FileLibMit.ReadLine(fhand) */
          riga = FileLibMit.ReadLine(fhand);
          /* If Len(LRTrim(riga)) > 0 */
          if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _numrec := _numrec + 1 */
            _numrec = CPLib.Round(_numrec+1,0);
            /* conta := conta + 1 */
            conta = CPLib.Round(conta+1,0);
            /* If Len(LRTrim(Substr(riga,17,16)))  < 16 */
            if (CPLib.lt(CPLib.Len(CPLib.LRTrim(CPLib.Substr(riga,17,16))),16)) {
              /* _esito := 1 */
              _esito = CPLib.Round(1,0);
            } else { // Else
              /* If Substr(riga,33,1)='1' */
              if (CPLib.eqr(CPLib.Substr(riga,33,1),"1")) {
                /* Exec "Nuovo Rapporto" Page 2:Page_2 */
                Page_2();
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
                /* ElseIf Substr(riga,33,1)='2' */
              } else if (CPLib.eqr(CPLib.Substr(riga,33,1),"2")) {
                /* Exec "Aggiorna Rapporto" Page 3:Page_3 */
                Page_3();
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
                /* cNumMod := cNumMod + 1 */
                cNumMod = CPLib.Round(cNumMod+1,0);
                /* ElseIf Substr(riga,33,1)='3' */
              } else if (CPLib.eqr(CPLib.Substr(riga,33,1),"3")) {
                /* Exec "Chiusura Rapporto" Page 4:Page_4 */
                Page_4();
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
                /* cNumChi := cNumChi + 1 */
                cNumChi = CPLib.Round(cNumChi+1,0);
              } // End If
            } // End If
          } // End If
          /* If _esito = 1 */
          if (CPLib.eqr(_esito,1)) {
            // Exit Loop
            if (true) {
              break;
            }
          } // End If
          /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(_numrec,10,0))+' riferimenti del file '+LRTrim(w_nomefile) // Messaggio Import */
          gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(_numrec,10,0))+" riferimenti del file "+CPLib.LRTrim(w_nomefile);
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } // End While
        /* FileLibMit.Close(fhand) */
        FileLibMit.Close(fhand);
        /* FileLibMit.DeleteFile('appo/'+LRTrim(gAzienda)+"/"+LRTrim(w_nomefile)) */
        FileLibMit.DeleteFile("appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(w_nomefile));
        /* If _esito=1 */
        if (CPLib.eqr(_esito,1)) {
          /* gMsgProc := gMsgProc + "Presente registrazione non valida. Riga "+LRTrim(Str(_numrec,10,0)) + NL */
          gMsgProc = gMsgProc+"Presente registrazione non valida. Riga "+CPLib.LRTrim(CPLib.Str(_numrec,10,0))+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgProc := gMsgProc + "Rilevati errori nell'impotazione dei file! Ricreare il file segnalato e rieseguire l'import dei dati. La procedura annullera automaticamente l'importazione" + NL */
          gMsgProc = gMsgProc+"Rilevati errori nell'impotazione dei file! Ricreare il file segnalato e rieseguire l'import dei dati. La procedura annullera automaticamente l'importazione"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +LRTrim(w_nomefile) + NL */
          gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+CPLib.LRTrim(w_nomefile)+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgImp := "Importazione dati interrotta per presenza errori" // Messaggio */
          gMsgImp = "Importazione dati interrotta per presenza errori";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // Transaction Error
          m_Sql.AbortTransaction();
        } else { // Else
          /* gMsgProc := gMsgProc + 'Record Elaborati: '+LRTrim(Str(_numrec,10,0)) + ' dal file '+LRTrim(w_nomefile)+NL */
          gMsgProc = gMsgProc+"Record Elaborati: "+CPLib.LRTrim(CPLib.Str(_numrec,10,0))+" dal file "+CPLib.LRTrim(w_nomefile)+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgProc := gMsgProc + 'Nuovi Rapporti: '+LRTrim(Str(cNumNew,10,0)) + ' - Rapporti Aggiornati: '+LRTrim(Str(cNumMod,10,0)) + ' - Rapporti Scartati:'+LRTrim(Str(cNumSca,10,0)) + ' - Rapporti Chiusi:'+LRTrim(Str(cNumChi,10,0)) + NL */
          gMsgProc = gMsgProc+"Nuovi Rapporti: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+" - Rapporti Aggiornati: "+CPLib.LRTrim(CPLib.Str(cNumMod,10,0))+" - Rapporti Scartati:"+CPLib.LRTrim(CPLib.Str(cNumSca,10,0))+" - Rapporti Chiusi:"+CPLib.LRTrim(CPLib.Str(cNumChi,10,0))+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +LRTrim(w_nomefile) + NL */
          gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+CPLib.LRTrim(w_nomefile)+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgImp := 'Importazione dati terminata.' // Messaggio Import */
          gMsgImp = "Importazione dati terminata.";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // Commit
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          m_Sql.CompleteTransaction();
        } // End If
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000075status,0)) {
          m_Sql.SetTransactionStatus(nTry00000075status,cTry00000075msg);
        }
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
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_intestbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_xntestbo=null;
    try {
      /* Nuovo Rapporto */
      /* _nuovo Numeric(1, 0) */
      double _nuovo;
      _nuovo = 0;
      /* cProgRap Char(10) */
      String cProgRap;
      cProgRap = CPLib.Space(10);
      /* _codrap Char(16) */
      String _codrap;
      _codrap = CPLib.Space(16);
      /* Verifica Esistenza Rapporto */
      /* _xrapporto := '' */
      _xrapporto = "";
      /* _nuovo := 0 */
      _nuovo = CPLib.Round(0,0);
      /* _magecod := '' */
      _magecod = "";
      /* If w_xMAFLGRAP='S' */
      if (CPLib.eqr(w_xMAFLGRAP,"S")) {
        // * --- Select from intestbo
        m_cServer = m_Ctx.GetServer("intestbo");
        m_cPhName = m_Ctx.GetPhName("intestbo");
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
        Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,17,16),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Substr(riga,17,16))+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intestbo.Eof())) {
          // * --- Read from anarapbo
          m_cServer = m_Ctx.GetServer("anarapbo");
          m_cPhName = m_Ctx.GetPhName("anarapbo");
          m_cSql = "";
          m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_intestbo.GetString("RAPPORTO"));
          if (m_Ctx.IsSharedTemp("anarapbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("MACODICE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _magecod = Read_Cursor.GetString("MACODICE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on anarapbo into routine arrt_import_unicredit returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _magecod = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If _magecod=w_codmage */
          if (CPLib.eqr(_magecod,w_codmage)) {
            /* _xrapporto := intestbo->RAPPORTO */
            _xrapporto = Cursor_intestbo.GetString("RAPPORTO");
          } // End If
          Cursor_intestbo.Next();
        }
        m_cConnectivityError = Cursor_intestbo.ErrorMessage();
        Cursor_intestbo.Close();
        // * --- End Select
        /* If Len(LRTrim(xRapporto)) <> 0 and Left(xRapporto,5)=w_codmage */
        if (CPLib.ne(CPLib.Len(CPLib.LRTrim(xRapporto)),0) && CPLib.eqr(CPLib.Left(xRapporto,5),w_codmage)) {
          /* _nuovo := 1 */
          _nuovo = CPLib.Round(1,0);
        } // End If
      } // End If
      /* If _nuovo=0 */
      if (CPLib.eqr(_nuovo,0)) {
        /* _xrapporto := '' */
        _xrapporto = "";
        // * --- Read from knarapbo
        m_cServer = m_Ctx.GetServer("knarapbo");
        m_cPhName = m_Ctx.GetPhName("knarapbo");
        m_cSql = "";
        m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,17,16),"C",25,0,m_cServer),m_cServer,CPLib.Substr(riga,17,16));
        if (m_Ctx.IsSharedTemp("knarapbo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _xrapporto = Read_Cursor.GetString("RAPPORTO");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on knarapbo into routine arrt_import_unicredit returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _xrapporto = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If Empty(LRTrim(_xrapporto)) */
        if (CPLib.Empty(CPLib.LRTrim(_xrapporto))) {
          /* If w_xMAFLGRAP='S' */
          if (CPLib.eqr(w_xMAFLGRAP,"S")) {
            /* cProgRap := Utilities.GetAutonumber("PRG"+LRTrim(w_codmage)+"\'"+LRTrim(gAzienda)+"'",'',10) */
            cProgRap = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRG"+CPLib.LRTrim(w_codmage)+"\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
            /* _codrap := LRTrim(w_codmage)+cProgRap */
            _codrap = CPLib.LRTrim(w_codmage)+cProgRap;
            // * --- Insert into wurapporti from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("wurapporti");
            m_cPhName = m_Ctx.GetPhName("wurapporti");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wurapporti",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"000000B3")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000B3(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_codmage,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProgRap,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,17,16),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wurapporti",true);
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
            /* _codrap := Substr(riga,17,16) */
            _codrap = CPLib.Substr(riga,17,16);
          } // End If
          /* nProgImp := Utilities.GetAutonumber("PRGIMPRAP\'"+LRTrim(gAzienda)+"'",0,15) */
          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPRAP\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
          /* If w_tipodest='D' */
          if (CPLib.eqr(w_tipodest,"D")) {
            // * --- Insert into anarapbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("anarapbo");
            m_cPhName = m_Ctx.GetPhName("anarapbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anarapbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"000000B7")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000B7(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(_codrap,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(CPLib.Substr(riga,34,50))+" "+CPLib.LRTrim(CPLib.Substr(riga,84,50)),50),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull("0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("E","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull("242","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("99","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_codmage,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
              /* gMsgProc := gMsgProc +"Rilevati errori nel file "+LRTrim(w_nomefile)+" per il rapporto: "+Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
              gMsgProc = gMsgProc+"Rilevati errori nel file "+CPLib.LRTrim(w_nomefile)+" per il rapporto: "+CPLib.Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              m_cLastMsgError = "";
              /* _esito := 1 */
              _esito = CPLib.Round(1,0);
            } else if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
          } else { // Else
            // * --- Insert into xnarapbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xnarapbo");
            m_cPhName = m_Ctx.GetPhName("xnarapbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xnarapbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"000000BB")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000BB(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(_codrap,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(CPLib.Substr(riga,34,50))+" "+CPLib.LRTrim(CPLib.Substr(riga,84,50)),50),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull("0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("E","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull("242","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("99","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_codmage,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
              /* gMsgProc := gMsgProc +"Rilevati errori nel file "+LRTrim(w_nomefile)+" per il rapporto: "+Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
              gMsgProc = gMsgProc+"Rilevati errori nel file "+CPLib.LRTrim(w_nomefile)+" per il rapporto: "+CPLib.Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              m_cLastMsgError = "";
              /* _esito := 1 */
              _esito = CPLib.Round(1,0);
            } else if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
          } // End If
          /* If _esito = 0 */
          if (CPLib.eqr(_esito,0)) {
            /* _xrapporto := '' */
            _xrapporto = "";
            // * --- Read from knarapbo
            m_cServer = m_Ctx.GetServer("knarapbo");
            m_cPhName = m_Ctx.GetPhName("knarapbo");
            m_cSql = "";
            m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,17,16),"C",25,0,m_cServer),m_cServer,CPLib.Substr(riga,17,16));
            if (m_Ctx.IsSharedTemp("knarapbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _xrapporto = Read_Cursor.GetString("RAPPORTO");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on knarapbo into routine arrt_import_unicredit returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _xrapporto = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(LRTrim(_xrapporto)) */
            if (CPLib.Empty(CPLib.LRTrim(_xrapporto))) {
              // * --- Insert into knarapbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("knarapbo");
              m_cPhName = m_Ctx.GetPhName("knarapbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"knarapbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"000000C3")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000C3(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codrap,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(CPLib.Substr(riga,34,50))+" "+CPLib.LRTrim(CPLib.Substr(riga,84,50)),50),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(w_tipodest,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
                /* gMsgProc := gMsgProc +"Rilevati errori nel file "+LRTrim(w_nomefile)+" per il rapporto: "+Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                gMsgProc = gMsgProc+"Rilevati errori nel file "+CPLib.LRTrim(w_nomefile)+" per il rapporto: "+CPLib.Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                m_cLastMsgError = "";
                /* _esito := 1 */
                _esito = CPLib.Round(1,0);
              } else if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
            } else { // Else
              // * --- Write into knarapbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("knarapbo");
              m_cPhName = m_Ctx.GetPhName("knarapbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"knarapbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"000000C7")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"DESCRAP = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(CPLib.Substr(riga,34,50))+" "+CPLib.LRTrim(CPLib.Substr(riga,84,50)),50),"C",50,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPORAP = "+CPLib.ToSQL(w_tipodest,"C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"knarapbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_codrap,"?",0,0,m_cServer),m_cServer,_codrap)+"";
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
          /* _oldmac := '' */
          _oldmac = "";
          /* cSRES := '' */
          cSRES = "";
          /* cSRES2 := '' */
          cSRES2 = "";
          /* xCF := '' */
          xCF = "";
          /* xConnes := Substr(riga,17,16) */
          xConnes = CPLib.Substr(riga,17,16);
          /* _oldrag := '' */
          _oldrag = "";
          // * --- Read from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          m_cSql = "";
          m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,17,16),"C",16,0,m_cServer),m_cServer,CPLib.Substr(riga,17,16));
          if (m_Ctx.IsSharedTemp("personbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("MACROAGENTE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RAGSOC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            xCF = Read_Cursor.GetString("CODFISC");
            _oldmac = Read_Cursor.GetString("MACROAGENTE");
            _oldrag = Read_Cursor.GetString("RAGSOC");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on personbo into routine arrt_import_unicredit returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            xCF = "";
            _oldmac = "";
            _oldrag = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(_oldrag)) */
          if (CPLib.Empty(CPLib.LRTrim(_oldrag))) {
            /* _oldrag := '' */
            _oldrag = "";
            /* xConnes := '' */
            xConnes = "";
            // * --- Read from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_cSql = "";
            m_cSql = m_cSql+"CODFISC="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,495,16),"C",16,0,m_cServer),m_cServer,CPLib.Substr(riga,495,16));
            if (m_Ctx.IsSharedTemp("personbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("MACROAGENTE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RAGSOC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              xCF = Read_Cursor.GetString("CODFISC");
              _oldmac = Read_Cursor.GetString("MACROAGENTE");
              xConnes = Read_Cursor.GetString("CONNES");
              _oldrag = Read_Cursor.GetString("RAGSOC");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on personbo into routine arrt_import_unicredit returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              xCF = "";
              _oldmac = "";
              xConnes = "";
              _oldrag = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
          } // End If
          /* xSesso := iif(Substr(riga,134,1)='M','1',iif(Substr(riga,134,1)='F','2',Substr(riga,134,1))) */
          xSesso = (CPLib.eqr(CPLib.Substr(riga,134,1),"M")?"1":(CPLib.eqr(CPLib.Substr(riga,134,1),"F")?"2":CPLib.Substr(riga,134,1)));
          /* xCitta := Substr(riga,143,30) */
          xCitta = CPLib.Substr(riga,143,30);
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
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("PROV",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            cPNAS = Read_Cursor.GetString("PROV");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_unicredit returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            cPNAS = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* cSNAS := '' */
          cSNAS = "";
          /* cCNAS := Substr(riga,143,30) */
          cCNAS = CPLib.Substr(riga,143,30);
          /* If (Substr(riga,506,1) = 'Z' or LRTrim(Substr(riga,193,30)) <> 'ITALIA') and Len(LRTrim(xSesso))=1 */
          if ((CPLib.eqr(CPLib.Substr(riga,506,1),"Z") || CPLib.ne(CPLib.LRTrim(CPLib.Substr(riga,193,30)),"ITALIA")) && CPLib.eqr(CPLib.Len(CPLib.LRTrim(xSesso)),1)) {
            /* cPNAS := 'EE' */
            cPNAS = "EE";
            /* cSNAS := Substr(riga,193,30) */
            cSNAS = CPLib.Substr(riga,193,30);
            /* cCNAS := '' */
            cCNAS = "";
          } // End If
          /* xProvRes := '' */
          xProvRes = "";
          // * --- Read from tbcitta
          m_cServer = m_Ctx.GetServer("tbcitta");
          m_cPhName = m_Ctx.GetPhName("tbcitta");
          m_cSql = "";
          m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,343,30),"C",60,0,m_cServer),m_cServer,CPLib.Substr(riga,343,30));
          if (m_Ctx.IsSharedTemp("tbcitta")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROV",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            xCodCab = Read_Cursor.GetString("CAB");
            xProvRes = Read_Cursor.GetString("PROV");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_unicredit returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            xCodCab = "";
            xProvRes = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* cSRES := Substr(riga,393,40) */
          cSRES = CPLib.Substr(riga,393,40);
          /* cSRES2 := '' */
          cSRES2 = "";
          // * --- Read from tbstati
          m_cServer = m_Ctx.GetServer("tbstati");
          m_cPhName = m_Ctx.GetPhName("tbstati");
          m_cSql = "";
          m_cSql = m_cSql+"DESCRI="+CPSql.SQLValueAdapter(CPLib.ToSQL(cSRES,"C",40,0,m_cServer),m_cServer,cSRES);
          if (m_Ctx.IsSharedTemp("tbstati")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODSTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            cSRES2 = Read_Cursor.GetString("CODSTA");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_unicredit returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            cSRES2 = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* _tipper := iif(Len(LRTrim(xSesso))=1,'P','G') */
          _tipper = (CPLib.eqr(CPLib.Len(CPLib.LRTrim(xSesso)),1)?"P":"G");
          /* If Empty(LRTrim(_oldrag)) */
          if (CPLib.Empty(CPLib.LRTrim(_oldrag))) {
            /* xCF := Substr(riga,543,16) */
            xCF = CPLib.Substr(riga,543,16);
            /* xConnes := Substr(riga,17,16) */
            xConnes = CPLib.Substr(riga,17,16);
            /* nProgImp := Utilities.GetAutonumber("PRGIMPOCLI\'"+LRTrim(gAzienda)+"'",0,15) */
            nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOCLI\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
            // * --- Insert into personbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"000000E7")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000E7(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,17,16),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(xCodCab,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,34,50))+" "+CPLib.LRTrim(CPLib.Substr(riga,84,50)),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,243,35),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(xCF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,135,8)),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cCNAS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("600","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("600","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,559,2),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,561,15),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,576,8)),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,584,8)),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,592,30),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,343,30),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(xProvRes,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,443,9),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(xSesso,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cSRES2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_tipper,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,34,26)),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,84,25)),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cPNAS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cSNAS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
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
              /* gMsgProc := gMsgProc +"Rilevati errori nel file "+LRTrim(w_nomefile)+" per il soggetto: "+LRTrim(Substr(riga,34,100))+" con codice fiscale: "+LRTrim(Substr(riga,543,16))+NL */
              gMsgProc = gMsgProc+"Rilevati errori nel file "+CPLib.LRTrim(w_nomefile)+" per il soggetto: "+CPLib.LRTrim(CPLib.Substr(riga,34,100))+" con codice fiscale: "+CPLib.LRTrim(CPLib.Substr(riga,543,16))+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              /* gMsgProc := gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
              gMsgProc = gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              /* _esito := 1 */
              _esito = CPLib.Round(1,0);
              m_cLastMsgError = "";
            } else if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
            /* If _esito=0 */
            if (CPLib.eqr(_esito,0)) {
              // * --- Insert into personbo_agg from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("personbo_agg");
              m_cPhName = m_Ctx.GetPhName("personbo_agg");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"000000ED")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000ED(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,17,16),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,668,25),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.ne(CPLib.At(CPLib.Upper(CPLib.Substr(riga,667,1)),"|S|Y"),0)?"S":"N"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,642,25)),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo_agg",true);
              m_cSql = m_cSql+")";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_nUpdatedRows = 0;
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.lt(m_nUpdatedRows,1)) {
                // No rows inserted
                /* gMsgProc := gMsgProc +"Rilevati errori nel file "+LRTrim(w_nomefile)+" per il soggetto: "+LRTrim(Substr(riga,34,100))+" con codice fiscale: "+LRTrim(Substr(riga,543,16))+NL */
                gMsgProc = gMsgProc+"Rilevati errori nel file "+CPLib.LRTrim(w_nomefile)+" per il soggetto: "+CPLib.LRTrim(CPLib.Substr(riga,34,100))+" con codice fiscale: "+CPLib.LRTrim(CPLib.Substr(riga,543,16))+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* gMsgProc := gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                gMsgProc = gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* _esito := 1 */
                _esito = CPLib.Round(1,0);
                m_cLastMsgError = "";
              } else if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
            } // End If
          } else { // Else
            /* _aggcli := 0 */
            _aggcli = CPLib.Round(0,0);
            /* Case LRTrim(w_codmage)='COSTA' */
            if (CPLib.eqr(CPLib.LRTrim(w_codmage),"COSTA")) {
              /* _aggcli := 1 */
              _aggcli = CPLib.Round(1,0);
              /* Case w_codmage='FININ' */
            } else if (CPLib.eqr(w_codmage,"FININ")) {
              /* If _oldmac <> 'COSTA' */
              if (CPLib.ne(_oldmac,"COSTA")) {
                /* _aggcli := 1 */
                _aggcli = CPLib.Round(1,0);
              } // End If
              /* Case w_codmage='BCAUC' */
            } else if (CPLib.eqr(w_codmage,"BCAUC")) {
              /* If _oldmac <> 'COSTA' and _oldmac <> 'FININ' */
              if (CPLib.ne(_oldmac,"COSTA") && CPLib.ne(_oldmac,"FININ")) {
                /* _aggcli := 1 */
                _aggcli = CPLib.Round(1,0);
              } // End If
              /* Case w_codmage='BCISP' */
            } else if (CPLib.eqr(w_codmage,"BCISP")) {
              /* If _oldmac <> 'COSTA' and _oldmac <> 'FININ' and _oldmac <> 'BCAUC' */
              if (CPLib.ne(_oldmac,"COSTA") && CPLib.ne(_oldmac,"FININ") && CPLib.ne(_oldmac,"BCAUC")) {
                /* _aggcli := 1 */
                _aggcli = CPLib.Round(1,0);
              } // End If
              /* Case w_codmage='BCASS' or LRTrim(w_codmage)='E998' or LRTrim(w_codmage)='EBDSS' or LRTrim(w_codmage)='I999' */
            } else if (CPLib.eqr(w_codmage,"BCASS") || CPLib.eqr(CPLib.LRTrim(w_codmage),"E998") || CPLib.eqr(CPLib.LRTrim(w_codmage),"EBDSS") || CPLib.eqr(CPLib.LRTrim(w_codmage),"I999")) {
              /* If _oldmac <> 'COSTA' and _oldmac <> 'FININ' and _oldmac <> 'BCAUC' and _oldmac <> 'BCISP' */
              if (CPLib.ne(_oldmac,"COSTA") && CPLib.ne(_oldmac,"FININ") && CPLib.ne(_oldmac,"BCAUC") && CPLib.ne(_oldmac,"BCISP")) {
                /* _aggcli := 1 */
                _aggcli = CPLib.Round(1,0);
              } // End If
              /* Case w_codmage='DHLSP' */
            } else if (CPLib.eqr(w_codmage,"DHLSP")) {
              /* If _oldmac = 'TRAVX' or _oldmac='DHLSP' */
              if (CPLib.eqr(_oldmac,"TRAVX") || CPLib.eqr(_oldmac,"DHLSP")) {
                /* _aggcli := 1 */
                _aggcli = CPLib.Round(1,0);
              } // End If
              /* Case w_codmage='TRAVX' */
            } else if (CPLib.eqr(w_codmage,"TRAVX")) {
              /* If _oldmac='TRAVX' */
              if (CPLib.eqr(_oldmac,"TRAVX")) {
                /* _aggcli := 1 */
                _aggcli = CPLib.Round(1,0);
              } // End If
            } // End Case
            /* If _aggcli = 1 */
            if (CPLib.eqr(_aggcli,1)) {
              /* cProgSto := Utilities.GetAutonumber("PSTOPERS\'"+LRTrim(gAzienda)+"'","",15) */
              cProgSto = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PSTOPERS\\'"+CPLib.LRTrim(gAzienda)+"'","",15);
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(xConnes,"?",0,0,m_cServer, m_oParameters),m_cServer,xConnes)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                // * --- Insert into wersonbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("wersonbo");
                m_cPhName = m_Ctx.GetPhName("wersonbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"00000104")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000104(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(cProgSto,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(xConnes,"?",0,0,m_cServer)+", ";
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
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
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
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PEP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("OLDCODFISC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("MACROAGENTE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SPOTID"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATASEGN"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("OLDSETSIN"),"?",0,0,m_cServer)+", ";
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
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"00000105")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(xCodCab,"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(CPLib.Substr(riga,34,50))+" "+CPLib.LRTrim(CPLib.Substr(riga,84,50)),70),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(CPLib.Substr(riga,243,35),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(CPLib.Substr(riga,543,16),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,135,8)),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(cCNAS,"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL("600","C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL("","C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL("600","C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(CPLib.Substr(riga,559,2),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(CPLib.Substr(riga,561,15),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,576,8)),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(CPLib.Substr(riga,592,30),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.Substr(riga,343,30),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(xProvRes,"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(CPLib.Substr(riga,443,9),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(xSesso,"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(cSRES2,"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATAVALI = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,584,8)),"D",8,0)+", ";
              m_cSql = m_cSql+"TIPOPERS = "+CPLib.ToSQL(_tipper,"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,34,26)),"C",26,0,m_cServer)+", ";
              m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,84,25)),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(cPNAS,"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(cSNAS,"C",30,0,m_cServer)+", ";
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
                /* gMsgProc := gMsgProc +"Rilevati errori nel file "+LRTrim(w_nomefile)+" per il soggetto: "+LRTrim(Substr(riga,34,100))+" con codice fiscale: "+LRTrim(Substr(riga,543,16))+NL */
                gMsgProc = gMsgProc+"Rilevati errori nel file "+CPLib.LRTrim(w_nomefile)+" per il soggetto: "+CPLib.LRTrim(CPLib.Substr(riga,34,100))+" con codice fiscale: "+CPLib.LRTrim(CPLib.Substr(riga,543,16))+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* gMsgProc := gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                gMsgProc = gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* _esito := 1 */
                _esito = CPLib.Round(1,0);
                m_cLastMsgError = "";
              } else if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
              /* _connes := '' */
              _connes = "";
              // * --- Read from personbo_agg
              m_cServer = m_Ctx.GetServer("personbo_agg");
              m_cPhName = m_Ctx.GetPhName("personbo_agg");
              m_cSql = "";
              m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(xConnes,"C",16,0,m_cServer),m_cServer,xConnes);
              if (m_Ctx.IsSharedTemp("personbo_agg")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _connes = Read_Cursor.GetString("CONNES");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on personbo_agg into routine arrt_import_unicredit returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _connes = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(LRTrim(_connes)) */
              if (CPLib.Empty(CPLib.LRTrim(_connes))) {
                // * --- Insert into personbo_agg from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("personbo_agg");
                m_cPhName = m_Ctx.GetPhName("personbo_agg");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"0000010D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000010D(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(xConnes,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,668,25),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.ne(CPLib.At(CPLib.Upper(CPLib.Substr(riga,667,1)),"|S|Y"),0)?"S":"N"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,642,25)),"?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo_agg",true);
                m_cSql = m_cSql+")";
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_nUpdatedRows = 0;
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.lt(m_nUpdatedRows,1)) {
                  // No rows inserted
                  /* gMsgProc := gMsgProc +"Rilevati errori nel file "+LRTrim(w_nomefile)+" per il soggetto: "+LRTrim(Substr(riga,34,100))+" con codice fiscale: "+LRTrim(Substr(riga,543,16))+NL */
                  gMsgProc = gMsgProc+"Rilevati errori nel file "+CPLib.LRTrim(w_nomefile)+" per il soggetto: "+CPLib.LRTrim(CPLib.Substr(riga,34,100))+" con codice fiscale: "+CPLib.LRTrim(CPLib.Substr(riga,543,16))+"\n";
                  m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                  /* gMsgProc := gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                  gMsgProc = gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                  m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                  /* _esito := 1 */
                  _esito = CPLib.Round(1,0);
                  m_cLastMsgError = "";
                } else if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                }
              } else { // Else
                // * --- Write into personbo_agg from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("personbo_agg");
                m_cPhName = m_Ctx.GetPhName("personbo_agg");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"00000112")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"TELEFONO = "+CPLib.ToSQL(CPLib.Substr(riga,668,25),"C",50,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLGEMAIL = "+CPLib.ToSQL((CPLib.ne(CPLib.At(CPLib.Upper(CPLib.Substr(riga,667,1)),"|S|Y"),0)?"S":"N"),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"EMAIL = "+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,642,25)),"M",10,0,m_cServer,m_oParameters)+", ";
                m_cSql = m_cSql+"FLGBANCA = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo_agg",false,true);
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
                  /* gMsgProc := gMsgProc +"Rilevati errori nel file "+LRTrim(w_nomefile)+" per il soggetto: "+LRTrim(Substr(riga,34,100))+" con codice fiscale: "+LRTrim(Substr(riga,543,16))+NL */
                  gMsgProc = gMsgProc+"Rilevati errori nel file "+CPLib.LRTrim(w_nomefile)+" per il soggetto: "+CPLib.LRTrim(CPLib.Substr(riga,34,100))+" con codice fiscale: "+CPLib.LRTrim(CPLib.Substr(riga,543,16))+"\n";
                  m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                  /* gMsgProc := gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                  gMsgProc = gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                  m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                  /* _esito := 1 */
                  _esito = CPLib.Round(1,0);
                  m_cLastMsgError = "";
                } else if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                }
              } // End If
            } // End If
          } // End If
          /* If Substr(riga,1,8) <> '00010101' */
          if (CPLib.ne(CPLib.Substr(riga,1,8),"00010101")) {
            /* _intercod := _codinter */
            _intercod = _codinter;
            /* _intercit := _citinter */
            _intercit = _citinter;
            /* _intercab := _cabinter */
            _intercab = _cabinter;
            /* _interprv := _prvinter */
            _interprv = _prvinter;
            /* cCli1 := xConnes */
            cCli1 = xConnes;
            /* xSOCTCF := '' */
            xSOCTCF = "";
            /* xSOCTCon := '' */
            xSOCTCon = "";
            /* conta := conta + 1 */
            conta = CPLib.Round(conta+1,0);
            /* cFlagLire := '3' */
            cFlagLire = "3";
            /* gMsgImp := 'Sono stati elaborate '+LRTrim(Str(conta,10,0))+' informazioni del file '+LRTrim(w_nomefile) // Messaggio Import */
            gMsgImp = "Sono stati elaborate "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" informazioni del file "+CPLib.LRTrim(w_nomefile);
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* Verifico la presenza dell'_unicode per evitare duplicazioni di informazioni diverse con lo stesso _unicode */
            /* _unicode := '' */
            _unicode = "";
            /* If w_tipodest='D' */
            if (CPLib.eqr(w_tipodest,"D")) {
              /* cInfProg1 := Utilities.GetAutonumber("PRGINFO1\'"+LRTrim(gAzienda)+"'",'',10) */
              cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
              /* cInfProg2 := Utilities.GetAutonumber("PRGINFO2\'"+LRTrim(gAzienda)+"'",'',11) */
              cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
              /* nProgImp := Utilities.GetAutonumber("PRGIMPINF\'"+LRTrim(gAzienda)+"'",0,15) */
              nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINF\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
              // * --- Insert into rapopebo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("rapopebo");
              m_cPhName = m_Ctx.GetPhName("rapopebo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"0000012A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000012A(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,1,8),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(xSOCTCF,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,1,8)),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cFlagLire,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,8)+cInfProg2+"0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(_codrap,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_intertip,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull("23","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(w_xMADIPSTD,"?",0,0,m_cServer)+", ";
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
                /* gMsgProc := gMsgProc +"Rilevati errori nel file "+LRTrim(w_nomefile)+" per l'informazione in data "+CharToDate(Left(riga,8))+" relativa al rapporto: "+Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                gMsgProc = gMsgProc+"Rilevati errori nel file "+CPLib.LRTrim(w_nomefile)+" per l'informazione in data "+CPLib.CharToDate(CPLib.Left(riga,8))+" relativa al rapporto: "+CPLib.Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                m_cLastMsgError = "";
                /* _esito := 1 */
                _esito = CPLib.Round(1,0);
              } else if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
              /* cMaxRow := 0 */
              cMaxRow = CPLib.Round(0,0);
              /* _nummod := 0 */
              _nummod = CPLib.Round(0,0);
              // * --- Select from intestbo
              m_cServer = m_Ctx.GetServer("intestbo");
              m_cPhName = m_Ctx.GetPhName("intestbo");
              if (Cursor_intestbo!=null)
                Cursor_intestbo.Close();
              Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,17,16),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Substr(riga,17,16))+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM ",m_cServer,m_Ctx,true));
              while ( ! (Cursor_intestbo.Eof())) {
                /* If intestbo->CODINTER=cCli1 */
                if (CPLib.eqr(Cursor_intestbo.GetString("CODINTER"),cCli1)) {
                  /* _nummod := intestbo->CPROWNUM */
                  _nummod = CPLib.Round(Cursor_intestbo.GetDouble("CPROWNUM"),0);
                } // End If
                /* cMaxRow := intestbo->CPROWNUM */
                cMaxRow = CPLib.Round(Cursor_intestbo.GetDouble("CPROWNUM"),0);
                Cursor_intestbo.Next();
              }
              m_cConnectivityError = Cursor_intestbo.ErrorMessage();
              Cursor_intestbo.Close();
              // * --- End Select
              /* If _nummod = 0 */
              if (CPLib.eqr(_nummod,0)) {
                /* nProgImp2 := Utilities.GetAutonumber("PRGIMPSOG\'"+LRTrim(gAzienda)+"'",0,15) */
                nProgImp2 = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPSOG\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
                // * --- Insert into intestbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("intestbo");
                m_cPhName = m_Ctx.GetPhName("intestbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"00000136")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000136(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow+1,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,1,8)),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull(cCli1,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_codrap,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,8)+cInfProg2+"0","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cCli1,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp2,"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
                  /* gMsgProc := gMsgProc +"Rilevati errori nel file "+LRTrim(w_nomefile)+" per la registrazione dell'intestatario dell'informazione in data "+CharToDate(Left(riga,8))+" relativa al rapporto: "+Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                  gMsgProc = gMsgProc+"Rilevati errori nel file "+CPLib.LRTrim(w_nomefile)+" per la registrazione dell'intestatario dell'informazione in data "+CPLib.CharToDate(CPLib.Left(riga,8))+" relativa al rapporto: "+CPLib.Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                  m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                  m_cLastMsgError = "";
                  /* _esito := 1 */
                  _esito = CPLib.Round(1,0);
                } else if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                }
              } else { // Else
                // * --- Write into intestbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("intestbo");
                m_cPhName = m_Ctx.GetPhName("intestbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"0000013A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DATAINI = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Left(riga,8)),"D",8,0)+", ";
                m_cSql = m_cSql+"NUMPROG1 = "+CPLib.ToSQL(cInfProg2,"C",11,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_codrap,"?",0,0,m_cServer),m_cServer,_codrap)+"";
                m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_nummod,"?",0,0,m_cServer),m_cServer,_nummod)+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_nUpdatedRows = 0;
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.lt(m_nUpdatedRows,1)) {
                  // No rows updated
                  /* gMsgProc := gMsgProc +"Rilevati errori nel file "+LRTrim(w_nomefile)+" per la registrazione dell'intestatario dell'informazione in data "+CharToDate(Left(riga,8))+" relativa al rapporto: "+Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                  gMsgProc = gMsgProc+"Rilevati errori nel file "+CPLib.LRTrim(w_nomefile)+" per la registrazione dell'intestatario dell'informazione in data "+CPLib.CharToDate(CPLib.Left(riga,8))+" relativa al rapporto: "+CPLib.Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                  m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                  m_cLastMsgError = "";
                  /* _esito := 1 */
                  _esito = CPLib.Round(1,0);
                } else if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                }
              } // End If
            } else { // Else
              /* cInfProg1 := Utilities.GetAutonumber("PRGPINFO1\'"+LRTrim(gAzienda)+"'",'',10) */
              cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGPINFO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
              /* cInfProg2 := Utilities.GetAutonumber("PRGPINFO2\'"+LRTrim(gAzienda)+"'",'',11) */
              cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGPINFO2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
              /* nProgImp := Utilities.GetAutonumber("PRGIMPINF\'"+LRTrim(gAzienda)+"'",0,15) */
              nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINF\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
              // * --- Insert into xapopebo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("xapopebo");
              m_cPhName = m_Ctx.GetPhName("xapopebo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xapopebo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"00000141")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000141(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,1,8),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(xSOCTCF,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,1,8)),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cFlagLire,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,8)+cInfProg2+"0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codrap,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_intertip,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull("23","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(w_xMADIPSTD,"?",0,0,m_cServer)+", ";
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
                /* gMsgProc := gMsgProc +"Rilevati errori nel file "+LRTrim(w_nomefile)+" per l'informazione in data "+CharToDate(Left(riga,8))+" relativa al rapporto: "+Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                gMsgProc = gMsgProc+"Rilevati errori nel file "+CPLib.LRTrim(w_nomefile)+" per l'informazione in data "+CPLib.CharToDate(CPLib.Left(riga,8))+" relativa al rapporto: "+CPLib.Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                m_cLastMsgError = "";
                /* _esito := 1 */
                _esito = CPLib.Round(1,0);
              } else if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
              /* cMaxRow := 0 */
              cMaxRow = CPLib.Round(0,0);
              /* _nummod := 0 */
              _nummod = CPLib.Round(0,0);
              // * --- Select from xntestbo
              m_cServer = m_Ctx.GetServer("xntestbo");
              m_cPhName = m_Ctx.GetPhName("xntestbo");
              if (Cursor_xntestbo!=null)
                Cursor_xntestbo.Close();
              Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,17,16),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Substr(riga,17,16))+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM ",m_cServer,m_Ctx,true));
              while ( ! (Cursor_xntestbo.Eof())) {
                /* If xntestbo->CODINTER=cCli1 */
                if (CPLib.eqr(Cursor_xntestbo.GetString("CODINTER"),cCli1)) {
                  /* _nummod := xntestbo->CPROWNUM */
                  _nummod = CPLib.Round(Cursor_xntestbo.GetDouble("CPROWNUM"),0);
                } // End If
                /* cMaxRow := xntestbo->CPROWNUM */
                cMaxRow = CPLib.Round(Cursor_xntestbo.GetDouble("CPROWNUM"),0);
                Cursor_xntestbo.Next();
              }
              m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
              Cursor_xntestbo.Close();
              // * --- End Select
              /* If _nummod = 0 */
              if (CPLib.eqr(_nummod,0)) {
                /* nProgImp2 := Utilities.GetAutonumber("PRGIMPSOG\'"+LRTrim(gAzienda)+"'",0,15) */
                nProgImp2 = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPSOG\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
                // * --- Insert into xntestbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("xntestbo");
                m_cPhName = m_Ctx.GetPhName("xntestbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xntestbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"0000014D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000014D(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow+1,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,1,8)),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull(cCli1,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_codrap,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,8)+cInfProg2+"0","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cCli1,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp2,"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
                  /* gMsgProc := gMsgProc +"Rilevati errori nel file "+LRTrim(w_nomefile)+" per la registrazione dell'intestatario dell'informazione in data "+CharToDate(Left(riga,8))+" relativa al rapporto: "+Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                  gMsgProc = gMsgProc+"Rilevati errori nel file "+CPLib.LRTrim(w_nomefile)+" per la registrazione dell'intestatario dell'informazione in data "+CPLib.CharToDate(CPLib.Left(riga,8))+" relativa al rapporto: "+CPLib.Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                  m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                  m_cLastMsgError = "";
                  /* _esito := 1 */
                  _esito = CPLib.Round(1,0);
                } else if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                }
              } else { // Else
                // * --- Write into intestbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("intestbo");
                m_cPhName = m_Ctx.GetPhName("intestbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"00000151")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DATAINI = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Left(riga,8)),"D",8,0)+", ";
                m_cSql = m_cSql+"NUMPROG1 = "+CPLib.ToSQL(cInfProg2,"C",11,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_codrap,"?",0,0,m_cServer),m_cServer,_codrap)+"";
                m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_nummod,"?",0,0,m_cServer),m_cServer,_nummod)+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_nUpdatedRows = 0;
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.lt(m_nUpdatedRows,1)) {
                  // No rows updated
                  /* gMsgProc := gMsgProc +"Rilevati errori nel file "+LRTrim(w_nomefile)+" per la registrazione dell'intestatario dell'informazione in data "+CharToDate(Left(riga,8))+" relativa al rapporto: "+Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                  gMsgProc = gMsgProc+"Rilevati errori nel file "+CPLib.LRTrim(w_nomefile)+" per la registrazione dell'intestatario dell'informazione in data "+CPLib.CharToDate(CPLib.Left(riga,8))+" relativa al rapporto: "+CPLib.Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                  m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                  m_cLastMsgError = "";
                  /* _esito := 1 */
                  _esito = CPLib.Round(1,0);
                } else if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                }
              } // End If
            } // End If
          } // End If
          /* cNumNew := cNumNew + 1 */
          cNumNew = CPLib.Round(cNumNew+1,0);
        } else { // Else
          /* eProg := Utilities.GetAutonumber("PRGWUCHKUNC\'"+LRTrim(gAzienda)+"'",0,10) */
          eProg = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGWUCHKUNC\\'"+CPLib.LRTrim(gAzienda)+"'",0,10),0);
          /* xCitta := Substr(riga,143,30) */
          xCitta = CPLib.Substr(riga,143,30);
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
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("PROV",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            cPNAS = Read_Cursor.GetString("PROV");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_unicredit returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            cPNAS = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* cSNAS := '' */
          cSNAS = "";
          /* cCNAS := Substr(riga,143,30) */
          cCNAS = CPLib.Substr(riga,143,30);
          /* If (Substr(riga,506,1) = 'Z' or LRTrim(Substr(riga,193,30)) <> 'ITALIA') and Len(LRTrim(xSesso))=1 */
          if ((CPLib.eqr(CPLib.Substr(riga,506,1),"Z") || CPLib.ne(CPLib.LRTrim(CPLib.Substr(riga,193,30)),"ITALIA")) && CPLib.eqr(CPLib.Len(CPLib.LRTrim(xSesso)),1)) {
            /* cSNAS := Substr(riga,193,30) */
            cSNAS = CPLib.Substr(riga,193,30);
            /* cCNAS := '' */
            cCNAS = "";
          } // End If
          /* xProvRes := '' */
          xProvRes = "";
          // * --- Read from tbcitta
          m_cServer = m_Ctx.GetServer("tbcitta");
          m_cPhName = m_Ctx.GetPhName("tbcitta");
          m_cSql = "";
          m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,343,30),"C",60,0,m_cServer),m_cServer,CPLib.Substr(riga,343,30));
          if (m_Ctx.IsSharedTemp("tbcitta")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROV",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            xCodCab = Read_Cursor.GetString("CAB");
            xProvRes = Read_Cursor.GetString("PROV");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_unicredit returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            xCodCab = "";
            xProvRes = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* cSRES := Substr(riga,393,40) */
          cSRES = CPLib.Substr(riga,393,40);
          /* cSRES2 := '' */
          cSRES2 = "";
          // * --- Read from tbstati
          m_cServer = m_Ctx.GetServer("tbstati");
          m_cPhName = m_Ctx.GetPhName("tbstati");
          m_cSql = "";
          m_cSql = m_cSql+"DESCRI="+CPSql.SQLValueAdapter(CPLib.ToSQL(cSRES,"C",40,0,m_cServer),m_cServer,cSRES);
          if (m_Ctx.IsSharedTemp("tbstati")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODSTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            cSRES2 = Read_Cursor.GetString("CODSTA");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_unicredit returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            cSRES2 = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          // * --- Insert into wuchkunicr from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("wuchkunicr");
          m_cPhName = m_Ctx.GetPhName("wuchkunicr");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wuchkunicr",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"00000163")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000163(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(eProg,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(w_nomefile),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.Substr(riga,1,8),"00010101")?CPLib.NullDate():CPLib.CharToDate(CPLib.Substr(riga,1,8))),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.Substr(riga,9,8),"00010101")?CPLib.NullDate():CPLib.CharToDate(CPLib.Substr(riga,9,8))),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,17,16),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,84,25)),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,34,26)),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,343,30),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,443,5),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,243,35),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cCNAS,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cSNAS,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(arfn_fdateR.Make(m_Ctx,this).Run((CPLib.eqr(CPLib.Substr(riga,125,8),"00010101")?CPLib.NullDate():CPLib.CharToDate(CPLib.Substr(riga,135,8)))),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,134,1),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,543,16),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,559,2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,561,15),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,592,30),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(arfn_fdateR.Make(m_Ctx,this).Run((CPLib.eqr(CPLib.Substr(riga,576,8),"00010101")?CPLib.NullDate():CPLib.CharToDate(CPLib.Substr(riga,576,8)))),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(arfn_fdateR.Make(m_Ctx,this).Run((CPLib.eqr(CPLib.Substr(riga,584,8),"00010101")?CPLib.NullDate():CPLib.CharToDate(CPLib.Substr(riga,584,8)))),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(xProvRes,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,668,25),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,667,1),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,642,25)),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Inserimento di nuovo rapporto già presente su archivio UNICO","?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cSRES,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wuchkunicr",true);
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
          /* cNumSca := cNumSca + 1 */
          cNumSca = CPLib.Round(cNumSca+1,0);
        } // End If
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
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
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
  void Page_3() throws Exception {
    CPResultSet Cursor_intestbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_knarapbo=null;
    CPResultSet Cursor_rapopebo=null;
    CPResultSet Cursor_xapopebo=null;
    CPResultSet Cursor_personbo=null;
    try {
      /* _xrapmod Char(25) */
      String _xrapmod;
      _xrapmod = CPLib.Space(25);
      /* _xtipmod Char(1) */
      String _xtipmod;
      _xtipmod = CPLib.Space(1);
      /* _datini Date */
      java.sql.Date _datini;
      _datini = CPLib.NullDate();
      /* _errmod Char(1) */
      String _errmod;
      _errmod = CPLib.Space(1);
      /* _errmsg Memo */
      String _errmsg;
      _errmsg = "";
      /* _xrapmod := '' */
      _xrapmod = "";
      /* _xtipmod := '' */
      _xtipmod = "";
      /* _errmod := 'N' */
      _errmod = "N";
      /* _errmsg := '' */
      _errmsg = "";
      /* If w_xMAFLGRAP='S' */
      if (CPLib.eqr(w_xMAFLGRAP,"S")) {
        // * --- Select from intestbo
        m_cServer = m_Ctx.GetServer("intestbo");
        m_cPhName = m_Ctx.GetPhName("intestbo");
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
        Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,17,16),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Substr(riga,17,16))+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intestbo.Eof())) {
          // * --- Read from anarapbo
          m_cServer = m_Ctx.GetServer("anarapbo");
          m_cPhName = m_Ctx.GetPhName("anarapbo");
          m_cSql = "";
          m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_intestbo.GetString("RAPPORTO"));
          if (m_Ctx.IsSharedTemp("anarapbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("MACODICE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _magecod = Read_Cursor.GetString("MACODICE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on anarapbo into routine arrt_import_unicredit returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _magecod = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If _magecod=w_codmage */
          if (CPLib.eqr(_magecod,w_codmage)) {
            /* _xrapporto := intestbo->RAPPORTO */
            _xrapporto = Cursor_intestbo.GetString("RAPPORTO");
          } // End If
          Cursor_intestbo.Next();
        }
        m_cConnectivityError = Cursor_intestbo.ErrorMessage();
        Cursor_intestbo.Close();
        // * --- End Select
      } else { // Else
        /* _xrapporto := Substr(riga,17,16) */
        _xrapporto = CPLib.Substr(riga,17,16);
      } // End If
      // * --- Select from knarapbo
      m_cServer = m_Ctx.GetServer("knarapbo");
      m_cPhName = m_Ctx.GetPhName("knarapbo");
      if (Cursor_knarapbo!=null)
        Cursor_knarapbo.Close();
      Cursor_knarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_xrapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,_xrapporto)+" "+")"+(m_Ctx.IsSharedTemp("knarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_knarapbo.Eof())) {
        /* _xrapmod := knarapbo->RAPPORTO */
        _xrapmod = Cursor_knarapbo.GetString("RAPPORTO");
        /* _xtipmod := knarapbo->TIPORAP */
        _xtipmod = Cursor_knarapbo.GetString("TIPORAP");
        Cursor_knarapbo.Next();
      }
      m_cConnectivityError = Cursor_knarapbo.ErrorMessage();
      Cursor_knarapbo.Close();
      // * --- End Select
      /* If not(Empty(LRTrim(_xrapmod))) */
      if ( ! (CPLib.Empty(CPLib.LRTrim(_xrapmod)))) {
        /* _datini := NullDate() */
        _datini = CPLib.NullDate();
        /* If _xtipmod ='D' */
        if (CPLib.eqr(_xtipmod,"D")) {
          // * --- Select from rapopebo
          m_cServer = m_Ctx.GetServer("rapopebo");
          m_cPhName = m_Ctx.GetPhName("rapopebo");
          if (Cursor_rapopebo!=null)
            Cursor_rapopebo.Close();
          Cursor_rapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,17,16),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Substr(riga,17,16))+"  and  TIPOOPRAP='23' "+")"+(m_Ctx.IsSharedTemp("rapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_rapopebo.Eof())) {
            /* _datini := rapopebo->DATAOPE */
            _datini = Cursor_rapopebo.GetDate("DATAOPE");
            Cursor_rapopebo.Next();
          }
          m_cConnectivityError = Cursor_rapopebo.ErrorMessage();
          Cursor_rapopebo.Close();
          // * --- End Select
        } else { // Else
          // * --- Select from xapopebo
          m_cServer = m_Ctx.GetServer("xapopebo");
          m_cPhName = m_Ctx.GetPhName("xapopebo");
          if (Cursor_xapopebo!=null)
            Cursor_xapopebo.Close();
          Cursor_xapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,17,16),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Substr(riga,17,16))+"  and  TIPOOPRAP='23' "+")"+(m_Ctx.IsSharedTemp("xapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_xapopebo.Eof())) {
            /* _datini := xapopebo->DATAOPE */
            _datini = Cursor_xapopebo.GetDate("DATAOPE");
            Cursor_xapopebo.Next();
          }
          m_cConnectivityError = Cursor_xapopebo.ErrorMessage();
          Cursor_xapopebo.Close();
          // * --- End Select
        } // End If
        /* Aggiornamento Rapporto */
        /* If DateToChar(_datini) = Substr(riga,1,8) */
        if (CPLib.eqr(CPLib.DateToChar(_datini),CPLib.Substr(riga,1,8))) {
          // * --- Write into anarapbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("anarapbo");
          m_cPhName = m_Ctx.GetPhName("anarapbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anarapbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"00000183")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"DESCRAP = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(CPLib.Substr(riga,34,50))+" "+CPLib.LRTrim(CPLib.Substr(riga,84,50)),50),"C",50,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"anarapbo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,17,16),"?",0,0,m_cServer),m_cServer,CPLib.Substr(riga,17,16))+"";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter();
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows updated
            /* gMsgProc := gMsgProc +"Rilevati errori nel file "+w_nomefile+" per il rapporto: "+Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Rilevati errori nel file "+w_nomefile+" per il rapporto: "+CPLib.Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            m_cLastMsgError = "";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          /* _oldmac := '' */
          _oldmac = "";
          /* _oldrag := '' */
          _oldrag = "";
          /* _oldcon := '' */
          _oldcon = "";
          // * --- Read from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          m_cSql = "";
          m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,17,16),"C",16,0,m_cServer),m_cServer,CPLib.Substr(riga,17,16));
          if (m_Ctx.IsSharedTemp("personbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("MACROAGENTE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RAGSOC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _oldmac = Read_Cursor.GetString("MACROAGENTE");
            _oldrag = Read_Cursor.GetString("RAGSOC");
            _oldcon = Read_Cursor.GetString("CONNES");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on personbo into routine arrt_import_unicredit returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _oldmac = "";
            _oldrag = "";
            _oldcon = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(_oldrag)) */
          if (CPLib.Empty(CPLib.LRTrim(_oldrag))) {
            /* _oldmac := '' */
            _oldmac = "";
            /* _oldrag := '' */
            _oldrag = "";
            // * --- Read from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_cSql = "";
            m_cSql = m_cSql+"CODFISC="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,543,16),"C",16,0,m_cServer),m_cServer,CPLib.Substr(riga,543,16));
            if (m_Ctx.IsSharedTemp("personbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("MACROAGENTE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RAGSOC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _oldmac = Read_Cursor.GetString("MACROAGENTE");
              _oldrag = Read_Cursor.GetString("RAGSOC");
              _oldcon = Read_Cursor.GetString("CONNES");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on personbo into routine arrt_import_unicredit returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _oldmac = "";
              _oldrag = "";
              _oldcon = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
          } // End If
          /* _aggcli := 0 */
          _aggcli = CPLib.Round(0,0);
          /* Case LRTrim(w_codmage)='COSTA' */
          if (CPLib.eqr(CPLib.LRTrim(w_codmage),"COSTA")) {
            /* _aggcli := 1 */
            _aggcli = CPLib.Round(1,0);
            /* Case w_codmage='FININ' */
          } else if (CPLib.eqr(w_codmage,"FININ")) {
            /* If _oldmac <> 'COSTA' */
            if (CPLib.ne(_oldmac,"COSTA")) {
              /* _aggcli := 1 */
              _aggcli = CPLib.Round(1,0);
            } // End If
            /* Case w_codmage='BCAUC' */
          } else if (CPLib.eqr(w_codmage,"BCAUC")) {
            /* If _oldmac <> 'COSTA' and _oldmac <> 'FININ' */
            if (CPLib.ne(_oldmac,"COSTA") && CPLib.ne(_oldmac,"FININ")) {
              /* _aggcli := 1 */
              _aggcli = CPLib.Round(1,0);
            } // End If
            /* Case w_codmage='BCISP' */
          } else if (CPLib.eqr(w_codmage,"BCISP")) {
            /* If _oldmac <> 'COSTA' and _oldmac <> 'FININ' and _oldmac <> 'BCAUC' */
            if (CPLib.ne(_oldmac,"COSTA") && CPLib.ne(_oldmac,"FININ") && CPLib.ne(_oldmac,"BCAUC")) {
              /* _aggcli := 1 */
              _aggcli = CPLib.Round(1,0);
            } // End If
            /* Case w_codmage='BCASS' or LRTrim(w_codmage)='E998' or LRTrim(w_codmage)='EBDSS' or LRTrim(w_codmage)='I999' */
          } else if (CPLib.eqr(w_codmage,"BCASS") || CPLib.eqr(CPLib.LRTrim(w_codmage),"E998") || CPLib.eqr(CPLib.LRTrim(w_codmage),"EBDSS") || CPLib.eqr(CPLib.LRTrim(w_codmage),"I999")) {
            /* If _oldmac <> 'COSTA' and _oldmac <> 'FININ' and _oldmac <> 'BCAUC' and _oldmac <> 'BCISP' */
            if (CPLib.ne(_oldmac,"COSTA") && CPLib.ne(_oldmac,"FININ") && CPLib.ne(_oldmac,"BCAUC") && CPLib.ne(_oldmac,"BCISP")) {
              /* _aggcli := 1 */
              _aggcli = CPLib.Round(1,0);
            } // End If
            /* Case w_codmage='DHLSP' */
          } else if (CPLib.eqr(w_codmage,"DHLSP")) {
            /* If _oldmac = 'TRAVX' or _oldmac='DHLSP' */
            if (CPLib.eqr(_oldmac,"TRAVX") || CPLib.eqr(_oldmac,"DHLSP")) {
              /* _aggcli := 1 */
              _aggcli = CPLib.Round(1,0);
            } // End If
            /* Case w_codmage='TRAVX' */
          } else if (CPLib.eqr(w_codmage,"TRAVX")) {
            /* If _oldmac='TRAVX' */
            if (CPLib.eqr(_oldmac,"TRAVX")) {
              /* _aggcli := 1 */
              _aggcli = CPLib.Round(1,0);
            } // End If
          } // End Case
          /* If _aggcli = 1 */
          if (CPLib.eqr(_aggcli,1)) {
            /* cProgSto := Utilities.GetAutonumber("PSTOPERS\'"+LRTrim(gAzienda)+"'","",15) */
            cProgSto = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PSTOPERS\\'"+CPLib.LRTrim(gAzienda)+"'","",15);
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldcon,"?",0,0,m_cServer, m_oParameters),m_cServer,_oldcon)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Insert into wersonbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("wersonbo");
              m_cPhName = m_Ctx.GetPhName("wersonbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"000001A2")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000001A2(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(cProgSto,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,17,16),"?",0,0,m_cServer)+", ";
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
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
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
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PEP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("OLDCODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("MACROAGENTE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SPOTID"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATASEGN"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("OLDSETSIN"),"?",0,0,m_cServer)+", ";
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
            /* cSRES := '' */
            cSRES = "";
            /* cSRES2 := '' */
            cSRES2 = "";
            /* xCF := '' */
            xCF = "";
            // * --- Read from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_cSql = "";
            m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldcon,"C",16,0,m_cServer),m_cServer,_oldcon);
            if (m_Ctx.IsSharedTemp("personbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              xCF = Read_Cursor.GetString("CODFISC");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on personbo into routine arrt_import_unicredit returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              xCF = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* xSesso := iif(Substr(riga,134,1)='M','1',iif(Substr(riga,134,1)='F','2',Substr(riga,134,1))) */
            xSesso = (CPLib.eqr(CPLib.Substr(riga,134,1),"M")?"1":(CPLib.eqr(CPLib.Substr(riga,134,1),"F")?"2":CPLib.Substr(riga,134,1)));
            /* xCitta := Substr(riga,143,30) */
            xCitta = CPLib.Substr(riga,143,30);
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
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("PROV",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              cPNAS = Read_Cursor.GetString("PROV");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_unicredit returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              cPNAS = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* cSNAS := '' */
            cSNAS = "";
            /* cCNAS := Substr(riga,143,30) */
            cCNAS = CPLib.Substr(riga,143,30);
            /* If (Substr(riga,554,1) = 'Z' or LRTrim(Substr(riga,193,30)) <> 'ITALIA') and Len(LRTrim(xSesso))=1 */
            if ((CPLib.eqr(CPLib.Substr(riga,554,1),"Z") || CPLib.ne(CPLib.LRTrim(CPLib.Substr(riga,193,30)),"ITALIA")) && CPLib.eqr(CPLib.Len(CPLib.LRTrim(xSesso)),1)) {
              /* cPNAS := 'EE' */
              cPNAS = "EE";
              /* cSNAS := Substr(riga,193,30) */
              cSNAS = CPLib.Substr(riga,193,30);
              /* cCNAS := '' */
              cCNAS = "";
            } // End If
            /* cSRES := Substr(riga,393,40) */
            cSRES = CPLib.Substr(riga,393,40);
            /* cSRES2 := '' */
            cSRES2 = "";
            /* xProvRes := '' */
            xProvRes = "";
            // * --- Read from tbcitta
            m_cServer = m_Ctx.GetServer("tbcitta");
            m_cPhName = m_Ctx.GetPhName("tbcitta");
            m_cSql = "";
            m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,343,30),"C",60,0,m_cServer),m_cServer,CPLib.Substr(riga,343,30));
            if (m_Ctx.IsSharedTemp("tbcitta")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROV",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              xCodCab = Read_Cursor.GetString("CAB");
              xProvRes = Read_Cursor.GetString("PROV");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_unicredit returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              xCodCab = "";
              xProvRes = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            // * --- Read from tbstati
            m_cServer = m_Ctx.GetServer("tbstati");
            m_cPhName = m_Ctx.GetPhName("tbstati");
            m_cSql = "";
            m_cSql = m_cSql+"DESCRI="+CPSql.SQLValueAdapter(CPLib.ToSQL(cSRES,"C",40,0,m_cServer),m_cServer,cSRES);
            if (m_Ctx.IsSharedTemp("tbstati")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODSTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              cSRES2 = Read_Cursor.GetString("CODSTA");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_unicredit returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              cSRES2 = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* _tipper := iif(Len(LRTrim(xSesso))=1,'P','G') */
            _tipper = (CPLib.eqr(CPLib.Len(CPLib.LRTrim(xSesso)),1)?"P":"G");
            // * --- Write into personbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"000001B6")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(xCodCab,"C",6,0,m_cServer)+", ";
            m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(CPLib.Substr(riga,34,50))+" "+CPLib.LRTrim(CPLib.Substr(riga,84,50)),70),"C",70,0,m_cServer)+", ";
            m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(CPLib.Substr(riga,243,35),"C",35,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(xCF,"C",16,0,m_cServer)+", ";
            m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,135,8)),"D",8,0)+", ";
            m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(cCNAS,"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL("600","C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL("","C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL("600","C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(CPLib.Substr(riga,559,2),"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(CPLib.Substr(riga,561,15),"C",15,0,m_cServer)+", ";
            m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,576,8)),"D",8,0)+", ";
            m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(CPLib.Substr(riga,592,30),"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.Substr(riga,343,30),"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(xProvRes,"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(CPLib.Substr(riga,443,9),"C",9,0,m_cServer)+", ";
            m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(xSesso,"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(cSRES2,"C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"DATAVALI = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,584,8)),"D",8,0)+", ";
            m_cSql = m_cSql+"TIPOPERS = "+CPLib.ToSQL(_tipper,"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,34,26)),"C",26,0,m_cServer)+", ";
            m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,84,25)),"C",25,0,m_cServer)+", ";
            m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(cPNAS,"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(cSNAS,"C",30,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldcon,"?",0,0,m_cServer),m_cServer,_oldcon)+"";
            m_cSql = m_cSql+m_oWrInfo.WhereFilter();
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_nUpdatedRows = 0;
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.lt(m_nUpdatedRows,1)) {
              // No rows updated
              /* gMsgProc := gMsgProc +"Rilevati errori nel file "+LRTrim(w_nomefile)+" per il soggetto: "+LRTrim(Substr(riga,34,100))+" con codice fiscale: "+LRTrim(Substr(riga,543,16))+NL */
              gMsgProc = gMsgProc+"Rilevati errori nel file "+CPLib.LRTrim(w_nomefile)+" per il soggetto: "+CPLib.LRTrim(CPLib.Substr(riga,34,100))+" con codice fiscale: "+CPLib.LRTrim(CPLib.Substr(riga,543,16))+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              /* gMsgProc := gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
              gMsgProc = gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              /* _esito := 1 */
              _esito = CPLib.Round(1,0);
              m_cLastMsgError = "";
            } else if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
            /* _connes := '' */
            _connes = "";
            // * --- Read from personbo_agg
            m_cServer = m_Ctx.GetServer("personbo_agg");
            m_cPhName = m_Ctx.GetPhName("personbo_agg");
            m_cSql = "";
            m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldcon,"C",16,0,m_cServer),m_cServer,_oldcon);
            if (m_Ctx.IsSharedTemp("personbo_agg")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _connes = Read_Cursor.GetString("CONNES");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on personbo_agg into routine arrt_import_unicredit returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _connes = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(LRTrim(_connes)) */
            if (CPLib.Empty(CPLib.LRTrim(_connes))) {
              // * --- Insert into personbo_agg from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("personbo_agg");
              m_cPhName = m_Ctx.GetPhName("personbo_agg");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"000001BE")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000001BE(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(_oldcon,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,668,25),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.ne(CPLib.At(CPLib.Upper(CPLib.Substr(riga,667,1)),"|S|Y"),0)?"S":"N"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,642,25)),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo_agg",true);
              m_cSql = m_cSql+")";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_nUpdatedRows = 0;
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.lt(m_nUpdatedRows,1)) {
                // No rows inserted
                /* gMsgProc := gMsgProc +"Rilevati errori nel file "+LRTrim(w_nomefile)+" per il soggetto: "+LRTrim(Substr(riga,34,100))+" con codice fiscale: "+LRTrim(Substr(riga,543,16))+NL */
                gMsgProc = gMsgProc+"Rilevati errori nel file "+CPLib.LRTrim(w_nomefile)+" per il soggetto: "+CPLib.LRTrim(CPLib.Substr(riga,34,100))+" con codice fiscale: "+CPLib.LRTrim(CPLib.Substr(riga,543,16))+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* gMsgProc := gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                gMsgProc = gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* _esito := 1 */
                _esito = CPLib.Round(1,0);
                m_cLastMsgError = "";
              } else if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
            } else { // Else
              // * --- Write into personbo_agg from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("personbo_agg");
              m_cPhName = m_Ctx.GetPhName("personbo_agg");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"000001C3")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"FLGBANCA = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"TELEFONO = "+CPLib.ToSQL(CPLib.Substr(riga,668,25),"C",50,0,m_cServer)+", ";
              m_cSql = m_cSql+"FLGEMAIL = "+CPLib.ToSQL((CPLib.ne(CPLib.At(CPLib.Upper(CPLib.Substr(riga,667,1)),"|S|Y"),0)?"S":"N"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"EMAIL = "+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,642,25)),"M",10,0,m_cServer,m_oParameters)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo_agg",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldcon,"?",0,0,m_cServer),m_cServer,_oldcon)+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_nUpdatedRows = 0;
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.lt(m_nUpdatedRows,1)) {
                // No rows updated
                /* gMsgProc := gMsgProc +"Rilevati errori nel file "+LRTrim(w_nomefile)+" per il soggetto: "+LRTrim(Substr(riga,34,100))+" con codice fiscale: "+LRTrim(Substr(riga,543,16))+NL */
                gMsgProc = gMsgProc+"Rilevati errori nel file "+CPLib.LRTrim(w_nomefile)+" per il soggetto: "+CPLib.LRTrim(CPLib.Substr(riga,34,100))+" con codice fiscale: "+CPLib.LRTrim(CPLib.Substr(riga,543,16))+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* gMsgProc := gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                gMsgProc = gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* _esito := 1 */
                _esito = CPLib.Round(1,0);
                m_cLastMsgError = "";
              } else if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
            } // End If
            /* cInfProg1 := Utilities.GetAutonumber("PRGINFO1\'"+LRTrim(gAzienda)+"'",'',10) */
            cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
            /* cInfProg2 := Utilities.GetAutonumber("PRGINFO2\'"+LRTrim(gAzienda)+"'",'',11) */
            cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
            /* nProgImp := Utilities.GetAutonumber("PRGIMPINF\'"+LRTrim(gAzienda)+"'",0,15) */
            nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINF\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
            // * --- Insert into rapopebo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("rapopebo");
            m_cPhName = m_Ctx.GetPhName("rapopebo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"000001CC")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000001CC(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(xSOCTCF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cFlagLire,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,9,8)+cInfProg2+"0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,17,16),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intertip,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull("0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull("31","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
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
              /* gMsgProc := gMsgProc +"Rilevati errori nel file "+LRTrim(w_nomefile)+" per l'informazione in data "+CharToDate(Left(riga,8))+" relativa al rapporto: "+Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
              gMsgProc = gMsgProc+"Rilevati errori nel file "+CPLib.LRTrim(w_nomefile)+" per l'informazione in data "+CPLib.CharToDate(CPLib.Left(riga,8))+" relativa al rapporto: "+CPLib.Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              m_cLastMsgError = "";
              /* _esito := 1 */
              _esito = CPLib.Round(1,0);
            } else if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
            /* cInfProg1 := Utilities.GetAutonumber("PRGINFO1\'"+LRTrim(gAzienda)+"'",'',10) */
            cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
            /* cInfProg2 := Utilities.GetAutonumber("PRGINFO2\'"+LRTrim(gAzienda)+"'",'',11) */
            cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
            /* nProgImp := Utilities.GetAutonumber("PRGIMPINF\'"+LRTrim(gAzienda)+"'",0,15) */
            nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINF\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
            // * --- Insert into rapopebo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("rapopebo");
            m_cPhName = m_Ctx.GetPhName("rapopebo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"000001D3")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000001D3(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(xSOCTCF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cFlagLire,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,9,8)+cInfProg2+"0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,17,16),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intertip,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull("0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull("32","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
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
              /* gMsgProc := gMsgProc +"Rilevati errori nel file "+LRTrim(w_nomefile)+" per l'informazione in data "+CharToDate(Left(riga,8))+" relativa al rapporto: "+Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
              gMsgProc = gMsgProc+"Rilevati errori nel file "+CPLib.LRTrim(w_nomefile)+" per l'informazione in data "+CPLib.CharToDate(CPLib.Left(riga,8))+" relativa al rapporto: "+CPLib.Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              m_cLastMsgError = "";
              /* _esito := 1 */
              _esito = CPLib.Round(1,0);
            } else if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
          } // End If
          /* If Substr(riga,1,8) <> '00010101' */
          if (CPLib.ne(CPLib.Substr(riga,1,8),"00010101")) {
            /* _unicode := '' */
            _unicode = "";
            /* _oldreg := '' */
            _oldreg = "";
            // * --- Select from rapopebo
            m_cServer = m_Ctx.GetServer("rapopebo");
            m_cPhName = m_Ctx.GetPhName("rapopebo");
            if (Cursor_rapopebo!=null)
              Cursor_rapopebo.Close();
            Cursor_rapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CDATOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(riga,8),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Left(riga,8))+"  and  RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,17,16),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Substr(riga,17,16))+"  and  TIPOOPRAP='23'  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("rapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_rapopebo.Eof())) {
              /* _unicode := rapopebo->IDBASE */
              _unicode = Cursor_rapopebo.GetString("IDBASE");
              /* _oldreg := rapopebo->IDEREG */
              _oldreg = Cursor_rapopebo.GetString("IDEREG");
              /* _flagrap2 := rapopebo->FLAGRAP2 */
              _flagrap2 = Cursor_rapopebo.GetString("FLAGRAP2");
              /* _idreg := rapopebo->IDEREG */
              _idreg = Cursor_rapopebo.GetString("IDEREG");
              Cursor_rapopebo.Next();
            }
            m_cConnectivityError = Cursor_rapopebo.ErrorMessage();
            Cursor_rapopebo.Close();
            // * --- End Select
            /* If Empty(LRTrim(_unicode)) */
            if (CPLib.Empty(CPLib.LRTrim(_unicode))) {
              /* _intercod := _codinter */
              _intercod = _codinter;
              /* _intercit := _citinter */
              _intercit = _citinter;
              /* _intercab := _cabinter */
              _intercab = _cabinter;
              /* _interprv := _prvinter */
              _interprv = _prvinter;
              /* xCF := '' */
              xCF = "";
              // * --- Read from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              m_cSql = "";
              m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldcon,"C",16,0,m_cServer),m_cServer,_oldcon);
              if (m_Ctx.IsSharedTemp("personbo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("MACROAGENTE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                xCF = Read_Cursor.GetString("CODFISC");
                _oldmac = Read_Cursor.GetString("MACROAGENTE");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on personbo into routine arrt_import_unicredit returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                xCF = "";
                _oldmac = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* cCli1 := xConnes */
              cCli1 = xConnes;
              /* xSOCTCF := '' */
              xSOCTCF = "";
              /* xSOCTCon := '' */
              xSOCTCon = "";
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              /* cFlagLire := '3' */
              cFlagLire = "3";
              /* Verifico la presenza dell'_unicode per evitare duplicazioni di informazioni diverse con lo stesso _unicode */
              /* cInfProg1 := Utilities.GetAutonumber("PRGINFO1\'"+LRTrim(gAzienda)+"'",'',10) */
              cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
              /* cInfProg2 := Utilities.GetAutonumber("PRGINFO2\'"+LRTrim(gAzienda)+"'",'',11) */
              cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
              /* nProgImp := Utilities.GetAutonumber("PRGIMPINF\'"+LRTrim(gAzienda)+"'",0,15) */
              nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINF\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
              // * --- Insert into rapopebo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("rapopebo");
              m_cPhName = m_Ctx.GetPhName("rapopebo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"000001F1")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000001F1(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,1,8),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(xSOCTCF,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,1,8)),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cFlagLire,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,8)+cInfProg2+"0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,17,16),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_intertip,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull("0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull("23","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
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
                /* gMsgProc := gMsgProc +"Rilevati errori nel file "+LRTrim(w_nomefile)+" per l'informazione in data "+CharToDate(Left(riga,8))+" relativa al rapporto: "+Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                gMsgProc = gMsgProc+"Rilevati errori nel file "+CPLib.LRTrim(w_nomefile)+" per l'informazione in data "+CPLib.CharToDate(CPLib.Left(riga,8))+" relativa al rapporto: "+CPLib.Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                m_cLastMsgError = "";
                /* _esito := 1 */
                _esito = CPLib.Round(1,0);
              } else if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
              /* cMaxRow := 0 */
              cMaxRow = CPLib.Round(0,0);
              /* _nummod := 0 */
              _nummod = CPLib.Round(0,0);
              // * --- Select from intestbo
              m_cServer = m_Ctx.GetServer("intestbo");
              m_cPhName = m_Ctx.GetPhName("intestbo");
              if (Cursor_intestbo!=null)
                Cursor_intestbo.Close();
              Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,17,16),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Substr(riga,17,16))+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM ",m_cServer,m_Ctx,true));
              while ( ! (Cursor_intestbo.Eof())) {
                /* If intestbo->CODINTER=_oldcon */
                if (CPLib.eqr(Cursor_intestbo.GetString("CODINTER"),_oldcon)) {
                  /* _nummod := intestbo->CPROWNUM */
                  _nummod = CPLib.Round(Cursor_intestbo.GetDouble("CPROWNUM"),0);
                } // End If
                /* cMaxRow := intestbo->CPROWNUM */
                cMaxRow = CPLib.Round(Cursor_intestbo.GetDouble("CPROWNUM"),0);
                Cursor_intestbo.Next();
              }
              m_cConnectivityError = Cursor_intestbo.ErrorMessage();
              Cursor_intestbo.Close();
              // * --- End Select
              /* If _nummod = 0 */
              if (CPLib.eqr(_nummod,0)) {
                /* nProgImp2 := Utilities.GetAutonumber("PRGIMPSOG\'"+LRTrim(gAzienda)+"'",0,15) */
                nProgImp2 = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPSOG\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
                // * --- Insert into intestbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("intestbo");
                m_cPhName = m_Ctx.GetPhName("intestbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"000001FD")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000001FD(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow+1,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,1,8)),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull(_oldcon,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,17,16),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,8)+cInfProg2+"0","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cCli1,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp2,"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
                  /* gMsgProc := gMsgProc +"Rilevati errori nel file "+LRTrim(w_nomefile)+" per la registrazione dell'intestatario dell'informazione in data "+CharToDate(Left(riga,8))+" relativa al rapporto: "+Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                  gMsgProc = gMsgProc+"Rilevati errori nel file "+CPLib.LRTrim(w_nomefile)+" per la registrazione dell'intestatario dell'informazione in data "+CPLib.CharToDate(CPLib.Left(riga,8))+" relativa al rapporto: "+CPLib.Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                  m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                  m_cLastMsgError = "";
                  /* _esito := 1 */
                  _esito = CPLib.Round(1,0);
                } else if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                }
              } else { // Else
                // * --- Write into intestbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("intestbo");
                m_cPhName = m_Ctx.GetPhName("intestbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"00000201")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DATAINI = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Left(riga,8)),"D",8,0)+", ";
                m_cSql = m_cSql+"NUMPROG1 = "+CPLib.ToSQL(cInfProg2,"C",11,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,17,16),"?",0,0,m_cServer),m_cServer,CPLib.Substr(riga,17,16))+"";
                m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_nummod,"?",0,0,m_cServer),m_cServer,_nummod)+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_nUpdatedRows = 0;
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.lt(m_nUpdatedRows,1)) {
                  // No rows updated
                  /* gMsgProc := gMsgProc +"Rilevati errori nel file "+LRTrim(w_nomefile)+" per la registrazione dell'intestatario dell'informazione in data "+CharToDate(Left(riga,8))+" relativa al rapporto: "+Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                  gMsgProc = gMsgProc+"Rilevati errori nel file "+CPLib.LRTrim(w_nomefile)+" per la registrazione dell'intestatario dell'informazione in data "+CPLib.CharToDate(CPLib.Left(riga,8))+" relativa al rapporto: "+CPLib.Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                  m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                  m_cLastMsgError = "";
                  /* _esito := 1 */
                  _esito = CPLib.Round(1,0);
                } else if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                }
              } // End If
            } else { // Else
              /* _flagrap2 := iif(Empty(_flagrap2),'0',Str(Val(_flagrap2)+1,1,0)) */
              _flagrap2 = (CPLib.Empty(_flagrap2)?"0":CPLib.Str(CPLib.Val(_flagrap2)+1,1,0));
              /* _idreg := Left(_idreg,19)+_flagrap2 */
              _idreg = CPLib.Left(_idreg,19)+_flagrap2;
              // * --- Write into rapopebo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("rapopebo");
              m_cPhName = m_Ctx.GetPhName("rapopebo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"00000207")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL("3","C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARETT = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
              m_cSql = m_cSql+"IDEREG = "+CPLib.ToSQL(_idreg,"C",20,0,m_cServer)+", ";
              m_cSql = m_cSql+"FLAGRAP2 = "+CPLib.ToSQL(_flagrap2,"C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"rapopebo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_unicode,"?",0,0,m_cServer),m_cServer,_unicode)+"";
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
              /* _intercod := _codinter */
              _intercod = _codinter;
              /* _intercit := _citinter */
              _intercit = _citinter;
              /* _intercab := _cabinter */
              _intercab = _cabinter;
              /* _interprv := _prvinter */
              _interprv = _prvinter;
              /* xCF := '' */
              xCF = "";
              // * --- Read from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              m_cSql = "";
              m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldcon,"C",16,0,m_cServer),m_cServer,_oldcon);
              if (m_Ctx.IsSharedTemp("personbo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("MACROAGENTE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                xCF = Read_Cursor.GetString("CODFISC");
                _oldmac = Read_Cursor.GetString("MACROAGENTE");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on personbo into routine arrt_import_unicredit returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                xCF = "";
                _oldmac = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* xSOCTCF := '' */
              xSOCTCF = "";
              /* xSOCTCon := '' */
              xSOCTCon = "";
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              /* cFlagLire := '3' */
              cFlagLire = "3";
              /* Verifico la presenza dell'_unicode per evitare duplicazioni di informazioni diverse con lo stesso _unicode */
              /* cInfProg1 := Utilities.GetAutonumber("PRGINFO1\'"+LRTrim(gAzienda)+"'",'',10) */
              cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
              // * --- Select from rapopebo
              m_cServer = m_Ctx.GetServer("rapopebo");
              m_cPhName = m_Ctx.GetPhName("rapopebo");
              if (Cursor_rapopebo!=null)
                Cursor_rapopebo.Close();
              Cursor_rapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idbase,"?",0,0,m_cServer, m_oParameters),m_cServer,_idbase)+" "+")"+(m_Ctx.IsSharedTemp("rapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_rapopebo.Eof())) {
                // * --- Insert into rapopebo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("rapopebo");
                m_cPhName = m_Ctx.GetPhName("rapopebo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"00000217")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000217(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,1,8),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull(xSOCTCF,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,1,8)),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDate("DATAREG"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cFlagLire,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,17,16),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_intertip,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull("0","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull("23","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_rapopebo.GetDate("DATAREG")),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
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
                  /* gMsgProc := gMsgProc +"Rilevati errori nel file "+LRTrim(w_nomefile)+" per l'informazione in data "+CharToDate(Left(riga,8))+" relativa al rapporto: "+Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                  gMsgProc = gMsgProc+"Rilevati errori nel file "+CPLib.LRTrim(w_nomefile)+" per l'informazione in data "+CPLib.CharToDate(CPLib.Left(riga,8))+" relativa al rapporto: "+CPLib.Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                  m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                  m_cLastMsgError = "";
                  /* _esito := 1 */
                  _esito = CPLib.Round(1,0);
                } else if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                }
                // * --- Select from intestbo
                m_cServer = m_Ctx.GetServer("intestbo");
                m_cPhName = m_Ctx.GetPhName("intestbo");
                if (Cursor_intestbo!=null)
                  Cursor_intestbo.Close();
                Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,17,16),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Substr(riga,17,16))+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM ",m_cServer,m_Ctx,true));
                while ( ! (Cursor_intestbo.Eof())) {
                  /* If intestbo->CODINTER=_oldcon */
                  if (CPLib.eqr(Cursor_intestbo.GetString("CODINTER"),_oldcon)) {
                    /* _nummod := intestbo->CPROWNUM */
                    _nummod = CPLib.Round(Cursor_intestbo.GetDouble("CPROWNUM"),0);
                  } // End If
                  /* cMaxRow := intestbo->CPROWNUM */
                  cMaxRow = CPLib.Round(Cursor_intestbo.GetDouble("CPROWNUM"),0);
                  Cursor_intestbo.Next();
                }
                m_cConnectivityError = Cursor_intestbo.ErrorMessage();
                Cursor_intestbo.Close();
                // * --- End Select
                /* If _nummod = 0 */
                if (CPLib.eqr(_nummod,0)) {
                  /* nProgImp2 := Utilities.GetAutonumber("PRGIMPSOG\'"+LRTrim(gAzienda)+"'",0,15) */
                  nProgImp2 = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPSOG\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
                  // * --- Insert into intestbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("intestbo");
                  m_cPhName = m_Ctx.GetPhName("intestbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"00000221")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000221(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow+1,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,1,8)),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull(_oldcon,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,17,16),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cCli1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp2,"?",0,0)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
                    /* gMsgProc := gMsgProc +"Rilevati errori nel file "+LRTrim(w_nomefile)+" per la registrazione dell'intestatario dell'informazione in data "+CharToDate(Left(riga,8))+" relativa al rapporto: "+Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                    gMsgProc = gMsgProc+"Rilevati errori nel file "+CPLib.LRTrim(w_nomefile)+" per la registrazione dell'intestatario dell'informazione in data "+CPLib.CharToDate(CPLib.Left(riga,8))+" relativa al rapporto: "+CPLib.Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                    m_cLastMsgError = "";
                    /* _esito := 1 */
                    _esito = CPLib.Round(1,0);
                  } else if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                  }
                } else { // Else
                  // * --- Write into intestbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("intestbo");
                  m_cPhName = m_Ctx.GetPhName("intestbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"00000225")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"DATAINI = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Left(riga,8)),"D",8,0)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,17,16),"?",0,0,m_cServer),m_cServer,CPLib.Substr(riga,17,16))+"";
                  m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_nummod,"?",0,0,m_cServer),m_cServer,_nummod)+"";
                  m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  if (CPLib.lt(m_nUpdatedRows,0)) {
                    m_nUpdatedRows = 0;
                  }
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.lt(m_nUpdatedRows,1)) {
                    // No rows updated
                    /* gMsgProc := gMsgProc +"Rilevati errori nel file "+LRTrim(w_nomefile)+" per la registrazione dell'intestatario dell'informazione in data "+CharToDate(Left(riga,8))+" relativa al rapporto: "+Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                    gMsgProc = gMsgProc+"Rilevati errori nel file "+CPLib.LRTrim(w_nomefile)+" per la registrazione dell'intestatario dell'informazione in data "+CPLib.CharToDate(CPLib.Left(riga,8))+" relativa al rapporto: "+CPLib.Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                    m_cLastMsgError = "";
                    /* _esito := 1 */
                    _esito = CPLib.Round(1,0);
                  } else if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                  }
                } // End If
                Cursor_rapopebo.Next();
              }
              m_cConnectivityError = Cursor_rapopebo.ErrorMessage();
              Cursor_rapopebo.Close();
              // * --- End Select
            } // End If
          } // End If
          /* If Substr(riga,9,8) <> '00010101' */
          if (CPLib.ne(CPLib.Substr(riga,9,8),"00010101")) {
            /* _unicode := '' */
            _unicode = "";
            /* _oldreg := '' */
            _oldreg = "";
            // * --- Select from rapopebo
            m_cServer = m_Ctx.GetServer("rapopebo");
            m_cPhName = m_Ctx.GetPhName("rapopebo");
            if (Cursor_rapopebo!=null)
              Cursor_rapopebo.Close();
            Cursor_rapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CDATOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,9,8),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Substr(riga,9,8))+"  and  RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,17,16),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Substr(riga,17,16))+"  and  TIPOOPRAP='26'  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("rapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_rapopebo.Eof())) {
              /* _unicode := rapopebo->IDBASE */
              _unicode = Cursor_rapopebo.GetString("IDBASE");
              /* _oldreg := rapopebo->IDEREG */
              _oldreg = Cursor_rapopebo.GetString("IDEREG");
              /* _flagrap2 := rapopebo->FLAGRAP2 */
              _flagrap2 = Cursor_rapopebo.GetString("FLAGRAP2");
              /* _idreg := rapopebo->IDEREG */
              _idreg = Cursor_rapopebo.GetString("IDEREG");
              Cursor_rapopebo.Next();
            }
            m_cConnectivityError = Cursor_rapopebo.ErrorMessage();
            Cursor_rapopebo.Close();
            // * --- End Select
            /* If Empty(LRTrim(_unicode)) */
            if (CPLib.Empty(CPLib.LRTrim(_unicode))) {
              /* _intercod := _codinter */
              _intercod = _codinter;
              /* _intercit := _citinter */
              _intercit = _citinter;
              /* _intercab := _cabinter */
              _intercab = _cabinter;
              /* _interprv := _prvinter */
              _interprv = _prvinter;
              /* xCF := '' */
              xCF = "";
              // * --- Read from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              m_cSql = "";
              m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldcon,"C",16,0,m_cServer),m_cServer,_oldcon);
              if (m_Ctx.IsSharedTemp("personbo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("MACROAGENTE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                xCF = Read_Cursor.GetString("CODFISC");
                _oldmac = Read_Cursor.GetString("MACROAGENTE");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on personbo into routine arrt_import_unicredit returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                xCF = "";
                _oldmac = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* cCli1 := xConnes */
              cCli1 = xConnes;
              /* xSOCTCF := '' */
              xSOCTCF = "";
              /* xSOCTCon := '' */
              xSOCTCon = "";
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              /* cFlagLire := '3' */
              cFlagLire = "3";
              /* Verifico la presenza dell'_unicode per evitare duplicazioni di informazioni diverse con lo stesso _unicode */
              /* cInfProg1 := Utilities.GetAutonumber("PRGINFO1\'"+LRTrim(gAzienda)+"'",'',10) */
              cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
              /* cInfProg2 := Utilities.GetAutonumber("PRGINFO2\'"+LRTrim(gAzienda)+"'",'',11) */
              cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
              /* nProgImp := Utilities.GetAutonumber("PRGIMPINF\'"+LRTrim(gAzienda)+"'",0,15) */
              nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINF\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
              // * --- Insert into rapopebo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("rapopebo");
              m_cPhName = m_Ctx.GetPhName("rapopebo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"00000242")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000242(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,9,8),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(xSOCTCF,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,9,8)),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cFlagLire,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,9,8)+cInfProg2+"0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,17,16),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_intertip,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull("0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull("26","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
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
                /* gMsgProc := gMsgProc +"Rilevati errori nel file "+LRTrim(w_nomefile)+" per l'informazione in data "+CharToDate(Left(riga,8))+" relativa al rapporto: "+Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                gMsgProc = gMsgProc+"Rilevati errori nel file "+CPLib.LRTrim(w_nomefile)+" per l'informazione in data "+CPLib.CharToDate(CPLib.Left(riga,8))+" relativa al rapporto: "+CPLib.Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                m_cLastMsgError = "";
                /* _esito := 1 */
                _esito = CPLib.Round(1,0);
              } else if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
              /* cMaxRow := 0 */
              cMaxRow = CPLib.Round(0,0);
              /* _nummod := 0 */
              _nummod = CPLib.Round(0,0);
              // * --- Select from intestbo
              m_cServer = m_Ctx.GetServer("intestbo");
              m_cPhName = m_Ctx.GetPhName("intestbo");
              if (Cursor_intestbo!=null)
                Cursor_intestbo.Close();
              Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,17,16),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Substr(riga,17,16))+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM ",m_cServer,m_Ctx,true));
              while ( ! (Cursor_intestbo.Eof())) {
                /* If intestbo->CODINTER=_oldcon */
                if (CPLib.eqr(Cursor_intestbo.GetString("CODINTER"),_oldcon)) {
                  /* _nummod := intestbo->CPROWNUM */
                  _nummod = CPLib.Round(Cursor_intestbo.GetDouble("CPROWNUM"),0);
                } // End If
                /* cMaxRow := intestbo->CPROWNUM */
                cMaxRow = CPLib.Round(Cursor_intestbo.GetDouble("CPROWNUM"),0);
                Cursor_intestbo.Next();
              }
              m_cConnectivityError = Cursor_intestbo.ErrorMessage();
              Cursor_intestbo.Close();
              // * --- End Select
              /* If _nummod = 0 */
              if (CPLib.eqr(_nummod,0)) {
                /* nProgImp2 := Utilities.GetAutonumber("PRGIMPSOG\'"+LRTrim(gAzienda)+"'",0,15) */
                nProgImp2 = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPSOG\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
                // * --- Insert into intestbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("intestbo");
                m_cPhName = m_Ctx.GetPhName("intestbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"0000024E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000024E(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow+1,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,9,8)),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull(_oldcon,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,17,16),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,9,8)+cInfProg2+"0","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cCli1,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp2,"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
                  /* gMsgProc := gMsgProc +"Rilevati errori nel file "+LRTrim(w_nomefile)+" per la registrazione dell'intestatario dell'informazione in data "+CharToDate(Left(riga,8))+" relativa al rapporto: "+Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                  gMsgProc = gMsgProc+"Rilevati errori nel file "+CPLib.LRTrim(w_nomefile)+" per la registrazione dell'intestatario dell'informazione in data "+CPLib.CharToDate(CPLib.Left(riga,8))+" relativa al rapporto: "+CPLib.Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                  m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                  m_cLastMsgError = "";
                  /* _esito := 1 */
                  _esito = CPLib.Round(1,0);
                } else if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                }
              } else { // Else
                // * --- Write into intestbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("intestbo");
                m_cPhName = m_Ctx.GetPhName("intestbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"00000252")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Left(riga,8)),"D",8,0)+", ";
                m_cSql = m_cSql+"NUMPROG2 = "+CPLib.ToSQL(cInfProg2,"C",11,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,17,16),"?",0,0,m_cServer),m_cServer,CPLib.Substr(riga,17,16))+"";
                m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_nummod,"?",0,0,m_cServer),m_cServer,_nummod)+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_nUpdatedRows = 0;
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.lt(m_nUpdatedRows,1)) {
                  // No rows updated
                  /* gMsgProc := gMsgProc +"Rilevati errori nel file "+LRTrim(w_nomefile)+" per la registrazione dell'intestatario dell'informazione in data "+CharToDate(Left(riga,8))+" relativa al rapporto: "+Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                  gMsgProc = gMsgProc+"Rilevati errori nel file "+CPLib.LRTrim(w_nomefile)+" per la registrazione dell'intestatario dell'informazione in data "+CPLib.CharToDate(CPLib.Left(riga,8))+" relativa al rapporto: "+CPLib.Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                  m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                  m_cLastMsgError = "";
                  /* _esito := 1 */
                  _esito = CPLib.Round(1,0);
                } else if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                }
              } // End If
            } else { // Else
              /* _flagrap2 := iif(Empty(_flagrap2),'0',Str(Val(_flagrap2)+1,1,0)) */
              _flagrap2 = (CPLib.Empty(_flagrap2)?"0":CPLib.Str(CPLib.Val(_flagrap2)+1,1,0));
              /* _idreg := Left(_idreg,19)+_flagrap2 */
              _idreg = CPLib.Left(_idreg,19)+_flagrap2;
              // * --- Write into rapopebo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("rapopebo");
              m_cPhName = m_Ctx.GetPhName("rapopebo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"00000258")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL("3","C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARETT = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
              m_cSql = m_cSql+"IDEREG = "+CPLib.ToSQL(_idreg,"C",20,0,m_cServer)+", ";
              m_cSql = m_cSql+"FLAGRAP2 = "+CPLib.ToSQL(_flagrap2,"C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"rapopebo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_unicode,"?",0,0,m_cServer),m_cServer,_unicode)+"";
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
              /* _intercod := _codinter */
              _intercod = _codinter;
              /* _intercit := _citinter */
              _intercit = _citinter;
              /* _intercab := _cabinter */
              _intercab = _cabinter;
              /* _interprv := _prvinter */
              _interprv = _prvinter;
              /* xCF := '' */
              xCF = "";
              // * --- Read from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              m_cSql = "";
              m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldcon,"C",16,0,m_cServer),m_cServer,_oldcon);
              if (m_Ctx.IsSharedTemp("personbo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("MACROAGENTE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                xCF = Read_Cursor.GetString("CODFISC");
                _oldmac = Read_Cursor.GetString("MACROAGENTE");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on personbo into routine arrt_import_unicredit returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                xCF = "";
                _oldmac = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* xSOCTCF := '' */
              xSOCTCF = "";
              /* xSOCTCon := '' */
              xSOCTCon = "";
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              /* cFlagLire := '3' */
              cFlagLire = "3";
              /* Verifico la presenza dell'_unicode per evitare duplicazioni di informazioni diverse con lo stesso _unicode */
              /* cInfProg1 := Utilities.GetAutonumber("PRGINFO1\'"+LRTrim(gAzienda)+"'",'',10) */
              cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
              // * --- Select from rapopebo
              m_cServer = m_Ctx.GetServer("rapopebo");
              m_cPhName = m_Ctx.GetPhName("rapopebo");
              if (Cursor_rapopebo!=null)
                Cursor_rapopebo.Close();
              Cursor_rapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idbase,"?",0,0,m_cServer, m_oParameters),m_cServer,_idbase)+" "+")"+(m_Ctx.IsSharedTemp("rapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_rapopebo.Eof())) {
                // * --- Insert into rapopebo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("rapopebo");
                m_cPhName = m_Ctx.GetPhName("rapopebo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"00000268")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000268(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,9,8),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull(xSOCTCF,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,9,8)),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDate("DATAREG"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cFlagLire,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,17,16),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_intertip,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull("0","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull("26","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_rapopebo.GetDate("DATAREG")),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
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
                  /* gMsgProc := gMsgProc +"Rilevati errori nel file "+LRTrim(w_nomefile)+" per l'informazione in data "+CharToDate(Left(riga,8))+" relativa al rapporto: "+Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                  gMsgProc = gMsgProc+"Rilevati errori nel file "+CPLib.LRTrim(w_nomefile)+" per l'informazione in data "+CPLib.CharToDate(CPLib.Left(riga,8))+" relativa al rapporto: "+CPLib.Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                  m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                  m_cLastMsgError = "";
                  /* _esito := 1 */
                  _esito = CPLib.Round(1,0);
                } else if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                }
                // * --- Select from intestbo
                m_cServer = m_Ctx.GetServer("intestbo");
                m_cPhName = m_Ctx.GetPhName("intestbo");
                if (Cursor_intestbo!=null)
                  Cursor_intestbo.Close();
                Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,17,16),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Substr(riga,17,16))+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM ",m_cServer,m_Ctx,true));
                while ( ! (Cursor_intestbo.Eof())) {
                  /* If intestbo->CODINTER=_oldcon */
                  if (CPLib.eqr(Cursor_intestbo.GetString("CODINTER"),_oldcon)) {
                    /* _nummod := intestbo->CPROWNUM */
                    _nummod = CPLib.Round(Cursor_intestbo.GetDouble("CPROWNUM"),0);
                  } // End If
                  /* cMaxRow := intestbo->CPROWNUM */
                  cMaxRow = CPLib.Round(Cursor_intestbo.GetDouble("CPROWNUM"),0);
                  Cursor_intestbo.Next();
                }
                m_cConnectivityError = Cursor_intestbo.ErrorMessage();
                Cursor_intestbo.Close();
                // * --- End Select
                /* If _nummod = 0 */
                if (CPLib.eqr(_nummod,0)) {
                  /* nProgImp2 := Utilities.GetAutonumber("PRGIMPSOG\'"+LRTrim(gAzienda)+"'",0,15) */
                  nProgImp2 = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPSOG\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
                  // * --- Insert into intestbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("intestbo");
                  m_cPhName = m_Ctx.GetPhName("intestbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"00000272")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000272(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow+1,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,9,8)),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull(_oldcon,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,17,16),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cCli1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp2,"?",0,0)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
                    /* gMsgProc := gMsgProc +"Rilevati errori nel file "+LRTrim(w_nomefile)+" per la registrazione dell'intestatario dell'informazione in data "+CharToDate(Left(riga,8))+" relativa al rapporto: "+Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                    gMsgProc = gMsgProc+"Rilevati errori nel file "+CPLib.LRTrim(w_nomefile)+" per la registrazione dell'intestatario dell'informazione in data "+CPLib.CharToDate(CPLib.Left(riga,8))+" relativa al rapporto: "+CPLib.Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                    m_cLastMsgError = "";
                    /* _esito := 1 */
                    _esito = CPLib.Round(1,0);
                  } else if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                  }
                } else { // Else
                  // * --- Write into intestbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("intestbo");
                  m_cPhName = m_Ctx.GetPhName("intestbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"00000276")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Left(riga,8)),"D",8,0)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,17,16),"?",0,0,m_cServer),m_cServer,CPLib.Substr(riga,17,16))+"";
                  m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_nummod,"?",0,0,m_cServer),m_cServer,_nummod)+"";
                  m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  if (CPLib.lt(m_nUpdatedRows,0)) {
                    m_nUpdatedRows = 0;
                  }
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.lt(m_nUpdatedRows,1)) {
                    // No rows updated
                    /* gMsgProc := gMsgProc +"Rilevati errori nel file "+LRTrim(w_nomefile)+" per la registrazione dell'intestatario dell'informazione in data "+CharToDate(Left(riga,8))+" relativa al rapporto: "+Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                    gMsgProc = gMsgProc+"Rilevati errori nel file "+CPLib.LRTrim(w_nomefile)+" per la registrazione dell'intestatario dell'informazione in data "+CPLib.CharToDate(CPLib.Left(riga,8))+" relativa al rapporto: "+CPLib.Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                    m_cLastMsgError = "";
                    /* _esito := 1 */
                    _esito = CPLib.Round(1,0);
                  } else if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                  }
                } // End If
                Cursor_rapopebo.Next();
              }
              m_cConnectivityError = Cursor_rapopebo.ErrorMessage();
              Cursor_rapopebo.Close();
              // * --- End Select
            } // End If
          } // End If
        } else { // Else
          /* _errmsg := 'Data di inizio rapporto non coincide' */
          _errmsg = "Data di inizio rapporto non coincide";
          /* _errmod := 'S' */
          _errmod = "S";
        } // End If
      } else { // Else
        /* _errmsg := 'Aggiornamento di un rapporto inesistente su archivio UNICO' */
        _errmsg = "Aggiornamento di un rapporto inesistente su archivio UNICO";
        /* _errmod := 'S' */
        _errmod = "S";
      } // End If
      /* If _errmod = 'S' */
      if (CPLib.eqr(_errmod,"S")) {
        /* eProg := Utilities.GetAutonumber("PRGWUCHKUNC\'"+LRTrim(gAzienda)+"'",0,10) */
        eProg = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGWUCHKUNC\\'"+CPLib.LRTrim(gAzienda)+"'",0,10),0);
        /* xCitta := Substr(riga,143,30) */
        xCitta = CPLib.Substr(riga,143,30);
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
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("PROV",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          cPNAS = Read_Cursor.GetString("PROV");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_unicredit returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          cPNAS = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* cSNAS := '' */
        cSNAS = "";
        /* cCNAS := Substr(riga,143,30) */
        cCNAS = CPLib.Substr(riga,143,30);
        /* If (Substr(riga,554,1) = 'Z' or LRTrim(Substr(riga,193,30)) <> 'ITALIA') and Len(LRTrim(xSesso))=1 */
        if ((CPLib.eqr(CPLib.Substr(riga,554,1),"Z") || CPLib.ne(CPLib.LRTrim(CPLib.Substr(riga,193,30)),"ITALIA")) && CPLib.eqr(CPLib.Len(CPLib.LRTrim(xSesso)),1)) {
          /* cSNAS := Substr(riga,193,30) */
          cSNAS = CPLib.Substr(riga,193,30);
          /* cCNAS := '' */
          cCNAS = "";
        } // End If
        /* xProvRes := '' */
        xProvRes = "";
        // * --- Read from tbcitta
        m_cServer = m_Ctx.GetServer("tbcitta");
        m_cPhName = m_Ctx.GetPhName("tbcitta");
        m_cSql = "";
        m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,343,30),"C",60,0,m_cServer),m_cServer,CPLib.Substr(riga,343,30));
        if (m_Ctx.IsSharedTemp("tbcitta")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROV",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          xCodCab = Read_Cursor.GetString("CAB");
          xProvRes = Read_Cursor.GetString("PROV");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_unicredit returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          xCodCab = "";
          xProvRes = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* cSRES := Substr(riga,393,40) */
        cSRES = CPLib.Substr(riga,393,40);
        /* cSRES2 := '' */
        cSRES2 = "";
        // * --- Read from tbstati
        m_cServer = m_Ctx.GetServer("tbstati");
        m_cPhName = m_Ctx.GetPhName("tbstati");
        m_cSql = "";
        m_cSql = m_cSql+"DESCRI="+CPSql.SQLValueAdapter(CPLib.ToSQL(cSRES,"C",40,0,m_cServer),m_cServer,cSRES);
        if (m_Ctx.IsSharedTemp("tbstati")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODSTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          cSRES2 = Read_Cursor.GetString("CODSTA");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_unicredit returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          cSRES2 = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        // * --- Insert into wuchkunicr from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("wuchkunicr");
        m_cPhName = m_Ctx.GetPhName("wuchkunicr");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wuchkunicr",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"0000028C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000028C(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(eProg,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(w_nomefile),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.Substr(riga,1,8),"00010101")?CPLib.NullDate():CPLib.CharToDate(CPLib.Substr(riga,1,8))),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.Substr(riga,9,8),"00010101")?CPLib.NullDate():CPLib.CharToDate(CPLib.Substr(riga,9,8))),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,17,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,84,25)),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,34,26)),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,343,30),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,443,5),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,243,35),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cCNAS,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cSNAS,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(arfn_fdateR.Make(m_Ctx,this).Run((CPLib.eqr(CPLib.Substr(riga,125,8),"00010101")?CPLib.NullDate():CPLib.CharToDate(CPLib.Substr(riga,135,8)))),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,134,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,543,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,559,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,561,15),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,592,30),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(arfn_fdateR.Make(m_Ctx,this).Run((CPLib.eqr(CPLib.Substr(riga,576,8),"00010101")?CPLib.NullDate():CPLib.CharToDate(CPLib.Substr(riga,576,8)))),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(arfn_fdateR.Make(m_Ctx,this).Run((CPLib.eqr(CPLib.Substr(riga,584,8),"00010101")?CPLib.NullDate():CPLib.CharToDate(CPLib.Substr(riga,584,8)))),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(xProvRes,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,668,25),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,667,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,642,25)),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_errmsg,"?",0,0,m_cServer, m_oParameters)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cSRES,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wuchkunicr",true);
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
        /* cNumSca := cNumSca + 1 */
        cNumSca = CPLib.Round(cNumSca+1,0);
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
        if (Cursor_knarapbo!=null)
          Cursor_knarapbo.Close();
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
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_4() throws Exception {
    CPResultSet Cursor_intestbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_knarapbo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_xntestbo=null;
    try {
      /* _xrapclose Char(25) */
      String _xrapclose;
      _xrapclose = CPLib.Space(25);
      /* _xtiprap Char(1) */
      String _xtiprap;
      _xtiprap = CPLib.Space(1);
      /* _xrapclose := '' */
      _xrapclose = "";
      /* _xtiprap := '' */
      _xtiprap = "";
      /* If w_xMAFLGRAP='S' */
      if (CPLib.eqr(w_xMAFLGRAP,"S")) {
        // * --- Select from intestbo
        m_cServer = m_Ctx.GetServer("intestbo");
        m_cPhName = m_Ctx.GetPhName("intestbo");
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
        Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,17,16),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Substr(riga,17,16))+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intestbo.Eof())) {
          // * --- Read from anarapbo
          m_cServer = m_Ctx.GetServer("anarapbo");
          m_cPhName = m_Ctx.GetPhName("anarapbo");
          m_cSql = "";
          m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_intestbo.GetString("RAPPORTO"));
          if (m_Ctx.IsSharedTemp("anarapbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("MACODICE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _magecod = Read_Cursor.GetString("MACODICE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on anarapbo into routine arrt_import_unicredit returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _magecod = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If _magecod=w_codmage */
          if (CPLib.eqr(_magecod,w_codmage)) {
            /* _xrapporto := intestbo->RAPPORTO */
            _xrapporto = Cursor_intestbo.GetString("RAPPORTO");
          } // End If
          Cursor_intestbo.Next();
        }
        m_cConnectivityError = Cursor_intestbo.ErrorMessage();
        Cursor_intestbo.Close();
        // * --- End Select
      } else { // Else
        /* _xrapporto := Substr(riga,17,16) */
        _xrapporto = CPLib.Substr(riga,17,16);
      } // End If
      // * --- Select from knarapbo
      m_cServer = m_Ctx.GetServer("knarapbo");
      m_cPhName = m_Ctx.GetPhName("knarapbo");
      if (Cursor_knarapbo!=null)
        Cursor_knarapbo.Close();
      Cursor_knarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_xrapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,_xrapporto)+" "+")"+(m_Ctx.IsSharedTemp("knarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_knarapbo.Eof())) {
        /* _xrapclose := knarapbo->RAPPORTO */
        _xrapclose = Cursor_knarapbo.GetString("RAPPORTO");
        /* _xtiprap := knarapbo->TIPORAP */
        _xtiprap = Cursor_knarapbo.GetString("TIPORAP");
        Cursor_knarapbo.Next();
      }
      m_cConnectivityError = Cursor_knarapbo.ErrorMessage();
      Cursor_knarapbo.Close();
      // * --- End Select
      /* If not(Empty(LRTrim(_xrapclose))) */
      if ( ! (CPLib.Empty(CPLib.LRTrim(_xrapclose)))) {
        /* If Substr(riga,9,8) <> '00010101' */
        if (CPLib.ne(CPLib.Substr(riga,9,8),"00010101")) {
          /* _oldmac := '' */
          _oldmac = "";
          /* _oldrag := '' */
          _oldrag = "";
          /* xCF := '' */
          xCF = "";
          /* _oldcon := '' */
          _oldcon = "";
          /* xConnes := Substr(riga,17,16) */
          xConnes = CPLib.Substr(riga,17,16);
          // * --- Read from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          m_cSql = "";
          m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,17,16),"C",16,0,m_cServer),m_cServer,CPLib.Substr(riga,17,16));
          if (m_Ctx.IsSharedTemp("personbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("MACROAGENTE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RAGSOC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _oldmac = Read_Cursor.GetString("MACROAGENTE");
            _oldrag = Read_Cursor.GetString("RAGSOC");
            _oldcon = Read_Cursor.GetString("CONNES");
            xCF = Read_Cursor.GetString("CODFISC");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on personbo into routine arrt_import_unicredit returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _oldmac = "";
            _oldrag = "";
            _oldcon = "";
            xCF = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(_oldrag)) */
          if (CPLib.Empty(CPLib.LRTrim(_oldrag))) {
            /* xConnes := '' */
            xConnes = "";
            /* _oldmac := '' */
            _oldmac = "";
            /* _oldrag := '' */
            _oldrag = "";
            // * --- Read from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_cSql = "";
            m_cSql = m_cSql+"CODFISC="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,543,16),"C",16,0,m_cServer),m_cServer,CPLib.Substr(riga,543,16));
            if (m_Ctx.IsSharedTemp("personbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("MACROAGENTE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RAGSOC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _oldmac = Read_Cursor.GetString("MACROAGENTE");
              _oldrag = Read_Cursor.GetString("RAGSOC");
              xCF = Read_Cursor.GetString("CODFISC");
              xConnes = Read_Cursor.GetString("CONNES");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on personbo into routine arrt_import_unicredit returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _oldmac = "";
              _oldrag = "";
              xCF = "";
              xConnes = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
          } // End If
          /* _aggcli := 0 */
          _aggcli = CPLib.Round(0,0);
          /* Case LRTrim(w_codmage)='COSTA' */
          if (CPLib.eqr(CPLib.LRTrim(w_codmage),"COSTA")) {
            /* _aggcli := 1 */
            _aggcli = CPLib.Round(1,0);
            /* Case w_codmage='FININ' */
          } else if (CPLib.eqr(w_codmage,"FININ")) {
            /* If _oldmac <> 'COSTA' */
            if (CPLib.ne(_oldmac,"COSTA")) {
              /* _aggcli := 1 */
              _aggcli = CPLib.Round(1,0);
            } // End If
            /* Case w_codmage='BCAUC' */
          } else if (CPLib.eqr(w_codmage,"BCAUC")) {
            /* If _oldmac <> 'COSTA' and _oldmac <> 'FININ' */
            if (CPLib.ne(_oldmac,"COSTA") && CPLib.ne(_oldmac,"FININ")) {
              /* _aggcli := 1 */
              _aggcli = CPLib.Round(1,0);
            } // End If
            /* Case w_codmage='BCISP' */
          } else if (CPLib.eqr(w_codmage,"BCISP")) {
            /* If _oldmac <> 'COSTA' and _oldmac <> 'FININ' and _oldmac <> 'BCAUC' */
            if (CPLib.ne(_oldmac,"COSTA") && CPLib.ne(_oldmac,"FININ") && CPLib.ne(_oldmac,"BCAUC")) {
              /* _aggcli := 1 */
              _aggcli = CPLib.Round(1,0);
            } // End If
            /* Case w_codmage='BCASS' or LRTrim(w_codmage)='E998' or LRTrim(w_codmage)='EBDSS' or LRTrim(w_codmage)='I999' */
          } else if (CPLib.eqr(w_codmage,"BCASS") || CPLib.eqr(CPLib.LRTrim(w_codmage),"E998") || CPLib.eqr(CPLib.LRTrim(w_codmage),"EBDSS") || CPLib.eqr(CPLib.LRTrim(w_codmage),"I999")) {
            /* If _oldmac <> 'COSTA' and _oldmac <> 'FININ' and _oldmac <> 'BCAUC' and _oldmac <> 'BCISP' */
            if (CPLib.ne(_oldmac,"COSTA") && CPLib.ne(_oldmac,"FININ") && CPLib.ne(_oldmac,"BCAUC") && CPLib.ne(_oldmac,"BCISP")) {
              /* _aggcli := 1 */
              _aggcli = CPLib.Round(1,0);
            } // End If
            /* Case w_codmage='DHLSP' */
          } else if (CPLib.eqr(w_codmage,"DHLSP")) {
            /* If _oldmac = 'TRAVX' or _oldmac='DHLSP' */
            if (CPLib.eqr(_oldmac,"TRAVX") || CPLib.eqr(_oldmac,"DHLSP")) {
              /* _aggcli := 1 */
              _aggcli = CPLib.Round(1,0);
            } // End If
            /* Case w_codmage='TRAVX' */
          } else if (CPLib.eqr(w_codmage,"TRAVX")) {
            /* If _oldmac='TRAVX' */
            if (CPLib.eqr(_oldmac,"TRAVX")) {
              /* _aggcli := 1 */
              _aggcli = CPLib.Round(1,0);
            } // End If
          } // End Case
          /* If _aggcli = 1 */
          if (CPLib.eqr(_aggcli,1)) {
            /* cProgSto := Utilities.GetAutonumber("PSTOPERS\'"+LRTrim(gAzienda)+"'","",15) */
            cProgSto = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PSTOPERS\\'"+CPLib.LRTrim(gAzienda)+"'","",15);
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(xConnes,"?",0,0,m_cServer, m_oParameters),m_cServer,xConnes)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Insert into wersonbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("wersonbo");
              m_cPhName = m_Ctx.GetPhName("wersonbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"000002BD")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000002BD(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(cProgSto,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(xConnes,"?",0,0,m_cServer)+", ";
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
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
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
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PEP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("OLDCODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("MACROAGENTE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SPOTID"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATASEGN"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("OLDSETSIN"),"?",0,0,m_cServer)+", ";
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
            /* cSRES := '' */
            cSRES = "";
            /* cSRES2 := '' */
            cSRES2 = "";
            /* xCF := '' */
            xCF = "";
            // * --- Read from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_cSql = "";
            m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(xConnes,"C",16,0,m_cServer),m_cServer,xConnes);
            if (m_Ctx.IsSharedTemp("personbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              xCF = Read_Cursor.GetString("CODFISC");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on personbo into routine arrt_import_unicredit returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              xCF = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* xSesso := iif(Substr(riga,134,1)='M','1',iif(Substr(riga,134,1)='F','2',Substr(riga,134,1))) */
            xSesso = (CPLib.eqr(CPLib.Substr(riga,134,1),"M")?"1":(CPLib.eqr(CPLib.Substr(riga,134,1),"F")?"2":CPLib.Substr(riga,134,1)));
            /* xCitta := Substr(riga,143,30) */
            xCitta = CPLib.Substr(riga,143,30);
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
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("PROV",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              cPNAS = Read_Cursor.GetString("PROV");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_unicredit returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              cPNAS = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* cSNAS := '' */
            cSNAS = "";
            /* cCNAS := Substr(riga,143,30) */
            cCNAS = CPLib.Substr(riga,143,30);
            /* If (Substr(riga,554,1) = 'Z' or LRTrim(Substr(riga,193,30)) <> 'ITALIA') and Len(LRTrim(xSesso))=1 */
            if ((CPLib.eqr(CPLib.Substr(riga,554,1),"Z") || CPLib.ne(CPLib.LRTrim(CPLib.Substr(riga,193,30)),"ITALIA")) && CPLib.eqr(CPLib.Len(CPLib.LRTrim(xSesso)),1)) {
              /* cPNAS := 'EE' */
              cPNAS = "EE";
              /* cSNAS := Substr(riga,193,30) */
              cSNAS = CPLib.Substr(riga,193,30);
              /* cCNAS := '' */
              cCNAS = "";
            } // End If
            /* cSRES := Substr(riga,393,40) */
            cSRES = CPLib.Substr(riga,393,40);
            /* cSRES2 := '' */
            cSRES2 = "";
            /* xProvRes := '' */
            xProvRes = "";
            // * --- Read from tbcitta
            m_cServer = m_Ctx.GetServer("tbcitta");
            m_cPhName = m_Ctx.GetPhName("tbcitta");
            m_cSql = "";
            m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,343,30),"C",60,0,m_cServer),m_cServer,CPLib.Substr(riga,343,30));
            if (m_Ctx.IsSharedTemp("tbcitta")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROV",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              xCodCab = Read_Cursor.GetString("CAB");
              xProvRes = Read_Cursor.GetString("PROV");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_unicredit returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              xCodCab = "";
              xProvRes = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            // * --- Read from tbstati
            m_cServer = m_Ctx.GetServer("tbstati");
            m_cPhName = m_Ctx.GetPhName("tbstati");
            m_cSql = "";
            m_cSql = m_cSql+"DESCRI="+CPSql.SQLValueAdapter(CPLib.ToSQL(cSRES,"C",40,0,m_cServer),m_cServer,cSRES);
            if (m_Ctx.IsSharedTemp("tbstati")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODSTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              cSRES2 = Read_Cursor.GetString("CODSTA");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_unicredit returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              cSRES2 = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* _tipper := iif(Len(LRTrim(xSesso))=1,'P','G') */
            _tipper = (CPLib.eqr(CPLib.Len(CPLib.LRTrim(xSesso)),1)?"P":"G");
            // * --- Write into personbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"000002D1")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(xCodCab,"C",6,0,m_cServer)+", ";
            m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(CPLib.Substr(riga,34,50))+" "+CPLib.LRTrim(CPLib.Substr(riga,84,50)),70),"C",70,0,m_cServer)+", ";
            m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(CPLib.Substr(riga,243,35),"C",35,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(xCF,"C",16,0,m_cServer)+", ";
            m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,135,8)),"D",8,0)+", ";
            m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(cCNAS,"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL("600","C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL("","C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL("600","C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(CPLib.Substr(riga,559,2),"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(CPLib.Substr(riga,561,15),"C",15,0,m_cServer)+", ";
            m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,576,8)),"D",8,0)+", ";
            m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(CPLib.Substr(riga,592,30),"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.Substr(riga,343,30),"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(xProvRes,"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(CPLib.Substr(riga,443,9),"C",9,0,m_cServer)+", ";
            m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(xSesso,"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(cSRES2,"C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"DATAVALI = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,584,8)),"D",8,0)+", ";
            m_cSql = m_cSql+"TIPOPERS = "+CPLib.ToSQL(_tipper,"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,34,26)),"C",26,0,m_cServer)+", ";
            m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,84,25)),"C",25,0,m_cServer)+", ";
            m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(cPNAS,"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(cSNAS,"C",30,0,m_cServer)+", ";
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
              /* gMsgProc := gMsgProc +"Rilevati errori nel file "+LRTrim(w_nomefile)+" per il soggetto: "+LRTrim(Substr(riga,34,100))+" con codice fiscale: "+LRTrim(Substr(riga,543,16))+NL */
              gMsgProc = gMsgProc+"Rilevati errori nel file "+CPLib.LRTrim(w_nomefile)+" per il soggetto: "+CPLib.LRTrim(CPLib.Substr(riga,34,100))+" con codice fiscale: "+CPLib.LRTrim(CPLib.Substr(riga,543,16))+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              /* gMsgProc := gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
              gMsgProc = gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              /* _esito := 1 */
              _esito = CPLib.Round(1,0);
              m_cLastMsgError = "";
            } else if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
            /* _connes := '' */
            _connes = "";
            // * --- Read from personbo_agg
            m_cServer = m_Ctx.GetServer("personbo_agg");
            m_cPhName = m_Ctx.GetPhName("personbo_agg");
            m_cSql = "";
            m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(xConnes,"C",16,0,m_cServer),m_cServer,xConnes);
            if (m_Ctx.IsSharedTemp("personbo_agg")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _connes = Read_Cursor.GetString("CONNES");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on personbo_agg into routine arrt_import_unicredit returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _connes = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(LRTrim(_connes)) */
            if (CPLib.Empty(CPLib.LRTrim(_connes))) {
              // * --- Insert into personbo_agg from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("personbo_agg");
              m_cPhName = m_Ctx.GetPhName("personbo_agg");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"000002D9")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000002D9(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(xConnes,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,668,25),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.ne(CPLib.At(CPLib.Upper(CPLib.Substr(riga,667,1)),"|S|Y"),0)?"S":"N"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,642,25)),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo_agg",true);
              m_cSql = m_cSql+")";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_nUpdatedRows = 0;
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.lt(m_nUpdatedRows,1)) {
                // No rows inserted
                /* gMsgProc := gMsgProc +"Rilevati errori nel file "+LRTrim(w_nomefile)+" per il soggetto: "+LRTrim(Substr(riga,34,100))+" con codice fiscale: "+LRTrim(Substr(riga,543,16))+NL */
                gMsgProc = gMsgProc+"Rilevati errori nel file "+CPLib.LRTrim(w_nomefile)+" per il soggetto: "+CPLib.LRTrim(CPLib.Substr(riga,34,100))+" con codice fiscale: "+CPLib.LRTrim(CPLib.Substr(riga,543,16))+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* gMsgProc := gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                gMsgProc = gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* _esito := 1 */
                _esito = CPLib.Round(1,0);
                m_cLastMsgError = "";
              } else if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
            } else { // Else
              // * --- Write into personbo_agg from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("personbo_agg");
              m_cPhName = m_Ctx.GetPhName("personbo_agg");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"000002DE")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"FLGBANCA = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"TELEFONO = "+CPLib.ToSQL(CPLib.Substr(riga,668,25),"C",50,0,m_cServer)+", ";
              m_cSql = m_cSql+"FLGEMAIL = "+CPLib.ToSQL((CPLib.ne(CPLib.At(CPLib.Upper(CPLib.Substr(riga,667,1)),"|S|Y"),0)?"S":"N"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"EMAIL = "+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,642,25)),"M",10,0,m_cServer,m_oParameters)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo_agg",false,true);
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
                /* gMsgProc := gMsgProc +"Rilevati errori nel file "+LRTrim(w_nomefile)+" per il soggetto: "+LRTrim(Substr(riga,34,100))+" con codice fiscale: "+LRTrim(Substr(riga,543,16))+NL */
                gMsgProc = gMsgProc+"Rilevati errori nel file "+CPLib.LRTrim(w_nomefile)+" per il soggetto: "+CPLib.LRTrim(CPLib.Substr(riga,34,100))+" con codice fiscale: "+CPLib.LRTrim(CPLib.Substr(riga,543,16))+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* gMsgProc := gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                gMsgProc = gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* _esito := 1 */
                _esito = CPLib.Round(1,0);
                m_cLastMsgError = "";
              } else if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
            } // End If
          } // End If
          /* _intercod := _codinter */
          _intercod = _codinter;
          /* _intercit := _citinter */
          _intercit = _citinter;
          /* _intercab := _cabinter */
          _intercab = _cabinter;
          /* _interprv := _prvinter */
          _interprv = _prvinter;
          /* xCF := '' */
          xCF = "";
          // * --- Read from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          m_cSql = "";
          m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(xConnes,"C",16,0,m_cServer),m_cServer,xConnes);
          if (m_Ctx.IsSharedTemp("personbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("MACROAGENTE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            xCF = Read_Cursor.GetString("CODFISC");
            _oldmac = Read_Cursor.GetString("MACROAGENTE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on personbo into routine arrt_import_unicredit returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            xCF = "";
            _oldmac = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* cCli1 := xConnes */
          cCli1 = xConnes;
          /* xSOCTCF := '' */
          xSOCTCF = "";
          /* xSOCTCon := '' */
          xSOCTCon = "";
          /* conta := conta + 1 */
          conta = CPLib.Round(conta+1,0);
          /* cFlagLire := '3' */
          cFlagLire = "3";
          /* gMsgImp := 'Sono stati elaborate '+LRTrim(Str(conta,10,0))+' informazioni del file '+LRTrim(w_nomefile) // Messaggio Import */
          gMsgImp = "Sono stati elaborate "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" informazioni del file "+CPLib.LRTrim(w_nomefile);
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* Verifico la presenza dell'_unicode per evitare duplicazioni di informazioni diverse con lo stesso _unicode */
          /* _unicode := '' */
          _unicode = "";
          /* If _xtiprap='D' */
          if (CPLib.eqr(_xtiprap,"D")) {
            /* cInfProg1 := Utilities.GetAutonumber("PRGINFO1\'"+LRTrim(gAzienda)+"'",'',10) */
            cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
            /* cInfProg2 := Utilities.GetAutonumber("PRGINFO2\'"+LRTrim(gAzienda)+"'",'',11) */
            cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
            /* nProgImp := Utilities.GetAutonumber("PRGIMPINF\'"+LRTrim(gAzienda)+"'",0,15) */
            nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINF\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
            // * --- Insert into rapopebo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("rapopebo");
            m_cPhName = m_Ctx.GetPhName("rapopebo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"000002F6")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000002F6(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,9,8),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(xSOCTCF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,9,8)),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cFlagLire,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,9,8)+cInfProg2+"0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,17,16),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intertip,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull("0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull("26","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
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
              /* gMsgProc := gMsgProc +"Rilevati errori nel file "+LRTrim(w_nomefile)+" per l'informazione in data "+CharToDate(Left(riga,8))+" relativa al rapporto: "+Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
              gMsgProc = gMsgProc+"Rilevati errori nel file "+CPLib.LRTrim(w_nomefile)+" per l'informazione in data "+CPLib.CharToDate(CPLib.Left(riga,8))+" relativa al rapporto: "+CPLib.Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              m_cLastMsgError = "";
              /* _esito := 1 */
              _esito = CPLib.Round(1,0);
            } else if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
            /* cMaxRow := 0 */
            cMaxRow = CPLib.Round(0,0);
            /* _nummod := 0 */
            _nummod = CPLib.Round(0,0);
            // * --- Select from intestbo
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            if (Cursor_intestbo!=null)
              Cursor_intestbo.Close();
            Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,17,16),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Substr(riga,17,16))+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM ",m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestbo.Eof())) {
              /* If intestbo->CODINTER=xConnes */
              if (CPLib.eqr(Cursor_intestbo.GetString("CODINTER"),xConnes)) {
                /* _nummod := intestbo->CPROWNUM */
                _nummod = CPLib.Round(Cursor_intestbo.GetDouble("CPROWNUM"),0);
              } // End If
              /* cMaxRow := intestbo->CPROWNUM */
              cMaxRow = CPLib.Round(Cursor_intestbo.GetDouble("CPROWNUM"),0);
              Cursor_intestbo.Next();
            }
            m_cConnectivityError = Cursor_intestbo.ErrorMessage();
            Cursor_intestbo.Close();
            // * --- End Select
            /* If _nummod = 0 */
            if (CPLib.eqr(_nummod,0)) {
              /* nProgImp2 := Utilities.GetAutonumber("PRGIMPSOG\'"+LRTrim(gAzienda)+"'",0,15) */
              nProgImp2 = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPSOG\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
              // * --- Insert into intestbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("intestbo");
              m_cPhName = m_Ctx.GetPhName("intestbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"00000302")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000302(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow+1,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,9,8)),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(xConnes,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,17,16),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,9,8)+cInfProg2+"0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cCli1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp2,"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
                /* gMsgProc := gMsgProc +"Rilevati errori nel file "+LRTrim(w_nomefile)+" per la registrazione dell'intestatario dell'informazione in data "+CharToDate(Left(riga,8))+" relativa al rapporto: "+Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                gMsgProc = gMsgProc+"Rilevati errori nel file "+CPLib.LRTrim(w_nomefile)+" per la registrazione dell'intestatario dell'informazione in data "+CPLib.CharToDate(CPLib.Left(riga,8))+" relativa al rapporto: "+CPLib.Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                m_cLastMsgError = "";
                /* _esito := 1 */
                _esito = CPLib.Round(1,0);
              } else if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
            } else { // Else
              // * --- Write into intestbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("intestbo");
              m_cPhName = m_Ctx.GetPhName("intestbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"00000306")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Left(riga,8)),"D",8,0)+", ";
              m_cSql = m_cSql+"NUMPROG2 = "+CPLib.ToSQL(cInfProg2,"C",11,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,17,16),"?",0,0,m_cServer),m_cServer,CPLib.Substr(riga,17,16))+"";
              m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_nummod,"?",0,0,m_cServer),m_cServer,_nummod)+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_nUpdatedRows = 0;
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.lt(m_nUpdatedRows,1)) {
                // No rows updated
                /* gMsgProc := gMsgProc +"Rilevati errori nel file "+LRTrim(w_nomefile)+" per la registrazione dell'intestatario dell'informazione in data "+CharToDate(Left(riga,8))+" relativa al rapporto: "+Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                gMsgProc = gMsgProc+"Rilevati errori nel file "+CPLib.LRTrim(w_nomefile)+" per la registrazione dell'intestatario dell'informazione in data "+CPLib.CharToDate(CPLib.Left(riga,8))+" relativa al rapporto: "+CPLib.Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                m_cLastMsgError = "";
                /* _esito := 1 */
                _esito = CPLib.Round(1,0);
              } else if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
            } // End If
          } else { // Else
            /* cInfProg1 := Utilities.GetAutonumber("PRGPINFO1\'"+LRTrim(gAzienda)+"'",'',10) */
            cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGPINFO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
            /* cInfProg2 := Utilities.GetAutonumber("PRGPINFO2\'"+LRTrim(gAzienda)+"'",'',11) */
            cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGPINFO2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
            /* nProgImp := Utilities.GetAutonumber("PRGIMPINF\'"+LRTrim(gAzienda)+"'",0,15) */
            nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINF\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
            // * --- Insert into xapopebo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xapopebo");
            m_cPhName = m_Ctx.GetPhName("xapopebo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xapopebo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"0000030D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000030D(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,9,8),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(xSOCTCF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,9,8)),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cFlagLire,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,9,8)+cInfProg2+"0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,17,16),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intertip,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull("0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull("26","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer)+", ";
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
              /* gMsgProc := gMsgProc +"Rilevati errori nel file "+LRTrim(w_nomefile)+" per l'informazione in data "+CharToDate(Left(riga,8))+" relativa al rapporto: "+Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
              gMsgProc = gMsgProc+"Rilevati errori nel file "+CPLib.LRTrim(w_nomefile)+" per l'informazione in data "+CPLib.CharToDate(CPLib.Left(riga,8))+" relativa al rapporto: "+CPLib.Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              m_cLastMsgError = "";
              /* _esito := 1 */
              _esito = CPLib.Round(1,0);
            } else if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
            /* cMaxRow := 0 */
            cMaxRow = CPLib.Round(0,0);
            /* _nummod := 0 */
            _nummod = CPLib.Round(0,0);
            // * --- Select from xntestbo
            m_cServer = m_Ctx.GetServer("xntestbo");
            m_cPhName = m_Ctx.GetPhName("xntestbo");
            if (Cursor_xntestbo!=null)
              Cursor_xntestbo.Close();
            Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,17,16),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Substr(riga,17,16))+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM ",m_cServer,m_Ctx,true));
            while ( ! (Cursor_xntestbo.Eof())) {
              /* If xntestbo->CODINTER=xConnes */
              if (CPLib.eqr(Cursor_xntestbo.GetString("CODINTER"),xConnes)) {
                /* _nummod := xntestbo->CPROWNUM */
                _nummod = CPLib.Round(Cursor_xntestbo.GetDouble("CPROWNUM"),0);
              } // End If
              /* cMaxRow := xntestbo->CPROWNUM */
              cMaxRow = CPLib.Round(Cursor_xntestbo.GetDouble("CPROWNUM"),0);
              Cursor_xntestbo.Next();
            }
            m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
            Cursor_xntestbo.Close();
            // * --- End Select
            /* If _nummod = 0 */
            if (CPLib.eqr(_nummod,0)) {
              /* nProgImp2 := Utilities.GetAutonumber("PRGIMPSOG\'"+LRTrim(gAzienda)+"'",0,15) */
              nProgImp2 = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPSOG\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
              // * --- Insert into xntestbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("xntestbo");
              m_cPhName = m_Ctx.GetPhName("xntestbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xntestbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"00000319")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000319(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow+1,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,9,8)),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(xConnes,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,17,16),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,9,8)+cInfProg2+"0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cCli1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp2,"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
                /* gMsgProc := gMsgProc +"Rilevati errori nel file "+LRTrim(w_nomefile)+" per la registrazione dell'intestatario dell'informazione in data "+CharToDate(Left(riga,8))+" relativa al rapporto: "+Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                gMsgProc = gMsgProc+"Rilevati errori nel file "+CPLib.LRTrim(w_nomefile)+" per la registrazione dell'intestatario dell'informazione in data "+CPLib.CharToDate(CPLib.Left(riga,8))+" relativa al rapporto: "+CPLib.Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                m_cLastMsgError = "";
                /* _esito := 1 */
                _esito = CPLib.Round(1,0);
              } else if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
            } else { // Else
              // * --- Write into xntestbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("xntestbo");
              m_cPhName = m_Ctx.GetPhName("xntestbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xntestbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"0000031D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,9,8)),"D",8,0)+", ";
              m_cSql = m_cSql+"NUMPROG2 = "+CPLib.ToSQL(cInfProg2,"C",11,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xntestbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,17,16),"?",0,0,m_cServer),m_cServer,CPLib.Substr(riga,17,16))+"";
              m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_nummod,"?",0,0,m_cServer),m_cServer,_nummod)+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_nUpdatedRows = 0;
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.lt(m_nUpdatedRows,1)) {
                // No rows updated
                /* gMsgProc := gMsgProc +"Rilevati errori nel file "+LRTrim(w_nomefile)+" per la registrazione dell'intestatario dell'informazione in data "+CharToDate(Left(riga,8))+" relativa al rapporto: "+Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                gMsgProc = gMsgProc+"Rilevati errori nel file "+CPLib.LRTrim(w_nomefile)+" per la registrazione dell'intestatario dell'informazione in data "+CPLib.CharToDate(CPLib.Left(riga,8))+" relativa al rapporto: "+CPLib.Substr(riga,17,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                m_cLastMsgError = "";
                /* _esito := 1 */
                _esito = CPLib.Round(1,0);
              } else if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
            } // End If
          } // End If
        } // End If
      } else { // Else
        /* eProg := Utilities.GetAutonumber("PRGWUCHKUNC\'"+LRTrim(gAzienda)+"'",0,10) */
        eProg = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGWUCHKUNC\\'"+CPLib.LRTrim(gAzienda)+"'",0,10),0);
        /* xCitta := Substr(riga,143,30) */
        xCitta = CPLib.Substr(riga,143,30);
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
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("PROV",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          cPNAS = Read_Cursor.GetString("PROV");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_unicredit returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          cPNAS = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* cSNAS := '' */
        cSNAS = "";
        /* cCNAS := Substr(riga,143,30) */
        cCNAS = CPLib.Substr(riga,143,30);
        /* If (Substr(riga,506,1) = 'Z' or LRTrim(Substr(riga,193,30)) <> 'ITALIA') and Len(LRTrim(xSesso))=1 */
        if ((CPLib.eqr(CPLib.Substr(riga,506,1),"Z") || CPLib.ne(CPLib.LRTrim(CPLib.Substr(riga,193,30)),"ITALIA")) && CPLib.eqr(CPLib.Len(CPLib.LRTrim(xSesso)),1)) {
          /* cSNAS := Substr(riga,193,30) */
          cSNAS = CPLib.Substr(riga,193,30);
          /* cCNAS := '' */
          cCNAS = "";
        } // End If
        /* xProvRes := '' */
        xProvRes = "";
        // * --- Read from tbcitta
        m_cServer = m_Ctx.GetServer("tbcitta");
        m_cPhName = m_Ctx.GetPhName("tbcitta");
        m_cSql = "";
        m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,343,30),"C",60,0,m_cServer),m_cServer,CPLib.Substr(riga,343,30));
        if (m_Ctx.IsSharedTemp("tbcitta")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROV",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          xCodCab = Read_Cursor.GetString("CAB");
          xProvRes = Read_Cursor.GetString("PROV");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_unicredit returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          xCodCab = "";
          xProvRes = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* cSRES := Substr(riga,393,40) */
        cSRES = CPLib.Substr(riga,393,40);
        /* cSRES2 := '' */
        cSRES2 = "";
        // * --- Read from tbstati
        m_cServer = m_Ctx.GetServer("tbstati");
        m_cPhName = m_Ctx.GetPhName("tbstati");
        m_cSql = "";
        m_cSql = m_cSql+"DESCRI="+CPSql.SQLValueAdapter(CPLib.ToSQL(cSRES,"C",40,0,m_cServer),m_cServer,cSRES);
        if (m_Ctx.IsSharedTemp("tbstati")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODSTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          cSRES2 = Read_Cursor.GetString("CODSTA");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_unicredit returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          cSRES2 = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        // * --- Insert into wuchkunicr from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("wuchkunicr");
        m_cPhName = m_Ctx.GetPhName("wuchkunicr");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wuchkunicr",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unicredit",610,"0000032E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000032E(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(eProg,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(w_nomefile),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.Substr(riga,1,8),"00010101")?CPLib.NullDate():CPLib.CharToDate(CPLib.Substr(riga,1,8))),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.Substr(riga,9,8),"00010101")?CPLib.NullDate():CPLib.CharToDate(CPLib.Substr(riga,9,8))),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,17,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,84,25)),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,34,26)),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,343,30),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,443,5),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,243,35),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cCNAS,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cSNAS,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(arfn_fdateR.Make(m_Ctx,this).Run((CPLib.eqr(CPLib.Substr(riga,125,8),"00010101")?CPLib.NullDate():CPLib.CharToDate(CPLib.Substr(riga,135,8)))),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,134,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,543,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,559,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,561,15),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,592,30),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(arfn_fdateR.Make(m_Ctx,this).Run((CPLib.eqr(CPLib.Substr(riga,576,8),"00010101")?CPLib.NullDate():CPLib.CharToDate(CPLib.Substr(riga,576,8)))),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(arfn_fdateR.Make(m_Ctx,this).Run((CPLib.eqr(CPLib.Substr(riga,584,8),"00010101")?CPLib.NullDate():CPLib.CharToDate(CPLib.Substr(riga,584,8)))),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(xProvRes,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,668,25),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,667,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,642,25)),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Chiusura di un rapporto non esistente in Archivio Unico","?",0,0,m_cServer, m_oParameters)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cSRES,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wuchkunicr",true);
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
        /* cNumSca := cNumSca + 1 */
        cNumSca = CPLib.Round(cNumSca+1,0);
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
        if (Cursor_knarapbo!=null)
          Cursor_knarapbo.Close();
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
        if (Cursor_xntestbo!=null)
          Cursor_xntestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_w_tipodest,String p_w_nomefile,String p_w_codmage) {
    w_tipodest = p_w_tipodest;
    w_nomefile = p_w_nomefile;
    w_codmage = p_w_codmage;
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
  public String Run(String p_w_tipodest,String p_w_nomefile,String p_w_codmage) {
    w_tipodest = p_w_tipodest;
    w_nomefile = p_w_nomefile;
    w_codmage = p_w_codmage;
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
  public static arrt_import_unicreditR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_import_unicreditR(p_Ctx, p_Caller);
  }
  public static arrt_import_unicreditR Make(CPContext p_Ctx) {
    return new arrt_import_unicreditR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    w_tipodest = CPLib.Space(1);
    w_nomefile = CPLib.Space(100);
    w_codmage = CPLib.Space(5);
    fhand = CPLib.Space(1);
    riga = "";
    eProg = 0;
    xConnes = CPLib.Space(16);
    _tdest = CPLib.Space(1);
    xCF = CPLib.Space(16);
    xSOCTCon = CPLib.Space(16);
    xSOCTCF = CPLib.Space(16);
    xCodCab = CPLib.Space(6);
    xCitta = CPLib.Space(30);
    cCliProg = CPLib.Space(6);
    cInfProg1 = CPLib.Space(10);
    cInfProg2 = CPLib.Space(11);
    cOpeProg1 = CPLib.Space(10);
    cOpeProg2 = CPLib.Space(11);
    cProgSto = CPLib.Space(15);
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
    cNumChi = 0;
    cNumSca = 0;
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
    cPNAS = CPLib.Space(2);
    cSRES = CPLib.Space(40);
    cSRES2 = CPLib.Space(3);
    _unicode = CPLib.Space(10);
    _salta = 0;
    _allineamento = 0;
    _allineatonomecnome = 0;
    _ragsocold = CPLib.Space(70);
    _cabold = CPLib.Space(6);
    nProgImp = 0;
    nProgImp2 = 0;
    _idbase = CPLib.Space(10);
    _codinter = CPLib.Space(11);
    _citinter = CPLib.Space(30);
    _cabinter = CPLib.Space(6);
    _prvinter = CPLib.Space(2);
    _intercod = CPLib.Space(11);
    _intercit = CPLib.Space(30);
    _intercab = CPLib.Space(6);
    _interprv = CPLib.Space(2);
    _intertip = CPLib.Space(2);
    _tipper = CPLib.Space(1);
    _benrag = CPLib.Space(70);
    _bensta = CPLib.Space(3);
    _bencta = CPLib.Space(30);
    _bencab = CPLib.Space(6);
    _benprv = CPLib.Space(2);
    _benind = CPLib.Space(35);
    _bencap = CPLib.Space(5);
    _oldreg = CPLib.Space(20);
    _idreg = CPLib.Space(20);
    _flagrap2 = CPLib.Space(1);
    xProvRes = CPLib.Space(2);
    _connes = CPLib.Space(16);
    _numrec = 0;
    _nummod = 0;
    _oldmac = CPLib.Space(5);
    _oldrag = CPLib.Space(70);
    _oldcon = CPLib.Space(70);
    _aggcli = 0;
    _nriga = 0;
    _xrapporto = CPLib.Space(25);
    _magecod = CPLib.Space(5);
    ciidbase = CPLib.Space(10);
    cidataini = CPLib.NullDate();
    cidatafine = CPLib.NullDate();
    cicodinter = CPLib.Space(12);
    cinumprog = CPLib.Space(11);
    citiporap = CPLib.Space(1);
    w_xMADESCRI = CPLib.Space(60);
    w_xMADIPSTD = CPLib.Space(6);
    w_xMAFLGBON = CPLib.Space(1);
    w_xMAFLGRAP = CPLib.Space(1);
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_fdate,arfn_fdatetime,arrt_import_unicredit,
  public static final String i_InvokedRoutines = ",arfn_fdate,arfn_fdatetime,arrt_import_unicredit,";
  public static String[] m_cRunParameterNames={"w_tipodest","w_nomefile","w_codmage"};
  protected static String GetFieldsName_000000B3(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RWMACAGE,";
    p_cSql = p_cSql+"RWCODRAP,";
    p_cSql = p_cSql+"RWCODFIS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wurapporti",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000B7(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"PRGIMPRAP,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"MACODICE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"anarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000BB(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"PRGIMPRAP,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"MACODICE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xnarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000C3(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"knarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000E7(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"TIPINTER,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"ALLINEATO,";
    p_cSql = p_cSql+"ALLINEATONOMECNOME,";
    p_cSql = p_cSql+"PROGIMPORT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000ED(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"TELEFONO,";
    p_cSql = p_cSql+"FLGEMAIL,";
    p_cSql = p_cSql+"EMAIL,";
    p_cSql = p_cSql+"FLGBANCA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000104(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"datamodi,";
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
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wersonbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000010D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"TELEFONO,";
    p_cSql = p_cSql+"FLGEMAIL,";
    p_cSql = p_cSql+"EMAIL,";
    p_cSql = p_cSql+"FLGBANCA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000012A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CONNESOPER,";
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
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000136(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"COLLEGAMEN,";
    p_cSql = p_cSql+"PRGIMPSOG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"intestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000141(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CONNESOPER,";
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
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000014D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"COLLEGAMEN,";
    p_cSql = p_cSql+"PRGIMPSOG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xntestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000163(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"WUCODICE,";
    p_cSql = p_cSql+"WUNOMEFILE,";
    p_cSql = p_cSql+"WUDATINI,";
    p_cSql = p_cSql+"WUDATFIN,";
    p_cSql = p_cSql+"WUCODRAP,";
    p_cSql = p_cSql+"WUNOMCLI,";
    p_cSql = p_cSql+"WUCOGCLI,";
    p_cSql = p_cSql+"WUCITCLI,";
    p_cSql = p_cSql+"WUCAPCLI,";
    p_cSql = p_cSql+"WUINDCLI,";
    p_cSql = p_cSql+"WUBCITCLI,";
    p_cSql = p_cSql+"WUBSTACLI,";
    p_cSql = p_cSql+"WUDATNAS,";
    p_cSql = p_cSql+"WUSEXCLI,";
    p_cSql = p_cSql+"WUCODFIS,";
    p_cSql = p_cSql+"WUTDOCCLI,";
    p_cSql = p_cSql+"WUNDOCCLI,";
    p_cSql = p_cSql+"WUADOCRIL,";
    p_cSql = p_cSql+"WURDOCCLI,";
    p_cSql = p_cSql+"WUSDOCCLI,";
    p_cSql = p_cSql+"WUPROVCLI,";
    p_cSql = p_cSql+"WUTELEFONO,";
    p_cSql = p_cSql+"WUFLGMAIL,";
    p_cSql = p_cSql+"WUEMAIL,";
    p_cSql = p_cSql+"WUNOTE,";
    p_cSql = p_cSql+"WUSTACLI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wuchkunicr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001A2(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"datamodi,";
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
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wersonbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001BE(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"TELEFONO,";
    p_cSql = p_cSql+"FLGEMAIL,";
    p_cSql = p_cSql+"EMAIL,";
    p_cSql = p_cSql+"FLGBANCA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001CC(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CONNESOPER,";
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
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001D3(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CONNESOPER,";
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
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001F1(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CONNESOPER,";
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
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001FD(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"COLLEGAMEN,";
    p_cSql = p_cSql+"PRGIMPSOG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"intestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000217(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CONNESOPER,";
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
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000221(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"COLLEGAMEN,";
    p_cSql = p_cSql+"PRGIMPSOG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"intestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000242(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CONNESOPER,";
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
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000024E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"NUMPROG2,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"COLLEGAMEN,";
    p_cSql = p_cSql+"PRGIMPSOG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"intestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000268(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CONNESOPER,";
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
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000272(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"NUMPROG2,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"COLLEGAMEN,";
    p_cSql = p_cSql+"PRGIMPSOG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"intestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000028C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"WUCODICE,";
    p_cSql = p_cSql+"WUNOMEFILE,";
    p_cSql = p_cSql+"WUDATINI,";
    p_cSql = p_cSql+"WUDATFIN,";
    p_cSql = p_cSql+"WUCODRAP,";
    p_cSql = p_cSql+"WUNOMCLI,";
    p_cSql = p_cSql+"WUCOGCLI,";
    p_cSql = p_cSql+"WUCITCLI,";
    p_cSql = p_cSql+"WUCAPCLI,";
    p_cSql = p_cSql+"WUINDCLI,";
    p_cSql = p_cSql+"WUBCITCLI,";
    p_cSql = p_cSql+"WUBSTACLI,";
    p_cSql = p_cSql+"WUDATNAS,";
    p_cSql = p_cSql+"WUSEXCLI,";
    p_cSql = p_cSql+"WUCODFIS,";
    p_cSql = p_cSql+"WUTDOCCLI,";
    p_cSql = p_cSql+"WUNDOCCLI,";
    p_cSql = p_cSql+"WUADOCRIL,";
    p_cSql = p_cSql+"WURDOCCLI,";
    p_cSql = p_cSql+"WUSDOCCLI,";
    p_cSql = p_cSql+"WUPROVCLI,";
    p_cSql = p_cSql+"WUTELEFONO,";
    p_cSql = p_cSql+"WUFLGMAIL,";
    p_cSql = p_cSql+"WUEMAIL,";
    p_cSql = p_cSql+"WUNOTE,";
    p_cSql = p_cSql+"WUSTACLI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wuchkunicr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002BD(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"datamodi,";
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
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wersonbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002D9(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"TELEFONO,";
    p_cSql = p_cSql+"FLGEMAIL,";
    p_cSql = p_cSql+"EMAIL,";
    p_cSql = p_cSql+"FLGBANCA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002F6(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CONNESOPER,";
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
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000302(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"NUMPROG2,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"COLLEGAMEN,";
    p_cSql = p_cSql+"PRGIMPSOG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"intestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000030D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CONNESOPER,";
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
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000319(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"NUMPROG2,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"COLLEGAMEN,";
    p_cSql = p_cSql+"PRGIMPSOG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xntestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000032E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"WUCODICE,";
    p_cSql = p_cSql+"WUNOMEFILE,";
    p_cSql = p_cSql+"WUDATINI,";
    p_cSql = p_cSql+"WUDATFIN,";
    p_cSql = p_cSql+"WUCODRAP,";
    p_cSql = p_cSql+"WUNOMCLI,";
    p_cSql = p_cSql+"WUCOGCLI,";
    p_cSql = p_cSql+"WUCITCLI,";
    p_cSql = p_cSql+"WUCAPCLI,";
    p_cSql = p_cSql+"WUINDCLI,";
    p_cSql = p_cSql+"WUBCITCLI,";
    p_cSql = p_cSql+"WUBSTACLI,";
    p_cSql = p_cSql+"WUDATNAS,";
    p_cSql = p_cSql+"WUSEXCLI,";
    p_cSql = p_cSql+"WUCODFIS,";
    p_cSql = p_cSql+"WUTDOCCLI,";
    p_cSql = p_cSql+"WUNDOCCLI,";
    p_cSql = p_cSql+"WUADOCRIL,";
    p_cSql = p_cSql+"WURDOCCLI,";
    p_cSql = p_cSql+"WUSDOCCLI,";
    p_cSql = p_cSql+"WUPROVCLI,";
    p_cSql = p_cSql+"WUTELEFONO,";
    p_cSql = p_cSql+"WUFLGMAIL,";
    p_cSql = p_cSql+"WUEMAIL,";
    p_cSql = p_cSql+"WUNOTE,";
    p_cSql = p_cSql+"WUSTACLI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wuchkunicr",true);
    return p_cSql;
  }
}
