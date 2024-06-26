// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_chkdiana_oldR implements CallerWithObjs {
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
  public String m_cPhName_kersonbo;
  public String m_cServer_kersonbo;
  public String m_cPhName_knarapbo;
  public String m_cServer_knarapbo;
  public String m_cPhName_meneficfrz;
  public String m_cServer_meneficfrz;
  public String m_cPhName_meneficope;
  public String m_cServer_meneficope;
  public String m_cPhName_merzistifrz;
  public String m_cServer_merzistifrz;
  public String m_cPhName_merzistiope;
  public String m_cServer_merzistiope;
  public String m_cPhName_mlientifrz;
  public String m_cServer_mlientifrz;
  public String m_cPhName_mlientiope;
  public String m_cServer_mlientiope;
  public String m_cPhName_mogopebo;
  public String m_cServer_mogopebo;
  public String m_cPhName_mogopefbo;
  public String m_cServer_mogopefbo;
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
  public String m_cPhName_rapotit;
  public String m_cServer_rapotit;
  public String m_cPhName_sogopebo;
  public String m_cServer_sogopebo;
  public String m_cPhName_sogopefbo;
  public String m_cServer_sogopefbo;
  public String m_cPhName_terzistifrz;
  public String m_cServer_terzistifrz;
  public String m_cPhName_terzistiope;
  public String m_cServer_terzistiope;
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
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
  public String m_cPhName_xogopebo;
  public String m_cServer_xogopebo;
  public String m_cPhName_xogopefbo;
  public String m_cServer_xogopefbo;
  public String m_cPhName_xapopebo;
  public String m_cServer_xapopebo;
  public String m_cPhName_tipo1;
  public String m_cServer_tipo1;
  public String m_cPhName_tipo2_3;
  public String m_cServer_tipo2_3;
  public String m_cPhName_tipo4;
  public String m_cServer_tipo4;
  public String m_cPhName_tipo5;
  public String m_cServer_tipo5;
  public String m_cPhName_tipo6;
  public String m_cServer_tipo6;
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
  public String w_codinter;
  public String w_tipinter;
  public java.sql.Date w_DaData;
  public java.sql.Date w_AData;
  public String w_tipoarch;
  public String w_codage;
  public String w_flgope;
  public String w_flgfrz;
  public String w_flgint;
  public String w_flgrae;
  public String w_flgrap;
  public String w_tiprap;
  public String w_codcli;
  public String w_ragben;
  public String w_flgsto;
  public String w_flgchk;
  public String w_flgdel;
  public String gPathApp;
  public String gIntemediario;
  public String gUrlApp;
  public String gAzienda;
  public double gNumRec;
  public double gNumReg;
  public String gMsgImp;
  public String gMsgProc;
  public String gFlgWU;
  public String w_codcab;
  public String w_cabcod;
  public String w_desccit;
  public String w_citdesc;
  public String w_provin;
  public String w_provind;
  public String w_coddipe;
  public String _note;
  public String fhand;
  public String _nomefile;
  public String cNomeFile;
  public String cOnlyNomeFile;
  public String cNomeFileZip;
  public double nTotRec;
  public double nTotReg;
  public double nNumRec;
  public double _avanza;
  public String _codrif;
  public String w_cdadata;
  public String w_c_adata;
  public String w_cdadata_rap;
  public String w_c_adata_rap;
  public double _ctotale;
  public double _conta;
  public double _max;
  public double _min;
  public double _top;
  public double _bottom;
  public double _cicli;
  public double _contacilci;
  public String _flagrap;
  public double _ciclo;
  public String _ramate;
  public String _numsto;
  public double _oldrighe;
  public double _continua;
  public String _oldrap;
  public String _idereg;
  public String xStato;
  public double _conta1;
  public double _conta2;
  public double _conta4;
  public double _conta5;
  public double _conta6;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_chkdiana_oldR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_chkdiana_old",m_Caller);
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
    m_cPhName_kersonbo = p_ContextObject.GetPhName("kersonbo");
    m_cServer_kersonbo = p_ContextObject.GetServer("kersonbo");
    m_cPhName_knarapbo = p_ContextObject.GetPhName("knarapbo");
    m_cServer_knarapbo = p_ContextObject.GetServer("knarapbo");
    m_cPhName_meneficfrz = p_ContextObject.GetPhName("meneficfrz");
    m_cServer_meneficfrz = p_ContextObject.GetServer("meneficfrz");
    m_cPhName_meneficope = p_ContextObject.GetPhName("meneficope");
    m_cServer_meneficope = p_ContextObject.GetServer("meneficope");
    m_cPhName_merzistifrz = p_ContextObject.GetPhName("merzistifrz");
    m_cServer_merzistifrz = p_ContextObject.GetServer("merzistifrz");
    m_cPhName_merzistiope = p_ContextObject.GetPhName("merzistiope");
    m_cServer_merzistiope = p_ContextObject.GetServer("merzistiope");
    m_cPhName_mlientifrz = p_ContextObject.GetPhName("mlientifrz");
    m_cServer_mlientifrz = p_ContextObject.GetServer("mlientifrz");
    m_cPhName_mlientiope = p_ContextObject.GetPhName("mlientiope");
    m_cServer_mlientiope = p_ContextObject.GetServer("mlientiope");
    m_cPhName_mogopebo = p_ContextObject.GetPhName("mogopebo");
    m_cServer_mogopebo = p_ContextObject.GetServer("mogopebo");
    m_cPhName_mogopefbo = p_ContextObject.GetPhName("mogopefbo");
    m_cServer_mogopefbo = p_ContextObject.GetServer("mogopefbo");
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_rapopebo = p_ContextObject.GetPhName("rapopebo");
    m_cServer_rapopebo = p_ContextObject.GetServer("rapopebo");
    m_cPhName_rapotit = p_ContextObject.GetPhName("rapotit");
    m_cServer_rapotit = p_ContextObject.GetServer("rapotit");
    m_cPhName_sogopebo = p_ContextObject.GetPhName("sogopebo");
    m_cServer_sogopebo = p_ContextObject.GetServer("sogopebo");
    m_cPhName_sogopefbo = p_ContextObject.GetPhName("sogopefbo");
    m_cServer_sogopefbo = p_ContextObject.GetServer("sogopefbo");
    m_cPhName_terzistifrz = p_ContextObject.GetPhName("terzistifrz");
    m_cServer_terzistifrz = p_ContextObject.GetServer("terzistifrz");
    m_cPhName_terzistiope = p_ContextObject.GetPhName("terzistiope");
    m_cServer_terzistiope = p_ContextObject.GetServer("terzistiope");
    m_cPhName_wersonbo = p_ContextObject.GetPhName("wersonbo");
    m_cServer_wersonbo = p_ContextObject.GetServer("wersonbo");
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
    m_cPhName_xogopebo = p_ContextObject.GetPhName("xogopebo");
    m_cServer_xogopebo = p_ContextObject.GetServer("xogopebo");
    m_cPhName_xogopefbo = p_ContextObject.GetPhName("xogopefbo");
    m_cServer_xogopefbo = p_ContextObject.GetServer("xogopefbo");
    m_cPhName_xapopebo = p_ContextObject.GetPhName("xapopebo");
    m_cServer_xapopebo = p_ContextObject.GetServer("xapopebo");
    m_cPhName_tipo1 = p_ContextObject.GetPhName("tipo1");
    m_cServer_tipo1 = p_ContextObject.GetServer("tipo1");
    m_cPhName_tipo2_3 = p_ContextObject.GetPhName("tipo2_3");
    m_cServer_tipo2_3 = p_ContextObject.GetServer("tipo2_3");
    m_cPhName_tipo4 = p_ContextObject.GetPhName("tipo4");
    m_cServer_tipo4 = p_ContextObject.GetServer("tipo4");
    m_cPhName_tipo5 = p_ContextObject.GetPhName("tipo5");
    m_cServer_tipo5 = p_ContextObject.GetServer("tipo5");
    m_cPhName_tipo6 = p_ContextObject.GetPhName("tipo6");
    m_cServer_tipo6 = p_ContextObject.GetServer("tipo6");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("gNumRec",p_cVarName)) {
      return gNumRec;
    }
    if (CPLib.eqr("gNumReg",p_cVarName)) {
      return gNumReg;
    }
    if (CPLib.eqr("nTotRec",p_cVarName)) {
      return nTotRec;
    }
    if (CPLib.eqr("nTotReg",p_cVarName)) {
      return nTotReg;
    }
    if (CPLib.eqr("nNumRec",p_cVarName)) {
      return nNumRec;
    }
    if (CPLib.eqr("_avanza",p_cVarName)) {
      return _avanza;
    }
    if (CPLib.eqr("_ctotale",p_cVarName)) {
      return _ctotale;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      return _max;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      return _min;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      return _top;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      return _bottom;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
    }
    if (CPLib.eqr("_contacilci",p_cVarName)) {
      return _contacilci;
    }
    if (CPLib.eqr("_ciclo",p_cVarName)) {
      return _ciclo;
    }
    if (CPLib.eqr("_oldrighe",p_cVarName)) {
      return _oldrighe;
    }
    if (CPLib.eqr("_continua",p_cVarName)) {
      return _continua;
    }
    if (CPLib.eqr("_conta1",p_cVarName)) {
      return _conta1;
    }
    if (CPLib.eqr("_conta2",p_cVarName)) {
      return _conta2;
    }
    if (CPLib.eqr("_conta4",p_cVarName)) {
      return _conta4;
    }
    if (CPLib.eqr("_conta5",p_cVarName)) {
      return _conta5;
    }
    if (CPLib.eqr("_conta6",p_cVarName)) {
      return _conta6;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_chkdiana_old";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("codinter",p_cVarName)) {
      return w_codinter;
    }
    if (CPLib.eqr("tipinter",p_cVarName)) {
      return w_tipinter;
    }
    if (CPLib.eqr("tipoarch",p_cVarName)) {
      return w_tipoarch;
    }
    if (CPLib.eqr("codage",p_cVarName)) {
      return w_codage;
    }
    if (CPLib.eqr("flgope",p_cVarName)) {
      return w_flgope;
    }
    if (CPLib.eqr("flgfrz",p_cVarName)) {
      return w_flgfrz;
    }
    if (CPLib.eqr("flgint",p_cVarName)) {
      return w_flgint;
    }
    if (CPLib.eqr("flgrae",p_cVarName)) {
      return w_flgrae;
    }
    if (CPLib.eqr("flgrap",p_cVarName)) {
      return w_flgrap;
    }
    if (CPLib.eqr("tiprap",p_cVarName)) {
      return w_tiprap;
    }
    if (CPLib.eqr("codcli",p_cVarName)) {
      return w_codcli;
    }
    if (CPLib.eqr("ragben",p_cVarName)) {
      return w_ragben;
    }
    if (CPLib.eqr("flgsto",p_cVarName)) {
      return w_flgsto;
    }
    if (CPLib.eqr("flgchk",p_cVarName)) {
      return w_flgchk;
    }
    if (CPLib.eqr("flgdel",p_cVarName)) {
      return w_flgdel;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      return gIntemediario;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
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
    if (CPLib.eqr("gFlgWU",p_cVarName)) {
      return gFlgWU;
    }
    if (CPLib.eqr("codcab",p_cVarName)) {
      return w_codcab;
    }
    if (CPLib.eqr("cabcod",p_cVarName)) {
      return w_cabcod;
    }
    if (CPLib.eqr("desccit",p_cVarName)) {
      return w_desccit;
    }
    if (CPLib.eqr("citdesc",p_cVarName)) {
      return w_citdesc;
    }
    if (CPLib.eqr("provin",p_cVarName)) {
      return w_provin;
    }
    if (CPLib.eqr("provind",p_cVarName)) {
      return w_provind;
    }
    if (CPLib.eqr("coddipe",p_cVarName)) {
      return w_coddipe;
    }
    if (CPLib.eqr("_note",p_cVarName)) {
      return _note;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("_nomefile",p_cVarName)) {
      return _nomefile;
    }
    if (CPLib.eqr("cNomeFile",p_cVarName)) {
      return cNomeFile;
    }
    if (CPLib.eqr("cOnlyNomeFile",p_cVarName)) {
      return cOnlyNomeFile;
    }
    if (CPLib.eqr("cNomeFileZip",p_cVarName)) {
      return cNomeFileZip;
    }
    if (CPLib.eqr("_codrif",p_cVarName)) {
      return _codrif;
    }
    if (CPLib.eqr("cdadata",p_cVarName)) {
      return w_cdadata;
    }
    if (CPLib.eqr("c_adata",p_cVarName)) {
      return w_c_adata;
    }
    if (CPLib.eqr("cdadata_rap",p_cVarName)) {
      return w_cdadata_rap;
    }
    if (CPLib.eqr("c_adata_rap",p_cVarName)) {
      return w_c_adata_rap;
    }
    if (CPLib.eqr("_flagrap",p_cVarName)) {
      return _flagrap;
    }
    if (CPLib.eqr("_ramate",p_cVarName)) {
      return _ramate;
    }
    if (CPLib.eqr("_numsto",p_cVarName)) {
      return _numsto;
    }
    if (CPLib.eqr("_oldrap",p_cVarName)) {
      return _oldrap;
    }
    if (CPLib.eqr("_idereg",p_cVarName)) {
      return _idereg;
    }
    if (CPLib.eqr("xStato",p_cVarName)) {
      return xStato;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("DaData",p_cVarName)) {
      return w_DaData;
    }
    if (CPLib.eqr("AData",p_cVarName)) {
      return w_AData;
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
    if (CPLib.eqr("gNumRec",p_cVarName)) {
      gNumRec = value;
      return;
    }
    if (CPLib.eqr("gNumReg",p_cVarName)) {
      gNumReg = value;
      return;
    }
    if (CPLib.eqr("nTotRec",p_cVarName)) {
      nTotRec = value;
      return;
    }
    if (CPLib.eqr("nTotReg",p_cVarName)) {
      nTotReg = value;
      return;
    }
    if (CPLib.eqr("nNumRec",p_cVarName)) {
      nNumRec = value;
      return;
    }
    if (CPLib.eqr("_avanza",p_cVarName)) {
      _avanza = value;
      return;
    }
    if (CPLib.eqr("_ctotale",p_cVarName)) {
      _ctotale = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
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
    if (CPLib.eqr("_top",p_cVarName)) {
      _top = value;
      return;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      _bottom = value;
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
    if (CPLib.eqr("_ciclo",p_cVarName)) {
      _ciclo = value;
      return;
    }
    if (CPLib.eqr("_oldrighe",p_cVarName)) {
      _oldrighe = value;
      return;
    }
    if (CPLib.eqr("_continua",p_cVarName)) {
      _continua = value;
      return;
    }
    if (CPLib.eqr("_conta1",p_cVarName)) {
      _conta1 = value;
      return;
    }
    if (CPLib.eqr("_conta2",p_cVarName)) {
      _conta2 = value;
      return;
    }
    if (CPLib.eqr("_conta4",p_cVarName)) {
      _conta4 = value;
      return;
    }
    if (CPLib.eqr("_conta5",p_cVarName)) {
      _conta5 = value;
      return;
    }
    if (CPLib.eqr("_conta6",p_cVarName)) {
      _conta6 = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("codinter",p_cVarName)) {
      w_codinter = value;
      return;
    }
    if (CPLib.eqr("tipinter",p_cVarName)) {
      w_tipinter = value;
      return;
    }
    if (CPLib.eqr("tipoarch",p_cVarName)) {
      w_tipoarch = value;
      return;
    }
    if (CPLib.eqr("codage",p_cVarName)) {
      w_codage = value;
      return;
    }
    if (CPLib.eqr("flgope",p_cVarName)) {
      w_flgope = value;
      return;
    }
    if (CPLib.eqr("flgfrz",p_cVarName)) {
      w_flgfrz = value;
      return;
    }
    if (CPLib.eqr("flgint",p_cVarName)) {
      w_flgint = value;
      return;
    }
    if (CPLib.eqr("flgrae",p_cVarName)) {
      w_flgrae = value;
      return;
    }
    if (CPLib.eqr("flgrap",p_cVarName)) {
      w_flgrap = value;
      return;
    }
    if (CPLib.eqr("tiprap",p_cVarName)) {
      w_tiprap = value;
      return;
    }
    if (CPLib.eqr("codcli",p_cVarName)) {
      w_codcli = value;
      return;
    }
    if (CPLib.eqr("ragben",p_cVarName)) {
      w_ragben = value;
      return;
    }
    if (CPLib.eqr("flgsto",p_cVarName)) {
      w_flgsto = value;
      return;
    }
    if (CPLib.eqr("flgchk",p_cVarName)) {
      w_flgchk = value;
      return;
    }
    if (CPLib.eqr("flgdel",p_cVarName)) {
      w_flgdel = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      gIntemediario = value;
      return;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      gUrlApp = value;
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
    if (CPLib.eqr("gFlgWU",p_cVarName)) {
      gFlgWU = value;
      return;
    }
    if (CPLib.eqr("codcab",p_cVarName)) {
      w_codcab = value;
      return;
    }
    if (CPLib.eqr("cabcod",p_cVarName)) {
      w_cabcod = value;
      return;
    }
    if (CPLib.eqr("desccit",p_cVarName)) {
      w_desccit = value;
      return;
    }
    if (CPLib.eqr("citdesc",p_cVarName)) {
      w_citdesc = value;
      return;
    }
    if (CPLib.eqr("provin",p_cVarName)) {
      w_provin = value;
      return;
    }
    if (CPLib.eqr("provind",p_cVarName)) {
      w_provind = value;
      return;
    }
    if (CPLib.eqr("coddipe",p_cVarName)) {
      w_coddipe = value;
      return;
    }
    if (CPLib.eqr("_note",p_cVarName)) {
      _note = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("_nomefile",p_cVarName)) {
      _nomefile = value;
      return;
    }
    if (CPLib.eqr("cNomeFile",p_cVarName)) {
      cNomeFile = value;
      return;
    }
    if (CPLib.eqr("cOnlyNomeFile",p_cVarName)) {
      cOnlyNomeFile = value;
      return;
    }
    if (CPLib.eqr("cNomeFileZip",p_cVarName)) {
      cNomeFileZip = value;
      return;
    }
    if (CPLib.eqr("_codrif",p_cVarName)) {
      _codrif = value;
      return;
    }
    if (CPLib.eqr("cdadata",p_cVarName)) {
      w_cdadata = value;
      return;
    }
    if (CPLib.eqr("c_adata",p_cVarName)) {
      w_c_adata = value;
      return;
    }
    if (CPLib.eqr("cdadata_rap",p_cVarName)) {
      w_cdadata_rap = value;
      return;
    }
    if (CPLib.eqr("c_adata_rap",p_cVarName)) {
      w_c_adata_rap = value;
      return;
    }
    if (CPLib.eqr("_flagrap",p_cVarName)) {
      _flagrap = value;
      return;
    }
    if (CPLib.eqr("_ramate",p_cVarName)) {
      _ramate = value;
      return;
    }
    if (CPLib.eqr("_numsto",p_cVarName)) {
      _numsto = value;
      return;
    }
    if (CPLib.eqr("_oldrap",p_cVarName)) {
      _oldrap = value;
      return;
    }
    if (CPLib.eqr("_idereg",p_cVarName)) {
      _idereg = value;
      return;
    }
    if (CPLib.eqr("xStato",p_cVarName)) {
      xStato = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("DaData",p_cVarName)) {
      w_DaData = value;
      return;
    }
    if (CPLib.eqr("AData",p_cVarName)) {
      w_AData = value;
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
    /* w_codinter Char(11) */
    /* w_tipinter Char(2) */
    /* w_DaData Date */
    /* w_AData Date */
    /* w_tipoarch Char(1) */
    /* w_codage Char(6) */
    /* w_flgope Char(1) */
    /* w_flgfrz Char(1) */
    /* w_flgint Char(1) */
    /* w_flgrae Char(1) */
    /* w_flgrap Char(1) */
    /* w_tiprap Char(1) */
    /* w_codcli Char(10) */
    /* w_ragben Char(70) */
    /* w_flgsto Char(1) */
    /* w_flgchk Char(1) */
    /* w_flgdel Char(1) */
    /* gPathApp Char(80) // Path Applicazione */
    /* gIntemediario Char(11) // Intermediario */
    /* gUrlApp Char(80) // URL Applicazione */
    /* gAzienda Char(10) // Azienda */
    /* gNumRec Numeric(15, 0) // N� Record DIANA */
    /* gNumReg Numeric(15, 0) // N� Registrazioni DIANA */
    /* gMsgImp Char(120) // Messaggio Import */
    /* gMsgProc Memo // Messaggio */
    /* gFlgWU Char(1) // Gestione WU */
    /* w_codcab Char(6) */
    /* w_cabcod Char(6) */
    /* w_desccit Char(30) */
    /* w_citdesc Char(30) */
    /* w_provin Char(2) */
    /* w_provind Char(2) */
    /* w_coddipe Char(6) */
    /* _note Memo */
    /* fhand Char(10) */
    /* _nomefile Char(15) */
    /* cNomeFile Char(30) */
    /* cOnlyNomeFile Char(30) */
    /* cNomeFileZip Char(30) */
    /* nTotRec Numeric(10, 0) */
    /* nTotReg Numeric(10, 0) */
    /* nNumRec Numeric(10, 0) */
    /* _avanza Numeric(1, 0) */
    /* _codrif Char(16) */
    /* w_cdadata Char(8) */
    /* w_c_adata Char(8) */
    /* w_cdadata_rap Char(8) */
    /* w_c_adata_rap Char(8) */
    /* _ctotale Numeric(10, 0) */
    /* _conta Numeric(10, 0) */
    /* _max Numeric(15, 0) */
    /* _min Numeric(15, 0) */
    /* _top Numeric(15, 0) */
    /* _bottom Numeric(15, 0) */
    /* _cicli Numeric(15, 0) */
    /* _contacilci Numeric(15, 0) */
    /* _ctotale Numeric(15, 0) */
    /* _flagrap Char(1) */
    /* _ciclo Numeric(1, 0) */
    /* _ramate Char(3) */
    /* _numsto Char(15) */
    /* _oldrighe Numeric(1, 0) */
    /* _continua Numeric(1, 0) */
    /* _oldrap Char(25) */
    /* _idereg Char(20) */
    /* xStato Char(1) */
    /* _conta1 Numeric(10, 0) */
    /* _conta2 Numeric(10, 0) */
    /* _conta4 Numeric(10, 0) */
    /* _conta5 Numeric(10, 0) */
    /* _conta6 Numeric(10, 0) */
    /* gMsgProc := gMsgProc + 'Ora Inizio Procedura: '+ arfn_fdatetime(DateTime()) + NL */
    gMsgProc = gMsgProc+"Ora Inizio Procedura: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* xStato := '' */
    xStato = "";
    /* _codrif := '' */
    _codrif = "";
    /* _ctotale := 0 */
    _ctotale = CPLib.Round(0,0);
    /* w_cdadata := iif(Empty(w_DaData) or DateToChar(w_DaData)='01000101','',DateToChar(w_DaData)) */
    w_cdadata = (CPLib.Empty(w_DaData) || CPLib.eqr(CPLib.DateToChar(w_DaData),"01000101")?"":CPLib.DateToChar(w_DaData));
    /* w_c_adata := iif(Empty(w_AData) or DateToChar(w_AData)='01000101','',DateToChar(w_AData)) */
    w_c_adata = (CPLib.Empty(w_AData) || CPLib.eqr(CPLib.DateToChar(w_AData),"01000101")?"":CPLib.DateToChar(w_AData));
    /* _conta := 0 */
    _conta = CPLib.Round(0,0);
    /* _conta1 := 0 */
    _conta1 = CPLib.Round(0,0);
    /* _conta2 := 0 */
    _conta2 = CPLib.Round(0,0);
    /* _conta4 := 0 */
    _conta4 = CPLib.Round(0,0);
    /* _conta5 := 0 */
    _conta5 = CPLib.Round(0,0);
    /* _conta6 := 0 */
    _conta6 = CPLib.Round(0,0);
    /* If w_flgchk='N' */
    if (CPLib.eqr(w_flgchk,"N")) {
      /* cOnlyNomeFile := "campione.txt" */
      cOnlyNomeFile = "campione.txt";
      /* cNomeFile := LRTrim(gPathApp)+'/flussi/'+LRTrim(gAzienda)+"/campione.txt" */
      cNomeFile = CPLib.LRTrim(gPathApp)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/campione.txt";
      /* cNomeFileZip := LRTrim(gPathApp)+'/flussi/'+LRTrim(gAzienda)+"/campione.zip" */
      cNomeFileZip = CPLib.LRTrim(gPathApp)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/campione.zip";
      /* fhand := FileLibrary.OpenWrite('./flussi/'+LRTrim(gAzienda)+"/"+LRTrim(cOnlyNomeFile)) */
      fhand = FileLibrary.OpenWrite("./flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(cOnlyNomeFile));
    } else { // Else
      /* gMsgProc := gMsgProc + 'Ora Inizio Azzeramento archivi appoggio: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Inizio Azzeramento archivi appoggio: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Azzeramento tabelle WEBCHK ...' // Messaggio Import */
      gMsgImp = "Azzeramento tabelle WEBCHK ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Delete from tipo1
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("tipo1");
      m_cPhName = m_Ctx.GetPhName("tipo1");
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = "delete from "+m_cPhName;
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(1,"?",0,0,m_cServer),m_cServer,1)+"";
      if (m_Ctx.IsSharedTemp("tipo1")) {
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
      // * --- Delete from tipo2_3
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("tipo2_3");
      m_cPhName = m_Ctx.GetPhName("tipo2_3");
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = "delete from "+m_cPhName;
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(1,"?",0,0,m_cServer),m_cServer,1)+"";
      if (m_Ctx.IsSharedTemp("tipo2_3")) {
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
      // * --- Delete from tipo4
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("tipo4");
      m_cPhName = m_Ctx.GetPhName("tipo4");
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = "delete from "+m_cPhName;
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(1,"?",0,0,m_cServer),m_cServer,1)+"";
      if (m_Ctx.IsSharedTemp("tipo4")) {
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
      // * --- Delete from tipo5
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("tipo5");
      m_cPhName = m_Ctx.GetPhName("tipo5");
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = "delete from "+m_cPhName;
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(1,"?",0,0,m_cServer),m_cServer,1)+"";
      if (m_Ctx.IsSharedTemp("tipo5")) {
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
      // * --- Delete from tipo1
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("tipo1");
      m_cPhName = m_Ctx.GetPhName("tipo1");
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = "delete from "+m_cPhName;
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(1,"?",0,0,m_cServer),m_cServer,1)+"";
      if (m_Ctx.IsSharedTemp("tipo1")) {
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
      /* gMsgProc := gMsgProc + 'Ora Fine Azzeramento archivi appoggio: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Fine Azzeramento archivi appoggio: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } // End If
    // Begin Transaction
    m_Sql.RequireTransaction();
    double nTry05E99748status;
    nTry05E99748status = m_Sql.GetTransactionStatus();
    String cTry05E99748msg;
    cTry05E99748msg = m_Sql.TransactionErrorMessage();
    try {
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' dei dati' + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" dei dati"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* If w_flgope = 'S' */
      if (CPLib.eqr(w_flgope,"S")) {
        /* Exec "Operazioni" Page 2:Page_2 */
        Page_2();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
      } // End If
      /* If w_flgfrz = 'S' */
      if (CPLib.eqr(w_flgfrz,"S")) {
        /* Exec "Frazionate" Page 4:Page_4 */
        Page_4();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
      } // End If
      /* Exec "Informazioni" Page 3:Page_3 */
      Page_3();
      if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
        throw new RoutineException();
      }
      /* Exec "Crea file zip" Page 5:Page_6 */
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
      /* If w_flgchk='N' */
      if (CPLib.eqr(w_flgchk,"N")) {
        /* FileLibrary.Close(fhand) */
        FileLibrary.Close(fhand);
        /* Exec "Crea file zip" Page 5:Page_6 */
        Page_6();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* gMsgImp := 'Elaborazione terminata. Premere il bottone per prelevare il file' // Messaggio Import */
        gMsgImp = "Elaborazione terminata. Premere il bottone per prelevare il file";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } else { // Else
        /* gMsgImp := 'Elaborazione Terminata. Utilizzare WEBCHK per analizzare i dati' // Messaggio Import */
        gMsgImp = "Elaborazione Terminata. Utilizzare WEBCHK per analizzare i dati";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } // End If
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' dei dati' + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" dei dati"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } catch(Exception l_exeption) {
      Stop.ReactToException(l_exeption);
      // Rollback
      m_Sql.AbortTransaction();
      m_cLastMsgError = m_Sql.TransactionErrorMessage();
      m_bError = true;
      m_Sql.CompleteTransaction();
      /* gMsgProc := gMsgProc + "Rilevati errori nell'elaborazione dei dati !" + NL */
      gMsgProc = gMsgProc+"Rilevati errori nell'elaborazione dei dati !"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Errore SQL: ' + m_Sql.TransactionErrorMessage() + NL */
      gMsgProc = gMsgProc+"Errore SQL: "+m_Sql.TransactionErrorMessage()+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' dei dati' + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" dei dati"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry05E99748status,0)) {
        m_Sql.SetTransactionStatus(nTry05E99748status,cTry05E99748msg);
      }
    }
    /* gMsgProc := gMsgProc + 'Ora Fine Procedura: '+ arfn_fdatetime(DateTime()) + NL */
    gMsgProc = gMsgProc+"Ora Fine Procedura: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
  }
  void Page_2() throws Exception {
    /* Cicla sulle operazioni */
    /* If w_tipoarch = 'D' */
    if (CPLib.eqr(w_tipoarch,"D")) {
      /* If Empty(LRTrim(w_codcli)) */
      if (CPLib.Empty(CPLib.LRTrim(w_codcli))) {
        /* Exec "Operazioni Definitive" Page 6:Page_7 */
        Page_7();
      } else { // Else
        /* Exec "Operazioni Definitive Cliente" Page 10:Page_11 */
        Page_11();
      } // End If
    } else { // Else
      /* If Empty(LRTrim(w_codcli)) */
      if (CPLib.Empty(CPLib.LRTrim(w_codcli))) {
        /* Exec "Operazioni Provvisorie" Page 7:Page_8 */
        Page_8();
      } else { // Else
        /* Exec "Operazioni Provvisorie Cliente" Page 11:Page_12 */
        Page_12();
      } // End If
    } // End If
  }
  void Page_3() throws Exception {
    CPResultSet Cursor_qbe_rapd_chkdiana=null;
    CPResultSet Cursor_xapopebo=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_anarapbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_anadip=null;
    CPResultSet Cursor_delegabo=null;
    CPResultSet Cursor_qbe_rapp_chkdiana=null;
    CPResultSet Cursor_xntestbo=null;
    CPResultSet Cursor_xnarapbo=null;
    CPResultSet Cursor_xelegabo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Cicla sulle informazioni sui rapporti */
      /* _conta := _conta + 1 */
      _conta = CPLib.Round(_conta+1,0);
      /* If w_flgrap = 'N' or (w_flgrap='S' and (w_tiprap='1' or w_tiprap='2')) */
      if (CPLib.eqr(w_flgrap,"N") || (CPLib.eqr(w_flgrap,"S") && (CPLib.eqr(w_tiprap,"1") || CPLib.eqr(w_tiprap,"2")))) {
        /* w_cdadata_rap := '' */
        w_cdadata_rap = "";
        /* w_c_adata_rap := '' */
        w_c_adata_rap = "";
      } else { // Else
        /* w_cdadata_rap := w_cdadata */
        w_cdadata_rap = w_cdadata;
        /* w_c_adata_rap := w_c_adata */
        w_c_adata_rap = w_c_adata;
      } // End If
      /* If w_tipoarch = 'D' */
      if (CPLib.eqr(w_tipoarch,"D")) {
        // * --- Select from qbe_rapd_chkdiana
        if (Cursor_qbe_rapd_chkdiana!=null)
          Cursor_qbe_rapd_chkdiana.Close();
        Cursor_qbe_rapd_chkdiana = new VQRHolder("qbe_rapd_chkdiana",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_rapd_chkdiana.Eof())) {
          /* _continua := 0 */
          _continua = CPLib.Round(0,0);
          /* Case w_flgrap='N' or (w_flgrap='S' and w_tiprap='3') */
          if (CPLib.eqr(w_flgrap,"N") || (CPLib.eqr(w_flgrap,"S") && CPLib.eqr(w_tiprap,"3"))) {
            /* _continua := 1 */
            _continua = CPLib.Round(1,0);
            /* Case w_flgrap='S' and w_tiprap='1' */
          } else if (CPLib.eqr(w_flgrap,"S") && CPLib.eqr(w_tiprap,"1")) {
            /* _continua := 1 */
            _continua = CPLib.Round(1,0);
            // * --- Select from xapopebo
            m_cServer = m_Ctx.GetServer("xapopebo");
            m_cPhName = m_Ctx.GetPhName("xapopebo");
            if (Cursor_xapopebo!=null)
              Cursor_xapopebo.Close();
            Cursor_xapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapp_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"DATAOPE ",m_cServer,m_Ctx,true));
            while ( ! (Cursor_xapopebo.Eof())) {
              /* Case xapopebo->TIPOOPRAP='25' or qbe_rapp_chkdiana->TIPOOPRAP='28' */
              if (CPLib.eqr(Cursor_xapopebo.GetString("TIPOOPRAP"),"25") || CPLib.eqr(Cursor_qbe_rapp_chkdiana.GetString("TIPOOPRAP"),"28")) {
                /* Case Right(xapopebo->TIPOOPRAP,1)='6' or xapopebo->TIPOOPRAP='38' */
              } else if (CPLib.eqr(CPLib.Right(Cursor_xapopebo.GetString("TIPOOPRAP"),1),"6") || CPLib.eqr(Cursor_xapopebo.GetString("TIPOOPRAP"),"38")) {
                /* If xapopebo->DATAOPE < w_DaData */
                if (CPLib.lt(Cursor_xapopebo.GetDate("DATAOPE"),w_DaData)) {
                  /* _continua := 0 */
                  _continua = CPLib.Round(0,0);
                } // End If
                /* Case xapopebo->TIPOOPRAP='31' or xapopebo->TIPOOPRAP='32' */
              } else if (CPLib.eqr(Cursor_xapopebo.GetString("TIPOOPRAP"),"31") || CPLib.eqr(Cursor_xapopebo.GetString("TIPOOPRAP"),"32")) {
              } else { // Otherwise
                /* If xapopebo->DATAOPE > w_AData */
                if (CPLib.gt(Cursor_xapopebo.GetDate("DATAOPE"),w_AData)) {
                  /* _continua := 0 */
                  _continua = CPLib.Round(0,0);
                } // End If
              } // End Case
              Cursor_xapopebo.Next();
            }
            m_cConnectivityError = Cursor_xapopebo.ErrorMessage();
            Cursor_xapopebo.Close();
            // * --- End Select
            /* Case w_flgrap='S' and w_tiprap='2' */
          } else if (CPLib.eqr(w_flgrap,"S") && CPLib.eqr(w_tiprap,"2")) {
            /* Case xapopebo->TIPOOPRAP='25' or qbe_rapp_chkdiana->TIPOOPRAP='28' */
            if (CPLib.eqr(Cursor_xapopebo.GetString("TIPOOPRAP"),"25") || CPLib.eqr(Cursor_qbe_rapp_chkdiana.GetString("TIPOOPRAP"),"28")) {
              /* Case Right(xapopebo->TIPOOPRAP,1)='6' or xapopebo->TIPOOPRAP='38' */
            } else if (CPLib.eqr(CPLib.Right(Cursor_xapopebo.GetString("TIPOOPRAP"),1),"6") || CPLib.eqr(Cursor_xapopebo.GetString("TIPOOPRAP"),"38")) {
              /* If xapopebo->DATAOPE > w_AData */
              if (CPLib.gt(Cursor_xapopebo.GetDate("DATAOPE"),w_AData)) {
                /* _continua := 0 */
                _continua = CPLib.Round(0,0);
              } // End If
              /* Case xapopebo->TIPOOPRAP='31' or xapopebo->TIPOOPRAP='32' */
            } else if (CPLib.eqr(Cursor_xapopebo.GetString("TIPOOPRAP"),"31") || CPLib.eqr(Cursor_xapopebo.GetString("TIPOOPRAP"),"32")) {
            } else { // Otherwise
              /* If xapopebo->DATAOPE > w_AData */
              if (CPLib.gt(Cursor_xapopebo.GetDate("DATAOPE"),w_AData)) {
                /* _continua := 0 */
                _continua = CPLib.Round(0,0);
              } // End If
            } // End Case
          } // End Case
          /* If not(Empty(w_codcli)) and _continua=1 */
          if ( ! (CPLib.Empty(w_codcli)) && CPLib.eqr(_continua,1)) {
            /* _continua := 0 */
            _continua = CPLib.Round(0,0);
            // * --- Select from intestbo
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            if (Cursor_intestbo!=null)
              Cursor_intestbo.Close();
            Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestbo.Eof())) {
              /* If intestbo->CODINTER=w_codcli */
              if (CPLib.eqr(Cursor_intestbo.GetString("CODINTER"),w_codcli)) {
                /* _continua := 1 */
                _continua = CPLib.Round(1,0);
              } // End If
              Cursor_intestbo.Next();
            }
            m_cConnectivityError = Cursor_intestbo.ErrorMessage();
            Cursor_intestbo.Close();
            // * --- End Select
          } // End If
          /* If _continua=1 */
          if (CPLib.eqr(_continua,1)) {
            /* _ctotale := _ctotale + 1 */
            _ctotale = CPLib.Round(_ctotale+1,0);
            /* gMsgImp := 'Elaborazione Informazione N.: '+LRTrim(Str(_ctotale,15,0)) // Messaggio Import */
            gMsgImp = "Elaborazione Informazione N.: "+CPLib.LRTrim(CPLib.Str(_ctotale,15,0));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* If Empty(LRTrim(qbe_rapd_chkdiana->FLAGRAP2)) */
            if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("FLAGRAP2")))) {
              /* _idereg := DateToChar(qbe_rapd_chkdiana->DATAOPE) + "I" + Left(qbe_rapd_chkdiana->NUMPROG,10) + qbe_rapd_chkdiana->STATOREG */
              _idereg = CPLib.DateToChar(Cursor_qbe_rapd_chkdiana.GetDate("DATAOPE"))+"I"+CPLib.Left(Cursor_qbe_rapd_chkdiana.GetString("NUMPROG"),10)+Cursor_qbe_rapd_chkdiana.GetString("STATOREG");
            } else { // Else
              /* _idereg := Left(qbe_rapd_chkdiana->IDEREG,8) + "I" + Right(qbe_rapd_chkdiana->IDEREG,11) */
              _idereg = CPLib.Left(Cursor_qbe_rapd_chkdiana.GetString("IDEREG"),8)+"I"+CPLib.Right(Cursor_qbe_rapd_chkdiana.GetString("IDEREG"),11);
            } // End If
            /* _note := w_tipinter + w_codinter + '1' + _idereg */
            _note = w_tipinter+w_codinter+"1"+_idereg;
            /* _flagrap := '' */
            _flagrap = "";
            /* If not(Empty(qbe_rapd_chkdiana->FLAGRAP)) */
            if ( ! (CPLib.Empty(Cursor_qbe_rapd_chkdiana.GetString("FLAGRAP")))) {
              /* _flagrap := qbe_rapd_chkdiana->FLAGRAP */
              _flagrap = Cursor_qbe_rapd_chkdiana.GetString("FLAGRAP");
            } else { // Else
              // * --- Select from anarapbo
              m_cServer = m_Ctx.GetServer("anarapbo");
              m_cPhName = m_Ctx.GetPhName("anarapbo");
              if (Cursor_anarapbo!=null)
                Cursor_anarapbo.Close();
              Cursor_anarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select TIPORAP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("anarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_anarapbo.Eof())) {
                /* _flagrap := anarapbo->TIPORAP */
                _flagrap = Cursor_anarapbo.GetString("TIPORAP");
                Cursor_anarapbo.Next();
              }
              m_cConnectivityError = Cursor_anarapbo.ErrorMessage();
              Cursor_anarapbo.Close();
              // * --- End Select
            } // End If
            /* If Empty(qbe_rapd_chkdiana->CODDIPE) */
            if (CPLib.Empty(Cursor_qbe_rapd_chkdiana.GetString("CODDIPE"))) {
              // * --- Read from intermbo
              m_cServer = m_Ctx.GetServer("intermbo");
              m_cPhName = m_Ctx.GetPhName("intermbo");
              m_cSql = "";
              m_cSql = m_cSql+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codinter,"C",11,0,m_cServer),m_cServer,w_codinter);
              if (m_Ctx.IsSharedTemp("intermbo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODCAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODDIPE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                w_codcab = Read_Cursor.GetString("CODCAB");
                w_desccit = Read_Cursor.GetString("DESCCIT");
                w_provin = Read_Cursor.GetString("PROVINCIA");
                w_coddipe = Read_Cursor.GetString("CODDIPE");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on intermbo into routine arrt_chkdiana_old returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                w_codcab = "";
                w_desccit = "";
                w_provin = "";
                w_coddipe = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(w_coddipe) */
              if (CPLib.Empty(w_coddipe)) {
                /* _note := _note + "000000" + Left(LRTrim(w_codcab)+Space(6),6) + Left(LRTrim(w_desccit)+Space(30),30) + Left(LRTrim(w_provin)+Space(2),2) */
                _note = _note+"000000"+CPLib.Left(CPLib.LRTrim(w_codcab)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(w_desccit)+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(w_provin)+CPLib.Space(2),2);
              } else { // Else
                /* _note := _note + Left(LRTrim(w_coddipe)+Space(6),6) */
                _note = _note+CPLib.Left(CPLib.LRTrim(w_coddipe)+CPLib.Space(6),6);
                // * --- Read from anadip
                m_cServer = m_Ctx.GetServer("anadip");
                m_cPhName = m_Ctx.GetPhName("anadip");
                m_cSql = "";
                m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_coddipe,"C",6,0,m_cServer),m_cServer,w_coddipe);
                if (m_Ctx.IsSharedTemp("anadip")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  w_cabcod = Read_Cursor.GetString("CAB");
                  w_citdesc = Read_Cursor.GetString("DESCCIT");
                  w_provind = Read_Cursor.GetString("PROVINCIA");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on anadip into routine arrt_chkdiana_old returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  w_cabcod = "";
                  w_citdesc = "";
                  w_provind = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If Empty(w_cabcod) */
                if (CPLib.Empty(w_cabcod)) {
                  /* _note := _note + Left(LRTrim(w_codcab)+Space(6),6) + Left(LRTrim(w_desccit)+Space(30),30) + Left(LRTrim(w_provin)+Space(2),2) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(w_codcab)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(w_desccit)+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(w_provin)+CPLib.Space(2),2);
                } else { // Else
                  /* _note := _note + Left(LRTrim(w_cabcod)+Space(6),6) + Left(LRTrim(w_citdesc)+Space(30),30) + Left(LRTrim(w_provind)+Space(2),2) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(w_cabcod)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(w_citdesc)+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(w_provind)+CPLib.Space(2),2);
                } // End If
              } // End If
            } else { // Else
              // * --- Select from anadip
              m_cServer = m_Ctx.GetServer("anadip");
              m_cPhName = m_Ctx.GetPhName("anadip");
              if (Cursor_anadip!=null)
                Cursor_anadip.Close();
              Cursor_anadip = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODDIP="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana.GetString("CODDIPE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("anadip")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_anadip.Eof())) {
                /* _note := _note + qbe_rapd_chkdiana->CODDIPE + Left(LRTrim(anadip->CAB)+Space(6),6) + Left(LRTrim(anadip->DESCCIT)+Space(30),30) + Left(LRTrim(anadip->PROVINCIA)+Space(2),2) */
                _note = _note+Cursor_qbe_rapd_chkdiana.GetString("CODDIPE")+CPLib.Left(CPLib.LRTrim(Cursor_anadip.GetString("CAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_anadip.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_anadip.GetString("PROVINCIA"))+CPLib.Space(2),2);
                Cursor_anadip.Next();
              }
              m_cConnectivityError = Cursor_anadip.ErrorMessage();
              Cursor_anadip.Close();
              // * --- End Select
            } // End If
            /* _note := _note + Left(LRTrim(DateToChar(qbe_rapd_chkdiana->DATAOPE))+Space(8),8) + Left(LRTrim(qbe_rapd_chkdiana->FLAGFRAZ)+" ",1) + Left(LRTrim(qbe_rapd_chkdiana->FLAGCONT)+" ",1) */
            _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_rapd_chkdiana.GetDate("DATAOPE")))+CPLib.Space(8),8)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("FLAGFRAZ"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("FLAGCONT"))+" ",1);
            /* _note := _note + Left(LRTrim(qbe_rapd_chkdiana->CODANA)+Space(4),4) + Left(LRTrim(qbe_rapd_chkdiana->CODVOC)+Space(2),2) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("CODANA"))+CPLib.Space(4),4)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("CODVOC"))+CPLib.Space(2),2);
            /* _note := _note + Left(LRTrim(qbe_rapd_chkdiana->TIPOINT2)+Space(2),2) + Left(LRTrim(qbe_rapd_chkdiana->CODINT2)+Space(11),11) + Left(LRTrim(qbe_rapd_chkdiana->PAESE)+Space(3),3) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("TIPOINT2"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("CODINT2"))+CPLib.Space(11),11)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("PAESE"))+CPLib.Space(3),3);
            /* _note := _note + Left(LRTrim(qbe_rapd_chkdiana->CODCAB2)+Space(6),6) + Left(LRTrim(qbe_rapd_chkdiana->DESC2)+Space(30),30) + Left(LRTrim(qbe_rapd_chkdiana->PROV2)+Space(2),2) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("CODCAB2"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("DESC2"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("PROV2"))+CPLib.Space(2),2);
            /* _note := _note + Space(50) + Left(LRTrim(qbe_rapd_chkdiana->RAPPORTO)+Space(25),25) + Left(LRTrim(_flagrap)+" ",1) */
            _note = _note+CPLib.Space(50)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"))+CPLib.Space(25),25)+CPLib.Left(CPLib.LRTrim(_flagrap)+" ",1);
            /* _note := _note + Left(LRTrim(qbe_rapd_chkdiana->TIPOLEG)+" ",1) + Left(LRTrim(DateToChar(qbe_rapd_chkdiana->DATAREG))+Space(8),8) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("TIPOLEG"))+" ",1)+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_rapd_chkdiana.GetDate("DATAREG")))+CPLib.Space(8),8);
            /* _note := _note + Left(LRTrim(qbe_rapd_chkdiana->TIPOOPRAP)+Space(2),2) + Left(LRTrim(qbe_rapd_chkdiana->COLLEG)+Space(12),12) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("TIPOOPRAP"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("COLLEG"))+CPLib.Space(12),12);
            /* _note := _note + Left(LRTrim(qbe_rapd_chkdiana->STATOREG)+" ",1)  */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("STATOREG"))+" ",1);
            /* If Empty(qbe_rapd_chkdiana->DATARETT) or DateToChar(qbe_rapd_chkdiana->DATARETT)='01000101' */
            if (CPLib.Empty(Cursor_qbe_rapd_chkdiana.GetDate("DATARETT")) || CPLib.eqr(CPLib.DateToChar(Cursor_qbe_rapd_chkdiana.GetDate("DATARETT")),"01000101")) {
              /* _note := _note + Space(8) */
              _note = _note+CPLib.Space(8);
            } else { // Else
              /* _note := _note + Left(LRTrim(DateToChar(qbe_rapd_chkdiana->DATARETT))+Space(8),8) */
              _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_rapd_chkdiana.GetDate("DATARETT")))+CPLib.Space(8),8);
            } // End If
            /* _note := _note + iif(Empty(LRTrim(qbe_rapd_chkdiana->OPERAZMOD)),Space(20),Left(qbe_rapd_chkdiana->OPERAZMOD,8)+"I"+Right(qbe_rapd_chkdiana->OPERAZMOD,11)) */
            _note = _note+(CPLib.Empty(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("OPERAZMOD")))?CPLib.Space(20):CPLib.Left(Cursor_qbe_rapd_chkdiana.GetString("OPERAZMOD"),8)+"I"+CPLib.Right(Cursor_qbe_rapd_chkdiana.GetString("OPERAZMOD"),11));
            // * --- Select from anarapbo
            m_cServer = m_Ctx.GetServer("anarapbo");
            m_cPhName = m_Ctx.GetPhName("anarapbo");
            if (Cursor_anarapbo!=null)
              Cursor_anarapbo.Close();
            Cursor_anarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("anarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_anarapbo.Eof())) {
              /* Case anarapbo->FLAGLIRE='1' or anarapbo->FLAGLIRE='L' */
              if (CPLib.eqr(Cursor_anarapbo.GetString("FLAGLIRE"),"1") || CPLib.eqr(Cursor_anarapbo.GetString("FLAGLIRE"),"L")) {
                /* _note := _note + '1' + '018' */
                _note = _note+"1"+"018";
                /* Case anarapbo->FLAGLIRE='2' or anarapbo->FLAGLIRE='V' */
              } else if (CPLib.eqr(Cursor_anarapbo.GetString("FLAGLIRE"),"2") || CPLib.eqr(Cursor_anarapbo.GetString("FLAGLIRE"),"V")) {
                /* _note := _note + '2' + Left(LRTrim(anarapbo->VALUTA)+Space(3),3) */
                _note = _note+"2"+CPLib.Left(CPLib.LRTrim(Cursor_anarapbo.GetString("VALUTA"))+CPLib.Space(3),3);
              } else { // Otherwise
                /* _note := _note + '3' + '242' */
                _note = _note+"3"+"242";
              } // End Case
              Cursor_anarapbo.Next();
            }
            m_cConnectivityError = Cursor_anarapbo.ErrorMessage();
            Cursor_anarapbo.Close();
            // * --- End Select
            /* _note := _note + Left(LRTrim(qbe_rapd_chkdiana->SEGNO)+" ",1) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("SEGNO"))+" ",1);
            /* _note := _note +  Right('000000000000000'+LRTrim(Str(qbe_rapd_chkdiana->TOTLIRE,15,0)),15) + Right('000000000000000'+LRTrim(Str(qbe_rapd_chkdiana->TOTCONT,15,0)),15) + Space(69) */
            _note = _note+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_rapd_chkdiana.GetDouble("TOTLIRE"),15,0)),15)+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_rapd_chkdiana.GetDouble("TOTCONT"),15,0)),15)+CPLib.Space(69);
            /* If w_flgchk='S' */
            if (CPLib.eqr(w_flgchk,"S")) {
              /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
              Page_15();
            } else { // Else
              /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
              FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
            } // End If
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nTotReg := nTotReg + 1 */
            nTotReg = CPLib.Round(nTotReg+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
            /* Case qbe_rapd_chkdiana->TIPOOPRAP='25' or qbe_rapd_chkdiana->TIPOOPRAP='28' */
            if (CPLib.eqr(Cursor_qbe_rapd_chkdiana.GetString("TIPOOPRAP"),"25") || CPLib.eqr(Cursor_qbe_rapd_chkdiana.GetString("TIPOOPRAP"),"28")) {
              /* If qbe_rapd_chkdiana->TIPOOPRAP='25' */
              if (CPLib.eqr(Cursor_qbe_rapd_chkdiana.GetString("TIPOOPRAP"),"25")) {
                /* If w_flgint = 'S' */
                if (CPLib.eqr(w_flgint,"S")) {
                  // * --- Select from intestbo
                  m_cServer = m_Ctx.GetServer("intestbo");
                  m_cPhName = m_Ctx.GetPhName("intestbo");
                  if (Cursor_intestbo!=null)
                    Cursor_intestbo.Close();
                  Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_intestbo.Eof())) {
                    /* If intestbo->DATAINI <= qbe_rapd_chkdiana->DATAOPE and (intestbo->DATAFINE >= qbe_rapd_chkdiana->DATAOPE or Empty(intestbo->DATAFINE)) */
                    if (CPLib.le(Cursor_intestbo.GetDate("DATAINI"),Cursor_qbe_rapd_chkdiana.GetDate("DATAOPE")) && (CPLib.ge(Cursor_intestbo.GetDate("DATAFINE"),Cursor_qbe_rapd_chkdiana.GetDate("DATAOPE")) || CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE")))) {
                      /* _note := w_tipinter + w_codinter+'2'+_idereg */
                      _note = w_tipinter+w_codinter+"2"+_idereg;
                      /* _note := _note + LRTrim(arfn_datisog_sol(intestbo->CODINTER,qbe_rapd_chkdiana->DATAREG,qbe_rapd_chkdiana->RAPPORTO,qbe_rapd_chkdiana->FLAGRAP,'2',w_flgrae,qbe_rapd_chkdiana->STATOREG,qbe_rapd_chkdiana->DATARETT)) */
                      _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_intestbo.GetString("CODINTER"),Cursor_qbe_rapd_chkdiana.GetDate("DATAREG"),Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),Cursor_qbe_rapd_chkdiana.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_rapd_chkdiana.GetString("STATOREG"),Cursor_qbe_rapd_chkdiana.GetDate("DATARETT")));
                      /* If w_flgchk='S' */
                      if (CPLib.eqr(w_flgchk,"S")) {
                        /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                        Page_15();
                      } else { // Else
                        /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                        FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                      } // End If
                      /* nTotRec := nTotRec + 1 */
                      nTotRec = CPLib.Round(nTotRec+1,0);
                      /* nNumRec := nNumRec + 1 */
                      nNumRec = CPLib.Round(nNumRec+1,0);
                    } // End If
                    Cursor_intestbo.Next();
                  }
                  m_cConnectivityError = Cursor_intestbo.ErrorMessage();
                  Cursor_intestbo.Close();
                  // * --- End Select
                } // End If
                // * --- Select from delegabo
                m_cServer = m_Ctx.GetServer("delegabo");
                m_cPhName = m_Ctx.GetPhName("delegabo");
                if (Cursor_delegabo!=null)
                  Cursor_delegabo.Close();
                Cursor_delegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG1="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("delegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_delegabo.Eof())) {
                  /* _avanza := 0 */
                  _avanza = CPLib.Round(0,0);
                  /* If Empty(delegabo->CODINTER) */
                  if (CPLib.Empty(Cursor_delegabo.GetString("CODINTER"))) {
                    /* _avanza := 1 */
                    _avanza = CPLib.Round(1,0);
                  } // End If
                  /* If _avanza=0 */
                  if (CPLib.eqr(_avanza,0)) {
                    /* _note := w_tipinter + w_codinter+'4'+_idereg */
                    _note = w_tipinter+w_codinter+"4"+_idereg;
                    /* _note := _note + LRTrim(arfn_datisog_sol(delegabo->CODINTER,qbe_rapd_chkdiana->DATAREG,qbe_rapd_chkdiana->RAPPORTO,qbe_rapd_chkdiana->FLAGRAP,'4',w_flgrae,qbe_rapd_chkdiana->STATOREG,qbe_rapd_chkdiana->DATARETT)) */
                    _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_delegabo.GetString("CODINTER"),Cursor_qbe_rapd_chkdiana.GetDate("DATAREG"),Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),Cursor_qbe_rapd_chkdiana.GetString("FLAGRAP"),"4",w_flgrae,Cursor_qbe_rapd_chkdiana.GetString("STATOREG"),Cursor_qbe_rapd_chkdiana.GetDate("DATARETT")));
                    /* If w_flgchk='S' */
                    if (CPLib.eqr(w_flgchk,"S")) {
                      /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                      Page_15();
                    } else { // Else
                      /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                      FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                    } // End If
                    /* nTotRec := nTotRec + 1 */
                    nTotRec = CPLib.Round(nTotRec+1,0);
                    /* nNumRec := nNumRec + 1 */
                    nNumRec = CPLib.Round(nNumRec+1,0);
                  } // End If
                  Cursor_delegabo.Next();
                }
                m_cConnectivityError = Cursor_delegabo.ErrorMessage();
                Cursor_delegabo.Close();
                // * --- End Select
              } else { // Else
                /* If w_flgint = 'S' */
                if (CPLib.eqr(w_flgint,"S")) {
                  // * --- Select from intestbo
                  m_cServer = m_Ctx.GetServer("intestbo");
                  m_cPhName = m_Ctx.GetPhName("intestbo");
                  if (Cursor_intestbo!=null)
                    Cursor_intestbo.Close();
                  Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_intestbo.Eof())) {
                    /* If intestbo->DATAINI <= qbe_rapd_chkdiana->DATAOPE and (intestbo->DATAFINE >= qbe_rapd_chkdiana->DATAOPE or Empty(intestbo->DATAFINE)) */
                    if (CPLib.le(Cursor_intestbo.GetDate("DATAINI"),Cursor_qbe_rapd_chkdiana.GetDate("DATAOPE")) && (CPLib.ge(Cursor_intestbo.GetDate("DATAFINE"),Cursor_qbe_rapd_chkdiana.GetDate("DATAOPE")) || CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE")))) {
                      /* _note := w_tipinter + w_codinter+'2'+_idereg */
                      _note = w_tipinter+w_codinter+"2"+_idereg;
                      /* _note := _note + LRTrim(arfn_datisog_sol(intestbo->CODINTER,qbe_rapd_chkdiana->DATAREG,qbe_rapd_chkdiana->RAPPORTO,qbe_rapd_chkdiana->FLAGRAP,'2',w_flgrae,qbe_rapd_chkdiana->STATOREG,qbe_rapd_chkdiana->DATARETT)) */
                      _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_intestbo.GetString("CODINTER"),Cursor_qbe_rapd_chkdiana.GetDate("DATAREG"),Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),Cursor_qbe_rapd_chkdiana.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_rapd_chkdiana.GetString("STATOREG"),Cursor_qbe_rapd_chkdiana.GetDate("DATARETT")));
                      /* If w_flgchk='S' */
                      if (CPLib.eqr(w_flgchk,"S")) {
                        /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                        Page_15();
                      } else { // Else
                        /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                        FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                      } // End If
                      /* nTotRec := nTotRec + 1 */
                      nTotRec = CPLib.Round(nTotRec+1,0);
                      /* nNumRec := nNumRec + 1 */
                      nNumRec = CPLib.Round(nNumRec+1,0);
                    } // End If
                    Cursor_intestbo.Next();
                  }
                  m_cConnectivityError = Cursor_intestbo.ErrorMessage();
                  Cursor_intestbo.Close();
                  // * --- End Select
                } // End If
                // * --- Select from delegabo
                m_cServer = m_Ctx.GetServer("delegabo");
                m_cPhName = m_Ctx.GetPhName("delegabo");
                if (Cursor_delegabo!=null)
                  Cursor_delegabo.Close();
                Cursor_delegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG2="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("delegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_delegabo.Eof())) {
                  /* _avanza := 0 */
                  _avanza = CPLib.Round(0,0);
                  /* If Empty(delegabo->CODINTER) */
                  if (CPLib.Empty(Cursor_delegabo.GetString("CODINTER"))) {
                    /* _avanza := 1 */
                    _avanza = CPLib.Round(1,0);
                  } // End If
                  /* If _avanza=0 */
                  if (CPLib.eqr(_avanza,0)) {
                    /* _note := w_tipinter + w_codinter+'4'+_idereg */
                    _note = w_tipinter+w_codinter+"4"+_idereg;
                    /* _note := _note + LRTrim(arfn_datisog_sol(delegabo->CODINTER,qbe_rapd_chkdiana->DATAREG,qbe_rapd_chkdiana->RAPPORTO,qbe_rapd_chkdiana->FLAGRAP,'4',w_flgrae,qbe_rapd_chkdiana->STATOREG,qbe_rapd_chkdiana->DATARETT)) */
                    _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_delegabo.GetString("CODINTER"),Cursor_qbe_rapd_chkdiana.GetDate("DATAREG"),Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),Cursor_qbe_rapd_chkdiana.GetString("FLAGRAP"),"4",w_flgrae,Cursor_qbe_rapd_chkdiana.GetString("STATOREG"),Cursor_qbe_rapd_chkdiana.GetDate("DATARETT")));
                    /* If w_flgchk='S' */
                    if (CPLib.eqr(w_flgchk,"S")) {
                      /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                      Page_15();
                    } else { // Else
                      /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                      FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                    } // End If
                    /* nTotRec := nTotRec + 1 */
                    nTotRec = CPLib.Round(nTotRec+1,0);
                    /* nNumRec := nNumRec + 1 */
                    nNumRec = CPLib.Round(nNumRec+1,0);
                  } // End If
                  Cursor_delegabo.Next();
                }
                m_cConnectivityError = Cursor_delegabo.ErrorMessage();
                Cursor_delegabo.Close();
                // * --- End Select
              } // End If
              /* Case Right(qbe_rapd_chkdiana->TIPOOPRAP,1)='6' or qbe_rapd_chkdiana->TIPOOPRAP='38' */
            } else if (CPLib.eqr(CPLib.Right(Cursor_qbe_rapd_chkdiana.GetString("TIPOOPRAP"),1),"6") || CPLib.eqr(Cursor_qbe_rapd_chkdiana.GetString("TIPOOPRAP"),"38")) {
              // * --- Select from intestbo
              m_cServer = m_Ctx.GetServer("intestbo");
              m_cPhName = m_Ctx.GetPhName("intestbo");
              if (Cursor_intestbo!=null)
                Cursor_intestbo.Close();
              Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG2="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_intestbo.Eof())) {
                /* _avanza := 0 */
                _avanza = CPLib.Round(0,0);
                /* If Empty(intestbo->CODINTER) */
                if (CPLib.Empty(Cursor_intestbo.GetString("CODINTER"))) {
                  /* _avanza := 1 */
                  _avanza = CPLib.Round(1,0);
                } // End If
                /* If _avanza=0 */
                if (CPLib.eqr(_avanza,0)) {
                  /* _note := w_tipinter + w_codinter+'2'+_idereg */
                  _note = w_tipinter+w_codinter+"2"+_idereg;
                  /* _note := _note + LRTrim(arfn_datisog_sol(intestbo->CODINTER,qbe_rapd_chkdiana->DATAREG,qbe_rapd_chkdiana->RAPPORTO,qbe_rapd_chkdiana->FLAGRAP,'2',w_flgrae,qbe_rapd_chkdiana->STATOREG,qbe_rapd_chkdiana->DATARETT)) */
                  _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_intestbo.GetString("CODINTER"),Cursor_qbe_rapd_chkdiana.GetDate("DATAREG"),Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),Cursor_qbe_rapd_chkdiana.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_rapd_chkdiana.GetString("STATOREG"),Cursor_qbe_rapd_chkdiana.GetDate("DATARETT")));
                  /* If w_flgchk='S' */
                  if (CPLib.eqr(w_flgchk,"S")) {
                    /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                    Page_15();
                  } else { // Else
                    /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                    FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                  } // End If
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                } // End If
                Cursor_intestbo.Next();
              }
              m_cConnectivityError = Cursor_intestbo.ErrorMessage();
              Cursor_intestbo.Close();
              // * --- End Select
              /* Case qbe_rapd_chkdiana->TIPOOPRAP='31' or qbe_rapd_chkdiana->TIPOOPRAP='32' */
            } else if (CPLib.eqr(Cursor_qbe_rapd_chkdiana.GetString("TIPOOPRAP"),"31") || CPLib.eqr(Cursor_qbe_rapd_chkdiana.GetString("TIPOOPRAP"),"32")) {
              // * --- Select from intestbo
              m_cServer = m_Ctx.GetServer("intestbo");
              m_cPhName = m_Ctx.GetPhName("intestbo");
              if (Cursor_intestbo!=null)
                Cursor_intestbo.Close();
              Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_intestbo.Eof())) {
                /* _avanza := 0 */
                _avanza = CPLib.Round(0,0);
                /* If Empty(intestbo->CODINTER) */
                if (CPLib.Empty(Cursor_intestbo.GetString("CODINTER"))) {
                  /* _avanza := 1 */
                  _avanza = CPLib.Round(1,0);
                } // End If
                /* If _avanza=0 */
                if (CPLib.eqr(_avanza,0)) {
                  /* _note := w_tipinter + w_codinter+'2'+_idereg */
                  _note = w_tipinter+w_codinter+"2"+_idereg;
                  /* If qbe_rapd_chkdiana->TIPOOPRAP='31' */
                  if (CPLib.eqr(Cursor_qbe_rapd_chkdiana.GetString("TIPOOPRAP"),"31")) {
                    /* _note := _note + LRTrim(arfn_datisog_sol(intestbo->CODINTER,arfn_dateminus(qbe_rapd_chkdiana->DATAREG,1),qbe_rapd_chkdiana->RAPPORTO,qbe_rapd_chkdiana->FLAGRAP,'2',w_flgrae,qbe_rapd_chkdiana->STATOREG,qbe_rapd_chkdiana->DATARETT)) */
                    _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_intestbo.GetString("CODINTER"),arfn_dateminusR.Make(m_Ctx,this).Run(Cursor_qbe_rapd_chkdiana.GetDate("DATAREG"),1),Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),Cursor_qbe_rapd_chkdiana.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_rapd_chkdiana.GetString("STATOREG"),Cursor_qbe_rapd_chkdiana.GetDate("DATARETT")));
                    /* ElseIf qbe_rapd_chkdiana->TIPOOPRAP='32' */
                  } else if (CPLib.eqr(Cursor_qbe_rapd_chkdiana.GetString("TIPOOPRAP"),"32")) {
                    /* _note := _note + LRTrim(arfn_datisog_sol(intestbo->CODINTER,qbe_rapd_chkdiana->DATAREG,qbe_rapd_chkdiana->RAPPORTO,qbe_rapd_chkdiana->FLAGRAP,'2',w_flgrae,qbe_rapd_chkdiana->STATOREG,qbe_rapd_chkdiana->DATARETT)) */
                    _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_intestbo.GetString("CODINTER"),Cursor_qbe_rapd_chkdiana.GetDate("DATAREG"),Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),Cursor_qbe_rapd_chkdiana.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_rapd_chkdiana.GetString("STATOREG"),Cursor_qbe_rapd_chkdiana.GetDate("DATARETT")));
                  } // End If
                  /* If w_flgchk='S' */
                  if (CPLib.eqr(w_flgchk,"S")) {
                    /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                    Page_15();
                  } else { // Else
                    /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                    FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                  } // End If
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                } // End If
                Cursor_intestbo.Next();
              }
              m_cConnectivityError = Cursor_intestbo.ErrorMessage();
              Cursor_intestbo.Close();
              // * --- End Select
              /* If w_flgdel='S' */
              if (CPLib.eqr(w_flgdel,"S")) {
                // * --- Select from delegabo
                m_cServer = m_Ctx.GetServer("delegabo");
                m_cPhName = m_Ctx.GetPhName("delegabo");
                if (Cursor_delegabo!=null)
                  Cursor_delegabo.Close();
                Cursor_delegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("delegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_delegabo.Eof())) {
                  /* _avanza := 0 */
                  _avanza = CPLib.Round(0,0);
                  /* If Empty(delegabo->CODINTER) */
                  if (CPLib.Empty(Cursor_delegabo.GetString("CODINTER"))) {
                    /* _avanza := 1 */
                    _avanza = CPLib.Round(1,0);
                  } // End If
                  /* If _avanza=0 */
                  if (CPLib.eqr(_avanza,0)) {
                    /* _note := w_tipinter + w_codinter+'4'+_idereg */
                    _note = w_tipinter+w_codinter+"4"+_idereg;
                    /* If qbe_rapd_chkdiana->TIPOOPRAP='31' */
                    if (CPLib.eqr(Cursor_qbe_rapd_chkdiana.GetString("TIPOOPRAP"),"31")) {
                      /* _note := _note + LRTrim(arfn_datisog_sol(delegabo->CODINTER,arfn_dateminus(qbe_rapd_chkdiana->DATAREG,1),qbe_rapd_chkdiana->RAPPORTO,qbe_rapd_chkdiana->FLAGRAP,'4',w_flgrae,qbe_rapd_chkdiana->STATOREG,qbe_rapd_chkdiana->DATARETT)) */
                      _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_delegabo.GetString("CODINTER"),arfn_dateminusR.Make(m_Ctx,this).Run(Cursor_qbe_rapd_chkdiana.GetDate("DATAREG"),1),Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),Cursor_qbe_rapd_chkdiana.GetString("FLAGRAP"),"4",w_flgrae,Cursor_qbe_rapd_chkdiana.GetString("STATOREG"),Cursor_qbe_rapd_chkdiana.GetDate("DATARETT")));
                      /* ElseIf qbe_rapd_chkdiana->TIPOOPRAP='32' */
                    } else if (CPLib.eqr(Cursor_qbe_rapd_chkdiana.GetString("TIPOOPRAP"),"32")) {
                      /* _note := _note + LRTrim(arfn_datisog_sol(delegabo->CODINTER,qbe_rapd_chkdiana->DATAREG,qbe_rapd_chkdiana->RAPPORTO,qbe_rapd_chkdiana->FLAGRAP,'4',w_flgrae,qbe_rapd_chkdiana->STATOREG,qbe_rapd_chkdiana->DATARETT)) */
                      _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_delegabo.GetString("CODINTER"),Cursor_qbe_rapd_chkdiana.GetDate("DATAREG"),Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),Cursor_qbe_rapd_chkdiana.GetString("FLAGRAP"),"4",w_flgrae,Cursor_qbe_rapd_chkdiana.GetString("STATOREG"),Cursor_qbe_rapd_chkdiana.GetDate("DATARETT")));
                    } // End If
                    /* If w_flgchk='S' */
                    if (CPLib.eqr(w_flgchk,"S")) {
                      /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                      Page_15();
                    } else { // Else
                      /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                      FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                    } // End If
                    /* nTotRec := nTotRec + 1 */
                    nTotRec = CPLib.Round(nTotRec+1,0);
                    /* nNumRec := nNumRec + 1 */
                    nNumRec = CPLib.Round(nNumRec+1,0);
                  } // End If
                  Cursor_delegabo.Next();
                }
                m_cConnectivityError = Cursor_delegabo.ErrorMessage();
                Cursor_delegabo.Close();
                // * --- End Select
              } // End If
            } else { // Otherwise
              // * --- Select from intestbo
              m_cServer = m_Ctx.GetServer("intestbo");
              m_cPhName = m_Ctx.GetPhName("intestbo");
              if (Cursor_intestbo!=null)
                Cursor_intestbo.Close();
              Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG1="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_intestbo.Eof())) {
                /* _avanza := 0 */
                _avanza = CPLib.Round(0,0);
                /* If Empty(intestbo->CODINTER) */
                if (CPLib.Empty(Cursor_intestbo.GetString("CODINTER"))) {
                  /* _avanza := 1 */
                  _avanza = CPLib.Round(1,0);
                } // End If
                /* If _avanza=0 */
                if (CPLib.eqr(_avanza,0)) {
                  /* _note := w_tipinter + w_codinter+'2'+_idereg */
                  _note = w_tipinter+w_codinter+"2"+_idereg;
                  /* _note := _note + LRTrim(arfn_datisog_sol(intestbo->CODINTER,qbe_rapd_chkdiana->DATAREG,qbe_rapd_chkdiana->RAPPORTO,qbe_rapd_chkdiana->FLAGRAP,'2',w_flgrae,qbe_rapd_chkdiana->STATOREG,qbe_rapd_chkdiana->DATARETT)) */
                  _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_intestbo.GetString("CODINTER"),Cursor_qbe_rapd_chkdiana.GetDate("DATAREG"),Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),Cursor_qbe_rapd_chkdiana.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_rapd_chkdiana.GetString("STATOREG"),Cursor_qbe_rapd_chkdiana.GetDate("DATARETT")));
                  /* If w_flgchk='S' */
                  if (CPLib.eqr(w_flgchk,"S")) {
                    /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                    Page_15();
                  } else { // Else
                    /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                    FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                  } // End If
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                } // End If
                Cursor_intestbo.Next();
              }
              m_cConnectivityError = Cursor_intestbo.ErrorMessage();
              Cursor_intestbo.Close();
              // * --- End Select
            } // End Case
          } // End If
          Cursor_qbe_rapd_chkdiana.Next();
        }
        m_cConnectivityError = Cursor_qbe_rapd_chkdiana.ErrorMessage();
        Cursor_qbe_rapd_chkdiana.Close();
        // * --- End Select
      } else { // Else
        // * --- Select from qbe_rapp_chkdiana
        if (Cursor_qbe_rapp_chkdiana!=null)
          Cursor_qbe_rapp_chkdiana.Close();
        Cursor_qbe_rapp_chkdiana = new VQRHolder("qbe_rapp_chkdiana",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_rapp_chkdiana.Eof())) {
          /* _continua := 0 */
          _continua = CPLib.Round(0,0);
          /* Case w_flgrap='N' or (w_flgrap='S' and w_tiprap='3') */
          if (CPLib.eqr(w_flgrap,"N") || (CPLib.eqr(w_flgrap,"S") && CPLib.eqr(w_tiprap,"3"))) {
            /* _continua := 1 */
            _continua = CPLib.Round(1,0);
            /* Case w_flgrap='S' and w_tiprap='1' */
          } else if (CPLib.eqr(w_flgrap,"S") && CPLib.eqr(w_tiprap,"1")) {
            /* _continua := 1 */
            _continua = CPLib.Round(1,0);
            // * --- Select from xapopebo
            m_cServer = m_Ctx.GetServer("xapopebo");
            m_cPhName = m_Ctx.GetPhName("xapopebo");
            if (Cursor_xapopebo!=null)
              Cursor_xapopebo.Close();
            Cursor_xapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapp_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"DATAOPE ",m_cServer,m_Ctx,true));
            while ( ! (Cursor_xapopebo.Eof())) {
              /* Case xapopebo->TIPOOPRAP='25' or qbe_rapp_chkdiana->TIPOOPRAP='28' */
              if (CPLib.eqr(Cursor_xapopebo.GetString("TIPOOPRAP"),"25") || CPLib.eqr(Cursor_qbe_rapp_chkdiana.GetString("TIPOOPRAP"),"28")) {
                /* Case Right(xapopebo->TIPOOPRAP,1)='6' or xapopebo->TIPOOPRAP='38' */
              } else if (CPLib.eqr(CPLib.Right(Cursor_xapopebo.GetString("TIPOOPRAP"),1),"6") || CPLib.eqr(Cursor_xapopebo.GetString("TIPOOPRAP"),"38")) {
                /* If xapopebo->DATAOPE < w_DaData */
                if (CPLib.lt(Cursor_xapopebo.GetDate("DATAOPE"),w_DaData)) {
                  /* _continua := 0 */
                  _continua = CPLib.Round(0,0);
                } // End If
                /* Case xapopebo->TIPOOPRAP='31' or xapopebo->TIPOOPRAP='32' */
              } else if (CPLib.eqr(Cursor_xapopebo.GetString("TIPOOPRAP"),"31") || CPLib.eqr(Cursor_xapopebo.GetString("TIPOOPRAP"),"32")) {
              } else { // Otherwise
                /* If xapopebo->DATAOPE > w_AData */
                if (CPLib.gt(Cursor_xapopebo.GetDate("DATAOPE"),w_AData)) {
                  /* _continua := 0 */
                  _continua = CPLib.Round(0,0);
                } // End If
              } // End Case
              Cursor_xapopebo.Next();
            }
            m_cConnectivityError = Cursor_xapopebo.ErrorMessage();
            Cursor_xapopebo.Close();
            // * --- End Select
            /* Case w_flgrap='S' and w_tiprap='2' */
          } else if (CPLib.eqr(w_flgrap,"S") && CPLib.eqr(w_tiprap,"2")) {
            /* Case xapopebo->TIPOOPRAP='25' or qbe_rapp_chkdiana->TIPOOPRAP='28' */
            if (CPLib.eqr(Cursor_xapopebo.GetString("TIPOOPRAP"),"25") || CPLib.eqr(Cursor_qbe_rapp_chkdiana.GetString("TIPOOPRAP"),"28")) {
              /* Case Right(xapopebo->TIPOOPRAP,1)='6' or xapopebo->TIPOOPRAP='38' */
            } else if (CPLib.eqr(CPLib.Right(Cursor_xapopebo.GetString("TIPOOPRAP"),1),"6") || CPLib.eqr(Cursor_xapopebo.GetString("TIPOOPRAP"),"38")) {
              /* If xapopebo->DATAOPE > w_AData */
              if (CPLib.gt(Cursor_xapopebo.GetDate("DATAOPE"),w_AData)) {
                /* _continua := 0 */
                _continua = CPLib.Round(0,0);
              } // End If
              /* Case xapopebo->TIPOOPRAP='31' or xapopebo->TIPOOPRAP='32' */
            } else if (CPLib.eqr(Cursor_xapopebo.GetString("TIPOOPRAP"),"31") || CPLib.eqr(Cursor_xapopebo.GetString("TIPOOPRAP"),"32")) {
            } else { // Otherwise
              /* If xapopebo->DATAOPE > w_AData */
              if (CPLib.gt(Cursor_xapopebo.GetDate("DATAOPE"),w_AData)) {
                /* _continua := 0 */
                _continua = CPLib.Round(0,0);
              } // End If
            } // End Case
          } // End Case
          /* If not(Empty(w_codcli)) and _continua=1 */
          if ( ! (CPLib.Empty(w_codcli)) && CPLib.eqr(_continua,1)) {
            /* _continua := 0 */
            _continua = CPLib.Round(0,0);
            // * --- Select from xntestbo
            m_cServer = m_Ctx.GetServer("xntestbo");
            m_cPhName = m_Ctx.GetPhName("xntestbo");
            if (Cursor_xntestbo!=null)
              Cursor_xntestbo.Close();
            Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapp_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xntestbo.Eof())) {
              /* If xntestbo->CODINTER=w_codcli */
              if (CPLib.eqr(Cursor_xntestbo.GetString("CODINTER"),w_codcli)) {
                /* _continua := 1 */
                _continua = CPLib.Round(1,0);
              } // End If
              Cursor_xntestbo.Next();
            }
            m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
            Cursor_xntestbo.Close();
            // * --- End Select
          } // End If
          /* If _continua=1 */
          if (CPLib.eqr(_continua,1)) {
            /* _ctotale := _ctotale + 1 */
            _ctotale = CPLib.Round(_ctotale+1,0);
            /* gMsgImp := 'Elaborazione Informazione N.: '+LRTrim(Str(_ctotale,15,0)) // Messaggio Import */
            gMsgImp = "Elaborazione Informazione N.: "+CPLib.LRTrim(CPLib.Str(_ctotale,15,0));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* If Empty(LRTrim(qbe_rapp_chkdiana->FLAGRAP2)) */
            if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("FLAGRAP2")))) {
              /* _idereg := DateToChar(qbe_rapp_chkdiana->DATAOPE) + "I" + Right(qbe_rapp_chkdiana->NUMPROG,10) + qbe_rapp_chkdiana->STATOREG */
              _idereg = CPLib.DateToChar(Cursor_qbe_rapp_chkdiana.GetDate("DATAOPE"))+"I"+CPLib.Right(Cursor_qbe_rapp_chkdiana.GetString("NUMPROG"),10)+Cursor_qbe_rapp_chkdiana.GetString("STATOREG");
            } else { // Else
              /* _idereg := Left(qbe_rapp_chkdiana->IDEREG,8) + "I" + Right(qbe_rapp_chkdiana->IDEREG,11) */
              _idereg = CPLib.Left(Cursor_qbe_rapp_chkdiana.GetString("IDEREG"),8)+"I"+CPLib.Right(Cursor_qbe_rapp_chkdiana.GetString("IDEREG"),11);
            } // End If
            /* _note := w_tipinter + w_codinter + '1'+_idereg */
            _note = w_tipinter+w_codinter+"1"+_idereg;
            /* _flagrap := '' */
            _flagrap = "";
            /* If not(Empty(qbe_rapp_chkdiana->FLAGRAP)) */
            if ( ! (CPLib.Empty(Cursor_qbe_rapp_chkdiana.GetString("FLAGRAP")))) {
              /* _flagrap := qbe_rapp_chkdiana->FLAGRAP */
              _flagrap = Cursor_qbe_rapp_chkdiana.GetString("FLAGRAP");
            } else { // Else
              // * --- Select from xnarapbo
              m_cServer = m_Ctx.GetServer("xnarapbo");
              m_cPhName = m_Ctx.GetPhName("xnarapbo");
              if (Cursor_xnarapbo!=null)
                Cursor_xnarapbo.Close();
              Cursor_xnarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select TIPORAP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapp_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xnarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_xnarapbo.Eof())) {
                /* _flagrap := xnarapbo->TIPORAP */
                _flagrap = Cursor_xnarapbo.GetString("TIPORAP");
                Cursor_xnarapbo.Next();
              }
              m_cConnectivityError = Cursor_xnarapbo.ErrorMessage();
              Cursor_xnarapbo.Close();
              // * --- End Select
            } // End If
            /* If Empty(qbe_rapp_chkdiana->CODDIPE) */
            if (CPLib.Empty(Cursor_qbe_rapp_chkdiana.GetString("CODDIPE"))) {
              // * --- Read from intermbo
              m_cServer = m_Ctx.GetServer("intermbo");
              m_cPhName = m_Ctx.GetPhName("intermbo");
              m_cSql = "";
              m_cSql = m_cSql+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codinter,"C",11,0,m_cServer),m_cServer,w_codinter);
              if (m_Ctx.IsSharedTemp("intermbo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODCAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODDIPE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                w_codcab = Read_Cursor.GetString("CODCAB");
                w_desccit = Read_Cursor.GetString("DESCCIT");
                w_provin = Read_Cursor.GetString("PROVINCIA");
                w_coddipe = Read_Cursor.GetString("CODDIPE");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on intermbo into routine arrt_chkdiana_old returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                w_codcab = "";
                w_desccit = "";
                w_provin = "";
                w_coddipe = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(w_coddipe) */
              if (CPLib.Empty(w_coddipe)) {
                /* _note := _note + "000000" + Left(LRTrim(w_codcab)+Space(6),6) + Left(LRTrim(w_desccit)+Space(30),30) + Left(LRTrim(w_provin)+Space(2),2) */
                _note = _note+"000000"+CPLib.Left(CPLib.LRTrim(w_codcab)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(w_desccit)+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(w_provin)+CPLib.Space(2),2);
              } else { // Else
                /* _note := _note + Left(LRTrim(w_coddipe)+Space(6),6) */
                _note = _note+CPLib.Left(CPLib.LRTrim(w_coddipe)+CPLib.Space(6),6);
                // * --- Read from anadip
                m_cServer = m_Ctx.GetServer("anadip");
                m_cPhName = m_Ctx.GetPhName("anadip");
                m_cSql = "";
                m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_coddipe,"C",6,0,m_cServer),m_cServer,w_coddipe);
                if (m_Ctx.IsSharedTemp("anadip")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  w_cabcod = Read_Cursor.GetString("CAB");
                  w_citdesc = Read_Cursor.GetString("DESCCIT");
                  w_provind = Read_Cursor.GetString("PROVINCIA");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on anadip into routine arrt_chkdiana_old returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  w_cabcod = "";
                  w_citdesc = "";
                  w_provind = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If Empty(w_cabcod) */
                if (CPLib.Empty(w_cabcod)) {
                  /* _note := _note + Left(LRTrim(w_codcab)+Space(6),6) + Left(LRTrim(w_desccit)+Space(30),30) + Left(LRTrim(w_provin)+Space(2),2) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(w_codcab)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(w_desccit)+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(w_provin)+CPLib.Space(2),2);
                } else { // Else
                  /* _note := _note + Left(LRTrim(w_cabcod)+Space(6),6) + Left(LRTrim(w_citdesc)+Space(30),30) + Left(LRTrim(w_provind)+Space(2),2) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(w_cabcod)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(w_citdesc)+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(w_provind)+CPLib.Space(2),2);
                } // End If
              } // End If
            } else { // Else
              // * --- Select from anadip
              m_cServer = m_Ctx.GetServer("anadip");
              m_cPhName = m_Ctx.GetPhName("anadip");
              if (Cursor_anadip!=null)
                Cursor_anadip.Close();
              Cursor_anadip = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODDIP="+CPLib.ToSQL(Cursor_qbe_rapp_chkdiana.GetString("CODDIPE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("anadip")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_anadip.Eof())) {
                /* _note := _note + qbe_rapp_chkdiana->CODDIPE + Left(LRTrim(anadip->CAB)+Space(6),6) + Left(LRTrim(anadip->DESCCIT)+Space(30),30) + Left(LRTrim(anadip->PROVINCIA)+Space(2),2) */
                _note = _note+Cursor_qbe_rapp_chkdiana.GetString("CODDIPE")+CPLib.Left(CPLib.LRTrim(Cursor_anadip.GetString("CAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_anadip.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_anadip.GetString("PROVINCIA"))+CPLib.Space(2),2);
                Cursor_anadip.Next();
              }
              m_cConnectivityError = Cursor_anadip.ErrorMessage();
              Cursor_anadip.Close();
              // * --- End Select
            } // End If
            /* _note := _note + Left(LRTrim(DateToChar(qbe_rapp_chkdiana->DATAOPE))+Space(8),8) + Left(LRTrim(qbe_rapp_chkdiana->FLAGFRAZ)+" ",1) + Left(LRTrim(qbe_rapp_chkdiana->FLAGCONT)+" ",1) */
            _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_rapp_chkdiana.GetDate("DATAOPE")))+CPLib.Space(8),8)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("FLAGFRAZ"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("FLAGCONT"))+" ",1);
            /* _note := _note + Left(LRTrim(qbe_rapp_chkdiana->CODANA)+Space(4),4) + Left(LRTrim(qbe_rapp_chkdiana->CODVOC)+Space(2),2) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("CODANA"))+CPLib.Space(4),4)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("CODVOC"))+CPLib.Space(2),2);
            /* _note := _note + Left(LRTrim(qbe_rapp_chkdiana->TIPOINT2)+Space(2),2) + Left(LRTrim(qbe_rapp_chkdiana->CODINT2)+Space(11),11) + Left(LRTrim(qbe_rapp_chkdiana->PAESE)+Space(3),3) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("TIPOINT2"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("CODINT2"))+CPLib.Space(11),11)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("PAESE"))+CPLib.Space(3),3);
            /* _note := _note + Left(LRTrim(qbe_rapp_chkdiana->CODCAB2)+Space(6),6) + Left(LRTrim(qbe_rapp_chkdiana->DESC2)+Space(30),30) + Left(LRTrim(qbe_rapp_chkdiana->PROV2)+Space(2),2) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("CODCAB2"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("DESC2"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("PROV2"))+CPLib.Space(2),2);
            /* _note := _note + Space(50) + Left(LRTrim(qbe_rapp_chkdiana->RAPPORTO)+Space(25),25) + Left(LRTrim(_flagrap)+" ",1) */
            _note = _note+CPLib.Space(50)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("RAPPORTO"))+CPLib.Space(25),25)+CPLib.Left(CPLib.LRTrim(_flagrap)+" ",1);
            /* _note := _note + Left(LRTrim(qbe_rapp_chkdiana->TIPOLEG)+" ",1) + Left(LRTrim(DateToChar(qbe_rapp_chkdiana->DATAREG))+Space(8),8) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("TIPOLEG"))+" ",1)+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_rapp_chkdiana.GetDate("DATAREG")))+CPLib.Space(8),8);
            /* _note := _note + Left(LRTrim(qbe_rapp_chkdiana->TIPOOPRAP)+Space(2),2) + Left(LRTrim(qbe_rapp_chkdiana->COLLEG)+Space(12),12) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("TIPOOPRAP"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("COLLEG"))+CPLib.Space(12),12);
            /* _note := _note + Left(LRTrim(qbe_rapp_chkdiana->STATOREG)+" ",1)  */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("STATOREG"))+" ",1);
            /* If Empty(qbe_rapp_chkdiana->DATARETT) or DateToChar(qbe_rapp_chkdiana->DATARETT)='01000101' */
            if (CPLib.Empty(Cursor_qbe_rapp_chkdiana.GetDate("DATARETT")) || CPLib.eqr(CPLib.DateToChar(Cursor_qbe_rapp_chkdiana.GetDate("DATARETT")),"01000101")) {
              /* _note := _note + Space(8) */
              _note = _note+CPLib.Space(8);
            } else { // Else
              /* _note := _note + Left(LRTrim(DateToChar(qbe_rapp_chkdiana->DATARETT))+Space(8),8) */
              _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_rapp_chkdiana.GetDate("DATARETT")))+CPLib.Space(8),8);
            } // End If
            /* _note := _note + iif(Empty(LRTrim(qbe_rapp_chkdiana->OPERAZMOD)),Space(20),Left(qbe_rapp_chkdiana->OPERAZMOD,8)+"I"+Right(qbe_rapp_chkdiana->OPERAZMOD,11)) */
            _note = _note+(CPLib.Empty(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("OPERAZMOD")))?CPLib.Space(20):CPLib.Left(Cursor_qbe_rapp_chkdiana.GetString("OPERAZMOD"),8)+"I"+CPLib.Right(Cursor_qbe_rapp_chkdiana.GetString("OPERAZMOD"),11));
            // * --- Select from xnarapbo
            m_cServer = m_Ctx.GetServer("xnarapbo");
            m_cPhName = m_Ctx.GetPhName("xnarapbo");
            if (Cursor_xnarapbo!=null)
              Cursor_xnarapbo.Close();
            Cursor_xnarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapp_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xnarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xnarapbo.Eof())) {
              /* Case xnarapbo->FLAGLIRE='1' or xnarapbo->FLAGLIRE='L' */
              if (CPLib.eqr(Cursor_xnarapbo.GetString("FLAGLIRE"),"1") || CPLib.eqr(Cursor_xnarapbo.GetString("FLAGLIRE"),"L")) {
                /* _note := _note + '1' + '018' */
                _note = _note+"1"+"018";
                /* Case xnarapbo->FLAGLIRE='2' or xnarapbo->FLAGLIRE='V' */
              } else if (CPLib.eqr(Cursor_xnarapbo.GetString("FLAGLIRE"),"2") || CPLib.eqr(Cursor_xnarapbo.GetString("FLAGLIRE"),"V")) {
                /* _note := _note + '2' + Left(LRTrim(xnarapbo->VALUTA)+Space(3),3) */
                _note = _note+"2"+CPLib.Left(CPLib.LRTrim(Cursor_xnarapbo.GetString("VALUTA"))+CPLib.Space(3),3);
              } else { // Otherwise
                /* _note := _note + '3' + '242' */
                _note = _note+"3"+"242";
              } // End Case
              Cursor_xnarapbo.Next();
            }
            m_cConnectivityError = Cursor_xnarapbo.ErrorMessage();
            Cursor_xnarapbo.Close();
            // * --- End Select
            /* _note := _note + Left(LRTrim(qbe_rapp_chkdiana->SEGNO)+" ",1) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("SEGNO"))+" ",1);
            /* _note := _note +  Right('000000000000000'+LRTrim(Str(qbe_rapp_chkdiana->TOTLIRE,15,0)),15) + Right('000000000000000'+LRTrim(Str(qbe_rapp_chkdiana->TOTCONT,15,0)),15) + Space(69) */
            _note = _note+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_rapp_chkdiana.GetDouble("TOTLIRE"),15,0)),15)+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_rapp_chkdiana.GetDouble("TOTCONT"),15,0)),15)+CPLib.Space(69);
            /* If w_flgchk='S' */
            if (CPLib.eqr(w_flgchk,"S")) {
              /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
              Page_15();
            } else { // Else
              /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
              FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
            } // End If
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nTotReg := nTotReg + 1 */
            nTotReg = CPLib.Round(nTotReg+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
            /* Case qbe_rapp_chkdiana->TIPOOPRAP='25' or qbe_rapp_chkdiana->TIPOOPRAP='28' */
            if (CPLib.eqr(Cursor_qbe_rapp_chkdiana.GetString("TIPOOPRAP"),"25") || CPLib.eqr(Cursor_qbe_rapp_chkdiana.GetString("TIPOOPRAP"),"28")) {
              /* If qbe_rapp_chkdiana->TIPOOPRAP='25' */
              if (CPLib.eqr(Cursor_qbe_rapp_chkdiana.GetString("TIPOOPRAP"),"25")) {
                /* If w_flgint = 'S' */
                if (CPLib.eqr(w_flgint,"S")) {
                  // * --- Select from xntestbo
                  m_cServer = m_Ctx.GetServer("xntestbo");
                  m_cPhName = m_Ctx.GetPhName("xntestbo");
                  if (Cursor_xntestbo!=null)
                    Cursor_xntestbo.Close();
                  Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapp_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_xntestbo.Eof())) {
                    /* If xntestbo->DATAINI <= qbe_rapp_chkdiana->DATAOPE and (xntestbo->DATAFINE >= qbe_rapp_chkdiana->DATAOPE or Empty(xntestbo->DATAFINE)) */
                    if (CPLib.le(Cursor_xntestbo.GetDate("DATAINI"),Cursor_qbe_rapp_chkdiana.GetDate("DATAOPE")) && (CPLib.ge(Cursor_xntestbo.GetDate("DATAFINE"),Cursor_qbe_rapp_chkdiana.GetDate("DATAOPE")) || CPLib.Empty(Cursor_xntestbo.GetDate("DATAFINE")))) {
                      /* _note := w_tipinter + w_codinter+'2'+_idereg */
                      _note = w_tipinter+w_codinter+"2"+_idereg;
                      /* _note := _note + LRTrim(arfn_datisog_sol(xntestbo->CODINTER,qbe_rapp_chkdiana->DATAREG,qbe_rapp_chkdiana->RAPPORTO,qbe_rapp_chkdiana->FLAGRAP,'2',w_flgrae,qbe_rapp_chkdiana->STATOREG,qbe_rapp_chkdiana->DATARETT)) */
                      _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_xntestbo.GetString("CODINTER"),Cursor_qbe_rapp_chkdiana.GetDate("DATAREG"),Cursor_qbe_rapp_chkdiana.GetString("RAPPORTO"),Cursor_qbe_rapp_chkdiana.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_rapp_chkdiana.GetString("STATOREG"),Cursor_qbe_rapp_chkdiana.GetDate("DATARETT")));
                      /* If w_flgchk='S' */
                      if (CPLib.eqr(w_flgchk,"S")) {
                        /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                        Page_15();
                      } else { // Else
                        /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                        FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                      } // End If
                      /* nTotRec := nTotRec + 1 */
                      nTotRec = CPLib.Round(nTotRec+1,0);
                      /* nNumRec := nNumRec + 1 */
                      nNumRec = CPLib.Round(nNumRec+1,0);
                    } // End If
                    Cursor_xntestbo.Next();
                  }
                  m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
                  Cursor_xntestbo.Close();
                  // * --- End Select
                } // End If
                // * --- Select from xelegabo
                m_cServer = m_Ctx.GetServer("xelegabo");
                m_cPhName = m_Ctx.GetPhName("xelegabo");
                if (Cursor_xelegabo!=null)
                  Cursor_xelegabo.Close();
                Cursor_xelegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapp_chkdiana.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG1="+CPLib.ToSQL(Cursor_qbe_rapp_chkdiana.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xelegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_xelegabo.Eof())) {
                  /* _avanza := 0 */
                  _avanza = CPLib.Round(0,0);
                  /* If Empty(xelegabo->CODINTER) */
                  if (CPLib.Empty(Cursor_xelegabo.GetString("CODINTER"))) {
                    /* _avanza := 1 */
                    _avanza = CPLib.Round(1,0);
                  } // End If
                  /* If _avanza=0 */
                  if (CPLib.eqr(_avanza,0)) {
                    /* _note := w_tipinter + w_codinter+'4'+_idereg */
                    _note = w_tipinter+w_codinter+"4"+_idereg;
                    /* _note := _note + LRTrim(arfn_datisog_sol(xelegabo->CODINTER,qbe_rapp_chkdiana->DATAREG,qbe_rapp_chkdiana->RAPPORTO,qbe_rapp_chkdiana->FLAGRAP,'4',w_flgrae,qbe_rapp_chkdiana->STATOREG,qbe_rapp_chkdiana->DATARETT)) */
                    _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_xelegabo.GetString("CODINTER"),Cursor_qbe_rapp_chkdiana.GetDate("DATAREG"),Cursor_qbe_rapp_chkdiana.GetString("RAPPORTO"),Cursor_qbe_rapp_chkdiana.GetString("FLAGRAP"),"4",w_flgrae,Cursor_qbe_rapp_chkdiana.GetString("STATOREG"),Cursor_qbe_rapp_chkdiana.GetDate("DATARETT")));
                    /* If w_flgchk='S' */
                    if (CPLib.eqr(w_flgchk,"S")) {
                      /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                      Page_15();
                    } else { // Else
                      /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                      FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                    } // End If
                    /* nTotRec := nTotRec + 1 */
                    nTotRec = CPLib.Round(nTotRec+1,0);
                    /* nNumRec := nNumRec + 1 */
                    nNumRec = CPLib.Round(nNumRec+1,0);
                  } // End If
                  Cursor_xelegabo.Next();
                }
                m_cConnectivityError = Cursor_xelegabo.ErrorMessage();
                Cursor_xelegabo.Close();
                // * --- End Select
              } else { // Else
                /* If w_flgint = 'S' */
                if (CPLib.eqr(w_flgint,"S")) {
                  // * --- Select from xntestbo
                  m_cServer = m_Ctx.GetServer("xntestbo");
                  m_cPhName = m_Ctx.GetPhName("xntestbo");
                  if (Cursor_xntestbo!=null)
                    Cursor_xntestbo.Close();
                  Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapp_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_xntestbo.Eof())) {
                    /* If xntestbo->DATAINI <= qbe_rapp_chkdiana->DATAOPE and (xntestbo->DATAFINE >= qbe_rapp_chkdiana->DATAOPE or Empty(xntestbo->DATAFINE)) */
                    if (CPLib.le(Cursor_xntestbo.GetDate("DATAINI"),Cursor_qbe_rapp_chkdiana.GetDate("DATAOPE")) && (CPLib.ge(Cursor_xntestbo.GetDate("DATAFINE"),Cursor_qbe_rapp_chkdiana.GetDate("DATAOPE")) || CPLib.Empty(Cursor_xntestbo.GetDate("DATAFINE")))) {
                      /* _note := w_tipinter + w_codinter+'2'+_idereg */
                      _note = w_tipinter+w_codinter+"2"+_idereg;
                      /* _note := _note + LRTrim(arfn_datisog_sol(xntestbo->CODINTER,qbe_rapp_chkdiana->DATAREG,qbe_rapp_chkdiana->RAPPORTO,qbe_rapp_chkdiana->FLAGRAP,'2',w_flgrae,qbe_rapp_chkdiana->STATOREG,qbe_rapp_chkdiana->DATARETT)) */
                      _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_xntestbo.GetString("CODINTER"),Cursor_qbe_rapp_chkdiana.GetDate("DATAREG"),Cursor_qbe_rapp_chkdiana.GetString("RAPPORTO"),Cursor_qbe_rapp_chkdiana.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_rapp_chkdiana.GetString("STATOREG"),Cursor_qbe_rapp_chkdiana.GetDate("DATARETT")));
                      /* If w_flgchk='S' */
                      if (CPLib.eqr(w_flgchk,"S")) {
                        /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                        Page_15();
                      } else { // Else
                        /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                        FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                      } // End If
                      /* nTotRec := nTotRec + 1 */
                      nTotRec = CPLib.Round(nTotRec+1,0);
                      /* nNumRec := nNumRec + 1 */
                      nNumRec = CPLib.Round(nNumRec+1,0);
                    } // End If
                    Cursor_xntestbo.Next();
                  }
                  m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
                  Cursor_xntestbo.Close();
                  // * --- End Select
                } // End If
                // * --- Select from xelegabo
                m_cServer = m_Ctx.GetServer("xelegabo");
                m_cPhName = m_Ctx.GetPhName("xelegabo");
                if (Cursor_xelegabo!=null)
                  Cursor_xelegabo.Close();
                Cursor_xelegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapp_chkdiana.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG2="+CPLib.ToSQL(Cursor_qbe_rapp_chkdiana.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xelegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_xelegabo.Eof())) {
                  /* _avanza := 0 */
                  _avanza = CPLib.Round(0,0);
                  /* If Empty(xelegabo->CODINTER) */
                  if (CPLib.Empty(Cursor_xelegabo.GetString("CODINTER"))) {
                    /* _avanza := 1 */
                    _avanza = CPLib.Round(1,0);
                  } // End If
                  /* If _avanza=0 */
                  if (CPLib.eqr(_avanza,0)) {
                    /* _note := w_tipinter + w_codinter+'4'+_idereg */
                    _note = w_tipinter+w_codinter+"4"+_idereg;
                    /* _note := _note + LRTrim(arfn_datisog_sol(xelegabo->CODINTER,qbe_rapp_chkdiana->DATAREG,qbe_rapp_chkdiana->RAPPORTO,qbe_rapp_chkdiana->FLAGRAP,'4',w_flgrae,qbe_rapp_chkdiana->STATOREG,qbe_rapp_chkdiana->DATARETT)) */
                    _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_xelegabo.GetString("CODINTER"),Cursor_qbe_rapp_chkdiana.GetDate("DATAREG"),Cursor_qbe_rapp_chkdiana.GetString("RAPPORTO"),Cursor_qbe_rapp_chkdiana.GetString("FLAGRAP"),"4",w_flgrae,Cursor_qbe_rapp_chkdiana.GetString("STATOREG"),Cursor_qbe_rapp_chkdiana.GetDate("DATARETT")));
                    /* If w_flgchk='S' */
                    if (CPLib.eqr(w_flgchk,"S")) {
                      /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                      Page_15();
                    } else { // Else
                      /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                      FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                    } // End If
                    /* nTotRec := nTotRec + 1 */
                    nTotRec = CPLib.Round(nTotRec+1,0);
                    /* nNumRec := nNumRec + 1 */
                    nNumRec = CPLib.Round(nNumRec+1,0);
                  } // End If
                  Cursor_xelegabo.Next();
                }
                m_cConnectivityError = Cursor_xelegabo.ErrorMessage();
                Cursor_xelegabo.Close();
                // * --- End Select
              } // End If
              /* Case Right(qbe_rapp_chkdiana->TIPOOPRAP,1)='6' or qbe_rapp_chkdiana->TIPOOPRAP='38' */
            } else if (CPLib.eqr(CPLib.Right(Cursor_qbe_rapp_chkdiana.GetString("TIPOOPRAP"),1),"6") || CPLib.eqr(Cursor_qbe_rapp_chkdiana.GetString("TIPOOPRAP"),"38")) {
              // * --- Select from xntestbo
              m_cServer = m_Ctx.GetServer("xntestbo");
              m_cPhName = m_Ctx.GetPhName("xntestbo");
              if (Cursor_xntestbo!=null)
                Cursor_xntestbo.Close();
              Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapp_chkdiana.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG2="+CPLib.ToSQL(Cursor_qbe_rapp_chkdiana.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_xntestbo.Eof())) {
                /* _avanza := 0 */
                _avanza = CPLib.Round(0,0);
                /* If Empty(xntestbo->CODINTER) */
                if (CPLib.Empty(Cursor_xntestbo.GetString("CODINTER"))) {
                  /* _avanza := 1 */
                  _avanza = CPLib.Round(1,0);
                } // End If
                /* If _avanza=0 */
                if (CPLib.eqr(_avanza,0)) {
                  /* _note := w_tipinter + w_codinter+'2'+_idereg */
                  _note = w_tipinter+w_codinter+"2"+_idereg;
                  /* _note := _note + LRTrim(arfn_datisog_sol(xntestbo->CODINTER,qbe_rapp_chkdiana->DATAREG,qbe_rapp_chkdiana->RAPPORTO,qbe_rapp_chkdiana->FLAGRAP,'2',w_flgrae,qbe_rapp_chkdiana->STATOREG,qbe_rapp_chkdiana->DATARETT)) */
                  _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_xntestbo.GetString("CODINTER"),Cursor_qbe_rapp_chkdiana.GetDate("DATAREG"),Cursor_qbe_rapp_chkdiana.GetString("RAPPORTO"),Cursor_qbe_rapp_chkdiana.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_rapp_chkdiana.GetString("STATOREG"),Cursor_qbe_rapp_chkdiana.GetDate("DATARETT")));
                  /* If w_flgchk='S' */
                  if (CPLib.eqr(w_flgchk,"S")) {
                    /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                    Page_15();
                  } else { // Else
                    /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                    FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                  } // End If
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                } // End If
                Cursor_xntestbo.Next();
              }
              m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
              Cursor_xntestbo.Close();
              // * --- End Select
              /* Case qbe_rapp_chkdiana->TIPOOPRAP='31' or qbe_rapp_chkdiana->TIPOOPRAP='32' */
            } else if (CPLib.eqr(Cursor_qbe_rapp_chkdiana.GetString("TIPOOPRAP"),"31") || CPLib.eqr(Cursor_qbe_rapp_chkdiana.GetString("TIPOOPRAP"),"32")) {
              // * --- Select from xntestbo
              m_cServer = m_Ctx.GetServer("xntestbo");
              m_cPhName = m_Ctx.GetPhName("xntestbo");
              if (Cursor_xntestbo!=null)
                Cursor_xntestbo.Close();
              Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapp_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_xntestbo.Eof())) {
                /* _avanza := 0 */
                _avanza = CPLib.Round(0,0);
                /* If Empty(xntestbo->CODINTER) */
                if (CPLib.Empty(Cursor_xntestbo.GetString("CODINTER"))) {
                  /* _avanza := 1 */
                  _avanza = CPLib.Round(1,0);
                } // End If
                /* If _avanza=0 */
                if (CPLib.eqr(_avanza,0)) {
                  /* _note := w_tipinter + w_codinter+'2'+_idereg */
                  _note = w_tipinter+w_codinter+"2"+_idereg;
                  /* If qbe_rapp_chkdiana->TIPOOPRAP='31' */
                  if (CPLib.eqr(Cursor_qbe_rapp_chkdiana.GetString("TIPOOPRAP"),"31")) {
                    /* _note := _note + LRTrim(arfn_datisog_sol(xntestbo->CODINTER,arfn_dateminus(qbe_rapp_chkdiana->DATAREG,1),qbe_rapp_chkdiana->RAPPORTO,qbe_rapp_chkdiana->FLAGRAP,'2',w_flgrae,qbe_rapp_chkdiana->STATOREG,qbe_rapp_chkdiana->DATARETT)) */
                    _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_xntestbo.GetString("CODINTER"),arfn_dateminusR.Make(m_Ctx,this).Run(Cursor_qbe_rapp_chkdiana.GetDate("DATAREG"),1),Cursor_qbe_rapp_chkdiana.GetString("RAPPORTO"),Cursor_qbe_rapp_chkdiana.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_rapp_chkdiana.GetString("STATOREG"),Cursor_qbe_rapp_chkdiana.GetDate("DATARETT")));
                    /* ElseIf qbe_rapp_chkdiana->TIPOOPRAP='32' */
                  } else if (CPLib.eqr(Cursor_qbe_rapp_chkdiana.GetString("TIPOOPRAP"),"32")) {
                    /* _note := _note + LRTrim(arfn_datisog_sol(xntestbo->CODINTER,qbe_rapp_chkdiana->DATAREG,qbe_rapp_chkdiana->RAPPORTO,qbe_rapp_chkdiana->FLAGRAP,'2',w_flgrae,qbe_rapp_chkdiana->STATOREG,qbe_rapp_chkdiana->DATARETT)) */
                    _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_xntestbo.GetString("CODINTER"),Cursor_qbe_rapp_chkdiana.GetDate("DATAREG"),Cursor_qbe_rapp_chkdiana.GetString("RAPPORTO"),Cursor_qbe_rapp_chkdiana.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_rapp_chkdiana.GetString("STATOREG"),Cursor_qbe_rapp_chkdiana.GetDate("DATARETT")));
                  } // End If
                  /* If w_flgchk='S' */
                  if (CPLib.eqr(w_flgchk,"S")) {
                    /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                    Page_15();
                  } else { // Else
                    /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                    FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                  } // End If
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                } // End If
                Cursor_xntestbo.Next();
              }
              m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
              Cursor_xntestbo.Close();
              // * --- End Select
              /* If w_flgdel = 'S' */
              if (CPLib.eqr(w_flgdel,"S")) {
                // * --- Select from xelegabo
                m_cServer = m_Ctx.GetServer("xelegabo");
                m_cPhName = m_Ctx.GetPhName("xelegabo");
                if (Cursor_xelegabo!=null)
                  Cursor_xelegabo.Close();
                Cursor_xelegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapp_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xelegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_xelegabo.Eof())) {
                  /* _avanza := 0 */
                  _avanza = CPLib.Round(0,0);
                  /* If Empty(xelegabo->CODINTER) */
                  if (CPLib.Empty(Cursor_xelegabo.GetString("CODINTER"))) {
                    /* _avanza := 1 */
                    _avanza = CPLib.Round(1,0);
                  } // End If
                  /* If _avanza=0 */
                  if (CPLib.eqr(_avanza,0)) {
                    /* _note := w_tipinter + w_codinter+'4'+_idereg */
                    _note = w_tipinter+w_codinter+"4"+_idereg;
                    /* If qbe_rapd_chkdiana->TIPOOPRAP='31' */
                    if (CPLib.eqr(Cursor_qbe_rapd_chkdiana.GetString("TIPOOPRAP"),"31")) {
                      /* _note := _note + LRTrim(arfn_datisog_sol(xelegabo->CODINTER,arfn_dateminus(qbe_rapp_chkdiana->DATAREG,1),qbe_rapp_chkdiana->RAPPORTO,qbe_rapp_chkdiana->FLAGRAP,'4',w_flgrae,qbe_rapp_chkdiana->STATOREG,qbe_rapp_chkdiana->DATARETT)) */
                      _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_xelegabo.GetString("CODINTER"),arfn_dateminusR.Make(m_Ctx,this).Run(Cursor_qbe_rapp_chkdiana.GetDate("DATAREG"),1),Cursor_qbe_rapp_chkdiana.GetString("RAPPORTO"),Cursor_qbe_rapp_chkdiana.GetString("FLAGRAP"),"4",w_flgrae,Cursor_qbe_rapp_chkdiana.GetString("STATOREG"),Cursor_qbe_rapp_chkdiana.GetDate("DATARETT")));
                      /* ElseIf qbe_rapd_chkdiana->TIPOOPRAP='32' */
                    } else if (CPLib.eqr(Cursor_qbe_rapd_chkdiana.GetString("TIPOOPRAP"),"32")) {
                      /* _note := _note + LRTrim(arfn_datisog_sol(xelegabo->CODINTER,qbe_rapp_chkdiana->DATAREG,qbe_rapp_chkdiana->RAPPORTO,qbe_rapp_chkdiana->FLAGRAP,'4',w_flgrae,qbe_rapp_chkdiana->STATOREG,qbe_rapp_chkdiana->DATARETT)) */
                      _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_xelegabo.GetString("CODINTER"),Cursor_qbe_rapp_chkdiana.GetDate("DATAREG"),Cursor_qbe_rapp_chkdiana.GetString("RAPPORTO"),Cursor_qbe_rapp_chkdiana.GetString("FLAGRAP"),"4",w_flgrae,Cursor_qbe_rapp_chkdiana.GetString("STATOREG"),Cursor_qbe_rapp_chkdiana.GetDate("DATARETT")));
                    } // End If
                    /* If w_flgchk='S' */
                    if (CPLib.eqr(w_flgchk,"S")) {
                      /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                      Page_15();
                    } else { // Else
                      /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                      FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                    } // End If
                    /* nTotRec := nTotRec + 1 */
                    nTotRec = CPLib.Round(nTotRec+1,0);
                    /* nNumRec := nNumRec + 1 */
                    nNumRec = CPLib.Round(nNumRec+1,0);
                  } // End If
                  Cursor_xelegabo.Next();
                }
                m_cConnectivityError = Cursor_xelegabo.ErrorMessage();
                Cursor_xelegabo.Close();
                // * --- End Select
              } // End If
            } else { // Otherwise
              // * --- Select from xntestbo
              m_cServer = m_Ctx.GetServer("xntestbo");
              m_cPhName = m_Ctx.GetPhName("xntestbo");
              if (Cursor_xntestbo!=null)
                Cursor_xntestbo.Close();
              Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapp_chkdiana.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG1="+CPLib.ToSQL(Cursor_qbe_rapp_chkdiana.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_xntestbo.Eof())) {
                /* _avanza := 0 */
                _avanza = CPLib.Round(0,0);
                /* If Empty(xntestbo->CODINTER) */
                if (CPLib.Empty(Cursor_xntestbo.GetString("CODINTER"))) {
                  /* _avanza := 1 */
                  _avanza = CPLib.Round(1,0);
                } // End If
                /* If _avanza=0 */
                if (CPLib.eqr(_avanza,0)) {
                  /* _note := w_tipinter + w_codinter+'2'+_idereg */
                  _note = w_tipinter+w_codinter+"2"+_idereg;
                  /* _note := _note + LRTrim(arfn_datisog_sol(xntestbo->CODINTER,qbe_rapp_chkdiana->DATAREG,qbe_rapp_chkdiana->RAPPORTO,qbe_rapp_chkdiana->FLAGRAP,'2',w_flgrae,qbe_rapp_chkdiana->STATOREG,qbe_rapp_chkdiana->DATARETT)) */
                  _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_xntestbo.GetString("CODINTER"),Cursor_qbe_rapp_chkdiana.GetDate("DATAREG"),Cursor_qbe_rapp_chkdiana.GetString("RAPPORTO"),Cursor_qbe_rapp_chkdiana.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_rapp_chkdiana.GetString("STATOREG"),Cursor_qbe_rapp_chkdiana.GetDate("DATARETT")));
                  /* If w_flgchk='S' */
                  if (CPLib.eqr(w_flgchk,"S")) {
                    /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                    Page_15();
                  } else { // Else
                    /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                    FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                  } // End If
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                } // End If
                Cursor_xntestbo.Next();
              }
              m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
              Cursor_xntestbo.Close();
              // * --- End Select
            } // End Case
          } // End If
          Cursor_qbe_rapp_chkdiana.Next();
        }
        m_cConnectivityError = Cursor_qbe_rapp_chkdiana.ErrorMessage();
        Cursor_qbe_rapp_chkdiana.Close();
        // * --- End Select
      } // End If
    } finally {
      try {
        if (Cursor_qbe_rapd_chkdiana!=null)
          Cursor_qbe_rapd_chkdiana.Close();
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
        if (Cursor_anarapbo!=null)
          Cursor_anarapbo.Close();
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
        if (Cursor_anadip!=null)
          Cursor_anadip.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_delegabo!=null)
          Cursor_delegabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_rapp_chkdiana!=null)
          Cursor_qbe_rapp_chkdiana.Close();
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
        if (Cursor_xnarapbo!=null)
          Cursor_xnarapbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xelegabo!=null)
          Cursor_xelegabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_4() throws Exception {
    /* Cicla sulle frazionate */
    /* If w_tipoarch = 'D' */
    if (CPLib.eqr(w_tipoarch,"D")) {
      /* If Empty(LRTrim(w_codcli)) */
      if (CPLib.Empty(CPLib.LRTrim(w_codcli))) {
        /* Exec "Frazionate Definitive" Page 8:Page_9 */
        Page_9();
      } else { // Else
        /* Exec "Frazionate Definitive Cliente" Page 12:Page_13 */
        Page_13();
      } // End If
    } else { // Else
      /* If Empty(LRTrim(w_codcli)) */
      if (CPLib.Empty(CPLib.LRTrim(w_codcli))) {
        /* Exec "Frazionate Provvisorie" Page 9:Page_10 */
        Page_10();
      } else { // Else
        /* Exec "Frazionate Provvisorie Cliente" Page 13:Page_14 */
        Page_14();
      } // End If
    } // End If
  }
  void Page_6() throws Exception {
    // Qui vengono scritti i file da inserire nello zip
        String[] filenames = new String[]{cNomeFile};
        
        // Crea un buffer per la lettura dei file
        byte[] buf = new byte[1024];
        
        try {
            // Creail file ZIP
            String outFilename = cNomeFileZip;
            java.util.zip.ZipOutputStream out = new java.util.zip.ZipOutputStream(new java.io.FileOutputStream(outFilename));
        
            // Comprime i file
            for (int i=0; i<filenames.length; i++) {
                java.io.FileInputStream in = new java.io.FileInputStream(filenames[i]);
        
                // Apre il file da aggiungere allo ZIP
                out.putNextEntry(new java.util.zip.ZipEntry(cOnlyNomeFile));
        
                // Trasferisce i dati da i file allo ZIP
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
        
                // Chiude il file
                out.closeEntry();
                in.close();
            }
        
            // Chiude il file ZIP
            out.close();
        } catch (java.io.IOException e) {
        }
    
  }
  void Page_7() throws Exception {
    CPResultSet Cursor_qbe_oped_chkdiana_limits=null;
    CPResultSet Cursor_qbe_oped_chkdiana=null;
    CPResultSet Cursor_anarapbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_anadip=null;
    CPResultSet Cursor_kersonbo=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_mlientiope=null;
    CPResultSet Cursor_clientiope=null;
    CPResultSet Cursor_mogopebo=null;
    CPResultSet Cursor_sogopebo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_meneficope=null;
    CPResultSet Cursor_beneficope=null;
    CPResultSet Cursor_merzistiope=null;
    CPResultSet Cursor_terzistiope=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Cicla sulle operazioni */
      /* gMsgImp := 'Verifica Operazioni da elaborare ...' // Messaggio Import */
      gMsgImp = "Verifica Operazioni da elaborare ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* _max := 0 */
      _max = CPLib.Round(0,0);
      /* _min := 0 */
      _min = CPLib.Round(0,0);
      /* _ciclo := 0 */
      _ciclo = CPLib.Round(0,0);
      /* Prima gli italiani */
      // * --- Select from qbe_oped_chkdiana_limits
      SPBridge.HMCaller _hUPIGFPJLSM;
      _hUPIGFPJLSM = new SPBridge.HMCaller();
      _hUPIGFPJLSM.Set("m_cVQRList",m_cVQRList);
      _hUPIGFPJLSM.Set("cdadata",w_cdadata);
      _hUPIGFPJLSM.Set("c_adata",w_c_adata);
      _hUPIGFPJLSM.Set("codage",w_codage);
      _hUPIGFPJLSM.Set("codcli",w_codcli);
      _hUPIGFPJLSM.Set("ragben",w_ragben);
      if (Cursor_qbe_oped_chkdiana_limits!=null)
        Cursor_qbe_oped_chkdiana_limits.Close();
      Cursor_qbe_oped_chkdiana_limits = new VQRHolder("qbe_oped_chkdiana_limits",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_hUPIGFPJLSM,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_oped_chkdiana_limits.Eof())) {
        /* _max := qbe_oped_chkdiana_limits->MAXOPE */
        _max = CPLib.Round(Cursor_qbe_oped_chkdiana_limits.GetDouble("MAXOPE"),0);
        /* _min := qbe_oped_chkdiana_limits->MINOPE */
        _min = CPLib.Round(Cursor_qbe_oped_chkdiana_limits.GetDouble("MINOPE"),0);
        Cursor_qbe_oped_chkdiana_limits.Next();
      }
      m_cConnectivityError = Cursor_qbe_oped_chkdiana_limits.ErrorMessage();
      Cursor_qbe_oped_chkdiana_limits.Close();
      // * --- End Select
      /* _cicli := iif(Mod(_max,5000) <> 0,Int(_max/5000) + 1,Int(_max/5000)) */
      _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,5000),0)?CPLib.Int(_max/5000)+1:CPLib.Int(_max/5000)),0);
      /* _bottom := _min */
      _bottom = CPLib.Round(_min,0);
      /* If _min > 5000 */
      if (CPLib.gt(_min,5000)) {
        /* _contacilci := Int(_min/5000) + 1 */
        _contacilci = CPLib.Round(CPLib.Int(_min/5000)+1,0);
      } else { // Else
        /* _contacilci := 1 */
        _contacilci = CPLib.Round(1,0);
      } // End If
      /* gMsgImp := 'Lettura operazioni in corso ...' // Messaggio Import */
      gMsgImp = "Lettura operazioni in corso ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* While _contacilci<=_cicli */
      while (CPLib.le(_contacilci,_cicli)) {
        /* _bottom := iif(_ciclo=0,_bottom,((_contacilci -1 ) * 5000) + 1) */
        _bottom = CPLib.Round((CPLib.eqr(_ciclo,0)?_bottom:((_contacilci-1)*5000)+1),0);
        /* _top := _contacilci * 5000 */
        _top = CPLib.Round(_contacilci*5000,0);
        /* _ciclo := 1 */
        _ciclo = CPLib.Round(1,0);
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
        /* gMsgImp := 'Lettura operazioni in corso ... Ciclo N. '+LRTrim(Str(_contacilci,10,0)) // Messaggio Import */
        gMsgImp = "Lettura operazioni in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacilci,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* Cicla sulle operazioni */
        // * --- Select from qbe_oped_chkdiana
        SPBridge.HMCaller _hRZIHAQHWPK;
        _hRZIHAQHWPK = new SPBridge.HMCaller();
        _hRZIHAQHWPK.Set("m_cVQRList",m_cVQRList);
        _hRZIHAQHWPK.Set("cdadata",w_cdadata);
        _hRZIHAQHWPK.Set("c_adata",w_c_adata);
        _hRZIHAQHWPK.Set("codage",w_codage);
        _hRZIHAQHWPK.Set("_bottom",_bottom);
        _hRZIHAQHWPK.Set("_top",_top);
        _hRZIHAQHWPK.Set("codcli",w_codcli);
        _hRZIHAQHWPK.Set("ragben",w_ragben);
        if (Cursor_qbe_oped_chkdiana!=null)
          Cursor_qbe_oped_chkdiana.Close();
        Cursor_qbe_oped_chkdiana = new VQRHolder("qbe_oped_chkdiana",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_hRZIHAQHWPK,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_oped_chkdiana.Eof())) {
          /* _ctotale := _ctotale + 1 */
          _ctotale = CPLib.Round(_ctotale+1,0);
          /* gMsgImp := 'Elaborazione Operazione N.: '+LRTrim(Str(_ctotale,15,0)) // Messaggio Import */
          gMsgImp = "Elaborazione Operazione N.: "+CPLib.LRTrim(CPLib.Str(_ctotale,15,0));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* If Empty(LRTrim(qbe_oped_chkdiana->FLAGRAP2)) */
          if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("FLAGRAP2")))) {
            /* _idereg := DateToChar(qbe_oped_chkdiana->DATAOPE) + "O" + Right(qbe_oped_chkdiana->NUMPROG,10) + 'S' */
            _idereg = CPLib.DateToChar(Cursor_qbe_oped_chkdiana.GetDate("DATAOPE"))+"O"+CPLib.Right(Cursor_qbe_oped_chkdiana.GetString("NUMPROG"),10)+"S";
          } else { // Else
            /* _idereg := Left(qbe_oped_chkdiana->IDEREG,8) + "O" + Right(qbe_oped_chkdiana->IDEREG,11) */
            _idereg = CPLib.Left(Cursor_qbe_oped_chkdiana.GetString("IDEREG"),8)+"O"+CPLib.Right(Cursor_qbe_oped_chkdiana.GetString("IDEREG"),11);
          } // End If
          /* _note := w_tipinter + w_codinter + '1' + _idereg */
          _note = w_tipinter+w_codinter+"1"+_idereg;
          /* _flagrap := '' */
          _flagrap = "";
          // * --- Select from anarapbo
          m_cServer = m_Ctx.GetServer("anarapbo");
          m_cPhName = m_Ctx.GetPhName("anarapbo");
          if (Cursor_anarapbo!=null)
            Cursor_anarapbo.Close();
          Cursor_anarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select TIPORAP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("anarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_anarapbo.Eof())) {
            /* _flagrap := anarapbo->TIPORAP */
            _flagrap = Cursor_anarapbo.GetString("TIPORAP");
            Cursor_anarapbo.Next();
          }
          m_cConnectivityError = Cursor_anarapbo.ErrorMessage();
          Cursor_anarapbo.Close();
          // * --- End Select
          /* _flagrap := iif(Empty(LRTrim(_flagrap)),qbe_oped_chkdiana->FLAGRAP,_flagrap) */
          _flagrap = (CPLib.Empty(CPLib.LRTrim(_flagrap))?Cursor_qbe_oped_chkdiana.GetString("FLAGRAP"):_flagrap);
          /* If Empty(qbe_oped_chkdiana->CODDIPE) */
          if (CPLib.Empty(Cursor_qbe_oped_chkdiana.GetString("CODDIPE"))) {
            // * --- Read from intermbo
            m_cServer = m_Ctx.GetServer("intermbo");
            m_cPhName = m_Ctx.GetPhName("intermbo");
            m_cSql = "";
            m_cSql = m_cSql+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codinter,"C",11,0,m_cServer),m_cServer,w_codinter);
            if (m_Ctx.IsSharedTemp("intermbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODCAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODDIPE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              w_codcab = Read_Cursor.GetString("CODCAB");
              w_desccit = Read_Cursor.GetString("DESCCIT");
              w_provin = Read_Cursor.GetString("PROVINCIA");
              w_coddipe = Read_Cursor.GetString("CODDIPE");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on intermbo into routine arrt_chkdiana_old returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              w_codcab = "";
              w_desccit = "";
              w_provin = "";
              w_coddipe = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(w_coddipe) */
            if (CPLib.Empty(w_coddipe)) {
              /* _note := _note + '000000' + Left(LRTrim(w_codcab)+Space(6),6) + Left(LRTrim(w_desccit)+Space(30),30) + Left(LRTrim(w_provin)+Space(2),2) */
              _note = _note+"000000"+CPLib.Left(CPLib.LRTrim(w_codcab)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(w_desccit)+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(w_provin)+CPLib.Space(2),2);
            } else { // Else
              /* _note := _note + w_coddipe */
              _note = _note+w_coddipe;
              // * --- Read from anadip
              m_cServer = m_Ctx.GetServer("anadip");
              m_cPhName = m_Ctx.GetPhName("anadip");
              m_cSql = "";
              m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_coddipe,"C",6,0,m_cServer),m_cServer,w_coddipe);
              if (m_Ctx.IsSharedTemp("anadip")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                w_cabcod = Read_Cursor.GetString("CAB");
                w_citdesc = Read_Cursor.GetString("DESCCIT");
                w_provind = Read_Cursor.GetString("PROVINCIA");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on anadip into routine arrt_chkdiana_old returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                w_cabcod = "";
                w_citdesc = "";
                w_provind = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(w_cabcod) */
              if (CPLib.Empty(w_cabcod)) {
                /* _note := _note + Left(LRTrim(w_codcab)+Space(6),6) + Left(LRTrim(w_desccit)+Space(30),30) + Left(LRTrim(w_provin)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(w_codcab)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(w_desccit)+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(w_provin)+CPLib.Space(2),2);
              } else { // Else
                /* _note := _note + Left(LRTrim(w_cabcod)+Space(6),6) + Left(LRTrim(w_citdesc)+Space(30),30) + Left(LRTrim(w_provind)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(w_cabcod)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(w_citdesc)+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(w_provind)+CPLib.Space(2),2);
              } // End If
            } // End If
          } else { // Else
            // * --- Select from anadip
            m_cServer = m_Ctx.GetServer("anadip");
            m_cPhName = m_Ctx.GetPhName("anadip");
            if (Cursor_anadip!=null)
              Cursor_anadip.Close();
            Cursor_anadip = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODDIP="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana.GetString("CODDIPE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("anadip")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_anadip.Eof())) {
              /* _note := _note + qbe_oped_chkdiana->CODDIPE + Left(LRTrim(anadip->CAB)+Space(6),6) + Left(LRTrim(anadip->DESCCIT)+Space(30),30) + Left(LRTrim(anadip->PROVINCIA)+Space(2),2) */
              _note = _note+Cursor_qbe_oped_chkdiana.GetString("CODDIPE")+CPLib.Left(CPLib.LRTrim(Cursor_anadip.GetString("CAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_anadip.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_anadip.GetString("PROVINCIA"))+CPLib.Space(2),2);
              Cursor_anadip.Next();
            }
            m_cConnectivityError = Cursor_anadip.ErrorMessage();
            Cursor_anadip.Close();
            // * --- End Select
          } // End If
          /* _note := _note + Left(DateToChar(qbe_oped_chkdiana->DATAOPE)+Space(8),8) + Left(LRTrim(qbe_oped_chkdiana->FLAGFRAZ)+" ",1) + Left(LRTrim(qbe_oped_chkdiana->FLAGCONT)+" ",1) */
          _note = _note+CPLib.Left(CPLib.DateToChar(Cursor_qbe_oped_chkdiana.GetDate("DATAOPE"))+CPLib.Space(8),8)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("FLAGFRAZ"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("FLAGCONT"))+" ",1);
          /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->CODANA)+Space(4),4) + Left(LRTrim(qbe_oped_chkdiana->CODVOC)+Space(2),2) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("CODANA"))+CPLib.Space(4),4)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("CODVOC"))+CPLib.Space(2),2);
          /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->TIPOINT2)+Space(2),2) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("TIPOINT2"))+CPLib.Space(2),2);
          /* _note := _note + iif(Empty(LRTrim(qbe_oped_chkdiana->CODFISCICP)),Left(LRTrim(qbe_oped_chkdiana->CODINT2)+Space(11),11),Left(LRTrim(qbe_oped_chkdiana->CODFISCICP)+Space(11),11)) */
          _note = _note+(CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("CODFISCICP")))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("CODINT2"))+CPLib.Space(11),11):CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("CODFISCICP"))+CPLib.Space(11),11));
          /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->PAESE)+Space(3),3) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("PAESE"))+CPLib.Space(3),3);
          /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->CODCAB2)+Space(6),6) + Left(LRTrim(arfn_agechar(qbe_oped_chkdiana->DESC2,' '))+Space(30),30) + Left(LRTrim(qbe_oped_chkdiana->PROV2)+Space(2),2) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("CODCAB2"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana.GetString("DESC2")," "))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("PROV2"))+CPLib.Space(2),2);
          /* _note := _note + Left(LRTrim(arfn_agechar(qbe_oped_chkdiana->DESCINTER,' '))+Space(50),50) + Left(LRTrim(arfn_agechar(qbe_oped_chkdiana->RAPPORTO,' '))+Space(25),25) + Left(LRTrim(_flagrap)+" ",1) */
          _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana.GetString("DESCINTER")," "))+CPLib.Space(50),50)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana.GetString("RAPPORTO")," "))+CPLib.Space(25),25)+CPLib.Left(CPLib.LRTrim(_flagrap)+" ",1);
          /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->TIPOLEG)+" ",1) + Left(LRTrim(DateToChar(qbe_oped_chkdiana->DATAREG))+Space(8),8) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("TIPOLEG"))+" ",1)+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_oped_chkdiana.GetDate("DATAREG")))+CPLib.Space(8),8);
          /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->TIPOOPRAP)+Space(2),2) + Left(LRTrim(qbe_oped_chkdiana->COLLEG)+Space(11),11) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("TIPOOPRAP"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("COLLEG"))+CPLib.Space(11),11);
          /* _note := _note + " " + Left(LRTrim(qbe_oped_chkdiana->STATOREG)+" ",1)  */
          _note = _note+" "+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("STATOREG"))+" ",1);
          /* If Empty(qbe_oped_chkdiana->DATARETT) or DateToChar(qbe_oped_chkdiana->DATARETT)='01000101' */
          if (CPLib.Empty(Cursor_qbe_oped_chkdiana.GetDate("DATARETT")) || CPLib.eqr(CPLib.DateToChar(Cursor_qbe_oped_chkdiana.GetDate("DATARETT")),"01000101")) {
            /* _note := _note + Space(8) */
            _note = _note+CPLib.Space(8);
          } else { // Else
            /* _note := _note + Left(LRTrim(DateToChar(qbe_oped_chkdiana->DATARETT))+Space(8),8) */
            _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_oped_chkdiana.GetDate("DATARETT")))+CPLib.Space(8),8);
          } // End If
          /* _note := _note + iif(Empty(LRTrim(qbe_oped_chkdiana->OPERAZMOD)),Space(20),Left(qbe_oped_chkdiana->OPERAZMOD,8)+"O"+Right(qbe_oped_chkdiana->OPERAZMOD,11)) */
          _note = _note+(CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("OPERAZMOD")))?CPLib.Space(20):CPLib.Left(Cursor_qbe_oped_chkdiana.GetString("OPERAZMOD"),8)+"O"+CPLib.Right(Cursor_qbe_oped_chkdiana.GetString("OPERAZMOD"),11));
          /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->FLAGLIRE)+" ",1) + Left(LRTrim(qbe_oped_chkdiana->VALUTA)+Space(3),3) + Left(LRTrim(qbe_oped_chkdiana->SEGNO)+" ",1) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("FLAGLIRE"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("VALUTA"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("SEGNO"))+" ",1);
          /* _note := _note +  Right('000000000000000'+LRTrim(Str(qbe_oped_chkdiana->TOTLIRE,15,0)),15) + Right('000000000000000'+LRTrim(Str(qbe_oped_chkdiana->TOTCONT,15,0)),15) + Space(69) */
          _note = _note+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_oped_chkdiana.GetDouble("TOTLIRE"),15,0)),15)+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_oped_chkdiana.GetDouble("TOTCONT"),15,0)),15)+CPLib.Space(69);
          /* If w_flgchk='S' */
          if (CPLib.eqr(w_flgchk,"S")) {
            /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
            Page_15();
          } else { // Else
            /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
            FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
          } // End If
          /* nTotRec := nTotRec + 1 */
          nTotRec = CPLib.Round(nTotRec+1,0);
          /* nTotReg := nTotReg + 1 */
          nTotReg = CPLib.Round(nTotReg+1,0);
          /* nNumRec := nNumRec + 1 */
          nNumRec = CPLib.Round(nNumRec+1,0);
          /* If not(Empty(qbe_oped_chkdiana->CONNESCLI)) and Empty(LRTrim(qbe_oped_chkdiana->RAPPORTO)) */
          if ( ! (CPLib.Empty(Cursor_qbe_oped_chkdiana.GetString("CONNESCLI"))) && CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("RAPPORTO")))) {
            /* _oldrap := '' */
            _oldrap = "";
            /* _codrif := qbe_oped_chkdiana->CONNESCLI */
            _codrif = Cursor_qbe_oped_chkdiana.GetString("CONNESCLI");
            /* If gFlgWU='S' */
            if (CPLib.eqr(gFlgWU,"S")) {
              // * --- Select from kersonbo
              m_cServer = m_Ctx.GetServer("kersonbo");
              m_cPhName = m_Ctx.GetPhName("kersonbo");
              if (Cursor_kersonbo!=null)
                Cursor_kersonbo.Close();
              Cursor_kersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana.GetString("CONNESDOC"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("kersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_kersonbo.Eof())) {
                /* _ramate := iif(w_flgrae='R',LRTrim(kersonbo->RAMOGRUP),Left(LRTrim(kersonbo->ATTIV),3)) */
                _ramate = (CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_kersonbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("ATTIV")),3));
                /* _note := w_tipinter + w_codinter */
                _note = w_tipinter+w_codinter;
                /* If Empty(qbe_oped_chkdiana->CONNESOPER) or (qbe_oped_chkdiana->CONNESOPER=qbe_oped_chkdiana->CONNESCLI) */
                if (CPLib.Empty(Cursor_qbe_oped_chkdiana.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_oped_chkdiana.GetString("CONNESOPER"),Cursor_qbe_oped_chkdiana.GetString("CONNESCLI")))) {
                  /* _note := _note + '2' */
                  _note = _note+"2";
                } else { // Else
                  /* _note := _note + '3' */
                  _note = _note+"3";
                } // End If
                /* _note := _note + _idereg */
                _note = _note+_idereg;
                /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->CONNESCLI)+Space(16),16) + Left(LRTrim(kersonbo->RAGSOC)+Space(70),70) + Left(LRTrim(kersonbo->PAESE)+Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("CONNESCLI"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("PAESE"))+CPLib.Space(3),3);
                /* _note := _note + Left(LRTrim(kersonbo->CODCAB)+Space(6),6) + Left(LRTrim(kersonbo->DESCCIT)+Space(30),30) + Left(LRTrim(kersonbo->PROVINCIA)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                /* _note := _note + Left(LRTrim(kersonbo->DOMICILIO)+Space(35),35) + Left(LRTrim(kersonbo->CAP)+ Space(5),5) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("CAP"))+CPLib.Space(5),5);
                /* _note := _note + Left(LRTrim(kersonbo->CODFISC)+Space(16),16)  */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("CODFISC"))+CPLib.Space(16),16);
                /* If Empty(kersonbo->DATANASC) or DateToChar(kersonbo->DATANASC)='01000101' */
                if (CPLib.Empty(Cursor_kersonbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_kersonbo.GetDate("DATANASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(kersonbo->DATANASC))+Space(8),8) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_kersonbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                } // End If
                /* If not(Empty(kersonbo->NASSTATO)) */
                if ( ! (CPLib.Empty(Cursor_kersonbo.GetString("NASSTATO")))) {
                  /* _note := _note + Left(LRTrim(kersonbo->NASSTATO)+Space(30),30) + Left(LRTrim(kersonbo->SOTGRUP)+Space(3),3) + Left(LRTrim(_ramate)+Space(3),3) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(_ramate)+CPLib.Space(3),3);
                } else { // Else
                  /* _note := _note + Left(LRTrim(kersonbo->NASCOMUN)+Space(30),30) + Left(LRTrim(kersonbo->SOTGRUP)+Space(3),3) + Left(LRTrim(_ramate) +Space(3),3) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(_ramate)+CPLib.Space(3),3);
                } // End If
                /* _note := _note + Left(LRTrim(kersonbo->SETTSINT)+Space(3),3) + Left(LRTrim(arfn_agechar(qbe_oped_chkdiana->RAPPORTO,' '))+Space(25),25) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana.GetString("RAPPORTO")," "))+CPLib.Space(25),25);
                /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->FLAGRAP)+" ",1) + Left(LRTrim(kersonbo->TIPODOC)+Space(2),2) + Left(LRTrim(kersonbo->NUMDOCUM)+Space(15),15) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                /* If Empty(kersonbo->DATARILASC) or DateToChar(kersonbo->DATARILASC)='01000101' */
                if (CPLib.Empty(Cursor_kersonbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_kersonbo.GetDate("DATARILASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(kersonbo->DATARILASC))+Space(8),8)  */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_kersonbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                } // End If
                /* _note := _note + Left(LRTrim(kersonbo->AUTRILASC)+Space(30),30) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("AUTRILASC"))+CPLib.Space(30),30);
                /* _note := _note + Left(LRTrim(kersonbo->SESSO)+" ",1) + Space(34) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SESSO"))+" ",1)+CPLib.Space(34);
                /* If w_flgchk='S' */
                if (CPLib.eqr(w_flgchk,"S")) {
                  /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                  Page_15();
                } else { // Else
                  /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                  FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                } // End If
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_kersonbo.Next();
              }
              m_cConnectivityError = Cursor_kersonbo.ErrorMessage();
              Cursor_kersonbo.Close();
              // * --- End Select
            } else { // Else
              /* _note := w_tipinter + w_codinter */
              _note = w_tipinter+w_codinter;
              /* If Empty(qbe_oped_chkdiana->CONNESOPER) or (qbe_oped_chkdiana->CONNESOPER=qbe_oped_chkdiana->CONNESCLI) */
              if (CPLib.Empty(Cursor_qbe_oped_chkdiana.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_oped_chkdiana.GetString("CONNESOPER"),Cursor_qbe_oped_chkdiana.GetString("CONNESCLI")))) {
                /* _note := _note + '2' */
                _note = _note+"2";
              } else { // Else
                /* _note := _note + '3' */
                _note = _note+"3";
              } // End If
              /* _note := _note + _idereg */
              _note = _note+_idereg;
              /* _note := _note + LRTrim(arfn_datisog_sol(qbe_oped_chkdiana->CONNESCLI,qbe_oped_chkdiana->DATAREG,qbe_oped_chkdiana->RAPPORTO,qbe_oped_chkdiana->FLAGRAP,'2',w_flgrae,qbe_oped_chkdiana->STATOREG,qbe_oped_chkdiana->DATARETT)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana.GetString("CONNESCLI"),Cursor_qbe_oped_chkdiana.GetDate("DATAREG"),Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_oped_chkdiana.GetString("STATOREG"),Cursor_qbe_oped_chkdiana.GetDate("DATARETT")));
              /* If w_flgchk='S' */
              if (CPLib.eqr(w_flgchk,"S")) {
                /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                Page_15();
              } else { // Else
                /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
              } // End If
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
            } // End If
          } else { // Else
            /* _oldrap := '' */
            _oldrap = "";
            // * --- Read from knarapbo
            m_cServer = m_Ctx.GetServer("knarapbo");
            m_cPhName = m_Ctx.GetPhName("knarapbo");
            m_cSql = "";
            m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"));
            if (m_Ctx.IsSharedTemp("knarapbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _oldrap = Read_Cursor.GetString("RAPPORTO");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on knarapbo into routine arrt_chkdiana_old returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _oldrap = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If not(Empty(_oldrap)) */
            if ( ! (CPLib.Empty(_oldrap))) {
              // * --- Select from intestbo
              m_cServer = m_Ctx.GetServer("intestbo");
              m_cPhName = m_Ctx.GetPhName("intestbo");
              if (Cursor_intestbo!=null)
                Cursor_intestbo.Close();
              Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_intestbo.Eof())) {
                /* If qbe_oped_chkdiana->RAPPORTO = intestbo->RAPPORTO */
                if (CPLib.eqr(Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"),Cursor_intestbo.GetString("RAPPORTO"))) {
                  /* _avanza := 0 */
                  _avanza = CPLib.Round(0,0);
                  /* If Empty(intestbo->CODINTER) or intestbo->STATOREG='2' or intestbo->STATOREG='3' */
                  if (CPLib.Empty(Cursor_intestbo.GetString("CODINTER")) || CPLib.eqr(Cursor_intestbo.GetString("STATOREG"),"2") || CPLib.eqr(Cursor_intestbo.GetString("STATOREG"),"3")) {
                    /* _avanza := 1 */
                    _avanza = CPLib.Round(1,0);
                  } // End If
                  /* If intestbo->DATAINI > qbe_oped_chkdiana->DATAOPE */
                  if (CPLib.gt(Cursor_intestbo.GetDate("DATAINI"),Cursor_qbe_oped_chkdiana.GetDate("DATAOPE"))) {
                    /* _avanza := 1 */
                    _avanza = CPLib.Round(1,0);
                  } // End If
                  /* If not(Empty(intestbo->DATAFINE)) and intestbo->DATAFINE < qbe_oped_chkdiana->DATAOPE */
                  if ( ! (CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE"))) && CPLib.lt(Cursor_intestbo.GetDate("DATAFINE"),Cursor_qbe_oped_chkdiana.GetDate("DATAOPE"))) {
                    /* _avanza := 1 */
                    _avanza = CPLib.Round(1,0);
                  } // End If
                  /* If _avanza = 0 */
                  if (CPLib.eqr(_avanza,0)) {
                    /* _codrif := intestbo->CODINTER */
                    _codrif = Cursor_intestbo.GetString("CODINTER");
                    /* _note := w_tipinter + w_codinter */
                    _note = w_tipinter+w_codinter;
                    /* If Empty(qbe_oped_chkdiana->CONNESOPER) or (qbe_oped_chkdiana->CONNESOPER=qbe_oped_chkdiana->CONNESCLI) */
                    if (CPLib.Empty(Cursor_qbe_oped_chkdiana.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_oped_chkdiana.GetString("CONNESOPER"),Cursor_qbe_oped_chkdiana.GetString("CONNESCLI")))) {
                      /* _note := _note + '2' */
                      _note = _note+"2";
                    } else { // Else
                      /* _note := _note + '3' */
                      _note = _note+"3";
                    } // End If
                    /* _note := _note + _idereg */
                    _note = _note+_idereg;
                    /* _note := _note + LRTrim(arfn_datisog_sol(intestbo->CODINTER,qbe_oped_chkdiana->DATAREG,qbe_oped_chkdiana->RAPPORTO,qbe_oped_chkdiana->FLAGRAP,'2',w_flgrae,qbe_oped_chkdiana->STATOREG,qbe_oped_chkdiana->DATARETT)) */
                    _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_intestbo.GetString("CODINTER"),Cursor_qbe_oped_chkdiana.GetDate("DATAREG"),Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_oped_chkdiana.GetString("STATOREG"),Cursor_qbe_oped_chkdiana.GetDate("DATARETT")));
                    /* If w_flgchk='S' */
                    if (CPLib.eqr(w_flgchk,"S")) {
                      /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                      Page_15();
                    } else { // Else
                      /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                      FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                    } // End If
                    /* nTotRec := nTotRec + 1 */
                    nTotRec = CPLib.Round(nTotRec+1,0);
                    /* nNumRec := nNumRec + 1 */
                    nNumRec = CPLib.Round(nNumRec+1,0);
                  } // End If
                } // End If
                Cursor_intestbo.Next();
              }
              m_cConnectivityError = Cursor_intestbo.ErrorMessage();
              Cursor_intestbo.Close();
              // * --- End Select
            } else { // Else
              /* If not(Empty(LRTrim(qbe_oped_chkdiana->CONNESCLI))) */
              if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("CONNESCLI"))))) {
                /* _note := w_tipinter + w_codinter */
                _note = w_tipinter+w_codinter;
                /* If Empty(qbe_oped_chkdiana->CONNESOPER) or (qbe_oped_chkdiana->CONNESOPER=qbe_oped_chkdiana->CONNESCLI) */
                if (CPLib.Empty(Cursor_qbe_oped_chkdiana.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_oped_chkdiana.GetString("CONNESOPER"),Cursor_qbe_oped_chkdiana.GetString("CONNESCLI")))) {
                  /* _note := _note + '2' */
                  _note = _note+"2";
                } else { // Else
                  /* _note := _note + '3' */
                  _note = _note+"3";
                } // End If
                /* _note := _note + _idereg */
                _note = _note+_idereg;
                /* _note := _note + LRTrim(arfn_datisog_sol(qbe_oped_chkdiana->CONNESCLI,qbe_oped_chkdiana->DATAREG,qbe_oped_chkdiana->RAPPORTO,qbe_oped_chkdiana->FLAGRAP,'2',w_flgrae,qbe_oped_chkdiana->STATOREG,qbe_oped_chkdiana->DATARETT)) */
                _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana.GetString("CONNESCLI"),Cursor_qbe_oped_chkdiana.GetDate("DATAREG"),Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_oped_chkdiana.GetString("STATOREG"),Cursor_qbe_oped_chkdiana.GetDate("DATARETT")));
                /* If w_flgchk='S' */
                if (CPLib.eqr(w_flgchk,"S")) {
                  /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                  Page_15();
                } else { // Else
                  /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                  FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                } // End If
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
              } // End If
            } // End If
          } // End If
          /* If Empty(LRTrim(_oldrap)) */
          if (CPLib.Empty(CPLib.LRTrim(_oldrap))) {
            /* _oldrighe := 0 */
            _oldrighe = CPLib.Round(0,0);
            /* If qbe_oped_chkdiana->STATOREG='3' */
            if (CPLib.eqr(Cursor_qbe_oped_chkdiana.GetString("STATOREG"),"3")) {
              /* _oldrighe := 0 */
              _oldrighe = CPLib.Round(0,0);
              // * --- Select from mlientiope
              m_cServer = m_Ctx.GetServer("mlientiope");
              m_cPhName = m_Ctx.GetPhName("mlientiope");
              if (Cursor_mlientiope!=null)
                Cursor_mlientiope.Close();
              Cursor_mlientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("mlientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_mlientiope.Eof())) {
                /* _oldrighe := 1 */
                _oldrighe = CPLib.Round(1,0);
                /* _note := w_tipinter + w_codinter */
                _note = w_tipinter+w_codinter;
                /* If Empty(qbe_oped_chkdiana->CONNESOPER) or (qbe_oped_chkdiana->CONNESOPER=mlientiope->CODSOG) */
                if (CPLib.Empty(Cursor_qbe_oped_chkdiana.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_oped_chkdiana.GetString("CONNESOPER"),Cursor_mlientiope.GetString("CODSOG")))) {
                  /* _note := _note + '2' */
                  _note = _note+"2";
                } else { // Else
                  /* _note := _note + '3' */
                  _note = _note+"3";
                } // End If
                /* _note := _note + _idereg */
                _note = _note+_idereg;
                /* _note := _note + LRTrim(arfn_datisog_sol(mlientiope->CODSOG,qbe_oped_chkdiana->DATAREG,qbe_oped_chkdiana->RAPPORTO,qbe_oped_chkdiana->FLAGRAP,'2',w_flgrae,qbe_oped_chkdiana->STATOREG,qbe_oped_chkdiana->DATARETT)) */
                _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_mlientiope.GetString("CODSOG"),Cursor_qbe_oped_chkdiana.GetDate("DATAREG"),Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_oped_chkdiana.GetString("STATOREG"),Cursor_qbe_oped_chkdiana.GetDate("DATARETT")));
                /* If w_flgchk='S' */
                if (CPLib.eqr(w_flgchk,"S")) {
                  /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                  Page_15();
                } else { // Else
                  /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                  FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                } // End If
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_mlientiope.Next();
              }
              m_cConnectivityError = Cursor_mlientiope.ErrorMessage();
              Cursor_mlientiope.Close();
              // * --- End Select
            } // End If
            /* If _oldrighe=0 */
            if (CPLib.eqr(_oldrighe,0)) {
              // * --- Select from clientiope
              m_cServer = m_Ctx.GetServer("clientiope");
              m_cPhName = m_Ctx.GetPhName("clientiope");
              if (Cursor_clientiope!=null)
                Cursor_clientiope.Close();
              Cursor_clientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("clientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_clientiope.Eof())) {
                /* _note := w_tipinter + w_codinter */
                _note = w_tipinter+w_codinter;
                /* If Empty(qbe_oped_chkdiana->CONNESOPER) or (qbe_oped_chkdiana->CONNESOPER=clientiope->CODSOG) */
                if (CPLib.Empty(Cursor_qbe_oped_chkdiana.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_oped_chkdiana.GetString("CONNESOPER"),Cursor_clientiope.GetString("CODSOG")))) {
                  /* _note := _note + '2' */
                  _note = _note+"2";
                } else { // Else
                  /* _note := _note + '3' */
                  _note = _note+"3";
                } // End If
                /* _note := _note + _idereg */
                _note = _note+_idereg;
                /* _note := _note + LRTrim(arfn_datisog_sol(clientiope->CODSOG,qbe_oped_chkdiana->DATAREG,qbe_oped_chkdiana->RAPPORTO,qbe_oped_chkdiana->FLAGRAP,'2',w_flgrae,qbe_oped_chkdiana->STATOREG,qbe_oped_chkdiana->DATARETT)) */
                _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_clientiope.GetString("CODSOG"),Cursor_qbe_oped_chkdiana.GetDate("DATAREG"),Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_oped_chkdiana.GetString("STATOREG"),Cursor_qbe_oped_chkdiana.GetDate("DATARETT")));
                /* If w_flgchk='S' */
                if (CPLib.eqr(w_flgchk,"S")) {
                  /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                  Page_15();
                } else { // Else
                  /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                  FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                } // End If
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_clientiope.Next();
              }
              m_cConnectivityError = Cursor_clientiope.ErrorMessage();
              Cursor_clientiope.Close();
              // * --- End Select
            } // End If
          } // End If
          /* If not(Empty(qbe_oped_chkdiana->CONNESOPER)) and qbe_oped_chkdiana->CONNESOPER <> _codrif */
          if ( ! (CPLib.Empty(Cursor_qbe_oped_chkdiana.GetString("CONNESOPER"))) && CPLib.ne(Cursor_qbe_oped_chkdiana.GetString("CONNESOPER"),_codrif)) {
            /* _note := w_tipinter + w_codinter+'4' + _idereg */
            _note = w_tipinter+w_codinter+"4"+_idereg;
            /* _note := _note + LRTrim(arfn_datisog_sol(qbe_oped_chkdiana->CONNESOPER,qbe_oped_chkdiana->DATAREG,qbe_oped_chkdiana->RAPPORTO,qbe_oped_chkdiana->FLAGRAP,'4',w_flgrae,qbe_oped_chkdiana->STATOREG,qbe_oped_chkdiana->DATARETT)) */
            _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana.GetString("CONNESOPER"),Cursor_qbe_oped_chkdiana.GetDate("DATAREG"),Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana.GetString("FLAGRAP"),"4",w_flgrae,Cursor_qbe_oped_chkdiana.GetString("STATOREG"),Cursor_qbe_oped_chkdiana.GetDate("DATARETT")));
            /* If w_flgchk='S' */
            if (CPLib.eqr(w_flgchk,"S")) {
              /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
              Page_15();
            } else { // Else
              /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
              FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
            } // End If
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
          } // End If
          /* _oldrighe := 0 */
          _oldrighe = CPLib.Round(0,0);
          /* If qbe_oped_chkdiana->STATOREG='3' */
          if (CPLib.eqr(Cursor_qbe_oped_chkdiana.GetString("STATOREG"),"3")) {
            // * --- Select from mogopebo
            m_cServer = m_Ctx.GetServer("mogopebo");
            m_cPhName = m_Ctx.GetPhName("mogopebo");
            if (Cursor_mogopebo!=null)
              Cursor_mogopebo.Close();
            Cursor_mogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("mogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_mogopebo.Eof())) {
              /* _oldrighe := 1 */
              _oldrighe = CPLib.Round(1,0);
              /* _note := w_tipinter + w_codinter+'4' + _idereg */
              _note = w_tipinter+w_codinter+"4"+_idereg;
              /* _note := _note + LRTrim(arfn_datisog_sol(mogopebo->CODSOG,qbe_oped_chkdiana->DATAREG,qbe_oped_chkdiana->RAPPORTO,qbe_oped_chkdiana->FLAGRAP,'4',w_flgrae,qbe_oped_chkdiana->STATOREG,qbe_oped_chkdiana->DATARETT)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_mogopebo.GetString("CODSOG"),Cursor_qbe_oped_chkdiana.GetDate("DATAREG"),Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana.GetString("FLAGRAP"),"4",w_flgrae,Cursor_qbe_oped_chkdiana.GetString("STATOREG"),Cursor_qbe_oped_chkdiana.GetDate("DATARETT")));
              /* If w_flgchk='S' */
              if (CPLib.eqr(w_flgchk,"S")) {
                /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                Page_15();
              } else { // Else
                /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
              } // End If
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
              Cursor_mogopebo.Next();
            }
            m_cConnectivityError = Cursor_mogopebo.ErrorMessage();
            Cursor_mogopebo.Close();
            // * --- End Select
          } // End If
          /* If _oldrighe=0 */
          if (CPLib.eqr(_oldrighe,0)) {
            // * --- Select from sogopebo
            m_cServer = m_Ctx.GetServer("sogopebo");
            m_cPhName = m_Ctx.GetPhName("sogopebo");
            if (Cursor_sogopebo!=null)
              Cursor_sogopebo.Close();
            Cursor_sogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("sogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_sogopebo.Eof())) {
              /* _note := w_tipinter + w_codinter+'4' + _idereg */
              _note = w_tipinter+w_codinter+"4"+_idereg;
              /* _note := _note + LRTrim(arfn_datisog_sol(sogopebo->CODSOG,qbe_oped_chkdiana->DATAREG,qbe_oped_chkdiana->RAPPORTO,qbe_oped_chkdiana->FLAGRAP,'4',w_flgrae,qbe_oped_chkdiana->STATOREG,qbe_oped_chkdiana->DATARETT)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_sogopebo.GetString("CODSOG"),Cursor_qbe_oped_chkdiana.GetDate("DATAREG"),Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana.GetString("FLAGRAP"),"4",w_flgrae,Cursor_qbe_oped_chkdiana.GetString("STATOREG"),Cursor_qbe_oped_chkdiana.GetDate("DATARETT")));
              /* If w_flgchk='S' */
              if (CPLib.eqr(w_flgchk,"S")) {
                /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                Page_15();
              } else { // Else
                /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
              } // End If
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
              Cursor_sogopebo.Next();
            }
            m_cConnectivityError = Cursor_sogopebo.ErrorMessage();
            Cursor_sogopebo.Close();
            // * --- End Select
          } // End If
          /* If not(Empty(qbe_oped_chkdiana->CONNESBEN)) or not(Empty(qbe_oped_chkdiana->C_RAG)) */
          if ( ! (CPLib.Empty(Cursor_qbe_oped_chkdiana.GetString("CONNESBEN"))) ||  ! (CPLib.Empty(Cursor_qbe_oped_chkdiana.GetString("C_RAG")))) {
            /* If not(Empty(qbe_oped_chkdiana->C_RAG)) */
            if ( ! (CPLib.Empty(Cursor_qbe_oped_chkdiana.GetString("C_RAG")))) {
              /* _note := w_tipinter + w_codinter+'5' + _idereg */
              _note = w_tipinter+w_codinter+"5"+_idereg;
              /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->CONNESBEN)+Space(16),16) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("CONNESBEN"))+CPLib.Space(16),16);
              /* _note := _note +Left(LRTrim(arfn_agechar(qbe_oped_chkdiana->C_RAG,' '))+Space(70),70) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana.GetString("C_RAG")," "))+CPLib.Space(70),70);
              /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->C_STA)+Space(3),3) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_STA"))+CPLib.Space(3),3);
              /* _note := _note +Left(LRTrim(qbe_oped_chkdiana->C_CAB)+Space(6),6) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_CAB"))+CPLib.Space(6),6);
              /* _note := _note +Left(LRTrim(arfn_agechar(qbe_oped_chkdiana->C_CTA,' '))+Space(30),30) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana.GetString("C_CTA")," "))+CPLib.Space(30),30);
              /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->C_PRV)+Space(2),2) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_PRV"))+CPLib.Space(2),2);
              /* _note := _note + Left(LRTrim(arfn_agechar(qbe_oped_chkdiana->C_IND,' '))+Space(35),35) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana.GetString("C_IND")," "))+CPLib.Space(35),35);
              /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->C_CAP)+Space(5),5) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_CAP"))+CPLib.Space(5),5);
              /* _note := _note + Space(63) */
              _note = _note+CPLib.Space(63);
              /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->C_RAPPORTO)+Space(25),25) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
              /* _note := _note + Space(91) */
              _note = _note+CPLib.Space(91);
              /* If w_flgchk='S' */
              if (CPLib.eqr(w_flgchk,"S")) {
                /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                Page_15();
              } else { // Else
                /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
              } // End If
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
              /* ElseIf not(Empty(qbe_oped_chkdiana->CONNESBEN)) */
            } else if ( ! (CPLib.Empty(Cursor_qbe_oped_chkdiana.GetString("CONNESBEN")))) {
              /* _numsto := arfn_chkspers(qbe_oped_chkdiana->CONNESBEN,qbe_oped_chkdiana->DATAREG) */
              _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana.GetString("CONNESBEN"),Cursor_qbe_oped_chkdiana.GetDate("DATAREG"));
              /* If Empty(LRTrim(_numsto)) */
              if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana.GetString("CONNESBEN"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* _note := w_tipinter + w_codinter+'5' + _idereg */
                  _note = w_tipinter+w_codinter+"5"+_idereg;
                  /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->CONNESBEN)+Space(16),16) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("CONNESBEN"))+CPLib.Space(16),16);
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana->C_RAG))),Left(LRTrim(arfn_agechar(qbe_oped_chkdiana->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(personbo->RAGSOC,' '))+Space(70),70)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana->C_STA))),Left(LRTrim(qbe_oped_chkdiana->C_STA)+Space(3),3),Left(LRTrim(personbo->PAESE)+Space(3),3)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana->C_CAB))),Left(LRTrim(qbe_oped_chkdiana->C_CAB)+Space(6),6),Left(LRTrim(personbo->CODCAB)+Space(6),6)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana->C_CTA))),Left(LRTrim(arfn_agechar(qbe_oped_chkdiana->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(personbo->DESCCIT,' '))+Space(30),30)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana->C_PRV))),Left(LRTrim(qbe_oped_chkdiana->C_PRV)+Space(2),2),Left(LRTrim(personbo->PROVINCIA)+Space(2),2)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana->C_IND))),Left(LRTrim(arfn_agechar(qbe_oped_chkdiana->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(personbo->DOMICILIO,' '))+Space(35),35)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana->C_CAP))),Left(LRTrim(qbe_oped_chkdiana->C_CAP)+Space(5),5),Left(LRTrim(personbo->CAP)+Space(5),5)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5));
                  /* _note := _note + Space(63) */
                  _note = _note+CPLib.Space(63);
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana->C_RAPPORTO))),Left(LRTrim(qbe_oped_chkdiana->C_RAPPORTO)+Space(25),25),Left(LRTrim(qbe_oped_chkdiana->RAPPORTBEN)+Space(25),25)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_RAPPORTO"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_RAPPORTO"))+CPLib.Space(25),25):CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("RAPPORTBEN"))+CPLib.Space(25),25));
                  /* _note := _note + Space(91) */
                  _note = _note+CPLib.Space(91);
                  /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                  FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } else { // Else
                // * --- Select from wersonbo
                m_cServer = m_Ctx.GetServer("wersonbo");
                m_cPhName = m_Ctx.GetPhName("wersonbo");
                if (Cursor_wersonbo!=null)
                  Cursor_wersonbo.Close();
                Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_wersonbo.Eof())) {
                  /* _note := w_tipinter + w_codinter+'5' + _idereg */
                  _note = w_tipinter+w_codinter+"5"+_idereg;
                  /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->CONNESBEN)+Space(16),16) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("CONNESBEN"))+CPLib.Space(16),16);
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana->C_RAG))),Left(LRTrim(arfn_agechar(qbe_oped_chkdiana->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(wersonbo->RAGSOC,' '))+Space(70),70)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana->C_STA))),Left(LRTrim(qbe_oped_chkdiana->C_STA)+Space(3),3),Left(LRTrim(wersonbo->PAESE)+Space(3),3)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PAESE"))+CPLib.Space(3),3));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana->C_CAB))),Left(LRTrim(qbe_oped_chkdiana->C_CAB)+Space(6),6),Left(LRTrim(wersonbo->CODCAB)+Space(6),6)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CODCAB"))+CPLib.Space(6),6));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana->C_CTA))),Left(LRTrim(arfn_agechar(qbe_oped_chkdiana->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(wersonbo->DESCCIT,' '))+Space(30),30)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana->C_PRV))),Left(LRTrim(qbe_oped_chkdiana->C_PRV)+Space(2),2),Left(LRTrim(wersonbo->PROVINCIA)+Space(2),2)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana->C_IND))),Left(LRTrim(arfn_agechar(qbe_oped_chkdiana->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(wersonbo->DOMICILIO,' '))+Space(35),35)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana->C_CAP))),Left(LRTrim(qbe_oped_chkdiana->C_CAP)+Space(5),5),Left(LRTrim(wersonbo->CAP)+Space(5),5)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CAP"))+CPLib.Space(5),5));
                  /* _note := _note + Space(63) */
                  _note = _note+CPLib.Space(63);
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana->C_RAPPORTO))),Left(LRTrim(qbe_oped_chkdiana->C_RAPPORTO)+Space(25),25),Left(LRTrim(qbe_oped_chkdiana->RAPPORTBEN)+Space(25),25)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_RAPPORTO"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_RAPPORTO"))+CPLib.Space(25),25):CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("RAPPORTBEN"))+CPLib.Space(25),25));
                  /* _note := _note + Space(91) */
                  _note = _note+CPLib.Space(91);
                  /* If w_flgchk='S' */
                  if (CPLib.eqr(w_flgchk,"S")) {
                    /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                    Page_15();
                  } else { // Else
                    /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                    FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                  } // End If
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_wersonbo.Next();
                }
                m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                Cursor_wersonbo.Close();
                // * --- End Select
              } // End If
            } // End If
          } // End If
          /* _oldrighe := 0 */
          _oldrighe = CPLib.Round(0,0);
          /* If qbe_oped_chkdiana->STATOREG='3' */
          if (CPLib.eqr(Cursor_qbe_oped_chkdiana.GetString("STATOREG"),"3")) {
            // * --- Select from meneficope
            m_cServer = m_Ctx.GetServer("meneficope");
            m_cPhName = m_Ctx.GetPhName("meneficope");
            if (Cursor_meneficope!=null)
              Cursor_meneficope.Close();
            Cursor_meneficope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("meneficope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_meneficope.Eof())) {
              /* _oldrighe := 1 */
              _oldrighe = CPLib.Round(1,0);
              /* If Empty(LRTrim(meneficope->CODSOG)) and not(Empty(LRTrim(meneficope->C_RAG))) */
              if (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("CODSOG"))) &&  ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_RAG"))))) {
                /* _note := w_tipinter + w_codinter+'5' + _idereg */
                _note = w_tipinter+w_codinter+"5"+_idereg;
                /* _note := _note + Left(LRTrim(meneficope->CODSOG)+Space(16),16) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("CODSOG"))+CPLib.Space(16),16);
                /* _note := _note +Left(LRTrim(arfn_agechar(meneficope->C_RAG,' '))+Space(70),70) */
                _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficope.GetString("C_RAG")," "))+CPLib.Space(70),70);
                /* _note := _note + Left(LRTrim(meneficope->C_STA)+Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_STA"))+CPLib.Space(3),3);
                /* _note := _note +Left(LRTrim(meneficope->C_CAB)+Space(6),6) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_CAB"))+CPLib.Space(6),6);
                /* _note := _note +Left(LRTrim(arfn_agechar(meneficope->C_CTA,' '))+Space(30),30) */
                _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficope.GetString("C_CTA")," "))+CPLib.Space(30),30);
                /* _note := _note + Left(LRTrim(meneficope->C_PRV)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_PRV"))+CPLib.Space(2),2);
                /* _note := _note + Left(LRTrim(arfn_agechar(meneficope->C_IND,' '))+Space(35),35) */
                _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficope.GetString("C_IND")," "))+CPLib.Space(35),35);
                /* _note := _note + Left(LRTrim(meneficope->C_CAP)+Space(5),5) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_CAP"))+CPLib.Space(5),5);
                /* _note := _note + Space(63) */
                _note = _note+CPLib.Space(63);
                /* _note := _note + Left(LRTrim(meneficope->C_RAPPORTO)+Space(25),25) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                /* _note := _note + Space(91) */
                _note = _note+CPLib.Space(91);
                /* If w_flgchk='S' */
                if (CPLib.eqr(w_flgchk,"S")) {
                  /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                  Page_15();
                } else { // Else
                  /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                  FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                } // End If
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
              } else { // Else
                /* _numsto := arfn_chkspers(meneficope->CODSOG,qbe_oped_chkdiana->DATAREG) */
                _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_meneficope.GetString("CODSOG"),Cursor_qbe_oped_chkdiana.GetDate("DATAREG"));
                /* If Empty(LRTrim(_numsto)) */
                if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
                  // * --- Select from personbo
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  if (Cursor_personbo!=null)
                    Cursor_personbo.Close();
                  Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_meneficope.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_personbo.Eof())) {
                    /* _note := w_tipinter + w_codinter+'5' + _idereg */
                    _note = w_tipinter+w_codinter+"5"+_idereg;
                    /* _note := _note + Left(LRTrim(meneficope->CODSOG)+Space(16),16) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("CODSOG"))+CPLib.Space(16),16);
                    /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_RAG))),Left(LRTrim(arfn_agechar(meneficope->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(personbo->RAGSOC,' '))+Space(70),70)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficope.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_STA))),Left(LRTrim(meneficope->C_STA)+Space(3),3),Left(LRTrim(personbo->PAESE)+Space(3),3)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_CAB))),Left(LRTrim(meneficope->C_CAB)+Space(6),6),Left(LRTrim(personbo->CODCAB)+Space(6),6)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_CTA))),Left(LRTrim(arfn_agechar(meneficope->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(personbo->DESCCIT,' '))+Space(30),30)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficope.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_PRV))),Left(LRTrim(meneficope->C_PRV)+Space(2),2),Left(LRTrim(personbo->PROVINCIA)+Space(2),2)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_IND))),Left(LRTrim(arfn_agechar(meneficope->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(personbo->DOMICILIO,' '))+Space(35),35)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficope.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_CAP))),Left(LRTrim(meneficope->C_CAP)+Space(5),5),Left(LRTrim(personbo->CAP)+Space(5),5)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5));
                    /* _note := _note + Space(63) */
                    _note = _note+CPLib.Space(63);
                    /* _note := _note +Left(LRTrim(meneficope->C_RAPPORTO)+Space(25),25) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                    /* _note := _note + Space(91) */
                    _note = _note+CPLib.Space(91);
                    /* If w_flgchk='S' */
                    if (CPLib.eqr(w_flgchk,"S")) {
                      /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                      Page_15();
                    } else { // Else
                      /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                      FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                    } // End If
                    /* nTotRec := nTotRec + 1 */
                    nTotRec = CPLib.Round(nTotRec+1,0);
                    /* nNumRec := nNumRec + 1 */
                    nNumRec = CPLib.Round(nNumRec+1,0);
                    Cursor_personbo.Next();
                  }
                  m_cConnectivityError = Cursor_personbo.ErrorMessage();
                  Cursor_personbo.Close();
                  // * --- End Select
                } else { // Else
                  // * --- Select from wersonbo
                  m_cServer = m_Ctx.GetServer("wersonbo");
                  m_cPhName = m_Ctx.GetPhName("wersonbo");
                  if (Cursor_wersonbo!=null)
                    Cursor_wersonbo.Close();
                  Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_wersonbo.Eof())) {
                    /* _note := w_tipinter + w_codinter+'5' + _idereg */
                    _note = w_tipinter+w_codinter+"5"+_idereg;
                    /* _note := _note + Left(LRTrim(meneficope->CODSOG)+Space(16),16) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("CODSOG"))+CPLib.Space(16),16);
                    /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_RAG))),Left(LRTrim(arfn_agechar(meneficope->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(wersonbo->RAGSOC,' '))+Space(70),70)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficope.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_STA))),Left(LRTrim(meneficope->C_STA)+Space(3),3),Left(LRTrim(wersonbo->PAESE)+Space(3),3)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PAESE"))+CPLib.Space(3),3));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_CAB))),Left(LRTrim(meneficope->C_CAB)+Space(6),6),Left(LRTrim(wersonbo->CODCAB)+Space(6),6)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CODCAB"))+CPLib.Space(6),6));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_CTA))),Left(LRTrim(arfn_agechar(meneficope->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(wersonbo->DESCCIT,' '))+Space(30),30)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficope.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_PRV))),Left(LRTrim(meneficope->C_PRV)+Space(2),2),Left(LRTrim(wersonbo->PROVINCIA)+Space(2),2)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_IND))),Left(LRTrim(arfn_agechar(meneficope->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(wersonbo->DOMICILIO,' '))+Space(35),35)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficope.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_CAP))),Left(LRTrim(meneficope->C_CAP)+Space(5),5),Left(LRTrim(wersonbo->CAP)+Space(5),5)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CAP"))+CPLib.Space(5),5));
                    /* _note := _note + Space(63) */
                    _note = _note+CPLib.Space(63);
                    /* _note := _note +Left(LRTrim(meneficope->C_RAPPORTO)+Space(25),25) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                    /* _note := _note + Space(91) */
                    _note = _note+CPLib.Space(91);
                    /* If w_flgchk='S' */
                    if (CPLib.eqr(w_flgchk,"S")) {
                      /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                      Page_15();
                    } else { // Else
                      /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                      FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                    } // End If
                    /* nTotRec := nTotRec + 1 */
                    nTotRec = CPLib.Round(nTotRec+1,0);
                    /* nNumRec := nNumRec + 1 */
                    nNumRec = CPLib.Round(nNumRec+1,0);
                    Cursor_wersonbo.Next();
                  }
                  m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                  Cursor_wersonbo.Close();
                  // * --- End Select
                } // End If
              } // End If
              Cursor_meneficope.Next();
            }
            m_cConnectivityError = Cursor_meneficope.ErrorMessage();
            Cursor_meneficope.Close();
            // * --- End Select
          } // End If
          /* If _oldrighe=0 */
          if (CPLib.eqr(_oldrighe,0)) {
            // * --- Select from beneficope
            m_cServer = m_Ctx.GetServer("beneficope");
            m_cPhName = m_Ctx.GetPhName("beneficope");
            if (Cursor_beneficope!=null)
              Cursor_beneficope.Close();
            Cursor_beneficope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("beneficope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_beneficope.Eof())) {
              /* If Empty(LRTrim(beneficope->CODSOG)) and not(Empty(LRTrim(beneficope->C_RAG))) */
              if (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("CODSOG"))) &&  ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_RAG"))))) {
                /* _note := w_tipinter + w_codinter+'5' + _idereg */
                _note = w_tipinter+w_codinter+"5"+_idereg;
                /* _note := _note + Left(LRTrim(beneficope->CODSOG)+Space(16),16) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("CODSOG"))+CPLib.Space(16),16);
                /* _note := _note +Left(LRTrim(arfn_agechar(beneficope->C_RAG,' '))+Space(70),70) */
                _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficope.GetString("C_RAG")," "))+CPLib.Space(70),70);
                /* _note := _note + Left(LRTrim(beneficope->C_STA)+Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_STA"))+CPLib.Space(3),3);
                /* _note := _note +Left(LRTrim(beneficope->C_CAB)+Space(6),6) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAB"))+CPLib.Space(6),6);
                /* _note := _note +Left(LRTrim(arfn_agechar(beneficope->C_CTA,' '))+Space(30),30) */
                _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficope.GetString("C_CTA")," "))+CPLib.Space(30),30);
                /* _note := _note + Left(LRTrim(beneficope->C_PRV)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_PRV"))+CPLib.Space(2),2);
                /* _note := _note + Left(LRTrim(arfn_agechar(beneficope->C_IND,' '))+Space(35),35) */
                _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficope.GetString("C_IND")," "))+CPLib.Space(35),35);
                /* _note := _note + Left(LRTrim(beneficope->C_CAP)+Space(5),5) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAP"))+CPLib.Space(5),5);
                /* _note := _note + Space(63) */
                _note = _note+CPLib.Space(63);
                /* _note := _note + Left(LRTrim(beneficope->C_RAPPORTO)+Space(25),25) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                /* _note := _note + Space(91) */
                _note = _note+CPLib.Space(91);
                /* If w_flgchk='S' */
                if (CPLib.eqr(w_flgchk,"S")) {
                  /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                  Page_15();
                } else { // Else
                  /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                  FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                } // End If
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
              } else { // Else
                /* _numsto := arfn_chkspers(beneficope->CODSOG,qbe_oped_chkdiana->DATAREG) */
                _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_beneficope.GetString("CODSOG"),Cursor_qbe_oped_chkdiana.GetDate("DATAREG"));
                /* If Empty(LRTrim(_numsto)) */
                if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
                  // * --- Select from personbo
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  if (Cursor_personbo!=null)
                    Cursor_personbo.Close();
                  Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_beneficope.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_personbo.Eof())) {
                    /* _note := w_tipinter + w_codinter+'5' + _idereg */
                    _note = w_tipinter+w_codinter+"5"+_idereg;
                    /* _note := _note + Left(LRTrim(beneficope->CODSOG)+Space(16),16) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("CODSOG"))+CPLib.Space(16),16);
                    /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_RAG))),Left(LRTrim(arfn_agechar(beneficope->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(personbo->RAGSOC,' '))+Space(70),70)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficope.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_STA))),Left(LRTrim(beneficope->C_STA)+Space(3),3),Left(LRTrim(personbo->PAESE)+Space(3),3)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_CAB))),Left(LRTrim(beneficope->C_CAB)+Space(6),6),Left(LRTrim(personbo->CODCAB)+Space(6),6)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_CTA))),Left(LRTrim(arfn_agechar(beneficope->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(personbo->DESCCIT,' '))+Space(30),30)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficope.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_PRV))),Left(LRTrim(beneficope->C_PRV)+Space(2),2),Left(LRTrim(personbo->PROVINCIA)+Space(2),2)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_IND))),Left(LRTrim(arfn_agechar(beneficope->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(personbo->DOMICILIO,' '))+Space(35),35)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficope.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_CAP))),Left(LRTrim(beneficope->C_CAP)+Space(5),5),Left(LRTrim(personbo->CAP)+Space(5),5)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5));
                    /* _note := _note + Space(63) */
                    _note = _note+CPLib.Space(63);
                    /* _note := _note +Left(LRTrim(beneficope->C_RAPPORTO)+Space(25),25) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                    /* _note := _note + Space(91) */
                    _note = _note+CPLib.Space(91);
                    /* If w_flgchk='S' */
                    if (CPLib.eqr(w_flgchk,"S")) {
                      /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                      Page_15();
                    } else { // Else
                      /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                      FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                    } // End If
                    /* nTotRec := nTotRec + 1 */
                    nTotRec = CPLib.Round(nTotRec+1,0);
                    /* nNumRec := nNumRec + 1 */
                    nNumRec = CPLib.Round(nNumRec+1,0);
                    Cursor_personbo.Next();
                  }
                  m_cConnectivityError = Cursor_personbo.ErrorMessage();
                  Cursor_personbo.Close();
                  // * --- End Select
                } else { // Else
                  // * --- Select from wersonbo
                  m_cServer = m_Ctx.GetServer("wersonbo");
                  m_cPhName = m_Ctx.GetPhName("wersonbo");
                  if (Cursor_wersonbo!=null)
                    Cursor_wersonbo.Close();
                  Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_wersonbo.Eof())) {
                    /* _note := w_tipinter + w_codinter+'5' + _idereg */
                    _note = w_tipinter+w_codinter+"5"+_idereg;
                    /* _note := _note + Left(LRTrim(beneficope->CODSOG)+Space(16),16) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("CODSOG"))+CPLib.Space(16),16);
                    /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_RAG))),Left(LRTrim(arfn_agechar(beneficope->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(wersonbo->RAGSOC,' '))+Space(70),70)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficope.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_STA))),Left(LRTrim(beneficope->C_STA)+Space(3),3),Left(LRTrim(wersonbo->PAESE)+Space(3),3)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PAESE"))+CPLib.Space(3),3));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_CAB))),Left(LRTrim(beneficope->C_CAB)+Space(6),6),Left(LRTrim(wersonbo->CODCAB)+Space(6),6)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CODCAB"))+CPLib.Space(6),6));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_CTA))),Left(LRTrim(arfn_agechar(beneficope->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(wersonbo->DESCCIT,' '))+Space(30),30)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficope.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_PRV))),Left(LRTrim(beneficope->C_PRV)+Space(2),2),Left(LRTrim(wersonbo->PROVINCIA)+Space(2),2)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_IND))),Left(LRTrim(arfn_agechar(beneficope->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(wersonbo->DOMICILIO,' '))+Space(35),35)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficope.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_CAP))),Left(LRTrim(beneficope->C_CAP)+Space(5),5),Left(LRTrim(wersonbo->CAP)+Space(5),5)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CAP"))+CPLib.Space(5),5));
                    /* _note := _note + Space(63) */
                    _note = _note+CPLib.Space(63);
                    /* _note := _note +Left(LRTrim(beneficope->C_RAPPORTO)+Space(25),25) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                    /* _note := _note + Space(91) */
                    _note = _note+CPLib.Space(91);
                    /* If w_flgchk='S' */
                    if (CPLib.eqr(w_flgchk,"S")) {
                      /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                      Page_15();
                    } else { // Else
                      /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                      FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                    } // End If
                    /* nTotRec := nTotRec + 1 */
                    nTotRec = CPLib.Round(nTotRec+1,0);
                    /* nNumRec := nNumRec + 1 */
                    nNumRec = CPLib.Round(nNumRec+1,0);
                    Cursor_wersonbo.Next();
                  }
                  m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                  Cursor_wersonbo.Close();
                  // * --- End Select
                } // End If
              } // End If
              Cursor_beneficope.Next();
            }
            m_cConnectivityError = Cursor_beneficope.ErrorMessage();
            Cursor_beneficope.Close();
            // * --- End Select
          } // End If
          /* If not(Empty(qbe_oped_chkdiana->CONNALTRO)) */
          if ( ! (CPLib.Empty(Cursor_qbe_oped_chkdiana.GetString("CONNALTRO")))) {
            /* _note := w_tipinter + w_codinter+'6' + _idereg */
            _note = w_tipinter+w_codinter+"6"+_idereg;
            /* _note := _note + LRTrim(arfn_datisog_sol(qbe_oped_chkdiana->CONNALTRO,qbe_oped_chkdiana->DATAREG,qbe_oped_chkdiana->RAPPORTO,qbe_oped_chkdiana->FLAGRAP,'6',w_flgrae,qbe_oped_chkdiana->STATOREG,qbe_oped_chkdiana->DATARETT)) */
            _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana.GetString("CONNALTRO"),Cursor_qbe_oped_chkdiana.GetDate("DATAREG"),Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana.GetString("FLAGRAP"),"6",w_flgrae,Cursor_qbe_oped_chkdiana.GetString("STATOREG"),Cursor_qbe_oped_chkdiana.GetDate("DATARETT")));
            /* If w_flgchk='S' */
            if (CPLib.eqr(w_flgchk,"S")) {
              /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
              Page_15();
            } else { // Else
              /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
              FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
            } // End If
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
          } // End If
          /* _oldrighe := 0 */
          _oldrighe = CPLib.Round(0,0);
          /* If qbe_oped_chkdiana->STATOREG='3' */
          if (CPLib.eqr(Cursor_qbe_oped_chkdiana.GetString("STATOREG"),"3")) {
            // * --- Select from merzistiope
            m_cServer = m_Ctx.GetServer("merzistiope");
            m_cPhName = m_Ctx.GetPhName("merzistiope");
            if (Cursor_merzistiope!=null)
              Cursor_merzistiope.Close();
            Cursor_merzistiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("merzistiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_merzistiope.Eof())) {
              /* _note := w_tipinter + w_codinter+'6' + _idereg */
              _note = w_tipinter+w_codinter+"6"+_idereg;
              /* _note := _note + LRTrim(arfn_datisog_sol(merzistiope->CODSOG,qbe_oped_chkdiana->DATAREG,qbe_oped_chkdiana->RAPPORTO,qbe_oped_chkdiana->FLAGRAP,'6',w_flgrae,qbe_oped_chkdiana->STATOREG,qbe_oped_chkdiana->DATARETT)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_merzistiope.GetString("CODSOG"),Cursor_qbe_oped_chkdiana.GetDate("DATAREG"),Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana.GetString("FLAGRAP"),"6",w_flgrae,Cursor_qbe_oped_chkdiana.GetString("STATOREG"),Cursor_qbe_oped_chkdiana.GetDate("DATARETT")));
              /* If w_flgchk='S' */
              if (CPLib.eqr(w_flgchk,"S")) {
                /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                Page_15();
              } else { // Else
                /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
              } // End If
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
              Cursor_merzistiope.Next();
            }
            m_cConnectivityError = Cursor_merzistiope.ErrorMessage();
            Cursor_merzistiope.Close();
            // * --- End Select
          } // End If
          /* If _oldrighe=0 */
          if (CPLib.eqr(_oldrighe,0)) {
            // * --- Select from terzistiope
            m_cServer = m_Ctx.GetServer("terzistiope");
            m_cPhName = m_Ctx.GetPhName("terzistiope");
            if (Cursor_terzistiope!=null)
              Cursor_terzistiope.Close();
            Cursor_terzistiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("terzistiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_terzistiope.Eof())) {
              /* _note := w_tipinter + w_codinter+'6' + _idereg */
              _note = w_tipinter+w_codinter+"6"+_idereg;
              /* _note := _note + LRTrim(arfn_datisog_sol(terzistiope->CODSOG,qbe_oped_chkdiana->DATAREG,qbe_oped_chkdiana->RAPPORTO,qbe_oped_chkdiana->FLAGRAP,'6',w_flgrae,qbe_oped_chkdiana->STATOREG,qbe_oped_chkdiana->DATARETT)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_terzistiope.GetString("CODSOG"),Cursor_qbe_oped_chkdiana.GetDate("DATAREG"),Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana.GetString("FLAGRAP"),"6",w_flgrae,Cursor_qbe_oped_chkdiana.GetString("STATOREG"),Cursor_qbe_oped_chkdiana.GetDate("DATARETT")));
              /* If w_flgchk='S' */
              if (CPLib.eqr(w_flgchk,"S")) {
                /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                Page_15();
              } else { // Else
                /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
              } // End If
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
              Cursor_terzistiope.Next();
            }
            m_cConnectivityError = Cursor_terzistiope.ErrorMessage();
            Cursor_terzistiope.Close();
            // * --- End Select
          } // End If
          /* gNumRec := nTotRec // N� Record DIANA */
          gNumRec = CPLib.Round(nTotRec,0);
          m_Ctx.SetGlobalNumber("gNumRec",gNumRec);
          /* gNumReg := nTotReg // N� Registrazioni DIANA */
          gNumReg = CPLib.Round(nTotReg,0);
          m_Ctx.SetGlobalNumber("gNumReg",gNumReg);
          Cursor_qbe_oped_chkdiana.Next();
        }
        m_cConnectivityError = Cursor_qbe_oped_chkdiana.ErrorMessage();
        Cursor_qbe_oped_chkdiana.Close();
        // * --- End Select
        /* _contacilci := _contacilci+1 */
        _contacilci = CPLib.Round(_contacilci+1,0);
      } // End While
    } finally {
      try {
        if (Cursor_qbe_oped_chkdiana_limits!=null)
          Cursor_qbe_oped_chkdiana_limits.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_oped_chkdiana!=null)
          Cursor_qbe_oped_chkdiana.Close();
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
        if (Read_Cursor!=null)
          Read_Cursor.Close();
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
        if (Cursor_kersonbo!=null)
          Cursor_kersonbo.Close();
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
        if (Cursor_mlientiope!=null)
          Cursor_mlientiope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_clientiope!=null)
          Cursor_clientiope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_mogopebo!=null)
          Cursor_mogopebo.Close();
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
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_meneficope!=null)
          Cursor_meneficope.Close();
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
        if (Cursor_merzistiope!=null)
          Cursor_merzistiope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_terzistiope!=null)
          Cursor_terzistiope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_8() throws Exception {
    CPResultSet Cursor_qbe_opep_chkdiana_limits=null;
    CPResultSet Cursor_qbe_opep_chkdiana=null;
    CPResultSet Cursor_anarapbo=null;
    CPResultSet Cursor_xnarapbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_anadip=null;
    CPResultSet Cursor_kersonbo=null;
    CPResultSet Cursor_knarapbo=null;
    CPResultSet Cursor_xntestbo=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_xlientiope=null;
    CPResultSet Cursor_xogopebo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_xeneficope=null;
    CPResultSet Cursor_xerzistiope=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Cicla sulle operazioni provvisorie */
      /* gMsgImp := 'Verifica Operazioni Provvisorie da elaborare ...' // Messaggio Import */
      gMsgImp = "Verifica Operazioni Provvisorie da elaborare ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* _max := 0 */
      _max = CPLib.Round(0,0);
      /* _min := 0 */
      _min = CPLib.Round(0,0);
      /* _ciclo := 0 */
      _ciclo = CPLib.Round(0,0);
      /* Prima gli italiani */
      // * --- Select from qbe_opep_chkdiana_limits
      SPBridge.HMCaller _hMQPUYYZAUF;
      _hMQPUYYZAUF = new SPBridge.HMCaller();
      _hMQPUYYZAUF.Set("m_cVQRList",m_cVQRList);
      _hMQPUYYZAUF.Set("cdadata",w_cdadata);
      _hMQPUYYZAUF.Set("c_adata",w_c_adata);
      _hMQPUYYZAUF.Set("codage",w_codage);
      _hMQPUYYZAUF.Set("codcli",w_codcli);
      _hMQPUYYZAUF.Set("ragben",w_ragben);
      if (Cursor_qbe_opep_chkdiana_limits!=null)
        Cursor_qbe_opep_chkdiana_limits.Close();
      Cursor_qbe_opep_chkdiana_limits = new VQRHolder("qbe_opep_chkdiana_limits",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_hMQPUYYZAUF,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_opep_chkdiana_limits.Eof())) {
        /* _max := qbe_opep_chkdiana_limits->MAXOPE */
        _max = CPLib.Round(Cursor_qbe_opep_chkdiana_limits.GetDouble("MAXOPE"),0);
        /* _min := qbe_opep_chkdiana_limits->MINOPE */
        _min = CPLib.Round(Cursor_qbe_opep_chkdiana_limits.GetDouble("MINOPE"),0);
        Cursor_qbe_opep_chkdiana_limits.Next();
      }
      m_cConnectivityError = Cursor_qbe_opep_chkdiana_limits.ErrorMessage();
      Cursor_qbe_opep_chkdiana_limits.Close();
      // * --- End Select
      /* _cicli := iif(Mod(_max,5000) <> 0,Int(_max/5000) + 1,Int(_max/5000)) */
      _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,5000),0)?CPLib.Int(_max/5000)+1:CPLib.Int(_max/5000)),0);
      /* _bottom := _min */
      _bottom = CPLib.Round(_min,0);
      /* If _min > 5000 */
      if (CPLib.gt(_min,5000)) {
        /* _contacilci := Int(_min/5000) + 1 */
        _contacilci = CPLib.Round(CPLib.Int(_min/5000)+1,0);
      } else { // Else
        /* _contacilci := 1 */
        _contacilci = CPLib.Round(1,0);
      } // End If
      /* gMsgImp := 'Lettura operazioni in corso ...' // Messaggio Import */
      gMsgImp = "Lettura operazioni in corso ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* While _contacilci<=_cicli */
      while (CPLib.le(_contacilci,_cicli)) {
        /* _bottom := iif(_ciclo=0,_bottom,((_contacilci -1 ) * 5000) + 1) */
        _bottom = CPLib.Round((CPLib.eqr(_ciclo,0)?_bottom:((_contacilci-1)*5000)+1),0);
        /* _top := _contacilci * 5000 */
        _top = CPLib.Round(_contacilci*5000,0);
        /* _ciclo := 1 */
        _ciclo = CPLib.Round(1,0);
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
        /* gMsgImp := 'Lettura operazioni in corso ... Ciclo N. '+LRTrim(Str(_contacilci,10,0)) // Messaggio Import */
        gMsgImp = "Lettura operazioni in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacilci,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* Cicla sulle operazioni */
        // * --- Select from qbe_opep_chkdiana
        SPBridge.HMCaller _hJTGGGITIFD;
        _hJTGGGITIFD = new SPBridge.HMCaller();
        _hJTGGGITIFD.Set("m_cVQRList",m_cVQRList);
        _hJTGGGITIFD.Set("cdadata",w_cdadata);
        _hJTGGGITIFD.Set("c_adata",w_c_adata);
        _hJTGGGITIFD.Set("codage",w_codage);
        _hJTGGGITIFD.Set("_bottom",_bottom);
        _hJTGGGITIFD.Set("_top",_top);
        _hJTGGGITIFD.Set("codcli",w_codcli);
        _hJTGGGITIFD.Set("ragben",w_ragben);
        if (Cursor_qbe_opep_chkdiana!=null)
          Cursor_qbe_opep_chkdiana.Close();
        Cursor_qbe_opep_chkdiana = new VQRHolder("qbe_opep_chkdiana",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_hJTGGGITIFD,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_opep_chkdiana.Eof())) {
          /* _ctotale := _ctotale + 1 */
          _ctotale = CPLib.Round(_ctotale+1,0);
          /* gMsgImp := 'Elaborazione Operazione N.: '+LRTrim(Str(_ctotale,15,0)) // Messaggio Import */
          gMsgImp = "Elaborazione Operazione N.: "+CPLib.LRTrim(CPLib.Str(_ctotale,15,0));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* If Empty(LRTrim(qbe_opep_chkdiana->FLAGRAP2)) */
          if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("FLAGRAP2")))) {
            /* _idereg := DateToChar(qbe_opep_chkdiana->DATAOPE) + "O" + Right(qbe_opep_chkdiana->NUMPROG,10) + 'S' */
            _idereg = CPLib.DateToChar(Cursor_qbe_opep_chkdiana.GetDate("DATAOPE"))+"O"+CPLib.Right(Cursor_qbe_opep_chkdiana.GetString("NUMPROG"),10)+"S";
          } else { // Else
            /* _idereg := Left(qbe_opep_chkdiana->IDEREG,8) + "O" + Right(qbe_opep_chkdiana->IDEREG,11) */
            _idereg = CPLib.Left(Cursor_qbe_opep_chkdiana.GetString("IDEREG"),8)+"O"+CPLib.Right(Cursor_qbe_opep_chkdiana.GetString("IDEREG"),11);
          } // End If
          /* _note := w_tipinter + w_codinter + '1' + _idereg */
          _note = w_tipinter+w_codinter+"1"+_idereg;
          /* _flagrap := '' */
          _flagrap = "";
          // * --- Select from anarapbo
          m_cServer = m_Ctx.GetServer("anarapbo");
          m_cPhName = m_Ctx.GetPhName("anarapbo");
          if (Cursor_anarapbo!=null)
            Cursor_anarapbo.Close();
          Cursor_anarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select TIPORAP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_opep_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("anarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_anarapbo.Eof())) {
            /* _flagrap := anarapbo->TIPORAP */
            _flagrap = Cursor_anarapbo.GetString("TIPORAP");
            Cursor_anarapbo.Next();
          }
          m_cConnectivityError = Cursor_anarapbo.ErrorMessage();
          Cursor_anarapbo.Close();
          // * --- End Select
          /* If Empty(LRTrim(_flagrap)) */
          if (CPLib.Empty(CPLib.LRTrim(_flagrap))) {
            // * --- Select from xnarapbo
            m_cServer = m_Ctx.GetServer("xnarapbo");
            m_cPhName = m_Ctx.GetPhName("xnarapbo");
            if (Cursor_xnarapbo!=null)
              Cursor_xnarapbo.Close();
            Cursor_xnarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select TIPORAP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_opep_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xnarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xnarapbo.Eof())) {
              /* _flagrap := xnarapbo->TIPORAP */
              _flagrap = Cursor_xnarapbo.GetString("TIPORAP");
              Cursor_xnarapbo.Next();
            }
            m_cConnectivityError = Cursor_xnarapbo.ErrorMessage();
            Cursor_xnarapbo.Close();
            // * --- End Select
            /* _flagrap := iif(Empty(LRTrim(_flagrap)),qbe_opep_chkdiana->FLAGRAP,_flagrap) */
            _flagrap = (CPLib.Empty(CPLib.LRTrim(_flagrap))?Cursor_qbe_opep_chkdiana.GetString("FLAGRAP"):_flagrap);
          } // End If
          /* If Empty(qbe_opep_chkdiana->CODDIPE) */
          if (CPLib.Empty(Cursor_qbe_opep_chkdiana.GetString("CODDIPE"))) {
            // * --- Read from intermbo
            m_cServer = m_Ctx.GetServer("intermbo");
            m_cPhName = m_Ctx.GetPhName("intermbo");
            m_cSql = "";
            m_cSql = m_cSql+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codinter,"C",11,0,m_cServer),m_cServer,w_codinter);
            if (m_Ctx.IsSharedTemp("intermbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODCAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODDIPE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              w_codcab = Read_Cursor.GetString("CODCAB");
              w_desccit = Read_Cursor.GetString("DESCCIT");
              w_provin = Read_Cursor.GetString("PROVINCIA");
              w_coddipe = Read_Cursor.GetString("CODDIPE");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on intermbo into routine arrt_chkdiana_old returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              w_codcab = "";
              w_desccit = "";
              w_provin = "";
              w_coddipe = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(w_coddipe) */
            if (CPLib.Empty(w_coddipe)) {
              /* _note := _note + '000000' + Left(LRTrim(w_codcab)+Space(6),6) + Left(LRTrim(w_desccit)+Space(30),30) + Left(LRTrim(w_provin)+Space(2),2) */
              _note = _note+"000000"+CPLib.Left(CPLib.LRTrim(w_codcab)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(w_desccit)+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(w_provin)+CPLib.Space(2),2);
            } else { // Else
              /* _note := _note + w_coddipe */
              _note = _note+w_coddipe;
              // * --- Read from anadip
              m_cServer = m_Ctx.GetServer("anadip");
              m_cPhName = m_Ctx.GetPhName("anadip");
              m_cSql = "";
              m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_coddipe,"C",6,0,m_cServer),m_cServer,w_coddipe);
              if (m_Ctx.IsSharedTemp("anadip")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                w_cabcod = Read_Cursor.GetString("CAB");
                w_citdesc = Read_Cursor.GetString("DESCCIT");
                w_provind = Read_Cursor.GetString("PROVINCIA");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on anadip into routine arrt_chkdiana_old returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                w_cabcod = "";
                w_citdesc = "";
                w_provind = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(w_cabcod) */
              if (CPLib.Empty(w_cabcod)) {
                /* _note := _note + Left(LRTrim(w_codcab)+Space(6),6) + Left(LRTrim(w_desccit)+Space(30),30) + Left(LRTrim(w_provin)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(w_codcab)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(w_desccit)+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(w_provin)+CPLib.Space(2),2);
              } else { // Else
                /* _note := _note + Left(LRTrim(w_cabcod)+Space(6),6) + Left(LRTrim(w_citdesc)+Space(30),30) + Left(LRTrim(w_provind)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(w_cabcod)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(w_citdesc)+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(w_provind)+CPLib.Space(2),2);
              } // End If
            } // End If
          } else { // Else
            // * --- Select from anadip
            m_cServer = m_Ctx.GetServer("anadip");
            m_cPhName = m_Ctx.GetPhName("anadip");
            if (Cursor_anadip!=null)
              Cursor_anadip.Close();
            Cursor_anadip = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODDIP="+CPLib.ToSQL(Cursor_qbe_opep_chkdiana.GetString("CODDIPE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("anadip")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_anadip.Eof())) {
              /* _note := _note + qbe_opep_chkdiana->CODDIPE + Left(LRTrim(anadip->CAB)+Space(6),6) + Left(LRTrim(anadip->DESCCIT)+Space(30),30) + Left(LRTrim(anadip->PROVINCIA)+Space(2),2) */
              _note = _note+Cursor_qbe_opep_chkdiana.GetString("CODDIPE")+CPLib.Left(CPLib.LRTrim(Cursor_anadip.GetString("CAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_anadip.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_anadip.GetString("PROVINCIA"))+CPLib.Space(2),2);
              Cursor_anadip.Next();
            }
            m_cConnectivityError = Cursor_anadip.ErrorMessage();
            Cursor_anadip.Close();
            // * --- End Select
          } // End If
          /* _note := _note + Left(DateToChar(qbe_opep_chkdiana->DATAOPE)+Space(8),8) + Left(LRTrim(qbe_opep_chkdiana->FLAGFRAZ)+" ",1) + Left(LRTrim(qbe_opep_chkdiana->FLAGCONT)+" ",1) */
          _note = _note+CPLib.Left(CPLib.DateToChar(Cursor_qbe_opep_chkdiana.GetDate("DATAOPE"))+CPLib.Space(8),8)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("FLAGFRAZ"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("FLAGCONT"))+" ",1);
          /* _note := _note + Left(LRTrim(qbe_opep_chkdiana->CODANA)+Space(4),4) + Left(LRTrim(qbe_opep_chkdiana->CODVOC)+Space(2),2) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("CODANA"))+CPLib.Space(4),4)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("CODVOC"))+CPLib.Space(2),2);
          /* _note := _note + Left(LRTrim(qbe_opep_chkdiana->TIPOINT2)+Space(2),2) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("TIPOINT2"))+CPLib.Space(2),2);
          /* _note := _note + iif(Empty(LRTrim(qbe_opep_chkdiana->CODFISCICP)),Left(LRTrim(qbe_opep_chkdiana->CODINT2)+Space(11),11),Left(LRTrim(qbe_opep_chkdiana->CODFISCICP)+Space(11),11)) */
          _note = _note+(CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("CODFISCICP")))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("CODINT2"))+CPLib.Space(11),11):CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("CODFISCICP"))+CPLib.Space(11),11));
          /* _note := _note + Left(LRTrim(qbe_opep_chkdiana->PAESE)+Space(3),3) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("PAESE"))+CPLib.Space(3),3);
          /* _note := _note + Left(LRTrim(qbe_opep_chkdiana->CODCAB2)+Space(6),6) + Left(LRTrim(arfn_agechar(qbe_opep_chkdiana->DESC2,' '))+Space(30),30) + Left(LRTrim(qbe_opep_chkdiana->PROV2)+Space(2),2) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("CODCAB2"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_opep_chkdiana.GetString("DESC2")," "))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("PROV2"))+CPLib.Space(2),2);
          /* _note := _note + Left(LRTrim(arfn_agechar(qbe_opep_chkdiana->DESCINTER,' '))+Space(50),50) + Left(LRTrim(arfn_agechar(qbe_opep_chkdiana->RAPPORTO,' '))+Space(25),25) + Left(LRTrim(_flagrap)+" ",1) */
          _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_opep_chkdiana.GetString("DESCINTER")," "))+CPLib.Space(50),50)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_opep_chkdiana.GetString("RAPPORTO")," "))+CPLib.Space(25),25)+CPLib.Left(CPLib.LRTrim(_flagrap)+" ",1);
          /* _note := _note + Left(LRTrim(qbe_opep_chkdiana->TIPOLEG)+" ",1) + Left(LRTrim(DateToChar(qbe_opep_chkdiana->DATAREG))+Space(8),8) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("TIPOLEG"))+" ",1)+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_opep_chkdiana.GetDate("DATAREG")))+CPLib.Space(8),8);
          /* _note := _note + Left(LRTrim(qbe_opep_chkdiana->TIPOOPRAP)+Space(2),2) + Left(LRTrim(qbe_opep_chkdiana->COLLEG)+Space(11),11) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("TIPOOPRAP"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("COLLEG"))+CPLib.Space(11),11);
          /* _note := _note + " " + Left(LRTrim(qbe_opep_chkdiana->STATOREG)+" ",1)  */
          _note = _note+" "+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("STATOREG"))+" ",1);
          /* If Empty(qbe_opep_chkdiana->DATARETT) or DateToChar(qbe_opep_chkdiana->DATARETT)='01000101' */
          if (CPLib.Empty(Cursor_qbe_opep_chkdiana.GetDate("DATARETT")) || CPLib.eqr(CPLib.DateToChar(Cursor_qbe_opep_chkdiana.GetDate("DATARETT")),"01000101")) {
            /* _note := _note + Space(8) */
            _note = _note+CPLib.Space(8);
          } else { // Else
            /* _note := _note + Left(LRTrim(DateToChar(qbe_opep_chkdiana->DATARETT))+Space(8),8) */
            _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_opep_chkdiana.GetDate("DATARETT")))+CPLib.Space(8),8);
          } // End If
          /* _note := _note + iif(Empty(LRTrim(qbe_opep_chkdiana->OPERAZMOD)),Space(20),Left(qbe_opep_chkdiana->OPERAZMOD,8)+"O"+Right(qbe_opep_chkdiana->OPERAZMOD,11)) */
          _note = _note+(CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("OPERAZMOD")))?CPLib.Space(20):CPLib.Left(Cursor_qbe_opep_chkdiana.GetString("OPERAZMOD"),8)+"O"+CPLib.Right(Cursor_qbe_opep_chkdiana.GetString("OPERAZMOD"),11));
          /* _note := _note + Left(LRTrim(qbe_opep_chkdiana->FLAGLIRE)+" ",1) + Left(LRTrim(qbe_opep_chkdiana->VALUTA)+Space(3),3) + Left(LRTrim(qbe_opep_chkdiana->SEGNO)+" ",1) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("FLAGLIRE"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("VALUTA"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("SEGNO"))+" ",1);
          /* _note := _note +  Right('000000000000000'+LRTrim(Str(qbe_opep_chkdiana->TOTLIRE,15,0)),15) + Right('000000000000000'+LRTrim(Str(qbe_opep_chkdiana->TOTCONT,15,0)),15) + Space(69) */
          _note = _note+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_opep_chkdiana.GetDouble("TOTLIRE"),15,0)),15)+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_opep_chkdiana.GetDouble("TOTCONT"),15,0)),15)+CPLib.Space(69);
          /* If w_flgchk='S' */
          if (CPLib.eqr(w_flgchk,"S")) {
            /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
            Page_15();
          } else { // Else
            /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
            FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
          } // End If
          /* nTotRec := nTotRec + 1 */
          nTotRec = CPLib.Round(nTotRec+1,0);
          /* nTotReg := nTotReg + 1 */
          nTotReg = CPLib.Round(nTotReg+1,0);
          /* nNumRec := nNumRec + 1 */
          nNumRec = CPLib.Round(nNumRec+1,0);
          /* If not(Empty(qbe_opep_chkdiana->CONNESCLI)) and Empty(LRTrim(qbe_opep_chkdiana->RAPPORTO)) */
          if ( ! (CPLib.Empty(Cursor_qbe_opep_chkdiana.GetString("CONNESCLI"))) && CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("RAPPORTO")))) {
            /* _oldrap := '' */
            _oldrap = "";
            /* _codrif := qbe_opep_chkdiana->CONNESCLI */
            _codrif = Cursor_qbe_opep_chkdiana.GetString("CONNESCLI");
            /* If gFlgWU='S' */
            if (CPLib.eqr(gFlgWU,"S")) {
              // * --- Select from kersonbo
              m_cServer = m_Ctx.GetServer("kersonbo");
              m_cPhName = m_Ctx.GetPhName("kersonbo");
              if (Cursor_kersonbo!=null)
                Cursor_kersonbo.Close();
              Cursor_kersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_opep_chkdiana.GetString("CONNESDOC"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("kersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_kersonbo.Eof())) {
                /* _ramate := iif(w_flgrae='R',LRTrim(kersonbo->RAMOGRUP),Left(LRTrim(kersonbo->ATTIV),3)) */
                _ramate = (CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_kersonbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("ATTIV")),3));
                /* _note := w_tipinter + w_codinter */
                _note = w_tipinter+w_codinter;
                /* If Empty(qbe_opep_chkdiana->CONNESOPER) or (qbe_opep_chkdiana->CONNESOPER=qbe_opep_chkdiana->CONNESCLI) */
                if (CPLib.Empty(Cursor_qbe_opep_chkdiana.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_opep_chkdiana.GetString("CONNESOPER"),Cursor_qbe_opep_chkdiana.GetString("CONNESCLI")))) {
                  /* _note := _note + '2' */
                  _note = _note+"2";
                } else { // Else
                  /* _note := _note + '3' */
                  _note = _note+"3";
                } // End If
                /* _note := _note + _idereg */
                _note = _note+_idereg;
                /* _note := _note + Left(LRTrim(qbe_opep_chkdiana->CONNESCLI)+Space(16),16) + Left(LRTrim(kersonbo->RAGSOC)+Space(70),70) + Left(LRTrim(kersonbo->PAESE)+Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("CONNESCLI"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("PAESE"))+CPLib.Space(3),3);
                /* _note := _note + Left(LRTrim(kersonbo->CODCAB)+Space(6),6) + Left(LRTrim(kersonbo->DESCCIT)+Space(30),30) + Left(LRTrim(kersonbo->PROVINCIA)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                /* _note := _note + Left(LRTrim(kersonbo->DOMICILIO)+Space(35),35) + Left(LRTrim(kersonbo->CAP)+ Space(5),5) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("CAP"))+CPLib.Space(5),5);
                /* _note := _note + Left(LRTrim(kersonbo->CODFISC)+Space(16),16)  */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("CODFISC"))+CPLib.Space(16),16);
                /* If Empty(kersonbo->DATANASC) or DateToChar(kersonbo->DATANASC)='01000101' */
                if (CPLib.Empty(Cursor_kersonbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_kersonbo.GetDate("DATANASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(kersonbo->DATANASC))+Space(8),8) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_kersonbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                } // End If
                /* If not(Empty(kersonbo->NASSTATO)) */
                if ( ! (CPLib.Empty(Cursor_kersonbo.GetString("NASSTATO")))) {
                  /* _note := _note + Left(LRTrim(kersonbo->NASSTATO)+Space(30),30) + Left(LRTrim(kersonbo->SOTGRUP)+Space(3),3) + Left(LRTrim(_ramate)+Space(3),3) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(_ramate)+CPLib.Space(3),3);
                } else { // Else
                  /* _note := _note + Left(LRTrim(kersonbo->NASCOMUN)+Space(30),30) + Left(LRTrim(kersonbo->SOTGRUP)+Space(3),3) + Left(LRTrim(_ramate) +Space(3),3) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(_ramate)+CPLib.Space(3),3);
                } // End If
                /* _note := _note + Left(LRTrim(kersonbo->SETTSINT)+Space(3),3) + Left(LRTrim(arfn_agechar(qbe_opep_chkdiana->RAPPORTO,' '))+Space(25),25) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_opep_chkdiana.GetString("RAPPORTO")," "))+CPLib.Space(25),25);
                /* _note := _note + Left(LRTrim(qbe_opep_chkdiana->FLAGRAP)+" ",1) + Left(LRTrim(kersonbo->TIPODOC)+Space(2),2) + Left(LRTrim(kersonbo->NUMDOCUM)+Space(15),15) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                /* If Empty(kersonbo->DATARILASC) or DateToChar(kersonbo->DATARILASC)='01000101' */
                if (CPLib.Empty(Cursor_kersonbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_kersonbo.GetDate("DATARILASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(kersonbo->DATARILASC))+Space(8),8)  */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_kersonbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                } // End If
                /* _note := _note + Left(LRTrim(kersonbo->AUTRILASC)+Space(30),30) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("AUTRILASC"))+CPLib.Space(30),30);
                /* _note := _note + Left(LRTrim(kersonbo->SESSO)+" ",1) + Space(34) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SESSO"))+" ",1)+CPLib.Space(34);
                /* If w_flgchk='S' */
                if (CPLib.eqr(w_flgchk,"S")) {
                  /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                  Page_15();
                } else { // Else
                  /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                  FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                } // End If
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_kersonbo.Next();
              }
              m_cConnectivityError = Cursor_kersonbo.ErrorMessage();
              Cursor_kersonbo.Close();
              // * --- End Select
            } else { // Else
              /* _note := w_tipinter + w_codinter */
              _note = w_tipinter+w_codinter;
              /* If Empty(qbe_opep_chkdiana->CONNESOPER) or (qbe_opep_chkdiana->CONNESOPER=qbe_opep_chkdiana->CONNESCLI) */
              if (CPLib.Empty(Cursor_qbe_opep_chkdiana.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_opep_chkdiana.GetString("CONNESOPER"),Cursor_qbe_opep_chkdiana.GetString("CONNESCLI")))) {
                /* _note := _note + '2' */
                _note = _note+"2";
              } else { // Else
                /* _note := _note + '3' */
                _note = _note+"3";
              } // End If
              /* _note := _note + _idereg */
              _note = _note+_idereg;
              /* _note := _note + LRTrim(arfn_datisog_sol(qbe_opep_chkdiana->CONNESCLI,qbe_opep_chkdiana->DATAREG,qbe_opep_chkdiana->RAPPORTO,qbe_opep_chkdiana->FLAGRAP,'2',w_flgrae,qbe_opep_chkdiana->STATOREG,qbe_opep_chkdiana->DATARETT)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_opep_chkdiana.GetString("CONNESCLI"),Cursor_qbe_opep_chkdiana.GetDate("DATAREG"),Cursor_qbe_opep_chkdiana.GetString("RAPPORTO"),Cursor_qbe_opep_chkdiana.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_opep_chkdiana.GetString("STATOREG"),Cursor_qbe_opep_chkdiana.GetDate("DATARETT")));
              /* If w_flgchk='S' */
              if (CPLib.eqr(w_flgchk,"S")) {
                /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                Page_15();
              } else { // Else
                /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
              } // End If
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
            } // End If
          } else { // Else
            /* _oldrap := '' */
            _oldrap = "";
            // * --- Read from knarapbo
            m_cServer = m_Ctx.GetServer("knarapbo");
            m_cPhName = m_Ctx.GetPhName("knarapbo");
            m_cSql = "";
            m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_opep_chkdiana.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_qbe_opep_chkdiana.GetString("RAPPORTO"));
            if (m_Ctx.IsSharedTemp("knarapbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _oldrap = Read_Cursor.GetString("RAPPORTO");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on knarapbo into routine arrt_chkdiana_old returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _oldrap = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If not(Empty(_oldrap)) */
            if ( ! (CPLib.Empty(_oldrap))) {
              // * --- Select from knarapbo
              m_cServer = m_Ctx.GetServer("knarapbo");
              m_cPhName = m_Ctx.GetPhName("knarapbo");
              if (Cursor_knarapbo!=null)
                Cursor_knarapbo.Close();
              Cursor_knarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_opep_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("knarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_knarapbo.Eof())) {
                /* If knarapbo->TIPORAP='P' */
                if (CPLib.eqr(Cursor_knarapbo.GetString("TIPORAP"),"P")) {
                  // * --- Select from xntestbo
                  m_cServer = m_Ctx.GetServer("xntestbo");
                  m_cPhName = m_Ctx.GetPhName("xntestbo");
                  if (Cursor_xntestbo!=null)
                    Cursor_xntestbo.Close();
                  Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_opep_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_xntestbo.Eof())) {
                    /* If qbe_opep_chkdiana->RAPPORTO = xntestbo->RAPPORTO */
                    if (CPLib.eqr(Cursor_qbe_opep_chkdiana.GetString("RAPPORTO"),Cursor_xntestbo.GetString("RAPPORTO"))) {
                      /* _avanza := 0 */
                      _avanza = CPLib.Round(0,0);
                      /* If Empty(xntestbo->CODINTER) or xntestbo->STATOREG='2' or xntestbo->STATOREG='3' */
                      if (CPLib.Empty(Cursor_xntestbo.GetString("CODINTER")) || CPLib.eqr(Cursor_xntestbo.GetString("STATOREG"),"2") || CPLib.eqr(Cursor_xntestbo.GetString("STATOREG"),"3")) {
                        /* _avanza := 1 */
                        _avanza = CPLib.Round(1,0);
                      } // End If
                      /* If xntestbo->DATAINI > qbe_opep_chkdiana->DATAOPE */
                      if (CPLib.gt(Cursor_xntestbo.GetDate("DATAINI"),Cursor_qbe_opep_chkdiana.GetDate("DATAOPE"))) {
                        /* _avanza := 1 */
                        _avanza = CPLib.Round(1,0);
                      } // End If
                      /* If not(Empty(xntestbo->DATAFINE)) and xntestbo->DATAFINE < qbe_opep_chkdiana->DATAOPE */
                      if ( ! (CPLib.Empty(Cursor_xntestbo.GetDate("DATAFINE"))) && CPLib.lt(Cursor_xntestbo.GetDate("DATAFINE"),Cursor_qbe_opep_chkdiana.GetDate("DATAOPE"))) {
                        /* _avanza := 1 */
                        _avanza = CPLib.Round(1,0);
                      } // End If
                      /* If _avanza = 0 */
                      if (CPLib.eqr(_avanza,0)) {
                        /* _codrif := xntestbo->CODINTER */
                        _codrif = Cursor_xntestbo.GetString("CODINTER");
                        /* _note := w_tipinter + w_codinter */
                        _note = w_tipinter+w_codinter;
                        /* If Empty(qbe_opep_chkdiana->CONNESOPER) or (qbe_opep_chkdiana->CONNESOPER=qbe_opep_chkdiana->CONNESCLI) */
                        if (CPLib.Empty(Cursor_qbe_opep_chkdiana.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_opep_chkdiana.GetString("CONNESOPER"),Cursor_qbe_opep_chkdiana.GetString("CONNESCLI")))) {
                          /* _note := _note + '2' */
                          _note = _note+"2";
                        } else { // Else
                          /* _note := _note + '3' */
                          _note = _note+"3";
                        } // End If
                        /* _note := _note + _idereg */
                        _note = _note+_idereg;
                        /* _note := _note + LRTrim(arfn_datisog_sol(xntestbo->CODINTER,qbe_opep_chkdiana->DATAREG,qbe_opep_chkdiana->RAPPORTO,qbe_opep_chkdiana->FLAGRAP,'2',w_flgrae,qbe_opep_chkdiana->STATOREG,qbe_opep_chkdiana->DATARETT)) */
                        _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_xntestbo.GetString("CODINTER"),Cursor_qbe_opep_chkdiana.GetDate("DATAREG"),Cursor_qbe_opep_chkdiana.GetString("RAPPORTO"),Cursor_qbe_opep_chkdiana.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_opep_chkdiana.GetString("STATOREG"),Cursor_qbe_opep_chkdiana.GetDate("DATARETT")));
                        /* If w_flgchk='S' */
                        if (CPLib.eqr(w_flgchk,"S")) {
                          /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                          Page_15();
                        } else { // Else
                          /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                          FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                        } // End If
                        /* nTotRec := nTotRec + 1 */
                        nTotRec = CPLib.Round(nTotRec+1,0);
                        /* nNumRec := nNumRec + 1 */
                        nNumRec = CPLib.Round(nNumRec+1,0);
                      } // End If
                    } // End If
                    Cursor_xntestbo.Next();
                  }
                  m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
                  Cursor_xntestbo.Close();
                  // * --- End Select
                } else { // Else
                  // * --- Select from intestbo
                  m_cServer = m_Ctx.GetServer("intestbo");
                  m_cPhName = m_Ctx.GetPhName("intestbo");
                  if (Cursor_intestbo!=null)
                    Cursor_intestbo.Close();
                  Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_opep_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_intestbo.Eof())) {
                    /* If qbe_opep_chkdiana->RAPPORTO = intestbo->RAPPORTO */
                    if (CPLib.eqr(Cursor_qbe_opep_chkdiana.GetString("RAPPORTO"),Cursor_intestbo.GetString("RAPPORTO"))) {
                      /* _avanza := 0 */
                      _avanza = CPLib.Round(0,0);
                      /* If Empty(intestbo->CODINTER) or intestbo->STATOREG='2' or intestbo->STATOREG='3' */
                      if (CPLib.Empty(Cursor_intestbo.GetString("CODINTER")) || CPLib.eqr(Cursor_intestbo.GetString("STATOREG"),"2") || CPLib.eqr(Cursor_intestbo.GetString("STATOREG"),"3")) {
                        /* _avanza := 1 */
                        _avanza = CPLib.Round(1,0);
                      } // End If
                      /* If intestbo->DATAINI > qbe_opep_chkdiana->DATAOPE */
                      if (CPLib.gt(Cursor_intestbo.GetDate("DATAINI"),Cursor_qbe_opep_chkdiana.GetDate("DATAOPE"))) {
                        /* _avanza := 1 */
                        _avanza = CPLib.Round(1,0);
                      } // End If
                      /* If not(Empty(intestbo->DATAFINE)) and intestbo->DATAFINE < qbe_opep_chkdiana->DATAOPE */
                      if ( ! (CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE"))) && CPLib.lt(Cursor_intestbo.GetDate("DATAFINE"),Cursor_qbe_opep_chkdiana.GetDate("DATAOPE"))) {
                        /* _avanza := 1 */
                        _avanza = CPLib.Round(1,0);
                      } // End If
                      /* If _avanza = 0 */
                      if (CPLib.eqr(_avanza,0)) {
                        /* _codrif := intestbo->CODINTER */
                        _codrif = Cursor_intestbo.GetString("CODINTER");
                        /* _note := w_tipinter + w_codinter */
                        _note = w_tipinter+w_codinter;
                        /* If Empty(qbe_opep_chkdiana->CONNESOPER) or (qbe_opep_chkdiana->CONNESOPER=qbe_opep_chkdiana->CONNESCLI) */
                        if (CPLib.Empty(Cursor_qbe_opep_chkdiana.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_opep_chkdiana.GetString("CONNESOPER"),Cursor_qbe_opep_chkdiana.GetString("CONNESCLI")))) {
                          /* _note := _note + '2' */
                          _note = _note+"2";
                        } else { // Else
                          /* _note := _note + '3' */
                          _note = _note+"3";
                        } // End If
                        /* _note := _note + _idereg */
                        _note = _note+_idereg;
                        /* _note := _note + LRTrim(arfn_datisog_sol(intestbo->CODINTER,qbe_opep_chkdiana->DATAREG,qbe_opep_chkdiana->RAPPORTO,qbe_opep_chkdiana->FLAGRAP,'2',w_flgrae,qbe_opep_chkdiana->STATOREG,qbe_opep_chkdiana->DATARETT)) */
                        _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_intestbo.GetString("CODINTER"),Cursor_qbe_opep_chkdiana.GetDate("DATAREG"),Cursor_qbe_opep_chkdiana.GetString("RAPPORTO"),Cursor_qbe_opep_chkdiana.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_opep_chkdiana.GetString("STATOREG"),Cursor_qbe_opep_chkdiana.GetDate("DATARETT")));
                        /* If w_flgchk='S' */
                        if (CPLib.eqr(w_flgchk,"S")) {
                          /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                          Page_15();
                        } else { // Else
                          /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                          FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                        } // End If
                        /* nTotRec := nTotRec + 1 */
                        nTotRec = CPLib.Round(nTotRec+1,0);
                        /* nNumRec := nNumRec + 1 */
                        nNumRec = CPLib.Round(nNumRec+1,0);
                      } // End If
                    } // End If
                    Cursor_intestbo.Next();
                  }
                  m_cConnectivityError = Cursor_intestbo.ErrorMessage();
                  Cursor_intestbo.Close();
                  // * --- End Select
                } // End If
                Cursor_knarapbo.Next();
              }
              m_cConnectivityError = Cursor_knarapbo.ErrorMessage();
              Cursor_knarapbo.Close();
              // * --- End Select
            } else { // Else
              /* If not(Empty(LRTrim(qbe_opep_chkdiana->CONNESCLI))) */
              if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("CONNESCLI"))))) {
                /* _note := w_tipinter + w_codinter */
                _note = w_tipinter+w_codinter;
                /* If Empty(qbe_opep_chkdiana->CONNESOPER) or (qbe_opep_chkdiana->CONNESOPER=qbe_opep_chkdiana->CONNESCLI) */
                if (CPLib.Empty(Cursor_qbe_opep_chkdiana.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_opep_chkdiana.GetString("CONNESOPER"),Cursor_qbe_opep_chkdiana.GetString("CONNESCLI")))) {
                  /* _note := _note + '2' */
                  _note = _note+"2";
                } else { // Else
                  /* _note := _note + '3' */
                  _note = _note+"3";
                } // End If
                /* _note := _note + _idereg */
                _note = _note+_idereg;
                /* _note := _note + LRTrim(arfn_datisog_sol(qbe_opep_chkdiana->CONNESCLI,qbe_opep_chkdiana->DATAREG,qbe_opep_chkdiana->RAPPORTO,qbe_opep_chkdiana->FLAGRAP,'2',w_flgrae,qbe_opep_chkdiana->STATOREG,qbe_opep_chkdiana->DATARETT)) */
                _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_opep_chkdiana.GetString("CONNESCLI"),Cursor_qbe_opep_chkdiana.GetDate("DATAREG"),Cursor_qbe_opep_chkdiana.GetString("RAPPORTO"),Cursor_qbe_opep_chkdiana.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_opep_chkdiana.GetString("STATOREG"),Cursor_qbe_opep_chkdiana.GetDate("DATARETT")));
                /* If w_flgchk='S' */
                if (CPLib.eqr(w_flgchk,"S")) {
                  /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                  Page_15();
                } else { // Else
                  /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                  FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                } // End If
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
              } // End If
            } // End If
          } // End If
          /* If Empty(LRTrim(_oldrap)) */
          if (CPLib.Empty(CPLib.LRTrim(_oldrap))) {
            /* _oldrighe := 0 */
            _oldrighe = CPLib.Round(0,0);
            // * --- Select from xlientiope
            m_cServer = m_Ctx.GetServer("xlientiope");
            m_cPhName = m_Ctx.GetPhName("xlientiope");
            if (Cursor_xlientiope!=null)
              Cursor_xlientiope.Close();
            Cursor_xlientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_opep_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xlientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xlientiope.Eof())) {
              /* _note := w_tipinter + w_codinter */
              _note = w_tipinter+w_codinter;
              /* If Empty(qbe_opep_chkdiana->CONNESOPER) or (qbe_opep_chkdiana->CONNESOPER=xlientiope->CODSOG) */
              if (CPLib.Empty(Cursor_qbe_opep_chkdiana.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_opep_chkdiana.GetString("CONNESOPER"),Cursor_xlientiope.GetString("CODSOG")))) {
                /* _note := _note + '2' */
                _note = _note+"2";
              } else { // Else
                /* _note := _note + '3' */
                _note = _note+"3";
              } // End If
              /* If Empty(LRTrim(qbe_opep_chkdiana->FLAGRAP2)) */
              if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("FLAGRAP2")))) {
                /* _note := _note + DateToChar(qbe_opep_chkdiana->DATAOPE) + qbe_opep_chkdiana->NUMPROG + 'S' */
                _note = _note+CPLib.DateToChar(Cursor_qbe_opep_chkdiana.GetDate("DATAOPE"))+Cursor_qbe_opep_chkdiana.GetString("NUMPROG")+"S";
              } else { // Else
                /* _note := _note + qbe_opep_chkdiana->IDEREG */
                _note = _note+Cursor_qbe_opep_chkdiana.GetString("IDEREG");
              } // End If
              /* _note := _note + LRTrim(arfn_datisog_sol(xlientiope->CODSOG,qbe_opep_chkdiana->DATAREG,qbe_opep_chkdiana->RAPPORTO,qbe_opep_chkdiana->FLAGRAP,'2',w_flgrae,qbe_opep_chkdiana->STATOREG,qbe_opep_chkdiana->DATARETT)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_xlientiope.GetString("CODSOG"),Cursor_qbe_opep_chkdiana.GetDate("DATAREG"),Cursor_qbe_opep_chkdiana.GetString("RAPPORTO"),Cursor_qbe_opep_chkdiana.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_opep_chkdiana.GetString("STATOREG"),Cursor_qbe_opep_chkdiana.GetDate("DATARETT")));
              /* If w_flgchk='S' */
              if (CPLib.eqr(w_flgchk,"S")) {
                /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                Page_15();
              } else { // Else
                /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
              } // End If
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
              Cursor_xlientiope.Next();
            }
            m_cConnectivityError = Cursor_xlientiope.ErrorMessage();
            Cursor_xlientiope.Close();
            // * --- End Select
          } // End If
          /* If not(Empty(qbe_opep_chkdiana->CONNESOPER)) and qbe_opep_chkdiana->CONNESOPER <> _codrif */
          if ( ! (CPLib.Empty(Cursor_qbe_opep_chkdiana.GetString("CONNESOPER"))) && CPLib.ne(Cursor_qbe_opep_chkdiana.GetString("CONNESOPER"),_codrif)) {
            /* _note := w_tipinter + w_codinter+'4'+_idereg */
            _note = w_tipinter+w_codinter+"4"+_idereg;
            /* _note := _note + LRTrim(arfn_datisog_sol(qbe_opep_chkdiana->CONNESOPER,qbe_opep_chkdiana->DATAREG,qbe_opep_chkdiana->RAPPORTO,qbe_opep_chkdiana->FLAGRAP,'4',w_flgrae,qbe_opep_chkdiana->STATOREG,qbe_opep_chkdiana->DATARETT)) */
            _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_opep_chkdiana.GetString("CONNESOPER"),Cursor_qbe_opep_chkdiana.GetDate("DATAREG"),Cursor_qbe_opep_chkdiana.GetString("RAPPORTO"),Cursor_qbe_opep_chkdiana.GetString("FLAGRAP"),"4",w_flgrae,Cursor_qbe_opep_chkdiana.GetString("STATOREG"),Cursor_qbe_opep_chkdiana.GetDate("DATARETT")));
            /* If w_flgchk='S' */
            if (CPLib.eqr(w_flgchk,"S")) {
              /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
              Page_15();
            } else { // Else
              /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
              FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
            } // End If
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
          } // End If
          // * --- Select from xogopebo
          m_cServer = m_Ctx.GetServer("xogopebo");
          m_cPhName = m_Ctx.GetPhName("xogopebo");
          if (Cursor_xogopebo!=null)
            Cursor_xogopebo.Close();
          Cursor_xogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_opep_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_xogopebo.Eof())) {
            /* _note := w_tipinter + w_codinter+'4'+_idereg */
            _note = w_tipinter+w_codinter+"4"+_idereg;
            /* _note := _note + LRTrim(arfn_datisog_sol(xogopebo->CODSOG,qbe_opep_chkdiana->DATAREG,qbe_opep_chkdiana->RAPPORTO,qbe_opep_chkdiana->FLAGRAP,'4',w_flgrae,qbe_opep_chkdiana->STATOREG,qbe_opep_chkdiana->DATARETT)) */
            _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_xogopebo.GetString("CODSOG"),Cursor_qbe_opep_chkdiana.GetDate("DATAREG"),Cursor_qbe_opep_chkdiana.GetString("RAPPORTO"),Cursor_qbe_opep_chkdiana.GetString("FLAGRAP"),"4",w_flgrae,Cursor_qbe_opep_chkdiana.GetString("STATOREG"),Cursor_qbe_opep_chkdiana.GetDate("DATARETT")));
            /* If w_flgchk='S' */
            if (CPLib.eqr(w_flgchk,"S")) {
              /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
              Page_15();
            } else { // Else
              /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
              FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
            } // End If
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
            Cursor_xogopebo.Next();
          }
          m_cConnectivityError = Cursor_xogopebo.ErrorMessage();
          Cursor_xogopebo.Close();
          // * --- End Select
          /* If not(Empty(qbe_opep_chkdiana->CONNESBEN)) or not(Empty(qbe_opep_chkdiana->C_RAG)) */
          if ( ! (CPLib.Empty(Cursor_qbe_opep_chkdiana.GetString("CONNESBEN"))) ||  ! (CPLib.Empty(Cursor_qbe_opep_chkdiana.GetString("C_RAG")))) {
            /* If not(Empty(qbe_opep_chkdiana->C_RAG)) */
            if ( ! (CPLib.Empty(Cursor_qbe_opep_chkdiana.GetString("C_RAG")))) {
              /* _note := w_tipinter + w_codinter+'5' + _idereg */
              _note = w_tipinter+w_codinter+"5"+_idereg;
              /* _note := _note + Left(LRTrim(qbe_opep_chkdiana->CONNESBEN)+Space(16),16) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("CONNESBEN"))+CPLib.Space(16),16);
              /* _note := _note +Left(LRTrim(arfn_agechar(qbe_opep_chkdiana->C_RAG,' '))+Space(70),70) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_opep_chkdiana.GetString("C_RAG")," "))+CPLib.Space(70),70);
              /* _note := _note + Left(LRTrim(qbe_opep_chkdiana->C_STA)+Space(3),3) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_STA"))+CPLib.Space(3),3);
              /* _note := _note +Left(LRTrim(qbe_opep_chkdiana->C_CAB)+Space(6),6) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_CAB"))+CPLib.Space(6),6);
              /* _note := _note +Left(LRTrim(arfn_agechar(qbe_opep_chkdiana->C_CTA,' '))+Space(30),30) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_opep_chkdiana.GetString("C_CTA")," "))+CPLib.Space(30),30);
              /* _note := _note + Left(LRTrim(qbe_opep_chkdiana->C_PRV)+Space(2),2) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_PRV"))+CPLib.Space(2),2);
              /* _note := _note + Left(LRTrim(arfn_agechar(qbe_opep_chkdiana->C_IND,' '))+Space(35),35) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_opep_chkdiana.GetString("C_IND")," "))+CPLib.Space(35),35);
              /* _note := _note + Left(LRTrim(qbe_opep_chkdiana->C_CAP)+Space(5),5) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_CAP"))+CPLib.Space(5),5);
              /* _note := _note + Space(63) */
              _note = _note+CPLib.Space(63);
              /* _note := _note + Left(LRTrim(qbe_opep_chkdiana->C_RAPPORTO)+Space(25),25) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
              /* _note := _note + Space(91) */
              _note = _note+CPLib.Space(91);
              /* If w_flgchk='S' */
              if (CPLib.eqr(w_flgchk,"S")) {
                /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                Page_15();
              } else { // Else
                /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
              } // End If
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
              /* ElseIf not(Empty(qbe_opep_chkdiana->CONNESBEN)) */
            } else if ( ! (CPLib.Empty(Cursor_qbe_opep_chkdiana.GetString("CONNESBEN")))) {
              /* _numsto := arfn_chkspers(qbe_opep_chkdiana->CONNESBEN,qbe_opep_chkdiana->DATAREG) */
              _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_opep_chkdiana.GetString("CONNESBEN"),Cursor_qbe_opep_chkdiana.GetDate("DATAREG"));
              /* If Empty(LRTrim(_numsto)) */
              if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_opep_chkdiana.GetString("CONNESBEN"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* _note := w_tipinter + w_codinter+'5' + _idereg */
                  _note = w_tipinter+w_codinter+"5"+_idereg;
                  /* _note := _note + Left(LRTrim(qbe_opep_chkdiana->CONNESBEN)+Space(16),16) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("CONNESBEN"))+CPLib.Space(16),16);
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_opep_chkdiana->C_RAG))),Left(LRTrim(arfn_agechar(qbe_opep_chkdiana->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(personbo->RAGSOC,' '))+Space(70),70)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_opep_chkdiana.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_opep_chkdiana->C_STA))),Left(LRTrim(qbe_opep_chkdiana->C_STA)+Space(3),3),Left(LRTrim(personbo->PAESE)+Space(3),3)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_opep_chkdiana->C_CAB))),Left(LRTrim(qbe_opep_chkdiana->C_CAB)+Space(6),6),Left(LRTrim(personbo->CODCAB)+Space(6),6)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_opep_chkdiana->C_CTA))),Left(LRTrim(arfn_agechar(qbe_opep_chkdiana->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(personbo->DESCCIT,' '))+Space(30),30)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_opep_chkdiana.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_opep_chkdiana->C_PRV))),Left(LRTrim(qbe_opep_chkdiana->C_PRV)+Space(2),2),Left(LRTrim(personbo->PROVINCIA)+Space(2),2)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_opep_chkdiana->C_IND))),Left(LRTrim(arfn_agechar(qbe_opep_chkdiana->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(personbo->DOMICILIO,' '))+Space(35),35)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_opep_chkdiana.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_opep_chkdiana->C_CAP))),Left(LRTrim(qbe_opep_chkdiana->C_CAP)+Space(5),5),Left(LRTrim(personbo->CAP)+Space(5),5)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5));
                  /* _note := _note + Space(63) */
                  _note = _note+CPLib.Space(63);
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_opep_chkdiana->C_RAPPORTO))),Left(LRTrim(qbe_opep_chkdiana->C_RAPPORTO)+Space(25),25),Left(LRTrim(qbe_opep_chkdiana->RAPPORTBEN)+Space(25),25)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_RAPPORTO"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_RAPPORTO"))+CPLib.Space(25),25):CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("RAPPORTBEN"))+CPLib.Space(25),25));
                  /* _note := _note + Space(91) */
                  _note = _note+CPLib.Space(91);
                  /* If w_flgchk='S' */
                  if (CPLib.eqr(w_flgchk,"S")) {
                    /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                    Page_15();
                  } else { // Else
                    /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                    FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                  } // End If
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } else { // Else
                // * --- Select from wersonbo
                m_cServer = m_Ctx.GetServer("wersonbo");
                m_cPhName = m_Ctx.GetPhName("wersonbo");
                if (Cursor_wersonbo!=null)
                  Cursor_wersonbo.Close();
                Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_wersonbo.Eof())) {
                  /* _note := w_tipinter + w_codinter+'5' + _idereg */
                  _note = w_tipinter+w_codinter+"5"+_idereg;
                  /* _note := _note + Left(LRTrim(qbe_opep_chkdiana->CONNESBEN)+Space(16),16) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("CONNESBEN"))+CPLib.Space(16),16);
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_opep_chkdiana->C_RAG))),Left(LRTrim(arfn_agechar(qbe_opep_chkdiana->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(wersonbo->RAGSOC,' '))+Space(70),70)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_opep_chkdiana.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_opep_chkdiana->C_STA))),Left(LRTrim(qbe_opep_chkdiana->C_STA)+Space(3),3),Left(LRTrim(wersonbo->PAESE)+Space(3),3)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PAESE"))+CPLib.Space(3),3));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_opep_chkdiana->C_CAB))),Left(LRTrim(qbe_opep_chkdiana->C_CAB)+Space(6),6),Left(LRTrim(wersonbo->CODCAB)+Space(6),6)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CODCAB"))+CPLib.Space(6),6));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_opep_chkdiana->C_CTA))),Left(LRTrim(arfn_agechar(qbe_opep_chkdiana->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(wersonbo->DESCCIT,' '))+Space(30),30)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_opep_chkdiana.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_opep_chkdiana->C_PRV))),Left(LRTrim(qbe_opep_chkdiana->C_PRV)+Space(2),2),Left(LRTrim(wersonbo->PROVINCIA)+Space(2),2)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_opep_chkdiana->C_IND))),Left(LRTrim(arfn_agechar(qbe_opep_chkdiana->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(wersonbo->DOMICILIO,' '))+Space(35),35)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_opep_chkdiana.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_opep_chkdiana->C_CAP))),Left(LRTrim(qbe_opep_chkdiana->C_CAP)+Space(5),5),Left(LRTrim(wersonbo->CAP)+Space(5),5)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CAP"))+CPLib.Space(5),5));
                  /* _note := _note + Space(63) */
                  _note = _note+CPLib.Space(63);
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_opep_chkdiana->C_RAPPORTO))),Left(LRTrim(qbe_opep_chkdiana->C_RAPPORTO)+Space(25),25),Left(LRTrim(qbe_opep_chkdiana->RAPPORTBEN)+Space(25),25)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_RAPPORTO"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_RAPPORTO"))+CPLib.Space(25),25):CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("RAPPORTBEN"))+CPLib.Space(25),25));
                  /* _note := _note + Space(91) */
                  _note = _note+CPLib.Space(91);
                  /* If w_flgchk='S' */
                  if (CPLib.eqr(w_flgchk,"S")) {
                    /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                    Page_15();
                  } else { // Else
                    /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                    FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                  } // End If
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_wersonbo.Next();
                }
                m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                Cursor_wersonbo.Close();
                // * --- End Select
              } // End If
            } // End If
          } // End If
          // * --- Select from xeneficope
          m_cServer = m_Ctx.GetServer("xeneficope");
          m_cPhName = m_Ctx.GetPhName("xeneficope");
          if (Cursor_xeneficope!=null)
            Cursor_xeneficope.Close();
          Cursor_xeneficope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_opep_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xeneficope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_xeneficope.Eof())) {
            /* If Empty(LRTrim(xeneficope->CODSOG)) and not(Empty(LRTrim(xeneficope->C_RAG))) */
            if (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficope.GetString("CODSOG"))) &&  ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficope.GetString("C_RAG"))))) {
              /* _note := w_tipinter + w_codinter+'5' + _idereg */
              _note = w_tipinter+w_codinter+"5"+_idereg;
              /* _note := _note + Left(LRTrim(xeneficope->CODSOG)+Space(16),16) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("CODSOG"))+CPLib.Space(16),16);
              /* _note := _note +Left(LRTrim(arfn_agechar(xeneficope->C_RAG,' '))+Space(70),70) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_xeneficope.GetString("C_RAG")," "))+CPLib.Space(70),70);
              /* _note := _note + Left(LRTrim(xeneficope->C_STA)+Space(3),3) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("C_STA"))+CPLib.Space(3),3);
              /* _note := _note +Left(LRTrim(xeneficope->C_CAB)+Space(6),6) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("C_CAB"))+CPLib.Space(6),6);
              /* _note := _note +Left(LRTrim(arfn_agechar(xeneficope->C_CTA,' '))+Space(30),30) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_xeneficope.GetString("C_CTA")," "))+CPLib.Space(30),30);
              /* _note := _note + Left(LRTrim(xeneficope->C_PRV)+Space(2),2) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("C_PRV"))+CPLib.Space(2),2);
              /* _note := _note + Left(LRTrim(arfn_agechar(xeneficope->C_IND,' '))+Space(35),35) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_xeneficope.GetString("C_IND")," "))+CPLib.Space(35),35);
              /* _note := _note + Left(LRTrim(xeneficope->C_CAP)+Space(5),5) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("C_CAP"))+CPLib.Space(5),5);
              /* _note := _note + Space(63) */
              _note = _note+CPLib.Space(63);
              /* _note := _note + Left(LRTrim(xeneficope->C_RAPPORTO)+Space(25),25) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
              /* _note := _note + Space(91) */
              _note = _note+CPLib.Space(91);
              /* If w_flgchk='S' */
              if (CPLib.eqr(w_flgchk,"S")) {
                /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                Page_15();
              } else { // Else
                /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
              } // End If
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
            } else { // Else
              /* _numsto := arfn_chkspers(xeneficope->CODSOG,qbe_opep_chkdiana->DATAREG) */
              _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_xeneficope.GetString("CODSOG"),Cursor_qbe_opep_chkdiana.GetDate("DATAREG"));
              /* If Empty(LRTrim(_numsto)) */
              if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xeneficope.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* _note := w_tipinter + w_codinter+'5' + _idereg */
                  _note = w_tipinter+w_codinter+"5"+_idereg;
                  /* _note := _note + Left(LRTrim(xeneficope->CODSOG)+Space(16),16) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("CODSOG"))+CPLib.Space(16),16);
                  /* _note := _note + iif(not(Empty(LRTrim(xeneficope->C_RAG))),Left(LRTrim(arfn_agechar(xeneficope->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(personbo->RAGSOC,' '))+Space(70),70)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficope.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_xeneficope.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                  /* _note := _note + iif(not(Empty(LRTrim(xeneficope->C_STA))),Left(LRTrim(xeneficope->C_STA)+Space(3),3),Left(LRTrim(personbo->PAESE)+Space(3),3)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficope.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3));
                  /* _note := _note + iif(not(Empty(LRTrim(xeneficope->C_CAB))),Left(LRTrim(xeneficope->C_CAB)+Space(6),6),Left(LRTrim(personbo->CODCAB)+Space(6),6)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficope.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6));
                  /* _note := _note + iif(not(Empty(LRTrim(xeneficope->C_CTA))),Left(LRTrim(arfn_agechar(xeneficope->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(personbo->DESCCIT,' '))+Space(30),30)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficope.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_xeneficope.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                  /* _note := _note + iif(not(Empty(LRTrim(xeneficope->C_PRV))),Left(LRTrim(xeneficope->C_PRV)+Space(2),2),Left(LRTrim(personbo->PROVINCIA)+Space(2),2)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficope.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                  /* _note := _note + iif(not(Empty(LRTrim(xeneficope->C_IND))),Left(LRTrim(arfn_agechar(xeneficope->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(personbo->DOMICILIO,' '))+Space(35),35)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficope.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_xeneficope.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                  /* _note := _note + iif(not(Empty(LRTrim(xeneficope->C_CAP))),Left(LRTrim(xeneficope->C_CAP)+Space(5),5),Left(LRTrim(personbo->CAP)+Space(5),5)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficope.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5));
                  /* _note := _note + Space(63) */
                  _note = _note+CPLib.Space(63);
                  /* _note := _note +Left(LRTrim(xeneficope->C_RAPPORTO)+Space(25),25) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                  /* _note := _note + Space(91) */
                  _note = _note+CPLib.Space(91);
                  /* If w_flgchk='S' */
                  if (CPLib.eqr(w_flgchk,"S")) {
                    /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                    Page_15();
                  } else { // Else
                    /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                    FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                  } // End If
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } else { // Else
                // * --- Select from wersonbo
                m_cServer = m_Ctx.GetServer("wersonbo");
                m_cPhName = m_Ctx.GetPhName("wersonbo");
                if (Cursor_wersonbo!=null)
                  Cursor_wersonbo.Close();
                Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_wersonbo.Eof())) {
                  /* _note := w_tipinter + w_codinter+'5' + _idereg */
                  _note = w_tipinter+w_codinter+"5"+_idereg;
                  /* _note := _note + Left(LRTrim(xeneficope->CODSOG)+Space(16),16) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("CODSOG"))+CPLib.Space(16),16);
                  /* _note := _note + iif(not(Empty(LRTrim(xeneficope->C_RAG))),Left(LRTrim(arfn_agechar(xeneficope->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(wersonbo->RAGSOC,' '))+Space(70),70)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficope.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_xeneficope.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                  /* _note := _note + iif(not(Empty(LRTrim(xeneficope->C_STA))),Left(LRTrim(xeneficope->C_STA)+Space(3),3),Left(LRTrim(wersonbo->PAESE)+Space(3),3)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficope.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PAESE"))+CPLib.Space(3),3));
                  /* _note := _note + iif(not(Empty(LRTrim(xeneficope->C_CAB))),Left(LRTrim(xeneficope->C_CAB)+Space(6),6),Left(LRTrim(wersonbo->CODCAB)+Space(6),6)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficope.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CODCAB"))+CPLib.Space(6),6));
                  /* _note := _note + iif(not(Empty(LRTrim(xeneficope->C_CTA))),Left(LRTrim(arfn_agechar(xeneficope->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(wersonbo->DESCCIT,' '))+Space(30),30)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficope.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_xeneficope.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                  /* _note := _note + iif(not(Empty(LRTrim(xeneficope->C_PRV))),Left(LRTrim(xeneficope->C_PRV)+Space(2),2),Left(LRTrim(wersonbo->PROVINCIA)+Space(2),2)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficope.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                  /* _note := _note + iif(not(Empty(LRTrim(xeneficope->C_IND))),Left(LRTrim(arfn_agechar(xeneficope->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(wersonbo->DOMICILIO,' '))+Space(35),35)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficope.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_xeneficope.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                  /* _note := _note + iif(not(Empty(LRTrim(xeneficope->C_CAP))),Left(LRTrim(xeneficope->C_CAP)+Space(5),5),Left(LRTrim(wersonbo->CAP)+Space(5),5)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficope.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CAP"))+CPLib.Space(5),5));
                  /* _note := _note + Space(63) */
                  _note = _note+CPLib.Space(63);
                  /* _note := _note +Left(LRTrim(xeneficope->C_RAPPORTO)+Space(25),25) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                  /* _note := _note + Space(91) */
                  _note = _note+CPLib.Space(91);
                  /* If w_flgchk='S' */
                  if (CPLib.eqr(w_flgchk,"S")) {
                    /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                    Page_15();
                  } else { // Else
                    /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                    FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                  } // End If
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_wersonbo.Next();
                }
                m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                Cursor_wersonbo.Close();
                // * --- End Select
              } // End If
            } // End If
            Cursor_xeneficope.Next();
          }
          m_cConnectivityError = Cursor_xeneficope.ErrorMessage();
          Cursor_xeneficope.Close();
          // * --- End Select
          /* If not(Empty(qbe_opep_chkdiana->CONNALTRO)) */
          if ( ! (CPLib.Empty(Cursor_qbe_opep_chkdiana.GetString("CONNALTRO")))) {
            /* _note := w_tipinter + w_codinter+'6' + _idereg */
            _note = w_tipinter+w_codinter+"6"+_idereg;
            /* _note := _note + LRTrim(arfn_datisog_sol(qbe_opep_chkdiana->CONNALTRO,qbe_opep_chkdiana->DATAREG,qbe_opep_chkdiana->RAPPORTO,qbe_opep_chkdiana->FLAGRAP,'6',w_flgrae,qbe_opep_chkdiana->STATOREG,qbe_opep_chkdiana->DATARETT)) */
            _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_opep_chkdiana.GetString("CONNALTRO"),Cursor_qbe_opep_chkdiana.GetDate("DATAREG"),Cursor_qbe_opep_chkdiana.GetString("RAPPORTO"),Cursor_qbe_opep_chkdiana.GetString("FLAGRAP"),"6",w_flgrae,Cursor_qbe_opep_chkdiana.GetString("STATOREG"),Cursor_qbe_opep_chkdiana.GetDate("DATARETT")));
            /* If w_flgchk='S' */
            if (CPLib.eqr(w_flgchk,"S")) {
              /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
              Page_15();
            } else { // Else
              /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
              FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
            } // End If
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
          } // End If
          // * --- Select from xerzistiope
          m_cServer = m_Ctx.GetServer("xerzistiope");
          m_cPhName = m_Ctx.GetPhName("xerzistiope");
          if (Cursor_xerzistiope!=null)
            Cursor_xerzistiope.Close();
          Cursor_xerzistiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_opep_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xerzistiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_xerzistiope.Eof())) {
            /* _note := w_tipinter + w_codinter+'6' + _idereg */
            _note = w_tipinter+w_codinter+"6"+_idereg;
            /* _note := _note + LRTrim(arfn_datisog_sol(xerzistiope->CODSOG,qbe_opep_chkdiana->DATAREG,qbe_opep_chkdiana->RAPPORTO,qbe_opep_chkdiana->FLAGRAP,'6',w_flgrae,qbe_opep_chkdiana->STATOREG,qbe_opep_chkdiana->DATARETT)) */
            _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_xerzistiope.GetString("CODSOG"),Cursor_qbe_opep_chkdiana.GetDate("DATAREG"),Cursor_qbe_opep_chkdiana.GetString("RAPPORTO"),Cursor_qbe_opep_chkdiana.GetString("FLAGRAP"),"6",w_flgrae,Cursor_qbe_opep_chkdiana.GetString("STATOREG"),Cursor_qbe_opep_chkdiana.GetDate("DATARETT")));
            /* If w_flgchk='S' */
            if (CPLib.eqr(w_flgchk,"S")) {
              /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
              Page_15();
            } else { // Else
              /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
              FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
            } // End If
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
            Cursor_xerzistiope.Next();
          }
          m_cConnectivityError = Cursor_xerzistiope.ErrorMessage();
          Cursor_xerzistiope.Close();
          // * --- End Select
          /* gNumRec := nTotRec // N� Record DIANA */
          gNumRec = CPLib.Round(nTotRec,0);
          m_Ctx.SetGlobalNumber("gNumRec",gNumRec);
          /* gNumReg := nTotReg // N� Registrazioni DIANA */
          gNumReg = CPLib.Round(nTotReg,0);
          m_Ctx.SetGlobalNumber("gNumReg",gNumReg);
          Cursor_qbe_opep_chkdiana.Next();
        }
        m_cConnectivityError = Cursor_qbe_opep_chkdiana.ErrorMessage();
        Cursor_qbe_opep_chkdiana.Close();
        // * --- End Select
        /* _contacilci := _contacilci+1 */
        _contacilci = CPLib.Round(_contacilci+1,0);
      } // End While
    } finally {
      try {
        if (Cursor_qbe_opep_chkdiana_limits!=null)
          Cursor_qbe_opep_chkdiana_limits.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_opep_chkdiana!=null)
          Cursor_qbe_opep_chkdiana.Close();
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
        if (Cursor_xnarapbo!=null)
          Cursor_xnarapbo.Close();
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
        if (Cursor_anadip!=null)
          Cursor_anadip.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_kersonbo!=null)
          Cursor_kersonbo.Close();
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
        if (Cursor_xntestbo!=null)
          Cursor_xntestbo.Close();
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
        if (Cursor_xlientiope!=null)
          Cursor_xlientiope.Close();
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
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
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
      try {
        if (Cursor_xerzistiope!=null)
          Cursor_xerzistiope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_9() throws Exception {
    CPResultSet Cursor_qbe_frad_chkdiana_limits=null;
    CPResultSet Cursor_qbe_frad_chkdiana=null;
    CPResultSet Cursor_anarapbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_anadip=null;
    CPResultSet Cursor_kersonbo=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_mlientifrz=null;
    CPResultSet Cursor_clientifrz=null;
    CPResultSet Cursor_mogopefbo=null;
    CPResultSet Cursor_sogopefbo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_meneficfrz=null;
    CPResultSet Cursor_beneficfrz=null;
    CPResultSet Cursor_merzistifrz=null;
    CPResultSet Cursor_terzistifrz=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Cicla sulle frazionate */
      /* gMsgImp := 'Verifica Frazionate da elaborare ...' // Messaggio Import */
      gMsgImp = "Verifica Frazionate da elaborare ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* _max := 0 */
      _max = CPLib.Round(0,0);
      /* _min := 0 */
      _min = CPLib.Round(0,0);
      /* _ciclo := 0 */
      _ciclo = CPLib.Round(0,0);
      /* Prima gli italiani */
      // * --- Select from qbe_frad_chkdiana_limits
      SPBridge.HMCaller _hNNYQQQCCAN;
      _hNNYQQQCCAN = new SPBridge.HMCaller();
      _hNNYQQQCCAN.Set("m_cVQRList",m_cVQRList);
      _hNNYQQQCCAN.Set("cdadata",w_cdadata);
      _hNNYQQQCCAN.Set("c_adata",w_c_adata);
      _hNNYQQQCCAN.Set("codage",w_codage);
      _hNNYQQQCCAN.Set("codcli",w_codcli);
      _hNNYQQQCCAN.Set("ragben",w_ragben);
      if (Cursor_qbe_frad_chkdiana_limits!=null)
        Cursor_qbe_frad_chkdiana_limits.Close();
      Cursor_qbe_frad_chkdiana_limits = new VQRHolder("qbe_frad_chkdiana_limits",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_hNNYQQQCCAN,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_frad_chkdiana_limits.Eof())) {
        /* _max := qbe_frad_chkdiana_limits->MAXFRZ */
        _max = CPLib.Round(Cursor_qbe_frad_chkdiana_limits.GetDouble("MAXFRZ"),0);
        /* _min := qbe_frad_chkdiana_limits->MINFRZ */
        _min = CPLib.Round(Cursor_qbe_frad_chkdiana_limits.GetDouble("MINFRZ"),0);
        Cursor_qbe_frad_chkdiana_limits.Next();
      }
      m_cConnectivityError = Cursor_qbe_frad_chkdiana_limits.ErrorMessage();
      Cursor_qbe_frad_chkdiana_limits.Close();
      // * --- End Select
      /* _cicli := iif(Mod(_max,5000) <> 0,Int(_max/5000) + 1,Int(_max/5000)) */
      _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,5000),0)?CPLib.Int(_max/5000)+1:CPLib.Int(_max/5000)),0);
      /* _bottom := _min */
      _bottom = CPLib.Round(_min,0);
      /* If _min > 5000 */
      if (CPLib.gt(_min,5000)) {
        /* _contacilci := Int(_min/5000) + 1 */
        _contacilci = CPLib.Round(CPLib.Int(_min/5000)+1,0);
      } else { // Else
        /* _contacilci := 1 */
        _contacilci = CPLib.Round(1,0);
      } // End If
      /* gMsgImp := 'Lettura operazioni in corso ...' // Messaggio Import */
      gMsgImp = "Lettura operazioni in corso ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* While _contacilci<=_cicli */
      while (CPLib.le(_contacilci,_cicli)) {
        /* _bottom := iif(_ciclo=0,_bottom,((_contacilci -1 ) * 5000) + 1) */
        _bottom = CPLib.Round((CPLib.eqr(_ciclo,0)?_bottom:((_contacilci-1)*5000)+1),0);
        /* _top := _contacilci * 5000 */
        _top = CPLib.Round(_contacilci*5000,0);
        /* _ciclo := 1 */
        _ciclo = CPLib.Round(1,0);
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
        /* gMsgImp := 'Lettura frazionate in corso ... Ciclo N. '+LRTrim(Str(_contacilci,10,0)) // Messaggio Import */
        gMsgImp = "Lettura frazionate in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacilci,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* Cicla sulle operazioni */
        // * --- Select from qbe_frad_chkdiana
        SPBridge.HMCaller _hCZHPJFSKPI;
        _hCZHPJFSKPI = new SPBridge.HMCaller();
        _hCZHPJFSKPI.Set("m_cVQRList",m_cVQRList);
        _hCZHPJFSKPI.Set("cdadata",w_cdadata);
        _hCZHPJFSKPI.Set("c_adata",w_c_adata);
        _hCZHPJFSKPI.Set("codage",w_codage);
        _hCZHPJFSKPI.Set("_bottom",_bottom);
        _hCZHPJFSKPI.Set("_top",_top);
        _hCZHPJFSKPI.Set("codcli",w_codcli);
        _hCZHPJFSKPI.Set("ragben",w_ragben);
        if (Cursor_qbe_frad_chkdiana!=null)
          Cursor_qbe_frad_chkdiana.Close();
        Cursor_qbe_frad_chkdiana = new VQRHolder("qbe_frad_chkdiana",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_hCZHPJFSKPI,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_frad_chkdiana.Eof())) {
          /* _ctotale := _ctotale + 1 */
          _ctotale = CPLib.Round(_ctotale+1,0);
          /* gMsgImp := 'Elaborazione Frazionata N.: '+LRTrim(Str(_ctotale,15,0)) // Messaggio Import */
          gMsgImp = "Elaborazione Frazionata N.: "+CPLib.LRTrim(CPLib.Str(_ctotale,15,0));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* If Empty(LRTrim(qbe_frad_chkdiana->FLAGRAP2)) */
          if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("FLAGRAP2")))) {
            /* _idereg := DateToChar(qbe_frad_chkdiana->DATAOPE) + "F" + Right(qbe_frad_chkdiana->NUMPROG,10) + 'S' */
            _idereg = CPLib.DateToChar(Cursor_qbe_frad_chkdiana.GetDate("DATAOPE"))+"F"+CPLib.Right(Cursor_qbe_frad_chkdiana.GetString("NUMPROG"),10)+"S";
          } else { // Else
            /* _idereg := Left(qbe_frad_chkdiana->IDEREG,8) + "F" + Right(qbe_frad_chkdiana->IDEREG,11) */
            _idereg = CPLib.Left(Cursor_qbe_frad_chkdiana.GetString("IDEREG"),8)+"F"+CPLib.Right(Cursor_qbe_frad_chkdiana.GetString("IDEREG"),11);
          } // End If
          /* _note := w_tipinter + w_codinter + '1' + _idereg */
          _note = w_tipinter+w_codinter+"1"+_idereg;
          /* _flagrap := '' */
          _flagrap = "";
          // * --- Select from anarapbo
          m_cServer = m_Ctx.GetServer("anarapbo");
          m_cPhName = m_Ctx.GetPhName("anarapbo");
          if (Cursor_anarapbo!=null)
            Cursor_anarapbo.Close();
          Cursor_anarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select TIPORAP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("anarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_anarapbo.Eof())) {
            /* _flagrap := anarapbo->TIPORAP */
            _flagrap = Cursor_anarapbo.GetString("TIPORAP");
            Cursor_anarapbo.Next();
          }
          m_cConnectivityError = Cursor_anarapbo.ErrorMessage();
          Cursor_anarapbo.Close();
          // * --- End Select
          /* _flagrap := iif(Empty(LRTrim(_flagrap)),qbe_frad_chkdiana->FLAGRAP,_flagrap) */
          _flagrap = (CPLib.Empty(CPLib.LRTrim(_flagrap))?Cursor_qbe_frad_chkdiana.GetString("FLAGRAP"):_flagrap);
          /* If Empty(qbe_frad_chkdiana->CODDIPE) */
          if (CPLib.Empty(Cursor_qbe_frad_chkdiana.GetString("CODDIPE"))) {
            // * --- Read from intermbo
            m_cServer = m_Ctx.GetServer("intermbo");
            m_cPhName = m_Ctx.GetPhName("intermbo");
            m_cSql = "";
            m_cSql = m_cSql+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codinter,"C",11,0,m_cServer),m_cServer,w_codinter);
            if (m_Ctx.IsSharedTemp("intermbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODCAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODDIPE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              w_codcab = Read_Cursor.GetString("CODCAB");
              w_desccit = Read_Cursor.GetString("DESCCIT");
              w_provin = Read_Cursor.GetString("PROVINCIA");
              w_coddipe = Read_Cursor.GetString("CODDIPE");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on intermbo into routine arrt_chkdiana_old returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              w_codcab = "";
              w_desccit = "";
              w_provin = "";
              w_coddipe = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(w_coddipe) */
            if (CPLib.Empty(w_coddipe)) {
              /* _note := _note + '000000' + Left(LRTrim(w_codcab)+Space(6),6) + Left(LRTrim(w_desccit)+Space(30),30) + Left(LRTrim(w_provin)+Space(2),2) */
              _note = _note+"000000"+CPLib.Left(CPLib.LRTrim(w_codcab)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(w_desccit)+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(w_provin)+CPLib.Space(2),2);
            } else { // Else
              /* _note := _note + w_coddipe */
              _note = _note+w_coddipe;
              // * --- Read from anadip
              m_cServer = m_Ctx.GetServer("anadip");
              m_cPhName = m_Ctx.GetPhName("anadip");
              m_cSql = "";
              m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_coddipe,"C",6,0,m_cServer),m_cServer,w_coddipe);
              if (m_Ctx.IsSharedTemp("anadip")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                w_cabcod = Read_Cursor.GetString("CAB");
                w_citdesc = Read_Cursor.GetString("DESCCIT");
                w_provind = Read_Cursor.GetString("PROVINCIA");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on anadip into routine arrt_chkdiana_old returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                w_cabcod = "";
                w_citdesc = "";
                w_provind = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(w_cabcod) */
              if (CPLib.Empty(w_cabcod)) {
                /* _note := _note + Left(LRTrim(w_codcab)+Space(6),6) + Left(LRTrim(w_desccit)+Space(30),30) + Left(LRTrim(w_provin)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(w_codcab)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(w_desccit)+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(w_provin)+CPLib.Space(2),2);
              } else { // Else
                /* _note := _note + Left(LRTrim(w_cabcod)+Space(6),6) + Left(LRTrim(w_citdesc)+Space(30),30) + Left(LRTrim(w_provind)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(w_cabcod)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(w_citdesc)+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(w_provind)+CPLib.Space(2),2);
              } // End If
            } // End If
          } else { // Else
            // * --- Select from anadip
            m_cServer = m_Ctx.GetServer("anadip");
            m_cPhName = m_Ctx.GetPhName("anadip");
            if (Cursor_anadip!=null)
              Cursor_anadip.Close();
            Cursor_anadip = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODDIP="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana.GetString("CODDIPE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("anadip")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_anadip.Eof())) {
              /* _note := _note + qbe_frad_chkdiana->CODDIPE + Left(LRTrim(anadip->CAB)+Space(6),6) + Left(LRTrim(anadip->DESCCIT)+Space(30),30) + Left(LRTrim(anadip->PROVINCIA)+Space(2),2) */
              _note = _note+Cursor_qbe_frad_chkdiana.GetString("CODDIPE")+CPLib.Left(CPLib.LRTrim(Cursor_anadip.GetString("CAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_anadip.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_anadip.GetString("PROVINCIA"))+CPLib.Space(2),2);
              Cursor_anadip.Next();
            }
            m_cConnectivityError = Cursor_anadip.ErrorMessage();
            Cursor_anadip.Close();
            // * --- End Select
          } // End If
          /* _note := _note + Left(DateToChar(qbe_frad_chkdiana->DATAOPE)+Space(8),8) + Left(LRTrim(qbe_frad_chkdiana->FLAGFRAZ)+" ",1) + Left(LRTrim(qbe_frad_chkdiana->FLAGCONT)+" ",1) */
          _note = _note+CPLib.Left(CPLib.DateToChar(Cursor_qbe_frad_chkdiana.GetDate("DATAOPE"))+CPLib.Space(8),8)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("FLAGFRAZ"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("FLAGCONT"))+" ",1);
          /* _note := _note + Left(LRTrim(qbe_frad_chkdiana->CODANA)+Space(4),4) + Left(LRTrim(qbe_frad_chkdiana->CODVOC)+Space(2),2) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("CODANA"))+CPLib.Space(4),4)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("CODVOC"))+CPLib.Space(2),2);
          /* _note := _note + Left(LRTrim(qbe_frad_chkdiana->TIPOINT2)+Space(2),2) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("TIPOINT2"))+CPLib.Space(2),2);
          /* _note := _note + iif(Empty(LRTrim(qbe_frad_chkdiana->CODFISCICP)),Left(LRTrim(qbe_frad_chkdiana->CODINT2)+Space(11),11),Left(LRTrim(qbe_frad_chkdiana->CODFISCICP)+Space(11),11)) */
          _note = _note+(CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("CODFISCICP")))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("CODINT2"))+CPLib.Space(11),11):CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("CODFISCICP"))+CPLib.Space(11),11));
          /* _note := _note + Left(LRTrim(qbe_frad_chkdiana->PAESE)+Space(3),3) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("PAESE"))+CPLib.Space(3),3);
          /* _note := _note + Left(LRTrim(qbe_frad_chkdiana->CODCAB2)+Space(6),6) + Left(LRTrim(arfn_agechar(qbe_frad_chkdiana->DESC2,' '))+Space(30),30) + Left(LRTrim(qbe_frad_chkdiana->PROV2)+Space(2),2) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("CODCAB2"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana.GetString("DESC2")," "))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("PROV2"))+CPLib.Space(2),2);
          /* _note := _note + Left(LRTrim(arfn_agechar(qbe_frad_chkdiana->DESCINTER,' '))+Space(50),50) + Left(LRTrim(arfn_agechar(qbe_frad_chkdiana->RAPPORTO,' '))+Space(25),25) + Left(LRTrim(_flagrap)+" ",1) */
          _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana.GetString("DESCINTER")," "))+CPLib.Space(50),50)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana.GetString("RAPPORTO")," "))+CPLib.Space(25),25)+CPLib.Left(CPLib.LRTrim(_flagrap)+" ",1);
          /* _note := _note + Left(LRTrim(qbe_frad_chkdiana->TIPOLEG)+" ",1) + Left(LRTrim(DateToChar(qbe_frad_chkdiana->DATAREG))+Space(8),8) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("TIPOLEG"))+" ",1)+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_frad_chkdiana.GetDate("DATAREG")))+CPLib.Space(8),8);
          /* _note := _note + Left(LRTrim(qbe_frad_chkdiana->TIPOOPRAP)+Space(2),2) + Left(LRTrim(qbe_frad_chkdiana->COLLEG)+Space(11),11) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("TIPOOPRAP"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("COLLEG"))+CPLib.Space(11),11);
          /* _note := _note + " " + Left(LRTrim(qbe_frad_chkdiana->STATOREG)+" ",1)  */
          _note = _note+" "+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("STATOREG"))+" ",1);
          /* If Empty(qbe_frad_chkdiana->DATARETT) or DateToChar(qbe_frad_chkdiana->DATARETT)='01000101' */
          if (CPLib.Empty(Cursor_qbe_frad_chkdiana.GetDate("DATARETT")) || CPLib.eqr(CPLib.DateToChar(Cursor_qbe_frad_chkdiana.GetDate("DATARETT")),"01000101")) {
            /* _note := _note + Space(8) */
            _note = _note+CPLib.Space(8);
          } else { // Else
            /* _note := _note + Left(LRTrim(DateToChar(qbe_frad_chkdiana->DATARETT))+Space(8),8) */
            _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_frad_chkdiana.GetDate("DATARETT")))+CPLib.Space(8),8);
          } // End If
          /* _note := _note + iif(Empty(LRTrim(qbe_frad_chkdiana->OPERAZMOD)),Space(20),Left(qbe_frad_chkdiana->OPERAZMOD,8)+"F"+Right(qbe_frad_chkdiana->OPERAZMOD,11)) */
          _note = _note+(CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("OPERAZMOD")))?CPLib.Space(20):CPLib.Left(Cursor_qbe_frad_chkdiana.GetString("OPERAZMOD"),8)+"F"+CPLib.Right(Cursor_qbe_frad_chkdiana.GetString("OPERAZMOD"),11));
          /* _note := _note + Left(LRTrim(qbe_frad_chkdiana->FLAGLIRE)+" ",1) + Left(LRTrim(qbe_frad_chkdiana->VALUTA)+Space(3),3) + Left(LRTrim(qbe_frad_chkdiana->SEGNO)+" ",1) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("FLAGLIRE"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("VALUTA"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("SEGNO"))+" ",1);
          /* _note := _note +  Right('000000000000000'+LRTrim(Str(qbe_frad_chkdiana->TOTLIRE,15,0)),15) + Right('000000000000000'+LRTrim(Str(qbe_frad_chkdiana->TOTCONT,15,0)),15) + Space(69) */
          _note = _note+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_frad_chkdiana.GetDouble("TOTLIRE"),15,0)),15)+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_frad_chkdiana.GetDouble("TOTCONT"),15,0)),15)+CPLib.Space(69);
          /* If w_flgchk='S' */
          if (CPLib.eqr(w_flgchk,"S")) {
            /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
            Page_15();
          } else { // Else
            /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
            FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
          } // End If
          /* nTotRec := nTotRec + 1 */
          nTotRec = CPLib.Round(nTotRec+1,0);
          /* nTotReg := nTotReg + 1 */
          nTotReg = CPLib.Round(nTotReg+1,0);
          /* nNumRec := nNumRec + 1 */
          nNumRec = CPLib.Round(nNumRec+1,0);
          /* If not(Empty(qbe_frad_chkdiana->CONNESCLI)) and Empty(LRTrim(qbe_frad_chkdiana->RAPPORTO)) */
          if ( ! (CPLib.Empty(Cursor_qbe_frad_chkdiana.GetString("CONNESCLI"))) && CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("RAPPORTO")))) {
            /* _oldrap := '' */
            _oldrap = "";
            /* _codrif := qbe_frad_chkdiana->CONNESCLI */
            _codrif = Cursor_qbe_frad_chkdiana.GetString("CONNESCLI");
            /* If gFlgWU='S' */
            if (CPLib.eqr(gFlgWU,"S")) {
              // * --- Select from kersonbo
              m_cServer = m_Ctx.GetServer("kersonbo");
              m_cPhName = m_Ctx.GetPhName("kersonbo");
              if (Cursor_kersonbo!=null)
                Cursor_kersonbo.Close();
              Cursor_kersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana.GetString("CONNESDOC"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("kersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_kersonbo.Eof())) {
                /* _ramate := iif(w_flgrae='R',LRTrim(kersonbo->RAMOGRUP),Left(LRTrim(kersonbo->ATTIV),3)) */
                _ramate = (CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_kersonbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("ATTIV")),3));
                /* _note := w_tipinter + w_codinter */
                _note = w_tipinter+w_codinter;
                /* If Empty(qbe_frad_chkdiana->CONNESOPER) or (qbe_frad_chkdiana->CONNESOPER=qbe_frad_chkdiana->CONNESCLI) */
                if (CPLib.Empty(Cursor_qbe_frad_chkdiana.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_frad_chkdiana.GetString("CONNESOPER"),Cursor_qbe_frad_chkdiana.GetString("CONNESCLI")))) {
                  /* _note := _note + '2' */
                  _note = _note+"2";
                } else { // Else
                  /* _note := _note + '3' */
                  _note = _note+"3";
                } // End If
                /* _note := _note + _idereg */
                _note = _note+_idereg;
                /* _note := _note + Left(LRTrim(qbe_frad_chkdiana->CONNESCLI)+Space(16),16) + Left(LRTrim(kersonbo->RAGSOC)+Space(70),70) + Left(LRTrim(kersonbo->PAESE)+Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("CONNESCLI"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("PAESE"))+CPLib.Space(3),3);
                /* _note := _note + Left(LRTrim(kersonbo->CODCAB)+Space(6),6) + Left(LRTrim(kersonbo->DESCCIT)+Space(30),30) + Left(LRTrim(kersonbo->PROVINCIA)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                /* _note := _note + Left(LRTrim(kersonbo->DOMICILIO)+Space(35),35) + Left(LRTrim(kersonbo->CAP)+ Space(5),5) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("CAP"))+CPLib.Space(5),5);
                /* _note := _note + Left(LRTrim(kersonbo->CODFISC)+Space(16),16)  */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("CODFISC"))+CPLib.Space(16),16);
                /* If Empty(kersonbo->DATANASC) or DateToChar(kersonbo->DATANASC)='01000101' */
                if (CPLib.Empty(Cursor_kersonbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_kersonbo.GetDate("DATANASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(kersonbo->DATANASC))+Space(8),8) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_kersonbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                } // End If
                /* If not(Empty(kersonbo->NASSTATO)) */
                if ( ! (CPLib.Empty(Cursor_kersonbo.GetString("NASSTATO")))) {
                  /* _note := _note + Left(LRTrim(kersonbo->NASSTATO)+Space(30),30) + Left(LRTrim(kersonbo->SOTGRUP)+Space(3),3) + Left(LRTrim(_ramate)+Space(3),3) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(_ramate)+CPLib.Space(3),3);
                } else { // Else
                  /* _note := _note + Left(LRTrim(kersonbo->NASCOMUN)+Space(30),30) + Left(LRTrim(kersonbo->SOTGRUP)+Space(3),3) + Left(LRTrim(_ramate) +Space(3),3) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(_ramate)+CPLib.Space(3),3);
                } // End If
                /* _note := _note + Left(LRTrim(kersonbo->SETTSINT)+Space(3),3) + Left(LRTrim(arfn_agechar(qbe_frad_chkdiana->RAPPORTO,' '))+Space(25),25) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana.GetString("RAPPORTO")," "))+CPLib.Space(25),25);
                /* _note := _note + Left(LRTrim(qbe_frad_chkdiana->FLAGRAP)+" ",1) + Left(LRTrim(kersonbo->TIPODOC)+Space(2),2) + Left(LRTrim(kersonbo->NUMDOCUM)+Space(15),15) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                /* If Empty(kersonbo->DATARILASC) or DateToChar(kersonbo->DATARILASC)='01000101' */
                if (CPLib.Empty(Cursor_kersonbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_kersonbo.GetDate("DATARILASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(kersonbo->DATARILASC))+Space(8),8)  */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_kersonbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                } // End If
                /* _note := _note + Left(LRTrim(kersonbo->AUTRILASC)+Space(30),30) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("AUTRILASC"))+CPLib.Space(30),30);
                /* _note := _note + Left(LRTrim(kersonbo->SESSO)+" ",1) + Space(34) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SESSO"))+" ",1)+CPLib.Space(34);
                /* If w_flgchk='S' */
                if (CPLib.eqr(w_flgchk,"S")) {
                  /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                  Page_15();
                } else { // Else
                  /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                  FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                } // End If
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_kersonbo.Next();
              }
              m_cConnectivityError = Cursor_kersonbo.ErrorMessage();
              Cursor_kersonbo.Close();
              // * --- End Select
            } else { // Else
              /* _note := w_tipinter + w_codinter */
              _note = w_tipinter+w_codinter;
              /* If Empty(qbe_frad_chkdiana->CONNESOPER) or (qbe_frad_chkdiana->CONNESOPER=qbe_frad_chkdiana->CONNESCLI) */
              if (CPLib.Empty(Cursor_qbe_frad_chkdiana.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_frad_chkdiana.GetString("CONNESOPER"),Cursor_qbe_frad_chkdiana.GetString("CONNESCLI")))) {
                /* _note := _note + '2' */
                _note = _note+"2";
              } else { // Else
                /* _note := _note + '3' */
                _note = _note+"3";
              } // End If
              /* _note := _note + _idereg */
              _note = _note+_idereg;
              /* _note := _note + LRTrim(arfn_datisog_sol(qbe_frad_chkdiana->CONNESCLI,qbe_frad_chkdiana->DATAREG,qbe_frad_chkdiana->RAPPORTO,qbe_frad_chkdiana->FLAGRAP,'2',w_flgrae,qbe_frad_chkdiana->STATOREG,qbe_frad_chkdiana->DATARETT)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana.GetString("CONNESCLI"),Cursor_qbe_frad_chkdiana.GetDate("DATAREG"),Cursor_qbe_frad_chkdiana.GetString("RAPPORTO"),Cursor_qbe_frad_chkdiana.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_frad_chkdiana.GetString("STATOREG"),Cursor_qbe_frad_chkdiana.GetDate("DATARETT")));
              /* If w_flgchk='S' */
              if (CPLib.eqr(w_flgchk,"S")) {
                /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                Page_15();
              } else { // Else
                /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
              } // End If
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
            } // End If
          } else { // Else
            /* _oldrap := '' */
            _oldrap = "";
            // * --- Read from knarapbo
            m_cServer = m_Ctx.GetServer("knarapbo");
            m_cPhName = m_Ctx.GetPhName("knarapbo");
            m_cSql = "";
            m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_frad_chkdiana.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_qbe_frad_chkdiana.GetString("RAPPORTO"));
            if (m_Ctx.IsSharedTemp("knarapbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _oldrap = Read_Cursor.GetString("RAPPORTO");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on knarapbo into routine arrt_chkdiana_old returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _oldrap = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If not(Empty(_oldrap)) */
            if ( ! (CPLib.Empty(_oldrap))) {
              // * --- Select from intestbo
              m_cServer = m_Ctx.GetServer("intestbo");
              m_cPhName = m_Ctx.GetPhName("intestbo");
              if (Cursor_intestbo!=null)
                Cursor_intestbo.Close();
              Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_intestbo.Eof())) {
                /* If qbe_frad_chkdiana->RAPPORTO = intestbo->RAPPORTO */
                if (CPLib.eqr(Cursor_qbe_frad_chkdiana.GetString("RAPPORTO"),Cursor_intestbo.GetString("RAPPORTO"))) {
                  /* _avanza := 0 */
                  _avanza = CPLib.Round(0,0);
                  /* If Empty(intestbo->CODINTER) or intestbo->STATOREG='2' or intestbo->STATOREG='3' */
                  if (CPLib.Empty(Cursor_intestbo.GetString("CODINTER")) || CPLib.eqr(Cursor_intestbo.GetString("STATOREG"),"2") || CPLib.eqr(Cursor_intestbo.GetString("STATOREG"),"3")) {
                    /* _avanza := 1 */
                    _avanza = CPLib.Round(1,0);
                  } // End If
                  /* If intestbo->DATAINI > qbe_frad_chkdiana->DATAOPE */
                  if (CPLib.gt(Cursor_intestbo.GetDate("DATAINI"),Cursor_qbe_frad_chkdiana.GetDate("DATAOPE"))) {
                    /* _avanza := 1 */
                    _avanza = CPLib.Round(1,0);
                  } // End If
                  /* If not(Empty(intestbo->DATAFINE)) and intestbo->DATAFINE < qbe_frad_chkdiana->DATAOPE */
                  if ( ! (CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE"))) && CPLib.lt(Cursor_intestbo.GetDate("DATAFINE"),Cursor_qbe_frad_chkdiana.GetDate("DATAOPE"))) {
                    /* _avanza := 1 */
                    _avanza = CPLib.Round(1,0);
                  } // End If
                  /* If _avanza = 0 */
                  if (CPLib.eqr(_avanza,0)) {
                    /* _codrif := intestbo->CODINTER */
                    _codrif = Cursor_intestbo.GetString("CODINTER");
                    /* _note := w_tipinter + w_codinter */
                    _note = w_tipinter+w_codinter;
                    /* If Empty(qbe_frad_chkdiana->CONNESOPER) or (qbe_frad_chkdiana->CONNESOPER=qbe_frad_chkdiana->CONNESCLI) */
                    if (CPLib.Empty(Cursor_qbe_frad_chkdiana.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_frad_chkdiana.GetString("CONNESOPER"),Cursor_qbe_frad_chkdiana.GetString("CONNESCLI")))) {
                      /* _note := _note + '2' */
                      _note = _note+"2";
                    } else { // Else
                      /* _note := _note + '3' */
                      _note = _note+"3";
                    } // End If
                    /* _note := _note + _idereg */
                    _note = _note+_idereg;
                    /* _note := _note + LRTrim(arfn_datisog_sol(intestbo->CODINTER,qbe_frad_chkdiana->DATAREG,qbe_frad_chkdiana->RAPPORTO,qbe_frad_chkdiana->FLAGRAP,'2',w_flgrae,qbe_frad_chkdiana->STATOREG,qbe_frad_chkdiana->DATARETT)) */
                    _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_intestbo.GetString("CODINTER"),Cursor_qbe_frad_chkdiana.GetDate("DATAREG"),Cursor_qbe_frad_chkdiana.GetString("RAPPORTO"),Cursor_qbe_frad_chkdiana.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_frad_chkdiana.GetString("STATOREG"),Cursor_qbe_frad_chkdiana.GetDate("DATARETT")));
                    /* If w_flgchk='S' */
                    if (CPLib.eqr(w_flgchk,"S")) {
                      /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                      Page_15();
                    } else { // Else
                      /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                      FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                    } // End If
                    /* nTotRec := nTotRec + 1 */
                    nTotRec = CPLib.Round(nTotRec+1,0);
                    /* nNumRec := nNumRec + 1 */
                    nNumRec = CPLib.Round(nNumRec+1,0);
                  } // End If
                } // End If
                Cursor_intestbo.Next();
              }
              m_cConnectivityError = Cursor_intestbo.ErrorMessage();
              Cursor_intestbo.Close();
              // * --- End Select
            } else { // Else
              /* If not(Empty(LRTrim(qbe_frad_chkdiana->CONNESCLI))) */
              if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("CONNESCLI"))))) {
                /* _note := w_tipinter + w_codinter */
                _note = w_tipinter+w_codinter;
                /* If Empty(qbe_frad_chkdiana->CONNESOPER) or (qbe_frad_chkdiana->CONNESOPER=qbe_frad_chkdiana->CONNESCLI) */
                if (CPLib.Empty(Cursor_qbe_frad_chkdiana.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_frad_chkdiana.GetString("CONNESOPER"),Cursor_qbe_frad_chkdiana.GetString("CONNESCLI")))) {
                  /* _note := _note + '2' */
                  _note = _note+"2";
                } else { // Else
                  /* _note := _note + '3' */
                  _note = _note+"3";
                } // End If
                /* _note := _note + _idereg */
                _note = _note+_idereg;
                /* _note := _note + LRTrim(arfn_datisog_sol(qbe_frad_chkdiana->CONNESCLI,qbe_frad_chkdiana->DATAREG,qbe_frad_chkdiana->RAPPORTO,qbe_frad_chkdiana->FLAGRAP,'2',w_flgrae,qbe_frad_chkdiana->STATOREG,qbe_frad_chkdiana->DATARETT)) */
                _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana.GetString("CONNESCLI"),Cursor_qbe_frad_chkdiana.GetDate("DATAREG"),Cursor_qbe_frad_chkdiana.GetString("RAPPORTO"),Cursor_qbe_frad_chkdiana.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_frad_chkdiana.GetString("STATOREG"),Cursor_qbe_frad_chkdiana.GetDate("DATARETT")));
                /* If w_flgchk='S' */
                if (CPLib.eqr(w_flgchk,"S")) {
                  /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                  Page_15();
                } else { // Else
                  /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                  FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                } // End If
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
              } // End If
            } // End If
          } // End If
          /* If not(Empty(LRTrim(_oldrap))) */
          if ( ! (CPLib.Empty(CPLib.LRTrim(_oldrap)))) {
            /* _oldrighe := 0 */
            _oldrighe = CPLib.Round(0,0);
            /* If qbe_frad_chkdiana->STATOREG='3' */
            if (CPLib.eqr(Cursor_qbe_frad_chkdiana.GetString("STATOREG"),"3")) {
              /* _oldrighe := 0 */
              _oldrighe = CPLib.Round(0,0);
              // * --- Select from mlientifrz
              m_cServer = m_Ctx.GetServer("mlientifrz");
              m_cPhName = m_Ctx.GetPhName("mlientifrz");
              if (Cursor_mlientifrz!=null)
                Cursor_mlientifrz.Close();
              Cursor_mlientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("mlientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_mlientifrz.Eof())) {
                /* _oldrighe := 1 */
                _oldrighe = CPLib.Round(1,0);
                /* _note := w_tipinter + w_codinter */
                _note = w_tipinter+w_codinter;
                /* If Empty(qbe_frad_chkdiana->CONNESOPER) or (qbe_frad_chkdiana->CONNESOPER=mlientifrz->CODSOG) */
                if (CPLib.Empty(Cursor_qbe_frad_chkdiana.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_frad_chkdiana.GetString("CONNESOPER"),Cursor_mlientifrz.GetString("CODSOG")))) {
                  /* _note := _note + '2' */
                  _note = _note+"2";
                } else { // Else
                  /* _note := _note + '3' */
                  _note = _note+"3";
                } // End If
                /* _note := _note + _idereg */
                _note = _note+_idereg;
                /* _note := _note + LRTrim(arfn_datisog_sol(mlientifrz->CODSOG,qbe_frad_chkdiana->DATAREG,qbe_frad_chkdiana->RAPPORTO,qbe_frad_chkdiana->FLAGRAP,'2',w_flgrae,qbe_frad_chkdiana->STATOREG,qbe_frad_chkdiana->DATARETT)) */
                _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_mlientifrz.GetString("CODSOG"),Cursor_qbe_frad_chkdiana.GetDate("DATAREG"),Cursor_qbe_frad_chkdiana.GetString("RAPPORTO"),Cursor_qbe_frad_chkdiana.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_frad_chkdiana.GetString("STATOREG"),Cursor_qbe_frad_chkdiana.GetDate("DATARETT")));
                /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_mlientifrz.Next();
              }
              m_cConnectivityError = Cursor_mlientifrz.ErrorMessage();
              Cursor_mlientifrz.Close();
              // * --- End Select
            } // End If
            /* If _oldrighe=0 */
            if (CPLib.eqr(_oldrighe,0)) {
              // * --- Select from clientifrz
              m_cServer = m_Ctx.GetServer("clientifrz");
              m_cPhName = m_Ctx.GetPhName("clientifrz");
              if (Cursor_clientifrz!=null)
                Cursor_clientifrz.Close();
              Cursor_clientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("clientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_clientifrz.Eof())) {
                /* _note := w_tipinter + w_codinter */
                _note = w_tipinter+w_codinter;
                /* If Empty(qbe_frad_chkdiana->CONNESOPER) or (qbe_frad_chkdiana->CONNESOPER=clientifrz->CODSOG) */
                if (CPLib.Empty(Cursor_qbe_frad_chkdiana.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_frad_chkdiana.GetString("CONNESOPER"),Cursor_clientifrz.GetString("CODSOG")))) {
                  /* _note := _note + '2' */
                  _note = _note+"2";
                } else { // Else
                  /* _note := _note + '3' */
                  _note = _note+"3";
                } // End If
                /* _note := _note + _idereg */
                _note = _note+_idereg;
                /* _note := _note + LRTrim(arfn_datisog_sol(clientifrz->CODSOG,qbe_frad_chkdiana->DATAREG,qbe_frad_chkdiana->RAPPORTO,qbe_frad_chkdiana->FLAGRAP,'2',w_flgrae,qbe_frad_chkdiana->STATOREG,qbe_frad_chkdiana->DATARETT)) */
                _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_clientifrz.GetString("CODSOG"),Cursor_qbe_frad_chkdiana.GetDate("DATAREG"),Cursor_qbe_frad_chkdiana.GetString("RAPPORTO"),Cursor_qbe_frad_chkdiana.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_frad_chkdiana.GetString("STATOREG"),Cursor_qbe_frad_chkdiana.GetDate("DATARETT")));
                /* If w_flgchk='S' */
                if (CPLib.eqr(w_flgchk,"S")) {
                  /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                  Page_15();
                } else { // Else
                  /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                  FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                } // End If
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_clientifrz.Next();
              }
              m_cConnectivityError = Cursor_clientifrz.ErrorMessage();
              Cursor_clientifrz.Close();
              // * --- End Select
            } // End If
          } // End If
          /* If not(Empty(qbe_frad_chkdiana->CONNESOPER)) and qbe_frad_chkdiana->CONNESOPER <> _codrif */
          if ( ! (CPLib.Empty(Cursor_qbe_frad_chkdiana.GetString("CONNESOPER"))) && CPLib.ne(Cursor_qbe_frad_chkdiana.GetString("CONNESOPER"),_codrif)) {
            /* _note := w_tipinter + w_codinter+'4' + _idereg */
            _note = w_tipinter+w_codinter+"4"+_idereg;
            /* _note := _note + LRTrim(arfn_datisog_sol(qbe_frad_chkdiana->CONNESOPER,qbe_frad_chkdiana->DATAREG,qbe_frad_chkdiana->RAPPORTO,qbe_frad_chkdiana->FLAGRAP,'4',w_flgrae,qbe_frad_chkdiana->STATOREG,qbe_frad_chkdiana->DATARETT)) */
            _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana.GetString("CONNESOPER"),Cursor_qbe_frad_chkdiana.GetDate("DATAREG"),Cursor_qbe_frad_chkdiana.GetString("RAPPORTO"),Cursor_qbe_frad_chkdiana.GetString("FLAGRAP"),"4",w_flgrae,Cursor_qbe_frad_chkdiana.GetString("STATOREG"),Cursor_qbe_frad_chkdiana.GetDate("DATARETT")));
            /* If w_flgchk='S' */
            if (CPLib.eqr(w_flgchk,"S")) {
              /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
              Page_15();
            } else { // Else
              /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
              FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
            } // End If
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
          } // End If
          /* _oldrighe := 0 */
          _oldrighe = CPLib.Round(0,0);
          /* If qbe_frad_chkdiana->STATOREG='3' */
          if (CPLib.eqr(Cursor_qbe_frad_chkdiana.GetString("STATOREG"),"3")) {
            // * --- Select from mogopefbo
            m_cServer = m_Ctx.GetServer("mogopefbo");
            m_cPhName = m_Ctx.GetPhName("mogopefbo");
            if (Cursor_mogopefbo!=null)
              Cursor_mogopefbo.Close();
            Cursor_mogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("mogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_mogopefbo.Eof())) {
              /* _oldrighe := 1 */
              _oldrighe = CPLib.Round(1,0);
              /* _note := w_tipinter + w_codinter+'4' + _idereg */
              _note = w_tipinter+w_codinter+"4"+_idereg;
              /* _note := _note + LRTrim(arfn_datisog_sol(mogopefbo->CODSOG,qbe_frad_chkdiana->DATAREG,qbe_frad_chkdiana->RAPPORTO,qbe_frad_chkdiana->FLAGRAP,'4',w_flgrae,qbe_frad_chkdiana->STATOREG,qbe_frad_chkdiana->DATARETT)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_mogopefbo.GetString("CODSOG"),Cursor_qbe_frad_chkdiana.GetDate("DATAREG"),Cursor_qbe_frad_chkdiana.GetString("RAPPORTO"),Cursor_qbe_frad_chkdiana.GetString("FLAGRAP"),"4",w_flgrae,Cursor_qbe_frad_chkdiana.GetString("STATOREG"),Cursor_qbe_frad_chkdiana.GetDate("DATARETT")));
              /* If w_flgchk='S' */
              if (CPLib.eqr(w_flgchk,"S")) {
                /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                Page_15();
              } else { // Else
                /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
              } // End If
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
              Cursor_mogopefbo.Next();
            }
            m_cConnectivityError = Cursor_mogopefbo.ErrorMessage();
            Cursor_mogopefbo.Close();
            // * --- End Select
          } // End If
          /* If _oldrighe=0 */
          if (CPLib.eqr(_oldrighe,0)) {
            // * --- Select from sogopefbo
            m_cServer = m_Ctx.GetServer("sogopefbo");
            m_cPhName = m_Ctx.GetPhName("sogopefbo");
            if (Cursor_sogopefbo!=null)
              Cursor_sogopefbo.Close();
            Cursor_sogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("sogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_sogopefbo.Eof())) {
              /* _note := w_tipinter + w_codinter+'4' + _idereg */
              _note = w_tipinter+w_codinter+"4"+_idereg;
              /* _note := _note + LRTrim(arfn_datisog_sol(sogopefbo->CODSOG,qbe_frad_chkdiana->DATAREG,qbe_frad_chkdiana->RAPPORTO,qbe_frad_chkdiana->FLAGRAP,'4',w_flgrae,qbe_frad_chkdiana->STATOREG,qbe_frad_chkdiana->DATARETT)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_sogopefbo.GetString("CODSOG"),Cursor_qbe_frad_chkdiana.GetDate("DATAREG"),Cursor_qbe_frad_chkdiana.GetString("RAPPORTO"),Cursor_qbe_frad_chkdiana.GetString("FLAGRAP"),"4",w_flgrae,Cursor_qbe_frad_chkdiana.GetString("STATOREG"),Cursor_qbe_frad_chkdiana.GetDate("DATARETT")));
              /* If w_flgchk='S' */
              if (CPLib.eqr(w_flgchk,"S")) {
                /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                Page_15();
              } else { // Else
                /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
              } // End If
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
              Cursor_sogopefbo.Next();
            }
            m_cConnectivityError = Cursor_sogopefbo.ErrorMessage();
            Cursor_sogopefbo.Close();
            // * --- End Select
          } // End If
          /* If not(Empty(qbe_frad_chkdiana->CONNESBEN)) or not(Empty(qbe_frad_chkdiana->C_RAG)) */
          if ( ! (CPLib.Empty(Cursor_qbe_frad_chkdiana.GetString("CONNESBEN"))) ||  ! (CPLib.Empty(Cursor_qbe_frad_chkdiana.GetString("C_RAG")))) {
            /* If not(Empty(qbe_frad_chkdiana->C_RAG)) */
            if ( ! (CPLib.Empty(Cursor_qbe_frad_chkdiana.GetString("C_RAG")))) {
              /* _note := w_tipinter + w_codinter+'5' + _idereg */
              _note = w_tipinter+w_codinter+"5"+_idereg;
              /* _note := _note + Left(LRTrim(qbe_frad_chkdiana->CONNESBEN)+Space(16),16) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("CONNESBEN"))+CPLib.Space(16),16);
              /* _note := _note +Left(LRTrim(arfn_agechar(qbe_frad_chkdiana->C_RAG,' '))+Space(70),70) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana.GetString("C_RAG")," "))+CPLib.Space(70),70);
              /* _note := _note + Left(LRTrim(qbe_frad_chkdiana->C_STA)+Space(3),3) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_STA"))+CPLib.Space(3),3);
              /* _note := _note +Left(LRTrim(qbe_frad_chkdiana->C_CAB)+Space(6),6) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_CAB"))+CPLib.Space(6),6);
              /* _note := _note +Left(LRTrim(arfn_agechar(qbe_frad_chkdiana->C_CTA,' '))+Space(30),30) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana.GetString("C_CTA")," "))+CPLib.Space(30),30);
              /* _note := _note + Left(LRTrim(qbe_frad_chkdiana->C_PRV)+Space(2),2) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_PRV"))+CPLib.Space(2),2);
              /* _note := _note + Left(LRTrim(arfn_agechar(qbe_frad_chkdiana->C_IND,' '))+Space(35),35) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana.GetString("C_IND")," "))+CPLib.Space(35),35);
              /* _note := _note + Left(LRTrim(qbe_frad_chkdiana->C_CAP)+Space(5),5) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_CAP"))+CPLib.Space(5),5);
              /* _note := _note + Space(63) */
              _note = _note+CPLib.Space(63);
              /* _note := _note + Left(LRTrim(qbe_frad_chkdiana->C_RAPPORTO)+Space(25),25) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
              /* _note := _note + Space(91) */
              _note = _note+CPLib.Space(91);
              /* If w_flgchk='S' */
              if (CPLib.eqr(w_flgchk,"S")) {
                /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                Page_15();
              } else { // Else
                /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
              } // End If
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
              /* ElseIf not(Empty(qbe_frad_chkdiana->CONNESBEN)) */
            } else if ( ! (CPLib.Empty(Cursor_qbe_frad_chkdiana.GetString("CONNESBEN")))) {
              /* _numsto := arfn_chkspers(qbe_frad_chkdiana->CONNESBEN,qbe_frad_chkdiana->DATAREG) */
              _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana.GetString("CONNESBEN"),Cursor_qbe_frad_chkdiana.GetDate("DATAREG"));
              /* If Empty(LRTrim(_numsto)) */
              if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana.GetString("CONNESBEN"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* _note := w_tipinter + w_codinter+'5' + _idereg */
                  _note = w_tipinter+w_codinter+"5"+_idereg;
                  /* _note := _note + Left(LRTrim(qbe_frad_chkdiana->CONNESBEN)+Space(16),16) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("CONNESBEN"))+CPLib.Space(16),16);
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana->C_RAG))),Left(LRTrim(arfn_agechar(qbe_frad_chkdiana->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(personbo->RAGSOC,' '))+Space(70),70)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana->C_STA))),Left(LRTrim(qbe_frad_chkdiana->C_STA)+Space(3),3),Left(LRTrim(personbo->PAESE)+Space(3),3)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana->C_CAB))),Left(LRTrim(qbe_frad_chkdiana->C_CAB)+Space(6),6),Left(LRTrim(personbo->CODCAB)+Space(6),6)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana->C_CTA))),Left(LRTrim(arfn_agechar(qbe_frad_chkdiana->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(personbo->DESCCIT,' '))+Space(30),30)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana->C_PRV))),Left(LRTrim(qbe_frad_chkdiana->C_PRV)+Space(2),2),Left(LRTrim(personbo->PROVINCIA)+Space(2),2)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana->C_IND))),Left(LRTrim(arfn_agechar(qbe_frad_chkdiana->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(personbo->DOMICILIO,' '))+Space(35),35)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana->C_CAP))),Left(LRTrim(qbe_frad_chkdiana->C_CAP)+Space(5),5),Left(LRTrim(personbo->CAP)+Space(5),5)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5));
                  /* _note := _note + Space(63) */
                  _note = _note+CPLib.Space(63);
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana->C_RAPPORTO))),Left(LRTrim(qbe_frad_chkdiana->C_RAPPORTO)+Space(25),25),Left(LRTrim(qbe_frad_chkdiana->RAPPORTBEN)+Space(25),25)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_RAPPORTO"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_RAPPORTO"))+CPLib.Space(25),25):CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("RAPPORTBEN"))+CPLib.Space(25),25));
                  /* _note := _note + Space(91) */
                  _note = _note+CPLib.Space(91);
                  /* If w_flgchk='S' */
                  if (CPLib.eqr(w_flgchk,"S")) {
                    /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                    Page_15();
                  } else { // Else
                    /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                    FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                  } // End If
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } else { // Else
                // * --- Select from wersonbo
                m_cServer = m_Ctx.GetServer("wersonbo");
                m_cPhName = m_Ctx.GetPhName("wersonbo");
                if (Cursor_wersonbo!=null)
                  Cursor_wersonbo.Close();
                Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_wersonbo.Eof())) {
                  /* _note := w_tipinter + w_codinter+'5' */
                  _note = w_tipinter+w_codinter+"5";
                  /* If Empty(LRTrim(qbe_frad_chkdiana->FLAGRAP2)) */
                  if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("FLAGRAP2")))) {
                    /* _note := _note + DateToChar(qbe_frad_chkdiana->DATAOPE) + qbe_frad_chkdiana->NUMPROG + 'S' */
                    _note = _note+CPLib.DateToChar(Cursor_qbe_frad_chkdiana.GetDate("DATAOPE"))+Cursor_qbe_frad_chkdiana.GetString("NUMPROG")+"S";
                  } else { // Else
                    /* _note := _note + qbe_frad_chkdiana->IDEREG */
                    _note = _note+Cursor_qbe_frad_chkdiana.GetString("IDEREG");
                  } // End If
                  /* _note := _note + Left(LRTrim(qbe_frad_chkdiana->CONNESBEN)+Space(16),16) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("CONNESBEN"))+CPLib.Space(16),16);
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana->C_RAG))),Left(LRTrim(arfn_agechar(qbe_frad_chkdiana->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(wersonbo->RAGSOC,' '))+Space(70),70)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana->C_STA))),Left(LRTrim(qbe_frad_chkdiana->C_STA)+Space(3),3),Left(LRTrim(wersonbo->PAESE)+Space(3),3)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PAESE"))+CPLib.Space(3),3));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana->C_CAB))),Left(LRTrim(qbe_frad_chkdiana->C_CAB)+Space(6),6),Left(LRTrim(wersonbo->CODCAB)+Space(6),6)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CODCAB"))+CPLib.Space(6),6));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana->C_CTA))),Left(LRTrim(arfn_agechar(qbe_frad_chkdiana->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(wersonbo->DESCCIT,' '))+Space(30),30)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana->C_PRV))),Left(LRTrim(qbe_frad_chkdiana->C_PRV)+Space(2),2),Left(LRTrim(wersonbo->PROVINCIA)+Space(2),2)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana->C_IND))),Left(LRTrim(arfn_agechar(qbe_frad_chkdiana->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(wersonbo->DOMICILIO,' '))+Space(35),35)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana->C_CAP))),Left(LRTrim(qbe_frad_chkdiana->C_CAP)+Space(5),5),Left(LRTrim(wersonbo->CAP)+Space(5),5)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CAP"))+CPLib.Space(5),5));
                  /* _note := _note + Space(63) */
                  _note = _note+CPLib.Space(63);
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana->C_RAPPORTO))),Left(LRTrim(qbe_frad_chkdiana->C_RAPPORTO)+Space(25),25),Left(LRTrim(qbe_frad_chkdiana->RAPPORTBEN)+Space(25),25)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_RAPPORTO"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_RAPPORTO"))+CPLib.Space(25),25):CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("RAPPORTBEN"))+CPLib.Space(25),25));
                  /* _note := _note + Space(91) */
                  _note = _note+CPLib.Space(91);
                  /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                  FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_wersonbo.Next();
                }
                m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                Cursor_wersonbo.Close();
                // * --- End Select
              } // End If
            } // End If
          } // End If
          /* _oldrighe := 0 */
          _oldrighe = CPLib.Round(0,0);
          /* If qbe_frad_chkdiana->STATOREG='3' */
          if (CPLib.eqr(Cursor_qbe_frad_chkdiana.GetString("STATOREG"),"3")) {
            // * --- Select from meneficfrz
            m_cServer = m_Ctx.GetServer("meneficfrz");
            m_cPhName = m_Ctx.GetPhName("meneficfrz");
            if (Cursor_meneficfrz!=null)
              Cursor_meneficfrz.Close();
            Cursor_meneficfrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("meneficfrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_meneficfrz.Eof())) {
              /* _oldrighe := 1 */
              _oldrighe = CPLib.Round(1,0);
              /* If Empty(LRTrim(meneficfrz->CODSOG)) and not(Empty(LRTrim(meneficfrz->C_RAG))) */
              if (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("CODSOG"))) &&  ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_RAG"))))) {
                /* _note := w_tipinter + w_codinter+'5' + _idereg */
                _note = w_tipinter+w_codinter+"5"+_idereg;
                /* _note := _note + Left(LRTrim(meneficfrz->CODSOG)+Space(16),16) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("CODSOG"))+CPLib.Space(16),16);
                /* _note := _note +Left(LRTrim(arfn_agechar(meneficfrz->C_RAG,' '))+Space(70),70) */
                _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficfrz.GetString("C_RAG")," "))+CPLib.Space(70),70);
                /* _note := _note + Left(LRTrim(meneficfrz->C_STA)+Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_STA"))+CPLib.Space(3),3);
                /* _note := _note +Left(LRTrim(meneficfrz->C_CAB)+Space(6),6) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_CAB"))+CPLib.Space(6),6);
                /* _note := _note +Left(LRTrim(arfn_agechar(meneficfrz->C_CTA,' '))+Space(30),30) */
                _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficfrz.GetString("C_CTA")," "))+CPLib.Space(30),30);
                /* _note := _note + Left(LRTrim(meneficfrz->C_PRV)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_PRV"))+CPLib.Space(2),2);
                /* _note := _note + Left(LRTrim(arfn_agechar(meneficfrz->C_IND,' '))+Space(35),35) */
                _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficfrz.GetString("C_IND")," "))+CPLib.Space(35),35);
                /* _note := _note + Left(LRTrim(meneficfrz->C_CAP)+Space(5),5) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_CAP"))+CPLib.Space(5),5);
                /* _note := _note + Space(63) */
                _note = _note+CPLib.Space(63);
                /* _note := _note + Left(LRTrim(meneficfrz->C_RAPPORTO)+Space(25),25) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                /* _note := _note + Space(91) */
                _note = _note+CPLib.Space(91);
                /* If w_flgchk='S' */
                if (CPLib.eqr(w_flgchk,"S")) {
                  /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                  Page_15();
                } else { // Else
                  /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                  FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                } // End If
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
              } else { // Else
                /* _numsto := arfn_chkspers(meneficfrz->CODSOG,qbe_frad_chkdiana->DATAREG) */
                _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_meneficfrz.GetString("CODSOG"),Cursor_qbe_frad_chkdiana.GetDate("DATAREG"));
                /* If Empty(LRTrim(_numsto)) */
                if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
                  // * --- Select from personbo
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  if (Cursor_personbo!=null)
                    Cursor_personbo.Close();
                  Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_meneficfrz.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_personbo.Eof())) {
                    /* _note := w_tipinter + w_codinter+'5' + _idereg */
                    _note = w_tipinter+w_codinter+"5"+_idereg;
                    /* _note := _note + Left(LRTrim(meneficfrz->CODSOG)+Space(16),16) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("CODSOG"))+CPLib.Space(16),16);
                    /* _note := _note + iif(not(Empty(LRTrim(meneficfrz->C_RAG))),Left(LRTrim(arfn_agechar(meneficfrz->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(personbo->RAGSOC,' '))+Space(70),70)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficfrz.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficfrz->C_STA))),Left(LRTrim(meneficfrz->C_STA)+Space(3),3),Left(LRTrim(personbo->PAESE)+Space(3),3)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficfrz->C_CAB))),Left(LRTrim(meneficfrz->C_CAB)+Space(6),6),Left(LRTrim(personbo->CODCAB)+Space(6),6)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficfrz->C_CTA))),Left(LRTrim(arfn_agechar(meneficfrz->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(personbo->DESCCIT,' '))+Space(30),30)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficfrz.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficfrz->C_PRV))),Left(LRTrim(meneficfrz->C_PRV)+Space(2),2),Left(LRTrim(personbo->PROVINCIA)+Space(2),2)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficfrz->C_IND))),Left(LRTrim(arfn_agechar(meneficfrz->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(personbo->DOMICILIO,' '))+Space(35),35)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficfrz.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficfrz->C_CAP))),Left(LRTrim(meneficfrz->C_CAP)+Space(5),5),Left(LRTrim(personbo->CAP)+Space(5),5)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5));
                    /* _note := _note + Space(63) */
                    _note = _note+CPLib.Space(63);
                    /* _note := _note +Left(LRTrim(meneficfrz->C_RAPPORTO)+Space(25),25) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                    /* _note := _note + Space(91) */
                    _note = _note+CPLib.Space(91);
                    /* If w_flgchk='S' */
                    if (CPLib.eqr(w_flgchk,"S")) {
                      /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                      Page_15();
                    } else { // Else
                      /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                      FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                    } // End If
                    /* nTotRec := nTotRec + 1 */
                    nTotRec = CPLib.Round(nTotRec+1,0);
                    /* nNumRec := nNumRec + 1 */
                    nNumRec = CPLib.Round(nNumRec+1,0);
                    Cursor_personbo.Next();
                  }
                  m_cConnectivityError = Cursor_personbo.ErrorMessage();
                  Cursor_personbo.Close();
                  // * --- End Select
                } else { // Else
                  // * --- Select from wersonbo
                  m_cServer = m_Ctx.GetServer("wersonbo");
                  m_cPhName = m_Ctx.GetPhName("wersonbo");
                  if (Cursor_wersonbo!=null)
                    Cursor_wersonbo.Close();
                  Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_wersonbo.Eof())) {
                    /* _note := w_tipinter + w_codinter+'5' */
                    _note = w_tipinter+w_codinter+"5";
                    /* If Empty(LRTrim(qbe_frad_chkdiana->FLAGRAP2)) */
                    if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("FLAGRAP2")))) {
                      /* _note := _note + DateToChar(qbe_frad_chkdiana->DATAOPE) + qbe_frad_chkdiana->NUMPROG + 'S' */
                      _note = _note+CPLib.DateToChar(Cursor_qbe_frad_chkdiana.GetDate("DATAOPE"))+Cursor_qbe_frad_chkdiana.GetString("NUMPROG")+"S";
                    } else { // Else
                      /* _note := _note + qbe_frad_chkdiana->IDEREG */
                      _note = _note+Cursor_qbe_frad_chkdiana.GetString("IDEREG");
                    } // End If
                    /* _note := _note + Left(LRTrim(meneficfrz->CODSOG)+Space(16),16) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("CODSOG"))+CPLib.Space(16),16);
                    /* _note := _note + iif(not(Empty(LRTrim(meneficfrz->C_RAG))),Left(LRTrim(arfn_agechar(meneficfrz->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(wersonbo->RAGSOC,' '))+Space(70),70)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficfrz.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficfrz->C_STA))),Left(LRTrim(meneficfrz->C_STA)+Space(3),3),Left(LRTrim(wersonbo->PAESE)+Space(3),3)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PAESE"))+CPLib.Space(3),3));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficfrz->C_CAB))),Left(LRTrim(meneficfrz->C_CAB)+Space(6),6),Left(LRTrim(wersonbo->CODCAB)+Space(6),6)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CODCAB"))+CPLib.Space(6),6));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficfrz->C_CTA))),Left(LRTrim(arfn_agechar(meneficfrz->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(wersonbo->DESCCIT,' '))+Space(30),30)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficfrz.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficfrz->C_PRV))),Left(LRTrim(meneficfrz->C_PRV)+Space(2),2),Left(LRTrim(wersonbo->PROVINCIA)+Space(2),2)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficfrz->C_IND))),Left(LRTrim(arfn_agechar(meneficfrz->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(wersonbo->DOMICILIO,' '))+Space(35),35)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficfrz.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficfrz->C_CAP))),Left(LRTrim(meneficfrz->C_CAP)+Space(5),5),Left(LRTrim(wersonbo->CAP)+Space(5),5)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CAP"))+CPLib.Space(5),5));
                    /* _note := _note + Space(63) */
                    _note = _note+CPLib.Space(63);
                    /* _note := _note +Left(LRTrim(meneficfrz->C_RAPPORTO)+Space(25),25) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                    /* _note := _note + Space(91) */
                    _note = _note+CPLib.Space(91);
                    /* If w_flgchk='S' */
                    if (CPLib.eqr(w_flgchk,"S")) {
                      /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                      Page_15();
                    } else { // Else
                      /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                      FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                    } // End If
                    /* nTotRec := nTotRec + 1 */
                    nTotRec = CPLib.Round(nTotRec+1,0);
                    /* nNumRec := nNumRec + 1 */
                    nNumRec = CPLib.Round(nNumRec+1,0);
                    Cursor_wersonbo.Next();
                  }
                  m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                  Cursor_wersonbo.Close();
                  // * --- End Select
                } // End If
              } // End If
              Cursor_meneficfrz.Next();
            }
            m_cConnectivityError = Cursor_meneficfrz.ErrorMessage();
            Cursor_meneficfrz.Close();
            // * --- End Select
          } // End If
          /* If _oldrighe=0 */
          if (CPLib.eqr(_oldrighe,0)) {
            // * --- Select from beneficfrz
            m_cServer = m_Ctx.GetServer("beneficfrz");
            m_cPhName = m_Ctx.GetPhName("beneficfrz");
            if (Cursor_beneficfrz!=null)
              Cursor_beneficfrz.Close();
            Cursor_beneficfrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("beneficfrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_beneficfrz.Eof())) {
              /* If Empty(LRTrim(beneficfrz->CODSOG)) and not(Empty(LRTrim(beneficfrz->C_RAG))) */
              if (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("CODSOG"))) &&  ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_RAG"))))) {
                /* _note := w_tipinter + w_codinter+'5' + _idereg */
                _note = w_tipinter+w_codinter+"5"+_idereg;
                /* _note := _note + Left(LRTrim(beneficfrz->CODSOG)+Space(16),16) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("CODSOG"))+CPLib.Space(16),16);
                /* _note := _note +Left(LRTrim(arfn_agechar(beneficfrz->C_RAG,' '))+Space(70),70) */
                _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficfrz.GetString("C_RAG")," "))+CPLib.Space(70),70);
                /* _note := _note + Left(LRTrim(beneficfrz->C_STA)+Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_STA"))+CPLib.Space(3),3);
                /* _note := _note +Left(LRTrim(beneficfrz->C_CAB)+Space(6),6) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_CAB"))+CPLib.Space(6),6);
                /* _note := _note +Left(LRTrim(arfn_agechar(beneficfrz->C_CTA,' '))+Space(30),30) */
                _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficfrz.GetString("C_CTA")," "))+CPLib.Space(30),30);
                /* _note := _note + Left(LRTrim(beneficfrz->C_PRV)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_PRV"))+CPLib.Space(2),2);
                /* _note := _note + Left(LRTrim(arfn_agechar(beneficfrz->C_IND,' '))+Space(35),35) */
                _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficfrz.GetString("C_IND")," "))+CPLib.Space(35),35);
                /* _note := _note + Left(LRTrim(beneficfrz->C_CAP)+Space(5),5) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_CAP"))+CPLib.Space(5),5);
                /* _note := _note + Space(63) */
                _note = _note+CPLib.Space(63);
                /* _note := _note + Left(LRTrim(beneficfrz->C_RAPPORTO)+Space(25),25) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                /* _note := _note + Space(91) */
                _note = _note+CPLib.Space(91);
                /* If w_flgchk='S' */
                if (CPLib.eqr(w_flgchk,"S")) {
                  /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                  Page_15();
                } else { // Else
                  /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                  FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                } // End If
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
              } else { // Else
                /* _numsto := arfn_chkspers(beneficfrz->CODSOG,qbe_frad_chkdiana->DATAREG) */
                _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_beneficfrz.GetString("CODSOG"),Cursor_qbe_frad_chkdiana.GetDate("DATAREG"));
                /* If Empty(LRTrim(_numsto)) */
                if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
                  // * --- Select from personbo
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  if (Cursor_personbo!=null)
                    Cursor_personbo.Close();
                  Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_beneficfrz.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_personbo.Eof())) {
                    /* _note := w_tipinter + w_codinter+'5' + _idereg */
                    _note = w_tipinter+w_codinter+"5"+_idereg;
                    /* _note := _note + Left(LRTrim(beneficfrz->CODSOG)+Space(16),16) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("CODSOG"))+CPLib.Space(16),16);
                    /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_RAG))),Left(LRTrim(arfn_agechar(beneficfrz->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(personbo->RAGSOC,' '))+Space(70),70)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficfrz.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_STA))),Left(LRTrim(beneficfrz->C_STA)+Space(3),3),Left(LRTrim(personbo->PAESE)+Space(3),3)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_CAB))),Left(LRTrim(beneficfrz->C_CAB)+Space(6),6),Left(LRTrim(personbo->CODCAB)+Space(6),6)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_CTA))),Left(LRTrim(arfn_agechar(beneficfrz->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(personbo->DESCCIT,' '))+Space(30),30)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficfrz.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_PRV))),Left(LRTrim(beneficfrz->C_PRV)+Space(2),2),Left(LRTrim(personbo->PROVINCIA)+Space(2),2)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_IND))),Left(LRTrim(arfn_agechar(beneficfrz->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(personbo->DOMICILIO,' '))+Space(35),35)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficfrz.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_CAP))),Left(LRTrim(beneficfrz->C_CAP)+Space(5),5),Left(LRTrim(personbo->CAP)+Space(5),5)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5));
                    /* _note := _note + Space(63) */
                    _note = _note+CPLib.Space(63);
                    /* _note := _note +Left(LRTrim(beneficfrz->C_RAPPORTO)+Space(25),25) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                    /* _note := _note + Space(91) */
                    _note = _note+CPLib.Space(91);
                    /* If w_flgchk='S' */
                    if (CPLib.eqr(w_flgchk,"S")) {
                      /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                      Page_15();
                    } else { // Else
                      /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                      FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                    } // End If
                    /* nTotRec := nTotRec + 1 */
                    nTotRec = CPLib.Round(nTotRec+1,0);
                    /* nNumRec := nNumRec + 1 */
                    nNumRec = CPLib.Round(nNumRec+1,0);
                    Cursor_personbo.Next();
                  }
                  m_cConnectivityError = Cursor_personbo.ErrorMessage();
                  Cursor_personbo.Close();
                  // * --- End Select
                } else { // Else
                  // * --- Select from wersonbo
                  m_cServer = m_Ctx.GetServer("wersonbo");
                  m_cPhName = m_Ctx.GetPhName("wersonbo");
                  if (Cursor_wersonbo!=null)
                    Cursor_wersonbo.Close();
                  Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_wersonbo.Eof())) {
                    /* _note := w_tipinter + w_codinter+'5' */
                    _note = w_tipinter+w_codinter+"5";
                    /* If Empty(LRTrim(qbe_frad_chkdiana->FLAGRAP2)) */
                    if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("FLAGRAP2")))) {
                      /* _note := _note + DateToChar(qbe_frad_chkdiana->DATAOPE) + qbe_frad_chkdiana->NUMPROG + 'S' */
                      _note = _note+CPLib.DateToChar(Cursor_qbe_frad_chkdiana.GetDate("DATAOPE"))+Cursor_qbe_frad_chkdiana.GetString("NUMPROG")+"S";
                    } else { // Else
                      /* _note := _note + qbe_frad_chkdiana->IDEREG */
                      _note = _note+Cursor_qbe_frad_chkdiana.GetString("IDEREG");
                    } // End If
                    /* _note := _note + Left(LRTrim(beneficfrz->CODSOG)+Space(16),16) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("CODSOG"))+CPLib.Space(16),16);
                    /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_RAG))),Left(LRTrim(arfn_agechar(beneficfrz->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(wersonbo->RAGSOC,' '))+Space(70),70)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficfrz.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_STA))),Left(LRTrim(beneficfrz->C_STA)+Space(3),3),Left(LRTrim(wersonbo->PAESE)+Space(3),3)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PAESE"))+CPLib.Space(3),3));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_CAB))),Left(LRTrim(beneficfrz->C_CAB)+Space(6),6),Left(LRTrim(wersonbo->CODCAB)+Space(6),6)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CODCAB"))+CPLib.Space(6),6));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_CTA))),Left(LRTrim(arfn_agechar(beneficfrz->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(wersonbo->DESCCIT,' '))+Space(30),30)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficfrz.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_PRV))),Left(LRTrim(beneficfrz->C_PRV)+Space(2),2),Left(LRTrim(wersonbo->PROVINCIA)+Space(2),2)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_IND))),Left(LRTrim(arfn_agechar(beneficfrz->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(wersonbo->DOMICILIO,' '))+Space(35),35)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficfrz.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_CAP))),Left(LRTrim(beneficfrz->C_CAP)+Space(5),5),Left(LRTrim(wersonbo->CAP)+Space(5),5)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CAP"))+CPLib.Space(5),5));
                    /* _note := _note + Space(63) */
                    _note = _note+CPLib.Space(63);
                    /* _note := _note +Left(LRTrim(beneficfrz->C_RAPPORTO)+Space(25),25) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                    /* _note := _note + Space(91) */
                    _note = _note+CPLib.Space(91);
                    /* If w_flgchk='S' */
                    if (CPLib.eqr(w_flgchk,"S")) {
                      /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                      Page_15();
                    } else { // Else
                      /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                      FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                    } // End If
                    /* nTotRec := nTotRec + 1 */
                    nTotRec = CPLib.Round(nTotRec+1,0);
                    /* nNumRec := nNumRec + 1 */
                    nNumRec = CPLib.Round(nNumRec+1,0);
                    Cursor_wersonbo.Next();
                  }
                  m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                  Cursor_wersonbo.Close();
                  // * --- End Select
                } // End If
              } // End If
              Cursor_beneficfrz.Next();
            }
            m_cConnectivityError = Cursor_beneficfrz.ErrorMessage();
            Cursor_beneficfrz.Close();
            // * --- End Select
          } // End If
          /* If not(Empty(qbe_frad_chkdiana->CONNALTRO)) */
          if ( ! (CPLib.Empty(Cursor_qbe_frad_chkdiana.GetString("CONNALTRO")))) {
            /* _note := w_tipinter + w_codinter+'6' + _idereg */
            _note = w_tipinter+w_codinter+"6"+_idereg;
            /* _note := _note + LRTrim(arfn_datisog_sol(qbe_frad_chkdiana->CONNALTRO,qbe_frad_chkdiana->DATAREG,qbe_frad_chkdiana->RAPPORTO,qbe_frad_chkdiana->FLAGRAP,'6',w_flgrae,qbe_frad_chkdiana->STATOREG,qbe_frad_chkdiana->DATARETT)) */
            _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana.GetString("CONNALTRO"),Cursor_qbe_frad_chkdiana.GetDate("DATAREG"),Cursor_qbe_frad_chkdiana.GetString("RAPPORTO"),Cursor_qbe_frad_chkdiana.GetString("FLAGRAP"),"6",w_flgrae,Cursor_qbe_frad_chkdiana.GetString("STATOREG"),Cursor_qbe_frad_chkdiana.GetDate("DATARETT")));
            /* If w_flgchk='S' */
            if (CPLib.eqr(w_flgchk,"S")) {
              /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
              Page_15();
            } else { // Else
              /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
              FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
            } // End If
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
          } // End If
          /* _oldrighe := 0 */
          _oldrighe = CPLib.Round(0,0);
          /* If qbe_frad_chkdiana->STATOREG='3' */
          if (CPLib.eqr(Cursor_qbe_frad_chkdiana.GetString("STATOREG"),"3")) {
            // * --- Select from merzistifrz
            m_cServer = m_Ctx.GetServer("merzistifrz");
            m_cPhName = m_Ctx.GetPhName("merzistifrz");
            if (Cursor_merzistifrz!=null)
              Cursor_merzistifrz.Close();
            Cursor_merzistifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("merzistifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_merzistifrz.Eof())) {
              /* _note := w_tipinter + w_codinter+'6' + _idereg */
              _note = w_tipinter+w_codinter+"6"+_idereg;
              /* _note := _note + LRTrim(arfn_datisog_sol(merzistifrz->CODSOG,qbe_frad_chkdiana->DATAREG,qbe_frad_chkdiana->RAPPORTO,qbe_frad_chkdiana->FLAGRAP,'6',w_flgrae,qbe_frad_chkdiana->STATOREG,qbe_frad_chkdiana->DATARETT)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_merzistifrz.GetString("CODSOG"),Cursor_qbe_frad_chkdiana.GetDate("DATAREG"),Cursor_qbe_frad_chkdiana.GetString("RAPPORTO"),Cursor_qbe_frad_chkdiana.GetString("FLAGRAP"),"6",w_flgrae,Cursor_qbe_frad_chkdiana.GetString("STATOREG"),Cursor_qbe_frad_chkdiana.GetDate("DATARETT")));
              /* If w_flgchk='S' */
              if (CPLib.eqr(w_flgchk,"S")) {
                /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                Page_15();
              } else { // Else
                /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
              } // End If
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
              Cursor_merzistifrz.Next();
            }
            m_cConnectivityError = Cursor_merzistifrz.ErrorMessage();
            Cursor_merzistifrz.Close();
            // * --- End Select
          } // End If
          /* If _oldrighe=0 */
          if (CPLib.eqr(_oldrighe,0)) {
            // * --- Select from terzistifrz
            m_cServer = m_Ctx.GetServer("terzistifrz");
            m_cPhName = m_Ctx.GetPhName("terzistifrz");
            if (Cursor_terzistifrz!=null)
              Cursor_terzistifrz.Close();
            Cursor_terzistifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("terzistifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_terzistifrz.Eof())) {
              /* _note := w_tipinter + w_codinter+'6' + _idereg */
              _note = w_tipinter+w_codinter+"6"+_idereg;
              /* _note := _note + LRTrim(arfn_datisog_sol(terzistifrz->CODSOG,qbe_frad_chkdiana->DATAREG,qbe_frad_chkdiana->RAPPORTO,qbe_frad_chkdiana->FLAGRAP,'6',w_flgrae,qbe_frad_chkdiana->STATOREG,qbe_frad_chkdiana->DATARETT)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_terzistifrz.GetString("CODSOG"),Cursor_qbe_frad_chkdiana.GetDate("DATAREG"),Cursor_qbe_frad_chkdiana.GetString("RAPPORTO"),Cursor_qbe_frad_chkdiana.GetString("FLAGRAP"),"6",w_flgrae,Cursor_qbe_frad_chkdiana.GetString("STATOREG"),Cursor_qbe_frad_chkdiana.GetDate("DATARETT")));
              /* If w_flgchk='S' */
              if (CPLib.eqr(w_flgchk,"S")) {
                /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                Page_15();
              } else { // Else
                /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
              } // End If
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
              Cursor_terzistifrz.Next();
            }
            m_cConnectivityError = Cursor_terzistifrz.ErrorMessage();
            Cursor_terzistifrz.Close();
            // * --- End Select
          } // End If
          /* gNumRec := nTotRec // N� Record DIANA */
          gNumRec = CPLib.Round(nTotRec,0);
          m_Ctx.SetGlobalNumber("gNumRec",gNumRec);
          /* gNumReg := nTotReg // N� Registrazioni DIANA */
          gNumReg = CPLib.Round(nTotReg,0);
          m_Ctx.SetGlobalNumber("gNumReg",gNumReg);
          Cursor_qbe_frad_chkdiana.Next();
        }
        m_cConnectivityError = Cursor_qbe_frad_chkdiana.ErrorMessage();
        Cursor_qbe_frad_chkdiana.Close();
        // * --- End Select
        /* _contacilci := _contacilci+1 */
        _contacilci = CPLib.Round(_contacilci+1,0);
      } // End While
    } finally {
      try {
        if (Cursor_qbe_frad_chkdiana_limits!=null)
          Cursor_qbe_frad_chkdiana_limits.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_frad_chkdiana!=null)
          Cursor_qbe_frad_chkdiana.Close();
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
        if (Read_Cursor!=null)
          Read_Cursor.Close();
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
        if (Cursor_kersonbo!=null)
          Cursor_kersonbo.Close();
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
        if (Cursor_mlientifrz!=null)
          Cursor_mlientifrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_clientifrz!=null)
          Cursor_clientifrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_mogopefbo!=null)
          Cursor_mogopefbo.Close();
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
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_meneficfrz!=null)
          Cursor_meneficfrz.Close();
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
        if (Cursor_merzistifrz!=null)
          Cursor_merzistifrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_terzistifrz!=null)
          Cursor_terzistifrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_10() throws Exception {
    CPResultSet Cursor_qbe_frap_chkdiana_limits=null;
    CPResultSet Cursor_qbe_frap_chkdiana=null;
    CPResultSet Cursor_anarapbo=null;
    CPResultSet Cursor_xnarapbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_anadip=null;
    CPResultSet Cursor_kersonbo=null;
    CPResultSet Cursor_knarapbo=null;
    CPResultSet Cursor_xntestbo=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_xlientifrz=null;
    CPResultSet Cursor_xogopefbo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_xeneficfrz=null;
    CPResultSet Cursor_xerzistifrz=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Cicla sulle frazionate provvisorie */
      /* gMsgImp := 'Verifica Frazionate Provvisorie da elaborare ...' // Messaggio Import */
      gMsgImp = "Verifica Frazionate Provvisorie da elaborare ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* _max := 0 */
      _max = CPLib.Round(0,0);
      /* _min := 0 */
      _min = CPLib.Round(0,0);
      /* _ciclo := 0 */
      _ciclo = CPLib.Round(0,0);
      /* Prima gli italiani */
      // * --- Select from qbe_frap_chkdiana_limits
      SPBridge.HMCaller _hETXZZDHOET;
      _hETXZZDHOET = new SPBridge.HMCaller();
      _hETXZZDHOET.Set("m_cVQRList",m_cVQRList);
      _hETXZZDHOET.Set("cdadata",w_cdadata);
      _hETXZZDHOET.Set("c_adata",w_c_adata);
      _hETXZZDHOET.Set("codage",w_codage);
      _hETXZZDHOET.Set("codcli",w_codcli);
      _hETXZZDHOET.Set("ragben",w_ragben);
      if (Cursor_qbe_frap_chkdiana_limits!=null)
        Cursor_qbe_frap_chkdiana_limits.Close();
      Cursor_qbe_frap_chkdiana_limits = new VQRHolder("qbe_frap_chkdiana_limits",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_hETXZZDHOET,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_frap_chkdiana_limits.Eof())) {
        /* _max := qbe_frap_chkdiana_limits->MAXFRZ */
        _max = CPLib.Round(Cursor_qbe_frap_chkdiana_limits.GetDouble("MAXFRZ"),0);
        /* _min := qbe_frap_chkdiana_limits->MINFRZ */
        _min = CPLib.Round(Cursor_qbe_frap_chkdiana_limits.GetDouble("MINFRZ"),0);
        Cursor_qbe_frap_chkdiana_limits.Next();
      }
      m_cConnectivityError = Cursor_qbe_frap_chkdiana_limits.ErrorMessage();
      Cursor_qbe_frap_chkdiana_limits.Close();
      // * --- End Select
      /* _cicli := iif(Mod(_max,5000) <> 0,Int(_max/5000) + 1,Int(_max/5000)) */
      _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,5000),0)?CPLib.Int(_max/5000)+1:CPLib.Int(_max/5000)),0);
      /* _bottom := _min */
      _bottom = CPLib.Round(_min,0);
      /* If _min > 5000 */
      if (CPLib.gt(_min,5000)) {
        /* _contacilci := Int(_min/5000) + 1 */
        _contacilci = CPLib.Round(CPLib.Int(_min/5000)+1,0);
      } else { // Else
        /* _contacilci := 1 */
        _contacilci = CPLib.Round(1,0);
      } // End If
      /* gMsgImp := 'Lettura frazionate in corso ...' // Messaggio Import */
      gMsgImp = "Lettura frazionate in corso ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* While _contacilci<=_cicli */
      while (CPLib.le(_contacilci,_cicli)) {
        /* _bottom := iif(_ciclo=0,_bottom,((_contacilci -1 ) * 5000) + 1) */
        _bottom = CPLib.Round((CPLib.eqr(_ciclo,0)?_bottom:((_contacilci-1)*5000)+1),0);
        /* _top := _contacilci * 5000 */
        _top = CPLib.Round(_contacilci*5000,0);
        /* _ciclo := 1 */
        _ciclo = CPLib.Round(1,0);
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
        /* gMsgImp := 'Lettura frazionate in corso ... Ciclo N. '+LRTrim(Str(_contacilci,10,0)) // Messaggio Import */
        gMsgImp = "Lettura frazionate in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacilci,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* Cicla sulle operazioni */
        // * --- Select from qbe_frap_chkdiana
        SPBridge.HMCaller _hPIZZRGFIKA;
        _hPIZZRGFIKA = new SPBridge.HMCaller();
        _hPIZZRGFIKA.Set("m_cVQRList",m_cVQRList);
        _hPIZZRGFIKA.Set("cdadata",w_cdadata);
        _hPIZZRGFIKA.Set("c_adata",w_c_adata);
        _hPIZZRGFIKA.Set("codage",w_codage);
        _hPIZZRGFIKA.Set("_bottom",_bottom);
        _hPIZZRGFIKA.Set("_top",_top);
        _hPIZZRGFIKA.Set("codcli",w_codcli);
        _hPIZZRGFIKA.Set("ragben",w_ragben);
        if (Cursor_qbe_frap_chkdiana!=null)
          Cursor_qbe_frap_chkdiana.Close();
        Cursor_qbe_frap_chkdiana = new VQRHolder("qbe_frap_chkdiana",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_hPIZZRGFIKA,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_frap_chkdiana.Eof())) {
          /* _ctotale := _ctotale + 1 */
          _ctotale = CPLib.Round(_ctotale+1,0);
          /* gMsgImp := 'Elaborazione Frazionata N.: '+LRTrim(Str(_ctotale,15,0)) // Messaggio Import */
          gMsgImp = "Elaborazione Frazionata N.: "+CPLib.LRTrim(CPLib.Str(_ctotale,15,0));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* If Empty(LRTrim(qbe_frap_chkdiana->FLAGRAP2)) */
          if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("FLAGRAP2")))) {
            /* _idereg := DateToChar(qbe_frap_chkdiana->DATAOPE) + "F" + Right(qbe_frap_chkdiana->NUMPROG,10) + 'S' */
            _idereg = CPLib.DateToChar(Cursor_qbe_frap_chkdiana.GetDate("DATAOPE"))+"F"+CPLib.Right(Cursor_qbe_frap_chkdiana.GetString("NUMPROG"),10)+"S";
          } else { // Else
            /* _idereg := Left(qbe_frap_chkdiana->IDEREG,8) + "F" + Right(qbe_frap_chkdiana->IDEREG,11) */
            _idereg = CPLib.Left(Cursor_qbe_frap_chkdiana.GetString("IDEREG"),8)+"F"+CPLib.Right(Cursor_qbe_frap_chkdiana.GetString("IDEREG"),11);
          } // End If
          /* _note := w_tipinter + w_codinter + '1' + _idereg */
          _note = w_tipinter+w_codinter+"1"+_idereg;
          /* _flagrap := '' */
          _flagrap = "";
          // * --- Select from anarapbo
          m_cServer = m_Ctx.GetServer("anarapbo");
          m_cPhName = m_Ctx.GetPhName("anarapbo");
          if (Cursor_anarapbo!=null)
            Cursor_anarapbo.Close();
          Cursor_anarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select TIPORAP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_frap_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("anarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_anarapbo.Eof())) {
            /* _flagrap := anarapbo->TIPORAP */
            _flagrap = Cursor_anarapbo.GetString("TIPORAP");
            Cursor_anarapbo.Next();
          }
          m_cConnectivityError = Cursor_anarapbo.ErrorMessage();
          Cursor_anarapbo.Close();
          // * --- End Select
          /* If Empty(LRTrim(_flagrap)) */
          if (CPLib.Empty(CPLib.LRTrim(_flagrap))) {
            // * --- Select from xnarapbo
            m_cServer = m_Ctx.GetServer("xnarapbo");
            m_cPhName = m_Ctx.GetPhName("xnarapbo");
            if (Cursor_xnarapbo!=null)
              Cursor_xnarapbo.Close();
            Cursor_xnarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select TIPORAP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_frap_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xnarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xnarapbo.Eof())) {
              /* _flagrap := anarapbo->TIPORAP */
              _flagrap = Cursor_anarapbo.GetString("TIPORAP");
              Cursor_xnarapbo.Next();
            }
            m_cConnectivityError = Cursor_xnarapbo.ErrorMessage();
            Cursor_xnarapbo.Close();
            // * --- End Select
            /* _flagrap := iif(Empty(LRTrim(_flagrap)),qbe_frap_chkdiana->FLAGRAP,_flagrap) */
            _flagrap = (CPLib.Empty(CPLib.LRTrim(_flagrap))?Cursor_qbe_frap_chkdiana.GetString("FLAGRAP"):_flagrap);
          } // End If
          /* If Empty(qbe_frap_chkdiana->CODDIPE) */
          if (CPLib.Empty(Cursor_qbe_frap_chkdiana.GetString("CODDIPE"))) {
            // * --- Read from intermbo
            m_cServer = m_Ctx.GetServer("intermbo");
            m_cPhName = m_Ctx.GetPhName("intermbo");
            m_cSql = "";
            m_cSql = m_cSql+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codinter,"C",11,0,m_cServer),m_cServer,w_codinter);
            if (m_Ctx.IsSharedTemp("intermbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODCAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODDIPE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              w_codcab = Read_Cursor.GetString("CODCAB");
              w_desccit = Read_Cursor.GetString("DESCCIT");
              w_provin = Read_Cursor.GetString("PROVINCIA");
              w_coddipe = Read_Cursor.GetString("CODDIPE");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on intermbo into routine arrt_chkdiana_old returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              w_codcab = "";
              w_desccit = "";
              w_provin = "";
              w_coddipe = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(w_coddipe) */
            if (CPLib.Empty(w_coddipe)) {
              /* _note := _note + '000000' + Left(LRTrim(w_codcab)+Space(6),6) + Left(LRTrim(w_desccit)+Space(30),30) + Left(LRTrim(w_provin)+Space(2),2) */
              _note = _note+"000000"+CPLib.Left(CPLib.LRTrim(w_codcab)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(w_desccit)+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(w_provin)+CPLib.Space(2),2);
            } else { // Else
              /* _note := _note + w_coddipe */
              _note = _note+w_coddipe;
              // * --- Read from anadip
              m_cServer = m_Ctx.GetServer("anadip");
              m_cPhName = m_Ctx.GetPhName("anadip");
              m_cSql = "";
              m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_coddipe,"C",6,0,m_cServer),m_cServer,w_coddipe);
              if (m_Ctx.IsSharedTemp("anadip")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                w_cabcod = Read_Cursor.GetString("CAB");
                w_citdesc = Read_Cursor.GetString("DESCCIT");
                w_provind = Read_Cursor.GetString("PROVINCIA");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on anadip into routine arrt_chkdiana_old returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                w_cabcod = "";
                w_citdesc = "";
                w_provind = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(w_cabcod) */
              if (CPLib.Empty(w_cabcod)) {
                /* _note := _note + Left(LRTrim(w_codcab)+Space(6),6) + Left(LRTrim(w_desccit)+Space(30),30) + Left(LRTrim(w_provin)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(w_codcab)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(w_desccit)+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(w_provin)+CPLib.Space(2),2);
              } else { // Else
                /* _note := _note + Left(LRTrim(w_cabcod)+Space(6),6) + Left(LRTrim(w_citdesc)+Space(30),30) + Left(LRTrim(w_provind)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(w_cabcod)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(w_citdesc)+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(w_provind)+CPLib.Space(2),2);
              } // End If
            } // End If
          } else { // Else
            // * --- Select from anadip
            m_cServer = m_Ctx.GetServer("anadip");
            m_cPhName = m_Ctx.GetPhName("anadip");
            if (Cursor_anadip!=null)
              Cursor_anadip.Close();
            Cursor_anadip = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODDIP="+CPLib.ToSQL(Cursor_qbe_frap_chkdiana.GetString("CODDIPE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("anadip")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_anadip.Eof())) {
              /* _note := _note + qbe_frap_chkdiana->CODDIPE + Left(LRTrim(anadip->CAB)+Space(6),6) + Left(LRTrim(anadip->DESCCIT)+Space(30),30) + Left(LRTrim(anadip->PROVINCIA)+Space(2),2) */
              _note = _note+Cursor_qbe_frap_chkdiana.GetString("CODDIPE")+CPLib.Left(CPLib.LRTrim(Cursor_anadip.GetString("CAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_anadip.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_anadip.GetString("PROVINCIA"))+CPLib.Space(2),2);
              Cursor_anadip.Next();
            }
            m_cConnectivityError = Cursor_anadip.ErrorMessage();
            Cursor_anadip.Close();
            // * --- End Select
          } // End If
          /* _note := _note + Left(DateToChar(qbe_frap_chkdiana->DATAOPE)+Space(8),8) + Left(LRTrim(qbe_frap_chkdiana->FLAGFRAZ)+" ",1) + Left(LRTrim(qbe_frap_chkdiana->FLAGCONT)+" ",1) */
          _note = _note+CPLib.Left(CPLib.DateToChar(Cursor_qbe_frap_chkdiana.GetDate("DATAOPE"))+CPLib.Space(8),8)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("FLAGFRAZ"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("FLAGCONT"))+" ",1);
          /* _note := _note + Left(LRTrim(qbe_frap_chkdiana->CODANA)+Space(4),4) + Left(LRTrim(qbe_frap_chkdiana->CODVOC)+Space(2),2) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("CODANA"))+CPLib.Space(4),4)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("CODVOC"))+CPLib.Space(2),2);
          /* _note := _note + Left(LRTrim(qbe_frap_chkdiana->TIPOINT2)+Space(2),2) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("TIPOINT2"))+CPLib.Space(2),2);
          /* _note := _note + iif(Empty(LRTrim(qbe_frap_chkdiana->CODFISCICP)),Left(LRTrim(qbe_frap_chkdiana->CODINT2)+Space(11),11),Left(LRTrim(qbe_frap_chkdiana->CODFISCICP)+Space(11),11)) */
          _note = _note+(CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("CODFISCICP")))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("CODINT2"))+CPLib.Space(11),11):CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("CODFISCICP"))+CPLib.Space(11),11));
          /* _note := _note + Left(LRTrim(qbe_frap_chkdiana->PAESE)+Space(3),3) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("PAESE"))+CPLib.Space(3),3);
          /* _note := _note + Left(LRTrim(qbe_frap_chkdiana->CODCAB2)+Space(6),6) + Left(LRTrim(arfn_agechar(qbe_frap_chkdiana->DESC2,' '))+Space(30),30) + Left(LRTrim(qbe_frap_chkdiana->PROV2)+Space(2),2) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("CODCAB2"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frap_chkdiana.GetString("DESC2")," "))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("PROV2"))+CPLib.Space(2),2);
          /* _note := _note + Left(LRTrim(arfn_agechar(qbe_frap_chkdiana->DESCINTER,' '))+Space(50),50) + Left(LRTrim(arfn_agechar(qbe_frap_chkdiana->RAPPORTO,' '))+Space(25),25) + Left(LRTrim(_flagrap)+" ",1) */
          _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frap_chkdiana.GetString("DESCINTER")," "))+CPLib.Space(50),50)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frap_chkdiana.GetString("RAPPORTO")," "))+CPLib.Space(25),25)+CPLib.Left(CPLib.LRTrim(_flagrap)+" ",1);
          /* _note := _note + Left(LRTrim(qbe_frap_chkdiana->TIPOLEG)+" ",1) + Left(LRTrim(DateToChar(qbe_frap_chkdiana->DATAREG))+Space(8),8) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("TIPOLEG"))+" ",1)+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_frap_chkdiana.GetDate("DATAREG")))+CPLib.Space(8),8);
          /* _note := _note + Left(LRTrim(qbe_frap_chkdiana->TIPOOPRAP)+Space(2),2) + Left(LRTrim(qbe_frap_chkdiana->COLLEG)+Space(11),11) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("TIPOOPRAP"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("COLLEG"))+CPLib.Space(11),11);
          /* _note := _note + " " + Left(LRTrim(qbe_frap_chkdiana->STATOREG)+" ",1)  */
          _note = _note+" "+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("STATOREG"))+" ",1);
          /* If Empty(qbe_frap_chkdiana->DATARETT) or DateToChar(qbe_frap_chkdiana->DATARETT)='01000101' */
          if (CPLib.Empty(Cursor_qbe_frap_chkdiana.GetDate("DATARETT")) || CPLib.eqr(CPLib.DateToChar(Cursor_qbe_frap_chkdiana.GetDate("DATARETT")),"01000101")) {
            /* _note := _note + Space(8) */
            _note = _note+CPLib.Space(8);
          } else { // Else
            /* _note := _note + Left(LRTrim(DateToChar(qbe_frap_chkdiana->DATARETT))+Space(8),8) */
            _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_frap_chkdiana.GetDate("DATARETT")))+CPLib.Space(8),8);
          } // End If
          /* _note := _note + iif(Empty(LRTrim(qbe_frap_chkdiana->OPERAZMOD)),Space(20),Left(qbe_frap_chkdiana->OPERAZMOD,8)+"F"+Right(qbe_frap_chkdiana->OPERAZMOD,11)) */
          _note = _note+(CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("OPERAZMOD")))?CPLib.Space(20):CPLib.Left(Cursor_qbe_frap_chkdiana.GetString("OPERAZMOD"),8)+"F"+CPLib.Right(Cursor_qbe_frap_chkdiana.GetString("OPERAZMOD"),11));
          /* _note := _note + Left(LRTrim(qbe_frap_chkdiana->FLAGLIRE)+" ",1) + Left(LRTrim(qbe_frap_chkdiana->VALUTA)+Space(3),3) + Left(LRTrim(qbe_frap_chkdiana->SEGNO)+" ",1) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("FLAGLIRE"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("VALUTA"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("SEGNO"))+" ",1);
          /* _note := _note +  Right('000000000000000'+LRTrim(Str(qbe_frap_chkdiana->TOTLIRE,15,0)),15) + Right('000000000000000'+LRTrim(Str(qbe_frap_chkdiana->TOTCONT,15,0)),15) + Space(69) */
          _note = _note+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_frap_chkdiana.GetDouble("TOTLIRE"),15,0)),15)+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_frap_chkdiana.GetDouble("TOTCONT"),15,0)),15)+CPLib.Space(69);
          /* If w_flgchk='S' */
          if (CPLib.eqr(w_flgchk,"S")) {
            /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
            Page_15();
          } else { // Else
            /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
            FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
          } // End If
          /* nTotRec := nTotRec + 1 */
          nTotRec = CPLib.Round(nTotRec+1,0);
          /* nTotReg := nTotReg + 1 */
          nTotReg = CPLib.Round(nTotReg+1,0);
          /* nNumRec := nNumRec + 1 */
          nNumRec = CPLib.Round(nNumRec+1,0);
          /* If not(Empty(qbe_frap_chkdiana->CONNESCLI)) and Empty(LRTrim(qbe_frap_chkdiana->RAPPORTO)) */
          if ( ! (CPLib.Empty(Cursor_qbe_frap_chkdiana.GetString("CONNESCLI"))) && CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("RAPPORTO")))) {
            /* _oldrap := '' */
            _oldrap = "";
            /* _codrif := qbe_frap_chkdiana->CONNESCLI */
            _codrif = Cursor_qbe_frap_chkdiana.GetString("CONNESCLI");
            /* If gFlgWU='S' */
            if (CPLib.eqr(gFlgWU,"S")) {
              // * --- Select from kersonbo
              m_cServer = m_Ctx.GetServer("kersonbo");
              m_cPhName = m_Ctx.GetPhName("kersonbo");
              if (Cursor_kersonbo!=null)
                Cursor_kersonbo.Close();
              Cursor_kersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_frap_chkdiana.GetString("CONNESDOC"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("kersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_kersonbo.Eof())) {
                /* _ramate := iif(w_flgrae='R',LRTrim(kersonbo->RAMOGRUP),Left(LRTrim(kersonbo->ATTIV),3)) */
                _ramate = (CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_kersonbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("ATTIV")),3));
                /* _note := w_tipinter + w_codinter */
                _note = w_tipinter+w_codinter;
                /* If Empty(qbe_frap_chkdiana->CONNESOPER) or (qbe_frap_chkdiana->CONNESOPER=qbe_frap_chkdiana->CONNESCLI) */
                if (CPLib.Empty(Cursor_qbe_frap_chkdiana.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_frap_chkdiana.GetString("CONNESOPER"),Cursor_qbe_frap_chkdiana.GetString("CONNESCLI")))) {
                  /* _note := _note + '2' */
                  _note = _note+"2";
                } else { // Else
                  /* _note := _note + '3' */
                  _note = _note+"3";
                } // End If
                /* _note := _note + _idereg */
                _note = _note+_idereg;
                /* _note := _note + Left(LRTrim(qbe_frap_chkdiana->CONNESCLI)+Space(16),16) + Left(LRTrim(kersonbo->RAGSOC)+Space(70),70) + Left(LRTrim(kersonbo->PAESE)+Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("CONNESCLI"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("PAESE"))+CPLib.Space(3),3);
                /* _note := _note + Left(LRTrim(kersonbo->CODCAB)+Space(6),6) + Left(LRTrim(kersonbo->DESCCIT)+Space(30),30) + Left(LRTrim(kersonbo->PROVINCIA)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                /* _note := _note + Left(LRTrim(kersonbo->DOMICILIO)+Space(35),35) + Left(LRTrim(kersonbo->CAP)+ Space(5),5) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("CAP"))+CPLib.Space(5),5);
                /* _note := _note + Left(LRTrim(kersonbo->CODFISC)+Space(16),16)  */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("CODFISC"))+CPLib.Space(16),16);
                /* If Empty(kersonbo->DATANASC) or DateToChar(kersonbo->DATANASC)='01000101' */
                if (CPLib.Empty(Cursor_kersonbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_kersonbo.GetDate("DATANASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(kersonbo->DATANASC))+Space(8),8) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_kersonbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                } // End If
                /* If not(Empty(kersonbo->NASSTATO)) */
                if ( ! (CPLib.Empty(Cursor_kersonbo.GetString("NASSTATO")))) {
                  /* _note := _note + Left(LRTrim(kersonbo->NASSTATO)+Space(30),30) + Left(LRTrim(kersonbo->SOTGRUP)+Space(3),3) + Left(LRTrim(_ramate)+Space(3),3) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(_ramate)+CPLib.Space(3),3);
                } else { // Else
                  /* _note := _note + Left(LRTrim(kersonbo->NASCOMUN)+Space(30),30) + Left(LRTrim(kersonbo->SOTGRUP)+Space(3),3) + Left(LRTrim(_ramate) +Space(3),3) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(_ramate)+CPLib.Space(3),3);
                } // End If
                /* _note := _note + Left(LRTrim(kersonbo->SETTSINT)+Space(3),3) + Left(LRTrim(arfn_agechar(qbe_frap_chkdiana->RAPPORTO,' '))+Space(25),25) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frap_chkdiana.GetString("RAPPORTO")," "))+CPLib.Space(25),25);
                /* _note := _note + Left(LRTrim(qbe_frap_chkdiana->FLAGRAP)+" ",1) + Left(LRTrim(kersonbo->TIPODOC)+Space(2),2) + Left(LRTrim(kersonbo->NUMDOCUM)+Space(15),15) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                /* If Empty(kersonbo->DATARILASC) or DateToChar(kersonbo->DATARILASC)='01000101' */
                if (CPLib.Empty(Cursor_kersonbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_kersonbo.GetDate("DATARILASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(kersonbo->DATARILASC))+Space(8),8)  */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_kersonbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                } // End If
                /* _note := _note + Left(LRTrim(kersonbo->AUTRILASC)+Space(30),30) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("AUTRILASC"))+CPLib.Space(30),30);
                /* _note := _note + Left(LRTrim(kersonbo->SESSO)+" ",1) + Space(34) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SESSO"))+" ",1)+CPLib.Space(34);
                /* If w_flgchk='S' */
                if (CPLib.eqr(w_flgchk,"S")) {
                  /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                  Page_15();
                } else { // Else
                  /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                  FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                } // End If
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_kersonbo.Next();
              }
              m_cConnectivityError = Cursor_kersonbo.ErrorMessage();
              Cursor_kersonbo.Close();
              // * --- End Select
            } else { // Else
              /* _note := w_tipinter + w_codinter */
              _note = w_tipinter+w_codinter;
              /* If Empty(qbe_frap_chkdiana->CONNESOPER) or (qbe_frap_chkdiana->CONNESOPER=qbe_frap_chkdiana->CONNESCLI) */
              if (CPLib.Empty(Cursor_qbe_frap_chkdiana.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_frap_chkdiana.GetString("CONNESOPER"),Cursor_qbe_frap_chkdiana.GetString("CONNESCLI")))) {
                /* _note := _note + '2' */
                _note = _note+"2";
              } else { // Else
                /* _note := _note + '3' */
                _note = _note+"3";
              } // End If
              /* _note := _note + _idereg */
              _note = _note+_idereg;
              /* _note := _note + LRTrim(arfn_datisog_sol(qbe_frap_chkdiana->CONNESCLI,qbe_frap_chkdiana->DATAREG,qbe_frap_chkdiana->RAPPORTO,qbe_frap_chkdiana->FLAGRAP,'2',w_flgrae,qbe_frap_chkdiana->STATOREG,qbe_frap_chkdiana->DATARETT)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_frap_chkdiana.GetString("CONNESCLI"),Cursor_qbe_frap_chkdiana.GetDate("DATAREG"),Cursor_qbe_frap_chkdiana.GetString("RAPPORTO"),Cursor_qbe_frap_chkdiana.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_frap_chkdiana.GetString("STATOREG"),Cursor_qbe_frap_chkdiana.GetDate("DATARETT")));
              /* If w_flgchk='S' */
              if (CPLib.eqr(w_flgchk,"S")) {
                /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                Page_15();
              } else { // Else
                /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
              } // End If
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
            } // End If
          } else { // Else
            /* _oldrap := '' */
            _oldrap = "";
            // * --- Read from knarapbo
            m_cServer = m_Ctx.GetServer("knarapbo");
            m_cPhName = m_Ctx.GetPhName("knarapbo");
            m_cSql = "";
            m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_frap_chkdiana.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_qbe_frap_chkdiana.GetString("RAPPORTO"));
            if (m_Ctx.IsSharedTemp("knarapbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _oldrap = Read_Cursor.GetString("RAPPORTO");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on knarapbo into routine arrt_chkdiana_old returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _oldrap = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If not(Empty(_oldrap)) */
            if ( ! (CPLib.Empty(_oldrap))) {
              // * --- Select from knarapbo
              m_cServer = m_Ctx.GetServer("knarapbo");
              m_cPhName = m_Ctx.GetPhName("knarapbo");
              if (Cursor_knarapbo!=null)
                Cursor_knarapbo.Close();
              Cursor_knarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_frap_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("knarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_knarapbo.Eof())) {
                /* If knarapbo->TIPORAP='P' */
                if (CPLib.eqr(Cursor_knarapbo.GetString("TIPORAP"),"P")) {
                  // * --- Select from xntestbo
                  m_cServer = m_Ctx.GetServer("xntestbo");
                  m_cPhName = m_Ctx.GetPhName("xntestbo");
                  if (Cursor_xntestbo!=null)
                    Cursor_xntestbo.Close();
                  Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_frap_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_xntestbo.Eof())) {
                    /* If qbe_frap_chkdiana->RAPPORTO = xntestbo->RAPPORTO */
                    if (CPLib.eqr(Cursor_qbe_frap_chkdiana.GetString("RAPPORTO"),Cursor_xntestbo.GetString("RAPPORTO"))) {
                      /* _avanza := 0 */
                      _avanza = CPLib.Round(0,0);
                      /* If Empty(xntestbo->CODINTER) or xntestbo->STATOREG='2' or xntestbo->STATOREG='3' */
                      if (CPLib.Empty(Cursor_xntestbo.GetString("CODINTER")) || CPLib.eqr(Cursor_xntestbo.GetString("STATOREG"),"2") || CPLib.eqr(Cursor_xntestbo.GetString("STATOREG"),"3")) {
                        /* _avanza := 1 */
                        _avanza = CPLib.Round(1,0);
                      } // End If
                      /* If xntestbo->DATAINI > qbe_frap_chkdiana->DATAOPE */
                      if (CPLib.gt(Cursor_xntestbo.GetDate("DATAINI"),Cursor_qbe_frap_chkdiana.GetDate("DATAOPE"))) {
                        /* _avanza := 1 */
                        _avanza = CPLib.Round(1,0);
                      } // End If
                      /* If not(Empty(xntestbo->DATAFINE)) and xntestbo->DATAFINE < qbe_frap_chkdiana->DATAOPE */
                      if ( ! (CPLib.Empty(Cursor_xntestbo.GetDate("DATAFINE"))) && CPLib.lt(Cursor_xntestbo.GetDate("DATAFINE"),Cursor_qbe_frap_chkdiana.GetDate("DATAOPE"))) {
                        /* _avanza := 1 */
                        _avanza = CPLib.Round(1,0);
                      } // End If
                      /* If _avanza = 0 */
                      if (CPLib.eqr(_avanza,0)) {
                        /* _codrif := xntestbo->CODINTER */
                        _codrif = Cursor_xntestbo.GetString("CODINTER");
                        /* _note := w_tipinter + w_codinter */
                        _note = w_tipinter+w_codinter;
                        /* If Empty(qbe_frap_chkdiana->CONNESOPER) or (qbe_frap_chkdiana->CONNESOPER=qbe_frap_chkdiana->CONNESCLI) */
                        if (CPLib.Empty(Cursor_qbe_frap_chkdiana.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_frap_chkdiana.GetString("CONNESOPER"),Cursor_qbe_frap_chkdiana.GetString("CONNESCLI")))) {
                          /* _note := _note + '2' */
                          _note = _note+"2";
                        } else { // Else
                          /* _note := _note + '3' */
                          _note = _note+"3";
                        } // End If
                        /* _note := _note + _idereg */
                        _note = _note+_idereg;
                        /* _note := _note + LRTrim(arfn_datisog_sol(xntestbo->CODINTER,qbe_frap_chkdiana->DATAREG,qbe_frap_chkdiana->RAPPORTO,qbe_frap_chkdiana->FLAGRAP,'2',w_flgrae,qbe_frap_chkdiana->STATOREG,qbe_frap_chkdiana->DATARETT)) */
                        _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_xntestbo.GetString("CODINTER"),Cursor_qbe_frap_chkdiana.GetDate("DATAREG"),Cursor_qbe_frap_chkdiana.GetString("RAPPORTO"),Cursor_qbe_frap_chkdiana.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_frap_chkdiana.GetString("STATOREG"),Cursor_qbe_frap_chkdiana.GetDate("DATARETT")));
                        /* If w_flgchk='S' */
                        if (CPLib.eqr(w_flgchk,"S")) {
                          /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                          Page_15();
                        } else { // Else
                          /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                          FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                        } // End If
                        /* nTotRec := nTotRec + 1 */
                        nTotRec = CPLib.Round(nTotRec+1,0);
                        /* nNumRec := nNumRec + 1 */
                        nNumRec = CPLib.Round(nNumRec+1,0);
                      } // End If
                    } // End If
                    Cursor_xntestbo.Next();
                  }
                  m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
                  Cursor_xntestbo.Close();
                  // * --- End Select
                } else { // Else
                  // * --- Select from intestbo
                  m_cServer = m_Ctx.GetServer("intestbo");
                  m_cPhName = m_Ctx.GetPhName("intestbo");
                  if (Cursor_intestbo!=null)
                    Cursor_intestbo.Close();
                  Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_frap_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_intestbo.Eof())) {
                    /* If qbe_frap_chkdiana->RAPPORTO = intestbo->RAPPORTO */
                    if (CPLib.eqr(Cursor_qbe_frap_chkdiana.GetString("RAPPORTO"),Cursor_intestbo.GetString("RAPPORTO"))) {
                      /* _avanza := 0 */
                      _avanza = CPLib.Round(0,0);
                      /* If Empty(intestbo->CODINTER) or intestbo->STATOREG='2' or intestbo->STATOREG='3' */
                      if (CPLib.Empty(Cursor_intestbo.GetString("CODINTER")) || CPLib.eqr(Cursor_intestbo.GetString("STATOREG"),"2") || CPLib.eqr(Cursor_intestbo.GetString("STATOREG"),"3")) {
                        /* _avanza := 1 */
                        _avanza = CPLib.Round(1,0);
                      } // End If
                      /* If intestbo->DATAINI > qbe_frap_chkdiana->DATAOPE */
                      if (CPLib.gt(Cursor_intestbo.GetDate("DATAINI"),Cursor_qbe_frap_chkdiana.GetDate("DATAOPE"))) {
                        /* _avanza := 1 */
                        _avanza = CPLib.Round(1,0);
                      } // End If
                      /* If not(Empty(intestbo->DATAFINE)) and intestbo->DATAFINE < qbe_frap_chkdiana->DATAOPE */
                      if ( ! (CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE"))) && CPLib.lt(Cursor_intestbo.GetDate("DATAFINE"),Cursor_qbe_frap_chkdiana.GetDate("DATAOPE"))) {
                        /* _avanza := 1 */
                        _avanza = CPLib.Round(1,0);
                      } // End If
                      /* If _avanza = 0 */
                      if (CPLib.eqr(_avanza,0)) {
                        /* _codrif := intestbo->CODINTER */
                        _codrif = Cursor_intestbo.GetString("CODINTER");
                        /* _note := w_tipinter + w_codinter */
                        _note = w_tipinter+w_codinter;
                        /* If Empty(qbe_frap_chkdiana->CONNESOPER) or (qbe_frap_chkdiana->CONNESOPER=qbe_frap_chkdiana->CONNESCLI) */
                        if (CPLib.Empty(Cursor_qbe_frap_chkdiana.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_frap_chkdiana.GetString("CONNESOPER"),Cursor_qbe_frap_chkdiana.GetString("CONNESCLI")))) {
                          /* _note := _note + '2' */
                          _note = _note+"2";
                        } else { // Else
                          /* _note := _note + '3' */
                          _note = _note+"3";
                        } // End If
                        /* _note := _note + _idereg */
                        _note = _note+_idereg;
                        /* _note := _note + LRTrim(arfn_datisog_sol(intestbo->CODINTER,qbe_frap_chkdiana->DATAREG,qbe_frap_chkdiana->RAPPORTO,qbe_frap_chkdiana->FLAGRAP,'2',w_flgrae,qbe_frap_chkdiana->STATOREG,qbe_frap_chkdiana->DATARETT)) */
                        _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_intestbo.GetString("CODINTER"),Cursor_qbe_frap_chkdiana.GetDate("DATAREG"),Cursor_qbe_frap_chkdiana.GetString("RAPPORTO"),Cursor_qbe_frap_chkdiana.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_frap_chkdiana.GetString("STATOREG"),Cursor_qbe_frap_chkdiana.GetDate("DATARETT")));
                        /* If w_flgchk='S' */
                        if (CPLib.eqr(w_flgchk,"S")) {
                          /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                          Page_15();
                        } else { // Else
                          /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                          FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                        } // End If
                        /* nTotRec := nTotRec + 1 */
                        nTotRec = CPLib.Round(nTotRec+1,0);
                        /* nNumRec := nNumRec + 1 */
                        nNumRec = CPLib.Round(nNumRec+1,0);
                      } // End If
                    } // End If
                    Cursor_intestbo.Next();
                  }
                  m_cConnectivityError = Cursor_intestbo.ErrorMessage();
                  Cursor_intestbo.Close();
                  // * --- End Select
                } // End If
                Cursor_knarapbo.Next();
              }
              m_cConnectivityError = Cursor_knarapbo.ErrorMessage();
              Cursor_knarapbo.Close();
              // * --- End Select
            } else { // Else
              /* If not(Empty(LRTrim(qbe_frap_chkdiana->CONNESCLI))) */
              if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("CONNESCLI"))))) {
                /* _note := w_tipinter + w_codinter */
                _note = w_tipinter+w_codinter;
                /* If Empty(qbe_frap_chkdiana->CONNESOPER) or (qbe_frap_chkdiana->CONNESOPER=qbe_frap_chkdiana->CONNESCLI) */
                if (CPLib.Empty(Cursor_qbe_frap_chkdiana.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_frap_chkdiana.GetString("CONNESOPER"),Cursor_qbe_frap_chkdiana.GetString("CONNESCLI")))) {
                  /* _note := _note + '2' */
                  _note = _note+"2";
                } else { // Else
                  /* _note := _note + '3' */
                  _note = _note+"3";
                } // End If
                /* _note := _note + _idereg */
                _note = _note+_idereg;
                /* _note := _note + LRTrim(arfn_datisog_sol(qbe_frap_chkdiana->CONNESCLI,qbe_frap_chkdiana->DATAREG,qbe_frap_chkdiana->RAPPORTO,qbe_frap_chkdiana->FLAGRAP,'2',w_flgrae,qbe_frap_chkdiana->STATOREG,qbe_frap_chkdiana->DATARETT)) */
                _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_frap_chkdiana.GetString("CONNESCLI"),Cursor_qbe_frap_chkdiana.GetDate("DATAREG"),Cursor_qbe_frap_chkdiana.GetString("RAPPORTO"),Cursor_qbe_frap_chkdiana.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_frap_chkdiana.GetString("STATOREG"),Cursor_qbe_frap_chkdiana.GetDate("DATARETT")));
                /* If w_flgchk='S' */
                if (CPLib.eqr(w_flgchk,"S")) {
                  /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                  Page_15();
                } else { // Else
                  /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                  FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                } // End If
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
              } // End If
            } // End If
          } // End If
          /* If not(Empty(LRTrim(_oldrap))) */
          if ( ! (CPLib.Empty(CPLib.LRTrim(_oldrap)))) {
            /* _oldrighe := 0 */
            _oldrighe = CPLib.Round(0,0);
            // * --- Select from xlientifrz
            m_cServer = m_Ctx.GetServer("xlientifrz");
            m_cPhName = m_Ctx.GetPhName("xlientifrz");
            if (Cursor_xlientifrz!=null)
              Cursor_xlientifrz.Close();
            Cursor_xlientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_frap_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xlientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xlientifrz.Eof())) {
              /* _note := w_tipinter + w_codinter */
              _note = w_tipinter+w_codinter;
              /* If Empty(qbe_frap_chkdiana->CONNESOPER) or (qbe_frap_chkdiana->CONNESOPER=xlientifrz->CODSOG) */
              if (CPLib.Empty(Cursor_qbe_frap_chkdiana.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_frap_chkdiana.GetString("CONNESOPER"),Cursor_xlientifrz.GetString("CODSOG")))) {
                /* _note := _note + '2' */
                _note = _note+"2";
              } else { // Else
                /* _note := _note + '3' */
                _note = _note+"3";
              } // End If
              /* _note := _note + _idereg */
              _note = _note+_idereg;
              /* _note := _note + LRTrim(arfn_datisog_sol(xlientifrz->CODSOG,qbe_frap_chkdiana->DATAREG,qbe_frap_chkdiana->RAPPORTO,qbe_frap_chkdiana->FLAGRAP,'2',w_flgrae,qbe_frap_chkdiana->STATOREG,qbe_frap_chkdiana->DATARETT)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_xlientifrz.GetString("CODSOG"),Cursor_qbe_frap_chkdiana.GetDate("DATAREG"),Cursor_qbe_frap_chkdiana.GetString("RAPPORTO"),Cursor_qbe_frap_chkdiana.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_frap_chkdiana.GetString("STATOREG"),Cursor_qbe_frap_chkdiana.GetDate("DATARETT")));
              /* If w_flgchk='S' */
              if (CPLib.eqr(w_flgchk,"S")) {
                /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                Page_15();
              } else { // Else
                /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
              } // End If
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
              Cursor_xlientifrz.Next();
            }
            m_cConnectivityError = Cursor_xlientifrz.ErrorMessage();
            Cursor_xlientifrz.Close();
            // * --- End Select
          } // End If
          /* If not(Empty(qbe_frap_chkdiana->CONNESOPER)) and qbe_frap_chkdiana->CONNESOPER <> _codrif */
          if ( ! (CPLib.Empty(Cursor_qbe_frap_chkdiana.GetString("CONNESOPER"))) && CPLib.ne(Cursor_qbe_frap_chkdiana.GetString("CONNESOPER"),_codrif)) {
            /* _note := w_tipinter + w_codinter+'4' + _idereg */
            _note = w_tipinter+w_codinter+"4"+_idereg;
            /* _note := _note + LRTrim(arfn_datisog_sol(qbe_frap_chkdiana->CONNESOPER,qbe_frap_chkdiana->DATAREG,qbe_frap_chkdiana->RAPPORTO,qbe_frap_chkdiana->FLAGRAP,'4',w_flgrae,qbe_frap_chkdiana->STATOREG,qbe_frap_chkdiana->DATARETT)) */
            _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_frap_chkdiana.GetString("CONNESOPER"),Cursor_qbe_frap_chkdiana.GetDate("DATAREG"),Cursor_qbe_frap_chkdiana.GetString("RAPPORTO"),Cursor_qbe_frap_chkdiana.GetString("FLAGRAP"),"4",w_flgrae,Cursor_qbe_frap_chkdiana.GetString("STATOREG"),Cursor_qbe_frap_chkdiana.GetDate("DATARETT")));
            /* If w_flgchk='S' */
            if (CPLib.eqr(w_flgchk,"S")) {
              /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
              Page_15();
            } else { // Else
              /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
              FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
            } // End If
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
          } // End If
          // * --- Select from xogopefbo
          m_cServer = m_Ctx.GetServer("xogopefbo");
          m_cPhName = m_Ctx.GetPhName("xogopefbo");
          if (Cursor_xogopefbo!=null)
            Cursor_xogopefbo.Close();
          Cursor_xogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_frap_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_xogopefbo.Eof())) {
            /* _note := w_tipinter + w_codinter+'4' + _idereg */
            _note = w_tipinter+w_codinter+"4"+_idereg;
            /* _note := _note + LRTrim(arfn_datisog_sol(xogopefbo->CODSOG,qbe_frap_chkdiana->DATAREG,qbe_frap_chkdiana->RAPPORTO,qbe_frap_chkdiana->FLAGRAP,'4',w_flgrae,qbe_frap_chkdiana->STATOREG,qbe_frap_chkdiana->DATARETT)) */
            _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_xogopefbo.GetString("CODSOG"),Cursor_qbe_frap_chkdiana.GetDate("DATAREG"),Cursor_qbe_frap_chkdiana.GetString("RAPPORTO"),Cursor_qbe_frap_chkdiana.GetString("FLAGRAP"),"4",w_flgrae,Cursor_qbe_frap_chkdiana.GetString("STATOREG"),Cursor_qbe_frap_chkdiana.GetDate("DATARETT")));
            /* If w_flgchk='S' */
            if (CPLib.eqr(w_flgchk,"S")) {
              /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
              Page_15();
            } else { // Else
              /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
              FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
            } // End If
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
            Cursor_xogopefbo.Next();
          }
          m_cConnectivityError = Cursor_xogopefbo.ErrorMessage();
          Cursor_xogopefbo.Close();
          // * --- End Select
          /* If not(Empty(qbe_frap_chkdiana->CONNESBEN)) or not(Empty(qbe_frap_chkdiana->C_RAG)) */
          if ( ! (CPLib.Empty(Cursor_qbe_frap_chkdiana.GetString("CONNESBEN"))) ||  ! (CPLib.Empty(Cursor_qbe_frap_chkdiana.GetString("C_RAG")))) {
            /* If not(Empty(qbe_frap_chkdiana->C_RAG)) */
            if ( ! (CPLib.Empty(Cursor_qbe_frap_chkdiana.GetString("C_RAG")))) {
              /* _note := w_tipinter + w_codinter+'5' + _idereg */
              _note = w_tipinter+w_codinter+"5"+_idereg;
              /* _note := _note + Left(LRTrim(qbe_frap_chkdiana->CONNESBEN)+Space(16),16) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("CONNESBEN"))+CPLib.Space(16),16);
              /* _note := _note +Left(LRTrim(arfn_agechar(qbe_frap_chkdiana->C_RAG,' '))+Space(70),70) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frap_chkdiana.GetString("C_RAG")," "))+CPLib.Space(70),70);
              /* _note := _note + Left(LRTrim(qbe_frap_chkdiana->C_STA)+Space(3),3) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_STA"))+CPLib.Space(3),3);
              /* _note := _note +Left(LRTrim(qbe_frap_chkdiana->C_CAB)+Space(6),6) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_CAB"))+CPLib.Space(6),6);
              /* _note := _note +Left(LRTrim(arfn_agechar(qbe_frap_chkdiana->C_CTA,' '))+Space(30),30) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frap_chkdiana.GetString("C_CTA")," "))+CPLib.Space(30),30);
              /* _note := _note + Left(LRTrim(qbe_frap_chkdiana->C_PRV)+Space(2),2) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_PRV"))+CPLib.Space(2),2);
              /* _note := _note + Left(LRTrim(arfn_agechar(qbe_frap_chkdiana->C_IND,' '))+Space(35),35) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frap_chkdiana.GetString("C_IND")," "))+CPLib.Space(35),35);
              /* _note := _note + Left(LRTrim(qbe_frap_chkdiana->C_CAP)+Space(5),5) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_CAP"))+CPLib.Space(5),5);
              /* _note := _note + Space(63) */
              _note = _note+CPLib.Space(63);
              /* _note := _note + Left(LRTrim(qbe_frap_chkdiana->C_RAPPORTO)+Space(25),25) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
              /* _note := _note + Space(91) */
              _note = _note+CPLib.Space(91);
              /* If w_flgchk='S' */
              if (CPLib.eqr(w_flgchk,"S")) {
                /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                Page_15();
              } else { // Else
                /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
              } // End If
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
              /* ElseIf not(Empty(qbe_frap_chkdiana->CONNESBEN)) */
            } else if ( ! (CPLib.Empty(Cursor_qbe_frap_chkdiana.GetString("CONNESBEN")))) {
              /* _numsto := arfn_chkspers(qbe_frap_chkdiana->CONNESBEN,qbe_frap_chkdiana->DATAREG) */
              _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_frap_chkdiana.GetString("CONNESBEN"),Cursor_qbe_frap_chkdiana.GetDate("DATAREG"));
              /* If Empty(LRTrim(_numsto)) */
              if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_frap_chkdiana.GetString("CONNESBEN"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* _note := w_tipinter + w_codinter+'5' + _idereg */
                  _note = w_tipinter+w_codinter+"5"+_idereg;
                  /* _note := _note + Left(LRTrim(qbe_frap_chkdiana->CONNESBEN)+Space(16),16) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("CONNESBEN"))+CPLib.Space(16),16);
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frap_chkdiana->C_RAG))),Left(LRTrim(arfn_agechar(qbe_frap_chkdiana->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(personbo->RAGSOC,' '))+Space(70),70)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frap_chkdiana.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frap_chkdiana->C_STA))),Left(LRTrim(qbe_frap_chkdiana->C_STA)+Space(3),3),Left(LRTrim(personbo->PAESE)+Space(3),3)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frap_chkdiana->C_CAB))),Left(LRTrim(qbe_frap_chkdiana->C_CAB)+Space(6),6),Left(LRTrim(personbo->CODCAB)+Space(6),6)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frap_chkdiana->C_CTA))),Left(LRTrim(arfn_agechar(qbe_frap_chkdiana->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(personbo->DESCCIT,' '))+Space(30),30)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frap_chkdiana.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frap_chkdiana->C_PRV))),Left(LRTrim(qbe_frap_chkdiana->C_PRV)+Space(2),2),Left(LRTrim(personbo->PROVINCIA)+Space(2),2)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frap_chkdiana->C_IND))),Left(LRTrim(arfn_agechar(qbe_frap_chkdiana->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(personbo->DOMICILIO,' '))+Space(35),35)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frap_chkdiana.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frap_chkdiana->C_CAP))),Left(LRTrim(qbe_frap_chkdiana->C_CAP)+Space(5),5),Left(LRTrim(personbo->CAP)+Space(5),5)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5));
                  /* _note := _note + Space(63) */
                  _note = _note+CPLib.Space(63);
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frap_chkdiana->C_RAPPORTO))),Left(LRTrim(qbe_frap_chkdiana->C_RAPPORTO)+Space(25),25),Left(LRTrim(qbe_frap_chkdiana->RAPPORTBEN)+Space(25),25)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_RAPPORTO"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_RAPPORTO"))+CPLib.Space(25),25):CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("RAPPORTBEN"))+CPLib.Space(25),25));
                  /* _note := _note + Space(91) */
                  _note = _note+CPLib.Space(91);
                  /* If w_flgchk='S' */
                  if (CPLib.eqr(w_flgchk,"S")) {
                    /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                    Page_15();
                  } else { // Else
                    /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                    FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                  } // End If
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } else { // Else
                // * --- Select from wersonbo
                m_cServer = m_Ctx.GetServer("wersonbo");
                m_cPhName = m_Ctx.GetPhName("wersonbo");
                if (Cursor_wersonbo!=null)
                  Cursor_wersonbo.Close();
                Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_wersonbo.Eof())) {
                  /* _note := w_tipinter + w_codinter+'5' + _idereg */
                  _note = w_tipinter+w_codinter+"5"+_idereg;
                  /* _note := _note + Left(LRTrim(qbe_frap_chkdiana->CONNESBEN)+Space(16),16) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("CONNESBEN"))+CPLib.Space(16),16);
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frap_chkdiana->C_RAG))),Left(LRTrim(arfn_agechar(qbe_frap_chkdiana->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(wersonbo->RAGSOC,' '))+Space(70),70)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frap_chkdiana.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frap_chkdiana->C_STA))),Left(LRTrim(qbe_frap_chkdiana->C_STA)+Space(3),3),Left(LRTrim(wersonbo->PAESE)+Space(3),3)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PAESE"))+CPLib.Space(3),3));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frap_chkdiana->C_CAB))),Left(LRTrim(qbe_frap_chkdiana->C_CAB)+Space(6),6),Left(LRTrim(wersonbo->CODCAB)+Space(6),6)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CODCAB"))+CPLib.Space(6),6));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frap_chkdiana->C_CTA))),Left(LRTrim(arfn_agechar(qbe_frap_chkdiana->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(wersonbo->DESCCIT,' '))+Space(30),30)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frap_chkdiana.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frap_chkdiana->C_PRV))),Left(LRTrim(qbe_frap_chkdiana->C_PRV)+Space(2),2),Left(LRTrim(wersonbo->PROVINCIA)+Space(2),2)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frap_chkdiana->C_IND))),Left(LRTrim(arfn_agechar(qbe_frap_chkdiana->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(wersonbo->DOMICILIO,' '))+Space(35),35)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frap_chkdiana.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frap_chkdiana->C_CAP))),Left(LRTrim(qbe_frap_chkdiana->C_CAP)+Space(5),5),Left(LRTrim(wersonbo->CAP)+Space(5),5)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CAP"))+CPLib.Space(5),5));
                  /* _note := _note + Space(63) */
                  _note = _note+CPLib.Space(63);
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frap_chkdiana->C_RAPPORTO))),Left(LRTrim(qbe_frap_chkdiana->C_RAPPORTO)+Space(25),25),Left(LRTrim(qbe_frap_chkdiana->RAPPORTBEN)+Space(25),25)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_RAPPORTO"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_RAPPORTO"))+CPLib.Space(25),25):CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("RAPPORTBEN"))+CPLib.Space(25),25));
                  /* _note := _note + Space(91) */
                  _note = _note+CPLib.Space(91);
                  /* If w_flgchk='S' */
                  if (CPLib.eqr(w_flgchk,"S")) {
                    /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                    Page_15();
                  } else { // Else
                    /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                    FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                  } // End If
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_wersonbo.Next();
                }
                m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                Cursor_wersonbo.Close();
                // * --- End Select
              } // End If
            } // End If
          } // End If
          // * --- Select from xeneficfrz
          m_cServer = m_Ctx.GetServer("xeneficfrz");
          m_cPhName = m_Ctx.GetPhName("xeneficfrz");
          if (Cursor_xeneficfrz!=null)
            Cursor_xeneficfrz.Close();
          Cursor_xeneficfrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_frap_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xeneficfrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_xeneficfrz.Eof())) {
            /* If Empty(LRTrim(xeneficfrz->CODSOG)) and not(Empty(LRTrim(xeneficfrz->C_RAG))) */
            if (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficfrz.GetString("CODSOG"))) &&  ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_RAG"))))) {
              /* _note := w_tipinter + w_codinter+'5' + _idereg */
              _note = w_tipinter+w_codinter+"5"+_idereg;
              /* _note := _note + Left(LRTrim(xeneficfrz->CODSOG)+Space(16),16) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("CODSOG"))+CPLib.Space(16),16);
              /* _note := _note +Left(LRTrim(arfn_agechar(xeneficfrz->C_RAG,' '))+Space(70),70) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_xeneficfrz.GetString("C_RAG")," "))+CPLib.Space(70),70);
              /* _note := _note + Left(LRTrim(xeneficfrz->C_STA)+Space(3),3) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_STA"))+CPLib.Space(3),3);
              /* _note := _note +Left(LRTrim(xeneficfrz->C_CAB)+Space(6),6) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_CAB"))+CPLib.Space(6),6);
              /* _note := _note +Left(LRTrim(arfn_agechar(xeneficfrz->C_CTA,' '))+Space(30),30) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_xeneficfrz.GetString("C_CTA")," "))+CPLib.Space(30),30);
              /* _note := _note + Left(LRTrim(xeneficfrz->C_PRV)+Space(2),2) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_PRV"))+CPLib.Space(2),2);
              /* _note := _note + Left(LRTrim(arfn_agechar(xeneficfrz->C_IND,' '))+Space(35),35) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_xeneficfrz.GetString("C_IND")," "))+CPLib.Space(35),35);
              /* _note := _note + Left(LRTrim(xeneficfrz->C_CAP)+Space(5),5) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_CAP"))+CPLib.Space(5),5);
              /* _note := _note + Space(63) */
              _note = _note+CPLib.Space(63);
              /* _note := _note + Left(LRTrim(xeneficfrz->C_RAPPORTO)+Space(25),25) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
              /* _note := _note + Space(91) */
              _note = _note+CPLib.Space(91);
              /* If w_flgchk='S' */
              if (CPLib.eqr(w_flgchk,"S")) {
                /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                Page_15();
              } else { // Else
                /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
              } // End If
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
            } else { // Else
              /* _numsto := arfn_chkspers(xeneficfrz->CODSOG,qbe_frap_chkdiana->DATAREG) */
              _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_xeneficfrz.GetString("CODSOG"),Cursor_qbe_frap_chkdiana.GetDate("DATAREG"));
              /* If Empty(LRTrim(_numsto)) */
              if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xeneficfrz.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* _note := w_tipinter + w_codinter+'5' + _idereg */
                  _note = w_tipinter+w_codinter+"5"+_idereg;
                  /* _note := _note + Left(LRTrim(xeneficfrz->CODSOG)+Space(16),16) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("CODSOG"))+CPLib.Space(16),16);
                  /* _note := _note + iif(not(Empty(LRTrim(xeneficfrz->C_RAG))),Left(LRTrim(arfn_agechar(xeneficfrz->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(personbo->RAGSOC,' '))+Space(70),70)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_xeneficfrz.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                  /* _note := _note + iif(not(Empty(LRTrim(xeneficfrz->C_STA))),Left(LRTrim(xeneficfrz->C_STA)+Space(3),3),Left(LRTrim(personbo->PAESE)+Space(3),3)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3));
                  /* _note := _note + iif(not(Empty(LRTrim(xeneficfrz->C_CAB))),Left(LRTrim(xeneficfrz->C_CAB)+Space(6),6),Left(LRTrim(personbo->CODCAB)+Space(6),6)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6));
                  /* _note := _note + iif(not(Empty(LRTrim(xeneficfrz->C_CTA))),Left(LRTrim(arfn_agechar(xeneficfrz->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(personbo->DESCCIT,' '))+Space(30),30)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_xeneficfrz.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                  /* _note := _note + iif(not(Empty(LRTrim(xeneficfrz->C_PRV))),Left(LRTrim(xeneficfrz->C_PRV)+Space(2),2),Left(LRTrim(personbo->PROVINCIA)+Space(2),2)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                  /* _note := _note + iif(not(Empty(LRTrim(xeneficfrz->C_IND))),Left(LRTrim(arfn_agechar(xeneficfrz->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(personbo->DOMICILIO,' '))+Space(35),35)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_xeneficfrz.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                  /* _note := _note + iif(not(Empty(LRTrim(xeneficfrz->C_CAP))),Left(LRTrim(xeneficfrz->C_CAP)+Space(5),5),Left(LRTrim(personbo->CAP)+Space(5),5)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5));
                  /* _note := _note + Space(63) */
                  _note = _note+CPLib.Space(63);
                  /* _note := _note +Left(LRTrim(xeneficfrz->C_RAPPORTO)+Space(25),25) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                  /* _note := _note + Space(91) */
                  _note = _note+CPLib.Space(91);
                  /* If w_flgchk='S' */
                  if (CPLib.eqr(w_flgchk,"S")) {
                    /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                    Page_15();
                  } else { // Else
                    /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                    FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                  } // End If
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } else { // Else
                // * --- Select from wersonbo
                m_cServer = m_Ctx.GetServer("wersonbo");
                m_cPhName = m_Ctx.GetPhName("wersonbo");
                if (Cursor_wersonbo!=null)
                  Cursor_wersonbo.Close();
                Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_wersonbo.Eof())) {
                  /* _note := w_tipinter + w_codinter+'5' + _idereg */
                  _note = w_tipinter+w_codinter+"5"+_idereg;
                  /* _note := _note + Left(LRTrim(xeneficfrz->CODSOG)+Space(16),16) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("CODSOG"))+CPLib.Space(16),16);
                  /* _note := _note + iif(not(Empty(LRTrim(xeneficfrz->C_RAG))),Left(LRTrim(arfn_agechar(xeneficfrz->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(wersonbo->RAGSOC,' '))+Space(70),70)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_xeneficfrz.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                  /* _note := _note + iif(not(Empty(LRTrim(xeneficfrz->C_STA))),Left(LRTrim(xeneficfrz->C_STA)+Space(3),3),Left(LRTrim(wersonbo->PAESE)+Space(3),3)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PAESE"))+CPLib.Space(3),3));
                  /* _note := _note + iif(not(Empty(LRTrim(xeneficfrz->C_CAB))),Left(LRTrim(xeneficfrz->C_CAB)+Space(6),6),Left(LRTrim(wersonbo->CODCAB)+Space(6),6)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CODCAB"))+CPLib.Space(6),6));
                  /* _note := _note + iif(not(Empty(LRTrim(xeneficfrz->C_CTA))),Left(LRTrim(arfn_agechar(xeneficfrz->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(wersonbo->DESCCIT,' '))+Space(30),30)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_xeneficfrz.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                  /* _note := _note + iif(not(Empty(LRTrim(xeneficfrz->C_PRV))),Left(LRTrim(xeneficfrz->C_PRV)+Space(2),2),Left(LRTrim(wersonbo->PROVINCIA)+Space(2),2)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                  /* _note := _note + iif(not(Empty(LRTrim(xeneficfrz->C_IND))),Left(LRTrim(arfn_agechar(xeneficfrz->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(wersonbo->DOMICILIO,' '))+Space(35),35)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_xeneficfrz.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                  /* _note := _note + iif(not(Empty(LRTrim(xeneficfrz->C_CAP))),Left(LRTrim(xeneficfrz->C_CAP)+Space(5),5),Left(LRTrim(wersonbo->CAP)+Space(5),5)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CAP"))+CPLib.Space(5),5));
                  /* _note := _note + Space(63) */
                  _note = _note+CPLib.Space(63);
                  /* _note := _note +Left(LRTrim(xeneficfrz->C_RAPPORTO)+Space(25),25) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                  /* _note := _note + Space(91) */
                  _note = _note+CPLib.Space(91);
                  /* If w_flgchk='S' */
                  if (CPLib.eqr(w_flgchk,"S")) {
                    /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                    Page_15();
                  } else { // Else
                    /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                    FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                  } // End If
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_wersonbo.Next();
                }
                m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                Cursor_wersonbo.Close();
                // * --- End Select
              } // End If
            } // End If
            Cursor_xeneficfrz.Next();
          }
          m_cConnectivityError = Cursor_xeneficfrz.ErrorMessage();
          Cursor_xeneficfrz.Close();
          // * --- End Select
          /* If not(Empty(qbe_frap_chkdiana->CONNALTRO)) */
          if ( ! (CPLib.Empty(Cursor_qbe_frap_chkdiana.GetString("CONNALTRO")))) {
            /* _note := w_tipinter + w_codinter+'6' + _idereg */
            _note = w_tipinter+w_codinter+"6"+_idereg;
            /* _note := _note + LRTrim(arfn_datisog_sol(qbe_frap_chkdiana->CONNALTRO,qbe_frap_chkdiana->DATAREG,qbe_frap_chkdiana->RAPPORTO,qbe_frap_chkdiana->FLAGRAP,'6',w_flgrae,qbe_frap_chkdiana->STATOREG,qbe_frap_chkdiana->DATARETT)) */
            _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_frap_chkdiana.GetString("CONNALTRO"),Cursor_qbe_frap_chkdiana.GetDate("DATAREG"),Cursor_qbe_frap_chkdiana.GetString("RAPPORTO"),Cursor_qbe_frap_chkdiana.GetString("FLAGRAP"),"6",w_flgrae,Cursor_qbe_frap_chkdiana.GetString("STATOREG"),Cursor_qbe_frap_chkdiana.GetDate("DATARETT")));
            /* If w_flgchk='S' */
            if (CPLib.eqr(w_flgchk,"S")) {
              /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
              Page_15();
            } else { // Else
              /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
              FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
            } // End If
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
          } // End If
          // * --- Select from xerzistifrz
          m_cServer = m_Ctx.GetServer("xerzistifrz");
          m_cPhName = m_Ctx.GetPhName("xerzistifrz");
          if (Cursor_xerzistifrz!=null)
            Cursor_xerzistifrz.Close();
          Cursor_xerzistifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_frap_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xerzistifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_xerzistifrz.Eof())) {
            /* _note := w_tipinter + w_codinter+'6' + _idereg */
            _note = w_tipinter+w_codinter+"6"+_idereg;
            /* _note := _note + LRTrim(arfn_datisog_sol(xerzistifrz->CODSOG,qbe_frap_chkdiana->DATAREG,qbe_frap_chkdiana->RAPPORTO,qbe_frap_chkdiana->FLAGRAP,'6',w_flgrae,qbe_frap_chkdiana->STATOREG,qbe_frap_chkdiana->DATARETT)) */
            _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_xerzistifrz.GetString("CODSOG"),Cursor_qbe_frap_chkdiana.GetDate("DATAREG"),Cursor_qbe_frap_chkdiana.GetString("RAPPORTO"),Cursor_qbe_frap_chkdiana.GetString("FLAGRAP"),"6",w_flgrae,Cursor_qbe_frap_chkdiana.GetString("STATOREG"),Cursor_qbe_frap_chkdiana.GetDate("DATARETT")));
            /* If w_flgchk='S' */
            if (CPLib.eqr(w_flgchk,"S")) {
              /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
              Page_15();
            } else { // Else
              /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
              FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
            } // End If
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
            Cursor_xerzistifrz.Next();
          }
          m_cConnectivityError = Cursor_xerzistifrz.ErrorMessage();
          Cursor_xerzistifrz.Close();
          // * --- End Select
          /* gNumRec := nTotRec // N� Record DIANA */
          gNumRec = CPLib.Round(nTotRec,0);
          m_Ctx.SetGlobalNumber("gNumRec",gNumRec);
          /* gNumReg := nTotReg // N� Registrazioni DIANA */
          gNumReg = CPLib.Round(nTotReg,0);
          m_Ctx.SetGlobalNumber("gNumReg",gNumReg);
          Cursor_qbe_frap_chkdiana.Next();
        }
        m_cConnectivityError = Cursor_qbe_frap_chkdiana.ErrorMessage();
        Cursor_qbe_frap_chkdiana.Close();
        // * --- End Select
        /* _contacilci := _contacilci+1 */
        _contacilci = CPLib.Round(_contacilci+1,0);
      } // End While
    } finally {
      try {
        if (Cursor_qbe_frap_chkdiana_limits!=null)
          Cursor_qbe_frap_chkdiana_limits.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_frap_chkdiana!=null)
          Cursor_qbe_frap_chkdiana.Close();
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
        if (Cursor_xnarapbo!=null)
          Cursor_xnarapbo.Close();
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
        if (Cursor_anadip!=null)
          Cursor_anadip.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_kersonbo!=null)
          Cursor_kersonbo.Close();
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
        if (Cursor_xntestbo!=null)
          Cursor_xntestbo.Close();
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
        if (Cursor_xlientifrz!=null)
          Cursor_xlientifrz.Close();
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
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
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
        if (Cursor_xerzistifrz!=null)
          Cursor_xerzistifrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_11() throws Exception {
    CPResultSet Cursor_qbe_oped_chkdiana_cli=null;
    CPResultSet Cursor_anarapbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_anadip=null;
    CPResultSet Cursor_kersonbo=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_mlientiope=null;
    CPResultSet Cursor_clientiope=null;
    CPResultSet Cursor_mogopebo=null;
    CPResultSet Cursor_sogopebo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_meneficope=null;
    CPResultSet Cursor_beneficope=null;
    CPResultSet Cursor_merzistiope=null;
    CPResultSet Cursor_terzistiope=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Cicla sulle operazioni di uno specifico cliente */
      /* gMsgImp := 'Verifica Operazioni del cliente da elaborare ...' // Messaggio Import */
      gMsgImp = "Verifica Operazioni del cliente da elaborare ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Select from qbe_oped_chkdiana_cli
      SPBridge.HMCaller _hUTXXJXAFLG;
      _hUTXXJXAFLG = new SPBridge.HMCaller();
      _hUTXXJXAFLG.Set("m_cVQRList",m_cVQRList);
      _hUTXXJXAFLG.Set("cdadata",w_cdadata);
      _hUTXXJXAFLG.Set("c_adata",w_c_adata);
      _hUTXXJXAFLG.Set("codage",w_codage);
      _hUTXXJXAFLG.Set("codcli",w_codcli);
      _hUTXXJXAFLG.Set("ragben",w_ragben);
      if (Cursor_qbe_oped_chkdiana_cli!=null)
        Cursor_qbe_oped_chkdiana_cli.Close();
      Cursor_qbe_oped_chkdiana_cli = new VQRHolder("qbe_oped_chkdiana_cli",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_hUTXXJXAFLG,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_oped_chkdiana_cli.Eof())) {
        /* _ctotale := _ctotale + 1 */
        _ctotale = CPLib.Round(_ctotale+1,0);
        /* gMsgImp := 'Elaborazione Operazione N.: '+LRTrim(Str(_ctotale,15,0)) // Messaggio Import */
        gMsgImp = "Elaborazione Operazione N.: "+CPLib.LRTrim(CPLib.Str(_ctotale,15,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If Empty(LRTrim(qbe_oped_chkdiana_cli->FLAGRAP2)) */
        if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("FLAGRAP2")))) {
          /* _idereg := DateToChar(qbe_oped_chkdiana_cli->DATAOPE) + "O" + Right(qbe_oped_chkdiana_cli->NUMPROG,10) + 'S' */
          _idereg = CPLib.DateToChar(Cursor_qbe_oped_chkdiana_cli.GetDate("DATAOPE"))+"O"+CPLib.Right(Cursor_qbe_oped_chkdiana_cli.GetString("NUMPROG"),10)+"S";
        } else { // Else
          /* _idereg := Left(qbe_oped_chkdiana_cli->IDEREG,8) + "O" + Right(qbe_oped_chkdiana_cli->IDEREG,11) */
          _idereg = CPLib.Left(Cursor_qbe_oped_chkdiana_cli.GetString("IDEREG"),8)+"O"+CPLib.Right(Cursor_qbe_oped_chkdiana_cli.GetString("IDEREG"),11);
        } // End If
        /* _note := w_tipinter + w_codinter + '1' + _idereg */
        _note = w_tipinter+w_codinter+"1"+_idereg;
        /* _flagrap := '' */
        _flagrap = "";
        // * --- Select from anarapbo
        m_cServer = m_Ctx.GetServer("anarapbo");
        m_cPhName = m_Ctx.GetPhName("anarapbo");
        if (Cursor_anarapbo!=null)
          Cursor_anarapbo.Close();
        Cursor_anarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select TIPORAP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana_cli.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("anarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_anarapbo.Eof())) {
          /* _flagrap := anarapbo->TIPORAP */
          _flagrap = Cursor_anarapbo.GetString("TIPORAP");
          Cursor_anarapbo.Next();
        }
        m_cConnectivityError = Cursor_anarapbo.ErrorMessage();
        Cursor_anarapbo.Close();
        // * --- End Select
        /* _flagrap := iif(Empty(LRTrim(_flagrap)),qbe_oped_chkdiana_cli->FLAGRAP,_flagrap) */
        _flagrap = (CPLib.Empty(CPLib.LRTrim(_flagrap))?Cursor_qbe_oped_chkdiana_cli.GetString("FLAGRAP"):_flagrap);
        /* If Empty(qbe_oped_chkdiana_cli->CODDIPE) */
        if (CPLib.Empty(Cursor_qbe_oped_chkdiana_cli.GetString("CODDIPE"))) {
          // * --- Read from intermbo
          m_cServer = m_Ctx.GetServer("intermbo");
          m_cPhName = m_Ctx.GetPhName("intermbo");
          m_cSql = "";
          m_cSql = m_cSql+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codinter,"C",11,0,m_cServer),m_cServer,w_codinter);
          if (m_Ctx.IsSharedTemp("intermbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODCAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODDIPE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            w_codcab = Read_Cursor.GetString("CODCAB");
            w_desccit = Read_Cursor.GetString("DESCCIT");
            w_provin = Read_Cursor.GetString("PROVINCIA");
            w_coddipe = Read_Cursor.GetString("CODDIPE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on intermbo into routine arrt_chkdiana_old returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            w_codcab = "";
            w_desccit = "";
            w_provin = "";
            w_coddipe = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(w_coddipe) */
          if (CPLib.Empty(w_coddipe)) {
            /* _note := _note + '000000' + Left(LRTrim(w_codcab)+Space(6),6) + Left(LRTrim(w_desccit)+Space(30),30) + Left(LRTrim(w_provin)+Space(2),2) */
            _note = _note+"000000"+CPLib.Left(CPLib.LRTrim(w_codcab)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(w_desccit)+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(w_provin)+CPLib.Space(2),2);
          } else { // Else
            /* _note := _note + w_coddipe */
            _note = _note+w_coddipe;
            // * --- Read from anadip
            m_cServer = m_Ctx.GetServer("anadip");
            m_cPhName = m_Ctx.GetPhName("anadip");
            m_cSql = "";
            m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_coddipe,"C",6,0,m_cServer),m_cServer,w_coddipe);
            if (m_Ctx.IsSharedTemp("anadip")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              w_cabcod = Read_Cursor.GetString("CAB");
              w_citdesc = Read_Cursor.GetString("DESCCIT");
              w_provind = Read_Cursor.GetString("PROVINCIA");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on anadip into routine arrt_chkdiana_old returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              w_cabcod = "";
              w_citdesc = "";
              w_provind = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(w_cabcod) */
            if (CPLib.Empty(w_cabcod)) {
              /* _note := _note + Left(LRTrim(w_codcab)+Space(6),6) + Left(LRTrim(w_desccit)+Space(30),30) + Left(LRTrim(w_provin)+Space(2),2) */
              _note = _note+CPLib.Left(CPLib.LRTrim(w_codcab)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(w_desccit)+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(w_provin)+CPLib.Space(2),2);
            } else { // Else
              /* _note := _note + Left(LRTrim(w_cabcod)+Space(6),6) + Left(LRTrim(w_citdesc)+Space(30),30) + Left(LRTrim(w_provind)+Space(2),2) */
              _note = _note+CPLib.Left(CPLib.LRTrim(w_cabcod)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(w_citdesc)+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(w_provind)+CPLib.Space(2),2);
            } // End If
          } // End If
        } else { // Else
          // * --- Select from anadip
          m_cServer = m_Ctx.GetServer("anadip");
          m_cPhName = m_Ctx.GetPhName("anadip");
          if (Cursor_anadip!=null)
            Cursor_anadip.Close();
          Cursor_anadip = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODDIP="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana_cli.GetString("CODDIPE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("anadip")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_anadip.Eof())) {
            /* _note := _note + qbe_oped_chkdiana_cli->CODDIPE + Left(LRTrim(anadip->CAB)+Space(6),6) + Left(LRTrim(anadip->DESCCIT)+Space(30),30) + Left(LRTrim(anadip->PROVINCIA)+Space(2),2) */
            _note = _note+Cursor_qbe_oped_chkdiana_cli.GetString("CODDIPE")+CPLib.Left(CPLib.LRTrim(Cursor_anadip.GetString("CAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_anadip.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_anadip.GetString("PROVINCIA"))+CPLib.Space(2),2);
            Cursor_anadip.Next();
          }
          m_cConnectivityError = Cursor_anadip.ErrorMessage();
          Cursor_anadip.Close();
          // * --- End Select
        } // End If
        /* _note := _note + Left(DateToChar(qbe_oped_chkdiana_cli->DATAOPE)+Space(8),8) + Left(LRTrim(qbe_oped_chkdiana_cli->FLAGFRAZ)+" ",1) + Left(LRTrim(qbe_oped_chkdiana_cli->FLAGCONT)+" ",1) */
        _note = _note+CPLib.Left(CPLib.DateToChar(Cursor_qbe_oped_chkdiana_cli.GetDate("DATAOPE"))+CPLib.Space(8),8)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("FLAGFRAZ"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("FLAGCONT"))+" ",1);
        /* _note := _note + Left(LRTrim(qbe_oped_chkdiana_cli->CODANA)+Space(4),4) + Left(LRTrim(qbe_oped_chkdiana_cli->CODVOC)+Space(2),2) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("CODANA"))+CPLib.Space(4),4)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("CODVOC"))+CPLib.Space(2),2);
        /* _note := _note + Left(LRTrim(qbe_oped_chkdiana_cli->TIPOINT2)+Space(2),2) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("TIPOINT2"))+CPLib.Space(2),2);
        /* _note := _note + iif(Empty(LRTrim(qbe_oped_chkdiana_cli->CODFISCICP)),Left(LRTrim(qbe_oped_chkdiana_cli->CODINT2)+Space(11),11),Left(LRTrim(qbe_oped_chkdiana_cli->CODFISCICP)+Space(11),11)) */
        _note = _note+(CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("CODFISCICP")))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("CODINT2"))+CPLib.Space(11),11):CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("CODFISCICP"))+CPLib.Space(11),11));
        /* _note := _note + Left(LRTrim(qbe_oped_chkdiana_cli->PAESE)+Space(3),3) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("PAESE"))+CPLib.Space(3),3);
        /* _note := _note + Left(LRTrim(qbe_oped_chkdiana_cli->CODCAB2)+Space(6),6) + Left(LRTrim(arfn_agechar(qbe_oped_chkdiana_cli->DESC2,' '))+Space(30),30) + Left(LRTrim(qbe_oped_chkdiana_cli->PROV2)+Space(2),2) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("CODCAB2"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana_cli.GetString("DESC2")," "))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("PROV2"))+CPLib.Space(2),2);
        /* _note := _note + Left(LRTrim(arfn_agechar(qbe_oped_chkdiana_cli->DESCINTER,' '))+Space(50),50) + Left(LRTrim(arfn_agechar(qbe_oped_chkdiana_cli->RAPPORTO,' '))+Space(25),25) + Left(LRTrim(_flagrap)+" ",1) */
        _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana_cli.GetString("DESCINTER")," "))+CPLib.Space(50),50)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana_cli.GetString("RAPPORTO")," "))+CPLib.Space(25),25)+CPLib.Left(CPLib.LRTrim(_flagrap)+" ",1);
        /* _note := _note + Left(LRTrim(qbe_oped_chkdiana_cli->TIPOLEG)+" ",1) + Left(LRTrim(DateToChar(qbe_oped_chkdiana_cli->DATAREG))+Space(8),8) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("TIPOLEG"))+" ",1)+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_oped_chkdiana_cli.GetDate("DATAREG")))+CPLib.Space(8),8);
        /* _note := _note + Left(LRTrim(qbe_oped_chkdiana_cli->TIPOOPRAP)+Space(2),2) + Left(LRTrim(qbe_oped_chkdiana_cli->COLLEG)+Space(11),11) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("TIPOOPRAP"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("COLLEG"))+CPLib.Space(11),11);
        /* _note := _note + " " + Left(LRTrim(qbe_oped_chkdiana_cli->STATOREG)+" ",1)  */
        _note = _note+" "+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("STATOREG"))+" ",1);
        /* If Empty(qbe_oped_chkdiana_cli->DATARETT) or DateToChar(qbe_oped_chkdiana_cli->DATARETT)='01000101' */
        if (CPLib.Empty(Cursor_qbe_oped_chkdiana_cli.GetDate("DATARETT")) || CPLib.eqr(CPLib.DateToChar(Cursor_qbe_oped_chkdiana_cli.GetDate("DATARETT")),"01000101")) {
          /* _note := _note + Space(8) */
          _note = _note+CPLib.Space(8);
        } else { // Else
          /* _note := _note + Left(LRTrim(DateToChar(qbe_oped_chkdiana_cli->DATARETT))+Space(8),8) */
          _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_oped_chkdiana_cli.GetDate("DATARETT")))+CPLib.Space(8),8);
        } // End If
        /* _note := _note + iif(Empty(LRTrim(qbe_oped_chkdiana_cli->OPERAZMOD)),Space(20),Left(qbe_oped_chkdiana_cli->OPERAZMOD,8)+"O"+Right(qbe_oped_chkdiana_cli->OPERAZMOD,11)) */
        _note = _note+(CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("OPERAZMOD")))?CPLib.Space(20):CPLib.Left(Cursor_qbe_oped_chkdiana_cli.GetString("OPERAZMOD"),8)+"O"+CPLib.Right(Cursor_qbe_oped_chkdiana_cli.GetString("OPERAZMOD"),11));
        /* _note := _note + Left(LRTrim(qbe_oped_chkdiana_cli->FLAGLIRE)+" ",1) + Left(LRTrim(qbe_oped_chkdiana_cli->VALUTA)+Space(3),3) + Left(LRTrim(qbe_oped_chkdiana_cli->SEGNO)+" ",1) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("FLAGLIRE"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("VALUTA"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("SEGNO"))+" ",1);
        /* _note := _note +  Right('000000000000000'+LRTrim(Str(qbe_oped_chkdiana_cli->TOTLIRE,15,0)),15) + Right('000000000000000'+LRTrim(Str(qbe_oped_chkdiana_cli->TOTCONT,15,0)),15) + Space(69) */
        _note = _note+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_oped_chkdiana_cli.GetDouble("TOTLIRE"),15,0)),15)+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_oped_chkdiana_cli.GetDouble("TOTCONT"),15,0)),15)+CPLib.Space(69);
        /* If w_flgchk='S' */
        if (CPLib.eqr(w_flgchk,"S")) {
          /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
          Page_15();
        } else { // Else
          /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
          FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
        } // End If
        /* nTotRec := nTotRec + 1 */
        nTotRec = CPLib.Round(nTotRec+1,0);
        /* nTotReg := nTotReg + 1 */
        nTotReg = CPLib.Round(nTotReg+1,0);
        /* nNumRec := nNumRec + 1 */
        nNumRec = CPLib.Round(nNumRec+1,0);
        /* If not(Empty(qbe_oped_chkdiana_cli->CONNESCLI)) and Empty(LRTrim(qbe_oped_chkdiana_cli->RAPPORTO)) */
        if ( ! (CPLib.Empty(Cursor_qbe_oped_chkdiana_cli.GetString("CONNESCLI"))) && CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("RAPPORTO")))) {
          /* _oldrap := '' */
          _oldrap = "";
          /* _codrif := qbe_oped_chkdiana_cli->CONNESCLI */
          _codrif = Cursor_qbe_oped_chkdiana_cli.GetString("CONNESCLI");
          /* If gFlgWU='S' */
          if (CPLib.eqr(gFlgWU,"S")) {
            // * --- Select from kersonbo
            m_cServer = m_Ctx.GetServer("kersonbo");
            m_cPhName = m_Ctx.GetPhName("kersonbo");
            if (Cursor_kersonbo!=null)
              Cursor_kersonbo.Close();
            Cursor_kersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana_cli.GetString("CONNESDOC"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("kersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_kersonbo.Eof())) {
              /* _ramate := iif(w_flgrae='R',LRTrim(kersonbo->RAMOGRUP),Left(LRTrim(kersonbo->ATTIV),3)) */
              _ramate = (CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_kersonbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("ATTIV")),3));
              /* _note := w_tipinter + w_codinter */
              _note = w_tipinter+w_codinter;
              /* If Empty(qbe_oped_chkdiana_cli->CONNESOPER) or (qbe_oped_chkdiana_cli->CONNESOPER=qbe_oped_chkdiana_cli->CONNESCLI) */
              if (CPLib.Empty(Cursor_qbe_oped_chkdiana_cli.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_oped_chkdiana_cli.GetString("CONNESOPER"),Cursor_qbe_oped_chkdiana_cli.GetString("CONNESCLI")))) {
                /* _note := _note + '2' */
                _note = _note+"2";
              } else { // Else
                /* _note := _note + '3' */
                _note = _note+"3";
              } // End If
              /* _note := _note + _idereg */
              _note = _note+_idereg;
              /* _note := _note + Left(LRTrim(qbe_oped_chkdiana_cli->CONNESCLI)+Space(16),16) + Left(LRTrim(kersonbo->RAGSOC)+Space(70),70) + Left(LRTrim(kersonbo->PAESE)+Space(3),3) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("CONNESCLI"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("PAESE"))+CPLib.Space(3),3);
              /* _note := _note + Left(LRTrim(kersonbo->CODCAB)+Space(6),6) + Left(LRTrim(kersonbo->DESCCIT)+Space(30),30) + Left(LRTrim(kersonbo->PROVINCIA)+Space(2),2) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
              /* _note := _note + Left(LRTrim(kersonbo->DOMICILIO)+Space(35),35) + Left(LRTrim(kersonbo->CAP)+ Space(5),5) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("CAP"))+CPLib.Space(5),5);
              /* _note := _note + Left(LRTrim(kersonbo->CODFISC)+Space(16),16)  */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("CODFISC"))+CPLib.Space(16),16);
              /* If Empty(kersonbo->DATANASC) or DateToChar(kersonbo->DATANASC)='01000101' */
              if (CPLib.Empty(Cursor_kersonbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_kersonbo.GetDate("DATANASC")),"01000101")) {
                /* _note := _note + Space(8) */
                _note = _note+CPLib.Space(8);
              } else { // Else
                /* _note := _note + Left(LRTrim(DateToChar(kersonbo->DATANASC))+Space(8),8) */
                _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_kersonbo.GetDate("DATANASC")))+CPLib.Space(8),8);
              } // End If
              /* If not(Empty(kersonbo->NASSTATO)) */
              if ( ! (CPLib.Empty(Cursor_kersonbo.GetString("NASSTATO")))) {
                /* _note := _note + Left(LRTrim(kersonbo->NASSTATO)+Space(30),30) + Left(LRTrim(kersonbo->SOTGRUP)+Space(3),3) + Left(LRTrim(_ramate)+Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(_ramate)+CPLib.Space(3),3);
              } else { // Else
                /* _note := _note + Left(LRTrim(kersonbo->NASCOMUN)+Space(30),30) + Left(LRTrim(kersonbo->SOTGRUP)+Space(3),3) + Left(LRTrim(_ramate) +Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(_ramate)+CPLib.Space(3),3);
              } // End If
              /* _note := _note + Left(LRTrim(kersonbo->SETTSINT)+Space(3),3) + Left(LRTrim(arfn_agechar(qbe_oped_chkdiana_cli->RAPPORTO,' '))+Space(25),25) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana_cli.GetString("RAPPORTO")," "))+CPLib.Space(25),25);
              /* _note := _note + Left(LRTrim(qbe_oped_chkdiana_cli->FLAGRAP)+" ",1) + Left(LRTrim(kersonbo->TIPODOC)+Space(2),2) + Left(LRTrim(kersonbo->NUMDOCUM)+Space(15),15) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
              /* If Empty(kersonbo->DATARILASC) or DateToChar(kersonbo->DATARILASC)='01000101' */
              if (CPLib.Empty(Cursor_kersonbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_kersonbo.GetDate("DATARILASC")),"01000101")) {
                /* _note := _note + Space(8) */
                _note = _note+CPLib.Space(8);
              } else { // Else
                /* _note := _note + Left(LRTrim(DateToChar(kersonbo->DATARILASC))+Space(8),8)  */
                _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_kersonbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
              } // End If
              /* _note := _note + Left(LRTrim(kersonbo->AUTRILASC)+Space(30),30) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("AUTRILASC"))+CPLib.Space(30),30);
              /* _note := _note + Left(LRTrim(kersonbo->SESSO)+" ",1) + Space(34) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SESSO"))+" ",1)+CPLib.Space(34);
              /* If w_flgchk='S' */
              if (CPLib.eqr(w_flgchk,"S")) {
                /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                Page_15();
              } else { // Else
                /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
              } // End If
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
              Cursor_kersonbo.Next();
            }
            m_cConnectivityError = Cursor_kersonbo.ErrorMessage();
            Cursor_kersonbo.Close();
            // * --- End Select
          } else { // Else
            /* _note := w_tipinter + w_codinter */
            _note = w_tipinter+w_codinter;
            /* If Empty(qbe_oped_chkdiana_cli->CONNESOPER) or (qbe_oped_chkdiana_cli->CONNESOPER=qbe_oped_chkdiana_cli->CONNESCLI) */
            if (CPLib.Empty(Cursor_qbe_oped_chkdiana_cli.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_oped_chkdiana_cli.GetString("CONNESOPER"),Cursor_qbe_oped_chkdiana_cli.GetString("CONNESCLI")))) {
              /* _note := _note + '2' */
              _note = _note+"2";
            } else { // Else
              /* _note := _note + '3' */
              _note = _note+"3";
            } // End If
            /* _note := _note + _idereg */
            _note = _note+_idereg;
            /* _note := _note + LRTrim(arfn_datisog_sol(qbe_oped_chkdiana_cli->CONNESCLI,qbe_oped_chkdiana_cli->DATAREG,qbe_oped_chkdiana_cli->RAPPORTO,qbe_oped_chkdiana_cli->FLAGRAP,'2',w_flgrae,qbe_oped_chkdiana_cli->STATOREG,qbe_oped_chkdiana_cli->DATARETT)) */
            _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana_cli.GetString("CONNESCLI"),Cursor_qbe_oped_chkdiana_cli.GetDate("DATAREG"),Cursor_qbe_oped_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana_cli.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_oped_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_oped_chkdiana_cli.GetDate("DATARETT")));
            /* If w_flgchk='S' */
            if (CPLib.eqr(w_flgchk,"S")) {
              /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
              Page_15();
            } else { // Else
              /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
              FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
            } // End If
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
          } // End If
        } else { // Else
          /* _oldrap := '' */
          _oldrap = "";
          // * --- Read from knarapbo
          m_cServer = m_Ctx.GetServer("knarapbo");
          m_cPhName = m_Ctx.GetPhName("knarapbo");
          m_cSql = "";
          m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_oped_chkdiana_cli.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_qbe_oped_chkdiana_cli.GetString("RAPPORTO"));
          if (m_Ctx.IsSharedTemp("knarapbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _oldrap = Read_Cursor.GetString("RAPPORTO");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on knarapbo into routine arrt_chkdiana_old returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _oldrap = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If not(Empty(_oldrap)) */
          if ( ! (CPLib.Empty(_oldrap))) {
            // * --- Select from intestbo
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            if (Cursor_intestbo!=null)
              Cursor_intestbo.Close();
            Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana_cli.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestbo.Eof())) {
              /* If qbe_oped_chkdiana_cli->RAPPORTO = intestbo->RAPPORTO */
              if (CPLib.eqr(Cursor_qbe_oped_chkdiana_cli.GetString("RAPPORTO"),Cursor_intestbo.GetString("RAPPORTO"))) {
                /* _avanza := 0 */
                _avanza = CPLib.Round(0,0);
                /* If Empty(intestbo->CODINTER) or intestbo->STATOREG='2' or intestbo->STATOREG='3' */
                if (CPLib.Empty(Cursor_intestbo.GetString("CODINTER")) || CPLib.eqr(Cursor_intestbo.GetString("STATOREG"),"2") || CPLib.eqr(Cursor_intestbo.GetString("STATOREG"),"3")) {
                  /* _avanza := 1 */
                  _avanza = CPLib.Round(1,0);
                } // End If
                /* If intestbo->DATAINI > qbe_oped_chkdiana_cli->DATAOPE */
                if (CPLib.gt(Cursor_intestbo.GetDate("DATAINI"),Cursor_qbe_oped_chkdiana_cli.GetDate("DATAOPE"))) {
                  /* _avanza := 1 */
                  _avanza = CPLib.Round(1,0);
                } // End If
                /* If not(Empty(intestbo->DATAFINE)) and intestbo->DATAFINE < qbe_oped_chkdiana_cli->DATAOPE */
                if ( ! (CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE"))) && CPLib.lt(Cursor_intestbo.GetDate("DATAFINE"),Cursor_qbe_oped_chkdiana_cli.GetDate("DATAOPE"))) {
                  /* _avanza := 1 */
                  _avanza = CPLib.Round(1,0);
                } // End If
                /* If _avanza = 0 */
                if (CPLib.eqr(_avanza,0)) {
                  /* _codrif := intestbo->CODINTER */
                  _codrif = Cursor_intestbo.GetString("CODINTER");
                  /* _note := w_tipinter + w_codinter */
                  _note = w_tipinter+w_codinter;
                  /* If Empty(qbe_oped_chkdiana_cli->CONNESOPER) or (qbe_oped_chkdiana_cli->CONNESOPER=qbe_oped_chkdiana_cli->CONNESCLI) */
                  if (CPLib.Empty(Cursor_qbe_oped_chkdiana_cli.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_oped_chkdiana_cli.GetString("CONNESOPER"),Cursor_qbe_oped_chkdiana_cli.GetString("CONNESCLI")))) {
                    /* _note := _note + '2' */
                    _note = _note+"2";
                  } else { // Else
                    /* _note := _note + '3' */
                    _note = _note+"3";
                  } // End If
                  /* _note := _note + _idereg */
                  _note = _note+_idereg;
                  /* _note := _note + LRTrim(arfn_datisog_sol(intestbo->CODINTER,qbe_oped_chkdiana_cli->DATAREG,qbe_oped_chkdiana_cli->RAPPORTO,qbe_oped_chkdiana_cli->FLAGRAP,'2',w_flgrae,qbe_oped_chkdiana_cli->STATOREG,qbe_oped_chkdiana_cli->DATARETT)) */
                  _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_intestbo.GetString("CODINTER"),Cursor_qbe_oped_chkdiana_cli.GetDate("DATAREG"),Cursor_qbe_oped_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana_cli.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_oped_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_oped_chkdiana_cli.GetDate("DATARETT")));
                  /* If w_flgchk='S' */
                  if (CPLib.eqr(w_flgchk,"S")) {
                    /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                    Page_15();
                  } else { // Else
                    /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                    FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                  } // End If
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                } // End If
              } // End If
              Cursor_intestbo.Next();
            }
            m_cConnectivityError = Cursor_intestbo.ErrorMessage();
            Cursor_intestbo.Close();
            // * --- End Select
          } else { // Else
            /* If not(Empty(LRTrim(qbe_oped_chkdiana_cli->CONNESCLI))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("CONNESCLI"))))) {
              /* _note := w_tipinter + w_codinter */
              _note = w_tipinter+w_codinter;
              /* If Empty(qbe_oped_chkdiana_cli->CONNESOPER) or (qbe_oped_chkdiana_cli->CONNESOPER=qbe_oped_chkdiana_cli->CONNESCLI) */
              if (CPLib.Empty(Cursor_qbe_oped_chkdiana_cli.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_oped_chkdiana_cli.GetString("CONNESOPER"),Cursor_qbe_oped_chkdiana_cli.GetString("CONNESCLI")))) {
                /* _note := _note + '2' */
                _note = _note+"2";
              } else { // Else
                /* _note := _note + '3' */
                _note = _note+"3";
              } // End If
              /* _note := _note + _idereg */
              _note = _note+_idereg;
              /* _note := _note + LRTrim(arfn_datisog_sol(qbe_oped_chkdiana_cli->CONNESCLI,qbe_oped_chkdiana_cli->DATAREG,qbe_oped_chkdiana_cli->RAPPORTO,qbe_oped_chkdiana_cli->FLAGRAP,'2',w_flgrae,qbe_oped_chkdiana_cli->STATOREG,qbe_oped_chkdiana_cli->DATARETT)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana_cli.GetString("CONNESCLI"),Cursor_qbe_oped_chkdiana_cli.GetDate("DATAREG"),Cursor_qbe_oped_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana_cli.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_oped_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_oped_chkdiana_cli.GetDate("DATARETT")));
              /* If w_flgchk='S' */
              if (CPLib.eqr(w_flgchk,"S")) {
                /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                Page_15();
              } else { // Else
                /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
              } // End If
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
            } // End If
          } // End If
        } // End If
        /* If Empty(LRTrim(_oldrap)) */
        if (CPLib.Empty(CPLib.LRTrim(_oldrap))) {
          /* _oldrighe := 0 */
          _oldrighe = CPLib.Round(0,0);
          /* If qbe_oped_chkdiana_cli->STATOREG='3' */
          if (CPLib.eqr(Cursor_qbe_oped_chkdiana_cli.GetString("STATOREG"),"3")) {
            /* _oldrighe := 0 */
            _oldrighe = CPLib.Round(0,0);
            // * --- Select from mlientiope
            m_cServer = m_Ctx.GetServer("mlientiope");
            m_cPhName = m_Ctx.GetPhName("mlientiope");
            if (Cursor_mlientiope!=null)
              Cursor_mlientiope.Close();
            Cursor_mlientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana_cli.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("mlientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_mlientiope.Eof())) {
              /* _oldrighe := 1 */
              _oldrighe = CPLib.Round(1,0);
              /* _note := w_tipinter + w_codinter */
              _note = w_tipinter+w_codinter;
              /* If Empty(qbe_oped_chkdiana_cli->CONNESOPER) or (qbe_oped_chkdiana_cli->CONNESOPER=mlientiope->CODSOG) */
              if (CPLib.Empty(Cursor_qbe_oped_chkdiana_cli.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_oped_chkdiana_cli.GetString("CONNESOPER"),Cursor_mlientiope.GetString("CODSOG")))) {
                /* _note := _note + '2' */
                _note = _note+"2";
              } else { // Else
                /* _note := _note + '3' */
                _note = _note+"3";
              } // End If
              /* _note := _note + _idereg */
              _note = _note+_idereg;
              /* _note := _note + LRTrim(arfn_datisog_sol(mlientiope->CODSOG,qbe_oped_chkdiana_cli->DATAREG,qbe_oped_chkdiana_cli->RAPPORTO,qbe_oped_chkdiana_cli->FLAGRAP,'2',w_flgrae,qbe_oped_chkdiana_cli->STATOREG,qbe_oped_chkdiana_cli->DATARETT)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_mlientiope.GetString("CODSOG"),Cursor_qbe_oped_chkdiana_cli.GetDate("DATAREG"),Cursor_qbe_oped_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana_cli.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_oped_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_oped_chkdiana_cli.GetDate("DATARETT")));
              /* If w_flgchk='S' */
              if (CPLib.eqr(w_flgchk,"S")) {
                /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                Page_15();
              } else { // Else
                /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
              } // End If
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
              Cursor_mlientiope.Next();
            }
            m_cConnectivityError = Cursor_mlientiope.ErrorMessage();
            Cursor_mlientiope.Close();
            // * --- End Select
          } // End If
          /* If _oldrighe=0 */
          if (CPLib.eqr(_oldrighe,0)) {
            // * --- Select from clientiope
            m_cServer = m_Ctx.GetServer("clientiope");
            m_cPhName = m_Ctx.GetPhName("clientiope");
            if (Cursor_clientiope!=null)
              Cursor_clientiope.Close();
            Cursor_clientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana_cli.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("clientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_clientiope.Eof())) {
              /* _note := w_tipinter + w_codinter */
              _note = w_tipinter+w_codinter;
              /* If Empty(qbe_oped_chkdiana_cli->CONNESOPER) or (qbe_oped_chkdiana_cli->CONNESOPER=clientiope->CODSOG) */
              if (CPLib.Empty(Cursor_qbe_oped_chkdiana_cli.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_oped_chkdiana_cli.GetString("CONNESOPER"),Cursor_clientiope.GetString("CODSOG")))) {
                /* _note := _note + '2' */
                _note = _note+"2";
              } else { // Else
                /* _note := _note + '3' */
                _note = _note+"3";
              } // End If
              /* _note := _note + _idereg */
              _note = _note+_idereg;
              /* _note := _note + LRTrim(arfn_datisog_sol(clientiope->CODSOG,qbe_oped_chkdiana_cli->DATAREG,qbe_oped_chkdiana_cli->RAPPORTO,qbe_oped_chkdiana_cli->FLAGRAP,'2',w_flgrae,qbe_oped_chkdiana_cli->STATOREG,qbe_oped_chkdiana_cli->DATARETT)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_clientiope.GetString("CODSOG"),Cursor_qbe_oped_chkdiana_cli.GetDate("DATAREG"),Cursor_qbe_oped_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana_cli.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_oped_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_oped_chkdiana_cli.GetDate("DATARETT")));
              /* If w_flgchk='S' */
              if (CPLib.eqr(w_flgchk,"S")) {
                /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                Page_15();
              } else { // Else
                /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
              } // End If
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
              Cursor_clientiope.Next();
            }
            m_cConnectivityError = Cursor_clientiope.ErrorMessage();
            Cursor_clientiope.Close();
            // * --- End Select
          } // End If
        } // End If
        /* If not(Empty(qbe_oped_chkdiana_cli->CONNESOPER)) and qbe_oped_chkdiana_cli->CONNESOPER <> _codrif */
        if ( ! (CPLib.Empty(Cursor_qbe_oped_chkdiana_cli.GetString("CONNESOPER"))) && CPLib.ne(Cursor_qbe_oped_chkdiana_cli.GetString("CONNESOPER"),_codrif)) {
          /* _note := w_tipinter + w_codinter+'4' + _idereg */
          _note = w_tipinter+w_codinter+"4"+_idereg;
          /* _note := _note + LRTrim(arfn_datisog_sol(qbe_oped_chkdiana_cli->CONNESOPER,qbe_oped_chkdiana_cli->DATAREG,qbe_oped_chkdiana_cli->RAPPORTO,qbe_oped_chkdiana_cli->FLAGRAP,'4',w_flgrae,qbe_oped_chkdiana_cli->STATOREG,qbe_oped_chkdiana_cli->DATARETT)) */
          _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana_cli.GetString("CONNESOPER"),Cursor_qbe_oped_chkdiana_cli.GetDate("DATAREG"),Cursor_qbe_oped_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana_cli.GetString("FLAGRAP"),"4",w_flgrae,Cursor_qbe_oped_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_oped_chkdiana_cli.GetDate("DATARETT")));
          /* If w_flgchk='S' */
          if (CPLib.eqr(w_flgchk,"S")) {
            /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
            Page_15();
          } else { // Else
            /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
            FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
          } // End If
          /* nTotRec := nTotRec + 1 */
          nTotRec = CPLib.Round(nTotRec+1,0);
          /* nNumRec := nNumRec + 1 */
          nNumRec = CPLib.Round(nNumRec+1,0);
        } // End If
        /* _oldrighe := 0 */
        _oldrighe = CPLib.Round(0,0);
        /* If qbe_oped_chkdiana_cli->STATOREG='3' */
        if (CPLib.eqr(Cursor_qbe_oped_chkdiana_cli.GetString("STATOREG"),"3")) {
          // * --- Select from mogopebo
          m_cServer = m_Ctx.GetServer("mogopebo");
          m_cPhName = m_Ctx.GetPhName("mogopebo");
          if (Cursor_mogopebo!=null)
            Cursor_mogopebo.Close();
          Cursor_mogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana_cli.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("mogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_mogopebo.Eof())) {
            /* _oldrighe := 1 */
            _oldrighe = CPLib.Round(1,0);
            /* _note := w_tipinter + w_codinter+'4' + _idereg */
            _note = w_tipinter+w_codinter+"4"+_idereg;
            /* _note := _note + LRTrim(arfn_datisog_sol(mogopebo->CODSOG,qbe_oped_chkdiana_cli->DATAREG,qbe_oped_chkdiana_cli->RAPPORTO,qbe_oped_chkdiana_cli->FLAGRAP,'4',w_flgrae,qbe_oped_chkdiana_cli->STATOREG,qbe_oped_chkdiana_cli->DATARETT)) */
            _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_mogopebo.GetString("CODSOG"),Cursor_qbe_oped_chkdiana_cli.GetDate("DATAREG"),Cursor_qbe_oped_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana_cli.GetString("FLAGRAP"),"4",w_flgrae,Cursor_qbe_oped_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_oped_chkdiana_cli.GetDate("DATARETT")));
            /* If w_flgchk='S' */
            if (CPLib.eqr(w_flgchk,"S")) {
              /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
              Page_15();
            } else { // Else
              /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
              FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
            } // End If
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
            Cursor_mogopebo.Next();
          }
          m_cConnectivityError = Cursor_mogopebo.ErrorMessage();
          Cursor_mogopebo.Close();
          // * --- End Select
        } // End If
        /* If _oldrighe=0 */
        if (CPLib.eqr(_oldrighe,0)) {
          // * --- Select from sogopebo
          m_cServer = m_Ctx.GetServer("sogopebo");
          m_cPhName = m_Ctx.GetPhName("sogopebo");
          if (Cursor_sogopebo!=null)
            Cursor_sogopebo.Close();
          Cursor_sogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana_cli.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("sogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_sogopebo.Eof())) {
            /* _note := w_tipinter + w_codinter+'4' + _idereg */
            _note = w_tipinter+w_codinter+"4"+_idereg;
            /* _note := _note + LRTrim(arfn_datisog_sol(sogopebo->CODSOG,qbe_oped_chkdiana_cli->DATAREG,qbe_oped_chkdiana_cli->RAPPORTO,qbe_oped_chkdiana_cli->FLAGRAP,'4',w_flgrae,qbe_oped_chkdiana_cli->STATOREG,qbe_oped_chkdiana_cli->DATARETT)) */
            _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_sogopebo.GetString("CODSOG"),Cursor_qbe_oped_chkdiana_cli.GetDate("DATAREG"),Cursor_qbe_oped_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana_cli.GetString("FLAGRAP"),"4",w_flgrae,Cursor_qbe_oped_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_oped_chkdiana_cli.GetDate("DATARETT")));
            /* If w_flgchk='S' */
            if (CPLib.eqr(w_flgchk,"S")) {
              /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
              Page_15();
            } else { // Else
              /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
              FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
            } // End If
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
            Cursor_sogopebo.Next();
          }
          m_cConnectivityError = Cursor_sogopebo.ErrorMessage();
          Cursor_sogopebo.Close();
          // * --- End Select
        } // End If
        /* If not(Empty(qbe_oped_chkdiana_cli->CONNESBEN)) or not(Empty(qbe_oped_chkdiana_cli->C_RAG)) */
        if ( ! (CPLib.Empty(Cursor_qbe_oped_chkdiana_cli.GetString("CONNESBEN"))) ||  ! (CPLib.Empty(Cursor_qbe_oped_chkdiana_cli.GetString("C_RAG")))) {
          /* If not(Empty(qbe_oped_chkdiana_cli->C_RAG)) */
          if ( ! (CPLib.Empty(Cursor_qbe_oped_chkdiana_cli.GetString("C_RAG")))) {
            /* _note := w_tipinter + w_codinter+'5' + _idereg */
            _note = w_tipinter+w_codinter+"5"+_idereg;
            /* _note := _note + Left(LRTrim(qbe_oped_chkdiana_cli->CONNESBEN)+Space(16),16) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("CONNESBEN"))+CPLib.Space(16),16);
            /* _note := _note +Left(LRTrim(arfn_agechar(qbe_oped_chkdiana_cli->C_RAG,' '))+Space(70),70) */
            _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana_cli.GetString("C_RAG")," "))+CPLib.Space(70),70);
            /* _note := _note + Left(LRTrim(qbe_oped_chkdiana_cli->C_STA)+Space(3),3) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("C_STA"))+CPLib.Space(3),3);
            /* _note := _note +Left(LRTrim(qbe_oped_chkdiana_cli->C_CAB)+Space(6),6) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("C_CAB"))+CPLib.Space(6),6);
            /* _note := _note +Left(LRTrim(arfn_agechar(qbe_oped_chkdiana_cli->C_CTA,' '))+Space(30),30) */
            _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana_cli.GetString("C_CTA")," "))+CPLib.Space(30),30);
            /* _note := _note + Left(LRTrim(qbe_oped_chkdiana_cli->C_PRV)+Space(2),2) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("C_PRV"))+CPLib.Space(2),2);
            /* _note := _note + Left(LRTrim(arfn_agechar(qbe_oped_chkdiana_cli->C_IND,' '))+Space(35),35) */
            _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana_cli.GetString("C_IND")," "))+CPLib.Space(35),35);
            /* _note := _note + Left(LRTrim(qbe_oped_chkdiana_cli->C_CAP)+Space(5),5) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("C_CAP"))+CPLib.Space(5),5);
            /* _note := _note + Space(63) */
            _note = _note+CPLib.Space(63);
            /* _note := _note + Left(LRTrim(qbe_oped_chkdiana_cli->C_RAPPORTO)+Space(25),25) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
            /* _note := _note + Space(91) */
            _note = _note+CPLib.Space(91);
            /* If w_flgchk='S' */
            if (CPLib.eqr(w_flgchk,"S")) {
              /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
              Page_15();
            } else { // Else
              /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
              FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
            } // End If
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
            /* ElseIf not(Empty(qbe_oped_chkdiana_cli->CONNESBEN)) */
          } else if ( ! (CPLib.Empty(Cursor_qbe_oped_chkdiana_cli.GetString("CONNESBEN")))) {
            /* _numsto := arfn_chkspers(qbe_oped_chkdiana_cli->CONNESBEN,qbe_oped_chkdiana_cli->DATAREG) */
            _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana_cli.GetString("CONNESBEN"),Cursor_qbe_oped_chkdiana_cli.GetDate("DATAREG"));
            /* If Empty(LRTrim(_numsto)) */
            if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana_cli.GetString("CONNESBEN"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                /* _note := w_tipinter + w_codinter+'5' + _idereg */
                _note = w_tipinter+w_codinter+"5"+_idereg;
                /* _note := _note + Left(LRTrim(qbe_oped_chkdiana_cli->CONNESBEN)+Space(16),16) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("CONNESBEN"))+CPLib.Space(16),16);
                /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana_cli->C_RAG))),Left(LRTrim(arfn_agechar(qbe_oped_chkdiana_cli->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(personbo->RAGSOC,' '))+Space(70),70)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana_cli.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana_cli->C_STA))),Left(LRTrim(qbe_oped_chkdiana_cli->C_STA)+Space(3),3),Left(LRTrim(personbo->PAESE)+Space(3),3)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana_cli->C_CAB))),Left(LRTrim(qbe_oped_chkdiana_cli->C_CAB)+Space(6),6),Left(LRTrim(personbo->CODCAB)+Space(6),6)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana_cli->C_CTA))),Left(LRTrim(arfn_agechar(qbe_oped_chkdiana_cli->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(personbo->DESCCIT,' '))+Space(30),30)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana_cli.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana_cli->C_PRV))),Left(LRTrim(qbe_oped_chkdiana_cli->C_PRV)+Space(2),2),Left(LRTrim(personbo->PROVINCIA)+Space(2),2)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana_cli->C_IND))),Left(LRTrim(arfn_agechar(qbe_oped_chkdiana_cli->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(personbo->DOMICILIO,' '))+Space(35),35)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana_cli.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana_cli->C_CAP))),Left(LRTrim(qbe_oped_chkdiana_cli->C_CAP)+Space(5),5),Left(LRTrim(personbo->CAP)+Space(5),5)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5));
                /* _note := _note + Space(63) */
                _note = _note+CPLib.Space(63);
                /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana_cli->C_RAPPORTO))),Left(LRTrim(qbe_oped_chkdiana_cli->C_RAPPORTO)+Space(25),25),Left(LRTrim(qbe_oped_chkdiana_cli->RAPPORTBEN)+Space(25),25)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("C_RAPPORTO"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("C_RAPPORTO"))+CPLib.Space(25),25):CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("RAPPORTBEN"))+CPLib.Space(25),25));
                /* _note := _note + Space(91) */
                _note = _note+CPLib.Space(91);
                /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
            } else { // Else
              // * --- Select from wersonbo
              m_cServer = m_Ctx.GetServer("wersonbo");
              m_cPhName = m_Ctx.GetPhName("wersonbo");
              if (Cursor_wersonbo!=null)
                Cursor_wersonbo.Close();
              Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_wersonbo.Eof())) {
                /* _note := w_tipinter + w_codinter+'5' + _idereg */
                _note = w_tipinter+w_codinter+"5"+_idereg;
                /* _note := _note + Left(LRTrim(qbe_oped_chkdiana_cli->CONNESBEN)+Space(16),16) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("CONNESBEN"))+CPLib.Space(16),16);
                /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana_cli->C_RAG))),Left(LRTrim(arfn_agechar(qbe_oped_chkdiana_cli->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(wersonbo->RAGSOC,' '))+Space(70),70)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana_cli.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana_cli->C_STA))),Left(LRTrim(qbe_oped_chkdiana_cli->C_STA)+Space(3),3),Left(LRTrim(wersonbo->PAESE)+Space(3),3)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PAESE"))+CPLib.Space(3),3));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana_cli->C_CAB))),Left(LRTrim(qbe_oped_chkdiana_cli->C_CAB)+Space(6),6),Left(LRTrim(wersonbo->CODCAB)+Space(6),6)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CODCAB"))+CPLib.Space(6),6));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana_cli->C_CTA))),Left(LRTrim(arfn_agechar(qbe_oped_chkdiana_cli->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(wersonbo->DESCCIT,' '))+Space(30),30)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana_cli.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana_cli->C_PRV))),Left(LRTrim(qbe_oped_chkdiana_cli->C_PRV)+Space(2),2),Left(LRTrim(wersonbo->PROVINCIA)+Space(2),2)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana_cli->C_IND))),Left(LRTrim(arfn_agechar(qbe_oped_chkdiana_cli->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(wersonbo->DOMICILIO,' '))+Space(35),35)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana_cli.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana_cli->C_CAP))),Left(LRTrim(qbe_oped_chkdiana_cli->C_CAP)+Space(5),5),Left(LRTrim(wersonbo->CAP)+Space(5),5)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CAP"))+CPLib.Space(5),5));
                /* _note := _note + Space(63) */
                _note = _note+CPLib.Space(63);
                /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana_cli->C_RAPPORTO))),Left(LRTrim(qbe_oped_chkdiana_cli->C_RAPPORTO)+Space(25),25),Left(LRTrim(qbe_oped_chkdiana_cli->RAPPORTBEN)+Space(25),25)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("C_RAPPORTO"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("C_RAPPORTO"))+CPLib.Space(25),25):CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli.GetString("RAPPORTBEN"))+CPLib.Space(25),25));
                /* _note := _note + Space(91) */
                _note = _note+CPLib.Space(91);
                /* If w_flgchk='S' */
                if (CPLib.eqr(w_flgchk,"S")) {
                  /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                  Page_15();
                } else { // Else
                  /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                  FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                } // End If
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_wersonbo.Next();
              }
              m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
              Cursor_wersonbo.Close();
              // * --- End Select
            } // End If
          } // End If
        } // End If
        /* _oldrighe := 0 */
        _oldrighe = CPLib.Round(0,0);
        /* If qbe_oped_chkdiana_cli->STATOREG='3' */
        if (CPLib.eqr(Cursor_qbe_oped_chkdiana_cli.GetString("STATOREG"),"3")) {
          // * --- Select from meneficope
          m_cServer = m_Ctx.GetServer("meneficope");
          m_cPhName = m_Ctx.GetPhName("meneficope");
          if (Cursor_meneficope!=null)
            Cursor_meneficope.Close();
          Cursor_meneficope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana_cli.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("meneficope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_meneficope.Eof())) {
            /* _oldrighe := 1 */
            _oldrighe = CPLib.Round(1,0);
            /* If Empty(LRTrim(meneficope->CODSOG)) and not(Empty(LRTrim(meneficope->C_RAG))) */
            if (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("CODSOG"))) &&  ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_RAG"))))) {
              /* _note := w_tipinter + w_codinter+'5' + _idereg */
              _note = w_tipinter+w_codinter+"5"+_idereg;
              /* _note := _note + Left(LRTrim(meneficope->CODSOG)+Space(16),16) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("CODSOG"))+CPLib.Space(16),16);
              /* _note := _note +Left(LRTrim(arfn_agechar(meneficope->C_RAG,' '))+Space(70),70) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficope.GetString("C_RAG")," "))+CPLib.Space(70),70);
              /* _note := _note + Left(LRTrim(meneficope->C_STA)+Space(3),3) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_STA"))+CPLib.Space(3),3);
              /* _note := _note +Left(LRTrim(meneficope->C_CAB)+Space(6),6) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_CAB"))+CPLib.Space(6),6);
              /* _note := _note +Left(LRTrim(arfn_agechar(meneficope->C_CTA,' '))+Space(30),30) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficope.GetString("C_CTA")," "))+CPLib.Space(30),30);
              /* _note := _note + Left(LRTrim(meneficope->C_PRV)+Space(2),2) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_PRV"))+CPLib.Space(2),2);
              /* _note := _note + Left(LRTrim(arfn_agechar(meneficope->C_IND,' '))+Space(35),35) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficope.GetString("C_IND")," "))+CPLib.Space(35),35);
              /* _note := _note + Left(LRTrim(meneficope->C_CAP)+Space(5),5) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_CAP"))+CPLib.Space(5),5);
              /* _note := _note + Space(63) */
              _note = _note+CPLib.Space(63);
              /* _note := _note + Left(LRTrim(meneficope->C_RAPPORTO)+Space(25),25) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
              /* _note := _note + Space(91) */
              _note = _note+CPLib.Space(91);
              /* If w_flgchk='S' */
              if (CPLib.eqr(w_flgchk,"S")) {
                /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                Page_15();
              } else { // Else
                /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
              } // End If
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
            } else { // Else
              /* _numsto := arfn_chkspers(meneficope->CODSOG,qbe_oped_chkdiana_cli->DATAREG) */
              _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_meneficope.GetString("CODSOG"),Cursor_qbe_oped_chkdiana_cli.GetDate("DATAREG"));
              /* If Empty(LRTrim(_numsto)) */
              if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_meneficope.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* _note := w_tipinter + w_codinter+'5' + _idereg */
                  _note = w_tipinter+w_codinter+"5"+_idereg;
                  /* _note := _note + Left(LRTrim(meneficope->CODSOG)+Space(16),16) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("CODSOG"))+CPLib.Space(16),16);
                  /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_RAG))),Left(LRTrim(arfn_agechar(meneficope->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(personbo->RAGSOC,' '))+Space(70),70)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficope.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                  /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_STA))),Left(LRTrim(meneficope->C_STA)+Space(3),3),Left(LRTrim(personbo->PAESE)+Space(3),3)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3));
                  /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_CAB))),Left(LRTrim(meneficope->C_CAB)+Space(6),6),Left(LRTrim(personbo->CODCAB)+Space(6),6)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6));
                  /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_CTA))),Left(LRTrim(arfn_agechar(meneficope->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(personbo->DESCCIT,' '))+Space(30),30)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficope.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                  /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_PRV))),Left(LRTrim(meneficope->C_PRV)+Space(2),2),Left(LRTrim(personbo->PROVINCIA)+Space(2),2)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                  /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_IND))),Left(LRTrim(arfn_agechar(meneficope->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(personbo->DOMICILIO,' '))+Space(35),35)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficope.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                  /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_CAP))),Left(LRTrim(meneficope->C_CAP)+Space(5),5),Left(LRTrim(personbo->CAP)+Space(5),5)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5));
                  /* _note := _note + Space(63) */
                  _note = _note+CPLib.Space(63);
                  /* _note := _note +Left(LRTrim(meneficope->C_RAPPORTO)+Space(25),25) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                  /* _note := _note + Space(91) */
                  _note = _note+CPLib.Space(91);
                  /* If w_flgchk='S' */
                  if (CPLib.eqr(w_flgchk,"S")) {
                    /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                    Page_15();
                  } else { // Else
                    /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                    FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                  } // End If
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } else { // Else
                // * --- Select from wersonbo
                m_cServer = m_Ctx.GetServer("wersonbo");
                m_cPhName = m_Ctx.GetPhName("wersonbo");
                if (Cursor_wersonbo!=null)
                  Cursor_wersonbo.Close();
                Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_wersonbo.Eof())) {
                  /* _note := w_tipinter + w_codinter+'5' + _idereg */
                  _note = w_tipinter+w_codinter+"5"+_idereg;
                  /* _note := _note + Left(LRTrim(meneficope->CODSOG)+Space(16),16) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("CODSOG"))+CPLib.Space(16),16);
                  /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_RAG))),Left(LRTrim(arfn_agechar(meneficope->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(wersonbo->RAGSOC,' '))+Space(70),70)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficope.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                  /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_STA))),Left(LRTrim(meneficope->C_STA)+Space(3),3),Left(LRTrim(wersonbo->PAESE)+Space(3),3)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PAESE"))+CPLib.Space(3),3));
                  /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_CAB))),Left(LRTrim(meneficope->C_CAB)+Space(6),6),Left(LRTrim(wersonbo->CODCAB)+Space(6),6)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CODCAB"))+CPLib.Space(6),6));
                  /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_CTA))),Left(LRTrim(arfn_agechar(meneficope->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(wersonbo->DESCCIT,' '))+Space(30),30)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficope.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                  /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_PRV))),Left(LRTrim(meneficope->C_PRV)+Space(2),2),Left(LRTrim(wersonbo->PROVINCIA)+Space(2),2)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                  /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_IND))),Left(LRTrim(arfn_agechar(meneficope->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(wersonbo->DOMICILIO,' '))+Space(35),35)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficope.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                  /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_CAP))),Left(LRTrim(meneficope->C_CAP)+Space(5),5),Left(LRTrim(wersonbo->CAP)+Space(5),5)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CAP"))+CPLib.Space(5),5));
                  /* _note := _note + Space(63) */
                  _note = _note+CPLib.Space(63);
                  /* _note := _note +Left(LRTrim(meneficope->C_RAPPORTO)+Space(25),25) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                  /* _note := _note + Space(91) */
                  _note = _note+CPLib.Space(91);
                  /* If w_flgchk='S' */
                  if (CPLib.eqr(w_flgchk,"S")) {
                    /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                    Page_15();
                  } else { // Else
                    /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                    FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                  } // End If
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_wersonbo.Next();
                }
                m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                Cursor_wersonbo.Close();
                // * --- End Select
              } // End If
            } // End If
            Cursor_meneficope.Next();
          }
          m_cConnectivityError = Cursor_meneficope.ErrorMessage();
          Cursor_meneficope.Close();
          // * --- End Select
        } // End If
        /* If _oldrighe=0 */
        if (CPLib.eqr(_oldrighe,0)) {
          // * --- Select from beneficope
          m_cServer = m_Ctx.GetServer("beneficope");
          m_cPhName = m_Ctx.GetPhName("beneficope");
          if (Cursor_beneficope!=null)
            Cursor_beneficope.Close();
          Cursor_beneficope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana_cli.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("beneficope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_beneficope.Eof())) {
            /* If Empty(LRTrim(beneficope->CODSOG)) and not(Empty(LRTrim(beneficope->C_RAG))) */
            if (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("CODSOG"))) &&  ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_RAG"))))) {
              /* _note := w_tipinter + w_codinter+'5' + _idereg */
              _note = w_tipinter+w_codinter+"5"+_idereg;
              /* _note := _note + Left(LRTrim(beneficope->CODSOG)+Space(16),16) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("CODSOG"))+CPLib.Space(16),16);
              /* _note := _note +Left(LRTrim(arfn_agechar(beneficope->C_RAG,' '))+Space(70),70) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficope.GetString("C_RAG")," "))+CPLib.Space(70),70);
              /* _note := _note + Left(LRTrim(beneficope->C_STA)+Space(3),3) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_STA"))+CPLib.Space(3),3);
              /* _note := _note +Left(LRTrim(beneficope->C_CAB)+Space(6),6) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAB"))+CPLib.Space(6),6);
              /* _note := _note +Left(LRTrim(arfn_agechar(beneficope->C_CTA,' '))+Space(30),30) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficope.GetString("C_CTA")," "))+CPLib.Space(30),30);
              /* _note := _note + Left(LRTrim(beneficope->C_PRV)+Space(2),2) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_PRV"))+CPLib.Space(2),2);
              /* _note := _note + Left(LRTrim(arfn_agechar(beneficope->C_IND,' '))+Space(35),35) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficope.GetString("C_IND")," "))+CPLib.Space(35),35);
              /* _note := _note + Left(LRTrim(beneficope->C_CAP)+Space(5),5) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAP"))+CPLib.Space(5),5);
              /* _note := _note + Space(63) */
              _note = _note+CPLib.Space(63);
              /* _note := _note + Left(LRTrim(beneficope->C_RAPPORTO)+Space(25),25) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
              /* _note := _note + Space(91) */
              _note = _note+CPLib.Space(91);
              /* If w_flgchk='S' */
              if (CPLib.eqr(w_flgchk,"S")) {
                /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                Page_15();
              } else { // Else
                /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
              } // End If
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
            } else { // Else
              /* _numsto := arfn_chkspers(beneficope->CODSOG,qbe_oped_chkdiana_cli->DATAREG) */
              _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_beneficope.GetString("CODSOG"),Cursor_qbe_oped_chkdiana_cli.GetDate("DATAREG"));
              /* If Empty(LRTrim(_numsto)) */
              if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_beneficope.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* _note := w_tipinter + w_codinter+'5' + _idereg */
                  _note = w_tipinter+w_codinter+"5"+_idereg;
                  /* _note := _note + Left(LRTrim(beneficope->CODSOG)+Space(16),16) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("CODSOG"))+CPLib.Space(16),16);
                  /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_RAG))),Left(LRTrim(arfn_agechar(beneficope->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(personbo->RAGSOC,' '))+Space(70),70)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficope.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                  /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_STA))),Left(LRTrim(beneficope->C_STA)+Space(3),3),Left(LRTrim(personbo->PAESE)+Space(3),3)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3));
                  /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_CAB))),Left(LRTrim(beneficope->C_CAB)+Space(6),6),Left(LRTrim(personbo->CODCAB)+Space(6),6)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6));
                  /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_CTA))),Left(LRTrim(arfn_agechar(beneficope->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(personbo->DESCCIT,' '))+Space(30),30)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficope.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                  /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_PRV))),Left(LRTrim(beneficope->C_PRV)+Space(2),2),Left(LRTrim(personbo->PROVINCIA)+Space(2),2)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                  /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_IND))),Left(LRTrim(arfn_agechar(beneficope->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(personbo->DOMICILIO,' '))+Space(35),35)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficope.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                  /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_CAP))),Left(LRTrim(beneficope->C_CAP)+Space(5),5),Left(LRTrim(personbo->CAP)+Space(5),5)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5));
                  /* _note := _note + Space(63) */
                  _note = _note+CPLib.Space(63);
                  /* _note := _note +Left(LRTrim(beneficope->C_RAPPORTO)+Space(25),25) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                  /* _note := _note + Space(91) */
                  _note = _note+CPLib.Space(91);
                  /* If w_flgchk='S' */
                  if (CPLib.eqr(w_flgchk,"S")) {
                    /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                    Page_15();
                  } else { // Else
                    /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                    FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                  } // End If
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } else { // Else
                // * --- Select from wersonbo
                m_cServer = m_Ctx.GetServer("wersonbo");
                m_cPhName = m_Ctx.GetPhName("wersonbo");
                if (Cursor_wersonbo!=null)
                  Cursor_wersonbo.Close();
                Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_wersonbo.Eof())) {
                  /* _note := w_tipinter + w_codinter+'5' + _idereg */
                  _note = w_tipinter+w_codinter+"5"+_idereg;
                  /* _note := _note + Left(LRTrim(beneficope->CODSOG)+Space(16),16) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("CODSOG"))+CPLib.Space(16),16);
                  /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_RAG))),Left(LRTrim(arfn_agechar(beneficope->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(wersonbo->RAGSOC,' '))+Space(70),70)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficope.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                  /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_STA))),Left(LRTrim(beneficope->C_STA)+Space(3),3),Left(LRTrim(wersonbo->PAESE)+Space(3),3)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PAESE"))+CPLib.Space(3),3));
                  /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_CAB))),Left(LRTrim(beneficope->C_CAB)+Space(6),6),Left(LRTrim(wersonbo->CODCAB)+Space(6),6)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CODCAB"))+CPLib.Space(6),6));
                  /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_CTA))),Left(LRTrim(arfn_agechar(beneficope->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(wersonbo->DESCCIT,' '))+Space(30),30)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficope.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                  /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_PRV))),Left(LRTrim(beneficope->C_PRV)+Space(2),2),Left(LRTrim(wersonbo->PROVINCIA)+Space(2),2)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                  /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_IND))),Left(LRTrim(arfn_agechar(beneficope->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(wersonbo->DOMICILIO,' '))+Space(35),35)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficope.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                  /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_CAP))),Left(LRTrim(beneficope->C_CAP)+Space(5),5),Left(LRTrim(wersonbo->CAP)+Space(5),5)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CAP"))+CPLib.Space(5),5));
                  /* _note := _note + Space(63) */
                  _note = _note+CPLib.Space(63);
                  /* _note := _note +Left(LRTrim(beneficope->C_RAPPORTO)+Space(25),25) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                  /* _note := _note + Space(91) */
                  _note = _note+CPLib.Space(91);
                  /* If w_flgchk='S' */
                  if (CPLib.eqr(w_flgchk,"S")) {
                    /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                    Page_15();
                  } else { // Else
                    /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                    FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                  } // End If
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_wersonbo.Next();
                }
                m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                Cursor_wersonbo.Close();
                // * --- End Select
              } // End If
            } // End If
            Cursor_beneficope.Next();
          }
          m_cConnectivityError = Cursor_beneficope.ErrorMessage();
          Cursor_beneficope.Close();
          // * --- End Select
        } // End If
        /* If not(Empty(qbe_oped_chkdiana_cli->CONNALTRO)) */
        if ( ! (CPLib.Empty(Cursor_qbe_oped_chkdiana_cli.GetString("CONNALTRO")))) {
          /* _note := w_tipinter + w_codinter+'6' + _idereg */
          _note = w_tipinter+w_codinter+"6"+_idereg;
          /* _note := _note + LRTrim(arfn_datisog_sol(qbe_oped_chkdiana_cli->CONNALTRO,qbe_oped_chkdiana_cli->DATAREG,qbe_oped_chkdiana_cli->RAPPORTO,qbe_oped_chkdiana_cli->FLAGRAP,'6',w_flgrae,qbe_oped_chkdiana_cli->STATOREG,qbe_oped_chkdiana_cli->DATARETT)) */
          _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana_cli.GetString("CONNALTRO"),Cursor_qbe_oped_chkdiana_cli.GetDate("DATAREG"),Cursor_qbe_oped_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana_cli.GetString("FLAGRAP"),"6",w_flgrae,Cursor_qbe_oped_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_oped_chkdiana_cli.GetDate("DATARETT")));
          /* If w_flgchk='S' */
          if (CPLib.eqr(w_flgchk,"S")) {
            /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
            Page_15();
          } else { // Else
            /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
            FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
          } // End If
          /* nTotRec := nTotRec + 1 */
          nTotRec = CPLib.Round(nTotRec+1,0);
          /* nNumRec := nNumRec + 1 */
          nNumRec = CPLib.Round(nNumRec+1,0);
        } // End If
        /* _oldrighe := 0 */
        _oldrighe = CPLib.Round(0,0);
        /* If qbe_oped_chkdiana_cli->STATOREG='3' */
        if (CPLib.eqr(Cursor_qbe_oped_chkdiana_cli.GetString("STATOREG"),"3")) {
          // * --- Select from merzistiope
          m_cServer = m_Ctx.GetServer("merzistiope");
          m_cPhName = m_Ctx.GetPhName("merzistiope");
          if (Cursor_merzistiope!=null)
            Cursor_merzistiope.Close();
          Cursor_merzistiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana_cli.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("merzistiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_merzistiope.Eof())) {
            /* _note := w_tipinter + w_codinter+'6' + _idereg */
            _note = w_tipinter+w_codinter+"6"+_idereg;
            /* _note := _note + LRTrim(arfn_datisog_sol(merzistiope->CODSOG,qbe_oped_chkdiana_cli->DATAREG,qbe_oped_chkdiana_cli->RAPPORTO,qbe_oped_chkdiana_cli->FLAGRAP,'6',w_flgrae,qbe_oped_chkdiana_cli->STATOREG,qbe_oped_chkdiana_cli->DATARETT)) */
            _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_merzistiope.GetString("CODSOG"),Cursor_qbe_oped_chkdiana_cli.GetDate("DATAREG"),Cursor_qbe_oped_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana_cli.GetString("FLAGRAP"),"6",w_flgrae,Cursor_qbe_oped_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_oped_chkdiana_cli.GetDate("DATARETT")));
            /* If w_flgchk='S' */
            if (CPLib.eqr(w_flgchk,"S")) {
              /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
              Page_15();
            } else { // Else
              /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
              FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
            } // End If
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
            Cursor_merzistiope.Next();
          }
          m_cConnectivityError = Cursor_merzistiope.ErrorMessage();
          Cursor_merzistiope.Close();
          // * --- End Select
        } // End If
        /* If _oldrighe=0 */
        if (CPLib.eqr(_oldrighe,0)) {
          // * --- Select from terzistiope
          m_cServer = m_Ctx.GetServer("terzistiope");
          m_cPhName = m_Ctx.GetPhName("terzistiope");
          if (Cursor_terzistiope!=null)
            Cursor_terzistiope.Close();
          Cursor_terzistiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana_cli.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("terzistiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_terzistiope.Eof())) {
            /* _note := w_tipinter + w_codinter+'6' + _idereg */
            _note = w_tipinter+w_codinter+"6"+_idereg;
            /* _note := _note + LRTrim(arfn_datisog_sol(terzistiope->CODSOG,qbe_oped_chkdiana_cli->DATAREG,qbe_oped_chkdiana_cli->RAPPORTO,qbe_oped_chkdiana_cli->FLAGRAP,'6',w_flgrae,qbe_oped_chkdiana_cli->STATOREG,qbe_oped_chkdiana_cli->DATARETT)) */
            _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_terzistiope.GetString("CODSOG"),Cursor_qbe_oped_chkdiana_cli.GetDate("DATAREG"),Cursor_qbe_oped_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana_cli.GetString("FLAGRAP"),"6",w_flgrae,Cursor_qbe_oped_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_oped_chkdiana_cli.GetDate("DATARETT")));
            /* If w_flgchk='S' */
            if (CPLib.eqr(w_flgchk,"S")) {
              /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
              Page_15();
            } else { // Else
              /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
              FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
            } // End If
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
            Cursor_terzistiope.Next();
          }
          m_cConnectivityError = Cursor_terzistiope.ErrorMessage();
          Cursor_terzistiope.Close();
          // * --- End Select
        } // End If
        /* gNumRec := nTotRec // N� Record DIANA */
        gNumRec = CPLib.Round(nTotRec,0);
        m_Ctx.SetGlobalNumber("gNumRec",gNumRec);
        /* gNumReg := nTotReg // N� Registrazioni DIANA */
        gNumReg = CPLib.Round(nTotReg,0);
        m_Ctx.SetGlobalNumber("gNumReg",gNumReg);
        Cursor_qbe_oped_chkdiana_cli.Next();
      }
      m_cConnectivityError = Cursor_qbe_oped_chkdiana_cli.ErrorMessage();
      Cursor_qbe_oped_chkdiana_cli.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_oped_chkdiana_cli!=null)
          Cursor_qbe_oped_chkdiana_cli.Close();
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
        if (Read_Cursor!=null)
          Read_Cursor.Close();
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
        if (Cursor_kersonbo!=null)
          Cursor_kersonbo.Close();
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
        if (Cursor_mlientiope!=null)
          Cursor_mlientiope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_clientiope!=null)
          Cursor_clientiope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_mogopebo!=null)
          Cursor_mogopebo.Close();
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
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_meneficope!=null)
          Cursor_meneficope.Close();
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
        if (Cursor_merzistiope!=null)
          Cursor_merzistiope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_terzistiope!=null)
          Cursor_terzistiope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_12() throws Exception {
    CPResultSet Cursor_qbe_opep_chkdiana_cli=null;
    CPResultSet Cursor_anarapbo=null;
    CPResultSet Cursor_xnarapbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_anadip=null;
    CPResultSet Cursor_kersonbo=null;
    CPResultSet Cursor_knarapbo=null;
    CPResultSet Cursor_xntestbo=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_xlientiope=null;
    CPResultSet Cursor_xogopebo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_xeneficope=null;
    CPResultSet Cursor_xerzistiope=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Cicla sulle operazioni provvisorie di uno specifico cliente */
      /* gMsgImp := 'Verifica Operazioni Provvisorie del cliente da elaborare ...' // Messaggio Import */
      gMsgImp = "Verifica Operazioni Provvisorie del cliente da elaborare ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Select from qbe_opep_chkdiana_cli
      SPBridge.HMCaller _hXVFYEDACNA;
      _hXVFYEDACNA = new SPBridge.HMCaller();
      _hXVFYEDACNA.Set("m_cVQRList",m_cVQRList);
      _hXVFYEDACNA.Set("cdadata",w_cdadata);
      _hXVFYEDACNA.Set("c_adata",w_c_adata);
      _hXVFYEDACNA.Set("codage",w_codage);
      _hXVFYEDACNA.Set("codcli",w_codcli);
      _hXVFYEDACNA.Set("ragben",w_ragben);
      if (Cursor_qbe_opep_chkdiana_cli!=null)
        Cursor_qbe_opep_chkdiana_cli.Close();
      Cursor_qbe_opep_chkdiana_cli = new VQRHolder("qbe_opep_chkdiana_cli",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_hXVFYEDACNA,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_opep_chkdiana_cli.Eof())) {
        /* _ctotale := _ctotale + 1 */
        _ctotale = CPLib.Round(_ctotale+1,0);
        /* gMsgImp := 'Elaborazione Operazione N.: '+LRTrim(Str(_ctotale,15,0)) // Messaggio Import */
        gMsgImp = "Elaborazione Operazione N.: "+CPLib.LRTrim(CPLib.Str(_ctotale,15,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If Empty(LRTrim(qbe_opep_chkdiana_cli->FLAGRAP2)) */
        if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("FLAGRAP2")))) {
          /* _idereg := DateToChar(qbe_opep_chkdiana_cli->DATAOPE) + "O" + Right(qbe_opep_chkdiana_cli->NUMPROG,10) + 'S' */
          _idereg = CPLib.DateToChar(Cursor_qbe_opep_chkdiana_cli.GetDate("DATAOPE"))+"O"+CPLib.Right(Cursor_qbe_opep_chkdiana_cli.GetString("NUMPROG"),10)+"S";
        } else { // Else
          /* _idereg := Left(qbe_opep_chkdiana_cli->IDEREG,8) + "O" + Right(qbe_opep_chkdiana_cli->IDEREG,11) */
          _idereg = CPLib.Left(Cursor_qbe_opep_chkdiana_cli.GetString("IDEREG"),8)+"O"+CPLib.Right(Cursor_qbe_opep_chkdiana_cli.GetString("IDEREG"),11);
        } // End If
        /* _note := w_tipinter + w_codinter + '1' + _idereg */
        _note = w_tipinter+w_codinter+"1"+_idereg;
        /* _flagrap := '' */
        _flagrap = "";
        // * --- Select from anarapbo
        m_cServer = m_Ctx.GetServer("anarapbo");
        m_cPhName = m_Ctx.GetPhName("anarapbo");
        if (Cursor_anarapbo!=null)
          Cursor_anarapbo.Close();
        Cursor_anarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select TIPORAP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_opep_chkdiana_cli.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("anarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_anarapbo.Eof())) {
          /* _flagrap := anarapbo->TIPORAP */
          _flagrap = Cursor_anarapbo.GetString("TIPORAP");
          Cursor_anarapbo.Next();
        }
        m_cConnectivityError = Cursor_anarapbo.ErrorMessage();
        Cursor_anarapbo.Close();
        // * --- End Select
        /* If Empty(LRTrim(_flagrap)) */
        if (CPLib.Empty(CPLib.LRTrim(_flagrap))) {
          // * --- Select from xnarapbo
          m_cServer = m_Ctx.GetServer("xnarapbo");
          m_cPhName = m_Ctx.GetPhName("xnarapbo");
          if (Cursor_xnarapbo!=null)
            Cursor_xnarapbo.Close();
          Cursor_xnarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select TIPORAP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_opep_chkdiana_cli.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xnarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_xnarapbo.Eof())) {
            /* _flagrap := xnarapbo->TIPORAP */
            _flagrap = Cursor_xnarapbo.GetString("TIPORAP");
            Cursor_xnarapbo.Next();
          }
          m_cConnectivityError = Cursor_xnarapbo.ErrorMessage();
          Cursor_xnarapbo.Close();
          // * --- End Select
          /* _flagrap := iif(Empty(LRTrim(_flagrap)),qbe_opep_chkdiana_cli->FLAGRAP,_flagrap) */
          _flagrap = (CPLib.Empty(CPLib.LRTrim(_flagrap))?Cursor_qbe_opep_chkdiana_cli.GetString("FLAGRAP"):_flagrap);
        } // End If
        /* If Empty(qbe_opep_chkdiana_cli->CODDIPE) */
        if (CPLib.Empty(Cursor_qbe_opep_chkdiana_cli.GetString("CODDIPE"))) {
          // * --- Read from intermbo
          m_cServer = m_Ctx.GetServer("intermbo");
          m_cPhName = m_Ctx.GetPhName("intermbo");
          m_cSql = "";
          m_cSql = m_cSql+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codinter,"C",11,0,m_cServer),m_cServer,w_codinter);
          if (m_Ctx.IsSharedTemp("intermbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODCAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODDIPE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            w_codcab = Read_Cursor.GetString("CODCAB");
            w_desccit = Read_Cursor.GetString("DESCCIT");
            w_provin = Read_Cursor.GetString("PROVINCIA");
            w_coddipe = Read_Cursor.GetString("CODDIPE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on intermbo into routine arrt_chkdiana_old returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            w_codcab = "";
            w_desccit = "";
            w_provin = "";
            w_coddipe = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(w_coddipe) */
          if (CPLib.Empty(w_coddipe)) {
            /* _note := _note + '000000' + Left(LRTrim(w_codcab)+Space(6),6) + Left(LRTrim(w_desccit)+Space(30),30) + Left(LRTrim(w_provin)+Space(2),2) */
            _note = _note+"000000"+CPLib.Left(CPLib.LRTrim(w_codcab)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(w_desccit)+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(w_provin)+CPLib.Space(2),2);
          } else { // Else
            /* _note := _note + w_coddipe */
            _note = _note+w_coddipe;
            // * --- Read from anadip
            m_cServer = m_Ctx.GetServer("anadip");
            m_cPhName = m_Ctx.GetPhName("anadip");
            m_cSql = "";
            m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_coddipe,"C",6,0,m_cServer),m_cServer,w_coddipe);
            if (m_Ctx.IsSharedTemp("anadip")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              w_cabcod = Read_Cursor.GetString("CAB");
              w_citdesc = Read_Cursor.GetString("DESCCIT");
              w_provind = Read_Cursor.GetString("PROVINCIA");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on anadip into routine arrt_chkdiana_old returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              w_cabcod = "";
              w_citdesc = "";
              w_provind = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(w_cabcod) */
            if (CPLib.Empty(w_cabcod)) {
              /* _note := _note + Left(LRTrim(w_codcab)+Space(6),6) + Left(LRTrim(w_desccit)+Space(30),30) + Left(LRTrim(w_provin)+Space(2),2) */
              _note = _note+CPLib.Left(CPLib.LRTrim(w_codcab)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(w_desccit)+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(w_provin)+CPLib.Space(2),2);
            } else { // Else
              /* _note := _note + Left(LRTrim(w_cabcod)+Space(6),6) + Left(LRTrim(w_citdesc)+Space(30),30) + Left(LRTrim(w_provind)+Space(2),2) */
              _note = _note+CPLib.Left(CPLib.LRTrim(w_cabcod)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(w_citdesc)+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(w_provind)+CPLib.Space(2),2);
            } // End If
          } // End If
        } else { // Else
          // * --- Select from anadip
          m_cServer = m_Ctx.GetServer("anadip");
          m_cPhName = m_Ctx.GetPhName("anadip");
          if (Cursor_anadip!=null)
            Cursor_anadip.Close();
          Cursor_anadip = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODDIP="+CPLib.ToSQL(Cursor_qbe_opep_chkdiana_cli.GetString("CODDIPE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("anadip")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_anadip.Eof())) {
            /* _note := _note + qbe_opep_chkdiana_cli->CODDIPE + Left(LRTrim(anadip->CAB)+Space(6),6) + Left(LRTrim(anadip->DESCCIT)+Space(30),30) + Left(LRTrim(anadip->PROVINCIA)+Space(2),2) */
            _note = _note+Cursor_qbe_opep_chkdiana_cli.GetString("CODDIPE")+CPLib.Left(CPLib.LRTrim(Cursor_anadip.GetString("CAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_anadip.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_anadip.GetString("PROVINCIA"))+CPLib.Space(2),2);
            Cursor_anadip.Next();
          }
          m_cConnectivityError = Cursor_anadip.ErrorMessage();
          Cursor_anadip.Close();
          // * --- End Select
        } // End If
        /* _note := _note + Left(DateToChar(qbe_opep_chkdiana_cli->DATAOPE)+Space(8),8) + Left(LRTrim(qbe_opep_chkdiana_cli->FLAGFRAZ)+" ",1) + Left(LRTrim(qbe_opep_chkdiana_cli->FLAGCONT)+" ",1) */
        _note = _note+CPLib.Left(CPLib.DateToChar(Cursor_qbe_opep_chkdiana_cli.GetDate("DATAOPE"))+CPLib.Space(8),8)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("FLAGFRAZ"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("FLAGCONT"))+" ",1);
        /* _note := _note + Left(LRTrim(qbe_opep_chkdiana_cli->CODANA)+Space(4),4) + Left(LRTrim(qbe_opep_chkdiana_cli->CODVOC)+Space(2),2) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("CODANA"))+CPLib.Space(4),4)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("CODVOC"))+CPLib.Space(2),2);
        /* _note := _note + Left(LRTrim(qbe_opep_chkdiana_cli->TIPOINT2)+Space(2),2) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("TIPOINT2"))+CPLib.Space(2),2);
        /* _note := _note + iif(Empty(LRTrim(qbe_opep_chkdiana_cli->CODFISCICP)),Left(LRTrim(qbe_opep_chkdiana_cli->CODINT2)+Space(11),11),Left(LRTrim(qbe_opep_chkdiana_cli->CODFISCICP)+Space(11),11)) */
        _note = _note+(CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("CODFISCICP")))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("CODINT2"))+CPLib.Space(11),11):CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("CODFISCICP"))+CPLib.Space(11),11));
        /* _note := _note + Left(LRTrim(qbe_opep_chkdiana_cli->PAESE)+Space(3),3) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("PAESE"))+CPLib.Space(3),3);
        /* _note := _note + Left(LRTrim(qbe_opep_chkdiana_cli->CODCAB2)+Space(6),6) + Left(LRTrim(arfn_agechar(qbe_opep_chkdiana_cli->DESC2,' '))+Space(30),30) + Left(LRTrim(qbe_opep_chkdiana_cli->PROV2)+Space(2),2) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("CODCAB2"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_opep_chkdiana_cli.GetString("DESC2")," "))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("PROV2"))+CPLib.Space(2),2);
        /* _note := _note + Left(LRTrim(arfn_agechar(qbe_opep_chkdiana_cli->DESCINTER,' '))+Space(50),50) + Left(LRTrim(arfn_agechar(qbe_opep_chkdiana_cli->RAPPORTO,' '))+Space(25),25) + Left(LRTrim(_flagrap)+" ",1) */
        _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_opep_chkdiana_cli.GetString("DESCINTER")," "))+CPLib.Space(50),50)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_opep_chkdiana_cli.GetString("RAPPORTO")," "))+CPLib.Space(25),25)+CPLib.Left(CPLib.LRTrim(_flagrap)+" ",1);
        /* _note := _note + Left(LRTrim(qbe_opep_chkdiana_cli->TIPOLEG)+" ",1) + Left(LRTrim(DateToChar(qbe_opep_chkdiana_cli->DATAREG))+Space(8),8) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("TIPOLEG"))+" ",1)+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_opep_chkdiana_cli.GetDate("DATAREG")))+CPLib.Space(8),8);
        /* _note := _note + Left(LRTrim(qbe_opep_chkdiana_cli->TIPOOPRAP)+Space(2),2) + Left(LRTrim(qbe_opep_chkdiana_cli->COLLEG)+Space(11),11) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("TIPOOPRAP"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("COLLEG"))+CPLib.Space(11),11);
        /* _note := _note + " " + Left(LRTrim(qbe_opep_chkdiana_cli->STATOREG)+" ",1)  */
        _note = _note+" "+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("STATOREG"))+" ",1);
        /* If Empty(qbe_opep_chkdiana_cli->DATARETT) or DateToChar(qbe_opep_chkdiana_cli->DATARETT)='01000101' */
        if (CPLib.Empty(Cursor_qbe_opep_chkdiana_cli.GetDate("DATARETT")) || CPLib.eqr(CPLib.DateToChar(Cursor_qbe_opep_chkdiana_cli.GetDate("DATARETT")),"01000101")) {
          /* _note := _note + Space(8) */
          _note = _note+CPLib.Space(8);
        } else { // Else
          /* _note := _note + Left(LRTrim(DateToChar(qbe_opep_chkdiana_cli->DATARETT))+Space(8),8) */
          _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_opep_chkdiana_cli.GetDate("DATARETT")))+CPLib.Space(8),8);
        } // End If
        /* _note := _note + iif(Empty(LRTrim(qbe_opep_chkdiana_cli->OPERAZMOD)),Space(20),Left(qbe_opep_chkdiana_cli->OPERAZMOD,8)+"O"+Right(qbe_opep_chkdiana_cli->OPERAZMOD,11)) */
        _note = _note+(CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("OPERAZMOD")))?CPLib.Space(20):CPLib.Left(Cursor_qbe_opep_chkdiana_cli.GetString("OPERAZMOD"),8)+"O"+CPLib.Right(Cursor_qbe_opep_chkdiana_cli.GetString("OPERAZMOD"),11));
        /* _note := _note + Left(LRTrim(qbe_opep_chkdiana_cli->FLAGLIRE)+" ",1) + Left(LRTrim(qbe_opep_chkdiana_cli->VALUTA)+Space(3),3) + Left(LRTrim(qbe_opep_chkdiana_cli->SEGNO)+" ",1) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("FLAGLIRE"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("VALUTA"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("SEGNO"))+" ",1);
        /* _note := _note +  Right('000000000000000'+LRTrim(Str(qbe_opep_chkdiana_cli->TOTLIRE,15,0)),15) + Right('000000000000000'+LRTrim(Str(qbe_opep_chkdiana_cli->TOTCONT,15,0)),15) + Space(69) */
        _note = _note+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_opep_chkdiana_cli.GetDouble("TOTLIRE"),15,0)),15)+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_opep_chkdiana_cli.GetDouble("TOTCONT"),15,0)),15)+CPLib.Space(69);
        /* If w_flgchk='S' */
        if (CPLib.eqr(w_flgchk,"S")) {
          /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
          Page_15();
        } else { // Else
          /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
          FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
        } // End If
        /* nTotRec := nTotRec + 1 */
        nTotRec = CPLib.Round(nTotRec+1,0);
        /* nTotReg := nTotReg + 1 */
        nTotReg = CPLib.Round(nTotReg+1,0);
        /* nNumRec := nNumRec + 1 */
        nNumRec = CPLib.Round(nNumRec+1,0);
        /* If not(Empty(qbe_opep_chkdiana_cli->CONNESCLI)) and Empty(LRTrim(qbe_opep_chkdiana_cli->RAPPORTO)) */
        if ( ! (CPLib.Empty(Cursor_qbe_opep_chkdiana_cli.GetString("CONNESCLI"))) && CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("RAPPORTO")))) {
          /* _oldrap := '' */
          _oldrap = "";
          /* _codrif := qbe_opep_chkdiana_cli->CONNESCLI */
          _codrif = Cursor_qbe_opep_chkdiana_cli.GetString("CONNESCLI");
          /* If gFlgWU='S' */
          if (CPLib.eqr(gFlgWU,"S")) {
            // * --- Select from kersonbo
            m_cServer = m_Ctx.GetServer("kersonbo");
            m_cPhName = m_Ctx.GetPhName("kersonbo");
            if (Cursor_kersonbo!=null)
              Cursor_kersonbo.Close();
            Cursor_kersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_opep_chkdiana_cli.GetString("CONNESDOC"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("kersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_kersonbo.Eof())) {
              /* _ramate := iif(w_flgrae='R',LRTrim(kersonbo->RAMOGRUP),Left(LRTrim(kersonbo->ATTIV),3)) */
              _ramate = (CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_kersonbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("ATTIV")),3));
              /* _note := w_tipinter + w_codinter */
              _note = w_tipinter+w_codinter;
              /* If Empty(qbe_opep_chkdiana_cli->CONNESOPER) or (qbe_opep_chkdiana_cli->CONNESOPER=qbe_opep_chkdiana_cli->CONNESCLI) */
              if (CPLib.Empty(Cursor_qbe_opep_chkdiana_cli.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_opep_chkdiana_cli.GetString("CONNESOPER"),Cursor_qbe_opep_chkdiana_cli.GetString("CONNESCLI")))) {
                /* _note := _note + '2' */
                _note = _note+"2";
              } else { // Else
                /* _note := _note + '3' */
                _note = _note+"3";
              } // End If
              /* _note := _note + _idereg */
              _note = _note+_idereg;
              /* _note := _note + Left(LRTrim(qbe_opep_chkdiana_cli->CONNESCLI)+Space(16),16) + Left(LRTrim(kersonbo->RAGSOC)+Space(70),70) + Left(LRTrim(kersonbo->PAESE)+Space(3),3) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("CONNESCLI"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("PAESE"))+CPLib.Space(3),3);
              /* _note := _note + Left(LRTrim(kersonbo->CODCAB)+Space(6),6) + Left(LRTrim(kersonbo->DESCCIT)+Space(30),30) + Left(LRTrim(kersonbo->PROVINCIA)+Space(2),2) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
              /* _note := _note + Left(LRTrim(kersonbo->DOMICILIO)+Space(35),35) + Left(LRTrim(kersonbo->CAP)+ Space(5),5) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("CAP"))+CPLib.Space(5),5);
              /* _note := _note + Left(LRTrim(kersonbo->CODFISC)+Space(16),16)  */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("CODFISC"))+CPLib.Space(16),16);
              /* If Empty(kersonbo->DATANASC) or DateToChar(kersonbo->DATANASC)='01000101' */
              if (CPLib.Empty(Cursor_kersonbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_kersonbo.GetDate("DATANASC")),"01000101")) {
                /* _note := _note + Space(8) */
                _note = _note+CPLib.Space(8);
              } else { // Else
                /* _note := _note + Left(LRTrim(DateToChar(kersonbo->DATANASC))+Space(8),8) */
                _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_kersonbo.GetDate("DATANASC")))+CPLib.Space(8),8);
              } // End If
              /* If not(Empty(kersonbo->NASSTATO)) */
              if ( ! (CPLib.Empty(Cursor_kersonbo.GetString("NASSTATO")))) {
                /* _note := _note + Left(LRTrim(kersonbo->NASSTATO)+Space(30),30) + Left(LRTrim(kersonbo->SOTGRUP)+Space(3),3) + Left(LRTrim(_ramate)+Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(_ramate)+CPLib.Space(3),3);
              } else { // Else
                /* _note := _note + Left(LRTrim(kersonbo->NASCOMUN)+Space(30),30) + Left(LRTrim(kersonbo->SOTGRUP)+Space(3),3) + Left(LRTrim(_ramate) +Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(_ramate)+CPLib.Space(3),3);
              } // End If
              /* _note := _note + Left(LRTrim(kersonbo->SETTSINT)+Space(3),3) + Left(LRTrim(arfn_agechar(qbe_opep_chkdiana_cli->RAPPORTO,' '))+Space(25),25) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_opep_chkdiana_cli.GetString("RAPPORTO")," "))+CPLib.Space(25),25);
              /* _note := _note + Left(LRTrim(qbe_opep_chkdiana_cli->FLAGRAP)+" ",1) + Left(LRTrim(kersonbo->TIPODOC)+Space(2),2) + Left(LRTrim(kersonbo->NUMDOCUM)+Space(15),15) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
              /* If Empty(kersonbo->DATARILASC) or DateToChar(kersonbo->DATARILASC)='01000101' */
              if (CPLib.Empty(Cursor_kersonbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_kersonbo.GetDate("DATARILASC")),"01000101")) {
                /* _note := _note + Space(8) */
                _note = _note+CPLib.Space(8);
              } else { // Else
                /* _note := _note + Left(LRTrim(DateToChar(kersonbo->DATARILASC))+Space(8),8)  */
                _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_kersonbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
              } // End If
              /* _note := _note + Left(LRTrim(kersonbo->AUTRILASC)+Space(30),30) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("AUTRILASC"))+CPLib.Space(30),30);
              /* _note := _note + Left(LRTrim(kersonbo->SESSO)+" ",1) + Space(34) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SESSO"))+" ",1)+CPLib.Space(34);
              /* If w_flgchk='S' */
              if (CPLib.eqr(w_flgchk,"S")) {
                /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                Page_15();
              } else { // Else
                /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
              } // End If
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
              Cursor_kersonbo.Next();
            }
            m_cConnectivityError = Cursor_kersonbo.ErrorMessage();
            Cursor_kersonbo.Close();
            // * --- End Select
          } else { // Else
            /* _note := w_tipinter + w_codinter */
            _note = w_tipinter+w_codinter;
            /* If Empty(qbe_opep_chkdiana_cli->CONNESOPER) or (qbe_opep_chkdiana_cli->CONNESOPER=qbe_opep_chkdiana_cli->CONNESCLI) */
            if (CPLib.Empty(Cursor_qbe_opep_chkdiana_cli.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_opep_chkdiana_cli.GetString("CONNESOPER"),Cursor_qbe_opep_chkdiana_cli.GetString("CONNESCLI")))) {
              /* _note := _note + '2' */
              _note = _note+"2";
            } else { // Else
              /* _note := _note + '3' */
              _note = _note+"3";
            } // End If
            /* _note := _note + _idereg */
            _note = _note+_idereg;
            /* _note := _note + LRTrim(arfn_datisog_sol(qbe_opep_chkdiana_cli->CONNESCLI,qbe_opep_chkdiana_cli->DATAREG,qbe_opep_chkdiana_cli->RAPPORTO,qbe_opep_chkdiana_cli->FLAGRAP,'2',w_flgrae,qbe_opep_chkdiana_cli->STATOREG,qbe_opep_chkdiana_cli->DATARETT)) */
            _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_opep_chkdiana_cli.GetString("CONNESCLI"),Cursor_qbe_opep_chkdiana_cli.GetDate("DATAREG"),Cursor_qbe_opep_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_opep_chkdiana_cli.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_opep_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_opep_chkdiana_cli.GetDate("DATARETT")));
            /* If w_flgchk='S' */
            if (CPLib.eqr(w_flgchk,"S")) {
              /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
              Page_15();
            } else { // Else
              /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
              FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
            } // End If
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
          } // End If
        } else { // Else
          /* _oldrap := '' */
          _oldrap = "";
          // * --- Read from knarapbo
          m_cServer = m_Ctx.GetServer("knarapbo");
          m_cPhName = m_Ctx.GetPhName("knarapbo");
          m_cSql = "";
          m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_opep_chkdiana_cli.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_qbe_opep_chkdiana_cli.GetString("RAPPORTO"));
          if (m_Ctx.IsSharedTemp("knarapbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _oldrap = Read_Cursor.GetString("RAPPORTO");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on knarapbo into routine arrt_chkdiana_old returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _oldrap = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If not(Empty(_oldrap)) */
          if ( ! (CPLib.Empty(_oldrap))) {
            // * --- Select from knarapbo
            m_cServer = m_Ctx.GetServer("knarapbo");
            m_cPhName = m_Ctx.GetPhName("knarapbo");
            if (Cursor_knarapbo!=null)
              Cursor_knarapbo.Close();
            Cursor_knarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_opep_chkdiana_cli.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("knarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_knarapbo.Eof())) {
              /* If knarapbo->TIPORAP='P' */
              if (CPLib.eqr(Cursor_knarapbo.GetString("TIPORAP"),"P")) {
                // * --- Select from xntestbo
                m_cServer = m_Ctx.GetServer("xntestbo");
                m_cPhName = m_Ctx.GetPhName("xntestbo");
                if (Cursor_xntestbo!=null)
                  Cursor_xntestbo.Close();
                Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_opep_chkdiana_cli.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_xntestbo.Eof())) {
                  /* If qbe_opep_chkdiana_cli->RAPPORTO = xntestbo->RAPPORTO */
                  if (CPLib.eqr(Cursor_qbe_opep_chkdiana_cli.GetString("RAPPORTO"),Cursor_xntestbo.GetString("RAPPORTO"))) {
                    /* _avanza := 0 */
                    _avanza = CPLib.Round(0,0);
                    /* If Empty(xntestbo->CODINTER) or xntestbo->STATOREG='2' or xntestbo->STATOREG='3' */
                    if (CPLib.Empty(Cursor_xntestbo.GetString("CODINTER")) || CPLib.eqr(Cursor_xntestbo.GetString("STATOREG"),"2") || CPLib.eqr(Cursor_xntestbo.GetString("STATOREG"),"3")) {
                      /* _avanza := 1 */
                      _avanza = CPLib.Round(1,0);
                    } // End If
                    /* If xntestbo->DATAINI > qbe_opep_chkdiana_cli->DATAOPE */
                    if (CPLib.gt(Cursor_xntestbo.GetDate("DATAINI"),Cursor_qbe_opep_chkdiana_cli.GetDate("DATAOPE"))) {
                      /* _avanza := 1 */
                      _avanza = CPLib.Round(1,0);
                    } // End If
                    /* If not(Empty(xntestbo->DATAFINE)) and xntestbo->DATAFINE < qbe_opep_chkdiana_cli->DATAOPE */
                    if ( ! (CPLib.Empty(Cursor_xntestbo.GetDate("DATAFINE"))) && CPLib.lt(Cursor_xntestbo.GetDate("DATAFINE"),Cursor_qbe_opep_chkdiana_cli.GetDate("DATAOPE"))) {
                      /* _avanza := 1 */
                      _avanza = CPLib.Round(1,0);
                    } // End If
                    /* If _avanza = 0 */
                    if (CPLib.eqr(_avanza,0)) {
                      /* _codrif := xntestbo->CODINTER */
                      _codrif = Cursor_xntestbo.GetString("CODINTER");
                      /* _note := w_tipinter + w_codinter */
                      _note = w_tipinter+w_codinter;
                      /* If Empty(qbe_opep_chkdiana_cli->CONNESOPER) or (qbe_opep_chkdiana_cli->CONNESOPER=qbe_opep_chkdiana_cli->CONNESCLI) */
                      if (CPLib.Empty(Cursor_qbe_opep_chkdiana_cli.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_opep_chkdiana_cli.GetString("CONNESOPER"),Cursor_qbe_opep_chkdiana_cli.GetString("CONNESCLI")))) {
                        /* _note := _note + '2' */
                        _note = _note+"2";
                      } else { // Else
                        /* _note := _note + '3' */
                        _note = _note+"3";
                      } // End If
                      /* _note := _note + _idereg */
                      _note = _note+_idereg;
                      /* _note := _note + LRTrim(arfn_datisog_sol(xntestbo->CODINTER,qbe_opep_chkdiana_cli->DATAREG,qbe_opep_chkdiana_cli->RAPPORTO,qbe_opep_chkdiana_cli->FLAGRAP,'2',w_flgrae,qbe_opep_chkdiana_cli->STATOREG,qbe_opep_chkdiana_cli->DATARETT)) */
                      _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_xntestbo.GetString("CODINTER"),Cursor_qbe_opep_chkdiana_cli.GetDate("DATAREG"),Cursor_qbe_opep_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_opep_chkdiana_cli.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_opep_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_opep_chkdiana_cli.GetDate("DATARETT")));
                      /* If w_flgchk='S' */
                      if (CPLib.eqr(w_flgchk,"S")) {
                        /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                        Page_15();
                      } else { // Else
                        /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                        FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                      } // End If
                      /* nTotRec := nTotRec + 1 */
                      nTotRec = CPLib.Round(nTotRec+1,0);
                      /* nNumRec := nNumRec + 1 */
                      nNumRec = CPLib.Round(nNumRec+1,0);
                    } // End If
                  } // End If
                  Cursor_xntestbo.Next();
                }
                m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
                Cursor_xntestbo.Close();
                // * --- End Select
              } else { // Else
                // * --- Select from intestbo
                m_cServer = m_Ctx.GetServer("intestbo");
                m_cPhName = m_Ctx.GetPhName("intestbo");
                if (Cursor_intestbo!=null)
                  Cursor_intestbo.Close();
                Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_opep_chkdiana_cli.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_intestbo.Eof())) {
                  /* If qbe_opep_chkdiana_cli->RAPPORTO = intestbo->RAPPORTO */
                  if (CPLib.eqr(Cursor_qbe_opep_chkdiana_cli.GetString("RAPPORTO"),Cursor_intestbo.GetString("RAPPORTO"))) {
                    /* _avanza := 0 */
                    _avanza = CPLib.Round(0,0);
                    /* If Empty(intestbo->CODINTER) or intestbo->STATOREG='2' or intestbo->STATOREG='3' */
                    if (CPLib.Empty(Cursor_intestbo.GetString("CODINTER")) || CPLib.eqr(Cursor_intestbo.GetString("STATOREG"),"2") || CPLib.eqr(Cursor_intestbo.GetString("STATOREG"),"3")) {
                      /* _avanza := 1 */
                      _avanza = CPLib.Round(1,0);
                    } // End If
                    /* If intestbo->DATAINI > qbe_opep_chkdiana_cli->DATAOPE */
                    if (CPLib.gt(Cursor_intestbo.GetDate("DATAINI"),Cursor_qbe_opep_chkdiana_cli.GetDate("DATAOPE"))) {
                      /* _avanza := 1 */
                      _avanza = CPLib.Round(1,0);
                    } // End If
                    /* If not(Empty(intestbo->DATAFINE)) and intestbo->DATAFINE < qbe_opep_chkdiana_cli->DATAOPE */
                    if ( ! (CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE"))) && CPLib.lt(Cursor_intestbo.GetDate("DATAFINE"),Cursor_qbe_opep_chkdiana_cli.GetDate("DATAOPE"))) {
                      /* _avanza := 1 */
                      _avanza = CPLib.Round(1,0);
                    } // End If
                    /* If _avanza = 0 */
                    if (CPLib.eqr(_avanza,0)) {
                      /* _codrif := intestbo->CODINTER */
                      _codrif = Cursor_intestbo.GetString("CODINTER");
                      /* _note := w_tipinter + w_codinter */
                      _note = w_tipinter+w_codinter;
                      /* If Empty(qbe_opep_chkdiana_cli->CONNESOPER) or (qbe_opep_chkdiana_cli->CONNESOPER=qbe_opep_chkdiana_cli->CONNESCLI) */
                      if (CPLib.Empty(Cursor_qbe_opep_chkdiana_cli.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_opep_chkdiana_cli.GetString("CONNESOPER"),Cursor_qbe_opep_chkdiana_cli.GetString("CONNESCLI")))) {
                        /* _note := _note + '2' */
                        _note = _note+"2";
                      } else { // Else
                        /* _note := _note + '3' */
                        _note = _note+"3";
                      } // End If
                      /* _note := _note + _idereg */
                      _note = _note+_idereg;
                      /* _note := _note + LRTrim(arfn_datisog_sol(intestbo->CODINTER,qbe_opep_chkdiana_cli->DATAREG,qbe_opep_chkdiana_cli->RAPPORTO,qbe_opep_chkdiana_cli->FLAGRAP,'2',w_flgrae,qbe_opep_chkdiana_cli->STATOREG,qbe_opep_chkdiana_cli->DATARETT)) */
                      _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_intestbo.GetString("CODINTER"),Cursor_qbe_opep_chkdiana_cli.GetDate("DATAREG"),Cursor_qbe_opep_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_opep_chkdiana_cli.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_opep_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_opep_chkdiana_cli.GetDate("DATARETT")));
                      /* If w_flgchk='S' */
                      if (CPLib.eqr(w_flgchk,"S")) {
                        /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                        Page_15();
                      } else { // Else
                        /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                        FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                      } // End If
                      /* nTotRec := nTotRec + 1 */
                      nTotRec = CPLib.Round(nTotRec+1,0);
                      /* nNumRec := nNumRec + 1 */
                      nNumRec = CPLib.Round(nNumRec+1,0);
                    } // End If
                  } // End If
                  Cursor_intestbo.Next();
                }
                m_cConnectivityError = Cursor_intestbo.ErrorMessage();
                Cursor_intestbo.Close();
                // * --- End Select
              } // End If
              Cursor_knarapbo.Next();
            }
            m_cConnectivityError = Cursor_knarapbo.ErrorMessage();
            Cursor_knarapbo.Close();
            // * --- End Select
          } else { // Else
            /* If not(Empty(LRTrim(qbe_opep_chkdiana_cli->CONNESCLI))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("CONNESCLI"))))) {
              /* _note := w_tipinter + w_codinter */
              _note = w_tipinter+w_codinter;
              /* If Empty(qbe_opep_chkdiana_cli->CONNESOPER) or (qbe_opep_chkdiana_cli->CONNESOPER=qbe_opep_chkdiana_cli->CONNESCLI) */
              if (CPLib.Empty(Cursor_qbe_opep_chkdiana_cli.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_opep_chkdiana_cli.GetString("CONNESOPER"),Cursor_qbe_opep_chkdiana_cli.GetString("CONNESCLI")))) {
                /* _note := _note + '2' */
                _note = _note+"2";
              } else { // Else
                /* _note := _note + '3' */
                _note = _note+"3";
              } // End If
              /* _note := _note + _idereg */
              _note = _note+_idereg;
              /* _note := _note + LRTrim(arfn_datisog_sol(qbe_opep_chkdiana_cli->CONNESCLI,qbe_opep_chkdiana_cli->DATAREG,qbe_opep_chkdiana_cli->RAPPORTO,qbe_opep_chkdiana_cli->FLAGRAP,'2',w_flgrae,qbe_opep_chkdiana_cli->STATOREG,qbe_opep_chkdiana_cli->DATARETT)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_opep_chkdiana_cli.GetString("CONNESCLI"),Cursor_qbe_opep_chkdiana_cli.GetDate("DATAREG"),Cursor_qbe_opep_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_opep_chkdiana_cli.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_opep_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_opep_chkdiana_cli.GetDate("DATARETT")));
              /* If w_flgchk='S' */
              if (CPLib.eqr(w_flgchk,"S")) {
                /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                Page_15();
              } else { // Else
                /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
              } // End If
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
            } // End If
          } // End If
        } // End If
        /* If Empty(LRTrim(_oldrap)) */
        if (CPLib.Empty(CPLib.LRTrim(_oldrap))) {
          /* _oldrighe := 0 */
          _oldrighe = CPLib.Round(0,0);
          // * --- Select from xlientiope
          m_cServer = m_Ctx.GetServer("xlientiope");
          m_cPhName = m_Ctx.GetPhName("xlientiope");
          if (Cursor_xlientiope!=null)
            Cursor_xlientiope.Close();
          Cursor_xlientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_opep_chkdiana_cli.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xlientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_xlientiope.Eof())) {
            /* _note := w_tipinter + w_codinter */
            _note = w_tipinter+w_codinter;
            /* If Empty(qbe_opep_chkdiana_cli->CONNESOPER) or (qbe_opep_chkdiana_cli->CONNESOPER=xlientiope->CODSOG) */
            if (CPLib.Empty(Cursor_qbe_opep_chkdiana_cli.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_opep_chkdiana_cli.GetString("CONNESOPER"),Cursor_xlientiope.GetString("CODSOG")))) {
              /* _note := _note + '2' */
              _note = _note+"2";
            } else { // Else
              /* _note := _note + '3' */
              _note = _note+"3";
            } // End If
            /* If Empty(LRTrim(qbe_opep_chkdiana_cli->FLAGRAP2)) */
            if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("FLAGRAP2")))) {
              /* _note := _note + DateToChar(qbe_opep_chkdiana_cli->DATAOPE) + qbe_opep_chkdiana_cli->NUMPROG + 'S' */
              _note = _note+CPLib.DateToChar(Cursor_qbe_opep_chkdiana_cli.GetDate("DATAOPE"))+Cursor_qbe_opep_chkdiana_cli.GetString("NUMPROG")+"S";
            } else { // Else
              /* _note := _note + qbe_opep_chkdiana_cli->IDEREG */
              _note = _note+Cursor_qbe_opep_chkdiana_cli.GetString("IDEREG");
            } // End If
            /* _note := _note + LRTrim(arfn_datisog_sol(xlientiope->CODSOG,qbe_opep_chkdiana_cli->DATAREG,qbe_opep_chkdiana_cli->RAPPORTO,qbe_opep_chkdiana_cli->FLAGRAP,'2',w_flgrae,qbe_opep_chkdiana_cli->STATOREG,qbe_opep_chkdiana_cli->DATARETT)) */
            _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_xlientiope.GetString("CODSOG"),Cursor_qbe_opep_chkdiana_cli.GetDate("DATAREG"),Cursor_qbe_opep_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_opep_chkdiana_cli.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_opep_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_opep_chkdiana_cli.GetDate("DATARETT")));
            /* If w_flgchk='S' */
            if (CPLib.eqr(w_flgchk,"S")) {
              /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
              Page_15();
            } else { // Else
              /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
              FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
            } // End If
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
            Cursor_xlientiope.Next();
          }
          m_cConnectivityError = Cursor_xlientiope.ErrorMessage();
          Cursor_xlientiope.Close();
          // * --- End Select
        } // End If
        /* If not(Empty(qbe_opep_chkdiana_cli->CONNESOPER)) and qbe_opep_chkdiana_cli->CONNESOPER <> _codrif */
        if ( ! (CPLib.Empty(Cursor_qbe_opep_chkdiana_cli.GetString("CONNESOPER"))) && CPLib.ne(Cursor_qbe_opep_chkdiana_cli.GetString("CONNESOPER"),_codrif)) {
          /* _note := w_tipinter + w_codinter+'4'+_idereg */
          _note = w_tipinter+w_codinter+"4"+_idereg;
          /* _note := _note + LRTrim(arfn_datisog_sol(qbe_opep_chkdiana_cli->CONNESOPER,qbe_opep_chkdiana_cli->DATAREG,qbe_opep_chkdiana_cli->RAPPORTO,qbe_opep_chkdiana_cli->FLAGRAP,'4',w_flgrae,qbe_opep_chkdiana_cli->STATOREG,qbe_opep_chkdiana_cli->DATARETT)) */
          _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_opep_chkdiana_cli.GetString("CONNESOPER"),Cursor_qbe_opep_chkdiana_cli.GetDate("DATAREG"),Cursor_qbe_opep_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_opep_chkdiana_cli.GetString("FLAGRAP"),"4",w_flgrae,Cursor_qbe_opep_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_opep_chkdiana_cli.GetDate("DATARETT")));
          /* If w_flgchk='S' */
          if (CPLib.eqr(w_flgchk,"S")) {
            /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
            Page_15();
          } else { // Else
            /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
            FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
          } // End If
          /* nTotRec := nTotRec + 1 */
          nTotRec = CPLib.Round(nTotRec+1,0);
          /* nNumRec := nNumRec + 1 */
          nNumRec = CPLib.Round(nNumRec+1,0);
        } // End If
        // * --- Select from xogopebo
        m_cServer = m_Ctx.GetServer("xogopebo");
        m_cPhName = m_Ctx.GetPhName("xogopebo");
        if (Cursor_xogopebo!=null)
          Cursor_xogopebo.Close();
        Cursor_xogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_opep_chkdiana_cli.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xogopebo.Eof())) {
          /* _note := w_tipinter + w_codinter+'4'+_idereg */
          _note = w_tipinter+w_codinter+"4"+_idereg;
          /* _note := _note + LRTrim(arfn_datisog_sol(xogopebo->CODSOG,qbe_opep_chkdiana_cli->DATAREG,qbe_opep_chkdiana_cli->RAPPORTO,qbe_opep_chkdiana_cli->FLAGRAP,'4',w_flgrae,qbe_opep_chkdiana_cli->STATOREG,qbe_opep_chkdiana_cli->DATARETT)) */
          _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_xogopebo.GetString("CODSOG"),Cursor_qbe_opep_chkdiana_cli.GetDate("DATAREG"),Cursor_qbe_opep_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_opep_chkdiana_cli.GetString("FLAGRAP"),"4",w_flgrae,Cursor_qbe_opep_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_opep_chkdiana_cli.GetDate("DATARETT")));
          /* If w_flgchk='S' */
          if (CPLib.eqr(w_flgchk,"S")) {
            /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
            Page_15();
          } else { // Else
            /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
            FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
          } // End If
          /* nTotRec := nTotRec + 1 */
          nTotRec = CPLib.Round(nTotRec+1,0);
          /* nNumRec := nNumRec + 1 */
          nNumRec = CPLib.Round(nNumRec+1,0);
          Cursor_xogopebo.Next();
        }
        m_cConnectivityError = Cursor_xogopebo.ErrorMessage();
        Cursor_xogopebo.Close();
        // * --- End Select
        /* If not(Empty(qbe_opep_chkdiana_cli->CONNESBEN)) or not(Empty(qbe_opep_chkdiana_cli->C_RAG)) */
        if ( ! (CPLib.Empty(Cursor_qbe_opep_chkdiana_cli.GetString("CONNESBEN"))) ||  ! (CPLib.Empty(Cursor_qbe_opep_chkdiana_cli.GetString("C_RAG")))) {
          /* If not(Empty(qbe_opep_chkdiana_cli->C_RAG)) */
          if ( ! (CPLib.Empty(Cursor_qbe_opep_chkdiana_cli.GetString("C_RAG")))) {
            /* _note := w_tipinter + w_codinter+'5' + _idereg */
            _note = w_tipinter+w_codinter+"5"+_idereg;
            /* _note := _note + Left(LRTrim(qbe_opep_chkdiana_cli->CONNESBEN)+Space(16),16) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("CONNESBEN"))+CPLib.Space(16),16);
            /* _note := _note +Left(LRTrim(arfn_agechar(qbe_opep_chkdiana_cli->C_RAG,' '))+Space(70),70) */
            _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_opep_chkdiana_cli.GetString("C_RAG")," "))+CPLib.Space(70),70);
            /* _note := _note + Left(LRTrim(qbe_opep_chkdiana_cli->C_STA)+Space(3),3) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("C_STA"))+CPLib.Space(3),3);
            /* _note := _note +Left(LRTrim(qbe_opep_chkdiana_cli->C_CAB)+Space(6),6) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("C_CAB"))+CPLib.Space(6),6);
            /* _note := _note +Left(LRTrim(arfn_agechar(qbe_opep_chkdiana_cli->C_CTA,' '))+Space(30),30) */
            _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_opep_chkdiana_cli.GetString("C_CTA")," "))+CPLib.Space(30),30);
            /* _note := _note + Left(LRTrim(qbe_opep_chkdiana_cli->C_PRV)+Space(2),2) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("C_PRV"))+CPLib.Space(2),2);
            /* _note := _note + Left(LRTrim(arfn_agechar(qbe_opep_chkdiana_cli->C_IND,' '))+Space(35),35) */
            _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_opep_chkdiana_cli.GetString("C_IND")," "))+CPLib.Space(35),35);
            /* _note := _note + Left(LRTrim(qbe_opep_chkdiana_cli->C_CAP)+Space(5),5) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("C_CAP"))+CPLib.Space(5),5);
            /* _note := _note + Space(63) */
            _note = _note+CPLib.Space(63);
            /* _note := _note + Left(LRTrim(qbe_opep_chkdiana_cli->C_RAPPORTO)+Space(25),25) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
            /* _note := _note + Space(91) */
            _note = _note+CPLib.Space(91);
            /* If w_flgchk='S' */
            if (CPLib.eqr(w_flgchk,"S")) {
              /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
              Page_15();
            } else { // Else
              /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
              FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
            } // End If
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
            /* ElseIf not(Empty(qbe_opep_chkdiana_cli->CONNESBEN)) */
          } else if ( ! (CPLib.Empty(Cursor_qbe_opep_chkdiana_cli.GetString("CONNESBEN")))) {
            /* _numsto := arfn_chkspers(qbe_opep_chkdiana_cli->CONNESBEN,qbe_opep_chkdiana_cli->DATAREG) */
            _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_opep_chkdiana_cli.GetString("CONNESBEN"),Cursor_qbe_opep_chkdiana_cli.GetDate("DATAREG"));
            /* If Empty(LRTrim(_numsto)) */
            if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_opep_chkdiana_cli.GetString("CONNESBEN"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                /* _note := w_tipinter + w_codinter+'5' + _idereg */
                _note = w_tipinter+w_codinter+"5"+_idereg;
                /* _note := _note + Left(LRTrim(qbe_opep_chkdiana_cli->CONNESBEN)+Space(16),16) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("CONNESBEN"))+CPLib.Space(16),16);
                /* _note := _note + iif(not(Empty(LRTrim(qbe_opep_chkdiana_cli->C_RAG))),Left(LRTrim(arfn_agechar(qbe_opep_chkdiana_cli->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(personbo->RAGSOC,' '))+Space(70),70)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_opep_chkdiana_cli.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_opep_chkdiana_cli->C_STA))),Left(LRTrim(qbe_opep_chkdiana_cli->C_STA)+Space(3),3),Left(LRTrim(personbo->PAESE)+Space(3),3)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_opep_chkdiana_cli->C_CAB))),Left(LRTrim(qbe_opep_chkdiana_cli->C_CAB)+Space(6),6),Left(LRTrim(personbo->CODCAB)+Space(6),6)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_opep_chkdiana_cli->C_CTA))),Left(LRTrim(arfn_agechar(qbe_opep_chkdiana_cli->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(personbo->DESCCIT,' '))+Space(30),30)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_opep_chkdiana_cli.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_opep_chkdiana_cli->C_PRV))),Left(LRTrim(qbe_opep_chkdiana_cli->C_PRV)+Space(2),2),Left(LRTrim(personbo->PROVINCIA)+Space(2),2)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_opep_chkdiana_cli->C_IND))),Left(LRTrim(arfn_agechar(qbe_opep_chkdiana_cli->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(personbo->DOMICILIO,' '))+Space(35),35)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_opep_chkdiana_cli.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_opep_chkdiana_cli->C_CAP))),Left(LRTrim(qbe_opep_chkdiana_cli->C_CAP)+Space(5),5),Left(LRTrim(personbo->CAP)+Space(5),5)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5));
                /* _note := _note + Space(63) */
                _note = _note+CPLib.Space(63);
                /* _note := _note + iif(not(Empty(LRTrim(qbe_opep_chkdiana_cli->C_RAPPORTO))),Left(LRTrim(qbe_opep_chkdiana_cli->C_RAPPORTO)+Space(25),25),Left(LRTrim(qbe_opep_chkdiana_cli->RAPPORTBEN)+Space(25),25)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("C_RAPPORTO"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("C_RAPPORTO"))+CPLib.Space(25),25):CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("RAPPORTBEN"))+CPLib.Space(25),25));
                /* _note := _note + Space(91) */
                _note = _note+CPLib.Space(91);
                /* If w_flgchk='S' */
                if (CPLib.eqr(w_flgchk,"S")) {
                  /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                  Page_15();
                } else { // Else
                  /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                  FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                } // End If
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
            } else { // Else
              // * --- Select from wersonbo
              m_cServer = m_Ctx.GetServer("wersonbo");
              m_cPhName = m_Ctx.GetPhName("wersonbo");
              if (Cursor_wersonbo!=null)
                Cursor_wersonbo.Close();
              Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_wersonbo.Eof())) {
                /* _note := w_tipinter + w_codinter+'5' + _idereg */
                _note = w_tipinter+w_codinter+"5"+_idereg;
                /* _note := _note + Left(LRTrim(qbe_opep_chkdiana_cli->CONNESBEN)+Space(16),16) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("CONNESBEN"))+CPLib.Space(16),16);
                /* _note := _note + iif(not(Empty(LRTrim(qbe_opep_chkdiana_cli->C_RAG))),Left(LRTrim(arfn_agechar(qbe_opep_chkdiana_cli->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(wersonbo->RAGSOC,' '))+Space(70),70)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_opep_chkdiana_cli.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_opep_chkdiana_cli->C_STA))),Left(LRTrim(qbe_opep_chkdiana_cli->C_STA)+Space(3),3),Left(LRTrim(wersonbo->PAESE)+Space(3),3)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PAESE"))+CPLib.Space(3),3));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_opep_chkdiana_cli->C_CAB))),Left(LRTrim(qbe_opep_chkdiana_cli->C_CAB)+Space(6),6),Left(LRTrim(wersonbo->CODCAB)+Space(6),6)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CODCAB"))+CPLib.Space(6),6));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_opep_chkdiana_cli->C_CTA))),Left(LRTrim(arfn_agechar(qbe_opep_chkdiana_cli->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(wersonbo->DESCCIT,' '))+Space(30),30)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_opep_chkdiana_cli.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_opep_chkdiana_cli->C_PRV))),Left(LRTrim(qbe_opep_chkdiana_cli->C_PRV)+Space(2),2),Left(LRTrim(wersonbo->PROVINCIA)+Space(2),2)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_opep_chkdiana_cli->C_IND))),Left(LRTrim(arfn_agechar(qbe_opep_chkdiana_cli->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(wersonbo->DOMICILIO,' '))+Space(35),35)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_opep_chkdiana_cli.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_opep_chkdiana_cli->C_CAP))),Left(LRTrim(qbe_opep_chkdiana_cli->C_CAP)+Space(5),5),Left(LRTrim(wersonbo->CAP)+Space(5),5)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CAP"))+CPLib.Space(5),5));
                /* _note := _note + Space(63) */
                _note = _note+CPLib.Space(63);
                /* _note := _note + iif(not(Empty(LRTrim(qbe_opep_chkdiana_cli->C_RAPPORTO))),Left(LRTrim(qbe_opep_chkdiana_cli->C_RAPPORTO)+Space(25),25),Left(LRTrim(qbe_opep_chkdiana_cli->RAPPORTBEN)+Space(25),25)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("C_RAPPORTO"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("C_RAPPORTO"))+CPLib.Space(25),25):CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana_cli.GetString("RAPPORTBEN"))+CPLib.Space(25),25));
                /* _note := _note + Space(91) */
                _note = _note+CPLib.Space(91);
                /* If w_flgchk='S' */
                if (CPLib.eqr(w_flgchk,"S")) {
                  /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                  Page_15();
                } else { // Else
                  /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                  FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                } // End If
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_wersonbo.Next();
              }
              m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
              Cursor_wersonbo.Close();
              // * --- End Select
            } // End If
          } // End If
        } // End If
        // * --- Select from xeneficope
        m_cServer = m_Ctx.GetServer("xeneficope");
        m_cPhName = m_Ctx.GetPhName("xeneficope");
        if (Cursor_xeneficope!=null)
          Cursor_xeneficope.Close();
        Cursor_xeneficope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_opep_chkdiana_cli.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xeneficope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xeneficope.Eof())) {
          /* If Empty(LRTrim(xeneficope->CODSOG)) and not(Empty(LRTrim(xeneficope->C_RAG))) */
          if (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficope.GetString("CODSOG"))) &&  ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficope.GetString("C_RAG"))))) {
            /* _note := w_tipinter + w_codinter+'5' + _idereg */
            _note = w_tipinter+w_codinter+"5"+_idereg;
            /* _note := _note + Left(LRTrim(xeneficope->CODSOG)+Space(16),16) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("CODSOG"))+CPLib.Space(16),16);
            /* _note := _note +Left(LRTrim(arfn_agechar(xeneficope->C_RAG,' '))+Space(70),70) */
            _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_xeneficope.GetString("C_RAG")," "))+CPLib.Space(70),70);
            /* _note := _note + Left(LRTrim(xeneficope->C_STA)+Space(3),3) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("C_STA"))+CPLib.Space(3),3);
            /* _note := _note +Left(LRTrim(xeneficope->C_CAB)+Space(6),6) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("C_CAB"))+CPLib.Space(6),6);
            /* _note := _note +Left(LRTrim(arfn_agechar(xeneficope->C_CTA,' '))+Space(30),30) */
            _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_xeneficope.GetString("C_CTA")," "))+CPLib.Space(30),30);
            /* _note := _note + Left(LRTrim(xeneficope->C_PRV)+Space(2),2) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("C_PRV"))+CPLib.Space(2),2);
            /* _note := _note + Left(LRTrim(arfn_agechar(xeneficope->C_IND,' '))+Space(35),35) */
            _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_xeneficope.GetString("C_IND")," "))+CPLib.Space(35),35);
            /* _note := _note + Left(LRTrim(xeneficope->C_CAP)+Space(5),5) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("C_CAP"))+CPLib.Space(5),5);
            /* _note := _note + Space(63) */
            _note = _note+CPLib.Space(63);
            /* _note := _note + Left(LRTrim(xeneficope->C_RAPPORTO)+Space(25),25) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
            /* _note := _note + Space(91) */
            _note = _note+CPLib.Space(91);
            /* If w_flgchk='S' */
            if (CPLib.eqr(w_flgchk,"S")) {
              /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
              Page_15();
            } else { // Else
              /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
              FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
            } // End If
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
          } else { // Else
            /* _numsto := arfn_chkspers(xeneficope->CODSOG,qbe_opep_chkdiana_cli->DATAREG) */
            _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_xeneficope.GetString("CODSOG"),Cursor_qbe_opep_chkdiana_cli.GetDate("DATAREG"));
            /* If Empty(LRTrim(_numsto)) */
            if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xeneficope.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                /* _note := w_tipinter + w_codinter+'5' + _idereg */
                _note = w_tipinter+w_codinter+"5"+_idereg;
                /* _note := _note + Left(LRTrim(xeneficope->CODSOG)+Space(16),16) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("CODSOG"))+CPLib.Space(16),16);
                /* _note := _note + iif(not(Empty(LRTrim(xeneficope->C_RAG))),Left(LRTrim(arfn_agechar(xeneficope->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(personbo->RAGSOC,' '))+Space(70),70)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficope.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_xeneficope.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                /* _note := _note + iif(not(Empty(LRTrim(xeneficope->C_STA))),Left(LRTrim(xeneficope->C_STA)+Space(3),3),Left(LRTrim(personbo->PAESE)+Space(3),3)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficope.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3));
                /* _note := _note + iif(not(Empty(LRTrim(xeneficope->C_CAB))),Left(LRTrim(xeneficope->C_CAB)+Space(6),6),Left(LRTrim(personbo->CODCAB)+Space(6),6)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficope.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6));
                /* _note := _note + iif(not(Empty(LRTrim(xeneficope->C_CTA))),Left(LRTrim(arfn_agechar(xeneficope->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(personbo->DESCCIT,' '))+Space(30),30)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficope.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_xeneficope.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                /* _note := _note + iif(not(Empty(LRTrim(xeneficope->C_PRV))),Left(LRTrim(xeneficope->C_PRV)+Space(2),2),Left(LRTrim(personbo->PROVINCIA)+Space(2),2)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficope.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                /* _note := _note + iif(not(Empty(LRTrim(xeneficope->C_IND))),Left(LRTrim(arfn_agechar(xeneficope->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(personbo->DOMICILIO,' '))+Space(35),35)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficope.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_xeneficope.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                /* _note := _note + iif(not(Empty(LRTrim(xeneficope->C_CAP))),Left(LRTrim(xeneficope->C_CAP)+Space(5),5),Left(LRTrim(personbo->CAP)+Space(5),5)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficope.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5));
                /* _note := _note + Space(63) */
                _note = _note+CPLib.Space(63);
                /* _note := _note +Left(LRTrim(xeneficope->C_RAPPORTO)+Space(25),25) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                /* _note := _note + Space(91) */
                _note = _note+CPLib.Space(91);
                /* If w_flgchk='S' */
                if (CPLib.eqr(w_flgchk,"S")) {
                  /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                  Page_15();
                } else { // Else
                  /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                  FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                } // End If
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
            } else { // Else
              // * --- Select from wersonbo
              m_cServer = m_Ctx.GetServer("wersonbo");
              m_cPhName = m_Ctx.GetPhName("wersonbo");
              if (Cursor_wersonbo!=null)
                Cursor_wersonbo.Close();
              Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_wersonbo.Eof())) {
                /* _note := w_tipinter + w_codinter+'5' + _idereg */
                _note = w_tipinter+w_codinter+"5"+_idereg;
                /* _note := _note + Left(LRTrim(xeneficope->CODSOG)+Space(16),16) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("CODSOG"))+CPLib.Space(16),16);
                /* _note := _note + iif(not(Empty(LRTrim(xeneficope->C_RAG))),Left(LRTrim(arfn_agechar(xeneficope->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(wersonbo->RAGSOC,' '))+Space(70),70)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficope.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_xeneficope.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                /* _note := _note + iif(not(Empty(LRTrim(xeneficope->C_STA))),Left(LRTrim(xeneficope->C_STA)+Space(3),3),Left(LRTrim(wersonbo->PAESE)+Space(3),3)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficope.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PAESE"))+CPLib.Space(3),3));
                /* _note := _note + iif(not(Empty(LRTrim(xeneficope->C_CAB))),Left(LRTrim(xeneficope->C_CAB)+Space(6),6),Left(LRTrim(wersonbo->CODCAB)+Space(6),6)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficope.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CODCAB"))+CPLib.Space(6),6));
                /* _note := _note + iif(not(Empty(LRTrim(xeneficope->C_CTA))),Left(LRTrim(arfn_agechar(xeneficope->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(wersonbo->DESCCIT,' '))+Space(30),30)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficope.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_xeneficope.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                /* _note := _note + iif(not(Empty(LRTrim(xeneficope->C_PRV))),Left(LRTrim(xeneficope->C_PRV)+Space(2),2),Left(LRTrim(wersonbo->PROVINCIA)+Space(2),2)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficope.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                /* _note := _note + iif(not(Empty(LRTrim(xeneficope->C_IND))),Left(LRTrim(arfn_agechar(xeneficope->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(wersonbo->DOMICILIO,' '))+Space(35),35)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficope.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_xeneficope.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                /* _note := _note + iif(not(Empty(LRTrim(xeneficope->C_CAP))),Left(LRTrim(xeneficope->C_CAP)+Space(5),5),Left(LRTrim(wersonbo->CAP)+Space(5),5)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficope.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CAP"))+CPLib.Space(5),5));
                /* _note := _note + Space(63) */
                _note = _note+CPLib.Space(63);
                /* _note := _note +Left(LRTrim(xeneficope->C_RAPPORTO)+Space(25),25) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                /* _note := _note + Space(91) */
                _note = _note+CPLib.Space(91);
                /* If w_flgchk='S' */
                if (CPLib.eqr(w_flgchk,"S")) {
                  /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                  Page_15();
                } else { // Else
                  /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                  FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                } // End If
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_wersonbo.Next();
              }
              m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
              Cursor_wersonbo.Close();
              // * --- End Select
            } // End If
          } // End If
          Cursor_xeneficope.Next();
        }
        m_cConnectivityError = Cursor_xeneficope.ErrorMessage();
        Cursor_xeneficope.Close();
        // * --- End Select
        /* If not(Empty(qbe_opep_chkdiana_cli->CONNALTRO)) */
        if ( ! (CPLib.Empty(Cursor_qbe_opep_chkdiana_cli.GetString("CONNALTRO")))) {
          /* _note := w_tipinter + w_codinter+'6' + _idereg */
          _note = w_tipinter+w_codinter+"6"+_idereg;
          /* _note := _note + LRTrim(arfn_datisog_sol(qbe_opep_chkdiana_cli->CONNALTRO,qbe_opep_chkdiana_cli->DATAREG,qbe_opep_chkdiana_cli->RAPPORTO,qbe_opep_chkdiana_cli->FLAGRAP,'6',w_flgrae,qbe_opep_chkdiana_cli->STATOREG,qbe_opep_chkdiana_cli->DATARETT)) */
          _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_opep_chkdiana_cli.GetString("CONNALTRO"),Cursor_qbe_opep_chkdiana_cli.GetDate("DATAREG"),Cursor_qbe_opep_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_opep_chkdiana_cli.GetString("FLAGRAP"),"6",w_flgrae,Cursor_qbe_opep_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_opep_chkdiana_cli.GetDate("DATARETT")));
          /* If w_flgchk='S' */
          if (CPLib.eqr(w_flgchk,"S")) {
            /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
            Page_15();
          } else { // Else
            /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
            FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
          } // End If
          /* nTotRec := nTotRec + 1 */
          nTotRec = CPLib.Round(nTotRec+1,0);
          /* nNumRec := nNumRec + 1 */
          nNumRec = CPLib.Round(nNumRec+1,0);
        } // End If
        // * --- Select from xerzistiope
        m_cServer = m_Ctx.GetServer("xerzistiope");
        m_cPhName = m_Ctx.GetPhName("xerzistiope");
        if (Cursor_xerzistiope!=null)
          Cursor_xerzistiope.Close();
        Cursor_xerzistiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_opep_chkdiana_cli.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xerzistiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xerzistiope.Eof())) {
          /* _note := w_tipinter + w_codinter+'6' + _idereg */
          _note = w_tipinter+w_codinter+"6"+_idereg;
          /* _note := _note + LRTrim(arfn_datisog_sol(xerzistiope->CODSOG,qbe_opep_chkdiana_cli->DATAREG,qbe_opep_chkdiana_cli->RAPPORTO,qbe_opep_chkdiana_cli->FLAGRAP,'6',w_flgrae,qbe_opep_chkdiana_cli->STATOREG,qbe_opep_chkdiana_cli->DATARETT)) */
          _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_xerzistiope.GetString("CODSOG"),Cursor_qbe_opep_chkdiana_cli.GetDate("DATAREG"),Cursor_qbe_opep_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_opep_chkdiana_cli.GetString("FLAGRAP"),"6",w_flgrae,Cursor_qbe_opep_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_opep_chkdiana_cli.GetDate("DATARETT")));
          /* If w_flgchk='S' */
          if (CPLib.eqr(w_flgchk,"S")) {
            /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
            Page_15();
          } else { // Else
            /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
            FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
          } // End If
          /* nTotRec := nTotRec + 1 */
          nTotRec = CPLib.Round(nTotRec+1,0);
          /* nNumRec := nNumRec + 1 */
          nNumRec = CPLib.Round(nNumRec+1,0);
          Cursor_xerzistiope.Next();
        }
        m_cConnectivityError = Cursor_xerzistiope.ErrorMessage();
        Cursor_xerzistiope.Close();
        // * --- End Select
        /* gNumRec := nTotRec // N� Record DIANA */
        gNumRec = CPLib.Round(nTotRec,0);
        m_Ctx.SetGlobalNumber("gNumRec",gNumRec);
        /* gNumReg := nTotReg // N� Registrazioni DIANA */
        gNumReg = CPLib.Round(nTotReg,0);
        m_Ctx.SetGlobalNumber("gNumReg",gNumReg);
        Cursor_qbe_opep_chkdiana_cli.Next();
      }
      m_cConnectivityError = Cursor_qbe_opep_chkdiana_cli.ErrorMessage();
      Cursor_qbe_opep_chkdiana_cli.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_opep_chkdiana_cli!=null)
          Cursor_qbe_opep_chkdiana_cli.Close();
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
        if (Cursor_xnarapbo!=null)
          Cursor_xnarapbo.Close();
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
        if (Cursor_anadip!=null)
          Cursor_anadip.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_kersonbo!=null)
          Cursor_kersonbo.Close();
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
        if (Cursor_xntestbo!=null)
          Cursor_xntestbo.Close();
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
        if (Cursor_xlientiope!=null)
          Cursor_xlientiope.Close();
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
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
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
      try {
        if (Cursor_xerzistiope!=null)
          Cursor_xerzistiope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_13() throws Exception {
    CPResultSet Cursor_qbe_frad_chkdiana_cli=null;
    CPResultSet Cursor_anarapbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_anadip=null;
    CPResultSet Cursor_kersonbo=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_mlientifrz=null;
    CPResultSet Cursor_clientifrz=null;
    CPResultSet Cursor_mogopefbo=null;
    CPResultSet Cursor_sogopefbo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_meneficfrz=null;
    CPResultSet Cursor_beneficfrz=null;
    CPResultSet Cursor_merzistifrz=null;
    CPResultSet Cursor_terzistifrz=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Cicla sulle frazionate di uno specifico cliente */
      /* gMsgImp := 'Verifica Frazionate del cliente da elaborare ...' // Messaggio Import */
      gMsgImp = "Verifica Frazionate del cliente da elaborare ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* _conta := _conta + 1 */
      _conta = CPLib.Round(_conta+1,0);
      // * --- Select from qbe_frad_chkdiana_cli
      SPBridge.HMCaller _hNJAJJMBSKM;
      _hNJAJJMBSKM = new SPBridge.HMCaller();
      _hNJAJJMBSKM.Set("m_cVQRList",m_cVQRList);
      _hNJAJJMBSKM.Set("cdadata",w_cdadata);
      _hNJAJJMBSKM.Set("c_adata",w_c_adata);
      _hNJAJJMBSKM.Set("codage",w_codage);
      _hNJAJJMBSKM.Set("codcli",w_codcli);
      _hNJAJJMBSKM.Set("ragben",w_ragben);
      if (Cursor_qbe_frad_chkdiana_cli!=null)
        Cursor_qbe_frad_chkdiana_cli.Close();
      Cursor_qbe_frad_chkdiana_cli = new VQRHolder("qbe_frad_chkdiana_cli",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_hNJAJJMBSKM,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_frad_chkdiana_cli.Eof())) {
        /* _ctotale := _ctotale + 1 */
        _ctotale = CPLib.Round(_ctotale+1,0);
        /* gMsgImp := 'Elaborazione Frazionata N.: '+LRTrim(Str(_ctotale,15,0)) // Messaggio Import */
        gMsgImp = "Elaborazione Frazionata N.: "+CPLib.LRTrim(CPLib.Str(_ctotale,15,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If Empty(LRTrim(qbe_frad_chkdiana_cli->FLAGRAP2)) */
        if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("FLAGRAP2")))) {
          /* _idereg := DateToChar(qbe_frad_chkdiana_cli->DATAOPE) + "F" + Right(qbe_frad_chkdiana_cli->NUMPROG,10) + 'S' */
          _idereg = CPLib.DateToChar(Cursor_qbe_frad_chkdiana_cli.GetDate("DATAOPE"))+"F"+CPLib.Right(Cursor_qbe_frad_chkdiana_cli.GetString("NUMPROG"),10)+"S";
        } else { // Else
          /* _idereg := Left(qbe_frad_chkdiana_cli->IDEREG,8) + "F" + Right(qbe_frad_chkdiana_cli->IDEREG,11) */
          _idereg = CPLib.Left(Cursor_qbe_frad_chkdiana_cli.GetString("IDEREG"),8)+"F"+CPLib.Right(Cursor_qbe_frad_chkdiana_cli.GetString("IDEREG"),11);
        } // End If
        /* _note := w_tipinter + w_codinter + '1' + _idereg */
        _note = w_tipinter+w_codinter+"1"+_idereg;
        /* _flagrap := '' */
        _flagrap = "";
        // * --- Select from anarapbo
        m_cServer = m_Ctx.GetServer("anarapbo");
        m_cPhName = m_Ctx.GetPhName("anarapbo");
        if (Cursor_anarapbo!=null)
          Cursor_anarapbo.Close();
        Cursor_anarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select TIPORAP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana_cli.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("anarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_anarapbo.Eof())) {
          /* _flagrap := anarapbo->TIPORAP */
          _flagrap = Cursor_anarapbo.GetString("TIPORAP");
          Cursor_anarapbo.Next();
        }
        m_cConnectivityError = Cursor_anarapbo.ErrorMessage();
        Cursor_anarapbo.Close();
        // * --- End Select
        /* _flagrap := iif(Empty(LRTrim(_flagrap)),qbe_frad_chkdiana_cli->FLAGRAP,_flagrap) */
        _flagrap = (CPLib.Empty(CPLib.LRTrim(_flagrap))?Cursor_qbe_frad_chkdiana_cli.GetString("FLAGRAP"):_flagrap);
        /* If Empty(qbe_frad_chkdiana_cli->CODDIPE) */
        if (CPLib.Empty(Cursor_qbe_frad_chkdiana_cli.GetString("CODDIPE"))) {
          // * --- Read from intermbo
          m_cServer = m_Ctx.GetServer("intermbo");
          m_cPhName = m_Ctx.GetPhName("intermbo");
          m_cSql = "";
          m_cSql = m_cSql+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codinter,"C",11,0,m_cServer),m_cServer,w_codinter);
          if (m_Ctx.IsSharedTemp("intermbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODCAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODDIPE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            w_codcab = Read_Cursor.GetString("CODCAB");
            w_desccit = Read_Cursor.GetString("DESCCIT");
            w_provin = Read_Cursor.GetString("PROVINCIA");
            w_coddipe = Read_Cursor.GetString("CODDIPE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on intermbo into routine arrt_chkdiana_old returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            w_codcab = "";
            w_desccit = "";
            w_provin = "";
            w_coddipe = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(w_coddipe) */
          if (CPLib.Empty(w_coddipe)) {
            /* _note := _note + '000000' + Left(LRTrim(w_codcab)+Space(6),6) + Left(LRTrim(w_desccit)+Space(30),30) + Left(LRTrim(w_provin)+Space(2),2) */
            _note = _note+"000000"+CPLib.Left(CPLib.LRTrim(w_codcab)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(w_desccit)+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(w_provin)+CPLib.Space(2),2);
          } else { // Else
            /* _note := _note + w_coddipe */
            _note = _note+w_coddipe;
            // * --- Read from anadip
            m_cServer = m_Ctx.GetServer("anadip");
            m_cPhName = m_Ctx.GetPhName("anadip");
            m_cSql = "";
            m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_coddipe,"C",6,0,m_cServer),m_cServer,w_coddipe);
            if (m_Ctx.IsSharedTemp("anadip")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              w_cabcod = Read_Cursor.GetString("CAB");
              w_citdesc = Read_Cursor.GetString("DESCCIT");
              w_provind = Read_Cursor.GetString("PROVINCIA");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on anadip into routine arrt_chkdiana_old returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              w_cabcod = "";
              w_citdesc = "";
              w_provind = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(w_cabcod) */
            if (CPLib.Empty(w_cabcod)) {
              /* _note := _note + Left(LRTrim(w_codcab)+Space(6),6) + Left(LRTrim(w_desccit)+Space(30),30) + Left(LRTrim(w_provin)+Space(2),2) */
              _note = _note+CPLib.Left(CPLib.LRTrim(w_codcab)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(w_desccit)+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(w_provin)+CPLib.Space(2),2);
            } else { // Else
              /* _note := _note + Left(LRTrim(w_cabcod)+Space(6),6) + Left(LRTrim(w_citdesc)+Space(30),30) + Left(LRTrim(w_provind)+Space(2),2) */
              _note = _note+CPLib.Left(CPLib.LRTrim(w_cabcod)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(w_citdesc)+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(w_provind)+CPLib.Space(2),2);
            } // End If
          } // End If
        } else { // Else
          // * --- Select from anadip
          m_cServer = m_Ctx.GetServer("anadip");
          m_cPhName = m_Ctx.GetPhName("anadip");
          if (Cursor_anadip!=null)
            Cursor_anadip.Close();
          Cursor_anadip = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODDIP="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana_cli.GetString("CODDIPE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("anadip")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_anadip.Eof())) {
            /* _note := _note + qbe_frad_chkdiana_cli->CODDIPE + Left(LRTrim(anadip->CAB)+Space(6),6) + Left(LRTrim(anadip->DESCCIT)+Space(30),30) + Left(LRTrim(anadip->PROVINCIA)+Space(2),2) */
            _note = _note+Cursor_qbe_frad_chkdiana_cli.GetString("CODDIPE")+CPLib.Left(CPLib.LRTrim(Cursor_anadip.GetString("CAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_anadip.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_anadip.GetString("PROVINCIA"))+CPLib.Space(2),2);
            Cursor_anadip.Next();
          }
          m_cConnectivityError = Cursor_anadip.ErrorMessage();
          Cursor_anadip.Close();
          // * --- End Select
        } // End If
        /* _note := _note + Left(DateToChar(qbe_frad_chkdiana_cli->DATAOPE)+Space(8),8) + Left(LRTrim(qbe_frad_chkdiana_cli->FLAGFRAZ)+" ",1) + Left(LRTrim(qbe_frad_chkdiana_cli->FLAGCONT)+" ",1) */
        _note = _note+CPLib.Left(CPLib.DateToChar(Cursor_qbe_frad_chkdiana_cli.GetDate("DATAOPE"))+CPLib.Space(8),8)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("FLAGFRAZ"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("FLAGCONT"))+" ",1);
        /* _note := _note + Left(LRTrim(qbe_frad_chkdiana_cli->CODANA)+Space(4),4) + Left(LRTrim(qbe_frad_chkdiana_cli->CODVOC)+Space(2),2) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("CODANA"))+CPLib.Space(4),4)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("CODVOC"))+CPLib.Space(2),2);
        /* _note := _note + Left(LRTrim(qbe_frad_chkdiana_cli->TIPOINT2)+Space(2),2) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("TIPOINT2"))+CPLib.Space(2),2);
        /* _note := _note + iif(Empty(LRTrim(qbe_frad_chkdiana_cli->CODFISCICP)),Left(LRTrim(qbe_frad_chkdiana_cli->CODINT2)+Space(11),11),Left(LRTrim(qbe_frad_chkdiana_cli->CODFISCICP)+Space(11),11)) */
        _note = _note+(CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("CODFISCICP")))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("CODINT2"))+CPLib.Space(11),11):CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("CODFISCICP"))+CPLib.Space(11),11));
        /* _note := _note + Left(LRTrim(qbe_frad_chkdiana_cli->PAESE)+Space(3),3) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("PAESE"))+CPLib.Space(3),3);
        /* _note := _note + Left(LRTrim(qbe_frad_chkdiana_cli->CODCAB2)+Space(6),6) + Left(LRTrim(arfn_agechar(qbe_frad_chkdiana_cli->DESC2,' '))+Space(30),30) + Left(LRTrim(qbe_frad_chkdiana_cli->PROV2)+Space(2),2) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("CODCAB2"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana_cli.GetString("DESC2")," "))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("PROV2"))+CPLib.Space(2),2);
        /* _note := _note + Left(LRTrim(arfn_agechar(qbe_frad_chkdiana_cli->DESCINTER,' '))+Space(50),50) + Left(LRTrim(arfn_agechar(qbe_frad_chkdiana_cli->RAPPORTO,' '))+Space(25),25) + Left(LRTrim(_flagrap)+" ",1) */
        _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana_cli.GetString("DESCINTER")," "))+CPLib.Space(50),50)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana_cli.GetString("RAPPORTO")," "))+CPLib.Space(25),25)+CPLib.Left(CPLib.LRTrim(_flagrap)+" ",1);
        /* _note := _note + Left(LRTrim(qbe_frad_chkdiana_cli->TIPOLEG)+" ",1) + Left(LRTrim(DateToChar(qbe_frad_chkdiana_cli->DATAREG))+Space(8),8) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("TIPOLEG"))+" ",1)+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_frad_chkdiana_cli.GetDate("DATAREG")))+CPLib.Space(8),8);
        /* _note := _note + Left(LRTrim(qbe_frad_chkdiana_cli->TIPOOPRAP)+Space(2),2) + Left(LRTrim(qbe_frad_chkdiana_cli->COLLEG)+Space(11),11) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("TIPOOPRAP"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("COLLEG"))+CPLib.Space(11),11);
        /* _note := _note + " " + Left(LRTrim(qbe_frad_chkdiana_cli->STATOREG)+" ",1)  */
        _note = _note+" "+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("STATOREG"))+" ",1);
        /* If Empty(qbe_frad_chkdiana_cli->DATARETT) or DateToChar(qbe_frad_chkdiana_cli->DATARETT)='01000101' */
        if (CPLib.Empty(Cursor_qbe_frad_chkdiana_cli.GetDate("DATARETT")) || CPLib.eqr(CPLib.DateToChar(Cursor_qbe_frad_chkdiana_cli.GetDate("DATARETT")),"01000101")) {
          /* _note := _note + Space(8) */
          _note = _note+CPLib.Space(8);
        } else { // Else
          /* _note := _note + Left(LRTrim(DateToChar(qbe_frad_chkdiana_cli->DATARETT))+Space(8),8) */
          _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_frad_chkdiana_cli.GetDate("DATARETT")))+CPLib.Space(8),8);
        } // End If
        /* _note := _note + iif(Empty(LRTrim(qbe_frad_chkdiana_cli->OPERAZMOD)),Space(20),Left(qbe_frad_chkdiana_cli->OPERAZMOD,8)+"F"+Right(qbe_frad_chkdiana_cli->OPERAZMOD,11)) */
        _note = _note+(CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("OPERAZMOD")))?CPLib.Space(20):CPLib.Left(Cursor_qbe_frad_chkdiana_cli.GetString("OPERAZMOD"),8)+"F"+CPLib.Right(Cursor_qbe_frad_chkdiana_cli.GetString("OPERAZMOD"),11));
        /* _note := _note + Left(LRTrim(qbe_frad_chkdiana_cli->FLAGLIRE)+" ",1) + Left(LRTrim(qbe_frad_chkdiana_cli->VALUTA)+Space(3),3) + Left(LRTrim(qbe_frad_chkdiana_cli->SEGNO)+" ",1) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("FLAGLIRE"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("VALUTA"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("SEGNO"))+" ",1);
        /* _note := _note +  Right('000000000000000'+LRTrim(Str(qbe_frad_chkdiana_cli->TOTLIRE,15,0)),15) + Right('000000000000000'+LRTrim(Str(qbe_frad_chkdiana_cli->TOTCONT,15,0)),15) + Space(69) */
        _note = _note+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_frad_chkdiana_cli.GetDouble("TOTLIRE"),15,0)),15)+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_frad_chkdiana_cli.GetDouble("TOTCONT"),15,0)),15)+CPLib.Space(69);
        /* If w_flgchk='S' */
        if (CPLib.eqr(w_flgchk,"S")) {
          /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
          Page_15();
        } else { // Else
          /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
          FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
        } // End If
        /* nTotRec := nTotRec + 1 */
        nTotRec = CPLib.Round(nTotRec+1,0);
        /* nTotReg := nTotReg + 1 */
        nTotReg = CPLib.Round(nTotReg+1,0);
        /* nNumRec := nNumRec + 1 */
        nNumRec = CPLib.Round(nNumRec+1,0);
        /* If not(Empty(qbe_frad_chkdiana_cli->CONNESCLI)) and Empty(LRTrim(qbe_frad_chkdiana_cli->RAPPORTO)) */
        if ( ! (CPLib.Empty(Cursor_qbe_frad_chkdiana_cli.GetString("CONNESCLI"))) && CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("RAPPORTO")))) {
          /* _oldrap := '' */
          _oldrap = "";
          /* _codrif := qbe_frad_chkdiana_cli->CONNESCLI */
          _codrif = Cursor_qbe_frad_chkdiana_cli.GetString("CONNESCLI");
          /* If gFlgWU='S' */
          if (CPLib.eqr(gFlgWU,"S")) {
            // * --- Select from kersonbo
            m_cServer = m_Ctx.GetServer("kersonbo");
            m_cPhName = m_Ctx.GetPhName("kersonbo");
            if (Cursor_kersonbo!=null)
              Cursor_kersonbo.Close();
            Cursor_kersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana_cli.GetString("CONNESDOC"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("kersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_kersonbo.Eof())) {
              /* _ramate := iif(w_flgrae='R',LRTrim(kersonbo->RAMOGRUP),Left(LRTrim(kersonbo->ATTIV),3)) */
              _ramate = (CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_kersonbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("ATTIV")),3));
              /* _note := w_tipinter + w_codinter */
              _note = w_tipinter+w_codinter;
              /* If Empty(qbe_frad_chkdiana_cli->CONNESOPER) or (qbe_frad_chkdiana_cli->CONNESOPER=qbe_frad_chkdiana_cli->CONNESCLI) */
              if (CPLib.Empty(Cursor_qbe_frad_chkdiana_cli.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_frad_chkdiana_cli.GetString("CONNESOPER"),Cursor_qbe_frad_chkdiana_cli.GetString("CONNESCLI")))) {
                /* _note := _note + '2' */
                _note = _note+"2";
              } else { // Else
                /* _note := _note + '3' */
                _note = _note+"3";
              } // End If
              /* _note := _note + _idereg */
              _note = _note+_idereg;
              /* _note := _note + Left(LRTrim(qbe_frad_chkdiana_cli->CONNESCLI)+Space(16),16) + Left(LRTrim(kersonbo->RAGSOC)+Space(70),70) + Left(LRTrim(kersonbo->PAESE)+Space(3),3) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("CONNESCLI"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("PAESE"))+CPLib.Space(3),3);
              /* _note := _note + Left(LRTrim(kersonbo->CODCAB)+Space(6),6) + Left(LRTrim(kersonbo->DESCCIT)+Space(30),30) + Left(LRTrim(kersonbo->PROVINCIA)+Space(2),2) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
              /* _note := _note + Left(LRTrim(kersonbo->DOMICILIO)+Space(35),35) + Left(LRTrim(kersonbo->CAP)+ Space(5),5) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("CAP"))+CPLib.Space(5),5);
              /* _note := _note + Left(LRTrim(kersonbo->CODFISC)+Space(16),16)  */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("CODFISC"))+CPLib.Space(16),16);
              /* If Empty(kersonbo->DATANASC) or DateToChar(kersonbo->DATANASC)='01000101' */
              if (CPLib.Empty(Cursor_kersonbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_kersonbo.GetDate("DATANASC")),"01000101")) {
                /* _note := _note + Space(8) */
                _note = _note+CPLib.Space(8);
              } else { // Else
                /* _note := _note + Left(LRTrim(DateToChar(kersonbo->DATANASC))+Space(8),8) */
                _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_kersonbo.GetDate("DATANASC")))+CPLib.Space(8),8);
              } // End If
              /* If not(Empty(kersonbo->NASSTATO)) */
              if ( ! (CPLib.Empty(Cursor_kersonbo.GetString("NASSTATO")))) {
                /* _note := _note + Left(LRTrim(kersonbo->NASSTATO)+Space(30),30) + Left(LRTrim(kersonbo->SOTGRUP)+Space(3),3) + Left(LRTrim(_ramate)+Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(_ramate)+CPLib.Space(3),3);
              } else { // Else
                /* _note := _note + Left(LRTrim(kersonbo->NASCOMUN)+Space(30),30) + Left(LRTrim(kersonbo->SOTGRUP)+Space(3),3) + Left(LRTrim(_ramate) +Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(_ramate)+CPLib.Space(3),3);
              } // End If
              /* _note := _note + Left(LRTrim(kersonbo->SETTSINT)+Space(3),3) + Left(LRTrim(arfn_agechar(qbe_frad_chkdiana_cli->RAPPORTO,' '))+Space(25),25) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana_cli.GetString("RAPPORTO")," "))+CPLib.Space(25),25);
              /* _note := _note + Left(LRTrim(qbe_frad_chkdiana_cli->FLAGRAP)+" ",1) + Left(LRTrim(kersonbo->TIPODOC)+Space(2),2) + Left(LRTrim(kersonbo->NUMDOCUM)+Space(15),15) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
              /* If Empty(kersonbo->DATARILASC) or DateToChar(kersonbo->DATARILASC)='01000101' */
              if (CPLib.Empty(Cursor_kersonbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_kersonbo.GetDate("DATARILASC")),"01000101")) {
                /* _note := _note + Space(8) */
                _note = _note+CPLib.Space(8);
              } else { // Else
                /* _note := _note + Left(LRTrim(DateToChar(kersonbo->DATARILASC))+Space(8),8)  */
                _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_kersonbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
              } // End If
              /* _note := _note + Left(LRTrim(kersonbo->AUTRILASC)+Space(30),30) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("AUTRILASC"))+CPLib.Space(30),30);
              /* _note := _note + Left(LRTrim(kersonbo->SESSO)+" ",1) + Space(34) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SESSO"))+" ",1)+CPLib.Space(34);
              /* If w_flgchk='S' */
              if (CPLib.eqr(w_flgchk,"S")) {
                /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                Page_15();
              } else { // Else
                /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
              } // End If
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
              Cursor_kersonbo.Next();
            }
            m_cConnectivityError = Cursor_kersonbo.ErrorMessage();
            Cursor_kersonbo.Close();
            // * --- End Select
          } else { // Else
            /* _note := w_tipinter + w_codinter */
            _note = w_tipinter+w_codinter;
            /* If Empty(qbe_frad_chkdiana_cli->CONNESOPER) or (qbe_frad_chkdiana_cli->CONNESOPER=qbe_frad_chkdiana_cli->CONNESCLI) */
            if (CPLib.Empty(Cursor_qbe_frad_chkdiana_cli.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_frad_chkdiana_cli.GetString("CONNESOPER"),Cursor_qbe_frad_chkdiana_cli.GetString("CONNESCLI")))) {
              /* _note := _note + '2' */
              _note = _note+"2";
            } else { // Else
              /* _note := _note + '3' */
              _note = _note+"3";
            } // End If
            /* _note := _note + _idereg */
            _note = _note+_idereg;
            /* _note := _note + LRTrim(arfn_datisog_sol(qbe_frad_chkdiana_cli->CONNESCLI,qbe_frad_chkdiana_cli->DATAREG,qbe_frad_chkdiana_cli->RAPPORTO,qbe_frad_chkdiana_cli->FLAGRAP,'2',w_flgrae,qbe_frad_chkdiana_cli->STATOREG,qbe_frad_chkdiana_cli->DATARETT)) */
            _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana_cli.GetString("CONNESCLI"),Cursor_qbe_frad_chkdiana_cli.GetDate("DATAREG"),Cursor_qbe_frad_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_frad_chkdiana_cli.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_frad_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_frad_chkdiana_cli.GetDate("DATARETT")));
            /* If w_flgchk='S' */
            if (CPLib.eqr(w_flgchk,"S")) {
              /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
              Page_15();
            } else { // Else
              /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
              FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
            } // End If
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
          } // End If
        } else { // Else
          /* _oldrap := '' */
          _oldrap = "";
          // * --- Read from knarapbo
          m_cServer = m_Ctx.GetServer("knarapbo");
          m_cPhName = m_Ctx.GetPhName("knarapbo");
          m_cSql = "";
          m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_frad_chkdiana_cli.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_qbe_frad_chkdiana_cli.GetString("RAPPORTO"));
          if (m_Ctx.IsSharedTemp("knarapbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _oldrap = Read_Cursor.GetString("RAPPORTO");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on knarapbo into routine arrt_chkdiana_old returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _oldrap = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If not(Empty(_oldrap)) */
          if ( ! (CPLib.Empty(_oldrap))) {
            // * --- Select from intestbo
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            if (Cursor_intestbo!=null)
              Cursor_intestbo.Close();
            Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana_cli.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestbo.Eof())) {
              /* If qbe_frad_chkdiana_cli->RAPPORTO = intestbo->RAPPORTO */
              if (CPLib.eqr(Cursor_qbe_frad_chkdiana_cli.GetString("RAPPORTO"),Cursor_intestbo.GetString("RAPPORTO"))) {
                /* _avanza := 0 */
                _avanza = CPLib.Round(0,0);
                /* If Empty(intestbo->CODINTER) or intestbo->STATOREG='2' or intestbo->STATOREG='3' */
                if (CPLib.Empty(Cursor_intestbo.GetString("CODINTER")) || CPLib.eqr(Cursor_intestbo.GetString("STATOREG"),"2") || CPLib.eqr(Cursor_intestbo.GetString("STATOREG"),"3")) {
                  /* _avanza := 1 */
                  _avanza = CPLib.Round(1,0);
                } // End If
                /* If intestbo->DATAINI > qbe_frad_chkdiana_cli->DATAOPE */
                if (CPLib.gt(Cursor_intestbo.GetDate("DATAINI"),Cursor_qbe_frad_chkdiana_cli.GetDate("DATAOPE"))) {
                  /* _avanza := 1 */
                  _avanza = CPLib.Round(1,0);
                } // End If
                /* If not(Empty(intestbo->DATAFINE)) and intestbo->DATAFINE < qbe_frad_chkdiana_cli->DATAOPE */
                if ( ! (CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE"))) && CPLib.lt(Cursor_intestbo.GetDate("DATAFINE"),Cursor_qbe_frad_chkdiana_cli.GetDate("DATAOPE"))) {
                  /* _avanza := 1 */
                  _avanza = CPLib.Round(1,0);
                } // End If
                /* If _avanza = 0 */
                if (CPLib.eqr(_avanza,0)) {
                  /* _codrif := intestbo->CODINTER */
                  _codrif = Cursor_intestbo.GetString("CODINTER");
                  /* _note := w_tipinter + w_codinter */
                  _note = w_tipinter+w_codinter;
                  /* If Empty(qbe_frad_chkdiana_cli->CONNESOPER) or (qbe_frad_chkdiana_cli->CONNESOPER=qbe_frad_chkdiana_cli->CONNESCLI) */
                  if (CPLib.Empty(Cursor_qbe_frad_chkdiana_cli.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_frad_chkdiana_cli.GetString("CONNESOPER"),Cursor_qbe_frad_chkdiana_cli.GetString("CONNESCLI")))) {
                    /* _note := _note + '2' */
                    _note = _note+"2";
                  } else { // Else
                    /* _note := _note + '3' */
                    _note = _note+"3";
                  } // End If
                  /* _note := _note + _idereg */
                  _note = _note+_idereg;
                  /* _note := _note + LRTrim(arfn_datisog_sol(intestbo->CODINTER,qbe_frad_chkdiana_cli->DATAREG,qbe_frad_chkdiana_cli->RAPPORTO,qbe_frad_chkdiana_cli->FLAGRAP,'2',w_flgrae,qbe_frad_chkdiana_cli->STATOREG,qbe_frad_chkdiana_cli->DATARETT)) */
                  _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_intestbo.GetString("CODINTER"),Cursor_qbe_frad_chkdiana_cli.GetDate("DATAREG"),Cursor_qbe_frad_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_frad_chkdiana_cli.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_frad_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_frad_chkdiana_cli.GetDate("DATARETT")));
                  /* If w_flgchk='S' */
                  if (CPLib.eqr(w_flgchk,"S")) {
                    /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                    Page_15();
                  } else { // Else
                    /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                    FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                  } // End If
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                } // End If
              } // End If
              Cursor_intestbo.Next();
            }
            m_cConnectivityError = Cursor_intestbo.ErrorMessage();
            Cursor_intestbo.Close();
            // * --- End Select
          } else { // Else
            /* If not(Empty(LRTrim(qbe_frad_chkdiana_cli->CONNESCLI))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("CONNESCLI"))))) {
              /* _note := w_tipinter + w_codinter */
              _note = w_tipinter+w_codinter;
              /* If Empty(qbe_frad_chkdiana_cli->CONNESOPER) or (qbe_frad_chkdiana_cli->CONNESOPER=qbe_frad_chkdiana_cli->CONNESCLI) */
              if (CPLib.Empty(Cursor_qbe_frad_chkdiana_cli.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_frad_chkdiana_cli.GetString("CONNESOPER"),Cursor_qbe_frad_chkdiana_cli.GetString("CONNESCLI")))) {
                /* _note := _note + '2' */
                _note = _note+"2";
              } else { // Else
                /* _note := _note + '3' */
                _note = _note+"3";
              } // End If
              /* _note := _note + _idereg */
              _note = _note+_idereg;
              /* _note := _note + LRTrim(arfn_datisog_sol(qbe_frad_chkdiana_cli->CONNESCLI,qbe_frad_chkdiana_cli->DATAREG,qbe_frad_chkdiana_cli->RAPPORTO,qbe_frad_chkdiana_cli->FLAGRAP,'2',w_flgrae,qbe_frad_chkdiana_cli->STATOREG,qbe_frad_chkdiana_cli->DATARETT)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana_cli.GetString("CONNESCLI"),Cursor_qbe_frad_chkdiana_cli.GetDate("DATAREG"),Cursor_qbe_frad_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_frad_chkdiana_cli.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_frad_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_frad_chkdiana_cli.GetDate("DATARETT")));
              /* If w_flgchk='S' */
              if (CPLib.eqr(w_flgchk,"S")) {
                /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                Page_15();
              } else { // Else
                /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
              } // End If
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
            } // End If
          } // End If
        } // End If
        /* If not(Empty(LRTrim(_oldrap))) */
        if ( ! (CPLib.Empty(CPLib.LRTrim(_oldrap)))) {
          /* _oldrighe := 0 */
          _oldrighe = CPLib.Round(0,0);
          /* If qbe_frad_chkdiana_cli->STATOREG='3' */
          if (CPLib.eqr(Cursor_qbe_frad_chkdiana_cli.GetString("STATOREG"),"3")) {
            /* _oldrighe := 0 */
            _oldrighe = CPLib.Round(0,0);
            // * --- Select from mlientifrz
            m_cServer = m_Ctx.GetServer("mlientifrz");
            m_cPhName = m_Ctx.GetPhName("mlientifrz");
            if (Cursor_mlientifrz!=null)
              Cursor_mlientifrz.Close();
            Cursor_mlientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana_cli.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("mlientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_mlientifrz.Eof())) {
              /* _oldrighe := 1 */
              _oldrighe = CPLib.Round(1,0);
              /* _note := w_tipinter + w_codinter */
              _note = w_tipinter+w_codinter;
              /* If Empty(qbe_frad_chkdiana_cli->CONNESOPER) or (qbe_frad_chkdiana_cli->CONNESOPER=mlientifrz->CODSOG) */
              if (CPLib.Empty(Cursor_qbe_frad_chkdiana_cli.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_frad_chkdiana_cli.GetString("CONNESOPER"),Cursor_mlientifrz.GetString("CODSOG")))) {
                /* _note := _note + '2' */
                _note = _note+"2";
              } else { // Else
                /* _note := _note + '3' */
                _note = _note+"3";
              } // End If
              /* _note := _note + _idereg */
              _note = _note+_idereg;
              /* _note := _note + LRTrim(arfn_datisog_sol(mlientifrz->CODSOG,qbe_frad_chkdiana_cli->DATAREG,qbe_frad_chkdiana_cli->RAPPORTO,qbe_frad_chkdiana_cli->FLAGRAP,'2',w_flgrae,qbe_frad_chkdiana_cli->STATOREG,qbe_frad_chkdiana_cli->DATARETT)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_mlientifrz.GetString("CODSOG"),Cursor_qbe_frad_chkdiana_cli.GetDate("DATAREG"),Cursor_qbe_frad_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_frad_chkdiana_cli.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_frad_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_frad_chkdiana_cli.GetDate("DATARETT")));
              /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
              FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
              Cursor_mlientifrz.Next();
            }
            m_cConnectivityError = Cursor_mlientifrz.ErrorMessage();
            Cursor_mlientifrz.Close();
            // * --- End Select
          } // End If
          /* If _oldrighe=0 */
          if (CPLib.eqr(_oldrighe,0)) {
            // * --- Select from clientifrz
            m_cServer = m_Ctx.GetServer("clientifrz");
            m_cPhName = m_Ctx.GetPhName("clientifrz");
            if (Cursor_clientifrz!=null)
              Cursor_clientifrz.Close();
            Cursor_clientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana_cli.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("clientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_clientifrz.Eof())) {
              /* _note := w_tipinter + w_codinter */
              _note = w_tipinter+w_codinter;
              /* If Empty(qbe_frad_chkdiana_cli->CONNESOPER) or (qbe_frad_chkdiana_cli->CONNESOPER=clientifrz->CODSOG) */
              if (CPLib.Empty(Cursor_qbe_frad_chkdiana_cli.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_frad_chkdiana_cli.GetString("CONNESOPER"),Cursor_clientifrz.GetString("CODSOG")))) {
                /* _note := _note + '2' */
                _note = _note+"2";
              } else { // Else
                /* _note := _note + '3' */
                _note = _note+"3";
              } // End If
              /* _note := _note + _idereg */
              _note = _note+_idereg;
              /* _note := _note + LRTrim(arfn_datisog_sol(clientifrz->CODSOG,qbe_frad_chkdiana_cli->DATAREG,qbe_frad_chkdiana_cli->RAPPORTO,qbe_frad_chkdiana_cli->FLAGRAP,'2',w_flgrae,qbe_frad_chkdiana_cli->STATOREG,qbe_frad_chkdiana_cli->DATARETT)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_clientifrz.GetString("CODSOG"),Cursor_qbe_frad_chkdiana_cli.GetDate("DATAREG"),Cursor_qbe_frad_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_frad_chkdiana_cli.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_frad_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_frad_chkdiana_cli.GetDate("DATARETT")));
              /* If w_flgchk='S' */
              if (CPLib.eqr(w_flgchk,"S")) {
                /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                Page_15();
              } else { // Else
                /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
              } // End If
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
              Cursor_clientifrz.Next();
            }
            m_cConnectivityError = Cursor_clientifrz.ErrorMessage();
            Cursor_clientifrz.Close();
            // * --- End Select
          } // End If
        } // End If
        /* If not(Empty(qbe_frad_chkdiana_cli->CONNESOPER)) and qbe_frad_chkdiana_cli->CONNESOPER <> _codrif */
        if ( ! (CPLib.Empty(Cursor_qbe_frad_chkdiana_cli.GetString("CONNESOPER"))) && CPLib.ne(Cursor_qbe_frad_chkdiana_cli.GetString("CONNESOPER"),_codrif)) {
          /* _note := w_tipinter + w_codinter+'4' + _idereg */
          _note = w_tipinter+w_codinter+"4"+_idereg;
          /* _note := _note + LRTrim(arfn_datisog_sol(qbe_frad_chkdiana_cli->CONNESOPER,qbe_frad_chkdiana_cli->DATAREG,qbe_frad_chkdiana_cli->RAPPORTO,qbe_frad_chkdiana_cli->FLAGRAP,'4',w_flgrae,qbe_frad_chkdiana_cli->STATOREG,qbe_frad_chkdiana_cli->DATARETT)) */
          _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana_cli.GetString("CONNESOPER"),Cursor_qbe_frad_chkdiana_cli.GetDate("DATAREG"),Cursor_qbe_frad_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_frad_chkdiana_cli.GetString("FLAGRAP"),"4",w_flgrae,Cursor_qbe_frad_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_frad_chkdiana_cli.GetDate("DATARETT")));
          /* If w_flgchk='S' */
          if (CPLib.eqr(w_flgchk,"S")) {
            /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
            Page_15();
          } else { // Else
            /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
            FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
          } // End If
          /* nTotRec := nTotRec + 1 */
          nTotRec = CPLib.Round(nTotRec+1,0);
          /* nNumRec := nNumRec + 1 */
          nNumRec = CPLib.Round(nNumRec+1,0);
        } // End If
        /* _oldrighe := 0 */
        _oldrighe = CPLib.Round(0,0);
        /* If qbe_frad_chkdiana_cli->STATOREG='3' */
        if (CPLib.eqr(Cursor_qbe_frad_chkdiana_cli.GetString("STATOREG"),"3")) {
          // * --- Select from mogopefbo
          m_cServer = m_Ctx.GetServer("mogopefbo");
          m_cPhName = m_Ctx.GetPhName("mogopefbo");
          if (Cursor_mogopefbo!=null)
            Cursor_mogopefbo.Close();
          Cursor_mogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana_cli.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("mogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_mogopefbo.Eof())) {
            /* _oldrighe := 1 */
            _oldrighe = CPLib.Round(1,0);
            /* _note := w_tipinter + w_codinter+'4' + _idereg */
            _note = w_tipinter+w_codinter+"4"+_idereg;
            /* _note := _note + LRTrim(arfn_datisog_sol(mogopefbo->CODSOG,qbe_frad_chkdiana_cli->DATAREG,qbe_frad_chkdiana_cli->RAPPORTO,qbe_frad_chkdiana_cli->FLAGRAP,'4',w_flgrae,qbe_frad_chkdiana_cli->STATOREG,qbe_frad_chkdiana_cli->DATARETT)) */
            _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_mogopefbo.GetString("CODSOG"),Cursor_qbe_frad_chkdiana_cli.GetDate("DATAREG"),Cursor_qbe_frad_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_frad_chkdiana_cli.GetString("FLAGRAP"),"4",w_flgrae,Cursor_qbe_frad_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_frad_chkdiana_cli.GetDate("DATARETT")));
            /* If w_flgchk='S' */
            if (CPLib.eqr(w_flgchk,"S")) {
              /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
              Page_15();
            } else { // Else
              /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
              FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
            } // End If
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
            Cursor_mogopefbo.Next();
          }
          m_cConnectivityError = Cursor_mogopefbo.ErrorMessage();
          Cursor_mogopefbo.Close();
          // * --- End Select
        } // End If
        /* If _oldrighe=0 */
        if (CPLib.eqr(_oldrighe,0)) {
          // * --- Select from sogopefbo
          m_cServer = m_Ctx.GetServer("sogopefbo");
          m_cPhName = m_Ctx.GetPhName("sogopefbo");
          if (Cursor_sogopefbo!=null)
            Cursor_sogopefbo.Close();
          Cursor_sogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana_cli.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("sogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_sogopefbo.Eof())) {
            /* _note := w_tipinter + w_codinter+'4' + _idereg */
            _note = w_tipinter+w_codinter+"4"+_idereg;
            /* _note := _note + LRTrim(arfn_datisog_sol(sogopefbo->CODSOG,qbe_frad_chkdiana_cli->DATAREG,qbe_frad_chkdiana_cli->RAPPORTO,qbe_frad_chkdiana_cli->FLAGRAP,'4',w_flgrae,qbe_frad_chkdiana_cli->STATOREG,qbe_frad_chkdiana_cli->DATARETT)) */
            _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_sogopefbo.GetString("CODSOG"),Cursor_qbe_frad_chkdiana_cli.GetDate("DATAREG"),Cursor_qbe_frad_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_frad_chkdiana_cli.GetString("FLAGRAP"),"4",w_flgrae,Cursor_qbe_frad_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_frad_chkdiana_cli.GetDate("DATARETT")));
            /* If w_flgchk='S' */
            if (CPLib.eqr(w_flgchk,"S")) {
              /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
              Page_15();
            } else { // Else
              /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
              FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
            } // End If
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
            Cursor_sogopefbo.Next();
          }
          m_cConnectivityError = Cursor_sogopefbo.ErrorMessage();
          Cursor_sogopefbo.Close();
          // * --- End Select
        } // End If
        /* If not(Empty(qbe_frad_chkdiana_cli->CONNESBEN)) or not(Empty(qbe_frad_chkdiana_cli->C_RAG)) */
        if ( ! (CPLib.Empty(Cursor_qbe_frad_chkdiana_cli.GetString("CONNESBEN"))) ||  ! (CPLib.Empty(Cursor_qbe_frad_chkdiana_cli.GetString("C_RAG")))) {
          /* If not(Empty(qbe_frad_chkdiana_cli->C_RAG)) */
          if ( ! (CPLib.Empty(Cursor_qbe_frad_chkdiana_cli.GetString("C_RAG")))) {
            /* _note := w_tipinter + w_codinter+'5' + _idereg */
            _note = w_tipinter+w_codinter+"5"+_idereg;
            /* _note := _note + Left(LRTrim(qbe_frad_chkdiana_cli->CONNESBEN)+Space(16),16) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("CONNESBEN"))+CPLib.Space(16),16);
            /* _note := _note +Left(LRTrim(arfn_agechar(qbe_frad_chkdiana_cli->C_RAG,' '))+Space(70),70) */
            _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana_cli.GetString("C_RAG")," "))+CPLib.Space(70),70);
            /* _note := _note + Left(LRTrim(qbe_frad_chkdiana_cli->C_STA)+Space(3),3) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("C_STA"))+CPLib.Space(3),3);
            /* _note := _note +Left(LRTrim(qbe_frad_chkdiana_cli->C_CAB)+Space(6),6) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("C_CAB"))+CPLib.Space(6),6);
            /* _note := _note +Left(LRTrim(arfn_agechar(qbe_frad_chkdiana_cli->C_CTA,' '))+Space(30),30) */
            _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana_cli.GetString("C_CTA")," "))+CPLib.Space(30),30);
            /* _note := _note + Left(LRTrim(qbe_frad_chkdiana_cli->C_PRV)+Space(2),2) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("C_PRV"))+CPLib.Space(2),2);
            /* _note := _note + Left(LRTrim(arfn_agechar(qbe_frad_chkdiana_cli->C_IND,' '))+Space(35),35) */
            _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana_cli.GetString("C_IND")," "))+CPLib.Space(35),35);
            /* _note := _note + Left(LRTrim(qbe_frad_chkdiana_cli->C_CAP)+Space(5),5) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("C_CAP"))+CPLib.Space(5),5);
            /* _note := _note + Space(63) */
            _note = _note+CPLib.Space(63);
            /* _note := _note + Left(LRTrim(qbe_frad_chkdiana_cli->C_RAPPORTO)+Space(25),25) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
            /* _note := _note + Space(91) */
            _note = _note+CPLib.Space(91);
            /* If w_flgchk='S' */
            if (CPLib.eqr(w_flgchk,"S")) {
              /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
              Page_15();
            } else { // Else
              /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
              FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
            } // End If
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
            /* ElseIf not(Empty(qbe_frad_chkdiana_cli->CONNESBEN)) */
          } else if ( ! (CPLib.Empty(Cursor_qbe_frad_chkdiana_cli.GetString("CONNESBEN")))) {
            /* _numsto := arfn_chkspers(qbe_frad_chkdiana_cli->CONNESBEN,qbe_frad_chkdiana_cli->DATAREG) */
            _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana_cli.GetString("CONNESBEN"),Cursor_qbe_frad_chkdiana_cli.GetDate("DATAREG"));
            /* If Empty(LRTrim(_numsto)) */
            if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana_cli.GetString("CONNESBEN"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                /* _note := w_tipinter + w_codinter+'5' + _idereg */
                _note = w_tipinter+w_codinter+"5"+_idereg;
                /* _note := _note + Left(LRTrim(qbe_frad_chkdiana_cli->CONNESBEN)+Space(16),16) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("CONNESBEN"))+CPLib.Space(16),16);
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana_cli->C_RAG))),Left(LRTrim(arfn_agechar(qbe_frad_chkdiana_cli->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(personbo->RAGSOC,' '))+Space(70),70)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana_cli.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana_cli->C_STA))),Left(LRTrim(qbe_frad_chkdiana_cli->C_STA)+Space(3),3),Left(LRTrim(personbo->PAESE)+Space(3),3)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana_cli->C_CAB))),Left(LRTrim(qbe_frad_chkdiana_cli->C_CAB)+Space(6),6),Left(LRTrim(personbo->CODCAB)+Space(6),6)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana_cli->C_CTA))),Left(LRTrim(arfn_agechar(qbe_frad_chkdiana_cli->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(personbo->DESCCIT,' '))+Space(30),30)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana_cli.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana_cli->C_PRV))),Left(LRTrim(qbe_frad_chkdiana_cli->C_PRV)+Space(2),2),Left(LRTrim(personbo->PROVINCIA)+Space(2),2)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana_cli->C_IND))),Left(LRTrim(arfn_agechar(qbe_frad_chkdiana_cli->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(personbo->DOMICILIO,' '))+Space(35),35)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana_cli.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana_cli->C_CAP))),Left(LRTrim(qbe_frad_chkdiana_cli->C_CAP)+Space(5),5),Left(LRTrim(personbo->CAP)+Space(5),5)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5));
                /* _note := _note + Space(63) */
                _note = _note+CPLib.Space(63);
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana_cli->C_RAPPORTO))),Left(LRTrim(qbe_frad_chkdiana_cli->C_RAPPORTO)+Space(25),25),Left(LRTrim(qbe_frad_chkdiana_cli->RAPPORTBEN)+Space(25),25)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("C_RAPPORTO"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("C_RAPPORTO"))+CPLib.Space(25),25):CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("RAPPORTBEN"))+CPLib.Space(25),25));
                /* _note := _note + Space(91) */
                _note = _note+CPLib.Space(91);
                /* If w_flgchk='S' */
                if (CPLib.eqr(w_flgchk,"S")) {
                  /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                  Page_15();
                } else { // Else
                  /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                  FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                } // End If
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
            } else { // Else
              // * --- Select from wersonbo
              m_cServer = m_Ctx.GetServer("wersonbo");
              m_cPhName = m_Ctx.GetPhName("wersonbo");
              if (Cursor_wersonbo!=null)
                Cursor_wersonbo.Close();
              Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_wersonbo.Eof())) {
                /* _note := w_tipinter + w_codinter+'5' */
                _note = w_tipinter+w_codinter+"5";
                /* If Empty(LRTrim(qbe_frad_chkdiana_cli->FLAGRAP2)) */
                if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("FLAGRAP2")))) {
                  /* _note := _note + DateToChar(qbe_frad_chkdiana_cli->DATAOPE) + qbe_frad_chkdiana_cli->NUMPROG + 'S' */
                  _note = _note+CPLib.DateToChar(Cursor_qbe_frad_chkdiana_cli.GetDate("DATAOPE"))+Cursor_qbe_frad_chkdiana_cli.GetString("NUMPROG")+"S";
                } else { // Else
                  /* _note := _note + qbe_frad_chkdiana_cli->IDEREG */
                  _note = _note+Cursor_qbe_frad_chkdiana_cli.GetString("IDEREG");
                } // End If
                /* _note := _note + Left(LRTrim(qbe_frad_chkdiana_cli->CONNESBEN)+Space(16),16) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("CONNESBEN"))+CPLib.Space(16),16);
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana_cli->C_RAG))),Left(LRTrim(arfn_agechar(qbe_frad_chkdiana_cli->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(wersonbo->RAGSOC,' '))+Space(70),70)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana_cli.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana_cli->C_STA))),Left(LRTrim(qbe_frad_chkdiana_cli->C_STA)+Space(3),3),Left(LRTrim(wersonbo->PAESE)+Space(3),3)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PAESE"))+CPLib.Space(3),3));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana_cli->C_CAB))),Left(LRTrim(qbe_frad_chkdiana_cli->C_CAB)+Space(6),6),Left(LRTrim(wersonbo->CODCAB)+Space(6),6)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CODCAB"))+CPLib.Space(6),6));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana_cli->C_CTA))),Left(LRTrim(arfn_agechar(qbe_frad_chkdiana_cli->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(wersonbo->DESCCIT,' '))+Space(30),30)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana_cli.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana_cli->C_PRV))),Left(LRTrim(qbe_frad_chkdiana_cli->C_PRV)+Space(2),2),Left(LRTrim(wersonbo->PROVINCIA)+Space(2),2)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana_cli->C_IND))),Left(LRTrim(arfn_agechar(qbe_frad_chkdiana_cli->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(wersonbo->DOMICILIO,' '))+Space(35),35)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana_cli.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana_cli->C_CAP))),Left(LRTrim(qbe_frad_chkdiana_cli->C_CAP)+Space(5),5),Left(LRTrim(wersonbo->CAP)+Space(5),5)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CAP"))+CPLib.Space(5),5));
                /* _note := _note + Space(63) */
                _note = _note+CPLib.Space(63);
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana_cli->C_RAPPORTO))),Left(LRTrim(qbe_frad_chkdiana_cli->C_RAPPORTO)+Space(25),25),Left(LRTrim(qbe_frad_chkdiana_cli->RAPPORTBEN)+Space(25),25)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("C_RAPPORTO"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("C_RAPPORTO"))+CPLib.Space(25),25):CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("RAPPORTBEN"))+CPLib.Space(25),25));
                /* _note := _note + Space(91) */
                _note = _note+CPLib.Space(91);
                /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_wersonbo.Next();
              }
              m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
              Cursor_wersonbo.Close();
              // * --- End Select
            } // End If
          } // End If
        } // End If
        /* _oldrighe := 0 */
        _oldrighe = CPLib.Round(0,0);
        /* If qbe_frad_chkdiana_cli->STATOREG='3' */
        if (CPLib.eqr(Cursor_qbe_frad_chkdiana_cli.GetString("STATOREG"),"3")) {
          // * --- Select from meneficfrz
          m_cServer = m_Ctx.GetServer("meneficfrz");
          m_cPhName = m_Ctx.GetPhName("meneficfrz");
          if (Cursor_meneficfrz!=null)
            Cursor_meneficfrz.Close();
          Cursor_meneficfrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana_cli.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("meneficfrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_meneficfrz.Eof())) {
            /* _oldrighe := 1 */
            _oldrighe = CPLib.Round(1,0);
            /* If Empty(LRTrim(meneficfrz->CODSOG)) and not(Empty(LRTrim(meneficfrz->C_RAG))) */
            if (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("CODSOG"))) &&  ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_RAG"))))) {
              /* _note := w_tipinter + w_codinter+'5' + _idereg */
              _note = w_tipinter+w_codinter+"5"+_idereg;
              /* _note := _note + Left(LRTrim(meneficfrz->CODSOG)+Space(16),16) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("CODSOG"))+CPLib.Space(16),16);
              /* _note := _note +Left(LRTrim(arfn_agechar(meneficfrz->C_RAG,' '))+Space(70),70) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficfrz.GetString("C_RAG")," "))+CPLib.Space(70),70);
              /* _note := _note + Left(LRTrim(meneficfrz->C_STA)+Space(3),3) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_STA"))+CPLib.Space(3),3);
              /* _note := _note +Left(LRTrim(meneficfrz->C_CAB)+Space(6),6) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_CAB"))+CPLib.Space(6),6);
              /* _note := _note +Left(LRTrim(arfn_agechar(meneficfrz->C_CTA,' '))+Space(30),30) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficfrz.GetString("C_CTA")," "))+CPLib.Space(30),30);
              /* _note := _note + Left(LRTrim(meneficfrz->C_PRV)+Space(2),2) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_PRV"))+CPLib.Space(2),2);
              /* _note := _note + Left(LRTrim(arfn_agechar(meneficfrz->C_IND,' '))+Space(35),35) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficfrz.GetString("C_IND")," "))+CPLib.Space(35),35);
              /* _note := _note + Left(LRTrim(meneficfrz->C_CAP)+Space(5),5) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_CAP"))+CPLib.Space(5),5);
              /* _note := _note + Space(63) */
              _note = _note+CPLib.Space(63);
              /* _note := _note + Left(LRTrim(meneficfrz->C_RAPPORTO)+Space(25),25) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
              /* _note := _note + Space(91) */
              _note = _note+CPLib.Space(91);
              /* If w_flgchk='S' */
              if (CPLib.eqr(w_flgchk,"S")) {
                /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                Page_15();
              } else { // Else
                /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
              } // End If
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
            } else { // Else
              /* _numsto := arfn_chkspers(meneficfrz->CODSOG,qbe_frad_chkdiana_cli->DATAREG) */
              _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_meneficfrz.GetString("CODSOG"),Cursor_qbe_frad_chkdiana_cli.GetDate("DATAREG"));
              /* If Empty(LRTrim(_numsto)) */
              if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_meneficfrz.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* _note := w_tipinter + w_codinter+'5' + _idereg */
                  _note = w_tipinter+w_codinter+"5"+_idereg;
                  /* _note := _note + Left(LRTrim(meneficfrz->CODSOG)+Space(16),16) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("CODSOG"))+CPLib.Space(16),16);
                  /* _note := _note + iif(not(Empty(LRTrim(meneficfrz->C_RAG))),Left(LRTrim(arfn_agechar(meneficfrz->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(personbo->RAGSOC,' '))+Space(70),70)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficfrz.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                  /* _note := _note + iif(not(Empty(LRTrim(meneficfrz->C_STA))),Left(LRTrim(meneficfrz->C_STA)+Space(3),3),Left(LRTrim(personbo->PAESE)+Space(3),3)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3));
                  /* _note := _note + iif(not(Empty(LRTrim(meneficfrz->C_CAB))),Left(LRTrim(meneficfrz->C_CAB)+Space(6),6),Left(LRTrim(personbo->CODCAB)+Space(6),6)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6));
                  /* _note := _note + iif(not(Empty(LRTrim(meneficfrz->C_CTA))),Left(LRTrim(arfn_agechar(meneficfrz->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(personbo->DESCCIT,' '))+Space(30),30)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficfrz.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                  /* _note := _note + iif(not(Empty(LRTrim(meneficfrz->C_PRV))),Left(LRTrim(meneficfrz->C_PRV)+Space(2),2),Left(LRTrim(personbo->PROVINCIA)+Space(2),2)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                  /* _note := _note + iif(not(Empty(LRTrim(meneficfrz->C_IND))),Left(LRTrim(arfn_agechar(meneficfrz->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(personbo->DOMICILIO,' '))+Space(35),35)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficfrz.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                  /* _note := _note + iif(not(Empty(LRTrim(meneficfrz->C_CAP))),Left(LRTrim(meneficfrz->C_CAP)+Space(5),5),Left(LRTrim(personbo->CAP)+Space(5),5)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5));
                  /* _note := _note + Space(63) */
                  _note = _note+CPLib.Space(63);
                  /* _note := _note +Left(LRTrim(meneficfrz->C_RAPPORTO)+Space(25),25) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                  /* _note := _note + Space(91) */
                  _note = _note+CPLib.Space(91);
                  /* If w_flgchk='S' */
                  if (CPLib.eqr(w_flgchk,"S")) {
                    /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                    Page_15();
                  } else { // Else
                    /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                    FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                  } // End If
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } else { // Else
                // * --- Select from wersonbo
                m_cServer = m_Ctx.GetServer("wersonbo");
                m_cPhName = m_Ctx.GetPhName("wersonbo");
                if (Cursor_wersonbo!=null)
                  Cursor_wersonbo.Close();
                Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_wersonbo.Eof())) {
                  /* _note := w_tipinter + w_codinter+'5' */
                  _note = w_tipinter+w_codinter+"5";
                  /* If Empty(LRTrim(qbe_frad_chkdiana_cli->FLAGRAP2)) */
                  if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("FLAGRAP2")))) {
                    /* _note := _note + DateToChar(qbe_frad_chkdiana_cli->DATAOPE) + qbe_frad_chkdiana_cli->NUMPROG + 'S' */
                    _note = _note+CPLib.DateToChar(Cursor_qbe_frad_chkdiana_cli.GetDate("DATAOPE"))+Cursor_qbe_frad_chkdiana_cli.GetString("NUMPROG")+"S";
                  } else { // Else
                    /* _note := _note + qbe_frad_chkdiana_cli->IDEREG */
                    _note = _note+Cursor_qbe_frad_chkdiana_cli.GetString("IDEREG");
                  } // End If
                  /* _note := _note + Left(LRTrim(meneficfrz->CODSOG)+Space(16),16) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("CODSOG"))+CPLib.Space(16),16);
                  /* _note := _note + iif(not(Empty(LRTrim(meneficfrz->C_RAG))),Left(LRTrim(arfn_agechar(meneficfrz->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(wersonbo->RAGSOC,' '))+Space(70),70)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficfrz.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                  /* _note := _note + iif(not(Empty(LRTrim(meneficfrz->C_STA))),Left(LRTrim(meneficfrz->C_STA)+Space(3),3),Left(LRTrim(wersonbo->PAESE)+Space(3),3)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PAESE"))+CPLib.Space(3),3));
                  /* _note := _note + iif(not(Empty(LRTrim(meneficfrz->C_CAB))),Left(LRTrim(meneficfrz->C_CAB)+Space(6),6),Left(LRTrim(wersonbo->CODCAB)+Space(6),6)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CODCAB"))+CPLib.Space(6),6));
                  /* _note := _note + iif(not(Empty(LRTrim(meneficfrz->C_CTA))),Left(LRTrim(arfn_agechar(meneficfrz->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(wersonbo->DESCCIT,' '))+Space(30),30)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficfrz.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                  /* _note := _note + iif(not(Empty(LRTrim(meneficfrz->C_PRV))),Left(LRTrim(meneficfrz->C_PRV)+Space(2),2),Left(LRTrim(wersonbo->PROVINCIA)+Space(2),2)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                  /* _note := _note + iif(not(Empty(LRTrim(meneficfrz->C_IND))),Left(LRTrim(arfn_agechar(meneficfrz->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(wersonbo->DOMICILIO,' '))+Space(35),35)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficfrz.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                  /* _note := _note + iif(not(Empty(LRTrim(meneficfrz->C_CAP))),Left(LRTrim(meneficfrz->C_CAP)+Space(5),5),Left(LRTrim(wersonbo->CAP)+Space(5),5)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CAP"))+CPLib.Space(5),5));
                  /* _note := _note + Space(63) */
                  _note = _note+CPLib.Space(63);
                  /* _note := _note +Left(LRTrim(meneficfrz->C_RAPPORTO)+Space(25),25) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                  /* _note := _note + Space(91) */
                  _note = _note+CPLib.Space(91);
                  /* If w_flgchk='S' */
                  if (CPLib.eqr(w_flgchk,"S")) {
                    /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                    Page_15();
                  } else { // Else
                    /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                    FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                  } // End If
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_wersonbo.Next();
                }
                m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                Cursor_wersonbo.Close();
                // * --- End Select
              } // End If
            } // End If
            Cursor_meneficfrz.Next();
          }
          m_cConnectivityError = Cursor_meneficfrz.ErrorMessage();
          Cursor_meneficfrz.Close();
          // * --- End Select
        } // End If
        /* If _oldrighe=0 */
        if (CPLib.eqr(_oldrighe,0)) {
          // * --- Select from beneficfrz
          m_cServer = m_Ctx.GetServer("beneficfrz");
          m_cPhName = m_Ctx.GetPhName("beneficfrz");
          if (Cursor_beneficfrz!=null)
            Cursor_beneficfrz.Close();
          Cursor_beneficfrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana_cli.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("beneficfrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_beneficfrz.Eof())) {
            /* If Empty(LRTrim(beneficfrz->CODSOG)) and not(Empty(LRTrim(beneficfrz->C_RAG))) */
            if (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("CODSOG"))) &&  ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_RAG"))))) {
              /* _note := w_tipinter + w_codinter+'5' + _idereg */
              _note = w_tipinter+w_codinter+"5"+_idereg;
              /* _note := _note + Left(LRTrim(beneficfrz->CODSOG)+Space(16),16) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("CODSOG"))+CPLib.Space(16),16);
              /* _note := _note +Left(LRTrim(arfn_agechar(beneficfrz->C_RAG,' '))+Space(70),70) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficfrz.GetString("C_RAG")," "))+CPLib.Space(70),70);
              /* _note := _note + Left(LRTrim(beneficfrz->C_STA)+Space(3),3) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_STA"))+CPLib.Space(3),3);
              /* _note := _note +Left(LRTrim(beneficfrz->C_CAB)+Space(6),6) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_CAB"))+CPLib.Space(6),6);
              /* _note := _note +Left(LRTrim(arfn_agechar(beneficfrz->C_CTA,' '))+Space(30),30) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficfrz.GetString("C_CTA")," "))+CPLib.Space(30),30);
              /* _note := _note + Left(LRTrim(beneficfrz->C_PRV)+Space(2),2) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_PRV"))+CPLib.Space(2),2);
              /* _note := _note + Left(LRTrim(arfn_agechar(beneficfrz->C_IND,' '))+Space(35),35) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficfrz.GetString("C_IND")," "))+CPLib.Space(35),35);
              /* _note := _note + Left(LRTrim(beneficfrz->C_CAP)+Space(5),5) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_CAP"))+CPLib.Space(5),5);
              /* _note := _note + Space(63) */
              _note = _note+CPLib.Space(63);
              /* _note := _note + Left(LRTrim(beneficfrz->C_RAPPORTO)+Space(25),25) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
              /* _note := _note + Space(91) */
              _note = _note+CPLib.Space(91);
              /* If w_flgchk='S' */
              if (CPLib.eqr(w_flgchk,"S")) {
                /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                Page_15();
              } else { // Else
                /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
              } // End If
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
            } else { // Else
              /* _numsto := arfn_chkspers(beneficfrz->CODSOG,qbe_frad_chkdiana_cli->DATAREG) */
              _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_beneficfrz.GetString("CODSOG"),Cursor_qbe_frad_chkdiana_cli.GetDate("DATAREG"));
              /* If Empty(LRTrim(_numsto)) */
              if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_beneficfrz.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* _note := w_tipinter + w_codinter+'5' + _idereg */
                  _note = w_tipinter+w_codinter+"5"+_idereg;
                  /* _note := _note + Left(LRTrim(beneficfrz->CODSOG)+Space(16),16) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("CODSOG"))+CPLib.Space(16),16);
                  /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_RAG))),Left(LRTrim(arfn_agechar(beneficfrz->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(personbo->RAGSOC,' '))+Space(70),70)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficfrz.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                  /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_STA))),Left(LRTrim(beneficfrz->C_STA)+Space(3),3),Left(LRTrim(personbo->PAESE)+Space(3),3)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3));
                  /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_CAB))),Left(LRTrim(beneficfrz->C_CAB)+Space(6),6),Left(LRTrim(personbo->CODCAB)+Space(6),6)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6));
                  /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_CTA))),Left(LRTrim(arfn_agechar(beneficfrz->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(personbo->DESCCIT,' '))+Space(30),30)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficfrz.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                  /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_PRV))),Left(LRTrim(beneficfrz->C_PRV)+Space(2),2),Left(LRTrim(personbo->PROVINCIA)+Space(2),2)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                  /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_IND))),Left(LRTrim(arfn_agechar(beneficfrz->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(personbo->DOMICILIO,' '))+Space(35),35)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficfrz.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                  /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_CAP))),Left(LRTrim(beneficfrz->C_CAP)+Space(5),5),Left(LRTrim(personbo->CAP)+Space(5),5)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5));
                  /* _note := _note + Space(63) */
                  _note = _note+CPLib.Space(63);
                  /* _note := _note +Left(LRTrim(beneficfrz->C_RAPPORTO)+Space(25),25) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                  /* _note := _note + Space(91) */
                  _note = _note+CPLib.Space(91);
                  /* If w_flgchk='S' */
                  if (CPLib.eqr(w_flgchk,"S")) {
                    /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                    Page_15();
                  } else { // Else
                    /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                    FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                  } // End If
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } else { // Else
                // * --- Select from wersonbo
                m_cServer = m_Ctx.GetServer("wersonbo");
                m_cPhName = m_Ctx.GetPhName("wersonbo");
                if (Cursor_wersonbo!=null)
                  Cursor_wersonbo.Close();
                Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_wersonbo.Eof())) {
                  /* _note := w_tipinter + w_codinter+'5' */
                  _note = w_tipinter+w_codinter+"5";
                  /* If Empty(LRTrim(qbe_frad_chkdiana_cli->FLAGRAP2)) */
                  if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli.GetString("FLAGRAP2")))) {
                    /* _note := _note + DateToChar(qbe_frad_chkdiana_cli->DATAOPE) + qbe_frad_chkdiana_cli->NUMPROG + 'S' */
                    _note = _note+CPLib.DateToChar(Cursor_qbe_frad_chkdiana_cli.GetDate("DATAOPE"))+Cursor_qbe_frad_chkdiana_cli.GetString("NUMPROG")+"S";
                  } else { // Else
                    /* _note := _note + qbe_frad_chkdiana_cli->IDEREG */
                    _note = _note+Cursor_qbe_frad_chkdiana_cli.GetString("IDEREG");
                  } // End If
                  /* _note := _note + Left(LRTrim(beneficfrz->CODSOG)+Space(16),16) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("CODSOG"))+CPLib.Space(16),16);
                  /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_RAG))),Left(LRTrim(arfn_agechar(beneficfrz->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(wersonbo->RAGSOC,' '))+Space(70),70)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficfrz.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                  /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_STA))),Left(LRTrim(beneficfrz->C_STA)+Space(3),3),Left(LRTrim(wersonbo->PAESE)+Space(3),3)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PAESE"))+CPLib.Space(3),3));
                  /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_CAB))),Left(LRTrim(beneficfrz->C_CAB)+Space(6),6),Left(LRTrim(wersonbo->CODCAB)+Space(6),6)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CODCAB"))+CPLib.Space(6),6));
                  /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_CTA))),Left(LRTrim(arfn_agechar(beneficfrz->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(wersonbo->DESCCIT,' '))+Space(30),30)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficfrz.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                  /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_PRV))),Left(LRTrim(beneficfrz->C_PRV)+Space(2),2),Left(LRTrim(wersonbo->PROVINCIA)+Space(2),2)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                  /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_IND))),Left(LRTrim(arfn_agechar(beneficfrz->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(wersonbo->DOMICILIO,' '))+Space(35),35)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficfrz.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                  /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_CAP))),Left(LRTrim(beneficfrz->C_CAP)+Space(5),5),Left(LRTrim(wersonbo->CAP)+Space(5),5)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CAP"))+CPLib.Space(5),5));
                  /* _note := _note + Space(63) */
                  _note = _note+CPLib.Space(63);
                  /* _note := _note +Left(LRTrim(beneficfrz->C_RAPPORTO)+Space(25),25) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                  /* _note := _note + Space(91) */
                  _note = _note+CPLib.Space(91);
                  /* If w_flgchk='S' */
                  if (CPLib.eqr(w_flgchk,"S")) {
                    /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                    Page_15();
                  } else { // Else
                    /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                    FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                  } // End If
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_wersonbo.Next();
                }
                m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                Cursor_wersonbo.Close();
                // * --- End Select
              } // End If
            } // End If
            Cursor_beneficfrz.Next();
          }
          m_cConnectivityError = Cursor_beneficfrz.ErrorMessage();
          Cursor_beneficfrz.Close();
          // * --- End Select
        } // End If
        /* If not(Empty(qbe_frad_chkdiana_cli->CONNALTRO)) */
        if ( ! (CPLib.Empty(Cursor_qbe_frad_chkdiana_cli.GetString("CONNALTRO")))) {
          /* _note := w_tipinter + w_codinter+'6' + _idereg */
          _note = w_tipinter+w_codinter+"6"+_idereg;
          /* _note := _note + LRTrim(arfn_datisog_sol(qbe_frad_chkdiana_cli->CONNALTRO,qbe_frad_chkdiana_cli->DATAREG,qbe_frad_chkdiana_cli->RAPPORTO,qbe_frad_chkdiana_cli->FLAGRAP,'6',w_flgrae,qbe_frad_chkdiana_cli->STATOREG,qbe_frad_chkdiana_cli->DATARETT)) */
          _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana_cli.GetString("CONNALTRO"),Cursor_qbe_frad_chkdiana_cli.GetDate("DATAREG"),Cursor_qbe_frad_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_frad_chkdiana_cli.GetString("FLAGRAP"),"6",w_flgrae,Cursor_qbe_frad_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_frad_chkdiana_cli.GetDate("DATARETT")));
          /* If w_flgchk='S' */
          if (CPLib.eqr(w_flgchk,"S")) {
            /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
            Page_15();
          } else { // Else
            /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
            FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
          } // End If
          /* nTotRec := nTotRec + 1 */
          nTotRec = CPLib.Round(nTotRec+1,0);
          /* nNumRec := nNumRec + 1 */
          nNumRec = CPLib.Round(nNumRec+1,0);
        } // End If
        /* _oldrighe := 0 */
        _oldrighe = CPLib.Round(0,0);
        /* If qbe_frad_chkdiana_cli->STATOREG='3' */
        if (CPLib.eqr(Cursor_qbe_frad_chkdiana_cli.GetString("STATOREG"),"3")) {
          // * --- Select from merzistifrz
          m_cServer = m_Ctx.GetServer("merzistifrz");
          m_cPhName = m_Ctx.GetPhName("merzistifrz");
          if (Cursor_merzistifrz!=null)
            Cursor_merzistifrz.Close();
          Cursor_merzistifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana_cli.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("merzistifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_merzistifrz.Eof())) {
            /* _note := w_tipinter + w_codinter+'6' + _idereg */
            _note = w_tipinter+w_codinter+"6"+_idereg;
            /* _note := _note + LRTrim(arfn_datisog_sol(merzistifrz->CODSOG,qbe_frad_chkdiana_cli->DATAREG,qbe_frad_chkdiana_cli->RAPPORTO,qbe_frad_chkdiana_cli->FLAGRAP,'6',w_flgrae,qbe_frad_chkdiana_cli->STATOREG,qbe_frad_chkdiana_cli->DATARETT)) */
            _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_merzistifrz.GetString("CODSOG"),Cursor_qbe_frad_chkdiana_cli.GetDate("DATAREG"),Cursor_qbe_frad_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_frad_chkdiana_cli.GetString("FLAGRAP"),"6",w_flgrae,Cursor_qbe_frad_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_frad_chkdiana_cli.GetDate("DATARETT")));
            /* If w_flgchk='S' */
            if (CPLib.eqr(w_flgchk,"S")) {
              /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
              Page_15();
            } else { // Else
              /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
              FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
            } // End If
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
            Cursor_merzistifrz.Next();
          }
          m_cConnectivityError = Cursor_merzistifrz.ErrorMessage();
          Cursor_merzistifrz.Close();
          // * --- End Select
        } // End If
        /* If _oldrighe=0 */
        if (CPLib.eqr(_oldrighe,0)) {
          // * --- Select from terzistifrz
          m_cServer = m_Ctx.GetServer("terzistifrz");
          m_cPhName = m_Ctx.GetPhName("terzistifrz");
          if (Cursor_terzistifrz!=null)
            Cursor_terzistifrz.Close();
          Cursor_terzistifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana_cli.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("terzistifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_terzistifrz.Eof())) {
            /* _note := w_tipinter + w_codinter+'6' + _idereg */
            _note = w_tipinter+w_codinter+"6"+_idereg;
            /* _note := _note + LRTrim(arfn_datisog_sol(terzistifrz->CODSOG,qbe_frad_chkdiana_cli->DATAREG,qbe_frad_chkdiana_cli->RAPPORTO,qbe_frad_chkdiana_cli->FLAGRAP,'6',w_flgrae,qbe_frad_chkdiana_cli->STATOREG,qbe_frad_chkdiana_cli->DATARETT)) */
            _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_terzistifrz.GetString("CODSOG"),Cursor_qbe_frad_chkdiana_cli.GetDate("DATAREG"),Cursor_qbe_frad_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_frad_chkdiana_cli.GetString("FLAGRAP"),"6",w_flgrae,Cursor_qbe_frad_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_frad_chkdiana_cli.GetDate("DATARETT")));
            /* If w_flgchk='S' */
            if (CPLib.eqr(w_flgchk,"S")) {
              /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
              Page_15();
            } else { // Else
              /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
              FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
            } // End If
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
            Cursor_terzistifrz.Next();
          }
          m_cConnectivityError = Cursor_terzistifrz.ErrorMessage();
          Cursor_terzistifrz.Close();
          // * --- End Select
        } // End If
        /* gNumRec := nTotRec // N� Record DIANA */
        gNumRec = CPLib.Round(nTotRec,0);
        m_Ctx.SetGlobalNumber("gNumRec",gNumRec);
        /* gNumReg := nTotReg // N� Registrazioni DIANA */
        gNumReg = CPLib.Round(nTotReg,0);
        m_Ctx.SetGlobalNumber("gNumReg",gNumReg);
        Cursor_qbe_frad_chkdiana_cli.Next();
      }
      m_cConnectivityError = Cursor_qbe_frad_chkdiana_cli.ErrorMessage();
      Cursor_qbe_frad_chkdiana_cli.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_frad_chkdiana_cli!=null)
          Cursor_qbe_frad_chkdiana_cli.Close();
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
        if (Read_Cursor!=null)
          Read_Cursor.Close();
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
        if (Cursor_kersonbo!=null)
          Cursor_kersonbo.Close();
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
        if (Cursor_mlientifrz!=null)
          Cursor_mlientifrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_clientifrz!=null)
          Cursor_clientifrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_mogopefbo!=null)
          Cursor_mogopefbo.Close();
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
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_meneficfrz!=null)
          Cursor_meneficfrz.Close();
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
        if (Cursor_merzistifrz!=null)
          Cursor_merzistifrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_terzistifrz!=null)
          Cursor_terzistifrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_14() throws Exception {
    CPResultSet Cursor_qbe_frap_chkdiana_cli=null;
    CPResultSet Cursor_anarapbo=null;
    CPResultSet Cursor_xnarapbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_anadip=null;
    CPResultSet Cursor_kersonbo=null;
    CPResultSet Cursor_knarapbo=null;
    CPResultSet Cursor_xntestbo=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_xlientifrz=null;
    CPResultSet Cursor_xogopefbo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_xeneficfrz=null;
    CPResultSet Cursor_xerzistifrz=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Cicla sulle frazionate provvisorie di uno specifico cliente */
      /* gMsgImp := 'Verifica Frazionate Provvisorie del cliente da elaborare ...' // Messaggio Import */
      gMsgImp = "Verifica Frazionate Provvisorie del cliente da elaborare ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* _conta := _conta + 1 */
      _conta = CPLib.Round(_conta+1,0);
      // * --- Select from qbe_frap_chkdiana_cli
      SPBridge.HMCaller _hEQWYTISWLV;
      _hEQWYTISWLV = new SPBridge.HMCaller();
      _hEQWYTISWLV.Set("m_cVQRList",m_cVQRList);
      _hEQWYTISWLV.Set("cdadata",w_cdadata);
      _hEQWYTISWLV.Set("c_adata",w_c_adata);
      _hEQWYTISWLV.Set("codage",w_codage);
      _hEQWYTISWLV.Set("codcli",w_codcli);
      _hEQWYTISWLV.Set("ragben",w_ragben);
      if (Cursor_qbe_frap_chkdiana_cli!=null)
        Cursor_qbe_frap_chkdiana_cli.Close();
      Cursor_qbe_frap_chkdiana_cli = new VQRHolder("qbe_frap_chkdiana_cli",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_hEQWYTISWLV,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_frap_chkdiana_cli.Eof())) {
        /* _ctotale := _ctotale + 1 */
        _ctotale = CPLib.Round(_ctotale+1,0);
        /* gMsgImp := 'Elaborazione Frazionata N.: '+LRTrim(Str(_ctotale,15,0)) // Messaggio Import */
        gMsgImp = "Elaborazione Frazionata N.: "+CPLib.LRTrim(CPLib.Str(_ctotale,15,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If Empty(LRTrim(qbe_frap_chkdiana_cli->FLAGRAP2)) */
        if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("FLAGRAP2")))) {
          /* _idereg := DateToChar(qbe_frap_chkdiana_cli->DATAOPE) + "F" + Right(qbe_frap_chkdiana_cli->NUMPROG,10) + 'S' */
          _idereg = CPLib.DateToChar(Cursor_qbe_frap_chkdiana_cli.GetDate("DATAOPE"))+"F"+CPLib.Right(Cursor_qbe_frap_chkdiana_cli.GetString("NUMPROG"),10)+"S";
        } else { // Else
          /* _idereg := Left(qbe_frap_chkdiana_cli->IDEREG,8) + "F" + Right(qbe_frap_chkdiana_cli->IDEREG,11) */
          _idereg = CPLib.Left(Cursor_qbe_frap_chkdiana_cli.GetString("IDEREG"),8)+"F"+CPLib.Right(Cursor_qbe_frap_chkdiana_cli.GetString("IDEREG"),11);
        } // End If
        /* _note := w_tipinter + w_codinter + '1' + _idereg */
        _note = w_tipinter+w_codinter+"1"+_idereg;
        /* _flagrap := '' */
        _flagrap = "";
        // * --- Select from anarapbo
        m_cServer = m_Ctx.GetServer("anarapbo");
        m_cPhName = m_Ctx.GetPhName("anarapbo");
        if (Cursor_anarapbo!=null)
          Cursor_anarapbo.Close();
        Cursor_anarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select TIPORAP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_frap_chkdiana_cli.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("anarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_anarapbo.Eof())) {
          /* _flagrap := anarapbo->TIPORAP */
          _flagrap = Cursor_anarapbo.GetString("TIPORAP");
          Cursor_anarapbo.Next();
        }
        m_cConnectivityError = Cursor_anarapbo.ErrorMessage();
        Cursor_anarapbo.Close();
        // * --- End Select
        /* If Empty(LRTrim(_flagrap)) */
        if (CPLib.Empty(CPLib.LRTrim(_flagrap))) {
          // * --- Select from xnarapbo
          m_cServer = m_Ctx.GetServer("xnarapbo");
          m_cPhName = m_Ctx.GetPhName("xnarapbo");
          if (Cursor_xnarapbo!=null)
            Cursor_xnarapbo.Close();
          Cursor_xnarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select TIPORAP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_frap_chkdiana_cli.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xnarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_xnarapbo.Eof())) {
            /* _flagrap := anarapbo->TIPORAP */
            _flagrap = Cursor_anarapbo.GetString("TIPORAP");
            Cursor_xnarapbo.Next();
          }
          m_cConnectivityError = Cursor_xnarapbo.ErrorMessage();
          Cursor_xnarapbo.Close();
          // * --- End Select
          /* _flagrap := iif(Empty(LRTrim(_flagrap)),qbe_frap_chkdiana_cli->FLAGRAP,_flagrap) */
          _flagrap = (CPLib.Empty(CPLib.LRTrim(_flagrap))?Cursor_qbe_frap_chkdiana_cli.GetString("FLAGRAP"):_flagrap);
        } // End If
        /* If Empty(qbe_frap_chkdiana_cli->CODDIPE) */
        if (CPLib.Empty(Cursor_qbe_frap_chkdiana_cli.GetString("CODDIPE"))) {
          // * --- Read from intermbo
          m_cServer = m_Ctx.GetServer("intermbo");
          m_cPhName = m_Ctx.GetPhName("intermbo");
          m_cSql = "";
          m_cSql = m_cSql+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codinter,"C",11,0,m_cServer),m_cServer,w_codinter);
          if (m_Ctx.IsSharedTemp("intermbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODCAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODDIPE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            w_codcab = Read_Cursor.GetString("CODCAB");
            w_desccit = Read_Cursor.GetString("DESCCIT");
            w_provin = Read_Cursor.GetString("PROVINCIA");
            w_coddipe = Read_Cursor.GetString("CODDIPE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on intermbo into routine arrt_chkdiana_old returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            w_codcab = "";
            w_desccit = "";
            w_provin = "";
            w_coddipe = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(w_coddipe) */
          if (CPLib.Empty(w_coddipe)) {
            /* _note := _note + '000000' + Left(LRTrim(w_codcab)+Space(6),6) + Left(LRTrim(w_desccit)+Space(30),30) + Left(LRTrim(w_provin)+Space(2),2) */
            _note = _note+"000000"+CPLib.Left(CPLib.LRTrim(w_codcab)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(w_desccit)+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(w_provin)+CPLib.Space(2),2);
          } else { // Else
            /* _note := _note + w_coddipe */
            _note = _note+w_coddipe;
            // * --- Read from anadip
            m_cServer = m_Ctx.GetServer("anadip");
            m_cPhName = m_Ctx.GetPhName("anadip");
            m_cSql = "";
            m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_coddipe,"C",6,0,m_cServer),m_cServer,w_coddipe);
            if (m_Ctx.IsSharedTemp("anadip")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              w_cabcod = Read_Cursor.GetString("CAB");
              w_citdesc = Read_Cursor.GetString("DESCCIT");
              w_provind = Read_Cursor.GetString("PROVINCIA");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on anadip into routine arrt_chkdiana_old returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              w_cabcod = "";
              w_citdesc = "";
              w_provind = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(w_cabcod) */
            if (CPLib.Empty(w_cabcod)) {
              /* _note := _note + Left(LRTrim(w_codcab)+Space(6),6) + Left(LRTrim(w_desccit)+Space(30),30) + Left(LRTrim(w_provin)+Space(2),2) */
              _note = _note+CPLib.Left(CPLib.LRTrim(w_codcab)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(w_desccit)+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(w_provin)+CPLib.Space(2),2);
            } else { // Else
              /* _note := _note + Left(LRTrim(w_cabcod)+Space(6),6) + Left(LRTrim(w_citdesc)+Space(30),30) + Left(LRTrim(w_provind)+Space(2),2) */
              _note = _note+CPLib.Left(CPLib.LRTrim(w_cabcod)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(w_citdesc)+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(w_provind)+CPLib.Space(2),2);
            } // End If
          } // End If
        } else { // Else
          // * --- Select from anadip
          m_cServer = m_Ctx.GetServer("anadip");
          m_cPhName = m_Ctx.GetPhName("anadip");
          if (Cursor_anadip!=null)
            Cursor_anadip.Close();
          Cursor_anadip = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODDIP="+CPLib.ToSQL(Cursor_qbe_frap_chkdiana_cli.GetString("CODDIPE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("anadip")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_anadip.Eof())) {
            /* _note := _note + qbe_frap_chkdiana_cli->CODDIPE + Left(LRTrim(anadip->CAB)+Space(6),6) + Left(LRTrim(anadip->DESCCIT)+Space(30),30) + Left(LRTrim(anadip->PROVINCIA)+Space(2),2) */
            _note = _note+Cursor_qbe_frap_chkdiana_cli.GetString("CODDIPE")+CPLib.Left(CPLib.LRTrim(Cursor_anadip.GetString("CAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_anadip.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_anadip.GetString("PROVINCIA"))+CPLib.Space(2),2);
            Cursor_anadip.Next();
          }
          m_cConnectivityError = Cursor_anadip.ErrorMessage();
          Cursor_anadip.Close();
          // * --- End Select
        } // End If
        /* _note := _note + Left(DateToChar(qbe_frap_chkdiana_cli->DATAOPE)+Space(8),8) + Left(LRTrim(qbe_frap_chkdiana_cli->FLAGFRAZ)+" ",1) + Left(LRTrim(qbe_frap_chkdiana_cli->FLAGCONT)+" ",1) */
        _note = _note+CPLib.Left(CPLib.DateToChar(Cursor_qbe_frap_chkdiana_cli.GetDate("DATAOPE"))+CPLib.Space(8),8)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("FLAGFRAZ"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("FLAGCONT"))+" ",1);
        /* _note := _note + Left(LRTrim(qbe_frap_chkdiana_cli->CODANA)+Space(4),4) + Left(LRTrim(qbe_frap_chkdiana_cli->CODVOC)+Space(2),2) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("CODANA"))+CPLib.Space(4),4)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("CODVOC"))+CPLib.Space(2),2);
        /* _note := _note + Left(LRTrim(qbe_frap_chkdiana_cli->TIPOINT2)+Space(2),2) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("TIPOINT2"))+CPLib.Space(2),2);
        /* _note := _note + iif(Empty(LRTrim(qbe_frap_chkdiana_cli->CODFISCICP)),Left(LRTrim(qbe_frap_chkdiana_cli->CODINT2)+Space(11),11),Left(LRTrim(qbe_frap_chkdiana_cli->CODFISCICP)+Space(11),11)) */
        _note = _note+(CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("CODFISCICP")))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("CODINT2"))+CPLib.Space(11),11):CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("CODFISCICP"))+CPLib.Space(11),11));
        /* _note := _note + Left(LRTrim(qbe_frap_chkdiana_cli->PAESE)+Space(3),3) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("PAESE"))+CPLib.Space(3),3);
        /* _note := _note + Left(LRTrim(qbe_frap_chkdiana_cli->CODCAB2)+Space(6),6) + Left(LRTrim(arfn_agechar(qbe_frap_chkdiana_cli->DESC2,' '))+Space(30),30) + Left(LRTrim(qbe_frap_chkdiana_cli->PROV2)+Space(2),2) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("CODCAB2"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frap_chkdiana_cli.GetString("DESC2")," "))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("PROV2"))+CPLib.Space(2),2);
        /* _note := _note + Left(LRTrim(arfn_agechar(qbe_frap_chkdiana_cli->DESCINTER,' '))+Space(50),50) + Left(LRTrim(arfn_agechar(qbe_frap_chkdiana_cli->RAPPORTO,' '))+Space(25),25) + Left(LRTrim(_flagrap)+" ",1) */
        _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frap_chkdiana_cli.GetString("DESCINTER")," "))+CPLib.Space(50),50)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frap_chkdiana_cli.GetString("RAPPORTO")," "))+CPLib.Space(25),25)+CPLib.Left(CPLib.LRTrim(_flagrap)+" ",1);
        /* _note := _note + Left(LRTrim(qbe_frap_chkdiana_cli->TIPOLEG)+" ",1) + Left(LRTrim(DateToChar(qbe_frap_chkdiana_cli->DATAREG))+Space(8),8) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("TIPOLEG"))+" ",1)+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_frap_chkdiana_cli.GetDate("DATAREG")))+CPLib.Space(8),8);
        /* _note := _note + Left(LRTrim(qbe_frap_chkdiana_cli->TIPOOPRAP)+Space(2),2) + Left(LRTrim(qbe_frap_chkdiana_cli->COLLEG)+Space(11),11) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("TIPOOPRAP"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("COLLEG"))+CPLib.Space(11),11);
        /* _note := _note + " " + Left(LRTrim(qbe_frap_chkdiana_cli->STATOREG)+" ",1)  */
        _note = _note+" "+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("STATOREG"))+" ",1);
        /* If Empty(qbe_frap_chkdiana_cli->DATARETT) or DateToChar(qbe_frap_chkdiana_cli->DATARETT)='01000101' */
        if (CPLib.Empty(Cursor_qbe_frap_chkdiana_cli.GetDate("DATARETT")) || CPLib.eqr(CPLib.DateToChar(Cursor_qbe_frap_chkdiana_cli.GetDate("DATARETT")),"01000101")) {
          /* _note := _note + Space(8) */
          _note = _note+CPLib.Space(8);
        } else { // Else
          /* _note := _note + Left(LRTrim(DateToChar(qbe_frap_chkdiana_cli->DATARETT))+Space(8),8) */
          _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_frap_chkdiana_cli.GetDate("DATARETT")))+CPLib.Space(8),8);
        } // End If
        /* _note := _note + iif(Empty(LRTrim(qbe_frap_chkdiana_cli->OPERAZMOD)),Space(20),Left(qbe_frap_chkdiana_cli->OPERAZMOD,8)+"F"+Right(qbe_frap_chkdiana_cli->OPERAZMOD,11)) */
        _note = _note+(CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("OPERAZMOD")))?CPLib.Space(20):CPLib.Left(Cursor_qbe_frap_chkdiana_cli.GetString("OPERAZMOD"),8)+"F"+CPLib.Right(Cursor_qbe_frap_chkdiana_cli.GetString("OPERAZMOD"),11));
        /* _note := _note + Left(LRTrim(qbe_frap_chkdiana_cli->FLAGLIRE)+" ",1) + Left(LRTrim(qbe_frap_chkdiana_cli->VALUTA)+Space(3),3) + Left(LRTrim(qbe_frap_chkdiana_cli->SEGNO)+" ",1) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("FLAGLIRE"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("VALUTA"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("SEGNO"))+" ",1);
        /* _note := _note +  Right('000000000000000'+LRTrim(Str(qbe_frap_chkdiana_cli->TOTLIRE,15,0)),15) + Right('000000000000000'+LRTrim(Str(qbe_frap_chkdiana_cli->TOTCONT,15,0)),15) + Space(69) */
        _note = _note+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_frap_chkdiana_cli.GetDouble("TOTLIRE"),15,0)),15)+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_frap_chkdiana_cli.GetDouble("TOTCONT"),15,0)),15)+CPLib.Space(69);
        /* If w_flgchk='S' */
        if (CPLib.eqr(w_flgchk,"S")) {
          /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
          Page_15();
        } else { // Else
          /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
          FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
        } // End If
        /* nTotRec := nTotRec + 1 */
        nTotRec = CPLib.Round(nTotRec+1,0);
        /* nTotReg := nTotReg + 1 */
        nTotReg = CPLib.Round(nTotReg+1,0);
        /* nNumRec := nNumRec + 1 */
        nNumRec = CPLib.Round(nNumRec+1,0);
        /* If not(Empty(qbe_frap_chkdiana_cli->CONNESCLI)) and Empty(LRTrim(qbe_frap_chkdiana_cli->RAPPORTO)) */
        if ( ! (CPLib.Empty(Cursor_qbe_frap_chkdiana_cli.GetString("CONNESCLI"))) && CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("RAPPORTO")))) {
          /* _oldrap := '' */
          _oldrap = "";
          /* _codrif := qbe_frap_chkdiana_cli->CONNESCLI */
          _codrif = Cursor_qbe_frap_chkdiana_cli.GetString("CONNESCLI");
          /* If gFlgWU='S' */
          if (CPLib.eqr(gFlgWU,"S")) {
            // * --- Select from kersonbo
            m_cServer = m_Ctx.GetServer("kersonbo");
            m_cPhName = m_Ctx.GetPhName("kersonbo");
            if (Cursor_kersonbo!=null)
              Cursor_kersonbo.Close();
            Cursor_kersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_frap_chkdiana_cli.GetString("CONNESDOC"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("kersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_kersonbo.Eof())) {
              /* _ramate := iif(w_flgrae='R',LRTrim(kersonbo->RAMOGRUP),Left(LRTrim(kersonbo->ATTIV),3)) */
              _ramate = (CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_kersonbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("ATTIV")),3));
              /* _note := w_tipinter + w_codinter */
              _note = w_tipinter+w_codinter;
              /* If Empty(qbe_frap_chkdiana_cli->CONNESOPER) or (qbe_frap_chkdiana_cli->CONNESOPER=qbe_frap_chkdiana_cli->CONNESCLI) */
              if (CPLib.Empty(Cursor_qbe_frap_chkdiana_cli.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_frap_chkdiana_cli.GetString("CONNESOPER"),Cursor_qbe_frap_chkdiana_cli.GetString("CONNESCLI")))) {
                /* _note := _note + '2' */
                _note = _note+"2";
              } else { // Else
                /* _note := _note + '3' */
                _note = _note+"3";
              } // End If
              /* _note := _note + _idereg */
              _note = _note+_idereg;
              /* _note := _note + Left(LRTrim(qbe_frap_chkdiana_cli->CONNESCLI)+Space(16),16) + Left(LRTrim(kersonbo->RAGSOC)+Space(70),70) + Left(LRTrim(kersonbo->PAESE)+Space(3),3) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("CONNESCLI"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("PAESE"))+CPLib.Space(3),3);
              /* _note := _note + Left(LRTrim(kersonbo->CODCAB)+Space(6),6) + Left(LRTrim(kersonbo->DESCCIT)+Space(30),30) + Left(LRTrim(kersonbo->PROVINCIA)+Space(2),2) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
              /* _note := _note + Left(LRTrim(kersonbo->DOMICILIO)+Space(35),35) + Left(LRTrim(kersonbo->CAP)+ Space(5),5) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("CAP"))+CPLib.Space(5),5);
              /* _note := _note + Left(LRTrim(kersonbo->CODFISC)+Space(16),16)  */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("CODFISC"))+CPLib.Space(16),16);
              /* If Empty(kersonbo->DATANASC) or DateToChar(kersonbo->DATANASC)='01000101' */
              if (CPLib.Empty(Cursor_kersonbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_kersonbo.GetDate("DATANASC")),"01000101")) {
                /* _note := _note + Space(8) */
                _note = _note+CPLib.Space(8);
              } else { // Else
                /* _note := _note + Left(LRTrim(DateToChar(kersonbo->DATANASC))+Space(8),8) */
                _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_kersonbo.GetDate("DATANASC")))+CPLib.Space(8),8);
              } // End If
              /* If not(Empty(kersonbo->NASSTATO)) */
              if ( ! (CPLib.Empty(Cursor_kersonbo.GetString("NASSTATO")))) {
                /* _note := _note + Left(LRTrim(kersonbo->NASSTATO)+Space(30),30) + Left(LRTrim(kersonbo->SOTGRUP)+Space(3),3) + Left(LRTrim(_ramate)+Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(_ramate)+CPLib.Space(3),3);
              } else { // Else
                /* _note := _note + Left(LRTrim(kersonbo->NASCOMUN)+Space(30),30) + Left(LRTrim(kersonbo->SOTGRUP)+Space(3),3) + Left(LRTrim(_ramate) +Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(_ramate)+CPLib.Space(3),3);
              } // End If
              /* _note := _note + Left(LRTrim(kersonbo->SETTSINT)+Space(3),3) + Left(LRTrim(arfn_agechar(qbe_frap_chkdiana_cli->RAPPORTO,' '))+Space(25),25) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frap_chkdiana_cli.GetString("RAPPORTO")," "))+CPLib.Space(25),25);
              /* _note := _note + Left(LRTrim(qbe_frap_chkdiana_cli->FLAGRAP)+" ",1) + Left(LRTrim(kersonbo->TIPODOC)+Space(2),2) + Left(LRTrim(kersonbo->NUMDOCUM)+Space(15),15) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
              /* If Empty(kersonbo->DATARILASC) or DateToChar(kersonbo->DATARILASC)='01000101' */
              if (CPLib.Empty(Cursor_kersonbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_kersonbo.GetDate("DATARILASC")),"01000101")) {
                /* _note := _note + Space(8) */
                _note = _note+CPLib.Space(8);
              } else { // Else
                /* _note := _note + Left(LRTrim(DateToChar(kersonbo->DATARILASC))+Space(8),8)  */
                _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_kersonbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
              } // End If
              /* _note := _note + Left(LRTrim(kersonbo->AUTRILASC)+Space(30),30) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("AUTRILASC"))+CPLib.Space(30),30);
              /* _note := _note + Left(LRTrim(kersonbo->SESSO)+" ",1) + Space(34) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SESSO"))+" ",1)+CPLib.Space(34);
              /* If w_flgchk='S' */
              if (CPLib.eqr(w_flgchk,"S")) {
                /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                Page_15();
              } else { // Else
                /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
              } // End If
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
              Cursor_kersonbo.Next();
            }
            m_cConnectivityError = Cursor_kersonbo.ErrorMessage();
            Cursor_kersonbo.Close();
            // * --- End Select
          } else { // Else
            /* _note := w_tipinter + w_codinter */
            _note = w_tipinter+w_codinter;
            /* If Empty(qbe_frap_chkdiana_cli->CONNESOPER) or (qbe_frap_chkdiana_cli->CONNESOPER=qbe_frap_chkdiana_cli->CONNESCLI) */
            if (CPLib.Empty(Cursor_qbe_frap_chkdiana_cli.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_frap_chkdiana_cli.GetString("CONNESOPER"),Cursor_qbe_frap_chkdiana_cli.GetString("CONNESCLI")))) {
              /* _note := _note + '2' */
              _note = _note+"2";
            } else { // Else
              /* _note := _note + '3' */
              _note = _note+"3";
            } // End If
            /* _note := _note + _idereg */
            _note = _note+_idereg;
            /* _note := _note + LRTrim(arfn_datisog_sol(qbe_frap_chkdiana_cli->CONNESCLI,qbe_frap_chkdiana_cli->DATAREG,qbe_frap_chkdiana_cli->RAPPORTO,qbe_frap_chkdiana_cli->FLAGRAP,'2',w_flgrae,qbe_frap_chkdiana_cli->STATOREG,qbe_frap_chkdiana_cli->DATARETT)) */
            _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_frap_chkdiana_cli.GetString("CONNESCLI"),Cursor_qbe_frap_chkdiana_cli.GetDate("DATAREG"),Cursor_qbe_frap_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_frap_chkdiana_cli.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_frap_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_frap_chkdiana_cli.GetDate("DATARETT")));
            /* If w_flgchk='S' */
            if (CPLib.eqr(w_flgchk,"S")) {
              /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
              Page_15();
            } else { // Else
              /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
              FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
            } // End If
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
          } // End If
        } else { // Else
          /* _oldrap := '' */
          _oldrap = "";
          // * --- Read from knarapbo
          m_cServer = m_Ctx.GetServer("knarapbo");
          m_cPhName = m_Ctx.GetPhName("knarapbo");
          m_cSql = "";
          m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_frap_chkdiana_cli.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_qbe_frap_chkdiana_cli.GetString("RAPPORTO"));
          if (m_Ctx.IsSharedTemp("knarapbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _oldrap = Read_Cursor.GetString("RAPPORTO");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on knarapbo into routine arrt_chkdiana_old returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _oldrap = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If not(Empty(_oldrap)) */
          if ( ! (CPLib.Empty(_oldrap))) {
            // * --- Select from knarapbo
            m_cServer = m_Ctx.GetServer("knarapbo");
            m_cPhName = m_Ctx.GetPhName("knarapbo");
            if (Cursor_knarapbo!=null)
              Cursor_knarapbo.Close();
            Cursor_knarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_frap_chkdiana_cli.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("knarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_knarapbo.Eof())) {
              /* If knarapbo->TIPORAP='P' */
              if (CPLib.eqr(Cursor_knarapbo.GetString("TIPORAP"),"P")) {
                // * --- Select from xntestbo
                m_cServer = m_Ctx.GetServer("xntestbo");
                m_cPhName = m_Ctx.GetPhName("xntestbo");
                if (Cursor_xntestbo!=null)
                  Cursor_xntestbo.Close();
                Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_frap_chkdiana_cli.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_xntestbo.Eof())) {
                  /* If qbe_frap_chkdiana_cli->RAPPORTO = xntestbo->RAPPORTO */
                  if (CPLib.eqr(Cursor_qbe_frap_chkdiana_cli.GetString("RAPPORTO"),Cursor_xntestbo.GetString("RAPPORTO"))) {
                    /* _avanza := 0 */
                    _avanza = CPLib.Round(0,0);
                    /* If Empty(xntestbo->CODINTER) or xntestbo->STATOREG='2' or xntestbo->STATOREG='3' */
                    if (CPLib.Empty(Cursor_xntestbo.GetString("CODINTER")) || CPLib.eqr(Cursor_xntestbo.GetString("STATOREG"),"2") || CPLib.eqr(Cursor_xntestbo.GetString("STATOREG"),"3")) {
                      /* _avanza := 1 */
                      _avanza = CPLib.Round(1,0);
                    } // End If
                    /* If xntestbo->DATAINI > qbe_frap_chkdiana_cli->DATAOPE */
                    if (CPLib.gt(Cursor_xntestbo.GetDate("DATAINI"),Cursor_qbe_frap_chkdiana_cli.GetDate("DATAOPE"))) {
                      /* _avanza := 1 */
                      _avanza = CPLib.Round(1,0);
                    } // End If
                    /* If not(Empty(xntestbo->DATAFINE)) and xntestbo->DATAFINE < qbe_frap_chkdiana_cli->DATAOPE */
                    if ( ! (CPLib.Empty(Cursor_xntestbo.GetDate("DATAFINE"))) && CPLib.lt(Cursor_xntestbo.GetDate("DATAFINE"),Cursor_qbe_frap_chkdiana_cli.GetDate("DATAOPE"))) {
                      /* _avanza := 1 */
                      _avanza = CPLib.Round(1,0);
                    } // End If
                    /* If _avanza = 0 */
                    if (CPLib.eqr(_avanza,0)) {
                      /* _codrif := xntestbo->CODINTER */
                      _codrif = Cursor_xntestbo.GetString("CODINTER");
                      /* _note := w_tipinter + w_codinter */
                      _note = w_tipinter+w_codinter;
                      /* If Empty(qbe_frap_chkdiana_cli->CONNESOPER) or (qbe_frap_chkdiana_cli->CONNESOPER=qbe_frap_chkdiana_cli->CONNESCLI) */
                      if (CPLib.Empty(Cursor_qbe_frap_chkdiana_cli.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_frap_chkdiana_cli.GetString("CONNESOPER"),Cursor_qbe_frap_chkdiana_cli.GetString("CONNESCLI")))) {
                        /* _note := _note + '2' */
                        _note = _note+"2";
                      } else { // Else
                        /* _note := _note + '3' */
                        _note = _note+"3";
                      } // End If
                      /* _note := _note + _idereg */
                      _note = _note+_idereg;
                      /* _note := _note + LRTrim(arfn_datisog_sol(xntestbo->CODINTER,qbe_frap_chkdiana_cli->DATAREG,qbe_frap_chkdiana_cli->RAPPORTO,qbe_frap_chkdiana_cli->FLAGRAP,'2',w_flgrae,qbe_frap_chkdiana_cli->STATOREG,qbe_frap_chkdiana_cli->DATARETT)) */
                      _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_xntestbo.GetString("CODINTER"),Cursor_qbe_frap_chkdiana_cli.GetDate("DATAREG"),Cursor_qbe_frap_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_frap_chkdiana_cli.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_frap_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_frap_chkdiana_cli.GetDate("DATARETT")));
                      /* If w_flgchk='S' */
                      if (CPLib.eqr(w_flgchk,"S")) {
                        /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                        Page_15();
                      } else { // Else
                        /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                        FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                      } // End If
                      /* nTotRec := nTotRec + 1 */
                      nTotRec = CPLib.Round(nTotRec+1,0);
                      /* nNumRec := nNumRec + 1 */
                      nNumRec = CPLib.Round(nNumRec+1,0);
                    } // End If
                  } // End If
                  Cursor_xntestbo.Next();
                }
                m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
                Cursor_xntestbo.Close();
                // * --- End Select
              } else { // Else
                // * --- Select from intestbo
                m_cServer = m_Ctx.GetServer("intestbo");
                m_cPhName = m_Ctx.GetPhName("intestbo");
                if (Cursor_intestbo!=null)
                  Cursor_intestbo.Close();
                Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_frap_chkdiana_cli.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_intestbo.Eof())) {
                  /* If qbe_frap_chkdiana_cli->RAPPORTO = intestbo->RAPPORTO */
                  if (CPLib.eqr(Cursor_qbe_frap_chkdiana_cli.GetString("RAPPORTO"),Cursor_intestbo.GetString("RAPPORTO"))) {
                    /* _avanza := 0 */
                    _avanza = CPLib.Round(0,0);
                    /* If Empty(intestbo->CODINTER) or intestbo->STATOREG='2' or intestbo->STATOREG='3' */
                    if (CPLib.Empty(Cursor_intestbo.GetString("CODINTER")) || CPLib.eqr(Cursor_intestbo.GetString("STATOREG"),"2") || CPLib.eqr(Cursor_intestbo.GetString("STATOREG"),"3")) {
                      /* _avanza := 1 */
                      _avanza = CPLib.Round(1,0);
                    } // End If
                    /* If intestbo->DATAINI > qbe_frap_chkdiana_cli->DATAOPE */
                    if (CPLib.gt(Cursor_intestbo.GetDate("DATAINI"),Cursor_qbe_frap_chkdiana_cli.GetDate("DATAOPE"))) {
                      /* _avanza := 1 */
                      _avanza = CPLib.Round(1,0);
                    } // End If
                    /* If not(Empty(intestbo->DATAFINE)) and intestbo->DATAFINE < qbe_frap_chkdiana_cli->DATAOPE */
                    if ( ! (CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE"))) && CPLib.lt(Cursor_intestbo.GetDate("DATAFINE"),Cursor_qbe_frap_chkdiana_cli.GetDate("DATAOPE"))) {
                      /* _avanza := 1 */
                      _avanza = CPLib.Round(1,0);
                    } // End If
                    /* If _avanza = 0 */
                    if (CPLib.eqr(_avanza,0)) {
                      /* _codrif := intestbo->CODINTER */
                      _codrif = Cursor_intestbo.GetString("CODINTER");
                      /* _note := w_tipinter + w_codinter */
                      _note = w_tipinter+w_codinter;
                      /* If Empty(qbe_frap_chkdiana_cli->CONNESOPER) or (qbe_frap_chkdiana_cli->CONNESOPER=qbe_frap_chkdiana_cli->CONNESCLI) */
                      if (CPLib.Empty(Cursor_qbe_frap_chkdiana_cli.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_frap_chkdiana_cli.GetString("CONNESOPER"),Cursor_qbe_frap_chkdiana_cli.GetString("CONNESCLI")))) {
                        /* _note := _note + '2' */
                        _note = _note+"2";
                      } else { // Else
                        /* _note := _note + '3' */
                        _note = _note+"3";
                      } // End If
                      /* _note := _note + _idereg */
                      _note = _note+_idereg;
                      /* _note := _note + LRTrim(arfn_datisog_sol(intestbo->CODINTER,qbe_frap_chkdiana_cli->DATAREG,qbe_frap_chkdiana_cli->RAPPORTO,qbe_frap_chkdiana_cli->FLAGRAP,'2',w_flgrae,qbe_frap_chkdiana_cli->STATOREG,qbe_frap_chkdiana_cli->DATARETT)) */
                      _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_intestbo.GetString("CODINTER"),Cursor_qbe_frap_chkdiana_cli.GetDate("DATAREG"),Cursor_qbe_frap_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_frap_chkdiana_cli.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_frap_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_frap_chkdiana_cli.GetDate("DATARETT")));
                      /* If w_flgchk='S' */
                      if (CPLib.eqr(w_flgchk,"S")) {
                        /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                        Page_15();
                      } else { // Else
                        /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                        FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                      } // End If
                      /* nTotRec := nTotRec + 1 */
                      nTotRec = CPLib.Round(nTotRec+1,0);
                      /* nNumRec := nNumRec + 1 */
                      nNumRec = CPLib.Round(nNumRec+1,0);
                    } // End If
                  } // End If
                  Cursor_intestbo.Next();
                }
                m_cConnectivityError = Cursor_intestbo.ErrorMessage();
                Cursor_intestbo.Close();
                // * --- End Select
              } // End If
              Cursor_knarapbo.Next();
            }
            m_cConnectivityError = Cursor_knarapbo.ErrorMessage();
            Cursor_knarapbo.Close();
            // * --- End Select
          } else { // Else
            /* If not(Empty(LRTrim(qbe_frap_chkdiana_cli->CONNESCLI))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("CONNESCLI"))))) {
              /* _note := w_tipinter + w_codinter */
              _note = w_tipinter+w_codinter;
              /* If Empty(qbe_frap_chkdiana_cli->CONNESOPER) or (qbe_frap_chkdiana_cli->CONNESOPER=qbe_frap_chkdiana_cli->CONNESCLI) */
              if (CPLib.Empty(Cursor_qbe_frap_chkdiana_cli.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_frap_chkdiana_cli.GetString("CONNESOPER"),Cursor_qbe_frap_chkdiana_cli.GetString("CONNESCLI")))) {
                /* _note := _note + '2' */
                _note = _note+"2";
              } else { // Else
                /* _note := _note + '3' */
                _note = _note+"3";
              } // End If
              /* _note := _note + _idereg */
              _note = _note+_idereg;
              /* _note := _note + LRTrim(arfn_datisog_sol(qbe_frap_chkdiana_cli->CONNESCLI,qbe_frap_chkdiana_cli->DATAREG,qbe_frap_chkdiana_cli->RAPPORTO,qbe_frap_chkdiana_cli->FLAGRAP,'2',w_flgrae,qbe_frap_chkdiana_cli->STATOREG,qbe_frap_chkdiana_cli->DATARETT)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_frap_chkdiana_cli.GetString("CONNESCLI"),Cursor_qbe_frap_chkdiana_cli.GetDate("DATAREG"),Cursor_qbe_frap_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_frap_chkdiana_cli.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_frap_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_frap_chkdiana_cli.GetDate("DATARETT")));
              /* If w_flgchk='S' */
              if (CPLib.eqr(w_flgchk,"S")) {
                /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                Page_15();
              } else { // Else
                /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
              } // End If
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
            } // End If
          } // End If
        } // End If
        /* If not(Empty(LRTrim(_oldrap))) */
        if ( ! (CPLib.Empty(CPLib.LRTrim(_oldrap)))) {
          /* _oldrighe := 0 */
          _oldrighe = CPLib.Round(0,0);
          // * --- Select from xlientifrz
          m_cServer = m_Ctx.GetServer("xlientifrz");
          m_cPhName = m_Ctx.GetPhName("xlientifrz");
          if (Cursor_xlientifrz!=null)
            Cursor_xlientifrz.Close();
          Cursor_xlientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_frap_chkdiana_cli.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xlientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_xlientifrz.Eof())) {
            /* _note := w_tipinter + w_codinter */
            _note = w_tipinter+w_codinter;
            /* If Empty(qbe_frap_chkdiana_cli->CONNESOPER) or (qbe_frap_chkdiana_cli->CONNESOPER=xlientifrz->CODSOG) */
            if (CPLib.Empty(Cursor_qbe_frap_chkdiana_cli.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_frap_chkdiana_cli.GetString("CONNESOPER"),Cursor_xlientifrz.GetString("CODSOG")))) {
              /* _note := _note + '2' */
              _note = _note+"2";
            } else { // Else
              /* _note := _note + '3' */
              _note = _note+"3";
            } // End If
            /* _note := _note + _idereg */
            _note = _note+_idereg;
            /* _note := _note + LRTrim(arfn_datisog_sol(xlientifrz->CODSOG,qbe_frap_chkdiana_cli->DATAREG,qbe_frap_chkdiana_cli->RAPPORTO,qbe_frap_chkdiana_cli->FLAGRAP,'2',w_flgrae,qbe_frap_chkdiana_cli->STATOREG,qbe_frap_chkdiana_cli->DATARETT)) */
            _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_xlientifrz.GetString("CODSOG"),Cursor_qbe_frap_chkdiana_cli.GetDate("DATAREG"),Cursor_qbe_frap_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_frap_chkdiana_cli.GetString("FLAGRAP"),"2",w_flgrae,Cursor_qbe_frap_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_frap_chkdiana_cli.GetDate("DATARETT")));
            /* If w_flgchk='S' */
            if (CPLib.eqr(w_flgchk,"S")) {
              /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
              Page_15();
            } else { // Else
              /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
              FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
            } // End If
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
            Cursor_xlientifrz.Next();
          }
          m_cConnectivityError = Cursor_xlientifrz.ErrorMessage();
          Cursor_xlientifrz.Close();
          // * --- End Select
        } // End If
        /* If not(Empty(qbe_frap_chkdiana_cli->CONNESOPER)) and qbe_frap_chkdiana_cli->CONNESOPER <> _codrif */
        if ( ! (CPLib.Empty(Cursor_qbe_frap_chkdiana_cli.GetString("CONNESOPER"))) && CPLib.ne(Cursor_qbe_frap_chkdiana_cli.GetString("CONNESOPER"),_codrif)) {
          /* _note := w_tipinter + w_codinter+'4' + _idereg */
          _note = w_tipinter+w_codinter+"4"+_idereg;
          /* _note := _note + LRTrim(arfn_datisog_sol(qbe_frap_chkdiana_cli->CONNESOPER,qbe_frap_chkdiana_cli->DATAREG,qbe_frap_chkdiana_cli->RAPPORTO,qbe_frap_chkdiana_cli->FLAGRAP,'4',w_flgrae,qbe_frap_chkdiana_cli->STATOREG,qbe_frap_chkdiana_cli->DATARETT)) */
          _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_frap_chkdiana_cli.GetString("CONNESOPER"),Cursor_qbe_frap_chkdiana_cli.GetDate("DATAREG"),Cursor_qbe_frap_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_frap_chkdiana_cli.GetString("FLAGRAP"),"4",w_flgrae,Cursor_qbe_frap_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_frap_chkdiana_cli.GetDate("DATARETT")));
          /* If w_flgchk='S' */
          if (CPLib.eqr(w_flgchk,"S")) {
            /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
            Page_15();
          } else { // Else
            /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
            FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
          } // End If
          /* nTotRec := nTotRec + 1 */
          nTotRec = CPLib.Round(nTotRec+1,0);
          /* nNumRec := nNumRec + 1 */
          nNumRec = CPLib.Round(nNumRec+1,0);
        } // End If
        // * --- Select from xogopefbo
        m_cServer = m_Ctx.GetServer("xogopefbo");
        m_cPhName = m_Ctx.GetPhName("xogopefbo");
        if (Cursor_xogopefbo!=null)
          Cursor_xogopefbo.Close();
        Cursor_xogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_frap_chkdiana_cli.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xogopefbo.Eof())) {
          /* _note := w_tipinter + w_codinter+'4' + _idereg */
          _note = w_tipinter+w_codinter+"4"+_idereg;
          /* _note := _note + LRTrim(arfn_datisog_sol(xogopefbo->CODSOG,qbe_frap_chkdiana_cli->DATAREG,qbe_frap_chkdiana_cli->RAPPORTO,qbe_frap_chkdiana_cli->FLAGRAP,'4',w_flgrae,qbe_frap_chkdiana_cli->STATOREG,qbe_frap_chkdiana_cli->DATARETT)) */
          _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_xogopefbo.GetString("CODSOG"),Cursor_qbe_frap_chkdiana_cli.GetDate("DATAREG"),Cursor_qbe_frap_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_frap_chkdiana_cli.GetString("FLAGRAP"),"4",w_flgrae,Cursor_qbe_frap_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_frap_chkdiana_cli.GetDate("DATARETT")));
          /* If w_flgchk='S' */
          if (CPLib.eqr(w_flgchk,"S")) {
            /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
            Page_15();
          } else { // Else
            /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
            FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
          } // End If
          /* nTotRec := nTotRec + 1 */
          nTotRec = CPLib.Round(nTotRec+1,0);
          /* nNumRec := nNumRec + 1 */
          nNumRec = CPLib.Round(nNumRec+1,0);
          Cursor_xogopefbo.Next();
        }
        m_cConnectivityError = Cursor_xogopefbo.ErrorMessage();
        Cursor_xogopefbo.Close();
        // * --- End Select
        /* If not(Empty(qbe_frap_chkdiana_cli->CONNESBEN)) or not(Empty(qbe_frap_chkdiana_cli->C_RAG)) */
        if ( ! (CPLib.Empty(Cursor_qbe_frap_chkdiana_cli.GetString("CONNESBEN"))) ||  ! (CPLib.Empty(Cursor_qbe_frap_chkdiana_cli.GetString("C_RAG")))) {
          /* If not(Empty(qbe_frap_chkdiana_cli->C_RAG)) */
          if ( ! (CPLib.Empty(Cursor_qbe_frap_chkdiana_cli.GetString("C_RAG")))) {
            /* _note := w_tipinter + w_codinter+'5' + _idereg */
            _note = w_tipinter+w_codinter+"5"+_idereg;
            /* _note := _note + Left(LRTrim(qbe_frap_chkdiana_cli->CONNESBEN)+Space(16),16) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("CONNESBEN"))+CPLib.Space(16),16);
            /* _note := _note +Left(LRTrim(arfn_agechar(qbe_frap_chkdiana_cli->C_RAG,' '))+Space(70),70) */
            _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frap_chkdiana_cli.GetString("C_RAG")," "))+CPLib.Space(70),70);
            /* _note := _note + Left(LRTrim(qbe_frap_chkdiana_cli->C_STA)+Space(3),3) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("C_STA"))+CPLib.Space(3),3);
            /* _note := _note +Left(LRTrim(qbe_frap_chkdiana_cli->C_CAB)+Space(6),6) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("C_CAB"))+CPLib.Space(6),6);
            /* _note := _note +Left(LRTrim(arfn_agechar(qbe_frap_chkdiana_cli->C_CTA,' '))+Space(30),30) */
            _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frap_chkdiana_cli.GetString("C_CTA")," "))+CPLib.Space(30),30);
            /* _note := _note + Left(LRTrim(qbe_frap_chkdiana_cli->C_PRV)+Space(2),2) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("C_PRV"))+CPLib.Space(2),2);
            /* _note := _note + Left(LRTrim(arfn_agechar(qbe_frap_chkdiana_cli->C_IND,' '))+Space(35),35) */
            _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frap_chkdiana_cli.GetString("C_IND")," "))+CPLib.Space(35),35);
            /* _note := _note + Left(LRTrim(qbe_frap_chkdiana_cli->C_CAP)+Space(5),5) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("C_CAP"))+CPLib.Space(5),5);
            /* _note := _note + Space(63) */
            _note = _note+CPLib.Space(63);
            /* _note := _note + Left(LRTrim(qbe_frap_chkdiana_cli->C_RAPPORTO)+Space(25),25) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
            /* _note := _note + Space(91) */
            _note = _note+CPLib.Space(91);
            /* If w_flgchk='S' */
            if (CPLib.eqr(w_flgchk,"S")) {
              /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
              Page_15();
            } else { // Else
              /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
              FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
            } // End If
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
            /* ElseIf not(Empty(qbe_frap_chkdiana_cli->CONNESBEN)) */
          } else if ( ! (CPLib.Empty(Cursor_qbe_frap_chkdiana_cli.GetString("CONNESBEN")))) {
            /* _numsto := arfn_chkspers(qbe_frap_chkdiana_cli->CONNESBEN,qbe_frap_chkdiana_cli->DATAREG) */
            _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_frap_chkdiana_cli.GetString("CONNESBEN"),Cursor_qbe_frap_chkdiana_cli.GetDate("DATAREG"));
            /* If Empty(LRTrim(_numsto)) */
            if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_frap_chkdiana_cli.GetString("CONNESBEN"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                /* _note := w_tipinter + w_codinter+'5' + _idereg */
                _note = w_tipinter+w_codinter+"5"+_idereg;
                /* _note := _note + Left(LRTrim(qbe_frap_chkdiana_cli->CONNESBEN)+Space(16),16) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("CONNESBEN"))+CPLib.Space(16),16);
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frap_chkdiana_cli->C_RAG))),Left(LRTrim(arfn_agechar(qbe_frap_chkdiana_cli->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(personbo->RAGSOC,' '))+Space(70),70)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frap_chkdiana_cli.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frap_chkdiana_cli->C_STA))),Left(LRTrim(qbe_frap_chkdiana_cli->C_STA)+Space(3),3),Left(LRTrim(personbo->PAESE)+Space(3),3)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frap_chkdiana_cli->C_CAB))),Left(LRTrim(qbe_frap_chkdiana_cli->C_CAB)+Space(6),6),Left(LRTrim(personbo->CODCAB)+Space(6),6)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frap_chkdiana_cli->C_CTA))),Left(LRTrim(arfn_agechar(qbe_frap_chkdiana_cli->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(personbo->DESCCIT,' '))+Space(30),30)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frap_chkdiana_cli.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frap_chkdiana_cli->C_PRV))),Left(LRTrim(qbe_frap_chkdiana_cli->C_PRV)+Space(2),2),Left(LRTrim(personbo->PROVINCIA)+Space(2),2)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frap_chkdiana_cli->C_IND))),Left(LRTrim(arfn_agechar(qbe_frap_chkdiana_cli->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(personbo->DOMICILIO,' '))+Space(35),35)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frap_chkdiana_cli.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frap_chkdiana_cli->C_CAP))),Left(LRTrim(qbe_frap_chkdiana_cli->C_CAP)+Space(5),5),Left(LRTrim(personbo->CAP)+Space(5),5)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5));
                /* _note := _note + Space(63) */
                _note = _note+CPLib.Space(63);
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frap_chkdiana_cli->C_RAPPORTO))),Left(LRTrim(qbe_frap_chkdiana_cli->C_RAPPORTO)+Space(25),25),Left(LRTrim(qbe_frap_chkdiana_cli->RAPPORTBEN)+Space(25),25)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("C_RAPPORTO"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("C_RAPPORTO"))+CPLib.Space(25),25):CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("RAPPORTBEN"))+CPLib.Space(25),25));
                /* _note := _note + Space(91) */
                _note = _note+CPLib.Space(91);
                /* If w_flgchk='S' */
                if (CPLib.eqr(w_flgchk,"S")) {
                  /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                  Page_15();
                } else { // Else
                  /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                  FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                } // End If
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
            } else { // Else
              // * --- Select from wersonbo
              m_cServer = m_Ctx.GetServer("wersonbo");
              m_cPhName = m_Ctx.GetPhName("wersonbo");
              if (Cursor_wersonbo!=null)
                Cursor_wersonbo.Close();
              Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_wersonbo.Eof())) {
                /* _note := w_tipinter + w_codinter+'5' + _idereg */
                _note = w_tipinter+w_codinter+"5"+_idereg;
                /* _note := _note + Left(LRTrim(qbe_frap_chkdiana_cli->CONNESBEN)+Space(16),16) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("CONNESBEN"))+CPLib.Space(16),16);
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frap_chkdiana_cli->C_RAG))),Left(LRTrim(arfn_agechar(qbe_frap_chkdiana_cli->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(wersonbo->RAGSOC,' '))+Space(70),70)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frap_chkdiana_cli.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frap_chkdiana_cli->C_STA))),Left(LRTrim(qbe_frap_chkdiana_cli->C_STA)+Space(3),3),Left(LRTrim(wersonbo->PAESE)+Space(3),3)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PAESE"))+CPLib.Space(3),3));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frap_chkdiana_cli->C_CAB))),Left(LRTrim(qbe_frap_chkdiana_cli->C_CAB)+Space(6),6),Left(LRTrim(wersonbo->CODCAB)+Space(6),6)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CODCAB"))+CPLib.Space(6),6));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frap_chkdiana_cli->C_CTA))),Left(LRTrim(arfn_agechar(qbe_frap_chkdiana_cli->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(wersonbo->DESCCIT,' '))+Space(30),30)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frap_chkdiana_cli.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frap_chkdiana_cli->C_PRV))),Left(LRTrim(qbe_frap_chkdiana_cli->C_PRV)+Space(2),2),Left(LRTrim(wersonbo->PROVINCIA)+Space(2),2)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frap_chkdiana_cli->C_IND))),Left(LRTrim(arfn_agechar(qbe_frap_chkdiana_cli->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(wersonbo->DOMICILIO,' '))+Space(35),35)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frap_chkdiana_cli.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frap_chkdiana_cli->C_CAP))),Left(LRTrim(qbe_frap_chkdiana_cli->C_CAP)+Space(5),5),Left(LRTrim(wersonbo->CAP)+Space(5),5)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CAP"))+CPLib.Space(5),5));
                /* _note := _note + Space(63) */
                _note = _note+CPLib.Space(63);
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frap_chkdiana_cli->C_RAPPORTO))),Left(LRTrim(qbe_frap_chkdiana_cli->C_RAPPORTO)+Space(25),25),Left(LRTrim(qbe_frap_chkdiana_cli->RAPPORTBEN)+Space(25),25)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("C_RAPPORTO"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("C_RAPPORTO"))+CPLib.Space(25),25):CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana_cli.GetString("RAPPORTBEN"))+CPLib.Space(25),25));
                /* _note := _note + Space(91) */
                _note = _note+CPLib.Space(91);
                /* If w_flgchk='S' */
                if (CPLib.eqr(w_flgchk,"S")) {
                  /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                  Page_15();
                } else { // Else
                  /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                  FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                } // End If
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_wersonbo.Next();
              }
              m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
              Cursor_wersonbo.Close();
              // * --- End Select
            } // End If
          } // End If
        } // End If
        // * --- Select from xeneficfrz
        m_cServer = m_Ctx.GetServer("xeneficfrz");
        m_cPhName = m_Ctx.GetPhName("xeneficfrz");
        if (Cursor_xeneficfrz!=null)
          Cursor_xeneficfrz.Close();
        Cursor_xeneficfrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_frap_chkdiana_cli.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xeneficfrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xeneficfrz.Eof())) {
          /* If Empty(LRTrim(xeneficfrz->CODSOG)) and not(Empty(LRTrim(xeneficfrz->C_RAG))) */
          if (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficfrz.GetString("CODSOG"))) &&  ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_RAG"))))) {
            /* _note := w_tipinter + w_codinter+'5' + _idereg */
            _note = w_tipinter+w_codinter+"5"+_idereg;
            /* _note := _note + Left(LRTrim(xeneficfrz->CODSOG)+Space(16),16) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("CODSOG"))+CPLib.Space(16),16);
            /* _note := _note +Left(LRTrim(arfn_agechar(xeneficfrz->C_RAG,' '))+Space(70),70) */
            _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_xeneficfrz.GetString("C_RAG")," "))+CPLib.Space(70),70);
            /* _note := _note + Left(LRTrim(xeneficfrz->C_STA)+Space(3),3) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_STA"))+CPLib.Space(3),3);
            /* _note := _note +Left(LRTrim(xeneficfrz->C_CAB)+Space(6),6) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_CAB"))+CPLib.Space(6),6);
            /* _note := _note +Left(LRTrim(arfn_agechar(xeneficfrz->C_CTA,' '))+Space(30),30) */
            _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_xeneficfrz.GetString("C_CTA")," "))+CPLib.Space(30),30);
            /* _note := _note + Left(LRTrim(xeneficfrz->C_PRV)+Space(2),2) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_PRV"))+CPLib.Space(2),2);
            /* _note := _note + Left(LRTrim(arfn_agechar(xeneficfrz->C_IND,' '))+Space(35),35) */
            _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_xeneficfrz.GetString("C_IND")," "))+CPLib.Space(35),35);
            /* _note := _note + Left(LRTrim(xeneficfrz->C_CAP)+Space(5),5) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_CAP"))+CPLib.Space(5),5);
            /* _note := _note + Space(63) */
            _note = _note+CPLib.Space(63);
            /* _note := _note + Left(LRTrim(xeneficfrz->C_RAPPORTO)+Space(25),25) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
            /* _note := _note + Space(91) */
            _note = _note+CPLib.Space(91);
            /* If w_flgchk='S' */
            if (CPLib.eqr(w_flgchk,"S")) {
              /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
              Page_15();
            } else { // Else
              /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
              FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
            } // End If
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
          } else { // Else
            /* _numsto := arfn_chkspers(xeneficfrz->CODSOG,qbe_frap_chkdiana_cli->DATAREG) */
            _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_xeneficfrz.GetString("CODSOG"),Cursor_qbe_frap_chkdiana_cli.GetDate("DATAREG"));
            /* If Empty(LRTrim(_numsto)) */
            if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xeneficfrz.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                /* _note := w_tipinter + w_codinter+'5' + _idereg */
                _note = w_tipinter+w_codinter+"5"+_idereg;
                /* _note := _note + Left(LRTrim(xeneficfrz->CODSOG)+Space(16),16) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("CODSOG"))+CPLib.Space(16),16);
                /* _note := _note + iif(not(Empty(LRTrim(xeneficfrz->C_RAG))),Left(LRTrim(arfn_agechar(xeneficfrz->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(personbo->RAGSOC,' '))+Space(70),70)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_xeneficfrz.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                /* _note := _note + iif(not(Empty(LRTrim(xeneficfrz->C_STA))),Left(LRTrim(xeneficfrz->C_STA)+Space(3),3),Left(LRTrim(personbo->PAESE)+Space(3),3)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3));
                /* _note := _note + iif(not(Empty(LRTrim(xeneficfrz->C_CAB))),Left(LRTrim(xeneficfrz->C_CAB)+Space(6),6),Left(LRTrim(personbo->CODCAB)+Space(6),6)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6));
                /* _note := _note + iif(not(Empty(LRTrim(xeneficfrz->C_CTA))),Left(LRTrim(arfn_agechar(xeneficfrz->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(personbo->DESCCIT,' '))+Space(30),30)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_xeneficfrz.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                /* _note := _note + iif(not(Empty(LRTrim(xeneficfrz->C_PRV))),Left(LRTrim(xeneficfrz->C_PRV)+Space(2),2),Left(LRTrim(personbo->PROVINCIA)+Space(2),2)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                /* _note := _note + iif(not(Empty(LRTrim(xeneficfrz->C_IND))),Left(LRTrim(arfn_agechar(xeneficfrz->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(personbo->DOMICILIO,' '))+Space(35),35)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_xeneficfrz.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                /* _note := _note + iif(not(Empty(LRTrim(xeneficfrz->C_CAP))),Left(LRTrim(xeneficfrz->C_CAP)+Space(5),5),Left(LRTrim(personbo->CAP)+Space(5),5)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5));
                /* _note := _note + Space(63) */
                _note = _note+CPLib.Space(63);
                /* _note := _note +Left(LRTrim(xeneficfrz->C_RAPPORTO)+Space(25),25) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                /* _note := _note + Space(91) */
                _note = _note+CPLib.Space(91);
                /* If w_flgchk='S' */
                if (CPLib.eqr(w_flgchk,"S")) {
                  /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                  Page_15();
                } else { // Else
                  /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                  FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                } // End If
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
            } else { // Else
              // * --- Select from wersonbo
              m_cServer = m_Ctx.GetServer("wersonbo");
              m_cPhName = m_Ctx.GetPhName("wersonbo");
              if (Cursor_wersonbo!=null)
                Cursor_wersonbo.Close();
              Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_wersonbo.Eof())) {
                /* _note := w_tipinter + w_codinter+'5' + _idereg */
                _note = w_tipinter+w_codinter+"5"+_idereg;
                /* _note := _note + Left(LRTrim(xeneficfrz->CODSOG)+Space(16),16) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("CODSOG"))+CPLib.Space(16),16);
                /* _note := _note + iif(not(Empty(LRTrim(xeneficfrz->C_RAG))),Left(LRTrim(arfn_agechar(xeneficfrz->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(wersonbo->RAGSOC,' '))+Space(70),70)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_xeneficfrz.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                /* _note := _note + iif(not(Empty(LRTrim(xeneficfrz->C_STA))),Left(LRTrim(xeneficfrz->C_STA)+Space(3),3),Left(LRTrim(wersonbo->PAESE)+Space(3),3)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PAESE"))+CPLib.Space(3),3));
                /* _note := _note + iif(not(Empty(LRTrim(xeneficfrz->C_CAB))),Left(LRTrim(xeneficfrz->C_CAB)+Space(6),6),Left(LRTrim(wersonbo->CODCAB)+Space(6),6)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CODCAB"))+CPLib.Space(6),6));
                /* _note := _note + iif(not(Empty(LRTrim(xeneficfrz->C_CTA))),Left(LRTrim(arfn_agechar(xeneficfrz->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(wersonbo->DESCCIT,' '))+Space(30),30)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_xeneficfrz.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                /* _note := _note + iif(not(Empty(LRTrim(xeneficfrz->C_PRV))),Left(LRTrim(xeneficfrz->C_PRV)+Space(2),2),Left(LRTrim(wersonbo->PROVINCIA)+Space(2),2)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                /* _note := _note + iif(not(Empty(LRTrim(xeneficfrz->C_IND))),Left(LRTrim(arfn_agechar(xeneficfrz->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(wersonbo->DOMICILIO,' '))+Space(35),35)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_xeneficfrz.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                /* _note := _note + iif(not(Empty(LRTrim(xeneficfrz->C_CAP))),Left(LRTrim(xeneficfrz->C_CAP)+Space(5),5),Left(LRTrim(wersonbo->CAP)+Space(5),5)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CAP"))+CPLib.Space(5),5));
                /* _note := _note + Space(63) */
                _note = _note+CPLib.Space(63);
                /* _note := _note +Left(LRTrim(xeneficfrz->C_RAPPORTO)+Space(25),25) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                /* _note := _note + Space(91) */
                _note = _note+CPLib.Space(91);
                /* If w_flgchk='S' */
                if (CPLib.eqr(w_flgchk,"S")) {
                  /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
                  Page_15();
                } else { // Else
                  /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
                  FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
                } // End If
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_wersonbo.Next();
              }
              m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
              Cursor_wersonbo.Close();
              // * --- End Select
            } // End If
          } // End If
          Cursor_xeneficfrz.Next();
        }
        m_cConnectivityError = Cursor_xeneficfrz.ErrorMessage();
        Cursor_xeneficfrz.Close();
        // * --- End Select
        /* If not(Empty(qbe_frap_chkdiana_cli->CONNALTRO)) */
        if ( ! (CPLib.Empty(Cursor_qbe_frap_chkdiana_cli.GetString("CONNALTRO")))) {
          /* _note := w_tipinter + w_codinter+'6' + _idereg */
          _note = w_tipinter+w_codinter+"6"+_idereg;
          /* _note := _note + LRTrim(arfn_datisog_sol(qbe_frap_chkdiana_cli->CONNALTRO,qbe_frap_chkdiana_cli->DATAREG,qbe_frap_chkdiana_cli->RAPPORTO,qbe_frap_chkdiana_cli->FLAGRAP,'6',w_flgrae,qbe_frap_chkdiana_cli->STATOREG,qbe_frap_chkdiana_cli->DATARETT)) */
          _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_frap_chkdiana_cli.GetString("CONNALTRO"),Cursor_qbe_frap_chkdiana_cli.GetDate("DATAREG"),Cursor_qbe_frap_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_frap_chkdiana_cli.GetString("FLAGRAP"),"6",w_flgrae,Cursor_qbe_frap_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_frap_chkdiana_cli.GetDate("DATARETT")));
          /* If w_flgchk='S' */
          if (CPLib.eqr(w_flgchk,"S")) {
            /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
            Page_15();
          } else { // Else
            /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
            FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
          } // End If
          /* nTotRec := nTotRec + 1 */
          nTotRec = CPLib.Round(nTotRec+1,0);
          /* nNumRec := nNumRec + 1 */
          nNumRec = CPLib.Round(nNumRec+1,0);
        } // End If
        // * --- Select from xerzistifrz
        m_cServer = m_Ctx.GetServer("xerzistifrz");
        m_cPhName = m_Ctx.GetPhName("xerzistifrz");
        if (Cursor_xerzistifrz!=null)
          Cursor_xerzistifrz.Close();
        Cursor_xerzistifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_frap_chkdiana_cli.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xerzistifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xerzistifrz.Eof())) {
          /* _note := w_tipinter + w_codinter+'6' + _idereg */
          _note = w_tipinter+w_codinter+"6"+_idereg;
          /* _note := _note + LRTrim(arfn_datisog_sol(xerzistifrz->CODSOG,qbe_frap_chkdiana_cli->DATAREG,qbe_frap_chkdiana_cli->RAPPORTO,qbe_frap_chkdiana_cli->FLAGRAP,'6',w_flgrae,qbe_frap_chkdiana_cli->STATOREG,qbe_frap_chkdiana_cli->DATARETT)) */
          _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_xerzistifrz.GetString("CODSOG"),Cursor_qbe_frap_chkdiana_cli.GetDate("DATAREG"),Cursor_qbe_frap_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_frap_chkdiana_cli.GetString("FLAGRAP"),"6",w_flgrae,Cursor_qbe_frap_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_frap_chkdiana_cli.GetDate("DATARETT")));
          /* If w_flgchk='S' */
          if (CPLib.eqr(w_flgchk,"S")) {
            /* Exec "Scrittura diretta su WEBCHK" Page 14:Page_15 */
            Page_15();
          } else { // Else
            /* FileLibrary.Write(fhand,Left(LRTrim(_note)+Space(380),380)+CRLF) */
            FileLibrary.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\r\n");
          } // End If
          /* nTotRec := nTotRec + 1 */
          nTotRec = CPLib.Round(nTotRec+1,0);
          /* nNumRec := nNumRec + 1 */
          nNumRec = CPLib.Round(nNumRec+1,0);
          Cursor_xerzistifrz.Next();
        }
        m_cConnectivityError = Cursor_xerzistifrz.ErrorMessage();
        Cursor_xerzistifrz.Close();
        // * --- End Select
        /* gNumRec := nTotRec // N� Record DIANA */
        gNumRec = CPLib.Round(nTotRec,0);
        m_Ctx.SetGlobalNumber("gNumRec",gNumRec);
        /* gNumReg := nTotReg // N� Registrazioni DIANA */
        gNumReg = CPLib.Round(nTotReg,0);
        m_Ctx.SetGlobalNumber("gNumReg",gNumReg);
        Cursor_qbe_frap_chkdiana_cli.Next();
      }
      m_cConnectivityError = Cursor_qbe_frap_chkdiana_cli.ErrorMessage();
      Cursor_qbe_frap_chkdiana_cli.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_frap_chkdiana_cli!=null)
          Cursor_qbe_frap_chkdiana_cli.Close();
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
        if (Cursor_xnarapbo!=null)
          Cursor_xnarapbo.Close();
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
        if (Cursor_anadip!=null)
          Cursor_anadip.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_kersonbo!=null)
          Cursor_kersonbo.Close();
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
        if (Cursor_xntestbo!=null)
          Cursor_xntestbo.Close();
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
        if (Cursor_xlientifrz!=null)
          Cursor_xlientifrz.Close();
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
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
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
        if (Cursor_xerzistifrz!=null)
          Cursor_xerzistifrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_15() throws Exception {
    /* xTipo Char(1) */
    String xTipo;
    xTipo = CPLib.Space(1);
    /* xTipo := Substr(_note,14,1) */
    xTipo = CPLib.Substr(_note,14,1);
    /* Case xTipo='1' */
    if (CPLib.eqr(xTipo,"1")) {
      /* xStato := Substr(_note,248,1) */
      xStato = CPLib.Substr(_note,248,1);
      /* If (w_flgsto = 'N' and (xStato='0' or xStato='1')) or w_flgsto = 'S' */
      if ((CPLib.eqr(w_flgsto,"N") && (CPLib.eqr(xStato,"0") || CPLib.eqr(xStato,"1"))) || CPLib.eqr(w_flgsto,"S")) {
        /* _conta1 := _conta1 + 1 */
        _conta1 = CPLib.Round(_conta1+1,0);
        // * --- Insert into tipo1 from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tipo1");
        m_cPhName = m_Ctx.GetPhName("tipo1");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tipo1")+" (";
        m_cSql = m_cSql+GetFieldsName_078A74F8(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,1,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,3,11),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,14,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,15,20),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,35,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,41,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,47,30),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,77,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(_note,79,8)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,87,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,88,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,89,4),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,93,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,95,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,97,11),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,108,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,111,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,117,30),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,147,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,149,50),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,199,25),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,224,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,225,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(_note,226,8)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,234,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,236,12),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,248,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(_note,249,8)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,257,20),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,277,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,278,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,281,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(_note,282,15)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(_note,297,15)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_conta1,"?",0,0)+", ";
        if (m_Ctx.IsSharedTemp("tipo1")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tipo1",true);
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
      /* Case xTipo='2' or xTipo='3' */
    } else if (CPLib.eqr(xTipo,"2") || CPLib.eqr(xTipo,"3")) {
      /* If (w_flgsto = 'N' and (xStato='0' or xStato='1')) or w_flgsto = 'S' */
      if ((CPLib.eqr(w_flgsto,"N") && (CPLib.eqr(xStato,"0") || CPLib.eqr(xStato,"1"))) || CPLib.eqr(w_flgsto,"S")) {
        /* _conta2 := _conta2 + 1 */
        _conta2 = CPLib.Round(_conta2+1,0);
        // * --- Insert into tipo2_3 from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tipo2_3");
        m_cPhName = m_Ctx.GetPhName("tipo2_3");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tipo2_3")+" (";
        m_cSql = m_cSql+GetFieldsName_078AA0D8(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,1,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,3,11),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,14,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,15,20),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,35,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,51,70),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,121,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,124,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,130,30),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,160,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,162,35),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,197,5),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,202,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(_note,218,8)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,226,30),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,256,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,259,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,262,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,265,25),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,290,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,291,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,293,15),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(_note,308,8)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,316,30),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,346,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_conta2,"?",0,0)+", ";
        if (m_Ctx.IsSharedTemp("tipo2_3")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tipo2_3",true);
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
      /* Case xTipo='4'  */
    } else if (CPLib.eqr(xTipo,"4")) {
      /* If (w_flgsto = 'N' and (xStato='0' or xStato='1')) or w_flgsto = 'S' */
      if ((CPLib.eqr(w_flgsto,"N") && (CPLib.eqr(xStato,"0") || CPLib.eqr(xStato,"1"))) || CPLib.eqr(w_flgsto,"S")) {
        /* _conta4 := _conta4 + 1 */
        _conta4 = CPLib.Round(_conta4+1,0);
        // * --- Insert into tipo4 from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tipo4");
        m_cPhName = m_Ctx.GetPhName("tipo4");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tipo4")+" (";
        m_cSql = m_cSql+GetFieldsName_078AC0E8(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,1,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,3,11),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,14,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,15,20),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,35,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,51,70),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,121,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,124,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,130,30),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,160,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,162,35),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,197,5),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,202,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(_note,218,8)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,226,30),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,291,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,293,15),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(_note,308,8)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,316,30),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,346,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_conta4,"?",0,0)+", ";
        if (m_Ctx.IsSharedTemp("tipo4")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tipo4",true);
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
      /* Case xTipo='5' */
    } else if (CPLib.eqr(xTipo,"5")) {
      /* If (w_flgsto = 'N' and (xStato='0' or xStato='1')) or w_flgsto = 'S' */
      if ((CPLib.eqr(w_flgsto,"N") && (CPLib.eqr(xStato,"0") || CPLib.eqr(xStato,"1"))) || CPLib.eqr(w_flgsto,"S")) {
        /* _conta5 := _conta5 + 1 */
        _conta5 = CPLib.Round(_conta5+1,0);
        // * --- Insert into tipo5 from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tipo5");
        m_cPhName = m_Ctx.GetPhName("tipo5");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tipo5")+" (";
        m_cSql = m_cSql+GetFieldsName_078AE6E0(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,1,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,3,11),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,14,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,15,20),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,35,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,51,70),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,121,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,124,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,130,30),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,160,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,162,35),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,197,5),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,265,25),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_conta5,"?",0,0)+", ";
        if (m_Ctx.IsSharedTemp("tipo5")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tipo5",true);
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
      /* Case xTipo='6' */
    } else if (CPLib.eqr(xTipo,"6")) {
      /* If (w_flgsto = 'N' and (xStato='0' or xStato='1')) or w_flgsto = 'S' */
      if ((CPLib.eqr(w_flgsto,"N") && (CPLib.eqr(xStato,"0") || CPLib.eqr(xStato,"1"))) || CPLib.eqr(w_flgsto,"S")) {
        /* _conta6 := _conta6 + 1 */
        _conta6 = CPLib.Round(_conta6+1,0);
        // * --- Insert into tipo6 from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tipo6");
        m_cPhName = m_Ctx.GetPhName("tipo6");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tipo6")+" (";
        m_cSql = m_cSql+GetFieldsName_07DB0108(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,1,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,3,11),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,14,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,15,20),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,35,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,51,70),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,121,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,124,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,130,30),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,160,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,162,35),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,197,5),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,202,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(_note,218,8)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,226,30),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,291,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,293,15),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(_note,308,8)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,316,30),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_note,346,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_conta6,"?",0,0)+", ";
        if (m_Ctx.IsSharedTemp("tipo6")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tipo6",true);
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
    } // End Case
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
      m_Caller.SetString("codinter","C",11,0,w_codinter);
      m_Caller.SetString("tipinter","C",2,0,w_tipinter);
      m_Caller.SetDate("DaData","D",8,0,w_DaData);
      m_Caller.SetDate("AData","D",8,0,w_AData);
      m_Caller.SetString("tipoarch","C",1,0,w_tipoarch);
      m_Caller.SetString("codage","C",6,0,w_codage);
      m_Caller.SetString("flgope","C",1,0,w_flgope);
      m_Caller.SetString("flgfrz","C",1,0,w_flgfrz);
      m_Caller.SetString("flgint","C",1,0,w_flgint);
      m_Caller.SetString("flgrae","C",1,0,w_flgrae);
      m_Caller.SetString("flgrap","C",1,0,w_flgrap);
      m_Caller.SetString("tiprap","C",1,0,w_tiprap);
      m_Caller.SetString("codcli","C",10,0,w_codcli);
      m_Caller.SetString("ragben","C",70,0,w_ragben);
      m_Caller.SetString("flgsto","C",1,0,w_flgsto);
      m_Caller.SetString("flgchk","C",1,0,w_flgchk);
      m_Caller.SetString("flgdel","C",1,0,w_flgdel);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_chkdiana_oldR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_chkdiana_oldR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_codinter = m_Caller.GetString("codinter","C",11,0);
    w_tipinter = m_Caller.GetString("tipinter","C",2,0);
    w_DaData = m_Caller.GetDate("DaData","D",8,0);
    w_AData = m_Caller.GetDate("AData","D",8,0);
    w_tipoarch = m_Caller.GetString("tipoarch","C",1,0);
    w_codage = m_Caller.GetString("codage","C",6,0);
    w_flgope = m_Caller.GetString("flgope","C",1,0);
    w_flgfrz = m_Caller.GetString("flgfrz","C",1,0);
    w_flgint = m_Caller.GetString("flgint","C",1,0);
    w_flgrae = m_Caller.GetString("flgrae","C",1,0);
    w_flgrap = m_Caller.GetString("flgrap","C",1,0);
    w_tiprap = m_Caller.GetString("tiprap","C",1,0);
    w_codcli = m_Caller.GetString("codcli","C",10,0);
    w_ragben = m_Caller.GetString("ragben","C",70,0);
    w_flgsto = m_Caller.GetString("flgsto","C",1,0);
    w_flgchk = m_Caller.GetString("flgchk","C",1,0);
    w_flgdel = m_Caller.GetString("flgdel","C",1,0);
    w_codcab = CPLib.Space(6);
    w_cabcod = CPLib.Space(6);
    w_desccit = CPLib.Space(30);
    w_citdesc = CPLib.Space(30);
    w_provin = CPLib.Space(2);
    w_provind = CPLib.Space(2);
    w_coddipe = CPLib.Space(6);
    _note = "";
    fhand = CPLib.Space(10);
    _nomefile = CPLib.Space(15);
    cNomeFile = CPLib.Space(30);
    cOnlyNomeFile = CPLib.Space(30);
    cNomeFileZip = CPLib.Space(30);
    nTotRec = 0;
    nTotReg = 0;
    nNumRec = 0;
    _avanza = 0;
    _codrif = CPLib.Space(16);
    w_cdadata = CPLib.Space(8);
    w_c_adata = CPLib.Space(8);
    w_cdadata_rap = CPLib.Space(8);
    w_c_adata_rap = CPLib.Space(8);
    _ctotale = 0;
    _conta = 0;
    _max = 0;
    _min = 0;
    _top = 0;
    _bottom = 0;
    _cicli = 0;
    _contacilci = 0;
    _flagrap = CPLib.Space(1);
    _ciclo = 0;
    _ramate = CPLib.Space(3);
    _numsto = CPLib.Space(15);
    _oldrighe = 0;
    _continua = 0;
    _oldrap = CPLib.Space(25);
    _idereg = CPLib.Space(20);
    xStato = CPLib.Space(1);
    _conta1 = 0;
    _conta2 = 0;
    _conta4 = 0;
    _conta5 = 0;
    _conta6 = 0;
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gNumRec=m_Ctx.GetGlobalNumber("gNumRec");
    gNumReg=m_Ctx.GetGlobalNumber("gNumReg");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gFlgWU=m_Ctx.GetGlobalString("gFlgWU");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_rapd_chkdiana,qbe_rapp_chkdiana,qbe_oped_chkdiana_limits,qbe_oped_chkdiana,qbe_opep_chkdiana_limits,qbe_opep_chkdiana,qbe_frad_chkdiana_limits,qbe_frad_chkdiana,qbe_frap_chkdiana_limits,qbe_frap_chkdiana,qbe_oped_chkdiana_cli,qbe_opep_chkdiana_cli,qbe_frad_chkdiana_cli,qbe_frap_chkdiana_cli,
  public static final String m_cVQRList = ",qbe_rapd_chkdiana,qbe_rapp_chkdiana,qbe_oped_chkdiana_limits,qbe_oped_chkdiana,qbe_opep_chkdiana_limits,qbe_opep_chkdiana,qbe_frad_chkdiana_limits,qbe_frad_chkdiana,qbe_frap_chkdiana_limits,qbe_frap_chkdiana,qbe_oped_chkdiana_cli,qbe_opep_chkdiana_cli,qbe_frad_chkdiana_cli,qbe_frap_chkdiana_cli,";
  // ENTITY_BATCHES: ,arfn_agechar,arfn_chkspers,arfn_dateminus,arfn_datisog_sol,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_agechar,arfn_chkspers,arfn_dateminus,arfn_datisog_sol,arfn_fdatetime,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_078A74F8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"A01A,";
    p_cSql = p_cSql+"A01B,";
    p_cSql = p_cSql+"A02,";
    p_cSql = p_cSql+"A03,";
    p_cSql = p_cSql+"A11,";
    p_cSql = p_cSql+"A12A,";
    p_cSql = p_cSql+"A12B,";
    p_cSql = p_cSql+"A12C,";
    p_cSql = p_cSql+"A21,";
    p_cSql = p_cSql+"A22,";
    p_cSql = p_cSql+"A23,";
    p_cSql = p_cSql+"A24,";
    p_cSql = p_cSql+"A25,";
    p_cSql = p_cSql+"A31A,";
    p_cSql = p_cSql+"A31B,";
    p_cSql = p_cSql+"A32,";
    p_cSql = p_cSql+"A33A,";
    p_cSql = p_cSql+"A33B,";
    p_cSql = p_cSql+"A33C,";
    p_cSql = p_cSql+"A34,";
    p_cSql = p_cSql+"A41,";
    p_cSql = p_cSql+"A42,";
    p_cSql = p_cSql+"A43,";
    p_cSql = p_cSql+"A51,";
    p_cSql = p_cSql+"A52,";
    p_cSql = p_cSql+"A53,";
    p_cSql = p_cSql+"A54A,";
    p_cSql = p_cSql+"A54B,";
    p_cSql = p_cSql+"A54C,";
    p_cSql = p_cSql+"B11,";
    p_cSql = p_cSql+"B12,";
    p_cSql = p_cSql+"B13,";
    p_cSql = p_cSql+"B14,";
    p_cSql = p_cSql+"B15,";
    p_cSql = p_cSql+"PROG,";
    if (p_Ctx.IsSharedTemp("tipo1")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tipo1",true);
    return p_cSql;
  }
  protected static String GetFieldsName_078AA0D8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"A01A,";
    p_cSql = p_cSql+"A01B,";
    p_cSql = p_cSql+"A02,";
    p_cSql = p_cSql+"A03,";
    p_cSql = p_cSql+"C11,";
    p_cSql = p_cSql+"D11,";
    p_cSql = p_cSql+"D13,";
    p_cSql = p_cSql+"D14A,";
    p_cSql = p_cSql+"D14B,";
    p_cSql = p_cSql+"D14C,";
    p_cSql = p_cSql+"D15,";
    p_cSql = p_cSql+"D16,";
    p_cSql = p_cSql+"D17,";
    p_cSql = p_cSql+"D18,";
    p_cSql = p_cSql+"D19,";
    p_cSql = p_cSql+"D21,";
    p_cSql = p_cSql+"D22,";
    p_cSql = p_cSql+"D23,";
    p_cSql = p_cSql+"D31,";
    p_cSql = p_cSql+"D32,";
    p_cSql = p_cSql+"D41,";
    p_cSql = p_cSql+"D42,";
    p_cSql = p_cSql+"D43,";
    p_cSql = p_cSql+"D44,";
    p_cSql = p_cSql+"D45,";
    p_cSql = p_cSql+"PROG,";
    if (p_Ctx.IsSharedTemp("tipo2_3")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tipo2_3",true);
    return p_cSql;
  }
  protected static String GetFieldsName_078AC0E8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"A01A,";
    p_cSql = p_cSql+"A01B,";
    p_cSql = p_cSql+"A02,";
    p_cSql = p_cSql+"A03,";
    p_cSql = p_cSql+"C21,";
    p_cSql = p_cSql+"E11,";
    p_cSql = p_cSql+"E13,";
    p_cSql = p_cSql+"E14A,";
    p_cSql = p_cSql+"E14B,";
    p_cSql = p_cSql+"E14C,";
    p_cSql = p_cSql+"E15,";
    p_cSql = p_cSql+"E16,";
    p_cSql = p_cSql+"E17,";
    p_cSql = p_cSql+"E18,";
    p_cSql = p_cSql+"E19,";
    p_cSql = p_cSql+"E41,";
    p_cSql = p_cSql+"E42,";
    p_cSql = p_cSql+"E43,";
    p_cSql = p_cSql+"E44,";
    p_cSql = p_cSql+"E45,";
    p_cSql = p_cSql+"PROG,";
    if (p_Ctx.IsSharedTemp("tipo4")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tipo4",true);
    return p_cSql;
  }
  protected static String GetFieldsName_078AE6E0(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"A01A,";
    p_cSql = p_cSql+"A01B,";
    p_cSql = p_cSql+"A02,";
    p_cSql = p_cSql+"A03,";
    p_cSql = p_cSql+"C31,";
    p_cSql = p_cSql+"F11,";
    p_cSql = p_cSql+"F13,";
    p_cSql = p_cSql+"F14A,";
    p_cSql = p_cSql+"F14B,";
    p_cSql = p_cSql+"F14C,";
    p_cSql = p_cSql+"F15,";
    p_cSql = p_cSql+"F16,";
    p_cSql = p_cSql+"F31,";
    p_cSql = p_cSql+"PROG,";
    if (p_Ctx.IsSharedTemp("tipo5")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tipo5",true);
    return p_cSql;
  }
  protected static String GetFieldsName_07DB0108(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"A01A,";
    p_cSql = p_cSql+"A01B,";
    p_cSql = p_cSql+"A02,";
    p_cSql = p_cSql+"A03,";
    p_cSql = p_cSql+"C41,";
    p_cSql = p_cSql+"G11,";
    p_cSql = p_cSql+"G13,";
    p_cSql = p_cSql+"G14A,";
    p_cSql = p_cSql+"G14B,";
    p_cSql = p_cSql+"G14C,";
    p_cSql = p_cSql+"G15,";
    p_cSql = p_cSql+"G16,";
    p_cSql = p_cSql+"G17,";
    p_cSql = p_cSql+"G18,";
    p_cSql = p_cSql+"G19,";
    p_cSql = p_cSql+"G41,";
    p_cSql = p_cSql+"G42,";
    p_cSql = p_cSql+"G43,";
    p_cSql = p_cSql+"G44,";
    p_cSql = p_cSql+"G45,";
    p_cSql = p_cSql+"PROG,";
    if (p_Ctx.IsSharedTemp("tipo6")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tipo6",true);
    return p_cSql;
  }
}
