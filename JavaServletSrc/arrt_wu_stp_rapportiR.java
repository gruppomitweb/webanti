// * --- Area Manuale = BO - Header
// * --- arrt_wu_stp_rapporti
import java.util.*;
import java.util.Iterator;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
// * --- Fine Area Manuale
public class arrt_wu_stp_rapportiR implements CallerWithObjs {
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
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_tbtipdoc;
  public String m_cServer_tbtipdoc;
  public String m_cPhName_docfrabo;
  public String m_cServer_docfrabo;
  public String m_cPhName_kersonbo;
  public String m_cServer_kersonbo;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public String m_cPhName_tmp_newpers;
  public String m_cServer_tmp_newpers;
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
  public String w_codrap;
  public String w_WUCODMAGE;
  public String w_xDESCRAP;
  public String w_xMADESCRI;
  public String gPathApp;
  public String gAzienda;
  public String gFileName;
  public String gDescAzi;
  public String gUrlApp;
  public String gMsgImp;
  public String prova;
  public String foglio;
  public String nomefile;
  public String stringa;
  public String numero;
  public String f_datsca;
  public String f_datini;
  public String f_datfin;
  public String f_datnas;
  public String codfisc;
  public String nominativo;
  public String indirizzo;
  public String citres;
  public String capres;
  public String cabres;
  public String prvres;
  public String stares;
  public String citnas;
  public String prvnas;
  public String stanas;
  public String sesso;
  public String datnas;
  public java.sql.Date _datnas;
  public String tipdoc;
  public String autril;
  public String numdoc;
  public String datril;
  public java.sql.Date _datril;
  public String _testa;
  public String _sqr;
  public String _coddip;
  public String _namdip;
  public String _citdip;
  public String _nomman;
  public String _cogman;
  public String _nazben;
  public String _luonas;
  public String _tipdoc;
  public String _numdoc;
  public String f_datdoc;
  public String _autril;
  public String _email;
  public String _numtel;
  public String _flgmail;
  public String _rapporto;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_wu_stp_rapporti
  public int _i;
  public int _y;
  public int _righe;
  public int conta;
  public int _conta;
  public int r;
  public int cell_count;
  public String sheetName = "Foglio1";
  public String[] lista;
  public String[] campi;
  public int conteggio;
  public int i;
  public int contanome;
  public int nfogli;
  public int ncampi;
  public SXSSFWorkbook wb;
  public SXSSFSheet sheet;
  public Row row; 
  public Cell cell;
  public CellStyle cs;
  public Font f;
  // * --- Fine Area Manuale
  public arrt_wu_stp_rapportiR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_wu_stp_rapporti",m_Caller);
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_tbtipdoc = p_ContextObject.GetPhName("tbtipdoc");
    if (m_cPhName_tbtipdoc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbtipdoc = m_cPhName_tbtipdoc+" "+m_Ctx.GetWritePhName("tbtipdoc");
    }
    m_cServer_tbtipdoc = p_ContextObject.GetServer("tbtipdoc");
    m_cPhName_docfrabo = p_ContextObject.GetPhName("docfrabo");
    if (m_cPhName_docfrabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_docfrabo = m_cPhName_docfrabo+" "+m_Ctx.GetWritePhName("docfrabo");
    }
    m_cServer_docfrabo = p_ContextObject.GetServer("docfrabo");
    m_cPhName_kersonbo = p_ContextObject.GetPhName("kersonbo");
    if (m_cPhName_kersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_kersonbo = m_cPhName_kersonbo+" "+m_Ctx.GetWritePhName("kersonbo");
    }
    m_cServer_kersonbo = p_ContextObject.GetServer("kersonbo");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    if (m_cPhName_tbstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstati = m_cPhName_tbstati+" "+m_Ctx.GetWritePhName("tbstati");
    }
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_cPhName_tmp_newpers = p_ContextObject.GetPhName("tmp_newpers");
    if (m_cPhName_tmp_newpers.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_newpers = m_cPhName_tmp_newpers+" "+m_Ctx.GetWritePhName("tmp_newpers");
    }
    m_cServer_tmp_newpers = p_ContextObject.GetServer("tmp_newpers");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_wu_stp_rapporti";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("codrap",p_cVarName)) {
      return w_codrap;
    }
    if (CPLib.eqr("WUCODMAGE",p_cVarName)) {
      return w_WUCODMAGE;
    }
    if (CPLib.eqr("xDESCRAP",p_cVarName)) {
      return w_xDESCRAP;
    }
    if (CPLib.eqr("xMADESCRI",p_cVarName)) {
      return w_xMADESCRI;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gFileName",p_cVarName)) {
      return gFileName;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      return gDescAzi;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("prova",p_cVarName)) {
      return prova;
    }
    if (CPLib.eqr("foglio",p_cVarName)) {
      return foglio;
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      return nomefile;
    }
    if (CPLib.eqr("stringa",p_cVarName)) {
      return stringa;
    }
    if (CPLib.eqr("numero",p_cVarName)) {
      return numero;
    }
    if (CPLib.eqr("f_datsca",p_cVarName)) {
      return f_datsca;
    }
    if (CPLib.eqr("f_datini",p_cVarName)) {
      return f_datini;
    }
    if (CPLib.eqr("f_datfin",p_cVarName)) {
      return f_datfin;
    }
    if (CPLib.eqr("f_datnas",p_cVarName)) {
      return f_datnas;
    }
    if (CPLib.eqr("codfisc",p_cVarName)) {
      return codfisc;
    }
    if (CPLib.eqr("nominativo",p_cVarName)) {
      return nominativo;
    }
    if (CPLib.eqr("indirizzo",p_cVarName)) {
      return indirizzo;
    }
    if (CPLib.eqr("citres",p_cVarName)) {
      return citres;
    }
    if (CPLib.eqr("capres",p_cVarName)) {
      return capres;
    }
    if (CPLib.eqr("cabres",p_cVarName)) {
      return cabres;
    }
    if (CPLib.eqr("prvres",p_cVarName)) {
      return prvres;
    }
    if (CPLib.eqr("stares",p_cVarName)) {
      return stares;
    }
    if (CPLib.eqr("citnas",p_cVarName)) {
      return citnas;
    }
    if (CPLib.eqr("prvnas",p_cVarName)) {
      return prvnas;
    }
    if (CPLib.eqr("stanas",p_cVarName)) {
      return stanas;
    }
    if (CPLib.eqr("sesso",p_cVarName)) {
      return sesso;
    }
    if (CPLib.eqr("datnas",p_cVarName)) {
      return datnas;
    }
    if (CPLib.eqr("tipdoc",p_cVarName)) {
      return tipdoc;
    }
    if (CPLib.eqr("autril",p_cVarName)) {
      return autril;
    }
    if (CPLib.eqr("numdoc",p_cVarName)) {
      return numdoc;
    }
    if (CPLib.eqr("datril",p_cVarName)) {
      return datril;
    }
    if (CPLib.eqr("_testa",p_cVarName)) {
      return _testa;
    }
    if (CPLib.eqr("_sqr",p_cVarName)) {
      return _sqr;
    }
    if (CPLib.eqr("_coddip",p_cVarName)) {
      return _coddip;
    }
    if (CPLib.eqr("_namdip",p_cVarName)) {
      return _namdip;
    }
    if (CPLib.eqr("_citdip",p_cVarName)) {
      return _citdip;
    }
    if (CPLib.eqr("_nomman",p_cVarName)) {
      return _nomman;
    }
    if (CPLib.eqr("_cogman",p_cVarName)) {
      return _cogman;
    }
    if (CPLib.eqr("_nazben",p_cVarName)) {
      return _nazben;
    }
    if (CPLib.eqr("_luonas",p_cVarName)) {
      return _luonas;
    }
    if (CPLib.eqr("_tipdoc",p_cVarName)) {
      return _tipdoc;
    }
    if (CPLib.eqr("_numdoc",p_cVarName)) {
      return _numdoc;
    }
    if (CPLib.eqr("f_datdoc",p_cVarName)) {
      return f_datdoc;
    }
    if (CPLib.eqr("_autril",p_cVarName)) {
      return _autril;
    }
    if (CPLib.eqr("_email",p_cVarName)) {
      return _email;
    }
    if (CPLib.eqr("_numtel",p_cVarName)) {
      return _numtel;
    }
    if (CPLib.eqr("_flgmail",p_cVarName)) {
      return _flgmail;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      return _rapporto;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_datnas",p_cVarName)) {
      return _datnas;
    }
    if (CPLib.eqr("_datril",p_cVarName)) {
      return _datril;
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("codrap",p_cVarName)) {
      w_codrap = value;
      return;
    }
    if (CPLib.eqr("WUCODMAGE",p_cVarName)) {
      w_WUCODMAGE = value;
      return;
    }
    if (CPLib.eqr("xDESCRAP",p_cVarName)) {
      w_xDESCRAP = value;
      return;
    }
    if (CPLib.eqr("xMADESCRI",p_cVarName)) {
      w_xMADESCRI = value;
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
    if (CPLib.eqr("gFileName",p_cVarName)) {
      gFileName = value;
      return;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      gDescAzi = value;
      return;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      gUrlApp = value;
      return;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
      return;
    }
    if (CPLib.eqr("prova",p_cVarName)) {
      prova = value;
      return;
    }
    if (CPLib.eqr("foglio",p_cVarName)) {
      foglio = value;
      return;
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      nomefile = value;
      return;
    }
    if (CPLib.eqr("stringa",p_cVarName)) {
      stringa = value;
      return;
    }
    if (CPLib.eqr("numero",p_cVarName)) {
      numero = value;
      return;
    }
    if (CPLib.eqr("f_datsca",p_cVarName)) {
      f_datsca = value;
      return;
    }
    if (CPLib.eqr("f_datini",p_cVarName)) {
      f_datini = value;
      return;
    }
    if (CPLib.eqr("f_datfin",p_cVarName)) {
      f_datfin = value;
      return;
    }
    if (CPLib.eqr("f_datnas",p_cVarName)) {
      f_datnas = value;
      return;
    }
    if (CPLib.eqr("codfisc",p_cVarName)) {
      codfisc = value;
      return;
    }
    if (CPLib.eqr("nominativo",p_cVarName)) {
      nominativo = value;
      return;
    }
    if (CPLib.eqr("indirizzo",p_cVarName)) {
      indirizzo = value;
      return;
    }
    if (CPLib.eqr("citres",p_cVarName)) {
      citres = value;
      return;
    }
    if (CPLib.eqr("capres",p_cVarName)) {
      capres = value;
      return;
    }
    if (CPLib.eqr("cabres",p_cVarName)) {
      cabres = value;
      return;
    }
    if (CPLib.eqr("prvres",p_cVarName)) {
      prvres = value;
      return;
    }
    if (CPLib.eqr("stares",p_cVarName)) {
      stares = value;
      return;
    }
    if (CPLib.eqr("citnas",p_cVarName)) {
      citnas = value;
      return;
    }
    if (CPLib.eqr("prvnas",p_cVarName)) {
      prvnas = value;
      return;
    }
    if (CPLib.eqr("stanas",p_cVarName)) {
      stanas = value;
      return;
    }
    if (CPLib.eqr("sesso",p_cVarName)) {
      sesso = value;
      return;
    }
    if (CPLib.eqr("datnas",p_cVarName)) {
      datnas = value;
      return;
    }
    if (CPLib.eqr("tipdoc",p_cVarName)) {
      tipdoc = value;
      return;
    }
    if (CPLib.eqr("autril",p_cVarName)) {
      autril = value;
      return;
    }
    if (CPLib.eqr("numdoc",p_cVarName)) {
      numdoc = value;
      return;
    }
    if (CPLib.eqr("datril",p_cVarName)) {
      datril = value;
      return;
    }
    if (CPLib.eqr("_testa",p_cVarName)) {
      _testa = value;
      return;
    }
    if (CPLib.eqr("_sqr",p_cVarName)) {
      _sqr = value;
      return;
    }
    if (CPLib.eqr("_coddip",p_cVarName)) {
      _coddip = value;
      return;
    }
    if (CPLib.eqr("_namdip",p_cVarName)) {
      _namdip = value;
      return;
    }
    if (CPLib.eqr("_citdip",p_cVarName)) {
      _citdip = value;
      return;
    }
    if (CPLib.eqr("_nomman",p_cVarName)) {
      _nomman = value;
      return;
    }
    if (CPLib.eqr("_cogman",p_cVarName)) {
      _cogman = value;
      return;
    }
    if (CPLib.eqr("_nazben",p_cVarName)) {
      _nazben = value;
      return;
    }
    if (CPLib.eqr("_luonas",p_cVarName)) {
      _luonas = value;
      return;
    }
    if (CPLib.eqr("_tipdoc",p_cVarName)) {
      _tipdoc = value;
      return;
    }
    if (CPLib.eqr("_numdoc",p_cVarName)) {
      _numdoc = value;
      return;
    }
    if (CPLib.eqr("f_datdoc",p_cVarName)) {
      f_datdoc = value;
      return;
    }
    if (CPLib.eqr("_autril",p_cVarName)) {
      _autril = value;
      return;
    }
    if (CPLib.eqr("_email",p_cVarName)) {
      _email = value;
      return;
    }
    if (CPLib.eqr("_numtel",p_cVarName)) {
      _numtel = value;
      return;
    }
    if (CPLib.eqr("_flgmail",p_cVarName)) {
      _flgmail = value;
      return;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      _rapporto = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("_datnas",p_cVarName)) {
      _datnas = value;
      return;
    }
    if (CPLib.eqr("_datril",p_cVarName)) {
      _datril = value;
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
    CPResultSet Cursor_qbe_wu_stp_rapporti=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* w_codrap Char(16) // Rapporto */
      /* w_WUCODMAGE Char(5) // MacroAgente */
      /* w_xDESCRAP Char(50) // Descrizione */
      /* w_xMADESCRI Char(60) // Denominazione */
      /* gPathApp Char(80) // Path Applicazione */
      /* gAzienda Char(10) // Azienda */
      /* gFileName Char(80) // NomeFile */
      /* gDescAzi Char(70) // Descrizione Intermediario */
      /* gUrlApp Char(80) // URL Applicazione */
      /* gMsgImp Char(120) // Messaggio Import */
      /* prova Char(1) */
      /* foglio Char(1) */
      /* nomefile Char(50) */
      /* stringa Char(1) */
      /* numero Char(1) */
      /* f_datsca Char(10) */
      /* f_datini Char(10) */
      /* f_datfin Char(10) */
      /* f_datnas Char(10) */
      /* codfisc Char(16) */
      /* nominativo Char(70) */
      /* indirizzo Char(35) */
      /* citres Char(40) */
      /* capres Char(5) */
      /* cabres Char(6) */
      /* prvres Char(2) */
      /* stares Char(40) */
      /* citnas Char(40) */
      /* prvnas Char(2) */
      /* stanas Char(40) */
      /* sesso Char(40) */
      /* datnas Char(8) */
      /* _datnas Date */
      /* tipdoc Char(2) */
      /* autril Char(30) */
      /* numdoc Char(15) */
      /* datril Char(8) */
      /* _datril Date */
      /* _testa Char(50) */
      /* _sqr Char(1) */
      /* _coddip Char(6) */
      /* _namdip Char(40) */
      /* _citdip Char(40) */
      /* _nomman Char(30) */
      /* _cogman Char(30) */
      /* _nazben Char(30) */
      /* _luonas Char(40) */
      /* _tipdoc Char(20) */
      /* _numdoc Char(20) */
      /* f_datdoc Char(10) */
      /* _autril Char(30) */
      /* _email Char(50) */
      /* _numtel Char(50) */
      /* _flgmail Char(1) */
      /* _rapporto Char(25) */
      /* _testa := LRTrim(gAzienda)+"_rapporti_"+w_WUCODMAGE+"_"+DateToChar(Date())+".xlsx" */
      _testa = CPLib.LRTrim(gAzienda)+"_rapporti_"+w_WUCODMAGE+"_"+CPLib.DateToChar(CPLib.Date())+".xlsx";
      /* nomefile := LRTrim(gPathApp)+"/export/"+LRTrim(gAzienda)+"/"+LRTrim(_testa) */
      nomefile = CPLib.LRTrim(gPathApp)+"/export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_testa);
      /* gFileName := _testa // NomeFile */
      gFileName = _testa;
      m_Ctx.SetGlobalString("gFileName",gFileName);
      // creo il contenitore dei fogli
      wb = new SXSSFWorkbook();
      sheet = (SXSSFSheet) wb.createSheet("Foglio1") ;
      CellStyle cs = wb.createCellStyle();
      cs.setFillForegroundColor(IndexedColors.LIME.getIndex());
      cs.setFillPattern(FillPatternType.SOLID_FOREGROUND);
      Font f = wb.createFont();
      f.setBold(true);
      f.setFontHeightInPoints((short) 11);
      cs.setFont(f);
      //Azzero i contatori di fogli letti e righe scritte
      _i = 0;
      r=0;
      //Creo il record da scrivere
      row = sheet.createRow(r);
      cell =  row.createCell(0);
      cell.setCellValue("CODICE FISCALE");
      cell.setCellStyle(cs);
      cell = row.createCell(1);
      cell.setCellValue("COGNOME");
      cell.setCellStyle(cs);
      cell = row.createCell(2);
      cell.setCellValue("NOME");
      cell.setCellStyle(cs);
      cell =  row.createCell(3);
      cell.setCellValue("SESSO");
      cell.setCellStyle(cs);
      cell =  row.createCell(4);
      cell.setCellValue("DATA DI NASCITA");
      cell.setCellStyle(cs);
      cell =  row.createCell(5);
      cell.setCellValue("LUOGO DI NASCITA");
      cell.setCellStyle(cs);
      cell =  row.createCell(6);
      cell.setCellValue("PROVINCIA DI NASCITA");
      cell.setCellStyle(cs);
      cell =  row.createCell(7);
      cell.setCellValue("DOMICILIO");
      cell.setCellStyle(cs);
      cell = row.createCell(8);
      cell.setCellValue("CITTA'");
      cell.setCellStyle(cs);
      cell = row.createCell(9);
      cell.setCellValue("CAP");
      cell.setCellStyle(cs);
      cell = row.createCell(10);
      cell.setCellValue("PROVINCIA");
      cell.setCellStyle(cs);
      cell = row.createCell(11);
      cell.setCellValue("CAB");
      cell.setCellStyle(cs);
      cell = row.createCell(12);
      cell.setCellValue("PAESE");
      cell.setCellStyle(cs);
      cell = row.createCell(13);
      cell.setCellValue("TIPO DOCUMENTO");
      cell.setCellStyle(cs);
      cell = row.createCell(14);
      cell.setCellValue("NUMERO DOCUMENTOI");
      cell.setCellStyle(cs);
      cell = row.createCell(15);
      cell.setCellValue("AUTORITA' DI RILASCIO");
      cell.setCellStyle(cs);
      cell = row.createCell(16);
      cell.setCellValue("DATA RILASCIO");
      cell.setCellStyle(cs);
      cell = row.createCell(17);
      cell.setCellValue("DATA SCADENZA");
      cell.setCellStyle(cs);
      cell = row.createCell(18);
      cell.setCellValue("DATA INIZIO RAPPORTO");
      cell.setCellStyle(cs);
      cell = row.createCell(19);
      cell.setCellValue("DATA FINE RAPPORTO");
      cell.setCellStyle(cs);
      cell = row.createCell(20);
      cell.setCellValue("EMAIL");
      cell.setCellStyle(cs);
      cell = row.createCell(21);
      cell.setCellValue("CONSENSO EMAIL");
      cell.setCellStyle(cs);
      cell = row.createCell(22);
      cell.setCellValue("TELEFONO");
      cell.setCellStyle(cs);
      cell = row.createCell(23);
      cell.setCellValue("CODICE RAPPORTO");
      cell.setCellStyle(cs);
      r++;
      /* Seleziona i record */
      // * --- Select from qbe_wu_stp_rapporti
      SPBridge.HMCaller _h00000043;
      _h00000043 = new SPBridge.HMCaller();
      _h00000043.Set("m_cVQRList",m_cVQRList);
      _h00000043.Set("WUCODMAGE",w_WUCODMAGE);
      _h00000043.Set("xMADESCRI",w_xMADESCRI);
      _h00000043.Set("codrap",w_codrap);
      _h00000043.Set("descazi",gDescAzi);
      if (Cursor_qbe_wu_stp_rapporti!=null)
        Cursor_qbe_wu_stp_rapporti.Close();
      Cursor_qbe_wu_stp_rapporti = new VQRHolder("qbe_wu_stp_rapporti",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000043,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_wu_stp_rapporti.Eof())) {
        /* gMsgImp := 'Elaborazione del rapporto con codice: '+LRTrim(qbe_wu_stp_rapporti->RAPPORTO) // Messaggio Import */
        gMsgImp = "Elaborazione del rapporto con codice: "+CPLib.LRTrim(Cursor_qbe_wu_stp_rapporti.GetString("RAPPORTO"));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* codfisc := qbe_wu_stp_rapporti->CODFISC */
        codfisc = Cursor_qbe_wu_stp_rapporti.GetString("CODFISC");
        /* _cogman := qbe_wu_stp_rapporti->COGNOME */
        _cogman = Cursor_qbe_wu_stp_rapporti.GetString("COGNOME");
        /* _nomman := qbe_wu_stp_rapporti->NOME */
        _nomman = Cursor_qbe_wu_stp_rapporti.GetString("NOME");
        /* citnas := qbe_wu_stp_rapporti->NASCOMUN */
        citnas = Cursor_qbe_wu_stp_rapporti.GetString("NASCOMUN");
        /* prvnas := qbe_wu_stp_rapporti->TIPINTER */
        prvnas = Cursor_qbe_wu_stp_rapporti.GetString("TIPINTER");
        /* stanas := qbe_wu_stp_rapporti->NASSTATO */
        stanas = Cursor_qbe_wu_stp_rapporti.GetString("NASSTATO");
        /* sesso := iif(qbe_wu_stp_rapporti->SESSO='1','Uomo',iif(qbe_wu_stp_rapporti->SESSO='2','Donna','')) */
        sesso = (CPLib.eqr(Cursor_qbe_wu_stp_rapporti.GetString("SESSO"),"1")?"Uomo":(CPLib.eqr(Cursor_qbe_wu_stp_rapporti.GetString("SESSO"),"2")?"Donna":""));
        /* datnas := DateToChar(qbe_wu_stp_rapporti->DATANASC) */
        datnas = CPLib.DateToChar(Cursor_qbe_wu_stp_rapporti.GetDate("DATANASC"));
        /* _datnas := qbe_wu_stp_rapporti->DATANASC */
        _datnas = Cursor_qbe_wu_stp_rapporti.GetDate("DATANASC");
        /* f_datnas := arfn_fdate(qbe_wu_stp_rapporti->DATANASC) */
        f_datnas = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_wu_stp_rapporti.GetDate("DATANASC"));
        /* _luonas := iif(prvnas='EE' or prvnas='',stanas,citnas) */
        _luonas = (CPLib.eqr(prvnas,"EE") || CPLib.eqr(prvnas,"")?stanas:citnas);
        /* indirizzo := qbe_wu_stp_rapporti->DOMICILIO */
        indirizzo = Cursor_qbe_wu_stp_rapporti.GetString("DOMICILIO");
        /* citres := qbe_wu_stp_rapporti->DESCCIT */
        citres = Cursor_qbe_wu_stp_rapporti.GetString("DESCCIT");
        /* capres := qbe_wu_stp_rapporti->CAP */
        capres = Cursor_qbe_wu_stp_rapporti.GetString("CAP");
        /* prvres := qbe_wu_stp_rapporti->PROVINCIA */
        prvres = Cursor_qbe_wu_stp_rapporti.GetString("PROVINCIA");
        /* cabres := qbe_wu_stp_rapporti->CODCAB */
        cabres = Cursor_qbe_wu_stp_rapporti.GetString("CODCAB");
        /* stares := qbe_wu_stp_rapporti->DESCPAESE */
        stares = Cursor_qbe_wu_stp_rapporti.GetString("DESCPAESE");
        /* _tipdoc := qbe_wu_stp_rapporti->DESCRI */
        _tipdoc = Cursor_qbe_wu_stp_rapporti.GetString("DESCRI");
        /* f_datdoc := arfn_fdate(qbe_wu_stp_rapporti->DATARILASC) */
        f_datdoc = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_wu_stp_rapporti.GetDate("DATARILASC"));
        /* _autril := qbe_wu_stp_rapporti->AUTRILASC */
        _autril = Cursor_qbe_wu_stp_rapporti.GetString("AUTRILASC");
        /* _numdoc := qbe_wu_stp_rapporti->NUMDOCUM */
        _numdoc = Cursor_qbe_wu_stp_rapporti.GetString("NUMDOCUM");
        /* f_datsca := arfn_fdate(qbe_wu_stp_rapporti->DATAVALI) */
        f_datsca = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_wu_stp_rapporti.GetDate("DATAVALI"));
        /* f_datini := arfn_fdate(qbe_wu_stp_rapporti->DATAINI) */
        f_datini = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_wu_stp_rapporti.GetDate("DATAINI"));
        /* f_datfin := arfn_fdate(qbe_wu_stp_rapporti->DATAFINE) */
        f_datfin = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_wu_stp_rapporti.GetDate("DATAFINE"));
        /* _email := qbe_wu_stp_rapporti->EMAIL */
        _email = Cursor_qbe_wu_stp_rapporti.GetString("EMAIL");
        /* _numtel := qbe_wu_stp_rapporti->TELEFONO */
        _numtel = Cursor_qbe_wu_stp_rapporti.GetString("TELEFONO");
        /* _flgmail := qbe_wu_stp_rapporti->FLGEMAIL */
        _flgmail = Cursor_qbe_wu_stp_rapporti.GetString("FLGEMAIL");
        /* _rapporto := qbe_wu_stp_rapporti->RAPPORTO */
        _rapporto = Cursor_qbe_wu_stp_rapporti.GetString("RAPPORTO");
        // Scrive la riga
        row = sheet.createRow(r);
        cell = row.createCell(0);
        cell.setCellValue(CPLib.LRTrim(codfisc));
        cell = row.createCell(1);
        cell.setCellValue(CPLib.LRTrim(_cogman));
        cell = row.createCell(2);
        cell.setCellValue(CPLib.LRTrim(_nomman));
        cell = row.createCell(3);
        cell.setCellValue(CPLib.LRTrim(sesso));
        cell = row.createCell(4);
        cell.setCellValue(CPLib.LRTrim(f_datnas));
        cell = row.createCell(5);
        cell.setCellValue(CPLib.LRTrim(_luonas));
        cell = row.createCell(6);
        cell.setCellValue(CPLib.LRTrim(prvnas));
        cell = row.createCell(7);
        cell.setCellValue(CPLib.LRTrim(indirizzo));
        cell = row.createCell(8);
        cell.setCellValue(CPLib.LRTrim(citres));
        cell = row.createCell(9);
        cell.setCellValue(CPLib.LRTrim(capres));
        cell = row.createCell(10);
        cell.setCellValue(CPLib.LRTrim(prvres));
        cell = row.createCell(11);
        cell.setCellValue(CPLib.LRTrim(cabres));
        cell = row.createCell(12);
        cell.setCellValue(CPLib.LRTrim(stares));
        cell = row.createCell(13);
        cell.setCellValue(CPLib.LRTrim(_tipdoc));
        cell = row.createCell(14);
        cell.setCellValue(CPLib.LRTrim(_numdoc));
        cell = row.createCell(15);
        cell.setCellValue(CPLib.LRTrim(_autril));
        cell = row.createCell(16);;
        cell.setCellValue(CPLib.LRTrim(f_datdoc));
        cell = row.createCell(17);
        cell.setCellValue(CPLib.LRTrim(f_datsca));
        cell = row.createCell(18);
        cell.setCellValue(CPLib.LRTrim(f_datini));
        cell = row.createCell(19);
        cell.setCellValue(CPLib.LRTrim(f_datfin));
        cell = row.createCell(20);
        cell.setCellValue(CPLib.LRTrim(_email));
        cell = row.createCell(21);
        cell.setCellValue(CPLib.LRTrim(_flgmail));
        cell = row.createCell(22);
        cell.setCellValue(CPLib.LRTrim(_numtel));
        cell = row.createCell(23);
        cell.setCellValue(CPLib.LRTrim(_rapporto));
        r++;
        Cursor_qbe_wu_stp_rapporti.Next();
      }
      m_cConnectivityError = Cursor_qbe_wu_stp_rapporti.ErrorMessage();
      Cursor_qbe_wu_stp_rapporti.Close();
      // * --- End Select
      //Ridimensiono le colonne in base al contenuto
      sheet.trackAllColumnsForAutoSizing() ;
      sheet.autoSizeColumn(0);
      sheet.autoSizeColumn(1);
      sheet.autoSizeColumn(2);
      sheet.autoSizeColumn(3);
      sheet.autoSizeColumn(4);
      sheet.autoSizeColumn(5);
      sheet.autoSizeColumn(6);
      sheet.autoSizeColumn(7);
      sheet.autoSizeColumn(8);
      sheet.autoSizeColumn(9);
      sheet.autoSizeColumn(10);
      sheet.autoSizeColumn(11);
      sheet.autoSizeColumn(12);
      sheet.autoSizeColumn(13);
      sheet.autoSizeColumn(14);
      sheet.autoSizeColumn(15);
      sheet.autoSizeColumn(16);
      sheet.autoSizeColumn(17);
      sheet.autoSizeColumn(18);
      sheet.autoSizeColumn(19);
      sheet.autoSizeColumn(20);
      sheet.autoSizeColumn(21);
      sheet.autoSizeColumn(22);
      sheet.autoSizeColumn(23);
      // scrivo il file di esito
      FileOutputStream fileOut = new FileOutputStream(CPLib.LRTrim(nomefile));
      //write this workbook to an Outputstream.
      wb.write(fileOut);
      fileOut.flush();
      fileOut.close();
      /* gMsgImp := 'Elaborazione Terminata!' // Messaggio Import */
      gMsgImp = "Elaborazione Terminata!";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* Return _testa */
      throw new Stop(_testa);
    } finally {
      try {
        if (Cursor_qbe_wu_stp_rapporti!=null)
          Cursor_qbe_wu_stp_rapporti.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_w_codrap,String p_w_WUCODMAGE,String p_w_xDESCRAP,String p_w_xMADESCRI) {
    w_codrap = p_w_codrap;
    w_WUCODMAGE = p_w_WUCODMAGE;
    w_xDESCRAP = p_w_xDESCRAP;
    w_xMADESCRI = p_w_xMADESCRI;
    return CPAsyncRoutine.CreateAsyncAndStart(
    new CPAsyncRoutine.AsyncRunnable() {
      public void Compute(CPAsyncRoutine.AsyncResult p_oResult) {
        try {
          p_oResult.m_oResult=new Stop(Run());
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
  public String Run(String p_w_codrap,String p_w_WUCODMAGE,String p_w_xDESCRAP,String p_w_xMADESCRI) {
    w_codrap = p_w_codrap;
    w_WUCODMAGE = p_w_WUCODMAGE;
    w_xDESCRAP = p_w_xDESCRAP;
    w_xMADESCRI = p_w_xMADESCRI;
    return Run();
  }
  public String Run() {
    String l_result;
    l_result = "";
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
      } catch(Stop stop_value) {
        l_result = stop_value.GetString();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = "";
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
    return l_result;
  }
  public static arrt_wu_stp_rapportiR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_wu_stp_rapportiR(p_Ctx, p_Caller);
  }
  public static arrt_wu_stp_rapportiR Make(CPContext p_Ctx) {
    return new arrt_wu_stp_rapportiR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    w_codrap = CPLib.Space(16);
    w_WUCODMAGE = CPLib.Space(5);
    w_xDESCRAP = CPLib.Space(50);
    w_xMADESCRI = CPLib.Space(60);
    prova = CPLib.Space(1);
    foglio = CPLib.Space(1);
    nomefile = CPLib.Space(50);
    stringa = CPLib.Space(1);
    numero = CPLib.Space(1);
    f_datsca = CPLib.Space(10);
    f_datini = CPLib.Space(10);
    f_datfin = CPLib.Space(10);
    f_datnas = CPLib.Space(10);
    codfisc = CPLib.Space(16);
    nominativo = CPLib.Space(70);
    indirizzo = CPLib.Space(35);
    citres = CPLib.Space(40);
    capres = CPLib.Space(5);
    cabres = CPLib.Space(6);
    prvres = CPLib.Space(2);
    stares = CPLib.Space(40);
    citnas = CPLib.Space(40);
    prvnas = CPLib.Space(2);
    stanas = CPLib.Space(40);
    sesso = CPLib.Space(40);
    datnas = CPLib.Space(8);
    _datnas = CPLib.NullDate();
    tipdoc = CPLib.Space(2);
    autril = CPLib.Space(30);
    numdoc = CPLib.Space(15);
    datril = CPLib.Space(8);
    _datril = CPLib.NullDate();
    _testa = CPLib.Space(50);
    _sqr = CPLib.Space(1);
    _coddip = CPLib.Space(6);
    _namdip = CPLib.Space(40);
    _citdip = CPLib.Space(40);
    _nomman = CPLib.Space(30);
    _cogman = CPLib.Space(30);
    _nazben = CPLib.Space(30);
    _luonas = CPLib.Space(40);
    _tipdoc = CPLib.Space(20);
    _numdoc = CPLib.Space(20);
    f_datdoc = CPLib.Space(10);
    _autril = CPLib.Space(30);
    _email = CPLib.Space(50);
    _numtel = CPLib.Space(50);
    _flgmail = CPLib.Space(1);
    _rapporto = CPLib.Space(25);
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gFileName=m_Ctx.GetGlobalString("gFileName");
    gDescAzi=m_Ctx.GetGlobalString("gDescAzi");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_wu_stp_rapporti,
  public static final String m_cVQRList = ",qbe_wu_stp_rapporti,";
  // ENTITY_BATCHES: ,arfn_fdate,arrt_wu_stp_rapporti,
  public static final String i_InvokedRoutines = ",arfn_fdate,arrt_wu_stp_rapporti,";
  public static String[] m_cRunParameterNames={"w_codrap","w_WUCODMAGE","w_xDESCRAP","w_xMADESCRI"};
}
