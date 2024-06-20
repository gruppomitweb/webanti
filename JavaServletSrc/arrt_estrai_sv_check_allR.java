// * --- Area Manuale = BO - Header
// * --- arrt_estrai_sv_check_all
import java.util.*;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;
import java.io.File;
import java.io.FileWriter;
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
// import com.opencsv.CSVWriter;
import com.opencsv.*;
import java.util.ArrayList;
// * --- Fine Area Manuale
public class arrt_estrai_sv_check_allR implements CallerWithObjs {
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
  public String m_cPhName_analisi_fr;
  public String m_cServer_analisi_fr;
  public String m_cPhName_analisi_sv;
  public String m_cServer_analisi_sv;
  public String m_cPhName_operazbo_agg;
  public String m_cServer_operazbo_agg;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public String m_cPhName_tbstgru;
  public String m_cServer_tbstgru;
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
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
  public double pAnno;
  public double pTri;
  public String pTipo;
  public String pFile;
  public String pTipoBase3;
  public String pFraudo;
  public String _datini;
  public String _datfin;
  public String _datinisem;
  public String _datfinsem;
  public String cRitorno;
  public String fhand;
  public String riga;
  public String nFile;
  public String outFileName;
  public String inFileName;
  public double _conta;
  public double _bottom;
  public double _top;
  public double _max;
  public double _cicli;
  public double _min;
  public double _mono;
  public double _tot;
  public double _reccount;
  public double _contarow;
  public String _tcont;
  public double _importo;
  public String _codcli;
  public String _sotgru;
  public String _cragsoc;
  public String _paeseres;
  public String _provres;
  public String _provage;
  public MemoryCursor_tbstati mcStati;
  public MemoryCursor_qbe_estrai_sv_ope_chk_all_vqr mcErrori;
  public MemoryCursor_qbe_estrai_sv_ope_tab_all_vqr mcDati;
  public String _nfile;
  public String _datope;
  public java.sql.Date _ddatini;
  public java.sql.Date _ddatfin;
  public java.sql.Date _dataoggi;
  public String _cdataoggi;
  public String _oldmsg;
  public String _valuta;
  public java.sql.Date _opedata;
  public java.sql.Date _operett;
  public String _opestato;
  public String _numsto;
  public MemoryCursor_qbe_statisv_vqr mcStatiSV;
  public MemoryCursor_qbe_provsv_vqr mcProvSV;
  public MemoryCursor_qbe_stgru_vqr mcStGru;
  public String _source;
  public MemoryCursor_qbe_estrai_sv_all_ip_1_vqr mcRapportiSVIP;
  public MemoryCursor_qbe_sv_idp_rapporti_vqr mcRapportiNS;
  public MemoryCursor_qbe_estrai_sv_all_ip_2_a_vqr mcOperazioniSVIP;
  public MemoryCursor_mcestraisv_clienti_mcrdef mcClientiSVIP;
  public MemoryCursorRow_mcestraisv_clienti_mcrdef rowClientiSVIP;
  public MemoryCursor_tbstgru mcTbSotgru;
  public MemoryCursor_mcerrsvip_mcrdef mcErroriSV_IP;
  public String _flgfraud;
  public String gAzienda;
  public String gIntemediario;
  public String gMsgImp;
  public String gMsgProc;
  public String gPathApp;
  public String gPathDoc;
  public String _pSegno;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_estrai_sv_check_all
  public int _i;
  public int _y;
  public int _righe;
  public int conta;
  public int r;
  String sheetName = "Foglio1";
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
  public CSVWriter cwriter;
  Vector filenames = new Vector();
  Vector fileonames = new Vector();
  // * --- Fine Area Manuale
  public arrt_estrai_sv_check_allR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_estrai_sv_check_all",m_Caller);
    m_cPhName_analisi_fr = p_ContextObject.GetPhName("analisi_fr");
    if (m_cPhName_analisi_fr.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_analisi_fr = m_cPhName_analisi_fr+" "+m_Ctx.GetWritePhName("analisi_fr");
    }
    m_cServer_analisi_fr = p_ContextObject.GetServer("analisi_fr");
    m_cPhName_analisi_sv = p_ContextObject.GetPhName("analisi_sv");
    if (m_cPhName_analisi_sv.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_analisi_sv = m_cPhName_analisi_sv+" "+m_Ctx.GetWritePhName("analisi_sv");
    }
    m_cServer_analisi_sv = p_ContextObject.GetServer("analisi_sv");
    m_cPhName_operazbo_agg = p_ContextObject.GetPhName("operazbo_agg");
    if (m_cPhName_operazbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo_agg = m_cPhName_operazbo_agg+" "+m_Ctx.GetWritePhName("operazbo_agg");
    }
    m_cServer_operazbo_agg = p_ContextObject.GetServer("operazbo_agg");
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
    m_cPhName_tbstgru = p_ContextObject.GetPhName("tbstgru");
    if (m_cPhName_tbstgru.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstgru = m_cPhName_tbstgru+" "+m_Ctx.GetWritePhName("tbstgru");
    }
    m_cServer_tbstgru = p_ContextObject.GetServer("tbstgru");
    m_cPhName_wersonbo = p_ContextObject.GetPhName("wersonbo");
    if (m_cPhName_wersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo = m_cPhName_wersonbo+" "+m_Ctx.GetWritePhName("wersonbo");
    }
    m_cServer_wersonbo = p_ContextObject.GetServer("wersonbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pAnno",p_cVarName)) {
      return pAnno;
    }
    if (CPLib.eqr("pTri",p_cVarName)) {
      return pTri;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      return _bottom;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      return _top;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      return _max;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      return _min;
    }
    if (CPLib.eqr("_mono",p_cVarName)) {
      return _mono;
    }
    if (CPLib.eqr("_tot",p_cVarName)) {
      return _tot;
    }
    if (CPLib.eqr("_reccount",p_cVarName)) {
      return _reccount;
    }
    if (CPLib.eqr("_contarow",p_cVarName)) {
      return _contarow;
    }
    if (CPLib.eqr("_importo",p_cVarName)) {
      return _importo;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_estrai_sv_check_all";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    if (CPLib.eqr("pFile",p_cVarName)) {
      return pFile;
    }
    if (CPLib.eqr("pTipoBase3",p_cVarName)) {
      return pTipoBase3;
    }
    if (CPLib.eqr("pFraudo",p_cVarName)) {
      return pFraudo;
    }
    if (CPLib.eqr("_datini",p_cVarName)) {
      return _datini;
    }
    if (CPLib.eqr("_datfin",p_cVarName)) {
      return _datfin;
    }
    if (CPLib.eqr("_datinisem",p_cVarName)) {
      return _datinisem;
    }
    if (CPLib.eqr("_datfinsem",p_cVarName)) {
      return _datfinsem;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      return cRitorno;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      return riga;
    }
    if (CPLib.eqr("nFile",p_cVarName)) {
      return nFile;
    }
    if (CPLib.eqr("outFileName",p_cVarName)) {
      return outFileName;
    }
    if (CPLib.eqr("inFileName",p_cVarName)) {
      return inFileName;
    }
    if (CPLib.eqr("_tcont",p_cVarName)) {
      return _tcont;
    }
    if (CPLib.eqr("_codcli",p_cVarName)) {
      return _codcli;
    }
    if (CPLib.eqr("_sotgru",p_cVarName)) {
      return _sotgru;
    }
    if (CPLib.eqr("_cragsoc",p_cVarName)) {
      return _cragsoc;
    }
    if (CPLib.eqr("_paeseres",p_cVarName)) {
      return _paeseres;
    }
    if (CPLib.eqr("_provres",p_cVarName)) {
      return _provres;
    }
    if (CPLib.eqr("_provage",p_cVarName)) {
      return _provage;
    }
    if (CPLib.eqr("_nfile",p_cVarName)) {
      return _nfile;
    }
    if (CPLib.eqr("_datope",p_cVarName)) {
      return _datope;
    }
    if (CPLib.eqr("_cdataoggi",p_cVarName)) {
      return _cdataoggi;
    }
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      return _oldmsg;
    }
    if (CPLib.eqr("_valuta",p_cVarName)) {
      return _valuta;
    }
    if (CPLib.eqr("_opestato",p_cVarName)) {
      return _opestato;
    }
    if (CPLib.eqr("_numsto",p_cVarName)) {
      return _numsto;
    }
    if (CPLib.eqr("_source",p_cVarName)) {
      return _source;
    }
    if (CPLib.eqr("_flgfraud",p_cVarName)) {
      return _flgfraud;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      return gIntemediario;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      return gPathDoc;
    }
    if (CPLib.eqr("_pSegno",p_cVarName)) {
      return _pSegno;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_ddatini",p_cVarName)) {
      return _ddatini;
    }
    if (CPLib.eqr("_ddatfin",p_cVarName)) {
      return _ddatfin;
    }
    if (CPLib.eqr("_dataoggi",p_cVarName)) {
      return _dataoggi;
    }
    if (CPLib.eqr("_opedata",p_cVarName)) {
      return _opedata;
    }
    if (CPLib.eqr("_operett",p_cVarName)) {
      return _operett;
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
    if (CPLib.eqr("mcStati",p_cVarName)) {
      return mcStati;
    }
    if (CPLib.eqr("mcErrori",p_cVarName)) {
      return mcErrori;
    }
    if (CPLib.eqr("mcDati",p_cVarName)) {
      return mcDati;
    }
    if (CPLib.eqr("mcStatiSV",p_cVarName)) {
      return mcStatiSV;
    }
    if (CPLib.eqr("mcProvSV",p_cVarName)) {
      return mcProvSV;
    }
    if (CPLib.eqr("mcStGru",p_cVarName)) {
      return mcStGru;
    }
    if (CPLib.eqr("mcRapportiSVIP",p_cVarName)) {
      return mcRapportiSVIP;
    }
    if (CPLib.eqr("mcRapportiNS",p_cVarName)) {
      return mcRapportiNS;
    }
    if (CPLib.eqr("mcOperazioniSVIP",p_cVarName)) {
      return mcOperazioniSVIP;
    }
    if (CPLib.eqr("mcClientiSVIP",p_cVarName)) {
      return mcClientiSVIP;
    }
    if (CPLib.eqr("mcTbSotgru",p_cVarName)) {
      return mcTbSotgru;
    }
    if (CPLib.eqr("mcErroriSV_IP",p_cVarName)) {
      return mcErroriSV_IP;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("rowClientiSVIP",p_cVarName)) {
      return rowClientiSVIP;
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("pAnno",p_cVarName)) {
      pAnno = value;
      return;
    }
    if (CPLib.eqr("pTri",p_cVarName)) {
      pTri = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
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
    if (CPLib.eqr("_max",p_cVarName)) {
      _max = value;
      return;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      _cicli = value;
      return;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      _min = value;
      return;
    }
    if (CPLib.eqr("_mono",p_cVarName)) {
      _mono = value;
      return;
    }
    if (CPLib.eqr("_tot",p_cVarName)) {
      _tot = value;
      return;
    }
    if (CPLib.eqr("_reccount",p_cVarName)) {
      _reccount = value;
      return;
    }
    if (CPLib.eqr("_contarow",p_cVarName)) {
      _contarow = value;
      return;
    }
    if (CPLib.eqr("_importo",p_cVarName)) {
      _importo = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
      return;
    }
    if (CPLib.eqr("pFile",p_cVarName)) {
      pFile = value;
      return;
    }
    if (CPLib.eqr("pTipoBase3",p_cVarName)) {
      pTipoBase3 = value;
      return;
    }
    if (CPLib.eqr("pFraudo",p_cVarName)) {
      pFraudo = value;
      return;
    }
    if (CPLib.eqr("_datini",p_cVarName)) {
      _datini = value;
      return;
    }
    if (CPLib.eqr("_datfin",p_cVarName)) {
      _datfin = value;
      return;
    }
    if (CPLib.eqr("_datinisem",p_cVarName)) {
      _datinisem = value;
      return;
    }
    if (CPLib.eqr("_datfinsem",p_cVarName)) {
      _datfinsem = value;
      return;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      cRitorno = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      riga = value;
      return;
    }
    if (CPLib.eqr("nFile",p_cVarName)) {
      nFile = value;
      return;
    }
    if (CPLib.eqr("outFileName",p_cVarName)) {
      outFileName = value;
      return;
    }
    if (CPLib.eqr("inFileName",p_cVarName)) {
      inFileName = value;
      return;
    }
    if (CPLib.eqr("_tcont",p_cVarName)) {
      _tcont = value;
      return;
    }
    if (CPLib.eqr("_codcli",p_cVarName)) {
      _codcli = value;
      return;
    }
    if (CPLib.eqr("_sotgru",p_cVarName)) {
      _sotgru = value;
      return;
    }
    if (CPLib.eqr("_cragsoc",p_cVarName)) {
      _cragsoc = value;
      return;
    }
    if (CPLib.eqr("_paeseres",p_cVarName)) {
      _paeseres = value;
      return;
    }
    if (CPLib.eqr("_provres",p_cVarName)) {
      _provres = value;
      return;
    }
    if (CPLib.eqr("_provage",p_cVarName)) {
      _provage = value;
      return;
    }
    if (CPLib.eqr("_nfile",p_cVarName)) {
      _nfile = value;
      return;
    }
    if (CPLib.eqr("_datope",p_cVarName)) {
      _datope = value;
      return;
    }
    if (CPLib.eqr("_cdataoggi",p_cVarName)) {
      _cdataoggi = value;
      return;
    }
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      _oldmsg = value;
      return;
    }
    if (CPLib.eqr("_valuta",p_cVarName)) {
      _valuta = value;
      return;
    }
    if (CPLib.eqr("_opestato",p_cVarName)) {
      _opestato = value;
      return;
    }
    if (CPLib.eqr("_numsto",p_cVarName)) {
      _numsto = value;
      return;
    }
    if (CPLib.eqr("_source",p_cVarName)) {
      _source = value;
      return;
    }
    if (CPLib.eqr("_flgfraud",p_cVarName)) {
      _flgfraud = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
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
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      gPathDoc = value;
      return;
    }
    if (CPLib.eqr("_pSegno",p_cVarName)) {
      _pSegno = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("_ddatini",p_cVarName)) {
      _ddatini = value;
      return;
    }
    if (CPLib.eqr("_ddatfin",p_cVarName)) {
      _ddatfin = value;
      return;
    }
    if (CPLib.eqr("_dataoggi",p_cVarName)) {
      _dataoggi = value;
      return;
    }
    if (CPLib.eqr("_opedata",p_cVarName)) {
      _opedata = value;
      return;
    }
    if (CPLib.eqr("_operett",p_cVarName)) {
      _operett = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
    if (CPLib.eqr("rowClientiSVIP",p_cVarName)) {
      rowClientiSVIP = (MemoryCursorRow_mcestraisv_clienti_mcrdef)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcStati",p_cVarName)) {
      mcStati = (MemoryCursor_tbstati)value;
      return;
    }
    if (CPLib.eqr("mcErrori",p_cVarName)) {
      mcErrori = (MemoryCursor_qbe_estrai_sv_ope_chk_all_vqr)value;
      return;
    }
    if (CPLib.eqr("mcDati",p_cVarName)) {
      mcDati = (MemoryCursor_qbe_estrai_sv_ope_tab_all_vqr)value;
      return;
    }
    if (CPLib.eqr("mcStatiSV",p_cVarName)) {
      mcStatiSV = (MemoryCursor_qbe_statisv_vqr)value;
      return;
    }
    if (CPLib.eqr("mcProvSV",p_cVarName)) {
      mcProvSV = (MemoryCursor_qbe_provsv_vqr)value;
      return;
    }
    if (CPLib.eqr("mcStGru",p_cVarName)) {
      mcStGru = (MemoryCursor_qbe_stgru_vqr)value;
      return;
    }
    if (CPLib.eqr("mcRapportiSVIP",p_cVarName)) {
      mcRapportiSVIP = (MemoryCursor_qbe_estrai_sv_all_ip_1_vqr)value;
      return;
    }
    if (CPLib.eqr("mcRapportiNS",p_cVarName)) {
      mcRapportiNS = (MemoryCursor_qbe_sv_idp_rapporti_vqr)value;
      return;
    }
    if (CPLib.eqr("mcOperazioniSVIP",p_cVarName)) {
      mcOperazioniSVIP = (MemoryCursor_qbe_estrai_sv_all_ip_2_a_vqr)value;
      return;
    }
    if (CPLib.eqr("mcClientiSVIP",p_cVarName)) {
      mcClientiSVIP = (MemoryCursor_mcestraisv_clienti_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcTbSotgru",p_cVarName)) {
      mcTbSotgru = (MemoryCursor_tbstgru)value;
      return;
    }
    if (CPLib.eqr("mcErroriSV_IP",p_cVarName)) {
      mcErroriSV_IP = (MemoryCursor_mcerrsvip_mcrdef)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_Main() throws Exception {
    CPResultSet Cursor_qbe_statisv=null;
    CPResultSet Cursor_qbe_provsv=null;
    CPResultSet Cursor_qbe_stgru=null;
    CPResultSet Cursor_tbstati=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* pAnno Numeric(4, 0) // Anno di riferimento */
      /* pTri Numeric(1, 0) // Trimestre */
      /* pTipo Char(1) // Tipo elaborazione */
      /* pFile Char(80) // Nome File Import */
      /* pTipoBase3 Char(4) // Tipo di Base 3 (B3IP o B3MT) */
      /* pFraudo Char(1) // Solo Fraudolente */
      /* _datini Char(8) // Data Inizio Trimestre */
      /* _datfin Char(8) // Data Fine Trimestre */
      /* _datinisem Char(8) // Data Inizio Semestre */
      /* _datfinsem Char(8) // Data Fine Semestre */
      /* cRitorno Char(30) */
      /* fhand Char(1) // Per gestione file */
      /* riga Memo */
      /* nFile Char(20) */
      /* outFileName Char(30) */
      /* inFileName Char(80) */
      /* _conta Numeric(10, 0) */
      /* _bottom Numeric(15, 0) */
      /* _top Numeric(15, 0) */
      /* _max Numeric(15, 0) */
      /* _cicli Numeric(15, 0) */
      /* _min Numeric(15, 0) */
      /* _mono Numeric(1, 0) */
      /* _tot Numeric(15, 0) */
      /* _reccount Numeric(10, 0) */
      /* _contarow Numeric(15, 0) */
      /* _tcont Char(3) */
      /* _importo Numeric(15, 0) */
      /* _codcli Char(16) */
      /* _sotgru Char(3) */
      /* _cragsoc Char(70) */
      /* _paeseres Char(3) */
      /* _provres Char(2) */
      /* _provage Char(2) */
      /* mcStati MemoryCursor(tbstati) */
      /* mcErrori MemoryCursor(qbe_estrai_sv_ope_chk_all.vqr) */
      /* mcDati MemoryCursor(qbe_estrai_sv_ope_tab_all.vqr) */
      /* _nfile Char(120) */
      /* _datope Char(10) */
      /* _ddatini Date */
      /* _ddatfin Date */
      /* _dataoggi Date */
      /* _cdataoggi Char(8) */
      /* _oldmsg Memo */
      /* _valuta Char(1) */
      /* _opedata Date */
      /* _operett Date */
      /* _opestato Char(1) */
      /* _numsto Char(15) */
      /* mcStatiSV MemoryCursor(qbe_statisv.vqr) */
      /* mcProvSV MemoryCursor(qbe_provsv.vqr) */
      /* mcStGru MemoryCursor(qbe_stgru.vqr) */
      /* _source Char(1) */
      /* mcRapportiSVIP MemoryCursor(qbe_estrai_sv_all_ip_1.vqr) // Rapporti SV IP */
      /* mcRapportiNS MemoryCursor(qbe_sv_idp_rapporti.vqr) // Rapporti SV IP */
      /* mcOperazioniSVIP MemoryCursor(qbe_estrai_sv_all_ip_2_a.vqr) // Operazioni SV IP */
      /* mcClientiSVIP MemoryCursor(mcEstraiSV_clienti.MCRDef) // File 3 delle SV per IP (Clienti.txt) */
      /* rowClientiSVIP Row(mcEstraiSV_clienti.MCRDef) */
      /* mcTbSotgru MemoryCursor(tbstgru) // Sottogruppi Att.Ec. */
      /* mcErroriSV_IP MemoryCursor(mcErrSvIP.MCRDef) */
      /* _flgfraud Char(1) */
      /* gAzienda Char(10) // Azienda */
      /* gIntemediario Char(11) // Intermediario */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Char(120) // Messaggio */
      /* gPathApp Char(80) // Path Applicazione */
      /* gPathDoc Char(80) // Path Applicazione */
      /* Case pTri=1 */
      if (CPLib.eqr(pTri,1)) {
        /* _datini := Str(pAnno,4,0)+'0101' // Data Inizio Trimestre */
        _datini = CPLib.Str(pAnno,4,0)+"0101";
        /* _datfin := Str(pAnno,4,0)+'0331' // Data Fine Trimestre */
        _datfin = CPLib.Str(pAnno,4,0)+"0331";
        /* Case pTri=2 */
      } else if (CPLib.eqr(pTri,2)) {
        /* If pFraudo='N' */
        if (CPLib.eqr(pFraudo,"N")) {
          /* _datini := Str(pAnno,4,0)+'0401' // Data Inizio Trimestre */
          _datini = CPLib.Str(pAnno,4,0)+"0401";
          /* _datfin := Str(pAnno,4,0)+'0630' // Data Fine Trimestre */
          _datfin = CPLib.Str(pAnno,4,0)+"0630";
        } else { // Else
          /* voce semestrale per IP */
          /* _datini := Str(pAnno,4,0)+'0101' // Data Inizio Semestre */
          _datini = CPLib.Str(pAnno,4,0)+"0101";
          /* _datfin := Str(pAnno,4,0)+'0630' // Data Fine Semestre */
          _datfin = CPLib.Str(pAnno,4,0)+"0630";
        } // End If
        /* voce semestrale per IP */
        /* _datinisem := Str(pAnno,4,0)+'0101' // Data Inizio Semestre */
        _datinisem = CPLib.Str(pAnno,4,0)+"0101";
        /* _datfinsem := Str(pAnno,4,0)+'0630' // Data Fine Semestre */
        _datfinsem = CPLib.Str(pAnno,4,0)+"0630";
        /* Case pTri=3 */
      } else if (CPLib.eqr(pTri,3)) {
        /* _datini := Str(pAnno,4,0)+'0701' // Data Inizio Trimestre */
        _datini = CPLib.Str(pAnno,4,0)+"0701";
        /* _datfin := Str(pAnno,4,0)+'0930' // Data Fine Trimestre */
        _datfin = CPLib.Str(pAnno,4,0)+"0930";
        /* Case pTri=4 */
      } else if (CPLib.eqr(pTri,4)) {
        /* If pFraudo='N' */
        if (CPLib.eqr(pFraudo,"N")) {
          /* _datini := Str(pAnno,4,0)+'1001' // Data Inizio Trimestre */
          _datini = CPLib.Str(pAnno,4,0)+"1001";
          /* _datfin := Str(pAnno,4,0)+'1231' // Data Fine Trimestre */
          _datfin = CPLib.Str(pAnno,4,0)+"1231";
        } else { // Else
          /* voce semestrale per IP */
          /* _datini := Str(pAnno,4,0)+'0701' // Data Inizio Semestre */
          _datini = CPLib.Str(pAnno,4,0)+"0701";
          /* _datfin := Str(pAnno,4,0)+'1231' // Data Fine Semestre */
          _datfin = CPLib.Str(pAnno,4,0)+"1231";
        } // End If
        /* voce semestrale per IP */
        /* _datinisem := Str(pAnno,4,0)+'0701' // Data Inizio Semestre */
        _datinisem = CPLib.Str(pAnno,4,0)+"0701";
        /* _datfinsem := Str(pAnno,4,0)+'1231' // Data Fine Semestre */
        _datfinsem = CPLib.Str(pAnno,4,0)+"1231";
      } // End Case
      /* _ddatini := CharToDate(_datini) */
      _ddatini = CPLib.CharToDate(_datini);
      /* _ddatfin := CharToDate(_datfin) */
      _ddatfin = CPLib.CharToDate(_datfin);
      /* If pTipoBase3='B3MT' */
      if (CPLib.eqr(pTipoBase3,"B3MT")) {
        /* -- Controlli Base 3 Moneytransfer */
        /* If pTipo='C' */
        if (CPLib.eqr(pTipo,"C")) {
          // * --- Fill memory cursor mcStatiSV on qbe_statisv
          mcStatiSV.Zap();
          if (Cursor_qbe_statisv!=null)
            Cursor_qbe_statisv.Close();
          Cursor_qbe_statisv = new VQRHolder("qbe_statisv",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          {
            final CPResultSet m_TheCursor = Cursor_qbe_statisv;
            Cursor_qbe_statisv.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_estrai_sv_check_all: query on qbe_statisv returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_qbe_statisv.Eof())) {
            mcStatiSV.AppendWithTrimmedKey(Cursor_qbe_statisv.GetString("CODSTA"));
            mcStatiSV.row.CODSTA = Cursor_qbe_statisv.GetString("CODSTA");
            Cursor_qbe_statisv.Next();
          }
          m_cConnectivityError = Cursor_qbe_statisv.ErrorMessage();
          Cursor_qbe_statisv.Close();
          mcStatiSV.GoTop();
          // * --- Fill memory cursor mcProvSV on qbe_provsv
          mcProvSV.Zap();
          if (Cursor_qbe_provsv!=null)
            Cursor_qbe_provsv.Close();
          Cursor_qbe_provsv = new VQRHolder("qbe_provsv",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          {
            final CPResultSet m_TheCursor = Cursor_qbe_provsv;
            Cursor_qbe_provsv.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_estrai_sv_check_all: query on qbe_provsv returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_qbe_provsv.Eof())) {
            mcProvSV.AppendWithTrimmedKey(Cursor_qbe_provsv.GetString("SIGLA"));
            mcProvSV.row.SIGLA = Cursor_qbe_provsv.GetString("SIGLA");
            Cursor_qbe_provsv.Next();
          }
          m_cConnectivityError = Cursor_qbe_provsv.ErrorMessage();
          Cursor_qbe_provsv.Close();
          mcProvSV.GoTop();
          // * --- Fill memory cursor mcStGru on qbe_stgru
          mcStGru.Zap();
          if (Cursor_qbe_stgru!=null)
            Cursor_qbe_stgru.Close();
          Cursor_qbe_stgru = new VQRHolder("qbe_stgru",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          {
            final CPResultSet m_TheCursor = Cursor_qbe_stgru;
            Cursor_qbe_stgru.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_estrai_sv_check_all: query on qbe_stgru returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_qbe_stgru.Eof())) {
            mcStGru.AppendWithTrimmedKey(Cursor_qbe_stgru.GetString("SOTGRU"));
            mcStGru.row.SOTGRU = Cursor_qbe_stgru.GetString("SOTGRU");
            mcStGru.row.DESCRI = Cursor_qbe_stgru.GetString("DESCRI");
            mcStGru.row.DATAINI = Cursor_qbe_stgru.GetDate("DATAINI");
            mcStGru.row.DATAFINE = Cursor_qbe_stgru.GetDate("DATAFINE");
            Cursor_qbe_stgru.Next();
          }
          m_cConnectivityError = Cursor_qbe_stgru.ErrorMessage();
          Cursor_qbe_stgru.Close();
          mcStGru.GoTop();
          /* gMsgProc := 'Ora Inizio Verifica Operazioni per SV: '+ arfn_fdatetime(DateTime()) + NL */
          gMsgProc = "Ora Inizio Verifica Operazioni per SV: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* outFileName := "CheckSV_MT"+LRTrim(gIntemediario)+"_"+Str(pAnno,4,0)+"_"+Str(pTri,1,0) */
          outFileName = "CheckSV_MT"+CPLib.LRTrim(gIntemediario)+"_"+CPLib.Str(pAnno,4,0)+"_"+CPLib.Str(pTri,1,0);
          /* _contarow := 0 */
          _contarow = CPLib.Round(0,0);
          /* Exec "Crea File Excel" Page 4:Excel */
          Excel();
          /* If _contarow = 0 */
          if (CPLib.eqr(_contarow,0)) {
            /* outFileName := '' */
            outFileName = "";
          } // End If
          /* gMsgProc := gMsgProc + 'Ora Fine Verifica Operazioni per SV: '+ arfn_fdatetime(DateTime()) + NL */
          gMsgProc = gMsgProc+"Ora Fine Verifica Operazioni per SV: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgImp := 'Elaborazione terminata con successo!' // Messaggio Import */
          gMsgImp = "Elaborazione terminata con successo!";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* ElseIf pTipo='T' */
        } else if (CPLib.eqr(pTipo,"T")) {
          /* gMsgProc :=  'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + NL */
          gMsgProc = "Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          // * --- Fill memory cursor mcStati on tbstati
          mcStati.Zap();
          m_cServer = m_Ctx.GetServer("tbstati");
          m_cPhName = m_Ctx.GetPhName("tbstati");
          if (Cursor_tbstati!=null)
            Cursor_tbstati.Close();
          Cursor_tbstati = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbstati")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
          {
            final CPResultSet m_TheCursor = Cursor_tbstati;
            Cursor_tbstati.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_estrai_sv_check_all: query on tbstati returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_tbstati.Eof())) {
            mcStati.AppendWithTrimmedKey(Cursor_tbstati.GetString("CODSTA"));
            mcStati.row.CODSTA = Cursor_tbstati.GetString("CODSTA");
            mcStati.row.DESCRI = Cursor_tbstati.GetString("DESCRI");
            mcStati.row.SIGLA = Cursor_tbstati.GetString("SIGLA");
            mcStati.row.ISO = Cursor_tbstati.GetString("ISO");
            mcStati.row.ISO2 = Cursor_tbstati.GetString("ISO2");
            mcStati.row.IDTBLS = Cursor_tbstati.GetString("IDTBLS");
            mcStati.row.IDBASE = Cursor_tbstati.GetString("IDBASE");
            mcStati.row.FLGSAE = Cursor_tbstati.GetString("FLGSAE");
            mcStati.row.ISON = Cursor_tbstati.GetString("ISON");
            Cursor_tbstati.Next();
          }
          m_cConnectivityError = Cursor_tbstati.ErrorMessage();
          Cursor_tbstati.Close();
          mcStati.GoTop();
          // Begin Transaction
          m_Sql.RequireTransaction();
          double nTry00000078status;
          nTry00000078status = m_Sql.GetTransactionStatus();
          String cTry00000078msg;
          cTry00000078msg = m_Sql.TransactionErrorMessage();
          try {
            /* If pTri=1 or pTri=3 */
            if (CPLib.eqr(pTri,1) || CPLib.eqr(pTri,3)) {
              /* gMsgProc := gMsgProc + 'Ora Inizio Azzeramento Archivio SV: '+ arfn_fdatetime(DateTime()) + NL */
              gMsgProc = gMsgProc+"Ora Inizio Azzeramento Archivio SV: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
               // * ---truncate
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("analisi_sv");
                      m_cPhName = m_Ctx.GetPhName("analisi_sv");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"analisi_sv",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_estrai_sv_check_all",613,"0000003C")+"truncate "+m_oWrInfo.GetTableWriteName();
                      m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                      if (CPLib.lt(m_nUpdatedRows,0)) {
                        m_Sql.AbortTransaction();
                      }
                      m_Sql.CompleteTransaction();
                      m_cLastMsgError = m_Sql.TransactionErrorMessage();
                      if (CPLib.ne(m_cLastMsgError,"")) {
                        m_bError = true;
                      }
              /* gMsgProc := gMsgProc + 'Ora Fine Azzeramento Archivio SV: '+ arfn_fdatetime(DateTime()) + NL */
              gMsgProc = gMsgProc+"Ora Fine Azzeramento Archivio SV: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            } else { // Else
              /* If pFraudo='N' */
              if (CPLib.eqr(pFraudo,"N")) {
                /* gMsgProc := gMsgProc + 'Ora Inizio Azzeramento Archivio SV: '+ arfn_fdatetime(DateTime()) + NL */
                gMsgProc = gMsgProc+"Ora Inizio Azzeramento Archivio SV: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                // * --- Delete from analisi_sv
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("analisi_sv");
                m_cPhName = m_Ctx.GetPhName("analisi_sv");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"analisi_sv",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_estrai_sv_check_all",202,"0000007F")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"DATAOPE >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_ddatini,"?",0,0,m_cServer),m_cServer,_ddatini)+"";
                m_cSql = m_cSql+" and DATAOPE <= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_ddatfin,"?",0,0,m_cServer),m_cServer,_ddatfin)+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
                /* gMsgProc := gMsgProc + 'Ora Fine Azzeramento Archivio SV: '+ arfn_fdatetime(DateTime()) + NL */
                gMsgProc = gMsgProc+"Ora Fine Azzeramento Archivio SV: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              } else { // Else
                /* gMsgProc := gMsgProc + 'Ora Inizio Azzeramento Archivio Fraudolente SV: '+ arfn_fdatetime(DateTime()) + NL */
                gMsgProc = gMsgProc+"Ora Inizio Azzeramento Archivio Fraudolente SV: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                // * --- Delete from analisi_fr
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("analisi_fr");
                m_cPhName = m_Ctx.GetPhName("analisi_fr");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"analisi_fr",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_estrai_sv_check_all",202,"00000082")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
                /* gMsgProc := gMsgProc + 'Ora Fine Azzeramento Archivio Fraudolente SV: '+ arfn_fdatetime(DateTime()) + NL */
                gMsgProc = gMsgProc+"Ora Fine Azzeramento Archivio Fraudolente SV: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              } // End If
            } // End If
            /* _contarow := 0 */
            _contarow = CPLib.Round(0,0);
            /* Exec "Operazioni" Page 2:Operazioni */
            Operazioni();
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
              throw new RoutineException();
            }
            /* Exec "Frazionate" Page 3:Frazionate */
            Frazionate();
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
              throw new RoutineException();
            }
            /* If pFraudo='N' */
            if (CPLib.eqr(pFraudo,"N")) {
              /* If pTri=2 or pTri=4 */
              if (CPLib.eqr(pTri,2) || CPLib.eqr(pTri,4)) {
                /* Exec Routine arfn_agg_fraudolente(pAnno,pTri) */
                arfn_agg_fraudolenteR.Make(m_Ctx,this).Run(pAnno,pTri);
              } // End If
            } // End If
            // Commit
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
            m_Sql.CompleteTransaction();
            /* gMsgProc := gMsgProc + 'Sono state estratte '+ LRTrim(Str(_contarow,10,0)) + " operazioni/frazionate" + NL */
            gMsgProc = gMsgProc+"Sono state estratte "+CPLib.LRTrim(CPLib.Str(_contarow,10,0))+" operazioni/frazionate"+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* outFileName := "OK" */
            outFileName = "OK";
            /* gMsgImp := 'Elaborazione terminata con successo!' // Messaggio Import */
            gMsgImp = "Elaborazione terminata con successo!";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          } catch(Exception l_exeption) {
            Stop.ReactToException(l_exeption);
            // Rollback
            m_Sql.AbortTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            m_bError = true;
            m_Sql.CompleteTransaction();
            /* outFileName := "KO" */
            outFileName = "KO";
            /* gMsgImp := 'Elaborazione terminata con errori!' // Messaggio Import */
            gMsgImp = "Elaborazione terminata con errori!";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          } finally {
            if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000078status,0)) {
              m_Sql.SetTransactionStatus(nTry00000078status,cTry00000078msg);
            }
          }
          /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + NL */
          gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* ElseIf pTipoBase3='B3IP' */
      } else if (CPLib.eqr(pTipoBase3,"B3IP")) {
        /* -- Controlli Base 3 Istituti di pagamento */
        /* Exec "Controlli Base3 Istituti di pagamento" Page 6:CheckIP */
        CheckIP();
      } // End If
      /* Return outFileName */
      throw new Stop(outFileName);
    } finally {
      try {
        if (Cursor_qbe_statisv!=null)
          Cursor_qbe_statisv.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_provsv!=null)
          Cursor_qbe_provsv.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_stgru!=null)
          Cursor_qbe_stgru.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tbstati!=null)
          Cursor_tbstati.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Operazioni() throws Exception {
    CPResultSet Cursor_qbe_estrai_sv_ope_tab_wu_minmax=null;
    CPResultSet Cursor_qbe_estrai_sv_ope_tab_all=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _reccount := 0 */
      _reccount = CPLib.Round(0,0);
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file delle operazioni' + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file delle operazioni"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* If pFraudo='N' */
      if (CPLib.eqr(pFraudo,"N")) {
        // * --- Select from qbe_estrai_sv_ope_tab_wu_minmax
        SPBridge.HMCaller _h00000099;
        _h00000099 = new SPBridge.HMCaller();
        _h00000099.Set("m_cVQRList",m_cVQRList);
        _h00000099.Set("pDADATA",_datini);
        _h00000099.Set("pA_DATA",_datfin);
        if (Cursor_qbe_estrai_sv_ope_tab_wu_minmax!=null)
          Cursor_qbe_estrai_sv_ope_tab_wu_minmax.Close();
        Cursor_qbe_estrai_sv_ope_tab_wu_minmax = new VQRHolder("qbe_estrai_sv_ope_tab_wu_minmax",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000099,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_estrai_sv_ope_tab_wu_minmax.Eof())) {
          /* _reccount := qbe_estrai_sv_ope_tab_wu_minmax->TOTOPE */
          _reccount = CPLib.Round(Cursor_qbe_estrai_sv_ope_tab_wu_minmax.GetDouble("TOTOPE"),0);
          Cursor_qbe_estrai_sv_ope_tab_wu_minmax.Next();
        }
        m_cConnectivityError = Cursor_qbe_estrai_sv_ope_tab_wu_minmax.ErrorMessage();
        Cursor_qbe_estrai_sv_ope_tab_wu_minmax.Close();
        // * --- End Select
      } else { // Else
        /* _reccount := 1 */
        _reccount = CPLib.Round(1,0);
      } // End If
      /* If _reccount > 0 */
      if (CPLib.gt(_reccount,0)) {
        /* _contarow := 0 */
        _contarow = CPLib.Round(0,0);
        /* _dataoggi := _ddatini */
        _dataoggi = _ddatini;
        /* _cdataoggi := _datini */
        _cdataoggi = _datini;
        /* While _dataoggi <= _ddatfin */
        while (CPLib.le(_dataoggi,_ddatfin)) {
          /* If Empty(_oldmsg) */
          if (CPLib.Empty(_oldmsg)) {
            /* gMsgProc := gMsgProc + 'Sto elaborando il giorno: '+arfn_fdate(_dataoggi) + " del file operazioni" // Messaggio */
            gMsgProc = gMsgProc+"Sto elaborando il giorno: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataoggi)+" del file operazioni";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } else { // Else
            /* gMsgProc := Strtran(gMsgProc,_oldmsg,'Sto elaborando il giorno: '+arfn_fdate(_dataoggi) + " del file operazioni") // Messaggio */
            gMsgProc = CPLib.Strtran(gMsgProc,_oldmsg,"Sto elaborando il giorno: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataoggi)+" del file operazioni");
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } // End If
          /* _oldmsg := 'Sto elaborando il giorno: '+arfn_fdate(_dataoggi) + " del file operazioni" */
          _oldmsg = "Sto elaborando il giorno: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataoggi)+" del file operazioni";
          // * --- Fill memory cursor mcDati on qbe_estrai_sv_ope_tab_all
          mcDati.Zap();
          SPBridge.HMCaller _h000000A6;
          _h000000A6 = new SPBridge.HMCaller();
          _h000000A6.Set("m_cVQRList",m_cVQRList);
          _h000000A6.Set("pDADATA",_cdataoggi);
          _h000000A6.Set("pFraudo",pFraudo);
          if (Cursor_qbe_estrai_sv_ope_tab_all!=null)
            Cursor_qbe_estrai_sv_ope_tab_all.Close();
          Cursor_qbe_estrai_sv_ope_tab_all = new VQRHolder("qbe_estrai_sv_ope_tab_all",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000A6,true).GetResultSet(m_Ctx);
          {
            final CPResultSet m_TheCursor = Cursor_qbe_estrai_sv_ope_tab_all;
            Cursor_qbe_estrai_sv_ope_tab_all.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,60000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_estrai_sv_check_all: query on qbe_estrai_sv_ope_tab_all returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 60000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_qbe_estrai_sv_ope_tab_all.Eof())) {
            mcDati.AppendBlank();
            mcDati.row.NUMPROG = Cursor_qbe_estrai_sv_ope_tab_all.GetString("NUMPROG");
            mcDati.row.DATAOPE = Cursor_qbe_estrai_sv_ope_tab_all.GetDate("DATAOPE");
            mcDati.row.SEGNO = Cursor_qbe_estrai_sv_ope_tab_all.GetString("SEGNO");
            mcDati.row.CODDIPE = Cursor_qbe_estrai_sv_ope_tab_all.GetString("CODDIPE");
            mcDati.row.DESCRIZ = Cursor_qbe_estrai_sv_ope_tab_all.GetString("DESCRIZ");
            mcDati.row.PROVINCIANEW = Cursor_qbe_estrai_sv_ope_tab_all.GetString("PROVINCIANEW");
            mcDati.row.TIPOSV = Cursor_qbe_estrai_sv_ope_tab_all.GetString("TIPOSV");
            mcDati.row.CONNESCLI = Cursor_qbe_estrai_sv_ope_tab_all.GetString("CONNESCLI");
            mcDati.row.PAESE = Cursor_qbe_estrai_sv_ope_tab_all.GetString("PAESE");
            mcDati.row.IMPOUT = Cursor_qbe_estrai_sv_ope_tab_all.GetDouble("IMPOUT");
            mcDati.row.TOTLIRE = Cursor_qbe_estrai_sv_ope_tab_all.GetDouble("TOTLIRE");
            mcDati.row.TOTCONT = Cursor_qbe_estrai_sv_ope_tab_all.GetDouble("TOTCONT");
            mcDati.row.FLAGLIRE = Cursor_qbe_estrai_sv_ope_tab_all.GetString("FLAGLIRE");
            mcDati.row.TIPO = Cursor_qbe_estrai_sv_ope_tab_all.GetString("TIPO");
            mcDati.row.DESCCIT = Cursor_qbe_estrai_sv_ope_tab_all.GetString("DESCCIT");
            mcDati.row.PROVINCIAOLD = Cursor_qbe_estrai_sv_ope_tab_all.GetString("PROVINCIAOLD");
            mcDati.row.CODCAB = Cursor_qbe_estrai_sv_ope_tab_all.GetString("CODCAB");
            mcDati.row.STATOREG = Cursor_qbe_estrai_sv_ope_tab_all.GetString("STATOREG");
            mcDati.row.DATARETT = Cursor_qbe_estrai_sv_ope_tab_all.GetDate("DATARETT");
            mcDati.row.FLAGFRAUD = Cursor_qbe_estrai_sv_ope_tab_all.GetDouble("FLAGFRAUD");
            Cursor_qbe_estrai_sv_ope_tab_all.Next();
          }
          m_cConnectivityError = Cursor_qbe_estrai_sv_ope_tab_all.ErrorMessage();
          Cursor_qbe_estrai_sv_ope_tab_all.Close();
          mcDati.GoTop();
          for (MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr rowDati : mcDati._iterable_()) {
            /* gMsgImp := "Sto elaborando l'operazione con progressivo: " + rowDati.NUMPROG // Messaggio Import */
            gMsgImp = "Sto elaborando l'operazione con progressivo: "+rowDati.NUMPROG;
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* _contarow := _contarow + 1 */
            _contarow = CPLib.Round(_contarow+1,0);
            /* _tcont := iif(rowDati.TOTLIRE=rowDati.TOTCONT,'351','352') */
            _tcont = (CPLib.eqr(rowDati.TOTLIRE,rowDati.TOTCONT)?"351":"352");
            /* If _tcont='352' */
            if (CPLib.eqr(_tcont,"352")) {
              /* _importo := iif(rowDati.TOTCONT=0,(rowDati.IMPOUT * 100),rowDati.TOTLIRE - (rowDati.IMPOUT*100)) */
              _importo = CPLib.Round((CPLib.eqr(rowDati.TOTCONT,0)?(rowDati.IMPOUT*100):rowDati.TOTLIRE-(rowDati.IMPOUT*100)),0);
            } else { // Else
              /* _importo := rowDati.IMPOUT * 100 */
              _importo = CPLib.Round(rowDati.IMPOUT*100,0);
            } // End If
            /* _valuta := iif(At(rowDati.FLAGLIRE,'|E|3|5') > 0 or Empty(rowDati.FLAGLIRE), '1','2') */
            _valuta = (CPLib.gt(CPLib.At(rowDati.FLAGLIRE,"|E|3|5"),0) || CPLib.Empty(rowDati.FLAGLIRE)?"1":"2");
            /* _paeseres := rowDati.PAESE */
            _paeseres = rowDati.PAESE;
            /* _sotgru := '' */
            _sotgru = "";
            /* _cragsoc := '' */
            _cragsoc = "";
            /* _provres := '' */
            _provres = "";
            /* _numsto := '' */
            _numsto = "";
            /* _codcli := rowDati.CONNESCLI */
            _codcli = rowDati.CONNESCLI;
            /* _opedata := rowDati.DATAOPE */
            _opedata = rowDati.DATAOPE;
            /* _operett := rowDati.DATARETT */
            _operett = rowDati.DATARETT;
            /* _opestato := rowDati.STATOREG */
            _opestato = rowDati.STATOREG;
            /* Exec "Ricerca Dati Cliente" Page 5:DatiCliente */
            DatiCliente();
            /* _flgfraud := iif((Empty(rowDati.FLAGFRAUD) or rowDati.FLAGFRAUD=0),'N','S') */
            _flgfraud = ((CPLib.Empty(rowDati.FLAGFRAUD) || CPLib.eqr(rowDati.FLAGFRAUD,0))?"N":"S");
            /* If pFraudo='N' */
            if (CPLib.eqr(pFraudo,"N")) {
              // * --- Insert into analisi_sv from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("analisi_sv");
              m_cPhName = m_Ctx.GetPhName("analisi_sv");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"analisi_sv",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_estrai_sv_check_all",202,"000000BD")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000BD(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.NUMPROG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.DATAOPE,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.SEGNO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.CODDIPE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.DESCRIZ,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(rowDati.PROVINCIAOLD)?rowDati.PROVINCIANEW:rowDati.PROVINCIAOLD),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.TIPOSV,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.CONNESCLI,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cragsoc,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_sotgru,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_provres,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_paeseres,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tcont,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_importo,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_contarow,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_valuta,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_source,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_flgfraud,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"analisi_sv",true);
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
              // * --- Insert into analisi_fr from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("analisi_fr");
              m_cPhName = m_Ctx.GetPhName("analisi_fr");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"analisi_fr",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_estrai_sv_check_all",202,"000000BE")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000BE(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.NUMPROG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.DATAOPE,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.SEGNO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.CODDIPE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.DESCRIZ,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(rowDati.PROVINCIAOLD)?rowDati.PROVINCIANEW:rowDati.PROVINCIAOLD),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.TIPOSV,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.CONNESCLI,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cragsoc,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_sotgru,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_provres,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_paeseres,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tcont,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_importo,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_contarow,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_valuta,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_source,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_flgfraud,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"analisi_fr",true);
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
          }
          /* _dataoggi := arfn_datesum(_dataoggi,1) */
          _dataoggi = arfn_datesumR.Make(m_Ctx,this).Run(_dataoggi,1);
          /* _cdataoggi := DateToChar(_dataoggi) */
          _cdataoggi = CPLib.DateToChar(_dataoggi);
        } // End While
        /* gMsgProc := gMsgProc + NL + 'Sono state estratte '+ LRTrim(Str(_contarow,10,0)) + " operazioni" + NL */
        gMsgProc = gMsgProc+"\n"+"Sono state estratte "+CPLib.LRTrim(CPLib.Str(_contarow,10,0))+" operazioni"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } else { // Else
        /* gMsgProc := gMsgProc + 'Non ci sono operazioni da elaborare per il periodo.' + NL */
        gMsgProc = gMsgProc+"Non ci sono operazioni da elaborare per il periodo."+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file delle operazioni' + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file delle operazioni"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_qbe_estrai_sv_ope_tab_wu_minmax!=null)
          Cursor_qbe_estrai_sv_ope_tab_wu_minmax.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_estrai_sv_ope_tab_all!=null)
          Cursor_qbe_estrai_sv_ope_tab_all.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Frazionate() throws Exception {
    CPResultSet Cursor_qbe_estrai_sv_frz_tab_wu_minmax=null;
    CPResultSet Cursor_qbe_estrai_sv_frz_tab_all=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _reccount := 0 */
      _reccount = CPLib.Round(0,0);
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file delle frazionate' + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file delle frazionate"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* If pFraudo='N' */
      if (CPLib.eqr(pFraudo,"N")) {
        // * --- Select from qbe_estrai_sv_frz_tab_wu_minmax
        SPBridge.HMCaller _h000000C8;
        _h000000C8 = new SPBridge.HMCaller();
        _h000000C8.Set("m_cVQRList",m_cVQRList);
        _h000000C8.Set("pDADATA",_datini);
        _h000000C8.Set("pA_DATA",_datfin);
        if (Cursor_qbe_estrai_sv_frz_tab_wu_minmax!=null)
          Cursor_qbe_estrai_sv_frz_tab_wu_minmax.Close();
        Cursor_qbe_estrai_sv_frz_tab_wu_minmax = new VQRHolder("qbe_estrai_sv_frz_tab_wu_minmax",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000C8,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_estrai_sv_frz_tab_wu_minmax.Eof())) {
          /* _reccount := qbe_estrai_sv_frz_tab_wu_minmax->TOTOPE */
          _reccount = CPLib.Round(Cursor_qbe_estrai_sv_frz_tab_wu_minmax.GetDouble("TOTOPE"),0);
          Cursor_qbe_estrai_sv_frz_tab_wu_minmax.Next();
        }
        m_cConnectivityError = Cursor_qbe_estrai_sv_frz_tab_wu_minmax.ErrorMessage();
        Cursor_qbe_estrai_sv_frz_tab_wu_minmax.Close();
        // * --- End Select
      } else { // Else
        /* _reccount := 1 */
        _reccount = CPLib.Round(1,0);
      } // End If
      /* If _reccount > 0 */
      if (CPLib.gt(_reccount,0)) {
        /* _contarow := 0 */
        _contarow = CPLib.Round(0,0);
        /* _dataoggi := _ddatini */
        _dataoggi = _ddatini;
        /* _cdataoggi := _datini */
        _cdataoggi = _datini;
        /* While _dataoggi <= _ddatfin */
        while (CPLib.le(_dataoggi,_ddatfin)) {
          /* If Empty(_oldmsg) */
          if (CPLib.Empty(_oldmsg)) {
            /* gMsgProc := gMsgProc + 'Sto elaborando il giorno: '+arfn_fdate(_dataoggi) + " del file frazionate" // Messaggio */
            gMsgProc = gMsgProc+"Sto elaborando il giorno: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataoggi)+" del file frazionate";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } else { // Else
            /* gMsgProc := Strtran(gMsgProc,_oldmsg,'Sto elaborando il giorno: '+arfn_fdate(_dataoggi) + " del file frazionate") // Messaggio */
            gMsgProc = CPLib.Strtran(gMsgProc,_oldmsg,"Sto elaborando il giorno: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataoggi)+" del file frazionate");
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } // End If
          /* _oldmsg := 'Sto elaborando il giorno: '+arfn_fdate(_dataoggi) + " del file frazionate" */
          _oldmsg = "Sto elaborando il giorno: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataoggi)+" del file frazionate";
          // * --- Fill memory cursor mcDati on qbe_estrai_sv_frz_tab_all
          mcDati.Zap();
          SPBridge.HMCaller _h000000D5;
          _h000000D5 = new SPBridge.HMCaller();
          _h000000D5.Set("m_cVQRList",m_cVQRList);
          _h000000D5.Set("pDADATA",_cdataoggi);
          _h000000D5.Set("pFraudo",pFraudo);
          if (Cursor_qbe_estrai_sv_frz_tab_all!=null)
            Cursor_qbe_estrai_sv_frz_tab_all.Close();
          Cursor_qbe_estrai_sv_frz_tab_all = new VQRHolder("qbe_estrai_sv_frz_tab_all",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000D5,true).GetResultSet(m_Ctx);
          {
            final CPResultSet m_TheCursor = Cursor_qbe_estrai_sv_frz_tab_all;
            Cursor_qbe_estrai_sv_frz_tab_all.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,60000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_estrai_sv_check_all: query on qbe_estrai_sv_frz_tab_all returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 60000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_qbe_estrai_sv_frz_tab_all.Eof())) {
            mcDati.AppendBlank();
            mcDati.row.NUMPROG = Cursor_qbe_estrai_sv_frz_tab_all.GetString("NUMPROG");
            mcDati.row.DATAOPE = Cursor_qbe_estrai_sv_frz_tab_all.GetDate("DATAOPE");
            mcDati.row.SEGNO = Cursor_qbe_estrai_sv_frz_tab_all.GetString("SEGNO");
            mcDati.row.CODDIPE = Cursor_qbe_estrai_sv_frz_tab_all.GetString("CODDIPE");
            mcDati.row.DESCRIZ = Cursor_qbe_estrai_sv_frz_tab_all.GetString("DESCRIZ");
            mcDati.row.PROVINCIANEW = Cursor_qbe_estrai_sv_frz_tab_all.GetString("PROVINCIANEW");
            mcDati.row.TIPOSV = Cursor_qbe_estrai_sv_frz_tab_all.GetString("TIPOSV");
            mcDati.row.CONNESCLI = Cursor_qbe_estrai_sv_frz_tab_all.GetString("CONNESCLI");
            mcDati.row.PAESE = Cursor_qbe_estrai_sv_frz_tab_all.GetString("PAESE");
            mcDati.row.IMPOUT = Cursor_qbe_estrai_sv_frz_tab_all.GetDouble("IMPOUT");
            mcDati.row.TOTLIRE = Cursor_qbe_estrai_sv_frz_tab_all.GetDouble("TOTLIRE");
            mcDati.row.TOTCONT = Cursor_qbe_estrai_sv_frz_tab_all.GetDouble("TOTCONT");
            mcDati.row.FLAGLIRE = Cursor_qbe_estrai_sv_frz_tab_all.GetString("FLAGLIRE");
            mcDati.row.TIPO = Cursor_qbe_estrai_sv_frz_tab_all.GetString("TIPO");
            mcDati.row.DESCCIT = Cursor_qbe_estrai_sv_frz_tab_all.GetString("DESCCIT");
            mcDati.row.PROVINCIAOLD = Cursor_qbe_estrai_sv_frz_tab_all.GetString("PROVINCIAOLD");
            mcDati.row.CODCAB = Cursor_qbe_estrai_sv_frz_tab_all.GetString("CODCAB");
            mcDati.row.STATOREG = Cursor_qbe_estrai_sv_frz_tab_all.GetString("STATOREG");
            mcDati.row.DATARETT = Cursor_qbe_estrai_sv_frz_tab_all.GetDate("DATARETT");
            mcDati.row.FLAGFRAUD = Cursor_qbe_estrai_sv_frz_tab_all.GetDouble("FLAGFRAUD");
            Cursor_qbe_estrai_sv_frz_tab_all.Next();
          }
          m_cConnectivityError = Cursor_qbe_estrai_sv_frz_tab_all.ErrorMessage();
          Cursor_qbe_estrai_sv_frz_tab_all.Close();
          mcDati.GoTop();
          for (MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr rowDati : mcDati._iterable_()) {
            /* gMsgImp := "Sto elaborando l'operazione con progressivo: " + rowDati.NUMPROG // Messaggio Import */
            gMsgImp = "Sto elaborando l'operazione con progressivo: "+rowDati.NUMPROG;
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* _contarow := _contarow + 1 */
            _contarow = CPLib.Round(_contarow+1,0);
            /* _tcont := iif(rowDati.TOTLIRE=rowDati.TOTCONT,'351','352') */
            _tcont = (CPLib.eqr(rowDati.TOTLIRE,rowDati.TOTCONT)?"351":"352");
            /* If _tcont='352' */
            if (CPLib.eqr(_tcont,"352")) {
              /* _importo := iif(rowDati.TOTCONT=0,(rowDati.IMPOUT*100),rowDati.TOTLIRE - (rowDati.IMPOUT * 100)) */
              _importo = CPLib.Round((CPLib.eqr(rowDati.TOTCONT,0)?(rowDati.IMPOUT*100):rowDati.TOTLIRE-(rowDati.IMPOUT*100)),0);
            } else { // Else
              /* _importo := (rowDati.IMPOUT * 100) */
              _importo = CPLib.Round((rowDati.IMPOUT*100),0);
            } // End If
            /* _valuta := iif(At(rowDati.FLAGLIRE,'|E|3|5') > 0 or Empty(rowDati.FLAGLIRE), '1','2') */
            _valuta = (CPLib.gt(CPLib.At(rowDati.FLAGLIRE,"|E|3|5"),0) || CPLib.Empty(rowDati.FLAGLIRE)?"1":"2");
            /* _paeseres := rowDati.PAESE */
            _paeseres = rowDati.PAESE;
            /* _sotgru := '' */
            _sotgru = "";
            /* _cragsoc := '' */
            _cragsoc = "";
            /* _provres := '' */
            _provres = "";
            /* _numsto := '' */
            _numsto = "";
            /* _codcli := rowDati.CONNESCLI */
            _codcli = rowDati.CONNESCLI;
            /* _opedata := rowDati.DATAOPE */
            _opedata = rowDati.DATAOPE;
            /* _operett := rowDati.DATARETT */
            _operett = rowDati.DATARETT;
            /* _opestato := rowDati.STATOREG */
            _opestato = rowDati.STATOREG;
            /* Exec "Ricerca Dati Cliente" Page 5:DatiCliente */
            DatiCliente();
            /* _flgfraud := iif((Empty(rowDati.FLAGFRAUD) or rowDati.FLAGFRAUD=0),'N','S') */
            _flgfraud = ((CPLib.Empty(rowDati.FLAGFRAUD) || CPLib.eqr(rowDati.FLAGFRAUD,0))?"N":"S");
            /* If pFraudo='N' */
            if (CPLib.eqr(pFraudo,"N")) {
              // * --- Insert into analisi_sv from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("analisi_sv");
              m_cPhName = m_Ctx.GetPhName("analisi_sv");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"analisi_sv",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_estrai_sv_check_all",202,"000000EC")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000EC(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL("F","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.NUMPROG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.DATAOPE,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.SEGNO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.CODDIPE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.DESCRIZ,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(rowDati.PROVINCIAOLD)?rowDati.PROVINCIANEW:rowDati.PROVINCIAOLD),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.TIPOSV,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.CONNESCLI,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cragsoc,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_sotgru,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_provres,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_paeseres,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tcont,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_importo,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_contarow,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_valuta,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_source,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_flgfraud,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"analisi_sv",true);
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
              // * --- Insert into analisi_fr from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("analisi_fr");
              m_cPhName = m_Ctx.GetPhName("analisi_fr");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"analisi_fr",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_estrai_sv_check_all",202,"000000ED")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000ED(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL("F","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.NUMPROG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.DATAOPE,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.SEGNO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.CODDIPE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.DESCRIZ,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(rowDati.PROVINCIAOLD)?rowDati.PROVINCIANEW:rowDati.PROVINCIAOLD),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.TIPOSV,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.CONNESCLI,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cragsoc,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_sotgru,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_provres,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_paeseres,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tcont,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_importo,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_contarow,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_valuta,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_source,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_flgfraud,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"analisi_fr",true);
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
          }
          /* _dataoggi := arfn_datesum(_dataoggi,1) */
          _dataoggi = arfn_datesumR.Make(m_Ctx,this).Run(_dataoggi,1);
          /* _cdataoggi := DateToChar(_dataoggi) */
          _cdataoggi = CPLib.DateToChar(_dataoggi);
        } // End While
        /* gMsgProc := gMsgProc + NL + 'Sono state estratte '+ LRTrim(Str(_contarow,10,0)) + " frazionate" + NL */
        gMsgProc = gMsgProc+"\n"+"Sono state estratte "+CPLib.LRTrim(CPLib.Str(_contarow,10,0))+" frazionate"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } else { // Else
        /* gMsgProc := gMsgProc + 'Non ci sono frazionate da elaborare per il periodo.' + NL */
        gMsgProc = gMsgProc+"Non ci sono frazionate da elaborare per il periodo."+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file delle frazionate' + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file delle frazionate"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_qbe_estrai_sv_frz_tab_wu_minmax!=null)
          Cursor_qbe_estrai_sv_frz_tab_wu_minmax.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_estrai_sv_frz_tab_all!=null)
          Cursor_qbe_estrai_sv_frz_tab_all.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Excel() throws Exception {
    CPResultSet Cursor_qbe_estrai_sv_ope_chk_all=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _err1 Char(50) */
      String _err1;
      _err1 = CPLib.Space(50);
      /* _err2 Char(50) */
      String _err2;
      _err2 = CPLib.Space(50);
      /* _err3 Char(50) */
      String _err3;
      _err3 = CPLib.Space(50);
      /* _err4 Char(50) */
      String _err4;
      _err4 = CPLib.Space(50);
      /* _err5 Char(50) */
      String _err5;
      _err5 = CPLib.Space(50);
      /* _err6 Char(50) */
      String _err6;
      _err6 = CPLib.Space(50);
      /* _err7 Char(50) */
      String _err7;
      _err7 = CPLib.Space(50);
      /* If pTipoBase3='B3MT' */
      if (CPLib.eqr(pTipoBase3,"B3MT")) {
        /* gMsgProc := gMsgProc + 'Esame operazioni...' + NL */
        gMsgProc = gMsgProc+"Esame operazioni..."+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // * --- Fill memory cursor mcErrori on qbe_estrai_sv_ope_chk_all
        mcErrori.Zap();
        if (Cursor_qbe_estrai_sv_ope_chk_all!=null)
          Cursor_qbe_estrai_sv_ope_chk_all.Close();
        Cursor_qbe_estrai_sv_ope_chk_all = new VQRHolder("qbe_estrai_sv_ope_chk_all",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        {
          final CPResultSet m_TheCursor = Cursor_qbe_estrai_sv_ope_chk_all;
          Cursor_qbe_estrai_sv_ope_chk_all.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arrt_estrai_sv_check_all: query on qbe_estrai_sv_ope_chk_all returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_qbe_estrai_sv_ope_chk_all.Eof())) {
          mcErrori.AppendBlank();
          mcErrori.row.TIPO = Cursor_qbe_estrai_sv_ope_chk_all.GetString("TIPO");
          mcErrori.row.NUMPROG = Cursor_qbe_estrai_sv_ope_chk_all.GetString("NUMPROG");
          mcErrori.row.DATAOPE = Cursor_qbe_estrai_sv_ope_chk_all.GetDate("DATAOPE");
          mcErrori.row.SEGNO = Cursor_qbe_estrai_sv_ope_chk_all.GetString("SEGNO");
          mcErrori.row.CODDIPE = Cursor_qbe_estrai_sv_ope_chk_all.GetString("CODDIPE");
          mcErrori.row.DESCRIZ = Cursor_qbe_estrai_sv_ope_chk_all.GetString("DESCRIZ");
          mcErrori.row.PROVINCIA1 = Cursor_qbe_estrai_sv_ope_chk_all.GetString("PROVINCIA1");
          mcErrori.row.TIPOSV = Cursor_qbe_estrai_sv_ope_chk_all.GetString("TIPOSV");
          mcErrori.row.CONNESCLI = Cursor_qbe_estrai_sv_ope_chk_all.GetString("CONNESCLI");
          mcErrori.row.RAGSOC = Cursor_qbe_estrai_sv_ope_chk_all.GetString("RAGSOC");
          mcErrori.row.SOTGRUP = Cursor_qbe_estrai_sv_ope_chk_all.GetString("SOTGRUP");
          mcErrori.row.PROVINCIA = Cursor_qbe_estrai_sv_ope_chk_all.GetString("PROVINCIA");
          mcErrori.row.PAESE = Cursor_qbe_estrai_sv_ope_chk_all.GetString("PAESE");
          mcErrori.row.IMPOUT = Cursor_qbe_estrai_sv_ope_chk_all.GetDouble("IMPOUT");
          mcErrori.row.CODFISC = Cursor_qbe_estrai_sv_ope_chk_all.GetString("CODFISC");
          mcErrori.row.DESCCIT = Cursor_qbe_estrai_sv_ope_chk_all.GetString("DESCCIT");
          mcErrori.row.NASCOMUN = Cursor_qbe_estrai_sv_ope_chk_all.GetString("NASCOMUN");
          mcErrori.row.NASSTATO = Cursor_qbe_estrai_sv_ope_chk_all.GetString("NASSTATO");
          mcErrori.row.TIPINTER = Cursor_qbe_estrai_sv_ope_chk_all.GetString("TIPINTER");
          mcErrori.row.CITAGE = Cursor_qbe_estrai_sv_ope_chk_all.GetString("CITAGE");
          mcErrori.row.PAESERES = Cursor_qbe_estrai_sv_ope_chk_all.GetString("PAESERES");
          mcErrori.row.INFORM = Cursor_qbe_estrai_sv_ope_chk_all.GetString("INFORM");
          mcErrori.row.SESSO = Cursor_qbe_estrai_sv_ope_chk_all.GetString("SESSO");
          mcErrori.row.SORGENTE = Cursor_qbe_estrai_sv_ope_chk_all.GetString("SORGENTE");
          Cursor_qbe_estrai_sv_ope_chk_all.Next();
        }
        m_cConnectivityError = Cursor_qbe_estrai_sv_ope_chk_all.ErrorMessage();
        Cursor_qbe_estrai_sv_ope_chk_all.Close();
        mcErrori.GoTop();
        /* If mcErrori.RecCount() > 0 or True */
        if (CPLib.gt(mcErrori.RecCount(),0) || true) {
          /* gMsgProc := gMsgProc + 'Ora Inizio Creazione File Excel: '+ arfn_fdatetime(DateTime()) + NL */
          gMsgProc = gMsgProc+"Ora Inizio Creazione File Excel: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* _nfile := LRTrim(gPathApp)+"/appo/"+LRTrim(gAzienda)+"/"+LRTrim(outFileName)+".xlsx" */
          _nfile = CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(outFileName)+".xlsx";
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
          //scrivo la riga di intestazione
          cell =  row.createCell(0);
          cell.setCellValue("N. Operazione");
          cell.setCellStyle(cs);
          cell =  row.createCell(1);
          cell.setCellValue("Data Operazione");
          cell.setCellStyle(cs);
          cell = row.createCell(2);
          cell.setCellValue("Segno");
          cell.setCellStyle(cs);
          cell = row.createCell(3);
          cell.setCellValue("Codice AGENZIA");
          cell.setCellStyle(cs);
          cell =  row.createCell(4);
          cell.setCellValue("Nome AGENZIA");
          cell.setCellStyle(cs);
          cell =  row.createCell(5);
          cell.setCellValue("Prov. Agenzia'");
          cell.setCellStyle(cs);
          cell =  row.createCell(6);
          cell.setCellValue("Canale Distributivo AGENZIA");
          cell.setCellStyle(cs);
          cell =  row.createCell(7);
          cell.setCellValue("NDG CLIENTE");
          cell.setCellStyle(cs);
          cell =  row.createCell(8);
          cell.setCellValue("Nominativo CLIENTE");
          cell.setCellStyle(cs);
          cell = row.createCell(9);
          cell.setCellValue("Settore CLIENTE");
          cell.setCellStyle(cs);
          cell = row.createCell(10);
          cell.setCellValue("Provincia CLIENTE");
          cell.setCellStyle(cs);
          cell = row.createCell(11);
          cell.setCellValue("Importo Netto");
          cell.setCellStyle(cs);
          cell = row.createCell(12);
          cell.setCellValue("Stato Destinazione");
          cell.setCellStyle(cs);
          cell = row.createCell(13);
          cell.setCellValue("Tipo Operazione");
          cell.setCellStyle(cs);
          cell = row.createCell(14);
          cell.setCellValue("Codice Fiscale");
          cell.setCellStyle(cs);
          cell = row.createCell(15);
          cell.setCellValue("Comune di nascita");
          cell.setCellStyle(cs);
          cell = row.createCell(16);
          cell.setCellValue("Stato di Nascita");
          cell.setCellStyle(cs);
          cell = row.createCell(17);
          cell.setCellValue("Provincia di Nascita");
          cell.setCellStyle(cs);
          cell = row.createCell(18);
          cell.setCellValue("Città di Residenza");
          cell.setCellStyle(cs);
          cell = row.createCell(19);
          cell.setCellValue("Città Agenzia");
          cell.setCellStyle(cs);
          cell = row.createCell(20);
          cell.setCellValue("Paese Residenza Cliente");
          cell.setCellStyle(cs);
          cell = row.createCell(21);
          cell.setCellValue("Riferimento");
          cell.setCellStyle(cs);
          cell = row.createCell(22);
          cell.setCellValue("Errore 1");
          cell.setCellStyle(cs);
          cell = row.createCell(23);
          cell.setCellValue("Errore 2");
          cell.setCellStyle(cs);
          cell = row.createCell(24);
          cell.setCellValue("Errore 3");
          cell.setCellStyle(cs);
          cell = row.createCell(25);
          cell.setCellValue("Errore 4");
          cell.setCellStyle(cs);
          cell = row.createCell(26);
          cell.setCellValue("Errore 5");
          cell.setCellStyle(cs);
          cell = row.createCell(27);
          cell.setCellValue("Errore 6");
          cell.setCellStyle(cs);
          cell = row.createCell(28);
          cell.setCellValue("Errore 7");
          cell.setCellStyle(cs);
          cell = row.createCell(29);
          cell.setCellValue("Origine Dati");
          cell.setCellStyle(cs);
          r=r+1;
          for (MemoryCursorRow_qbe_estrai_sv_ope_chk_all_vqr rowErrori : mcErrori._iterable_()) {
            /* _contarow := _contarow + 1 */
            _contarow = CPLib.Round(_contarow+1,0);
            /* _err1 := '' */
            _err1 = "";
            /* _err2 := '' */
            _err2 = "";
            /* _err3 := '' */
            _err3 = "";
            /* _err4 := '' */
            _err4 = "";
            /* _err5 := '' */
            _err5 = "";
            /* _err6 := '' */
            _err6 = "";
            /* _err7 := '' */
            _err7 = "";
            /* If Empty(rowErrori.PROVINCIA) */
            if (CPLib.Empty(rowErrori.PROVINCIA)) {
              /* _err1 := 'Provincia Cliente Assente' */
              _err1 = "Provincia Cliente Assente";
            } else { // Else
              /* If not(mcProvSV.GoToKey(rowErrori.PROVINCIA)) */
              if ( ! (mcProvSV.GoToKey(rowErrori.PROVINCIA))) {
                /* _err1 := 'Provincia Cliente Non Valida' */
                _err1 = "Provincia Cliente Non Valida";
              } // End If
            } // End If
            /* If Empty(rowErrori.PROVINCIA1) */
            if (CPLib.Empty(rowErrori.PROVINCIA1)) {
              /* _err2 := 'Provincia Agenzia Assente' */
              _err2 = "Provincia Agenzia Assente";
            } else { // Else
              /* If not(mcProvSV.GoToKey(rowErrori.PROVINCIA1)) */
              if ( ! (mcProvSV.GoToKey(rowErrori.PROVINCIA1))) {
                /* _err2 := 'Provincia Agenzia Non Valida' */
                _err2 = "Provincia Agenzia Non Valida";
              } // End If
            } // End If
            /* If Empty(rowErrori.PAESE) */
            if (CPLib.Empty(rowErrori.PAESE)) {
              /* _err3 := 'Stato Destinazione Assente' */
              _err3 = "Stato Destinazione Assente";
            } else { // Else
              /* If not(mcStatiSV.GoToKey(rowErrori.PAESE)) */
              if ( ! (mcStatiSV.GoToKey(rowErrori.PAESE))) {
                /* _err3 := 'Stato Destinazione non valido' */
                _err3 = "Stato Destinazione non valido";
              } else { // Else
                /* If At(LRTrim(rowErrori.PAESE),'|030|043|251') > 0 */
                if (CPLib.gt(CPLib.At(CPLib.LRTrim(rowErrori.PAESE),"|030|043|251"),0)) {
                  /* _err3 := 'Stato Destinazione non valido' */
                  _err3 = "Stato Destinazione non valido";
                } // End If
              } // End If
            } // End If
            /* If Empty(rowErrori.SOTGRUP) */
            if (CPLib.Empty(rowErrori.SOTGRUP)) {
              /* _err4 := 'SAE Assente' */
              _err4 = "SAE Assente";
            } else { // Else
              /* If (((rowErrori.SOTGRUP = '600' and At(rowErrori.SESSO,'|1|2')>0) or (rowErrori.SOTGRUP <> '600' and rowErrori.SOTGRUP < '700')) and rowErrori.PROVINCIA = 'EE') or (rowErrori.SOTGRUP >= '700' and rowErrori.PROVINCIA <> 'EE') */
              if ((((CPLib.eqr(rowErrori.SOTGRUP,"600") && CPLib.gt(CPLib.At(rowErrori.SESSO,"|1|2"),0)) || (CPLib.ne(rowErrori.SOTGRUP,"600") && CPLib.lt(rowErrori.SOTGRUP,"700"))) && CPLib.eqr(rowErrori.PROVINCIA,"EE")) || (CPLib.ge(rowErrori.SOTGRUP,"700") && CPLib.ne(rowErrori.PROVINCIA,"EE"))) {
                /* _err4 := 'SAE non valido' */
                _err4 = "SAE non valido";
              } else { // Else
                /* If not(mcStGru.GoToKey(rowErrori.SOTGRUP)) */
                if ( ! (mcStGru.GoToKey(rowErrori.SOTGRUP))) {
                  /* _err4 := 'SAE inesistente' */
                  _err4 = "SAE inesistente";
                } // End If
              } // End If
            } // End If
            /* If rowErrori.IMPOUT=0 */
            if (CPLib.eqr(rowErrori.IMPOUT,0)) {
              /* _err5 := 'Importo Assente' */
              _err5 = "Importo Assente";
            } // End If
            /* If Empty(rowErrori.SEGNO) */
            if (CPLib.Empty(rowErrori.SEGNO)) {
              /* _err6 := 'Segno Operazione Assente' */
              _err6 = "Segno Operazione Assente";
            } // End If
            /* If Empty(rowErrori.TIPOSV) */
            if (CPLib.Empty(rowErrori.TIPOSV)) {
              /* _err7 := 'Tipo dipendenza assente' */
              _err7 = "Tipo dipendenza assente";
            } // End If
            /* _datope := arfn_fdate(rowErrori.DATAOPE) */
            _datope = arfn_fdateR.Make(m_Ctx,this).Run(rowErrori.DATAOPE);
            //Creo il record da scrivere
            row = sheet.createRow(r);
            cell = row.createCell(0);
            cell.setCellValue(CPLib.LRTrim(rowErrori.NUMPROG));
            cell = row.createCell(1);
            cell.setCellValue(_datope);
            cell = row.createCell(2);
            cell.setCellValue(CPLib.LRTrim(rowErrori.SEGNO));
            cell = row.createCell(3);
            cell.setCellValue(CPLib.LRTrim(rowErrori.CODDIPE));
            cell = row.createCell(4);
            cell.setCellValue(CPLib.LRTrim(rowErrori.DESCRIZ));
            cell = row.createCell(5);
            cell.setCellValue(CPLib.LRTrim(rowErrori.PROVINCIA1));
            cell = row.createCell(6);
            cell.setCellValue(CPLib.LRTrim(rowErrori.TIPOSV));
            cell = row.createCell(7);
            cell.setCellValue(CPLib.LRTrim(rowErrori.CONNESCLI));
            cell = row.createCell(8);
            cell.setCellValue(CPLib.LRTrim(rowErrori.RAGSOC));
            cell = row.createCell(9);
            cell.setCellValue(CPLib.LRTrim(rowErrori.SOTGRUP));
            cell = row.createCell(10);
            cell.setCellValue(CPLib.LRTrim(rowErrori.PROVINCIA));
            cell = row.createCell(11);
            cell.setCellValue(rowErrori.IMPOUT);
            cell = row.createCell(12);
            cell.setCellValue(CPLib.LRTrim(rowErrori.PAESE));
            cell = row.createCell(13);
            cell.setCellValue(CPLib.LRTrim(rowErrori.TIPO));
            cell = row.createCell(14);
            cell.setCellValue(CPLib.LRTrim(rowErrori.CODFISC));
            cell = row.createCell(15);
            cell.setCellValue(CPLib.LRTrim(rowErrori.NASCOMUN));
            cell = row.createCell(16);
            cell.setCellValue(CPLib.LRTrim(rowErrori.NASSTATO));
            cell = row.createCell(17);
            cell.setCellValue(CPLib.LRTrim(rowErrori.TIPINTER));
            cell = row.createCell(18);
            cell.setCellValue(CPLib.LRTrim(rowErrori.DESCCIT));
            cell = row.createCell(19);
            cell.setCellValue(CPLib.LRTrim(rowErrori.CITAGE));
            cell = row.createCell(20);
            cell.setCellValue(CPLib.LRTrim(rowErrori.PAESERES));
            cell = row.createCell(21);
            cell.setCellValue(CPLib.LRTrim(rowErrori.INFORM));
            cell = row.createCell(22);
            cell.setCellValue(CPLib.LRTrim(_err1));
            cell = row.createCell(23);
            cell.setCellValue(CPLib.LRTrim(_err2));
            cell = row.createCell(24);
            cell.setCellValue(CPLib.LRTrim(_err3));
            cell = row.createCell(25);
            cell.setCellValue(CPLib.LRTrim(_err4));
            cell = row.createCell(26);
            cell.setCellValue(CPLib.LRTrim(_err5));
            cell = row.createCell(27);
            cell.setCellValue(CPLib.LRTrim(_err6));
            cell = row.createCell(28);
            cell.setCellValue(CPLib.LRTrim(_err7));
            cell = row.createCell(29);
            cell.setCellValue(CPLib.LRTrim(rowErrori.SORGENTE));
            r=r+1;
          }
          /* gMsgImp := 'Attendere. Creazione del file excel ...' // Messaggio Import */
          gMsgImp = "Attendere. Creazione del file excel ...";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
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
          sheet.autoSizeColumn(24);
          sheet.autoSizeColumn(25);
          sheet.autoSizeColumn(26);
          sheet.autoSizeColumn(27);
          sheet.autoSizeColumn(28);
          sheet.autoSizeColumn(29);
          // scrivo il file di esito
          FileOutputStream fileOut = new FileOutputStream(CPLib.LRTrim(_nfile));
          
          //write this workbook to an Outputstream.
          wb.write(fileOut);
          fileOut.flush();
          fileOut.close();
          /* gMsgProc := gMsgProc + 'Ora Fine Creazione File Excel: '+ arfn_fdatetime(DateTime()) + NL */
          gMsgProc = gMsgProc+"Ora Fine Creazione File Excel: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgProc := gMsgProc + 'Sono stati rilevati ' +LRTrim(Str(_contarow,10,0))+" errori." +NL */
          gMsgProc = gMsgProc+"Sono stati rilevati "+CPLib.LRTrim(CPLib.Str(_contarow,10,0))+" errori."+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* ElseIf pTipoBase3='B3IP' */
      } else if (CPLib.eqr(pTipoBase3,"B3IP")) {
        /* If mcErroriSV_IP.RecCount() > 0 or True */
        if (CPLib.gt(mcErroriSV_IP.RecCount(),0) || true) {
          /* gMsgProc := gMsgProc + 'Ora Inizio Creazione File Excel: '+ arfn_fdatetime(DateTime()) + NL */
          gMsgProc = gMsgProc+"Ora Inizio Creazione File Excel: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* _nfile := LRTrim(gPathApp)+"/appo/"+LRTrim(gAzienda)+"/"+LRTrim(outFileName)+".xlsx" */
          _nfile = CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(outFileName)+".xlsx";
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
          //scrivo la riga di intestazione
          cell =  row.createCell(0);
          cell.setCellValue("Tipo di Dato");
          cell.setCellStyle(cs);
          cell =  row.createCell(1);
          cell.setCellValue("ID");
          cell.setCellStyle(cs);
          cell = row.createCell(2);
          cell.setCellValue("Info");
          cell.setCellStyle(cs);
          cell = row.createCell(3);
          cell.setCellValue("Errore");
          cell.setCellStyle(cs);
          r=r+1;
          for (MemoryCursorRow_mcerrsvip_mcrdef rowErrori : mcErroriSV_IP._iterable_()) {
            /* _contarow := _contarow + 1 */
            _contarow = CPLib.Round(_contarow+1,0);
            //Creo il record da scrivere
            row = sheet.createRow(r);
            cell = row.createCell(0);
            cell.setCellValue(CPLib.LRTrim(rowErrori.tipodato));
            cell = row.createCell(1);
            cell.setCellValue(CPLib.LRTrim(rowErrori.id_dato));
            cell = row.createCell(2);
            cell.setCellValue(CPLib.LRTrim(rowErrori.info));
            cell = row.createCell(3);
            cell.setCellValue(CPLib.LRTrim(rowErrori.errore));
            r=r+1;
          }
          /* gMsgImp := 'Attendere. Creazione del file excel ...' // Messaggio Import */
          gMsgImp = "Attendere. Creazione del file excel ...";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          //Ridimensiono le colonne in base al contenuto
          sheet.trackAllColumnsForAutoSizing() ;
          sheet.autoSizeColumn(0);
          sheet.autoSizeColumn(1);
          sheet.autoSizeColumn(2);
          sheet.autoSizeColumn(3);
          
          // scrivo il file di esito
          FileOutputStream fileOut = new FileOutputStream(CPLib.LRTrim(_nfile));
          
          //write this workbook to an Outputstream.
          wb.write(fileOut);
          fileOut.flush();
          fileOut.close();
        } // End If
      } // End If
    } finally {
      try {
        if (Cursor_qbe_estrai_sv_ope_chk_all!=null)
          Cursor_qbe_estrai_sv_ope_chk_all.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void DatiCliente() throws Exception {
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    try {
      /* Prende i dati del cliente da storico o dai dati attuali */
      /* _source := '' */
      _source = "";
      /* _numsto := arfn_chkspers(_codcli,iif(_opestato='1',_operett,_opedata)) */
      _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(_codcli,(CPLib.eqr(_opestato,"1")?_operett:_opedata));
      /* If Empty(LRTrim(_numsto)) */
      if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
        // * --- Select from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
        Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codcli,"?",0,0,m_cServer, m_oParameters),m_cServer,_codcli)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_personbo.Eof())) {
          /* _sotgru := personbo->SOTGRUP */
          _sotgru = Cursor_personbo.GetString("SOTGRUP");
          /* _cragsoc := personbo->RAGSOC */
          _cragsoc = Cursor_personbo.GetString("RAGSOC");
          /* _provres := personbo->PROVINCIA */
          _provres = Cursor_personbo.GetString("PROVINCIA");
          /* _source := 'P' */
          _source = "P";
          Cursor_personbo.Next();
        }
        m_cConnectivityError = Cursor_personbo.ErrorMessage();
        Cursor_personbo.Close();
        // * --- End Select
      } else { // Else
        // * --- Select from wersonbo
        m_cServer = m_Ctx.GetServer("wersonbo");
        m_cPhName = m_Ctx.GetPhName("wersonbo");
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
        Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_wersonbo.Eof())) {
          /* _sotgru := wersonbo->SOTGRUP */
          _sotgru = Cursor_wersonbo.GetString("SOTGRUP");
          /* _cragsoc := wersonbo->RAGSOC */
          _cragsoc = Cursor_wersonbo.GetString("RAGSOC");
          /* _provres := wersonbo->PROVINCIA */
          _provres = Cursor_wersonbo.GetString("PROVINCIA");
          /* _source := 'W' */
          _source = "W";
          Cursor_wersonbo.Next();
        }
        m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
        Cursor_wersonbo.Close();
        // * --- End Select
        /* If Empty(_sotgru) or Empty(_paeseres) or Empty(_provres) */
        if (CPLib.Empty(_sotgru) || CPLib.Empty(_paeseres) || CPLib.Empty(_provres)) {
          // * --- Select from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          if (Cursor_personbo!=null)
            Cursor_personbo.Close();
          Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codcli,"?",0,0,m_cServer, m_oParameters),m_cServer,_codcli)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_personbo.Eof())) {
            /* _sotgru := personbo->SOTGRUP */
            _sotgru = Cursor_personbo.GetString("SOTGRUP");
            /* _cragsoc := personbo->RAGSOC */
            _cragsoc = Cursor_personbo.GetString("RAGSOC");
            /* _provres := personbo->PROVINCIA */
            _provres = Cursor_personbo.GetString("PROVINCIA");
            /* _source := 'P' */
            _source = "P";
            Cursor_personbo.Next();
          }
          m_cConnectivityError = Cursor_personbo.ErrorMessage();
          Cursor_personbo.Close();
          // * --- End Select
        } // End If
      } // End If
    } finally {
      try {
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void CheckIP() throws Exception {
    CPResultSet Cursor_qbe_estrai_sv_all_ip_1=null;
    CPResultSet Cursor_qbe_sv_idp_rapporti=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_qbe_estrai_sv_all_ip_2_a=null;
    CPResultSet Cursor_tbstgru=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* gMsgProc := 'Ora Inizio Verifica per SV: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = "Ora Inizio Verifica per SV: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* outFileName := "CheckSV_IP"+LRTrim(gIntemediario)+"_"+Str(pAnno,4,0)+"_"+Str(pTri,1,0) */
      outFileName = "CheckSV_IP"+CPLib.LRTrim(gIntemediario)+"_"+CPLib.Str(pAnno,4,0)+"_"+CPLib.Str(pTri,1,0);
      /* _dataFinePeriodo Date := CharToDate(_datfin) */
      java.sql.Date _dataFinePeriodo;
      _dataFinePeriodo = CPLib.CharToDate(_datfin);
      /* _pSegno Char(0) */
      /* err_count Numeric(0, 0) := 0 */
      double err_count;
      err_count = CPLib.Round(0,0);
      // * --- Fill memory cursor mcRapportiSVIP on qbe_estrai_sv_all_ip_1
      mcRapportiSVIP.Zap();
      SPBridge.HMCaller _h00000164;
      _h00000164 = new SPBridge.HMCaller();
      _h00000164.Set("m_cVQRList",m_cVQRList);
      _h00000164.Set("pANNO",pAnno);
      _h00000164.Set("pTRIMESTRE",pTri);
      _h00000164.Set("pDATAF_INI",_datini);
      _h00000164.Set("pDATAF_FIN",_datfin);
      if (Cursor_qbe_estrai_sv_all_ip_1!=null)
        Cursor_qbe_estrai_sv_all_ip_1.Close();
      Cursor_qbe_estrai_sv_all_ip_1 = new VQRHolder("qbe_estrai_sv_all_ip_1",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000164,true).GetResultSet(m_Ctx);
      {
        final CPResultSet m_TheCursor = Cursor_qbe_estrai_sv_all_ip_1;
        Cursor_qbe_estrai_sv_all_ip_1.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_estrai_sv_check_all: query on qbe_estrai_sv_all_ip_1 returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_qbe_estrai_sv_all_ip_1.Eof())) {
        mcRapportiSVIP.AppendBlank();
        mcRapportiSVIP.row.RAPPORTO = Cursor_qbe_estrai_sv_all_ip_1.GetString("RAPPORTO");
        mcRapportiSVIP.row.DESCRAP = Cursor_qbe_estrai_sv_all_ip_1.GetString("DESCRAP");
        mcRapportiSVIP.row.ANNO = Cursor_qbe_estrai_sv_all_ip_1.GetString("ANNO");
        mcRapportiSVIP.row.TRIMESTRE = Cursor_qbe_estrai_sv_all_ip_1.GetString("TRIMESTRE");
        mcRapportiSVIP.row.IMPORTO = Cursor_qbe_estrai_sv_all_ip_1.GetDouble("IMPORTO");
        mcRapportiSVIP.row.CODINTER = Cursor_qbe_estrai_sv_all_ip_1.GetString("CODINTER");
        mcRapportiSVIP.row.DATA_INI = Cursor_qbe_estrai_sv_all_ip_1.GetDate("DATA_INI");
        mcRapportiSVIP.row.DATA_FIN = Cursor_qbe_estrai_sv_all_ip_1.GetDate("DATA_FIN");
        mcRapportiSVIP.row.TIPORAP = Cursor_qbe_estrai_sv_all_ip_1.GetString("TIPORAP");
        mcRapportiSVIP.row.DATARETT = Cursor_qbe_estrai_sv_all_ip_1.GetDate("DATARETT");
        Cursor_qbe_estrai_sv_all_ip_1.Next();
      }
      m_cConnectivityError = Cursor_qbe_estrai_sv_all_ip_1.ErrorMessage();
      Cursor_qbe_estrai_sv_all_ip_1.Close();
      mcRapportiSVIP.GoTop();
      // * --- Fill memory cursor mcRapportiNS on qbe_sv_idp_rapporti
      mcRapportiNS.Zap();
      SPBridge.HMCaller _h00000165;
      _h00000165 = new SPBridge.HMCaller();
      _h00000165.Set("m_cVQRList",m_cVQRList);
      _h00000165.Set("pANNO",pAnno);
      _h00000165.Set("pTRIMESTRE",pTri);
      _h00000165.Set("pDATAF_INI",_datini);
      if (Cursor_qbe_sv_idp_rapporti!=null)
        Cursor_qbe_sv_idp_rapporti.Close();
      Cursor_qbe_sv_idp_rapporti = new VQRHolder("qbe_sv_idp_rapporti",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000165,true).GetResultSet(m_Ctx);
      {
        final CPResultSet m_TheCursor = Cursor_qbe_sv_idp_rapporti;
        Cursor_qbe_sv_idp_rapporti.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_estrai_sv_check_all: query on qbe_sv_idp_rapporti returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_qbe_sv_idp_rapporti.Eof())) {
        mcRapportiNS.AppendBlank();
        mcRapportiNS.row.RAPPORTO = Cursor_qbe_sv_idp_rapporti.GetString("RAPPORTO");
        mcRapportiNS.row.DESCRAP = Cursor_qbe_sv_idp_rapporti.GetString("DESCRAP");
        Cursor_qbe_sv_idp_rapporti.Next();
      }
      m_cConnectivityError = Cursor_qbe_sv_idp_rapporti.ErrorMessage();
      Cursor_qbe_sv_idp_rapporti.Close();
      mcRapportiNS.GoTop();
      /* gMsgProc := gMsgProc + 'Ora inizio Verifica Rapporti per SV: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora inizio Verifica Rapporti per SV: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Rapporti in essere o cessati nel trimestre da verificare: '+ mcRapportiSVIP.RecCount() + NL */
      gMsgProc = gMsgProc+"Rapporti in essere o cessati nel trimestre da verificare: "+mcRapportiSVIP.RecCount()+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      for (MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr rw_rapp : mcRapportiSVIP._iterable_()) {
        /* -- mi prendo il soggetto collegato */
        /* If not(mcClientiSVIP.HasKey(rw_rapp.CODINTER)) */
        if ( ! (mcClientiSVIP.HasKey(rw_rapp.CODINTER))) {
          /* rowClientiSVIP := new Row(mcEstraiSV_clienti.MCRDef) */
          rowClientiSVIP = new MemoryCursorRow_mcestraisv_clienti_mcrdef();
          // * --- Select from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          if (Cursor_personbo!=null)
            Cursor_personbo.Close();
          Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+""+CPSql.SQLValueAdapter(CPLib.ToSQL(rw_rapp.CODINTER,"?",0,0,m_cServer, m_oParameters),m_cServer,rw_rapp.CODINTER)+"=CONNES "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_personbo.Eof())) {
            /* rowClientiSVIP.NDG := personbo->CONNES // 05.01 */
            rowClientiSVIP.NDG = Cursor_personbo.GetString("CONNES");
            /* rowClientiSVIP.RAGSOC := personbo->RAGSOC // 05.03 */
            rowClientiSVIP.RAGSOC = Cursor_personbo.GetString("RAGSOC");
            /* rowClientiSVIP.PROV := personbo->PROVINCIA // 05.04 */
            rowClientiSVIP.PROV = Cursor_personbo.GetString("PROVINCIA");
            /* rowClientiSVIP.SAE := personbo->SOTGRUP // 05.05 */
            rowClientiSVIP.SAE = Cursor_personbo.GetString("SOTGRUP");
            /* rowClientiSVIP.ATECO := personbo->ATTIV // 05.06 */
            rowClientiSVIP.ATECO = Cursor_personbo.GetString("ATTIV");
            /* rowClientiSVIP.SPECIE := personbo->PKTBSPECIE // 05.06 */
            rowClientiSVIP.SPECIE = Cursor_personbo.GetString("PKTBSPECIE");
            /* rowClientiSVIP.CODFISC := personbo->CODFISC // 05.06 */
            rowClientiSVIP.CODFISC = Cursor_personbo.GetString("CODFISC");
            // Exit Loop
            if (true) {
              break;
            }
            Cursor_personbo.Next();
          }
          m_cConnectivityError = Cursor_personbo.ErrorMessage();
          Cursor_personbo.Close();
          // * --- End Select
          /* mcClientiSVIP.AppendRowWithKey(rw_rapp.CODINTER,rowClientiSVIP) // File 3 delle SV per IP (Clienti.txt) */
          mcClientiSVIP.AppendRowWithKey(rw_rapp.CODINTER,rowClientiSVIP);
        } // End If
        /* -- controllo il rapporto */
        /* If not(Empty(rw_rapp.DATA_FIN)) and rw_rapp.DATA_FIN<=_dataFinePeriodo and not(rw_rapp.IMPORTO=0) */
        if ( ! (CPLib.Empty(rw_rapp.DATA_FIN)) && CPLib.le(rw_rapp.DATA_FIN,_dataFinePeriodo) &&  ! (CPLib.eqr(rw_rapp.IMPORTO,0))) {
          /* mcErroriSV_IP.AppendBlank() */
          mcErroriSV_IP.AppendBlank();
          /* mcErroriSV_IP.tipodato := 'RAPPORTO' */
          mcErroriSV_IP.row.tipodato = "RAPPORTO";
          /* mcErroriSV_IP.id_dato := rw_rapp.RAPPORTO */
          mcErroriSV_IP.row.id_dato = rw_rapp.RAPPORTO;
          /* mcErroriSV_IP.info := rw_rapp.DESCRAP */
          mcErroriSV_IP.row.info = rw_rapp.DESCRAP;
          /* mcErroriSV_IP.errore := 'Cessato nel trimestre con saldo diverso da zero' */
          mcErroriSV_IP.row.errore = "Cessato nel trimestre con saldo diverso da zero";
          /* err_count := err_count+1 */
          err_count = CPLib.Round(err_count+1,0);
        } // End If
      }
      /* gMsgProc := gMsgProc + 'Ora Fine Verifica Rapporti per SV: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Fine Verifica Rapporti per SV: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Rapporti con anomalie: '+ err_count + NL */
      gMsgProc = gMsgProc+"Rapporti con anomalie: "+err_count+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      for (MemoryCursorRow_qbe_sv_idp_rapporti_vqr rw_rappNS : mcRapportiNS._iterable_()) {
        /* mcErroriSV_IP.AppendBlank() */
        mcErroriSV_IP.AppendBlank();
        /* mcErroriSV_IP.tipodato := 'RAPPORTO' */
        mcErroriSV_IP.row.tipodato = "RAPPORTO";
        /* mcErroriSV_IP.id_dato := rw_rappNS.RAPPORTO */
        mcErroriSV_IP.row.id_dato = rw_rappNS.RAPPORTO;
        /* mcErroriSV_IP.info := rw_rappNS.DESCRAP */
        mcErroriSV_IP.row.info = rw_rappNS.DESCRAP;
        /* mcErroriSV_IP.errore := 'Rapporto in essere (o cessato) nel trimestre senza saldo' */
        mcErroriSV_IP.row.errore = "Rapporto in essere (o cessato) nel trimestre senza saldo";
        /* err_count := err_count+1 */
        err_count = CPLib.Round(err_count+1,0);
      }
      /* If pTri=2 or pTri=4 */
      if (CPLib.eqr(pTri,2) || CPLib.eqr(pTri,4)) {
        /* Estraggo tutto il semestre  */
        // * --- Fill memory cursor mcOperazioniSVIP on qbe_estrai_sv_all_ip_2_a
        mcOperazioniSVIP.Zap();
        SPBridge.HMCaller _h0000018E;
        _h0000018E = new SPBridge.HMCaller();
        _h0000018E.Set("m_cVQRList",m_cVQRList);
        _h0000018E.Set("pDataINI",_datinisem);
        _h0000018E.Set("pDataFIN",_datfinsem);
        if (Cursor_qbe_estrai_sv_all_ip_2_a!=null)
          Cursor_qbe_estrai_sv_all_ip_2_a.Close();
        Cursor_qbe_estrai_sv_all_ip_2_a = new VQRHolder("qbe_estrai_sv_all_ip_2_a",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000018E,true).GetResultSet(m_Ctx);
        {
          final CPResultSet m_TheCursor = Cursor_qbe_estrai_sv_all_ip_2_a;
          Cursor_qbe_estrai_sv_all_ip_2_a.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arrt_estrai_sv_check_all: query on qbe_estrai_sv_all_ip_2_a returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_qbe_estrai_sv_all_ip_2_a.Eof())) {
          mcOperazioniSVIP.AppendBlank();
          mcOperazioniSVIP.row.IDBASE = Cursor_qbe_estrai_sv_all_ip_2_a.GetString("IDBASE");
          mcOperazioniSVIP.row.RAPPORTO = Cursor_qbe_estrai_sv_all_ip_2_a.GetString("RAPPORTO");
          mcOperazioniSVIP.row.TOTLIRE = Cursor_qbe_estrai_sv_all_ip_2_a.GetDouble("TOTLIRE");
          mcOperazioniSVIP.row.DATAOPE = Cursor_qbe_estrai_sv_all_ip_2_a.GetDate("DATAOPE");
          mcOperazioniSVIP.row.SV58550 = Cursor_qbe_estrai_sv_all_ip_2_a.GetString("SV58550");
          mcOperazioniSVIP.row.PAESE = Cursor_qbe_estrai_sv_all_ip_2_a.GetString("PAESE");
          mcOperazioniSVIP.row.PROVINCIA = Cursor_qbe_estrai_sv_all_ip_2_a.GetString("PROVINCIA");
          mcOperazioniSVIP.row.SV58550MA = Cursor_qbe_estrai_sv_all_ip_2_a.GetString("SV58550MA");
          mcOperazioniSVIP.row.VALUTA = Cursor_qbe_estrai_sv_all_ip_2_a.GetString("VALUTA");
          mcOperazioniSVIP.row.FONTE = Cursor_qbe_estrai_sv_all_ip_2_a.GetString("FONTE");
          mcOperazioniSVIP.row.NUMPROG = Cursor_qbe_estrai_sv_all_ip_2_a.GetString("NUMPROG");
          mcOperazioniSVIP.row.SEGNO = Cursor_qbe_estrai_sv_all_ip_2_a.GetString("SEGNO");
          mcOperazioniSVIP.row.SV58724 = Cursor_qbe_estrai_sv_all_ip_2_a.GetString("SV58724");
          mcOperazioniSVIP.row.SV58726SCA = Cursor_qbe_estrai_sv_all_ip_2_a.GetString("SV58726SCA");
          mcOperazioniSVIP.row.SV58726SA = Cursor_qbe_estrai_sv_all_ip_2_a.GetString("SV58726SA");
          mcOperazioniSVIP.row.SV58726PISP = Cursor_qbe_estrai_sv_all_ip_2_a.GetString("SV58726PISP");
          Cursor_qbe_estrai_sv_all_ip_2_a.Next();
        }
        m_cConnectivityError = Cursor_qbe_estrai_sv_all_ip_2_a.ErrorMessage();
        Cursor_qbe_estrai_sv_all_ip_2_a.Close();
        mcOperazioniSVIP.GoTop();
      } else { // Else
        /* Estraggo solo il trimestre  */
        // * --- Fill memory cursor mcOperazioniSVIP on qbe_estrai_sv_all_ip_2_a
        mcOperazioniSVIP.Zap();
        SPBridge.HMCaller _h00000190;
        _h00000190 = new SPBridge.HMCaller();
        _h00000190.Set("m_cVQRList",m_cVQRList);
        _h00000190.Set("pDataINI",_datini);
        _h00000190.Set("pDataFIN",_datfin);
        if (Cursor_qbe_estrai_sv_all_ip_2_a!=null)
          Cursor_qbe_estrai_sv_all_ip_2_a.Close();
        Cursor_qbe_estrai_sv_all_ip_2_a = new VQRHolder("qbe_estrai_sv_all_ip_2_a",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000190,true).GetResultSet(m_Ctx);
        {
          final CPResultSet m_TheCursor = Cursor_qbe_estrai_sv_all_ip_2_a;
          Cursor_qbe_estrai_sv_all_ip_2_a.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arrt_estrai_sv_check_all: query on qbe_estrai_sv_all_ip_2_a returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_qbe_estrai_sv_all_ip_2_a.Eof())) {
          mcOperazioniSVIP.AppendBlank();
          mcOperazioniSVIP.row.IDBASE = Cursor_qbe_estrai_sv_all_ip_2_a.GetString("IDBASE");
          mcOperazioniSVIP.row.RAPPORTO = Cursor_qbe_estrai_sv_all_ip_2_a.GetString("RAPPORTO");
          mcOperazioniSVIP.row.TOTLIRE = Cursor_qbe_estrai_sv_all_ip_2_a.GetDouble("TOTLIRE");
          mcOperazioniSVIP.row.DATAOPE = Cursor_qbe_estrai_sv_all_ip_2_a.GetDate("DATAOPE");
          mcOperazioniSVIP.row.SV58550 = Cursor_qbe_estrai_sv_all_ip_2_a.GetString("SV58550");
          mcOperazioniSVIP.row.PAESE = Cursor_qbe_estrai_sv_all_ip_2_a.GetString("PAESE");
          mcOperazioniSVIP.row.PROVINCIA = Cursor_qbe_estrai_sv_all_ip_2_a.GetString("PROVINCIA");
          mcOperazioniSVIP.row.SV58550MA = Cursor_qbe_estrai_sv_all_ip_2_a.GetString("SV58550MA");
          mcOperazioniSVIP.row.VALUTA = Cursor_qbe_estrai_sv_all_ip_2_a.GetString("VALUTA");
          mcOperazioniSVIP.row.FONTE = Cursor_qbe_estrai_sv_all_ip_2_a.GetString("FONTE");
          mcOperazioniSVIP.row.NUMPROG = Cursor_qbe_estrai_sv_all_ip_2_a.GetString("NUMPROG");
          mcOperazioniSVIP.row.SEGNO = Cursor_qbe_estrai_sv_all_ip_2_a.GetString("SEGNO");
          mcOperazioniSVIP.row.SV58724 = Cursor_qbe_estrai_sv_all_ip_2_a.GetString("SV58724");
          mcOperazioniSVIP.row.SV58726SCA = Cursor_qbe_estrai_sv_all_ip_2_a.GetString("SV58726SCA");
          mcOperazioniSVIP.row.SV58726SA = Cursor_qbe_estrai_sv_all_ip_2_a.GetString("SV58726SA");
          mcOperazioniSVIP.row.SV58726PISP = Cursor_qbe_estrai_sv_all_ip_2_a.GetString("SV58726PISP");
          Cursor_qbe_estrai_sv_all_ip_2_a.Next();
        }
        m_cConnectivityError = Cursor_qbe_estrai_sv_all_ip_2_a.ErrorMessage();
        Cursor_qbe_estrai_sv_all_ip_2_a.Close();
        mcOperazioniSVIP.GoTop();
      } // End If
      /* gMsgProc := gMsgProc + 'Ora inizio Verifica Operazioni per SV: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora inizio Verifica Operazioni per SV: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Operazioni da verificare: '+ mcOperazioniSVIP.RecCount() + NL */
      gMsgProc = gMsgProc+"Operazioni da verificare: "+mcOperazioniSVIP.RecCount()+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      for (MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr rw_ope : mcOperazioniSVIP._iterable_()) {
        /* If Empty(rw_ope.SEGNO) */
        if (CPLib.Empty(rw_ope.SEGNO)) {
          /* mcErroriSV_IP.AppendBlank() */
          mcErroriSV_IP.AppendBlank();
          /* mcErroriSV_IP.tipodato := iif(mcOperazioniSVIP.FONTE="OPE", "OPERAZIONE", "FRAZIONATA") */
          mcErroriSV_IP.row.tipodato = (CPLib.eqr(mcOperazioniSVIP.row.FONTE,"OPE")?"OPERAZIONE":"FRAZIONATA");
          /* mcErroriSV_IP.id_dato := rw_ope.NUMPROG */
          mcErroriSV_IP.row.id_dato = rw_ope.NUMPROG;
          /* mcErroriSV_IP.info := DateToChar(rw_ope.DATAOPE) */
          mcErroriSV_IP.row.info = CPLib.DateToChar(rw_ope.DATAOPE);
          /* mcErroriSV_IP.errore := 'Campo "Segno" non settato' */
          mcErroriSV_IP.row.errore = "Campo \"Segno\" non settato";
        } // End If
        /* If not(Empty(rw_ope.SEGNO)) and rw_ope.SEGNO='D' */
        if ( ! (CPLib.Empty(rw_ope.SEGNO)) && CPLib.eqr(rw_ope.SEGNO,"D")) {
          /* If Empty(rw_ope.SV58550MA) */
          if (CPLib.Empty(rw_ope.SV58550MA)) {
            /* mcErroriSV_IP.AppendBlank() */
            mcErroriSV_IP.AppendBlank();
            /* mcErroriSV_IP.tipodato := iif(mcOperazioniSVIP.FONTE="OPE", "OPERAZIONE", "FRAZIONATA") */
            mcErroriSV_IP.row.tipodato = (CPLib.eqr(mcOperazioniSVIP.row.FONTE,"OPE")?"OPERAZIONE":"FRAZIONATA");
            /* mcErroriSV_IP.id_dato := rw_ope.NUMPROG */
            mcErroriSV_IP.row.id_dato = rw_ope.NUMPROG;
            /* mcErroriSV_IP.info := DateToChar(rw_ope.DATAOPE) */
            mcErroriSV_IP.row.info = CPLib.DateToChar(rw_ope.DATAOPE);
            /* mcErroriSV_IP.errore := 'Campo "Modalità Avvio" non settato' */
            mcErroriSV_IP.row.errore = "Campo \"Modalità Avvio\" non settato";
          } // End If
          /* If Empty(rw_ope.SV58550) */
          if (CPLib.Empty(rw_ope.SV58550)) {
            /* mcErroriSV_IP.AppendBlank() */
            mcErroriSV_IP.AppendBlank();
            /* mcErroriSV_IP.tipodato := iif(mcOperazioniSVIP.FONTE="OPE", "OPERAZIONE", "FRAZIONATA") */
            mcErroriSV_IP.row.tipodato = (CPLib.eqr(mcOperazioniSVIP.row.FONTE,"OPE")?"OPERAZIONE":"FRAZIONATA");
            /* mcErroriSV_IP.id_dato := rw_ope.NUMPROG */
            mcErroriSV_IP.row.id_dato = rw_ope.NUMPROG;
            /* mcErroriSV_IP.info := DateToChar(rw_ope.DATAOPE) */
            mcErroriSV_IP.row.info = CPLib.DateToChar(rw_ope.DATAOPE);
            /* mcErroriSV_IP.errore := 'Campo "SV58550" non settato' */
            mcErroriSV_IP.row.errore = "Campo \"SV58550\" non settato";
          } // End If
        } // End If
        /* If Empty(rw_ope.PROVINCIA) */
        if (CPLib.Empty(rw_ope.PROVINCIA)) {
          /* mcErroriSV_IP.AppendBlank() */
          mcErroriSV_IP.AppendBlank();
          /* mcErroriSV_IP.tipodato := iif(mcOperazioniSVIP.FONTE="OPE", "OPERAZIONE", "FRAZIONATA") */
          mcErroriSV_IP.row.tipodato = (CPLib.eqr(mcOperazioniSVIP.row.FONTE,"OPE")?"OPERAZIONE":"FRAZIONATA");
          /* mcErroriSV_IP.id_dato := rw_ope.NUMPROG */
          mcErroriSV_IP.row.id_dato = rw_ope.NUMPROG;
          /* mcErroriSV_IP.info := DateToChar(rw_ope.DATAOPE) */
          mcErroriSV_IP.row.info = CPLib.DateToChar(rw_ope.DATAOPE);
          /* mcErroriSV_IP.errore := 'Campo "Provincia" non settato' */
          mcErroriSV_IP.row.errore = "Campo \"Provincia\" non settato";
        } // End If
        /* If Empty(rw_ope.PAESE) */
        if (CPLib.Empty(rw_ope.PAESE)) {
          /* mcErroriSV_IP.AppendBlank() */
          mcErroriSV_IP.AppendBlank();
          /* mcErroriSV_IP.tipodato := iif(mcOperazioniSVIP.FONTE="OPE", "OPERAZIONE", "FRAZIONATA") */
          mcErroriSV_IP.row.tipodato = (CPLib.eqr(mcOperazioniSVIP.row.FONTE,"OPE")?"OPERAZIONE":"FRAZIONATA");
          /* mcErroriSV_IP.id_dato := rw_ope.NUMPROG */
          mcErroriSV_IP.row.id_dato = rw_ope.NUMPROG;
          /* mcErroriSV_IP.info := DateToChar(rw_ope.DATAOPE) */
          mcErroriSV_IP.row.info = CPLib.DateToChar(rw_ope.DATAOPE);
          /* mcErroriSV_IP.errore := 'Campo "Paese Intermediario Controparte" non settato' */
          mcErroriSV_IP.row.errore = "Campo \"Paese Intermediario Controparte\" non settato";
        } // End If
        /* If Empty(rw_ope.RAPPORTO) */
        if (CPLib.Empty(rw_ope.RAPPORTO)) {
          /* mcErroriSV_IP.AppendBlank() */
          mcErroriSV_IP.AppendBlank();
          /* mcErroriSV_IP.tipodato := iif(mcOperazioniSVIP.FONTE="OPE", "OPERAZIONE", "FRAZIONATA") */
          mcErroriSV_IP.row.tipodato = (CPLib.eqr(mcOperazioniSVIP.row.FONTE,"OPE")?"OPERAZIONE":"FRAZIONATA");
          /* mcErroriSV_IP.id_dato := rw_ope.NUMPROG */
          mcErroriSV_IP.row.id_dato = rw_ope.NUMPROG;
          /* mcErroriSV_IP.info := DateToChar(rw_ope.DATAOPE) */
          mcErroriSV_IP.row.info = CPLib.DateToChar(rw_ope.DATAOPE);
          /* mcErroriSV_IP.errore := 'Operazione senza rapporto associato' */
          mcErroriSV_IP.row.errore = "Operazione senza rapporto associato";
        } // End If
      }
      /* gMsgProc := gMsgProc + 'Ora Fine Verifica Operazioni per SV: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Fine Verifica Operazioni per SV: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora inizio Verifica Soggetti per SV: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora inizio Verifica Soggetti per SV: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Soggetti da verificare: '+ mcClientiSVIP.RecCount() + NL */
      gMsgProc = gMsgProc+"Soggetti da verificare: "+mcClientiSVIP.RecCount()+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // * --- Fill memory cursor mcTbSotgru on tbstgru
      mcTbSotgru.Zap();
      m_cServer = m_Ctx.GetServer("tbstgru");
      m_cPhName = m_Ctx.GetPhName("tbstgru");
      if (Cursor_tbstgru!=null)
        Cursor_tbstgru.Close();
      Cursor_tbstgru = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbstgru")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_tbstgru;
        Cursor_tbstgru.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_estrai_sv_check_all: query on tbstgru returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_tbstgru.Eof())) {
        mcTbSotgru.AppendWithTrimmedKey(Cursor_tbstgru.GetString("SOTGRU"));
        mcTbSotgru.row.SOTGRU = Cursor_tbstgru.GetString("SOTGRU");
        mcTbSotgru.row.DESCRI = Cursor_tbstgru.GetString("DESCRI");
        mcTbSotgru.row.TIPOSOT = Cursor_tbstgru.GetString("TIPOSOT");
        mcTbSotgru.row.DATAINI = Cursor_tbstgru.GetDate("DATAINI");
        mcTbSotgru.row.DATAFINE = Cursor_tbstgru.GetDate("DATAFINE");
        Cursor_tbstgru.Next();
      }
      m_cConnectivityError = Cursor_tbstgru.ErrorMessage();
      Cursor_tbstgru.Close();
      mcTbSotgru.GoTop();
      for (MemoryCursorRow_mcestraisv_clienti_mcrdef rw_cli : mcClientiSVIP._iterable_()) {
        /* If Empty(rw_cli.SPECIE) */
        if (CPLib.Empty(rw_cli.SPECIE)) {
          /* mcErroriSV_IP.AppendBlank() */
          mcErroriSV_IP.AppendBlank();
          /* mcErroriSV_IP.tipodato := 'SOGGETTO' */
          mcErroriSV_IP.row.tipodato = "SOGGETTO";
          /* mcErroriSV_IP.id_dato := rw_cli.NDG */
          mcErroriSV_IP.row.id_dato = rw_cli.NDG;
          /* mcErroriSV_IP.info := rw_cli.RAGSOC */
          mcErroriSV_IP.row.info = rw_cli.RAGSOC;
          /* mcErroriSV_IP.errore := 'Campo "SPECIE" non settato' */
          mcErroriSV_IP.row.errore = "Campo \"SPECIE\" non settato";
          /* ElseIf Empty(rw_cli.CODFISC) and rw_cli.CFESTERO=0 */
        } else if (CPLib.Empty(rw_cli.CODFISC) && CPLib.eqr(rw_cli.CFESTERO,0)) {
          /* mcErroriSV_IP.AppendBlank() */
          mcErroriSV_IP.AppendBlank();
          /* mcErroriSV_IP.tipodato := 'SOGGETTO' */
          mcErroriSV_IP.row.tipodato = "SOGGETTO";
          /* mcErroriSV_IP.id_dato := rw_cli.NDG */
          mcErroriSV_IP.row.id_dato = rw_cli.NDG;
          /* mcErroriSV_IP.info := rw_cli.RAGSOC */
          mcErroriSV_IP.row.info = rw_cli.RAGSOC;
          /* mcErroriSV_IP.errore := 'Campo "CODICE FISCALE" non settato' */
          mcErroriSV_IP.row.errore = "Campo \"CODICE FISCALE\" non settato";
          /* ElseIf not(Empty(rw_cli.CODFISC)) and (Len(rw_cli.CODFISC)<>16 and Len(rw_cli.CODFISC)<>11) and rw_cli.CFESTERO=0 */
        } else if ( ! (CPLib.Empty(rw_cli.CODFISC)) && (CPLib.ne(CPLib.Len(rw_cli.CODFISC),16) && CPLib.ne(CPLib.Len(rw_cli.CODFISC),11)) && CPLib.eqr(rw_cli.CFESTERO,0)) {
          /* mcErroriSV_IP.AppendBlank() */
          mcErroriSV_IP.AppendBlank();
          /* mcErroriSV_IP.tipodato := 'SOGGETTO' */
          mcErroriSV_IP.row.tipodato = "SOGGETTO";
          /* mcErroriSV_IP.id_dato := rw_cli.NDG */
          mcErroriSV_IP.row.id_dato = rw_cli.NDG;
          /* mcErroriSV_IP.info := rw_cli.RAGSOC */
          mcErroriSV_IP.row.info = rw_cli.RAGSOC;
          /* mcErroriSV_IP.errore := 'Campo "CODICE FISCALE" lunghezza errata' */
          mcErroriSV_IP.row.errore = "Campo \"CODICE FISCALE\" lunghezza errata";
        } // End If
      }
      /* gMsgProc := gMsgProc + 'Ora Fine Verifica Soggetti per SV: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Fine Verifica Soggetti per SV: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Exec "Crea File Excel" Page 4:Excel */
      Excel();
    } finally {
      try {
        if (Cursor_qbe_estrai_sv_all_ip_1!=null)
          Cursor_qbe_estrai_sv_all_ip_1.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_sv_idp_rapporti!=null)
          Cursor_qbe_sv_idp_rapporti.Close();
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
        if (Cursor_qbe_estrai_sv_all_ip_2_a!=null)
          Cursor_qbe_estrai_sv_all_ip_2_a.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tbstgru!=null)
          Cursor_tbstgru.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(double p_pAnno,double p_pTri,String p_pTipo,String p_pFile,String p_pTipoBase3,String p_pFraudo) {
    pAnno = p_pAnno;
    pTri = p_pTri;
    pTipo = p_pTipo;
    pFile = p_pFile;
    pTipoBase3 = p_pTipoBase3;
    pFraudo = p_pFraudo;
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
  public String Run(double p_pAnno,double p_pTri,String p_pTipo,String p_pFile,String p_pTipoBase3,String p_pFraudo) {
    pAnno = p_pAnno;
    pTri = p_pTri;
    pTipo = p_pTipo;
    pFile = p_pFile;
    pTipoBase3 = p_pTipoBase3;
    pFraudo = p_pFraudo;
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
          Page_Main();
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
  public static arrt_estrai_sv_check_allR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_estrai_sv_check_allR(p_Ctx, p_Caller);
  }
  public static arrt_estrai_sv_check_allR Make(CPContext p_Ctx) {
    return new arrt_estrai_sv_check_allR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pAnno = 0;
    pTri = 0;
    pTipo = CPLib.Space(1);
    pFile = CPLib.Space(80);
    pTipoBase3 = CPLib.Space(4);
    pFraudo = CPLib.Space(1);
    _datini = CPLib.Space(8);
    _datfin = CPLib.Space(8);
    _datinisem = CPLib.Space(8);
    _datfinsem = CPLib.Space(8);
    cRitorno = CPLib.Space(30);
    fhand = CPLib.Space(1);
    riga = "";
    nFile = CPLib.Space(20);
    outFileName = CPLib.Space(30);
    inFileName = CPLib.Space(80);
    _conta = 0;
    _bottom = 0;
    _top = 0;
    _max = 0;
    _cicli = 0;
    _min = 0;
    _mono = 0;
    _tot = 0;
    _reccount = 0;
    _contarow = 0;
    _tcont = CPLib.Space(3);
    _importo = 0;
    _codcli = CPLib.Space(16);
    _sotgru = CPLib.Space(3);
    _cragsoc = CPLib.Space(70);
    _paeseres = CPLib.Space(3);
    _provres = CPLib.Space(2);
    _provage = CPLib.Space(2);
    mcStati = new MemoryCursor_tbstati();
    mcErrori = new MemoryCursor_qbe_estrai_sv_ope_chk_all_vqr();
    mcDati = new MemoryCursor_qbe_estrai_sv_ope_tab_all_vqr();
    _nfile = CPLib.Space(120);
    _datope = CPLib.Space(10);
    _ddatini = CPLib.NullDate();
    _ddatfin = CPLib.NullDate();
    _dataoggi = CPLib.NullDate();
    _cdataoggi = CPLib.Space(8);
    _oldmsg = "";
    _valuta = CPLib.Space(1);
    _opedata = CPLib.NullDate();
    _operett = CPLib.NullDate();
    _opestato = CPLib.Space(1);
    _numsto = CPLib.Space(15);
    mcStatiSV = new MemoryCursor_qbe_statisv_vqr();
    mcProvSV = new MemoryCursor_qbe_provsv_vqr();
    mcStGru = new MemoryCursor_qbe_stgru_vqr();
    _source = CPLib.Space(1);
    mcRapportiSVIP = new MemoryCursor_qbe_estrai_sv_all_ip_1_vqr();
    mcRapportiNS = new MemoryCursor_qbe_sv_idp_rapporti_vqr();
    mcOperazioniSVIP = new MemoryCursor_qbe_estrai_sv_all_ip_2_a_vqr();
    mcClientiSVIP = new MemoryCursor_mcestraisv_clienti_mcrdef();
    rowClientiSVIP = new MemoryCursorRow_mcestraisv_clienti_mcrdef();
    mcTbSotgru = new MemoryCursor_tbstgru();
    mcErroriSV_IP = new MemoryCursor_mcerrsvip_mcrdef();
    _flgfraud = CPLib.Space(1);
    _pSegno = CPLib.Space(0);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_statisv,qbe_provsv,qbe_stgru,qbe_estrai_sv_ope_tab_wu_minmax,qbe_estrai_sv_ope_tab_all,qbe_estrai_sv_frz_tab_wu_minmax,qbe_estrai_sv_frz_tab_all,qbe_estrai_sv_ope_chk_all,qbe_estrai_sv_all_ip_1,qbe_sv_idp_rapporti,qbe_estrai_sv_all_ip_2_a,qbe_estrai_sv_all_ip_2_a,
  public static final String m_cVQRList = ",qbe_statisv,qbe_provsv,qbe_stgru,qbe_estrai_sv_ope_tab_wu_minmax,qbe_estrai_sv_ope_tab_all,qbe_estrai_sv_frz_tab_wu_minmax,qbe_estrai_sv_frz_tab_all,qbe_estrai_sv_ope_chk_all,qbe_estrai_sv_all_ip_1,qbe_sv_idp_rapporti,qbe_estrai_sv_all_ip_2_a,qbe_estrai_sv_all_ip_2_a,";
  // ENTITY_BATCHES: ,arfn_agg_fraudolente,arfn_chkspers,arfn_datesum,arfn_fdate,arfn_fdatetime,arrt_estrai_sv_check_all,
  public static final String i_InvokedRoutines = ",arfn_agg_fraudolente,arfn_chkspers,arfn_datesum,arfn_fdate,arfn_fdatetime,arrt_estrai_sv_check_all,";
  public static String[] m_cRunParameterNames={"pAnno","pTri","pTipo","pFile","pTipoBase3","pFraudo"};
  protected static String GetFieldsName_000000BD(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"PROVINCIA1,";
    p_cSql = p_cSql+"TIPOSV,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"TIPOCONT,";
    p_cSql = p_cSql+"IMPOUT,";
    p_cSql = p_cSql+"ROWNUMBER,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"SOURCEPERS,";
    p_cSql = p_cSql+"FLAGFRAUD,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"analisi_sv",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000BE(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"PROVINCIA1,";
    p_cSql = p_cSql+"TIPOSV,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"TIPOCONT,";
    p_cSql = p_cSql+"IMPOUT,";
    p_cSql = p_cSql+"ROWNUMBER,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"SOURCEPERS,";
    p_cSql = p_cSql+"FLAGFRAUD,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"analisi_fr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000EC(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"PROVINCIA1,";
    p_cSql = p_cSql+"TIPOSV,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"TIPOCONT,";
    p_cSql = p_cSql+"IMPOUT,";
    p_cSql = p_cSql+"ROWNUMBER,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"SOURCEPERS,";
    p_cSql = p_cSql+"FLAGFRAUD,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"analisi_sv",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000ED(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"PROVINCIA1,";
    p_cSql = p_cSql+"TIPOSV,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"TIPOCONT,";
    p_cSql = p_cSql+"IMPOUT,";
    p_cSql = p_cSql+"ROWNUMBER,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"SOURCEPERS,";
    p_cSql = p_cSql+"FLAGFRAUD,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"analisi_fr",true);
    return p_cSql;
  }
}
