// * --- Area Manuale = BO - Header
// * --- arrt_stprappo_all
import java.io.File; 
import java.lang.Double;
/*
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
import jxl.write.WriteException;*/

/////////////////////////////////////////////////////
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.CellStyle;
//import org.apache.poi.ss.usermodel.CreationHelper;
/////////////////////////////////////////////////////

// * --- Fine Area Manuale
public class arrt_stprappo_allR implements CallerWithObjs {
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
  public String m_cPhName_xntestbo;
  public String m_cServer_xntestbo;
  public String m_cPhName_xelegabo;
  public String m_cServer_xelegabo;
  public String m_cPhName_jntestbo;
  public String m_cServer_jntestbo;
  public String m_cPhName_jelegabo;
  public String m_cServer_jelegabo;
  public String m_cPhName_jntestit;
  public String m_cServer_jntestit;
  public String m_cPhName_xntestit;
  public String m_cServer_xntestit;
  public String m_cPhName_wntestbo;
  public String m_cServer_wntestbo;
  public String m_cPhName_welegabo;
  public String m_cServer_welegabo;
  public String m_cPhName_wntestit;
  public String m_cServer_wntestit;
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
  public String fonte;
  public String tipostp;
  public String daRappo;
  public String aRappo;
  public String DaSogg;
  public String ASogg;
  public String coddip;
  public java.sql.Date DaData;
  public java.sql.Date AData;
  public boolean detope;
  public boolean detana;
  public boolean flgtit;
  public boolean flgdel;
  public String tipo;
  public boolean attiva;
  public boolean mod_attiva;
  public boolean cancellata;
  public boolean mod_copia;
  public boolean aui;
  public String pTIPOAG;
  public String pRISGLOB;
  public String gPathApp;
  public String gUrlApp;
  public String gDescAzi;
  public String gAzienda;
  public String gMsgImp;
  public String nomefilexls;
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
  public String _scopo;
  public String _natura;
  public String _risglob;
  public String _datprof;
  public String _datrevprof;
  public String _desrisglob;
  public String _cognome;
  public String _nome;
  public String _risglobs;
  public String _datprofs;
  public String _datrevprofs;
  public String _destipsog;
  public String foglio;
  public String stringa;
  public String report_name;
  public String c_dadata;
  public String c_adata;
  public MemoryCursor_delegabo mcdelegabo;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_stprappo_all
  public int riga;
  public short FontHeight=11;
  public short FontHeight2=10;
  //public DateTime dt;
  // * --- Fine Area Manuale
  public arrt_stprappo_allR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_stprappo_all",m_Caller);
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
    m_cPhName_xntestbo = p_ContextObject.GetPhName("xntestbo");
    if (m_cPhName_xntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xntestbo = m_cPhName_xntestbo+" "+m_Ctx.GetWritePhName("xntestbo");
    }
    m_cServer_xntestbo = p_ContextObject.GetServer("xntestbo");
    m_cPhName_xelegabo = p_ContextObject.GetPhName("xelegabo");
    if (m_cPhName_xelegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xelegabo = m_cPhName_xelegabo+" "+m_Ctx.GetWritePhName("xelegabo");
    }
    m_cServer_xelegabo = p_ContextObject.GetServer("xelegabo");
    m_cPhName_jntestbo = p_ContextObject.GetPhName("jntestbo");
    if (m_cPhName_jntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jntestbo = m_cPhName_jntestbo+" "+m_Ctx.GetWritePhName("jntestbo");
    }
    m_cServer_jntestbo = p_ContextObject.GetServer("jntestbo");
    m_cPhName_jelegabo = p_ContextObject.GetPhName("jelegabo");
    if (m_cPhName_jelegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jelegabo = m_cPhName_jelegabo+" "+m_Ctx.GetWritePhName("jelegabo");
    }
    m_cServer_jelegabo = p_ContextObject.GetServer("jelegabo");
    m_cPhName_jntestit = p_ContextObject.GetPhName("jntestit");
    if (m_cPhName_jntestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jntestit = m_cPhName_jntestit+" "+m_Ctx.GetWritePhName("jntestit");
    }
    m_cServer_jntestit = p_ContextObject.GetServer("jntestit");
    m_cPhName_xntestit = p_ContextObject.GetPhName("xntestit");
    if (m_cPhName_xntestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xntestit = m_cPhName_xntestit+" "+m_Ctx.GetWritePhName("xntestit");
    }
    m_cServer_xntestit = p_ContextObject.GetServer("xntestit");
    m_cPhName_wntestbo = p_ContextObject.GetPhName("wntestbo");
    if (m_cPhName_wntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wntestbo = m_cPhName_wntestbo+" "+m_Ctx.GetWritePhName("wntestbo");
    }
    m_cServer_wntestbo = p_ContextObject.GetServer("wntestbo");
    m_cPhName_welegabo = p_ContextObject.GetPhName("welegabo");
    if (m_cPhName_welegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_welegabo = m_cPhName_welegabo+" "+m_Ctx.GetWritePhName("welegabo");
    }
    m_cServer_welegabo = p_ContextObject.GetServer("welegabo");
    m_cPhName_wntestit = p_ContextObject.GetPhName("wntestit");
    if (m_cPhName_wntestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wntestit = m_cPhName_wntestit+" "+m_Ctx.GetWritePhName("wntestit");
    }
    m_cServer_wntestit = p_ContextObject.GetServer("wntestit");
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
      return "arrt_stprappo_all";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("fonte",p_cVarName)) {
      return fonte;
    }
    if (CPLib.eqr("tipostp",p_cVarName)) {
      return tipostp;
    }
    if (CPLib.eqr("daRappo",p_cVarName)) {
      return daRappo;
    }
    if (CPLib.eqr("aRappo",p_cVarName)) {
      return aRappo;
    }
    if (CPLib.eqr("DaSogg",p_cVarName)) {
      return DaSogg;
    }
    if (CPLib.eqr("ASogg",p_cVarName)) {
      return ASogg;
    }
    if (CPLib.eqr("coddip",p_cVarName)) {
      return coddip;
    }
    if (CPLib.eqr("tipo",p_cVarName)) {
      return tipo;
    }
    if (CPLib.eqr("pTIPOAG",p_cVarName)) {
      return pTIPOAG;
    }
    if (CPLib.eqr("pRISGLOB",p_cVarName)) {
      return pRISGLOB;
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
    if (CPLib.eqr("nomefilexls",p_cVarName)) {
      return nomefilexls;
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
    if (CPLib.eqr("_risglobs",p_cVarName)) {
      return _risglobs;
    }
    if (CPLib.eqr("_datprofs",p_cVarName)) {
      return _datprofs;
    }
    if (CPLib.eqr("_datrevprofs",p_cVarName)) {
      return _datrevprofs;
    }
    if (CPLib.eqr("_destipsog",p_cVarName)) {
      return _destipsog;
    }
    if (CPLib.eqr("foglio",p_cVarName)) {
      return foglio;
    }
    if (CPLib.eqr("stringa",p_cVarName)) {
      return stringa;
    }
    if (CPLib.eqr("report_name",p_cVarName)) {
      return report_name;
    }
    if (CPLib.eqr("c_dadata",p_cVarName)) {
      return c_dadata;
    }
    if (CPLib.eqr("c_adata",p_cVarName)) {
      return c_adata;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("DaData",p_cVarName)) {
      return DaData;
    }
    if (CPLib.eqr("AData",p_cVarName)) {
      return AData;
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
    if (CPLib.eqr("detope",p_cVarName)) {
      return detope;
    }
    if (CPLib.eqr("detana",p_cVarName)) {
      return detana;
    }
    if (CPLib.eqr("flgtit",p_cVarName)) {
      return flgtit;
    }
    if (CPLib.eqr("flgdel",p_cVarName)) {
      return flgdel;
    }
    if (CPLib.eqr("attiva",p_cVarName)) {
      return attiva;
    }
    if (CPLib.eqr("mod_attiva",p_cVarName)) {
      return mod_attiva;
    }
    if (CPLib.eqr("cancellata",p_cVarName)) {
      return cancellata;
    }
    if (CPLib.eqr("mod_copia",p_cVarName)) {
      return mod_copia;
    }
    if (CPLib.eqr("aui",p_cVarName)) {
      return aui;
    }
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("mcdelegabo",p_cVarName)) {
      return mcdelegabo;
    }
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
    if (CPLib.eqr("fonte",p_cVarName)) {
      fonte = value;
      return;
    }
    if (CPLib.eqr("tipostp",p_cVarName)) {
      tipostp = value;
      return;
    }
    if (CPLib.eqr("daRappo",p_cVarName)) {
      daRappo = value;
      return;
    }
    if (CPLib.eqr("aRappo",p_cVarName)) {
      aRappo = value;
      return;
    }
    if (CPLib.eqr("DaSogg",p_cVarName)) {
      DaSogg = value;
      return;
    }
    if (CPLib.eqr("ASogg",p_cVarName)) {
      ASogg = value;
      return;
    }
    if (CPLib.eqr("coddip",p_cVarName)) {
      coddip = value;
      return;
    }
    if (CPLib.eqr("tipo",p_cVarName)) {
      tipo = value;
      return;
    }
    if (CPLib.eqr("pTIPOAG",p_cVarName)) {
      pTIPOAG = value;
      return;
    }
    if (CPLib.eqr("pRISGLOB",p_cVarName)) {
      pRISGLOB = value;
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
    if (CPLib.eqr("nomefilexls",p_cVarName)) {
      nomefilexls = value;
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
    if (CPLib.eqr("_risglobs",p_cVarName)) {
      _risglobs = value;
      return;
    }
    if (CPLib.eqr("_datprofs",p_cVarName)) {
      _datprofs = value;
      return;
    }
    if (CPLib.eqr("_datrevprofs",p_cVarName)) {
      _datrevprofs = value;
      return;
    }
    if (CPLib.eqr("_destipsog",p_cVarName)) {
      _destipsog = value;
      return;
    }
    if (CPLib.eqr("foglio",p_cVarName)) {
      foglio = value;
      return;
    }
    if (CPLib.eqr("stringa",p_cVarName)) {
      stringa = value;
      return;
    }
    if (CPLib.eqr("report_name",p_cVarName)) {
      report_name = value;
      return;
    }
    if (CPLib.eqr("c_dadata",p_cVarName)) {
      c_dadata = value;
      return;
    }
    if (CPLib.eqr("c_adata",p_cVarName)) {
      c_adata = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("DaData",p_cVarName)) {
      DaData = value;
      return;
    }
    if (CPLib.eqr("AData",p_cVarName)) {
      AData = value;
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
    if (CPLib.eqr("detope",p_cVarName)) {
      detope = value;
      return;
    }
    if (CPLib.eqr("detana",p_cVarName)) {
      detana = value;
      return;
    }
    if (CPLib.eqr("flgtit",p_cVarName)) {
      flgtit = value;
      return;
    }
    if (CPLib.eqr("flgdel",p_cVarName)) {
      flgdel = value;
      return;
    }
    if (CPLib.eqr("attiva",p_cVarName)) {
      attiva = value;
      return;
    }
    if (CPLib.eqr("mod_attiva",p_cVarName)) {
      mod_attiva = value;
      return;
    }
    if (CPLib.eqr("cancellata",p_cVarName)) {
      cancellata = value;
      return;
    }
    if (CPLib.eqr("mod_copia",p_cVarName)) {
      mod_copia = value;
      return;
    }
    if (CPLib.eqr("aui",p_cVarName)) {
      aui = value;
      return;
    }
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcdelegabo",p_cVarName)) {
      mcdelegabo = (MemoryCursor_delegabo)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_tmp_stprapporti=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_delegabo=null;
    CPResultSet Cursor_xntestbo=null;
    CPResultSet Cursor_xelegabo=null;
    CPResultSet Cursor_jntestbo=null;
    CPResultSet Cursor_jelegabo=null;
    CPResultSet Cursor_wntestbo=null;
    CPResultSet Cursor_welegabo=null;
    try {
      /* Parametro della procedura */
      /* fonte Char(1) // fonte de dato (D - Definitivo, P - Provisorio, J -Agenzia Entrate) */
      /* tipostp Char(1) // tipo di stampa (R- report ,'X' Excel) */
      /* daRappo Char(25) */
      /* aRappo Char(25) */
      /* DaSogg Char(16) */
      /* ASogg Char(16) */
      /* coddip Char(6) */
      /* DaData Date */
      /* AData Date */
      /* detope Bool // Stampa con dettaglio informazioni */
      /* detana Bool // Dettaglio anagrafico (Solo Excel) */
      /* flgtit Bool // Stampa i Titolari Effettivi */
      /* flgdel Bool // Stampa i Delegati */
      /* tipo Char(1) // tipo di rapporti da stampare */
      /* attiva Bool */
      /* mod_attiva Bool */
      /* cancellata Bool */
      /* mod_copia Bool */
      /* aui Bool // Per la stampa agenzia entrate permette di escludere i titolari effettivi del AUI */
      /* pTIPOAG Char(2) // Tipo di rapporto agenzia entrate */
      /* pRISGLOB Char(1) // Valere del rischio globale  */
      /* gPathApp Char(80) // Path Applicazione */
      /* gUrlApp Char(80) // URL Applicazione */
      /* gDescAzi Char(70) // Descrizione Intermediario */
      /* gAzienda Char(10) // Azienda */
      /* gMsgImp Char(120) // Messaggio Import */
      /* nomefilexls Char(50) */
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
      /* _scopo Char(50) */
      /* _natura Char(50) */
      /* _risglob Char(40) */
      /* _datprof Char(10) */
      /* _datrevprof Char(10) */
      /* _desrisglob Char(150) */
      /* _cognome Char(30) */
      /* _nome Char(30) */
      /* _risglobs Char(40) */
      /* _datprofs Char(10) */
      /* _datrevprofs Char(10) */
      /* _destipsog Char(0) */
      /* foglio Char(1) */
      /* stringa Char(1) */
      /* report_name Char(0) := iif(detope,'arrp_stprappo2.vrp','arrp_stprappo1.vrp') // nome del report */
      report_name = (detope?"arrp_stprappo2.vrp":"arrp_stprappo1.vrp");
      /* c_dadata Char(8) := iif(Empty(DaData),'',DateToChar(DaData)) // da data in char */
      c_dadata = (CPLib.Empty(DaData)?"":CPLib.DateToChar(DaData));
      /* c_adata Char(8) := iif(Empty(AData),'',DateToChar(AData)) // a data in char */
      c_adata = (CPLib.Empty(AData)?"":CPLib.DateToChar(AData));
      /* Lancio la stampa */
      /* If tipostp='R' */
      if (CPLib.eqr(tipostp,"R")) {
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
        /* If fonte='D' */
        if (CPLib.eqr(fonte,"D")) {
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
          SPBridge.HMCaller _h0000005D;
          _h0000005D = new SPBridge.HMCaller();
          _h0000005D.Set("m_cVQRList",m_cVQRList);
          _h0000005D.Set("daRappo",daRappo);
          _h0000005D.Set("aRappo",aRappo);
          _h0000005D.Set("DaSogg",DaSogg);
          _h0000005D.Set("ASogg",ASogg);
          _h0000005D.Set("c_dadata",c_dadata);
          _h0000005D.Set("c_adata",c_adata);
          _h0000005D.Set("coddip",coddip);
          _h0000005D.Set("attiva",attiva);
          _h0000005D.Set("mod_attiva",mod_attiva);
          _h0000005D.Set("mod_copia",mod_copia);
          _h0000005D.Set("cancellata",cancellata);
          _h0000005D.Set("tipo",tipo);
          _h0000005D.Set("pRISGLOB",pRISGLOB);
          _h0000005D.Set("pTIPOAG",pTIPOAG);
          m_cPhName = m_Ctx.CreateTmpPhName("tmp_stprapporti");
          new VQRHolder("qbe_allrapopebo",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000005D,true).CreateServerQuery(m_Ctx, "tmp_stprapporti",false);
          m_cPhName_tmp_stprapporti = m_cPhName;
          /* ElseIf fonte='P' */
        } else if (CPLib.eqr(fonte,"P")) {
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
          SPBridge.HMCaller _h0000005E;
          _h0000005E = new SPBridge.HMCaller();
          _h0000005E.Set("m_cVQRList",m_cVQRList);
          _h0000005E.Set("daRappo",daRappo);
          _h0000005E.Set("aRappo",aRappo);
          _h0000005E.Set("DaSogg",DaSogg);
          _h0000005E.Set("ASogg",ASogg);
          _h0000005E.Set("c_dadata",c_dadata);
          _h0000005E.Set("c_adata",c_adata);
          _h0000005E.Set("coddip",coddip);
          _h0000005E.Set("tipo",tipo);
          _h0000005E.Set("pRISGLOB",pRISGLOB);
          _h0000005E.Set("pTIPOAG",pTIPOAG);
          m_cPhName = m_Ctx.CreateTmpPhName("tmp_stprapporti");
          new VQRHolder("qbe_allxapopebo",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000005E,true).CreateServerQuery(m_Ctx, "tmp_stprapporti",false);
          m_cPhName_tmp_stprapporti = m_cPhName;
          /* ElseIf fonte='J' */
        } else if (CPLib.eqr(fonte,"J")) {
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
          SPBridge.HMCaller _h0000005F;
          _h0000005F = new SPBridge.HMCaller();
          _h0000005F.Set("m_cVQRList",m_cVQRList);
          _h0000005F.Set("daRappo",daRappo);
          _h0000005F.Set("aRappo",aRappo);
          _h0000005F.Set("DaSogg",DaSogg);
          _h0000005F.Set("ASogg",ASogg);
          _h0000005F.Set("c_dadata",c_dadata);
          _h0000005F.Set("c_adata",c_adata);
          _h0000005F.Set("coddip",coddip);
          _h0000005F.Set("tipo",tipo);
          _h0000005F.Set("pRISGLOB",pRISGLOB);
          _h0000005F.Set("pTIPOAG",pTIPOAG);
          m_cPhName = m_Ctx.CreateTmpPhName("tmp_stprapporti");
          new VQRHolder("qbe_allrapopebo_ae",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000005F,true).CreateServerQuery(m_Ctx, "tmp_stprapporti",false);
          m_cPhName_tmp_stprapporti = m_cPhName;
          /* ElseIf fonte='W' */
        } else if (CPLib.eqr(fonte,"W")) {
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
          SPBridge.HMCaller _h00000060;
          _h00000060 = new SPBridge.HMCaller();
          _h00000060.Set("m_cVQRList",m_cVQRList);
          _h00000060.Set("daRappo",daRappo);
          _h00000060.Set("aRappo",aRappo);
          _h00000060.Set("DaSogg",DaSogg);
          _h00000060.Set("ASogg",ASogg);
          _h00000060.Set("c_dadata",c_dadata);
          _h00000060.Set("c_adata",c_adata);
          _h00000060.Set("coddip",coddip);
          _h00000060.Set("tipo",tipo);
          _h00000060.Set("pRISGLOB",pRISGLOB);
          _h00000060.Set("pTIPOAG",pTIPOAG);
          m_cPhName = m_Ctx.CreateTmpPhName("tmp_stprapporti");
          new VQRHolder("qbe_allrapopebo_sto",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000060,true).CreateServerQuery(m_Ctx, "tmp_stprapporti",false);
          m_cPhName_tmp_stprapporti = m_cPhName;
        } // End If
        /* If detope */
        if (detope) {
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
            /* If fonte='D' */
            if (CPLib.eqr(fonte,"D")) {
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
                    Error l_oErrorFault = new Error("Read on personbo into routine arrt_stprappo_all returns two or more records. This item should return only a record.");
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
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stprappo_all",234,"00000067")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000067(m_Ctx,m_oWrInfo);
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
                    Error l_oErrorFault = new Error("Read on personbo into routine arrt_stprappo_all returns two or more records. This item should return only a record.");
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
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stprappo_all",234,"0000006A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000006A(m_Ctx,m_oWrInfo);
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
              /* ElseIf fonte='P' */
            } else if (CPLib.eqr(fonte,"P")) {
              // * --- Select from xntestbo
              m_cServer = m_Ctx.GetServer("xntestbo");
              m_cPhName = m_Ctx.GetPhName("xntestbo");
              if (Cursor_xntestbo!=null)
                Cursor_xntestbo.Close();
              Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER,DATAINI,DATAFINE,NUMPROG1,NUMPROG2,STATOREG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_tmp_stprapporti.GetString("RAPPORTO"),"?",0,0)+"  and  (NUMPROG1="+CPLib.ToSQL(Cursor_tmp_stprapporti.GetString("NUMPROG"),"?",0,0)+"  or  NUMPROG2="+CPLib.ToSQL(Cursor_tmp_stprapporti.GetString("NUMPROG"),"?",0,0)+") "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_xntestbo.Eof())) {
                // * --- Read from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                m_cSql = "";
                m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"C",16,0,m_cServer),m_cServer,Cursor_xntestbo.GetString("CODINTER"));
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
                    Error l_oErrorFault = new Error("Read on personbo into routine arrt_stprappo_all returns two or more records. This item should return only a record.");
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
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stprappo_all",234,"0000006D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000006D(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_stprapporti.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_stprapporti.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_ragsoc,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetDate("DATAINI"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetDate("DATAFINE"),"?",0,0)+", ";
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
                Cursor_xntestbo.Next();
              }
              m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
              Cursor_xntestbo.Close();
              // * --- End Select
              // * --- Select from xelegabo
              m_cServer = m_Ctx.GetServer("xelegabo");
              m_cPhName = m_Ctx.GetPhName("xelegabo");
              if (Cursor_xelegabo!=null)
                Cursor_xelegabo.Close();
              Cursor_xelegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER,DATAINI,DATAFINE,NUMPROG1,NUMPROG2  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_tmp_stprapporti.GetString("RAPPORTO"),"?",0,0)+"  and  (NUMPROG1="+CPLib.ToSQL(Cursor_tmp_stprapporti.GetString("NUMPROG"),"?",0,0)+"  or  NUMPROG2="+CPLib.ToSQL(Cursor_tmp_stprapporti.GetString("NUMPROG"),"?",0,0)+") "+")"+(m_Ctx.IsSharedTemp("xelegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_xelegabo.Eof())) {
                // * --- Read from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                m_cSql = "";
                m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xelegabo.GetString("CODINTER"),"C",16,0,m_cServer),m_cServer,Cursor_xelegabo.GetString("CODINTER"));
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
                    Error l_oErrorFault = new Error("Read on personbo into routine arrt_stprappo_all returns two or more records. This item should return only a record.");
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
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stprappo_all",234,"00000070")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000070(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_stprapporti.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_stprapporti.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xelegabo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_ragsoc,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xelegabo.GetDate("DATAINI"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xelegabo.GetDate("DATAFINE"),"?",0,0)+", ";
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
                Cursor_xelegabo.Next();
              }
              m_cConnectivityError = Cursor_xelegabo.ErrorMessage();
              Cursor_xelegabo.Close();
              // * --- End Select
              /* ElseIf fonte='J' */
            } else if (CPLib.eqr(fonte,"J")) {
              // * --- Select from jntestbo
              m_cServer = m_Ctx.GetServer("jntestbo");
              m_cPhName = m_Ctx.GetPhName("jntestbo");
              if (Cursor_jntestbo!=null)
                Cursor_jntestbo.Close();
              Cursor_jntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER,DATAINI,DATAFINE,NUMPROG1,NUMPROG2,STATOREG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_tmp_stprapporti.GetString("RAPPORTO"),"?",0,0)+"  and  (NUMPROG1="+CPLib.ToSQL(Cursor_tmp_stprapporti.GetString("NUMPROG"),"?",0,0)+"  or  NUMPROG2="+CPLib.ToSQL(Cursor_tmp_stprapporti.GetString("NUMPROG"),"?",0,0)+") "+")"+(m_Ctx.IsSharedTemp("jntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_jntestbo.Eof())) {
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
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAGSOC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _ragsoc = Read_Cursor.GetString("RAGSOC");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on personbo into routine arrt_stprappo_all returns two or more records. This item should return only a record.");
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
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stprappo_all",234,"00000073")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000073(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_stprapporti.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_stprapporti.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jntestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_ragsoc,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jntestbo.GetDate("DATAINI"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jntestbo.GetDate("DATAFINE"),"?",0,0)+", ";
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
                Cursor_jntestbo.Next();
              }
              m_cConnectivityError = Cursor_jntestbo.ErrorMessage();
              Cursor_jntestbo.Close();
              // * --- End Select
              // * --- Select from jelegabo
              m_cServer = m_Ctx.GetServer("jelegabo");
              m_cPhName = m_Ctx.GetPhName("jelegabo");
              if (Cursor_jelegabo!=null)
                Cursor_jelegabo.Close();
              Cursor_jelegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER,DATAINI,DATAFINE,NUMPROG1,NUMPROG2  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_tmp_stprapporti.GetString("RAPPORTO"),"?",0,0)+"  and  (NUMPROG1="+CPLib.ToSQL(Cursor_tmp_stprapporti.GetString("NUMPROG"),"?",0,0)+"  or  NUMPROG2="+CPLib.ToSQL(Cursor_tmp_stprapporti.GetString("NUMPROG"),"?",0,0)+") "+")"+(m_Ctx.IsSharedTemp("jelegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_jelegabo.Eof())) {
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
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAGSOC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _ragsoc = Read_Cursor.GetString("RAGSOC");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on personbo into routine arrt_stprappo_all returns two or more records. This item should return only a record.");
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
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stprappo_all",234,"00000076")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000076(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_stprapporti.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_stprapporti.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jelegabo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_ragsoc,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jelegabo.GetDate("DATAINI"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jelegabo.GetDate("DATAFINE"),"?",0,0)+", ";
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
                Cursor_jelegabo.Next();
              }
              m_cConnectivityError = Cursor_jelegabo.ErrorMessage();
              Cursor_jelegabo.Close();
              // * --- End Select
              /* ElseIf fonte='W' */
            } else if (CPLib.eqr(fonte,"W")) {
              // * --- Select from wntestbo
              m_cServer = m_Ctx.GetServer("wntestbo");
              m_cPhName = m_Ctx.GetPhName("wntestbo");
              if (Cursor_wntestbo!=null)
                Cursor_wntestbo.Close();
              Cursor_wntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER,DATAINI,DATAFINE,NUMPROG1,NUMPROG2,STATOREG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_tmp_stprapporti.GetString("RAPPORTO"),"?",0,0)+"  and  (NUMPROG1="+CPLib.ToSQL(Cursor_tmp_stprapporti.GetString("NUMPROG"),"?",0,0)+"  or  NUMPROG2="+CPLib.ToSQL(Cursor_tmp_stprapporti.GetString("NUMPROG"),"?",0,0)+") "+")"+(m_Ctx.IsSharedTemp("wntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_wntestbo.Eof())) {
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
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAGSOC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _ragsoc = Read_Cursor.GetString("RAGSOC");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on personbo into routine arrt_stprappo_all returns two or more records. This item should return only a record.");
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
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stprappo_all",234,"00000079")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000079(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_stprapporti.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_stprapporti.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jntestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_ragsoc,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jntestbo.GetDate("DATAINI"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jntestbo.GetDate("DATAFINE"),"?",0,0)+", ";
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
                Cursor_wntestbo.Next();
              }
              m_cConnectivityError = Cursor_wntestbo.ErrorMessage();
              Cursor_wntestbo.Close();
              // * --- End Select
              // * --- Select from welegabo
              m_cServer = m_Ctx.GetServer("welegabo");
              m_cPhName = m_Ctx.GetPhName("welegabo");
              if (Cursor_welegabo!=null)
                Cursor_welegabo.Close();
              Cursor_welegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER,DATAINI,DATAFINE,NUMPROG1,NUMPROG2  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_tmp_stprapporti.GetString("RAPPORTO"),"?",0,0)+"  and  (NUMPROG1="+CPLib.ToSQL(Cursor_tmp_stprapporti.GetString("NUMPROG"),"?",0,0)+"  or  NUMPROG2="+CPLib.ToSQL(Cursor_tmp_stprapporti.GetString("NUMPROG"),"?",0,0)+") "+")"+(m_Ctx.IsSharedTemp("welegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_welegabo.Eof())) {
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
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAGSOC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _ragsoc = Read_Cursor.GetString("RAGSOC");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on personbo into routine arrt_stprappo_all returns two or more records. This item should return only a record.");
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
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stprappo_all",234,"0000007C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000007C(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_stprapporti.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_stprapporti.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jelegabo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_ragsoc,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jelegabo.GetDate("DATAINI"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jelegabo.GetDate("DATAFINE"),"?",0,0)+", ";
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
                Cursor_welegabo.Next();
              }
              m_cConnectivityError = Cursor_welegabo.ErrorMessage();
              Cursor_welegabo.Close();
              // * --- End Select
            } // End If
            Cursor_tmp_stprapporti.Next();
          }
          m_cConnectivityError = Cursor_tmp_stprapporti.ErrorMessage();
          Cursor_tmp_stprapporti.Close();
          // * --- End Select
        } // End If
        /* Stop report_name */
        Forward f;
        f=new Forward("Report",false,this,Forward.Start,false);
        f.SetParameter("daRappo",daRappo);
        f.SetParameter("aRappo",aRappo);
        f.SetParameter("DaData",DaData);
        f.SetParameter("AData",AData);
        f.SetParameter("c_dadata",c_dadata);
        f.SetParameter("c_adata",c_adata);
        f.SetParameter("attiva",attiva);
        f.SetParameter("mod_attiva",mod_attiva);
        f.SetParameter("cancellata",cancellata);
        f.SetParameter("mod_copia",mod_copia);
        f.SetParameter("tipo",tipo);
        f.SetParameter("DescAzi",gDescAzi);
        f.SetParameter("showParameterMask",false);
        f.SetParameter("ReportName",report_name);
        f.SetParameter("m_cParameterSequence","daRappo"+","+"aRappo"+","+"DaData"+","+"AData"+","+"c_dadata"+","+"c_adata"+","+"attiva"+","+"mod_attiva"+","+"cancellata"+","+"mod_copia"+","+"tipo"+","+"DescAzi"+","+"showParameterMask"+","+"ReportName");
        f.SetParameter("m_cMode","hyperlink");
        throw f;
      } else { // Else
        /* If detana */
        if (detana) {
          /* Exec "Excel con Dettaglio" Page 3:Page_3 */
          Page_3();
        } else { // Else
          /* Exec "Excel Senza Dettaglio" Page 2:Page_2 */
          Page_2();
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
      try {
        if (Cursor_xntestbo!=null)
          Cursor_xntestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xelegabo!=null)
          Cursor_xelegabo.Close();
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
        if (Cursor_jelegabo!=null)
          Cursor_jelegabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wntestbo!=null)
          Cursor_wntestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_welegabo!=null)
          Cursor_welegabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_qbe_rapporti_xls=null;
    CPResultSet Cursor_qbe_rapporti_xls_prov=null;
    CPResultSet Cursor_qbe_rapporti_xls_ae=null;
    CPResultSet Cursor_qbe_rapporti_xls_sto=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_xntestbo=null;
    CPResultSet Cursor_jntestbo=null;
    CPResultSet Cursor_wntestbo=null;
    CPResultSet Cursor_intestit=null;
    CPResultSet Cursor_xntestit=null;
    CPResultSet Cursor_jntestit=null;
    CPResultSet Cursor_wntestit=null;
    CPResultSet Cursor_delegabo=null;
    CPResultSet Cursor_xelegabo=null;
    CPResultSet Cursor_jelegabo=null;
    CPResultSet Cursor_welegabo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Senza dettaglio anagrafico */
      /* file Char(1) */
      String file;
      file = CPLib.Space(1);
      /* nomeesito Char(50) := 'rapporti'+DateTimeToChar(DateTime())+".xlsx" */
      String nomeesito;
      nomeesito = "rapporti"+CPLib.DateTimeToChar(CPLib.DateTime())+".xlsx";
      /* mcqbe_rapporti_xls MemoryCursor(qbe_rapporti_xls.vqr) // mc qbe_rapporti_xls */
      MemoryCursor_qbe_rapporti_xls_vqr mcqbe_rapporti_xls;
      mcqbe_rapporti_xls = new MemoryCursor_qbe_rapporti_xls_vqr();
      /* mcintestbo MemoryCursor(intestbo) // mc intestbo */
      MemoryCursor_intestbo mcintestbo;
      mcintestbo = new MemoryCursor_intestbo();
      /* mcintestit MemoryCursor(intestit) // mc intestbo */
      MemoryCursor_intestit mcintestit;
      mcintestit = new MemoryCursor_intestit();
      /* mcdelegabo MemoryCursor(delegabo) // mc delegabo */
      /* excellFile Object(FileOutputStream) // FileOutputStream file */
      FileOutputStream excellFile;
      excellFile = null;
      /* Workbook Object(Workbook) // Workbook file */
      Workbook Workbook;
      Workbook = null;
      /* sheet Object(Sheet) // Sheet file1 */
      Sheet sheet;
      sheet = null;
      /* style Object(CellStyle) // stile della cella */
      CellStyle style;
      style = null;
      /* stylebody Object(CellStyle) // stile della cella */
      CellStyle stylebody;
      stylebody = null;
      /* stylebodydate Object(CellStyle) // stile della cella */
      CellStyle stylebodydate;
      stylebodydate = null;
      /* font Object(Font) // font da appicare allo stile */
      Font font;
      font = null;
      /* fontbody Object(Font) // font da appicare allo stile */
      Font fontbody;
      fontbody = null;
      /* row Object(Row) // riga del foglio */
      Row row;
      row = null;
      /* cell Object(Cell) // cella */
      Cell cell;
      cell = null;
      /* maxcell Numeric(0, 0) := 13 // numero di colonne */
      double maxcell;
      maxcell = CPLib.Round(13,0);
      /* nomefilexls := LRTrim(gPathApp)+"/output/"+LRTrim(gAzienda)+"/"+nomeesito */
      nomefilexls = CPLib.LRTrim(gPathApp)+"/output/"+CPLib.LRTrim(gAzienda)+"/"+nomeesito;
      /* Workbook := WorkbookFactory.create(1=1) // Workbook file */
      Workbook = WorkbookFactory.create(CPLib.eqr(1,1));
      /* excellFile := new FileOutputStream(nomefilexls) // FileOutputStream file */
      excellFile = new FileOutputStream(nomefilexls);
      /* sheet := Workbook.createSheet("Elenco Rapporti") // Sheet file1 */
      sheet = Workbook.createSheet("Elenco Rapporti");
      /* font := Workbook.createFont() // font da appicare allo stile */
      font = Workbook.createFont();
      /* font.setFontName("Arial") // font da appicare allo stile */
      font.setFontName("Arial");
      /* font.setBold(true) // font da appicare allo stile */
      font.setBold(true);
      /* font.setFontHeightInPoints(FontHeight) // font da appicare allo stile */
      font.setFontHeightInPoints(FontHeight);
      /* style := Workbook.createCellStyle() // stile della cella */
      style = Workbook.createCellStyle();
      /* style.setFont(font) // stile della cella */
      style.setFont(font);
      /* row := sheet.createRow(0) // riga del foglio */
      row = sheet.createRow(0);
      /* row.setRowStyle(style) // riga del foglio */
      row.setRowStyle(style);
      /* cell := row.createCell(0) // cella */
      cell = row.createCell(0);
      /* cell.setCellValue("Codice Rapporto") // cella */
      cell.setCellValue("Codice Rapporto");
      /* cell := row.createCell(1) // cella */
      cell = row.createCell(1);
      /* cell.setCellValue("Descrizione") // cella */
      cell.setCellValue("Descrizione");
      /* cell := row.createCell(2) // cella */
      cell = row.createCell(2);
      /* cell.setCellValue("Codice Fiscale") // cella */
      cell.setCellValue("Codice Fiscale");
      /* cell := row.createCell(3) // cella */
      cell = row.createCell(3);
      /* cell.setCellValue("Nominativo") // cella */
      cell.setCellValue("Nominativo");
      /* cell := row.createCell(4) // cella */
      cell = row.createCell(4);
      /* cell.setCellValue("Data Inizio") // cella */
      cell.setCellValue("Data Inizio");
      /* cell := row.createCell(5) // cella */
      cell = row.createCell(5);
      /* cell.setCellValue("Data Fine") // cella */
      cell.setCellValue("Data Fine");
      /* cell := row.createCell(6) // cella */
      cell = row.createCell(6);
      /* cell.setCellValue("Tipo Rapporto") // cella */
      cell.setCellValue("Tipo Rapporto");
      /* cell := row.createCell(7) // cella */
      cell = row.createCell(7);
      /* cell.setCellValue("Valuta") // cella */
      cell.setCellValue("Valuta");
      /* cell := row.createCell(8) // cella */
      cell = row.createCell(8);
      /* cell.setCellValue("Tipo Soggetto") // cella */
      cell.setCellValue("Tipo Soggetto");
      /* cell := row.createCell(9) // cella */
      cell = row.createCell(9);
      /* cell.setCellValue("Scopo Prestazione") // cella */
      cell.setCellValue("Scopo Prestazione");
      /* cell := row.createCell(10) // cella */
      cell = row.createCell(10);
      /* cell.setCellValue("Natura Prestazione") // cella */
      cell.setCellValue("Natura Prestazione");
      /* cell := row.createCell(11) // cella */
      cell = row.createCell(11);
      /* cell.setCellValue("Data Profilatura") // cella */
      cell.setCellValue("Data Profilatura");
      /* cell := row.createCell(12) // cella */
      cell = row.createCell(12);
      /* cell.setCellValue("Rischio Globale") // cella */
      cell.setCellValue("Rischio Globale");
      /* cell := row.createCell(13) // cella */
      cell = row.createCell(13);
      /* cell.setCellValue("Data Prossima Profilatura") // cella */
      cell.setCellValue("Data Prossima Profilatura");
      riga = 1;
      /* fontbody := Workbook.createFont() // font da appicare allo stile */
      fontbody = Workbook.createFont();
      /* fontbody.setFontName("Arial") // font da appicare allo stile */
      fontbody.setFontName("Arial");
      /* fontbody.setBold(false) // font da appicare allo stile */
      fontbody.setBold(false);
      /* fontbody.setFontHeightInPoints(FontHeight2) // font da appicare allo stile */
      fontbody.setFontHeightInPoints(FontHeight2);
      /* stylebody := Workbook.createCellStyle() // stile della cella */
      stylebody = Workbook.createCellStyle();
      /* stylebody.setFont(fontbody) // stile della cella */
      stylebody.setFont(fontbody);
      /* If fonte='D' */
      if (CPLib.eqr(fonte,"D")) {
        // * --- Fill memory cursor mcqbe_rapporti_xls on qbe_rapporti_xls
        mcqbe_rapporti_xls.Zap();
        SPBridge.HMCaller _h000000C7;
        _h000000C7 = new SPBridge.HMCaller();
        _h000000C7.Set("m_cVQRList",m_cVQRList);
        _h000000C7.Set("daRappo",daRappo);
        _h000000C7.Set("aRappo",aRappo);
        _h000000C7.Set("coddip",coddip);
        _h000000C7.Set("DaData",DaData);
        _h000000C7.Set("AData",AData);
        _h000000C7.Set("DaSogg",DaSogg);
        _h000000C7.Set("ASogg",ASogg);
        _h000000C7.Set("tipo",tipo);
        _h000000C7.Set("pRISGLOB",pRISGLOB);
        _h000000C7.Set("pTIPOAG",pTIPOAG);
        if (Cursor_qbe_rapporti_xls!=null)
          Cursor_qbe_rapporti_xls.Close();
        Cursor_qbe_rapporti_xls = new VQRHolder("qbe_rapporti_xls",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000C7,true).GetResultSet(m_Ctx);
        {
          final CPResultSet m_TheCursor = Cursor_qbe_rapporti_xls;
          Cursor_qbe_rapporti_xls.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arrt_stprappo_all: query on qbe_rapporti_xls returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_qbe_rapporti_xls.Eof())) {
          mcqbe_rapporti_xls.AppendBlank();
          mcqbe_rapporti_xls.row.RAPPORTO = Cursor_qbe_rapporti_xls.GetString("RAPPORTO");
          mcqbe_rapporti_xls.row.DESCRAP = Cursor_qbe_rapporti_xls.GetString("DESCRAP");
          mcqbe_rapporti_xls.row.TIPORAP = Cursor_qbe_rapporti_xls.GetString("TIPORAP");
          mcqbe_rapporti_xls.row.FLAGLIRE = Cursor_qbe_rapporti_xls.GetString("FLAGLIRE");
          mcqbe_rapporti_xls.row.VALUTA = Cursor_qbe_rapporti_xls.GetString("VALUTA");
          mcqbe_rapporti_xls.row.SCOPO = Cursor_qbe_rapporti_xls.GetString("SCOPO");
          mcqbe_rapporti_xls.row.NATURA = Cursor_qbe_rapporti_xls.GetString("NATURA");
          mcqbe_rapporti_xls.row.RISGLOB = Cursor_qbe_rapporti_xls.GetString("RISGLOB");
          mcqbe_rapporti_xls.row.DATAPROF = Cursor_qbe_rapporti_xls.GetDate("DATAPROF");
          mcqbe_rapporti_xls.row.DATAREVPROF = Cursor_qbe_rapporti_xls.GetDate("DATAREVPROF");
          Cursor_qbe_rapporti_xls.Next();
        }
        m_cConnectivityError = Cursor_qbe_rapporti_xls.ErrorMessage();
        Cursor_qbe_rapporti_xls.Close();
        mcqbe_rapporti_xls.GoTop();
        /* ElseIf fonte='P' */
      } else if (CPLib.eqr(fonte,"P")) {
        // * --- Fill memory cursor mcqbe_rapporti_xls on qbe_rapporti_xls_prov
        mcqbe_rapporti_xls.Zap();
        SPBridge.HMCaller _h000000C8;
        _h000000C8 = new SPBridge.HMCaller();
        _h000000C8.Set("m_cVQRList",m_cVQRList);
        _h000000C8.Set("daRappo",daRappo);
        _h000000C8.Set("aRappo",aRappo);
        _h000000C8.Set("coddip",coddip);
        _h000000C8.Set("DaData",DaData);
        _h000000C8.Set("AData",AData);
        _h000000C8.Set("DaSogg",DaSogg);
        _h000000C8.Set("ASogg",ASogg);
        _h000000C8.Set("tipo",tipo);
        _h000000C8.Set("pRISGLOB",pRISGLOB);
        _h000000C8.Set("pTIPOAG",pTIPOAG);
        if (Cursor_qbe_rapporti_xls_prov!=null)
          Cursor_qbe_rapporti_xls_prov.Close();
        Cursor_qbe_rapporti_xls_prov = new VQRHolder("qbe_rapporti_xls_prov",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000C8,true).GetResultSet(m_Ctx);
        {
          final CPResultSet m_TheCursor = Cursor_qbe_rapporti_xls_prov;
          Cursor_qbe_rapporti_xls_prov.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arrt_stprappo_all: query on qbe_rapporti_xls_prov returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_qbe_rapporti_xls_prov.Eof())) {
          mcqbe_rapporti_xls.AppendBlank();
          mcqbe_rapporti_xls.row.RAPPORTO = Cursor_qbe_rapporti_xls_prov.GetString("RAPPORTO");
          mcqbe_rapporti_xls.row.DESCRAP = Cursor_qbe_rapporti_xls_prov.GetString("DESCRAP");
          mcqbe_rapporti_xls.row.TIPORAP = Cursor_qbe_rapporti_xls_prov.GetString("TIPORAP");
          mcqbe_rapporti_xls.row.FLAGLIRE = Cursor_qbe_rapporti_xls_prov.GetString("FLAGLIRE");
          mcqbe_rapporti_xls.row.VALUTA = Cursor_qbe_rapporti_xls_prov.GetString("VALUTA");
          mcqbe_rapporti_xls.row.SCOPO = Cursor_qbe_rapporti_xls_prov.GetString("SCOPO");
          mcqbe_rapporti_xls.row.NATURA = Cursor_qbe_rapporti_xls_prov.GetString("NATURA");
          mcqbe_rapporti_xls.row.RISGLOB = Cursor_qbe_rapporti_xls_prov.GetString("RISGLOB");
          mcqbe_rapporti_xls.row.DATAPROF = Cursor_qbe_rapporti_xls_prov.GetDate("DATAPROF");
          mcqbe_rapporti_xls.row.DATAREVPROF = Cursor_qbe_rapporti_xls_prov.GetDate("DATAREVPROF");
          Cursor_qbe_rapporti_xls_prov.Next();
        }
        m_cConnectivityError = Cursor_qbe_rapporti_xls_prov.ErrorMessage();
        Cursor_qbe_rapporti_xls_prov.Close();
        mcqbe_rapporti_xls.GoTop();
        /* ElseIf fonte='J' */
      } else if (CPLib.eqr(fonte,"J")) {
        // * --- Fill memory cursor mcqbe_rapporti_xls on qbe_rapporti_xls_ae
        mcqbe_rapporti_xls.Zap();
        SPBridge.HMCaller _h000000C9;
        _h000000C9 = new SPBridge.HMCaller();
        _h000000C9.Set("m_cVQRList",m_cVQRList);
        _h000000C9.Set("daRappo",daRappo);
        _h000000C9.Set("aRappo",aRappo);
        _h000000C9.Set("coddip",coddip);
        _h000000C9.Set("DaData",DaData);
        _h000000C9.Set("AData",AData);
        _h000000C9.Set("DaSogg",DaSogg);
        _h000000C9.Set("ASogg",ASogg);
        _h000000C9.Set("tipo",tipo);
        _h000000C9.Set("pRISGLOB",pRISGLOB);
        _h000000C9.Set("pTIPOAG",pTIPOAG);
        if (Cursor_qbe_rapporti_xls_ae!=null)
          Cursor_qbe_rapporti_xls_ae.Close();
        Cursor_qbe_rapporti_xls_ae = new VQRHolder("qbe_rapporti_xls_ae",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000C9,true).GetResultSet(m_Ctx);
        {
          final CPResultSet m_TheCursor = Cursor_qbe_rapporti_xls_ae;
          Cursor_qbe_rapporti_xls_ae.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arrt_stprappo_all: query on qbe_rapporti_xls_ae returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_qbe_rapporti_xls_ae.Eof())) {
          mcqbe_rapporti_xls.AppendBlank();
          mcqbe_rapporti_xls.row.RAPPORTO = Cursor_qbe_rapporti_xls_ae.GetString("RAPPORTO");
          mcqbe_rapporti_xls.row.DESCRAP = Cursor_qbe_rapporti_xls_ae.GetString("DESCRAP");
          mcqbe_rapporti_xls.row.TIPORAP = Cursor_qbe_rapporti_xls_ae.GetString("TIPORAP");
          mcqbe_rapporti_xls.row.FLAGLIRE = Cursor_qbe_rapporti_xls_ae.GetString("FLAGLIRE");
          mcqbe_rapporti_xls.row.VALUTA = Cursor_qbe_rapporti_xls_ae.GetString("VALUTA");
          mcqbe_rapporti_xls.row.SCOPO = Cursor_qbe_rapporti_xls_ae.GetString("SCOPO");
          mcqbe_rapporti_xls.row.NATURA = Cursor_qbe_rapporti_xls_ae.GetString("NATURA");
          mcqbe_rapporti_xls.row.RISGLOB = Cursor_qbe_rapporti_xls_ae.GetString("RISGLOB");
          mcqbe_rapporti_xls.row.DATAPROF = Cursor_qbe_rapporti_xls_ae.GetDate("DATAPROF");
          mcqbe_rapporti_xls.row.DATAREVPROF = Cursor_qbe_rapporti_xls_ae.GetDate("DATAREVPROF");
          Cursor_qbe_rapporti_xls_ae.Next();
        }
        m_cConnectivityError = Cursor_qbe_rapporti_xls_ae.ErrorMessage();
        Cursor_qbe_rapporti_xls_ae.Close();
        mcqbe_rapporti_xls.GoTop();
        /* ElseIf fonte='W' */
      } else if (CPLib.eqr(fonte,"W")) {
        // * --- Fill memory cursor mcqbe_rapporti_xls on qbe_rapporti_xls_sto
        mcqbe_rapporti_xls.Zap();
        SPBridge.HMCaller _h000000CA;
        _h000000CA = new SPBridge.HMCaller();
        _h000000CA.Set("m_cVQRList",m_cVQRList);
        _h000000CA.Set("daRappo",daRappo);
        _h000000CA.Set("aRappo",aRappo);
        _h000000CA.Set("coddip",coddip);
        _h000000CA.Set("DaData",DaData);
        _h000000CA.Set("AData",AData);
        _h000000CA.Set("DaSogg",DaSogg);
        _h000000CA.Set("ASogg",ASogg);
        _h000000CA.Set("tipo",tipo);
        _h000000CA.Set("pRISGLOB",pRISGLOB);
        _h000000CA.Set("pTIPOAG",pTIPOAG);
        if (Cursor_qbe_rapporti_xls_sto!=null)
          Cursor_qbe_rapporti_xls_sto.Close();
        Cursor_qbe_rapporti_xls_sto = new VQRHolder("qbe_rapporti_xls_sto",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000CA,true).GetResultSet(m_Ctx);
        {
          final CPResultSet m_TheCursor = Cursor_qbe_rapporti_xls_sto;
          Cursor_qbe_rapporti_xls_sto.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arrt_stprappo_all: query on qbe_rapporti_xls_sto returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_qbe_rapporti_xls_sto.Eof())) {
          mcqbe_rapporti_xls.AppendBlank();
          mcqbe_rapporti_xls.row.RAPPORTO = Cursor_qbe_rapporti_xls_sto.GetString("RAPPORTO");
          mcqbe_rapporti_xls.row.DESCRAP = Cursor_qbe_rapporti_xls_sto.GetString("DESCRAP");
          mcqbe_rapporti_xls.row.TIPORAP = Cursor_qbe_rapporti_xls_sto.GetString("TIPORAP");
          mcqbe_rapporti_xls.row.FLAGLIRE = Cursor_qbe_rapporti_xls_sto.GetString("FLAGLIRE");
          mcqbe_rapporti_xls.row.VALUTA = Cursor_qbe_rapporti_xls_sto.GetString("VALUTA");
          mcqbe_rapporti_xls.row.SCOPO = Cursor_qbe_rapporti_xls_sto.GetString("SCOPO");
          mcqbe_rapporti_xls.row.NATURA = Cursor_qbe_rapporti_xls_sto.GetString("NATURA");
          mcqbe_rapporti_xls.row.RISGLOB = Cursor_qbe_rapporti_xls_sto.GetString("RISGLOB");
          mcqbe_rapporti_xls.row.DATAPROF = Cursor_qbe_rapporti_xls_sto.GetDate("DATAPROF");
          mcqbe_rapporti_xls.row.DATAREVPROF = Cursor_qbe_rapporti_xls_sto.GetDate("DATAREVPROF");
          Cursor_qbe_rapporti_xls_sto.Next();
        }
        m_cConnectivityError = Cursor_qbe_rapporti_xls_sto.ErrorMessage();
        Cursor_qbe_rapporti_xls_sto.Close();
        mcqbe_rapporti_xls.GoTop();
      } // End If
      for (MemoryCursorRow_qbe_rapporti_xls_vqr rwqbe_rapporti_xls : mcqbe_rapporti_xls._iterable_()) {
        /* gMsgImp := "Elaborazione Rapporto "+ rwqbe_rapporti_xls.RAPPORTO // Messaggio Import */
        gMsgImp = "Elaborazione Rapporto "+rwqbe_rapporti_xls.RAPPORTO;
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* rapporto := rwqbe_rapporti_xls.RAPPORTO */
        rapporto = rwqbe_rapporti_xls.RAPPORTO;
        /* descrap := rwqbe_rapporti_xls.DESCRAP */
        descrap = rwqbe_rapporti_xls.DESCRAP;
        /* tiprap := rwqbe_rapporti_xls.TIPORAP */
        tiprap = rwqbe_rapporti_xls.TIPORAP;
        /* valuta := rwqbe_rapporti_xls.VALUTA */
        valuta = rwqbe_rapporti_xls.VALUTA;
        /* _scopo := rwqbe_rapporti_xls.SCOPO */
        _scopo = rwqbe_rapporti_xls.SCOPO;
        /* _natura := rwqbe_rapporti_xls.NATURA */
        _natura = rwqbe_rapporti_xls.NATURA;
        /* _risglob := '' */
        _risglob = "";
        /* If not(Empty(rwqbe_rapporti_xls.RISGLOB)) */
        if ( ! (CPLib.Empty(rwqbe_rapporti_xls.RISGLOB))) {
          // * --- Read from tbrisglob
          m_cServer = m_Ctx.GetServer("tbrisglob");
          m_cPhName = m_Ctx.GetPhName("tbrisglob");
          m_cSql = "";
          m_cSql = m_cSql+"CODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwqbe_rapporti_xls.RISGLOB,"C",3,0,m_cServer),m_cServer,rwqbe_rapporti_xls.RISGLOB);
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
              Error l_oErrorFault = new Error("Read on tbrisglob into routine arrt_stprappo_all returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _risglob = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* _risglob := LRTrim(rwqbe_rapporti_xls.RISGLOB)+"-"+ LRTrim(_risglob) */
          _risglob = CPLib.LRTrim(rwqbe_rapporti_xls.RISGLOB)+"-"+CPLib.LRTrim(_risglob);
        } // End If
        /* _datprof := arfn_fdate(rwqbe_rapporti_xls.DATAPROF) */
        _datprof = arfn_fdateR.Make(m_Ctx,this).Run(rwqbe_rapporti_xls.DATAPROF);
        /* _datrevprof := arfn_fdate(rwqbe_rapporti_xls.DATAREVPROF) */
        _datrevprof = arfn_fdateR.Make(m_Ctx,this).Run(rwqbe_rapporti_xls.DATAREVPROF);
        /* If fonte='D' */
        if (CPLib.eqr(fonte,"D")) {
          // * --- Fill memory cursor mcintestbo on intestbo
          mcintestbo.Zap();
          m_cServer = m_Ctx.GetServer("intestbo");
          m_cPhName = m_Ctx.GetPhName("intestbo");
          if (Cursor_intestbo!=null)
            Cursor_intestbo.Close();
          Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwqbe_rapporti_xls.RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,rwqbe_rapporti_xls.RAPPORTO)+"  and  (STATOREG <> '2'  or  STATOREG <> '3') "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          {
            final CPResultSet m_TheCursor = Cursor_intestbo;
            Cursor_intestbo.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_stprappo_all: query on intestbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_intestbo.Eof())) {
            mcintestbo.AppendBlank();
            mcintestbo.row.IDBASE = Cursor_intestbo.GetString("IDBASE");
            mcintestbo.row.CPROWNUM = Cursor_intestbo.GetDouble("CPROWNUM");
            mcintestbo.row.DATAINI = Cursor_intestbo.GetDate("DATAINI");
            mcintestbo.row.TIPOPERS = Cursor_intestbo.GetString("TIPOPERS");
            mcintestbo.row.CODINTER = Cursor_intestbo.GetString("CODINTER");
            mcintestbo.row.DATAFINE = Cursor_intestbo.GetDate("DATAFINE");
            mcintestbo.row.NUMPROG1 = Cursor_intestbo.GetString("NUMPROG1");
            mcintestbo.row.NUMPROG2 = Cursor_intestbo.GetString("NUMPROG2");
            mcintestbo.row.RAPPORTO = Cursor_intestbo.GetString("RAPPORTO");
            mcintestbo.row.TIPORAP = Cursor_intestbo.GetString("TIPORAP");
            mcintestbo.row.STATOREG = Cursor_intestbo.GetString("STATOREG");
            mcintestbo.row.DESCINTER = Cursor_intestbo.GetString("DESCINTER");
            mcintestbo.row.OPERAZMOD = Cursor_intestbo.GetString("OPERAZMOD");
            mcintestbo.row.DATARETT = Cursor_intestbo.GetDate("DATARETT");
            mcintestbo.row.IDEREG = Cursor_intestbo.GetString("IDEREG");
            mcintestbo.row.COLLEGAMEN = Cursor_intestbo.GetString("COLLEGAMEN");
            mcintestbo.row.UCODE = Cursor_intestbo.GetString("UCODE");
            mcintestbo.row.ABBINATO = Cursor_intestbo.GetDouble("ABBINATO");
            mcintestbo.row.PRGIMPSOG = Cursor_intestbo.GetDouble("PRGIMPSOG");
            mcintestbo.row.PROQUOTA = Cursor_intestbo.GetDouble("PROQUOTA");
            mcintestbo.row.NUMIMP = Cursor_intestbo.GetDateTime("NUMIMP");
            Cursor_intestbo.Next();
          }
          m_cConnectivityError = Cursor_intestbo.ErrorMessage();
          Cursor_intestbo.Close();
          mcintestbo.GoTop();
          /* ElseIf fonte='P' */
        } else if (CPLib.eqr(fonte,"P")) {
          // * --- Fill memory cursor mcintestbo on xntestbo
          mcintestbo.Zap();
          m_cServer = m_Ctx.GetServer("xntestbo");
          m_cPhName = m_Ctx.GetPhName("xntestbo");
          if (Cursor_xntestbo!=null)
            Cursor_xntestbo.Close();
          Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwqbe_rapporti_xls.RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,rwqbe_rapporti_xls.RAPPORTO)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          {
            final CPResultSet m_TheCursor = Cursor_xntestbo;
            Cursor_xntestbo.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_stprappo_all: query on xntestbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_xntestbo.Eof())) {
            mcintestbo.AppendBlank();
            mcintestbo.row.IDBASE = Cursor_xntestbo.GetString("IDBASE");
            mcintestbo.row.CPROWNUM = Cursor_xntestbo.GetDouble("CPROWNUM");
            mcintestbo.row.DATAINI = Cursor_xntestbo.GetDate("DATAINI");
            mcintestbo.row.TIPOPERS = Cursor_xntestbo.GetString("TIPOPERS");
            mcintestbo.row.CODINTER = Cursor_xntestbo.GetString("CODINTER");
            mcintestbo.row.DATAFINE = Cursor_xntestbo.GetDate("DATAFINE");
            mcintestbo.row.NUMPROG1 = Cursor_xntestbo.GetString("NUMPROG1");
            mcintestbo.row.NUMPROG2 = Cursor_xntestbo.GetString("NUMPROG2");
            mcintestbo.row.RAPPORTO = Cursor_xntestbo.GetString("RAPPORTO");
            mcintestbo.row.TIPORAP = Cursor_xntestbo.GetString("TIPORAP");
            mcintestbo.row.STATOREG = Cursor_xntestbo.GetString("STATOREG");
            mcintestbo.row.DESCINTER = Cursor_xntestbo.GetString("DESCINTER");
            mcintestbo.row.OPERAZMOD = Cursor_xntestbo.GetString("OPERAZMOD");
            mcintestbo.row.DATARETT = Cursor_xntestbo.GetDate("DATARETT");
            mcintestbo.row.IDEREG = Cursor_xntestbo.GetString("IDEREG");
            mcintestbo.row.COLLEGAMEN = Cursor_xntestbo.GetString("COLLEGAMEN");
            mcintestbo.row.UCODE = Cursor_xntestbo.GetString("UCODE");
            mcintestbo.row.ABBINATO = Cursor_xntestbo.GetDouble("ABBINATO");
            mcintestbo.row.PRGIMPSOG = Cursor_xntestbo.GetDouble("PRGIMPSOG");
            mcintestbo.row.PROQUOTA = Cursor_xntestbo.GetDouble("PROQUOTA");
            mcintestbo.row.NUMIMP = Cursor_xntestbo.GetDateTime("NUMIMP");
            Cursor_xntestbo.Next();
          }
          m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
          Cursor_xntestbo.Close();
          mcintestbo.GoTop();
          /* ElseIf fonte='J' */
        } else if (CPLib.eqr(fonte,"J")) {
          // * --- Fill memory cursor mcintestbo on jntestbo
          mcintestbo.Zap();
          m_cServer = m_Ctx.GetServer("jntestbo");
          m_cPhName = m_Ctx.GetPhName("jntestbo");
          if (Cursor_jntestbo!=null)
            Cursor_jntestbo.Close();
          Cursor_jntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwqbe_rapporti_xls.RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,rwqbe_rapporti_xls.RAPPORTO)+" "+")"+(m_Ctx.IsSharedTemp("jntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          {
            final CPResultSet m_TheCursor = Cursor_jntestbo;
            Cursor_jntestbo.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_stprappo_all: query on jntestbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_jntestbo.Eof())) {
            mcintestbo.AppendBlank();
            mcintestbo.row.IDBASE = Cursor_jntestbo.GetString("IDBASE");
            mcintestbo.row.CPROWNUM = Cursor_jntestbo.GetDouble("CPROWNUM");
            mcintestbo.row.DATAINI = Cursor_jntestbo.GetDate("DATAINI");
            mcintestbo.row.TIPOPERS = Cursor_jntestbo.GetString("TIPOPERS");
            mcintestbo.row.CODINTER = Cursor_jntestbo.GetString("CODINTER");
            mcintestbo.row.DATAFINE = Cursor_jntestbo.GetDate("DATAFINE");
            mcintestbo.row.NUMPROG1 = Cursor_jntestbo.GetString("NUMPROG1");
            mcintestbo.row.NUMPROG2 = Cursor_jntestbo.GetString("NUMPROG2");
            mcintestbo.row.RAPPORTO = Cursor_jntestbo.GetString("RAPPORTO");
            mcintestbo.row.TIPORAP = Cursor_jntestbo.GetString("TIPORAP");
            mcintestbo.row.STATOREG = Cursor_jntestbo.GetString("STATOREG");
            mcintestbo.row.DESCINTER = Cursor_jntestbo.GetString("DESCINTER");
            mcintestbo.row.OPERAZMOD = Cursor_jntestbo.GetString("OPERAZMOD");
            mcintestbo.row.DATARETT = Cursor_jntestbo.GetDate("DATARETT");
            mcintestbo.row.IDEREG = Cursor_jntestbo.GetString("IDEREG");
            mcintestbo.row.COLLEGAMEN = Cursor_jntestbo.GetString("COLLEGAMEN");
            mcintestbo.row.UCODE = Cursor_jntestbo.GetString("UCODE");
            mcintestbo.row.ABBINATO = Cursor_jntestbo.GetDouble("ABBINATO");
            mcintestbo.row.PRGIMPSOG = Cursor_jntestbo.GetDouble("PRGIMPSOG");
            mcintestbo.row.PROQUOTA = Cursor_jntestbo.GetDouble("PROQUOTA");
            mcintestbo.row.NUMIMP = Cursor_jntestbo.GetDateTime("NUMIMP");
            Cursor_jntestbo.Next();
          }
          m_cConnectivityError = Cursor_jntestbo.ErrorMessage();
          Cursor_jntestbo.Close();
          mcintestbo.GoTop();
          /* ElseIf fonte='W' */
        } else if (CPLib.eqr(fonte,"W")) {
          // * --- Fill memory cursor mcintestbo on wntestbo
          mcintestbo.Zap();
          m_cServer = m_Ctx.GetServer("wntestbo");
          m_cPhName = m_Ctx.GetPhName("wntestbo");
          if (Cursor_wntestbo!=null)
            Cursor_wntestbo.Close();
          Cursor_wntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwqbe_rapporti_xls.RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,rwqbe_rapporti_xls.RAPPORTO)+" "+")"+(m_Ctx.IsSharedTemp("wntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          {
            final CPResultSet m_TheCursor = Cursor_wntestbo;
            Cursor_wntestbo.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_stprappo_all: query on wntestbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_wntestbo.Eof())) {
            mcintestbo.AppendBlank();
            mcintestbo.row.IDBASE = Cursor_wntestbo.GetString("IDBASE");
            mcintestbo.row.CPROWNUM = Cursor_wntestbo.GetDouble("CPROWNUM");
            mcintestbo.row.DATAINI = Cursor_wntestbo.GetDate("DATAINI");
            mcintestbo.row.TIPOPERS = Cursor_wntestbo.GetString("TIPOPERS");
            mcintestbo.row.CODINTER = Cursor_wntestbo.GetString("CODINTER");
            mcintestbo.row.DATAFINE = Cursor_wntestbo.GetDate("DATAFINE");
            mcintestbo.row.NUMPROG1 = Cursor_wntestbo.GetString("NUMPROG1");
            mcintestbo.row.NUMPROG2 = Cursor_wntestbo.GetString("NUMPROG2");
            mcintestbo.row.RAPPORTO = Cursor_wntestbo.GetString("RAPPORTO");
            mcintestbo.row.TIPORAP = Cursor_wntestbo.GetString("TIPORAP");
            mcintestbo.row.STATOREG = Cursor_wntestbo.GetString("STATOREG");
            mcintestbo.row.DESCINTER = Cursor_wntestbo.GetString("DESCINTER");
            mcintestbo.row.OPERAZMOD = Cursor_wntestbo.GetString("OPERAZMOD");
            mcintestbo.row.DATARETT = Cursor_wntestbo.GetDate("DATARETT");
            mcintestbo.row.IDEREG = Cursor_wntestbo.GetString("IDEREG");
            mcintestbo.row.COLLEGAMEN = Cursor_wntestbo.GetString("COLLEGAMEN");
            mcintestbo.row.UCODE = Cursor_wntestbo.GetString("UCODE");
            mcintestbo.row.ABBINATO = Cursor_wntestbo.GetDouble("ABBINATO");
            mcintestbo.row.PRGIMPSOG = Cursor_wntestbo.GetDouble("PRGIMPSOG");
            mcintestbo.row.PROQUOTA = Cursor_wntestbo.GetDouble("PROQUOTA");
            mcintestbo.row.NUMIMP = Cursor_wntestbo.GetDateTime("NUMIMP");
            Cursor_wntestbo.Next();
          }
          m_cConnectivityError = Cursor_wntestbo.ErrorMessage();
          Cursor_wntestbo.Close();
          mcintestbo.GoTop();
        } // End If
        for (MemoryCursorRow_intestbo rwintestbo : mcintestbo._iterable_()) {
          /* connes := rwintestbo.CODINTER */
          connes = rwintestbo.CODINTER;
          /* dataini := arfn_fdate(rwintestbo.DATAINI) */
          dataini = arfn_fdateR.Make(m_Ctx,this).Run(rwintestbo.DATAINI);
          /* datafin := arfn_fdate(rwintestbo.DATAFINE) */
          datafin = arfn_fdateR.Make(m_Ctx,this).Run(rwintestbo.DATAFINE);
          /* cf := '' */
          cf = "";
          /* _ragsoc := '' */
          _ragsoc = "";
          // * --- Read from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          m_cSql = "";
          m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwintestbo.CODINTER,"C",16,0,m_cServer),m_cServer,rwintestbo.CODINTER);
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
              Error l_oErrorFault = new Error("Read on personbo into routine arrt_stprappo_all returns two or more records. This item should return only a record.");
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
          /* row := sheet.createRow(riga) // riga del foglio */
          row = sheet.createRow(riga);
          /* row.setRowStyle(stylebody) // riga del foglio */
          row.setRowStyle(stylebody);
          /* cell := row.createCell(0) // cella */
          cell = row.createCell(0);
          /* cell.setCellValue(rapporto) // cella */
          cell.setCellValue(rapporto);
          /* cell := row.createCell(1) // cella */
          cell = row.createCell(1);
          /* cell.setCellValue(descrap) // cella */
          cell.setCellValue(descrap);
          /* cell := row.createCell(2) // cella */
          cell = row.createCell(2);
          /* cell.setCellValue(cf) // cella */
          cell.setCellValue(cf);
          /* cell := row.createCell(3) // cella */
          cell = row.createCell(3);
          /* cell.setCellValue(_ragsoc) // cella */
          cell.setCellValue(_ragsoc);
          /* cell := row.createCell(4) // cella */
          cell = row.createCell(4);
          /* cell.setCellValue(dataini) // cella */
          cell.setCellValue(dataini);
          /* cell := row.createCell(5) // cella */
          cell = row.createCell(5);
          /* cell.setCellValue(datafin) // cella */
          cell.setCellValue(datafin);
          /* cell := row.createCell(6) // cella */
          cell = row.createCell(6);
          /* cell.setCellValue(tiprap) // cella */
          cell.setCellValue(tiprap);
          /* cell := row.createCell(7) // cella */
          cell = row.createCell(7);
          /* cell.setCellValue(valuta) // cella */
          cell.setCellValue(valuta);
          /* cell := row.createCell(8) // cella */
          cell = row.createCell(8);
          /* cell.setCellValue("I") // cella */
          cell.setCellValue("I");
          /* cell := row.createCell(9) // cella */
          cell = row.createCell(9);
          /* cell.setCellValue(_scopo) // cella */
          cell.setCellValue(_scopo);
          /* cell := row.createCell(10) // cella */
          cell = row.createCell(10);
          /* cell.setCellValue(_natura) // cella */
          cell.setCellValue(_natura);
          /* cell := row.createCell(11) // cella */
          cell = row.createCell(11);
          /* cell.setCellValue(_datprof) // cella */
          cell.setCellValue(_datprof);
          /* cell := row.createCell(12) // cella */
          cell = row.createCell(12);
          /* cell.setCellValue(_risglob) // cella */
          cell.setCellValue(_risglob);
          /* cell := row.createCell(13) // cella */
          cell = row.createCell(13);
          /* cell.setCellValue(_datrevprof) // cella */
          cell.setCellValue(_datrevprof);
          riga = riga + 1;
          /* If flgtit */
          if (flgtit) {
            /* If fonte='D' */
            if (CPLib.eqr(fonte,"D")) {
              // * --- Fill memory cursor mcintestit on intestit
              mcintestit.Zap();
              m_cServer = m_Ctx.GetServer("intestit");
              m_cPhName = m_Ctx.GetPhName("intestit");
              if (Cursor_intestit!=null)
                Cursor_intestit.Close();
              Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwintestbo.CODINTER,"?",0,0,m_cServer, m_oParameters),m_cServer,rwintestbo.CODINTER)+"  and  (STATOREG <> '2'  or  STATOREG <> '3') "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              {
                final CPResultSet m_TheCursor = Cursor_intestit;
                Cursor_intestit.ActionOnClose(new Runnable() {
                  public void run() {
                    if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                      com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                      if ( ! (CPLib.IsNull(info))) {
                        info.log("Routine arrt_stprappo_all: query on intestit returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                      }
                    }
                  }
                  });
              }
              while ( ! (Cursor_intestit.Eof())) {
                mcintestit.AppendBlank();
                mcintestit.row.CODCLI = Cursor_intestit.GetString("CODCLI");
                mcintestit.row.RAPPORTO = Cursor_intestit.GetString("RAPPORTO");
                mcintestit.row.CODINTER = Cursor_intestit.GetString("CODINTER");
                mcintestit.row.DESCINTER = Cursor_intestit.GetString("DESCINTER");
                mcintestit.row.DATAINI = Cursor_intestit.GetDate("DATAINI");
                mcintestit.row.TIPORAP = Cursor_intestit.GetString("TIPORAP");
                mcintestit.row.TIPOPERS = Cursor_intestit.GetString("TIPOPERS");
                mcintestit.row.STATOREG = Cursor_intestit.GetString("STATOREG");
                mcintestit.row.OPERAZMOD = Cursor_intestit.GetString("OPERAZMOD");
                mcintestit.row.DATARETT = Cursor_intestit.GetDate("DATARETT");
                mcintestit.row.IDEREG = Cursor_intestit.GetString("IDEREG");
                mcintestit.row.COLLEGAMEN = Cursor_intestit.GetString("COLLEGAMEN");
                mcintestit.row.DATAFINE = Cursor_intestit.GetDate("DATAFINE");
                mcintestit.row.NUMPROG1 = Cursor_intestit.GetString("NUMPROG1");
                mcintestit.row.NUMPROG2 = Cursor_intestit.GetString("NUMPROG2");
                mcintestit.row.IDBASE = Cursor_intestit.GetString("IDBASE");
                mcintestit.row.UCODE = Cursor_intestit.GetString("UCODE");
                mcintestit.row.ABBINATO = Cursor_intestit.GetDouble("ABBINATO");
                mcintestit.row.PRGIMPTITE = Cursor_intestit.GetDouble("PRGIMPTITE");
                mcintestit.row.NUMIMP = Cursor_intestit.GetDateTime("NUMIMP");
                mcintestit.row.NOAGE = Cursor_intestit.GetString("NOAGE");
                Cursor_intestit.Next();
              }
              m_cConnectivityError = Cursor_intestit.ErrorMessage();
              Cursor_intestit.Close();
              mcintestit.GoTop();
              /* ElseIf fonte='P' */
            } else if (CPLib.eqr(fonte,"P")) {
              // * --- Fill memory cursor mcintestit on xntestit
              mcintestit.Zap();
              m_cServer = m_Ctx.GetServer("xntestit");
              m_cPhName = m_Ctx.GetPhName("xntestit");
              if (Cursor_xntestit!=null)
                Cursor_xntestit.Close();
              Cursor_xntestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwintestbo.CODINTER,"?",0,0,m_cServer, m_oParameters),m_cServer,rwintestbo.CODINTER)+" "+")"+(m_Ctx.IsSharedTemp("xntestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              {
                final CPResultSet m_TheCursor = Cursor_xntestit;
                Cursor_xntestit.ActionOnClose(new Runnable() {
                  public void run() {
                    if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                      com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                      if ( ! (CPLib.IsNull(info))) {
                        info.log("Routine arrt_stprappo_all: query on xntestit returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                      }
                    }
                  }
                  });
              }
              while ( ! (Cursor_xntestit.Eof())) {
                mcintestit.AppendBlank();
                mcintestit.row.CODCLI = Cursor_xntestit.GetString("CODCLI");
                mcintestit.row.RAPPORTO = Cursor_xntestit.GetString("RAPPORTO");
                mcintestit.row.CODINTER = Cursor_xntestit.GetString("CODINTER");
                mcintestit.row.DESCINTER = Cursor_xntestit.GetString("DESCINTER");
                mcintestit.row.DATAINI = Cursor_xntestit.GetDate("DATAINI");
                mcintestit.row.TIPORAP = Cursor_xntestit.GetString("TIPORAP");
                mcintestit.row.TIPOPERS = Cursor_xntestit.GetString("TIPOPERS");
                mcintestit.row.STATOREG = Cursor_xntestit.GetString("STATOREG");
                mcintestit.row.OPERAZMOD = Cursor_xntestit.GetString("OPERAZMOD");
                mcintestit.row.DATARETT = Cursor_xntestit.GetDate("DATARETT");
                mcintestit.row.IDEREG = Cursor_xntestit.GetString("IDEREG");
                mcintestit.row.COLLEGAMEN = Cursor_xntestit.GetString("COLLEGAMEN");
                mcintestit.row.DATAFINE = Cursor_xntestit.GetDate("DATAFINE");
                mcintestit.row.NUMPROG1 = Cursor_xntestit.GetString("NUMPROG1");
                mcintestit.row.NUMPROG2 = Cursor_xntestit.GetString("NUMPROG2");
                mcintestit.row.IDBASE = Cursor_xntestit.GetString("IDBASE");
                mcintestit.row.UCODE = Cursor_xntestit.GetString("UCODE");
                mcintestit.row.ABBINATO = Cursor_xntestit.GetDouble("ABBINATO");
                mcintestit.row.PRGIMPTITE = Cursor_xntestit.GetDouble("PRGIMPTITE");
                mcintestit.row.NUMIMP = Cursor_xntestit.GetDateTime("NUMIMP");
                mcintestit.row.NOAGE = Cursor_xntestit.GetString("NOAGE");
                Cursor_xntestit.Next();
              }
              m_cConnectivityError = Cursor_xntestit.ErrorMessage();
              Cursor_xntestit.Close();
              mcintestit.GoTop();
              /* ElseIf fonte='J' */
            } else if (CPLib.eqr(fonte,"J")) {
              // * --- Fill memory cursor mcintestit on jntestit
              mcintestit.Zap();
              m_cServer = m_Ctx.GetServer("jntestit");
              m_cPhName = m_Ctx.GetPhName("jntestit");
              if (Cursor_jntestit!=null)
                Cursor_jntestit.Close();
              Cursor_jntestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwintestbo.CODINTER,"?",0,0,m_cServer, m_oParameters),m_cServer,rwintestbo.CODINTER)+" "+")"+(m_Ctx.IsSharedTemp("jntestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              {
                final CPResultSet m_TheCursor = Cursor_jntestit;
                Cursor_jntestit.ActionOnClose(new Runnable() {
                  public void run() {
                    if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                      com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                      if ( ! (CPLib.IsNull(info))) {
                        info.log("Routine arrt_stprappo_all: query on jntestit returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                      }
                    }
                  }
                  });
              }
              while ( ! (Cursor_jntestit.Eof())) {
                mcintestit.AppendBlank();
                mcintestit.row.CODCLI = Cursor_jntestit.GetString("CODCLI");
                mcintestit.row.RAPPORTO = Cursor_jntestit.GetString("RAPPORTO");
                mcintestit.row.CODINTER = Cursor_jntestit.GetString("CODINTER");
                mcintestit.row.DESCINTER = Cursor_jntestit.GetString("DESCINTER");
                mcintestit.row.DATAINI = Cursor_jntestit.GetDate("DATAINI");
                mcintestit.row.TIPORAP = Cursor_jntestit.GetString("TIPORAP");
                mcintestit.row.TIPOPERS = Cursor_jntestit.GetString("TIPOPERS");
                mcintestit.row.STATOREG = Cursor_jntestit.GetString("STATOREG");
                mcintestit.row.OPERAZMOD = Cursor_jntestit.GetString("OPERAZMOD");
                mcintestit.row.DATARETT = Cursor_jntestit.GetDate("DATARETT");
                mcintestit.row.IDEREG = Cursor_jntestit.GetString("IDEREG");
                mcintestit.row.COLLEGAMEN = Cursor_jntestit.GetString("COLLEGAMEN");
                mcintestit.row.DATAFINE = Cursor_jntestit.GetDate("DATAFINE");
                mcintestit.row.NUMPROG1 = Cursor_jntestit.GetString("NUMPROG1");
                mcintestit.row.NUMPROG2 = Cursor_jntestit.GetString("NUMPROG2");
                mcintestit.row.IDBASE = Cursor_jntestit.GetString("IDBASE");
                mcintestit.row.UCODE = Cursor_jntestit.GetString("UCODE");
                mcintestit.row.ABBINATO = Cursor_jntestit.GetDouble("ABBINATO");
                mcintestit.row.PRGIMPTITE = Cursor_jntestit.GetDouble("PRGIMPTITE");
                mcintestit.row.NUMIMP = Cursor_jntestit.GetDateTime("NUMIMP");
                mcintestit.row.NOAGE = Cursor_jntestit.GetString("NOAGE");
                Cursor_jntestit.Next();
              }
              m_cConnectivityError = Cursor_jntestit.ErrorMessage();
              Cursor_jntestit.Close();
              mcintestit.GoTop();
              /* If aui */
              if (aui) {
                // * --- Fill memory cursor mcintestit on intestit
                mcintestit.GoBottom();
                m_cServer = m_Ctx.GetServer("intestit");
                m_cPhName = m_Ctx.GetPhName("intestit");
                if (Cursor_intestit!=null)
                  Cursor_intestit.Close();
                Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwintestbo.CODINTER,"?",0,0,m_cServer, m_oParameters),m_cServer,rwintestbo.CODINTER)+"  and  (STATOREG <> '2' or  STATOREG <> '3')  and  NOAGE<>'S' "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                {
                  final CPResultSet m_TheCursor = Cursor_intestit;
                  Cursor_intestit.ActionOnClose(new Runnable() {
                    public void run() {
                      if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                        com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                        if ( ! (CPLib.IsNull(info))) {
                          info.log("Routine arrt_stprappo_all: query on intestit returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                        }
                      }
                    }
                    });
                }
                while ( ! (Cursor_intestit.Eof())) {
                  mcintestit.AppendBlank();
                  mcintestit.row.CODCLI = Cursor_intestit.GetString("CODCLI");
                  mcintestit.row.RAPPORTO = Cursor_intestit.GetString("RAPPORTO");
                  mcintestit.row.CODINTER = Cursor_intestit.GetString("CODINTER");
                  mcintestit.row.DESCINTER = Cursor_intestit.GetString("DESCINTER");
                  mcintestit.row.DATAINI = Cursor_intestit.GetDate("DATAINI");
                  mcintestit.row.TIPORAP = Cursor_intestit.GetString("TIPORAP");
                  mcintestit.row.TIPOPERS = Cursor_intestit.GetString("TIPOPERS");
                  mcintestit.row.STATOREG = Cursor_intestit.GetString("STATOREG");
                  mcintestit.row.OPERAZMOD = Cursor_intestit.GetString("OPERAZMOD");
                  mcintestit.row.DATARETT = Cursor_intestit.GetDate("DATARETT");
                  mcintestit.row.IDEREG = Cursor_intestit.GetString("IDEREG");
                  mcintestit.row.COLLEGAMEN = Cursor_intestit.GetString("COLLEGAMEN");
                  mcintestit.row.DATAFINE = Cursor_intestit.GetDate("DATAFINE");
                  mcintestit.row.NUMPROG1 = Cursor_intestit.GetString("NUMPROG1");
                  mcintestit.row.NUMPROG2 = Cursor_intestit.GetString("NUMPROG2");
                  mcintestit.row.IDBASE = Cursor_intestit.GetString("IDBASE");
                  mcintestit.row.UCODE = Cursor_intestit.GetString("UCODE");
                  mcintestit.row.ABBINATO = Cursor_intestit.GetDouble("ABBINATO");
                  mcintestit.row.PRGIMPTITE = Cursor_intestit.GetDouble("PRGIMPTITE");
                  mcintestit.row.NUMIMP = Cursor_intestit.GetDateTime("NUMIMP");
                  mcintestit.row.NOAGE = Cursor_intestit.GetString("NOAGE");
                  Cursor_intestit.Next();
                }
                m_cConnectivityError = Cursor_intestit.ErrorMessage();
                Cursor_intestit.Close();
                mcintestit.GoTop();
              } // End If
              /* ElseIf fonte='W' */
            } else if (CPLib.eqr(fonte,"W")) {
              // * --- Fill memory cursor mcintestit on wntestit
              mcintestit.Zap();
              m_cServer = m_Ctx.GetServer("wntestit");
              m_cPhName = m_Ctx.GetPhName("wntestit");
              if (Cursor_wntestit!=null)
                Cursor_wntestit.Close();
              Cursor_wntestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwintestbo.CODINTER,"?",0,0,m_cServer, m_oParameters),m_cServer,rwintestbo.CODINTER)+" "+")"+(m_Ctx.IsSharedTemp("wntestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              {
                final CPResultSet m_TheCursor = Cursor_wntestit;
                Cursor_wntestit.ActionOnClose(new Runnable() {
                  public void run() {
                    if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                      com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                      if ( ! (CPLib.IsNull(info))) {
                        info.log("Routine arrt_stprappo_all: query on wntestit returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                      }
                    }
                  }
                  });
              }
              while ( ! (Cursor_wntestit.Eof())) {
                mcintestit.AppendBlank();
                mcintestit.row.CODCLI = Cursor_wntestit.GetString("CODCLI");
                mcintestit.row.RAPPORTO = Cursor_wntestit.GetString("RAPPORTO");
                mcintestit.row.CODINTER = Cursor_wntestit.GetString("CODINTER");
                mcintestit.row.DESCINTER = Cursor_wntestit.GetString("DESCINTER");
                mcintestit.row.DATAINI = Cursor_wntestit.GetDate("DATAINI");
                mcintestit.row.TIPORAP = Cursor_wntestit.GetString("TIPORAP");
                mcintestit.row.TIPOPERS = Cursor_wntestit.GetString("TIPOPERS");
                mcintestit.row.STATOREG = Cursor_wntestit.GetString("STATOREG");
                mcintestit.row.OPERAZMOD = Cursor_wntestit.GetString("OPERAZMOD");
                mcintestit.row.DATARETT = Cursor_wntestit.GetDate("DATARETT");
                mcintestit.row.IDEREG = Cursor_wntestit.GetString("IDEREG");
                mcintestit.row.COLLEGAMEN = Cursor_wntestit.GetString("COLLEGAMEN");
                mcintestit.row.DATAFINE = Cursor_wntestit.GetDate("DATAFINE");
                mcintestit.row.NUMPROG1 = Cursor_wntestit.GetString("NUMPROG1");
                mcintestit.row.NUMPROG2 = Cursor_wntestit.GetString("NUMPROG2");
                mcintestit.row.IDBASE = Cursor_wntestit.GetString("IDBASE");
                mcintestit.row.UCODE = Cursor_wntestit.GetString("UCODE");
                mcintestit.row.ABBINATO = Cursor_wntestit.GetDouble("ABBINATO");
                mcintestit.row.PRGIMPTITE = Cursor_wntestit.GetDouble("PRGIMPTITE");
                mcintestit.row.NUMIMP = Cursor_wntestit.GetDateTime("NUMIMP");
                mcintestit.row.NOAGE = Cursor_wntestit.GetString("NOAGE");
                Cursor_wntestit.Next();
              }
              m_cConnectivityError = Cursor_wntestit.ErrorMessage();
              Cursor_wntestit.Close();
              mcintestit.GoTop();
            } // End If
            for (MemoryCursorRow_intestit rwintestit : mcintestit._iterable_()) {
              /* dataini := arfn_fdate(rwintestit.DATAINI) */
              dataini = arfn_fdateR.Make(m_Ctx,this).Run(rwintestit.DATAINI);
              /* datafin := arfn_fdate(rwintestit.DATAFINE) */
              datafin = arfn_fdateR.Make(m_Ctx,this).Run(rwintestit.DATAFINE);
              /* _ragsoc := '' */
              _ragsoc = "";
              /* cf := '' */
              cf = "";
              // * --- Read from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              m_cSql = "";
              m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwintestit.CODINTER,"C",16,0,m_cServer),m_cServer,rwintestit.CODINTER);
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
                  Error l_oErrorFault = new Error("Read on personbo into routine arrt_stprappo_all returns two or more records. This item should return only a record.");
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
              /* row := sheet.createRow(riga) // riga del foglio */
              row = sheet.createRow(riga);
              /* row.setRowStyle(stylebody) // riga del foglio */
              row.setRowStyle(stylebody);
              /* cell := row.createCell(0) // cella */
              cell = row.createCell(0);
              /* cell.setCellValue(rapporto) // cella */
              cell.setCellValue(rapporto);
              /* cell := row.createCell(1) // cella */
              cell = row.createCell(1);
              /* cell.setCellValue(descrap) // cella */
              cell.setCellValue(descrap);
              /* cell := row.createCell(2) // cella */
              cell = row.createCell(2);
              /* cell.setCellValue(cf) // cella */
              cell.setCellValue(cf);
              /* cell := row.createCell(3) // cella */
              cell = row.createCell(3);
              /* cell.setCellValue(_ragsoc) // cella */
              cell.setCellValue(_ragsoc);
              /* cell := row.createCell(4) // cella */
              cell = row.createCell(4);
              /* cell.setCellValue(_dataini) // cella */
              cell.setCellValue(_dataini);
              /* cell := row.createCell(5) // cella */
              cell = row.createCell(5);
              /* cell.setCellValue(_datafin) // cella */
              cell.setCellValue(_datafin);
              /* cell := row.createCell(6) // cella */
              cell = row.createCell(6);
              /* cell.setCellValue(tiprap) // cella */
              cell.setCellValue(tiprap);
              /* cell := row.createCell(7) // cella */
              cell = row.createCell(7);
              /* cell.setCellValue(valuta) // cella */
              cell.setCellValue(valuta);
              /* cell := row.createCell(8) // cella */
              cell = row.createCell(8);
              /* cell.setCellValue("T") // cella */
              cell.setCellValue("T");
              /* cell := row.createCell(9) // cella */
              cell = row.createCell(9);
              /* cell.setCellValue(_scopo) // cella */
              cell.setCellValue(_scopo);
              /* cell := row.createCell(10) // cella */
              cell = row.createCell(10);
              /* cell.setCellValue(_natura) // cella */
              cell.setCellValue(_natura);
              /* cell := row.createCell(11) // cella */
              cell = row.createCell(11);
              /* cell.setCellValue(_datprof) // cella */
              cell.setCellValue(_datprof);
              /* cell := row.createCell(12) // cella */
              cell = row.createCell(12);
              /* cell.setCellValue(_risglob) // cella */
              cell.setCellValue(_risglob);
              /* cell := row.createCell(13) // cella */
              cell = row.createCell(13);
              /* cell.setCellValue(_datrevprof) // cella */
              cell.setCellValue(_datrevprof);
              riga = riga + 1;
            }
          } // End If
        }
        /* If flgdel */
        if (flgdel) {
          /* If fonte='D' */
          if (CPLib.eqr(fonte,"D")) {
            // * --- Fill memory cursor mcdelegabo on delegabo
            mcdelegabo.Zap();
            m_cServer = m_Ctx.GetServer("delegabo");
            m_cPhName = m_Ctx.GetPhName("delegabo");
            if (Cursor_delegabo!=null)
              Cursor_delegabo.Close();
            Cursor_delegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwqbe_rapporti_xls.RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,rwqbe_rapporti_xls.RAPPORTO)+"  and  (STATOREG <> '2'  or  STATOREG <> '3') "+")"+(m_Ctx.IsSharedTemp("delegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            {
              final CPResultSet m_TheCursor = Cursor_delegabo;
              Cursor_delegabo.ActionOnClose(new Runnable() {
                public void run() {
                  if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                    com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                    if ( ! (CPLib.IsNull(info))) {
                      info.log("Routine arrt_stprappo_all: query on delegabo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                    }
                  }
                }
                });
            }
            while ( ! (Cursor_delegabo.Eof())) {
              mcdelegabo.AppendBlank();
              mcdelegabo.row.RAPPORTO = Cursor_delegabo.GetString("RAPPORTO");
              mcdelegabo.row.CPROWNUM = Cursor_delegabo.GetDouble("CPROWNUM");
              mcdelegabo.row.CODINTER = Cursor_delegabo.GetString("CODINTER");
              mcdelegabo.row.DESCINTER = Cursor_delegabo.GetString("DESCINTER");
              mcdelegabo.row.DATAINI = Cursor_delegabo.GetDate("DATAINI");
              mcdelegabo.row.TIPORAP = Cursor_delegabo.GetString("TIPORAP");
              mcdelegabo.row.TIPOPERS = Cursor_delegabo.GetString("TIPOPERS");
              mcdelegabo.row.STATOREG = Cursor_delegabo.GetString("STATOREG");
              mcdelegabo.row.OPERAZMOD = Cursor_delegabo.GetString("OPERAZMOD");
              mcdelegabo.row.DATARETT = Cursor_delegabo.GetDate("DATARETT");
              mcdelegabo.row.IDEREG = Cursor_delegabo.GetString("IDEREG");
              mcdelegabo.row.COLLEGAMEN = Cursor_delegabo.GetString("COLLEGAMEN");
              mcdelegabo.row.DATAFINE = Cursor_delegabo.GetDate("DATAFINE");
              mcdelegabo.row.NUMPROG1 = Cursor_delegabo.GetString("NUMPROG1");
              mcdelegabo.row.NUMPROG2 = Cursor_delegabo.GetString("NUMPROG2");
              mcdelegabo.row.IDBASE = Cursor_delegabo.GetString("IDBASE");
              mcdelegabo.row.UCODE = Cursor_delegabo.GetString("UCODE");
              mcdelegabo.row.ABBINATO = Cursor_delegabo.GetDouble("ABBINATO");
              mcdelegabo.row.NOAGE = Cursor_delegabo.GetString("NOAGE");
              mcdelegabo.row.NUMIMP = Cursor_delegabo.GetDateTime("NUMIMP");
              Cursor_delegabo.Next();
            }
            m_cConnectivityError = Cursor_delegabo.ErrorMessage();
            Cursor_delegabo.Close();
            mcdelegabo.GoTop();
            /* ElseIf fonte='P' */
          } else if (CPLib.eqr(fonte,"P")) {
            // * --- Fill memory cursor mcdelegabo on xelegabo
            mcdelegabo.Zap();
            m_cServer = m_Ctx.GetServer("xelegabo");
            m_cPhName = m_Ctx.GetPhName("xelegabo");
            if (Cursor_xelegabo!=null)
              Cursor_xelegabo.Close();
            Cursor_xelegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwqbe_rapporti_xls.RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,rwqbe_rapporti_xls.RAPPORTO)+" "+")"+(m_Ctx.IsSharedTemp("xelegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            {
              final CPResultSet m_TheCursor = Cursor_xelegabo;
              Cursor_xelegabo.ActionOnClose(new Runnable() {
                public void run() {
                  if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                    com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                    if ( ! (CPLib.IsNull(info))) {
                      info.log("Routine arrt_stprappo_all: query on xelegabo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                    }
                  }
                }
                });
            }
            while ( ! (Cursor_xelegabo.Eof())) {
              mcdelegabo.AppendBlank();
              mcdelegabo.row.RAPPORTO = Cursor_xelegabo.GetString("RAPPORTO");
              mcdelegabo.row.CPROWNUM = Cursor_xelegabo.GetDouble("CPROWNUM");
              mcdelegabo.row.CODINTER = Cursor_xelegabo.GetString("CODINTER");
              mcdelegabo.row.DESCINTER = Cursor_xelegabo.GetString("DESCINTER");
              mcdelegabo.row.DATAINI = Cursor_xelegabo.GetDate("DATAINI");
              mcdelegabo.row.TIPORAP = Cursor_xelegabo.GetString("TIPORAP");
              mcdelegabo.row.TIPOPERS = Cursor_xelegabo.GetString("TIPOPERS");
              mcdelegabo.row.STATOREG = Cursor_xelegabo.GetString("STATOREG");
              mcdelegabo.row.OPERAZMOD = Cursor_xelegabo.GetString("OPERAZMOD");
              mcdelegabo.row.DATARETT = Cursor_xelegabo.GetDate("DATARETT");
              mcdelegabo.row.IDEREG = Cursor_xelegabo.GetString("IDEREG");
              mcdelegabo.row.COLLEGAMEN = Cursor_xelegabo.GetString("COLLEGAMEN");
              mcdelegabo.row.DATAFINE = Cursor_xelegabo.GetDate("DATAFINE");
              mcdelegabo.row.NUMPROG1 = Cursor_xelegabo.GetString("NUMPROG1");
              mcdelegabo.row.NUMPROG2 = Cursor_xelegabo.GetString("NUMPROG2");
              mcdelegabo.row.IDBASE = Cursor_xelegabo.GetString("IDBASE");
              mcdelegabo.row.UCODE = Cursor_xelegabo.GetString("UCODE");
              mcdelegabo.row.ABBINATO = Cursor_xelegabo.GetDouble("ABBINATO");
              mcdelegabo.row.NOAGE = Cursor_xelegabo.GetString("NOAGE");
              mcdelegabo.row.NUMIMP = Cursor_xelegabo.GetDateTime("NUMIMP");
              Cursor_xelegabo.Next();
            }
            m_cConnectivityError = Cursor_xelegabo.ErrorMessage();
            Cursor_xelegabo.Close();
            mcdelegabo.GoTop();
            /* ElseIf fonte='J' */
          } else if (CPLib.eqr(fonte,"J")) {
            // * --- Fill memory cursor mcdelegabo on jelegabo
            mcdelegabo.Zap();
            m_cServer = m_Ctx.GetServer("jelegabo");
            m_cPhName = m_Ctx.GetPhName("jelegabo");
            if (Cursor_jelegabo!=null)
              Cursor_jelegabo.Close();
            Cursor_jelegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwqbe_rapporti_xls.RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,rwqbe_rapporti_xls.RAPPORTO)+" "+")"+(m_Ctx.IsSharedTemp("jelegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            {
              final CPResultSet m_TheCursor = Cursor_jelegabo;
              Cursor_jelegabo.ActionOnClose(new Runnable() {
                public void run() {
                  if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                    com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                    if ( ! (CPLib.IsNull(info))) {
                      info.log("Routine arrt_stprappo_all: query on jelegabo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                    }
                  }
                }
                });
            }
            while ( ! (Cursor_jelegabo.Eof())) {
              mcdelegabo.AppendBlank();
              mcdelegabo.row.RAPPORTO = Cursor_jelegabo.GetString("RAPPORTO");
              mcdelegabo.row.CPROWNUM = Cursor_jelegabo.GetDouble("CPROWNUM");
              mcdelegabo.row.CODINTER = Cursor_jelegabo.GetString("CODINTER");
              mcdelegabo.row.DESCINTER = Cursor_jelegabo.GetString("DESCINTER");
              mcdelegabo.row.DATAINI = Cursor_jelegabo.GetDate("DATAINI");
              mcdelegabo.row.TIPORAP = Cursor_jelegabo.GetString("TIPORAP");
              mcdelegabo.row.TIPOPERS = Cursor_jelegabo.GetString("TIPOPERS");
              mcdelegabo.row.STATOREG = Cursor_jelegabo.GetString("STATOREG");
              mcdelegabo.row.OPERAZMOD = Cursor_jelegabo.GetString("OPERAZMOD");
              mcdelegabo.row.DATARETT = Cursor_jelegabo.GetDate("DATARETT");
              mcdelegabo.row.IDEREG = Cursor_jelegabo.GetString("IDEREG");
              mcdelegabo.row.COLLEGAMEN = Cursor_jelegabo.GetString("COLLEGAMEN");
              mcdelegabo.row.DATAFINE = Cursor_jelegabo.GetDate("DATAFINE");
              mcdelegabo.row.NUMPROG1 = Cursor_jelegabo.GetString("NUMPROG1");
              mcdelegabo.row.NUMPROG2 = Cursor_jelegabo.GetString("NUMPROG2");
              mcdelegabo.row.IDBASE = Cursor_jelegabo.GetString("IDBASE");
              mcdelegabo.row.UCODE = Cursor_jelegabo.GetString("UCODE");
              mcdelegabo.row.ABBINATO = Cursor_jelegabo.GetDouble("ABBINATO");
              mcdelegabo.row.NOAGE = Cursor_jelegabo.GetString("NOAGE");
              mcdelegabo.row.NUMIMP = Cursor_jelegabo.GetDateTime("NUMIMP");
              Cursor_jelegabo.Next();
            }
            m_cConnectivityError = Cursor_jelegabo.ErrorMessage();
            Cursor_jelegabo.Close();
            mcdelegabo.GoTop();
            /* ElseIf fonte='W' */
          } else if (CPLib.eqr(fonte,"W")) {
            // * --- Fill memory cursor mcdelegabo on welegabo
            mcdelegabo.Zap();
            m_cServer = m_Ctx.GetServer("welegabo");
            m_cPhName = m_Ctx.GetPhName("welegabo");
            if (Cursor_welegabo!=null)
              Cursor_welegabo.Close();
            Cursor_welegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwqbe_rapporti_xls.RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,rwqbe_rapporti_xls.RAPPORTO)+" "+")"+(m_Ctx.IsSharedTemp("welegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            {
              final CPResultSet m_TheCursor = Cursor_welegabo;
              Cursor_welegabo.ActionOnClose(new Runnable() {
                public void run() {
                  if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                    com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                    if ( ! (CPLib.IsNull(info))) {
                      info.log("Routine arrt_stprappo_all: query on welegabo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                    }
                  }
                }
                });
            }
            while ( ! (Cursor_welegabo.Eof())) {
              mcdelegabo.AppendBlank();
              mcdelegabo.row.RAPPORTO = Cursor_welegabo.GetString("RAPPORTO");
              mcdelegabo.row.CPROWNUM = Cursor_welegabo.GetDouble("CPROWNUM");
              mcdelegabo.row.CODINTER = Cursor_welegabo.GetString("CODINTER");
              mcdelegabo.row.DESCINTER = Cursor_welegabo.GetString("DESCINTER");
              mcdelegabo.row.DATAINI = Cursor_welegabo.GetDate("DATAINI");
              mcdelegabo.row.TIPORAP = Cursor_welegabo.GetString("TIPORAP");
              mcdelegabo.row.TIPOPERS = Cursor_welegabo.GetString("TIPOPERS");
              mcdelegabo.row.STATOREG = Cursor_welegabo.GetString("STATOREG");
              mcdelegabo.row.OPERAZMOD = Cursor_welegabo.GetString("OPERAZMOD");
              mcdelegabo.row.DATARETT = Cursor_welegabo.GetDate("DATARETT");
              mcdelegabo.row.IDEREG = Cursor_welegabo.GetString("IDEREG");
              mcdelegabo.row.COLLEGAMEN = Cursor_welegabo.GetString("COLLEGAMEN");
              mcdelegabo.row.DATAFINE = Cursor_welegabo.GetDate("DATAFINE");
              mcdelegabo.row.NUMPROG1 = Cursor_welegabo.GetString("NUMPROG1");
              mcdelegabo.row.NUMPROG2 = Cursor_welegabo.GetString("NUMPROG2");
              mcdelegabo.row.IDBASE = Cursor_welegabo.GetString("IDBASE");
              mcdelegabo.row.UCODE = Cursor_welegabo.GetString("UCODE");
              mcdelegabo.row.ABBINATO = Cursor_welegabo.GetDouble("ABBINATO");
              mcdelegabo.row.NOAGE = Cursor_welegabo.GetString("NOAGE");
              mcdelegabo.row.NUMIMP = Cursor_welegabo.GetDateTime("NUMIMP");
              Cursor_welegabo.Next();
            }
            m_cConnectivityError = Cursor_welegabo.ErrorMessage();
            Cursor_welegabo.Close();
            mcdelegabo.GoTop();
          } // End If
          for (MemoryCursorRow_delegabo rwdelegabo : mcdelegabo._iterable_()) {
            /* connes := mcdelegabo.CODINTER */
            connes = mcdelegabo.row.CODINTER;
            /* dataini := arfn_fdate(mcdelegabo.DATAINI) */
            dataini = arfn_fdateR.Make(m_Ctx,this).Run(mcdelegabo.row.DATAINI);
            /* datafin := arfn_fdate(mcdelegabo.DATAFINE) */
            datafin = arfn_fdateR.Make(m_Ctx,this).Run(mcdelegabo.row.DATAFINE);
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
                Error l_oErrorFault = new Error("Read on personbo into routine arrt_stprappo_all returns two or more records. This item should return only a record.");
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
            /* row := sheet.createRow(riga) // riga del foglio */
            row = sheet.createRow(riga);
            /* row.setRowStyle(stylebody) // riga del foglio */
            row.setRowStyle(stylebody);
            /* cell := row.createCell(0) // cella */
            cell = row.createCell(0);
            /* cell.setCellValue(rapporto) // cella */
            cell.setCellValue(rapporto);
            /* cell := row.createCell(1) // cella */
            cell = row.createCell(1);
            /* cell.setCellValue(descrap) // cella */
            cell.setCellValue(descrap);
            /* cell := row.createCell(2) // cella */
            cell = row.createCell(2);
            /* cell.setCellValue(cf) // cella */
            cell.setCellValue(cf);
            /* cell := row.createCell(3) // cella */
            cell = row.createCell(3);
            /* cell.setCellValue(_ragsoc) // cella */
            cell.setCellValue(_ragsoc);
            /* cell := row.createCell(4) // cella */
            cell = row.createCell(4);
            /* cell.setCellValue(_dataini) // cella */
            cell.setCellValue(_dataini);
            /* cell := row.createCell(5) // cella */
            cell = row.createCell(5);
            /* cell.setCellValue(_datafin) // cella */
            cell.setCellValue(_datafin);
            /* cell := row.createCell(6) // cella */
            cell = row.createCell(6);
            /* cell.setCellValue(tiprap) // cella */
            cell.setCellValue(tiprap);
            /* cell := row.createCell(7) // cella */
            cell = row.createCell(7);
            /* cell.setCellValue(valuta) // cella */
            cell.setCellValue(valuta);
            /* cell := row.createCell(8) // cella */
            cell = row.createCell(8);
            /* cell.setCellValue("D") // cella */
            cell.setCellValue("D");
            /* cell := row.createCell(9) // cella */
            cell = row.createCell(9);
            /* cell.setCellValue(_scopo) // cella */
            cell.setCellValue(_scopo);
            /* cell := row.createCell(10) // cella */
            cell = row.createCell(10);
            /* cell.setCellValue(_natura) // cella */
            cell.setCellValue(_natura);
            /* cell := row.createCell(11) // cella */
            cell = row.createCell(11);
            /* cell.setCellValue(_datprof) // cella */
            cell.setCellValue(_datprof);
            /* cell := row.createCell(12) // cella */
            cell = row.createCell(12);
            /* cell.setCellValue(_risglob) // cella */
            cell.setCellValue(_risglob);
            /* cell := row.createCell(13) // cella */
            cell = row.createCell(13);
            /* cell.setCellValue(_datrevprof) // cella */
            cell.setCellValue(_datrevprof);
            riga = riga + 1;
          }
        } // End If
      }
      for (int col = 0; CPLib.ne(col,maxcell+1); col = col + (1)) {
        /* sheet.autoSizeColumn(col) // Sheet file1 */
        sheet.autoSizeColumn(col);
      }
      /* Workbook.write(excellFile) // Workbook file */
      Workbook.write(excellFile);
      /* excellFile.flush() // FileOutputStream file */
      excellFile.flush();
      /* excellFile.close() // FileOutputStream file */
      excellFile.close();
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
        if (Cursor_qbe_rapporti_xls_prov!=null)
          Cursor_qbe_rapporti_xls_prov.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_rapporti_xls_ae!=null)
          Cursor_qbe_rapporti_xls_ae.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_rapporti_xls_sto!=null)
          Cursor_qbe_rapporti_xls_sto.Close();
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
        if (Cursor_xntestbo!=null)
          Cursor_xntestbo.Close();
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
        if (Cursor_wntestbo!=null)
          Cursor_wntestbo.Close();
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
        if (Cursor_xntestit!=null)
          Cursor_xntestit.Close();
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
        if (Cursor_wntestit!=null)
          Cursor_wntestit.Close();
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
      try {
        if (Cursor_xelegabo!=null)
          Cursor_xelegabo.Close();
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
      try {
        if (Cursor_welegabo!=null)
          Cursor_welegabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_3() throws Exception {
    CPResultSet Cursor_qbe_rapporti_xls_dett=null;
    CPResultSet Cursor_qbe_rapporti_xls_dett_prov=null;
    CPResultSet Cursor_qbe_rapporti_xls_dett_ae=null;
    CPResultSet Cursor_qbe_rapporti_xls_dett_sto=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_xntestbo=null;
    CPResultSet Cursor_jntestbo=null;
    CPResultSet Cursor_wntestbo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_intestit=null;
    CPResultSet Cursor_xntestit=null;
    CPResultSet Cursor_jntestit=null;
    CPResultSet Cursor_wntestit=null;
    CPResultSet Cursor_delegabo=null;
    CPResultSet Cursor_xelegabo=null;
    CPResultSet Cursor_jelegabo=null;
    CPResultSet Cursor_welegabo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Excel Con dettaglio anagrafico */
      /* file Char(1) */
      String file;
      file = CPLib.Space(1);
      /* nomeesito Char(50) := 'rapporti'+DateTimeToChar(DateTime())+".xlsx" */
      String nomeesito;
      nomeesito = "rapporti"+CPLib.DateTimeToChar(CPLib.DateTime())+".xlsx";
      /* _crap Bool := False // Esite intestatario */
      boolean _crap;
      _crap = false;
      /* _notit Bool := True // Mancata presenza di titolari effettivi collegati all'intestatario esaminato */
      boolean _notit;
      _notit = true;
      /* mcqbe_rapporti_xls_dett MemoryCursor(qbe_rapporti_xls_dett.vqr) // mc qbe_rapporti_xls_dett */
      MemoryCursor_qbe_rapporti_xls_dett_vqr mcqbe_rapporti_xls_dett;
      mcqbe_rapporti_xls_dett = new MemoryCursor_qbe_rapporti_xls_dett_vqr();
      /* mcintestbo MemoryCursor(intestbo) // mc intestbo */
      MemoryCursor_intestbo mcintestbo;
      mcintestbo = new MemoryCursor_intestbo();
      /* mcintestit MemoryCursor(intestit) // mc intestit */
      MemoryCursor_intestit mcintestit;
      mcintestit = new MemoryCursor_intestit();
      /* mcdelegabo MemoryCursor(delegabo) // mc delegabo */
      MemoryCursor_delegabo mcdelegabo;
      mcdelegabo = new MemoryCursor_delegabo();
      /* excellFile Object(FileOutputStream) // FileOutputStream file */
      FileOutputStream excellFile;
      excellFile = null;
      /* Workbook Object(Workbook) // Workbook file */
      Workbook Workbook;
      Workbook = null;
      /* sheet Object(Sheet) // Sheet file1 */
      Sheet sheet;
      sheet = null;
      /* font Object(Font) // font da appicare allo stile */
      Font font;
      font = null;
      /* fontbody Object(Font) // font da appicare allo stile */
      Font fontbody;
      fontbody = null;
      /* maxcell Numeric(0, 0) := 42 // numero di colonne */
      double maxcell;
      maxcell = CPLib.Round(42,0);
      /* cell Object(Cell) // cella */
      Cell cell;
      cell = null;
      /* row Object(Row) // riga del foglio */
      Row row;
      row = null;
      /* style Object(CellStyle) // stile della cella */
      CellStyle style;
      style = null;
      /* stylebody Object(CellStyle) // stile della cella */
      CellStyle stylebody;
      stylebody = null;
      /* stylebodydate Object(CellStyle) // stile della cella */
      CellStyle stylebodydate;
      stylebodydate = null;
      /* nomefilexls := LRTrim(gPathApp)+"/output/"+LRTrim(gAzienda)+"/"+nomeesito */
      nomefilexls = CPLib.LRTrim(gPathApp)+"/output/"+CPLib.LRTrim(gAzienda)+"/"+nomeesito;
      /* Workbook := WorkbookFactory.create(1=1) // Workbook file */
      Workbook = WorkbookFactory.create(CPLib.eqr(1,1));
      /* excellFile := new FileOutputStream(nomefilexls) // FileOutputStream file */
      excellFile = new FileOutputStream(nomefilexls);
      /* sheet := Workbook.createSheet("Elenco Rapporti") // Sheet file1 */
      sheet = Workbook.createSheet("Elenco Rapporti");
      /* font := Workbook.createFont() // font da appicare allo stile */
      font = Workbook.createFont();
      /* font.setFontName("Arial") // font da appicare allo stile */
      font.setFontName("Arial");
      /* font.setBold(true) // font da appicare allo stile */
      font.setBold(true);
      /* font.setFontHeightInPoints(FontHeight) // font da appicare allo stile */
      font.setFontHeightInPoints(FontHeight);
      /* style := Workbook.createCellStyle() // stile della cella */
      style = Workbook.createCellStyle();
      /* style.setFont(font) // stile della cella */
      style.setFont(font);
      /* row := sheet.createRow(0) // riga del foglio */
      row = sheet.createRow(0);
      /* row.setRowStyle(style) // riga del foglio */
      row.setRowStyle(style);
      /* cell := row.createCell(0) // cella */
      cell = row.createCell(0);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("Codice Rapporto") // cella */
      cell.setCellValue("Codice Rapporto");
      /* cell := row.createCell(1) // cella */
      cell = row.createCell(1);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("Descrizione") // cella */
      cell.setCellValue("Descrizione");
      /* cell := row.createCell(2) // cella */
      cell = row.createCell(2);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("Tipo Rapporto") // cella */
      cell.setCellValue("Tipo Rapporto");
      /* cell := row.createCell(3) // cella */
      cell = row.createCell(3);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("Valuta") // cella */
      cell.setCellValue("Valuta");
      /* cell := row.createCell(4) // cella */
      cell = row.createCell(4);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("Customer ID") // cella */
      cell.setCellValue("Customer ID");
      /* cell := row.createCell(5) // cella */
      cell = row.createCell(5);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("Scopo Prestazione") // cella */
      cell.setCellValue("Scopo Prestazione");
      /* cell := row.createCell(6) // cella */
      cell = row.createCell(6);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("Natura Prestazione") // cella */
      cell.setCellValue("Natura Prestazione");
      /* cell := row.createCell(7) // cella */
      cell = row.createCell(7);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("Data Profilatura (Rapporto)") // cella */
      cell.setCellValue("Data Profilatura (Rapporto)");
      /* cell := row.createCell(8) // cella */
      cell = row.createCell(8);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("Rischio Globale (Rapporto)") // cella */
      cell.setCellValue("Rischio Globale (Rapporto)");
      /* cell := row.createCell(9) // cella */
      cell = row.createCell(9);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("Prossima Profilatura (Rapporto)") // cella */
      cell.setCellValue("Prossima Profilatura (Rapporto)");
      /* cell := row.createCell(10) // cella */
      cell = row.createCell(10);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("Codice Fiscale") // cella */
      cell.setCellValue("Codice Fiscale");
      /* cell := row.createCell(11) // cella */
      cell = row.createCell(11);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("Nominativo") // cella */
      cell.setCellValue("Nominativo");
      /* cell := row.createCell(12) // cella */
      cell = row.createCell(12);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("Paese Residenza") // cella */
      cell.setCellValue("Paese Residenza");
      /* cell := row.createCell(13) // cella */
      cell = row.createCell(13);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("Città Residenza") // cella */
      cell.setCellValue("Città Residenza");
      /* cell := row.createCell(14) // cella */
      cell = row.createCell(14);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("Domicilio") // cella */
      cell.setCellValue("Domicilio");
      /* cell := row.createCell(15) // cella */
      cell = row.createCell(15);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("CAP Residenza") // cella */
      cell.setCellValue("CAP Residenza");
      /* cell := row.createCell(16) // cella */
      cell = row.createCell(16);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("CAB Residenza") // cella */
      cell.setCellValue("CAB Residenza");
      /* cell := row.createCell(17) // cella */
      cell = row.createCell(17);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("Prov Residenza") // cella */
      cell.setCellValue("Prov Residenza");
      /* cell := row.createCell(18) // cella */
      cell = row.createCell(18);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("Luogo Nascita") // cella */
      cell.setCellValue("Luogo Nascita");
      /* cell := row.createCell(19) // cella */
      cell = row.createCell(19);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("Prov. Nascita") // cella */
      cell.setCellValue("Prov. Nascita");
      /* cell := row.createCell(20) // cella */
      cell = row.createCell(20);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("Data Nascita") // cella */
      cell.setCellValue("Data Nascita");
      /* cell := row.createCell(21) // cella */
      cell = row.createCell(21);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("Sesso") // cella */
      cell.setCellValue("Sesso");
      /* cell := row.createCell(22) // cella */
      cell = row.createCell(22);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("Tipo Documento") // cella */
      cell.setCellValue("Tipo Documento");
      /* cell := row.createCell(23) // cella */
      cell = row.createCell(23);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("N° Documento") // cella */
      cell.setCellValue("N° Documento");
      /* cell := row.createCell(24) // cella */
      cell = row.createCell(24);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("Data Rilascio") // cella */
      cell.setCellValue("Data Rilascio");
      /* cell := row.createCell(25) // cella */
      cell = row.createCell(25);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("Autorità Rilascio") // cella */
      cell.setCellValue("Autorità Rilascio");
      /* cell := row.createCell(26) // cella */
      cell = row.createCell(26);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("NDG Soggetto") // cella */
      cell.setCellValue("NDG Soggetto");
      /* cell := row.createCell(27) // cella */
      cell = row.createCell(27);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("S.A.E.") // cella */
      cell.setCellValue("S.A.E.");
      /* cell := row.createCell(28) // cella */
      cell = row.createCell(28);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("Descrizione S.A.E.") // cella */
      cell.setCellValue("Descrizione S.A.E.");
      /* cell := row.createCell(29) // cella */
      cell = row.createCell(29);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("R.A.E.") // cella */
      cell.setCellValue("R.A.E.");
      /* cell := row.createCell(30) // cella */
      cell = row.createCell(30);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("Descrizione R.A.E.") // cella */
      cell.setCellValue("Descrizione R.A.E.");
      /* cell := row.createCell(31) // cella */
      cell = row.createCell(31);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("ATECO") // cella */
      cell.setCellValue("ATECO");
      /* cell := row.createCell(32) // cella */
      cell = row.createCell(32);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("Descrizione ATECO") // cella */
      cell.setCellValue("Descrizione ATECO");
      /* cell := row.createCell(33) // cella */
      cell = row.createCell(33);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("Sett. Sintetico") // cella */
      cell.setCellValue("Sett. Sintetico");
      /* cell := row.createCell(34) // cella */
      cell = row.createCell(34);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("Descrizione Sett. Sintetico") // cella */
      cell.setCellValue("Descrizione Sett. Sintetico");
      /* cell := row.createCell(35) // cella */
      cell = row.createCell(35);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("Data Inizio") // cella */
      cell.setCellValue("Data Inizio");
      /* cell := row.createCell(36) // cella */
      cell = row.createCell(36);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("Data Fine") // cella */
      cell.setCellValue("Data Fine");
      /* cell := row.createCell(37) // cella */
      cell = row.createCell(37);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("Tipo Soggetto") // cella */
      cell.setCellValue("Tipo Soggetto");
      /* cell := row.createCell(38) // cella */
      cell = row.createCell(38);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("Cognome") // cella */
      cell.setCellValue("Cognome");
      /* cell := row.createCell(39) // cella */
      cell = row.createCell(39);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("Nome") // cella */
      cell.setCellValue("Nome");
      /* cell := row.createCell(40) // cella */
      cell = row.createCell(40);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("Data Profilatura (Soggetto)") // cella */
      cell.setCellValue("Data Profilatura (Soggetto)");
      /* cell := row.createCell(41) // cella */
      cell = row.createCell(41);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("Rischio Globale (Soggetto)") // cella */
      cell.setCellValue("Rischio Globale (Soggetto)");
      /* cell := row.createCell(42) // cella */
      cell = row.createCell(42);
      m_Ctx.SetGlobalObject("cell",cell);
      /* cell.setCellValue("Prossima Profilatura (Soggetto)") // cella */
      cell.setCellValue("Prossima Profilatura (Soggetto)");
      riga = 1;
      /* fontbody := Workbook.createFont() // font da appicare allo stile */
      fontbody = Workbook.createFont();
      /* fontbody.setFontName("Arial") // font da appicare allo stile */
      fontbody.setFontName("Arial");
      /* fontbody.setBold(false) // font da appicare allo stile */
      fontbody.setBold(false);
      /* fontbody.setFontHeightInPoints(FontHeight2) // font da appicare allo stile */
      fontbody.setFontHeightInPoints(FontHeight2);
      /* stylebody := Workbook.createCellStyle() // stile della cella */
      stylebody = Workbook.createCellStyle();
      /* stylebody.setFont(fontbody) // stile della cella */
      stylebody.setFont(fontbody);
      /* rapporto := '' */
      rapporto = "";
      /* If fonte='D' */
      if (CPLib.eqr(fonte,"D")) {
        // * --- Fill memory cursor mcqbe_rapporti_xls_dett on qbe_rapporti_xls_dett
        mcqbe_rapporti_xls_dett.Zap();
        SPBridge.HMCaller _h000001EB;
        _h000001EB = new SPBridge.HMCaller();
        _h000001EB.Set("m_cVQRList",m_cVQRList);
        _h000001EB.Set("daRappo",daRappo);
        _h000001EB.Set("aRappo",aRappo);
        _h000001EB.Set("coddip",coddip);
        _h000001EB.Set("DaData",DaData);
        _h000001EB.Set("AData",AData);
        _h000001EB.Set("DaSogg",DaSogg);
        _h000001EB.Set("ASogg",ASogg);
        _h000001EB.Set("tipo",tipo);
        _h000001EB.Set("pRISGLOB",pRISGLOB);
        _h000001EB.Set("pTIPOAG",pTIPOAG);
        if (Cursor_qbe_rapporti_xls_dett!=null)
          Cursor_qbe_rapporti_xls_dett.Close();
        Cursor_qbe_rapporti_xls_dett = new VQRHolder("qbe_rapporti_xls_dett",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000001EB,true).GetResultSet(m_Ctx);
        {
          final CPResultSet m_TheCursor = Cursor_qbe_rapporti_xls_dett;
          Cursor_qbe_rapporti_xls_dett.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arrt_stprappo_all: query on qbe_rapporti_xls_dett returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_qbe_rapporti_xls_dett.Eof())) {
          mcqbe_rapporti_xls_dett.AppendBlank();
          mcqbe_rapporti_xls_dett.row.RAPPORTO = Cursor_qbe_rapporti_xls_dett.GetString("RAPPORTO");
          mcqbe_rapporti_xls_dett.row.DESCRAP = Cursor_qbe_rapporti_xls_dett.GetString("DESCRAP");
          mcqbe_rapporti_xls_dett.row.TIPORAP = Cursor_qbe_rapporti_xls_dett.GetString("TIPORAP");
          mcqbe_rapporti_xls_dett.row.FLAGLIRE = Cursor_qbe_rapporti_xls_dett.GetString("FLAGLIRE");
          mcqbe_rapporti_xls_dett.row.VALUTA = Cursor_qbe_rapporti_xls_dett.GetString("VALUTA");
          mcqbe_rapporti_xls_dett.row.SPLITCODE = Cursor_qbe_rapporti_xls_dett.GetString("SPLITCODE");
          mcqbe_rapporti_xls_dett.row.SCOPO = Cursor_qbe_rapporti_xls_dett.GetString("SCOPO");
          mcqbe_rapporti_xls_dett.row.NATURA = Cursor_qbe_rapporti_xls_dett.GetString("NATURA");
          mcqbe_rapporti_xls_dett.row.DATAPROF = Cursor_qbe_rapporti_xls_dett.GetDate("DATAPROF");
          mcqbe_rapporti_xls_dett.row.RISGLOB = Cursor_qbe_rapporti_xls_dett.GetString("RISGLOB");
          mcqbe_rapporti_xls_dett.row.DATAREVPROF = Cursor_qbe_rapporti_xls_dett.GetDate("DATAREVPROF");
          mcqbe_rapporti_xls_dett.row.CODICELR = Cursor_qbe_rapporti_xls_dett.GetString("CODICELR");
          Cursor_qbe_rapporti_xls_dett.Next();
        }
        m_cConnectivityError = Cursor_qbe_rapporti_xls_dett.ErrorMessage();
        Cursor_qbe_rapporti_xls_dett.Close();
        mcqbe_rapporti_xls_dett.GoTop();
        /* ElseIf fonte='P' */
      } else if (CPLib.eqr(fonte,"P")) {
        // * --- Fill memory cursor mcqbe_rapporti_xls_dett on qbe_rapporti_xls_dett_prov
        mcqbe_rapporti_xls_dett.Zap();
        SPBridge.HMCaller _h000001EC;
        _h000001EC = new SPBridge.HMCaller();
        _h000001EC.Set("m_cVQRList",m_cVQRList);
        _h000001EC.Set("daRappo",daRappo);
        _h000001EC.Set("aRappo",aRappo);
        _h000001EC.Set("coddip",coddip);
        _h000001EC.Set("DaData",DaData);
        _h000001EC.Set("AData",AData);
        _h000001EC.Set("DaSogg",DaSogg);
        _h000001EC.Set("ASogg",ASogg);
        _h000001EC.Set("tipo",tipo);
        _h000001EC.Set("pRISGLOB",pRISGLOB);
        _h000001EC.Set("pTIPOAG",pTIPOAG);
        if (Cursor_qbe_rapporti_xls_dett_prov!=null)
          Cursor_qbe_rapporti_xls_dett_prov.Close();
        Cursor_qbe_rapporti_xls_dett_prov = new VQRHolder("qbe_rapporti_xls_dett_prov",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000001EC,true).GetResultSet(m_Ctx);
        {
          final CPResultSet m_TheCursor = Cursor_qbe_rapporti_xls_dett_prov;
          Cursor_qbe_rapporti_xls_dett_prov.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arrt_stprappo_all: query on qbe_rapporti_xls_dett_prov returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_qbe_rapporti_xls_dett_prov.Eof())) {
          mcqbe_rapporti_xls_dett.AppendBlank();
          mcqbe_rapporti_xls_dett.row.RAPPORTO = Cursor_qbe_rapporti_xls_dett_prov.GetString("RAPPORTO");
          mcqbe_rapporti_xls_dett.row.DESCRAP = Cursor_qbe_rapporti_xls_dett_prov.GetString("DESCRAP");
          mcqbe_rapporti_xls_dett.row.TIPORAP = Cursor_qbe_rapporti_xls_dett_prov.GetString("TIPORAP");
          mcqbe_rapporti_xls_dett.row.FLAGLIRE = Cursor_qbe_rapporti_xls_dett_prov.GetString("FLAGLIRE");
          mcqbe_rapporti_xls_dett.row.VALUTA = Cursor_qbe_rapporti_xls_dett_prov.GetString("VALUTA");
          mcqbe_rapporti_xls_dett.row.SPLITCODE = Cursor_qbe_rapporti_xls_dett_prov.GetString("SPLITCODE");
          mcqbe_rapporti_xls_dett.row.SCOPO = Cursor_qbe_rapporti_xls_dett_prov.GetString("SCOPO");
          mcqbe_rapporti_xls_dett.row.NATURA = Cursor_qbe_rapporti_xls_dett_prov.GetString("NATURA");
          mcqbe_rapporti_xls_dett.row.DATAPROF = Cursor_qbe_rapporti_xls_dett_prov.GetDate("DATAPROF");
          mcqbe_rapporti_xls_dett.row.RISGLOB = Cursor_qbe_rapporti_xls_dett_prov.GetString("RISGLOB");
          mcqbe_rapporti_xls_dett.row.DATAREVPROF = Cursor_qbe_rapporti_xls_dett_prov.GetDate("DATAREVPROF");
          mcqbe_rapporti_xls_dett.row.CODICELR = Cursor_qbe_rapporti_xls_dett_prov.GetString("CODICELR");
          Cursor_qbe_rapporti_xls_dett_prov.Next();
        }
        m_cConnectivityError = Cursor_qbe_rapporti_xls_dett_prov.ErrorMessage();
        Cursor_qbe_rapporti_xls_dett_prov.Close();
        mcqbe_rapporti_xls_dett.GoTop();
        /* ElseIf fonte='J' */
      } else if (CPLib.eqr(fonte,"J")) {
        // * --- Fill memory cursor mcqbe_rapporti_xls_dett on qbe_rapporti_xls_dett_ae
        mcqbe_rapporti_xls_dett.Zap();
        SPBridge.HMCaller _h000001ED;
        _h000001ED = new SPBridge.HMCaller();
        _h000001ED.Set("m_cVQRList",m_cVQRList);
        _h000001ED.Set("daRappo",daRappo);
        _h000001ED.Set("aRappo",aRappo);
        _h000001ED.Set("coddip",coddip);
        _h000001ED.Set("DaData",DaData);
        _h000001ED.Set("AData",AData);
        _h000001ED.Set("DaSogg",DaSogg);
        _h000001ED.Set("ASogg",ASogg);
        _h000001ED.Set("tipo",tipo);
        _h000001ED.Set("pRISGLOB",pRISGLOB);
        _h000001ED.Set("pTIPOAG",pTIPOAG);
        if (Cursor_qbe_rapporti_xls_dett_ae!=null)
          Cursor_qbe_rapporti_xls_dett_ae.Close();
        Cursor_qbe_rapporti_xls_dett_ae = new VQRHolder("qbe_rapporti_xls_dett_ae",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000001ED,true).GetResultSet(m_Ctx);
        {
          final CPResultSet m_TheCursor = Cursor_qbe_rapporti_xls_dett_ae;
          Cursor_qbe_rapporti_xls_dett_ae.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arrt_stprappo_all: query on qbe_rapporti_xls_dett_ae returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_qbe_rapporti_xls_dett_ae.Eof())) {
          mcqbe_rapporti_xls_dett.AppendBlank();
          mcqbe_rapporti_xls_dett.row.RAPPORTO = Cursor_qbe_rapporti_xls_dett_ae.GetString("RAPPORTO");
          mcqbe_rapporti_xls_dett.row.DESCRAP = Cursor_qbe_rapporti_xls_dett_ae.GetString("DESCRAP");
          mcqbe_rapporti_xls_dett.row.TIPORAP = Cursor_qbe_rapporti_xls_dett_ae.GetString("TIPORAP");
          mcqbe_rapporti_xls_dett.row.FLAGLIRE = Cursor_qbe_rapporti_xls_dett_ae.GetString("FLAGLIRE");
          mcqbe_rapporti_xls_dett.row.VALUTA = Cursor_qbe_rapporti_xls_dett_ae.GetString("VALUTA");
          mcqbe_rapporti_xls_dett.row.SPLITCODE = Cursor_qbe_rapporti_xls_dett_ae.GetString("SPLITCODE");
          mcqbe_rapporti_xls_dett.row.SCOPO = Cursor_qbe_rapporti_xls_dett_ae.GetString("SCOPO");
          mcqbe_rapporti_xls_dett.row.NATURA = Cursor_qbe_rapporti_xls_dett_ae.GetString("NATURA");
          mcqbe_rapporti_xls_dett.row.DATAPROF = Cursor_qbe_rapporti_xls_dett_ae.GetDate("DATAPROF");
          mcqbe_rapporti_xls_dett.row.RISGLOB = Cursor_qbe_rapporti_xls_dett_ae.GetString("RISGLOB");
          mcqbe_rapporti_xls_dett.row.DATAREVPROF = Cursor_qbe_rapporti_xls_dett_ae.GetDate("DATAREVPROF");
          mcqbe_rapporti_xls_dett.row.CODICELR = Cursor_qbe_rapporti_xls_dett_ae.GetString("CODICELR");
          Cursor_qbe_rapporti_xls_dett_ae.Next();
        }
        m_cConnectivityError = Cursor_qbe_rapporti_xls_dett_ae.ErrorMessage();
        Cursor_qbe_rapporti_xls_dett_ae.Close();
        mcqbe_rapporti_xls_dett.GoTop();
        /* ElseIf fonte='W' */
      } else if (CPLib.eqr(fonte,"W")) {
        // * --- Fill memory cursor mcqbe_rapporti_xls_dett on qbe_rapporti_xls_dett_sto
        mcqbe_rapporti_xls_dett.Zap();
        SPBridge.HMCaller _h000001EE;
        _h000001EE = new SPBridge.HMCaller();
        _h000001EE.Set("m_cVQRList",m_cVQRList);
        _h000001EE.Set("daRappo",daRappo);
        _h000001EE.Set("aRappo",aRappo);
        _h000001EE.Set("coddip",coddip);
        _h000001EE.Set("DaData",DaData);
        _h000001EE.Set("AData",AData);
        _h000001EE.Set("DaSogg",DaSogg);
        _h000001EE.Set("ASogg",ASogg);
        _h000001EE.Set("tipo",tipo);
        _h000001EE.Set("pRISGLOB",pRISGLOB);
        _h000001EE.Set("pTIPOAG",pTIPOAG);
        if (Cursor_qbe_rapporti_xls_dett_sto!=null)
          Cursor_qbe_rapporti_xls_dett_sto.Close();
        Cursor_qbe_rapporti_xls_dett_sto = new VQRHolder("qbe_rapporti_xls_dett_sto",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000001EE,true).GetResultSet(m_Ctx);
        {
          final CPResultSet m_TheCursor = Cursor_qbe_rapporti_xls_dett_sto;
          Cursor_qbe_rapporti_xls_dett_sto.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arrt_stprappo_all: query on qbe_rapporti_xls_dett_sto returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_qbe_rapporti_xls_dett_sto.Eof())) {
          mcqbe_rapporti_xls_dett.AppendBlank();
          mcqbe_rapporti_xls_dett.row.RAPPORTO = Cursor_qbe_rapporti_xls_dett_sto.GetString("RAPPORTO");
          mcqbe_rapporti_xls_dett.row.DESCRAP = Cursor_qbe_rapporti_xls_dett_sto.GetString("DESCRAP");
          mcqbe_rapporti_xls_dett.row.TIPORAP = Cursor_qbe_rapporti_xls_dett_sto.GetString("TIPORAP");
          mcqbe_rapporti_xls_dett.row.FLAGLIRE = Cursor_qbe_rapporti_xls_dett_sto.GetString("FLAGLIRE");
          mcqbe_rapporti_xls_dett.row.VALUTA = Cursor_qbe_rapporti_xls_dett_sto.GetString("VALUTA");
          mcqbe_rapporti_xls_dett.row.SPLITCODE = Cursor_qbe_rapporti_xls_dett_sto.GetString("SPLITCODE");
          mcqbe_rapporti_xls_dett.row.SCOPO = Cursor_qbe_rapporti_xls_dett_sto.GetString("SCOPO");
          mcqbe_rapporti_xls_dett.row.NATURA = Cursor_qbe_rapporti_xls_dett_sto.GetString("NATURA");
          mcqbe_rapporti_xls_dett.row.DATAPROF = Cursor_qbe_rapporti_xls_dett_sto.GetDate("DATAPROF");
          mcqbe_rapporti_xls_dett.row.RISGLOB = Cursor_qbe_rapporti_xls_dett_sto.GetString("RISGLOB");
          mcqbe_rapporti_xls_dett.row.DATAREVPROF = Cursor_qbe_rapporti_xls_dett_sto.GetDate("DATAREVPROF");
          mcqbe_rapporti_xls_dett.row.CODICELR = Cursor_qbe_rapporti_xls_dett_sto.GetString("CODICELR");
          Cursor_qbe_rapporti_xls_dett_sto.Next();
        }
        m_cConnectivityError = Cursor_qbe_rapporti_xls_dett_sto.ErrorMessage();
        Cursor_qbe_rapporti_xls_dett_sto.Close();
        mcqbe_rapporti_xls_dett.GoTop();
      } // End If
      for (MemoryCursorRow_qbe_rapporti_xls_dett_vqr rwqbe_rapporti_xls_dett : mcqbe_rapporti_xls_dett._iterable_()) {
        /* _notit := True */
        _notit = true;
        /* _crap := False // Esite il rapporto */
        _crap = false;
        /* gMsgImp := "Elaborazione Rapporto "+ rwqbe_rapporti_xls_dett.RAPPORTO // Messaggio Import */
        gMsgImp = "Elaborazione Rapporto "+rwqbe_rapporti_xls_dett.RAPPORTO;
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* rapporto := rwqbe_rapporti_xls_dett.RAPPORTO */
        rapporto = rwqbe_rapporti_xls_dett.RAPPORTO;
        /* descrap := rwqbe_rapporti_xls_dett.DESCRAP */
        descrap = rwqbe_rapporti_xls_dett.DESCRAP;
        /* tiprap := rwqbe_rapporti_xls_dett.TIPORAP */
        tiprap = rwqbe_rapporti_xls_dett.TIPORAP;
        /* valuta := rwqbe_rapporti_xls_dett.VALUTA */
        valuta = rwqbe_rapporti_xls_dett.VALUTA;
        /* _customerid := rwqbe_rapporti_xls_dett.SPLITCODE */
        _customerid = rwqbe_rapporti_xls_dett.SPLITCODE;
        /* _scopo := rwqbe_rapporti_xls_dett.SCOPO */
        _scopo = rwqbe_rapporti_xls_dett.SCOPO;
        /* _natura := rwqbe_rapporti_xls_dett.NATURA */
        _natura = rwqbe_rapporti_xls_dett.NATURA;
        /* _datprof := arfn_fdate(rwqbe_rapporti_xls_dett.DATAPROF) */
        _datprof = arfn_fdateR.Make(m_Ctx,this).Run(rwqbe_rapporti_xls_dett.DATAPROF);
        /* _datrevprof := arfn_fdate(rwqbe_rapporti_xls_dett.DATAREVPROF) */
        _datrevprof = arfn_fdateR.Make(m_Ctx,this).Run(rwqbe_rapporti_xls_dett.DATAREVPROF);
        /* _risglob := '' */
        _risglob = "";
        /* If not(Empty(rwqbe_rapporti_xls_dett.RISGLOB)) */
        if ( ! (CPLib.Empty(rwqbe_rapporti_xls_dett.RISGLOB))) {
          // * --- Read from tbrisglob
          m_cServer = m_Ctx.GetServer("tbrisglob");
          m_cPhName = m_Ctx.GetPhName("tbrisglob");
          m_cSql = "";
          m_cSql = m_cSql+"CODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwqbe_rapporti_xls_dett.RISGLOB,"C",3,0,m_cServer),m_cServer,rwqbe_rapporti_xls_dett.RISGLOB);
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
              Error l_oErrorFault = new Error("Read on tbrisglob into routine arrt_stprappo_all returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _risglob = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* _risglob := iif(Empty(_risglob),'',LRTrim(rwqbe_rapporti_xls_dett.RISGLOB)+"-"+ LRTrim(_risglob)) */
          _risglob = (CPLib.Empty(_risglob)?"":CPLib.LRTrim(rwqbe_rapporti_xls_dett.RISGLOB)+"-"+CPLib.LRTrim(_risglob));
        } // End If
        /* If fonte='D' */
        if (CPLib.eqr(fonte,"D")) {
          /* If tipo='T' */
          if (CPLib.eqr(tipo,"T")) {
            // * --- Fill memory cursor mcintestbo on intestbo
            mcintestbo.Zap();
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            if (Cursor_intestbo!=null)
              Cursor_intestbo.Close();
            Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwqbe_rapporti_xls_dett.RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,rwqbe_rapporti_xls_dett.RAPPORTO)+"  and  (STATOREG <> '2'  or  STATOREG <> '3') "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            {
              final CPResultSet m_TheCursor = Cursor_intestbo;
              Cursor_intestbo.ActionOnClose(new Runnable() {
                public void run() {
                  if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                    com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                    if ( ! (CPLib.IsNull(info))) {
                      info.log("Routine arrt_stprappo_all: query on intestbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                    }
                  }
                }
                });
            }
            while ( ! (Cursor_intestbo.Eof())) {
              mcintestbo.AppendBlank();
              mcintestbo.row.IDBASE = Cursor_intestbo.GetString("IDBASE");
              mcintestbo.row.CPROWNUM = Cursor_intestbo.GetDouble("CPROWNUM");
              mcintestbo.row.DATAINI = Cursor_intestbo.GetDate("DATAINI");
              mcintestbo.row.TIPOPERS = Cursor_intestbo.GetString("TIPOPERS");
              mcintestbo.row.CODINTER = Cursor_intestbo.GetString("CODINTER");
              mcintestbo.row.DATAFINE = Cursor_intestbo.GetDate("DATAFINE");
              mcintestbo.row.NUMPROG1 = Cursor_intestbo.GetString("NUMPROG1");
              mcintestbo.row.NUMPROG2 = Cursor_intestbo.GetString("NUMPROG2");
              mcintestbo.row.RAPPORTO = Cursor_intestbo.GetString("RAPPORTO");
              mcintestbo.row.TIPORAP = Cursor_intestbo.GetString("TIPORAP");
              mcintestbo.row.STATOREG = Cursor_intestbo.GetString("STATOREG");
              mcintestbo.row.DESCINTER = Cursor_intestbo.GetString("DESCINTER");
              mcintestbo.row.OPERAZMOD = Cursor_intestbo.GetString("OPERAZMOD");
              mcintestbo.row.DATARETT = Cursor_intestbo.GetDate("DATARETT");
              mcintestbo.row.IDEREG = Cursor_intestbo.GetString("IDEREG");
              mcintestbo.row.COLLEGAMEN = Cursor_intestbo.GetString("COLLEGAMEN");
              mcintestbo.row.UCODE = Cursor_intestbo.GetString("UCODE");
              mcintestbo.row.ABBINATO = Cursor_intestbo.GetDouble("ABBINATO");
              mcintestbo.row.PRGIMPSOG = Cursor_intestbo.GetDouble("PRGIMPSOG");
              mcintestbo.row.PROQUOTA = Cursor_intestbo.GetDouble("PROQUOTA");
              mcintestbo.row.NUMIMP = Cursor_intestbo.GetDateTime("NUMIMP");
              Cursor_intestbo.Next();
            }
            m_cConnectivityError = Cursor_intestbo.ErrorMessage();
            Cursor_intestbo.Close();
            mcintestbo.GoTop();
            /* ElseIf tipo='A' or tipo='1' */
          } else if (CPLib.eqr(tipo,"A") || CPLib.eqr(tipo,"1")) {
            // * --- Fill memory cursor mcintestbo on intestbo
            mcintestbo.Zap();
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            if (Cursor_intestbo!=null)
              Cursor_intestbo.Close();
            Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwqbe_rapporti_xls_dett.RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,rwqbe_rapporti_xls_dett.RAPPORTO)+"  and  (STATOREG <> '2'  or  STATOREG <> '3')  and  [NOTEMPTYDATE(DATAFINE)]=0 "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            {
              final CPResultSet m_TheCursor = Cursor_intestbo;
              Cursor_intestbo.ActionOnClose(new Runnable() {
                public void run() {
                  if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                    com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                    if ( ! (CPLib.IsNull(info))) {
                      info.log("Routine arrt_stprappo_all: query on intestbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                    }
                  }
                }
                });
            }
            while ( ! (Cursor_intestbo.Eof())) {
              mcintestbo.AppendBlank();
              mcintestbo.row.IDBASE = Cursor_intestbo.GetString("IDBASE");
              mcintestbo.row.CPROWNUM = Cursor_intestbo.GetDouble("CPROWNUM");
              mcintestbo.row.DATAINI = Cursor_intestbo.GetDate("DATAINI");
              mcintestbo.row.TIPOPERS = Cursor_intestbo.GetString("TIPOPERS");
              mcintestbo.row.CODINTER = Cursor_intestbo.GetString("CODINTER");
              mcintestbo.row.DATAFINE = Cursor_intestbo.GetDate("DATAFINE");
              mcintestbo.row.NUMPROG1 = Cursor_intestbo.GetString("NUMPROG1");
              mcintestbo.row.NUMPROG2 = Cursor_intestbo.GetString("NUMPROG2");
              mcintestbo.row.RAPPORTO = Cursor_intestbo.GetString("RAPPORTO");
              mcintestbo.row.TIPORAP = Cursor_intestbo.GetString("TIPORAP");
              mcintestbo.row.STATOREG = Cursor_intestbo.GetString("STATOREG");
              mcintestbo.row.DESCINTER = Cursor_intestbo.GetString("DESCINTER");
              mcintestbo.row.OPERAZMOD = Cursor_intestbo.GetString("OPERAZMOD");
              mcintestbo.row.DATARETT = Cursor_intestbo.GetDate("DATARETT");
              mcintestbo.row.IDEREG = Cursor_intestbo.GetString("IDEREG");
              mcintestbo.row.COLLEGAMEN = Cursor_intestbo.GetString("COLLEGAMEN");
              mcintestbo.row.UCODE = Cursor_intestbo.GetString("UCODE");
              mcintestbo.row.ABBINATO = Cursor_intestbo.GetDouble("ABBINATO");
              mcintestbo.row.PRGIMPSOG = Cursor_intestbo.GetDouble("PRGIMPSOG");
              mcintestbo.row.PROQUOTA = Cursor_intestbo.GetDouble("PROQUOTA");
              mcintestbo.row.NUMIMP = Cursor_intestbo.GetDateTime("NUMIMP");
              Cursor_intestbo.Next();
            }
            m_cConnectivityError = Cursor_intestbo.ErrorMessage();
            Cursor_intestbo.Close();
            mcintestbo.GoTop();
            /* ElseIf tipo='C' or tipo='2' */
          } else if (CPLib.eqr(tipo,"C") || CPLib.eqr(tipo,"2")) {
            // * --- Fill memory cursor mcintestbo on intestbo
            mcintestbo.Zap();
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            if (Cursor_intestbo!=null)
              Cursor_intestbo.Close();
            Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwqbe_rapporti_xls_dett.RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,rwqbe_rapporti_xls_dett.RAPPORTO)+"  and  (STATOREG <> '2'  or  STATOREG <> '3')  and  [NOTEMPTYDATE(DATAFINE)]>0 "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            {
              final CPResultSet m_TheCursor = Cursor_intestbo;
              Cursor_intestbo.ActionOnClose(new Runnable() {
                public void run() {
                  if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                    com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                    if ( ! (CPLib.IsNull(info))) {
                      info.log("Routine arrt_stprappo_all: query on intestbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                    }
                  }
                }
                });
            }
            while ( ! (Cursor_intestbo.Eof())) {
              mcintestbo.AppendBlank();
              mcintestbo.row.IDBASE = Cursor_intestbo.GetString("IDBASE");
              mcintestbo.row.CPROWNUM = Cursor_intestbo.GetDouble("CPROWNUM");
              mcintestbo.row.DATAINI = Cursor_intestbo.GetDate("DATAINI");
              mcintestbo.row.TIPOPERS = Cursor_intestbo.GetString("TIPOPERS");
              mcintestbo.row.CODINTER = Cursor_intestbo.GetString("CODINTER");
              mcintestbo.row.DATAFINE = Cursor_intestbo.GetDate("DATAFINE");
              mcintestbo.row.NUMPROG1 = Cursor_intestbo.GetString("NUMPROG1");
              mcintestbo.row.NUMPROG2 = Cursor_intestbo.GetString("NUMPROG2");
              mcintestbo.row.RAPPORTO = Cursor_intestbo.GetString("RAPPORTO");
              mcintestbo.row.TIPORAP = Cursor_intestbo.GetString("TIPORAP");
              mcintestbo.row.STATOREG = Cursor_intestbo.GetString("STATOREG");
              mcintestbo.row.DESCINTER = Cursor_intestbo.GetString("DESCINTER");
              mcintestbo.row.OPERAZMOD = Cursor_intestbo.GetString("OPERAZMOD");
              mcintestbo.row.DATARETT = Cursor_intestbo.GetDate("DATARETT");
              mcintestbo.row.IDEREG = Cursor_intestbo.GetString("IDEREG");
              mcintestbo.row.COLLEGAMEN = Cursor_intestbo.GetString("COLLEGAMEN");
              mcintestbo.row.UCODE = Cursor_intestbo.GetString("UCODE");
              mcintestbo.row.ABBINATO = Cursor_intestbo.GetDouble("ABBINATO");
              mcintestbo.row.PRGIMPSOG = Cursor_intestbo.GetDouble("PRGIMPSOG");
              mcintestbo.row.PROQUOTA = Cursor_intestbo.GetDouble("PROQUOTA");
              mcintestbo.row.NUMIMP = Cursor_intestbo.GetDateTime("NUMIMP");
              Cursor_intestbo.Next();
            }
            m_cConnectivityError = Cursor_intestbo.ErrorMessage();
            Cursor_intestbo.Close();
            mcintestbo.GoTop();
          } // End If
          /* ElseIf fonte='P' */
        } else if (CPLib.eqr(fonte,"P")) {
          /* If tipo='T' */
          if (CPLib.eqr(tipo,"T")) {
            // * --- Fill memory cursor mcintestbo on xntestbo
            mcintestbo.Zap();
            m_cServer = m_Ctx.GetServer("xntestbo");
            m_cPhName = m_Ctx.GetPhName("xntestbo");
            if (Cursor_xntestbo!=null)
              Cursor_xntestbo.Close();
            Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwqbe_rapporti_xls_dett.RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,rwqbe_rapporti_xls_dett.RAPPORTO)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            {
              final CPResultSet m_TheCursor = Cursor_xntestbo;
              Cursor_xntestbo.ActionOnClose(new Runnable() {
                public void run() {
                  if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                    com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                    if ( ! (CPLib.IsNull(info))) {
                      info.log("Routine arrt_stprappo_all: query on xntestbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                    }
                  }
                }
                });
            }
            while ( ! (Cursor_xntestbo.Eof())) {
              mcintestbo.AppendBlank();
              mcintestbo.row.IDBASE = Cursor_xntestbo.GetString("IDBASE");
              mcintestbo.row.CPROWNUM = Cursor_xntestbo.GetDouble("CPROWNUM");
              mcintestbo.row.DATAINI = Cursor_xntestbo.GetDate("DATAINI");
              mcintestbo.row.TIPOPERS = Cursor_xntestbo.GetString("TIPOPERS");
              mcintestbo.row.CODINTER = Cursor_xntestbo.GetString("CODINTER");
              mcintestbo.row.DATAFINE = Cursor_xntestbo.GetDate("DATAFINE");
              mcintestbo.row.NUMPROG1 = Cursor_xntestbo.GetString("NUMPROG1");
              mcintestbo.row.NUMPROG2 = Cursor_xntestbo.GetString("NUMPROG2");
              mcintestbo.row.RAPPORTO = Cursor_xntestbo.GetString("RAPPORTO");
              mcintestbo.row.TIPORAP = Cursor_xntestbo.GetString("TIPORAP");
              mcintestbo.row.STATOREG = Cursor_xntestbo.GetString("STATOREG");
              mcintestbo.row.DESCINTER = Cursor_xntestbo.GetString("DESCINTER");
              mcintestbo.row.OPERAZMOD = Cursor_xntestbo.GetString("OPERAZMOD");
              mcintestbo.row.DATARETT = Cursor_xntestbo.GetDate("DATARETT");
              mcintestbo.row.IDEREG = Cursor_xntestbo.GetString("IDEREG");
              mcintestbo.row.COLLEGAMEN = Cursor_xntestbo.GetString("COLLEGAMEN");
              mcintestbo.row.UCODE = Cursor_xntestbo.GetString("UCODE");
              mcintestbo.row.ABBINATO = Cursor_xntestbo.GetDouble("ABBINATO");
              mcintestbo.row.PRGIMPSOG = Cursor_xntestbo.GetDouble("PRGIMPSOG");
              mcintestbo.row.PROQUOTA = Cursor_xntestbo.GetDouble("PROQUOTA");
              mcintestbo.row.NUMIMP = Cursor_xntestbo.GetDateTime("NUMIMP");
              Cursor_xntestbo.Next();
            }
            m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
            Cursor_xntestbo.Close();
            mcintestbo.GoTop();
            /* ElseIf tipo='A' or tipo='1' */
          } else if (CPLib.eqr(tipo,"A") || CPLib.eqr(tipo,"1")) {
            // * --- Fill memory cursor mcintestbo on xntestbo
            mcintestbo.Zap();
            m_cServer = m_Ctx.GetServer("xntestbo");
            m_cPhName = m_Ctx.GetPhName("xntestbo");
            if (Cursor_xntestbo!=null)
              Cursor_xntestbo.Close();
            Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwqbe_rapporti_xls_dett.RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,rwqbe_rapporti_xls_dett.RAPPORTO)+"  and  [NOTEMPTYDATE(DATAFINE)]=0 "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            {
              final CPResultSet m_TheCursor = Cursor_xntestbo;
              Cursor_xntestbo.ActionOnClose(new Runnable() {
                public void run() {
                  if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                    com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                    if ( ! (CPLib.IsNull(info))) {
                      info.log("Routine arrt_stprappo_all: query on xntestbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                    }
                  }
                }
                });
            }
            while ( ! (Cursor_xntestbo.Eof())) {
              mcintestbo.AppendBlank();
              mcintestbo.row.IDBASE = Cursor_xntestbo.GetString("IDBASE");
              mcintestbo.row.CPROWNUM = Cursor_xntestbo.GetDouble("CPROWNUM");
              mcintestbo.row.DATAINI = Cursor_xntestbo.GetDate("DATAINI");
              mcintestbo.row.TIPOPERS = Cursor_xntestbo.GetString("TIPOPERS");
              mcintestbo.row.CODINTER = Cursor_xntestbo.GetString("CODINTER");
              mcintestbo.row.DATAFINE = Cursor_xntestbo.GetDate("DATAFINE");
              mcintestbo.row.NUMPROG1 = Cursor_xntestbo.GetString("NUMPROG1");
              mcintestbo.row.NUMPROG2 = Cursor_xntestbo.GetString("NUMPROG2");
              mcintestbo.row.RAPPORTO = Cursor_xntestbo.GetString("RAPPORTO");
              mcintestbo.row.TIPORAP = Cursor_xntestbo.GetString("TIPORAP");
              mcintestbo.row.STATOREG = Cursor_xntestbo.GetString("STATOREG");
              mcintestbo.row.DESCINTER = Cursor_xntestbo.GetString("DESCINTER");
              mcintestbo.row.OPERAZMOD = Cursor_xntestbo.GetString("OPERAZMOD");
              mcintestbo.row.DATARETT = Cursor_xntestbo.GetDate("DATARETT");
              mcintestbo.row.IDEREG = Cursor_xntestbo.GetString("IDEREG");
              mcintestbo.row.COLLEGAMEN = Cursor_xntestbo.GetString("COLLEGAMEN");
              mcintestbo.row.UCODE = Cursor_xntestbo.GetString("UCODE");
              mcintestbo.row.ABBINATO = Cursor_xntestbo.GetDouble("ABBINATO");
              mcintestbo.row.PRGIMPSOG = Cursor_xntestbo.GetDouble("PRGIMPSOG");
              mcintestbo.row.PROQUOTA = Cursor_xntestbo.GetDouble("PROQUOTA");
              mcintestbo.row.NUMIMP = Cursor_xntestbo.GetDateTime("NUMIMP");
              Cursor_xntestbo.Next();
            }
            m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
            Cursor_xntestbo.Close();
            mcintestbo.GoTop();
            /* ElseIf tipo='C' or tipo='2' */
          } else if (CPLib.eqr(tipo,"C") || CPLib.eqr(tipo,"2")) {
            // * --- Fill memory cursor mcintestbo on xntestbo
            mcintestbo.Zap();
            m_cServer = m_Ctx.GetServer("xntestbo");
            m_cPhName = m_Ctx.GetPhName("xntestbo");
            if (Cursor_xntestbo!=null)
              Cursor_xntestbo.Close();
            Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwqbe_rapporti_xls_dett.RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,rwqbe_rapporti_xls_dett.RAPPORTO)+"  and  [NOTEMPTYDATE(DATAFINE)]>0 "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            {
              final CPResultSet m_TheCursor = Cursor_xntestbo;
              Cursor_xntestbo.ActionOnClose(new Runnable() {
                public void run() {
                  if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                    com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                    if ( ! (CPLib.IsNull(info))) {
                      info.log("Routine arrt_stprappo_all: query on xntestbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                    }
                  }
                }
                });
            }
            while ( ! (Cursor_xntestbo.Eof())) {
              mcintestbo.AppendBlank();
              mcintestbo.row.IDBASE = Cursor_xntestbo.GetString("IDBASE");
              mcintestbo.row.CPROWNUM = Cursor_xntestbo.GetDouble("CPROWNUM");
              mcintestbo.row.DATAINI = Cursor_xntestbo.GetDate("DATAINI");
              mcintestbo.row.TIPOPERS = Cursor_xntestbo.GetString("TIPOPERS");
              mcintestbo.row.CODINTER = Cursor_xntestbo.GetString("CODINTER");
              mcintestbo.row.DATAFINE = Cursor_xntestbo.GetDate("DATAFINE");
              mcintestbo.row.NUMPROG1 = Cursor_xntestbo.GetString("NUMPROG1");
              mcintestbo.row.NUMPROG2 = Cursor_xntestbo.GetString("NUMPROG2");
              mcintestbo.row.RAPPORTO = Cursor_xntestbo.GetString("RAPPORTO");
              mcintestbo.row.TIPORAP = Cursor_xntestbo.GetString("TIPORAP");
              mcintestbo.row.STATOREG = Cursor_xntestbo.GetString("STATOREG");
              mcintestbo.row.DESCINTER = Cursor_xntestbo.GetString("DESCINTER");
              mcintestbo.row.OPERAZMOD = Cursor_xntestbo.GetString("OPERAZMOD");
              mcintestbo.row.DATARETT = Cursor_xntestbo.GetDate("DATARETT");
              mcintestbo.row.IDEREG = Cursor_xntestbo.GetString("IDEREG");
              mcintestbo.row.COLLEGAMEN = Cursor_xntestbo.GetString("COLLEGAMEN");
              mcintestbo.row.UCODE = Cursor_xntestbo.GetString("UCODE");
              mcintestbo.row.ABBINATO = Cursor_xntestbo.GetDouble("ABBINATO");
              mcintestbo.row.PRGIMPSOG = Cursor_xntestbo.GetDouble("PRGIMPSOG");
              mcintestbo.row.PROQUOTA = Cursor_xntestbo.GetDouble("PROQUOTA");
              mcintestbo.row.NUMIMP = Cursor_xntestbo.GetDateTime("NUMIMP");
              Cursor_xntestbo.Next();
            }
            m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
            Cursor_xntestbo.Close();
            mcintestbo.GoTop();
          } // End If
          /* ElseIf fonte='J' */
        } else if (CPLib.eqr(fonte,"J")) {
          /* If tipo='T' */
          if (CPLib.eqr(tipo,"T")) {
            // * --- Fill memory cursor mcintestbo on jntestbo
            mcintestbo.Zap();
            m_cServer = m_Ctx.GetServer("jntestbo");
            m_cPhName = m_Ctx.GetPhName("jntestbo");
            if (Cursor_jntestbo!=null)
              Cursor_jntestbo.Close();
            Cursor_jntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwqbe_rapporti_xls_dett.RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,rwqbe_rapporti_xls_dett.RAPPORTO)+" "+")"+(m_Ctx.IsSharedTemp("jntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            {
              final CPResultSet m_TheCursor = Cursor_jntestbo;
              Cursor_jntestbo.ActionOnClose(new Runnable() {
                public void run() {
                  if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                    com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                    if ( ! (CPLib.IsNull(info))) {
                      info.log("Routine arrt_stprappo_all: query on jntestbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                    }
                  }
                }
                });
            }
            while ( ! (Cursor_jntestbo.Eof())) {
              mcintestbo.AppendBlank();
              mcintestbo.row.IDBASE = Cursor_jntestbo.GetString("IDBASE");
              mcintestbo.row.CPROWNUM = Cursor_jntestbo.GetDouble("CPROWNUM");
              mcintestbo.row.DATAINI = Cursor_jntestbo.GetDate("DATAINI");
              mcintestbo.row.TIPOPERS = Cursor_jntestbo.GetString("TIPOPERS");
              mcintestbo.row.CODINTER = Cursor_jntestbo.GetString("CODINTER");
              mcintestbo.row.DATAFINE = Cursor_jntestbo.GetDate("DATAFINE");
              mcintestbo.row.NUMPROG1 = Cursor_jntestbo.GetString("NUMPROG1");
              mcintestbo.row.NUMPROG2 = Cursor_jntestbo.GetString("NUMPROG2");
              mcintestbo.row.RAPPORTO = Cursor_jntestbo.GetString("RAPPORTO");
              mcintestbo.row.TIPORAP = Cursor_jntestbo.GetString("TIPORAP");
              mcintestbo.row.STATOREG = Cursor_jntestbo.GetString("STATOREG");
              mcintestbo.row.DESCINTER = Cursor_jntestbo.GetString("DESCINTER");
              mcintestbo.row.OPERAZMOD = Cursor_jntestbo.GetString("OPERAZMOD");
              mcintestbo.row.DATARETT = Cursor_jntestbo.GetDate("DATARETT");
              mcintestbo.row.IDEREG = Cursor_jntestbo.GetString("IDEREG");
              mcintestbo.row.COLLEGAMEN = Cursor_jntestbo.GetString("COLLEGAMEN");
              mcintestbo.row.UCODE = Cursor_jntestbo.GetString("UCODE");
              mcintestbo.row.ABBINATO = Cursor_jntestbo.GetDouble("ABBINATO");
              mcintestbo.row.PRGIMPSOG = Cursor_jntestbo.GetDouble("PRGIMPSOG");
              mcintestbo.row.PROQUOTA = Cursor_jntestbo.GetDouble("PROQUOTA");
              mcintestbo.row.NUMIMP = Cursor_jntestbo.GetDateTime("NUMIMP");
              Cursor_jntestbo.Next();
            }
            m_cConnectivityError = Cursor_jntestbo.ErrorMessage();
            Cursor_jntestbo.Close();
            mcintestbo.GoTop();
            /* ElseIf tipo='A' or tipo='1' */
          } else if (CPLib.eqr(tipo,"A") || CPLib.eqr(tipo,"1")) {
            // * --- Fill memory cursor mcintestbo on jntestbo
            mcintestbo.Zap();
            m_cServer = m_Ctx.GetServer("jntestbo");
            m_cPhName = m_Ctx.GetPhName("jntestbo");
            if (Cursor_jntestbo!=null)
              Cursor_jntestbo.Close();
            Cursor_jntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwqbe_rapporti_xls_dett.RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,rwqbe_rapporti_xls_dett.RAPPORTO)+"  and  [NOTEMPTYDATE(DATAFINE)]=0 "+")"+(m_Ctx.IsSharedTemp("jntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            {
              final CPResultSet m_TheCursor = Cursor_jntestbo;
              Cursor_jntestbo.ActionOnClose(new Runnable() {
                public void run() {
                  if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                    com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                    if ( ! (CPLib.IsNull(info))) {
                      info.log("Routine arrt_stprappo_all: query on jntestbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                    }
                  }
                }
                });
            }
            while ( ! (Cursor_jntestbo.Eof())) {
              mcintestbo.AppendBlank();
              mcintestbo.row.IDBASE = Cursor_jntestbo.GetString("IDBASE");
              mcintestbo.row.CPROWNUM = Cursor_jntestbo.GetDouble("CPROWNUM");
              mcintestbo.row.DATAINI = Cursor_jntestbo.GetDate("DATAINI");
              mcintestbo.row.TIPOPERS = Cursor_jntestbo.GetString("TIPOPERS");
              mcintestbo.row.CODINTER = Cursor_jntestbo.GetString("CODINTER");
              mcintestbo.row.DATAFINE = Cursor_jntestbo.GetDate("DATAFINE");
              mcintestbo.row.NUMPROG1 = Cursor_jntestbo.GetString("NUMPROG1");
              mcintestbo.row.NUMPROG2 = Cursor_jntestbo.GetString("NUMPROG2");
              mcintestbo.row.RAPPORTO = Cursor_jntestbo.GetString("RAPPORTO");
              mcintestbo.row.TIPORAP = Cursor_jntestbo.GetString("TIPORAP");
              mcintestbo.row.STATOREG = Cursor_jntestbo.GetString("STATOREG");
              mcintestbo.row.DESCINTER = Cursor_jntestbo.GetString("DESCINTER");
              mcintestbo.row.OPERAZMOD = Cursor_jntestbo.GetString("OPERAZMOD");
              mcintestbo.row.DATARETT = Cursor_jntestbo.GetDate("DATARETT");
              mcintestbo.row.IDEREG = Cursor_jntestbo.GetString("IDEREG");
              mcintestbo.row.COLLEGAMEN = Cursor_jntestbo.GetString("COLLEGAMEN");
              mcintestbo.row.UCODE = Cursor_jntestbo.GetString("UCODE");
              mcintestbo.row.ABBINATO = Cursor_jntestbo.GetDouble("ABBINATO");
              mcintestbo.row.PRGIMPSOG = Cursor_jntestbo.GetDouble("PRGIMPSOG");
              mcintestbo.row.PROQUOTA = Cursor_jntestbo.GetDouble("PROQUOTA");
              mcintestbo.row.NUMIMP = Cursor_jntestbo.GetDateTime("NUMIMP");
              Cursor_jntestbo.Next();
            }
            m_cConnectivityError = Cursor_jntestbo.ErrorMessage();
            Cursor_jntestbo.Close();
            mcintestbo.GoTop();
            /* ElseIf tipo='C' or tipo='2' */
          } else if (CPLib.eqr(tipo,"C") || CPLib.eqr(tipo,"2")) {
            // * --- Fill memory cursor mcintestbo on jntestbo
            mcintestbo.Zap();
            m_cServer = m_Ctx.GetServer("jntestbo");
            m_cPhName = m_Ctx.GetPhName("jntestbo");
            if (Cursor_jntestbo!=null)
              Cursor_jntestbo.Close();
            Cursor_jntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwqbe_rapporti_xls_dett.RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,rwqbe_rapporti_xls_dett.RAPPORTO)+"  and  [NOTEMPTYDATE(DATAFINE)]>0 "+")"+(m_Ctx.IsSharedTemp("jntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            {
              final CPResultSet m_TheCursor = Cursor_jntestbo;
              Cursor_jntestbo.ActionOnClose(new Runnable() {
                public void run() {
                  if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                    com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                    if ( ! (CPLib.IsNull(info))) {
                      info.log("Routine arrt_stprappo_all: query on jntestbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                    }
                  }
                }
                });
            }
            while ( ! (Cursor_jntestbo.Eof())) {
              mcintestbo.AppendBlank();
              mcintestbo.row.IDBASE = Cursor_jntestbo.GetString("IDBASE");
              mcintestbo.row.CPROWNUM = Cursor_jntestbo.GetDouble("CPROWNUM");
              mcintestbo.row.DATAINI = Cursor_jntestbo.GetDate("DATAINI");
              mcintestbo.row.TIPOPERS = Cursor_jntestbo.GetString("TIPOPERS");
              mcintestbo.row.CODINTER = Cursor_jntestbo.GetString("CODINTER");
              mcintestbo.row.DATAFINE = Cursor_jntestbo.GetDate("DATAFINE");
              mcintestbo.row.NUMPROG1 = Cursor_jntestbo.GetString("NUMPROG1");
              mcintestbo.row.NUMPROG2 = Cursor_jntestbo.GetString("NUMPROG2");
              mcintestbo.row.RAPPORTO = Cursor_jntestbo.GetString("RAPPORTO");
              mcintestbo.row.TIPORAP = Cursor_jntestbo.GetString("TIPORAP");
              mcintestbo.row.STATOREG = Cursor_jntestbo.GetString("STATOREG");
              mcintestbo.row.DESCINTER = Cursor_jntestbo.GetString("DESCINTER");
              mcintestbo.row.OPERAZMOD = Cursor_jntestbo.GetString("OPERAZMOD");
              mcintestbo.row.DATARETT = Cursor_jntestbo.GetDate("DATARETT");
              mcintestbo.row.IDEREG = Cursor_jntestbo.GetString("IDEREG");
              mcintestbo.row.COLLEGAMEN = Cursor_jntestbo.GetString("COLLEGAMEN");
              mcintestbo.row.UCODE = Cursor_jntestbo.GetString("UCODE");
              mcintestbo.row.ABBINATO = Cursor_jntestbo.GetDouble("ABBINATO");
              mcintestbo.row.PRGIMPSOG = Cursor_jntestbo.GetDouble("PRGIMPSOG");
              mcintestbo.row.PROQUOTA = Cursor_jntestbo.GetDouble("PROQUOTA");
              mcintestbo.row.NUMIMP = Cursor_jntestbo.GetDateTime("NUMIMP");
              Cursor_jntestbo.Next();
            }
            m_cConnectivityError = Cursor_jntestbo.ErrorMessage();
            Cursor_jntestbo.Close();
            mcintestbo.GoTop();
          } // End If
          /* ElseIf fonte='W' */
        } else if (CPLib.eqr(fonte,"W")) {
          /* If tipo='T' */
          if (CPLib.eqr(tipo,"T")) {
            // * --- Fill memory cursor mcintestbo on wntestbo
            mcintestbo.Zap();
            m_cServer = m_Ctx.GetServer("wntestbo");
            m_cPhName = m_Ctx.GetPhName("wntestbo");
            if (Cursor_wntestbo!=null)
              Cursor_wntestbo.Close();
            Cursor_wntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwqbe_rapporti_xls_dett.RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,rwqbe_rapporti_xls_dett.RAPPORTO)+" "+")"+(m_Ctx.IsSharedTemp("wntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            {
              final CPResultSet m_TheCursor = Cursor_wntestbo;
              Cursor_wntestbo.ActionOnClose(new Runnable() {
                public void run() {
                  if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                    com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                    if ( ! (CPLib.IsNull(info))) {
                      info.log("Routine arrt_stprappo_all: query on wntestbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                    }
                  }
                }
                });
            }
            while ( ! (Cursor_wntestbo.Eof())) {
              mcintestbo.AppendBlank();
              mcintestbo.row.IDBASE = Cursor_wntestbo.GetString("IDBASE");
              mcintestbo.row.CPROWNUM = Cursor_wntestbo.GetDouble("CPROWNUM");
              mcintestbo.row.DATAINI = Cursor_wntestbo.GetDate("DATAINI");
              mcintestbo.row.TIPOPERS = Cursor_wntestbo.GetString("TIPOPERS");
              mcintestbo.row.CODINTER = Cursor_wntestbo.GetString("CODINTER");
              mcintestbo.row.DATAFINE = Cursor_wntestbo.GetDate("DATAFINE");
              mcintestbo.row.NUMPROG1 = Cursor_wntestbo.GetString("NUMPROG1");
              mcintestbo.row.NUMPROG2 = Cursor_wntestbo.GetString("NUMPROG2");
              mcintestbo.row.RAPPORTO = Cursor_wntestbo.GetString("RAPPORTO");
              mcintestbo.row.TIPORAP = Cursor_wntestbo.GetString("TIPORAP");
              mcintestbo.row.STATOREG = Cursor_wntestbo.GetString("STATOREG");
              mcintestbo.row.DESCINTER = Cursor_wntestbo.GetString("DESCINTER");
              mcintestbo.row.OPERAZMOD = Cursor_wntestbo.GetString("OPERAZMOD");
              mcintestbo.row.DATARETT = Cursor_wntestbo.GetDate("DATARETT");
              mcintestbo.row.IDEREG = Cursor_wntestbo.GetString("IDEREG");
              mcintestbo.row.COLLEGAMEN = Cursor_wntestbo.GetString("COLLEGAMEN");
              mcintestbo.row.UCODE = Cursor_wntestbo.GetString("UCODE");
              mcintestbo.row.ABBINATO = Cursor_wntestbo.GetDouble("ABBINATO");
              mcintestbo.row.PRGIMPSOG = Cursor_wntestbo.GetDouble("PRGIMPSOG");
              mcintestbo.row.PROQUOTA = Cursor_wntestbo.GetDouble("PROQUOTA");
              mcintestbo.row.NUMIMP = Cursor_wntestbo.GetDateTime("NUMIMP");
              Cursor_wntestbo.Next();
            }
            m_cConnectivityError = Cursor_wntestbo.ErrorMessage();
            Cursor_wntestbo.Close();
            mcintestbo.GoTop();
            /* ElseIf tipo='A' or tipo='1' */
          } else if (CPLib.eqr(tipo,"A") || CPLib.eqr(tipo,"1")) {
            // * --- Fill memory cursor mcintestbo on wntestbo
            mcintestbo.Zap();
            m_cServer = m_Ctx.GetServer("wntestbo");
            m_cPhName = m_Ctx.GetPhName("wntestbo");
            if (Cursor_wntestbo!=null)
              Cursor_wntestbo.Close();
            Cursor_wntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwqbe_rapporti_xls_dett.RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,rwqbe_rapporti_xls_dett.RAPPORTO)+"  and  [NOTEMPTYDATE(DATAFINE)]=0 "+")"+(m_Ctx.IsSharedTemp("wntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            {
              final CPResultSet m_TheCursor = Cursor_wntestbo;
              Cursor_wntestbo.ActionOnClose(new Runnable() {
                public void run() {
                  if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                    com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                    if ( ! (CPLib.IsNull(info))) {
                      info.log("Routine arrt_stprappo_all: query on wntestbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                    }
                  }
                }
                });
            }
            while ( ! (Cursor_wntestbo.Eof())) {
              mcintestbo.AppendBlank();
              mcintestbo.row.IDBASE = Cursor_wntestbo.GetString("IDBASE");
              mcintestbo.row.CPROWNUM = Cursor_wntestbo.GetDouble("CPROWNUM");
              mcintestbo.row.DATAINI = Cursor_wntestbo.GetDate("DATAINI");
              mcintestbo.row.TIPOPERS = Cursor_wntestbo.GetString("TIPOPERS");
              mcintestbo.row.CODINTER = Cursor_wntestbo.GetString("CODINTER");
              mcintestbo.row.DATAFINE = Cursor_wntestbo.GetDate("DATAFINE");
              mcintestbo.row.NUMPROG1 = Cursor_wntestbo.GetString("NUMPROG1");
              mcintestbo.row.NUMPROG2 = Cursor_wntestbo.GetString("NUMPROG2");
              mcintestbo.row.RAPPORTO = Cursor_wntestbo.GetString("RAPPORTO");
              mcintestbo.row.TIPORAP = Cursor_wntestbo.GetString("TIPORAP");
              mcintestbo.row.STATOREG = Cursor_wntestbo.GetString("STATOREG");
              mcintestbo.row.DESCINTER = Cursor_wntestbo.GetString("DESCINTER");
              mcintestbo.row.OPERAZMOD = Cursor_wntestbo.GetString("OPERAZMOD");
              mcintestbo.row.DATARETT = Cursor_wntestbo.GetDate("DATARETT");
              mcintestbo.row.IDEREG = Cursor_wntestbo.GetString("IDEREG");
              mcintestbo.row.COLLEGAMEN = Cursor_wntestbo.GetString("COLLEGAMEN");
              mcintestbo.row.UCODE = Cursor_wntestbo.GetString("UCODE");
              mcintestbo.row.ABBINATO = Cursor_wntestbo.GetDouble("ABBINATO");
              mcintestbo.row.PRGIMPSOG = Cursor_wntestbo.GetDouble("PRGIMPSOG");
              mcintestbo.row.PROQUOTA = Cursor_wntestbo.GetDouble("PROQUOTA");
              mcintestbo.row.NUMIMP = Cursor_wntestbo.GetDateTime("NUMIMP");
              Cursor_wntestbo.Next();
            }
            m_cConnectivityError = Cursor_wntestbo.ErrorMessage();
            Cursor_wntestbo.Close();
            mcintestbo.GoTop();
            /* ElseIf tipo='C' or tipo='2' */
          } else if (CPLib.eqr(tipo,"C") || CPLib.eqr(tipo,"2")) {
            // * --- Fill memory cursor mcintestbo on wntestbo
            mcintestbo.Zap();
            m_cServer = m_Ctx.GetServer("wntestbo");
            m_cPhName = m_Ctx.GetPhName("wntestbo");
            if (Cursor_wntestbo!=null)
              Cursor_wntestbo.Close();
            Cursor_wntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwqbe_rapporti_xls_dett.RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,rwqbe_rapporti_xls_dett.RAPPORTO)+"  and  [NOTEMPTYDATE(DATAFINE)]>0 "+")"+(m_Ctx.IsSharedTemp("wntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            {
              final CPResultSet m_TheCursor = Cursor_wntestbo;
              Cursor_wntestbo.ActionOnClose(new Runnable() {
                public void run() {
                  if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                    com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                    if ( ! (CPLib.IsNull(info))) {
                      info.log("Routine arrt_stprappo_all: query on wntestbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                    }
                  }
                }
                });
            }
            while ( ! (Cursor_wntestbo.Eof())) {
              mcintestbo.AppendBlank();
              mcintestbo.row.IDBASE = Cursor_wntestbo.GetString("IDBASE");
              mcintestbo.row.CPROWNUM = Cursor_wntestbo.GetDouble("CPROWNUM");
              mcintestbo.row.DATAINI = Cursor_wntestbo.GetDate("DATAINI");
              mcintestbo.row.TIPOPERS = Cursor_wntestbo.GetString("TIPOPERS");
              mcintestbo.row.CODINTER = Cursor_wntestbo.GetString("CODINTER");
              mcintestbo.row.DATAFINE = Cursor_wntestbo.GetDate("DATAFINE");
              mcintestbo.row.NUMPROG1 = Cursor_wntestbo.GetString("NUMPROG1");
              mcintestbo.row.NUMPROG2 = Cursor_wntestbo.GetString("NUMPROG2");
              mcintestbo.row.RAPPORTO = Cursor_wntestbo.GetString("RAPPORTO");
              mcintestbo.row.TIPORAP = Cursor_wntestbo.GetString("TIPORAP");
              mcintestbo.row.STATOREG = Cursor_wntestbo.GetString("STATOREG");
              mcintestbo.row.DESCINTER = Cursor_wntestbo.GetString("DESCINTER");
              mcintestbo.row.OPERAZMOD = Cursor_wntestbo.GetString("OPERAZMOD");
              mcintestbo.row.DATARETT = Cursor_wntestbo.GetDate("DATARETT");
              mcintestbo.row.IDEREG = Cursor_wntestbo.GetString("IDEREG");
              mcintestbo.row.COLLEGAMEN = Cursor_wntestbo.GetString("COLLEGAMEN");
              mcintestbo.row.UCODE = Cursor_wntestbo.GetString("UCODE");
              mcintestbo.row.ABBINATO = Cursor_wntestbo.GetDouble("ABBINATO");
              mcintestbo.row.PRGIMPSOG = Cursor_wntestbo.GetDouble("PRGIMPSOG");
              mcintestbo.row.PROQUOTA = Cursor_wntestbo.GetDouble("PROQUOTA");
              mcintestbo.row.NUMIMP = Cursor_wntestbo.GetDateTime("NUMIMP");
              Cursor_wntestbo.Next();
            }
            m_cConnectivityError = Cursor_wntestbo.ErrorMessage();
            Cursor_wntestbo.Close();
            mcintestbo.GoTop();
          } // End If
        } // End If
        for (MemoryCursorRow_intestbo rwintestbo : mcintestbo._iterable_()) {
          /* _crap := True // Esite il rapporto */
          _crap = true;
          /* connes := rwintestbo.CODINTER */
          connes = rwintestbo.CODINTER;
          /* dataini := arfn_fdate(rwintestbo.DATAINI) */
          dataini = arfn_fdateR.Make(m_Ctx,this).Run(rwintestbo.DATAINI);
          /* datafin := arfn_fdate(rwintestbo.DATAFINE) */
          datafin = arfn_fdateR.Make(m_Ctx,this).Run(rwintestbo.DATAFINE);
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
          Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwintestbo.CODINTER,"?",0,0,m_cServer, m_oParameters),m_cServer,rwintestbo.CODINTER)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
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
                Error l_oErrorFault = new Error("Read on tbstati into routine arrt_stprappo_all returns two or more records. This item should return only a record.");
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
                Error l_oErrorFault = new Error("Read on tbtipdoc into routine arrt_stprappo_all returns two or more records. This item should return only a record.");
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
                Error l_oErrorFault = new Error("Read on tbstgru into routine arrt_stprappo_all returns two or more records. This item should return only a record.");
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
                Error l_oErrorFault = new Error("Read on tbtipatt into routine arrt_stprappo_all returns two or more records. This item should return only a record.");
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
                Error l_oErrorFault = new Error("Read on tbsetsin into routine arrt_stprappo_all returns two or more records. This item should return only a record.");
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
                Error l_oErrorFault = new Error("Read on tbramgru into routine arrt_stprappo_all returns two or more records. This item should return only a record.");
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
            /* _risglobs := '' */
            _risglobs = "";
            /* If not(Empty(personbo->RISGLOB)) */
            if ( ! (CPLib.Empty(Cursor_personbo.GetString("RISGLOB")))) {
              // * --- Read from tbrisglob
              m_cServer = m_Ctx.GetServer("tbrisglob");
              m_cPhName = m_Ctx.GetPhName("tbrisglob");
              m_cSql = "";
              m_cSql = m_cSql+"CODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("RISGLOB"),"C",3,0,m_cServer),m_cServer,Cursor_personbo.GetString("RISGLOB"));
              if (m_Ctx.IsSharedTemp("tbrisglob")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _risglobs = Read_Cursor.GetString("DESCRI");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbrisglob into routine arrt_stprappo_all returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _risglobs = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* _risglobs := iif(Empty(_risglobs),'',LRTrim(personbo->RISGLOB)+"-"+ LRTrim(_risglobs)) */
              _risglobs = (CPLib.Empty(_risglobs)?"":CPLib.LRTrim(Cursor_personbo.GetString("RISGLOB"))+"-"+CPLib.LRTrim(_risglobs));
            } // End If
            /* _datprofs := arfn_fdate(personbo->DATAPROF) */
            _datprofs = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_personbo.GetDate("DATAPROF"));
            /* _datrevprofs := arfn_fdate(personbo->DATAREVPROF) */
            _datrevprofs = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_personbo.GetDate("DATAREVPROF"));
            Cursor_personbo.Next();
          }
          m_cConnectivityError = Cursor_personbo.ErrorMessage();
          Cursor_personbo.Close();
          // * --- End Select
          /* If tipo='1' or tipo='2' */
          if (CPLib.eqr(tipo,"1") || CPLib.eqr(tipo,"2")) {
            /* _notit := True */
            _notit = true;
            /* If fonte='D' */
            if (CPLib.eqr(fonte,"D")) {
              // * --- Select from intestit
              m_cServer = m_Ctx.GetServer("intestit");
              m_cPhName = m_Ctx.GetPhName("intestit");
              if (Cursor_intestit!=null)
                Cursor_intestit.Close();
              Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwintestbo.CODINTER,"?",0,0,m_cServer, m_oParameters),m_cServer,rwintestbo.CODINTER)+"  and  (STATOREG <> '2'  or  STATOREG <> '3'  or  STATOREG is null) "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_intestit.Eof())) {
                /* _notit := False */
                _notit = false;
                // Exit Loop
                if (true) {
                  break;
                }
                Cursor_intestit.Next();
              }
              m_cConnectivityError = Cursor_intestit.ErrorMessage();
              Cursor_intestit.Close();
              // * --- End Select
              /* ElseIf fonte='P' */
            } else if (CPLib.eqr(fonte,"P")) {
              // * --- Select from xntestit
              m_cServer = m_Ctx.GetServer("xntestit");
              m_cPhName = m_Ctx.GetPhName("xntestit");
              if (Cursor_xntestit!=null)
                Cursor_xntestit.Close();
              Cursor_xntestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwintestbo.CODINTER,"?",0,0,m_cServer, m_oParameters),m_cServer,rwintestbo.CODINTER)+"  and  (STATOREG <> '2'  or  STATOREG <> '3'  or  STATOREG is null) "+")"+(m_Ctx.IsSharedTemp("xntestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_xntestit.Eof())) {
                /* _notit := False */
                _notit = false;
                // Exit Loop
                if (true) {
                  break;
                }
                Cursor_xntestit.Next();
              }
              m_cConnectivityError = Cursor_xntestit.ErrorMessage();
              Cursor_xntestit.Close();
              // * --- End Select
              /* ElseIf fonte='J' */
            } else if (CPLib.eqr(fonte,"J")) {
              // * --- Select from jntestit
              m_cServer = m_Ctx.GetServer("jntestit");
              m_cPhName = m_Ctx.GetPhName("jntestit");
              if (Cursor_jntestit!=null)
                Cursor_jntestit.Close();
              Cursor_jntestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwintestbo.CODINTER,"?",0,0,m_cServer, m_oParameters),m_cServer,rwintestbo.CODINTER)+"  and  (STATOREG <> '2'  or  STATOREG <> '3'  or  STATOREG is null) "+")"+(m_Ctx.IsSharedTemp("jntestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_jntestit.Eof())) {
                /* _notit := False */
                _notit = false;
                // Exit Loop
                if (true) {
                  break;
                }
                Cursor_jntestit.Next();
              }
              m_cConnectivityError = Cursor_jntestit.ErrorMessage();
              Cursor_jntestit.Close();
              // * --- End Select
              /* ElseIf fonte='W' */
            } else if (CPLib.eqr(fonte,"W")) {
              // * --- Select from wntestit
              m_cServer = m_Ctx.GetServer("wntestit");
              m_cPhName = m_Ctx.GetPhName("wntestit");
              if (Cursor_wntestit!=null)
                Cursor_wntestit.Close();
              Cursor_wntestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwintestbo.CODINTER,"?",0,0,m_cServer, m_oParameters),m_cServer,rwintestbo.CODINTER)+"  and  (STATOREG <> '2'  or  STATOREG <> '3'  or  STATOREG is null) "+")"+(m_Ctx.IsSharedTemp("wntestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_wntestit.Eof())) {
                /* _notit := False */
                _notit = false;
                // Exit Loop
                if (true) {
                  break;
                }
                Cursor_wntestit.Next();
              }
              m_cConnectivityError = Cursor_wntestit.ErrorMessage();
              Cursor_wntestit.Close();
              // * --- End Select
            } // End If
          } // End If
          /* If (_notit and (tipo='1' or tipo='2')) or (tipo<>'1' or tipo<>'2') */
          if ((_notit && (CPLib.eqr(tipo,"1") || CPLib.eqr(tipo,"2"))) || (CPLib.ne(tipo,"1") || CPLib.ne(tipo,"2"))) {
            /* _destipsog := "INTESTATARIO" */
            _destipsog = "INTESTATARIO";
            /* row := sheet.createRow(riga) // riga del foglio */
            row = sheet.createRow(riga);
            /* row.setRowStyle(stylebody) // riga del foglio */
            row.setRowStyle(stylebody);
            /* cell := row.createCell(0) // cella */
            cell = row.createCell(0);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(rapporto) // cella */
            cell.setCellValue(rapporto);
            /* cell := row.createCell(1) // cella */
            cell = row.createCell(1);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(descrap) // cella */
            cell.setCellValue(descrap);
            /* cell := row.createCell(2) // cella */
            cell = row.createCell(2);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(tiprap) // cella */
            cell.setCellValue(tiprap);
            /* cell := row.createCell(3) // cella */
            cell = row.createCell(3);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(valuta) // cella */
            cell.setCellValue(valuta);
            /* cell := row.createCell(4) // cella */
            cell = row.createCell(4);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(_customerid) // cella */
            cell.setCellValue(_customerid);
            /* cell := row.createCell(5) // cella */
            cell = row.createCell(5);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(_scopo) // cella */
            cell.setCellValue(_scopo);
            /* cell := row.createCell(6) // cella */
            cell = row.createCell(6);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(_natura) // cella */
            cell.setCellValue(_natura);
            /* cell := row.createCell(7) // cella */
            cell = row.createCell(7);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(_datprof) // cella */
            cell.setCellValue(_datprof);
            /* cell := row.createCell(8) // cella */
            cell = row.createCell(8);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(_risglob) // cella */
            cell.setCellValue(_risglob);
            /* cell := row.createCell(9) // cella */
            cell = row.createCell(9);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(_datrevprof) // cella */
            cell.setCellValue(_datrevprof);
            /* cell := row.createCell(10) // cella */
            cell = row.createCell(10);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(cf) // cella */
            cell.setCellValue(cf);
            /* cell := row.createCell(11) // cella */
            cell = row.createCell(11);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(_ragsoc) // cella */
            cell.setCellValue(_ragsoc);
            /* cell := row.createCell(12) // cella */
            cell = row.createCell(12);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(stares) // cella */
            cell.setCellValue(stares);
            /* cell := row.createCell(13) // cella */
            cell = row.createCell(13);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(citres) // cella */
            cell.setCellValue(citres);
            /* cell := row.createCell(14) // cella */
            cell = row.createCell(14);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(indirizzo) // cella */
            cell.setCellValue(indirizzo);
            /* cell := row.createCell(15) // cella */
            cell = row.createCell(15);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(capres) // cella */
            cell.setCellValue(capres);
            /* cell := row.createCell(16) // cella */
            cell = row.createCell(16);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(cabres) // cella */
            cell.setCellValue(cabres);
            /* cell := row.createCell(17) // cella */
            cell = row.createCell(17);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(prvres) // cella */
            cell.setCellValue(prvres);
            /* cell := row.createCell(18) // cella */
            cell = row.createCell(18);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(luonas) // cella */
            cell.setCellValue(luonas);
            /* cell := row.createCell(19) // cella */
            cell = row.createCell(19);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(prvnas) // cella */
            cell.setCellValue(prvnas);
            /* cell := row.createCell(20) // cella */
            cell = row.createCell(20);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(datnas) // cella */
            cell.setCellValue(datnas);
            /* cell := row.createCell(21) // cella */
            cell = row.createCell(21);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(sesso) // cella */
            cell.setCellValue(sesso);
            /* cell := row.createCell(22) // cella */
            cell = row.createCell(22);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(tipdoc) // cella */
            cell.setCellValue(tipdoc);
            /* cell := row.createCell(23) // cella */
            cell = row.createCell(23);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(numdoc) // cella */
            cell.setCellValue(numdoc);
            /* cell := row.createCell(24) // cella */
            cell = row.createCell(24);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(datril) // cella */
            cell.setCellValue(datril);
            /* cell := row.createCell(25) // cella */
            cell = row.createCell(25);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(autril) // cella */
            cell.setCellValue(autril);
            /* cell := row.createCell(26) // cella */
            cell = row.createCell(26);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(connes) // cella */
            cell.setCellValue(connes);
            /* cell := row.createCell(27) // cella */
            cell = row.createCell(27);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(_sae) // cella */
            cell.setCellValue(_sae);
            /* cell := row.createCell(28) // cella */
            cell = row.createCell(28);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(_dsae) // cella */
            cell.setCellValue(_dsae);
            /* cell := row.createCell(29) // cella */
            cell = row.createCell(29);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(_rae) // cella */
            cell.setCellValue(_rae);
            /* cell := row.createCell(30) // cella */
            cell = row.createCell(30);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(_drae) // cella */
            cell.setCellValue(_drae);
            /* cell := row.createCell(31) // cella */
            cell = row.createCell(31);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(_ateco) // cella */
            cell.setCellValue(_ateco);
            /* cell := row.createCell(32) // cella */
            cell = row.createCell(32);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(_dateco) // cella */
            cell.setCellValue(_dateco);
            /* cell := row.createCell(33) // cella */
            cell = row.createCell(33);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(_ssin) // cella */
            cell.setCellValue(_ssin);
            /* cell := row.createCell(34) // cella */
            cell = row.createCell(34);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(_dssin) // cella */
            cell.setCellValue(_dssin);
            /* cell := row.createCell(35) // cella */
            cell = row.createCell(35);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(dataini) // cella */
            cell.setCellValue(dataini);
            /* cell := row.createCell(36) // cella */
            cell = row.createCell(36);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(datafin) // cella */
            cell.setCellValue(datafin);
            /* cell := row.createCell(37) // cella */
            cell = row.createCell(37);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(_destipsog) // cella */
            cell.setCellValue(_destipsog);
            /* cell := row.createCell(38) // cella */
            cell = row.createCell(38);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(_cognome) // cella */
            cell.setCellValue(_cognome);
            /* cell := row.createCell(39) // cella */
            cell = row.createCell(39);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(_nome) // cella */
            cell.setCellValue(_nome);
            /* cell := row.createCell(40) // cella */
            cell = row.createCell(40);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(_datprofs) // cella */
            cell.setCellValue(_datprofs);
            /* cell := row.createCell(41) // cella */
            cell = row.createCell(41);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(_risglobs) // cella */
            cell.setCellValue(_risglobs);
            /* cell := row.createCell(42) // cella */
            cell = row.createCell(42);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(_datrevprofs) // cella */
            cell.setCellValue(_datrevprofs);
            riga = riga + 1;
          } // End If
          /* If flgtit */
          if (flgtit) {
            /* If fonte='D' */
            if (CPLib.eqr(fonte,"D")) {
              // * --- Fill memory cursor mcintestit on intestit
              mcintestit.Zap();
              m_cServer = m_Ctx.GetServer("intestit");
              m_cPhName = m_Ctx.GetPhName("intestit");
              if (Cursor_intestit!=null)
                Cursor_intestit.Close();
              Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwintestbo.CODINTER,"?",0,0,m_cServer, m_oParameters),m_cServer,rwintestbo.CODINTER)+"  and  (STATOREG <> '2'  or  STATOREG <> '3') "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              {
                final CPResultSet m_TheCursor = Cursor_intestit;
                Cursor_intestit.ActionOnClose(new Runnable() {
                  public void run() {
                    if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                      com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                      if ( ! (CPLib.IsNull(info))) {
                        info.log("Routine arrt_stprappo_all: query on intestit returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                      }
                    }
                  }
                  });
              }
              while ( ! (Cursor_intestit.Eof())) {
                mcintestit.AppendBlank();
                mcintestit.row.CODCLI = Cursor_intestit.GetString("CODCLI");
                mcintestit.row.RAPPORTO = Cursor_intestit.GetString("RAPPORTO");
                mcintestit.row.CODINTER = Cursor_intestit.GetString("CODINTER");
                mcintestit.row.DESCINTER = Cursor_intestit.GetString("DESCINTER");
                mcintestit.row.DATAINI = Cursor_intestit.GetDate("DATAINI");
                mcintestit.row.TIPORAP = Cursor_intestit.GetString("TIPORAP");
                mcintestit.row.TIPOPERS = Cursor_intestit.GetString("TIPOPERS");
                mcintestit.row.STATOREG = Cursor_intestit.GetString("STATOREG");
                mcintestit.row.OPERAZMOD = Cursor_intestit.GetString("OPERAZMOD");
                mcintestit.row.DATARETT = Cursor_intestit.GetDate("DATARETT");
                mcintestit.row.IDEREG = Cursor_intestit.GetString("IDEREG");
                mcintestit.row.COLLEGAMEN = Cursor_intestit.GetString("COLLEGAMEN");
                mcintestit.row.DATAFINE = Cursor_intestit.GetDate("DATAFINE");
                mcintestit.row.NUMPROG1 = Cursor_intestit.GetString("NUMPROG1");
                mcintestit.row.NUMPROG2 = Cursor_intestit.GetString("NUMPROG2");
                mcintestit.row.IDBASE = Cursor_intestit.GetString("IDBASE");
                mcintestit.row.UCODE = Cursor_intestit.GetString("UCODE");
                mcintestit.row.ABBINATO = Cursor_intestit.GetDouble("ABBINATO");
                mcintestit.row.PRGIMPTITE = Cursor_intestit.GetDouble("PRGIMPTITE");
                mcintestit.row.NUMIMP = Cursor_intestit.GetDateTime("NUMIMP");
                mcintestit.row.NOAGE = Cursor_intestit.GetString("NOAGE");
                Cursor_intestit.Next();
              }
              m_cConnectivityError = Cursor_intestit.ErrorMessage();
              Cursor_intestit.Close();
              mcintestit.GoTop();
              /* ElseIf fonte='P' */
            } else if (CPLib.eqr(fonte,"P")) {
              // * --- Fill memory cursor mcintestit on xntestit
              mcintestit.Zap();
              m_cServer = m_Ctx.GetServer("xntestit");
              m_cPhName = m_Ctx.GetPhName("xntestit");
              if (Cursor_xntestit!=null)
                Cursor_xntestit.Close();
              Cursor_xntestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwintestbo.CODINTER,"?",0,0,m_cServer, m_oParameters),m_cServer,rwintestbo.CODINTER)+" "+")"+(m_Ctx.IsSharedTemp("xntestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              {
                final CPResultSet m_TheCursor = Cursor_xntestit;
                Cursor_xntestit.ActionOnClose(new Runnable() {
                  public void run() {
                    if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                      com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                      if ( ! (CPLib.IsNull(info))) {
                        info.log("Routine arrt_stprappo_all: query on xntestit returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                      }
                    }
                  }
                  });
              }
              while ( ! (Cursor_xntestit.Eof())) {
                mcintestit.AppendBlank();
                mcintestit.row.CODCLI = Cursor_xntestit.GetString("CODCLI");
                mcintestit.row.RAPPORTO = Cursor_xntestit.GetString("RAPPORTO");
                mcintestit.row.CODINTER = Cursor_xntestit.GetString("CODINTER");
                mcintestit.row.DESCINTER = Cursor_xntestit.GetString("DESCINTER");
                mcintestit.row.DATAINI = Cursor_xntestit.GetDate("DATAINI");
                mcintestit.row.TIPORAP = Cursor_xntestit.GetString("TIPORAP");
                mcintestit.row.TIPOPERS = Cursor_xntestit.GetString("TIPOPERS");
                mcintestit.row.STATOREG = Cursor_xntestit.GetString("STATOREG");
                mcintestit.row.OPERAZMOD = Cursor_xntestit.GetString("OPERAZMOD");
                mcintestit.row.DATARETT = Cursor_xntestit.GetDate("DATARETT");
                mcintestit.row.IDEREG = Cursor_xntestit.GetString("IDEREG");
                mcintestit.row.COLLEGAMEN = Cursor_xntestit.GetString("COLLEGAMEN");
                mcintestit.row.DATAFINE = Cursor_xntestit.GetDate("DATAFINE");
                mcintestit.row.NUMPROG1 = Cursor_xntestit.GetString("NUMPROG1");
                mcintestit.row.NUMPROG2 = Cursor_xntestit.GetString("NUMPROG2");
                mcintestit.row.IDBASE = Cursor_xntestit.GetString("IDBASE");
                mcintestit.row.UCODE = Cursor_xntestit.GetString("UCODE");
                mcintestit.row.ABBINATO = Cursor_xntestit.GetDouble("ABBINATO");
                mcintestit.row.PRGIMPTITE = Cursor_xntestit.GetDouble("PRGIMPTITE");
                mcintestit.row.NUMIMP = Cursor_xntestit.GetDateTime("NUMIMP");
                mcintestit.row.NOAGE = Cursor_xntestit.GetString("NOAGE");
                Cursor_xntestit.Next();
              }
              m_cConnectivityError = Cursor_xntestit.ErrorMessage();
              Cursor_xntestit.Close();
              mcintestit.GoTop();
              /* ElseIf fonte='J' */
            } else if (CPLib.eqr(fonte,"J")) {
              // * --- Fill memory cursor mcintestit on jntestit
              mcintestit.Zap();
              m_cServer = m_Ctx.GetServer("jntestit");
              m_cPhName = m_Ctx.GetPhName("jntestit");
              if (Cursor_jntestit!=null)
                Cursor_jntestit.Close();
              Cursor_jntestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwintestbo.CODINTER,"?",0,0,m_cServer, m_oParameters),m_cServer,rwintestbo.CODINTER)+" "+")"+(m_Ctx.IsSharedTemp("jntestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              {
                final CPResultSet m_TheCursor = Cursor_jntestit;
                Cursor_jntestit.ActionOnClose(new Runnable() {
                  public void run() {
                    if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                      com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                      if ( ! (CPLib.IsNull(info))) {
                        info.log("Routine arrt_stprappo_all: query on jntestit returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                      }
                    }
                  }
                  });
              }
              while ( ! (Cursor_jntestit.Eof())) {
                mcintestit.AppendBlank();
                mcintestit.row.CODCLI = Cursor_jntestit.GetString("CODCLI");
                mcintestit.row.RAPPORTO = Cursor_jntestit.GetString("RAPPORTO");
                mcintestit.row.CODINTER = Cursor_jntestit.GetString("CODINTER");
                mcintestit.row.DESCINTER = Cursor_jntestit.GetString("DESCINTER");
                mcintestit.row.DATAINI = Cursor_jntestit.GetDate("DATAINI");
                mcintestit.row.TIPORAP = Cursor_jntestit.GetString("TIPORAP");
                mcintestit.row.TIPOPERS = Cursor_jntestit.GetString("TIPOPERS");
                mcintestit.row.STATOREG = Cursor_jntestit.GetString("STATOREG");
                mcintestit.row.OPERAZMOD = Cursor_jntestit.GetString("OPERAZMOD");
                mcintestit.row.DATARETT = Cursor_jntestit.GetDate("DATARETT");
                mcintestit.row.IDEREG = Cursor_jntestit.GetString("IDEREG");
                mcintestit.row.COLLEGAMEN = Cursor_jntestit.GetString("COLLEGAMEN");
                mcintestit.row.DATAFINE = Cursor_jntestit.GetDate("DATAFINE");
                mcintestit.row.NUMPROG1 = Cursor_jntestit.GetString("NUMPROG1");
                mcintestit.row.NUMPROG2 = Cursor_jntestit.GetString("NUMPROG2");
                mcintestit.row.IDBASE = Cursor_jntestit.GetString("IDBASE");
                mcintestit.row.UCODE = Cursor_jntestit.GetString("UCODE");
                mcintestit.row.ABBINATO = Cursor_jntestit.GetDouble("ABBINATO");
                mcintestit.row.PRGIMPTITE = Cursor_jntestit.GetDouble("PRGIMPTITE");
                mcintestit.row.NUMIMP = Cursor_jntestit.GetDateTime("NUMIMP");
                mcintestit.row.NOAGE = Cursor_jntestit.GetString("NOAGE");
                Cursor_jntestit.Next();
              }
              m_cConnectivityError = Cursor_jntestit.ErrorMessage();
              Cursor_jntestit.Close();
              mcintestit.GoTop();
              /* If aui */
              if (aui) {
                // * --- Fill memory cursor mcintestit on intestit
                mcintestit.GoBottom();
                m_cServer = m_Ctx.GetServer("intestit");
                m_cPhName = m_Ctx.GetPhName("intestit");
                if (Cursor_intestit!=null)
                  Cursor_intestit.Close();
                Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwintestbo.CODINTER,"?",0,0,m_cServer, m_oParameters),m_cServer,rwintestbo.CODINTER)+"  and  (STATOREG <> '2' or  STATOREG <> '3')  and  NOAGE<>'S' "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                {
                  final CPResultSet m_TheCursor = Cursor_intestit;
                  Cursor_intestit.ActionOnClose(new Runnable() {
                    public void run() {
                      if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                        com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                        if ( ! (CPLib.IsNull(info))) {
                          info.log("Routine arrt_stprappo_all: query on intestit returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                        }
                      }
                    }
                    });
                }
                while ( ! (Cursor_intestit.Eof())) {
                  mcintestit.AppendBlank();
                  mcintestit.row.CODCLI = Cursor_intestit.GetString("CODCLI");
                  mcintestit.row.RAPPORTO = Cursor_intestit.GetString("RAPPORTO");
                  mcintestit.row.CODINTER = Cursor_intestit.GetString("CODINTER");
                  mcintestit.row.DESCINTER = Cursor_intestit.GetString("DESCINTER");
                  mcintestit.row.DATAINI = Cursor_intestit.GetDate("DATAINI");
                  mcintestit.row.TIPORAP = Cursor_intestit.GetString("TIPORAP");
                  mcintestit.row.TIPOPERS = Cursor_intestit.GetString("TIPOPERS");
                  mcintestit.row.STATOREG = Cursor_intestit.GetString("STATOREG");
                  mcintestit.row.OPERAZMOD = Cursor_intestit.GetString("OPERAZMOD");
                  mcintestit.row.DATARETT = Cursor_intestit.GetDate("DATARETT");
                  mcintestit.row.IDEREG = Cursor_intestit.GetString("IDEREG");
                  mcintestit.row.COLLEGAMEN = Cursor_intestit.GetString("COLLEGAMEN");
                  mcintestit.row.DATAFINE = Cursor_intestit.GetDate("DATAFINE");
                  mcintestit.row.NUMPROG1 = Cursor_intestit.GetString("NUMPROG1");
                  mcintestit.row.NUMPROG2 = Cursor_intestit.GetString("NUMPROG2");
                  mcintestit.row.IDBASE = Cursor_intestit.GetString("IDBASE");
                  mcintestit.row.UCODE = Cursor_intestit.GetString("UCODE");
                  mcintestit.row.ABBINATO = Cursor_intestit.GetDouble("ABBINATO");
                  mcintestit.row.PRGIMPTITE = Cursor_intestit.GetDouble("PRGIMPTITE");
                  mcintestit.row.NUMIMP = Cursor_intestit.GetDateTime("NUMIMP");
                  mcintestit.row.NOAGE = Cursor_intestit.GetString("NOAGE");
                  Cursor_intestit.Next();
                }
                m_cConnectivityError = Cursor_intestit.ErrorMessage();
                Cursor_intestit.Close();
                mcintestit.GoTop();
              } // End If
            } // End If
            for (MemoryCursorRow_intestit rwintestit : mcintestit._iterable_()) {
              /* dataini := arfn_fdate(rwintestit.DATAINI) */
              dataini = arfn_fdateR.Make(m_Ctx,this).Run(rwintestit.DATAINI);
              /* datafin := arfn_fdate(rwintestit.DATAFINE) */
              datafin = arfn_fdateR.Make(m_Ctx,this).Run(rwintestit.DATAFINE);
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
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwintestit.CODINTER,"?",0,0,m_cServer, m_oParameters),m_cServer,rwintestit.CODINTER)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
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
                    Error l_oErrorFault = new Error("Read on tbstati into routine arrt_stprappo_all returns two or more records. This item should return only a record.");
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
                    Error l_oErrorFault = new Error("Read on tbtipdoc into routine arrt_stprappo_all returns two or more records. This item should return only a record.");
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
                    Error l_oErrorFault = new Error("Read on tbstgru into routine arrt_stprappo_all returns two or more records. This item should return only a record.");
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
                    Error l_oErrorFault = new Error("Read on tbtipatt into routine arrt_stprappo_all returns two or more records. This item should return only a record.");
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
                    Error l_oErrorFault = new Error("Read on tbsetsin into routine arrt_stprappo_all returns two or more records. This item should return only a record.");
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
                    Error l_oErrorFault = new Error("Read on tbramgru into routine arrt_stprappo_all returns two or more records. This item should return only a record.");
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
                /* _risglobs := '' */
                _risglobs = "";
                /* If not(Empty(personbo->RISGLOB)) */
                if ( ! (CPLib.Empty(Cursor_personbo.GetString("RISGLOB")))) {
                  // * --- Read from tbrisglob
                  m_cServer = m_Ctx.GetServer("tbrisglob");
                  m_cPhName = m_Ctx.GetPhName("tbrisglob");
                  m_cSql = "";
                  m_cSql = m_cSql+"CODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("RISGLOB"),"C",3,0,m_cServer),m_cServer,Cursor_personbo.GetString("RISGLOB"));
                  if (m_Ctx.IsSharedTemp("tbrisglob")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _risglobs = Read_Cursor.GetString("DESCRI");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on tbrisglob into routine arrt_stprappo_all returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _risglobs = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* _risglobs := iif(Empty(_risglobs),'',LRTrim(personbo->RISGLOB)+"-"+ LRTrim(_risglobs)) */
                  _risglobs = (CPLib.Empty(_risglobs)?"":CPLib.LRTrim(Cursor_personbo.GetString("RISGLOB"))+"-"+CPLib.LRTrim(_risglobs));
                } // End If
                /* _datprofs := arfn_fdate(personbo->DATAPROF) */
                _datprofs = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_personbo.GetDate("DATAPROF"));
                /* _datrevprofs := arfn_fdate(personbo->DATAREVPROF) */
                _datrevprofs = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_personbo.GetDate("DATAREVPROF"));
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
              /* _destipsog := "TITOLARE" */
              _destipsog = "TITOLARE";
              /* row := sheet.createRow(riga) // riga del foglio */
              row = sheet.createRow(riga);
              /* row.setRowStyle(stylebody) // riga del foglio */
              row.setRowStyle(stylebody);
              /* cell := row.createCell(0) // cella */
              cell = row.createCell(0);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(rapporto) // cella */
              cell.setCellValue(rapporto);
              /* cell := row.createCell(1) // cella */
              cell = row.createCell(1);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(descrap) // cella */
              cell.setCellValue(descrap);
              /* cell := row.createCell(2) // cella */
              cell = row.createCell(2);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(tiprap) // cella */
              cell.setCellValue(tiprap);
              /* cell := row.createCell(3) // cella */
              cell = row.createCell(3);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(valuta) // cella */
              cell.setCellValue(valuta);
              /* cell := row.createCell(4) // cella */
              cell = row.createCell(4);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(_customerid) // cella */
              cell.setCellValue(_customerid);
              /* cell := row.createCell(5) // cella */
              cell = row.createCell(5);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(_scopo) // cella */
              cell.setCellValue(_scopo);
              /* cell := row.createCell(6) // cella */
              cell = row.createCell(6);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(_natura) // cella */
              cell.setCellValue(_natura);
              /* cell := row.createCell(7) // cella */
              cell = row.createCell(7);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(_datprof) // cella */
              cell.setCellValue(_datprof);
              /* cell := row.createCell(8) // cella */
              cell = row.createCell(8);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(_risglob) // cella */
              cell.setCellValue(_risglob);
              /* cell := row.createCell(9) // cella */
              cell = row.createCell(9);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(_datrevprof) // cella */
              cell.setCellValue(_datrevprof);
              /* cell := row.createCell(10) // cella */
              cell = row.createCell(10);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(cf) // cella */
              cell.setCellValue(cf);
              /* cell := row.createCell(11) // cella */
              cell = row.createCell(11);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(_ragsoc) // cella */
              cell.setCellValue(_ragsoc);
              /* cell := row.createCell(12) // cella */
              cell = row.createCell(12);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(stares) // cella */
              cell.setCellValue(stares);
              /* cell := row.createCell(13) // cella */
              cell = row.createCell(13);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(citres) // cella */
              cell.setCellValue(citres);
              /* cell := row.createCell(14) // cella */
              cell = row.createCell(14);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(indirizzo) // cella */
              cell.setCellValue(indirizzo);
              /* cell := row.createCell(15) // cella */
              cell = row.createCell(15);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(capres) // cella */
              cell.setCellValue(capres);
              /* cell := row.createCell(16) // cella */
              cell = row.createCell(16);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(cabres) // cella */
              cell.setCellValue(cabres);
              /* cell := row.createCell(17) // cella */
              cell = row.createCell(17);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(prvres) // cella */
              cell.setCellValue(prvres);
              /* cell := row.createCell(18) // cella */
              cell = row.createCell(18);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(luonas) // cella */
              cell.setCellValue(luonas);
              /* cell := row.createCell(19) // cella */
              cell = row.createCell(19);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(prvnas) // cella */
              cell.setCellValue(prvnas);
              /* cell := row.createCell(20) // cella */
              cell = row.createCell(20);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(datnas) // cella */
              cell.setCellValue(datnas);
              /* cell := row.createCell(21) // cella */
              cell = row.createCell(21);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(sesso) // cella */
              cell.setCellValue(sesso);
              /* cell := row.createCell(22) // cella */
              cell = row.createCell(22);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(tipdoc) // cella */
              cell.setCellValue(tipdoc);
              /* cell := row.createCell(23) // cella */
              cell = row.createCell(23);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(numdoc) // cella */
              cell.setCellValue(numdoc);
              /* cell := row.createCell(24) // cella */
              cell = row.createCell(24);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(datril) // cella */
              cell.setCellValue(datril);
              /* cell := row.createCell(25) // cella */
              cell = row.createCell(25);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(autril) // cella */
              cell.setCellValue(autril);
              /* cell := row.createCell(26) // cella */
              cell = row.createCell(26);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(connes) // cella */
              cell.setCellValue(connes);
              /* cell := row.createCell(27) // cella */
              cell = row.createCell(27);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(_sae) // cella */
              cell.setCellValue(_sae);
              /* cell := row.createCell(28) // cella */
              cell = row.createCell(28);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(_dsae) // cella */
              cell.setCellValue(_dsae);
              /* cell := row.createCell(29) // cella */
              cell = row.createCell(29);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(_rae) // cella */
              cell.setCellValue(_rae);
              /* cell := row.createCell(30) // cella */
              cell = row.createCell(30);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(_drae) // cella */
              cell.setCellValue(_drae);
              /* cell := row.createCell(31) // cella */
              cell = row.createCell(31);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(_ateco) // cella */
              cell.setCellValue(_ateco);
              /* cell := row.createCell(32) // cella */
              cell = row.createCell(32);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(_dateco) // cella */
              cell.setCellValue(_dateco);
              /* cell := row.createCell(33) // cella */
              cell = row.createCell(33);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(_ssin) // cella */
              cell.setCellValue(_ssin);
              /* cell := row.createCell(34) // cella */
              cell = row.createCell(34);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(_dssin) // cella */
              cell.setCellValue(_dssin);
              /* cell := row.createCell(35) // cella */
              cell = row.createCell(35);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(dataini) // cella */
              cell.setCellValue(dataini);
              /* cell := row.createCell(36) // cella */
              cell = row.createCell(36);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(datafin) // cella */
              cell.setCellValue(datafin);
              /* cell := row.createCell(37) // cella */
              cell = row.createCell(37);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(_destipsog) // cella */
              cell.setCellValue(_destipsog);
              /* cell := row.createCell(38) // cella */
              cell = row.createCell(38);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(_cognome) // cella */
              cell.setCellValue(_cognome);
              /* cell := row.createCell(39) // cella */
              cell = row.createCell(39);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(_nome) // cella */
              cell.setCellValue(_nome);
              /* cell := row.createCell(40) // cella */
              cell = row.createCell(40);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(_datprofs) // cella */
              cell.setCellValue(_datprofs);
              /* cell := row.createCell(41) // cella */
              cell = row.createCell(41);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(_risglobs) // cella */
              cell.setCellValue(_risglobs);
              /* cell := row.createCell(42) // cella */
              cell = row.createCell(42);
              m_Ctx.SetGlobalObject("cell",cell);
              /* cell.setCellValue(_datrevprofs) // cella */
              cell.setCellValue(_datrevprofs);
              riga = riga + 1;
            }
          } // End If
        }
        /* If not(Empty(rwqbe_rapporti_xls_dett.CODICELR)) and _crap */
        if ( ! (CPLib.Empty(rwqbe_rapporti_xls_dett.CODICELR)) && _crap) {
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
          Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwqbe_rapporti_xls_dett.CODICELR,"?",0,0,m_cServer, m_oParameters),m_cServer,rwqbe_rapporti_xls_dett.CODICELR)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
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
                Error l_oErrorFault = new Error("Read on tbstati into routine arrt_stprappo_all returns two or more records. This item should return only a record.");
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
                Error l_oErrorFault = new Error("Read on tbtipdoc into routine arrt_stprappo_all returns two or more records. This item should return only a record.");
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
                Error l_oErrorFault = new Error("Read on tbstgru into routine arrt_stprappo_all returns two or more records. This item should return only a record.");
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
                Error l_oErrorFault = new Error("Read on tbtipatt into routine arrt_stprappo_all returns two or more records. This item should return only a record.");
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
                Error l_oErrorFault = new Error("Read on tbsetsin into routine arrt_stprappo_all returns two or more records. This item should return only a record.");
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
                Error l_oErrorFault = new Error("Read on tbramgru into routine arrt_stprappo_all returns two or more records. This item should return only a record.");
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
            /* _risglobs := '' */
            _risglobs = "";
            /* If not(Empty(personbo->RISGLOB)) */
            if ( ! (CPLib.Empty(Cursor_personbo.GetString("RISGLOB")))) {
              // * --- Read from tbrisglob
              m_cServer = m_Ctx.GetServer("tbrisglob");
              m_cPhName = m_Ctx.GetPhName("tbrisglob");
              m_cSql = "";
              m_cSql = m_cSql+"CODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("RISGLOB"),"C",3,0,m_cServer),m_cServer,Cursor_personbo.GetString("RISGLOB"));
              if (m_Ctx.IsSharedTemp("tbrisglob")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _risglobs = Read_Cursor.GetString("DESCRI");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbrisglob into routine arrt_stprappo_all returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _risglobs = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* _risglobs := iif(Empty(_risglobs),'',LRTrim(personbo->RISGLOB)+"-"+ LRTrim(_risglobs)) */
              _risglobs = (CPLib.Empty(_risglobs)?"":CPLib.LRTrim(Cursor_personbo.GetString("RISGLOB"))+"-"+CPLib.LRTrim(_risglobs));
            } // End If
            /* _datprofs := arfn_fdate(personbo->DATAPROF) */
            _datprofs = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_personbo.GetDate("DATAPROF"));
            /* _datrevprofs := arfn_fdate(personbo->DATAREVPROF) */
            _datrevprofs = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_personbo.GetDate("DATAREVPROF"));
            Cursor_personbo.Next();
          }
          m_cConnectivityError = Cursor_personbo.ErrorMessage();
          Cursor_personbo.Close();
          // * --- End Select
          /* _destipsog := "LEGALE RAPPRESENTANTE" */
          _destipsog = "LEGALE RAPPRESENTANTE";
          /* row := sheet.createRow(riga) // riga del foglio */
          row = sheet.createRow(riga);
          /* row.setRowStyle(stylebody) // riga del foglio */
          row.setRowStyle(stylebody);
          /* cell := row.createCell(0) // cella */
          cell = row.createCell(0);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(rapporto) // cella */
          cell.setCellValue(rapporto);
          /* cell := row.createCell(1) // cella */
          cell = row.createCell(1);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(descrap) // cella */
          cell.setCellValue(descrap);
          /* cell := row.createCell(2) // cella */
          cell = row.createCell(2);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(tiprap) // cella */
          cell.setCellValue(tiprap);
          /* cell := row.createCell(3) // cella */
          cell = row.createCell(3);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(valuta) // cella */
          cell.setCellValue(valuta);
          /* cell := row.createCell(4) // cella */
          cell = row.createCell(4);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(_customerid) // cella */
          cell.setCellValue(_customerid);
          /* cell := row.createCell(5) // cella */
          cell = row.createCell(5);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(_scopo) // cella */
          cell.setCellValue(_scopo);
          /* cell := row.createCell(6) // cella */
          cell = row.createCell(6);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(_natura) // cella */
          cell.setCellValue(_natura);
          /* cell := row.createCell(7) // cella */
          cell = row.createCell(7);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(_datprof) // cella */
          cell.setCellValue(_datprof);
          /* cell := row.createCell(8) // cella */
          cell = row.createCell(8);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(_risglob) // cella */
          cell.setCellValue(_risglob);
          /* cell := row.createCell(9) // cella */
          cell = row.createCell(9);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(_datrevprof) // cella */
          cell.setCellValue(_datrevprof);
          /* cell := row.createCell(10) // cella */
          cell = row.createCell(10);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(cf) // cella */
          cell.setCellValue(cf);
          /* cell := row.createCell(11) // cella */
          cell = row.createCell(11);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(_ragsoc) // cella */
          cell.setCellValue(_ragsoc);
          /* cell := row.createCell(12) // cella */
          cell = row.createCell(12);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(stares) // cella */
          cell.setCellValue(stares);
          /* cell := row.createCell(13) // cella */
          cell = row.createCell(13);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(citres) // cella */
          cell.setCellValue(citres);
          /* cell := row.createCell(14) // cella */
          cell = row.createCell(14);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(indirizzo) // cella */
          cell.setCellValue(indirizzo);
          /* cell := row.createCell(15) // cella */
          cell = row.createCell(15);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(capres) // cella */
          cell.setCellValue(capres);
          /* cell := row.createCell(16) // cella */
          cell = row.createCell(16);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(cabres) // cella */
          cell.setCellValue(cabres);
          /* cell := row.createCell(17) // cella */
          cell = row.createCell(17);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(prvres) // cella */
          cell.setCellValue(prvres);
          /* cell := row.createCell(18) // cella */
          cell = row.createCell(18);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(luonas) // cella */
          cell.setCellValue(luonas);
          /* cell := row.createCell(19) // cella */
          cell = row.createCell(19);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(prvnas) // cella */
          cell.setCellValue(prvnas);
          /* cell := row.createCell(20) // cella */
          cell = row.createCell(20);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(datnas) // cella */
          cell.setCellValue(datnas);
          /* cell := row.createCell(21) // cella */
          cell = row.createCell(21);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(sesso) // cella */
          cell.setCellValue(sesso);
          /* cell := row.createCell(22) // cella */
          cell = row.createCell(22);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(tipdoc) // cella */
          cell.setCellValue(tipdoc);
          /* cell := row.createCell(23) // cella */
          cell = row.createCell(23);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(numdoc) // cella */
          cell.setCellValue(numdoc);
          /* cell := row.createCell(24) // cella */
          cell = row.createCell(24);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(datril) // cella */
          cell.setCellValue(datril);
          /* cell := row.createCell(25) // cella */
          cell = row.createCell(25);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(autril) // cella */
          cell.setCellValue(autril);
          /* cell := row.createCell(26) // cella */
          cell = row.createCell(26);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(connes) // cella */
          cell.setCellValue(connes);
          /* cell := row.createCell(27) // cella */
          cell = row.createCell(27);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(_sae) // cella */
          cell.setCellValue(_sae);
          /* cell := row.createCell(28) // cella */
          cell = row.createCell(28);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(_dsae) // cella */
          cell.setCellValue(_dsae);
          /* cell := row.createCell(29) // cella */
          cell = row.createCell(29);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(_rae) // cella */
          cell.setCellValue(_rae);
          /* cell := row.createCell(30) // cella */
          cell = row.createCell(30);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(_drae) // cella */
          cell.setCellValue(_drae);
          /* cell := row.createCell(31) // cella */
          cell = row.createCell(31);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(_ateco) // cella */
          cell.setCellValue(_ateco);
          /* cell := row.createCell(32) // cella */
          cell = row.createCell(32);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(_dateco) // cella */
          cell.setCellValue(_dateco);
          /* cell := row.createCell(33) // cella */
          cell = row.createCell(33);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(_ssin) // cella */
          cell.setCellValue(_ssin);
          /* cell := row.createCell(34) // cella */
          cell = row.createCell(34);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(_dssin) // cella */
          cell.setCellValue(_dssin);
          /* cell := row.createCell(35) // cella */
          cell = row.createCell(35);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(dataini) // cella */
          cell.setCellValue(dataini);
          /* cell := row.createCell(36) // cella */
          cell = row.createCell(36);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(datafin) // cella */
          cell.setCellValue(datafin);
          /* cell := row.createCell(37) // cella */
          cell = row.createCell(37);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(_destipsog) // cella */
          cell.setCellValue(_destipsog);
          /* cell := row.createCell(38) // cella */
          cell = row.createCell(38);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(_cognome) // cella */
          cell.setCellValue(_cognome);
          /* cell := row.createCell(39) // cella */
          cell = row.createCell(39);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(_nome) // cella */
          cell.setCellValue(_nome);
          /* cell := row.createCell(40) // cella */
          cell = row.createCell(40);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(_datprofs) // cella */
          cell.setCellValue(_datprofs);
          /* cell := row.createCell(41) // cella */
          cell = row.createCell(41);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(_risglobs) // cella */
          cell.setCellValue(_risglobs);
          /* cell := row.createCell(42) // cella */
          cell = row.createCell(42);
          m_Ctx.SetGlobalObject("cell",cell);
          /* cell.setCellValue(_datrevprofs) // cella */
          cell.setCellValue(_datrevprofs);
          riga = riga + 1;
        } // End If
        /* If flgdel and _crap */
        if (flgdel && _crap) {
          /* If fonte='D' */
          if (CPLib.eqr(fonte,"D")) {
            // * --- Fill memory cursor mcdelegabo on delegabo
            mcdelegabo.Zap();
            m_cServer = m_Ctx.GetServer("delegabo");
            m_cPhName = m_Ctx.GetPhName("delegabo");
            if (Cursor_delegabo!=null)
              Cursor_delegabo.Close();
            Cursor_delegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwqbe_rapporti_xls_dett.RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,rwqbe_rapporti_xls_dett.RAPPORTO)+"  and  (STATOREG <> '2'  or  STATOREG <> '3') "+")"+(m_Ctx.IsSharedTemp("delegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            {
              final CPResultSet m_TheCursor = Cursor_delegabo;
              Cursor_delegabo.ActionOnClose(new Runnable() {
                public void run() {
                  if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                    com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                    if ( ! (CPLib.IsNull(info))) {
                      info.log("Routine arrt_stprappo_all: query on delegabo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                    }
                  }
                }
                });
            }
            while ( ! (Cursor_delegabo.Eof())) {
              mcdelegabo.AppendBlank();
              mcdelegabo.row.RAPPORTO = Cursor_delegabo.GetString("RAPPORTO");
              mcdelegabo.row.CPROWNUM = Cursor_delegabo.GetDouble("CPROWNUM");
              mcdelegabo.row.CODINTER = Cursor_delegabo.GetString("CODINTER");
              mcdelegabo.row.DESCINTER = Cursor_delegabo.GetString("DESCINTER");
              mcdelegabo.row.DATAINI = Cursor_delegabo.GetDate("DATAINI");
              mcdelegabo.row.TIPORAP = Cursor_delegabo.GetString("TIPORAP");
              mcdelegabo.row.TIPOPERS = Cursor_delegabo.GetString("TIPOPERS");
              mcdelegabo.row.STATOREG = Cursor_delegabo.GetString("STATOREG");
              mcdelegabo.row.OPERAZMOD = Cursor_delegabo.GetString("OPERAZMOD");
              mcdelegabo.row.DATARETT = Cursor_delegabo.GetDate("DATARETT");
              mcdelegabo.row.IDEREG = Cursor_delegabo.GetString("IDEREG");
              mcdelegabo.row.COLLEGAMEN = Cursor_delegabo.GetString("COLLEGAMEN");
              mcdelegabo.row.DATAFINE = Cursor_delegabo.GetDate("DATAFINE");
              mcdelegabo.row.NUMPROG1 = Cursor_delegabo.GetString("NUMPROG1");
              mcdelegabo.row.NUMPROG2 = Cursor_delegabo.GetString("NUMPROG2");
              mcdelegabo.row.IDBASE = Cursor_delegabo.GetString("IDBASE");
              mcdelegabo.row.UCODE = Cursor_delegabo.GetString("UCODE");
              mcdelegabo.row.ABBINATO = Cursor_delegabo.GetDouble("ABBINATO");
              mcdelegabo.row.NOAGE = Cursor_delegabo.GetString("NOAGE");
              mcdelegabo.row.NUMIMP = Cursor_delegabo.GetDateTime("NUMIMP");
              Cursor_delegabo.Next();
            }
            m_cConnectivityError = Cursor_delegabo.ErrorMessage();
            Cursor_delegabo.Close();
            mcdelegabo.GoTop();
            /* ElseIf fonte='P' */
          } else if (CPLib.eqr(fonte,"P")) {
            // * --- Fill memory cursor mcdelegabo on xelegabo
            mcdelegabo.Zap();
            m_cServer = m_Ctx.GetServer("xelegabo");
            m_cPhName = m_Ctx.GetPhName("xelegabo");
            if (Cursor_xelegabo!=null)
              Cursor_xelegabo.Close();
            Cursor_xelegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwqbe_rapporti_xls_dett.RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,rwqbe_rapporti_xls_dett.RAPPORTO)+" "+")"+(m_Ctx.IsSharedTemp("xelegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            {
              final CPResultSet m_TheCursor = Cursor_xelegabo;
              Cursor_xelegabo.ActionOnClose(new Runnable() {
                public void run() {
                  if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                    com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                    if ( ! (CPLib.IsNull(info))) {
                      info.log("Routine arrt_stprappo_all: query on xelegabo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                    }
                  }
                }
                });
            }
            while ( ! (Cursor_xelegabo.Eof())) {
              mcdelegabo.AppendBlank();
              mcdelegabo.row.RAPPORTO = Cursor_xelegabo.GetString("RAPPORTO");
              mcdelegabo.row.CPROWNUM = Cursor_xelegabo.GetDouble("CPROWNUM");
              mcdelegabo.row.CODINTER = Cursor_xelegabo.GetString("CODINTER");
              mcdelegabo.row.DESCINTER = Cursor_xelegabo.GetString("DESCINTER");
              mcdelegabo.row.DATAINI = Cursor_xelegabo.GetDate("DATAINI");
              mcdelegabo.row.TIPORAP = Cursor_xelegabo.GetString("TIPORAP");
              mcdelegabo.row.TIPOPERS = Cursor_xelegabo.GetString("TIPOPERS");
              mcdelegabo.row.STATOREG = Cursor_xelegabo.GetString("STATOREG");
              mcdelegabo.row.OPERAZMOD = Cursor_xelegabo.GetString("OPERAZMOD");
              mcdelegabo.row.DATARETT = Cursor_xelegabo.GetDate("DATARETT");
              mcdelegabo.row.IDEREG = Cursor_xelegabo.GetString("IDEREG");
              mcdelegabo.row.COLLEGAMEN = Cursor_xelegabo.GetString("COLLEGAMEN");
              mcdelegabo.row.DATAFINE = Cursor_xelegabo.GetDate("DATAFINE");
              mcdelegabo.row.NUMPROG1 = Cursor_xelegabo.GetString("NUMPROG1");
              mcdelegabo.row.NUMPROG2 = Cursor_xelegabo.GetString("NUMPROG2");
              mcdelegabo.row.IDBASE = Cursor_xelegabo.GetString("IDBASE");
              mcdelegabo.row.UCODE = Cursor_xelegabo.GetString("UCODE");
              mcdelegabo.row.ABBINATO = Cursor_xelegabo.GetDouble("ABBINATO");
              mcdelegabo.row.NOAGE = Cursor_xelegabo.GetString("NOAGE");
              mcdelegabo.row.NUMIMP = Cursor_xelegabo.GetDateTime("NUMIMP");
              Cursor_xelegabo.Next();
            }
            m_cConnectivityError = Cursor_xelegabo.ErrorMessage();
            Cursor_xelegabo.Close();
            mcdelegabo.GoTop();
            /* ElseIf fonte='J' */
          } else if (CPLib.eqr(fonte,"J")) {
            // * --- Fill memory cursor mcdelegabo on jelegabo
            mcdelegabo.Zap();
            m_cServer = m_Ctx.GetServer("jelegabo");
            m_cPhName = m_Ctx.GetPhName("jelegabo");
            if (Cursor_jelegabo!=null)
              Cursor_jelegabo.Close();
            Cursor_jelegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwqbe_rapporti_xls_dett.RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,rwqbe_rapporti_xls_dett.RAPPORTO)+" "+")"+(m_Ctx.IsSharedTemp("jelegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            {
              final CPResultSet m_TheCursor = Cursor_jelegabo;
              Cursor_jelegabo.ActionOnClose(new Runnable() {
                public void run() {
                  if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                    com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                    if ( ! (CPLib.IsNull(info))) {
                      info.log("Routine arrt_stprappo_all: query on jelegabo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                    }
                  }
                }
                });
            }
            while ( ! (Cursor_jelegabo.Eof())) {
              mcdelegabo.AppendBlank();
              mcdelegabo.row.RAPPORTO = Cursor_jelegabo.GetString("RAPPORTO");
              mcdelegabo.row.CPROWNUM = Cursor_jelegabo.GetDouble("CPROWNUM");
              mcdelegabo.row.CODINTER = Cursor_jelegabo.GetString("CODINTER");
              mcdelegabo.row.DESCINTER = Cursor_jelegabo.GetString("DESCINTER");
              mcdelegabo.row.DATAINI = Cursor_jelegabo.GetDate("DATAINI");
              mcdelegabo.row.TIPORAP = Cursor_jelegabo.GetString("TIPORAP");
              mcdelegabo.row.TIPOPERS = Cursor_jelegabo.GetString("TIPOPERS");
              mcdelegabo.row.STATOREG = Cursor_jelegabo.GetString("STATOREG");
              mcdelegabo.row.OPERAZMOD = Cursor_jelegabo.GetString("OPERAZMOD");
              mcdelegabo.row.DATARETT = Cursor_jelegabo.GetDate("DATARETT");
              mcdelegabo.row.IDEREG = Cursor_jelegabo.GetString("IDEREG");
              mcdelegabo.row.COLLEGAMEN = Cursor_jelegabo.GetString("COLLEGAMEN");
              mcdelegabo.row.DATAFINE = Cursor_jelegabo.GetDate("DATAFINE");
              mcdelegabo.row.NUMPROG1 = Cursor_jelegabo.GetString("NUMPROG1");
              mcdelegabo.row.NUMPROG2 = Cursor_jelegabo.GetString("NUMPROG2");
              mcdelegabo.row.IDBASE = Cursor_jelegabo.GetString("IDBASE");
              mcdelegabo.row.UCODE = Cursor_jelegabo.GetString("UCODE");
              mcdelegabo.row.ABBINATO = Cursor_jelegabo.GetDouble("ABBINATO");
              mcdelegabo.row.NOAGE = Cursor_jelegabo.GetString("NOAGE");
              mcdelegabo.row.NUMIMP = Cursor_jelegabo.GetDateTime("NUMIMP");
              Cursor_jelegabo.Next();
            }
            m_cConnectivityError = Cursor_jelegabo.ErrorMessage();
            Cursor_jelegabo.Close();
            mcdelegabo.GoTop();
            /* ElseIf fonte='W' */
          } else if (CPLib.eqr(fonte,"W")) {
            // * --- Fill memory cursor mcdelegabo on welegabo
            mcdelegabo.Zap();
            m_cServer = m_Ctx.GetServer("welegabo");
            m_cPhName = m_Ctx.GetPhName("welegabo");
            if (Cursor_welegabo!=null)
              Cursor_welegabo.Close();
            Cursor_welegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwqbe_rapporti_xls_dett.RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,rwqbe_rapporti_xls_dett.RAPPORTO)+" "+")"+(m_Ctx.IsSharedTemp("welegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            {
              final CPResultSet m_TheCursor = Cursor_welegabo;
              Cursor_welegabo.ActionOnClose(new Runnable() {
                public void run() {
                  if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                    com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                    if ( ! (CPLib.IsNull(info))) {
                      info.log("Routine arrt_stprappo_all: query on welegabo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                    }
                  }
                }
                });
            }
            while ( ! (Cursor_welegabo.Eof())) {
              mcdelegabo.AppendBlank();
              mcdelegabo.row.RAPPORTO = Cursor_welegabo.GetString("RAPPORTO");
              mcdelegabo.row.CPROWNUM = Cursor_welegabo.GetDouble("CPROWNUM");
              mcdelegabo.row.CODINTER = Cursor_welegabo.GetString("CODINTER");
              mcdelegabo.row.DESCINTER = Cursor_welegabo.GetString("DESCINTER");
              mcdelegabo.row.DATAINI = Cursor_welegabo.GetDate("DATAINI");
              mcdelegabo.row.TIPORAP = Cursor_welegabo.GetString("TIPORAP");
              mcdelegabo.row.TIPOPERS = Cursor_welegabo.GetString("TIPOPERS");
              mcdelegabo.row.STATOREG = Cursor_welegabo.GetString("STATOREG");
              mcdelegabo.row.OPERAZMOD = Cursor_welegabo.GetString("OPERAZMOD");
              mcdelegabo.row.DATARETT = Cursor_welegabo.GetDate("DATARETT");
              mcdelegabo.row.IDEREG = Cursor_welegabo.GetString("IDEREG");
              mcdelegabo.row.COLLEGAMEN = Cursor_welegabo.GetString("COLLEGAMEN");
              mcdelegabo.row.DATAFINE = Cursor_welegabo.GetDate("DATAFINE");
              mcdelegabo.row.NUMPROG1 = Cursor_welegabo.GetString("NUMPROG1");
              mcdelegabo.row.NUMPROG2 = Cursor_welegabo.GetString("NUMPROG2");
              mcdelegabo.row.IDBASE = Cursor_welegabo.GetString("IDBASE");
              mcdelegabo.row.UCODE = Cursor_welegabo.GetString("UCODE");
              mcdelegabo.row.ABBINATO = Cursor_welegabo.GetDouble("ABBINATO");
              mcdelegabo.row.NOAGE = Cursor_welegabo.GetString("NOAGE");
              mcdelegabo.row.NUMIMP = Cursor_welegabo.GetDateTime("NUMIMP");
              Cursor_welegabo.Next();
            }
            m_cConnectivityError = Cursor_welegabo.ErrorMessage();
            Cursor_welegabo.Close();
            mcdelegabo.GoTop();
          } // End If
          for (MemoryCursorRow_delegabo rwdelegabo : mcdelegabo._iterable_()) {
            /* connes := rwdelegabo.CODINTER */
            connes = rwdelegabo.CODINTER;
            /* dataini := arfn_fdate(rwdelegabo.DATAINI) */
            dataini = arfn_fdateR.Make(m_Ctx,this).Run(rwdelegabo.DATAINI);
            /* datafin := arfn_fdate(rwdelegabo.DATAFINE) */
            datafin = arfn_fdateR.Make(m_Ctx,this).Run(rwdelegabo.DATAFINE);
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
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwdelegabo.CODINTER,"?",0,0,m_cServer, m_oParameters),m_cServer,rwdelegabo.CODINTER)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
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
                  Error l_oErrorFault = new Error("Read on tbstati into routine arrt_stprappo_all returns two or more records. This item should return only a record.");
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
                  Error l_oErrorFault = new Error("Read on tbtipdoc into routine arrt_stprappo_all returns two or more records. This item should return only a record.");
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
                  Error l_oErrorFault = new Error("Read on tbstgru into routine arrt_stprappo_all returns two or more records. This item should return only a record.");
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
                  Error l_oErrorFault = new Error("Read on tbtipatt into routine arrt_stprappo_all returns two or more records. This item should return only a record.");
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
                  Error l_oErrorFault = new Error("Read on tbsetsin into routine arrt_stprappo_all returns two or more records. This item should return only a record.");
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
                  Error l_oErrorFault = new Error("Read on tbramgru into routine arrt_stprappo_all returns two or more records. This item should return only a record.");
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
              /* _risglobs := '' */
              _risglobs = "";
              /* If not(Empty(personbo->RISGLOB)) */
              if ( ! (CPLib.Empty(Cursor_personbo.GetString("RISGLOB")))) {
                // * --- Read from tbrisglob
                m_cServer = m_Ctx.GetServer("tbrisglob");
                m_cPhName = m_Ctx.GetPhName("tbrisglob");
                m_cSql = "";
                m_cSql = m_cSql+"CODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("RISGLOB"),"C",3,0,m_cServer),m_cServer,Cursor_personbo.GetString("RISGLOB"));
                if (m_Ctx.IsSharedTemp("tbrisglob")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _risglobs = Read_Cursor.GetString("DESCRI");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on tbrisglob into routine arrt_stprappo_all returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _risglobs = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* _risglobs := iif(Empty(_risglobs),'',LRTrim(personbo->RISGLOB)+"-"+ LRTrim(_risglobs)) */
                _risglobs = (CPLib.Empty(_risglobs)?"":CPLib.LRTrim(Cursor_personbo.GetString("RISGLOB"))+"-"+CPLib.LRTrim(_risglobs));
              } // End If
              /* _datprofs := arfn_fdate(personbo->DATAPROF) */
              _datprofs = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_personbo.GetDate("DATAPROF"));
              /* _datrevprofs := arfn_fdate(personbo->DATAREVPROF) */
              _datrevprofs = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_personbo.GetDate("DATAREVPROF"));
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
            /* _destipsog := "DELEGATO" */
            _destipsog = "DELEGATO";
            /* row := sheet.createRow(riga) // riga del foglio */
            row = sheet.createRow(riga);
            /* row.setRowStyle(stylebody) // riga del foglio */
            row.setRowStyle(stylebody);
            /* cell := row.createCell(0) // cella */
            cell = row.createCell(0);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(rapporto) // cella */
            cell.setCellValue(rapporto);
            /* cell := row.createCell(1) // cella */
            cell = row.createCell(1);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(descrap) // cella */
            cell.setCellValue(descrap);
            /* cell := row.createCell(2) // cella */
            cell = row.createCell(2);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(tiprap) // cella */
            cell.setCellValue(tiprap);
            /* cell := row.createCell(3) // cella */
            cell = row.createCell(3);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(valuta) // cella */
            cell.setCellValue(valuta);
            /* cell := row.createCell(4) // cella */
            cell = row.createCell(4);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(_customerid) // cella */
            cell.setCellValue(_customerid);
            /* cell := row.createCell(5) // cella */
            cell = row.createCell(5);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(_scopo) // cella */
            cell.setCellValue(_scopo);
            /* cell := row.createCell(6) // cella */
            cell = row.createCell(6);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(_natura) // cella */
            cell.setCellValue(_natura);
            /* cell := row.createCell(7) // cella */
            cell = row.createCell(7);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(_datprof) // cella */
            cell.setCellValue(_datprof);
            /* cell := row.createCell(8) // cella */
            cell = row.createCell(8);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(_risglob) // cella */
            cell.setCellValue(_risglob);
            /* cell := row.createCell(9) // cella */
            cell = row.createCell(9);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(_datrevprof) // cella */
            cell.setCellValue(_datrevprof);
            /* cell := row.createCell(10) // cella */
            cell = row.createCell(10);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(cf) // cella */
            cell.setCellValue(cf);
            /* cell := row.createCell(11) // cella */
            cell = row.createCell(11);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(_ragsoc) // cella */
            cell.setCellValue(_ragsoc);
            /* cell := row.createCell(12) // cella */
            cell = row.createCell(12);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(stares) // cella */
            cell.setCellValue(stares);
            /* cell := row.createCell(13) // cella */
            cell = row.createCell(13);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(citres) // cella */
            cell.setCellValue(citres);
            /* cell := row.createCell(14) // cella */
            cell = row.createCell(14);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(indirizzo) // cella */
            cell.setCellValue(indirizzo);
            /* cell := row.createCell(15) // cella */
            cell = row.createCell(15);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(capres) // cella */
            cell.setCellValue(capres);
            /* cell := row.createCell(16) // cella */
            cell = row.createCell(16);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(cabres) // cella */
            cell.setCellValue(cabres);
            /* cell := row.createCell(17) // cella */
            cell = row.createCell(17);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(prvres) // cella */
            cell.setCellValue(prvres);
            /* cell := row.createCell(18) // cella */
            cell = row.createCell(18);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(luonas) // cella */
            cell.setCellValue(luonas);
            /* cell := row.createCell(19) // cella */
            cell = row.createCell(19);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(prvnas) // cella */
            cell.setCellValue(prvnas);
            /* cell := row.createCell(20) // cella */
            cell = row.createCell(20);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(datnas) // cella */
            cell.setCellValue(datnas);
            /* cell := row.createCell(21) // cella */
            cell = row.createCell(21);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(sesso) // cella */
            cell.setCellValue(sesso);
            /* cell := row.createCell(22) // cella */
            cell = row.createCell(22);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(tipdoc) // cella */
            cell.setCellValue(tipdoc);
            /* cell := row.createCell(23) // cella */
            cell = row.createCell(23);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(numdoc) // cella */
            cell.setCellValue(numdoc);
            /* cell := row.createCell(24) // cella */
            cell = row.createCell(24);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(datril) // cella */
            cell.setCellValue(datril);
            /* cell := row.createCell(25) // cella */
            cell = row.createCell(25);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(autril) // cella */
            cell.setCellValue(autril);
            /* cell := row.createCell(26) // cella */
            cell = row.createCell(26);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(connes) // cella */
            cell.setCellValue(connes);
            /* cell := row.createCell(27) // cella */
            cell = row.createCell(27);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(_sae) // cella */
            cell.setCellValue(_sae);
            /* cell := row.createCell(28) // cella */
            cell = row.createCell(28);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(_dsae) // cella */
            cell.setCellValue(_dsae);
            /* cell := row.createCell(29) // cella */
            cell = row.createCell(29);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(_rae) // cella */
            cell.setCellValue(_rae);
            /* cell := row.createCell(30) // cella */
            cell = row.createCell(30);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(_drae) // cella */
            cell.setCellValue(_drae);
            /* cell := row.createCell(31) // cella */
            cell = row.createCell(31);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(_ateco) // cella */
            cell.setCellValue(_ateco);
            /* cell := row.createCell(32) // cella */
            cell = row.createCell(32);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(_dateco) // cella */
            cell.setCellValue(_dateco);
            /* cell := row.createCell(33) // cella */
            cell = row.createCell(33);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(_ssin) // cella */
            cell.setCellValue(_ssin);
            /* cell := row.createCell(34) // cella */
            cell = row.createCell(34);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(_dssin) // cella */
            cell.setCellValue(_dssin);
            /* cell := row.createCell(35) // cella */
            cell = row.createCell(35);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(dataini) // cella */
            cell.setCellValue(dataini);
            /* cell := row.createCell(36) // cella */
            cell = row.createCell(36);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(datafin) // cella */
            cell.setCellValue(datafin);
            /* cell := row.createCell(37) // cella */
            cell = row.createCell(37);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(_destipsog) // cella */
            cell.setCellValue(_destipsog);
            /* cell := row.createCell(38) // cella */
            cell = row.createCell(38);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(_cognome) // cella */
            cell.setCellValue(_cognome);
            /* cell := row.createCell(39) // cella */
            cell = row.createCell(39);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(_nome) // cella */
            cell.setCellValue(_nome);
            /* cell := row.createCell(40) // cella */
            cell = row.createCell(40);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(_datprofs) // cella */
            cell.setCellValue(_datprofs);
            /* cell := row.createCell(41) // cella */
            cell = row.createCell(41);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(_risglobs) // cella */
            cell.setCellValue(_risglobs);
            /* cell := row.createCell(42) // cella */
            cell = row.createCell(42);
            m_Ctx.SetGlobalObject("cell",cell);
            /* cell.setCellValue(_datrevprofs) // cella */
            cell.setCellValue(_datrevprofs);
            riga = riga + 1;
          }
        } // End If
      }
      for (int col = 0; CPLib.ne(col,maxcell+1); col = col + (1)) {
        /* sheet.autoSizeColumn(col) // Sheet file1 */
        sheet.autoSizeColumn(col);
      }
      /* Workbook.write(excellFile) // Workbook file */
      Workbook.write(excellFile);
      /* excellFile.flush() // FileOutputStream file */
      excellFile.flush();
      /* excellFile.close() // FileOutputStream file */
      excellFile.close();
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
        if (Cursor_qbe_rapporti_xls_dett_prov!=null)
          Cursor_qbe_rapporti_xls_dett_prov.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_rapporti_xls_dett_ae!=null)
          Cursor_qbe_rapporti_xls_dett_ae.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_rapporti_xls_dett_sto!=null)
          Cursor_qbe_rapporti_xls_dett_sto.Close();
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
        if (Cursor_xntestbo!=null)
          Cursor_xntestbo.Close();
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
        if (Cursor_wntestbo!=null)
          Cursor_wntestbo.Close();
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
        if (Cursor_intestit!=null)
          Cursor_intestit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xntestit!=null)
          Cursor_xntestit.Close();
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
        if (Cursor_wntestit!=null)
          Cursor_wntestit.Close();
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
      try {
        if (Cursor_xelegabo!=null)
          Cursor_xelegabo.Close();
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
      try {
        if (Cursor_welegabo!=null)
          Cursor_welegabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_fonte,String p_tipostp,String p_daRappo,String p_aRappo,String p_DaSogg,String p_ASogg,String p_coddip,java.sql.Date p_DaData,java.sql.Date p_AData,boolean p_detope,boolean p_detana,boolean p_flgtit,boolean p_flgdel,String p_tipo,boolean p_attiva,boolean p_mod_attiva,boolean p_cancellata,boolean p_mod_copia,boolean p_aui,String p_pTIPOAG,String p_pRISGLOB) {
    fonte = p_fonte;
    tipostp = p_tipostp;
    daRappo = p_daRappo;
    aRappo = p_aRappo;
    DaSogg = p_DaSogg;
    ASogg = p_ASogg;
    coddip = p_coddip;
    DaData = p_DaData;
    AData = p_AData;
    detope = p_detope;
    detana = p_detana;
    flgtit = p_flgtit;
    flgdel = p_flgdel;
    tipo = p_tipo;
    attiva = p_attiva;
    mod_attiva = p_mod_attiva;
    cancellata = p_cancellata;
    mod_copia = p_mod_copia;
    aui = p_aui;
    pTIPOAG = p_pTIPOAG;
    pRISGLOB = p_pRISGLOB;
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
  public Forward Run(String p_fonte,String p_tipostp,String p_daRappo,String p_aRappo,String p_DaSogg,String p_ASogg,String p_coddip,java.sql.Date p_DaData,java.sql.Date p_AData,boolean p_detope,boolean p_detana,boolean p_flgtit,boolean p_flgdel,String p_tipo,boolean p_attiva,boolean p_mod_attiva,boolean p_cancellata,boolean p_mod_copia,boolean p_aui,String p_pTIPOAG,String p_pRISGLOB) {
    fonte = p_fonte;
    tipostp = p_tipostp;
    daRappo = p_daRappo;
    aRappo = p_aRappo;
    DaSogg = p_DaSogg;
    ASogg = p_ASogg;
    coddip = p_coddip;
    DaData = p_DaData;
    AData = p_AData;
    detope = p_detope;
    detana = p_detana;
    flgtit = p_flgtit;
    flgdel = p_flgdel;
    tipo = p_tipo;
    attiva = p_attiva;
    mod_attiva = p_mod_attiva;
    cancellata = p_cancellata;
    mod_copia = p_mod_copia;
    aui = p_aui;
    pTIPOAG = p_pTIPOAG;
    pRISGLOB = p_pRISGLOB;
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
  public static arrt_stprappo_allR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_stprappo_allR(p_Ctx, p_Caller);
  }
  public void Blank() {
    fonte = CPLib.Space(1);
    tipostp = CPLib.Space(1);
    daRappo = CPLib.Space(25);
    aRappo = CPLib.Space(25);
    DaSogg = CPLib.Space(16);
    ASogg = CPLib.Space(16);
    coddip = CPLib.Space(6);
    DaData = CPLib.NullDate();
    AData = CPLib.NullDate();
    detope = false;
    detana = false;
    flgtit = false;
    flgdel = false;
    tipo = CPLib.Space(1);
    attiva = false;
    mod_attiva = false;
    cancellata = false;
    mod_copia = false;
    aui = false;
    pTIPOAG = CPLib.Space(2);
    pRISGLOB = CPLib.Space(1);
    nomefilexls = CPLib.Space(50);
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
    _scopo = CPLib.Space(50);
    _natura = CPLib.Space(50);
    _risglob = CPLib.Space(40);
    _datprof = CPLib.Space(10);
    _datrevprof = CPLib.Space(10);
    _desrisglob = CPLib.Space(150);
    _cognome = CPLib.Space(30);
    _nome = CPLib.Space(30);
    _risglobs = CPLib.Space(40);
    _datprofs = CPLib.Space(10);
    _datrevprofs = CPLib.Space(10);
    _destipsog = CPLib.Space(0);
    foglio = CPLib.Space(1);
    stringa = CPLib.Space(1);
    report_name = (detope?"arrp_stprappo2.vrp":"arrp_stprappo1.vrp");
    c_dadata = (CPLib.Empty(DaData)?"":CPLib.DateToChar(DaData));
    c_adata = (CPLib.Empty(AData)?"":CPLib.DateToChar(AData));
    mcdelegabo = new MemoryCursor_delegabo();
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    gDescAzi=m_Ctx.GetGlobalString("gDescAzi");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_allrapopebo,qbe_allxapopebo,qbe_allrapopebo_ae,qbe_allrapopebo_sto,qbe_rapporti_xls,qbe_rapporti_xls_prov,qbe_rapporti_xls_ae,qbe_rapporti_xls_sto,qbe_rapporti_xls_dett,qbe_rapporti_xls_dett_prov,qbe_rapporti_xls_dett_ae,qbe_rapporti_xls_dett_sto,
  public static final String m_cVQRList = ",qbe_allrapopebo,qbe_allxapopebo,qbe_allrapopebo_ae,qbe_allrapopebo_sto,qbe_rapporti_xls,qbe_rapporti_xls_prov,qbe_rapporti_xls_ae,qbe_rapporti_xls_sto,qbe_rapporti_xls_dett,qbe_rapporti_xls_dett_prov,qbe_rapporti_xls_dett_ae,qbe_rapporti_xls_dett_sto,";
  // ENTITY_BATCHES: ,arfn_fdate,
  public static final String i_InvokedRoutines = ",arfn_fdate,";
  public static String[] m_cRunParameterNames={"fonte","tipostp","daRappo","aRappo","DaSogg","ASogg","coddip","DaData","AData","detope","detana","flgtit","flgdel","tipo","attiva","mod_attiva","cancellata","mod_copia","aui","pTIPOAG","pRISGLOB"};
  protected static String GetFieldsName_00000067(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_00000070(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_00000073(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_00000076(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_00000079(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_0000007C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
