// * --- Area Manuale = BO - Header
// * --- arrt_import_correzioni_sv
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

import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.*;
import com.monitorjbl.xlsx.StreamingReader;

/*
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.streaming.SXSSFWorkbook;
import org.apache.poi.hssf.streaming.SHSSFSheet;
import org.apache.poi.hssf.streaming.SHSSFCell;
import org.apache.poi.hssf.streaming.SHSSFRow;
import org.apache.poi.hssf.streaming.SHSSFSheet;
import org.apache.poi.hssf.streaming.SHSSFWorkbook;
*/
// * --- Fine Area Manuale
public class arrt_import_correzioni_svR implements CallerWithObjs {
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
  // I messaggi vengono instradati su questo oggetto
  public CPMessageSink m_MessageSink;
  public com.zucchetti.sitepainter.Logger m_Debug;
  public com.zucchetti.sitepainter.Logger m_Info;
  public com.zucchetti.sitepainter.Logger m_Warning;
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
  public String m_cPhName_tbsetsina;
  public String m_cServer_tbsetsina;
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
  public String gAzienda;
  public String gPathApp;
  public String gMsgProc;
  public String gMsgImp;
  public String column01;
  public String column02;
  public double column02num;
  public java.sql.Date column02date;
  public String column03;
  public String column04;
  public String column05;
  public String column06;
  public String column07;
  public String column08;
  public String column09;
  public String column10;
  public String column11;
  public double column12num;
  public String column13;
  public String column14;
  public String column15;
  public String column16;
  public String column17;
  public String column18;
  public boolean _commit;
  public boolean _falied;
  public double riga_letta;
  public String riga_letta_c;
  public java.sql.Date date_base_excel;
  public double ncol;
  public double foglio;
  public String foglio_c;
  public String cProgSto;
  public java.sql.Date w_DATARETT;
  public String cCanc;
  public String cProg;
  public String _progrig;
  public MemoryCursor_mcdatistru_mcrdef mcDati;
  public MemoryCursor_mcconnes_mcrdef mcWersonbo;
  public MemoryCursor_qbe_setsin_vqr mcSettori;
  public MemoryCursor_tbsetsina mcSetSina;
  public String _idbase;
  public String _statoreg;
  public String cNewProg;
  public String _idereg;
  public String _idbase2;
  public String _cab;
  public String stringaflagrap2;
  public String _flagrap2;
  public String _desccit;
  public String _numprog;
  public String _stgrup;
  public double cell_type;
  public String nota;
  public boolean modifica;
  public String _idbase_ang;
  public String _connes;
  public String _ragsoc;
  public String _cf;
  public String _ateco;
  public String _ramo;
  public String _settsint;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_import_correzioni_sv
  public int _i;
  public int _y;
  public int _righe;
  public int conta;
  public int r;
  String sheetName = "Sheet1";
  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
  public int _conta;
  public String[] lista;
  public String[] campi;
  public String[] colonna;
  public int conteggio;
  public int i;
  public int contanome;
  public int nfogli;
  public int ncampi;
  public int cell_count;
  // * --- Fine Area Manuale
  public arrt_import_correzioni_svR (CPContext p_ContextObject, Caller caller) {
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
    // I messaggi vengono instradati su questo oggetto
    m_MessageSink = CPMessageSink.ConsoleSink;
    m_Debug = com.zucchetti.sitepainter.Logger.getDebugLogger();
    m_Info = com.zucchetti.sitepainter.Logger.getInfoLogger();
    m_Warning = com.zucchetti.sitepainter.Logger.getWarningLogger();
    p_ContextObject = p_ContextObject.DisabledDataFilteringVersion();
    CPSecurity.RoutineCallableByProgram("arrt_import_correzioni_sv",m_Caller);
    m_cPhName_fraziobo = p_ContextObject.GetPhName("fraziobo");
    if (m_cPhName_fraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fraziobo = m_cPhName_fraziobo+" "+m_Ctx.GetWritePhName("fraziobo");
    }
    m_cServer_fraziobo = p_ContextObject.GetServer("fraziobo");
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    if (m_cPhName_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo = m_cPhName_operazbo+" "+m_Ctx.GetWritePhName("operazbo");
    }
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_wersonbo = p_ContextObject.GetPhName("wersonbo");
    if (m_cPhName_wersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo = m_cPhName_wersonbo+" "+m_Ctx.GetWritePhName("wersonbo");
    }
    m_cServer_wersonbo = p_ContextObject.GetServer("wersonbo");
    m_cPhName_tbsetsina = p_ContextObject.GetPhName("tbsetsina");
    if (m_cPhName_tbsetsina.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbsetsina = m_cPhName_tbsetsina+" "+m_Ctx.GetWritePhName("tbsetsina");
    }
    m_cServer_tbsetsina = p_ContextObject.GetServer("tbsetsina");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("column02num",p_cVarName)) {
      return column02num;
    }
    if (CPLib.eqr("column12num",p_cVarName)) {
      return column12num;
    }
    if (CPLib.eqr("riga_letta",p_cVarName)) {
      return riga_letta;
    }
    if (CPLib.eqr("ncol",p_cVarName)) {
      return ncol;
    }
    if (CPLib.eqr("foglio",p_cVarName)) {
      return foglio;
    }
    if (CPLib.eqr("cell_type",p_cVarName)) {
      return cell_type;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_import_correzioni_sv";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      return nomefile;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
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
    if (CPLib.eqr("riga_letta_c",p_cVarName)) {
      return riga_letta_c;
    }
    if (CPLib.eqr("foglio_c",p_cVarName)) {
      return foglio_c;
    }
    if (CPLib.eqr("cProgSto",p_cVarName)) {
      return cProgSto;
    }
    if (CPLib.eqr("cCanc",p_cVarName)) {
      return cCanc;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      return cProg;
    }
    if (CPLib.eqr("_progrig",p_cVarName)) {
      return _progrig;
    }
    if (CPLib.eqr("_idbase",p_cVarName)) {
      return _idbase;
    }
    if (CPLib.eqr("_statoreg",p_cVarName)) {
      return _statoreg;
    }
    if (CPLib.eqr("cNewProg",p_cVarName)) {
      return cNewProg;
    }
    if (CPLib.eqr("_idereg",p_cVarName)) {
      return _idereg;
    }
    if (CPLib.eqr("_idbase2",p_cVarName)) {
      return _idbase2;
    }
    if (CPLib.eqr("_cab",p_cVarName)) {
      return _cab;
    }
    if (CPLib.eqr("stringaflagrap2",p_cVarName)) {
      return stringaflagrap2;
    }
    if (CPLib.eqr("_flagrap2",p_cVarName)) {
      return _flagrap2;
    }
    if (CPLib.eqr("_desccit",p_cVarName)) {
      return _desccit;
    }
    if (CPLib.eqr("_numprog",p_cVarName)) {
      return _numprog;
    }
    if (CPLib.eqr("_stgrup",p_cVarName)) {
      return _stgrup;
    }
    if (CPLib.eqr("nota",p_cVarName)) {
      return nota;
    }
    if (CPLib.eqr("_idbase_ang",p_cVarName)) {
      return _idbase_ang;
    }
    if (CPLib.eqr("_connes",p_cVarName)) {
      return _connes;
    }
    if (CPLib.eqr("_ragsoc",p_cVarName)) {
      return _ragsoc;
    }
    if (CPLib.eqr("_cf",p_cVarName)) {
      return _cf;
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
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("column02date",p_cVarName)) {
      return column02date;
    }
    if (CPLib.eqr("date_base_excel",p_cVarName)) {
      return date_base_excel;
    }
    if (CPLib.eqr("DATARETT",p_cVarName)) {
      return w_DATARETT;
    }
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_commit",p_cVarName)) {
      return _commit;
    }
    if (CPLib.eqr("_falied",p_cVarName)) {
      return _falied;
    }
    if (CPLib.eqr("modifica",p_cVarName)) {
      return modifica;
    }
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("mcDati",p_cVarName)) {
      return mcDati;
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
    if (CPLib.eqr("i_MessageSink",p_cVarName)) {
      return m_MessageSink.RowForCaller();
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("column02num",p_cVarName)) {
      column02num = value;
      return;
    }
    if (CPLib.eqr("column12num",p_cVarName)) {
      column12num = value;
      return;
    }
    if (CPLib.eqr("riga_letta",p_cVarName)) {
      riga_letta = value;
      return;
    }
    if (CPLib.eqr("ncol",p_cVarName)) {
      ncol = value;
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("nomefile",p_cVarName)) {
      nomefile = value;
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
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
      return;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
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
    if (CPLib.eqr("riga_letta_c",p_cVarName)) {
      riga_letta_c = value;
      return;
    }
    if (CPLib.eqr("foglio_c",p_cVarName)) {
      foglio_c = value;
      return;
    }
    if (CPLib.eqr("cProgSto",p_cVarName)) {
      cProgSto = value;
      return;
    }
    if (CPLib.eqr("cCanc",p_cVarName)) {
      cCanc = value;
      return;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      cProg = value;
      return;
    }
    if (CPLib.eqr("_progrig",p_cVarName)) {
      _progrig = value;
      return;
    }
    if (CPLib.eqr("_idbase",p_cVarName)) {
      _idbase = value;
      return;
    }
    if (CPLib.eqr("_statoreg",p_cVarName)) {
      _statoreg = value;
      return;
    }
    if (CPLib.eqr("cNewProg",p_cVarName)) {
      cNewProg = value;
      return;
    }
    if (CPLib.eqr("_idereg",p_cVarName)) {
      _idereg = value;
      return;
    }
    if (CPLib.eqr("_idbase2",p_cVarName)) {
      _idbase2 = value;
      return;
    }
    if (CPLib.eqr("_cab",p_cVarName)) {
      _cab = value;
      return;
    }
    if (CPLib.eqr("stringaflagrap2",p_cVarName)) {
      stringaflagrap2 = value;
      return;
    }
    if (CPLib.eqr("_flagrap2",p_cVarName)) {
      _flagrap2 = value;
      return;
    }
    if (CPLib.eqr("_desccit",p_cVarName)) {
      _desccit = value;
      return;
    }
    if (CPLib.eqr("_numprog",p_cVarName)) {
      _numprog = value;
      return;
    }
    if (CPLib.eqr("_stgrup",p_cVarName)) {
      _stgrup = value;
      return;
    }
    if (CPLib.eqr("nota",p_cVarName)) {
      nota = value;
      return;
    }
    if (CPLib.eqr("_idbase_ang",p_cVarName)) {
      _idbase_ang = value;
      return;
    }
    if (CPLib.eqr("_connes",p_cVarName)) {
      _connes = value;
      return;
    }
    if (CPLib.eqr("_ragsoc",p_cVarName)) {
      _ragsoc = value;
      return;
    }
    if (CPLib.eqr("_cf",p_cVarName)) {
      _cf = value;
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
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("column02date",p_cVarName)) {
      column02date = value;
      return;
    }
    if (CPLib.eqr("date_base_excel",p_cVarName)) {
      date_base_excel = value;
      return;
    }
    if (CPLib.eqr("DATARETT",p_cVarName)) {
      w_DATARETT = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("_commit",p_cVarName)) {
      _commit = value;
      return;
    }
    if (CPLib.eqr("_falied",p_cVarName)) {
      _falied = value;
      return;
    }
    if (CPLib.eqr("modifica",p_cVarName)) {
      modifica = value;
      return;
    }
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcDati",p_cVarName)) {
      mcDati = (MemoryCursor_mcdatistru_mcrdef)value;
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
  void StartPage() throws Exception {
    CPResultSet Cursor_qbe_setsin=null;
    CPResultSet Cursor_tbsetsina=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* nomefile Char(30) // nome file da importare */
      /* gAzienda Char(10) // Azienda */
      /* gPathApp Char(80) // Path Applicazione */
      /* gMsgProc Memo // Messaggio */
      /* gMsgImp Char(120) // Messaggio */
      /* column01 Char(11) // numero progressivo */
      /* column02 Char(25) // data operazione */
      /* column02num Numeric(99, 0) // data operazione */
      /* column02date Date // data operazione */
      /* column03 Char(1) // segno */
      /* column04 Char(6) // codice agenzia */
      /* column05 Char(25) // descrizione agenzia */
      /* column06 Char(2) // provincia agenzia */
      /* column07 Char(3) // canale distributivo */
      /* column08 Char(16) // NDG */
      /* column09 Char(70) // Ragione Sociale */
      /* column10 Char(3) // Settore Sintetico */
      /* column11 Char(2) // Provincia Soggetto */
      /* column12num Numeric(15, 2) // Importo Netto */
      /* column13 Char(3) // Stato controparte */
      /* column14 Char(1) // Tipo operazione */
      /* column15 Char(9) // RIFIMPORT1 */
      /* column16 Char(30) // RIFIMPORT2 */
      /* column17 Char(3) // Paese_Residenza */
      /* column18 Char(30) // Citta_Residenza */
      /* _commit Bool // ok alla commit */
      /* _falied Bool // fallimento scrittura dati */
      /* riga_letta Numeric(9, 0) // riga letta del file Excel */
      /* riga_letta_c Char(9) // riga letta del file Excel Character */
      /* date_base_excel Date // data di base Excel */
      /* ncol Numeric(2, 0) // numero della colonna letta */
      /* foglio Numeric(2, 0) // foglio letto */
      /* foglio_c Char(9) // foglio letto Character */
      /* cProgSto Char(15) // progressivo wersonbo del giorno */
      /* w_DATARETT Date // data rettifica */
      /* cCanc Char(10) */
      /* cProg Char(10) */
      /* _progrig Char(10) */
      /* mcDati MemoryCursor(mcDatiStru.MCRDef) */
      /* mcWersonbo MemoryCursor(mcConnes.MCRDef) */
      /* mcSettori MemoryCursor(qbe_setsin.vqr) */
      /* mcSetSina MemoryCursor(tbsetsina) */
      /* _idbase Char(10) // _idbase operazione/ frazionata */
      /* _statoreg Char(1) // stato dell'operazione */
      /* cNewProg Char(10) */
      /* _idereg Char(20) */
      /* _idbase2 Char(10) */
      /* _cab Char(6) */
      /* stringaflagrap2 Char(10) */
      /* _flagrap2 Char(1) */
      /* _desccit Char(30) */
      /* _numprog Char(11) */
      /* _stgrup Char(3) */
      /* cell_type Numeric(1, 0) // tipologia di cella letta */
      /* nota Char(100) // nota del eventuale problema */
      /* modifica Bool // ok alla modifica dei dati */
      /* _idbase_ang Char(16) // _idbase_ang dell'anagrafica */
      /* _connes Char(16) // connes letto */
      /* _ragsoc Char(70) */
      /* _cf Char(16) // CF letto */
      /* _ateco Char(10) */
      /* _ramo Char(3) */
      /* _settsint Char(3) */
      /* gMsgProc := '' */
      gMsgProc = "";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + nomefile + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefile+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000047status;
      nTry00000047status = m_Sql.GetTransactionStatus();
      String cTry00000047msg;
      cTry00000047msg = m_Sql.TransactionErrorMessage();
      try {
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
                  info.log("Routine arrt_import_correzioni_sv: query on qbe_setsin returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
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
                  info.log("Routine arrt_import_correzioni_sv: query on tbsetsina returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
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
        /* Case At('.xls',Lower(LRTrim(nomefile))) <> 0 and At('.xlsx',Lower(LRTrim(nomefile))) = 0 */
        if (CPLib.ne(CPLib.At(".xls",CPLib.Lower(CPLib.LRTrim(nomefile))),0) && CPLib.eqr(CPLib.At(".xlsx",CPLib.Lower(CPLib.LRTrim(nomefile))),0)) {
          /* Exec "xls" Page 2:XLS */
          XLS();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* Case At('.xlsx',Lower(LRTrim(nomefile))) <> 0 */
        } else if (CPLib.ne(CPLib.At(".xlsx",CPLib.Lower(CPLib.LRTrim(nomefile))),0)) {
          /* Exec "Xlsx2" Page 3:XLSX */
          XLSX();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
        } // End Case
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        /* Debug Msg "Errore transazione %1" */
        if ( ! (CPLib.IsNull(m_Debug))) {
          m_Debug.log(CPLib.FormatMsg(m_Ctx,"Errore transazione %1",m_cLastMsgError));
        }
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000047status,0)) {
          m_Sql.SetTransactionStatus(nTry00000047status,cTry00000047msg);
        }
      }
      /* gMsgImp := 'Elaborazione Terminata!' // Messaggio Import */
      gMsgImp = "Elaborazione Terminata!";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + nomefile + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefile+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
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
    }
  }
  void XLS() throws Exception {
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_fraziobo=null;
    CPResultSet Cursor_operazbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_personbo=null;
    try {
      //base
      InputStream ExcelFileToRead = new FileInputStream(CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(nomefile));
      Workbook wb = WorkbookFactory.create(ExcelFileToRead);
      //HSSFWorkbook  wb = new HSSFWorkbook(ExcelFileToRead);
      //Modifica per evitare che carichi tutto il file in memoria
      
      conta = wb.getNumberOfSheets();
      
      System.out.println("Sono presenti "+conta);
      
      //Modifica per evitare che carichi tutto il file in memoria
      Row row; 
      Cell cell;
      
      Row row2; 
      Cell cell2;
      /* riga_letta := 0 // riga letta del file Excel */
      riga_letta = CPLib.Round(0,0);
      /* w_DATARETT := Date() // data rettifica */
      w_DATARETT = CPLib.Date();
      // * --- Fill memory cursor mcWersonbo on wersonbo
      mcWersonbo.Zap();
      m_cServer = m_Ctx.GetServer("wersonbo");
      m_cPhName = m_Ctx.GetPhName("wersonbo");
      if (Cursor_wersonbo!=null)
        Cursor_wersonbo.Close();
      Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"datamodi="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_DATARETT,"?",0,0,m_cServer, m_oParameters),m_cServer,w_DATARETT)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_wersonbo;
        Cursor_wersonbo.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_import_correzioni_sv: query on wersonbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
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
      /* _commit := True // ok alla commit */
      _commit = true;
      //Azzero i contatori di fogli letti e righe scritte
      _i = 0;
      r=0;
      /* _commit := True // ok alla commit */
      _commit = true;
      /* While _i < conta */
      while (CPLib.lt(_i,conta)) {
        //Apro uno ad uno i fogli del file Excel
        Sheet sheet = wb.getSheetAt(_i);
        //Mi definisco un oggetto che contiene tutte le righe
        Iterator rows = sheet.rowIterator();
        // System.out.println("Lettura foglio "+_i+" di "+conta);
        // System.out.println("Ci sono record "+rows.hasNext());
        /* gMsgProc := gMsgProc +"Lettura foglio "+_i+" di "+conta+' '+ arfn_fdatetime(DateTime()) + ' del file ' + nomefile + NL */
        gMsgProc = gMsgProc+"Lettura foglio "+_i+" di "+conta+" "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefile+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* riga_letta := 0 // riga letta del file Excel */
        riga_letta = CPLib.Round(0,0);
        /* foglio := _i // foglio letto */
        foglio = CPLib.Round(_i,0);
        /* While rows.hasNext() and _commit */
        while (rows.hasNext() && _commit) {
          //scorro le righe
          row=(Row) rows.next();
          //Mi definisco un oggetto che contiene tutte le celle della riga letta
          Iterator cells = row.cellIterator();
          /* cell_count := 0 */
          cell_count = 0;
          /* riga_letta := riga_letta+1 // riga letta del file Excel */
          riga_letta = CPLib.Round(riga_letta+1,0);
          /* nota := '' // nota del eventuale problema */
          nota = "";
          /* modifica := True // ok alla modifica dei dati */
          modifica = true;
          /* gMsgProc := gMsgProc +"Lettura foglio "+_i+" di "+conta+" riga letta "+riga_letta+' '+arfn_fdatetime(DateTime()) + ' del file ' + nomefile + NL */
          gMsgProc = gMsgProc+"Lettura foglio "+_i+" di "+conta+" riga letta "+riga_letta+" "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefile+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* column01 := '' // numero progressivo */
          column01 = "";
          /* column02 := '' // data operazione */
          column02 = "";
          /* column02num := 0 // data operazione */
          column02num = CPLib.Round(0,0);
          /* column02date := NullDate() // data operazione */
          column02date = CPLib.NullDate();
          /* column03 := '' // segno */
          column03 = "";
          /* column04 := '' // codice agenzia */
          column04 = "";
          /* column05 := '' // descrizione agenzia */
          column05 = "";
          /* column06 := '' // provincia agenzia */
          column06 = "";
          /* column07 := '' // canale distributivo */
          column07 = "";
          /* column08 := '' // NDG */
          column08 = "";
          /* column09 := '' // Ragione Sociale */
          column09 = "";
          /* column10 := '' // Settore Sintetico */
          column10 = "";
          /* column11 := '' // Provincia Soggetto */
          column11 = "";
          /* column12num := 0 // Importo Netto */
          column12num = CPLib.Round(0,2);
          /* column13 := '' // Stato residenza cliente */
          column13 = "";
          /* column14 := '' // Tipo operazione */
          column14 = "";
          /* column15 := '' // RIFIMPORT1 */
          column15 = "";
          /* column16 := '' // RIFIMPORT2 */
          column16 = "";
          /* column17 := '' // Paese_Residenza */
          column17 = "";
          /* column18 := '' // Citta_Residenza */
          column18 = "";
          /* While cells.hasNext() and riga_letta>1 */
          while (cells.hasNext() && CPLib.gt(riga_letta,1)) {
            //scorro le celle della riga
            cell=(Cell) cells.next();
            /* cell_count := cell_count+1 */
            cell_count = cell_count+1;
            /* cell_type := cell.getCellType().ordinal() */
            cell_type = CPLib.Round(cell.getCellType().ordinal(),0);
            /* ncol := cell.getColumnIndex() // numero della colonna letta */
            ncol = CPLib.Round(cell.getColumnIndex(),0);
            /* ncol := ncol+1 // numero della colonna letta */
            ncol = CPLib.Round(ncol+1,0);
            /* While cell_count<ncol */
            while (CPLib.lt(cell_count,ncol)) {
              /* cell_count := cell_count+1 */
              cell_count = cell_count+1;
            } // End While
            /* Case cell_type=0 */
            if (CPLib.eqr(cell_type,0)) {
              /* Case cell_count=2 */
              if (CPLib.eqr(cell_count,2)) {
                /* column02num := cell.getNumericCellValue() // data operazione */
                column02num = CPLib.Round(cell.getNumericCellValue(),0);
                /* column02date := CharToDate(LRTrim(sdf.format(cell.getDateCellValue()))) // data operazione */
                column02date = CPLib.CharToDate(CPLib.LRTrim(sdf.format(cell.getDateCellValue())));
                /* column02 := LRTrim(sdf.format(cell.getDateCellValue())) // data operazione */
                column02 = CPLib.LRTrim(sdf.format(cell.getDateCellValue()));
                /* Case cell_count=12 */
              } else if (CPLib.eqr(cell_count,12)) {
                /* column12num := cell.getNumericCellValue() // Importo Netto */
                column12num = CPLib.Round(cell.getNumericCellValue(),2);
              } else { // Otherwise
                // Transaction Error
                m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"errore tipo colonna non prevista (numerico)"));
                throw new RoutineException(CPLib.FormatMsg(m_Ctx,"errore tipo colonna non prevista (numerico)"));
              } // End Case
              /* Case cell_type=1 */
            } else if (CPLib.eqr(cell_type,1)) {
              /* Case cell_count=1 */
              if (CPLib.eqr(cell_count,1)) {
                /* column01 := LRTrim(cell.getStringCellValue()) // numero progressivo */
                column01 = CPLib.LRTrim(cell.getStringCellValue());
                /* Case cell_count=3 */
              } else if (CPLib.eqr(cell_count,3)) {
                /* column03 := LRTrim(cell.getStringCellValue()) // segno */
                column03 = CPLib.LRTrim(cell.getStringCellValue());
                /* Case cell_count=4 */
              } else if (CPLib.eqr(cell_count,4)) {
                /* column04 := LRTrim(cell.getStringCellValue()) // codice agenzia */
                column04 = CPLib.LRTrim(cell.getStringCellValue());
                /* Case cell_count=5 */
              } else if (CPLib.eqr(cell_count,5)) {
                /* column05 := LRTrim(cell.getStringCellValue()) // descrizione agenzia */
                column05 = CPLib.LRTrim(cell.getStringCellValue());
                /* Case cell_count=6 */
              } else if (CPLib.eqr(cell_count,6)) {
                /* column06 := LRTrim(cell.getStringCellValue()) // provincia agenzia */
                column06 = CPLib.LRTrim(cell.getStringCellValue());
                /* Case cell_count=7 */
              } else if (CPLib.eqr(cell_count,7)) {
                /* column07 := LRTrim(cell.getStringCellValue()) // canale distributivo */
                column07 = CPLib.LRTrim(cell.getStringCellValue());
                /* Case cell_count=8 */
              } else if (CPLib.eqr(cell_count,8)) {
                /* column08 := LRTrim(cell.getStringCellValue()) // NDG */
                column08 = CPLib.LRTrim(cell.getStringCellValue());
                /* Case cell_count=9 */
              } else if (CPLib.eqr(cell_count,9)) {
                /* column09 := LRTrim(cell.getStringCellValue()) // Ragione Sociale */
                column09 = CPLib.LRTrim(cell.getStringCellValue());
                /* Case cell_count=10 */
              } else if (CPLib.eqr(cell_count,10)) {
                /* column10 := LRTrim(cell.getStringCellValue()) // Settore Sintetico */
                column10 = CPLib.LRTrim(cell.getStringCellValue());
                /* Case cell_count=11 */
              } else if (CPLib.eqr(cell_count,11)) {
                /* column11 := LRTrim(cell.getStringCellValue()) // Provincia Soggetto */
                column11 = CPLib.LRTrim(cell.getStringCellValue());
                /* Case cell_count=13 */
              } else if (CPLib.eqr(cell_count,13)) {
                /* column13 := LRTrim(cell.getStringCellValue()) // Stato controparte */
                column13 = CPLib.LRTrim(cell.getStringCellValue());
                /* Case cell_count=14 */
              } else if (CPLib.eqr(cell_count,14)) {
                /* column14 := LRTrim(cell.getStringCellValue()) // Tipo operazione */
                column14 = CPLib.LRTrim(cell.getStringCellValue());
                /* Case cell_count=15 */
              } else if (CPLib.eqr(cell_count,15)) {
                /* column15 := LRTrim(cell.getStringCellValue()) // RIFIMPORT1 */
                column15 = CPLib.LRTrim(cell.getStringCellValue());
                /* Case cell_count=16 */
              } else if (CPLib.eqr(cell_count,16)) {
                /* column16 := LRTrim(cell.getStringCellValue()) // RIFIMPORT2 */
                column16 = CPLib.LRTrim(cell.getStringCellValue());
                /* Case cell_count=17 */
              } else if (CPLib.eqr(cell_count,17)) {
                /* column17 := LRTrim(cell.getStringCellValue()) // Paese_Residenza */
                column17 = CPLib.LRTrim(cell.getStringCellValue());
                /* Case cell_count=18 */
              } else if (CPLib.eqr(cell_count,18)) {
                /* column18 := LRTrim(cell.getStringCellValue()) // Citta_Residenza */
                column18 = CPLib.LRTrim(cell.getStringCellValue());
                /* Case cell_count=19 */
              } else if (CPLib.eqr(cell_count,19)) {
              } else { // Otherwise
                // Transaction Error
                m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"errore tipo colonna non prevista (stringa) %1",CPLib.Str(cell_count,2,0)));
                throw new RoutineException(CPLib.FormatMsg(m_Ctx,"errore tipo colonna non prevista (stringa) %1",CPLib.Str(cell_count,2,0)));
              } // End Case
              /* Case cell_type=2 */
            } else if (CPLib.eqr(cell_type,2)) {
              // Transaction Error
              m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"errore tipo colonna non prevista (2)"));
              throw new RoutineException(CPLib.FormatMsg(m_Ctx,"errore tipo colonna non prevista (2)"));
              /* Case cell_type=3 */
            } else if (CPLib.eqr(cell_type,3)) {
              // Transaction Error
              m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"errore tipo colonna non prevista (3)"));
              throw new RoutineException(CPLib.FormatMsg(m_Ctx,"errore tipo colonna non prevista (3)"));
            } else { // Otherwise
              // Transaction Error
              m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"errore tipo colonna non prevista (altro)"));
              throw new RoutineException(CPLib.FormatMsg(m_Ctx,"errore tipo colonna non prevista (altro)"));
            } // End Case
          } // End While
          /* If not(Empty(column01) or Empty(column08)) */
          if ( ! (CPLib.Empty(column01) || CPLib.Empty(column08))) {
            /* _idbase := '' */
            _idbase = "";
            /* If column14='F' */
            if (CPLib.eqr(column14,"F")) {
              // * --- Select from fraziobo
              m_cServer = m_Ctx.GetServer("fraziobo");
              m_cPhName = m_Ctx.GetPhName("fraziobo");
              if (Cursor_fraziobo!=null)
                Cursor_fraziobo.Close();
              Cursor_fraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(column01,"?",0,0,m_cServer, m_oParameters),m_cServer,column01)+"  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("fraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_fraziobo.Eof())) {
                /* _idbase := fraziobo->IDBASE // _idbase operazione/ frazionata */
                _idbase = Cursor_fraziobo.GetString("IDBASE");
                Cursor_fraziobo.Next();
              }
              m_cConnectivityError = Cursor_fraziobo.ErrorMessage();
              Cursor_fraziobo.Close();
              // * --- End Select
            } else { // Else
              // * --- Select from operazbo
              m_cServer = m_Ctx.GetServer("operazbo");
              m_cPhName = m_Ctx.GetPhName("operazbo");
              if (Cursor_operazbo!=null)
                Cursor_operazbo.Close();
              Cursor_operazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select "+CPLib.ToSQL(Cursor_fraziobo.GetString("IDBASE"),"?",0,0)+"  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(column01,"?",0,0,m_cServer, m_oParameters),m_cServer,column01)+"  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("operazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_operazbo.Eof())) {
                /* _idbase := fraziobo->IDBASE // _idbase operazione/ frazionata */
                _idbase = Cursor_fraziobo.GetString("IDBASE");
                Cursor_operazbo.Next();
              }
              m_cConnectivityError = Cursor_operazbo.ErrorMessage();
              Cursor_operazbo.Close();
              // * --- End Select
            } // End If
            // * --- Read from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_cSql = "";
            m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(column08,"C",16,0,m_cServer),m_cServer,column08);
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
                Error l_oErrorFault = new Error("Read on personbo into routine arrt_import_correzioni_sv returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _ragsoc = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* gMsgProc := gMsgProc +'Idbase letto su frazionata: '+LRTrim(_idbase)+' Numero progressivo associato: '+LRTrim(column01)+' Ragsoc letto su personbo: '+LRTrim(_ragsoc)+' NDG associato: '+LRTrim(column08)+' '+arfn_fdatetime(DateTime()) + ' del file ' + nomefile + NL */
            gMsgProc = gMsgProc+"Idbase letto su frazionata: "+CPLib.LRTrim(_idbase)+" Numero progressivo associato: "+CPLib.LRTrim(column01)+" Ragsoc letto su personbo: "+CPLib.LRTrim(_ragsoc)+" NDG associato: "+CPLib.LRTrim(column08)+" "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefile+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* gMsgImp := 'Elaboro '+iif(column14='F','frazionata','operazione')+" con progressivo n. "+column01 + " (riga letta " + LRTrim(Str(riga_letta,10,0)) + ")" */
            gMsgImp = "Elaboro "+(CPLib.eqr(column14,"F")?"frazionata":"operazione")+" con progressivo n. "+column01+" (riga letta "+CPLib.LRTrim(CPLib.Str(riga_letta,10,0))+")";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* If Empty(_idbase) or Empty(_ragsoc) */
            if (CPLib.Empty(_idbase) || CPLib.Empty(_ragsoc)) {
              /* Debug Msg "id base non trovato" */
              if ( ! (CPLib.IsNull(m_Debug))) {
                m_Debug.log(CPLib.FormatMsg(m_Ctx,"id base non trovato"));
              }
              // Transaction Error
              m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"id base non trovato"));
              throw new RoutineException(CPLib.FormatMsg(m_Ctx,"id base non trovato"));
            } else { // Else
              /* Empty(LRTrim(cProgSto)) */
              /* If not(mcWersonbo.HasKey(LRTrim(column08))) */
              if ( ! (mcWersonbo.HasKey(CPLib.LRTrim(column08)))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LTrim(column08),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.LTrim(column08))+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                {
                  final CPResultSet m_TheCursor = Cursor_personbo;
                  Cursor_personbo.ActionOnClose(new Runnable() {
                    public void run() {
                      if (CPLib.gt(m_TheCursor.CurrentRow()-1,1*1.1)) {
                        com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                        if ( ! (CPLib.IsNull(info))) {
                          info.log("Routine arrt_import_correzioni_sv: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1");
                        }
                      }
                    }
                    });
                }
                if ( ! (Cursor_personbo.Eof())) {
                  while ( ! (Cursor_personbo.Eof())) {
                    /* If LRTrim(personbo->PROVINCIA)<>LRTrim(column11) or LRTrim(personbo->SOTGRUP) <> LRTrim(column10) or LRTrim(personbo->PAESE)<>LRTrim(column17) or LRTrim(personbo->DESCCIT)<>LRTrim(column18) */
                    if (CPLib.ne(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA")),CPLib.LRTrim(column11)) || CPLib.ne(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP")),CPLib.LRTrim(column10)) || CPLib.ne(CPLib.LRTrim(Cursor_personbo.GetString("PAESE")),CPLib.LRTrim(column17)) || CPLib.ne(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT")),CPLib.LRTrim(column18))) {
                      /* _ateco := personbo->ATTIV */
                      _ateco = Cursor_personbo.GetString("ATTIV");
                      /* _ramo := personbo->RAMOGRUP */
                      _ramo = Cursor_personbo.GetString("RAMOGRUP");
                      /* _stgrup := LRTrim(column10) */
                      _stgrup = CPLib.LRTrim(column10);
                      /* _settsint := '' */
                      _settsint = "";
                      /* Exec "Settore Sintetico" Page 4:Settore */
                      Settore();
                      /* cProgSto := Utilities.GetAutonumber("PSTOPERS\'"+LRTrim(gAzienda)+"'","",15) */
                      cProgSto = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PSTOPERS\\'"+CPLib.LRTrim(gAzienda)+"'","",15);
                      // * --- Insert into wersonbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("wersonbo");
                      m_cPhName = m_Ctx.GetPhName("wersonbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_correzioni_sv",137,"000000B6")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_000000B6(m_Ctx,m_oWrInfo);
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
                      m_cSql = m_cSql+""+CPLib.ToSQL(w_DATARETT,"?",0,0)+", ";
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
                      }
                      // * --- Write into personbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("personbo");
                      m_cPhName = m_Ctx.GetPhName("personbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_correzioni_sv",137,"000000B7")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(CPLib.LRTrim(column11),"C",2,0,m_cServer)+", ";
                      m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(CPLib.LRTrim(column10),"C",3,0,m_cServer)+", ";
                      m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(_settsint,"C",3,0,m_cServer)+", ";
                      m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.LRTrim(column18),"C",30,0,m_cServer)+", ";
                      m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(CPLib.LRTrim(column17),"C",3,0,m_cServer)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer),m_cServer,Cursor_personbo.GetString("CONNES"))+"";
                      m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                      m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                      {
                        if (CPLib.gt(m_nUpdatedRows,1*1.1)) {
                          com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                          if ( ! (CPLib.IsNull(info))) {
                            info.log("Routine arrt_import_correzioni_sv: Write on personbo updates "+(m_nUpdatedRows)+" rows larger then the expected 1");
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
                      }
                      /* mcWersonbo.AppendWithKey(LTrim(column08)) */
                      mcWersonbo.AppendWithKey(CPLib.LTrim(column08));
                      /* mcWersonbo.connes := LTrim(column08) */
                      mcWersonbo.row.connes = CPLib.LTrim(column08);
                      /* mcWersonbo.SaveRow() */
                      mcWersonbo.SaveRow();
                      /* nota := iif(Empty(nota),'soggetto trovato, storicizzato e modificato',nota+' soggetto trovato, storicizzato e modificato') // nota del eventuale problema */
                      nota = (CPLib.Empty(nota)?"soggetto trovato, storicizzato e modificato":nota+" soggetto trovato, storicizzato e modificato");
                    } else { // Else
                      /* nota := iif(Empty(nota),'soggetto trovato ma con lo stesso dato',nota+' soggetto trovato ma con lo stesso dato') // nota del eventuale problema */
                      nota = (CPLib.Empty(nota)?"soggetto trovato ma con lo stesso dato":nota+" soggetto trovato ma con lo stesso dato");
                    } // End If
                    Cursor_personbo.Next();
                  }
                  m_cConnectivityError = Cursor_personbo.ErrorMessage();
                } else {
                  // No rows selected
                  /* _connes := '' // connes letto */
                  _connes = "";
                  /* _cf := '' // CF letto */
                  _cf = "";
                  // * --- Read from personbo
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  m_cSql = "";
                  m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LTrim(column08),"C",16,0,m_cServer),m_cServer,CPLib.LTrim(column08));
                  if (m_Ctx.IsSharedTemp("personbo")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _connes = Read_Cursor.GetString("CONNES");
                    _cf = Read_Cursor.GetString("CODFISC");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on personbo into routine arrt_import_correzioni_sv returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _connes = "";
                    _cf = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* If Empty(_connes) */
                  if (CPLib.Empty(_connes)) {
                    /* nota := iif(Empty(nota),'soggetto ricercato non trovato in anagrafica',nota+' soggetto ricercato non trovato in anagrafica') // nota del eventuale problema */
                    nota = (CPLib.Empty(nota)?"soggetto ricercato non trovato in anagrafica":nota+" soggetto ricercato non trovato in anagrafica");
                  } // End If
                }
                Cursor_personbo.Close();
                // * --- End Select
              } else { // Else
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LTrim(column08),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.LTrim(column08))+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                {
                  final CPResultSet m_TheCursor = Cursor_personbo;
                  Cursor_personbo.ActionOnClose(new Runnable() {
                    public void run() {
                      if (CPLib.gt(m_TheCursor.CurrentRow()-1,1*1.1)) {
                        com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                        if ( ! (CPLib.IsNull(info))) {
                          info.log("Routine arrt_import_correzioni_sv: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1");
                        }
                      }
                    }
                    });
                }
                if ( ! (Cursor_personbo.Eof())) {
                  while ( ! (Cursor_personbo.Eof())) {
                    /* If LRTrim(personbo->PROVINCIA)<>LRTrim(column11) or LRTrim(personbo->SOTGRUP) <> LRTrim(column10) or LRTrim(personbo->PAESE)<>LRTrim(column17) or LRTrim(personbo->DESCCIT)<>LRTrim(column18) */
                    if (CPLib.ne(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA")),CPLib.LRTrim(column11)) || CPLib.ne(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP")),CPLib.LRTrim(column10)) || CPLib.ne(CPLib.LRTrim(Cursor_personbo.GetString("PAESE")),CPLib.LRTrim(column17)) || CPLib.ne(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT")),CPLib.LRTrim(column18))) {
                      /* _ateco := personbo->ATTIV */
                      _ateco = Cursor_personbo.GetString("ATTIV");
                      /* _ramo := personbo->RAMOGRUP */
                      _ramo = Cursor_personbo.GetString("RAMOGRUP");
                      /* _stgrup := LRTrim(column10) */
                      _stgrup = CPLib.LRTrim(column10);
                      /* _settsint := '' */
                      _settsint = "";
                      /* Exec "Settore Sintetico" Page 4:Settore */
                      Settore();
                      // * --- Write into personbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("personbo");
                      m_cPhName = m_Ctx.GetPhName("personbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_correzioni_sv",137,"000000C9")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(CPLib.LRTrim(column11),"C",2,0,m_cServer)+", ";
                      m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(CPLib.LRTrim(column10),"C",3,0,m_cServer)+", ";
                      m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(_settsint,"C",3,0,m_cServer)+", ";
                      m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.LRTrim(column18),"C",30,0,m_cServer)+", ";
                      m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(CPLib.LRTrim(column17),"C",3,0,m_cServer)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer),m_cServer,Cursor_personbo.GetString("CONNES"))+"";
                      m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                      m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                      {
                        if (CPLib.gt(m_nUpdatedRows,1*1.1)) {
                          com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                          if ( ! (CPLib.IsNull(info))) {
                            info.log("Routine arrt_import_correzioni_sv: Write on personbo updates "+(m_nUpdatedRows)+" rows larger then the expected 1");
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
                      }
                      /* nota := iif(Empty(nota),'soggetto trovato e modificato',nota+' soggetto trovato e modificato') // nota del eventuale problema */
                      nota = (CPLib.Empty(nota)?"soggetto trovato e modificato":nota+" soggetto trovato e modificato");
                    } else { // Else
                      /* nota := iif(Empty(nota),'soggetto trovato ma con lo stesso dato',nota+' soggetto trovato ma con lo stesso dato') // nota del eventuale problema */
                      nota = (CPLib.Empty(nota)?"soggetto trovato ma con lo stesso dato":nota+" soggetto trovato ma con lo stesso dato");
                    } // End If
                    Cursor_personbo.Next();
                  }
                  m_cConnectivityError = Cursor_personbo.ErrorMessage();
                } else {
                  // No rows selected
                  /* _connes := '' // connes letto */
                  _connes = "";
                  /* _cf := '' // CF letto */
                  _cf = "";
                  // * --- Read from personbo
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  m_cSql = "";
                  m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LTrim(column08),"C",16,0,m_cServer),m_cServer,CPLib.LTrim(column08));
                  if (m_Ctx.IsSharedTemp("personbo")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _connes = Read_Cursor.GetString("CONNES");
                    _cf = Read_Cursor.GetString("CODFISC");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on personbo into routine arrt_import_correzioni_sv returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _connes = "";
                    _cf = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* If Empty(_connes) */
                  if (CPLib.Empty(_connes)) {
                    /* nota := iif(Empty(nota),'soggetto ricercato non trovato in anagrafica',nota+' soggetto ricercato non trovato in anagrafica') // nota del eventuale problema */
                    nota = (CPLib.Empty(nota)?"soggetto ricercato non trovato in anagrafica":nota+" soggetto ricercato non trovato in anagrafica");
                  } // End If
                }
                Cursor_personbo.Close();
                // * --- End Select
              } // End If
              /* If LRTrim(column14)='F' */
              if (CPLib.eqr(CPLib.LRTrim(column14),"F")) {
                /* stringaflagrap2 := 'JLMNOTUV?' // stringa di valori di flagrap2 */
                stringaflagrap2 = "JLMNOTUV?";
                // * --- Select from fraziobo
                m_cServer = m_Ctx.GetServer("fraziobo");
                m_cPhName = m_Ctx.GetPhName("fraziobo");
                if (Cursor_fraziobo!=null)
                  Cursor_fraziobo.Close();
                Cursor_fraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idbase,"?",0,0,m_cServer, m_oParameters),m_cServer,_idbase)+" "+")"+(m_Ctx.IsSharedTemp("fraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_fraziobo.Eof())) {
                  /* If LRTrim(column13)<>fraziobo->C_STA */
                  if (CPLib.ne(CPLib.LRTrim(column13),Cursor_fraziobo.GetString("C_STA"))) {
                    /* cNewProg := Utilities.GetAutonumber("PFRAZIO1\'"+LRTrim(gAzienda)+"'",Space(10),10) */
                    cNewProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PFRAZIO1\\'"+CPLib.LRTrim(gAzienda)+"'",CPLib.Space(10),10);
                    /* _flagrap2 := iif(Empty(fraziobo->FLAGRAP2) or fraziobo->FLAGRAP2='Z',Left(stringaflagrap2,1),Substr(stringaflagrap2,(At(fraziobo->FLAGRAP2,stringaflagrap2)+1),1)) */
                    _flagrap2 = (CPLib.Empty(Cursor_fraziobo.GetString("FLAGRAP2")) || CPLib.eqr(Cursor_fraziobo.GetString("FLAGRAP2"),"Z")?CPLib.Left(stringaflagrap2,1):CPLib.Substr(stringaflagrap2,(CPLib.At(Cursor_fraziobo.GetString("FLAGRAP2"),stringaflagrap2)+1),1));
                    /* _idbase2 := LibreriaMit.UniqueId() // Idbase */
                    _idbase2 = LibreriaMit.UniqueId();
                    /* _idereg := 'F'+Right(fraziobo->NUMPROG,9)+_idbase2 // Stato Registrazione */
                    _idereg = "F"+CPLib.Right(Cursor_fraziobo.GetString("NUMPROG"),9)+_idbase2;
                    // * --- Insert into fraziobo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("fraziobo");
                    m_cPhName = m_Ctx.GetPhName("fraziobo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_import_correzioni_sv",137,"000000D9")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000000D9(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_IND"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(column13),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("CAMBIO"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CDATREG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDate("DATAIMP"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDate("DATAOPE"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDate("DATAREG"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(w_DATARETT,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("DUCOLLEG"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("DURAT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_flagrap2,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(cNewProg,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_idbase2,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("idcauana"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_idereg,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("IMPOUT"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("IPCOLLEG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("MTCN"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("NOPROT"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDateTime("ORACOLLEG"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("PAGASOGOP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("PRGIMPFRZ"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("RAREA"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("RCOMP"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("RFREQ"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("RIMP"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("RRAGIO"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("RTIPO"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("TOTCONT"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("TOTLIRE"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("IMPIN"),"?",0,0)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"fraziobo",true);
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
                    // * --- Write into fraziobo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("fraziobo");
                    m_cPhName = m_Ctx.GetPhName("fraziobo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_import_correzioni_sv",137,"000000DA")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL("3","C",1,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DATARETT = "+CPLib.ToSQL(w_DATARETT,"D",8,0)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_idbase,"?",0,0,m_cServer),m_cServer,_idbase)+"";
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
                  Cursor_fraziobo.Next();
                }
                m_cConnectivityError = Cursor_fraziobo.ErrorMessage();
                Cursor_fraziobo.Close();
                // * --- End Select
              } else { // Else
                /* stringaflagrap2 := 'ABCDEFGHI' // stringa di valori di flagrap2 */
                stringaflagrap2 = "ABCDEFGHI";
                // * --- Select from operazbo
                m_cServer = m_Ctx.GetServer("operazbo");
                m_cPhName = m_Ctx.GetPhName("operazbo");
                if (Cursor_operazbo!=null)
                  Cursor_operazbo.Close();
                Cursor_operazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idbase,"?",0,0,m_cServer, m_oParameters),m_cServer,_idbase)+" "+")"+(m_Ctx.IsSharedTemp("operazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_operazbo.Eof())) {
                  /* If LRTrim(column13)<>operazbo->C_STA */
                  if (CPLib.ne(CPLib.LRTrim(column13),Cursor_operazbo.GetString("C_STA"))) {
                    /* cNewProg := Utilities.GetAutonumber("POPERAZ1\'"+LRTrim(gAzienda)+"'",Space(10),10) */
                    cNewProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ1\\'"+CPLib.LRTrim(gAzienda)+"'",CPLib.Space(10),10);
                    /* _flagrap2 := iif(Empty(operazbo->FLAGRAP2) or operazbo->FLAGRAP2='S',Left(stringaflagrap2,1),Substr(stringaflagrap2,(At(operazbo->FLAGRAP2,stringaflagrap2)+1),1)) */
                    _flagrap2 = (CPLib.Empty(Cursor_operazbo.GetString("FLAGRAP2")) || CPLib.eqr(Cursor_operazbo.GetString("FLAGRAP2"),"S")?CPLib.Left(stringaflagrap2,1):CPLib.Substr(stringaflagrap2,(CPLib.At(Cursor_operazbo.GetString("FLAGRAP2"),stringaflagrap2)+1),1));
                    /* _idbase2 := LibreriaMit.UniqueId() // Idbase */
                    _idbase2 = LibreriaMit.UniqueId();
                    /* _idereg := 'O'+Right(operazbo->NUMPROG,9)+_idbase2 // Stato Registrazione */
                    _idereg = "O"+CPLib.Right(Cursor_operazbo.GetString("NUMPROG"),9)+_idbase2;
                    // * --- Insert into operazbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("operazbo");
                    m_cPhName = m_Ctx.GetPhName("operazbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_import_correzioni_sv",137,"000000E2")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000000E2(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("C_IND"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(column13),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("CAMBIO"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CDATREG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDate("DATAIMP"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDate("DATAOPE"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDate("DATAREG"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(w_DATARETT,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("DUCOLLEG"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("DURAT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_flagrap2,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(cNewProg,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_idbase2,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("idcauana"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_idereg,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("IPCOLLEG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("MTCN"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("NOPROT"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDateTime("ORACOLLEG"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("PAGASOGOP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("PRGIMPOPE"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("RAREA"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("RCOMP"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("RFREQ"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("RIMP"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("RRAGIO"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("RTIPO"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("TOTCONT"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("TOTLIRE"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("IMPIN"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("IMPOUT"),"?",0,0)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"operazbo",true);
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
                    // * --- Write into operazbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("operazbo");
                    m_cPhName = m_Ctx.GetPhName("operazbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_import_correzioni_sv",137,"000000E3")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL("3","C",1,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DATARETT = "+CPLib.ToSQL(w_DATARETT,"D",8,0)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_idbase,"?",0,0,m_cServer),m_cServer,_idbase)+"";
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
                  Cursor_operazbo.Next();
                }
                m_cConnectivityError = Cursor_operazbo.ErrorMessage();
                Cursor_operazbo.Close();
                // * --- End Select
              } // End If
            } // End If
            /* If not(Empty(nota)) */
            if ( ! (CPLib.Empty(nota))) {
              /* gMsgProc := gMsgProc+nota+' '+arfn_fdatetime(DateTime()) + ' del file ' + nomefile + NL */
              gMsgProc = gMsgProc+nota+" "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefile+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            } // End If
          } else { // Else
            /* gMsgProc := gMsgProc +'Nessuna azione intrapesa per la riga corrente '+arfn_fdatetime(DateTime()) + ' del file ' + nomefile + NL */
            gMsgProc = gMsgProc+"Nessuna azione intrapesa per la riga corrente "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefile+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } // End If
        } // End While
        _i++;
      } // End While
      // Cancella file input
      wb.close();
      //?FileLibMit.DeleteFile("appo/"+CPLib.LRTrim(gAzienda)+"/"+nomefile);
      /* _commit := FileLibMit.DeleteFile("appo/"+LRTrim(gAzienda)+"/"+nomefile) // ok alla commit */
      _commit = FileLibMit.DeleteFile("appo/"+CPLib.LRTrim(gAzienda)+"/"+nomefile);
    } finally {
      try {
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_fraziobo!=null)
          Cursor_fraziobo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_operazbo!=null)
          Cursor_operazbo.Close();
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
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void XLSX() throws Exception {
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_personbo=null;
    try {
      // Prova
      InputStream is = new FileInputStream(new File(CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(nomefile)));
      Workbook workbook = StreamingReader.builder()
              .rowCacheSize(100)    // number of rows to keep in memory (defaults to 10)
              .bufferSize(4096)     // buffer size to use when reading InputStream to file (defaults to 1024)
              .open(is);            // InputStream or File for XLSX file (required)
      Cell cell;
      int cellType;
      String[] colonna = new String[18];
      _i=0;
      riga_letta=0;
      Sheet sheet = workbook.getSheetAt(0);
      for (Row row : sheet) {
        if (row == null) {
               // This row is completely empty
          } else {
      /* riga_letta := riga_letta+1 // riga letta del file Excel */
      riga_letta = CPLib.Round(riga_letta+1,0);
      /* w_DATARETT := Date() // data rettifica */
      w_DATARETT = CPLib.Date();
      /* gMsgImp := 'Elaboro riga Excel numero: '+ LRTrim(Str(riga_letta,10,0)) // Messaggio Import */
      gMsgImp = "Elaboro riga Excel numero: "+CPLib.LRTrim(CPLib.Str(riga_letta,10,0));
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* If riga_letta > 1 */
      if (CPLib.gt(riga_letta,1)) {
        //scorro le colonne
        cell_count=0;
        /* While cell_count < 18 */
        while (CPLib.lt(cell_count,18)) {
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
        /* mcDati.AppendBlank() */
        mcDati.AppendBlank();
        /* mcDati.colonna1 := colonna[0] */
        mcDati.row.colonna1 = colonna[0];
        /* mcDati.colonna2 := colonna[1] */
        mcDati.row.colonna2 = colonna[1];
        /* mcDati.colonna3 := colonna[2] */
        mcDati.row.colonna3 = colonna[2];
        /* mcDati.colonna4 := colonna[3] */
        mcDati.row.colonna4 = colonna[3];
        /* mcDati.colonna5 := colonna[4] */
        mcDati.row.colonna5 = colonna[4];
        /* mcDati.colonna6 := colonna[5] */
        mcDati.row.colonna6 = colonna[5];
        /* mcDati.colonna7 := colonna[6] */
        mcDati.row.colonna7 = colonna[6];
        /* mcDati.colonna8 := colonna[7] */
        mcDati.row.colonna8 = colonna[7];
        /* mcDati.colonna9 := colonna[8] */
        mcDati.row.colonna9 = colonna[8];
        /* mcDati.colonna10 := colonna[9] */
        mcDati.row.colonna10 = colonna[9];
        /* mcDati.colonna11 := colonna[10] */
        mcDati.row.colonna11 = colonna[10];
        /* mcDati.colonna12 := colonna[11] */
        mcDati.row.colonna12 = colonna[11];
        /* mcDati.colonna13 := colonna[12] */
        mcDati.row.colonna13 = colonna[12];
        /* mcDati.colonna14 := colonna[13] */
        mcDati.row.colonna14 = colonna[13];
        /* mcDati.colonna15 := colonna[14] */
        mcDati.row.colonna15 = colonna[14];
        /* mcDati.colonna16 := colonna[15] */
        mcDati.row.colonna16 = colonna[15];
        /* mcDati.colonna17 := colonna[16] */
        mcDati.row.colonna17 = colonna[16];
        /* mcDati.colonna18 := colonna[17] */
        mcDati.row.colonna18 = colonna[17];
        /* mcDati.SaveRow() */
        mcDati.SaveRow();
      } // End If
      // Chiude i cicli
        }
      }
      workbook.close();
      //?FileLibMit.DeleteFile("appo/"+CPLib.LRTrim(gAzienda)+"/"+nomefile);
      conta=1;
      /* _commit := FileLibMit.DeleteFile("appo/"+LRTrim(gAzienda)+"/"+nomefile) // ok alla commit */
      _commit = FileLibMit.DeleteFile("appo/"+CPLib.LRTrim(gAzienda)+"/"+nomefile);
      // * --- Fill memory cursor mcWersonbo on wersonbo
      mcWersonbo.Zap();
      m_cServer = m_Ctx.GetServer("wersonbo");
      m_cPhName = m_Ctx.GetPhName("wersonbo");
      if (Cursor_wersonbo!=null)
        Cursor_wersonbo.Close();
      Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"datamodi="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_DATARETT,"?",0,0,m_cServer, m_oParameters),m_cServer,w_DATARETT)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_wersonbo;
        Cursor_wersonbo.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_import_correzioni_sv: query on wersonbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
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
      for (MemoryCursorRow_mcdatistru_mcrdef rowDati : mcDati._iterable_()) {
        /* If not(Empty(rowDati.colonna1) or Empty(rowDati.colonna8)) */
        if ( ! (CPLib.Empty(rowDati.colonna1) || CPLib.Empty(rowDati.colonna8))) {
          /* _numprog := rowDati.colonna1 */
          _numprog = rowDati.colonna1;
          /* _idbase := '' */
          _idbase = "";
          /* gMsgImp := 'Elaboro '+iif(rowDati.colonna14='F','frazionata','operazione')+" con progressivo n. "+_numprog + " (riga "+LRTrim(Str(conta,10,0)) + " di " + LRTrim(Str(riga_letta,10,0)) + ")" */
          gMsgImp = "Elaboro "+(CPLib.eqr(rowDati.colonna14,"F")?"frazionata":"operazione")+" con progressivo n. "+_numprog+" (riga "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" di "+CPLib.LRTrim(CPLib.Str(riga_letta,10,0))+")";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Read from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          m_cSql = "";
          m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowDati.colonna8,"C",16,0,m_cServer),m_cServer,rowDati.colonna8);
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
              Error l_oErrorFault = new Error("Read on personbo into routine arrt_import_correzioni_sv returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _ragsoc = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(_ragsoc) */
          if (CPLib.Empty(_ragsoc)) {
            // Transaction Error
            m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"id base non trovato"));
          } else { // Else
            /* If not(mcWersonbo.HasKey(rowDati.colonna8)) */
            if ( ! (mcWersonbo.HasKey(rowDati.colonna8))) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LTrim(rowDati.colonna8),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.LTrim(rowDati.colonna8))+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              {
                final CPResultSet m_TheCursor = Cursor_personbo;
                Cursor_personbo.ActionOnClose(new Runnable() {
                  public void run() {
                    if (CPLib.gt(m_TheCursor.CurrentRow()-1,1*1.1)) {
                      com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                      if ( ! (CPLib.IsNull(info))) {
                        info.log("Routine arrt_import_correzioni_sv: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1");
                      }
                    }
                  }
                  });
              }
              while ( ! (Cursor_personbo.Eof())) {
                /* If personbo->PROVINCIA<>LRTrim(rowDati.colonna11) or personbo->SOTGRUP <> LRTrim(rowDati.colonna10) or personbo->PAESE<>LRTrim(rowDati.colonna17) or personbo->DESCCIT<>LRTrim(rowDati.colonna18) */
                if (CPLib.ne(Cursor_personbo.GetString("PROVINCIA"),CPLib.LRTrim(rowDati.colonna11)) || CPLib.ne(Cursor_personbo.GetString("SOTGRUP"),CPLib.LRTrim(rowDati.colonna10)) || CPLib.ne(Cursor_personbo.GetString("PAESE"),CPLib.LRTrim(rowDati.colonna17)) || CPLib.ne(Cursor_personbo.GetString("DESCCIT"),CPLib.LRTrim(rowDati.colonna18))) {
                  /* _ateco := personbo->ATTIV */
                  _ateco = Cursor_personbo.GetString("ATTIV");
                  /* _ramo := personbo->RAMOGRUP */
                  _ramo = Cursor_personbo.GetString("RAMOGRUP");
                  /* _stgrup := LRTrim(rowDati.colonna10) */
                  _stgrup = CPLib.LRTrim(rowDati.colonna10);
                  /* _settsint := '' */
                  _settsint = "";
                  /* Exec "Settore Sintetico" Page 4:Settore */
                  Settore();
                  /* cProgSto := Utilities.GetAutonumber("PSTOPERS\'"+LRTrim(gAzienda)+"'","",15) */
                  cProgSto = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PSTOPERS\\'"+CPLib.LRTrim(gAzienda)+"'","",15);
                  // * --- Insert into wersonbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("wersonbo");
                  m_cPhName = m_Ctx.GetPhName("wersonbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_import_correzioni_sv",137,"0000011A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_0000011A(m_Ctx,m_oWrInfo);
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
                  m_cSql = m_cSql+""+CPLib.ToSQL(w_DATARETT,"?",0,0)+", ";
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
                  }
                  // * --- Write into personbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_import_correzioni_sv",137,"0000011B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(CPLib.LRTrim(rowDati.colonna11),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(CPLib.LRTrim(rowDati.colonna10),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(_settsint,"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(CPLib.LRTrim(rowDati.colonna17),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.LRTrim(rowDati.colonna18),"C",30,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer),m_cServer,Cursor_personbo.GetString("CONNES"))+"";
                  m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  {
                    if (CPLib.gt(m_nUpdatedRows,1*1.1)) {
                      com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                      if ( ! (CPLib.IsNull(info))) {
                        info.log("Routine arrt_import_correzioni_sv: Write on personbo updates "+(m_nUpdatedRows)+" rows larger then the expected 1");
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
                  }
                  /* mcWersonbo.AppendWithKey(rowDati.colonna8) */
                  mcWersonbo.AppendWithKey(rowDati.colonna8);
                  /* mcWersonbo.connes := rowDati.colonna8 */
                  mcWersonbo.row.connes = rowDati.colonna8;
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
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LTrim(rowDati.colonna8),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.LTrim(rowDati.colonna8))+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              {
                final CPResultSet m_TheCursor = Cursor_personbo;
                Cursor_personbo.ActionOnClose(new Runnable() {
                  public void run() {
                    if (CPLib.gt(m_TheCursor.CurrentRow()-1,1*1.1)) {
                      com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                      if ( ! (CPLib.IsNull(info))) {
                        info.log("Routine arrt_import_correzioni_sv: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1");
                      }
                    }
                  }
                  });
              }
              while ( ! (Cursor_personbo.Eof())) {
                /* If personbo->PROVINCIA<>LRTrim(rowDati.colonna11) or personbo->SOTGRUP <> LRTrim(rowDati.colonna10) or personbo->PAESE<>LRTrim(rowDati.colonna17) or personbo->DESCCIT<>LRTrim(rowDati.colonna18) */
                if (CPLib.ne(Cursor_personbo.GetString("PROVINCIA"),CPLib.LRTrim(rowDati.colonna11)) || CPLib.ne(Cursor_personbo.GetString("SOTGRUP"),CPLib.LRTrim(rowDati.colonna10)) || CPLib.ne(Cursor_personbo.GetString("PAESE"),CPLib.LRTrim(rowDati.colonna17)) || CPLib.ne(Cursor_personbo.GetString("DESCCIT"),CPLib.LRTrim(rowDati.colonna18))) {
                  /* _ateco := personbo->ATTIV */
                  _ateco = Cursor_personbo.GetString("ATTIV");
                  /* _ramo := personbo->RAMOGRUP */
                  _ramo = Cursor_personbo.GetString("RAMOGRUP");
                  /* _stgrup := LRTrim(rowDati.colonna10) */
                  _stgrup = CPLib.LRTrim(rowDati.colonna10);
                  /* _settsint := '' */
                  _settsint = "";
                  /* Exec "Settore Sintetico" Page 4:Settore */
                  Settore();
                  // * --- Write into personbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_import_correzioni_sv",137,"00000126")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(CPLib.LRTrim(rowDati.colonna11),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(CPLib.LRTrim(rowDati.colonna10),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(_settsint,"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(CPLib.LRTrim(rowDati.colonna17),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.LRTrim(rowDati.colonna18),"C",30,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer),m_cServer,Cursor_personbo.GetString("CONNES"))+"";
                  m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  {
                    if (CPLib.gt(m_nUpdatedRows,1*1.1)) {
                      com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                      if ( ! (CPLib.IsNull(info))) {
                        info.log("Routine arrt_import_correzioni_sv: Write on personbo updates "+(m_nUpdatedRows)+" rows larger then the expected 1");
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
                  }
                } // End If
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
            } // End If
          } // End If
        } // End If
        /* conta := conta + 1 */
        conta = conta+1;
      }
    } finally {
      try {
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
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
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Settore() throws Exception {
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
    m_MessageSink = new CPAsyncRoutine.AsyncSink();
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
    ,m_MessageSink
    );
  }
  public Forward Run(String p_nomefile) {
    nomefile = p_nomefile;
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
          StartPage();
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
  public static arrt_import_correzioni_svR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_import_correzioni_svR(p_Ctx, p_Caller);
  }
  public void Blank() {
    nomefile = CPLib.Space(30);
    column01 = CPLib.Space(11);
    column02 = CPLib.Space(25);
    column02num = 0;
    column02date = CPLib.NullDate();
    column03 = CPLib.Space(1);
    column04 = CPLib.Space(6);
    column05 = CPLib.Space(25);
    column06 = CPLib.Space(2);
    column07 = CPLib.Space(3);
    column08 = CPLib.Space(16);
    column09 = CPLib.Space(70);
    column10 = CPLib.Space(3);
    column11 = CPLib.Space(2);
    column12num = 0;
    column13 = CPLib.Space(3);
    column14 = CPLib.Space(1);
    column15 = CPLib.Space(9);
    column16 = CPLib.Space(30);
    column17 = CPLib.Space(3);
    column18 = CPLib.Space(30);
    _commit = false;
    _falied = false;
    riga_letta = 0;
    riga_letta_c = CPLib.Space(9);
    date_base_excel = CPLib.NullDate();
    ncol = 0;
    foglio = 0;
    foglio_c = CPLib.Space(9);
    cProgSto = CPLib.Space(15);
    w_DATARETT = CPLib.NullDate();
    cCanc = CPLib.Space(10);
    cProg = CPLib.Space(10);
    _progrig = CPLib.Space(10);
    mcDati = new MemoryCursor_mcdatistru_mcrdef();
    mcWersonbo = new MemoryCursor_mcconnes_mcrdef();
    mcSettori = new MemoryCursor_qbe_setsin_vqr();
    mcSetSina = new MemoryCursor_tbsetsina();
    _idbase = CPLib.Space(10);
    _statoreg = CPLib.Space(1);
    cNewProg = CPLib.Space(10);
    _idereg = CPLib.Space(20);
    _idbase2 = CPLib.Space(10);
    _cab = CPLib.Space(6);
    stringaflagrap2 = CPLib.Space(10);
    _flagrap2 = CPLib.Space(1);
    _desccit = CPLib.Space(30);
    _numprog = CPLib.Space(11);
    _stgrup = CPLib.Space(3);
    cell_type = 0;
    nota = CPLib.Space(100);
    modifica = false;
    _idbase_ang = CPLib.Space(16);
    _connes = CPLib.Space(16);
    _ragsoc = CPLib.Space(70);
    _cf = CPLib.Space(16);
    _ateco = CPLib.Space(10);
    _ramo = CPLib.Space(3);
    _settsint = CPLib.Space(3);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_setsin,
  public static final String m_cVQRList = ",qbe_setsin,";
  // ENTITY_BATCHES: ,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,";
  public static String[] m_cRunParameterNames={"nomefile"};
  protected static String GetFieldsName_000000B6(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_000000D9(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_RAPPORTO,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CONNALTRO,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"DUCOLLEG,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"IMPOUT,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"IPCOLLEG,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"MTCN,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"ORACOLLEG,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PAGASOGOP,";
    p_cSql = p_cSql+"PRGIMPFRZ,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"IMPIN,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"fraziobo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000E2(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_RAPPORTO,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CONNALTRO,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"DUCOLLEG,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"IPCOLLEG,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"MTCN,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"ORACOLLEG,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PAGASOGOP,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"IMPIN,";
    p_cSql = p_cSql+"IMPOUT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000011A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
