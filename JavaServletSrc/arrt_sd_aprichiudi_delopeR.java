// * --- Area Manuale = BO - Header
// * --- arrt_sd_aprichiudi_delope
import java.util.*;
// * --- Fine Area Manuale
public class arrt_sd_aprichiudi_delopeR implements CallerWithObjs {
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
  public String m_cPhName_aederig;
  public String m_cServer_aederig;
  public String m_cPhName_aefile_do_glob;
  public String m_cServer_aefile_do_glob;
  public String m_cPhName_aefiles_do;
  public String m_cServer_aefiles_do;
  public String m_cPhName_aeoprig;
  public String m_cServer_aeoprig;
  public String m_cPhName_aerighe;
  public String m_cServer_aerighe;
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
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
  public java.sql.Date w_a_data;
  public java.sql.Date w_dadata;
  public String w_FILEINVIO;
  public java.sql.Date w_DATAINVIO;
  public String w_CFINVIO;
  public String w_CAFINVIO;
  public double w_anno;
  public String w_mese;
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
  public String _intefisc;
  public String _cfint;
  public String _ragint;
  public String _citint;
  public String _prvint;
  public String _cfinvio;
  public String _cafinvio;
  public String _tipinvio;
  public String _impinvio;
  public java.sql.Date _datinvio;
  public double _itariga;
  public double _estriga;
  public double _max;
  public double _min;
  public double _tot;
  public double _mono;
  public double _cicli;
  public double _bottom;
  public double _top;
  public double _fileita;
  public double _fileest;
  public double _contacilci;
  public double countmp;
  public String _estero;
  public double _crow;
  public double _cfile;
  public double _conta;
  public String _czip;
  public String _file1;
  public String _file2;
  public MemoryCursor_tmp_apecod mcItaliaA;
  public MemoryCursorRow_tmp_apecod rowItaliaA;
  public MemoryCursor_tmp_chiucod mcItaliaC;
  public MemoryCursorRow_tmp_chiucod rowItaliaC;
  public MemoryCursor_tmp_apenocod mcEsteriA;
  public MemoryCursorRow_tmp_apenocod rowEsteriA;
  public MemoryCursor_tmp_chiunocod mcEsteriC;
  public MemoryCursorRow_tmp_chiunocod rowEsteriC;
  public String gPathApp;
  public String gIntemediario;
  public String gAzienda;
  public String gMsgImp;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_sd_aprichiudi_delope
  // These are the files to include in the ZIP file
  Vector filenames = new Vector();
  Vector fileonames = new Vector();
  // * --- Fine Area Manuale
  public arrt_sd_aprichiudi_delopeR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_sd_aprichiudi_delope",m_Caller);
    m_cPhName_aederig = p_ContextObject.GetPhName("aederig");
    m_cServer_aederig = p_ContextObject.GetServer("aederig");
    m_cPhName_aefile_do_glob = p_ContextObject.GetPhName("aefile_do_glob");
    m_cServer_aefile_do_glob = p_ContextObject.GetServer("aefile_do_glob");
    m_cPhName_aefiles_do = p_ContextObject.GetPhName("aefiles_do");
    m_cServer_aefiles_do = p_ContextObject.GetServer("aefiles_do");
    m_cPhName_aeoprig = p_ContextObject.GetPhName("aeoprig");
    m_cServer_aeoprig = p_ContextObject.GetServer("aeoprig");
    m_cPhName_aerighe = p_ContextObject.GetPhName("aerighe");
    m_cServer_aerighe = p_ContextObject.GetServer("aerighe");
    m_cPhName_aetesta = p_ContextObject.GetPhName("aetesta");
    m_cServer_aetesta = p_ContextObject.GetServer("aetesta");
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_stpfileage")) {
      m_cPhName_tmp_stpfileage = p_ContextObject.GetPhName("tmp_stpfileage");
      m_cServer_tmp_stpfileage = p_ContextObject.GetServer("tmp_stpfileage");
    }
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
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
    if (CPLib.eqr("_itariga",p_cVarName)) {
      return _itariga;
    }
    if (CPLib.eqr("_estriga",p_cVarName)) {
      return _estriga;
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
    if (CPLib.eqr("_bottom",p_cVarName)) {
      return _bottom;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      return _top;
    }
    if (CPLib.eqr("_fileita",p_cVarName)) {
      return _fileita;
    }
    if (CPLib.eqr("_fileest",p_cVarName)) {
      return _fileest;
    }
    if (CPLib.eqr("_contacilci",p_cVarName)) {
      return _contacilci;
    }
    if (CPLib.eqr("countmp",p_cVarName)) {
      return countmp;
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
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_sd_aprichiudi_delope";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
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
    if (CPLib.eqr("mese",p_cVarName)) {
      return w_mese;
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
    if (CPLib.eqr("_intefisc",p_cVarName)) {
      return _intefisc;
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
    if (CPLib.eqr("_estero",p_cVarName)) {
      return _estero;
    }
    if (CPLib.eqr("_czip",p_cVarName)) {
      return _czip;
    }
    if (CPLib.eqr("_file1",p_cVarName)) {
      return _file1;
    }
    if (CPLib.eqr("_file2",p_cVarName)) {
      return _file2;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      return gIntemediario;
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
    if (CPLib.eqr("a_data",p_cVarName)) {
      return w_a_data;
    }
    if (CPLib.eqr("dadata",p_cVarName)) {
      return w_dadata;
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
    if (CPLib.eqr("mcItaliaA",p_cVarName)) {
      return mcItaliaA;
    }
    if (CPLib.eqr("mcItaliaC",p_cVarName)) {
      return mcItaliaC;
    }
    if (CPLib.eqr("mcEsteriA",p_cVarName)) {
      return mcEsteriA;
    }
    if (CPLib.eqr("mcEsteriC",p_cVarName)) {
      return mcEsteriC;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("rowItaliaA",p_cVarName)) {
      return rowItaliaA;
    }
    if (CPLib.eqr("rowItaliaC",p_cVarName)) {
      return rowItaliaC;
    }
    if (CPLib.eqr("rowEsteriA",p_cVarName)) {
      return rowEsteriA;
    }
    if (CPLib.eqr("rowEsteriC",p_cVarName)) {
      return rowEsteriC;
    }
    return null;
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
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
    if (CPLib.eqr("_itariga",p_cVarName)) {
      _itariga = value;
      return;
    }
    if (CPLib.eqr("_estriga",p_cVarName)) {
      _estriga = value;
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
    if (CPLib.eqr("_bottom",p_cVarName)) {
      _bottom = value;
      return;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      _top = value;
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
    if (CPLib.eqr("_contacilci",p_cVarName)) {
      _contacilci = value;
      return;
    }
    if (CPLib.eqr("countmp",p_cVarName)) {
      countmp = value;
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
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
    if (CPLib.eqr("mese",p_cVarName)) {
      w_mese = value;
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
    if (CPLib.eqr("_intefisc",p_cVarName)) {
      _intefisc = value;
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
    if (CPLib.eqr("_estero",p_cVarName)) {
      _estero = value;
      return;
    }
    if (CPLib.eqr("_czip",p_cVarName)) {
      _czip = value;
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
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      gIntemediario = value;
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
    if (CPLib.eqr("a_data",p_cVarName)) {
      w_a_data = value;
      return;
    }
    if (CPLib.eqr("dadata",p_cVarName)) {
      w_dadata = value;
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
    if (CPLib.eqr("rowItaliaA",p_cVarName)) {
      rowItaliaA = (MemoryCursorRow_tmp_apecod)value;
      return;
    }
    if (CPLib.eqr("rowItaliaC",p_cVarName)) {
      rowItaliaC = (MemoryCursorRow_tmp_chiucod)value;
      return;
    }
    if (CPLib.eqr("rowEsteriA",p_cVarName)) {
      rowEsteriA = (MemoryCursorRow_tmp_apenocod)value;
      return;
    }
    if (CPLib.eqr("rowEsteriC",p_cVarName)) {
      rowEsteriC = (MemoryCursorRow_tmp_chiunocod)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcItaliaA",p_cVarName)) {
      mcItaliaA = (MemoryCursor_tmp_apecod)value;
      return;
    }
    if (CPLib.eqr("mcItaliaC",p_cVarName)) {
      mcItaliaC = (MemoryCursor_tmp_chiucod)value;
      return;
    }
    if (CPLib.eqr("mcEsteriA",p_cVarName)) {
      mcEsteriA = (MemoryCursor_tmp_apenocod)value;
      return;
    }
    if (CPLib.eqr("mcEsteriC",p_cVarName)) {
      mcEsteriC = (MemoryCursor_tmp_chiunocod)value;
      return;
    }
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_intermbo=null;
    try {
      /* w_a_data Date */
      /* w_dadata Date */
      /* w_FILEINVIO Char(1) // Tipo Preparazione FIle */
      /* w_DATAINVIO Date // Data Impegno Organo Invio */
      /* w_CFINVIO Char(16) // Codice Fiscale Organo Invio File */
      /* w_CAFINVIO Char(5) // Codice CAF Organo Invio */
      /* w_anno Numeric(4, 0) */
      /* w_mese Char(2) */
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
      /* _nocodrec Numeric(10, 0) */
      /* _sicodrec Numeric(10, 0) */
      /* _intefisc Char(16) */
      /* _cfint Char(16) */
      /* _ragint Char(70) */
      /* _citint Char(40) */
      /* _prvint Char(2) */
      /* _cfinvio Char(16) */
      /* _cafinvio Char(5) */
      /* _tipinvio Char(1) */
      /* _impinvio Char(8) */
      /* _datinvio Date */
      /* _itariga Numeric(1, 0) */
      /* _estriga Numeric(1, 0) */
      /* _max Numeric(15, 0) */
      /* _min Numeric(15, 0) */
      /* _tot Numeric(15, 0) */
      /* _mono Numeric(1, 0) */
      /* _cicli Numeric(15, 0) */
      /* _bottom Numeric(15, 0) */
      /* _top Numeric(15, 0) */
      /* _fileita Numeric(3, 0) // Conteggio file soggetti italiani */
      /* _fileest Numeric(3, 0) // Conteggio file soggetti esteri */
      /* _contacilci Numeric(15, 0) */
      /* countmp Numeric(15, 0) // Contatore delle occorenze inserite nel temporaneo */
      /* _estero Char(1) */
      /* _crow Numeric(10, 0) */
      /* _cfile Numeric(10, 0) */
      /* _conta Numeric(10, 0) */
      /* _czip Char(20) */
      /* _file1 Char(30) */
      /* _file2 Char(30) */
      /* mcItaliaA MemoryCursor(tmp_apecod) */
      /* rowItaliaA Row(tmp_apecod) */
      /* mcItaliaC MemoryCursor(tmp_chiucod) */
      /* rowItaliaC Row(tmp_chiucod) */
      /* mcEsteriA MemoryCursor(tmp_apenocod) */
      /* rowEsteriA Row(tmp_apenocod) */
      /* mcEsteriC MemoryCursor(tmp_chiunocod) */
      /* rowEsteriC Row(tmp_chiunocod) */
      /* gPathApp Char(80) // Path Applicazione */
      /* gIntemediario Char(11) // Intermediario */
      /* gAzienda Char(10) // Azienda */
      /* gMsgImp Char(120) // Messaggio Import */
      /* Crea file apertura e chiusura */
      /* gMsgImp := 'Elaborazione anno '+Str(w_anno,4,0)+' mese '+w_mese // Messaggio Import */
      gMsgImp = "Elaborazione anno "+CPLib.Str(w_anno,4,0)+" mese "+w_mese;
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
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
      /* Scrive i dati */
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
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry07272F18status;
      nTry07272F18status = m_Sql.GetTransactionStatus();
      String cTry07272F18msg;
      cTry07272F18msg = m_Sql.TransactionErrorMessage();
      try {
        /* Exec "Aperture" Page 2:Page_2 */
        Page_2();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* Exec "Chiusure" Page 3:Page_3 */
        Page_3();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        /* gMsgImp := 'Elaborazione Terminata. Premere il bottone per prelevare i file' // Messaggio Import */
        gMsgImp = "Elaborazione Terminata. Premere il bottone per prelevare i file";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
        /* gMsgImp := _errlog // Messaggio Import */
        gMsgImp = _errlog;
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry07272F18status,0)) {
          m_Sql.SetTransactionStatus(nTry07272F18status,cTry07272F18msg);
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
    }
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_qbe_invio_delope_ape_5=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_qbe_invio_delope_ape_6_max_min_glob=null;
    CPResultSet Cursor_qbe_invio_delope_ape_6_globale=null;
    CPResultSet Read_Cursor=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Invii Periodici */
      /* _nocodrec := 0 */
      _nocodrec = CPLib.Round(0,0);
      /* _sicodrec := 0 */
      _sicodrec = CPLib.Round(0,0);
      /* gMsgImp := 'Selezione dei record da esportare' // Messaggio Import */
      gMsgImp = "Selezione dei record da esportare";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
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
      /* _estero := 'N' */
      _estero = "N";
      // * --- Select from qbe_invio_delope_ape_5
      if (Cursor_qbe_invio_delope_ape_5!=null)
        Cursor_qbe_invio_delope_ape_5.Close();
      Cursor_qbe_invio_delope_ape_5 = new VQRHolder("qbe_invio_delope_ape_5",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_invio_delope_ape_5.Eof())) {
        // * --- Select from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
        Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_invio_delope_ape_5.GetString("CONNESINT"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_personbo.Eof())) {
          /* _sicodrec := _sicodrec + 1 */
          _sicodrec = CPLib.Round(_sicodrec+1,0);
          /* If not(Empty(personbo->COGNOME)) and (not(Empty(personbo->NOME)) or (Upper(Substr(personbo->CODFISC,4,3))='XXX' and not(Empty(personbo->SESSO)))) and Len(LRTrim(personbo->CODFISC)) = 16 */
          if ( ! (CPLib.Empty(Cursor_personbo.GetString("COGNOME"))) && ( ! (CPLib.Empty(Cursor_personbo.GetString("NOME"))) || (CPLib.eqr(CPLib.Upper(CPLib.Substr(Cursor_personbo.GetString("CODFISC"),4,3)),"XXX") &&  ! (CPLib.Empty(Cursor_personbo.GetString("SESSO"))))) && CPLib.eqr(CPLib.Len(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))),16)) {
            /* _cdata1 := Right(DateToChar(personbo->DATANASC),2)+Substr(DateToChar(personbo->DATANASC),5,2)+Left(DateToChar(personbo->DATANASC),4) */
            _cdata1 = CPLib.Right(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),4);
            /* _cdata2 := Right(DateToChar(qbe_invio_delope_ape_5->ADATA),2)+Substr(DateToChar(qbe_invio_delope_ape_5->ADATA),5,2)+Left(DateToChar(qbe_invio_delope_ape_5->ADATA),4) */
            _cdata2 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_invio_delope_ape_5.GetDate("ADATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_invio_delope_ape_5.GetDate("ADATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_invio_delope_ape_5.GetDate("ADATA")),4);
            /* _cdata3 := '' */
            _cdata3 = "";
            /* If not(Empty(personbo->NASSTATO)) and Upper(LRTrim(personbo->NASSTATO)) <> 'ITALIA' */
            if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO"))) && CPLib.ne(CPLib.Upper(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))),"ITALIA")) {
              /* _descit := personbo->NASSTATO */
              _descit = Cursor_personbo.GetString("NASSTATO");
            } else { // Else
              /* _descit := personbo->NASCOMUN */
              _descit = Cursor_personbo.GetString("NASCOMUN");
            } // End If
            /* mcItaliaA.AppendBlank() */
            mcItaliaA.AppendBlank();
            /* mcItaliaA.TIPOREC := '1' */
            mcItaliaA.row.TIPOREC = "1";
            /* mcItaliaA.COGNOME := personbo->COGNOME */
            mcItaliaA.row.COGNOME = Cursor_personbo.GetString("COGNOME");
            /* mcItaliaA.NOME := personbo->NOME */
            mcItaliaA.row.NOME = Cursor_personbo.GetString("NOME");
            /* mcItaliaA.SESSO := iif(personbo->SESSO='F' or personbo->SESSO='2','F','M') */
            mcItaliaA.row.SESSO = (CPLib.eqr(Cursor_personbo.GetString("SESSO"),"F") || CPLib.eqr(Cursor_personbo.GetString("SESSO"),"2")?"F":"M");
            /* mcItaliaA.DATANASC := _cdata1 */
            mcItaliaA.row.DATANASC = _cdata1;
            /* mcItaliaA.COMSTA := _descit */
            mcItaliaA.row.COMSTA = _descit;
            /* mcItaliaA.PROVNA := personbo->TIPINTER */
            mcItaliaA.row.PROVNA = Cursor_personbo.GetString("TIPINTER");
            /* mcItaliaA.TIPORAP := qbe_invio_delope_ape_5->TIPOAG */
            mcItaliaA.row.TIPORAP = Cursor_qbe_invio_delope_ape_5.GetString("TIPOAG");
            /* mcItaliaA.COINT := qbe_invio_delope_ape_5->COINT */
            mcItaliaA.row.COINT = Cursor_qbe_invio_delope_ape_5.GetString("COINT");
            /* mcItaliaA.RAPPORTO := qbe_invio_delope_ape_5->RAPPORTO */
            mcItaliaA.row.RAPPORTO = Cursor_qbe_invio_delope_ape_5.GetString("RAPPORTO");
            /* mcItaliaA.DATAINI := _cdata2 */
            mcItaliaA.row.DATAINI = _cdata2;
            /* mcItaliaA.DATACHIU := _cdata3 */
            mcItaliaA.row.DATACHIU = _cdata3;
            /* mcItaliaA.IDBASE := qbe_invio_delope_ape_5->IDBASE */
            mcItaliaA.row.IDBASE = Cursor_qbe_invio_delope_ape_5.GetString("IDBASE");
            /* mcItaliaA.CODFISC := personbo->CODFISC */
            mcItaliaA.row.CODFISC = Cursor_personbo.GetString("CODFISC");
            /* mcItaliaA.progae := _sicodrec */
            mcItaliaA.row.progae = _sicodrec;
            /* mcItaliaA.SaveRow() */
            mcItaliaA.SaveRow();
          } else { // Else
            /* _cdata2 := Right(DateToChar(qbe_invio_delope_ape_5->ADATA),2)+Substr(DateToChar(qbe_invio_delope_ape_5->ADATA),5,2)+Left(DateToChar(qbe_invio_delope_ape_5->ADATA),4) */
            _cdata2 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_invio_delope_ape_5.GetDate("ADATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_invio_delope_ape_5.GetDate("ADATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_invio_delope_ape_5.GetDate("ADATA")),4);
            /* _cdata3 := '' */
            _cdata3 = "";
            /* mcItaliaA.AppendBlank() */
            mcItaliaA.AppendBlank();
            /* mcItaliaA.TIPOREC := '1' */
            mcItaliaA.row.TIPOREC = "1";
            /* mcItaliaA.DENOM := Left(personbo->RAGSOC,60) */
            mcItaliaA.row.DENOM = CPLib.Left(Cursor_personbo.GetString("RAGSOC"),60);
            /* mcItaliaA.COMSEDE := personbo->DESCCIT */
            mcItaliaA.row.COMSEDE = Cursor_personbo.GetString("DESCCIT");
            /* mcItaliaA.PROVSED := personbo->PROVINCIA */
            mcItaliaA.row.PROVSED = Cursor_personbo.GetString("PROVINCIA");
            /* mcItaliaA.TIPORAP := qbe_invio_delope_ape_5->TIPOAG */
            mcItaliaA.row.TIPORAP = Cursor_qbe_invio_delope_ape_5.GetString("TIPOAG");
            /* mcItaliaA.COINT := qbe_invio_delope_ape_5->COINT */
            mcItaliaA.row.COINT = Cursor_qbe_invio_delope_ape_5.GetString("COINT");
            /* mcItaliaA.RAPPORTO := qbe_invio_delope_ape_5->RAPPORTO */
            mcItaliaA.row.RAPPORTO = Cursor_qbe_invio_delope_ape_5.GetString("RAPPORTO");
            /* mcItaliaA.DATAINI := _cdata2 */
            mcItaliaA.row.DATAINI = _cdata2;
            /* mcItaliaA.DATACHIU := _cdata3 */
            mcItaliaA.row.DATACHIU = _cdata3;
            /* mcItaliaA.IDBASE := qbe_invio_delope_ape_5->IDBASE */
            mcItaliaA.row.IDBASE = Cursor_qbe_invio_delope_ape_5.GetString("IDBASE");
            /* mcItaliaA.CODFISC := personbo->CODFISC */
            mcItaliaA.row.CODFISC = Cursor_personbo.GetString("CODFISC");
            /* mcItaliaA.progae := _sicodrec */
            mcItaliaA.row.progae = _sicodrec;
            /* mcItaliaA.SaveRow() */
            mcItaliaA.SaveRow();
          } // End If
          Cursor_personbo.Next();
        }
        m_cConnectivityError = Cursor_personbo.ErrorMessage();
        Cursor_personbo.Close();
        // * --- End Select
        Cursor_qbe_invio_delope_ape_5.Next();
      }
      m_cConnectivityError = Cursor_qbe_invio_delope_ape_5.ErrorMessage();
      Cursor_qbe_invio_delope_ape_5.Close();
      // * --- End Select
      // * --- Select from qbe_invio_delope_ape_6_max_min_glob
      if (Cursor_qbe_invio_delope_ape_6_max_min_glob!=null)
        Cursor_qbe_invio_delope_ape_6_max_min_glob.Close();
      Cursor_qbe_invio_delope_ape_6_max_min_glob = new VQRHolder("qbe_invio_delope_ape_6_max_min_glob",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_invio_delope_ape_6_max_min_glob.Eof())) {
        /* _max := qbe_invio_delope_ape_6_max_min_glob->MAXPROGOPX */
        _max = CPLib.Round(Cursor_qbe_invio_delope_ape_6_max_min_glob.GetDouble("MAXPROGOPX"),0);
        /* _min := qbe_invio_delope_ape_6_max_min_glob->MINPROGOPX */
        _min = CPLib.Round(Cursor_qbe_invio_delope_ape_6_max_min_glob.GetDouble("MINPROGOPX"),0);
        /* _tot := qbe_invio_delope_ape_6_max_min_glob->TOTPROGOPX */
        _tot = CPLib.Round(Cursor_qbe_invio_delope_ape_6_max_min_glob.GetDouble("TOTPROGOPX"),0);
        Cursor_qbe_invio_delope_ape_6_max_min_glob.Next();
      }
      m_cConnectivityError = Cursor_qbe_invio_delope_ape_6_max_min_glob.ErrorMessage();
      Cursor_qbe_invio_delope_ape_6_max_min_glob.Close();
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
      /* gMsgImp := 'Lettura informazioni in corso ...' // Messaggio Import */
      gMsgImp = "Lettura informazioni in corso ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
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
        /* gMsgImp := 'Lettura informazioni in corso ... Ciclo N. '+LRTrim(Str(_contacilci,10,0)) // Messaggio Import */
        gMsgImp = "Lettura informazioni in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacilci,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If _top>=_min */
        if (CPLib.ge(_top,_min)) {
          // * --- Select from qbe_invio_delope_ape_6_globale
          if (Cursor_qbe_invio_delope_ape_6_globale!=null)
            Cursor_qbe_invio_delope_ape_6_globale.Close();
          Cursor_qbe_invio_delope_ape_6_globale = new VQRHolder("qbe_invio_delope_ape_6_globale",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_invio_delope_ape_6_globale.Eof())) {
            /* gMsgImp := "Elaborazione soggetti con CF italiano. Sto elaborando l'informazione N° " + LRTrim(Str(_nocodrec+_sicodrec,10,0)) // Messaggio allineamento 1 */
            gMsgImp = "Elaborazione soggetti con CF italiano. Sto elaborando l'informazione N° "+CPLib.LRTrim(CPLib.Str(_nocodrec+_sicodrec,10,0));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* _sicodrec := _sicodrec + 1 */
            _sicodrec = CPLib.Round(_sicodrec+1,0);
            /* If not(Empty(qbe_invio_delope_ape_6_globale->COGNOME)) and (not(Empty(qbe_invio_delope_ape_6_globale->NOME)) or (Upper(Substr(qbe_invio_delope_ape_6_globale->CODFISC,4,3))='XXX' and not(Empty(qbe_invio_delope_ape_6_globale->SESSO)))) and Len(LRTrim(qbe_invio_delope_ape_6_globale->CODFISC)) = 16 */
            if ( ! (CPLib.Empty(Cursor_qbe_invio_delope_ape_6_globale.GetString("COGNOME"))) && ( ! (CPLib.Empty(Cursor_qbe_invio_delope_ape_6_globale.GetString("NOME"))) || (CPLib.eqr(CPLib.Upper(CPLib.Substr(Cursor_qbe_invio_delope_ape_6_globale.GetString("CODFISC"),4,3)),"XXX") &&  ! (CPLib.Empty(Cursor_qbe_invio_delope_ape_6_globale.GetString("SESSO"))))) && CPLib.eqr(CPLib.Len(CPLib.LRTrim(Cursor_qbe_invio_delope_ape_6_globale.GetString("CODFISC"))),16)) {
              /* _cdata1 := Right(DateToChar(qbe_invio_delope_ape_6_globale->DATANASC),2)+Substr(DateToChar(qbe_invio_delope_ape_6_globale->DATANASC),5,2)+Left(DateToChar(qbe_invio_delope_ape_6_globale->DATANASC),4) */
              _cdata1 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_invio_delope_ape_6_globale.GetDate("DATANASC")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_invio_delope_ape_6_globale.GetDate("DATANASC")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_invio_delope_ape_6_globale.GetDate("DATANASC")),4);
              /* _cdata2 := Right(DateToChar(qbe_invio_delope_ape_6_globale->ADATA),2)+Substr(DateToChar(qbe_invio_delope_ape_6_globale->ADATA),5,2)+Left(DateToChar(qbe_invio_delope_ape_6_globale->ADATA),4) */
              _cdata2 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_invio_delope_ape_6_globale.GetDate("ADATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_invio_delope_ape_6_globale.GetDate("ADATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_invio_delope_ape_6_globale.GetDate("ADATA")),4);
              /* _cdata3 := '' */
              _cdata3 = "";
              /* If not(Empty(qbe_invio_delope_ape_6_globale->NASSTATO)) and Upper(LRTrim(qbe_invio_delope_ape_6_globale->NASSTATO)) <> 'ITALIA' */
              if ( ! (CPLib.Empty(Cursor_qbe_invio_delope_ape_6_globale.GetString("NASSTATO"))) && CPLib.ne(CPLib.Upper(CPLib.LRTrim(Cursor_qbe_invio_delope_ape_6_globale.GetString("NASSTATO"))),"ITALIA")) {
                /* _descit := qbe_invio_delope_ape_6_globale->NASSTATO */
                _descit = Cursor_qbe_invio_delope_ape_6_globale.GetString("NASSTATO");
              } else { // Else
                /* _descit := qbe_invio_delope_ape_6_globale->NASCOMUN */
                _descit = Cursor_qbe_invio_delope_ape_6_globale.GetString("NASCOMUN");
              } // End If
              /* mcItaliaA.AppendBlank() */
              mcItaliaA.AppendBlank();
              /* mcItaliaA.TIPOREC := '1' */
              mcItaliaA.row.TIPOREC = "1";
              /* mcItaliaA.COGNOME := qbe_invio_delope_ape_6_globale->COGNOME */
              mcItaliaA.row.COGNOME = Cursor_qbe_invio_delope_ape_6_globale.GetString("COGNOME");
              /* mcItaliaA.NOME := qbe_invio_delope_ape_6_globale->NOME */
              mcItaliaA.row.NOME = Cursor_qbe_invio_delope_ape_6_globale.GetString("NOME");
              /* mcItaliaA.SESSO := iif(qbe_invio_delope_ape_6_globale->SESSO='F' or qbe_invio_delope_ape_6_globale->SESSO='2','F','M') */
              mcItaliaA.row.SESSO = (CPLib.eqr(Cursor_qbe_invio_delope_ape_6_globale.GetString("SESSO"),"F") || CPLib.eqr(Cursor_qbe_invio_delope_ape_6_globale.GetString("SESSO"),"2")?"F":"M");
              /* mcItaliaA.DATANASC := _cdata1 */
              mcItaliaA.row.DATANASC = _cdata1;
              /* mcItaliaA.COMSTA := _descit */
              mcItaliaA.row.COMSTA = _descit;
              /* mcItaliaA.PROVNA := qbe_invio_delope_ape_6_globale->TIPINTER */
              mcItaliaA.row.PROVNA = Cursor_qbe_invio_delope_ape_6_globale.GetString("TIPINTER");
              /* mcItaliaA.TIPORAP := qbe_invio_delope_ape_6_globale->TIPOAG */
              mcItaliaA.row.TIPORAP = Cursor_qbe_invio_delope_ape_6_globale.GetString("TIPOAG");
              /* mcItaliaA.COINT := qbe_invio_delope_ape_6_globale->COINT */
              mcItaliaA.row.COINT = Cursor_qbe_invio_delope_ape_6_globale.GetString("COINT");
              /* mcItaliaA.RAPPORTO := qbe_invio_delope_ape_6_globale->RAPPORTO */
              mcItaliaA.row.RAPPORTO = Cursor_qbe_invio_delope_ape_6_globale.GetString("RAPPORTO");
              /* mcItaliaA.DATAINI := _cdata2 */
              mcItaliaA.row.DATAINI = _cdata2;
              /* mcItaliaA.DATACHIU := _cdata3 */
              mcItaliaA.row.DATACHIU = _cdata3;
              /* mcItaliaA.IDBASE := qbe_invio_delope_ape_6_globale->IDBASE */
              mcItaliaA.row.IDBASE = Cursor_qbe_invio_delope_ape_6_globale.GetString("IDBASE");
              /* mcItaliaA.CODFISC := qbe_invio_delope_ape_6_globale->CODFISC */
              mcItaliaA.row.CODFISC = Cursor_qbe_invio_delope_ape_6_globale.GetString("CODFISC");
              /* mcItaliaA.progae := _sicodrec */
              mcItaliaA.row.progae = _sicodrec;
              /* mcItaliaA.SaveRow() */
              mcItaliaA.SaveRow();
            } else { // Else
              /* _cdata2 := Right(DateToChar(qbe_invio_delope_ape_6_globale->ADATA),2)+Substr(DateToChar(qbe_invio_delope_ape_6_globale->ADATA),5,2)+Left(DateToChar(qbe_invio_delope_ape_6_globale->ADATA),4) */
              _cdata2 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_invio_delope_ape_6_globale.GetDate("ADATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_invio_delope_ape_6_globale.GetDate("ADATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_invio_delope_ape_6_globale.GetDate("ADATA")),4);
              /* _cdata3 := '' */
              _cdata3 = "";
              /* mcItaliaA.AppendBlank() */
              mcItaliaA.AppendBlank();
              /* mcItaliaA.TIPOREC := '1' */
              mcItaliaA.row.TIPOREC = "1";
              /* mcItaliaA.DENOM := Left(qbe_invio_delope_ape_6_globale->RAGSOC,60) */
              mcItaliaA.row.DENOM = CPLib.Left(Cursor_qbe_invio_delope_ape_6_globale.GetString("RAGSOC"),60);
              /* mcItaliaA.COMSEDE := qbe_invio_delope_ape_6_globale->DESCCIT */
              mcItaliaA.row.COMSEDE = Cursor_qbe_invio_delope_ape_6_globale.GetString("DESCCIT");
              /* mcItaliaA.PROVSED := qbe_invio_delope_ape_6_globale->PROVINCIA */
              mcItaliaA.row.PROVSED = Cursor_qbe_invio_delope_ape_6_globale.GetString("PROVINCIA");
              /* mcItaliaA.TIPORAP := qbe_invio_delope_ape_6_globale->TIPOAG */
              mcItaliaA.row.TIPORAP = Cursor_qbe_invio_delope_ape_6_globale.GetString("TIPOAG");
              /* mcItaliaA.COINT := qbe_invio_delope_ape_6_globale->COINT */
              mcItaliaA.row.COINT = Cursor_qbe_invio_delope_ape_6_globale.GetString("COINT");
              /* mcItaliaA.RAPPORTO := qbe_invio_delope_ape_6_globale->RAPPORTO */
              mcItaliaA.row.RAPPORTO = Cursor_qbe_invio_delope_ape_6_globale.GetString("RAPPORTO");
              /* mcItaliaA.DATAINI := _cdata2 */
              mcItaliaA.row.DATAINI = _cdata2;
              /* mcItaliaA.DATACHIU := _cdata3 */
              mcItaliaA.row.DATACHIU = _cdata3;
              /* mcItaliaA.IDBASE := qbe_invio_delope_ape_6_globale->IDBASE */
              mcItaliaA.row.IDBASE = Cursor_qbe_invio_delope_ape_6_globale.GetString("IDBASE");
              /* mcItaliaA.CODFISC := qbe_invio_delope_ape_6_globale->CODFISC */
              mcItaliaA.row.CODFISC = Cursor_qbe_invio_delope_ape_6_globale.GetString("CODFISC");
              /* mcItaliaA.progae := _sicodrec */
              mcItaliaA.row.progae = _sicodrec;
              /* mcItaliaA.SaveRow() */
              mcItaliaA.SaveRow();
            } // End If
            /* countmp := countmp+1 // Contatore delle occorenze inserite nel temporaneo */
            countmp = CPLib.Round(countmp+1,0);
            Cursor_qbe_invio_delope_ape_6_globale.Next();
          }
          m_cConnectivityError = Cursor_qbe_invio_delope_ape_6_globale.ErrorMessage();
          Cursor_qbe_invio_delope_ape_6_globale.Close();
          // * --- End Select
        } else { // Else
          /* gMsgImp := 'Lettura informazioni in corso ...' // Messaggio Import */
          gMsgImp = "Lettura informazioni in corso ...";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } // End If
        /* _contacilci := _contacilci+1 */
        _contacilci = CPLib.Round(_contacilci+1,0);
      } // End While
      /* _i := 1 */
      _i = CPLib.Round(1,0);
      /* _crow := 0 */
      _crow = CPLib.Round(0,0);
      /* _cfile := 0 */
      _cfile = CPLib.Round(0,0);
      /* _conta := 1 */
      _conta = CPLib.Round(1,0);
      for (MemoryCursorRow_tmp_apecod rowItaliaA : mcItaliaA._iterable_()) {
        /* If _crow = 0 and _i=1 */
        if (CPLib.eqr(_crow,0) && CPLib.eqr(_i,1)) {
          /* _nomefile := '99'+Right(DateTimeToChar(DateTime()),12)+'1' */
          _nomefile = "99"+CPLib.Right(CPLib.DateTimeToChar(CPLib.DateTime()),12)+"1";
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
          /* _crow := 1 */
          _crow = CPLib.Round(1,0);
        } // End If
        /* gMsgImp := 'Elaborazione soggetti con CF italiano. Sto scrivendo il file ' + LRTrim(cOnlyNomeFile)+ ' - Riga N° '+ LRTrim(Str(_crow,10,0)) // Messaggio Import */
        gMsgImp = "Elaborazione soggetti con CF italiano. Sto scrivendo il file "+CPLib.LRTrim(cOnlyNomeFile)+" - Riga N° "+CPLib.LRTrim(CPLib.Str(_crow,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _r := _r + 1 */
        _r = CPLib.Round(_r+1,0);
        /* If _i = 1 */
        if (CPLib.eqr(_i,1)) {
          /* _file := rowItaliaA.TIPOREC */
          _file = rowItaliaA.TIPOREC;
        } // End If
        /* _file := _file + Right("0000000000000000000000000000000000000000" + LRTrim(Str(_r)),25) */
        _file = _file+CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(CPLib.Str(_r)),25);
        /* _file := _file + Left(LRTrim(arfn_agechar(rowItaliaA.CODFISC,' ')) + Space(16),16) */
        _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowItaliaA.CODFISC," "))+CPLib.Space(16),16);
        /* _file := _file + Left(LRTrim(arfn_agechar(rowItaliaA.COGNOME,' '))+ Space(26),26) */
        _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowItaliaA.COGNOME," "))+CPLib.Space(26),26);
        /* _file := _file + Left(LRTrim(arfn_agechar(rowItaliaA.NOME,' ')) + Space(25),25) */
        _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowItaliaA.NOME," "))+CPLib.Space(25),25);
        /* _file := _file + Left(LRTrim(arfn_agechar(rowItaliaA.SESSO,' '))+Space(1),1) */
        _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowItaliaA.SESSO," "))+CPLib.Space(1),1);
        /* _file := _file + Left(LRTrim(rowItaliaA.DATANASC) + Space(8),8) */
        _file = _file+CPLib.Left(CPLib.LRTrim(rowItaliaA.DATANASC)+CPLib.Space(8),8);
        /* _file := _file + Left(LRTrim(arfn_agechar(rowItaliaA.COMSTA,' ')) + Space(40),40) */
        _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowItaliaA.COMSTA," "))+CPLib.Space(40),40);
        /* _file := _file + Left(LRTrim(arfn_agechar(rowItaliaA.PROVNA,' ')) + Space(2),2) */
        _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowItaliaA.PROVNA," "))+CPLib.Space(2),2);
        /* _file := _file + Left(LRTrim(arfn_agechar(rowItaliaA.DENOM,' ')) + Space(60),60) */
        _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowItaliaA.DENOM," "))+CPLib.Space(60),60);
        /* _file := _file + Left(LRTrim(arfn_agechar(rowItaliaA.COMSEDE,' ')) + Space(40),40) */
        _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowItaliaA.COMSEDE," "))+CPLib.Space(40),40);
        /* _file := _file + Left(LRTrim(arfn_agechar(rowItaliaA.PROVSED,' ')) + Space(2),2) */
        _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowItaliaA.PROVSED," "))+CPLib.Space(2),2);
        /* _file := _file + Left(LRTrim(rowItaliaA.TIPORAP) + Space(2),2) */
        _file = _file+CPLib.Left(CPLib.LRTrim(rowItaliaA.TIPORAP)+CPLib.Space(2),2);
        /* _file := _file + Left(LRTrim(rowItaliaA.COINT) + Space(1),1) */
        _file = _file+CPLib.Left(CPLib.LRTrim(rowItaliaA.COINT)+CPLib.Space(1),1);
        /* _file := _file + Left(LRTrim(rowItaliaA.DATAINI) + Space(8),8) */
        _file = _file+CPLib.Left(CPLib.LRTrim(rowItaliaA.DATAINI)+CPLib.Space(8),8);
        /* If not(Empty(rowItaliaA.DATACHIU)) and CharToDate(rowItaliaA.DATACHIU) >= w_dadata and CharToDate(rowItaliaA.DATACHIU) <= w_a_data */
        if ( ! (CPLib.Empty(rowItaliaA.DATACHIU)) && CPLib.ge(CPLib.CharToDate(rowItaliaA.DATACHIU),w_dadata) && CPLib.le(CPLib.CharToDate(rowItaliaA.DATACHIU),w_a_data)) {
          /* _file := _file + Left(LRTrim(rowItaliaA.DATACHIU) + Space(8),8) */
          _file = _file+CPLib.Left(CPLib.LRTrim(rowItaliaA.DATACHIU)+CPLib.Space(8),8);
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
        /* If rowItaliaA.TIPORAP='98' */
        if (CPLib.eqr(rowItaliaA.TIPORAP,"98")) {
          // * --- Write into aeoprig from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aeoprig");
          m_cPhName = m_Ctx.GetPhName("aeoprig");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = "Update "+m_cPhName+" set ";
          m_cSql = m_cSql+"ASPEDITO = "+CPLib.ToSQL(1,"N",1,0)+", ";
          m_cSql = m_cSql+"APROG = "+CPLib.ToSQL(_r,"C",25,0,m_cServer)+", ";
          m_cSql = m_cSql+"AFILE = "+CPLib.ToSQL(_nomefile,"C",15,0,m_cServer)+", ";
          m_cSql = m_cSql+"ADTPRE = "+CPLib.ToSQL(w_a_data,"D",8,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aeoprig",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowItaliaA.IDBASE,"?",0,0,m_cServer),m_cServer,rowItaliaA.IDBASE)+"";
          if (m_Ctx.IsSharedTemp("aeoprig")) {
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
          // * --- Write into aederig from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aederig");
          m_cPhName = m_Ctx.GetPhName("aederig");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = "Update "+m_cPhName+" set ";
          m_cSql = m_cSql+"ASPEDITO = "+CPLib.ToSQL(1,"N",1,0)+", ";
          m_cSql = m_cSql+"APROG = "+CPLib.ToSQL(_r,"C",25,0,m_cServer)+", ";
          m_cSql = m_cSql+"AFILE = "+CPLib.ToSQL(_nomefile,"C",15,0,m_cServer)+", ";
          m_cSql = m_cSql+"ADTPRE = "+CPLib.ToSQL(w_a_data,"D",8,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aederig",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowItaliaA.IDBASE,"?",0,0,m_cServer),m_cServer,rowItaliaA.IDBASE)+"";
          if (m_Ctx.IsSharedTemp("aederig")) {
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
          /* If not(Empty(rowItaliaA.DATACHIU)) and CharToDate(rowItaliaA.DATACHIU) >= w_dadata and CharToDate(rowItaliaA.DATACHIU) <= w_a_data */
          if ( ! (CPLib.Empty(rowItaliaA.DATACHIU)) && CPLib.ge(CPLib.CharToDate(rowItaliaA.DATACHIU),w_dadata) && CPLib.le(CPLib.CharToDate(rowItaliaA.DATACHIU),w_a_data)) {
            // * --- Write into aederig from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("aederig");
            m_cPhName = m_Ctx.GetPhName("aederig");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = "Update "+m_cPhName+" set ";
            m_cSql = m_cSql+"CSPEDITO = "+CPLib.ToSQL(1,"N",1,0)+", ";
            m_cSql = m_cSql+"CPROG = "+CPLib.ToSQL(_r,"C",25,0,m_cServer)+", ";
            m_cSql = m_cSql+"CFILE = "+CPLib.ToSQL(_nomefile,"C",15,0,m_cServer)+", ";
            m_cSql = m_cSql+"CDTPRE = "+CPLib.ToSQL(w_a_data,"D",8,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aederig",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowItaliaA.IDBASE,"?",0,0,m_cServer),m_cServer,rowItaliaA.IDBASE)+"";
            if (m_Ctx.IsSharedTemp("aederig")) {
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
        } // End If
        // * --- Insert into tmp_stpfileage from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_stpfileage");
        m_cPhName = m_Ctx.GetPhName("tmp_stpfileage");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_stpfileage")+" (";
        m_cSql = m_cSql+GetFieldsName_05DF0278(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowItaliaA.RAPPORTO,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(CPLib.Str(_r)),25),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(rowItaliaA.SESSO)?rowItaliaA.DENOM:CPLib.LRTrim(rowItaliaA.COGNOME)+" "+CPLib.LRTrim(rowItaliaA.NOME)),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowItaliaA.DATAINI,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowItaliaA.DATACHIU,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowItaliaA.COINT,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowItaliaA.TIPORAP,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowItaliaA.CODFISC,"?",0,0,m_cServer)+", ";
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
          /* _file := _file + LRTrim(arfn_agechar(_ragint,' '))+Space(70 - Len(LRTrim(_ragint))) */
          _file = _file+CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(_ragint," "))+CPLib.Space(70-CPLib.Len(CPLib.LRTrim(_ragint)));
          /* _file := _file + LRTrim(arfn_agechar(_citint,' '))+Space(40 - Len(LRTrim(_citint))) */
          _file = _file+CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(_citint," "))+CPLib.Space(40-CPLib.Len(CPLib.LRTrim(_citint)));
          /* _file := _file + LRTrim(arfn_agechar(_prvint,' '))+Space(2 - Len(LRTrim(_prvint))) */
          _file = _file+CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(_prvint," "))+CPLib.Space(2-CPLib.Len(CPLib.LRTrim(_prvint)));
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
          /* FileLibrary.Write(fhand,_file) */
          FileLibrary.Write(fhand,_file);
          /* FileLibrary.Close(fhand) */
          FileLibrary.Close(fhand);
          /* cProg := Utilities.GetAutonumber("PRGFILES\'"+LRTrim(gAzienda)+"'",'',10) */
          cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGFILES\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
          // * --- Insert into aefile_do_glob from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aefile_do_glob");
          m_cPhName = m_Ctx.GetPhName("aefile_do_glob");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"aefile_do_glob")+" (";
          m_cSql = m_cSql+GetFieldsName_077B8170(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_nomefile),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Invio "+CPLib.Right("0000"+CPLib.Str(CPLib.Year(w_a_data),4,0),4)+CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(CPLib.Month(w_a_data),2,0)),2)+" - Soggetti Italiani","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(w_mese,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(w_anno,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_nomefile,30),"?",0,0,m_cServer)+", ";
          if (m_Ctx.IsSharedTemp("aefile_do_glob")) {
            m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
          }
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aefile_do_glob",true);
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
        /* Cicla sul file per invii e prepara il file */
      }
      /* If _crow>0 and _crow<15000 */
      if (CPLib.gt(_crow,0) && CPLib.lt(_crow,15000)) {
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
        /* _file :=  '9CCB00' + '34' */
        _file = "9CCB00"+"34";
        /* _file := _file + LRTrim(_cfint)+Space(16 - Len(LRTrim(_cfint))) */
        _file = _file+CPLib.LRTrim(_cfint)+CPLib.Space(16-CPLib.Len(CPLib.LRTrim(_cfint)));
        /* _file := _file + Space(102) */
        _file = _file+CPLib.Space(102);
        /* _file := _file + LRTrim(arfn_agechar(_ragint,' '))+Space(70 - Len(LRTrim(_ragint))) */
        _file = _file+CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(_ragint," "))+CPLib.Space(70-CPLib.Len(CPLib.LRTrim(_ragint)));
        /* _file := _file + LRTrim(arfn_agechar(_citint,' '))+Space(40 - Len(LRTrim(_citint))) */
        _file = _file+CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(_citint," "))+CPLib.Space(40-CPLib.Len(CPLib.LRTrim(_citint)));
        /* _file := _file + LRTrim(arfn_agechar(_prvint,' '))+Space(2 - Len(LRTrim(_prvint))) */
        _file = _file+CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(_prvint," "))+CPLib.Space(2-CPLib.Len(CPLib.LRTrim(_prvint)));
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
        /* FileLibrary.Write(fhand,_file) */
        FileLibrary.Write(fhand,_file);
        /* FileLibrary.Close(fhand) */
        FileLibrary.Close(fhand);
        /* cProg := Utilities.GetAutonumber("PRGFILES\'"+LRTrim(gAzienda)+"'",'',10) */
        cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGFILES\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
        // * --- Insert into aefile_do_glob from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("aefile_do_glob");
        m_cPhName = m_Ctx.GetPhName("aefile_do_glob");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"aefile_do_glob")+" (";
        m_cSql = m_cSql+GetFieldsName_0768C918(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_nomefile),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Invio "+CPLib.Right("0000"+CPLib.Str(CPLib.Year(w_a_data),4,0),4)+CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(CPLib.Month(w_a_data),2,0)),2)+" - Soggetti Italiani","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(w_mese,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(w_anno,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_nomefile,30),"?",0,0,m_cServer)+", ";
        if (m_Ctx.IsSharedTemp("aefile_do_glob")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aefile_do_glob",true);
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
      /* countmp := 0 // Contatore delle occorenze inserite nel temporaneo */
      countmp = CPLib.Round(0,0);
      /* If _fileita > 0 */
      if (CPLib.gt(_fileita,0)) {
        /* _czip := '99'+Right(DateTimeToChar(DateTime()),12)+"_1.zip" */
        _czip = "99"+CPLib.Right(CPLib.DateTimeToChar(CPLib.DateTime()),12)+"_1.zip";
        /* cNomeFileZip := LRTrim(gPathApp)+'/flussi/'+LRTrim(gAzienda)+"/"+_czip */
        cNomeFileZip = CPLib.LRTrim(gPathApp)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+_czip;
        /* Exec "Crea file zip" Page 4:Page_4 */
        Page_4();
        /* cProg := Utilities.GetAutonumber("PRGFILES\'"+LRTrim(gAzienda)+"'",'',10) */
        cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGFILES\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
        // * --- Insert into aefiles_do from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("aefiles_do");
        m_cPhName = m_Ctx.GetPhName("aefiles_do");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"aefiles_do")+" (";
        m_cSql = m_cSql+GetFieldsName_07A6DC78(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_czip),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Invio "+CPLib.Right("0000"+CPLib.Str(CPLib.Year(w_a_data),4,0),4)+CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(CPLib.Month(w_a_data),2,0)),2)+" - Soggetti Italiani","?",0,0,m_cServer)+", ";
        if (m_Ctx.IsSharedTemp("aefiles_do")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aefiles_do",true);
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
      /* _nocodrec := 0 */
      _nocodrec = CPLib.Round(0,0);
      /* Stranieri */
      /* _estero := 'S' */
      _estero = "S";
      // * --- Select from qbe_invio_delope_ape_5
      if (Cursor_qbe_invio_delope_ape_5!=null)
        Cursor_qbe_invio_delope_ape_5.Close();
      Cursor_qbe_invio_delope_ape_5 = new VQRHolder("qbe_invio_delope_ape_5",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_invio_delope_ape_5.Eof())) {
        // * --- Select from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
        Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_invio_delope_ape_5.GetString("CONNESINT"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_personbo.Eof())) {
          /* _nocodrec := _nocodrec + 1 */
          _nocodrec = CPLib.Round(_nocodrec+1,0);
          /* _descit := '' */
          _descit = "";
          /* If not(Empty(personbo->COGNOME)) and not(Empty(personbo->NOME)) */
          if ( ! (CPLib.Empty(Cursor_personbo.GetString("COGNOME"))) &&  ! (CPLib.Empty(Cursor_personbo.GetString("NOME")))) {
            /* _cdata1 := Right(DateToChar(personbo->DATANASC),2)+Substr(DateToChar(personbo->DATANASC),5,2)+Left(DateToChar(personbo->DATANASC),4) */
            _cdata1 = CPLib.Right(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),4);
            /* _cdata2 := Right(DateToChar(qbe_invio_delope_ape_5->ADATA),2)+Substr(DateToChar(qbe_invio_delope_ape_5->ADATA),5,2)+Left(DateToChar(qbe_invio_delope_ape_5->ADATA),4) */
            _cdata2 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_invio_delope_ape_5.GetDate("ADATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_invio_delope_ape_5.GetDate("ADATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_invio_delope_ape_5.GetDate("ADATA")),4);
            /* _cdata3 := '' */
            _cdata3 = "";
            /* mcEsteriA.AppendBlank() */
            mcEsteriA.AppendBlank();
            /* mcEsteriA.TIPOREC := '4' */
            mcEsteriA.row.TIPOREC = "4";
            /* mcEsteriA.COGNOME := personbo->COGNOME */
            mcEsteriA.row.COGNOME = Cursor_personbo.GetString("COGNOME");
            /* mcEsteriA.NOME := personbo->NOME */
            mcEsteriA.row.NOME = Cursor_personbo.GetString("NOME");
            /* mcEsteriA.SESSO := iif(personbo->SESSO='F' or personbo->SESSO='2','F','M') */
            mcEsteriA.row.SESSO = (CPLib.eqr(Cursor_personbo.GetString("SESSO"),"F") || CPLib.eqr(Cursor_personbo.GetString("SESSO"),"2")?"F":"M");
            /* mcEsteriA.DATANASC := _cdata1 */
            mcEsteriA.row.DATANASC = _cdata1;
            /* mcEsteriA.COMSTA := personbo->NASSTATO */
            mcEsteriA.row.COMSTA = Cursor_personbo.GetString("NASSTATO");
            /* mcEsteriA.PROVNA := 'EE' */
            mcEsteriA.row.PROVNA = "EE";
            /* mcEsteriA.TIPORAP := qbe_invio_delope_ape_5->TIPOAG */
            mcEsteriA.row.TIPORAP = Cursor_qbe_invio_delope_ape_5.GetString("TIPOAG");
            /* mcEsteriA.COINT := qbe_invio_delope_ape_5->COINT */
            mcEsteriA.row.COINT = Cursor_qbe_invio_delope_ape_5.GetString("COINT");
            /* mcEsteriA.RAPPORTO := qbe_invio_delope_ape_5->RAPPORTO */
            mcEsteriA.row.RAPPORTO = Cursor_qbe_invio_delope_ape_5.GetString("RAPPORTO");
            /* mcEsteriA.DATAINI := _cdata2 */
            mcEsteriA.row.DATAINI = _cdata2;
            /* mcEsteriA.DATACHIU := _cdata3 */
            mcEsteriA.row.DATACHIU = _cdata3;
            /* mcEsteriA.IDBASE := qbe_invio_delope_ape_5->IDBASE */
            mcEsteriA.row.IDBASE = Cursor_qbe_invio_delope_ape_5.GetString("IDBASE");
            /* mcEsteriA.progae := _nocodrec */
            mcEsteriA.row.progae = _nocodrec;
            /* mcEsteriA.SaveRow() */
            mcEsteriA.SaveRow();
          } else { // Else
            /* If not(Empty(personbo->PAESE)) */
            if ( ! (CPLib.Empty(Cursor_personbo.GetString("PAESE")))) {
              // * --- Read from tbstati
              m_cServer = m_Ctx.GetServer("tbstati");
              m_cPhName = m_Ctx.GetPhName("tbstati");
              m_cSql = "";
              m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer),m_cServer,Cursor_personbo.GetString("PAESE"));
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
                  Error l_oErrorFault = new Error("Read on tbstati into routine arrt_sd_aprichiudi_delope returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _descit = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* _descit := iif(not(Empty(_descit)),_descit,personbo->DESCCIT) */
              _descit = ( ! (CPLib.Empty(_descit))?_descit:Cursor_personbo.GetString("DESCCIT"));
            } else { // Else
              /* _descit := personbo->DESCCIT */
              _descit = Cursor_personbo.GetString("DESCCIT");
            } // End If
            /* _cdata2 := Right(DateToChar(qbe_invio_delope_ape_5->ADATA),2)+Substr(DateToChar(qbe_invio_delope_ape_5->ADATA),5,2)+Left(DateToChar(qbe_invio_delope_ape_5->ADATA),4) */
            _cdata2 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_invio_delope_ape_5.GetDate("ADATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_invio_delope_ape_5.GetDate("ADATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_invio_delope_ape_5.GetDate("ADATA")),4);
            /* _cdata3 := '' */
            _cdata3 = "";
            /* mcEsteriA.AppendBlank() */
            mcEsteriA.AppendBlank();
            /* mcEsteriA.TIPOREC := '4' */
            mcEsteriA.row.TIPOREC = "4";
            /* mcEsteriA.DENOM := Left(personbo->RAGSOC,60) */
            mcEsteriA.row.DENOM = CPLib.Left(Cursor_personbo.GetString("RAGSOC"),60);
            /* mcEsteriA.COMSEDE := _descit */
            mcEsteriA.row.COMSEDE = _descit;
            /* mcEsteriA.PROVSED := iif(Empty(personbo->PROVINCIA),'EE',personbo->PROVINCIA) */
            mcEsteriA.row.PROVSED = (CPLib.Empty(Cursor_personbo.GetString("PROVINCIA"))?"EE":Cursor_personbo.GetString("PROVINCIA"));
            /* mcEsteriA.TIPORAP := qbe_invio_delope_ape_5->TIPOAG */
            mcEsteriA.row.TIPORAP = Cursor_qbe_invio_delope_ape_5.GetString("TIPOAG");
            /* mcEsteriA.COINT := qbe_invio_delope_ape_5->COINT */
            mcEsteriA.row.COINT = Cursor_qbe_invio_delope_ape_5.GetString("COINT");
            /* mcEsteriA.RAPPORTO := qbe_invio_delope_ape_5->RAPPORTO */
            mcEsteriA.row.RAPPORTO = Cursor_qbe_invio_delope_ape_5.GetString("RAPPORTO");
            /* mcEsteriA.DATAINI := _cdata2 */
            mcEsteriA.row.DATAINI = _cdata2;
            /* mcEsteriA.DATACHIU := _cdata3 */
            mcEsteriA.row.DATACHIU = _cdata3;
            /* mcEsteriA.IDBASE := qbe_invio_delope_ape_5->IDBASE */
            mcEsteriA.row.IDBASE = Cursor_qbe_invio_delope_ape_5.GetString("IDBASE");
            /* mcEsteriA.progae := _nocodrec */
            mcEsteriA.row.progae = _nocodrec;
            /* mcEsteriA.SaveRow() */
            mcEsteriA.SaveRow();
          } // End If
          Cursor_personbo.Next();
        }
        m_cConnectivityError = Cursor_personbo.ErrorMessage();
        Cursor_personbo.Close();
        // * --- End Select
        Cursor_qbe_invio_delope_ape_5.Next();
      }
      m_cConnectivityError = Cursor_qbe_invio_delope_ape_5.ErrorMessage();
      Cursor_qbe_invio_delope_ape_5.Close();
      // * --- End Select
      // * --- Select from qbe_invio_delope_ape_6_max_min_glob
      if (Cursor_qbe_invio_delope_ape_6_max_min_glob!=null)
        Cursor_qbe_invio_delope_ape_6_max_min_glob.Close();
      Cursor_qbe_invio_delope_ape_6_max_min_glob = new VQRHolder("qbe_invio_delope_ape_6_max_min_glob",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_invio_delope_ape_6_max_min_glob.Eof())) {
        /* _min := qbe_invio_delope_ape_6_max_min_glob->MINPROGOPX */
        _min = CPLib.Round(Cursor_qbe_invio_delope_ape_6_max_min_glob.GetDouble("MINPROGOPX"),0);
        /* _max := qbe_invio_delope_ape_6_max_min_glob->MAXPROGOPX */
        _max = CPLib.Round(Cursor_qbe_invio_delope_ape_6_max_min_glob.GetDouble("MAXPROGOPX"),0);
        /* _tot := qbe_invio_delope_ape_6_max_min_glob->TOTPROGOPX */
        _tot = CPLib.Round(Cursor_qbe_invio_delope_ape_6_max_min_glob.GetDouble("TOTPROGOPX"),0);
        Cursor_qbe_invio_delope_ape_6_max_min_glob.Next();
      }
      m_cConnectivityError = Cursor_qbe_invio_delope_ape_6_max_min_glob.ErrorMessage();
      Cursor_qbe_invio_delope_ape_6_max_min_glob.Close();
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
        /* gMsgImp := 'Lettura informazioni in corso ... Ciclo N. '+LRTrim(Str(_contacilci,10,0)) // Messaggio Import */
        gMsgImp = "Lettura informazioni in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacilci,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If _top>=_min */
        if (CPLib.ge(_top,_min)) {
          // * --- Select from qbe_invio_delope_ape_6_globale
          if (Cursor_qbe_invio_delope_ape_6_globale!=null)
            Cursor_qbe_invio_delope_ape_6_globale.Close();
          Cursor_qbe_invio_delope_ape_6_globale = new VQRHolder("qbe_invio_delope_ape_6_globale",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_invio_delope_ape_6_globale.Eof())) {
            /* _nocodrec := _nocodrec + 1 */
            _nocodrec = CPLib.Round(_nocodrec+1,0);
            /* gMsgImp := "Elaborazione soggetti senza CF italiano. Sto elaborando l'informazione N° " + LRTrim(Str(_nocodrec+_sicodrec,10,0)) // Messaggio allineamento 1 */
            gMsgImp = "Elaborazione soggetti senza CF italiano. Sto elaborando l'informazione N° "+CPLib.LRTrim(CPLib.Str(_nocodrec+_sicodrec,10,0));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* _descit := '' */
            _descit = "";
            /* If not(Empty(qbe_invio_delope_ape_6_globale->COGNOME)) and not(Empty(qbe_invio_delope_ape_6_globale->NOME)) and not(Empty(qbe_invio_delope_ape_6_globale->SESSO)) */
            if ( ! (CPLib.Empty(Cursor_qbe_invio_delope_ape_6_globale.GetString("COGNOME"))) &&  ! (CPLib.Empty(Cursor_qbe_invio_delope_ape_6_globale.GetString("NOME"))) &&  ! (CPLib.Empty(Cursor_qbe_invio_delope_ape_6_globale.GetString("SESSO")))) {
              /* _cdata1 := Right(DateToChar(qbe_invio_delope_ape_6_globale->DATANASC),2)+Substr(DateToChar(qbe_invio_delope_ape_6_globale->DATANASC),5,2)+Left(DateToChar(qbe_invio_delope_ape_6_globale->DATANASC),4) */
              _cdata1 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_invio_delope_ape_6_globale.GetDate("DATANASC")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_invio_delope_ape_6_globale.GetDate("DATANASC")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_invio_delope_ape_6_globale.GetDate("DATANASC")),4);
              /* _cdata2 := Right(DateToChar(qbe_invio_delope_ape_6_globale->ADATA),2)+Substr(DateToChar(qbe_invio_delope_ape_6_globale->ADATA),5,2)+Left(DateToChar(qbe_invio_delope_ape_6_globale->ADATA),4) */
              _cdata2 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_invio_delope_ape_6_globale.GetDate("ADATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_invio_delope_ape_6_globale.GetDate("ADATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_invio_delope_ape_6_globale.GetDate("ADATA")),4);
              /* _cdata3 := '' */
              _cdata3 = "";
              /* mcEsteriA.AppendBlank() */
              mcEsteriA.AppendBlank();
              /* mcEsteriA.TIPOREC := '4' */
              mcEsteriA.row.TIPOREC = "4";
              /* mcEsteriA.COGNOME := qbe_invio_delope_ape_6_globale->COGNOME */
              mcEsteriA.row.COGNOME = Cursor_qbe_invio_delope_ape_6_globale.GetString("COGNOME");
              /* mcEsteriA.NOME := qbe_invio_delope_ape_6_globale->NOME */
              mcEsteriA.row.NOME = Cursor_qbe_invio_delope_ape_6_globale.GetString("NOME");
              /* mcEsteriA.SESSO := iif(qbe_invio_delope_ape_6_globale->SESSO='F' or qbe_invio_delope_ape_6_globale->SESSO='2','F','M') */
              mcEsteriA.row.SESSO = (CPLib.eqr(Cursor_qbe_invio_delope_ape_6_globale.GetString("SESSO"),"F") || CPLib.eqr(Cursor_qbe_invio_delope_ape_6_globale.GetString("SESSO"),"2")?"F":"M");
              /* mcEsteriA.DATANASC := _cdata1 */
              mcEsteriA.row.DATANASC = _cdata1;
              /* mcEsteriA.COMSTA := iif(Empty(qbe_invio_delope_ape_6_globale->NASSTATO),qbe_invio_delope_ape_6_globale->NASCOMUN,qbe_invio_delope_ape_6_globale->NASSTATO) */
              mcEsteriA.row.COMSTA = (CPLib.Empty(Cursor_qbe_invio_delope_ape_6_globale.GetString("NASSTATO"))?Cursor_qbe_invio_delope_ape_6_globale.GetString("NASCOMUN"):Cursor_qbe_invio_delope_ape_6_globale.GetString("NASSTATO"));
              /* mcEsteriA.PROVNA := 'EE' */
              mcEsteriA.row.PROVNA = "EE";
              /* mcEsteriA.TIPORAP := qbe_invio_delope_ape_6_globale->TIPOAG */
              mcEsteriA.row.TIPORAP = Cursor_qbe_invio_delope_ape_6_globale.GetString("TIPOAG");
              /* mcEsteriA.COINT := qbe_invio_delope_ape_6_globale->COINT */
              mcEsteriA.row.COINT = Cursor_qbe_invio_delope_ape_6_globale.GetString("COINT");
              /* mcEsteriA.RAPPORTO := qbe_invio_delope_ape_6_globale->RAPPORTO */
              mcEsteriA.row.RAPPORTO = Cursor_qbe_invio_delope_ape_6_globale.GetString("RAPPORTO");
              /* mcEsteriA.DATAINI := _cdata2 */
              mcEsteriA.row.DATAINI = _cdata2;
              /* mcEsteriA.DATACHIU := _cdata3 */
              mcEsteriA.row.DATACHIU = _cdata3;
              /* mcEsteriA.IDBASE := qbe_invio_delope_ape_6_globale->IDBASE */
              mcEsteriA.row.IDBASE = Cursor_qbe_invio_delope_ape_6_globale.GetString("IDBASE");
              /* mcEsteriA.progae := _nocodrec */
              mcEsteriA.row.progae = _nocodrec;
              /* mcEsteriA.SaveRow() */
              mcEsteriA.SaveRow();
            } else { // Else
              /* If not(Empty(qbe_invio_delope_ape_6_globale->PAESE)) */
              if ( ! (CPLib.Empty(Cursor_qbe_invio_delope_ape_6_globale.GetString("PAESE")))) {
                // * --- Read from tbstati
                m_cServer = m_Ctx.GetServer("tbstati");
                m_cPhName = m_Ctx.GetPhName("tbstati");
                m_cSql = "";
                m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_invio_delope_ape_6_globale.GetString("PAESE"),"C",3,0,m_cServer),m_cServer,Cursor_qbe_invio_delope_ape_6_globale.GetString("PAESE"));
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
                    Error l_oErrorFault = new Error("Read on tbstati into routine arrt_sd_aprichiudi_delope returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _descit = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* _descit := iif(not(Empty(_descit)),_descit,qbe_invio_delope_ape_6_globale->DESCCIT) */
                _descit = ( ! (CPLib.Empty(_descit))?_descit:Cursor_qbe_invio_delope_ape_6_globale.GetString("DESCCIT"));
              } else { // Else
                /* _descit := qbe_invio_delope_ape_6_globale->DESCCIT */
                _descit = Cursor_qbe_invio_delope_ape_6_globale.GetString("DESCCIT");
              } // End If
              /* _cdata2 := Right(DateToChar(qbe_invio_delope_ape_6_globale->ADATA),2)+Substr(DateToChar(qbe_invio_delope_ape_6_globale->ADATA),5,2)+Left(DateToChar(qbe_invio_delope_ape_6_globale->ADATA),4) */
              _cdata2 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_invio_delope_ape_6_globale.GetDate("ADATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_invio_delope_ape_6_globale.GetDate("ADATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_invio_delope_ape_6_globale.GetDate("ADATA")),4);
              /* _cdata3 := '' */
              _cdata3 = "";
              /* mcEsteriA.AppendBlank() */
              mcEsteriA.AppendBlank();
              /* mcEsteriA.TIPOREC := '4' */
              mcEsteriA.row.TIPOREC = "4";
              /* mcEsteriA.DENOM := Left(qbe_invio_delope_ape_6_globale->RAGSOC,60) */
              mcEsteriA.row.DENOM = CPLib.Left(Cursor_qbe_invio_delope_ape_6_globale.GetString("RAGSOC"),60);
              /* mcEsteriA.COMSEDE := _descit */
              mcEsteriA.row.COMSEDE = _descit;
              /* mcEsteriA.PROVSED := iif(Empty(qbe_invio_delope_ape_6_globale->PROVINCIA),'EE',qbe_invio_delope_ape_6_globale->PROVINCIA) */
              mcEsteriA.row.PROVSED = (CPLib.Empty(Cursor_qbe_invio_delope_ape_6_globale.GetString("PROVINCIA"))?"EE":Cursor_qbe_invio_delope_ape_6_globale.GetString("PROVINCIA"));
              /* mcEsteriA.TIPORAP := qbe_invio_delope_ape_6_globale->TIPOAG */
              mcEsteriA.row.TIPORAP = Cursor_qbe_invio_delope_ape_6_globale.GetString("TIPOAG");
              /* mcEsteriA.COINT := qbe_invio_delope_ape_6_globale->COINT */
              mcEsteriA.row.COINT = Cursor_qbe_invio_delope_ape_6_globale.GetString("COINT");
              /* mcEsteriA.RAPPORTO := qbe_invio_delope_ape_6_globale->RAPPORTO */
              mcEsteriA.row.RAPPORTO = Cursor_qbe_invio_delope_ape_6_globale.GetString("RAPPORTO");
              /* mcEsteriA.DATAINI := _cdata2 */
              mcEsteriA.row.DATAINI = _cdata2;
              /* mcEsteriA.DATACHIU := _cdata3 */
              mcEsteriA.row.DATACHIU = _cdata3;
              /* mcEsteriA.IDBASE := qbe_invio_delope_ape_6_globale->IDBASE */
              mcEsteriA.row.IDBASE = Cursor_qbe_invio_delope_ape_6_globale.GetString("IDBASE");
              /* mcEsteriA.progae := _nocodrec */
              mcEsteriA.row.progae = _nocodrec;
              /* mcEsteriA.SaveRow() */
              mcEsteriA.SaveRow();
            } // End If
            /* countmp := countmp+1 // Contatore delle occorenze inserite nel temporaneo */
            countmp = CPLib.Round(countmp+1,0);
            Cursor_qbe_invio_delope_ape_6_globale.Next();
          }
          m_cConnectivityError = Cursor_qbe_invio_delope_ape_6_globale.ErrorMessage();
          Cursor_qbe_invio_delope_ape_6_globale.Close();
          // * --- End Select
        } else { // Else
          /* gMsgImp := 'Lettura informazioni in corso ...' // Messaggio Import */
          gMsgImp = "Lettura informazioni in corso ...";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } // End If
        /* _contacilci := _contacilci+1 */
        _contacilci = CPLib.Round(_contacilci+1,0);
      } // End While
      /* _i := 1 */
      _i = CPLib.Round(1,0);
      /* _crow := 0 */
      _crow = CPLib.Round(0,0);
      /* _cfile := 0 */
      _cfile = CPLib.Round(0,0);
      /* _conta := 1 */
      _conta = CPLib.Round(1,0);
      for (MemoryCursorRow_tmp_apenocod rowEsteriA : mcEsteriA._iterable_()) {
        /* If _crow = 0 and _i=1 */
        if (CPLib.eqr(_crow,0) && CPLib.eqr(_i,1)) {
          /* Crea Record di testa */
          /* _nomefile := '99'+Right(DateTimeToChar(DateTime()),12)+'4' */
          _nomefile = "99"+CPLib.Right(CPLib.DateTimeToChar(CPLib.DateTime()),12)+"4";
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
          /* _fileest := _fileest + 1 */
          _fileest = CPLib.Round(_fileest+1,0);
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
          /* _crow := 1 */
          _crow = CPLib.Round(1,0);
        } // End If
        /* gMsgImp := 'Elaborazione soggetti senza CF italiano. Sto scrivendo il file ' + LRTrim(cOnlyNomeFile)+ ' - Riga N° '+ LRTrim(Str(_crow,10,0)) // Messaggio Import */
        gMsgImp = "Elaborazione soggetti senza CF italiano. Sto scrivendo il file "+CPLib.LRTrim(cOnlyNomeFile)+" - Riga N° "+CPLib.LRTrim(CPLib.Str(_crow,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _r := _r + 1 */
        _r = CPLib.Round(_r+1,0);
        /* If _i = 1 */
        if (CPLib.eqr(_i,1)) {
          /* _file := rowEsteriA.TIPOREC */
          _file = rowEsteriA.TIPOREC;
        } // End If
        // * --- Insert into tmp_stpfileage from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_stpfileage");
        m_cPhName = m_Ctx.GetPhName("tmp_stpfileage");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_stpfileage")+" (";
        m_cSql = m_cSql+GetFieldsName_05FCA348(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("4","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowEsteriA.RAPPORTO,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(CPLib.Str(_r)),25),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(rowEsteriA.SESSO)?rowEsteriA.DENOM:CPLib.LRTrim(rowEsteriA.COGNOME)+" "+CPLib.LRTrim(rowEsteriA.NOME)),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowEsteriA.DATAINI,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowEsteriA.DATACHIU,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowEsteriA.COINT,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rowEsteriA.TIPORAP,"?",0,0,m_cServer)+", ";
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
        /* _file := _file + Left(LRTrim(arfn_agechar(rowEsteriA.COGNOME,' ')) + Space(26),26) */
        _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowEsteriA.COGNOME," "))+CPLib.Space(26),26);
        /* _file := _file + Left(LRTrim(arfn_agechar(rowEsteriA.NOME,' ')) + Space(25),25) */
        _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowEsteriA.NOME," "))+CPLib.Space(25),25);
        /* _file := _file + Left(LRTrim(arfn_agechar(rowEsteriA.SESSO,' '))+Space(1),1) */
        _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowEsteriA.SESSO," "))+CPLib.Space(1),1);
        /* _file := _file + Left(LRTrim(rowEsteriA.DATANASC) + Space(8),8) */
        _file = _file+CPLib.Left(CPLib.LRTrim(rowEsteriA.DATANASC)+CPLib.Space(8),8);
        /* _file := _file + Left(LRTrim(arfn_agechar(rowEsteriA.COMSTA,' ')) + Space(40),40) */
        _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowEsteriA.COMSTA," "))+CPLib.Space(40),40);
        /* _file := _file + Left(LRTrim(arfn_agechar(rowEsteriA.PROVNA,' ')) + Space(2),2) */
        _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowEsteriA.PROVNA," "))+CPLib.Space(2),2);
        /* _file := _file + Left(LRTrim(arfn_agechar(rowEsteriA.DENOM,' ')) + Space(60),60) */
        _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowEsteriA.DENOM," "))+CPLib.Space(60),60);
        /* _file := _file + Left(LRTrim(arfn_agechar(rowEsteriA.COMSEDE,' ')) + Space(40),40) */
        _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowEsteriA.COMSEDE," "))+CPLib.Space(40),40);
        /* _file := _file + Left(LRTrim(arfn_agechar(rowEsteriA.PROVSED,' ')) + Space(2),2) */
        _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowEsteriA.PROVSED," "))+CPLib.Space(2),2);
        /* _file := _file + Left(LRTrim(rowEsteriA.TIPORAP) + Space(2),2) */
        _file = _file+CPLib.Left(CPLib.LRTrim(rowEsteriA.TIPORAP)+CPLib.Space(2),2);
        /* _file := _file + Left(LRTrim(rowEsteriA.COINT) + Space(1),1) */
        _file = _file+CPLib.Left(CPLib.LRTrim(rowEsteriA.COINT)+CPLib.Space(1),1);
        /* _file := _file + Left(LRTrim(rowEsteriA.DATAINI) + Space(8),8) */
        _file = _file+CPLib.Left(CPLib.LRTrim(rowEsteriA.DATAINI)+CPLib.Space(8),8);
        /* If not(Empty(rowEsteriA.DATACHIU)) and CharToDate(rowEsteriA.DATACHIU) >= w_dadata and CharToDate(rowEsteriA.DATACHIU) <= w_a_data */
        if ( ! (CPLib.Empty(rowEsteriA.DATACHIU)) && CPLib.ge(CPLib.CharToDate(rowEsteriA.DATACHIU),w_dadata) && CPLib.le(CPLib.CharToDate(rowEsteriA.DATACHIU),w_a_data)) {
          /* _file := _file + Left(LRTrim(rowEsteriA.DATACHIU) + Space(8),8) */
          _file = _file+CPLib.Left(CPLib.LRTrim(rowEsteriA.DATACHIU)+CPLib.Space(8),8);
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
        /* If rowEsteriA.TIPORAP='98' */
        if (CPLib.eqr(rowEsteriA.TIPORAP,"98")) {
          // * --- Write into aeoprig from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aeoprig");
          m_cPhName = m_Ctx.GetPhName("aeoprig");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = "Update "+m_cPhName+" set ";
          m_cSql = m_cSql+"ASPEDITO = "+CPLib.ToSQL(1,"N",1,0)+", ";
          m_cSql = m_cSql+"APROG = "+CPLib.ToSQL(_r,"C",25,0,m_cServer)+", ";
          m_cSql = m_cSql+"AFILE = "+CPLib.ToSQL(_nomefile,"C",15,0,m_cServer)+", ";
          m_cSql = m_cSql+"ADTPRE = "+CPLib.ToSQL(w_a_data,"D",8,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aeoprig",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowEsteriA.IDBASE,"?",0,0,m_cServer),m_cServer,rowEsteriA.IDBASE)+"";
          if (m_Ctx.IsSharedTemp("aeoprig")) {
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
          // * --- Write into aederig from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aederig");
          m_cPhName = m_Ctx.GetPhName("aederig");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = "Update "+m_cPhName+" set ";
          m_cSql = m_cSql+"ASPEDITO = "+CPLib.ToSQL(1,"N",1,0)+", ";
          m_cSql = m_cSql+"APROG = "+CPLib.ToSQL(_r,"C",25,0,m_cServer)+", ";
          m_cSql = m_cSql+"AFILE = "+CPLib.ToSQL(_nomefile,"C",15,0,m_cServer)+", ";
          m_cSql = m_cSql+"ADTPRE = "+CPLib.ToSQL(w_a_data,"D",8,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aederig",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowEsteriA.IDBASE,"?",0,0,m_cServer),m_cServer,rowEsteriA.IDBASE)+"";
          if (m_Ctx.IsSharedTemp("aederig")) {
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
          /* If not(Empty(rowEsteriA.DATACHIU)) and CharToDate(rowEsteriA.DATACHIU) >= w_dadata and CharToDate(rowEsteriA.DATACHIU) <= w_a_data */
          if ( ! (CPLib.Empty(rowEsteriA.DATACHIU)) && CPLib.ge(CPLib.CharToDate(rowEsteriA.DATACHIU),w_dadata) && CPLib.le(CPLib.CharToDate(rowEsteriA.DATACHIU),w_a_data)) {
            // * --- Write into aederig from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("aederig");
            m_cPhName = m_Ctx.GetPhName("aederig");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = "Update "+m_cPhName+" set ";
            m_cSql = m_cSql+"CSPEDITO = "+CPLib.ToSQL(1,"N",1,0)+", ";
            m_cSql = m_cSql+"CPROG = "+CPLib.ToSQL(_r,"C",25,0,m_cServer)+", ";
            m_cSql = m_cSql+"CFILE = "+CPLib.ToSQL(_nomefile,"C",15,0,m_cServer)+", ";
            m_cSql = m_cSql+"CDTPRE = "+CPLib.ToSQL(w_a_data,"D",8,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aederig",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowEsteriA.IDBASE,"?",0,0,m_cServer),m_cServer,rowEsteriA.IDBASE)+"";
            if (m_Ctx.IsSharedTemp("aederig")) {
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
          /* _file := _file + LRTrim(arfn_agechar(_ragint,' '))+Space(70 - Len(LRTrim(_ragint))) */
          _file = _file+CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(_ragint," "))+CPLib.Space(70-CPLib.Len(CPLib.LRTrim(_ragint)));
          /* _file := _file + LRTrim(arfn_agechar(_citint,' '))+Space(40 - Len(LRTrim(_citint))) */
          _file = _file+CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(_citint," "))+CPLib.Space(40-CPLib.Len(CPLib.LRTrim(_citint)));
          /* _file := _file + LRTrim(arfn_agechar(_prvint,' '))+Space(2 - Len(LRTrim(_prvint))) */
          _file = _file+CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(_prvint," "))+CPLib.Space(2-CPLib.Len(CPLib.LRTrim(_prvint)));
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
          /* FileLibrary.Write(fhand,_file) */
          FileLibrary.Write(fhand,_file);
          /* FileLibrary.Close(fhand) */
          FileLibrary.Close(fhand);
          /* cProg := Utilities.GetAutonumber("PRGFILES\'"+LRTrim(gAzienda)+"'",'',10) */
          cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGFILES\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
          // * --- Insert into aefile_do_glob from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aefile_do_glob");
          m_cPhName = m_Ctx.GetPhName("aefile_do_glob");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"aefile_do_glob")+" (";
          m_cSql = m_cSql+GetFieldsName_061AB648(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_nomefile),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Invio "+CPLib.Right("0000"+CPLib.Str(CPLib.Year(w_a_data),4,0),4)+CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(CPLib.Month(w_a_data),2,0)),2)+" - Soggetti Esteri","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(w_mese,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(w_anno,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_nomefile,30),"?",0,0,m_cServer)+", ";
          if (m_Ctx.IsSharedTemp("aefile_do_glob")) {
            m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
          }
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aefile_do_glob",true);
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
      }
      /* If _crow>0 and _crow<15000 */
      if (CPLib.gt(_crow,0) && CPLib.lt(_crow,15000)) {
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
        /* _file := _file + LRTrim(arfn_agechar(_ragint,' '))+Space(70 - Len(LRTrim(_ragint))) */
        _file = _file+CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(_ragint," "))+CPLib.Space(70-CPLib.Len(CPLib.LRTrim(_ragint)));
        /* _file := _file + LRTrim(arfn_agechar(_citint,' '))+Space(40 - Len(LRTrim(_citint))) */
        _file = _file+CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(_citint," "))+CPLib.Space(40-CPLib.Len(CPLib.LRTrim(_citint)));
        /* _file := _file + LRTrim(arfn_agechar(_prvint,' '))+Space(2 - Len(LRTrim(_prvint))) */
        _file = _file+CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(_prvint," "))+CPLib.Space(2-CPLib.Len(CPLib.LRTrim(_prvint)));
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
        /* FileLibrary.Write(fhand,_file) */
        FileLibrary.Write(fhand,_file);
        /* FileLibrary.Close(fhand) */
        FileLibrary.Close(fhand);
        /* cProg := Utilities.GetAutonumber("PRGFILES\'"+LRTrim(gAzienda)+"'",'',10) */
        cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGFILES\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
        // * --- Insert into aefile_do_glob from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("aefile_do_glob");
        m_cPhName = m_Ctx.GetPhName("aefile_do_glob");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"aefile_do_glob")+" (";
        m_cSql = m_cSql+GetFieldsName_05D02140(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_nomefile),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Invio "+CPLib.Right("0000"+CPLib.Str(CPLib.Year(w_a_data),4,0),4)+CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(CPLib.Month(w_a_data),2,0)),2)+" - Soggetti Esteri","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(w_mese,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(w_anno,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_nomefile,30),"?",0,0,m_cServer)+", ";
        if (m_Ctx.IsSharedTemp("aefile_do_glob")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aefile_do_glob",true);
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
      /* countmp := 0 // Contatore delle occorenze inserite nel temporaneo */
      countmp = CPLib.Round(0,0);
      /* If _fileest > 0 */
      if (CPLib.gt(_fileest,0)) {
        /* _czip := '99'+Right(DateTimeToChar(DateTime()),12)+"_4.zip" */
        _czip = "99"+CPLib.Right(CPLib.DateTimeToChar(CPLib.DateTime()),12)+"_4.zip";
        /* cNomeFileZip := LRTrim(gPathApp)+'/flussi/'+LRTrim(gAzienda)+"/"+_czip */
        cNomeFileZip = CPLib.LRTrim(gPathApp)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+_czip;
        /* Exec "Crea file zip" Page 4:Page_4 */
        Page_4();
        /* cProg := Utilities.GetAutonumber("PRGFILES\'"+LRTrim(gAzienda)+"'",'',10) */
        cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGFILES\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
        // * --- Insert into aefiles_do from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("aefiles_do");
        m_cPhName = m_Ctx.GetPhName("aefiles_do");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.InsertIntoStatement(m_Ctx,"aefiles_do")+" (";
        m_cSql = m_cSql+GetFieldsName_077D2FC0(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_czip),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Invio "+CPLib.Right("0000"+CPLib.Str(CPLib.Year(w_a_data),4,0),4)+CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(CPLib.Month(w_a_data),2,0)),2)+" - Soggetti Esteri","?",0,0,m_cServer)+", ";
        if (m_Ctx.IsSharedTemp("aefiles_do")) {
          m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
        }
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aefiles_do",true);
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
      } // End If
    } finally {
      try {
        if (Cursor_qbe_invio_delope_ape_5!=null)
          Cursor_qbe_invio_delope_ape_5.Close();
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
        if (Cursor_qbe_invio_delope_ape_6_max_min_glob!=null)
          Cursor_qbe_invio_delope_ape_6_max_min_glob.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_invio_delope_ape_6_globale!=null)
          Cursor_qbe_invio_delope_ape_6_globale.Close();
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
    }
  }
  void Page_3() throws Exception {
    CPResultSet Cursor_qbe_invio_delope_chi_2=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Read_Cursor=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Invii Periodici */
      /* _nocodrec := 0 */
      _nocodrec = CPLib.Round(0,0);
      /* _sicodrec := 0 */
      _sicodrec = CPLib.Round(0,0);
      // * --- Select from qbe_invio_delope_chi_2
      if (Cursor_qbe_invio_delope_chi_2!=null)
        Cursor_qbe_invio_delope_chi_2.Close();
      Cursor_qbe_invio_delope_chi_2 = new VQRHolder("qbe_invio_delope_chi_2",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_invio_delope_chi_2.Eof())) {
        // * --- Select from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
        Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_2.GetString("CONNESINT"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_personbo.Eof())) {
          /* gMsgImp := 'Lettura dati anagrafici di : '+ Left(LRTrim(personbo->COGNOME) + Space(26),26) // Messaggio Import */
          gMsgImp = "Lettura dati anagrafici di : "+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("COGNOME"))+CPLib.Space(26),26);
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* If personbo->CFESTERO=1 */
          if (CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),1)) {
            /* _descit := '' */
            _descit = "";
            /* If not(Empty(personbo->COGNOME)) and not(Empty(personbo->NOME)) and not(Empty(personbo->SESSO)) */
            if ( ! (CPLib.Empty(Cursor_personbo.GetString("COGNOME"))) &&  ! (CPLib.Empty(Cursor_personbo.GetString("NOME"))) &&  ! (CPLib.Empty(Cursor_personbo.GetString("SESSO")))) {
              /* _cdata1 := Right(DateToChar(personbo->DATANASC),2)+Substr(DateToChar(personbo->DATANASC),5,2)+Left(DateToChar(personbo->DATANASC),4) */
              _cdata1 = CPLib.Right(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),4);
              /* _cdata2 := Right(DateToChar(qbe_invio_delope_chi_2->ADATA),2)+Substr(DateToChar(qbe_invio_delope_chi_2->ADATA),5,2)+Left(DateToChar(qbe_invio_delope_chi_2->ADATA),4) */
              _cdata2 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("ADATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("ADATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("ADATA")),4);
              /* _cdata3 := Right(DateToChar(qbe_invio_delope_chi_2->CDATA),2)+Substr(DateToChar(qbe_invio_delope_chi_2->CDATA),5,2)+Left(DateToChar(qbe_invio_delope_chi_2->CDATA),4) */
              _cdata3 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("CDATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("CDATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("CDATA")),4);
              /* mcEsteriC.AppendBlank() */
              mcEsteriC.AppendBlank();
              /* mcEsteriC.TIPOREC := '5' */
              mcEsteriC.row.TIPOREC = "5";
              /* mcEsteriC.COGNOME := personbo->COGNOME */
              mcEsteriC.row.COGNOME = Cursor_personbo.GetString("COGNOME");
              /* mcEsteriC.NOME := personbo->NOME */
              mcEsteriC.row.NOME = Cursor_personbo.GetString("NOME");
              /* mcEsteriC.SESSO := iif(personbo->SESSO='F' or personbo->SESSO='2','F','M') */
              mcEsteriC.row.SESSO = (CPLib.eqr(Cursor_personbo.GetString("SESSO"),"F") || CPLib.eqr(Cursor_personbo.GetString("SESSO"),"2")?"F":"M");
              /* mcEsteriC.DATANASC := _cdata1 */
              mcEsteriC.row.DATANASC = _cdata1;
              /* mcEsteriC.COMSTA := personbo->NASSTATO */
              mcEsteriC.row.COMSTA = Cursor_personbo.GetString("NASSTATO");
              /* mcEsteriC.PROVNA := 'EE' */
              mcEsteriC.row.PROVNA = "EE";
              /* mcEsteriC.TIPORAP := qbe_invio_delope_chi_2->TIPOAG */
              mcEsteriC.row.TIPORAP = Cursor_qbe_invio_delope_chi_2.GetString("TIPOAG");
              /* mcEsteriC.COINT := qbe_invio_delope_chi_2->COINT */
              mcEsteriC.row.COINT = Cursor_qbe_invio_delope_chi_2.GetString("COINT");
              /* mcEsteriC.RAPPORTO := qbe_invio_delope_chi_2->RAPPORTO */
              mcEsteriC.row.RAPPORTO = Cursor_qbe_invio_delope_chi_2.GetString("RAPPORTO");
              /* mcEsteriC.DATAINI := _cdata2 */
              mcEsteriC.row.DATAINI = _cdata2;
              /* mcEsteriC.DATACHIU := _cdata3 */
              mcEsteriC.row.DATACHIU = _cdata3;
              /* mcEsteriC.IDBASE := qbe_invio_delope_chi_2->IDBASE */
              mcEsteriC.row.IDBASE = Cursor_qbe_invio_delope_chi_2.GetString("IDBASE");
              /* mcEsteriC.PROGRIF := qbe_invio_delope_chi_2->APROG */
              mcEsteriC.row.PROGRIF = Cursor_qbe_invio_delope_chi_2.GetString("APROG");
              /* mcEsteriC.IDFILE := qbe_invio_delope_chi_2->AFILE */
              mcEsteriC.row.IDFILE = Cursor_qbe_invio_delope_chi_2.GetString("AFILE");
              /* mcEsteriC.CODINTER := iif(Empty(LRTrim(qbe_invio_delope_chi_2->OLDINTER)),_cfint,qbe_invio_delope_chi_2->OLDINTER) */
              mcEsteriC.row.CODINTER = (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_invio_delope_chi_2.GetString("OLDINTER")))?_cfint:Cursor_qbe_invio_delope_chi_2.GetString("OLDINTER"));
              /* mcEsteriC.SaveRow() */
              mcEsteriC.SaveRow();
            } else { // Else
              /* If not(Empty(personbo->PAESE)) */
              if ( ! (CPLib.Empty(Cursor_personbo.GetString("PAESE")))) {
                // * --- Read from tbstati
                m_cServer = m_Ctx.GetServer("tbstati");
                m_cPhName = m_Ctx.GetPhName("tbstati");
                m_cSql = "";
                m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer),m_cServer,Cursor_personbo.GetString("PAESE"));
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
                    Error l_oErrorFault = new Error("Read on tbstati into routine arrt_sd_aprichiudi_delope returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _descit = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* _descit := iif(not(Empty(_descit)),_descit,personbo->DESCCIT) */
                _descit = ( ! (CPLib.Empty(_descit))?_descit:Cursor_personbo.GetString("DESCCIT"));
              } else { // Else
                /* _descit := personbo->DESCCIT */
                _descit = Cursor_personbo.GetString("DESCCIT");
              } // End If
              /* _cdata2 := Right(DateToChar(qbe_invio_delope_chi_2->ADATA),2)+Substr(DateToChar(qbe_invio_delope_chi_2->ADATA),5,2)+Left(DateToChar(qbe_invio_delope_chi_2->ADATA),4) */
              _cdata2 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("ADATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("ADATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("ADATA")),4);
              /* _cdata3 := Right(DateToChar(qbe_invio_delope_chi_2->CDATA),2)+Substr(DateToChar(qbe_invio_delope_chi_2->CDATA),5,2)+Left(DateToChar(qbe_invio_delope_chi_2->CDATA),4) */
              _cdata3 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("CDATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("CDATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("CDATA")),4);
              /* mcEsteriC.AppendBlank() */
              mcEsteriC.AppendBlank();
              /* mcEsteriC.TIPOREC := '5' */
              mcEsteriC.row.TIPOREC = "5";
              /* mcEsteriC.DENOM := Left(personbo->RAGSOC,60) */
              mcEsteriC.row.DENOM = CPLib.Left(Cursor_personbo.GetString("RAGSOC"),60);
              /* mcEsteriC.COMSEDE := _descit */
              mcEsteriC.row.COMSEDE = _descit;
              /* mcEsteriC.PROVSED := iif(Empty(personbo->PROVINCIA),'EE',personbo->PROVINCIA) */
              mcEsteriC.row.PROVSED = (CPLib.Empty(Cursor_personbo.GetString("PROVINCIA"))?"EE":Cursor_personbo.GetString("PROVINCIA"));
              /* mcEsteriC.TIPORAP := qbe_invio_delope_chi_2->TIPOAG */
              mcEsteriC.row.TIPORAP = Cursor_qbe_invio_delope_chi_2.GetString("TIPOAG");
              /* mcEsteriC.COINT := qbe_invio_delope_chi_2->COINT */
              mcEsteriC.row.COINT = Cursor_qbe_invio_delope_chi_2.GetString("COINT");
              /* mcEsteriC.RAPPORTO := qbe_invio_delope_chi_2->RAPPORTO */
              mcEsteriC.row.RAPPORTO = Cursor_qbe_invio_delope_chi_2.GetString("RAPPORTO");
              /* mcEsteriC.DATAINI := _cdata2 */
              mcEsteriC.row.DATAINI = _cdata2;
              /* mcEsteriC.DATACHIU := _cdata3 */
              mcEsteriC.row.DATACHIU = _cdata3;
              /* mcEsteriC.IDBASE := qbe_invio_delope_chi_2->IDBASE */
              mcEsteriC.row.IDBASE = Cursor_qbe_invio_delope_chi_2.GetString("IDBASE");
              /* mcEsteriC.PROGRIF := qbe_invio_delope_chi_2->APROG */
              mcEsteriC.row.PROGRIF = Cursor_qbe_invio_delope_chi_2.GetString("APROG");
              /* mcEsteriC.IDFILE := qbe_invio_delope_chi_2->AFILE */
              mcEsteriC.row.IDFILE = Cursor_qbe_invio_delope_chi_2.GetString("AFILE");
              /* mcEsteriC.CODINTER := iif(Empty(LRTrim(qbe_invio_delope_chi_2->OLDINTER)),_cfint,qbe_invio_delope_chi_2->OLDINTER) */
              mcEsteriC.row.CODINTER = (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_invio_delope_chi_2.GetString("OLDINTER")))?_cfint:Cursor_qbe_invio_delope_chi_2.GetString("OLDINTER"));
              /* mcEsteriC.SaveRow() */
              mcEsteriC.SaveRow();
            } // End If
            /* _nocodrec := _nocodrec + 1 */
            _nocodrec = CPLib.Round(_nocodrec+1,0);
          } else { // Else
            /* If not(Empty(personbo->COGNOME)) and (not(Empty(personbo->NOME)) or (Upper(Substr(personbo->CODFISC,4,3))='XXX' and not(Empty(personbo->SESSO)))) and Len(LRTrim(personbo->CODFISC)) = 16 */
            if ( ! (CPLib.Empty(Cursor_personbo.GetString("COGNOME"))) && ( ! (CPLib.Empty(Cursor_personbo.GetString("NOME"))) || (CPLib.eqr(CPLib.Upper(CPLib.Substr(Cursor_personbo.GetString("CODFISC"),4,3)),"XXX") &&  ! (CPLib.Empty(Cursor_personbo.GetString("SESSO"))))) && CPLib.eqr(CPLib.Len(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))),16)) {
              /* _cdata1 := Right(DateToChar(personbo->DATANASC),2)+Substr(DateToChar(personbo->DATANASC),5,2)+Left(DateToChar(personbo->DATANASC),4) */
              _cdata1 = CPLib.Right(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),4);
              /* _cdata2 := Right(DateToChar(qbe_invio_delope_chi_2->ADATA),2)+Substr(DateToChar(qbe_invio_delope_chi_2->ADATA),5,2)+Left(DateToChar(qbe_invio_delope_chi_2->ADATA),4) */
              _cdata2 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("ADATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("ADATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("ADATA")),4);
              /* _cdata3 := Right(DateToChar(qbe_invio_delope_chi_2->CDATA),2)+Substr(DateToChar(qbe_invio_delope_chi_2->CDATA),5,2)+Left(DateToChar(qbe_invio_delope_chi_2->CDATA),4) */
              _cdata3 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("CDATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("CDATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("CDATA")),4);
              /* If not(Empty(personbo->NASSTATO)) and Upper(LRTrim(personbo->NASSTATO)) <> 'ITALIA' */
              if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO"))) && CPLib.ne(CPLib.Upper(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))),"ITALIA")) {
                /* _descit := personbo->NASSTATO */
                _descit = Cursor_personbo.GetString("NASSTATO");
              } else { // Else
                /* _descit := personbo->NASCOMUN */
                _descit = Cursor_personbo.GetString("NASCOMUN");
              } // End If
              /* mcItaliaC.AppendBlank() */
              mcItaliaC.AppendBlank();
              /* mcItaliaC.TIPOREC := '2' */
              mcItaliaC.row.TIPOREC = "2";
              /* mcItaliaC.COGNOME := personbo->COGNOME */
              mcItaliaC.row.COGNOME = Cursor_personbo.GetString("COGNOME");
              /* mcItaliaC.NOME := personbo->NOME */
              mcItaliaC.row.NOME = Cursor_personbo.GetString("NOME");
              /* mcItaliaC.SESSO := iif(personbo->SESSO='F' or personbo->SESSO='2','F','M') */
              mcItaliaC.row.SESSO = (CPLib.eqr(Cursor_personbo.GetString("SESSO"),"F") || CPLib.eqr(Cursor_personbo.GetString("SESSO"),"2")?"F":"M");
              /* mcItaliaC.DATANASC := _cdata1 */
              mcItaliaC.row.DATANASC = _cdata1;
              /* mcItaliaC.COMSTA := _descit */
              mcItaliaC.row.COMSTA = _descit;
              /* mcItaliaC.PROVNA := personbo->TIPINTER */
              mcItaliaC.row.PROVNA = Cursor_personbo.GetString("TIPINTER");
              /* mcItaliaC.TIPORAP := qbe_invio_delope_chi_2->TIPOAG */
              mcItaliaC.row.TIPORAP = Cursor_qbe_invio_delope_chi_2.GetString("TIPOAG");
              /* mcItaliaC.COINT := qbe_invio_delope_chi_2->COINT */
              mcItaliaC.row.COINT = Cursor_qbe_invio_delope_chi_2.GetString("COINT");
              /* mcItaliaC.RAPPORTO := qbe_invio_delope_chi_2->RAPPORTO */
              mcItaliaC.row.RAPPORTO = Cursor_qbe_invio_delope_chi_2.GetString("RAPPORTO");
              /* mcItaliaC.DATAINI := _cdata2 */
              mcItaliaC.row.DATAINI = _cdata2;
              /* mcItaliaC.DATACHIU := _cdata3 */
              mcItaliaC.row.DATACHIU = _cdata3;
              /* mcItaliaC.IDBASE := qbe_invio_delope_chi_2->IDBASE */
              mcItaliaC.row.IDBASE = Cursor_qbe_invio_delope_chi_2.GetString("IDBASE");
              /* mcItaliaC.CODFISC := personbo->CODFISC */
              mcItaliaC.row.CODFISC = Cursor_personbo.GetString("CODFISC");
              /* mcItaliaC.PROGRIF := qbe_invio_delope_chi_2->APROG */
              mcItaliaC.row.PROGRIF = Cursor_qbe_invio_delope_chi_2.GetString("APROG");
              /* mcItaliaC.IDFILE := qbe_invio_delope_chi_2->AFILE */
              mcItaliaC.row.IDFILE = Cursor_qbe_invio_delope_chi_2.GetString("AFILE");
              /* mcItaliaC.CODINTER := iif(Empty(LRTrim(qbe_invio_delope_chi_2->OLDINTER)),_cfint,qbe_invio_delope_chi_2->OLDINTER) */
              mcItaliaC.row.CODINTER = (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_invio_delope_chi_2.GetString("OLDINTER")))?_cfint:Cursor_qbe_invio_delope_chi_2.GetString("OLDINTER"));
              /* mcItaliaC.SaveRow() */
              mcItaliaC.SaveRow();
            } else { // Else
              /* _cdata2 := Right(DateToChar(qbe_invio_delope_chi_2->ADATA),2)+Substr(DateToChar(qbe_invio_delope_chi_2->ADATA),5,2)+Left(DateToChar(qbe_invio_delope_chi_2->ADATA),4) */
              _cdata2 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("ADATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("ADATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("ADATA")),4);
              /* _cdata3 := Right(DateToChar(qbe_invio_delope_chi_2->CDATA),2)+Substr(DateToChar(qbe_invio_delope_chi_2->CDATA),5,2)+Left(DateToChar(qbe_invio_delope_chi_2->CDATA),4) */
              _cdata3 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("CDATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("CDATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("CDATA")),4);
              /* mcItaliaC.AppendBlank() */
              mcItaliaC.AppendBlank();
              /* mcItaliaC.TIPOREC := '2' */
              mcItaliaC.row.TIPOREC = "2";
              /* mcItaliaC.DENOM := Left(personbo->RAGSOC,60) */
              mcItaliaC.row.DENOM = CPLib.Left(Cursor_personbo.GetString("RAGSOC"),60);
              /* mcItaliaC.COMSEDE := personbo->DESCCIT */
              mcItaliaC.row.COMSEDE = Cursor_personbo.GetString("DESCCIT");
              /* mcItaliaC.PROVSED := personbo->PROVINCIA */
              mcItaliaC.row.PROVSED = Cursor_personbo.GetString("PROVINCIA");
              /* mcItaliaC.TIPORAP := qbe_invio_delope_chi_2->TIPOAG */
              mcItaliaC.row.TIPORAP = Cursor_qbe_invio_delope_chi_2.GetString("TIPOAG");
              /* mcItaliaC.COINT := qbe_invio_delope_chi_2->COINT */
              mcItaliaC.row.COINT = Cursor_qbe_invio_delope_chi_2.GetString("COINT");
              /* mcItaliaC.RAPPORTO := qbe_invio_delope_chi_2->RAPPORTO */
              mcItaliaC.row.RAPPORTO = Cursor_qbe_invio_delope_chi_2.GetString("RAPPORTO");
              /* mcItaliaC.DATAINI := _cdata2 */
              mcItaliaC.row.DATAINI = _cdata2;
              /* mcItaliaC.DATACHIU := _cdata3 */
              mcItaliaC.row.DATACHIU = _cdata3;
              /* mcItaliaC.IDBASE := qbe_invio_delope_chi_2->IDBASE */
              mcItaliaC.row.IDBASE = Cursor_qbe_invio_delope_chi_2.GetString("IDBASE");
              /* mcItaliaC.CODFISC := personbo->CODFISC */
              mcItaliaC.row.CODFISC = Cursor_personbo.GetString("CODFISC");
              /* mcItaliaC.PROGRIF := qbe_invio_delope_chi_2->APROG */
              mcItaliaC.row.PROGRIF = Cursor_qbe_invio_delope_chi_2.GetString("APROG");
              /* mcItaliaC.IDFILE := qbe_invio_delope_chi_2->AFILE */
              mcItaliaC.row.IDFILE = Cursor_qbe_invio_delope_chi_2.GetString("AFILE");
              /* mcItaliaC.CODINTER := iif(Empty(LRTrim(qbe_invio_delope_chi_2->OLDINTER)),_cfint,qbe_invio_delope_chi_2->OLDINTER) */
              mcItaliaC.row.CODINTER = (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_invio_delope_chi_2.GetString("OLDINTER")))?_cfint:Cursor_qbe_invio_delope_chi_2.GetString("OLDINTER"));
              /* mcItaliaC.SaveRow() */
              mcItaliaC.SaveRow();
            } // End If
            /* _sicodrec := _sicodrec + 1 */
            _sicodrec = CPLib.Round(_sicodrec+1,0);
          } // End If
          Cursor_personbo.Next();
        }
        m_cConnectivityError = Cursor_personbo.ErrorMessage();
        Cursor_personbo.Close();
        // * --- End Select
        Cursor_qbe_invio_delope_chi_2.Next();
      }
      m_cConnectivityError = Cursor_qbe_invio_delope_chi_2.ErrorMessage();
      Cursor_qbe_invio_delope_chi_2.Close();
      // * --- End Select
      /* If _sicodrec > 0 */
      if (CPLib.gt(_sicodrec,0)) {
        /* _i := 1 */
        _i = CPLib.Round(1,0);
        /* _crow := 0 */
        _crow = CPLib.Round(0,0);
        /* _cfile := 0 */
        _cfile = CPLib.Round(0,0);
        /* _conta := 1 */
        _conta = CPLib.Round(1,0);
        for (MemoryCursorRow_tmp_chiucod rowItaliaC : mcItaliaC._iterable_()) {
          /* If _crow = 0 and _i=1 */
          if (CPLib.eqr(_crow,0) && CPLib.eqr(_i,1)) {
            /* _nomefile := '99'+Right(DateTimeToChar(DateTime()),12)+'2' */
            _nomefile = "99"+CPLib.Right(CPLib.DateTimeToChar(CPLib.DateTime()),12)+"2";
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
            /* Crea Record di testa */
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
            /* _crow := 1 */
            _crow = CPLib.Round(1,0);
            /* FileLibrary.WriteLine(fhand,_file) */
            FileLibrary.WriteLine(fhand,_file);
          } // End If
          /* gMsgImp := 'Elaborazione soggetti con CF italiano. Sto scrivendo il file ' + LRTrim(cOnlyNomeFile)+ ' - Riga N° '+ LRTrim(Str(_crow,10,0)) // Messaggio Import */
          gMsgImp = "Elaborazione soggetti con CF italiano. Sto scrivendo il file "+CPLib.LRTrim(cOnlyNomeFile)+" - Riga N° "+CPLib.LRTrim(CPLib.Str(_crow,10,0));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* _r := _r + 1 */
          _r = CPLib.Round(_r+1,0);
          /* If _i = 1 */
          if (CPLib.eqr(_i,1)) {
            /* _file := mcItaliaC.TIPOREC */
            _file = mcItaliaC.row.TIPOREC;
          } // End If
          /* _file := _file + Right("0000000000000000000000000000000000000000" + LRTrim(Str(_r)),25) */
          _file = _file+CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(CPLib.Str(_r)),25);
          /* _file := _file + Left(LRTrim(mcItaliaC.CODINTER)+Space(16),16) */
          _file = _file+CPLib.Left(CPLib.LRTrim(mcItaliaC.row.CODINTER)+CPLib.Space(16),16);
          /* _file := _file + Right("00000000000000000000000000" + LRTrim(mcItaliaC.IDFILE),15) */
          _file = _file+CPLib.Right("00000000000000000000000000"+CPLib.LRTrim(mcItaliaC.row.IDFILE),15);
          /* _file := _file + Right("0000000000000000000000000000000000000000" + LRTrim(mcItaliaC.PROGRIF),25) */
          _file = _file+CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(mcItaliaC.row.PROGRIF),25);
          /* _file := _file + Left(LRTrim(mcItaliaC.CODFISC) + Space(16),16) */
          _file = _file+CPLib.Left(CPLib.LRTrim(mcItaliaC.row.CODFISC)+CPLib.Space(16),16);
          /* _file := _file + Left(LRTrim(arfn_agechar(mcItaliaC.COGNOME,' ')) + Space(26),26) */
          _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(mcItaliaC.row.COGNOME," "))+CPLib.Space(26),26);
          /* _file := _file + Left(LRTrim(arfn_agechar(mcItaliaC.NOME,' ')) + Space(25),25) */
          _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(mcItaliaC.row.NOME," "))+CPLib.Space(25),25);
          /* _file := _file + Left(LRTrim(arfn_agechar(mcItaliaC.SESSO,' '))+Space(1),1) */
          _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(mcItaliaC.row.SESSO," "))+CPLib.Space(1),1);
          /* _file := _file + Left(LRTrim(mcItaliaC.DATANASC) + Space(8),8) */
          _file = _file+CPLib.Left(CPLib.LRTrim(mcItaliaC.row.DATANASC)+CPLib.Space(8),8);
          /* _file := _file + Left(LRTrim(arfn_agechar(mcItaliaC.COMSTA,' ')) + Space(40),40) */
          _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(mcItaliaC.row.COMSTA," "))+CPLib.Space(40),40);
          /* _file := _file + Left(LRTrim(arfn_agechar(mcItaliaC.PROVNA,' ')) + Space(2),2) */
          _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(mcItaliaC.row.PROVNA," "))+CPLib.Space(2),2);
          /* _file := _file + Left(LRTrim(arfn_agechar(mcItaliaC.DENOM,' ')) + Space(60),60) */
          _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(mcItaliaC.row.DENOM," "))+CPLib.Space(60),60);
          /* _file := _file + Left(LRTrim(arfn_agechar(mcItaliaC.COMSEDE,' ')) + Space(40),40) */
          _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(mcItaliaC.row.COMSEDE," "))+CPLib.Space(40),40);
          /* _file := _file + Left(LRTrim(arfn_agechar(mcItaliaC.PROVSED,' ')) + Space(2),2) */
          _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(mcItaliaC.row.PROVSED," "))+CPLib.Space(2),2);
          /* _file := _file + Left(LRTrim(mcItaliaC.TIPORAP) + Space(2),2) */
          _file = _file+CPLib.Left(CPLib.LRTrim(mcItaliaC.row.TIPORAP)+CPLib.Space(2),2);
          /* _file := _file + Left(LRTrim(mcItaliaC.COINT) + Space(1),1) */
          _file = _file+CPLib.Left(CPLib.LRTrim(mcItaliaC.row.COINT)+CPLib.Space(1),1);
          /* _file := _file + Left(LRTrim(mcItaliaC.DATAINI) + Space(8),8) */
          _file = _file+CPLib.Left(CPLib.LRTrim(mcItaliaC.row.DATAINI)+CPLib.Space(8),8);
          /* _file := _file + Left(LRTrim(mcItaliaC.DATACHIU) + Space(8),8) */
          _file = _file+CPLib.Left(CPLib.LRTrim(mcItaliaC.row.DATACHIU)+CPLib.Space(8),8);
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
          // * --- Write into aederig from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aederig");
          m_cPhName = m_Ctx.GetPhName("aederig");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = "Update "+m_cPhName+" set ";
          m_cSql = m_cSql+"CSPEDITO = "+CPLib.ToSQL(1,"N",1,0)+", ";
          m_cSql = m_cSql+"CPROG = "+CPLib.ToSQL(_r,"C",25,0,m_cServer)+", ";
          m_cSql = m_cSql+"CFILE = "+CPLib.ToSQL(_nomefile,"C",15,0,m_cServer)+", ";
          m_cSql = m_cSql+"CDTPRE = "+CPLib.ToSQL(w_a_data,"D",8,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aederig",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(mcItaliaC.row.IDBASE,"?",0,0,m_cServer),m_cServer,mcItaliaC.row.IDBASE)+"";
          if (m_Ctx.IsSharedTemp("aederig")) {
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
          // * --- Insert into tmp_stpfileage from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_stpfileage");
          m_cPhName = m_Ctx.GetPhName("tmp_stpfileage");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_stpfileage")+" (";
          m_cSql = m_cSql+GetFieldsName_075535B8(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(mcItaliaC.row.RAPPORTO,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(CPLib.Str(_r)),25),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(mcItaliaC.row.SESSO)?mcItaliaC.row.DENOM:CPLib.LRTrim(mcItaliaC.row.COGNOME)+" "+CPLib.LRTrim(mcItaliaC.row.NOME)),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(mcItaliaC.row.DATAINI,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(mcItaliaC.row.DATACHIU,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(mcItaliaC.row.COINT,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(mcItaliaC.row.TIPORAP,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(mcItaliaC.row.CODFISC,"?",0,0,m_cServer)+", ";
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
            /* _file := _file + LRTrim(arfn_agechar(_ragint,' '))+Space(70 - Len(LRTrim(_ragint))) */
            _file = _file+CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(_ragint," "))+CPLib.Space(70-CPLib.Len(CPLib.LRTrim(_ragint)));
            /* _file := _file + LRTrim(arfn_agechar(_citint,' '))+Space(40 - Len(LRTrim(_citint))) */
            _file = _file+CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(_citint," "))+CPLib.Space(40-CPLib.Len(CPLib.LRTrim(_citint)));
            /* _file := _file + LRTrim(arfn_agechar(_prvint,' '))+Space(2 - Len(LRTrim(_prvint))) */
            _file = _file+CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(_prvint," "))+CPLib.Space(2-CPLib.Len(CPLib.LRTrim(_prvint)));
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
            /* FileLibrary.Write(fhand,_file) */
            FileLibrary.Write(fhand,_file);
            /* FileLibrary.Close(fhand) */
            FileLibrary.Close(fhand);
            /* cProg := Utilities.GetAutonumber("PRGFILES\'"+LRTrim(gAzienda)+"'",'',10) */
            cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGFILES\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
            // * --- Insert into aefile_do_glob from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("aefile_do_glob");
            m_cPhName = m_Ctx.GetPhName("aefile_do_glob");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.InsertIntoStatement(m_Ctx,"aefile_do_glob")+" (";
            m_cSql = m_cSql+GetFieldsName_0779AB68(m_Ctx);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_nomefile),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Invio "+CPLib.Right("0000"+CPLib.Str(CPLib.Year(w_a_data),4,0),4)+CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(CPLib.Month(w_a_data),2,0)),2)+" - Chiusure Soggetti Italiani","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_mese,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_anno,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_nomefile,30),"?",0,0,m_cServer)+", ";
            if (m_Ctx.IsSharedTemp("aefile_do_glob")) {
              m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
            }
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aefile_do_glob",true);
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
          /* Cicla sul file per invii e prepara il file */
        }
        /* If _crow > 0 and _crow<15000 */
        if (CPLib.gt(_crow,0) && CPLib.lt(_crow,15000)) {
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
          /* _file :=  '9CCB00' + '34' */
          _file = "9CCB00"+"34";
          /* _file := _file + LRTrim(_cfint)+Space(16 - Len(LRTrim(_cfint))) */
          _file = _file+CPLib.LRTrim(_cfint)+CPLib.Space(16-CPLib.Len(CPLib.LRTrim(_cfint)));
          /* _file := _file + Space(102) */
          _file = _file+CPLib.Space(102);
          /* _file := _file + LRTrim(arfn_agechar(_ragint,' '))+Space(70 - Len(LRTrim(_ragint))) */
          _file = _file+CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(_ragint," "))+CPLib.Space(70-CPLib.Len(CPLib.LRTrim(_ragint)));
          /* _file := _file + LRTrim(arfn_agechar(_citint,' '))+Space(40 - Len(LRTrim(_citint))) */
          _file = _file+CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(_citint," "))+CPLib.Space(40-CPLib.Len(CPLib.LRTrim(_citint)));
          /* _file := _file + LRTrim(arfn_agechar(_prvint,' '))+Space(2 - Len(LRTrim(_prvint))) */
          _file = _file+CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(_prvint," "))+CPLib.Space(2-CPLib.Len(CPLib.LRTrim(_prvint)));
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
          /* FileLibrary.Write(fhand,_file) */
          FileLibrary.Write(fhand,_file);
          /* FileLibrary.Close(fhand) */
          FileLibrary.Close(fhand);
          /* cProg := Utilities.GetAutonumber("PRGFILES\'"+LRTrim(gAzienda)+"'",'',10) */
          cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGFILES\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
          // * --- Insert into aefile_do_glob from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aefile_do_glob");
          m_cPhName = m_Ctx.GetPhName("aefile_do_glob");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"aefile_do_glob")+" (";
          m_cSql = m_cSql+GetFieldsName_06305458(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_nomefile),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Invio "+CPLib.Right("0000"+CPLib.Str(CPLib.Year(w_a_data),4,0),4)+CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(CPLib.Month(w_a_data),2,0)),2)+" - Chiusure Soggetti Italiani","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(w_mese,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(w_anno,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_nomefile,30),"?",0,0,m_cServer)+", ";
          if (m_Ctx.IsSharedTemp("aefile_do_glob")) {
            m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
          }
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aefile_do_glob",true);
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
        /* If _fileita > 0 */
        if (CPLib.gt(_fileita,0)) {
          /* _czip := '99'+Right(DateTimeToChar(DateTime()),12)+"_2.zip" */
          _czip = "99"+CPLib.Right(CPLib.DateTimeToChar(CPLib.DateTime()),12)+"_2.zip";
          /* cNomeFileZip := LRTrim(gPathApp)+'/flussi/'+LRTrim(gAzienda)+"/"+_czip */
          cNomeFileZip = CPLib.LRTrim(gPathApp)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+_czip;
          /* Exec "Crea file zip" Page 4:Page_4 */
          Page_4();
          /* cProg := Utilities.GetAutonumber("PRGFILES\'"+LRTrim(gAzienda)+"'",'',10) */
          cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGFILES\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
          // * --- Insert into aefiles_do from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aefiles_do");
          m_cPhName = m_Ctx.GetPhName("aefiles_do");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"aefiles_do")+" (";
          m_cSql = m_cSql+GetFieldsName_076EF238(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_czip),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Invio "+CPLib.Right("0000"+CPLib.Str(CPLib.Year(w_a_data),4,0),4)+CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(CPLib.Month(w_a_data),2,0)),2)+" - Chiusure Soggetti Italiani","?",0,0,m_cServer)+", ";
          if (m_Ctx.IsSharedTemp("aefiles_do")) {
            m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
          }
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aefiles_do",true);
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
        } // End If
      } // End If
      /* If _nocodrec > 0 */
      if (CPLib.gt(_nocodrec,0)) {
        /* _i := 1 */
        _i = CPLib.Round(1,0);
        /* _crow := 0 */
        _crow = CPLib.Round(0,0);
        /* _cfile := 0 */
        _cfile = CPLib.Round(0,0);
        /* _conta := 1 */
        _conta = CPLib.Round(1,0);
        /* _fileest := 0 // Conteggio file soggetti esteri */
        _fileest = CPLib.Round(0,0);
        for (MemoryCursorRow_tmp_chiunocod rowEsteriC : mcEsteriC._iterable_()) {
          /* If _crow = 0 and _i=1 */
          if (CPLib.eqr(_crow,0) && CPLib.eqr(_i,1)) {
            /* _nomefile := '99'+Right(DateTimeToChar(DateTime()),12)+'5' */
            _nomefile = "99"+CPLib.Right(CPLib.DateTimeToChar(CPLib.DateTime()),12)+"5";
            /* cNomeFile := LRTrim(gPathApp)+'/flussi/'+LRTrim(gAzienda)+"/"+LRTrim(_nomefile) */
            cNomeFile = CPLib.LRTrim(gPathApp)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_nomefile);
            /* cOnlyNomeFile := _nomefile */
            cOnlyNomeFile = _nomefile;
            /* _fileest := _fileest + 1 // Conteggio file soggetti esteri */
            _fileest = CPLib.Round(_fileest+1,0);
            // These are the files to include in the ZIP file
            filenames.add(cNomeFile);
            fileonames.add(cOnlyNomeFile);
            /* fhand := FileLibrary.OpenWrite('./flussi/'+LRTrim(gAzienda)+"/"+LRTrim(_nomefile)) */
            fhand = FileLibrary.OpenWrite("./flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_nomefile));
            /* Crea Record di testa */
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
            /* _crow := 1 */
            _crow = CPLib.Round(1,0);
          } // End If
          /* gMsgImp := 'Elaborazione soggetti csenza CF italiano. Sto scrivendo il file ' + LRTrim(cOnlyNomeFile)+ ' - Riga N° '+ LRTrim(Str(_crow,10,0)) // Messaggio Import */
          gMsgImp = "Elaborazione soggetti csenza CF italiano. Sto scrivendo il file "+CPLib.LRTrim(cOnlyNomeFile)+" - Riga N° "+CPLib.LRTrim(CPLib.Str(_crow,10,0));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* _r := _r + 1 */
          _r = CPLib.Round(_r+1,0);
          /* If _i = 1 */
          if (CPLib.eqr(_i,1)) {
            /* _file := mcEsteriC.TIPOREC */
            _file = mcEsteriC.row.TIPOREC;
          } // End If
          /* _file := _file + Right("0000000000000000000000000000000000000000" + LRTrim(Str(_r)),25) */
          _file = _file+CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(CPLib.Str(_r)),25);
          /* _file := _file + Left(LRTrim(mcEsteriC.CODINTER)+Space(16),16) */
          _file = _file+CPLib.Left(CPLib.LRTrim(mcEsteriC.row.CODINTER)+CPLib.Space(16),16);
          /* _file := _file + Right("00000000000000000000000000" + LRTrim(mcEsteriC.IDFILE),15) */
          _file = _file+CPLib.Right("00000000000000000000000000"+CPLib.LRTrim(mcEsteriC.row.IDFILE),15);
          /* _file := _file + Right("0000000000000000000000000000000000000000" + LRTrim(mcEsteriC.PROGRIF),25) */
          _file = _file+CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(mcEsteriC.row.PROGRIF),25);
          /* _file := _file + Left(LRTrim(arfn_agechar(mcEsteriC.COGNOME,' ')) + Space(26),26) */
          _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(mcEsteriC.row.COGNOME," "))+CPLib.Space(26),26);
          /* _file := _file + Left(LRTrim(arfn_agechar(mcEsteriC.NOME,' ')) + Space(25),25) */
          _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(mcEsteriC.row.NOME," "))+CPLib.Space(25),25);
          /* _file := _file + Left(LRTrim(arfn_agechar(mcEsteriC.SESSO,' '))+Space(1),1) */
          _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(mcEsteriC.row.SESSO," "))+CPLib.Space(1),1);
          /* _file := _file + Left(LRTrim(mcEsteriC.DATANASC) + Space(8),8) */
          _file = _file+CPLib.Left(CPLib.LRTrim(mcEsteriC.row.DATANASC)+CPLib.Space(8),8);
          /* _file := _file + Left(LRTrim(arfn_agechar(mcEsteriC.COMSTA,' ')) + Space(40),40) */
          _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(mcEsteriC.row.COMSTA," "))+CPLib.Space(40),40);
          /* _file := _file + Left(LRTrim(arfn_agechar(mcEsteriC.PROVNA,' ')) + Space(2),2) */
          _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(mcEsteriC.row.PROVNA," "))+CPLib.Space(2),2);
          /* _file := _file + Left(LRTrim(arfn_agechar(mcEsteriC.DENOM,' ')) + Space(60),60) */
          _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(mcEsteriC.row.DENOM," "))+CPLib.Space(60),60);
          /* _file := _file + Left(LRTrim(arfn_agechar(mcEsteriC.COMSEDE,' ')) + Space(40),40) */
          _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(mcEsteriC.row.COMSEDE," "))+CPLib.Space(40),40);
          /* _file := _file + Left(LRTrim(arfn_agechar(mcEsteriC.PROVSED,' ')) + Space(2),2) */
          _file = _file+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(mcEsteriC.row.PROVSED," "))+CPLib.Space(2),2);
          /* _file := _file + Left(LRTrim(mcEsteriC.TIPORAP) + Space(2),2) */
          _file = _file+CPLib.Left(CPLib.LRTrim(mcEsteriC.row.TIPORAP)+CPLib.Space(2),2);
          /* _file := _file + Left(LRTrim(mcEsteriC.COINT) + Space(1),1) */
          _file = _file+CPLib.Left(CPLib.LRTrim(mcEsteriC.row.COINT)+CPLib.Space(1),1);
          /* _file := _file + Left(LRTrim(mcEsteriC.DATAINI) + Space(8),8) */
          _file = _file+CPLib.Left(CPLib.LRTrim(mcEsteriC.row.DATAINI)+CPLib.Space(8),8);
          /* _file := _file + Left(LRTrim(mcEsteriC.DATACHIU) + Space(8),8) */
          _file = _file+CPLib.Left(CPLib.LRTrim(mcEsteriC.row.DATACHIU)+CPLib.Space(8),8);
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
          // * --- Write into aederig from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aederig");
          m_cPhName = m_Ctx.GetPhName("aederig");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = "Update "+m_cPhName+" set ";
          m_cSql = m_cSql+"CSPEDITO = "+CPLib.ToSQL(1,"N",1,0)+", ";
          m_cSql = m_cSql+"CPROG = "+CPLib.ToSQL(_r,"C",25,0,m_cServer)+", ";
          m_cSql = m_cSql+"CFILE = "+CPLib.ToSQL(_nomefile,"C",15,0,m_cServer)+", ";
          m_cSql = m_cSql+"CDTPRE = "+CPLib.ToSQL(w_a_data,"D",8,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aederig",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(mcEsteriC.row.IDBASE,"?",0,0,m_cServer),m_cServer,mcEsteriC.row.IDBASE)+"";
          if (m_Ctx.IsSharedTemp("aederig")) {
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
          // * --- Insert into tmp_stpfileage from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_stpfileage");
          m_cPhName = m_Ctx.GetPhName("tmp_stpfileage");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_stpfileage")+" (";
          m_cSql = m_cSql+GetFieldsName_0702C510(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("5","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(mcEsteriC.row.RAPPORTO,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(CPLib.Str(_r)),25),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(mcEsteriC.row.SESSO)?mcEsteriC.row.DENOM:CPLib.LRTrim(mcEsteriC.row.COGNOME)+" "+CPLib.LRTrim(mcEsteriC.row.NOME)),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(mcEsteriC.row.DATAINI,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(mcEsteriC.row.DATACHIU,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(mcEsteriC.row.COINT,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(mcEsteriC.row.TIPORAP,"?",0,0,m_cServer)+", ";
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
            /* _file := _file + LRTrim(arfn_agechar(_ragint,' '))+Space(70 - Len(LRTrim(_ragint))) */
            _file = _file+CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(_ragint," "))+CPLib.Space(70-CPLib.Len(CPLib.LRTrim(_ragint)));
            /* _file := _file + LRTrim(arfn_agechar(_citint,' '))+Space(40 - Len(LRTrim(_citint))) */
            _file = _file+CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(_citint," "))+CPLib.Space(40-CPLib.Len(CPLib.LRTrim(_citint)));
            /* _file := _file + LRTrim(arfn_agechar(_prvint,' '))+Space(2 - Len(LRTrim(_prvint))) */
            _file = _file+CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(_prvint," "))+CPLib.Space(2-CPLib.Len(CPLib.LRTrim(_prvint)));
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
            /* FileLibrary.Write(fhand,_file) */
            FileLibrary.Write(fhand,_file);
            /* FileLibrary.Close(fhand) */
            FileLibrary.Close(fhand);
            /* cProg := Utilities.GetAutonumber("PRGFILES\'"+LRTrim(gAzienda)+"'",'',10) */
            cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGFILES\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
            // * --- Insert into aefile_do_glob from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("aefile_do_glob");
            m_cPhName = m_Ctx.GetPhName("aefile_do_glob");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.InsertIntoStatement(m_Ctx,"aefile_do_glob")+" (";
            m_cSql = m_cSql+GetFieldsName_05DD7E58(m_Ctx);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_nomefile),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Invio "+CPLib.Right("0000"+CPLib.Str(CPLib.Year(w_a_data),4,0),4)+CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(CPLib.Month(w_a_data),2,0)),2)+" - Chiusure Soggetti Esteri","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_mese,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_anno,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_nomefile,30),"?",0,0,m_cServer)+", ";
            if (m_Ctx.IsSharedTemp("aefile_do_glob")) {
              m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
            }
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aefile_do_glob",true);
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
          /* Cicla sul file per invii e prepara il file */
        }
        /* If _crow > 0 and _crow<15000 */
        if (CPLib.gt(_crow,0) && CPLib.lt(_crow,15000)) {
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
          /* _file :=  '9CCB00' + '34' */
          _file = "9CCB00"+"34";
          /* _file := _file + LRTrim(_cfint)+Space(16 - Len(LRTrim(_cfint))) */
          _file = _file+CPLib.LRTrim(_cfint)+CPLib.Space(16-CPLib.Len(CPLib.LRTrim(_cfint)));
          /* _file := _file + Space(102) */
          _file = _file+CPLib.Space(102);
          /* _file := _file + LRTrim(arfn_agechar(_ragint,' '))+Space(70 - Len(LRTrim(_ragint))) */
          _file = _file+CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(_ragint," "))+CPLib.Space(70-CPLib.Len(CPLib.LRTrim(_ragint)));
          /* _file := _file + LRTrim(arfn_agechar(_citint,' '))+Space(40 - Len(LRTrim(_citint))) */
          _file = _file+CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(_citint," "))+CPLib.Space(40-CPLib.Len(CPLib.LRTrim(_citint)));
          /* _file := _file + LRTrim(arfn_agechar(_prvint,' '))+Space(2 - Len(LRTrim(_prvint))) */
          _file = _file+CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(_prvint," "))+CPLib.Space(2-CPLib.Len(CPLib.LRTrim(_prvint)));
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
          /* FileLibrary.Write(fhand,_file) */
          FileLibrary.Write(fhand,_file);
          /* FileLibrary.Close(fhand) */
          FileLibrary.Close(fhand);
          /* cProg := Utilities.GetAutonumber("PRGFILES\'"+LRTrim(gAzienda)+"'",'',10) */
          cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGFILES\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
          // * --- Insert into aefile_do_glob from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aefile_do_glob");
          m_cPhName = m_Ctx.GetPhName("aefile_do_glob");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"aefile_do_glob")+" (";
          m_cSql = m_cSql+GetFieldsName_077AC860(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_nomefile),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Invio "+CPLib.Right("0000"+CPLib.Str(CPLib.Year(w_a_data),4,0),4)+CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(CPLib.Month(w_a_data),2,0)),2)+" - Chiusure Soggetti Italiani","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(w_mese,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(w_anno,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_nomefile,30),"?",0,0,m_cServer)+", ";
          if (m_Ctx.IsSharedTemp("aefile_do_glob")) {
            m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
          }
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aefile_do_glob",true);
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
        /* If _fileest > 0 */
        if (CPLib.gt(_fileest,0)) {
          /* _czip := '99'+Right(DateTimeToChar(DateTime()),12)+"_5.zip" */
          _czip = "99"+CPLib.Right(CPLib.DateTimeToChar(CPLib.DateTime()),12)+"_5.zip";
          /* cNomeFileZip := LRTrim(gPathApp)+'/flussi/'+LRTrim(gAzienda)+"/"+_czip */
          cNomeFileZip = CPLib.LRTrim(gPathApp)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+_czip;
          /* Exec "Crea file zip" Page 4:Page_4 */
          Page_4();
          /* cProg := Utilities.GetAutonumber("PRGFILES\'"+LRTrim(gAzienda)+"'",'',10) */
          cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGFILES\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
          // * --- Insert into aefiles_do from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aefiles_do");
          m_cPhName = m_Ctx.GetPhName("aefiles_do");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"aefiles_do")+" (";
          m_cSql = m_cSql+GetFieldsName_06EC1E30(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_czip),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Invio "+CPLib.Right("0000"+CPLib.Str(CPLib.Year(w_a_data),4,0),4)+CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(CPLib.Month(w_a_data),2,0)),2)+" - Chiusure Soggetti Esteri","?",0,0,m_cServer)+", ";
          if (m_Ctx.IsSharedTemp("aefiles_do")) {
            m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
          }
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aefiles_do",true);
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
        } // End If
      } // End If
    } finally {
      try {
        if (Cursor_qbe_invio_delope_chi_2!=null)
          Cursor_qbe_invio_delope_chi_2.Close();
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
        if (Read_Cursor!=null)
          Read_Cursor.Close();
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
  public String RunAsync(java.sql.Date p_w_a_data,java.sql.Date p_w_dadata,String p_w_FILEINVIO,java.sql.Date p_w_DATAINVIO,String p_w_CFINVIO,String p_w_CAFINVIO,double p_w_anno,String p_w_mese) {
    w_a_data = p_w_a_data;
    w_dadata = p_w_dadata;
    w_FILEINVIO = p_w_FILEINVIO;
    w_DATAINVIO = p_w_DATAINVIO;
    w_CFINVIO = p_w_CFINVIO;
    w_CAFINVIO = p_w_CAFINVIO;
    w_anno = p_w_anno;
    w_mese = p_w_mese;
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
  public Forward Run(java.sql.Date p_w_a_data,java.sql.Date p_w_dadata,String p_w_FILEINVIO,java.sql.Date p_w_DATAINVIO,String p_w_CFINVIO,String p_w_CAFINVIO,double p_w_anno,String p_w_mese) {
    w_a_data = p_w_a_data;
    w_dadata = p_w_dadata;
    w_FILEINVIO = p_w_FILEINVIO;
    w_DATAINVIO = p_w_DATAINVIO;
    w_CFINVIO = p_w_CFINVIO;
    w_CAFINVIO = p_w_CAFINVIO;
    w_anno = p_w_anno;
    w_mese = p_w_mese;
    return Run();
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
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_sd_aprichiudi_delopeR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_sd_aprichiudi_delopeR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_a_data = CPLib.NullDate();
    w_dadata = CPLib.NullDate();
    w_FILEINVIO = CPLib.Space(1);
    w_DATAINVIO = CPLib.NullDate();
    w_CFINVIO = CPLib.Space(16);
    w_CAFINVIO = CPLib.Space(5);
    w_anno = 0;
    w_mese = CPLib.Space(2);
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
    _intefisc = CPLib.Space(16);
    _cfint = CPLib.Space(16);
    _ragint = CPLib.Space(70);
    _citint = CPLib.Space(40);
    _prvint = CPLib.Space(2);
    _cfinvio = CPLib.Space(16);
    _cafinvio = CPLib.Space(5);
    _tipinvio = CPLib.Space(1);
    _impinvio = CPLib.Space(8);
    _datinvio = CPLib.NullDate();
    _itariga = 0;
    _estriga = 0;
    _max = 0;
    _min = 0;
    _tot = 0;
    _mono = 0;
    _cicli = 0;
    _bottom = 0;
    _top = 0;
    _fileita = 0;
    _fileest = 0;
    _contacilci = 0;
    countmp = 0;
    _estero = CPLib.Space(1);
    _crow = 0;
    _cfile = 0;
    _conta = 0;
    _czip = CPLib.Space(20);
    _file1 = CPLib.Space(30);
    _file2 = CPLib.Space(30);
    mcItaliaA = new MemoryCursor_tmp_apecod();
    rowItaliaA = new MemoryCursorRow_tmp_apecod();
    mcItaliaC = new MemoryCursor_tmp_chiucod();
    rowItaliaC = new MemoryCursorRow_tmp_chiucod();
    mcEsteriA = new MemoryCursor_tmp_apenocod();
    rowEsteriA = new MemoryCursorRow_tmp_apenocod();
    mcEsteriC = new MemoryCursor_tmp_chiunocod();
    rowEsteriC = new MemoryCursorRow_tmp_chiunocod();
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_invio_delope_ape_5,qbe_invio_delope_ape_6_max_min_glob,qbe_invio_delope_ape_6_globale,qbe_invio_delope_ape_5,qbe_invio_delope_ape_6_max_min_glob,qbe_invio_delope_ape_6_globale,qbe_invio_delope_chi_2,
  public static final String m_cVQRList = ",qbe_invio_delope_ape_5,qbe_invio_delope_ape_6_max_min_glob,qbe_invio_delope_ape_6_globale,qbe_invio_delope_ape_5,qbe_invio_delope_ape_6_max_min_glob,qbe_invio_delope_ape_6_globale,qbe_invio_delope_chi_2,";
  // ENTITY_BATCHES: ,arfn_agechar,
  public static final String i_InvokedRoutines = ",arfn_agechar,";
  public static String[] m_cRunParameterNames={"w_a_data","w_dadata","w_FILEINVIO","w_DATAINVIO","w_CFINVIO","w_CAFINVIO","w_anno","w_mese"};
  protected static String GetFieldsName_05DF0278(CPContext p_Ctx) {
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
  protected static String GetFieldsName_077B8170(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"idfile,";
    p_cSql = p_cSql+"datafile,";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"descfile,";
    p_cSql = p_cSql+"mese,";
    p_cSql = p_cSql+"anno,";
    p_cSql = p_cSql+"filename,";
    if (p_Ctx.IsSharedTemp("aefile_do_glob")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aefile_do_glob",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0768C918(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"idfile,";
    p_cSql = p_cSql+"datafile,";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"descfile,";
    p_cSql = p_cSql+"mese,";
    p_cSql = p_cSql+"anno,";
    p_cSql = p_cSql+"filename,";
    if (p_Ctx.IsSharedTemp("aefile_do_glob")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aefile_do_glob",true);
    return p_cSql;
  }
  protected static String GetFieldsName_07A6DC78(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"idfile,";
    p_cSql = p_cSql+"datafile,";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"descfile,";
    if (p_Ctx.IsSharedTemp("aefiles_do")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aefiles_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05FCA348(CPContext p_Ctx) {
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
  protected static String GetFieldsName_061AB648(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"idfile,";
    p_cSql = p_cSql+"datafile,";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"descfile,";
    p_cSql = p_cSql+"mese,";
    p_cSql = p_cSql+"anno,";
    p_cSql = p_cSql+"filename,";
    if (p_Ctx.IsSharedTemp("aefile_do_glob")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aefile_do_glob",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05D02140(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"idfile,";
    p_cSql = p_cSql+"datafile,";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"descfile,";
    p_cSql = p_cSql+"mese,";
    p_cSql = p_cSql+"anno,";
    p_cSql = p_cSql+"filename,";
    if (p_Ctx.IsSharedTemp("aefile_do_glob")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aefile_do_glob",true);
    return p_cSql;
  }
  protected static String GetFieldsName_077D2FC0(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"idfile,";
    p_cSql = p_cSql+"datafile,";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"descfile,";
    if (p_Ctx.IsSharedTemp("aefiles_do")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aefiles_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_075535B8(CPContext p_Ctx) {
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
  protected static String GetFieldsName_0779AB68(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"idfile,";
    p_cSql = p_cSql+"datafile,";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"descfile,";
    p_cSql = p_cSql+"mese,";
    p_cSql = p_cSql+"anno,";
    p_cSql = p_cSql+"filename,";
    if (p_Ctx.IsSharedTemp("aefile_do_glob")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aefile_do_glob",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06305458(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"idfile,";
    p_cSql = p_cSql+"datafile,";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"descfile,";
    p_cSql = p_cSql+"mese,";
    p_cSql = p_cSql+"anno,";
    p_cSql = p_cSql+"filename,";
    if (p_Ctx.IsSharedTemp("aefile_do_glob")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aefile_do_glob",true);
    return p_cSql;
  }
  protected static String GetFieldsName_076EF238(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"idfile,";
    p_cSql = p_cSql+"datafile,";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"descfile,";
    if (p_Ctx.IsSharedTemp("aefiles_do")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aefiles_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0702C510(CPContext p_Ctx) {
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
  protected static String GetFieldsName_05DD7E58(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"idfile,";
    p_cSql = p_cSql+"datafile,";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"descfile,";
    p_cSql = p_cSql+"mese,";
    p_cSql = p_cSql+"anno,";
    p_cSql = p_cSql+"filename,";
    if (p_Ctx.IsSharedTemp("aefile_do_glob")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aefile_do_glob",true);
    return p_cSql;
  }
  protected static String GetFieldsName_077AC860(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"idfile,";
    p_cSql = p_cSql+"datafile,";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"descfile,";
    p_cSql = p_cSql+"mese,";
    p_cSql = p_cSql+"anno,";
    p_cSql = p_cSql+"filename,";
    if (p_Ctx.IsSharedTemp("aefile_do_glob")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aefile_do_glob",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06EC1E30(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"idfile,";
    p_cSql = p_cSql+"datafile,";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"descfile,";
    if (p_Ctx.IsSharedTemp("aefiles_do")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aefiles_do",true);
    return p_cSql;
  }
}
