// * --- Area Manuale = BO - Header
// * --- arrt_wutrxchk_save
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
public class arrt_wutrxchk_saveR implements CallerWithObjs {
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
  public String m_cPhName_wutrxchk;
  public String m_cServer_wutrxchk;
  public String m_cPhName_tmp_list_imprich;
  public String m_cServer_tmp_list_imprich;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_wutrxchk_checked;
  public String m_cServer_wutrxchk_checked;
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
  public double w_TRXCODPRG;
  public String w_TRXCOGNOM;
  public String w_TRXNOME;
  public String w_TRXDOMICI;
  public String w_TRXFLGCF;
  public String w_TRXCODFIS;
  public String w_TRXLUONAS;
  public String w_TRXNUMDOC;
  public java.sql.Date w_TRXDATSCA;
  public java.sql.Date w_TRXDATRIL;
  public String w_TRXAUTRIL;
  public String w_TRXNAZRES;
  public String w_TRXCITRES;
  public String w_TRXTIPDOC;
  public java.sql.Date w_TRXDATOPE;
  public String w_TRXFLGCON;
  public String w_TRSSEGNO;
  public double w_TRXIMPORTO;
  public double w_TRXCONTAN;
  public String w_TRXUNIQUE;
  public String w_TRXCODDIP;
  public String w_TRXCOGCON;
  public String w_TRXNOMCON;
  public String w_TRXDESTIN;
  public String w_TRXMTCN;
  public java.sql.Date w_TRXDATNAS;
  public String w_TRXSESSO;
  public String w_TRXCODCAS;
  public String w_TRXRECTYPE;
  public String w_TRXCODMAG;
  public String w_TRXCODUNI;
  public String w_TRXFLGFOR;
  public java.sql.Timestamp w_TRXTFINLAV;
  public java.sql.Date w_TRDFINLAV;
  public String w_TRFLGINLAV;
  public String w_TRXFLGAUA;
  public String w_TRXESITO;
  public String w_finalized;
  public MemoryCursor_wutrxchk mcTransazioni;
  public String _trxcognom;
  public String _trxnome;
  public String _trxluonas;
  public String _trxnumdoc;
  public String _trxtipdoc;
  public java.sql.Date _trxdatnas;
  public String _trxsesso;
  public java.sql.Timestamp _trxtinixlav;
  public java.sql.Date _trxdinixlav;
  public double _trxuser;
  public String gAzienda;
  public String gPathApp;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_wutrxchk_save
  public int _i;
  public int _y;
  public int _righe;
  public int conta;
  public int _conta;
  public int r;
  public int cell_count;
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
  // * --- Fine Area Manuale
  public arrt_wutrxchk_saveR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_wutrxchk_save",m_Caller);
    m_cPhName_wutrxchk = p_ContextObject.GetPhName("wutrxchk");
    if (m_cPhName_wutrxchk.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wutrxchk = m_cPhName_wutrxchk+" "+m_Ctx.GetWritePhName("wutrxchk");
    }
    m_cServer_wutrxchk = p_ContextObject.GetServer("wutrxchk");
    m_cPhName_tmp_list_imprich = p_ContextObject.GetPhName("tmp_list_imprich");
    if (m_cPhName_tmp_list_imprich.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_list_imprich = m_cPhName_tmp_list_imprich+" "+m_Ctx.GetWritePhName("tmp_list_imprich");
    }
    m_cServer_tmp_list_imprich = p_ContextObject.GetServer("tmp_list_imprich");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_wutrxchk_checked = p_ContextObject.GetPhName("wutrxchk_checked");
    if (m_cPhName_wutrxchk_checked.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wutrxchk_checked = m_cPhName_wutrxchk_checked+" "+m_Ctx.GetWritePhName("wutrxchk_checked");
    }
    m_cServer_wutrxchk_checked = p_ContextObject.GetServer("wutrxchk_checked");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("TRXCODPRG",p_cVarName)) {
      return w_TRXCODPRG;
    }
    if (CPLib.eqr("TRXIMPORTO",p_cVarName)) {
      return w_TRXIMPORTO;
    }
    if (CPLib.eqr("TRXCONTAN",p_cVarName)) {
      return w_TRXCONTAN;
    }
    if (CPLib.eqr("_trxuser",p_cVarName)) {
      return _trxuser;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_wutrxchk_save";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("TRXCOGNOM",p_cVarName)) {
      return w_TRXCOGNOM;
    }
    if (CPLib.eqr("TRXNOME",p_cVarName)) {
      return w_TRXNOME;
    }
    if (CPLib.eqr("TRXDOMICI",p_cVarName)) {
      return w_TRXDOMICI;
    }
    if (CPLib.eqr("TRXFLGCF",p_cVarName)) {
      return w_TRXFLGCF;
    }
    if (CPLib.eqr("TRXCODFIS",p_cVarName)) {
      return w_TRXCODFIS;
    }
    if (CPLib.eqr("TRXLUONAS",p_cVarName)) {
      return w_TRXLUONAS;
    }
    if (CPLib.eqr("TRXNUMDOC",p_cVarName)) {
      return w_TRXNUMDOC;
    }
    if (CPLib.eqr("TRXAUTRIL",p_cVarName)) {
      return w_TRXAUTRIL;
    }
    if (CPLib.eqr("TRXNAZRES",p_cVarName)) {
      return w_TRXNAZRES;
    }
    if (CPLib.eqr("TRXCITRES",p_cVarName)) {
      return w_TRXCITRES;
    }
    if (CPLib.eqr("TRXTIPDOC",p_cVarName)) {
      return w_TRXTIPDOC;
    }
    if (CPLib.eqr("TRXFLGCON",p_cVarName)) {
      return w_TRXFLGCON;
    }
    if (CPLib.eqr("TRSSEGNO",p_cVarName)) {
      return w_TRSSEGNO;
    }
    if (CPLib.eqr("TRXUNIQUE",p_cVarName)) {
      return w_TRXUNIQUE;
    }
    if (CPLib.eqr("TRXCODDIP",p_cVarName)) {
      return w_TRXCODDIP;
    }
    if (CPLib.eqr("TRXCOGCON",p_cVarName)) {
      return w_TRXCOGCON;
    }
    if (CPLib.eqr("TRXNOMCON",p_cVarName)) {
      return w_TRXNOMCON;
    }
    if (CPLib.eqr("TRXDESTIN",p_cVarName)) {
      return w_TRXDESTIN;
    }
    if (CPLib.eqr("TRXMTCN",p_cVarName)) {
      return w_TRXMTCN;
    }
    if (CPLib.eqr("TRXSESSO",p_cVarName)) {
      return w_TRXSESSO;
    }
    if (CPLib.eqr("TRXCODCAS",p_cVarName)) {
      return w_TRXCODCAS;
    }
    if (CPLib.eqr("TRXRECTYPE",p_cVarName)) {
      return w_TRXRECTYPE;
    }
    if (CPLib.eqr("TRXCODMAG",p_cVarName)) {
      return w_TRXCODMAG;
    }
    if (CPLib.eqr("TRXCODUNI",p_cVarName)) {
      return w_TRXCODUNI;
    }
    if (CPLib.eqr("TRXFLGFOR",p_cVarName)) {
      return w_TRXFLGFOR;
    }
    if (CPLib.eqr("TRFLGINLAV",p_cVarName)) {
      return w_TRFLGINLAV;
    }
    if (CPLib.eqr("TRXFLGAUA",p_cVarName)) {
      return w_TRXFLGAUA;
    }
    if (CPLib.eqr("TRXESITO",p_cVarName)) {
      return w_TRXESITO;
    }
    if (CPLib.eqr("finalized",p_cVarName)) {
      return w_finalized;
    }
    if (CPLib.eqr("_trxcognom",p_cVarName)) {
      return _trxcognom;
    }
    if (CPLib.eqr("_trxnome",p_cVarName)) {
      return _trxnome;
    }
    if (CPLib.eqr("_trxluonas",p_cVarName)) {
      return _trxluonas;
    }
    if (CPLib.eqr("_trxnumdoc",p_cVarName)) {
      return _trxnumdoc;
    }
    if (CPLib.eqr("_trxtipdoc",p_cVarName)) {
      return _trxtipdoc;
    }
    if (CPLib.eqr("_trxsesso",p_cVarName)) {
      return _trxsesso;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("TRXDATSCA",p_cVarName)) {
      return w_TRXDATSCA;
    }
    if (CPLib.eqr("TRXDATRIL",p_cVarName)) {
      return w_TRXDATRIL;
    }
    if (CPLib.eqr("TRXDATOPE",p_cVarName)) {
      return w_TRXDATOPE;
    }
    if (CPLib.eqr("TRXDATNAS",p_cVarName)) {
      return w_TRXDATNAS;
    }
    if (CPLib.eqr("TRDFINLAV",p_cVarName)) {
      return w_TRDFINLAV;
    }
    if (CPLib.eqr("_trxdatnas",p_cVarName)) {
      return _trxdatnas;
    }
    if (CPLib.eqr("_trxdinixlav",p_cVarName)) {
      return _trxdinixlav;
    }
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("TRXTFINLAV",p_cVarName)) {
      return w_TRXTFINLAV;
    }
    if (CPLib.eqr("_trxtinixlav",p_cVarName)) {
      return _trxtinixlav;
    }
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("mcTransazioni",p_cVarName)) {
      return mcTransazioni;
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
    if (CPLib.eqr("TRXCODPRG",p_cVarName)) {
      w_TRXCODPRG = value;
      return;
    }
    if (CPLib.eqr("TRXIMPORTO",p_cVarName)) {
      w_TRXIMPORTO = value;
      return;
    }
    if (CPLib.eqr("TRXCONTAN",p_cVarName)) {
      w_TRXCONTAN = value;
      return;
    }
    if (CPLib.eqr("_trxuser",p_cVarName)) {
      _trxuser = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("TRXCOGNOM",p_cVarName)) {
      w_TRXCOGNOM = value;
      return;
    }
    if (CPLib.eqr("TRXNOME",p_cVarName)) {
      w_TRXNOME = value;
      return;
    }
    if (CPLib.eqr("TRXDOMICI",p_cVarName)) {
      w_TRXDOMICI = value;
      return;
    }
    if (CPLib.eqr("TRXFLGCF",p_cVarName)) {
      w_TRXFLGCF = value;
      return;
    }
    if (CPLib.eqr("TRXCODFIS",p_cVarName)) {
      w_TRXCODFIS = value;
      return;
    }
    if (CPLib.eqr("TRXLUONAS",p_cVarName)) {
      w_TRXLUONAS = value;
      return;
    }
    if (CPLib.eqr("TRXNUMDOC",p_cVarName)) {
      w_TRXNUMDOC = value;
      return;
    }
    if (CPLib.eqr("TRXAUTRIL",p_cVarName)) {
      w_TRXAUTRIL = value;
      return;
    }
    if (CPLib.eqr("TRXNAZRES",p_cVarName)) {
      w_TRXNAZRES = value;
      return;
    }
    if (CPLib.eqr("TRXCITRES",p_cVarName)) {
      w_TRXCITRES = value;
      return;
    }
    if (CPLib.eqr("TRXTIPDOC",p_cVarName)) {
      w_TRXTIPDOC = value;
      return;
    }
    if (CPLib.eqr("TRXFLGCON",p_cVarName)) {
      w_TRXFLGCON = value;
      return;
    }
    if (CPLib.eqr("TRSSEGNO",p_cVarName)) {
      w_TRSSEGNO = value;
      return;
    }
    if (CPLib.eqr("TRXUNIQUE",p_cVarName)) {
      w_TRXUNIQUE = value;
      return;
    }
    if (CPLib.eqr("TRXCODDIP",p_cVarName)) {
      w_TRXCODDIP = value;
      return;
    }
    if (CPLib.eqr("TRXCOGCON",p_cVarName)) {
      w_TRXCOGCON = value;
      return;
    }
    if (CPLib.eqr("TRXNOMCON",p_cVarName)) {
      w_TRXNOMCON = value;
      return;
    }
    if (CPLib.eqr("TRXDESTIN",p_cVarName)) {
      w_TRXDESTIN = value;
      return;
    }
    if (CPLib.eqr("TRXMTCN",p_cVarName)) {
      w_TRXMTCN = value;
      return;
    }
    if (CPLib.eqr("TRXSESSO",p_cVarName)) {
      w_TRXSESSO = value;
      return;
    }
    if (CPLib.eqr("TRXCODCAS",p_cVarName)) {
      w_TRXCODCAS = value;
      return;
    }
    if (CPLib.eqr("TRXRECTYPE",p_cVarName)) {
      w_TRXRECTYPE = value;
      return;
    }
    if (CPLib.eqr("TRXCODMAG",p_cVarName)) {
      w_TRXCODMAG = value;
      return;
    }
    if (CPLib.eqr("TRXCODUNI",p_cVarName)) {
      w_TRXCODUNI = value;
      return;
    }
    if (CPLib.eqr("TRXFLGFOR",p_cVarName)) {
      w_TRXFLGFOR = value;
      return;
    }
    if (CPLib.eqr("TRFLGINLAV",p_cVarName)) {
      w_TRFLGINLAV = value;
      return;
    }
    if (CPLib.eqr("TRXFLGAUA",p_cVarName)) {
      w_TRXFLGAUA = value;
      return;
    }
    if (CPLib.eqr("TRXESITO",p_cVarName)) {
      w_TRXESITO = value;
      return;
    }
    if (CPLib.eqr("finalized",p_cVarName)) {
      w_finalized = value;
      return;
    }
    if (CPLib.eqr("_trxcognom",p_cVarName)) {
      _trxcognom = value;
      return;
    }
    if (CPLib.eqr("_trxnome",p_cVarName)) {
      _trxnome = value;
      return;
    }
    if (CPLib.eqr("_trxluonas",p_cVarName)) {
      _trxluonas = value;
      return;
    }
    if (CPLib.eqr("_trxnumdoc",p_cVarName)) {
      _trxnumdoc = value;
      return;
    }
    if (CPLib.eqr("_trxtipdoc",p_cVarName)) {
      _trxtipdoc = value;
      return;
    }
    if (CPLib.eqr("_trxsesso",p_cVarName)) {
      _trxsesso = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("TRXDATSCA",p_cVarName)) {
      w_TRXDATSCA = value;
      return;
    }
    if (CPLib.eqr("TRXDATRIL",p_cVarName)) {
      w_TRXDATRIL = value;
      return;
    }
    if (CPLib.eqr("TRXDATOPE",p_cVarName)) {
      w_TRXDATOPE = value;
      return;
    }
    if (CPLib.eqr("TRXDATNAS",p_cVarName)) {
      w_TRXDATNAS = value;
      return;
    }
    if (CPLib.eqr("TRDFINLAV",p_cVarName)) {
      w_TRDFINLAV = value;
      return;
    }
    if (CPLib.eqr("_trxdatnas",p_cVarName)) {
      _trxdatnas = value;
      return;
    }
    if (CPLib.eqr("_trxdinixlav",p_cVarName)) {
      _trxdinixlav = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
    if (CPLib.eqr("TRXTFINLAV",p_cVarName)) {
      w_TRXTFINLAV = value;
      return;
    }
    if (CPLib.eqr("_trxtinixlav",p_cVarName)) {
      _trxtinixlav = value;
      return;
    }
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcTransazioni",p_cVarName)) {
      mcTransazioni = (MemoryCursor_wutrxchk)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_Main() throws Exception {
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_wutrxchk=null;
    try {
      /* w_TRXCODPRG Numeric(15, 0) // ID Transazione */
      /* w_TRXCOGNOM Char(50) // Cognome */
      /* w_TRXNOME Char(50) // Nome */
      /* w_TRXDOMICI Char(100) // Domicilio */
      /* w_TRXFLGCF Char(1) // Flag Codice Fiscale */
      /* w_TRXCODFIS Char(16) // Codice Ficale (reale) */
      /* w_TRXLUONAS Char(50) // Luogo di nascita */
      /* w_TRXNUMDOC Char(30) // Numero Documento */
      /* w_TRXDATSCA Date // Data Scadenza Documento */
      /* w_TRXDATRIL Date // Data Rilascio Documento */
      /* w_TRXAUTRIL Char(50) // Autorità Rilascio Documento */
      /* w_TRXNAZRES Char(50) // Nazione di Residenza */
      /* w_TRXCITRES Char(50) // Città Di residenza */
      /* w_TRXTIPDOC Char(2) // Tipo Documento */
      /* w_TRXDATOPE Date // Data Operazione */
      /* w_TRXFLGCON Char(1) // Flag Contanti */
      /* w_TRSSEGNO Char(1) // Segno (A=Send,D=Receive) */
      /* w_TRXIMPORTO Numeric(15, 2) // Importo */
      /* w_TRXCONTAN Numeric(15, 2) // Contante */
      /* w_TRXUNIQUE Char(10) // Unique ID */
      /* w_TRXCODDIP Char(10) // Codice Agenzia */
      /* w_TRXCOGCON Char(100) // Cognome Controparte */
      /* w_TRXNOMCON Char(100) // Nome Controparte */
      /* w_TRXDESTIN Char(100) // Stato Controparte */
      /* w_TRXMTCN Char(10) // MTCN Operazione */
      /* w_TRXDATNAS Date // Data Di Nascita */
      /* w_TRXSESSO Char(1) // Sesso */
      /* w_TRXCODCAS Char(4) // Codice Catastale */
      /* w_TRXRECTYPE Char(1) // Tipo Record */
      /* w_TRXCODMAG Char(5) // Codice MacroAgente */
      /* w_TRXCODUNI Char(18) // Codice Univoco */
      /* w_TRXFLGFOR Char(1) // FORZATURA INSERIMENTO */
      /* w_TRXTFINLAV DateTime // Ora Fine Lavorazione */
      /* w_TRDFINLAV Date // Data Fine Lavorazione */
      /* w_TRFLGINLAV Char(1) // IN lavorazione */
      /* w_TRXFLGAUA Char(1) */
      /* w_TRXESITO Char(1) */
      /* w_finalized Char(1) */
      /* mcTransazioni MemoryCursor(wutrxchk) */
      /* _trxcognom Char(50) */
      /* _trxnome Char(50) */
      /* _trxluonas Char(50) */
      /* _trxnumdoc Char(30) */
      /* _trxtipdoc Char(2) */
      /* _trxdatnas Date */
      /* _trxsesso Char(1) */
      /* _trxsesso Char(1) */
      /* _trxtinixlav DateTime */
      /* _trxdinixlav Date */
      /* _trxuser Numeric(10, 0) */
      /* gAzienda Char(10) // Azienda */
      /* gPathApp Char(80) // Path Applicazione */
      /* _trxcognom := '' */
      _trxcognom = "";
      /* _trxnome := '' */
      _trxnome = "";
      /* _trxluonas := '' */
      _trxluonas = "";
      /* _trxnumdoc := '' */
      _trxnumdoc = "";
      /* _trxtipdoc := '' */
      _trxtipdoc = "";
      /* _trxdatnas := NullDate() */
      _trxdatnas = CPLib.NullDate();
      /* _trxsesso := '' */
      _trxsesso = "";
      /* _trxtinixlav := NullDateTime() */
      _trxtinixlav = CPLib.NullDateTime();
      /* _trxdinixlav := NullDate() */
      _trxdinixlav = CPLib.NullDate();
      /* _trxuser := 0 */
      _trxuser = CPLib.Round(0,0);
      /* If w_finalized='S' */
      if (CPLib.eqr(w_finalized,"S")) {
        // * --- Read from wutrxchk
        m_cServer = m_Ctx.GetServer("wutrxchk");
        m_cPhName = m_Ctx.GetPhName("wutrxchk");
        m_cSql = "";
        m_cSql = m_cSql+"TRXCODPRG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_TRXCODPRG,"N",15,0,m_cServer),m_cServer,w_TRXCODPRG);
        if (m_Ctx.IsSharedTemp("wutrxchk")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("TRXCOGNOM",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("TRXNOME",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("TRXLUONAS",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("TRXNUMDOC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("TRXTIPDOC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("TRXDATNAS",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("TRXSESSO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("TRXUTENTE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("TRXTINILAV",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("TRXDINILAV",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _trxcognom = Read_Cursor.GetString("TRXCOGNOM");
          _trxnome = Read_Cursor.GetString("TRXNOME");
          _trxluonas = Read_Cursor.GetString("TRXLUONAS");
          _trxnumdoc = Read_Cursor.GetString("TRXNUMDOC");
          _trxtipdoc = Read_Cursor.GetString("TRXTIPDOC");
          _trxdatnas = Read_Cursor.GetDate("TRXDATNAS");
          _trxsesso = Read_Cursor.GetString("TRXSESSO");
          _trxuser = CPLib.Round(Read_Cursor.GetDouble("TRXUTENTE"),0);
          _trxtinixlav = Read_Cursor.GetDateTime("TRXTINILAV");
          _trxdinixlav = Read_Cursor.GetDate("TRXDINILAV");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on wutrxchk into routine arrt_wutrxchk_save returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _trxcognom = "";
          _trxnome = "";
          _trxluonas = "";
          _trxnumdoc = "";
          _trxtipdoc = "";
          _trxdatnas = CPLib.NullDate();
          _trxsesso = "";
          _trxuser = 0;
          _trxtinixlav = CPLib.NullDateTime();
          _trxdinixlav = CPLib.NullDate();
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        // * --- Fill memory cursor mcTransazioni on wutrxchk
        mcTransazioni.Zap();
        m_cServer = m_Ctx.GetServer("wutrxchk");
        m_cPhName = m_Ctx.GetPhName("wutrxchk");
        if (Cursor_wutrxchk!=null)
          Cursor_wutrxchk.Close();
        Cursor_wutrxchk = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"TRXFLGAUI='S'  and  TRXFLGAUA='N'  and  TRXCOGNOM= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_trxcognom,"?",0,0,m_cServer, m_oParameters),m_cServer,_trxcognom)+"  and  TRXNOME="+CPSql.SQLValueAdapter(CPLib.ToSQL(_trxnome,"?",0,0,m_cServer, m_oParameters),m_cServer,_trxnome)+"  and  TRXSESSO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_trxsesso,"?",0,0,m_cServer, m_oParameters),m_cServer,_trxsesso)+"  and  TRXLUONAS="+CPSql.SQLValueAdapter(CPLib.ToSQL(_trxluonas,"?",0,0,m_cServer, m_oParameters),m_cServer,_trxluonas)+"  and  TRXDATNAS="+CPSql.SQLValueAdapter(CPLib.ToSQL(_trxdatnas,"?",0,0,m_cServer, m_oParameters),m_cServer,_trxdatnas)+"  and  TRXTIPDOC="+CPSql.SQLValueAdapter(CPLib.ToSQL(_trxtipdoc,"?",0,0,m_cServer, m_oParameters),m_cServer,_trxtipdoc)+"  and  TRXNUMDOC="+CPSql.SQLValueAdapter(CPLib.ToSQL(_trxnumdoc,"?",0,0,m_cServer, m_oParameters),m_cServer,_trxnumdoc)+" "+")"+(m_Ctx.IsSharedTemp("wutrxchk")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        {
          final CPResultSet m_TheCursor = Cursor_wutrxchk;
          Cursor_wutrxchk.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arrt_wutrxchk_save: query on wutrxchk returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_wutrxchk.Eof())) {
          mcTransazioni.AppendBlank();
          mcTransazioni.row.TRXCODPRG = Cursor_wutrxchk.GetDouble("TRXCODPRG");
          mcTransazioni.row.TRXCOGNOM = Cursor_wutrxchk.GetString("TRXCOGNOM");
          mcTransazioni.row.TRXNOME = Cursor_wutrxchk.GetString("TRXNOME");
          mcTransazioni.row.TRXDOMICI = Cursor_wutrxchk.GetString("TRXDOMICI");
          mcTransazioni.row.TRXFLGCF = Cursor_wutrxchk.GetString("TRXFLGCF");
          mcTransazioni.row.TRXCODFIS = Cursor_wutrxchk.GetString("TRXCODFIS");
          mcTransazioni.row.TRXLUONAS = Cursor_wutrxchk.GetString("TRXLUONAS");
          mcTransazioni.row.TRXNUMDOC = Cursor_wutrxchk.GetString("TRXNUMDOC");
          mcTransazioni.row.TRXDATSCA = Cursor_wutrxchk.GetDate("TRXDATSCA");
          mcTransazioni.row.TRXDATRIL = Cursor_wutrxchk.GetDate("TRXDATRIL");
          mcTransazioni.row.TRXAUTRIL = Cursor_wutrxchk.GetString("TRXAUTRIL");
          mcTransazioni.row.TRXNAZRES = Cursor_wutrxchk.GetString("TRXNAZRES");
          mcTransazioni.row.TRXCITRES = Cursor_wutrxchk.GetString("TRXCITRES");
          mcTransazioni.row.TRXTIPDOC = Cursor_wutrxchk.GetString("TRXTIPDOC");
          mcTransazioni.row.TRXDATOPE = Cursor_wutrxchk.GetDate("TRXDATOPE");
          mcTransazioni.row.TRXFLGCON = Cursor_wutrxchk.GetString("TRXFLGCON");
          mcTransazioni.row.TRSSEGNO = Cursor_wutrxchk.GetString("TRSSEGNO");
          mcTransazioni.row.TRXIMPORTO = Cursor_wutrxchk.GetDouble("TRXIMPORTO");
          mcTransazioni.row.TRXCONTAN = Cursor_wutrxchk.GetDouble("TRXCONTAN");
          mcTransazioni.row.TRXUNIQUE = Cursor_wutrxchk.GetString("TRXUNIQUE");
          mcTransazioni.row.TRXCODDIP = Cursor_wutrxchk.GetString("TRXCODDIP");
          mcTransazioni.row.TRXCOGCON = Cursor_wutrxchk.GetString("TRXCOGCON");
          mcTransazioni.row.TRXNOMCON = Cursor_wutrxchk.GetString("TRXNOMCON");
          mcTransazioni.row.TRXDESTIN = Cursor_wutrxchk.GetString("TRXDESTIN");
          mcTransazioni.row.TRXMTCN = Cursor_wutrxchk.GetString("TRXMTCN");
          mcTransazioni.row.TRXDATNAS = Cursor_wutrxchk.GetDate("TRXDATNAS");
          mcTransazioni.row.TRXSESSO = Cursor_wutrxchk.GetString("TRXSESSO");
          mcTransazioni.row.TRXCODCAS = Cursor_wutrxchk.GetString("TRXCODCAS");
          mcTransazioni.row.TRXRECTYPE = Cursor_wutrxchk.GetString("TRXRECTYPE");
          mcTransazioni.row.TRXCODMAG = Cursor_wutrxchk.GetString("TRXCODMAG");
          mcTransazioni.row.TRXCODUNI = Cursor_wutrxchk.GetString("TRXCODUNI");
          mcTransazioni.row.TRXERROR01 = Cursor_wutrxchk.GetString("TRXERROR01");
          mcTransazioni.row.TRXERROR02 = Cursor_wutrxchk.GetString("TRXERROR02");
          mcTransazioni.row.TRXERROR03 = Cursor_wutrxchk.GetString("TRXERROR03");
          mcTransazioni.row.TRXERROR04 = Cursor_wutrxchk.GetString("TRXERROR04");
          mcTransazioni.row.TRXERROR05 = Cursor_wutrxchk.GetString("TRXERROR05");
          mcTransazioni.row.TRXERROR06 = Cursor_wutrxchk.GetString("TRXERROR06");
          mcTransazioni.row.TRXERROR07 = Cursor_wutrxchk.GetString("TRXERROR07");
          mcTransazioni.row.TRXERROR08 = Cursor_wutrxchk.GetString("TRXERROR08");
          mcTransazioni.row.TRXERROR09 = Cursor_wutrxchk.GetString("TRXERROR09");
          mcTransazioni.row.TRXERROR10 = Cursor_wutrxchk.GetString("TRXERROR10");
          mcTransazioni.row.TRXERROR11 = Cursor_wutrxchk.GetString("TRXERROR11");
          mcTransazioni.row.TRXERROR12 = Cursor_wutrxchk.GetString("TRXERROR12");
          mcTransazioni.row.TRXERROR13 = Cursor_wutrxchk.GetString("TRXERROR13");
          mcTransazioni.row.TRXERROR14 = Cursor_wutrxchk.GetString("TRXERROR14");
          mcTransazioni.row.TRXERROR15 = Cursor_wutrxchk.GetString("TRXERROR15");
          mcTransazioni.row.TRXERROR16 = Cursor_wutrxchk.GetString("TRXERROR16");
          mcTransazioni.row.TRXERROR17 = Cursor_wutrxchk.GetString("TRXERROR17");
          mcTransazioni.row.TRXERROR18 = Cursor_wutrxchk.GetString("TRXERROR18");
          mcTransazioni.row.TRXERROR19 = Cursor_wutrxchk.GetString("TRXERROR19");
          mcTransazioni.row.TRXERROR20 = Cursor_wutrxchk.GetString("TRXERROR20");
          mcTransazioni.row.TRXERROR21 = Cursor_wutrxchk.GetString("TRXERROR21");
          mcTransazioni.row.TRXERROR22 = Cursor_wutrxchk.GetString("TRXERROR22");
          mcTransazioni.row.TRXERROR23 = Cursor_wutrxchk.GetString("TRXERROR23");
          mcTransazioni.row.TRXERROR24 = Cursor_wutrxchk.GetString("TRXERROR24");
          mcTransazioni.row.TRXERROR25 = Cursor_wutrxchk.GetString("TRXERROR25");
          mcTransazioni.row.TRXERROR26 = Cursor_wutrxchk.GetString("TRXERROR26");
          mcTransazioni.row.TRXERROR27 = Cursor_wutrxchk.GetString("TRXERROR27");
          mcTransazioni.row.TRXERROR28 = Cursor_wutrxchk.GetString("TRXERROR28");
          mcTransazioni.row.TRXERROR29 = Cursor_wutrxchk.GetString("TRXERROR29");
          mcTransazioni.row.TRXERROR30 = Cursor_wutrxchk.GetString("TRXERROR30");
          mcTransazioni.row.TRXERROR31 = Cursor_wutrxchk.GetString("TRXERROR31");
          mcTransazioni.row.TRXERROR32 = Cursor_wutrxchk.GetString("TRXERROR32");
          mcTransazioni.row.TRXERROR33 = Cursor_wutrxchk.GetString("TRXERROR33");
          mcTransazioni.row.TRXERROR34 = Cursor_wutrxchk.GetString("TRXERROR34");
          mcTransazioni.row.TRXERROR35 = Cursor_wutrxchk.GetString("TRXERROR35");
          mcTransazioni.row.TRXERROR36 = Cursor_wutrxchk.GetString("TRXERROR36");
          mcTransazioni.row.TRXERROR37 = Cursor_wutrxchk.GetString("TRXERROR37");
          mcTransazioni.row.TRXERROR38 = Cursor_wutrxchk.GetString("TRXERROR38");
          mcTransazioni.row.TRXERROR39 = Cursor_wutrxchk.GetString("TRXERROR39");
          mcTransazioni.row.TRXERROR40 = Cursor_wutrxchk.GetString("TRXERROR40");
          mcTransazioni.row.TRXERROR41 = Cursor_wutrxchk.GetString("TRXERROR41");
          mcTransazioni.row.TRXERROR42 = Cursor_wutrxchk.GetString("TRXERROR42");
          mcTransazioni.row.TRXERROR43 = Cursor_wutrxchk.GetString("TRXERROR43");
          mcTransazioni.row.TRXERROR44 = Cursor_wutrxchk.GetString("TRXERROR44");
          mcTransazioni.row.TRXERROR45 = Cursor_wutrxchk.GetString("TRXERROR45");
          mcTransazioni.row.TRXERROR46 = Cursor_wutrxchk.GetString("TRXERROR46");
          mcTransazioni.row.TRXERROR47 = Cursor_wutrxchk.GetString("TRXERROR47");
          mcTransazioni.row.TRXERROR48 = Cursor_wutrxchk.GetString("TRXERROR48");
          mcTransazioni.row.TRXERROR49 = Cursor_wutrxchk.GetString("TRXERROR49");
          mcTransazioni.row.TRXERROR50 = Cursor_wutrxchk.GetString("TRXERROR50");
          mcTransazioni.row.TRXERRAUA01 = Cursor_wutrxchk.GetString("TRXERRAUA01");
          mcTransazioni.row.TRXERRAUA02 = Cursor_wutrxchk.GetString("TRXERRAUA02");
          mcTransazioni.row.TRXERRAUA03 = Cursor_wutrxchk.GetString("TRXERRAUA03");
          mcTransazioni.row.TRXERRAUA04 = Cursor_wutrxchk.GetString("TRXERRAUA04");
          mcTransazioni.row.TRXERRAUA05 = Cursor_wutrxchk.GetString("TRXERRAUA05");
          mcTransazioni.row.TRXERRAUA06 = Cursor_wutrxchk.GetString("TRXERRAUA06");
          mcTransazioni.row.TRXERRAUA07 = Cursor_wutrxchk.GetString("TRXERRAUA07");
          mcTransazioni.row.TRXERRAUA08 = Cursor_wutrxchk.GetString("TRXERRAUA08");
          mcTransazioni.row.TRXERRAUA09 = Cursor_wutrxchk.GetString("TRXERRAUA09");
          mcTransazioni.row.TRXERRAUA10 = Cursor_wutrxchk.GetString("TRXERRAUA10");
          mcTransazioni.row.TRXFLGAUI = Cursor_wutrxchk.GetString("TRXFLGAUI");
          mcTransazioni.row.TRXFLGAUA = Cursor_wutrxchk.GetString("TRXFLGAUA");
          mcTransazioni.row.TRXFLGFOR = Cursor_wutrxchk.GetString("TRXFLGFOR");
          mcTransazioni.row.TRXAUICHK = Cursor_wutrxchk.GetString("TRXAUICHK");
          mcTransazioni.row.TRXAUACHK = Cursor_wutrxchk.GetString("TRXAUACHK");
          mcTransazioni.row.TRXNOTEOPER = Cursor_wutrxchk.GetString("TRXNOTEOPER");
          mcTransazioni.row.TRXFORCE = Cursor_wutrxchk.GetString("TRXFORCE");
          mcTransazioni.row.TRXNASSTATO = Cursor_wutrxchk.GetString("TRXNASSTATO");
          mcTransazioni.row.TRXNASCOMUN = Cursor_wutrxchk.GetString("TRXNASCOMUN");
          mcTransazioni.row.TRXFLGAUAQ1 = Cursor_wutrxchk.GetString("TRXFLGAUAQ1");
          mcTransazioni.row.TRXFLGAUAQ2 = Cursor_wutrxchk.GetString("TRXFLGAUAQ2");
          mcTransazioni.row.TRXFLGAUAQ3 = Cursor_wutrxchk.GetString("TRXFLGAUAQ3");
          mcTransazioni.row.TRXFLGAUAQ4 = Cursor_wutrxchk.GetString("TRXFLGAUAQ4");
          mcTransazioni.row.TRXFLGAUAQ5 = Cursor_wutrxchk.GetString("TRXFLGAUAQ5");
          mcTransazioni.row.TRXDATRICERCA = Cursor_wutrxchk.GetDate("TRXDATRICERCA");
          mcTransazioni.row.TRXUTENTE = Cursor_wutrxchk.GetDouble("TRXUTENTE");
          mcTransazioni.row.TRXTINILAV = Cursor_wutrxchk.GetDateTime("TRXTINILAV");
          mcTransazioni.row.TRXTFINLAV = Cursor_wutrxchk.GetDateTime("TRXTFINLAV");
          mcTransazioni.row.TRXDINILAV = Cursor_wutrxchk.GetDate("TRXDINILAV");
          mcTransazioni.row.TRDFINLAV = Cursor_wutrxchk.GetDate("TRDFINLAV");
          mcTransazioni.row.TRFLGINLAV = Cursor_wutrxchk.GetString("TRFLGINLAV");
          mcTransazioni.row.TRXNUMRIL = Cursor_wutrxchk.GetDouble("TRXNUMRIL");
          mcTransazioni.row.TRXSCAEDT = Cursor_wutrxchk.GetDate("TRXSCAEDT");
          mcTransazioni.row.TRXESITO = Cursor_wutrxchk.GetString("TRXESITO");
          mcTransazioni.row.TRXDERIVATA = Cursor_wutrxchk.GetString("TRXDERIVATA");
          mcTransazioni.row.TRXGALACTIC = Cursor_wutrxchk.GetString("TRXGALACTIC");
          mcTransazioni.row.TRXNAZRIL = Cursor_wutrxchk.GetString("TRXNAZRIL");
          Cursor_wutrxchk.Next();
        }
        m_cConnectivityError = Cursor_wutrxchk.ErrorMessage();
        Cursor_wutrxchk.Close();
        mcTransazioni.GoTop();
        /* w_TRXTFINLAV := DateTime() // Ora Fine Lavorazione */
        w_TRXTFINLAV = CPLib.DateTime();
        /* w_TRDFINLAV := Date() // Data Fine Lavorazione */
        w_TRDFINLAV = CPLib.Date();
        /* w_TRFLGINLAV := 'N' // IN lavorazione */
        w_TRFLGINLAV = "N";
        /* w_TRXFLGAUA := 'S' // IN lavorazione */
        w_TRXFLGAUA = "S";
        for (MemoryCursorRow_wutrxchk rowTransazioni : mcTransazioni._iterable_()) {
          /* If rowTransazioni.TRXCODPRG<>w_TRXCODPRG */
          if (CPLib.ne(rowTransazioni.TRXCODPRG,w_TRXCODPRG)) {
            /* If w_TRXFLGFOR='S' */
            if (CPLib.eqr(w_TRXFLGFOR,"S")) {
              // * --- Write into wutrxchk from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("wutrxchk");
              m_cPhName = m_Ctx.GetPhName("wutrxchk");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wutrxchk",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_wutrxchk_save",39,"0000004E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"TRXFLGAUA = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"TRXTFINLAV = "+CPLib.ToSQL(w_TRXTFINLAV,"T",14,0)+", ";
              m_cSql = m_cSql+"TRDFINLAV = "+CPLib.ToSQL(w_TRDFINLAV,"D",8,0)+", ";
              m_cSql = m_cSql+"TRFLGINLAV = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"TRXUTENTE = "+CPLib.ToSQL(_trxuser,"N",10,0)+", ";
              m_cSql = m_cSql+"TRXTINILAV = "+CPLib.ToSQL(_trxtinixlav,"T",14,0)+", ";
              m_cSql = m_cSql+"TRXDINILAV = "+CPLib.ToSQL(_trxdinixlav,"D",8,0)+", ";
              m_cSql = m_cSql+"TRXESITO = "+CPLib.ToSQL(w_TRXESITO,"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"TRXDERIVATA = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"wutrxchk",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"TRXCODPRG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowTransazioni.TRXCODPRG,"?",0,0,m_cServer),m_cServer,rowTransazioni.TRXCODPRG)+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
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
              // * --- Write into wutrxchk from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("wutrxchk");
              m_cPhName = m_Ctx.GetPhName("wutrxchk");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wutrxchk",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_wutrxchk_save",39,"0000004F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"TRXFLGAUA = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"TRXTFINLAV = "+CPLib.ToSQL(w_TRXTFINLAV,"T",14,0)+", ";
              m_cSql = m_cSql+"TRDFINLAV = "+CPLib.ToSQL(w_TRDFINLAV,"D",8,0)+", ";
              m_cSql = m_cSql+"TRFLGINLAV = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"TRXUTENTE = "+CPLib.ToSQL(_trxuser,"N",10,0)+", ";
              m_cSql = m_cSql+"TRXTINILAV = "+CPLib.ToSQL(_trxtinixlav,"T",14,0)+", ";
              m_cSql = m_cSql+"TRXDINILAV = "+CPLib.ToSQL(_trxdinixlav,"D",8,0)+", ";
              m_cSql = m_cSql+"TRXCOGNOM = "+CPLib.ToSQL(w_TRXCOGNOM,"C",50,0,m_cServer)+", ";
              m_cSql = m_cSql+"TRXNOME = "+CPLib.ToSQL(w_TRXNOME,"C",50,0,m_cServer)+", ";
              m_cSql = m_cSql+"TRXCODFIS = "+CPLib.ToSQL(w_TRXCODFIS,"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"TRXLUONAS = "+CPLib.ToSQL(w_TRXLUONAS,"C",50,0,m_cServer)+", ";
              m_cSql = m_cSql+"TRXDATNAS = "+CPLib.ToSQL(w_TRXDATNAS,"D",8,0)+", ";
              m_cSql = m_cSql+"TRXSESSO = "+CPLib.ToSQL(w_TRXSESSO,"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"TRXESITO = "+CPLib.ToSQL(w_TRXESITO,"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"TRXDERIVATA = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"wutrxchk",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"TRXCODPRG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowTransazioni.TRXCODPRG,"?",0,0,m_cServer),m_cServer,rowTransazioni.TRXCODPRG)+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
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
          /* If w_TRXFLGFOR='S' */
          if (CPLib.eqr(w_TRXFLGFOR,"S")) {
            // * --- Insert into wutrxchk_checked from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("wutrxchk_checked");
            m_cPhName = m_Ctx.GetPhName("wutrxchk_checked");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wutrxchk_checked",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_wutrxchk_save",39,"00000051")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000051(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_TRDFINLAV,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRSSEGNO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXAUACHK,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXAUICHK,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXAUTRIL,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXCITRES,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXCODCAS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXCODDIP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXCODFIS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXCODMAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXCODPRG,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXCODUNI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXCOGCON,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXCOGNOM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXCONTAN,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXDATNAS,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXDATOPE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXDATRICERCA,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXDATRIL,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXDATSCA,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXDESTIN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_trxdinixlav,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXDOMICI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERRAUA01,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERRAUA02,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERRAUA03,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERRAUA04,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERRAUA05,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERRAUA06,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERRAUA07,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERRAUA08,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERRAUA09,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERRAUA10,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR01,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR02,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR03,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR04,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR05,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR06,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR07,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR08,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR09,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR10,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR11,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR12,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR13,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR14,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR15,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR16,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR17,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR18,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR19,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR20,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR21,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR22,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR23,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR24,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR25,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR26,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR27,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR28,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR29,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR30,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR31,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR32,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR33,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR34,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR35,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR36,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR37,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR38,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR39,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR40,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR41,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR42,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR43,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR44,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR45,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR46,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR47,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR48,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR49,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR50,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_TRXESITO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXFLGAUAQ1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXFLGAUAQ2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXFLGAUAQ3,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXFLGAUAQ4,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXFLGAUAQ5,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXFLGAUI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXFLGCF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXFLGCON,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXFLGFOR,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXFORCE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXIMPORTO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXLUONAS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXMTCN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXNASCOMUN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXNASSTATO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXNAZRES,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXNOMCON,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXNOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXNOTEOPER,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXNUMDOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXNUMRIL,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXRECTYPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXSCAEDT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXSESSO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_TRXTFINLAV,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_trxtinixlav,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXTIPDOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXUNIQUE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_trxuser,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXDERIVATA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXGALACTIC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXNAZRIL,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wutrxchk_checked",true);
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
            // * --- Insert into wutrxchk_checked from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("wutrxchk_checked");
            m_cPhName = m_Ctx.GetPhName("wutrxchk_checked");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wutrxchk_checked",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_wutrxchk_save",39,"00000052")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000052(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_TRDFINLAV,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRSSEGNO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXAUACHK,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXAUICHK,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXAUTRIL,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXCITRES,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXCODCAS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXCODDIP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_TRXCODFIS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXCODMAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXCODPRG,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXCODUNI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXCOGCON,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_TRXCOGNOM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXCONTAN,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_TRXDATNAS,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXDATOPE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXDATRICERCA,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXDATRIL,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXDATSCA,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXDESTIN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_trxdinixlav,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXDOMICI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERRAUA01,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERRAUA02,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERRAUA03,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERRAUA04,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERRAUA05,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERRAUA06,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERRAUA07,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERRAUA08,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERRAUA09,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERRAUA10,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR01,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR02,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR03,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR04,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR05,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR06,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR07,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR08,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR09,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR10,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR11,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR12,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR13,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR14,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR15,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR16,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR17,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR18,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR19,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR20,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR21,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR22,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR23,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR24,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR25,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR26,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR27,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR28,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR29,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR30,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR31,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR32,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR33,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR34,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR35,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR36,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR37,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR38,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR39,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR40,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR41,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR42,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR43,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR44,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR45,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR46,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR47,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR48,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR49,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXERROR50,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_TRXESITO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXFLGAUAQ1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXFLGAUAQ2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXFLGAUAQ3,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXFLGAUAQ4,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXFLGAUAQ5,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXFLGAUI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXFLGCF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXFLGCON,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXFLGFOR,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXFORCE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXIMPORTO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_TRXLUONAS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXMTCN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXNASCOMUN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXNASSTATO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXNAZRES,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXNOMCON,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_TRXNOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXNOTEOPER,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXNUMDOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXNUMRIL,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXRECTYPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXSCAEDT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_TRXSESSO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_TRXTFINLAV,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_trxtinixlav,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXTIPDOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXUNIQUE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_trxuser,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXDERIVATA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXGALACTIC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTransazioni.TRXNAZRIL,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wutrxchk_checked",true);
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
      } // End If
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wutrxchk!=null)
          Cursor_wutrxchk.Close();
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
          Page_Main();
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
      m_Caller.SetNumber("TRXCODPRG","N",15,0,w_TRXCODPRG);
      m_Caller.SetString("TRXCOGNOM","C",50,0,w_TRXCOGNOM);
      m_Caller.SetString("TRXNOME","C",50,0,w_TRXNOME);
      m_Caller.SetString("TRXDOMICI","C",100,0,w_TRXDOMICI);
      m_Caller.SetString("TRXFLGCF","C",1,0,w_TRXFLGCF);
      m_Caller.SetString("TRXCODFIS","C",16,0,w_TRXCODFIS);
      m_Caller.SetString("TRXLUONAS","C",50,0,w_TRXLUONAS);
      m_Caller.SetString("TRXNUMDOC","C",30,0,w_TRXNUMDOC);
      m_Caller.SetDate("TRXDATSCA","D",8,0,w_TRXDATSCA);
      m_Caller.SetDate("TRXDATRIL","D",8,0,w_TRXDATRIL);
      m_Caller.SetString("TRXAUTRIL","C",50,0,w_TRXAUTRIL);
      m_Caller.SetString("TRXNAZRES","C",50,0,w_TRXNAZRES);
      m_Caller.SetString("TRXCITRES","C",50,0,w_TRXCITRES);
      m_Caller.SetString("TRXTIPDOC","C",2,0,w_TRXTIPDOC);
      m_Caller.SetDate("TRXDATOPE","D",8,0,w_TRXDATOPE);
      m_Caller.SetString("TRXFLGCON","C",1,0,w_TRXFLGCON);
      m_Caller.SetString("TRSSEGNO","C",1,0,w_TRSSEGNO);
      m_Caller.SetNumber("TRXIMPORTO","N",15,2,w_TRXIMPORTO);
      m_Caller.SetNumber("TRXCONTAN","N",15,2,w_TRXCONTAN);
      m_Caller.SetString("TRXUNIQUE","C",10,0,w_TRXUNIQUE);
      m_Caller.SetString("TRXCODDIP","C",10,0,w_TRXCODDIP);
      m_Caller.SetString("TRXCOGCON","C",100,0,w_TRXCOGCON);
      m_Caller.SetString("TRXNOMCON","C",100,0,w_TRXNOMCON);
      m_Caller.SetString("TRXDESTIN","C",100,0,w_TRXDESTIN);
      m_Caller.SetString("TRXMTCN","C",10,0,w_TRXMTCN);
      m_Caller.SetDate("TRXDATNAS","D",8,0,w_TRXDATNAS);
      m_Caller.SetString("TRXSESSO","C",1,0,w_TRXSESSO);
      m_Caller.SetString("TRXCODCAS","C",4,0,w_TRXCODCAS);
      m_Caller.SetString("TRXRECTYPE","C",1,0,w_TRXRECTYPE);
      m_Caller.SetString("TRXCODMAG","C",5,0,w_TRXCODMAG);
      m_Caller.SetString("TRXCODUNI","C",18,0,w_TRXCODUNI);
      m_Caller.SetString("TRXFLGFOR","C",1,0,w_TRXFLGFOR);
      m_Caller.SetDateTime("TRXTFINLAV","T",14,0,w_TRXTFINLAV);
      m_Caller.SetDate("TRDFINLAV","D",8,0,w_TRDFINLAV);
      m_Caller.SetString("TRFLGINLAV","C",1,0,w_TRFLGINLAV);
      m_Caller.SetString("TRXFLGAUA","C",1,0,w_TRXFLGAUA);
      m_Caller.SetString("TRXESITO","C",1,0,w_TRXESITO);
      m_Caller.SetString("finalized","C",1,0,w_finalized);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_wutrxchk_saveR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_wutrxchk_saveR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_TRXCODPRG = m_Caller.GetNumber("TRXCODPRG","N",15,0);
    w_TRXCOGNOM = m_Caller.GetString("TRXCOGNOM","C",50,0);
    w_TRXNOME = m_Caller.GetString("TRXNOME","C",50,0);
    w_TRXDOMICI = m_Caller.GetString("TRXDOMICI","C",100,0);
    w_TRXFLGCF = m_Caller.GetString("TRXFLGCF","C",1,0);
    w_TRXCODFIS = m_Caller.GetString("TRXCODFIS","C",16,0);
    w_TRXLUONAS = m_Caller.GetString("TRXLUONAS","C",50,0);
    w_TRXNUMDOC = m_Caller.GetString("TRXNUMDOC","C",30,0);
    w_TRXDATSCA = m_Caller.GetDate("TRXDATSCA","D",8,0);
    w_TRXDATRIL = m_Caller.GetDate("TRXDATRIL","D",8,0);
    w_TRXAUTRIL = m_Caller.GetString("TRXAUTRIL","C",50,0);
    w_TRXNAZRES = m_Caller.GetString("TRXNAZRES","C",50,0);
    w_TRXCITRES = m_Caller.GetString("TRXCITRES","C",50,0);
    w_TRXTIPDOC = m_Caller.GetString("TRXTIPDOC","C",2,0);
    w_TRXDATOPE = m_Caller.GetDate("TRXDATOPE","D",8,0);
    w_TRXFLGCON = m_Caller.GetString("TRXFLGCON","C",1,0);
    w_TRSSEGNO = m_Caller.GetString("TRSSEGNO","C",1,0);
    w_TRXIMPORTO = m_Caller.GetNumber("TRXIMPORTO","N",15,2);
    w_TRXCONTAN = m_Caller.GetNumber("TRXCONTAN","N",15,2);
    w_TRXUNIQUE = m_Caller.GetString("TRXUNIQUE","C",10,0);
    w_TRXCODDIP = m_Caller.GetString("TRXCODDIP","C",10,0);
    w_TRXCOGCON = m_Caller.GetString("TRXCOGCON","C",100,0);
    w_TRXNOMCON = m_Caller.GetString("TRXNOMCON","C",100,0);
    w_TRXDESTIN = m_Caller.GetString("TRXDESTIN","C",100,0);
    w_TRXMTCN = m_Caller.GetString("TRXMTCN","C",10,0);
    w_TRXDATNAS = m_Caller.GetDate("TRXDATNAS","D",8,0);
    w_TRXSESSO = m_Caller.GetString("TRXSESSO","C",1,0);
    w_TRXCODCAS = m_Caller.GetString("TRXCODCAS","C",4,0);
    w_TRXRECTYPE = m_Caller.GetString("TRXRECTYPE","C",1,0);
    w_TRXCODMAG = m_Caller.GetString("TRXCODMAG","C",5,0);
    w_TRXCODUNI = m_Caller.GetString("TRXCODUNI","C",18,0);
    w_TRXFLGFOR = m_Caller.GetString("TRXFLGFOR","C",1,0);
    w_TRXTFINLAV = m_Caller.GetDateTime("TRXTFINLAV","T",14,0);
    w_TRDFINLAV = m_Caller.GetDate("TRDFINLAV","D",8,0);
    w_TRFLGINLAV = m_Caller.GetString("TRFLGINLAV","C",1,0);
    w_TRXFLGAUA = m_Caller.GetString("TRXFLGAUA","C",1,0);
    w_TRXESITO = m_Caller.GetString("TRXESITO","C",1,0);
    w_finalized = m_Caller.GetString("finalized","C",1,0);
    mcTransazioni = new MemoryCursor_wutrxchk();
    _trxcognom = CPLib.Space(50);
    _trxnome = CPLib.Space(50);
    _trxluonas = CPLib.Space(50);
    _trxnumdoc = CPLib.Space(30);
    _trxtipdoc = CPLib.Space(2);
    _trxdatnas = CPLib.NullDate();
    _trxsesso = CPLib.Space(1);
    _trxtinixlav = CPLib.NullDateTime();
    _trxdinixlav = CPLib.NullDate();
    _trxuser = 0;
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000051(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TRDFINLAV,";
    p_cSql = p_cSql+"TRFLGINLAV,";
    p_cSql = p_cSql+"TRSSEGNO,";
    p_cSql = p_cSql+"TRXAUACHK,";
    p_cSql = p_cSql+"TRXAUICHK,";
    p_cSql = p_cSql+"TRXAUTRIL,";
    p_cSql = p_cSql+"TRXCITRES,";
    p_cSql = p_cSql+"TRXCODCAS,";
    p_cSql = p_cSql+"TRXCODDIP,";
    p_cSql = p_cSql+"TRXCODFIS,";
    p_cSql = p_cSql+"TRXCODMAG,";
    p_cSql = p_cSql+"TRXCODPRG,";
    p_cSql = p_cSql+"TRXCODUNI,";
    p_cSql = p_cSql+"TRXCOGCON,";
    p_cSql = p_cSql+"TRXCOGNOM,";
    p_cSql = p_cSql+"TRXCONTAN,";
    p_cSql = p_cSql+"TRXDATNAS,";
    p_cSql = p_cSql+"TRXDATOPE,";
    p_cSql = p_cSql+"TRXDATRICERCA,";
    p_cSql = p_cSql+"TRXDATRIL,";
    p_cSql = p_cSql+"TRXDATSCA,";
    p_cSql = p_cSql+"TRXDESTIN,";
    p_cSql = p_cSql+"TRXDINILAV,";
    p_cSql = p_cSql+"TRXDOMICI,";
    p_cSql = p_cSql+"TRXERRAUA01,";
    p_cSql = p_cSql+"TRXERRAUA02,";
    p_cSql = p_cSql+"TRXERRAUA03,";
    p_cSql = p_cSql+"TRXERRAUA04,";
    p_cSql = p_cSql+"TRXERRAUA05,";
    p_cSql = p_cSql+"TRXERRAUA06,";
    p_cSql = p_cSql+"TRXERRAUA07,";
    p_cSql = p_cSql+"TRXERRAUA08,";
    p_cSql = p_cSql+"TRXERRAUA09,";
    p_cSql = p_cSql+"TRXERRAUA10,";
    p_cSql = p_cSql+"TRXERROR01,";
    p_cSql = p_cSql+"TRXERROR02,";
    p_cSql = p_cSql+"TRXERROR03,";
    p_cSql = p_cSql+"TRXERROR04,";
    p_cSql = p_cSql+"TRXERROR05,";
    p_cSql = p_cSql+"TRXERROR06,";
    p_cSql = p_cSql+"TRXERROR07,";
    p_cSql = p_cSql+"TRXERROR08,";
    p_cSql = p_cSql+"TRXERROR09,";
    p_cSql = p_cSql+"TRXERROR10,";
    p_cSql = p_cSql+"TRXERROR11,";
    p_cSql = p_cSql+"TRXERROR12,";
    p_cSql = p_cSql+"TRXERROR13,";
    p_cSql = p_cSql+"TRXERROR14,";
    p_cSql = p_cSql+"TRXERROR15,";
    p_cSql = p_cSql+"TRXERROR16,";
    p_cSql = p_cSql+"TRXERROR17,";
    p_cSql = p_cSql+"TRXERROR18,";
    p_cSql = p_cSql+"TRXERROR19,";
    p_cSql = p_cSql+"TRXERROR20,";
    p_cSql = p_cSql+"TRXERROR21,";
    p_cSql = p_cSql+"TRXERROR22,";
    p_cSql = p_cSql+"TRXERROR23,";
    p_cSql = p_cSql+"TRXERROR24,";
    p_cSql = p_cSql+"TRXERROR25,";
    p_cSql = p_cSql+"TRXERROR26,";
    p_cSql = p_cSql+"TRXERROR27,";
    p_cSql = p_cSql+"TRXERROR28,";
    p_cSql = p_cSql+"TRXERROR29,";
    p_cSql = p_cSql+"TRXERROR30,";
    p_cSql = p_cSql+"TRXERROR31,";
    p_cSql = p_cSql+"TRXERROR32,";
    p_cSql = p_cSql+"TRXERROR33,";
    p_cSql = p_cSql+"TRXERROR34,";
    p_cSql = p_cSql+"TRXERROR35,";
    p_cSql = p_cSql+"TRXERROR36,";
    p_cSql = p_cSql+"TRXERROR37,";
    p_cSql = p_cSql+"TRXERROR38,";
    p_cSql = p_cSql+"TRXERROR39,";
    p_cSql = p_cSql+"TRXERROR40,";
    p_cSql = p_cSql+"TRXERROR41,";
    p_cSql = p_cSql+"TRXERROR42,";
    p_cSql = p_cSql+"TRXERROR43,";
    p_cSql = p_cSql+"TRXERROR44,";
    p_cSql = p_cSql+"TRXERROR45,";
    p_cSql = p_cSql+"TRXERROR46,";
    p_cSql = p_cSql+"TRXERROR47,";
    p_cSql = p_cSql+"TRXERROR48,";
    p_cSql = p_cSql+"TRXERROR49,";
    p_cSql = p_cSql+"TRXERROR50,";
    p_cSql = p_cSql+"TRXESITO,";
    p_cSql = p_cSql+"TRXFLGAUA,";
    p_cSql = p_cSql+"TRXFLGAUAQ1,";
    p_cSql = p_cSql+"TRXFLGAUAQ2,";
    p_cSql = p_cSql+"TRXFLGAUAQ3,";
    p_cSql = p_cSql+"TRXFLGAUAQ4,";
    p_cSql = p_cSql+"TRXFLGAUAQ5,";
    p_cSql = p_cSql+"TRXFLGAUI,";
    p_cSql = p_cSql+"TRXFLGCF,";
    p_cSql = p_cSql+"TRXFLGCON,";
    p_cSql = p_cSql+"TRXFLGFOR,";
    p_cSql = p_cSql+"TRXFORCE,";
    p_cSql = p_cSql+"TRXIMPORTO,";
    p_cSql = p_cSql+"TRXLUONAS,";
    p_cSql = p_cSql+"TRXMTCN,";
    p_cSql = p_cSql+"TRXNASCOMUN,";
    p_cSql = p_cSql+"TRXNASSTATO,";
    p_cSql = p_cSql+"TRXNAZRES,";
    p_cSql = p_cSql+"TRXNOMCON,";
    p_cSql = p_cSql+"TRXNOME,";
    p_cSql = p_cSql+"TRXNOTEOPER,";
    p_cSql = p_cSql+"TRXNUMDOC,";
    p_cSql = p_cSql+"TRXNUMRIL,";
    p_cSql = p_cSql+"TRXRECTYPE,";
    p_cSql = p_cSql+"TRXSCAEDT,";
    p_cSql = p_cSql+"TRXSESSO,";
    p_cSql = p_cSql+"TRXTFINLAV,";
    p_cSql = p_cSql+"TRXTINILAV,";
    p_cSql = p_cSql+"TRXTIPDOC,";
    p_cSql = p_cSql+"TRXUNIQUE,";
    p_cSql = p_cSql+"TRXUTENTE,";
    p_cSql = p_cSql+"TRXDERIVATA,";
    p_cSql = p_cSql+"TRXGALACTIC,";
    p_cSql = p_cSql+"TRXNAZRIL,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wutrxchk_checked",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000052(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TRDFINLAV,";
    p_cSql = p_cSql+"TRFLGINLAV,";
    p_cSql = p_cSql+"TRSSEGNO,";
    p_cSql = p_cSql+"TRXAUACHK,";
    p_cSql = p_cSql+"TRXAUICHK,";
    p_cSql = p_cSql+"TRXAUTRIL,";
    p_cSql = p_cSql+"TRXCITRES,";
    p_cSql = p_cSql+"TRXCODCAS,";
    p_cSql = p_cSql+"TRXCODDIP,";
    p_cSql = p_cSql+"TRXCODFIS,";
    p_cSql = p_cSql+"TRXCODMAG,";
    p_cSql = p_cSql+"TRXCODPRG,";
    p_cSql = p_cSql+"TRXCODUNI,";
    p_cSql = p_cSql+"TRXCOGCON,";
    p_cSql = p_cSql+"TRXCOGNOM,";
    p_cSql = p_cSql+"TRXCONTAN,";
    p_cSql = p_cSql+"TRXDATNAS,";
    p_cSql = p_cSql+"TRXDATOPE,";
    p_cSql = p_cSql+"TRXDATRICERCA,";
    p_cSql = p_cSql+"TRXDATRIL,";
    p_cSql = p_cSql+"TRXDATSCA,";
    p_cSql = p_cSql+"TRXDESTIN,";
    p_cSql = p_cSql+"TRXDINILAV,";
    p_cSql = p_cSql+"TRXDOMICI,";
    p_cSql = p_cSql+"TRXERRAUA01,";
    p_cSql = p_cSql+"TRXERRAUA02,";
    p_cSql = p_cSql+"TRXERRAUA03,";
    p_cSql = p_cSql+"TRXERRAUA04,";
    p_cSql = p_cSql+"TRXERRAUA05,";
    p_cSql = p_cSql+"TRXERRAUA06,";
    p_cSql = p_cSql+"TRXERRAUA07,";
    p_cSql = p_cSql+"TRXERRAUA08,";
    p_cSql = p_cSql+"TRXERRAUA09,";
    p_cSql = p_cSql+"TRXERRAUA10,";
    p_cSql = p_cSql+"TRXERROR01,";
    p_cSql = p_cSql+"TRXERROR02,";
    p_cSql = p_cSql+"TRXERROR03,";
    p_cSql = p_cSql+"TRXERROR04,";
    p_cSql = p_cSql+"TRXERROR05,";
    p_cSql = p_cSql+"TRXERROR06,";
    p_cSql = p_cSql+"TRXERROR07,";
    p_cSql = p_cSql+"TRXERROR08,";
    p_cSql = p_cSql+"TRXERROR09,";
    p_cSql = p_cSql+"TRXERROR10,";
    p_cSql = p_cSql+"TRXERROR11,";
    p_cSql = p_cSql+"TRXERROR12,";
    p_cSql = p_cSql+"TRXERROR13,";
    p_cSql = p_cSql+"TRXERROR14,";
    p_cSql = p_cSql+"TRXERROR15,";
    p_cSql = p_cSql+"TRXERROR16,";
    p_cSql = p_cSql+"TRXERROR17,";
    p_cSql = p_cSql+"TRXERROR18,";
    p_cSql = p_cSql+"TRXERROR19,";
    p_cSql = p_cSql+"TRXERROR20,";
    p_cSql = p_cSql+"TRXERROR21,";
    p_cSql = p_cSql+"TRXERROR22,";
    p_cSql = p_cSql+"TRXERROR23,";
    p_cSql = p_cSql+"TRXERROR24,";
    p_cSql = p_cSql+"TRXERROR25,";
    p_cSql = p_cSql+"TRXERROR26,";
    p_cSql = p_cSql+"TRXERROR27,";
    p_cSql = p_cSql+"TRXERROR28,";
    p_cSql = p_cSql+"TRXERROR29,";
    p_cSql = p_cSql+"TRXERROR30,";
    p_cSql = p_cSql+"TRXERROR31,";
    p_cSql = p_cSql+"TRXERROR32,";
    p_cSql = p_cSql+"TRXERROR33,";
    p_cSql = p_cSql+"TRXERROR34,";
    p_cSql = p_cSql+"TRXERROR35,";
    p_cSql = p_cSql+"TRXERROR36,";
    p_cSql = p_cSql+"TRXERROR37,";
    p_cSql = p_cSql+"TRXERROR38,";
    p_cSql = p_cSql+"TRXERROR39,";
    p_cSql = p_cSql+"TRXERROR40,";
    p_cSql = p_cSql+"TRXERROR41,";
    p_cSql = p_cSql+"TRXERROR42,";
    p_cSql = p_cSql+"TRXERROR43,";
    p_cSql = p_cSql+"TRXERROR44,";
    p_cSql = p_cSql+"TRXERROR45,";
    p_cSql = p_cSql+"TRXERROR46,";
    p_cSql = p_cSql+"TRXERROR47,";
    p_cSql = p_cSql+"TRXERROR48,";
    p_cSql = p_cSql+"TRXERROR49,";
    p_cSql = p_cSql+"TRXERROR50,";
    p_cSql = p_cSql+"TRXESITO,";
    p_cSql = p_cSql+"TRXFLGAUA,";
    p_cSql = p_cSql+"TRXFLGAUAQ1,";
    p_cSql = p_cSql+"TRXFLGAUAQ2,";
    p_cSql = p_cSql+"TRXFLGAUAQ3,";
    p_cSql = p_cSql+"TRXFLGAUAQ4,";
    p_cSql = p_cSql+"TRXFLGAUAQ5,";
    p_cSql = p_cSql+"TRXFLGAUI,";
    p_cSql = p_cSql+"TRXFLGCF,";
    p_cSql = p_cSql+"TRXFLGCON,";
    p_cSql = p_cSql+"TRXFLGFOR,";
    p_cSql = p_cSql+"TRXFORCE,";
    p_cSql = p_cSql+"TRXIMPORTO,";
    p_cSql = p_cSql+"TRXLUONAS,";
    p_cSql = p_cSql+"TRXMTCN,";
    p_cSql = p_cSql+"TRXNASCOMUN,";
    p_cSql = p_cSql+"TRXNASSTATO,";
    p_cSql = p_cSql+"TRXNAZRES,";
    p_cSql = p_cSql+"TRXNOMCON,";
    p_cSql = p_cSql+"TRXNOME,";
    p_cSql = p_cSql+"TRXNOTEOPER,";
    p_cSql = p_cSql+"TRXNUMDOC,";
    p_cSql = p_cSql+"TRXNUMRIL,";
    p_cSql = p_cSql+"TRXRECTYPE,";
    p_cSql = p_cSql+"TRXSCAEDT,";
    p_cSql = p_cSql+"TRXSESSO,";
    p_cSql = p_cSql+"TRXTFINLAV,";
    p_cSql = p_cSql+"TRXTINILAV,";
    p_cSql = p_cSql+"TRXTIPDOC,";
    p_cSql = p_cSql+"TRXUNIQUE,";
    p_cSql = p_cSql+"TRXUTENTE,";
    p_cSql = p_cSql+"TRXDERIVATA,";
    p_cSql = p_cSql+"TRXGALACTIC,";
    p_cSql = p_cSql+"TRXNAZRIL,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wutrxchk_checked",true);
    return p_cSql;
  }
}
