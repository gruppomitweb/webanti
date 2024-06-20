// * --- Area Manuale = BO - Header
// * --- arrt_stpfraz_xls
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
public class arrt_stpfraz_xlsR implements CallerWithObjs {
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
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
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
  public java.sql.Date w_DaDatOpe;
  public java.sql.Date w_ADatOpe;
  public String w_daCodCli;
  public String w_aCodCli;
  public String w_tipstp;
  public String w_c_adata;
  public String w_c_dadata;
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
  public String _c_rag;
  public String _c_sta;
  public String _c_dsta;
  public String _c_cta;
  public String _c_ind;
  public String _c_cap;
  public String _c_prv;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_stpfraz_xls
  public int riga;
  public DateTime dt;
  // * --- Fine Area Manuale
  public arrt_stpfraz_xlsR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_stpfraz_xls",m_Caller);
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    if (m_cPhName_tbstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstati = m_cPhName_tbstati+" "+m_Ctx.GetWritePhName("tbstati");
    }
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
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
      return "arrt_stpfraz_xls";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("daCodCli",p_cVarName)) {
      return w_daCodCli;
    }
    if (CPLib.eqr("aCodCli",p_cVarName)) {
      return w_aCodCli;
    }
    if (CPLib.eqr("tipstp",p_cVarName)) {
      return w_tipstp;
    }
    if (CPLib.eqr("c_adata",p_cVarName)) {
      return w_c_adata;
    }
    if (CPLib.eqr("c_dadata",p_cVarName)) {
      return w_c_dadata;
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
    if (CPLib.eqr("_c_rag",p_cVarName)) {
      return _c_rag;
    }
    if (CPLib.eqr("_c_sta",p_cVarName)) {
      return _c_sta;
    }
    if (CPLib.eqr("_c_dsta",p_cVarName)) {
      return _c_dsta;
    }
    if (CPLib.eqr("_c_cta",p_cVarName)) {
      return _c_cta;
    }
    if (CPLib.eqr("_c_ind",p_cVarName)) {
      return _c_ind;
    }
    if (CPLib.eqr("_c_cap",p_cVarName)) {
      return _c_cap;
    }
    if (CPLib.eqr("_c_prv",p_cVarName)) {
      return _c_prv;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("DaDatOpe",p_cVarName)) {
      return w_DaDatOpe;
    }
    if (CPLib.eqr("ADatOpe",p_cVarName)) {
      return w_ADatOpe;
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
    if (CPLib.eqr("daCodCli",p_cVarName)) {
      w_daCodCli = value;
      return;
    }
    if (CPLib.eqr("aCodCli",p_cVarName)) {
      w_aCodCli = value;
      return;
    }
    if (CPLib.eqr("tipstp",p_cVarName)) {
      w_tipstp = value;
      return;
    }
    if (CPLib.eqr("c_adata",p_cVarName)) {
      w_c_adata = value;
      return;
    }
    if (CPLib.eqr("c_dadata",p_cVarName)) {
      w_c_dadata = value;
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
    if (CPLib.eqr("_c_rag",p_cVarName)) {
      _c_rag = value;
      return;
    }
    if (CPLib.eqr("_c_sta",p_cVarName)) {
      _c_sta = value;
      return;
    }
    if (CPLib.eqr("_c_dsta",p_cVarName)) {
      _c_dsta = value;
      return;
    }
    if (CPLib.eqr("_c_cta",p_cVarName)) {
      _c_cta = value;
      return;
    }
    if (CPLib.eqr("_c_ind",p_cVarName)) {
      _c_ind = value;
      return;
    }
    if (CPLib.eqr("_c_cap",p_cVarName)) {
      _c_cap = value;
      return;
    }
    if (CPLib.eqr("_c_prv",p_cVarName)) {
      _c_prv = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("DaDatOpe",p_cVarName)) {
      w_DaDatOpe = value;
      return;
    }
    if (CPLib.eqr("ADatOpe",p_cVarName)) {
      w_ADatOpe = value;
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
    CPResultSet Cursor_qbe_stpfrazana_xls=null;
    CPResultSet Read_Cursor=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Variabili del caller */
      /* w_DaDatOpe Date */
      /* w_ADatOpe Date */
      /* w_daCodCli Char(16) */
      /* w_aCodCli Char(16) */
      /* w_tipstp Char(1) */
      /* w_c_adata Char(8) */
      /* w_c_dadata Char(8) */
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
      /* _c_rag Char(70) */
      /* _c_sta Char(3) */
      /* _c_dsta Char(40) */
      /* _c_cta Char(40) */
      /* _c_ind Char(35) */
      /* _c_cap Char(5) */
      /* _c_prv Char(2) */
      /* dataoggi := DateToChar(Date()) */
      dataoggi = CPLib.DateToChar(CPLib.Date());
      /* _testa := "frazionate_"+dataoggi+".xls" */
      _testa = "frazionate_"+dataoggi+".xls";
      /* nomefile := LRTrim(gPathApp)+"/export/"+LRTrim(_testa) */
      nomefile = CPLib.LRTrim(gPathApp)+"/export/"+CPLib.LRTrim(_testa);
      /* _dadata := arfn_fdate(w_DaDatOpe) */
      _dadata = arfn_fdateR.Make(m_Ctx,this).Run(w_DaDatOpe);
      /* _a_data := arfn_fdate(w_ADatOpe) */
      _a_data = arfn_fdateR.Make(m_Ctx,this).Run(w_ADatOpe);
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
      Label stringa = new Label(0,0,"N° Progressivo.",arial11format);
      foglio.addCell(stringa); 
      stringa = new Label(1,0,"Data Operazione",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(2,0,"Tipo Operazione",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(3,0,"Causale Analitica",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(4,0,"Causale Sintetica",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(5,0,"Segno",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(6,0,"Valuta",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(7,0,"Divisa",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(8,0,"Cambio",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(9,0,"Totale Operazione",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(10,0,"Contanti",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(11,0,"Cod. Fiscale",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(12,0,"Nominativo",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(13,0,"Città Nascita",arial11format);
      foglio.addCell(stringa); 
      stringa = new Label(14,0,"Provincia Nascita",arial11format);
      foglio.addCell(stringa); 
      stringa = new Label(15,0,"Stato Nascita",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(16,0,"Data Nascita",arial11format);
      foglio.addCell(stringa); 
      stringa = new Label(17,0,"Sesso",arial11format);
      foglio.addCell(stringa); 
      stringa = new Label(18,0,"Beneficiario",arial11format);
      foglio.addCell(stringa); 
      stringa = new Label(19,0,"Stato Beneficiario",arial11format);
      foglio.addCell(stringa); 
      stringa = new Label(20,0,"Città Beneficiario",arial11format);
      foglio.addCell(stringa); 
      stringa = new Label(21,0,"Indirizzo Beneficiario",arial11format);
      foglio.addCell(stringa); 
      stringa = new Label(22,0,"CAP Beneficiario",arial11format);
      foglio.addCell(stringa); 
      stringa = new Label(23,0,"Prov. Beneficiario",arial11format);
      foglio.addCell(stringa); 
      riga = 2;
      /* Legge i dati dalla query e scrive le righe */
      // * --- Select from qbe_stpfrazana_xls
      if (Cursor_qbe_stpfrazana_xls!=null)
        Cursor_qbe_stpfrazana_xls.Close();
      Cursor_qbe_stpfrazana_xls = new VQRHolder("qbe_stpfrazana_xls",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_stpfrazana_xls.Eof())) {
        /* numprog := qbe_stpfrazana_xls->NUMPROG */
        numprog = Cursor_qbe_stpfrazana_xls.GetString("NUMPROG");
        /* dataope := DateToChar(qbe_stpfrazana_xls->DATAOPE) */
        dataope = CPLib.DateToChar(Cursor_qbe_stpfrazana_xls.GetDate("DATAOPE"));
        /* _dataope := qbe_stpfrazana_xls->DATAOPE */
        _dataope = Cursor_qbe_stpfrazana_xls.GetDate("DATAOPE");
        /* f_datope := arfn_fdate(qbe_stpfrazana_xls->DATAOPE) */
        f_datope = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_stpfrazana_xls.GetDate("DATAOPE"));
        /* tipope := qbe_stpfrazana_xls->TIPOOPRAP */
        tipope = Cursor_qbe_stpfrazana_xls.GetString("TIPOOPRAP");
        /* cauana := qbe_stpfrazana_xls->CODANA */
        cauana = Cursor_qbe_stpfrazana_xls.GetString("CODANA");
        /* causin := qbe_stpfrazana_xls->CODVOC */
        causin = Cursor_qbe_stpfrazana_xls.GetString("CODVOC");
        /* segno := qbe_stpfrazana_xls->SEGNO */
        segno = Cursor_qbe_stpfrazana_xls.GetString("SEGNO");
        /* valuta := iif(qbe_stpfrazana_xls->VALUTA='242','Euro',iif(qbe_stpfrazana_xls->VALUTA='018','Lire','Altro')) */
        valuta = (CPLib.eqr(Cursor_qbe_stpfrazana_xls.GetString("VALUTA"),"242")?"Euro":(CPLib.eqr(Cursor_qbe_stpfrazana_xls.GetString("VALUTA"),"018")?"Lire":"Altro"));
        /* divisa := qbe_stpfrazana_xls->DESCRI1 */
        divisa = Cursor_qbe_stpfrazana_xls.GetString("DESCRI1");
        /* cambio := qbe_stpfrazana_xls->CAMBIO */
        cambio = CPLib.Round(Cursor_qbe_stpfrazana_xls.GetDouble("CAMBIO"),10);
        /* totimp := qbe_stpfrazana_xls->TOTEURO */
        totimp = CPLib.Round(Cursor_qbe_stpfrazana_xls.GetDouble("TOTEURO"),2);
        /* totcon := qbe_stpfrazana_xls->TOTCONT */
        totcon = CPLib.Round(Cursor_qbe_stpfrazana_xls.GetDouble("TOTCONT"),2);
        /* codfisc := qbe_stpfrazana_xls->CODFISC */
        codfisc = Cursor_qbe_stpfrazana_xls.GetString("CODFISC");
        /* nominativo := qbe_stpfrazana_xls->RAGSOC */
        nominativo = Cursor_qbe_stpfrazana_xls.GetString("RAGSOC");
        /* citnas := qbe_stpfrazana_xls->NASCOMUN */
        citnas = Cursor_qbe_stpfrazana_xls.GetString("NASCOMUN");
        /* prvnas := qbe_stpfrazana_xls->NASPROV */
        prvnas = Cursor_qbe_stpfrazana_xls.GetString("NASPROV");
        /* stanas := qbe_stpfrazana_xls->NASSTATO */
        stanas = Cursor_qbe_stpfrazana_xls.GetString("NASSTATO");
        /* sesso := iif(qbe_stpfrazana_xls->SESSO='1','Uomo',iif(qbe_stpfrazana_xls->SESSO='2','Donna','')) */
        sesso = (CPLib.eqr(Cursor_qbe_stpfrazana_xls.GetString("SESSO"),"1")?"Uomo":(CPLib.eqr(Cursor_qbe_stpfrazana_xls.GetString("SESSO"),"2")?"Donna":""));
        /* datnas := DateToChar(qbe_stpfrazana_xls->DATANASC) */
        datnas = CPLib.DateToChar(Cursor_qbe_stpfrazana_xls.GetDate("DATANASC"));
        /* _datnas := qbe_stpfrazana_xls->DATANASC */
        _datnas = Cursor_qbe_stpfrazana_xls.GetDate("DATANASC");
        /* f_datnas := arfn_fdate(qbe_stpfrazana_xls->DATANASC) */
        f_datnas = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_stpfrazana_xls.GetDate("DATANASC"));
        /* _c_rag := qbe_stpfrazana_xls->C_RAG */
        _c_rag = Cursor_qbe_stpfrazana_xls.GetString("C_RAG");
        /* _c_sta := qbe_stpfrazana_xls->C_STA */
        _c_sta = Cursor_qbe_stpfrazana_xls.GetString("C_STA");
        /* _c_dsta := '' */
        _c_dsta = "";
        /* If not(Empty(LRTrim(_c_sta))) */
        if ( ! (CPLib.Empty(CPLib.LRTrim(_c_sta)))) {
          // * --- Read from tbstati
          m_cServer = m_Ctx.GetServer("tbstati");
          m_cPhName = m_Ctx.GetPhName("tbstati");
          m_cSql = "";
          m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_c_sta,"C",3,0,m_cServer),m_cServer,_c_sta);
          if (m_Ctx.IsSharedTemp("tbstati")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _c_dsta = Read_Cursor.GetString("DESCRI");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on tbstati into routine arrt_stpfraz_xls returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _c_dsta = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
        } // End If
        /* _c_cta := qbe_stpfrazana_xls->C_CTA */
        _c_cta = Cursor_qbe_stpfrazana_xls.GetString("C_CTA");
        /* _c_ind := qbe_stpfrazana_xls->C_IND */
        _c_ind = Cursor_qbe_stpfrazana_xls.GetString("C_IND");
        /* _c_cap := qbe_stpfrazana_xls->C_CAP */
        _c_cap = Cursor_qbe_stpfrazana_xls.GetString("C_CAP");
        /* _c_prv := qbe_stpfrazana_xls->C_PRV */
        _c_prv = Cursor_qbe_stpfrazana_xls.GetString("C_PRV");
        // Scrive i dati
        stringa = new Label(0,riga,numprog);
        foglio.addCell(stringa); 
        stringa = new Label(1,riga,f_datope);
        foglio.addCell(stringa);
        stringa = new Label(2,riga,tipope);
        foglio.addCell(stringa); 
        stringa = new Label(3,riga,cauana);
        foglio.addCell(stringa);
        stringa = new Label(4,riga,causin);
        foglio.addCell(stringa);
        stringa = new Label(5,riga,segno);
        foglio.addCell(stringa);
        stringa = new Label(6,riga,valuta);
        foglio.addCell(stringa);
        stringa = new Label(7,riga,divisa);
        foglio.addCell(stringa);
        Number num1 = new Number(8,riga,cambio,dblNum);
        foglio.addCell(num1);
        num1 = new Number(9,riga,totimp,dblNum);
        foglio.addCell(num1);
        num1 = new Number(10,riga,totcon,dblNum);
        foglio.addCell(num1);
        stringa = new Label(11,riga,codfisc);
        foglio.addCell(stringa);
        stringa = new Label(12,riga,nominativo);
        foglio.addCell(stringa);
        stringa = new Label(13,riga,citnas);
        foglio.addCell(stringa); 
        stringa = new Label(14,riga,prvnas);
        foglio.addCell(stringa); 
        stringa = new Label(15,riga,stanas);
        foglio.addCell(stringa);
        stringa = new Label(16,riga,f_datnas);
        foglio.addCell(stringa);
        stringa = new Label(17,riga,sesso);
        foglio.addCell(stringa); 
        stringa = new Label(18,riga,_c_rag);
        foglio.addCell(stringa); 
        stringa = new Label(19,riga,_c_dsta);
        foglio.addCell(stringa); 
        stringa = new Label(20,riga,_c_cta);
        foglio.addCell(stringa); 
        stringa = new Label(21,riga,_c_ind);
        foglio.addCell(stringa); 
        stringa = new Label(22,riga,_c_cap);
        foglio.addCell(stringa); 
        stringa = new Label(23,riga,_c_prv);
        foglio.addCell(stringa); 
        riga = riga + 1;
        Cursor_qbe_stpfrazana_xls.Next();
      }
      m_cConnectivityError = Cursor_qbe_stpfrazana_xls.ErrorMessage();
      Cursor_qbe_stpfrazana_xls.Close();
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
      foglio.setColumnView(19, cf);
      foglio.setColumnView(20, cf);
      foglio.setColumnView(21, cf);
      foglio.setColumnView(22, cf);
      foglio.setColumnView(23, cf);
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
        if (Cursor_qbe_stpfrazana_xls!=null)
          Cursor_qbe_stpfrazana_xls.Close();
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
      m_Caller.SetDate("DaDatOpe","D",8,0,w_DaDatOpe);
      m_Caller.SetDate("ADatOpe","D",8,0,w_ADatOpe);
      m_Caller.SetString("daCodCli","C",16,0,w_daCodCli);
      m_Caller.SetString("aCodCli","C",16,0,w_aCodCli);
      m_Caller.SetString("tipstp","C",1,0,w_tipstp);
      m_Caller.SetString("c_adata","C",8,0,w_c_adata);
      m_Caller.SetString("c_dadata","C",8,0,w_c_dadata);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_stpfraz_xlsR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_stpfraz_xlsR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_DaDatOpe = m_Caller.GetDate("DaDatOpe","D",8,0);
    w_ADatOpe = m_Caller.GetDate("ADatOpe","D",8,0);
    w_daCodCli = m_Caller.GetString("daCodCli","C",16,0);
    w_aCodCli = m_Caller.GetString("aCodCli","C",16,0);
    w_tipstp = m_Caller.GetString("tipstp","C",1,0);
    w_c_adata = m_Caller.GetString("c_adata","C",8,0);
    w_c_dadata = m_Caller.GetString("c_dadata","C",8,0);
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
    _c_rag = CPLib.Space(70);
    _c_sta = CPLib.Space(3);
    _c_dsta = CPLib.Space(40);
    _c_cta = CPLib.Space(40);
    _c_ind = CPLib.Space(35);
    _c_cap = CPLib.Space(5);
    _c_prv = CPLib.Space(2);
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_stpfrazana_xls,
  public static final String m_cVQRList = ",qbe_stpfrazana_xls,";
  // ENTITY_BATCHES: ,arfn_fdate,
  public static final String i_InvokedRoutines = ",arfn_fdate,";
  public static String[] m_cRunParameterNames={};
}
