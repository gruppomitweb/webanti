// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_chkdiana_mtR implements CallerWithObjs {
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
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public String m_cPhName_xntestbo;
  public String m_cServer_xntestbo;
  public String m_cPhName_xnarapbo;
  public String m_cServer_xnarapbo;
  public String m_cPhName_kersonbo;
  public String m_cServer_kersonbo;
  public String m_cPhName_clientiope;
  public String m_cServer_clientiope;
  public String m_cPhName_sogopebo;
  public String m_cServer_sogopebo;
  public String m_cPhName_beneficope;
  public String m_cServer_beneficope;
  public String m_cPhName_terzistiope;
  public String m_cServer_terzistiope;
  public String m_cPhName_xlientiope;
  public String m_cServer_xlientiope;
  public String m_cPhName_xogopebo;
  public String m_cServer_xogopebo;
  public String m_cPhName_xeneficope;
  public String m_cServer_xeneficope;
  public String m_cPhName_xerzistiope;
  public String m_cServer_xerzistiope;
  public String m_cPhName_clientifrz;
  public String m_cServer_clientifrz;
  public String m_cPhName_sogopefbo;
  public String m_cServer_sogopefbo;
  public String m_cPhName_beneficfrz;
  public String m_cServer_beneficfrz;
  public String m_cPhName_terzistifrz;
  public String m_cServer_terzistifrz;
  public String m_cPhName_xlientifrz;
  public String m_cServer_xlientifrz;
  public String m_cPhName_xogopefbo;
  public String m_cServer_xogopefbo;
  public String m_cPhName_xeneficfrz;
  public String m_cServer_xeneficfrz;
  public String m_cPhName_xerzistifrz;
  public String m_cServer_xerzistifrz;
  public String m_cPhName_rapotit;
  public String m_cServer_rapotit;
  public String m_cPhName_knarapbo;
  public String m_cServer_knarapbo;
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
  public String w_codinter;
  public String w_tipinter;
  public java.sql.Date w_DaData;
  public java.sql.Date w_AData;
  public String w_tipoarch;
  public String w_codage;
  public String w_flgope;
  public String w_flgfrz;
  public String gPathApp;
  public String gIntemediario;
  public String gUrlApp;
  public String gAzienda;
  public double gNumRec;
  public double gNumReg;
  public String gMsgImp;
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
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_chkdiana_mtR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_chkdiana_mt",m_Caller);
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    if (m_cPhName_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo = m_cPhName_operazbo+" "+m_Ctx.GetWritePhName("operazbo");
    }
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    if (m_cPhName_anadip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anadip = m_cPhName_anadip+" "+m_Ctx.GetWritePhName("anadip");
    }
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_rapopebo = p_ContextObject.GetPhName("rapopebo");
    if (m_cPhName_rapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapopebo = m_cPhName_rapopebo+" "+m_Ctx.GetWritePhName("rapopebo");
    }
    m_cServer_rapopebo = p_ContextObject.GetServer("rapopebo");
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    if (m_cPhName_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anarapbo = m_cPhName_anarapbo+" "+m_Ctx.GetWritePhName("anarapbo");
    }
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_fraziobo = p_ContextObject.GetPhName("fraziobo");
    if (m_cPhName_fraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fraziobo = m_cPhName_fraziobo+" "+m_Ctx.GetWritePhName("fraziobo");
    }
    m_cServer_fraziobo = p_ContextObject.GetServer("fraziobo");
    m_cPhName_xntestbo = p_ContextObject.GetPhName("xntestbo");
    if (m_cPhName_xntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xntestbo = m_cPhName_xntestbo+" "+m_Ctx.GetWritePhName("xntestbo");
    }
    m_cServer_xntestbo = p_ContextObject.GetServer("xntestbo");
    m_cPhName_xnarapbo = p_ContextObject.GetPhName("xnarapbo");
    if (m_cPhName_xnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xnarapbo = m_cPhName_xnarapbo+" "+m_Ctx.GetWritePhName("xnarapbo");
    }
    m_cServer_xnarapbo = p_ContextObject.GetServer("xnarapbo");
    m_cPhName_kersonbo = p_ContextObject.GetPhName("kersonbo");
    if (m_cPhName_kersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_kersonbo = m_cPhName_kersonbo+" "+m_Ctx.GetWritePhName("kersonbo");
    }
    m_cServer_kersonbo = p_ContextObject.GetServer("kersonbo");
    m_cPhName_clientiope = p_ContextObject.GetPhName("clientiope");
    if (m_cPhName_clientiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_clientiope = m_cPhName_clientiope+" "+m_Ctx.GetWritePhName("clientiope");
    }
    m_cServer_clientiope = p_ContextObject.GetServer("clientiope");
    m_cPhName_sogopebo = p_ContextObject.GetPhName("sogopebo");
    if (m_cPhName_sogopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sogopebo = m_cPhName_sogopebo+" "+m_Ctx.GetWritePhName("sogopebo");
    }
    m_cServer_sogopebo = p_ContextObject.GetServer("sogopebo");
    m_cPhName_beneficope = p_ContextObject.GetPhName("beneficope");
    if (m_cPhName_beneficope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_beneficope = m_cPhName_beneficope+" "+m_Ctx.GetWritePhName("beneficope");
    }
    m_cServer_beneficope = p_ContextObject.GetServer("beneficope");
    m_cPhName_terzistiope = p_ContextObject.GetPhName("terzistiope");
    if (m_cPhName_terzistiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_terzistiope = m_cPhName_terzistiope+" "+m_Ctx.GetWritePhName("terzistiope");
    }
    m_cServer_terzistiope = p_ContextObject.GetServer("terzistiope");
    m_cPhName_xlientiope = p_ContextObject.GetPhName("xlientiope");
    if (m_cPhName_xlientiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xlientiope = m_cPhName_xlientiope+" "+m_Ctx.GetWritePhName("xlientiope");
    }
    m_cServer_xlientiope = p_ContextObject.GetServer("xlientiope");
    m_cPhName_xogopebo = p_ContextObject.GetPhName("xogopebo");
    if (m_cPhName_xogopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xogopebo = m_cPhName_xogopebo+" "+m_Ctx.GetWritePhName("xogopebo");
    }
    m_cServer_xogopebo = p_ContextObject.GetServer("xogopebo");
    m_cPhName_xeneficope = p_ContextObject.GetPhName("xeneficope");
    if (m_cPhName_xeneficope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xeneficope = m_cPhName_xeneficope+" "+m_Ctx.GetWritePhName("xeneficope");
    }
    m_cServer_xeneficope = p_ContextObject.GetServer("xeneficope");
    m_cPhName_xerzistiope = p_ContextObject.GetPhName("xerzistiope");
    if (m_cPhName_xerzistiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xerzistiope = m_cPhName_xerzistiope+" "+m_Ctx.GetWritePhName("xerzistiope");
    }
    m_cServer_xerzistiope = p_ContextObject.GetServer("xerzistiope");
    m_cPhName_clientifrz = p_ContextObject.GetPhName("clientifrz");
    if (m_cPhName_clientifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_clientifrz = m_cPhName_clientifrz+" "+m_Ctx.GetWritePhName("clientifrz");
    }
    m_cServer_clientifrz = p_ContextObject.GetServer("clientifrz");
    m_cPhName_sogopefbo = p_ContextObject.GetPhName("sogopefbo");
    if (m_cPhName_sogopefbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sogopefbo = m_cPhName_sogopefbo+" "+m_Ctx.GetWritePhName("sogopefbo");
    }
    m_cServer_sogopefbo = p_ContextObject.GetServer("sogopefbo");
    m_cPhName_beneficfrz = p_ContextObject.GetPhName("beneficfrz");
    if (m_cPhName_beneficfrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_beneficfrz = m_cPhName_beneficfrz+" "+m_Ctx.GetWritePhName("beneficfrz");
    }
    m_cServer_beneficfrz = p_ContextObject.GetServer("beneficfrz");
    m_cPhName_terzistifrz = p_ContextObject.GetPhName("terzistifrz");
    if (m_cPhName_terzistifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_terzistifrz = m_cPhName_terzistifrz+" "+m_Ctx.GetWritePhName("terzistifrz");
    }
    m_cServer_terzistifrz = p_ContextObject.GetServer("terzistifrz");
    m_cPhName_xlientifrz = p_ContextObject.GetPhName("xlientifrz");
    if (m_cPhName_xlientifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xlientifrz = m_cPhName_xlientifrz+" "+m_Ctx.GetWritePhName("xlientifrz");
    }
    m_cServer_xlientifrz = p_ContextObject.GetServer("xlientifrz");
    m_cPhName_xogopefbo = p_ContextObject.GetPhName("xogopefbo");
    if (m_cPhName_xogopefbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xogopefbo = m_cPhName_xogopefbo+" "+m_Ctx.GetWritePhName("xogopefbo");
    }
    m_cServer_xogopefbo = p_ContextObject.GetServer("xogopefbo");
    m_cPhName_xeneficfrz = p_ContextObject.GetPhName("xeneficfrz");
    if (m_cPhName_xeneficfrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xeneficfrz = m_cPhName_xeneficfrz+" "+m_Ctx.GetWritePhName("xeneficfrz");
    }
    m_cServer_xeneficfrz = p_ContextObject.GetServer("xeneficfrz");
    m_cPhName_xerzistifrz = p_ContextObject.GetPhName("xerzistifrz");
    if (m_cPhName_xerzistifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xerzistifrz = m_cPhName_xerzistifrz+" "+m_Ctx.GetWritePhName("xerzistifrz");
    }
    m_cServer_xerzistifrz = p_ContextObject.GetServer("xerzistifrz");
    m_cPhName_rapotit = p_ContextObject.GetPhName("rapotit");
    if (m_cPhName_rapotit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapotit = m_cPhName_rapotit+" "+m_Ctx.GetWritePhName("rapotit");
    }
    m_cServer_rapotit = p_ContextObject.GetServer("rapotit");
    m_cPhName_knarapbo = p_ContextObject.GetPhName("knarapbo");
    if (m_cPhName_knarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_knarapbo = m_cPhName_knarapbo+" "+m_Ctx.GetWritePhName("knarapbo");
    }
    m_cServer_knarapbo = p_ContextObject.GetServer("knarapbo");
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
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_chkdiana_mt";
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
    if (CPLib.eqr("_flagrap",p_cVarName)) {
      return _flagrap;
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
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
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
    if (CPLib.eqr("_flagrap",p_cVarName)) {
      _flagrap = value;
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
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
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
    /* gPathApp Char(80) // Path Applicazione */
    /* gIntemediario Char(11) // Intermediario */
    /* gUrlApp Char(80) // URL Applicazione */
    /* gAzienda Char(10) // Azienda */
    /* gNumRec Numeric(15, 0) // N° Record DIANA */
    /* gNumReg Numeric(15, 0) // N° Registrazioni DIANA */
    /* gMsgImp Char(120) // Messaggio Import */
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
    /* If w_flgope = 'S' */
    if (CPLib.eqr(w_flgope,"S")) {
      /* Exec "Operazioni" Page 2:Page_2 */
      Page_2();
    } // End If
    /* If w_flgfrz = 'S' */
    if (CPLib.eqr(w_flgfrz,"S")) {
      /* Exec "Frazionate" Page 4:Page_4 */
      Page_4();
    } // End If
    /* Exec "Informazioni" Page 3:Page_3 */
    Page_3();
    /* Exec "Titolari" Page 5:Page_5 */
    Page_5();
    /* gMsgImp := 'Elaborazione terminata. Chiamare assistenza per procedura successiva' // Messaggio Import */
    gMsgImp = "Elaborazione terminata. Chiamare assistenza per procedura successiva";
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_qbe_oped_chkdiana_limits=null;
    CPResultSet Cursor_qbe_oped_chkdiana=null;
    CPResultSet Cursor_knarapbo=null;
    CPResultSet Cursor_xnarapbo=null;
    CPResultSet Cursor_anarapbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_anadip=null;
    CPResultSet Cursor_kersonbo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_clientiope=null;
    CPResultSet Cursor_sogopebo=null;
    CPResultSet Cursor_beneficope=null;
    CPResultSet Cursor_terzistiope=null;
    CPResultSet Cursor_qbe_opep_chkdiana_limits=null;
    CPResultSet Cursor_qbe_opep_chkdiana=null;
    CPResultSet Cursor_xlientiope=null;
    CPResultSet Cursor_xogopebo=null;
    CPResultSet Cursor_xeneficope=null;
    CPResultSet Cursor_xerzistiope=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Cicla sulle operazioni */
      /* If w_tipoarch = 'D' */
      if (CPLib.eqr(w_tipoarch,"D")) {
        /* Cicla sulle informazioni sui rapporti */
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
        SPBridge.HMCaller _h00000046;
        _h00000046 = new SPBridge.HMCaller();
        _h00000046.Set("m_cVQRList",m_cVQRList);
        _h00000046.Set("cdadata",w_cdadata);
        _h00000046.Set("c_adata",w_c_adata);
        _h00000046.Set("codage",w_codage);
        if (Cursor_qbe_oped_chkdiana_limits!=null)
          Cursor_qbe_oped_chkdiana_limits.Close();
        Cursor_qbe_oped_chkdiana_limits = new VQRHolder("qbe_oped_chkdiana_limits",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000046,true).GetResultSet(m_Ctx);
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
          /* _nomefile := 'campione.txt.'+Right('0000'+LRTrim(Str(_conta,4,0)),4) */
          _nomefile = "campione.txt."+CPLib.Right("0000"+CPLib.LRTrim(CPLib.Str(_conta,4,0)),4);
          /* fhand := FileLibMit.OpenWrite('./flussi/'+LRTrim(gAzienda)+"/"+LRTrim(_nomefile)) */
          fhand = FileLibMit.OpenWrite("./flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_nomefile));
          /* Cicla sulle operazioni */
          // * --- Select from qbe_oped_chkdiana
          SPBridge.HMCaller _h00000058;
          _h00000058 = new SPBridge.HMCaller();
          _h00000058.Set("m_cVQRList",m_cVQRList);
          _h00000058.Set("cdadata",w_cdadata);
          _h00000058.Set("c_adata",w_c_adata);
          _h00000058.Set("codage",w_codage);
          _h00000058.Set("_bottom",_bottom);
          _h00000058.Set("_top",_top);
          if (Cursor_qbe_oped_chkdiana!=null)
            Cursor_qbe_oped_chkdiana.Close();
          Cursor_qbe_oped_chkdiana = new VQRHolder("qbe_oped_chkdiana",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000058,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_oped_chkdiana.Eof())) {
            /* _ctotale := _ctotale + 1 */
            _ctotale = CPLib.Round(_ctotale+1,0);
            /* gMsgImp := 'Elaborazione Operazione N.: '+LRTrim(Str(_ctotale,15,0)) // Messaggio Import */
            gMsgImp = "Elaborazione Operazione N.: "+CPLib.LRTrim(CPLib.Str(_ctotale,15,0));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* _note := w_tipinter + w_codinter + '1' */
            _note = w_tipinter+w_codinter+"1";
            /* If Empty(LRTrim(qbe_oped_chkdiana->FLAGRAP2)) */
            if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("FLAGRAP2")))) {
              /* _note := _note + DateToChar(qbe_oped_chkdiana->DATAOPE) + qbe_oped_chkdiana->NUMPROG + 'S' */
              _note = _note+CPLib.DateToChar(Cursor_qbe_oped_chkdiana.GetDate("DATAOPE"))+Cursor_qbe_oped_chkdiana.GetString("NUMPROG")+"S";
            } else { // Else
              /* _note := _note + qbe_oped_chkdiana->IDEREG */
              _note = _note+Cursor_qbe_oped_chkdiana.GetString("IDEREG");
            } // End If
            /* _flagrap := '' */
            _flagrap = "";
            /* If not(Empty(qbe_oped_chkdiana->FLAGRAP)) */
            if ( ! (CPLib.Empty(Cursor_qbe_oped_chkdiana.GetString("FLAGRAP")))) {
              /* _flagrap := qbe_oped_chkdiana->FLAGRAP */
              _flagrap = Cursor_qbe_oped_chkdiana.GetString("FLAGRAP");
            } else { // Else
              // * --- Select from knarapbo
              m_cServer = m_Ctx.GetServer("knarapbo");
              m_cPhName = m_Ctx.GetPhName("knarapbo");
              if (Cursor_knarapbo!=null)
                Cursor_knarapbo.Close();
              Cursor_knarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("knarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_knarapbo.Eof())) {
                /* If knarapbo->TIPORAP='P' */
                if (CPLib.eqr(Cursor_knarapbo.GetString("TIPORAP"),"P")) {
                  // * --- Select from xnarapbo
                  m_cServer = m_Ctx.GetServer("xnarapbo");
                  m_cPhName = m_Ctx.GetPhName("xnarapbo");
                  if (Cursor_xnarapbo!=null)
                    Cursor_xnarapbo.Close();
                  Cursor_xnarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select TIPORAP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xnarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_xnarapbo.Eof())) {
                    /* _flagrap := xnarapbo->TIPORAP */
                    _flagrap = Cursor_xnarapbo.GetString("TIPORAP");
                    Cursor_xnarapbo.Next();
                  }
                  m_cConnectivityError = Cursor_xnarapbo.ErrorMessage();
                  Cursor_xnarapbo.Close();
                  // * --- End Select
                } else { // Else
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
                } // End If
                Cursor_knarapbo.Next();
              }
              m_cConnectivityError = Cursor_knarapbo.ErrorMessage();
              Cursor_knarapbo.Close();
              // * --- End Select
            } // End If
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
                  Error l_oErrorFault = new Error("Read on intermbo into routine arrt_chkdiana_mt returns two or more records. This item should return only a record.");
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
                    Error l_oErrorFault = new Error("Read on anadip into routine arrt_chkdiana_mt returns two or more records. This item should return only a record.");
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
            /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->TIPOINT2)+Space(2),2) + Left(LRTrim(qbe_oped_chkdiana->CODFISCICP)+Space(11),11) + Left(LRTrim(qbe_oped_chkdiana->PAESE)+Space(3),3) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("TIPOINT2"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("CODFISCICP"))+CPLib.Space(11),11)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("PAESE"))+CPLib.Space(3),3);
            /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->CODCAB2)+Space(6),6) + Left(LRTrim(qbe_oped_chkdiana->DESC2)+Space(30),30) + Left(LRTrim(qbe_oped_chkdiana->PROV2)+Space(2),2) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("CODCAB2"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("DESC2"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("PROV2"))+CPLib.Space(2),2);
            /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->DESCINTER)+Space(50),50) + Left(LRTrim(qbe_oped_chkdiana->RAPPORTO)+Space(25),25) + Left(LRTrim(_flagrap)+" ",1) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("DESCINTER"))+CPLib.Space(50),50)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"))+CPLib.Space(25),25)+CPLib.Left(CPLib.LRTrim(_flagrap)+" ",1);
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
            /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->OPERAZMOD)+Space(20),20) + Left(LRTrim(qbe_oped_chkdiana->FLAGLIRE)+" ",1) + Left(LRTrim(qbe_oped_chkdiana->VALUTA)+Space(3),3) + Left(LRTrim(qbe_oped_chkdiana->SEGNO)+" ",1) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("OPERAZMOD"))+CPLib.Space(20),20)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("FLAGLIRE"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("VALUTA"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("SEGNO"))+" ",1);
            /* _note := _note +  Right('000000000000000'+LRTrim(Str(qbe_oped_chkdiana->TOTLIRE,15,0)),15) + Right('000000000000000'+LRTrim(Str(qbe_oped_chkdiana->TOTCONT,15,0)),15) + Space(69) */
            _note = _note+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_oped_chkdiana.GetDouble("TOTLIRE"),15,0)),15)+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_oped_chkdiana.GetDouble("TOTCONT"),15,0)),15)+CPLib.Space(69);
            /* FileLibMit.WriteLine(fhand,_note) */
            FileLibMit.WriteLine(fhand,_note);
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nTotReg := nTotReg + 1 */
            nTotReg = CPLib.Round(nTotReg+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
            /* If not(Empty(qbe_oped_chkdiana->CONNESCLI)) and Empty(LRTrim(qbe_oped_chkdiana->RAPPORTO)) */
            if ( ! (CPLib.Empty(Cursor_qbe_oped_chkdiana.GetString("CONNESCLI"))) && CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("RAPPORTO")))) {
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
                  /* _note := _note + Left(LRTrim(DateToChar(qbe_oped_chkdiana->DATAOPE))+Space(8),8) + qbe_oped_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_oped_chkdiana->STATOREG) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_oped_chkdiana.GetDate("DATAOPE")))+CPLib.Space(8),8)+Cursor_qbe_oped_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_oped_chkdiana.GetString("STATOREG"));
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
                    /* _note := _note + Left(LRTrim(kersonbo->NASSTATO)+Space(30),30) + Left(LRTrim(kersonbo->SOTGRUP)+Space(3),3) + Left(LRTrim(kersonbo->RAMOGRUP)+Space(3),3) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(kersonbo->NASCOMUN)+Space(30),30) + Left(LRTrim(kersonbo->SOTGRUP)+Space(3),3) + Left(LRTrim(kersonbo->RAMOGRUP)+Space(3),3) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                  } // End If
                  /* _note := _note + Left(LRTrim(kersonbo->SETTSINT)+Space(3),3) + Left(LRTrim(qbe_oped_chkdiana->RAPPORTO)+Space(25),25) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"))+CPLib.Space(25),25);
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
                  /* FileLibMit.WriteLine(fhand,_note) */
                  FileLibMit.WriteLine(fhand,_note);
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
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana.GetString("CONNESCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
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
                  /* _note := _note + Left(LRTrim(DateToChar(qbe_oped_chkdiana->DATAOPE))+Space(8),8) + qbe_oped_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_oped_chkdiana->STATOREG) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_oped_chkdiana.GetDate("DATAOPE")))+CPLib.Space(8),8)+Cursor_qbe_oped_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_oped_chkdiana.GetString("STATOREG"));
                  /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->CONNESCLI)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("CONNESCLI"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
                  /* _note := _note + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                  /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
                  /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
                  /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
                  if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                    /* _note := _note + Space(8) */
                    _note = _note+CPLib.Space(8);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                  } // End If
                  /* If not(Empty(personbo->NASSTATO)) */
                  if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                    /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                  } // End If
                  /* _note := _note + Left(LRTrim(personbo->SETTSINT)+Space(3),3) + Left(LRTrim(qbe_oped_chkdiana->RAPPORTO)+Space(25),25) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"))+CPLib.Space(25),25);
                  /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                  /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
                  if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                    /* _note := _note + Space(8) */
                    _note = _note+CPLib.Space(8);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                    _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                  } // End If
                  /* _note := _note + Left(LRTrim(personbo->AUTRILASC)+Space(30),30) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("AUTRILASC"))+CPLib.Space(30),30);
                  /* _note := _note + Left(LRTrim(personbo->SESSO)+" ",1) + Space(34) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SESSO"))+" ",1)+CPLib.Space(34);
                  /* FileLibMit.WriteLine(fhand,_note) */
                  FileLibMit.WriteLine(fhand,_note);
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } // End If
            } else { // Else
              // * --- Select from intestbo
              m_cServer = m_Ctx.GetServer("intestbo");
              m_cPhName = m_Ctx.GetPhName("intestbo");
              if (Cursor_intestbo!=null)
                Cursor_intestbo.Close();
              Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_intestbo.Eof())) {
                /* If (qbe_oped_chkdiana->RAPPORTO+'P') = (intestbo->RAPPORTO+intestbo->TIPOPERS) */
                if (CPLib.eqr((Cursor_qbe_oped_chkdiana.GetString("RAPPORTO")+"P"),(Cursor_intestbo.GetString("RAPPORTO")+Cursor_intestbo.GetString("TIPOPERS")))) {
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
                    // * --- Select from personbo
                    m_cServer = m_Ctx.GetServer("personbo");
                    m_cPhName = m_Ctx.GetPhName("personbo");
                    if (Cursor_personbo!=null)
                      Cursor_personbo.Close();
                    Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_personbo.Eof())) {
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
                      /* _note := _note + Left(LRTrim(DateToChar(qbe_oped_chkdiana->DATAOPE))+Space(8),8) + qbe_oped_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_oped_chkdiana->STATOREG) */
                      _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_oped_chkdiana.GetDate("DATAOPE")))+CPLib.Space(8),8)+Cursor_qbe_oped_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_oped_chkdiana.GetString("STATOREG"));
                      /* _note := _note + Left(LRTrim(intestbo->CODINTER)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
                      _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_intestbo.GetString("CODINTER"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
                      /* _note := _note + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
                      _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                      /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
                      _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
                      /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
                      _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
                      /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
                      if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                        /* _note := _note + Space(8) */
                        _note = _note+CPLib.Space(8);
                      } else { // Else
                        /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                        _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                      } // End If
                      /* If not(Empty(personbo->NASSTATO)) */
                      if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                        /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                      } else { // Else
                        /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                      } // End If
                      /* _note := _note + Left(LRTrim(personbo->SETTSINT)+Space(3),3) + Left(LRTrim(qbe_oped_chkdiana->RAPPORTO)+Space(25),25) */
                      _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"))+CPLib.Space(25),25);
                      /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
                      _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                      /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
                      if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                        /* _note := _note + Space(8) */
                        _note = _note+CPLib.Space(8);
                      } else { // Else
                        /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                        _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                      } // End If
                      /* _note := _note + Left(LRTrim(personbo->AUTRILASC)+Space(30),30) */
                      _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("AUTRILASC"))+CPLib.Space(30),30);
                      /* _note := _note + Left(LRTrim(personbo->SESSO)+" ",1) + Space(34) */
                      _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SESSO"))+" ",1)+CPLib.Space(34);
                      /* FileLibMit.WriteLine(fhand,_note) */
                      FileLibMit.WriteLine(fhand,_note);
                      /* nTotRec := nTotRec + 1 */
                      nTotRec = CPLib.Round(nTotRec+1,0);
                      /* nNumRec := nNumRec + 1 */
                      nNumRec = CPLib.Round(nNumRec+1,0);
                      Cursor_personbo.Next();
                    }
                    m_cConnectivityError = Cursor_personbo.ErrorMessage();
                    Cursor_personbo.Close();
                    // * --- End Select
                  } // End If
                } // End If
                Cursor_intestbo.Next();
              }
              m_cConnectivityError = Cursor_intestbo.ErrorMessage();
              Cursor_intestbo.Close();
              // * --- End Select
            } // End If
            // * --- Select from clientiope
            m_cServer = m_Ctx.GetServer("clientiope");
            m_cPhName = m_Ctx.GetPhName("clientiope");
            if (Cursor_clientiope!=null)
              Cursor_clientiope.Close();
            Cursor_clientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("clientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_clientiope.Eof())) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_clientiope.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
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
                /* _note := _note + Left(LRTrim(DateToChar(qbe_oped_chkdiana->DATAOPE))+Space(8),8) + qbe_oped_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_oped_chkdiana->STATOREG) */
                _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_oped_chkdiana.GetDate("DATAOPE")))+CPLib.Space(8),8)+Cursor_qbe_oped_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_oped_chkdiana.GetString("STATOREG"));
                /* _note := _note + Left(LRTrim(clientiope->CODSOG)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_clientiope.GetString("CODSOG"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
                /* _note := _note + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
                /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
                /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                } // End If
                /* If not(Empty(personbo->NASSTATO)) */
                if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                  /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                } else { // Else
                  /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                } // End If
                /* _note := _note + Left(LRTrim(personbo->SETTSINT)+Space(3),3) + Left(LRTrim(qbe_oped_chkdiana->RAPPORTO)+Space(25),25) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"))+CPLib.Space(25),25);
                /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                } // End If
                /* _note := _note + Left(LRTrim(personbo->AUTRILASC)+Space(30),30) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("AUTRILASC"))+CPLib.Space(30),30);
                /* _note := _note + Left(LRTrim(personbo->SESSO)+" ",1) + Space(34) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SESSO"))+" ",1)+CPLib.Space(34);
                /* FileLibMit.WriteLine(fhand,_note) */
                FileLibMit.WriteLine(fhand,_note);
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
              Cursor_clientiope.Next();
            }
            m_cConnectivityError = Cursor_clientiope.ErrorMessage();
            Cursor_clientiope.Close();
            // * --- End Select
            /* If not(Empty(qbe_oped_chkdiana->CONNESOPER)) and qbe_oped_chkdiana->CONNESOPER <> _codrif */
            if ( ! (CPLib.Empty(Cursor_qbe_oped_chkdiana.GetString("CONNESOPER"))) && CPLib.ne(Cursor_qbe_oped_chkdiana.GetString("CONNESOPER"),_codrif)) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana.GetString("CONNESOPER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                /* _note := w_tipinter + w_codinter+'4' */
                _note = w_tipinter+w_codinter+"4";
                /* _note := _note + DateToChar(qbe_oped_chkdiana->DATAOPE) + qbe_oped_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_oped_chkdiana->STATOREG) */
                _note = _note+CPLib.DateToChar(Cursor_qbe_oped_chkdiana.GetDate("DATAOPE"))+Cursor_qbe_oped_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_oped_chkdiana.GetString("STATOREG"));
                /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->CONNESOPER)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("CONNESOPER"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
                /* _note := _note + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
                /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
                /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                } // End If
                /* If not(Empty(personbo->NASSTATO)) */
                if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                  /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Space(35) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Space(35);
                } else { // Else
                  /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Space(35) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Space(35);
                } // End If
                /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                } // End If
                /* _note := _note + personbo->AUTRILASC + personbo->SESSO + Space(34) */
                _note = _note+Cursor_personbo.GetString("AUTRILASC")+Cursor_personbo.GetString("SESSO")+CPLib.Space(34);
                /* FileLibMit.WriteLine(fhand,_note) */
                FileLibMit.WriteLine(fhand,_note);
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
            } // End If
            // * --- Select from sogopebo
            m_cServer = m_Ctx.GetServer("sogopebo");
            m_cPhName = m_Ctx.GetPhName("sogopebo");
            if (Cursor_sogopebo!=null)
              Cursor_sogopebo.Close();
            Cursor_sogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("sogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_sogopebo.Eof())) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_sogopebo.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                /* _note := w_tipinter + w_codinter+'4' */
                _note = w_tipinter+w_codinter+"4";
                /* _note := _note + DateToChar(qbe_oped_chkdiana->DATAOPE) + qbe_oped_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_oped_chkdiana->STATOREG) */
                _note = _note+CPLib.DateToChar(Cursor_qbe_oped_chkdiana.GetDate("DATAOPE"))+Cursor_qbe_oped_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_oped_chkdiana.GetString("STATOREG"));
                /* _note := _note + Left(LRTrim(sogopebo->CODSOG)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_sogopebo.GetString("CODSOG"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
                /* _note := _note + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
                /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
                /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                } // End If
                /* If not(Empty(personbo->NASSTATO)) */
                if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                  /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Space(35) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Space(35);
                } else { // Else
                  /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Space(35) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Space(35);
                } // End If
                /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                } // End If
                /* _note := _note + personbo->AUTRILASC + personbo->SESSO + Space(34) */
                _note = _note+Cursor_personbo.GetString("AUTRILASC")+Cursor_personbo.GetString("SESSO")+CPLib.Space(34);
                /* FileLibMit.WriteLine(fhand,_note) */
                FileLibMit.WriteLine(fhand,_note);
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
              Cursor_sogopebo.Next();
            }
            m_cConnectivityError = Cursor_sogopebo.ErrorMessage();
            Cursor_sogopebo.Close();
            // * --- End Select
            /* If not(Empty(qbe_oped_chkdiana->CONNESBEN)) or not(Empty(qbe_oped_chkdiana->C_RAG)) */
            if ( ! (CPLib.Empty(Cursor_qbe_oped_chkdiana.GetString("CONNESBEN"))) ||  ! (CPLib.Empty(Cursor_qbe_oped_chkdiana.GetString("C_RAG")))) {
              /* If not(Empty(qbe_oped_chkdiana->CONNESBEN)) */
              if ( ! (CPLib.Empty(Cursor_qbe_oped_chkdiana.GetString("CONNESBEN")))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana.GetString("CONNESBEN"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* _note := w_tipinter + w_codinter+'5' */
                  _note = w_tipinter+w_codinter+"5";
                  /* _note := _note + DateToChar(qbe_oped_chkdiana->DATAOPE) + qbe_oped_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_oped_chkdiana->STATOREG) */
                  _note = _note+CPLib.DateToChar(Cursor_qbe_oped_chkdiana.GetDate("DATAOPE"))+Cursor_qbe_oped_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_oped_chkdiana.GetString("STATOREG"));
                  /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->CONNESBEN)+Space(16),16) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("CONNESBEN"))+CPLib.Space(16),16);
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana->C_RAG))),Left(LRTrim(qbe_oped_chkdiana->C_RAG)+Space(70),70),Left(LRTrim(personbo->RAGSOC)+Space(70),70)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_RAG"))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana->C_STA))),Left(LRTrim(qbe_oped_chkdiana->C_STA)+Space(3),3),Left(LRTrim(personbo->PAESE)+Space(3),3)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana->C_CAB))),Left(LRTrim(qbe_oped_chkdiana->C_CAB)+Space(6),6),Left(LRTrim(personbo->CODCAB)+Space(6),6)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana->C_CTA))),Left(LRTrim(qbe_oped_chkdiana->C_CTA)+Space(30),30),Left(LRTrim(personbo->DESCCIT)+Space(30),30)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_CTA"))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana->C_PRV))),Left(LRTrim(qbe_oped_chkdiana->C_PRV)+Space(2),2),Left(LRTrim(personbo->PROVINCIA)+Space(2),2)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana->C_IND))),Left(LRTrim(qbe_oped_chkdiana->C_IND)+Space(35),35),Left(LRTrim(personbo->DOMICILIO)+Space(35),35)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_IND"))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana->C_CAP))),Left(LRTrim(qbe_oped_chkdiana->C_CAP)+Space(5),5),Left(LRTrim(personbo->CAP)+Space(5),5)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5));
                  /* _note := _note + Space(63) */
                  _note = _note+CPLib.Space(63);
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana->C_RAPPORTO))),Left(LRTrim(qbe_oped_chkdiana->C_RAPPORTO)+Space(25),25),Left(LRTrim(qbe_oped_chkdiana->RAPPORTBEN)+Space(25),25)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_RAPPORTO"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_RAPPORTO"))+CPLib.Space(25),25):CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("RAPPORTBEN"))+CPLib.Space(25),25));
                  /* _note := _note + Space(91) */
                  _note = _note+CPLib.Space(91);
                  /* FileLibMit.WriteLine(fhand,_note) */
                  FileLibMit.WriteLine(fhand,_note);
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
                /* ElseIf not(Empty(qbe_oped_chkdiana->C_RAG)) */
              } else if ( ! (CPLib.Empty(Cursor_qbe_oped_chkdiana.GetString("C_RAG")))) {
                /* _note := w_tipinter + w_codinter+'5' */
                _note = w_tipinter+w_codinter+"5";
                /* _note := _note + DateToChar(qbe_oped_chkdiana->DATAOPE) + qbe_oped_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_oped_chkdiana->STATOREG) */
                _note = _note+CPLib.DateToChar(Cursor_qbe_oped_chkdiana.GetDate("DATAOPE"))+Cursor_qbe_oped_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_oped_chkdiana.GetString("STATOREG"));
                /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->CONNESBEN)+Space(16),16) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("CONNESBEN"))+CPLib.Space(16),16);
                /* _note := _note +Left(LRTrim(qbe_oped_chkdiana->C_RAG)+Space(70),70) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_RAG"))+CPLib.Space(70),70);
                /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->C_STA)+Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_STA"))+CPLib.Space(3),3);
                /* _note := _note +Left(LRTrim(qbe_oped_chkdiana->C_CAB)+Space(6),6) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_CAB"))+CPLib.Space(6),6);
                /* _note := _note +Left(LRTrim(qbe_oped_chkdiana->C_CTA)+Space(30),30) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_CTA"))+CPLib.Space(30),30);
                /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->C_PRV)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_PRV"))+CPLib.Space(2),2);
                /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->C_IND)+Space(35),35) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_IND"))+CPLib.Space(35),35);
                /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->C_CAP)+Space(5),5) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_CAP"))+CPLib.Space(5),5);
                /* _note := _note + Space(63) */
                _note = _note+CPLib.Space(63);
                /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->C_RAPPORTO)+Space(25),25) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                /* _note := _note + Space(91) */
                _note = _note+CPLib.Space(91);
                /* FileLibMit.WriteLine(fhand,_note) */
                FileLibMit.WriteLine(fhand,_note);
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
              } // End If
            } // End If
            // * --- Select from beneficope
            m_cServer = m_Ctx.GetServer("beneficope");
            m_cPhName = m_Ctx.GetPhName("beneficope");
            if (Cursor_beneficope!=null)
              Cursor_beneficope.Close();
            Cursor_beneficope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("beneficope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_beneficope.Eof())) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_beneficope.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                /* _note := w_tipinter + w_codinter+'5' */
                _note = w_tipinter+w_codinter+"5";
                /* _note := _note + DateToChar(qbe_oped_chkdiana->DATAOPE) + qbe_oped_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_oped_chkdiana->STATOREG) */
                _note = _note+CPLib.DateToChar(Cursor_qbe_oped_chkdiana.GetDate("DATAOPE"))+Cursor_qbe_oped_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_oped_chkdiana.GetString("STATOREG"));
                /* _note := _note + Left(LRTrim(beneficope->CODSOG)+Space(16),16) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("CODSOG"))+CPLib.Space(16),16);
                /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_RAG))),Left(LRTrim(beneficope->C_RAG)+Space(70),70),Left(LRTrim(personbo->RAGSOC)+Space(70),70)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_RAG"))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70));
                /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_STA))),Left(LRTrim(beneficope->C_STA)+Space(3),3),Left(LRTrim(personbo->PAESE)+Space(3),3)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3));
                /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_CAB))),Left(LRTrim(beneficope->C_CAB)+Space(6),6),Left(LRTrim(personbo->CODCAB)+Space(6),6)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6));
                /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_CTA))),Left(LRTrim(beneficope->C_CTA)+Space(30),30),Left(LRTrim(personbo->DESCCIT)+Space(30),30)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_CTA"))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30));
                /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_PRV))),Left(LRTrim(beneficope->C_PRV)+Space(2),2),Left(LRTrim(personbo->PROVINCIA)+Space(2),2)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_IND))),Left(LRTrim(beneficope->C_IND)+Space(35),35),Left(LRTrim(personbo->DOMICILIO)+Space(35),35)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_IND"))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35));
                /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_CAP))),Left(LRTrim(beneficope->C_CAP)+Space(5),5),Left(LRTrim(personbo->CAP)+Space(5),5)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5));
                /* _note := _note + Space(63) */
                _note = _note+CPLib.Space(63);
                /* _note := _note +Left(LRTrim(beneficope->C_RAPPORTO)+Space(25),25) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                /* _note := _note + Space(91) */
                _note = _note+CPLib.Space(91);
                /* FileLibMit.WriteLine(fhand,_note) */
                FileLibMit.WriteLine(fhand,_note);
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
              Cursor_beneficope.Next();
            }
            m_cConnectivityError = Cursor_beneficope.ErrorMessage();
            Cursor_beneficope.Close();
            // * --- End Select
            /* If not(Empty(qbe_oped_chkdiana->CONNALTRO)) */
            if ( ! (CPLib.Empty(Cursor_qbe_oped_chkdiana.GetString("CONNALTRO")))) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana.GetString("CONNALTRO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                /* _note := w_tipinter + w_codinter+'6' */
                _note = w_tipinter+w_codinter+"6";
                /* _note := _note + DateToChar(qbe_oped_chkdiana->DATAOPE) + qbe_oped_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_oped_chkdiana->STATOREG) */
                _note = _note+CPLib.DateToChar(Cursor_qbe_oped_chkdiana.GetDate("DATAOPE"))+Cursor_qbe_oped_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_oped_chkdiana.GetString("STATOREG"));
                /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->CONNALTRO)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("CONNALTRO"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
                /* _note := _note + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
                /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
                /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                } // End If
                /* If not(Empty(personbo->NASSTATO)) */
                if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                  /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Space(35) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Space(35);
                } else { // Else
                  /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Space(35) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Space(35);
                } // End If
                /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                } // End If
                /* _note := _note + personbo->AUTRILASC + personbo->SESSO + Space(34) */
                _note = _note+Cursor_personbo.GetString("AUTRILASC")+Cursor_personbo.GetString("SESSO")+CPLib.Space(34);
                /* FileLibMit.WriteLine(fhand,_note) */
                FileLibMit.WriteLine(fhand,_note);
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
            } // End If
            // * --- Select from terzistiope
            m_cServer = m_Ctx.GetServer("terzistiope");
            m_cPhName = m_Ctx.GetPhName("terzistiope");
            if (Cursor_terzistiope!=null)
              Cursor_terzistiope.Close();
            Cursor_terzistiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("terzistiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_terzistiope.Eof())) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_terzistiope.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                /* _note := w_tipinter + w_codinter+'6' */
                _note = w_tipinter+w_codinter+"6";
                /* _note := _note + DateToChar(qbe_oped_chkdiana->DATAOPE) + qbe_oped_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_oped_chkdiana->STATOREG) */
                _note = _note+CPLib.DateToChar(Cursor_qbe_oped_chkdiana.GetDate("DATAOPE"))+Cursor_qbe_oped_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_oped_chkdiana.GetString("STATOREG"));
                /* _note := _note + Left(LRTrim(terzistiope->CODSOG)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_terzistiope.GetString("CODSOG"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
                /* _note := _note + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
                /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
                /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                } // End If
                /* If not(Empty(personbo->NASSTATO)) */
                if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                  /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Space(35) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Space(35);
                } else { // Else
                  /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Space(35) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Space(35);
                } // End If
                /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                } // End If
                /* _note := _note + personbo->AUTRILASC + personbo->SESSO + Space(34) */
                _note = _note+Cursor_personbo.GetString("AUTRILASC")+Cursor_personbo.GetString("SESSO")+CPLib.Space(34);
                /* FileLibMit.WriteLine(fhand,_note) */
                FileLibMit.WriteLine(fhand,_note);
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
              Cursor_terzistiope.Next();
            }
            m_cConnectivityError = Cursor_terzistiope.ErrorMessage();
            Cursor_terzistiope.Close();
            // * --- End Select
            /* gNumRec := nTotRec // N° Record DIANA */
            gNumRec = CPLib.Round(nTotRec,0);
            m_Ctx.SetGlobalNumber("gNumRec",gNumRec);
            /* gNumReg := nTotReg // N° Registrazioni DIANA */
            gNumReg = CPLib.Round(nTotReg,0);
            m_Ctx.SetGlobalNumber("gNumReg",gNumReg);
            Cursor_qbe_oped_chkdiana.Next();
          }
          m_cConnectivityError = Cursor_qbe_oped_chkdiana.ErrorMessage();
          Cursor_qbe_oped_chkdiana.Close();
          // * --- End Select
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* _contacilci := _contacilci+1 */
          _contacilci = CPLib.Round(_contacilci+1,0);
        } // End While
      } else { // Else
        /* Cicla sulle informazioni sui rapporti */
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
        // * --- Select from qbe_opep_chkdiana_limits
        SPBridge.HMCaller _h00000196;
        _h00000196 = new SPBridge.HMCaller();
        _h00000196.Set("m_cVQRList",m_cVQRList);
        _h00000196.Set("cdadata",w_cdadata);
        _h00000196.Set("c_adata",w_c_adata);
        _h00000196.Set("codage",w_codage);
        if (Cursor_qbe_opep_chkdiana_limits!=null)
          Cursor_qbe_opep_chkdiana_limits.Close();
        Cursor_qbe_opep_chkdiana_limits = new VQRHolder("qbe_opep_chkdiana_limits",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000196,true).GetResultSet(m_Ctx);
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
          /* _nomefile := 'campione.txt.'+Right('0000'+LRTrim(Str(_conta,4,0)),4) */
          _nomefile = "campione.txt."+CPLib.Right("0000"+CPLib.LRTrim(CPLib.Str(_conta,4,0)),4);
          /* fhand := FileLibMit.OpenWrite('./flussi/'+LRTrim(gAzienda)+"/"+LRTrim(_nomefile)) */
          fhand = FileLibMit.OpenWrite("./flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_nomefile));
          /* Cicla sulle operazioni */
          // * --- Select from qbe_opep_chkdiana
          SPBridge.HMCaller _h000001A8;
          _h000001A8 = new SPBridge.HMCaller();
          _h000001A8.Set("m_cVQRList",m_cVQRList);
          _h000001A8.Set("cdadata",w_cdadata);
          _h000001A8.Set("c_adata",w_c_adata);
          _h000001A8.Set("codage",w_codage);
          _h000001A8.Set("_bottom",_bottom);
          _h000001A8.Set("_top",_top);
          if (Cursor_qbe_opep_chkdiana!=null)
            Cursor_qbe_opep_chkdiana.Close();
          Cursor_qbe_opep_chkdiana = new VQRHolder("qbe_opep_chkdiana",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000001A8,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_opep_chkdiana.Eof())) {
            /* _ctotale := _ctotale + 1 */
            _ctotale = CPLib.Round(_ctotale+1,0);
            /* gMsgImp := 'Elaborazione Operazione N.: '+LRTrim(Str(_ctotale,15,0)) // Messaggio Import */
            gMsgImp = "Elaborazione Operazione N.: "+CPLib.LRTrim(CPLib.Str(_ctotale,15,0));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* _note := w_tipinter + w_codinter + '1' */
            _note = w_tipinter+w_codinter+"1";
            /* If Empty(LRTrim(qbe_opep_chkdiana->FLAGRAP2)) */
            if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("FLAGRAP2")))) {
              /* _note := _note + DateToChar(qbe_opep_chkdiana->DATAOPE) + qbe_opep_chkdiana->NUMPROG + 'S' */
              _note = _note+CPLib.DateToChar(Cursor_qbe_opep_chkdiana.GetDate("DATAOPE"))+Cursor_qbe_opep_chkdiana.GetString("NUMPROG")+"S";
            } else { // Else
              /* _note := _note + qbe_opep_chkdiana->IDEREG */
              _note = _note+Cursor_qbe_opep_chkdiana.GetString("IDEREG");
            } // End If
            /* _flagrap := '' */
            _flagrap = "";
            /* If not(Empty(qbe_opep_chkdiana->FLAGRAP)) */
            if ( ! (CPLib.Empty(Cursor_qbe_opep_chkdiana.GetString("FLAGRAP")))) {
              /* _flagrap := qbe_opep_chkdiana->FLAGRAP */
              _flagrap = Cursor_qbe_opep_chkdiana.GetString("FLAGRAP");
            } else { // Else
              // * --- Select from knarapbo
              m_cServer = m_Ctx.GetServer("knarapbo");
              m_cPhName = m_Ctx.GetPhName("knarapbo");
              if (Cursor_knarapbo!=null)
                Cursor_knarapbo.Close();
              Cursor_knarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_opep_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("knarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_knarapbo.Eof())) {
                /* If knarapbo->TIPORAP='P' */
                if (CPLib.eqr(Cursor_knarapbo.GetString("TIPORAP"),"P")) {
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
                } else { // Else
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
                } // End If
                Cursor_knarapbo.Next();
              }
              m_cConnectivityError = Cursor_knarapbo.ErrorMessage();
              Cursor_knarapbo.Close();
              // * --- End Select
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
                  Error l_oErrorFault = new Error("Read on intermbo into routine arrt_chkdiana_mt returns two or more records. This item should return only a record.");
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
                    Error l_oErrorFault = new Error("Read on anadip into routine arrt_chkdiana_mt returns two or more records. This item should return only a record.");
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
                /* _note := _note + qbe_oped_chkdiana->CODDIPE + Left(LRTrim(anadip->CAB)+Space(6),6) + Left(LRTrim(anadip->DESCCIT)+Space(30),30) + Left(LRTrim(anadip->PROVINCIA)+Space(2),2) */
                _note = _note+Cursor_qbe_oped_chkdiana.GetString("CODDIPE")+CPLib.Left(CPLib.LRTrim(Cursor_anadip.GetString("CAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_anadip.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_anadip.GetString("PROVINCIA"))+CPLib.Space(2),2);
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
            /* _note := _note + Left(LRTrim(qbe_opep_chkdiana->TIPOINT2)+Space(2),2) + Left(LRTrim(qbe_opep_chkdiana->CODFISCICP)+Space(11),11) + Left(LRTrim(qbe_opep_chkdiana->PAESE)+Space(3),3) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("TIPOINT2"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("CODFISCICP"))+CPLib.Space(11),11)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("PAESE"))+CPLib.Space(3),3);
            /* _note := _note + Left(LRTrim(qbe_opep_chkdiana->CODCAB2)+Space(6),6) + Left(LRTrim(qbe_opep_chkdiana->DESC2)+Space(30),30) + Left(LRTrim(qbe_opep_chkdiana->PROV2)+Space(2),2) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("CODCAB2"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("DESC2"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("PROV2"))+CPLib.Space(2),2);
            /* _note := _note + Left(LRTrim(qbe_opep_chkdiana->DESCINTER)+Space(50),50) + Left(LRTrim(qbe_opep_chkdiana->RAPPORTO)+Space(25),25) + Left(LRTrim(_flagrap)+" ",1) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("DESCINTER"))+CPLib.Space(50),50)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("RAPPORTO"))+CPLib.Space(25),25)+CPLib.Left(CPLib.LRTrim(_flagrap)+" ",1);
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
            /* _note := _note + Left(LRTrim(qbe_opep_chkdiana->OPERAZMOD)+Space(20),20) + Left(LRTrim(qbe_opep_chkdiana->FLAGLIRE)+" ",1) + Left(LRTrim(qbe_opep_chkdiana->VALUTA)+Space(3),3) + Left(LRTrim(qbe_opep_chkdiana->SEGNO)+" ",1) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("OPERAZMOD"))+CPLib.Space(20),20)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("FLAGLIRE"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("VALUTA"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("SEGNO"))+" ",1);
            /* _note := _note +  Right('000000000000000'+LRTrim(Str(qbe_opep_chkdiana->TOTLIRE,15,0)),15) + Right('000000000000000'+LRTrim(Str(qbe_opep_chkdiana->TOTCONT,15,0)),15) + Space(69) */
            _note = _note+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_opep_chkdiana.GetDouble("TOTLIRE"),15,0)),15)+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_opep_chkdiana.GetDouble("TOTCONT"),15,0)),15)+CPLib.Space(69);
            /* FileLibMit.WriteLine(fhand,_note) */
            FileLibMit.WriteLine(fhand,_note);
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nTotReg := nTotReg + 1 */
            nTotReg = CPLib.Round(nTotReg+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
            /* If not(Empty(qbe_opep_chkdiana->CONNESCLI)) and Empty(LRTrim(qbe_opep_chkdiana->RAPPORTO)) */
            if ( ! (CPLib.Empty(Cursor_qbe_opep_chkdiana.GetString("CONNESCLI"))) && CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("RAPPORTO")))) {
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
                  /* _note := _note + Left(LRTrim(DateToChar(qbe_opep_chkdiana->DATAOPE))+Space(8),8) + qbe_opep_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_opep_chkdiana->STATOREG) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_opep_chkdiana.GetDate("DATAOPE")))+CPLib.Space(8),8)+Cursor_qbe_opep_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_opep_chkdiana.GetString("STATOREG"));
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
                    /* _note := _note + Left(LRTrim(kersonbo->NASSTATO)+Space(30),30) + Left(LRTrim(kersonbo->SOTGRUP)+Space(3),3) + Left(LRTrim(kersonbo->RAMOGRUP)+Space(3),3) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(kersonbo->NASCOMUN)+Space(30),30) + Left(LRTrim(kersonbo->SOTGRUP)+Space(3),3) + Left(LRTrim(kersonbo->RAMOGRUP)+Space(3),3) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                  } // End If
                  /* _note := _note + Left(LRTrim(kersonbo->SETTSINT)+Space(3),3) + Left(LRTrim(qbe_opep_chkdiana->RAPPORTO)+Space(25),25) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("RAPPORTO"))+CPLib.Space(25),25);
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
                  /* FileLibMit.WriteLine(fhand,_note) */
                  FileLibMit.WriteLine(fhand,_note);
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
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_opep_chkdiana.GetString("CONNESCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
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
                  /* _note := _note + Left(LRTrim(DateToChar(qbe_opep_chkdiana->DATAOPE))+Space(8),8) + qbe_opep_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_opep_chkdiana->STATOREG) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_opep_chkdiana.GetDate("DATAOPE")))+CPLib.Space(8),8)+Cursor_qbe_opep_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_opep_chkdiana.GetString("STATOREG"));
                  /* _note := _note + Left(LRTrim(qbe_opep_chkdiana->CONNESCLI)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("CONNESCLI"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
                  /* _note := _note + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                  /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
                  /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
                  /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
                  if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                    /* _note := _note + Space(8) */
                    _note = _note+CPLib.Space(8);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                  } // End If
                  /* If not(Empty(personbo->NASSTATO)) */
                  if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                    /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                  } // End If
                  /* _note := _note + Left(LRTrim(personbo->SETTSINT)+Space(3),3) + Left(LRTrim(qbe_opep_chkdiana->RAPPORTO)+Space(25),25) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("RAPPORTO"))+CPLib.Space(25),25);
                  /* _note := _note + Left(LRTrim(qbe_opep_chkdiana->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                  /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
                  if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                    /* _note := _note + Space(8) */
                    _note = _note+CPLib.Space(8);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                    _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                  } // End If
                  /* _note := _note + Left(LRTrim(personbo->AUTRILASC)+Space(30),30) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("AUTRILASC"))+CPLib.Space(30),30);
                  /* _note := _note + Left(LRTrim(personbo->SESSO)+" ",1) + Space(34) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SESSO"))+" ",1)+CPLib.Space(34);
                  /* FileLibMit.WriteLine(fhand,_note) */
                  FileLibMit.WriteLine(fhand,_note);
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } // End If
            } else { // Else
              // * --- Select from intestbo
              m_cServer = m_Ctx.GetServer("intestbo");
              m_cPhName = m_Ctx.GetPhName("intestbo");
              if (Cursor_intestbo!=null)
                Cursor_intestbo.Close();
              Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_opep_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_intestbo.Eof())) {
                /* If (qbe_opep_chkdiana->RAPPORTO+'P') = (intestbo->RAPPORTO+intestbo->TIPOPERS) */
                if (CPLib.eqr((Cursor_qbe_opep_chkdiana.GetString("RAPPORTO")+"P"),(Cursor_intestbo.GetString("RAPPORTO")+Cursor_intestbo.GetString("TIPOPERS")))) {
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
                    // * --- Select from personbo
                    m_cServer = m_Ctx.GetServer("personbo");
                    m_cPhName = m_Ctx.GetPhName("personbo");
                    if (Cursor_personbo!=null)
                      Cursor_personbo.Close();
                    Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_personbo.Eof())) {
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
                      /* _note := _note + Left(LRTrim(DateToChar(qbe_opep_chkdiana->DATAOPE))+Space(8),8) + qbe_opep_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_opep_chkdiana->STATOREG) */
                      _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_opep_chkdiana.GetDate("DATAOPE")))+CPLib.Space(8),8)+Cursor_qbe_opep_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_opep_chkdiana.GetString("STATOREG"));
                      /* _note := _note + Left(LRTrim(intestbo->CODINTER)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
                      _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_intestbo.GetString("CODINTER"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
                      /* _note := _note + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
                      _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                      /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
                      _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
                      /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
                      _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
                      /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
                      if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                        /* _note := _note + Space(8) */
                        _note = _note+CPLib.Space(8);
                      } else { // Else
                        /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                        _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                      } // End If
                      /* If not(Empty(personbo->NASSTATO)) */
                      if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                        /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                      } else { // Else
                        /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                      } // End If
                      /* _note := _note + Left(LRTrim(personbo->SETTSINT)+Space(3),3) + Left(LRTrim(qbe_opep_chkdiana->RAPPORTO)+Space(25),25) */
                      _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("RAPPORTO"))+CPLib.Space(25),25);
                      /* _note := _note + Left(LRTrim(qbe_opep_chkdiana->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
                      _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                      /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
                      if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                        /* _note := _note + Space(8) */
                        _note = _note+CPLib.Space(8);
                      } else { // Else
                        /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                        _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                      } // End If
                      /* _note := _note + Left(LRTrim(personbo->AUTRILASC)+Space(30),30) */
                      _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("AUTRILASC"))+CPLib.Space(30),30);
                      /* _note := _note + Left(LRTrim(personbo->SESSO)+" ",1) + Space(34) */
                      _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SESSO"))+" ",1)+CPLib.Space(34);
                      /* FileLibMit.WriteLine(fhand,_note) */
                      FileLibMit.WriteLine(fhand,_note);
                      /* nTotRec := nTotRec + 1 */
                      nTotRec = CPLib.Round(nTotRec+1,0);
                      /* nNumRec := nNumRec + 1 */
                      nNumRec = CPLib.Round(nNumRec+1,0);
                      Cursor_personbo.Next();
                    }
                    m_cConnectivityError = Cursor_personbo.ErrorMessage();
                    Cursor_personbo.Close();
                    // * --- End Select
                  } // End If
                } // End If
                Cursor_intestbo.Next();
              }
              m_cConnectivityError = Cursor_intestbo.ErrorMessage();
              Cursor_intestbo.Close();
              // * --- End Select
            } // End If
            // * --- Select from xlientiope
            m_cServer = m_Ctx.GetServer("xlientiope");
            m_cPhName = m_Ctx.GetPhName("xlientiope");
            if (Cursor_xlientiope!=null)
              Cursor_xlientiope.Close();
            Cursor_xlientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_opep_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xlientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xlientiope.Eof())) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xlientiope.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
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
                /* _note := _note + Left(LRTrim(DateToChar(qbe_opep_chkdiana->DATAOPE))+Space(8),8) + qbe_opep_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_opep_chkdiana->STATOREG) */
                _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_opep_chkdiana.GetDate("DATAOPE")))+CPLib.Space(8),8)+Cursor_qbe_opep_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_opep_chkdiana.GetString("STATOREG"));
                /* _note := _note + Left(LRTrim(xlientiope->CODSOG)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xlientiope.GetString("CODSOG"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
                /* _note := _note + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
                /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
                /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                } // End If
                /* If not(Empty(personbo->NASSTATO)) */
                if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                  /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                } else { // Else
                  /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                } // End If
                /* _note := _note + Left(LRTrim(personbo->SETTSINT)+Space(3),3) + Left(LRTrim(qbe_opep_chkdiana->RAPPORTO)+Space(25),25) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("RAPPORTO"))+CPLib.Space(25),25);
                /* _note := _note + Left(LRTrim(qbe_opep_chkdiana->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                } // End If
                /* _note := _note + Left(LRTrim(personbo->AUTRILASC)+Space(30),30) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("AUTRILASC"))+CPLib.Space(30),30);
                /* _note := _note + Left(LRTrim(personbo->SESSO)+" ",1) + Space(34) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SESSO"))+" ",1)+CPLib.Space(34);
                /* FileLibMit.WriteLine(fhand,_note) */
                FileLibMit.WriteLine(fhand,_note);
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
              Cursor_xlientiope.Next();
            }
            m_cConnectivityError = Cursor_xlientiope.ErrorMessage();
            Cursor_xlientiope.Close();
            // * --- End Select
            /* If not(Empty(qbe_opep_chkdiana->CONNESOPER)) and qbe_opep_chkdiana->CONNESOPER <> _codrif */
            if ( ! (CPLib.Empty(Cursor_qbe_opep_chkdiana.GetString("CONNESOPER"))) && CPLib.ne(Cursor_qbe_opep_chkdiana.GetString("CONNESOPER"),_codrif)) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_opep_chkdiana.GetString("CONNESOPER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                /* _note := w_tipinter + w_codinter+'4' */
                _note = w_tipinter+w_codinter+"4";
                /* _note := _note + DateToChar(qbe_opep_chkdiana->DATAOPE) + qbe_opep_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_opep_chkdiana->STATOREG) */
                _note = _note+CPLib.DateToChar(Cursor_qbe_opep_chkdiana.GetDate("DATAOPE"))+Cursor_qbe_opep_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_opep_chkdiana.GetString("STATOREG"));
                /* _note := _note + Left(LRTrim(qbe_opep_chkdiana->CONNESOPER)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("CONNESOPER"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
                /* _note := _note + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
                /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
                /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                } // End If
                /* If not(Empty(personbo->NASSTATO)) */
                if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                  /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Space(35) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Space(35);
                } else { // Else
                  /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Space(35) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Space(35);
                } // End If
                /* _note := _note + Left(LRTrim(qbe_opep_chkdiana->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                } // End If
                /* _note := _note + personbo->AUTRILASC + personbo->SESSO + Space(34) */
                _note = _note+Cursor_personbo.GetString("AUTRILASC")+Cursor_personbo.GetString("SESSO")+CPLib.Space(34);
                /* FileLibMit.WriteLine(fhand,_note) */
                FileLibMit.WriteLine(fhand,_note);
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
            } // End If
            // * --- Select from xogopebo
            m_cServer = m_Ctx.GetServer("xogopebo");
            m_cPhName = m_Ctx.GetPhName("xogopebo");
            if (Cursor_xogopebo!=null)
              Cursor_xogopebo.Close();
            Cursor_xogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_opep_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xogopebo.Eof())) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xogopebo.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                /* _note := w_tipinter + w_codinter+'4' */
                _note = w_tipinter+w_codinter+"4";
                /* _note := _note + DateToChar(qbe_opep_chkdiana->DATAOPE) + qbe_opep_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_opep_chkdiana->STATOREG) */
                _note = _note+CPLib.DateToChar(Cursor_qbe_opep_chkdiana.GetDate("DATAOPE"))+Cursor_qbe_opep_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_opep_chkdiana.GetString("STATOREG"));
                /* _note := _note + Left(LRTrim(xogopebo->CODSOG)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xogopebo.GetString("CODSOG"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
                /* _note := _note + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
                /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
                /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                } // End If
                /* If not(Empty(personbo->NASSTATO)) */
                if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                  /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Space(35) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Space(35);
                } else { // Else
                  /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Space(35) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Space(35);
                } // End If
                /* _note := _note + Left(LRTrim(qbe_opep_chkdiana->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                } // End If
                /* _note := _note + personbo->AUTRILASC + personbo->SESSO + Space(34) */
                _note = _note+Cursor_personbo.GetString("AUTRILASC")+Cursor_personbo.GetString("SESSO")+CPLib.Space(34);
                /* FileLibMit.WriteLine(fhand,_note) */
                FileLibMit.WriteLine(fhand,_note);
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
              Cursor_xogopebo.Next();
            }
            m_cConnectivityError = Cursor_xogopebo.ErrorMessage();
            Cursor_xogopebo.Close();
            // * --- End Select
            /* If not(Empty(qbe_opep_chkdiana->CONNESBEN)) or not(Empty(qbe_opep_chkdiana->C_RAG)) */
            if ( ! (CPLib.Empty(Cursor_qbe_opep_chkdiana.GetString("CONNESBEN"))) ||  ! (CPLib.Empty(Cursor_qbe_opep_chkdiana.GetString("C_RAG")))) {
              /* If not(Empty(qbe_opep_chkdiana->CONNESBEN)) */
              if ( ! (CPLib.Empty(Cursor_qbe_opep_chkdiana.GetString("CONNESBEN")))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_opep_chkdiana.GetString("CONNESBEN"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* _note := w_tipinter + w_codinter+'5' */
                  _note = w_tipinter+w_codinter+"5";
                  /* _note := _note + DateToChar(qbe_opep_chkdiana->DATAOPE) + qbe_opep_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_opep_chkdiana->STATOREG) */
                  _note = _note+CPLib.DateToChar(Cursor_qbe_opep_chkdiana.GetDate("DATAOPE"))+Cursor_qbe_opep_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_opep_chkdiana.GetString("STATOREG"));
                  /* _note := _note + Left(LRTrim(qbe_opep_chkdiana->CONNESBEN)+Space(16),16) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("CONNESBEN"))+CPLib.Space(16),16);
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_opep_chkdiana->C_RAG))),Left(LRTrim(qbe_opep_chkdiana->C_RAG)+Space(70),70),Left(LRTrim(personbo->RAGSOC)+Space(70),70)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_RAG"))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_opep_chkdiana->C_STA))),Left(LRTrim(qbe_opep_chkdiana->C_STA)+Space(3),3),Left(LRTrim(personbo->PAESE)+Space(3),3)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_opep_chkdiana->C_CAB))),Left(LRTrim(qbe_opep_chkdiana->C_CAB)+Space(6),6),Left(LRTrim(personbo->CODCAB)+Space(6),6)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_opep_chkdiana->C_CTA))),Left(LRTrim(qbe_opep_chkdiana->C_CTA)+Space(30),30),Left(LRTrim(personbo->DESCCIT)+Space(30),30)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_CTA"))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_opep_chkdiana->C_PRV))),Left(LRTrim(qbe_opep_chkdiana->C_PRV)+Space(2),2),Left(LRTrim(personbo->PROVINCIA)+Space(2),2)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_opep_chkdiana->C_IND))),Left(LRTrim(qbe_opep_chkdiana->C_IND)+Space(35),35),Left(LRTrim(personbo->DOMICILIO)+Space(35),35)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_IND"))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_opep_chkdiana->C_CAP))),Left(LRTrim(qbe_opep_chkdiana->C_CAP)+Space(5),5),Left(LRTrim(personbo->CAP)+Space(5),5)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5));
                  /* _note := _note + Space(63) */
                  _note = _note+CPLib.Space(63);
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_opep_chkdiana->C_RAPPORTO))),Left(LRTrim(qbe_opep_chkdiana->C_RAPPORTO)+Space(25),25),Left(LRTrim(qbe_opep_chkdiana->RAPPORTBEN)+Space(25),25)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_RAPPORTO"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_RAPPORTO"))+CPLib.Space(25),25):CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("RAPPORTBEN"))+CPLib.Space(25),25));
                  /* _note := _note + Space(91) */
                  _note = _note+CPLib.Space(91);
                  /* FileLibMit.WriteLine(fhand,_note) */
                  FileLibMit.WriteLine(fhand,_note);
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
                /* ElseIf not(Empty(qbe_opep_chkdiana->C_RAG)) */
              } else if ( ! (CPLib.Empty(Cursor_qbe_opep_chkdiana.GetString("C_RAG")))) {
                /* _note := w_tipinter + w_codinter+'5' */
                _note = w_tipinter+w_codinter+"5";
                /* _note := _note + DateToChar(qbe_opep_chkdiana->DATAOPE) + qbe_opep_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_opep_chkdiana->STATOREG) */
                _note = _note+CPLib.DateToChar(Cursor_qbe_opep_chkdiana.GetDate("DATAOPE"))+Cursor_qbe_opep_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_opep_chkdiana.GetString("STATOREG"));
                /* _note := _note + Left(LRTrim(qbe_opep_chkdiana->CONNESBEN)+Space(16),16) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("CONNESBEN"))+CPLib.Space(16),16);
                /* _note := _note +Left(LRTrim(qbe_opep_chkdiana->C_RAG)+Space(70),70) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_RAG"))+CPLib.Space(70),70);
                /* _note := _note + Left(LRTrim(qbe_opep_chkdiana->C_STA)+Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_STA"))+CPLib.Space(3),3);
                /* _note := _note +Left(LRTrim(qbe_opep_chkdiana->C_CAB)+Space(6),6) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_CAB"))+CPLib.Space(6),6);
                /* _note := _note +Left(LRTrim(qbe_opep_chkdiana->C_CTA)+Space(30),30) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_CTA"))+CPLib.Space(30),30);
                /* _note := _note + Left(LRTrim(qbe_opep_chkdiana->C_PRV)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_PRV"))+CPLib.Space(2),2);
                /* _note := _note + Left(LRTrim(qbe_opep_chkdiana->C_IND)+Space(35),35) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_IND"))+CPLib.Space(35),35);
                /* _note := _note + Left(LRTrim(qbe_opep_chkdiana->C_CAP)+Space(5),5) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_CAP"))+CPLib.Space(5),5);
                /* _note := _note + Space(63) */
                _note = _note+CPLib.Space(63);
                /* _note := _note + Left(LRTrim(qbe_opep_chkdiana->C_RAPPORTO)+Space(25),25) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                /* _note := _note + Space(91) */
                _note = _note+CPLib.Space(91);
                /* FileLibMit.WriteLine(fhand,_note) */
                FileLibMit.WriteLine(fhand,_note);
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
              } // End If
            } // End If
            // * --- Select from xeneficope
            m_cServer = m_Ctx.GetServer("xeneficope");
            m_cPhName = m_Ctx.GetPhName("xeneficope");
            if (Cursor_xeneficope!=null)
              Cursor_xeneficope.Close();
            Cursor_xeneficope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_opep_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xeneficope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xeneficope.Eof())) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xeneficope.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                /* _note := w_tipinter + w_codinter+'5' */
                _note = w_tipinter+w_codinter+"5";
                /* _note := _note + DateToChar(qbe_opep_chkdiana->DATAOPE) + qbe_opep_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_opep_chkdiana->STATOREG) */
                _note = _note+CPLib.DateToChar(Cursor_qbe_opep_chkdiana.GetDate("DATAOPE"))+Cursor_qbe_opep_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_opep_chkdiana.GetString("STATOREG"));
                /* _note := _note + Left(LRTrim(xeneficope->CODSOG)+Space(16),16) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("CODSOG"))+CPLib.Space(16),16);
                /* _note := _note + iif(not(Empty(LRTrim(xeneficope->C_RAG))),Left(LRTrim(xeneficope->C_RAG)+Space(70),70),Left(LRTrim(personbo->RAGSOC)+Space(70),70)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficope.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("C_RAG"))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70));
                /* _note := _note + iif(not(Empty(LRTrim(xeneficope->C_STA))),Left(LRTrim(xeneficope->C_STA)+Space(3),3),Left(LRTrim(personbo->PAESE)+Space(3),3)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficope.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3));
                /* _note := _note + iif(not(Empty(LRTrim(xeneficope->C_CAB))),Left(LRTrim(xeneficope->C_CAB)+Space(6),6),Left(LRTrim(personbo->CODCAB)+Space(6),6)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficope.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6));
                /* _note := _note + iif(not(Empty(LRTrim(xeneficope->C_CTA))),Left(LRTrim(xeneficope->C_CTA)+Space(30),30),Left(LRTrim(personbo->DESCCIT)+Space(30),30)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficope.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("C_CTA"))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30));
                /* _note := _note + iif(not(Empty(LRTrim(xeneficope->C_PRV))),Left(LRTrim(xeneficope->C_PRV)+Space(2),2),Left(LRTrim(personbo->PROVINCIA)+Space(2),2)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficope.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                /* _note := _note + iif(not(Empty(LRTrim(xeneficope->C_IND))),Left(LRTrim(xeneficope->C_IND)+Space(35),35),Left(LRTrim(personbo->DOMICILIO)+Space(35),35)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficope.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("C_IND"))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35));
                /* _note := _note + iif(not(Empty(LRTrim(xeneficope->C_CAP))),Left(LRTrim(xeneficope->C_CAP)+Space(5),5),Left(LRTrim(personbo->CAP)+Space(5),5)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficope.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5));
                /* _note := _note + Space(63) */
                _note = _note+CPLib.Space(63);
                /* _note := _note +Left(LRTrim(xeneficope->C_RAPPORTO)+Space(25),25) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficope.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                /* _note := _note + Space(91) */
                _note = _note+CPLib.Space(91);
                /* FileLibMit.WriteLine(fhand,_note) */
                FileLibMit.WriteLine(fhand,_note);
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
              Cursor_xeneficope.Next();
            }
            m_cConnectivityError = Cursor_xeneficope.ErrorMessage();
            Cursor_xeneficope.Close();
            // * --- End Select
            /* If not(Empty(qbe_opep_chkdiana->CONNALTRO)) */
            if ( ! (CPLib.Empty(Cursor_qbe_opep_chkdiana.GetString("CONNALTRO")))) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_opep_chkdiana.GetString("CONNALTRO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                /* _note := w_tipinter + w_codinter+'6' */
                _note = w_tipinter+w_codinter+"6";
                /* _note := _note + DateToChar(qbe_opep_chkdiana->DATAOPE) + qbe_opep_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_opep_chkdiana->STATOREG) */
                _note = _note+CPLib.DateToChar(Cursor_qbe_opep_chkdiana.GetDate("DATAOPE"))+Cursor_qbe_opep_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_opep_chkdiana.GetString("STATOREG"));
                /* _note := _note + Left(LRTrim(qbe_opep_chkdiana->CONNALTRO)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("CONNALTRO"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
                /* _note := _note + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
                /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
                /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                } // End If
                /* If not(Empty(personbo->NASSTATO)) */
                if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                  /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Space(35) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Space(35);
                } else { // Else
                  /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Space(35) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Space(35);
                } // End If
                /* _note := _note + Left(LRTrim(qbe_opep_chkdiana->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                } // End If
                /* _note := _note + personbo->AUTRILASC + personbo->SESSO + Space(34) */
                _note = _note+Cursor_personbo.GetString("AUTRILASC")+Cursor_personbo.GetString("SESSO")+CPLib.Space(34);
                /* FileLibMit.WriteLine(fhand,_note) */
                FileLibMit.WriteLine(fhand,_note);
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
            } // End If
            // * --- Select from xerzistiope
            m_cServer = m_Ctx.GetServer("xerzistiope");
            m_cPhName = m_Ctx.GetPhName("xerzistiope");
            if (Cursor_xerzistiope!=null)
              Cursor_xerzistiope.Close();
            Cursor_xerzistiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_opep_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xerzistiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xerzistiope.Eof())) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xerzistiope.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                /* _note := w_tipinter + w_codinter+'6' */
                _note = w_tipinter+w_codinter+"6";
                /* _note := _note + DateToChar(qbe_opep_chkdiana->DATAOPE) + qbe_opep_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_opep_chkdiana->STATOREG) */
                _note = _note+CPLib.DateToChar(Cursor_qbe_opep_chkdiana.GetDate("DATAOPE"))+Cursor_qbe_opep_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_opep_chkdiana.GetString("STATOREG"));
                /* _note := _note + Left(LRTrim(xerzistiope->CODSOG)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xerzistiope.GetString("CODSOG"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
                /* _note := _note + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
                /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
                /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                } // End If
                /* If not(Empty(personbo->NASSTATO)) */
                if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                  /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Space(35) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Space(35);
                } else { // Else
                  /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Space(35) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Space(35);
                } // End If
                /* _note := _note + Left(LRTrim(qbe_opep_chkdiana->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_opep_chkdiana.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                } // End If
                /* _note := _note + personbo->AUTRILASC + personbo->SESSO + Space(34) */
                _note = _note+Cursor_personbo.GetString("AUTRILASC")+Cursor_personbo.GetString("SESSO")+CPLib.Space(34);
                /* FileLibMit.WriteLine(fhand,_note) */
                FileLibMit.WriteLine(fhand,_note);
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
              Cursor_xerzistiope.Next();
            }
            m_cConnectivityError = Cursor_xerzistiope.ErrorMessage();
            Cursor_xerzistiope.Close();
            // * --- End Select
            /* gNumRec := nTotRec // N° Record DIANA */
            gNumRec = CPLib.Round(nTotRec,0);
            m_Ctx.SetGlobalNumber("gNumRec",gNumRec);
            /* gNumReg := nTotReg // N° Registrazioni DIANA */
            gNumReg = CPLib.Round(nTotReg,0);
            m_Ctx.SetGlobalNumber("gNumReg",gNumReg);
            Cursor_qbe_opep_chkdiana.Next();
          }
          m_cConnectivityError = Cursor_qbe_opep_chkdiana.ErrorMessage();
          Cursor_qbe_opep_chkdiana.Close();
          // * --- End Select
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* _contacilci := _contacilci+1 */
          _contacilci = CPLib.Round(_contacilci+1,0);
        } // End While
      } // End If
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
        if (Cursor_knarapbo!=null)
          Cursor_knarapbo.Close();
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
        if (Cursor_clientiope!=null)
          Cursor_clientiope.Close();
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
        if (Cursor_beneficope!=null)
          Cursor_beneficope.Close();
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
  void Page_3() throws Exception {
    CPResultSet Cursor_qbe_rapd_chkdiana=null;
    CPResultSet Cursor_anarapbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_anadip=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_qbe_rapp_chkdiana=null;
    CPResultSet Cursor_knarapbo=null;
    CPResultSet Cursor_xnarapbo=null;
    CPResultSet Cursor_xntestbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Cicla sulle informazioni sui rapporti */
      /* _conta := _conta + 1 */
      _conta = CPLib.Round(_conta+1,0);
      /* _nomefile := 'campione.txt.'+Right('0000'+LRTrim(Str(_conta,4,0)),4) */
      _nomefile = "campione.txt."+CPLib.Right("0000"+CPLib.LRTrim(CPLib.Str(_conta,4,0)),4);
      /* fhand := FileLibMit.OpenWrite('./flussi/'+LRTrim(gAzienda)+"/"+LRTrim(_nomefile)) */
      fhand = FileLibMit.OpenWrite("./flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_nomefile));
      /* If w_tipoarch = 'D' */
      if (CPLib.eqr(w_tipoarch,"D")) {
        // * --- Select from qbe_rapd_chkdiana
        if (Cursor_qbe_rapd_chkdiana!=null)
          Cursor_qbe_rapd_chkdiana.Close();
        Cursor_qbe_rapd_chkdiana = new VQRHolder("qbe_rapd_chkdiana",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_rapd_chkdiana.Eof())) {
          /* _note := w_tipinter + w_codinter + '1' */
          _note = w_tipinter+w_codinter+"1";
          /* _note := _note + DateToChar(qbe_rapd_chkdiana->DATAOPE) + qbe_rapd_chkdiana->NUMPROG + LibreriaMit.StatoReg('qbe_rapd_chkdiana',qbe_rapd_chkdiana->STATOREG) */
          _note = _note+CPLib.DateToChar(Cursor_qbe_rapd_chkdiana.GetDate("DATAOPE"))+Cursor_qbe_rapd_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("qbe_rapd_chkdiana",Cursor_qbe_rapd_chkdiana.GetString("STATOREG"));
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
                Error l_oErrorFault = new Error("Read on intermbo into routine arrt_chkdiana_mt returns two or more records. This item should return only a record.");
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
                  Error l_oErrorFault = new Error("Read on anadip into routine arrt_chkdiana_mt returns two or more records. This item should return only a record.");
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
          /* _note := _note + Left(LRTrim(qbe_rapd_chkdiana->OPERAZMOD)+Space(20),20) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("OPERAZMOD"))+CPLib.Space(20),20);
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
          /* FileLibMit.WriteLine(fhand,_note) */
          FileLibMit.WriteLine(fhand,_note);
          /* nTotRec := nTotRec + 1 */
          nTotRec = CPLib.Round(nTotRec+1,0);
          /* nTotReg := nTotReg + 1 */
          nTotReg = CPLib.Round(nTotReg+1,0);
          /* nNumRec := nNumRec + 1 */
          nNumRec = CPLib.Round(nNumRec+1,0);
          /* Case qbe_rapd_chkdiana->TIPOOPRAP='25' or qbe_rapd_chkdiana->TIPOOPRAP='28' */
          if (CPLib.eqr(Cursor_qbe_rapd_chkdiana.GetString("TIPOOPRAP"),"25") || CPLib.eqr(Cursor_qbe_rapd_chkdiana.GetString("TIPOOPRAP"),"28")) {
            // * --- Select from intestbo
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            if (Cursor_intestbo!=null)
              Cursor_intestbo.Close();
            Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestbo.Eof())) {
              /* _avanza := 0 */
              _avanza = CPLib.Round(0,0);
              /* If intestbo->TIPOPERS='D' */
              if (CPLib.eqr(Cursor_intestbo.GetString("TIPOPERS"),"D")) {
                /* _avanza := 1 */
                _avanza = CPLib.Round(1,0);
              } // End If
              /* If Empty(intestbo->CODINTER) */
              if (CPLib.Empty(Cursor_intestbo.GetString("CODINTER"))) {
                /* _avanza := 1 */
                _avanza = CPLib.Round(1,0);
              } // End If
              /* If _avanza=0 */
              if (CPLib.eqr(_avanza,0)) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* _note := w_tipinter + w_codinter+'2' */
                  _note = w_tipinter+w_codinter+"2";
                  /* _note := _note + Left(LRTrim(DateToChar(qbe_rapd_chkdiana->DATAOPE))+Space(8),8) + qbe_rapd_chkdiana->NUMPROG + LibreriaMit.StatoReg('qbe_rapd_chkdiana',qbe_rapd_chkdiana->STATOREG) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_rapd_chkdiana.GetDate("DATAOPE")))+CPLib.Space(8),8)+Cursor_qbe_rapd_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("qbe_rapd_chkdiana",Cursor_qbe_rapd_chkdiana.GetString("STATOREG"));
                  /* _note := _note + Left(LRTrim(personbo->CONNES)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CONNES"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
                  /* _note := _note + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                  /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
                  /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
                  /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
                  if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                    /* _note := _note + Space(8) */
                    _note = _note+CPLib.Space(8);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                  } // End If
                  /* If not(Empty(personbo->NASSTATO)) */
                  if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                    /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                  } // End If
                  /* _note := _note + Left(LRTrim(personbo->SETTSINT)+Space(3),3) + Left(LRTrim(qbe_rapd_chkdiana->RAPPORTO)+Space(25),25) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"))+CPLib.Space(25),25);
                  /* _note := _note + Left(LRTrim(qbe_rapd_chkdiana->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                  /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
                  if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                    /* _note := _note + Space(8) */
                    _note = _note+CPLib.Space(8);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                    _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                  } // End If
                  /* _note := _note + Left(LRTrim(personbo->AUTRILASC)+Space(30),30) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("AUTRILASC"))+CPLib.Space(30),30);
                  /* _note := _note + Left(LRTrim(personbo->SESSO)+" ",1) + Space(34) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SESSO"))+" ",1)+CPLib.Space(34);
                  /* FileLibMit.WriteLine(fhand,_note) */
                  FileLibMit.WriteLine(fhand,_note);
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } // End If
              Cursor_intestbo.Next();
            }
            m_cConnectivityError = Cursor_intestbo.ErrorMessage();
            Cursor_intestbo.Close();
            // * --- End Select
            /* Case Right(qbe_rapd_chkdiana->TIPOOPRAP,1)='6' */
          } else if (CPLib.eqr(CPLib.Right(Cursor_qbe_rapd_chkdiana.GetString("TIPOOPRAP"),1),"6")) {
            // * --- Select from intestbo
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            if (Cursor_intestbo!=null)
              Cursor_intestbo.Close();
            Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG2="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestbo.Eof())) {
              /* _avanza := 0 */
              _avanza = CPLib.Round(0,0);
              /* If intestbo->TIPOPERS='D' */
              if (CPLib.eqr(Cursor_intestbo.GetString("TIPOPERS"),"D")) {
                /* _avanza := 1 */
                _avanza = CPLib.Round(1,0);
              } // End If
              /* If Empty(intestbo->CODINTER) */
              if (CPLib.Empty(Cursor_intestbo.GetString("CODINTER"))) {
                /* _avanza := 1 */
                _avanza = CPLib.Round(1,0);
              } // End If
              /* If _avanza=0 */
              if (CPLib.eqr(_avanza,0)) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* _note := w_tipinter + w_codinter+'2' */
                  _note = w_tipinter+w_codinter+"2";
                  /* _note := _note + Left(LRTrim(DateToChar(qbe_rapd_chkdiana->DATAOPE))+Space(8),8) + qbe_rapd_chkdiana->NUMPROG + LibreriaMit.StatoReg('qbe_rapd_chkdiana',qbe_rapd_chkdiana->STATOREG) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_rapd_chkdiana.GetDate("DATAOPE")))+CPLib.Space(8),8)+Cursor_qbe_rapd_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("qbe_rapd_chkdiana",Cursor_qbe_rapd_chkdiana.GetString("STATOREG"));
                  /* _note := _note + Left(LRTrim(personbo->CONNES)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CONNES"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
                  /* _note := _note + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                  /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
                  /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
                  /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
                  if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                    /* _note := _note + Space(8) */
                    _note = _note+CPLib.Space(8);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                  } // End If
                  /* If not(Empty(personbo->NASSTATO)) */
                  if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                    /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                  } // End If
                  /* _note := _note + Left(LRTrim(personbo->SETTSINT)+Space(3),3) + Left(LRTrim(qbe_rapd_chkdiana->RAPPORTO)+Space(25),25) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"))+CPLib.Space(25),25);
                  /* _note := _note + Left(LRTrim(qbe_rapd_chkdiana->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                  /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
                  if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                    /* _note := _note + Space(8) */
                    _note = _note+CPLib.Space(8);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                    _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                  } // End If
                  /* _note := _note + Left(LRTrim(personbo->AUTRILASC)+Space(30),30) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("AUTRILASC"))+CPLib.Space(30),30);
                  /* _note := _note + Left(LRTrim(personbo->SESSO)+" ",1) + Space(34) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SESSO"))+" ",1)+CPLib.Space(34);
                  /* FileLibMit.WriteLine(fhand,_note) */
                  FileLibMit.WriteLine(fhand,_note);
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } // End If
              Cursor_intestbo.Next();
            }
            m_cConnectivityError = Cursor_intestbo.ErrorMessage();
            Cursor_intestbo.Close();
            // * --- End Select
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
              /* If intestbo->TIPOPERS='D' */
              if (CPLib.eqr(Cursor_intestbo.GetString("TIPOPERS"),"D")) {
                /* _avanza := 1 */
                _avanza = CPLib.Round(1,0);
              } // End If
              /* If Empty(intestbo->CODINTER) */
              if (CPLib.Empty(Cursor_intestbo.GetString("CODINTER"))) {
                /* _avanza := 1 */
                _avanza = CPLib.Round(1,0);
              } // End If
              /* If _avanza=0 */
              if (CPLib.eqr(_avanza,0)) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* _note := w_tipinter + w_codinter+'2' */
                  _note = w_tipinter+w_codinter+"2";
                  /* _note := _note + Left(LRTrim(DateToChar(qbe_rapd_chkdiana->DATAOPE))+Space(8),8) + qbe_rapd_chkdiana->NUMPROG + LibreriaMit.StatoReg('qbe_rapd_chkdiana',qbe_rapd_chkdiana->STATOREG) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_rapd_chkdiana.GetDate("DATAOPE")))+CPLib.Space(8),8)+Cursor_qbe_rapd_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("qbe_rapd_chkdiana",Cursor_qbe_rapd_chkdiana.GetString("STATOREG"));
                  /* _note := _note + Left(LRTrim(personbo->CONNES)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CONNES"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
                  /* _note := _note + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                  /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
                  /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
                  /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
                  if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                    /* _note := _note + Space(8) */
                    _note = _note+CPLib.Space(8);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                  } // End If
                  /* If not(Empty(personbo->NASSTATO)) */
                  if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                    /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                  } // End If
                  /* _note := _note + Left(LRTrim(personbo->SETTSINT)+Space(3),3) + Left(LRTrim(qbe_rapd_chkdiana->RAPPORTO)+Space(25),25) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"))+CPLib.Space(25),25);
                  /* _note := _note + Left(LRTrim(qbe_rapd_chkdiana->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                  /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
                  if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                    /* _note := _note + Space(8) */
                    _note = _note+CPLib.Space(8);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                    _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                  } // End If
                  /* _note := _note + Left(LRTrim(personbo->AUTRILASC)+Space(30),30) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("AUTRILASC"))+CPLib.Space(30),30);
                  /* _note := _note + Left(LRTrim(personbo->SESSO)+" ",1) + Space(34) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SESSO"))+" ",1)+CPLib.Space(34);
                  /* FileLibMit.WriteLine(fhand,_note) */
                  FileLibMit.WriteLine(fhand,_note);
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } // End If
              Cursor_intestbo.Next();
            }
            m_cConnectivityError = Cursor_intestbo.ErrorMessage();
            Cursor_intestbo.Close();
            // * --- End Select
          } // End Case
          /* If not(Empty(qbe_rapd_chkdiana->CONNESOPER)) */
          if ( ! (CPLib.Empty(Cursor_qbe_rapd_chkdiana.GetString("CONNESOPER")))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana.GetString("CONNESOPER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              /* _note := w_tipinter + w_codinter+'4' */
              _note = w_tipinter+w_codinter+"4";
              /* _note := _note + Left(LRTrim(DateToChar(qbe_rapd_chkdiana->DATAOPE))+Space(8),8) + Left(LRTrim(qbe_rapd_chkdiana->NUMPROG)+Space(11),11) + LibreriaMit.StatoReg('qbe_rapd_chkdiana',qbe_rapd_chkdiana->STATOREG) */
              _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_rapd_chkdiana.GetDate("DATAOPE")))+CPLib.Space(8),8)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("NUMPROG"))+CPLib.Space(11),11)+LibreriaMit.StatoReg("qbe_rapd_chkdiana",Cursor_qbe_rapd_chkdiana.GetString("STATOREG"));
              /* _note := _note + Left(LRTrim(personbo->CONNES)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CONNES"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
              /* _note := _note + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
              /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
              /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
              /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
              if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                /* _note := _note + Space(8) */
                _note = _note+CPLib.Space(8);
              } else { // Else
                /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
              } // End If
              /* If not(Empty(personbo->NASSTATO)) */
              if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Space(35) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Space(35);
              } else { // Else
                /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Space(35) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Space(35);
              } // End If
              /* _note := _note + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
              /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
              if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                /* _note := _note + Space(8) */
                _note = _note+CPLib.Space(8);
              } else { // Else
                /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
              } // End If
              /* _note := _note + Left(LRTrim(personbo->AUTRILASC)+Space(30),30) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("AUTRILASC"))+CPLib.Space(30),30);
              /* _note := _note + Left(LRTrim(personbo->SESSO)+" ",1) + Space(34) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SESSO"))+" ",1)+CPLib.Space(34);
              /* FileLibMit.WriteLine(fhand,_note) */
              FileLibMit.WriteLine(fhand,_note);
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
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
          /* _note := w_tipinter + w_codinter + '1' */
          _note = w_tipinter+w_codinter+"1";
          /* _note := _note + DateToChar(qbe_rapp_chkdiana->DATAOPE) + qbe_rapp_chkdiana->NUMPROG + LibreriaMit.StatoReg('qbe_rapp_chkdiana',qbe_rapp_chkdiana->STATOREG) */
          _note = _note+CPLib.DateToChar(Cursor_qbe_rapp_chkdiana.GetDate("DATAOPE"))+Cursor_qbe_rapp_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("qbe_rapp_chkdiana",Cursor_qbe_rapp_chkdiana.GetString("STATOREG"));
          /* _flagrap := '' */
          _flagrap = "";
          /* If not(Empty(qbe_rapp_chkdiana->FLAGRAP)) */
          if ( ! (CPLib.Empty(Cursor_qbe_rapp_chkdiana.GetString("FLAGRAP")))) {
            /* _flagrap := qbe_rapp_chkdiana->FLAGRAP */
            _flagrap = Cursor_qbe_rapp_chkdiana.GetString("FLAGRAP");
          } else { // Else
            // * --- Select from knarapbo
            m_cServer = m_Ctx.GetServer("knarapbo");
            m_cPhName = m_Ctx.GetPhName("knarapbo");
            if (Cursor_knarapbo!=null)
              Cursor_knarapbo.Close();
            Cursor_knarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapp_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("knarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_knarapbo.Eof())) {
              /* If knarapbo->TIPORAP='P' */
              if (CPLib.eqr(Cursor_knarapbo.GetString("TIPORAP"),"P")) {
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
              } else { // Else
                // * --- Select from anarapbo
                m_cServer = m_Ctx.GetServer("anarapbo");
                m_cPhName = m_Ctx.GetPhName("anarapbo");
                if (Cursor_anarapbo!=null)
                  Cursor_anarapbo.Close();
                Cursor_anarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select TIPORAP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapp_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("anarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_anarapbo.Eof())) {
                  /* _flagrap := anarapbo->TIPORAP */
                  _flagrap = Cursor_anarapbo.GetString("TIPORAP");
                  Cursor_anarapbo.Next();
                }
                m_cConnectivityError = Cursor_anarapbo.ErrorMessage();
                Cursor_anarapbo.Close();
                // * --- End Select
              } // End If
              Cursor_knarapbo.Next();
            }
            m_cConnectivityError = Cursor_knarapbo.ErrorMessage();
            Cursor_knarapbo.Close();
            // * --- End Select
          } // End If
          /* If Empty(qbe_rapp_chkdiana->CODDIPE) or Empty(qbe_rapp_chkdiana->CODCAB) */
          if (CPLib.Empty(Cursor_qbe_rapp_chkdiana.GetString("CODDIPE")) || CPLib.Empty(Cursor_qbe_rapp_chkdiana.GetString("CODCAB"))) {
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
                Error l_oErrorFault = new Error("Read on intermbo into routine arrt_chkdiana_mt returns two or more records. This item should return only a record.");
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
                  Error l_oErrorFault = new Error("Read on anadip into routine arrt_chkdiana_mt returns two or more records. This item should return only a record.");
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
            /* _note := _note + qbe_rapp_chkdiana->CODDIPE + qbe_rapp_chkdiana->CODCAB + qbe_rapp_chkdiana->DESCCIT + qbe_rapp_chkdiana->PROVINCIA */
            _note = _note+Cursor_qbe_rapp_chkdiana.GetString("CODDIPE")+Cursor_qbe_rapp_chkdiana.GetString("CODCAB")+Cursor_qbe_rapp_chkdiana.GetString("DESCCIT")+Cursor_qbe_rapp_chkdiana.GetString("PROVINCIA");
          } // End If
          /* _note := _note + Left(LRTrim(DateToChar(qbe_rapp_chkdiana->DATAOPE))+Space(8),8) + Left(LRTrim(qbe_rapp_chkdiana->FLAGFRAZ)+" ",1) + Left(LRTrim(qbe_rapp_chkdiana->FLAGCONT)+" ",1) */
          _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_rapp_chkdiana.GetDate("DATAOPE")))+CPLib.Space(8),8)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("FLAGFRAZ"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("FLAGCONT"))+" ",1);
          /* _note := _note + Left(LRTrim(qbe_rapp_chkdiana->CODANA)+Space(4),4) + Left(LRTrim(qbe_rapp_chkdiana->CODVOC)+Space(2),2) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("CODANA"))+CPLib.Space(4),4)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("CODVOC"))+CPLib.Space(2),2);
          /* _note := _note + Left(LRTrim(qbe_rapp_chkdiana->TIPOINT2)+Space(2),2) + Left(LRTrim(qbe_rapp_chkdiana->CODINT2)+Space(11),11) + Left(LRTrim(qbe_rapp_chkdiana->PAESE)+Space(3),3) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("TIPOINT2"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("CODINT2"))+CPLib.Space(11),11)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("PAESE"))+CPLib.Space(3),3);
          /* _note := _note + Left(LRTrim(qbe_rapp_chkdiana->CODCAB2)+Space(6),6) + Left(LRTrim(qbe_rapp_chkdiana->DESC2)+Space(30),30) + Left(LRTrim(qbe_rapp_chkdiana->PROV2)+Space(2),2) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("CODCAB2"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("DESC2"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("PROV2"))+CPLib.Space(2),2);
          /* _note := _note + Space(50) + Left(LRTrim(qbe_rapp_chkdiana->RAPPORTO)+Space(25),25) + Left(LRTrim(qbe_rapp_chkdiana->FLAGRAP)+" ",1) */
          _note = _note+CPLib.Space(50)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("RAPPORTO"))+CPLib.Space(25),25)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("FLAGRAP"))+" ",1);
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
          /* _note := _note + Left(LRTrim(qbe_rapp_chkdiana->OPERAZMOD)+Space(20),20) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("OPERAZMOD"))+CPLib.Space(20),20);
          // * --- Select from anarapbo
          m_cServer = m_Ctx.GetServer("anarapbo");
          m_cPhName = m_Ctx.GetPhName("anarapbo");
          if (Cursor_anarapbo!=null)
            Cursor_anarapbo.Close();
          Cursor_anarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapp_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("anarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
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
              /* _note := _note + '2' + Left(LRTrim(anarapbo->VALUTA)+Space(3),3) */
              _note = _note+"2"+CPLib.Left(CPLib.LRTrim(Cursor_anarapbo.GetString("VALUTA"))+CPLib.Space(3),3);
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
          /* FileLibMit.WriteLine(fhand,_note) */
          FileLibMit.WriteLine(fhand,_note);
          /* nTotRec := nTotRec + 1 */
          nTotRec = CPLib.Round(nTotRec+1,0);
          /* nTotReg := nTotReg + 1 */
          nTotReg = CPLib.Round(nTotReg+1,0);
          /* nNumRec := nNumRec + 1 */
          nNumRec = CPLib.Round(nNumRec+1,0);
          /* Case qbe_rapp_chkdiana->TIPOOPRAP='25' or qbe_rapp_chkdiana->TIPOOPRAP='28' */
          if (CPLib.eqr(Cursor_qbe_rapp_chkdiana.GetString("TIPOOPRAP"),"25") || CPLib.eqr(Cursor_qbe_rapp_chkdiana.GetString("TIPOOPRAP"),"28")) {
            // * --- Select from intestbo
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            if (Cursor_intestbo!=null)
              Cursor_intestbo.Close();
            Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapp_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestbo.Eof())) {
              /* _avanza := 0 */
              _avanza = CPLib.Round(0,0);
              /* If intestbo->TIPOPERS='D' */
              if (CPLib.eqr(Cursor_intestbo.GetString("TIPOPERS"),"D")) {
                /* _avanza := 1 */
                _avanza = CPLib.Round(1,0);
              } // End If
              /* If Empty(intestbo->CODINTER) */
              if (CPLib.Empty(Cursor_intestbo.GetString("CODINTER"))) {
                /* _avanza := 1 */
                _avanza = CPLib.Round(1,0);
              } // End If
              /* If _avanza=0 */
              if (CPLib.eqr(_avanza,0)) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* _note := w_tipinter + w_codinter+'2' */
                  _note = w_tipinter+w_codinter+"2";
                  /* _note := _note + Left(LRTrim(DateToChar(qbe_rapp_chkdiana->DATAOPE))+Space(8),8) + qbe_rapp_chkdiana->NUMPROG + LibreriaMit.StatoReg('qbe_rapp_chkdiana',qbe_rapp_chkdiana->STATOREG) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_rapp_chkdiana.GetDate("DATAOPE")))+CPLib.Space(8),8)+Cursor_qbe_rapp_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("qbe_rapp_chkdiana",Cursor_qbe_rapp_chkdiana.GetString("STATOREG"));
                  /* _note := _note + Left(LRTrim(personbo->CONNES)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CONNES"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
                  /* _note := _note + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                  /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
                  /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
                  /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
                  if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                    /* _note := _note + Space(8) */
                    _note = _note+CPLib.Space(8);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                  } // End If
                  /* If not(Empty(personbo->NASSTATO)) */
                  if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                    /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                  } // End If
                  /* _note := _note + Left(LRTrim(personbo->SETTSINT)+Space(3),3) + Left(LRTrim(qbe_rapp_chkdiana->RAPPORTO)+Space(25),25) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("RAPPORTO"))+CPLib.Space(25),25);
                  /* _note := _note + Left(LRTrim(qbe_rapp_chkdiana->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                  /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
                  if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                    /* _note := _note + Space(8) */
                    _note = _note+CPLib.Space(8);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                    _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                  } // End If
                  /* _note := _note + Left(LRTrim(personbo->AUTRILASC)+Space(30),30) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("AUTRILASC"))+CPLib.Space(30),30);
                  /* _note := _note + Left(LRTrim(personbo->SESSO)+" ",1) + Space(34) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SESSO"))+" ",1)+CPLib.Space(34);
                  /* FileLibMit.WriteLine(fhand,_note) */
                  FileLibMit.WriteLine(fhand,_note);
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } // End If
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
            Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapp_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xntestbo.Eof())) {
              /* _avanza := 0 */
              _avanza = CPLib.Round(0,0);
              /* If xntestbo->TIPOPERS='D' */
              if (CPLib.eqr(Cursor_xntestbo.GetString("TIPOPERS"),"D")) {
                /* _avanza := 1 */
                _avanza = CPLib.Round(1,0);
              } // End If
              /* If Empty(xntestbo->CODINTER) */
              if (CPLib.Empty(Cursor_xntestbo.GetString("CODINTER"))) {
                /* _avanza := 1 */
                _avanza = CPLib.Round(1,0);
              } // End If
              /* If _avanza=0 */
              if (CPLib.eqr(_avanza,0)) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* _note := w_tipinter + w_codinter+'2' */
                  _note = w_tipinter+w_codinter+"2";
                  /* _note := _note + Left(LRTrim(DateToChar(qbe_rapp_chkdiana->DATAOPE))+Space(8),8) + qbe_rapp_chkdiana->NUMPROG + LibreriaMit.StatoReg('qbe_rapp_chkdiana',qbe_rapp_chkdiana->STATOREG) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_rapp_chkdiana.GetDate("DATAOPE")))+CPLib.Space(8),8)+Cursor_qbe_rapp_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("qbe_rapp_chkdiana",Cursor_qbe_rapp_chkdiana.GetString("STATOREG"));
                  /* _note := _note + Left(LRTrim(personbo->CONNES)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CONNES"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
                  /* _note := _note + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                  /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
                  /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
                  /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
                  if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                    /* _note := _note + Space(8) */
                    _note = _note+CPLib.Space(8);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                  } // End If
                  /* If not(Empty(personbo->NASSTATO)) */
                  if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                    /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                  } // End If
                  /* _note := _note + Left(LRTrim(personbo->SETTSINT)+Space(3),3) + Left(LRTrim(qbe_rapp_chkdiana->RAPPORTO)+Space(25),25) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("RAPPORTO"))+CPLib.Space(25),25);
                  /* _note := _note + Left(LRTrim(qbe_rapp_chkdiana->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                  /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
                  if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                    /* _note := _note + Space(8) */
                    _note = _note+CPLib.Space(8);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                    _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                  } // End If
                  /* _note := _note + Left(LRTrim(personbo->AUTRILASC)+Space(30),30) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("AUTRILASC"))+CPLib.Space(30),30);
                  /* _note := _note + Left(LRTrim(personbo->SESSO)+" ",1) + Space(34) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SESSO"))+" ",1)+CPLib.Space(34);
                  /* FileLibMit.WriteLine(fhand,_note) */
                  FileLibMit.WriteLine(fhand,_note);
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } // End If
              Cursor_xntestbo.Next();
            }
            m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
            Cursor_xntestbo.Close();
            // * --- End Select
            /* Case Right(qbe_rapp_chkdiana->TIPOOPRAP,1)='6' */
          } else if (CPLib.eqr(CPLib.Right(Cursor_qbe_rapp_chkdiana.GetString("TIPOOPRAP"),1),"6")) {
            // * --- Select from intestbo
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            if (Cursor_intestbo!=null)
              Cursor_intestbo.Close();
            Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapp_chkdiana.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG2="+CPLib.ToSQL(Cursor_qbe_rapp_chkdiana.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestbo.Eof())) {
              /* _avanza := 0 */
              _avanza = CPLib.Round(0,0);
              /* If intestbo->TIPOPERS='D' */
              if (CPLib.eqr(Cursor_intestbo.GetString("TIPOPERS"),"D")) {
                /* _avanza := 1 */
                _avanza = CPLib.Round(1,0);
              } // End If
              /* If Empty(intestbo->CODINTER) */
              if (CPLib.Empty(Cursor_intestbo.GetString("CODINTER"))) {
                /* _avanza := 1 */
                _avanza = CPLib.Round(1,0);
              } // End If
              /* If _avanza=0 */
              if (CPLib.eqr(_avanza,0)) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* _note := w_tipinter + w_codinter+'2' */
                  _note = w_tipinter+w_codinter+"2";
                  /* _note := _note + Left(LRTrim(DateToChar(qbe_rapp_chkdiana->DATAOPE))+Space(8),8) + qbe_rapp_chkdiana->NUMPROG + LibreriaMit.StatoReg('qbe_rapp_chkdiana',qbe_rapp_chkdiana->STATOREG) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_rapp_chkdiana.GetDate("DATAOPE")))+CPLib.Space(8),8)+Cursor_qbe_rapp_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("qbe_rapp_chkdiana",Cursor_qbe_rapp_chkdiana.GetString("STATOREG"));
                  /* _note := _note + Left(LRTrim(personbo->CONNES)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CONNES"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
                  /* _note := _note + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                  /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
                  /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
                  /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
                  if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                    /* _note := _note + Space(8) */
                    _note = _note+CPLib.Space(8);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                  } // End If
                  /* If not(Empty(personbo->NASSTATO)) */
                  if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                    /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                  } // End If
                  /* _note := _note + Left(LRTrim(personbo->SETTSINT)+Space(3),3) + Left(LRTrim(qbe_rapp_chkdiana->RAPPORTO)+Space(25),25) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("RAPPORTO"))+CPLib.Space(25),25);
                  /* _note := _note + Left(LRTrim(qbe_rapp_chkdiana->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                  /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
                  if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                    /* _note := _note + Space(8) */
                    _note = _note+CPLib.Space(8);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                    _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                  } // End If
                  /* _note := _note + Left(LRTrim(personbo->AUTRILASC)+Space(30),30) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("AUTRILASC"))+CPLib.Space(30),30);
                  /* _note := _note + Left(LRTrim(personbo->SESSO)+" ",1) + Space(34) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SESSO"))+" ",1)+CPLib.Space(34);
                  /* FileLibMit.WriteLine(fhand,_note) */
                  FileLibMit.WriteLine(fhand,_note);
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } // End If
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
            Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapp_chkdiana.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG2="+CPLib.ToSQL(Cursor_qbe_rapp_chkdiana.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xntestbo.Eof())) {
              /* _avanza := 0 */
              _avanza = CPLib.Round(0,0);
              /* If xntestbo->TIPOPERS='D' */
              if (CPLib.eqr(Cursor_xntestbo.GetString("TIPOPERS"),"D")) {
                /* _avanza := 1 */
                _avanza = CPLib.Round(1,0);
              } // End If
              /* If Empty(xntestbo->CODINTER) */
              if (CPLib.Empty(Cursor_xntestbo.GetString("CODINTER"))) {
                /* _avanza := 1 */
                _avanza = CPLib.Round(1,0);
              } // End If
              /* If _avanza=0 */
              if (CPLib.eqr(_avanza,0)) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* _note := w_tipinter + w_codinter+'2' */
                  _note = w_tipinter+w_codinter+"2";
                  /* _note := _note + Left(LRTrim(DateToChar(qbe_rapp_chkdiana->DATAOPE))+Space(8),8) + qbe_rapp_chkdiana->NUMPROG + LibreriaMit.StatoReg('qbe_rapp_chkdiana',qbe_rapp_chkdiana->STATOREG) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_rapp_chkdiana.GetDate("DATAOPE")))+CPLib.Space(8),8)+Cursor_qbe_rapp_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("qbe_rapp_chkdiana",Cursor_qbe_rapp_chkdiana.GetString("STATOREG"));
                  /* _note := _note + Left(LRTrim(personbo->CONNES)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CONNES"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
                  /* _note := _note + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                  /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
                  /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
                  /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
                  if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                    /* _note := _note + Space(8) */
                    _note = _note+CPLib.Space(8);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                  } // End If
                  /* If not(Empty(personbo->NASSTATO)) */
                  if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                    /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                  } // End If
                  /* _note := _note + Left(LRTrim(personbo->SETTSINT)+Space(3),3) + Left(LRTrim(qbe_rapp_chkdiana->RAPPORTO)+Space(25),25) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("RAPPORTO"))+CPLib.Space(25),25);
                  /* _note := _note + Left(LRTrim(qbe_rapp_chkdiana->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                  /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
                  if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                    /* _note := _note + Space(8) */
                    _note = _note+CPLib.Space(8);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                    _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                  } // End If
                  /* _note := _note + Left(LRTrim(personbo->AUTRILASC)+Space(30),30) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("AUTRILASC"))+CPLib.Space(30),30);
                  /* _note := _note + Left(LRTrim(personbo->SESSO)+" ",1) + Space(34) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SESSO"))+" ",1)+CPLib.Space(34);
                  /* FileLibMit.WriteLine(fhand,_note) */
                  FileLibMit.WriteLine(fhand,_note);
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } // End If
              Cursor_xntestbo.Next();
            }
            m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
            Cursor_xntestbo.Close();
            // * --- End Select
          } else { // Otherwise
            // * --- Select from intestbo
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            if (Cursor_intestbo!=null)
              Cursor_intestbo.Close();
            Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapp_chkdiana.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG1="+CPLib.ToSQL(Cursor_qbe_rapp_chkdiana.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestbo.Eof())) {
              /* _avanza := 0 */
              _avanza = CPLib.Round(0,0);
              /* If intestbo->TIPOPERS='D' */
              if (CPLib.eqr(Cursor_intestbo.GetString("TIPOPERS"),"D")) {
                /* _avanza := 1 */
                _avanza = CPLib.Round(1,0);
              } // End If
              /* If Empty(intestbo->CODINTER) */
              if (CPLib.Empty(Cursor_intestbo.GetString("CODINTER"))) {
                /* _avanza := 1 */
                _avanza = CPLib.Round(1,0);
              } // End If
              /* If _avanza=0 */
              if (CPLib.eqr(_avanza,0)) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* _note := w_tipinter + w_codinter+'2' */
                  _note = w_tipinter+w_codinter+"2";
                  /* _note := _note + Left(LRTrim(DateToChar(qbe_rapp_chkdiana->DATAOPE))+Space(8),8) + qbe_rapp_chkdiana->NUMPROG + LibreriaMit.StatoReg('qbe_rapp_chkdiana',qbe_rapp_chkdiana->STATOREG) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_rapp_chkdiana.GetDate("DATAOPE")))+CPLib.Space(8),8)+Cursor_qbe_rapp_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("qbe_rapp_chkdiana",Cursor_qbe_rapp_chkdiana.GetString("STATOREG"));
                  /* _note := _note + Left(LRTrim(personbo->CONNES)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CONNES"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
                  /* _note := _note + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                  /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
                  /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
                  /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
                  if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                    /* _note := _note + Space(8) */
                    _note = _note+CPLib.Space(8);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                  } // End If
                  /* If not(Empty(personbo->NASSTATO)) */
                  if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                    /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                  } // End If
                  /* _note := _note + Left(LRTrim(personbo->SETTSINT)+Space(3),3) + Left(LRTrim(qbe_rapp_chkdiana->RAPPORTO)+Space(25),25) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("RAPPORTO"))+CPLib.Space(25),25);
                  /* _note := _note + Left(LRTrim(qbe_rapp_chkdiana->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                  /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
                  if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                    /* _note := _note + Space(8) */
                    _note = _note+CPLib.Space(8);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                    _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                  } // End If
                  /* _note := _note + Left(LRTrim(personbo->AUTRILASC)+Space(30),30) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("AUTRILASC"))+CPLib.Space(30),30);
                  /* _note := _note + Left(LRTrim(personbo->SESSO)+" ",1) + Space(34) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SESSO"))+" ",1)+CPLib.Space(34);
                  /* FileLibMit.WriteLine(fhand,_note) */
                  FileLibMit.WriteLine(fhand,_note);
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } // End If
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
            Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapp_chkdiana.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG1="+CPLib.ToSQL(Cursor_qbe_rapp_chkdiana.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xntestbo.Eof())) {
              /* _avanza := 0 */
              _avanza = CPLib.Round(0,0);
              /* If xntestbo->TIPOPERS='D' */
              if (CPLib.eqr(Cursor_xntestbo.GetString("TIPOPERS"),"D")) {
                /* _avanza := 1 */
                _avanza = CPLib.Round(1,0);
              } // End If
              /* If Empty(xntestbo->CODINTER) */
              if (CPLib.Empty(Cursor_xntestbo.GetString("CODINTER"))) {
                /* _avanza := 1 */
                _avanza = CPLib.Round(1,0);
              } // End If
              /* If _avanza=0 */
              if (CPLib.eqr(_avanza,0)) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* _note := w_tipinter + w_codinter+'2' */
                  _note = w_tipinter+w_codinter+"2";
                  /* _note := _note + Left(LRTrim(DateToChar(qbe_rapp_chkdiana->DATAOPE))+Space(8),8) + qbe_rapp_chkdiana->NUMPROG + LibreriaMit.StatoReg('qbe_rapp_chkdiana',qbe_rapp_chkdiana->STATOREG) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_rapp_chkdiana.GetDate("DATAOPE")))+CPLib.Space(8),8)+Cursor_qbe_rapp_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("qbe_rapp_chkdiana",Cursor_qbe_rapp_chkdiana.GetString("STATOREG"));
                  /* _note := _note + Left(LRTrim(personbo->CONNES)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CONNES"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
                  /* _note := _note + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                  /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
                  /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
                  /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
                  if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                    /* _note := _note + Space(8) */
                    _note = _note+CPLib.Space(8);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                  } // End If
                  /* If not(Empty(personbo->NASSTATO)) */
                  if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                    /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                  } // End If
                  /* _note := _note + Left(LRTrim(personbo->SETTSINT)+Space(3),3) + Left(LRTrim(qbe_rapp_chkdiana->RAPPORTO)+Space(25),25) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("RAPPORTO"))+CPLib.Space(25),25);
                  /* _note := _note + Left(LRTrim(qbe_rapp_chkdiana->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                  /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
                  if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                    /* _note := _note + Space(8) */
                    _note = _note+CPLib.Space(8);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                    _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                  } // End If
                  /* _note := _note + Left(LRTrim(personbo->AUTRILASC)+Space(30),30) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("AUTRILASC"))+CPLib.Space(30),30);
                  /* _note := _note + Left(LRTrim(personbo->SESSO)+" ",1) + Space(34) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SESSO"))+" ",1)+CPLib.Space(34);
                  /* FileLibMit.WriteLine(fhand,_note) */
                  FileLibMit.WriteLine(fhand,_note);
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } // End If
              Cursor_xntestbo.Next();
            }
            m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
            Cursor_xntestbo.Close();
            // * --- End Select
          } // End Case
          /* If not(Empty(qbe_rapp_chkdiana->CONNESOPER)) */
          if ( ! (CPLib.Empty(Cursor_qbe_rapp_chkdiana.GetString("CONNESOPER")))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_rapp_chkdiana.GetString("CONNESOPER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              /* _note := w_tipinter + w_codinter+'4' */
              _note = w_tipinter+w_codinter+"4";
              /* _note := _note + Left(LRTrim(DateToChar(qbe_rapp_chkdiana->DATAOPE))+Space(8),8) + Left(LRTrim(qbe_rapp_chkdiana->NUMPROG)+Space(11),11) + LibreriaMit.StatoReg('qbe_rapp_chkdiana',qbe_rapp_chkdiana->STATOREG) */
              _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_rapp_chkdiana.GetDate("DATAOPE")))+CPLib.Space(8),8)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapp_chkdiana.GetString("NUMPROG"))+CPLib.Space(11),11)+LibreriaMit.StatoReg("qbe_rapp_chkdiana",Cursor_qbe_rapp_chkdiana.GetString("STATOREG"));
              /* _note := _note + Left(LRTrim(personbo->CONNES)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CONNES"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
              /* _note := _note + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
              /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
              /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
              /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
              if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                /* _note := _note + Space(8) */
                _note = _note+CPLib.Space(8);
              } else { // Else
                /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
              } // End If
              /* If not(Empty(personbo->NASSTATO)) */
              if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Space(35) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Space(35);
              } else { // Else
                /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Space(35) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Space(35);
              } // End If
              /* _note := _note + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
              /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
              if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                /* _note := _note + Space(8) */
                _note = _note+CPLib.Space(8);
              } else { // Else
                /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
              } // End If
              /* _note := _note + Left(LRTrim(personbo->AUTRILASC)+Space(30),30) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("AUTRILASC"))+CPLib.Space(30),30);
              /* _note := _note + Left(LRTrim(personbo->SESSO)+" ",1) + Space(34) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SESSO"))+" ",1)+CPLib.Space(34);
              /* FileLibMit.WriteLine(fhand,_note) */
              FileLibMit.WriteLine(fhand,_note);
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } // End If
          Cursor_qbe_rapp_chkdiana.Next();
        }
        m_cConnectivityError = Cursor_qbe_rapp_chkdiana.ErrorMessage();
        Cursor_qbe_rapp_chkdiana.Close();
        // * --- End Select
      } // End If
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
    } finally {
      try {
        if (Cursor_qbe_rapd_chkdiana!=null)
          Cursor_qbe_rapd_chkdiana.Close();
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
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
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
        if (Cursor_qbe_rapp_chkdiana!=null)
          Cursor_qbe_rapp_chkdiana.Close();
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
        if (Cursor_xnarapbo!=null)
          Cursor_xnarapbo.Close();
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
    CPResultSet Cursor_qbe_frad_chkdiana_limits=null;
    CPResultSet Cursor_qbe_frad_chkdiana=null;
    CPResultSet Cursor_knarapbo=null;
    CPResultSet Cursor_xnarapbo=null;
    CPResultSet Cursor_anarapbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_anadip=null;
    CPResultSet Cursor_kersonbo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_clientifrz=null;
    CPResultSet Cursor_sogopefbo=null;
    CPResultSet Cursor_beneficfrz=null;
    CPResultSet Cursor_terzistifrz=null;
    CPResultSet Cursor_qbe_frap_chkdiana_limits=null;
    CPResultSet Cursor_qbe_frap_chkdiana=null;
    CPResultSet Cursor_xlientifrz=null;
    CPResultSet Cursor_xogopefbo=null;
    CPResultSet Cursor_xeneficfrz=null;
    CPResultSet Cursor_xerzistifrz=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Cicla sulle frazionate */
      /* If w_tipoarch = 'D' */
      if (CPLib.eqr(w_tipoarch,"D")) {
        /* Cicla sulle informazioni sui rapporti */
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
        SPBridge.HMCaller _h00000488;
        _h00000488 = new SPBridge.HMCaller();
        _h00000488.Set("m_cVQRList",m_cVQRList);
        _h00000488.Set("cdadata",w_cdadata);
        _h00000488.Set("c_adata",w_c_adata);
        _h00000488.Set("codage",w_codage);
        if (Cursor_qbe_frad_chkdiana_limits!=null)
          Cursor_qbe_frad_chkdiana_limits.Close();
        Cursor_qbe_frad_chkdiana_limits = new VQRHolder("qbe_frad_chkdiana_limits",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000488,true).GetResultSet(m_Ctx);
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
          /* _nomefile := 'campione.txt.'+Right('0000'+LRTrim(Str(_conta,4,0)),4) */
          _nomefile = "campione.txt."+CPLib.Right("0000"+CPLib.LRTrim(CPLib.Str(_conta,4,0)),4);
          /* fhand := FileLibMit.OpenWrite('./flussi/'+LRTrim(gAzienda)+"/"+LRTrim(_nomefile)) */
          fhand = FileLibMit.OpenWrite("./flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_nomefile));
          /* Cicla sulle operazioni */
          // * --- Select from qbe_frad_chkdiana
          SPBridge.HMCaller _h0000049A;
          _h0000049A = new SPBridge.HMCaller();
          _h0000049A.Set("m_cVQRList",m_cVQRList);
          _h0000049A.Set("cdadata",w_cdadata);
          _h0000049A.Set("c_adata",w_c_adata);
          _h0000049A.Set("codage",w_codage);
          _h0000049A.Set("_bottom",_bottom);
          _h0000049A.Set("_top",_top);
          if (Cursor_qbe_frad_chkdiana!=null)
            Cursor_qbe_frad_chkdiana.Close();
          Cursor_qbe_frad_chkdiana = new VQRHolder("qbe_frad_chkdiana",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000049A,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_frad_chkdiana.Eof())) {
            /* _ctotale := _ctotale + 1 */
            _ctotale = CPLib.Round(_ctotale+1,0);
            /* gMsgImp := 'Elaborazione Operazione N.: '+LRTrim(Str(_ctotale,15,0)) // Messaggio Import */
            gMsgImp = "Elaborazione Operazione N.: "+CPLib.LRTrim(CPLib.Str(_ctotale,15,0));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* _note := w_tipinter + w_codinter + '1' */
            _note = w_tipinter+w_codinter+"1";
            /* If Empty(LRTrim(qbe_frad_chkdiana->FLAGRAP2)) */
            if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("FLAGRAP2")))) {
              /* _note := _note + DateToChar(qbe_frad_chkdiana->DATAOPE) + qbe_frad_chkdiana->NUMPROG + 'S' */
              _note = _note+CPLib.DateToChar(Cursor_qbe_frad_chkdiana.GetDate("DATAOPE"))+Cursor_qbe_frad_chkdiana.GetString("NUMPROG")+"S";
            } else { // Else
              /* _note := _note + qbe_frad_chkdiana->IDEREG */
              _note = _note+Cursor_qbe_frad_chkdiana.GetString("IDEREG");
            } // End If
            /* _flagrap := '' */
            _flagrap = "";
            /* _flagrap := '' */
            _flagrap = "";
            /* If not(Empty(qbe_frad_chkdiana->FLAGRAP)) */
            if ( ! (CPLib.Empty(Cursor_qbe_frad_chkdiana.GetString("FLAGRAP")))) {
              /* _flagrap := qbe_frad_chkdiana->FLAGRAP */
              _flagrap = Cursor_qbe_frad_chkdiana.GetString("FLAGRAP");
            } else { // Else
              // * --- Select from knarapbo
              m_cServer = m_Ctx.GetServer("knarapbo");
              m_cPhName = m_Ctx.GetPhName("knarapbo");
              if (Cursor_knarapbo!=null)
                Cursor_knarapbo.Close();
              Cursor_knarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("knarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_knarapbo.Eof())) {
                /* If knarapbo->TIPORAP='P' */
                if (CPLib.eqr(Cursor_knarapbo.GetString("TIPORAP"),"P")) {
                  // * --- Select from xnarapbo
                  m_cServer = m_Ctx.GetServer("xnarapbo");
                  m_cPhName = m_Ctx.GetPhName("xnarapbo");
                  if (Cursor_xnarapbo!=null)
                    Cursor_xnarapbo.Close();
                  Cursor_xnarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select TIPORAP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xnarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_xnarapbo.Eof())) {
                    /* _flagrap := xnarapbo->TIPORAP */
                    _flagrap = Cursor_xnarapbo.GetString("TIPORAP");
                    Cursor_xnarapbo.Next();
                  }
                  m_cConnectivityError = Cursor_xnarapbo.ErrorMessage();
                  Cursor_xnarapbo.Close();
                  // * --- End Select
                } else { // Else
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
                } // End If
                Cursor_knarapbo.Next();
              }
              m_cConnectivityError = Cursor_knarapbo.ErrorMessage();
              Cursor_knarapbo.Close();
              // * --- End Select
            } // End If
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
                  Error l_oErrorFault = new Error("Read on intermbo into routine arrt_chkdiana_mt returns two or more records. This item should return only a record.");
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
                    Error l_oErrorFault = new Error("Read on anadip into routine arrt_chkdiana_mt returns two or more records. This item should return only a record.");
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
            /* _note := _note + Left(LRTrim(qbe_frad_chkdiana->TIPOINT2)+Space(2),2) + Left(LRTrim(qbe_frad_chkdiana->CODFISCICP)+Space(11),11) + Left(LRTrim(qbe_frad_chkdiana->PAESE)+Space(3),3) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("TIPOINT2"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("CODFISCICP"))+CPLib.Space(11),11)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("PAESE"))+CPLib.Space(3),3);
            /* _note := _note + Left(LRTrim(qbe_frad_chkdiana->CODCAB2)+Space(6),6) + Left(LRTrim(qbe_frad_chkdiana->DESC2)+Space(30),30) + Left(LRTrim(qbe_frad_chkdiana->PROV2)+Space(2),2) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("CODCAB2"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("DESC2"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("PROV2"))+CPLib.Space(2),2);
            /* _note := _note + Left(LRTrim(qbe_frad_chkdiana->DESCINTER)+Space(50),50) + Left(LRTrim(qbe_frad_chkdiana->RAPPORTO)+Space(25),25) + Left(LRTrim(_flagrap)+" ",1) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("DESCINTER"))+CPLib.Space(50),50)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("RAPPORTO"))+CPLib.Space(25),25)+CPLib.Left(CPLib.LRTrim(_flagrap)+" ",1);
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
            /* _note := _note + Left(LRTrim(qbe_frad_chkdiana->OPERAZMOD)+Space(20),20) + Left(LRTrim(qbe_frad_chkdiana->FLAGLIRE)+" ",1) + Left(LRTrim(qbe_frad_chkdiana->VALUTA)+Space(3),3) + Left(LRTrim(qbe_frad_chkdiana->SEGNO)+" ",1) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("OPERAZMOD"))+CPLib.Space(20),20)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("FLAGLIRE"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("VALUTA"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("SEGNO"))+" ",1);
            /* _note := _note +  Right('000000000000000'+LRTrim(Str(qbe_frad_chkdiana->TOTLIRE,15,0)),15) + Right('000000000000000'+LRTrim(Str(qbe_frad_chkdiana->TOTCONT,15,0)),15) + Space(69) */
            _note = _note+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_frad_chkdiana.GetDouble("TOTLIRE"),15,0)),15)+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_frad_chkdiana.GetDouble("TOTCONT"),15,0)),15)+CPLib.Space(69);
            /* FileLibMit.WriteLine(fhand,_note) */
            FileLibMit.WriteLine(fhand,_note);
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nTotReg := nTotReg + 1 */
            nTotReg = CPLib.Round(nTotReg+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
            /* If not(Empty(qbe_frad_chkdiana->CONNESCLI)) and Empty(LRTrim(qbe_frad_chkdiana->RAPPORTO)) */
            if ( ! (CPLib.Empty(Cursor_qbe_frad_chkdiana.GetString("CONNESCLI"))) && CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("RAPPORTO")))) {
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
                  /* _note := _note + Left(LRTrim(DateToChar(qbe_frad_chkdiana->DATAOPE))+Space(8),8) + qbe_frad_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_frad_chkdiana->STATOREG) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_frad_chkdiana.GetDate("DATAOPE")))+CPLib.Space(8),8)+Cursor_qbe_frad_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_frad_chkdiana.GetString("STATOREG"));
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
                    /* _note := _note + Left(LRTrim(kersonbo->NASSTATO)+Space(30),30) + Left(LRTrim(kersonbo->SOTGRUP)+Space(3),3) + Left(LRTrim(kersonbo->RAMOGRUP)+Space(3),3) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(kersonbo->NASCOMUN)+Space(30),30) + Left(LRTrim(kersonbo->SOTGRUP)+Space(3),3) + Left(LRTrim(kersonbo->RAMOGRUP)+Space(3),3) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                  } // End If
                  /* _note := _note + Left(LRTrim(kersonbo->SETTSINT)+Space(3),3) + Left(LRTrim(qbe_frad_chkdiana->RAPPORTO)+Space(25),25) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("RAPPORTO"))+CPLib.Space(25),25);
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
                  /* FileLibMit.WriteLine(fhand,_note) */
                  FileLibMit.WriteLine(fhand,_note);
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
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana.GetString("CONNESCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
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
                  /* _note := _note + Left(LRTrim(DateToChar(qbe_frad_chkdiana->DATAOPE))+Space(8),8) + qbe_frad_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_frad_chkdiana->STATOREG) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_frad_chkdiana.GetDate("DATAOPE")))+CPLib.Space(8),8)+Cursor_qbe_frad_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_frad_chkdiana.GetString("STATOREG"));
                  /* _note := _note + Left(LRTrim(qbe_frad_chkdiana->CONNESCLI)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("CONNESCLI"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
                  /* _note := _note + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                  /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
                  /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
                  /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
                  if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                    /* _note := _note + Space(8) */
                    _note = _note+CPLib.Space(8);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                  } // End If
                  /* If not(Empty(personbo->NASSTATO)) */
                  if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                    /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                  } // End If
                  /* _note := _note + Left(LRTrim(personbo->SETTSINT)+Space(3),3) + Left(LRTrim(qbe_frad_chkdiana->RAPPORTO)+Space(25),25) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("RAPPORTO"))+CPLib.Space(25),25);
                  /* _note := _note + Left(LRTrim(qbe_frad_chkdiana->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                  /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
                  if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                    /* _note := _note + Space(8) */
                    _note = _note+CPLib.Space(8);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                    _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                  } // End If
                  /* _note := _note + Left(LRTrim(personbo->AUTRILASC)+Space(30),30) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("AUTRILASC"))+CPLib.Space(30),30);
                  /* _note := _note + Left(LRTrim(personbo->SESSO)+" ",1) + Space(34) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SESSO"))+" ",1)+CPLib.Space(34);
                  /* FileLibMit.WriteLine(fhand,_note) */
                  FileLibMit.WriteLine(fhand,_note);
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } // End If
            } else { // Else
              // * --- Select from intestbo
              m_cServer = m_Ctx.GetServer("intestbo");
              m_cPhName = m_Ctx.GetPhName("intestbo");
              if (Cursor_intestbo!=null)
                Cursor_intestbo.Close();
              Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_intestbo.Eof())) {
                /* If (qbe_frad_chkdiana->RAPPORTO+'P') = (intestbo->RAPPORTO+intestbo->TIPOPERS) */
                if (CPLib.eqr((Cursor_qbe_frad_chkdiana.GetString("RAPPORTO")+"P"),(Cursor_intestbo.GetString("RAPPORTO")+Cursor_intestbo.GetString("TIPOPERS")))) {
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
                    // * --- Select from personbo
                    m_cServer = m_Ctx.GetServer("personbo");
                    m_cPhName = m_Ctx.GetPhName("personbo");
                    if (Cursor_personbo!=null)
                      Cursor_personbo.Close();
                    Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_personbo.Eof())) {
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
                      /* _note := _note + Left(LRTrim(DateToChar(qbe_frad_chkdiana->DATAOPE))+Space(8),8) + qbe_frad_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_frad_chkdiana->STATOREG) */
                      _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_frad_chkdiana.GetDate("DATAOPE")))+CPLib.Space(8),8)+Cursor_qbe_frad_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_frad_chkdiana.GetString("STATOREG"));
                      /* _note := _note + Left(LRTrim(intestbo->CODINTER)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
                      _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_intestbo.GetString("CODINTER"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
                      /* _note := _note + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
                      _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                      /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
                      _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
                      /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
                      _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
                      /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
                      if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                        /* _note := _note + Space(8) */
                        _note = _note+CPLib.Space(8);
                      } else { // Else
                        /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                        _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                      } // End If
                      /* If not(Empty(personbo->NASSTATO)) */
                      if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                        /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                      } else { // Else
                        /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                      } // End If
                      /* _note := _note + Left(LRTrim(personbo->SETTSINT)+Space(3),3) + Left(LRTrim(qbe_frad_chkdiana->RAPPORTO)+Space(25),25) */
                      _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("RAPPORTO"))+CPLib.Space(25),25);
                      /* _note := _note + Left(LRTrim(qbe_frad_chkdiana->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
                      _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                      /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
                      if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                        /* _note := _note + Space(8) */
                        _note = _note+CPLib.Space(8);
                      } else { // Else
                        /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                        _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                      } // End If
                      /* _note := _note + Left(LRTrim(personbo->AUTRILASC)+Space(30),30) */
                      _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("AUTRILASC"))+CPLib.Space(30),30);
                      /* _note := _note + Left(LRTrim(personbo->SESSO)+" ",1) + Space(34) */
                      _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SESSO"))+" ",1)+CPLib.Space(34);
                      /* FileLibMit.WriteLine(fhand,_note) */
                      FileLibMit.WriteLine(fhand,_note);
                      /* nTotRec := nTotRec + 1 */
                      nTotRec = CPLib.Round(nTotRec+1,0);
                      /* nNumRec := nNumRec + 1 */
                      nNumRec = CPLib.Round(nNumRec+1,0);
                      Cursor_personbo.Next();
                    }
                    m_cConnectivityError = Cursor_personbo.ErrorMessage();
                    Cursor_personbo.Close();
                    // * --- End Select
                  } // End If
                } // End If
                Cursor_intestbo.Next();
              }
              m_cConnectivityError = Cursor_intestbo.ErrorMessage();
              Cursor_intestbo.Close();
              // * --- End Select
            } // End If
            // * --- Select from clientifrz
            m_cServer = m_Ctx.GetServer("clientifrz");
            m_cPhName = m_Ctx.GetPhName("clientifrz");
            if (Cursor_clientifrz!=null)
              Cursor_clientifrz.Close();
            Cursor_clientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("clientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_clientifrz.Eof())) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_clientifrz.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
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
                /* _note := _note + Left(LRTrim(DateToChar(qbe_frad_chkdiana->DATAOPE))+Space(8),8) + qbe_frad_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_frad_chkdiana->STATOREG) */
                _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_frad_chkdiana.GetDate("DATAOPE")))+CPLib.Space(8),8)+Cursor_qbe_frad_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_frad_chkdiana.GetString("STATOREG"));
                /* _note := _note + Left(LRTrim(clientifrz->CODSOG)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_clientifrz.GetString("CODSOG"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
                /* _note := _note + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
                /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
                /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                } // End If
                /* If not(Empty(personbo->NASSTATO)) */
                if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                  /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                } else { // Else
                  /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                } // End If
                /* _note := _note + Left(LRTrim(personbo->SETTSINT)+Space(3),3) + Left(LRTrim(qbe_frad_chkdiana->RAPPORTO)+Space(25),25) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("RAPPORTO"))+CPLib.Space(25),25);
                /* _note := _note + Left(LRTrim(qbe_frad_chkdiana->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                } // End If
                /* _note := _note + Left(LRTrim(personbo->AUTRILASC)+Space(30),30) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("AUTRILASC"))+CPLib.Space(30),30);
                /* _note := _note + Left(LRTrim(personbo->SESSO)+" ",1) + Space(34) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SESSO"))+" ",1)+CPLib.Space(34);
                /* FileLibMit.WriteLine(fhand,_note) */
                FileLibMit.WriteLine(fhand,_note);
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
              Cursor_clientifrz.Next();
            }
            m_cConnectivityError = Cursor_clientifrz.ErrorMessage();
            Cursor_clientifrz.Close();
            // * --- End Select
            /* If not(Empty(qbe_frad_chkdiana->CONNESOPER)) and qbe_frad_chkdiana->CONNESOPER <> _codrif */
            if ( ! (CPLib.Empty(Cursor_qbe_frad_chkdiana.GetString("CONNESOPER"))) && CPLib.ne(Cursor_qbe_frad_chkdiana.GetString("CONNESOPER"),_codrif)) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana.GetString("CONNESOPER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                /* _note := w_tipinter + w_codinter+'4' */
                _note = w_tipinter+w_codinter+"4";
                /* _note := _note + DateToChar(qbe_frad_chkdiana->DATAOPE) + qbe_frad_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_frad_chkdiana->STATOREG) */
                _note = _note+CPLib.DateToChar(Cursor_qbe_frad_chkdiana.GetDate("DATAOPE"))+Cursor_qbe_frad_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_frad_chkdiana.GetString("STATOREG"));
                /* _note := _note + Left(LRTrim(qbe_frad_chkdiana->CONNESOPER)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("CONNESOPER"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
                /* _note := _note + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
                /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
                /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                } // End If
                /* If not(Empty(personbo->NASSTATO)) */
                if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                  /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Space(35) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Space(35);
                } else { // Else
                  /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Space(35) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Space(35);
                } // End If
                /* _note := _note + Left(LRTrim(qbe_frad_chkdiana->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                } // End If
                /* _note := _note + personbo->AUTRILASC + personbo->SESSO + Space(34) */
                _note = _note+Cursor_personbo.GetString("AUTRILASC")+Cursor_personbo.GetString("SESSO")+CPLib.Space(34);
                /* FileLibMit.WriteLine(fhand,_note) */
                FileLibMit.WriteLine(fhand,_note);
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
            } // End If
            // * --- Select from sogopefbo
            m_cServer = m_Ctx.GetServer("sogopefbo");
            m_cPhName = m_Ctx.GetPhName("sogopefbo");
            if (Cursor_sogopefbo!=null)
              Cursor_sogopefbo.Close();
            Cursor_sogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("sogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_sogopefbo.Eof())) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_sogopefbo.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                /* _note := w_tipinter + w_codinter+'4' */
                _note = w_tipinter+w_codinter+"4";
                /* _note := _note + DateToChar(qbe_frad_chkdiana->DATAOPE) + qbe_frad_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_frad_chkdiana->STATOREG) */
                _note = _note+CPLib.DateToChar(Cursor_qbe_frad_chkdiana.GetDate("DATAOPE"))+Cursor_qbe_frad_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_frad_chkdiana.GetString("STATOREG"));
                /* _note := _note + Left(LRTrim(sogopefbo->CODSOG)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_sogopefbo.GetString("CODSOG"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
                /* _note := _note + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
                /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
                /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                } // End If
                /* If not(Empty(personbo->NASSTATO)) */
                if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                  /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Space(35) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Space(35);
                } else { // Else
                  /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Space(35) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Space(35);
                } // End If
                /* _note := _note + Left(LRTrim(qbe_frad_chkdiana->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                } // End If
                /* _note := _note + personbo->AUTRILASC + personbo->SESSO + Space(34) */
                _note = _note+Cursor_personbo.GetString("AUTRILASC")+Cursor_personbo.GetString("SESSO")+CPLib.Space(34);
                /* FileLibMit.WriteLine(fhand,_note) */
                FileLibMit.WriteLine(fhand,_note);
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
              Cursor_sogopefbo.Next();
            }
            m_cConnectivityError = Cursor_sogopefbo.ErrorMessage();
            Cursor_sogopefbo.Close();
            // * --- End Select
            /* If not(Empty(qbe_frad_chkdiana->CONNESBEN)) or not(Empty(qbe_frad_chkdiana->C_RAG)) */
            if ( ! (CPLib.Empty(Cursor_qbe_frad_chkdiana.GetString("CONNESBEN"))) ||  ! (CPLib.Empty(Cursor_qbe_frad_chkdiana.GetString("C_RAG")))) {
              /* If not(Empty(qbe_frad_chkdiana->CONNESBEN)) */
              if ( ! (CPLib.Empty(Cursor_qbe_frad_chkdiana.GetString("CONNESBEN")))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana.GetString("CONNESBEN"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* _note := w_tipinter + w_codinter+'5' */
                  _note = w_tipinter+w_codinter+"5";
                  /* _note := _note + DateToChar(qbe_frad_chkdiana->DATAOPE) + qbe_frad_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_frad_chkdiana->STATOREG) */
                  _note = _note+CPLib.DateToChar(Cursor_qbe_frad_chkdiana.GetDate("DATAOPE"))+Cursor_qbe_frad_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_frad_chkdiana.GetString("STATOREG"));
                  /* _note := _note + Left(LRTrim(qbe_frad_chkdiana->CONNESBEN)+Space(16),16) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("CONNESBEN"))+CPLib.Space(16),16);
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana->C_RAG))),Left(LRTrim(qbe_frad_chkdiana->C_RAG)+Space(70),70),Left(LRTrim(personbo->RAGSOC)+Space(70),70)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_RAG"))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana->C_STA))),Left(LRTrim(qbe_frad_chkdiana->C_STA)+Space(3),3),Left(LRTrim(personbo->PAESE)+Space(3),3)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana->C_CAB))),Left(LRTrim(qbe_frad_chkdiana->C_CAB)+Space(6),6),Left(LRTrim(personbo->CODCAB)+Space(6),6)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana->C_CTA))),Left(LRTrim(qbe_frad_chkdiana->C_CTA)+Space(30),30),Left(LRTrim(personbo->DESCCIT)+Space(30),30)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_CTA"))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana->C_PRV))),Left(LRTrim(qbe_frad_chkdiana->C_PRV)+Space(2),2),Left(LRTrim(personbo->PROVINCIA)+Space(2),2)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana->C_IND))),Left(LRTrim(qbe_frad_chkdiana->C_IND)+Space(35),35),Left(LRTrim(personbo->DOMICILIO)+Space(35),35)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_IND"))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana->C_CAP))),Left(LRTrim(qbe_frad_chkdiana->C_CAP)+Space(5),5),Left(LRTrim(personbo->CAP)+Space(5),5)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5));
                  /* _note := _note + Space(63) */
                  _note = _note+CPLib.Space(63);
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana->C_RAPPORTO))),Left(LRTrim(qbe_frad_chkdiana->C_RAPPORTO)+Space(25),25),Left(LRTrim(qbe_frad_chkdiana->RAPPORTBEN)+Space(25),25)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_RAPPORTO"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_RAPPORTO"))+CPLib.Space(25),25):CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("RAPPORTBEN"))+CPLib.Space(25),25));
                  /* _note := _note + Space(91) */
                  _note = _note+CPLib.Space(91);
                  /* FileLibMit.WriteLine(fhand,_note) */
                  FileLibMit.WriteLine(fhand,_note);
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
                /* ElseIf not(Empty(qbe_frad_chkdiana->C_RAG)) */
              } else if ( ! (CPLib.Empty(Cursor_qbe_frad_chkdiana.GetString("C_RAG")))) {
                /* _note := w_tipinter + w_codinter+'5' */
                _note = w_tipinter+w_codinter+"5";
                /* _note := _note + DateToChar(qbe_frad_chkdiana->DATAOPE) + qbe_frad_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_frad_chkdiana->STATOREG) */
                _note = _note+CPLib.DateToChar(Cursor_qbe_frad_chkdiana.GetDate("DATAOPE"))+Cursor_qbe_frad_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_frad_chkdiana.GetString("STATOREG"));
                /* _note := _note + Left(LRTrim(qbe_frad_chkdiana->CONNESBEN)+Space(16),16) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("CONNESBEN"))+CPLib.Space(16),16);
                /* _note := _note +Left(LRTrim(qbe_frad_chkdiana->C_RAG)+Space(70),70) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_RAG"))+CPLib.Space(70),70);
                /* _note := _note + Left(LRTrim(qbe_frad_chkdiana->C_STA)+Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_STA"))+CPLib.Space(3),3);
                /* _note := _note +Left(LRTrim(qbe_frad_chkdiana->C_CAB)+Space(6),6) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_CAB"))+CPLib.Space(6),6);
                /* _note := _note +Left(LRTrim(qbe_frad_chkdiana->C_CTA)+Space(30),30) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_CTA"))+CPLib.Space(30),30);
                /* _note := _note + Left(LRTrim(qbe_frad_chkdiana->C_PRV)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_PRV"))+CPLib.Space(2),2);
                /* _note := _note + Left(LRTrim(qbe_frad_chkdiana->C_IND)+Space(35),35) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_IND"))+CPLib.Space(35),35);
                /* _note := _note + Left(LRTrim(qbe_frad_chkdiana->C_CAP)+Space(5),5) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_CAP"))+CPLib.Space(5),5);
                /* _note := _note + Space(63) */
                _note = _note+CPLib.Space(63);
                /* _note := _note + Left(LRTrim(qbe_frad_chkdiana->C_RAPPORTO)+Space(25),25) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                /* _note := _note + Space(91) */
                _note = _note+CPLib.Space(91);
                /* FileLibMit.WriteLine(fhand,_note) */
                FileLibMit.WriteLine(fhand,_note);
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
              } // End If
            } // End If
            // * --- Select from beneficfrz
            m_cServer = m_Ctx.GetServer("beneficfrz");
            m_cPhName = m_Ctx.GetPhName("beneficfrz");
            if (Cursor_beneficfrz!=null)
              Cursor_beneficfrz.Close();
            Cursor_beneficfrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("beneficfrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_beneficfrz.Eof())) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_beneficfrz.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                /* _note := w_tipinter + w_codinter+'5' */
                _note = w_tipinter+w_codinter+"5";
                /* _note := _note + DateToChar(qbe_frad_chkdiana->DATAOPE) + qbe_frad_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_frad_chkdiana->STATOREG) */
                _note = _note+CPLib.DateToChar(Cursor_qbe_frad_chkdiana.GetDate("DATAOPE"))+Cursor_qbe_frad_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_frad_chkdiana.GetString("STATOREG"));
                /* _note := _note + Left(LRTrim(beneficfrz->CODSOG)+Space(16),16) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("CODSOG"))+CPLib.Space(16),16);
                /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_RAG))),Left(LRTrim(beneficfrz->C_RAG)+Space(70),70),Left(LRTrim(personbo->RAGSOC)+Space(70),70)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_RAG"))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70));
                /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_STA))),Left(LRTrim(beneficfrz->C_STA)+Space(3),3),Left(LRTrim(personbo->PAESE)+Space(3),3)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3));
                /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_CAB))),Left(LRTrim(beneficfrz->C_CAB)+Space(6),6),Left(LRTrim(personbo->CODCAB)+Space(6),6)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6));
                /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_CTA))),Left(LRTrim(beneficfrz->C_CTA)+Space(30),30),Left(LRTrim(personbo->DESCCIT)+Space(30),30)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_CTA"))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30));
                /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_PRV))),Left(LRTrim(beneficfrz->C_PRV)+Space(2),2),Left(LRTrim(personbo->PROVINCIA)+Space(2),2)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_IND))),Left(LRTrim(beneficfrz->C_IND)+Space(35),35),Left(LRTrim(personbo->DOMICILIO)+Space(35),35)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_IND"))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35));
                /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_CAP))),Left(LRTrim(beneficfrz->C_CAP)+Space(5),5),Left(LRTrim(personbo->CAP)+Space(5),5)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5));
                /* _note := _note + Space(63) */
                _note = _note+CPLib.Space(63);
                /* _note := _note +Left(LRTrim(beneficfrz->C_RAPPORTO)+Space(25),25) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                /* _note := _note + Space(91) */
                _note = _note+CPLib.Space(91);
                /* FileLibMit.WriteLine(fhand,_note) */
                FileLibMit.WriteLine(fhand,_note);
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
              Cursor_beneficfrz.Next();
            }
            m_cConnectivityError = Cursor_beneficfrz.ErrorMessage();
            Cursor_beneficfrz.Close();
            // * --- End Select
            /* If not(Empty(qbe_frad_chkdiana->CONNALTRO)) */
            if ( ! (CPLib.Empty(Cursor_qbe_frad_chkdiana.GetString("CONNALTRO")))) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana.GetString("CONNALTRO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                /* _note := w_tipinter + w_codinter+'6' */
                _note = w_tipinter+w_codinter+"6";
                /* _note := _note + DateToChar(qbe_frad_chkdiana->DATAOPE) + qbe_frad_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_frad_chkdiana->STATOREG) */
                _note = _note+CPLib.DateToChar(Cursor_qbe_frad_chkdiana.GetDate("DATAOPE"))+Cursor_qbe_frad_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_frad_chkdiana.GetString("STATOREG"));
                /* _note := _note + Left(LRTrim(qbe_frad_chkdiana->CONNALTRO)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("CONNALTRO"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
                /* _note := _note + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
                /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
                /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                } // End If
                /* If not(Empty(personbo->NASSTATO)) */
                if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                  /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Space(35) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Space(35);
                } else { // Else
                  /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Space(35) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Space(35);
                } // End If
                /* _note := _note + Left(LRTrim(qbe_frad_chkdiana->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                } // End If
                /* _note := _note + personbo->AUTRILASC + personbo->SESSO + Space(34) */
                _note = _note+Cursor_personbo.GetString("AUTRILASC")+Cursor_personbo.GetString("SESSO")+CPLib.Space(34);
                /* FileLibMit.WriteLine(fhand,_note) */
                FileLibMit.WriteLine(fhand,_note);
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
            } // End If
            // * --- Select from terzistifrz
            m_cServer = m_Ctx.GetServer("terzistifrz");
            m_cPhName = m_Ctx.GetPhName("terzistifrz");
            if (Cursor_terzistifrz!=null)
              Cursor_terzistifrz.Close();
            Cursor_terzistifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("terzistifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_terzistifrz.Eof())) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_terzistifrz.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                /* _note := w_tipinter + w_codinter+'6' */
                _note = w_tipinter+w_codinter+"6";
                /* _note := _note + DateToChar(qbe_frad_chkdiana->DATAOPE) + qbe_frad_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_frad_chkdiana->STATOREG) */
                _note = _note+CPLib.DateToChar(Cursor_qbe_frad_chkdiana.GetDate("DATAOPE"))+Cursor_qbe_frad_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_frad_chkdiana.GetString("STATOREG"));
                /* _note := _note + Left(LRTrim(terzistifrz->CODSOG)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_terzistifrz.GetString("CODSOG"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
                /* _note := _note + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
                /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
                /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                } // End If
                /* If not(Empty(personbo->NASSTATO)) */
                if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                  /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Space(35) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Space(35);
                } else { // Else
                  /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Space(35) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Space(35);
                } // End If
                /* _note := _note + Left(LRTrim(qbe_frad_chkdiana->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                } // End If
                /* _note := _note + personbo->AUTRILASC + personbo->SESSO + Space(34) */
                _note = _note+Cursor_personbo.GetString("AUTRILASC")+Cursor_personbo.GetString("SESSO")+CPLib.Space(34);
                /* FileLibMit.WriteLine(fhand,_note) */
                FileLibMit.WriteLine(fhand,_note);
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
              Cursor_terzistifrz.Next();
            }
            m_cConnectivityError = Cursor_terzistifrz.ErrorMessage();
            Cursor_terzistifrz.Close();
            // * --- End Select
            /* gNumRec := nTotRec // N° Record DIANA */
            gNumRec = CPLib.Round(nTotRec,0);
            m_Ctx.SetGlobalNumber("gNumRec",gNumRec);
            /* gNumReg := nTotReg // N° Registrazioni DIANA */
            gNumReg = CPLib.Round(nTotReg,0);
            m_Ctx.SetGlobalNumber("gNumReg",gNumReg);
            Cursor_qbe_frad_chkdiana.Next();
          }
          m_cConnectivityError = Cursor_qbe_frad_chkdiana.ErrorMessage();
          Cursor_qbe_frad_chkdiana.Close();
          // * --- End Select
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* _contacilci := _contacilci+1 */
          _contacilci = CPLib.Round(_contacilci+1,0);
        } // End While
      } else { // Else
        /* Cicla sulle informazioni sui rapporti */
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
        // * --- Select from qbe_frap_chkdiana_limits
        SPBridge.HMCaller _h000005D9;
        _h000005D9 = new SPBridge.HMCaller();
        _h000005D9.Set("m_cVQRList",m_cVQRList);
        _h000005D9.Set("cdadata",w_cdadata);
        _h000005D9.Set("c_adata",w_c_adata);
        _h000005D9.Set("codage",w_codage);
        if (Cursor_qbe_frap_chkdiana_limits!=null)
          Cursor_qbe_frap_chkdiana_limits.Close();
        Cursor_qbe_frap_chkdiana_limits = new VQRHolder("qbe_frap_chkdiana_limits",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000005D9,true).GetResultSet(m_Ctx);
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
          /* _nomefile := 'campione.txt.'+Right('0000'+LRTrim(Str(_conta,4,0)),4) */
          _nomefile = "campione.txt."+CPLib.Right("0000"+CPLib.LRTrim(CPLib.Str(_conta,4,0)),4);
          /* fhand := FileLibMit.OpenWrite('./flussi/'+LRTrim(gAzienda)+"/"+LRTrim(_nomefile)) */
          fhand = FileLibMit.OpenWrite("./flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_nomefile));
          /* Cicla sulle operazioni */
          // * --- Select from qbe_frap_chkdiana
          SPBridge.HMCaller _h000005EB;
          _h000005EB = new SPBridge.HMCaller();
          _h000005EB.Set("m_cVQRList",m_cVQRList);
          _h000005EB.Set("cdadata",w_cdadata);
          _h000005EB.Set("c_adata",w_c_adata);
          _h000005EB.Set("codage",w_codage);
          _h000005EB.Set("_bottom",_bottom);
          _h000005EB.Set("_top",_top);
          if (Cursor_qbe_frap_chkdiana!=null)
            Cursor_qbe_frap_chkdiana.Close();
          Cursor_qbe_frap_chkdiana = new VQRHolder("qbe_frap_chkdiana",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000005EB,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_frap_chkdiana.Eof())) {
            /* _ctotale := _ctotale + 1 */
            _ctotale = CPLib.Round(_ctotale+1,0);
            /* gMsgImp := 'Elaborazione Operazione N.: '+LRTrim(Str(_ctotale,15,0)) // Messaggio Import */
            gMsgImp = "Elaborazione Operazione N.: "+CPLib.LRTrim(CPLib.Str(_ctotale,15,0));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* _note := w_tipinter + w_codinter + '1' */
            _note = w_tipinter+w_codinter+"1";
            /* If Empty(LRTrim(qbe_frap_chkdiana->FLAGRAP2)) */
            if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("FLAGRAP2")))) {
              /* _note := _note + DateToChar(qbe_frap_chkdiana->DATAOPE) + qbe_frap_chkdiana->NUMPROG + 'S' */
              _note = _note+CPLib.DateToChar(Cursor_qbe_frap_chkdiana.GetDate("DATAOPE"))+Cursor_qbe_frap_chkdiana.GetString("NUMPROG")+"S";
            } else { // Else
              /* _note := _note + qbe_frap_chkdiana->IDEREG */
              _note = _note+Cursor_qbe_frap_chkdiana.GetString("IDEREG");
            } // End If
            /* _flagrap := '' */
            _flagrap = "";
            /* If not(Empty(qbe_frap_chkdiana->FLAGRAP)) */
            if ( ! (CPLib.Empty(Cursor_qbe_frap_chkdiana.GetString("FLAGRAP")))) {
              /* _flagrap := qbe_frap_chkdiana->FLAGRAP */
              _flagrap = Cursor_qbe_frap_chkdiana.GetString("FLAGRAP");
            } else { // Else
              // * --- Select from knarapbo
              m_cServer = m_Ctx.GetServer("knarapbo");
              m_cPhName = m_Ctx.GetPhName("knarapbo");
              if (Cursor_knarapbo!=null)
                Cursor_knarapbo.Close();
              Cursor_knarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_frap_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("knarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_knarapbo.Eof())) {
                /* If knarapbo->TIPORAP='P' */
                if (CPLib.eqr(Cursor_knarapbo.GetString("TIPORAP"),"P")) {
                  // * --- Select from xnarapbo
                  m_cServer = m_Ctx.GetServer("xnarapbo");
                  m_cPhName = m_Ctx.GetPhName("xnarapbo");
                  if (Cursor_xnarapbo!=null)
                    Cursor_xnarapbo.Close();
                  Cursor_xnarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select TIPORAP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_frap_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xnarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_xnarapbo.Eof())) {
                    /* _flagrap := xnarapbo->TIPORAP */
                    _flagrap = Cursor_xnarapbo.GetString("TIPORAP");
                    Cursor_xnarapbo.Next();
                  }
                  m_cConnectivityError = Cursor_xnarapbo.ErrorMessage();
                  Cursor_xnarapbo.Close();
                  // * --- End Select
                } else { // Else
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
                } // End If
                Cursor_knarapbo.Next();
              }
              m_cConnectivityError = Cursor_knarapbo.ErrorMessage();
              Cursor_knarapbo.Close();
              // * --- End Select
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
                  Error l_oErrorFault = new Error("Read on intermbo into routine arrt_chkdiana_mt returns two or more records. This item should return only a record.");
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
                    Error l_oErrorFault = new Error("Read on anadip into routine arrt_chkdiana_mt returns two or more records. This item should return only a record.");
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
                /* _note := _note + qbe_frad_chkdiana->CODDIPE + Left(LRTrim(anadip->CAB)+Space(6),6) + Left(LRTrim(anadip->DESCCIT)+Space(30),30) + Left(LRTrim(anadip->PROVINCIA)+Space(2),2) */
                _note = _note+Cursor_qbe_frad_chkdiana.GetString("CODDIPE")+CPLib.Left(CPLib.LRTrim(Cursor_anadip.GetString("CAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_anadip.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_anadip.GetString("PROVINCIA"))+CPLib.Space(2),2);
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
            /* _note := _note + Left(LRTrim(qbe_frap_chkdiana->TIPOINT2)+Space(2),2) + Left(LRTrim(qbe_frap_chkdiana->CODFISCICP)+Space(11),11) + Left(LRTrim(qbe_frap_chkdiana->PAESE)+Space(3),3) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("TIPOINT2"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("CODFISCICP"))+CPLib.Space(11),11)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("PAESE"))+CPLib.Space(3),3);
            /* _note := _note + Left(LRTrim(qbe_frap_chkdiana->CODCAB2)+Space(6),6) + Left(LRTrim(qbe_frap_chkdiana->DESC2)+Space(30),30) + Left(LRTrim(qbe_frap_chkdiana->PROV2)+Space(2),2) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("CODCAB2"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("DESC2"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("PROV2"))+CPLib.Space(2),2);
            /* _note := _note + Left(LRTrim(qbe_frap_chkdiana->DESCINTER)+Space(50),50) + Left(LRTrim(qbe_frap_chkdiana->RAPPORTO)+Space(25),25) + Left(LRTrim(_flagrap)+" ",1) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("DESCINTER"))+CPLib.Space(50),50)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("RAPPORTO"))+CPLib.Space(25),25)+CPLib.Left(CPLib.LRTrim(_flagrap)+" ",1);
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
            /* _note := _note + Left(LRTrim(qbe_frap_chkdiana->OPERAZMOD)+Space(20),20) + Left(LRTrim(qbe_frap_chkdiana->FLAGLIRE)+" ",1) + Left(LRTrim(qbe_frap_chkdiana->VALUTA)+Space(3),3) + Left(LRTrim(qbe_frap_chkdiana->SEGNO)+" ",1) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("OPERAZMOD"))+CPLib.Space(20),20)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("FLAGLIRE"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("VALUTA"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("SEGNO"))+" ",1);
            /* _note := _note +  Right('000000000000000'+LRTrim(Str(qbe_frap_chkdiana->TOTLIRE,15,0)),15) + Right('000000000000000'+LRTrim(Str(qbe_frap_chkdiana->TOTCONT,15,0)),15) + Space(69) */
            _note = _note+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_frap_chkdiana.GetDouble("TOTLIRE"),15,0)),15)+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_frap_chkdiana.GetDouble("TOTCONT"),15,0)),15)+CPLib.Space(69);
            /* FileLibMit.WriteLine(fhand,_note) */
            FileLibMit.WriteLine(fhand,_note);
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nTotReg := nTotReg + 1 */
            nTotReg = CPLib.Round(nTotReg+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
            /* If not(Empty(qbe_frap_chkdiana->CONNESCLI)) and Empty(LRTrim(qbe_frap_chkdiana->RAPPORTO)) */
            if ( ! (CPLib.Empty(Cursor_qbe_frap_chkdiana.GetString("CONNESCLI"))) && CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("RAPPORTO")))) {
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
                  /* _note := _note + Left(LRTrim(DateToChar(qbe_frap_chkdiana->DATAOPE))+Space(8),8) + qbe_frap_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_frap_chkdiana->STATOREG) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_frap_chkdiana.GetDate("DATAOPE")))+CPLib.Space(8),8)+Cursor_qbe_frap_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_frap_chkdiana.GetString("STATOREG"));
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
                    /* _note := _note + Left(LRTrim(kersonbo->NASSTATO)+Space(30),30) + Left(LRTrim(kersonbo->SOTGRUP)+Space(3),3) + Left(LRTrim(kersonbo->RAMOGRUP)+Space(3),3) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(kersonbo->NASCOMUN)+Space(30),30) + Left(LRTrim(kersonbo->SOTGRUP)+Space(3),3) + Left(LRTrim(kersonbo->RAMOGRUP)+Space(3),3) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                  } // End If
                  /* _note := _note + Left(LRTrim(kersonbo->SETTSINT)+Space(3),3) + Left(LRTrim(qbe_frap_chkdiana->RAPPORTO)+Space(25),25) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("RAPPORTO"))+CPLib.Space(25),25);
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
                  /* FileLibMit.WriteLine(fhand,_note) */
                  FileLibMit.WriteLine(fhand,_note);
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
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_frap_chkdiana.GetString("CONNESCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
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
                  /* _note := _note + Left(LRTrim(DateToChar(qbe_frap_chkdiana->DATAOPE))+Space(8),8) + qbe_frap_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_frap_chkdiana->STATOREG) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_frap_chkdiana.GetDate("DATAOPE")))+CPLib.Space(8),8)+Cursor_qbe_frap_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_frap_chkdiana.GetString("STATOREG"));
                  /* _note := _note + Left(LRTrim(qbe_frap_chkdiana->CONNESCLI)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("CONNESCLI"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
                  /* _note := _note + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                  /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
                  /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
                  /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
                  if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                    /* _note := _note + Space(8) */
                    _note = _note+CPLib.Space(8);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                  } // End If
                  /* If not(Empty(personbo->NASSTATO)) */
                  if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                    /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                  } // End If
                  /* _note := _note + Left(LRTrim(personbo->SETTSINT)+Space(3),3) + Left(LRTrim(qbe_frap_chkdiana->RAPPORTO)+Space(25),25) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("RAPPORTO"))+CPLib.Space(25),25);
                  /* _note := _note + Left(LRTrim(qbe_frap_chkdiana->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                  /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
                  if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                    /* _note := _note + Space(8) */
                    _note = _note+CPLib.Space(8);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                    _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                  } // End If
                  /* _note := _note + Left(LRTrim(personbo->AUTRILASC)+Space(30),30) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("AUTRILASC"))+CPLib.Space(30),30);
                  /* _note := _note + Left(LRTrim(personbo->SESSO)+" ",1) + Space(34) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SESSO"))+" ",1)+CPLib.Space(34);
                  /* FileLibMit.WriteLine(fhand,_note) */
                  FileLibMit.WriteLine(fhand,_note);
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } // End If
            } else { // Else
              // * --- Select from intestbo
              m_cServer = m_Ctx.GetServer("intestbo");
              m_cPhName = m_Ctx.GetPhName("intestbo");
              if (Cursor_intestbo!=null)
                Cursor_intestbo.Close();
              Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_frap_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_intestbo.Eof())) {
                /* If (qbe_frap_chkdiana->RAPPORTO+'P') = (intestbo->RAPPORTO+intestbo->TIPOPERS) */
                if (CPLib.eqr((Cursor_qbe_frap_chkdiana.GetString("RAPPORTO")+"P"),(Cursor_intestbo.GetString("RAPPORTO")+Cursor_intestbo.GetString("TIPOPERS")))) {
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
                    // * --- Select from personbo
                    m_cServer = m_Ctx.GetServer("personbo");
                    m_cPhName = m_Ctx.GetPhName("personbo");
                    if (Cursor_personbo!=null)
                      Cursor_personbo.Close();
                    Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_personbo.Eof())) {
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
                      /* _note := _note + Left(LRTrim(DateToChar(qbe_frap_chkdiana->DATAOPE))+Space(8),8) + qbe_frap_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_frap_chkdiana->STATOREG) */
                      _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_frap_chkdiana.GetDate("DATAOPE")))+CPLib.Space(8),8)+Cursor_qbe_frap_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_frap_chkdiana.GetString("STATOREG"));
                      /* _note := _note + Left(LRTrim(intestbo->CODINTER)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
                      _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_intestbo.GetString("CODINTER"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
                      /* _note := _note + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
                      _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                      /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
                      _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
                      /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
                      _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
                      /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
                      if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                        /* _note := _note + Space(8) */
                        _note = _note+CPLib.Space(8);
                      } else { // Else
                        /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                        _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                      } // End If
                      /* If not(Empty(personbo->NASSTATO)) */
                      if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                        /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                      } else { // Else
                        /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                      } // End If
                      /* _note := _note + Left(LRTrim(personbo->SETTSINT)+Space(3),3) + Left(LRTrim(qbe_frap_chkdiana->RAPPORTO)+Space(25),25) */
                      _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("RAPPORTO"))+CPLib.Space(25),25);
                      /* _note := _note + Left(LRTrim(qbe_frap_chkdiana->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
                      _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                      /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
                      if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                        /* _note := _note + Space(8) */
                        _note = _note+CPLib.Space(8);
                      } else { // Else
                        /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                        _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                      } // End If
                      /* _note := _note + Left(LRTrim(personbo->AUTRILASC)+Space(30),30) */
                      _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("AUTRILASC"))+CPLib.Space(30),30);
                      /* _note := _note + Left(LRTrim(personbo->SESSO)+" ",1) + Space(34) */
                      _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SESSO"))+" ",1)+CPLib.Space(34);
                      /* FileLibMit.WriteLine(fhand,_note) */
                      FileLibMit.WriteLine(fhand,_note);
                      /* nTotRec := nTotRec + 1 */
                      nTotRec = CPLib.Round(nTotRec+1,0);
                      /* nNumRec := nNumRec + 1 */
                      nNumRec = CPLib.Round(nNumRec+1,0);
                      Cursor_personbo.Next();
                    }
                    m_cConnectivityError = Cursor_personbo.ErrorMessage();
                    Cursor_personbo.Close();
                    // * --- End Select
                  } // End If
                } // End If
                Cursor_intestbo.Next();
              }
              m_cConnectivityError = Cursor_intestbo.ErrorMessage();
              Cursor_intestbo.Close();
              // * --- End Select
            } // End If
            // * --- Select from xlientifrz
            m_cServer = m_Ctx.GetServer("xlientifrz");
            m_cPhName = m_Ctx.GetPhName("xlientifrz");
            if (Cursor_xlientifrz!=null)
              Cursor_xlientifrz.Close();
            Cursor_xlientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_frap_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xlientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xlientifrz.Eof())) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xlientifrz.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
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
                /* _note := _note + Left(LRTrim(DateToChar(qbe_frap_chkdiana->DATAOPE))+Space(8),8) + qbe_frap_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_frap_chkdiana->STATOREG) */
                _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_frap_chkdiana.GetDate("DATAOPE")))+CPLib.Space(8),8)+Cursor_qbe_frap_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_frap_chkdiana.GetString("STATOREG"));
                /* _note := _note + Left(LRTrim(xlientifrz->CODSOG)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xlientifrz.GetString("CODSOG"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
                /* _note := _note + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
                /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
                /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                } // End If
                /* If not(Empty(personbo->NASSTATO)) */
                if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                  /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                } else { // Else
                  /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                } // End If
                /* _note := _note + Left(LRTrim(personbo->SETTSINT)+Space(3),3) + Left(LRTrim(qbe_frap_chkdiana->RAPPORTO)+Space(25),25) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("RAPPORTO"))+CPLib.Space(25),25);
                /* _note := _note + Left(LRTrim(qbe_frap_chkdiana->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                } // End If
                /* _note := _note + Left(LRTrim(personbo->AUTRILASC)+Space(30),30) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("AUTRILASC"))+CPLib.Space(30),30);
                /* _note := _note + Left(LRTrim(personbo->SESSO)+" ",1) + Space(34) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SESSO"))+" ",1)+CPLib.Space(34);
                /* FileLibMit.WriteLine(fhand,_note) */
                FileLibMit.WriteLine(fhand,_note);
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
              Cursor_xlientifrz.Next();
            }
            m_cConnectivityError = Cursor_xlientifrz.ErrorMessage();
            Cursor_xlientifrz.Close();
            // * --- End Select
            /* If not(Empty(qbe_frap_chkdiana->CONNESOPER)) and qbe_frap_chkdiana->CONNESOPER <> _codrif */
            if ( ! (CPLib.Empty(Cursor_qbe_frap_chkdiana.GetString("CONNESOPER"))) && CPLib.ne(Cursor_qbe_frap_chkdiana.GetString("CONNESOPER"),_codrif)) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_frap_chkdiana.GetString("CONNESOPER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                /* _note := w_tipinter + w_codinter+'4' */
                _note = w_tipinter+w_codinter+"4";
                /* _note := _note + DateToChar(qbe_frap_chkdiana->DATAOPE) + qbe_frap_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_frap_chkdiana->STATOREG) */
                _note = _note+CPLib.DateToChar(Cursor_qbe_frap_chkdiana.GetDate("DATAOPE"))+Cursor_qbe_frap_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_frap_chkdiana.GetString("STATOREG"));
                /* _note := _note + Left(LRTrim(qbe_frap_chkdiana->CONNESOPER)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("CONNESOPER"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
                /* _note := _note + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
                /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
                /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                } // End If
                /* If not(Empty(personbo->NASSTATO)) */
                if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                  /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Space(35) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Space(35);
                } else { // Else
                  /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Space(35) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Space(35);
                } // End If
                /* _note := _note + Left(LRTrim(qbe_frap_chkdiana->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                } // End If
                /* _note := _note + personbo->AUTRILASC + personbo->SESSO + Space(34) */
                _note = _note+Cursor_personbo.GetString("AUTRILASC")+Cursor_personbo.GetString("SESSO")+CPLib.Space(34);
                /* FileLibMit.WriteLine(fhand,_note) */
                FileLibMit.WriteLine(fhand,_note);
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
            } // End If
            // * --- Select from xogopefbo
            m_cServer = m_Ctx.GetServer("xogopefbo");
            m_cPhName = m_Ctx.GetPhName("xogopefbo");
            if (Cursor_xogopefbo!=null)
              Cursor_xogopefbo.Close();
            Cursor_xogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_frap_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xogopefbo.Eof())) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xogopefbo.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                /* _note := w_tipinter + w_codinter+'4' */
                _note = w_tipinter+w_codinter+"4";
                /* _note := _note + DateToChar(qbe_frap_chkdiana->DATAOPE) + qbe_frap_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_frap_chkdiana->STATOREG) */
                _note = _note+CPLib.DateToChar(Cursor_qbe_frap_chkdiana.GetDate("DATAOPE"))+Cursor_qbe_frap_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_frap_chkdiana.GetString("STATOREG"));
                /* _note := _note + Left(LRTrim(xogopefbo->CODSOG)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xogopefbo.GetString("CODSOG"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
                /* _note := _note + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
                /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
                /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                } // End If
                /* If not(Empty(personbo->NASSTATO)) */
                if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                  /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Space(35) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Space(35);
                } else { // Else
                  /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Space(35) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Space(35);
                } // End If
                /* _note := _note + Left(LRTrim(qbe_frap_chkdiana->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                } // End If
                /* _note := _note + personbo->AUTRILASC + personbo->SESSO + Space(34) */
                _note = _note+Cursor_personbo.GetString("AUTRILASC")+Cursor_personbo.GetString("SESSO")+CPLib.Space(34);
                /* FileLibMit.WriteLine(fhand,_note) */
                FileLibMit.WriteLine(fhand,_note);
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
              Cursor_xogopefbo.Next();
            }
            m_cConnectivityError = Cursor_xogopefbo.ErrorMessage();
            Cursor_xogopefbo.Close();
            // * --- End Select
            /* If not(Empty(qbe_frap_chkdiana->CONNESBEN)) or not(Empty(qbe_frap_chkdiana->C_RAG)) */
            if ( ! (CPLib.Empty(Cursor_qbe_frap_chkdiana.GetString("CONNESBEN"))) ||  ! (CPLib.Empty(Cursor_qbe_frap_chkdiana.GetString("C_RAG")))) {
              /* If not(Empty(qbe_frap_chkdiana->CONNESBEN)) */
              if ( ! (CPLib.Empty(Cursor_qbe_frap_chkdiana.GetString("CONNESBEN")))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_frap_chkdiana.GetString("CONNESBEN"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* _note := w_tipinter + w_codinter+'5' */
                  _note = w_tipinter+w_codinter+"5";
                  /* _note := _note + DateToChar(qbe_frap_chkdiana->DATAOPE) + qbe_frap_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_frap_chkdiana->STATOREG) */
                  _note = _note+CPLib.DateToChar(Cursor_qbe_frap_chkdiana.GetDate("DATAOPE"))+Cursor_qbe_frap_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_frap_chkdiana.GetString("STATOREG"));
                  /* _note := _note + Left(LRTrim(qbe_frap_chkdiana->CONNESBEN)+Space(16),16) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("CONNESBEN"))+CPLib.Space(16),16);
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frap_chkdiana->C_RAG))),Left(LRTrim(qbe_frap_chkdiana->C_RAG)+Space(70),70),Left(LRTrim(personbo->RAGSOC)+Space(70),70)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_RAG"))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frap_chkdiana->C_STA))),Left(LRTrim(qbe_frap_chkdiana->C_STA)+Space(3),3),Left(LRTrim(personbo->PAESE)+Space(3),3)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frap_chkdiana->C_CAB))),Left(LRTrim(qbe_frap_chkdiana->C_CAB)+Space(6),6),Left(LRTrim(personbo->CODCAB)+Space(6),6)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frap_chkdiana->C_CTA))),Left(LRTrim(qbe_frap_chkdiana->C_CTA)+Space(30),30),Left(LRTrim(personbo->DESCCIT)+Space(30),30)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_CTA"))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frap_chkdiana->C_PRV))),Left(LRTrim(qbe_frap_chkdiana->C_PRV)+Space(2),2),Left(LRTrim(personbo->PROVINCIA)+Space(2),2)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frap_chkdiana->C_IND))),Left(LRTrim(qbe_frap_chkdiana->C_IND)+Space(35),35),Left(LRTrim(personbo->DOMICILIO)+Space(35),35)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_IND"))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frap_chkdiana->C_CAP))),Left(LRTrim(qbe_frap_chkdiana->C_CAP)+Space(5),5),Left(LRTrim(personbo->CAP)+Space(5),5)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5));
                  /* _note := _note + Space(63) */
                  _note = _note+CPLib.Space(63);
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_frap_chkdiana->C_RAPPORTO))),Left(LRTrim(qbe_frap_chkdiana->C_RAPPORTO)+Space(25),25),Left(LRTrim(qbe_frap_chkdiana->RAPPORTBEN)+Space(25),25)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_RAPPORTO"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_RAPPORTO"))+CPLib.Space(25),25):CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("RAPPORTBEN"))+CPLib.Space(25),25));
                  /* _note := _note + Space(91) */
                  _note = _note+CPLib.Space(91);
                  /* FileLibMit.WriteLine(fhand,_note) */
                  FileLibMit.WriteLine(fhand,_note);
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
                /* ElseIf not(Empty(qbe_frap_chkdiana->C_RAG)) */
              } else if ( ! (CPLib.Empty(Cursor_qbe_frap_chkdiana.GetString("C_RAG")))) {
                /* _note := w_tipinter + w_codinter+'5' */
                _note = w_tipinter+w_codinter+"5";
                /* _note := _note + DateToChar(qbe_frap_chkdiana->DATAOPE) + qbe_frap_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_frap_chkdiana->STATOREG) */
                _note = _note+CPLib.DateToChar(Cursor_qbe_frap_chkdiana.GetDate("DATAOPE"))+Cursor_qbe_frap_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_frap_chkdiana.GetString("STATOREG"));
                /* _note := _note + Left(LRTrim(qbe_frap_chkdiana->CONNESBEN)+Space(16),16) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("CONNESBEN"))+CPLib.Space(16),16);
                /* _note := _note +Left(LRTrim(qbe_frap_chkdiana->C_RAG)+Space(70),70) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_RAG"))+CPLib.Space(70),70);
                /* _note := _note + Left(LRTrim(qbe_frap_chkdiana->C_STA)+Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_STA"))+CPLib.Space(3),3);
                /* _note := _note +Left(LRTrim(qbe_frap_chkdiana->C_CAB)+Space(6),6) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_CAB"))+CPLib.Space(6),6);
                /* _note := _note +Left(LRTrim(qbe_frap_chkdiana->C_CTA)+Space(30),30) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_CTA"))+CPLib.Space(30),30);
                /* _note := _note + Left(LRTrim(qbe_frap_chkdiana->C_PRV)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_PRV"))+CPLib.Space(2),2);
                /* _note := _note + Left(LRTrim(qbe_frap_chkdiana->C_IND)+Space(35),35) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_IND"))+CPLib.Space(35),35);
                /* _note := _note + Left(LRTrim(qbe_frap_chkdiana->C_CAP)+Space(5),5) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_CAP"))+CPLib.Space(5),5);
                /* _note := _note + Space(63) */
                _note = _note+CPLib.Space(63);
                /* _note := _note + Left(LRTrim(qbe_frap_chkdiana->C_RAPPORTO)+Space(25),25) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                /* _note := _note + Space(91) */
                _note = _note+CPLib.Space(91);
                /* FileLibMit.WriteLine(fhand,_note) */
                FileLibMit.WriteLine(fhand,_note);
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
              } // End If
            } // End If
            // * --- Select from xeneficfrz
            m_cServer = m_Ctx.GetServer("xeneficfrz");
            m_cPhName = m_Ctx.GetPhName("xeneficfrz");
            if (Cursor_xeneficfrz!=null)
              Cursor_xeneficfrz.Close();
            Cursor_xeneficfrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_frap_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xeneficfrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xeneficfrz.Eof())) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xeneficfrz.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                /* _note := w_tipinter + w_codinter+'5' */
                _note = w_tipinter+w_codinter+"5";
                /* _note := _note + DateToChar(qbe_frap_chkdiana->DATAOPE) + qbe_frap_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_frap_chkdiana->STATOREG) */
                _note = _note+CPLib.DateToChar(Cursor_qbe_frap_chkdiana.GetDate("DATAOPE"))+Cursor_qbe_frap_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_frap_chkdiana.GetString("STATOREG"));
                /* _note := _note + Left(LRTrim(xeneficfrz->CODSOG)+Space(16),16) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("CODSOG"))+CPLib.Space(16),16);
                /* _note := _note + iif(not(Empty(LRTrim(xeneficfrz->C_RAG))),Left(LRTrim(xeneficfrz->C_RAG)+Space(70),70),Left(LRTrim(personbo->RAGSOC)+Space(70),70)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_RAG"))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70));
                /* _note := _note + iif(not(Empty(LRTrim(xeneficfrz->C_STA))),Left(LRTrim(xeneficfrz->C_STA)+Space(3),3),Left(LRTrim(personbo->PAESE)+Space(3),3)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3));
                /* _note := _note + iif(not(Empty(LRTrim(xeneficfrz->C_CAB))),Left(LRTrim(xeneficfrz->C_CAB)+Space(6),6),Left(LRTrim(personbo->CODCAB)+Space(6),6)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6));
                /* _note := _note + iif(not(Empty(LRTrim(xeneficfrz->C_CTA))),Left(LRTrim(xeneficfrz->C_CTA)+Space(30),30),Left(LRTrim(personbo->DESCCIT)+Space(30),30)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_CTA"))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30));
                /* _note := _note + iif(not(Empty(LRTrim(xeneficfrz->C_PRV))),Left(LRTrim(xeneficfrz->C_PRV)+Space(2),2),Left(LRTrim(personbo->PROVINCIA)+Space(2),2)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                /* _note := _note + iif(not(Empty(LRTrim(xeneficfrz->C_IND))),Left(LRTrim(xeneficfrz->C_IND)+Space(35),35),Left(LRTrim(personbo->DOMICILIO)+Space(35),35)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_IND"))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35));
                /* _note := _note + iif(not(Empty(LRTrim(xeneficfrz->C_CAP))),Left(LRTrim(xeneficfrz->C_CAP)+Space(5),5),Left(LRTrim(personbo->CAP)+Space(5),5)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5));
                /* _note := _note + Space(63) */
                _note = _note+CPLib.Space(63);
                /* _note := _note +Left(LRTrim(xeneficfrz->C_RAPPORTO)+Space(25),25) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                /* _note := _note + Space(91) */
                _note = _note+CPLib.Space(91);
                /* FileLibMit.WriteLine(fhand,_note) */
                FileLibMit.WriteLine(fhand,_note);
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
              Cursor_xeneficfrz.Next();
            }
            m_cConnectivityError = Cursor_xeneficfrz.ErrorMessage();
            Cursor_xeneficfrz.Close();
            // * --- End Select
            /* If not(Empty(qbe_frap_chkdiana->CONNALTRO)) */
            if ( ! (CPLib.Empty(Cursor_qbe_frap_chkdiana.GetString("CONNALTRO")))) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_frap_chkdiana.GetString("CONNALTRO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                /* _note := w_tipinter + w_codinter+'6' */
                _note = w_tipinter+w_codinter+"6";
                /* _note := _note + DateToChar(qbe_frap_chkdiana->DATAOPE) + qbe_frap_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_frap_chkdiana->STATOREG) */
                _note = _note+CPLib.DateToChar(Cursor_qbe_frap_chkdiana.GetDate("DATAOPE"))+Cursor_qbe_frap_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_frap_chkdiana.GetString("STATOREG"));
                /* _note := _note + Left(LRTrim(qbe_frap_chkdiana->CONNALTRO)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("CONNALTRO"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
                /* _note := _note + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
                /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
                /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                } // End If
                /* If not(Empty(personbo->NASSTATO)) */
                if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                  /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Space(35) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Space(35);
                } else { // Else
                  /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Space(35) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Space(35);
                } // End If
                /* _note := _note + Left(LRTrim(qbe_frap_chkdiana->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                } // End If
                /* _note := _note + personbo->AUTRILASC + personbo->SESSO + Space(34) */
                _note = _note+Cursor_personbo.GetString("AUTRILASC")+Cursor_personbo.GetString("SESSO")+CPLib.Space(34);
                /* FileLibMit.WriteLine(fhand,_note) */
                FileLibMit.WriteLine(fhand,_note);
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
            } // End If
            // * --- Select from xerzistifrz
            m_cServer = m_Ctx.GetServer("xerzistifrz");
            m_cPhName = m_Ctx.GetPhName("xerzistifrz");
            if (Cursor_xerzistifrz!=null)
              Cursor_xerzistifrz.Close();
            Cursor_xerzistifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_frap_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xerzistifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xerzistifrz.Eof())) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xerzistifrz.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                /* _note := w_tipinter + w_codinter+'6' */
                _note = w_tipinter+w_codinter+"6";
                /* _note := _note + DateToChar(qbe_frap_chkdiana->DATAOPE) + qbe_frap_chkdiana->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',qbe_frap_chkdiana->STATOREG) */
                _note = _note+CPLib.DateToChar(Cursor_qbe_frap_chkdiana.GetDate("DATAOPE"))+Cursor_qbe_frap_chkdiana.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_qbe_frap_chkdiana.GetString("STATOREG"));
                /* _note := _note + Left(LRTrim(xerzistifrz->CODSOG)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_xerzistifrz.GetString("CODSOG"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
                /* _note := _note + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
                /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
                /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                } // End If
                /* If not(Empty(personbo->NASSTATO)) */
                if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                  /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Space(35) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Space(35);
                } else { // Else
                  /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Space(35) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Space(35);
                } // End If
                /* _note := _note + Left(LRTrim(qbe_frap_chkdiana->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frap_chkdiana.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                } // End If
                /* _note := _note + personbo->AUTRILASC + personbo->SESSO + Space(34) */
                _note = _note+Cursor_personbo.GetString("AUTRILASC")+Cursor_personbo.GetString("SESSO")+CPLib.Space(34);
                /* FileLibMit.WriteLine(fhand,_note) */
                FileLibMit.WriteLine(fhand,_note);
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
              Cursor_xerzistifrz.Next();
            }
            m_cConnectivityError = Cursor_xerzistifrz.ErrorMessage();
            Cursor_xerzistifrz.Close();
            // * --- End Select
            /* gNumRec := nTotRec // N° Record DIANA */
            gNumRec = CPLib.Round(nTotRec,0);
            m_Ctx.SetGlobalNumber("gNumRec",gNumRec);
            /* gNumReg := nTotReg // N° Registrazioni DIANA */
            gNumReg = CPLib.Round(nTotReg,0);
            m_Ctx.SetGlobalNumber("gNumReg",gNumReg);
            Cursor_qbe_frap_chkdiana.Next();
          }
          m_cConnectivityError = Cursor_qbe_frap_chkdiana.ErrorMessage();
          Cursor_qbe_frap_chkdiana.Close();
          // * --- End Select
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* _contacilci := _contacilci+1 */
          _contacilci = CPLib.Round(_contacilci+1,0);
        } // End While
      } // End If
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
        if (Cursor_knarapbo!=null)
          Cursor_knarapbo.Close();
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
        if (Cursor_clientifrz!=null)
          Cursor_clientifrz.Close();
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
        if (Cursor_beneficfrz!=null)
          Cursor_beneficfrz.Close();
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
  void Page_5() throws Exception {
    CPResultSet Cursor_rapotit=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_anadip=null;
    CPResultSet Cursor_personbo=null;
    try {
      /* Titolari Effettivi */
      /* _conta := _conta + 1 */
      _conta = CPLib.Round(_conta+1,0);
      /* _nomefile := 'campione.txt.'+Right('0000'+LRTrim(Str(_conta,4,0)),4) */
      _nomefile = "campione.txt."+CPLib.Right("0000"+CPLib.LRTrim(CPLib.Str(_conta,4,0)),4);
      /* fhand := FileLibMit.OpenWrite('./flussi/'+LRTrim(gAzienda)+"/"+LRTrim(_nomefile)) */
      fhand = FileLibMit.OpenWrite("./flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_nomefile));
      // * --- Select from rapotit
      m_cServer = m_Ctx.GetServer("rapotit");
      m_cPhName = m_Ctx.GetPhName("rapotit");
      if (Cursor_rapotit!=null)
        Cursor_rapotit.Close();
      Cursor_rapotit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("rapotit")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1")+" order by "+"DATAOPE ",m_cServer,m_Ctx,true));
      while ( ! (Cursor_rapotit.Eof())) {
        /* _ctotale := _ctotale + 1 */
        _ctotale = CPLib.Round(_ctotale+1,0);
        /* gMsgImp := 'Elaborazione Informazione N.: '+LRTrim(Str(_ctotale,15,0)) // Messaggio Import */
        gMsgImp = "Elaborazione Informazione N.: "+CPLib.LRTrim(CPLib.Str(_ctotale,15,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _note := w_tipinter + w_codinter + '1' */
        _note = w_tipinter+w_codinter+"1";
        /* _note := _note + DateToChar(rapotit->DATAOPE) + rapotit->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',rapotit->STATOREG) */
        _note = _note+CPLib.DateToChar(Cursor_rapotit.GetDate("DATAOPE"))+Cursor_rapotit.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_rapotit.GetString("STATOREG"));
        /* If Empty(rapotit->CODDIPE) */
        if (CPLib.Empty(Cursor_rapotit.GetString("CODDIPE"))) {
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
              Error l_oErrorFault = new Error("Read on intermbo into routine arrt_chkdiana_mt returns two or more records. This item should return only a record.");
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
                Error l_oErrorFault = new Error("Read on anadip into routine arrt_chkdiana_mt returns two or more records. This item should return only a record.");
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
          Cursor_anadip = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODDIP="+CPLib.ToSQL(Cursor_rapotit.GetString("CODDIPE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("anadip")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_anadip.Eof())) {
            /* _note := _note + rapotit->CODDIPE + Left(LRTrim(anadip->CAB)+Space(6),6) + Left(LRTrim(anadip->DESCCIT)+Space(30),30) + Left(LRTrim(anadip->PROVINCIA)+Space(2),2) */
            _note = _note+Cursor_rapotit.GetString("CODDIPE")+CPLib.Left(CPLib.LRTrim(Cursor_anadip.GetString("CAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_anadip.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_anadip.GetString("PROVINCIA"))+CPLib.Space(2),2);
            Cursor_anadip.Next();
          }
          m_cConnectivityError = Cursor_anadip.ErrorMessage();
          Cursor_anadip.Close();
          // * --- End Select
        } // End If
        /* _note := _note + Left(DateToChar(rapotit->DATAOPE)+Space(8),8) + Left(LRTrim(rapotit->FLAGFRAZ)+" ",1) + Left(LRTrim(rapotit->FLAGCONT)+" ",1) */
        _note = _note+CPLib.Left(CPLib.DateToChar(Cursor_rapotit.GetDate("DATAOPE"))+CPLib.Space(8),8)+CPLib.Left(CPLib.LRTrim(Cursor_rapotit.GetString("FLAGFRAZ"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_rapotit.GetString("FLAGCONT"))+" ",1);
        /* _note := _note + Left(LRTrim(rapotit->CODANA)+Space(4),4) + Left(LRTrim(rapotit->CODVOC)+Space(2),2) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_rapotit.GetString("CODANA"))+CPLib.Space(4),4)+CPLib.Left(CPLib.LRTrim(Cursor_rapotit.GetString("CODVOC"))+CPLib.Space(2),2);
        /* _note := _note + Left(LRTrim(rapotit->TIPOINT2)+Space(2),2) + Left(LRTrim(rapotit->CODINT2)+Space(11),11) + Left(LRTrim(rapotit->PAESE)+Space(3),3) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_rapotit.GetString("TIPOINT2"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_rapotit.GetString("CODINT2"))+CPLib.Space(11),11)+CPLib.Left(CPLib.LRTrim(Cursor_rapotit.GetString("PAESE"))+CPLib.Space(3),3);
        /* _note := _note + Left(LRTrim(rapotit->CODCAB2)+Space(6),6) + Left(LRTrim(rapotit->DESC2)+Space(30),30) + Left(LRTrim(rapotit->PROV2)+Space(2),2) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_rapotit.GetString("CODCAB2"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_rapotit.GetString("DESC2"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_rapotit.GetString("PROV2"))+CPLib.Space(2),2);
        /* _note := _note + Left(LRTrim(rapotit->DESCINTER)+Space(50),50) + Left(LRTrim(rapotit->RAPPORTO)+Space(25),25) + Left(LRTrim(rapotit->FLAGRAP)+" ",1) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_rapotit.GetString("DESCINTER"))+CPLib.Space(50),50)+CPLib.Left(CPLib.LRTrim(Cursor_rapotit.GetString("RAPPORTO"))+CPLib.Space(25),25)+CPLib.Left(CPLib.LRTrim(Cursor_rapotit.GetString("FLAGRAP"))+" ",1);
        /* _note := _note + Left(LRTrim(rapotit->TIPOLEG)+" ",1) + Left(LRTrim(DateToChar(rapotit->DATAREG))+Space(8),8) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_rapotit.GetString("TIPOLEG"))+" ",1)+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_rapotit.GetDate("DATAREG")))+CPLib.Space(8),8);
        /* _note := _note + Left(LRTrim(rapotit->TIPOOPRAP)+Space(2),2) + Left(LRTrim(rapotit->COLLEG)+Space(11),11) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_rapotit.GetString("TIPOOPRAP"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_rapotit.GetString("COLLEG"))+CPLib.Space(11),11);
        /* _note := _note + " " + Left(LRTrim(rapotit->STATOREG)+" ",1)  */
        _note = _note+" "+CPLib.Left(CPLib.LRTrim(Cursor_rapotit.GetString("STATOREG"))+" ",1);
        /* If Empty(rapotit->DATARETT) or DateToChar(rapotit->DATARETT)='01000101' */
        if (CPLib.Empty(Cursor_rapotit.GetDate("DATARETT")) || CPLib.eqr(CPLib.DateToChar(Cursor_rapotit.GetDate("DATARETT")),"01000101")) {
          /* _note := _note + Space(8) */
          _note = _note+CPLib.Space(8);
        } else { // Else
          /* _note := _note + Left(LRTrim(DateToChar(rapotit->DATARETT))+Space(8),8) */
          _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_rapotit.GetDate("DATARETT")))+CPLib.Space(8),8);
        } // End If
        /* _note := _note + Left(LRTrim(rapotit->OPERAZMOD)+Space(20),20) + Left(LRTrim(rapotit->FLAGLIRE)+" ",1) + Left(LRTrim(rapotit->VALUTA)+Space(3),3) + Left(LRTrim(rapotit->SEGNO)+" ",1) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_rapotit.GetString("OPERAZMOD"))+CPLib.Space(20),20)+CPLib.Left(CPLib.LRTrim(Cursor_rapotit.GetString("FLAGLIRE"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_rapotit.GetString("VALUTA"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_rapotit.GetString("SEGNO"))+" ",1);
        /* _note := _note +  Right('000000000000000'+LRTrim(Str(rapotit->TOTLIRE,15,0)),15) + Right('000000000000000'+LRTrim(Str(rapotit->TOTCONT,15,0)),15) + Space(69) */
        _note = _note+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_rapotit.GetDouble("TOTLIRE"),15,0)),15)+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_rapotit.GetDouble("TOTCONT"),15,0)),15)+CPLib.Space(69);
        /* FileLibMit.WriteLine(fhand,_note) */
        FileLibMit.WriteLine(fhand,_note);
        /* nTotRec := nTotRec + 1 */
        nTotRec = CPLib.Round(nTotRec+1,0);
        /* nTotReg := nTotReg + 1 */
        nTotReg = CPLib.Round(nTotReg+1,0);
        /* nNumRec := nNumRec + 1 */
        nNumRec = CPLib.Round(nNumRec+1,0);
        /* If not(Empty(rapotit->CONNESCLI)) */
        if ( ! (CPLib.Empty(Cursor_rapotit.GetString("CONNESCLI")))) {
          // * --- Select from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          if (Cursor_personbo!=null)
            Cursor_personbo.Close();
          Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_rapotit.GetString("CONNESCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_personbo.Eof())) {
            /* _note := w_tipinter + w_codinter */
            _note = w_tipinter+w_codinter;
            /* If Empty(rapotit->CONNESOPER) or (rapotit->CONNESOPER=rapotit->CONNESCLI) */
            if (CPLib.Empty(Cursor_rapotit.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_rapotit.GetString("CONNESOPER"),Cursor_rapotit.GetString("CONNESCLI")))) {
              /* _note := _note + '2' */
              _note = _note+"2";
            } else { // Else
              /* _note := _note + '3' */
              _note = _note+"3";
            } // End If
            /* _note := _note + Left(LRTrim(DateToChar(rapotit->DATAOPE))+Space(8),8) + rapotit->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',rapotit->STATOREG) */
            _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_rapotit.GetDate("DATAOPE")))+CPLib.Space(8),8)+Cursor_rapotit.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_rapotit.GetString("STATOREG"));
            /* _note := _note + Left(LRTrim(rapotit->CONNESCLI)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_rapotit.GetString("CONNESCLI"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
            /* _note := _note + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
            /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
            /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
            /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
            if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
              /* _note := _note + Space(8) */
              _note = _note+CPLib.Space(8);
            } else { // Else
              /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
              _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
            } // End If
            /* If not(Empty(personbo->NASSTATO)) */
            if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
              /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
            } else { // Else
              /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
            } // End If
            /* _note := _note + Left(LRTrim(personbo->SETTSINT)+Space(3),3) + Left(LRTrim(rapotit->RAPPORTO)+Space(25),25) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_rapotit.GetString("RAPPORTO"))+CPLib.Space(25),25);
            /* _note := _note + Left(LRTrim(rapotit->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_rapotit.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
            /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
            if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
              /* _note := _note + Space(8) */
              _note = _note+CPLib.Space(8);
            } else { // Else
              /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
              _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
            } // End If
            /* _note := _note + Left(LRTrim(personbo->AUTRILASC)+Space(30),30) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("AUTRILASC"))+CPLib.Space(30),30);
            /* _note := _note + Left(LRTrim(personbo->SESSO)+" ",1) + Space(34) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SESSO"))+" ",1)+CPLib.Space(34);
            /* FileLibMit.WriteLine(fhand,_note) */
            FileLibMit.WriteLine(fhand,_note);
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
            Cursor_personbo.Next();
          }
          m_cConnectivityError = Cursor_personbo.ErrorMessage();
          Cursor_personbo.Close();
          // * --- End Select
        } // End If
        /* If not(Empty(rapotit->CONNESOPER)) */
        if ( ! (CPLib.Empty(Cursor_rapotit.GetString("CONNESOPER")))) {
          // * --- Select from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          if (Cursor_personbo!=null)
            Cursor_personbo.Close();
          Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_rapotit.GetString("CONNESOPER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_personbo.Eof())) {
            /* _note := w_tipinter + w_codinter+'6' */
            _note = w_tipinter+w_codinter+"6";
            /* _note := _note + DateToChar(rapotit->DATAOPE) + rapotit->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',rapotit->STATOREG) */
            _note = _note+CPLib.DateToChar(Cursor_rapotit.GetDate("DATAOPE"))+Cursor_rapotit.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_rapotit.GetString("STATOREG"));
            /* _note := _note + Left(LRTrim(rapotit->CONNESOPER)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_rapotit.GetString("CONNESOPER"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
            /* _note := _note + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
            /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
            /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
            /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
            if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
              /* _note := _note + Space(8) */
              _note = _note+CPLib.Space(8);
            } else { // Else
              /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
              _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
            } // End If
            /* If not(Empty(personbo->NASSTATO)) */
            if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
              /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Space(35) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Space(35);
            } else { // Else
              /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Space(35) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Space(35);
            } // End If
            /* _note := _note + Left(LRTrim(rapotit->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_rapotit.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
            /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
            if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
              /* _note := _note + Space(8) */
              _note = _note+CPLib.Space(8);
            } else { // Else
              /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
              _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
            } // End If
            /* _note := _note + personbo->AUTRILASC + personbo->SESSO + Space(34) */
            _note = _note+Cursor_personbo.GetString("AUTRILASC")+Cursor_personbo.GetString("SESSO")+CPLib.Space(34);
            /* FileLibMit.WriteLine(fhand,_note) */
            FileLibMit.WriteLine(fhand,_note);
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
            Cursor_personbo.Next();
          }
          m_cConnectivityError = Cursor_personbo.ErrorMessage();
          Cursor_personbo.Close();
          // * --- End Select
        } // End If
        /* gNumRec := nTotRec // N° Record DIANA */
        gNumRec = CPLib.Round(nTotRec,0);
        m_Ctx.SetGlobalNumber("gNumRec",gNumRec);
        /* gNumReg := nTotReg // N° Registrazioni DIANA */
        gNumReg = CPLib.Round(nTotReg,0);
        m_Ctx.SetGlobalNumber("gNumReg",gNumReg);
        Cursor_rapotit.Next();
      }
      m_cConnectivityError = Cursor_rapotit.ErrorMessage();
      Cursor_rapotit.Close();
      // * --- End Select
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
    } finally {
      try {
        if (Cursor_rapotit!=null)
          Cursor_rapotit.Close();
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
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
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
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_chkdiana_mtR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_chkdiana_mtR(p_Ctx, p_Caller);
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
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gNumRec=m_Ctx.GetGlobalNumber("gNumRec");
    gNumReg=m_Ctx.GetGlobalNumber("gNumReg");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gFlgWU=m_Ctx.GetGlobalString("gFlgWU");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_oped_chkdiana_limits,qbe_oped_chkdiana,qbe_opep_chkdiana_limits,qbe_opep_chkdiana,qbe_rapd_chkdiana,qbe_rapp_chkdiana,qbe_frad_chkdiana_limits,qbe_frad_chkdiana,qbe_frap_chkdiana_limits,qbe_frap_chkdiana,
  public static final String m_cVQRList = ",qbe_oped_chkdiana_limits,qbe_oped_chkdiana,qbe_opep_chkdiana_limits,qbe_opep_chkdiana,qbe_rapd_chkdiana,qbe_rapp_chkdiana,qbe_frad_chkdiana_limits,qbe_frad_chkdiana,qbe_frap_chkdiana_limits,qbe_frap_chkdiana,";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
}
