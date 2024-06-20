// * --- Area Manuale = BO - Header
// * --- arrt_stprappo
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
public class arrt_stprappoR implements CallerWithObjs {
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
  public String m_cPhName_delegabo;
  public String m_cServer_delegabo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_intestit;
  public String m_cServer_intestit;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_rapotit;
  public String m_cServer_rapotit;
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
  public String m_cPhName_tmp_sog_rappo;
  public String m_cServer_tmp_sog_rappo;
  public String m_cPhName_fiduciabo;
  public String m_cServer_fiduciabo;
  public String m_cPhName_tbrisglob;
  public String m_cServer_tbrisglob;
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
  public String w_DaSogg;
  public String w_ASogg;
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
  public String _customerid;
  public double _notit;
  public String _scopo;
  public String _natura;
  public String _risglob;
  public String _datprof;
  public String _datrevprof;
  public String _desrisglob;
  public String _cognome;
  public String _nome;
  public double _crap;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_stprappo
  public int riga;
  public DateTime dt;
  // * --- Fine Area Manuale
  public arrt_stprappoR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_stprappo",m_Caller);
    m_cPhName_delegabo = p_ContextObject.GetPhName("delegabo");
    if (m_cPhName_delegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_delegabo = m_cPhName_delegabo+" "+m_Ctx.GetWritePhName("delegabo");
    }
    m_cServer_delegabo = p_ContextObject.GetServer("delegabo");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_intestit = p_ContextObject.GetPhName("intestit");
    if (m_cPhName_intestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestit = m_cPhName_intestit+" "+m_Ctx.GetWritePhName("intestit");
    }
    m_cServer_intestit = p_ContextObject.GetServer("intestit");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_rapotit = p_ContextObject.GetPhName("rapotit");
    if (m_cPhName_rapotit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapotit = m_cPhName_rapotit+" "+m_Ctx.GetWritePhName("rapotit");
    }
    m_cServer_rapotit = p_ContextObject.GetServer("rapotit");
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
    if (m_Ctx.IsTmpAlreadyCreated("tmp_sog_rappo")) {
      m_cPhName_tmp_sog_rappo = p_ContextObject.GetPhName("tmp_sog_rappo");
      if (m_cPhName_tmp_sog_rappo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_sog_rappo = m_cPhName_tmp_sog_rappo+" "+m_Ctx.GetWritePhName("tmp_sog_rappo");
      }
      m_cServer_tmp_sog_rappo = p_ContextObject.GetServer("tmp_sog_rappo");
    }
    m_cPhName_fiduciabo = p_ContextObject.GetPhName("fiduciabo");
    if (m_cPhName_fiduciabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fiduciabo = m_cPhName_fiduciabo+" "+m_Ctx.GetWritePhName("fiduciabo");
    }
    m_cServer_fiduciabo = p_ContextObject.GetServer("fiduciabo");
    m_cPhName_tbrisglob = p_ContextObject.GetPhName("tbrisglob");
    if (m_cPhName_tbrisglob.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbrisglob = m_cPhName_tbrisglob+" "+m_Ctx.GetWritePhName("tbrisglob");
    }
    m_cServer_tbrisglob = p_ContextObject.GetServer("tbrisglob");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_notit",p_cVarName)) {
      return _notit;
    }
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
      return "arrt_stprappo";
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
    if (CPLib.eqr("DaSogg",p_cVarName)) {
      return w_DaSogg;
    }
    if (CPLib.eqr("ASogg",p_cVarName)) {
      return w_ASogg;
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
    if (CPLib.eqr("_customerid",p_cVarName)) {
      return _customerid;
    }
    if (CPLib.eqr("_scopo",p_cVarName)) {
      return _scopo;
    }
    if (CPLib.eqr("_natura",p_cVarName)) {
      return _natura;
    }
    if (CPLib.eqr("_risglob",p_cVarName)) {
      return _risglob;
    }
    if (CPLib.eqr("_datprof",p_cVarName)) {
      return _datprof;
    }
    if (CPLib.eqr("_datrevprof",p_cVarName)) {
      return _datrevprof;
    }
    if (CPLib.eqr("_desrisglob",p_cVarName)) {
      return _desrisglob;
    }
    if (CPLib.eqr("_cognome",p_cVarName)) {
      return _cognome;
    }
    if (CPLib.eqr("_nome",p_cVarName)) {
      return _nome;
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
    if (CPLib.eqr("_notit",p_cVarName)) {
      _notit = value;
      return;
    }
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
    if (CPLib.eqr("DaSogg",p_cVarName)) {
      w_DaSogg = value;
      return;
    }
    if (CPLib.eqr("ASogg",p_cVarName)) {
      w_ASogg = value;
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
    if (CPLib.eqr("_customerid",p_cVarName)) {
      _customerid = value;
      return;
    }
    if (CPLib.eqr("_scopo",p_cVarName)) {
      _scopo = value;
      return;
    }
    if (CPLib.eqr("_natura",p_cVarName)) {
      _natura = value;
      return;
    }
    if (CPLib.eqr("_risglob",p_cVarName)) {
      _risglob = value;
      return;
    }
    if (CPLib.eqr("_datprof",p_cVarName)) {
      _datprof = value;
      return;
    }
    if (CPLib.eqr("_datrevprof",p_cVarName)) {
      _datrevprof = value;
      return;
    }
    if (CPLib.eqr("_desrisglob",p_cVarName)) {
      _desrisglob = value;
      return;
    }
    if (CPLib.eqr("_cognome",p_cVarName)) {
      _cognome = value;
      return;
    }
    if (CPLib.eqr("_nome",p_cVarName)) {
      _nome = value;
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
    CPResultSet Cursor_qbe_allrapopebo=null;
    CPResultSet Cursor_tmp_stprapporti=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_delegabo=null;
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
      /* w_DaSogg Char(16) */
      /* w_ASogg Char(16) */
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
      /* _customerid Char(10) */
      /* _notit Numeric(1, 0) */
      /* _scopo Char(50) */
      /* _natura Char(50) */
      /* _risglob Char(40) */
      /* _datprof Char(10) */
      /* _datrevprof Char(10) */
      /* _desrisglob Char(150) */
      /* _cognome Char(30) */
      /* _nome Char(30) */
      /* Lancio la stampa */
      // * --- Drop temporary table tmp_sog_rappo
      if (m_Ctx.IsSharedTemp("tmp_sog_rappo")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_sog_rappo")) {
          m_cServer = m_Ctx.GetServer("tmp_sog_rappo");
          m_cPhName = m_Ctx.GetPhName("tmp_sog_rappo");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_sog_rappo");
      }
      // * --- Create temporary table tmp_sog_rappo
      if (m_Ctx.IsSharedTemp("tmp_sog_rappo")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_sog_rappo")) {
          m_cServer = m_Ctx.GetServer("tmp_sog_rappo");
          m_cPhName = m_Ctx.GetPhName("tmp_sog_rappo");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_sog_rappo");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_sog_rappo");
      if ( ! (m_Ctx.IsSharedTemp("tmp_sog_rappo"))) {
        m_cServer = m_Ctx.GetServer("tmp_sog_rappo");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_sog_rappo",m_cServer,"proto")),m_cPhName,"tmp_sog_rappo",m_Ctx);
      }
      m_cPhName_tmp_sog_rappo = m_cPhName;
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
          new VQRHolder("qbe_allrapopebo",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).CreateServerQuery(m_Ctx, "tmp_stprapporti",false);
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
          // * --- Select from qbe_allrapopebo
          if (Cursor_qbe_allrapopebo!=null)
            Cursor_qbe_allrapopebo.Close();
          Cursor_qbe_allrapopebo = new VQRHolder("qbe_allrapopebo",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_allrapopebo.Eof())) {
            /* If Empty(qbe_allrapopebo->DATAFINE) */
            if (CPLib.Empty(Cursor_qbe_allrapopebo.GetDate("DATAFINE"))) {
              // * --- Insert into tmp_stprapporti from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stprapporti");
              m_cPhName = m_Ctx.GetPhName("tmp_stprapporti");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stprapporti",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stprappo",136,"0000005F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000005F(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo.GetDate("DATAFINE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo.GetDate("DATAINI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo.GetString("DESCRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo.GetString("RISGLOB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo.GetDate("DATAPROF"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo.GetDate("DATAREVPROF"),"?",0,0)+", ";
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
            Cursor_qbe_allrapopebo.Next();
          }
          m_cConnectivityError = Cursor_qbe_allrapopebo.ErrorMessage();
          Cursor_qbe_allrapopebo.Close();
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
          // * --- Select from qbe_allrapopebo
          if (Cursor_qbe_allrapopebo!=null)
            Cursor_qbe_allrapopebo.Close();
          Cursor_qbe_allrapopebo = new VQRHolder("qbe_allrapopebo",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_allrapopebo.Eof())) {
            /* If not(Empty(qbe_allrapopebo->DATAFINE)) */
            if ( ! (CPLib.Empty(Cursor_qbe_allrapopebo.GetDate("DATAFINE")))) {
              // * --- Insert into tmp_stprapporti from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stprapporti");
              m_cPhName = m_Ctx.GetPhName("tmp_stprapporti");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stprapporti",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stprappo",136,"00000064")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000064(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo.GetString("DESCRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo.GetDate("DATAINI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo.GetDate("DATAFINE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo.GetString("RISGLOB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo.GetDate("DATAPROF"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo.GetDate("DATAREVPROF"),"?",0,0)+", ";
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
            Cursor_qbe_allrapopebo.Next();
          }
          m_cConnectivityError = Cursor_qbe_allrapopebo.ErrorMessage();
          Cursor_qbe_allrapopebo.Close();
          // * --- End Select
        } // End Case
        /* If w_detope='S' */
        if (CPLib.eqr(w_detope,"S")) {
          // * --- Select from tmp_stprapporti
          m_cServer = m_Ctx.GetServer("tmp_stprapporti");
          m_cPhName = m_Ctx.GetPhName("tmp_stprapporti");
          if (Cursor_tmp_stprapporti!=null)
            Cursor_tmp_stprapporti.Close();
          Cursor_tmp_stprapporti = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select RAPPORTO,NUMPROG,STATOREG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_stprapporti")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_tmp_stprapporti.Eof())) {
            /* gMsgImp := 'Esame Rapporto: '+ LRTrim(tmp_stprapporti->RAPPORTO) + " - Informazione n.: " + LRTrim(tmp_stprapporti->NUMPROG) // Messaggio Import */
            gMsgImp = "Esame Rapporto: "+CPLib.LRTrim(Cursor_tmp_stprapporti.GetString("RAPPORTO"))+" - Informazione n.: "+CPLib.LRTrim(Cursor_tmp_stprapporti.GetString("NUMPROG"));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            // * --- Select from intestbo
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            if (Cursor_intestbo!=null)
              Cursor_intestbo.Close();
            Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER,DATAINI,DATAFINE,NUMPROG1,NUMPROG2,STATOREG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_tmp_stprapporti.GetString("RAPPORTO"),"?",0,0)+"  and  (NUMPROG1="+CPLib.ToSQL(Cursor_tmp_stprapporti.GetString("NUMPROG"),"?",0,0)+"  or  NUMPROG2="+CPLib.ToSQL(Cursor_tmp_stprapporti.GetString("NUMPROG"),"?",0,0)+") "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestbo.Eof())) {
              // * --- Read from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              m_cSql = "";
              m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"C",16,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"));
              if (m_Ctx.IsSharedTemp("personbo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAGSOC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _ragsoc = Read_Cursor.GetString("RAGSOC");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on personbo into routine arrt_stprappo returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _ragsoc = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              // * --- Insert into tmp_sog_rappo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_sog_rappo");
              m_cPhName = m_Ctx.GetPhName("tmp_sog_rappo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_sog_rappo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stprappo",136,"0000006A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000006A(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_stprapporti.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_stprapporti.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_ragsoc,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetDate("DATAINI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetDate("DATAFINE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_stprapporti.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_sog_rappo",true);
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
              Cursor_intestbo.Next();
            }
            m_cConnectivityError = Cursor_intestbo.ErrorMessage();
            Cursor_intestbo.Close();
            // * --- End Select
            // * --- Select from delegabo
            m_cServer = m_Ctx.GetServer("delegabo");
            m_cPhName = m_Ctx.GetPhName("delegabo");
            if (Cursor_delegabo!=null)
              Cursor_delegabo.Close();
            Cursor_delegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER,DATAINI,DATAFINE,NUMPROG1,NUMPROG2  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_tmp_stprapporti.GetString("RAPPORTO"),"?",0,0)+"  and  (NUMPROG1="+CPLib.ToSQL(Cursor_tmp_stprapporti.GetString("NUMPROG"),"?",0,0)+"  or  NUMPROG2="+CPLib.ToSQL(Cursor_tmp_stprapporti.GetString("NUMPROG"),"?",0,0)+") "+")"+(m_Ctx.IsSharedTemp("delegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_delegabo.Eof())) {
              // * --- Read from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              m_cSql = "";
              m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_delegabo.GetString("CODINTER"),"C",16,0,m_cServer),m_cServer,Cursor_delegabo.GetString("CODINTER"));
              if (m_Ctx.IsSharedTemp("personbo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAGSOC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _ragsoc = Read_Cursor.GetString("RAGSOC");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on personbo into routine arrt_stprappo returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _ragsoc = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              // * --- Insert into tmp_sog_rappo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_sog_rappo");
              m_cPhName = m_Ctx.GetPhName("tmp_sog_rappo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_sog_rappo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stprappo",136,"0000006D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000006D(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_stprapporti.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_stprapporti.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_ragsoc,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetDate("DATAINI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetDate("DATAFINE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_stprapporti.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_sog_rappo",true);
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
              Cursor_delegabo.Next();
            }
            m_cConnectivityError = Cursor_delegabo.ErrorMessage();
            Cursor_delegabo.Close();
            // * --- End Select
            Cursor_tmp_stprapporti.Next();
          }
          m_cConnectivityError = Cursor_tmp_stprapporti.ErrorMessage();
          Cursor_tmp_stprapporti.Close();
          // * --- End Select
          /* Stop arrp_stprappo2.vrp */
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
          f.SetParameter("showParameterMask",false);
          f.SetParameter("ReportName","arrp_stprappo2.vrp");
          f.SetParameter("m_cParameterSequence","daRappo"+","+"aRappo"+","+"DaData"+","+"AData"+","+"c_dadata"+","+"c_adata"+","+"attiva"+","+"mod_attiva"+","+"cancellata"+","+"mod_copia"+","+"tipo"+","+"DescAzi"+","+"showParameterMask"+","+"ReportName");
          f.SetParameter("m_cMode","hyperlink");
          throw f;
        } else { // Else
          /* Stop arrp_stprappo1.vrp */
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
          f.SetParameter("showParameterMask",false);
          f.SetParameter("ReportName","arrp_stprappo1.vrp");
          f.SetParameter("m_cParameterSequence","daRappo"+","+"aRappo"+","+"DaData"+","+"AData"+","+"c_dadata"+","+"c_adata"+","+"attiva"+","+"mod_attiva"+","+"cancellata"+","+"mod_copia"+","+"tipo"+","+"DescAzi"+","+"hideLanguage"+","+"hideSettings"+","+"showParameterMask"+","+"ReportName");
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
        if (Cursor_qbe_allrapopebo!=null)
          Cursor_qbe_allrapopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tmp_stprapporti!=null)
          Cursor_tmp_stprapporti.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
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
        if (Cursor_delegabo!=null)
          Cursor_delegabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_qbe_rapporti_xls=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_intestit=null;
    CPResultSet Cursor_delegabo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Senza dettaglio anagrafico */
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
      stringa = new Label(9,0,"Scopo Prestazione",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(10,0,"Natura Prestazione",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(11,0,"Data Profilatura",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(12,0,"Rischio Globale",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(13,0,"Data Prossima Profilatura",arial11format);
      foglio.addCell(stringa);
      riga = 2;
      // * --- Select from qbe_rapporti_xls
      if (Cursor_qbe_rapporti_xls!=null)
        Cursor_qbe_rapporti_xls.Close();
      Cursor_qbe_rapporti_xls = new VQRHolder("qbe_rapporti_xls",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_rapporti_xls.Eof())) {
        /* gMsgImp := "Elaborazione Rapporto "+ qbe_rapporti_xls->RAPPORTO // Messaggio Import */
        gMsgImp = "Elaborazione Rapporto "+Cursor_qbe_rapporti_xls.GetString("RAPPORTO");
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _crap := 1 */
        _crap = CPLib.Round(1,0);
        /* rapporto := qbe_rapporti_xls->RAPPORTO */
        rapporto = Cursor_qbe_rapporti_xls.GetString("RAPPORTO");
        /* descrap := qbe_rapporti_xls->DESCRAP */
        descrap = Cursor_qbe_rapporti_xls.GetString("DESCRAP");
        /* tiprap := qbe_rapporti_xls->TIPORAP */
        tiprap = Cursor_qbe_rapporti_xls.GetString("TIPORAP");
        /* valuta := qbe_rapporti_xls->VALUTA */
        valuta = Cursor_qbe_rapporti_xls.GetString("VALUTA");
        /* _scopo := qbe_rapporti_xls->SCOPO */
        _scopo = Cursor_qbe_rapporti_xls.GetString("SCOPO");
        /* _natura := qbe_rapporti_xls->NATURA */
        _natura = Cursor_qbe_rapporti_xls.GetString("NATURA");
        /* _risglob := '' */
        _risglob = "";
        /* If not(Empty(qbe_rapporti_xls->RISGLOB)) */
        if ( ! (CPLib.Empty(Cursor_qbe_rapporti_xls.GetString("RISGLOB")))) {
          // * --- Read from tbrisglob
          m_cServer = m_Ctx.GetServer("tbrisglob");
          m_cPhName = m_Ctx.GetPhName("tbrisglob");
          m_cSql = "";
          m_cSql = m_cSql+"CODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_rapporti_xls.GetString("RISGLOB"),"C",3,0,m_cServer),m_cServer,Cursor_qbe_rapporti_xls.GetString("RISGLOB"));
          if (m_Ctx.IsSharedTemp("tbrisglob")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _risglob = Read_Cursor.GetString("DESCRI");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on tbrisglob into routine arrt_stprappo returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _risglob = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* _risglob := LRTrim(qbe_rapporti_xls->RISGLOB)+"-"+ LRTrim(_risglob) */
          _risglob = CPLib.LRTrim(Cursor_qbe_rapporti_xls.GetString("RISGLOB"))+"-"+CPLib.LRTrim(_risglob);
        } // End If
        /* _datprof := arfn_fdate(qbe_rapporti_xls->DATAPROF) */
        _datprof = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_rapporti_xls.GetDate("DATAPROF"));
        /* _datrevprof := arfn_fdate(qbe_rapporti_xls->DATAREVPROF) */
        _datrevprof = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_rapporti_xls.GetDate("DATAREVPROF"));
        // * --- Select from intestbo
        m_cServer = m_Ctx.GetServer("intestbo");
        m_cPhName = m_Ctx.GetPhName("intestbo");
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
        Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER,DATAINI,DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapporti_xls.GetString("RAPPORTO"),"?",0,0)+"  and  STATOREG <> '2' "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intestbo.Eof())) {
          /* connes := intestbo->CODINTER */
          connes = Cursor_intestbo.GetString("CODINTER");
          /* dataini := arfn_fdate(intestbo->DATAINI) */
          dataini = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_intestbo.GetDate("DATAINI"));
          /* datafin := arfn_fdate(intestbo->DATAFINE) */
          datafin = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_intestbo.GetDate("DATAFINE"));
          /* cf := '' */
          cf = "";
          /* _ragsoc := '' */
          _ragsoc = "";
          // * --- Read from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          m_cSql = "";
          m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"C",16,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"));
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
              Error l_oErrorFault = new Error("Read on personbo into routine arrt_stprappo returns two or more records. This item should return only a record.");
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
          stringa = new Label(9,riga,_scopo);
          foglio.addCell(stringa);
          stringa = new Label(10,riga,_natura);
          foglio.addCell(stringa);
          stringa = new Label(11,riga,_datprof);
          foglio.addCell(stringa);
          stringa = new Label(12,riga,_risglob);
          foglio.addCell(stringa);
          stringa = new Label(13,riga,_datrevprof);
          foglio.addCell(stringa);
          riga = riga + 1;
          /* If w_flgtit='S' */
          if (CPLib.eqr(w_flgtit,"S")) {
            // * --- Select from intestit
            m_cServer = m_Ctx.GetServer("intestit");
            m_cPhName = m_Ctx.GetPhName("intestit");
            if (Cursor_intestit!=null)
              Cursor_intestit.Close();
            Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+"  and  STATOREG <> '2' "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
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
                  Error l_oErrorFault = new Error("Read on personbo into routine arrt_stprappo returns two or more records. This item should return only a record.");
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
              stringa = new Label(9,riga,_scopo);
              foglio.addCell(stringa);
              stringa = new Label(10,riga,_natura);
              foglio.addCell(stringa);
              stringa = new Label(11,riga,_datprof);
              foglio.addCell(stringa);
              stringa = new Label(12,riga,_risglob);
              foglio.addCell(stringa);
              stringa = new Label(13,riga,_datrevprof);
              foglio.addCell(stringa);
              riga = riga + 1;
              Cursor_intestit.Next();
            }
            m_cConnectivityError = Cursor_intestit.ErrorMessage();
            Cursor_intestit.Close();
            // * --- End Select
          } // End If
          Cursor_intestbo.Next();
        }
        m_cConnectivityError = Cursor_intestbo.ErrorMessage();
        Cursor_intestbo.Close();
        // * --- End Select
        /* If w_flgdel='S' */
        if (CPLib.eqr(w_flgdel,"S")) {
          // * --- Select from delegabo
          m_cServer = m_Ctx.GetServer("delegabo");
          m_cPhName = m_Ctx.GetPhName("delegabo");
          if (Cursor_delegabo!=null)
            Cursor_delegabo.Close();
          Cursor_delegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER,DATAINI,DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapporti_xls.GetString("RAPPORTO"),"?",0,0)+"  and  STATOREG <> '2' "+")"+(m_Ctx.IsSharedTemp("delegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_delegabo.Eof())) {
            /* connes := delegabo->CODINTER */
            connes = Cursor_delegabo.GetString("CODINTER");
            /* dataini := arfn_fdate(delegabo->DATAINI) */
            dataini = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_delegabo.GetDate("DATAINI"));
            /* datafin := arfn_fdate(delegabo->DATAFINE) */
            datafin = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_delegabo.GetDate("DATAFINE"));
            /* _ragsoc := '' */
            _ragsoc = "";
            /* cf := '' */
            cf = "";
            // * --- Read from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_cSql = "";
            m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_delegabo.GetString("CODINTER"),"C",16,0,m_cServer),m_cServer,Cursor_delegabo.GetString("CODINTER"));
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
                Error l_oErrorFault = new Error("Read on personbo into routine arrt_stprappo returns two or more records. This item should return only a record.");
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
            stringa = new Label(9,riga,_scopo);
            foglio.addCell(stringa);
            stringa = new Label(10,riga,_natura);
            foglio.addCell(stringa);
            stringa = new Label(11,riga,_datprof);
            foglio.addCell(stringa);
            stringa = new Label(12,riga,_risglob);
            foglio.addCell(stringa);
            stringa = new Label(13,riga,_datrevprof);
            foglio.addCell(stringa);
            riga = riga + 1;
            Cursor_delegabo.Next();
          }
          m_cConnectivityError = Cursor_delegabo.ErrorMessage();
          Cursor_delegabo.Close();
          // * --- End Select
        } // End If
        Cursor_qbe_rapporti_xls.Next();
      }
      m_cConnectivityError = Cursor_qbe_rapporti_xls.ErrorMessage();
      Cursor_qbe_rapporti_xls.Close();
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
      prova.write();
      prova.close();
      /* gMsgImp := "Elaborazione Terminata !" // Messaggio Import */
      gMsgImp = "Elaborazione Terminata !";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Cursor_qbe_rapporti_xls!=null)
          Cursor_qbe_rapporti_xls.Close();
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
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
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
        if (Cursor_delegabo!=null)
          Cursor_delegabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_3() throws Exception {
    CPResultSet Cursor_qbe_rapporti_xls_dett=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_intestit=null;
    CPResultSet Cursor_delegabo=null;
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
      stringa = new Label(9,0,"CAP Residenza",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(10,0,"CAB Residenza",arial11format);
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
      stringa = new Label(32,0,"Customer ID",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(33,0,"Scopo Prestazione",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(34,0,"Natura Prestazione",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(35,0,"Data Profilatura",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(36,0,"Rischio Globale",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(37,0,"Data Prossima Profilatura",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(38,0,"Cognome",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(39,0,"Nome",arial11format);
      foglio.addCell(stringa);
      riga = 2;
      /* rapporto := '' */
      rapporto = "";
      // * --- Select from qbe_rapporti_xls_dett
      if (Cursor_qbe_rapporti_xls_dett!=null)
        Cursor_qbe_rapporti_xls_dett.Close();
      Cursor_qbe_rapporti_xls_dett = new VQRHolder("qbe_rapporti_xls_dett",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_rapporti_xls_dett.Eof())) {
        /* _notit := 0 */
        _notit = CPLib.Round(0,0);
        /* _crap := 0 */
        _crap = CPLib.Round(0,0);
        /* gMsgImp := "Elaborazione Rapporto "+ qbe_rapporti_xls_dett->RAPPORTO // Messaggio Import */
        gMsgImp = "Elaborazione Rapporto "+Cursor_qbe_rapporti_xls_dett.GetString("RAPPORTO");
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* rapporto := qbe_rapporti_xls_dett->RAPPORTO */
        rapporto = Cursor_qbe_rapporti_xls_dett.GetString("RAPPORTO");
        /* descrap := qbe_rapporti_xls_dett->DESCRAP */
        descrap = Cursor_qbe_rapporti_xls_dett.GetString("DESCRAP");
        /* tiprap := qbe_rapporti_xls_dett->TIPORAP */
        tiprap = Cursor_qbe_rapporti_xls_dett.GetString("TIPORAP");
        /* valuta := qbe_rapporti_xls_dett->VALUTA */
        valuta = Cursor_qbe_rapporti_xls_dett.GetString("VALUTA");
        /* _customerid := qbe_rapporti_xls_dett->SPLITCODE */
        _customerid = Cursor_qbe_rapporti_xls_dett.GetString("SPLITCODE");
        /* _scopo := qbe_rapporti_xls_dett->SCOPO */
        _scopo = Cursor_qbe_rapporti_xls_dett.GetString("SCOPO");
        /* _natura := qbe_rapporti_xls_dett->NATURA */
        _natura = Cursor_qbe_rapporti_xls_dett.GetString("NATURA");
        /* _datprof := arfn_fdate(qbe_rapporti_xls_dett->DATAPROF) */
        _datprof = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_rapporti_xls_dett.GetDate("DATAPROF"));
        /* _datrevprof := arfn_fdate(qbe_rapporti_xls_dett->DATAREVPROF) */
        _datrevprof = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_rapporti_xls_dett.GetDate("DATAREVPROF"));
        // * --- Select from intestbo
        m_cServer = m_Ctx.GetServer("intestbo");
        m_cPhName = m_Ctx.GetPhName("intestbo");
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
        Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER,DATAINI,DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapporti_xls_dett.GetString("RAPPORTO"),"?",0,0)+"  and  STATOREG <>'2' "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intestbo.Eof())) {
          /* If w_tipo='T' or (w_tipo='A' and Empty(intestbo->DATAFINE)) or (w_tipo='C' and not(Empty(intestbo->DATAFINE))) */
          if (CPLib.eqr(w_tipo,"T") || (CPLib.eqr(w_tipo,"A") && CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE"))) || (CPLib.eqr(w_tipo,"C") &&  ! (CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE"))))) {
            /* _crap := 1 */
            _crap = CPLib.Round(1,0);
            /* connes := intestbo->CODINTER */
            connes = Cursor_intestbo.GetString("CODINTER");
            /* dataini := arfn_fdate(intestbo->DATAINI) */
            dataini = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_intestbo.GetDate("DATAINI"));
            /* datafin := arfn_fdate(intestbo->DATAFINE) */
            datafin = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_intestbo.GetDate("DATAFINE"));
            /* cf := '' */
            cf = "";
            /* _ragsoc := '' */
            _ragsoc = "";
            /* _cognome := '' */
            _cognome = "";
            /* _nome := '' */
            _nome = "";
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
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              /* cf := personbo->CODFISC */
              cf = Cursor_personbo.GetString("CODFISC");
              /* _ragsoc := personbo->RAGSOC */
              _ragsoc = Cursor_personbo.GetString("RAGSOC");
              /* _cognome := personbo->COGNOME */
              _cognome = Cursor_personbo.GetString("COGNOME");
              /* _nome := personbo->NOME */
              _nome = Cursor_personbo.GetString("NOME");
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
                  Error l_oErrorFault = new Error("Read on tbstati into routine arrt_stprappo returns two or more records. This item should return only a record.");
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
                  Error l_oErrorFault = new Error("Read on tbtipdoc into routine arrt_stprappo returns two or more records. This item should return only a record.");
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
                  Error l_oErrorFault = new Error("Read on tbstgru into routine arrt_stprappo returns two or more records. This item should return only a record.");
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
                  Error l_oErrorFault = new Error("Read on tbtipatt into routine arrt_stprappo returns two or more records. This item should return only a record.");
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
                  Error l_oErrorFault = new Error("Read on tbsetsin into routine arrt_stprappo returns two or more records. This item should return only a record.");
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
                  Error l_oErrorFault = new Error("Read on tbramgru into routine arrt_stprappo returns two or more records. This item should return only a record.");
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
            stringa = new Label(32,riga,_customerid);
            foglio.addCell(stringa);
            stringa = new Label(33,riga,_scopo);
            foglio.addCell(stringa);
            stringa = new Label(34,riga,_natura);
            foglio.addCell(stringa);
            stringa = new Label(35,riga,_datprof);
            foglio.addCell(stringa);
            stringa = new Label(36,riga,_risglob);
            foglio.addCell(stringa);
            stringa = new Label(37,riga,_datrevprof);
            foglio.addCell(stringa);
            stringa = new Label(38,riga,_cognome);
            foglio.addCell(stringa);
            stringa = new Label(39,riga,_nome);
            foglio.addCell(stringa);
            riga = riga + 1;
            /* If w_flgtit='S' */
            if (CPLib.eqr(w_flgtit,"S")) {
              // * --- Select from intestit
              m_cServer = m_Ctx.GetServer("intestit");
              m_cPhName = m_Ctx.GetPhName("intestit");
              if (Cursor_intestit!=null)
                Cursor_intestit.Close();
              Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+"  and  STATOREG <> '2' "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_intestit.Eof())) {
                /* dataini := arfn_fdate(intestit->DATAINI) */
                dataini = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_intestit.GetDate("DATAINI"));
                /* datafin := arfn_fdate(intestit->DATAFINE) */
                datafin = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_intestit.GetDate("DATAFINE"));
                /* cf := '' */
                cf = "";
                /* _ragsoc := '' */
                _ragsoc = "";
                /* _cognome := '' */
                _cognome = "";
                /* _nome := '' */
                _nome = "";
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
                  /* _cognome := personbo->COGNOME */
                  _cognome = Cursor_personbo.GetString("COGNOME");
                  /* _nome := personbo->NOME */
                  _nome = Cursor_personbo.GetString("NOME");
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
                      Error l_oErrorFault = new Error("Read on tbstati into routine arrt_stprappo returns two or more records. This item should return only a record.");
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
                      Error l_oErrorFault = new Error("Read on tbtipdoc into routine arrt_stprappo returns two or more records. This item should return only a record.");
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
                      Error l_oErrorFault = new Error("Read on tbstgru into routine arrt_stprappo returns two or more records. This item should return only a record.");
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
                      Error l_oErrorFault = new Error("Read on tbtipatt into routine arrt_stprappo returns two or more records. This item should return only a record.");
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
                      Error l_oErrorFault = new Error("Read on tbsetsin into routine arrt_stprappo returns two or more records. This item should return only a record.");
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
                      Error l_oErrorFault = new Error("Read on tbramgru into routine arrt_stprappo returns two or more records. This item should return only a record.");
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
                stringa = new Label(32,riga,_customerid);
                foglio.addCell(stringa);
                stringa = new Label(33,riga,_scopo);
                foglio.addCell(stringa);
                stringa = new Label(34,riga,_natura);
                foglio.addCell(stringa);
                stringa = new Label(35,riga,_datprof);
                foglio.addCell(stringa);
                stringa = new Label(36,riga,_risglob);
                foglio.addCell(stringa);
                stringa = new Label(37,riga,_datrevprof);
                foglio.addCell(stringa);
                stringa = new Label(38,riga,_cognome);
                foglio.addCell(stringa);
                stringa = new Label(39,riga,_nome);
                foglio.addCell(stringa);
                riga = riga + 1;
                Cursor_intestit.Next();
              }
              m_cConnectivityError = Cursor_intestit.ErrorMessage();
              Cursor_intestit.Close();
              // * --- End Select
            } // End If
            /* ElseIf  (w_tipo='1' and Empty(intestbo->DATAFINE)) or (w_tipo='2' and not(Empty(intestbo->DATAFINE))) */
          } else if ((CPLib.eqr(w_tipo,"1") && CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE"))) || (CPLib.eqr(w_tipo,"2") &&  ! (CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE"))))) {
            /* _crap := 1 */
            _crap = CPLib.Round(1,0);
            /* connes := intestbo->CODINTER */
            connes = Cursor_intestbo.GetString("CODINTER");
            /* dataini := arfn_fdate(intestbo->DATAINI) */
            dataini = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_intestbo.GetDate("DATAINI"));
            /* datafin := arfn_fdate(intestbo->DATAFINE) */
            datafin = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_intestbo.GetDate("DATAFINE"));
            /* cf := '' */
            cf = "";
            /* _ragsoc := '' */
            _ragsoc = "";
            /* _cognome := '' */
            _cognome = "";
            /* _nome := '' */
            _nome = "";
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
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              /* cf := personbo->CODFISC */
              cf = Cursor_personbo.GetString("CODFISC");
              /* _ragsoc := personbo->RAGSOC */
              _ragsoc = Cursor_personbo.GetString("RAGSOC");
              /* _cognome := personbo->COGNOME */
              _cognome = Cursor_personbo.GetString("COGNOME");
              /* _nome := personbo->NOME */
              _nome = Cursor_personbo.GetString("NOME");
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
                  Error l_oErrorFault = new Error("Read on tbstati into routine arrt_stprappo returns two or more records. This item should return only a record.");
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
                  Error l_oErrorFault = new Error("Read on tbtipdoc into routine arrt_stprappo returns two or more records. This item should return only a record.");
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
                  Error l_oErrorFault = new Error("Read on tbstgru into routine arrt_stprappo returns two or more records. This item should return only a record.");
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
                  Error l_oErrorFault = new Error("Read on tbtipatt into routine arrt_stprappo returns two or more records. This item should return only a record.");
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
                  Error l_oErrorFault = new Error("Read on tbsetsin into routine arrt_stprappo returns two or more records. This item should return only a record.");
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
                  Error l_oErrorFault = new Error("Read on tbramgru into routine arrt_stprappo returns two or more records. This item should return only a record.");
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
            /* _notit := 0 */
            _notit = CPLib.Round(0,0);
            // * --- Select from intestit
            m_cServer = m_Ctx.GetServer("intestit");
            m_cPhName = m_Ctx.GetPhName("intestit");
            if (Cursor_intestit!=null)
              Cursor_intestit.Close();
            Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+"  and  (STATOREG <> '2'  or  STATOREG is null) "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestit.Eof())) {
              /* _notit := 1 */
              _notit = CPLib.Round(1,0);
              Cursor_intestit.Next();
            }
            m_cConnectivityError = Cursor_intestit.ErrorMessage();
            Cursor_intestit.Close();
            // * --- End Select
            /* If _notit=0 */
            if (CPLib.eqr(_notit,0)) {
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
              stringa = new Label(32,riga,_customerid);
              foglio.addCell(stringa);
              stringa = new Label(33,riga,_scopo);
              foglio.addCell(stringa);
              stringa = new Label(34,riga,_natura);
              foglio.addCell(stringa);
              stringa = new Label(35,riga,_datprof);
              foglio.addCell(stringa);
              stringa = new Label(36,riga,_risglob);
              foglio.addCell(stringa);
              stringa = new Label(37,riga,_datrevprof);
              foglio.addCell(stringa);
              stringa = new Label(38,riga,_cognome);
              foglio.addCell(stringa);
              stringa = new Label(39,riga,_nome);
              foglio.addCell(stringa);
              riga = riga + 1;
            } // End If
          } // End If
          Cursor_intestbo.Next();
        }
        m_cConnectivityError = Cursor_intestbo.ErrorMessage();
        Cursor_intestbo.Close();
        // * --- End Select
        /* If not(Empty(qbe_rapporti_xls_dett->CODICELR)) and _crap=1 */
        if ( ! (CPLib.Empty(Cursor_qbe_rapporti_xls_dett.GetString("CODICELR"))) && CPLib.eqr(_crap,1)) {
          /* cf := '' */
          cf = "";
          /* _ragsoc := '' */
          _ragsoc = "";
          /* _cognome := '' */
          _cognome = "";
          /* _nome := '' */
          _nome = "";
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
          Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_rapporti_xls_dett.GetString("CODICELR"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_personbo.Eof())) {
            /* cf := personbo->CODFISC */
            cf = Cursor_personbo.GetString("CODFISC");
            /* _ragsoc := personbo->RAGSOC */
            _ragsoc = Cursor_personbo.GetString("RAGSOC");
            /* _cognome := personbo->COGNOME */
            _cognome = Cursor_personbo.GetString("COGNOME");
            /* _nome := personbo->NOME */
            _nome = Cursor_personbo.GetString("NOME");
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
                Error l_oErrorFault = new Error("Read on tbstati into routine arrt_stprappo returns two or more records. This item should return only a record.");
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
                Error l_oErrorFault = new Error("Read on tbtipdoc into routine arrt_stprappo returns two or more records. This item should return only a record.");
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
                Error l_oErrorFault = new Error("Read on tbstgru into routine arrt_stprappo returns two or more records. This item should return only a record.");
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
                Error l_oErrorFault = new Error("Read on tbtipatt into routine arrt_stprappo returns two or more records. This item should return only a record.");
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
                Error l_oErrorFault = new Error("Read on tbsetsin into routine arrt_stprappo returns two or more records. This item should return only a record.");
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
                Error l_oErrorFault = new Error("Read on tbramgru into routine arrt_stprappo returns two or more records. This item should return only a record.");
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
          stringa = new Label(31,riga,"LEGALE RAPPRESENTANTE");
          foglio.addCell(stringa);
          stringa = new Label(32,riga,_customerid);
          foglio.addCell(stringa);
          stringa = new Label(33,riga,_scopo);
          foglio.addCell(stringa);
          stringa = new Label(34,riga,_natura);
          foglio.addCell(stringa);
          stringa = new Label(35,riga,_datprof);
          foglio.addCell(stringa);
          stringa = new Label(36,riga,_risglob);
          foglio.addCell(stringa);
          stringa = new Label(37,riga,_datrevprof);
          foglio.addCell(stringa);
          stringa = new Label(38,riga,_cognome);
          foglio.addCell(stringa);
          stringa = new Label(39,riga,_nome);
          foglio.addCell(stringa);
          riga = riga + 1;
        } // End If
        /* If w_flgdel='S' and _crap=1 */
        if (CPLib.eqr(w_flgdel,"S") && CPLib.eqr(_crap,1)) {
          // * --- Select from delegabo
          m_cServer = m_Ctx.GetServer("delegabo");
          m_cPhName = m_Ctx.GetPhName("delegabo");
          if (Cursor_delegabo!=null)
            Cursor_delegabo.Close();
          Cursor_delegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER,DATAINI,DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapporti_xls_dett.GetString("RAPPORTO"),"?",0,0)+"  and  STATOREG <> '2' "+")"+(m_Ctx.IsSharedTemp("delegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_delegabo.Eof())) {
            /* connes := delegabo->CODINTER */
            connes = Cursor_delegabo.GetString("CODINTER");
            /* dataini := arfn_fdate(delegabo->DATAINI) */
            dataini = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_delegabo.GetDate("DATAINI"));
            /* datafin := arfn_fdate(delegabo->DATAFINE) */
            datafin = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_delegabo.GetDate("DATAFINE"));
            /* cf := '' */
            cf = "";
            /* _ragsoc := '' */
            _ragsoc = "";
            /* _cognome := '' */
            _cognome = "";
            /* _nome := '' */
            _nome = "";
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
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_delegabo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              /* cf := personbo->CODFISC */
              cf = Cursor_personbo.GetString("CODFISC");
              /* _ragsoc := personbo->RAGSOC */
              _ragsoc = Cursor_personbo.GetString("RAGSOC");
              /* _cognome := personbo->COGNOME */
              _cognome = Cursor_personbo.GetString("COGNOME");
              /* _nome := personbo->NOME */
              _nome = Cursor_personbo.GetString("NOME");
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
                  Error l_oErrorFault = new Error("Read on tbstati into routine arrt_stprappo returns two or more records. This item should return only a record.");
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
                  Error l_oErrorFault = new Error("Read on tbtipdoc into routine arrt_stprappo returns two or more records. This item should return only a record.");
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
                  Error l_oErrorFault = new Error("Read on tbstgru into routine arrt_stprappo returns two or more records. This item should return only a record.");
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
                  Error l_oErrorFault = new Error("Read on tbtipatt into routine arrt_stprappo returns two or more records. This item should return only a record.");
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
                  Error l_oErrorFault = new Error("Read on tbsetsin into routine arrt_stprappo returns two or more records. This item should return only a record.");
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
                  Error l_oErrorFault = new Error("Read on tbramgru into routine arrt_stprappo returns two or more records. This item should return only a record.");
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
            stringa = new Label(32,riga,_customerid);
            foglio.addCell(stringa);
            stringa = new Label(33,riga,_scopo);
            foglio.addCell(stringa);
            stringa = new Label(34,riga,_natura);
            foglio.addCell(stringa);
            stringa = new Label(35,riga,_datprof);
            foglio.addCell(stringa);
            stringa = new Label(36,riga,_risglob);
            foglio.addCell(stringa);
            stringa = new Label(37,riga,_datrevprof);
            foglio.addCell(stringa);
            stringa = new Label(38,riga,_cognome);
            foglio.addCell(stringa);
            stringa = new Label(39,riga,_nome);
            foglio.addCell(stringa);
            riga = riga + 1;
            Cursor_delegabo.Next();
          }
          m_cConnectivityError = Cursor_delegabo.ErrorMessage();
          Cursor_delegabo.Close();
          // * --- End Select
        } // End If
        Cursor_qbe_rapporti_xls_dett.Next();
      }
      m_cConnectivityError = Cursor_qbe_rapporti_xls_dett.ErrorMessage();
      Cursor_qbe_rapporti_xls_dett.Close();
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
      foglio.setColumnView(32, cf);
      foglio.setColumnView(33, cf);
      foglio.setColumnView(34, cf);
      foglio.setColumnView(35, cf);
      foglio.setColumnView(36, cf);
      foglio.setColumnView(37, cf);
      foglio.setColumnView(38, cf);
      foglio.setColumnView(39, cf);
      prova.write();
      prova.close();
      /* gMsgImp := "Elaborazione Terminata !" // Messaggio Import */
      gMsgImp = "Elaborazione Terminata !";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Cursor_qbe_rapporti_xls_dett!=null)
          Cursor_qbe_rapporti_xls_dett.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
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
        if (Cursor_delegabo!=null)
          Cursor_delegabo.Close();
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
      m_Caller.SetString("DaSogg","C",16,0,w_DaSogg);
      m_Caller.SetString("ASogg","C",16,0,w_ASogg);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_stprappoR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_stprappoR(p_Ctx, p_Caller);
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
    w_DaSogg = m_Caller.GetString("DaSogg","C",16,0);
    w_ASogg = m_Caller.GetString("ASogg","C",16,0);
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
    _customerid = CPLib.Space(10);
    _notit = 0;
    _scopo = CPLib.Space(50);
    _natura = CPLib.Space(50);
    _risglob = CPLib.Space(40);
    _datprof = CPLib.Space(10);
    _datrevprof = CPLib.Space(10);
    _desrisglob = CPLib.Space(150);
    _cognome = CPLib.Space(30);
    _nome = CPLib.Space(30);
    _crap = 0;
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    gDescAzi=m_Ctx.GetGlobalString("gDescAzi");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_allrapopebo,qbe_allrapopebo,qbe_allrapopebo,qbe_rapporti_xls,qbe_rapporti_xls_dett,
  public static final String m_cVQRList = ",qbe_allrapopebo,qbe_allrapopebo,qbe_allrapopebo,qbe_rapporti_xls,qbe_rapporti_xls_dett,";
  // ENTITY_BATCHES: ,arfn_fdate,
  public static final String i_InvokedRoutines = ",arfn_fdate,";
  public static String[] m_cRunParameterNames={"pTipo"};
  protected static String GetFieldsName_0000005F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"RISGLOB,";
    p_cSql = p_cSql+"DATAPROF,";
    p_cSql = p_cSql+"DATAREVPROF,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stprapporti",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000064(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"RISGLOB,";
    p_cSql = p_cSql+"DATAPROF,";
    p_cSql = p_cSql+"DATAREVPROF,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stprapporti",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000006A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"DATINI,";
    p_cSql = p_cSql+"DATFIN,";
    p_cSql = p_cSql+"TIPSOG,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_sog_rappo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000006D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"DATINI,";
    p_cSql = p_cSql+"DATFIN,";
    p_cSql = p_cSql+"TIPSOG,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_sog_rappo",true);
    return p_cSql;
  }
}
