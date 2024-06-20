// * --- Area Manuale = BO - Header
// * --- arrt_stplegami_prv
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
public class arrt_stplegami_prvR implements CallerWithObjs {
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
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public String m_cPhName_tbtipdoc;
  public String m_cServer_tbtipdoc;
  public String m_cPhName_rapotit;
  public String m_cServer_rapotit;
  public String m_cPhName_delegabo;
  public String m_cServer_delegabo;
  public String m_cPhName_tbstgru;
  public String m_cServer_tbstgru;
  public String m_cPhName_tbtipatt;
  public String m_cServer_tbtipatt;
  public String m_cPhName_tbsetsin;
  public String m_cServer_tbsetsin;
  public String m_cPhName_tbramgru;
  public String m_cServer_tbramgru;
  public String m_cPhName_tmp_stplegami;
  public String m_cServer_tmp_stplegami;
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
  public String w_daSocieta;
  public String w_aSocieta;
  public java.sql.Date w_DaData;
  public java.sql.Date w_AData;
  public String w_detana;
  public String gPathApp;
  public String gUrlApp;
  public String gDescAzi;
  public String gAzienda;
  public String gMsgImp;
  public String file;
  public String foglio;
  public String nomeesito;
  public String nomefilexls;
  public String stringa;
  public String rapporto;
  public String descrap;
  public String cf;
  public String piva;
  public String dataini;
  public java.sql.Date _dataini;
  public String datafin;
  public java.sql.Date _datafin;
  public String tiprap;
  public String valuta;
  public String _ragsoc;
  public String _tipsog;
  public String connes;
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
  public String tipdoc;
  public String autril;
  public String numdoc;
  public String datril;
  public String luonas;
  public String _sae;
  public String _dsae;
  public String _ateco;
  public String _dateco;
  public String _ssin;
  public String _dssin;
  public String _rae;
  public String _drae;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_stplegami_prv
  public int riga;
  public DateTime dt;
  // * --- Fine Area Manuale
  public arrt_stplegami_prvR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_stplegami_prv",m_Caller);
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    if (m_cPhName_tbstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstati = m_cPhName_tbstati+" "+m_Ctx.GetWritePhName("tbstati");
    }
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_cPhName_tbtipdoc = p_ContextObject.GetPhName("tbtipdoc");
    if (m_cPhName_tbtipdoc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbtipdoc = m_cPhName_tbtipdoc+" "+m_Ctx.GetWritePhName("tbtipdoc");
    }
    m_cServer_tbtipdoc = p_ContextObject.GetServer("tbtipdoc");
    m_cPhName_rapotit = p_ContextObject.GetPhName("rapotit");
    if (m_cPhName_rapotit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapotit = m_cPhName_rapotit+" "+m_Ctx.GetWritePhName("rapotit");
    }
    m_cServer_rapotit = p_ContextObject.GetServer("rapotit");
    m_cPhName_delegabo = p_ContextObject.GetPhName("delegabo");
    if (m_cPhName_delegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_delegabo = m_cPhName_delegabo+" "+m_Ctx.GetWritePhName("delegabo");
    }
    m_cServer_delegabo = p_ContextObject.GetServer("delegabo");
    m_cPhName_tbstgru = p_ContextObject.GetPhName("tbstgru");
    if (m_cPhName_tbstgru.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstgru = m_cPhName_tbstgru+" "+m_Ctx.GetWritePhName("tbstgru");
    }
    m_cServer_tbstgru = p_ContextObject.GetServer("tbstgru");
    m_cPhName_tbtipatt = p_ContextObject.GetPhName("tbtipatt");
    if (m_cPhName_tbtipatt.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbtipatt = m_cPhName_tbtipatt+" "+m_Ctx.GetWritePhName("tbtipatt");
    }
    m_cServer_tbtipatt = p_ContextObject.GetServer("tbtipatt");
    m_cPhName_tbsetsin = p_ContextObject.GetPhName("tbsetsin");
    if (m_cPhName_tbsetsin.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbsetsin = m_cPhName_tbsetsin+" "+m_Ctx.GetWritePhName("tbsetsin");
    }
    m_cServer_tbsetsin = p_ContextObject.GetServer("tbsetsin");
    m_cPhName_tbramgru = p_ContextObject.GetPhName("tbramgru");
    if (m_cPhName_tbramgru.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbramgru = m_cPhName_tbramgru+" "+m_Ctx.GetWritePhName("tbramgru");
    }
    m_cServer_tbramgru = p_ContextObject.GetServer("tbramgru");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_stplegami")) {
      m_cPhName_tmp_stplegami = p_ContextObject.GetPhName("tmp_stplegami");
      if (m_cPhName_tmp_stplegami.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_stplegami = m_cPhName_tmp_stplegami+" "+m_Ctx.GetWritePhName("tmp_stplegami");
      }
      m_cServer_tmp_stplegami = p_ContextObject.GetServer("tmp_stplegami");
    }
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
      return "arrt_stplegami_prv";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("daSocieta",p_cVarName)) {
      return w_daSocieta;
    }
    if (CPLib.eqr("aSocieta",p_cVarName)) {
      return w_aSocieta;
    }
    if (CPLib.eqr("detana",p_cVarName)) {
      return w_detana;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      return gDescAzi;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("file",p_cVarName)) {
      return file;
    }
    if (CPLib.eqr("foglio",p_cVarName)) {
      return foglio;
    }
    if (CPLib.eqr("nomeesito",p_cVarName)) {
      return nomeesito;
    }
    if (CPLib.eqr("nomefilexls",p_cVarName)) {
      return nomefilexls;
    }
    if (CPLib.eqr("stringa",p_cVarName)) {
      return stringa;
    }
    if (CPLib.eqr("rapporto",p_cVarName)) {
      return rapporto;
    }
    if (CPLib.eqr("descrap",p_cVarName)) {
      return descrap;
    }
    if (CPLib.eqr("cf",p_cVarName)) {
      return cf;
    }
    if (CPLib.eqr("piva",p_cVarName)) {
      return piva;
    }
    if (CPLib.eqr("dataini",p_cVarName)) {
      return dataini;
    }
    if (CPLib.eqr("datafin",p_cVarName)) {
      return datafin;
    }
    if (CPLib.eqr("tiprap",p_cVarName)) {
      return tiprap;
    }
    if (CPLib.eqr("valuta",p_cVarName)) {
      return valuta;
    }
    if (CPLib.eqr("_ragsoc",p_cVarName)) {
      return _ragsoc;
    }
    if (CPLib.eqr("_tipsog",p_cVarName)) {
      return _tipsog;
    }
    if (CPLib.eqr("connes",p_cVarName)) {
      return connes;
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
    if (CPLib.eqr("luonas",p_cVarName)) {
      return luonas;
    }
    if (CPLib.eqr("_sae",p_cVarName)) {
      return _sae;
    }
    if (CPLib.eqr("_dsae",p_cVarName)) {
      return _dsae;
    }
    if (CPLib.eqr("_ateco",p_cVarName)) {
      return _ateco;
    }
    if (CPLib.eqr("_dateco",p_cVarName)) {
      return _dateco;
    }
    if (CPLib.eqr("_ssin",p_cVarName)) {
      return _ssin;
    }
    if (CPLib.eqr("_dssin",p_cVarName)) {
      return _dssin;
    }
    if (CPLib.eqr("_rae",p_cVarName)) {
      return _rae;
    }
    if (CPLib.eqr("_drae",p_cVarName)) {
      return _drae;
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
    if (CPLib.eqr("_dataini",p_cVarName)) {
      return _dataini;
    }
    if (CPLib.eqr("_datafin",p_cVarName)) {
      return _datafin;
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
    if (CPLib.eqr("daSocieta",p_cVarName)) {
      w_daSocieta = value;
      return;
    }
    if (CPLib.eqr("aSocieta",p_cVarName)) {
      w_aSocieta = value;
      return;
    }
    if (CPLib.eqr("detana",p_cVarName)) {
      w_detana = value;
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
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      gDescAzi = value;
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
    if (CPLib.eqr("file",p_cVarName)) {
      file = value;
      return;
    }
    if (CPLib.eqr("foglio",p_cVarName)) {
      foglio = value;
      return;
    }
    if (CPLib.eqr("nomeesito",p_cVarName)) {
      nomeesito = value;
      return;
    }
    if (CPLib.eqr("nomefilexls",p_cVarName)) {
      nomefilexls = value;
      return;
    }
    if (CPLib.eqr("stringa",p_cVarName)) {
      stringa = value;
      return;
    }
    if (CPLib.eqr("rapporto",p_cVarName)) {
      rapporto = value;
      return;
    }
    if (CPLib.eqr("descrap",p_cVarName)) {
      descrap = value;
      return;
    }
    if (CPLib.eqr("cf",p_cVarName)) {
      cf = value;
      return;
    }
    if (CPLib.eqr("piva",p_cVarName)) {
      piva = value;
      return;
    }
    if (CPLib.eqr("dataini",p_cVarName)) {
      dataini = value;
      return;
    }
    if (CPLib.eqr("datafin",p_cVarName)) {
      datafin = value;
      return;
    }
    if (CPLib.eqr("tiprap",p_cVarName)) {
      tiprap = value;
      return;
    }
    if (CPLib.eqr("valuta",p_cVarName)) {
      valuta = value;
      return;
    }
    if (CPLib.eqr("_ragsoc",p_cVarName)) {
      _ragsoc = value;
      return;
    }
    if (CPLib.eqr("_tipsog",p_cVarName)) {
      _tipsog = value;
      return;
    }
    if (CPLib.eqr("connes",p_cVarName)) {
      connes = value;
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
    if (CPLib.eqr("luonas",p_cVarName)) {
      luonas = value;
      return;
    }
    if (CPLib.eqr("_sae",p_cVarName)) {
      _sae = value;
      return;
    }
    if (CPLib.eqr("_dsae",p_cVarName)) {
      _dsae = value;
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
    if (CPLib.eqr("_ssin",p_cVarName)) {
      _ssin = value;
      return;
    }
    if (CPLib.eqr("_dssin",p_cVarName)) {
      _dssin = value;
      return;
    }
    if (CPLib.eqr("_rae",p_cVarName)) {
      _rae = value;
      return;
    }
    if (CPLib.eqr("_drae",p_cVarName)) {
      _drae = value;
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
    if (CPLib.eqr("_dataini",p_cVarName)) {
      _dataini = value;
      return;
    }
    if (CPLib.eqr("_datafin",p_cVarName)) {
      _datafin = value;
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
    VQRHolder l_VQRHolder = null;
    /* w_daSocieta Char(16) */
    /* w_aSocieta Char(16) */
    /* w_DaData Date */
    /* w_AData Date */
    /* w_detana Char(1) */
    /* gPathApp Char(80) // Path Applicazione */
    /* gUrlApp Char(80) // URL Applicazione */
    /* gDescAzi Char(70) // Descrizione Intermediario */
    /* gAzienda Char(10) // Azienda */
    /* gMsgImp Char(120) // Messaggio Import */
    /* file Char(1) */
    /* foglio Char(1) */
    /* nomeesito Char(50) */
    /* nomefilexls Char(50) */
    /* stringa Char(1) */
    /* rapporto Char(25) */
    /* descrap Char(70) */
    /* cf Char(16) */
    /* piva Char(11) */
    /* dataini Char(8) */
    /* _dataini Date */
    /* datafin Char(8) */
    /* _datafin Date */
    /* tiprap Char(1) */
    /* valuta Char(3) */
    /* _ragsoc Char(70) */
    /* _tipsog Char(1) */
    /* connes Char(16) */
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
    /* tipdoc Char(2) */
    /* autril Char(30) */
    /* numdoc Char(15) */
    /* datril Char(8) */
    /* luonas Char(8) */
    /* _sae Char(3) */
    /* _dsae Char(70) */
    /* _ateco Char(6) */
    /* _dateco Char(70) */
    /* _ssin Char(3) */
    /* _dssin Char(70) */
    /* _rae Char(3) */
    /* _drae Char(70) */
    /* Lancio la stampa */
    // * --- Drop temporary table tmp_stplegami
    if (m_Ctx.IsSharedTemp("tmp_stplegami")) {
      if (m_Ctx.IsTmpAlreadyCreated("tmp_stplegami")) {
        m_cServer = m_Ctx.GetServer("tmp_stplegami");
        m_cPhName = m_Ctx.GetPhName("tmp_stplegami");
        m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
      }
    } else {
      m_Ctx.DropTmp("tmp_stplegami");
    }
    // * --- Create temporary table tmp_stplegami
    if (m_Ctx.IsSharedTemp("tmp_stplegami")) {
      if (m_Ctx.IsTmpAlreadyCreated("tmp_stplegami")) {
        m_cServer = m_Ctx.GetServer("tmp_stplegami");
        m_cPhName = m_Ctx.GetPhName("tmp_stplegami");
        m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
      }
    } else {
      m_Ctx.DropTmp("tmp_stplegami");
    }
    m_cPhName = m_Ctx.CreateTmpPhName("tmp_stplegami");
    if ( ! (m_Ctx.IsSharedTemp("tmp_stplegami"))) {
      m_cServer = m_Ctx.GetServer("tmp_stplegami");
      m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_stplegami",m_cServer,"proto")),m_cPhName,"tmp_stplegami",m_Ctx,new String[]{"RAPPORTO","NUMPROG"});
    }
    m_cPhName_tmp_stplegami = m_cPhName;
    // * --- Insert into tmp_stplegami from query
    m_Sql.RequireTransaction();
    m_cServer = m_Ctx.GetServer("tmp_stplegami");
    m_cPhName = m_Ctx.GetPhName("tmp_stplegami");
    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stplegami",m_Ctx.GetCompany());
    SPBridge.HMCaller _h0000003C;
    _h0000003C = new SPBridge.HMCaller();
    _h0000003C.Set("m_cVQRList",m_cVQRList);
    _h0000003C.Set("DaData",w_DaData);
    _h0000003C.Set("AData",w_AData);
    _h0000003C.Set("daSocieta",w_daSocieta);
    _h0000003C.Set("aSocieta",w_aSocieta);
    m_nUpdatedRows=m_Sql.InsertIntoVQR(CPLib.GetSQLPrefixComment("arrt_stplegami_prv",115,"0000003C"),m_oWrInfo,"qbe_allrapotit_prv",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000003C,m_Ctx);
    if (CPLib.lt(m_nUpdatedRows,0)) {
      m_Sql.AbortTransaction();
    }
    m_Sql.CompleteTransaction();
    m_cLastMsgError = m_Sql.TransactionErrorMessage();
    if (CPLib.ne(m_cLastMsgError,"")) {
      m_bError = true;
    }
    /* If w_detana='S' */
    if (CPLib.eqr(w_detana,"S")) {
      /* Stop arrp_stplegami2.vrp */
      Forward f;
      f=new Forward("Report",false,this,Forward.Start,false);
      f.SetParameter("w_daSocieta",w_daSocieta);
      f.SetParameter("w_aSocieta",w_aSocieta);
      f.SetParameter("w_dadata",w_DaData);
      f.SetParameter("w_adata",w_AData);
      f.SetParameter("w_DescAzi",gDescAzi);
      f.SetParameter("_tiporep","P");
      f.SetParameter("ReportName","arrp_stplegami2.vrp");
      f.SetParameter("m_cParameterSequence","w_daSocieta"+","+"w_aSocieta"+","+"w_dadata"+","+"w_adata"+","+"w_DescAzi"+","+"_tiporep"+","+"ReportName");
      f.SetParameter("m_cMode","hyperlink");
      throw f;
    } else { // Else
      /* Stop arrp_stplegami1.vrp */
      Forward f;
      f=new Forward("Report",false,this,Forward.Start,false);
      f.SetParameter("w_daSocieta",w_daSocieta);
      f.SetParameter("w_aSocieta",w_aSocieta);
      f.SetParameter("w_dadata",w_DaData);
      f.SetParameter("w_adata",w_AData);
      f.SetParameter("w_DescAzi",gDescAzi);
      f.SetParameter("_tiporep","P");
      f.SetParameter("ReportName","arrp_stplegami1.vrp");
      f.SetParameter("m_cParameterSequence","w_daSocieta"+","+"w_aSocieta"+","+"w_dadata"+","+"w_adata"+","+"w_DescAzi"+","+"_tiporep"+","+"ReportName");
      f.SetParameter("m_cMode","hyperlink");
      throw f;
    } // End If
  }
  void _init_() {
  }
  public String RunAsync(String p_w_daSocieta,String p_w_aSocieta,java.sql.Date p_w_DaData,java.sql.Date p_w_AData,String p_w_detana) {
    w_daSocieta = p_w_daSocieta;
    w_aSocieta = p_w_aSocieta;
    w_DaData = p_w_DaData;
    w_AData = p_w_AData;
    w_detana = p_w_detana;
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
  public Forward Run(String p_w_daSocieta,String p_w_aSocieta,java.sql.Date p_w_DaData,java.sql.Date p_w_AData,String p_w_detana) {
    w_daSocieta = p_w_daSocieta;
    w_aSocieta = p_w_aSocieta;
    w_DaData = p_w_DaData;
    w_AData = p_w_AData;
    w_detana = p_w_detana;
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
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_stplegami_prvR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_stplegami_prvR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_daSocieta = CPLib.Space(16);
    w_aSocieta = CPLib.Space(16);
    w_DaData = CPLib.NullDate();
    w_AData = CPLib.NullDate();
    w_detana = CPLib.Space(1);
    file = CPLib.Space(1);
    foglio = CPLib.Space(1);
    nomeesito = CPLib.Space(50);
    nomefilexls = CPLib.Space(50);
    stringa = CPLib.Space(1);
    rapporto = CPLib.Space(25);
    descrap = CPLib.Space(70);
    cf = CPLib.Space(16);
    piva = CPLib.Space(11);
    dataini = CPLib.Space(8);
    _dataini = CPLib.NullDate();
    datafin = CPLib.Space(8);
    _datafin = CPLib.NullDate();
    tiprap = CPLib.Space(1);
    valuta = CPLib.Space(3);
    _ragsoc = CPLib.Space(70);
    _tipsog = CPLib.Space(1);
    connes = CPLib.Space(16);
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
    tipdoc = CPLib.Space(2);
    autril = CPLib.Space(30);
    numdoc = CPLib.Space(15);
    datril = CPLib.Space(8);
    luonas = CPLib.Space(8);
    _sae = CPLib.Space(3);
    _dsae = CPLib.Space(70);
    _ateco = CPLib.Space(6);
    _dateco = CPLib.Space(70);
    _ssin = CPLib.Space(3);
    _dssin = CPLib.Space(70);
    _rae = CPLib.Space(3);
    _drae = CPLib.Space(70);
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    gDescAzi=m_Ctx.GetGlobalString("gDescAzi");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_allrapotit_prv,
  public static final String m_cVQRList = ",qbe_allrapotit_prv,";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={"w_daSocieta","w_aSocieta","w_DaData","w_AData","w_detana"};
}
