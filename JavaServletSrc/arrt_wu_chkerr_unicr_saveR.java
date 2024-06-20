// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_wu_chkerr_unicr_saveR implements CallerWithObjs {
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
  public String m_cPhName_wuchkunicr;
  public String m_cServer_wuchkunicr;
  public String m_cPhName_knarapbo;
  public String m_cServer_knarapbo;
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_xnarapbo;
  public String m_cServer_xnarapbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public String m_cPhName_personbo_agg;
  public String m_cServer_personbo_agg;
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_xapopebo;
  public String m_cServer_xapopebo;
  public String m_cPhName_xntestbo;
  public String m_cServer_xntestbo;
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
  public String w_WUCODICE;
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
  public String _intertip;
  public double _errore;
  public String _intercod;
  public String _intercit;
  public String _intercab;
  public String _interprv;
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
  public double _aggcli;
  public java.sql.Date dNas;
  public java.sql.Date dDoc;
  public java.sql.Date dSca;
  public java.sql.Date dIni;
  public java.sql.Date dFin;
  public String gAzienda;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_wu_chkerr_unicr_saveR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_wu_chkerr_unicr_save",m_Caller);
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_wuchkunicr = p_ContextObject.GetPhName("wuchkunicr");
    if (m_cPhName_wuchkunicr.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wuchkunicr = m_cPhName_wuchkunicr+" "+m_Ctx.GetWritePhName("wuchkunicr");
    }
    m_cServer_wuchkunicr = p_ContextObject.GetServer("wuchkunicr");
    m_cPhName_knarapbo = p_ContextObject.GetPhName("knarapbo");
    if (m_cPhName_knarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_knarapbo = m_cPhName_knarapbo+" "+m_Ctx.GetWritePhName("knarapbo");
    }
    m_cServer_knarapbo = p_ContextObject.GetServer("knarapbo");
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    if (m_cPhName_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anarapbo = m_cPhName_anarapbo+" "+m_Ctx.GetWritePhName("anarapbo");
    }
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_xnarapbo = p_ContextObject.GetPhName("xnarapbo");
    if (m_cPhName_xnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xnarapbo = m_cPhName_xnarapbo+" "+m_Ctx.GetWritePhName("xnarapbo");
    }
    m_cServer_xnarapbo = p_ContextObject.GetServer("xnarapbo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
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
    m_cPhName_personbo_agg = p_ContextObject.GetPhName("personbo_agg");
    if (m_cPhName_personbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo_agg = m_cPhName_personbo_agg+" "+m_Ctx.GetWritePhName("personbo_agg");
    }
    m_cServer_personbo_agg = p_ContextObject.GetServer("personbo_agg");
    m_cPhName_wersonbo = p_ContextObject.GetPhName("wersonbo");
    if (m_cPhName_wersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo = m_cPhName_wersonbo+" "+m_Ctx.GetWritePhName("wersonbo");
    }
    m_cServer_wersonbo = p_ContextObject.GetServer("wersonbo");
    m_cPhName_rapopebo = p_ContextObject.GetPhName("rapopebo");
    if (m_cPhName_rapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapopebo = m_cPhName_rapopebo+" "+m_Ctx.GetWritePhName("rapopebo");
    }
    m_cServer_rapopebo = p_ContextObject.GetServer("rapopebo");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_xapopebo = p_ContextObject.GetPhName("xapopebo");
    if (m_cPhName_xapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xapopebo = m_cPhName_xapopebo+" "+m_Ctx.GetWritePhName("xapopebo");
    }
    m_cServer_xapopebo = p_ContextObject.GetServer("xapopebo");
    m_cPhName_xntestbo = p_ContextObject.GetPhName("xntestbo");
    if (m_cPhName_xntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xntestbo = m_cPhName_xntestbo+" "+m_Ctx.GetWritePhName("xntestbo");
    }
    m_cServer_xntestbo = p_ContextObject.GetServer("xntestbo");
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
    if (CPLib.eqr("_errore",p_cVarName)) {
      return _errore;
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
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_wu_chkerr_unicr_save";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("WUCODICE",p_cVarName)) {
      return w_WUCODICE;
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
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("dNas",p_cVarName)) {
      return dNas;
    }
    if (CPLib.eqr("dDoc",p_cVarName)) {
      return dDoc;
    }
    if (CPLib.eqr("dSca",p_cVarName)) {
      return dSca;
    }
    if (CPLib.eqr("dIni",p_cVarName)) {
      return dIni;
    }
    if (CPLib.eqr("dFin",p_cVarName)) {
      return dFin;
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
    if (CPLib.eqr("_errore",p_cVarName)) {
      _errore = value;
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("WUCODICE",p_cVarName)) {
      w_WUCODICE = value;
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
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("dNas",p_cVarName)) {
      dNas = value;
      return;
    }
    if (CPLib.eqr("dDoc",p_cVarName)) {
      dDoc = value;
      return;
    }
    if (CPLib.eqr("dSca",p_cVarName)) {
      dSca = value;
      return;
    }
    if (CPLib.eqr("dIni",p_cVarName)) {
      dIni = value;
      return;
    }
    if (CPLib.eqr("dFin",p_cVarName)) {
      dFin = value;
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
    CPResultSet Cursor_wuchkunicr=null;
    try {
      /* w_WUCODICE Char(10) */
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
      /* _intertip Char(2) */
      /* _errore Numeric(1, 0) */
      /* _intercod Char(11) */
      /* _intercit Char(30) */
      /* _intercab Char(6) */
      /* _interprv Char(2) */
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
      /* _aggcli Numeric(1, 0) */
      /* dNas Date */
      /* dDoc Date */
      /* dSca Date */
      /* dIni Date */
      /* dFin Date */
      /* gAzienda Char(10) // Azienda */
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
      /* Legge il record e lo elabora */
      // * --- Select from wuchkunicr
      m_cServer = m_Ctx.GetServer("wuchkunicr");
      m_cPhName = m_Ctx.GetPhName("wuchkunicr");
      if (Cursor_wuchkunicr!=null)
        Cursor_wuchkunicr.Close();
      Cursor_wuchkunicr = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select WUFLGALL,WUFLGFRC,WUTIPOPE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"WUCODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_WUCODICE,"?",0,0,m_cServer, m_oParameters),m_cServer,w_WUCODICE)+" "+")"+(m_Ctx.IsSharedTemp("wuchkunicr")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_wuchkunicr.Eof())) {
        /* If wuchkunicr->WUFLGALL='S' or (wuchkunicr->WUFLGALL='N' and wuchkunicr->WUFLGFRC='S') */
        if (CPLib.eqr(Cursor_wuchkunicr.GetString("WUFLGALL"),"S") || (CPLib.eqr(Cursor_wuchkunicr.GetString("WUFLGALL"),"N") && CPLib.eqr(Cursor_wuchkunicr.GetString("WUFLGFRC"),"S"))) {
          /* _errore := 0 */
          _errore = CPLib.Round(0,0);
          /* If wuchkunicr->WUTIPOPE='1' */
          if (CPLib.eqr(Cursor_wuchkunicr.GetString("WUTIPOPE"),"1")) {
            /* Exec "Nuovo Rapporto" Page 2:Page_2 */
            Page_2();
            /* ElseIf wuchkunicr->WUTIPOPE='2' */
          } else if (CPLib.eqr(Cursor_wuchkunicr.GetString("WUTIPOPE"),"2")) {
            /* Exec "Aggiornamento Rapporto" Page 3:Page_3 */
            Page_3();
            /* ElseIf wuchkunicr->WUTIPOPE='3' */
          } else if (CPLib.eqr(Cursor_wuchkunicr.GetString("WUTIPOPE"),"3")) {
            /* Exec "Chiusura Rapporto" Page 4:Page_4 */
            Page_4();
          } // End If
          /* If _errore=0 */
          if (CPLib.eqr(_errore,0)) {
            // * --- Delete from wuchkunicr
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("wuchkunicr");
            m_cPhName = m_Ctx.GetPhName("wuchkunicr");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wuchkunicr",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_chkerr_unicr_save",22,"00000065")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"WUCODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_WUCODICE,"?",0,0,m_cServer),m_cServer,w_WUCODICE)+"";
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
            // * --- Write into wuchkunicr from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("wuchkunicr");
            m_cPhName = m_Ctx.GetPhName("wuchkunicr");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wuchkunicr",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_chkerr_unicr_save",22,"00000066")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"WUFLGALL = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"WUFLGFRC = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"wuchkunicr",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"WUCODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_WUCODICE,"?",0,0,m_cServer),m_cServer,w_WUCODICE)+"";
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
        Cursor_wuchkunicr.Next();
      }
      m_cConnectivityError = Cursor_wuchkunicr.ErrorMessage();
      Cursor_wuchkunicr.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wuchkunicr!=null)
          Cursor_wuchkunicr.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_wuchkunicr=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_xntestbo=null;
    try {
      /* Nuovo Rapporto */
      /* _xrapporto Char(25) */
      String _xrapporto;
      _xrapporto = CPLib.Space(25);
      /* Verifica Esistenza Rapporto */
      // * --- Select from wuchkunicr
      m_cServer = m_Ctx.GetServer("wuchkunicr");
      m_cPhName = m_Ctx.GetPhName("wuchkunicr");
      if (Cursor_wuchkunicr!=null)
        Cursor_wuchkunicr.Close();
      Cursor_wuchkunicr = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"WUCODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_WUCODICE,"?",0,0,m_cServer, m_oParameters),m_cServer,w_WUCODICE)+" "+")"+(m_Ctx.IsSharedTemp("wuchkunicr")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_wuchkunicr.Eof())) {
        /* _xrapporto := '' */
        _xrapporto = "";
        // * --- Read from knarapbo
        m_cServer = m_Ctx.GetServer("knarapbo");
        m_cPhName = m_Ctx.GetPhName("knarapbo");
        m_cSql = "";
        m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODRAP"),"C",25,0,m_cServer),m_cServer,Cursor_wuchkunicr.GetString("WUCODRAP"));
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
            Error l_oErrorFault = new Error("Read on knarapbo into routine arrt_wu_chkerr_unicr_save returns two or more records. This item should return only a record.");
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
          /* nProgImp := Utilities.GetAutonumber("PRGIMPRAP\'"+LRTrim(gAzienda)+"'",0,15) */
          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPRAP\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
          // * --- Insert into xnarapbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xnarapbo");
          m_cPhName = m_Ctx.GetPhName("xnarapbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xnarapbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_chkerr_unicr_save",22,"00000070")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000070(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUCOGCLI"))+" "+CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNOMCLI")),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("E","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull("242","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("99","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODMAGE"),"?",0,0,m_cServer)+", ";
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
          // * --- Insert into knarapbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("knarapbo");
          m_cPhName = m_Ctx.GetPhName("knarapbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"knarapbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_chkerr_unicr_save",22,"00000071")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000071(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUCOGCLI"))+" "+CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNOMCLI")),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("P","?",0,0,m_cServer)+", ";
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
          /* _oldmac := '' */
          _oldmac = "";
          /* cSRES := '' */
          cSRES = "";
          /* cSRES2 := '' */
          cSRES2 = "";
          /* xCF := '' */
          xCF = "";
          /* dNas := CharToDate(Right(wuchkunicr->WUDATNAS,4)+Substr(wuchkunicr->WUDATNAS,4,2)+Left(wuchkunicr->WUDATNAS,2)) */
          dNas = CPLib.CharToDate(CPLib.Right(Cursor_wuchkunicr.GetString("WUDATNAS"),4)+CPLib.Substr(Cursor_wuchkunicr.GetString("WUDATNAS"),4,2)+CPLib.Left(Cursor_wuchkunicr.GetString("WUDATNAS"),2));
          /* dDoc := CharToDate(Right(wuchkunicr->WURDOCCLI,4)+Substr(wuchkunicr->WURDOCCLI,4,2)+Left(wuchkunicr->WURDOCCLI,2)) */
          dDoc = CPLib.CharToDate(CPLib.Right(Cursor_wuchkunicr.GetString("WURDOCCLI"),4)+CPLib.Substr(Cursor_wuchkunicr.GetString("WURDOCCLI"),4,2)+CPLib.Left(Cursor_wuchkunicr.GetString("WURDOCCLI"),2));
          /* dSca := CharToDate(Right(wuchkunicr->WUSDOCCLI,4)+Substr(wuchkunicr->WUSDOCCLI,4,2)+Left(wuchkunicr->WUSDOCCLI,2)) */
          dSca = CPLib.CharToDate(CPLib.Right(Cursor_wuchkunicr.GetString("WUSDOCCLI"),4)+CPLib.Substr(Cursor_wuchkunicr.GetString("WUSDOCCLI"),4,2)+CPLib.Left(Cursor_wuchkunicr.GetString("WUSDOCCLI"),2));
          // * --- Read from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          m_cSql = "";
          m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNCODFIS")))?Cursor_wuchkunicr.GetString("WUCODFIS"):Cursor_wuchkunicr.GetString("WUNCODFIS")),"C",16,0,m_cServer),m_cServer,(CPLib.Empty(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNCODFIS")))?Cursor_wuchkunicr.GetString("WUCODFIS"):Cursor_wuchkunicr.GetString("WUNCODFIS")));
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
              Error l_oErrorFault = new Error("Read on personbo into routine arrt_wu_chkerr_unicr_save returns two or more records. This item should return only a record.");
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
          /* If not(Empty(wuchkunicr->WUNSEXCLI)) */
          if ( ! (CPLib.Empty(Cursor_wuchkunicr.GetString("WUNSEXCLI")))) {
            /* xSesso := iif(wuchkunicr->WUNSEXCLI='M','1',iif(wuchkunicr->WUNSEXCLI='F','2',wuchkunicr->WUNSEXCLI)) */
            xSesso = (CPLib.eqr(Cursor_wuchkunicr.GetString("WUNSEXCLI"),"M")?"1":(CPLib.eqr(Cursor_wuchkunicr.GetString("WUNSEXCLI"),"F")?"2":Cursor_wuchkunicr.GetString("WUNSEXCLI")));
          } else { // Else
            /* xSesso := iif(wuchkunicr->WUSEXCLI='M','1',iif(wuchkunicr->WUSEXCLI='F','2',wuchkunicr->WUSEXCLI)) */
            xSesso = (CPLib.eqr(Cursor_wuchkunicr.GetString("WUSEXCLI"),"M")?"1":(CPLib.eqr(Cursor_wuchkunicr.GetString("WUSEXCLI"),"F")?"2":Cursor_wuchkunicr.GetString("WUSEXCLI")));
          } // End If
          /* xCitta := iif(Empty(LRTrim(wuchkunicr->WUNBCITCLI)),wuchkunicr->WUBCITCLI,wuchkunicr->WUNBCITCLI) */
          xCitta = (CPLib.Empty(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNBCITCLI")))?Cursor_wuchkunicr.GetString("WUBCITCLI"):Cursor_wuchkunicr.GetString("WUNBCITCLI"));
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
              Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_wu_chkerr_unicr_save returns two or more records. This item should return only a record.");
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
          /* cCNAS := iif(Empty(LRTrim(wuchkunicr->WUNBCITCLI)),wuchkunicr->WUBCITCLI,wuchkunicr->WUNBCITCLI) */
          cCNAS = (CPLib.Empty(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNBCITCLI")))?Cursor_wuchkunicr.GetString("WUBCITCLI"):Cursor_wuchkunicr.GetString("WUNBCITCLI"));
          /* If Substr(wuchkunicr->WUCODFIS,12,1) = 'Z' and Len(LRTrim(xSesso))=1 */
          if (CPLib.eqr(CPLib.Substr(Cursor_wuchkunicr.GetString("WUCODFIS"),12,1),"Z") && CPLib.eqr(CPLib.Len(CPLib.LRTrim(xSesso)),1)) {
            /* cPNAS := 'EE' */
            cPNAS = "EE";
            /* cSNAS := iif(Empty(LRTrim(wuchkunicr->WUNBCITCLI)),wuchkunicr->WUBSTACLI,wuchkunicr->WUNBSTACLI) */
            cSNAS = (CPLib.Empty(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNBCITCLI")))?Cursor_wuchkunicr.GetString("WUBSTACLI"):Cursor_wuchkunicr.GetString("WUNBSTACLI"));
            /* cCNAS := '' */
            cCNAS = "";
          } // End If
          /* xProvRes := '' */
          xProvRes = "";
          // * --- Read from tbcitta
          m_cServer = m_Ctx.GetServer("tbcitta");
          m_cPhName = m_Ctx.GetPhName("tbcitta");
          m_cSql = "";
          m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNCITCLI")))?Cursor_wuchkunicr.GetString("WUCITCLI"):Cursor_wuchkunicr.GetString("WUNCITCLI")),"C",60,0,m_cServer),m_cServer,(CPLib.Empty(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNCITCLI")))?Cursor_wuchkunicr.GetString("WUCITCLI"):Cursor_wuchkunicr.GetString("WUNCITCLI")));
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
              Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_wu_chkerr_unicr_save returns two or more records. This item should return only a record.");
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
          /* cSRES := Left(wuchkunicr->WUSTACLI,40) */
          cSRES = CPLib.Left(Cursor_wuchkunicr.GetString("WUSTACLI"),40);
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
              Error l_oErrorFault = new Error("Read on tbstati into routine arrt_wu_chkerr_unicr_save returns two or more records. This item should return only a record.");
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
          /* If Empty(LRTrim(xCF)) */
          if (CPLib.Empty(CPLib.LRTrim(xCF))) {
            /* xCF := wuchkunicr->WUCODFIS */
            xCF = Cursor_wuchkunicr.GetString("WUCODFIS");
            /* nProgImp := Utilities.GetAutonumber("PRGIMPOCLI\'"+LRTrim(gAzienda)+"'",0,15) */
            nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOCLI\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
            // * --- Insert into personbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_chkerr_unicr_save",22,"0000008F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000008F(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(xCF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(xCodCab,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUCOGCLI"))+" "+CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNOMCLI")),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_wuchkunicr.GetString("WUINDCLI"),35),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(xCF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(dNas)?dNas:Cursor_wuchkunicr.GetDate("WUNDATNAS")),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cCNAS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("600","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("600","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNTDOCCLI")))?Cursor_wuchkunicr.GetString("WUTDOCCLI"):Cursor_wuchkunicr.GetString("WUNTDOCCLI")),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNDOCCLI")),15),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(dDoc)?dDoc:Cursor_wuchkunicr.GetDate("WUNRDOCCLI")),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUADOCRIL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNCITCLI")))?Cursor_wuchkunicr.GetString("WUCITCLI"):Cursor_wuchkunicr.GetString("WUNCITCLI")),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(xProvRes,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNCAPCLI")))?Cursor_wuchkunicr.GetString("WUCAPCLI"):Cursor_wuchkunicr.GetString("WUNCAPCLI")),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(xSesso,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cSRES2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(dSca)?dSca:Cursor_wuchkunicr.GetDate("WUNSDOCCLI")),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_tipper,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_wuchkunicr.GetString("WUCOGCLI"),26),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_wuchkunicr.GetString("WUNOMCLI"),25),"?",0,0,m_cServer)+", ";
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
              m_Sql.AbortTransaction();
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
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
              m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_chkerr_unicr_save",22,"00000091")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000091(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODFIS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUEMAIL"),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUFLGMAIL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUTELEFONO"),"?",0,0,m_cServer)+", ";
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
            } // End If
          } else { // Else
            /* _aggcli := 0 */
            _aggcli = CPLib.Round(0,0);
            /* Case LRTrim(wuchkunicr->WUCODMAGE)='COSTA' */
            if (CPLib.eqr(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUCODMAGE")),"COSTA")) {
              /* _aggcli := 1 */
              _aggcli = CPLib.Round(1,0);
              /* Case wuchkunicr->WUCODMAGE='FININ' */
            } else if (CPLib.eqr(Cursor_wuchkunicr.GetString("WUCODMAGE"),"FININ")) {
              /* If _oldmac <> 'COSTA' */
              if (CPLib.ne(_oldmac,"COSTA")) {
                /* _aggcli := 1 */
                _aggcli = CPLib.Round(1,0);
              } // End If
              /* Case wuchkunicr->WUCODMAGE='BCAUC' */
            } else if (CPLib.eqr(Cursor_wuchkunicr.GetString("WUCODMAGE"),"BCAUC")) {
              /* If _oldmac <> 'COSTA' and _oldmac <> 'FININ' */
              if (CPLib.ne(_oldmac,"COSTA") && CPLib.ne(_oldmac,"FININ")) {
                /* _aggcli := 1 */
                _aggcli = CPLib.Round(1,0);
              } // End If
              /* Case wuchkunicr->WUCODMAGE='BCISP' */
            } else if (CPLib.eqr(Cursor_wuchkunicr.GetString("WUCODMAGE"),"BCISP")) {
              /* If _oldmac <> 'COSTA' and _oldmac <> 'FININ' and _oldmac <> 'BCAUC' */
              if (CPLib.ne(_oldmac,"COSTA") && CPLib.ne(_oldmac,"FININ") && CPLib.ne(_oldmac,"BCAUC")) {
                /* _aggcli := 1 */
                _aggcli = CPLib.Round(1,0);
              } // End If
              /* Case wuchkunicr->WUCODMAGE='BCASS' or LRTrim(wuchkunicr->WUCODMAGE)='E998' or LRTrim(wuchkunicr->WUCODMAGE)='EBDSS' or LRTrim(wuchkunicr->WUCODMAGE)='I999' */
            } else if (CPLib.eqr(Cursor_wuchkunicr.GetString("WUCODMAGE"),"BCASS") || CPLib.eqr(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUCODMAGE")),"E998") || CPLib.eqr(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUCODMAGE")),"EBDSS") || CPLib.eqr(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUCODMAGE")),"I999")) {
              /* If _oldmac <> 'COSTA' and _oldmac <> 'FININ' and _oldmac <> 'BCAUC' and _oldmac <> 'BCISP' */
              if (CPLib.ne(_oldmac,"COSTA") && CPLib.ne(_oldmac,"FININ") && CPLib.ne(_oldmac,"BCAUC") && CPLib.ne(_oldmac,"BCISP")) {
                /* _aggcli := 1 */
                _aggcli = CPLib.Round(1,0);
              } // End If
              /* Case wuchkunicr->WUCODMAGE='DHLSP' */
            } else if (CPLib.eqr(Cursor_wuchkunicr.GetString("WUCODMAGE"),"DHLSP")) {
              /* If _oldmac = 'TRAVX' or _oldmac='DHLSP' */
              if (CPLib.eqr(_oldmac,"TRAVX") || CPLib.eqr(_oldmac,"DHLSP")) {
                /* _aggcli := 1 */
                _aggcli = CPLib.Round(1,0);
              } // End If
              /* Case wuchkunicr->WUCODMAGE='TRAVX' */
            } else if (CPLib.eqr(Cursor_wuchkunicr.GetString("WUCODMAGE"),"TRAVX")) {
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
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODFIS"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                // * --- Insert into wersonbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("wersonbo");
                m_cPhName = m_Ctx.GetPhName("wersonbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_chkerr_unicr_save",22,"000000A4")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000000A4(m_Ctx,m_oWrInfo);
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
              m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_chkerr_unicr_save",22,"000000A5")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(xCodCab,"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUCOGCLI"))+" "+CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNOMCLI")),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(CPLib.Left(Cursor_wuchkunicr.GetString("WUINDCLI"),35),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(xCF,"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL((CPLib.Empty(dNas)?dNas:Cursor_wuchkunicr.GetDate("WUNDATNAS")),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(cCNAS,"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL("600","C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL("","C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL("600","C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNTDOCCLI")))?Cursor_wuchkunicr.GetString("WUTDOCCLI"):Cursor_wuchkunicr.GetString("WUNTDOCCLI")),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNDOCCLI")),15),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL((CPLib.Empty(dDoc)?dDoc:Cursor_wuchkunicr.GetDate("WUNRDOCCLI")),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUADOCRIL"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNCITCLI")))?Cursor_wuchkunicr.GetString("WUCITCLI"):Cursor_wuchkunicr.GetString("WUNCITCLI")),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(xProvRes,"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNCAPCLI")))?Cursor_wuchkunicr.GetString("WUCAPCLI"):Cursor_wuchkunicr.GetString("WUNCAPCLI")),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(xSesso,"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(cSRES2,"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATAVALI = "+CPLib.ToSQL((CPLib.Empty(dSca)?dSca:Cursor_wuchkunicr.GetDate("WUNSDOCCLI")),"D",8,0)+", ";
              m_cSql = m_cSql+"TIPOPERS = "+CPLib.ToSQL(_tipper,"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(CPLib.Left(Cursor_wuchkunicr.GetString("WUCOGCLI"),26),"C",26,0,m_cServer)+", ";
              m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(CPLib.Left(Cursor_wuchkunicr.GetString("WUNOMCLI"),25),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(cPNAS,"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(cSNAS,"C",30,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODFIS"),"?",0,0,m_cServer),m_cServer,Cursor_wuchkunicr.GetString("WUCODFIS"))+"";
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
              /* _connes := '' */
              _connes = "";
              // * --- Read from personbo_agg
              m_cServer = m_Ctx.GetServer("personbo_agg");
              m_cPhName = m_Ctx.GetPhName("personbo_agg");
              m_cSql = "";
              m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODFIS"),"C",16,0,m_cServer),m_cServer,Cursor_wuchkunicr.GetString("WUCODFIS"));
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
                  Error l_oErrorFault = new Error("Read on personbo_agg into routine arrt_wu_chkerr_unicr_save returns two or more records. This item should return only a record.");
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
                m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_chkerr_unicr_save",22,"000000A9")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000000A9(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODFIS"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUEMAIL"),"?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUFLGMAIL"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUTELEFONO"),"?",0,0,m_cServer)+", ";
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
                m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_chkerr_unicr_save",22,"000000AA")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"EMAIL = "+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUEMAIL"),"M",10,0,m_cServer,m_oParameters)+", ";
                m_cSql = m_cSql+"FLGEMAIL = "+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUFLGMAIL"),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"TELEFONO = "+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUTELEFONO"),"C",50,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo_agg",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODFIS"),"?",0,0,m_cServer),m_cServer,Cursor_wuchkunicr.GetString("WUCODFIS"))+"";
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
          /* _intercod := _codinter */
          _intercod = _codinter;
          /* _intercit := _citinter */
          _intercit = _citinter;
          /* _intercab := _cabinter */
          _intercab = _cabinter;
          /* _interprv := _prvinter */
          _interprv = _prvinter;
          /* xConnes := wuchkunicr->WUCODFIS */
          xConnes = Cursor_wuchkunicr.GetString("WUCODFIS");
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
          /* _unicode := '' */
          _unicode = "";
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
          m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_chkerr_unicr_save",22,"000000BC")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000000BC(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_wuchkunicr.GetDate("WUNDATINI"))?CPLib.DateToChar(Cursor_wuchkunicr.GetDate("WUDATINI")):CPLib.DateToChar(Cursor_wuchkunicr.GetDate("WUNDATINI"))),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(xSOCTCF,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_wuchkunicr.GetDate("WUNDATINI"))?Cursor_wuchkunicr.GetDate("WUDATINI"):Cursor_wuchkunicr.GetDate("WUNDATINI")),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cFlagLire,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_wuchkunicr.GetDate("WUNDATINI"))?CPLib.DateToChar(Cursor_wuchkunicr.GetDate("WUDATINI")):CPLib.DateToChar(Cursor_wuchkunicr.GetDate("WUNDATINI")))+cInfProg2+"0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODFIS"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intertip,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull("23","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xapopebo",true);
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
          /* cMaxRow := 0 */
          cMaxRow = CPLib.Round(0,0);
          /* _nummod := 0 */
          _nummod = CPLib.Round(0,0);
          // * --- Select from xntestbo
          m_cServer = m_Ctx.GetServer("xntestbo");
          m_cPhName = m_Ctx.GetPhName("xntestbo");
          if (Cursor_xntestbo!=null)
            Cursor_xntestbo.Close();
          Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODFIS"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM ",m_cServer,m_Ctx,true));
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
            m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_chkerr_unicr_save",22,"000000C5")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000C5(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow+1,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_wuchkunicr.GetDate("WUNDATINI"))?Cursor_wuchkunicr.GetDate("WUDATINI"):Cursor_wuchkunicr.GetDate("WUNDATINI")),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(cCli1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODFIS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_wuchkunicr.GetDate("WUNDATINI"))?CPLib.DateToChar(Cursor_wuchkunicr.GetDate("WUDATINI")):CPLib.DateToChar(Cursor_wuchkunicr.GetDate("WUNDATINI")))+cInfProg2+"0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cCli1,"?",0,0,m_cServer)+", ";
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
            // * --- Write into intestbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_chkerr_unicr_save",22,"000000C6")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"DATAINI = "+CPLib.ToSQL(dIni,"D",8,0)+", ";
            m_cSql = m_cSql+"NUMPROG1 = "+CPLib.ToSQL(cInfProg2,"C",11,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODFIS"),"?",0,0,m_cServer),m_cServer,Cursor_wuchkunicr.GetString("WUCODFIS"))+"";
            m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_nummod,"?",0,0,m_cServer),m_cServer,_nummod)+"";
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
          /* _errore := 1 */
          _errore = CPLib.Round(1,0);
        } // End If
        Cursor_wuchkunicr.Next();
      }
      m_cConnectivityError = Cursor_wuchkunicr.ErrorMessage();
      Cursor_wuchkunicr.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_wuchkunicr!=null)
          Cursor_wuchkunicr.Close();
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
    CPResultSet Cursor_wuchkunicr=null;
    CPResultSet Cursor_knarapbo=null;
    CPResultSet Cursor_rapopebo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_intestbo=null;
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
      /* _errmod := 'N' */
      _errmod = "N";
      // * --- Select from wuchkunicr
      m_cServer = m_Ctx.GetServer("wuchkunicr");
      m_cPhName = m_Ctx.GetPhName("wuchkunicr");
      if (Cursor_wuchkunicr!=null)
        Cursor_wuchkunicr.Close();
      Cursor_wuchkunicr = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"WUCODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_WUCODICE,"?",0,0,m_cServer, m_oParameters),m_cServer,w_WUCODICE)+" "+")"+(m_Ctx.IsSharedTemp("wuchkunicr")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_wuchkunicr.Eof())) {
        /* _xrapmod := '' */
        _xrapmod = "";
        /* _xtipmod := '' */
        _xtipmod = "";
        /* _errmsg := '' */
        _errmsg = "";
        // * --- Select from knarapbo
        m_cServer = m_Ctx.GetServer("knarapbo");
        m_cPhName = m_Ctx.GetPhName("knarapbo");
        if (Cursor_knarapbo!=null)
          Cursor_knarapbo.Close();
        Cursor_knarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODRAP"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("knarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
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
          // * --- Select from rapopebo
          m_cServer = m_Ctx.GetServer("rapopebo");
          m_cPhName = m_Ctx.GetPhName("rapopebo");
          if (Cursor_rapopebo!=null)
            Cursor_rapopebo.Close();
          Cursor_rapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODFIS"),"?",0,0)+"  and  TIPOOPRAP='23' "+")"+(m_Ctx.IsSharedTemp("rapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_rapopebo.Eof())) {
            /* _datini := rapopebo->DATAOPE */
            _datini = Cursor_rapopebo.GetDate("DATAOPE");
            Cursor_rapopebo.Next();
          }
          m_cConnectivityError = Cursor_rapopebo.ErrorMessage();
          Cursor_rapopebo.Close();
          // * --- End Select
          /* Aggiornamento Rapporto */
          /* If wuchkunicr->WUDATINI = _datini */
          if (CPLib.eqr(Cursor_wuchkunicr.GetDate("WUDATINI"),_datini)) {
            /* dIni := iif(Empty(wuchkunicr->WUNDATINI),wuchkunicr->WUDATINI,wuchkunicr->WUNDATINI) */
            dIni = (CPLib.Empty(Cursor_wuchkunicr.GetDate("WUNDATINI"))?Cursor_wuchkunicr.GetDate("WUDATINI"):Cursor_wuchkunicr.GetDate("WUNDATINI"));
            /* dFin := iif(Empty(wuchkunicr->WUNDATFIN),wuchkunicr->WUDATFIN,wuchkunicr->WUNDATFIN) */
            dFin = (CPLib.Empty(Cursor_wuchkunicr.GetDate("WUNDATFIN"))?Cursor_wuchkunicr.GetDate("WUDATFIN"):Cursor_wuchkunicr.GetDate("WUNDATFIN"));
            // * --- Write into anarapbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("anarapbo");
            m_cPhName = m_Ctx.GetPhName("anarapbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anarapbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_chkerr_unicr_save",22,"000000E0")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"DESCRAP = "+CPLib.ToSQL(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUCOGCLI"))+" "+CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNOMCLI")),"C",50,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"anarapbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODFIS"),"?",0,0,m_cServer),m_cServer,Cursor_wuchkunicr.GetString("WUCODFIS"))+"";
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
            /* _oldmac := '' */
            _oldmac = "";
            /* cSRES := '' */
            cSRES = "";
            /* cSRES2 := '' */
            cSRES2 = "";
            /* xCF := '' */
            xCF = "";
            /* dNas := CharToDate(Right(wuchkunicr->WUDATNAS,4)+Substr(wuchkunicr->WUDATNAS,4,2)+Left(wuchkunicr->WUDATNAS,2)) */
            dNas = CPLib.CharToDate(CPLib.Right(Cursor_wuchkunicr.GetString("WUDATNAS"),4)+CPLib.Substr(Cursor_wuchkunicr.GetString("WUDATNAS"),4,2)+CPLib.Left(Cursor_wuchkunicr.GetString("WUDATNAS"),2));
            /* dDoc := CharToDate(Right(wuchkunicr->WURDOCCLI,4)+Substr(wuchkunicr->WURDOCCLI,4,2)+Left(wuchkunicr->WURDOCCLI,2)) */
            dDoc = CPLib.CharToDate(CPLib.Right(Cursor_wuchkunicr.GetString("WURDOCCLI"),4)+CPLib.Substr(Cursor_wuchkunicr.GetString("WURDOCCLI"),4,2)+CPLib.Left(Cursor_wuchkunicr.GetString("WURDOCCLI"),2));
            /* dSca := CharToDate(Right(wuchkunicr->WUSDOCCLI,4)+Substr(wuchkunicr->WUSDOCCLI,4,2)+Left(wuchkunicr->WUSDOCCLI,2)) */
            dSca = CPLib.CharToDate(CPLib.Right(Cursor_wuchkunicr.GetString("WUSDOCCLI"),4)+CPLib.Substr(Cursor_wuchkunicr.GetString("WUSDOCCLI"),4,2)+CPLib.Left(Cursor_wuchkunicr.GetString("WUSDOCCLI"),2));
            // * --- Read from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_cSql = "";
            m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNCODFIS")))?Cursor_wuchkunicr.GetString("WUCODFIS"):Cursor_wuchkunicr.GetString("WUNCODFIS")),"C",16,0,m_cServer),m_cServer,(CPLib.Empty(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNCODFIS")))?Cursor_wuchkunicr.GetString("WUCODFIS"):Cursor_wuchkunicr.GetString("WUNCODFIS")));
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
                Error l_oErrorFault = new Error("Read on personbo into routine arrt_wu_chkerr_unicr_save returns two or more records. This item should return only a record.");
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
            /* If not(Empty(wuchkunicr->WUNSEXCLI)) */
            if ( ! (CPLib.Empty(Cursor_wuchkunicr.GetString("WUNSEXCLI")))) {
              /* xSesso := iif(wuchkunicr->WUNSEXCLI='M','1',iif(wuchkunicr->WUNSEXCLI='F','2',wuchkunicr->WUNSEXCLI)) */
              xSesso = (CPLib.eqr(Cursor_wuchkunicr.GetString("WUNSEXCLI"),"M")?"1":(CPLib.eqr(Cursor_wuchkunicr.GetString("WUNSEXCLI"),"F")?"2":Cursor_wuchkunicr.GetString("WUNSEXCLI")));
            } else { // Else
              /* xSesso := iif(wuchkunicr->WUSEXCLI='M','1',iif(wuchkunicr->WUSEXCLI='F','2',wuchkunicr->WUSEXCLI)) */
              xSesso = (CPLib.eqr(Cursor_wuchkunicr.GetString("WUSEXCLI"),"M")?"1":(CPLib.eqr(Cursor_wuchkunicr.GetString("WUSEXCLI"),"F")?"2":Cursor_wuchkunicr.GetString("WUSEXCLI")));
            } // End If
            /* xCitta := iif(Empty(LRTrim(wuchkunicr->WUNBCITCLI)),wuchkunicr->WUBCITCLI,wuchkunicr->WUNBCITCLI) */
            xCitta = (CPLib.Empty(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNBCITCLI")))?Cursor_wuchkunicr.GetString("WUBCITCLI"):Cursor_wuchkunicr.GetString("WUNBCITCLI"));
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
                Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_wu_chkerr_unicr_save returns two or more records. This item should return only a record.");
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
            /* cCNAS := iif(Empty(LRTrim(wuchkunicr->WUNBCITCLI)),wuchkunicr->WUBCITCLI,wuchkunicr->WUNBCITCLI) */
            cCNAS = (CPLib.Empty(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNBCITCLI")))?Cursor_wuchkunicr.GetString("WUBCITCLI"):Cursor_wuchkunicr.GetString("WUNBCITCLI"));
            /* If Substr(wuchkunicr->WUCODFIS,12,1) = 'Z' and Len(LRTrim(xSesso))=1 */
            if (CPLib.eqr(CPLib.Substr(Cursor_wuchkunicr.GetString("WUCODFIS"),12,1),"Z") && CPLib.eqr(CPLib.Len(CPLib.LRTrim(xSesso)),1)) {
              /* cPNAS := 'EE' */
              cPNAS = "EE";
              /* cSNAS := iif(Empty(LRTrim(wuchkunicr->WUNBCITCLI)),wuchkunicr->WUBSTACLI,wuchkunicr->WUNBSTACLI) */
              cSNAS = (CPLib.Empty(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNBCITCLI")))?Cursor_wuchkunicr.GetString("WUBSTACLI"):Cursor_wuchkunicr.GetString("WUNBSTACLI"));
              /* cCNAS := '' */
              cCNAS = "";
            } // End If
            /* xProvRes := '' */
            xProvRes = "";
            // * --- Read from tbcitta
            m_cServer = m_Ctx.GetServer("tbcitta");
            m_cPhName = m_Ctx.GetPhName("tbcitta");
            m_cSql = "";
            m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNCITCLI")))?Cursor_wuchkunicr.GetString("WUCITCLI"):Cursor_wuchkunicr.GetString("WUNCITCLI")),"C",60,0,m_cServer),m_cServer,(CPLib.Empty(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNCITCLI")))?Cursor_wuchkunicr.GetString("WUCITCLI"):Cursor_wuchkunicr.GetString("WUNCITCLI")));
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
                Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_wu_chkerr_unicr_save returns two or more records. This item should return only a record.");
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
            /* cSRES := Left(wuchkunicr->WUSTACLI,40) */
            cSRES = CPLib.Left(Cursor_wuchkunicr.GetString("WUSTACLI"),40);
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
                Error l_oErrorFault = new Error("Read on tbstati into routine arrt_wu_chkerr_unicr_save returns two or more records. This item should return only a record.");
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
            /* _aggcli := 0 */
            _aggcli = CPLib.Round(0,0);
            /* Case LRTrim(wuchkunicr->WUCODMAGE)='COSTA' */
            if (CPLib.eqr(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUCODMAGE")),"COSTA")) {
              /* _aggcli := 1 */
              _aggcli = CPLib.Round(1,0);
              /* Case wuchkunicr->WUCODMAGE='FININ' */
            } else if (CPLib.eqr(Cursor_wuchkunicr.GetString("WUCODMAGE"),"FININ")) {
              /* If _oldmac <> 'COSTA' */
              if (CPLib.ne(_oldmac,"COSTA")) {
                /* _aggcli := 1 */
                _aggcli = CPLib.Round(1,0);
              } // End If
              /* Case wuchkunicr->WUCODMAGE='BCAUC' */
            } else if (CPLib.eqr(Cursor_wuchkunicr.GetString("WUCODMAGE"),"BCAUC")) {
              /* If _oldmac <> 'COSTA' and _oldmac <> 'FININ' */
              if (CPLib.ne(_oldmac,"COSTA") && CPLib.ne(_oldmac,"FININ")) {
                /* _aggcli := 1 */
                _aggcli = CPLib.Round(1,0);
              } // End If
              /* Case wuchkunicr->WUCODMAGE='BCISP' */
            } else if (CPLib.eqr(Cursor_wuchkunicr.GetString("WUCODMAGE"),"BCISP")) {
              /* If _oldmac <> 'COSTA' and _oldmac <> 'FININ' and _oldmac <> 'BCAUC' */
              if (CPLib.ne(_oldmac,"COSTA") && CPLib.ne(_oldmac,"FININ") && CPLib.ne(_oldmac,"BCAUC")) {
                /* _aggcli := 1 */
                _aggcli = CPLib.Round(1,0);
              } // End If
              /* Case wuchkunicr->WUCODMAGE='BCASS' or LRTrim(wuchkunicr->WUCODMAGE)='E998' or LRTrim(wuchkunicr->WUCODMAGE)='EBDSS' or LRTrim(wuchkunicr->WUCODMAGE)='I999' */
            } else if (CPLib.eqr(Cursor_wuchkunicr.GetString("WUCODMAGE"),"BCASS") || CPLib.eqr(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUCODMAGE")),"E998") || CPLib.eqr(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUCODMAGE")),"EBDSS") || CPLib.eqr(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUCODMAGE")),"I999")) {
              /* If _oldmac <> 'COSTA' and _oldmac <> 'FININ' and _oldmac <> 'BCAUC' and _oldmac <> 'BCISP' */
              if (CPLib.ne(_oldmac,"COSTA") && CPLib.ne(_oldmac,"FININ") && CPLib.ne(_oldmac,"BCAUC") && CPLib.ne(_oldmac,"BCISP")) {
                /* _aggcli := 1 */
                _aggcli = CPLib.Round(1,0);
              } // End If
              /* Case wuchkunicr->WUCODMAGE='DHLSP' */
            } else if (CPLib.eqr(Cursor_wuchkunicr.GetString("WUCODMAGE"),"DHLSP")) {
              /* If _oldmac = 'TRAVX' or _oldmac='DHLSP' */
              if (CPLib.eqr(_oldmac,"TRAVX") || CPLib.eqr(_oldmac,"DHLSP")) {
                /* _aggcli := 1 */
                _aggcli = CPLib.Round(1,0);
              } // End If
              /* Case wuchkunicr->WUCODMAGE='TRAVX' */
            } else if (CPLib.eqr(Cursor_wuchkunicr.GetString("WUCODMAGE"),"TRAVX")) {
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
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODFIS"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                // * --- Insert into wersonbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("wersonbo");
                m_cPhName = m_Ctx.GetPhName("wersonbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_chkerr_unicr_save",22,"0000010D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000010D(m_Ctx,m_oWrInfo);
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
              m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_chkerr_unicr_save",22,"0000010E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(xCodCab,"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUCOGCLI"))+" "+CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNOMCLI")),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(CPLib.Left(Cursor_wuchkunicr.GetString("WUINDCLI"),35),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(xCF,"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL((CPLib.Empty(dNas)?dNas:Cursor_wuchkunicr.GetDate("WUNDATNAS")),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(cCNAS,"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL("600","C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL("","C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL("600","C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNTDOCCLI")))?Cursor_wuchkunicr.GetString("WUTDOCCLI"):Cursor_wuchkunicr.GetString("WUNTDOCCLI")),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNDOCCLI")),15),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL((CPLib.Empty(dDoc)?dDoc:Cursor_wuchkunicr.GetDate("WUNRDOCCLI")),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUADOCRIL"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNCITCLI")))?Cursor_wuchkunicr.GetString("WUCITCLI"):Cursor_wuchkunicr.GetString("WUNCITCLI")),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(xProvRes,"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNCAPCLI")))?Cursor_wuchkunicr.GetString("WUCAPCLI"):Cursor_wuchkunicr.GetString("WUNCAPCLI")),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(xSesso,"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(cSRES2,"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATAVALI = "+CPLib.ToSQL((CPLib.Empty(dSca)?dSca:Cursor_wuchkunicr.GetDate("WUNSDOCCLI")),"D",8,0)+", ";
              m_cSql = m_cSql+"TIPOPERS = "+CPLib.ToSQL(_tipper,"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(CPLib.Left(Cursor_wuchkunicr.GetString("WUCOGCLI"),26),"C",26,0,m_cServer)+", ";
              m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(CPLib.Left(Cursor_wuchkunicr.GetString("WUNOMCLI"),25),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(cPNAS,"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(cSNAS,"C",30,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODFIS"),"?",0,0,m_cServer),m_cServer,Cursor_wuchkunicr.GetString("WUCODFIS"))+"";
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
              /* _connes := '' */
              _connes = "";
              // * --- Read from personbo_agg
              m_cServer = m_Ctx.GetServer("personbo_agg");
              m_cPhName = m_Ctx.GetPhName("personbo_agg");
              m_cSql = "";
              m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODFIS"),"C",16,0,m_cServer),m_cServer,Cursor_wuchkunicr.GetString("WUCODFIS"));
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
                  Error l_oErrorFault = new Error("Read on personbo_agg into routine arrt_wu_chkerr_unicr_save returns two or more records. This item should return only a record.");
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
                m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_chkerr_unicr_save",22,"00000112")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000112(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODFIS"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUEMAIL"),"?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUFLGMAIL"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUTELEFONO"),"?",0,0,m_cServer)+", ";
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
                m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_chkerr_unicr_save",22,"00000113")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"EMAIL = "+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUEMAIL"),"M",10,0,m_cServer,m_oParameters)+", ";
                m_cSql = m_cSql+"FLGEMAIL = "+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUFLGMAIL"),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"TELEFONO = "+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUTELEFONO"),"C",50,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo_agg",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODFIS"),"?",0,0,m_cServer),m_cServer,Cursor_wuchkunicr.GetString("WUCODFIS"))+"";
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
            /* If not(Empty(wuchkunicr->WUDATINI)) */
            if ( ! (CPLib.Empty(Cursor_wuchkunicr.GetDate("WUDATINI")))) {
              /* _unicode := '' */
              _unicode = "";
              /* _oldreg := '' */
              _oldreg = "";
              // * --- Select from rapopebo
              m_cServer = m_Ctx.GetServer("rapopebo");
              m_cPhName = m_Ctx.GetPhName("rapopebo");
              if (Cursor_rapopebo!=null)
                Cursor_rapopebo.Close();
              Cursor_rapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CDATOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.DateToChar(dIni),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.DateToChar(dIni))+"  and  RAPPORTO="+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODRAP"),"?",0,0)+"  and  TIPOOPRAP='23'  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("rapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
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
                /* xConnes := wuchkunicr->WUCODFIS */
                xConnes = Cursor_wuchkunicr.GetString("WUCODFIS");
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
                m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_chkerr_unicr_save",22,"0000012D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000012D(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(dIni),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_wuchkunicr.GetString("WUCODMAGE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull(xSOCTCF,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(dIni,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cFlagLire,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(dIni)+cInfProg2+"0","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_wuchkunicr.GetString("WUCODFIS"),"?",0,0,m_cServer)+", ";
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
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
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
                Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODFIS"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM ",m_cServer,m_Ctx,true));
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
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_chkerr_unicr_save",22,"00000136")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000136(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow+1,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(dIni,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull(cCli1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODFIS"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(dIni)+cInfProg2+"0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cCli1,"?",0,0,m_cServer)+", ";
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
                } else { // Else
                  // * --- Write into intestbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("intestbo");
                  m_cPhName = m_Ctx.GetPhName("intestbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_chkerr_unicr_save",22,"00000137")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"DATAINI = "+CPLib.ToSQL(dIni,"D",8,0)+", ";
                  m_cSql = m_cSql+"NUMPROG1 = "+CPLib.ToSQL(cInfProg2,"C",11,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODFIS"),"?",0,0,m_cServer),m_cServer,Cursor_wuchkunicr.GetString("WUCODFIS"))+"";
                  m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_nummod,"?",0,0,m_cServer),m_cServer,_nummod)+"";
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
                m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_chkerr_unicr_save",22,"0000013A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                /* xConnes := wuchkunicr->WUCODFIS */
                xConnes = Cursor_wuchkunicr.GetString("WUCODFIS");
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
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_chkerr_unicr_save",22,"0000014A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_0000014A(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(dIni),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull(xSOCTCF,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(dIni,"?",0,0)+", ";
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
                  m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_wuchkunicr.GetString("WUCODFIS"),"?",0,0,m_cServer)+", ";
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
                    m_Sql.AbortTransaction();
                  }
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                  }
                  // * --- Select from intestbo
                  m_cServer = m_Ctx.GetServer("intestbo");
                  m_cPhName = m_Ctx.GetPhName("intestbo");
                  if (Cursor_intestbo!=null)
                    Cursor_intestbo.Close();
                  Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODFIS"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM ",m_cServer,m_Ctx,true));
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
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_chkerr_unicr_save",22,"00000151")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_00000151(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow+1,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(dIni,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQLNull(cCli1,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODFIS"),"?",0,0,m_cServer)+", ";
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
                      m_Sql.AbortTransaction();
                    }
                    m_Sql.CompleteTransaction();
                    m_cLastMsgError = m_Sql.TransactionErrorMessage();
                    if (CPLib.ne(m_cLastMsgError,"")) {
                      m_bError = true;
                    }
                  } else { // Else
                    // * --- Write into intestbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("intestbo");
                    m_cPhName = m_Ctx.GetPhName("intestbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_chkerr_unicr_save",22,"00000152")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"DATAINI = "+CPLib.ToSQL(dIni,"D",8,0)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODFIS"),"?",0,0,m_cServer),m_cServer,Cursor_wuchkunicr.GetString("WUCODFIS"))+"";
                    m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_nummod,"?",0,0,m_cServer),m_cServer,_nummod)+"";
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
                  Cursor_rapopebo.Next();
                }
                m_cConnectivityError = Cursor_rapopebo.ErrorMessage();
                Cursor_rapopebo.Close();
                // * --- End Select
              } // End If
            } // End If
            /* If not(Empty(dFin)) */
            if ( ! (CPLib.Empty(dFin))) {
              /* _unicode := '' */
              _unicode = "";
              /* _oldreg := '' */
              _oldreg = "";
              // * --- Select from rapopebo
              m_cServer = m_Ctx.GetServer("rapopebo");
              m_cPhName = m_Ctx.GetPhName("rapopebo");
              if (Cursor_rapopebo!=null)
                Cursor_rapopebo.Close();
              Cursor_rapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CDATOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.DateToChar(dFin),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.DateToChar(dFin))+"  and  RAPPORTO="+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODRAP"),"?",0,0)+"  and  TIPOOPRAP='26'  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("rapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
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
                /* xConnes := wuchkunicr->WUCODFIS */
                xConnes = Cursor_wuchkunicr.GetString("WUCODFIS");
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
                m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_chkerr_unicr_save",22,"0000016B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000016B(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(dFin),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_wuchkunicr.GetString("WUCODMAGE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull(xSOCTCF,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(dFin,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cFlagLire,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(dFin)+cInfProg2+"0","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_wuchkunicr.GetString("WUCODFIS"),"?",0,0,m_cServer)+", ";
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
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
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
                Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODFIS"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM ",m_cServer,m_Ctx,true));
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
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_chkerr_unicr_save",22,"00000174")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000174(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow+1,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(dFin,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull(cCli1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODFIS"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(dFin)+cInfProg2+"0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cCli1,"?",0,0,m_cServer)+", ";
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
                } else { // Else
                  // * --- Write into intestbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("intestbo");
                  m_cPhName = m_Ctx.GetPhName("intestbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_chkerr_unicr_save",22,"00000175")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(CPLib.DateToChar(dFin),"D",8,0)+", ";
                  m_cSql = m_cSql+"NUMPROG2 = "+CPLib.ToSQL(cInfProg2,"C",11,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODFIS"),"?",0,0,m_cServer),m_cServer,Cursor_wuchkunicr.GetString("WUCODFIS"))+"";
                  m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_nummod,"?",0,0,m_cServer),m_cServer,_nummod)+"";
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
                m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_chkerr_unicr_save",22,"00000178")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                /* xConnes := wuchkunicr->WUCODFIS */
                xConnes = Cursor_wuchkunicr.GetString("WUCODFIS");
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
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_chkerr_unicr_save",22,"00000188")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000188(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(dFin),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull(xSOCTCF,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(dFin,"?",0,0)+", ";
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
                  m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_wuchkunicr.GetString("WUCODFIS"),"?",0,0,m_cServer)+", ";
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
                    m_Sql.AbortTransaction();
                  }
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                  }
                  // * --- Select from intestbo
                  m_cServer = m_Ctx.GetServer("intestbo");
                  m_cPhName = m_Ctx.GetPhName("intestbo");
                  if (Cursor_intestbo!=null)
                    Cursor_intestbo.Close();
                  Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODFIS"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM ",m_cServer,m_Ctx,true));
                  while ( ! (Cursor_intestbo.Eof())) {
                    /* If intestbo->CODINTER=wuchkunicr->WUCODFIS */
                    if (CPLib.eqr(Cursor_intestbo.GetString("CODINTER"),Cursor_wuchkunicr.GetString("WUCODFIS"))) {
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
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_chkerr_unicr_save",22,"0000018F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_0000018F(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow+1,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(dFin,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_wuchkunicr.GetString("WUCODFIS"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODFIS"),"?",0,0,m_cServer)+", ";
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
                      m_Sql.AbortTransaction();
                    }
                    m_Sql.CompleteTransaction();
                    m_cLastMsgError = m_Sql.TransactionErrorMessage();
                    if (CPLib.ne(m_cLastMsgError,"")) {
                      m_bError = true;
                    }
                  } else { // Else
                    // * --- Write into intestbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("intestbo");
                    m_cPhName = m_Ctx.GetPhName("intestbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_chkerr_unicr_save",22,"00000190")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(dFin,"D",8,0)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODFIS"),"?",0,0,m_cServer),m_cServer,Cursor_wuchkunicr.GetString("WUCODFIS"))+"";
                    m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_nummod,"?",0,0,m_cServer),m_cServer,_nummod)+"";
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
        Cursor_wuchkunicr.Next();
      }
      m_cConnectivityError = Cursor_wuchkunicr.ErrorMessage();
      Cursor_wuchkunicr.Close();
      // * --- End Select
      /* If _errmod = 'S' */
      if (CPLib.eqr(_errmod,"S")) {
        /* _errore := 1 */
        _errore = CPLib.Round(1,0);
      } // End If
    } finally {
      try {
        if (Cursor_wuchkunicr!=null)
          Cursor_wuchkunicr.Close();
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
  void Page_4() throws Exception {
    CPResultSet Cursor_wuchkunicr=null;
    CPResultSet Cursor_knarapbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_intestbo=null;
    try {
      /* _xrapclose Char(25) */
      String _xrapclose;
      _xrapclose = CPLib.Space(25);
      /* _xtiprap Char(1) */
      String _xtiprap;
      _xtiprap = CPLib.Space(1);
      // * --- Select from wuchkunicr
      m_cServer = m_Ctx.GetServer("wuchkunicr");
      m_cPhName = m_Ctx.GetPhName("wuchkunicr");
      if (Cursor_wuchkunicr!=null)
        Cursor_wuchkunicr.Close();
      Cursor_wuchkunicr = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"WUCODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_WUCODICE,"?",0,0,m_cServer, m_oParameters),m_cServer,w_WUCODICE)+" "+")"+(m_Ctx.IsSharedTemp("wuchkunicr")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_wuchkunicr.Eof())) {
        /* _xrapclose := '' */
        _xrapclose = "";
        /* _xtiprap := '' */
        _xtiprap = "";
        // * --- Select from knarapbo
        m_cServer = m_Ctx.GetServer("knarapbo");
        m_cPhName = m_Ctx.GetPhName("knarapbo");
        if (Cursor_knarapbo!=null)
          Cursor_knarapbo.Close();
        Cursor_knarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODFIS"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("knarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
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
          /* dIni := iif(Empty(wuchkunicr->WUNDATINI),wuchkunicr->WUDATINI,wuchkunicr->WUNDATINI) */
          dIni = (CPLib.Empty(Cursor_wuchkunicr.GetDate("WUNDATINI"))?Cursor_wuchkunicr.GetDate("WUDATINI"):Cursor_wuchkunicr.GetDate("WUNDATINI"));
          /* dFin := iif(Empty(wuchkunicr->WUNDATFIN),wuchkunicr->WUDATFIN,wuchkunicr->WUNDATFIN) */
          dFin = (CPLib.Empty(Cursor_wuchkunicr.GetDate("WUNDATFIN"))?Cursor_wuchkunicr.GetDate("WUDATFIN"):Cursor_wuchkunicr.GetDate("WUNDATFIN"));
          /* If not(Empty(dFin)) */
          if ( ! (CPLib.Empty(dFin))) {
            /* _oldmac := '' */
            _oldmac = "";
            /* cSRES := '' */
            cSRES = "";
            /* cSRES2 := '' */
            cSRES2 = "";
            /* xCF := '' */
            xCF = "";
            /* dNas := CharToDate(Right(wuchkunicr->WUDATNAS,4)+Substr(wuchkunicr->WUDATNAS,4,2)+Left(wuchkunicr->WUDATNAS,2)) */
            dNas = CPLib.CharToDate(CPLib.Right(Cursor_wuchkunicr.GetString("WUDATNAS"),4)+CPLib.Substr(Cursor_wuchkunicr.GetString("WUDATNAS"),4,2)+CPLib.Left(Cursor_wuchkunicr.GetString("WUDATNAS"),2));
            /* dDoc := CharToDate(Right(wuchkunicr->WURDOCCLI,4)+Substr(wuchkunicr->WURDOCCLI,4,2)+Left(wuchkunicr->WURDOCCLI,2)) */
            dDoc = CPLib.CharToDate(CPLib.Right(Cursor_wuchkunicr.GetString("WURDOCCLI"),4)+CPLib.Substr(Cursor_wuchkunicr.GetString("WURDOCCLI"),4,2)+CPLib.Left(Cursor_wuchkunicr.GetString("WURDOCCLI"),2));
            /* dSca := CharToDate(Right(wuchkunicr->WUSDOCCLI,4)+Substr(wuchkunicr->WUSDOCCLI,4,2)+Left(wuchkunicr->WUSDOCCLI,2)) */
            dSca = CPLib.CharToDate(CPLib.Right(Cursor_wuchkunicr.GetString("WUSDOCCLI"),4)+CPLib.Substr(Cursor_wuchkunicr.GetString("WUSDOCCLI"),4,2)+CPLib.Left(Cursor_wuchkunicr.GetString("WUSDOCCLI"),2));
            // * --- Read from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_cSql = "";
            m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNCODFIS")))?Cursor_wuchkunicr.GetString("WUCODFIS"):Cursor_wuchkunicr.GetString("WUNCODFIS")),"C",16,0,m_cServer),m_cServer,(CPLib.Empty(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNCODFIS")))?Cursor_wuchkunicr.GetString("WUCODFIS"):Cursor_wuchkunicr.GetString("WUNCODFIS")));
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
                Error l_oErrorFault = new Error("Read on personbo into routine arrt_wu_chkerr_unicr_save returns two or more records. This item should return only a record.");
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
            /* If not(Empty(wuchkunicr->WUNSEXCLI)) */
            if ( ! (CPLib.Empty(Cursor_wuchkunicr.GetString("WUNSEXCLI")))) {
              /* xSesso := iif(wuchkunicr->WUNSEXCLI='M','1',iif(wuchkunicr->WUNSEXCLI='F','2',wuchkunicr->WUNSEXCLI)) */
              xSesso = (CPLib.eqr(Cursor_wuchkunicr.GetString("WUNSEXCLI"),"M")?"1":(CPLib.eqr(Cursor_wuchkunicr.GetString("WUNSEXCLI"),"F")?"2":Cursor_wuchkunicr.GetString("WUNSEXCLI")));
            } else { // Else
              /* xSesso := iif(wuchkunicr->WUSEXCLI='M','1',iif(wuchkunicr->WUSEXCLI='F','2',wuchkunicr->WUSEXCLI)) */
              xSesso = (CPLib.eqr(Cursor_wuchkunicr.GetString("WUSEXCLI"),"M")?"1":(CPLib.eqr(Cursor_wuchkunicr.GetString("WUSEXCLI"),"F")?"2":Cursor_wuchkunicr.GetString("WUSEXCLI")));
            } // End If
            /* xCitta := iif(Empty(LRTrim(wuchkunicr->WUNBCITCLI)),wuchkunicr->WUBCITCLI,wuchkunicr->WUNBCITCLI) */
            xCitta = (CPLib.Empty(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNBCITCLI")))?Cursor_wuchkunicr.GetString("WUBCITCLI"):Cursor_wuchkunicr.GetString("WUNBCITCLI"));
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
                Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_wu_chkerr_unicr_save returns two or more records. This item should return only a record.");
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
            /* cCNAS := iif(Empty(LRTrim(wuchkunicr->WUNBCITCLI)),wuchkunicr->WUBCITCLI,wuchkunicr->WUNBCITCLI) */
            cCNAS = (CPLib.Empty(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNBCITCLI")))?Cursor_wuchkunicr.GetString("WUBCITCLI"):Cursor_wuchkunicr.GetString("WUNBCITCLI"));
            /* If Substr(wuchkunicr->WUCODFIS,12,1) = 'Z' and Len(LRTrim(xSesso))=1 */
            if (CPLib.eqr(CPLib.Substr(Cursor_wuchkunicr.GetString("WUCODFIS"),12,1),"Z") && CPLib.eqr(CPLib.Len(CPLib.LRTrim(xSesso)),1)) {
              /* cPNAS := 'EE' */
              cPNAS = "EE";
              /* cSNAS := iif(Empty(LRTrim(wuchkunicr->WUNBCITCLI)),wuchkunicr->WUBSTACLI,wuchkunicr->WUNBSTACLI) */
              cSNAS = (CPLib.Empty(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNBCITCLI")))?Cursor_wuchkunicr.GetString("WUBSTACLI"):Cursor_wuchkunicr.GetString("WUNBSTACLI"));
              /* cCNAS := '' */
              cCNAS = "";
            } // End If
            /* xProvRes := '' */
            xProvRes = "";
            // * --- Read from tbcitta
            m_cServer = m_Ctx.GetServer("tbcitta");
            m_cPhName = m_Ctx.GetPhName("tbcitta");
            m_cSql = "";
            m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNCITCLI")))?Cursor_wuchkunicr.GetString("WUCITCLI"):Cursor_wuchkunicr.GetString("WUNCITCLI")),"C",60,0,m_cServer),m_cServer,(CPLib.Empty(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNCITCLI")))?Cursor_wuchkunicr.GetString("WUCITCLI"):Cursor_wuchkunicr.GetString("WUNCITCLI")));
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
                Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_wu_chkerr_unicr_save returns two or more records. This item should return only a record.");
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
            /* cSRES := Left(wuchkunicr->WUSTACLI,40) */
            cSRES = CPLib.Left(Cursor_wuchkunicr.GetString("WUSTACLI"),40);
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
                Error l_oErrorFault = new Error("Read on tbstati into routine arrt_wu_chkerr_unicr_save returns two or more records. This item should return only a record.");
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
            /* _aggcli := 0 */
            _aggcli = CPLib.Round(0,0);
            /* Case LRTrim(wuchkunicr->WUCODMAGE)='COSTA' */
            if (CPLib.eqr(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUCODMAGE")),"COSTA")) {
              /* _aggcli := 1 */
              _aggcli = CPLib.Round(1,0);
              /* Case wuchkunicr->WUCODMAGE='FININ' */
            } else if (CPLib.eqr(Cursor_wuchkunicr.GetString("WUCODMAGE"),"FININ")) {
              /* If _oldmac <> 'COSTA' */
              if (CPLib.ne(_oldmac,"COSTA")) {
                /* _aggcli := 1 */
                _aggcli = CPLib.Round(1,0);
              } // End If
              /* Case wuchkunicr->WUCODMAGE='BCAUC' */
            } else if (CPLib.eqr(Cursor_wuchkunicr.GetString("WUCODMAGE"),"BCAUC")) {
              /* If _oldmac <> 'COSTA' and _oldmac <> 'FININ' */
              if (CPLib.ne(_oldmac,"COSTA") && CPLib.ne(_oldmac,"FININ")) {
                /* _aggcli := 1 */
                _aggcli = CPLib.Round(1,0);
              } // End If
              /* Case wuchkunicr->WUCODMAGE='BCISP' */
            } else if (CPLib.eqr(Cursor_wuchkunicr.GetString("WUCODMAGE"),"BCISP")) {
              /* If _oldmac <> 'COSTA' and _oldmac <> 'FININ' and _oldmac <> 'BCAUC' */
              if (CPLib.ne(_oldmac,"COSTA") && CPLib.ne(_oldmac,"FININ") && CPLib.ne(_oldmac,"BCAUC")) {
                /* _aggcli := 1 */
                _aggcli = CPLib.Round(1,0);
              } // End If
              /* Case wuchkunicr->WUCODMAGE='BCASS' or LRTrim(wuchkunicr->WUCODMAGE)='E998' or LRTrim(wuchkunicr->WUCODMAGE)='EBDSS' or LRTrim(wuchkunicr->WUCODMAGE)='I999' */
            } else if (CPLib.eqr(Cursor_wuchkunicr.GetString("WUCODMAGE"),"BCASS") || CPLib.eqr(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUCODMAGE")),"E998") || CPLib.eqr(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUCODMAGE")),"EBDSS") || CPLib.eqr(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUCODMAGE")),"I999")) {
              /* If _oldmac <> 'COSTA' and _oldmac <> 'FININ' and _oldmac <> 'BCAUC' and _oldmac <> 'BCISP' */
              if (CPLib.ne(_oldmac,"COSTA") && CPLib.ne(_oldmac,"FININ") && CPLib.ne(_oldmac,"BCAUC") && CPLib.ne(_oldmac,"BCISP")) {
                /* _aggcli := 1 */
                _aggcli = CPLib.Round(1,0);
              } // End If
              /* Case wuchkunicr->WUCODMAGE='DHLSP' */
            } else if (CPLib.eqr(Cursor_wuchkunicr.GetString("WUCODMAGE"),"DHLSP")) {
              /* If _oldmac = 'TRAVX' or _oldmac='DHLSP' */
              if (CPLib.eqr(_oldmac,"TRAVX") || CPLib.eqr(_oldmac,"DHLSP")) {
                /* _aggcli := 1 */
                _aggcli = CPLib.Round(1,0);
              } // End If
              /* Case wuchkunicr->WUCODMAGE='TRAVX' */
            } else if (CPLib.eqr(Cursor_wuchkunicr.GetString("WUCODMAGE"),"TRAVX")) {
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
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODFIS"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                // * --- Insert into wersonbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("wersonbo");
                m_cPhName = m_Ctx.GetPhName("wersonbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_chkerr_unicr_save",22,"000001D1")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000001D1(m_Ctx,m_oWrInfo);
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
              m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_chkerr_unicr_save",22,"000001D2")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(xCodCab,"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUCOGCLI"))+" "+CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNOMCLI")),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(CPLib.Left(Cursor_wuchkunicr.GetString("WUINDCLI"),35),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(xCF,"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL((CPLib.Empty(dNas)?dNas:Cursor_wuchkunicr.GetDate("WUNDATNAS")),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(cCNAS,"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL("600","C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL("","C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL("600","C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNTDOCCLI")))?Cursor_wuchkunicr.GetString("WUTDOCCLI"):Cursor_wuchkunicr.GetString("WUNTDOCCLI")),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNDOCCLI")),15),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL((CPLib.Empty(dDoc)?dDoc:Cursor_wuchkunicr.GetDate("WUNRDOCCLI")),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUADOCRIL"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNCITCLI")))?Cursor_wuchkunicr.GetString("WUCITCLI"):Cursor_wuchkunicr.GetString("WUNCITCLI")),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(xProvRes,"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(Cursor_wuchkunicr.GetString("WUNCAPCLI")))?Cursor_wuchkunicr.GetString("WUCAPCLI"):Cursor_wuchkunicr.GetString("WUNCAPCLI")),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(xSesso,"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(cSRES2,"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATAVALI = "+CPLib.ToSQL((CPLib.Empty(dSca)?dSca:Cursor_wuchkunicr.GetDate("WUNSDOCCLI")),"D",8,0)+", ";
              m_cSql = m_cSql+"TIPOPERS = "+CPLib.ToSQL(_tipper,"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(CPLib.Left(Cursor_wuchkunicr.GetString("WUCOGCLI"),26),"C",26,0,m_cServer)+", ";
              m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(CPLib.Left(Cursor_wuchkunicr.GetString("WUNOMCLI"),25),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(cPNAS,"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(cSNAS,"C",30,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODFIS"),"?",0,0,m_cServer),m_cServer,Cursor_wuchkunicr.GetString("WUCODFIS"))+"";
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
              /* _connes := '' */
              _connes = "";
              // * --- Read from personbo_agg
              m_cServer = m_Ctx.GetServer("personbo_agg");
              m_cPhName = m_Ctx.GetPhName("personbo_agg");
              m_cSql = "";
              m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODFIS"),"C",16,0,m_cServer),m_cServer,Cursor_wuchkunicr.GetString("WUCODFIS"));
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
                  Error l_oErrorFault = new Error("Read on personbo_agg into routine arrt_wu_chkerr_unicr_save returns two or more records. This item should return only a record.");
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
                m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_chkerr_unicr_save",22,"000001D6")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000001D6(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODFIS"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUEMAIL"),"?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUFLGMAIL"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUTELEFONO"),"?",0,0,m_cServer)+", ";
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
                m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_chkerr_unicr_save",22,"000001D7")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"EMAIL = "+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUEMAIL"),"M",10,0,m_cServer,m_oParameters)+", ";
                m_cSql = m_cSql+"FLGEMAIL = "+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUFLGMAIL"),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"TELEFONO = "+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUTELEFONO"),"C",50,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo_agg",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODFIS"),"?",0,0,m_cServer),m_cServer,Cursor_wuchkunicr.GetString("WUCODFIS"))+"";
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
            /* _intercod := _codinter */
            _intercod = _codinter;
            /* _intercit := _citinter */
            _intercit = _citinter;
            /* _intercab := _cabinter */
            _intercab = _cabinter;
            /* _interprv := _prvinter */
            _interprv = _prvinter;
            /* xConnes := wuchkunicr->WUCODFIS */
            xConnes = Cursor_wuchkunicr.GetString("WUCODFIS");
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
            /* _unicode := '' */
            _unicode = "";
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
            m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_chkerr_unicr_save",22,"000001E8")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000001E8(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(dFin),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_wuchkunicr.GetString("WUCODMAGE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(xSOCTCF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(dFin,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cFlagLire,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(dFin)+cInfProg1+"0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_wuchkunicr.GetString("WUCODFIS"),"?",0,0,m_cServer)+", ";
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
              m_Sql.AbortTransaction();
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
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
            Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODFIS"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM ",m_cServer,m_Ctx,true));
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
              m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_chkerr_unicr_save",22,"000001F1")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000001F1(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow+1,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(dFin,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(cCli1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODFIS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(dFin)+cInfProg2+"0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cCli1,"?",0,0,m_cServer)+", ";
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
            } else { // Else
              // * --- Write into intestbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("intestbo");
              m_cPhName = m_Ctx.GetPhName("intestbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_chkerr_unicr_save",22,"000001F2")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(dFin,"D",8,0)+", ";
              m_cSql = m_cSql+"NUMPROG2 = "+CPLib.ToSQL(cInfProg2,"C",11,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_wuchkunicr.GetString("WUCODFIS"),"?",0,0,m_cServer),m_cServer,Cursor_wuchkunicr.GetString("WUCODFIS"))+"";
              m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_nummod,"?",0,0,m_cServer),m_cServer,_nummod)+"";
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
          /* _errore := 1 */
          _errore = CPLib.Round(1,0);
        } // End If
        Cursor_wuchkunicr.Next();
      }
      m_cConnectivityError = Cursor_wuchkunicr.ErrorMessage();
      Cursor_wuchkunicr.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_wuchkunicr!=null)
          Cursor_wuchkunicr.Close();
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
      m_Caller.SetString("WUCODICE","C",10,0,w_WUCODICE);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_wu_chkerr_unicr_saveR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_wu_chkerr_unicr_saveR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_WUCODICE = m_Caller.GetString("WUCODICE","C",10,0);
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
    _intertip = CPLib.Space(2);
    _errore = 0;
    _intercod = CPLib.Space(11);
    _intercit = CPLib.Space(30);
    _intercab = CPLib.Space(6);
    _interprv = CPLib.Space(2);
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
    _aggcli = 0;
    dNas = CPLib.NullDate();
    dDoc = CPLib.NullDate();
    dSca = CPLib.NullDate();
    dIni = CPLib.NullDate();
    dFin = CPLib.NullDate();
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000070(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_00000071(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"knarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000008F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"DATAVALI,";
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
  protected static String GetFieldsName_00000091(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"EMAIL,";
    p_cSql = p_cSql+"FLGEMAIL,";
    p_cSql = p_cSql+"TELEFONO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000A4(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_000000A9(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"EMAIL,";
    p_cSql = p_cSql+"FLGEMAIL,";
    p_cSql = p_cSql+"TELEFONO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000BC(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_000000C5(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_0000010D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_00000112(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"EMAIL,";
    p_cSql = p_cSql+"FLGEMAIL,";
    p_cSql = p_cSql+"TELEFONO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000012D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODDIPE,";
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
  protected static String GetFieldsName_0000014A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_00000151(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_0000016B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODDIPE,";
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
  protected static String GetFieldsName_00000174(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_00000188(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_0000018F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_000001D1(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_000001D6(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"EMAIL,";
    p_cSql = p_cSql+"FLGEMAIL,";
    p_cSql = p_cSql+"TELEFONO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001E8(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODDIPE,";
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
}
