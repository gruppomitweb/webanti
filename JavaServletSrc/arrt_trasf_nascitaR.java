// * --- Area Manuale = BO - Header
// * --- arrt_trasf_nascita
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
import com.monitorjbl.xlsx.StreamingReader;
// * --- Fine Area Manuale
public class arrt_trasf_nascitaR implements CallerWithObjs {
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
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_kersonbo;
  public String m_cServer_kersonbo;
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
  public String m_cPhName_tmp_list_imprich;
  public String m_cServer_tmp_list_imprich;
  public String m_cPhName_dersonbo;
  public String m_cServer_dersonbo;
  public String m_cPhName_tbluonas;
  public String m_cServer_tbluonas;
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
  public String _nfile;
  public double _contar;
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
  public double riga_letta;
  public double foglio;
  public String cProgSto;
  public java.sql.Date _data;
  public String _sigla;
  public String gPathApp;
  public String gUrlApp;
  public String gAzienda;
  public String gMsgImp;
  public String gMsgProc;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_trasf_nascita
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
  public arrt_trasf_nascitaR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_trasf_nascita",m_Caller);
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
    m_cPhName_opextrbo = p_ContextObject.GetPhName("opextrbo");
    if (m_cPhName_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_opextrbo = m_cPhName_opextrbo+" "+m_Ctx.GetWritePhName("opextrbo");
    }
    m_cServer_opextrbo = p_ContextObject.GetServer("opextrbo");
    m_cPhName_kersonbo = p_ContextObject.GetPhName("kersonbo");
    if (m_cPhName_kersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_kersonbo = m_cPhName_kersonbo+" "+m_Ctx.GetWritePhName("kersonbo");
    }
    m_cServer_kersonbo = p_ContextObject.GetServer("kersonbo");
    m_cPhName_wersonbo = p_ContextObject.GetPhName("wersonbo");
    if (m_cPhName_wersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo = m_cPhName_wersonbo+" "+m_Ctx.GetWritePhName("wersonbo");
    }
    m_cServer_wersonbo = p_ContextObject.GetServer("wersonbo");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_list_imprich")) {
      m_cPhName_tmp_list_imprich = p_ContextObject.GetPhName("tmp_list_imprich");
      if (m_cPhName_tmp_list_imprich.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_list_imprich = m_cPhName_tmp_list_imprich+" "+m_Ctx.GetWritePhName("tmp_list_imprich");
      }
      m_cServer_tmp_list_imprich = p_ContextObject.GetServer("tmp_list_imprich");
    }
    m_cPhName_dersonbo = p_ContextObject.GetPhName("dersonbo");
    if (m_cPhName_dersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_dersonbo = m_cPhName_dersonbo+" "+m_Ctx.GetWritePhName("dersonbo");
    }
    m_cServer_dersonbo = p_ContextObject.GetServer("dersonbo");
    m_cPhName_tbluonas = p_ContextObject.GetPhName("tbluonas");
    if (m_cPhName_tbluonas.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbluonas = m_cPhName_tbluonas+" "+m_Ctx.GetWritePhName("tbluonas");
    }
    m_cServer_tbluonas = p_ContextObject.GetServer("tbluonas");
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
    if (CPLib.eqr("_conta2",p_cVarName)) {
      return _conta2;
    }
    if (CPLib.eqr("_npers",p_cVarName)) {
      return _npers;
    }
    if (CPLib.eqr("_nriga",p_cVarName)) {
      return _nriga;
    }
    if (CPLib.eqr("riga_letta",p_cVarName)) {
      return riga_letta;
    }
    if (CPLib.eqr("foglio",p_cVarName)) {
      return foglio;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_trasf_nascita";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      return w_nomefile;
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
    if (CPLib.eqr("cProgSto",p_cVarName)) {
      return cProgSto;
    }
    if (CPLib.eqr("_sigla",p_cVarName)) {
      return _sigla;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
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
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_dnas",p_cVarName)) {
      return _dnas;
    }
    if (CPLib.eqr("_data",p_cVarName)) {
      return _data;
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
    if (CPLib.eqr("riga_letta",p_cVarName)) {
      riga_letta = value;
      return;
    }
    if (CPLib.eqr("foglio",p_cVarName)) {
      foglio = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("nomefile",p_cVarName)) {
      w_nomefile = value;
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
    if (CPLib.eqr("cProgSto",p_cVarName)) {
      cProgSto = value;
      return;
    }
    if (CPLib.eqr("_sigla",p_cVarName)) {
      _sigla = value;
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
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("_dnas",p_cVarName)) {
      _dnas = value;
      return;
    }
    if (CPLib.eqr("_data",p_cVarName)) {
      _data = value;
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
    CPResultSet Read_Cursor=null;
    try {
      /* w_nomefile Char(80) */
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
      /* _nfile Char(50) */
      /* _contar Numeric(7, 0) */
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
      /* riga_letta Numeric(10, 0) */
      /* foglio Numeric(2, 0) // foglio letto */
      /* cProgSto Char(15) */
      /* _data Date */
      /* _sigla Char(4) */
      /* gPathApp Char(80) // Path Applicazione */
      /* gUrlApp Char(80) // Path Applicazione */
      /* gAzienda Char(10) // Azienda */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Log Elaborazione */
      // * --- Drop temporary table tmp_list_imprich
      if (m_Ctx.IsSharedTemp("tmp_list_imprich")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_list_imprich")) {
          m_cServer = m_Ctx.GetServer("tmp_list_imprich");
          m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_list_imprich");
      }
      // * --- Create temporary table tmp_list_imprich
      if (m_Ctx.IsSharedTemp("tmp_list_imprich")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_list_imprich")) {
          m_cServer = m_Ctx.GetServer("tmp_list_imprich");
          m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_list_imprich");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_list_imprich");
      if ( ! (m_Ctx.IsSharedTemp("tmp_list_imprich"))) {
        m_cServer = m_Ctx.GetServer("tmp_list_imprich");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_list_imprich",m_cServer,"proto")),m_cPhName,"tmp_list_imprich",m_Ctx);
      }
      m_cPhName_tmp_list_imprich = m_cPhName;
      /* Cicla sul file della lista e lancia la pagina appropriata */
      /* gMsgProc := 'Ora Inizio Elaborazione: '+ arfn_fdatetime(DateTime()) + NL // Log Elaborazione */
      gMsgProc = "Ora Inizio Elaborazione: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // Prova
      InputStream is = new FileInputStream(new File(CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(w_nomefile)));
      Workbook workbook = StreamingReader.builder()
              .rowCacheSize(100)    // number of rows to keep in memory (defaults to 10)
              .bufferSize(4096)     // buffer size to use when reading InputStream to file (defaults to 1024)
              .open(is);            // InputStream or File for XLSX file (required)
      Cell cell;
      int cellType;
      String[] colonna = new String[2];
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
      //scorro le colonne
      cell_count=0;
      /* While cell_count < 2 */
      while (CPLib.lt(cell_count,2)) {
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
      /* conta := conta + 1 */
      conta = conta+1;
      /* _sigla := '' */
      _sigla = "";
      // * --- Read from tbluonas
      m_cServer = m_Ctx.GetServer("tbluonas");
      m_cPhName = m_Ctx.GetPhName("tbluonas");
      m_cSql = "";
      m_cSql = m_cSql+"DESCRI="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(colonna[1]),"C",60,0,m_cServer),m_cServer,CPLib.LRTrim(colonna[1]));
      if (m_Ctx.IsSharedTemp("tbluonas")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("SIGLA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        _sigla = Read_Cursor.GetString("SIGLA");
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on tbluonas into routine arrt_trasf_nascita returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        _sigla = "";
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
      /* If Left(_sigla,1)='Z' */
      if (CPLib.eqr(CPLib.Left(_sigla,1),"Z")) {
        // * --- Write into dersonbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("dersonbo");
        m_cPhName = m_Ctx.GetPhName("dersonbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"dersonbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_nascita",990,"0000003D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(colonna[1]),30),"C",60,0,m_cServer)+", ";
        m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL("","C",60,0,m_cServer)+", ";
        m_cSql = m_cSql+"LUOGONAS = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(colonna[1]),50),"C",50,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"dersonbo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"NASSTATO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(colonna[0]),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(colonna[0]))+"";
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
        // * --- Write into dersonbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("dersonbo");
        m_cPhName = m_Ctx.GetPhName("dersonbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"dersonbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_nascita",990,"0000003E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(colonna[1]),30),"C",60,0,m_cServer)+", ";
        m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL("","C",60,0,m_cServer)+", ";
        m_cSql = m_cSql+"LUOGONAS = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(colonna[1]),50),"C",50,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"dersonbo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"NASCOMUN = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(colonna[0]),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(colonna[0]))+"";
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
      // Chiude i cicli
        }
      }
      workbook.close();
      /* gMsgImp := 'Elaborazione Terminata.' // Messaggio Import */
      gMsgImp = "Elaborazione Terminata.";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione: '+ arfn_fdatetime(DateTime()) + NL // Log Elaborazione */
      gMsgProc = gMsgProc+"Ora Fine Elaborazione: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_w_nomefile) {
    w_nomefile = p_w_nomefile;
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
  public String Run(String p_w_nomefile) {
    w_nomefile = p_w_nomefile;
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
  public static arrt_trasf_nascitaR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_trasf_nascitaR(p_Ctx, p_Caller);
  }
  public static arrt_trasf_nascitaR Make(CPContext p_Ctx) {
    return new arrt_trasf_nascitaR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    w_nomefile = CPLib.Space(80);
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
    _nfile = CPLib.Space(50);
    _contar = 0;
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
    riga_letta = 0;
    foglio = 0;
    cProgSto = CPLib.Space(15);
    _data = CPLib.NullDate();
    _sigla = CPLib.Space(4);
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_fdatetime,arrt_trasf_nascita,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,arrt_trasf_nascita,";
  public static String[] m_cRunParameterNames={"w_nomefile"};
}
