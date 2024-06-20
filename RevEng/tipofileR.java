// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class tipofileR implements CallerWithObjs {
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
  // * --- tipofile
  public String[] lista;
  public int conteggio;
  public int i;
  public int contanome;
  // * --- Fine Area Manuale
  public tipofileR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("tipofile",m_Caller);
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
    if (m_Ctx.IsTmpAlreadyCreated("tmp_rapportipd")) {
      m_cPhName_tmp_rapportipd = p_ContextObject.GetPhName("tmp_rapportipd");
      m_cServer_tmp_rapportipd = p_ContextObject.GetServer("tmp_rapportipd");
    }
    m_cPhName_aestor = p_ContextObject.GetPhName("aestor");
    m_cServer_aestor = p_ContextObject.GetServer("aestor");
    m_cPhName_aecanc = p_ContextObject.GetPhName("aecanc");
    m_cServer_aecanc = p_ContextObject.GetServer("aecanc");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec)  {
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
  public String GetString(String p_cVarName,String p_cType,int len,int dec)  {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "tipofile";
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
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec)  {
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
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec)  {
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec)  {
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec)  {
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec)  {
    return null;
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value)  {
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
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value)  {
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
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value)  {
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
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value)  {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value)  {
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value)  {
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value)  {
  }
  public void CalledBatchEnd()  {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_tmp_list_imprich=null;
    try {
      /* Dichiarazione variabili del caller */
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
      /* If w_impzip=1 */
      if (CPLib.eqr(w_impzip,1)) {
        /* Exec "Estrae Lo Zip" Page 6 */
        Page_6();
      } // End If
      // * --- Drop temporary table tmp_rapportipd
      if (m_Ctx.IsSharedTemp("tmp_rapportipd")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_rapportipd")) {
          m_cServer = m_Ctx.GetServer("tmp_rapportipd");
          m_cPhName = m_Ctx.GetPhName("tmp_rapportipd");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_rapportipd");
      }
      // * --- Create temporary table tmp_rapportipd
      if (m_Ctx.IsSharedTemp("tmp_rapportipd")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_rapportipd")) {
          m_cServer = m_Ctx.GetServer("tmp_rapportipd");
          m_cPhName = m_Ctx.GetPhName("tmp_rapportipd");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_rapportipd");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_rapportipd");
      if ( ! (m_Ctx.IsSharedTemp("tmp_rapportipd"))) {
        m_cServer = m_Ctx.GetServer("tmp_rapportipd");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_rapportipd",m_cServer,"proto")),m_cPhName,"tmp_rapportipd",m_Ctx);
      }
      m_cPhName_tmp_rapportipd = m_cPhName;
      // * --- Select from tmp_list_imprich
      m_cServer = m_Ctx.GetServer("tmp_list_imprich");
      m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
      if (Cursor_tmp_list_imprich!=null)
        Cursor_tmp_list_imprich.Close();
      Cursor_tmp_list_imprich = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_list_imprich")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_tmp_list_imprich.Eof())) {
        /* If _esito = 0 */
        if (CPLib.eqr(_esito,0)) {
          /* _filename := tmp_list_imprich->nomefile */
          _filename = Cursor_tmp_list_imprich.GetString("nomefile");
          /* Exec "Legge File di testo" Page 2 */
          Page_2();
          /* Exec "Scrive i Rapporti" Page 3 */
          Page_3();
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
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        Cursor_tmp_list_imprich.Next();
      }
      m_cConnectivityError = Cursor_tmp_list_imprich.ErrorMessage();
      Cursor_tmp_list_imprich.Close();
      // * --- End Select
      /* If w_f_ricaui='A' */
      if (CPLib.eqr(w_f_ricaui,"A")) {
        /* Exec "Ricostruisce AUI" Page 4 */
        Page_4();
        /* ElseIf w_f_ricaui='G' */
      } else if (CPLib.eqr(w_f_ricaui,"G")) {
        /* Exec "Ricostruisce AGE" Page 5 */
        Page_5();
      } // End If
      /* If _esito=0 */
      if (CPLib.eqr(_esito,0)) {
        /* gMsgProc := gMsgProc + 'Sono stati inseriti o aggiornati:'+NL+'Soggetti: '+LRTrim(Str(cNumSog,10,0))+NL+'Rapporti: '+LRTrim(Str(cNumRap,10,0))+NL+'Deleghe: '+LRTrim(Str(cNumDel,10,0))+NL+'Operazioni ExtraConto: '+LRTrim(Str(cNumOXC,10,0))+NL */
        gMsgProc = gMsgProc+"Sono stati inseriti o aggiornati:"+"\n"+"Soggetti: "+CPLib.LRTrim(CPLib.Str(cNumSog,10,0))+"\n"+"Rapporti: "+CPLib.LRTrim(CPLib.Str(cNumRap,10,0))+"\n"+"Deleghe: "+CPLib.LRTrim(CPLib.Str(cNumDel,10,0))+"\n"+"Operazioni ExtraConto: "+CPLib.LRTrim(CPLib.Str(cNumOXC,10,0))+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
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
    /* Legge il file di testo e porta i dati nella tabella */
    /* conta := 0 */
    conta = CPLib.Round(0,0);
    /* fhand := FileLibrary.OpenRead('appo/'+LRTrim(_filename)) */
    fhand = FileLibrary.OpenRead("appo/"+CPLib.LRTrim(_filename));
    /* riga := FileLibrary.ReadLine(fhand) */
    riga = FileLibrary.ReadLine(fhand);
    /* If Left(riga,8) <> '0CCB0034' */
    if (CPLib.ne(CPLib.Left(riga,8),"0CCB0034")) {
      /* gMsgProc := gMsgProc + "ll file "+LRTrim(_filename)+"non � nel formato standard per Anagrafe dei Rapporti"+NL // Messaggio Import */
      gMsgProc = gMsgProc+"ll file "+CPLib.LRTrim(_filename)+"non � nel formato standard per Anagrafe dei Rapporti"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
      /* ElseIf LRTrim(Substr(riga,9,16)) <> LRTrim(_codint) */
    } else if (CPLib.ne(CPLib.LRTrim(CPLib.Substr(riga,9,16)),CPLib.LRTrim(_codint))) {
      /* gMsgProc := gMsgProc + "ll file "+LRTrim(_filename)+" non � relativo a questo Intermediario"+NL // Messaggio Import */
      gMsgProc = gMsgProc+"ll file "+CPLib.LRTrim(_filename)+" non � relativo a questo Intermediario"+"\n";
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
              /* cNPROG := arfn_delzero(Substr(cRiga,1,25)) */
              cNPROG = arfn_delzeroR.Make(m_Ctx,this).Run(CPLib.Substr(cRiga,1,25));
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
                // * --- Insert into tmp_imp_filae
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_imp_filae");
                m_cPhName = m_Ctx.GetPhName("tmp_imp_filae");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "insert into "+m_cPhName+" (";
                m_cSql = m_cSql+GetFieldsName_05CA0FD8(m_Ctx);
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
              /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' rapporti/operazioni' // Messaggio Import */
              gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" rapporti/operazioni";
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            } // End While
            /* Case _tipofile='2' */
          } else if (CPLib.eqr(_tipofile,"2")) {
            /* While cicla <= 4 */
            while (CPLib.le(cicla,4)) {
              /* cRiga := Substr(riga,(cicla * 330)+2,330) */
              cRiga = CPLib.Substr(riga,(cicla*330)+2,330);
              /* cNPROG := arfn_delzero(Substr(cRiga,1,25)) */
              cNPROG = arfn_delzeroR.Make(m_Ctx,this).Run(CPLib.Substr(cRiga,1,25));
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
                // * --- Insert into tmp_imp_filae
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_imp_filae");
                m_cPhName = m_Ctx.GetPhName("tmp_imp_filae");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "insert into "+m_cPhName+" (";
                m_cSql = m_cSql+GetFieldsName_06222C38(m_Ctx);
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
              /* cNPROG := arfn_delzero(Substr(cRiga,1,25)) */
              cNPROG = arfn_delzeroR.Make(m_Ctx,this).Run(CPLib.Substr(cRiga,1,25));
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
                // * --- Insert into tmp_imp_filae
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_imp_filae");
                m_cPhName = m_Ctx.GetPhName("tmp_imp_filae");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "insert into "+m_cPhName+" (";
                m_cSql = m_cSql+GetFieldsName_061A0718(m_Ctx);
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
              /* cNPROG := arfn_delzero(Substr(cRiga,1,25)) */
              cNPROG = arfn_delzeroR.Make(m_Ctx,this).Run(CPLib.Substr(cRiga,1,25));
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
                // * --- Insert into tmp_imp_filae
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_imp_filae");
                m_cPhName = m_Ctx.GetPhName("tmp_imp_filae");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "insert into "+m_cPhName+" (";
                m_cSql = m_cSql+GetFieldsName_062099C8(m_Ctx);
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
              /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' rapporti/operazioni' // Messaggio Import */
              gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" rapporti/operazioni";
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            } // End While
            /* Case _tipofile='5' */
          } else if (CPLib.eqr(_tipofile,"5")) {
            /* While cicla <= 4 */
            while (CPLib.le(cicla,4)) {
              /* cRiga := Substr(riga,(cicla * 330)+2,330) */
              cRiga = CPLib.Substr(riga,(cicla*330)+2,330);
              /* cNPROG := arfn_delzero(Substr(cRiga,1,25)) */
              cNPROG = arfn_delzeroR.Make(m_Ctx,this).Run(CPLib.Substr(cRiga,1,25));
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
                // * --- Insert into tmp_imp_filae
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_imp_filae");
                m_cPhName = m_Ctx.GetPhName("tmp_imp_filae");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "insert into "+m_cPhName+" (";
                m_cSql = m_cSql+GetFieldsName_060118B0(m_Ctx);
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
              /* cNPROG := arfn_delzero(Substr(cRiga,1,25)) */
              cNPROG = arfn_delzeroR.Make(m_Ctx,this).Run(CPLib.Substr(cRiga,1,25));
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
                // * --- Insert into tmp_imp_filae
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_imp_filae");
                m_cPhName = m_Ctx.GetPhName("tmp_imp_filae");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "insert into "+m_cPhName+" (";
                m_cSql = m_cSql+GetFieldsName_05C50818(m_Ctx);
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
  void Page_3() throws Exception {
    CPResultSet Cursor_tmp_imp_filae=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_aerighe=null;
    try {
      /* Legge il file d'appoggio e scrive i rapporti */
      // begin transaction
      m_Sql.RequireTransaction();
      double nTry05A40CE8status;
      nTry05A40CE8status = m_Sql.GetTransactionStatus();
      String cTry05A40CE8msg;
      cTry05A40CE8msg = m_Sql.TransactionErrorMessage();
      try {
        // * --- Select from tmp_imp_filae
        m_cServer = m_Ctx.GetServer("tmp_imp_filae");
        m_cPhName = m_Ctx.GetPhName("tmp_imp_filae");
        if (Cursor_tmp_imp_filae!=null)
          Cursor_tmp_imp_filae.Close();
        Cursor_tmp_imp_filae = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_imp_filae")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_tmp_imp_filae.Eof())) {
          /* If tmp_imp_filae->INVIO > '3' */
          if (CPLib.gt(Cursor_tmp_imp_filae.GetString("INVIO"),"3")) {
            /* If Empty(tmp_imp_filae->SESSO) */
            if (CPLib.Empty(Cursor_tmp_imp_filae.GetString("SESSO"))) {
              // * --- Read from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              m_cSql = "";
              m_cSql = m_cSql+"RAGSOC="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("RAGSOC"),"C",70,0,m_cServer),m_cServer,Cursor_tmp_imp_filae.GetString("RAGSOC"));
              m_cSql = m_cSql+" and DESCCIT="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("SLCITTA"),"C",30,0,m_cServer),m_cServer,Cursor_tmp_imp_filae.GetString("SLCITTA"));
              m_cSql = m_cSql+" and PROVINCIA="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("SLPROV"),"C",2,0,m_cServer),m_cServer,Cursor_tmp_imp_filae.GetString("SLPROV"));
              if (m_Ctx.IsSharedTemp("personbo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select CONNES from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _connes = Read_Cursor.GetString("CONNES");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on personbo into routine tipofile returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _connes = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
            } else { // Else
              /* If tmp_imp_filae->NAPROV='EE' */
              if (CPLib.eqr(Cursor_tmp_imp_filae.GetString("NAPROV"),"EE")) {
                // * --- Read from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                m_cSql = "";
                m_cSql = m_cSql+"COGNOME="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("CNOME"),"C",26,0,m_cServer),m_cServer,Cursor_tmp_imp_filae.GetString("CNOME"));
                m_cSql = m_cSql+" and NOME="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("NOME"),"C",25,0,m_cServer),m_cServer,Cursor_tmp_imp_filae.GetString("NOME"));
                m_cSql = m_cSql+" and DATANASC="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_imp_filae.GetDate("NADATA"),"D",8,0,m_cServer),m_cServer,Cursor_tmp_imp_filae.GetDate("NADATA"));
                m_cSql = m_cSql+" and NASSTATO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("NACITTA"),"C",30,0,m_cServer),m_cServer,Cursor_tmp_imp_filae.GetString("NACITTA"));
                m_cSql = m_cSql+" and TIPINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("NAPROV"),"C",2,0,m_cServer),m_cServer,Cursor_tmp_imp_filae.GetString("NAPROV"));
                if (m_Ctx.IsSharedTemp("personbo")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select CONNES from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _connes = Read_Cursor.GetString("CONNES");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on personbo into routine tipofile returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _connes = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
              } else { // Else
                // * --- Read from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                m_cSql = "";
                m_cSql = m_cSql+"COGNOME="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("CNOME"),"C",26,0,m_cServer),m_cServer,Cursor_tmp_imp_filae.GetString("CNOME"));
                m_cSql = m_cSql+" and NOME="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("NOME"),"C",25,0,m_cServer),m_cServer,Cursor_tmp_imp_filae.GetString("NOME"));
                m_cSql = m_cSql+" and DATANASC="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_imp_filae.GetDate("NADATA"),"D",8,0,m_cServer),m_cServer,Cursor_tmp_imp_filae.GetDate("NADATA"));
                m_cSql = m_cSql+" and NASCOMUN="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("NACITTA"),"C",30,0,m_cServer),m_cServer,Cursor_tmp_imp_filae.GetString("NACITTA"));
                m_cSql = m_cSql+" and TIPINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("NAPROV"),"C",2,0,m_cServer),m_cServer,Cursor_tmp_imp_filae.GetString("NAPROV"));
                if (m_Ctx.IsSharedTemp("personbo")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select CONNES from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _connes = Read_Cursor.GetString("CONNES");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on personbo into routine tipofile returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _connes = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
              } // End If
            } // End If
            /* If Empty(LRTrim(_connes)) and w_f_denom='S' */
            if (CPLib.Empty(CPLib.LRTrim(_connes)) && CPLib.eqr(w_f_denom,"S")) {
              /* If Empty(tmp_imp_filae->SESSO) */
              if (CPLib.Empty(Cursor_tmp_imp_filae.GetString("SESSO"))) {
                // * --- Read from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                m_cSql = "";
                m_cSql = m_cSql+"RAGSOC="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("RAGSOC"),"C",70,0,m_cServer),m_cServer,Cursor_tmp_imp_filae.GetString("RAGSOC"));
                if (m_Ctx.IsSharedTemp("personbo")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select CONNES from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _connes = Read_Cursor.GetString("CONNES");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on personbo into routine tipofile returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _connes = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
              } else { // Else
                // * --- Read from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                m_cSql = "";
                m_cSql = m_cSql+"COGNOME="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("CNOME"),"C",26,0,m_cServer),m_cServer,Cursor_tmp_imp_filae.GetString("CNOME"));
                m_cSql = m_cSql+" and NOME="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("NOME"),"C",25,0,m_cServer),m_cServer,Cursor_tmp_imp_filae.GetString("NOME"));
                if (m_Ctx.IsSharedTemp("personbo")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select CONNES from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _connes = Read_Cursor.GetString("CONNES");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on personbo into routine tipofile returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _connes = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
              } // End If
            } // End If
            /* If Empty(LRTrim(_connes)) */
            if (CPLib.Empty(CPLib.LRTrim(_connes))) {
              /* _connes := Left(LibreriaMit.UniqueId()+LibreriaMit.UniqueId(),16) */
              _connes = CPLib.Left(LibreriaMit.UniqueId()+LibreriaMit.UniqueId(),16);
              /* If Empty(LRTrim(tmp_imp_filae->SESSO)) */
              if (CPLib.Empty(CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("SESSO")))) {
                /* _ragsoc := tmp_imp_filae->RAGSOC */
                _ragsoc = Cursor_tmp_imp_filae.GetString("RAGSOC");
                // * --- Insert into personbo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "insert into "+m_cPhName+" (";
                m_cSql = m_cSql+GetFieldsName_06008268(m_Ctx);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(_connes,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_connes,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("RAGSOC")),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("SLCITTA")),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("SLPROV"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
                if (m_Ctx.IsSharedTemp("personbo")) {
                  m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                }
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
                  throw new RoutineException();
                }
              } else { // Else
                /* _ragsoc := LRTrim(tmp_imp_filae->CNOME)+" "+LRTrim(tmp_imp_filae->NOME) */
                _ragsoc = CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("CNOME"))+" "+CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("NOME"));
                // * --- Insert into personbo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "insert into "+m_cPhName+" (";
                m_cSql = m_cSql+GetFieldsName_061298E0(m_Ctx);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("CF"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("CNOME"))+" "+CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("NOME")),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_imp_filae.GetDate("NADATA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("NACITTA")),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("NAPROV")),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("CNOME")),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("NOME")),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_tmp_imp_filae.GetString("SESSO"),"M")?"1":"2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_connes,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_tmp_imp_filae.GetString("NAPROV"),"EE")?Cursor_tmp_imp_filae.GetString("NACITTA"):"ITALIA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
                if (m_Ctx.IsSharedTemp("personbo")) {
                  m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                }
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
                  throw new RoutineException();
                }
              } // End If
            } else { // Else
              /* If Empty(LRTrim(tmp_imp_filae->SESSO)) */
              if (CPLib.Empty(CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("SESSO")))) {
                // * --- Write into personbo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "Update "+m_cPhName+" set ";
                m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("RAGSOC")),"C",70,0,m_cServer)+", ";
                m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("SLCITTA")),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("SLPROV"),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
                if (m_Ctx.IsSharedTemp("personbo")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } else { // Else
                /* If tmp_imp_filae->NAPROV='EE' */
                if (CPLib.eqr(Cursor_tmp_imp_filae.GetString("NAPROV"),"EE")) {
                  // * --- Write into personbo
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = "Update "+m_cPhName+" set ";
                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("CF"),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("CNOME")),"C",26,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("NOME")),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetDate("NADATA"),"D",8,0)+", ";
                  m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("CNOME"))+" "+CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("NOME")),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL((CPLib.eqr(Cursor_tmp_imp_filae.GetString("SESSO"),"M")?"1":"2"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("NAPROV"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("NACITTA")),"C",30,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
                  if (m_Ctx.IsSharedTemp("personbo")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                    throw new RoutineException();
                  }
                } else { // Else
                  // * --- Write into personbo
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = "Update "+m_cPhName+" set ";
                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("CF"),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("CNOME"),"C",26,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("NOME"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetDate("NADATA"),"D",8,0)+", ";
                  m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("CNOME"))+" "+CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("NOME")),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL((CPLib.eqr(Cursor_tmp_imp_filae.GetString("SESSO"),"M")?"1":"2"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("NAPROV"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL("ITALIA","C",30,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
                  if (m_Ctx.IsSharedTemp("personbo")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                    throw new RoutineException();
                  }
                } // End If
              } // End If
            } // End If
            /* cNumSog := cNumSog + 1 */
            cNumSog = CPLib.Round(cNumSog+1,0);
          } else { // Else
            /* _connes := '' */
            _connes = "";
            /* _ragsoc := '' */
            _ragsoc = "";
            // * --- Read from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_cSql = "";
            m_cSql = m_cSql+"CODFISC="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("CF"),"C",16,0,m_cServer),m_cServer,Cursor_tmp_imp_filae.GetString("CF"));
            if (m_Ctx.IsSharedTemp("personbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select CONNES,RAGSOC from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _connes = Read_Cursor.GetString("CONNES");
              _ragsoc = Read_Cursor.GetString("RAGSOC");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on personbo into routine tipofile returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _connes = "";
              _ragsoc = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(LRTrim(_connes)) */
            if (CPLib.Empty(CPLib.LRTrim(_connes))) {
              /* _connes := tmp_imp_filae->CF */
              _connes = Cursor_tmp_imp_filae.GetString("CF");
              /* If Empty(LRTrim(tmp_imp_filae->SESSO)) */
              if (CPLib.Empty(CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("SESSO")))) {
                /* _ragsoc := tmp_imp_filae->RAGSOC */
                _ragsoc = Cursor_tmp_imp_filae.GetString("RAGSOC");
                // * --- Insert into personbo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "insert into "+m_cPhName+" (";
                m_cSql = m_cSql+GetFieldsName_05FD53F8(m_Ctx);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("CF"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("CF"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("RAGSOC")),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("SLCITTA")),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("SLPROV"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
                if (m_Ctx.IsSharedTemp("personbo")) {
                  m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                }
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
                  throw new RoutineException();
                }
              } else { // Else
                /* _ragsoc := LRTrim(tmp_imp_filae->CNOME)+" "+LRTrim(tmp_imp_filae->NOME) */
                _ragsoc = CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("CNOME"))+" "+CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("NOME"));
                // * --- Insert into personbo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "insert into "+m_cPhName+" (";
                m_cSql = m_cSql+GetFieldsName_061A7FF8(m_Ctx);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("CF"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("CNOME"))+" "+CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("NOME")),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_imp_filae.GetDate("NADATA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("NACITTA")),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("NAPROV")),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("CNOME")),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("NOME")),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_tmp_imp_filae.GetString("SESSO"),"M")?"1":"2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("CF"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim((CPLib.eqr(Cursor_tmp_imp_filae.GetString("NAPROV"),"EE")?Cursor_tmp_imp_filae.GetString("NACITTA"):"ITALIA")),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
                if (m_Ctx.IsSharedTemp("personbo")) {
                  m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                }
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
                  throw new RoutineException();
                }
              } // End If
            } else { // Else
              /* If Empty(LRTrim(tmp_imp_filae->SESSO)) */
              if (CPLib.Empty(CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("SESSO")))) {
                // * --- Write into personbo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "Update "+m_cPhName+" set ";
                m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("RAGSOC")),"C",70,0,m_cServer)+", ";
                m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("SLCITTA")),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("SLPROV"),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(0,"N",1,0)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
                if (m_Ctx.IsSharedTemp("personbo")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } else { // Else
                /* If tmp_imp_filae->NAPROV='EE' */
                if (CPLib.eqr(Cursor_tmp_imp_filae.GetString("NAPROV"),"EE")) {
                  // * --- Write into personbo
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = "Update "+m_cPhName+" set ";
                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("CF"),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("CNOME")),"C",26,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("NOME")),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetDate("NADATA"),"D",8,0)+", ";
                  m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("CNOME"))+" "+CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("NOME")),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL((CPLib.eqr(Cursor_tmp_imp_filae.GetString("SESSO"),"M")?"1":"2"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("NAPROV"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(0,"N",1,0)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("NACITTA")),"C",30,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
                  if (m_Ctx.IsSharedTemp("personbo")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                    throw new RoutineException();
                  }
                } else { // Else
                  // * --- Write into personbo
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = "Update "+m_cPhName+" set ";
                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("CF"),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("CNOME")),"C",26,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("NOME")),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetDate("NADATA"),"D",8,0)+", ";
                  m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("CNOME"))+" "+CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("NOME")),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL((CPLib.eqr(Cursor_tmp_imp_filae.GetString("SESSO"),"M")?"1":"2"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("NAPROV"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(0,"N",1,0)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL("ITALIA","C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("NACITTA")),"C",30,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
                  if (m_Ctx.IsSharedTemp("personbo")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                    throw new RoutineException();
                  }
                } // End If
              } // End If
            } // End If
          } // End If
          /* Case tmp_imp_filae->INVIO = '1' or tmp_imp_filae->INVIO = '4' */
          if (CPLib.eqr(Cursor_tmp_imp_filae.GetString("INVIO"),"1") || CPLib.eqr(Cursor_tmp_imp_filae.GetString("INVIO"),"4")) {
            /* Case tmp_imp_filae->COINT='3' and tmp_imp_filae->TIPO <> '98' */
            if (CPLib.eqr(Cursor_tmp_imp_filae.GetString("COINT"),"3") && CPLib.ne(Cursor_tmp_imp_filae.GetString("TIPO"),"98")) {
              /* _rapporto := '' */
              _rapporto = "";
              // * --- Read from aederig
              m_cServer = m_Ctx.GetServer("aederig");
              m_cPhName = m_Ctx.GetPhName("aederig");
              m_cSql = "";
              m_cSql = m_cSql+"AFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("IDFILE"),"C",15,0,m_cServer),m_cServer,Cursor_tmp_imp_filae.GetString("IDFILE"));
              m_cSql = m_cSql+" and APROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("NPROG"),"C",25,0,m_cServer),m_cServer,Cursor_tmp_imp_filae.GetString("NPROG"));
              if (m_Ctx.IsSharedTemp("aederig")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select RAPPORTO from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _rapporto = Read_Cursor.GetString("RAPPORTO");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on aederig into routine tipofile returns two or more records. This item should return only a record.");
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
                /* _rapporto := Strtran(_ragsoc," ","") */
                _rapporto = CPLib.Strtran(_ragsoc," ","");
                /* _rapporto := Strtran(_rapporto,"-","") */
                _rapporto = CPLib.Strtran(_rapporto,"-","");
                /* _rapporto := Strtran(_rapporto,".","") */
                _rapporto = CPLib.Strtran(_rapporto,".","");
                /* _rapporto := Left(_rapporto,15)+LibreriaMit.UniqueId() */
                _rapporto = CPLib.Left(_rapporto,15)+LibreriaMit.UniqueId();
                /* _prog := Utilities.GetAutonumber("PRGAEDELEG\'"+LRTrim(gAzienda)+"'",'',10) */
                _prog = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGAEDELEG\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
                // * --- Insert into aederig
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aederig");
                m_cPhName = m_Ctx.GetPhName("aederig");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "insert into "+m_cPhName+" (";
                m_cSql = m_cSql+GetFieldsName_05D47BC0(m_Ctx);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_connes,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("NPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_imp_filae.GetDate("ADATA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_prog,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("TIPO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("COINT"),"?",0,0,m_cServer)+", ";
                if (m_Ctx.IsSharedTemp("aederig")) {
                  m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                }
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aederig",true);
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
                // * --- Write into aederig
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aederig");
                m_cPhName = m_Ctx.GetPhName("aederig");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "Update "+m_cPhName+" set ";
                m_cSql = m_cSql+"CONNESINT = "+CPLib.ToSQL(_connes,"C",16,0,m_cServer)+", ";
                m_cSql = m_cSql+"ASPEDITO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                m_cSql = m_cSql+"ADATA = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetDate("ADATA"),"D",8,0)+", ";
                m_cSql = m_cSql+"APROG = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("NPROG"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"AFILE = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("IDFILE"),"C",15,0,m_cServer)+", ";
                m_cSql = m_cSql+"IDRIF = "+CPLib.ToSQL(LibreriaMit.UniqueId(),"C",10,0,m_cServer)+", ";
                m_cSql = m_cSql+"TIPOAG = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("TIPO"),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"COINT = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("COINT"),"C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aederig",false);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer),m_cServer,_rapporto)+"";
                if (m_Ctx.IsSharedTemp("aederig")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
              /* gMsgImp := "Elaborazione Delega: " + _rapporto // Messaggio Import */
              gMsgImp = "Elaborazione Delega: "+_rapporto;
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* If not(Empty(tmp_imp_filae->CDATA)) */
              if ( ! (CPLib.Empty(Cursor_tmp_imp_filae.GetDate("CDATA")))) {
                // * --- Write into aederig
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aederig");
                m_cPhName = m_Ctx.GetPhName("aederig");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "Update "+m_cPhName+" set ";
                m_cSql = m_cSql+"CDATA = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetDate("CDATA"),"D",8,0)+", ";
                m_cSql = m_cSql+"CPROG = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("NPROG"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"CFILE = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("IDFILE"),"C",15,0,m_cServer)+", ";
                m_cSql = m_cSql+"TIPOAG = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("TIPO"),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"COINT = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("COINT"),"C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aederig",false);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer),m_cServer,_rapporto)+"";
                if (m_Ctx.IsSharedTemp("aederig")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
              /* cNumDel := cNumDel + 1 */
              cNumDel = CPLib.Round(cNumDel+1,0);
              /* Case tmp_imp_filae->COINT='3' and tmp_imp_filae->TIPO = '98' */
            } else if (CPLib.eqr(Cursor_tmp_imp_filae.GetString("COINT"),"3") && CPLib.eqr(Cursor_tmp_imp_filae.GetString("TIPO"),"98")) {
              /* _prog := '' */
              _prog = "";
              // * --- Read from aeoprig
              m_cServer = m_Ctx.GetServer("aeoprig");
              m_cPhName = m_Ctx.GetPhName("aeoprig");
              m_cSql = "";
              m_cSql = m_cSql+"AFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("IDFILE"),"C",15,0,m_cServer),m_cServer,Cursor_tmp_imp_filae.GetString("IDFILE"));
              m_cSql = m_cSql+" and APROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("NPROG"),"C",25,0,m_cServer),m_cServer,Cursor_tmp_imp_filae.GetString("NPROG"));
              if (m_Ctx.IsSharedTemp("aeoprig")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select IDBASE from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _rapporto = Read_Cursor.GetString("IDBASE");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on aeoprig into routine tipofile returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _rapporto = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(LRTrim(_prog)) */
              if (CPLib.Empty(CPLib.LRTrim(_prog))) {
                /* _prog := Utilities.GetAutonumber("PRGAEOPEXTR\'"+LRTrim(gAzienda)+"'",'',10) */
                _prog = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGAEOPEXTR\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
                // * --- Insert into aeoprig
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aeoprig");
                m_cPhName = m_Ctx.GetPhName("aeoprig");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "insert into "+m_cPhName+" (";
                m_cSql = m_cSql+GetFieldsName_05B53808(m_Ctx);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(_prog,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_connes,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("NPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_imp_filae.GetDate("ADATA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
                if (m_Ctx.IsSharedTemp("aeoprig")) {
                  m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                }
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aeoprig",true);
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
                // * --- Write into aeoprig
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aeoprig");
                m_cPhName = m_Ctx.GetPhName("aeoprig");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "Update "+m_cPhName+" set ";
                m_cSql = m_cSql+"CONNESINT = "+CPLib.ToSQL(_connes,"C",16,0,m_cServer)+", ";
                m_cSql = m_cSql+"ASPEDITO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                m_cSql = m_cSql+"ADATA = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetDate("ADATA"),"D",8,0)+", ";
                m_cSql = m_cSql+"APROG = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("NPROG"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"AFILE = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("IDFILE"),"C",15,0,m_cServer)+", ";
                m_cSql = m_cSql+"IDRIF = "+CPLib.ToSQL(LibreriaMit.UniqueId(),"C",10,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aeoprig",false);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_prog,"?",0,0,m_cServer),m_cServer,_prog)+"";
                if (m_Ctx.IsSharedTemp("aeoprig")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
              /* gMsgImp := "Elaborazione Op. Extrconto: " + _prog // Messaggio Import */
              gMsgImp = "Elaborazione Op. Extrconto: "+_prog;
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* cNumOXC := cNumOXC + 1 */
              cNumOXC = CPLib.Round(cNumOXC+1,0);
              /* Case tmp_imp_filae->TIPO = '98' */
            } else if (CPLib.eqr(Cursor_tmp_imp_filae.GetString("TIPO"),"98")) {
              /* _prog := '' */
              _prog = "";
              // * --- Read from aeoprig
              m_cServer = m_Ctx.GetServer("aeoprig");
              m_cPhName = m_Ctx.GetPhName("aeoprig");
              m_cSql = "";
              m_cSql = m_cSql+"AFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("IDFILE"),"C",15,0,m_cServer),m_cServer,Cursor_tmp_imp_filae.GetString("IDFILE"));
              m_cSql = m_cSql+" and APROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("NPROG"),"C",25,0,m_cServer),m_cServer,Cursor_tmp_imp_filae.GetString("NPROG"));
              if (m_Ctx.IsSharedTemp("aeoprig")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select IDBASE from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _rapporto = Read_Cursor.GetString("IDBASE");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on aeoprig into routine tipofile returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _rapporto = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(LRTrim(_prog)) */
              if (CPLib.Empty(CPLib.LRTrim(_prog))) {
                /* _prog := Utilities.GetAutonumber("PRGAEOPEXTR\'"+LRTrim(gAzienda)+"'",'',10) */
                _prog = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGAEOPEXTR\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
                // * --- Insert into aeoprig
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aeoprig");
                m_cPhName = m_Ctx.GetPhName("aeoprig");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "insert into "+m_cPhName+" (";
                m_cSql = m_cSql+GetFieldsName_059C9B08(m_Ctx);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(_prog,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_connes,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("NPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_imp_filae.GetDate("ADATA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
                if (m_Ctx.IsSharedTemp("aeoprig")) {
                  m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                }
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aeoprig",true);
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
                // * --- Write into aeoprig
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aeoprig");
                m_cPhName = m_Ctx.GetPhName("aeoprig");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "Update "+m_cPhName+" set ";
                m_cSql = m_cSql+"CONNESINT = "+CPLib.ToSQL(_connes,"C",16,0,m_cServer)+", ";
                m_cSql = m_cSql+"ASPEDITO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                m_cSql = m_cSql+"ADATA = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetDate("ADATA"),"D",8,0)+", ";
                m_cSql = m_cSql+"APROG = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("NPROG"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"AFILE = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("IDFILE"),"C",15,0,m_cServer)+", ";
                m_cSql = m_cSql+"IDRIF = "+CPLib.ToSQL(LibreriaMit.UniqueId(),"C",10,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aeoprig",false);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_prog,"?",0,0,m_cServer),m_cServer,_prog)+"";
                if (m_Ctx.IsSharedTemp("aeoprig")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
              /* gMsgImp := "Elaborazione Op. Extrconto: " + _prog // Messaggio Import */
              gMsgImp = "Elaborazione Op. Extrconto: "+_prog;
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* cNumOXC := cNumOXC + 1 */
              cNumOXC = CPLib.Round(cNumOXC+1,0);
            } else { // Otherwise
              /* _rapporto := '' */
              _rapporto = "";
              /* _numriga := 0 */
              _numriga = CPLib.Round(0,0);
              // * --- Read from aerighe
              m_cServer = m_Ctx.GetServer("aerighe");
              m_cPhName = m_Ctx.GetPhName("aerighe");
              m_cSql = "";
              m_cSql = m_cSql+"AFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("IDFILE"),"C",15,0,m_cServer),m_cServer,Cursor_tmp_imp_filae.GetString("IDFILE"));
              m_cSql = m_cSql+" and APROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("NPROG"),"C",25,0,m_cServer),m_cServer,Cursor_tmp_imp_filae.GetString("NPROG"));
              if (m_Ctx.IsSharedTemp("aerighe")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select RAPPORTO,CPROWNUM from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _rapporto = Read_Cursor.GetString("RAPPORTO");
                _numriga = CPLib.Round(Read_Cursor.GetDouble("CPROWNUM"),0);
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on aerighe into routine tipofile returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _rapporto = "";
                _numriga = 0;
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(LRTrim(_rapporto)) */
              if (CPLib.Empty(CPLib.LRTrim(_rapporto))) {
                /* nProgImp := Utilities.GetAutonumber("PROGAET\'"+LRTrim(gAzienda)+"'",0,15) */
                nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGAET\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
                /* _rapporto := LRTrim(w_prefrap)+Utilities.GetAutonumber("PRGRAPFAGE\'"+LRTrim(gAzienda)+"'",'',10) */
                _rapporto = CPLib.LRTrim(w_prefrap)+Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGRAPFAGE\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
                /* gMsgImp := 'Sto inserendo in anagrafe tributaria il rapporto '+LRTrim(_rapporto) // Messaggio Import */
                gMsgImp = "Sto inserendo in anagrafe tributaria il rapporto "+CPLib.LRTrim(_rapporto);
                m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                // * --- Insert into aetesta
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aetesta");
                m_cPhName = m_Ctx.GetPhName("aetesta");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "insert into "+m_cPhName+" (";
                m_cSql = m_cSql+GetFieldsName_05BC8808(m_Ctx);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("TIPO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("COINT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("E","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
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
                  throw new RoutineException();
                }
                // * --- Insert into tmp_rapportipd
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_rapportipd");
                m_cPhName = m_Ctx.GetPhName("tmp_rapportipd");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "insert into "+m_cPhName+" (";
                m_cSql = m_cSql+GetFieldsName_061AEFE8(m_Ctx);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                if (m_Ctx.IsSharedTemp("tmp_rapportipd")) {
                  m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                }
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_rapportipd",true);
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
                /* nProgImp2 := Utilities.GetAutonumber("PROGAER\'"+LRTrim(gAzienda)+"'",0,15) */
                nProgImp2 = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGAER\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
                /* cID := LibreriaMit.UniqueId() */
                cID = LibreriaMit.UniqueId();
                // * --- Insert into aerighe
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aerighe");
                m_cPhName = m_Ctx.GetPhName("aerighe");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "insert into "+m_cPhName+" (";
                m_cSql = m_cSql+GetFieldsName_05920378(m_Ctx);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull(_connes,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("NPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_imp_filae.GetDate("ADATA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp2,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cID,"?",0,0,m_cServer)+", ";
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
                  throw new RoutineException();
                }
              } else { // Else
                /* gMsgImp := 'Sto aggiornando in anagrafe tributaria il rapporto '+LRTrim(_rapporto) // Messaggio Import */
                gMsgImp = "Sto aggiornando in anagrafe tributaria il rapporto "+CPLib.LRTrim(_rapporto);
                m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                // * --- Write into aetesta
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aetesta");
                m_cPhName = m_Ctx.GetPhName("aetesta");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "Update "+m_cPhName+" set ";
                m_cSql = m_cSql+"TIPOAG = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("TIPO"),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"COINT = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("COINT"),"C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aetesta",false);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer),m_cServer,_rapporto)+"";
                if (m_Ctx.IsSharedTemp("aetesta")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
                // * --- Write into aerighe
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aerighe");
                m_cPhName = m_Ctx.GetPhName("aerighe");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "Update "+m_cPhName+" set ";
                m_cSql = m_cSql+"CONNESINT = "+CPLib.ToSQLNull(_connes,"C",16,0,m_cServer)+", ";
                m_cSql = m_cSql+"ASPEDITO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                m_cSql = m_cSql+"ADATA = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetDate("ADATA"),"D",8,0)+", ";
                m_cSql = m_cSql+"APROG = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("NPROG"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"AFILE = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("IDFILE"),"C",15,0,m_cServer)+", ";
                m_cSql = m_cSql+"IDRIF = "+CPLib.ToSQL(LibreriaMit.UniqueId(),"C",10,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer),m_cServer,_rapporto)+"";
                m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_numriga,"?",0,0,m_cServer),m_cServer,_numriga)+"";
                if (m_Ctx.IsSharedTemp("aerighe")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
              /* gMsgImp := "Elaborazione Rapporto: " + _rapporto // Messaggio Import */
              gMsgImp = "Elaborazione Rapporto: "+_rapporto;
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* If not(Empty(tmp_imp_filae->CDATA)) */
              if ( ! (CPLib.Empty(Cursor_tmp_imp_filae.GetDate("CDATA")))) {
                // * --- Write into aerighe
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aerighe");
                m_cPhName = m_Ctx.GetPhName("aerighe");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "Update "+m_cPhName+" set ";
                m_cSql = m_cSql+"CDATA = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetDate("CDATA"),"D",8,0)+", ";
                m_cSql = m_cSql+"CPROG = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("NPROG"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"CFILE = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("IDFILE"),"C",15,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer),m_cServer,_rapporto)+"";
                m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(1,"?",0,0,m_cServer),m_cServer,1)+"";
                if (m_Ctx.IsSharedTemp("aerighe")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
              /* cNumRap := cNumRap + 1 */
              cNumRap = CPLib.Round(cNumRap+1,0);
            } // End Case
            /* Case tmp_imp_filae->INVIO = '2' or tmp_imp_filae->INVIO = '5' */
          } else if (CPLib.eqr(Cursor_tmp_imp_filae.GetString("INVIO"),"2") || CPLib.eqr(Cursor_tmp_imp_filae.GetString("INVIO"),"5")) {
            /* If tmp_imp_filae->COINT = '3' and tmp_imp_filae->TIPO <> '98' */
            if (CPLib.eqr(Cursor_tmp_imp_filae.GetString("COINT"),"3") && CPLib.ne(Cursor_tmp_imp_filae.GetString("TIPO"),"98")) {
              // * --- Read from aederig
              m_cServer = m_Ctx.GetServer("aederig");
              m_cPhName = m_Ctx.GetPhName("aederig");
              m_cSql = "";
              m_cSql = m_cSql+"AFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("OLDID"),"C",15,0,m_cServer),m_cServer,Cursor_tmp_imp_filae.GetString("OLDID"));
              m_cSql = m_cSql+" and APROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("OLDPROG"),"C",25,0,m_cServer),m_cServer,Cursor_tmp_imp_filae.GetString("OLDPROG"));
              if (m_Ctx.IsSharedTemp("aederig")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select IDBASE from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _prog = Read_Cursor.GetString("IDBASE");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on aederig into routine tipofile returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _prog = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(LRTrim(_prog)) */
              if (CPLib.Empty(CPLib.LRTrim(_prog))) {
                /* gMsgProc := _startmsg + gMsgProc + 'DELEGHE - File '+ LRTrim(tmp_imp_filae->OLDID)+' - Prog. '+LRTrim(tmp_imp_filae->OLDPROG)+' - Mancano i dati  di Apertura' // Messaggio */
                gMsgProc = _startmsg+gMsgProc+"DELEGHE - File "+CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("OLDID"))+" - Prog. "+CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("OLDPROG"))+" - Mancano i dati  di Apertura";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              } else { // Else
                // * --- Insert into tmp_rapportipd
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_rapportipd");
                m_cPhName = m_Ctx.GetPhName("tmp_rapportipd");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "insert into "+m_cPhName+" (";
                m_cSql = m_cSql+GetFieldsName_05B0F248(m_Ctx);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                if (m_Ctx.IsSharedTemp("tmp_rapportipd")) {
                  m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                }
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_rapportipd",true);
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
                // * --- Write into aederig
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aederig");
                m_cPhName = m_Ctx.GetPhName("aederig");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "Update "+m_cPhName+" set ";
                m_cSql = m_cSql+"CSPEDITO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                m_cSql = m_cSql+"CDATA = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetDate("CDATA"),"D",8,0)+", ";
                m_cSql = m_cSql+"CPROG = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("NPROG"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"CFILE = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("IDFILE"),"C",15,0,m_cServer)+", ";
                m_cSql = m_cSql+"CONNESINT = "+CPLib.ToSQL(_connes,"C",16,0,m_cServer)+", ";
                m_cSql = m_cSql+"TIPOAG = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("TIPO"),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"COINT = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("COINT"),"C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aederig",false);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_prog,"?",0,0,m_cServer),m_cServer,_prog)+"";
                if (m_Ctx.IsSharedTemp("aederig")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
              /* cNumDel := cNumDel + 1 */
              cNumDel = CPLib.Round(cNumDel+1,0);
            } else { // Else
              // * --- Read from aerighe
              m_cServer = m_Ctx.GetServer("aerighe");
              m_cPhName = m_Ctx.GetPhName("aerighe");
              m_cSql = "";
              m_cSql = m_cSql+"AFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("OLDID"),"C",15,0,m_cServer),m_cServer,Cursor_tmp_imp_filae.GetString("OLDID"));
              m_cSql = m_cSql+" and APROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("OLDPROG"),"C",25,0,m_cServer),m_cServer,Cursor_tmp_imp_filae.GetString("OLDPROG"));
              if (m_Ctx.IsSharedTemp("aerighe")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select RAPPORTO,CPROWNUM from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _rapporto = Read_Cursor.GetString("RAPPORTO");
                _numrig = CPLib.Round(Read_Cursor.GetDouble("CPROWNUM"),0);
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on aerighe into routine tipofile returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _rapporto = "";
                _numrig = 0;
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(LRTrim(_rapporto)) */
              if (CPLib.Empty(CPLib.LRTrim(_rapporto))) {
                /* gMsgProc := _startmsg + gMsgProc + 'RAPPORTI - File '+ LRTrim(tmp_imp_filae->OLDID)+' - Prog. '+LRTrim(tmp_imp_filae->OLDPROG)+' - Mancano i dati  di Apertura' // Messaggio */
                gMsgProc = _startmsg+gMsgProc+"RAPPORTI - File "+CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("OLDID"))+" - Prog. "+CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("OLDPROG"))+" - Mancano i dati  di Apertura";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              } else { // Else
                // * --- Insert into tmp_rapportipd
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_rapportipd");
                m_cPhName = m_Ctx.GetPhName("tmp_rapportipd");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "insert into "+m_cPhName+" (";
                m_cSql = m_cSql+GetFieldsName_05BB5A38(m_Ctx);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                if (m_Ctx.IsSharedTemp("tmp_rapportipd")) {
                  m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                }
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_rapportipd",true);
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
                // * --- Write into aerighe
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aerighe");
                m_cPhName = m_Ctx.GetPhName("aerighe");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "Update "+m_cPhName+" set ";
                m_cSql = m_cSql+"CSPEDITO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                m_cSql = m_cSql+"CDATA = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetDate("CDATA"),"D",8,0)+", ";
                m_cSql = m_cSql+"CPROG = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("NPROG"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"CFILE = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("IDFILE"),"C",15,0,m_cServer)+", ";
                m_cSql = m_cSql+"CONNESINT = "+CPLib.ToSQLNull(_connes,"C",16,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer),m_cServer,_rapporto)+"";
                m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_numrig,"?",0,0,m_cServer),m_cServer,_numrig)+"";
                if (m_Ctx.IsSharedTemp("aerighe")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
              /* cNumRap := cNumRap + 1 */
              cNumRap = CPLib.Round(cNumRap+1,0);
            } // End If
            /* Case tmp_imp_filae->INVIO = '3' or tmp_imp_filae->INVIO = '6' */
          } else if (CPLib.eqr(Cursor_tmp_imp_filae.GetString("INVIO"),"3") || CPLib.eqr(Cursor_tmp_imp_filae.GetString("INVIO"),"6")) {
            /* Case tmp_imp_filae->COINT='3' and tmp_imp_filae->TIPO <> '98' */
            if (CPLib.eqr(Cursor_tmp_imp_filae.GetString("COINT"),"3") && CPLib.ne(Cursor_tmp_imp_filae.GetString("TIPO"),"98")) {
              /* Case tmp_imp_filae->COINT='3' and tmp_imp_filae->TIPO = '98' */
            } else if (CPLib.eqr(Cursor_tmp_imp_filae.GetString("COINT"),"3") && CPLib.eqr(Cursor_tmp_imp_filae.GetString("TIPO"),"98")) {
            } else { // Otherwise
              /* Case tmp_imp_filae->PERIODO="200600" */
              if (CPLib.eqr(Cursor_tmp_imp_filae.GetString("PERIODO"),"200600")) {
                /* _dtret := CharToDate('20061231') // Data Rettifica */
                _dtret = CPLib.CharToDate("20061231");
                /* Case tmp_imp_filae->PERIODO="200700" */
              } else if (CPLib.eqr(Cursor_tmp_imp_filae.GetString("PERIODO"),"200700")) {
                /* _dtret := CharToDate('20070430') // Data Rettifica */
                _dtret = CPLib.CharToDate("20070430");
              } else { // Otherwise
                /* _dtret := arfn_finemese(CharToDate(Left(tmp_imp_filae->PERIODO,6)+'01')) // Data Rettifica */
                _dtret = arfn_finemeseR.Make(m_Ctx,this).Run(CPLib.CharToDate(CPLib.Left(Cursor_tmp_imp_filae.GetString("PERIODO"),6)+"01"));
              } // End Case
              /* If LRTrim(tmp_imp_filae->TIPOOP)='RETTIFICA' */
              if (CPLib.eqr(CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("TIPOOP")),"RETTIFICA")) {
                /* _friga := 0 */
                _friga = CPLib.Round(0,0);
                /* _frappo := '' */
                _frappo = "";
                // * --- Read from aerighe
                m_cServer = m_Ctx.GetServer("aerighe");
                m_cPhName = m_Ctx.GetPhName("aerighe");
                m_cSql = "";
                m_cSql = m_cSql+"APROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("OLDPROG"),"C",25,0,m_cServer),m_cServer,Cursor_tmp_imp_filae.GetString("OLDPROG"));
                m_cSql = m_cSql+" and AFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("OLDID"),"C",15,0,m_cServer),m_cServer,Cursor_tmp_imp_filae.GetString("OLDID"));
                if (m_Ctx.IsSharedTemp("aerighe")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select CPROWNUM,RAPPORTO from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _friga = CPLib.Round(Read_Cursor.GetDouble("CPROWNUM"),0);
                  _frappo = Read_Cursor.GetString("RAPPORTO");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on aerighe into routine tipofile returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _friga = 0;
                  _frappo = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If _friga = 0 */
                if (CPLib.eqr(_friga,0)) {
                  /* _friga := 0 */
                  _friga = CPLib.Round(0,0);
                  /* _frappo := '' */
                  _frappo = "";
                  // * --- Read from aerighe
                  m_cServer = m_Ctx.GetServer("aerighe");
                  m_cPhName = m_Ctx.GetPhName("aerighe");
                  m_cSql = "";
                  m_cSql = m_cSql+"CPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("OLDPROG"),"C",25,0,m_cServer),m_cServer,Cursor_tmp_imp_filae.GetString("OLDPROG"));
                  m_cSql = m_cSql+" and CFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("OLDID"),"C",15,0,m_cServer),m_cServer,Cursor_tmp_imp_filae.GetString("OLDID"));
                  if (m_Ctx.IsSharedTemp("aerighe")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select CPROWNUM,RAPPORTO from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _friga = CPLib.Round(Read_Cursor.GetDouble("CPROWNUM"),0);
                    _frappo = Read_Cursor.GetString("RAPPORTO");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on aerighe into routine tipofile returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _friga = 0;
                    _frappo = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* If _friga <> 0 */
                  if (CPLib.ne(_friga,0)) {
                    // * --- Write into aerighe
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("aerighe");
                    m_cPhName = m_Ctx.GetPhName("aerighe");
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = "Update "+m_cPhName+" set ";
                    m_cSql = m_cSql+"CONNESINT = "+CPLib.ToSQLNull(_connes,"C",16,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CSPEDITO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                    m_cSql = m_cSql+"CDTPRE = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetDate("ADATA"),"D",8,0)+", ";
                    m_cSql = m_cSql+"CDATA = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetDate("ADATA"),"D",8,0)+", ";
                    m_cSql = m_cSql+"CPROG = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("NPROG"),"C",25,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CFILE = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("IDFILE"),"C",15,0,m_cServer)+", ";
                    m_cSql = m_cSql+"COLDPROG = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("OLDPROG"),"C",25,0,m_cServer)+", ";
                    m_cSql = m_cSql+"COLDFILE = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("OLDID"),"C",15,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CDATARET = "+CPLib.ToSQL(_dtret,"D",8,0)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_frappo,"?",0,0,m_cServer),m_cServer,_frappo)+"";
                    m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_friga,"?",0,0,m_cServer),m_cServer,_friga)+"";
                    if (m_Ctx.IsSharedTemp("aerighe")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                    m_Sql.CompleteTransaction();
                    m_cLastMsgError = m_Sql.TransactionErrorMessage();
                    if (CPLib.ne(m_cLastMsgError,"")) {
                      m_bError = true;
                      throw new RoutineException();
                    }
                    // * --- Write into aetesta
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("aetesta");
                    m_cPhName = m_Ctx.GetPhName("aetesta");
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = "Update "+m_cPhName+" set ";
                    m_cSql = m_cSql+"TIPOAG = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("TIPO"),"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"COINT = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("COINT"),"C",1,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aetesta",false);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_frappo,"?",0,0,m_cServer),m_cServer,_frappo)+"";
                    if (m_Ctx.IsSharedTemp("aetesta")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                    m_Sql.CompleteTransaction();
                    m_cLastMsgError = m_Sql.TransactionErrorMessage();
                    if (CPLib.ne(m_cLastMsgError,"")) {
                      m_bError = true;
                      throw new RoutineException();
                    }
                  } else { // Else
                    /* gMsgProc := gMsgProc + 'Rilevati errori nel file '+_filename+' ! Non trovato rapporto corrispondente' + NL */
                    gMsgProc = gMsgProc+"Rilevati errori nel file "+_filename+" ! Non trovato rapporto corrispondente"+"\n";
                    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                  } // End If
                } else { // Else
                  // * --- Select from aerighe
                  m_cServer = m_Ctx.GetServer("aerighe");
                  m_cPhName = m_Ctx.GetPhName("aerighe");
                  if (Cursor_aerighe!=null)
                    Cursor_aerighe.Close();
                  Cursor_aerighe = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_frappo,"?",0,0,m_cServer, m_oParameters),m_cServer,_frappo)+"  and  CPROWNUM="+CPSql.SQLValueAdapter(CPLib.ToSQL(_friga,"?",0,0,m_cServer, m_oParameters),m_cServer,_friga)+" "+")"+(m_Ctx.IsSharedTemp("aerighe")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_aerighe.Eof())) {
                    /* If Empty(aerighe->CPROG) or (aerighe->APROG = aerighe->CPROG and aerighe->AFILE = aerighe->CFILE) */
                    if (CPLib.Empty(Cursor_aerighe.GetString("CPROG")) || (CPLib.eqr(Cursor_aerighe.GetString("APROG"),Cursor_aerighe.GetString("CPROG")) && CPLib.eqr(Cursor_aerighe.GetString("AFILE"),Cursor_aerighe.GetString("CFILE")))) {
                      // * --- Write into aerighe
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("aerighe");
                      m_cPhName = m_Ctx.GetPhName("aerighe");
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = "Update "+m_cPhName+" set ";
                      m_cSql = m_cSql+"CDATA = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetDate("CDATA"),"D",8,0)+", ";
                      m_cSql = m_cSql+"CPROG = "+CPLib.ToSQL((CPLib.Empty(Cursor_tmp_imp_filae.GetDate("CDATA"))?"":Cursor_tmp_imp_filae.GetString("NPROG")),"C",25,0,m_cServer)+", ";
                      m_cSql = m_cSql+"CFILE = "+CPLib.ToSQL((CPLib.Empty(Cursor_tmp_imp_filae.GetDate("CDATA"))?"":Cursor_tmp_imp_filae.GetString("IDFILE")),"C",15,0,m_cServer)+", ";
                      m_cSql = m_cSql+"CSPEDITO = "+CPLib.ToSQL((CPLib.Empty(Cursor_tmp_imp_filae.GetDate("CDATA"))?0:1),"N",1,0)+", ";
                      m_cSql = m_cSql+"COLDPROG = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("OLDPROG"),"C",25,0,m_cServer)+", ";
                      m_cSql = m_cSql+"COLDFILE = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("OLDID"),"C",15,0,m_cServer)+", ";
                      m_cSql = m_cSql+"CDATARET = "+CPLib.ToSQL(_dtret,"D",8,0)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_frappo,"?",0,0,m_cServer),m_cServer,_frappo)+"";
                      m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_friga,"?",0,0,m_cServer),m_cServer,_friga)+"";
                      if (m_Ctx.IsSharedTemp("aerighe")) {
                        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                      }
                      m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                      m_Sql.CompleteTransaction();
                      m_cLastMsgError = m_Sql.TransactionErrorMessage();
                      if (CPLib.ne(m_cLastMsgError,"")) {
                        m_bError = true;
                        throw new RoutineException();
                      }
                    } // End If
                    // * --- Write into aerighe
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("aerighe");
                    m_cPhName = m_Ctx.GetPhName("aerighe");
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = "Update "+m_cPhName+" set ";
                    m_cSql = m_cSql+"CONNESINT = "+CPLib.ToSQLNull(_connes,"C",16,0,m_cServer)+", ";
                    m_cSql = m_cSql+"ASPEDITO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                    m_cSql = m_cSql+"ADTPRE = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetDate("ADATA"),"D",8,0)+", ";
                    m_cSql = m_cSql+"ADATA = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetDate("ADATA"),"D",8,0)+", ";
                    m_cSql = m_cSql+"APROG = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("NPROG"),"C",25,0,m_cServer)+", ";
                    m_cSql = m_cSql+"AFILE = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("IDFILE"),"C",15,0,m_cServer)+", ";
                    m_cSql = m_cSql+"AOLDPROG = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("OLDPROG"),"C",25,0,m_cServer)+", ";
                    m_cSql = m_cSql+"AOLDFILE = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("OLDID"),"C",15,0,m_cServer)+", ";
                    m_cSql = m_cSql+"ADATARET = "+CPLib.ToSQL(_dtret,"D",8,0)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_frappo,"?",0,0,m_cServer),m_cServer,_frappo)+"";
                    m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_friga,"?",0,0,m_cServer),m_cServer,_friga)+"";
                    if (m_Ctx.IsSharedTemp("aerighe")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                    m_Sql.CompleteTransaction();
                    m_cLastMsgError = m_Sql.TransactionErrorMessage();
                    if (CPLib.ne(m_cLastMsgError,"")) {
                      m_bError = true;
                      throw new RoutineException();
                    }
                    Cursor_aerighe.Next();
                  }
                  m_cConnectivityError = Cursor_aerighe.ErrorMessage();
                  Cursor_aerighe.Close();
                  // * --- End Select
                  // * --- Write into aetesta
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("aetesta");
                  m_cPhName = m_Ctx.GetPhName("aetesta");
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = "Update "+m_cPhName+" set ";
                  m_cSql = m_cSql+"TIPOAG = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("TIPO"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"COINT = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("COINT"),"C",1,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aetesta",false);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_frappo,"?",0,0,m_cServer),m_cServer,_frappo)+"";
                  if (m_Ctx.IsSharedTemp("aetesta")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                    throw new RoutineException();
                  }
                } // End If
              } else { // Else
                /* _friga := 0 */
                _friga = CPLib.Round(0,0);
                /* _frappo := '' */
                _frappo = "";
                // * --- Read from aerighe
                m_cServer = m_Ctx.GetServer("aerighe");
                m_cPhName = m_Ctx.GetPhName("aerighe");
                m_cSql = "";
                m_cSql = m_cSql+"APROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("OLDPROG"),"C",25,0,m_cServer),m_cServer,Cursor_tmp_imp_filae.GetString("OLDPROG"));
                m_cSql = m_cSql+" and AFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("OLDID"),"C",15,0,m_cServer),m_cServer,Cursor_tmp_imp_filae.GetString("OLDID"));
                if (m_Ctx.IsSharedTemp("aerighe")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select CPROWNUM,RAPPORTO from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _friga = CPLib.Round(Read_Cursor.GetDouble("CPROWNUM"),0);
                  _frappo = Read_Cursor.GetString("RAPPORTO");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on aerighe into routine tipofile returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _friga = 0;
                  _frappo = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If _friga = 0 */
                if (CPLib.eqr(_friga,0)) {
                  /* _friga := 0 */
                  _friga = CPLib.Round(0,0);
                  /* _frappo := '' */
                  _frappo = "";
                  // * --- Read from aerighe
                  m_cServer = m_Ctx.GetServer("aerighe");
                  m_cPhName = m_Ctx.GetPhName("aerighe");
                  m_cSql = "";
                  m_cSql = m_cSql+"CPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("OLDPROG"),"C",25,0,m_cServer),m_cServer,Cursor_tmp_imp_filae.GetString("OLDPROG"));
                  m_cSql = m_cSql+" and CFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("OLDID"),"C",15,0,m_cServer),m_cServer,Cursor_tmp_imp_filae.GetString("OLDID"));
                  if (m_Ctx.IsSharedTemp("aerighe")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select CPROWNUM,RAPPORTO from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _friga = CPLib.Round(Read_Cursor.GetDouble("CPROWNUM"),0);
                    _frappo = Read_Cursor.GetString("RAPPORTO");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on aerighe into routine tipofile returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _friga = 0;
                    _frappo = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* If _friga <> 0 */
                  if (CPLib.ne(_friga,0)) {
                    /* _tipoag := '' */
                    _tipoag = "";
                    /* _coint := '' */
                    _coint = "";
                    // * --- Read from aetesta
                    m_cServer = m_Ctx.GetServer("aetesta");
                    m_cPhName = m_Ctx.GetPhName("aetesta");
                    m_cSql = "";
                    m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_aerighe.GetString("RAPPORTO"));
                    if (m_Ctx.IsSharedTemp("aetesta")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select TIPOAG,COINT from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _tipoag = Read_Cursor.GetString("TIPOAG");
                      _coint = Read_Cursor.GetString("COINT");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on aetesta into routine tipofile returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _tipoag = "";
                      _coint = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                    /* cInfProg1 := Utilities.GetAutonumber("PRGSTORAE\'"+LRTrim(gAzienda)+"'",'',10) */
                    cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGSTORAE\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
                    /* _idbase := LibreriaMit.UniqueId() */
                    _idbase = LibreriaMit.UniqueId();
                    // * --- Insert into aestor
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("aestor");
                    m_cPhName = m_Ctx.GetPhName("aestor");
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = "insert into "+m_cPhName+" (";
                    m_cSql = m_cSql+GetFieldsName_05C96478(m_Ctx);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_idbase,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDouble("ASPEDITO"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("ADATA"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("APROG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("AFILE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("ADATARET"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDouble("CSPEDITO"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("CDATA"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("CPROG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("CFILE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("CDATARET"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("IDRIF"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tipoag,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_coint,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("NOCODFISC"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDouble("PROGAER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDouble("CPROWNUM"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("ADTPRE"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("CDTPRE"),"?",0,0)+", ";
                    if (m_Ctx.IsSharedTemp("aestor")) {
                      m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                    }
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aestor",true);
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
                    // * --- Insert into aecanc
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("aecanc");
                    m_cPhName = m_Ctx.GetPhName("aecanc");
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = "insert into "+m_cPhName+" (";
                    m_cSql = m_cSql+GetFieldsName_059249F8(m_Ctx);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDouble("ASPEDITO"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("ADATA"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("APROG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("AFILE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_dtret,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDouble("CSPEDITO"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("CDATA"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("CPROG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("CFILE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_dtret,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("IDRIF"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tipoag,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_coint,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("NOCODFISC"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_idbase,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_imp_filae.GetDate("CDATA"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
                    if (m_Ctx.IsSharedTemp("aecanc")) {
                      m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                    }
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aecanc",true);
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
                    // * --- Write into aerighe
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("aerighe");
                    m_cPhName = m_Ctx.GetPhName("aerighe");
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = "Update "+m_cPhName+" set ";
                    m_cSql = m_cSql+"CDATA = "+CPLib.ToSQL(CPLib.NullDate(),"D",8,0)+", ";
                    m_cSql = m_cSql+"CPROG = "+CPLib.ToSQL("","C",25,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CFILE = "+CPLib.ToSQL("","C",15,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CSPEDITO = "+CPLib.ToSQL(0,"N",1,0)+", ";
                    m_cSql = m_cSql+"COLDPROG = "+CPLib.ToSQL("","C",25,0,m_cServer)+", ";
                    m_cSql = m_cSql+"COLDFILE = "+CPLib.ToSQL("","C",15,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CDATARET = "+CPLib.ToSQL(CPLib.NullDate(),"D",8,0)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_frappo,"?",0,0,m_cServer),m_cServer,_frappo)+"";
                    m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_friga,"?",0,0,m_cServer),m_cServer,_friga)+"";
                    if (m_Ctx.IsSharedTemp("aerighe")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                    m_Sql.CompleteTransaction();
                    m_cLastMsgError = m_Sql.TransactionErrorMessage();
                    if (CPLib.ne(m_cLastMsgError,"")) {
                      m_bError = true;
                      throw new RoutineException();
                    }
                  } else { // Else
                    /* gMsgProc := gMsgProc + 'Rilevati errori nel file '+_filename+' ! Non trovato rapporto corrispondente' + NL */
                    gMsgProc = gMsgProc+"Rilevati errori nel file "+_filename+" ! Non trovato rapporto corrispondente"+"\n";
                    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                  } // End If
                } else { // Else
                  // * --- Select from aerighe
                  m_cServer = m_Ctx.GetServer("aerighe");
                  m_cPhName = m_Ctx.GetPhName("aerighe");
                  if (Cursor_aerighe!=null)
                    Cursor_aerighe.Close();
                  Cursor_aerighe = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_frappo,"?",0,0,m_cServer, m_oParameters),m_cServer,_frappo)+"  and  CPROWNUM="+CPSql.SQLValueAdapter(CPLib.ToSQL(_friga,"?",0,0,m_cServer, m_oParameters),m_cServer,_friga)+" "+")"+(m_Ctx.IsSharedTemp("aerighe")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_aerighe.Eof())) {
                    /* _tipoag := '' */
                    _tipoag = "";
                    /* _coint := '' */
                    _coint = "";
                    // * --- Read from aetesta
                    m_cServer = m_Ctx.GetServer("aetesta");
                    m_cPhName = m_Ctx.GetPhName("aetesta");
                    m_cSql = "";
                    m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_aerighe.GetString("RAPPORTO"));
                    if (m_Ctx.IsSharedTemp("aetesta")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select TIPOAG,COINT from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _tipoag = Read_Cursor.GetString("TIPOAG");
                      _coint = Read_Cursor.GetString("COINT");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on aetesta into routine tipofile returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _tipoag = "";
                      _coint = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                    /* cInfProg1 := Utilities.GetAutonumber("PRGSTORAE\'"+LRTrim(gAzienda)+"'",'',10) */
                    cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGSTORAE\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
                    /* _idbase := LibreriaMit.UniqueId() */
                    _idbase = LibreriaMit.UniqueId();
                    // * --- Insert into aestor
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("aestor");
                    m_cPhName = m_Ctx.GetPhName("aestor");
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = "insert into "+m_cPhName+" (";
                    m_cSql = m_cSql+GetFieldsName_05CCAE28(m_Ctx);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_idbase,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDouble("ASPEDITO"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("ADATA"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("APROG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("AFILE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("ADATARET"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDouble("CSPEDITO"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("CDATA"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("CPROG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("CFILE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("CDATARET"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("IDRIF"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tipoag,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_coint,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("NOCODFISC"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDouble("PROGAER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDouble("CPROWNUM"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("ADTPRE"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("CDTPRE"),"?",0,0)+", ";
                    if (m_Ctx.IsSharedTemp("aestor")) {
                      m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                    }
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aestor",true);
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
                    // * --- Insert into aecanc
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("aecanc");
                    m_cPhName = m_Ctx.GetPhName("aecanc");
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = "insert into "+m_cPhName+" (";
                    m_cSql = m_cSql+GetFieldsName_059E0AD8(m_Ctx);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDouble("ASPEDITO"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("ADATA"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("APROG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("AFILE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_dtret,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDouble("CSPEDITO"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("CDATA"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("CPROG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("CFILE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("CDATARET"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("IDRIF"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tipoag,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_coint,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("NOCODFISC"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_idbase,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_imp_filae.GetDate("CDATA"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("A","?",0,0,m_cServer)+", ";
                    if (m_Ctx.IsSharedTemp("aecanc")) {
                      m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                    }
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aecanc",true);
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
                    Cursor_aerighe.Next();
                  }
                  m_cConnectivityError = Cursor_aerighe.ErrorMessage();
                  Cursor_aerighe.Close();
                  // * --- End Select
                  // * --- Write into aerighe
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("aerighe");
                  m_cPhName = m_Ctx.GetPhName("aerighe");
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = "Update "+m_cPhName+" set ";
                  m_cSql = m_cSql+"ADATA = "+CPLib.ToSQL(CPLib.NullDate(),"D",8,0)+", ";
                  m_cSql = m_cSql+"APROG = "+CPLib.ToSQL("","C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"AFILE = "+CPLib.ToSQL("","C",15,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ASPEDITO = "+CPLib.ToSQL(0,"N",1,0)+", ";
                  m_cSql = m_cSql+"AOLDPROG = "+CPLib.ToSQL("","C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"AOLDFILE = "+CPLib.ToSQL("","C",15,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ADATARET = "+CPLib.ToSQL(CPLib.NullDate(),"D",8,0)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_frappo,"?",0,0,m_cServer),m_cServer,_frappo)+"";
                  m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_friga,"?",0,0,m_cServer),m_cServer,_friga)+"";
                  if (m_Ctx.IsSharedTemp("aerighe")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
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
            } // End Case
          } // End Case
          Cursor_tmp_imp_filae.Next();
        }
        m_cConnectivityError = Cursor_tmp_imp_filae.ErrorMessage();
        Cursor_tmp_imp_filae.Close();
        // * --- End Select
        // commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
      } catch(Exception l_exeption) {
        if (l_exeption instanceof Stop)
          throw l_exeption;
        /* gMsgProc := gMsgProc + 'Rilevati errori nel file '+_filename+' ! Ricrearlo e rieseguire import dei dati' + NL+'Tipo Errore:'+m_Sql.TransactionErrorMessage()+NL */
        gMsgProc = gMsgProc+"Rilevati errori nel file "+_filename+" ! Ricrearlo e rieseguire import dei dati"+"\n"+"Tipo Errore:"+m_Sql.TransactionErrorMessage()+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
        // rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
      }
      if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry05A40CE8status,0)) {
        m_Sql.SetTransactionStatus(nTry05A40CE8status,cTry05A40CE8msg);
      }
    } finally {
      try {
        if (Cursor_tmp_imp_filae!=null)
          Cursor_tmp_imp_filae.Close();
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
    }
  }
  void Page_4() throws Exception {
    CPResultSet Cursor_tmp_rapportipd=null;
    CPResultSet Cursor_aetesta=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_aerighe=null;
    try {
      /* Ricostruisce Archivio AUI */
      // begin transaction
      m_Sql.RequireTransaction();
      double nTry05992048status;
      nTry05992048status = m_Sql.GetTransactionStatus();
      String cTry05992048msg;
      cTry05992048msg = m_Sql.TransactionErrorMessage();
      try {
        // * --- Select from tmp_rapportipd
        m_cServer = m_Ctx.GetServer("tmp_rapportipd");
        m_cPhName = m_Ctx.GetPhName("tmp_rapportipd");
        if (Cursor_tmp_rapportipd!=null)
          Cursor_tmp_rapportipd.Close();
        Cursor_tmp_rapportipd = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select RAPPORTO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_rapportipd")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_tmp_rapportipd.Eof())) {
          // * --- Select from aetesta
          m_cServer = m_Ctx.GetServer("aetesta");
          m_cPhName = m_Ctx.GetPhName("aetesta");
          if (Cursor_aetesta!=null)
            Cursor_aetesta.Close();
          Cursor_aetesta = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_tmp_rapportipd.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("aetesta")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_aetesta.Eof())) {
            // * --- Read from anarapbo
            m_cServer = m_Ctx.GetServer("anarapbo");
            m_cPhName = m_Ctx.GetPhName("anarapbo");
            m_cSql = "";
            m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aetesta.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_aetesta.GetString("RAPPORTO"));
            if (m_Ctx.IsSharedTemp("anarapbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select RAPPORTO from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _rapporto = Read_Cursor.GetString("RAPPORTO");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on anarapbo into routine tipofile returns two or more records. This item should return only a record.");
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
              /* If aetesta->COINT='1' */
              if (CPLib.eqr(Cursor_aetesta.GetString("COINT"),"1")) {
                /* _tiprap := '1' */
                _tiprap = "1";
              } else { // Else
                /* _tiprap := '' */
                _tiprap = "";
              } // End If
              /* gMsgImp := 'Sto inserendo in archivio AUI il rapporto '+LRTrim(aetesta->RAPPORTO) // Messaggio Import */
              gMsgImp = "Sto inserendo in archivio AUI il rapporto "+CPLib.LRTrim(Cursor_aetesta.GetString("RAPPORTO"));
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* nProgImp := Utilities.GetAutonumber("PRGIMPRAP\'"+LRTrim(gAzienda)+"'",0,15) */
              nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPRAP\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
              // * --- Insert into anarapbo
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("anarapbo");
              m_cPhName = m_Ctx.GetPhName("anarapbo");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = "insert into "+m_cPhName+" (";
              m_cSql = m_cSql+GetFieldsName_05A628D8(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aetesta.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aetesta.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(w_codval,"?",0,0,m_cServer)+", ";
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
                Read_Cursor = m_Sql.Query(m_cServer,"select RAGSOC,SESSO from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _ragsoc = Read_Cursor.GetString("RAGSOC");
                  cSESSO = Read_Cursor.GetString("SESSO");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on personbo into routine tipofile returns two or more records. This item should return only a record.");
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
                /* If _tiprap='' */
                if (CPLib.eqr(_tiprap,"")) {
                  /* If Len(LRTrim(cSESSO)) > 0 */
                  if (CPLib.gt(CPLib.Len(CPLib.LRTrim(cSESSO)),0)) {
                    /* _tiprap := '0' */
                    _tiprap = "0";
                  } else { // Else
                    /* _tiprap := '2' */
                    _tiprap = "2";
                  } // End If
                } // End If
                // * --- Write into anarapbo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("anarapbo");
                m_cPhName = m_Ctx.GetPhName("anarapbo");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "Update "+m_cPhName+" set ";
                m_cSql = m_cSql+"DESCRAP = "+CPLib.ToSQL(CPLib.Left(_ragsoc,50),"C",50,0,m_cServer)+", ";
                m_cSql = m_cSql+"TIPORAP = "+CPLib.ToSQLNull(_tiprap,"C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"anarapbo",false);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_aerighe.GetString("RAPPORTO"))+"";
                if (m_Ctx.IsSharedTemp("anarapbo")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
                /* If not(Empty(aerighe->ADATA)) */
                if ( ! (CPLib.Empty(Cursor_aerighe.GetDate("ADATA")))) {
                  /* cInfProg1 := Utilities.GetAutonumber("PRGINFO1\'"+LRTrim(gAzienda)+"'",'',10) */
                  cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
                  /* cInfProg2 := Utilities.GetAutonumber("PRGINFO2\'"+LRTrim(gAzienda)+"'",'',11) */
                  cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
                  /* nProgImp := Utilities.GetAutonumber("PRGIMPINF\'"+LRTrim(gAzienda)+"'",0,15) */
                  nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINF\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
                  /* cProgA := cInfProg2 */
                  cProgA = cInfProg2;
                  // * --- Insert into rapopebo
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("rapopebo");
                  m_cPhName = m_Ctx.GetPhName("rapopebo");
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = "insert into "+m_cPhName+" (";
                  m_cSql = m_cSql+GetFieldsName_061B2018(m_Ctx);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("ADATA"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("ADATA"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull("23","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_aetesta.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull("0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_aerighe.GetDate("ADATA"))+cInfProg2+"0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_aerighe.GetDate("ADATA")),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0,m_cServer)+", ";
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
                    throw new RoutineException();
                  }
                } // End If
                /* If not(Empty(aerighe->CDATA)) */
                if ( ! (CPLib.Empty(Cursor_aerighe.GetDate("CDATA")))) {
                  /* cInfProg1 := Utilities.GetAutonumber("PRGINFO1\'"+LRTrim(gAzienda)+"'",'',10) */
                  cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
                  /* cInfProg2 := Utilities.GetAutonumber("PRGINFO2\'"+LRTrim(gAzienda)+"'",'',11) */
                  cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
                  /* nProgImp := Utilities.GetAutonumber("PRGIMPINF\'"+LRTrim(gAzienda)+"'",0,15) */
                  nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINF\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
                  /* cProgC := cInfProg2 */
                  cProgC = cInfProg2;
                  // * --- Insert into rapopebo
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("rapopebo");
                  m_cPhName = m_Ctx.GetPhName("rapopebo");
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = "insert into "+m_cPhName+" (";
                  m_cSql = m_cSql+GetFieldsName_05CE4B18(m_Ctx);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("CDATA"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("CDATA"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull("26","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_aetesta.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull("0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_aerighe.GetDate("CDATA"))+cInfProg2+"0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_aerighe.GetDate("CDATA")),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0,m_cServer)+", ";
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
                    throw new RoutineException();
                  }
                } // End If
                /* nProgImp := Utilities.GetAutonumber("PRGIMPSOG\'"+LRTrim(gAzienda)+"'",0,15) */
                nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPSOG\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
                /* cID := LibreriaMit.UniqueId() */
                cID = LibreriaMit.UniqueId();
                // * --- Insert into intestbo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("intestbo");
                m_cPhName = m_Ctx.GetPhName("intestbo");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "insert into "+m_cPhName+" (";
                m_cSql = m_cSql+GetFieldsName_05CC9448(m_Ctx);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aetesta.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_aerighe.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("ADATA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("CDATA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cProgA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cProgC,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_aerighe.GetDate("ADATA"))+cProgA+"O","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cID,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_numriga,"?",0,0)+", ";
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
                /* _numriga := _numriga + 1 */
                _numriga = CPLib.Round(_numriga+1,0);
                Cursor_aerighe.Next();
              }
              m_cConnectivityError = Cursor_aerighe.ErrorMessage();
              Cursor_aerighe.Close();
              // * --- End Select
            } else { // Else
              /* cProgA := '' */
              cProgA = "";
              /* cProgC := '' */
              cProgC = "";
              // * --- Select from aerighe
              m_cServer = m_Ctx.GetServer("aerighe");
              m_cPhName = m_Ctx.GetPhName("aerighe");
              if (Cursor_aerighe!=null)
                Cursor_aerighe.Close();
              Cursor_aerighe = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_aetesta.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("aerighe")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM ",m_cServer,m_Ctx,true));
              while ( ! (Cursor_aerighe.Eof())) {
                /* cSESSO := '' */
                cSESSO = "";
                /* If not(Empty(aerighe->CDATA)) */
                if ( ! (CPLib.Empty(Cursor_aerighe.GetDate("CDATA")))) {
                  /* cInfProg1 := Utilities.GetAutonumber("PRGINFO1\'"+LRTrim(gAzienda)+"'",'',10) */
                  cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
                  /* cInfProg2 := Utilities.GetAutonumber("PRGINFO2\'"+LRTrim(gAzienda)+"'",'',11) */
                  cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
                  /* nProgImp := Utilities.GetAutonumber("PRGIMPINF\'"+LRTrim(gAzienda)+"'",0,15) */
                  nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINF\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
                  /* cProgC := cInfProg2 */
                  cProgC = cInfProg2;
                  // * --- Insert into rapopebo
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("rapopebo");
                  m_cPhName = m_Ctx.GetPhName("rapopebo");
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = "insert into "+m_cPhName+" (";
                  m_cSql = m_cSql+GetFieldsName_05B50418(m_Ctx);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("CDATA"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("CDATA"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull("26","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_aetesta.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull("0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_aerighe.GetDate("CDATA"))+cInfProg2+"0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_aerighe.GetDate("CDATA")),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0,m_cServer)+", ";
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
                    throw new RoutineException();
                  }
                } // End If
                // * --- Write into intestbo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("intestbo");
                m_cPhName = m_Ctx.GetPhName("intestbo");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "Update "+m_cPhName+" set ";
                m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(Cursor_aerighe.GetDate("CDATA"),"D",8,0)+", ";
                m_cSql = m_cSql+"NUMPROG2 = "+CPLib.ToSQL(cProgC,"C",11,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer),m_cServer,_rapporto)+"";
                m_cSql = m_cSql+" and CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQLNull(Cursor_aerighe.GetString("CONNESINT"),"?",0,0,m_cServer),m_cServer,Cursor_aerighe.GetString("CONNESINT"))+"";
                if (m_Ctx.IsSharedTemp("intestbo")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
                Cursor_aerighe.Next();
              }
              m_cConnectivityError = Cursor_aerighe.ErrorMessage();
              Cursor_aerighe.Close();
              // * --- End Select
            } // End If
            Cursor_aetesta.Next();
          }
          m_cConnectivityError = Cursor_aetesta.ErrorMessage();
          Cursor_aetesta.Close();
          // * --- End Select
          Cursor_tmp_rapportipd.Next();
        }
        m_cConnectivityError = Cursor_tmp_rapportipd.ErrorMessage();
        Cursor_tmp_rapportipd.Close();
        // * --- End Select
        // commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
      } catch(Exception l_exeption) {
        if (l_exeption instanceof Stop)
          throw l_exeption;
        /* gMsgProc := gMsgProc + 'Rilevati errori nela creazione dei rapporti.Tipo Errore:'+m_Sql.TransactionErrorMessage()+NL */
        gMsgProc = gMsgProc+"Rilevati errori nela creazione dei rapporti.Tipo Errore:"+m_Sql.TransactionErrorMessage()+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
        // rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
      }
      if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry05992048status,0)) {
        m_Sql.SetTransactionStatus(nTry05992048status,cTry05992048msg);
      }
    } finally {
      try {
        if (Cursor_tmp_rapportipd!=null)
          Cursor_tmp_rapportipd.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
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
    }
  }
  void Page_5() throws Exception {
    CPResultSet Cursor_tmp_rapportipd=null;
    CPResultSet Cursor_aetesta=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_aerighe=null;
    try {
      /* Ricostruisce Archivio AGE */
      // begin transaction
      m_Sql.RequireTransaction();
      double nTry05BBC818status;
      nTry05BBC818status = m_Sql.GetTransactionStatus();
      String cTry05BBC818msg;
      cTry05BBC818msg = m_Sql.TransactionErrorMessage();
      try {
        // * --- Select from tmp_rapportipd
        m_cServer = m_Ctx.GetServer("tmp_rapportipd");
        m_cPhName = m_Ctx.GetPhName("tmp_rapportipd");
        if (Cursor_tmp_rapportipd!=null)
          Cursor_tmp_rapportipd.Close();
        Cursor_tmp_rapportipd = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select RAPPORTO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_rapportipd")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_tmp_rapportipd.Eof())) {
          /* _rapporto := '' */
          _rapporto = "";
          // * --- Select from aetesta
          m_cServer = m_Ctx.GetServer("aetesta");
          m_cPhName = m_Ctx.GetPhName("aetesta");
          if (Cursor_aetesta!=null)
            Cursor_aetesta.Close();
          Cursor_aetesta = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_tmp_rapportipd.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("aetesta")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_aetesta.Eof())) {
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
            Read_Cursor = m_Sql.Query(m_cServer,"select RAPPORTO from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _rapporto = Read_Cursor.GetString("RAPPORTO");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on jnarapbo into routine tipofile returns two or more records. This item should return only a record.");
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
              /* If aetesta->COINT='1' */
              if (CPLib.eqr(Cursor_aetesta.GetString("COINT"),"1")) {
                /* _tiprap := '1' */
                _tiprap = "1";
              } else { // Else
                /* _tiprap := '' */
                _tiprap = "";
              } // End If
              /* gMsgImp := 'Sto inserendo in archivio AGE il rapporto '+LRTrim(aetesta->RAPPORTO) // Messaggio Import */
              gMsgImp = "Sto inserendo in archivio AGE il rapporto "+CPLib.LRTrim(Cursor_aetesta.GetString("RAPPORTO"));
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* nProgImp := Utilities.GetAutonumber("PRGIMPRAPAGE\'"+LRTrim(gAzienda)+"'",0,15) */
              nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPRAPAGE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
              // * --- Insert into jnarapbo
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("jnarapbo");
              m_cPhName = m_Ctx.GetPhName("jnarapbo");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = "insert into "+m_cPhName+" (";
              m_cSql = m_cSql+GetFieldsName_061AFA38(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aetesta.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aetesta.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(w_codval,"?",0,0,m_cServer)+", ";
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
                Read_Cursor = m_Sql.Query(m_cServer,"select RAGSOC,SESSO from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _ragsoc = Read_Cursor.GetString("RAGSOC");
                  cSESSO = Read_Cursor.GetString("SESSO");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on personbo into routine tipofile returns two or more records. This item should return only a record.");
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
                /* If _tiprap='' */
                if (CPLib.eqr(_tiprap,"")) {
                  /* If Len(LRTrim(cSESSO)) > 0 */
                  if (CPLib.gt(CPLib.Len(CPLib.LRTrim(cSESSO)),0)) {
                    /* _tiprap := '0' */
                    _tiprap = "0";
                  } else { // Else
                    /* _tiprap := '2' */
                    _tiprap = "2";
                  } // End If
                } // End If
                // * --- Write into jnarapbo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("jnarapbo");
                m_cPhName = m_Ctx.GetPhName("jnarapbo");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "Update "+m_cPhName+" set ";
                m_cSql = m_cSql+"DESCRAP = "+CPLib.ToSQL(CPLib.Left(_ragsoc,50),"C",50,0,m_cServer)+", ";
                m_cSql = m_cSql+"TIPORAP = "+CPLib.ToSQL(_tiprap,"C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jnarapbo",false);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_aerighe.GetString("RAPPORTO"))+"";
                if (m_Ctx.IsSharedTemp("jnarapbo")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
                /* If not(Empty(aerighe->ADATA)) */
                if ( ! (CPLib.Empty(Cursor_aerighe.GetDate("ADATA")))) {
                  /* cInfProg1 := Utilities.GetAutonumber("PRGINFAGE1\'"+LRTrim(gAzienda)+"'",'',10) */
                  cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFAGE1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
                  /* cInfProg2 := Utilities.GetAutonumber("PRGINFAGE2\'"+LRTrim(gAzienda)+"'",'',11) */
                  cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFAGE2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
                  /* nProgImp := Utilities.GetAutonumber("PRGIMPINFAGE\'"+LRTrim(gAzienda)+"'",0,15) */
                  nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINFAGE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
                  /* cProgA := cInfProg2 */
                  cProgA = cInfProg2;
                  // * --- Insert into japopebo
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("japopebo");
                  m_cPhName = m_Ctx.GetPhName("japopebo");
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = "insert into "+m_cPhName+" (";
                  m_cSql = m_cSql+GetFieldsName_0604F648(m_Ctx);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("ADATA"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("ADATA"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("23","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_aetesta.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_aerighe.GetDate("ADATA"))+cInfProg2+"0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_aerighe.GetDate("ADATA")),"?",0,0,m_cServer)+", ";
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
                  // * --- Insert into japopebo
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("japopebo");
                  m_cPhName = m_Ctx.GetPhName("japopebo");
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = "insert into "+m_cPhName+" (";
                  m_cSql = m_cSql+GetFieldsName_05BF4238(m_Ctx);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("CDATA"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("CDATA"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("26","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_aetesta.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_aerighe.GetDate("CDATA"))+cInfProg2+"0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_aerighe.GetDate("CDATA")),"?",0,0,m_cServer)+", ";
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
                /* nProgImp := Utilities.GetAutonumber("PRGIMPSOGAGE\'"+LRTrim(gAzienda)+"'",0,15) */
                nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPSOGAGE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
                /* cID := LibreriaMit.UniqueId() */
                cID = LibreriaMit.UniqueId();
                // * --- Insert into jntestbo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("jntestbo");
                m_cPhName = m_Ctx.GetPhName("jntestbo");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "insert into "+m_cPhName+" (";
                m_cSql = m_cSql+GetFieldsName_059C53C8(m_Ctx);
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
            } else { // Else
              /* cProgA := '' */
              cProgA = "";
              /* cProgC := '' */
              cProgC = "";
              // * --- Select from aerighe
              m_cServer = m_Ctx.GetServer("aerighe");
              m_cPhName = m_Ctx.GetPhName("aerighe");
              if (Cursor_aerighe!=null)
                Cursor_aerighe.Close();
              Cursor_aerighe = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_aetesta.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("aerighe")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM ",m_cServer,m_Ctx,true));
              while ( ! (Cursor_aerighe.Eof())) {
                /* cSESSO := '' */
                cSESSO = "";
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
                  // * --- Insert into japopebo
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("japopebo");
                  m_cPhName = m_Ctx.GetPhName("japopebo");
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = "insert into "+m_cPhName+" (";
                  m_cSql = m_cSql+GetFieldsName_061CCC58(m_Ctx);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("CDATA"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("CDATA"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("26","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_aetesta.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_aerighe.GetDate("CDATA"))+cInfProg2+"0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_aerighe.GetDate("CDATA")),"?",0,0,m_cServer)+", ";
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
                // * --- Write into jntestbo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("jntestbo");
                m_cPhName = m_Ctx.GetPhName("jntestbo");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "Update "+m_cPhName+" set ";
                m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(Cursor_aerighe.GetDate("CDATA"),"D",8,0)+", ";
                m_cSql = m_cSql+"NUMPROG2 = "+CPLib.ToSQL(cProgC,"C",11,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jntestbo",false);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer),m_cServer,_rapporto)+"";
                m_cSql = m_cSql+" and CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aerighe.GetString("CONNESINT"),"?",0,0,m_cServer),m_cServer,Cursor_aerighe.GetString("CONNESINT"))+"";
                if (m_Ctx.IsSharedTemp("jntestbo")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
                Cursor_aerighe.Next();
              }
              m_cConnectivityError = Cursor_aerighe.ErrorMessage();
              Cursor_aerighe.Close();
              // * --- End Select
            } // End If
            Cursor_aetesta.Next();
          }
          m_cConnectivityError = Cursor_aetesta.ErrorMessage();
          Cursor_aetesta.Close();
          // * --- End Select
          Cursor_tmp_rapportipd.Next();
        }
        m_cConnectivityError = Cursor_tmp_rapportipd.ErrorMessage();
        Cursor_tmp_rapportipd.Close();
        // * --- End Select
        // commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
      } catch(Exception l_exeption) {
        if (l_exeption instanceof Stop)
          throw l_exeption;
        /* gMsgProc := gMsgProc + 'Rilevati errori nela creazione dei rapporti.Tipo Errore:'+m_Sql.TransactionErrorMessage()+NL */
        gMsgProc = gMsgProc+"Rilevati errori nela creazione dei rapporti.Tipo Errore:"+m_Sql.TransactionErrorMessage()+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
        // rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
      }
      if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry05BBC818status,0)) {
        m_Sql.SetTransactionStatus(nTry05BBC818status,cTry05BBC818msg);
      }
    } finally {
      try {
        if (Cursor_tmp_rapportipd!=null)
          Cursor_tmp_rapportipd.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
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
    }
  }
  void Page_6() throws Exception {
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
      m_Sql.CompleteTransaction();
      m_cLastMsgError = m_Sql.TransactionErrorMessage();
      if (CPLib.ne(m_cLastMsgError,"")) {
        m_bError = true;
      }
      /* contanome := 0 */
      contanome = 0;
      /* While contanome<conteggio */
      while (CPLib.lt(contanome,conteggio)) {
        buffernomefile=lista[contanome];
        // * --- Insert into tmp_list_imprich
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_list_imprich");
        m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = "insert into "+m_cPhName+" (";
        m_cSql = m_cSql+GetFieldsName_05B55398(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(buffernomefile,"?",0,0,m_cServer)+", ";
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
  void _init_()  {
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
            com.zucchetti.sitepainter.EventHandler.notifyEvent("Run end",this,m_Ctx,specificEventsHandlers,allEventsHandlers);
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
      m_Caller.SetNumber("impzip","N",1,0,w_impzip);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static tipofileR Make(CPContext p_Ctx, Caller p_Caller) {
    return new tipofileR(p_Ctx, p_Caller);
  }
  public void Blank()  {
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
  // ENTITY_BATCHES: ,arfn_datefchar,arfn_finemese,arfn_fdatetime,arfn_delzero,
  public static final String i_InvokedRoutines = ",arfn_datefchar,arfn_finemese,arfn_fdatetime,arfn_delzero,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_05CA0FD8(CPContext p_Ctx)  {
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
  protected static String GetFieldsName_06222C38(CPContext p_Ctx)  {
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
  protected static String GetFieldsName_061A0718(CPContext p_Ctx)  {
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
  protected static String GetFieldsName_062099C8(CPContext p_Ctx)  {
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
  protected static String GetFieldsName_060118B0(CPContext p_Ctx)  {
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
  protected static String GetFieldsName_05C50818(CPContext p_Ctx)  {
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
  protected static String GetFieldsName_06008268(CPContext p_Ctx)  {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CFESTERO,";
    if (p_Ctx.IsSharedTemp("personbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_061298E0(CPContext p_Ctx)  {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"TIPINTER,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"CFESTERO,";
    if (p_Ctx.IsSharedTemp("personbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05FD53F8(CPContext p_Ctx)  {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CFESTERO,";
    if (p_Ctx.IsSharedTemp("personbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_061A7FF8(CPContext p_Ctx)  {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"TIPINTER,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"CFESTERO,";
    if (p_Ctx.IsSharedTemp("personbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05D47BC0(CPContext p_Ctx)  {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"ASPEDITO,";
    p_cSql = p_cSql+"APROG,";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+"IDRIF,";
    p_cSql = p_cSql+"AFILE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"COINT,";
    if (p_Ctx.IsSharedTemp("aederig")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aederig",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05B53808(CPContext p_Ctx)  {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"ASPEDITO,";
    p_cSql = p_cSql+"APROG,";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+"IDRIF,";
    p_cSql = p_cSql+"AFILE,";
    if (p_Ctx.IsSharedTemp("aeoprig")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aeoprig",true);
    return p_cSql;
  }
  protected static String GetFieldsName_059C9B08(CPContext p_Ctx)  {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"ASPEDITO,";
    p_cSql = p_cSql+"APROG,";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+"IDRIF,";
    p_cSql = p_cSql+"AFILE,";
    if (p_Ctx.IsSharedTemp("aeoprig")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aeoprig",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05BC8808(CPContext p_Ctx)  {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"RIFANA,";
    p_cSql = p_cSql+"PROGAET,";
    p_cSql = p_cSql+"FLGIMP,";
    if (p_Ctx.IsSharedTemp("aetesta")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aetesta",true);
    return p_cSql;
  }
  protected static String GetFieldsName_061AEFE8(CPContext p_Ctx)  {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    if (p_Ctx.IsSharedTemp("tmp_rapportipd")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_rapportipd",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05920378(CPContext p_Ctx)  {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"ASPEDITO,";
    p_cSql = p_cSql+"APROG,";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+"IDRIF,";
    p_cSql = p_cSql+"AFILE,";
    p_cSql = p_cSql+"PROGAER,";
    p_cSql = p_cSql+"IDBASE,";
    if (p_Ctx.IsSharedTemp("aerighe")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aerighe",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05B0F248(CPContext p_Ctx)  {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    if (p_Ctx.IsSharedTemp("tmp_rapportipd")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_rapportipd",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05BB5A38(CPContext p_Ctx)  {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    if (p_Ctx.IsSharedTemp("tmp_rapportipd")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_rapportipd",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05C96478(CPContext p_Ctx)  {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"ASPEDITO,";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+"APROG,";
    p_cSql = p_cSql+"AFILE,";
    p_cSql = p_cSql+"ADATARET,";
    p_cSql = p_cSql+"CSPEDITO,";
    p_cSql = p_cSql+"CDATA,";
    p_cSql = p_cSql+"CPROG,";
    p_cSql = p_cSql+"CFILE,";
    p_cSql = p_cSql+"CDATARET,";
    p_cSql = p_cSql+"IDRIF,";
    p_cSql = p_cSql+"RIFRIGA,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"NOCODFISC,";
    p_cSql = p_cSql+"PROGRES,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"ADTPRE,";
    p_cSql = p_cSql+"CDTPRE,";
    if (p_Ctx.IsSharedTemp("aestor")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aestor",true);
    return p_cSql;
  }
  protected static String GetFieldsName_059249F8(CPContext p_Ctx)  {
    String p_cSql = "";
    p_cSql = p_cSql+"PROGRES,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"ASPEDITO,";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+"APROG,";
    p_cSql = p_cSql+"AFILE,";
    p_cSql = p_cSql+"ADATARET,";
    p_cSql = p_cSql+"CSPEDITO,";
    p_cSql = p_cSql+"CDATA,";
    p_cSql = p_cSql+"CPROG,";
    p_cSql = p_cSql+"CFILE,";
    p_cSql = p_cSql+"CDATARET,";
    p_cSql = p_cSql+"IDRIF,";
    p_cSql = p_cSql+"RIFRIGA,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"NOCODFISC,";
    p_cSql = p_cSql+"RIFSTOR,";
    p_cSql = p_cSql+"DATARIF,";
    p_cSql = p_cSql+"TIPOCAN,";
    if (p_Ctx.IsSharedTemp("aecanc")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aecanc",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05CCAE28(CPContext p_Ctx)  {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"ASPEDITO,";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+"APROG,";
    p_cSql = p_cSql+"AFILE,";
    p_cSql = p_cSql+"ADATARET,";
    p_cSql = p_cSql+"CSPEDITO,";
    p_cSql = p_cSql+"CDATA,";
    p_cSql = p_cSql+"CPROG,";
    p_cSql = p_cSql+"CFILE,";
    p_cSql = p_cSql+"CDATARET,";
    p_cSql = p_cSql+"IDRIF,";
    p_cSql = p_cSql+"RIFRIGA,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"NOCODFISC,";
    p_cSql = p_cSql+"PROGRES,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"ADTPRE,";
    p_cSql = p_cSql+"CDTPRE,";
    if (p_Ctx.IsSharedTemp("aestor")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aestor",true);
    return p_cSql;
  }
  protected static String GetFieldsName_059E0AD8(CPContext p_Ctx)  {
    String p_cSql = "";
    p_cSql = p_cSql+"PROGRES,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"ASPEDITO,";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+"APROG,";
    p_cSql = p_cSql+"AFILE,";
    p_cSql = p_cSql+"ADATARET,";
    p_cSql = p_cSql+"CSPEDITO,";
    p_cSql = p_cSql+"CDATA,";
    p_cSql = p_cSql+"CPROG,";
    p_cSql = p_cSql+"CFILE,";
    p_cSql = p_cSql+"CDATARET,";
    p_cSql = p_cSql+"IDRIF,";
    p_cSql = p_cSql+"RIFRIGA,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"NOCODFISC,";
    p_cSql = p_cSql+"RIFSTOR,";
    p_cSql = p_cSql+"DATARIF,";
    p_cSql = p_cSql+"TIPOCAN,";
    if (p_Ctx.IsSharedTemp("aecanc")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aecanc",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05A628D8(CPContext p_Ctx)  {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"PRGIMPRAP,";
    p_cSql = p_cSql+"VALUTA,";
    if (p_Ctx.IsSharedTemp("anarapbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"anarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_061B2018(CPContext p_Ctx)  {
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
    if (p_Ctx.IsSharedTemp("rapopebo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05CE4B18(CPContext p_Ctx)  {
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
    if (p_Ctx.IsSharedTemp("rapopebo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05CC9448(CPContext p_Ctx)  {
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
    if (p_Ctx.IsSharedTemp("intestbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"intestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05B50418(CPContext p_Ctx)  {
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
    if (p_Ctx.IsSharedTemp("rapopebo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_061AFA38(CPContext p_Ctx)  {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"PRGIMPRAP,";
    p_cSql = p_cSql+"VALUTA,";
    if (p_Ctx.IsSharedTemp("jnarapbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"jnarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0604F648(CPContext p_Ctx)  {
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
  protected static String GetFieldsName_05BF4238(CPContext p_Ctx)  {
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
  protected static String GetFieldsName_059C53C8(CPContext p_Ctx)  {
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
    if (p_Ctx.IsSharedTemp("jntestbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"jntestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_061CCC58(CPContext p_Ctx)  {
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
  protected static String GetFieldsName_05B55398(CPContext p_Ctx)  {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    if (p_Ctx.IsSharedTemp("tmp_list_imprich")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_list_imprich",true);
    return p_cSql;
  }
}
