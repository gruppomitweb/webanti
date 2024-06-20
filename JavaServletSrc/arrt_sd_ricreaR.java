// * --- Area Manuale = BO - Header
// * --- arrt_sd_ricrea
import java.util.*;
// * --- Fine Area Manuale
public class arrt_sd_ricreaR implements CallerWithObjs {
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
  public String w_nomefile;
  public String w_tipofile;
  public double w_files;
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
  public double _estero;
  public String _cfinvio;
  public String _cafinvio;
  public String _tipinvio;
  public String _impinvio;
  public String gPathApp;
  public String gIntemediario;
  public String gMsgImp;
  public double gFilesAge;
  public String gAzienda;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_sd_ricrea
  // These are the files to include in the ZIP file
  Vector filenames = new Vector();
  Vector fileonames = new Vector();
  
  // * --- Fine Area Manuale
  public arrt_sd_ricreaR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_sd_ricrea",m_Caller);
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_aetesta = p_ContextObject.GetPhName("aetesta");
    m_cServer_aetesta = p_ContextObject.GetServer("aetesta");
    m_cPhName_aerighe = p_ContextObject.GetPhName("aerighe");
    m_cServer_aerighe = p_ContextObject.GetServer("aerighe");
    m_cPhName_tmp_apecod = p_ContextObject.GetPhName("tmp_apecod");
    m_cServer_tmp_apecod = p_ContextObject.GetServer("tmp_apecod");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_aefiles = p_ContextObject.GetPhName("aefiles");
    m_cServer_aefiles = p_ContextObject.GetServer("aefiles");
    m_cPhName_tmp_apenocod = p_ContextObject.GetPhName("tmp_apenocod");
    m_cServer_tmp_apenocod = p_ContextObject.GetServer("tmp_apenocod");
    m_cPhName_tmp_chiunocod = p_ContextObject.GetPhName("tmp_chiunocod");
    m_cServer_tmp_chiunocod = p_ContextObject.GetServer("tmp_chiunocod");
    m_cPhName_tmp_chiucod = p_ContextObject.GetPhName("tmp_chiucod");
    m_cServer_tmp_chiucod = p_ContextObject.GetServer("tmp_chiucod");
    m_cPhName_tmp_stpfileage = p_ContextObject.GetPhName("tmp_stpfileage");
    m_cServer_tmp_stpfileage = p_ContextObject.GetServer("tmp_stpfileage");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("files",p_cVarName)) {
      return w_files;
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
    if (CPLib.eqr("_estero",p_cVarName)) {
      return _estero;
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
      return "arrt_sd_ricrea";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      return w_nomefile;
    }
    if (CPLib.eqr("tipofile",p_cVarName)) {
      return w_tipofile;
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
    if (CPLib.eqr("_estero",p_cVarName)) {
      _estero = value;
      return;
    }
    if (CPLib.eqr("gFilesAge",p_cVarName)) {
      gFilesAge = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("nomefile",p_cVarName)) {
      w_nomefile = value;
      return;
    }
    if (CPLib.eqr("tipofile",p_cVarName)) {
      w_tipofile = value;
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
      /* w_nomefile Char(15) */
      /* w_tipofile Char(1) */
      /* w_files Numeric(1, 0) */
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
      /* _estero Numeric(1, 0) */
      /* _cfinvio Char(16) */
      /* _cafinvio Char(5) */
      /* _tipinvio Char(1) */
      /* _impinvio Char(8) */
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
        /* _impinvio := DateToChar(intermbo->DATAINVIO) */
        _impinvio = CPLib.DateToChar(Cursor_intermbo.GetDate("DATAINVIO"));
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* _cfinvio := Space(16) */
      _cfinvio = CPLib.Space(16);
      /* _cafinvio := Space(5) */
      _cafinvio = CPLib.Space(5);
      /* _tipinvio := Space(1) */
      _tipinvio = CPLib.Space(1);
      /* _impinvio := Space(8) */
      _impinvio = CPLib.Space(8);
      /* Crea i file */
      /* If w_tipofile='A' */
      if (CPLib.eqr(w_tipofile,"A")) {
        /* Exec "Aperture" Page 2 */
        Page_2();
        /* ElseIf w_tipofile='C' */
      } else if (CPLib.eqr(w_tipofile,"C")) {
        /* Exec "Chiusure" Page 3 */
        Page_3();
      } // End If
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
    CPResultSet Cursor_aerighe=null;
    try {
      /* gMsgImp := 'Lettura rapporti in corso ...' // Messaggio Import */
      gMsgImp = "Lettura rapporti in corso ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Select from aerighe
      m_cServer = m_Ctx.GetServer("aerighe");
      m_cPhName = m_Ctx.GetPhName("aerighe");
      if (Cursor_aerighe!=null)
        Cursor_aerighe.Close();
      Cursor_aerighe = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"AFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_nomefile,"?",0,0,m_cServer, m_oParameters),m_cServer,w_nomefile)+" "+")"+(m_Ctx.IsSharedTemp("aerighe")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_aerighe.Eof())) {
        Cursor_aerighe.Next();
      }
      m_cConnectivityError = Cursor_aerighe.ErrorMessage();
      Cursor_aerighe.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_aerighe!=null)
          Cursor_aerighe.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_3() throws Exception {
    CPResultSet Cursor_aerighe=null;
    try {
      /* Invii Periodici */
      /* _czip := LRTrim(w_nomefile)+"_2.zip" */
      _czip = CPLib.LRTrim(w_nomefile)+"_2.zip";
      /* cNomeFileZip := LRTrim(gPathApp)+'/flussi/'+LRTrim(gAzienda)+"/"+_czip */
      cNomeFileZip = CPLib.LRTrim(gPathApp)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+_czip;
      // * --- Select from aerighe
      m_cServer = m_Ctx.GetServer("aerighe");
      m_cPhName = m_Ctx.GetPhName("aerighe");
      if (Cursor_aerighe!=null)
        Cursor_aerighe.Close();
      Cursor_aerighe = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_nomefile,"?",0,0,m_cServer, m_oParameters),m_cServer,w_nomefile)+" "+")"+(m_Ctx.IsSharedTemp("aerighe")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_aerighe.Eof())) {
        Cursor_aerighe.Next();
      }
      m_cConnectivityError = Cursor_aerighe.ErrorMessage();
      Cursor_aerighe.Close();
      // * --- End Select
    } finally {
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
      m_Caller.SetString("nomefile","C",15,0,w_nomefile);
      m_Caller.SetString("tipofile","C",1,0,w_tipofile);
      m_Caller.SetNumber("files","N",1,0,w_files);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_sd_ricreaR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_sd_ricreaR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_nomefile = m_Caller.GetString("nomefile","C",15,0);
    w_tipofile = m_Caller.GetString("tipofile","C",1,0);
    w_files = m_Caller.GetNumber("files","N",1,0);
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
    _estero = 0;
    _cfinvio = CPLib.Space(16);
    _cafinvio = CPLib.Space(5);
    _tipinvio = CPLib.Space(1);
    _impinvio = CPLib.Space(8);
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gFilesAge=m_Ctx.GetGlobalNumber("gFilesAge");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_agechar,
  public static final String i_InvokedRoutines = ",arfn_agechar,";
  public static String[] m_cRunParameterNames={};
}
