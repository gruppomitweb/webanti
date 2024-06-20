// * --- Area Manuale = BO - Header
// * --- arfn_import_correzioni_sv_all
import java.util.*;
import java.util.Iterator;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

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

import com.monitorjbl.xlsx.*;
// * --- Fine Area Manuale
public class arfn_import_correzioni_sv_allR implements CallerWithObjs {
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
  public String m_cPhName_analisi_sv;
  public String m_cServer_analisi_sv;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_tbsetsina;
  public String m_cServer_tbsetsina;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_personbo_agg;
  public String m_cServer_personbo_agg;
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
  public String nomefile;
  public double riga_letta;
  public double foglio;
  public double cell_type;
  public String _cRitorno;
  public double _contar;
  public String _stgrup;
  public String _ateco;
  public String _ramo;
  public String _settsint;
  public MemoryCursor_tbstati mcStati;
  public MemoryCursor_mcconnes_mcrdef mcWersonbo;
  public MemoryCursor_qbe_setsin_vqr mcSettori;
  public MemoryCursor_tbsetsina mcSetSina;
  public String cProgSto;
  public String column01;
  public String column02;
  public String column03;
  public String column04;
  public String column05;
  public String column06;
  public String column07;
  public String column08;
  public String column09;
  public String column10;
  public String column11;
  public String column12;
  public String column13;
  public String column14;
  public String column15;
  public String column16;
  public String column17;
  public String column18;
  public String column19;
  public String column20;
  public String column21;
  public String column22;
  public String column23;
  public String column24;
  public String column25;
  public String column26;
  public String column27;
  public String column28;
  public String column29;
  public String column30;
  public String gAzienda;
  public String gPathApp;
  public String gPathDoc;
  public java.sql.Date gDataVaria;
  public String gMsgProc;
  public String gMsgImp;
  // * --- Area Manuale = BO - Properties
  // * --- arfn_import_correzioni_sv_all
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
  //public SXSSFWorkbook wb;
  //public SXSSFSheet sheet;
  //public Row row; 
  //public Cell cell;
  public CellStyle cs;
  public Font f;
  public String[] colonna;
  // * --- Fine Area Manuale
  public arfn_import_correzioni_sv_allR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_import_correzioni_sv_all",m_Caller);
    m_cPhName_analisi_sv = p_ContextObject.GetPhName("analisi_sv");
    if (m_cPhName_analisi_sv.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_analisi_sv = m_cPhName_analisi_sv+" "+m_Ctx.GetWritePhName("analisi_sv");
    }
    m_cServer_analisi_sv = p_ContextObject.GetServer("analisi_sv");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_tbsetsina = p_ContextObject.GetPhName("tbsetsina");
    if (m_cPhName_tbsetsina.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbsetsina = m_cPhName_tbsetsina+" "+m_Ctx.GetWritePhName("tbsetsina");
    }
    m_cServer_tbsetsina = p_ContextObject.GetServer("tbsetsina");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    if (m_cPhName_tbstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstati = m_cPhName_tbstati+" "+m_Ctx.GetWritePhName("tbstati");
    }
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_cPhName_wersonbo = p_ContextObject.GetPhName("wersonbo");
    if (m_cPhName_wersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo = m_cPhName_wersonbo+" "+m_Ctx.GetWritePhName("wersonbo");
    }
    m_cServer_wersonbo = p_ContextObject.GetServer("wersonbo");
    m_cPhName_opextrbo = p_ContextObject.GetPhName("opextrbo");
    if (m_cPhName_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_opextrbo = m_cPhName_opextrbo+" "+m_Ctx.GetWritePhName("opextrbo");
    }
    m_cServer_opextrbo = p_ContextObject.GetServer("opextrbo");
    m_cPhName_personbo_agg = p_ContextObject.GetPhName("personbo_agg");
    if (m_cPhName_personbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo_agg = m_cPhName_personbo_agg+" "+m_Ctx.GetWritePhName("personbo_agg");
    }
    m_cServer_personbo_agg = p_ContextObject.GetServer("personbo_agg");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("riga_letta",p_cVarName)) {
      return riga_letta;
    }
    if (CPLib.eqr("foglio",p_cVarName)) {
      return foglio;
    }
    if (CPLib.eqr("cell_type",p_cVarName)) {
      return cell_type;
    }
    if (CPLib.eqr("_contar",p_cVarName)) {
      return _contar;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_import_correzioni_sv_all";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      return nomefile;
    }
    if (CPLib.eqr("_cRitorno",p_cVarName)) {
      return _cRitorno;
    }
    if (CPLib.eqr("_stgrup",p_cVarName)) {
      return _stgrup;
    }
    if (CPLib.eqr("_ateco",p_cVarName)) {
      return _ateco;
    }
    if (CPLib.eqr("_ramo",p_cVarName)) {
      return _ramo;
    }
    if (CPLib.eqr("_settsint",p_cVarName)) {
      return _settsint;
    }
    if (CPLib.eqr("cProgSto",p_cVarName)) {
      return cProgSto;
    }
    if (CPLib.eqr("column01",p_cVarName)) {
      return column01;
    }
    if (CPLib.eqr("column02",p_cVarName)) {
      return column02;
    }
    if (CPLib.eqr("column03",p_cVarName)) {
      return column03;
    }
    if (CPLib.eqr("column04",p_cVarName)) {
      return column04;
    }
    if (CPLib.eqr("column05",p_cVarName)) {
      return column05;
    }
    if (CPLib.eqr("column06",p_cVarName)) {
      return column06;
    }
    if (CPLib.eqr("column07",p_cVarName)) {
      return column07;
    }
    if (CPLib.eqr("column08",p_cVarName)) {
      return column08;
    }
    if (CPLib.eqr("column09",p_cVarName)) {
      return column09;
    }
    if (CPLib.eqr("column10",p_cVarName)) {
      return column10;
    }
    if (CPLib.eqr("column11",p_cVarName)) {
      return column11;
    }
    if (CPLib.eqr("column12",p_cVarName)) {
      return column12;
    }
    if (CPLib.eqr("column13",p_cVarName)) {
      return column13;
    }
    if (CPLib.eqr("column14",p_cVarName)) {
      return column14;
    }
    if (CPLib.eqr("column15",p_cVarName)) {
      return column15;
    }
    if (CPLib.eqr("column16",p_cVarName)) {
      return column16;
    }
    if (CPLib.eqr("column17",p_cVarName)) {
      return column17;
    }
    if (CPLib.eqr("column18",p_cVarName)) {
      return column18;
    }
    if (CPLib.eqr("column19",p_cVarName)) {
      return column19;
    }
    if (CPLib.eqr("column20",p_cVarName)) {
      return column20;
    }
    if (CPLib.eqr("column21",p_cVarName)) {
      return column21;
    }
    if (CPLib.eqr("column22",p_cVarName)) {
      return column22;
    }
    if (CPLib.eqr("column23",p_cVarName)) {
      return column23;
    }
    if (CPLib.eqr("column24",p_cVarName)) {
      return column24;
    }
    if (CPLib.eqr("column25",p_cVarName)) {
      return column25;
    }
    if (CPLib.eqr("column26",p_cVarName)) {
      return column26;
    }
    if (CPLib.eqr("column27",p_cVarName)) {
      return column27;
    }
    if (CPLib.eqr("column28",p_cVarName)) {
      return column28;
    }
    if (CPLib.eqr("column29",p_cVarName)) {
      return column29;
    }
    if (CPLib.eqr("column30",p_cVarName)) {
      return column30;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      return gPathDoc;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("gDataVaria",p_cVarName)) {
      return gDataVaria;
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
    if (CPLib.eqr("mcWersonbo",p_cVarName)) {
      return mcWersonbo;
    }
    if (CPLib.eqr("mcSettori",p_cVarName)) {
      return mcSettori;
    }
    if (CPLib.eqr("mcSetSina",p_cVarName)) {
      return mcSetSina;
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
    if (CPLib.eqr("riga_letta",p_cVarName)) {
      riga_letta = value;
      return;
    }
    if (CPLib.eqr("foglio",p_cVarName)) {
      foglio = value;
      return;
    }
    if (CPLib.eqr("cell_type",p_cVarName)) {
      cell_type = value;
      return;
    }
    if (CPLib.eqr("_contar",p_cVarName)) {
      _contar = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("nomefile",p_cVarName)) {
      nomefile = value;
      return;
    }
    if (CPLib.eqr("_cRitorno",p_cVarName)) {
      _cRitorno = value;
      return;
    }
    if (CPLib.eqr("_stgrup",p_cVarName)) {
      _stgrup = value;
      return;
    }
    if (CPLib.eqr("_ateco",p_cVarName)) {
      _ateco = value;
      return;
    }
    if (CPLib.eqr("_ramo",p_cVarName)) {
      _ramo = value;
      return;
    }
    if (CPLib.eqr("_settsint",p_cVarName)) {
      _settsint = value;
      return;
    }
    if (CPLib.eqr("cProgSto",p_cVarName)) {
      cProgSto = value;
      return;
    }
    if (CPLib.eqr("column01",p_cVarName)) {
      column01 = value;
      return;
    }
    if (CPLib.eqr("column02",p_cVarName)) {
      column02 = value;
      return;
    }
    if (CPLib.eqr("column03",p_cVarName)) {
      column03 = value;
      return;
    }
    if (CPLib.eqr("column04",p_cVarName)) {
      column04 = value;
      return;
    }
    if (CPLib.eqr("column05",p_cVarName)) {
      column05 = value;
      return;
    }
    if (CPLib.eqr("column06",p_cVarName)) {
      column06 = value;
      return;
    }
    if (CPLib.eqr("column07",p_cVarName)) {
      column07 = value;
      return;
    }
    if (CPLib.eqr("column08",p_cVarName)) {
      column08 = value;
      return;
    }
    if (CPLib.eqr("column09",p_cVarName)) {
      column09 = value;
      return;
    }
    if (CPLib.eqr("column10",p_cVarName)) {
      column10 = value;
      return;
    }
    if (CPLib.eqr("column11",p_cVarName)) {
      column11 = value;
      return;
    }
    if (CPLib.eqr("column12",p_cVarName)) {
      column12 = value;
      return;
    }
    if (CPLib.eqr("column13",p_cVarName)) {
      column13 = value;
      return;
    }
    if (CPLib.eqr("column14",p_cVarName)) {
      column14 = value;
      return;
    }
    if (CPLib.eqr("column15",p_cVarName)) {
      column15 = value;
      return;
    }
    if (CPLib.eqr("column16",p_cVarName)) {
      column16 = value;
      return;
    }
    if (CPLib.eqr("column17",p_cVarName)) {
      column17 = value;
      return;
    }
    if (CPLib.eqr("column18",p_cVarName)) {
      column18 = value;
      return;
    }
    if (CPLib.eqr("column19",p_cVarName)) {
      column19 = value;
      return;
    }
    if (CPLib.eqr("column20",p_cVarName)) {
      column20 = value;
      return;
    }
    if (CPLib.eqr("column21",p_cVarName)) {
      column21 = value;
      return;
    }
    if (CPLib.eqr("column22",p_cVarName)) {
      column22 = value;
      return;
    }
    if (CPLib.eqr("column23",p_cVarName)) {
      column23 = value;
      return;
    }
    if (CPLib.eqr("column24",p_cVarName)) {
      column24 = value;
      return;
    }
    if (CPLib.eqr("column25",p_cVarName)) {
      column25 = value;
      return;
    }
    if (CPLib.eqr("column26",p_cVarName)) {
      column26 = value;
      return;
    }
    if (CPLib.eqr("column27",p_cVarName)) {
      column27 = value;
      return;
    }
    if (CPLib.eqr("column28",p_cVarName)) {
      column28 = value;
      return;
    }
    if (CPLib.eqr("column29",p_cVarName)) {
      column29 = value;
      return;
    }
    if (CPLib.eqr("column30",p_cVarName)) {
      column30 = value;
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
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      gPathDoc = value;
      return;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
      return;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("gDataVaria",p_cVarName)) {
      gDataVaria = value;
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
    if (CPLib.eqr("mcStati",p_cVarName)) {
      mcStati = (MemoryCursor_tbstati)value;
      return;
    }
    if (CPLib.eqr("mcWersonbo",p_cVarName)) {
      mcWersonbo = (MemoryCursor_mcconnes_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcSettori",p_cVarName)) {
      mcSettori = (MemoryCursor_qbe_setsin_vqr)value;
      return;
    }
    if (CPLib.eqr("mcSetSina",p_cVarName)) {
      mcSetSina = (MemoryCursor_tbsetsina)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_tbstati=null;
    CPResultSet Cursor_qbe_setsin=null;
    CPResultSet Cursor_tbsetsina=null;
    CPResultSet Cursor_personbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* nomefile Char(30) // nome file da importare */
      /* riga_letta Numeric(10, 0) */
      /* foglio Numeric(2, 0) // foglio letto */
      double foglio;
      foglio = 0;
      /* cCanc Char(10) */
      String cCanc;
      cCanc = CPLib.Space(10);
      /* cProg Char(10) */
      String cProg;
      cProg = CPLib.Space(10);
      /* _progrig Char(10) */
      String _progrig;
      _progrig = CPLib.Space(10);
      /* foglio Numeric(2, 0) // foglio letto */
      /* cell_type Numeric(1, 0) // tipologia di cella letta */
      /* _cRitorno Char(2) */
      /* _contar Numeric(10, 0) */
      /* _stgrup Char(3) */
      /* _ateco Char(10) */
      /* _ramo Char(3) */
      /* _settsint Char(3) */
      /* mcStati MemoryCursor(tbstati) */
      /* mcWersonbo MemoryCursor(mcConnes.MCRDef) */
      /* mcSettori MemoryCursor(qbe_setsin.vqr) */
      /* mcSetSina MemoryCursor(tbsetsina) */
      /* cProgSto Char(15) */
      /* _ateco Char(10) */
      /* _ramo Char(3) */
      /* _settsint Char(3) */
      /* column01 Char(100) */
      /* column02 Char(100) */
      /* column03 Char(100) */
      /* column04 Char(100) */
      /* column05 Char(100) */
      /* column06 Char(100) */
      /* column07 Char(100) */
      /* column08 Char(100) */
      /* column09 Char(100) */
      /* column10 Char(100) */
      /* column11 Char(100) */
      /* column12 Char(100) */
      /* column13 Char(100) */
      /* column14 Char(100) */
      /* column15 Char(100) */
      /* column16 Char(100) */
      /* column17 Char(100) */
      /* column18 Char(100) */
      /* column19 Char(100) */
      /* column20 Char(100) */
      /* column21 Char(100) */
      /* column22 Char(100) */
      /* column23 Char(100) */
      /* column24 Char(100) */
      /* column25 Char(100) */
      /* column26 Char(100) */
      /* column27 Char(100) */
      /* column28 Char(100) */
      /* column29 Char(100) */
      /* column30 Char(100) */
      /* gAzienda Char(10) // Azienda */
      /* gPathApp Char(80) // Path Applicazione */
      /* gPathDoc Char(80) // Path Applicazione */
      /* gDataVaria Date // Data Variazione */
      /* gMsgProc Char(120) // Messaggio */
      /* gMsgImp Char(120) */
      /* gMsgProc := 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + nomefile + NL */
      gMsgProc = "Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefile+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000041status;
      nTry00000041status = m_Sql.GetTransactionStatus();
      String cTry00000041msg;
      cTry00000041msg = m_Sql.TransactionErrorMessage();
      try {
        // * --- Fill memory cursor mcWersonbo on wersonbo
        mcWersonbo.Zap();
        m_cServer = m_Ctx.GetServer("wersonbo");
        m_cPhName = m_Ctx.GetPhName("wersonbo");
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
        Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"datamodi="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Date(),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Date())+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        {
          final CPResultSet m_TheCursor = Cursor_wersonbo;
          Cursor_wersonbo.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arfn_import_correzioni_sv_all: query on wersonbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_wersonbo.Eof())) {
          mcWersonbo.AppendWithTrimmedKey(Cursor_wersonbo.GetString("CONNES"));
          mcWersonbo.row.connes = "";
          Cursor_wersonbo.Next();
        }
        m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
        Cursor_wersonbo.Close();
        mcWersonbo.GoTop();
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
                  info.log("Routine arfn_import_correzioni_sv_all: query on tbstati returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
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
        // * --- Fill memory cursor mcSettori on qbe_setsin
        mcSettori.Zap();
        if (Cursor_qbe_setsin!=null)
          Cursor_qbe_setsin.Close();
        Cursor_qbe_setsin = new VQRHolder("qbe_setsin",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        {
          final CPResultSet m_TheCursor = Cursor_qbe_setsin;
          Cursor_qbe_setsin.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arfn_import_correzioni_sv_all: query on qbe_setsin returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_qbe_setsin.Eof())) {
          mcSettori.AppendBlank();
          mcSettori.row.SETSINT = Cursor_qbe_setsin.GetString("SETSINT");
          mcSettori.row.DESCRI = Cursor_qbe_setsin.GetString("DESCRI");
          mcSettori.row.DATAINI = Cursor_qbe_setsin.GetDate("DATAINI");
          mcSettori.row.DATAFINE = Cursor_qbe_setsin.GetDate("DATAFINE");
          mcSettori.row.DAGRU1 = Cursor_qbe_setsin.GetString("DAGRU1");
          mcSettori.row.AGRU1 = Cursor_qbe_setsin.GetString("AGRU1");
          mcSettori.row.DAGRU2 = Cursor_qbe_setsin.GetString("DAGRU2");
          mcSettori.row.AGRU2 = Cursor_qbe_setsin.GetString("AGRU2");
          mcSettori.row.DAGRU3 = Cursor_qbe_setsin.GetString("DAGRU3");
          mcSettori.row.AGRU3 = Cursor_qbe_setsin.GetString("AGRU3");
          mcSettori.row.DAGRU4 = Cursor_qbe_setsin.GetString("DAGRU4");
          mcSettori.row.AGRU4 = Cursor_qbe_setsin.GetString("AGRU4");
          mcSettori.row.DAGRU5 = Cursor_qbe_setsin.GetString("DAGRU5");
          mcSettori.row.AGRU5 = Cursor_qbe_setsin.GetString("AGRU5");
          mcSettori.row.DAGRU6 = Cursor_qbe_setsin.GetString("DAGRU6");
          mcSettori.row.AGRU6 = Cursor_qbe_setsin.GetString("AGRU6");
          mcSettori.row.DASOT1 = Cursor_qbe_setsin.GetString("DASOT1");
          mcSettori.row.ASOT1 = Cursor_qbe_setsin.GetString("ASOT1");
          mcSettori.row.DASOT2 = Cursor_qbe_setsin.GetString("DASOT2");
          mcSettori.row.ASOT2 = Cursor_qbe_setsin.GetString("ASOT2");
          mcSettori.row.DASOT3 = Cursor_qbe_setsin.GetString("DASOT3");
          mcSettori.row.ASOT3 = Cursor_qbe_setsin.GetString("ASOT3");
          mcSettori.row.DASOT4 = Cursor_qbe_setsin.GetString("DASOT4");
          mcSettori.row.ASOT4 = Cursor_qbe_setsin.GetString("ASOT4");
          mcSettori.row.DASOT5 = Cursor_qbe_setsin.GetString("DASOT5");
          mcSettori.row.ASOT5 = Cursor_qbe_setsin.GetString("ASOT5");
          mcSettori.row.DASOT6 = Cursor_qbe_setsin.GetString("DASOT6");
          mcSettori.row.ASOT6 = Cursor_qbe_setsin.GetString("ASOT6");
          mcSettori.row.DASOT7 = Cursor_qbe_setsin.GetString("DASOT7");
          mcSettori.row.ASOT7 = Cursor_qbe_setsin.GetString("ASOT7");
          mcSettori.row.DASOT8 = Cursor_qbe_setsin.GetString("DASOT8");
          mcSettori.row.ASOT8 = Cursor_qbe_setsin.GetString("ASOT8");
          mcSettori.row.DASOT9 = Cursor_qbe_setsin.GetString("DASOT9");
          mcSettori.row.ASOT9 = Cursor_qbe_setsin.GetString("ASOT9");
          mcSettori.row.DASOT10 = Cursor_qbe_setsin.GetString("DASOT10");
          mcSettori.row.ASOT10 = Cursor_qbe_setsin.GetString("ASOT10");
          mcSettori.row.DASOT11 = Cursor_qbe_setsin.GetString("DASOT11");
          mcSettori.row.ASOT11 = Cursor_qbe_setsin.GetString("ASOT11");
          mcSettori.row.DASOT12 = Cursor_qbe_setsin.GetString("DASOT12");
          mcSettori.row.ASOT12 = Cursor_qbe_setsin.GetString("ASOT12");
          mcSettori.row.DAATE1 = Cursor_qbe_setsin.GetString("DAATE1");
          mcSettori.row.AATE1 = Cursor_qbe_setsin.GetString("AATE1");
          mcSettori.row.DAATE2 = Cursor_qbe_setsin.GetString("DAATE2");
          mcSettori.row.AATE2 = Cursor_qbe_setsin.GetString("AATE2");
          mcSettori.row.DAATE3 = Cursor_qbe_setsin.GetString("DAATE3");
          mcSettori.row.AATE3 = Cursor_qbe_setsin.GetString("AATE3");
          mcSettori.row.DAATE4 = Cursor_qbe_setsin.GetString("DAATE4");
          mcSettori.row.AATE4 = Cursor_qbe_setsin.GetString("AATE4");
          mcSettori.row.DAATE5 = Cursor_qbe_setsin.GetString("DAATE5");
          mcSettori.row.AATE5 = Cursor_qbe_setsin.GetString("AATE5");
          mcSettori.row.DAATE6 = Cursor_qbe_setsin.GetString("DAATE6");
          mcSettori.row.AATE6 = Cursor_qbe_setsin.GetString("AATE6");
          mcSettori.row.IDSETSIN = Cursor_qbe_setsin.GetDouble("IDSETSIN");
          Cursor_qbe_setsin.Next();
        }
        m_cConnectivityError = Cursor_qbe_setsin.ErrorMessage();
        Cursor_qbe_setsin.Close();
        mcSettori.GoTop();
        // * --- Fill memory cursor mcSetSina on tbsetsina
        mcSetSina.Zap();
        m_cServer = m_Ctx.GetServer("tbsetsina");
        m_cPhName = m_Ctx.GetPhName("tbsetsina");
        if (Cursor_tbsetsina!=null)
          Cursor_tbsetsina.Close();
        Cursor_tbsetsina = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbsetsina")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        {
          final CPResultSet m_TheCursor = Cursor_tbsetsina;
          Cursor_tbsetsina.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arfn_import_correzioni_sv_all: query on tbsetsina returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_tbsetsina.Eof())) {
          mcSetSina.AppendWithTrimmedKey(Cursor_tbsetsina.GetString("CODATECO"));
          mcSetSina.row.IDSETSIN = Cursor_tbsetsina.GetDouble("IDSETSIN");
          mcSetSina.row.SETSINT = Cursor_tbsetsina.GetString("SETSINT");
          mcSetSina.row.CODATECO = Cursor_tbsetsina.GetString("CODATECO");
          Cursor_tbsetsina.Next();
        }
        m_cConnectivityError = Cursor_tbsetsina.ErrorMessage();
        Cursor_tbsetsina.Close();
        mcSetSina.GoTop();
        //base
        InputStream ExcelFileToRead = new FileInputStream(CPLib.LRTrim(gPathDoc)+"/appo/"+CPLib.LRTrim(gAzienda)+'/'+CPLib.LRTrim(nomefile));
        XSSFWorkbook  workbook = new XSSFWorkbook(ExcelFileToRead);
        //Workbook workbook = Workbook.getWorkbook(new File(CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(w_nomefile)));
        Cell cell;
        int cellType;
        String[] colonna = new String[30];
        _i=0;
        riga_letta=0;
        Sheet sheet = workbook.getSheetAt(0);
        for (Row row : sheet) {
          if (row == null) {
                 // This row is completely empty
            } else {
        /* riga_letta := riga_letta+1 // riga letta del file Excel */
        riga_letta = CPLib.Round(riga_letta+1,0);
        /* gMsgImp := 'Elaboro riga Excel numero: '+ LRTrim(Str(riga_letta,10,0)) // Messaggio Import */
        gMsgImp = "Elaboro riga Excel numero: "+CPLib.LRTrim(CPLib.Str(riga_letta,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If riga_letta > 1 */
        if (CPLib.gt(riga_letta,1)) {
          //scorro le colonne
          cell_count=0;
          /* While cell_count < 29 */
          while (CPLib.lt(cell_count,29)) {
            //scorro le celle della riga
            cell = row.getCell(cell_count);
            if (cell != null) {
            //  _tipocol = cell.getCellType();
              cellType = cell.getCellType().ordinal();
              switch (cellType) {
                case 1:
                  colonna[cell_count]=String.valueOf((int)cell.getNumericCellValue());
                  break;
                case 2:
                  colonna[cell_count]=cell.getStringCellValue();       
                  break;
                default:
                  colonna[cell_count]=cell.getStringCellValue();       
               }
            } else {
              colonna[cell_count]="";
            }
            ++cell_count;
          } // End While
          /* _contar := _contar + 1 */
          _contar = CPLib.Round(_contar+1,0);
          /* gMsgImp := 'Aggiorno operazione con progressivo='+ LRTrim(colonna[0]) + " - Riga "+LRTrim(Str(riga_letta,10,0)) // Messaggio Import */
          gMsgImp = "Aggiorno operazione con progressivo="+CPLib.LRTrim(colonna[0])+" - Riga "+CPLib.LRTrim(CPLib.Str(riga_letta,10,0));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Write into analisi_sv from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("analisi_sv");
          m_cPhName = m_Ctx.GetPhName("analisi_sv");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"analisi_sv",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arfn_import_correzioni_sv_all",86,"00000050")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"SEGNO = "+CPLib.ToSQL(CPLib.LRTrim(colonna[2]),"C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"CODDIPE = "+CPLib.ToSQL(CPLib.LRTrim(colonna[3]),"C",6,0,m_cServer)+", ";
          m_cSql = m_cSql+"DESCRIZ = "+CPLib.ToSQL(CPLib.LRTrim(colonna[4]),"C",30,0,m_cServer)+", ";
          m_cSql = m_cSql+"PROVINCIA1 = "+CPLib.ToSQL(CPLib.LRTrim(colonna[5]),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"TIPOSV = "+CPLib.ToSQL(CPLib.LRTrim(colonna[6]),"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(CPLib.LRTrim(colonna[7]),"C",16,0,m_cServer)+", ";
          m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.LRTrim(colonna[8]),"C",70,0,m_cServer)+", ";
          m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(CPLib.LRTrim(colonna[9]),"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(CPLib.LRTrim(colonna[10]),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(CPLib.LRTrim(colonna[12]),"C",3,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"analisi_sv",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"TIPO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(colonna[13]),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(colonna[13]))+"";
          m_cSql = m_cSql+" and NUMPROG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(colonna[0]),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(colonna[0]))+"";
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
          /* If colonna[29]='P' and (not(Empty(colonna[22])) or not(Empty(colonna[25]))) */
          if (CPLib.eqr(colonna[29],"P") && ( ! (CPLib.Empty(colonna[22])) ||  ! (CPLib.Empty(colonna[25])))) {
            /* If not(mcWersonbo.HasKey(colonna[7])) */
            if ( ! (mcWersonbo.HasKey(colonna[7]))) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LTrim(colonna[7]),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.LTrim(colonna[7]))+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              {
                final CPResultSet m_TheCursor = Cursor_personbo;
                Cursor_personbo.ActionOnClose(new Runnable() {
                  public void run() {
                    if (CPLib.gt(m_TheCursor.CurrentRow()-1,1*1.1)) {
                      com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                      if ( ! (CPLib.IsNull(info))) {
                        info.log("Routine arfn_import_correzioni_sv_all: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1");
                      }
                    }
                  }
                  });
              }
              while ( ! (Cursor_personbo.Eof())) {
                /* If personbo->PROVINCIA<>LRTrim(colonna[10]) or personbo->SOTGRUP <> LRTrim(colonna[9]) or personbo->PAESE<>LRTrim(colonna[20]) or personbo->DESCCIT<>LRTrim(colonna[18]) */
                if (CPLib.ne(Cursor_personbo.GetString("PROVINCIA"),CPLib.LRTrim(colonna[10])) || CPLib.ne(Cursor_personbo.GetString("SOTGRUP"),CPLib.LRTrim(colonna[9])) || CPLib.ne(Cursor_personbo.GetString("PAESE"),CPLib.LRTrim(colonna[20])) || CPLib.ne(Cursor_personbo.GetString("DESCCIT"),CPLib.LRTrim(colonna[18]))) {
                  /* _ateco := personbo->ATTIV */
                  _ateco = Cursor_personbo.GetString("ATTIV");
                  /* _ramo := personbo->RAMOGRUP */
                  _ramo = Cursor_personbo.GetString("RAMOGRUP");
                  /* _stgrup := LRTrim(colonna[9]) */
                  _stgrup = CPLib.LRTrim(colonna[9]);
                  /* _settsint := '' */
                  _settsint = "";
                  /* Exec "Settori Sintetici" Page 2:Page_2 */
                  Page_2();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                  /* cProgSto := Utilities.GetAutonumber("PSTOPERS\'"+LRTrim(gAzienda)+"'","",15) */
                  cProgSto = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PSTOPERS\\'"+CPLib.LRTrim(gAzienda)+"'","",15);
                  // * --- Insert into wersonbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("wersonbo");
                  m_cPhName = m_Ctx.GetPhName("wersonbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arfn_import_correzioni_sv_all",86,"0000005B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_0000005B(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cProgSto,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAVALI"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("CFESTERO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("OLDCONNES"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATEXTRA"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PKTBSPECIE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("COMPORT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RNATGIU"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RATTIV"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RCOMP"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RAREA"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("ALLINEATO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("ALLINEATONOMECNOME"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOCOLD"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("PROGIMPORT"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROGIMP_C"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PEP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("OLDCODFISC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("MACROAGENTE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SPOTID"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATASEGN"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("OLDSETSIN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wersonbo",true);
                  m_cSql = m_cSql+")";
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
                  // * --- Write into personbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arfn_import_correzioni_sv_all",86,"0000005C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(CPLib.LRTrim(colonna[10]),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(CPLib.LRTrim(colonna[9]),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(_settsint,"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(CPLib.LRTrim(colonna[20]),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.LRTrim(colonna[18]),"C",30,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer),m_cServer,Cursor_personbo.GetString("CONNES"))+"";
                  m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  {
                    if (CPLib.gt(m_nUpdatedRows,1*1.1)) {
                      com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                      if ( ! (CPLib.IsNull(info))) {
                        info.log("Routine arfn_import_correzioni_sv_all: Write on personbo updates "+(m_nUpdatedRows)+" rows larger then the expected 1");
                      }
                    }
                  }
                  if (CPLib.lt(m_nUpdatedRows,0)) {
                    m_Sql.AbortTransaction();
                  }
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                    throw new RoutineException();
                  }
                  /* mcWersonbo.AppendWithKey(colonna[7]) */
                  mcWersonbo.AppendWithKey(colonna[7]);
                  /* mcWersonbo.connes := colonna[7] */
                  mcWersonbo.row.connes = colonna[7];
                  /* mcWersonbo.SaveRow() */
                  mcWersonbo.SaveRow();
                } // End If
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
            } else { // Else
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LTrim(colonna[7]),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.LTrim(colonna[7]))+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              {
                final CPResultSet m_TheCursor = Cursor_personbo;
                Cursor_personbo.ActionOnClose(new Runnable() {
                  public void run() {
                    if (CPLib.gt(m_TheCursor.CurrentRow()-1,1*1.1)) {
                      com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                      if ( ! (CPLib.IsNull(info))) {
                        info.log("Routine arfn_import_correzioni_sv_all: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1");
                      }
                    }
                  }
                  });
              }
              while ( ! (Cursor_personbo.Eof())) {
                /* If personbo->PROVINCIA<>LRTrim(colonna[10]) or personbo->SOTGRUP <> LRTrim(colonna[9]) or personbo->PAESE<>LRTrim(colonna[20]) or personbo->DESCCIT<>LRTrim(colonna[18]) */
                if (CPLib.ne(Cursor_personbo.GetString("PROVINCIA"),CPLib.LRTrim(colonna[10])) || CPLib.ne(Cursor_personbo.GetString("SOTGRUP"),CPLib.LRTrim(colonna[9])) || CPLib.ne(Cursor_personbo.GetString("PAESE"),CPLib.LRTrim(colonna[20])) || CPLib.ne(Cursor_personbo.GetString("DESCCIT"),CPLib.LRTrim(colonna[18]))) {
                  /* _ateco := personbo->ATTIV */
                  _ateco = Cursor_personbo.GetString("ATTIV");
                  /* _ramo := personbo->RAMOGRUP */
                  _ramo = Cursor_personbo.GetString("RAMOGRUP");
                  /* _stgrup := LRTrim(colonna[9]) */
                  _stgrup = CPLib.LRTrim(colonna[9]);
                  /* _settsint := '' */
                  _settsint = "";
                  /* Exec "Settori Sintetici" Page 2:Page_2 */
                  Page_2();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                  // * --- Write into personbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arfn_import_correzioni_sv_all",86,"00000067")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(CPLib.LRTrim(colonna[10]),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(CPLib.LRTrim(colonna[9]),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(_settsint,"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(CPLib.LRTrim(colonna[20]),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.LRTrim(colonna[18]),"C",30,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer),m_cServer,Cursor_personbo.GetString("CONNES"))+"";
                  m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  {
                    if (CPLib.gt(m_nUpdatedRows,1*1.1)) {
                      com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                      if ( ! (CPLib.IsNull(info))) {
                        info.log("Routine arfn_import_correzioni_sv_all: Write on personbo updates "+(m_nUpdatedRows)+" rows larger then the expected 1");
                      }
                    }
                  }
                  if (CPLib.lt(m_nUpdatedRows,0)) {
                    m_Sql.AbortTransaction();
                  }
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                    throw new RoutineException();
                  }
                } // End If
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
            } // End If
          } // End If
          /* conta := conta + 1 */
          conta = conta+1;
        } // End If
        // Chiude i cicli
          }
        }
        workbook.close();
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        /* _cRitorno := 'OK' */
        _cRitorno = "OK";
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
        /* _cRitorno := 'KO' */
        _cRitorno = "KO";
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000041status,0)) {
          m_Sql.SetTransactionStatus(nTry00000041status,cTry00000041msg);
        }
      }
      /* gMsgImp := 'Elaborazione terminata!' // Messaggio Import */
      gMsgImp = "Elaborazione terminata!";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + nomefile + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefile+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Return _cRitorno */
      throw new Stop(_cRitorno);
    } finally {
      try {
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
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
      try {
        if (Cursor_qbe_setsin!=null)
          Cursor_qbe_setsin.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tbsetsina!=null)
          Cursor_tbsetsina.Close();
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
    }
  }
  void Page_2() throws Exception {
    /* Variabili Locali */
    /* _NewRamo Char(3) */
    String _NewRamo;
    _NewRamo = CPLib.Space(3);
    /* _ateco_loc Char(3) */
    String _ateco_loc;
    _ateco_loc = CPLib.Space(3);
    /* _oksotgru Numeric(1, 0) */
    double _oksotgru;
    _oksotgru = 0;
    /* _okramatt Numeric(1, 0) */
    double _okramatt;
    _okramatt = 0;
    /* _okateco Numeric(1, 0) */
    double _okateco;
    _okateco = 0;
    /* Verifica se presente codice Ateco */
    /* If Empty(LRTrim(_ateco)) or LRTrim(_ateco) = '0' */
    if (CPLib.Empty(CPLib.LRTrim(_ateco)) || CPLib.eqr(CPLib.LRTrim(_ateco),"0")) {
      /* _ateco_loc := '' */
      _ateco_loc = "";
    } // End If
    /* If not(Empty(_ateco)) and Len(LRTrim(_ateco)) > 3 */
    if ( ! (CPLib.Empty(_ateco)) && CPLib.gt(CPLib.Len(CPLib.LRTrim(_ateco)),3)) {
      /* _ateco_loc := Left(LRTrim(_ateco),3) */
      _ateco_loc = CPLib.Left(CPLib.LRTrim(_ateco),3);
    } // End If
    /* If Date() < CharToDate('20100801') */
    if (CPLib.lt(CPLib.Date(),CPLib.CharToDate("20100801"))) {
      /* _ateco_loc := '' */
      _ateco_loc = "";
    } // End If
    /* If not(Empty(_ateco)) and (_ateco='970' or _ateco='981' or _ateco='982' or _ateco='990' or _ateco='P00') */
    if ( ! (CPLib.Empty(_ateco)) && (CPLib.eqr(_ateco,"970") || CPLib.eqr(_ateco,"981") || CPLib.eqr(_ateco,"982") || CPLib.eqr(_ateco,"990") || CPLib.eqr(_ateco,"P00"))) {
      /* _ateco_loc := '' */
      _ateco_loc = "";
    } // End If
    /* Controlla i valori del sottogruppo e del ramo */
    /* _NewRamo := iif(Empty(_ramo),'???',_ramo) */
    _NewRamo = (CPLib.Empty(_ramo)?"???":_ramo);
    for (MemoryCursorRow_qbe_setsin_vqr rowSet : mcSettori._iterable_()) {
      /* _okramatt := 0 */
      _okramatt = CPLib.Round(0,0);
      /* _oksotgru := 0 */
      _oksotgru = CPLib.Round(0,0);
      /* _okateco := 0 */
      _okateco = CPLib.Round(0,0);
      /* If _stgrup >= rowSet.DASOT1 and _stgrup <= rowSet.ASOT1 */
      if (CPLib.ge(_stgrup,rowSet.DASOT1) && CPLib.le(_stgrup,rowSet.ASOT1)) {
        /* _oksotgru := 1 */
        _oksotgru = CPLib.Round(1,0);
      } // End If
      /* If _stgrup >= rowSet.DASOT2 and _stgrup <= rowSet.ASOT2 */
      if (CPLib.ge(_stgrup,rowSet.DASOT2) && CPLib.le(_stgrup,rowSet.ASOT2)) {
        /* _oksotgru := 1 */
        _oksotgru = CPLib.Round(1,0);
      } // End If
      /* If _stgrup >= rowSet.DASOT3 and _stgrup <= rowSet.ASOT3 */
      if (CPLib.ge(_stgrup,rowSet.DASOT3) && CPLib.le(_stgrup,rowSet.ASOT3)) {
        /* _oksotgru := 1 */
        _oksotgru = CPLib.Round(1,0);
      } // End If
      /* If _stgrup >= rowSet.DASOT4 and _stgrup <= rowSet.ASOT4 */
      if (CPLib.ge(_stgrup,rowSet.DASOT4) && CPLib.le(_stgrup,rowSet.ASOT4)) {
        /* _oksotgru := 1 */
        _oksotgru = CPLib.Round(1,0);
      } // End If
      /* If _stgrup >= rowSet.DASOT5 and _stgrup <= rowSet.ASOT5 */
      if (CPLib.ge(_stgrup,rowSet.DASOT5) && CPLib.le(_stgrup,rowSet.ASOT5)) {
        /* _oksotgru := 1 */
        _oksotgru = CPLib.Round(1,0);
      } // End If
      /* If _stgrup >= rowSet.DASOT6 and _stgrup <= rowSet.ASOT6 */
      if (CPLib.ge(_stgrup,rowSet.DASOT6) && CPLib.le(_stgrup,rowSet.ASOT6)) {
        /* _oksotgru := 1 */
        _oksotgru = CPLib.Round(1,0);
      } // End If
      /* If _stgrup >= rowSet.DASOT7 and _stgrup <= rowSet.ASOT7 */
      if (CPLib.ge(_stgrup,rowSet.DASOT7) && CPLib.le(_stgrup,rowSet.ASOT7)) {
        /* _oksotgru := 1 */
        _oksotgru = CPLib.Round(1,0);
      } // End If
      /* If _stgrup >= rowSet.DASOT8 and _stgrup <= rowSet.ASOT8 */
      if (CPLib.ge(_stgrup,rowSet.DASOT8) && CPLib.le(_stgrup,rowSet.ASOT8)) {
        /* _oksotgru := 1 */
        _oksotgru = CPLib.Round(1,0);
      } // End If
      /* If _stgrup >= rowSet.DASOT9 and _stgrup <= rowSet.ASOT9 */
      if (CPLib.ge(_stgrup,rowSet.DASOT9) && CPLib.le(_stgrup,rowSet.ASOT9)) {
        /* _oksotgru := 1 */
        _oksotgru = CPLib.Round(1,0);
      } // End If
      /* If _stgrup >= rowSet.DASOT10 and _stgrup <= rowSet.ASOT10 */
      if (CPLib.ge(_stgrup,rowSet.DASOT10) && CPLib.le(_stgrup,rowSet.ASOT10)) {
        /* _oksotgru := 1 */
        _oksotgru = CPLib.Round(1,0);
      } // End If
      /* If _stgrup >= rowSet.DASOT11 and _stgrup <= rowSet.ASOT11 */
      if (CPLib.ge(_stgrup,rowSet.DASOT11) && CPLib.le(_stgrup,rowSet.ASOT11)) {
        /* _oksotgru := 1 */
        _oksotgru = CPLib.Round(1,0);
      } // End If
      /* If _stgrup >= rowSet.DASOT12 and _stgrup <= rowSet.ASOT12 */
      if (CPLib.ge(_stgrup,rowSet.DASOT12) && CPLib.le(_stgrup,rowSet.ASOT12)) {
        /* _oksotgru := 1 */
        _oksotgru = CPLib.Round(1,0);
      } // End If
      /* If _NewRamo = '???' */
      if (CPLib.eqr(_NewRamo,"???")) {
        /* _okramatt := 1 */
        _okramatt = CPLib.Round(1,0);
      } else { // Else
        /* If Empty(LRTrim(_ateco)) */
        if (CPLib.Empty(CPLib.LRTrim(_ateco))) {
          /* If _NewRamo >= rowSet.DAGRU1 and _NewRamo <= rowSet.AGRU1 */
          if (CPLib.ge(_NewRamo,rowSet.DAGRU1) && CPLib.le(_NewRamo,rowSet.AGRU1)) {
            /* _okramatt := 1 */
            _okramatt = CPLib.Round(1,0);
          } // End If
          /* If _NewRamo >= rowSet.DAGRU2 and _NewRamo <= rowSet.AGRU2 */
          if (CPLib.ge(_NewRamo,rowSet.DAGRU2) && CPLib.le(_NewRamo,rowSet.AGRU2)) {
            /* _okramatt := 1 */
            _okramatt = CPLib.Round(1,0);
          } // End If
          /* If _NewRamo >= rowSet.DAGRU3 and _NewRamo <= rowSet.AGRU3 */
          if (CPLib.ge(_NewRamo,rowSet.DAGRU3) && CPLib.le(_NewRamo,rowSet.AGRU3)) {
            /* _okramatt := 1 */
            _okramatt = CPLib.Round(1,0);
          } // End If
          /* If _NewRamo >= rowSet.DAGRU4 and _NewRamo <= rowSet.AGRU4 */
          if (CPLib.ge(_NewRamo,rowSet.DAGRU4) && CPLib.le(_NewRamo,rowSet.AGRU4)) {
            /* _okramatt := 1 */
            _okramatt = CPLib.Round(1,0);
          } // End If
          /* If _NewRamo >= rowSet.DAGRU5 and _NewRamo <= rowSet.AGRU5 */
          if (CPLib.ge(_NewRamo,rowSet.DAGRU5) && CPLib.le(_NewRamo,rowSet.AGRU5)) {
            /* _okramatt := 1 */
            _okramatt = CPLib.Round(1,0);
          } // End If
          /* If _NewRamo >= rowSet.DAGRU6 and _NewRamo <= rowSet.AGRU6 */
          if (CPLib.ge(_NewRamo,rowSet.DAGRU6) && CPLib.le(_NewRamo,rowSet.AGRU6)) {
            /* _okramatt := 1 */
            _okramatt = CPLib.Round(1,0);
          } // End If
          /* If _NewRamo >= 'NUL' */
          if (CPLib.ge(_NewRamo,"NUL")) {
            /* _okramatt := 1 */
            _okramatt = CPLib.Round(1,0);
          } // End If
        } else { // Else
          for (MemoryCursorRow_tbsetsina rowSina : mcSetSina._iterable_()) {
            if (CPLib.eqr(mcSetSina.row.IDSETSIN,rowSet.IDSETSIN)) {
              /* If _ateco_loc=rowSina.CODATECO */
              if (CPLib.eqr(_ateco_loc,rowSina.CODATECO)) {
                /* _okateco := 1 */
                _okateco = CPLib.Round(1,0);
              } // End If
            }
          }
        } // End If
      } // End If
      /* If (_okramatt = 1 or _okateco=1) and _oksotgru = 1 */
      if ((CPLib.eqr(_okramatt,1) || CPLib.eqr(_okateco,1)) && CPLib.eqr(_oksotgru,1)) {
        /* _settsint := rowSet.SETSINT */
        _settsint = rowSet.SETSINT;
      } // End If
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_nomefile) {
    nomefile = p_nomefile;
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
  public String Run(String p_nomefile) {
    nomefile = p_nomefile;
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
          Page_1();
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
  public static arfn_import_correzioni_sv_allR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_import_correzioni_sv_allR(p_Ctx, p_Caller);
  }
  public static arfn_import_correzioni_sv_allR Make(CPContext p_Ctx) {
    return new arfn_import_correzioni_sv_allR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    nomefile = CPLib.Space(30);
    riga_letta = 0;
    foglio = 0;
    cell_type = 0;
    _cRitorno = CPLib.Space(2);
    _contar = 0;
    _stgrup = CPLib.Space(3);
    _ateco = CPLib.Space(10);
    _ramo = CPLib.Space(3);
    _settsint = CPLib.Space(3);
    mcStati = new MemoryCursor_tbstati();
    mcWersonbo = new MemoryCursor_mcconnes_mcrdef();
    mcSettori = new MemoryCursor_qbe_setsin_vqr();
    mcSetSina = new MemoryCursor_tbsetsina();
    cProgSto = CPLib.Space(15);
    column01 = CPLib.Space(100);
    column02 = CPLib.Space(100);
    column03 = CPLib.Space(100);
    column04 = CPLib.Space(100);
    column05 = CPLib.Space(100);
    column06 = CPLib.Space(100);
    column07 = CPLib.Space(100);
    column08 = CPLib.Space(100);
    column09 = CPLib.Space(100);
    column10 = CPLib.Space(100);
    column11 = CPLib.Space(100);
    column12 = CPLib.Space(100);
    column13 = CPLib.Space(100);
    column14 = CPLib.Space(100);
    column15 = CPLib.Space(100);
    column16 = CPLib.Space(100);
    column17 = CPLib.Space(100);
    column18 = CPLib.Space(100);
    column19 = CPLib.Space(100);
    column20 = CPLib.Space(100);
    column21 = CPLib.Space(100);
    column22 = CPLib.Space(100);
    column23 = CPLib.Space(100);
    column24 = CPLib.Space(100);
    column25 = CPLib.Space(100);
    column26 = CPLib.Space(100);
    column27 = CPLib.Space(100);
    column28 = CPLib.Space(100);
    column29 = CPLib.Space(100);
    column30 = CPLib.Space(100);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
    gDataVaria=m_Ctx.GetGlobalDate("gDataVaria");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_setsin,
  public static final String m_cVQRList = ",qbe_setsin,";
  // ENTITY_BATCHES: ,arfn_fdatetime,arfn_import_correzioni_sv_all,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,arfn_import_correzioni_sv_all,";
  public static String[] m_cRunParameterNames={"nomefile"};
  protected static String GetFieldsName_0000005B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"sanumpro,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPINTER,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"PARTIVA,";
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"SOSPMAF,";
    p_cSql = p_cSql+"idcitta,";
    p_cSql = p_cSql+"datamodi,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+"OLDCONNES,";
    p_cSql = p_cSql+"DATEXTRA,";
    p_cSql = p_cSql+"PKTBSPECIE,";
    p_cSql = p_cSql+"COMPORT,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"RNATGIU,";
    p_cSql = p_cSql+"RATTIV,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"ALLINEATO,";
    p_cSql = p_cSql+"ALLINEATONOMECNOME,";
    p_cSql = p_cSql+"RAGSOCOLD,";
    p_cSql = p_cSql+"PROGIMPORT,";
    p_cSql = p_cSql+"PROGIMP_C,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"PEP,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"OLDCODFISC,";
    p_cSql = p_cSql+"MACROAGENTE,";
    p_cSql = p_cSql+"SPOTID,";
    p_cSql = p_cSql+"DATASEGN,";
    p_cSql = p_cSql+"OLDSETSIN,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wersonbo",true);
    return p_cSql;
  }
}
