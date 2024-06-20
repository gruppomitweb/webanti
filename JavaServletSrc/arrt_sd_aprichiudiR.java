// * --- Area Manuale = BO - Header
// * --- arrt_sd_aprichiudi
import java.util.*;
// * --- Fine Area Manuale
public class arrt_sd_aprichiudiR implements CallerWithObjs {
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
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
  public String m_cPhName_aerighe;
  public String m_cServer_aerighe;
  public String m_cPhName_tmp_apecod;
  public String m_cServer_tmp_apecod;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_aefiles;
  public String m_cServer_aefiles;
  public String m_cPhName_tmp_apenocod;
  public String m_cServer_tmp_apenocod;
  public String m_cPhName_tmp_chiunocod;
  public String m_cServer_tmp_chiunocod;
  public String m_cPhName_tmp_chiucod;
  public String m_cServer_tmp_chiucod;
  public String m_cPhName_tmp_stpfileage;
  public String m_cServer_tmp_stpfileage;
  public String m_cPhName_aefiles_glob;
  public String m_cServer_aefiles_glob;
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
  public java.sql.Date w_a_data;
  public java.sql.Date w_dadata;
  public java.sql.Date w_datpri;
  public java.sql.Date w_datsecf;
  public java.sql.Date w_datseci;
  public String w_iniz;
  public String w_seco;
  public double w_files;
  public double w_anno;
  public String w_mese;
  public String w_FILEINVIO;
  public java.sql.Date w_DATAINVIO;
  public String w_CFINVIO;
  public String w_CAFINVIO;
  public String _errlog;
  public double imprec;
  public double _noprot;
  public String _rapold;
  public String _tipoco;
  public double _nriga;
  public double _newrow;
  public String _cdata1;
  public String _cdata2;
  public String _cdata3;
  public String _cdata4;
  public String _descit;
  public String _file;
  public String _nomefile;
  public double _r;
  public double _i;
  public String fhand;
  public String cNomeFile;
  public String cOnlyNomeFile;
  public String cNomeFileZip;
  public String cProg;
  public double _nocodrec;
  public double _sicodrec;
  public double _crow;
  public double _cfile;
  public double _conta;
  public String _cfint;
  public String _ragint;
  public String _citint;
  public String _prvint;
  public String _file1;
  public String _file2;
  public String _czip;
  public double _max;
  public double _min;
  public double _tot;
  public double _mono;
  public double _cicli;
  public double _contacilci;
  public double _bottom;
  public double _top;
  public double nProgImp;
  public double _fileita;
  public double _fileest;
  public double countmp;
  public String _estero;
  public String _cfinvio;
  public String _cafinvio;
  public String _tipinvio;
  public String _impinvio;
  public java.sql.Date _datinvio;
  public String gPathApp;
  public String gIntemediario;
  public String gMsgImp;
  public double gFilesAge;
  public String gAzienda;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_sd_aprichiudi
  // These are the files to include in the ZIP file
  Vector filenames = new Vector();
  Vector fileonames = new Vector();
  
  // * --- Fine Area Manuale
  public arrt_sd_aprichiudiR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_sd_aprichiudi",m_Caller);
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_aetesta = p_ContextObject.GetPhName("aetesta");
    m_cServer_aetesta = p_ContextObject.GetServer("aetesta");
    m_cPhName_aerighe = p_ContextObject.GetPhName("aerighe");
    m_cServer_aerighe = p_ContextObject.GetServer("aerighe");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_apecod")) {
      m_cPhName_tmp_apecod = p_ContextObject.GetPhName("tmp_apecod");
      m_cServer_tmp_apecod = p_ContextObject.GetServer("tmp_apecod");
    }
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_aefiles = p_ContextObject.GetPhName("aefiles");
    m_cServer_aefiles = p_ContextObject.GetServer("aefiles");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_apenocod")) {
      m_cPhName_tmp_apenocod = p_ContextObject.GetPhName("tmp_apenocod");
      m_cServer_tmp_apenocod = p_ContextObject.GetServer("tmp_apenocod");
    }
    if (m_Ctx.IsTmpAlreadyCreated("tmp_chiunocod")) {
      m_cPhName_tmp_chiunocod = p_ContextObject.GetPhName("tmp_chiunocod");
      m_cServer_tmp_chiunocod = p_ContextObject.GetServer("tmp_chiunocod");
    }
    if (m_Ctx.IsTmpAlreadyCreated("tmp_chiucod")) {
      m_cPhName_tmp_chiucod = p_ContextObject.GetPhName("tmp_chiucod");
      m_cServer_tmp_chiucod = p_ContextObject.GetServer("tmp_chiucod");
    }
    if (m_Ctx.IsTmpAlreadyCreated("tmp_stpfileage")) {
      m_cPhName_tmp_stpfileage = p_ContextObject.GetPhName("tmp_stpfileage");
      m_cServer_tmp_stpfileage = p_ContextObject.GetServer("tmp_stpfileage");
    }
    m_cPhName_aefiles_glob = p_ContextObject.GetPhName("aefiles_glob");
    m_cServer_aefiles_glob = p_ContextObject.GetServer("aefiles_glob");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("files",p_cVarName)) {
      return w_files;
    }
    if (CPLib.eqr("anno",p_cVarName)) {
      return w_anno;
    }
    if (CPLib.eqr("imprec",p_cVarName)) {
      return imprec;
    }
    if (CPLib.eqr("_noprot",p_cVarName)) {
      return _noprot;
    }
    if (CPLib.eqr("_nriga",p_cVarName)) {
      return _nriga;
    }
    if (CPLib.eqr("_newrow",p_cVarName)) {
      return _newrow;
    }
    if (CPLib.eqr("_r",p_cVarName)) {
      return _r;
    }
    if (CPLib.eqr("_i",p_cVarName)) {
      return _i;
    }
    if (CPLib.eqr("_nocodrec",p_cVarName)) {
      return _nocodrec;
    }
    if (CPLib.eqr("_sicodrec",p_cVarName)) {
      return _sicodrec;
    }
    if (CPLib.eqr("_crow",p_cVarName)) {
      return _crow;
    }
    if (CPLib.eqr("_cfile",p_cVarName)) {
      return _cfile;
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
    if (CPLib.eqr("_tot",p_cVarName)) {
      return _tot;
    }
    if (CPLib.eqr("_mono",p_cVarName)) {
      return _mono;
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
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      return nProgImp;
    }
    if (CPLib.eqr("_fileita",p_cVarName)) {
      return _fileita;
    }
    if (CPLib.eqr("_fileest",p_cVarName)) {
      return _fileest;
    }
    if (CPLib.eqr("countmp",p_cVarName)) {
      return countmp;
    }
    if (CPLib.eqr("gFilesAge",p_cVarName)) {
      return gFilesAge;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_sd_aprichiudi";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("iniz",p_cVarName)) {
      return w_iniz;
    }
    if (CPLib.eqr("seco",p_cVarName)) {
      return w_seco;
    }
    if (CPLib.eqr("mese",p_cVarName)) {
      return w_mese;
    }
    if (CPLib.eqr("FILEINVIO",p_cVarName)) {
      return w_FILEINVIO;
    }
    if (CPLib.eqr("CFINVIO",p_cVarName)) {
      return w_CFINVIO;
    }
    if (CPLib.eqr("CAFINVIO",p_cVarName)) {
      return w_CAFINVIO;
    }
    if (CPLib.eqr("_errlog",p_cVarName)) {
      return _errlog;
    }
    if (CPLib.eqr("_rapold",p_cVarName)) {
      return _rapold;
    }
    if (CPLib.eqr("_tipoco",p_cVarName)) {
      return _tipoco;
    }
    if (CPLib.eqr("_cdata1",p_cVarName)) {
      return _cdata1;
    }
    if (CPLib.eqr("_cdata2",p_cVarName)) {
      return _cdata2;
    }
    if (CPLib.eqr("_cdata3",p_cVarName)) {
      return _cdata3;
    }
    if (CPLib.eqr("_cdata4",p_cVarName)) {
      return _cdata4;
    }
    if (CPLib.eqr("_descit",p_cVarName)) {
      return _descit;
    }
    if (CPLib.eqr("_file",p_cVarName)) {
      return _file;
    }
    if (CPLib.eqr("_nomefile",p_cVarName)) {
      return _nomefile;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
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
    if (CPLib.eqr("cProg",p_cVarName)) {
      return cProg;
    }
    if (CPLib.eqr("_cfint",p_cVarName)) {
      return _cfint;
    }
    if (CPLib.eqr("_ragint",p_cVarName)) {
      return _ragint;
    }
    if (CPLib.eqr("_citint",p_cVarName)) {
      return _citint;
    }
    if (CPLib.eqr("_prvint",p_cVarName)) {
      return _prvint;
    }
    if (CPLib.eqr("_file1",p_cVarName)) {
      return _file1;
    }
    if (CPLib.eqr("_file2",p_cVarName)) {
      return _file2;
    }
    if (CPLib.eqr("_czip",p_cVarName)) {
      return _czip;
    }
    if (CPLib.eqr("_estero",p_cVarName)) {
      return _estero;
    }
    if (CPLib.eqr("_cfinvio",p_cVarName)) {
      return _cfinvio;
    }
    if (CPLib.eqr("_cafinvio",p_cVarName)) {
      return _cafinvio;
    }
    if (CPLib.eqr("_tipinvio",p_cVarName)) {
      return _tipinvio;
    }
    if (CPLib.eqr("_impinvio",p_cVarName)) {
      return _impinvio;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      return gIntemediario;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("a_data",p_cVarName)) {
      return w_a_data;
    }
    if (CPLib.eqr("dadata",p_cVarName)) {
      return w_dadata;
    }
    if (CPLib.eqr("datpri",p_cVarName)) {
      return w_datpri;
    }
    if (CPLib.eqr("datsecf",p_cVarName)) {
      return w_datsecf;
    }
    if (CPLib.eqr("datseci",p_cVarName)) {
      return w_datseci;
    }
    if (CPLib.eqr("DATAINVIO",p_cVarName)) {
      return w_DATAINVIO;
    }
    if (CPLib.eqr("_datinvio",p_cVarName)) {
      return _datinvio;
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
    if (CPLib.eqr("files",p_cVarName)) {
      w_files = value;
      return;
    }
    if (CPLib.eqr("anno",p_cVarName)) {
      w_anno = value;
      return;
    }
    if (CPLib.eqr("imprec",p_cVarName)) {
      imprec = value;
      return;
    }
    if (CPLib.eqr("_noprot",p_cVarName)) {
      _noprot = value;
      return;
    }
    if (CPLib.eqr("_nriga",p_cVarName)) {
      _nriga = value;
      return;
    }
    if (CPLib.eqr("_newrow",p_cVarName)) {
      _newrow = value;
      return;
    }
    if (CPLib.eqr("_r",p_cVarName)) {
      _r = value;
      return;
    }
    if (CPLib.eqr("_i",p_cVarName)) {
      _i = value;
      return;
    }
    if (CPLib.eqr("_nocodrec",p_cVarName)) {
      _nocodrec = value;
      return;
    }
    if (CPLib.eqr("_sicodrec",p_cVarName)) {
      _sicodrec = value;
      return;
    }
    if (CPLib.eqr("_crow",p_cVarName)) {
      _crow = value;
      return;
    }
    if (CPLib.eqr("_cfile",p_cVarName)) {
      _cfile = value;
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
    if (CPLib.eqr("_tot",p_cVarName)) {
      _tot = value;
      return;
    }
    if (CPLib.eqr("_mono",p_cVarName)) {
      _mono = value;
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
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      nProgImp = value;
      return;
    }
    if (CPLib.eqr("_fileita",p_cVarName)) {
      _fileita = value;
      return;
    }
    if (CPLib.eqr("_fileest",p_cVarName)) {
      _fileest = value;
      return;
    }
    if (CPLib.eqr("countmp",p_cVarName)) {
      countmp = value;
      return;
    }
    if (CPLib.eqr("gFilesAge",p_cVarName)) {
      gFilesAge = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("iniz",p_cVarName)) {
      w_iniz = value;
      return;
    }
    if (CPLib.eqr("seco",p_cVarName)) {
      w_seco = value;
      return;
    }
    if (CPLib.eqr("mese",p_cVarName)) {
      w_mese = value;
      return;
    }
    if (CPLib.eqr("FILEINVIO",p_cVarName)) {
      w_FILEINVIO = value;
      return;
    }
    if (CPLib.eqr("CFINVIO",p_cVarName)) {
      w_CFINVIO = value;
      return;
    }
    if (CPLib.eqr("CAFINVIO",p_cVarName)) {
      w_CAFINVIO = value;
      return;
    }
    if (CPLib.eqr("_errlog",p_cVarName)) {
      _errlog = value;
      return;
    }
    if (CPLib.eqr("_rapold",p_cVarName)) {
      _rapold = value;
      return;
    }
    if (CPLib.eqr("_tipoco",p_cVarName)) {
      _tipoco = value;
      return;
    }
    if (CPLib.eqr("_cdata1",p_cVarName)) {
      _cdata1 = value;
      return;
    }
    if (CPLib.eqr("_cdata2",p_cVarName)) {
      _cdata2 = value;
      return;
    }
    if (CPLib.eqr("_cdata3",p_cVarName)) {
      _cdata3 = value;
      return;
    }
    if (CPLib.eqr("_cdata4",p_cVarName)) {
      _cdata4 = value;
      return;
    }
    if (CPLib.eqr("_descit",p_cVarName)) {
      _descit = value;
      return;
    }
    if (CPLib.eqr("_file",p_cVarName)) {
      _file = value;
      return;
    }
    if (CPLib.eqr("_nomefile",p_cVarName)) {
      _nomefile = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
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
    if (CPLib.eqr("cProg",p_cVarName)) {
      cProg = value;
      return;
    }
    if (CPLib.eqr("_cfint",p_cVarName)) {
      _cfint = value;
      return;
    }
    if (CPLib.eqr("_ragint",p_cVarName)) {
      _ragint = value;
      return;
    }
    if (CPLib.eqr("_citint",p_cVarName)) {
      _citint = value;
      return;
    }
    if (CPLib.eqr("_prvint",p_cVarName)) {
      _prvint = value;
      return;
    }
    if (CPLib.eqr("_file1",p_cVarName)) {
      _file1 = value;
      return;
    }
    if (CPLib.eqr("_file2",p_cVarName)) {
      _file2 = value;
      return;
    }
    if (CPLib.eqr("_czip",p_cVarName)) {
      _czip = value;
      return;
    }
    if (CPLib.eqr("_estero",p_cVarName)) {
      _estero = value;
      return;
    }
    if (CPLib.eqr("_cfinvio",p_cVarName)) {
      _cfinvio = value;
      return;
    }
    if (CPLib.eqr("_cafinvio",p_cVarName)) {
      _cafinvio = value;
      return;
    }
    if (CPLib.eqr("_tipinvio",p_cVarName)) {
      _tipinvio = value;
      return;
    }
    if (CPLib.eqr("_impinvio",p_cVarName)) {
      _impinvio = value;
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
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("a_data",p_cVarName)) {
      w_a_data = value;
      return;
    }
    if (CPLib.eqr("dadata",p_cVarName)) {
      w_dadata = value;
      return;
    }
    if (CPLib.eqr("datpri",p_cVarName)) {
      w_datpri = value;
      return;
    }
    if (CPLib.eqr("datsecf",p_cVarName)) {
      w_datsecf = value;
      return;
    }
    if (CPLib.eqr("datseci",p_cVarName)) {
      w_datseci = value;
      return;
    }
    if (CPLib.eqr("DATAINVIO",p_cVarName)) {
      w_DATAINVIO = value;
      return;
    }
    if (CPLib.eqr("_datinvio",p_cVarName)) {
      _datinvio = value;
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
      /* w_a_data Date */
      /* w_dadata Date */
      /* w_datpri Date */
      /* w_datsecf Date */
      /* w_datseci Date */
      /* w_iniz Char(1) */
      /* w_seco Char(1) */
      /* w_files Numeric(1, 0) */
      /* w_anno Numeric(4, 0) // Anno riferimento */
      /* w_mese Char(2) // Anno riferimento */
      /* w_FILEINVIO Char(1) // Tipo Preparazione FIle */
      /* w_DATAINVIO Date // Data Impegno Organo Invio */
      /* w_CFINVIO Char(16) // Codice Fiscale Organo Invio File */
      /* w_CAFINVIO Char(5) // Codice CAF Organo Invio */
      /* _errlog Memo */
      /* imprec Numeric(10, 0) */
      /* _noprot Numeric(1, 0) */
      /* _rapold Char(25) */
      /* _tipoco Char(1) */
      /* _nriga Numeric(4, 0) */
      /* _newrow Numeric(4, 0) */
      /* _cdata1 Char(8) */
      /* _cdata2 Char(8) */
      /* _cdata3 Char(8) */
      /* _cdata4 Char(8) */
      /* _descit Char(40) */
      /* _file Memo */
      /* _nomefile Char(15) */
      /* _r Numeric(15, 0) */
      /* _i Numeric(15, 0) */
      /* fhand Char(10) */
      /* cNomeFile Char(30) */
      /* cOnlyNomeFile Char(30) */
      /* cNomeFileZip Char(30) */
      /* cProg Char(10) */
      /* _nocodrec Numeric(10, 0) // Conteggio rapporti con soggetti esteri */
      /* _sicodrec Numeric(10, 0) // Conteggio rapporti con soggetti italiani */
      /* _crow Numeric(10, 0) */
      /* _cfile Numeric(10, 0) */
      /* _conta Numeric(10, 0) */
      /* _cfint Char(16) */
      /* _ragint Char(70) */
      /* _citint Char(40) */
      /* _prvint Char(2) */
      /* _file1 Char(30) */
      /* _file2 Char(30) */
      /* _czip Char(20) */
      /* _max Numeric(15, 0) */
      /* _min Numeric(15, 0) */
      /* _tot Numeric(15, 0) */
      /* _mono Numeric(1, 0) */
      /* _cicli Numeric(15, 0) */
      /* _contacilci Numeric(15, 0) */
      /* _bottom Numeric(15, 0) */
      /* _top Numeric(15, 0) */
      /* nProgImp Numeric(15, 0) */
      /* _fileita Numeric(3, 0) // Conteggio file soggetti italiani */
      /* _fileest Numeric(3, 0) // Conteggio file soggetti esteri */
      /* countmp Numeric(15, 0) // Contatore delle occorenze inserite nel temporaneo */
      /* _estero Char(1) */
      /* _cfinvio Char(16) */
      /* _cafinvio Char(5) */
      /* _tipinvio Char(1) */
      /* _impinvio Char(8) */
      /* _datinvio Date */
      /* gPathApp Char(80) // Path Applicazione */
      /* gIntemediario Char(11) // Intermediario */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gFilesAge Numeric(1, 0) // Visualizzazione file prodotti per age */
      /* gAzienda Char(10) // Azienda */
      /* Verifica la casistica */
      /* _r := 0 */
      _r = CPLib.Round(0,0);
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _r := intermbo->CONTATORE */
        _r = CPLib.Round(Cursor_intermbo.GetDouble("CONTATORE"),0);
        /* _cfint := intermbo->CODFISC */
        _cfint = Cursor_intermbo.GetString("CODFISC");
        /* _ragint := arfn_agechar(intermbo->RAGSOC,' ') */
        _ragint = arfn_agecharR.Make(m_Ctx,this).Run(Cursor_intermbo.GetString("RAGSOC")," ");
        /* _citint := arfn_agechar(intermbo->DESCCIT,' ') */
        _citint = arfn_agecharR.Make(m_Ctx,this).Run(Cursor_intermbo.GetString("DESCCIT")," ");
        /* _prvint := intermbo->PROVINCIA */
        _prvint = Cursor_intermbo.GetString("PROVINCIA");
        /* _cfinvio := intermbo->CFINVIO */
        _cfinvio = Cursor_intermbo.GetString("CFINVIO");
        /* _cafinvio := LRTrim(intermbo->CAFINVIO) */
        _cafinvio = CPLib.LRTrim(Cursor_intermbo.GetString("CAFINVIO"));
        /* _tipinvio := intermbo->FILEINVIO */
        _tipinvio = Cursor_intermbo.GetString("FILEINVIO");
        /* _datinvio := intermbo->DATAINVIO */
        _datinvio = Cursor_intermbo.GetDate("DATAINVIO");
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* _cfinvio := iif(not(Empty(w_CFINVIO)) and LRTrim(w_CFINVIO) <> LRTrim(_cfinvio),w_CFINVIO,_cfinvio) */
      _cfinvio = ( ! (CPLib.Empty(w_CFINVIO)) && CPLib.ne(CPLib.LRTrim(w_CFINVIO),CPLib.LRTrim(_cfinvio))?w_CFINVIO:_cfinvio);
      /* _cafinvio := iif(not(Empty(w_CAFINVIO)) and LRTrim(w_CAFINVIO) <> LRTrim(_cafinvio),LRTrim(w_CAFINVIO),LRTrim(_cafinvio)) */
      _cafinvio = ( ! (CPLib.Empty(w_CAFINVIO)) && CPLib.ne(CPLib.LRTrim(w_CAFINVIO),CPLib.LRTrim(_cafinvio))?CPLib.LRTrim(w_CAFINVIO):CPLib.LRTrim(_cafinvio));
      /* If Empty(LRTrim(_cfinvio)) and Empty(LRTrim(_cafinvio)) */
      if (CPLib.Empty(CPLib.LRTrim(_cfinvio)) && CPLib.Empty(CPLib.LRTrim(_cafinvio))) {
        /* _tipinvio := ' ' */
        _tipinvio = " ";
        /* _impinvio := Space(8) */
        _impinvio = CPLib.Space(8);
      } else { // Else
        /* Case Empty(_datinvio) and Empty(w_DATAINVIO) */
        if (CPLib.Empty(_datinvio) && CPLib.Empty(w_DATAINVIO)) {
          /* _impinvio := DateToChar(Date()) */
          _impinvio = CPLib.DateToChar(CPLib.Date());
          /* Case not(Empty(_datinvio)) and Empty(w_DATAINVIO) */
        } else if ( ! (CPLib.Empty(_datinvio)) && CPLib.Empty(w_DATAINVIO)) {
          /* _impinvio := DateToChar(_datinvio) */
          _impinvio = CPLib.DateToChar(_datinvio);
          /* Case Empty(_datinvio) and not(Empty(w_DATAINVIO)) */
        } else if (CPLib.Empty(_datinvio) &&  ! (CPLib.Empty(w_DATAINVIO))) {
          /* _impinvio := DateToChar(w_DATAINVIO) */
          _impinvio = CPLib.DateToChar(w_DATAINVIO);
          /* Case not(Empty(_datinvio)) and not(Empty(w_DATAINVIO)) */
        } else if ( ! (CPLib.Empty(_datinvio)) &&  ! (CPLib.Empty(w_DATAINVIO))) {
          /* If w_DATAINVIO <> _datinvio */
          if (CPLib.ne(w_DATAINVIO,_datinvio)) {
            /* _impinvio := DateToChar(w_DATAINVIO) */
            _impinvio = CPLib.DateToChar(w_DATAINVIO);
          } else { // Else
            /* _impinvio := DateToChar(_datinvio) */
            _impinvio = CPLib.DateToChar(_datinvio);
          } // End If
        } // End Case
        /* _tipinvio := iif(not(Empty(w_FILEINVIO)) and LRTrim(w_FILEINVIO) <> LRTrim(_tipinvio),w_FILEINVIO,_tipinvio) */
        _tipinvio = ( ! (CPLib.Empty(w_FILEINVIO)) && CPLib.ne(CPLib.LRTrim(w_FILEINVIO),CPLib.LRTrim(_tipinvio))?w_FILEINVIO:_tipinvio);
        /* _impinvio := Substr(_impinvio,7,2)+Substr(_impinvio,5,2)+Left(_impinvio,4) */
        _impinvio = CPLib.Substr(_impinvio,7,2)+CPLib.Substr(_impinvio,5,2)+CPLib.Left(_impinvio,4);
      } // End If
      /* Crea file per stampa contenuto file */
      /* _cfinvio := arfn_agechar(_cfinvio,' ') */
      _cfinvio = arfn_agecharR.Make(m_Ctx,this).Run(_cfinvio," ");
      /* _cafinvio := arfn_agechar(_cafinvio,' ') */
      _cafinvio = arfn_agecharR.Make(m_Ctx,this).Run(_cafinvio," ");
      /* _tipinvio := arfn_agechar(_tipinvio,' ') */
      _tipinvio = arfn_agecharR.Make(m_Ctx,this).Run(_tipinvio," ");
      // * --- Drop temporary table tmp_stpfileage
      if (m_Ctx.IsSharedTemp("tmp_stpfileage")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_stpfileage")) {
          m_cServer = m_Ctx.GetServer("tmp_stpfileage");
          m_cPhName = m_Ctx.GetPhName("tmp_stpfileage");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_stpfileage");
      }
      // * --- Create temporary table tmp_stpfileage
      if (m_Ctx.IsSharedTemp("tmp_stpfileage")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_stpfileage")) {
          m_cServer = m_Ctx.GetServer("tmp_stpfileage");
          m_cPhName = m_Ctx.GetPhName("tmp_stpfileage");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_stpfileage");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_stpfileage");
      if ( ! (m_Ctx.IsSharedTemp("tmp_stpfileage"))) {
        m_cServer = m_Ctx.GetServer("tmp_stpfileage");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_stpfileage",m_cServer,"proto")),m_cPhName,"tmp_stpfileage",m_Ctx);
      }
      m_cPhName_tmp_stpfileage = m_cPhName;
      /* Crea i file */
      /* Exec "Aperture" Page 2:Page_2 */
      Page_2();
      /* Exec "Chiusure" Page 3:Page_3 */
      Page_3();
      // * --- Write into intermbo from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = "Update "+m_cPhName+" set ";
      m_cSql = m_cSql+"CONTATORE = "+CPLib.ToSQL(_r,"N",15,0)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intermbo",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gIntemediario,"?",0,0,m_cServer),m_cServer,gIntemediario)+"";
      if (m_Ctx.IsSharedTemp("intermbo")) {
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
      /* gFilesAge := 1 // Visualizzazione file prodotti per age */
      gFilesAge = CPLib.Round(1,0);
      m_Ctx.SetGlobalNumber("gFilesAge",gFilesAge);
      /* If Empty(LRTrim(_errlog)) */
      if (CPLib.Empty(CPLib.LRTrim(_errlog))) {
        /* gMsgImp := 'Elaborazione Terminata. Premere il bottone per prelevare i file' // Messaggio Import */
        gMsgImp = "Elaborazione Terminata. Premere il bottone per prelevare i file";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* w_files := 1 */
        w_files = CPLib.Round(1,0);
      } else { // Else
        /* gMsgImp := _errlog // Messaggio Import */
        gMsgImp = _errlog;
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } // End If
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
    CPResultSet Cursor_qbe_scadat_ape_3_max_min=null;
    CPResultSet Cursor_qbe_scadat_ape_3=null;
    CPResultSet Cursor_tmp_apecod=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_tmp_apenocod=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Invii Periodici */
      // * --- Drop temporary table tmp_apecod
      if (m_Ctx.IsSharedTemp("tmp_apecod")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_apecod")) {
          m_cServer = m_Ctx.GetServer("tmp_apecod");
          m_cPhName = m_Ctx.GetPhName("tmp_apecod");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_apecod");
      }
      // * --- Create temporary table tmp_apecod
      if (m_Ctx.IsSharedTemp("tmp_apecod")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_apecod")) {
          m_cServer = m_Ctx.GetServer("tmp_apecod");
          m_cPhName = m_Ctx.GetPhName("tmp_apecod");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_apecod");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_apecod");
      if ( ! (m_Ctx.IsSharedTemp("tmp_apecod"))) {
        m_cServer = m_Ctx.GetServer("tmp_apecod");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_apecod",m_cServer,"proto")),m_cPhName,"tmp_apecod",m_Ctx,new String[]{"RAPPORTO"});
      }
      m_cPhName_tmp_apecod = m_cPhName;
      // * --- Drop temporary table tmp_apenocod
      if (m_Ctx.IsSharedTemp("tmp_apenocod")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_apenocod")) {
          m_cServer = m_Ctx.GetServer("tmp_apenocod");
          m_cPhName = m_Ctx.GetPhName("tmp_apenocod");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_apenocod");
      }
      // * --- Create temporary table tmp_apenocod
      if (m_Ctx.IsSharedTemp("tmp_apenocod")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_apenocod")) {
          m_cServer = m_Ctx.GetServer("tmp_apenocod");
          m_cPhName = m_Ctx.GetPhName("tmp_apenocod");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_apenocod");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_apenocod");
      if ( ! (m_Ctx.IsSharedTemp("tmp_apenocod"))) {
        m_cServer = m_Ctx.GetServer("tmp_apenocod");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_apenocod",m_cServer,"proto")),m_cPhName,"tmp_apenocod",m_Ctx,new String[]{"RAPPORTO"});
      }
      m_cPhName_tmp_apenocod = m_cPhName;
      /* _nocodrec := 0 // Conteggio rapporti con soggetti esteri */
      _nocodrec = CPLib.Round(0,0);
      /* _sicodrec := 0 // Conteggio rapporti con soggetti italiani */
      _sicodrec = CPLib.Round(0,0);
      /* _fileita := 0 // Conteggio file soggetti italiani */
      _fileita = CPLib.Round(0,0);
      /* _fileest := 0 // Conteggio file soggetti esteri */
      _fileest = CPLib.Round(0,0);
      /* countmp := 0 // Contatore delle occorenze inserite nel temporaneo */
      countmp = CPLib.Round(0,0);
      /* _max := 0 */
      _max = CPLib.Round(0,0);
      /* _min := 0 */
      _min = CPLib.Round(0,0);
      /* _tot := 0 */
      _tot = CPLib.Round(0,0);
      /* _mono := 0 */
      _mono = CPLib.Round(0,0);
      /* gMsgImp := 'Verifica Rapporti da elaborare ...' // Messaggio Import */
      gMsgImp = "Verifica Rapporti da elaborare ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* Prima gli italiani */
      /* _estero := 'N' */
      _estero = "N";
      // * --- Select from qbe_scadat_ape_3_max_min
      if (Cursor_qbe_scadat_ape_3_max_min!=null)
        Cursor_qbe_scadat_ape_3_max_min.Close();
      Cursor_qbe_scadat_ape_3_max_min = new VQRHolder("qbe_scadat_ape_3_max_min",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_scadat_ape_3_max_min.Eof())) {
        /* _max := qbe_scadat_ape_3_max_min->MAXPROGAER */
        _max = CPLib.Round(Cursor_qbe_scadat_ape_3_max_min.GetDouble("MAXPROGAER"),0);
        /* _min := qbe_scadat_ape_3_max_min->MINPROGAER */
        _min = CPLib.Round(Cursor_qbe_scadat_ape_3_max_min.GetDouble("MINPROGAER"),0);
        /* _tot := qbe_scadat_ape_3_max_min->TOTPROGAER */
        _tot = CPLib.Round(Cursor_qbe_scadat_ape_3_max_min.GetDouble("TOTPROGAER"),0);
        Cursor_qbe_scadat_ape_3_max_min.Next();
      }
      m_cConnectivityError = Cursor_qbe_scadat_ape_3_max_min.ErrorMessage();
      Cursor_qbe_scadat_ape_3_max_min.Close();
      // * --- End Select
      /* _mono := iif(_tot > 75000,0,1) */
      _mono = CPLib.Round((CPLib.gt(_tot,75000)?0:1),0);
      /* If _mono = 1 */
      if (CPLib.eqr(_mono,1)) {
        /* If _tot = 0 */
        if (CPLib.eqr(_tot,0)) {
          /* _cicli := 0 */
          _cicli = CPLib.Round(0,0);
        } else { // Else
          /* _cicli := 1 */
          _cicli = CPLib.Round(1,0);
        } // End If
      } else { // Else
        /* _cicli := iif(Mod(_max,5000) <> 0,Int(_max/5000) + 1,Int(_max/5000)) */
        _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,5000),0)?CPLib.Int(_max/5000)+1:CPLib.Int(_max/5000)),0);
      } // End If
      /* _contacilci := 1 */
      _contacilci = CPLib.Round(1,0);
      /* gMsgImp := 'Lettura rapporti in corso ...' // Messaggio Import */
      gMsgImp = "Lettura rapporti in corso ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* _czip := DateTimeToChar(DateTime())+"_1.zip" */
      _czip = CPLib.DateTimeToChar(CPLib.DateTime())+"_1.zip";
      /* cNomeFileZip := LRTrim(gPathApp)+'/flussi/'+LRTrim(gAzienda)+"/"+_czip */
      cNomeFileZip = CPLib.LRTrim(gPathApp)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+_czip;
      /* While _contacilci<=_cicli */
      while (CPLib.le(_contacilci,_cicli)) {
        /* If _mono = 1 */
        if (CPLib.eqr(_mono,1)) {
          /* _bottom := _min */
          _bottom = CPLib.Round(_min,0);
          /* _top := _max */
          _top = CPLib.Round(_max,0);
        } else { // Else
          /* _bottom := ((_contacilci -1 ) * 5000) + 1 */
          _bottom = CPLib.Round(((_contacilci-1)*5000)+1,0);
          /* _top := _contacilci * 5000 */
          _top = CPLib.Round(_contacilci*5000,0);
        } // End If
        /* gMsgImp := 'Lettura rapporti in corso ... Ciclo N. '+LRTrim(Str(_contacilci,10,0)) // Messaggio Import */
        gMsgImp = "Lettura rapporti in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacilci,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If _top>=_min */
        if (CPLib.ge(_top,_min)) {
          // * --- Select from qbe_scadat_ape_3
          if (Cursor_qbe_scadat_ape_3!=null)
            Cursor_qbe_scadat_ape_3.Close();
          Cursor_qbe_scadat_ape_3 = new VQRHolder("qbe_scadat_ape_3",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_scadat_ape_3.Eof())) {
            /* gMsgImp := 'Elaborazione soggetti con CF italiano al ' + LRTrim(Str(((qbe_scadat_ape_3->PROGAER-(_min-1))/(_max-(_min-1)))*100,5,2)) + '%. Sto elaborando il rapporto N° ' + LRTrim(Str(_nocodrec+_sicodrec,10,0)) // Messaggio allineamento 1 */
            gMsgImp = "Elaborazione soggetti con CF italiano al "+CPLib.LRTrim(CPLib.Str(((Cursor_qbe_scadat_ape_3.GetDouble("PROGAER")-(_min-1))/(_max-(_min-1)))*100,5,2))+"%. Sto elaborando il rapporto N° "+CPLib.LRTrim(CPLib.Str(_nocodrec+_sicodrec,10,0));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* If not(Empty(qbe_scadat_ape_3->COGNOME)) and not(Empty(qbe_scadat_ape_3->NOME)) and Len(LRTrim(qbe_scadat_ape_3->SESSO)) = 1 */
            if ( ! (CPLib.Empty(Cursor_qbe_scadat_ape_3.GetString("COGNOME"))) &&  ! (CPLib.Empty(Cursor_qbe_scadat_ape_3.GetString("NOME"))) && CPLib.eqr(CPLib.Len(CPLib.LRTrim(Cursor_qbe_scadat_ape_3.GetString("SESSO"))),1)) {
              /* _cdata1 := Right(DateToChar(qbe_scadat_ape_3->DATANASC),2)+Substr(DateToChar(qbe_scadat_ape_3->DATANASC),5,2)+Left(DateToChar(qbe_scadat_ape_3->DATANASC),4) */
              _cdata1 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_scadat_ape_3.GetDate("DATANASC")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_scadat_ape_3.GetDate("DATANASC")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_scadat_ape_3.GetDate("DATANASC")),4);
              /* _cdata2 := Right(DateToChar(qbe_scadat_ape_3->ADATA),2)+Substr(DateToChar(qbe_scadat_ape_3->ADATA),5,2)+Left(DateToChar(qbe_scadat_ape_3->ADATA),4) */
              _cdata2 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_scadat_ape_3.GetDate("ADATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_scadat_ape_3.GetDate("ADATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_scadat_ape_3.GetDate("ADATA")),4);
              /* _cdata3 := '' */
              _cdata3 = "";
              /* If not(Empty(qbe_scadat_ape_3->NASSTATO)) and Upper(LRTrim(qbe_scadat_ape_3->NASSTATO)) <> 'ITALIA' */
              if ( ! (CPLib.Empty(Cursor_qbe_scadat_ape_3.GetString("NASSTATO"))) && CPLib.ne(CPLib.Upper(CPLib.LRTrim(Cursor_qbe_scadat_ape_3.GetString("NASSTATO"))),"ITALIA")) {
                /* _descit := qbe_scadat_ape_3->NASSTATO */
                _descit = Cursor_qbe_scadat_ape_3.GetString("NASSTATO");
              } else { // Else
                /* _descit := qbe_scadat_ape_3->NASCOMUN */
                _descit = Cursor_qbe_scadat_ape_3.GetString("NASCOMUN");
              } // End If
              /* nProgImp := Utilities.GetAutonumber("PROGAE\'"+LRTrim(gAzienda)+"'",0,15) */
              nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGAE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
              // * --- Insert into tmp_apecod from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_apecod");
              m_cPhName = m_Ctx.GetPhName("tmp_apecod");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_apecod")+" (";
              m_cSql = m_cSql+GetFieldsName_06305458(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_ape_3.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_ape_3.GetString("NOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_qbe_scadat_ape_3.GetString("SESSO"),"F") || CPLib.eqr(Cursor_qbe_scadat_ape_3.GetString("SESSO"),"2")?"F":"M"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_descit,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_ape_3.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_ape_3.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_ape_3.GetString("COINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_ape_3.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata3,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_ape_3.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_ape_3.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
              if (m_Ctx.IsSharedTemp("tmp_apecod")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_apecod",true);
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
              /* _cdata2 := Right(DateToChar(qbe_scadat_ape_3->ADATA),2)+Substr(DateToChar(qbe_scadat_ape_3->ADATA),5,2)+Left(DateToChar(qbe_scadat_ape_3->ADATA),4) */
              _cdata2 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_scadat_ape_3.GetDate("ADATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_scadat_ape_3.GetDate("ADATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_scadat_ape_3.GetDate("ADATA")),4);
              /* _cdata3 := '' */
              _cdata3 = "";
              /* nProgImp := Utilities.GetAutonumber("PROGAE\'"+LRTrim(gAzienda)+"'",0,15) */
              nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGAE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
              // * --- Insert into tmp_apecod from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_apecod");
              m_cPhName = m_Ctx.GetPhName("tmp_apecod");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_apecod")+" (";
              m_cSql = m_cSql+GetFieldsName_0634C018(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_ape_3.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_ape_3.GetString("COINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_ape_3.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata3,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_ape_3.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_qbe_scadat_ape_3.GetString("RAGSOC"),60),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_ape_3.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_ape_3.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_ape_3.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
              if (m_Ctx.IsSharedTemp("tmp_apecod")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_apecod",true);
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
            /* _sicodrec := _sicodrec + 1 */
            _sicodrec = CPLib.Round(_sicodrec+1,0);
            /* countmp := countmp+1 // Contatore delle occorenze inserite nel temporaneo */
            countmp = CPLib.Round(countmp+1,0);
            Cursor_qbe_scadat_ape_3.Next();
          }
          m_cConnectivityError = Cursor_qbe_scadat_ape_3.ErrorMessage();
          Cursor_qbe_scadat_ape_3.Close();
          // * --- End Select
        } else { // Else
          /* gMsgImp := 'Lettura rapporti in corso ...' // Messaggio Import */
          gMsgImp = "Lettura rapporti in corso ...";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } // End If
        /* _contacilci := _contacilci+1 */
        _contacilci = CPLib.Round(_contacilci+1,0);
        /* If Mod(_top,75000)=0 or _contacilci > _cicli */
        if (CPLib.eqr(CPLib.Mod(_top,75000),0) || CPLib.gt(_contacilci,_cicli)) {
          /* If _sicodrec > 0 */
          if (CPLib.gt(_sicodrec,0)) {
            /* Cicla sul file per invii e prepara il file */
            /* _i := 1 */
            _i = CPLib.Round(1,0);
            /* _crow := 0 */
            _crow = CPLib.Round(0,0);
            /* _cfile := 0 */
            _cfile = CPLib.Round(0,0);
            /* _conta := 1 */
            _conta = CPLib.Round(1,0);
            // * --- Select from tmp_apecod
            m_cServer = m_Ctx.GetServer("tmp_apecod");
            m_cPhName = m_Ctx.GetPhName("tmp_apecod");
            if (Cursor_tmp_apecod!=null)
              Cursor_tmp_apecod.Close();
            Cursor_tmp_apecod = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_apecod")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_tmp_apecod.Eof())) {
              /* If _crow = 0 and _i=1 */
              if (CPLib.eqr(_crow,0) && CPLib.eqr(_i,1)) {
                /* Crea Record di testa */
                /* _nomefile := DateTimeToChar(DateTime())+'1' */
                _nomefile = CPLib.DateTimeToChar(CPLib.DateTime())+"1";
                /* cNomeFile := LRTrim(gPathApp)+'/flussi/'+LRTrim(gAzienda)+"/"+LRTrim(_nomefile) */
                cNomeFile = CPLib.LRTrim(gPathApp)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_nomefile);
                /* cOnlyNomeFile := _nomefile */
                cOnlyNomeFile = _nomefile;
                /* _fileita := _fileita + 1 */
                _fileita = CPLib.Round(_fileita+1,0);
                // These are the files to include in the ZIP file
                filenames.add(cNomeFile);
                fileonames.add(cOnlyNomeFile);
                /* fhand := FileLibrary.OpenWrite('./flussi/'+LRTrim(gAzienda)+"/"+LRTrim(_nomefile)) */
                fhand = FileLibrary.OpenWrite("./flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_nomefile));
                /* _file := '0CCB00' + '34' */
                _file = "0CCB00"+"34";
                /* _file := _file + LRTrim(_cfint)+Space(16 - Len(LRTrim(_cfint))) */
                _file = _file+CPLib.LRTrim(_cfint)+CPLib.Space(16-CPLib.Len(CPLib.LRTrim(_cfint)));
                /* _file := _file + Space(102) */
                _file = _file+CPLib.Space(102);
                /* _file := _file + LRTrim(_ragint)+Space(70 - Len(LRTrim(_ragint))) */
                _file = _file+CPLib.LRTrim(_ragint)+CPLib.Space(70-CPLib.Len(CPLib.LRTrim(_ragint)));
                /* _file := _file + LRTrim(_citint)+Space(40 - Len(LRTrim(_citint))) */
                _file = _file+CPLib.LRTrim(_citint)+CPLib.Space(40-CPLib.Len(CPLib.LRTrim(_citint)));
                /* _file := _file + LRTrim(_prvint)+Space(2 - Len(LRTrim(_prvint))) */
                _file = _file+CPLib.LRTrim(_prvint)+CPLib.Space(2-CPLib.Len(CPLib.LRTrim(_prvint)));
                /* _file := _file + Right("0000"+Str(Year(w_a_data),4,0),4)+Right("00"+LRTrim(Str(Month(w_a_data),2,0)),2) */
                _file = _file+CPLib.Right("0000"+CPLib.Str(CPLib.Year(w_a_data),4,0),4)+CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(CPLib.Month(w_a_data),2,0)),2);
                /* _file := _file + '1' */
                _file = _file+"1";
                /* _file := _file + Left(LRTrim(_nomefile)+Space(15),15) */
                _file = _file+CPLib.Left(CPLib.LRTrim(_nomefile)+CPLib.Space(15),15);
                /* _file := _file + Left(LRTrim(_cfinvio)+Space(16),16) */
                _file = _file+CPLib.Left(CPLib.LRTrim(_cfinvio)+CPLib.Space(16),16);
                /* _file := _file + Left(LRTrim(_cafinvio)+Space(5),5) */
                _file = _file+CPLib.Left(CPLib.LRTrim(_cafinvio)+CPLib.Space(5),5);
                /* _file := _file + Left(LRTrim(_tipinvio)+Space(1),1) */
                _file = _file+CPLib.Left(CPLib.LRTrim(_tipinvio)+CPLib.Space(1),1);
                /* _file := _file + Left(LRTrim(_impinvio)+Space(8),8) */
                _file = _file+CPLib.Left(CPLib.LRTrim(_impinvio)+CPLib.Space(8),8);
                /* _file := _file + Space(1507) */
                _file = _file+CPLib.Space(1507);
                /* _file := _file + 'A' */
                _file = _file+"A";
                /* FileLibrary.WriteLine(fhand,_file) */
                FileLibrary.WriteLine(fhand,_file);
              } // End If
              /* gMsgImp := 'Elaborazione soggetti con CF italiano al ' + LRTrim(Str(((_top-(_min-1))/(_max-(_min-1)))*100,5,2)) + '%. Sto scrivendo il file ' + LRTrim(cOnlyNomeFile)+ ' - Riga N° '+ LRTrim(Str(_crow,10,0)) // Messaggio Import */
              gMsgImp = "Elaborazione soggetti con CF italiano al "+CPLib.LRTrim(CPLib.Str(((_top-(_min-1))/(_max-(_min-1)))*100,5,2))+"%. Sto scrivendo il file "+CPLib.LRTrim(cOnlyNomeFile)+" - Riga N° "+CPLib.LRTrim(CPLib.Str(_crow,10,0));
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _r := _r + 1 */
              _r = CPLib.Round(_r+1,0);
              /* If _i = 1 */
              if (CPLib.eqr(_i,1)) {
                /* _file := tmp_apecod->TIPOREC */
                _file = Cursor_tmp_apecod.GetString("TIPOREC");
              } // End If
              // * --- Insert into tmp_stpfileage from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stpfileage");
              m_cPhName = m_Ctx.GetPhName("tmp_stpfileage");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_stpfileage")+" (";
              m_cSql = m_cSql+GetFieldsName_04186960(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_apecod.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(CPLib.Str(_r)),25),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_tmp_apecod.GetString("SESSO"))?Cursor_tmp_apecod.GetString("DENOM"):CPLib.LRTrim(Cursor_tmp_apecod.GetString("COGNOME"))+" "+CPLib.LRTrim(Cursor_tmp_apecod.GetString("NOME"))),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_apecod.GetString("DATAINI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_apecod.GetString("DATACHIU"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_apecod.GetString("COINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_apecod.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_apecod.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("tmp_stpfileage")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpfileage",true);
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
              /* _file := _file + Right("0000000000000000000000000000000000000000" + LRTrim(Str(_r)),25) */
              _file = _file+CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(CPLib.Str(_r)),25);
              /* _file := _file + Left(LRTrim(arfn_agechar(tmp_apecod->CODFISC,' ')) + Space(16),16) */
              _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_tmp_apecod.GetString("CODFISC")," "))+CPLib.Space(16),16);
              /* _file := _file + Left(LRTrim(arfn_agechar(tmp_apecod->COGNOME,' ')) + Space(26),26) */
              _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_tmp_apecod.GetString("COGNOME")," "))+CPLib.Space(26),26);
              /* _file := _file + Left(LRTrim(arfn_agechar(tmp_apecod->NOME,' ')) + Space(25),25) */
              _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_tmp_apecod.GetString("NOME")," "))+CPLib.Space(25),25);
              /* _file := _file + Left(LRTrim(tmp_apecod->SESSO)+Space(1),1) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_apecod.GetString("SESSO"))+CPLib.Space(1),1);
              /* _file := _file + Left(LRTrim(tmp_apecod->DATANASC) + Space(8),8) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_apecod.GetString("DATANASC"))+CPLib.Space(8),8);
              /* _file := _file + Left(LRTrim(arfn_agechar(tmp_apecod->COMSTA,' ')) + Space(40),40) */
              _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_tmp_apecod.GetString("COMSTA")," "))+CPLib.Space(40),40);
              /* _file := _file + Left(LRTrim(arfn_agechar(tmp_apecod->PROVNA,' ')) + Space(2),2) */
              _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_tmp_apecod.GetString("PROVNA")," "))+CPLib.Space(2),2);
              /* _file := _file + Left(LRTrim(arfn_agechar(tmp_apecod->DENOM,' ')) + Space(60),60) */
              _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_tmp_apecod.GetString("DENOM")," "))+CPLib.Space(60),60);
              /* _file := _file + Left(LRTrim(arfn_agechar(tmp_apecod->COMSEDE,' ')) + Space(40),40) */
              _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_tmp_apecod.GetString("COMSEDE")," "))+CPLib.Space(40),40);
              /* _file := _file + Left(LRTrim(arfn_agechar(tmp_apecod->PROVSED,' ')) + Space(2),2) */
              _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_tmp_apecod.GetString("PROVSED")," "))+CPLib.Space(2),2);
              /* _file := _file + Left(LRTrim(tmp_apecod->TIPORAP) + Space(2),2) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_apecod.GetString("TIPORAP"))+CPLib.Space(2),2);
              /* _file := _file + Left(LRTrim(tmp_apecod->COINT) + Space(1),1) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_apecod.GetString("COINT"))+CPLib.Space(1),1);
              /* _file := _file + Left(LRTrim(tmp_apecod->DATAINI) + Space(8),8) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_apecod.GetString("DATAINI"))+CPLib.Space(8),8);
              /* If not(Empty(tmp_apecod->DATACHIU)) and CharToDate(tmp_apecod->DATACHIU) >= w_dadata and CharToDate(tmp_apecod->DATACHIU) <= w_a_data */
              if ( ! (CPLib.Empty(Cursor_tmp_apecod.GetString("DATACHIU"))) && CPLib.ge(CPLib.CharToDate(Cursor_tmp_apecod.GetString("DATACHIU")),w_dadata) && CPLib.le(CPLib.CharToDate(Cursor_tmp_apecod.GetString("DATACHIU")),w_a_data)) {
                /* _file := _file + Left(LRTrim(tmp_apecod->DATACHIU) + Space(8),8) */
                _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_apecod.GetString("DATACHIU"))+CPLib.Space(8),8);
              } else { // Else
                /* _file := _file + Space(8) */
                _file = _file+CPLib.Space(8);
              } // End If
              /* _file := _file + Space(65) */
              _file = _file+CPLib.Space(65);
              /* _file := _file + '*' */
              _file = _file+"*";
              /* _i := _i + 1 */
              _i = CPLib.Round(_i+1,0);
              /* If _i=6 */
              if (CPLib.eqr(_i,6)) {
                /* _i := 1 */
                _i = CPLib.Round(1,0);
                /* _file := _file + Space(146) */
                _file = _file+CPLib.Space(146);
                /* _file := _file + 'A' */
                _file = _file+"A";
                /* FileLibrary.WriteLine(fhand,_file) */
                FileLibrary.WriteLine(fhand,_file);
                /* _crow := _crow + 1 */
                _crow = CPLib.Round(_crow+1,0);
              } // End If
              /* If not(Empty(tmp_apecod->DATACHIU)) and CharToDate(tmp_apecod->DATACHIU) >= w_dadata and CharToDate(tmp_apecod->DATACHIU) <= w_a_data */
              if ( ! (CPLib.Empty(Cursor_tmp_apecod.GetString("DATACHIU"))) && CPLib.ge(CPLib.CharToDate(Cursor_tmp_apecod.GetString("DATACHIU")),w_dadata) && CPLib.le(CPLib.CharToDate(Cursor_tmp_apecod.GetString("DATACHIU")),w_a_data)) {
                // * --- Write into aerighe from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aerighe");
                m_cPhName = m_Ctx.GetPhName("aerighe");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "Update "+m_cPhName+" set ";
                m_cSql = m_cSql+"ASPEDITO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                m_cSql = m_cSql+"APROG = "+CPLib.ToSQL(_r,"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"AFILE = "+CPLib.ToSQL(_nomefile,"C",15,0,m_cServer)+", ";
                m_cSql = m_cSql+"ADTPRE = "+CPLib.ToSQL(w_a_data,"D",8,0)+", ";
                m_cSql = m_cSql+"CSPEDITO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                m_cSql = m_cSql+"CPROG = "+CPLib.ToSQL(_r,"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"CFILE = "+CPLib.ToSQL(_nomefile,"C",15,0,m_cServer)+", ";
                m_cSql = m_cSql+"CDTPRE = "+CPLib.ToSQL(w_a_data,"D",8,0)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_apecod.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_apecod.GetString("IDBASE"))+"";
                if (m_Ctx.IsSharedTemp("aerighe")) {
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
              } else { // Else
                // * --- Write into aerighe from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aerighe");
                m_cPhName = m_Ctx.GetPhName("aerighe");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "Update "+m_cPhName+" set ";
                m_cSql = m_cSql+"ASPEDITO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                m_cSql = m_cSql+"APROG = "+CPLib.ToSQL(_r,"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"AFILE = "+CPLib.ToSQL(_nomefile,"C",15,0,m_cServer)+", ";
                m_cSql = m_cSql+"ADTPRE = "+CPLib.ToSQL(w_a_data,"D",8,0)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_apecod.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_apecod.GetString("IDBASE"))+"";
                if (m_Ctx.IsSharedTemp("aerighe")) {
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
              } // End If
              /* If _crow=15000 */
              if (CPLib.eqr(_crow,15000)) {
                /* If _i > 1 and _i < 6 */
                if (CPLib.gt(_i,1) && CPLib.lt(_i,6)) {
                  /* While _i < 6 */
                  while (CPLib.lt(_i,6)) {
                    /* _file := _file + Space(329) */
                    _file = _file+CPLib.Space(329);
                    /* _file := _file + '*' */
                    _file = _file+"*";
                    /* _i := _i + 1 */
                    _i = CPLib.Round(_i+1,0);
                  } // End While
                  /* _file := _file + Space(146) */
                  _file = _file+CPLib.Space(146);
                  /* _file := _file + 'A' */
                  _file = _file+"A";
                  /* FileLibrary.WriteLine(fhand,_file) */
                  FileLibrary.WriteLine(fhand,_file);
                } // End If
                /* _file := '9CCB00' + '34' */
                _file = "9CCB00"+"34";
                /* _file := _file + LRTrim(_cfint)+Space(16 - Len(LRTrim(_cfint))) */
                _file = _file+CPLib.LRTrim(_cfint)+CPLib.Space(16-CPLib.Len(CPLib.LRTrim(_cfint)));
                /* _file := _file + Space(102) */
                _file = _file+CPLib.Space(102);
                /* _file := _file + LRTrim(_ragint)+Space(70 - Len(LRTrim(_ragint))) */
                _file = _file+CPLib.LRTrim(_ragint)+CPLib.Space(70-CPLib.Len(CPLib.LRTrim(_ragint)));
                /* _file := _file + LRTrim(_citint)+Space(40 - Len(LRTrim(_citint))) */
                _file = _file+CPLib.LRTrim(_citint)+CPLib.Space(40-CPLib.Len(CPLib.LRTrim(_citint)));
                /* _file := _file + LRTrim(_prvint)+Space(2 - Len(LRTrim(_prvint))) */
                _file = _file+CPLib.LRTrim(_prvint)+CPLib.Space(2-CPLib.Len(CPLib.LRTrim(_prvint)));
                /* _file := _file + Right("0000"+Str(Year(w_a_data),4,0),4)+Right("00"+LRTrim(Str(Month(w_a_data),2,0)),2) */
                _file = _file+CPLib.Right("0000"+CPLib.Str(CPLib.Year(w_a_data),4,0),4)+CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(CPLib.Month(w_a_data),2,0)),2);
                /* _file := _file + '1' */
                _file = _file+"1";
                /* _file := _file + Left(LRTrim(_nomefile)+Space(15),15) */
                _file = _file+CPLib.Left(CPLib.LRTrim(_nomefile)+CPLib.Space(15),15);
                /* _file := _file + Left(LRTrim(_cfinvio)+Space(16),16) */
                _file = _file+CPLib.Left(CPLib.LRTrim(_cfinvio)+CPLib.Space(16),16);
                /* _file := _file + Left(LRTrim(_cafinvio)+Space(5),5) */
                _file = _file+CPLib.Left(CPLib.LRTrim(_cafinvio)+CPLib.Space(5),5);
                /* _file := _file + Left(LRTrim(_tipinvio)+Space(1),1) */
                _file = _file+CPLib.Left(CPLib.LRTrim(_tipinvio)+CPLib.Space(1),1);
                /* _file := _file + Left(LRTrim(_impinvio)+Space(8),8) */
                _file = _file+CPLib.Left(CPLib.LRTrim(_impinvio)+CPLib.Space(8),8);
                /* _file := _file + Space(1507) */
                _file = _file+CPLib.Space(1507);
                /* _file := _file + 'A' */
                _file = _file+"A";
                /* FileLibrary.WriteLine(fhand,_file) */
                FileLibrary.WriteLine(fhand,_file);
                /* FileLibrary.Close(fhand) */
                FileLibrary.Close(fhand);
                /* cProg := Utilities.GetAutonumber("PRGFILES\'"+LRTrim(gAzienda)+"'",'',10) */
                cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGFILES\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
                // * --- Insert into aefiles_glob from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aefiles_glob");
                m_cPhName = m_Ctx.GetPhName("aefiles_glob");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.InsertIntoStatement(m_Ctx,"aefiles_glob")+" (";
                m_cSql = m_cSql+GetFieldsName_0705BAC8(m_Ctx);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("Invio Periodico Aperture Soggetti Italiani","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(w_mese,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(w_anno,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
                if (m_Ctx.IsSharedTemp("aefiles_glob")) {
                  m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                }
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aefiles_glob",true);
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
                /* _i := 1 */
                _i = CPLib.Round(1,0);
                /* _crow := 0 */
                _crow = CPLib.Round(0,0);
                /* _cfile := _cfile + 1 */
                _cfile = CPLib.Round(_cfile+1,0);
              } // End If
              /* _conta := _conta + 1 */
              _conta = CPLib.Round(_conta+1,0);
              Cursor_tmp_apecod.Next();
            }
            m_cConnectivityError = Cursor_tmp_apecod.ErrorMessage();
            Cursor_tmp_apecod.Close();
            // * --- End Select
            /* If _crow<15000 */
            if (CPLib.lt(_crow,15000)) {
              /* If _i > 1 and _i < 6 */
              if (CPLib.gt(_i,1) && CPLib.lt(_i,6)) {
                /* While _i < 6 */
                while (CPLib.lt(_i,6)) {
                  /* _file := _file + Space(329) */
                  _file = _file+CPLib.Space(329);
                  /* _file := _file + '*' */
                  _file = _file+"*";
                  /* _i := _i + 1 */
                  _i = CPLib.Round(_i+1,0);
                } // End While
                /* _file := _file + Space(146) */
                _file = _file+CPLib.Space(146);
                /* _file := _file + 'A' */
                _file = _file+"A";
                /* FileLibrary.WriteLine(fhand,_file) */
                FileLibrary.WriteLine(fhand,_file);
              } // End If
              /* _file := '9CCB00' + '34' */
              _file = "9CCB00"+"34";
              /* _file := _file + LRTrim(_cfint)+Space(16 - Len(LRTrim(_cfint))) */
              _file = _file+CPLib.LRTrim(_cfint)+CPLib.Space(16-CPLib.Len(CPLib.LRTrim(_cfint)));
              /* _file := _file + Space(102) */
              _file = _file+CPLib.Space(102);
              /* _file := _file + LRTrim(_ragint)+Space(70 - Len(LRTrim(_ragint))) */
              _file = _file+CPLib.LRTrim(_ragint)+CPLib.Space(70-CPLib.Len(CPLib.LRTrim(_ragint)));
              /* _file := _file + LRTrim(_citint)+Space(40 - Len(LRTrim(_citint))) */
              _file = _file+CPLib.LRTrim(_citint)+CPLib.Space(40-CPLib.Len(CPLib.LRTrim(_citint)));
              /* _file := _file + LRTrim(_prvint)+Space(2 - Len(LRTrim(_prvint))) */
              _file = _file+CPLib.LRTrim(_prvint)+CPLib.Space(2-CPLib.Len(CPLib.LRTrim(_prvint)));
              /* _file := _file + Right("0000"+Str(Year(w_a_data),4,0),4)+Right("00"+LRTrim(Str(Month(w_a_data),2,0)),2) */
              _file = _file+CPLib.Right("0000"+CPLib.Str(CPLib.Year(w_a_data),4,0),4)+CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(CPLib.Month(w_a_data),2,0)),2);
              /* _file := _file + '1' */
              _file = _file+"1";
              /* _file := _file + Left(LRTrim(_nomefile)+Space(15),15) */
              _file = _file+CPLib.Left(CPLib.LRTrim(_nomefile)+CPLib.Space(15),15);
              /* _file := _file + Left(LRTrim(_cfinvio)+Space(16),16) */
              _file = _file+CPLib.Left(CPLib.LRTrim(_cfinvio)+CPLib.Space(16),16);
              /* _file := _file + Left(LRTrim(_cafinvio)+Space(5),5) */
              _file = _file+CPLib.Left(CPLib.LRTrim(_cafinvio)+CPLib.Space(5),5);
              /* _file := _file + Left(LRTrim(_tipinvio)+Space(1),1) */
              _file = _file+CPLib.Left(CPLib.LRTrim(_tipinvio)+CPLib.Space(1),1);
              /* _file := _file + Left(LRTrim(_impinvio)+Space(8),8) */
              _file = _file+CPLib.Left(CPLib.LRTrim(_impinvio)+CPLib.Space(8),8);
              /* _file := _file + Space(1507) */
              _file = _file+CPLib.Space(1507);
              /* _file := _file + 'A' */
              _file = _file+"A";
              /* FileLibrary.WriteLine(fhand,_file) */
              FileLibrary.WriteLine(fhand,_file);
              /* FileLibrary.Close(fhand) */
              FileLibrary.Close(fhand);
              /* cProg := Utilities.GetAutonumber("PRGFILES\'"+LRTrim(gAzienda)+"'",'',10) */
              cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGFILES\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
              // * --- Insert into aefiles_glob from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("aefiles_glob");
              m_cPhName = m_Ctx.GetPhName("aefiles_glob");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"aefiles_glob")+" (";
              m_cSql = m_cSql+GetFieldsName_077C19E0(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Invio Periodico Aperture Soggetti Italiani","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(w_mese,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(w_anno,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("aefiles_glob")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aefiles_glob",true);
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
              /* _cfile := _cfile + 1 */
              _cfile = CPLib.Round(_cfile+1,0);
            } // End If
          } // End If
          // * --- Delete from tmp_apecod
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_apecod");
          m_cPhName = m_Ctx.GetPhName("tmp_apecod");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = "delete from "+m_cPhName;
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(1,"?",0,0,m_cServer),m_cServer,1)+"";
          if (m_Ctx.IsSharedTemp("tmp_apecod")) {
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
          /* countmp := 0 // Contatore delle occorenze inserite nel temporaneo */
          countmp = CPLib.Round(0,0);
        } // End If
      } // End While
      /* If _fileita > 0 */
      if (CPLib.gt(_fileita,0)) {
        /* cProg := Utilities.GetAutonumber("PRGFILES\'"+LRTrim(gAzienda)+"'",'',10) */
        cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGFILES\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
        // * --- Insert into aefiles from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("aefiles");
        m_cPhName = m_Ctx.GetPhName("aefiles");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"aefiles")+" (";
        m_cSql = m_cSql+GetFieldsName_041754E8(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_czip,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Invio Periodico Aperture Soggetti Italiani","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(w_mese,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(w_anno,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
        if (m_Ctx.IsSharedTemp("aefiles")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aefiles",true);
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
        /* Exec "Crea file zip" Page 4:Page_4 */
        Page_4();
      } // End If
      /* countmp := 0 // Contatore delle occorenze inserite nel temporaneo */
      countmp = CPLib.Round(0,0);
      /* _max := 0 */
      _max = CPLib.Round(0,0);
      /* _min := 0 */
      _min = CPLib.Round(0,0);
      /* _tot := 0 */
      _tot = CPLib.Round(0,0);
      /* _mono := 0 */
      _mono = CPLib.Round(0,0);
      /* Stranieri */
      /* _estero := 'S' */
      _estero = "S";
      // * --- Select from qbe_scadat_ape_3_max_min
      if (Cursor_qbe_scadat_ape_3_max_min!=null)
        Cursor_qbe_scadat_ape_3_max_min.Close();
      Cursor_qbe_scadat_ape_3_max_min = new VQRHolder("qbe_scadat_ape_3_max_min",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_scadat_ape_3_max_min.Eof())) {
        /* _max := qbe_scadat_ape_3_max_min->MAXPROGAER */
        _max = CPLib.Round(Cursor_qbe_scadat_ape_3_max_min.GetDouble("MAXPROGAER"),0);
        /* _min := qbe_scadat_ape_3_max_min->MINPROGAER */
        _min = CPLib.Round(Cursor_qbe_scadat_ape_3_max_min.GetDouble("MINPROGAER"),0);
        /* _tot := qbe_scadat_ape_3_max_min->TOTPROGAER */
        _tot = CPLib.Round(Cursor_qbe_scadat_ape_3_max_min.GetDouble("TOTPROGAER"),0);
        Cursor_qbe_scadat_ape_3_max_min.Next();
      }
      m_cConnectivityError = Cursor_qbe_scadat_ape_3_max_min.ErrorMessage();
      Cursor_qbe_scadat_ape_3_max_min.Close();
      // * --- End Select
      /* _mono := iif(_tot > 75000,0,1) */
      _mono = CPLib.Round((CPLib.gt(_tot,75000)?0:1),0);
      /* If _mono = 1 */
      if (CPLib.eqr(_mono,1)) {
        /* If _tot = 0 */
        if (CPLib.eqr(_tot,0)) {
          /* _cicli := 0 */
          _cicli = CPLib.Round(0,0);
        } else { // Else
          /* _cicli := 1 */
          _cicli = CPLib.Round(1,0);
        } // End If
      } else { // Else
        /* _cicli := iif(Mod(_max,5000) <> 0,Int(_max/5000) + 1,Int(_max/5000)) */
        _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,5000),0)?CPLib.Int(_max/5000)+1:CPLib.Int(_max/5000)),0);
      } // End If
      /* _contacilci := 1 */
      _contacilci = CPLib.Round(1,0);
      /* _czip := DateTimeToChar(DateTime())+"_4.zip" */
      _czip = CPLib.DateTimeToChar(CPLib.DateTime())+"_4.zip";
      /* cNomeFileZip := LRTrim(gPathApp)+'/flussi/'+LRTrim(gAzienda)+"/"+_czip */
      cNomeFileZip = CPLib.LRTrim(gPathApp)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+_czip;
      /* While _contacilci<=_cicli */
      while (CPLib.le(_contacilci,_cicli)) {
        /* If _mono = 1 */
        if (CPLib.eqr(_mono,1)) {
          /* _bottom := _min */
          _bottom = CPLib.Round(_min,0);
          /* _top := _max */
          _top = CPLib.Round(_max,0);
        } else { // Else
          /* _bottom := ((_contacilci -1 ) * 5000) + 1 */
          _bottom = CPLib.Round(((_contacilci-1)*5000)+1,0);
          /* _top := _contacilci * 5000 */
          _top = CPLib.Round(_contacilci*5000,0);
        } // End If
        /* gMsgImp := 'Lettura rapporti in corso ... Ciclo N. '+LRTrim(Str(_contacilci,10,0)) // Messaggio Import */
        gMsgImp = "Lettura rapporti in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacilci,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If _top>=_min */
        if (CPLib.ge(_top,_min)) {
          // * --- Select from qbe_scadat_ape_3
          if (Cursor_qbe_scadat_ape_3!=null)
            Cursor_qbe_scadat_ape_3.Close();
          Cursor_qbe_scadat_ape_3 = new VQRHolder("qbe_scadat_ape_3",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_scadat_ape_3.Eof())) {
            /* gMsgImp := 'Elaborazione soggetti senza CF italiano al ' + LRTrim(Str(((qbe_scadat_ape_3->PROGAER-(_min-1))/(_max-(_min-1)))*100,5,2)) + '%. Sto elaborando il rapporto N° ' + LRTrim(Str(_nocodrec+_sicodrec,10,0)) // Messaggio allineamento 1 */
            gMsgImp = "Elaborazione soggetti senza CF italiano al "+CPLib.LRTrim(CPLib.Str(((Cursor_qbe_scadat_ape_3.GetDouble("PROGAER")-(_min-1))/(_max-(_min-1)))*100,5,2))+"%. Sto elaborando il rapporto N° "+CPLib.LRTrim(CPLib.Str(_nocodrec+_sicodrec,10,0));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* _descit := '' */
            _descit = "";
            /* If not(Empty(qbe_scadat_ape_3->COGNOME)) and not(Empty(qbe_scadat_ape_3->NOME)) and  not(Empty(qbe_scadat_ape_3->SESSO)) */
            if ( ! (CPLib.Empty(Cursor_qbe_scadat_ape_3.GetString("COGNOME"))) &&  ! (CPLib.Empty(Cursor_qbe_scadat_ape_3.GetString("NOME"))) &&  ! (CPLib.Empty(Cursor_qbe_scadat_ape_3.GetString("SESSO")))) {
              /* _cdata1 := Right(DateToChar(qbe_scadat_ape_3->DATANASC),2)+Substr(DateToChar(qbe_scadat_ape_3->DATANASC),5,2)+Left(DateToChar(qbe_scadat_ape_3->DATANASC),4) */
              _cdata1 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_scadat_ape_3.GetDate("DATANASC")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_scadat_ape_3.GetDate("DATANASC")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_scadat_ape_3.GetDate("DATANASC")),4);
              /* _cdata2 := Right(DateToChar(qbe_scadat_ape_3->ADATA),2)+Substr(DateToChar(qbe_scadat_ape_3->ADATA),5,2)+Left(DateToChar(qbe_scadat_ape_3->ADATA),4) */
              _cdata2 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_scadat_ape_3.GetDate("ADATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_scadat_ape_3.GetDate("ADATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_scadat_ape_3.GetDate("ADATA")),4);
              /* _cdata3 := '' */
              _cdata3 = "";
              /* nProgImp := Utilities.GetAutonumber("PROGAENOCOD\'"+LRTrim(gAzienda)+"'",0,15) */
              nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGAENOCOD\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
              // * --- Insert into tmp_apenocod from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_apenocod");
              m_cPhName = m_Ctx.GetPhName("tmp_apenocod");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_apenocod")+" (";
              m_cSql = m_cSql+GetFieldsName_07742B08(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL("4","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_ape_3.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_ape_3.GetString("NOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_qbe_scadat_ape_3.GetString("SESSO"),"F") || CPLib.eqr(Cursor_qbe_scadat_ape_3.GetString("SESSO"),"2")?"F":"M"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_ape_3.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("EE","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_ape_3.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_ape_3.GetString("COINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_ape_3.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata3,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_ape_3.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
              if (m_Ctx.IsSharedTemp("tmp_apenocod")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_apenocod",true);
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
              /* If not(Empty(qbe_scadat_ape_3->PAESE)) */
              if ( ! (CPLib.Empty(Cursor_qbe_scadat_ape_3.GetString("PAESE")))) {
                // * --- Read from tbstati
                m_cServer = m_Ctx.GetServer("tbstati");
                m_cPhName = m_Ctx.GetPhName("tbstati");
                m_cSql = "";
                m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_scadat_ape_3.GetString("PAESE"),"C",3,0,m_cServer),m_cServer,Cursor_qbe_scadat_ape_3.GetString("PAESE"));
                if (m_Ctx.IsSharedTemp("tbstati")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _descit = Read_Cursor.GetString("DESCRI");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on tbstati into routine arrt_sd_aprichiudi returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _descit = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* _descit := iif(not(Empty(_descit)),_descit,qbe_scadat_ape_3->DESCCIT) */
                _descit = ( ! (CPLib.Empty(_descit))?_descit:Cursor_qbe_scadat_ape_3.GetString("DESCCIT"));
              } else { // Else
                /* _descit := qbe_scadat_ape_3->DESCCIT */
                _descit = Cursor_qbe_scadat_ape_3.GetString("DESCCIT");
              } // End If
              /* _cdata2 := Right(DateToChar(qbe_scadat_ape_3->ADATA),2)+Substr(DateToChar(qbe_scadat_ape_3->ADATA),5,2)+Left(DateToChar(qbe_scadat_ape_3->ADATA),4) */
              _cdata2 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_scadat_ape_3.GetDate("ADATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_scadat_ape_3.GetDate("ADATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_scadat_ape_3.GetDate("ADATA")),4);
              /* _cdata3 := '' */
              _cdata3 = "";
              /* nProgImp := Utilities.GetAutonumber("PROGAENOCOD\'"+LRTrim(gAzienda)+"'",0,15) */
              nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGAENOCOD\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
              // * --- Insert into tmp_apenocod from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_apenocod");
              m_cPhName = m_Ctx.GetPhName("tmp_apenocod");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_apenocod")+" (";
              m_cSql = m_cSql+GetFieldsName_0725F848(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL("4","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_ape_3.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_ape_3.GetString("COINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_ape_3.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata3,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_ape_3.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_qbe_scadat_ape_3.GetString("RAGSOC"),60),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_descit,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_qbe_scadat_ape_3.GetString("PROVINCIA"))?"EE":Cursor_qbe_scadat_ape_3.GetString("PROVINCIA")),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
              if (m_Ctx.IsSharedTemp("tmp_apenocod")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_apenocod",true);
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
            /* _nocodrec := _nocodrec + 1 */
            _nocodrec = CPLib.Round(_nocodrec+1,0);
            /* countmp := countmp+1 // Contatore delle occorenze inserite nel temporaneo */
            countmp = CPLib.Round(countmp+1,0);
            Cursor_qbe_scadat_ape_3.Next();
          }
          m_cConnectivityError = Cursor_qbe_scadat_ape_3.ErrorMessage();
          Cursor_qbe_scadat_ape_3.Close();
          // * --- End Select
        } else { // Else
          /* gMsgImp := 'Lettura rapporti in corso ...' // Messaggio Import */
          gMsgImp = "Lettura rapporti in corso ...";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } // End If
        /* _contacilci := _contacilci+1 */
        _contacilci = CPLib.Round(_contacilci+1,0);
        /* If Mod(_top,75000)=0 or _contacilci > _cicli */
        if (CPLib.eqr(CPLib.Mod(_top,75000),0) || CPLib.gt(_contacilci,_cicli)) {
          /* If _nocodrec>0 */
          if (CPLib.gt(_nocodrec,0)) {
            /* Cicla sul file per invii e prepara il file */
            /* _i := 1 */
            _i = CPLib.Round(1,0);
            /* _crow := 0 */
            _crow = CPLib.Round(0,0);
            /* _cfile := 0 */
            _cfile = CPLib.Round(0,0);
            /* _conta := 1 */
            _conta = CPLib.Round(1,0);
            // * --- Select from tmp_apenocod
            m_cServer = m_Ctx.GetServer("tmp_apenocod");
            m_cPhName = m_Ctx.GetPhName("tmp_apenocod");
            if (Cursor_tmp_apenocod!=null)
              Cursor_tmp_apenocod.Close();
            Cursor_tmp_apenocod = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_apenocod")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_tmp_apenocod.Eof())) {
              /* If _crow = 0 and _i=1 */
              if (CPLib.eqr(_crow,0) && CPLib.eqr(_i,1)) {
                /* Crea Record di testa */
                /* _nomefile := DateTimeToChar(DateTime())+'4' */
                _nomefile = CPLib.DateTimeToChar(CPLib.DateTime())+"4";
                /* cNomeFile := LRTrim(gPathApp)+'/flussi/'+LRTrim(gAzienda)+"/"+LRTrim(_nomefile) */
                cNomeFile = CPLib.LRTrim(gPathApp)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_nomefile);
                /* cOnlyNomeFile := _nomefile */
                cOnlyNomeFile = _nomefile;
                // These are the files to include in the ZIP file
                filenames.add(cNomeFile);
                fileonames.add(cOnlyNomeFile);
                /* fhand := FileLibrary.OpenWrite('./flussi/'+LRTrim(gAzienda)+"/"+LRTrim(_nomefile)) */
                fhand = FileLibrary.OpenWrite("./flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_nomefile));
                /* _fileest := _fileest + 1 */
                _fileest = CPLib.Round(_fileest+1,0);
                /* _file := '0CCB00' + '34' */
                _file = "0CCB00"+"34";
                /* _file := _file + LRTrim(_cfint)+Space(16 - Len(LRTrim(_cfint))) */
                _file = _file+CPLib.LRTrim(_cfint)+CPLib.Space(16-CPLib.Len(CPLib.LRTrim(_cfint)));
                /* _file := _file + Space(102) */
                _file = _file+CPLib.Space(102);
                /* _file := _file + LRTrim(_ragint)+Space(70 - Len(LRTrim(_ragint))) */
                _file = _file+CPLib.LRTrim(_ragint)+CPLib.Space(70-CPLib.Len(CPLib.LRTrim(_ragint)));
                /* _file := _file + LRTrim(_citint)+Space(40 - Len(LRTrim(_citint))) */
                _file = _file+CPLib.LRTrim(_citint)+CPLib.Space(40-CPLib.Len(CPLib.LRTrim(_citint)));
                /* _file := _file + LRTrim(_prvint)+Space(2 - Len(LRTrim(_prvint))) */
                _file = _file+CPLib.LRTrim(_prvint)+CPLib.Space(2-CPLib.Len(CPLib.LRTrim(_prvint)));
                /* _file := _file + Right("0000"+Str(Year(w_a_data),4,0),4)+Right("00"+LRTrim(Str(Month(w_a_data),2,0)),2) */
                _file = _file+CPLib.Right("0000"+CPLib.Str(CPLib.Year(w_a_data),4,0),4)+CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(CPLib.Month(w_a_data),2,0)),2);
                /* _file := _file + '4' */
                _file = _file+"4";
                /* _file := _file + Left(LRTrim(_nomefile)+Space(15),15) */
                _file = _file+CPLib.Left(CPLib.LRTrim(_nomefile)+CPLib.Space(15),15);
                /* _file := _file + Left(LRTrim(_cfinvio)+Space(16),16) */
                _file = _file+CPLib.Left(CPLib.LRTrim(_cfinvio)+CPLib.Space(16),16);
                /* _file := _file + Left(LRTrim(_cafinvio)+Space(5),5) */
                _file = _file+CPLib.Left(CPLib.LRTrim(_cafinvio)+CPLib.Space(5),5);
                /* _file := _file + Left(LRTrim(_tipinvio)+Space(1),1) */
                _file = _file+CPLib.Left(CPLib.LRTrim(_tipinvio)+CPLib.Space(1),1);
                /* _file := _file + Left(LRTrim(_impinvio)+Space(8),8) */
                _file = _file+CPLib.Left(CPLib.LRTrim(_impinvio)+CPLib.Space(8),8);
                /* _file := _file + Space(1507) */
                _file = _file+CPLib.Space(1507);
                /* _file := _file + 'A' */
                _file = _file+"A";
                /* FileLibrary.WriteLine(fhand,_file) */
                FileLibrary.WriteLine(fhand,_file);
              } // End If
              /* gMsgImp := 'Elaborazione soggetti senza CF italiano al ' + LRTrim(Str(((_top-(_min-1))/(_max-(_min-1)))*100,5,2)) + '%. Sto scrivendo il file ' + LRTrim(cOnlyNomeFile)+ ' - Riga N° '+ LRTrim(Str(_crow,10,0)) // Messaggio Import */
              gMsgImp = "Elaborazione soggetti senza CF italiano al "+CPLib.LRTrim(CPLib.Str(((_top-(_min-1))/(_max-(_min-1)))*100,5,2))+"%. Sto scrivendo il file "+CPLib.LRTrim(cOnlyNomeFile)+" - Riga N° "+CPLib.LRTrim(CPLib.Str(_crow,10,0));
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _r := _r + 1 */
              _r = CPLib.Round(_r+1,0);
              /* If _i = 1 */
              if (CPLib.eqr(_i,1)) {
                /* _file := tmp_apenocod->TIPOREC */
                _file = Cursor_tmp_apenocod.GetString("TIPOREC");
              } // End If
              // * --- Insert into tmp_stpfileage from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stpfileage");
              m_cPhName = m_Ctx.GetPhName("tmp_stpfileage");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_stpfileage")+" (";
              m_cSql = m_cSql+GetFieldsName_07C83F68(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("4","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_apenocod.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(CPLib.Str(_r)),25),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_tmp_apenocod.GetString("SESSO"))?Cursor_tmp_apenocod.GetString("DENOM"):CPLib.LRTrim(Cursor_tmp_apenocod.GetString("COGNOME"))+" "+CPLib.LRTrim(Cursor_tmp_apenocod.GetString("NOME"))),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_apenocod.GetString("DATAINI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_apenocod.GetString("DATACHIU"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_apenocod.GetString("COINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_apenocod.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("tmp_stpfileage")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpfileage",true);
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
              /* _file := _file + Right("0000000000000000000000000000000000000000" + LRTrim(Str(_r)),25) */
              _file = _file+CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(CPLib.Str(_r)),25);
              /* _file := _file + Left(LRTrim(arfn_agechar(tmp_apenocod->COGNOME,' ')) + Space(26),26) */
              _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_tmp_apenocod.GetString("COGNOME")," "))+CPLib.Space(26),26);
              /* _file := _file + Left(LRTrim(arfn_agechar(tmp_apenocod->NOME,' ')) + Space(25),25) */
              _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_tmp_apenocod.GetString("NOME")," "))+CPLib.Space(25),25);
              /* _file := _file + Left(LRTrim(tmp_apenocod->SESSO)+Space(1),1) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_apenocod.GetString("SESSO"))+CPLib.Space(1),1);
              /* _file := _file + Left(LRTrim(tmp_apenocod->DATANASC) + Space(8),8) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_apenocod.GetString("DATANASC"))+CPLib.Space(8),8);
              /* _file := _file + Left(LRTrim(arfn_agechar(tmp_apenocod->COMSTA,' ')) + Space(40),40) */
              _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_tmp_apenocod.GetString("COMSTA")," "))+CPLib.Space(40),40);
              /* _file := _file + Left(LRTrim(arfn_agechar(tmp_apenocod->PROVNA,' ')) + Space(2),2) */
              _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_tmp_apenocod.GetString("PROVNA")," "))+CPLib.Space(2),2);
              /* _file := _file + Left(LRTrim(arfn_agechar(tmp_apenocod->DENOM,' ')) + Space(60),60) */
              _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_tmp_apenocod.GetString("DENOM")," "))+CPLib.Space(60),60);
              /* _file := _file + Left(LRTrim(arfn_agechar(tmp_apenocod->COMSEDE,' ')) + Space(40),40) */
              _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_tmp_apenocod.GetString("COMSEDE")," "))+CPLib.Space(40),40);
              /* _file := _file + Left(LRTrim(arfn_agechar(tmp_apenocod->PROVSED,' ')) + Space(2),2) */
              _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_tmp_apenocod.GetString("PROVSED")," "))+CPLib.Space(2),2);
              /* _file := _file + Left(LRTrim(tmp_apenocod->TIPORAP) + Space(2),2) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_apenocod.GetString("TIPORAP"))+CPLib.Space(2),2);
              /* _file := _file + Left(LRTrim(tmp_apenocod->COINT) + Space(1),1) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_apenocod.GetString("COINT"))+CPLib.Space(1),1);
              /* _file := _file + Left(LRTrim(tmp_apenocod->DATAINI) + Space(8),8) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_apenocod.GetString("DATAINI"))+CPLib.Space(8),8);
              /* If not(Empty(tmp_apenocod->DATACHIU)) and CharToDate(tmp_apenocod->DATACHIU) >= w_dadata and CharToDate(tmp_apenocod->DATACHIU) <= w_a_data */
              if ( ! (CPLib.Empty(Cursor_tmp_apenocod.GetString("DATACHIU"))) && CPLib.ge(CPLib.CharToDate(Cursor_tmp_apenocod.GetString("DATACHIU")),w_dadata) && CPLib.le(CPLib.CharToDate(Cursor_tmp_apenocod.GetString("DATACHIU")),w_a_data)) {
                /* _file := _file + Left(LRTrim(tmp_apenocod->DATACHIU) + Space(8),8) */
                _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_apenocod.GetString("DATACHIU"))+CPLib.Space(8),8);
              } else { // Else
                /* _file := _file + Space(8) */
                _file = _file+CPLib.Space(8);
              } // End If
              /* _file := _file + Space(81) */
              _file = _file+CPLib.Space(81);
              /* _file := _file + '*' */
              _file = _file+"*";
              /* _i := _i + 1 */
              _i = CPLib.Round(_i+1,0);
              /* If _i=6 */
              if (CPLib.eqr(_i,6)) {
                /* _i := 1 */
                _i = CPLib.Round(1,0);
                /* _file := _file + Space(146) */
                _file = _file+CPLib.Space(146);
                /* _file := _file + 'A' */
                _file = _file+"A";
                /* FileLibrary.WriteLine(fhand,_file) */
                FileLibrary.WriteLine(fhand,_file);
                /* _crow := _crow + 1 */
                _crow = CPLib.Round(_crow+1,0);
              } // End If
              /* If not(Empty(tmp_apenocod->DATACHIU)) and CharToDate(tmp_apenocod->DATACHIU) >= w_dadata and CharToDate(tmp_apenocod->DATACHIU) <= w_a_data */
              if ( ! (CPLib.Empty(Cursor_tmp_apenocod.GetString("DATACHIU"))) && CPLib.ge(CPLib.CharToDate(Cursor_tmp_apenocod.GetString("DATACHIU")),w_dadata) && CPLib.le(CPLib.CharToDate(Cursor_tmp_apenocod.GetString("DATACHIU")),w_a_data)) {
                // * --- Write into aerighe from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aerighe");
                m_cPhName = m_Ctx.GetPhName("aerighe");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "Update "+m_cPhName+" set ";
                m_cSql = m_cSql+"ASPEDITO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                m_cSql = m_cSql+"APROG = "+CPLib.ToSQL(_r,"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"AFILE = "+CPLib.ToSQL(_nomefile,"C",15,0,m_cServer)+", ";
                m_cSql = m_cSql+"ADTPRE = "+CPLib.ToSQL(w_a_data,"D",8,0)+", ";
                m_cSql = m_cSql+"CSPEDITO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                m_cSql = m_cSql+"CPROG = "+CPLib.ToSQL(_r,"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"CFILE = "+CPLib.ToSQL(_nomefile,"C",15,0,m_cServer)+", ";
                m_cSql = m_cSql+"CDTPRE = "+CPLib.ToSQL(w_a_data,"D",8,0)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_apenocod.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_apenocod.GetString("IDBASE"))+"";
                if (m_Ctx.IsSharedTemp("aerighe")) {
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
              } else { // Else
                // * --- Write into aerighe from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aerighe");
                m_cPhName = m_Ctx.GetPhName("aerighe");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "Update "+m_cPhName+" set ";
                m_cSql = m_cSql+"ASPEDITO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                m_cSql = m_cSql+"APROG = "+CPLib.ToSQL(_r,"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"AFILE = "+CPLib.ToSQL(_nomefile,"C",15,0,m_cServer)+", ";
                m_cSql = m_cSql+"ADTPRE = "+CPLib.ToSQL(w_a_data,"D",8,0)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_apenocod.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_apenocod.GetString("IDBASE"))+"";
                if (m_Ctx.IsSharedTemp("aerighe")) {
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
              } // End If
              /* If _crow=15000 */
              if (CPLib.eqr(_crow,15000)) {
                /* If _i > 1 and _i < 6 */
                if (CPLib.gt(_i,1) && CPLib.lt(_i,6)) {
                  /* While _i < 6 */
                  while (CPLib.lt(_i,6)) {
                    /* _file := _file + Space(329) */
                    _file = _file+CPLib.Space(329);
                    /* _file := _file + '*' */
                    _file = _file+"*";
                    /* _i := _i + 1 */
                    _i = CPLib.Round(_i+1,0);
                  } // End While
                  /* _file := _file + Space(146) */
                  _file = _file+CPLib.Space(146);
                  /* _file := _file + 'A' */
                  _file = _file+"A";
                  /* FileLibrary.WriteLine(fhand,_file) */
                  FileLibrary.WriteLine(fhand,_file);
                } // End If
                /* _file := '9CCB00' + '34' */
                _file = "9CCB00"+"34";
                /* _file := _file + LRTrim(_cfint)+Space(16 - Len(LRTrim(_cfint))) */
                _file = _file+CPLib.LRTrim(_cfint)+CPLib.Space(16-CPLib.Len(CPLib.LRTrim(_cfint)));
                /* _file := _file + Space(102) */
                _file = _file+CPLib.Space(102);
                /* _file := _file + LRTrim(_ragint)+Space(70 - Len(LRTrim(_ragint))) */
                _file = _file+CPLib.LRTrim(_ragint)+CPLib.Space(70-CPLib.Len(CPLib.LRTrim(_ragint)));
                /* _file := _file + LRTrim(_citint)+Space(40 - Len(LRTrim(_citint))) */
                _file = _file+CPLib.LRTrim(_citint)+CPLib.Space(40-CPLib.Len(CPLib.LRTrim(_citint)));
                /* _file := _file + LRTrim(_prvint)+Space(2 - Len(LRTrim(_prvint))) */
                _file = _file+CPLib.LRTrim(_prvint)+CPLib.Space(2-CPLib.Len(CPLib.LRTrim(_prvint)));
                /* _file := _file + Right("0000"+Str(Year(w_a_data),4,0),4)+Right("00"+LRTrim(Str(Month(w_a_data),2,0)),2) */
                _file = _file+CPLib.Right("0000"+CPLib.Str(CPLib.Year(w_a_data),4,0),4)+CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(CPLib.Month(w_a_data),2,0)),2);
                /* _file := _file + '4' */
                _file = _file+"4";
                /* _file := _file + Left(LRTrim(_nomefile)+Space(15),15) */
                _file = _file+CPLib.Left(CPLib.LRTrim(_nomefile)+CPLib.Space(15),15);
                /* _file := _file + Left(LRTrim(_cfinvio)+Space(16),16) */
                _file = _file+CPLib.Left(CPLib.LRTrim(_cfinvio)+CPLib.Space(16),16);
                /* _file := _file + Left(LRTrim(_cafinvio)+Space(5),5) */
                _file = _file+CPLib.Left(CPLib.LRTrim(_cafinvio)+CPLib.Space(5),5);
                /* _file := _file + Left(LRTrim(_tipinvio)+Space(1),1) */
                _file = _file+CPLib.Left(CPLib.LRTrim(_tipinvio)+CPLib.Space(1),1);
                /* _file := _file + Left(LRTrim(_impinvio)+Space(8),8) */
                _file = _file+CPLib.Left(CPLib.LRTrim(_impinvio)+CPLib.Space(8),8);
                /* _file := _file + Space(1507) */
                _file = _file+CPLib.Space(1507);
                /* _file := _file + 'A' */
                _file = _file+"A";
                /* FileLibrary.WriteLine(fhand,_file) */
                FileLibrary.WriteLine(fhand,_file);
                /* FileLibrary.Close(fhand) */
                FileLibrary.Close(fhand);
                /* cProg := Utilities.GetAutonumber("PRGFILES\'"+LRTrim(gAzienda)+"'",'',10) */
                cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGFILES\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
                // * --- Insert into aefiles_glob from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aefiles_glob");
                m_cPhName = m_Ctx.GetPhName("aefiles_glob");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.InsertIntoStatement(m_Ctx,"aefiles_glob")+" (";
                m_cSql = m_cSql+GetFieldsName_05ECFCE8(m_Ctx);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("Invio Periodico Aperture Soggetti Esteri","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(w_mese,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(w_anno,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
                if (m_Ctx.IsSharedTemp("aefiles_glob")) {
                  m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                }
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aefiles_glob",true);
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
                /* _i := 1 */
                _i = CPLib.Round(1,0);
                /* _crow := 0 */
                _crow = CPLib.Round(0,0);
                /* _cfile := _cfile + 1 */
                _cfile = CPLib.Round(_cfile+1,0);
              } // End If
              /* _conta := _conta + 1 */
              _conta = CPLib.Round(_conta+1,0);
              Cursor_tmp_apenocod.Next();
            }
            m_cConnectivityError = Cursor_tmp_apenocod.ErrorMessage();
            Cursor_tmp_apenocod.Close();
            // * --- End Select
            /* If _crow<15000 */
            if (CPLib.lt(_crow,15000)) {
              /* If _i > 1 and _i < 6 */
              if (CPLib.gt(_i,1) && CPLib.lt(_i,6)) {
                /* While _i < 6 */
                while (CPLib.lt(_i,6)) {
                  /* _file := _file + Space(329) */
                  _file = _file+CPLib.Space(329);
                  /* _file := _file + '*' */
                  _file = _file+"*";
                  /* _i := _i + 1 */
                  _i = CPLib.Round(_i+1,0);
                } // End While
                /* _file := _file + Space(146) */
                _file = _file+CPLib.Space(146);
                /* _file := _file + 'A' */
                _file = _file+"A";
                /* FileLibrary.WriteLine(fhand,_file) */
                FileLibrary.WriteLine(fhand,_file);
              } // End If
              /* _file := '9CCB00' + '34' */
              _file = "9CCB00"+"34";
              /* _file := _file + LRTrim(_cfint)+Space(16 - Len(LRTrim(_cfint))) */
              _file = _file+CPLib.LRTrim(_cfint)+CPLib.Space(16-CPLib.Len(CPLib.LRTrim(_cfint)));
              /* _file := _file + Space(102) */
              _file = _file+CPLib.Space(102);
              /* _file := _file + LRTrim(_ragint)+Space(70 - Len(LRTrim(_ragint))) */
              _file = _file+CPLib.LRTrim(_ragint)+CPLib.Space(70-CPLib.Len(CPLib.LRTrim(_ragint)));
              /* _file := _file + LRTrim(_citint)+Space(40 - Len(LRTrim(_citint))) */
              _file = _file+CPLib.LRTrim(_citint)+CPLib.Space(40-CPLib.Len(CPLib.LRTrim(_citint)));
              /* _file := _file + LRTrim(_prvint)+Space(2 - Len(LRTrim(_prvint))) */
              _file = _file+CPLib.LRTrim(_prvint)+CPLib.Space(2-CPLib.Len(CPLib.LRTrim(_prvint)));
              /* _file := _file + Right("0000"+Str(Year(w_a_data),4,0),4)+Right("00"+LRTrim(Str(Month(w_a_data),2,0)),2) */
              _file = _file+CPLib.Right("0000"+CPLib.Str(CPLib.Year(w_a_data),4,0),4)+CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(CPLib.Month(w_a_data),2,0)),2);
              /* _file := _file + '4' */
              _file = _file+"4";
              /* _file := _file + Left(LRTrim(_nomefile)+Space(15),15) */
              _file = _file+CPLib.Left(CPLib.LRTrim(_nomefile)+CPLib.Space(15),15);
              /* _file := _file + Left(LRTrim(_cfinvio)+Space(16),16) */
              _file = _file+CPLib.Left(CPLib.LRTrim(_cfinvio)+CPLib.Space(16),16);
              /* _file := _file + Left(LRTrim(_cafinvio)+Space(5),5) */
              _file = _file+CPLib.Left(CPLib.LRTrim(_cafinvio)+CPLib.Space(5),5);
              /* _file := _file + Left(LRTrim(_tipinvio)+Space(1),1) */
              _file = _file+CPLib.Left(CPLib.LRTrim(_tipinvio)+CPLib.Space(1),1);
              /* _file := _file + Left(LRTrim(_impinvio)+Space(8),8) */
              _file = _file+CPLib.Left(CPLib.LRTrim(_impinvio)+CPLib.Space(8),8);
              /* _file := _file + Space(1507) */
              _file = _file+CPLib.Space(1507);
              /* _file := _file + 'A' */
              _file = _file+"A";
              /* FileLibrary.WriteLine(fhand,_file) */
              FileLibrary.WriteLine(fhand,_file);
              /* FileLibrary.Close(fhand) */
              FileLibrary.Close(fhand);
              /* cProg := Utilities.GetAutonumber("PRGFILES\'"+LRTrim(gAzienda)+"'",'',10) */
              cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGFILES\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
              // * --- Insert into aefiles_glob from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("aefiles_glob");
              m_cPhName = m_Ctx.GetPhName("aefiles_glob");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"aefiles_glob")+" (";
              m_cSql = m_cSql+GetFieldsName_07654C18(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Invio Periodico Aperture Soggetti Esteri","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(w_mese,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(w_anno,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("aefiles_glob")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aefiles_glob",true);
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
              /* _cfile := _cfile + 1 */
              _cfile = CPLib.Round(_cfile+1,0);
            } // End If
          } // End If
          // * --- Delete from tmp_apenocod
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_apenocod");
          m_cPhName = m_Ctx.GetPhName("tmp_apenocod");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = "delete from "+m_cPhName;
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(1,"?",0,0,m_cServer),m_cServer,1)+"";
          if (m_Ctx.IsSharedTemp("tmp_apenocod")) {
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
          /* countmp := 0 // Contatore delle occorenze inserite nel temporaneo */
          countmp = CPLib.Round(0,0);
        } // End If
      } // End While
      /* If _fileest > 0 */
      if (CPLib.gt(_fileest,0)) {
        /* cProg := Utilities.GetAutonumber("PRGFILES\'"+LRTrim(gAzienda)+"'",'',10) */
        cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGFILES\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
        // * --- Insert into aefiles from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("aefiles");
        m_cPhName = m_Ctx.GetPhName("aefiles");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"aefiles")+" (";
        m_cSql = m_cSql+GetFieldsName_07682E68(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_czip,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Invio Periodico Aperture Soggetti Esteri","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(w_mese,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(w_anno,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
        if (m_Ctx.IsSharedTemp("aefiles")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aefiles",true);
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
        /* Exec "Crea file zip" Page 4:Page_4 */
        Page_4();
      } // End If
    } finally {
      try {
        if (Cursor_qbe_scadat_ape_3_max_min!=null)
          Cursor_qbe_scadat_ape_3_max_min.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_scadat_ape_3!=null)
          Cursor_qbe_scadat_ape_3.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tmp_apecod!=null)
          Cursor_tmp_apecod.Close();
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
        if (Cursor_tmp_apenocod!=null)
          Cursor_tmp_apenocod.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_3() throws Exception {
    CPResultSet Cursor_qbe_scadat_chi_3_max_min=null;
    CPResultSet Cursor_qbe_scadat_chi_3=null;
    CPResultSet Cursor_tmp_chiucod=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_tmp_chiunocod=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Invii Periodici */
      // * --- Drop temporary table tmp_chiucod
      if (m_Ctx.IsSharedTemp("tmp_chiucod")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_chiucod")) {
          m_cServer = m_Ctx.GetServer("tmp_chiucod");
          m_cPhName = m_Ctx.GetPhName("tmp_chiucod");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_chiucod");
      }
      // * --- Create temporary table tmp_chiucod
      if (m_Ctx.IsSharedTemp("tmp_chiucod")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_chiucod")) {
          m_cServer = m_Ctx.GetServer("tmp_chiucod");
          m_cPhName = m_Ctx.GetPhName("tmp_chiucod");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_chiucod");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_chiucod");
      if ( ! (m_Ctx.IsSharedTemp("tmp_chiucod"))) {
        m_cServer = m_Ctx.GetServer("tmp_chiucod");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_chiucod",m_cServer,"proto")),m_cPhName,"tmp_chiucod",m_Ctx,new String[]{"RAPPORTO"});
      }
      m_cPhName_tmp_chiucod = m_cPhName;
      // * --- Drop temporary table tmp_chiunocod
      if (m_Ctx.IsSharedTemp("tmp_chiunocod")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_chiunocod")) {
          m_cServer = m_Ctx.GetServer("tmp_chiunocod");
          m_cPhName = m_Ctx.GetPhName("tmp_chiunocod");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_chiunocod");
      }
      // * --- Create temporary table tmp_chiunocod
      if (m_Ctx.IsSharedTemp("tmp_chiunocod")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_chiunocod")) {
          m_cServer = m_Ctx.GetServer("tmp_chiunocod");
          m_cPhName = m_Ctx.GetPhName("tmp_chiunocod");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_chiunocod");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_chiunocod");
      if ( ! (m_Ctx.IsSharedTemp("tmp_chiunocod"))) {
        m_cServer = m_Ctx.GetServer("tmp_chiunocod");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_chiunocod",m_cServer,"proto")),m_cPhName,"tmp_chiunocod",m_Ctx,new String[]{"RAPPORTO"});
      }
      m_cPhName_tmp_chiunocod = m_cPhName;
      /* _nocodrec := 0 // Conteggio rapporti con soggetti esteri */
      _nocodrec = CPLib.Round(0,0);
      /* _sicodrec := 0 // Conteggio rapporti con soggetti italiani */
      _sicodrec = CPLib.Round(0,0);
      /* _fileita := 0 // Conteggio file soggetti italiani */
      _fileita = CPLib.Round(0,0);
      /* _fileest := 0 // Conteggio file soggetti esteri */
      _fileest = CPLib.Round(0,0);
      /* countmp := 0 // Contatore delle occorenze inserite nel temporaneo */
      countmp = CPLib.Round(0,0);
      /* _max := 0 */
      _max = CPLib.Round(0,0);
      /* _min := 0 */
      _min = CPLib.Round(0,0);
      /* _tot := 0 */
      _tot = CPLib.Round(0,0);
      /* _mono := 0 */
      _mono = CPLib.Round(0,0);
      /* gMsgImp := 'Lettura rapporti in corso per generazione chiusure ...' // Messaggio Import */
      gMsgImp = "Lettura rapporti in corso per generazione chiusure ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* _estero := 'N' */
      _estero = "N";
      // * --- Select from qbe_scadat_chi_3_max_min
      if (Cursor_qbe_scadat_chi_3_max_min!=null)
        Cursor_qbe_scadat_chi_3_max_min.Close();
      Cursor_qbe_scadat_chi_3_max_min = new VQRHolder("qbe_scadat_chi_3_max_min",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_scadat_chi_3_max_min.Eof())) {
        /* _max := qbe_scadat_chi_3_max_min->MAXPROGAER */
        _max = CPLib.Round(Cursor_qbe_scadat_chi_3_max_min.GetDouble("MAXPROGAER"),0);
        /* _min := qbe_scadat_chi_3_max_min->MINPROGAER */
        _min = CPLib.Round(Cursor_qbe_scadat_chi_3_max_min.GetDouble("MINPROGAER"),0);
        /* _tot := qbe_scadat_chi_3_max_min->TOTPROGAER */
        _tot = CPLib.Round(Cursor_qbe_scadat_chi_3_max_min.GetDouble("TOTPROGAER"),0);
        Cursor_qbe_scadat_chi_3_max_min.Next();
      }
      m_cConnectivityError = Cursor_qbe_scadat_chi_3_max_min.ErrorMessage();
      Cursor_qbe_scadat_chi_3_max_min.Close();
      // * --- End Select
      /* _mono := iif(_tot > 75000,0,1) */
      _mono = CPLib.Round((CPLib.gt(_tot,75000)?0:1),0);
      /* If _mono = 1 */
      if (CPLib.eqr(_mono,1)) {
        /* If _tot = 0 */
        if (CPLib.eqr(_tot,0)) {
          /* _cicli := 0 */
          _cicli = CPLib.Round(0,0);
        } else { // Else
          /* _cicli := 1 */
          _cicli = CPLib.Round(1,0);
        } // End If
      } else { // Else
        /* _cicli := iif(Mod(_max,5000) <> 0,Int(_max/5000) + 1,Int(_max/5000)) */
        _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,5000),0)?CPLib.Int(_max/5000)+1:CPLib.Int(_max/5000)),0);
      } // End If
      /* _contacilci := 1 */
      _contacilci = CPLib.Round(1,0);
      /* _czip := DateTimeToChar(DateTime())+"_2.zip" */
      _czip = CPLib.DateTimeToChar(CPLib.DateTime())+"_2.zip";
      /* cNomeFileZip := LRTrim(gPathApp)+'/flussi/'+LRTrim(gAzienda)+"/"+_czip */
      cNomeFileZip = CPLib.LRTrim(gPathApp)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+_czip;
      /* While _contacilci<= _cicli */
      while (CPLib.le(_contacilci,_cicli)) {
        /* If _mono = 1 */
        if (CPLib.eqr(_mono,1)) {
          /* _bottom := _min */
          _bottom = CPLib.Round(_min,0);
          /* _top := _max */
          _top = CPLib.Round(_max,0);
        } else { // Else
          /* _bottom := ((_contacilci -1 ) * 5000) + 1 */
          _bottom = CPLib.Round(((_contacilci-1)*5000)+1,0);
          /* _top := _contacilci * 5000 */
          _top = CPLib.Round(_contacilci*5000,0);
        } // End If
        /* gMsgImp := 'Lettura rapporti in corso ... Ciclo N. '+LRTrim(Str(_contacilci,10,0)) // Messaggio Import */
        gMsgImp = "Lettura rapporti in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacilci,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If _top>=_min */
        if (CPLib.ge(_top,_min)) {
          // * --- Select from qbe_scadat_chi_3
          if (Cursor_qbe_scadat_chi_3!=null)
            Cursor_qbe_scadat_chi_3.Close();
          Cursor_qbe_scadat_chi_3 = new VQRHolder("qbe_scadat_chi_3",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_scadat_chi_3.Eof())) {
            /* gMsgImp := 'Elaborazione soggetti con CF italiano al ' + LRTrim(Str(((qbe_scadat_chi_3->PROGAER-(_min-1))/(_max-(_min-1)))*100,5,2)) + '%. Sto elaborando il rapporto N° ' + LRTrim(Str(_nocodrec+_sicodrec,10,0)) // Messaggio allineamento 1 */
            gMsgImp = "Elaborazione soggetti con CF italiano al "+CPLib.LRTrim(CPLib.Str(((Cursor_qbe_scadat_chi_3.GetDouble("PROGAER")-(_min-1))/(_max-(_min-1)))*100,5,2))+"%. Sto elaborando il rapporto N° "+CPLib.LRTrim(CPLib.Str(_nocodrec+_sicodrec,10,0));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* If not(Empty(qbe_scadat_chi_3->COGNOME)) and not(Empty(qbe_scadat_chi_3->NOME)) and not(Empty(qbe_scadat_chi_3->SESSO))  */
            if ( ! (CPLib.Empty(Cursor_qbe_scadat_chi_3.GetString("COGNOME"))) &&  ! (CPLib.Empty(Cursor_qbe_scadat_chi_3.GetString("NOME"))) &&  ! (CPLib.Empty(Cursor_qbe_scadat_chi_3.GetString("SESSO")))) {
              /* _cdata1 := Right(DateToChar(qbe_scadat_chi_3->DATANASC),2)+Substr(DateToChar(qbe_scadat_chi_3->DATANASC),5,2)+Left(DateToChar(qbe_scadat_chi_3->DATANASC),4) */
              _cdata1 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_scadat_chi_3.GetDate("DATANASC")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_scadat_chi_3.GetDate("DATANASC")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_scadat_chi_3.GetDate("DATANASC")),4);
              /* _cdata2 := Right(DateToChar(qbe_scadat_chi_3->ADATA),2)+Substr(DateToChar(qbe_scadat_chi_3->ADATA),5,2)+Left(DateToChar(qbe_scadat_chi_3->ADATA),4) */
              _cdata2 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_scadat_chi_3.GetDate("ADATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_scadat_chi_3.GetDate("ADATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_scadat_chi_3.GetDate("ADATA")),4);
              /* _cdata3 := Right(DateToChar(qbe_scadat_chi_3->CDATA),2)+Substr(DateToChar(qbe_scadat_chi_3->CDATA),5,2)+Left(DateToChar(qbe_scadat_chi_3->CDATA),4) */
              _cdata3 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_scadat_chi_3.GetDate("CDATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_scadat_chi_3.GetDate("CDATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_scadat_chi_3.GetDate("CDATA")),4);
              /* If not(Empty(qbe_scadat_chi_3->NASSTATO)) and Upper(LRTrim(qbe_scadat_chi_3->NASSTATO)) <> 'ITALIA' */
              if ( ! (CPLib.Empty(Cursor_qbe_scadat_chi_3.GetString("NASSTATO"))) && CPLib.ne(CPLib.Upper(CPLib.LRTrim(Cursor_qbe_scadat_chi_3.GetString("NASSTATO"))),"ITALIA")) {
                /* _descit := qbe_scadat_chi_3->NASSTATO */
                _descit = Cursor_qbe_scadat_chi_3.GetString("NASSTATO");
              } else { // Else
                /* _descit := qbe_scadat_chi_3->NASCOMUN */
                _descit = Cursor_qbe_scadat_chi_3.GetString("NASCOMUN");
              } // End If
              /* nProgImp := Utilities.GetAutonumber("PROGAECHIUCOD\'"+LRTrim(gAzienda)+"'",0,15) */
              nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGAECHIUCOD\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
              // * --- Insert into tmp_chiucod from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_chiucod");
              m_cPhName = m_Ctx.GetPhName("tmp_chiucod");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_chiucod")+" (";
              m_cSql = m_cSql+GetFieldsName_05E61E88(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_chi_3.GetString("APROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_chi_3.GetString("AFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_chi_3.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_chi_3.GetString("NOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_qbe_scadat_chi_3.GetString("SESSO"),"F") || CPLib.eqr(Cursor_qbe_scadat_chi_3.GetString("SESSO"),"2")?"F":"M"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_descit,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_chi_3.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_chi_3.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_chi_3.GetString("COINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_chi_3.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata3,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_chi_3.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_chi_3.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(Cursor_qbe_scadat_chi_3.GetString("OLDINTER")))?_cfint:Cursor_qbe_scadat_chi_3.GetString("OLDINTER")),"?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("tmp_chiucod")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_chiucod",true);
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
              /* _cdata2 := Right(DateToChar(qbe_scadat_chi_3->ADATA),2)+Substr(DateToChar(qbe_scadat_chi_3->ADATA),5,2)+Left(DateToChar(qbe_scadat_chi_3->ADATA),4) */
              _cdata2 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_scadat_chi_3.GetDate("ADATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_scadat_chi_3.GetDate("ADATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_scadat_chi_3.GetDate("ADATA")),4);
              /* _cdata3 := Right(DateToChar(qbe_scadat_chi_3->CDATA),2)+Substr(DateToChar(qbe_scadat_chi_3->CDATA),5,2)+Left(DateToChar(qbe_scadat_chi_3->CDATA),4) */
              _cdata3 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_scadat_chi_3.GetDate("CDATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_scadat_chi_3.GetDate("CDATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_scadat_chi_3.GetDate("CDATA")),4);
              /* nProgImp := Utilities.GetAutonumber("PROGAECHIUCOD\'"+LRTrim(gAzienda)+"'",0,15) */
              nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGAECHIUCOD\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
              // * --- Insert into tmp_chiucod from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_chiucod");
              m_cPhName = m_Ctx.GetPhName("tmp_chiucod");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_chiucod")+" (";
              m_cSql = m_cSql+GetFieldsName_06436BE0(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_chi_3.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_chi_3.GetString("COINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_chi_3.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata3,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_chi_3.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_qbe_scadat_chi_3.GetString("RAGSOC"),60),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_chi_3.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_chi_3.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_chi_3.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_chi_3.GetString("APROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_chi_3.GetString("AFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(Cursor_qbe_scadat_chi_3.GetString("OLDINTER")))?_cfint:Cursor_qbe_scadat_chi_3.GetString("OLDINTER")),"?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("tmp_chiucod")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_chiucod",true);
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
            /* _sicodrec := _sicodrec + 1 */
            _sicodrec = CPLib.Round(_sicodrec+1,0);
            /* countmp := countmp+1 // Contatore delle occorenze inserite nel temporaneo */
            countmp = CPLib.Round(countmp+1,0);
            Cursor_qbe_scadat_chi_3.Next();
          }
          m_cConnectivityError = Cursor_qbe_scadat_chi_3.ErrorMessage();
          Cursor_qbe_scadat_chi_3.Close();
          // * --- End Select
        } else { // Else
          /* gMsgImp := 'Lettura rapporti in corso ...' // Messaggio Import */
          gMsgImp = "Lettura rapporti in corso ...";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } // End If
        /* _contacilci := _contacilci+1 */
        _contacilci = CPLib.Round(_contacilci+1,0);
        /* If Mod(_top,75000)=0 or _contacilci > _cicli */
        if (CPLib.eqr(CPLib.Mod(_top,75000),0) || CPLib.gt(_contacilci,_cicli)) {
          /* If _sicodrec > 0 */
          if (CPLib.gt(_sicodrec,0)) {
            /* Cicla sul file per invii e prepara il file */
            /* _i := 1 */
            _i = CPLib.Round(1,0);
            /* _crow := 0 */
            _crow = CPLib.Round(0,0);
            /* _cfile := 0 */
            _cfile = CPLib.Round(0,0);
            /* _conta := 1 */
            _conta = CPLib.Round(1,0);
            // * --- Select from tmp_chiucod
            m_cServer = m_Ctx.GetServer("tmp_chiucod");
            m_cPhName = m_Ctx.GetPhName("tmp_chiucod");
            if (Cursor_tmp_chiucod!=null)
              Cursor_tmp_chiucod.Close();
            Cursor_tmp_chiucod = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_chiucod")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_tmp_chiucod.Eof())) {
              /* If _crow = 0 and _i=1 */
              if (CPLib.eqr(_crow,0) && CPLib.eqr(_i,1)) {
                /* Crea Record di testa */
                /* _nomefile := DateTimeToChar(DateTime())+'2' */
                _nomefile = CPLib.DateTimeToChar(CPLib.DateTime())+"2";
                /* cNomeFile := LRTrim(gPathApp)+'/flussi/'+LRTrim(gAzienda)+"/"+LRTrim(_nomefile) */
                cNomeFile = CPLib.LRTrim(gPathApp)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_nomefile);
                /* cOnlyNomeFile := _nomefile */
                cOnlyNomeFile = _nomefile;
                /* _fileita := _fileita + 1 */
                _fileita = CPLib.Round(_fileita+1,0);
                // These are the files to include in the ZIP file
                filenames.add(cNomeFile);
                fileonames.add(cOnlyNomeFile);
                /* fhand := FileLibrary.OpenWrite('./flussi/'+LRTrim(gAzienda)+"/"+LRTrim(_nomefile)) */
                fhand = FileLibrary.OpenWrite("./flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_nomefile));
                /* _file := '0CCB00' + '34' */
                _file = "0CCB00"+"34";
                /* _file := _file + LRTrim(_cfint)+Space(16 - Len(LRTrim(_cfint))) */
                _file = _file+CPLib.LRTrim(_cfint)+CPLib.Space(16-CPLib.Len(CPLib.LRTrim(_cfint)));
                /* _file := _file + Space(102) */
                _file = _file+CPLib.Space(102);
                /* _file := _file + LRTrim(_ragint)+Space(70 - Len(LRTrim(_ragint))) */
                _file = _file+CPLib.LRTrim(_ragint)+CPLib.Space(70-CPLib.Len(CPLib.LRTrim(_ragint)));
                /* _file := _file + LRTrim(_citint)+Space(40 - Len(LRTrim(_citint))) */
                _file = _file+CPLib.LRTrim(_citint)+CPLib.Space(40-CPLib.Len(CPLib.LRTrim(_citint)));
                /* _file := _file + LRTrim(_prvint)+Space(2 - Len(LRTrim(_prvint))) */
                _file = _file+CPLib.LRTrim(_prvint)+CPLib.Space(2-CPLib.Len(CPLib.LRTrim(_prvint)));
                /* _file := _file + Right("0000"+Str(Year(w_a_data),4,0),4)+Right("00"+LRTrim(Str(Month(w_a_data),2,0)),2) */
                _file = _file+CPLib.Right("0000"+CPLib.Str(CPLib.Year(w_a_data),4,0),4)+CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(CPLib.Month(w_a_data),2,0)),2);
                /* _file := _file + '2' */
                _file = _file+"2";
                /* _file := _file + Left(LRTrim(_nomefile)+Space(15),15) */
                _file = _file+CPLib.Left(CPLib.LRTrim(_nomefile)+CPLib.Space(15),15);
                /* _file := _file + Left(LRTrim(_cfinvio)+Space(16),16) */
                _file = _file+CPLib.Left(CPLib.LRTrim(_cfinvio)+CPLib.Space(16),16);
                /* _file := _file + Left(LRTrim(_cafinvio)+Space(5),5) */
                _file = _file+CPLib.Left(CPLib.LRTrim(_cafinvio)+CPLib.Space(5),5);
                /* _file := _file + Left(LRTrim(_tipinvio)+Space(1),1) */
                _file = _file+CPLib.Left(CPLib.LRTrim(_tipinvio)+CPLib.Space(1),1);
                /* _file := _file + Left(LRTrim(_impinvio)+Space(8),8) */
                _file = _file+CPLib.Left(CPLib.LRTrim(_impinvio)+CPLib.Space(8),8);
                /* _file := _file + Space(1507) */
                _file = _file+CPLib.Space(1507);
                /* _file := _file + 'A' */
                _file = _file+"A";
                /* FileLibrary.WriteLine(fhand,_file) */
                FileLibrary.WriteLine(fhand,_file);
              } // End If
              /* gMsgImp := 'Elaborazione soggetti con CF italiano al ' + LRTrim(Str(((_top-(_min-1))/(_max-(_min-1)))*100,5,2)) + '%. Sto scrivendo il file ' + LRTrim(cOnlyNomeFile)+ ' - Riga N° '+ LRTrim(Str(_crow,10,0)) // Messaggio Import */
              gMsgImp = "Elaborazione soggetti con CF italiano al "+CPLib.LRTrim(CPLib.Str(((_top-(_min-1))/(_max-(_min-1)))*100,5,2))+"%. Sto scrivendo il file "+CPLib.LRTrim(cOnlyNomeFile)+" - Riga N° "+CPLib.LRTrim(CPLib.Str(_crow,10,0));
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _r := _r + 1 */
              _r = CPLib.Round(_r+1,0);
              /* If _i = 1 */
              if (CPLib.eqr(_i,1)) {
                /* _file := tmp_chiucod->TIPOREC */
                _file = Cursor_tmp_chiucod.GetString("TIPOREC");
              } // End If
              // * --- Insert into tmp_stpfileage from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stpfileage");
              m_cPhName = m_Ctx.GetPhName("tmp_stpfileage");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_stpfileage")+" (";
              m_cSql = m_cSql+GetFieldsName_05EDD3C8(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_chiucod.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(CPLib.Str(_r)),25),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_tmp_chiucod.GetString("SESSO"))?Cursor_tmp_chiucod.GetString("DENOM"):CPLib.LRTrim(Cursor_tmp_chiucod.GetString("COGNOME"))+" "+CPLib.LRTrim(Cursor_tmp_chiucod.GetString("NOME"))),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_chiucod.GetString("DATAINI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_chiucod.GetString("DATACHIU"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_chiucod.GetString("COINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_chiucod.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_chiucod.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("tmp_stpfileage")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpfileage",true);
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
              /* _file := _file + Right("0000000000000000000000000000000000000000" + LRTrim(Str(_r)),25) */
              _file = _file+CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(CPLib.Str(_r)),25);
              /* _file := _file + Left(LRTrim(tmp_chiucod->CODINTER)+Space(16),16) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("CODINTER"))+CPLib.Space(16),16);
              /* _file := _file + Right("00000000000000000000000000" + LRTrim(tmp_chiucod->IDFILE),15) */
              _file = _file+CPLib.Right("00000000000000000000000000"+CPLib.LRTrim(Cursor_tmp_chiucod.GetString("IDFILE")),15);
              /* _file := _file + Right("0000000000000000000000000000000000000000" + LRTrim(tmp_chiucod->PROGRIF),25) */
              _file = _file+CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(Cursor_tmp_chiucod.GetString("PROGRIF")),25);
              /* _file := _file + Left(LRTrim(arfn_agechar(tmp_chiucod->CODFISC,' ')) + Space(16),16) */
              _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_tmp_chiucod.GetString("CODFISC")," "))+CPLib.Space(16),16);
              /* _file := _file + Left(LRTrim(arfn_agechar(tmp_chiucod->COGNOME,' ')) + Space(26),26) */
              _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_tmp_chiucod.GetString("COGNOME")," "))+CPLib.Space(26),26);
              /* _file := _file + Left(LRTrim(arfn_agechar(tmp_chiucod->NOME,' ')) + Space(25),25) */
              _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_tmp_chiucod.GetString("NOME")," "))+CPLib.Space(25),25);
              /* _file := _file + Left(LRTrim(tmp_chiucod->SESSO)+Space(1),1) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("SESSO"))+CPLib.Space(1),1);
              /* _file := _file + Left(LRTrim(tmp_chiucod->DATANASC) + Space(8),8) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("DATANASC"))+CPLib.Space(8),8);
              /* _file := _file + Left(LRTrim(arfn_agechar(tmp_chiucod->COMSTA,' ')) + Space(40),40) */
              _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_tmp_chiucod.GetString("COMSTA")," "))+CPLib.Space(40),40);
              /* _file := _file + Left(LRTrim(arfn_agechar(tmp_chiucod->PROVNA,' ')) + Space(2),2) */
              _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_tmp_chiucod.GetString("PROVNA")," "))+CPLib.Space(2),2);
              /* _file := _file + Left(LRTrim(arfn_agechar(tmp_chiucod->DENOM,' ')) + Space(60),60) */
              _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_tmp_chiucod.GetString("DENOM")," "))+CPLib.Space(60),60);
              /* _file := _file + Left(LRTrim(arfn_agechar(tmp_chiucod->COMSEDE,' ')) + Space(40),40) */
              _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_tmp_chiucod.GetString("COMSEDE")," "))+CPLib.Space(40),40);
              /* _file := _file + Left(LRTrim(arfn_agechar(tmp_chiucod->PROVSED,' ')) + Space(2),2) */
              _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_tmp_chiucod.GetString("PROVSED")," "))+CPLib.Space(2),2);
              /* _file := _file + Left(LRTrim(tmp_chiucod->TIPORAP) + Space(2),2) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("TIPORAP"))+CPLib.Space(2),2);
              /* _file := _file + Left(LRTrim(tmp_chiucod->COINT) + Space(1),1) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("COINT"))+CPLib.Space(1),1);
              /* _file := _file + Left(LRTrim(tmp_chiucod->DATAINI) + Space(8),8) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("DATAINI"))+CPLib.Space(8),8);
              /* _file := _file + Left(LRTrim(tmp_chiucod->DATACHIU) + Space(8),8) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("DATACHIU"))+CPLib.Space(8),8);
              /* _file := _file + Space(9) */
              _file = _file+CPLib.Space(9);
              /* _file := _file + '*' */
              _file = _file+"*";
              /* _i := _i + 1 */
              _i = CPLib.Round(_i+1,0);
              /* If _i=6 */
              if (CPLib.eqr(_i,6)) {
                /* _i := 1 */
                _i = CPLib.Round(1,0);
                /* _file := _file + Space(146) */
                _file = _file+CPLib.Space(146);
                /* _file := _file + 'A' */
                _file = _file+"A";
                /* FileLibrary.WriteLine(fhand,_file) */
                FileLibrary.WriteLine(fhand,_file);
                /* _crow := _crow + 1 */
                _crow = CPLib.Round(_crow+1,0);
              } // End If
              // * --- Write into aerighe from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("aerighe");
              m_cPhName = m_Ctx.GetPhName("aerighe");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = "Update "+m_cPhName+" set ";
              m_cSql = m_cSql+"CSPEDITO = "+CPLib.ToSQL(1,"N",1,0)+", ";
              m_cSql = m_cSql+"CPROG = "+CPLib.ToSQL(_r,"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"CFILE = "+CPLib.ToSQL(_nomefile,"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"CDTPRE = "+CPLib.ToSQL(w_a_data,"D",8,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_chiucod.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_chiucod.GetString("IDBASE"))+"";
              if (m_Ctx.IsSharedTemp("aerighe")) {
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
              /* If _crow=15000 */
              if (CPLib.eqr(_crow,15000)) {
                /* If _i > 1 and _i < 6 */
                if (CPLib.gt(_i,1) && CPLib.lt(_i,6)) {
                  /* While _i < 6 */
                  while (CPLib.lt(_i,6)) {
                    /* _file := _file + Space(329) */
                    _file = _file+CPLib.Space(329);
                    /* _file := _file + '*' */
                    _file = _file+"*";
                    /* _i := _i + 1 */
                    _i = CPLib.Round(_i+1,0);
                  } // End While
                  /* _file := _file + Space(146) */
                  _file = _file+CPLib.Space(146);
                  /* _file := _file + 'A' */
                  _file = _file+"A";
                  /* FileLibrary.WriteLine(fhand,_file) */
                  FileLibrary.WriteLine(fhand,_file);
                } // End If
                /* _file := '9CCB00' + '34' */
                _file = "9CCB00"+"34";
                /* _file := _file + LRTrim(_cfint)+Space(16 - Len(LRTrim(_cfint))) */
                _file = _file+CPLib.LRTrim(_cfint)+CPLib.Space(16-CPLib.Len(CPLib.LRTrim(_cfint)));
                /* _file := _file + Space(102) */
                _file = _file+CPLib.Space(102);
                /* _file := _file + LRTrim(_ragint)+Space(70 - Len(LRTrim(_ragint))) */
                _file = _file+CPLib.LRTrim(_ragint)+CPLib.Space(70-CPLib.Len(CPLib.LRTrim(_ragint)));
                /* _file := _file + LRTrim(_citint)+Space(40 - Len(LRTrim(_citint))) */
                _file = _file+CPLib.LRTrim(_citint)+CPLib.Space(40-CPLib.Len(CPLib.LRTrim(_citint)));
                /* _file := _file + LRTrim(_prvint)+Space(2 - Len(LRTrim(_prvint))) */
                _file = _file+CPLib.LRTrim(_prvint)+CPLib.Space(2-CPLib.Len(CPLib.LRTrim(_prvint)));
                /* _file := _file + Right("0000"+Str(Year(w_a_data),4,0),4)+Right("00"+LRTrim(Str(Month(w_a_data),2,0)),2) */
                _file = _file+CPLib.Right("0000"+CPLib.Str(CPLib.Year(w_a_data),4,0),4)+CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(CPLib.Month(w_a_data),2,0)),2);
                /* _file := _file + '2' */
                _file = _file+"2";
                /* _file := _file + Left(LRTrim(_nomefile)+Space(15),15) */
                _file = _file+CPLib.Left(CPLib.LRTrim(_nomefile)+CPLib.Space(15),15);
                /* _file := _file + Left(LRTrim(_cfinvio)+Space(16),16) */
                _file = _file+CPLib.Left(CPLib.LRTrim(_cfinvio)+CPLib.Space(16),16);
                /* _file := _file + Left(LRTrim(_cafinvio)+Space(5),5) */
                _file = _file+CPLib.Left(CPLib.LRTrim(_cafinvio)+CPLib.Space(5),5);
                /* _file := _file + Left(LRTrim(_tipinvio)+Space(1),1) */
                _file = _file+CPLib.Left(CPLib.LRTrim(_tipinvio)+CPLib.Space(1),1);
                /* _file := _file + Left(LRTrim(_impinvio)+Space(8),8) */
                _file = _file+CPLib.Left(CPLib.LRTrim(_impinvio)+CPLib.Space(8),8);
                /* _file := _file + Space(1507) */
                _file = _file+CPLib.Space(1507);
                /* _file := _file + 'A' */
                _file = _file+"A";
                /* FileLibrary.WriteLine(fhand,_file) */
                FileLibrary.WriteLine(fhand,_file);
                /* FileLibrary.Close(fhand) */
                FileLibrary.Close(fhand);
                /* _i := 1 */
                _i = CPLib.Round(1,0);
                /* _crow := 0 */
                _crow = CPLib.Round(0,0);
                /* cProg := Utilities.GetAutonumber("PRGFILES\'"+LRTrim(gAzienda)+"'",'',10) */
                cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGFILES\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
                // * --- Insert into aefiles_glob from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aefiles_glob");
                m_cPhName = m_Ctx.GetPhName("aefiles_glob");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.InsertIntoStatement(m_Ctx,"aefiles_glob")+" (";
                m_cSql = m_cSql+GetFieldsName_06433790(m_Ctx);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("Invio Periodico Chiusure Soggetti Italiani","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(w_mese,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(w_anno,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
                if (m_Ctx.IsSharedTemp("aefiles_glob")) {
                  m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                }
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aefiles_glob",true);
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
                /* _cfile := _cfile + 1 */
                _cfile = CPLib.Round(_cfile+1,0);
              } // End If
              /* _conta := _conta + 1 */
              _conta = CPLib.Round(_conta+1,0);
              Cursor_tmp_chiucod.Next();
            }
            m_cConnectivityError = Cursor_tmp_chiucod.ErrorMessage();
            Cursor_tmp_chiucod.Close();
            // * --- End Select
            /* If _crow<15000 */
            if (CPLib.lt(_crow,15000)) {
              /* If _i > 1 and _i < 6 */
              if (CPLib.gt(_i,1) && CPLib.lt(_i,6)) {
                /* While _i < 6 */
                while (CPLib.lt(_i,6)) {
                  /* _file := _file + Space(329) */
                  _file = _file+CPLib.Space(329);
                  /* _file := _file + '*' */
                  _file = _file+"*";
                  /* _i := _i + 1 */
                  _i = CPLib.Round(_i+1,0);
                } // End While
                /* _file := _file + Space(146) */
                _file = _file+CPLib.Space(146);
                /* _file := _file + 'A' */
                _file = _file+"A";
                /* FileLibrary.WriteLine(fhand,_file) */
                FileLibrary.WriteLine(fhand,_file);
              } // End If
              /* _file := '9CCB00' + '34' */
              _file = "9CCB00"+"34";
              /* _file := _file + LRTrim(_cfint)+Space(16 - Len(LRTrim(_cfint))) */
              _file = _file+CPLib.LRTrim(_cfint)+CPLib.Space(16-CPLib.Len(CPLib.LRTrim(_cfint)));
              /* _file := _file + Space(102) */
              _file = _file+CPLib.Space(102);
              /* _file := _file + LRTrim(_ragint)+Space(70 - Len(LRTrim(_ragint))) */
              _file = _file+CPLib.LRTrim(_ragint)+CPLib.Space(70-CPLib.Len(CPLib.LRTrim(_ragint)));
              /* _file := _file + LRTrim(_citint)+Space(40 - Len(LRTrim(_citint))) */
              _file = _file+CPLib.LRTrim(_citint)+CPLib.Space(40-CPLib.Len(CPLib.LRTrim(_citint)));
              /* _file := _file + LRTrim(_prvint)+Space(2 - Len(LRTrim(_prvint))) */
              _file = _file+CPLib.LRTrim(_prvint)+CPLib.Space(2-CPLib.Len(CPLib.LRTrim(_prvint)));
              /* _file := _file + Right("0000"+Str(Year(w_a_data),4,0),4)+Right("00"+LRTrim(Str(Month(w_a_data),2,0)),2) */
              _file = _file+CPLib.Right("0000"+CPLib.Str(CPLib.Year(w_a_data),4,0),4)+CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(CPLib.Month(w_a_data),2,0)),2);
              /* _file := _file + '2' */
              _file = _file+"2";
              /* _file := _file + Left(LRTrim(_nomefile)+Space(15),15) */
              _file = _file+CPLib.Left(CPLib.LRTrim(_nomefile)+CPLib.Space(15),15);
              /* _file := _file + Left(LRTrim(_cfinvio)+Space(16),16) */
              _file = _file+CPLib.Left(CPLib.LRTrim(_cfinvio)+CPLib.Space(16),16);
              /* _file := _file + Left(LRTrim(_cafinvio)+Space(5),5) */
              _file = _file+CPLib.Left(CPLib.LRTrim(_cafinvio)+CPLib.Space(5),5);
              /* _file := _file + Left(LRTrim(_tipinvio)+Space(1),1) */
              _file = _file+CPLib.Left(CPLib.LRTrim(_tipinvio)+CPLib.Space(1),1);
              /* _file := _file + Left(LRTrim(_impinvio)+Space(8),8) */
              _file = _file+CPLib.Left(CPLib.LRTrim(_impinvio)+CPLib.Space(8),8);
              /* _file := _file + Space(1507) */
              _file = _file+CPLib.Space(1507);
              /* _file := _file + 'A' */
              _file = _file+"A";
              /* FileLibrary.WriteLine(fhand,_file) */
              FileLibrary.WriteLine(fhand,_file);
              /* FileLibrary.Close(fhand) */
              FileLibrary.Close(fhand);
              /* cProg := Utilities.GetAutonumber("PRGFILES\'"+LRTrim(gAzienda)+"'",'',10) */
              cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGFILES\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
              // * --- Insert into aefiles_glob from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("aefiles_glob");
              m_cPhName = m_Ctx.GetPhName("aefiles_glob");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"aefiles_glob")+" (";
              m_cSql = m_cSql+GetFieldsName_0768C018(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Invio Periodico Chiusure Soggetti Italiani","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(w_mese,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(w_anno,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("aefiles_glob")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aefiles_glob",true);
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
              /* _cfile := _cfile + 1 */
              _cfile = CPLib.Round(_cfile+1,0);
            } // End If
          } // End If
          // * --- Delete from tmp_chiucod
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_chiucod");
          m_cPhName = m_Ctx.GetPhName("tmp_chiucod");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = "delete from "+m_cPhName;
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(1,"?",0,0,m_cServer),m_cServer,1)+"";
          if (m_Ctx.IsSharedTemp("tmp_chiucod")) {
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
          /* countmp := 0 // Contatore delle occorenze inserite nel temporaneo */
          countmp = CPLib.Round(0,0);
        } // End If
      } // End While
      /* If _fileita > 0 */
      if (CPLib.gt(_fileita,0)) {
        /* cProg := Utilities.GetAutonumber("PRGFILES\'"+LRTrim(gAzienda)+"'",'',10) */
        cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGFILES\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
        // * --- Insert into aefiles from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("aefiles");
        m_cPhName = m_Ctx.GetPhName("aefiles");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"aefiles")+" (";
        m_cSql = m_cSql+GetFieldsName_06302A28(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_czip,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Invio Periodico Chiusure Soggetti Italiani","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(w_mese,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(w_anno,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
        if (m_Ctx.IsSharedTemp("aefiles")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aefiles",true);
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
        /* Exec "Crea file zip" Page 4:Page_4 */
        Page_4();
      } // End If
      /* countmp := 0 // Contatore delle occorenze inserite nel temporaneo */
      countmp = CPLib.Round(0,0);
      /* _max := 0 */
      _max = CPLib.Round(0,0);
      /* _min := 0 */
      _min = CPLib.Round(0,0);
      /* _tot := 0 */
      _tot = CPLib.Round(0,0);
      /* _mono := 0 */
      _mono = CPLib.Round(0,0);
      /* Stranieri */
      /* _estero := 'S' */
      _estero = "S";
      // * --- Select from qbe_scadat_chi_3_max_min
      if (Cursor_qbe_scadat_chi_3_max_min!=null)
        Cursor_qbe_scadat_chi_3_max_min.Close();
      Cursor_qbe_scadat_chi_3_max_min = new VQRHolder("qbe_scadat_chi_3_max_min",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_scadat_chi_3_max_min.Eof())) {
        /* _max := qbe_scadat_chi_3_max_min->MAXPROGAER */
        _max = CPLib.Round(Cursor_qbe_scadat_chi_3_max_min.GetDouble("MAXPROGAER"),0);
        /* _min := qbe_scadat_chi_3_max_min->MINPROGAER */
        _min = CPLib.Round(Cursor_qbe_scadat_chi_3_max_min.GetDouble("MINPROGAER"),0);
        /* _tot := qbe_scadat_chi_3_max_min->TOTPROGAER */
        _tot = CPLib.Round(Cursor_qbe_scadat_chi_3_max_min.GetDouble("TOTPROGAER"),0);
        Cursor_qbe_scadat_chi_3_max_min.Next();
      }
      m_cConnectivityError = Cursor_qbe_scadat_chi_3_max_min.ErrorMessage();
      Cursor_qbe_scadat_chi_3_max_min.Close();
      // * --- End Select
      /* _mono := iif(_tot > 75000,0,1) */
      _mono = CPLib.Round((CPLib.gt(_tot,75000)?0:1),0);
      /* If _mono = 1 */
      if (CPLib.eqr(_mono,1)) {
        /* If _tot = 0 */
        if (CPLib.eqr(_tot,0)) {
          /* _cicli := 0 */
          _cicli = CPLib.Round(0,0);
        } else { // Else
          /* _cicli := 1 */
          _cicli = CPLib.Round(1,0);
        } // End If
      } else { // Else
        /* _cicli := iif(Mod(_max,5000) <> 0,Int(_max/5000) + 1,Int(_max/5000)) */
        _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,5000),0)?CPLib.Int(_max/5000)+1:CPLib.Int(_max/5000)),0);
      } // End If
      /* _contacilci := 1 */
      _contacilci = CPLib.Round(1,0);
      /* _czip := DateTimeToChar(DateTime())+"_5.zip" */
      _czip = CPLib.DateTimeToChar(CPLib.DateTime())+"_5.zip";
      /* cNomeFileZip := LRTrim(gPathApp)+'/flussi/'+LRTrim(gAzienda)+"/"+_czip */
      cNomeFileZip = CPLib.LRTrim(gPathApp)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+_czip;
      /* While _contacilci<= _cicli */
      while (CPLib.le(_contacilci,_cicli)) {
        /* If _mono = 1 */
        if (CPLib.eqr(_mono,1)) {
          /* _bottom := _min */
          _bottom = CPLib.Round(_min,0);
          /* _top := _max */
          _top = CPLib.Round(_max,0);
        } else { // Else
          /* _bottom := ((_contacilci -1 ) * 5000) + 1 */
          _bottom = CPLib.Round(((_contacilci-1)*5000)+1,0);
          /* _top := _contacilci * 5000 */
          _top = CPLib.Round(_contacilci*5000,0);
        } // End If
        /* gMsgImp := 'Lettura rapporti in corso ... Ciclo N. '+LRTrim(Str(_contacilci,10,0)) // Messaggio Import */
        gMsgImp = "Lettura rapporti in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacilci,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If _top>=_min */
        if (CPLib.ge(_top,_min)) {
          // * --- Select from qbe_scadat_chi_3
          if (Cursor_qbe_scadat_chi_3!=null)
            Cursor_qbe_scadat_chi_3.Close();
          Cursor_qbe_scadat_chi_3 = new VQRHolder("qbe_scadat_chi_3",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_scadat_chi_3.Eof())) {
            /* gMsgImp := 'Elaborazione soggetti senza CF italiano al ' + LRTrim(Str(((qbe_scadat_chi_3->PROGAER-(_min-1))/(_max-(_min-1)))*100,5,2)) + '%. Sto elaborando il rapporto N° ' + LRTrim(Str(_nocodrec+_sicodrec,10,0)) // Messaggio allineamento 1 */
            gMsgImp = "Elaborazione soggetti senza CF italiano al "+CPLib.LRTrim(CPLib.Str(((Cursor_qbe_scadat_chi_3.GetDouble("PROGAER")-(_min-1))/(_max-(_min-1)))*100,5,2))+"%. Sto elaborando il rapporto N° "+CPLib.LRTrim(CPLib.Str(_nocodrec+_sicodrec,10,0));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* _descit := '' */
            _descit = "";
            /* If not(Empty(qbe_scadat_chi_3->COGNOME)) and not(Empty(qbe_scadat_chi_3->NOME)) and not(Empty(qbe_scadat_chi_3->SESSO))  */
            if ( ! (CPLib.Empty(Cursor_qbe_scadat_chi_3.GetString("COGNOME"))) &&  ! (CPLib.Empty(Cursor_qbe_scadat_chi_3.GetString("NOME"))) &&  ! (CPLib.Empty(Cursor_qbe_scadat_chi_3.GetString("SESSO")))) {
              /* _cdata1 := Right(DateToChar(qbe_scadat_chi_3->DATANASC),2)+Substr(DateToChar(qbe_scadat_chi_3->DATANASC),5,2)+Left(DateToChar(qbe_scadat_chi_3->DATANASC),4) */
              _cdata1 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_scadat_chi_3.GetDate("DATANASC")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_scadat_chi_3.GetDate("DATANASC")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_scadat_chi_3.GetDate("DATANASC")),4);
              /* _cdata2 := Right(DateToChar(qbe_scadat_chi_3->ADATA),2)+Substr(DateToChar(qbe_scadat_chi_3->ADATA),5,2)+Left(DateToChar(qbe_scadat_chi_3->ADATA),4) */
              _cdata2 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_scadat_chi_3.GetDate("ADATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_scadat_chi_3.GetDate("ADATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_scadat_chi_3.GetDate("ADATA")),4);
              /* _cdata3 := Right(DateToChar(qbe_scadat_chi_3->CDATA),2)+Substr(DateToChar(qbe_scadat_chi_3->CDATA),5,2)+Left(DateToChar(qbe_scadat_chi_3->CDATA),4) */
              _cdata3 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_scadat_chi_3.GetDate("CDATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_scadat_chi_3.GetDate("CDATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_scadat_chi_3.GetDate("CDATA")),4);
              /* nProgImp := Utilities.GetAutonumber("PROGAECHIUNOCOD\'"+LRTrim(gAzienda)+"'",0,15) */
              nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGAECHIUNOCOD\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
              // * --- Insert into tmp_chiunocod from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_chiunocod");
              m_cPhName = m_Ctx.GetPhName("tmp_chiunocod");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_chiunocod")+" (";
              m_cSql = m_cSql+GetFieldsName_07257BB0(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL("5","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_chi_3.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_chi_3.GetString("NOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_qbe_scadat_chi_3.GetString("SESSO"),"F") || CPLib.eqr(Cursor_qbe_scadat_chi_3.GetString("SESSO"),"2")?"F":"M"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_chi_3.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("EE","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_chi_3.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_chi_3.GetString("COINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_chi_3.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata3,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_chi_3.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_chi_3.GetString("APROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_chi_3.GetString("AFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(Cursor_qbe_scadat_chi_3.GetString("OLDINTER")))?_cfint:Cursor_qbe_scadat_chi_3.GetString("OLDINTER")),"?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("tmp_chiunocod")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_chiunocod",true);
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
              /* If not(Empty(qbe_scadat_chi_3->PAESE)) */
              if ( ! (CPLib.Empty(Cursor_qbe_scadat_chi_3.GetString("PAESE")))) {
                // * --- Read from tbstati
                m_cServer = m_Ctx.GetServer("tbstati");
                m_cPhName = m_Ctx.GetPhName("tbstati");
                m_cSql = "";
                m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_scadat_chi_3.GetString("PAESE"),"C",3,0,m_cServer),m_cServer,Cursor_qbe_scadat_chi_3.GetString("PAESE"));
                if (m_Ctx.IsSharedTemp("tbstati")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _descit = Read_Cursor.GetString("DESCRI");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on tbstati into routine arrt_sd_aprichiudi returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _descit = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* _descit := iif(not(Empty(_descit)),_descit,qbe_scadat_chi_3->DESCCIT) */
                _descit = ( ! (CPLib.Empty(_descit))?_descit:Cursor_qbe_scadat_chi_3.GetString("DESCCIT"));
              } else { // Else
                /* _descit := qbe_scadat_chi_3->DESCCIT */
                _descit = Cursor_qbe_scadat_chi_3.GetString("DESCCIT");
              } // End If
              /* _cdata2 := Right(DateToChar(qbe_scadat_chi_3->ADATA),2)+Substr(DateToChar(qbe_scadat_chi_3->ADATA),5,2)+Left(DateToChar(qbe_scadat_chi_3->ADATA),4) */
              _cdata2 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_scadat_chi_3.GetDate("ADATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_scadat_chi_3.GetDate("ADATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_scadat_chi_3.GetDate("ADATA")),4);
              /* _cdata3 := Right(DateToChar(qbe_scadat_chi_3->CDATA),2)+Substr(DateToChar(qbe_scadat_chi_3->CDATA),5,2)+Left(DateToChar(qbe_scadat_chi_3->CDATA),4) */
              _cdata3 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_scadat_chi_3.GetDate("CDATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_scadat_chi_3.GetDate("CDATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_scadat_chi_3.GetDate("CDATA")),4);
              /* nProgImp := Utilities.GetAutonumber("PROGAECHIUNOCOD\'"+LRTrim(gAzienda)+"'",0,15) */
              nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGAECHIUNOCOD\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
              // * --- Insert into tmp_chiunocod from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_chiunocod");
              m_cPhName = m_Ctx.GetPhName("tmp_chiunocod");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_chiunocod")+" (";
              m_cSql = m_cSql+GetFieldsName_076CC2C8(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL("5","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_chi_3.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_chi_3.GetString("COINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_chi_3.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata3,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_chi_3.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_qbe_scadat_chi_3.GetString("RAGSOC"),60),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_descit,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_qbe_scadat_chi_3.GetString("PROVINCIA"))?"EE":Cursor_qbe_scadat_chi_3.GetString("PROVINCIA")),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_chi_3.GetString("APROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_scadat_chi_3.GetString("AFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(Cursor_qbe_scadat_chi_3.GetString("OLDINTER")))?_cfint:Cursor_qbe_scadat_chi_3.GetString("OLDINTER")),"?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("tmp_chiunocod")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_chiunocod",true);
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
            /* _nocodrec := _nocodrec + 1 */
            _nocodrec = CPLib.Round(_nocodrec+1,0);
            /* countmp := countmp+1 // Contatore delle occorenze inserite nel temporaneo */
            countmp = CPLib.Round(countmp+1,0);
            Cursor_qbe_scadat_chi_3.Next();
          }
          m_cConnectivityError = Cursor_qbe_scadat_chi_3.ErrorMessage();
          Cursor_qbe_scadat_chi_3.Close();
          // * --- End Select
        } else { // Else
          /* gMsgImp := 'Lettura rapporti in corso ...' // Messaggio Import */
          gMsgImp = "Lettura rapporti in corso ...";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } // End If
        /* _contacilci := _contacilci+1 */
        _contacilci = CPLib.Round(_contacilci+1,0);
        /* If Mod(_top,75000)=0 or _contacilci > _cicli */
        if (CPLib.eqr(CPLib.Mod(_top,75000),0) || CPLib.gt(_contacilci,_cicli)) {
          /* If _nocodrec > 0 */
          if (CPLib.gt(_nocodrec,0)) {
            /* Cicla sul file per invii e prepara il file */
            /* _i := 1 */
            _i = CPLib.Round(1,0);
            /* _crow := 0 */
            _crow = CPLib.Round(0,0);
            /* _cfile := 0 */
            _cfile = CPLib.Round(0,0);
            /* _conta := 1 */
            _conta = CPLib.Round(1,0);
            // * --- Select from tmp_chiunocod
            m_cServer = m_Ctx.GetServer("tmp_chiunocod");
            m_cPhName = m_Ctx.GetPhName("tmp_chiunocod");
            if (Cursor_tmp_chiunocod!=null)
              Cursor_tmp_chiunocod.Close();
            Cursor_tmp_chiunocod = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_chiunocod")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_tmp_chiunocod.Eof())) {
              /* If _crow = 0 and _i=1 */
              if (CPLib.eqr(_crow,0) && CPLib.eqr(_i,1)) {
                /* Crea Record di testa */
                /* _fileest := _fileest + 1 */
                _fileest = CPLib.Round(_fileest+1,0);
                /* _nomefile := DateTimeToChar(DateTime())+'5' */
                _nomefile = CPLib.DateTimeToChar(CPLib.DateTime())+"5";
                /* cNomeFile := LRTrim(gPathApp)+'/flussi/'+LRTrim(gAzienda)+"/"+LRTrim(_nomefile) */
                cNomeFile = CPLib.LRTrim(gPathApp)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_nomefile);
                /* cOnlyNomeFile := _nomefile */
                cOnlyNomeFile = _nomefile;
                // These are the files to include in the ZIP file
                filenames.add(cNomeFile);
                fileonames.add(cOnlyNomeFile);
                /* fhand := FileLibrary.OpenWrite('./flussi/'+LRTrim(gAzienda)+"/"+LRTrim(_nomefile)) */
                fhand = FileLibrary.OpenWrite("./flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_nomefile));
                /* _file := '0CCB00' + '34' */
                _file = "0CCB00"+"34";
                /* _file := _file + LRTrim(_cfint)+Space(16 - Len(LRTrim(_cfint))) */
                _file = _file+CPLib.LRTrim(_cfint)+CPLib.Space(16-CPLib.Len(CPLib.LRTrim(_cfint)));
                /* _file := _file + Space(102) */
                _file = _file+CPLib.Space(102);
                /* _file := _file + LRTrim(_ragint)+Space(70 - Len(LRTrim(_ragint))) */
                _file = _file+CPLib.LRTrim(_ragint)+CPLib.Space(70-CPLib.Len(CPLib.LRTrim(_ragint)));
                /* _file := _file + LRTrim(_citint)+Space(40 - Len(LRTrim(_citint))) */
                _file = _file+CPLib.LRTrim(_citint)+CPLib.Space(40-CPLib.Len(CPLib.LRTrim(_citint)));
                /* _file := _file + LRTrim(_prvint)+Space(2 - Len(LRTrim(_prvint))) */
                _file = _file+CPLib.LRTrim(_prvint)+CPLib.Space(2-CPLib.Len(CPLib.LRTrim(_prvint)));
                /* _file := _file + Right("0000"+Str(Year(w_a_data),4,0),4)+Right("00"+LRTrim(Str(Month(w_a_data),2,0)),2) */
                _file = _file+CPLib.Right("0000"+CPLib.Str(CPLib.Year(w_a_data),4,0),4)+CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(CPLib.Month(w_a_data),2,0)),2);
                /* _file := _file + '5' */
                _file = _file+"5";
                /* _file := _file + Left(LRTrim(_nomefile)+Space(15),15) */
                _file = _file+CPLib.Left(CPLib.LRTrim(_nomefile)+CPLib.Space(15),15);
                /* _file := _file + Left(LRTrim(_cfinvio)+Space(16),16) */
                _file = _file+CPLib.Left(CPLib.LRTrim(_cfinvio)+CPLib.Space(16),16);
                /* _file := _file + Left(LRTrim(_cafinvio)+Space(5),5) */
                _file = _file+CPLib.Left(CPLib.LRTrim(_cafinvio)+CPLib.Space(5),5);
                /* _file := _file + Left(LRTrim(_tipinvio)+Space(1),1) */
                _file = _file+CPLib.Left(CPLib.LRTrim(_tipinvio)+CPLib.Space(1),1);
                /* _file := _file + Left(LRTrim(_impinvio)+Space(8),8) */
                _file = _file+CPLib.Left(CPLib.LRTrim(_impinvio)+CPLib.Space(8),8);
                /* _file := _file + Space(1507) */
                _file = _file+CPLib.Space(1507);
                /* _file := _file + 'A' */
                _file = _file+"A";
                /* FileLibrary.WriteLine(fhand,_file) */
                FileLibrary.WriteLine(fhand,_file);
              } // End If
              /* gMsgImp := 'Sto scrivendo il file ' + LRTrim(cOnlyNomeFile)+ ' - Riga N° '+ LRTrim(Str(_crow,10,0)) // Messaggio Import */
              gMsgImp = "Sto scrivendo il file "+CPLib.LRTrim(cOnlyNomeFile)+" - Riga N° "+CPLib.LRTrim(CPLib.Str(_crow,10,0));
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _r := _r + 1 */
              _r = CPLib.Round(_r+1,0);
              /* If _i = 1 */
              if (CPLib.eqr(_i,1)) {
                /* _file := tmp_chiunocod->TIPOREC */
                _file = Cursor_tmp_chiunocod.GetString("TIPOREC");
              } // End If
              // * --- Insert into tmp_stpfileage from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stpfileage");
              m_cPhName = m_Ctx.GetPhName("tmp_stpfileage");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_stpfileage")+" (";
              m_cSql = m_cSql+GetFieldsName_06DDE2A8(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("5","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_chiunocod.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(CPLib.Str(_r)),25),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_tmp_chiunocod.GetString("SESSO"))?Cursor_tmp_chiunocod.GetString("DENOM"):CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("COGNOME"))+" "+CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("NOME"))),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_chiunocod.GetString("DATAINI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_chiunocod.GetString("DATACHIU"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_chiunocod.GetString("COINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_chiunocod.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("tmp_stpfileage")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpfileage",true);
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
              /* _file := _file + Right("0000000000000000000000000000000000000000" + LRTrim(Str(_r)),25) */
              _file = _file+CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(CPLib.Str(_r)),25);
              /* _file := _file + Left(LRTrim(tmp_chiunocod->CODINTER)+Space(16),16) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("CODINTER"))+CPLib.Space(16),16);
              /* _file := _file + Right("00000000000000000000000000" + LRTrim(tmp_chiunocod->IDFILE),15) */
              _file = _file+CPLib.Right("00000000000000000000000000"+CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("IDFILE")),15);
              /* _file := _file + Right("0000000000000000000000000000000000000000" + LRTrim(tmp_chiunocod->PROGRIF),25) */
              _file = _file+CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("PROGRIF")),25);
              /* _file := _file + Left(LRTrim(arfn_agechar(tmp_chiunocod->COGNOME,' ')) + Space(26),26) */
              _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_tmp_chiunocod.GetString("COGNOME")," "))+CPLib.Space(26),26);
              /* _file := _file + Left(LRTrim(arfn_agechar(tmp_chiunocod->NOME,' ')) + Space(25),25) */
              _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_tmp_chiunocod.GetString("NOME")," "))+CPLib.Space(25),25);
              /* _file := _file + Left(LRTrim(tmp_chiunocod->SESSO)+Space(1),1) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("SESSO"))+CPLib.Space(1),1);
              /* _file := _file + Left(LRTrim(tmp_chiunocod->DATANASC) + Space(8),8) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("DATANASC"))+CPLib.Space(8),8);
              /* _file := _file + Left(LRTrim(arfn_agechar(tmp_chiunocod->COMSTA,' ')) + Space(40),40) */
              _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_tmp_chiunocod.GetString("COMSTA")," "))+CPLib.Space(40),40);
              /* _file := _file + Left(LRTrim(arfn_agechar(tmp_chiunocod->PROVNA,' ')) + Space(2),2) */
              _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_tmp_chiunocod.GetString("PROVNA")," "))+CPLib.Space(2),2);
              /* _file := _file + Left(LRTrim(arfn_agechar(tmp_chiunocod->DENOM,' ')) + Space(60),60) */
              _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_tmp_chiunocod.GetString("DENOM")," "))+CPLib.Space(60),60);
              /* _file := _file + Left(LRTrim(arfn_agechar(tmp_chiunocod->COMSEDE,' ')) + Space(40),40) */
              _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_tmp_chiunocod.GetString("COMSEDE")," "))+CPLib.Space(40),40);
              /* _file := _file + Left(LRTrim(arfn_agechar(tmp_chiunocod->PROVSED,' ')) + Space(2),2) */
              _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_tmp_chiunocod.GetString("PROVSED")," "))+CPLib.Space(2),2);
              /* _file := _file + Left(LRTrim(tmp_chiunocod->TIPORAP) + Space(2),2) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("TIPORAP"))+CPLib.Space(2),2);
              /* _file := _file + Left(LRTrim(tmp_chiunocod->COINT) + Space(1),1) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("COINT"))+CPLib.Space(1),1);
              /* _file := _file + Left(LRTrim(tmp_chiunocod->DATAINI) + Space(8),8) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("DATAINI"))+CPLib.Space(8),8);
              /* _file := _file + Left(LRTrim(tmp_chiunocod->DATACHIU) + Space(8),8) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("DATACHIU"))+CPLib.Space(8),8);
              /* _file := _file + Space(25) */
              _file = _file+CPLib.Space(25);
              /* _file := _file + '*' */
              _file = _file+"*";
              /* _i := _i + 1 */
              _i = CPLib.Round(_i+1,0);
              /* If _i=6 */
              if (CPLib.eqr(_i,6)) {
                /* _i := 1 */
                _i = CPLib.Round(1,0);
                /* _file := _file + Space(146) */
                _file = _file+CPLib.Space(146);
                /* _file := _file + 'A' */
                _file = _file+"A";
                /* FileLibrary.WriteLine(fhand,_file) */
                FileLibrary.WriteLine(fhand,_file);
                /* _crow := _crow + 1 */
                _crow = CPLib.Round(_crow+1,0);
              } // End If
              // * --- Write into aerighe from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("aerighe");
              m_cPhName = m_Ctx.GetPhName("aerighe");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = "Update "+m_cPhName+" set ";
              m_cSql = m_cSql+"CSPEDITO = "+CPLib.ToSQL(1,"N",1,0)+", ";
              m_cSql = m_cSql+"CPROG = "+CPLib.ToSQL(_r,"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"CFILE = "+CPLib.ToSQL(_nomefile,"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"CDTPRE = "+CPLib.ToSQL(w_a_data,"D",8,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_chiunocod.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_chiunocod.GetString("IDBASE"))+"";
              if (m_Ctx.IsSharedTemp("aerighe")) {
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
              /* If _crow=15000 */
              if (CPLib.eqr(_crow,15000)) {
                /* If _i > 1 and _i < 6 */
                if (CPLib.gt(_i,1) && CPLib.lt(_i,6)) {
                  /* While _i < 6 */
                  while (CPLib.lt(_i,6)) {
                    /* _file := _file + Space(329) */
                    _file = _file+CPLib.Space(329);
                    /* _file := _file + '*' */
                    _file = _file+"*";
                    /* _i := _i + 1 */
                    _i = CPLib.Round(_i+1,0);
                  } // End While
                  /* _file := _file + Space(146) */
                  _file = _file+CPLib.Space(146);
                  /* _file := _file + 'A' */
                  _file = _file+"A";
                  /* FileLibrary.WriteLine(fhand,_file) */
                  FileLibrary.WriteLine(fhand,_file);
                } // End If
                /* _file := '9CCB00' + '34' */
                _file = "9CCB00"+"34";
                /* _file := _file + LRTrim(_cfint)+Space(16 - Len(LRTrim(_cfint))) */
                _file = _file+CPLib.LRTrim(_cfint)+CPLib.Space(16-CPLib.Len(CPLib.LRTrim(_cfint)));
                /* _file := _file + Space(102) */
                _file = _file+CPLib.Space(102);
                /* _file := _file + LRTrim(_ragint)+Space(70 - Len(LRTrim(_ragint))) */
                _file = _file+CPLib.LRTrim(_ragint)+CPLib.Space(70-CPLib.Len(CPLib.LRTrim(_ragint)));
                /* _file := _file + LRTrim(_citint)+Space(40 - Len(LRTrim(_citint))) */
                _file = _file+CPLib.LRTrim(_citint)+CPLib.Space(40-CPLib.Len(CPLib.LRTrim(_citint)));
                /* _file := _file + LRTrim(_prvint)+Space(2 - Len(LRTrim(_prvint))) */
                _file = _file+CPLib.LRTrim(_prvint)+CPLib.Space(2-CPLib.Len(CPLib.LRTrim(_prvint)));
                /* _file := _file + Right("0000"+Str(Year(w_a_data),4,0),4)+Right("00"+LRTrim(Str(Month(w_a_data),2,0)),2) */
                _file = _file+CPLib.Right("0000"+CPLib.Str(CPLib.Year(w_a_data),4,0),4)+CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(CPLib.Month(w_a_data),2,0)),2);
                /* _file := _file + '5' */
                _file = _file+"5";
                /* _file := _file + Left(LRTrim(_nomefile)+Space(15),15) */
                _file = _file+CPLib.Left(CPLib.LRTrim(_nomefile)+CPLib.Space(15),15);
                /* _file := _file + Left(LRTrim(_cfinvio)+Space(16),16) */
                _file = _file+CPLib.Left(CPLib.LRTrim(_cfinvio)+CPLib.Space(16),16);
                /* _file := _file + Left(LRTrim(_cafinvio)+Space(5),5) */
                _file = _file+CPLib.Left(CPLib.LRTrim(_cafinvio)+CPLib.Space(5),5);
                /* _file := _file + Left(LRTrim(_tipinvio)+Space(1),1) */
                _file = _file+CPLib.Left(CPLib.LRTrim(_tipinvio)+CPLib.Space(1),1);
                /* _file := _file + Left(LRTrim(_impinvio)+Space(8),8) */
                _file = _file+CPLib.Left(CPLib.LRTrim(_impinvio)+CPLib.Space(8),8);
                /* _file := _file + Space(1507) */
                _file = _file+CPLib.Space(1507);
                /* _file := _file + 'A' */
                _file = _file+"A";
                /* FileLibrary.WriteLine(fhand,_file) */
                FileLibrary.WriteLine(fhand,_file);
                /* FileLibrary.Close(fhand) */
                FileLibrary.Close(fhand);
                /* _i := 1 */
                _i = CPLib.Round(1,0);
                /* _crow := 0 */
                _crow = CPLib.Round(0,0);
                /* cProg := Utilities.GetAutonumber("PRGFILES\'"+LRTrim(gAzienda)+"'",'',10) */
                cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGFILES\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
                // * --- Insert into aefiles_glob from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aefiles_glob");
                m_cPhName = m_Ctx.GetPhName("aefiles_glob");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.InsertIntoStatement(m_Ctx,"aefiles_glob")+" (";
                m_cSql = m_cSql+GetFieldsName_06BD2B38(m_Ctx);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("Invio Periodico Chiusure Soggetti Esteri","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(w_mese,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(w_anno,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
                if (m_Ctx.IsSharedTemp("aefiles_glob")) {
                  m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                }
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aefiles_glob",true);
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
                /* _cfile := _cfile + 1 */
                _cfile = CPLib.Round(_cfile+1,0);
              } // End If
              /* _conta := _conta + 1 */
              _conta = CPLib.Round(_conta+1,0);
              Cursor_tmp_chiunocod.Next();
            }
            m_cConnectivityError = Cursor_tmp_chiunocod.ErrorMessage();
            Cursor_tmp_chiunocod.Close();
            // * --- End Select
            /* If _crow < 15000 */
            if (CPLib.lt(_crow,15000)) {
              /* If _i > 1 and _i < 6 */
              if (CPLib.gt(_i,1) && CPLib.lt(_i,6)) {
                /* While _i < 6 */
                while (CPLib.lt(_i,6)) {
                  /* _file := _file + Space(329) */
                  _file = _file+CPLib.Space(329);
                  /* _file := _file + '*' */
                  _file = _file+"*";
                  /* _i := _i + 1 */
                  _i = CPLib.Round(_i+1,0);
                } // End While
                /* _file := _file + Space(146) */
                _file = _file+CPLib.Space(146);
                /* _file := _file + 'A' */
                _file = _file+"A";
                /* FileLibrary.WriteLine(fhand,_file) */
                FileLibrary.WriteLine(fhand,_file);
              } // End If
              /* _file := '9CCB00' + '34' */
              _file = "9CCB00"+"34";
              /* _file := _file + LRTrim(_cfint)+Space(16 - Len(LRTrim(_cfint))) */
              _file = _file+CPLib.LRTrim(_cfint)+CPLib.Space(16-CPLib.Len(CPLib.LRTrim(_cfint)));
              /* _file := _file + Space(102) */
              _file = _file+CPLib.Space(102);
              /* _file := _file + LRTrim(_ragint)+Space(70 - Len(LRTrim(_ragint))) */
              _file = _file+CPLib.LRTrim(_ragint)+CPLib.Space(70-CPLib.Len(CPLib.LRTrim(_ragint)));
              /* _file := _file + LRTrim(_citint)+Space(40 - Len(LRTrim(_citint))) */
              _file = _file+CPLib.LRTrim(_citint)+CPLib.Space(40-CPLib.Len(CPLib.LRTrim(_citint)));
              /* _file := _file + LRTrim(_prvint)+Space(2 - Len(LRTrim(_prvint))) */
              _file = _file+CPLib.LRTrim(_prvint)+CPLib.Space(2-CPLib.Len(CPLib.LRTrim(_prvint)));
              /* _file := _file + Right("0000"+Str(Year(w_a_data),4,0),4)+Right("00"+LRTrim(Str(Month(w_a_data),2,0)),2) */
              _file = _file+CPLib.Right("0000"+CPLib.Str(CPLib.Year(w_a_data),4,0),4)+CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(CPLib.Month(w_a_data),2,0)),2);
              /* _file := _file + '5' */
              _file = _file+"5";
              /* _file := _file + Left(LRTrim(_nomefile)+Space(15),15) */
              _file = _file+CPLib.Left(CPLib.LRTrim(_nomefile)+CPLib.Space(15),15);
              /* _file := _file + Left(LRTrim(_cfinvio)+Space(16),16) */
              _file = _file+CPLib.Left(CPLib.LRTrim(_cfinvio)+CPLib.Space(16),16);
              /* _file := _file + Left(LRTrim(_cafinvio)+Space(5),5) */
              _file = _file+CPLib.Left(CPLib.LRTrim(_cafinvio)+CPLib.Space(5),5);
              /* _file := _file + Left(LRTrim(_tipinvio)+Space(1),1) */
              _file = _file+CPLib.Left(CPLib.LRTrim(_tipinvio)+CPLib.Space(1),1);
              /* _file := _file + Left(LRTrim(_impinvio)+Space(8),8) */
              _file = _file+CPLib.Left(CPLib.LRTrim(_impinvio)+CPLib.Space(8),8);
              /* _file := _file + Space(1507) */
              _file = _file+CPLib.Space(1507);
              /* _file := _file + 'A' */
              _file = _file+"A";
              /* FileLibrary.WriteLine(fhand,_file) */
              FileLibrary.WriteLine(fhand,_file);
              /* FileLibrary.Close(fhand) */
              FileLibrary.Close(fhand);
              /* cProg := Utilities.GetAutonumber("PRGFILES\'"+LRTrim(gAzienda)+"'",'',10) */
              cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGFILES\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
              // * --- Insert into aefiles_glob from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("aefiles_glob");
              m_cPhName = m_Ctx.GetPhName("aefiles_glob");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"aefiles_glob")+" (";
              m_cSql = m_cSql+GetFieldsName_074139F0(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Invio Periodico Chiusure Soggetti Esteri","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(w_mese,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(w_anno,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("aefiles_glob")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aefiles_glob",true);
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
              /* _cfile := _cfile + 1 */
              _cfile = CPLib.Round(_cfile+1,0);
            } // End If
          } // End If
          // * --- Delete from tmp_chiunocod
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_chiunocod");
          m_cPhName = m_Ctx.GetPhName("tmp_chiunocod");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = "delete from "+m_cPhName;
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(1,"?",0,0,m_cServer),m_cServer,1)+"";
          if (m_Ctx.IsSharedTemp("tmp_chiunocod")) {
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
          /* countmp := 0 // Contatore delle occorenze inserite nel temporaneo */
          countmp = CPLib.Round(0,0);
        } // End If
      } // End While
      /* If _fileest > 0 */
      if (CPLib.gt(_fileest,0)) {
        /* cProg := Utilities.GetAutonumber("PRGFILES\'"+LRTrim(gAzienda)+"'",'',10) */
        cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGFILES\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
        // * --- Insert into aefiles from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("aefiles");
        m_cPhName = m_Ctx.GetPhName("aefiles");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"aefiles")+" (";
        m_cSql = m_cSql+GetFieldsName_07472FC8(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_czip,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Invio Periodico Chiusure Soggetti Esteri","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(w_mese,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(w_anno,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
        if (m_Ctx.IsSharedTemp("aefiles")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aefiles",true);
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
        /* Exec "Crea file zip" Page 4:Page_4 */
        Page_4();
      } // End If
    } finally {
      try {
        if (Cursor_qbe_scadat_chi_3_max_min!=null)
          Cursor_qbe_scadat_chi_3_max_min.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_scadat_chi_3!=null)
          Cursor_qbe_scadat_chi_3.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tmp_chiucod!=null)
          Cursor_tmp_chiucod.Close();
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
        if (Cursor_tmp_chiunocod!=null)
          Cursor_tmp_chiunocod.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_4() throws Exception {
    // Create a buffer for reading the files
        byte[] buf = new byte[1024];
        
        try {
            // Create the ZIP file
            String outFilename = cNomeFileZip;
            java.util.zip.ZipOutputStream out = new java.util.zip.ZipOutputStream(new java.io.FileOutputStream(outFilename));
        
            // Compress the files
            for (int i=0; i<filenames.size(); i++) {
                _file1=(String)filenames.elementAt(i);
                _file2=(String)fileonames.elementAt(i);
                java.io.FileInputStream in = new java.io.FileInputStream(_file1);
        
                // Add ZIP entry to output stream.
                out.putNextEntry(new java.util.zip.ZipEntry(_file2));
        
                // Transfer bytes from the file to the ZIP file
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
        
                // Complete the entry
                out.closeEntry();
                in.close();
                FileLibrary.DeleteFile(CPLib.LRTrim(gPathApp)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_file2));
            }
        
            // Complete the ZIP file
            out.close();
            filenames.removeAllElements();
            fileonames.removeAllElements();
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
      m_Caller.SetDate("a_data","D",8,0,w_a_data);
      m_Caller.SetDate("dadata","D",8,0,w_dadata);
      m_Caller.SetDate("datpri","D",8,0,w_datpri);
      m_Caller.SetDate("datsecf","D",8,0,w_datsecf);
      m_Caller.SetDate("datseci","D",8,0,w_datseci);
      m_Caller.SetString("iniz","C",1,0,w_iniz);
      m_Caller.SetString("seco","C",1,0,w_seco);
      m_Caller.SetNumber("files","N",1,0,w_files);
      m_Caller.SetNumber("anno","N",4,0,w_anno);
      m_Caller.SetString("mese","C",2,0,w_mese);
      m_Caller.SetString("FILEINVIO","C",1,0,w_FILEINVIO);
      m_Caller.SetDate("DATAINVIO","D",8,0,w_DATAINVIO);
      m_Caller.SetString("CFINVIO","C",16,0,w_CFINVIO);
      m_Caller.SetString("CAFINVIO","C",5,0,w_CAFINVIO);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_sd_aprichiudiR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_sd_aprichiudiR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_a_data = m_Caller.GetDate("a_data","D",8,0);
    w_dadata = m_Caller.GetDate("dadata","D",8,0);
    w_datpri = m_Caller.GetDate("datpri","D",8,0);
    w_datsecf = m_Caller.GetDate("datsecf","D",8,0);
    w_datseci = m_Caller.GetDate("datseci","D",8,0);
    w_iniz = m_Caller.GetString("iniz","C",1,0);
    w_seco = m_Caller.GetString("seco","C",1,0);
    w_files = m_Caller.GetNumber("files","N",1,0);
    w_anno = m_Caller.GetNumber("anno","N",4,0);
    w_mese = m_Caller.GetString("mese","C",2,0);
    w_FILEINVIO = m_Caller.GetString("FILEINVIO","C",1,0);
    w_DATAINVIO = m_Caller.GetDate("DATAINVIO","D",8,0);
    w_CFINVIO = m_Caller.GetString("CFINVIO","C",16,0);
    w_CAFINVIO = m_Caller.GetString("CAFINVIO","C",5,0);
    _errlog = "";
    imprec = 0;
    _noprot = 0;
    _rapold = CPLib.Space(25);
    _tipoco = CPLib.Space(1);
    _nriga = 0;
    _newrow = 0;
    _cdata1 = CPLib.Space(8);
    _cdata2 = CPLib.Space(8);
    _cdata3 = CPLib.Space(8);
    _cdata4 = CPLib.Space(8);
    _descit = CPLib.Space(40);
    _file = "";
    _nomefile = CPLib.Space(15);
    _r = 0;
    _i = 0;
    fhand = CPLib.Space(10);
    cNomeFile = CPLib.Space(30);
    cOnlyNomeFile = CPLib.Space(30);
    cNomeFileZip = CPLib.Space(30);
    cProg = CPLib.Space(10);
    _nocodrec = 0;
    _sicodrec = 0;
    _crow = 0;
    _cfile = 0;
    _conta = 0;
    _cfint = CPLib.Space(16);
    _ragint = CPLib.Space(70);
    _citint = CPLib.Space(40);
    _prvint = CPLib.Space(2);
    _file1 = CPLib.Space(30);
    _file2 = CPLib.Space(30);
    _czip = CPLib.Space(20);
    _max = 0;
    _min = 0;
    _tot = 0;
    _mono = 0;
    _cicli = 0;
    _contacilci = 0;
    _bottom = 0;
    _top = 0;
    nProgImp = 0;
    _fileita = 0;
    _fileest = 0;
    countmp = 0;
    _estero = CPLib.Space(1);
    _cfinvio = CPLib.Space(16);
    _cafinvio = CPLib.Space(5);
    _tipinvio = CPLib.Space(1);
    _impinvio = CPLib.Space(8);
    _datinvio = CPLib.NullDate();
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gFilesAge=m_Ctx.GetGlobalNumber("gFilesAge");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_scadat_ape_3_max_min,qbe_scadat_ape_3,qbe_scadat_ape_3_max_min,qbe_scadat_ape_3,qbe_scadat_chi_3_max_min,qbe_scadat_chi_3,qbe_scadat_chi_3_max_min,qbe_scadat_chi_3,
  public static final String m_cVQRList = ",qbe_scadat_ape_3_max_min,qbe_scadat_ape_3,qbe_scadat_ape_3_max_min,qbe_scadat_ape_3,qbe_scadat_chi_3_max_min,qbe_scadat_chi_3,qbe_scadat_chi_3_max_min,qbe_scadat_chi_3,";
  // ENTITY_BATCHES: ,arfn_agechar,
  public static final String i_InvokedRoutines = ",arfn_agechar,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_06305458(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPOREC,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"COMSTA,";
    p_cSql = p_cSql+"PROVNA,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATACHIU,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"progae,";
    if (p_Ctx.IsSharedTemp("tmp_apecod")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_apecod",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0634C018(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPOREC,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATACHIU,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DENOM,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"COMSEDE,";
    p_cSql = p_cSql+"PROVSED,";
    p_cSql = p_cSql+"progae,";
    if (p_Ctx.IsSharedTemp("tmp_apecod")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_apecod",true);
    return p_cSql;
  }
  protected static String GetFieldsName_04186960(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"tipofile,";
    p_cSql = p_cSql+"rapporto,";
    p_cSql = p_cSql+"nprog,";
    p_cSql = p_cSql+"ragsoc,";
    p_cSql = p_cSql+"datini,";
    p_cSql = p_cSql+"datfin,";
    p_cSql = p_cSql+"tiporap,";
    p_cSql = p_cSql+"agerap,";
    p_cSql = p_cSql+"connes,";
    if (p_Ctx.IsSharedTemp("tmp_stpfileage")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpfileage",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0705BAC8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"idfile,";
    p_cSql = p_cSql+"datafile,";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"descfile,";
    p_cSql = p_cSql+"mese,";
    p_cSql = p_cSql+"anno,";
    p_cSql = p_cSql+"filename,";
    if (p_Ctx.IsSharedTemp("aefiles_glob")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aefiles_glob",true);
    return p_cSql;
  }
  protected static String GetFieldsName_077C19E0(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"idfile,";
    p_cSql = p_cSql+"datafile,";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"descfile,";
    p_cSql = p_cSql+"mese,";
    p_cSql = p_cSql+"anno,";
    p_cSql = p_cSql+"filename,";
    if (p_Ctx.IsSharedTemp("aefiles_glob")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aefiles_glob",true);
    return p_cSql;
  }
  protected static String GetFieldsName_041754E8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"idfile,";
    p_cSql = p_cSql+"datafile,";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"descfile,";
    p_cSql = p_cSql+"mese,";
    p_cSql = p_cSql+"anno,";
    p_cSql = p_cSql+"filename,";
    if (p_Ctx.IsSharedTemp("aefiles")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aefiles",true);
    return p_cSql;
  }
  protected static String GetFieldsName_07742B08(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPOREC,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"COMSTA,";
    p_cSql = p_cSql+"PROVNA,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATACHIU,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"progae,";
    if (p_Ctx.IsSharedTemp("tmp_apenocod")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_apenocod",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0725F848(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPOREC,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATACHIU,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DENOM,";
    p_cSql = p_cSql+"COMSEDE,";
    p_cSql = p_cSql+"PROVSED,";
    p_cSql = p_cSql+"progae,";
    if (p_Ctx.IsSharedTemp("tmp_apenocod")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_apenocod",true);
    return p_cSql;
  }
  protected static String GetFieldsName_07C83F68(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"tipofile,";
    p_cSql = p_cSql+"rapporto,";
    p_cSql = p_cSql+"nprog,";
    p_cSql = p_cSql+"ragsoc,";
    p_cSql = p_cSql+"datini,";
    p_cSql = p_cSql+"datfin,";
    p_cSql = p_cSql+"tiporap,";
    p_cSql = p_cSql+"agerap,";
    if (p_Ctx.IsSharedTemp("tmp_stpfileage")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpfileage",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05ECFCE8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"idfile,";
    p_cSql = p_cSql+"datafile,";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"descfile,";
    p_cSql = p_cSql+"mese,";
    p_cSql = p_cSql+"anno,";
    p_cSql = p_cSql+"filename,";
    if (p_Ctx.IsSharedTemp("aefiles_glob")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aefiles_glob",true);
    return p_cSql;
  }
  protected static String GetFieldsName_07654C18(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"idfile,";
    p_cSql = p_cSql+"datafile,";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"descfile,";
    p_cSql = p_cSql+"mese,";
    p_cSql = p_cSql+"anno,";
    p_cSql = p_cSql+"filename,";
    if (p_Ctx.IsSharedTemp("aefiles_glob")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aefiles_glob",true);
    return p_cSql;
  }
  protected static String GetFieldsName_07682E68(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"idfile,";
    p_cSql = p_cSql+"datafile,";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"descfile,";
    p_cSql = p_cSql+"mese,";
    p_cSql = p_cSql+"anno,";
    p_cSql = p_cSql+"filename,";
    if (p_Ctx.IsSharedTemp("aefiles")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aefiles",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05E61E88(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPOREC,";
    p_cSql = p_cSql+"PROGRIF,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"COMSTA,";
    p_cSql = p_cSql+"PROVNA,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATACHIU,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"progae,";
    p_cSql = p_cSql+"CODINTER,";
    if (p_Ctx.IsSharedTemp("tmp_chiucod")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_chiucod",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06436BE0(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPOREC,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATACHIU,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DENOM,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"COMSEDE,";
    p_cSql = p_cSql+"PROVSED,";
    p_cSql = p_cSql+"PROGRIF,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"progae,";
    p_cSql = p_cSql+"CODINTER,";
    if (p_Ctx.IsSharedTemp("tmp_chiucod")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_chiucod",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05EDD3C8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"tipofile,";
    p_cSql = p_cSql+"rapporto,";
    p_cSql = p_cSql+"nprog,";
    p_cSql = p_cSql+"ragsoc,";
    p_cSql = p_cSql+"datini,";
    p_cSql = p_cSql+"datfin,";
    p_cSql = p_cSql+"tiporap,";
    p_cSql = p_cSql+"agerap,";
    p_cSql = p_cSql+"connes,";
    if (p_Ctx.IsSharedTemp("tmp_stpfileage")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpfileage",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06433790(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"idfile,";
    p_cSql = p_cSql+"datafile,";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"descfile,";
    p_cSql = p_cSql+"mese,";
    p_cSql = p_cSql+"anno,";
    p_cSql = p_cSql+"filename,";
    if (p_Ctx.IsSharedTemp("aefiles_glob")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aefiles_glob",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0768C018(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"idfile,";
    p_cSql = p_cSql+"datafile,";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"descfile,";
    p_cSql = p_cSql+"mese,";
    p_cSql = p_cSql+"anno,";
    p_cSql = p_cSql+"filename,";
    if (p_Ctx.IsSharedTemp("aefiles_glob")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aefiles_glob",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06302A28(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"idfile,";
    p_cSql = p_cSql+"datafile,";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"descfile,";
    p_cSql = p_cSql+"mese,";
    p_cSql = p_cSql+"anno,";
    p_cSql = p_cSql+"filename,";
    if (p_Ctx.IsSharedTemp("aefiles")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aefiles",true);
    return p_cSql;
  }
  protected static String GetFieldsName_07257BB0(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPOREC,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"COMSTA,";
    p_cSql = p_cSql+"PROVNA,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATACHIU,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"PROGRIF,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"progae,";
    p_cSql = p_cSql+"CODINTER,";
    if (p_Ctx.IsSharedTemp("tmp_chiunocod")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_chiunocod",true);
    return p_cSql;
  }
  protected static String GetFieldsName_076CC2C8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPOREC,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATACHIU,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DENOM,";
    p_cSql = p_cSql+"COMSEDE,";
    p_cSql = p_cSql+"PROVSED,";
    p_cSql = p_cSql+"PROGRIF,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"progae,";
    p_cSql = p_cSql+"CODINTER,";
    if (p_Ctx.IsSharedTemp("tmp_chiunocod")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_chiunocod",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06DDE2A8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"tipofile,";
    p_cSql = p_cSql+"rapporto,";
    p_cSql = p_cSql+"nprog,";
    p_cSql = p_cSql+"ragsoc,";
    p_cSql = p_cSql+"datini,";
    p_cSql = p_cSql+"datfin,";
    p_cSql = p_cSql+"tiporap,";
    p_cSql = p_cSql+"agerap,";
    if (p_Ctx.IsSharedTemp("tmp_stpfileage")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpfileage",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06BD2B38(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"idfile,";
    p_cSql = p_cSql+"datafile,";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"descfile,";
    p_cSql = p_cSql+"mese,";
    p_cSql = p_cSql+"anno,";
    p_cSql = p_cSql+"filename,";
    if (p_Ctx.IsSharedTemp("aefiles_glob")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aefiles_glob",true);
    return p_cSql;
  }
  protected static String GetFieldsName_074139F0(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"idfile,";
    p_cSql = p_cSql+"datafile,";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"descfile,";
    p_cSql = p_cSql+"mese,";
    p_cSql = p_cSql+"anno,";
    p_cSql = p_cSql+"filename,";
    if (p_Ctx.IsSharedTemp("aefiles_glob")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aefiles_glob",true);
    return p_cSql;
  }
  protected static String GetFieldsName_07472FC8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"idfile,";
    p_cSql = p_cSql+"datafile,";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"descfile,";
    p_cSql = p_cSql+"mese,";
    p_cSql = p_cSql+"anno,";
    p_cSql = p_cSql+"filename,";
    if (p_Ctx.IsSharedTemp("aefiles")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aefiles",true);
    return p_cSql;
  }
}
