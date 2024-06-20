// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_ricrea51R implements CallerWithObjs {
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
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_aerighe;
  public String m_cServer_aerighe;
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
  public String m_cPhName_aederig;
  public String m_cServer_aederig;
  public String m_cPhName_jnarapbo;
  public String m_cServer_jnarapbo;
  public String m_cPhName_japopebo;
  public String m_cServer_japopebo;
  public String m_cPhName_jntestbo;
  public String m_cServer_jntestbo;
  public String m_cPhName_jelegabo;
  public String m_cServer_jelegabo;
  public String m_cPhName_cpwarn;
  public String m_cServer_cpwarn;
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
  public java.sql.Date w_DataReg;
  public String fhand;
  public String riga;
  public String _filename;
  public String _codint;
  public String _periodo;
  public String _tipofile;
  public String _nomefile;
  public String _descfile;
  public double _esito;
  public String _rapporto;
  public double _numrig;
  public String _ragsoc;
  public String _prog;
  public String _tiprap;
  public String _startmsg;
  public double _numriga;
  public double cNumNew;
  public double cNumMod;
  public double cNumSog;
  public double cNumDel;
  public double cNumOXC;
  public double cNumRap;
  public double conta;
  public double cicla;
  public String cNPROG;
  public String cCODFISC;
  public String cCOGNOME;
  public String cNOME;
  public String cSESSO;
  public java.sql.Date dDATNAS;
  public String cNACITTA;
  public String cNAPROV;
  public String cRAGSOC;
  public String cSLCITTA;
  public String cSLPROV;
  public String cTIPOINF;
  public String cCOINT;
  public java.sql.Date dDATAPE;
  public java.sql.Date dDATCHI;
  public String cIDFILE;
  public String cIDPROG;
  public String cTIPOOP;
  public String cRiga;
  public String _connes;
  public double nProgImp;
  public double nProgImp2;
  public String cInfProg1;
  public String cInfProg2;
  public String cProgA;
  public String cProgC;
  public java.sql.Date dDatIni;
  public java.sql.Date dDatFin;
  public String cID;
  public java.sql.Date _dtret;
  public double _friga;
  public String _frappo;
  public String _tipoag;
  public String _coint;
  public String _idbase;
  public String gAzienda;
  public String gMsgImp;
  public String gMsgProc;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_ricrea51
  public String[] lista;
  public int conteggio;
  public int i;
  public int contanome;
  // * --- Fine Area Manuale
  public arrt_ricrea51R (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_ricrea51",m_Caller);
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_aerighe = p_ContextObject.GetPhName("aerighe");
    m_cServer_aerighe = p_ContextObject.GetServer("aerighe");
    m_cPhName_aetesta = p_ContextObject.GetPhName("aetesta");
    m_cServer_aetesta = p_ContextObject.GetServer("aetesta");
    m_cPhName_aederig = p_ContextObject.GetPhName("aederig");
    m_cServer_aederig = p_ContextObject.GetServer("aederig");
    m_cPhName_jnarapbo = p_ContextObject.GetPhName("jnarapbo");
    m_cServer_jnarapbo = p_ContextObject.GetServer("jnarapbo");
    m_cPhName_japopebo = p_ContextObject.GetPhName("japopebo");
    m_cServer_japopebo = p_ContextObject.GetServer("japopebo");
    m_cPhName_jntestbo = p_ContextObject.GetPhName("jntestbo");
    m_cServer_jntestbo = p_ContextObject.GetServer("jntestbo");
    m_cPhName_jelegabo = p_ContextObject.GetPhName("jelegabo");
    m_cServer_jelegabo = p_ContextObject.GetServer("jelegabo");
    m_cPhName_cpwarn = p_ContextObject.GetPhName("cpwarn");
    m_cServer_cpwarn = p_ContextObject.GetServer("cpwarn");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_esito",p_cVarName)) {
      return _esito;
    }
    if (CPLib.eqr("_numrig",p_cVarName)) {
      return _numrig;
    }
    if (CPLib.eqr("_numriga",p_cVarName)) {
      return _numriga;
    }
    if (CPLib.eqr("cNumNew",p_cVarName)) {
      return cNumNew;
    }
    if (CPLib.eqr("cNumMod",p_cVarName)) {
      return cNumMod;
    }
    if (CPLib.eqr("cNumSog",p_cVarName)) {
      return cNumSog;
    }
    if (CPLib.eqr("cNumDel",p_cVarName)) {
      return cNumDel;
    }
    if (CPLib.eqr("cNumOXC",p_cVarName)) {
      return cNumOXC;
    }
    if (CPLib.eqr("cNumRap",p_cVarName)) {
      return cNumRap;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      return conta;
    }
    if (CPLib.eqr("cicla",p_cVarName)) {
      return cicla;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      return nProgImp;
    }
    if (CPLib.eqr("nProgImp2",p_cVarName)) {
      return nProgImp2;
    }
    if (CPLib.eqr("_friga",p_cVarName)) {
      return _friga;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_ricrea51";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      return riga;
    }
    if (CPLib.eqr("_filename",p_cVarName)) {
      return _filename;
    }
    if (CPLib.eqr("_codint",p_cVarName)) {
      return _codint;
    }
    if (CPLib.eqr("_periodo",p_cVarName)) {
      return _periodo;
    }
    if (CPLib.eqr("_tipofile",p_cVarName)) {
      return _tipofile;
    }
    if (CPLib.eqr("_nomefile",p_cVarName)) {
      return _nomefile;
    }
    if (CPLib.eqr("_descfile",p_cVarName)) {
      return _descfile;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      return _rapporto;
    }
    if (CPLib.eqr("_ragsoc",p_cVarName)) {
      return _ragsoc;
    }
    if (CPLib.eqr("_prog",p_cVarName)) {
      return _prog;
    }
    if (CPLib.eqr("_tiprap",p_cVarName)) {
      return _tiprap;
    }
    if (CPLib.eqr("_startmsg",p_cVarName)) {
      return _startmsg;
    }
    if (CPLib.eqr("cNPROG",p_cVarName)) {
      return cNPROG;
    }
    if (CPLib.eqr("cCODFISC",p_cVarName)) {
      return cCODFISC;
    }
    if (CPLib.eqr("cCOGNOME",p_cVarName)) {
      return cCOGNOME;
    }
    if (CPLib.eqr("cNOME",p_cVarName)) {
      return cNOME;
    }
    if (CPLib.eqr("cSESSO",p_cVarName)) {
      return cSESSO;
    }
    if (CPLib.eqr("cNACITTA",p_cVarName)) {
      return cNACITTA;
    }
    if (CPLib.eqr("cNAPROV",p_cVarName)) {
      return cNAPROV;
    }
    if (CPLib.eqr("cRAGSOC",p_cVarName)) {
      return cRAGSOC;
    }
    if (CPLib.eqr("cSLCITTA",p_cVarName)) {
      return cSLCITTA;
    }
    if (CPLib.eqr("cSLPROV",p_cVarName)) {
      return cSLPROV;
    }
    if (CPLib.eqr("cTIPOINF",p_cVarName)) {
      return cTIPOINF;
    }
    if (CPLib.eqr("cCOINT",p_cVarName)) {
      return cCOINT;
    }
    if (CPLib.eqr("cIDFILE",p_cVarName)) {
      return cIDFILE;
    }
    if (CPLib.eqr("cIDPROG",p_cVarName)) {
      return cIDPROG;
    }
    if (CPLib.eqr("cTIPOOP",p_cVarName)) {
      return cTIPOOP;
    }
    if (CPLib.eqr("cRiga",p_cVarName)) {
      return cRiga;
    }
    if (CPLib.eqr("_connes",p_cVarName)) {
      return _connes;
    }
    if (CPLib.eqr("cInfProg1",p_cVarName)) {
      return cInfProg1;
    }
    if (CPLib.eqr("cInfProg2",p_cVarName)) {
      return cInfProg2;
    }
    if (CPLib.eqr("cProgA",p_cVarName)) {
      return cProgA;
    }
    if (CPLib.eqr("cProgC",p_cVarName)) {
      return cProgC;
    }
    if (CPLib.eqr("cID",p_cVarName)) {
      return cID;
    }
    if (CPLib.eqr("_frappo",p_cVarName)) {
      return _frappo;
    }
    if (CPLib.eqr("_tipoag",p_cVarName)) {
      return _tipoag;
    }
    if (CPLib.eqr("_coint",p_cVarName)) {
      return _coint;
    }
    if (CPLib.eqr("_idbase",p_cVarName)) {
      return _idbase;
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
    if (CPLib.eqr("DataReg",p_cVarName)) {
      return w_DataReg;
    }
    if (CPLib.eqr("dDATNAS",p_cVarName)) {
      return dDATNAS;
    }
    if (CPLib.eqr("dDATAPE",p_cVarName)) {
      return dDATAPE;
    }
    if (CPLib.eqr("dDATCHI",p_cVarName)) {
      return dDATCHI;
    }
    if (CPLib.eqr("dDatIni",p_cVarName)) {
      return dDatIni;
    }
    if (CPLib.eqr("dDatFin",p_cVarName)) {
      return dDatFin;
    }
    if (CPLib.eqr("_dtret",p_cVarName)) {
      return _dtret;
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
    if (CPLib.eqr("_esito",p_cVarName)) {
      _esito = value;
      return;
    }
    if (CPLib.eqr("_numrig",p_cVarName)) {
      _numrig = value;
      return;
    }
    if (CPLib.eqr("_numriga",p_cVarName)) {
      _numriga = value;
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
    if (CPLib.eqr("cNumSog",p_cVarName)) {
      cNumSog = value;
      return;
    }
    if (CPLib.eqr("cNumDel",p_cVarName)) {
      cNumDel = value;
      return;
    }
    if (CPLib.eqr("cNumOXC",p_cVarName)) {
      cNumOXC = value;
      return;
    }
    if (CPLib.eqr("cNumRap",p_cVarName)) {
      cNumRap = value;
      return;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      conta = value;
      return;
    }
    if (CPLib.eqr("cicla",p_cVarName)) {
      cicla = value;
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
    if (CPLib.eqr("_friga",p_cVarName)) {
      _friga = value;
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
    if (CPLib.eqr("_filename",p_cVarName)) {
      _filename = value;
      return;
    }
    if (CPLib.eqr("_codint",p_cVarName)) {
      _codint = value;
      return;
    }
    if (CPLib.eqr("_periodo",p_cVarName)) {
      _periodo = value;
      return;
    }
    if (CPLib.eqr("_tipofile",p_cVarName)) {
      _tipofile = value;
      return;
    }
    if (CPLib.eqr("_nomefile",p_cVarName)) {
      _nomefile = value;
      return;
    }
    if (CPLib.eqr("_descfile",p_cVarName)) {
      _descfile = value;
      return;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      _rapporto = value;
      return;
    }
    if (CPLib.eqr("_ragsoc",p_cVarName)) {
      _ragsoc = value;
      return;
    }
    if (CPLib.eqr("_prog",p_cVarName)) {
      _prog = value;
      return;
    }
    if (CPLib.eqr("_tiprap",p_cVarName)) {
      _tiprap = value;
      return;
    }
    if (CPLib.eqr("_startmsg",p_cVarName)) {
      _startmsg = value;
      return;
    }
    if (CPLib.eqr("cNPROG",p_cVarName)) {
      cNPROG = value;
      return;
    }
    if (CPLib.eqr("cCODFISC",p_cVarName)) {
      cCODFISC = value;
      return;
    }
    if (CPLib.eqr("cCOGNOME",p_cVarName)) {
      cCOGNOME = value;
      return;
    }
    if (CPLib.eqr("cNOME",p_cVarName)) {
      cNOME = value;
      return;
    }
    if (CPLib.eqr("cSESSO",p_cVarName)) {
      cSESSO = value;
      return;
    }
    if (CPLib.eqr("cNACITTA",p_cVarName)) {
      cNACITTA = value;
      return;
    }
    if (CPLib.eqr("cNAPROV",p_cVarName)) {
      cNAPROV = value;
      return;
    }
    if (CPLib.eqr("cRAGSOC",p_cVarName)) {
      cRAGSOC = value;
      return;
    }
    if (CPLib.eqr("cSLCITTA",p_cVarName)) {
      cSLCITTA = value;
      return;
    }
    if (CPLib.eqr("cSLPROV",p_cVarName)) {
      cSLPROV = value;
      return;
    }
    if (CPLib.eqr("cTIPOINF",p_cVarName)) {
      cTIPOINF = value;
      return;
    }
    if (CPLib.eqr("cCOINT",p_cVarName)) {
      cCOINT = value;
      return;
    }
    if (CPLib.eqr("cIDFILE",p_cVarName)) {
      cIDFILE = value;
      return;
    }
    if (CPLib.eqr("cIDPROG",p_cVarName)) {
      cIDPROG = value;
      return;
    }
    if (CPLib.eqr("cTIPOOP",p_cVarName)) {
      cTIPOOP = value;
      return;
    }
    if (CPLib.eqr("cRiga",p_cVarName)) {
      cRiga = value;
      return;
    }
    if (CPLib.eqr("_connes",p_cVarName)) {
      _connes = value;
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
    if (CPLib.eqr("cProgA",p_cVarName)) {
      cProgA = value;
      return;
    }
    if (CPLib.eqr("cProgC",p_cVarName)) {
      cProgC = value;
      return;
    }
    if (CPLib.eqr("cID",p_cVarName)) {
      cID = value;
      return;
    }
    if (CPLib.eqr("_frappo",p_cVarName)) {
      _frappo = value;
      return;
    }
    if (CPLib.eqr("_tipoag",p_cVarName)) {
      _tipoag = value;
      return;
    }
    if (CPLib.eqr("_coint",p_cVarName)) {
      _coint = value;
      return;
    }
    if (CPLib.eqr("_idbase",p_cVarName)) {
      _idbase = value;
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
    if (CPLib.eqr("DataReg",p_cVarName)) {
      w_DataReg = value;
      return;
    }
    if (CPLib.eqr("dDATNAS",p_cVarName)) {
      dDATNAS = value;
      return;
    }
    if (CPLib.eqr("dDATAPE",p_cVarName)) {
      dDATAPE = value;
      return;
    }
    if (CPLib.eqr("dDATCHI",p_cVarName)) {
      dDATCHI = value;
      return;
    }
    if (CPLib.eqr("dDatIni",p_cVarName)) {
      dDatIni = value;
      return;
    }
    if (CPLib.eqr("dDatFin",p_cVarName)) {
      dDatFin = value;
      return;
    }
    if (CPLib.eqr("_dtret",p_cVarName)) {
      _dtret = value;
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
    try {
      /* w_DataReg Date */
      /* fhand Char(1) */
      /* riga Memo */
      /* _filename Char(80) */
      /* _codint Char(16) */
      /* _periodo Char(6) */
      /* _tipofile Char(1) */
      /* _nomefile Char(15) */
      /* _descfile Char(80) */
      /* _esito Numeric(1, 0) */
      /* _rapporto Char(25) */
      /* _numrig Numeric(10, 0) */
      /* _ragsoc Char(70) */
      /* _prog Char(10) */
      /* _tiprap Char(1) */
      /* _startmsg Char(60) */
      /* _numriga Numeric(4, 0) */
      /* cNumNew Numeric(10, 0) */
      /* cNumMod Numeric(10, 0) */
      /* cNumSog Numeric(10, 0) */
      /* cNumDel Numeric(10, 0) */
      /* cNumOXC Numeric(10, 0) */
      /* cNumRap Numeric(10, 0) */
      /* conta Numeric(10, 0) */
      /* cicla Numeric(1, 0) */
      /* cNPROG Char(25) */
      /* cCODFISC Char(16) */
      /* cCOGNOME Char(26) */
      /* cNOME Char(25) */
      /* cSESSO Char(1) */
      /* dDATNAS Date */
      /* cNACITTA Char(40) */
      /* cNAPROV Char(2) */
      /* cRAGSOC Char(60) */
      /* cSLCITTA Char(40) */
      /* cSLPROV Char(2) */
      /* cTIPOINF Char(2) */
      /* cCOINT Char(1) */
      /* dDATAPE Date */
      /* dDATCHI Date */
      /* cIDFILE Char(15) */
      /* cIDPROG Char(25) */
      /* cTIPOOP Char(15) */
      /* cRiga Char(331) */
      /* _connes Char(16) */
      /* nProgImp Numeric(15, 0) */
      /* nProgImp2 Numeric(15, 0) */
      /* cInfProg1 Char(10) */
      /* cInfProg2 Char(11) */
      /* cProgA Char(11) */
      /* cProgC Char(11) */
      /* dDatIni Date */
      /* dDatFin Date */
      /* cID Char(10) */
      /* _dtret Date // Data Rettifica */
      /* _friga Numeric(4, 0) */
      /* _frappo Char(25) */
      /* _tipoag Char(2) */
      /* _coint Char(1) */
      /* _idbase Char(10) */
      /* gAzienda Char(10) // Azienda */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio */
      /* Import Soggetti */
      /* gMsgProc := '' */
      gMsgProc = "";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Messaggi Elaborazione ...' */
      gMsgImp = "Messaggi Elaborazione ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _codint := intermbo->CODFISC */
        _codint = Cursor_intermbo.GetString("CODFISC");
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* Cicla sul file della lista e lancia la pagina appropriata */
      /* _esito := 0 */
      _esito = CPLib.Round(0,0);
      /* cNumDel := 0 */
      cNumDel = CPLib.Round(0,0);
      /* cNumRap := 0 */
      cNumRap = CPLib.Round(0,0);
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+arfn_fdatetime(DateTime()) + NL // Messaggio */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Exec "Crea rapporti 5.1" Page 2:Page_2 */
      Page_2();
      /* gMsgProc := gMsgProc + 'Sono stati inseriti o aggiornati:'+NL+'Rapporti: '+LRTrim(Str(cNumRap,10,0))+NL+'Deleghe: '+LRTrim(Str(cNumDel,10,0))+NL */
      gMsgProc = gMsgProc+"Sono stati inseriti o aggiornati:"+"\n"+"Rapporti: "+CPLib.LRTrim(CPLib.Str(cNumRap,10,0))+"\n"+"Deleghe: "+CPLib.LRTrim(CPLib.Str(cNumDel,10,0))+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Elaborazione Terminata' // Messaggio Import */
      gMsgImp = "Elaborazione Terminata";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
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
    CPResultSet Cursor_aetesta=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_aerighe=null;
    CPResultSet Cursor_aederig=null;
    CPResultSet Cursor_jelegabo=null;
    try {
      /* Ricostruisce Archivio AGE */
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry05CE8898status;
      nTry05CE8898status = m_Sql.GetTransactionStatus();
      String cTry05CE8898msg;
      cTry05CE8898msg = m_Sql.TransactionErrorMessage();
      try {
        // * --- Select from aetesta
        m_cServer = m_Ctx.GetServer("aetesta");
        m_cPhName = m_Ctx.GetPhName("aetesta");
        if (Cursor_aetesta!=null)
          Cursor_aetesta.Close();
        Cursor_aetesta = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("aetesta")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_aetesta.Eof())) {
          /* _rapporto := '' */
          _rapporto = "";
          // * --- Read from jnarapbo
          m_cServer = m_Ctx.GetServer("jnarapbo");
          m_cPhName = m_Ctx.GetPhName("jnarapbo");
          m_cSql = "";
          m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aetesta.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_aetesta.GetString("RAPPORTO"));
          if (m_Ctx.IsSharedTemp("jnarapbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _rapporto = Read_Cursor.GetString("RAPPORTO");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on jnarapbo into routine arrt_ricrea51 returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _rapporto = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(_rapporto) */
          if (CPLib.Empty(_rapporto)) {
            /* gMsgImp := 'Sto inserendo in archivio AGE il rapporto '+LRTrim(aetesta->RAPPORTO) // Messaggio Import */
            gMsgImp = "Sto inserendo in archivio AGE il rapporto "+CPLib.LRTrim(Cursor_aetesta.GetString("RAPPORTO"));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* nProgImp := Utilities.GetAutonumber("PRGIMPRAPAGE\'"+LRTrim(gAzienda)+"'",0,15) */
            nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPRAPAGE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
            // * --- Insert into jnarapbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("jnarapbo");
            m_cPhName = m_Ctx.GetPhName("jnarapbo");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.InsertIntoStatement(m_Ctx,"jnarapbo")+" (";
            m_cSql = m_cSql+GetFieldsName_05EDFBB8(m_Ctx);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aetesta.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aetesta.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("E","?",0,0,m_cServer)+", ";
            if (m_Ctx.IsSharedTemp("jnarapbo")) {
              m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
            }
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"jnarapbo",true);
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
            /* cProgA := '' */
            cProgA = "";
            /* cProgC := '' */
            cProgC = "";
            /* _numriga := 1 */
            _numriga = CPLib.Round(1,0);
            // * --- Select from aerighe
            m_cServer = m_Ctx.GetServer("aerighe");
            m_cPhName = m_Ctx.GetPhName("aerighe");
            if (Cursor_aerighe!=null)
              Cursor_aerighe.Close();
            Cursor_aerighe = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_aetesta.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("aerighe")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM ",m_cServer,m_Ctx,true));
            while ( ! (Cursor_aerighe.Eof())) {
              /* cSESSO := '' */
              cSESSO = "";
              // * --- Read from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              m_cSql = "";
              m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aerighe.GetString("CONNESINT"),"C",16,0,m_cServer),m_cServer,Cursor_aerighe.GetString("CONNESINT"));
              if (m_Ctx.IsSharedTemp("personbo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAGSOC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("SESSO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _ragsoc = Read_Cursor.GetString("RAGSOC");
                cSESSO = Read_Cursor.GetString("SESSO");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on personbo into routine arrt_ricrea51 returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _ragsoc = "";
                cSESSO = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              // * --- Write into jnarapbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("jnarapbo");
              m_cPhName = m_Ctx.GetPhName("jnarapbo");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = "Update "+m_cPhName+" set ";
              m_cSql = m_cSql+"DESCRAP = "+CPLib.ToSQL(CPLib.Left(_ragsoc,50),"C",50,0,m_cServer)+", ";
              m_cSql = m_cSql+"IMPAPE = "+CPLib.ToSQL(1,"N",1,0)+", ";
              m_cSql = m_cSql+"IMPCHIU = "+CPLib.ToSQL(( ! (CPLib.Empty(Cursor_aerighe.GetDate("CDATA")))?1:0),"N",1,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jnarapbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_aerighe.GetString("RAPPORTO"))+"";
              if (m_Ctx.IsSharedTemp("jnarapbo")) {
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
              /* If not(Empty(aerighe->ADATA)) */
              if ( ! (CPLib.Empty(Cursor_aerighe.GetDate("ADATA")))) {
                /* dDatIni := aerighe->ADATA */
                dDatIni = Cursor_aerighe.GetDate("ADATA");
              } // End If
              /* If not(Empty(aerighe->CDATA)) */
              if ( ! (CPLib.Empty(Cursor_aerighe.GetDate("CDATA")))) {
                /* dDatFin := aerighe->CDATA */
                dDatFin = Cursor_aerighe.GetDate("CDATA");
              } // End If
              /* nProgImp := Utilities.GetAutonumber("PRGIMPSOGAGE\'"+LRTrim(gAzienda)+"'",0,15) */
              nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPSOGAGE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
              /* cID := LibreriaMit.UniqueId() */
              cID = LibreriaMit.UniqueId();
              // * --- Insert into jntestbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("jntestbo");
              m_cPhName = m_Ctx.GetPhName("jntestbo");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"jntestbo")+" (";
              m_cSql = m_cSql+GetFieldsName_07977D98(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aetesta.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("ADATA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("CDATA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cProgA,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cProgC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_aerighe.GetDate("ADATA"))+cProgA+"O","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cID,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_numriga,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
              if (m_Ctx.IsSharedTemp("jntestbo")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"jntestbo",true);
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
              /* _numriga := _numriga + 1 */
              _numriga = CPLib.Round(_numriga+1,0);
              Cursor_aerighe.Next();
            }
            m_cConnectivityError = Cursor_aerighe.ErrorMessage();
            Cursor_aerighe.Close();
            // * --- End Select
            /* If not(Empty(dDatIni)) */
            if ( ! (CPLib.Empty(dDatIni))) {
              /* cInfProg1 := Utilities.GetAutonumber("PRGINFAGE1\'"+LRTrim(gAzienda)+"'",'',10) */
              cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFAGE1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
              /* cInfProg2 := Utilities.GetAutonumber("PRGINFAGE2\'"+LRTrim(gAzienda)+"'",'',11) */
              cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFAGE2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
              /* nProgImp := Utilities.GetAutonumber("PRGIMPINFAGE\'"+LRTrim(gAzienda)+"'",0,15) */
              nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINFAGE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
              /* cProgA := cInfProg2 */
              cProgA = cInfProg2;
              // * --- Insert into japopebo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("japopebo");
              m_cPhName = m_Ctx.GetPhName("japopebo");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"japopebo")+" (";
              m_cSql = m_cSql+GetFieldsName_0725F1D0(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(dDatIni,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("23","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_aetesta.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(dDatIni)+cInfProg2+"0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(dDatIni),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("japopebo")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
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
              // * --- Write into jntestbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("jntestbo");
              m_cPhName = m_Ctx.GetPhName("jntestbo");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = "Update "+m_cPhName+" set ";
              m_cSql = m_cSql+"NUMPROG1 = "+CPLib.ToSQL(cInfProg2,"C",11,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jntestbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aetesta.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_aetesta.GetString("RAPPORTO"))+"";
              if (m_Ctx.IsSharedTemp("jntestbo")) {
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
            /* If not(Empty(dDatFin)) */
            if ( ! (CPLib.Empty(dDatFin))) {
              /* cInfProg1 := Utilities.GetAutonumber("PRGINFAGE1\'"+LRTrim(gAzienda)+"'",'',10) */
              cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFAGE1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
              /* cInfProg2 := Utilities.GetAutonumber("PRGINFAGE2\'"+LRTrim(gAzienda)+"'",'',11) */
              cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFAGE2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
              /* nProgImp := Utilities.GetAutonumber("PRGIMPINFAGE\'"+LRTrim(gAzienda)+"'",0,15) */
              nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINFAGE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
              /* cProgC := cInfProg2 */
              cProgC = cInfProg2;
              // * --- Insert into japopebo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("japopebo");
              m_cPhName = m_Ctx.GetPhName("japopebo");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"japopebo")+" (";
              m_cSql = m_cSql+GetFieldsName_06E56ED8(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(dDatFin,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("26","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_aetesta.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(dDatFin)+cInfProg2+"0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(dDatFin),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("japopebo")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
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
              // * --- Write into jntestbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("jntestbo");
              m_cPhName = m_Ctx.GetPhName("jntestbo");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = "Update "+m_cPhName+" set ";
              m_cSql = m_cSql+"NUMPROG2 = "+CPLib.ToSQL(cInfProg2,"C",11,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jntestbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aetesta.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_aetesta.GetString("RAPPORTO"))+"";
              if (m_Ctx.IsSharedTemp("jntestbo")) {
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
          /* cNumRap := cNumRap + 1 */
          cNumRap = CPLib.Round(cNumRap+1,0);
          Cursor_aetesta.Next();
        }
        m_cConnectivityError = Cursor_aetesta.ErrorMessage();
        Cursor_aetesta.Close();
        // * --- End Select
        // * --- Select from aederig
        m_cServer = m_Ctx.GetServer("aederig");
        m_cPhName = m_Ctx.GetPhName("aederig");
        if (Cursor_aederig!=null)
          Cursor_aederig.Close();
        Cursor_aederig = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("aederig")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_aederig.Eof())) {
          /* _rapporto := '' */
          _rapporto = "";
          // * --- Read from jnarapbo
          m_cServer = m_Ctx.GetServer("jnarapbo");
          m_cPhName = m_Ctx.GetPhName("jnarapbo");
          m_cSql = "";
          m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_aederig.GetString("RAPPORTO"));
          if (m_Ctx.IsSharedTemp("jnarapbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _rapporto = Read_Cursor.GetString("RAPPORTO");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on jnarapbo into routine arrt_ricrea51 returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _rapporto = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If not(Empty(_rapporto)) */
          if ( ! (CPLib.Empty(_rapporto))) {
            /* cProgA := '' */
            cProgA = "";
            /* cProgC := '' */
            cProgC = "";
            /* If not(Empty(aederig->ADATA)) */
            if ( ! (CPLib.Empty(Cursor_aederig.GetDate("ADATA")))) {
              /* cInfProg1 := Utilities.GetAutonumber("PRGINFAGE1\'"+LRTrim(gAzienda)+"'",'',10) */
              cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFAGE1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
              /* cInfProg2 := Utilities.GetAutonumber("PRGINFAGE2\'"+LRTrim(gAzienda)+"'",'',11) */
              cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFAGE2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
              /* nProgImp := Utilities.GetAutonumber("PRGIMPINFAGE\'"+LRTrim(gAzienda)+"'",0,15) */
              nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINFAGE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
              /* cProgA := cInfProg2 */
              cProgA = cInfProg2;
              // * --- Insert into japopebo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("japopebo");
              m_cPhName = m_Ctx.GetPhName("japopebo");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"japopebo")+" (";
              m_cSql = m_cSql+GetFieldsName_05FBE960(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetDate("ADATA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(w_DataReg)?CPLib.Date():w_DataReg),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("25","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_aederig.GetDate("ADATA"))+cInfProg2+"0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_aederig.GetDate("ADATA")),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("japopebo")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
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
            } // End If
            /* If not(Empty(aerighe->CDATA)) */
            if ( ! (CPLib.Empty(Cursor_aerighe.GetDate("CDATA")))) {
              /* cInfProg1 := Utilities.GetAutonumber("PRGINFAGE1\'"+LRTrim(gAzienda)+"'",'',10) */
              cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFAGE1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
              /* cInfProg2 := Utilities.GetAutonumber("PRGINFAGE2\'"+LRTrim(gAzienda)+"'",'',11) */
              cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFAGE2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
              /* nProgImp := Utilities.GetAutonumber("PRGIMPINFAGE\'"+LRTrim(gAzienda)+"'",0,15) */
              nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINFAGE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
              /* cProgC := cInfProg2 */
              cProgC = cInfProg2;
              // * --- Insert into japopebo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("japopebo");
              m_cPhName = m_Ctx.GetPhName("japopebo");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"japopebo")+" (";
              m_cSql = m_cSql+GetFieldsName_07CFDA48(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetDate("CDATA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(w_DataReg)?CPLib.Date():w_DataReg),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("28","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_aederig.GetDate("CDATA"))+cInfProg2+"0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_aederig.GetDate("CDATA")),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("japopebo")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
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
            } // End If
            /* cID := LibreriaMit.UniqueId() */
            cID = LibreriaMit.UniqueId();
            /* _numriga := 0 */
            _numriga = CPLib.Round(0,0);
            // * --- Select from jelegabo
            m_cServer = m_Ctx.GetServer("jelegabo");
            m_cPhName = m_Ctx.GetPhName("jelegabo");
            if (Cursor_jelegabo!=null)
              Cursor_jelegabo.Close();
            Cursor_jelegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("jelegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM ",m_cServer,m_Ctx,true));
            while ( ! (Cursor_jelegabo.Eof())) {
              /* _numriga := jelegabo->CPROWNUM */
              _numriga = CPLib.Round(Cursor_jelegabo.GetDouble("CPROWNUM"),0);
              Cursor_jelegabo.Next();
            }
            m_cConnectivityError = Cursor_jelegabo.ErrorMessage();
            Cursor_jelegabo.Close();
            // * --- End Select
            /* _numriga := _numriga + 1 */
            _numriga = CPLib.Round(_numriga+1,0);
            // * --- Insert into jelegabo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("jelegabo");
            m_cPhName = m_Ctx.GetPhName("jelegabo");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.InsertIntoStatement(m_Ctx,"jelegabo")+" (";
            m_cSql = m_cSql+GetFieldsName_079B08E8(m_Ctx);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetDate("ADATA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetDate("CDATA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProgA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProgC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_aederig.GetDate("ADATA"))+cProgA+"O","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cID,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_numriga,"?",0,0)+", ";
            if (m_Ctx.IsSharedTemp("jelegabo")) {
              m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
            }
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"jelegabo",true);
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
            /* cNumDel := cNumDel + 1 */
            cNumDel = CPLib.Round(cNumDel+1,0);
          } // End If
          Cursor_aederig.Next();
        }
        m_cConnectivityError = Cursor_aederig.ErrorMessage();
        Cursor_aederig.Close();
        // * --- End Select
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        /* gMsgProc := gMsgProc + 'Rilevati errori nela creazione dei rapporti.Tipo Errore:'+m_Sql.TransactionErrorMessage()+NL */
        gMsgProc = gMsgProc+"Rilevati errori nela creazione dei rapporti.Tipo Errore:"+m_Sql.TransactionErrorMessage()+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry05CE8898status,0)) {
          m_Sql.SetTransactionStatus(nTry05CE8898status,cTry05CE8898msg);
        }
      }
    } finally {
      try {
        if (Cursor_aetesta!=null)
          Cursor_aetesta.Close();
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
        if (Cursor_aerighe!=null)
          Cursor_aerighe.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_aederig!=null)
          Cursor_aederig.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jelegabo!=null)
          Cursor_jelegabo.Close();
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
      m_Caller.SetDate("DataReg","D",8,0,w_DataReg);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_ricrea51R Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_ricrea51R(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_DataReg = m_Caller.GetDate("DataReg","D",8,0);
    fhand = CPLib.Space(1);
    riga = "";
    _filename = CPLib.Space(80);
    _codint = CPLib.Space(16);
    _periodo = CPLib.Space(6);
    _tipofile = CPLib.Space(1);
    _nomefile = CPLib.Space(15);
    _descfile = CPLib.Space(80);
    _esito = 0;
    _rapporto = CPLib.Space(25);
    _numrig = 0;
    _ragsoc = CPLib.Space(70);
    _prog = CPLib.Space(10);
    _tiprap = CPLib.Space(1);
    _startmsg = CPLib.Space(60);
    _numriga = 0;
    cNumNew = 0;
    cNumMod = 0;
    cNumSog = 0;
    cNumDel = 0;
    cNumOXC = 0;
    cNumRap = 0;
    conta = 0;
    cicla = 0;
    cNPROG = CPLib.Space(25);
    cCODFISC = CPLib.Space(16);
    cCOGNOME = CPLib.Space(26);
    cNOME = CPLib.Space(25);
    cSESSO = CPLib.Space(1);
    dDATNAS = CPLib.NullDate();
    cNACITTA = CPLib.Space(40);
    cNAPROV = CPLib.Space(2);
    cRAGSOC = CPLib.Space(60);
    cSLCITTA = CPLib.Space(40);
    cSLPROV = CPLib.Space(2);
    cTIPOINF = CPLib.Space(2);
    cCOINT = CPLib.Space(1);
    dDATAPE = CPLib.NullDate();
    dDATCHI = CPLib.NullDate();
    cIDFILE = CPLib.Space(15);
    cIDPROG = CPLib.Space(25);
    cTIPOOP = CPLib.Space(15);
    cRiga = CPLib.Space(331);
    _connes = CPLib.Space(16);
    nProgImp = 0;
    nProgImp2 = 0;
    cInfProg1 = CPLib.Space(10);
    cInfProg2 = CPLib.Space(11);
    cProgA = CPLib.Space(11);
    cProgC = CPLib.Space(11);
    dDatIni = CPLib.NullDate();
    dDatFin = CPLib.NullDate();
    cID = CPLib.Space(10);
    _dtret = CPLib.NullDate();
    _friga = 0;
    _frappo = CPLib.Space(25);
    _tipoag = CPLib.Space(2);
    _coint = CPLib.Space(1);
    _idbase = CPLib.Space(10);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_05EDFBB8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"PRGIMPRAP,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"FLAGLIRE,";
    if (p_Ctx.IsSharedTemp("jnarapbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"jnarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_07977D98(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"NUMPROG2,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"PRGIMPSOG,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"ABBINATO,";
    if (p_Ctx.IsSharedTemp("jntestbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"jntestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0725F1D0(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"PRGIMPINF,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"STATOREG,";
    if (p_Ctx.IsSharedTemp("japopebo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"japopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06E56ED8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"PRGIMPINF,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"STATOREG,";
    if (p_Ctx.IsSharedTemp("japopebo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"japopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05FBE960(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"PRGIMPINF,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"STATOREG,";
    if (p_Ctx.IsSharedTemp("japopebo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"japopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_07CFDA48(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"PRGIMPINF,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"STATOREG,";
    if (p_Ctx.IsSharedTemp("japopebo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"japopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_079B08E8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"NUMPROG2,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CPROWNUM,";
    if (p_Ctx.IsSharedTemp("jelegabo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"jelegabo",true);
    return p_cSql;
  }
}
