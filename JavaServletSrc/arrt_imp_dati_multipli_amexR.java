// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_imp_dati_multipli_amexR implements CallerWithObjs {
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
  public String m_cPhName_aeopstor;
  public String m_cServer_aeopstor;
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
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
  public String m_cPhName_delegabo;
  public String m_cServer_delegabo;
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_japopebo;
  public String m_cServer_japopebo;
  public String m_cPhName_jelegabo;
  public String m_cServer_jelegabo;
  public String m_cPhName_jnarapbo;
  public String m_cServer_jnarapbo;
  public String m_cPhName_jntestbo;
  public String m_cServer_jntestbo;
  public String m_cPhName_joginfo;
  public String m_cServer_joginfo;
  public String m_cPhName_jogopebo;
  public String m_cServer_jogopebo;
  public String m_cPhName_jperazbo;
  public String m_cServer_jperazbo;
  public String m_cPhName_knarapbo;
  public String m_cServer_knarapbo;
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
  public String m_cPhName_rapotit;
  public String m_cServer_rapotit;
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
  public String m_cPhName_terzistifrz;
  public String m_cServer_terzistifrz;
  public String m_cPhName_terzistiope;
  public String m_cServer_terzistiope;
  public String m_cPhName_titolabo;
  public String m_cServer_titolabo;
  public String m_cPhName_titopers;
  public String m_cServer_titopers;
  public String m_cPhName_tmp_list_imprich;
  public String m_cServer_tmp_list_imprich;
  public String m_cPhName_xapopebo;
  public String m_cServer_xapopebo;
  public String m_cPhName_xapotit;
  public String m_cServer_xapotit;
  public String m_cPhName_xelegabo;
  public String m_cServer_xelegabo;
  public String m_cPhName_xeneficfrz;
  public String m_cServer_xeneficfrz;
  public String m_cPhName_xeneficope;
  public String m_cServer_xeneficope;
  public String m_cPhName_xerzistifrz;
  public String m_cServer_xerzistifrz;
  public String m_cPhName_xerzistiope;
  public String m_cServer_xerzistiope;
  public String m_cPhName_xlientifrz;
  public String m_cServer_xlientifrz;
  public String m_cPhName_xlientiope;
  public String m_cServer_xlientiope;
  public String m_cPhName_xnarapbo;
  public String m_cServer_xnarapbo;
  public String m_cPhName_xntestbo;
  public String m_cServer_xntestbo;
  public String m_cPhName_xoginfo;
  public String m_cServer_xoginfo;
  public String m_cPhName_xogopebo;
  public String m_cServer_xogopebo;
  public String m_cPhName_xogopefbo;
  public String m_cServer_xogopefbo;
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
  public String w_tipodest;
  public String gMsgProc;
  public double w_impzip;
  public String fhand;
  public String riga;
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
  public double cNumInv;
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
  public String _tipper;
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
  // * --- arrt_imp_dati_multipli_amex
  public String[] lista;
  public int conteggio;
  public int i;
  public int contanome;
  // * --- Fine Area Manuale
  public arrt_imp_dati_multipli_amexR (CPContext p_ContextObject, Caller caller) {
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
    p_ContextObject = p_ContextObject.DisabledDataFilteringVersion();
    CPSecurity.RoutineCallableByProgram("arrt_imp_dati_multipli_amex",m_Caller);
    m_cPhName_aeopstor = p_ContextObject.GetPhName("aeopstor");
    m_cServer_aeopstor = p_ContextObject.GetServer("aeopstor");
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_beneficfrz = p_ContextObject.GetPhName("beneficfrz");
    m_cServer_beneficfrz = p_ContextObject.GetServer("beneficfrz");
    m_cPhName_beneficope = p_ContextObject.GetPhName("beneficope");
    m_cServer_beneficope = p_ContextObject.GetServer("beneficope");
    m_cPhName_clientifrz = p_ContextObject.GetPhName("clientifrz");
    m_cServer_clientifrz = p_ContextObject.GetServer("clientifrz");
    m_cPhName_clientiope = p_ContextObject.GetPhName("clientiope");
    m_cServer_clientiope = p_ContextObject.GetServer("clientiope");
    m_cPhName_delegabo = p_ContextObject.GetPhName("delegabo");
    m_cServer_delegabo = p_ContextObject.GetServer("delegabo");
    m_cPhName_fraziobo = p_ContextObject.GetPhName("fraziobo");
    m_cServer_fraziobo = p_ContextObject.GetServer("fraziobo");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_japopebo = p_ContextObject.GetPhName("japopebo");
    m_cServer_japopebo = p_ContextObject.GetServer("japopebo");
    m_cPhName_jelegabo = p_ContextObject.GetPhName("jelegabo");
    m_cServer_jelegabo = p_ContextObject.GetServer("jelegabo");
    m_cPhName_jnarapbo = p_ContextObject.GetPhName("jnarapbo");
    m_cServer_jnarapbo = p_ContextObject.GetServer("jnarapbo");
    m_cPhName_jntestbo = p_ContextObject.GetPhName("jntestbo");
    m_cServer_jntestbo = p_ContextObject.GetServer("jntestbo");
    m_cPhName_joginfo = p_ContextObject.GetPhName("joginfo");
    m_cServer_joginfo = p_ContextObject.GetServer("joginfo");
    m_cPhName_jogopebo = p_ContextObject.GetPhName("jogopebo");
    m_cServer_jogopebo = p_ContextObject.GetServer("jogopebo");
    m_cPhName_jperazbo = p_ContextObject.GetPhName("jperazbo");
    m_cServer_jperazbo = p_ContextObject.GetServer("jperazbo");
    m_cPhName_knarapbo = p_ContextObject.GetPhName("knarapbo");
    m_cServer_knarapbo = p_ContextObject.GetServer("knarapbo");
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_cPhName_opextrbo = p_ContextObject.GetPhName("opextrbo");
    m_cServer_opextrbo = p_ContextObject.GetServer("opextrbo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_rapopebo = p_ContextObject.GetPhName("rapopebo");
    m_cServer_rapopebo = p_ContextObject.GetServer("rapopebo");
    m_cPhName_rapotit = p_ContextObject.GetPhName("rapotit");
    m_cServer_rapotit = p_ContextObject.GetServer("rapotit");
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
    m_cPhName_terzistifrz = p_ContextObject.GetPhName("terzistifrz");
    m_cServer_terzistifrz = p_ContextObject.GetServer("terzistifrz");
    m_cPhName_terzistiope = p_ContextObject.GetPhName("terzistiope");
    m_cServer_terzistiope = p_ContextObject.GetServer("terzistiope");
    m_cPhName_titolabo = p_ContextObject.GetPhName("titolabo");
    m_cServer_titolabo = p_ContextObject.GetServer("titolabo");
    m_cPhName_titopers = p_ContextObject.GetPhName("titopers");
    m_cServer_titopers = p_ContextObject.GetServer("titopers");
    m_cPhName_tmp_list_imprich = p_ContextObject.GetPhName("tmp_list_imprich");
    m_cServer_tmp_list_imprich = p_ContextObject.GetServer("tmp_list_imprich");
    m_cPhName_xapopebo = p_ContextObject.GetPhName("xapopebo");
    m_cServer_xapopebo = p_ContextObject.GetServer("xapopebo");
    m_cPhName_xapotit = p_ContextObject.GetPhName("xapotit");
    m_cServer_xapotit = p_ContextObject.GetServer("xapotit");
    m_cPhName_xelegabo = p_ContextObject.GetPhName("xelegabo");
    m_cServer_xelegabo = p_ContextObject.GetServer("xelegabo");
    m_cPhName_xeneficfrz = p_ContextObject.GetPhName("xeneficfrz");
    m_cServer_xeneficfrz = p_ContextObject.GetServer("xeneficfrz");
    m_cPhName_xeneficope = p_ContextObject.GetPhName("xeneficope");
    m_cServer_xeneficope = p_ContextObject.GetServer("xeneficope");
    m_cPhName_xerzistifrz = p_ContextObject.GetPhName("xerzistifrz");
    m_cServer_xerzistifrz = p_ContextObject.GetServer("xerzistifrz");
    m_cPhName_xerzistiope = p_ContextObject.GetPhName("xerzistiope");
    m_cServer_xerzistiope = p_ContextObject.GetServer("xerzistiope");
    m_cPhName_xlientifrz = p_ContextObject.GetPhName("xlientifrz");
    m_cServer_xlientifrz = p_ContextObject.GetServer("xlientifrz");
    m_cPhName_xlientiope = p_ContextObject.GetPhName("xlientiope");
    m_cServer_xlientiope = p_ContextObject.GetServer("xlientiope");
    m_cPhName_xnarapbo = p_ContextObject.GetPhName("xnarapbo");
    m_cServer_xnarapbo = p_ContextObject.GetServer("xnarapbo");
    m_cPhName_xntestbo = p_ContextObject.GetPhName("xntestbo");
    m_cServer_xntestbo = p_ContextObject.GetServer("xntestbo");
    m_cPhName_xoginfo = p_ContextObject.GetPhName("xoginfo");
    m_cServer_xoginfo = p_ContextObject.GetServer("xoginfo");
    m_cPhName_xogopebo = p_ContextObject.GetPhName("xogopebo");
    m_cServer_xogopebo = p_ContextObject.GetServer("xogopebo");
    m_cPhName_xogopefbo = p_ContextObject.GetPhName("xogopefbo");
    m_cServer_xogopefbo = p_ContextObject.GetServer("xogopefbo");
    m_cPhName_xperazbo = p_ContextObject.GetPhName("xperazbo");
    m_cServer_xperazbo = p_ContextObject.GetServer("xperazbo");
    m_cPhName_xraziobo = p_ContextObject.GetPhName("xraziobo");
    m_cServer_xraziobo = p_ContextObject.GetServer("xraziobo");
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
      return "arrt_imp_dati_multipli_amex";
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
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_tmp_list_imprich=null;
    try {
      /* Dichiarazione variabili del caller */
      /* w_tipodest Char(1) */
      /* gMsgProc Memo */
      /* w_impzip Numeric(1, 0) */
      /* Definizione variabili locali */
      /* fhand Char(1) */
      /* riga Memo */
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
      /* cSNAS Char(30) */
      /* cCNAS Char(30) */
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
      /* _tipper Char(1) */
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
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* Import Soggetti */
      /* gMsgProc := '' */
      gMsgProc = "";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Cicla sul file della lista e lancia la pagina appropriata */
      /* _esito := 0 */
      _esito = CPLib.Round(0,0);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry07964360status;
      nTry07964360status = m_Sql.GetTransactionStatus();
      String cTry07964360msg;
      cTry07964360msg = m_Sql.TransactionErrorMessage();
      try {
        /* If w_impzip=1 */
        if (CPLib.eqr(w_impzip,1)) {
          /* Exec "Estrai ZIP" Page 27:Page_27 */
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
              /* nomefileimport := LRTrim(tmp_list_imprich->nomefile) */
              nomefileimport = CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile"));
              /* Case At('archpers.txt',Lower(nomefileimport)) <> 0 */
              if (CPLib.ne(CPLib.At("archpers.txt",CPLib.Lower(nomefileimport)),0)) {
                /* Exec "Soggetti" Page 2:Page_2 */
                Page_2();
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
                /* Case At('archdip.txt',Lower(nomefileimport)) <> 0 */
              } else if (CPLib.ne(CPLib.At("archdip.txt",CPLib.Lower(nomefileimport)),0)) {
                /* Exec "Dipendenze" Page 14:Page_14 */
                Page_14();
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
                /* Case At('archtito.txt',Lower(nomefileimport)) <> 0 */
              } else if (CPLib.ne(CPLib.At("archtito.txt",CPLib.Lower(nomefileimport)),0)) {
                /* Exec "Titolari Effettivi" Page 15:Page_15 */
                Page_15();
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
                /* Case At('sogcli.txt',Lower(nomefileimport)) <> 0 */
              } else if (CPLib.ne(CPLib.At("sogcli.txt",CPLib.Lower(nomefileimport)),0)) {
                /* Exec "Altri Intestatari Rapporti" Page 26:Page_26 */
                Page_26();
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
                /* Case At('archrap.txt',Lower(nomefileimport)) <> 0 */
              } else if (CPLib.ne(CPLib.At("archrap.txt",CPLib.Lower(nomefileimport)),0)) {
                /* If w_tipodest = 'P' */
                if (CPLib.eqr(w_tipodest,"P")) {
                  /* Exec "Rapporti Provvisorio" Page 7:Page_7 */
                  Page_7();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                } else { // Else
                  /* Exec "Rapporti" Page 3:Page_3 */
                  Page_3();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                } // End If
                /* Case At('archinf.txt',Lower(nomefileimport)) <> 0 */
              } else if (CPLib.ne(CPLib.At("archinf.txt",CPLib.Lower(nomefileimport)),0)) {
                /* If w_tipodest = 'P' */
                if (CPLib.eqr(w_tipodest,"P")) {
                  /* Exec "Informazioni Provvisorio" Page 8:Page_8 */
                  Page_8();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                } else { // Else
                  /* Exec "Informazioni" Page 4:Page_4 */
                  Page_4();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                } // End If
                /* Case At('archope.txt',Lower(nomefileimport)) <> 0 */
              } else if (CPLib.ne(CPLib.At("archope.txt",CPLib.Lower(nomefileimport)),0)) {
                /* If w_tipodest = 'P' */
                if (CPLib.eqr(w_tipodest,"P")) {
                  /* Exec "Operazioni Provvisorio" Page 9:Page_9 */
                  Page_9();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                } else { // Else
                  /* Exec "Operazioni" Page 5:Page_5 */
                  Page_5();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                } // End If
                /* Case At('archfraz.txt',Lower(nomefileimport)) <> 0 */
              } else if (CPLib.ne(CPLib.At("archfraz.txt",CPLib.Lower(nomefileimport)),0)) {
                /* If w_tipodest = 'P' */
                if (CPLib.eqr(w_tipodest,"P")) {
                  /* Exec "Frazionarie Provvisorio" Page 10:Page_10 */
                  Page_10();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                } else { // Else
                  /* Exec "Frazionate" Page 6:Page_6 */
                  Page_6();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                } // End If
                /* Case At('intest.txt',Lower(nomefileimport)) <> 0 */
              } else if (CPLib.ne(CPLib.At("intest.txt",CPLib.Lower(nomefileimport)),0)) {
                /* If w_tipodest = 'P' */
                if (CPLib.eqr(w_tipodest,"P")) {
                  /* Exec "Intestatari Provvisorio" Page 22:Page_22 */
                  Page_22();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                } else { // Else
                  /* Exec "Intestatari" Page 19:Page_19 */
                  Page_19();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                } // End If
                /* Case At('rapage.txt',Lower(nomefileimport)) <> 0 */
              } else if (CPLib.ne(CPLib.At("rapage.txt",CPLib.Lower(nomefileimport)),0)) {
                /* Exec "Rapporti Agenzia Entrate" Page 11:Page_11 */
                Page_11();
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
                /* Case At('infage.txt',Lower(nomefileimport)) <> 0 */
              } else if (CPLib.ne(CPLib.At("infage.txt",CPLib.Lower(nomefileimport)),0)) {
                /* Exec "Informazioni Agenzia Entrate" Page 12:Page_12 */
                Page_12();
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
                /* Case At('opeage.txt',Lower(nomefileimport)) <> 0 */
              } else if (CPLib.ne(CPLib.At("opeage.txt",CPLib.Lower(nomefileimport)),0)) {
                /* Exec "Operazioni Agenzia Entrate" Page 13:Page_13 */
                Page_13();
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
                /* Case At('opex.txt',Lower(nomefileimport)) <> 0 */
              } else if (CPLib.ne(CPLib.At("opex.txt",CPLib.Lower(nomefileimport)),0)) {
                /* Exec "Operazioni extraconto" Page 16:Page_16 */
                Page_16();
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
                /* Case At('procdel.txt',Lower(nomefileimport)) <> 0 */
              } else if (CPLib.ne(CPLib.At("procdel.txt",CPLib.Lower(nomefileimport)),0)) {
                /* If w_tipodest = 'P' */
                if (CPLib.eqr(w_tipodest,"P")) {
                  /* Exec "Procuratori/delegati su rapporto Provvisorio" Page 20:Page_20 */
                  Page_20();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                } else { // Else
                  /* Exec "Procuratori/delegati su rapporto" Page 17:Page_17 */
                  Page_17();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                } // End If
                /* Case At('procage.txt',Lower(nomefileimport)) <> 0 */
              } else if (CPLib.ne(CPLib.At("procage.txt",CPLib.Lower(nomefileimport)),0)) {
                /* Exec "Procuratori/delegati su rapporto Agenzia Entrate" Page 23:Page_23 */
                Page_23();
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
                /* Case At('sogope.txt',Lower(nomefileimport)) <> 0 */
              } else if (CPLib.ne(CPLib.At("sogope.txt",CPLib.Lower(nomefileimport)),0)) {
                /* If w_tipodest = 'P' */
                if (CPLib.eqr(w_tipodest,"P")) {
                  /* Exec "Soggetti operanti Provvisorio" Page 21:Page_21 */
                  Page_21();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                } else { // Else
                  /* Exec "Soggetti operanti" Page 18:Page_18 */
                  Page_18();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                } // End If
                /* Case At('sogage.txt',Lower(nomefileimport)) <> 0 */
              } else if (CPLib.ne(CPLib.At("sogage.txt",CPLib.Lower(nomefileimport)),0)) {
                /* Exec "Soggetti operanti Agenzia Entrate" Page 24:Page_24 */
                Page_24();
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
                /* Case At('intage.txt',Lower(nomefileimport)) <> 0 */
              } else if (CPLib.ne(CPLib.At("intage.txt",CPLib.Lower(nomefileimport)),0)) {
                /* Exec "Intestatari Agenzia Entrate" Page 25:Page_25 */
                Page_25();
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
                /* Case At('sogben.txt',Lower(nomefileimport)) <> 0 */
              } else if (CPLib.ne(CPLib.At("sogben.txt",CPLib.Lower(nomefileimport)),0)) {
                /* Exec "Altri Beneficiari Operazioni" Page 28:Page_28 */
                Page_28();
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
                /* Case At('sogaltro.txt',Lower(nomefileimport)) <> 0 */
              } else if (CPLib.ne(CPLib.At("sogaltro.txt",CPLib.Lower(nomefileimport)),0)) {
                /* Exec "Altri Soggetti Operanti Operazioni" Page 29:Page_29 */
                Page_29();
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
        /* gMsgImp := 'Fine importazione dati. Inizio fase di commit. Attendere prego...' // Messaggio Import */
        gMsgImp = "Fine importazione dati. Inizio fase di commit. Attendere prego...";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
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
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry07964360status,0)) {
          m_Sql.SetTransactionStatus(nTry07964360status,cTry07964360msg);
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
      /* cNumInv := 0 */
      cNumInv = CPLib.Round(0,0);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        /* If Len(LRTrim(riga)) > 0 */
        if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
          /* _tipper := '' */
          _tipper = "";
          /* conta := conta + 1 */
          conta = CPLib.Round(conta+1,0);
          /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' nominativi del file '+nomefileimport // Messaggio Import */
          gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" nominativi del file "+nomefileimport;
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
              Error l_oErrorFault = new Error("Read on personbo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
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
          /* _tipper := iif(Empty(LRTrim(Substr(riga,288,1))),'G','P') */
          _tipper = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,288,1)))?"G":"P");
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
                Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
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
          /* Verifico se il soggetto in esame non � gi� presente l'inserisco */
          /* If Empty(LRTrim(xConnes)) */
          if (CPLib.Empty(CPLib.LRTrim(xConnes))) {
            /* nProgImp := Utilities.GetAutonumber("PRGIMPOCLI\'"+LRTrim(gAzienda)+"'",0,15) */
            nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOCLI\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
            // * --- Insert into personbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.InsertIntoStatement(m_Ctx,"personbo")+" (";
            m_cSql = m_cSql+GetFieldsName_07944D50(m_Ctx);
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
            m_cSql = m_cSql+""+CPLib.ToSQL(_tipper,"?",0,0,m_cServer)+", ";
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
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,475,3)),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,478,3)),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,481,3)),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,484,3)),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,470,5)),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.Substr(riga,487,1))?"N":CPLib.Substr(riga,487,1)),"?",0,0,m_cServer)+", ";
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
              /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per il soggetto: "+LRTrim(Substr(riga,7,70))+" con codice fiscale: "+LRTrim(Substr(riga,112,16))+NL */
              gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per il soggetto: "+CPLib.LRTrim(CPLib.Substr(riga,7,70))+" con codice fiscale: "+CPLib.LRTrim(CPLib.Substr(riga,112,16))+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              /* gMsgProc := gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
              gMsgProc = gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
            /* cNumNew := cNumNew + 1 */
            cNumNew = CPLib.Round(cNumNew+1,0);
          } else { // Else
            /* Verifico se il soggetto � una persona fisica */
            /* If Len(LRTrim(Substr(riga,112,16)))=16 */
            if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(CPLib.Substr(riga,112,16))),16)) {
              /* Verifico se � mai stato allineato e quale tipo di allineamento a subito */
              /* Case _allineatonomecnome=0 and _allineamento=0 */
              if (CPLib.eqr(_allineatonomecnome,0) && CPLib.eqr(_allineamento,0)) {
                /* Se il soggetto non � stato allineato con le procedure di allineamento sovrascrivo tutti i dati solo se la ragione sociale � diversa dalla precedente inserita */
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
                    /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per il soggetto: "+Substr(riga,7,70)+" con codice fiscale: "+Substr(riga,112,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
                    gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per il soggetto: "+CPLib.Substr(riga,7,70)+" con codice fiscale: "+CPLib.Substr(riga,112,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
                } else { // Else
                  /* cNumInv := cNumInv + 1 // Contatore record invariati */
                  cNumInv = CPLib.Round(cNumInv+1,0);
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
                    /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per il soggetto: "+Substr(riga,7,70)+" con codice fiscale: "+Substr(riga,112,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
                    gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per il soggetto: "+CPLib.Substr(riga,7,70)+" con codice fiscale: "+CPLib.Substr(riga,112,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
                    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                    /* m_cLastMsgError = "" */
                    CPLib.eqr(m_cLastMsgError,"");
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
                    /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per il soggetto: "+Substr(riga,7,70)+" con codice fiscale: "+Substr(riga,112,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
                    gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per il soggetto: "+CPLib.Substr(riga,7,70)+" con codice fiscale: "+CPLib.Substr(riga,112,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
                    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
                  /* Sovrascrivo i dati non alineati solo se la ragione sociale � diversa */
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
                    /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per il soggetto: "+Substr(riga,7,70)+" con codice fiscale: "+Substr(riga,112,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
                    gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per il soggetto: "+CPLib.Substr(riga,7,70)+" con codice fiscale: "+CPLib.Substr(riga,112,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
                    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                    /* m_cLastMsgError = "" */
                    CPLib.eqr(m_cLastMsgError,"");
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
                  /* cNumInv := cNumInv + 1 // Contatore record invariati */
                  cNumInv = CPLib.Round(cNumInv+1,0);
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
                    /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per il soggetto: "+Substr(riga,7,70)+" con codice fiscale: "+Substr(riga,112,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
                    gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per il soggetto: "+CPLib.Substr(riga,7,70)+" con codice fiscale: "+CPLib.Substr(riga,112,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
                    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
                  /* cNumInv := cNumInv + 1 // Contatore record invariati */
                  cNumInv = CPLib.Round(cNumInv+1,0);
                } // End If
              } // End Case
            } else { // Else
              /* Se non � persona fisica */
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
                  m_cSql = m_cSql+"ALLINEATO = "+CPLib.ToSQL(0,"N",1,0)+", ";
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
                    /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per il soggetto: "+Substr(riga,7,70)+" con codice fiscale: "+Substr(riga,112,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
                    gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per il soggetto: "+CPLib.Substr(riga,7,70)+" con codice fiscale: "+CPLib.Substr(riga,112,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
                    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
                      /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per il soggetto: "+Substr(riga,7,70)+" con codice fiscale: "+Substr(riga,112,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
                      gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per il soggetto: "+CPLib.Substr(riga,7,70)+" con codice fiscale: "+CPLib.Substr(riga,112,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
                      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
                  /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per il soggetto: "+Substr(riga,7,70)+" con codice fiscale: "+Substr(riga,112,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
                  gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per il soggetto: "+CPLib.Substr(riga,7,70)+" con codice fiscale: "+CPLib.Substr(riga,112,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
                  m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime())  + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' rapporti del file '+nomefileimport // Messaggio Import */
        gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" rapporti del file "+nomefileimport;
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        /* cFlagLire := '' */
        cFlagLire = "";
        /* Case Substr(riga,77,1)='S' or Substr(riga,77,1)='1' or Substr(riga,77,1)='7' */
        if (CPLib.eqr(CPLib.Substr(riga,77,1),"S") || CPLib.eqr(CPLib.Substr(riga,77,1),"1") || CPLib.eqr(CPLib.Substr(riga,77,1),"7")) {
          /* cFlagLire := '1' */
          cFlagLire = "1";
          /* Case Substr(riga,77,1)='E' or Substr(riga,77,1)='3' or Substr(riga,77,1)='5' */
        } else if (CPLib.eqr(CPLib.Substr(riga,77,1),"E") || CPLib.eqr(CPLib.Substr(riga,77,1),"3") || CPLib.eqr(CPLib.Substr(riga,77,1),"5")) {
          /* If Substr(riga,77,1) = 'E' */
          if (CPLib.eqr(CPLib.Substr(riga,77,1),"E")) {
            /* cFlagLire := '3' */
            cFlagLire = "3";
          } else { // Else
            /* cFlagLire := Substr(riga,77,1) */
            cFlagLire = CPLib.Substr(riga,77,1);
          } // End If
        } else { // Otherwise
          /* cFlagLire := Substr(riga,77,1) */
          cFlagLire = CPLib.Substr(riga,77,1);
        } // End Case
        /* xRapporto := '' */
        xRapporto = "";
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
            Error l_oErrorFault = new Error("Read on anarapbo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
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
          /* nProgImp := Utilities.GetAutonumber("PRGIMPRAP\'"+LRTrim(gAzienda)+"'",0,15) */
          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPRAP\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
          // * --- Insert into anarapbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("anarapbo");
          m_cPhName = m_Ctx.GetPhName("anarapbo");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"anarapbo")+" (";
          m_cSql = m_cSql+GetFieldsName_0773F940(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,25),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,26,50),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,76,1),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cFlagLire,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,78,3),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,81,2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,83,1)),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,84,5),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,89,5),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,94,5),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
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
            /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per il rapporto: "+Left(riga,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per il rapporto: "+CPLib.Left(riga,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
          m_cSql = m_cSql+GetFieldsName_0773F628(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,25),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,26,50),"?",0,0,m_cServer)+", ";
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
            /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per il rapporto: "+Left(riga,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per il rapporto: "+CPLib.Left(riga,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
          m_cSql = m_cSql+"FLAGLIRE = "+CPLib.ToSQL(cFlagLire,"C",1,0,m_cServer)+", ";
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
            /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per il rapporto: "+Left(riga,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per il rapporto: "+CPLib.Left(riga,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
          /* cNumMod := cNumMod + 1 */
          cNumMod = CPLib.Round(cNumMod+1,0);
        } // End If
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
    }
  }
  void Page_4() throws Exception {
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_intestbo=null;
    try {
      /* Legge il file di testo e porta i dati nella tabella */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        /* _intercod := iif(Empty(LRTrim(Substr(riga,104,11))),_codinter,Substr(riga,104,11)) */
        _intercod = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,104,11)))?_codinter:CPLib.Substr(riga,104,11));
        /* _intercit := iif(Empty(LRTrim(Substr(riga,121,30))),_citinter,Substr(riga,121,30)) */
        _intercit = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,121,30)))?_citinter:CPLib.Substr(riga,121,30));
        /* _intercab := iif(Empty(LRTrim(Substr(riga,153,6))),_cabinter,Substr(riga,153,6)) */
        _intercab = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,153,6)))?_cabinter:CPLib.Substr(riga,153,6));
        /* _interprv := iif(Empty(LRTrim(Substr(riga,151,2))),_prvinter,Substr(riga,151,2)) */
        _interprv = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,151,2)))?_prvinter:CPLib.Substr(riga,151,2));
        /* xConnes := Substr(riga,75,16) */
        xConnes = CPLib.Substr(riga,75,16);
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
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          cCli1 = Read_Cursor.GetString("CONNES");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on personbo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          cCli1 = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If Empty(LRTrim(cCli1)) */
        if (CPLib.Empty(CPLib.LRTrim(cCli1))) {
          // * --- Read from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          m_cSql = "";
          m_cSql = m_cSql+"CODFISC="+CPSql.SQLValueAdapter(CPLib.ToSQL(xConnes,"C",16,0,m_cServer),m_cServer,xConnes);
          if (m_Ctx.IsSharedTemp("personbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            cCli1 = Read_Cursor.GetString("CONNES");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on personbo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            cCli1 = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(cCli1)) */
          if (CPLib.Empty(CPLib.LRTrim(cCli1))) {
            /* cCli1 := xConnes */
            cCli1 = xConnes;
          } // End If
        } // End If
        /* xSOCTCF := '' */
        xSOCTCF = "";
        /* xSOCTCon := Substr(riga,50,16) */
        xSOCTCon = CPLib.Substr(riga,50,16);
        /* If not(Empty(LRTrim(xSOCTCon))) */
        if ( ! (CPLib.Empty(CPLib.LRTrim(xSOCTCon)))) {
          // * --- Read from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          m_cSql = "";
          m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(xSOCTCon,"C",16,0,m_cServer),m_cServer,xSOCTCon);
          if (m_Ctx.IsSharedTemp("personbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            xSOCTCF = Read_Cursor.GetString("CONNES");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on personbo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            xSOCTCF = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(xSOCTCF)) */
          if (CPLib.Empty(CPLib.LRTrim(xSOCTCF))) {
            // * --- Read from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_cSql = "";
            m_cSql = m_cSql+"CODFISC="+CPSql.SQLValueAdapter(CPLib.ToSQL(xSOCTCon,"C",16,0,m_cServer),m_cServer,xSOCTCon);
            if (m_Ctx.IsSharedTemp("personbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              xSOCTCF = Read_Cursor.GetString("CONNES");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on personbo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              xSOCTCF = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(LRTrim(xSOCTCF)) */
            if (CPLib.Empty(CPLib.LRTrim(xSOCTCF))) {
              /* xSOCTCF := xSOCTCon */
              xSOCTCF = xSOCTCon;
            } // End If
          } // End If
        } // End If
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        /* gMsgImp := 'Sono stati elaborate '+LRTrim(Str(conta,10,0))+' informazioni del file '+nomefileimport // Messaggio Import */
        gMsgImp = "Sono stati elaborate "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" informazioni del file "+nomefileimport;
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* Case Substr(riga,46,1)='S' or Substr(riga,46,1)='1' or Substr(riga,46,1)='7' */
        if (CPLib.eqr(CPLib.Substr(riga,46,1),"S") || CPLib.eqr(CPLib.Substr(riga,46,1),"1") || CPLib.eqr(CPLib.Substr(riga,46,1),"7")) {
          /* cFlagLire := '1' */
          cFlagLire = "1";
          /* Case Substr(riga,46,1)='E' or Substr(riga,46,1)='3' or Substr(riga,46,1)='5' */
        } else if (CPLib.eqr(CPLib.Substr(riga,46,1),"E") || CPLib.eqr(CPLib.Substr(riga,46,1),"3") || CPLib.eqr(CPLib.Substr(riga,46,1),"5")) {
          /* If Substr(riga,46,1) = 'E' */
          if (CPLib.eqr(CPLib.Substr(riga,46,1),"E")) {
            /* cFlagLire := '3' */
            cFlagLire = "3";
          } else { // Else
            /* cFlagLire := Substr(riga,46,1) */
            cFlagLire = CPLib.Substr(riga,46,1);
          } // End If
        } else { // Otherwise
          /* cFlagLire := Substr(riga,46,1) */
          cFlagLire = CPLib.Substr(riga,46,1);
        } // End Case
        /* Verifico la presenza dell'_unicode per evitare duplicazioni di informazioni diverse con lo stesso _unicode */
        /* _unicode := '' */
        _unicode = "";
        /* If Len(LRTrim(Substr(riga,159,10))) > 0 */
        if (CPLib.gt(CPLib.Len(CPLib.LRTrim(CPLib.Substr(riga,159,10))),0)) {
          // * --- Read from rapopebo
          m_cServer = m_Ctx.GetServer("rapopebo");
          m_cPhName = m_Ctx.GetPhName("rapopebo");
          m_cSql = "";
          m_cSql = m_cSql+"UNIQUECODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,159,10),"C",10,0,m_cServer),m_cServer,CPLib.Substr(riga,159,10));
          if (m_Ctx.IsSharedTemp("rapopebo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("UNIQUECODE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _unicode = Read_Cursor.GetString("UNIQUECODE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on rapopebo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _unicode = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If _unicode<>'' */
          if (CPLib.ne(_unicode,"")) {
            /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per l'informazione in data "+CharToDate(Right(Left(riga,8),4)+Substr(Left(riga,8),3,2)+Left(Left(riga,8),2))+" relativa al rapporto: "+Substr(riga,9,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per l'informazione in data "+CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2))+" relativa al rapporto: "+CPLib.Substr(riga,9,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            // Exit Loop
            if (true) {
              break;
            }
          } // End If
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
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"rapopebo")+" (";
        m_cSql = m_cSql+GetFieldsName_077CDB18(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,115,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQLNull(xSOCTCF,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(CPLib.Substr(riga,36,8),4)+CPLib.Substr(CPLib.Substr(riga,36,8),3,2)+CPLib.Left(CPLib.Substr(riga,36,8),2)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,169,50),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cFlagLire,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,34,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,8)+cInfProg1+"0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.Substr(riga,44,2),1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,9,25),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,102,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,35,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,44,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,159,10),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,47,3),"?",0,0,m_cServer)+", ";
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
          /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per l'informazione in data "+CharToDate(Right(Left(riga,8),4)+Substr(Left(riga,8),3,2)+Left(Left(riga,8),2))+" relativa al rapporto: "+Substr(riga,9,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
          gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per l'informazione in data "+CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2))+" relativa al rapporto: "+CPLib.Substr(riga,9,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
        /* cNumNew := cNumNew+1 */
        cNumNew = CPLib.Round(cNumNew+1,0);
        /* cMaxRow := 0 */
        cMaxRow = CPLib.Round(0,0);
        /* cNumMod := 0 */
        cNumMod = CPLib.Round(0,0);
        // * --- Select from intestbo
        m_cServer = m_Ctx.GetServer("intestbo");
        m_cPhName = m_Ctx.GetPhName("intestbo");
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
        Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,9,25),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Substr(riga,9,25))+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM ",m_cServer,m_Ctx,true));
        while ( ! (Cursor_intestbo.Eof())) {
          /* If intestbo->CODINTER=cCli1 */
          if (CPLib.eqr(Cursor_intestbo.GetString("CODINTER"),cCli1)) {
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
          /* nProgImp2 := Utilities.GetAutonumber("PRGIMPSOG\'"+LRTrim(gAzienda)+"'",0,15) */
          nProgImp2 = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPSOG\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
          // * --- Insert into intestbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("intestbo");
          m_cPhName = m_Ctx.GetPhName("intestbo");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"intestbo")+" (";
          m_cSql = m_cSql+GetFieldsName_077D6A40(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow+1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2)),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.Substr(riga,44,2),"25") || CPLib.eqr(CPLib.Substr(riga,44,2),"28")?"D":"P"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(cCli1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,9,25),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,34,1),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,8)+cInfProg2+"0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cCli1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp2,"?",0,0)+", ";
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
            /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario dell'informazione in data "+CharToDate(Right(Left(riga,8),4)+Substr(Left(riga,8),3,2)+Left(Left(riga,8),2))+" relativa al rapporto: "+Substr(riga,9,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario dell'informazione in data "+CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2))+" relativa al rapporto: "+CPLib.Substr(riga,9,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
        } else { // Else
          /* If Substr(riga,44,2)='23' */
          if (CPLib.eqr(CPLib.Substr(riga,44,2),"23")) {
            // * --- Write into intestbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = "Update "+m_cPhName+" set ";
            m_cSql = m_cSql+"DATAINI = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2)),"D",8,0)+", ";
            m_cSql = m_cSql+"NUMPROG1 = "+CPLib.ToSQL(cInfProg2,"C",11,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,9,25),"?",0,0,m_cServer),m_cServer,CPLib.Substr(riga,9,25))+"";
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
              /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario dell'informazione in data "+CharToDate(Right(Left(riga,8),4)+Substr(Left(riga,8),3,2)+Left(Left(riga,8),2))+" relativa al rapporto: "+Substr(riga,9,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
              gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario dell'informazione in data "+CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2))+" relativa al rapporto: "+CPLib.Substr(riga,9,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
            /* ElseIf Substr(riga,44,2)='26' */
          } else if (CPLib.eqr(CPLib.Substr(riga,44,2),"26")) {
            // * --- Write into intestbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = "Update "+m_cPhName+" set ";
            m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2)),"D",8,0)+", ";
            m_cSql = m_cSql+"NUMPROG2 = "+CPLib.ToSQL(cInfProg2,"C",11,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,9,25),"?",0,0,m_cServer),m_cServer,CPLib.Substr(riga,9,25))+"";
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
              /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario dell'informazione in data "+CharToDate(Right(Left(riga,8),4)+Substr(Left(riga,8),3,2)+Left(Left(riga,8),2))+" relativa al rapporto: "+Substr(riga,9,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
              gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario dell'informazione in data "+CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2))+" relativa al rapporto: "+CPLib.Substr(riga,9,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
        } // End If
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* gMsgProc := gMsgProc + 'Informazione Inserite: '+LRTrim(Str(cNumNew,10,0)) + NL */
      gMsgProc = gMsgProc+"Informazione Inserite: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
    }
  }
  void Page_5() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* Legge il file di testo e porta i dati nella tabella */
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        /* _intercod := iif(Empty(LRTrim(Substr(riga,246,11))),_codinter,Substr(riga,246,11)) */
        _intercod = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,246,11)))?_codinter:CPLib.Substr(riga,246,11));
        /* _intercit := iif(Empty(LRTrim(Substr(riga,263,30))),_citinter,Substr(riga,263,30)) */
        _intercit = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,263,30)))?_citinter:CPLib.Substr(riga,263,30));
        /* _intercab := iif(Empty(LRTrim(Substr(riga,295,6))),_cabinter,Substr(riga,295,6)) */
        _intercab = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,295,6)))?_cabinter:CPLib.Substr(riga,295,6));
        /* _interprv := iif(Empty(LRTrim(Substr(riga,293,2))),_prvinter,Substr(riga,293,2)) */
        _interprv = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,293,2)))?_prvinter:CPLib.Substr(riga,293,2));
        /* If not(Empty(LRTrim(Substr(riga,257,6)))) */
        if ( ! (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,257,6))))) {
          /* If Empty(LRTrim(Substr(riga,263,30))+LRTrim(Substr(riga,295,6))+LRTrim(Substr(riga,293,2))) */
          if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,263,30))+CPLib.LRTrim(CPLib.Substr(riga,295,6))+CPLib.LRTrim(CPLib.Substr(riga,293,2)))) {
            // * --- Read from anadip
            m_cServer = m_Ctx.GetServer("anadip");
            m_cPhName = m_Ctx.GetPhName("anadip");
            m_cSql = "";
            m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,257,6),"C",6,0,m_cServer),m_cServer,CPLib.Substr(riga,257,6));
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
                Error l_oErrorFault = new Error("Read on anadip into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
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
        /* If Len(LRTrim(Substr(riga,318,10))) > 0 */
        if (CPLib.gt(CPLib.Len(CPLib.LRTrim(CPLib.Substr(riga,318,10))),0)) {
          // * --- Read from operazbo
          m_cServer = m_Ctx.GetServer("operazbo");
          m_cPhName = m_Ctx.GetPhName("operazbo");
          m_cSql = "";
          m_cSql = m_cSql+"UNIQUECODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,318,10),"C",10,0,m_cServer),m_cServer,CPLib.Substr(riga,318,10));
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
              Error l_oErrorFault = new Error("Read on operazbo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _unicode = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Len(LRTrim(_unicode)) > 0 */
          if (CPLib.gt(CPLib.Len(CPLib.LRTrim(_unicode)),0)) {
            /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per l'operazione in data "+CharToDate(Right(Left(riga,8),4)+Substr(Left(riga,8),3,2)+Left(Left(riga,8),2))+" con importo "+Str((Val(Substr(riga,160,15)))/100,14,2)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per l'operazione in data "+CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2))+" con importo "+CPLib.Str((CPLib.Val(CPLib.Substr(riga,160,15)))/100,14,2)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            // Exit Loop
            if (true) {
              break;
            }
          } // End If
        } // End If
        /* cOpeProg1 := Utilities.GetAutonumber("POPERAZ1\'"+LRTrim(gAzienda)+"'",'',10) */
        cOpeProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
        /* cOpeProg2 := Utilities.GetAutonumber("POPERAZ2\'"+LRTrim(gAzienda)+"'",'',11) */
        cOpeProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
        /* Case Substr(riga,155,1)='S' or Substr(riga,155,1)='1' or Substr(riga,155,1)='7' */
        if (CPLib.eqr(CPLib.Substr(riga,155,1),"S") || CPLib.eqr(CPLib.Substr(riga,155,1),"1") || CPLib.eqr(CPLib.Substr(riga,155,1),"7")) {
          /* cFlagLire := '1' */
          cFlagLire = "1";
          /* Case Substr(riga,155,1)='E' or Substr(riga,155,1)='3' or Substr(riga,155,1)='5' */
        } else if (CPLib.eqr(CPLib.Substr(riga,155,1),"E") || CPLib.eqr(CPLib.Substr(riga,155,1),"3") || CPLib.eqr(CPLib.Substr(riga,155,1),"5")) {
          /* If Substr(riga,155,1) = 'E' */
          if (CPLib.eqr(CPLib.Substr(riga,155,1),"E")) {
            /* cFlagLire := '3' */
            cFlagLire = "3";
          } else { // Else
            /* cFlagLire := Substr(riga,155,1) */
            cFlagLire = CPLib.Substr(riga,155,1);
          } // End If
        } else { // Otherwise
          /* cFlagLire := Substr(riga,155,1) */
          cFlagLire = CPLib.Substr(riga,155,1);
        } // End Case
        /* cFlagCont := iif(Substr(riga,9,1)='1' or Substr(riga,9,1)='S','1','0')  */
        cFlagCont = (CPLib.eqr(CPLib.Substr(riga,9,1),"1") || CPLib.eqr(CPLib.Substr(riga,9,1),"S")?"1":"0");
        /* cFlagFraz := iif(Empty(Substr(riga,301,1)),'0',Substr(riga,301,1)) */
        cFlagFraz = (CPLib.Empty(CPLib.Substr(riga,301,1))?"0":CPLib.Substr(riga,301,1));
        /* cIdCau := '' */
        cIdCau = "";
        // * --- Read from tbcauana
        m_cServer = m_Ctx.GetServer("tbcauana");
        m_cPhName = m_Ctx.GetPhName("tbcauana");
        m_cSql = "";
        m_cSql = m_cSql+"CODCAU="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,10,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(riga,10,4));
        m_cSql = m_cSql+" and CAUSINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,14,2),"C",2,0,m_cServer),m_cServer,CPLib.Substr(riga,14,2));
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
            Error l_oErrorFault = new Error("Read on tbcauana into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          cIdCau = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* nProgImp := Utilities.GetAutonumber("PRGIMPOPE\'"+LRTrim(gAzienda)+"'",0,15) */
        nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOPE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        /* gMsgImp := 'Sono stati elaborate '+LRTrim(Str(conta,10,0))+' operazioni del file '+nomefileimport // Messaggio Import */
        gMsgImp = "Sono stati elaborate "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" operazioni del file "+nomefileimport;
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _benrag := Substr(riga,511,70) */
        _benrag = CPLib.Substr(riga,511,70);
        /* _bensta := Substr(riga,581,3) */
        _bensta = CPLib.Substr(riga,581,3);
        /* _bencta := Substr(riga,584,30) */
        _bencta = CPLib.Substr(riga,584,30);
        /* _bencab := Substr(riga,614,6) */
        _bencab = CPLib.Substr(riga,614,6);
        /* _benprv := Substr(riga,620,2) */
        _benprv = CPLib.Substr(riga,620,2);
        /* _benind := Substr(riga,622,35) */
        _benind = CPLib.Substr(riga,622,35);
        /* _bencap := Substr(riga,657,5) */
        _bencap = CPLib.Substr(riga,657,5);
        /* If not(Empty(LRTrim(Substr(riga,302,16)))) and Empty(LRTrim(_benrag+_bensta+_bencta+_bencab+_benprv+_benind+_bencap)) */
        if ( ! (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,302,16)))) && CPLib.Empty(CPLib.LRTrim(_benrag+_bensta+_bencta+_bencab+_benprv+_benind+_bencap))) {
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
          m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,302,16),"C",16,0,m_cServer),m_cServer,CPLib.Substr(riga,302,16));
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
              Error l_oErrorFault = new Error("Read on personbo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
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
        m_cSql = m_cSql+GetFieldsName_062E40E8(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,454,5),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,419,5),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_bencab,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_bencap,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_bencta,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_benind,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_benprv,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_benrag,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,762,25),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_bensta,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,222,9))/10000,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right(CPLib.Substr(riga,147,8),4)+CPLib.Substr(CPLib.Substr(riga,147,8),3,2)+CPLib.Left(CPLib.Substr(riga,147,8),2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,10,4),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,64,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,257,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,18,11),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,14,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,484,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,302,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,190,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,206,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(CPLib.Substr(riga,500,8),4)+CPLib.Substr(CPLib.Substr(riga,500,8),3,2)+CPLib.Left(CPLib.Substr(riga,500,8),2)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(CPLib.Substr(riga,147,8),4)+CPLib.Substr(CPLib.Substr(riga,147,8),3,2)+CPLib.Left(CPLib.Substr(riga,147,8),2)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,32,30),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,70,50),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,459,5),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cFlagCont,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cFlagFraz,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cFlagLire,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,145,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cIdCau,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2)+cOpeProg2+"S","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,331,9),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,414,5),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,662,50),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,328,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,29,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,812,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,62,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,409,5),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,787,25),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,120,25),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,475,3)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,472,3)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,481,3)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,478,3)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,469,3)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,508,3)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,712,50),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,159,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,464,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,16,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,244,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,146,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,242,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,175,15)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,160,15)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,318,10),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,156,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,340,69),"?",0,0,m_cServer)+", ";
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
          /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per l'operazione in data "+CharToDate(Right(Left(riga,8),4)+Substr(Left(riga,8),3,2)+Left(Left(riga,8),2))+" con importo "+Str((Val(Substr(riga,160,15)))/100,14,2)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
          gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per l'operazione in data "+CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2))+" con importo "+CPLib.Str((CPLib.Val(CPLib.Substr(riga,160,15)))/100,14,2)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
        /* cNumNew := cNumNew + 1 */
        cNumNew = CPLib.Round(cNumNew+1,0);
      } // End While
      /* gMsgProc := gMsgProc + 'Operazioni Inserite: '+LRTrim(Str(cNumNew,10,0)) + NL */
      gMsgProc = gMsgProc+"Operazioni Inserite: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
    }
  }
  void Page_6() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* Legge il file di testo e porta i dati nella tabella */
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        /* _intercod := iif(Empty(LRTrim(Substr(riga,246,11))),_codinter,Substr(riga,246,11)) */
        _intercod = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,246,11)))?_codinter:CPLib.Substr(riga,246,11));
        /* _intercit := iif(Empty(LRTrim(Substr(riga,263,30))),_citinter,Substr(riga,263,30)) */
        _intercit = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,263,30)))?_citinter:CPLib.Substr(riga,263,30));
        /* _intercab := iif(Empty(LRTrim(Substr(riga,295,6))),_cabinter,Substr(riga,295,6)) */
        _intercab = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,295,6)))?_cabinter:CPLib.Substr(riga,295,6));
        /* _interprv := iif(Empty(LRTrim(Substr(riga,293,2))),_prvinter,Substr(riga,293,2)) */
        _interprv = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,293,2)))?_prvinter:CPLib.Substr(riga,293,2));
        /* If not(Empty(LRTrim(Substr(riga,257,6)))) */
        if ( ! (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,257,6))))) {
          /* If Empty(LRTrim(Substr(riga,263,30))+LRTrim(Substr(riga,295,6))+LRTrim(Substr(riga,293,2))) */
          if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,263,30))+CPLib.LRTrim(CPLib.Substr(riga,295,6))+CPLib.LRTrim(CPLib.Substr(riga,293,2)))) {
            // * --- Read from anadip
            m_cServer = m_Ctx.GetServer("anadip");
            m_cPhName = m_Ctx.GetPhName("anadip");
            m_cSql = "";
            m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,257,6),"C",6,0,m_cServer),m_cServer,CPLib.Substr(riga,257,6));
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
                Error l_oErrorFault = new Error("Read on anadip into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
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
        /* If Len(LRTrim(Substr(riga,318,10))) > 0 */
        if (CPLib.gt(CPLib.Len(CPLib.LRTrim(CPLib.Substr(riga,318,10))),0)) {
          // * --- Read from fraziobo
          m_cServer = m_Ctx.GetServer("fraziobo");
          m_cPhName = m_Ctx.GetPhName("fraziobo");
          m_cSql = "";
          m_cSql = m_cSql+"UNIQUECODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,318,10),"C",10,0,m_cServer),m_cServer,CPLib.Substr(riga,318,10));
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
              Error l_oErrorFault = new Error("Read on fraziobo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _unicode = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Len(LRTrim(_unicode)) > 0 */
          if (CPLib.gt(CPLib.Len(CPLib.LRTrim(_unicode)),0)) {
            /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per l'operazione in data "+CharToDate(Right(Left(riga,8),4)+Substr(Left(riga,8),3,2)+Left(Left(riga,8),2))+" con importo "+Str((Val(Substr(riga,160,15)))/100,14,2)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per l'operazione in data "+CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2))+" con importo "+CPLib.Str((CPLib.Val(CPLib.Substr(riga,160,15)))/100,14,2)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            // Exit Loop
            if (true) {
              break;
            }
          } // End If
        } // End If
        /* cOpeProg1 := Utilities.GetAutonumber("PFRAZIO1\'"+LRTrim(gAzienda)+"'",'',10) */
        cOpeProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PFRAZIO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
        /* cOpeProg2 := Utilities.GetAutonumber("PFRAZIO2\'"+LRTrim(gAzienda)+"'",'',11) */
        cOpeProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PFRAZIO2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
        /* Case Substr(riga,155,1)='S' or Substr(riga,155,1)='1' or Substr(riga,155,1)='7' */
        if (CPLib.eqr(CPLib.Substr(riga,155,1),"S") || CPLib.eqr(CPLib.Substr(riga,155,1),"1") || CPLib.eqr(CPLib.Substr(riga,155,1),"7")) {
          /* cFlagLire := '1' */
          cFlagLire = "1";
          /* Case Substr(riga,155,1)='E' or Substr(riga,155,1)='3' or Substr(riga,155,1)='5' */
        } else if (CPLib.eqr(CPLib.Substr(riga,155,1),"E") || CPLib.eqr(CPLib.Substr(riga,155,1),"3") || CPLib.eqr(CPLib.Substr(riga,155,1),"5")) {
          /* If Substr(riga,155,1) = 'E' */
          if (CPLib.eqr(CPLib.Substr(riga,155,1),"E")) {
            /* cFlagLire := '3' */
            cFlagLire = "3";
          } else { // Else
            /* cFlagLire := Substr(riga,155,1) */
            cFlagLire = CPLib.Substr(riga,155,1);
          } // End If
        } else { // Otherwise
          /* cFlagLire := Substr(riga,155,1) */
          cFlagLire = CPLib.Substr(riga,155,1);
        } // End Case
        /* cFlagCont := iif(Substr(riga,9,1)='1' or Substr(riga,9,1)='S','1','0')  */
        cFlagCont = (CPLib.eqr(CPLib.Substr(riga,9,1),"1") || CPLib.eqr(CPLib.Substr(riga,9,1),"S")?"1":"0");
        /* cFlagFraz := iif(Empty(Substr(riga,301,1)),'0',Substr(riga,301,1)) */
        cFlagFraz = (CPLib.Empty(CPLib.Substr(riga,301,1))?"0":CPLib.Substr(riga,301,1));
        /* cIdCau := '' */
        cIdCau = "";
        // * --- Read from tbcauana
        m_cServer = m_Ctx.GetServer("tbcauana");
        m_cPhName = m_Ctx.GetPhName("tbcauana");
        m_cSql = "";
        m_cSql = m_cSql+"CODCAU="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,10,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(riga,10,4));
        m_cSql = m_cSql+" and CAUSINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,14,2),"C",2,0,m_cServer),m_cServer,CPLib.Substr(riga,14,2));
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
            Error l_oErrorFault = new Error("Read on tbcauana into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          cIdCau = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* nProgImp := Utilities.GetAutonumber("PRGIMPFRZ\'"+LRTrim(gAzienda)+"'",0,15) */
        nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPFRZ\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        /* gMsgImp := 'Sono stati elaborate '+LRTrim(Str(conta,10,0))+' frazionate del file '+nomefileimport // Messaggio Import */
        gMsgImp = "Sono stati elaborate "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" frazionate del file "+nomefileimport;
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _benrag := Substr(riga,511,70) */
        _benrag = CPLib.Substr(riga,511,70);
        /* _bensta := Substr(riga,581,3) */
        _bensta = CPLib.Substr(riga,581,3);
        /* _bencta := Substr(riga,584,30) */
        _bencta = CPLib.Substr(riga,584,30);
        /* _bencab := Substr(riga,614,6) */
        _bencab = CPLib.Substr(riga,614,6);
        /* _benprv := Substr(riga,620,2) */
        _benprv = CPLib.Substr(riga,620,2);
        /* _benind := Substr(riga,622,35) */
        _benind = CPLib.Substr(riga,622,35);
        /* _bencap := Substr(riga,657,5) */
        _bencap = CPLib.Substr(riga,657,5);
        /* If not(Empty(LRTrim(Substr(riga,302,16)))) and Empty(LRTrim(_benrag+_bensta+_bencta+_bencab+_benprv+_benind+_bencap)) */
        if ( ! (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,302,16)))) && CPLib.Empty(CPLib.LRTrim(_benrag+_bensta+_bencta+_bencab+_benprv+_benind+_bencap))) {
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
          m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,302,16),"C",16,0,m_cServer),m_cServer,CPLib.Substr(riga,302,16));
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
              Error l_oErrorFault = new Error("Read on personbo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
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
        m_cSql = m_cSql+GetFieldsName_0634EF58(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,454,5),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,419,5),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_bencab,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_bencap,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_bencta,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_benind,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_benprv,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_benrag,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,762,25),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_bensta,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,222,9))/10000,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right(CPLib.Substr(riga,147,8),4)+CPLib.Substr(CPLib.Substr(riga,147,8),3,2)+CPLib.Left(CPLib.Substr(riga,147,8),2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,10,4),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,64,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,257,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,18,11),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,14,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,484,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,302,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,190,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,206,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(CPLib.Substr(riga,500,8),4)+CPLib.Substr(CPLib.Substr(riga,500,8),3,2)+CPLib.Left(CPLib.Substr(riga,500,8),2)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(CPLib.Substr(riga,147,8),4)+CPLib.Substr(CPLib.Substr(riga,147,8),3,2)+CPLib.Left(CPLib.Substr(riga,147,8),2)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,32,30),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,70,50),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,459,5),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cFlagCont,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cFlagFraz,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cFlagLire,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,145,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cIdCau,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2)+cOpeProg2+"Z","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,331,9),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,414,5),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,662,50),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,328,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,29,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,812,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,62,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,409,5),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,787,25),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,120,25),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,475,3)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,472,3)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,481,3)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,478,3)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,469,3)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,508,3)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,712,50),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,159,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,464,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,16,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,244,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,146,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,242,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,175,15)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,160,15)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,318,10),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,156,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,340,69),"?",0,0,m_cServer)+", ";
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
          /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per l'operazione in data "+CharToDate(Right(Left(riga,8),4)+Substr(Left(riga,8),3,2)+Left(Left(riga,8),2))+" con importo "+Str((Val(Substr(riga,160,15)))/100,14,2)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
          gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per l'operazione in data "+CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2))+" con importo "+CPLib.Str((CPLib.Val(CPLib.Substr(riga,160,15)))/100,14,2)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
        /* cNumNew := cNumNew + 1 */
        cNumNew = CPLib.Round(cNumNew+1,0);
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* gMsgProc := gMsgProc + 'Frazionate Inserite: '+LRTrim(Str(cNumNew,10,0)) + NL */
      gMsgProc = gMsgProc+"Frazionate Inserite: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' rapporti del file '+nomefileimport // Messaggio Import */
        gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" rapporti del file "+nomefileimport;
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        /* cFlagLire := '' */
        cFlagLire = "";
        /* Case Substr(riga,77,1)='S' or Substr(riga,77,1)='1' or Substr(riga,77,1)='7' */
        if (CPLib.eqr(CPLib.Substr(riga,77,1),"S") || CPLib.eqr(CPLib.Substr(riga,77,1),"1") || CPLib.eqr(CPLib.Substr(riga,77,1),"7")) {
          /* cFlagLire := '1' */
          cFlagLire = "1";
          /* Case Substr(riga,77,1)='E' or Substr(riga,77,1)='3' or Substr(riga,77,1)='5' */
        } else if (CPLib.eqr(CPLib.Substr(riga,77,1),"E") || CPLib.eqr(CPLib.Substr(riga,77,1),"3") || CPLib.eqr(CPLib.Substr(riga,77,1),"5")) {
          /* If Substr(riga,77,1) = 'E' */
          if (CPLib.eqr(CPLib.Substr(riga,77,1),"E")) {
            /* cFlagLire := '3' */
            cFlagLire = "3";
          } else { // Else
            /* cFlagLire := Substr(riga,77,1) */
            cFlagLire = CPLib.Substr(riga,77,1);
          } // End If
        } else { // Otherwise
          /* cFlagLire := Substr(riga,77,1) */
          cFlagLire = CPLib.Substr(riga,77,1);
        } // End Case
        /* xRapporto := '' */
        xRapporto = "";
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
            Error l_oErrorFault = new Error("Read on xnarapbo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
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
          /* nProgImp := Utilities.GetAutonumber("PRGIMPRAP\'"+LRTrim(gAzienda)+"'",0,15) */
          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPRAP\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
          // * --- Insert into xnarapbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xnarapbo");
          m_cPhName = m_Ctx.GetPhName("xnarapbo");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"xnarapbo")+" (";
          m_cSql = m_cSql+GetFieldsName_07CEAAD0(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,25),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,26,50),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,76,1),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cFlagLire,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,78,3),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,81,2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,83,1)),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,84,5),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,89,5),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,94,5),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
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
            /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per il rapporto: "+Left(riga,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per il rapporto: "+CPLib.Left(riga,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
          m_cSql = m_cSql+GetFieldsName_05CB8230(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,25),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,26,50),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("P","?",0,0,m_cServer)+", ";
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
            /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per il rapporto: "+Left(riga,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per il rapporto: "+CPLib.Left(riga,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
          m_cSql = m_cSql+"FLAGLIRE = "+CPLib.ToSQL(cFlagLire,"C",1,0,m_cServer)+", ";
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
            /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per il rapporto: "+Left(riga,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per il rapporto: "+CPLib.Left(riga,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
          /* cNumMod := cNumMod + 1 */
          cNumMod = CPLib.Round(cNumMod+1,0);
        } // End If
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* gMsgProc := gMsgProc + 'Rapporti Inseriti: '+LRTrim(Str(cNumNew,10,0)) + " - Rapporti Aggiornati: "+LRTrim(Str(cNumMod,10,0)) + NL */
      gMsgProc = gMsgProc+"Rapporti Inseriti: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+" - Rapporti Aggiornati: "+CPLib.LRTrim(CPLib.Str(cNumMod,10,0))+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
    }
  }
  void Page_8() throws Exception {
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_xntestbo=null;
    try {
      /* Legge il file di testo e porta i dati nella tabella */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        /* _intercod := iif(Empty(LRTrim(Substr(riga,104,11))),_codinter,Substr(riga,104,11)) */
        _intercod = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,104,11)))?_codinter:CPLib.Substr(riga,104,11));
        /* _intercit := iif(Empty(LRTrim(Substr(riga,121,30))),_citinter,Substr(riga,121,30)) */
        _intercit = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,121,30)))?_citinter:CPLib.Substr(riga,121,30));
        /* _intercab := iif(Empty(LRTrim(Substr(riga,153,6))),_cabinter,Substr(riga,153,6)) */
        _intercab = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,153,6)))?_cabinter:CPLib.Substr(riga,153,6));
        /* _interprv := iif(Empty(LRTrim(Substr(riga,151,2))),_prvinter,Substr(riga,151,2)) */
        _interprv = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,151,2)))?_prvinter:CPLib.Substr(riga,151,2));
        /* xConnes := Substr(riga,75,16) */
        xConnes = CPLib.Substr(riga,75,16);
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
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          cCli1 = Read_Cursor.GetString("CONNES");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on personbo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          cCli1 = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If Empty(LRTrim(cCli1)) */
        if (CPLib.Empty(CPLib.LRTrim(cCli1))) {
          // * --- Read from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          m_cSql = "";
          m_cSql = m_cSql+"CODFISC="+CPSql.SQLValueAdapter(CPLib.ToSQL(xConnes,"C",16,0,m_cServer),m_cServer,xConnes);
          if (m_Ctx.IsSharedTemp("personbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            cCli1 = Read_Cursor.GetString("CONNES");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on personbo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            cCli1 = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(cCli1)) */
          if (CPLib.Empty(CPLib.LRTrim(cCli1))) {
            /* cCli1 := xConnes */
            cCli1 = xConnes;
          } // End If
        } // End If
        /* xSOCTCF := '' */
        xSOCTCF = "";
        /* xSOCTCon := Substr(riga,50,16) */
        xSOCTCon = CPLib.Substr(riga,50,16);
        /* If not(Empty(LRTrim(xSOCTCon))) */
        if ( ! (CPLib.Empty(CPLib.LRTrim(xSOCTCon)))) {
          // * --- Read from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          m_cSql = "";
          m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(xSOCTCon,"C",16,0,m_cServer),m_cServer,xSOCTCon);
          if (m_Ctx.IsSharedTemp("personbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            xSOCTCF = Read_Cursor.GetString("CONNES");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on personbo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            xSOCTCF = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(xSOCTCF)) */
          if (CPLib.Empty(CPLib.LRTrim(xSOCTCF))) {
            // * --- Read from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_cSql = "";
            m_cSql = m_cSql+"CODFISC="+CPSql.SQLValueAdapter(CPLib.ToSQL(xSOCTCon,"C",16,0,m_cServer),m_cServer,xSOCTCon);
            if (m_Ctx.IsSharedTemp("personbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              xSOCTCF = Read_Cursor.GetString("CONNES");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on personbo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              xSOCTCF = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(LRTrim(xSOCTCF)) */
            if (CPLib.Empty(CPLib.LRTrim(xSOCTCF))) {
              /* xSOCTCF := xSOCTCon */
              xSOCTCF = xSOCTCon;
            } // End If
          } // End If
        } // End If
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        /* gMsgImp := 'Sono stati elaborate '+LRTrim(Str(conta,10,0))+' informazioni del file '+nomefileimport // Messaggio Import */
        gMsgImp = "Sono stati elaborate "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" informazioni del file "+nomefileimport;
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* Case Substr(riga,46,1)='S' or Substr(riga,46,1)='1' or Substr(riga,46,1)='7' */
        if (CPLib.eqr(CPLib.Substr(riga,46,1),"S") || CPLib.eqr(CPLib.Substr(riga,46,1),"1") || CPLib.eqr(CPLib.Substr(riga,46,1),"7")) {
          /* cFlagLire := '1' */
          cFlagLire = "1";
          /* Case Substr(riga,46,1)='E' or Substr(riga,46,1)='3' or Substr(riga,46,1)='5' */
        } else if (CPLib.eqr(CPLib.Substr(riga,46,1),"E") || CPLib.eqr(CPLib.Substr(riga,46,1),"3") || CPLib.eqr(CPLib.Substr(riga,46,1),"5")) {
          /* If Substr(riga,46,1) = 'E' */
          if (CPLib.eqr(CPLib.Substr(riga,46,1),"E")) {
            /* cFlagLire := '3' */
            cFlagLire = "3";
          } else { // Else
            /* cFlagLire := Substr(riga,46,1) */
            cFlagLire = CPLib.Substr(riga,46,1);
          } // End If
        } else { // Otherwise
          /* cFlagLire := Substr(riga,46,1) */
          cFlagLire = CPLib.Substr(riga,46,1);
        } // End Case
        /* Verifico la presenza dell'_unicode per evitare duplicazioni di informazioni diverse con lo stesso _unicode */
        /* _unicode := '' */
        _unicode = "";
        /* If Len(LRTrim(Substr(riga,159,10))) > 0 */
        if (CPLib.gt(CPLib.Len(CPLib.LRTrim(CPLib.Substr(riga,159,10))),0)) {
          // * --- Read from xapopebo
          m_cServer = m_Ctx.GetServer("xapopebo");
          m_cPhName = m_Ctx.GetPhName("xapopebo");
          m_cSql = "";
          m_cSql = m_cSql+"UNIQUECODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,159,10),"C",10,0,m_cServer),m_cServer,CPLib.Substr(riga,159,10));
          if (m_Ctx.IsSharedTemp("xapopebo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("UNIQUECODE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _unicode = Read_Cursor.GetString("UNIQUECODE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on xapopebo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _unicode = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If _unicode<>'' */
          if (CPLib.ne(_unicode,"")) {
            /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per l'informazione in data "+CharToDate(Right(Left(riga,8),4)+Substr(Left(riga,8),3,2)+Left(Left(riga,8),2))+" relativa al rapporto: "+Substr(riga,9,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per l'informazione in data "+CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2))+" relativa al rapporto: "+CPLib.Substr(riga,9,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            // Exit Loop
            if (true) {
              break;
            }
          } // End If
        } // End If
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
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"xapopebo")+" (";
        m_cSql = m_cSql+GetFieldsName_05BC49B0(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_cabinter,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,115,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(xSOCTCF,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(CPLib.Substr(riga,36,8),4)+CPLib.Substr(CPLib.Substr(riga,36,8),3,2)+CPLib.Left(CPLib.Substr(riga,36,8),2)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,169,50),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cFlagLire,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,34,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,8)+cInfProg1+"0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.Substr(riga,44,2),1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,9,25),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,102,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,35,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,44,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,159,10),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,47,3),"?",0,0,m_cServer)+", ";
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
          /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per l'informazione in data "+CharToDate(Right(Left(riga,8),4)+Substr(Left(riga,8),3,2)+Left(Left(riga,8),2))+" relativa al rapporto: "+Substr(riga,9,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
          gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per l'informazione in data "+CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2))+" relativa al rapporto: "+CPLib.Substr(riga,9,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
        /* cNumNew := cNumNew + 1 */
        cNumNew = CPLib.Round(cNumNew+1,0);
        /* cMaxRow := 0 */
        cMaxRow = CPLib.Round(0,0);
        /* cNumMod := 0 */
        cNumMod = CPLib.Round(0,0);
        // * --- Select from xntestbo
        m_cServer = m_Ctx.GetServer("xntestbo");
        m_cPhName = m_Ctx.GetPhName("xntestbo");
        if (Cursor_xntestbo!=null)
          Cursor_xntestbo.Close();
        Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,9,25),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Substr(riga,9,25))+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM ",m_cServer,m_Ctx,true));
        while ( ! (Cursor_xntestbo.Eof())) {
          /* If xntestbo->CODINTER=cCli1 */
          if (CPLib.eqr(Cursor_xntestbo.GetString("CODINTER"),cCli1)) {
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
          /* nProgImp2 := Utilities.GetAutonumber("PRGIMPSOG\'"+LRTrim(gAzienda)+"'",0,15) */
          nProgImp2 = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPSOG\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
          // * --- Insert into xntestbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xntestbo");
          m_cPhName = m_Ctx.GetPhName("xntestbo");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"xntestbo")+" (";
          m_cSql = m_cSql+GetFieldsName_061A4A48(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow+1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2)),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.Substr(riga,44,2),"25") || CPLib.eqr(CPLib.Substr(riga,44,2),"28")?"D":"P"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(cCli1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,9,25),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,34,1),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,8)+cInfProg2+"O","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cCli1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp2,"?",0,0)+", ";
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
            /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario dell'informazione in data "+CharToDate(Right(Left(riga,8),4)+Substr(Left(riga,8),3,2)+Left(Left(riga,8),2))+" relativa al rapporto: "+Substr(riga,9,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario dell'informazione in data "+CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2))+" relativa al rapporto: "+CPLib.Substr(riga,9,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
        } else { // Else
          /* If Substr(riga,44,2)='23' */
          if (CPLib.eqr(CPLib.Substr(riga,44,2),"23")) {
            // * --- Write into xntestbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xntestbo");
            m_cPhName = m_Ctx.GetPhName("xntestbo");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = "Update "+m_cPhName+" set ";
            m_cSql = m_cSql+"DATAINI = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2)),"D",8,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xntestbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,9,25),"?",0,0,m_cServer),m_cServer,CPLib.Substr(riga,9,25))+"";
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
              /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario dell'informazione in data "+CharToDate(Right(Left(riga,8),4)+Substr(Left(riga,8),3,2)+Left(Left(riga,8),2))+" relativa al rapporto: "+Substr(riga,9,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
              gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario dell'informazione in data "+CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2))+" relativa al rapporto: "+CPLib.Substr(riga,9,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
            /* ElseIf Substr(riga,44,2)='26' */
          } else if (CPLib.eqr(CPLib.Substr(riga,44,2),"26")) {
            // * --- Write into xntestbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xntestbo");
            m_cPhName = m_Ctx.GetPhName("xntestbo");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = "Update "+m_cPhName+" set ";
            m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2)),"D",8,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xntestbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,9,25),"?",0,0,m_cServer),m_cServer,CPLib.Substr(riga,9,25))+"";
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
              /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario dell'informazione in data "+CharToDate(Right(Left(riga,8),4)+Substr(Left(riga,8),3,2)+Left(Left(riga,8),2))+" relativa al rapporto: "+Substr(riga,9,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
              gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario dell'informazione in data "+CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2))+" relativa al rapporto: "+CPLib.Substr(riga,9,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
        } // End If
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* gMsgProc := gMsgProc + 'Informazione Inserite: '+LRTrim(Str(cNumNew,10,0)) + NL */
      gMsgProc = gMsgProc+"Informazione Inserite: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
        if (Cursor_xntestbo!=null)
          Cursor_xntestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_9() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* Legge il file di testo e porta i dati nella tabella */
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        /* _intercod := iif(Empty(LRTrim(Substr(riga,246,11))),_codinter,Substr(riga,246,11)) */
        _intercod = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,246,11)))?_codinter:CPLib.Substr(riga,246,11));
        /* _intercit := iif(Empty(LRTrim(Substr(riga,263,30))),_citinter,Substr(riga,263,30)) */
        _intercit = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,263,30)))?_citinter:CPLib.Substr(riga,263,30));
        /* _intercab := iif(Empty(LRTrim(Substr(riga,295,6))),_cabinter,Substr(riga,295,6)) */
        _intercab = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,295,6)))?_cabinter:CPLib.Substr(riga,295,6));
        /* _interprv := iif(Empty(LRTrim(Substr(riga,293,2))),_prvinter,Substr(riga,293,2)) */
        _interprv = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,293,2)))?_prvinter:CPLib.Substr(riga,293,2));
        /* If not(Empty(LRTrim(Substr(riga,257,6)))) */
        if ( ! (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,257,6))))) {
          /* If Empty(LRTrim(Substr(riga,263,30))+LRTrim(Substr(riga,295,6))+LRTrim(Substr(riga,293,2))) */
          if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,263,30))+CPLib.LRTrim(CPLib.Substr(riga,295,6))+CPLib.LRTrim(CPLib.Substr(riga,293,2)))) {
            // * --- Read from anadip
            m_cServer = m_Ctx.GetServer("anadip");
            m_cPhName = m_Ctx.GetPhName("anadip");
            m_cSql = "";
            m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,257,6),"C",6,0,m_cServer),m_cServer,CPLib.Substr(riga,257,6));
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
                Error l_oErrorFault = new Error("Read on anadip into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
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
        /* If Len(LRTrim(Substr(riga,318,10))) > 0 */
        if (CPLib.gt(CPLib.Len(CPLib.LRTrim(CPLib.Substr(riga,318,10))),0)) {
          // * --- Read from xperazbo
          m_cServer = m_Ctx.GetServer("xperazbo");
          m_cPhName = m_Ctx.GetPhName("xperazbo");
          m_cSql = "";
          m_cSql = m_cSql+"UNIQUECODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,318,10),"C",10,0,m_cServer),m_cServer,CPLib.Substr(riga,318,10));
          if (m_Ctx.IsSharedTemp("xperazbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("UNIQUECODE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _unicode = Read_Cursor.GetString("UNIQUECODE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on xperazbo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _unicode = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Len(LRTrim(_unicode)) > 0 */
          if (CPLib.gt(CPLib.Len(CPLib.LRTrim(_unicode)),0)) {
            /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per l'operazione in data "+CharToDate(Right(Left(riga,8),4)+Substr(Left(riga,8),3,2)+Left(Left(riga,8),2))+" con importo "+Str((Val(Substr(riga,160,15)))/100,14,2)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per l'operazione in data "+CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2))+" con importo "+CPLib.Str((CPLib.Val(CPLib.Substr(riga,160,15)))/100,14,2)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            // Exit Loop
            if (true) {
              break;
            }
          } // End If
        } // End If
        /* cOpeProg1 := Utilities.GetAutonumber("PPOPER1\'"+LRTrim(gAzienda)+"'",'',10) */
        cOpeProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PPOPER1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
        /* cOpeProg2 := Utilities.GetAutonumber("PPOPER2\'"+LRTrim(gAzienda)+"'",'',11) */
        cOpeProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PPOPER2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
        /* Case Substr(riga,155,1)='S' or Substr(riga,155,1)='1' or Substr(riga,155,1)='7' */
        if (CPLib.eqr(CPLib.Substr(riga,155,1),"S") || CPLib.eqr(CPLib.Substr(riga,155,1),"1") || CPLib.eqr(CPLib.Substr(riga,155,1),"7")) {
          /* cFlagLire := '1' */
          cFlagLire = "1";
          /* Case Substr(riga,155,1)='E' or Substr(riga,155,1)='3' or Substr(riga,155,1)='5' */
        } else if (CPLib.eqr(CPLib.Substr(riga,155,1),"E") || CPLib.eqr(CPLib.Substr(riga,155,1),"3") || CPLib.eqr(CPLib.Substr(riga,155,1),"5")) {
          /* If Substr(riga,155,1) = 'E' */
          if (CPLib.eqr(CPLib.Substr(riga,155,1),"E")) {
            /* cFlagLire := '3' */
            cFlagLire = "3";
          } else { // Else
            /* cFlagLire := Substr(riga,155,1) */
            cFlagLire = CPLib.Substr(riga,155,1);
          } // End If
        } else { // Otherwise
          /* cFlagLire := Substr(riga,155,1) */
          cFlagLire = CPLib.Substr(riga,155,1);
        } // End Case
        /* cFlagCont := iif(Substr(riga,9,1)='1' or Substr(riga,9,1)='S','1','0')  */
        cFlagCont = (CPLib.eqr(CPLib.Substr(riga,9,1),"1") || CPLib.eqr(CPLib.Substr(riga,9,1),"S")?"1":"0");
        /* cFlagFraz := iif(Empty(Substr(riga,301,1)),'0',Substr(riga,301,1)) */
        cFlagFraz = (CPLib.Empty(CPLib.Substr(riga,301,1))?"0":CPLib.Substr(riga,301,1));
        /* cIdCau := '' */
        cIdCau = "";
        // * --- Read from tbcauana
        m_cServer = m_Ctx.GetServer("tbcauana");
        m_cPhName = m_Ctx.GetPhName("tbcauana");
        m_cSql = "";
        m_cSql = m_cSql+"CODCAU="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,10,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(riga,10,4));
        m_cSql = m_cSql+" and CAUSINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,14,2),"C",2,0,m_cServer),m_cServer,CPLib.Substr(riga,14,2));
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
            Error l_oErrorFault = new Error("Read on tbcauana into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          cIdCau = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* nProgImp := Utilities.GetAutonumber("PRGIMPOPE\'"+LRTrim(gAzienda)+"'",0,15) */
        nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOPE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        /* gMsgImp := 'Sono stati elaborate '+LRTrim(Str(conta,10,0))+' operazioni del file '+nomefileimport // Messaggio Import */
        gMsgImp = "Sono stati elaborate "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" operazioni del file "+nomefileimport;
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _benrag := Substr(riga,511,70) */
        _benrag = CPLib.Substr(riga,511,70);
        /* _bensta := Substr(riga,581,3) */
        _bensta = CPLib.Substr(riga,581,3);
        /* _bencta := Substr(riga,584,30) */
        _bencta = CPLib.Substr(riga,584,30);
        /* _bencab := Substr(riga,614,6) */
        _bencab = CPLib.Substr(riga,614,6);
        /* _benprv := Substr(riga,620,2) */
        _benprv = CPLib.Substr(riga,620,2);
        /* _benind := Substr(riga,622,35) */
        _benind = CPLib.Substr(riga,622,35);
        /* _bencap := Substr(riga,657,5) */
        _bencap = CPLib.Substr(riga,657,5);
        /* If not(Empty(LRTrim(Substr(riga,302,16)))) and Empty(LRTrim(_benrag+_bensta+_bencta+_bencab+_benprv+_benind+_bencap)) */
        if ( ! (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,302,16)))) && CPLib.Empty(CPLib.LRTrim(_benrag+_bensta+_bencta+_bencab+_benprv+_benind+_bencap))) {
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
          m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,302,16),"C",16,0,m_cServer),m_cServer,CPLib.Substr(riga,302,16));
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
              Error l_oErrorFault = new Error("Read on personbo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
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
        // * --- Insert into xperazbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("xperazbo");
        m_cPhName = m_Ctx.GetPhName("xperazbo");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"xperazbo")+" (";
        m_cSql = m_cSql+GetFieldsName_05EBE158(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,454,5),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,419,5),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_bencab,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_bencap,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_bencta,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_benind,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_benprv,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_benrag,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,762,25),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_bensta,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,222,9))/10000,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right(CPLib.Substr(riga,147,8),4)+CPLib.Substr(CPLib.Substr(riga,147,8),3,2)+CPLib.Left(CPLib.Substr(riga,147,8),2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,10,4),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,64,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,257,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,18,11),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,14,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,484,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,302,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,190,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,206,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(CPLib.Substr(riga,500,8),4)+CPLib.Substr(CPLib.Substr(riga,500,8),3,2)+CPLib.Left(CPLib.Substr(riga,500,8),2)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(CPLib.Substr(riga,147,8),4)+CPLib.Substr(CPLib.Substr(riga,147,8),3,2)+CPLib.Left(CPLib.Substr(riga,147,8),2)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,32,30),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,70,50),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,459,5),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cFlagCont,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cFlagFraz,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cFlagLire,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,145,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cIdCau,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2)+cOpeProg2+"S","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,331,9),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,414,5),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,662,50),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,328,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,29,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,812,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,62,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,409,5),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,787,25),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,120,25),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,475,3)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,472,3)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,481,3)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,478,3)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,469,3)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,508,3)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,712,50),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,159,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,464,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,16,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,244,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,146,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,242,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,175,15)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,160,15)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,318,10),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,156,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,340,69),"?",0,0,m_cServer)+", ";
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
          /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per l'operazione in data "+CharToDate(Right(Left(riga,8),4)+Substr(Left(riga,8),3,2)+Left(Left(riga,8),2))+" con importo "+Str((Val(Substr(riga,160,15)))/100,14,2)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
          gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per l'operazione in data "+CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2))+" con importo "+CPLib.Str((CPLib.Val(CPLib.Substr(riga,160,15)))/100,14,2)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
        /* cNumNew := cNumNew + 1 */
        cNumNew = CPLib.Round(cNumNew+1,0);
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* gMsgProc := gMsgProc + 'Operazioni Inserite: '+LRTrim(Str(cNumNew,10,0)) + NL */
      gMsgProc = gMsgProc+"Operazioni Inserite: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
    }
  }
  void Page_10() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* Legge il file di testo e porta i dati nella tabella */
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        /* _intercod := iif(Empty(LRTrim(Substr(riga,246,11))),_codinter,Substr(riga,246,11)) */
        _intercod = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,246,11)))?_codinter:CPLib.Substr(riga,246,11));
        /* _intercit := iif(Empty(LRTrim(Substr(riga,263,30))),_citinter,Substr(riga,263,30)) */
        _intercit = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,263,30)))?_citinter:CPLib.Substr(riga,263,30));
        /* _intercab := iif(Empty(LRTrim(Substr(riga,295,6))),_cabinter,Substr(riga,295,6)) */
        _intercab = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,295,6)))?_cabinter:CPLib.Substr(riga,295,6));
        /* _interprv := iif(Empty(LRTrim(Substr(riga,293,2))),_prvinter,Substr(riga,293,2)) */
        _interprv = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,293,2)))?_prvinter:CPLib.Substr(riga,293,2));
        /* If not(Empty(LRTrim(Substr(riga,257,6)))) */
        if ( ! (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,257,6))))) {
          /* If Empty(LRTrim(Substr(riga,263,30))+LRTrim(Substr(riga,295,6))+LRTrim(Substr(riga,293,2))) */
          if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,263,30))+CPLib.LRTrim(CPLib.Substr(riga,295,6))+CPLib.LRTrim(CPLib.Substr(riga,293,2)))) {
            // * --- Read from anadip
            m_cServer = m_Ctx.GetServer("anadip");
            m_cPhName = m_Ctx.GetPhName("anadip");
            m_cSql = "";
            m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,257,6),"C",6,0,m_cServer),m_cServer,CPLib.Substr(riga,257,6));
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
                Error l_oErrorFault = new Error("Read on anadip into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
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
        /* If Len(LRTrim(Substr(riga,318,10))) > 0 */
        if (CPLib.gt(CPLib.Len(CPLib.LRTrim(CPLib.Substr(riga,318,10))),0)) {
          // * --- Read from xraziobo
          m_cServer = m_Ctx.GetServer("xraziobo");
          m_cPhName = m_Ctx.GetPhName("xraziobo");
          m_cSql = "";
          m_cSql = m_cSql+"UNIQUECODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,318,10),"C",10,0,m_cServer),m_cServer,CPLib.Substr(riga,318,10));
          if (m_Ctx.IsSharedTemp("xraziobo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("UNIQUECODE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _unicode = Read_Cursor.GetString("UNIQUECODE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on xraziobo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _unicode = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Len(LRTrim(_unicode)) > 0 */
          if (CPLib.gt(CPLib.Len(CPLib.LRTrim(_unicode)),0)) {
            /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per l'operazione in data "+CharToDate(Right(Left(riga,8),4)+Substr(Left(riga,8),3,2)+Left(Left(riga,8),2))+" con importo "+Str((Val(Substr(riga,160,15)))/100,14,2)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per l'operazione in data "+CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2))+" con importo "+CPLib.Str((CPLib.Val(CPLib.Substr(riga,160,15)))/100,14,2)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            // Exit Loop
            if (true) {
              break;
            }
          } // End If
        } // End If
        /* cOpeProg1 := Utilities.GetAutonumber("PPFRAZ1\'"+LRTrim(gAzienda)+"'",'',10) */
        cOpeProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PPFRAZ1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
        /* cOpeProg2 := Utilities.GetAutonumber("PPFRAZ2\'"+LRTrim(gAzienda)+"'",'',11) */
        cOpeProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PPFRAZ2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
        /* Case Substr(riga,155,1)='S' or Substr(riga,155,1)='1' or Substr(riga,155,1)='7' */
        if (CPLib.eqr(CPLib.Substr(riga,155,1),"S") || CPLib.eqr(CPLib.Substr(riga,155,1),"1") || CPLib.eqr(CPLib.Substr(riga,155,1),"7")) {
          /* cFlagLire := '1' */
          cFlagLire = "1";
          /* Case Substr(riga,155,1)='E' or Substr(riga,155,1)='3' or Substr(riga,155,1)='5' */
        } else if (CPLib.eqr(CPLib.Substr(riga,155,1),"E") || CPLib.eqr(CPLib.Substr(riga,155,1),"3") || CPLib.eqr(CPLib.Substr(riga,155,1),"5")) {
          /* If Substr(riga,155,1) = 'E' */
          if (CPLib.eqr(CPLib.Substr(riga,155,1),"E")) {
            /* cFlagLire := '3' */
            cFlagLire = "3";
          } else { // Else
            /* cFlagLire := Substr(riga,155,1) */
            cFlagLire = CPLib.Substr(riga,155,1);
          } // End If
        } else { // Otherwise
          /* cFlagLire := Substr(riga,155,1) */
          cFlagLire = CPLib.Substr(riga,155,1);
        } // End Case
        /* cFlagCont := iif(Substr(riga,9,1)='1' or Substr(riga,9,1)='S','1','0')  */
        cFlagCont = (CPLib.eqr(CPLib.Substr(riga,9,1),"1") || CPLib.eqr(CPLib.Substr(riga,9,1),"S")?"1":"0");
        /* cFlagFraz := iif(Empty(Substr(riga,301,1)),'0',Substr(riga,301,1)) */
        cFlagFraz = (CPLib.Empty(CPLib.Substr(riga,301,1))?"0":CPLib.Substr(riga,301,1));
        /* cIdCau := '' */
        cIdCau = "";
        // * --- Read from tbcauana
        m_cServer = m_Ctx.GetServer("tbcauana");
        m_cPhName = m_Ctx.GetPhName("tbcauana");
        m_cSql = "";
        m_cSql = m_cSql+"CODCAU="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,10,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(riga,10,4));
        m_cSql = m_cSql+" and CAUSINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,14,2),"C",2,0,m_cServer),m_cServer,CPLib.Substr(riga,14,2));
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
            Error l_oErrorFault = new Error("Read on tbcauana into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          cIdCau = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* nProgImp := Utilities.GetAutonumber("PRGIMPFRZ\'"+LRTrim(gAzienda)+"'",0,15) */
        nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPFRZ\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        /* gMsgImp := 'Sono stati elaborate '+LRTrim(Str(conta,10,0))+' frazionate del file '+nomefileimport // Messaggio Import */
        gMsgImp = "Sono stati elaborate "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" frazionate del file "+nomefileimport;
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _benrag := Substr(riga,511,70) */
        _benrag = CPLib.Substr(riga,511,70);
        /* _bensta := Substr(riga,581,3) */
        _bensta = CPLib.Substr(riga,581,3);
        /* _bencta := Substr(riga,584,30) */
        _bencta = CPLib.Substr(riga,584,30);
        /* _bencab := Substr(riga,614,6) */
        _bencab = CPLib.Substr(riga,614,6);
        /* _benprv := Substr(riga,620,2) */
        _benprv = CPLib.Substr(riga,620,2);
        /* _benind := Substr(riga,622,35) */
        _benind = CPLib.Substr(riga,622,35);
        /* _bencap := Substr(riga,657,5) */
        _bencap = CPLib.Substr(riga,657,5);
        /* If not(Empty(LRTrim(Substr(riga,302,16)))) and Empty(LRTrim(_benrag+_bensta+_bencta+_bencab+_benprv+_benind+_bencap)) */
        if ( ! (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,302,16)))) && CPLib.Empty(CPLib.LRTrim(_benrag+_bensta+_bencta+_bencab+_benprv+_benind+_bencap))) {
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
          m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,302,16),"C",16,0,m_cServer),m_cServer,CPLib.Substr(riga,302,16));
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
              Error l_oErrorFault = new Error("Read on personbo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
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
        // * --- Insert into xraziobo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("xraziobo");
        m_cPhName = m_Ctx.GetPhName("xraziobo");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"xraziobo")+" (";
        m_cSql = m_cSql+GetFieldsName_06574630(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,454,5),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,419,5),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_bencab,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_bencap,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_bencta,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_benind,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_benprv,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_benrag,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,762,25),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_bensta,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,222,9))/10000,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right(CPLib.Substr(riga,147,8),4)+CPLib.Substr(CPLib.Substr(riga,147,8),3,2)+CPLib.Left(CPLib.Substr(riga,147,8),2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,10,4),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,64,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,257,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,18,11),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,14,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,484,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,302,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,190,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,206,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(CPLib.Substr(riga,500,8),4)+CPLib.Substr(CPLib.Substr(riga,500,8),3,2)+CPLib.Left(CPLib.Substr(riga,500,8),2)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(CPLib.Substr(riga,147,8),4)+CPLib.Substr(CPLib.Substr(riga,147,8),3,2)+CPLib.Left(CPLib.Substr(riga,147,8),2)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,32,30),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,70,50),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,459,5),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cFlagCont,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cFlagFraz,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cFlagLire,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,145,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cIdCau,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2)+cOpeProg2+"Z","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,331,9),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,414,5),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,662,50),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,328,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,29,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,812,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,62,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,409,5),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,787,25),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,120,25),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,475,3)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,472,3)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,481,3)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,478,3)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,469,3)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,508,3)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,712,50),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,159,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,464,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,16,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,244,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,146,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,242,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,175,15)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,160,15)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,318,10),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,156,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,340,69),"?",0,0,m_cServer)+", ";
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
          /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per l'operazione in data "+CharToDate(Right(Left(riga,8),4)+Substr(Left(riga,8),3,2)+Left(Left(riga,8),2))+" con importo "+Str((Val(Substr(riga,160,15)))/100,14,2)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
          gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per l'operazione in data "+CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2))+" con importo "+CPLib.Str((CPLib.Val(CPLib.Substr(riga,160,15)))/100,14,2)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
        /* cNumNew := cNumNew + 1 */
        cNumNew = CPLib.Round(cNumNew+1,0);
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* gMsgProc := gMsgProc + 'Frazionate Inserite: '+LRTrim(Str(cNumNew,10,0)) + NL */
      gMsgProc = gMsgProc+"Frazionate Inserite: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        /* cFlagLire := '' */
        cFlagLire = "";
        /* Case Substr(riga,77,1)='S' or Substr(riga,77,1)='1' or Substr(riga,77,1)='7' */
        if (CPLib.eqr(CPLib.Substr(riga,77,1),"S") || CPLib.eqr(CPLib.Substr(riga,77,1),"1") || CPLib.eqr(CPLib.Substr(riga,77,1),"7")) {
          /* cFlagLire := '1' */
          cFlagLire = "1";
          /* Case Substr(riga,77,1)='E' or Substr(riga,77,1)='3' or Substr(riga,77,1)='5' */
        } else if (CPLib.eqr(CPLib.Substr(riga,77,1),"E") || CPLib.eqr(CPLib.Substr(riga,77,1),"3") || CPLib.eqr(CPLib.Substr(riga,77,1),"5")) {
          /* If Substr(riga,77,1) = 'E' */
          if (CPLib.eqr(CPLib.Substr(riga,77,1),"E")) {
            /* cFlagLire := '3' */
            cFlagLire = "3";
          } else { // Else
            /* cFlagLire := Substr(riga,77,1) */
            cFlagLire = CPLib.Substr(riga,77,1);
          } // End If
        } else { // Otherwise
          /* cFlagLire := Substr(riga,77,1) */
          cFlagLire = CPLib.Substr(riga,77,1);
        } // End Case
        /* xRapporto := '' */
        xRapporto = "";
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
            Error l_oErrorFault = new Error("Read on jnarapbo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
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
          /* nProgImp := Utilities.GetAutonumber("PRGIMPRAPAGE\'"+LRTrim(gAzienda)+"'",0,15) */
          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPRAPAGE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
          // * --- Insert into jnarapbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("jnarapbo");
          m_cPhName = m_Ctx.GetPhName("jnarapbo");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"jnarapbo")+" (";
          m_cSql = m_cSql+GetFieldsName_05E0EBA8(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,25),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,26,50),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,76,1),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cFlagLire,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,78,3),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,81,2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,83,1)),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,84,5),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,89,5),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,94,5),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
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
            /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per il rapporto: "+Left(riga,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per il rapporto: "+CPLib.Left(riga,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
          m_cSql = m_cSql+"FLAGLIRE = "+CPLib.ToSQL(cFlagLire,"C",1,0,m_cServer)+", ";
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
            /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per il rapporto: "+Left(riga,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per il rapporto: "+CPLib.Left(riga,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
          /* cNumMod := cNumMod + 1 */
          cNumMod = CPLib.Round(cNumMod+1,0);
        } // End If
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* gMsgProc := gMsgProc + 'Rapporti AGE Inseriti: '+LRTrim(Str(cNumNew,10,0)) + " - Rapporti AGE Aggiornati: "+LRTrim(Str(cNumMod,10,0)) + NL */
      gMsgProc = gMsgProc+"Rapporti AGE Inseriti: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+" - Rapporti AGE Aggiornati: "+CPLib.LRTrim(CPLib.Str(cNumMod,10,0))+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
    }
  }
  void Page_12() throws Exception {
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_jntestbo=null;
    try {
      /* Legge il file di testo e porta i dati nella tabella */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        /* _intercod := iif(Empty(LRTrim(Substr(riga,104,11))),_codinter,Substr(riga,104,11)) */
        _intercod = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,104,11)))?_codinter:CPLib.Substr(riga,104,11));
        /* _intercit := iif(Empty(LRTrim(Substr(riga,121,30))),_citinter,Substr(riga,121,30)) */
        _intercit = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,121,30)))?_citinter:CPLib.Substr(riga,121,30));
        /* _intercab := iif(Empty(LRTrim(Substr(riga,153,6))),_cabinter,Substr(riga,153,6)) */
        _intercab = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,153,6)))?_cabinter:CPLib.Substr(riga,153,6));
        /* _interprv := iif(Empty(LRTrim(Substr(riga,151,2))),_prvinter,Substr(riga,151,2)) */
        _interprv = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,151,2)))?_prvinter:CPLib.Substr(riga,151,2));
        /* xConnes := Substr(riga,75,16) */
        xConnes = CPLib.Substr(riga,75,16);
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
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          cCli1 = Read_Cursor.GetString("CONNES");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on personbo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          cCli1 = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If Empty(LRTrim(cCli1)) */
        if (CPLib.Empty(CPLib.LRTrim(cCli1))) {
          // * --- Read from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          m_cSql = "";
          m_cSql = m_cSql+"CODFISC="+CPSql.SQLValueAdapter(CPLib.ToSQL(xConnes,"C",16,0,m_cServer),m_cServer,xConnes);
          if (m_Ctx.IsSharedTemp("personbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            cCli1 = Read_Cursor.GetString("CONNES");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on personbo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            cCli1 = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(cCli1)) */
          if (CPLib.Empty(CPLib.LRTrim(cCli1))) {
            /* cCli1 := xConnes */
            cCli1 = xConnes;
          } // End If
        } // End If
        /* xSOCTCF := '' */
        xSOCTCF = "";
        /* xSOCTCon := Substr(riga,50,16) */
        xSOCTCon = CPLib.Substr(riga,50,16);
        /* If not(Empty(LRTrim(xSOCTCon))) */
        if ( ! (CPLib.Empty(CPLib.LRTrim(xSOCTCon)))) {
          // * --- Read from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          m_cSql = "";
          m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(xSOCTCon,"C",16,0,m_cServer),m_cServer,xSOCTCon);
          if (m_Ctx.IsSharedTemp("personbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            xSOCTCF = Read_Cursor.GetString("CONNES");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on personbo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            xSOCTCF = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(xSOCTCF)) */
          if (CPLib.Empty(CPLib.LRTrim(xSOCTCF))) {
            // * --- Read from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_cSql = "";
            m_cSql = m_cSql+"CODFISC="+CPSql.SQLValueAdapter(CPLib.ToSQL(xSOCTCon,"C",16,0,m_cServer),m_cServer,xSOCTCon);
            if (m_Ctx.IsSharedTemp("personbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              xSOCTCF = Read_Cursor.GetString("CONNES");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on personbo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              xSOCTCF = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(LRTrim(xSOCTCF)) */
            if (CPLib.Empty(CPLib.LRTrim(xSOCTCF))) {
              /* xSOCTCF := xSOCTCon */
              xSOCTCF = xSOCTCon;
            } // End If
          } // End If
        } // End If
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        /* gMsgImp := 'Sono stati elaborate '+LRTrim(Str(conta,10,0))+' informazioni del file '+nomefileimport // Messaggio Import */
        gMsgImp = "Sono stati elaborate "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" informazioni del file "+nomefileimport;
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* Case Substr(riga,46,1)='S' or Substr(riga,46,1)='1' or Substr(riga,46,1)='7' */
        if (CPLib.eqr(CPLib.Substr(riga,46,1),"S") || CPLib.eqr(CPLib.Substr(riga,46,1),"1") || CPLib.eqr(CPLib.Substr(riga,46,1),"7")) {
          /* cFlagLire := '1' */
          cFlagLire = "1";
          /* Case Substr(riga,46,1)='E' or Substr(riga,46,1)='3' or Substr(riga,46,1)='5' */
        } else if (CPLib.eqr(CPLib.Substr(riga,46,1),"E") || CPLib.eqr(CPLib.Substr(riga,46,1),"3") || CPLib.eqr(CPLib.Substr(riga,46,1),"5")) {
          /* If Substr(riga,46,1) = 'E' */
          if (CPLib.eqr(CPLib.Substr(riga,46,1),"E")) {
            /* cFlagLire := '3' */
            cFlagLire = "3";
          } else { // Else
            /* cFlagLire := Substr(riga,46,1) */
            cFlagLire = CPLib.Substr(riga,46,1);
          } // End If
        } else { // Otherwise
          /* cFlagLire := Substr(riga,46,1) */
          cFlagLire = CPLib.Substr(riga,46,1);
        } // End Case
        /* Da sentire Bruno sembra che l'importazione dei soggetti operanti in agenzia delle entrate non sia pi� attiva.
           Ma sul tracciato c'� ancora. */
        /* cInfProg1 := iif(Empty(Substr(riga,159,10)),Utilities.GetAutonumber("PRGINFAGE1\'"+LRTrim(gAzienda)+"'",'',10),Substr(riga,159,10)) */
        cInfProg1 = (CPLib.Empty(CPLib.Substr(riga,159,10))?Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFAGE1\\'"+CPLib.LRTrim(gAzienda)+"'","",10):CPLib.Substr(riga,159,10));
        /* cInfProg2 := Utilities.GetAutonumber("PRGINFAGE2\'"+LRTrim(gAzienda)+"'",'',11) */
        cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFAGE2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
        /* nProgImp := Utilities.GetAutonumber("PRGIMPINFAGE\'"+LRTrim(gAzienda)+"'",0,15) */
        nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINFAGE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
        // * --- Insert into japopebo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("japopebo");
        m_cPhName = m_Ctx.GetPhName("japopebo");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"japopebo")+" (";
        m_cSql = m_cSql+GetFieldsName_0634F5D0(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,115,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(xSOCTCF,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(CPLib.Substr(riga,36,8),4)+CPLib.Substr(CPLib.Substr(riga,36,8),3,2)+CPLib.Left(CPLib.Substr(riga,36,8),2)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,169,50),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cFlagLire,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,34,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,8)+cInfProg1+"0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.Substr(riga,44,2),1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,9,25),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,102,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,35,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,44,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,47,3),"?",0,0,m_cServer)+", ";
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
          /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per l'informazione in data "+CharToDate(Right(Left(riga,8),4)+Substr(Left(riga,8),3,2)+Left(Left(riga,8),2))+" relativa al rapporto: "+Substr(riga,9,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
          gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per l'informazione in data "+CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2))+" relativa al rapporto: "+CPLib.Substr(riga,9,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
        /* cNumNew := cNumNew + 1 */
        cNumNew = CPLib.Round(cNumNew+1,0);
        /* cMaxRow := 0 */
        cMaxRow = CPLib.Round(0,0);
        /* cNumMod := 0 */
        cNumMod = CPLib.Round(0,0);
        // * --- Select from jntestbo
        m_cServer = m_Ctx.GetServer("jntestbo");
        m_cPhName = m_Ctx.GetPhName("jntestbo");
        if (Cursor_jntestbo!=null)
          Cursor_jntestbo.Close();
        Cursor_jntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,9,25),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Substr(riga,9,25))+" "+")"+(m_Ctx.IsSharedTemp("jntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM ",m_cServer,m_Ctx,true));
        while ( ! (Cursor_jntestbo.Eof())) {
          /* If jntestbo->CODINTER=cCli1 */
          if (CPLib.eqr(Cursor_jntestbo.GetString("CODINTER"),cCli1)) {
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
          /* nProgImp2 := Utilities.GetAutonumber("PRGIMPSOGAGE\'"+LRTrim(gAzienda)+"'",0,15) */
          nProgImp2 = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPSOGAGE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
          // * --- Insert into jntestbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("jntestbo");
          m_cPhName = m_Ctx.GetPhName("jntestbo");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"jntestbo")+" (";
          m_cSql = m_cSql+GetFieldsName_07CAE548(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow+1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2)),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.Substr(riga,44,2),"25") || CPLib.eqr(CPLib.Substr(riga,44,2),"28")?"D":"P"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cCli1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,9,25),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,34,1),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,8)+cInfProg2+"O","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cCli1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp2,"?",0,0)+", ";
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
            /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario dell'informazione in data "+CharToDate(Right(Left(riga,8),4)+Substr(Left(riga,8),3,2)+Left(Left(riga,8),2))+" relativa al rapporto: "+Substr(riga,9,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario dell'informazione in data "+CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2))+" relativa al rapporto: "+CPLib.Substr(riga,9,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
        } else { // Else
          /* If Substr(riga,44,2)='23' */
          if (CPLib.eqr(CPLib.Substr(riga,44,2),"23")) {
            // * --- Write into jntestbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("jntestbo");
            m_cPhName = m_Ctx.GetPhName("jntestbo");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = "Update "+m_cPhName+" set ";
            m_cSql = m_cSql+"DATAINI = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2)),"D",8,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jntestbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,9,25),"?",0,0,m_cServer),m_cServer,CPLib.Substr(riga,9,25))+"";
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
              /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario dell'informazione in data "+CharToDate(Right(Left(riga,8),4)+Substr(Left(riga,8),3,2)+Left(Left(riga,8),2))+" relativa al rapporto: "+Substr(riga,9,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
              gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario dell'informazione in data "+CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2))+" relativa al rapporto: "+CPLib.Substr(riga,9,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
            /* ElseIf Substr(riga,44,2)='26' */
          } else if (CPLib.eqr(CPLib.Substr(riga,44,2),"26")) {
            // * --- Write into jntestbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("jntestbo");
            m_cPhName = m_Ctx.GetPhName("jntestbo");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = "Update "+m_cPhName+" set ";
            m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2)),"D",8,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jntestbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,9,25),"?",0,0,m_cServer),m_cServer,CPLib.Substr(riga,9,25))+"";
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
              /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario dell'informazione in data "+CharToDate(Right(Left(riga,8),4)+Substr(Left(riga,8),3,2)+Left(Left(riga,8),2))+" relativa al rapporto: "+Substr(riga,9,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
              gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario dell'informazione in data "+CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2))+" relativa al rapporto: "+CPLib.Substr(riga,9,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
        } // End If
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* gMsgProc := gMsgProc + 'Informazione Inserite: '+LRTrim(Str(cNumNew,10,0)) + NL */
      gMsgProc = gMsgProc+"Informazione Inserite: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
        if (Cursor_jntestbo!=null)
          Cursor_jntestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_13() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* Legge il file di testo e porta i dati nella tabella */
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        /* _intercod := iif(Empty(LRTrim(Substr(riga,246,11))),_codinter,Substr(riga,246,11)) */
        _intercod = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,246,11)))?_codinter:CPLib.Substr(riga,246,11));
        /* _intercit := iif(Empty(LRTrim(Substr(riga,263,30))),_citinter,Substr(riga,263,30)) */
        _intercit = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,263,30)))?_citinter:CPLib.Substr(riga,263,30));
        /* _intercab := iif(Empty(LRTrim(Substr(riga,295,6))),_cabinter,Substr(riga,295,6)) */
        _intercab = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,295,6)))?_cabinter:CPLib.Substr(riga,295,6));
        /* _interprv := iif(Empty(LRTrim(Substr(riga,293,2))),_prvinter,Substr(riga,293,2)) */
        _interprv = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,293,2)))?_prvinter:CPLib.Substr(riga,293,2));
        /* cOpeProg1 := iif(Empty(Substr(riga,318,10)),Utilities.GetAutonumber("POPERAGE1\'"+LRTrim(gAzienda)+"'",'',10),Substr(riga,318,10)) */
        cOpeProg1 = (CPLib.Empty(CPLib.Substr(riga,318,10))?Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAGE1\\'"+CPLib.LRTrim(gAzienda)+"'","",10):CPLib.Substr(riga,318,10));
        /* cOpeProg2 := Utilities.GetAutonumber("POPERAGE2\'"+LRTrim(gAzienda)+"'",'',11) */
        cOpeProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAGE2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
        /* Case Substr(riga,155,1)='S' or Substr(riga,155,1)='1' or Substr(riga,155,1)='7' */
        if (CPLib.eqr(CPLib.Substr(riga,155,1),"S") || CPLib.eqr(CPLib.Substr(riga,155,1),"1") || CPLib.eqr(CPLib.Substr(riga,155,1),"7")) {
          /* cFlagLire := '1' */
          cFlagLire = "1";
          /* Case Substr(riga,155,1)='E' or Substr(riga,155,1)='3' or Substr(riga,155,1)='5' */
        } else if (CPLib.eqr(CPLib.Substr(riga,155,1),"E") || CPLib.eqr(CPLib.Substr(riga,155,1),"3") || CPLib.eqr(CPLib.Substr(riga,155,1),"5")) {
          /* If Substr(riga,155,1) = 'E' */
          if (CPLib.eqr(CPLib.Substr(riga,155,1),"E")) {
            /* cFlagLire := '3' */
            cFlagLire = "3";
          } else { // Else
            /* cFlagLire := Substr(riga,155,1) */
            cFlagLire = CPLib.Substr(riga,155,1);
          } // End If
        } else { // Otherwise
          /* cFlagLire := Substr(riga,155,1) */
          cFlagLire = CPLib.Substr(riga,155,1);
        } // End Case
        /* cFlagCont := iif(Substr(riga,9,1)='1' or Substr(riga,9,1)='S','1','0')  */
        cFlagCont = (CPLib.eqr(CPLib.Substr(riga,9,1),"1") || CPLib.eqr(CPLib.Substr(riga,9,1),"S")?"1":"0");
        /* cFlagFraz := iif(Empty(Substr(riga,301,1)),'0',Substr(riga,301,1)) */
        cFlagFraz = (CPLib.Empty(CPLib.Substr(riga,301,1))?"0":CPLib.Substr(riga,301,1));
        /* cIdCau := '' */
        cIdCau = "";
        // * --- Read from tbcauana
        m_cServer = m_Ctx.GetServer("tbcauana");
        m_cPhName = m_Ctx.GetPhName("tbcauana");
        m_cSql = "";
        m_cSql = m_cSql+"CODCAU="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,10,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(riga,10,4));
        m_cSql = m_cSql+" and CAUSINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,14,2),"C",2,0,m_cServer),m_cServer,CPLib.Substr(riga,14,2));
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
            Error l_oErrorFault = new Error("Read on tbcauana into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          cIdCau = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* nProgImp := Utilities.GetAutonumber("PRGIMPOPEAGE\'"+LRTrim(gAzienda)+"'",0,15) */
        nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOPEAGE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        /* gMsgImp := 'Sono stati elaborate '+LRTrim(Str(conta,10,0))+' operazioni del file '+nomefileimport // Messaggio Import */
        gMsgImp = "Sono stati elaborate "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" operazioni del file "+nomefileimport;
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Insert into jperazbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("jperazbo");
        m_cPhName = m_Ctx.GetPhName("jperazbo");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"jperazbo")+" (";
        m_cSql = m_cSql+GetFieldsName_06131748(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,222,9))/10000,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,10,4),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,64,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,257,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,18,11),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,14,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,302,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,302,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,190,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,206,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(CPLib.Substr(riga,147,8),4)+CPLib.Substr(CPLib.Substr(riga,147,8),3,2)+CPLib.Left(CPLib.Substr(riga,147,8),2)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,32,30),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,70,50),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cFlagCont,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cFlagFraz,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cFlagLire,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,145,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cIdCau,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2)+cOpeProg2+"O","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,331,9),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,328,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,29,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,62,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,222,9),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,120,25),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,159,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,16,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,244,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,146,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,242,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,175,15)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,160,15)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,156,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,409,5),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,414,5),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,419,5),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2),"?",0,0,m_cServer)+", ";
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
          /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per l'operazione in data "+CharToDate(Right(Left(riga,8),4)+Substr(Left(riga,8),3,2)+Left(Left(riga,8),2))+" con importo "+Str((Val(Substr(riga,160,15)))/100,14,2)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
          gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per l'operazione in data "+CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2))+" con importo "+CPLib.Str((CPLib.Val(CPLib.Substr(riga,160,15)))/100,14,2)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
        /* cNumNew := cNumNew + 1 */
        cNumNew = CPLib.Round(cNumNew+1,0);
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* gMsgProc := gMsgProc + 'Operazioni AGE Inserite: '+LRTrim(Str(cNumNew,10,0)) + NL */
      gMsgProc = gMsgProc+"Operazioni AGE Inserite: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        /* xDIP := Substr(riga,1,6) */
        xDIP = CPLib.Substr(riga,1,6);
        /* xCodCab := Substr(riga,69,6) */
        xCodCab = CPLib.Substr(riga,69,6);
        /* If Empty(LRTrim(xCodCab)) */
        if (CPLib.Empty(CPLib.LRTrim(xCodCab))) {
          /* xCitta := Substr(riga,37,30) */
          xCitta = CPLib.Substr(riga,37,30);
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
              Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
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
            Error l_oErrorFault = new Error("Read on anadip into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
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
          m_cSql = m_cSql+GetFieldsName_062E26C0(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(xDIP,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,7,30),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,37,30),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,67,2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(xCodCab,"?",0,0,m_cServer)+", ";
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
          m_cSql = m_cSql+"CAB = "+CPLib.ToSQL(xCodCab,"C",6,0,m_cServer)+", ";
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
        /* gMsgProc := gMsgProc + 'Dipendenze Inserite: '+LRTrim(Str(cNumNew,10,0)) + NL */
        gMsgProc = gMsgProc+"Dipendenze Inserite: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
      /* If cNumMod <> 0 */
      if (CPLib.ne(cNumMod,0)) {
        /* gMsgProc := gMsgProc + 'Dipendenze Aggiornate: '+LRTrim(Str(cNumMod,10,0)) + NL */
        gMsgProc = gMsgProc+"Dipendenze Aggiornate: "+CPLib.LRTrim(CPLib.Str(cNumMod,10,0))+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
    }
  }
  void Page_15() throws Exception {
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_xapotit=null;
    CPResultSet Cursor_rapotit=null;
    try {
      /* Legge il file di testo e porta i dati nella tabella */
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      /* cNumMod := 0 */
      cNumMod = CPLib.Round(0,0);
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        /* _intercod := iif(Empty(LRTrim(Substr(riga,104,11))),_codinter,Substr(riga,104,11)) */
        _intercod = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,104,11)))?_codinter:CPLib.Substr(riga,104,11));
        /* _intercit := iif(Empty(LRTrim(Substr(riga,121,30))),_citinter,Substr(riga,121,30)) */
        _intercit = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,121,30)))?_citinter:CPLib.Substr(riga,121,30));
        /* _intercab := iif(Empty(LRTrim(Substr(riga,153,6))),_cabinter,Substr(riga,153,6)) */
        _intercab = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,153,6)))?_cabinter:CPLib.Substr(riga,153,6));
        /* _interprv := iif(Empty(LRTrim(Substr(riga,151,2))),_prvinter,Substr(riga,151,2)) */
        _interprv = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,151,2)))?_prvinter:CPLib.Substr(riga,151,2));
        /* _unicode := '' */
        _unicode = "";
        /* If not(Empty(Substr(riga,159,10))) */
        if ( ! (CPLib.Empty(CPLib.Substr(riga,159,10)))) {
          /* _tdest := '' */
          _tdest = "";
          // * --- Read from xapotit
          m_cServer = m_Ctx.GetServer("xapotit");
          m_cPhName = m_Ctx.GetPhName("xapotit");
          m_cSql = "";
          m_cSql = m_cSql+"UNIQUECODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,159,10),"C",10,0,m_cServer),m_cServer,CPLib.Substr(riga,159,10));
          if (m_Ctx.IsSharedTemp("xapotit")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _unicode = Read_Cursor.GetString("IDBASE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on xapotit into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _unicode = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(_unicode) */
          if (CPLib.Empty(_unicode)) {
            // * --- Read from rapotit
            m_cServer = m_Ctx.GetServer("rapotit");
            m_cPhName = m_Ctx.GetPhName("rapotit");
            m_cSql = "";
            m_cSql = m_cSql+"UNIQUECODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,159,10),"C",10,0,m_cServer),m_cServer,CPLib.Substr(riga,159,10));
            if (m_Ctx.IsSharedTemp("rapotit")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _unicode = Read_Cursor.GetString("IDBASE");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on rapotit into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _unicode = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If not(Empty(_unicode)) */
            if ( ! (CPLib.Empty(_unicode))) {
              /* _tdest := 'D' */
              _tdest = "D";
            } // End If
          } else { // Else
            /* _tdest := 'P' */
            _tdest = "P";
          } // End If
        } // End If
        /* If Empty(LRTrim(_unicode)) */
        if (CPLib.Empty(CPLib.LRTrim(_unicode))) {
          /* If w_tipodest='P' */
          if (CPLib.eqr(w_tipodest,"P")) {
            /* cInfProg1 := Utilities.GetAutonumber("PRGPTIT1\'"+LRTrim(gAzienda)+"'",'',10) */
            cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGPTIT1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
            /* cInfProg2 := Utilities.GetAutonumber("PRGPTIT2\'"+LRTrim(gAzienda)+"'",'',11) */
            cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGPTIT2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
            /* nProgImp := Utilities.GetAutonumber("PRGIMPTIT\'"+LRTrim(gAzienda)+"'",0,15) */
            nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPTIT\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
            // * --- Insert into xapotit from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xapotit");
            m_cPhName = m_Ctx.GetPhName("xapotit");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.InsertIntoStatement(m_Ctx,"xapotit")+" (";
            m_cSql = m_cSql+GetFieldsName_07A4C690(m_Ctx);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,115,6),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2)),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(CPLib.Substr(riga,36,8),4)+CPLib.Substr(CPLib.Substr(riga,36,8),3,2)+CPLib.Left(CPLib.Substr(riga,36,8),2)),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,169,50),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,34,1),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,8)+cInfProg1+"0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.Substr(riga,44,2),1),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,9,25),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,102,2),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,35,1),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,44,2),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,159,10),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,75,16),"?",0,0,m_cServer)+", ";
            if (m_Ctx.IsSharedTemp("xapotit")) {
              m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
            }
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xapotit",true);
            m_cSql = m_cSql+")";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_nUpdatedRows = 0;
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.lt(m_nUpdatedRows,1)) {
              // No rows inserted
              /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per il legame tra soggetti in data "+CharToDate(Right(Left(riga,8),4)+Substr(Left(riga,8),3,2)+Left(Left(riga,8),2))+" relativa al soggetto: "+Substr(riga,9,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
              gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per il legame tra soggetti in data "+CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2))+" relativa al soggetto: "+CPLib.Substr(riga,9,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
            /* cNumNew := cNumNew+1 */
            cNumNew = CPLib.Round(cNumNew+1,0);
          } else { // Else
            /* cInfProg1 := Utilities.GetAutonumber("PRGTITO1\'"+LRTrim(gAzienda)+"'",'',10) */
            cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGTITO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
            /* cInfProg2 := Utilities.GetAutonumber("PRGTITO2\'"+LRTrim(gAzienda)+"'",'',11) */
            cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGTITO2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
            /* nProgImp := Utilities.GetAutonumber("PRGIMPTIT\'"+LRTrim(gAzienda)+"'",0,15) */
            nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPTIT\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
            // * --- Insert into rapotit from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("rapotit");
            m_cPhName = m_Ctx.GetPhName("rapotit");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.InsertIntoStatement(m_Ctx,"rapotit")+" (";
            m_cSql = m_cSql+GetFieldsName_05DE4BA8(m_Ctx);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,115,6),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2)),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(CPLib.Substr(riga,36,8),4)+CPLib.Substr(CPLib.Substr(riga,36,8),3,2)+CPLib.Left(CPLib.Substr(riga,36,8),2)),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,169,50),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,34,1),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,8)+cInfProg1+"0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.Substr(riga,44,2),1),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,9,25),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,102,2),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,35,1),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,44,2),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,159,10),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,75,16),"?",0,0,m_cServer)+", ";
            if (m_Ctx.IsSharedTemp("rapotit")) {
              m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
            }
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"rapotit",true);
            m_cSql = m_cSql+")";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_nUpdatedRows = 0;
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.lt(m_nUpdatedRows,1)) {
              // No rows inserted
              /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per il legame tra soggetti in data "+CharToDate(Right(Left(riga,8),4)+Substr(Left(riga,8),3,2)+Left(Left(riga,8),2))+" relativa al soggetto: "+Substr(riga,9,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
              gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per il legame tra soggetti in data "+CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2))+" relativa al soggetto: "+CPLib.Substr(riga,9,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
            /* cNumNew := cNumNew+1 */
            cNumNew = CPLib.Round(cNumNew+1,0);
          } // End If
        } else { // Else
          /* If _tdest='P' */
          if (CPLib.eqr(_tdest,"P")) {
            // * --- Select from xapotit
            m_cServer = m_Ctx.GetServer("xapotit");
            m_cPhName = m_Ctx.GetPhName("xapotit");
            if (Cursor_xapotit!=null)
              Cursor_xapotit.Close();
            Cursor_xapotit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_unicode,"?",0,0,m_cServer, m_oParameters),m_cServer,_unicode)+"  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("xapotit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xapotit.Eof())) {
              /* cInfProg1 := Utilities.GetAutonumber("PRGPTIT1\'"+LRTrim(gAzienda)+"'",'',10) */
              cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGPTIT1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
              // * --- Insert into xapotit from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("xapotit");
              m_cPhName = m_Ctx.GetPhName("xapotit");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"xapotit")+" (";
              m_cSql = m_cSql+GetFieldsName_05B5EA60(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetDouble("PRGIMPTIT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("xapotit")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xapotit",true);
              m_cSql = m_cSql+")";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_nUpdatedRows = 0;
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.lt(m_nUpdatedRows,1)) {
                // No rows inserted
                /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per il legame tra soggetti in data "+CharToDate(Right(Left(riga,8),4)+Substr(Left(riga,8),3,2)+Left(Left(riga,8),2))+" relativa al soggetto: "+Substr(riga,9,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
                gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per il legame tra soggetti in data "+CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2))+" relativa al soggetto: "+CPLib.Substr(riga,9,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
              // * --- Write into xapotit from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("xapotit");
              m_cPhName = m_Ctx.GetPhName("xapotit");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = "Update "+m_cPhName+" set ";
              m_cSql = m_cSql+"CDATOPE = "+CPLib.ToSQL(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2),"C",8,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(_intercab,"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODDIPE = "+CPLib.ToSQL(CPLib.Substr(riga,115,6),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQL(_intercod,"C",11,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATAOPE = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2)),"D",8,0)+", ";
              m_cSql = m_cSql+"DATAREG = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(CPLib.Substr(riga,36,8),4)+CPLib.Substr(CPLib.Substr(riga,36,8),3,2)+CPLib.Left(CPLib.Substr(riga,36,8),2)),"D",8,0)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(_intercit,"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCINTER = "+CPLib.ToSQL(CPLib.Substr(riga,169,50),"C",50,0,m_cServer)+", ";
              m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(CPLib.Substr(riga,34,1),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"IDEREG = "+CPLib.ToSQL(Cursor_xapotit.GetString("IDEREG"),"C",20,0,m_cServer)+", ";
              m_cSql = m_cSql+"OPRAP = "+CPLib.ToSQL(CPLib.Left(CPLib.Substr(riga,44,2),1),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(_interprv,"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(CPLib.Substr(riga,9,25),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL("1","C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPOINTER = "+CPLib.ToSQL(CPLib.Substr(riga,102,2),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPOLEG = "+CPLib.ToSQL(CPLib.Substr(riga,35,1),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPOOPRAP = "+CPLib.ToSQL(CPLib.Substr(riga,44,2),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(CPLib.Substr(riga,75,16),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARETT = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xapotit",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_unicode,"?",0,0,m_cServer),m_cServer,_unicode)+"";
              if (m_Ctx.IsSharedTemp("xapotit")) {
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
              Cursor_xapotit.Next();
            }
            m_cConnectivityError = Cursor_xapotit.ErrorMessage();
            Cursor_xapotit.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from rapotit
            m_cServer = m_Ctx.GetServer("rapotit");
            m_cPhName = m_Ctx.GetPhName("rapotit");
            if (Cursor_rapotit!=null)
              Cursor_rapotit.Close();
            Cursor_rapotit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_unicode,"?",0,0,m_cServer, m_oParameters),m_cServer,_unicode)+"  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("rapotit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_rapotit.Eof())) {
              /* cInfProg1 := Utilities.GetAutonumber("PRGTITO1\'"+LRTrim(gAzienda)+"'",'',10) */
              cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGTITO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
              // * --- Insert into rapotit from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("rapotit");
              m_cPhName = m_Ctx.GetPhName("rapotit");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"rapotit")+" (";
              m_cSql = m_cSql+GetFieldsName_05F086A0(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetDouble("PRGIMPTIT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("rapotit")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"rapotit",true);
              m_cSql = m_cSql+")";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_nUpdatedRows = 0;
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.lt(m_nUpdatedRows,1)) {
                // No rows inserted
                /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per il legame tra soggetti in data "+CharToDate(Right(Left(riga,8),4)+Substr(Left(riga,8),3,2)+Left(Left(riga,8),2))+" relativa al soggetto: "+Substr(riga,9,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
                gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per il legame tra soggetti in data "+CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2))+" relativa al soggetto: "+CPLib.Substr(riga,9,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
              // * --- Write into rapotit from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("rapotit");
              m_cPhName = m_Ctx.GetPhName("rapotit");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = "Update "+m_cPhName+" set ";
              m_cSql = m_cSql+"CDATOPE = "+CPLib.ToSQL(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2),"C",8,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(_intercab,"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODDIPE = "+CPLib.ToSQL(CPLib.Substr(riga,115,6),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQL(_intercod,"C",11,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATAOPE = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2)),"D",8,0)+", ";
              m_cSql = m_cSql+"DATAREG = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(CPLib.Substr(riga,36,8),4)+CPLib.Substr(CPLib.Substr(riga,36,8),3,2)+CPLib.Left(CPLib.Substr(riga,36,8),2)),"D",8,0)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(_intercit,"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCINTER = "+CPLib.ToSQL(CPLib.Substr(riga,169,50),"C",50,0,m_cServer)+", ";
              m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(CPLib.Substr(riga,34,1),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"IDEREG = "+CPLib.ToSQL(Cursor_rapotit.GetString("IDEREG"),"C",20,0,m_cServer)+", ";
              m_cSql = m_cSql+"OPRAP = "+CPLib.ToSQL(CPLib.Left(CPLib.Substr(riga,44,2),1),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(_interprv,"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(CPLib.Substr(riga,9,25),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL("1","C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPOINTER = "+CPLib.ToSQL(CPLib.Substr(riga,102,2),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPOLEG = "+CPLib.ToSQL(CPLib.Substr(riga,35,1),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPOOPRAP = "+CPLib.ToSQL(CPLib.Substr(riga,44,2),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(CPLib.Substr(riga,75,16),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARETT = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"rapotit",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_unicode,"?",0,0,m_cServer),m_cServer,_unicode)+"";
              if (m_Ctx.IsSharedTemp("rapotit")) {
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
              Cursor_rapotit.Next();
            }
            m_cConnectivityError = Cursor_rapotit.ErrorMessage();
            Cursor_rapotit.Close();
            // * --- End Select
          } // End If
        } // End If
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* gMsgProc := gMsgProc + 'Titolari Inseriti: '+LRTrim(Str(cNumNew,10,0)) + " - Titolari Aggiornati: "+LRTrim(Str(cNumMod,10,0)) + NL */
      gMsgProc = gMsgProc+"Titolari Inseriti: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+" - Titolari Aggiornati: "+CPLib.LRTrim(CPLib.Str(cNumMod,10,0))+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
        if (Cursor_xapotit!=null)
          Cursor_xapotit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_rapotit!=null)
          Cursor_rapotit.Close();
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
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
            Error l_oErrorFault = new Error("Read on opextrbo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
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
          m_cSql = m_cSql+GetFieldsName_05B62690(m_Ctx);
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
            /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per il soggetto con codice fiscale: "+Substr(riga,1,16)+" per l'operazione extraconto in data: "+Substr(riga,21,8)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per il soggetto con codice fiscale: "+CPLib.Substr(riga,1,16)+" per l'operazione extraconto in data: "+CPLib.Substr(riga,21,8)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
            /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per il soggetto con codice fiscale: "+Substr(riga,1,16)+" per l'operazione extraconto in data: "+Substr(riga,21,8)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per il soggetto con codice fiscale: "+CPLib.Substr(riga,1,16)+" per l'operazione extraconto in data: "+CPLib.Substr(riga,21,8)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
          /* cNumMod := cNumMod + 1 */
          cNumMod = CPLib.Round(cNumMod+1,0);
        } // End If
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* gMsgProc := gMsgProc + 'Operazioni ExtraConto Inserite: '+LRTrim(Str(cNumNew,10,0)) + " - Operazioni ExtraConto Aggiornati: "+LRTrim(Str(cNumMod,10,0))+' dal file '+nomefileimport+NL */
      gMsgProc = gMsgProc+"Operazioni ExtraConto Inserite: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+" - Operazioni ExtraConto Aggiornati: "+CPLib.LRTrim(CPLib.Str(cNumMod,10,0))+" dal file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
            Error l_oErrorFault = new Error("Read on delegabo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
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
          m_cSql = m_cSql+GetFieldsName_061562D8(m_Ctx);
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
            /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per il soggetto con codice fiscale: "+Substr(riga,26,16)+" per il rapporto: "+Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per il soggetto con codice fiscale: "+CPLib.Substr(riga,26,16)+" per il rapporto: "+CPLib.Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
            /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per il soggetto con codice fiscale: "+Substr(riga,26,16)+" per il rapporto: "+Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per il soggetto con codice fiscale: "+CPLib.Substr(riga,26,16)+" per il rapporto: "+CPLib.Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
          /* cNumMod := cNumMod + 1 */
          cNumMod = CPLib.Round(cNumMod+1,0);
        } // End If
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* gMsgProc := gMsgProc + 'Deleghe Rapporti Inserite: '+LRTrim(Str(cNumNew,10,0)) + " - Deleghe Rapporti Aggiornate: "+LRTrim(Str(cNumMod,10,0)) + NL */
      gMsgProc = gMsgProc+"Deleghe Rapporti Inserite: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+" - Deleghe Rapporti Aggiornate: "+CPLib.LRTrim(CPLib.Str(cNumMod,10,0))+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
    }
  }
  void Page_18() throws Exception {
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_sogopefbo=null;
    CPResultSet Cursor_sogopebo=null;
    CPResultSet Cursor_soginfo=null;
    try {
      /* Importazione file SOGOPE.TXT altri soggetti operanti */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
        /* _unicode := '' */
        _unicode = "";
        /* _salta := 0 */
        _salta = CPLib.Round(0,0);
        /* Verfico la presenza di _unicode nelle tabelle rapopebo/operazbo/fraziobo */
        // * --- Read from rapopebo
        m_cServer = m_Ctx.GetServer("rapopebo");
        m_cPhName = m_Ctx.GetPhName("rapopebo");
        m_cSql = "";
        m_cSql = m_cSql+"UNIQUECODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,11,10),"C",10,0,m_cServer),m_cServer,CPLib.Substr(riga,11,10));
        if (m_Ctx.IsSharedTemp("rapopebo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("NUMPROG",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("UNIQUECODE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _idbase = Read_Cursor.GetString("IDBASE");
          cOpeProg2 = Read_Cursor.GetString("NUMPROG");
          _unicode = Read_Cursor.GetString("UNIQUECODE");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on rapopebo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _idbase = "";
          cOpeProg2 = "";
          _unicode = "";
          Read_Cursor.Close();
          // * --- Read from operazbo
          m_cServer = m_Ctx.GetServer("operazbo");
          m_cPhName = m_Ctx.GetPhName("operazbo");
          m_cSql = "";
          m_cSql = m_cSql+"UNIQUECODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,11,10),"C",10,0,m_cServer),m_cServer,CPLib.Substr(riga,11,10));
          if (m_Ctx.IsSharedTemp("operazbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("NUMPROG",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("UNIQUECODE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _idbase = Read_Cursor.GetString("IDBASE");
            cOpeProg2 = Read_Cursor.GetString("NUMPROG");
            _unicode = Read_Cursor.GetString("UNIQUECODE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on operazbo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _idbase = "";
            cOpeProg2 = "";
            _unicode = "";
            Read_Cursor.Close();
            // * --- Read from fraziobo
            m_cServer = m_Ctx.GetServer("fraziobo");
            m_cPhName = m_Ctx.GetPhName("fraziobo");
            m_cSql = "";
            m_cSql = m_cSql+"UNIQUECODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,11,10),"C",10,0,m_cServer),m_cServer,CPLib.Substr(riga,11,10));
            if (m_Ctx.IsSharedTemp("fraziobo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("NUMPROG",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("UNIQUECODE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _idbase = Read_Cursor.GetString("IDBASE");
              cOpeProg2 = Read_Cursor.GetString("NUMPROG");
              _unicode = Read_Cursor.GetString("UNIQUECODE");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on fraziobo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _idbase = "";
              cOpeProg2 = "";
              _unicode = "";
              Read_Cursor.Close();
              /* gMsgProc := gMsgProc +"Rilevati errore nella valorizazione del campo IDFILEBO nel file "+nomefileimport+" per il soggetto con codice fiscale: "+Substr(riga,21,16)+" non risulta associabile a nessuna informazione/operazione.  Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
              gMsgProc = gMsgProc+"Rilevati errore nella valorizazione del campo IDFILEBO nel file "+nomefileimport+" per il soggetto con codice fiscale: "+CPLib.Substr(riga,21,16)+" non risulta associabile a nessuna informazione/operazione.  Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              m_cLastMsgError = "";
              /* _esito := 1 */
              _esito = CPLib.Round(1,0);
              /* _salta := 1 */
              _salta = CPLib.Round(1,0);
              // Exit Loop
              if (true) {
                break;
              }
            }
            /* If _salta=0 and Substr(riga,11,10) = _unicode */
            if (CPLib.eqr(_salta,0) && CPLib.eqr(CPLib.Substr(riga,11,10),_unicode)) {
              // * --- Select from sogopefbo
              m_cServer = m_Ctx.GetServer("sogopefbo");
              m_cPhName = m_Ctx.GetPhName("sogopefbo");
              if (Cursor_sogopefbo!=null)
                Cursor_sogopefbo.Close();
              Cursor_sogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idbase,"?",0,0,m_cServer, m_oParameters),m_cServer,_idbase)+" "+")"+(m_Ctx.IsSharedTemp("sogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
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
              m_cSql = m_cSql+GetFieldsName_06813FF8(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(_idbase,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow+1,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,21,16),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,49,1),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
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
                /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per il soggetto operante con codice fiscale: "+Substr(riga,21,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
                gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per il soggetto operante con codice fiscale: "+CPLib.Substr(riga,21,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
              /* _salta := 1 */
              _salta = CPLib.Round(1,0);
              /* cNumNew := cNumNew+1 */
              cNumNew = CPLib.Round(cNumNew+1,0);
            } // End If
          }
          /* If _salta=0 and Substr(riga,11,10) = _unicode */
          if (CPLib.eqr(_salta,0) && CPLib.eqr(CPLib.Substr(riga,11,10),_unicode)) {
            // * --- Select from sogopebo
            m_cServer = m_Ctx.GetServer("sogopebo");
            m_cPhName = m_Ctx.GetPhName("sogopebo");
            if (Cursor_sogopebo!=null)
              Cursor_sogopebo.Close();
            Cursor_sogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idbase,"?",0,0,m_cServer, m_oParameters),m_cServer,_idbase)+" "+")"+(m_Ctx.IsSharedTemp("sogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
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
            m_cSql = m_cSql+GetFieldsName_0629AFF0(m_Ctx);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(_idbase,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow+1,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,21,16),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,49,1),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
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
              /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per il soggetto operante con codice fiscale: "+Substr(riga,21,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
              gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per il soggetto operante con codice fiscale: "+CPLib.Substr(riga,21,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
            /* cNumNew := cNumNew+1 */
            cNumNew = CPLib.Round(cNumNew+1,0);
          } // End If
        }
        /* If _salta=0 and Substr(riga,11,10) = _unicode */
        if (CPLib.eqr(_salta,0) && CPLib.eqr(CPLib.Substr(riga,11,10),_unicode)) {
          // * --- Select from soginfo
          m_cServer = m_Ctx.GetServer("soginfo");
          m_cPhName = m_Ctx.GetPhName("soginfo");
          if (Cursor_soginfo!=null)
            Cursor_soginfo.Close();
          Cursor_soginfo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idbase,"?",0,0,m_cServer, m_oParameters),m_cServer,_idbase)+" "+")"+(m_Ctx.IsSharedTemp("soginfo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
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
          m_cSql = m_cSql+GetFieldsName_05E65098(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_idbase,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow+1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,21,16),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,49,1),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
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
            /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per il soggetto operante con codice fiscale: "+Substr(riga,21,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per il soggetto operante con codice fiscale: "+CPLib.Substr(riga,21,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
          /* cNumNew := cNumNew+1 */
          cNumNew = CPLib.Round(cNumNew+1,0);
        } // End If
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport') */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* gMsgProc := gMsgProc + "Soggetti operanti inseriti: "+LRTrim(Str(cNumNew,10,0)) + " - Soggetti operanti aggiornati: "+LRTrim(Str(cNumMod,10,0)) + NL */
      gMsgProc = gMsgProc+"Soggetti operanti inseriti: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+" - Soggetti operanti aggiornati: "+CPLib.LRTrim(CPLib.Str(cNumMod,10,0))+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
        /* Verifico in intestbo che ci sia gi� un recod con lo stesso codice rapporto e memorizzo i dati della riga necessari per crearne una nuova. */
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
          /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario con codice fiscale "+Substr(riga,26,16)+" relativa al rapporto: "+Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
          gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario con codice fiscale "+CPLib.Substr(riga,26,16)+" relativa al rapporto: "+CPLib.Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          m_cLastMsgError = "";
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
        /* If cNumMod = 0 */
        if (CPLib.eqr(cNumMod,0)) {
          // * --- Insert into intestbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("intestbo");
          m_cPhName = m_Ctx.GetPhName("intestbo");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"intestbo")+" (";
          m_cSql = m_cSql+GetFieldsName_06440F00(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(ciidbase,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow+1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cidataini,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.Substr(riga,121,1))?"P":CPLib.Substr(riga,121,1)),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,26,16),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cinumprog,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,1,25),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(citiporap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(cidataini)+cinumprog+"O","?",0,0,m_cServer)+", ";
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
            /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario con codice fiscale "+Substr(riga,26,16)+" relativa al rapporto: "+Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario con codice fiscale "+CPLib.Substr(riga,26,16)+" relativa al rapporto: "+CPLib.Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
          /* cNumNew := cNumNew+1 */
          cNumNew = CPLib.Round(cNumNew+1,0);
        } // End If
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* gMsgProc := gMsgProc + "Intestatari inseriti: "+LRTrim(Str(cNumNew,10,0)) + " - Intestatari aggiornati: "+LRTrim(Str(cNumMod,10,0)) + NL */
      gMsgProc = gMsgProc+"Intestatari inseriti: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+" - Intestatari aggiornati: "+CPLib.LRTrim(CPLib.Str(cNumMod,10,0))+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Fine importazione del file '+nomefileimport // Messaggio Import */
      gMsgImp = "Fine importazione del file "+nomefileimport;
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
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
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
            Error l_oErrorFault = new Error("Read on xelegabo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
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
          m_cSql = m_cSql+GetFieldsName_0418D008(m_Ctx);
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
            /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per il soggetto con codice fiscale: "+Substr(riga,26,16)+" per il rapporto: "+Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per il soggetto con codice fiscale: "+CPLib.Substr(riga,26,16)+" per il rapporto: "+CPLib.Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
            /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per il soggetto con codice fiscale: "+Substr(riga,26,16)+" per il rapporto: "+Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per il soggetto con codice fiscale: "+CPLib.Substr(riga,26,16)+" per il rapporto: "+CPLib.Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
          /* cNumMod := cNumMod + 1 */
          cNumMod = CPLib.Round(cNumMod+1,0);
        } // End If
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* gMsgProc := gMsgProc + 'Deleghe Rapporti Inserite: '+LRTrim(Str(cNumNew,10,0)) + " - Deleghe Rapporti Aggiornate: "+LRTrim(Str(cNumMod,10,0)) + NL */
      gMsgProc = gMsgProc+"Deleghe Rapporti Inserite: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+" - Deleghe Rapporti Aggiornate: "+CPLib.LRTrim(CPLib.Str(cNumMod,10,0))+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
    }
  }
  void Page_21() throws Exception {
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_xogopefbo=null;
    CPResultSet Cursor_xogopebo=null;
    CPResultSet Cursor_xoginfo=null;
    try {
      /* Importazione file SOGOPE.TXT altri soggetti operanti in Provvisorio */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
        /* _unicode := '' */
        _unicode = "";
        /* _salta := 0 */
        _salta = CPLib.Round(0,0);
        /* Verfico la presenza di _unicode nelle tabelle rapopebo/operazbo/fraziobo */
        // * --- Read from xapopebo
        m_cServer = m_Ctx.GetServer("xapopebo");
        m_cPhName = m_Ctx.GetPhName("xapopebo");
        m_cSql = "";
        m_cSql = m_cSql+"UNIQUECODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,11,10),"C",10,0,m_cServer),m_cServer,CPLib.Substr(riga,11,10));
        if (m_Ctx.IsSharedTemp("xapopebo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("NUMPROG",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("UNIQUECODE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _idbase = Read_Cursor.GetString("IDBASE");
          cInfProg2 = Read_Cursor.GetString("NUMPROG");
          _unicode = Read_Cursor.GetString("UNIQUECODE");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on xapopebo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _idbase = "";
          cInfProg2 = "";
          _unicode = "";
          Read_Cursor.Close();
          // * --- Read from xperazbo
          m_cServer = m_Ctx.GetServer("xperazbo");
          m_cPhName = m_Ctx.GetPhName("xperazbo");
          m_cSql = "";
          m_cSql = m_cSql+"UNIQUECODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,11,10),"C",10,0,m_cServer),m_cServer,CPLib.Substr(riga,11,10));
          if (m_Ctx.IsSharedTemp("xperazbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("NUMPROG",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("UNIQUECODE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _idbase = Read_Cursor.GetString("IDBASE");
            cInfProg2 = Read_Cursor.GetString("NUMPROG");
            _unicode = Read_Cursor.GetString("UNIQUECODE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on xperazbo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _idbase = "";
            cInfProg2 = "";
            _unicode = "";
            Read_Cursor.Close();
            // * --- Read from xraziobo
            m_cServer = m_Ctx.GetServer("xraziobo");
            m_cPhName = m_Ctx.GetPhName("xraziobo");
            m_cSql = "";
            m_cSql = m_cSql+"UNIQUECODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,11,10),"C",10,0,m_cServer),m_cServer,CPLib.Substr(riga,11,10));
            if (m_Ctx.IsSharedTemp("xraziobo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("NUMPROG",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("UNIQUECODE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _idbase = Read_Cursor.GetString("IDBASE");
              cInfProg2 = Read_Cursor.GetString("NUMPROG");
              _unicode = Read_Cursor.GetString("UNIQUECODE");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on xraziobo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _idbase = "";
              cInfProg2 = "";
              _unicode = "";
              Read_Cursor.Close();
              /* gMsgProc := gMsgProc +"Rilevati errore nella valorizazione del campo IDFILEBO nel file "+nomefileimport+" per il soggetto con codice fiscale: "+Substr(riga,21,16)+" non risulta associabile a nessuna informazione/operazione.  Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
              gMsgProc = gMsgProc+"Rilevati errore nella valorizazione del campo IDFILEBO nel file "+nomefileimport+" per il soggetto con codice fiscale: "+CPLib.Substr(riga,21,16)+" non risulta associabile a nessuna informazione/operazione.  Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              /* _esito := 1 */
              _esito = CPLib.Round(1,0);
              m_cLastMsgError = "";
              /* _salta := 1 */
              _salta = CPLib.Round(1,0);
              // Exit Loop
              if (true) {
                break;
              }
            }
            /* If _salta=0 and Substr(riga,11,10) = _unicode */
            if (CPLib.eqr(_salta,0) && CPLib.eqr(CPLib.Substr(riga,11,10),_unicode)) {
              // * --- Select from xogopefbo
              m_cServer = m_Ctx.GetServer("xogopefbo");
              m_cPhName = m_Ctx.GetPhName("xogopefbo");
              if (Cursor_xogopefbo!=null)
                Cursor_xogopefbo.Close();
              Cursor_xogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idbase,"?",0,0,m_cServer, m_oParameters),m_cServer,_idbase)+" "+")"+(m_Ctx.IsSharedTemp("xogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
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
              m_cSql = m_cSql+GetFieldsName_05FC32C8(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(_idbase,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow+1,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,21,16),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,49,1),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
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
                /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per il soggetto operante con codice fiscale: "+Substr(riga,21,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
                gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per il soggetto operante con codice fiscale: "+CPLib.Substr(riga,21,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
              /* _salta := 1 */
              _salta = CPLib.Round(1,0);
              /* cNumNew := cNumNew+1 */
              cNumNew = CPLib.Round(cNumNew+1,0);
            } // End If
          }
          /* If _salta=0 and Substr(riga,11,10) = _unicode */
          if (CPLib.eqr(_salta,0) && CPLib.eqr(CPLib.Substr(riga,11,10),_unicode)) {
            // * --- Select from xogopebo
            m_cServer = m_Ctx.GetServer("xogopebo");
            m_cPhName = m_Ctx.GetPhName("xogopebo");
            if (Cursor_xogopebo!=null)
              Cursor_xogopebo.Close();
            Cursor_xogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idbase,"?",0,0,m_cServer, m_oParameters),m_cServer,_idbase)+" "+")"+(m_Ctx.IsSharedTemp("xogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
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
            m_cSql = m_cSql+GetFieldsName_05B5D500(m_Ctx);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(_idbase,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow+1,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,21,16),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,49,1),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
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
              /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per il soggetto operante con codice fiscale: "+Substr(riga,21,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
              gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per il soggetto operante con codice fiscale: "+CPLib.Substr(riga,21,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
            /* cNumNew := cNumNew+1 */
            cNumNew = CPLib.Round(cNumNew+1,0);
          } // End If
        }
        /* If _salta=0 and Substr(riga,11,10) = _unicode */
        if (CPLib.eqr(_salta,0) && CPLib.eqr(CPLib.Substr(riga,11,10),_unicode)) {
          // * --- Select from xoginfo
          m_cServer = m_Ctx.GetServer("xoginfo");
          m_cPhName = m_Ctx.GetPhName("xoginfo");
          if (Cursor_xoginfo!=null)
            Cursor_xoginfo.Close();
          Cursor_xoginfo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idbase,"?",0,0,m_cServer, m_oParameters),m_cServer,_idbase)+" "+")"+(m_Ctx.IsSharedTemp("xoginfo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
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
          m_cSql = m_cSql+GetFieldsName_0630AA68(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_idbase,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow+1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,21,16),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,49,1),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
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
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows inserted
            /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per il soggetto operante con codice fiscale: "+Substr(riga,21,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per il soggetto operante con codice fiscale: "+CPLib.Substr(riga,21,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
          /* cNumNew := cNumNew+1 */
          cNumNew = CPLib.Round(cNumNew+1,0);
        } // End If
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport') */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* gMsgProc := gMsgProc + "Soggetti operanti inseriti: "+LRTrim(Str(cNumNew,10,0)) + " - Soggetti operanti aggiornati: "+LRTrim(Str(cNumMod,10,0)) + NL */
      gMsgProc = gMsgProc+"Soggetti operanti inseriti: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+" - Soggetti operanti aggiornati: "+CPLib.LRTrim(CPLib.Str(cNumMod,10,0))+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
        /* Verifico in intestbo che ci sia gi� un recod con lo stesso codice rapporto e memorizzo i dati della riga necessari per crearne una nuova. */
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
          /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario con codice fiscale "+Substr(riga,26,16)+" relativa al rapporto: "+Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
          gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario con codice fiscale "+CPLib.Substr(riga,26,16)+" relativa al rapporto: "+CPLib.Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          m_cLastMsgError = "";
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
        /* If cNumMod = 0 */
        if (CPLib.eqr(cNumMod,0)) {
          // * --- Insert into xntestbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xntestbo");
          m_cPhName = m_Ctx.GetPhName("xntestbo");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"xntestbo")+" (";
          m_cSql = m_cSql+GetFieldsName_0643C0D0(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(ciidbase,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow+1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cidataini,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.Substr(riga,121,1))?"P":CPLib.Substr(riga,121,1)),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Substr(riga,26,16),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cinumprog,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,1,25),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(citiporap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(cidataini)+cinumprog+"O","?",0,0,m_cServer)+", ";
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
            /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario con codice fiscale "+Substr(riga,26,16)+" relativa al rapporto: "+Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario con codice fiscale "+CPLib.Substr(riga,26,16)+" relativa al rapporto: "+CPLib.Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
          /* cNumNew := cNumNew+1 */
          cNumNew = CPLib.Round(cNumNew+1,0);
        } // End If
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* gMsgProc := gMsgProc + "Intestatari inseriti: "+LRTrim(Str(cNumNew,10,0)) + " - Intestatari aggiornati: "+LRTrim(Str(cNumMod,10,0)) + NL */
      gMsgProc = gMsgProc+"Intestatari inseriti: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+" - Intestatari aggiornati: "+CPLib.LRTrim(CPLib.Str(cNumMod,10,0))+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Fine importazione del file '+nomefileimport // Messaggio Import */
      gMsgImp = "Fine importazione del file "+nomefileimport;
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
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
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
            Error l_oErrorFault = new Error("Read on jelegabo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
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
          m_cSql = m_cSql+GetFieldsName_062F71F0(m_Ctx);
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
            /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per il soggetto con codice fiscale: "+Substr(riga,26,16)+" per il rapporto: "+Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per il soggetto con codice fiscale: "+CPLib.Substr(riga,26,16)+" per il rapporto: "+CPLib.Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
            /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per il soggetto con codice fiscale: "+Substr(riga,26,16)+" per il rapporto: "+Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per il soggetto con codice fiscale: "+CPLib.Substr(riga,26,16)+" per il rapporto: "+CPLib.Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
          /* cNumMod := cNumMod + 1 */
          cNumMod = CPLib.Round(cNumMod+1,0);
        } // End If
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* gMsgProc := gMsgProc + 'Deleghe Rapporti Inserite: '+LRTrim(Str(cNumNew,10,0)) + " - Deleghe Rapporti Aggiornate: "+LRTrim(Str(cNumMod,10,0)) + NL */
      gMsgProc = gMsgProc+"Deleghe Rapporti Inserite: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+" - Deleghe Rapporti Aggiornate: "+CPLib.LRTrim(CPLib.Str(cNumMod,10,0))+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        /* cMaxRow := 0 */
        cMaxRow = CPLib.Round(0,0);
        /* _unicode := '' */
        _unicode = "";
        /* _salta := 0 */
        _salta = CPLib.Round(0,0);
        /* Verfico la presenza di _unicode nelle tabelle rapopebo/operazbo/fraziobo */
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
          _unicode = Read_Cursor.GetString("IDBASE");
          cInfProg2 = Read_Cursor.GetString("NUMPROG");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on japopebo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _unicode = "";
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
            _unicode = Read_Cursor.GetString("IDBASE");
            cOpeProg2 = Read_Cursor.GetString("NUMPROG");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on jperazbo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _unicode = "";
            cOpeProg2 = "";
            Read_Cursor.Close();
            /* gMsgProc := gMsgProc +"Rilevati errore nella valorizazione del campo IDFILEBO nel file "+nomefileimport+" per il soggetto con codice fiscale: "+Substr(riga,21,16)+" non risulta associabile a nessuna informazione/operazione.  Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Rilevati errore nella valorizazione del campo IDFILEBO nel file "+nomefileimport+" per il soggetto con codice fiscale: "+CPLib.Substr(riga,21,16)+" non risulta associabile a nessuna informazione/operazione.  Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            m_cLastMsgError = "";
            /* _salta := 1 */
            _salta = CPLib.Round(1,0);
            // Exit Loop
            if (true) {
              break;
            }
          }
          /* If _salta=0 and Substr(riga,11,10) = _unicode */
          if (CPLib.eqr(_salta,0) && CPLib.eqr(CPLib.Substr(riga,11,10),_unicode)) {
            // * --- Select from jogopebo
            m_cServer = m_Ctx.GetServer("jogopebo");
            m_cPhName = m_Ctx.GetPhName("jogopebo");
            if (Cursor_jogopebo!=null)
              Cursor_jogopebo.Close();
            Cursor_jogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_unicode,"?",0,0,m_cServer, m_oParameters),m_cServer,_unicode)+" "+")"+(m_Ctx.IsSharedTemp("jogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
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
            m_cSql = m_cSql+GetFieldsName_05E62980(m_Ctx);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(_unicode,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow+1,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,21,16),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,49,1),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_unicode,"?",0,0,m_cServer)+", ";
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
              /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per il soggetto operante con codice fiscale: "+Substr(riga,21,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
              gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per il soggetto operante con codice fiscale: "+CPLib.Substr(riga,21,16)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
            /* cNumNew := cNumNew+1 */
            cNumNew = CPLib.Round(cNumNew+1,0);
          } // End If
        }
        /* If _salta=0 and Substr(riga,11,10) = _unicode */
        if (CPLib.eqr(_salta,0) && CPLib.eqr(CPLib.Substr(riga,11,10),_unicode)) {
          // * --- Select from joginfo
          m_cServer = m_Ctx.GetServer("joginfo");
          m_cPhName = m_Ctx.GetPhName("joginfo");
          if (Cursor_joginfo!=null)
            Cursor_joginfo.Close();
          Cursor_joginfo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_unicode,"?",0,0,m_cServer, m_oParameters),m_cServer,_unicode)+" "+")"+(m_Ctx.IsSharedTemp("joginfo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
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
          m_cSql = m_cSql+GetFieldsName_06444158(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_unicode,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow+1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,21,16),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,49,1),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_unicode,"?",0,0,m_cServer)+", ";
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
      /* gMsgProc := gMsgProc + "Soggetti operanti inseriti: "+LRTrim(Str(cNumNew,10,0)) + " - Soggetti operanti aggiornati: "+LRTrim(Str(cNumMod,10,0)) + NL */
      gMsgProc = gMsgProc+"Soggetti operanti inseriti: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+" - Soggetti operanti aggiornati: "+CPLib.LRTrim(CPLib.Str(cNumMod,10,0))+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
    CPResultSet Cursor_jntestbo=null;
    try {
      /* Importazione file INTAGE.TXT altri intestatari */
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      /* cNumMod := 0 */
      cNumMod = CPLib.Round(0,0);
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        /* cMaxRow := 0 */
        cMaxRow = CPLib.Round(0,0);
        /* cNumMod := 0 */
        cNumMod = CPLib.Round(0,0);
        /* Verifico in intestbo che ci sia gi� un recod con lo stesso codice rapporto e memorizzo i dati della riga necessari per crearne una nuova. */
        // * --- Select from jntestbo
        m_cServer = m_Ctx.GetServer("jntestbo");
        m_cPhName = m_Ctx.GetPhName("jntestbo");
        if (Cursor_jntestbo!=null)
          Cursor_jntestbo.Close();
        Cursor_jntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,1,25),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Substr(riga,1,25))+" "+")"+(m_Ctx.IsSharedTemp("jntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM ",m_cServer,m_Ctx,true));
        if ( ! (Cursor_jntestbo.Eof())) {
          while ( ! (Cursor_jntestbo.Eof())) {
            /* If Substr(riga,26,16)=jntestbo->CODINTER */
            if (CPLib.eqr(CPLib.Substr(riga,26,16),Cursor_jntestbo.GetString("CODINTER"))) {
              /* cNumMod := jntestbo->CPROWNUM */
              cNumMod = CPLib.Round(Cursor_jntestbo.GetDouble("CPROWNUM"),0);
            } // End If
            /* cMaxRow := jntestbo->CPROWNUM */
            cMaxRow = CPLib.Round(Cursor_jntestbo.GetDouble("CPROWNUM"),0);
            /* ciidbase := jntestbo->IDBASE */
            ciidbase = Cursor_jntestbo.GetString("IDBASE");
            /* cidataini := jntestbo->DATAINI */
            cidataini = Cursor_jntestbo.GetDate("DATAINI");
            /* cidatafine := jntestbo->DATAFINE */
            cidatafine = Cursor_jntestbo.GetDate("DATAFINE");
            /* cicodinter := jntestbo->CODINTER */
            cicodinter = Cursor_jntestbo.GetString("CODINTER");
            /* cinumprog := jntestbo->NUMPROG1 */
            cinumprog = Cursor_jntestbo.GetString("NUMPROG1");
            /* citiporap := jntestbo->TIPORAP */
            citiporap = Cursor_jntestbo.GetString("TIPORAP");
            Cursor_jntestbo.Next();
          }
          m_cConnectivityError = Cursor_jntestbo.ErrorMessage();
        } else {
          // No rows selected
          /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario con codice fiscale "+Substr(riga,26,16)+" relativa al rapporto: "+Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
          gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario con codice fiscale "+CPLib.Substr(riga,26,16)+" relativa al rapporto: "+CPLib.Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          m_cLastMsgError = "";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
          // Exit Loop
          if (true) {
            break;
          }
        }
        Cursor_jntestbo.Close();
        // * --- End Select
        /* Se trovo il record inserisco il nuovo intestatario */
        /* If cNumMod = 0 */
        if (CPLib.eqr(cNumMod,0)) {
          // * --- Insert into jntestbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("jntestbo");
          m_cPhName = m_Ctx.GetPhName("jntestbo");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"jntestbo")+" (";
          m_cSql = m_cSql+GetFieldsName_062E9F20(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(ciidbase,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow+1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cidataini,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.Substr(riga,121,1))?"P":CPLib.Substr(riga,121,1)),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,26,16),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cinumprog,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,1,25),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(citiporap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(cidataini)+cinumprog+"O","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(CPLib.Substr(riga,26,16))+CPLib.Space(5),16),"?",0,0,m_cServer)+", ";
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
            /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario con codice fiscale "+Substr(riga,26,16)+" relativa al rapporto: "+Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per la registrazione dell'intestatario con codice fiscale "+CPLib.Substr(riga,26,16)+" relativa al rapporto: "+CPLib.Substr(riga,1,25)+" Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verr� annulata automaticamente."+"\n";
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
          /* cNumNew := cNumNew+1 */
          cNumNew = CPLib.Round(cNumNew+1,0);
        } // End If
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* gMsgProc := gMsgProc + "Intestatari inseriti: "+LRTrim(Str(cNumNew,10,0)) + " - Intestatari aggiornati: "+LRTrim(Str(cNumMod,10,0)) + NL */
      gMsgProc = gMsgProc+"Intestatari inseriti: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+" - Intestatari aggiornati: "+CPLib.LRTrim(CPLib.Str(cNumMod,10,0))+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Fine importazione del file '+nomefileimport // Messaggio Import */
      gMsgImp = "Fine importazione del file "+nomefileimport;
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Cursor_jntestbo!=null)
          Cursor_jntestbo.Close();
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
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        /* cMaxRow := 0 */
        cMaxRow = CPLib.Round(0,0);
        /* cNumMod := 0 */
        cNumMod = CPLib.Round(0,0);
        /* _unicode := '' */
        _unicode = "";
        /* If Substr(riga,48,1)='F' */
        if (CPLib.eqr(CPLib.Substr(riga,48,1),"F")) {
          // * --- Read from xraziobo
          m_cServer = m_Ctx.GetServer("xraziobo");
          m_cPhName = m_Ctx.GetPhName("xraziobo");
          m_cSql = "";
          m_cSql = m_cSql+"UNIQUECODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,11,10),"C",10,0,m_cServer),m_cServer,CPLib.Substr(riga,11,10));
          if (m_Ctx.IsSharedTemp("xraziobo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _unicode = Read_Cursor.GetString("IDBASE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on xraziobo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _unicode = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(_unicode)) */
          if (CPLib.Empty(CPLib.LRTrim(_unicode))) {
            // * --- Read from fraziobo
            m_cServer = m_Ctx.GetServer("fraziobo");
            m_cPhName = m_Ctx.GetPhName("fraziobo");
            m_cSql = "";
            m_cSql = m_cSql+"UNIQUECODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,11,10),"C",10,0,m_cServer),m_cServer,CPLib.Substr(riga,11,10));
            if (m_Ctx.IsSharedTemp("fraziobo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _unicode = Read_Cursor.GetString("IDBASE");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on fraziobo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _unicode = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If not(Empty(LRTrim(_unicode))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(_unicode)))) {
              // * --- Insert into clientifrz from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("clientifrz");
              m_cPhName = m_Ctx.GetPhName("clientifrz");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"clientifrz")+" (";
              m_cSql = m_cSql+GetFieldsName_0418C510(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(_unicode,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,21,16),"?",0,0,m_cServer)+", ";
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
              }
            } // End If
          } else { // Else
            // * --- Insert into xlientifrz from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xlientifrz");
            m_cPhName = m_Ctx.GetPhName("xlientifrz");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.InsertIntoStatement(m_Ctx,"xlientifrz")+" (";
            m_cSql = m_cSql+GetFieldsName_05FC8920(m_Ctx);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(_unicode,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,21,16),"?",0,0,m_cServer)+", ";
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
            }
          } // End If
          /* ElseIf Substr(riga,48,1)='O' */
        } else if (CPLib.eqr(CPLib.Substr(riga,48,1),"O")) {
          // * --- Read from xperazbo
          m_cServer = m_Ctx.GetServer("xperazbo");
          m_cPhName = m_Ctx.GetPhName("xperazbo");
          m_cSql = "";
          m_cSql = m_cSql+"UNIQUECODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,11,10),"C",10,0,m_cServer),m_cServer,CPLib.Substr(riga,11,10));
          if (m_Ctx.IsSharedTemp("xperazbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _unicode = Read_Cursor.GetString("IDBASE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on xperazbo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _unicode = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(_unicode)) */
          if (CPLib.Empty(CPLib.LRTrim(_unicode))) {
            // * --- Read from operazbo
            m_cServer = m_Ctx.GetServer("operazbo");
            m_cPhName = m_Ctx.GetPhName("operazbo");
            m_cSql = "";
            m_cSql = m_cSql+"UNIQUECODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,11,10),"C",10,0,m_cServer),m_cServer,CPLib.Substr(riga,11,10));
            if (m_Ctx.IsSharedTemp("operazbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _unicode = Read_Cursor.GetString("IDBASE");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on operazbo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _unicode = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If not(Empty(LRTrim(_unicode))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(_unicode)))) {
              // * --- Insert into clientiope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("clientiope");
              m_cPhName = m_Ctx.GetPhName("clientiope");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"clientiope")+" (";
              m_cSql = m_cSql+GetFieldsName_079F4808(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(_unicode,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,21,16),"?",0,0,m_cServer)+", ";
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
              }
            } // End If
          } else { // Else
            // * --- Insert into xlientiope from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xlientiope");
            m_cPhName = m_Ctx.GetPhName("xlientiope");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.InsertIntoStatement(m_Ctx,"xlientiope")+" (";
            m_cSql = m_cSql+GetFieldsName_079F2498(m_Ctx);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(_unicode,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,21,16),"?",0,0,m_cServer)+", ";
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
            }
          } // End If
        } // End If
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* gMsgProc := gMsgProc + 'Intestatari Operazioni Inseriti: '+LRTrim(Str(cNumNew,10,0)) + " - Intestatari Operazioni Aggiornati: "+LRTrim(Str(cNumMod,10,0)) + NL */
      gMsgProc = gMsgProc+"Intestatari Operazioni Inseriti: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+" - Intestatari Operazioni Aggiornati: "+CPLib.LRTrim(CPLib.Str(cNumMod,10,0))+"\n";
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
          /* Case At('archinf.txt',Lower(buffernomefile)) <> 0 */
        } else if (CPLib.ne(CPLib.At("archinf.txt",CPLib.Lower(buffernomefile)),0)) {
          /* _priorita := 4 */
          _priorita = CPLib.Round(4,0);
          /* Case At('archope.txt',Lower(buffernomefile)) <> 0 */
        } else if (CPLib.ne(CPLib.At("archope.txt",CPLib.Lower(buffernomefile)),0)) {
          /* _priorita := 5 */
          _priorita = CPLib.Round(5,0);
          /* Case At('archfraz.txt',Lower(buffernomefile)) <> 0 */
        } else if (CPLib.ne(CPLib.At("archfraz.txt",CPLib.Lower(buffernomefile)),0)) {
          /* _priorita := 6 */
          _priorita = CPLib.Round(6,0);
          /* Case At('opex.txt',Lower(buffernomefile)) <> 0 */
        } else if (CPLib.ne(CPLib.At("opex.txt",CPLib.Lower(buffernomefile)),0)) {
          /* _priorita := 7 */
          _priorita = CPLib.Round(7,0);
          /* Case At('archtito.txt',Lower(buffernomefile)) <> 0 */
        } else if (CPLib.ne(CPLib.At("archtito.txt",CPLib.Lower(buffernomefile)),0)) {
          /* _priorita := 8 */
          _priorita = CPLib.Round(8,0);
          /* Case At('procdel.txt',Lower(buffernomefile)) <> 0 */
        } else if (CPLib.ne(CPLib.At("procdel.txt",CPLib.Lower(buffernomefile)),0)) {
          /* _priorita := 9 */
          _priorita = CPLib.Round(9,0);
          /* Case At('sogope.txt',Lower(buffernomefile)) <> 0 */
        } else if (CPLib.ne(CPLib.At("sogope.txt",CPLib.Lower(buffernomefile)),0)) {
          /* _priorita := 10 */
          _priorita = CPLib.Round(10,0);
          /* Case At('intest.txt',Lower(buffernomefile)) <> 0 */
        } else if (CPLib.ne(CPLib.At("intest.txt",CPLib.Lower(buffernomefile)),0)) {
          /* _priorita := 11 */
          _priorita = CPLib.Round(11,0);
          /* Case At('stopers.txt',Lower(buffernomefile)) <> 0 */
        } else if (CPLib.ne(CPLib.At("stopers.txt",CPLib.Lower(buffernomefile)),0)) {
          /* _priorita := 12 */
          _priorita = CPLib.Round(12,0);
          /* Case At('personew.txt',Lower(buffernomefile)) <> 0 */
        } else if (CPLib.ne(CPLib.At("personew.txt",CPLib.Lower(buffernomefile)),0)) {
          /* _priorita := 13 */
          _priorita = CPLib.Round(13,0);
          /* Case At('rapage.txt',Lower(buffernomefile)) <> 0 */
        } else if (CPLib.ne(CPLib.At("rapage.txt",CPLib.Lower(buffernomefile)),0)) {
          /* _priorita := 14 */
          _priorita = CPLib.Round(14,0);
          /* Case At('infage.txt',Lower(buffernomefile)) <> 0 */
        } else if (CPLib.ne(CPLib.At("infage.txt",CPLib.Lower(buffernomefile)),0)) {
          /* _priorita := 15 */
          _priorita = CPLib.Round(15,0);
          /* Case At('intage.txt',Lower(buffernomefile)) <> 0 */
        } else if (CPLib.ne(CPLib.At("intage.txt",CPLib.Lower(buffernomefile)),0)) {
          /* _priorita := 16 */
          _priorita = CPLib.Round(16,0);
          /* Case At('opeage.txt',Lower(buffernomefile)) <> 0 */
        } else if (CPLib.ne(CPLib.At("opeage.txt",CPLib.Lower(buffernomefile)),0)) {
          /* _priorita := 17 */
          _priorita = CPLib.Round(17,0);
          /* Case At('procage.txt',Lower(buffernomefile)) <> 0 */
        } else if (CPLib.ne(CPLib.At("procage.txt",CPLib.Lower(buffernomefile)),0)) {
          /* _priorita := 18 */
          _priorita = CPLib.Round(18,0);
          /* Case At('sogcli.txt',Lower(buffernomefile)) <> 0 */
        } else if (CPLib.ne(CPLib.At("sogcli.txt",CPLib.Lower(buffernomefile)),0)) {
          /* _priorita := 19 */
          _priorita = CPLib.Round(19,0);
          /* Case At('sogben.txt',Lower(buffernomefile)) <> 0 */
        } else if (CPLib.ne(CPLib.At("sogben.txt",CPLib.Lower(buffernomefile)),0)) {
          /* _priorita := 20 */
          _priorita = CPLib.Round(20,0);
          /* Case At('sogaltro.txt',Lower(buffernomefile)) <> 0 */
        } else if (CPLib.ne(CPLib.At("sogaltro.txt",CPLib.Lower(buffernomefile)),0)) {
          /* _priorita := 21 */
          _priorita = CPLib.Round(21,0);
        } // End Case
        // * --- Insert into tmp_list_imprich from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_list_imprich");
        m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_list_imprich")+" (";
        m_cSql = m_cSql+GetFieldsName_072D0390(m_Ctx);
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
  void Page_28() throws Exception {
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_beneficfrz=null;
    CPResultSet Cursor_xeneficfrz=null;
    CPResultSet Cursor_beneficope=null;
    CPResultSet Cursor_xeneficope=null;
    try {
      /* Legge il file di testo e porta i dati nella tabella */
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      /* cNumMod := 0 */
      cNumMod = CPLib.Round(0,0);
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        /* If not(Empty(LRTrim(riga))) */
        if ( ! (CPLib.Empty(CPLib.LRTrim(riga)))) {
          /* cMaxRow := 0 */
          cMaxRow = CPLib.Round(0,0);
          /* cNumMod := 0 */
          cNumMod = CPLib.Round(0,0);
          /* _unicode := '' */
          _unicode = "";
          /* If Substr(riga,48,1)='F' */
          if (CPLib.eqr(CPLib.Substr(riga,48,1),"F")) {
            // * --- Read from xraziobo
            m_cServer = m_Ctx.GetServer("xraziobo");
            m_cPhName = m_Ctx.GetPhName("xraziobo");
            m_cSql = "";
            m_cSql = m_cSql+"UNIQUECODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,11,10),"C",10,0,m_cServer),m_cServer,CPLib.Substr(riga,11,10));
            if (m_Ctx.IsSharedTemp("xraziobo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _unicode = Read_Cursor.GetString("IDBASE");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on xraziobo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _unicode = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(LRTrim(_unicode)) */
            if (CPLib.Empty(CPLib.LRTrim(_unicode))) {
              // * --- Read from fraziobo
              m_cServer = m_Ctx.GetServer("fraziobo");
              m_cPhName = m_Ctx.GetPhName("fraziobo");
              m_cSql = "";
              m_cSql = m_cSql+"UNIQUECODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,11,10),"C",10,0,m_cServer),m_cServer,CPLib.Substr(riga,11,10));
              if (m_Ctx.IsSharedTemp("fraziobo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _unicode = Read_Cursor.GetString("IDBASE");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on fraziobo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _unicode = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If not(Empty(LRTrim(_unicode))) */
              if ( ! (CPLib.Empty(CPLib.LRTrim(_unicode)))) {
                // * --- Select from beneficfrz
                m_cServer = m_Ctx.GetServer("beneficfrz");
                m_cPhName = m_Ctx.GetPhName("beneficfrz");
                if (Cursor_beneficfrz!=null)
                  Cursor_beneficfrz.Close();
                Cursor_beneficfrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_unicode,"?",0,0,m_cServer, m_oParameters),m_cServer,_unicode)+" "+")"+(m_Ctx.IsSharedTemp("beneficfrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM ",m_cServer,m_Ctx,true));
                while ( ! (Cursor_beneficfrz.Eof())) {
                  /* cMaxRow := beneficfrz->CPROWNUM */
                  cMaxRow = CPLib.Round(Cursor_beneficfrz.GetDouble("CPROWNUM"),0);
                  Cursor_beneficfrz.Next();
                }
                m_cConnectivityError = Cursor_beneficfrz.ErrorMessage();
                Cursor_beneficfrz.Close();
                // * --- End Select
                /* cMaxRow := cMaxRow + 1 */
                cMaxRow = CPLib.Round(cMaxRow+1,0);
                // * --- Insert into beneficfrz from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("beneficfrz");
                m_cPhName = m_Ctx.GetPhName("beneficfrz");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.InsertIntoStatement(m_Ctx,"beneficfrz")+" (";
                m_cSql = m_cSql+GetFieldsName_05CC5D50(m_Ctx);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(_unicode,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,21,16),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,49,1),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,75,70),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,145,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,148,30),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,178,6),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,184,2),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,186,35),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,221,5),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow,"?",0,0)+", ";
                if (m_Ctx.IsSharedTemp("beneficfrz")) {
                  m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                }
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"beneficfrz",true);
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
              } // End If
            } else { // Else
              // * --- Select from xeneficfrz
              m_cServer = m_Ctx.GetServer("xeneficfrz");
              m_cPhName = m_Ctx.GetPhName("xeneficfrz");
              if (Cursor_xeneficfrz!=null)
                Cursor_xeneficfrz.Close();
              Cursor_xeneficfrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_unicode,"?",0,0,m_cServer, m_oParameters),m_cServer,_unicode)+" "+")"+(m_Ctx.IsSharedTemp("xeneficfrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM ",m_cServer,m_Ctx,true));
              while ( ! (Cursor_xeneficfrz.Eof())) {
                /* cMaxRow := xeneficfrz->CPROWNUM */
                cMaxRow = CPLib.Round(Cursor_xeneficfrz.GetDouble("CPROWNUM"),0);
                Cursor_xeneficfrz.Next();
              }
              m_cConnectivityError = Cursor_xeneficfrz.ErrorMessage();
              Cursor_xeneficfrz.Close();
              // * --- End Select
              /* cMaxRow := cMaxRow + 1 */
              cMaxRow = CPLib.Round(cMaxRow+1,0);
              // * --- Insert into xeneficfrz from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("xeneficfrz");
              m_cPhName = m_Ctx.GetPhName("xeneficfrz");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"xeneficfrz")+" (";
              m_cSql = m_cSql+GetFieldsName_061F53D8(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(_unicode,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,21,16),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,49,1),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,75,70),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,145,3),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,148,30),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,178,6),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,184,2),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,186,35),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,221,5),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow,"?",0,0)+", ";
              if (m_Ctx.IsSharedTemp("xeneficfrz")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xeneficfrz",true);
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
            } // End If
            /* ElseIf Substr(riga,48,1)='O' */
          } else if (CPLib.eqr(CPLib.Substr(riga,48,1),"O")) {
            // * --- Read from xperazbo
            m_cServer = m_Ctx.GetServer("xperazbo");
            m_cPhName = m_Ctx.GetPhName("xperazbo");
            m_cSql = "";
            m_cSql = m_cSql+"UNIQUECODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,11,10),"C",10,0,m_cServer),m_cServer,CPLib.Substr(riga,11,10));
            if (m_Ctx.IsSharedTemp("xperazbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _unicode = Read_Cursor.GetString("IDBASE");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on xperazbo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _unicode = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(LRTrim(_unicode)) */
            if (CPLib.Empty(CPLib.LRTrim(_unicode))) {
              // * --- Read from operazbo
              m_cServer = m_Ctx.GetServer("operazbo");
              m_cPhName = m_Ctx.GetPhName("operazbo");
              m_cSql = "";
              m_cSql = m_cSql+"UNIQUECODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,11,10),"C",10,0,m_cServer),m_cServer,CPLib.Substr(riga,11,10));
              if (m_Ctx.IsSharedTemp("operazbo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _unicode = Read_Cursor.GetString("IDBASE");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on operazbo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _unicode = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If not(Empty(LRTrim(_unicode))) */
              if ( ! (CPLib.Empty(CPLib.LRTrim(_unicode)))) {
                // * --- Select from beneficope
                m_cServer = m_Ctx.GetServer("beneficope");
                m_cPhName = m_Ctx.GetPhName("beneficope");
                if (Cursor_beneficope!=null)
                  Cursor_beneficope.Close();
                Cursor_beneficope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_unicode,"?",0,0,m_cServer, m_oParameters),m_cServer,_unicode)+" "+")"+(m_Ctx.IsSharedTemp("beneficope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM ",m_cServer,m_Ctx,true));
                while ( ! (Cursor_beneficope.Eof())) {
                  /* cMaxRow := beneficope->CPROWNUM */
                  cMaxRow = CPLib.Round(Cursor_beneficope.GetDouble("CPROWNUM"),0);
                  Cursor_beneficope.Next();
                }
                m_cConnectivityError = Cursor_beneficope.ErrorMessage();
                Cursor_beneficope.Close();
                // * --- End Select
                /* cMaxRow := cMaxRow + 1 */
                cMaxRow = CPLib.Round(cMaxRow+1,0);
                // * --- Insert into beneficope from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("beneficope");
                m_cPhName = m_Ctx.GetPhName("beneficope");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.InsertIntoStatement(m_Ctx,"beneficope")+" (";
                m_cSql = m_cSql+GetFieldsName_072C39A0(m_Ctx);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(_unicode,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,21,16),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,49,1),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,75,70),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,145,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,148,30),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,178,6),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,184,2),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,186,35),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,221,5),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow,"?",0,0)+", ";
                if (m_Ctx.IsSharedTemp("beneficope")) {
                  m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                }
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"beneficope",true);
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
              } // End If
            } else { // Else
              // * --- Select from xeneficope
              m_cServer = m_Ctx.GetServer("xeneficope");
              m_cPhName = m_Ctx.GetPhName("xeneficope");
              if (Cursor_xeneficope!=null)
                Cursor_xeneficope.Close();
              Cursor_xeneficope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_unicode,"?",0,0,m_cServer, m_oParameters),m_cServer,_unicode)+" "+")"+(m_Ctx.IsSharedTemp("xeneficope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM ",m_cServer,m_Ctx,true));
              while ( ! (Cursor_xeneficope.Eof())) {
                /* cMaxRow := xeneficope->CPROWNUM */
                cMaxRow = CPLib.Round(Cursor_xeneficope.GetDouble("CPROWNUM"),0);
                Cursor_xeneficope.Next();
              }
              m_cConnectivityError = Cursor_xeneficope.ErrorMessage();
              Cursor_xeneficope.Close();
              // * --- End Select
              /* cMaxRow := cMaxRow + 1 */
              cMaxRow = CPLib.Round(cMaxRow+1,0);
              // * --- Insert into xeneficope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("xeneficope");
              m_cPhName = m_Ctx.GetPhName("xeneficope");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"xeneficope")+" (";
              m_cSql = m_cSql+GetFieldsName_072C77C8(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(_unicode,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,21,16),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,49,1),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,75,70),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,145,3),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,148,30),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,178,6),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,184,2),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,186,35),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,221,5),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cMaxRow,"?",0,0)+", ";
              if (m_Ctx.IsSharedTemp("xeneficope")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xeneficope",true);
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
            } // End If
          } // End If
        } // End If
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* gMsgProc := gMsgProc + 'Beneficiari Operazioni Inseriti: '+LRTrim(Str(cNumNew,10,0)) + " - Beneficiari Operazioni Aggiornati: "+LRTrim(Str(cNumMod,10,0)) + NL */
      gMsgProc = gMsgProc+"Beneficiari Operazioni Inseriti: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+" - Beneficiari Operazioni Aggiornati: "+CPLib.LRTrim(CPLib.Str(cNumMod,10,0))+"\n";
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
        if (Cursor_beneficfrz!=null)
          Cursor_beneficfrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xeneficfrz!=null)
          Cursor_xeneficfrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_beneficope!=null)
          Cursor_beneficope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xeneficope!=null)
          Cursor_xeneficope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_29() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* Legge il file di testo e porta i dati nella tabella */
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      /* cNumMod := 0 */
      cNumMod = CPLib.Round(0,0);
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* fhand := FileLibrary.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibrary.OpenRead("./appo/"+nomefileimport);
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        /* cMaxRow := 0 */
        cMaxRow = CPLib.Round(0,0);
        /* cNumMod := 0 */
        cNumMod = CPLib.Round(0,0);
        /* _unicode := '' */
        _unicode = "";
        /* If Substr(riga,48,1)='F' */
        if (CPLib.eqr(CPLib.Substr(riga,48,1),"F")) {
          // * --- Read from xraziobo
          m_cServer = m_Ctx.GetServer("xraziobo");
          m_cPhName = m_Ctx.GetPhName("xraziobo");
          m_cSql = "";
          m_cSql = m_cSql+"UNIQUECODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,11,10),"C",10,0,m_cServer),m_cServer,CPLib.Substr(riga,11,10));
          if (m_Ctx.IsSharedTemp("xraziobo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _unicode = Read_Cursor.GetString("IDBASE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on xraziobo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _unicode = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(_unicode)) */
          if (CPLib.Empty(CPLib.LRTrim(_unicode))) {
            // * --- Read from fraziobo
            m_cServer = m_Ctx.GetServer("fraziobo");
            m_cPhName = m_Ctx.GetPhName("fraziobo");
            m_cSql = "";
            m_cSql = m_cSql+"UNIQUECODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,11,10),"C",10,0,m_cServer),m_cServer,CPLib.Substr(riga,11,10));
            if (m_Ctx.IsSharedTemp("fraziobo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _unicode = Read_Cursor.GetString("IDBASE");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on fraziobo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _unicode = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If not(Empty(LRTrim(_unicode))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(_unicode)))) {
              // * --- Insert into terzistifrz from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("terzistifrz");
              m_cPhName = m_Ctx.GetPhName("terzistifrz");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"terzistifrz")+" (";
              m_cSql = m_cSql+GetFieldsName_079F3890(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(_unicode,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,21,16),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,49,1),"?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("terzistifrz")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"terzistifrz",true);
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
            // * --- Insert into xerzistifrz from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xerzistifrz");
            m_cPhName = m_Ctx.GetPhName("xerzistifrz");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.InsertIntoStatement(m_Ctx,"xerzistifrz")+" (";
            m_cSql = m_cSql+GetFieldsName_079C0A88(m_Ctx);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(_unicode,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,21,16),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,49,1),"?",0,0,m_cServer)+", ";
            if (m_Ctx.IsSharedTemp("xerzistifrz")) {
              m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
            }
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xerzistifrz",true);
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
          /* ElseIf Substr(riga,48,1)='O' */
        } else if (CPLib.eqr(CPLib.Substr(riga,48,1),"O")) {
          // * --- Read from xperazbo
          m_cServer = m_Ctx.GetServer("xperazbo");
          m_cPhName = m_Ctx.GetPhName("xperazbo");
          m_cSql = "";
          m_cSql = m_cSql+"UNIQUECODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,11,10),"C",10,0,m_cServer),m_cServer,CPLib.Substr(riga,11,10));
          if (m_Ctx.IsSharedTemp("xperazbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _unicode = Read_Cursor.GetString("IDBASE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on xperazbo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _unicode = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(_unicode)) */
          if (CPLib.Empty(CPLib.LRTrim(_unicode))) {
            // * --- Read from operazbo
            m_cServer = m_Ctx.GetServer("operazbo");
            m_cPhName = m_Ctx.GetPhName("operazbo");
            m_cSql = "";
            m_cSql = m_cSql+"UNIQUECODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,11,10),"C",10,0,m_cServer),m_cServer,CPLib.Substr(riga,11,10));
            if (m_Ctx.IsSharedTemp("operazbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _unicode = Read_Cursor.GetString("IDBASE");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on operazbo into routine arrt_imp_dati_multipli_amex returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _unicode = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If not(Empty(LRTrim(_unicode))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(_unicode)))) {
              // * --- Insert into terzistiope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("terzistiope");
              m_cPhName = m_Ctx.GetPhName("terzistiope");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"terzistiope")+" (";
              m_cSql = m_cSql+GetFieldsName_0612CDE0(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(_unicode,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,21,16),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,49,1),"?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("terzistiope")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"terzistiope",true);
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
            // * --- Insert into xerzistiope from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xerzistiope");
            m_cPhName = m_Ctx.GetPhName("xerzistiope");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.InsertIntoStatement(m_Ctx,"xerzistiope")+" (";
            m_cSql = m_cSql+GetFieldsName_05E22740(m_Ctx);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(_unicode,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,21,16),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,49,1),"?",0,0,m_cServer)+", ";
            if (m_Ctx.IsSharedTemp("xerzistiope")) {
              m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
            }
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xerzistiope",true);
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
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* FileLibrary.DeleteFile('./appo/'+nomefileimport) */
      FileLibrary.DeleteFile("./appo/"+nomefileimport);
      /* gMsgProc := gMsgProc + 'Altri Soggetti Operazioni Inseriti: '+LRTrim(Str(cNumNew,10,0)) + " - Altri Soggetti Operazioni Aggiornati: "+LRTrim(Str(cNumMod,10,0)) + NL */
      gMsgProc = gMsgProc+"Altri Soggetti Operazioni Inseriti: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+" - Altri Soggetti Operazioni Aggiornati: "+CPLib.LRTrim(CPLib.Str(cNumMod,10,0))+"\n";
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
      m_Caller.SetString("gMsgProc","M",10,0,gMsgProc);
      m_Caller.SetNumber("impzip","N",1,0,w_impzip);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_imp_dati_multipli_amexR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_imp_dati_multipli_amexR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_tipodest = m_Caller.GetString("tipodest","C",1,0);
    gMsgProc = m_Caller.GetString("gMsgProc","M",10,0);
    w_impzip = m_Caller.GetNumber("impzip","N",1,0);
    fhand = CPLib.Space(1);
    riga = "";
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
    cNumInv = 0;
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
    _tipper = CPLib.Space(1);
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
  protected static String GetFieldsName_07944D50(CPContext p_Ctx) {
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
  protected static String GetFieldsName_0773F940(CPContext p_Ctx) {
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
    p_cSql = p_cSql+"PRGIMPRAP,";
    if (p_Ctx.IsSharedTemp("anarapbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"anarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0773F628(CPContext p_Ctx) {
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
  protected static String GetFieldsName_077CDB18(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CONNESOPER,";
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
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    if (p_Ctx.IsSharedTemp("rapopebo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_077D6A40(CPContext p_Ctx) {
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
    if (p_Ctx.IsSharedTemp("intestbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"intestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_062E40E8(CPContext p_Ctx) {
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
  protected static String GetFieldsName_0634EF58(CPContext p_Ctx) {
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
  protected static String GetFieldsName_07CEAAD0(CPContext p_Ctx) {
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
    p_cSql = p_cSql+"PRGIMPRAP,";
    if (p_Ctx.IsSharedTemp("xnarapbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xnarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05CB8230(CPContext p_Ctx) {
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
  protected static String GetFieldsName_05BC49B0(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CONNESOPER,";
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
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    if (p_Ctx.IsSharedTemp("xapopebo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_061A4A48(CPContext p_Ctx) {
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
    if (p_Ctx.IsSharedTemp("xntestbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xntestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05EBE158(CPContext p_Ctx) {
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
  protected static String GetFieldsName_06574630(CPContext p_Ctx) {
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
  protected static String GetFieldsName_05E0EBA8(CPContext p_Ctx) {
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
    p_cSql = p_cSql+"PRGIMPRAP,";
    if (p_Ctx.IsSharedTemp("jnarapbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"jnarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0634F5D0(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CONNESOPER,";
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
    if (p_Ctx.IsSharedTemp("japopebo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"japopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_07CAE548(CPContext p_Ctx) {
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
    if (p_Ctx.IsSharedTemp("jntestbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"jntestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06131748(CPContext p_Ctx) {
    String p_cSql = "";
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
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
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
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    if (p_Ctx.IsSharedTemp("jperazbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"jperazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_062E26C0(CPContext p_Ctx) {
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
  protected static String GetFieldsName_07A4C690(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PRGIMPTIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"CONNESCLI,";
    if (p_Ctx.IsSharedTemp("xapotit")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xapotit",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05DE4BA8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PRGIMPTIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"CONNESCLI,";
    if (p_Ctx.IsSharedTemp("rapotit")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapotit",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05B5EA60(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PRGIMPTIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"UNIQUECODE,";
    if (p_Ctx.IsSharedTemp("xapotit")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xapotit",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05F086A0(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PRGIMPTIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"UNIQUECODE,";
    if (p_Ctx.IsSharedTemp("rapotit")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapotit",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05B62690(CPContext p_Ctx) {
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
  protected static String GetFieldsName_061562D8(CPContext p_Ctx) {
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
  protected static String GetFieldsName_06813FF8(CPContext p_Ctx) {
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
  protected static String GetFieldsName_0629AFF0(CPContext p_Ctx) {
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
  protected static String GetFieldsName_05E65098(CPContext p_Ctx) {
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
  protected static String GetFieldsName_06440F00(CPContext p_Ctx) {
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
  protected static String GetFieldsName_0418D008(CPContext p_Ctx) {
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
  protected static String GetFieldsName_05FC32C8(CPContext p_Ctx) {
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
  protected static String GetFieldsName_05B5D500(CPContext p_Ctx) {
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
  protected static String GetFieldsName_0630AA68(CPContext p_Ctx) {
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
  protected static String GetFieldsName_0643C0D0(CPContext p_Ctx) {
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
  protected static String GetFieldsName_062F71F0(CPContext p_Ctx) {
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
  protected static String GetFieldsName_05E62980(CPContext p_Ctx) {
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
  protected static String GetFieldsName_06444158(CPContext p_Ctx) {
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
  protected static String GetFieldsName_062E9F20(CPContext p_Ctx) {
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
  protected static String GetFieldsName_0418C510(CPContext p_Ctx) {
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
  protected static String GetFieldsName_05FC8920(CPContext p_Ctx) {
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
  protected static String GetFieldsName_079F4808(CPContext p_Ctx) {
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
  protected static String GetFieldsName_079F2498(CPContext p_Ctx) {
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
  protected static String GetFieldsName_072D0390(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"priorita,";
    if (p_Ctx.IsSharedTemp("tmp_list_imprich")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_list_imprich",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05CC5D50(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"CPROWNUM,";
    if (p_Ctx.IsSharedTemp("beneficfrz")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"beneficfrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_061F53D8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"CPROWNUM,";
    if (p_Ctx.IsSharedTemp("xeneficfrz")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xeneficfrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_072C39A0(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"CPROWNUM,";
    if (p_Ctx.IsSharedTemp("beneficope")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"beneficope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_072C77C8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"CPROWNUM,";
    if (p_Ctx.IsSharedTemp("xeneficope")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xeneficope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_079F3890(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"LEGAME,";
    if (p_Ctx.IsSharedTemp("terzistifrz")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"terzistifrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_079C0A88(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"LEGAME,";
    if (p_Ctx.IsSharedTemp("xerzistifrz")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xerzistifrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0612CDE0(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"LEGAME,";
    if (p_Ctx.IsSharedTemp("terzistiope")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"terzistiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05E22740(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"LEGAME,";
    if (p_Ctx.IsSharedTemp("xerzistiope")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xerzistiope",true);
    return p_cSql;
  }
}
