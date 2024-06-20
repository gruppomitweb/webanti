// * --- Area Manuale = BO - Header
// * --- arrt_import_masscf
import java.util.*;
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
// * --- Fine Area Manuale
public class arrt_import_masscfR implements CallerWithObjs {
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
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_personbo_agg;
  public String m_cServer_personbo_agg;
  public String m_cPhName_tmp_list_imprich;
  public String m_cServer_tmp_list_imprich;
  public String m_cPhName_tmp_scarti;
  public String m_cServer_tmp_scarti;
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_aesaldi;
  public String m_cServer_aesaldi;
  public String m_cPhName_tmp_esitosid;
  public String m_cServer_tmp_esitosid;
  public String m_cPhName_kersonbo;
  public String m_cServer_kersonbo;
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
  public String w_nomefile;
  public String w_flgfam;
  public String w_flganf;
  public String w_flgant;
  public String w_flgxls;
  public String w_flgexa;
  public String w_flgcst;
  public String fhand;
  public String riga;
  public double cNumNew;
  public double cNumMod;
  public String nomefileimport;
  public double nProgImp;
  public String _connes;
  public String _ragsoc;
  public String _codfisc;
  public String _esito;
  public double _cfestero;
  public String _nprog;
  public String _nomefileesi;
  public MemoryCursor_mcerrmcf_mcrdef mcErrori;
  public MemoryCursor_mcscartimcf_mcrdef mcScarti;
  public MemoryCursor_mcscartimcf_mcrdef mcScartiFin;
  public MemoryCursor_mcxlsritmcf_mcrdef mcXLSIMP;
  public String _nfile;
  public double _contar;
  public double _conta;
  public double _conta2;
  public java.sql.Date _dnas;
  public String _sesso;
  public String _nasstato;
  public String _nascomun;
  public String _oldcon;
  public double _npers;
  public String _risultato;
  public String _protocollo;
  public String _fileprot;
  public String _descrsid;
  public String _tipodoc;
  public double _nriga;
  public String _txtstp;
  public String gPathApp;
  public String gPathDoc;
  public String gUrlApp;
  public String gAzienda;
  public String gMsgImp;
  public String gMsgProc;
  public double w_tiporep;
  public String w_flgwuker;
  public String w_flgwrong;
  public String w_filexls;
  public String w_flgagg;
  public String cRitorno;
  public String _ndg1;
  public String _cfs1;
  public String _ndg2;
  public String _cfs2;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_import_masscf
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
  // * --- Fine Area Manuale
  public arrt_import_masscfR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_import_masscf",m_Caller);
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_personbo_agg = p_ContextObject.GetPhName("personbo_agg");
    if (m_cPhName_personbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo_agg = m_cPhName_personbo_agg+" "+m_Ctx.GetWritePhName("personbo_agg");
    }
    m_cServer_personbo_agg = p_ContextObject.GetServer("personbo_agg");
    m_cPhName_tmp_list_imprich = p_ContextObject.GetPhName("tmp_list_imprich");
    if (m_cPhName_tmp_list_imprich.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_list_imprich = m_cPhName_tmp_list_imprich+" "+m_Ctx.GetWritePhName("tmp_list_imprich");
    }
    m_cServer_tmp_list_imprich = p_ContextObject.GetServer("tmp_list_imprich");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_scarti")) {
      m_cPhName_tmp_scarti = p_ContextObject.GetPhName("tmp_scarti");
      if (m_cPhName_tmp_scarti.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_scarti = m_cPhName_tmp_scarti+" "+m_Ctx.GetWritePhName("tmp_scarti");
      }
      m_cServer_tmp_scarti = p_ContextObject.GetServer("tmp_scarti");
    }
    m_cPhName_opextrbo = p_ContextObject.GetPhName("opextrbo");
    if (m_cPhName_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_opextrbo = m_cPhName_opextrbo+" "+m_Ctx.GetWritePhName("opextrbo");
    }
    m_cServer_opextrbo = p_ContextObject.GetServer("opextrbo");
    m_cPhName_aesaldi = p_ContextObject.GetPhName("aesaldi");
    if (m_cPhName_aesaldi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aesaldi = m_cPhName_aesaldi+" "+m_Ctx.GetWritePhName("aesaldi");
    }
    m_cServer_aesaldi = p_ContextObject.GetServer("aesaldi");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_esitosid")) {
      m_cPhName_tmp_esitosid = p_ContextObject.GetPhName("tmp_esitosid");
      if (m_cPhName_tmp_esitosid.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_esitosid = m_cPhName_tmp_esitosid+" "+m_Ctx.GetWritePhName("tmp_esitosid");
      }
      m_cServer_tmp_esitosid = p_ContextObject.GetServer("tmp_esitosid");
    }
    m_cPhName_kersonbo = p_ContextObject.GetPhName("kersonbo");
    if (m_cPhName_kersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_kersonbo = m_cPhName_kersonbo+" "+m_Ctx.GetWritePhName("kersonbo");
    }
    m_cServer_kersonbo = p_ContextObject.GetServer("kersonbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("cNumNew",p_cVarName)) {
      return cNumNew;
    }
    if (CPLib.eqr("cNumMod",p_cVarName)) {
      return cNumMod;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      return nProgImp;
    }
    if (CPLib.eqr("_cfestero",p_cVarName)) {
      return _cfestero;
    }
    if (CPLib.eqr("_contar",p_cVarName)) {
      return _contar;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_conta2",p_cVarName)) {
      return _conta2;
    }
    if (CPLib.eqr("_npers",p_cVarName)) {
      return _npers;
    }
    if (CPLib.eqr("_nriga",p_cVarName)) {
      return _nriga;
    }
    if (CPLib.eqr("tiporep",p_cVarName)) {
      return w_tiporep;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_import_masscf";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      return w_nomefile;
    }
    if (CPLib.eqr("flgfam",p_cVarName)) {
      return w_flgfam;
    }
    if (CPLib.eqr("flganf",p_cVarName)) {
      return w_flganf;
    }
    if (CPLib.eqr("flgant",p_cVarName)) {
      return w_flgant;
    }
    if (CPLib.eqr("flgxls",p_cVarName)) {
      return w_flgxls;
    }
    if (CPLib.eqr("flgexa",p_cVarName)) {
      return w_flgexa;
    }
    if (CPLib.eqr("flgcst",p_cVarName)) {
      return w_flgcst;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      return riga;
    }
    if (CPLib.eqr("nomefileimport",p_cVarName)) {
      return nomefileimport;
    }
    if (CPLib.eqr("_connes",p_cVarName)) {
      return _connes;
    }
    if (CPLib.eqr("_ragsoc",p_cVarName)) {
      return _ragsoc;
    }
    if (CPLib.eqr("_codfisc",p_cVarName)) {
      return _codfisc;
    }
    if (CPLib.eqr("_esito",p_cVarName)) {
      return _esito;
    }
    if (CPLib.eqr("_nprog",p_cVarName)) {
      return _nprog;
    }
    if (CPLib.eqr("_nomefileesi",p_cVarName)) {
      return _nomefileesi;
    }
    if (CPLib.eqr("_nfile",p_cVarName)) {
      return _nfile;
    }
    if (CPLib.eqr("_sesso",p_cVarName)) {
      return _sesso;
    }
    if (CPLib.eqr("_nasstato",p_cVarName)) {
      return _nasstato;
    }
    if (CPLib.eqr("_nascomun",p_cVarName)) {
      return _nascomun;
    }
    if (CPLib.eqr("_oldcon",p_cVarName)) {
      return _oldcon;
    }
    if (CPLib.eqr("_risultato",p_cVarName)) {
      return _risultato;
    }
    if (CPLib.eqr("_protocollo",p_cVarName)) {
      return _protocollo;
    }
    if (CPLib.eqr("_fileprot",p_cVarName)) {
      return _fileprot;
    }
    if (CPLib.eqr("_descrsid",p_cVarName)) {
      return _descrsid;
    }
    if (CPLib.eqr("_tipodoc",p_cVarName)) {
      return _tipodoc;
    }
    if (CPLib.eqr("_txtstp",p_cVarName)) {
      return _txtstp;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      return gPathDoc;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("flgwuker",p_cVarName)) {
      return w_flgwuker;
    }
    if (CPLib.eqr("flgwrong",p_cVarName)) {
      return w_flgwrong;
    }
    if (CPLib.eqr("filexls",p_cVarName)) {
      return w_filexls;
    }
    if (CPLib.eqr("flgagg",p_cVarName)) {
      return w_flgagg;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      return cRitorno;
    }
    if (CPLib.eqr("_ndg1",p_cVarName)) {
      return _ndg1;
    }
    if (CPLib.eqr("_cfs1",p_cVarName)) {
      return _cfs1;
    }
    if (CPLib.eqr("_ndg2",p_cVarName)) {
      return _ndg2;
    }
    if (CPLib.eqr("_cfs2",p_cVarName)) {
      return _cfs2;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_dnas",p_cVarName)) {
      return _dnas;
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
    if (CPLib.eqr("mcErrori",p_cVarName)) {
      return mcErrori;
    }
    if (CPLib.eqr("mcScarti",p_cVarName)) {
      return mcScarti;
    }
    if (CPLib.eqr("mcScartiFin",p_cVarName)) {
      return mcScartiFin;
    }
    if (CPLib.eqr("mcXLSIMP",p_cVarName)) {
      return mcXLSIMP;
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
    if (CPLib.eqr("cNumNew",p_cVarName)) {
      cNumNew = value;
      return;
    }
    if (CPLib.eqr("cNumMod",p_cVarName)) {
      cNumMod = value;
      return;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      nProgImp = value;
      return;
    }
    if (CPLib.eqr("_cfestero",p_cVarName)) {
      _cfestero = value;
      return;
    }
    if (CPLib.eqr("_contar",p_cVarName)) {
      _contar = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
    if (CPLib.eqr("_conta2",p_cVarName)) {
      _conta2 = value;
      return;
    }
    if (CPLib.eqr("_npers",p_cVarName)) {
      _npers = value;
      return;
    }
    if (CPLib.eqr("_nriga",p_cVarName)) {
      _nriga = value;
      return;
    }
    if (CPLib.eqr("tiporep",p_cVarName)) {
      w_tiporep = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("nomefile",p_cVarName)) {
      w_nomefile = value;
      return;
    }
    if (CPLib.eqr("flgfam",p_cVarName)) {
      w_flgfam = value;
      return;
    }
    if (CPLib.eqr("flganf",p_cVarName)) {
      w_flganf = value;
      return;
    }
    if (CPLib.eqr("flgant",p_cVarName)) {
      w_flgant = value;
      return;
    }
    if (CPLib.eqr("flgxls",p_cVarName)) {
      w_flgxls = value;
      return;
    }
    if (CPLib.eqr("flgexa",p_cVarName)) {
      w_flgexa = value;
      return;
    }
    if (CPLib.eqr("flgcst",p_cVarName)) {
      w_flgcst = value;
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
    if (CPLib.eqr("nomefileimport",p_cVarName)) {
      nomefileimport = value;
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
    if (CPLib.eqr("_codfisc",p_cVarName)) {
      _codfisc = value;
      return;
    }
    if (CPLib.eqr("_esito",p_cVarName)) {
      _esito = value;
      return;
    }
    if (CPLib.eqr("_nprog",p_cVarName)) {
      _nprog = value;
      return;
    }
    if (CPLib.eqr("_nomefileesi",p_cVarName)) {
      _nomefileesi = value;
      return;
    }
    if (CPLib.eqr("_nfile",p_cVarName)) {
      _nfile = value;
      return;
    }
    if (CPLib.eqr("_sesso",p_cVarName)) {
      _sesso = value;
      return;
    }
    if (CPLib.eqr("_nasstato",p_cVarName)) {
      _nasstato = value;
      return;
    }
    if (CPLib.eqr("_nascomun",p_cVarName)) {
      _nascomun = value;
      return;
    }
    if (CPLib.eqr("_oldcon",p_cVarName)) {
      _oldcon = value;
      return;
    }
    if (CPLib.eqr("_risultato",p_cVarName)) {
      _risultato = value;
      return;
    }
    if (CPLib.eqr("_protocollo",p_cVarName)) {
      _protocollo = value;
      return;
    }
    if (CPLib.eqr("_fileprot",p_cVarName)) {
      _fileprot = value;
      return;
    }
    if (CPLib.eqr("_descrsid",p_cVarName)) {
      _descrsid = value;
      return;
    }
    if (CPLib.eqr("_tipodoc",p_cVarName)) {
      _tipodoc = value;
      return;
    }
    if (CPLib.eqr("_txtstp",p_cVarName)) {
      _txtstp = value;
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
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      gUrlApp = value;
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
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
      return;
    }
    if (CPLib.eqr("flgwuker",p_cVarName)) {
      w_flgwuker = value;
      return;
    }
    if (CPLib.eqr("flgwrong",p_cVarName)) {
      w_flgwrong = value;
      return;
    }
    if (CPLib.eqr("filexls",p_cVarName)) {
      w_filexls = value;
      return;
    }
    if (CPLib.eqr("flgagg",p_cVarName)) {
      w_flgagg = value;
      return;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      cRitorno = value;
      return;
    }
    if (CPLib.eqr("_ndg1",p_cVarName)) {
      _ndg1 = value;
      return;
    }
    if (CPLib.eqr("_cfs1",p_cVarName)) {
      _cfs1 = value;
      return;
    }
    if (CPLib.eqr("_ndg2",p_cVarName)) {
      _ndg2 = value;
      return;
    }
    if (CPLib.eqr("_cfs2",p_cVarName)) {
      _cfs2 = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("_dnas",p_cVarName)) {
      _dnas = value;
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
    if (CPLib.eqr("mcErrori",p_cVarName)) {
      mcErrori = (MemoryCursor_mcerrmcf_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcScarti",p_cVarName)) {
      mcScarti = (MemoryCursor_mcscartimcf_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcScartiFin",p_cVarName)) {
      mcScartiFin = (MemoryCursor_mcscartimcf_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcXLSIMP",p_cVarName)) {
      mcXLSIMP = (MemoryCursor_mcxlsritmcf_mcrdef)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    /* w_nomefile Char(80) */
    /* w_flgfam Char(1) */
    /* w_flganf Char(1) */
    /* w_flgant Char(1) */
    /* w_flgxls Char(1) */
    /* w_flgexa Char(1) */
    /* w_flgcst Char(1) */
    /* fhand Char(1) // Handle file testo */
    /* riga Memo // Riga file testo */
    /* cNumNew Numeric(10, 0) // Contatore record nuovi */
    /* cNumMod Numeric(10, 0) // Contatore record aggiornati */
    /* nomefileimport Char(50) // Nome File Import */
    /* nProgImp Numeric(15, 0) // Identificativo Soggetto */
    /* _connes Char(16) // Connes del soggetto */
    /* _ragsoc Char(70) // Nominativo */
    /* _codfisc Char(16) // Codice Fiscale */
    /* _esito Char(4) // Codice Esito */
    /* _cfestero Numeric(1, 0) */
    /* _nprog Char(15) */
    /* _nomefileesi Char(80) */
    /* mcErrori MemoryCursor(mcErrMCF.MCRDef) */
    /* mcScarti MemoryCursor(mcScartiMCF.MCRDef) */
    /* mcScartiFin MemoryCursor(mcScartiMCF.MCRDef) */
    /* mcXLSIMP MemoryCursor(mcXLSRITMCF.MCRDef) */
    /* _nfile Char(50) */
    /* _contar Numeric(7, 0) */
    /* _conta Numeric(7, 0) */
    /* _conta2 Numeric(7, 0) */
    /* _dnas Date */
    /* _sesso Char(1) */
    /* _nasstato Char(30) */
    /* _nascomun Char(30) */
    /* _oldcon Char(16) */
    /* _npers Numeric(2, 0) */
    /* _risultato Char(3) */
    /* _protocollo Char(24) */
    /* _fileprot Char(50) */
    /* _descrsid Char(90) */
    /* _tipodoc Char(1) */
    /* _nriga Numeric(10, 0) */
    /* _txtstp Memo */
    /* gPathApp Char(80) // Path Applicazione */
    /* gPathDoc Char(80) // Path Applicazione */
    /* gUrlApp Char(80) // Path Applicazione */
    /* gAzienda Char(10) // Azienda */
    /* gMsgImp Char(120) // Messaggio Import */
    /* gMsgProc Memo // Log Elaborazione */
    /* Legge dati intermediario per metteri su operazbo,fraziobo,rapopebo se mancanti */
    /* w_tiporep Numeric(1, 0) */
    /* w_flgwuker Char(1) */
    /* w_flgwrong Char(1) */
    /* w_filexls Char(80) */
    /* w_flgagg Char(1) */
    /* cRitorno Char(80) */
    /* Import Soggetti */
    /* gMsgProc := '' */
    gMsgProc = "";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* Cicla sul file della lista e lancia la pagina appropriata */
    // Begin Transaction
    m_Sql.RequireTransaction();
    double nTry0000003Estatus;
    nTry0000003Estatus = m_Sql.GetTransactionStatus();
    String cTry0000003Emsg;
    cTry0000003Emsg = m_Sql.TransactionErrorMessage();
    try {
      /* gMsgProc := 'Ora Inizio Elaborazione: '+ arfn_fdatetime(DateTime()) + NL // Log Elaborazione */
      gMsgProc = "Ora Inizio Elaborazione: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* nomefileimport := LRTrim(w_nomefile) // Nome File Import */
      nomefileimport = CPLib.LRTrim(w_nomefile);
      /* If At('.RUN',Upper(nomefileimport)) <> 0 */
      if (CPLib.ne(CPLib.At(".RUN",CPLib.Upper(nomefileimport)),0)) {
        // * --- Drop temporary table tmp_esitosid
        if (m_Ctx.IsSharedTemp("tmp_esitosid")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_esitosid")) {
            m_cServer = m_Ctx.GetServer("tmp_esitosid");
            m_cPhName = m_Ctx.GetPhName("tmp_esitosid");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_esitosid");
        }
        // * --- Create temporary table tmp_esitosid
        if (m_Ctx.IsSharedTemp("tmp_esitosid")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_esitosid")) {
            m_cServer = m_Ctx.GetServer("tmp_esitosid");
            m_cPhName = m_Ctx.GetPhName("tmp_esitosid");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_esitosid");
        }
        m_cPhName = m_Ctx.CreateTmpPhName("tmp_esitosid");
        if ( ! (m_Ctx.IsSharedTemp("tmp_esitosid"))) {
          m_cServer = m_Ctx.GetServer("tmp_esitosid");
          m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_esitosid",m_cServer,"proto")),m_cPhName,"tmp_esitosid",m_Ctx);
        }
        m_cPhName_tmp_esitosid = m_cPhName;
        /* fhand := FileLibMit.OpenRead('newtab/Ricevuta_masscf.txt') // Handle file testo */
        fhand = FileLibMit.OpenRead("newtab/Ricevuta_masscf.txt");
        /* While not(FileLibMit.Eof(fhand)) */
        while ( ! (FileLibMit.Eof(fhand))) {
          /* riga := FileLibMit.ReadLine(fhand) // Riga file testo */
          riga = FileLibMit.ReadLine(fhand);
          /* If Len(LRTrim(riga)) > 0 */
          if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* mcErrori.AppendWithKey(Left(riga,3)) */
            mcErrori.AppendWithKey(CPLib.Left(riga,3));
            /* mcErrori.ERCODICE := Left(riga,3) */
            mcErrori.row.ERCODICE = CPLib.Left(riga,3);
            /* mcErrori.ERDESCRI := Substr(riga,4,90) */
            mcErrori.row.ERDESCRI = CPLib.Substr(riga,4,90);
            /* mcErrori.SaveRow() */
            mcErrori.SaveRow();
          } // End If
        } // End While
        /* FileLibMit.Close(fhand) */
        FileLibMit.Close(fhand);
        /* fhand := FileLibMit.OpenReadPath(LRTrim(gPathDoc)+'/appo/'+LRTrim(gAzienda)+"/"+LRTrim(nomefileimport)) // Handle file testo */
        fhand = FileLibMit.OpenReadPath(CPLib.LRTrim(gPathDoc)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(nomefileimport));
        /* Exec "Lettura Ricevuta" Page 5:Page_5 */
        Page_5();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* FileLibMit.Close(fhand) */
        FileLibMit.Close(fhand);
        /* FileLibMit.DeleteFile(LRTrim(gPathDoc)+'/appo/'+LRTrim(gAzienda)+"/"+LRTrim(nomefileimport)) */
        FileLibMit.DeleteFile(CPLib.LRTrim(gPathDoc)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(nomefileimport));
      } else { // Else
        // * --- Drop temporary table tmp_scarti
        if (m_Ctx.IsSharedTemp("tmp_scarti")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_scarti")) {
            m_cServer = m_Ctx.GetServer("tmp_scarti");
            m_cPhName = m_Ctx.GetPhName("tmp_scarti");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_scarti");
        }
        // * --- Create temporary table tmp_scarti
        if (m_Ctx.IsSharedTemp("tmp_scarti")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_scarti")) {
            m_cServer = m_Ctx.GetServer("tmp_scarti");
            m_cPhName = m_Ctx.GetPhName("tmp_scarti");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_scarti");
        }
        m_cPhName = m_Ctx.CreateTmpPhName("tmp_scarti");
        if ( ! (m_Ctx.IsSharedTemp("tmp_scarti"))) {
          m_cServer = m_Ctx.GetServer("tmp_scarti");
          m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_scarti",m_cServer,"proto")),m_cPhName,"tmp_scarti",m_Ctx);
        }
        m_cPhName_tmp_scarti = m_cPhName;
        /* w_flgagg := 'N' */
        w_flgagg = "N";
        /* fhand := FileLibMit.OpenRead('newtab/Errori_masscf.txt') // Handle file testo */
        fhand = FileLibMit.OpenRead("newtab/Errori_masscf.txt");
        /* While not(FileLibMit.Eof(fhand)) */
        while ( ! (FileLibMit.Eof(fhand))) {
          /* riga := FileLibMit.ReadLine(fhand) // Riga file testo */
          riga = FileLibMit.ReadLine(fhand);
          /* If Len(LRTrim(riga)) > 0 */
          if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* mcErrori.AppendWithKey(Left(riga,4)) */
            mcErrori.AppendWithKey(CPLib.Left(riga,4));
            /* mcErrori.ERCODICE := Left(riga,4) */
            mcErrori.row.ERCODICE = CPLib.Left(riga,4);
            /* mcErrori.ERDESCRI := Substr(riga,6,68) */
            mcErrori.row.ERDESCRI = CPLib.Substr(riga,6,68);
            /* mcErrori.ERTESTO := Substr(riga,75,210) */
            mcErrori.row.ERTESTO = CPLib.Substr(riga,75,210);
            /* mcErrori.ERAZIONE := Substr(riga,286,80) */
            mcErrori.row.ERAZIONE = CPLib.Substr(riga,286,80);
            /* mcErrori.SaveRow() */
            mcErrori.SaveRow();
          } // End If
        } // End While
        /* FileLibMit.Close(fhand) */
        FileLibMit.Close(fhand);
        /* FileLibMit.FileCopy(LRTrim(gPathDoc)+'/appo/'+LRTrim(gAzienda)+"/"+LRTrim(nomefileimport),LRTrim(gPathDoc)+'/SID/MASSCFR/ELB/'+LRTrim(gAzienda)+"/"+nomefileimport) */
        FileLibMit.FileCopy(CPLib.LRTrim(gPathDoc)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(nomefileimport),CPLib.LRTrim(gPathDoc)+"/SID/MASSCFR/ELB/"+CPLib.LRTrim(gAzienda)+"/"+nomefileimport);
        /* FileLibMit.DeleteFile(LRTrim(gPathDoc)+'/appo/'+LRTrim(gAzienda)+"/"+LRTrim(nomefileimport)) */
        FileLibMit.DeleteFile(CPLib.LRTrim(gPathDoc)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(nomefileimport));
        /* _nomefileesi := arfn_exec_sid_sm_ric(nomefileimport) */
        _nomefileesi = arfn_exec_sid_sm_ricR.Make(m_Ctx,this).Run(nomefileimport);
        /* If not(Empty(_nomefileesi)) */
        if ( ! (CPLib.Empty(_nomefileesi))) {
          /* Exec "Lettura File" Page 2:Page_2 */
          Page_2();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* If mcScarti.RecCount() > 0 */
          if (CPLib.gt(mcScarti.RecCount(),0)) {
            /* gMsgProc := gMsgProc + 'Ora Inizio Scrittura File Scarti: '+ arfn_fdatetime(DateTime()) + NL // Log Elaborazione */
            gMsgProc = gMsgProc+"Ora Inizio Scrittura File Scarti: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            for (MemoryCursorRow_mcscartimcf_mcrdef rowScarti : mcScarti._iterable_()) {
              // * --- Insert into tmp_scarti from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_scarti");
              m_cPhName = m_Ctx.GetPhName("tmp_scarti");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_scarti",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_masscf",940,"0000006B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000006B(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowScarti.ERCONNES,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowScarti.ERRAGSOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowScarti.ERCODFIS,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowScarti.ERCODICE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowScarti.ERDESCRI,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowScarti.ERTESTO,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowScarti.ERAZIONE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_scarti",true);
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
            }
            /* gMsgProc := gMsgProc + 'Ora Fine Scrittura File Scarti: '+ arfn_fdatetime(DateTime()) + NL // Log Elaborazione */
            gMsgProc = gMsgProc+"Ora Fine Scrittura File Scarti: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } // End If
          /* If w_flgxls='S' */
          if (CPLib.eqr(w_flgxls,"S")) {
            /* gMsgProc := gMsgProc + 'Ora Inizio Scrittura File Excel: '+ arfn_fdatetime(DateTime()) + NL // Log Elaborazione */
            gMsgProc = gMsgProc+"Ora Inizio Scrittura File Excel: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* Exec "Scrittura File Excel" Page 3:Page_3 */
            Page_3();
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
              throw new RoutineException();
            }
            /* gMsgProc := gMsgProc + 'Ora Fine Scrittura File Excel: '+ arfn_fdatetime(DateTime()) + NL // Log Elaborazione */
            gMsgProc = gMsgProc+"Ora Fine Scrittura File Excel: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* w_filexls := LRTrim(nomefileimport)+".xlsx" */
            w_filexls = CPLib.LRTrim(nomefileimport)+".xlsx";
            /* cRitorno := w_filexls */
            cRitorno = w_filexls;
          } // End If
          /* If w_flgwrong='S' */
          if (CPLib.eqr(w_flgwrong,"S")) {
            /* gMsgProc := gMsgProc + 'Ora Inizio Scrittura File Excel: '+ arfn_fdatetime(DateTime()) + NL // Log Elaborazione */
            gMsgProc = gMsgProc+"Ora Inizio Scrittura File Excel: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* Exec "File Excel Associati errati" Page 4:Page_4 */
            Page_4();
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
              throw new RoutineException();
            }
            /* gMsgProc := gMsgProc + 'Ora Fine Scrittura File Excel: '+ arfn_fdatetime(DateTime()) + NL // Log Elaborazione */
            gMsgProc = gMsgProc+"Ora Fine Scrittura File Excel: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* w_filexls := LRTrim(nomefileimport)+".xlsx" */
            w_filexls = CPLib.LRTrim(nomefileimport)+".xlsx";
            /* cRitorno := w_filexls */
            cRitorno = w_filexls;
          } // End If
        } else { // Else
          /* gMsgProc := gMsgProc + "Errore nell'estrazione del file degli esiti" + NL // Log Elaborazione */
          gMsgProc = gMsgProc+"Errore nell'estrazione del file degli esiti"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* w_tiporep := 1 */
        w_tiporep = CPLib.Round(1,0);
      } // End If
      // Commit
      m_cLastMsgError = m_Sql.TransactionErrorMessage();
      if (CPLib.ne(m_cLastMsgError,"")) {
        m_bError = true;
      }
      m_Sql.CompleteTransaction();
      /* gMsgImp := 'Elaborazione Terminata.' // Messaggio Import */
      gMsgImp = "Elaborazione Terminata.";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } catch(Exception l_exeption) {
      Stop.ReactToException(l_exeption);
      /* cRitorno := 'KO' */
      cRitorno = "KO";
      /* gMsgImp := "Importazione dati terminata con errori." // Messaggio Import */
      gMsgImp = "Importazione dati terminata con errori.";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // Rollback
      m_Sql.AbortTransaction();
      m_cLastMsgError = m_Sql.TransactionErrorMessage();
      m_bError = true;
      m_Sql.CompleteTransaction();
    } finally {
      if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000003Estatus,0)) {
        m_Sql.SetTransactionStatus(nTry0000003Estatus,cTry0000003Emsg);
      }
    }
    /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione: '+ arfn_fdatetime(DateTime()) + NL // Log Elaborazione */
    gMsgProc = gMsgProc+"Ora Fine Elaborazione: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* Return cRitorno */
    throw new Stop(cRitorno);
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_personbo=null;
    CPResultSet Read_Cursor=null;
    try {
      /* _ndg1 Char(16) */
      /* _cfs1 Char(16) */
      /* _ndg2 Char(16) */
      /* _cfs2 Char(16) */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + _nomefileesi + NL // Log Elaborazione */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+_nomefileesi+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* fhand := FileLibMit.OpenReadPath(LRTrim(gPathDoc)+'/SID/MASSCFR/RIC/'+LRTrim(gAzienda)+"/"+_nomefileesi) // Handle file testo */
      fhand = FileLibMit.OpenReadPath(CPLib.LRTrim(gPathDoc)+"/SID/MASSCFR/RIC/"+CPLib.LRTrim(gAzienda)+"/"+_nomefileesi);
      /* While not(FileLibMit.Eof(fhand)) */
      while ( ! (FileLibMit.Eof(fhand))) {
        /* riga := FileLibMit.ReadLine(fhand) // Riga file testo */
        riga = FileLibMit.ReadLine(fhand);
        /* If Len(LRTrim(riga)) > 0 */
        if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
          /* nProgImp := Val(Substr(riga,2,15)) */
          nProgImp = CPLib.Round(CPLib.Val(CPLib.Substr(riga,2,15)),0);
          /* _dnas := CharToDate(Substr(riga,118,4)+Substr(riga,116,2)+Substr(riga,114,2)) */
          _dnas = CPLib.CharToDate(CPLib.Substr(riga,118,4)+CPLib.Substr(riga,116,2)+CPLib.Substr(riga,114,2));
          /* _sesso := iif(Substr(riga,113,1)='M','1','2') */
          _sesso = (CPLib.eqr(CPLib.Substr(riga,113,1),"M")?"1":"2");
          /* _esito := LRTrim(Substr(riga,229,4)) // Codice Esito */
          _esito = CPLib.LRTrim(CPLib.Substr(riga,229,4));
          /* gMsgImp := 'Elaboro Soggetto con codice: '+ Substr(riga,2,15) + ' - Esito: '+_esito // Log Elaborazione */
          gMsgImp = "Elaboro Soggetto con codice: "+CPLib.Substr(riga,2,15)+" - Esito: "+_esito;
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* If w_flgwrong='S' */
          if (CPLib.eqr(w_flgwrong,"S")) {
            /* If _esito='0000' or _esito='0001' */
            if (CPLib.eqr(_esito,"0000") || CPLib.eqr(_esito,"0001")) {
              /* _npers := 0 */
              _npers = CPLib.Round(0,0);
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"PROGIMPORT="+CPSql.SQLValueAdapter(CPLib.ToSQL(nProgImp,"?",0,0,m_cServer, m_oParameters),m_cServer,nProgImp)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                /* _npers := _npers + 1 */
                _npers = CPLib.Round(_npers+1,0);
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
              /* If _npers = 2 */
              if (CPLib.eqr(_npers,2)) {
                /* _cfestero := 0 */
                _cfestero = CPLib.Round(0,0);
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"PROGIMPORT="+CPSql.SQLValueAdapter(CPLib.ToSQL(nProgImp,"?",0,0,m_cServer, m_oParameters),m_cServer,nProgImp)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* _cfestero := _cfestero + 1 */
                  _cfestero = CPLib.Round(_cfestero+1,0);
                  /* If _cfestero=1 */
                  if (CPLib.eqr(_cfestero,1)) {
                    /* _ndg1 := personbo->CONNES */
                    _ndg1 = Cursor_personbo.GetString("CONNES");
                    /* _cfs1 := personbo->CODFISC */
                    _cfs1 = Cursor_personbo.GetString("CODFISC");
                  } // End If
                  /* If _cfestero=2 */
                  if (CPLib.eqr(_cfestero,2)) {
                    /* _ndg2 := personbo->CONNES */
                    _ndg2 = Cursor_personbo.GetString("CONNES");
                    /* _cfs2 := personbo->CODFISC */
                    _cfs2 = Cursor_personbo.GetString("CODFISC");
                  } // End If
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
                /* If _cfs1=_cfs2 and _ndg1<>_ndg2 and not(Empty(_cfs1)) and not(Empty(_cfs2)) */
                if (CPLib.eqr(_cfs1,_cfs2) && CPLib.ne(_ndg1,_ndg2) &&  ! (CPLib.Empty(_cfs1)) &&  ! (CPLib.Empty(_cfs2))) {
                  // * --- Select from personbo
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  if (Cursor_personbo!=null)
                    Cursor_personbo.Close();
                  Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"PROGIMPORT="+CPSql.SQLValueAdapter(CPLib.ToSQL(nProgImp,"?",0,0,m_cServer, m_oParameters),m_cServer,nProgImp)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_personbo.Eof())) {
                    /* If not(mcScarti.GoToKey(personbo->CONNES)) */
                    if ( ! (mcScarti.GoToKey(Cursor_personbo.GetString("CONNES")))) {
                      /* mcScarti.AppendWithKey(personbo->CONNES) */
                      mcScarti.AppendWithKey(Cursor_personbo.GetString("CONNES"));
                      /* mcScarti.ERCONNES := personbo->CONNES */
                      mcScarti.row.ERCONNES = Cursor_personbo.GetString("CONNES");
                      /* mcScarti.ERRAGSOC := personbo->RAGSOC */
                      mcScarti.row.ERRAGSOC = Cursor_personbo.GetString("RAGSOC");
                      /* mcScarti.ERCODFIS := personbo->CODFISC */
                      mcScarti.row.ERCODFIS = Cursor_personbo.GetString("CODFISC");
                      /* mcScarti.ERDESCRI := Substr(riga,2,15) */
                      mcScarti.row.ERDESCRI = CPLib.Substr(riga,2,15);
                      /* mcScarti.SaveRow() */
                      mcScarti.SaveRow();
                    } // End If
                    Cursor_personbo.Next();
                  }
                  m_cConnectivityError = Cursor_personbo.ErrorMessage();
                  Cursor_personbo.Close();
                  // * --- End Select
                } // End If
                /* ElseIf _npers > 2 */
              } else if (CPLib.gt(_npers,2)) {
                /* mcScartiFin.Zap() */
                mcScartiFin.Zap();
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"PROGIMPORT="+CPSql.SQLValueAdapter(CPLib.ToSQL(nProgImp,"?",0,0,m_cServer, m_oParameters),m_cServer,nProgImp)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* mcScartiFin.AppendBlank() */
                  mcScartiFin.AppendBlank();
                  /* mcScartiFin.ERCONNES := personbo->CONNES */
                  mcScartiFin.row.ERCONNES = Cursor_personbo.GetString("CONNES");
                  /* mcScartiFin.ERRAGSOC := personbo->RAGSOC */
                  mcScartiFin.row.ERRAGSOC = Cursor_personbo.GetString("RAGSOC");
                  /* mcScartiFin.ERCODFIS := personbo->CODFISC */
                  mcScartiFin.row.ERCODFIS = Cursor_personbo.GetString("CODFISC");
                  /* mcScartiFin.ERDESCRI := Substr(riga,2,15) */
                  mcScartiFin.row.ERDESCRI = CPLib.Substr(riga,2,15);
                  /* mcScarti.SaveRow() */
                  mcScarti.SaveRow();
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
                /* _conta := 1 */
                _conta = CPLib.Round(1,0);
                /* While _conta <= _npers */
                while (CPLib.le(_conta,_npers)) {
                  /* mcScartiFin.GoTo(_conta) */
                  mcScartiFin.GoTo(_conta);
                  /* _ndg1 := mcScartiFin.ERCONNES */
                  _ndg1 = mcScartiFin.row.ERCONNES;
                  /* _cfs1 := mcScartiFin.ERCODFIS */
                  _cfs1 = mcScartiFin.row.ERCODFIS;
                  /* _ragsoc := mcScartiFin.ERRAGSOC // Nominativo */
                  _ragsoc = mcScartiFin.row.ERRAGSOC;
                  /* _nprog := LRTrim(mcScartiFin.ERDESCRI) */
                  _nprog = CPLib.LRTrim(mcScartiFin.row.ERDESCRI);
                  /* _conta2 := _conta + 1 */
                  _conta2 = CPLib.Round(_conta+1,0);
                  /* mcScartiFin.Skip(1) */
                  mcScartiFin.Skip(1);
                  /* While _conta2 <= _npers */
                  while (CPLib.le(_conta2,_npers)) {
                    /* If mcScartiFin.ERCONNES <> _ndg1 and mcScartiFin.ERCODFIS = _cfs1 and not(Empty(_cfs1)) and not(Empty(mcScartiFin.ERCODFIS)) */
                    if (CPLib.ne(mcScartiFin.row.ERCONNES,_ndg1) && CPLib.eqr(mcScartiFin.row.ERCODFIS,_cfs1) &&  ! (CPLib.Empty(_cfs1)) &&  ! (CPLib.Empty(mcScartiFin.row.ERCODFIS))) {
                      /* If not(mcScarti.GoToKey(mcScartiFin.ERCONNES)) */
                      if ( ! (mcScarti.GoToKey(mcScartiFin.row.ERCONNES))) {
                        /* mcScarti.AppendWithKey(mcScartiFin.ERCONNES) */
                        mcScarti.AppendWithKey(mcScartiFin.row.ERCONNES);
                        /* mcScarti.ERCONNES := mcScartiFin.ERCONNES */
                        mcScarti.row.ERCONNES = mcScartiFin.row.ERCONNES;
                        /* mcScarti.ERRAGSOC := mcScartiFin.ERRAGSOC */
                        mcScarti.row.ERRAGSOC = mcScartiFin.row.ERRAGSOC;
                        /* mcScarti.ERCODFIS := mcScartiFin.ERCODFIS */
                        mcScarti.row.ERCODFIS = mcScartiFin.row.ERCODFIS;
                        /* mcScarti.ERDESCRI := mcScartiFin.ERDESCRI */
                        mcScarti.row.ERDESCRI = mcScartiFin.row.ERDESCRI;
                        /* mcScarti.SaveRow() */
                        mcScarti.SaveRow();
                      } // End If
                      /* If not(mcScarti.GoToKey(_ndg1)) */
                      if ( ! (mcScarti.GoToKey(_ndg1))) {
                        /* mcScarti.AppendWithKey(_ndg1) */
                        mcScarti.AppendWithKey(_ndg1);
                        /* mcScarti.ERCONNES := _ndg1 */
                        mcScarti.row.ERCONNES = _ndg1;
                        /* mcScarti.ERRAGSOC := _ragsoc */
                        mcScarti.row.ERRAGSOC = _ragsoc;
                        /* mcScarti.ERCODFIS := _cfs1 */
                        mcScarti.row.ERCODFIS = _cfs1;
                        /* mcScarti.ERDESCRI := _nprog */
                        mcScarti.row.ERDESCRI = _nprog;
                        /* mcScarti.SaveRow() */
                        mcScarti.SaveRow();
                      } // End If
                    } // End If
                    /* _conta2 := _conta2 + 1 */
                    _conta2 = CPLib.Round(_conta2+1,0);
                  } // End While
                  /* _conta := _conta + 1 */
                  _conta = CPLib.Round(_conta+1,0);
                } // End While
              } // End If
            } // End If
          } else { // Else
            /* _connes := '' */
            _connes = "";
            /* _cfestero := 0 */
            _cfestero = CPLib.Round(0,0);
            /* _ragsoc := '' // Nominativo */
            _ragsoc = "";
            /* _codfisc := '' // Codice Fiscale */
            _codfisc = "";
            /* If w_flgagg='N' */
            if (CPLib.eqr(w_flgagg,"N")) {
              // * --- Read from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              m_cSql = "";
              m_cSql = m_cSql+"PROGIMPORT="+CPSql.SQLValueAdapter(CPLib.ToSQL(nProgImp,"N",15,0,m_cServer),m_cServer,nProgImp);
              if (m_Ctx.IsSharedTemp("personbo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RAGSOC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CFESTERO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _connes = Read_Cursor.GetString("CONNES");
                _ragsoc = Read_Cursor.GetString("RAGSOC");
                _codfisc = Read_Cursor.GetString("CODFISC");
                _cfestero = CPLib.Round(Read_Cursor.GetDouble("CFESTERO"),0);
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on personbo into routine arrt_import_masscf returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _connes = "";
                _ragsoc = "";
                _codfisc = "";
                _cfestero = 0;
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
            } else { // Else
              // * --- Read from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              m_cSql = "";
              m_cSql = m_cSql+"PROGIMPORT="+CPSql.SQLValueAdapter(CPLib.ToSQL(nProgImp,"N",15,0,m_cServer),m_cServer,nProgImp);
              m_cSql = m_cSql+" and COGNOME="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,33,26),"C",26,0,m_cServer),m_cServer,CPLib.Substr(riga,33,26));
              m_cSql = m_cSql+" and NOME="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,73,25),"C",25,0,m_cServer),m_cServer,CPLib.Substr(riga,73,25));
              m_cSql = m_cSql+" and DATANASC="+CPSql.SQLValueAdapter(CPLib.ToSQL(_dnas,"D",8,0,m_cServer),m_cServer,_dnas);
              m_cSql = m_cSql+" and NASCOMUN="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,126,30),"C",30,0,m_cServer),m_cServer,CPLib.Substr(riga,126,30));
              m_cSql = m_cSql+" and SESSO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_sesso,"C",1,0,m_cServer),m_cServer,_sesso);
              if (m_Ctx.IsSharedTemp("personbo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RAGSOC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CFESTERO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _connes = Read_Cursor.GetString("CONNES");
                _ragsoc = Read_Cursor.GetString("RAGSOC");
                _codfisc = Read_Cursor.GetString("CODFISC");
                _cfestero = CPLib.Round(Read_Cursor.GetDouble("CFESTERO"),0);
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on personbo into routine arrt_import_masscf returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _connes = "";
                _ragsoc = "";
                _codfisc = "";
                _cfestero = 0;
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(LRTrim(_connes)) */
              if (CPLib.Empty(CPLib.LRTrim(_connes))) {
                // * --- Read from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                m_cSql = "";
                m_cSql = m_cSql+"PROGIMPORT="+CPSql.SQLValueAdapter(CPLib.ToSQL(nProgImp,"N",15,0,m_cServer),m_cServer,nProgImp);
                m_cSql = m_cSql+" and COGNOME="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,33,26),"C",26,0,m_cServer),m_cServer,CPLib.Substr(riga,33,26));
                m_cSql = m_cSql+" and NOME="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,73,25),"C",25,0,m_cServer),m_cServer,CPLib.Substr(riga,73,25));
                m_cSql = m_cSql+" and DATANASC="+CPSql.SQLValueAdapter(CPLib.ToSQL(_dnas,"D",8,0,m_cServer),m_cServer,_dnas);
                m_cSql = m_cSql+" and NASSTATO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,126,30),"C",30,0,m_cServer),m_cServer,CPLib.Substr(riga,126,30));
                m_cSql = m_cSql+" and SESSO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_sesso,"C",1,0,m_cServer),m_cServer,_sesso);
                if (m_Ctx.IsSharedTemp("personbo")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RAGSOC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CFESTERO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _connes = Read_Cursor.GetString("CONNES");
                  _ragsoc = Read_Cursor.GetString("RAGSOC");
                  _codfisc = Read_Cursor.GetString("CODFISC");
                  _cfestero = CPLib.Round(Read_Cursor.GetDouble("CFESTERO"),0);
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on personbo into routine arrt_import_masscf returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _connes = "";
                  _ragsoc = "";
                  _codfisc = "";
                  _cfestero = 0;
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
              } // End If
            } // End If
            /* If not(Empty(_connes)) */
            if ( ! (CPLib.Empty(_connes))) {
              /* If Left(riga,1)='1' */
              if (CPLib.eqr(CPLib.Left(riga,1),"1")) {
                /* _contar := _contar + 1 */
                _contar = CPLib.Round(_contar+1,0);
                /* _dnas := CharToDate(Substr(riga,340,4)+Substr(riga,338,2)+Substr(riga,336,2)) */
                _dnas = CPLib.CharToDate(CPLib.Substr(riga,340,4)+CPLib.Substr(riga,338,2)+CPLib.Substr(riga,336,2));
                /* _nasstato := iif(Substr(riga,389,2)='EE',Substr(riga,344,30),'') */
                _nasstato = (CPLib.eqr(CPLib.Substr(riga,389,2),"EE")?CPLib.Substr(riga,344,30):"");
                /* _nascomun := iif(Substr(riga,389,2)='EE','',Substr(riga,344,30)) */
                _nascomun = (CPLib.eqr(CPLib.Substr(riga,389,2),"EE")?"":CPLib.Substr(riga,344,30));
                /* Case LRTrim(_esito)='0000' */
                if (CPLib.eqr(CPLib.LRTrim(_esito),"0000")) {
                  /* If _cfestero=1 */
                  if (CPLib.eqr(_cfestero,1)) {
                    /* If w_flganf='S' or w_flgant='S' */
                    if (CPLib.eqr(w_flganf,"S") || CPLib.eqr(w_flgant,"S")) {
                      /* Exec Routine arrt_storicopers_old(_connes,Date()) */
                      arrt_storicopers_oldR.Make(m_Ctx,this).Run(_connes,CPLib.Date());
                      /* If w_flganf='S' and w_flgant='S' */
                      if (CPLib.eqr(w_flganf,"S") && CPLib.eqr(w_flgant,"S")) {
                        // * --- Write into personbo from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("personbo");
                        m_cPhName = m_Ctx.GetPhName("personbo");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_masscf",940,"000000E2")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                        m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(CPLib.Substr(riga,239,16),"C",16,0,m_cServer)+", ";
                        m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(0,"N",1,0)+", ";
                        m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(CPLib.Substr(riga,255,40))+" "+CPLib.LRTrim(CPLib.Substr(riga,295,40)),70),"C",70,0,m_cServer)+", ";
                        m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(_dnas,"D",8,0)+", ";
                        m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(_nascomun,"C",30,0,m_cServer)+", ";
                        m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL((CPLib.eqr(CPLib.Substr(riga,335,1),"M")?"1":"2"),"C",1,0,m_cServer)+", ";
                        m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(_nasstato,"C",30,0,m_cServer)+", ";
                        m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(CPLib.Substr(riga,295,25),"C",25,0,m_cServer)+", ";
                        m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(CPLib.Substr(riga,255,26),"C",26,0,m_cServer)+", ";
                        m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(CPLib.Substr(riga,389,2),"C",2,0,m_cServer)+", ";
                        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                        m_cSql = m_cSql+" where ";
                        m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
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
                      /* If w_flganf='S' and w_flgant='N' */
                      if (CPLib.eqr(w_flganf,"S") && CPLib.eqr(w_flgant,"N")) {
                        // * --- Write into personbo from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("personbo");
                        m_cPhName = m_Ctx.GetPhName("personbo");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_masscf",940,"000000E4")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                        m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(CPLib.Substr(riga,239,16),"C",16,0,m_cServer)+", ";
                        m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(0,"N",1,0)+", ";
                        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                        m_cSql = m_cSql+" where ";
                        m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
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
                      /* If w_flganf='N' and w_flgant='S' */
                      if (CPLib.eqr(w_flganf,"N") && CPLib.eqr(w_flgant,"S")) {
                        // * --- Write into personbo from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("personbo");
                        m_cPhName = m_Ctx.GetPhName("personbo");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_masscf",940,"000000E6")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                        m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(0,"N",1,0)+", ";
                        m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(CPLib.Substr(riga,255,40))+" "+CPLib.LRTrim(CPLib.Substr(riga,295,40)),70),"C",70,0,m_cServer)+", ";
                        m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(_dnas,"D",8,0)+", ";
                        m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(_nascomun,"C",30,0,m_cServer)+", ";
                        m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL((CPLib.eqr(CPLib.Substr(riga,335,1),"M")?"1":"2"),"C",1,0,m_cServer)+", ";
                        m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(_nasstato,"C",30,0,m_cServer)+", ";
                        m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(CPLib.Substr(riga,295,25),"C",25,0,m_cServer)+", ";
                        m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(CPLib.Substr(riga,255,26),"C",26,0,m_cServer)+", ";
                        m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(CPLib.Substr(riga,389,2),"C",2,0,m_cServer)+", ";
                        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                        m_cSql = m_cSql+" where ";
                        m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
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
                      // * --- Write into personbo_agg from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("personbo_agg");
                      m_cPhName = m_Ctx.GetPhName("personbo_agg");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_masscf",940,"000000E7")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"FLGVALIDO = "+CPLib.ToSQL(w_flganf,"C",1,0,m_cServer)+", ";
                      m_cSql = m_cSql+"FLGANAVAL = "+CPLib.ToSQL(w_flgant,"C",1,0,m_cServer)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo_agg",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
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
                      /* If m_nUpdatedRows=0 */
                      if (CPLib.eqr(m_nUpdatedRows,0)) {
                        // * --- Insert into personbo_agg from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("personbo_agg");
                        m_cPhName = m_Ctx.GetPhName("personbo_agg");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_masscf",940,"000000E9")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                        m_cSql = m_cSql+GetFieldsName_000000E9(m_Ctx,m_oWrInfo);
                        m_cSql = m_cSql+") values (";
                        m_cSql = m_cSql+""+CPLib.ToSQL(_connes,"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(w_flganf,"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(w_flgant,"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+m_oWrInfo.InsertValues();
                        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo_agg",true);
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
                    } // End If
                  } else { // Else
                    /* If w_flganf='S' or w_flgant='S' */
                    if (CPLib.eqr(w_flganf,"S") || CPLib.eqr(w_flgant,"S")) {
                      /* If w_flgant='S' */
                      if (CPLib.eqr(w_flgant,"S")) {
                        /* Exec Routine arrt_storicopers_old(_connes,Date()) */
                        arrt_storicopers_oldR.Make(m_Ctx,this).Run(_connes,CPLib.Date());
                        // * --- Write into personbo from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("personbo");
                        m_cPhName = m_Ctx.GetPhName("personbo");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_masscf",940,"000000ED")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                        m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(CPLib.Substr(riga,255,40))+" "+CPLib.LRTrim(CPLib.Substr(riga,295,40)),70),"C",70,0,m_cServer)+", ";
                        m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(_dnas,"D",8,0)+", ";
                        m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(_nascomun,"C",30,0,m_cServer)+", ";
                        m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL((CPLib.eqr(CPLib.Substr(riga,335,1),"M")?"1":"2"),"C",1,0,m_cServer)+", ";
                        m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(_nasstato,"C",30,0,m_cServer)+", ";
                        m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(CPLib.Substr(riga,295,25),"C",25,0,m_cServer)+", ";
                        m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(CPLib.Substr(riga,255,26),"C",26,0,m_cServer)+", ";
                        m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(CPLib.Substr(riga,389,2),"C",2,0,m_cServer)+", ";
                        m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(CPLib.Substr(riga,239,16),"C",16,0,m_cServer)+", ";
                        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                        m_cSql = m_cSql+" where ";
                        m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
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
                      // * --- Write into personbo_agg from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("personbo_agg");
                      m_cPhName = m_Ctx.GetPhName("personbo_agg");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_masscf",940,"000000EE")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"FLGVALIDO = "+CPLib.ToSQL(w_flganf,"C",1,0,m_cServer)+", ";
                      m_cSql = m_cSql+"FLGANAVAL = "+CPLib.ToSQL(w_flgant,"C",1,0,m_cServer)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo_agg",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
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
                      /* If m_nUpdatedRows=0 */
                      if (CPLib.eqr(m_nUpdatedRows,0)) {
                        // * --- Insert into personbo_agg from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("personbo_agg");
                        m_cPhName = m_Ctx.GetPhName("personbo_agg");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_masscf",940,"000000F0")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                        m_cSql = m_cSql+GetFieldsName_000000F0(m_Ctx,m_oWrInfo);
                        m_cSql = m_cSql+") values (";
                        m_cSql = m_cSql+""+CPLib.ToSQL(_connes,"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(w_flganf,"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(w_flgant,"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+m_oWrInfo.InsertValues();
                        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo_agg",true);
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
                    } // End If
                  } // End If
                  /* If w_flgwuker='S' */
                  if (CPLib.eqr(w_flgwuker,"S")) {
                    /* Exec "Aggiorna Kersonbo" Page 6:Page_6 */
                    Page_6();
                  } // End If
                  /* If w_flgfam = 'S' */
                  if (CPLib.eqr(w_flgfam,"S")) {
                    // * --- Write into opextrbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("opextrbo");
                    m_cPhName = m_Ctx.GetPhName("opextrbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_import_masscf",940,"000000F4")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"DATAMODI = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
                    m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
                    m_cSql = m_cSql+" and ANNO >= "+CPSql.SQLValueAdapter(CPLib.ToSQL("2011","?",0,0,m_cServer),m_cServer,"2011")+"";
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
                  /* Case LRTrim(_esito)='0001' */
                } else if (CPLib.eqr(CPLib.LRTrim(_esito),"0001")) {
                  /* If w_flganf='S' or w_flgant='S' */
                  if (CPLib.eqr(w_flganf,"S") || CPLib.eqr(w_flgant,"S")) {
                    /* Exec Routine arrt_storicopers_old(_connes,Date()) */
                    arrt_storicopers_oldR.Make(m_Ctx,this).Run(_connes,CPLib.Date());
                    /* If w_flgant='S' */
                    if (CPLib.eqr(w_flgant,"S")) {
                      // * --- Write into personbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("personbo");
                      m_cPhName = m_Ctx.GetPhName("personbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_masscf",940,"000000F8")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(CPLib.Substr(riga,255,40))+" "+CPLib.LRTrim(CPLib.Substr(riga,295,40)),70),"C",70,0,m_cServer)+", ";
                      m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(_dnas,"D",8,0)+", ";
                      m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(_nascomun,"C",30,0,m_cServer)+", ";
                      m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL((CPLib.eqr(CPLib.Substr(riga,335,1),"M")?"1":"2"),"C",1,0,m_cServer)+", ";
                      m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(_nasstato,"C",30,0,m_cServer)+", ";
                      m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(CPLib.Substr(riga,295,25),"C",25,0,m_cServer)+", ";
                      m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(CPLib.Substr(riga,255,26),"C",26,0,m_cServer)+", ";
                      m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(CPLib.Substr(riga,389,2),"C",2,0,m_cServer)+", ";
                      m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(CPLib.Substr(riga,239,16),"C",16,0,m_cServer)+", ";
                      m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(0,"N",1,0)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
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
                    /* If w_flgant='N' */
                    if (CPLib.eqr(w_flgant,"N")) {
                      // * --- Write into personbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("personbo");
                      m_cPhName = m_Ctx.GetPhName("personbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_masscf",940,"000000FA")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(CPLib.Substr(riga,239,16),"C",16,0,m_cServer)+", ";
                      m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(0,"N",1,0)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
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
                    // * --- Write into personbo_agg from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("personbo_agg");
                    m_cPhName = m_Ctx.GetPhName("personbo_agg");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_import_masscf",940,"000000FB")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"FLGVALIDO = "+CPLib.ToSQL(w_flganf,"C",1,0,m_cServer)+", ";
                    m_cSql = m_cSql+"FLGANAVAL = "+CPLib.ToSQL(w_flgant,"C",1,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo_agg",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
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
                    /* If m_nUpdatedRows=0 */
                    if (CPLib.eqr(m_nUpdatedRows,0)) {
                      // * --- Insert into personbo_agg from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("personbo_agg");
                      m_cPhName = m_Ctx.GetPhName("personbo_agg");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_masscf",940,"000000FD")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_000000FD(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_connes,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(w_flganf,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(w_flgant,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo_agg",true);
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
                  } // End If
                  /* If w_flgwuker='S' */
                  if (CPLib.eqr(w_flgwuker,"S")) {
                    /* Exec "Aggiorna Kersonbo" Page 6:Page_6 */
                    Page_6();
                  } // End If
                  /* If w_flgfam = 'S' */
                  if (CPLib.eqr(w_flgfam,"S")) {
                    // * --- Write into opextrbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("opextrbo");
                    m_cPhName = m_Ctx.GetPhName("opextrbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_import_masscf",940,"00000101")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"DATAMODI = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
                    m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
                    m_cSql = m_cSql+" and ANNO >= "+CPSql.SQLValueAdapter(CPLib.ToSQL("2011","?",0,0,m_cServer),m_cServer,"2011")+"";
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
                  /* Case LRTrim(_esito)='0111' or LRTrim(_esito)='0112' or LRTrim(_esito)='0006'  or LRTrim(_esito)='0007' or LRTrim(_esito)='0110' */
                } else if (CPLib.eqr(CPLib.LRTrim(_esito),"0111") || CPLib.eqr(CPLib.LRTrim(_esito),"0112") || CPLib.eqr(CPLib.LRTrim(_esito),"0006") || CPLib.eqr(CPLib.LRTrim(_esito),"0007") || CPLib.eqr(CPLib.LRTrim(_esito),"0110")) {
                  /* If w_flganf='S' */
                  if (CPLib.eqr(w_flganf,"S")) {
                    /* If w_flgcst='S' */
                    if (CPLib.eqr(w_flgcst,"S")) {
                      /* If Upper(Substr(riga,28,1))='Z' */
                      if (CPLib.eqr(CPLib.Upper(CPLib.Substr(riga,28,1)),"Z")) {
                        /* Exec Routine arrt_storicopers_old(_connes,Date()) */
                        arrt_storicopers_oldR.Make(m_Ctx,this).Run(_connes,CPLib.Date());
                        // * --- Write into personbo from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("personbo");
                        m_cPhName = m_Ctx.GetPhName("personbo");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_masscf",940,"00000106")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                        m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                        m_cSql = m_cSql+" where ";
                        m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
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
                        // * --- Write into personbo_agg from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("personbo_agg");
                        m_cPhName = m_Ctx.GetPhName("personbo_agg");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_masscf",940,"00000107")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                        m_cSql = m_cSql+"FLGVALIDO = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
                        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo_agg",false,true);
                        m_cSql = m_cSql+" where ";
                        m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
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
                        /* If m_nUpdatedRows=0 */
                        if (CPLib.eqr(m_nUpdatedRows,0)) {
                          // * --- Insert into personbo_agg from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("personbo_agg");
                          m_cPhName = m_Ctx.GetPhName("personbo_agg");
                          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_masscf",940,"00000109")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                          m_cSql = m_cSql+GetFieldsName_00000109(m_Ctx,m_oWrInfo);
                          m_cSql = m_cSql+") values (";
                          m_cSql = m_cSql+""+CPLib.ToSQL(_connes,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+m_oWrInfo.InsertValues();
                          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo_agg",true);
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
                        /* If w_flgfam = 'S' */
                        if (CPLib.eqr(w_flgfam,"S")) {
                          // * --- Write into opextrbo from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("opextrbo");
                          m_cPhName = m_Ctx.GetPhName("opextrbo");
                          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_masscf",940,"0000010B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                          m_cSql = m_cSql+"DATAMODI = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
                          m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
                          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
                          m_cSql = m_cSql+" where ";
                          m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
                          m_cSql = m_cSql+" and ANNO >= "+CPSql.SQLValueAdapter(CPLib.ToSQL("2011","?",0,0,m_cServer),m_cServer,"2011")+"";
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
                    } else { // Else
                      /* Exec Routine arrt_storicopers_old(_connes,Date()) */
                      arrt_storicopers_oldR.Make(m_Ctx,this).Run(_connes,CPLib.Date());
                      // * --- Write into personbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("personbo");
                      m_cPhName = m_Ctx.GetPhName("personbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_masscf",940,"0000010D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                      m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL("","C",16,0,m_cServer)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
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
                      // * --- Write into personbo_agg from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("personbo_agg");
                      m_cPhName = m_Ctx.GetPhName("personbo_agg");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_masscf",940,"0000010E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"FLGVALIDO = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo_agg",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
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
                      /* If m_nUpdatedRows=0 */
                      if (CPLib.eqr(m_nUpdatedRows,0)) {
                        // * --- Insert into personbo_agg from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("personbo_agg");
                        m_cPhName = m_Ctx.GetPhName("personbo_agg");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_masscf",940,"00000110")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                        m_cSql = m_cSql+GetFieldsName_00000110(m_Ctx,m_oWrInfo);
                        m_cSql = m_cSql+") values (";
                        m_cSql = m_cSql+""+CPLib.ToSQL(_connes,"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+m_oWrInfo.InsertValues();
                        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo_agg",true);
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
                      /* If w_flgfam = 'S' */
                      if (CPLib.eqr(w_flgfam,"S")) {
                        // * --- Write into opextrbo from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("opextrbo");
                        m_cPhName = m_Ctx.GetPhName("opextrbo");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_masscf",940,"00000112")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                        m_cSql = m_cSql+"DATAMODI = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
                        m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
                        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
                        m_cSql = m_cSql+" where ";
                        m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
                        m_cSql = m_cSql+" and ANNO >= "+CPSql.SQLValueAdapter(CPLib.ToSQL("2011","?",0,0,m_cServer),m_cServer,"2011")+"";
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
                  } // End If
                } else { // Otherwise
                  /* mcScarti.AppendWithKey(_connes) */
                  mcScarti.AppendWithKey(_connes);
                  /* mcScarti.ERCONNES := _connes */
                  mcScarti.row.ERCONNES = _connes;
                  /* mcScarti.ERRAGSOC := _ragsoc */
                  mcScarti.row.ERRAGSOC = _ragsoc;
                  /* mcScarti.ERCODFIS := _codfisc */
                  mcScarti.row.ERCODFIS = _codfisc;
                  /* If mcErrori.GoToKey(_esito) */
                  if (mcErrori.GoToKey(_esito)) {
                    /* mcScarti.ERCODICE := mcErrori.ERCODICE */
                    mcScarti.row.ERCODICE = mcErrori.row.ERCODICE;
                    /* mcScarti.ERDESCRI := mcErrori.ERDESCRI */
                    mcScarti.row.ERDESCRI = mcErrori.row.ERDESCRI;
                    /* mcScarti.ERTESTO := mcErrori.ERTESTO */
                    mcScarti.row.ERTESTO = mcErrori.row.ERTESTO;
                    /* mcScarti.ERAZIONE := mcErrori.ERAZIONE */
                    mcScarti.row.ERAZIONE = mcErrori.row.ERAZIONE;
                  } // End If
                  /* mcScarti.SaveRow() */
                  mcScarti.SaveRow();
                } // End Case
                /* If w_flgxls='S' */
                if (CPLib.eqr(w_flgxls,"S")) {
                  /* mcXLSIMP.AppendBlank() */
                  mcXLSIMP.AppendBlank();
                  /* mcXLSIMP.NDG := _connes */
                  mcXLSIMP.row.NDG = _connes;
                  /* mcXLSIMP.CODFSC := Substr(riga,17,16) */
                  mcXLSIMP.row.CODFSC = CPLib.Substr(riga,17,16);
                  /* mcXLSIMP.COGNOME := Substr(riga,33,40) */
                  mcXLSIMP.row.COGNOME = CPLib.Substr(riga,33,40);
                  /* mcXLSIMP.NOME := Substr(riga,73,40) */
                  mcXLSIMP.row.NOME = CPLib.Substr(riga,73,40);
                  /* mcXLSIMP.SESSO := Substr(riga,113,1) */
                  mcXLSIMP.row.SESSO = CPLib.Substr(riga,113,1);
                  /* mcXLSIMP.DATNASC := Substr(riga,114,8) */
                  mcXLSIMP.row.DATNASC = CPLib.Substr(riga,114,8);
                  /* mcXLSIMP.NASCOD := Substr(riga,122,4) */
                  mcXLSIMP.row.NASCOD = CPLib.Substr(riga,122,4);
                  /* mcXLSIMP.NASNOM := Substr(riga,126,45) */
                  mcXLSIMP.row.NASNOM = CPLib.Substr(riga,126,45);
                  /* mcXLSIMP.NASPRV := Substr(riga,171,2) */
                  mcXLSIMP.row.NASPRV = CPLib.Substr(riga,171,2);
                  /* mcXLSIMP.CODRIT := _esito */
                  mcXLSIMP.row.CODRIT = _esito;
                  /* If mcErrori.GoToKey(_esito) */
                  if (mcErrori.GoToKey(_esito)) {
                    /* mcXLSIMP.DESRIT := mcErrori.ERDESCRI */
                    mcXLSIMP.row.DESRIT = mcErrori.row.ERDESCRI;
                  } // End If
                  /* mcXLSIMP.CODFSCAGE := Substr(riga,239,16) */
                  mcXLSIMP.row.CODFSCAGE = CPLib.Substr(riga,239,16);
                  /* mcXLSIMP.COGNOMEAGE := Substr(riga,255,40) */
                  mcXLSIMP.row.COGNOMEAGE = CPLib.Substr(riga,255,40);
                  /* mcXLSIMP.NOMEAGE := Substr(riga,295,40) */
                  mcXLSIMP.row.NOMEAGE = CPLib.Substr(riga,295,40);
                  /* mcXLSIMP.SESSOAGE := Substr(riga,335,1) */
                  mcXLSIMP.row.SESSOAGE = CPLib.Substr(riga,335,1);
                  /* mcXLSIMP.DATNASCAGE := Substr(riga,336,8) */
                  mcXLSIMP.row.DATNASCAGE = CPLib.Substr(riga,336,8);
                  /* mcXLSIMP.NASNOMAGE := Substr(riga,344,45) */
                  mcXLSIMP.row.NASNOMAGE = CPLib.Substr(riga,344,45);
                  /* mcXLSIMP.NASPRVAGE := Substr(riga,389,2) */
                  mcXLSIMP.row.NASPRVAGE = CPLib.Substr(riga,389,2);
                  /* If w_flgexa='S' */
                  if (CPLib.eqr(w_flgexa,"S")) {
                    // * --- Select from personbo
                    m_cServer = m_Ctx.GetServer("personbo");
                    m_cPhName = m_Ctx.GetPhName("personbo");
                    if (Cursor_personbo!=null)
                      Cursor_personbo.Close();
                    Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer, m_oParameters),m_cServer,_connes)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_personbo.Eof())) {
                      /* mcXLSIMP.CODFSCAUI := personbo->CODFISC */
                      mcXLSIMP.row.CODFSCAUI = Cursor_personbo.GetString("CODFISC");
                      /* mcXLSIMP.COGNOMEAUI := personbo->COGNOME */
                      mcXLSIMP.row.COGNOMEAUI = Cursor_personbo.GetString("COGNOME");
                      /* mcXLSIMP.NOMEAUI := personbo->NOME */
                      mcXLSIMP.row.NOMEAUI = Cursor_personbo.GetString("NOME");
                      /* mcXLSIMP.SESSOAUI := iif(personbo->SESSO='1','Maschio',iif(personbo->SESSO='2','Femmina','')) */
                      mcXLSIMP.row.SESSOAUI = (CPLib.eqr(Cursor_personbo.GetString("SESSO"),"1")?"Maschio":(CPLib.eqr(Cursor_personbo.GetString("SESSO"),"2")?"Femmina":""));
                      /* mcXLSIMP.DATNASCAUI := DateToChar(personbo->DATANASC) */
                      mcXLSIMP.row.DATNASCAUI = CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC"));
                      /* mcXLSIMP.NASNOMAUI := iif(personbo->TIPINTER='EE',personbo->NASSTATO,personbo->NASCOMUN) */
                      mcXLSIMP.row.NASNOMAUI = (CPLib.eqr(Cursor_personbo.GetString("TIPINTER"),"EE")?Cursor_personbo.GetString("NASSTATO"):Cursor_personbo.GetString("NASCOMUN"));
                      /* mcXLSIMP.NASPRVAUI := personbo->TIPINTER */
                      mcXLSIMP.row.NASPRVAUI = Cursor_personbo.GetString("TIPINTER");
                      /* mcXLSIMP.TIPDOCAUI := arfn_dectabs('DOC',personbo->TIPODOC) */
                      mcXLSIMP.row.TIPDOCAUI = arfn_dectabsR.Make(m_Ctx,this).Run("DOC",Cursor_personbo.GetString("TIPODOC"));
                      /* mcXLSIMP.NUMDOCAUI := personbo->NUMDOCUM */
                      mcXLSIMP.row.NUMDOCAUI = Cursor_personbo.GetString("NUMDOCUM");
                      /* mcXLSIMP.AUTRILAUI := personbo->AUTRILASC */
                      mcXLSIMP.row.AUTRILAUI = Cursor_personbo.GetString("AUTRILASC");
                      Cursor_personbo.Next();
                    }
                    m_cConnectivityError = Cursor_personbo.ErrorMessage();
                    Cursor_personbo.Close();
                    // * --- End Select
                  } // End If
                  /* mcXLSIMP.SaveRow() */
                  mcXLSIMP.SaveRow();
                } // End If
                /* ElseIf Left(riga,1)='2' */
              } else if (CPLib.eqr(CPLib.Left(riga,1),"2")) {
                /* _contar := _contar + 1 */
                _contar = CPLib.Round(_contar+1,0);
                /* Case LRTrim(_esito)='0000' */
                if (CPLib.eqr(CPLib.LRTrim(_esito),"0000")) {
                  /* If _cfestero=1 */
                  if (CPLib.eqr(_cfestero,1)) {
                    /* Exec Routine arrt_storicopers_old(_connes,Date()) */
                    arrt_storicopers_oldR.Make(m_Ctx,this).Run(_connes,CPLib.Date());
                    // * --- Write into personbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("personbo");
                    m_cPhName = m_Ctx.GetPhName("personbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_import_masscf",940,"00000143")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(CPLib.Substr(riga,239,16),"C",16,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(0,"N",1,0)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
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
                    // * --- Write into personbo_agg from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("personbo_agg");
                    m_cPhName = m_Ctx.GetPhName("personbo_agg");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_import_masscf",940,"00000144")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"FLGVALIDO = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo_agg",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
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
                    // * --- Write into personbo_agg from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("personbo_agg");
                    m_cPhName = m_Ctx.GetPhName("personbo_agg");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_import_masscf",940,"00000145")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"FLGVALIDO = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo_agg",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
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
                  /* Case LRTrim(_esito)='0001' */
                } else if (CPLib.eqr(CPLib.LRTrim(_esito),"0001")) {
                  /* Exec Routine arrt_storicopers_old(_connes,Date()) */
                  arrt_storicopers_oldR.Make(m_Ctx,this).Run(_connes,CPLib.Date());
                  // * --- Write into personbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_import_masscf",940,"00000147")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(CPLib.Substr(riga,17,15),"C",16,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
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
                  // * --- Write into personbo_agg from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("personbo_agg");
                  m_cPhName = m_Ctx.GetPhName("personbo_agg");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_import_masscf",940,"00000148")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"FLGVALIDO = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo_agg",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
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
                  /* Case LRTrim(_esito)='0111' or LRTrim(_esito)='0112' or LRTrim(_esito)='0006'  or LRTrim(_esito)='0007' or LRTrim(_esito)='0110' */
                } else if (CPLib.eqr(CPLib.LRTrim(_esito),"0111") || CPLib.eqr(CPLib.LRTrim(_esito),"0112") || CPLib.eqr(CPLib.LRTrim(_esito),"0006") || CPLib.eqr(CPLib.LRTrim(_esito),"0007") || CPLib.eqr(CPLib.LRTrim(_esito),"0110")) {
                  /* Exec Routine arrt_storicopers_old(_connes,Date()) */
                  arrt_storicopers_oldR.Make(m_Ctx,this).Run(_connes,CPLib.Date());
                  // * --- Write into personbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_import_masscf",940,"0000014A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
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
                } else { // Otherwise
                  /* mcScarti.AppendWithKey(_connes) */
                  mcScarti.AppendWithKey(_connes);
                  /* mcScarti.ERCONNES := _connes */
                  mcScarti.row.ERCONNES = _connes;
                  /* mcScarti.ERRAGSOC := _ragsoc */
                  mcScarti.row.ERRAGSOC = _ragsoc;
                  /* mcScarti.ERCODFIS := _codfisc */
                  mcScarti.row.ERCODFIS = _codfisc;
                  /* If mcErrori.GoToKey(_esito) */
                  if (mcErrori.GoToKey(_esito)) {
                    /* mcScarti.ERCODICE := mcErrori.ERCODICE */
                    mcScarti.row.ERCODICE = mcErrori.row.ERCODICE;
                    /* mcScarti.ERDESCRI := mcErrori.ERDESCRI */
                    mcScarti.row.ERDESCRI = mcErrori.row.ERDESCRI;
                    /* mcScarti.ERTESTO := mcErrori.ERTESTO */
                    mcScarti.row.ERTESTO = mcErrori.row.ERTESTO;
                    /* mcScarti.ERAZIONE := mcErrori.ERAZIONE */
                    mcScarti.row.ERAZIONE = mcErrori.row.ERAZIONE;
                  } // End If
                  /* mcScarti.SaveRow() */
                  mcScarti.SaveRow();
                } // End Case
              } // End If
            } // End If
          } // End If
        } // End If
      } // End While
      /* If w_flgwrong='S' */
      if (CPLib.eqr(w_flgwrong,"S")) {
        /* _connes := '' // Connes del soggetto */
        _connes = "";
        /* _codfisc := '' // Codice Fiscale */
        _codfisc = "";
        /* nProgImp := 0 // Identificativo Soggetto */
        nProgImp = CPLib.Round(0,0);
        /* mcScartiFin.Zap() */
        mcScartiFin.Zap();
        MemoryCursor_mcscartimcf_mcrdef cpmc_0000015A;
        cpmc_0000015A = new MemoryCursor_mcscartimcf_mcrdef();
        for (MemoryCursorRow_mcscartimcf_mcrdef rwScarti : mcScarti._iterable_()) {
          cpmc_0000015A.Append(rwScarti);
        }
        for (MemoryCursorRow_mcscartimcf_mcrdef rwScarti : cpmc_0000015A._iterable_(new CPMemoryCursorRow.Comparator<MemoryCursorRow_mcscartimcf_mcrdef>(){  public int compare(MemoryCursorRow_mcscartimcf_mcrdef r1,MemoryCursorRow_mcscartimcf_mcrdef r2){    if (CPLib.gt(r1.ERDESCRI,r2.ERDESCRI)) return 1;    if (CPLib.lt(r1.ERDESCRI,r2.ERDESCRI)) return -1;    if (CPLib.gt(r1.ERCONNES,r2.ERCONNES)) return 1;    if (CPLib.lt(r1.ERCONNES,r2.ERCONNES)) return -1;    return 0;  }})) {
          /* mcScartiFin.AppendBlank() */
          mcScartiFin.AppendBlank();
          /* mcScartiFin.ERCONNES := rwScarti.ERCONNES */
          mcScartiFin.row.ERCONNES = rwScarti.ERCONNES;
          /* mcScartiFin.ERRAGSOC := rwScarti.ERRAGSOC */
          mcScartiFin.row.ERRAGSOC = rwScarti.ERRAGSOC;
          /* mcScartiFin.ERCODFIS := rwScarti.ERCODFIS */
          mcScartiFin.row.ERCODFIS = rwScarti.ERCODFIS;
          /* mcScartiFin.ERDESCRI := rwScarti.ERDESCRI */
          mcScartiFin.row.ERDESCRI = rwScarti.ERDESCRI;
          /* mcScartiFin.SaveRow() */
          mcScartiFin.SaveRow();
        }
      } // End If
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + _nomefileesi + NL // Log Elaborazione */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+_nomefileesi+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
      /* gMsgImp := 'Fine importazione del file '+_nomefileesi // Messaggio Import */
      gMsgImp = "Fine importazione del file "+_nomefileesi;
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* cRitorno := 'OK' */
      cRitorno = "OK";
    } finally {
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
    }
  }
  void Page_3() throws Exception {
    /* Formato Excel */
    /* _nfile := LRTrim(gPathDoc)+"/export/"+LRTrim(gAzienda)+"/"+LRTrim(nomefileimport)+".xlsx" */
    _nfile = CPLib.LRTrim(gPathDoc)+"/export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(nomefileimport)+".xlsx";
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
    cell.setCellValue("NDG");
    cell.setCellStyle(cs);
    cell =  row.createCell(1);
    cell.setCellValue("Codice Fiscale Origine");
    cell.setCellStyle(cs);
    cell = row.createCell(2);
    cell.setCellValue("Cognome Origine");
    cell.setCellStyle(cs);
    cell = row.createCell(3);
    cell.setCellValue("Nome Origine");
    cell.setCellStyle(cs);
    cell =  row.createCell(4);
    cell.setCellValue("Sesso Origine");
    cell.setCellStyle(cs);
    cell =  row.createCell(5);
    cell.setCellValue("Data Nascita Origine'");
    cell.setCellStyle(cs);
    cell =  row.createCell(6);
    cell.setCellValue("Codice Nascita Origine");
    cell.setCellStyle(cs);
    cell =  row.createCell(7);
    cell.setCellValue("Luogo Nascita Origine");
    cell.setCellStyle(cs);
    cell =  row.createCell(8);
    cell.setCellValue("Provincia Nascita Origine");
    cell.setCellStyle(cs);
    cell = row.createCell(9);
    cell.setCellValue("ESITO");
    cell.setCellStyle(cs);
    cell = row.createCell(10);
    cell.setCellValue("DESCRIZIONE");
    cell.setCellStyle(cs);
    cell = row.createCell(11);
    cell.setCellValue("Codice Fiscale AGE");
    cell.setCellStyle(cs);
    cell = row.createCell(12);
    cell.setCellValue("Cognome AGE");
    cell.setCellStyle(cs);
    cell = row.createCell(13);
    cell.setCellValue("Nome AGE");
    cell.setCellStyle(cs);
    cell = row.createCell(14);
    cell.setCellValue("Sesso AGE");
    cell.setCellStyle(cs);
    cell = row.createCell(15);
    cell.setCellValue("Data Nascita AGE");
    cell.setCellStyle(cs);
    cell = row.createCell(16);
    cell.setCellValue("Luogo Nascita AGE");
    cell.setCellStyle(cs);
    cell = row.createCell(17);
    cell.setCellValue("Provincia Nascita AGE");
    cell.setCellStyle(cs);
    /* If w_flgexa='S' */
    if (CPLib.eqr(w_flgexa,"S")) {
      // Scrive dati aggiuntivi Soggetto
      cell = row.createCell(18);
      cell.setCellValue("Codice Fiscale AUI");
      cell.setCellStyle(cs);
      cell = row.createCell(19);
      cell.setCellValue("Cognome AUI");
      cell.setCellStyle(cs);
      cell = row.createCell(20);
      cell.setCellValue("Nome AUI");
      cell.setCellStyle(cs);
      cell = row.createCell(21);
      cell.setCellValue("Sesso AUI");
      cell.setCellStyle(cs);
      cell = row.createCell(22);
      cell.setCellValue("Data Nascita AUI");
      cell.setCellStyle(cs);
      cell = row.createCell(23);
      cell.setCellValue("Luogo Nascita AUI");
      cell.setCellStyle(cs);
      cell = row.createCell(24);
      cell.setCellValue("Provincia Nascita AUI");
      cell.setCellStyle(cs);
      cell = row.createCell(25);
      cell.setCellValue("Tipo Documento AUI");
      cell.setCellStyle(cs);
      cell = row.createCell(26);
      cell.setCellValue("N. Documento AUI");
      cell.setCellStyle(cs);
      cell = row.createCell(27);
      cell.setCellValue("Autorità Rilascio AUI");
      cell.setCellStyle(cs);
    } // End If
    // Porta avanti contatore riga
    r++;
    /* _conta := 0 */
    _conta = CPLib.Round(0,0);
    for (MemoryCursorRow_mcxlsritmcf_mcrdef rwXLS : mcXLSIMP._iterable_()) {
      /* _conta := _conta + 1 */
      _conta = CPLib.Round(_conta+1,0);
      /* gMsgImp := 'Sto scrivendo la riga n.: '+ LRTrim(Str(_conta,7,0)) + " su " + LRTrim(Str(_contar,7,0)) // Log Elaborazione */
      gMsgImp = "Sto scrivendo la riga n.: "+CPLib.LRTrim(CPLib.Str(_conta,7,0))+" su "+CPLib.LRTrim(CPLib.Str(_contar,7,0));
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      //Creo il record da scrivere
      row = sheet.createRow(r);
      cell = row.createCell(0);
      cell.setCellValue(CPLib.LRTrim(rwXLS.NDG));
      cell = row.createCell(1);
      cell.setCellValue(CPLib.LRTrim(rwXLS.CODFSC));
      cell = row.createCell(2);
      cell.setCellValue(CPLib.LRTrim(rwXLS.COGNOME));
      cell = row.createCell(3);
      cell.setCellValue(CPLib.LRTrim(rwXLS.NOME));
      cell = row.createCell(4);
      cell.setCellValue(CPLib.LRTrim(rwXLS.SESSO));
      cell = row.createCell(5);
      cell.setCellValue(CPLib.LRTrim(rwXLS.DATNASC));
      cell = row.createCell(6);
      cell.setCellValue(CPLib.LRTrim(rwXLS.NASCOD));
      cell = row.createCell(7);
      cell.setCellValue(CPLib.LRTrim(rwXLS.NASNOM));
      cell = row.createCell(8);
      cell.setCellValue(CPLib.LRTrim(rwXLS.NASPRV));
      cell = row.createCell(9);
      cell.setCellValue(CPLib.LRTrim(rwXLS.CODRIT));
      cell = row.createCell(10);
      cell.setCellValue(CPLib.LRTrim(rwXLS.DESRIT));
      cell = row.createCell(11);
      cell.setCellValue(CPLib.LRTrim(rwXLS.CODFSCAGE));
      cell = row.createCell(12);
      cell.setCellValue(CPLib.LRTrim(rwXLS.COGNOMEAGE));
      cell = row.createCell(13);
      cell.setCellValue(CPLib.LRTrim(rwXLS.NOMEAGE));
      cell = row.createCell(14);
      cell.setCellValue(CPLib.LRTrim(rwXLS.SESSOAGE));
      cell = row.createCell(15);
      cell.setCellValue(CPLib.LRTrim(rwXLS.DATNASCAGE));
      cell = row.createCell(16);
      cell.setCellValue(CPLib.LRTrim(rwXLS.NASNOMAGE));
      cell = row.createCell(17);
      cell.setCellValue(CPLib.LRTrim(rwXLS.NASPRVAGE));
      /* If w_flgexa='S' */
      if (CPLib.eqr(w_flgexa,"S")) {
        // Scrive Dati Aggiuntivi
        cell = row.createCell(18);
        cell.setCellValue(CPLib.LRTrim(rwXLS.CODFSCAUI));
        cell = row.createCell(19);
        cell.setCellValue(CPLib.LRTrim(rwXLS.COGNOMEAUI));
        cell = row.createCell(20);
        cell.setCellValue(CPLib.LRTrim(rwXLS.NOMEAUI));
        cell = row.createCell(21);
        cell.setCellValue(CPLib.LRTrim(rwXLS.SESSOAUI));
        cell = row.createCell(22);
        cell.setCellValue(CPLib.LRTrim(rwXLS.DATNASCAUI));
        cell = row.createCell(23);
        cell.setCellValue(CPLib.LRTrim(rwXLS.NASNOMAUI));
        cell = row.createCell(24);
        cell.setCellValue(CPLib.LRTrim(rwXLS.NASPRVAUI));
        cell = row.createCell(25);
        cell.setCellValue(CPLib.LRTrim(rwXLS.TIPDOCAUI));
        cell = row.createCell(26);
        cell.setCellValue(CPLib.LRTrim(rwXLS.NUMDOCAUI));
        cell = row.createCell(27);
        cell.setCellValue(CPLib.LRTrim(rwXLS.AUTRILAUI));
      } // End If
      // Porta avanti contatore riga
      r++;
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
    /* If w_flgexa='S' */
    if (CPLib.eqr(w_flgexa,"S")) {
      // Allarga colonne aggiuntive
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
    } // End If
    // scrivo il file di esito
    FileOutputStream fileOut = new FileOutputStream(CPLib.LRTrim(_nfile));
    
    //write this workbook to an Outputstream.
    wb.write(fileOut);
    fileOut.flush();
    fileOut.close();
    /* cRitorno := LRTrim(nomefileimport)+".xlsx" */
    cRitorno = CPLib.LRTrim(nomefileimport)+".xlsx";
  }
  void Page_4() throws Exception {
    /* Formato Excel */
    /* _nfile := LRTrim(gPathDoc)+"/export/"+LRTrim(gAzienda)+"/"+LRTrim(nomefileimport)+".xlsx" */
    _nfile = CPLib.LRTrim(gPathDoc)+"/export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(nomefileimport)+".xlsx";
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
    cell.setCellValue("NDG");
    cell.setCellStyle(cs);
    cell =  row.createCell(1);
    cell.setCellValue("Ragione Sociale");
    cell.setCellStyle(cs);
    cell = row.createCell(2);
    cell.setCellValue("Codice Fiscale");
    cell.setCellStyle(cs);
    cell = row.createCell(3);
    cell.setCellValue("Codice Ricerca");
    cell.setCellStyle(cs);
    cell =  row.createCell(4);
    // Porta avanti contatore riga
    r++;
    /* _conta := 0 */
    _conta = CPLib.Round(0,0);
    for (MemoryCursorRow_mcscartimcf_mcrdef rwScarti : mcScartiFin._iterable_()) {
      /* _conta := _conta + 1 */
      _conta = CPLib.Round(_conta+1,0);
      /* gMsgImp := 'Sto scrivendo la riga n.: '+ LRTrim(Str(_conta,7,0)) + " su " + LRTrim(Str(_contar,7,0)) // Log Elaborazione */
      gMsgImp = "Sto scrivendo la riga n.: "+CPLib.LRTrim(CPLib.Str(_conta,7,0))+" su "+CPLib.LRTrim(CPLib.Str(_contar,7,0));
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      //Creo il record da scrivere
      row = sheet.createRow(r);
      cell = row.createCell(0);
      cell.setCellValue(CPLib.LRTrim(rwScarti.ERCONNES));
      cell = row.createCell(1);
      cell.setCellValue(CPLib.LRTrim(rwScarti.ERRAGSOC));
      cell = row.createCell(2);
      cell.setCellValue(CPLib.LRTrim(rwScarti.ERCODFIS));
      cell = row.createCell(3);
      cell.setCellValue(CPLib.LRTrim(rwScarti.ERDESCRI));
      // Porta avanti contatore riga
      r++;
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
  }
  void Page_5() throws Exception {
    /* Lettura ricevuta */
    /* While not(FileLibMit.Eof(fhand)) */
    while ( ! (FileLibMit.Eof(fhand))) {
      /* riga := FileLibMit.ReadLine(fhand) // Riga file testo */
      riga = FileLibMit.ReadLine(fhand);
      /* If Len(LRTrim(riga)) > 0 */
      if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
        /* _nriga := _nriga + 1 */
        _nriga = CPLib.Round(_nriga+1,0);
        /* _txtstp := '' */
        _txtstp = "";
        /* If Left(riga,1)='A' */
        if (CPLib.eqr(CPLib.Left(riga,1),"A")) {
          /* _tipodoc := Substr(riga,2,1) */
          _tipodoc = CPLib.Substr(riga,2,1);
          /* If Substr(riga,2,1) = '1' */
          if (CPLib.eqr(CPLib.Substr(riga,2,1),"1")) {
            /* If Substr(riga,3,1)='1' */
            if (CPLib.eqr(CPLib.Substr(riga,3,1),"1")) {
              /* _txtstp := _txtstp + "1 - Assenza di errori formali nella comunicazione. Fornitura Accettata" +  NL */
              _txtstp = _txtstp+"1 - Assenza di errori formali nella comunicazione. Fornitura Accettata"+"\n";
              /* gMsgProc := gMsgProc + "1 - Assenza di errori formali nella comunicazione. Fornitura Accettata" +  NL // Log Messaggi */
              gMsgProc = gMsgProc+"1 - Assenza di errori formali nella comunicazione. Fornitura Accettata"+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              /* ElseIf Substr(riga,3,1)='2' */
            } else if (CPLib.eqr(CPLib.Substr(riga,3,1),"2")) {
              /* _txtstp := _txtstp + "2 - Presenza di errori formali nella comunicazione. Fornitura scartata" +  NL */
              _txtstp = _txtstp+"2 - Presenza di errori formali nella comunicazione. Fornitura scartata"+"\n";
              /* gMsgProc := gMsgProc + "2 - Presenza di errori formali nella comunicazione. Fornitura scartata" +  NL // Log Messaggi */
              gMsgProc = gMsgProc+"2 - Presenza di errori formali nella comunicazione. Fornitura scartata"+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            } // End If
            /* If Substr(riga,4,3) <> '000' */
            if (CPLib.ne(CPLib.Substr(riga,4,3),"000")) {
              /* If mcErrori.HasKey(Substr(riga,4,3)) */
              if (mcErrori.HasKey(CPLib.Substr(riga,4,3))) {
                /* mcErrori.GoToKey(Substr(riga,4,3)) */
                mcErrori.GoToKey(CPLib.Substr(riga,4,3));
                /* gMsgProc := gMsgProc + Substr(riga,4,3) + " - " + LRTrim(mcErrori.ERDESCRI) +  NL // Log Messaggi */
                gMsgProc = gMsgProc+CPLib.Substr(riga,4,3)+" - "+CPLib.LRTrim(mcErrori.row.ERDESCRI)+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              } // End If
            } // End If
            /* ElseIf Substr(riga,2,1) = '2' */
          } else if (CPLib.eqr(CPLib.Substr(riga,2,1),"2")) {
            /* If Substr(riga,3,1)='1' */
            if (CPLib.eqr(CPLib.Substr(riga,3,1),"1")) {
              /* _txtstp := _txtstp + "1 - La comunicazione è stata correttamente presentata" +  NL */
              _txtstp = _txtstp+"1 - La comunicazione è stata correttamente presentata"+"\n";
              /* gMsgProc := gMsgProc + "1 - La comunicazione è stata correttamente presentata" +  NL // Log Messaggi */
              gMsgProc = gMsgProc+"1 - La comunicazione è stata correttamente presentata"+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              /* _risultato := Substr(riga,4,3) */
              _risultato = CPLib.Substr(riga,4,3);
              /* _protocollo := Substr(riga,7,24) */
              _protocollo = CPLib.Substr(riga,7,24);
              /* _fileprot := Substr(riga,31,50) */
              _fileprot = CPLib.Substr(riga,31,50);
              /* _descrsid := '' */
              _descrsid = "";
              /* If mcErrori.GoToKey(_risultato) */
              if (mcErrori.GoToKey(_risultato)) {
                /* _descrsid := mcErrori.ERDESCRI */
                _descrsid = mcErrori.row.ERDESCRI;
              } // End If
              /* ElseIf Substr(riga,3,1)='2' */
            } else if (CPLib.eqr(CPLib.Substr(riga,3,1),"2")) {
              /* _txtstp := _txtstp + "2 - La comunicazione è stata completamente scartata" +  NL */
              _txtstp = _txtstp+"2 - La comunicazione è stata completamente scartata"+"\n";
              /* gMsgProc := gMsgProc + "2 - La comunicazione è stata completamente scartata" +  NL // Log Messaggi */
              gMsgProc = gMsgProc+"2 - La comunicazione è stata completamente scartata"+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              /* _risultato := Substr(riga,4,3) */
              _risultato = CPLib.Substr(riga,4,3);
              /* _protocollo := Substr(riga,7,24) */
              _protocollo = CPLib.Substr(riga,7,24);
              /* _fileprot := Substr(riga,31,50) */
              _fileprot = CPLib.Substr(riga,31,50);
              /* _descrsid := '' */
              _descrsid = "";
              /* If mcErrori.GoToKey(_risultato) */
              if (mcErrori.GoToKey(_risultato)) {
                /* _descrsid := mcErrori.ERDESCRI */
                _descrsid = mcErrori.row.ERDESCRI;
              } // End If
            } // End If
            /* gMsgProc := gMsgProc + 'ESITO:'+_risultato + " - " +_descrsid + NL // Log Messaggi */
            gMsgProc = gMsgProc+"ESITO:"+_risultato+" - "+_descrsid+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* gMsgProc := gMsgProc + 'PROTOCOLLO:'+_protocollo + NL // Log Messaggi */
            gMsgProc = gMsgProc+"PROTOCOLLO:"+_protocollo+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* gMsgProc := gMsgProc + 'FILE PROTOCOLLATO:'+_fileprot + NL // Log Messaggi */
            gMsgProc = gMsgProc+"FILE PROTOCOLLATO:"+_fileprot+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* _txtstp := _txtstp + 'ESITO:'+_risultato + " - " +_descrsid + NL */
            _txtstp = _txtstp+"ESITO:"+_risultato+" - "+_descrsid+"\n";
          } // End If
          // * --- Insert into tmp_esitosid from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_esitosid");
          m_cPhName = m_Ctx.GetPhName("tmp_esitosid");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitosid",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_masscf",940,"000001B7")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000001B7(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Year(CPLib.Date()),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_nriga,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_protocollo,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_fileprot,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_txtstp,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("A","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_risultato,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitosid",true);
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
        /* If Left(riga,1)='B' */
        if (CPLib.eqr(CPLib.Left(riga,1),"B")) {
          /* _risultato := Substr(riga,2,3) */
          _risultato = CPLib.Substr(riga,2,3);
          /* _descrsid := '' */
          _descrsid = "";
          /* If mcErrori.GoToKey(_risultato) */
          if (mcErrori.GoToKey(_risultato)) {
            /* _descrsid := mcErrori.ERDESCRI */
            _descrsid = mcErrori.row.ERDESCRI;
          } // End If
          /* If _tipodoc = '1' */
          if (CPLib.eqr(_tipodoc,"1")) {
            /* _txtstp := 'N. Record: '+Substr(riga,2,10) +" - Tipo Riga: "+Substr(riga,11,1)+' - Posizione:'+Substr(riga,12,3) */
            _txtstp = "N. Record: "+CPLib.Substr(riga,2,10)+" - Tipo Riga: "+CPLib.Substr(riga,11,1)+" - Posizione:"+CPLib.Substr(riga,12,3);
            /* gMsgImp := 'N. Record: '+Substr(riga,2,10) +" - Tipo Riga: "+Substr(riga,11,1)+' - Posizione:'+Substr(riga,12,3) // Messaggio Import */
            gMsgImp = "N. Record: "+CPLib.Substr(riga,2,10)+" - Tipo Riga: "+CPLib.Substr(riga,11,1)+" - Posizione:"+CPLib.Substr(riga,12,3);
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          } else { // Else
            /* _txtstp := 'N. Record: '+Substr(riga,6,9) +" - Tipo Riga: "+Substr(riga,5,1)+' - Codice campo:'+Substr(riga,30,2)+" - "+LRTrim(_descrsid) */
            _txtstp = "N. Record: "+CPLib.Substr(riga,6,9)+" - Tipo Riga: "+CPLib.Substr(riga,5,1)+" - Codice campo:"+CPLib.Substr(riga,30,2)+" - "+CPLib.LRTrim(_descrsid);
            /* gMsgImp := 'N. Record: '+Substr(riga,6,9) +" - Tipo Riga: "+Substr(riga,5,1)+' - Codice campo:'+Substr(riga,30,2)+" - "+LRTrim(_descrsid) // Messaggio Import */
            gMsgImp = "N. Record: "+CPLib.Substr(riga,6,9)+" - Tipo Riga: "+CPLib.Substr(riga,5,1)+" - Codice campo:"+CPLib.Substr(riga,30,2)+" - "+CPLib.LRTrim(_descrsid);
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          } // End If
          // * --- Insert into tmp_esitosid from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_esitosid");
          m_cPhName = m_Ctx.GetPhName("tmp_esitosid");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitosid",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_masscf",940,"000001C2")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000001C2(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Year(CPLib.Date()),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_nriga,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_protocollo,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_fileprot,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_txtstp,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("B","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_risultato,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitosid",true);
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
      } // End If
    } // End While
    /* cRitorno := 'OK' */
    cRitorno = "OK";
  }
  void Page_6() throws Exception {
    CPResultSet Cursor_qbe_masscf_kersonbo_o=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Legge le operazioni e aggiorna i dati in kersonbo */
      // * --- Select from qbe_masscf_kersonbo_o
      SPBridge.HMCaller _h000001C5;
      _h000001C5 = new SPBridge.HMCaller();
      _h000001C5.Set("m_cVQRList",m_cVQRList);
      _h000001C5.Set("pCONNESCLI",_connes);
      if (Cursor_qbe_masscf_kersonbo_o!=null)
        Cursor_qbe_masscf_kersonbo_o.Close();
      Cursor_qbe_masscf_kersonbo_o = new VQRHolder("qbe_masscf_kersonbo_o",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000001C5,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_masscf_kersonbo_o.Eof())) {
        // * --- Write into kersonbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("kersonbo");
        m_cPhName = m_Ctx.GetPhName("kersonbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"kersonbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_masscf",940,"000001C6")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(CPLib.Substr(riga,239,16),"C",16,0,m_cServer)+", ";
        m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(0,"N",1,0)+", ";
        m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(CPLib.Substr(riga,255,40))+" "+CPLib.LRTrim(CPLib.Substr(riga,295,40)),70),"C",70,0,m_cServer)+", ";
        m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(_dnas,"D",8,0)+", ";
        m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(_nascomun,"C",30,0,m_cServer)+", ";
        m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL((CPLib.eqr(CPLib.Substr(riga,335,1),"M")?"1":"2"),"C",1,0,m_cServer)+", ";
        m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(_nasstato,"C",30,0,m_cServer)+", ";
        m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(CPLib.Substr(riga,295,25),"C",25,0,m_cServer)+", ";
        m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(CPLib.Substr(riga,255,26),"C",26,0,m_cServer)+", ";
        m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(CPLib.Substr(riga,389,2),"C",2,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"kersonbo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_masscf_kersonbo_o.GetString("CONNES"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_masscf_kersonbo_o.GetString("CONNES"))+"";
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
        Cursor_qbe_masscf_kersonbo_o.Next();
      }
      m_cConnectivityError = Cursor_qbe_masscf_kersonbo_o.ErrorMessage();
      Cursor_qbe_masscf_kersonbo_o.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_masscf_kersonbo_o!=null)
          Cursor_qbe_masscf_kersonbo_o.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_w_nomefile,String p_w_flgfam,String p_w_flganf,String p_w_flgant,String p_w_flgxls,String p_w_flgexa,String p_w_flgcst) {
    w_nomefile = p_w_nomefile;
    w_flgfam = p_w_flgfam;
    w_flganf = p_w_flganf;
    w_flgant = p_w_flgant;
    w_flgxls = p_w_flgxls;
    w_flgexa = p_w_flgexa;
    w_flgcst = p_w_flgcst;
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
  public String Run(String p_w_nomefile,String p_w_flgfam,String p_w_flganf,String p_w_flgant,String p_w_flgxls,String p_w_flgexa,String p_w_flgcst) {
    w_nomefile = p_w_nomefile;
    w_flgfam = p_w_flgfam;
    w_flganf = p_w_flganf;
    w_flgant = p_w_flgant;
    w_flgxls = p_w_flgxls;
    w_flgexa = p_w_flgexa;
    w_flgcst = p_w_flgcst;
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
  public static arrt_import_masscfR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_import_masscfR(p_Ctx, p_Caller);
  }
  public static arrt_import_masscfR Make(CPContext p_Ctx) {
    return new arrt_import_masscfR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    w_nomefile = CPLib.Space(80);
    w_flgfam = CPLib.Space(1);
    w_flganf = CPLib.Space(1);
    w_flgant = CPLib.Space(1);
    w_flgxls = CPLib.Space(1);
    w_flgexa = CPLib.Space(1);
    w_flgcst = CPLib.Space(1);
    fhand = CPLib.Space(1);
    riga = "";
    cNumNew = 0;
    cNumMod = 0;
    nomefileimport = CPLib.Space(50);
    nProgImp = 0;
    _connes = CPLib.Space(16);
    _ragsoc = CPLib.Space(70);
    _codfisc = CPLib.Space(16);
    _esito = CPLib.Space(4);
    _cfestero = 0;
    _nprog = CPLib.Space(15);
    _nomefileesi = CPLib.Space(80);
    mcErrori = new MemoryCursor_mcerrmcf_mcrdef();
    mcScarti = new MemoryCursor_mcscartimcf_mcrdef();
    mcScartiFin = new MemoryCursor_mcscartimcf_mcrdef();
    mcXLSIMP = new MemoryCursor_mcxlsritmcf_mcrdef();
    _nfile = CPLib.Space(50);
    _contar = 0;
    _conta = 0;
    _conta2 = 0;
    _dnas = CPLib.NullDate();
    _sesso = CPLib.Space(1);
    _nasstato = CPLib.Space(30);
    _nascomun = CPLib.Space(30);
    _oldcon = CPLib.Space(16);
    _npers = 0;
    _risultato = CPLib.Space(3);
    _protocollo = CPLib.Space(24);
    _fileprot = CPLib.Space(50);
    _descrsid = CPLib.Space(90);
    _tipodoc = CPLib.Space(1);
    _nriga = 0;
    _txtstp = "";
    w_tiporep = 0;
    w_flgwuker = CPLib.Space(1);
    w_flgwrong = CPLib.Space(1);
    w_filexls = CPLib.Space(80);
    w_flgagg = CPLib.Space(1);
    cRitorno = CPLib.Space(80);
    _ndg1 = CPLib.Space(16);
    _cfs1 = CPLib.Space(16);
    _ndg2 = CPLib.Space(16);
    _cfs2 = CPLib.Space(16);
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_masscf_kersonbo_o,
  public static final String m_cVQRList = ",qbe_masscf_kersonbo_o,";
  // ENTITY_BATCHES: ,arfn_dectabs,arfn_exec_sid_sm_ric,arfn_fdatetime,arrt_import_masscf,arrt_storicopers_old,
  public static final String i_InvokedRoutines = ",arfn_dectabs,arfn_exec_sid_sm_ric,arfn_fdatetime,arrt_import_masscf,arrt_storicopers_old,";
  public static String[] m_cRunParameterNames={"w_nomefile","w_flgfam","w_flganf","w_flgant","w_flgxls","w_flgexa","w_flgcst"};
  protected static String GetFieldsName_0000006B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ERCONNES,";
    p_cSql = p_cSql+"ERRAGSOC,";
    p_cSql = p_cSql+"ERCODFISC,";
    p_cSql = p_cSql+"ERCODICE,";
    p_cSql = p_cSql+"ERDESCRI,";
    p_cSql = p_cSql+"ERTESTO,";
    p_cSql = p_cSql+"ERAZIONE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_scarti",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000E9(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"FLGVALIDO,";
    p_cSql = p_cSql+"FLGANAVAL,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000F0(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"FLGVALIDO,";
    p_cSql = p_cSql+"FLGANAVAL,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000FD(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"FLGVALIDO,";
    p_cSql = p_cSql+"FLGANAVAL,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000109(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"FLGVALIDO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000110(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"FLGVALIDO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001B7(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ANNORIF,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"PROTOCOLLO,";
    p_cSql = p_cSql+"FILEPROT,";
    p_cSql = p_cSql+"TXTMSG,";
    p_cSql = p_cSql+"TIPORIGA,";
    p_cSql = p_cSql+"CODERR,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitosid",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001C2(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ANNORIF,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"PROTOCOLLO,";
    p_cSql = p_cSql+"FILEPROT,";
    p_cSql = p_cSql+"TXTMSG,";
    p_cSql = p_cSql+"TIPORIGA,";
    p_cSql = p_cSql+"CODERR,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitosid",true);
    return p_cSql;
  }
}
