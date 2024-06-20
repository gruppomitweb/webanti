// * --- Area Manuale = BO - Header
// * --- arrt_sd_ricrea_ac
import java.util.*;
// * --- Fine Area Manuale
public class arrt_sd_ricrea_acR implements CallerWithObjs {
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
  public double _cicli;
  public double _contacilci;
  public double _bottom;
  public double _top;
  public double nProgImp;
  public double _fileita;
  public double _fileest;
  public double countmp;
  public double _estero;
  public String w_nomefile;
  public String gPathApp;
  public String gIntemediario;
  public String gMsgImp;
  public double gFilesAge;
  public String gAzienda;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_sd_ricrea_ac
  // These are the files to include in the ZIP file
  Vector filenames = new Vector();
  Vector fileonames = new Vector();
  
  // * --- Fine Area Manuale
  public arrt_sd_ricrea_acR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_sd_ricrea_ac",m_Caller);
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
      return "arrt_sd_ricrea_ac";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
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
    if (CPLib.eqr("nomefile",p_cVarName)) {
      return w_nomefile;
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
    if (CPLib.eqr("nomefile",p_cVarName)) {
      w_nomefile = value;
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
      /* _cicli Numeric(15, 0) */
      /* _contacilci Numeric(15, 0) */
      /* _bottom Numeric(15, 0) */
      /* _top Numeric(15, 0) */
      /* nProgImp Numeric(15, 0) */
      /* _fileita Numeric(3, 0) // Conteggio file soggetti italiani */
      /* _fileest Numeric(3, 0) // Conteggio file soggetti esteri */
      /* countmp Numeric(15, 0) // Contatore delle occorenze inserite nel temporaneo */
      /* _estero Numeric(1, 0) */
      /* w_nomefile Char(15) */
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
        /* _ragint := intermbo->RAGSOC */
        _ragint = Cursor_intermbo.GetString("RAGSOC");
        /* _citint := intermbo->DESCCIT */
        _citint = Cursor_intermbo.GetString("DESCCIT");
        /* _prvint := intermbo->PROVINCIA */
        _prvint = Cursor_intermbo.GetString("PROVINCIA");
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* Exec "Aperture" Page 2 */
      Page_2();
      /* Exec "Chiusure" Page 3 */
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
    CPResultSet Cursor_qbe_ricrea_1=null;
    CPResultSet Cursor_qbe_ricrea_ape=null;
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
      /* Prima gli italiani */
      /* gMsgImp := 'Lettura rapporti in corso ...' // Messaggio Import */
      gMsgImp = "Lettura rapporti in corso ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* _czip := DateTimeToChar(DateTime())+"_1.zip" */
      _czip = CPLib.DateTimeToChar(CPLib.DateTime())+"_1.zip";
      /* cNomeFileZip := LRTrim(gPathApp)+'/flussi/'+_czip */
      cNomeFileZip = CPLib.LRTrim(gPathApp)+"/flussi/"+_czip;
      // * --- Select from qbe_ricrea_1
      if (Cursor_qbe_ricrea_1!=null)
        Cursor_qbe_ricrea_1.Close();
      Cursor_qbe_ricrea_1 = new VQRHolder("qbe_ricrea_1",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_ricrea_1.Eof())) {
        /* w_nomefile := qbe_ricrea_1->AFILE */
        w_nomefile = Cursor_qbe_ricrea_1.GetString("AFILE");
        /* If Substr(w_nomefile,15,1) = '1' */
        if (CPLib.eqr(CPLib.Substr(w_nomefile,15,1),"1")) {
          // * --- Select from qbe_ricrea_ape
          if (Cursor_qbe_ricrea_ape!=null)
            Cursor_qbe_ricrea_ape.Close();
          Cursor_qbe_ricrea_ape = new VQRHolder("qbe_ricrea_ape",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_ricrea_ape.Eof())) {
            /* _sicodrec := _sicodrec + 1 // Conteggio rapporti con soggetti italiani */
            _sicodrec = CPLib.Round(_sicodrec+1,0);
            /* gMsgImp := 'Elaborazione soggetti relativi al file ' + LRTrim(w_nomefile) +'. Sto elaborando il rapporto N° ' + LRTrim(Str(_nocodrec+_sicodrec,10,0)) // Messaggio allineamento 1 */
            gMsgImp = "Elaborazione soggetti relativi al file "+CPLib.LRTrim(w_nomefile)+". Sto elaborando il rapporto N° "+CPLib.LRTrim(CPLib.Str(_nocodrec+_sicodrec,10,0));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* If not(Empty(qbe_ricrea_ape->COGNOME)) and not(Empty(qbe_ricrea_ape->NOME)) and Len(LRTrim(qbe_ricrea_ape->CODFISC)) = 16 */
            if ( ! (CPLib.Empty(Cursor_qbe_ricrea_ape.GetString("COGNOME"))) &&  ! (CPLib.Empty(Cursor_qbe_ricrea_ape.GetString("NOME"))) && CPLib.eqr(CPLib.Len(CPLib.LRTrim(Cursor_qbe_ricrea_ape.GetString("CODFISC"))),16)) {
              /* _cdata1 := Right(DateToChar(qbe_ricrea_ape->DATANASC),2)+Substr(DateToChar(qbe_ricrea_ape->DATANASC),5,2)+Left(DateToChar(qbe_ricrea_ape->DATANASC),4) */
              _cdata1 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_ricrea_ape.GetDate("DATANASC")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_ricrea_ape.GetDate("DATANASC")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_ricrea_ape.GetDate("DATANASC")),4);
              /* _cdata2 := Right(DateToChar(qbe_ricrea_ape->ADATA),2)+Substr(DateToChar(qbe_ricrea_ape->ADATA),5,2)+Left(DateToChar(qbe_ricrea_ape->ADATA),4) */
              _cdata2 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_ricrea_ape.GetDate("ADATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_ricrea_ape.GetDate("ADATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_ricrea_ape.GetDate("ADATA")),4);
              /* _cdata3 := '' */
              _cdata3 = "";
              /* If not(Empty(qbe_ricrea_ape->NASSTATO)) and Upper(LRTrim(qbe_ricrea_ape->NASSTATO)) <> 'ITALIA' */
              if ( ! (CPLib.Empty(Cursor_qbe_ricrea_ape.GetString("NASSTATO"))) && CPLib.ne(CPLib.Upper(CPLib.LRTrim(Cursor_qbe_ricrea_ape.GetString("NASSTATO"))),"ITALIA")) {
                /* _descit := qbe_ricrea_ape->NASSTATO */
                _descit = Cursor_qbe_ricrea_ape.GetString("NASSTATO");
              } else { // Else
                /* _descit := qbe_ricrea_ape->NASCOMUN */
                _descit = Cursor_qbe_ricrea_ape.GetString("NASCOMUN");
              } // End If
              // * --- Insert into tmp_apecod from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_apecod");
              m_cPhName = m_Ctx.GetPhName("tmp_apecod");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_apecod")+" (";
              m_cSql = m_cSql+GetFieldsName_076CF208(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_ape.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_ape.GetString("NOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_qbe_ricrea_ape.GetString("SESSO"),"F") || CPLib.eqr(Cursor_qbe_ricrea_ape.GetString("SESSO"),"2")?"F":"M"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_descit,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_ape.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_ape.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_ape.GetString("COINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_ape.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata3,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_ape.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_ape.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_ape.GetDouble("APROGN"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_ape.GetString("APROG"),"?",0,0,m_cServer)+", ";
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
              /* _cdata2 := Right(DateToChar(qbe_ricrea_ape->ADATA),2)+Substr(DateToChar(qbe_ricrea_ape->ADATA),5,2)+Left(DateToChar(qbe_ricrea_ape->ADATA),4) */
              _cdata2 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_ricrea_ape.GetDate("ADATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_ricrea_ape.GetDate("ADATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_ricrea_ape.GetDate("ADATA")),4);
              /* _cdata3 := '' */
              _cdata3 = "";
              // * --- Insert into tmp_apecod from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_apecod");
              m_cPhName = m_Ctx.GetPhName("tmp_apecod");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_apecod")+" (";
              m_cSql = m_cSql+GetFieldsName_06E8BD38(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_ape.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_ape.GetString("COINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_ape.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata3,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_ape.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_qbe_ricrea_ape.GetString("RAGSOC"),60),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_ape.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_ape.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_ape.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_ape.GetDouble("APROGN"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_ape.GetString("APROG"),"?",0,0,m_cServer)+", ";
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
            Cursor_qbe_ricrea_ape.Next();
          }
          m_cConnectivityError = Cursor_qbe_ricrea_ape.ErrorMessage();
          Cursor_qbe_ricrea_ape.Close();
          // * --- End Select
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
                /* cNomeFile := LRTrim(gPathApp)+'/flussi/'+LRTrim(w_nomefile) */
                cNomeFile = CPLib.LRTrim(gPathApp)+"/flussi/"+CPLib.LRTrim(w_nomefile);
                /* cOnlyNomeFile := w_nomefile */
                cOnlyNomeFile = w_nomefile;
                /* _fileita := _fileita + 1 */
                _fileita = CPLib.Round(_fileita+1,0);
                // These are the files to include in the ZIP file
                filenames.add(cNomeFile);
                fileonames.add(cOnlyNomeFile);
                /* fhand := FileLibrary.OpenWrite('./flussi/'+LRTrim(w_nomefile)) */
                fhand = FileLibrary.OpenWrite("./flussi/"+CPLib.LRTrim(w_nomefile));
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
                /* _file := _file + w_nomefile */
                _file = _file+w_nomefile;
                /* _file := _file + Space(1537) */
                _file = _file+CPLib.Space(1537);
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
              /* _file := _file + Right("0000000000000000000000000000000000000000" + LRTrim(Str(_r)),25) */
              _file = _file+CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(CPLib.Str(_r)),25);
              /* _file := _file + Left(LRTrim(tmp_apecod->CODFISC) + Space(16),16) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_apecod.GetString("CODFISC"))+CPLib.Space(16),16);
              /* _file := _file + Left(LRTrim(tmp_apecod->COGNOME) + Space(26),26) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_apecod.GetString("COGNOME"))+CPLib.Space(26),26);
              /* _file := _file + Left(LRTrim(tmp_apecod->NOME) + Space(25),25) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_apecod.GetString("NOME"))+CPLib.Space(25),25);
              /* _file := _file + Left(LRTrim(tmp_apecod->SESSO)+Space(1),1) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_apecod.GetString("SESSO"))+CPLib.Space(1),1);
              /* _file := _file + Left(LRTrim(tmp_apecod->DATANASC) + Space(8),8) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_apecod.GetString("DATANASC"))+CPLib.Space(8),8);
              /* _file := _file + Left(LRTrim(tmp_apecod->COMSTA) + Space(40),40) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_apecod.GetString("COMSTA"))+CPLib.Space(40),40);
              /* _file := _file + Left(LRTrim(tmp_apecod->PROVNA) + Space(2),2) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_apecod.GetString("PROVNA"))+CPLib.Space(2),2);
              /* _file := _file + Left(LRTrim(tmp_apecod->DENOM) + Space(60),60) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_apecod.GetString("DENOM"))+CPLib.Space(60),60);
              /* _file := _file + Left(LRTrim(tmp_apecod->COMSEDE) + Space(40),40) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_apecod.GetString("COMSEDE"))+CPLib.Space(40),40);
              /* _file := _file + Left(LRTrim(tmp_apecod->PROVSED) + Space(2),2) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_apecod.GetString("PROVSED"))+CPLib.Space(2),2);
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
              /* _file := _file + w_nomefile */
              _file = _file+w_nomefile;
              /* _file := _file + Space(1537) */
              _file = _file+CPLib.Space(1537);
              /* _file := _file + 'A' */
              _file = _file+"A";
              /* FileLibrary.WriteLine(fhand,_file) */
              FileLibrary.WriteLine(fhand,_file);
              /* FileLibrary.Close(fhand) */
              FileLibrary.Close(fhand);
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
        Cursor_qbe_ricrea_1.Next();
      }
      m_cConnectivityError = Cursor_qbe_ricrea_1.ErrorMessage();
      Cursor_qbe_ricrea_1.Close();
      // * --- End Select
      /* If _fileita > 0 */
      if (CPLib.gt(_fileita,0)) {
        /* Exec "Crea file zip" Page 4 */
        Page_4();
      } // End If
      /* countmp := 0 // Contatore delle occorenze inserite nel temporaneo */
      countmp = CPLib.Round(0,0);
      /* Stranieri */
      /* _czip := DateTimeToChar(DateTime())+"_4.zip" */
      _czip = CPLib.DateTimeToChar(CPLib.DateTime())+"_4.zip";
      /* cNomeFileZip := LRTrim(gPathApp)+'/flussi/'+_czip */
      cNomeFileZip = CPLib.LRTrim(gPathApp)+"/flussi/"+_czip;
      // * --- Select from qbe_ricrea_1
      if (Cursor_qbe_ricrea_1!=null)
        Cursor_qbe_ricrea_1.Close();
      Cursor_qbe_ricrea_1 = new VQRHolder("qbe_ricrea_1",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_ricrea_1.Eof())) {
        /* w_nomefile := qbe_ricrea_1->AFILE */
        w_nomefile = Cursor_qbe_ricrea_1.GetString("AFILE");
        /* If Substr(w_nomefile,15,1) = '4' */
        if (CPLib.eqr(CPLib.Substr(w_nomefile,15,1),"4")) {
          // * --- Select from qbe_ricrea_ape
          if (Cursor_qbe_ricrea_ape!=null)
            Cursor_qbe_ricrea_ape.Close();
          Cursor_qbe_ricrea_ape = new VQRHolder("qbe_ricrea_ape",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_ricrea_ape.Eof())) {
            /* gMsgImp := 'Elaborazione soggetti relativi al file ' + LRTrim(w_nomefile) +'. Sto elaborando il rapporto N° ' + LRTrim(Str(_nocodrec+_sicodrec,10,0)) // Messaggio allineamento 1 */
            gMsgImp = "Elaborazione soggetti relativi al file "+CPLib.LRTrim(w_nomefile)+". Sto elaborando il rapporto N° "+CPLib.LRTrim(CPLib.Str(_nocodrec+_sicodrec,10,0));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* _descit := '' */
            _descit = "";
            /* If not(Empty(qbe_ricrea_ape->COGNOME)) and not(Empty(qbe_ricrea_ape->NOME)) */
            if ( ! (CPLib.Empty(Cursor_qbe_ricrea_ape.GetString("COGNOME"))) &&  ! (CPLib.Empty(Cursor_qbe_ricrea_ape.GetString("NOME")))) {
              /* _cdata1 := Right(DateToChar(qbe_ricrea_ape->DATANASC),2)+Substr(DateToChar(qbe_ricrea_ape->DATANASC),5,2)+Left(DateToChar(qbe_ricrea_ape->DATANASC),4) */
              _cdata1 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_ricrea_ape.GetDate("DATANASC")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_ricrea_ape.GetDate("DATANASC")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_ricrea_ape.GetDate("DATANASC")),4);
              /* _cdata2 := Right(DateToChar(qbe_ricrea_ape->ADATA),2)+Substr(DateToChar(qbe_ricrea_ape->ADATA),5,2)+Left(DateToChar(qbe_ricrea_ape->ADATA),4) */
              _cdata2 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_ricrea_ape.GetDate("ADATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_ricrea_ape.GetDate("ADATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_ricrea_ape.GetDate("ADATA")),4);
              /* _cdata3 := '' */
              _cdata3 = "";
              // * --- Insert into tmp_apenocod from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_apenocod");
              m_cPhName = m_Ctx.GetPhName("tmp_apenocod");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_apenocod")+" (";
              m_cSql = m_cSql+GetFieldsName_062DEDF0(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL("4","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_ape.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_ape.GetString("NOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_qbe_ricrea_ape.GetString("SESSO"),"F") || CPLib.eqr(Cursor_qbe_ricrea_ape.GetString("SESSO"),"2")?"F":"M"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_ape.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("EE","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_ape.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_ape.GetString("COINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_ape.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata3,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_ape.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_ape.GetDouble("APROGN"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_ape.GetString("APROG"),"?",0,0,m_cServer)+", ";
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
              /* If not(Empty(qbe_ricrea_ape->PAESE)) */
              if ( ! (CPLib.Empty(Cursor_qbe_ricrea_ape.GetString("PAESE")))) {
                // * --- Read from tbstati
                m_cServer = m_Ctx.GetServer("tbstati");
                m_cPhName = m_Ctx.GetPhName("tbstati");
                m_cSql = "";
                m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_ricrea_ape.GetString("PAESE"),"C",3,0,m_cServer),m_cServer,Cursor_qbe_ricrea_ape.GetString("PAESE"));
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
                    Error l_oErrorFault = new Error("Read on tbstati into routine arrt_sd_ricrea_ac returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _descit = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* _descit := iif(not(Empty(_descit)),_descit,qbe_ricrea_ape->DESCCIT) */
                _descit = ( ! (CPLib.Empty(_descit))?_descit:Cursor_qbe_ricrea_ape.GetString("DESCCIT"));
              } else { // Else
                /* _descit := qbe_ricrea_ape->DESCCIT */
                _descit = Cursor_qbe_ricrea_ape.GetString("DESCCIT");
              } // End If
              /* _cdata2 := Right(DateToChar(qbe_ricrea_ape->ADATA),2)+Substr(DateToChar(qbe_ricrea_ape->ADATA),5,2)+Left(DateToChar(qbe_ricrea_ape->ADATA),4) */
              _cdata2 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_ricrea_ape.GetDate("ADATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_ricrea_ape.GetDate("ADATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_ricrea_ape.GetDate("ADATA")),4);
              /* _cdata3 := '' */
              _cdata3 = "";
              // * --- Insert into tmp_apenocod from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_apenocod");
              m_cPhName = m_Ctx.GetPhName("tmp_apenocod");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_apenocod")+" (";
              m_cSql = m_cSql+GetFieldsName_05FA71D0(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL("4","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_ape.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_ape.GetString("COINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_ape.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata3,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_ape.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_qbe_ricrea_ape.GetString("RAGSOC"),60),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_descit,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_qbe_ricrea_ape.GetString("PROVINCIA"))?"EE":Cursor_qbe_ricrea_ape.GetString("PROVINCIA")),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_ape.GetDouble("APROGN"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_ape.GetString("APROG"),"?",0,0,m_cServer)+", ";
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
            Cursor_qbe_ricrea_ape.Next();
          }
          m_cConnectivityError = Cursor_qbe_ricrea_ape.ErrorMessage();
          Cursor_qbe_ricrea_ape.Close();
          // * --- End Select
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
                /* _nomefile := w_nomefile */
                _nomefile = w_nomefile;
                /* cNomeFile := LRTrim(gPathApp)+'/flussi/'+LRTrim(w_nomefile) */
                cNomeFile = CPLib.LRTrim(gPathApp)+"/flussi/"+CPLib.LRTrim(w_nomefile);
                /* cOnlyNomeFile := _nomefile */
                cOnlyNomeFile = _nomefile;
                // These are the files to include in the ZIP file
                filenames.add(cNomeFile);
                fileonames.add(cOnlyNomeFile);
                /* fhand := FileLibrary.OpenWrite('./flussi/'+LRTrim(_nomefile)) */
                fhand = FileLibrary.OpenWrite("./flussi/"+CPLib.LRTrim(_nomefile));
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
                /* _file := _file + _nomefile */
                _file = _file+_nomefile;
                /* _file := _file + Space(1537) */
                _file = _file+CPLib.Space(1537);
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
              /* _r := _r + 1 */
              _r = CPLib.Round(_r+1,0);
              /* _file := _file + Right("0000000000000000000000000000000000000000" + LRTrim(Str(_r)),25) */
              _file = _file+CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(CPLib.Str(_r)),25);
              /* _file := _file + Left(LRTrim(tmp_apenocod->COGNOME) + Space(26),26) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_apenocod.GetString("COGNOME"))+CPLib.Space(26),26);
              /* _file := _file + Left(LRTrim(tmp_apenocod->NOME) + Space(25),25) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_apenocod.GetString("NOME"))+CPLib.Space(25),25);
              /* _file := _file + Left(LRTrim(tmp_apenocod->SESSO)+Space(1),1) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_apenocod.GetString("SESSO"))+CPLib.Space(1),1);
              /* _file := _file + Left(LRTrim(tmp_apenocod->DATANASC) + Space(8),8) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_apenocod.GetString("DATANASC"))+CPLib.Space(8),8);
              /* _file := _file + Left(LRTrim(tmp_apenocod->COMSTA) + Space(40),40) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_apenocod.GetString("COMSTA"))+CPLib.Space(40),40);
              /* _file := _file + Left(LRTrim(tmp_apenocod->PROVNA) + Space(2),2) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_apenocod.GetString("PROVNA"))+CPLib.Space(2),2);
              /* _file := _file + Left(LRTrim(tmp_apenocod->DENOM) + Space(60),60) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_apenocod.GetString("DENOM"))+CPLib.Space(60),60);
              /* _file := _file + Left(LRTrim(tmp_apenocod->COMSEDE) + Space(40),40) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_apenocod.GetString("COMSEDE"))+CPLib.Space(40),40);
              /* _file := _file + Left(LRTrim(tmp_apenocod->PROVSED) + Space(2),2) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_apenocod.GetString("PROVSED"))+CPLib.Space(2),2);
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
              /* _file := _file + _nomefile */
              _file = _file+_nomefile;
              /* _file := _file + Space(1537) */
              _file = _file+CPLib.Space(1537);
              /* _file := _file + 'A' */
              _file = _file+"A";
              /* FileLibrary.WriteLine(fhand,_file) */
              FileLibrary.WriteLine(fhand,_file);
              /* FileLibrary.Close(fhand) */
              FileLibrary.Close(fhand);
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
        Cursor_qbe_ricrea_1.Next();
      }
      m_cConnectivityError = Cursor_qbe_ricrea_1.ErrorMessage();
      Cursor_qbe_ricrea_1.Close();
      // * --- End Select
      /* If _fileest > 0 */
      if (CPLib.gt(_fileest,0)) {
        /* Exec "Crea file zip" Page 4 */
        Page_4();
      } // End If
    } finally {
      try {
        if (Cursor_qbe_ricrea_1!=null)
          Cursor_qbe_ricrea_1.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_ricrea_ape!=null)
          Cursor_qbe_ricrea_ape.Close();
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
    CPResultSet Cursor_qbe_ricrea_2=null;
    CPResultSet Cursor_qbe_ricrea_chi=null;
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
      /* gMsgImp := 'Lettura rapporti in corso per generazione chiusure ...' // Messaggio Import */
      gMsgImp = "Lettura rapporti in corso per generazione chiusure ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* _czip := DateTimeToChar(DateTime())+"_2.zip" */
      _czip = CPLib.DateTimeToChar(CPLib.DateTime())+"_2.zip";
      /* cNomeFileZip := LRTrim(gPathApp)+'/flussi/'+_czip */
      cNomeFileZip = CPLib.LRTrim(gPathApp)+"/flussi/"+_czip;
      // * --- Select from qbe_ricrea_2
      if (Cursor_qbe_ricrea_2!=null)
        Cursor_qbe_ricrea_2.Close();
      Cursor_qbe_ricrea_2 = new VQRHolder("qbe_ricrea_2",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_ricrea_2.Eof())) {
        /* w_nomefile := qbe_ricrea_2->CFILE */
        w_nomefile = Cursor_qbe_ricrea_2.GetString("CFILE");
        /* If Substr(w_nomefile,15,1) = '2' */
        if (CPLib.eqr(CPLib.Substr(w_nomefile,15,1),"2")) {
          // * --- Select from qbe_ricrea_chi
          if (Cursor_qbe_ricrea_chi!=null)
            Cursor_qbe_ricrea_chi.Close();
          Cursor_qbe_ricrea_chi = new VQRHolder("qbe_ricrea_chi",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_ricrea_chi.Eof())) {
            /* gMsgImp := 'Elaborazione soggetti relativi al file ' + LRTrim(w_nomefile) +'. Sto elaborando il rapporto N° ' + LRTrim(Str(_nocodrec+_sicodrec,10,0)) // Messaggio allineamento 1 */
            gMsgImp = "Elaborazione soggetti relativi al file "+CPLib.LRTrim(w_nomefile)+". Sto elaborando il rapporto N° "+CPLib.LRTrim(CPLib.Str(_nocodrec+_sicodrec,10,0));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* If not(Empty(qbe_ricrea_chi->COGNOME)) and not(Empty(qbe_ricrea_chi->NOME)) and Len(LRTrim(qbe_ricrea_chi->CODFISC)) = 16 */
            if ( ! (CPLib.Empty(Cursor_qbe_ricrea_chi.GetString("COGNOME"))) &&  ! (CPLib.Empty(Cursor_qbe_ricrea_chi.GetString("NOME"))) && CPLib.eqr(CPLib.Len(CPLib.LRTrim(Cursor_qbe_ricrea_chi.GetString("CODFISC"))),16)) {
              /* _cdata1 := Right(DateToChar(qbe_ricrea_chi->DATANASC),2)+Substr(DateToChar(qbe_ricrea_chi->DATANASC),5,2)+Left(DateToChar(qbe_ricrea_chi->DATANASC),4) */
              _cdata1 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_ricrea_chi.GetDate("DATANASC")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_ricrea_chi.GetDate("DATANASC")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_ricrea_chi.GetDate("DATANASC")),4);
              /* _cdata2 := Right(DateToChar(qbe_ricrea_chi->ADATA),2)+Substr(DateToChar(qbe_ricrea_chi->ADATA),5,2)+Left(DateToChar(qbe_ricrea_chi->ADATA),4) */
              _cdata2 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_ricrea_chi.GetDate("ADATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_ricrea_chi.GetDate("ADATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_ricrea_chi.GetDate("ADATA")),4);
              /* _cdata3 := Right(DateToChar(qbe_ricrea_chi->CDATA),2)+Substr(DateToChar(qbe_ricrea_chi->CDATA),5,2)+Left(DateToChar(qbe_ricrea_chi->CDATA),4) */
              _cdata3 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_ricrea_chi.GetDate("CDATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_ricrea_chi.GetDate("CDATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_ricrea_chi.GetDate("CDATA")),4);
              /* If not(Empty(qbe_ricrea_chi->NASSTATO)) and Upper(LRTrim(qbe_ricrea_chi->NASSTATO)) <> 'ITALIA' */
              if ( ! (CPLib.Empty(Cursor_qbe_ricrea_chi.GetString("NASSTATO"))) && CPLib.ne(CPLib.Upper(CPLib.LRTrim(Cursor_qbe_ricrea_chi.GetString("NASSTATO"))),"ITALIA")) {
                /* _descit := qbe_ricrea_chi->NASSTATO */
                _descit = Cursor_qbe_ricrea_chi.GetString("NASSTATO");
              } else { // Else
                /* _descit := qbe_ricrea_chi->NASCOMUN */
                _descit = Cursor_qbe_ricrea_chi.GetString("NASCOMUN");
              } // End If
              // * --- Insert into tmp_chiucod from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_chiucod");
              m_cPhName = m_Ctx.GetPhName("tmp_chiucod");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_chiucod")+" (";
              m_cSql = m_cSql+GetFieldsName_078E4378(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetString("APROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetString("AFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetString("NOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_qbe_ricrea_chi.GetString("SESSO"),"F") || CPLib.eqr(Cursor_qbe_ricrea_chi.GetString("SESSO"),"2")?"F":"M"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_descit,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetString("COINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata3,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetDouble("CPROGN"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetString("CPROG"),"?",0,0,m_cServer)+", ";
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
              /* _cdata2 := Right(DateToChar(qbe_ricrea_chi->ADATA),2)+Substr(DateToChar(qbe_ricrea_chi->ADATA),5,2)+Left(DateToChar(qbe_ricrea_chi->ADATA),4) */
              _cdata2 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_ricrea_chi.GetDate("ADATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_ricrea_chi.GetDate("ADATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_ricrea_chi.GetDate("ADATA")),4);
              /* _cdata3 := Right(DateToChar(qbe_ricrea_chi->CDATA),2)+Substr(DateToChar(qbe_ricrea_chi->CDATA),5,2)+Left(DateToChar(qbe_ricrea_chi->CDATA),4) */
              _cdata3 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_ricrea_chi.GetDate("CDATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_ricrea_chi.GetDate("CDATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_ricrea_chi.GetDate("CDATA")),4);
              // * --- Insert into tmp_chiucod from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_chiucod");
              m_cPhName = m_Ctx.GetPhName("tmp_chiucod");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_chiucod")+" (";
              m_cSql = m_cSql+GetFieldsName_077292F8(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetString("COINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata3,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_qbe_ricrea_chi.GetString("RAGSOC"),60),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetString("APROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetString("AFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetDouble("CPROGN"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetString("CPROG"),"?",0,0,m_cServer)+", ";
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
            Cursor_qbe_ricrea_chi.Next();
          }
          m_cConnectivityError = Cursor_qbe_ricrea_chi.ErrorMessage();
          Cursor_qbe_ricrea_chi.Close();
          // * --- End Select
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
                /* _nomefile := w_nomefile */
                _nomefile = w_nomefile;
                /* cNomeFile := LRTrim(gPathApp)+'/flussi/'+LRTrim(_nomefile) */
                cNomeFile = CPLib.LRTrim(gPathApp)+"/flussi/"+CPLib.LRTrim(_nomefile);
                /* cOnlyNomeFile := _nomefile */
                cOnlyNomeFile = _nomefile;
                /* _fileita := _fileita + 1 */
                _fileita = CPLib.Round(_fileita+1,0);
                // These are the files to include in the ZIP file
                filenames.add(cNomeFile);
                fileonames.add(cOnlyNomeFile);
                /* fhand := FileLibrary.OpenWrite('./flussi/'+LRTrim(_nomefile)) */
                fhand = FileLibrary.OpenWrite("./flussi/"+CPLib.LRTrim(_nomefile));
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
                /* _file := _file + _nomefile */
                _file = _file+_nomefile;
                /* _file := _file + Space(1537) */
                _file = _file+CPLib.Space(1537);
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
              /* _file := _file + Right("0000000000000000000000000000000000000000" + LRTrim(Str(_r)),25) */
              _file = _file+CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(CPLib.Str(_r)),25);
              /* _file := _file + Left(LRTrim(_cfint)+Space(16),16) */
              _file = _file+CPLib.Left(CPLib.LRTrim(_cfint)+CPLib.Space(16),16);
              /* _file := _file + Right("00000000000000000000000000" + LRTrim(tmp_chiucod->IDFILE),15) */
              _file = _file+CPLib.Right("00000000000000000000000000"+CPLib.LRTrim(Cursor_tmp_chiucod.GetString("IDFILE")),15);
              /* _file := _file + Right("0000000000000000000000000000000000000000" + LRTrim(tmp_chiucod->PROGRIF),25) */
              _file = _file+CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(Cursor_tmp_chiucod.GetString("PROGRIF")),25);
              /* _file := _file + Left(LRTrim(tmp_chiucod->CODFISC) + Space(16),16) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("CODFISC"))+CPLib.Space(16),16);
              /* _file := _file + Left(LRTrim(tmp_chiucod->COGNOME) + Space(26),26) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("COGNOME"))+CPLib.Space(26),26);
              /* _file := _file + Left(LRTrim(tmp_chiucod->NOME) + Space(25),25) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("NOME"))+CPLib.Space(25),25);
              /* _file := _file + Left(LRTrim(tmp_chiucod->SESSO)+Space(1),1) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("SESSO"))+CPLib.Space(1),1);
              /* _file := _file + Left(LRTrim(tmp_chiucod->DATANASC) + Space(8),8) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("DATANASC"))+CPLib.Space(8),8);
              /* _file := _file + Left(LRTrim(tmp_chiucod->COMSTA) + Space(40),40) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("COMSTA"))+CPLib.Space(40),40);
              /* _file := _file + Left(LRTrim(tmp_chiucod->PROVNA) + Space(2),2) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("PROVNA"))+CPLib.Space(2),2);
              /* _file := _file + Left(LRTrim(tmp_chiucod->DENOM) + Space(60),60) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("DENOM"))+CPLib.Space(60),60);
              /* _file := _file + Left(LRTrim(tmp_chiucod->COMSEDE) + Space(40),40) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("COMSEDE"))+CPLib.Space(40),40);
              /* _file := _file + Left(LRTrim(tmp_chiucod->PROVSED) + Space(2),2) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("PROVSED"))+CPLib.Space(2),2);
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
              /* _file := _file + _nomefile */
              _file = _file+_nomefile;
              /* _file := _file + Space(1537) */
              _file = _file+CPLib.Space(1537);
              /* _file := _file + 'A' */
              _file = _file+"A";
              /* FileLibrary.WriteLine(fhand,_file) */
              FileLibrary.WriteLine(fhand,_file);
              /* FileLibrary.Close(fhand) */
              FileLibrary.Close(fhand);
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
        Cursor_qbe_ricrea_2.Next();
      }
      m_cConnectivityError = Cursor_qbe_ricrea_2.ErrorMessage();
      Cursor_qbe_ricrea_2.Close();
      // * --- End Select
      /* If _fileita > 0 */
      if (CPLib.gt(_fileita,0)) {
        /* Exec "Crea file zip" Page 4 */
        Page_4();
      } // End If
      /* countmp := 0 // Contatore delle occorenze inserite nel temporaneo */
      countmp = CPLib.Round(0,0);
      /* Stranieri */
      /* _czip := DateTimeToChar(DateTime())+"_5.zip" */
      _czip = CPLib.DateTimeToChar(CPLib.DateTime())+"_5.zip";
      /* cNomeFileZip := LRTrim(gPathApp)+'/flussi/'+_czip */
      cNomeFileZip = CPLib.LRTrim(gPathApp)+"/flussi/"+_czip;
      // * --- Select from qbe_ricrea_2
      if (Cursor_qbe_ricrea_2!=null)
        Cursor_qbe_ricrea_2.Close();
      Cursor_qbe_ricrea_2 = new VQRHolder("qbe_ricrea_2",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_ricrea_2.Eof())) {
        /* w_nomefile := qbe_ricrea_2->CFILE */
        w_nomefile = Cursor_qbe_ricrea_2.GetString("CFILE");
        /* If Substr(w_nomefile,15,1) = '5' */
        if (CPLib.eqr(CPLib.Substr(w_nomefile,15,1),"5")) {
          // * --- Select from qbe_ricrea_chi
          if (Cursor_qbe_ricrea_chi!=null)
            Cursor_qbe_ricrea_chi.Close();
          Cursor_qbe_ricrea_chi = new VQRHolder("qbe_ricrea_chi",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_ricrea_chi.Eof())) {
            /* gMsgImp := 'Elaborazione soggetti relativi al file ' + LRTrim(w_nomefile) +'. Sto elaborando il rapporto N° ' + LRTrim(Str(_nocodrec+_sicodrec,10,0)) // Messaggio allineamento 1 */
            gMsgImp = "Elaborazione soggetti relativi al file "+CPLib.LRTrim(w_nomefile)+". Sto elaborando il rapporto N° "+CPLib.LRTrim(CPLib.Str(_nocodrec+_sicodrec,10,0));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* _descit := '' */
            _descit = "";
            /* If not(Empty(qbe_ricrea_chi->COGNOME)) and not(Empty(qbe_ricrea_chi->NOME)) */
            if ( ! (CPLib.Empty(Cursor_qbe_ricrea_chi.GetString("COGNOME"))) &&  ! (CPLib.Empty(Cursor_qbe_ricrea_chi.GetString("NOME")))) {
              /* _cdata1 := Right(DateToChar(qbe_ricrea_chi->DATANASC),2)+Substr(DateToChar(qbe_ricrea_chi->DATANASC),5,2)+Left(DateToChar(qbe_ricrea_chi->DATANASC),4) */
              _cdata1 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_ricrea_chi.GetDate("DATANASC")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_ricrea_chi.GetDate("DATANASC")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_ricrea_chi.GetDate("DATANASC")),4);
              /* _cdata2 := Right(DateToChar(qbe_ricrea_chi->ADATA),2)+Substr(DateToChar(qbe_ricrea_chi->ADATA),5,2)+Left(DateToChar(qbe_ricrea_chi->ADATA),4) */
              _cdata2 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_ricrea_chi.GetDate("ADATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_ricrea_chi.GetDate("ADATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_ricrea_chi.GetDate("ADATA")),4);
              /* _cdata3 := Right(DateToChar(qbe_ricrea_chi->CDATA),2)+Substr(DateToChar(qbe_ricrea_chi->CDATA),5,2)+Left(DateToChar(qbe_ricrea_chi->CDATA),4) */
              _cdata3 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_ricrea_chi.GetDate("CDATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_ricrea_chi.GetDate("CDATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_ricrea_chi.GetDate("CDATA")),4);
              // * --- Insert into tmp_chiunocod from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_chiunocod");
              m_cPhName = m_Ctx.GetPhName("tmp_chiunocod");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_chiunocod")+" (";
              m_cSql = m_cSql+GetFieldsName_0724C9A8(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL("5","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetString("NOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_qbe_ricrea_chi.GetString("SESSO"),"F") || CPLib.eqr(Cursor_qbe_ricrea_chi.GetString("SESSO"),"2")?"F":"M"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("EE","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetString("COINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata3,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetString("APROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetString("AFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetDouble("CPROGN"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetString("CPROG"),"?",0,0,m_cServer)+", ";
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
              /* If not(Empty(qbe_ricrea_chi->PAESE)) */
              if ( ! (CPLib.Empty(Cursor_qbe_ricrea_chi.GetString("PAESE")))) {
                // * --- Read from tbstati
                m_cServer = m_Ctx.GetServer("tbstati");
                m_cPhName = m_Ctx.GetPhName("tbstati");
                m_cSql = "";
                m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetString("PAESE"),"C",3,0,m_cServer),m_cServer,Cursor_qbe_ricrea_chi.GetString("PAESE"));
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
                    Error l_oErrorFault = new Error("Read on tbstati into routine arrt_sd_ricrea_ac returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _descit = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* _descit := iif(not(Empty(_descit)),_descit,qbe_ricrea_chi->DESCCIT) */
                _descit = ( ! (CPLib.Empty(_descit))?_descit:Cursor_qbe_ricrea_chi.GetString("DESCCIT"));
              } else { // Else
                /* _descit := qbe_ricrea_chi->DESCCIT */
                _descit = Cursor_qbe_ricrea_chi.GetString("DESCCIT");
              } // End If
              /* _cdata2 := Right(DateToChar(qbe_ricrea_chi->ADATA),2)+Substr(DateToChar(qbe_ricrea_chi->ADATA),5,2)+Left(DateToChar(qbe_ricrea_chi->ADATA),4) */
              _cdata2 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_ricrea_chi.GetDate("ADATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_ricrea_chi.GetDate("ADATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_ricrea_chi.GetDate("ADATA")),4);
              /* _cdata3 := Right(DateToChar(qbe_ricrea_chi->CDATA),2)+Substr(DateToChar(qbe_ricrea_chi->CDATA),5,2)+Left(DateToChar(qbe_ricrea_chi->CDATA),4) */
              _cdata3 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_ricrea_chi.GetDate("CDATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_ricrea_chi.GetDate("CDATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_ricrea_chi.GetDate("CDATA")),4);
              // * --- Insert into tmp_chiunocod from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_chiunocod");
              m_cPhName = m_Ctx.GetPhName("tmp_chiunocod");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_chiunocod")+" (";
              m_cSql = m_cSql+GetFieldsName_06D4F608(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL("5","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetString("COINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata3,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_qbe_ricrea_chi.GetString("RAGSOC"),60),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_descit,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_qbe_ricrea_chi.GetString("PROVINCIA"))?"EE":Cursor_qbe_ricrea_chi.GetString("PROVINCIA")),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetString("APROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetString("AFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetDouble("CPROGN"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ricrea_chi.GetString("CPROG"),"?",0,0,m_cServer)+", ";
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
            Cursor_qbe_ricrea_chi.Next();
          }
          m_cConnectivityError = Cursor_qbe_ricrea_chi.ErrorMessage();
          Cursor_qbe_ricrea_chi.Close();
          // * --- End Select
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
                /* _nomefile := w_nomefile */
                _nomefile = w_nomefile;
                /* cNomeFile := LRTrim(gPathApp)+'/flussi/'+LRTrim(_nomefile) */
                cNomeFile = CPLib.LRTrim(gPathApp)+"/flussi/"+CPLib.LRTrim(_nomefile);
                /* cOnlyNomeFile := _nomefile */
                cOnlyNomeFile = _nomefile;
                // These are the files to include in the ZIP file
                filenames.add(cNomeFile);
                fileonames.add(cOnlyNomeFile);
                /* fhand := FileLibrary.OpenWrite('./flussi/'+LRTrim(_nomefile)) */
                fhand = FileLibrary.OpenWrite("./flussi/"+CPLib.LRTrim(_nomefile));
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
                /* _file := _file + _nomefile */
                _file = _file+_nomefile;
                /* _file := _file + Space(1537) */
                _file = _file+CPLib.Space(1537);
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
              /* _r := _r + 1 */
              _r = CPLib.Round(_r+1,0);
              /* _file := _file + Right("0000000000000000000000000000000000000000" + LRTrim(Str(_r)),25) */
              _file = _file+CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(CPLib.Str(_r)),25);
              /* _file := _file + Left(LRTrim(_cfint)+Space(16),16) */
              _file = _file+CPLib.Left(CPLib.LRTrim(_cfint)+CPLib.Space(16),16);
              /* _file := _file + Right("00000000000000000000000000" + LRTrim(tmp_chiunocod->IDFILE),15) */
              _file = _file+CPLib.Right("00000000000000000000000000"+CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("IDFILE")),15);
              /* _file := _file + Right("0000000000000000000000000000000000000000" + LRTrim(tmp_chiunocod->PROGRIF),25) */
              _file = _file+CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("PROGRIF")),25);
              /* _file := _file + Left(LRTrim(tmp_chiunocod->COGNOME) + Space(26),26) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("COGNOME"))+CPLib.Space(26),26);
              /* _file := _file + Left(LRTrim(tmp_chiunocod->NOME) + Space(25),25) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("NOME"))+CPLib.Space(25),25);
              /* _file := _file + Left(LRTrim(tmp_chiunocod->SESSO)+Space(1),1) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("SESSO"))+CPLib.Space(1),1);
              /* _file := _file + Left(LRTrim(tmp_chiunocod->DATANASC) + Space(8),8) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("DATANASC"))+CPLib.Space(8),8);
              /* _file := _file + Left(LRTrim(tmp_chiunocod->COMSTA) + Space(40),40) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("COMSTA"))+CPLib.Space(40),40);
              /* _file := _file + Left(LRTrim(tmp_chiunocod->PROVNA) + Space(2),2) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("PROVNA"))+CPLib.Space(2),2);
              /* _file := _file + Left(LRTrim(tmp_chiunocod->DENOM) + Space(60),60) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("DENOM"))+CPLib.Space(60),60);
              /* _file := _file + Left(LRTrim(tmp_chiunocod->COMSEDE) + Space(40),40) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("COMSEDE"))+CPLib.Space(40),40);
              /* _file := _file + Left(LRTrim(tmp_chiunocod->PROVSED) + Space(2),2) */
              _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("PROVSED"))+CPLib.Space(2),2);
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
              /* _file := _file + _nomefile */
              _file = _file+_nomefile;
              /* _file := _file + Space(1537) */
              _file = _file+CPLib.Space(1537);
              /* _file := _file + 'A' */
              _file = _file+"A";
              /* FileLibrary.WriteLine(fhand,_file) */
              FileLibrary.WriteLine(fhand,_file);
              /* FileLibrary.Close(fhand) */
              FileLibrary.Close(fhand);
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
        } // End If
        Cursor_qbe_ricrea_2.Next();
      }
      m_cConnectivityError = Cursor_qbe_ricrea_2.ErrorMessage();
      Cursor_qbe_ricrea_2.Close();
      // * --- End Select
      /* If _fileest > 0 */
      if (CPLib.gt(_fileest,0)) {
        /* Exec "Crea file zip" Page 4 */
        Page_4();
      } // End If
    } finally {
      try {
        if (Cursor_qbe_ricrea_2!=null)
          Cursor_qbe_ricrea_2.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_ricrea_chi!=null)
          Cursor_qbe_ricrea_chi.Close();
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
                FileLibrary.DeleteFile(CPLib.LRTrim(gPathApp)+"/flussi/"+CPLib.LRTrim(_file2));
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
      m_Caller.SetNumber("files","N",1,0,w_files);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_sd_ricrea_acR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_sd_ricrea_acR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_a_data = m_Caller.GetDate("a_data","D",8,0);
    w_dadata = m_Caller.GetDate("dadata","D",8,0);
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
    _cicli = 0;
    _contacilci = 0;
    _bottom = 0;
    _top = 0;
    nProgImp = 0;
    _fileita = 0;
    _fileest = 0;
    countmp = 0;
    _estero = 0;
    w_nomefile = CPLib.Space(15);
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gFilesAge=m_Ctx.GetGlobalNumber("gFilesAge");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_ricrea_1,qbe_ricrea_ape,qbe_ricrea_1,qbe_ricrea_ape,qbe_ricrea_2,qbe_ricrea_chi,qbe_ricrea_2,qbe_ricrea_chi,
  public static final String m_cVQRList = ",qbe_ricrea_1,qbe_ricrea_ape,qbe_ricrea_1,qbe_ricrea_ape,qbe_ricrea_2,qbe_ricrea_chi,qbe_ricrea_2,qbe_ricrea_chi,";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_076CF208(CPContext p_Ctx) {
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
    p_cSql = p_cSql+"PROG,";
    if (p_Ctx.IsSharedTemp("tmp_apecod")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_apecod",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06E8BD38(CPContext p_Ctx) {
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
    p_cSql = p_cSql+"PROG,";
    if (p_Ctx.IsSharedTemp("tmp_apecod")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_apecod",true);
    return p_cSql;
  }
  protected static String GetFieldsName_062DEDF0(CPContext p_Ctx) {
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
    p_cSql = p_cSql+"PROG,";
    if (p_Ctx.IsSharedTemp("tmp_apenocod")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_apenocod",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05FA71D0(CPContext p_Ctx) {
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
    p_cSql = p_cSql+"PROG,";
    if (p_Ctx.IsSharedTemp("tmp_apenocod")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_apenocod",true);
    return p_cSql;
  }
  protected static String GetFieldsName_078E4378(CPContext p_Ctx) {
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
    p_cSql = p_cSql+"PROG,";
    if (p_Ctx.IsSharedTemp("tmp_chiucod")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_chiucod",true);
    return p_cSql;
  }
  protected static String GetFieldsName_077292F8(CPContext p_Ctx) {
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
    p_cSql = p_cSql+"PROG,";
    if (p_Ctx.IsSharedTemp("tmp_chiucod")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_chiucod",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0724C9A8(CPContext p_Ctx) {
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
    p_cSql = p_cSql+"progae,";
    p_cSql = p_cSql+"PROG,";
    if (p_Ctx.IsSharedTemp("tmp_chiunocod")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_chiunocod",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06D4F608(CPContext p_Ctx) {
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
    p_cSql = p_cSql+"PROG,";
    if (p_Ctx.IsSharedTemp("tmp_chiunocod")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_chiunocod",true);
    return p_cSql;
  }
}
