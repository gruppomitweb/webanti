// * --- Area Manuale = BO - Header
// * --- arrt_start_estrai_xls
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
import com.opencsv.CSVWriter;
import java.util.ArrayList;
// * --- Fine Area Manuale
public class arrt_start_estrai_xlsR implements CallerWithObjs {
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
  public String m_cPhName_bckprocessi;
  public String m_cServer_bckprocessi;
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
  public java.sql.Date w_dadata;
  public java.sql.Date w_adata;
  public String w_cdadata;
  public String w_c_adata;
  public String w_cDIP;
  public String w_xdesdip;
  public String w_ragosc;
  public String w_citnas;
  public String w_stanas;
  public java.sql.Date w_datnas;
  public String w_cMTCN;
  public String w_cCODFISC;
  public String w_ragben;
  public String w_staben;
  public String w_codmag;
  public String w_connes;
  public String w_nomefile;
  public String w_tipofile;
  public String w_flgsto;
  public String w_tipoout;
  public String w_opesel;
  public String w_frzsel;
  public String w_attive;
  public String w_destfold;
  public String w_flgmese;
  public String w_flgncf;
  public String w_flgsegno;
  public String gAzienda;
  public String gPathApp;
  public String gFileName;
  public String gUrlApp;
  public String gMsgImp;
  public String cProg;
  public String _filezip;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_start_estrai_xls
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
  // * --- Fine Area Manuale
  public arrt_start_estrai_xlsR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_start_estrai_xls",m_Caller);
    m_cPhName_bckprocessi = p_ContextObject.GetPhName("bckprocessi");
    if (m_cPhName_bckprocessi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_bckprocessi = m_cPhName_bckprocessi+" "+m_Ctx.GetWritePhName("bckprocessi");
    }
    m_cServer_bckprocessi = p_ContextObject.GetServer("bckprocessi");
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
      return "arrt_start_estrai_xls";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("cdadata",p_cVarName)) {
      return w_cdadata;
    }
    if (CPLib.eqr("c_adata",p_cVarName)) {
      return w_c_adata;
    }
    if (CPLib.eqr("cDIP",p_cVarName)) {
      return w_cDIP;
    }
    if (CPLib.eqr("xdesdip",p_cVarName)) {
      return w_xdesdip;
    }
    if (CPLib.eqr("ragosc",p_cVarName)) {
      return w_ragosc;
    }
    if (CPLib.eqr("citnas",p_cVarName)) {
      return w_citnas;
    }
    if (CPLib.eqr("stanas",p_cVarName)) {
      return w_stanas;
    }
    if (CPLib.eqr("cMTCN",p_cVarName)) {
      return w_cMTCN;
    }
    if (CPLib.eqr("cCODFISC",p_cVarName)) {
      return w_cCODFISC;
    }
    if (CPLib.eqr("ragben",p_cVarName)) {
      return w_ragben;
    }
    if (CPLib.eqr("staben",p_cVarName)) {
      return w_staben;
    }
    if (CPLib.eqr("codmag",p_cVarName)) {
      return w_codmag;
    }
    if (CPLib.eqr("connes",p_cVarName)) {
      return w_connes;
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      return w_nomefile;
    }
    if (CPLib.eqr("tipofile",p_cVarName)) {
      return w_tipofile;
    }
    if (CPLib.eqr("flgsto",p_cVarName)) {
      return w_flgsto;
    }
    if (CPLib.eqr("tipoout",p_cVarName)) {
      return w_tipoout;
    }
    if (CPLib.eqr("opesel",p_cVarName)) {
      return w_opesel;
    }
    if (CPLib.eqr("frzsel",p_cVarName)) {
      return w_frzsel;
    }
    if (CPLib.eqr("attive",p_cVarName)) {
      return w_attive;
    }
    if (CPLib.eqr("destfold",p_cVarName)) {
      return w_destfold;
    }
    if (CPLib.eqr("flgmese",p_cVarName)) {
      return w_flgmese;
    }
    if (CPLib.eqr("flgncf",p_cVarName)) {
      return w_flgncf;
    }
    if (CPLib.eqr("flgsegno",p_cVarName)) {
      return w_flgsegno;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gFileName",p_cVarName)) {
      return gFileName;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      return cProg;
    }
    if (CPLib.eqr("_filezip",p_cVarName)) {
      return _filezip;
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
    if (CPLib.eqr("datnas",p_cVarName)) {
      return w_datnas;
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
    if (CPLib.eqr("cdadata",p_cVarName)) {
      w_cdadata = value;
      return;
    }
    if (CPLib.eqr("c_adata",p_cVarName)) {
      w_c_adata = value;
      return;
    }
    if (CPLib.eqr("cDIP",p_cVarName)) {
      w_cDIP = value;
      return;
    }
    if (CPLib.eqr("xdesdip",p_cVarName)) {
      w_xdesdip = value;
      return;
    }
    if (CPLib.eqr("ragosc",p_cVarName)) {
      w_ragosc = value;
      return;
    }
    if (CPLib.eqr("citnas",p_cVarName)) {
      w_citnas = value;
      return;
    }
    if (CPLib.eqr("stanas",p_cVarName)) {
      w_stanas = value;
      return;
    }
    if (CPLib.eqr("cMTCN",p_cVarName)) {
      w_cMTCN = value;
      return;
    }
    if (CPLib.eqr("cCODFISC",p_cVarName)) {
      w_cCODFISC = value;
      return;
    }
    if (CPLib.eqr("ragben",p_cVarName)) {
      w_ragben = value;
      return;
    }
    if (CPLib.eqr("staben",p_cVarName)) {
      w_staben = value;
      return;
    }
    if (CPLib.eqr("codmag",p_cVarName)) {
      w_codmag = value;
      return;
    }
    if (CPLib.eqr("connes",p_cVarName)) {
      w_connes = value;
      return;
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      w_nomefile = value;
      return;
    }
    if (CPLib.eqr("tipofile",p_cVarName)) {
      w_tipofile = value;
      return;
    }
    if (CPLib.eqr("flgsto",p_cVarName)) {
      w_flgsto = value;
      return;
    }
    if (CPLib.eqr("tipoout",p_cVarName)) {
      w_tipoout = value;
      return;
    }
    if (CPLib.eqr("opesel",p_cVarName)) {
      w_opesel = value;
      return;
    }
    if (CPLib.eqr("frzsel",p_cVarName)) {
      w_frzsel = value;
      return;
    }
    if (CPLib.eqr("attive",p_cVarName)) {
      w_attive = value;
      return;
    }
    if (CPLib.eqr("destfold",p_cVarName)) {
      w_destfold = value;
      return;
    }
    if (CPLib.eqr("flgmese",p_cVarName)) {
      w_flgmese = value;
      return;
    }
    if (CPLib.eqr("flgncf",p_cVarName)) {
      w_flgncf = value;
      return;
    }
    if (CPLib.eqr("flgsegno",p_cVarName)) {
      w_flgsegno = value;
      return;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
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
    if (CPLib.eqr("gFileName",p_cVarName)) {
      gFileName = value;
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
    if (CPLib.eqr("cProg",p_cVarName)) {
      cProg = value;
      return;
    }
    if (CPLib.eqr("_filezip",p_cVarName)) {
      _filezip = value;
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
    if (CPLib.eqr("datnas",p_cVarName)) {
      w_datnas = value;
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
    /* pTipo Char(1) */
    /* w_dadata Date */
    /* w_adata Date */
    /* w_cdadata Char(8) */
    /* w_c_adata Char(8) */
    /* w_cDIP Char(6) */
    /* w_xdesdip Char(30) // Descrizione */
    /* w_ragosc Char(60) // Nominativo */
    /* w_citnas Char(40) // Citta di nascita */
    /* w_stanas Char(40) // Stato di nascita */
    /* w_datnas Date // Data di nascita */
    /* w_cMTCN Char(10) */
    /* w_cCODFISC Char(16) */
    /* w_ragben Char(60) // Nominativo */
    /* w_staben Char(40) // Stato di nascita */
    /* w_codmag Char(5) // MacroAgente */
    /* w_connes Char(16) // MacroAgente */
    /* w_nomefile Char(60) // Nome File */
    /* w_tipofile Char(1) */
    /* w_flgsto Char(1) */
    /* w_tipoout Char(1) */
    /* w_opesel Char(1) */
    /* w_frzsel Char(1) */
    /* w_attive Char(1) */
    /* w_destfold Char(128) */
    /* w_flgmese Char(1) */
    /* w_flgncf Char(1) */
    /* w_flgsegno Char(1) */
    /* gAzienda Char(10) // Azienda */
    /* gPathApp Char(80) // Path Applicazione */
    /* gFileName Char(80) // NomeFile */
    /* gUrlApp Char(80) // URL Applicazione */
    /* gMsgImp Char(120) // Messaggio Import */
    /* cProg Char(10) */
    /* _filezip Char(128) */
    /* If pTipo='B' */
    if (CPLib.eqr(pTipo,"B")) {
      /* cProg := Utilities.GetAutonumber("PBCKPROC\'"+LRTrim(gAzienda)+"'","",10) */
      cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PBCKPROC\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
      // * --- Insert into bckprocessi from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("bckprocessi");
      m_cPhName = m_Ctx.GetPhName("bckprocessi");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"bckprocessi",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_start_estrai_xls",251,"00000029")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
      m_cSql = m_cSql+GetFieldsName_00000029(m_Ctx,m_oWrInfo);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("arrt_estrai_xls","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(pTipo,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(w_dadata),"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(w_adata),"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_cdadata,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_c_adata,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_cDIP,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_xdesdip,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_ragosc,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_citnas,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_stanas,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(w_datnas)?"":CPLib.DateToChar(w_datnas)),"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_cMTCN,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_cCODFISC,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_ragben,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_staben,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_codmag,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_connes,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_nomefile,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_tipofile,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_flgsto,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_tipoout,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_opesel,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_frzsel,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_attive,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_destfold,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(gAzienda,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(gPathApp,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_flgmese,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_flgncf,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_flgsegno,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(32,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+m_oWrInfo.InsertValues();
      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"bckprocessi",true);
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
      /* gMsgImp := 'Elaborazione programmata. Consultare la schermata dei processi per verificare lo stato di avanzamento' // Messaggio Import */
      gMsgImp = "Elaborazione programmata. Consultare la schermata dei processi per verificare lo stato di avanzamento";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } else { // Else
      /* Exec Routine arrt_estrai_xls(pTipo,w_dadata,w_adata,w_cdadata,w_c_adata,w_cDIP,w_xdesdip,w_ragosc,w_citnas,w_stanas,w_datnas,w_cMTCN,w_cCODFISC,w_ragben,w_staben,w_codmag,w_connes,w_nomefile,w_tipofile,w_flgsto,w_tipoout,w_opesel,w_frzsel,w_attive,w_destfold,gAzienda,gPathApp,w_flgmese,w_flgncf,w_flgsegno,"","",0) */
      arrt_estrai_xlsR.Make(m_Ctx,this).Run(pTipo,w_dadata,w_adata,w_cdadata,w_c_adata,w_cDIP,w_xdesdip,w_ragosc,w_citnas,w_stanas,w_datnas,w_cMTCN,w_cCODFISC,w_ragben,w_staben,w_codmag,w_connes,w_nomefile,w_tipofile,w_flgsto,w_tipoout,w_opesel,w_frzsel,w_attive,w_destfold,gAzienda,gPathApp,w_flgmese,w_flgncf,w_flgsegno,"","",0);
      /* gMsgImp := 'Elaborazione Terminata. Attendere lo scaricamento del file' // Messaggio Import */
      gMsgImp = "Elaborazione Terminata. Attendere lo scaricamento del file";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // Rilegge il valore di gFileName
      gFileName=m_Ctx.GetGlobalString("gFileName");
      /* _filezip := iif(Empty(LRTrim(w_destfold)),LRTrim(gPathApp)+"/export/"+LRTrim(gAzienda)+"/"+LRTrim(gFileName),LRTrim(w_destfold)+"/"+LRTrim(gFileName)) */
      _filezip = (CPLib.Empty(CPLib.LRTrim(w_destfold))?CPLib.LRTrim(gPathApp)+"/export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(gFileName):CPLib.LRTrim(w_destfold)+"/"+CPLib.LRTrim(gFileName));
      /* Stop LRTrim(gUrlApp)+"servlet/DownloadFileDirect?fileName="+LRTrim(_filezip) */
      Forward f;
      f=new Forward(CPLib.LRTrim(gUrlApp)+"servlet/DownloadFileDirect?fileName="+CPLib.LRTrim(_filezip),false,this,Forward.NoStatus,true);
      f.SetParameter("m_cParameterSequence", "");
      f.SetParameter("m_cMode","hyperlink");
      throw f;
    } // End If
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
      m_Caller.SetDate("dadata","D",8,0,w_dadata);
      m_Caller.SetDate("adata","D",8,0,w_adata);
      m_Caller.SetString("cdadata","C",8,0,w_cdadata);
      m_Caller.SetString("c_adata","C",8,0,w_c_adata);
      m_Caller.SetString("cDIP","C",6,0,w_cDIP);
      m_Caller.SetString("xdesdip","C",30,0,w_xdesdip);
      m_Caller.SetString("ragosc","C",60,0,w_ragosc);
      m_Caller.SetString("citnas","C",40,0,w_citnas);
      m_Caller.SetString("stanas","C",40,0,w_stanas);
      m_Caller.SetDate("datnas","D",8,0,w_datnas);
      m_Caller.SetString("cMTCN","C",10,0,w_cMTCN);
      m_Caller.SetString("cCODFISC","C",16,0,w_cCODFISC);
      m_Caller.SetString("ragben","C",60,0,w_ragben);
      m_Caller.SetString("staben","C",40,0,w_staben);
      m_Caller.SetString("codmag","C",5,0,w_codmag);
      m_Caller.SetString("connes","C",16,0,w_connes);
      m_Caller.SetString("nomefile","C",60,0,w_nomefile);
      m_Caller.SetString("tipofile","C",1,0,w_tipofile);
      m_Caller.SetString("flgsto","C",1,0,w_flgsto);
      m_Caller.SetString("tipoout","C",1,0,w_tipoout);
      m_Caller.SetString("opesel","C",1,0,w_opesel);
      m_Caller.SetString("frzsel","C",1,0,w_frzsel);
      m_Caller.SetString("attive","C",1,0,w_attive);
      m_Caller.SetString("destfold","C",128,0,w_destfold);
      m_Caller.SetString("flgmese","C",1,0,w_flgmese);
      m_Caller.SetString("flgncf","C",1,0,w_flgncf);
      m_Caller.SetString("flgsegno","C",1,0,w_flgsegno);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_start_estrai_xlsR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_start_estrai_xlsR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pTipo = CPLib.Space(1);
    w_dadata = m_Caller.GetDate("dadata","D",8,0);
    w_adata = m_Caller.GetDate("adata","D",8,0);
    w_cdadata = m_Caller.GetString("cdadata","C",8,0);
    w_c_adata = m_Caller.GetString("c_adata","C",8,0);
    w_cDIP = m_Caller.GetString("cDIP","C",6,0);
    w_xdesdip = m_Caller.GetString("xdesdip","C",30,0);
    w_ragosc = m_Caller.GetString("ragosc","C",60,0);
    w_citnas = m_Caller.GetString("citnas","C",40,0);
    w_stanas = m_Caller.GetString("stanas","C",40,0);
    w_datnas = m_Caller.GetDate("datnas","D",8,0);
    w_cMTCN = m_Caller.GetString("cMTCN","C",10,0);
    w_cCODFISC = m_Caller.GetString("cCODFISC","C",16,0);
    w_ragben = m_Caller.GetString("ragben","C",60,0);
    w_staben = m_Caller.GetString("staben","C",40,0);
    w_codmag = m_Caller.GetString("codmag","C",5,0);
    w_connes = m_Caller.GetString("connes","C",16,0);
    w_nomefile = m_Caller.GetString("nomefile","C",60,0);
    w_tipofile = m_Caller.GetString("tipofile","C",1,0);
    w_flgsto = m_Caller.GetString("flgsto","C",1,0);
    w_tipoout = m_Caller.GetString("tipoout","C",1,0);
    w_opesel = m_Caller.GetString("opesel","C",1,0);
    w_frzsel = m_Caller.GetString("frzsel","C",1,0);
    w_attive = m_Caller.GetString("attive","C",1,0);
    w_destfold = m_Caller.GetString("destfold","C",128,0);
    w_flgmese = m_Caller.GetString("flgmese","C",1,0);
    w_flgncf = m_Caller.GetString("flgncf","C",1,0);
    w_flgsegno = m_Caller.GetString("flgsegno","C",1,0);
    cProg = CPLib.Space(10);
    _filezip = CPLib.Space(128);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gFileName=m_Ctx.GetGlobalString("gFileName");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arrt_estrai_xls,
  public static final String i_InvokedRoutines = ",arrt_estrai_xls,";
  public static String[] m_cRunParameterNames={"pTipo"};
  protected static String GetFieldsName_00000029(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PBCODICE,";
    p_cSql = p_cSql+"PBSTATO,";
    p_cSql = p_cSql+"PBSERVLET,";
    p_cSql = p_cSql+"PBPARAM01,";
    p_cSql = p_cSql+"PBPARAM02,";
    p_cSql = p_cSql+"PBPARAM03,";
    p_cSql = p_cSql+"PBPARAM04,";
    p_cSql = p_cSql+"PBPARAM05,";
    p_cSql = p_cSql+"PBPARAM06,";
    p_cSql = p_cSql+"PBPARAM07,";
    p_cSql = p_cSql+"PBPARAM08,";
    p_cSql = p_cSql+"PBPARAM09,";
    p_cSql = p_cSql+"PBPARAM10,";
    p_cSql = p_cSql+"PBPARAM11,";
    p_cSql = p_cSql+"PBPARAM12,";
    p_cSql = p_cSql+"PBPARAM13,";
    p_cSql = p_cSql+"PBPARAM14,";
    p_cSql = p_cSql+"PBPARAM15,";
    p_cSql = p_cSql+"PBPARAM16,";
    p_cSql = p_cSql+"PBPARAM17,";
    p_cSql = p_cSql+"PBPARAM18,";
    p_cSql = p_cSql+"PBPARAM19,";
    p_cSql = p_cSql+"PBPARAM20,";
    p_cSql = p_cSql+"PBPARAM21,";
    p_cSql = p_cSql+"PBPARAM22,";
    p_cSql = p_cSql+"PBPARAM23,";
    p_cSql = p_cSql+"PBPARAM24,";
    p_cSql = p_cSql+"PBPARAM25,";
    p_cSql = p_cSql+"PBPARAM26,";
    p_cSql = p_cSql+"PBPARAM27,";
    p_cSql = p_cSql+"PBPARAM28,";
    p_cSql = p_cSql+"PBPARAM29,";
    p_cSql = p_cSql+"PBPARAM30,";
    p_cSql = p_cSql+"PBTIPOP01,";
    p_cSql = p_cSql+"PBTIPOP02,";
    p_cSql = p_cSql+"PBTIPOP03,";
    p_cSql = p_cSql+"PBTIPOP04,";
    p_cSql = p_cSql+"PBTIPOP05,";
    p_cSql = p_cSql+"PBTIPOP06,";
    p_cSql = p_cSql+"PBTIPOP07,";
    p_cSql = p_cSql+"PBTIPOP08,";
    p_cSql = p_cSql+"PBTIPOP09,";
    p_cSql = p_cSql+"PBTIPOP10,";
    p_cSql = p_cSql+"PBTIPOP11,";
    p_cSql = p_cSql+"PBTIPOP12,";
    p_cSql = p_cSql+"PBTIPOP13,";
    p_cSql = p_cSql+"PBTIPOP14,";
    p_cSql = p_cSql+"PBTIPOP15,";
    p_cSql = p_cSql+"PBTIPOP16,";
    p_cSql = p_cSql+"PBTIPOP17,";
    p_cSql = p_cSql+"PBTIPOP18,";
    p_cSql = p_cSql+"PBTIPOP19,";
    p_cSql = p_cSql+"PBTIPOP20,";
    p_cSql = p_cSql+"PBTIPOP21,";
    p_cSql = p_cSql+"PBTIPOP22,";
    p_cSql = p_cSql+"PBTIPOP23,";
    p_cSql = p_cSql+"PBTIPOP24,";
    p_cSql = p_cSql+"PBTIPOP25,";
    p_cSql = p_cSql+"PBTIPOP26,";
    p_cSql = p_cSql+"PBTIPOP27,";
    p_cSql = p_cSql+"PBTIPOP28,";
    p_cSql = p_cSql+"PBTIPOP29,";
    p_cSql = p_cSql+"PBTIPOP30,";
    p_cSql = p_cSql+"PBNUMPAR,";
    p_cSql = p_cSql+"PBPARAM31,";
    p_cSql = p_cSql+"PBPARAM32,";
    p_cSql = p_cSql+"PBTIPOP31,";
    p_cSql = p_cSql+"PBTIPOP32,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"bckprocessi",true);
    return p_cSql;
  }
}
