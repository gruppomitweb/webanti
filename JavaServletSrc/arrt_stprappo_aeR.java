// * --- Area Manuale = BO - Header
// * --- arrt_stprappo_ae
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
public class arrt_stprappo_aeR implements CallerWithObjs {
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
  public String m_cPhName_japotit;
  public String m_cServer_japotit;
  public String m_cPhName_jelegabo;
  public String m_cServer_jelegabo;
  public String m_cPhName_jntestbo;
  public String m_cServer_jntestbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_tbramgru;
  public String m_cServer_tbramgru;
  public String m_cPhName_tbsetsin;
  public String m_cServer_tbsetsin;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public String m_cPhName_tbstgru;
  public String m_cServer_tbstgru;
  public String m_cPhName_tbtipatt;
  public String m_cServer_tbtipatt;
  public String m_cPhName_tbtipdoc;
  public String m_cServer_tbtipdoc;
  public String m_cPhName_tmp_stprapporti;
  public String m_cServer_tmp_stprapporti;
  public String m_cPhName_intestit;
  public String m_cServer_intestit;
  public String m_cPhName_jntestit;
  public String m_cServer_jntestit;
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
  public String pTipo;
  public String w_daRappo;
  public String w_aRappo;
  public java.sql.Date w_DaData;
  public java.sql.Date w_AData;
  public String w_c_dadata;
  public String w_c_adata;
  public String w_detope;
  public String w_attiva;
  public String w_mod_attiva;
  public String w_cancellata;
  public String w_mod_copia;
  public String w_tipo;
  public String w_detana;
  public String w_flgtit;
  public String w_flgdel;
  public String w_coddip;
  public String w_noaui;
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
  public double _crap;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_stprappo_ae
  public int riga;
  public DateTime dt;
  // * --- Fine Area Manuale
  public arrt_stprappo_aeR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_stprappo_ae",m_Caller);
    m_cPhName_japotit = p_ContextObject.GetPhName("japotit");
    if (m_cPhName_japotit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_japotit = m_cPhName_japotit+" "+m_Ctx.GetWritePhName("japotit");
    }
    m_cServer_japotit = p_ContextObject.GetServer("japotit");
    m_cPhName_jelegabo = p_ContextObject.GetPhName("jelegabo");
    if (m_cPhName_jelegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jelegabo = m_cPhName_jelegabo+" "+m_Ctx.GetWritePhName("jelegabo");
    }
    m_cServer_jelegabo = p_ContextObject.GetServer("jelegabo");
    m_cPhName_jntestbo = p_ContextObject.GetPhName("jntestbo");
    if (m_cPhName_jntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jntestbo = m_cPhName_jntestbo+" "+m_Ctx.GetWritePhName("jntestbo");
    }
    m_cServer_jntestbo = p_ContextObject.GetServer("jntestbo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_tbramgru = p_ContextObject.GetPhName("tbramgru");
    if (m_cPhName_tbramgru.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbramgru = m_cPhName_tbramgru+" "+m_Ctx.GetWritePhName("tbramgru");
    }
    m_cServer_tbramgru = p_ContextObject.GetServer("tbramgru");
    m_cPhName_tbsetsin = p_ContextObject.GetPhName("tbsetsin");
    if (m_cPhName_tbsetsin.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbsetsin = m_cPhName_tbsetsin+" "+m_Ctx.GetWritePhName("tbsetsin");
    }
    m_cServer_tbsetsin = p_ContextObject.GetServer("tbsetsin");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    if (m_cPhName_tbstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstati = m_cPhName_tbstati+" "+m_Ctx.GetWritePhName("tbstati");
    }
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
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
    m_cPhName_tbtipdoc = p_ContextObject.GetPhName("tbtipdoc");
    if (m_cPhName_tbtipdoc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbtipdoc = m_cPhName_tbtipdoc+" "+m_Ctx.GetWritePhName("tbtipdoc");
    }
    m_cServer_tbtipdoc = p_ContextObject.GetServer("tbtipdoc");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_stprapporti")) {
      m_cPhName_tmp_stprapporti = p_ContextObject.GetPhName("tmp_stprapporti");
      if (m_cPhName_tmp_stprapporti.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_stprapporti = m_cPhName_tmp_stprapporti+" "+m_Ctx.GetWritePhName("tmp_stprapporti");
      }
      m_cServer_tmp_stprapporti = p_ContextObject.GetServer("tmp_stprapporti");
    }
    m_cPhName_intestit = p_ContextObject.GetPhName("intestit");
    if (m_cPhName_intestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestit = m_cPhName_intestit+" "+m_Ctx.GetWritePhName("intestit");
    }
    m_cServer_intestit = p_ContextObject.GetServer("intestit");
    m_cPhName_jntestit = p_ContextObject.GetPhName("jntestit");
    if (m_cPhName_jntestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jntestit = m_cPhName_jntestit+" "+m_Ctx.GetWritePhName("jntestit");
    }
    m_cServer_jntestit = p_ContextObject.GetServer("jntestit");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_crap",p_cVarName)) {
      return _crap;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_stprappo_ae";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("daRappo",p_cVarName)) {
      return w_daRappo;
    }
    if (CPLib.eqr("aRappo",p_cVarName)) {
      return w_aRappo;
    }
    if (CPLib.eqr("c_dadata",p_cVarName)) {
      return w_c_dadata;
    }
    if (CPLib.eqr("c_adata",p_cVarName)) {
      return w_c_adata;
    }
    if (CPLib.eqr("detope",p_cVarName)) {
      return w_detope;
    }
    if (CPLib.eqr("attiva",p_cVarName)) {
      return w_attiva;
    }
    if (CPLib.eqr("mod_attiva",p_cVarName)) {
      return w_mod_attiva;
    }
    if (CPLib.eqr("cancellata",p_cVarName)) {
      return w_cancellata;
    }
    if (CPLib.eqr("mod_copia",p_cVarName)) {
      return w_mod_copia;
    }
    if (CPLib.eqr("tipo",p_cVarName)) {
      return w_tipo;
    }
    if (CPLib.eqr("detana",p_cVarName)) {
      return w_detana;
    }
    if (CPLib.eqr("flgtit",p_cVarName)) {
      return w_flgtit;
    }
    if (CPLib.eqr("flgdel",p_cVarName)) {
      return w_flgdel;
    }
    if (CPLib.eqr("coddip",p_cVarName)) {
      return w_coddip;
    }
    if (CPLib.eqr("noaui",p_cVarName)) {
      return w_noaui;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
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
    if (CPLib.eqr("_crap",p_cVarName)) {
      _crap = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("daRappo",p_cVarName)) {
      w_daRappo = value;
      return;
    }
    if (CPLib.eqr("aRappo",p_cVarName)) {
      w_aRappo = value;
      return;
    }
    if (CPLib.eqr("c_dadata",p_cVarName)) {
      w_c_dadata = value;
      return;
    }
    if (CPLib.eqr("c_adata",p_cVarName)) {
      w_c_adata = value;
      return;
    }
    if (CPLib.eqr("detope",p_cVarName)) {
      w_detope = value;
      return;
    }
    if (CPLib.eqr("attiva",p_cVarName)) {
      w_attiva = value;
      return;
    }
    if (CPLib.eqr("mod_attiva",p_cVarName)) {
      w_mod_attiva = value;
      return;
    }
    if (CPLib.eqr("cancellata",p_cVarName)) {
      w_cancellata = value;
      return;
    }
    if (CPLib.eqr("mod_copia",p_cVarName)) {
      w_mod_copia = value;
      return;
    }
    if (CPLib.eqr("tipo",p_cVarName)) {
      w_tipo = value;
      return;
    }
    if (CPLib.eqr("detana",p_cVarName)) {
      w_detana = value;
      return;
    }
    if (CPLib.eqr("flgtit",p_cVarName)) {
      w_flgtit = value;
      return;
    }
    if (CPLib.eqr("flgdel",p_cVarName)) {
      w_flgdel = value;
      return;
    }
    if (CPLib.eqr("coddip",p_cVarName)) {
      w_coddip = value;
      return;
    }
    if (CPLib.eqr("noaui",p_cVarName)) {
      w_noaui = value;
      return;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
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
    CPResultSet Cursor_qbe_allrapopebo_ae=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Parametro della procedura */
      /* pTipo Char(1) */
      /* w_daRappo Char(25) */
      /* w_aRappo Char(25) */
      /* w_DaData Date */
      /* w_AData Date */
      /* w_c_dadata Char(8) */
      /* w_c_adata Char(8) */
      /* w_detope Char(1) */
      /* w_attiva Char(1) */
      /* w_mod_attiva Char(1) */
      /* w_cancellata Char(1) */
      /* w_mod_copia Char(1) */
      /* w_tipo Char(1) */
      /* w_detana Char(1) */
      /* w_flgtit Char(1) */
      /* w_flgdel Char(1) */
      /* w_coddip Char(6) */
      /* w_noaui Char(1) // Esclude dati AUI */
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
      /* w_c_dadata := iif(w_c_dadata='01000101','',w_c_dadata) */
      w_c_dadata = (CPLib.eqr(w_c_dadata,"01000101")?"":w_c_dadata);
      /* w_c_adata := iif(w_c_adata='01000101','',w_c_adata) */
      w_c_adata = (CPLib.eqr(w_c_adata,"01000101")?"":w_c_adata);
      /* If pTipo='R' */
      if (CPLib.eqr(pTipo,"R")) {
        /* Case w_tipo='T' */
        if (CPLib.eqr(w_tipo,"T")) {
          // * --- Drop temporary table tmp_stprapporti
          if (m_Ctx.IsSharedTemp("tmp_stprapporti")) {
            if (m_Ctx.IsTmpAlreadyCreated("tmp_stprapporti")) {
              m_cServer = m_Ctx.GetServer("tmp_stprapporti");
              m_cPhName = m_Ctx.GetPhName("tmp_stprapporti");
              m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
            }
          } else {
            m_Ctx.DropTmp("tmp_stprapporti");
          }
          // * --- Create temporary table tmp_stprapporti
          if (m_Ctx.IsSharedTemp("tmp_stprapporti")) {
            if (m_Ctx.IsTmpAlreadyCreated("tmp_stprapporti")) {
              m_cServer = m_Ctx.GetServer("tmp_stprapporti");
              m_cPhName = m_Ctx.GetPhName("tmp_stprapporti");
              m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
            }
          } else {
            m_Ctx.DropTmp("tmp_stprapporti");
          }
          m_cPhName = m_Ctx.CreateTmpPhName("tmp_stprapporti");
          new VQRHolder("qbe_allrapopebo_ae",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).CreateServerQuery(m_Ctx, "tmp_stprapporti",false);
          m_cPhName_tmp_stprapporti = m_cPhName;
          /* Case w_tipo='A' */
        } else if (CPLib.eqr(w_tipo,"A")) {
          // * --- Drop temporary table tmp_stprapporti
          if (m_Ctx.IsSharedTemp("tmp_stprapporti")) {
            if (m_Ctx.IsTmpAlreadyCreated("tmp_stprapporti")) {
              m_cServer = m_Ctx.GetServer("tmp_stprapporti");
              m_cPhName = m_Ctx.GetPhName("tmp_stprapporti");
              m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
            }
          } else {
            m_Ctx.DropTmp("tmp_stprapporti");
          }
          // * --- Create temporary table tmp_stprapporti
          if (m_Ctx.IsSharedTemp("tmp_stprapporti")) {
            if (m_Ctx.IsTmpAlreadyCreated("tmp_stprapporti")) {
              m_cServer = m_Ctx.GetServer("tmp_stprapporti");
              m_cPhName = m_Ctx.GetPhName("tmp_stprapporti");
              m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
            }
          } else {
            m_Ctx.DropTmp("tmp_stprapporti");
          }
          m_cPhName = m_Ctx.CreateTmpPhName("tmp_stprapporti");
          if ( ! (m_Ctx.IsSharedTemp("tmp_stprapporti"))) {
            m_cServer = m_Ctx.GetServer("tmp_stprapporti");
            m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_stprapporti",m_cServer,"proto")),m_cPhName,"tmp_stprapporti",m_Ctx,new String[]{"RAPPORTO","NUMPROG"});
          }
          m_cPhName_tmp_stprapporti = m_cPhName;
          // * --- Select from qbe_allrapopebo_ae
          if (Cursor_qbe_allrapopebo_ae!=null)
            Cursor_qbe_allrapopebo_ae.Close();
          Cursor_qbe_allrapopebo_ae = new VQRHolder("qbe_allrapopebo_ae",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_allrapopebo_ae.Eof())) {
            /* If Empty(qbe_allrapopebo_ae->DATAFINE) */
            if (CPLib.Empty(Cursor_qbe_allrapopebo_ae.GetDate("DATAFINE"))) {
              // * --- Insert into tmp_stprapporti from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stprapporti");
              m_cPhName = m_Ctx.GetPhName("tmp_stprapporti");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stprapporti",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stprappo_ae",112,"00000052")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000052(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ae.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ae.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ae.GetDate("DATAFINE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ae.GetDate("DATAINI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ae.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ae.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ae.GetString("DESCRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ae.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ae.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ae.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ae.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ae.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ae.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ae.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ae.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ae.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stprapporti",true);
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
            Cursor_qbe_allrapopebo_ae.Next();
          }
          m_cConnectivityError = Cursor_qbe_allrapopebo_ae.ErrorMessage();
          Cursor_qbe_allrapopebo_ae.Close();
          // * --- End Select
          /* Case w_tipo='C' */
        } else if (CPLib.eqr(w_tipo,"C")) {
          // * --- Drop temporary table tmp_stprapporti
          if (m_Ctx.IsSharedTemp("tmp_stprapporti")) {
            if (m_Ctx.IsTmpAlreadyCreated("tmp_stprapporti")) {
              m_cServer = m_Ctx.GetServer("tmp_stprapporti");
              m_cPhName = m_Ctx.GetPhName("tmp_stprapporti");
              m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
            }
          } else {
            m_Ctx.DropTmp("tmp_stprapporti");
          }
          // * --- Create temporary table tmp_stprapporti
          if (m_Ctx.IsSharedTemp("tmp_stprapporti")) {
            if (m_Ctx.IsTmpAlreadyCreated("tmp_stprapporti")) {
              m_cServer = m_Ctx.GetServer("tmp_stprapporti");
              m_cPhName = m_Ctx.GetPhName("tmp_stprapporti");
              m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
            }
          } else {
            m_Ctx.DropTmp("tmp_stprapporti");
          }
          m_cPhName = m_Ctx.CreateTmpPhName("tmp_stprapporti");
          if ( ! (m_Ctx.IsSharedTemp("tmp_stprapporti"))) {
            m_cServer = m_Ctx.GetServer("tmp_stprapporti");
            m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_stprapporti",m_cServer,"proto")),m_cPhName,"tmp_stprapporti",m_Ctx,new String[]{"RAPPORTO","NUMPROG"});
          }
          m_cPhName_tmp_stprapporti = m_cPhName;
          // * --- Select from qbe_allrapopebo_ae
          if (Cursor_qbe_allrapopebo_ae!=null)
            Cursor_qbe_allrapopebo_ae.Close();
          Cursor_qbe_allrapopebo_ae = new VQRHolder("qbe_allrapopebo_ae",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_allrapopebo_ae.Eof())) {
            /* If not(Empty(qbe_allrapopebo_ae->DATAFINE)) */
            if ( ! (CPLib.Empty(Cursor_qbe_allrapopebo_ae.GetDate("DATAFINE")))) {
              // * --- Insert into tmp_stprapporti from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stprapporti");
              m_cPhName = m_Ctx.GetPhName("tmp_stprapporti");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stprapporti",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stprappo_ae",112,"00000057")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000057(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ae.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ae.GetString("DESCRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ae.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ae.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ae.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ae.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ae.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ae.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ae.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ae.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ae.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ae.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ae.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ae.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ae.GetDate("DATAINI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ae.GetDate("DATAFINE"),"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stprapporti",true);
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
            Cursor_qbe_allrapopebo_ae.Next();
          }
          m_cConnectivityError = Cursor_qbe_allrapopebo_ae.ErrorMessage();
          Cursor_qbe_allrapopebo_ae.Close();
          // * --- End Select
        } // End Case
        /* If w_detope='S' */
        if (CPLib.eqr(w_detope,"S")) {
          /* Stop arrp_stprappo_ae2.vrp */
          Forward f;
          f=new Forward("Report",false,this,Forward.Start,false);
          f.SetParameter("daRappo",w_daRappo);
          f.SetParameter("aRappo",w_aRappo);
          f.SetParameter("DaData",w_DaData);
          f.SetParameter("AData",w_AData);
          f.SetParameter("c_dadata",w_c_dadata);
          f.SetParameter("c_adata",w_c_adata);
          f.SetParameter("attiva",w_attiva);
          f.SetParameter("mod_attiva",w_mod_attiva);
          f.SetParameter("cancellata",w_cancellata);
          f.SetParameter("mod_copia",w_mod_copia);
          f.SetParameter("tipo",w_tipo);
          f.SetParameter("DescAzi",gDescAzi);
          f.SetParameter("ReportName","arrp_stprappo_ae2.vrp");
          f.SetParameter("m_cParameterSequence","daRappo"+","+"aRappo"+","+"DaData"+","+"AData"+","+"c_dadata"+","+"c_adata"+","+"attiva"+","+"mod_attiva"+","+"cancellata"+","+"mod_copia"+","+"tipo"+","+"DescAzi"+","+"ReportName");
          f.SetParameter("m_cMode","hyperlink");
          throw f;
        } else { // Else
          /* Stop arrp_stprappo_ae1.vrp */
          Forward f;
          f=new Forward("Report",false,this,Forward.Start,false);
          f.SetParameter("daRappo",w_daRappo);
          f.SetParameter("aRappo",w_aRappo);
          f.SetParameter("DaData",w_DaData);
          f.SetParameter("AData",w_AData);
          f.SetParameter("c_dadata",w_c_dadata);
          f.SetParameter("c_adata",w_c_adata);
          f.SetParameter("attiva",w_attiva);
          f.SetParameter("mod_attiva",w_mod_attiva);
          f.SetParameter("cancellata",w_cancellata);
          f.SetParameter("mod_copia",w_mod_copia);
          f.SetParameter("tipo",w_tipo);
          f.SetParameter("DescAzi",gDescAzi);
          f.SetParameter("hideLanguage",true);
          f.SetParameter("hideSettings",true);
          f.SetParameter("hideExport",true);
          f.SetParameter("ReportName","arrp_stprappo_ae1.vrp");
          f.SetParameter("m_cParameterSequence","daRappo"+","+"aRappo"+","+"DaData"+","+"AData"+","+"c_dadata"+","+"c_adata"+","+"attiva"+","+"mod_attiva"+","+"cancellata"+","+"mod_copia"+","+"tipo"+","+"DescAzi"+","+"hideLanguage"+","+"hideSettings"+","+"hideExport"+","+"ReportName");
          f.SetParameter("m_cMode","hyperlink");
          throw f;
        } // End If
      } else { // Else
        /* If w_detana='N' */
        if (CPLib.eqr(w_detana,"N")) {
          /* Exec "Excel Senza Dettaglio" Page 2:Page_2 */
          Page_2();
        } else { // Else
          /* Exec "Excel con Dettaglio" Page 3:Page_3 */
          Page_3();
        } // End If
        /* Stop LRTrim(gUrlApp)+"servlet/DownloadFileDirect?fileName="+LRTrim(nomefilexls) */
        Forward f;
        f=new Forward(CPLib.LRTrim(gUrlApp)+"servlet/DownloadFileDirect?fileName="+CPLib.LRTrim(nomefilexls),false,this,Forward.NoStatus,true);
        f.SetParameter("m_cParameterSequence", "");
        f.SetParameter("m_cMode","hyperlink");
        throw f;
      } // End If
    } finally {
      try {
        if (Cursor_qbe_allrapopebo_ae!=null)
          Cursor_qbe_allrapopebo_ae.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_qbe_rapporti_xls_ae=null;
    CPResultSet Cursor_jntestbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_intestit=null;
    CPResultSet Cursor_jntestit=null;
    CPResultSet Cursor_jelegabo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Excel Con dettaglio anagrafico */
      /* _crap Numeric(10, 0) */
      /* nomeesito := 'rapporti'+DateTimeToChar(DateTime())+".xls" */
      nomeesito = "rapporti"+CPLib.DateTimeToChar(CPLib.DateTime())+".xls";
      /* nomefilexls := LRTrim(gPathApp)+"/output/"+LRTrim(gAzienda)+"/"+nomeesito */
      nomefilexls = CPLib.LRTrim(gPathApp)+"/output/"+CPLib.LRTrim(gAzienda)+"/"+nomeesito;
      // Crea il foglio e scrive la testata
      WorkbookSettings ws = new WorkbookSettings();
      WritableWorkbook prova = Workbook.createWorkbook(new File(nomefilexls), ws);
      WritableSheet foglio = prova.createSheet("Elenco Rapporti", 0);
      WritableFont arial11font = new WritableFont(WritableFont.ARIAL, 11, WritableFont.BOLD, true);
      WritableCellFormat arial11format = new WritableCellFormat (arial11font);
      DateFormat df = new DateFormat("dd-mm-yyyy");
      WritableCellFormat cf1 = new WritableCellFormat(df);
      Label stringa = new Label(0,0,"Codice Rapporto",arial11format);
      foglio.addCell(stringa); 
      stringa = new Label(1,0,"Descrizione",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(2,0,"Codice Fiscale",arial11format);
      foglio.addCell(stringa); 
      stringa = new Label(3,0,"Nominativo",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(4,0,"Data Inizio",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(5,0,"Data Fine",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(6,0,"Tipo Rapporto",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(7,0,"Valuta",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(8,0,"Tipo Soggetto",arial11format);
      foglio.addCell(stringa);
      riga = 2;
      /* _crap := 0 */
      _crap = CPLib.Round(0,0);
      /* rapporto := '' */
      rapporto = "";
      // * --- Select from qbe_rapporti_xls_ae
      if (Cursor_qbe_rapporti_xls_ae!=null)
        Cursor_qbe_rapporti_xls_ae.Close();
      Cursor_qbe_rapporti_xls_ae = new VQRHolder("qbe_rapporti_xls_ae",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_rapporti_xls_ae.Eof())) {
        /* gMsgImp := "Elaborazione Rapporto "+ qbe_rapporti_xls_ae->RAPPORTO // Messaggio Import */
        gMsgImp = "Elaborazione Rapporto "+Cursor_qbe_rapporti_xls_ae.GetString("RAPPORTO");
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _crap := 1 */
        _crap = CPLib.Round(1,0);
        /* rapporto := qbe_rapporti_xls_ae->RAPPORTO */
        rapporto = Cursor_qbe_rapporti_xls_ae.GetString("RAPPORTO");
        /* descrap := qbe_rapporti_xls_ae->DESCRAP */
        descrap = Cursor_qbe_rapporti_xls_ae.GetString("DESCRAP");
        /* tiprap := qbe_rapporti_xls_ae->TIPORAP */
        tiprap = Cursor_qbe_rapporti_xls_ae.GetString("TIPORAP");
        /* valuta := qbe_rapporti_xls_ae->VALUTA */
        valuta = Cursor_qbe_rapporti_xls_ae.GetString("VALUTA");
        // * --- Select from jntestbo
        m_cServer = m_Ctx.GetServer("jntestbo");
        m_cPhName = m_Ctx.GetPhName("jntestbo");
        if (Cursor_jntestbo!=null)
          Cursor_jntestbo.Close();
        Cursor_jntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER,DATAINI,DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapporti_xls_ae.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("jntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_jntestbo.Eof())) {
          /* connes := jntestbo->CODINTER */
          connes = Cursor_jntestbo.GetString("CODINTER");
          /* dataini := arfn_fdate(jntestbo->DATAINI) */
          dataini = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_jntestbo.GetDate("DATAINI"));
          /* datafin := arfn_fdate(jntestbo->DATAFINE) */
          datafin = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_jntestbo.GetDate("DATAFINE"));
          /* cf := '' */
          cf = "";
          /* _ragsoc := '' */
          _ragsoc = "";
          // * --- Read from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          m_cSql = "";
          m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_jntestbo.GetString("CODINTER"),"C",16,0,m_cServer),m_cServer,Cursor_jntestbo.GetString("CODINTER"));
          if (m_Ctx.IsSharedTemp("personbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAGSOC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _ragsoc = Read_Cursor.GetString("RAGSOC");
            cf = Read_Cursor.GetString("CODFISC");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on personbo into routine arrt_stprappo_ae returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _ragsoc = "";
            cf = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          // Scrive i dati
          stringa = new Label(0,riga,rapporto);
          foglio.addCell(stringa); 
          stringa = new Label(1,riga,descrap);
          foglio.addCell(stringa); 
          stringa = new Label(2,riga,cf);
          foglio.addCell(stringa); 
          stringa = new Label(3,riga,_ragsoc);
          foglio.addCell(stringa);
          stringa = new Label(4,riga,dataini);
          foglio.addCell(stringa);
          stringa = new Label(5,riga,datafin);
          foglio.addCell(stringa);
          stringa = new Label(6,riga,tiprap);
          foglio.addCell(stringa);
          stringa = new Label(7,riga,valuta);
          foglio.addCell(stringa);
          stringa = new Label(8,riga,"I");
          foglio.addCell(stringa);
          riga = riga + 1;
          /* If w_flgtit='S' */
          if (CPLib.eqr(w_flgtit,"S")) {
            /* If w_noaui='N' */
            if (CPLib.eqr(w_noaui,"N")) {
              // * --- Select from intestit
              m_cServer = m_Ctx.GetServer("intestit");
              m_cPhName = m_Ctx.GetPhName("intestit");
              if (Cursor_intestit!=null)
                Cursor_intestit.Close();
              Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPLib.ToSQL(Cursor_jntestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_intestit.Eof())) {
                /* dataini := arfn_fdate(intestit->DATAINI) */
                dataini = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_intestit.GetDate("DATAINI"));
                /* datafin := arfn_fdate(intestit->DATAFINE) */
                datafin = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_intestit.GetDate("DATAFINE"));
                /* _ragsoc := '' */
                _ragsoc = "";
                /* cf := '' */
                cf = "";
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
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAGSOC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _ragsoc = Read_Cursor.GetString("RAGSOC");
                  cf = Read_Cursor.GetString("CODFISC");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on personbo into routine arrt_stprappo_ae returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _ragsoc = "";
                  cf = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                // Scrive i dati
                stringa = new Label(0,riga,rapporto);
                foglio.addCell(stringa); 
                stringa = new Label(1,riga,descrap);
                foglio.addCell(stringa); 
                stringa = new Label(2,riga,cf);
                foglio.addCell(stringa); 
                stringa = new Label(3,riga,_ragsoc);
                foglio.addCell(stringa);
                stringa = new Label(4,riga,dataini);
                foglio.addCell(stringa);
                stringa = new Label(5,riga,datafin);
                foglio.addCell(stringa);
                stringa = new Label(6,riga,tiprap);
                foglio.addCell(stringa);
                stringa = new Label(7,riga,valuta);
                foglio.addCell(stringa);
                stringa = new Label(8,riga,"T");
                foglio.addCell(stringa);
                riga = riga + 1;
                Cursor_intestit.Next();
              }
              m_cConnectivityError = Cursor_intestit.ErrorMessage();
              Cursor_intestit.Close();
              // * --- End Select
            } // End If
            // * --- Select from jntestit
            m_cServer = m_Ctx.GetServer("jntestit");
            m_cPhName = m_Ctx.GetPhName("jntestit");
            if (Cursor_jntestit!=null)
              Cursor_jntestit.Close();
            Cursor_jntestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPLib.ToSQL(Cursor_jntestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("jntestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_jntestit.Eof())) {
              /* dataini := arfn_fdate(jntestit->DATAINI) */
              dataini = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_jntestit.GetDate("DATAINI"));
              /* datafin := arfn_fdate(jntestit->DATAFINE) */
              datafin = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_jntestit.GetDate("DATAFINE"));
              /* _ragsoc := '' */
              _ragsoc = "";
              /* cf := '' */
              cf = "";
              // * --- Read from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              m_cSql = "";
              m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_jntestit.GetString("CODINTER"),"C",16,0,m_cServer),m_cServer,Cursor_jntestit.GetString("CODINTER"));
              if (m_Ctx.IsSharedTemp("personbo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAGSOC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _ragsoc = Read_Cursor.GetString("RAGSOC");
                cf = Read_Cursor.GetString("CODFISC");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on personbo into routine arrt_stprappo_ae returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _ragsoc = "";
                cf = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              // Scrive i dati
              stringa = new Label(0,riga,rapporto);
              foglio.addCell(stringa); 
              stringa = new Label(1,riga,descrap);
              foglio.addCell(stringa); 
              stringa = new Label(2,riga,cf);
              foglio.addCell(stringa); 
              stringa = new Label(3,riga,_ragsoc);
              foglio.addCell(stringa);
              stringa = new Label(4,riga,dataini);
              foglio.addCell(stringa);
              stringa = new Label(5,riga,datafin);
              foglio.addCell(stringa);
              stringa = new Label(6,riga,tiprap);
              foglio.addCell(stringa);
              stringa = new Label(7,riga,valuta);
              foglio.addCell(stringa);
              stringa = new Label(8,riga,"T");
              foglio.addCell(stringa);
              riga = riga + 1;
              Cursor_jntestit.Next();
            }
            m_cConnectivityError = Cursor_jntestit.ErrorMessage();
            Cursor_jntestit.Close();
            // * --- End Select
          } // End If
          Cursor_jntestbo.Next();
        }
        m_cConnectivityError = Cursor_jntestbo.ErrorMessage();
        Cursor_jntestbo.Close();
        // * --- End Select
        /* If w_flgdel='S' */
        if (CPLib.eqr(w_flgdel,"S")) {
          // * --- Select from jelegabo
          m_cServer = m_Ctx.GetServer("jelegabo");
          m_cPhName = m_Ctx.GetPhName("jelegabo");
          if (Cursor_jelegabo!=null)
            Cursor_jelegabo.Close();
          Cursor_jelegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER,DATAINI,DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapporti_xls_ae.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("jelegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_jelegabo.Eof())) {
            /* connes := jelegabo->CODINTER */
            connes = Cursor_jelegabo.GetString("CODINTER");
            /* dataini := arfn_fdate(jelegabo->DATAINI) */
            dataini = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_jelegabo.GetDate("DATAINI"));
            /* datafin := arfn_fdate(jelegabo->DATAFINE) */
            datafin = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_jelegabo.GetDate("DATAFINE"));
            /* _ragsoc := '' */
            _ragsoc = "";
            /* cf := '' */
            cf = "";
            // * --- Read from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_cSql = "";
            m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_jelegabo.GetString("CODINTER"),"C",16,0,m_cServer),m_cServer,Cursor_jelegabo.GetString("CODINTER"));
            if (m_Ctx.IsSharedTemp("personbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAGSOC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _ragsoc = Read_Cursor.GetString("RAGSOC");
              cf = Read_Cursor.GetString("CODFISC");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on personbo into routine arrt_stprappo_ae returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _ragsoc = "";
              cf = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            // Scrive i dati
            stringa = new Label(0,riga,rapporto);
            foglio.addCell(stringa); 
            stringa = new Label(1,riga,descrap);
            foglio.addCell(stringa); 
            stringa = new Label(2,riga,cf);
            foglio.addCell(stringa); 
            stringa = new Label(3,riga,_ragsoc);
            foglio.addCell(stringa);
            stringa = new Label(4,riga,dataini);
            foglio.addCell(stringa);
            stringa = new Label(5,riga,datafin);
            foglio.addCell(stringa);
            stringa = new Label(6,riga,tiprap);
            foglio.addCell(stringa);
            stringa = new Label(7,riga,valuta);
            foglio.addCell(stringa);
            stringa = new Label(8,riga,"D");
            foglio.addCell(stringa);
            riga = riga + 1;
            Cursor_jelegabo.Next();
          }
          m_cConnectivityError = Cursor_jelegabo.ErrorMessage();
          Cursor_jelegabo.Close();
          // * --- End Select
        } // End If
        Cursor_qbe_rapporti_xls_ae.Next();
      }
      m_cConnectivityError = Cursor_qbe_rapporti_xls_ae.ErrorMessage();
      Cursor_qbe_rapporti_xls_ae.Close();
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
      // Scrive il file e chiude
      prova.write();
      prova.close();
      /* gMsgImp := "Elaborazione Terminata !" // Messaggio Import */
      gMsgImp = "Elaborazione Terminata !";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Cursor_qbe_rapporti_xls_ae!=null)
          Cursor_qbe_rapporti_xls_ae.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jntestbo!=null)
          Cursor_jntestbo.Close();
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
        if (Cursor_intestit!=null)
          Cursor_intestit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jntestit!=null)
          Cursor_jntestit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jelegabo!=null)
          Cursor_jelegabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_3() throws Exception {
    CPResultSet Cursor_qbe_rapporti_xls_dett_ae=null;
    CPResultSet Cursor_jntestbo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_intestit=null;
    CPResultSet Cursor_jntestit=null;
    CPResultSet Cursor_jelegabo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Excel Con dettaglio anagrafico */
      /* _crap Numeric(10, 0) */
      /* nomeesito := 'rapporti'+DateTimeToChar(DateTime())+".xls" */
      nomeesito = "rapporti"+CPLib.DateTimeToChar(CPLib.DateTime())+".xls";
      /* nomefilexls := LRTrim(gPathApp)+"/output/"+LRTrim(gAzienda)+"/"+nomeesito */
      nomefilexls = CPLib.LRTrim(gPathApp)+"/output/"+CPLib.LRTrim(gAzienda)+"/"+nomeesito;
      // Crea il foglio e scrive la testata
      WorkbookSettings ws = new WorkbookSettings();
      WritableWorkbook prova = Workbook.createWorkbook(new File(nomefilexls), ws);
      WritableSheet foglio = prova.createSheet("Elenco Rapporti", 0);
      WritableFont arial11font = new WritableFont(WritableFont.ARIAL, 11, WritableFont.BOLD, true);
      WritableCellFormat arial11format = new WritableCellFormat (arial11font);
      DateFormat df = new DateFormat("dd-mm-yyyy");
      WritableCellFormat cf1 = new WritableCellFormat(df);
      Label stringa = new Label(0,0,"Codice Rapporto",arial11format);
      foglio.addCell(stringa); 
      stringa = new Label(1,0,"Descrizione",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(2,0,"Tipo Rapporto",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(3,0,"Valuta",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(4,0,"Codice Fiscale",arial11format);
      foglio.addCell(stringa); 
      stringa = new Label(5,0,"Nominativo",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(6,0,"Paese Residenza",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(7,0,"Città Residenza",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(8,0,"Domicilio",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(9,0,"CAB Residenza",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(10,0,"CAP Residenza",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(11,0,"Prov Residenza",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(12,0,"Luogo Nascita",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(13,0,"Prov. Nascita",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(14,0,"Data Nascita",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(15,0,"Sesso",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(16,0,"Tipo Documento",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(17,0,"N° Documento",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(18,0,"Data Rilascio",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(19,0,"Autorità Rilascio",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(20,0,"NDG Soggetto",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(21,0,"S.A.E.",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(22,0,"Descrizione S.A.E.",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(23,0,"R.A.E.",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(24,0,"Descrizione R.A.E.",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(25,0,"ATECO",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(26,0,"Descrizione ATECO",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(27,0,"Sett. Sintetico",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(28,0,"Descrizione Sett. Sintetico",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(29,0,"Data Inizio",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(30,0,"Data Fine",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(31,0,"Tipo Soggetto",arial11format);
      foglio.addCell(stringa);
      riga = 2;
      /* _crap := 0 */
      _crap = CPLib.Round(0,0);
      /* rapporto := '' */
      rapporto = "";
      // * --- Select from qbe_rapporti_xls_dett_ae
      if (Cursor_qbe_rapporti_xls_dett_ae!=null)
        Cursor_qbe_rapporti_xls_dett_ae.Close();
      Cursor_qbe_rapporti_xls_dett_ae = new VQRHolder("qbe_rapporti_xls_dett_ae",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_rapporti_xls_dett_ae.Eof())) {
        /* gMsgImp := "Elaborazione Rapporto "+ qbe_rapporti_xls_dett_ae->RAPPORTO // Messaggio Import */
        gMsgImp = "Elaborazione Rapporto "+Cursor_qbe_rapporti_xls_dett_ae.GetString("RAPPORTO");
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _crap := 1 */
        _crap = CPLib.Round(1,0);
        /* rapporto := qbe_rapporti_xls_dett_ae->RAPPORTO */
        rapporto = Cursor_qbe_rapporti_xls_dett_ae.GetString("RAPPORTO");
        /* descrap := qbe_rapporti_xls_dett_ae->DESCRAP */
        descrap = Cursor_qbe_rapporti_xls_dett_ae.GetString("DESCRAP");
        /* tiprap := qbe_rapporti_xls_dett_ae->TIPORAP */
        tiprap = Cursor_qbe_rapporti_xls_dett_ae.GetString("TIPORAP");
        /* valuta := qbe_rapporti_xls_dett_ae->VALUTA */
        valuta = Cursor_qbe_rapporti_xls_dett_ae.GetString("VALUTA");
        // * --- Select from jntestbo
        m_cServer = m_Ctx.GetServer("jntestbo");
        m_cPhName = m_Ctx.GetPhName("jntestbo");
        if (Cursor_jntestbo!=null)
          Cursor_jntestbo.Close();
        Cursor_jntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER,DATAINI,DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapporti_xls_dett_ae.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("jntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_jntestbo.Eof())) {
          /* connes := jntestbo->CODINTER */
          connes = Cursor_jntestbo.GetString("CODINTER");
          /* dataini := arfn_fdate(jntestbo->DATAINI) */
          dataini = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_jntestbo.GetDate("DATAINI"));
          /* datafin := arfn_fdate(jntestbo->DATAFINE) */
          datafin = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_jntestbo.GetDate("DATAFINE"));
          /* cf := '' */
          cf = "";
          /* _ragsoc := '' */
          _ragsoc = "";
          /* indirizzo := '' */
          indirizzo = "";
          /* citres := '' */
          citres = "";
          /* capres := '' */
          capres = "";
          /* cabres := '' */
          cabres = "";
          /* prvres := '' */
          prvres = "";
          /* stares := '' */
          stares = "";
          /* citnas := '' */
          citnas = "";
          /* prvnas := '' */
          prvnas = "";
          /* stanas := '' */
          stanas = "";
          /* sesso := '' */
          sesso = "";
          /* datnas := '' */
          datnas = "";
          /* tipdoc := '' */
          tipdoc = "";
          /* autril := '' */
          autril = "";
          /* numdoc := '' */
          numdoc = "";
          /* datril := '' */
          datril = "";
          /* luonas := '' */
          luonas = "";
          /* _sae := '' */
          _sae = "";
          /* _dsae := '' */
          _dsae = "";
          /* _ateco := '' */
          _ateco = "";
          /* _dateco := '' */
          _dateco = "";
          /* _ssin := '' */
          _ssin = "";
          /* _dssin := '' */
          _dssin = "";
          /* _rae := '' */
          _rae = "";
          /* _drae := '' */
          _drae = "";
          // * --- Select from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          if (Cursor_personbo!=null)
            Cursor_personbo.Close();
          Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_jntestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_personbo.Eof())) {
            /* cf := personbo->CODFISC */
            cf = Cursor_personbo.GetString("CODFISC");
            /* _ragsoc := personbo->RAGSOC */
            _ragsoc = Cursor_personbo.GetString("RAGSOC");
            /* indirizzo := personbo->DOMICILIO */
            indirizzo = Cursor_personbo.GetString("DOMICILIO");
            /* citres := personbo->DESCCIT */
            citres = Cursor_personbo.GetString("DESCCIT");
            /* capres := personbo->CAP */
            capres = Cursor_personbo.GetString("CAP");
            /* cabres := personbo->CODCAB */
            cabres = Cursor_personbo.GetString("CODCAB");
            /* prvres := personbo->PROVINCIA */
            prvres = Cursor_personbo.GetString("PROVINCIA");
            /* stares := '' */
            stares = "";
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
              stares = Read_Cursor.GetString("DESCRI");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbstati into routine arrt_stprappo_ae returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              stares = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* citnas := personbo->NASCOMUN */
            citnas = Cursor_personbo.GetString("NASCOMUN");
            /* prvnas := personbo->TIPINTER */
            prvnas = Cursor_personbo.GetString("TIPINTER");
            /* stanas := personbo->NASSTATO */
            stanas = Cursor_personbo.GetString("NASSTATO");
            /* sesso := iif(personbo->SESSO='1','Uomo',iif(personbo->SESSO='2','Donna','')) */
            sesso = (CPLib.eqr(Cursor_personbo.GetString("SESSO"),"1")?"Uomo":(CPLib.eqr(Cursor_personbo.GetString("SESSO"),"2")?"Donna":""));
            /* datnas := arfn_fdate(personbo->DATANASC) */
            datnas = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_personbo.GetDate("DATANASC"));
            /* tipdoc := '' */
            tipdoc = "";
            // * --- Read from tbtipdoc
            m_cServer = m_Ctx.GetServer("tbtipdoc");
            m_cPhName = m_Ctx.GetPhName("tbtipdoc");
            m_cSql = "";
            m_cSql = m_cSql+"TIPDOC="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer),m_cServer,Cursor_personbo.GetString("TIPODOC"));
            if (m_Ctx.IsSharedTemp("tbtipdoc")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              tipdoc = Read_Cursor.GetString("DESCRI");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbtipdoc into routine arrt_stprappo_ae returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              tipdoc = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* autril := personbo->AUTRILASC */
            autril = Cursor_personbo.GetString("AUTRILASC");
            /* numdoc := personbo->NUMDOCUM */
            numdoc = Cursor_personbo.GetString("NUMDOCUM");
            /* datril := arfn_fdate(personbo->DATARILASC) */
            datril = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_personbo.GetDate("DATARILASC"));
            /* luonas := iif(personbo->TIPINTER='EE',stanas,citnas) */
            luonas = (CPLib.eqr(Cursor_personbo.GetString("TIPINTER"),"EE")?stanas:citnas);
            /* _sae := personbo->SOTGRUP */
            _sae = Cursor_personbo.GetString("SOTGRUP");
            // * --- Read from tbstgru
            m_cServer = m_Ctx.GetServer("tbstgru");
            m_cPhName = m_Ctx.GetPhName("tbstgru");
            m_cSql = "";
            m_cSql = m_cSql+"SOTGRU="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer),m_cServer,Cursor_personbo.GetString("SOTGRUP"));
            if (m_Ctx.IsSharedTemp("tbstgru")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _dsae = Read_Cursor.GetString("DESCRI");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbstgru into routine arrt_stprappo_ae returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _dsae = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* _dsae := LRTrim(_dsae) */
            _dsae = CPLib.LRTrim(_dsae);
            /* _ateco := personbo->ATTIV */
            _ateco = Cursor_personbo.GetString("ATTIV");
            // * --- Read from tbtipatt
            m_cServer = m_Ctx.GetServer("tbtipatt");
            m_cPhName = m_Ctx.GetPhName("tbtipatt");
            m_cSql = "";
            m_cSql = m_cSql+"CODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer),m_cServer,Cursor_personbo.GetString("ATTIV"));
            if (m_Ctx.IsSharedTemp("tbtipatt")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _dateco = Read_Cursor.GetString("DESCRI");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbtipatt into routine arrt_stprappo_ae returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _dateco = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* _dateco := LRTrim(_dateco) */
            _dateco = CPLib.LRTrim(_dateco);
            /* _ssin := personbo->SETTSINT */
            _ssin = Cursor_personbo.GetString("SETTSINT");
            // * --- Read from tbsetsin
            m_cServer = m_Ctx.GetServer("tbsetsin");
            m_cPhName = m_Ctx.GetPhName("tbsetsin");
            m_cSql = "";
            m_cSql = m_cSql+"SETSINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer),m_cServer,Cursor_personbo.GetString("SETTSINT"));
            if (m_Ctx.IsSharedTemp("tbsetsin")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _dssin = Read_Cursor.GetString("DESCRI");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbsetsin into routine arrt_stprappo_ae returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _dssin = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* _dssin := LRTrim(_dssin) */
            _dssin = CPLib.LRTrim(_dssin);
            /* _rae := personbo->RAMOGRUP */
            _rae = Cursor_personbo.GetString("RAMOGRUP");
            // * --- Read from tbramgru
            m_cServer = m_Ctx.GetServer("tbramgru");
            m_cPhName = m_Ctx.GetPhName("tbramgru");
            m_cSql = "";
            m_cSql = m_cSql+"RAMGRU="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"C",3,0,m_cServer),m_cServer,Cursor_personbo.GetString("RAMOGRUP"));
            if (m_Ctx.IsSharedTemp("tbramgru")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _drae = Read_Cursor.GetString("DESCRI");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbramgru into routine arrt_stprappo_ae returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _drae = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* _drae := LRTrim(_drae) */
            _drae = CPLib.LRTrim(_drae);
            Cursor_personbo.Next();
          }
          m_cConnectivityError = Cursor_personbo.ErrorMessage();
          Cursor_personbo.Close();
          // * --- End Select
          // Scrive i dati
          stringa = new Label(0,riga,rapporto);
          foglio.addCell(stringa); 
          stringa = new Label(1,riga,descrap);
          foglio.addCell(stringa); 
          stringa = new Label(2,riga,tiprap);
          foglio.addCell(stringa);
          stringa = new Label(3,riga,valuta);
          foglio.addCell(stringa);
          stringa = new Label(4,riga,cf);
          foglio.addCell(stringa); 
          stringa = new Label(5,riga,_ragsoc);
          foglio.addCell(stringa);
          stringa = new Label(6,riga,stares);
          foglio.addCell(stringa); 
          stringa = new Label(7,riga,citres);
          foglio.addCell(stringa); 
          stringa = new Label(8,riga,indirizzo);
          foglio.addCell(stringa); 
          stringa = new Label(9,riga,capres);
          foglio.addCell(stringa); 
          stringa = new Label(10,riga,cabres);
          foglio.addCell(stringa); 
          stringa = new Label(11,riga,prvres);
          foglio.addCell(stringa); 
          stringa = new Label(12,riga,luonas);
          foglio.addCell(stringa); 
          stringa = new Label(13,riga,prvnas);
          foglio.addCell(stringa);
          stringa = new Label(14,riga,datnas);
          foglio.addCell(stringa);
          stringa = new Label(15,riga,sesso);
          foglio.addCell(stringa);
          stringa = new Label(16,riga,tipdoc);
          foglio.addCell(stringa);
          stringa = new Label(17,riga,numdoc);
          foglio.addCell(stringa);
          stringa = new Label(18,riga,datril);
          foglio.addCell(stringa);
          stringa = new Label(19,riga,autril);
          foglio.addCell(stringa);
          stringa = new Label(20,riga,connes);
          foglio.addCell(stringa);
          stringa = new Label(21,riga,_sae);
          foglio.addCell(stringa);
          stringa = new Label(22,riga,_dsae);
          foglio.addCell(stringa);
          stringa = new Label(23,riga,_rae);
          foglio.addCell(stringa);
          stringa = new Label(24,riga,_drae);
          foglio.addCell(stringa);
          stringa = new Label(25,riga,_ateco);
          foglio.addCell(stringa);
          stringa = new Label(26,riga,_dateco);
          foglio.addCell(stringa);
          stringa = new Label(27,riga,_ssin);
          foglio.addCell(stringa);
          stringa = new Label(28,riga,_dssin);
          foglio.addCell(stringa);
          stringa = new Label(29,riga,dataini);
          foglio.addCell(stringa);
          stringa = new Label(30,riga,datafin);
          foglio.addCell(stringa);
          stringa = new Label(31,riga,"INTESTATARIO");
          foglio.addCell(stringa);
          riga = riga + 1;
          /* If w_flgtit='S' */
          if (CPLib.eqr(w_flgtit,"S")) {
            /* If w_noaui='N' */
            if (CPLib.eqr(w_noaui,"N")) {
              // * --- Select from intestit
              m_cServer = m_Ctx.GetServer("intestit");
              m_cPhName = m_Ctx.GetPhName("intestit");
              if (Cursor_intestit!=null)
                Cursor_intestit.Close();
              Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPLib.ToSQL(Cursor_jntestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_intestit.Eof())) {
                /* dataini := arfn_fdate(intestit->DATAINI) */
                dataini = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_intestit.GetDate("DATAINI"));
                /* datafin := arfn_fdate(intestit->DATAFINE) */
                datafin = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_intestit.GetDate("DATAFINE"));
                /* cf := '' */
                cf = "";
                /* _ragsoc := '' */
                _ragsoc = "";
                /* indirizzo := '' */
                indirizzo = "";
                /* citres := '' */
                citres = "";
                /* capres := '' */
                capres = "";
                /* cabres := '' */
                cabres = "";
                /* prvres := '' */
                prvres = "";
                /* stares := '' */
                stares = "";
                /* citnas := '' */
                citnas = "";
                /* prvnas := '' */
                prvnas = "";
                /* stanas := '' */
                stanas = "";
                /* sesso := '' */
                sesso = "";
                /* datnas := '' */
                datnas = "";
                /* tipdoc := '' */
                tipdoc = "";
                /* autril := '' */
                autril = "";
                /* numdoc := '' */
                numdoc = "";
                /* datril := '' */
                datril = "";
                /* luonas := '' */
                luonas = "";
                /* _sae := '' */
                _sae = "";
                /* _dsae := '' */
                _dsae = "";
                /* _ateco := '' */
                _ateco = "";
                /* _dateco := '' */
                _dateco = "";
                /* _ssin := '' */
                _ssin = "";
                /* _dssin := '' */
                _dssin = "";
                /* _rae := '' */
                _rae = "";
                /* _drae := '' */
                _drae = "";
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestit.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* connes := personbo->CONNES */
                  connes = Cursor_personbo.GetString("CONNES");
                  /* cf := personbo->CODFISC */
                  cf = Cursor_personbo.GetString("CODFISC");
                  /* _ragsoc := personbo->RAGSOC */
                  _ragsoc = Cursor_personbo.GetString("RAGSOC");
                  /* indirizzo := personbo->DOMICILIO */
                  indirizzo = Cursor_personbo.GetString("DOMICILIO");
                  /* citres := personbo->DESCCIT */
                  citres = Cursor_personbo.GetString("DESCCIT");
                  /* capres := personbo->CAP */
                  capres = Cursor_personbo.GetString("CAP");
                  /* cabres := personbo->CODCAB */
                  cabres = Cursor_personbo.GetString("CODCAB");
                  /* prvres := personbo->PROVINCIA */
                  prvres = Cursor_personbo.GetString("PROVINCIA");
                  /* stares := '' */
                  stares = "";
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
                    stares = Read_Cursor.GetString("DESCRI");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on tbstati into routine arrt_stprappo_ae returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    stares = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* citnas := personbo->NASCOMUN */
                  citnas = Cursor_personbo.GetString("NASCOMUN");
                  /* prvnas := personbo->TIPINTER */
                  prvnas = Cursor_personbo.GetString("TIPINTER");
                  /* stanas := personbo->NASSTATO */
                  stanas = Cursor_personbo.GetString("NASSTATO");
                  /* sesso := iif(personbo->SESSO='1','Uomo',iif(personbo->SESSO='2','Donna','')) */
                  sesso = (CPLib.eqr(Cursor_personbo.GetString("SESSO"),"1")?"Uomo":(CPLib.eqr(Cursor_personbo.GetString("SESSO"),"2")?"Donna":""));
                  /* datnas := arfn_fdate(personbo->DATANASC) */
                  datnas = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_personbo.GetDate("DATANASC"));
                  /* tipdoc := '' */
                  tipdoc = "";
                  // * --- Read from tbtipdoc
                  m_cServer = m_Ctx.GetServer("tbtipdoc");
                  m_cPhName = m_Ctx.GetPhName("tbtipdoc");
                  m_cSql = "";
                  m_cSql = m_cSql+"TIPDOC="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer),m_cServer,Cursor_personbo.GetString("TIPODOC"));
                  if (m_Ctx.IsSharedTemp("tbtipdoc")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    tipdoc = Read_Cursor.GetString("DESCRI");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on tbtipdoc into routine arrt_stprappo_ae returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    tipdoc = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* autril := personbo->AUTRILASC */
                  autril = Cursor_personbo.GetString("AUTRILASC");
                  /* numdoc := personbo->NUMDOCUM */
                  numdoc = Cursor_personbo.GetString("NUMDOCUM");
                  /* datril := arfn_fdate(personbo->DATARILASC) */
                  datril = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_personbo.GetDate("DATARILASC"));
                  /* luonas := iif(personbo->TIPINTER='EE',stanas,citnas) */
                  luonas = (CPLib.eqr(Cursor_personbo.GetString("TIPINTER"),"EE")?stanas:citnas);
                  /* _sae := personbo->SOTGRUP */
                  _sae = Cursor_personbo.GetString("SOTGRUP");
                  // * --- Read from tbstgru
                  m_cServer = m_Ctx.GetServer("tbstgru");
                  m_cPhName = m_Ctx.GetPhName("tbstgru");
                  m_cSql = "";
                  m_cSql = m_cSql+"SOTGRU="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer),m_cServer,Cursor_personbo.GetString("SOTGRUP"));
                  if (m_Ctx.IsSharedTemp("tbstgru")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _dsae = Read_Cursor.GetString("DESCRI");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on tbstgru into routine arrt_stprappo_ae returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _dsae = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* _dsae := LRTrim(_dsae) */
                  _dsae = CPLib.LRTrim(_dsae);
                  /* _ateco := personbo->ATTIV */
                  _ateco = Cursor_personbo.GetString("ATTIV");
                  // * --- Read from tbtipatt
                  m_cServer = m_Ctx.GetServer("tbtipatt");
                  m_cPhName = m_Ctx.GetPhName("tbtipatt");
                  m_cSql = "";
                  m_cSql = m_cSql+"CODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer),m_cServer,Cursor_personbo.GetString("ATTIV"));
                  if (m_Ctx.IsSharedTemp("tbtipatt")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _dateco = Read_Cursor.GetString("DESCRI");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on tbtipatt into routine arrt_stprappo_ae returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _dateco = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* _dateco := LRTrim(_dateco) */
                  _dateco = CPLib.LRTrim(_dateco);
                  /* _ssin := personbo->SETTSINT */
                  _ssin = Cursor_personbo.GetString("SETTSINT");
                  // * --- Read from tbsetsin
                  m_cServer = m_Ctx.GetServer("tbsetsin");
                  m_cPhName = m_Ctx.GetPhName("tbsetsin");
                  m_cSql = "";
                  m_cSql = m_cSql+"SETSINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer),m_cServer,Cursor_personbo.GetString("SETTSINT"));
                  if (m_Ctx.IsSharedTemp("tbsetsin")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _dssin = Read_Cursor.GetString("DESCRI");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on tbsetsin into routine arrt_stprappo_ae returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _dssin = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* _dssin := LRTrim(_dssin) */
                  _dssin = CPLib.LRTrim(_dssin);
                  /* _rae := personbo->RAMOGRUP */
                  _rae = Cursor_personbo.GetString("RAMOGRUP");
                  // * --- Read from tbramgru
                  m_cServer = m_Ctx.GetServer("tbramgru");
                  m_cPhName = m_Ctx.GetPhName("tbramgru");
                  m_cSql = "";
                  m_cSql = m_cSql+"RAMGRU="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"C",3,0,m_cServer),m_cServer,Cursor_personbo.GetString("RAMOGRUP"));
                  if (m_Ctx.IsSharedTemp("tbramgru")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _drae = Read_Cursor.GetString("DESCRI");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on tbramgru into routine arrt_stprappo_ae returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _drae = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* _drae := LRTrim(_drae) */
                  _drae = CPLib.LRTrim(_drae);
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
                // Scrive i dati
                stringa = new Label(0,riga,rapporto);
                foglio.addCell(stringa); 
                stringa = new Label(1,riga,descrap);
                foglio.addCell(stringa); 
                stringa = new Label(2,riga,tiprap);
                foglio.addCell(stringa);
                stringa = new Label(3,riga,valuta);
                foglio.addCell(stringa);
                stringa = new Label(4,riga,cf);
                foglio.addCell(stringa); 
                stringa = new Label(5,riga,_ragsoc);
                foglio.addCell(stringa);
                stringa = new Label(6,riga,stares);
                foglio.addCell(stringa); 
                stringa = new Label(7,riga,citres);
                foglio.addCell(stringa); 
                stringa = new Label(8,riga,indirizzo);
                foglio.addCell(stringa); 
                stringa = new Label(9,riga,capres);
                foglio.addCell(stringa); 
                stringa = new Label(10,riga,cabres);
                foglio.addCell(stringa); 
                stringa = new Label(11,riga,prvres);
                foglio.addCell(stringa); 
                stringa = new Label(12,riga,luonas);
                foglio.addCell(stringa); 
                stringa = new Label(13,riga,prvnas);
                foglio.addCell(stringa);
                stringa = new Label(14,riga,datnas);
                foglio.addCell(stringa);
                stringa = new Label(15,riga,sesso);
                foglio.addCell(stringa);
                stringa = new Label(16,riga,tipdoc);
                foglio.addCell(stringa);
                stringa = new Label(17,riga,numdoc);
                foglio.addCell(stringa);
                stringa = new Label(18,riga,datril);
                foglio.addCell(stringa);
                stringa = new Label(19,riga,autril);
                foglio.addCell(stringa);
                stringa = new Label(20,riga,connes);
                foglio.addCell(stringa);
                stringa = new Label(21,riga,_sae);
                foglio.addCell(stringa);
                stringa = new Label(22,riga,_dsae);
                foglio.addCell(stringa);
                stringa = new Label(23,riga,_rae);
                foglio.addCell(stringa);
                stringa = new Label(24,riga,_drae);
                foglio.addCell(stringa);
                stringa = new Label(25,riga,_ateco);
                foglio.addCell(stringa);
                stringa = new Label(26,riga,_dateco);
                foglio.addCell(stringa);
                stringa = new Label(27,riga,_ssin);
                foglio.addCell(stringa);
                stringa = new Label(28,riga,_dssin);
                foglio.addCell(stringa);
                stringa = new Label(29,riga,dataini);
                foglio.addCell(stringa);
                stringa = new Label(30,riga,datafin);
                foglio.addCell(stringa);
                stringa = new Label(31,riga,"TITOLARE");
                foglio.addCell(stringa);
                riga = riga + 1;
                Cursor_intestit.Next();
              }
              m_cConnectivityError = Cursor_intestit.ErrorMessage();
              Cursor_intestit.Close();
              // * --- End Select
            } // End If
            // * --- Select from jntestit
            m_cServer = m_Ctx.GetServer("jntestit");
            m_cPhName = m_Ctx.GetPhName("jntestit");
            if (Cursor_jntestit!=null)
              Cursor_jntestit.Close();
            Cursor_jntestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPLib.ToSQL(Cursor_jntestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("jntestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_jntestit.Eof())) {
              /* dataini := arfn_fdate(jntestit->DATAINI) */
              dataini = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_jntestit.GetDate("DATAINI"));
              /* datafin := arfn_fdate(jntestit->DATAFINE) */
              datafin = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_jntestit.GetDate("DATAFINE"));
              /* cf := '' */
              cf = "";
              /* _ragsoc := '' */
              _ragsoc = "";
              /* indirizzo := '' */
              indirizzo = "";
              /* citres := '' */
              citres = "";
              /* capres := '' */
              capres = "";
              /* cabres := '' */
              cabres = "";
              /* prvres := '' */
              prvres = "";
              /* stares := '' */
              stares = "";
              /* citnas := '' */
              citnas = "";
              /* prvnas := '' */
              prvnas = "";
              /* stanas := '' */
              stanas = "";
              /* sesso := '' */
              sesso = "";
              /* datnas := '' */
              datnas = "";
              /* tipdoc := '' */
              tipdoc = "";
              /* autril := '' */
              autril = "";
              /* numdoc := '' */
              numdoc = "";
              /* datril := '' */
              datril = "";
              /* luonas := '' */
              luonas = "";
              /* _sae := '' */
              _sae = "";
              /* _dsae := '' */
              _dsae = "";
              /* _ateco := '' */
              _ateco = "";
              /* _dateco := '' */
              _dateco = "";
              /* _ssin := '' */
              _ssin = "";
              /* _dssin := '' */
              _dssin = "";
              /* _rae := '' */
              _rae = "";
              /* _drae := '' */
              _drae = "";
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_jntestit.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                /* connes := personbo->CONNES */
                connes = Cursor_personbo.GetString("CONNES");
                /* cf := personbo->CODFISC */
                cf = Cursor_personbo.GetString("CODFISC");
                /* _ragsoc := personbo->RAGSOC */
                _ragsoc = Cursor_personbo.GetString("RAGSOC");
                /* indirizzo := personbo->DOMICILIO */
                indirizzo = Cursor_personbo.GetString("DOMICILIO");
                /* citres := personbo->DESCCIT */
                citres = Cursor_personbo.GetString("DESCCIT");
                /* capres := personbo->CAP */
                capres = Cursor_personbo.GetString("CAP");
                /* cabres := personbo->CODCAB */
                cabres = Cursor_personbo.GetString("CODCAB");
                /* prvres := personbo->PROVINCIA */
                prvres = Cursor_personbo.GetString("PROVINCIA");
                /* stares := '' */
                stares = "";
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
                  stares = Read_Cursor.GetString("DESCRI");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on tbstati into routine arrt_stprappo_ae returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  stares = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* citnas := personbo->NASCOMUN */
                citnas = Cursor_personbo.GetString("NASCOMUN");
                /* prvnas := personbo->TIPINTER */
                prvnas = Cursor_personbo.GetString("TIPINTER");
                /* stanas := personbo->NASSTATO */
                stanas = Cursor_personbo.GetString("NASSTATO");
                /* sesso := iif(personbo->SESSO='1','Uomo',iif(personbo->SESSO='2','Donna','')) */
                sesso = (CPLib.eqr(Cursor_personbo.GetString("SESSO"),"1")?"Uomo":(CPLib.eqr(Cursor_personbo.GetString("SESSO"),"2")?"Donna":""));
                /* datnas := arfn_fdate(personbo->DATANASC) */
                datnas = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_personbo.GetDate("DATANASC"));
                /* tipdoc := '' */
                tipdoc = "";
                // * --- Read from tbtipdoc
                m_cServer = m_Ctx.GetServer("tbtipdoc");
                m_cPhName = m_Ctx.GetPhName("tbtipdoc");
                m_cSql = "";
                m_cSql = m_cSql+"TIPDOC="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer),m_cServer,Cursor_personbo.GetString("TIPODOC"));
                if (m_Ctx.IsSharedTemp("tbtipdoc")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  tipdoc = Read_Cursor.GetString("DESCRI");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on tbtipdoc into routine arrt_stprappo_ae returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  tipdoc = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* autril := personbo->AUTRILASC */
                autril = Cursor_personbo.GetString("AUTRILASC");
                /* numdoc := personbo->NUMDOCUM */
                numdoc = Cursor_personbo.GetString("NUMDOCUM");
                /* datril := arfn_fdate(personbo->DATARILASC) */
                datril = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_personbo.GetDate("DATARILASC"));
                /* luonas := iif(personbo->TIPINTER='EE',stanas,citnas) */
                luonas = (CPLib.eqr(Cursor_personbo.GetString("TIPINTER"),"EE")?stanas:citnas);
                /* _sae := personbo->SOTGRUP */
                _sae = Cursor_personbo.GetString("SOTGRUP");
                // * --- Read from tbstgru
                m_cServer = m_Ctx.GetServer("tbstgru");
                m_cPhName = m_Ctx.GetPhName("tbstgru");
                m_cSql = "";
                m_cSql = m_cSql+"SOTGRU="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer),m_cServer,Cursor_personbo.GetString("SOTGRUP"));
                if (m_Ctx.IsSharedTemp("tbstgru")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _dsae = Read_Cursor.GetString("DESCRI");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on tbstgru into routine arrt_stprappo_ae returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _dsae = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* _dsae := LRTrim(_dsae) */
                _dsae = CPLib.LRTrim(_dsae);
                /* _ateco := personbo->ATTIV */
                _ateco = Cursor_personbo.GetString("ATTIV");
                // * --- Read from tbtipatt
                m_cServer = m_Ctx.GetServer("tbtipatt");
                m_cPhName = m_Ctx.GetPhName("tbtipatt");
                m_cSql = "";
                m_cSql = m_cSql+"CODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer),m_cServer,Cursor_personbo.GetString("ATTIV"));
                if (m_Ctx.IsSharedTemp("tbtipatt")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _dateco = Read_Cursor.GetString("DESCRI");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on tbtipatt into routine arrt_stprappo_ae returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _dateco = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* _dateco := LRTrim(_dateco) */
                _dateco = CPLib.LRTrim(_dateco);
                /* _ssin := personbo->SETTSINT */
                _ssin = Cursor_personbo.GetString("SETTSINT");
                // * --- Read from tbsetsin
                m_cServer = m_Ctx.GetServer("tbsetsin");
                m_cPhName = m_Ctx.GetPhName("tbsetsin");
                m_cSql = "";
                m_cSql = m_cSql+"SETSINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer),m_cServer,Cursor_personbo.GetString("SETTSINT"));
                if (m_Ctx.IsSharedTemp("tbsetsin")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _dssin = Read_Cursor.GetString("DESCRI");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on tbsetsin into routine arrt_stprappo_ae returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _dssin = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* _dssin := LRTrim(_dssin) */
                _dssin = CPLib.LRTrim(_dssin);
                /* _rae := personbo->RAMOGRUP */
                _rae = Cursor_personbo.GetString("RAMOGRUP");
                // * --- Read from tbramgru
                m_cServer = m_Ctx.GetServer("tbramgru");
                m_cPhName = m_Ctx.GetPhName("tbramgru");
                m_cSql = "";
                m_cSql = m_cSql+"RAMGRU="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"C",3,0,m_cServer),m_cServer,Cursor_personbo.GetString("RAMOGRUP"));
                if (m_Ctx.IsSharedTemp("tbramgru")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _drae = Read_Cursor.GetString("DESCRI");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on tbramgru into routine arrt_stprappo_ae returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _drae = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* _drae := LRTrim(_drae) */
                _drae = CPLib.LRTrim(_drae);
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
              // Scrive i dati
              stringa = new Label(0,riga,rapporto);
              foglio.addCell(stringa); 
              stringa = new Label(1,riga,descrap);
              foglio.addCell(stringa); 
              stringa = new Label(2,riga,tiprap);
              foglio.addCell(stringa);
              stringa = new Label(3,riga,valuta);
              foglio.addCell(stringa);
              stringa = new Label(4,riga,cf);
              foglio.addCell(stringa); 
              stringa = new Label(5,riga,_ragsoc);
              foglio.addCell(stringa);
              stringa = new Label(6,riga,stares);
              foglio.addCell(stringa); 
              stringa = new Label(7,riga,citres);
              foglio.addCell(stringa); 
              stringa = new Label(8,riga,indirizzo);
              foglio.addCell(stringa); 
              stringa = new Label(9,riga,capres);
              foglio.addCell(stringa); 
              stringa = new Label(10,riga,cabres);
              foglio.addCell(stringa); 
              stringa = new Label(11,riga,prvres);
              foglio.addCell(stringa); 
              stringa = new Label(12,riga,luonas);
              foglio.addCell(stringa); 
              stringa = new Label(13,riga,prvnas);
              foglio.addCell(stringa);
              stringa = new Label(14,riga,datnas);
              foglio.addCell(stringa);
              stringa = new Label(15,riga,sesso);
              foglio.addCell(stringa);
              stringa = new Label(16,riga,tipdoc);
              foglio.addCell(stringa);
              stringa = new Label(17,riga,numdoc);
              foglio.addCell(stringa);
              stringa = new Label(18,riga,datril);
              foglio.addCell(stringa);
              stringa = new Label(19,riga,autril);
              foglio.addCell(stringa);
              stringa = new Label(20,riga,connes);
              foglio.addCell(stringa);
              stringa = new Label(21,riga,_sae);
              foglio.addCell(stringa);
              stringa = new Label(22,riga,_dsae);
              foglio.addCell(stringa);
              stringa = new Label(23,riga,_rae);
              foglio.addCell(stringa);
              stringa = new Label(24,riga,_drae);
              foglio.addCell(stringa);
              stringa = new Label(25,riga,_ateco);
              foglio.addCell(stringa);
              stringa = new Label(26,riga,_dateco);
              foglio.addCell(stringa);
              stringa = new Label(27,riga,_ssin);
              foglio.addCell(stringa);
              stringa = new Label(28,riga,_dssin);
              foglio.addCell(stringa);
              stringa = new Label(29,riga,dataini);
              foglio.addCell(stringa);
              stringa = new Label(30,riga,datafin);
              foglio.addCell(stringa);
              stringa = new Label(31,riga,"TITOLARE");
              foglio.addCell(stringa);
              riga = riga + 1;
              Cursor_jntestit.Next();
            }
            m_cConnectivityError = Cursor_jntestit.ErrorMessage();
            Cursor_jntestit.Close();
            // * --- End Select
          } // End If
          Cursor_jntestbo.Next();
        }
        m_cConnectivityError = Cursor_jntestbo.ErrorMessage();
        Cursor_jntestbo.Close();
        // * --- End Select
        /* If w_flgdel='S' */
        if (CPLib.eqr(w_flgdel,"S")) {
          // * --- Select from jelegabo
          m_cServer = m_Ctx.GetServer("jelegabo");
          m_cPhName = m_Ctx.GetPhName("jelegabo");
          if (Cursor_jelegabo!=null)
            Cursor_jelegabo.Close();
          Cursor_jelegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER,DATAINI,DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapporti_xls_dett_ae.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("jelegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_jelegabo.Eof())) {
            /* connes := jelegabo->CODINTER */
            connes = Cursor_jelegabo.GetString("CODINTER");
            /* dataini := arfn_fdate(jelegabo->DATAINI) */
            dataini = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_jelegabo.GetDate("DATAINI"));
            /* datafin := arfn_fdate(jelegabo->DATAFINE) */
            datafin = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_jelegabo.GetDate("DATAFINE"));
            /* cf := '' */
            cf = "";
            /* _ragsoc := '' */
            _ragsoc = "";
            /* indirizzo := '' */
            indirizzo = "";
            /* citres := '' */
            citres = "";
            /* capres := '' */
            capres = "";
            /* cabres := '' */
            cabres = "";
            /* prvres := '' */
            prvres = "";
            /* stares := '' */
            stares = "";
            /* citnas := '' */
            citnas = "";
            /* prvnas := '' */
            prvnas = "";
            /* stanas := '' */
            stanas = "";
            /* sesso := '' */
            sesso = "";
            /* datnas := '' */
            datnas = "";
            /* tipdoc := '' */
            tipdoc = "";
            /* autril := '' */
            autril = "";
            /* numdoc := '' */
            numdoc = "";
            /* datril := '' */
            datril = "";
            /* luonas := '' */
            luonas = "";
            /* _sae := '' */
            _sae = "";
            /* _dsae := '' */
            _dsae = "";
            /* _ateco := '' */
            _ateco = "";
            /* _dateco := '' */
            _dateco = "";
            /* _ssin := '' */
            _ssin = "";
            /* _dssin := '' */
            _dssin = "";
            /* _rae := '' */
            _rae = "";
            /* _drae := '' */
            _drae = "";
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_jelegabo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              /* cf := personbo->CODFISC */
              cf = Cursor_personbo.GetString("CODFISC");
              /* _ragsoc := personbo->RAGSOC */
              _ragsoc = Cursor_personbo.GetString("RAGSOC");
              /* indirizzo := personbo->DOMICILIO */
              indirizzo = Cursor_personbo.GetString("DOMICILIO");
              /* citres := personbo->DESCCIT */
              citres = Cursor_personbo.GetString("DESCCIT");
              /* capres := personbo->CAP */
              capres = Cursor_personbo.GetString("CAP");
              /* cabres := personbo->CODCAB */
              cabres = Cursor_personbo.GetString("CODCAB");
              /* prvres := personbo->PROVINCIA */
              prvres = Cursor_personbo.GetString("PROVINCIA");
              /* stares := '' */
              stares = "";
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
                stares = Read_Cursor.GetString("DESCRI");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbstati into routine arrt_stprappo_ae returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                stares = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* citnas := personbo->NASCOMUN */
              citnas = Cursor_personbo.GetString("NASCOMUN");
              /* prvnas := personbo->TIPINTER */
              prvnas = Cursor_personbo.GetString("TIPINTER");
              /* stanas := personbo->NASSTATO */
              stanas = Cursor_personbo.GetString("NASSTATO");
              /* sesso := iif(personbo->SESSO='1','Uomo',iif(personbo->SESSO='2','Donna','')) */
              sesso = (CPLib.eqr(Cursor_personbo.GetString("SESSO"),"1")?"Uomo":(CPLib.eqr(Cursor_personbo.GetString("SESSO"),"2")?"Donna":""));
              /* datnas := arfn_fdate(personbo->DATANASC) */
              datnas = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_personbo.GetDate("DATANASC"));
              /* tipdoc := '' */
              tipdoc = "";
              // * --- Read from tbtipdoc
              m_cServer = m_Ctx.GetServer("tbtipdoc");
              m_cPhName = m_Ctx.GetPhName("tbtipdoc");
              m_cSql = "";
              m_cSql = m_cSql+"TIPDOC="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer),m_cServer,Cursor_personbo.GetString("TIPODOC"));
              if (m_Ctx.IsSharedTemp("tbtipdoc")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                tipdoc = Read_Cursor.GetString("DESCRI");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbtipdoc into routine arrt_stprappo_ae returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                tipdoc = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* autril := personbo->AUTRILASC */
              autril = Cursor_personbo.GetString("AUTRILASC");
              /* numdoc := personbo->NUMDOCUM */
              numdoc = Cursor_personbo.GetString("NUMDOCUM");
              /* datril := arfn_fdate(personbo->DATARILASC) */
              datril = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_personbo.GetDate("DATARILASC"));
              /* luonas := iif(personbo->TIPINTER='EE',stanas,citnas) */
              luonas = (CPLib.eqr(Cursor_personbo.GetString("TIPINTER"),"EE")?stanas:citnas);
              /* _sae := personbo->SOTGRUP */
              _sae = Cursor_personbo.GetString("SOTGRUP");
              // * --- Read from tbstgru
              m_cServer = m_Ctx.GetServer("tbstgru");
              m_cPhName = m_Ctx.GetPhName("tbstgru");
              m_cSql = "";
              m_cSql = m_cSql+"SOTGRU="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer),m_cServer,Cursor_personbo.GetString("SOTGRUP"));
              if (m_Ctx.IsSharedTemp("tbstgru")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _dsae = Read_Cursor.GetString("DESCRI");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbstgru into routine arrt_stprappo_ae returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _dsae = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* _dsae := LRTrim(_dsae) */
              _dsae = CPLib.LRTrim(_dsae);
              /* _ateco := personbo->ATTIV */
              _ateco = Cursor_personbo.GetString("ATTIV");
              // * --- Read from tbtipatt
              m_cServer = m_Ctx.GetServer("tbtipatt");
              m_cPhName = m_Ctx.GetPhName("tbtipatt");
              m_cSql = "";
              m_cSql = m_cSql+"CODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer),m_cServer,Cursor_personbo.GetString("ATTIV"));
              if (m_Ctx.IsSharedTemp("tbtipatt")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _dateco = Read_Cursor.GetString("DESCRI");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbtipatt into routine arrt_stprappo_ae returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _dateco = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* _dateco := LRTrim(_dateco) */
              _dateco = CPLib.LRTrim(_dateco);
              /* _ssin := personbo->SETTSINT */
              _ssin = Cursor_personbo.GetString("SETTSINT");
              // * --- Read from tbsetsin
              m_cServer = m_Ctx.GetServer("tbsetsin");
              m_cPhName = m_Ctx.GetPhName("tbsetsin");
              m_cSql = "";
              m_cSql = m_cSql+"SETSINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer),m_cServer,Cursor_personbo.GetString("SETTSINT"));
              if (m_Ctx.IsSharedTemp("tbsetsin")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _dssin = Read_Cursor.GetString("DESCRI");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbsetsin into routine arrt_stprappo_ae returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _dssin = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* _dssin := LRTrim(_dssin) */
              _dssin = CPLib.LRTrim(_dssin);
              /* _rae := personbo->RAMOGRUP */
              _rae = Cursor_personbo.GetString("RAMOGRUP");
              // * --- Read from tbramgru
              m_cServer = m_Ctx.GetServer("tbramgru");
              m_cPhName = m_Ctx.GetPhName("tbramgru");
              m_cSql = "";
              m_cSql = m_cSql+"RAMGRU="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"C",3,0,m_cServer),m_cServer,Cursor_personbo.GetString("RAMOGRUP"));
              if (m_Ctx.IsSharedTemp("tbramgru")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _drae = Read_Cursor.GetString("DESCRI");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbramgru into routine arrt_stprappo_ae returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _drae = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* _drae := LRTrim(_drae) */
              _drae = CPLib.LRTrim(_drae);
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
            // Scrive i dati
            stringa = new Label(0,riga,rapporto);
            foglio.addCell(stringa); 
            stringa = new Label(1,riga,descrap);
            foglio.addCell(stringa); 
            stringa = new Label(2,riga,tiprap);
            foglio.addCell(stringa);
            stringa = new Label(3,riga,valuta);
            foglio.addCell(stringa);
            stringa = new Label(4,riga,cf);
            foglio.addCell(stringa); 
            stringa = new Label(5,riga,_ragsoc);
            foglio.addCell(stringa);
            stringa = new Label(6,riga,stares);
            foglio.addCell(stringa); 
            stringa = new Label(7,riga,citres);
            foglio.addCell(stringa); 
            stringa = new Label(8,riga,indirizzo);
            foglio.addCell(stringa); 
            stringa = new Label(9,riga,capres);
            foglio.addCell(stringa); 
            stringa = new Label(10,riga,cabres);
            foglio.addCell(stringa); 
            stringa = new Label(11,riga,prvres);
            foglio.addCell(stringa); 
            stringa = new Label(12,riga,luonas);
            foglio.addCell(stringa); 
            stringa = new Label(13,riga,prvnas);
            foglio.addCell(stringa);
            stringa = new Label(14,riga,datnas);
            foglio.addCell(stringa);
            stringa = new Label(15,riga,sesso);
            foglio.addCell(stringa);
            stringa = new Label(16,riga,tipdoc);
            foglio.addCell(stringa);
            stringa = new Label(17,riga,numdoc);
            foglio.addCell(stringa);
            stringa = new Label(18,riga,datril);
            foglio.addCell(stringa);
            stringa = new Label(19,riga,autril);
            foglio.addCell(stringa);
            stringa = new Label(20,riga,connes);
            foglio.addCell(stringa);
            stringa = new Label(21,riga,_sae);
            foglio.addCell(stringa);
            stringa = new Label(22,riga,_dsae);
            foglio.addCell(stringa);
            stringa = new Label(23,riga,_rae);
            foglio.addCell(stringa);
            stringa = new Label(24,riga,_drae);
            foglio.addCell(stringa);
            stringa = new Label(25,riga,_ateco);
            foglio.addCell(stringa);
            stringa = new Label(26,riga,_dateco);
            foglio.addCell(stringa);
            stringa = new Label(27,riga,_ssin);
            foglio.addCell(stringa);
            stringa = new Label(28,riga,_dssin);
            foglio.addCell(stringa);
            stringa = new Label(29,riga,dataini);
            foglio.addCell(stringa);
            stringa = new Label(30,riga,datafin);
            foglio.addCell(stringa);
            stringa = new Label(31,riga,"DELEGATO");
            foglio.addCell(stringa);
            riga = riga + 1;
            Cursor_jelegabo.Next();
          }
          m_cConnectivityError = Cursor_jelegabo.ErrorMessage();
          Cursor_jelegabo.Close();
          // * --- End Select
        } // End If
        Cursor_qbe_rapporti_xls_dett_ae.Next();
      }
      m_cConnectivityError = Cursor_qbe_rapporti_xls_dett_ae.ErrorMessage();
      Cursor_qbe_rapporti_xls_dett_ae.Close();
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
      foglio.setColumnView(24, cf);
      foglio.setColumnView(25, cf);
      foglio.setColumnView(26, cf);
      foglio.setColumnView(27, cf);
      foglio.setColumnView(28, cf);
      foglio.setColumnView(29, cf);
      foglio.setColumnView(30, cf);
      foglio.setColumnView(31, cf);
      prova.write();
      prova.close();
      /* gMsgImp := "Elaborazione Terminata !" // Messaggio Import */
      gMsgImp = "Elaborazione Terminata !";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Cursor_qbe_rapporti_xls_dett_ae!=null)
          Cursor_qbe_rapporti_xls_dett_ae.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jntestbo!=null)
          Cursor_jntestbo.Close();
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
      try {
        if (Cursor_intestit!=null)
          Cursor_intestit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jntestit!=null)
          Cursor_jntestit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jelegabo!=null)
          Cursor_jelegabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pTipo) {
    pTipo = p_pTipo;
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
  public Forward Run(String p_pTipo) {
    pTipo = p_pTipo;
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
      m_Caller.SetString("daRappo","C",25,0,w_daRappo);
      m_Caller.SetString("aRappo","C",25,0,w_aRappo);
      m_Caller.SetDate("DaData","D",8,0,w_DaData);
      m_Caller.SetDate("AData","D",8,0,w_AData);
      m_Caller.SetString("c_dadata","C",8,0,w_c_dadata);
      m_Caller.SetString("c_adata","C",8,0,w_c_adata);
      m_Caller.SetString("detope","C",1,0,w_detope);
      m_Caller.SetString("attiva","C",1,0,w_attiva);
      m_Caller.SetString("mod_attiva","C",1,0,w_mod_attiva);
      m_Caller.SetString("cancellata","C",1,0,w_cancellata);
      m_Caller.SetString("mod_copia","C",1,0,w_mod_copia);
      m_Caller.SetString("tipo","C",1,0,w_tipo);
      m_Caller.SetString("detana","C",1,0,w_detana);
      m_Caller.SetString("flgtit","C",1,0,w_flgtit);
      m_Caller.SetString("flgdel","C",1,0,w_flgdel);
      m_Caller.SetString("coddip","C",6,0,w_coddip);
      m_Caller.SetString("noaui","C",1,0,w_noaui);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_stprappo_aeR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_stprappo_aeR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pTipo = CPLib.Space(1);
    w_daRappo = m_Caller.GetString("daRappo","C",25,0);
    w_aRappo = m_Caller.GetString("aRappo","C",25,0);
    w_DaData = m_Caller.GetDate("DaData","D",8,0);
    w_AData = m_Caller.GetDate("AData","D",8,0);
    w_c_dadata = m_Caller.GetString("c_dadata","C",8,0);
    w_c_adata = m_Caller.GetString("c_adata","C",8,0);
    w_detope = m_Caller.GetString("detope","C",1,0);
    w_attiva = m_Caller.GetString("attiva","C",1,0);
    w_mod_attiva = m_Caller.GetString("mod_attiva","C",1,0);
    w_cancellata = m_Caller.GetString("cancellata","C",1,0);
    w_mod_copia = m_Caller.GetString("mod_copia","C",1,0);
    w_tipo = m_Caller.GetString("tipo","C",1,0);
    w_detana = m_Caller.GetString("detana","C",1,0);
    w_flgtit = m_Caller.GetString("flgtit","C",1,0);
    w_flgdel = m_Caller.GetString("flgdel","C",1,0);
    w_coddip = m_Caller.GetString("coddip","C",6,0);
    w_noaui = m_Caller.GetString("noaui","C",1,0);
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
    _crap = 0;
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    gDescAzi=m_Ctx.GetGlobalString("gDescAzi");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_allrapopebo_ae,qbe_allrapopebo_ae,qbe_allrapopebo_ae,qbe_rapporti_xls_ae,qbe_rapporti_xls_dett_ae,
  public static final String m_cVQRList = ",qbe_allrapopebo_ae,qbe_allrapopebo_ae,qbe_allrapopebo_ae,qbe_rapporti_xls_ae,qbe_rapporti_xls_dett_ae,";
  // ENTITY_BATCHES: ,arfn_fdate,
  public static final String i_InvokedRoutines = ",arfn_fdate,";
  public static String[] m_cRunParameterNames={"pTipo"};
  protected static String GetFieldsName_00000052(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stprapporti",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000057(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stprapporti",true);
    return p_cSql;
  }
}
