// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_imp_esitiR implements CallerWithObjs {
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
  public String m_cPhName_tmp_impesiti;
  public String m_cServer_tmp_impesiti;
  public String m_cPhName_aerighe;
  public String m_cServer_aerighe;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_aeoprig;
  public String m_cServer_aeoprig;
  public String m_cPhName_aederig;
  public String m_cServer_aederig;
  public String m_cPhName_aecanc;
  public String m_cServer_aecanc;
  public String m_cPhName_aeopcanc;
  public String m_cServer_aeopcanc;
  public String m_cPhName_aedecanc;
  public String m_cServer_aedecanc;
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
  public String w_msgproc;
  public double w_scelta;
  public double w_impzip;
  public String gMsgProc;
  public String w_nomefile;
  public String fhand;
  public String riga;
  public String _filename;
  public double salta;
  public double findesito;
  public String nprog;
  public String esito;
  public String esito2;
  public String idbase;
  public double nputf8;
  public double npnormal;
  public double nProgImp;
  public double _max;
  public double _min;
  public double _cicli;
  public double _contacilci;
  public double _bottom;
  public double _top;
  public double contafile;
  public String _aprog;
  public String _afile;
  public String _cprog;
  public String _cfile;
  public String rapporto;
  public String tipoac;
  public String connes;
  public String ident;
  public String ragsoc;
  public String persona;
  public String cognome;
  public String nome;
  public String sesso;
  public java.sql.Date datanasc;
  public String nascomun;
  public String nasstato;
  public String tipinter;
  public String desccit;
  public String provincia;
  public String codfisc;
  public String codcab;
  public String czipfile;
  public String cpercorsozip;
  public String cdirectoryfile;
  public String buffernomefile;
  public String nomefileimport;
  public double _priorita;
  public String gPathApp;
  public String gAzienda;
  public String gMsgImp;
  public double gOkPrintEsiti;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_imp_esiti
  public String[] lista;
  public int conteggio;
  public int i;
  public int contanome;
  // * --- Fine Area Manuale
  public arrt_imp_esitiR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_imp_esiti",m_Caller);
    m_cPhName_tmp_list_imprich = p_ContextObject.GetPhName("tmp_list_imprich");
    if (m_cPhName_tmp_list_imprich.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_list_imprich = m_cPhName_tmp_list_imprich+" "+m_Ctx.GetWritePhName("tmp_list_imprich");
    }
    m_cServer_tmp_list_imprich = p_ContextObject.GetServer("tmp_list_imprich");
    m_cPhName_tmp_impesiti = p_ContextObject.GetPhName("tmp_impesiti");
    if (m_cPhName_tmp_impesiti.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_impesiti = m_cPhName_tmp_impesiti+" "+m_Ctx.GetWritePhName("tmp_impesiti");
    }
    m_cServer_tmp_impesiti = p_ContextObject.GetServer("tmp_impesiti");
    m_cPhName_aerighe = p_ContextObject.GetPhName("aerighe");
    if (m_cPhName_aerighe.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aerighe = m_cPhName_aerighe+" "+m_Ctx.GetWritePhName("aerighe");
    }
    m_cServer_aerighe = p_ContextObject.GetServer("aerighe");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_aeoprig = p_ContextObject.GetPhName("aeoprig");
    if (m_cPhName_aeoprig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeoprig = m_cPhName_aeoprig+" "+m_Ctx.GetWritePhName("aeoprig");
    }
    m_cServer_aeoprig = p_ContextObject.GetServer("aeoprig");
    m_cPhName_aederig = p_ContextObject.GetPhName("aederig");
    if (m_cPhName_aederig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aederig = m_cPhName_aederig+" "+m_Ctx.GetWritePhName("aederig");
    }
    m_cServer_aederig = p_ContextObject.GetServer("aederig");
    m_cPhName_aecanc = p_ContextObject.GetPhName("aecanc");
    if (m_cPhName_aecanc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aecanc = m_cPhName_aecanc+" "+m_Ctx.GetWritePhName("aecanc");
    }
    m_cServer_aecanc = p_ContextObject.GetServer("aecanc");
    m_cPhName_aeopcanc = p_ContextObject.GetPhName("aeopcanc");
    if (m_cPhName_aeopcanc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeopcanc = m_cPhName_aeopcanc+" "+m_Ctx.GetWritePhName("aeopcanc");
    }
    m_cServer_aeopcanc = p_ContextObject.GetServer("aeopcanc");
    m_cPhName_aedecanc = p_ContextObject.GetPhName("aedecanc");
    if (m_cPhName_aedecanc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aedecanc = m_cPhName_aedecanc+" "+m_Ctx.GetWritePhName("aedecanc");
    }
    m_cServer_aedecanc = p_ContextObject.GetServer("aedecanc");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("scelta",p_cVarName)) {
      return w_scelta;
    }
    if (CPLib.eqr("impzip",p_cVarName)) {
      return w_impzip;
    }
    if (CPLib.eqr("salta",p_cVarName)) {
      return salta;
    }
    if (CPLib.eqr("findesito",p_cVarName)) {
      return findesito;
    }
    if (CPLib.eqr("nputf8",p_cVarName)) {
      return nputf8;
    }
    if (CPLib.eqr("npnormal",p_cVarName)) {
      return npnormal;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      return nProgImp;
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
    if (CPLib.eqr("contafile",p_cVarName)) {
      return contafile;
    }
    if (CPLib.eqr("_priorita",p_cVarName)) {
      return _priorita;
    }
    if (CPLib.eqr("gOkPrintEsiti",p_cVarName)) {
      return gOkPrintEsiti;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_imp_esiti";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("msgproc",p_cVarName)) {
      return w_msgproc;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      return w_nomefile;
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
    if (CPLib.eqr("nprog",p_cVarName)) {
      return nprog;
    }
    if (CPLib.eqr("esito",p_cVarName)) {
      return esito;
    }
    if (CPLib.eqr("esito2",p_cVarName)) {
      return esito2;
    }
    if (CPLib.eqr("idbase",p_cVarName)) {
      return idbase;
    }
    if (CPLib.eqr("_aprog",p_cVarName)) {
      return _aprog;
    }
    if (CPLib.eqr("_afile",p_cVarName)) {
      return _afile;
    }
    if (CPLib.eqr("_cprog",p_cVarName)) {
      return _cprog;
    }
    if (CPLib.eqr("_cfile",p_cVarName)) {
      return _cfile;
    }
    if (CPLib.eqr("rapporto",p_cVarName)) {
      return rapporto;
    }
    if (CPLib.eqr("tipoac",p_cVarName)) {
      return tipoac;
    }
    if (CPLib.eqr("connes",p_cVarName)) {
      return connes;
    }
    if (CPLib.eqr("ident",p_cVarName)) {
      return ident;
    }
    if (CPLib.eqr("ragsoc",p_cVarName)) {
      return ragsoc;
    }
    if (CPLib.eqr("persona",p_cVarName)) {
      return persona;
    }
    if (CPLib.eqr("cognome",p_cVarName)) {
      return cognome;
    }
    if (CPLib.eqr("nome",p_cVarName)) {
      return nome;
    }
    if (CPLib.eqr("sesso",p_cVarName)) {
      return sesso;
    }
    if (CPLib.eqr("nascomun",p_cVarName)) {
      return nascomun;
    }
    if (CPLib.eqr("nasstato",p_cVarName)) {
      return nasstato;
    }
    if (CPLib.eqr("tipinter",p_cVarName)) {
      return tipinter;
    }
    if (CPLib.eqr("desccit",p_cVarName)) {
      return desccit;
    }
    if (CPLib.eqr("provincia",p_cVarName)) {
      return provincia;
    }
    if (CPLib.eqr("codfisc",p_cVarName)) {
      return codfisc;
    }
    if (CPLib.eqr("codcab",p_cVarName)) {
      return codcab;
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
    if (CPLib.eqr("datanasc",p_cVarName)) {
      return datanasc;
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
    if (CPLib.eqr("scelta",p_cVarName)) {
      w_scelta = value;
      return;
    }
    if (CPLib.eqr("impzip",p_cVarName)) {
      w_impzip = value;
      return;
    }
    if (CPLib.eqr("salta",p_cVarName)) {
      salta = value;
      return;
    }
    if (CPLib.eqr("findesito",p_cVarName)) {
      findesito = value;
      return;
    }
    if (CPLib.eqr("nputf8",p_cVarName)) {
      nputf8 = value;
      return;
    }
    if (CPLib.eqr("npnormal",p_cVarName)) {
      npnormal = value;
      return;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      nProgImp = value;
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
    if (CPLib.eqr("contafile",p_cVarName)) {
      contafile = value;
      return;
    }
    if (CPLib.eqr("_priorita",p_cVarName)) {
      _priorita = value;
      return;
    }
    if (CPLib.eqr("gOkPrintEsiti",p_cVarName)) {
      gOkPrintEsiti = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("msgproc",p_cVarName)) {
      w_msgproc = value;
      return;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
      return;
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      w_nomefile = value;
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
    if (CPLib.eqr("nprog",p_cVarName)) {
      nprog = value;
      return;
    }
    if (CPLib.eqr("esito",p_cVarName)) {
      esito = value;
      return;
    }
    if (CPLib.eqr("esito2",p_cVarName)) {
      esito2 = value;
      return;
    }
    if (CPLib.eqr("idbase",p_cVarName)) {
      idbase = value;
      return;
    }
    if (CPLib.eqr("_aprog",p_cVarName)) {
      _aprog = value;
      return;
    }
    if (CPLib.eqr("_afile",p_cVarName)) {
      _afile = value;
      return;
    }
    if (CPLib.eqr("_cprog",p_cVarName)) {
      _cprog = value;
      return;
    }
    if (CPLib.eqr("_cfile",p_cVarName)) {
      _cfile = value;
      return;
    }
    if (CPLib.eqr("rapporto",p_cVarName)) {
      rapporto = value;
      return;
    }
    if (CPLib.eqr("tipoac",p_cVarName)) {
      tipoac = value;
      return;
    }
    if (CPLib.eqr("connes",p_cVarName)) {
      connes = value;
      return;
    }
    if (CPLib.eqr("ident",p_cVarName)) {
      ident = value;
      return;
    }
    if (CPLib.eqr("ragsoc",p_cVarName)) {
      ragsoc = value;
      return;
    }
    if (CPLib.eqr("persona",p_cVarName)) {
      persona = value;
      return;
    }
    if (CPLib.eqr("cognome",p_cVarName)) {
      cognome = value;
      return;
    }
    if (CPLib.eqr("nome",p_cVarName)) {
      nome = value;
      return;
    }
    if (CPLib.eqr("sesso",p_cVarName)) {
      sesso = value;
      return;
    }
    if (CPLib.eqr("nascomun",p_cVarName)) {
      nascomun = value;
      return;
    }
    if (CPLib.eqr("nasstato",p_cVarName)) {
      nasstato = value;
      return;
    }
    if (CPLib.eqr("tipinter",p_cVarName)) {
      tipinter = value;
      return;
    }
    if (CPLib.eqr("desccit",p_cVarName)) {
      desccit = value;
      return;
    }
    if (CPLib.eqr("provincia",p_cVarName)) {
      provincia = value;
      return;
    }
    if (CPLib.eqr("codfisc",p_cVarName)) {
      codfisc = value;
      return;
    }
    if (CPLib.eqr("codcab",p_cVarName)) {
      codcab = value;
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
    if (CPLib.eqr("datanasc",p_cVarName)) {
      datanasc = value;
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
    CPResultSet Cursor_tmp_list_imprich=null;
    CPResultSet Cursor_qbe_tmp_impesiti_max_min=null;
    CPResultSet Cursor_tmp_impesiti=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* w_msgproc Memo */
      /* w_scelta Numeric(1, 0) */
      /* w_impzip Numeric(1, 0) */
      /* gMsgProc Memo */
      /* w_nomefile Char(100) */
      /* fhand Char(1) */
      /* riga Memo */
      /* _filename Char(30) */
      /* salta Numeric(1, 0) */
      /* findesito Numeric(1, 0) */
      /* nprog Char(25) */
      /* esito Char(200) */
      /* esito2 Char(200) */
      /* idbase Char(10) */
      /* nputf8 Numeric(19, 0) */
      /* npnormal Numeric(19, 0) */
      /* nProgImp Numeric(15, 0) */
      /* _max Numeric(15, 0) */
      /* _min Numeric(15, 0) */
      /* _cicli Numeric(15, 0) */
      /* _contacilci Numeric(15, 0) */
      /* _bottom Numeric(15, 0) */
      /* _top Numeric(15, 0) */
      /* contafile Numeric(10, 0) */
      /* _aprog Char(25) */
      /* _afile Char(15) */
      /* _cprog Char(25) */
      /* _cfile Char(15) */
      /* rapporto Char(25) */
      /* tipoac Char(1) */
      /* connes Char(16) */
      /* ident Char(15) */
      /* ragsoc Char(30) */
      /* persona Char(10) */
      /* cognome Char(26) */
      /* nome Char(25) */
      /* sesso Char(1) */
      /* datanasc Date */
      /* nascomun Char(30) */
      /* nasstato Char(30) */
      /* tipinter Char(2) */
      /* desccit Char(30) */
      /* provincia Char(2) */
      /* codfisc Char(16) */
      /* codcab Char(6) */
      /* czipfile Char(100) */
      /* cpercorsozip Char(200) */
      /* cdirectoryfile Char(200) */
      /* buffernomefile Char(100) */
      /* nomefileimport Char(50) */
      /* _priorita Numeric(3, 0) */
      /* gPathApp Char(80) // Path Applicazione */
      /* gAzienda Char(10) // Azienda */
      /* gMsgImp Memo // Messaggio Import */
      /* gOkPrintEsiti Numeric(1, 0) // Abbilita le stampe degli esiti importati */
      /* gMsgProc := '' // Messaggio */
      gMsgProc = "";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Estrai il filezip */
      /* If w_impzip=1 */
      if (CPLib.eqr(w_impzip,1)) {
        /* Exec "Estrai zip" Page 5:Page_5 */
        Page_5();
      } // End If
      /* contafile := 0 */
      contafile = CPLib.Round(0,0);
      /* Cicla sul file della lista e lancia la lettura file */
      // * --- Select from tmp_list_imprich
      m_cServer = m_Ctx.GetServer("tmp_list_imprich");
      m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
      if (Cursor_tmp_list_imprich!=null)
        Cursor_tmp_list_imprich.Close();
      Cursor_tmp_list_imprich = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_list_imprich")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_tmp_list_imprich.Eof())) {
        /* _filename := tmp_list_imprich->nomefile */
        _filename = Cursor_tmp_list_imprich.GetString("nomefile");
        /* contafile := contafile+1 */
        contafile = CPLib.Round(contafile+1,0);
        /* Exec "File" Page 2:Page_2 */
        Page_2();
        Cursor_tmp_list_imprich.Next();
      }
      m_cConnectivityError = Cursor_tmp_list_imprich.ErrorMessage();
      Cursor_tmp_list_imprich.Close();
      // * --- End Select
      /* a questo punto compilo i vari campi anagrafici */
      /* gMsgProc := gMsgProc + 'Ora Inzio Elaborazione dati '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Inzio Elaborazione dati "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // * --- Select from qbe_tmp_impesiti_max_min
      if (Cursor_qbe_tmp_impesiti_max_min!=null)
        Cursor_qbe_tmp_impesiti_max_min.Close();
      Cursor_qbe_tmp_impesiti_max_min = new VQRHolder("qbe_tmp_impesiti_max_min",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tmp_impesiti_max_min.Eof())) {
        /* _max := qbe_tmp_impesiti_max_min->MAXPROGIMPESITI */
        _max = CPLib.Round(Cursor_qbe_tmp_impesiti_max_min.GetDouble("MAXPROGIMPESITI"),0);
        /* _min := qbe_tmp_impesiti_max_min->MINPROGIMPESITI */
        _min = CPLib.Round(Cursor_qbe_tmp_impesiti_max_min.GetDouble("MINPROGIMPESITI"),0);
        Cursor_qbe_tmp_impesiti_max_min.Next();
      }
      m_cConnectivityError = Cursor_qbe_tmp_impesiti_max_min.ErrorMessage();
      Cursor_qbe_tmp_impesiti_max_min.Close();
      // * --- End Select
      /* _cicli := iif(Mod(_max,10000) <> 0,Int(_max/10000) + 1,Int(_max/10000)) */
      _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,10000),0)?CPLib.Int(_max/10000)+1:CPLib.Int(_max/10000)),0);
      /* _contacilci := 1 */
      _contacilci = CPLib.Round(1,0);
      /* While _contacilci<= _cicli */
      while (CPLib.le(_contacilci,_cicli)) {
        /* _bottom := ((_contacilci -1 ) * 10000) + 1 */
        _bottom = CPLib.Round(((_contacilci-1)*10000)+1,0);
        /* _top := _contacilci * 10000 */
        _top = CPLib.Round(_contacilci*10000,0);
        /* If _top>=_min */
        if (CPLib.ge(_top,_min)) {
          // * --- Select from tmp_impesiti
          m_cServer = m_Ctx.GetServer("tmp_impesiti");
          m_cPhName = m_Ctx.GetPhName("tmp_impesiti");
          if (Cursor_tmp_impesiti!=null)
            Cursor_tmp_impesiti.Close();
          Cursor_tmp_impesiti = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"PROGIMPESITI>="+CPSql.SQLValueAdapter(CPLib.ToSQL(_bottom,"?",0,0,m_cServer, m_oParameters),m_cServer,_bottom)+"  and  PROGIMPESITI<="+CPSql.SQLValueAdapter(CPLib.ToSQL(_top,"?",0,0,m_cServer, m_oParameters),m_cServer,_top)+" "+")"+(m_Ctx.IsSharedTemp("tmp_impesiti")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_tmp_impesiti.Eof())) {
            /* nprog := tmp_impesiti->nprog */
            nprog = Cursor_tmp_impesiti.GetString("nprog");
            /* idbase := tmp_impesiti->idbase */
            idbase = Cursor_tmp_impesiti.GetString("idbase");
            /* If LRTrim(nprog)<>'Senza progressivo' */
            if (CPLib.ne(CPLib.LRTrim(nprog),"Senza progressivo")) {
              /* If w_scelta=1 */
              if (CPLib.eqr(w_scelta,1)) {
                /* Exec "CompletamentoR" Page 3:Page_3 */
                Page_3();
              } else { // Else
                /* Exec "CompletamentoO" Page 4:Page_4 */
                Page_4();
              } // End If
            } // End If
            /* gMsgImp := 'Elaborazione al ' + LRTrim(Str(((tmp_impesiti->PROGIMPESITI-(_min-1))/(_max-(_min-1)))*100,5,2)) + '%.' // Messaggio allineamento 1 */
            gMsgImp = "Elaborazione al "+CPLib.LRTrim(CPLib.Str(((Cursor_tmp_impesiti.GetDouble("PROGIMPESITI")-(_min-1))/(_max-(_min-1)))*100,5,2))+"%.";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            Cursor_tmp_impesiti.Next();
          }
          m_cConnectivityError = Cursor_tmp_impesiti.ErrorMessage();
          Cursor_tmp_impesiti.Close();
          // * --- End Select
        } // End If
        /* _contacilci := _contacilci+1 */
        _contacilci = CPLib.Round(_contacilci+1,0);
      } // End While
      /* gOkPrintEsiti := 1 // Bottone Stampe */
      gOkPrintEsiti = CPLib.Round(1,0);
      m_Ctx.SetGlobalNumber("gOkPrintEsiti",gOkPrintEsiti);
      /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione dati '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Fine Elaborazione dati "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_tmp_list_imprich!=null)
          Cursor_tmp_list_imprich.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_tmp_impesiti_max_min!=null)
          Cursor_qbe_tmp_impesiti_max_min.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tmp_impesiti!=null)
          Cursor_tmp_impesiti.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    /* Legge il file di testo e recupera i progressivi e i vari esiti */
    /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + _filename + NL */
    gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+_filename+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* fhand := FileLibMit.OpenRead('appo/'+LRTrim(_filename)) */
    fhand = FileLibMit.OpenRead("appo/"+CPLib.LRTrim(_filename));
    /* nputf8 := 0 */
    nputf8 = CPLib.Round(0,0);
    /* npnormal := 0 */
    npnormal = CPLib.Round(0,0);
    /* findesito := 0 */
    findesito = CPLib.Round(0,0);
    /* esito := '' */
    esito = "";
    /* esito2 := '' */
    esito2 = "";
    /* riga := FileLibMit.ReadLine(fhand) */
    riga = FileLibMit.ReadLine(fhand);
    /* While not(FileLibMit.Eof(fhand)) */
    while ( ! (FileLibMit.Eof(fhand))) {
      /* salta := 0 */
      salta = CPLib.Round(0,0);
      /* riga := FileLibMit.ReadLine(fhand) */
      riga = FileLibMit.ReadLine(fhand);
      /* If findesito<>1 */
      if (CPLib.ne(findesito,1)) {
        /* If At('PRESENZA DI CARATTERI NON AMMESSI',LRTrim(Upper(riga)))>0 */
        if (CPLib.gt(CPLib.At("PRESENZA DI CARATTERI NON AMMESSI",CPLib.LRTrim(CPLib.Upper(riga))),0)) {
          /* setto una variabile per passare al record successivo */
          /* riga := FileLibMit.ReadLine(fhand) */
          riga = FileLibMit.ReadLine(fhand);
          /* nprog := Substr(riga,121,25) */
          nprog = CPLib.Substr(riga,121,25);
          /* idbase := LibreriaMit.UniqueId() */
          idbase = LibreriaMit.UniqueId();
          /* salta := 1 */
          salta = CPLib.Round(1,0);
          /* nputf8 := nputf8+1 */
          nputf8 = CPLib.Round(nputf8+1,0);
          /* nProgImp := Utilities.GetAutonumber("PROGIMPESITI\'"+LRTrim(gAzienda)+"'",0,15) */
          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGIMPESITI\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
          // * --- Insert into tmp_impesiti from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_impesiti");
          m_cPhName = m_Ctx.GetPhName("tmp_impesiti");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_impesiti",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_esiti",269,"00000072")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000072(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL("PRESENZA DI CARATTERI NON AMMESSI","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Str(CPLib.Val(nprog),25,0)),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(idbase,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_filename),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_impesiti",true);
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
      /* If salta<> 1 */
      if (CPLib.ne(salta,1)) {
        /* If Left(riga,2) = '34' */
        if (CPLib.eqr(CPLib.Left(riga,2),"34")) {
          /* findesito := 1 */
          findesito = CPLib.Round(1,0);
          /* nprog := Substr(riga,121,25) */
          nprog = CPLib.Substr(riga,121,25);
          /* idbase := LibreriaMit.UniqueId() */
          idbase = LibreriaMit.UniqueId();
          /* nProgImp := Utilities.GetAutonumber("PROGIMPESITI\'"+LRTrim(gAzienda)+"'",0,15) */
          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGIMPESITI\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
          /* esito2 := LRTrim(Substr(riga,21,100)) */
          esito2 = CPLib.LRTrim(CPLib.Substr(riga,21,100));
          /* If LRTrim(esito2)='' */
          if (CPLib.eqr(CPLib.LRTrim(esito2),"")) {
            /* Case Substr(riga,3,2)='01' */
            if (CPLib.eqr(CPLib.Substr(riga,3,2),"01")) {
              /* esito2 := 'CODICE FISCALE TITOLARE RAPPORTO - VALORE ASSENTE' */
              esito2 = "CODICE FISCALE TITOLARE RAPPORTO - VALORE ASSENTE";
              /* Case Substr(riga,3,2)='02' */
            } else if (CPLib.eqr(CPLib.Substr(riga,3,2),"02")) {
              /* esito2 := 'CODICE FISCALE TITOLARE RAPPORTO - VALORE ERRATO IN FORMATO' */
              esito2 = "CODICE FISCALE TITOLARE RAPPORTO - VALORE ERRATO IN FORMATO";
            } // End Case
          } // End If
          // * --- Insert into tmp_impesiti from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_impesiti");
          m_cPhName = m_Ctx.GetPhName("tmp_impesiti");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_impesiti",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_esiti",269,"0000007E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000007E(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Str(CPLib.Val(nprog),25,0)),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(idbase,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_filename),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(esito2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_impesiti",true);
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
          /* npnormal := npnormal+1 */
          npnormal = CPLib.Round(npnormal+1,0);
        } // End If
        /* setto una variabile per prendere tutte le prossime righe come esito */
        /* If Left(riga,2) = '32' */
        if (CPLib.eqr(CPLib.Left(riga,2),"32")) {
          /* findesito := 1 */
          findesito = CPLib.Round(1,0);
          /* nprog := Substr(riga,121,25) */
          nprog = CPLib.Substr(riga,121,25);
          /* idbase := LibreriaMit.UniqueId() */
          idbase = LibreriaMit.UniqueId();
          /* nProgImp := Utilities.GetAutonumber("PROGIMPESITI\'"+LRTrim(gAzienda)+"'",0,15) */
          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGIMPESITI\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
          /* esito2 := LRTrim(Substr(riga,21,100)) */
          esito2 = CPLib.LRTrim(CPLib.Substr(riga,21,100));
          /* If LRTrim(esito2)='' */
          if (CPLib.eqr(CPLib.LRTrim(esito2),"")) {
            /* Case Substr(riga,3,2)='00' */
            if (CPLib.eqr(CPLib.Substr(riga,3,2),"00")) {
              /* esito2 := 'CODICE FISCALE TITOLARE RAPPORTO: CODICE FISCALE E DATI ANAGRAFICI INCONGRUENTI' */
              esito2 = "CODICE FISCALE TITOLARE RAPPORTO: CODICE FISCALE E DATI ANAGRAFICI INCONGRUENTI";
            } // End Case
          } // End If
          // * --- Insert into tmp_impesiti from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_impesiti");
          m_cPhName = m_Ctx.GetPhName("tmp_impesiti");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_impesiti",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_esiti",269,"0000008A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000008A(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Str(CPLib.Val(nprog),25,0)),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(idbase,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_filename),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(esito2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_impesiti",true);
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
          /* npnormal := npnormal+1 */
          npnormal = CPLib.Round(npnormal+1,0);
        } // End If
      } // End If
      /* gMsgImp := 'Importazione file ' + LRTrim(Str(contafile,10,0)) + ' di ' + conteggio + '. Nel file '+_filename+' sono stati rilevati '+ LRTrim(Str(npnormal,19,0)) + ' errori.' // Messaggio Import */
      gMsgImp = "Importazione file "+CPLib.LRTrim(CPLib.Str(contafile,10,0))+" di "+conteggio+". Nel file "+_filename+" sono stati rilevati "+CPLib.LRTrim(CPLib.Str(npnormal,19,0))+" errori.";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } // End While
    /* FileLibMit.Close(fhand) */
    FileLibMit.Close(fhand);
    /* FileLibMit.DeleteFile('appo/'+LRTrim(_filename)) */
    FileLibMit.DeleteFile("appo/"+CPLib.LRTrim(_filename));
    /* gMsgProc := gMsgProc + 'Nel file:'+LRTrim(_filename)+' sono stati rilevati '+LRTrim(Str(npnormal,19,0))+' errori '+ iif(nputf8>0,' più '+LRTrim(Str(nputf8,19,0))+' senza progressivo','')+NL  // Messaggio */
    gMsgProc = gMsgProc+"Nel file:"+CPLib.LRTrim(_filename)+" sono stati rilevati "+CPLib.LRTrim(CPLib.Str(npnormal,19,0))+" errori "+(CPLib.gt(nputf8,0)?" più "+CPLib.LRTrim(CPLib.Str(nputf8,19,0))+" senza progressivo":"")+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + _filename + NL */
    gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+_filename+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
  }
  void Page_3() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* rapporto := '' */
      rapporto = "";
      /* tipoac := '' */
      tipoac = "";
      /* connes := '' */
      connes = "";
      /* ident := '' */
      ident = "";
      /* ragsoc := '' */
      ragsoc = "";
      /* persona := '' */
      persona = "";
      /* cognome := '' */
      cognome = "";
      /* nome := '' */
      nome = "";
      /* sesso := '' */
      sesso = "";
      /* datanasc := NullDate() */
      datanasc = CPLib.NullDate();
      /* nascomun := '' */
      nascomun = "";
      /* tipinter := '' */
      tipinter = "";
      /* desccit := '' */
      desccit = "";
      /* provincia := '' */
      provincia = "";
      /* codfisc := '' */
      codfisc = "";
      /* codcab := '' */
      codcab = "";
      /* _aprog := '' */
      _aprog = "";
      /* _afile := '' */
      _afile = "";
      /* _cprog := '' */
      _cprog = "";
      /* _cfile := '' */
      _cfile = "";
      /* provo prima a vedere se è una apertura */
      /* nprog := arfn_delzero(nprog) */
      nprog = arfn_delzeroR.Make(m_Ctx,this).Run(nprog);
      // * --- Read from aerighe
      m_cServer = m_Ctx.GetServer("aerighe");
      m_cPhName = m_Ctx.GetPhName("aerighe");
      m_cSql = "";
      m_cSql = m_cSql+"APROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(nprog,"C",25,0,m_cServer),m_cServer,nprog);
      if (m_Ctx.IsSharedTemp("aerighe")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("AFILE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CONNESINT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("APROG",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("AFILE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        ident = Read_Cursor.GetString("AFILE");
        connes = Read_Cursor.GetString("CONNESINT");
        rapporto = Read_Cursor.GetString("RAPPORTO");
        _aprog = Read_Cursor.GetString("APROG");
        _afile = Read_Cursor.GetString("AFILE");
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on aerighe into routine arrt_imp_esiti returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        ident = "";
        connes = "";
        rapporto = "";
        _aprog = "";
        _afile = "";
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
      /* If ident='' */
      if (CPLib.eqr(ident,"")) {
        /* allora forse è una chiusura */
        // * --- Read from aerighe
        m_cServer = m_Ctx.GetServer("aerighe");
        m_cPhName = m_Ctx.GetPhName("aerighe");
        m_cSql = "";
        m_cSql = m_cSql+"CPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(nprog,"C",25,0,m_cServer),m_cServer,nprog);
        if (m_Ctx.IsSharedTemp("aerighe")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CFILE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CONNESINT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("APROG",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("AFILE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CPROG",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CFILE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          ident = Read_Cursor.GetString("CFILE");
          connes = Read_Cursor.GetString("CONNESINT");
          rapporto = Read_Cursor.GetString("RAPPORTO");
          _aprog = Read_Cursor.GetString("APROG");
          _afile = Read_Cursor.GetString("AFILE");
          _cprog = Read_Cursor.GetString("CPROG");
          _cfile = Read_Cursor.GetString("CFILE");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on aerighe into routine arrt_imp_esiti returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          ident = "";
          connes = "";
          rapporto = "";
          _aprog = "";
          _afile = "";
          _cprog = "";
          _cfile = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
      } else { // Else
        /* tipoac := 'A' */
        tipoac = "A";
      } // End If
      /* If ident="" */
      if (CPLib.eqr(ident,"")) {
        // * --- Read from aecanc
        m_cServer = m_Ctx.GetServer("aecanc");
        m_cPhName = m_Ctx.GetPhName("aecanc");
        m_cSql = "";
        m_cSql = m_cSql+"IDPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(nprog,"C",25,0,m_cServer),m_cServer,nprog);
        if (m_Ctx.IsSharedTemp("aecanc")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDFILE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CONNESINT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("APROG",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("AFILE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CPROG",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CFILE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          ident = Read_Cursor.GetString("IDFILE");
          connes = Read_Cursor.GetString("CONNESINT");
          rapporto = Read_Cursor.GetString("RAPPORTO");
          _aprog = Read_Cursor.GetString("APROG");
          _afile = Read_Cursor.GetString("AFILE");
          _cprog = Read_Cursor.GetString("CPROG");
          _cfile = Read_Cursor.GetString("CFILE");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on aecanc into routine arrt_imp_esiti returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          ident = "";
          connes = "";
          rapporto = "";
          _aprog = "";
          _afile = "";
          _cprog = "";
          _cfile = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
      } else { // Else
        /* tipoac := 'C' */
        tipoac = "C";
      } // End If
      /* If ident='' */
      if (CPLib.eqr(ident,"")) {
        /* in questo caso non è stato individuato */
        // * --- Write into tmp_impesiti from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_impesiti");
        m_cPhName = m_Ctx.GetPhName("tmp_impesiti");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_impesiti",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_esiti",269,"000000B2")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"rapporto = "+CPLib.ToSQL("Rapporto non individuato","C",25,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_impesiti",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"idbase = "+CPSql.SQLValueAdapter(CPLib.ToSQL(idbase,"?",0,0,m_cServer),m_cServer,idbase)+"";
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
        /* quindi dovrebbe averlo trovato */
        /* If tipoac='' */
        if (CPLib.eqr(tipoac,"")) {
          /* tipoac := 'D' */
          tipoac = "D";
        } // End If
        // * --- Read from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        m_cSql = "";
        m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(connes,"C",16,0,m_cServer),m_cServer,connes);
        if (m_Ctx.IsSharedTemp("personbo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAGSOC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("COGNOME",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("NOME",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("SESSO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DATANASC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("NASCOMUN",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("TIPINTER",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODCAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("NASSTATO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          ragsoc = Read_Cursor.GetString("RAGSOC");
          cognome = Read_Cursor.GetString("COGNOME");
          nome = Read_Cursor.GetString("NOME");
          sesso = Read_Cursor.GetString("SESSO");
          datanasc = Read_Cursor.GetDate("DATANASC");
          nascomun = Read_Cursor.GetString("NASCOMUN");
          tipinter = Read_Cursor.GetString("TIPINTER");
          desccit = Read_Cursor.GetString("DESCCIT");
          provincia = Read_Cursor.GetString("PROVINCIA");
          codfisc = Read_Cursor.GetString("CODFISC");
          codcab = Read_Cursor.GetString("CODCAB");
          nasstato = Read_Cursor.GetString("NASSTATO");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on personbo into routine arrt_imp_esiti returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          ragsoc = "";
          cognome = "";
          nome = "";
          sesso = "";
          datanasc = CPLib.NullDate();
          nascomun = "";
          tipinter = "";
          desccit = "";
          provincia = "";
          codfisc = "";
          codcab = "";
          nasstato = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If LRTrim(sesso)='' */
        if (CPLib.eqr(CPLib.LRTrim(sesso),"")) {
          /* persona := 'Giuridica' */
          persona = "Giuridica";
        } else { // Else
          /* persona := 'Fisica' */
          persona = "Fisica";
        } // End If
        // * --- Write into tmp_impesiti from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_impesiti");
        m_cPhName = m_Ctx.GetPhName("tmp_impesiti");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_impesiti",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_esiti",269,"000000BA")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"trueident = "+CPLib.ToSQL(ident,"C",15,0,m_cServer)+", ";
        m_cSql = m_cSql+"ragsoc = "+CPLib.ToSQL(ragsoc,"C",70,0,m_cServer)+", ";
        m_cSql = m_cSql+"rapporto = "+CPLib.ToSQL(rapporto,"C",25,0,m_cServer)+", ";
        m_cSql = m_cSql+"connes = "+CPLib.ToSQL(connes,"C",16,0,m_cServer)+", ";
        m_cSql = m_cSql+"tipoac = "+CPLib.ToSQL(tipoac,"C",1,0,m_cServer)+", ";
        m_cSql = m_cSql+"persona = "+CPLib.ToSQL(persona,"C",10,0,m_cServer)+", ";
        m_cSql = m_cSql+"cognome = "+CPLib.ToSQL(cognome,"C",26,0,m_cServer)+", ";
        m_cSql = m_cSql+"nome = "+CPLib.ToSQL(nome,"C",25,0,m_cServer)+", ";
        m_cSql = m_cSql+"sesso = "+CPLib.ToSQL(sesso,"C",1,0,m_cServer)+", ";
        m_cSql = m_cSql+"datanasc = "+CPLib.ToSQL(datanasc,"D",8,0)+", ";
        m_cSql = m_cSql+"nascomun = "+CPLib.ToSQL((CPLib.eqr(tipinter,"EE")?nasstato:nascomun),"C",40,0,m_cServer)+", ";
        m_cSql = m_cSql+"tipinter = "+CPLib.ToSQL(tipinter,"C",2,0,m_cServer)+", ";
        m_cSql = m_cSql+"desccit = "+CPLib.ToSQL(desccit,"C",40,0,m_cServer)+", ";
        m_cSql = m_cSql+"provincia = "+CPLib.ToSQL(provincia,"C",2,0,m_cServer)+", ";
        m_cSql = m_cSql+"codfisc = "+CPLib.ToSQL(codfisc,"C",16,0,m_cServer)+", ";
        m_cSql = m_cSql+"codcab = "+CPLib.ToSQL(codcab,"C",6,0,m_cServer)+", ";
        m_cSql = m_cSql+"aprog = "+CPLib.ToSQL(CPLib.Right("0000000000000000000000000"+CPLib.LRTrim(_aprog),25),"C",25,0,m_cServer)+", ";
        m_cSql = m_cSql+"afile = "+CPLib.ToSQL(_afile,"C",15,0,m_cServer)+", ";
        m_cSql = m_cSql+"cprog = "+CPLib.ToSQL(CPLib.Right("0000000000000000000000000"+CPLib.LRTrim(_cprog),25),"C",25,0,m_cServer)+", ";
        m_cSql = m_cSql+"cfile = "+CPLib.ToSQL(_cfile,"C",15,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_impesiti",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"idbase = "+CPSql.SQLValueAdapter(CPLib.ToSQL(idbase,"?",0,0,m_cServer),m_cServer,idbase)+"";
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
    try {
      /* rapporto := '' */
      rapporto = "";
      /* tipoac := '' */
      tipoac = "";
      /* connes := '' */
      connes = "";
      /* ident := '' */
      ident = "";
      /* ragsoc := '' */
      ragsoc = "";
      /* persona := '' */
      persona = "";
      /* cognome := '' */
      cognome = "";
      /* nome := '' */
      nome = "";
      /* sesso := '' */
      sesso = "";
      /* datanasc := NullDate() */
      datanasc = CPLib.NullDate();
      /* nascomun := '' */
      nascomun = "";
      /* nasstato := '' */
      nasstato = "";
      /* tipinter := '' */
      tipinter = "";
      /* desccit := '' */
      desccit = "";
      /* provincia := '' */
      provincia = "";
      /* codfisc := '' */
      codfisc = "";
      /* codcab := '' */
      codcab = "";
      /* provo prima a vedere se è operazione extraconto */
      /* nprog := arfn_delzero(nprog) */
      nprog = arfn_delzeroR.Make(m_Ctx,this).Run(nprog);
      // * --- Read from aeoprig
      m_cServer = m_Ctx.GetServer("aeoprig");
      m_cPhName = m_Ctx.GetPhName("aeoprig");
      m_cSql = "";
      m_cSql = m_cSql+"APROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(nprog,"C",25,0,m_cServer),m_cServer,nprog);
      if (m_Ctx.IsSharedTemp("aeoprig")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("AFILE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CONNESINT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        ident = Read_Cursor.GetString("AFILE");
        connes = Read_Cursor.GetString("CONNESINT");
        rapporto = Read_Cursor.GetString("RAPPORTO");
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on aeoprig into routine arrt_imp_esiti returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        ident = "";
        connes = "";
        rapporto = "";
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
      /* If ident='' */
      if (CPLib.eqr(ident,"")) {
        // * --- Read from aeoprig
        m_cServer = m_Ctx.GetServer("aeoprig");
        m_cPhName = m_Ctx.GetPhName("aeoprig");
        m_cSql = "";
        m_cSql = m_cSql+"COLDPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(nprog,"C",25,0,m_cServer),m_cServer,nprog);
        if (m_Ctx.IsSharedTemp("aeoprig")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("COLDFILE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CONNESINT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          ident = Read_Cursor.GetString("COLDFILE");
          connes = Read_Cursor.GetString("CONNESINT");
          rapporto = Read_Cursor.GetString("RAPPORTO");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on aeoprig into routine arrt_imp_esiti returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          ident = "";
          connes = "";
          rapporto = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If ident='' */
        if (CPLib.eqr(ident,"")) {
          /* allora forse è una apertura delega */
          // * --- Read from aederig
          m_cServer = m_Ctx.GetServer("aederig");
          m_cPhName = m_Ctx.GetPhName("aederig");
          m_cSql = "";
          m_cSql = m_cSql+"APROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(nprog,"C",25,0,m_cServer),m_cServer,nprog);
          if (m_Ctx.IsSharedTemp("aederig")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("AFILE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CONNESINT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            ident = Read_Cursor.GetString("AFILE");
            connes = Read_Cursor.GetString("CONNESINT");
            rapporto = Read_Cursor.GetString("RAPPORTO");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on aederig into routine arrt_imp_esiti returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            ident = "";
            connes = "";
            rapporto = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If ident='' */
          if (CPLib.eqr(ident,"")) {
            // * --- Read from aeopcanc
            m_cServer = m_Ctx.GetServer("aeopcanc");
            m_cPhName = m_Ctx.GetPhName("aeopcanc");
            m_cSql = "";
            m_cSql = m_cSql+"IDPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(nprog,"C",25,0,m_cServer),m_cServer,nprog);
            if (m_Ctx.IsSharedTemp("aeopcanc")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("AFILE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CONNESINT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              ident = Read_Cursor.GetString("AFILE");
              connes = Read_Cursor.GetString("CONNESINT");
              rapporto = Read_Cursor.GetString("RAPPORTO");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on aeopcanc into routine arrt_imp_esiti returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              ident = "";
              connes = "";
              rapporto = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If ident='' */
            if (CPLib.eqr(ident,"")) {
              // * --- Read from aedecanc
              m_cServer = m_Ctx.GetServer("aedecanc");
              m_cPhName = m_Ctx.GetPhName("aedecanc");
              m_cSql = "";
              m_cSql = m_cSql+"IDPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(nprog,"C",25,0,m_cServer),m_cServer,nprog);
              if (m_Ctx.IsSharedTemp("aedecanc")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("AFILE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CONNESINT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                ident = Read_Cursor.GetString("AFILE");
                connes = Read_Cursor.GetString("CONNESINT");
                rapporto = Read_Cursor.GetString("RAPPORTO");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on aedecanc into routine arrt_imp_esiti returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                ident = "";
                connes = "";
                rapporto = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* tipoac := 'D' */
              tipoac = "D";
            } else { // Else
              /* tipoac := 'O' */
              tipoac = "O";
            } // End If
          } else { // Else
            /* tipoac := 'D' */
            tipoac = "D";
          } // End If
        } else { // Else
          /* operazione extraconto */
          /* tipoac := 'O' */
          tipoac = "O";
        } // End If
      } else { // Else
        /* operazione extraconto */
        /* tipoac := 'O' */
        tipoac = "O";
      } // End If
      /* If ident='' */
      if (CPLib.eqr(ident,"")) {
        /* lettura chiusura delega */
        // * --- Read from aederig
        m_cServer = m_Ctx.GetServer("aederig");
        m_cPhName = m_Ctx.GetPhName("aederig");
        m_cSql = "";
        m_cSql = m_cSql+"APROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(nprog,"C",25,0,m_cServer),m_cServer,nprog);
        if (m_Ctx.IsSharedTemp("aederig")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("AFILE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CONNESINT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          ident = Read_Cursor.GetString("AFILE");
          connes = Read_Cursor.GetString("CONNESINT");
          rapporto = Read_Cursor.GetString("RAPPORTO");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on aederig into routine arrt_imp_esiti returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          ident = "";
          connes = "";
          rapporto = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
      } else { // Else
        /* If tipoac='' */
        if (CPLib.eqr(tipoac,"")) {
          /* apertura delega */
          /* tipoac := 'D' */
          tipoac = "D";
        } // End If
      } // End If
      /* If ident='' */
      if (CPLib.eqr(ident,"")) {
        /* non trovato nulla */
        // * --- Write into tmp_impesiti from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_impesiti");
        m_cPhName = m_Ctx.GetPhName("tmp_impesiti");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_impesiti",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_esiti",269,"000000E8")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"rapporto = "+CPLib.ToSQL("Rapporto non individuato","C",25,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_impesiti",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"idbase = "+CPSql.SQLValueAdapter(CPLib.ToSQL(idbase,"?",0,0,m_cServer),m_cServer,idbase)+"";
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
        /* If tipoac='' */
        if (CPLib.eqr(tipoac,"")) {
          /* chiusura delega */
          /* tipoac := 'E' */
          tipoac = "E";
        } // End If
        /* quindi dovrebbe averlo trovato */
        // * --- Read from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        m_cSql = "";
        m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(connes,"C",16,0,m_cServer),m_cServer,connes);
        if (m_Ctx.IsSharedTemp("personbo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAGSOC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("COGNOME",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("NOME",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("SESSO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DATANASC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("NASCOMUN",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("TIPINTER",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODCAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("NASSTATO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          ragsoc = Read_Cursor.GetString("RAGSOC");
          cognome = Read_Cursor.GetString("COGNOME");
          nome = Read_Cursor.GetString("NOME");
          sesso = Read_Cursor.GetString("SESSO");
          datanasc = Read_Cursor.GetDate("DATANASC");
          nascomun = Read_Cursor.GetString("NASCOMUN");
          tipinter = Read_Cursor.GetString("TIPINTER");
          desccit = Read_Cursor.GetString("DESCCIT");
          provincia = Read_Cursor.GetString("PROVINCIA");
          codfisc = Read_Cursor.GetString("CODFISC");
          codcab = Read_Cursor.GetString("CODCAB");
          nasstato = Read_Cursor.GetString("NASSTATO");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on personbo into routine arrt_imp_esiti returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          ragsoc = "";
          cognome = "";
          nome = "";
          sesso = "";
          datanasc = CPLib.NullDate();
          nascomun = "";
          tipinter = "";
          desccit = "";
          provincia = "";
          codfisc = "";
          codcab = "";
          nasstato = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If LRTrim(sesso)='' */
        if (CPLib.eqr(CPLib.LRTrim(sesso),"")) {
          /* persona := 'Giuridica' */
          persona = "Giuridica";
        } else { // Else
          /* persona := 'Fisica' */
          persona = "Fisica";
        } // End If
        // * --- Write into tmp_impesiti from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_impesiti");
        m_cPhName = m_Ctx.GetPhName("tmp_impesiti");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_impesiti",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_esiti",269,"000000F1")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"trueident = "+CPLib.ToSQL(ident,"C",15,0,m_cServer)+", ";
        m_cSql = m_cSql+"ragsoc = "+CPLib.ToSQL(ragsoc,"C",70,0,m_cServer)+", ";
        m_cSql = m_cSql+"rapporto = "+CPLib.ToSQL(rapporto,"C",25,0,m_cServer)+", ";
        m_cSql = m_cSql+"connes = "+CPLib.ToSQL(connes,"C",16,0,m_cServer)+", ";
        m_cSql = m_cSql+"tipoac = "+CPLib.ToSQL(tipoac,"C",1,0,m_cServer)+", ";
        m_cSql = m_cSql+"persona = "+CPLib.ToSQL(persona,"C",10,0,m_cServer)+", ";
        m_cSql = m_cSql+"cognome = "+CPLib.ToSQL(cognome,"C",26,0,m_cServer)+", ";
        m_cSql = m_cSql+"nome = "+CPLib.ToSQL(nome,"C",25,0,m_cServer)+", ";
        m_cSql = m_cSql+"sesso = "+CPLib.ToSQL(sesso,"C",1,0,m_cServer)+", ";
        m_cSql = m_cSql+"datanasc = "+CPLib.ToSQL(datanasc,"D",8,0)+", ";
        m_cSql = m_cSql+"nascomun = "+CPLib.ToSQL((CPLib.eqr(tipinter,"EE")?nasstato:nascomun),"C",40,0,m_cServer)+", ";
        m_cSql = m_cSql+"tipinter = "+CPLib.ToSQL(tipinter,"C",2,0,m_cServer)+", ";
        m_cSql = m_cSql+"desccit = "+CPLib.ToSQL(desccit,"C",40,0,m_cServer)+", ";
        m_cSql = m_cSql+"provincia = "+CPLib.ToSQL(provincia,"C",2,0,m_cServer)+", ";
        m_cSql = m_cSql+"codfisc = "+CPLib.ToSQL(codfisc,"C",16,0,m_cServer)+", ";
        m_cSql = m_cSql+"codcab = "+CPLib.ToSQL(codcab,"C",6,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_impesiti",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"idbase = "+CPSql.SQLValueAdapter(CPLib.ToSQL(idbase,"?",0,0,m_cServer),m_cServer,idbase)+"";
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
  void Page_5() throws Exception {
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
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_list_imprich",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_esiti",269,"000000F9")+"delete from "+m_oWrInfo.GetTableWriteName();
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"nomefile = "+CPSql.SQLValueAdapter(CPLib.ToSQL(czipfile,"?",0,0,m_cServer),m_cServer,czipfile)+"";
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
      /* contanome := 0 */
      contanome = 0;
      /* While contanome<conteggio */
      while (CPLib.lt(contanome,conteggio)) {
        buffernomefile=lista[contanome];
        // * --- Insert into tmp_list_imprich from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_list_imprich");
        m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_list_imprich",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_esiti",269,"000000FD")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_000000FD(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(buffernomefile,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
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
      /* FileLibMit.DeleteFile('./appo/'+czipfile) */
      FileLibMit.DeleteFile("./appo/"+czipfile);
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
      m_Caller.SetString("msgproc","M",10,0,w_msgproc);
      m_Caller.SetNumber("scelta","N",1,0,w_scelta);
      m_Caller.SetNumber("impzip","N",1,0,w_impzip);
      m_Caller.SetString("gMsgProc","M",10,0,gMsgProc);
      m_Caller.SetString("nomefile","C",100,0,w_nomefile);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_imp_esitiR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_imp_esitiR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_msgproc = m_Caller.GetString("msgproc","M",10,0);
    w_scelta = m_Caller.GetNumber("scelta","N",1,0);
    w_impzip = m_Caller.GetNumber("impzip","N",1,0);
    gMsgProc = m_Caller.GetString("gMsgProc","M",10,0);
    w_nomefile = m_Caller.GetString("nomefile","C",100,0);
    fhand = CPLib.Space(1);
    riga = "";
    _filename = CPLib.Space(30);
    salta = 0;
    findesito = 0;
    nprog = CPLib.Space(25);
    esito = CPLib.Space(200);
    esito2 = CPLib.Space(200);
    idbase = CPLib.Space(10);
    nputf8 = 0;
    npnormal = 0;
    nProgImp = 0;
    _max = 0;
    _min = 0;
    _cicli = 0;
    _contacilci = 0;
    _bottom = 0;
    _top = 0;
    contafile = 0;
    _aprog = CPLib.Space(25);
    _afile = CPLib.Space(15);
    _cprog = CPLib.Space(25);
    _cfile = CPLib.Space(15);
    rapporto = CPLib.Space(25);
    tipoac = CPLib.Space(1);
    connes = CPLib.Space(16);
    ident = CPLib.Space(15);
    ragsoc = CPLib.Space(30);
    persona = CPLib.Space(10);
    cognome = CPLib.Space(26);
    nome = CPLib.Space(25);
    sesso = CPLib.Space(1);
    datanasc = CPLib.NullDate();
    nascomun = CPLib.Space(30);
    nasstato = CPLib.Space(30);
    tipinter = CPLib.Space(2);
    desccit = CPLib.Space(30);
    provincia = CPLib.Space(2);
    codfisc = CPLib.Space(16);
    codcab = CPLib.Space(6);
    czipfile = CPLib.Space(100);
    cpercorsozip = CPLib.Space(200);
    cdirectoryfile = CPLib.Space(200);
    buffernomefile = CPLib.Space(100);
    nomefileimport = CPLib.Space(50);
    _priorita = 0;
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gOkPrintEsiti=m_Ctx.GetGlobalNumber("gOkPrintEsiti");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_tmp_impesiti_max_min,
  public static final String m_cVQRList = ",qbe_tmp_impesiti_max_min,";
  // ENTITY_BATCHES: ,arfn_delzero,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_delzero,arfn_fdatetime,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000072(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"esito,";
    p_cSql = p_cSql+"nprog,";
    p_cSql = p_cSql+"idbase,";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"PROGIMPESITI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_impesiti",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000007E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nprog,";
    p_cSql = p_cSql+"idbase,";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"PROGIMPESITI,";
    p_cSql = p_cSql+"esito,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_impesiti",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000008A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nprog,";
    p_cSql = p_cSql+"idbase,";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"PROGIMPESITI,";
    p_cSql = p_cSql+"esito,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_impesiti",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000FD(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"priorita,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_list_imprich",true);
    return p_cSql;
  }
}
