// * --- Area Manuale = BO - Header
// * --- arrt_estrai_fraz
import java.io.File; 
import java.lang.Double;

import jxl.CellReferenceHelper;
import jxl.CellView;
import jxl.HeaderFooter;
import jxl.Range;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.Orientation;
import jxl.format.PageOrder;
import jxl.format.PageOrientation;
import jxl.format.PaperSize;
import jxl.format.ScriptStyle;
import jxl.format.UnderlineStyle;
import jxl.write.Blank;
import jxl.write.Boolean;
import jxl.write.DateFormat;
import jxl.write.DateFormats;
import jxl.write.DateTime;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.NumberFormat;
import jxl.write.NumberFormats;
import jxl.write.WritableCellFeatures;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableHyperlink;
import jxl.write.WritableImage;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
// * --- Fine Area Manuale
public class arrt_estrai_frazR implements CallerWithObjs {
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
  public java.sql.Date w_dadata;
  public java.sql.Date w_adata;
  public String w_cdadata;
  public String w_c_adata;
  public String w_cCODFISC;
  public String w_cDIP;
  public String w_cMTCN;
  public String w_xdesdip;
  public String gPathApp;
  public String gUrlApp;
  public String _dadata;
  public String _a_data;
  public String prova;
  public String foglio;
  public String nomefile;
  public String stringa;
  public String numero;
  public String dData;
  public String dataoggi;
  public String numprog;
  public String datareg;
  public java.sql.Date _datareg;
  public String dataope;
  public java.sql.Date _dataope;
  public String f_datope;
  public String f_datnas;
  public String tipope;
  public String cauana;
  public String causin;
  public String segno;
  public String valuta;
  public String divisa;
  public double cambio;
  public double totimp;
  public double totcon;
  public String codfisc;
  public String nominativo;
  public String indirizzo;
  public String citres;
  public String capres;
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
  // * --- Area Manuale = BO - Properties
  // * --- arrt_estrai_fraz
  public int riga;
  public DateTime dt;
  // * --- Fine Area Manuale
  public arrt_estrai_frazR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_estrai_fraz",m_Caller);
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
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("cambio",p_cVarName)) {
      return cambio;
    }
    if (CPLib.eqr("totimp",p_cVarName)) {
      return totimp;
    }
    if (CPLib.eqr("totcon",p_cVarName)) {
      return totcon;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_estrai_fraz";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("cdadata",p_cVarName)) {
      return w_cdadata;
    }
    if (CPLib.eqr("c_adata",p_cVarName)) {
      return w_c_adata;
    }
    if (CPLib.eqr("cCODFISC",p_cVarName)) {
      return w_cCODFISC;
    }
    if (CPLib.eqr("cDIP",p_cVarName)) {
      return w_cDIP;
    }
    if (CPLib.eqr("cMTCN",p_cVarName)) {
      return w_cMTCN;
    }
    if (CPLib.eqr("xdesdip",p_cVarName)) {
      return w_xdesdip;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
    }
    if (CPLib.eqr("_dadata",p_cVarName)) {
      return _dadata;
    }
    if (CPLib.eqr("_a_data",p_cVarName)) {
      return _a_data;
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
    if (CPLib.eqr("dData",p_cVarName)) {
      return dData;
    }
    if (CPLib.eqr("dataoggi",p_cVarName)) {
      return dataoggi;
    }
    if (CPLib.eqr("numprog",p_cVarName)) {
      return numprog;
    }
    if (CPLib.eqr("datareg",p_cVarName)) {
      return datareg;
    }
    if (CPLib.eqr("dataope",p_cVarName)) {
      return dataope;
    }
    if (CPLib.eqr("f_datope",p_cVarName)) {
      return f_datope;
    }
    if (CPLib.eqr("f_datnas",p_cVarName)) {
      return f_datnas;
    }
    if (CPLib.eqr("tipope",p_cVarName)) {
      return tipope;
    }
    if (CPLib.eqr("cauana",p_cVarName)) {
      return cauana;
    }
    if (CPLib.eqr("causin",p_cVarName)) {
      return causin;
    }
    if (CPLib.eqr("segno",p_cVarName)) {
      return segno;
    }
    if (CPLib.eqr("valuta",p_cVarName)) {
      return valuta;
    }
    if (CPLib.eqr("divisa",p_cVarName)) {
      return divisa;
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
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("dadata",p_cVarName)) {
      return w_dadata;
    }
    if (CPLib.eqr("adata",p_cVarName)) {
      return w_adata;
    }
    if (CPLib.eqr("_datareg",p_cVarName)) {
      return _datareg;
    }
    if (CPLib.eqr("_dataope",p_cVarName)) {
      return _dataope;
    }
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
    if (CPLib.eqr("cambio",p_cVarName)) {
      cambio = value;
      return;
    }
    if (CPLib.eqr("totimp",p_cVarName)) {
      totimp = value;
      return;
    }
    if (CPLib.eqr("totcon",p_cVarName)) {
      totcon = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("cdadata",p_cVarName)) {
      w_cdadata = value;
      return;
    }
    if (CPLib.eqr("c_adata",p_cVarName)) {
      w_c_adata = value;
      return;
    }
    if (CPLib.eqr("cCODFISC",p_cVarName)) {
      w_cCODFISC = value;
      return;
    }
    if (CPLib.eqr("cDIP",p_cVarName)) {
      w_cDIP = value;
      return;
    }
    if (CPLib.eqr("cMTCN",p_cVarName)) {
      w_cMTCN = value;
      return;
    }
    if (CPLib.eqr("xdesdip",p_cVarName)) {
      w_xdesdip = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      gUrlApp = value;
      return;
    }
    if (CPLib.eqr("_dadata",p_cVarName)) {
      _dadata = value;
      return;
    }
    if (CPLib.eqr("_a_data",p_cVarName)) {
      _a_data = value;
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
    if (CPLib.eqr("dData",p_cVarName)) {
      dData = value;
      return;
    }
    if (CPLib.eqr("dataoggi",p_cVarName)) {
      dataoggi = value;
      return;
    }
    if (CPLib.eqr("numprog",p_cVarName)) {
      numprog = value;
      return;
    }
    if (CPLib.eqr("datareg",p_cVarName)) {
      datareg = value;
      return;
    }
    if (CPLib.eqr("dataope",p_cVarName)) {
      dataope = value;
      return;
    }
    if (CPLib.eqr("f_datope",p_cVarName)) {
      f_datope = value;
      return;
    }
    if (CPLib.eqr("f_datnas",p_cVarName)) {
      f_datnas = value;
      return;
    }
    if (CPLib.eqr("tipope",p_cVarName)) {
      tipope = value;
      return;
    }
    if (CPLib.eqr("cauana",p_cVarName)) {
      cauana = value;
      return;
    }
    if (CPLib.eqr("causin",p_cVarName)) {
      causin = value;
      return;
    }
    if (CPLib.eqr("segno",p_cVarName)) {
      segno = value;
      return;
    }
    if (CPLib.eqr("valuta",p_cVarName)) {
      valuta = value;
      return;
    }
    if (CPLib.eqr("divisa",p_cVarName)) {
      divisa = value;
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
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("dadata",p_cVarName)) {
      w_dadata = value;
      return;
    }
    if (CPLib.eqr("adata",p_cVarName)) {
      w_adata = value;
      return;
    }
    if (CPLib.eqr("_datareg",p_cVarName)) {
      _datareg = value;
      return;
    }
    if (CPLib.eqr("_dataope",p_cVarName)) {
      _dataope = value;
      return;
    }
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
    CPResultSet Cursor_qbe_estrai_frz=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_kersonbo=null;
    CPResultSet Read_Cursor=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* w_dadata Date */
      /* w_adata Date */
      /* w_cdadata Char(8) */
      /* w_c_adata Char(8) */
      /* w_cCODFISC Char(16) */
      /* w_cDIP Char(5) */
      /* w_cMTCN Char(10) */
      /* w_xdesdip Char(30) // Descrizione */
      /* Variabili Globali */
      /* gPathApp Char(80) // Path Applicazione */
      /* gUrlApp Char(80) // URL Applicazione */
      /* gUrlApp Char(80) // URL Applicazione */
      /* _dadata Char(10) */
      /* _a_data Char(10) */
      /* prova Char(1) */
      /* foglio Char(1) */
      /* nomefile Char(50) */
      /* stringa Char(1) */
      /* numero Char(1) */
      /* dData Char(1) */
      /* dataoggi Char(8) */
      /* numprog Char(11) */
      /* datareg Char(8) */
      /* _datareg Date */
      /* dataope Char(8) */
      /* _dataope Date */
      /* f_datope Char(10) */
      /* f_datnas Char(10) */
      /* tipope Char(2) */
      /* cauana Char(4) */
      /* causin Char(4) */
      /* segno Char(1) */
      /* valuta Char(6) */
      /* divisa Char(30) */
      /* cambio Numeric(15, 10) */
      /* totimp Numeric(15, 2) */
      /* totcon Numeric(15, 2) */
      /* codfisc Char(16) */
      /* nominativo Char(70) */
      /* indirizzo Char(35) */
      /* citres Char(40) */
      /* capres Char(5) */
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
      /* dataoggi := DateToChar(Date()) */
      dataoggi = CPLib.DateToChar(CPLib.Date());
      /* _testa := "frazionate_"+dataoggi+".xls" */
      _testa = "frazionate_"+dataoggi+".xls";
      /* nomefile := LRTrim(gPathApp)+"/export/"+LRTrim(_testa) */
      nomefile = CPLib.LRTrim(gPathApp)+"/export/"+CPLib.LRTrim(_testa);
      // Crea il foglio e scrive la testata
      WorkbookSettings ws = new WorkbookSettings();
      WritableWorkbook prova = Workbook.createWorkbook(new File(nomefile), ws);
      WritableSheet foglio = prova.createSheet("Elenco Frazionate dal "+_dadata+" al "+_a_data, 0);
      WritableFont arial11font = new WritableFont(WritableFont.ARIAL, 11, WritableFont.BOLD, true);
      WritableCellFormat arial11format = new WritableCellFormat (arial11font);
      WritableCellFormat intNum = new WritableCellFormat(NumberFormats.INTEGER);
      WritableCellFormat dblNum = new WritableCellFormat(NumberFormats.FLOAT);
      DateFormat df = new DateFormat("dd-mm-yyyy");
      WritableCellFormat cf1 = new WritableCellFormat(df);
      Label stringa = new Label(0,0,"SQR",arial11format);
      foglio.addCell(stringa); 
      stringa = new Label(1,0,"AGENZIA",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(2,0,"INDIRIZZO",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(3,0,"CITTA'",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(4,0,"IMPORTO TRASFERITO",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(5,0,"COGNOME MANDATARIO",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(6,0,"NOME MANDATARIO",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(7,0,"SESSO",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(8,0,"LUOGO DI NASCITA",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(9,0,"DATA DI NASCITA",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(10,0,"CODICE FISCALE",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(11,0,"DOCUMENTO",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(12,0,"N° DOCUMENTO",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(13,0,"LUOGO DI RILASCIO",arial11format);
      foglio.addCell(stringa); 
      stringa = new Label(14,0,"AUTORITA'",arial11format);
      foglio.addCell(stringa); 
      stringa = new Label(15,0,"MTCN",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(16,0,"DATA OPERAZIONE",arial11format);
      foglio.addCell(stringa); 
      stringa = new Label(17,0,"NOMINATIVO BENEFICIARIO",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(18,0,"STATO",arial11format);
      foglio.addCell(stringa); 
      riga = 2;
      // * --- Select from qbe_estrai_frz
      if (Cursor_qbe_estrai_frz!=null)
        Cursor_qbe_estrai_frz.Close();
      Cursor_qbe_estrai_frz = new VQRHolder("qbe_estrai_frz",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_estrai_frz.Eof())) {
        /* _sqr := iif(qbe_estrai_frz->SEGNO='A','S','P') */
        _sqr = (CPLib.eqr(Cursor_qbe_estrai_frz.GetString("SEGNO"),"A")?"S":"P");
        /* _coddip := qbe_estrai_frz->CODDIPE */
        _coddip = Cursor_qbe_estrai_frz.GetString("CODDIPE");
        /* _namdip := qbe_estrai_frz->DESCRIZ */
        _namdip = Cursor_qbe_estrai_frz.GetString("DESCRIZ");
        /* _citdip := qbe_estrai_frz->DESCCIT */
        _citdip = Cursor_qbe_estrai_frz.GetString("DESCCIT");
        // * --- Select from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
        Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_estrai_frz.GetString("CONNESCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_personbo.Eof())) {
          /* codfisc := personbo->CODFISC */
          codfisc = Cursor_personbo.GetString("CODFISC");
          /* _cogman := personbo->COGNOME */
          _cogman = Cursor_personbo.GetString("COGNOME");
          /* _nomman := personbo->NOME */
          _nomman = Cursor_personbo.GetString("NOME");
          /* citnas := personbo->NASCOMUN */
          citnas = Cursor_personbo.GetString("NASCOMUN");
          /* prvnas := personbo->TIPINTER */
          prvnas = Cursor_personbo.GetString("TIPINTER");
          /* stanas := personbo->NASSTATO */
          stanas = Cursor_personbo.GetString("NASSTATO");
          /* sesso := iif(personbo->SESSO='1','Uomo',iif(personbo->SESSO='2','Donna','')) */
          sesso = (CPLib.eqr(Cursor_personbo.GetString("SESSO"),"1")?"Uomo":(CPLib.eqr(Cursor_personbo.GetString("SESSO"),"2")?"Donna":""));
          /* datnas := DateToChar(personbo->DATANASC) */
          datnas = CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC"));
          /* _datnas := personbo->DATANASC */
          _datnas = Cursor_personbo.GetDate("DATANASC");
          /* f_datnas := arfn_fdate(personbo->DATANASC) */
          f_datnas = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_personbo.GetDate("DATANASC"));
          /* _luonas := iif(prvnas='EE' or prvnas='',stanas,citnas) */
          _luonas = (CPLib.eqr(prvnas,"EE") || CPLib.eqr(prvnas,"")?stanas:citnas);
          Cursor_personbo.Next();
        }
        m_cConnectivityError = Cursor_personbo.ErrorMessage();
        Cursor_personbo.Close();
        // * --- End Select
        // * --- Select from kersonbo
        m_cServer = m_Ctx.GetServer("kersonbo");
        m_cPhName = m_Ctx.GetPhName("kersonbo");
        if (Cursor_kersonbo!=null)
          Cursor_kersonbo.Close();
        Cursor_kersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_estrai_frz.GetString("CONNESDOC"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("kersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_kersonbo.Eof())) {
          /* _tipdoc := '' */
          _tipdoc = "";
          // * --- Read from tbtipdoc
          m_cServer = m_Ctx.GetServer("tbtipdoc");
          m_cPhName = m_Ctx.GetPhName("tbtipdoc");
          m_cSql = "";
          m_cSql = m_cSql+"TIPDOC="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_kersonbo.GetString("TIPODOC"),"C",2,0,m_cServer),m_cServer,Cursor_kersonbo.GetString("TIPODOC"));
          if (m_Ctx.IsSharedTemp("tbtipdoc")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _tipdoc = Read_Cursor.GetString("DESCRI");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on tbtipdoc into routine arrt_estrai_fraz returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _tipdoc = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* f_datdoc := arfn_fdate(kersonbo->DATARILASC) */
          f_datdoc = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_kersonbo.GetDate("DATARILASC"));
          /* _autril := kersonbo->AUTRILASC */
          _autril = Cursor_kersonbo.GetString("AUTRILASC");
          /* _numdoc := kersonbo->NUMDOCUM */
          _numdoc = Cursor_kersonbo.GetString("NUMDOCUM");
          Cursor_kersonbo.Next();
        }
        m_cConnectivityError = Cursor_kersonbo.ErrorMessage();
        Cursor_kersonbo.Close();
        // * --- End Select
        /* numprog := qbe_estrai_frz->MTCN */
        numprog = Cursor_qbe_estrai_frz.GetString("MTCN");
        /* dataope := DateToChar(qbe_estrai_frz->DATAOPE) */
        dataope = CPLib.DateToChar(Cursor_qbe_estrai_frz.GetDate("DATAOPE"));
        /* _dataope := qbe_estrai_frz->DATAOPE */
        _dataope = Cursor_qbe_estrai_frz.GetDate("DATAOPE");
        /* f_datope := arfn_fdate(qbe_estrai_frz->DATAOPE) */
        f_datope = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_estrai_frz.GetDate("DATAOPE"));
        /* totimp := qbe_estrai_frz->TOTLIRE / 100 */
        totimp = CPLib.Round(Cursor_qbe_estrai_frz.GetDouble("TOTLIRE")/100,2);
        /* nominativo := qbe_estrai_frz->C_RAG */
        nominativo = Cursor_qbe_estrai_frz.GetString("C_RAG");
        /* _nazben := qbe_estrai_frz->C_STA */
        _nazben = Cursor_qbe_estrai_frz.GetString("C_STA");
        // Scrive i dati
        stringa = new Label(0,riga,_sqr);
        foglio.addCell(stringa); 
        stringa = new Label(1,riga,_namdip);
        foglio.addCell(stringa);
        stringa = new Label(2,riga,"");
        foglio.addCell(stringa); 
        stringa = new Label(3,riga,_citdip);
        foglio.addCell(stringa);
        Number num1 = new Number(4,riga,totimp,dblNum);
        foglio.addCell(num1);
        stringa = new Label(5,riga,_cogman);
        foglio.addCell(stringa);
        stringa = new Label(6,riga,_nomman);
        foglio.addCell(stringa);
        stringa = new Label(7,riga,sesso);
        foglio.addCell(stringa);
        stringa = new Label(8,riga,_luonas);
        foglio.addCell(stringa);
        stringa = new Label(9,riga,f_datnas);
        foglio.addCell(stringa);
        stringa = new Label(10,riga,codfisc);
        foglio.addCell(stringa);
        stringa = new Label(11,riga,_tipdoc);
        foglio.addCell(stringa);
        stringa = new Label(12,riga,_numdoc);
        foglio.addCell(stringa);
        stringa = new Label(13,riga,f_datdoc);
        foglio.addCell(stringa);
        stringa = new Label(14,riga,_autril);
        foglio.addCell(stringa);
        stringa = new Label(15,riga,numprog);
        foglio.addCell(stringa); 
        stringa = new Label(16,riga,f_datope);
        foglio.addCell(stringa); 
        stringa = new Label(17,riga,nominativo);
        foglio.addCell(stringa);
        stringa = new Label(18,riga,_nazben);
        foglio.addCell(stringa); 
        riga = riga + 1;
        Cursor_qbe_estrai_frz.Next();
      }
      m_cConnectivityError = Cursor_qbe_estrai_frz.ErrorMessage();
      Cursor_qbe_estrai_frz.Close();
      // * --- End Select
      //Aggiusta le colonne
      CellView cf = new CellView();
      cf.setAutosize(true);
      foglio.setColumnView(0, cf);
      foglio.setColumnView(1, cf);
      foglio.setColumnView(2, cf);
      foglio.setColumnView(3, cf);
      foglio.setColumnView(4, cf);
      foglio.setColumnView(5, cf);
      foglio.setColumnView(6, cf);
      foglio.setColumnView(7, cf);
      foglio.setColumnView(8, cf);
      foglio.setColumnView(9, cf);
      foglio.setColumnView(10, cf);
      foglio.setColumnView(11, cf);
      foglio.setColumnView(12, cf);
      foglio.setColumnView(13, cf);
      foglio.setColumnView(14, cf);
      foglio.setColumnView(15, cf);
      foglio.setColumnView(16, cf);
      foglio.setColumnView(17, cf);
      foglio.setColumnView(18, cf);
      prova.write();
      prova.close();
      /* Stop LRTrim(gUrlApp)+"/export/"+LRTrim(_testa) */
      Forward f;
      f=new Forward(CPLib.LRTrim(gUrlApp)+"/export/"+CPLib.LRTrim(_testa),false,this,Forward.NoStatus,true);
      f.SetParameter("m_cParameterSequence", "");
      f.SetParameter("m_cMode","hyperlink");
      throw f;
    } finally {
      try {
        if (Cursor_qbe_estrai_frz!=null)
          Cursor_qbe_estrai_frz.Close();
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
        if (Cursor_kersonbo!=null)
          Cursor_kersonbo.Close();
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
      m_Caller.SetDate("dadata","D",8,0,w_dadata);
      m_Caller.SetDate("adata","D",8,0,w_adata);
      m_Caller.SetString("cdadata","C",8,0,w_cdadata);
      m_Caller.SetString("c_adata","C",8,0,w_c_adata);
      m_Caller.SetString("cCODFISC","C",16,0,w_cCODFISC);
      m_Caller.SetString("cDIP","C",5,0,w_cDIP);
      m_Caller.SetString("cMTCN","C",10,0,w_cMTCN);
      m_Caller.SetString("xdesdip","C",30,0,w_xdesdip);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_estrai_frazR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_estrai_frazR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_dadata = m_Caller.GetDate("dadata","D",8,0);
    w_adata = m_Caller.GetDate("adata","D",8,0);
    w_cdadata = m_Caller.GetString("cdadata","C",8,0);
    w_c_adata = m_Caller.GetString("c_adata","C",8,0);
    w_cCODFISC = m_Caller.GetString("cCODFISC","C",16,0);
    w_cDIP = m_Caller.GetString("cDIP","C",5,0);
    w_cMTCN = m_Caller.GetString("cMTCN","C",10,0);
    w_xdesdip = m_Caller.GetString("xdesdip","C",30,0);
    _dadata = CPLib.Space(10);
    _a_data = CPLib.Space(10);
    prova = CPLib.Space(1);
    foglio = CPLib.Space(1);
    nomefile = CPLib.Space(50);
    stringa = CPLib.Space(1);
    numero = CPLib.Space(1);
    dData = CPLib.Space(1);
    dataoggi = CPLib.Space(8);
    numprog = CPLib.Space(11);
    datareg = CPLib.Space(8);
    _datareg = CPLib.NullDate();
    dataope = CPLib.Space(8);
    _dataope = CPLib.NullDate();
    f_datope = CPLib.Space(10);
    f_datnas = CPLib.Space(10);
    tipope = CPLib.Space(2);
    cauana = CPLib.Space(4);
    causin = CPLib.Space(4);
    segno = CPLib.Space(1);
    valuta = CPLib.Space(6);
    divisa = CPLib.Space(30);
    cambio = 0;
    totimp = 0;
    totcon = 0;
    codfisc = CPLib.Space(16);
    nominativo = CPLib.Space(70);
    indirizzo = CPLib.Space(35);
    citres = CPLib.Space(40);
    capres = CPLib.Space(5);
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
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_estrai_frz,
  public static final String m_cVQRList = ",qbe_estrai_frz,";
  // ENTITY_BATCHES: ,arfn_fdate,
  public static final String i_InvokedRoutines = ",arfn_fdate,";
  public static String[] m_cRunParameterNames={};
}
