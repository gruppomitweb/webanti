// * --- Area Manuale = BO - Header
// * --- arrt_export_confidi
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
public class arrt_export_confidiR implements CallerWithObjs {
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
  public String m_cPhName_intestit;
  public String m_cServer_intestit;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_rapotit;
  public String m_cServer_rapotit;
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
  public String gPathApp;
  public String gAzienda;
  public String gFileName;
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
  public java.sql.Date _dataril;
  public java.sql.Date _dataval;
  public java.sql.Date _datnas;
  public String f_datnas;
  public String f_datril;
  public String f_datval;
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
  public double tipdoc;
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
  public String _numprog;
  public String _mtcn;
  public String _macage;
  public String _stator;
  public String _rapporto;
  public String _ragsoc;
  public double _sgru;
  public String _ateco;
  public String _dateco;
  public double _ncf;
  public double _pep;
  public String _cfinter;
  public String _ctinter;
  public String _cbinter;
  public String _printer;
  public String _cfditta;
  public String _idreg;
  public double _conta;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_export_confidi
  public int riga;
  public DateTime dt;
  // * --- Fine Area Manuale
  public arrt_export_confidiR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_export_confidi",m_Caller);
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
    m_cPhName_intestit = p_ContextObject.GetPhName("intestit");
    if (m_cPhName_intestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestit = m_cPhName_intestit+" "+m_Ctx.GetWritePhName("intestit");
    }
    m_cServer_intestit = p_ContextObject.GetServer("intestit");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_rapotit = p_ContextObject.GetPhName("rapotit");
    if (m_cPhName_rapotit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapotit = m_cPhName_rapotit+" "+m_Ctx.GetWritePhName("rapotit");
    }
    m_cServer_rapotit = p_ContextObject.GetServer("rapotit");
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
    if (CPLib.eqr("tipdoc",p_cVarName)) {
      return tipdoc;
    }
    if (CPLib.eqr("_sgru",p_cVarName)) {
      return _sgru;
    }
    if (CPLib.eqr("_ncf",p_cVarName)) {
      return _ncf;
    }
    if (CPLib.eqr("_pep",p_cVarName)) {
      return _pep;
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
      return "arrt_export_confidi";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
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
    if (CPLib.eqr("f_datnas",p_cVarName)) {
      return f_datnas;
    }
    if (CPLib.eqr("f_datril",p_cVarName)) {
      return f_datril;
    }
    if (CPLib.eqr("f_datval",p_cVarName)) {
      return f_datval;
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
    if (CPLib.eqr("_numprog",p_cVarName)) {
      return _numprog;
    }
    if (CPLib.eqr("_mtcn",p_cVarName)) {
      return _mtcn;
    }
    if (CPLib.eqr("_macage",p_cVarName)) {
      return _macage;
    }
    if (CPLib.eqr("_stator",p_cVarName)) {
      return _stator;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      return _rapporto;
    }
    if (CPLib.eqr("_ragsoc",p_cVarName)) {
      return _ragsoc;
    }
    if (CPLib.eqr("_ateco",p_cVarName)) {
      return _ateco;
    }
    if (CPLib.eqr("_dateco",p_cVarName)) {
      return _dateco;
    }
    if (CPLib.eqr("_cfinter",p_cVarName)) {
      return _cfinter;
    }
    if (CPLib.eqr("_ctinter",p_cVarName)) {
      return _ctinter;
    }
    if (CPLib.eqr("_cbinter",p_cVarName)) {
      return _cbinter;
    }
    if (CPLib.eqr("_printer",p_cVarName)) {
      return _printer;
    }
    if (CPLib.eqr("_cfditta",p_cVarName)) {
      return _cfditta;
    }
    if (CPLib.eqr("_idreg",p_cVarName)) {
      return _idreg;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_dataril",p_cVarName)) {
      return _dataril;
    }
    if (CPLib.eqr("_dataval",p_cVarName)) {
      return _dataval;
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
    if (CPLib.eqr("tipdoc",p_cVarName)) {
      tipdoc = value;
      return;
    }
    if (CPLib.eqr("_sgru",p_cVarName)) {
      _sgru = value;
      return;
    }
    if (CPLib.eqr("_ncf",p_cVarName)) {
      _ncf = value;
      return;
    }
    if (CPLib.eqr("_pep",p_cVarName)) {
      _pep = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
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
    if (CPLib.eqr("f_datnas",p_cVarName)) {
      f_datnas = value;
      return;
    }
    if (CPLib.eqr("f_datril",p_cVarName)) {
      f_datril = value;
      return;
    }
    if (CPLib.eqr("f_datval",p_cVarName)) {
      f_datval = value;
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
    if (CPLib.eqr("_numprog",p_cVarName)) {
      _numprog = value;
      return;
    }
    if (CPLib.eqr("_mtcn",p_cVarName)) {
      _mtcn = value;
      return;
    }
    if (CPLib.eqr("_macage",p_cVarName)) {
      _macage = value;
      return;
    }
    if (CPLib.eqr("_stator",p_cVarName)) {
      _stator = value;
      return;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      _rapporto = value;
      return;
    }
    if (CPLib.eqr("_ragsoc",p_cVarName)) {
      _ragsoc = value;
      return;
    }
    if (CPLib.eqr("_ateco",p_cVarName)) {
      _ateco = value;
      return;
    }
    if (CPLib.eqr("_dateco",p_cVarName)) {
      _dateco = value;
      return;
    }
    if (CPLib.eqr("_cfinter",p_cVarName)) {
      _cfinter = value;
      return;
    }
    if (CPLib.eqr("_ctinter",p_cVarName)) {
      _ctinter = value;
      return;
    }
    if (CPLib.eqr("_cbinter",p_cVarName)) {
      _cbinter = value;
      return;
    }
    if (CPLib.eqr("_printer",p_cVarName)) {
      _printer = value;
      return;
    }
    if (CPLib.eqr("_cfditta",p_cVarName)) {
      _cfditta = value;
      return;
    }
    if (CPLib.eqr("_idreg",p_cVarName)) {
      _idreg = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("_dataril",p_cVarName)) {
      _dataril = value;
      return;
    }
    if (CPLib.eqr("_dataval",p_cVarName)) {
      _dataval = value;
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
    /* gPathApp Char(80) // Path Applicazione */
    /* gAzienda Char(10) // Azienda */
    /* gFileName Char(80) // NomeFile */
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
    /* _dataril Date */
    /* _dataval Date */
    /* _datnas Date */
    /* f_datnas Char(10) */
    /* f_datril Char(10) */
    /* f_datval Char(10) */
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
    /* tipdoc Numeric(2, 0) */
    /* autril Char(30) */
    /* numdoc Char(15) */
    /* datril Char(8) */
    /* _datril Date */
    /* _testa Char(50) */
    /* _sqr Char(10) */
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
    /* _numprog Char(11) */
    /* _mtcn Char(10) */
    /* _macage Char(5) */
    /* _stator Char(1) */
    /* _rapporto Char(25) */
    /* _ragsoc Char(70) */
    /* _sgru Numeric(3, 0) */
    /* _ateco Char(10) */
    /* _dateco Char(300) */
    /* _ncf Numeric(1, 0) */
    /* _pep Numeric(1, 0) */
    /* _cfinter Char(16) */
    /* _ctinter Char(40) */
    /* _cbinter Char(6) */
    /* _printer Char(2) */
    /* _cfditta Char(16) */
    /* _idreg Char(20) */
    /* _conta Numeric(10, 0) */
    /* Exec "Giuridiche" Page 2:Page_2 */
    Page_2();
    /* Exec "Fisiche" Page 3:Page_3 */
    Page_3();
    /* Exec "Legami" Page 4:Page_4 */
    Page_4();
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_qbe_confidi_clienti=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _testa := "anagrafica_cliente.xls" */
      _testa = "anagrafica_cliente.xls";
      /* nomefile := LRTrim(gPathApp)+"/export/"+LRTrim(_testa) */
      nomefile = CPLib.LRTrim(gPathApp)+"/export/"+CPLib.LRTrim(_testa);
      /* gFileName := _testa // NomeFile */
      gFileName = _testa;
      m_Ctx.SetGlobalString("gFileName",gFileName);
      // Crea il foglio e scrive la testata
      WorkbookSettings ws = new WorkbookSettings();
      WritableWorkbook prova = Workbook.createWorkbook(new File(nomefile), ws);
      WritableSheet foglio = prova.createSheet("anagrafica_cliente", 0);
      WritableFont arial11font = new WritableFont(WritableFont.ARIAL, 11, WritableFont.BOLD, true);
      WritableCellFormat arial11format = new WritableCellFormat (arial11font);
      WritableCellFormat intNum = new WritableCellFormat(NumberFormats.INTEGER);
      WritableCellFormat dblNum = new WritableCellFormat(NumberFormats.FLOAT);
      DateFormat df = new DateFormat("dd-mm-yyyy");
      WritableCellFormat cf1 = new WritableCellFormat(df);
      riga=0;
      /* Seleziona i record */
      // * --- Select from qbe_confidi_clienti
      SPBridge.HMCaller _h00000057;
      _h00000057 = new SPBridge.HMCaller();
      _h00000057.Set("m_cVQRList",m_cVQRList);
      _h00000057.Set("tipoper","G");
      if (Cursor_qbe_confidi_clienti!=null)
        Cursor_qbe_confidi_clienti.Close();
      Cursor_qbe_confidi_clienti = new VQRHolder("qbe_confidi_clienti",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000057,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_confidi_clienti.Eof())) {
        /* codfisc := qbe_confidi_clienti->CODFISC */
        codfisc = Cursor_qbe_confidi_clienti.GetString("CODFISC");
        /* _ragsoc := qbe_confidi_clienti->RAGSOC */
        _ragsoc = Cursor_qbe_confidi_clienti.GetString("RAGSOC");
        /* indirizzo := qbe_confidi_clienti->DOMICILIO */
        indirizzo = Cursor_qbe_confidi_clienti.GetString("DOMICILIO");
        /* citres := qbe_confidi_clienti->DESCCIT */
        citres = Cursor_qbe_confidi_clienti.GetString("DESCCIT");
        /* capres := qbe_confidi_clienti->CAP */
        capres = Cursor_qbe_confidi_clienti.GetString("CAP");
        /* prvres := qbe_confidi_clienti->PROVINCIA */
        prvres = Cursor_qbe_confidi_clienti.GetString("PROVINCIA");
        /* stares := qbe_confidi_clienti->PAESE */
        stares = Cursor_qbe_confidi_clienti.GetString("PAESE");
        /* _sgru := Val(qbe_confidi_clienti->SOTGRUP) */
        _sgru = CPLib.Round(CPLib.Val(Cursor_qbe_confidi_clienti.GetString("SOTGRUP")),0);
        /* _ateco := iif(Empty(qbe_confidi_clienti->ATTIV),Space(8),Left(qbe_confidi_clienti->ATTIV,2)+"."+Substr(qbe_confidi_clienti->ATTIV,3,2)+"."+Substr(qbe_confidi_clienti->ATTIV,5,2)) */
        _ateco = (CPLib.Empty(Cursor_qbe_confidi_clienti.GetString("ATTIV"))?CPLib.Space(8):CPLib.Left(Cursor_qbe_confidi_clienti.GetString("ATTIV"),2)+"."+CPLib.Substr(Cursor_qbe_confidi_clienti.GetString("ATTIV"),3,2)+"."+CPLib.Substr(Cursor_qbe_confidi_clienti.GetString("ATTIV"),5,2));
        /* _dateco := LRTrim(Left(qbe_confidi_clienti->DESCRI,300)) */
        _dateco = CPLib.LRTrim(CPLib.Left(Cursor_qbe_confidi_clienti.GetString("DESCRI"),300));
        // Scrive i dati 
        Label stringa = new Label(0,riga,"7");
        foglio.addCell(stringa); 
        stringa = new Label(1,riga,_ragsoc);
        foglio.addCell(stringa);
        stringa = new Label(2,riga,citres);
        foglio.addCell(stringa); 
        stringa = new Label(3,riga,"      ");
        foglio.addCell(stringa);
        stringa = new Label(4,riga,indirizzo);
        foglio.addCell(stringa);
        Number num1 = new Number(5,riga,0,intNum);
        foglio.addCell(num1);
        stringa = new Label(6,riga,prvres);
        foglio.addCell(stringa);
        stringa = new Label(7,riga,capres);
        foglio.addCell(stringa);
        stringa = new Label(8,riga,stares);
        foglio.addCell(stringa);
        stringa = new Label(9,riga,"      ");
        foglio.addCell(stringa);
        stringa = new Label(10,riga,"      ");
        foglio.addCell(stringa);
        stringa = new Label(11,riga,"      ");
        foglio.addCell(stringa);
        stringa = new Label(12,riga,"      ");
        foglio.addCell(stringa);
        stringa = new Label(13,riga,"      ");
        foglio.addCell(stringa);
        stringa = new Label(14,riga,"      ");
        foglio.addCell(stringa);
        stringa = new Label(15,riga,codfisc);
        foglio.addCell(stringa); 
        stringa = new Label(16,riga,"      ");
        foglio.addCell(stringa); 
        stringa = new Label(17,riga,"       ");
        foglio.addCell(stringa); 
        stringa = new Label(18,riga,"      ");
        foglio.addCell(stringa); 
        num1 = new Number(19,riga,_sgru,intNum);
        foglio.addCell(num1); 
        stringa = new Label(20,riga,_ateco);
        foglio.addCell(stringa); 
        stringa = new Label(21,riga,_dateco);
        foglio.addCell(stringa); 
        num1 = new Number(22,riga,0,intNum);
        foglio.addCell(num1); 
        num1 = new Number(23,riga,0,intNum);
        foglio.addCell(num1);
        num1 = new Number(24,riga,0,dblNum);
        foglio.addCell(num1); 
        num1 = new Number(25,riga,0,dblNum);
        foglio.addCell(num1); 
        stringa = new Label(26,riga,"       ");
        foglio.addCell(stringa); 
        num1 = new Number(27,riga,0,intNum);
        foglio.addCell(num1); 
        num1 = new Number(28,riga,0,intNum);
        foglio.addCell(num1); 
        stringa = new Label(29,riga,"      ");
        foglio.addCell(stringa); 
        // Contatore Righe
        riga = riga + 1;
        Cursor_qbe_confidi_clienti.Next();
      }
      m_cConnectivityError = Cursor_qbe_confidi_clienti.ErrorMessage();
      Cursor_qbe_confidi_clienti.Close();
      // * --- End Select
      //Aggiusta le colonne
      CellView cf = new CellView();
      cf.setAutosize(true);
      foglio.setColumnView(0, cf);
      foglio.setColumnView(1, cf);
      foglio.setColumnView(2, cf);
      // foglio.setColumnView(3, cf);
      foglio.setColumnView(4, cf);
      // foglio.setColumnView(5, cf);
      // foglio.setColumnView(6, cf);
      // foglio.setColumnView(7, cf);
      // foglio.setColumnView(8, cf);
      // foglio.setColumnView(9, cf);
      // foglio.setColumnView(10, cf);
      // foglio.setColumnView(11, cf);
      // foglio.setColumnView(12, cf);
      // foglio.setColumnView(13, cf);
      // foglio.setColumnView(14, cf);
      foglio.setColumnView(15, cf);
      // foglio.setColumnView(16, cf);
      // foglio.setColumnView(17, cf);
      // foglio.setColumnView(18, cf);
      foglio.setColumnView(19, cf);
      foglio.setColumnView(20, cf);
      foglio.setColumnView(21, cf);
      // foglio.setColumnView(22, cf);
      // // foglio.setColumnView(23, cf);
      // foglio.setColumnView(24, cf);
      // foglio.setColumnView(25, cf);
      // foglio.setColumnView(26, cf);
      // foglio.setColumnView(27, cf);
      // foglio.setColumnView(28, cf);
      // foglio.setColumnView(29, cf);
      // Scrive il foglio e lo chiude
      prova.write();
      prova.close();
    } finally {
      try {
        if (Cursor_qbe_confidi_clienti!=null)
          Cursor_qbe_confidi_clienti.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_3() throws Exception {
    CPResultSet Cursor_qbe_confidi_clienti=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _testa := "anagrafica_pf.xls" */
      _testa = "anagrafica_pf.xls";
      /* nomefile := LRTrim(gPathApp)+"/export/"+LRTrim(_testa) */
      nomefile = CPLib.LRTrim(gPathApp)+"/export/"+CPLib.LRTrim(_testa);
      /* gFileName := _testa // NomeFile */
      gFileName = _testa;
      m_Ctx.SetGlobalString("gFileName",gFileName);
      // Crea il foglio e scrive la testata
      WorkbookSettings ws = new WorkbookSettings();
      WritableWorkbook prova = Workbook.createWorkbook(new File(nomefile), ws);
      WritableSheet foglio = prova.createSheet("anagrafica_pf", 0);
      WritableFont arial11font = new WritableFont(WritableFont.ARIAL, 11, WritableFont.BOLD, true);
      WritableCellFormat arial11format = new WritableCellFormat (arial11font);
      WritableCellFormat intNum = new WritableCellFormat(NumberFormats.INTEGER);
      WritableCellFormat dblNum = new WritableCellFormat(NumberFormats.FLOAT);
      DateFormat df = new DateFormat("dd-mm-yyyy");
      WritableCellFormat cf1 = new WritableCellFormat(df);
      riga=0;
      /* Seleziona i record */
      // * --- Select from qbe_confidi_clienti
      SPBridge.HMCaller _h0000006D;
      _h0000006D = new SPBridge.HMCaller();
      _h0000006D.Set("m_cVQRList",m_cVQRList);
      _h0000006D.Set("tipoper","P");
      if (Cursor_qbe_confidi_clienti!=null)
        Cursor_qbe_confidi_clienti.Close();
      Cursor_qbe_confidi_clienti = new VQRHolder("qbe_confidi_clienti",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000006D,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_confidi_clienti.Eof())) {
        /* _datnas := qbe_confidi_clienti->DATANASC */
        _datnas = Cursor_qbe_confidi_clienti.GetDate("DATANASC");
        /* f_datnas := iif(Empty(_datnas),Space(10),Left(DateToChar(_datnas),4)+"-"+Substr(DateToChar(_datnas),5,2)+"-"+Substr(DateToChar(_datnas),7,2)) */
        f_datnas = (CPLib.Empty(_datnas)?CPLib.Space(10):CPLib.Left(CPLib.DateToChar(_datnas),4)+"-"+CPLib.Substr(CPLib.DateToChar(_datnas),5,2)+"-"+CPLib.Substr(CPLib.DateToChar(_datnas),7,2));
        /* citnas := iif(not(Empty(qbe_confidi_clienti->NASSTATO)) and qbe_confidi_clienti->NASSTATO <> 'ITALIA',qbe_confidi_clienti->NASSTATO,qbe_confidi_clienti->NASCOMUN) */
        citnas = ( ! (CPLib.Empty(Cursor_qbe_confidi_clienti.GetString("NASSTATO"))) && CPLib.ne(Cursor_qbe_confidi_clienti.GetString("NASSTATO"),"ITALIA")?Cursor_qbe_confidi_clienti.GetString("NASSTATO"):Cursor_qbe_confidi_clienti.GetString("NASCOMUN"));
        /* prvnas := qbe_confidi_clienti->TIPINTER */
        prvnas = Cursor_qbe_confidi_clienti.GetString("TIPINTER");
        /* sesso := iif(qbe_confidi_clienti->SESSO='1','M','F') */
        sesso = (CPLib.eqr(Cursor_qbe_confidi_clienti.GetString("SESSO"),"1")?"M":"F");
        /* tipdoc := Val(qbe_confidi_clienti->TIPODOC) */
        tipdoc = CPLib.Round(CPLib.Val(Cursor_qbe_confidi_clienti.GetString("TIPODOC")),0);
        /* autril := qbe_confidi_clienti->AUTRILASC */
        autril = Cursor_qbe_confidi_clienti.GetString("AUTRILASC");
        /* numdoc := qbe_confidi_clienti->NUMDOCUM */
        numdoc = Cursor_qbe_confidi_clienti.GetString("NUMDOCUM");
        /* _dataril := qbe_confidi_clienti->DATARILASC */
        _dataril = Cursor_qbe_confidi_clienti.GetDate("DATARILASC");
        /* _dataval := qbe_confidi_clienti->DATAVALI */
        _dataval = Cursor_qbe_confidi_clienti.GetDate("DATAVALI");
        /* f_datril := iif(Empty(_dataril),Space(10),Left(DateToChar(_dataril),4)+"-"+Substr(DateToChar(_dataril),5,2)+"-"+Substr(DateToChar(_dataril),7,2)) */
        f_datril = (CPLib.Empty(_dataril)?CPLib.Space(10):CPLib.Left(CPLib.DateToChar(_dataril),4)+"-"+CPLib.Substr(CPLib.DateToChar(_dataril),5,2)+"-"+CPLib.Substr(CPLib.DateToChar(_dataril),7,2));
        /* f_datval := iif(Empty(_dataval),Space(10),Left(DateToChar(_dataval),4)+"-"+Substr(DateToChar(_dataval),5,2)+"-"+Substr(DateToChar(_dataval),7,2)) */
        f_datval = (CPLib.Empty(_dataval)?CPLib.Space(10):CPLib.Left(CPLib.DateToChar(_dataval),4)+"-"+CPLib.Substr(CPLib.DateToChar(_dataval),5,2)+"-"+CPLib.Substr(CPLib.DateToChar(_dataval),7,2));
        /* codfisc := qbe_confidi_clienti->CODFISC */
        codfisc = Cursor_qbe_confidi_clienti.GetString("CODFISC");
        /* _ragsoc := qbe_confidi_clienti->RAGSOC */
        _ragsoc = Cursor_qbe_confidi_clienti.GetString("RAGSOC");
        /* indirizzo := qbe_confidi_clienti->DOMICILIO */
        indirizzo = Cursor_qbe_confidi_clienti.GetString("DOMICILIO");
        /* citres := qbe_confidi_clienti->DESCCIT */
        citres = Cursor_qbe_confidi_clienti.GetString("DESCCIT");
        /* capres := qbe_confidi_clienti->CAP */
        capres = Cursor_qbe_confidi_clienti.GetString("CAP");
        /* prvres := qbe_confidi_clienti->PROVINCIA */
        prvres = Cursor_qbe_confidi_clienti.GetString("PROVINCIA");
        /* stares := qbe_confidi_clienti->PAESE */
        stares = Cursor_qbe_confidi_clienti.GetString("PAESE");
        /* _sgru := Val(qbe_confidi_clienti->SOTGRUP) */
        _sgru = CPLib.Round(CPLib.Val(Cursor_qbe_confidi_clienti.GetString("SOTGRUP")),0);
        /* _ateco := Left(qbe_confidi_clienti->ATTIV,2)+"."+Substr(qbe_confidi_clienti->ATTIV,3,2)+"."+Substr(qbe_confidi_clienti->ATTIV,5,2) */
        _ateco = CPLib.Left(Cursor_qbe_confidi_clienti.GetString("ATTIV"),2)+"."+CPLib.Substr(Cursor_qbe_confidi_clienti.GetString("ATTIV"),3,2)+"."+CPLib.Substr(Cursor_qbe_confidi_clienti.GetString("ATTIV"),5,2);
        /* _dateco := LRTrim(Left(qbe_confidi_clienti->DESCRI,300)) */
        _dateco = CPLib.LRTrim(CPLib.Left(Cursor_qbe_confidi_clienti.GetString("DESCRI"),300));
        /* _nomman := qbe_confidi_clienti->NOME */
        _nomman = Cursor_qbe_confidi_clienti.GetString("NOME");
        /* _cogman := qbe_confidi_clienti->COGNOME */
        _cogman = Cursor_qbe_confidi_clienti.GetString("COGNOME");
        /* _pep := iif(qbe_confidi_clienti->PEP='S',1,0) */
        _pep = CPLib.Round((CPLib.eqr(Cursor_qbe_confidi_clienti.GetString("PEP"),"S")?1:0),0);
        /* _ncf := qbe_confidi_clienti->CFESTERO */
        _ncf = CPLib.Round(Cursor_qbe_confidi_clienti.GetDouble("CFESTERO"),0);
        // Scrive i dati 
        Label stringa = new Label(0,riga,"6");
        foglio.addCell(stringa); 
        stringa = new Label(1,riga,sesso);
        foglio.addCell(stringa);
        stringa = new Label(2,riga,_nomman);
        foglio.addCell(stringa); 
        stringa = new Label(3,riga,_cogman);
        foglio.addCell(stringa);
        stringa = new Label(4,riga,citnas);
        foglio.addCell(stringa);
        stringa = new Label(5,riga,prvnas);
        foglio.addCell(stringa);
        stringa = new Label(6,riga,f_datnas);
        foglio.addCell(stringa);
        stringa = new Label(7,riga,citres);
        foglio.addCell(stringa);
        stringa = new Label(8,riga,prvres);
        foglio.addCell(stringa);
        stringa = new Label(9,riga,stares);
        foglio.addCell(stringa);
        stringa = new Label(10,riga,capres);
        foglio.addCell(stringa);
        stringa = new Label(11,riga,"      ");
        foglio.addCell(stringa);
        stringa = new Label(12,riga,indirizzo);
        foglio.addCell(stringa);
        Number num1 = new Number(13,riga,0,intNum);
        foglio.addCell(num1);
        stringa = new Label(14,riga,"      ");
        foglio.addCell(stringa);
        stringa = new Label(15,riga,"      ");
        foglio.addCell(stringa); 
        stringa = new Label(16,riga,"      ");
        foglio.addCell(stringa); 
        stringa = new Label(17,riga,codfisc);
        foglio.addCell(stringa); 
        num1 = new Number(18,riga,tipdoc,intNum);
        foglio.addCell(num1);
        stringa = new Label(19,riga,numdoc);
        foglio.addCell(stringa); 
        stringa = new Label(20,riga,autril);
        foglio.addCell(stringa); 
        stringa = new Label(21,riga,f_datril);
        foglio.addCell(stringa); 
        stringa = new Label(22,riga,f_datval);
        foglio.addCell(stringa); 
        num1 = new Number(23,riga,_pep,intNum);
        foglio.addCell(num1); 
        num1 = new Number(24,riga,_ncf,intNum);
        foglio.addCell(num1); 
        num1 = new Number(25,riga,541,intNum);
        foglio.addCell(num1); 
        num1 = new Number(26,riga,_sgru,intNum);
        foglio.addCell(num1); 
        stringa = new Label(27,riga,"      ");
        foglio.addCell(stringa); 
        stringa = new Label(28,riga,"      ");
        foglio.addCell(stringa); 
        num1 = new Number(29,riga,0,intNum);
        foglio.addCell(num1); 
        num1 = new Number(30,riga,0,intNum);
        foglio.addCell(num1); 
        // Contatore Righe
        riga = riga + 1;
        Cursor_qbe_confidi_clienti.Next();
      }
      m_cConnectivityError = Cursor_qbe_confidi_clienti.ErrorMessage();
      Cursor_qbe_confidi_clienti.Close();
      // * --- End Select
      // Scrive il foglio e lo chiude
      prova.write();
      prova.close();
    } finally {
      try {
        if (Cursor_qbe_confidi_clienti!=null)
          Cursor_qbe_confidi_clienti.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_4() throws Exception {
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_intestit=null;
    CPResultSet Read_Cursor=null;
    try {
      /* _testa := "anagrafica_aui_legame.xls" */
      _testa = "anagrafica_aui_legame.xls";
      /* nomefile := LRTrim(gPathApp)+"/export/"+LRTrim(_testa) */
      nomefile = CPLib.LRTrim(gPathApp)+"/export/"+CPLib.LRTrim(_testa);
      /* gFileName := _testa // NomeFile */
      gFileName = _testa;
      m_Ctx.SetGlobalString("gFileName",gFileName);
      // Crea il foglio e scrive la testata
      WorkbookSettings ws = new WorkbookSettings();
      WritableWorkbook prova = Workbook.createWorkbook(new File(nomefile), ws);
      WritableSheet foglio = prova.createSheet("anagrafica_aui_legame", 0);
      WritableFont arial11font = new WritableFont(WritableFont.ARIAL, 11, WritableFont.BOLD, true);
      WritableCellFormat arial11format = new WritableCellFormat (arial11font);
      WritableCellFormat intNum = new WritableCellFormat(NumberFormats.INTEGER);
      WritableCellFormat dblNum = new WritableCellFormat(NumberFormats.FLOAT);
      DateFormat df = new DateFormat("dd-mm-yyyy");
      WritableCellFormat cf1 = new WritableCellFormat(df);
      riga=0;
      /* Seleziona i record */
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _cfinter := intermbo->CODFISC */
        _cfinter = Cursor_intermbo.GetString("CODFISC");
        /* _ctinter := intermbo->DESCCIT */
        _ctinter = Cursor_intermbo.GetString("DESCCIT");
        /* _cbinter := intermbo->CODCAB */
        _cbinter = Cursor_intermbo.GetString("CODCAB");
        /* _printer := intermbo->PROVINCIA */
        _printer = Cursor_intermbo.GetString("PROVINCIA");
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      // * --- Select from intestit
      m_cServer = m_Ctx.GetServer("intestit");
      m_cPhName = m_Ctx.GetPhName("intestit");
      if (Cursor_intestit!=null)
        Cursor_intestit.Close();
      Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intestit")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intestit.Eof())) {
        /* _cfditta := '' */
        _cfditta = "";
        /* codfisc := '' */
        codfisc = "";
        // * --- Read from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        m_cSql = "";
        m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestit.GetString("CODCLI"),"C",16,0,m_cServer),m_cServer,Cursor_intestit.GetString("CODCLI"));
        if (m_Ctx.IsSharedTemp("personbo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _cfditta = Read_Cursor.GetString("CODFISC");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on personbo into routine arrt_export_confidi returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _cfditta = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        // * --- Read from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        m_cSql = "";
        m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestit.GetString("CODINTER"),"C",16,0,m_cServer),m_cServer,Cursor_intestit.GetString("CODINTER"));
        if (m_Ctx.IsSharedTemp("personbo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          codfisc = Read_Cursor.GetString("CODFISC");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on personbo into routine arrt_export_confidi returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          codfisc = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        // * --- Read from rapotit
        m_cServer = m_Ctx.GetServer("rapotit");
        m_cPhName = m_Ctx.GetPhName("rapotit");
        m_cSql = "";
        m_cSql = m_cSql+"NUMPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestit.GetString("NUMPROG1"),"C",11,0,m_cServer),m_cServer,Cursor_intestit.GetString("NUMPROG1"));
        if (m_Ctx.IsSharedTemp("rapotit")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DATAOPE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DATAREG",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _dataril = Read_Cursor.GetDate("DATAOPE");
          _dataval = Read_Cursor.GetDate("DATAREG");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on rapotit into routine arrt_export_confidi returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _dataril = CPLib.NullDate();
          _dataval = CPLib.NullDate();
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
        /* _idreg := DateToChar(_dataril)+Right('000000000000'+LRTrim(Str(_conta,10,0)),12) */
        _idreg = CPLib.DateToChar(_dataril)+CPLib.Right("000000000000"+CPLib.LRTrim(CPLib.Str(_conta,10,0)),12);
        /* f_datril := iif(Empty(_dataril),Space(10),Left(DateToChar(_dataril),4)+"-"+Substr(DateToChar(_dataril),5,2)+"-"+Substr(DateToChar(_dataril),7,2)) */
        f_datril = (CPLib.Empty(_dataril)?CPLib.Space(10):CPLib.Left(CPLib.DateToChar(_dataril),4)+"-"+CPLib.Substr(CPLib.DateToChar(_dataril),5,2)+"-"+CPLib.Substr(CPLib.DateToChar(_dataril),7,2));
        /* f_datval := iif(Empty(_dataval),Space(10),Left(DateToChar(_dataval),4)+"-"+Substr(DateToChar(_dataval),5,2)+"-"+Substr(DateToChar(_dataval),7,2)) */
        f_datval = (CPLib.Empty(_dataval)?CPLib.Space(10):CPLib.Left(CPLib.DateToChar(_dataval),4)+"-"+CPLib.Substr(CPLib.DateToChar(_dataval),5,2)+"-"+CPLib.Substr(CPLib.DateToChar(_dataval),7,2));
        // Scrive i dati 
        Number num1 = new Number(0,riga,16,intNum);
        foglio.addCell(num1);
        Label stringa = new Label(1,riga,_cfinter);
        foglio.addCell(stringa);
        num1 = new Number(2,riga,1,intNum);
        foglio.addCell(num1);
        stringa = new Label(3,riga,_idreg);
        foglio.addCell(stringa);
        stringa = new Label(4,riga,_cfditta);
        foglio.addCell(stringa);
        stringa = new Label(5,riga,codfisc);
        foglio.addCell(stringa);
        stringa = new Label(6,riga,"      ");
        foglio.addCell(stringa);
        stringa = new Label(7,riga,_cbinter);
        foglio.addCell(stringa);
        stringa = new Label(8,riga,_ctinter);
        foglio.addCell(stringa);
        stringa = new Label(9,riga,_printer);
        foglio.addCell(stringa);
        stringa = new Label(10,riga,f_datril);
        foglio.addCell(stringa);
        stringa = new Label(11,riga,"      ");
        foglio.addCell(stringa);
        stringa = new Label(12,riga,"5");
        foglio.addCell(stringa);
        stringa = new Label(13,riga,f_datval);
        foglio.addCell(stringa);
        num1 = new Number(14,riga,50,intNum);
        foglio.addCell(num1);
        stringa = new Label(15,riga,"      ");
        foglio.addCell(stringa); 
        stringa = new Label(16,riga,"      ");
        foglio.addCell(stringa); 
        // Contatore Righe
        riga = riga + 1;
        /* If not(Empty(intestit->DATAFINE)) */
        if ( ! (CPLib.Empty(Cursor_intestit.GetDate("DATAFINE")))) {
          /* _idreg := '' */
          _idreg = "";
          // * --- Read from rapotit
          m_cServer = m_Ctx.GetServer("rapotit");
          m_cPhName = m_Ctx.GetPhName("rapotit");
          m_cSql = "";
          m_cSql = m_cSql+"NUMPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestit.GetString("NUMPROG2"),"C",11,0,m_cServer),m_cServer,Cursor_intestit.GetString("NUMPROG2"));
          if (m_Ctx.IsSharedTemp("rapotit")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DATAOPE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DATAREG",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _dataril = Read_Cursor.GetDate("DATAOPE");
            _dataval = Read_Cursor.GetDate("DATAREG");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on rapotit into routine arrt_export_confidi returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _dataril = CPLib.NullDate();
            _dataval = CPLib.NullDate();
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* _conta := _conta + 1 */
          _conta = CPLib.Round(_conta+1,0);
          /* _idreg := DateToChar(_dataril)+Right('000000000000'+LRTrim(Str(_conta,10,0)),12) */
          _idreg = CPLib.DateToChar(_dataril)+CPLib.Right("000000000000"+CPLib.LRTrim(CPLib.Str(_conta,10,0)),12);
          /* f_datril := iif(Empty(_dataril),Space(10),Left(DateToChar(_dataril),4)+"-"+Substr(DateToChar(_dataril),5,2)+"-"+Substr(DateToChar(_dataril),7,2)) */
          f_datril = (CPLib.Empty(_dataril)?CPLib.Space(10):CPLib.Left(CPLib.DateToChar(_dataril),4)+"-"+CPLib.Substr(CPLib.DateToChar(_dataril),5,2)+"-"+CPLib.Substr(CPLib.DateToChar(_dataril),7,2));
          /* f_datval := iif(Empty(_dataval),Space(10),Left(DateToChar(_dataval),4)+"-"+Substr(DateToChar(_dataval),5,2)+"-"+Substr(DateToChar(_dataval),7,2)) */
          f_datval = (CPLib.Empty(_dataval)?CPLib.Space(10):CPLib.Left(CPLib.DateToChar(_dataval),4)+"-"+CPLib.Substr(CPLib.DateToChar(_dataval),5,2)+"-"+CPLib.Substr(CPLib.DateToChar(_dataval),7,2));
          // Scrive i dati 
          num1 = new Number(0,riga,16,intNum);
          foglio.addCell(num1);
          stringa = new Label(1,riga,_cfinter);
          foglio.addCell(stringa);
          num1 = new Number(2,riga,1,intNum);
          foglio.addCell(num1);
          stringa = new Label(3,riga,_idreg);
          foglio.addCell(stringa);
          stringa = new Label(4,riga,_cfditta);
          foglio.addCell(stringa);
          stringa = new Label(5,riga,codfisc);
          foglio.addCell(stringa);
          stringa = new Label(6,riga,"      ");
          foglio.addCell(stringa);
          stringa = new Label(7,riga,_cbinter);
          foglio.addCell(stringa);
          stringa = new Label(8,riga,_ctinter);
          foglio.addCell(stringa);
          stringa = new Label(9,riga,_printer);
          foglio.addCell(stringa);
          stringa = new Label(10,riga,f_datril);
          foglio.addCell(stringa);
          stringa = new Label(11,riga,"      ");
          foglio.addCell(stringa);
          stringa = new Label(12,riga,"5");
          foglio.addCell(stringa);
          stringa = new Label(13,riga,f_datval);
          foglio.addCell(stringa);
          num1 = new Number(14,riga,51,intNum);
          foglio.addCell(num1);
          stringa = new Label(15,riga,"      ");
          foglio.addCell(stringa); 
          stringa = new Label(16,riga,"      ");
          foglio.addCell(stringa); 
          // Contatore Righe
          riga = riga + 1;
        } // End If
        Cursor_intestit.Next();
      }
      m_cConnectivityError = Cursor_intestit.ErrorMessage();
      Cursor_intestit.Close();
      // * --- End Select
      // Scrive il foglio e lo chiude
      prova.write();
      prova.close();
    } finally {
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intestit!=null)
          Cursor_intestit.Close();
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
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_export_confidiR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_export_confidiR(p_Ctx, p_Caller);
  }
  public void Blank() {
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
    _dataril = CPLib.NullDate();
    _dataval = CPLib.NullDate();
    _datnas = CPLib.NullDate();
    f_datnas = CPLib.Space(10);
    f_datril = CPLib.Space(10);
    f_datval = CPLib.Space(10);
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
    tipdoc = 0;
    autril = CPLib.Space(30);
    numdoc = CPLib.Space(15);
    datril = CPLib.Space(8);
    _datril = CPLib.NullDate();
    _testa = CPLib.Space(50);
    _sqr = CPLib.Space(10);
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
    _numprog = CPLib.Space(11);
    _mtcn = CPLib.Space(10);
    _macage = CPLib.Space(5);
    _stator = CPLib.Space(1);
    _rapporto = CPLib.Space(25);
    _ragsoc = CPLib.Space(70);
    _sgru = 0;
    _ateco = CPLib.Space(10);
    _dateco = CPLib.Space(300);
    _ncf = 0;
    _pep = 0;
    _cfinter = CPLib.Space(16);
    _ctinter = CPLib.Space(40);
    _cbinter = CPLib.Space(6);
    _printer = CPLib.Space(2);
    _cfditta = CPLib.Space(16);
    _idreg = CPLib.Space(20);
    _conta = 0;
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gFileName=m_Ctx.GetGlobalString("gFileName");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_confidi_clienti,qbe_confidi_clienti,
  public static final String m_cVQRList = ",qbe_confidi_clienti,qbe_confidi_clienti,";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
}
