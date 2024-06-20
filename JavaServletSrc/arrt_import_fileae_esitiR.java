// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_import_fileae_esitiR implements CallerWithObjs {
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
  public String m_cPhName_tmp_list_imprich;
  public String m_cServer_tmp_list_imprich;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_tmp_imp_filae;
  public String m_cServer_tmp_imp_filae;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_aerighe;
  public String m_cServer_aerighe;
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
  public String m_cPhName_aederig;
  public String m_cServer_aederig;
  public String m_cPhName_aeoprig;
  public String m_cServer_aeoprig;
  public String m_cPhName_jnarapbo;
  public String m_cServer_jnarapbo;
  public String m_cPhName_japopebo;
  public String m_cServer_japopebo;
  public String m_cPhName_jntestbo;
  public String m_cServer_jntestbo;
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_tmp_rapportipd;
  public String m_cServer_tmp_rapportipd;
  public String m_cPhName_aestor;
  public String m_cServer_aestor;
  public String m_cPhName_aecanc;
  public String m_cServer_aecanc;
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
  public double w_offset;
  public String w_f_denom;
  public String w_prefrap;
  public String w_f_ricaui;
  public String w_codval;
  public String w_fileape;
  public double w_impzip;
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
  public String cID;
  public java.sql.Date _dtret;
  public double _friga;
  public String _frappo;
  public String _tipoag;
  public String _coint;
  public String _idbase;
  public String czipfile;
  public String cpercorsozip;
  public String cdirectoryfile;
  public String buffernomefile;
  public String nomefileimport;
  public double _priorita;
  public String gAzienda;
  public String gMsgImp;
  public String gMsgProc;
  public String gPathApp;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_import_fileae_esiti
  public String[] lista;
  public int conteggio;
  public int i;
  public int contanome;
  // * --- Fine Area Manuale
  public arrt_import_fileae_esitiR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_import_fileae_esiti",m_Caller);
    m_cPhName_tmp_list_imprich = p_ContextObject.GetPhName("tmp_list_imprich");
    m_cServer_tmp_list_imprich = p_ContextObject.GetServer("tmp_list_imprich");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_imp_filae")) {
      m_cPhName_tmp_imp_filae = p_ContextObject.GetPhName("tmp_imp_filae");
      m_cServer_tmp_imp_filae = p_ContextObject.GetServer("tmp_imp_filae");
    }
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_aerighe = p_ContextObject.GetPhName("aerighe");
    m_cServer_aerighe = p_ContextObject.GetServer("aerighe");
    m_cPhName_aetesta = p_ContextObject.GetPhName("aetesta");
    m_cServer_aetesta = p_ContextObject.GetServer("aetesta");
    m_cPhName_aederig = p_ContextObject.GetPhName("aederig");
    m_cServer_aederig = p_ContextObject.GetServer("aederig");
    m_cPhName_aeoprig = p_ContextObject.GetPhName("aeoprig");
    m_cServer_aeoprig = p_ContextObject.GetServer("aeoprig");
    m_cPhName_jnarapbo = p_ContextObject.GetPhName("jnarapbo");
    m_cServer_jnarapbo = p_ContextObject.GetServer("jnarapbo");
    m_cPhName_japopebo = p_ContextObject.GetPhName("japopebo");
    m_cServer_japopebo = p_ContextObject.GetServer("japopebo");
    m_cPhName_jntestbo = p_ContextObject.GetPhName("jntestbo");
    m_cServer_jntestbo = p_ContextObject.GetServer("jntestbo");
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_rapopebo = p_ContextObject.GetPhName("rapopebo");
    m_cServer_rapopebo = p_ContextObject.GetServer("rapopebo");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_tmp_rapportipd = p_ContextObject.GetPhName("tmp_rapportipd");
    m_cServer_tmp_rapportipd = p_ContextObject.GetServer("tmp_rapportipd");
    m_cPhName_aestor = p_ContextObject.GetPhName("aestor");
    m_cServer_aestor = p_ContextObject.GetServer("aestor");
    m_cPhName_aecanc = p_ContextObject.GetPhName("aecanc");
    m_cServer_aecanc = p_ContextObject.GetServer("aecanc");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("offset",p_cVarName)) {
      return w_offset;
    }
    if (CPLib.eqr("impzip",p_cVarName)) {
      return w_impzip;
    }
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
      return "arrt_import_fileae_esiti";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("f_denom",p_cVarName)) {
      return w_f_denom;
    }
    if (CPLib.eqr("prefrap",p_cVarName)) {
      return w_prefrap;
    }
    if (CPLib.eqr("f_ricaui",p_cVarName)) {
      return w_f_ricaui;
    }
    if (CPLib.eqr("codval",p_cVarName)) {
      return w_codval;
    }
    if (CPLib.eqr("fileape",p_cVarName)) {
      return w_fileape;
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
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("dDATNAS",p_cVarName)) {
      return dDATNAS;
    }
    if (CPLib.eqr("dDATAPE",p_cVarName)) {
      return dDATAPE;
    }
    if (CPLib.eqr("dDATCHI",p_cVarName)) {
      return dDATCHI;
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
    if (CPLib.eqr("offset",p_cVarName)) {
      w_offset = value;
      return;
    }
    if (CPLib.eqr("impzip",p_cVarName)) {
      w_impzip = value;
      return;
    }
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
    if (CPLib.eqr("_priorita",p_cVarName)) {
      _priorita = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("f_denom",p_cVarName)) {
      w_f_denom = value;
      return;
    }
    if (CPLib.eqr("prefrap",p_cVarName)) {
      w_prefrap = value;
      return;
    }
    if (CPLib.eqr("f_ricaui",p_cVarName)) {
      w_f_ricaui = value;
      return;
    }
    if (CPLib.eqr("codval",p_cVarName)) {
      w_codval = value;
      return;
    }
    if (CPLib.eqr("fileape",p_cVarName)) {
      w_fileape = value;
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
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
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
      /* Dichiarazione variabili del caller */
      /* w_offset Numeric(5, 0) */
      /* w_f_denom Char(1) */
      /* w_prefrap Char(5) */
      /* w_f_ricaui Char(1) */
      /* w_codval Char(3) */
      /* w_fileape Char(80) */
      /* w_impzip Numeric(1, 0) */
      /* Definizione variabili locali */
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
      /* cID Char(10) */
      /* _dtret Date // Data Rettifica */
      /* _friga Numeric(4, 0) */
      /* _frappo Char(25) */
      /* _tipoag Char(2) */
      /* _coint Char(1) */
      /* _idbase Char(10) */
      /* czipfile Char(100) */
      /* cpercorsozip Char(200) */
      /* cdirectoryfile Char(200) */
      /* buffernomefile Char(100) */
      /* nomefileimport Char(50) */
      /* _priorita Numeric(3, 0) */
      /* gAzienda Char(10) // Azienda */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio */
      /* gPathApp Char(80) // Path Applicazione */
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
      /* Crea il file appoggio */
      // * --- Drop temporary table tmp_imp_filae
      if (m_Ctx.IsSharedTemp("tmp_imp_filae")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_imp_filae")) {
          m_cServer = m_Ctx.GetServer("tmp_imp_filae");
          m_cPhName = m_Ctx.GetPhName("tmp_imp_filae");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_imp_filae");
      }
      // * --- Create temporary table tmp_imp_filae
      if (m_Ctx.IsSharedTemp("tmp_imp_filae")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_imp_filae")) {
          m_cServer = m_Ctx.GetServer("tmp_imp_filae");
          m_cPhName = m_Ctx.GetPhName("tmp_imp_filae");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_imp_filae");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_imp_filae");
      if ( ! (m_Ctx.IsSharedTemp("tmp_imp_filae"))) {
        m_cServer = m_Ctx.GetServer("tmp_imp_filae");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_imp_filae",m_cServer,"proto")),m_cPhName,"tmp_imp_filae",m_Ctx);
      }
      m_cPhName_tmp_imp_filae = m_cPhName;
      /* Cicla sul file della lista e lancia la pagina appropriata */
      /* _esito := 0 */
      _esito = CPLib.Round(0,0);
      /* cNumDel := 0 */
      cNumDel = CPLib.Round(0,0);
      /* cNumOXC := 0 */
      cNumOXC = CPLib.Round(0,0);
      /* cNumRap := 0 */
      cNumRap = CPLib.Round(0,0);
      /* cNumSog := 0 */
      cNumSog = CPLib.Round(0,0);
      /* _startmsg := gMsgProc + 'Ora Inizio Processo: '+arfn_fdatetime(DateTime()) + NL */
      _startmsg = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      /* gMsgProc := _startmsg */
      gMsgProc = _startmsg;
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* _filename := w_fileape */
      _filename = w_fileape;
      /* Exec "Legge File di testo" Page 2 */
      Page_2();
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
    /* Legge il file di testo e porta i dati nella tabella */
    /* conta := 0 */
    conta = CPLib.Round(0,0);
    /* fhand := FileLibrary.OpenRead('appo/'+LRTrim(_filename)) */
    fhand = FileLibrary.OpenRead("appo/"+CPLib.LRTrim(_filename));
    /* riga := FileLibrary.ReadLine(fhand) */
    riga = FileLibrary.ReadLine(fhand);
    /* If Left(riga,8) <> '0CCB0034' */
    if (CPLib.ne(CPLib.Left(riga,8),"0CCB0034")) {
      /* gMsgProc := gMsgProc + "ll file "+LRTrim(_filename)+"non è nel formato standard per Anagrafe dei Rapporti"+NL // Messaggio Import */
      gMsgProc = gMsgProc+"ll file "+CPLib.LRTrim(_filename)+"non è nel formato standard per Anagrafe dei Rapporti"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
      /* ElseIf LRTrim(Substr(riga,9,16)) <> LRTrim(_codint) */
    } else if (CPLib.ne(CPLib.LRTrim(CPLib.Substr(riga,9,16)),CPLib.LRTrim(_codint))) {
      /* gMsgProc := gMsgProc + "ll file "+LRTrim(_filename)+" non è relativo a questo Intermediario"+NL // Messaggio Import */
      gMsgProc = gMsgProc+"ll file "+CPLib.LRTrim(_filename)+" non è relativo a questo Intermediario"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
    } else { // Else
      /* _periodo := Substr(riga,239,6) */
      _periodo = CPLib.Substr(riga,239,6);
      /* _tipofile := Substr(riga,245,1) */
      _tipofile = CPLib.Substr(riga,245,1);
      /* _nomefile := Substr(riga,246,15) */
      _nomefile = CPLib.Substr(riga,246,15);
      /* Case _tipofile='1' */
      if (CPLib.eqr(_tipofile,"1")) {
        /* _descfile := "INVIO ORDINARIO - Comunicazioni di nuovi rapporti" */
        _descfile = "INVIO ORDINARIO - Comunicazioni di nuovi rapporti";
        /* Case _tipofile='2' */
      } else if (CPLib.eqr(_tipofile,"2")) {
        /* _descfile := "INVIO CESSAZIONE - Comunicazioni di cessazioni dei rapporti" */
        _descfile = "INVIO CESSAZIONE - Comunicazioni di cessazioni dei rapporti";
        /* Case _tipofile='3' */
      } else if (CPLib.eqr(_tipofile,"3")) {
        /* _descfile := "INVIO RETTIFICATIVO - Comunicazioni di rettifiche o cancellazioni di rapporti" */
        _descfile = "INVIO RETTIFICATIVO - Comunicazioni di rettifiche o cancellazioni di rapporti";
        /* Case _tipofile='4' */
      } else if (CPLib.eqr(_tipofile,"4")) {
        /* _descfile := "INVIO ORDINARIO - Comunicazioni di nuovi rapporti senza Codice Fiscale" */
        _descfile = "INVIO ORDINARIO - Comunicazioni di nuovi rapporti senza Codice Fiscale";
        /* Case _tipofile='5' */
      } else if (CPLib.eqr(_tipofile,"5")) {
        /* _descfile := "INVIO CESSAZIONE - Comunicazioni di cessazioni dei rapporti senza Codice Fiscale" */
        _descfile = "INVIO CESSAZIONE - Comunicazioni di cessazioni dei rapporti senza Codice Fiscale";
        /* Case _tipofile='6' */
      } else if (CPLib.eqr(_tipofile,"6")) {
        /* _descfile := "INVIO RETTIFICATIVO - Comunicazioni di rettifiche o cancellazioni di rapporti senza Codice Fiscale" */
        _descfile = "INVIO RETTIFICATIVO - Comunicazioni di rettifiche o cancellazioni di rapporti senza Codice Fiscale";
        /* Case _tipofile='7' */
      } else if (CPLib.eqr(_tipofile,"7")) {
        /* _descfile := "COMUNICAZIONE DI NESSUNA VARIAZIONE SU ANAGRAFE RAPPORTI" */
        _descfile = "COMUNICAZIONE DI NESSUNA VARIAZIONE SU ANAGRAFE RAPPORTI";
      } // End Case
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* riga := FileLibrary.ReadLine(fhand) */
        riga = FileLibrary.ReadLine(fhand);
        /* If Len(LRTrim(riga)) > 0 and Left(riga,1) <> '9' */
        if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0) && CPLib.ne(CPLib.Left(riga,1),"9")) {
          /* cicla := 0 */
          cicla = CPLib.Round(0,0);
          /* Case _tipofile='1' */
          if (CPLib.eqr(_tipofile,"1")) {
            /* While cicla <= 4 */
            while (CPLib.le(cicla,4)) {
              /* cRiga := Substr(riga,(cicla * 330)+2,330) */
              cRiga = CPLib.Substr(riga,(cicla*330)+2,330);
              /* cNPROG := Substr(cRiga,1,25) */
              cNPROG = CPLib.Substr(cRiga,1,25);
              /* cCODFISC := Substr(cRiga,26,16) */
              cCODFISC = CPLib.Substr(cRiga,26,16);
              /* cCOGNOME := Substr(cRiga,42,26) */
              cCOGNOME = CPLib.Substr(cRiga,42,26);
              /* cNOME := Substr(cRiga,68,25) */
              cNOME = CPLib.Substr(cRiga,68,25);
              /* cSESSO := Substr(cRiga,93,1) */
              cSESSO = CPLib.Substr(cRiga,93,1);
              /* dDATNAS := arfn_datefchar(Substr(cRiga,94,8)) */
              dDATNAS = arfn_datefcharR.Make(m_Ctx,this).Run(CPLib.Substr(cRiga,94,8));
              /* cNACITTA := Substr(cRiga,102,40) */
              cNACITTA = CPLib.Substr(cRiga,102,40);
              /* cNAPROV := Substr(cRiga,142,2) */
              cNAPROV = CPLib.Substr(cRiga,142,2);
              /* cRAGSOC := Substr(cRiga,144,60) */
              cRAGSOC = CPLib.Substr(cRiga,144,60);
              /* cSLCITTA := Substr(cRiga,204,40) */
              cSLCITTA = CPLib.Substr(cRiga,204,40);
              /* cSLPROV := Substr(cRiga,244,2) */
              cSLPROV = CPLib.Substr(cRiga,244,2);
              /* cTIPOINF := Substr(cRiga,246,2) */
              cTIPOINF = CPLib.Substr(cRiga,246,2);
              /* cCOINT := Substr(cRiga,248,1) */
              cCOINT = CPLib.Substr(cRiga,248,1);
              /* dDATAPE := arfn_datefchar(Substr(cRiga,249,8)) */
              dDATAPE = arfn_datefcharR.Make(m_Ctx,this).Run(CPLib.Substr(cRiga,249,8));
              /* dDATCHI := arfn_datefchar(Substr(cRiga,257,8)) */
              dDATCHI = arfn_datefcharR.Make(m_Ctx,this).Run(CPLib.Substr(cRiga,257,8));
              /* If Len(LRTrim(cNPROG+cCODFISC)) > 0 */
              if (CPLib.gt(CPLib.Len(CPLib.LRTrim(cNPROG+cCODFISC)),0)) {
                // * --- Insert into tmp_imp_filae from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_imp_filae");
                m_cPhName = m_Ctx.GetPhName("tmp_imp_filae");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_imp_filae")+" (";
                m_cSql = m_cSql+GetFieldsName_079B0E88(m_Ctx);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(_periodo,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_tipofile,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_descfile,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cNPROG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cCODFISC,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cCOGNOME,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cNOME,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cSESSO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(dDATNAS,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cNACITTA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cNAPROV,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cRAGSOC,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cSLCITTA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cSLPROV,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cTIPOINF,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cCOINT,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(dDATAPE,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(dDATCHI,"?",0,0)+", ";
                if (m_Ctx.IsSharedTemp("tmp_imp_filae")) {
                  m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                }
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_imp_filae",true);
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
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              /* cicla := cicla + 1 */
              cicla = CPLib.Round(cicla+1,0);
              /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' rapporti' // Messaggio Import */
              gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" rapporti";
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            } // End While
            /* Case _tipofile='2' */
          } else if (CPLib.eqr(_tipofile,"2")) {
            /* While cicla <= 4 */
            while (CPLib.le(cicla,4)) {
              /* cRiga := Substr(riga,(cicla * 330)+2,330) */
              cRiga = CPLib.Substr(riga,(cicla*330)+2,330);
              /* cNPROG := Substr(cRiga,1,25) */
              cNPROG = CPLib.Substr(cRiga,1,25);
              /* cIDFILE := Substr(cRiga,42,15) */
              cIDFILE = CPLib.Substr(cRiga,42,15);
              /* cIDPROG := arfn_delzero(Substr(cRiga,57,25)) */
              cIDPROG = arfn_delzeroR.Make(m_Ctx,this).Run(CPLib.Substr(cRiga,57,25));
              /* cCODFISC := Substr(cRiga,82,16) */
              cCODFISC = CPLib.Substr(cRiga,82,16);
              /* cCOGNOME := Substr(cRiga,98,26) */
              cCOGNOME = CPLib.Substr(cRiga,98,26);
              /* cNOME := Substr(cRiga,124,25) */
              cNOME = CPLib.Substr(cRiga,124,25);
              /* cSESSO := Substr(cRiga,149,1) */
              cSESSO = CPLib.Substr(cRiga,149,1);
              /* dDATNAS := arfn_datefchar(Substr(cRiga,150,8)) */
              dDATNAS = arfn_datefcharR.Make(m_Ctx,this).Run(CPLib.Substr(cRiga,150,8));
              /* cNACITTA := Substr(cRiga,158,40) */
              cNACITTA = CPLib.Substr(cRiga,158,40);
              /* cNAPROV := Substr(cRiga,198,2) */
              cNAPROV = CPLib.Substr(cRiga,198,2);
              /* cRAGSOC := Substr(cRiga,200,60) */
              cRAGSOC = CPLib.Substr(cRiga,200,60);
              /* cSLCITTA := Substr(cRiga,260,40) */
              cSLCITTA = CPLib.Substr(cRiga,260,40);
              /* cSLPROV := Substr(cRiga,300,2) */
              cSLPROV = CPLib.Substr(cRiga,300,2);
              /* cTIPOINF := Substr(cRiga,302,2) */
              cTIPOINF = CPLib.Substr(cRiga,302,2);
              /* cCOINT := Substr(cRiga,304,1) */
              cCOINT = CPLib.Substr(cRiga,304,1);
              /* dDATAPE := arfn_datefchar(Substr(cRiga,305,8)) */
              dDATAPE = arfn_datefcharR.Make(m_Ctx,this).Run(CPLib.Substr(cRiga,305,8));
              /* dDATCHI := arfn_datefchar(Substr(cRiga,313,8)) */
              dDATCHI = arfn_datefcharR.Make(m_Ctx,this).Run(CPLib.Substr(cRiga,313,8));
              /* If Len(LRTrim(cNPROG+cCODFISC)) > 0 */
              if (CPLib.gt(CPLib.Len(CPLib.LRTrim(cNPROG+cCODFISC)),0)) {
                // * --- Insert into tmp_imp_filae from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_imp_filae");
                m_cPhName = m_Ctx.GetPhName("tmp_imp_filae");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_imp_filae")+" (";
                m_cSql = m_cSql+GetFieldsName_074B26C8(m_Ctx);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(_periodo,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_tipofile,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_descfile,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cNPROG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cCODFISC,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cCOGNOME,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cNOME,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cSESSO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(dDATNAS,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cNACITTA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cNAPROV,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cRAGSOC,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cSLCITTA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cSLPROV,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cTIPOINF,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cCOINT,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(dDATAPE,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(dDATCHI,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cIDFILE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cIDPROG,"?",0,0,m_cServer)+", ";
                if (m_Ctx.IsSharedTemp("tmp_imp_filae")) {
                  m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                }
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_imp_filae",true);
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
              /* cicla := cicla + 1 */
              cicla = CPLib.Round(cicla+1,0);
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' rapporti' // Messaggio Import */
              gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" rapporti";
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            } // End While
            /* Case _tipofile='3' */
          } else if (CPLib.eqr(_tipofile,"3")) {
            /* While cicla <= 4 */
            while (CPLib.le(cicla,4)) {
              /* cRiga := Substr(riga,(cicla * 330)+2,330) */
              cRiga = CPLib.Substr(riga,(cicla*330)+2,330);
              /* cNPROG := Substr(cRiga,1,25) */
              cNPROG = CPLib.Substr(cRiga,1,25);
              /* cIDFILE := Substr(cRiga,42,15) */
              cIDFILE = CPLib.Substr(cRiga,42,15);
              /* cIDPROG := arfn_delzero(Substr(cRiga,57,25)) */
              cIDPROG = arfn_delzeroR.Make(m_Ctx,this).Run(CPLib.Substr(cRiga,57,25));
              /* cTIPOOP := iif(Substr(cRiga,82,1)='1','CANCELLAZIONE','RETTIFICA') */
              cTIPOOP = (CPLib.eqr(CPLib.Substr(cRiga,82,1),"1")?"CANCELLAZIONE":"RETTIFICA");
              /* cCODFISC := Substr(cRiga,83,16) */
              cCODFISC = CPLib.Substr(cRiga,83,16);
              /* cCOGNOME := Substr(cRiga,99,26) */
              cCOGNOME = CPLib.Substr(cRiga,99,26);
              /* cNOME := Substr(cRiga,125,25) */
              cNOME = CPLib.Substr(cRiga,125,25);
              /* cSESSO := Substr(cRiga,150,1) */
              cSESSO = CPLib.Substr(cRiga,150,1);
              /* dDATNAS := arfn_datefchar(Substr(cRiga,151,8)) */
              dDATNAS = arfn_datefcharR.Make(m_Ctx,this).Run(CPLib.Substr(cRiga,151,8));
              /* cNACITTA := Substr(cRiga,159,40) */
              cNACITTA = CPLib.Substr(cRiga,159,40);
              /* cNAPROV := Substr(cRiga,199,2) */
              cNAPROV = CPLib.Substr(cRiga,199,2);
              /* cRAGSOC := Substr(cRiga,201,60) */
              cRAGSOC = CPLib.Substr(cRiga,201,60);
              /* cSLCITTA := Substr(cRiga,261,40) */
              cSLCITTA = CPLib.Substr(cRiga,261,40);
              /* cSLPROV := Substr(cRiga,301,2) */
              cSLPROV = CPLib.Substr(cRiga,301,2);
              /* cTIPOINF := Substr(cRiga,303,2) */
              cTIPOINF = CPLib.Substr(cRiga,303,2);
              /* cCOINT := Substr(cRiga,305,1) */
              cCOINT = CPLib.Substr(cRiga,305,1);
              /* dDATAPE := arfn_datefchar(Substr(cRiga,306,8)) */
              dDATAPE = arfn_datefcharR.Make(m_Ctx,this).Run(CPLib.Substr(cRiga,306,8));
              /* dDATCHI := arfn_datefchar(Substr(cRiga,314,8)) */
              dDATCHI = arfn_datefcharR.Make(m_Ctx,this).Run(CPLib.Substr(cRiga,314,8));
              /* If Len(LRTrim(cNPROG+cCODFISC)) > 0 */
              if (CPLib.gt(CPLib.Len(CPLib.LRTrim(cNPROG+cCODFISC)),0)) {
                // * --- Insert into tmp_imp_filae from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_imp_filae");
                m_cPhName = m_Ctx.GetPhName("tmp_imp_filae");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_imp_filae")+" (";
                m_cSql = m_cSql+GetFieldsName_06E85E28(m_Ctx);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(_periodo,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_tipofile,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_descfile,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cNPROG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cCODFISC,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cCOGNOME,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cNOME,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cSESSO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(dDATNAS,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cNACITTA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cNAPROV,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cRAGSOC,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cSLCITTA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cSLPROV,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cTIPOINF,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cCOINT,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(dDATAPE,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(dDATCHI,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cIDFILE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cIDPROG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cTIPOOP,"?",0,0,m_cServer)+", ";
                if (m_Ctx.IsSharedTemp("tmp_imp_filae")) {
                  m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                }
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_imp_filae",true);
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
              /* cicla := cicla + 1 */
              cicla = CPLib.Round(cicla+1,0);
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' rapporti' // Messaggio Import */
              gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" rapporti";
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            } // End While
            /* Case _tipofile='4' */
          } else if (CPLib.eqr(_tipofile,"4")) {
            /* While cicla <= 4 */
            while (CPLib.le(cicla,4)) {
              /* cRiga := Substr(riga,(cicla * 330)+2,330) */
              cRiga = CPLib.Substr(riga,(cicla*330)+2,330);
              /* cNPROG := Substr(cRiga,1,25) */
              cNPROG = CPLib.Substr(cRiga,1,25);
              /* cCODFISC := '' */
              cCODFISC = "";
              /* cCOGNOME := Substr(cRiga,26,26) */
              cCOGNOME = CPLib.Substr(cRiga,26,26);
              /* cNOME := Substr(cRiga,52,25) */
              cNOME = CPLib.Substr(cRiga,52,25);
              /* cSESSO := Substr(cRiga,77,1) */
              cSESSO = CPLib.Substr(cRiga,77,1);
              /* dDATNAS := arfn_datefchar(Substr(cRiga,78,8)) */
              dDATNAS = arfn_datefcharR.Make(m_Ctx,this).Run(CPLib.Substr(cRiga,78,8));
              /* cNACITTA := Substr(cRiga,86,40) */
              cNACITTA = CPLib.Substr(cRiga,86,40);
              /* cNAPROV := Substr(cRiga,126,2) */
              cNAPROV = CPLib.Substr(cRiga,126,2);
              /* cRAGSOC := Substr(cRiga,128,60) */
              cRAGSOC = CPLib.Substr(cRiga,128,60);
              /* cSLCITTA := Substr(cRiga,188,40) */
              cSLCITTA = CPLib.Substr(cRiga,188,40);
              /* cSLPROV := Substr(cRiga,228,2) */
              cSLPROV = CPLib.Substr(cRiga,228,2);
              /* cTIPOINF := Substr(cRiga,230,2) */
              cTIPOINF = CPLib.Substr(cRiga,230,2);
              /* cCOINT := Substr(cRiga,232,1) */
              cCOINT = CPLib.Substr(cRiga,232,1);
              /* dDATAPE := arfn_datefchar(Substr(cRiga,233,8)) */
              dDATAPE = arfn_datefcharR.Make(m_Ctx,this).Run(CPLib.Substr(cRiga,233,8));
              /* dDATCHI := arfn_datefchar(Substr(cRiga,241,8)) */
              dDATCHI = arfn_datefcharR.Make(m_Ctx,this).Run(CPLib.Substr(cRiga,241,8));
              /* If Len(LRTrim(cNPROG+cCODFISC)) > 0 */
              if (CPLib.gt(CPLib.Len(CPLib.LRTrim(cNPROG+cCODFISC)),0)) {
                // * --- Insert into tmp_imp_filae from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_imp_filae");
                m_cPhName = m_Ctx.GetPhName("tmp_imp_filae");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_imp_filae")+" (";
                m_cSql = m_cSql+GetFieldsName_0736D030(m_Ctx);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(_periodo,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_tipofile,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_descfile,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cNPROG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cCODFISC,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cCOGNOME,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cNOME,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cSESSO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(dDATNAS,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cNACITTA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cNAPROV,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cRAGSOC,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cSLCITTA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cSLPROV,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cTIPOINF,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cCOINT,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(dDATAPE,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(dDATCHI,"?",0,0)+", ";
                if (m_Ctx.IsSharedTemp("tmp_imp_filae")) {
                  m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                }
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_imp_filae",true);
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
              /* cicla := cicla + 1 */
              cicla = CPLib.Round(cicla+1,0);
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' rapporti' // Messaggio Import */
              gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" rapporti";
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            } // End While
            /* Case _tipofile='5' */
          } else if (CPLib.eqr(_tipofile,"5")) {
            /* While cicla <= 4 */
            while (CPLib.le(cicla,4)) {
              /* cRiga := Substr(riga,(cicla * 330)+2,330) */
              cRiga = CPLib.Substr(riga,(cicla*330)+2,330);
              /* cNPROG := Substr(cRiga,1,25) */
              cNPROG = CPLib.Substr(cRiga,1,25);
              /* cIDFILE := Substr(cRiga,42,15) */
              cIDFILE = CPLib.Substr(cRiga,42,15);
              /* cIDPROG := arfn_delzero(Substr(cRiga,57,25)) */
              cIDPROG = arfn_delzeroR.Make(m_Ctx,this).Run(CPLib.Substr(cRiga,57,25));
              /* cCODFISC := '' */
              cCODFISC = "";
              /* cCOGNOME := Substr(cRiga,82,26) */
              cCOGNOME = CPLib.Substr(cRiga,82,26);
              /* cNOME := Substr(cRiga,108,25) */
              cNOME = CPLib.Substr(cRiga,108,25);
              /* cSESSO := Substr(cRiga,133,1) */
              cSESSO = CPLib.Substr(cRiga,133,1);
              /* dDATNAS := arfn_datefchar(Substr(cRiga,134,8)) */
              dDATNAS = arfn_datefcharR.Make(m_Ctx,this).Run(CPLib.Substr(cRiga,134,8));
              /* cNACITTA := Substr(cRiga,142,40) */
              cNACITTA = CPLib.Substr(cRiga,142,40);
              /* cNAPROV := Substr(cRiga,182,2) */
              cNAPROV = CPLib.Substr(cRiga,182,2);
              /* cRAGSOC := Substr(cRiga,184,60) */
              cRAGSOC = CPLib.Substr(cRiga,184,60);
              /* cSLCITTA := Substr(cRiga,244,40) */
              cSLCITTA = CPLib.Substr(cRiga,244,40);
              /* cSLPROV := Substr(cRiga,284,2) */
              cSLPROV = CPLib.Substr(cRiga,284,2);
              /* cTIPOINF := Substr(cRiga,286,2) */
              cTIPOINF = CPLib.Substr(cRiga,286,2);
              /* cCOINT := Substr(cRiga,288,1) */
              cCOINT = CPLib.Substr(cRiga,288,1);
              /* dDATAPE := arfn_datefchar(Substr(cRiga,289,8)) */
              dDATAPE = arfn_datefcharR.Make(m_Ctx,this).Run(CPLib.Substr(cRiga,289,8));
              /* dDATCHI := arfn_datefchar(Substr(cRiga,297,8)) */
              dDATCHI = arfn_datefcharR.Make(m_Ctx,this).Run(CPLib.Substr(cRiga,297,8));
              /* If Len(LRTrim(cNPROG+cCODFISC)) > 0 */
              if (CPLib.gt(CPLib.Len(CPLib.LRTrim(cNPROG+cCODFISC)),0)) {
                // * --- Insert into tmp_imp_filae from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_imp_filae");
                m_cPhName = m_Ctx.GetPhName("tmp_imp_filae");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_imp_filae")+" (";
                m_cSql = m_cSql+GetFieldsName_064713A8(m_Ctx);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(_periodo,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_tipofile,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_descfile,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cNPROG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cCODFISC,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cCOGNOME,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cNOME,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cSESSO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(dDATNAS,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cNACITTA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cNAPROV,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cRAGSOC,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cSLCITTA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cSLPROV,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cTIPOINF,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cCOINT,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(dDATAPE,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(dDATCHI,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cIDFILE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cIDPROG,"?",0,0,m_cServer)+", ";
                if (m_Ctx.IsSharedTemp("tmp_imp_filae")) {
                  m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                }
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_imp_filae",true);
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
              /* cicla := cicla + 1 */
              cicla = CPLib.Round(cicla+1,0);
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' rapporti' // Messaggio Import */
              gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" rapporti";
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            } // End While
            /* Case _tipofile='6' */
          } else if (CPLib.eqr(_tipofile,"6")) {
            /* While cicla <= 4 */
            while (CPLib.le(cicla,4)) {
              /* cRiga := Substr(riga,(cicla * 330)+2,330) */
              cRiga = CPLib.Substr(riga,(cicla*330)+2,330);
              /* cNPROG := Substr(cRiga,1,25) */
              cNPROG = CPLib.Substr(cRiga,1,25);
              /* cIDFILE := Substr(cRiga,42,15) */
              cIDFILE = CPLib.Substr(cRiga,42,15);
              /* cIDPROG := arfn_delzero(Substr(cRiga,57,25)) */
              cIDPROG = arfn_delzeroR.Make(m_Ctx,this).Run(CPLib.Substr(cRiga,57,25));
              /* cTIPOOP := iif(Substr(cRiga,82,1)='1','CANCELLAZIONE','RETTIFICA') */
              cTIPOOP = (CPLib.eqr(CPLib.Substr(cRiga,82,1),"1")?"CANCELLAZIONE":"RETTIFICA");
              /* cCODFISC := '' */
              cCODFISC = "";
              /* cCOGNOME := Substr(cRiga,99,26) */
              cCOGNOME = CPLib.Substr(cRiga,99,26);
              /* cNOME := Substr(cRiga,125,25) */
              cNOME = CPLib.Substr(cRiga,125,25);
              /* cSESSO := Substr(cRiga,150,1) */
              cSESSO = CPLib.Substr(cRiga,150,1);
              /* dDATNAS := arfn_datefchar(Substr(cRiga,151,8)) */
              dDATNAS = arfn_datefcharR.Make(m_Ctx,this).Run(CPLib.Substr(cRiga,151,8));
              /* cNACITTA := Substr(cRiga,159,40) */
              cNACITTA = CPLib.Substr(cRiga,159,40);
              /* cNAPROV := Substr(cRiga,199,2) */
              cNAPROV = CPLib.Substr(cRiga,199,2);
              /* cRAGSOC := Substr(cRiga,201,60) */
              cRAGSOC = CPLib.Substr(cRiga,201,60);
              /* cSLCITTA := Substr(cRiga,261,40) */
              cSLCITTA = CPLib.Substr(cRiga,261,40);
              /* cSLPROV := Substr(cRiga,301,2) */
              cSLPROV = CPLib.Substr(cRiga,301,2);
              /* cTIPOINF := Substr(cRiga,303,2) */
              cTIPOINF = CPLib.Substr(cRiga,303,2);
              /* cCOINT := Substr(cRiga,305,1) */
              cCOINT = CPLib.Substr(cRiga,305,1);
              /* dDATAPE := arfn_datefchar(Substr(cRiga,306,8)) */
              dDATAPE = arfn_datefcharR.Make(m_Ctx,this).Run(CPLib.Substr(cRiga,306,8));
              /* dDATCHI := arfn_datefchar(Substr(cRiga,314,8)) */
              dDATCHI = arfn_datefcharR.Make(m_Ctx,this).Run(CPLib.Substr(cRiga,314,8));
              /* If Len(LRTrim(cNPROG+cCODFISC)) > 0 */
              if (CPLib.gt(CPLib.Len(CPLib.LRTrim(cNPROG+cCODFISC)),0)) {
                // * --- Insert into tmp_imp_filae from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_imp_filae");
                m_cPhName = m_Ctx.GetPhName("tmp_imp_filae");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_imp_filae")+" (";
                m_cSql = m_cSql+GetFieldsName_0719B498(m_Ctx);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(_periodo,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_tipofile,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_descfile,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cNPROG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cCODFISC,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cCOGNOME,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cNOME,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cSESSO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(dDATNAS,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cNACITTA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cNAPROV,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cRAGSOC,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cSLCITTA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cSLPROV,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cTIPOINF,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cCOINT,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(dDATAPE,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(dDATCHI,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cIDFILE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cIDPROG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cTIPOOP,"?",0,0,m_cServer)+", ";
                if (m_Ctx.IsSharedTemp("tmp_imp_filae")) {
                  m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                }
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_imp_filae",true);
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
              /* cicla := cicla + 1 */
              cicla = CPLib.Round(cicla+1,0);
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' rapporti' // Messaggio Import */
              gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" rapporti";
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            } // End While
          } // End Case
        } // End If
      } // End While
    } // End If
    /* FileLibrary.Close(fhand) */
    FileLibrary.Close(fhand);
    /* FileLibrary.DeleteFile('appo/'+LRTrim(_filename)) */
    FileLibrary.DeleteFile("appo/"+CPLib.LRTrim(_filename));
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
      m_Caller.SetNumber("offset","N",5,0,w_offset);
      m_Caller.SetString("f_denom","C",1,0,w_f_denom);
      m_Caller.SetString("prefrap","C",5,0,w_prefrap);
      m_Caller.SetString("f_ricaui","C",1,0,w_f_ricaui);
      m_Caller.SetString("codval","C",3,0,w_codval);
      m_Caller.SetString("fileape","C",80,0,w_fileape);
      m_Caller.SetNumber("impzip","N",1,0,w_impzip);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_import_fileae_esitiR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_import_fileae_esitiR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_offset = m_Caller.GetNumber("offset","N",5,0);
    w_f_denom = m_Caller.GetString("f_denom","C",1,0);
    w_prefrap = m_Caller.GetString("prefrap","C",5,0);
    w_f_ricaui = m_Caller.GetString("f_ricaui","C",1,0);
    w_codval = m_Caller.GetString("codval","C",3,0);
    w_fileape = m_Caller.GetString("fileape","C",80,0);
    w_impzip = m_Caller.GetNumber("impzip","N",1,0);
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
    cID = CPLib.Space(10);
    _dtret = CPLib.NullDate();
    _friga = 0;
    _frappo = CPLib.Space(25);
    _tipoag = CPLib.Space(2);
    _coint = CPLib.Space(1);
    _idbase = CPLib.Space(10);
    czipfile = CPLib.Space(100);
    cpercorsozip = CPLib.Space(200);
    cdirectoryfile = CPLib.Space(200);
    buffernomefile = CPLib.Space(100);
    nomefileimport = CPLib.Space(50);
    _priorita = 0;
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_datefchar,arfn_delzero,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_datefchar,arfn_delzero,arfn_fdatetime,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_079B0E88(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"PERIODO,";
    p_cSql = p_cSql+"INVIO,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"NPROG,";
    p_cSql = p_cSql+"CF,";
    p_cSql = p_cSql+"CNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"NADATA,";
    p_cSql = p_cSql+"NACITTA,";
    p_cSql = p_cSql+"NAPROV,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"SLCITTA,";
    p_cSql = p_cSql+"SLPROV,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+"CDATA,";
    if (p_Ctx.IsSharedTemp("tmp_imp_filae")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_imp_filae",true);
    return p_cSql;
  }
  protected static String GetFieldsName_074B26C8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"PERIODO,";
    p_cSql = p_cSql+"INVIO,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"NPROG,";
    p_cSql = p_cSql+"CF,";
    p_cSql = p_cSql+"CNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"NADATA,";
    p_cSql = p_cSql+"NACITTA,";
    p_cSql = p_cSql+"NAPROV,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"SLCITTA,";
    p_cSql = p_cSql+"SLPROV,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+"CDATA,";
    p_cSql = p_cSql+"OLDID,";
    p_cSql = p_cSql+"OLDPROG,";
    if (p_Ctx.IsSharedTemp("tmp_imp_filae")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_imp_filae",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06E85E28(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"PERIODO,";
    p_cSql = p_cSql+"INVIO,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"NPROG,";
    p_cSql = p_cSql+"CF,";
    p_cSql = p_cSql+"CNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"NADATA,";
    p_cSql = p_cSql+"NACITTA,";
    p_cSql = p_cSql+"NAPROV,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"SLCITTA,";
    p_cSql = p_cSql+"SLPROV,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+"CDATA,";
    p_cSql = p_cSql+"OLDID,";
    p_cSql = p_cSql+"OLDPROG,";
    p_cSql = p_cSql+"TIPOOP,";
    if (p_Ctx.IsSharedTemp("tmp_imp_filae")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_imp_filae",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0736D030(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"PERIODO,";
    p_cSql = p_cSql+"INVIO,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"NPROG,";
    p_cSql = p_cSql+"CF,";
    p_cSql = p_cSql+"CNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"NADATA,";
    p_cSql = p_cSql+"NACITTA,";
    p_cSql = p_cSql+"NAPROV,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"SLCITTA,";
    p_cSql = p_cSql+"SLPROV,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+"CDATA,";
    if (p_Ctx.IsSharedTemp("tmp_imp_filae")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_imp_filae",true);
    return p_cSql;
  }
  protected static String GetFieldsName_064713A8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"PERIODO,";
    p_cSql = p_cSql+"INVIO,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"NPROG,";
    p_cSql = p_cSql+"CF,";
    p_cSql = p_cSql+"CNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"NADATA,";
    p_cSql = p_cSql+"NACITTA,";
    p_cSql = p_cSql+"NAPROV,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"SLCITTA,";
    p_cSql = p_cSql+"SLPROV,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+"CDATA,";
    p_cSql = p_cSql+"OLDID,";
    p_cSql = p_cSql+"OLDPROG,";
    if (p_Ctx.IsSharedTemp("tmp_imp_filae")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_imp_filae",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0719B498(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"PERIODO,";
    p_cSql = p_cSql+"INVIO,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"NPROG,";
    p_cSql = p_cSql+"CF,";
    p_cSql = p_cSql+"CNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"NADATA,";
    p_cSql = p_cSql+"NACITTA,";
    p_cSql = p_cSql+"NAPROV,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"SLCITTA,";
    p_cSql = p_cSql+"SLPROV,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+"CDATA,";
    p_cSql = p_cSql+"OLDID,";
    p_cSql = p_cSql+"OLDPROG,";
    p_cSql = p_cSql+"TIPOOP,";
    if (p_Ctx.IsSharedTemp("tmp_imp_filae")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_imp_filae",true);
    return p_cSql;
  }
}
